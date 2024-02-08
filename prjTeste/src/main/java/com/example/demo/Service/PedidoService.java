package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Pedido;
import com.example.demo.Repositories.PedidoRepository;
@Service
public class PedidoService {

	
		private final PedidoRepository pedidoRepository;

		@Autowired
		public PedidoService(PedidoRepository pedidoRepository) {
			this.pedidoRepository = pedidoRepository;
		}

		public Pedido savePedido( Pedido pedido) {
			return pedidoRepository.save( pedido);
		}

		public List<Pedido> getAllPedido() {
			return pedidoRepository.findAll();
		}

		public Pedido getPedidoById(Long id) {
			return pedidoRepository.findById(id).orElse(null);

		}

		public void deletePedido(long id) {
			pedidoRepository.deleteById(id);

		}

		public Pedido updateClienteEntities(Long id, Pedido novoPedido) {
			Optional<Pedido> PedidoOptional = pedidoRepository.findById(id);
			if (PedidoOptional.isPresent()) {
				Pedido PedidoExistente = PedidoOptional.get();
				PedidoExistente.setNumero(novoPedido.getNumero());
				PedidoExistente.setValor(novoPedido.getValor());
				return pedidoRepository.save(PedidoExistente);
			} else {
				return null;
			}
		}

		public ResponseEntity<Pedido> ok(Pedido pedido) {
			// TODO Auto-generated method stub
			return null;
		}

		public Pedido updatePedido(Long id, Pedido pedido) {
			// TODO Auto-generated method stub
			return null;
		}

	}

