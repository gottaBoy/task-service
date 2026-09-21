/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u6a21\u578b\u5b58\u50a8\u529f\u80fd\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppUtil")
public interface IPSAppDynaUtilBase
extends IPSAppUtil {
    public IPSAppDataEntity getStoagePSAppDataEntity();

    public IPSAppDataEntity getStoragePSAppDataEntity();

    public IPSAppDEAction getGetPSAppDEAction();

    public IPSAppDEAction getCreatePSAppDEAction();

    public IPSAppDEAction getUpdatePSAppDEAction();

    public IPSAppDEAction getRemovePSAppDEAction();

    public IPSAppDEField getAppIdPSAppDEField();

    public IPSAppDEField getUserIdPSAppDEField();

    public IPSAppDEField getModelPSAppDEField();

    public IPSAppDEField getModelIdPSAppDEField();
}

