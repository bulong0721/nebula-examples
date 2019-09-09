package io.nebula.account;

import lombok.Data;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/8/22
 */
@Data
public class TransferDto {
    private String userId;
    private int money;
}
