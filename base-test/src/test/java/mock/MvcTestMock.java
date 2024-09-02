package mock;

import dto.MockDemoDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import service.MockDemoService;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MvcTestMock {

    @Test
    public void MockTest() {

        // 初始化Dto测试实例
        MockDemoDto mockDto = mock(MockDemoDto.class);

        // 使用 mockito 对 getDemoStatus 方法打桩
        when(mockDto.getDemoStatus()).thenReturn(1);

        // 调用 mock 对象的 getDemoStatus 方法，结果永远是 1
        Assert.assertEquals(1, mockDto.getDemoStatus());

        // mock DemoService
        MockDemoService mockDemoService = new MockDemoService(mockDto);
        Assert.assertEquals(1, mockDemoService.getDemoStatus());

    }
    @Test
    public void mockInterfaceTest() {
        List mockList = mock(List.class);

        // 接口的默认值：和类方法一致，都是默认返回值
        Assert.assertEquals(0, mockList.size());
        Assert.assertEquals(null, mockList.get(0));

        // 注意：调用 mock 对象的写方法，是没有效果的
        mockList.add("a");
        Assert.assertEquals(0, mockList.size());      // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals(null, mockList.get(0));   // 没有指定 get(0) 返回值，这里结果是默认值

        // mock值测试
        when(mockList.get(0)).thenReturn("a");          // 指定 get(0)时返回 a
        Assert.assertEquals(0, mockList.size());        // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals("a", mockList.get(0));      // 因为上面指定了 get(0) 返回 a，所以这里会返回 a
        Assert.assertEquals(null, mockList.get(1));     // 没有指定 get(1) 返回值，这里结果是默认值
    }
}
