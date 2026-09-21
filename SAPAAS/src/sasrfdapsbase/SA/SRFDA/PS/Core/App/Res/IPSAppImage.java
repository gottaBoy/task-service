/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

@PSModelInterfaceMeta(title="\u5e94\u7528\u56fe\u7247\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysImage")
@PSModelRTIgnoreMeta
public interface IPSAppImage
extends IPSApplicationObject,
IPSSysImage {
    public IPSSysImage getPSSysImage();
}

