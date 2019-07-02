package org.afmejia.photoapp.api.account.ui.controller;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/status/check")
    public String status() {
        return "Working..";
    }