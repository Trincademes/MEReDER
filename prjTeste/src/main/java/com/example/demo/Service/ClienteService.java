package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.ClienteEntities;
import com.example.demo.Repositories.ClienteRepository;


@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public ClienteEntities saveClienteEntities( ClienteEntities clienteEntities) {
		return clienteRepository.save( clienteEntities);
	}

	public List<ClienteEntities> getAllClienteEntities() {
		return clienteRepository.findAll();
	}

	public ClienteEntities getClienteEntitiesById(Long id) {
		return clienteRepository.findById(id).orElse(null);

	}

	public void deleteClienteEntities(long id) {
		clienteRepository.deleteById(id);

	}

	public ClienteEntities updateClienteEntities(Long id, ClienteEntities novoClienteEntities) {
		Optional<ClienteEntities> ClienteEntitiesOptional = clienteRepository.findById(id);
		if (ClienteEntitiesOptional.isPresent()) {
			ClienteEntities ClienteEntitiesExistente = ClienteEntitiesOptional.get();
			ClienteEntitiesExistente.setNome(novoClienteEntities.getNome());
			ClienteEntitiesExistente.setEmail(novoClienteEntities.getEmail());
			return clienteRepository.save(ClienteEntitiesExistente);
		} else {
			return null;
		}
	}

}
