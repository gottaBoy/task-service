/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCtrlLogicGrpDetail", implement="PSDEUILogicGroupDetailImpl")
public interface IPSAppDEUILogicGroupDetail
extends IPSDEUILogicGroupDetail {
    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEUILogic getPSAppDEUILogic() throws Exception;

    public IPSAppUILogic getPSAppUILogic() throws Exception;
}

