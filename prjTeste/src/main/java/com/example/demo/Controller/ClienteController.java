package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.ClienteEntities;
import com.example.demo.Service.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

		@Autowired
		private final ClienteService clienteService;

		public ClienteController(ClienteService clienteService) {
			this.clienteService = clienteService;
		}
		@GetMapping("/home")
		public String paginainicial() {
			return "index";

		}


		@PostMapping
		public ClienteEntities createClienteEntities(@RequestBody ClienteEntities clienteEntities) {
			return clienteEntities.saveClienteEntities(clienteEntities);

		}

		@GetMapping("/{id}")
		public ResponseEntity<ClienteEntities> getClienteEntities(@PathVariable Long id) {
			ClienteEntities clienteEntities = clienteService.getClienteEntitiesById(id);
			if (clienteEntities != null) {
				return ResponseEntity.ok(clienteEntities);
			} else {
				return ResponseEntity.notFound().build();
			}

		}

		
		@DeleteMapping("/{id}")
		public void deletelivro(@PathVariable Long id) {
			clienteService.deleteClienteEntities(id);
		}

		@GetMapping
		public ResponseEntity<List<ClienteEntities>> getAllClienteEntities(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<ClienteEntities> livro = clienteService.getAllClienteEntities();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livro);
		}

		@PutMapping("/{id}")
		public ClienteEntities updateClienteEntities(@PathVariable Long id, @RequestBody ClienteEntities clienteEntities) {
			return clienteService.updateClienteEntities(id, clienteEntities);
		}
	}

