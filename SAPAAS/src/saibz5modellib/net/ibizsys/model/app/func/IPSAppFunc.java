/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.app.func;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;

public interface IPSAppFunc
extends IPSApplicationObject,
IPSModelObject {
    public static final String APPFUNCTYPE_APPVIEW = "APPVIEW";
    public static final String APPFUNCTYPE_SUBAPPVIEW = "SUBAPPVIEW";
    public static final String APPFUNCTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String APPFUNCTYPE_CUSTOM = "CUSTOM";
    public static final String APPFUNCTYPE_PDTAPPFUNC = "PDTAPPFUNC";
    public static final String APPFUNCTYPE_JAVASCRIPT = "JAVASCRIPT";
    public static final String OPENMODE_INDEXVIEWTAB = "INDEXVIEWTAB";
    public static final String OPENMODE_INDEXVIEWPOPUP = "INDEXVIEWPOPUP";
    public static final String OPENMODE_INDEXVIEWPOPUPMODAL = "INDEXVIEWPOPUPMODAL";
    public static final String OPENMODE_HTMLPOPUP = "HTMLPOPUP";

    public String getFuncSN();

    public String getAppFuncType();

    public IPSAppView getPSAppView() throws Exception;

    public String getOpenMode();

    public String getUserData();

    public String getUserData2();

    public int getViewWidth();

    public int getViewHeight();

    public String getViewTitle();

    public ObjectNode getOpenViewParam();

    public int getAccUserMode();

    public String getAccessKey();

    public String getPSPDTAppFuncId();

    public String getHtmlPageUrl();

    public String getJSCode();

    public IPSLanguageRes getNamePSLanguageRes();

    public String getTooltip();

    public IPSLanguageRes getTooltipPSLanguageRes();
}

