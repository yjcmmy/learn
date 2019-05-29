package spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendTest {
    public static void main(String args[]){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RabbitTemplate template = applicationContext.getBean(RabbitTemplate.class);
        template.convertAndSend("发送一条测试消息");
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

}
