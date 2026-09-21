/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.IWFLinkModel;

public interface IWFRouteLinkModel
extends IWFLinkModel {
    public boolean isDefault();

    public IWFLinkGroupCondModel getWFLinkGroupCondModel();
}

