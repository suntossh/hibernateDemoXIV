package com.suntossh.data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.suntossh.data.entities.Account;
import com.suntossh.data.entities.Address;
import com.suntossh.data.entities.Bank;
import com.suntossh.data.entities.Credential;
import com.suntossh.data.entities.TimeTest;
import com.suntossh.data.entities.User;

public class Application {
	
	

	
	public static void main_for_Uni_OneToMany(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Account account = new Account();
		
			account.setName("Santosh");
			account.setCloseDate(new Date());
			account.setCreatedBy("Santosh Created by");
			account.setCreatedDate(new Date());
			account.setCurrentBalance(new BigDecimal(1000000.00));
			account.setInitialBalance(new BigDecimal(10000.00));
			account.setLastUpdatedBy("Santosh Last UpdBy");
			account.setLastUpdatedDate(new Date());
			account.setOpenDate(new Date());
		
		com.suntossh.data.entities.Transaction beltPurchase = new com.suntossh.data.entities.Transaction();
			beltPurchase.setAmount(new BigDecimal("50.00"));
			beltPurchase.setTitle("Belt");
			beltPurchase.setClosingBalance(new BigDecimal("0.00"));
			beltPurchase.setCreatedBy("Kevin Bowersox");
			beltPurchase.setCreatedDate(new Date());
			beltPurchase.setInitialBalance(new BigDecimal("0.00"));
			beltPurchase.setLastUpdatedBy("Kevin Bowersox");
			beltPurchase.setLastUpdatedDate(new Date());
			beltPurchase.setNotes("New Dress Belt");
			beltPurchase.setTransactionType("Debit");

		com.suntossh.data.entities.Transaction shoePurchase = new com.suntossh.data.entities.Transaction();
			shoePurchase.setAmount(new BigDecimal("100.00"));
			shoePurchase.setTitle("Shoes");
			shoePurchase.setClosingBalance(new BigDecimal("0.00"));
			shoePurchase.setCreatedBy("Kevin Bowersox");
			shoePurchase.setCreatedDate(new Date());
			shoePurchase.setInitialBalance(new BigDecimal("0.00"));
			shoePurchase.setLastUpdatedBy("Kevin Bowersox");
			shoePurchase.setLastUpdatedDate(new Date());
			shoePurchase.setNotes("Nice Pair of Shoes");
			shoePurchase.setTransactionType("Debit");

		account.getTransactions().add(shoePurchase);
		account.getTransactions().add(beltPurchase);
		
		
			
		session.save(account);	
		
		transaction.commit();

		
		session.close();
	}
	
	public static Date getMyBirthDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,1984);
		calendar.set(Calendar.MONTH,6);
		calendar.set(Calendar.DATE,22);
		return calendar.getTime();
		
	}
	
	public static void main(String[] args) {

		for(int i=0; i< 1; i++){
			new Thread(new Runnable() {
				
				public void run() {
					main_for_Uni_OneToMany(null);
					
				}
			}).start();
		}
		
	}
	
}
