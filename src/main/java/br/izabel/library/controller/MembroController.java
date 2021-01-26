package br.izabel.library.controller;

import br.izabel.library.domain.Membro;
import br.izabel.library.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value= "/membros")
public class MembroController {

    @Autowired
    private MembroService membroService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Membro obj) {
        membroService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getNumMembro()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
