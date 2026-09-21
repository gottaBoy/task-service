/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;

@PSModelInterfaceMeta(title="\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysPortletCat")
public interface IPSAppPortletCat
extends IPSSysPortletCat,
IPSApplicationObject,
IPSModelSortable {
    public IPSSysPortletCat getPSSysPortletCat();

    public boolean isUngroup();

    @Override
    public String getCodeName();

    @Override
    public IPSLanguageRes getNamePSLanguageRes();

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public IPSSysCss getPSSysCss();
}

