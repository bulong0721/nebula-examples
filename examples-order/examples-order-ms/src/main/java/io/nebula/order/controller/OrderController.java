package io.nebula.order.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.github.pagehelper.PageInfo;
import io.nebula.kernel.exception.BusinessException;
import io.nebula.kernel.exception.FluentException;
import io.nebula.kernel.exchange.*;
import io.nebula.order.model.Order;
import io.nebula.web.controller.BaseController;
import io.nebula.order.model.OrderExample;
import io.nebula.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author NebulaGenerator controller
 * @version V1.0
 * @date 2019-8-22
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/billing")
    public ResponseEntity<Order> billing(String userId, String commodityCd, int count) {
        Order order = orderService.billing(userId, commodityCd, count);
        return StatusCode.OK.build(order);
    }

    @PostMapping("/page")
    public PageableEntity<Order> page(@RequestBody PageRequest<Order> request) {
        OrderExample example = new OrderExample();
        PageInfo<Order> pageInfo = orderService.pageByExample(example, request);
        return TkToolkit.build(pageInfo);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> add(@RequestBody Order order) {
        // 实体校验
        ComplexResult cr = checkAllWithJsr303(order)
                .doValidate()
                .result(ResultCollectors.toComplex());
        // 验证失败
        if (!cr.isSuccess()) {
            throw new FluentException(cr.getErrors());
        }
        if (!orderService.insertUseGeneratedKeys(order)) {
            throw new BusinessException("实体创建失败");
        }
        return StatusCode.OK.build(order);
    }

    @PostMapping("/update")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        // 实体校验
        ComplexResult cr = checkAllWithJsr303(order)
                .doValidate()
                .result(ResultCollectors.toComplex());
        // 验证失败
        if (!cr.isSuccess()) {
            throw new FluentException(cr.getErrors());
        }
        if (!orderService.updateByPKSelective(order)) {
            throw new BusinessException("实体更新失败");
        }
        return StatusCode.OK.build(order);
    }

    @PostMapping("/remove")
    public ResponseEntity<Order> remove(@RequestBody Order order) {
        if (!orderService.deleteByPK(order)) {
            throw new BusinessException("实体删除失败");
        }
        return StatusCode.OK.build(order);
    }
}
