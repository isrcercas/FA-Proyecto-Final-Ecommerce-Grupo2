package com.grupo2.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "detalle_compras")
public class Detalle_Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cantidad;
    private Double precioUnitario;
    private Double descuentoCompra;
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Detalle_Compra() {
    }

    public Detalle_Compra(Long cantidad, Double precioUnitario, Double descuentoCompra, Compra compra, Producto producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuentoCompra = descuentoCompra;
        this.compra = compra;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getDescuentoCompra() {
        return descuentoCompra;
    }

    public void setDescuentoCompra(Double descuentoCompra) {
        this.descuentoCompra = descuentoCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Detalle_Compra{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", descuentoCompra=" + descuentoCompra +
                ", compra=" + compra +
                ", producto=" + producto +
                '}';
    }
}