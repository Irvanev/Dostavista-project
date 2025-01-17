package com.delivery.mainservice.models.entities;

import com.delivery.mainservice.models.enums.OrderStatusEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Orders extends BaseEntity {
    private Customers customerId;
    private int price;
    private String pickupAddress;
    private String deliveryAddress;
    private String description;
    private String weight;
    private OrderStatusEnum status;
    private Date createdAt;

    protected Orders() {}

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Enumerated(EnumType.STRING)
    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
