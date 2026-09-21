/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.control.IControl
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.IControl;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="controlType")
public interface IPSControl
extends IPSModelObject,
IControl,
IPSDynaInstSupportable {
    public static final String CONTROLTYPE_APPMENU = "APPMENU";
    public static final String CONTROLTYPE_CALENDAR = "CALENDAR";
    public static final String CONTROLTYPE_CALENDAREXPBAR = "CALENDAREXPBAR";
    public static final String CONTROLTYPE_CHART = "CHART";
    public static final String CONTROLTYPE_CHARTEXPBAR = "CHARTEXPBAR";
    public static final String CONTROLTYPE_CONTEXTMENU = "CONTEXTMENU";
    public static final String CONTROLTYPE_CUSTOM = "CUSTOM";
    public static final String CONTROLTYPE_DASHBOARD = "DASHBOARD";
    public static final String CONTROLTYPE_DATAVIEW = "DATAVIEW";
    public static final String CONTROLTYPE_DATAVIEWEXPBAR = "DATAVIEWEXPBAR";
    public static final String CONTROLTYPE_DRBAR = "DRBAR";
    public static final String CONTROLTYPE_DRTAB = "DRTAB";
    public static final String CONTROLTYPE_EXPBAR = "EXPBAR";
    public static final String CONTROLTYPE_FORM = "FORM";
    public static final String CONTROLTYPE_GANTT = "GANTT";
    public static final String CONTROLTYPE_GANTTEXPBAR = "GANTTEXPBAR";
    public static final String CONTROLTYPE_GRID = "GRID";
    public static final String CONTROLTYPE_GRIDEXPBAR = "GRIDEXPBAR";
    public static final String CONTROLTYPE_KANBAN = "KANBAN";
    public static final String CONTROLTYPE_LIST = "LIST";
    public static final String CONTROLTYPE_LISTEXPBAR = "LISTEXPBAR";
    public static final String CONTROLTYPE_MAP = "MAP";
    public static final String CONTROLTYPE_MAPEXPBAR = "MAPEXPBAR";
    public static final String CONTROLTYPE_MOBMDCTRL = "MOBMDCTRL";
    public static final String CONTROLTYPE_MULTIEDITVIEWPANEL = "MULTIEDITVIEWPANEL";
    public static final String CONTROLTYPE_PANEL = "PANEL";
    public static final String CONTROLTYPE_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    public static final String CONTROLTYPE_PORTLET = "PORTLET";
    public static final String CONTROLTYPE_REPORTPANEL = "REPORTPANEL";
    public static final String CONTROLTYPE_SEARCHBAR = "SEARCHBAR";
    public static final String CONTROLTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String CONTROLTYPE_STATEWIZARDPANEL = "STATEWIZARDPANEL";
    public static final String CONTROLTYPE_TABEXPPANEL = "TABEXPPANEL";
    public static final String CONTROLTYPE_TABVIEWPANEL = "TABVIEWPANEL";
    public static final String CONTROLTYPE_TITLEBAR = "TITLEBAR";
    public static final String CONTROLTYPE_TOOLBAR = "TOOLBAR";
    public static final String CONTROLTYPE_TREEEXPBAR = "TREEEXPBAR";
    public static final String CONTROLTYPE_TREEGRID = "TREEGRID";
    public static final String CONTROLTYPE_TREEGRIDEX = "TREEGRIDEX";
    public static final String CONTROLTYPE_TREEVIEW = "TREEVIEW";
    public static final String CONTROLTYPE_UPDATEPANEL = "UPDATEPANEL";
    public static final String CONTROLTYPE_VIEWLAYOUTPANEL = "VIEWLAYOUTPANEL";
    public static final String CONTROLTYPE_VIEWPANEL = "VIEWPANEL";
    public static final String CONTROLTYPE_VIEWPROXY = "VIEWPROXY";
    public static final String CONTROLTYPE_WFEXPBAR = "WFEXPBAR";
    public static final String CONTROLTYPE_WIZARDPANEL = "WIZARDPANEL";
    public static final String CONTROLTYPE_QUICKSEARCHBAR = "QUICKSEARCHBAR";
    public static final String CONTROLTYPE_CAPTIONBAR = "CAPTIONBAR";
    public static final String CONTROLTYPE_DATAINFOBAR = "DATAINFOBAR";
    public static final String MODELSCOPE_DE = "DE";
    public static final String MODELSCOPE_APP = "APP";
    public static final String MODELSCOPE_VIEW = "VIEW";
    public static final String ID_CURRENTVIEW = "SRFCURRENTVIEW";

    public void init(ISRFDAGlobalHelper var1, IPSControlContainer var2, String var3, IPSControlParam var4) throws Exception;

    public IPSControlContainer getPSControlContainer();

    public IPSControlXDataContainer getPSControlXDataContainer();

    public IPSAppView getPSAppView();

    public IPSControlType getPSControlType();

    public void setPSControlType(IPSControlType var1);

    public IPSDataEntity getPSDataEntity();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> var1) throws Exception;

    public void fillEmbeddedPSAppViewRefs(String var1, ArrayList<IPSAppViewRef> var2) throws Exception;

    @Override
    public String getCodeName();

    public boolean isDesignMode();

    public String getModelScope();

    public boolean hasCtrlModel();

    public String getUniqueId();

    public double getWidth();

    public double getHeight();

    public IPSControlParam getPSControlParam();

    public int getOrderValue();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSCtrlMsg getPSCtrlMsg();

    public IPSSysCss getPSSysCss();

    public boolean isDefaultCtrl();

    public boolean isDynamicCtrl();

    public boolean isEnableCol12ToCol24();

    public String getLogicName();

    public String getControlType();

    public String getControlStyle();

    public String getControlSubType();

    public void registerPSControlLogic(IPSControlLogic var1) throws Exception;

    public Iterator<? extends IPSControlLogic> getPSControlLogics();

    public Iterator<String> getHookEventNames();

    public Iterator<? extends IPSControlLogic> getPSControlLogics(String var1);

    public Object getCtrlParam(String var1);

    public boolean containsCtrlParam(String var1);

    public String getCtrlParam(String var1, String var2);

    public boolean getCtrlParam(String var1, boolean var2);

    public int getCtrlParam(String var1, int var2);

    public Iterator<String> getCtrlParamNames();

    public IPSPFXCodeObject getRender();

    public IPSAppDataEntity getPSAppDataEntity();

    public Iterator<? extends IPSControlAction> getPSControlActions();

    public IPSControlAction getUserPSControlAction();

    public IPSControlAction getUser2PSControlAction();

    public boolean isPrepareTemplV2logic();

    public boolean isRegisterToPSAppDataEntity();

    public boolean isPrepareDefaultPSAppViewLogics();

    public IPSControlHandler getPSControlHandler();

    public IPSControl getRefPSControl() throws Exception;

    public IPSControl getRefPSControl2() throws Exception;

    public String getInstallUIEngine();

    public String getInstallUIEngine2();

    public boolean isIndividualCtrl();

    public boolean isEnableUIModelEx();

    public Iterator<? extends IPSControlLogic> getAllPSControlLogics();

    public Iterator<? extends IPSControlAttribute> getPSControlAttributes();

    public Iterator<? extends IPSControlAttribute> getAllPSControlAttributes();

    public Iterator<? extends IPSControlRender> getPSControlRenders();

    public Iterator<? extends IPSControlRender> getAllPSControlRenders();

    public Iterator<? extends IPSControlAttribute> getPSControlAttributesByItemName(String var1);

    public Iterator<? extends IPSControlRender> getPSControlRendersByItemName(String var1);

    public Iterator<? extends IPSControlLogic> getPSControlLogicsByItemName(String var1);

    public void registerPSControlLogic(IPSAppViewLogic var1) throws Exception;

    public int getDynaSysMode();

    public int getPriority();
}

