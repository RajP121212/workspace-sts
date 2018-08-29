package com.suraj.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.stock.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
