package hyman.study.mq.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessageListener implements MessageListener {
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try{
			System.out.println("QueueMessageListener监听到了文本消息 "+textMessage.getText());
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
