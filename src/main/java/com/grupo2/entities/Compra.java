package com.grupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private java.time.LocalDate fechaDeCompra;
    private Double total;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Compra() {
    }

    public Compra(LocalDate fechaDeCompra, Double total, Usuario usuario) {
        this.fechaDeCompra = fechaDeCompra;
        this.total = total;
        this.usuario = usuario;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDate fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fechaDeCompra=" + fechaDeCompra +
                ", total=" + total +
                ", usuario=" + usuario +

                '}';
    }
}