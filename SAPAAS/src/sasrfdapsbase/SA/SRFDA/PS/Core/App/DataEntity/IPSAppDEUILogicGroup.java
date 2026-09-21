/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroup;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCtrlLogicGroup")
public interface IPSAppDEUILogicGroup
extends IPSDEUILogicGroup {
    public Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSApplication getPSApplication();
}

