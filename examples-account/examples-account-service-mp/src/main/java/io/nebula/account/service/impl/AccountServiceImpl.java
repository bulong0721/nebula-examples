package io.nebula.account.service.impl;

import io.nebula.account.dto.TransferDto;
import io.nebula.account.mapper.AccountMapper;
import io.nebula.account.model.Account;
import io.nebula.account.service.AccountService;
import io.nebula.kernel.service.impl.MybatisPlusServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xubulong
 * @since 2019-08-22
 */
@Slf4j
@Component
public class AccountServiceImpl extends MybatisPlusServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public int transfer(TransferDto dto) {
        return baseMapper.transfer(dto);
    }
}
