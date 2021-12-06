package com.revature.RCUbackend.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TranscationController {

    private TransactionService transactionService;

    @Autowired
    public TranscationController(TranscationService transcationService){ this.transactionService = transcationService;}

    @GetMapping("allTransactions")
    public Response allTransactions(@RequestBody User user){
        Response response;
        ArrayList<Transaction> temp = this.transactionService.findByUserId(user.getUserID());

        if(temp != null){
            response = new Response(true, "Transactions found", temp);
        }else{
            response = new Response(false, "Transactions not found", null);
        }

        return response;
    }
}
