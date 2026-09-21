/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Properties;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRefRuntime;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewRefImpl
extends PSObjectImpl
implements IPSAppViewRef,
IPSAppViewRefRuntime {
    private static final Log log = LogFactory.getLog(PSAppViewRefImpl.class);
    public static final String EMBEDVIEWID = "EMBEDVIEWID";
    public static final String MINORPSDEVIEWBASEID = "MINORPSDEVIEWBASEID";
    public static final String TRYMODE = "TRYMODE";
    protected PSAppViewRef psAppViewRef = null;
    protected IPSAppView iPSAppView = null;
    protected IPSAppView refPSAppView = null;
    protected String strEmbedId = "";
    private ObjectNode viewParam = null;
    private ObjectNode parentModeJO = null;
    private ObjectNode parentDataJO = null;
    private int nWidth = -1;
    private int nHeight = -1;
    private String strRefModeDesc = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSAppView iPSAppView, PSAppViewRef psAppViewRef) throws Exception {
        try {
            Properties viewParams;
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSAppView = iPSAppView;
            this.psAppViewRef = psAppViewRef;
            this.setId(this.psAppViewRef.getPSAPPVIEWREFID());
            this.setName(this.psAppViewRef.getPSAPPVIEWREFNAME());
            this.setPSObjectData(this.psAppViewRef);
            this.strEmbedId = this.psAppViewRef.getParamStringValue(EMBEDVIEWID, "");
            this.strRefModeDesc = this.psAppViewRef.getREFMODETEXT();
            if (!this.psAppViewRef.isWIDTHNull()) {
                this.nWidth = this.psAppViewRef.getWIDTH();
            }
            if (!this.psAppViewRef.isHEIGHTNull()) {
                this.nHeight = this.psAppViewRef.getHEIGHT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppViewRef.getVIEWPARAMS()) && (viewParams = PropertiesHelper.load((String)this.psAppViewRef.getVIEWPARAMS())) != null) {
                for (Object objKey : viewParams.keySet()) {
                    String strKey = objKey.toString();
                    this.getViewParam(true).put(strKey.toLowerCase(), PropertiesHelper.getProperty((Properties)viewParams, (String)strKey));
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

    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public String getRefPSAppViewId() {
        return this.psAppViewRef.getMINORPSAPPVIEWID();
    }

    @PSModelRTMeta(description="\u6253\u5f00\u6a21\u5f0f")
    public String getOpenMode() {
        return this.psAppViewRef.getOPENMODE();
    }

    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe")
    public IPSAppView getRefPSAppView() throws Exception {
        if (this.refPSAppView == null) {
            String strMinorPSDEViewId = this.psAppViewRef.getParamStringValue(MINORPSDEVIEWBASEID, null);
            boolean bTryMode = this.psAppViewRef.getParamBoolValue(TRYMODE, false);
            this.refPSAppView = ((IPSApplicationRuntime)this.iPSAppView.getPSApplication()).getPSAppView(this.getRefPSAppViewId(), strMinorPSDEViewId, bTryMode, this.iPSAppView);
            if (this.refPSAppView != null) {
                String strOpenMode = this.refPSAppView.getOpenMode((IPSAppViewRef)this);
                if (StringHelper.compare((String)strOpenMode, (String)"POPUP", (boolean)true) == 0 || StringHelper.compare((String)strOpenMode, (String)"POPUPMODAL", (boolean)true) == 0) {
                    ((IPSAppViewRuntime)this.refPSAppView).markViewUsage(2, this);
                } else {
                    ((IPSAppViewRuntime)this.refPSAppView).markViewUsage(1, this);
                }
            }
        }
        return this.refPSAppView;
    }

    public void setRefPSAppView(IPSAppView refPSAppView) {
        this.refPSAppView = refPSAppView;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSAppView).getPSSysModelInstId();
    }

    public String getEmbedId() {
        return this.strEmbedId;
    }

    public void setEmbedId(String strEmbedId) {
        this.strEmbedId = strEmbedId;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u9ad8\u5ea6")
    public int getHeight() {
        return this.nHeight;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u5bbd\u5ea6")
    public int getWidth() {
        return this.nWidth;
    }

    public synchronized ObjectNode getViewParam(boolean bCreate) {
        if (this.viewParam == null && bCreate) {
            this.viewParam = JsonNodeHelper.createObjectNode();
        }
        return this.viewParam;
    }

    public ObjectNode getViewParam() {
        return this.getViewParam(false);
    }

    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u6807\u9898")
    public String getRealTitle() throws Exception {
        return this.getRefPSAppView().getTitle((IPSAppViewRef)this);
    }

    public int getRealWidth(int nDefault) throws Exception {
        int nWidth = this.getRefPSAppView().getWidth((IPSAppViewRef)this);
        if (nWidth <= 0) {
            return nDefault;
        }
        return nWidth;
    }

    public int getRealHeight(int nDefault) throws Exception {
        int nHeight = this.getRefPSAppView().getHeight((IPSAppViewRef)this);
        if (nHeight <= 0) {
            return nDefault;
        }
        return nHeight;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u6253\u5f00\u6a21\u5f0f")
    public String getRealOpenMode() throws Exception {
        return this.getRefPSAppView().getOpenMode((IPSAppViewRef)this);
    }

    public ObjectNode getViewParamJO(boolean bCreate) {
        return this.getViewParam(bCreate);
    }

    public ObjectNode getViewParamJO() {
        return this.getViewParam();
    }

    public ObjectNode getParentModeJO(boolean bCreate) {
        if (this.parentModeJO == null && bCreate) {
            this.parentModeJO = JsonNodeHelper.createObjectNode();
        }
        return this.parentModeJO;
    }

    public ObjectNode getParentModeJO() {
        return this.getParentModeJO(false);
    }

    public ObjectNode getParentDataJO(boolean bCreate) {
        if (this.parentDataJO == null && bCreate) {
            this.parentDataJO = JsonNodeHelper.createObjectNode();
        }
        return this.parentDataJO;
    }

    public ObjectNode getParentDataJO() {
        return this.getParentDataJO(false);
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWREF";
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f", order=100)
    public String getName() {
        return super.getName();
    }

    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f\u8bf4\u660e", order=110)
    public String getRefModeDesc() {
        return this.strRefModeDesc;
    }

    public String getRealTitleLanResTag() throws Exception {
        return null;
    }

    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"mode", (Object)this.getName());
        if (this.getRefPSAppView() != null) {
            IPSAppViewRuntime refPSAppView = (IPSAppViewRuntime)this.getRefPSAppView();
            ObjectNode viewNode = JsonNodeHelper.createObjectNode();
            viewNode.put("url", refPSAppView.getPageUrl());
            if (!StringHelper.isNullOrEmpty((String)this.getRealOpenMode())) {
                viewNode.put("OPENMODE", this.getRealOpenMode());
            }
            if (this.getRealHeight(refPSAppView.getHeight()) > 0) {
                viewNode.put("height", this.getRealHeight(refPSAppView.getHeight()));
            }
            if (this.getRealWidth(refPSAppView.getWidth()) > 0) {
                viewNode.put("width", this.getRealWidth(refPSAppView.getWidth()));
            }
            if (refPSAppView.isRedirectView()) {
                viewNode.put("redirectview", true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getRealTitle())) {
                viewNode.put("title", this.getRealTitle());
            }
            JsonNodeHelper.put((ObjectNode)objectNode, (String)"view", (Object)viewNode);
        }
    }
}

