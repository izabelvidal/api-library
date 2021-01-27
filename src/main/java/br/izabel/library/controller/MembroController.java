package br.izabel.library.controller;

import br.izabel.library.domain.Membro;
import br.izabel.library.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Membro obj = membroService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Membro>> findAll(){
        List<Membro> list = membroService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
