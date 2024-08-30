import lombok.Data;

public class TestThreadPoolTestClazz {
    // 任务的个数
    private static final int TASK_NUM = 50;

    public static void main(String[] args) {
        ThreadPoolTest myPool = new ThreadPoolTest(3,50);
        for (int i=0;i<TASK_NUM;i++) {
            myPool.execute(new MyTask("task_"+i));
        }

    }


    @Data
    static class MyTask implements Runnable{

        private String name;
        public MyTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("task :"+name+" end...");

        }

    }


}
