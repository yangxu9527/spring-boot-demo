package com.bailiny.tx;

import com.bailiny.tx.entity.User2;
import com.bailiny.tx.repository.User2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang Xu
 * @date 2020/9/24 14:59
 * @description:
 */
@Service
public class User2Service {
    @Autowired
    private User2Repository user2Repository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void add(User2 user) {
        user2Repository.save(user);
    }

    //    @Transactional(propagation = Propagation.REQUIRED)
    public void addException(User2 user) {
        user2Repository.save(user);
        throw new RuntimeException();
    }
}
