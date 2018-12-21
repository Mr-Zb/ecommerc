package com.fun.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import java.util.List;

@Slf4j
public class SessionRegistryImpl implements SessionRegistry, ApplicationListener<SessionDestroyedEvent> {
    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        log.info("--消除的sessionid--"+event.getId());
    }

    @Override
    public List<Object> getAllPrincipals() {
        return null;
    }

    @Override
    public List<SessionInformation> getAllSessions(Object principal, boolean includeExpiredSessions) {
        return null;
    }

    @Override
    public SessionInformation getSessionInformation(String sessionId) {
        return null;
    }

    @Override
    public void refreshLastRequest(String sessionId) {

    }

    @Override
    public void registerNewSession(String sessionId, Object principal) {

    }

    @Override
    public void removeSessionInformation(String sessionId) {

    }
}
