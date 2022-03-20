package xyz.codeiwthcami.taxi24.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "riders")
public class Rider extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    private String email;


}
