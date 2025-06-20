package com.grupo2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table (name = "usuarios")
public class Usuario {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
@Column (nullable = false)
    private String nombreUsuario;
    private String password;
    private String email;
    private String direccion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Compra> compras = new ArrayList<>();


}
