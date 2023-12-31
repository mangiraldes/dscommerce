package br.com.mangiraldes.dscommerce.entities;

import jakarta.persistence.*;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_payment")
public class Payment {

    @OneToOne
    @MapsId
    private Order order;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public Payment(Order order, Long id, Instant moment) {
        this.order = order;
        this.id = id;
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
