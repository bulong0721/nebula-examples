package io.nebula.order.service.impl;

import io.nebula.account.AccountService;
import io.nebula.account.TransferDto;
import io.nebula.kernel.exception.BusinessException;
import io.nebula.kernel.exchange.ResponseEntity;
import io.nebula.kernel.service.impl.TkMapperServiceImpl;
import io.nebula.order.model.Order;
import io.nebula.order.model.OrderExample;
import io.nebula.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author NebulaGenerator
 * OrderServiceImpl
 * Created by serviceImpl-generator on 2019-8-22
 */
@Slf4j
@Component
public class OrderServiceImpl extends TkMapperServiceImpl<Order, OrderExample> implements OrderService {
    @Autowired
    private AccountService accountService;
    private Random random = new Random();

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-demo-tx")
    @Transactional(rollbackFor = Exception.class)
    public Order billing(String userId, String commodityCd, int count) {
        int money = calculate(commodityCd, count);
        TransferDto dto = new TransferDto();
        dto.setUserId(userId);
        dto.setMoney(money);
        ResponseEntity<Boolean> result = accountService.transfer(dto);
        if (!result.success() || !result.getData()) {
            throw new BusinessException("转账失败");
        }

        final Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCd);
        order.setCount(count);
        order.setMoney(money);
        this.saveOrUpdate(order);

        if (random.nextBoolean()) {
            throw new BusinessException("异常交易");
        }

        return order;
    }

    private int calculate(String commodityCd, int orderCount) {
        return 2 * orderCount;
    }
}
