package hyman.study.mq.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @Desc JMS发送者
 *
 * @author Administrator
 *
 * 2018年3月27日 上午11:12:22
 */
@Service("senderService")
public class SenderServiceImpl implements SenderService {
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMessage(Destination destination, String msg) {
		System.out.println(Thread.currentThread().getName()+" 向队列 "+destination.toString()+" 发送消息------->  "+msg);
		jmsTemplate.send(destination,new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
		
	}

	@Override
	public void sendMessage(String msg) {
		String destination = jmsTemplate.getDefaultDestinationName();
		System.out.println(Thread.currentThread().getName()+" 向队列 "+destination+" 发送消息------->  "+msg);
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
}
