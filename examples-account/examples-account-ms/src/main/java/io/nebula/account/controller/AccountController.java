package io.nebula.account.controller;

import io.nebula.account.dto.TransferDto;
import io.nebula.account.model.Account;
import io.nebula.account.service.AccountService;
import io.nebula.kernel.validator.NotBlankValidator;
import io.nebula.web.controller.BaseController;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.nebula.kernel.exception.BusinessException;
import io.nebula.kernel.exception.FluentException;
import io.nebula.kernel.exchange.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xubulong
 * @since 2019-08-22
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/transfer")
    public ResponseEntity<Boolean> account(@RequestBody TransferDto transferDto) {
        ComplexResult cr = checkAllWithJsr303(transferDto)
                .on(transferDto.getUserId(), new NotBlankValidator("userId"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        // 验证失败
        if (!cr.isSuccess()) {
            throw new FluentException(cr.getErrors());
        }

        if (accountService.transfer(transferDto) == 1) {
            return StatusCode.OK.build(true);
        }
        return StatusCode.ServiceException.build(false);
    }

    @PostMapping("/page")
    public PageableEntity<Account> page(@RequestBody PageRequest<Account> request) {
        IPage pager = MpToolkit.toPage(request);
        QueryWrapper<Account> wrapper = MpToolkit.queryWrapper(request);
        IPage<Account> result = accountService.page(pager, wrapper);
        return MpToolkit.build(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Account> add(@RequestBody Account account) {
        // 实体校验
        ComplexResult cr = checkAllWithJsr303(account)
                .doValidate()
                .result(ResultCollectors.toComplex());
        // 验证失败
        if (!cr.isSuccess()) {
            throw new FluentException(cr.getErrors());
        }
        if (!accountService.saveOrUpdate(account)) {
            throw new BusinessException("实体创建失败");
        }
        return StatusCode.OK.build(account);
    }

    @PostMapping("/update")
    public ResponseEntity<Account> update(@RequestBody Account account) {
        // 实体校验
        ComplexResult cr = checkAllWithJsr303(account)
                .doValidate()
                .result(ResultCollectors.toComplex());
        // 验证失败
        if (!cr.isSuccess()) {
            throw new FluentException(cr.getErrors());
        }
        if (!accountService.saveOrUpdate(account)) {
            throw new BusinessException("实体更新失败");
        }
        return StatusCode.OK.build(account);
    }

    @PostMapping("/remove")
    public ResponseEntity<Account> remove(@RequestBody Account account) {
        if (!accountService.remove(MpToolkit.updateWrapper(account))) {
            throw new BusinessException("实体删除失败");
        }
        return StatusCode.OK.build(account);
    }
}
