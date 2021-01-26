package br.izabel.library.service;

import br.izabel.library.domain.Membro;
import br.izabel.library.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public Membro insert(Membro obj) {
        obj.setNumMembro(null);
        obj = membroRepository.save(obj);
        return obj;
    }
}
