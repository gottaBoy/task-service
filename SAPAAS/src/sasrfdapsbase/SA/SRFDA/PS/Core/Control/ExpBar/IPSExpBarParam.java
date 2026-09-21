/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5bfc\u822a\u680f\u53c2\u6570\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSExpBarParam
extends IPSAjaxControlParam {
    public static final String CTRLPARAM_SECTIONNAME = "SECTION.NAME";
    public static final String CTRLPARAM_SECTIONNAMELANRESTAG = "SECTION.NAMELANRESTAG";

    public String getPSSysCounterId();

    public String getTitle();

    public String getTitlePSLanguageResId();

    public Boolean getEnableCounter();

    public Boolean getEnableSearch();

    public Boolean getShowTitleBar();

    public String getPSDEToolbarId();

    public String getPSSysImageId();
}

