/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import SA.SRFDA.PS.Data.PSWFLinkRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8fde\u63a5\u89d2\u8272\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFLinkRole")
public interface IPSWFLinkRole
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSWFLink var2, PSWFLinkRole var3) throws Exception;

    public IPSWFLink getPSWFLink();

    public IPSWFProcessRole getPSWFProcessRole();

    public IPSSysMsgTempl getPSSysMsgTempl();
}

