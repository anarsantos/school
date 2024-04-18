package tech.ada.school.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gerador automático
    private int id;
    @Column(name = "nome_completo")
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String eMail; //vai ficar E_MAIL
    @CreationTimestamp
    private Instant createdAt;
}
