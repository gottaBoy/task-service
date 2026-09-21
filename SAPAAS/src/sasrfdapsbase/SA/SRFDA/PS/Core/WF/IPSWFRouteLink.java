/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFRouteLinkModel
 *  net.ibizsys.pswf.core.RootWFLinkGroupCondModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import net.ibizsys.pswf.core.IWFRouteLinkModel;
import net.ibizsys.pswf.core.RootWFLinkGroupCondModel;

@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u5e38\u89c4\u5904\u7406\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"ROUTE"})
@PSModelPFIgnoreMeta
public interface IPSWFRouteLink
extends IPSWFLink,
IWFRouteLinkModel {
    public RootWFLinkGroupCondModel getRootWFLinkGroupCondModel();
}

