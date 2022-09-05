package com.kob.backend.service.user.account;

import com.kob.backend.pojo.User;

import java.util.Map;

public interface InfoService {
    public Map<String, String> getinfo();
    public Map<String, String> upload(User user);
}
