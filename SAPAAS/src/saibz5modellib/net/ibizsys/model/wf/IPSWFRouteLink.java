/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFRouteLinkModel
 *  net.ibizsys.pswf.core.RootWFLinkGroupCondModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.pswf.core.IWFRouteLinkModel;
import net.ibizsys.pswf.core.RootWFLinkGroupCondModel;

public interface IPSWFRouteLink
extends IPSWFLink,
IWFRouteLinkModel {
    public RootWFLinkGroupCondModel getRootWFLinkGroupCondModel();
}

