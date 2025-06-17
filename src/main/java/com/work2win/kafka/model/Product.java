package com.work2win.kafka.model;
import jakarta.persistence.Entity;
import javax.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue
	int id;
	String name;
	int price;	
	
}