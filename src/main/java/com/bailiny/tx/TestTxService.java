package com.bailiny.tx;

import com.bailiny.tx.entity.User1;
import com.bailiny.tx.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yang Xu
 * @date 2020/9/24 15:27
 * @description:
 */
@Service
public class TestTxService {

    @Autowired
    private User1Service user1Service;
    @Autowired
    private User2Service user2Service;

    public void notransaction_exception_required_required() {
        User1 user1 = new User1("张三");
        User2 user2 = new User2("李四");
        user1Service.addRequired(user1);
        user2Service.addRequired(user2);
        throw new RuntimeException();
    }
}
