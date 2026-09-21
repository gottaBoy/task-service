/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IUIAction
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import net.ibizsys.paas.view.IUIAction;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u754c\u9762\u884c\u4e3a\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="PSDEUIActionImpl")
public interface IPSUIAction
extends IPSModelObject,
IUIAction,
IPSNavigateParamContainer {
    public static final String VIEWLOGICATTACHMODE_NONE = "NONE";
    public static final String VIEWLOGICATTACHMODE_REPLACE = "REPLACE";
    public static final String VIEWLOGICATTACHMODE_AFTER = "AFTER";
    public static final int NOPRIVDISPLAYMODE_DISABLED = 1;
    public static final int NOPRIVDISPLAYMODE_HIDE = 2;
    public static final int NOPRIVDISPLAYMODE_HIDEDEFAULT = 6;
    public static final String ACTIONTARGET_SINGLE = "SINGLE";
    public static final String ACTIONTARGET_SINGLEKEY = "SINGLEKEY";
    public static final String ACTIONTARGET_MULTI = "MULTI";
    public static final String ACTIONTARGET_ALL = "ALL";
    public static final String ACTIONTARGET_NONE = "NONE";
    public static final String ACTIONMODE_SYS = "SYS";
    public static final String ACTIONMODE_FRONT = "FRONT";
    public static final String ACTIONMODE_BACKEND = "BACKEND";
    public static final String ACTIONMODE_WFFRONT = "WFFRONT";
    public static final String ACTIONMODE_WFBACKEND = "WFBACKEND";
    public static final String ACTIONMODE_CUSTOM = "CUSTOM";
    public static final int REFRESHMODE_NONE = 0;
    public static final int REFRESHMODE_DEFAULT = 1;
    public static final int REFRESHMODE_PARENTNODE = 2;
    public static final int REFRESHMODE_ROOTNODE = 3;
    public static final int ACTIONLEVEL_LOW = 50;
    public static final int ACTIONLEVEL_NORMAL = 100;
    public static final int ACTIONLEVEL_HIGH = 200;
    public static final int ACTIONLEVEL_CRITICAL = 250;
    public static final String DIALOGRESULT_OK = "OK";
    public static final String DIALOGRESULT_CANCEL = "CANCEL";
    public static final int CLOSEWINDOWMODE_NO = 0;
    public static final int CLOSEWINDOWMODE_OK = 1;
    public static final int CLOSEWINDOWMODE_CANCEL = 2;

    public String getUIActionTag();

    public String getUIActionFullTag();

    public String getUIActionType();

    public String getUIActionMode();

    public void fillUIActionItem(Object var1) throws Exception;

    public String getCaption(String var1);

    public boolean isUIActionGroup(Object var1) throws Exception;

    public IPSUIActionGroup getPSUIActionGroup(Object var1) throws Exception;

    public boolean isEnableUIActionGroupExMode(Object var1) throws Exception;

    @Override
    public String getCodeName();

    public boolean isValid(Object var1) throws Exception;

    public String getActionTarget();

    public String getFrontProcessType();

    public IPSSysImage getPSSysImage();

    public String getTooltip(String var1);

    public String getHtmlPageUrl();

    public long getTimeout();

    public String getConfirmMsg();

    public boolean isReloadData();

    public String getSuccessMsg();

    public String getDataAccessAction();

    public boolean isCloseEditView();

    public boolean isEnableToggleMode();

    public String getViewLogicAttachMode();

    public String getViewLogicType();

    public String getPSDEUILogicId();

    public String getPSSysViewLogicId();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public IPSLanguageRes getCMPSLanguageRes();

    public IPSLanguageRes getSMPSLanguageRes();

    public int getNoPrivDisplayMode(IPSAppView var1);

    public String getUIActionParam();

    public JSONObject getUIActionParamJO();

    public String getValueItem();

    public String getTextItem();

    public String getParamItem();

    public IPSUIAction getNextPSUIAction();

    public IPSAppView getFrontPSAppView(Object var1) throws Exception;

    public String getFullCodeName();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSViewLogic getPSViewLogic(Object var1) throws Exception;

    public String getViewLogicCodeName();

    public boolean hasViewLogic();

    public boolean isShowBusyIndicator();

    public int getRefreshMode();

    public IPSAppView getFrontPSAppView() throws Exception;

    public boolean isGroup() throws Exception;

    public boolean isEnableConfirm();

    public int getActionLevel();

    public String getUILogicAttachMode();

    public String getUILogicType();

    public String getDialogResult();

    public String getPredefinedType();

    public String getScriptCode();

    public String getCounterId();

    public String getButtonStyle();
}

