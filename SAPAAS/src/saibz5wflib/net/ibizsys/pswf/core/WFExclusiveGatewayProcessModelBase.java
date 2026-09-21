/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFExclusiveGatewayProcessModel;
import net.ibizsys.pswf.core.WFGatewayProcessModelBase;

public abstract class WFExclusiveGatewayProcessModelBase
extends WFGatewayProcessModelBase
implements IWFExclusiveGatewayProcessModel {
    public String getWFProcessType() {
        return "EXCLUSIVEGATEWAY";
    }
}

