package com.nezopont.service;

import com.nezopont.entity.Message;
import com.nezopont.repository.MessageReposit;
import com.nezopont.web.DTO.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageReposit messageReposit;

    @Autowired
    public void setService(MessageReposit messageReposit) {
        this.messageReposit = messageReposit;
    }
    public List<Message> findAllCategory(){
        return messageReposit.findAll();
    }
    public Message save(MessageDTO messageDTO){
        Message message=new Message();
        message.setName(messageDTO.getName());
        message.setMsg(messageDTO.getMsg());
        return messageReposit.save(message);
    }
}
