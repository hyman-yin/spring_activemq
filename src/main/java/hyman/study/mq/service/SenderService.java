package hyman.study.mq.service;

import javax.jms.Destination;

public interface SenderService {
	public void sendMessage(Destination destination,final String msg);
	public void sendMessage(final String msg);
}
