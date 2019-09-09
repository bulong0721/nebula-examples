package io.nebula.examples.consumer;

import io.nebula.examples.model.WaybillNoVersion;
import io.nebula.messaging.annotation.Consumer;
import io.nebula.messaging.api.Headers;
import io.nebula.messaging.api.MessageListener;
import io.nebula.messaging.support.EDSWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/1/14
 */
@Slf4j
@Consumer(topic = "Waybill", group = "openPOrderbill1111")
public class WaybillConsumer extends MessageListener<EDSWrapper<WaybillNoVersion>> {

    @Override
    public void onMessage(Headers headers, EDSWrapper<WaybillNoVersion> wrapper) throws Exception {
        log.info("receive message: {}", wrapper.getPayload());
    }
}
