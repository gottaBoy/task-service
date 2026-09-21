/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELNParam")
public interface IPSAppDELogicNodeParam
extends IPSDELogicNodeParam {
    public IPSAppDELogicNode getPSAppDELogicNode();
}

