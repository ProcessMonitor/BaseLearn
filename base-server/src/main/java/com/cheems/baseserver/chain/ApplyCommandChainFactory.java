package com.cheems.baseserver.chain;

import com.cheems.baseserver.dto.ApplyDto;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Component
public class ApplyCommandChainFactory<T, R> {

    // 初始化指针
    private BaseCommandChain<T, R> first;

    public ApplyCommandChainFactory(List<BaseCommandChain> commandChains) {
        if (!CollectionUtils.isEmpty(commandChains)) {
            for (int i = 0; i < commandChains.size() - 1; i++) {
                commandChains.get(i).setNextChainHandler(commandChains.get(i + 1));
            }
            first = commandChains.get(0);
        }
    }

    /**
     * 执行申请单责任链
     *
     * @param data
     * @return
     */
    public R execute(T data) {
        return first.handle(data);
    }
}
