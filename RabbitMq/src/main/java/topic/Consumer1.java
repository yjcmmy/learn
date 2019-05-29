package topic;

import com.rabbitmq.client.*;
import rabbitMqUtil.ConnectionUtil;

import java.io.IOException;

public class Consumer1 {
    private static final String EXCHANGE_NAME="TopicExchange";
    public static void main(String args[]) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("queue1",false,false,false,null);
        //绑定交换机
        //参数3，标记，绑定到交换机时会指定一个标记，只有和它一样的标记的消息才会被消费者受到
        channel.queueBind("queue1",EXCHANGE_NAME,"key.*");
        //如果要接受多个消息，再执行一次即可
        channel.queueBind("queue1",EXCHANGE_NAME,"abc.#");
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
