package com.cheems.api.impl.DataPusher;

import com.cheems.api.DataPusher;
import com.cheems.baseapi.shanghai.LongHuaPdfFilePushDto;
import com.swak.frame.dto.Response;

import java.util.concurrent.CompletableFuture;

public class PdfFilePusher implements DataPusher<LongHuaPdfFilePushDto> {
    @Override
    public CompletableFuture<Response<String>> push(LongHuaPdfFilePushDto data) {
//        return CompletableFuture.supplyAsync(() -> httpPdfPusher(data));
        return null;
    }
}
