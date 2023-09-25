package com.pursuit.springclass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pursuit.springclass.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
