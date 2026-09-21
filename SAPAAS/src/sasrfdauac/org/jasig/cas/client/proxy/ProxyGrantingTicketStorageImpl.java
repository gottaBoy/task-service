/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package org.jasig.cas.client.proxy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;

public final class ProxyGrantingTicketStorageImpl
implements ProxyGrantingTicketStorage {
    private final Log log = LogFactory.getLog(this.getClass());
    private static final long DEFAULT_TIMEOUT = 60000L;
    private final Map cache = Collections.synchronizedMap(new HashMap());
    private long timeout;

    public ProxyGrantingTicketStorageImpl() {
        this(60000L);
    }

    public ProxyGrantingTicketStorageImpl(long timeout) {
        this.timeout = timeout;
    }

    @Override
    public String retrieve(String proxyGrantingTicketIou) {
        ProxyGrantingTicketHolder holder = (ProxyGrantingTicketHolder)this.cache.get(proxyGrantingTicketIou);
        if (holder == null) {
            this.log.info((Object)("No Proxy Ticket found for " + proxyGrantingTicketIou));
            return null;
        }
        this.cache.remove(holder);
        if (this.log.isDebugEnabled()) {
            this.log.debug((Object)("Returned ProxyGrantingTicket of " + holder.getProxyGrantingTicket()));
        }
        return holder.getProxyGrantingTicket();
    }

    @Override
    public void save(String proxyGrantingTicketIou, String proxyGrantingTicket) {
        ProxyGrantingTicketHolder holder = new ProxyGrantingTicketHolder(proxyGrantingTicket);
        if (this.log.isDebugEnabled()) {
            this.log.debug((Object)("Saving ProxyGrantingTicketIOU and ProxyGrantingTicket combo: [" + proxyGrantingTicketIou + ", " + proxyGrantingTicket + "]"));
        }
        this.cache.put(proxyGrantingTicketIou, holder);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cleanUp() {
        Map map = this.cache;
        synchronized (map) {
            Iterator iter = this.cache.values().iterator();
            while (iter.hasNext()) {
                ProxyGrantingTicketHolder holder = (ProxyGrantingTicketHolder)iter.next();
                if (!holder.isExpired(this.timeout)) continue;
                iter.remove();
            }
        }
    }

    private static final class ProxyGrantingTicketHolder {
        private final String proxyGrantingTicket;
        private final long timeInserted;

        protected ProxyGrantingTicketHolder(String proxyGrantingTicket) {
            this.proxyGrantingTicket = proxyGrantingTicket;
            this.timeInserted = System.currentTimeMillis();
        }

        public String getProxyGrantingTicket() {
            return this.proxyGrantingTicket;
        }

        final boolean isExpired(long timeout) {
            return System.currentTimeMillis() - this.timeInserted > timeout;
        }
    }
}

