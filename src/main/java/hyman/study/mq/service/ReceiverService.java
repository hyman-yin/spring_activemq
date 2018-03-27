package hyman.study.mq.service;

import javax.jms.Destination;
import javax.jms.TextMessage;

public interface ReceiverService {
	public TextMessage receive(Destination destination);
}
