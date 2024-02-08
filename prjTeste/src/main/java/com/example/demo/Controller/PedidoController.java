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

import com.example.demo.Entities.Pedido;
	import com.example.demo.Service.PedidoService;
	@RestController
	@RequestMapping("/Pedido")
	public class PedidoController {
		
	        @Autowired
			private final PedidoService pedidoService;

			public PedidoController(PedidoService pedidoService) {
				this.pedidoService = pedidoService;
			}
			@GetMapping("/home")
			public String paginainicial() {
				return "index";

			}


			@PostMapping
			public Pedido createPedido(@RequestBody Pedido pedido) {
				return pedidoService.savePedido(pedido);

			}

			@GetMapping("/{id}")
			public ResponseEntity<Pedido> getPedido(@PathVariable Long id) {
				Pedido pedido = pedidoService.getPedidoById(id);
				if (pedido != null) {
					return pedidoService.ok(pedido);
				} else {
					return ResponseEntity.notFound().build();
				}

			}

			
			@DeleteMapping("/{id}")
			public void deletelivro(@PathVariable Long id) {
				pedidoService.deletePedido(id);
			}

			@GetMapping
			public ResponseEntity<List<Pedido>> getAllClienteEntities(RequestEntity<Void> requestEntity) {
				String method = requestEntity.getMethod().name();
				String contentType = requestEntity.getHeaders().getContentType().toString();
				List<Pedido> livro = pedidoService.getAllPedido();
				return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
						.body(livro);
			}

			@PutMapping("/{id}")
			public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
				return pedidoService.updatePedido(id, pedido);
			}
		}

