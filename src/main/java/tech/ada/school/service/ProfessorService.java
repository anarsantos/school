package tech.ada.school.service;

import org.springframework.stereotype.Service;
import tech.ada.school.domain.dto.v1.ProfessorDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService implements IProfessorService {
    //base de dados professor
    private final List<ProfessorDto> professores = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarProfessor(String nome) {
        professores.add(new ProfessorDto(id, nome));
        return id++;
    }

    @Override
    public  List<ProfessorDto> listarProfessores() {
        return professores;
    }

    @Override
    public ProfessorDto buscarProfessor(int id) {
        return null;
    }

    @Override
    public void atualizarProfessor(int id, String nome) {

    }
}