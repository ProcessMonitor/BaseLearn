package com.cheems.api;


import com.swak.frame.dto.Response;

import java.util.concurrent.CompletableFuture;

public interface DataPusher<T>{
    CompletableFuture<Response<String>> push(T data);
}
