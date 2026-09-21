/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodLogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEActionLogic
extends IPSAppDEMethodLogic {
    public IPSDEActionLogic getPSDEActionLogic();

    public boolean isInternalLogic();

    public boolean isCloneParam();

    public IPSAppDELogic getPSAppDELogic();

    public IPSAppDataEntity getDstPSAppDataEntity();

    public IPSAppDEAction getDstPSAppDEAction();
}

