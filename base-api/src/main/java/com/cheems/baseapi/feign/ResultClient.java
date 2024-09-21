package com.cheems.baseapi.feign;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface ResultClient {
    /**
     * 接收回传结果（源于LIMS）
     * @param requests {@link LisTestMainRequest}
     * @return
     */
    @RequestMapping(value = "/jianyan/middle/result/receive", method = RequestMethod.POST)
    Response<?> receiveLimsResult(@RequestBody List<LisTestMainRequest> requests);

    /**
     * 结果召回
     * @param request {@link CallbackResultRequest}
     * @return
     */
    @RequestMapping(value = "/jianyan/middle/result/callback", method = RequestMethod.POST)
    Response<?> callbackResult(@RequestBody CallbackResultRequest request);
}
