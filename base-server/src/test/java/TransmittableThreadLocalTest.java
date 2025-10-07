import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TransmittableThreadLocalTest {

    TransmittableThreadLocal<String> ttl = new TransmittableThreadLocal<>();

    // 模拟创建一个 容量为2的线程池
    private ExecutorService executorService = Executors.newFixedThreadPool(2);


    ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();

    private HttpServletRequest request = null;

    // 线程池中的线程执行
    void test(HttpServletRequest req) {
        String traceId = req.getHeader("traceId");
        System.out.println("设置主线程 Id :");
        ttl.set(traceId);

        executorService.execute(TtlRunnable.get(() -> {
            String traceId2 = ttl.get();
            System.out.println("子线程中获取到的 traceId :" + traceId2);
        }));

    }

    @BeforeEach
    public void setUp() {
        ttl = new TransmittableThreadLocal<>();
        executorService = Executors.newFixedThreadPool(2);
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getHeader("traceId")).thenReturn("testTraceId");
    }

    @Test
    public void testTTL() throws InterruptedException {
        StringBuilder result = new StringBuilder();
        test(request);
        // 等待子线程执行完成
        Thread.sleep(1000);

        String traceId2 = ttl.get();
        System.out.println("子线程中获取到的 traceId :" + traceId2);
        result.append(traceId2);

        assertEquals("testTraceId", result.toString());
    }
}
