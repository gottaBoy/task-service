/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.view.IPSAppIndexView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterRef
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.app.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppIndexView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.PSAppViewImpl;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.PSAppMenuParamImpl;
import net.ibizsys.model.entity.PSAppIndexView;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSAppIndexViewImpl
extends PSAppViewImpl
implements IPSAppIndexView {
    protected PSAppIndexView psAppIndexView = new PSAppIndexView();
    protected IPSAppMenu iPSAppMenu = null;
    protected boolean bDefaultPage = false;
    private IPSSysCounterRef portalPSSysCounterRef = null;
    public static final String CTRL_APPMENU = "appmenu";
    private String strMainMenuAlign = "";
    private IPSAppView defPSAppView = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppIndexView(this.psApplicationView.getPSAPPVIEWID(), this.psAppIndexView);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u9996\u9875\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        boolean bDynaCtrl = false;
        String strPSAppMenuId = this.psAppIndexView.getPSAPPMENUID();
        if (this.getPSDynaAppViewData() != null && !StringHelper.isNullOrEmpty((String)this.getPSDynaAppViewData().getPSAPPMENUID())) {
            strPSAppMenuId = this.getPSDynaAppViewData().getPSAPPMENUID();
            bDynaCtrl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)strPSAppMenuId)) {
            PSAppMenuParamImpl psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(strPSAppMenuId);
            if (bDynaCtrl) {
                psAppMenuParamImpl.setDynamicCtrl(true);
            }
            this.iPSAppMenu = (IPSAppMenu)this.registerPSControl(CTRL_APPMENU, "APPMENU", psAppMenuParamImpl);
        }
        if (!this.psAppIndexView.isDEFAULTPAGENull()) {
            this.bDefaultPage = this.psAppIndexView.getDEFAULTPAGE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAppIndexView.getDEFPSAPPVIEWID())) {
            this.defPSAppView = this.getPSApplicationRuntime().getPSAppView(this.psAppIndexView.getDEFPSAPPVIEWID(), "", this);
        }
        this.portalPSSysCounterRef = this.preparePortalPSSysCounterRef();
        this.strMainMenuAlign = this.psAppIndexView.getMAINMENUSIDE();
    }

    protected IPSSysCounterRef preparePortalPSSysCounterRef() throws Exception {
        if (this.psAppIndexView.isENABLECOUNTERNull() || this.psAppIndexView.getENABLECOUNTER()) {
            String strPortalCounterId = this.psAppIndexView.getPSSYSCOUNTERID();
            IPSSysCounter iPSSysCounter = null;
            if (StringHelper.isNullOrEmpty((String)strPortalCounterId)) {
                strPortalCounterId = KeyValueHelper.genUniqueId((String)this.getPSAppView().getPSApplication().getPSSystem().getId(), (String)"PORTAL");
                iPSSysCounter = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCounter(strPortalCounterId, true);
            } else {
                iPSSysCounter = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCounter(strPortalCounterId, false);
            }
            if (iPSSysCounter != null) {
                ObjectNode refModeObj = JsonNodeHelper.createObjectNode();
                return this.getPSAppViewRuntime().registerPSSysCounter(iPSSysCounter, refModeObj);
            }
        }
        return null;
    }

    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return true;
    }

    public boolean isEnableWF() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5e94\u7528\u529f\u80fd\u96c6\u5408", hideempty=true)
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        if (this.iPSAppMenu == null) {
            return null;
        }
        return this.iPSAppMenu.getPSAppFuncs();
    }

    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u5bf9\u8c61", hideempty=true)
    public IPSAppMenu getPSAppMenu() {
        return this.iPSAppMenu;
    }

    @PSModelRTMeta(description="\u5e94\u7528\u8d77\u59cb\u89c6\u56fe")
    public boolean isDefaultPage() {
        return this.bDefaultPage;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84", hideempty2=true)
    public String getAppIconPath() {
        return this.psAppIndexView.getAPPICONPATH();
    }

    public String getAppIconPath2() {
        return this.psAppIndexView.getAPPICONPATH2();
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getAppIconPath())) {
            this.registerPSAppViewParam("UI.APPICONPATH", this.getAppIconPath(), "");
        }
        if (!StringHelper.isNullOrEmpty((String)this.getAppIconPath2())) {
            this.registerPSAppViewParam("UI.APPICONPATH2", this.getAppIconPath2(), "");
        }
        if (!StringHelper.isNullOrEmpty((String)this.getMainMenuAlign())) {
            this.registerPSAppViewParam("UI.MAINMENUALIGN", this.getMainMenuAlign(), "");
        }
        super.onPreparePSAppViewParams();
    }

    @PSModelRTMeta(description="\u95e8\u6237\u8ba1\u6570\u5668\u5f15\u7528", hideempty2=true)
    public IPSSysCounterRef getPortalPSSysCounterRef() {
        return this.portalPSSysCounterRef;
    }

    @Override
    public String getMainMenuAlign() {
        if (StringHelper.isNullOrEmpty((String)this.strMainMenuAlign)) {
            return super.getMainMenuAlign();
        }
        return this.strMainMenuAlign;
    }

    public IPSAppView getDefPSAppView() {
        return this.defPSAppView;
    }

    @Override
    public String getModelType() {
        return "PSAPPINDEXVIEW";
    }

    @Override
    protected boolean isUserRefModeDefault() {
        return true;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.getDefPSAppView() != null) {
            relatedAppViewList.add(this.getDefPSAppView());
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }
}

