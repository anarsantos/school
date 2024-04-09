package tech.ada.school.service;

import tech.ada.school.domain.dto.v1.ProfessorDto;

import java.util.List;
public interface IProfessorService {
    int criarProfessor(String nome);
    List<ProfessorDto> listarProfessores();
    ProfessorDto buscarProfessor(int id);
    void atualizarProfessor(int id, String nome);
}
