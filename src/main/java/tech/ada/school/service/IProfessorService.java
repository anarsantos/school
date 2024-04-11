package tech.ada.school.service;

import tech.ada.school.domain.dto.v1.ProfessorDto;

import java.util.List;
public interface IProfessorService {
    int criarProfessor(ProfessorDto pedido);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id);

    void atualizarProfessor(int id, ProfessorDto pedido);

    void removerProfessor(int id);
}
