package be.thomasmore.favorieteteamservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="team")
@Data
@NoArgsConstructor
public class favorieteTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="naam")
    private String naam;
}
