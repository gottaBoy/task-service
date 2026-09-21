/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.RawItem;

import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

public interface IPSUnkownItem
extends IPSRawItemBase {
    public String getRawContent();

    public String getHtmlContent();

    public IPSSysImage getPSSysImage();
}

