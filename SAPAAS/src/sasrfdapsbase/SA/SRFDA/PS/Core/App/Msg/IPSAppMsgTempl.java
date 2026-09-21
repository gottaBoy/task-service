/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Msg;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u6d88\u606f\u6a21\u677f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysMsgTempl")
public interface IPSAppMsgTempl
extends IPSApplicationObject,
IPSSysMsgTempl,
IPSModelSortable {
    public IPSSysMsgTempl getPSSysMsgTempl();
}

