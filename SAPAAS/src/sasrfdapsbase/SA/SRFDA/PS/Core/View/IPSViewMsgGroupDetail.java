/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Data.PSViewMsgGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u89c6\u56fe\u6d88\u606f\u7ec4\u6210\u5458\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSViewMsgGrpDetail")
public interface IPSViewMsgGroupDetail
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSViewMsgGroup var2, PSViewMsgGroupDetail var3) throws Exception;

    public IPSViewMsgGroup getPSViewMsgGroup();

    public String getPSViewMsgId();

    public IPSViewMsg getPSViewMsg() throws Exception;

    public String getPosition();
}

