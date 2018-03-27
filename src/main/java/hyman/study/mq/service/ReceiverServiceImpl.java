package hyman.study.mq.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("receiverService")
public class ReceiverServiceImpl implements ReceiverService {
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Override
	public TextMessage receive(Destination destination) {
		TextMessage message = (TextMessage)jmsTemplate.receive(destination);
		
		try {
			System.out.println("从队列 "+destination.toString()+" 接收到消息 <-----"+message.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}

}
