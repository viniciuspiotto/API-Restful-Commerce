package com.piotto.apiproduct.resources;

import com.piotto.apiproduct.domain.Client;
import com.piotto.apiproduct.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getOne(@PathVariable Integer id) {
        Client obj = clientService.findOne(id);
        return ResponseEntity.ok().body(obj);
    }
}
