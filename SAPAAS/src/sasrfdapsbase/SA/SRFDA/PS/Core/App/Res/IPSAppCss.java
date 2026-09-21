/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;

@PSModelInterfaceMeta(title="\u5e94\u7528\u6837\u5f0f\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCss")
@PSModelRTIgnoreMeta
public interface IPSAppCss
extends IPSApplicationObject,
IPSSysCss {
    public IPSSysCss getPSSysCss();
}

