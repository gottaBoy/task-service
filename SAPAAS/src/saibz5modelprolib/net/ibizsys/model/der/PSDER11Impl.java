/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.der.IPSDER11
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.der;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.der.IPSDER11;
import net.ibizsys.model.der.PSDER1NImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDER11Impl
extends PSDER1NImpl
implements IPSDER11 {
    private static final Log log = LogFactory.getLog(PSDER11Impl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onFillViewParentModeJO(ObjectNode jo) {
        super.onFillViewParentModeJO(jo);
        if (!jo.has("SRFDER11ID".toLowerCase())) {
            jo.put("SRFDER11ID".toLowerCase(), this.getName());
        }
    }
}

