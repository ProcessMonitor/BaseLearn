package com.cheems.basemessage.broker;


import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
public class rabbitSenderTest {

    public final static String QUEUE_NAME = "Hello";

public static void main(String[] args) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();

    // 使用默认配置连接本地RabbitMQ
    factory.setHost("172.16.24.128");        // 或 "127.0.0.1"
    factory.setPort(5672);               // RabbitMQ默认端口
//    factory.setUsername("guest");        // 默认用户名
//    factory.setPassword("guest");        // 默认密码
//    factory.setVirtualHost("/");         // 默认虚拟主机

    try {
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";

        // 给message 加一个时间戳
        message += " " + System.currentTimeMillis();

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        // 关闭连接
        channel.close();
        connection.close();
    } catch (Exception e) {
        System.err.println("连接RabbitMQ失败: " + e.getMessage());
        e.printStackTrace();
    }
}





}
