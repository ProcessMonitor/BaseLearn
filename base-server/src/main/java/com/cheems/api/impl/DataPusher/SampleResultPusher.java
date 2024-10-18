package com.cheems.api.impl.DataPusher;


import com.cheems.api.DataPusher;
import com.cheems.baseapi.shanghai.LongHuaResultDto;
import com.swak.frame.dto.Response;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class SampleResultPusher implements DataPusher<LongHuaResultDto> {
    @Override
    public CompletableFuture<Response<String>> push(LongHuaResultDto data) {
        return null;
//        return CompletableFuture.supplyAsync(() -> httpSampleResult(data));
    }
}
