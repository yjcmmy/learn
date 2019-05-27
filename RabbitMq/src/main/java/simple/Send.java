package simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMqUtil.ConnectionUtil;

public class Send {
    public static String QueueName="FirstQueue";
    public static void main(String args[]) throws Exception{
        Connection connection= ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //参数2：是否持久化，rabbit重启后是否保存
        //参数3：是否排外，两个作用，一是连接关闭后是否自动删除队列，二是是否私有当前队列，如果私有了，那么其他通道不可以访问
        //参数4：是否自动删除
        channel.queueDeclare(QueueName,false,false,false,null);

        for(int i=0;i<100;i++){
            String msg="hello simple"+i;
            channel.basicPublish("",QueueName,null,msg.getBytes());
            System.out.println("sent msg: "+msg);
        }
        channel.close();
        connection.close();
    }
}
