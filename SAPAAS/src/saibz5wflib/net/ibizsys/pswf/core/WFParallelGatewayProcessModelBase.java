/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFParallelGatewayProcessModel;
import net.ibizsys.pswf.core.WFGatewayProcessModelBase;

public abstract class WFParallelGatewayProcessModelBase
extends WFGatewayProcessModelBase
implements IWFParallelGatewayProcessModel {
    public String getWFProcessType() {
        return "PARALLELGATEWAY";
    }
}

