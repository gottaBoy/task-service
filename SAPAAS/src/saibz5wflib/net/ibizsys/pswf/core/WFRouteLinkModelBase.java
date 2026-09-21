/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.IWFRouteLinkModel;
import net.ibizsys.pswf.core.RootWFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkModelBase;

public abstract class WFRouteLinkModelBase
extends WFLinkModelBase
implements IWFRouteLinkModel {
    private RootWFLinkGroupCondModel rootWFLinkGroupCondModel = new RootWFLinkGroupCondModel();
    private boolean bDefault = false;

    @Override
    public boolean isDefault() {
        return this.bDefault;
    }

    public RootWFLinkGroupCondModel getRootWFLinkGroupCondModel() {
        return this.rootWFLinkGroupCondModel;
    }

    public void setDefault(boolean bDefault) {
        this.bDefault = bDefault;
    }

    @Override
    public IWFLinkGroupCondModel getWFLinkGroupCondModel() {
        return this.rootWFLinkGroupCondModel;
    }
}

