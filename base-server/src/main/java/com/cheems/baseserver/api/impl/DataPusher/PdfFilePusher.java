package com.cheems.baseserver.api.impl.DataPusher;

import com.cheems.baseserver.api.DataPusher;
import com.cheems.baseapi.shanghai.LongHuaPdfFilePushDto;
import com.swak.frame.dto.Response;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PdfFilePusher implements DataPusher<LongHuaPdfFilePushDto> {
    @Override
    public CompletableFuture<Response<String>> push(LongHuaPdfFilePushDto data) {
//        return CompletableFuture.supplyAsync(() -> httpPdfPusher(data));
        return null;
    }
}
