package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")

public class Pedido {
	
		

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;

			private String numero;
			
			private String valor;
			
			
			

			public String getNome() {
				return n
			}

			public void setNome(String numero) {
				this.numero = numero;
			}

			public String getEmail() {
				return valor;
			}

			public void setEmail(String valor) {
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			
		}