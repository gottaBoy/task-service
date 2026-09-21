/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;

@PSModelInterfaceMeta(title="\u5de5\u5177\u680f\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="itemType", implement="PSDEToolbarItemImpl", model="PSDETBItem")
public interface IPSDEToolbarItem
extends IPSModelObject,
IPSControlItem {
    public static final String TBITEMTYPE_DEUIACTION = "DEUIACTION";
    public static final String TBITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String TBITEMTYPE_ITEMS = "ITEMS";
    public static final String TBITEMTYPE_RAWITEM = "RAWITEM";
    public static final String SHOWMODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";
    public static final String SHOWMODE_ICON = "ICON";
    public static final String SHOWMODE_SHORTWORD = "SHORTWORD";

    public void init(ISRFDAGlobalHelper var1, IPSDEToolbar var2, IPSDEToolbarItem var3, PSDEToolbarItem var4) throws Exception;

    public String getCaption();

    public String getItemType();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public boolean isValid() throws Exception;

    public IPSDEToolbar getPSDEToolbar();

    public boolean isShowCaption();

    public boolean isShowIcon();

    public String getTooltip();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public IPSDEToolbarItem getParentPSDEToolbarItem();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public void fillPSDEToolbarItems(ArrayList<IPSDEToolbarItem> var1);

    public double getWidth();

    public double getHeight();

    @Override
    public String getUserTag();

    @Override
    public String getUserTag2();

    public IPSPFXCodeObject getRender();

    public String getData();

    public String getDynaClass();

    public String getCssStyle();

    public String getItemStyle();

    public String getCounterId();

    public int getCounterMode();
}

