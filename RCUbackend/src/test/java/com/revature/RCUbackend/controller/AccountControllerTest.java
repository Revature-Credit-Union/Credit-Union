package java.com.revature.RCUbackend.controller;

import com.revature.RCUbackend.controller.*;
import com.revature.RCUbackend.service.*;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;

public class AccountControllerTest {
    AccountController accountController;

    @Mock
    AccountService accountService;

    @BeforeEach
    void setUp(){
        this.accountController = new AccountController(accountService);
    }

    @Test
    void depositTest(){}

    @Test
    void withdrawTest(){}

    @Test
    void transferTest(){}

}
