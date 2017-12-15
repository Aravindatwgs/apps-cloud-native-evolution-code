package com.example.billing.billing;


import com.example.payments.Gateway;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    private Gateway paymentGateway;

    public BillingController(Gateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void run(String userId, int paymentMonthlyAmount) {
        paymentGateway.createReocurringPayment(paymentMonthlyAmount);
    }




    @RequestMapping(value = "/reoccurringPayment", method = RequestMethod.POST)
    public ResponseEntity<String> reoccurringPayment(@RequestBody int paymentMonthlyAmount){

        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.add("content-type", MediaType.APPLICATION_JSON.toString());


        ResponseEntity<String> response;

        System.out.println("Payement Monthly " + paymentMonthlyAmount);

        if(this.paymentGateway.createReocurringPayment(paymentMonthlyAmount)) {
            response = new ResponseEntity<>("{errors: []}", responseHeaders, HttpStatus.CREATED);
        } else
        {
            response = new ResponseEntity<>("{errors: [\"error1\", \"error2\"]}", responseHeaders, HttpStatus.BAD_REQUEST);
        }



       return response;

    }





}
