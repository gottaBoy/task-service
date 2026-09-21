/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.CaptionBar;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

@PSModelInterfaceMeta(title="\u6807\u9898\u680f\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSCaptionBar
extends IPSControl {
    public String getCaption();

    public String getSubCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSLanguageRes getSubCapPSLanguageRes();

    public IPSSysImage getPSSysImage();
}

