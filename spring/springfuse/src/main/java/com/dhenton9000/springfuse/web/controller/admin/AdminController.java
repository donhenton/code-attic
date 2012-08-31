/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/admin/AdminController.p.vm.java
 */
package com.dhenton9000.springfuse.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhenton9000.springfuse.web.util.ExceptionUtil;

/**
 * A simple Controller example that a developper can use as a tool
 * to call the throwException handler that throws on purpose an exception!
 * This is pretty useful to make sure that the error page displayed
 * in that case meets your expectations.
 *
 * Note: This controller name is forced only to minimize the risks of name collisions.
 * It is not used since controllers sit on top of everything else.
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {

    private ExceptionUtil exceptionUtil = new ExceptionUtil();

    @RequestMapping("index")
    public void index(Model model) {
        model.addAttribute("adminForm", new AdminForm());
    }

    @RequestMapping("throwException")
    public void throwException(@ModelAttribute AdminForm adminForm) throws Exception {
        exceptionUtil.throwException(adminForm.getExceptionName());
    }
}