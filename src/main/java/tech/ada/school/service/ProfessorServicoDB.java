package tech.ada.school.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tech.ada.school.domain.dto.exception.NotFoundException;
import tech.ada.school.domain.dto.v1.ProfessorDto;
import tech.ada.school.domain.entities.Professor;
import tech.ada.school.domain.mappers.ProfessorMapper;
import tech.ada.school.repositories.ProfessorRepository;

import java.util.List;

@Service
@Primary
public class ProfessorServicoDB implements IProfessorService {

    private final ProfessorRepository repositorio;

    public ProfessorServicoDB(ProfessorRepository repositorio) { //construtor
        this.repositorio = repositorio;
    }

    @Override
    public ProfessorDto criarProfessor(ProfessorDto pedido) {

        Professor p = ProfessorMapper.toEntity(pedido);
        return ProfessorMapper.toDto(repositorio.save(p));
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return repositorio.findAll().stream().map(ProfessorMapper::toDto).toList();
    }

    @Override
    public ProfessorDto buscarProfessor(int id) throws NotFoundException {
        return ProfessorMapper.toDto(repositorio
                .findById(id)
                .orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)))
        );
    }

    @Override
    public ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws NotFoundException {
        final Professor p = repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
        p.setCpf(pedido.getCpf()); //só pode atualizar nome, CPF e e-mail.
        p.setNome(pedido.getNome());
        p.setEMail(pedido.getEmail());
        return ProfessorMapper.toDto(repositorio.save(p));
    }

    @Override
    public void removerProfessor(int id) throws NotFoundException {
        final Professor p = repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
        repositorio.delete(p);
        repositorio.deleteById(id);
    }

    @Override
    public ProfessorDto buscarPorCpf(String cpf) throws NotFoundException {
        return ProfessorMapper.toDto(repositorio
                .findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException(Professor.class, cpf))
        );
    }
}
