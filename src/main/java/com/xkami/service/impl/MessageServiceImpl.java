package com.xkami.service.impl;

import com.xkami.model.Message;
import com.xkami.model.User;
import com.xkami.model.repository.MessageDao;
import com.xkami.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageDao messageDao;

    @Override
    public Message findById(Long id) {
        return messageDao.findById(id);
    }

    @Override
    public List<Message> findAllByUserAndState(User user, byte state, Pageable pageable) {
        return messageDao.findAllByUserAndState(user, state, pageable);
    }

    @Override
    public Long countAllByUserAndState(User user, byte state) {
        return messageDao.countAllByUserAndState(user,state);
    }

    @Override
    public Message save(Message message) {
        return messageDao.save(message);
    }


}
