package com.patrickfrr.ecommerce.checkout.listener;

import com.patrickfrr.ecommerce.checkout.entity.CheckoutEntity;
import com.patrickfrr.ecommerce.checkout.service.CheckoutService;
import com.patrickfrr.ecommerce.checkout.streaming.PaymentPaidSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreadtedEvent paymentCreadtedEvent) {
        checkoutService.updateStatus(paymentCreadtedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
