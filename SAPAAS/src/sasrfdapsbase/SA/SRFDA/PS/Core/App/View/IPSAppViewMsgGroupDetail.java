/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroupDetail;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSViewMsgGrpDetail")
public interface IPSAppViewMsgGroupDetail
extends IPSViewMsgGroupDetail {
    public IPSAppViewMsgGroup getPSAppViewMsgGroup();

    public IPSAppViewMsg getPSAppViewMsg();

    @Override
    public String getPosition();
}

