package com.onlineshop.domain.product;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@DynamicInsert(true)
@DynamicUpdate(true)
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 5868118208960245447L;

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Id
    private Long id;
    private String productId;
    private String categoryId;
    private String author;
    private String publish;
    private String publishTime;
    private String recommendInfo;
    private String info;
    private String name;
    private Double price;
    private Long total;
    private Long sales;
    /**
     * 创建日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.sql.Timestamp createdTime;

}
