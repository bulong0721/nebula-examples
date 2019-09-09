package io.nebula.order.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/8/20
 */
@Configuration
@MapperScan("io.nebula.*.mapper")
public class TkMapperConfig {

}
