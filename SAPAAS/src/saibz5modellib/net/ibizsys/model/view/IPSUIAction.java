/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.view.IUIAction
 */
package net.ibizsys.model.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.paas.view.IUIAction;

public interface IPSUIAction
extends IPSModelObject,
IUIAction,
IPSModelJsonExporter {
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
    public static final String UIACTIONMODE_SYS = "SYS";
    public static final String UIACTIONMODE_FRONT = "FRONT";
    public static final String UIACTIONMODE_BACKEND = "BACKEND";
    public static final String UIACTIONMODE_WFFRONT = "WFFRONT";
    public static final String UIACTIONMODE_WFBACKEND = "WFBACKEND";

    public String getUIActionTag();

    public String getUIActionFullTag();

    public String getUIActionType();

    public String getUIActionMode();

    public void fillUIActionItem(Object var1) throws Exception;

    public String getCaption(String var1);

    public boolean isUIActionGroup(Object var1) throws Exception;

    public IPSUIActionGroup getPSUIActionGroup(Object var1) throws Exception;

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

    public ObjectNode getUIActionParamJO();

    public String getValueItem();

    public String getTextItem();

    public String getParamItem();

    public IPSUIAction getNextPSUIAction();
}

