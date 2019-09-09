package io.nebula.account.mapper;

import io.nebula.account.dto.TransferDto;
import io.nebula.account.model.Account;
import io.nebula.kernel.mapper.MpBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xubulong
 * @since 2019-08-22
 */
@Mapper
public interface AccountMapper extends MpBaseMapper<Account> {

    int transfer(TransferDto transferDto);
}
