/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jasig.cas.client.util.CommonUtils;

public final class ProxyList {
    private final List proxyChains;

    public ProxyList(List proxyChains) {
        CommonUtils.assertNotNull(proxyChains, "List of proxy chains cannot be null.");
        Iterator iter = proxyChains.iterator();
        while (iter.hasNext()) {
            CommonUtils.assertTrue(iter.next() instanceof String[], "Proxy chains must contain String[] items exclusively.");
        }
        this.proxyChains = proxyChains;
    }

    public ProxyList() {
        this(new ArrayList());
    }

    public boolean contains(String[] proxiedList) {
        Iterator iter = this.proxyChains.iterator();
        while (iter.hasNext()) {
            if (!Arrays.equals(proxiedList, (String[])iter.next())) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.proxyChains.toString();
    }
}

