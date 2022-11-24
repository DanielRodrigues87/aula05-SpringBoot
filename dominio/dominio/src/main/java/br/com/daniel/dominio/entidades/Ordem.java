package br.com.daniel.dominio.entidades;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ordem")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "ordem")
    private List<OrdemItem> items = new ArrayList<>();

    public List<OrdemItem> getItems() {
        return items;
    }

    public Ordem() {
    }

    public Ordem(Long id, Instant moment, OrderStatus status, Cliente cliente) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        double soma = 0.0;
        for (OrdemItem item : items) {
            soma = soma + item.getSubTotal();
        }
        return soma;
    }
}
