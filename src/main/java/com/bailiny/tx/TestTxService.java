package com.bailiny.tx;

import com.bailiny.tx.entity.User1;
import com.bailiny.tx.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /*******************************************************************************************************************
     * REQUIRED
     */
    public void outException() {
        User1 user1 = new User1("张三");
        User2 user2 = new User2("李四");
        user1Service.add(user1);
        user2Service.add(user2);
        throw new RuntimeException();
    }

    public void inner2Exception() {
        User1 user1 = new User1("张三");
        User2 user2 = new User2("李四");
        user1Service.add(user1);
        user2Service.addException(user2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void outExceptionTx() {
        User1 user1 = new User1("张三");
        User2 user2 = new User2("李四");
        user1Service.add(user1);
        user2Service.add(user2);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void inner2ExceptionTx() {
        User1 user1 = new User1("张三");
        User2 user2 = new User2("李四");
        user1Service.add(user1);
        user2Service.addException(user2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void inner2ExceptionTxTry() {
        User1 user1 = new User1("张三");
        User2 user2 = new User2("李四");
        user1Service.add(user1);
        try {
            user2Service.addException(user2);
        } catch (Exception e) {
            System.out.println("C发生异常");
        }
    }

}
