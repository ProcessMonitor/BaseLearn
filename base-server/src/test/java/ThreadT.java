public class ThreadT {
    public synchronized void m1(int i) {
        System.out.println(i + "m1 running...");
//        try {
//            Thread.sleep(300l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(i + "m1 end");
    }

    public synchronized void m2(int i) {
        System.out.println(i + "m2 running...");
        System.out.println(i + "m2 end");
    }

//        public static void main(String[] args) {
//        ThreadT test = new ThreadT();
//        for (int i = 0; i < 10; i++) {
//            try {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        test.m1();
//                    }
//                }).start();
//                Thread.sleep(1000);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        test.m2();
//                    }
//                }).start();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            ThreadT test = new ThreadT();
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.m1(finalI);
                }
            }).start();

            Thread.sleep(1000); // 添加 0-2 毫秒的随机延迟
//            Thread.sleep((long)(Math.random()*2)); // 添加 0-2 毫秒的随机延迟
            int finalI1 = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.m2(finalI1);
                }
            }).start();
        }
    }
}