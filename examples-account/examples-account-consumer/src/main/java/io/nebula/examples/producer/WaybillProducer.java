package io.nebula.examples.producer;

import io.nebula.examples.model.WaybillNoVersion;
import io.nebula.messaging.annotation.Producer;
import io.nebula.messaging.api.MessageSender;
import io.nebula.messaging.support.EDSWrapper;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/1/14
 */
@Producer(topic = "Waybill")
public interface WaybillProducer extends MessageSender<EDSWrapper<WaybillNoVersion>> {
}
