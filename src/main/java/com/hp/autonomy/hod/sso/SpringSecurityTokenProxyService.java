/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.hod.sso;

import com.hp.autonomy.hod.client.token.TokenProxy;
import com.hp.autonomy.hod.client.token.TokenProxyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * {@link TokenProxyService} which retrieves the token proxy from the Spring Security Context if the stored
 * authentication is a {@link HodAuthentication}.
 */
public class SpringSecurityTokenProxyService implements TokenProxyService {

    @Override
    public TokenProxy getTokenProxy() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof HodAuthentication)) {
            return null;
        }

        return ((HodAuthentication) authentication).getTokenProxy();
    }

}
