package br.izabel.library.service;

import br.izabel.library.domain.Membro;
import br.izabel.library.repository.MembroRepository;
import br.izabel.library.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public Membro insert(Membro obj) {
        obj.setNumMembro(null);
        obj = membroRepository.save(obj);
        return obj;
    }

    public Membro find(Integer id) {
        Optional<Membro> obj = membroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Membro.class.getName()));
    }

    public List<Membro> findAll(){
        return membroRepository.findAll();
    }
}
