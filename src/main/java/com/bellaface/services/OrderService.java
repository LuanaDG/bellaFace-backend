package com.bellaface.services;

import java.math.BigDecimal;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bellaface.entities.Order;
import com.bellaface.entities.OrderProduct;
import com.bellaface.entities.OrderProductPk;
import com.bellaface.entities.Product;
import com.bellaface.exceptions.BusinessException;
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

	
	public Order insert(Order entity) {

		verificaSeADataAtualEFinalDeSemana();

		entity = repository.save(entity);
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (Product produto : entity.getListProducts()) {

			// Para não confiar somente nos valores enviados pelo front, recuperar o produto no DB 
			Product produtoDB = produtoRepository.findById(produto.getId()).get();

			OrderProductPk orderProductId = new OrderProductPk();
			orderProductId.setOrderId(entity.getId());
			orderProductId.setProductId(produtoDB.getId());

			BigDecimal valorUnitarioTotal = produtoDB.getPrice().multiply(new BigDecimal(produto.getQuantity()));

			orderProductService.salvar(new OrderProduct(orderProductId, produto.getQuantity(), null,
					produtoDB.getPrice(), valorUnitarioTotal));
			valorTotal = valorTotal.add(valorUnitarioTotal);
		}

		entity.setTotalOrder(valorTotal);

		return repository.save(entity);
	}

	private void verificaSeADataAtualEFinalDeSemana() {

		Calendar atual = Calendar.getInstance();

		if (atual.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| atual.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {

			throw new BusinessException("Não é possível fazer compras aos finais de semana!");

		}

	}

	
}