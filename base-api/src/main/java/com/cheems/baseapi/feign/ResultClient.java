package com.cheems.baseapi.feign;



public interface ResultClient {
    /**
     * 接收回传结果（源于LIMS）
     * @param requests {@link LisTestMainRequest}
     * @return
     */
//    @RequestMapping(value = "/jianyan/middle/result/receive", method = RequestMethod.POST)
//    Response<?> receiveLimsResult(@RequestBody List<LisTestMainRequest> requests);

    /**
     * 结果召回
     * @param request {@link CallbackResultRequest}
     * @return
     */
//    @RequestMapping(value = "/jianyan/middle/result/callback", method = RequestMethod.POST)
//    Response<?> callbackResult(@RequestBody CallbackResultRequest request);
}
