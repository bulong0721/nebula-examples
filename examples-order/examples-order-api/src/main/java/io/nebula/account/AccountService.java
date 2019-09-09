package io.nebula.account;

import io.nebula.kernel.exchange.ResponseEntity;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/1/24
 */
@FeignClient(value = "examples-account-ms")
public interface AccountService {

    @RequestLine("POST /account/transfer")
    @Headers("Content-Type: application/json")
    ResponseEntity<Boolean> transfer(TransferDto transferDto);
}
