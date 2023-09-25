package com.pursuit.springclass.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pursuit.springclass.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> orderItems;

    // TODO: Implement relation between Order and Product
//    @JsonIgnore
//    @OneToMany(mappedBy = "order")
//    private List<Product> products;

    public Order() {}

    public Order(Long id, Instant moment, User user, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.user = user;
        this.setOrderStatus(orderStatus);
        this.orderItems = new HashSet<>();
        // this.products = new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public User getUser() {
        return this.user;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.intToEnum(this.orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) this.orderStatus = orderStatus.getCode();
    }

    public Set<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(other == null || this.getClass() != other.getClass()) return false;

        return this.getId().equals(((Order) other).getId());
    }
}
