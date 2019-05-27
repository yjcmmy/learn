package simple;

import com.rabbitmq.client.*;
import rabbitMqUtil.ConnectionUtil;

import java.io.IOException;

public class Consumer {
    public static String QueueName = "FirstQueue";

    public static void main(String args[]) throws Exception {
        final Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QueueName, false, false, false, null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //当我们收到消息时调用
                System.out.println("消费者一收到的消息是：" + new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);  //参数2false为确认收到消息，true为拒绝收到消息
                try {
                    Thread.sleep(50);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        new Thread(new Runnable() {
            public void run() {
                try {
                    final Channel channel2 = connection.createChannel();
                    channel2.queueDeclare(QueueName, false, false, false, null);
                    DefaultConsumer consumer2 = new DefaultConsumer(channel2) {
                        @Override
                        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                            System.out.println("消费者二收到的消息是：" + new String(body));
                            channel2.basicAck(envelope.getDeliveryTag(), false);
                        }
                    };
                    channel2.basicConsume(QueueName, false, consumer2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        //注册消费者，参数二为手动确认，收到消息后需要手动告诉服务器
        channel.basicConsume(QueueName, false, consumer);


    }

}
