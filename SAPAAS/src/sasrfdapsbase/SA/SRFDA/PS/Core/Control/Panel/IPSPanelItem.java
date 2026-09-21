/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutItem;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u9762\u677f\u9879\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", typefield="itemType", model="PSSysViewPanelItem")
public interface IPSPanelItem
extends IPSPanelObject,
IPSControlItem,
IPSLayoutItem {
    public static final String ITEMTYPE_CONTAINER = "CONTAINER";
    public static final String ITEMTYPE_CONTROL = "CONTROL";
    public static final String ITEMTYPE_CTRLPOS = "CTRLPOS";
    public static final String ITEMTYPE_RAWITEM = "RAWITEM";
    public static final String ITEMTYPE_TABPANEL = "TABPANEL";
    public static final String ITEMTYPE_TAGPAGE = "TAGPAGE";
    public static final String ITEMTYPE_FIELD = "FIELD";
    public static final String ITEMTYPE_BUTTON = "BUTTON";
    public static final String ITEMTYPE_USERCONTROL = "USERCONTROL";
    public static final String ITEMTYPE_BUTTONLIST = "BUTTONLIST";
    public static final String ITEMTYPE_PARAM = "PARAM";
    public static final String ITEMTYPE_RAWITEMPARAM = "RAWITEMPARAM";
    public static final String ITEMSTYLE_DEFAULT = "DEFAULT";
    public static final String ITEMSTYLE_STYLE2 = "STYLE2";
    public static final String ITEMSTYLE_STYLE3 = "STYLE3";
    public static final String ITEMSTYLE_STYLE4 = "STYLE4";
    public static final String BORERLAYOUTPOS_NORTH = "NORTH";
    public static final String BORERLAYOUTPOS_WEST = "WEST";
    public static final String BORERLAYOUTPOS_EAST = "EAST";
    public static final String BORERLAYOUTPOS_SOUTH = "SOUTH";
    public static final String BORERLAYOUTPOS_CENTER = "CENTER";
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;

    @Override
    public String getCodeName();

    public void layout() throws Exception;

    public String getUniqueId();

    public String getCaption();

    public boolean isShowCaption();

    public IPSPanelItem getParentPSPanelItem();

    @Override
    public IPSPanel getPSPanel();

    public void fillPSPanelItems(ArrayList<IPSPanelItem> var1);

    public void fillPSPanelFields(ArrayList<IPSPanelField> var1);

    public void fillPSControls(ArrayList<IPSControl> var1);

    public String getItemType();

    public double getContentWidth();

    public double getContentHeight();

    public double getWidth();

    public double getHeight();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public void fillEmbeddedPSAppViewRefs(String var1, ArrayList<IPSAppViewRef> var2) throws Exception;

    public String getParentLayoutMode();

    public int getColSpan() throws Exception;

    public int getRowSpan() throws Exception;

    public int getColXS();

    public int getColSM();

    public int getColMD();

    public int getColLG();

    public int getColXSOffset();

    public int getColSMOffset();

    public int getColMDOffset();

    public int getColLGOffset();

    public String getColCssClass();

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysCss getLabelPSSysCss();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public int getColWidth();

    public IPSPanelItem getRootPSPanelItem();

    public String getItemStyle();

    public String getBorderLayoutPos();

    public int getFlexGrow();

    public IPSPanelItemGroupLogic getPSPanelItemGroupLogic(String var1) throws Exception;

    @Override
    public IPSLayoutPos getPSLayoutPos();

    public IPSLayout getPSLayout();

    public IPSPFXCodeObject getRender();

    public Iterator<IPSPanelItemCatGroupLogic> getPSPanelItemGroupLogics();

    public Iterator<IPSPanelItemLogic> getAllPSPanelItemLogics();

    public String getDynaClass();

    public String getCssStyle();

    public String getLabelCssStyle();

    public String getLabelDynaClass();

    public IPSSysCounter getPSSysCounter();

    public String getCounterId();

    public int getCounterMode();

    public IPSAppCounterRef getPSAppCounterRef();
}

