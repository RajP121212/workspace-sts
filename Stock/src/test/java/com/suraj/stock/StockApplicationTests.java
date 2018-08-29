package com.suraj.stock;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.suraj.stock.entities.Stock;
import com.suraj.stock.repository.StockRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockApplicationTests {

	@Autowired
	private StockRepository stockRepository;

	//@Before @After annotations 
	//Run before and after every test METHOD in the class
	
	@Before
	public void before() {
		System.out.println("Before");
	}
	
	@After
	public void after() {
		System.out.println("After");
	}
	
	//@BeforeClass @AfterClass annotations 
	//Static methods which are executed once before and after a test CLASS
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
	
	//

	@Test
	public void insertStockRecord() {
		
		Stock stock = new Stock();
		stock.setStockName("Google");
		stock.setStockQuantity("100");
		
		stockRepository.save(stock);
		
	}

}
