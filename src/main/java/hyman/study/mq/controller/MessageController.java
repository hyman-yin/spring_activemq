package hyman.study.mq.controller;

import javax.annotation.Resource;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hyman.study.mq.service.ReceiverService;
import hyman.study.mq.service.SenderService;

@Controller
@RequestMapping("/test")
public class MessageController {
	@Resource(name="demoQueueDestination")
	private ActiveMQQueue queueDestination;
	
	@Resource(name="senderService")
	private SenderService senderService;
	
	@Resource(name="receiverService")
	private ReceiverService receiverService;
	
	@RequestMapping(value="/send",method=RequestMethod.POST)
	@ResponseBody
	public void send(String msg){
		senderService.sendMessage(msg);
	}
	
	@RequestMapping(value="/receive",method=RequestMethod.GET)
	@ResponseBody
	public Object receive(){
		TextMessage message = receiverService.receive(queueDestination);
		return message;
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "test message";
	}
}
