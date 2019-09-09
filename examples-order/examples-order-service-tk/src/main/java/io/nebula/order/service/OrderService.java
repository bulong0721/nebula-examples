package io.nebula.order.service;

import io.nebula.kernel.service.TkPageableService;
import io.nebula.order.model.Order;
import io.nebula.order.model.OrderExample;

/**
 * @author NebulaGenerator
 * OrderService接口
 * Created by service-generator on 2019-8-22
 */
public interface OrderService extends TkPageableService<Order, OrderExample> {

    Order billing(String userId, String commodityCd, int count);
}
