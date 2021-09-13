package br.patrickfrr.ecommerce.checkout.service;

import br.patrickfrr.ecommerce.checkout.entity.CheckoutEntity;
import br.patrickfrr.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {
    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}

