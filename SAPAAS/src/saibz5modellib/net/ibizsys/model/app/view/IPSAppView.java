/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.view.IView
 */
package net.ibizsys.model.app.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppViewParam;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.control.titlebar.IPSTitleBar;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.paas.view.IView;

public interface IPSAppView
extends IPSApplicationObject,
IPSModelObject,
IPSControlContainer,
IView {
    public static final String VIEWPARAM_UI_CTRL = "UI.CTRL";
    public static final String VIEWPARAM_UI_SHOWCAPTIONBAR = "UI.SHOWCAPTIONBAR";
    public static final int VIEWUSAGE_DEFAULT = 1;
    public static final int VIEWUSAGE_MODAL = 2;
    public static final int VIEWUSAGE_EMBEDED = 4;

    public String getTitle();

    public String getCaption();

    public String getSubCaption();

    public boolean isDynamicView();

    public IPSDataEntity getPSDataEntity();

    public ArrayList<IPSControl> getAllPSControls();

    public ArrayList<IPSAjaxControl> getAllPSAjaxControls();

    public Iterator<IPSUIAction> getPSUIActions();

    public ObjectNode getPSUIActionParamJO(IPSUIAction var1) throws Exception;

    public boolean isRedirectView();

    public boolean isPSDEView();

    @Override
    public IPSControl getPSControl(String var1) throws Exception;

    @Override
    public boolean hasPSControl(String var1);

    @Override
    public Iterator<IPSControl> getPSControls();

    @Override
    public Iterator<IPSAjaxControl> getPSAjaxControls();

    public IPSAppModule getPSAppModule() throws Exception;

    public boolean isEnableDP();

    public int getWidth();

    public int getHeight();

    public IPSAppView getRefPSAppView(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppView> getRefPSAppViews(String var1) throws Exception;

    public IPSAppViewRef getPSAppViewRef(String var1, boolean var2) throws Exception;

    public IPSSysCss getPSSysCss();

    public Iterator<IPSSysCss> getPSSysCsses();

    public Iterator<IPSSysImage> getPSSysImages();

    public String getLanguage();

    public String getBackendUrl();

    public Iterator<String> getAppViewRefModes();

    public Iterator<IPSAppViewRef> getPSAppViewRefs();

    public String getViewIcon();

    public String getTitle(IPSAppViewRef var1);

    public String getCaption(IPSAppViewRef var1);

    public String getOpenMode(IPSAppViewRef var1);

    public int getWidth(IPSAppViewRef var1);

    public int getHeight(IPSAppViewRef var1);

    public String getOpenMode();

    public boolean isEnableViewModel();

    public String getViewModelUrl();

    public boolean isEnableWF();

    public boolean isUserRefMode();

    public boolean isEnableHelp();

    public Iterator<IPSAppViewRef> getEmbeddedPSAppViewRefs(String var1) throws Exception;

    public Iterator<IPSCodeList> getRelatedPSCodeLists(boolean var1) throws Exception;

    public Iterator<IPSCodeList> getAllRelatedPSCodeLists() throws Exception;

    public Iterator<IPSCodeList> getRelatedPSCodeLists() throws Exception;

    public ArrayList<IPSControl> getPSControls(String var1, int var2);

    public String getPageUrl();

    public IPSAppViewParam registerPSAppViewParam(String var1, String var2, String var3) throws Exception;

    public Iterator<IPSAppViewParam> getPSAppViewParams() throws Exception;

    public int getAccUserMode();

    public String getAccessKey();

    public boolean isMobileView();

    public boolean isPickupView();

    public boolean getRefFlag();

    public String getMainMenuAlign();

    public String getTitleLanResTag();

    public String getTitleLanResTag(IPSAppViewRef var1);

    public String getCapLanResTag();

    public String getSubCapLanResTag();

    public boolean isShowCaptionBar();

    public boolean getSysRefFlag();

    public IPSSysImage getPSSysImage();

    public boolean isCustomViewStyle();

    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception;

    public Iterator<IPSAppFunc> getPSAppFuncs();

    public int getButtonNoPrivDisplayMode();

    public IPSTitleBar getPSTitleBar();

    public boolean isEmbeddedView();

    public IPSAjaxHandler getPSAjaxHandler();

    public boolean testViewUsage(int var1);

    public int getViewUsage();

    public IPSViewType getPSViewType();

    public Iterator<IPSSysCounterRef> getPSSysCounterRefs();

    public long getLastModifyTime();

    public String getDynaModelContent() throws Exception;
}

