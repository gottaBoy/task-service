/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.func;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.PSApplicationObjectImpl;
import net.ibizsys.model.app.func.IPSAppFuncRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.entity.PSAppFunc;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppFuncImpl
extends PSApplicationObjectImpl
implements IPSAppFuncRuntime {
    private static final Log log = LogFactory.getLog(PSAppFuncImpl.class);
    protected PSAppFunc psAppFunc = null;
    private String strUserData = null;
    private String strUserData2 = null;
    private int nViewWidth = 0;
    private int nViewHeight = 0;
    private String strViewTitle = "";
    private ObjectNode joOpenViewParams = JsonNodeHelper.createObjectNode();
    private Properties openViewParams = null;
    private IPSAppView iPSAppView = null;
    private int nAccUserMode = AccessUserModes.UNKNOWN;
    private String strAccessKey = null;
    private String strHtmlPageUrl = null;
    private String strJSCode = null;
    private String strTooltip = null;
    private IPSLanguageRes namePSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private String strCodeName = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppFunc psAppFunc) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.psAppFunc = psAppFunc;
            this.setId(this.psAppFunc.getPSAPPFUNCID());
            this.setName(this.psAppFunc.getPSAPPFUNCNAME());
            this.setPSObjectData(psAppFunc);
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getUSERDATA())) {
                this.strUserData = this.psAppFunc.getUSERDATA();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getUSERDATA2())) {
                this.strUserData2 = this.psAppFunc.getUSERDATA2();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getPAGEURL())) {
                this.strHtmlPageUrl = this.psAppFunc.getPAGEURL();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getJSCODE())) {
                this.strJSCode = this.psAppFunc.getJSCODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getTOOLTIPINFO())) {
                this.strTooltip = this.psAppFunc.getTOOLTIPINFO();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getCODENAME())) {
                this.strCodeName = this.psAppFunc.getCODENAME();
            }
            this.iPSAppView = this.getPSAppView();
            if (this.iPSAppView != null) {
                this.nViewWidth = this.iPSAppView.getWidth();
                this.nViewHeight = this.iPSAppView.getHeight();
                this.strViewTitle = this.iPSAppView.getTitle();
                this.nAccUserMode = this.iPSAppView.getAccUserMode();
                this.strAccessKey = this.iPSAppView.getAccessKey();
                if (StringHelper.compare((String)this.getOpenMode(), (String)"INDEXVIEWPOPUPMODAL", (boolean)true) == 0 || StringHelper.compare((String)this.getOpenMode(), (String)"INDEXVIEWPOPUP", (boolean)true) == 0) {
                    ((IPSAppViewRuntime)this.iPSAppView).markViewUsage(2, this);
                } else {
                    ((IPSAppViewRuntime)this.iPSAppView).markViewUsage(1, this);
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.strViewTitle)) {
                this.strViewTitle = this.getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getNAMEPSLANRESID())) {
                this.namePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psAppFunc.getNAMEPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppFunc.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psAppFunc.getTIPPSLANRESID());
            }
            this.openViewParams = PropertiesHelper.load((String)this.psAppFunc.getOPENVIEWPARAM());
            if (this.openViewParams != null) {
                for (Object objKey : this.openViewParams.keySet()) {
                    String strKey = objKey.toString();
                    this.joOpenViewParams.put(strKey.toLowerCase(), PropertiesHelper.getProperty((Properties)this.openViewParams, (String)strKey));
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd\u7c7b\u578b", codelist="AppFuncType")
    public String getAppFuncType() {
        return this.psAppFunc.getAPPFUNCTYPE();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (StringHelper.compare((String)this.psAppFunc.getAPPFUNCTYPE(), (String)"APPVIEW", (boolean)true) == 0) {
            relatedAppViewList.add(this.getPSAppView());
        }
    }

    @PSModelRTMeta(description="\u529f\u80fd\u7f16\u53f7")
    public String getFuncSN() {
        return this.psAppFunc.getFUNCSN();
    }

    @PSModelRTMeta(description="\u6253\u5f00\u89c6\u56fe")
    public IPSAppView getPSAppView() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psAppFunc.getPSAPPVIEWID())) {
            return null;
        }
        if (this.iPSAppView == null) {
            this.iPSAppView = this.getPSApplicationRuntime().getPSAppView(this.psAppFunc.getPSAPPVIEWID(), null);
        }
        return this.iPSAppView;
    }

    @PSModelRTMeta(description="\u529f\u80fd\u6253\u5f00\u6a21\u5f0f", codelist="AppFuncOpenMode")
    public String getOpenMode() {
        return this.psAppFunc.getOPENMODE();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e")
    public String getUserData() {
        return this.strUserData;
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e2")
    public String getUserData2() {
        return this.strUserData2;
    }

    public int getViewWidth() {
        return this.nViewWidth;
    }

    public int getViewHeight() {
        return this.nViewHeight;
    }

    public String getViewTitle() {
        return this.strViewTitle;
    }

    @PSModelRTMeta(description="\u6253\u5f00\u89c6\u56fe\u53c2\u6570")
    public ObjectNode getOpenViewParam() {
        return this.joOpenViewParams;
    }

    public int getAccUserMode() {
        return this.nAccUserMode;
    }

    public String getAccessKey() {
        return this.strAccessKey;
    }

    public String getPSPDTAppFuncId() {
        return this.psAppFunc.getPSPDTAPPFUNCID();
    }

    @PSModelRTMeta(description="Html\u5730\u5740")
    public String getHtmlPageUrl() {
        return this.strHtmlPageUrl;
    }

    public String getJSCode() {
        return this.strJSCode;
    }

    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        return this.strTooltip;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }
}

