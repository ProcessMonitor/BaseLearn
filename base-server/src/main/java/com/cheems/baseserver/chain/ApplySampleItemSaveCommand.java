package com.cheems.baseserver.chain;

import com.cheems.baseserver.dto.ApplyDto;
import org.springframework.stereotype.Component;

@Component
public class ApplySampleItemSaveCommand extends BaseCommandChain<ApplyDto, Boolean> {

    public Boolean handle(ApplyDto applyDto) {
        System.out.println("save sample item");
        // 业务check  逻辑

        return super.handle(applyDto);
    }

}
