package com.bellaface.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bellaface.entities.NotaFiscal;
import com.bellaface.entities.Order;
import com.bellaface.entities.OrderProduct;
import com.bellaface.entities.OrderProductPk;
import com.bellaface.entities.Product;
import com.bellaface.exceptions.BusinessException;
import com.bellaface.repositories.NotaFiscalRepository;
import com.bellaface.repositories.OrderRepository;
import com.bellaface.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository produtoRepository;

	@Autowired
	private OrderProductService orderProductService;

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	public Order insert(Order entity) {

		verificaSeADataAtualEFinalDeSemana();

		entity = repository.save(entity);

		BigDecimal valorTotal = BigDecimal.ZERO;

		Integer quantidadeTotalItens = 0;

		for (Product produto : entity.getListProducts()) {

			// Para não confiar somente nos valores enviados pelo front, recuperar o produto
			// no DB
			Product produtoDB = produtoRepository.findById(produto.getId()).get();

			OrderProductPk orderProductId = new OrderProductPk();
			orderProductId.setOrderId(entity.getId());
			orderProductId.setProductId(produtoDB.getId());

			BigDecimal valorUnitarioTotal = produtoDB.getPrice().multiply(new BigDecimal(produto.getQuantity()));

			orderProductService.salvar(new OrderProduct(orderProductId, produto.getQuantity(), null,
					produtoDB.getPrice(), valorUnitarioTotal));

			quantidadeTotalItens = quantidadeTotalItens + produto.getQuantity();

			valorTotal = valorTotal.add(valorUnitarioTotal);
		}

		valorTotal = corrigeValorMenorQueCem(valorTotal, quantidadeTotalItens);

		entity.setTotalOrder(valorTotal);

		// verificaSeOTotalDaCompraEMenorQueCem(valorTotal);

		return repository.save(entity);
	}

	private void verificaSeADataAtualEFinalDeSemana() {

		Calendar atual = Calendar.getInstance();

		if (atual.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| atual.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {

			throw new BusinessException("Não é possível fazer compras aos finais de semana!");

		}

	}

	private void verificaSeOTotalDaCompraEMenorQueCem(BigDecimal valorTotal) {

		BigDecimal valorReferencia = new BigDecimal("100");

		if (valorTotal.compareTo(valorReferencia) == -1) {

			throw new BusinessException("Não é possível realizar uma compra com valor menor que R$100,00!");
		}
	}

	private BigDecimal corrigeValorMenorQueCem(BigDecimal valorTotal, Integer quantidadeTotalItens) {

		BigDecimal valorMinimoCem = new BigDecimal("100");

		if (valorTotal.compareTo(valorMinimoCem) == -1) {
			return valorMinimoCem;

		} else {

			if (quantidadeTotalItens < 5) {
				valorTotal = valorTotal.multiply(new BigDecimal(0.9));

			} else {
				valorTotal = valorTotal.multiply(new BigDecimal(0.7));
			}
			return valorTotal;
		}
	}

	public NotaFiscal buscarDadosNotaFiscal(Integer idOrder) {

		return notaFiscalRepository.buscarDadosNotaFiscal(idOrder);

	}

}