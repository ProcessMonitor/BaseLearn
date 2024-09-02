import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest {


    /**
     * 测试异步操作
     */
    @Test
    void ASyncTestFunc() {

        CompletableFuture.runAsync(() -> {
            System.out.println("hello world");

            for (int i = 0; i < 100; i++){
                System.out.print(i + " ");
            }
        }).join();

        CompletableFuture.runAsync(() -> {
            System.out.println("=====================");
            for (int i = 100; i < 200; i++) {
                System.out.print(i + " ");
            }
        }).join();


    }

    /**
     * 链式异步操作
     */
    @Test
    void LinkedAsyncOpration() {
        String str = "hello world";
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> str.replace(" ", ""))
            .thenCombine(CompletableFuture.supplyAsync(() -> str.replaceAll("hello", ""))
            , (a, b) -> a.toUpperCase() + b.toUpperCase()).thenAccept(System.out::println);
        try {
            voidCompletableFuture.get(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
