/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.proxy;

import java.util.TimerTask;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;

public final class CleanUpTimerTask
extends TimerTask {
    private final ProxyGrantingTicketStorage proxyGrantingTicketStorage;

    public CleanUpTimerTask(ProxyGrantingTicketStorage proxyGrantingTicketStorage) {
        this.proxyGrantingTicketStorage = proxyGrantingTicketStorage;
    }

    @Override
    public void run() {
        this.proxyGrantingTicketStorage.cleanUp();
    }
}

