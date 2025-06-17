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
    private LocalDate fechaDeCompra;
    private Double total;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public Compra() {
    }

    public Compra(Long id, LocalDate fechaDeCompra, Double total, Integer cantidad, Usuario usuario, List<Producto> productos) {
        this.id = id;
        this.fechaDeCompra = fechaDeCompra;
        this.total = total;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.productos = productos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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