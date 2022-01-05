package br.com.application.pk;

import br.com.application.entity.OrderEntity;
import br.com.application.entity.ProductEntity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrdemItemPk implements Serializable {


        @ManyToOne
        @JoinColumn(name = "order_id")
        private OrderEntity order;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private ProductEntity product;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItemPk that = (OrdemItemPk) o;
        return order.equals(that.order) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
