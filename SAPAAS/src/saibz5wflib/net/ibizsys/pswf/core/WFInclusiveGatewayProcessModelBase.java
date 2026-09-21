/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFInclusiveGatewayProcessModel;
import net.ibizsys.pswf.core.WFGatewayProcessModelBase;

public abstract class WFInclusiveGatewayProcessModelBase
extends WFGatewayProcessModelBase
implements IWFInclusiveGatewayProcessModel {
    public String getWFProcessType() {
        return "INCLUSIVEGATEWAY";
    }
}

