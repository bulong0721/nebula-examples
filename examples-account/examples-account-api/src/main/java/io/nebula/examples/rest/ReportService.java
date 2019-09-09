package io.nebula.examples.rest;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = ReportService.SERVICE_NAME, url = "${galaxy.msg.url}")
public interface ReportService {
    String SERVICE_NAME = "report";

    @RequestLine("GET /display/queryBusiness")
    String queryBusiness();
}
