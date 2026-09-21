/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase;
import SA.SRFDA.PS.Core.App.View.IPSAppDEViewBase;
import SA.SRFDA.PS.Core.App.View.IPSAppViewBase;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5168\u5c40\u754c\u9762\u903b\u8f91\u5f15\u7528\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppUILogicRefView
extends IPSAppUILogicRefViewBase,
IPSAppViewBase,
IPSAppDEViewBase {
    public IPSAppViewRef getPSAppViewRef();

    @Override
    public IPSDataEntity getPSDataEntity();

    @Override
    public IPSAppDataEntity getPSAppDataEntity();
}

