package com.xkami.model.repository;

import com.xkami.model.Message;
import com.xkami.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface MessageDao extends CrudRepository<Message,Long>{
    Message save(Message message);
    Long countAllByUserAndState(User user, byte state);
    List<Message> findAllByUserAndState(User user, byte state, Pageable pageable);
    Message findById(Long id);
}
