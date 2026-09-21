/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEFLogic;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelExtendMeta(extend="IPSAppDELogic", typevalue={"DEFIELD"})
@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEFLogicImpl")
public interface IPSAppDEFLogic
extends IPSAppDELogic,
IPSDEFLogic {
    public IPSAppDEField getPSAppDEField();
}

