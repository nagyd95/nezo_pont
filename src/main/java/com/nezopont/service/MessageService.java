package com.nezopont.service;

import com.nezopont.entity.Message;
import com.nezopont.repository.MessageReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageReposit messageReposit;

    @Autowired
    public void setService(MessageReposit messageReposit) {
        this.messageReposit = messageReposit;
    }
    public List<Message> findAllCategory(){
        return messageReposit.findAll();
    }
}
