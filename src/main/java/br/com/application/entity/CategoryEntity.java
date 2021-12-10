package br.com.application.entity;


import br.com.application.enums.OrderStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;



    private  UserEntity user;

    public CategoryEntity(){

    }

    public CategoryEntity(Integer id, String name){
        this.id = id;
        this.user = user;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoment() {
        return name;
    }

    public void setMoment(String name) {
        this.name = name;
    }


     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
