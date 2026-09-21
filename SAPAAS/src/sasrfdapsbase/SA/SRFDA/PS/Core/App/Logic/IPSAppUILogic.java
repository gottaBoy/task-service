/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5168\u5c40\u754c\u9762\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSAppUILogicImpl", typefield="viewLogicType")
public interface IPSAppUILogic
extends IPSSysViewLogic {
    public IPSApplication getPSApplication();

    public boolean isBuiltinLogic();

    public Iterator<IPSAppUILogicRefView> getPSAppUILogicRefViews();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEUILogic getPSAppDEUILogic();

    public IPSPFXCodeObject getRender();

    @Override
    public String getViewLogicType();

    public IPSSysPFPlugin getPSSysPFPlugin();
}

