/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u95e8\u6237\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDBPortletPartParam
extends IPSAjaxControlParam {
    public String getPortletType();

    public int getColumnId();

    public int getColumnSpan();

    public int getColXS();

    public int getColSM();

    public int getColMD();

    public int getColLG();

    public int getColXSOffset();

    public int getColSMOffset();

    public int getColMDOffset();

    public int getColLGOffset();

    public boolean isNewRowMode();

    public String getTitle();

    public String getTitlePSLanguageResId();

    public Boolean getShowTitleBar();

    public int getFlexGrow();

    public int getFlexShrink();

    public int getFlexBasis();

    public String getBorderLayoutPos();

    public Integer getTitleBarCloseMode();

    public String getPSSysUniResId();

    public String getPSSysImageId();

    public String getDynaClass();

    public String getVAlignSelf();

    public String getHAlignSelf();

    public Boolean isEnableAnchor();
}

