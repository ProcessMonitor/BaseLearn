package com.cheems.baseserver.chain;


import com.cheems.baseserver.dto.ApplyDto;

/**
 * logic chain base class
 *
 * @author cheems
 * @date 2024/12/03
 */
public abstract class BaseCommandChain<T, R> {
    public BaseCommandChain<T, R> nextChainHandler;

    public void setNextChainHandler(BaseCommandChain nextChainHandler) {
        this.nextChainHandler = nextChainHandler;
    }

    public boolean hasNext() {
        return this.nextChainHandler != null;
    }

    /**
     * next chain handler
     */
    public R handle(T data) {
        if (hasNext()) {
            return nextChainHandler.handle(data);
        }
        return null;
    }

}
