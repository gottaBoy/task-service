/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.model.der.IPSDERNN
 */
package net.ibizsys.model.der;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERNN;

public class PSDERNNImpl
implements IPSDERNN {
    private IPSDER1N[] list = null;

    public PSDERNNImpl(IPSDER1N[] list) {
        this.list = list;
    }

    @PSModelRTMeta(description="1:N\u5173\u7cfb1")
    public IPSDER1N getFirstPSDER1N() {
        return this.list[0];
    }

    @PSModelRTMeta(description="1:N\u5173\u7cfb2")
    public IPSDER1N getSecondPSDER1N() {
        return this.list[1];
    }
}

