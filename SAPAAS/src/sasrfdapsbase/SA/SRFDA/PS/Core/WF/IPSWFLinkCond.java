/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFLinkCondModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.pswf.core.IWFLinkCondModel;

@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8fde\u63a5\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", typefield="condType", model="PSWFLinkCond")
@PSModelPFIgnoreMeta
public interface IPSWFLinkCond
extends IPSModelObject,
IWFLinkCondModel {
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public void init(ISRFDAGlobalHelper var1, IPSWFLink var2, IPSWFLinkCond var3, PSWFLinkCond var4) throws Exception;

    public IPSWFLinkCond getParentPSWFLinkCond();

    public IPSWFLink getPSWFLink();

    public String getCondType();
}

