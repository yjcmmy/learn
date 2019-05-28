package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMqUtil.ConnectionUtil;

public class Send {
    private static final String EXCHANGE_NAME="TopicExchange";
    public static void main(String args[]) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //因为消息是先发到交换机中，而交换机是没有保存功能的，所以如果没有消费者，消息会丢失
        channel.basicPublish(EXCHANGE_NAME,"key.1",null,"topic模式的消息1".getBytes());
        channel.basicPublish(EXCHANGE_NAME,"abc.2",null,"路由模式的消息2".getBytes());
        channel.basicPublish(EXCHANGE_NAME,"key.ww",null,"路由模式的消息3".getBytes());
        channel.close();
        connection.close();
    }
}
