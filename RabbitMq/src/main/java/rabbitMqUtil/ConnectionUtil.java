package rabbitMqUtil;

import com.rabbitmq.client.ConnectionFactory;
import  com.rabbitmq.client.Connection;

public class ConnectionUtil {
    public static Connection getConnection() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/yjchost");
        connectionFactory.setUsername("yjc");
        connectionFactory.setPassword("123456");
        com.rabbitmq.client.Connection connection=null;
        try {
            connection=connectionFactory.newConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String args[]){
        Connection connection = ConnectionUtil.getConnection();
        System.out.println(connection.toString());
    }
}
