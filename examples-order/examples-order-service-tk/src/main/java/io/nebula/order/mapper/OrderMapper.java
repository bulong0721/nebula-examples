package io.nebula.order.mapper;

import io.nebula.kernel.mapper.TkBaseMapper;
import io.nebula.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends TkBaseMapper<Order> {
}
