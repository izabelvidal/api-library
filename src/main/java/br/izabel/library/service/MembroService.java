package br.izabel.library.service;

import br.izabel.library.domain.Membro;
import br.izabel.library.domain.dto.MembroDto;
import br.izabel.library.repository.MembroRepository;
import br.izabel.library.service.exception.DataIntegrityException;
import br.izabel.library.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Membro update(Membro obj) {
        Membro newObj = find(obj.getNumMembro());
        updateData(newObj, obj);
        return membroRepository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            membroRepository.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }

    }

    public Membro fromDto(MembroDto objDto){
        return new Membro(objDto.getNumMembro(), objDto.getNome(), objDto.getIdade());
    }

    private void updateData(Membro newObj, Membro obj) {
        newObj.setNome(obj.getNome());
        newObj.setIdade(obj.getIdade());
    }
}
