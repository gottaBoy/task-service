/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u6210\u5458\u9879\u53c2\u6570\u5bf9\u8c61\u63a5\u53e3", implement="PSControlItemParamProxy")
public interface IPSControlItemParam
extends IPSModelObject {
    public String getKey();

    public String getValue();

    public String getCaption();

    public IPSSysImage getPSSysImage();

    public IPSUIAction getPSUIAction();

    public String getTooltip();
}

