package com.bailiny;

import com.bailiny.tx.TestTxService;
import com.bailiny.tx.entity.User1;
import com.bailiny.tx.User1Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TxServiceTests {
    @Autowired
    private User1Service user1Service;

    @Autowired
    private TestTxService testTxService;

    @Test
    public void test1() {
        testTxService.notransaction_exception_required_required();
    }

}
