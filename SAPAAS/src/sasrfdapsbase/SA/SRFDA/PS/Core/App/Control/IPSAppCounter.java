/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u8ba1\u6570\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCounter")
public interface IPSAppCounter
extends IPSSysCounter,
IPSApplicationObject,
IPSModelSortable {
    public IPSAppDEMethod getPSAppDEMethod();

    public IPSAppDEAction getGetPSAppDEAction();

    public IPSAppDataEntity getPSAppDataEntity();

    @Override
    public IPSApplication getPSApplication();

    public IPSSysCounter getPSSysCounter();

    public IPSAppDEDataSet getGetPSAppDEDataSet();
}

