package com.example.billing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


public class Client {


    private RestOperations restTemplate;

    @Autowired
    public Client(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }





    public void billUser(String userId,Integer amount) {

        //RestOperations restTemplate = new RestTemplate();
 //       Map<String, String> params = new HashMap<String, String>();
   //     params.put("paymentMonthlyAmount", "10");

       // String url = restTemplate.getForObject("http://billing", String.class);

        //restTemplate.postForObject(url + "/reocurringPayment" ,params,Object.class);
        restTemplate.postForEntity("http://billing/reoccurringPayment", amount, String.class);



    }


}
