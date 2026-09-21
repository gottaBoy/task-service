/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dashboard.IPortlet
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboardContainer;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSUserControl;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutItem;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import net.ibizsys.paas.control.dashboard.IPortlet;

@PSModelInterfaceMeta(typefield="portletType", implement="PSDBPortletPartImpl", model="PSSysDBPart")
@PSModelExtendMeta(title="\u95e8\u6237\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", extend="IPSControl", typevalue={"PORTLET"})
public interface IPSDBPortletPart
extends IPSControl,
IPSAjaxControl,
IPortlet,
IPSControlContainer,
IPSUserControl,
IPSSFCodeObject,
IPSLayoutItem {
    public static final int TITLEBARCLOSEMODE_NONE = 0;
    public static final int TITLEBARCLOSEMODE_OPENDEFAULT = 1;
    public static final int TITLEBARCLOSEMODE_CLOSEDEFAULT = 2;

    public int getDefaultColId();

    public IPSControl getContentPSControl();

    public String getColCssClass();

    public IPSPortletType getPSPortetType();

    public IPSLanguageRes getTitlePSLanguageRes();

    public boolean isShowTitleBar();

    public String getBorderLayoutPos();

    public int getFlexGrow();

    @Override
    public IPSLayoutPos getPSLayoutPos();

    public int getTitleBarCloseMode();

    public IPSSysUniRes getPSSysUniRes();

    public IPSUIActionGroup getPSUIActionGroup();

    public String getActionGroupExtractMode();

    public IPSSysImage getPSSysImage();

    public String getPortletType();

    public String getTitle();

    public String getDynaClass();

    public void setPSDashboardContainer(IPSDashboardContainer var1);

    public IPSDashboardContainer getPSDashboardContainer();

    public boolean isEnableAnchor();
}

