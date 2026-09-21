/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

@PSModelInterfaceMeta(title="\u56fe\u7247\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSImageBase {
    public String getAlternativeText();

    public IPSSysImage getPSSysImage();

    public boolean isPlaceCenter();

    public String getFitMode();
}

