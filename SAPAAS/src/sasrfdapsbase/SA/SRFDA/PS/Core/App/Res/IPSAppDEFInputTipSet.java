/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u63d0\u793a\u96c6\u5408\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFInputTipSet")
public interface IPSAppDEFInputTipSet
extends IPSApplicationObject,
IPSDEFInputTipSet {
    public IPSDEFInputTipSet getPSDEFInputTipSet();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public IPSAppDEField getUniqueTagPSAppDEField() throws Exception;

    public IPSAppDEField getLinkPSAppDEField() throws Exception;

    public IPSAppDEField getEnableClosePSAppDEField() throws Exception;

    public IPSAppDEField getContentPSAppDEField() throws Exception;
}

