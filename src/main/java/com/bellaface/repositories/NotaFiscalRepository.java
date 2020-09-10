package com.bellaface.repositories;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.bellaface.entities.NotaFiscal;
import com.bellaface.entities.NotaFiscalItem;

@Service
public class NotaFiscalRepository  {
	
	  @PersistenceContext
	  private EntityManager entityManager;
	
	public NotaFiscal buscarDadosNotaFiscal(Integer idOrder) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT product.id, order_product.order_id, product.name, product.description, order_product.quantity, bellaface.order.created_at, product.price, bellaface.order.total_order, bellaface.order.comments " );
		sql.append(" FROM bellaface.order  " );
		sql.append(" INNER JOIN order_product  " );
		sql.append(" ON bellaface.order.id = order_product.order_id  " );
		sql.append(" INNER JOIN product  " );
		sql.append(" ON product.id = order_product.product_id  " );
		sql.append(" WHERE bellaface.order.id = :orderId  " );
		sql.append(" ORDER BY order_product.order_id ASC  " );
		
		
		Query query = entityManager.createNativeQuery(sql.toString());
		
		query.setParameter("orderId", idOrder);
		
		List<Object[]>  listaDeDados = query.getResultList();
		
		NotaFiscal notaFiscal = new NotaFiscal();
		List<NotaFiscalItem> notaFiscalItemList = new ArrayList<NotaFiscalItem>();
		for(Object[] dadoDaNotaEDoItem: listaDeDados) {
			
			notaFiscalItemList.add(new NotaFiscalItem((Integer) dadoDaNotaEDoItem[0], (String) dadoDaNotaEDoItem[2], (String) dadoDaNotaEDoItem[3],
					(Integer) dadoDaNotaEDoItem[4], (BigDecimal) dadoDaNotaEDoItem[6],(BigDecimal) dadoDaNotaEDoItem[7]));
			
			notaFiscal.setIdOrder((Integer) dadoDaNotaEDoItem[0]);
			notaFiscal.setDataVenda((Date) dadoDaNotaEDoItem[5] );
			notaFiscal.setValorTotal((BigDecimal) dadoDaNotaEDoItem[7]);
			notaFiscal.setComments((String) dadoDaNotaEDoItem[8]);
			

		}
		
		//coloca a lista de itens na NF
		notaFiscal.setItemList(notaFiscalItemList);
		
		
		return notaFiscal;
		
	}

}
