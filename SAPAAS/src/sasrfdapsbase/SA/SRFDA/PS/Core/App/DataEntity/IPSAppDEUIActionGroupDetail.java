/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUAGroupDetail")
public interface IPSAppDEUIActionGroupDetail
extends IPSDEUIActionGroupDetail {
    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup();

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getBeforePSSysCss();

    public IPSSysCss getAfterPSSysCss();
}

