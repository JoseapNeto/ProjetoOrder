package br.com.application.entity;


import br.com.application.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String moment;
    private Integer status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  UserEntity user;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItemEntity> orderItemEntity = new HashSet<>();

    public OrderEntity(){

    }

    public OrderEntity(Integer id, String moment, OrderStatus status, UserEntity user){
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.user = user;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String name) {
        this.moment = name;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if(status != null) {
            this.status = status.getCode();
        }
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<OrderItemEntity> getItems(){
        return orderItemEntity;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
