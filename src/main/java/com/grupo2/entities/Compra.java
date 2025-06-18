package com.grupo2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString

@Entity
@Table (name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaDeCompra;
    private Double total;
    @Setter
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    /*
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();
*/
    public Compra() {
    }

    public Compra(Long id, LocalDate fechaDeCompra, Double total, Integer cantidad, Usuario usuario, Producto producto) {
        this.id = id;
        this.fechaDeCompra = fechaDeCompra;
        this.total = total;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.producto = producto;
    }







}