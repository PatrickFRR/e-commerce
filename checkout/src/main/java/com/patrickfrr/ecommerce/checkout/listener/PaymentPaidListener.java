package com.patrickfrr.ecommerce.checkout.listener;


import com.patrickfrr.ecommerce.checkout.entity.CheckoutEntity;
import com.patrickfrr.ecommerce.checkout.service.CheckoutService;
import com.patrickfrr.ecommerce.checkout.streaming.PaymentPaidSink;
import com.patrickfrr.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

   @Deprecated
   @StreamListener(PaymentPaidSink.INPUT)
   public void handler(PaymentCreatedEvent paymentCreatedEvent) {
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
