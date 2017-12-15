package com.example.subscriptions;

//import com.example.billing.ChargeUser;
import com.example.billing.Client;

import com.example.email.SendEmail;

public class CreateSubscription {

    //private final ChargeUser chargeUser;
    private final SendEmail emailSender;
    private final SubscriptionRepository subscriptions;
    private final Client clientUser;


    public CreateSubscription(
            Client clientUser,
            SendEmail emailSender, SubscriptionRepository subscriptions) {
        this.clientUser = clientUser;
        this.emailSender = emailSender;
        this.subscriptions = subscriptions;
    }



//    public CreateSubscription(
//            ChargeUser chargeUser,
//            SendEmail emailSender, SubscriptionRepository subscriptions) {
//        this.chargeUser = chargeUser;
//        this.emailSender = emailSender;
//        this.subscriptions = subscriptions;
//    }





    public void run(String userId, String packageId) {
        subscriptions.create(new Subscription(userId, packageId));
        //chargeUser.run(userId, 100);
        clientUser.billUser(userId,10);
        emailSender.run("me@example.com", "Subscription Created", "Some email body");
    }
}
