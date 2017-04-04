package com.orlovskiy.rss.service;


public interface IMailService {

    boolean sendEMail(String from, String to, String subject, String text);

}
