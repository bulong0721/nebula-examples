package io.nebula.order.model;

import io.nebula.kernel.entity.BaseEntity;
import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name = "order_tbl")
public class Order extends BaseEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "commodity_code")
    private String commodityCode;

    @Column(name = "count")
    private Integer count;

    @Column(name = "money")
    private Integer money;
}
