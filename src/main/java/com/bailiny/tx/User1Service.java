package com.bailiny.tx;

import com.bailiny.tx.entity.User1;
import com.bailiny.tx.repository.User1Repository;
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
public class User1Service {
    @Autowired
    private User1Repository user1Repository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User1 user) {
        user1Repository.save(user);
    }
}
