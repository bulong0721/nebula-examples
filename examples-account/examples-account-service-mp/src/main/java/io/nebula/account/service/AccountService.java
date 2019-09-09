package io.nebula.account.service;

import io.nebula.account.dto.TransferDto;
import io.nebula.account.model.Account;
import io.nebula.kernel.service.MybatisPlusService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xubulong
 * @since 2019-08-22
 */
public interface AccountService extends MybatisPlusService<Account> {

    int transfer(TransferDto dto);
}
