package com.bailiny;

import com.bailiny.tx.TestTxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 */
@SpringBootTest
class TxServiceTests {

    @Autowired
    private TestTxService testTxService;

    @Test
    public void outException() {
        testTxService.outException();
    }

    @Test
    public void inner2Exception() {
        testTxService.inner2Exception();
    }

    @Test
    public void outExceptionTx() {
        testTxService.outExceptionTx();
    }

    @Test
    public void inner2ExceptionTx() {
        testTxService.inner2ExceptionTx();
    }

    @Test
    public void inner2ExceptionTxTry() {
        testTxService.inner2ExceptionTxTry();
    }
}
