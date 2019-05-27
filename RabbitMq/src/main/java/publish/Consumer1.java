package publish;

import com.rabbitmq.client.*;
import rabbitMqUtil.ConnectionUtil;

import java.io.IOException;

public class Consumer1 {
    private static final String EXCHANGE_NAME="FirstExchange";
    public static void main(String args[]) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("queue1",false,false,false,null);
        //绑定交换机
        channel.queueBind("queue1",EXCHANGE_NAME,"");
        channel.basicQos(1);
        DefaultConsumer defaultConsumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1："+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        } ;
        channel.basicConsume("queue1",false,defaultConsumer);

    }
}
