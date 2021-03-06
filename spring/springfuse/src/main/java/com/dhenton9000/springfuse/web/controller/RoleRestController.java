/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/restController.e.vm.java
 */
package com.dhenton9000.springfuse.web.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dhenton9000.springfuse.web.util.AutoCompleteResult;
import com.dhenton9000.springfuse.web.util.SearchParameters;
import com.dhenton9000.springfuse.domain.Role;
import com.dhenton9000.springfuse.service.RoleService;

@Controller
@RequestMapping("domain/rest/role/")
public class RoleRestController {
    @Autowired
    public FormattingConversionService formattingConversionService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/", method = POST)
    @ResponseBody
    public Role create(@Valid Role role) {
        roleService.save(role);
        return role.copy();
    }

    @RequestMapping(value = "/", method = POST, headers = "content-type:application/json")
    @ResponseBody
    public Role jsonCreate(@Valid @RequestBody Role role) {
        roleService.save(role);
        return role.copy();
    }

    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public List<Role> list(Role role, SearchParameters searchParameters) {
        List<Role> roles = roleService.find(role, searchParameters.toSearchTemplate());
        List<Role> ret = new ArrayList<Role>();
        for (Role _role : roles) {
            ret.add(_role.copy());
        }
        return ret;
    }

    @RequestMapping(value = "/{pk}", method = GET)
    @ResponseBody
    public Role get(@PathVariable("pk") Role role) {
        return role.copy();
    }

    @RequestMapping(value = "/{pk}", method = PUT)
    @ResponseBody
    public Role update(@PathVariable("pk") Role roleToUpdate, @Valid Role role) {
        role.copyTo(roleToUpdate);
        roleService.save(roleToUpdate);
        return roleToUpdate.copy();
    }

    @RequestMapping(value = "/{pk}", method = DELETE)
    @ResponseBody
    public boolean delete(@PathVariable("pk") Role role) {
        roleService.delete(role);
        return true;
    }

    @RequestMapping("/autocomplete")
    @ResponseBody
    public List<AutoCompleteResult> autocomplete(@RequestParam(value = "term", required = false) String searchPattern,
            SearchParameters search) {
        if (searchPattern != null && !searchPattern.isEmpty()) {
            search.setSearchPattern(searchPattern);
        }
        List<AutoCompleteResult> ret = new ArrayList<AutoCompleteResult>();
        for (Role role : roleService.find(search.toSearchTemplate())) {
            String objectPk = role.getPrimaryKey().toString();
            String objectLabel = formattingConversionService.convert(role, String.class);
            ret.add(new AutoCompleteResult(objectPk, objectLabel));
        }
        return ret;
    }

    @ExceptionHandler()
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public void exception(Exception e, PrintWriter out) {
        out.write(e.getMessage());
    }
}