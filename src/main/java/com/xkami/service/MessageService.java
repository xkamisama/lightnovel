package com.xkami.service;

import com.xkami.model.Message;
import com.xkami.model.User;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface MessageService {
    Message save(Message message);
    Long countAllByUserAndState(User user, byte state);
    List<Message> findAllByUserAndState(User user, byte state, Pageable pageable);
    Message findById(Long id);
}
