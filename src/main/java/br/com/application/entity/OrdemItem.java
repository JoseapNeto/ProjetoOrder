package br.com.application.entity;


import br.com.application.pk.OrdemItemPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrdemItem {

    @EmbeddedId
    private OrdemItemPk id;
    private Integer quantity;
    private Double price;

    public OrdemItem(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }


    public OrderEntity getOrder(){
        return id.getOrder();
    }

    public void setOrder(OrderEntity order){
        id.setOrder(order);
    }


    public ProductEntity getProduct(){
        return id.getProduct();
    }

    public void setProduct(ProductEntity product){
        id.setProduct(product);
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return id.equals(ordemItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
