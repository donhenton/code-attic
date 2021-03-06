/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/manager/ModelGenerator.e.vm.java
 */
package com.dhenton9000.springfuse.service;

import java.util.*;

import com.dhenton9000.springfuse.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhenton9000.springfuse.domain.Account;

import com.dhenton9000.springfuse.domain.ContactInfo;
import com.dhenton9000.springfuse.service.ContactInfoService;
import com.dhenton9000.springfuse.service.ContactInfoGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Service
public class AccountGenerator {

    /**
     * Returns a new Account instance filled with random values.
     */
    public Account getAccount() {
        Account account = new Account();

        // simple attributes follows
        account.setUsername(ValueGenerator.getUniqueString(255));
        account.setPassword("d");
        account.setEmail(ValueGenerator.getUniqueEmail());
        account.setIsEnabled(true);
        return account;
    }

    @Autowired
    private ContactInfoService contactInfoService;
    @Autowired
    private ContactInfoGenerator contactInfoGenerator;
}