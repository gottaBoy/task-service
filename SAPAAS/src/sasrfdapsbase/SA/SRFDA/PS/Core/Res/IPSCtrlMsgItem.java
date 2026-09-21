/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSCtrlMsgItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u90e8\u4ef6\u6d88\u606f\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCtrlMsgItem")
public interface IPSCtrlMsgItem
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSCtrlMsg var2, PSCtrlMsgItem var3) throws Exception;

    public IPSCtrlMsg getPSCtrlMsg();

    public IPSLanguageRes getContentPSLanguageRes();

    public String getContent();

    public int getTimeout();
}

