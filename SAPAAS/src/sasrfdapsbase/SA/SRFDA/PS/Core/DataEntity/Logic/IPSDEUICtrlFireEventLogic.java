/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u89e6\u53d1\u4e8b\u4ef6\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"VIEWCTRLFIREEVENT"})
public interface IPSDEUICtrlFireEventLogic
extends IPSDEUILogicNode {
    public IPSDEUILogicParam getFireCtrl() throws Exception;

    public String getEventName() throws Exception;

    public IPSDEUILogicParam getEventParam() throws Exception;
}

