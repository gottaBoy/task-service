/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFLinkCustomCondModel;
import net.ibizsys.pswf.core.WFLinkCondModelBase;

public class WFLinkCustomCondModel
extends WFLinkCondModelBase
implements IWFLinkCustomCondModel {
    @Override
    public String getCondType() {
        return "CUSTOM";
    }
}

