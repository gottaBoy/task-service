/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.IPSControlXDataContainer
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IView
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlParamRuntime;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSControlImpl
extends PSObjectImpl
implements IPSControl,
IPSControlRuntime {
    private static final Log log = LogFactory.getLog(PSControlImpl.class);
    private IPSControlContainer iPSControlContainer = null;
    private IPSControlTypeRuntime iPSControlType = null;
    private IPSDataEntity iPSDataEntity = null;
    protected IPSControlParam iPSControlParam = null;
    private IPSSysCss iPSSysCss = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private boolean bDesignMode = false;
    private String strUniqueId = "";
    private double fWidth = 0.0;
    private double fHeight = 0.0;
    private int nOrderValue = 99999;
    private IPSControlXDataContainer iPSControlXDataContainer = null;
    private boolean bDefaultCtrl = false;
    private boolean bDynamicCtrl = false;
    private String strLogicName = null;
    private String strDynaViewContent = null;
    private String strDynaModelContent = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSControlContainer(iPSControlContainer);
        this.setName(strName);
        this.iPSControlParam = iPSControlParam;
        this.strUniqueId = this.getPSAppViewRuntime().generateCtrlUniId();
        if (this.iPSControlParam.getWidth() != null) {
            this.fWidth = this.iPSControlParam.getWidth();
        }
        if (this.iPSControlParam.getHeight() != null) {
            this.fHeight = this.iPSControlParam.getHeight();
        }
        if (this.iPSControlParam.isDefaultCtrl() != null) {
            this.bDefaultCtrl = this.iPSControlParam.isDefaultCtrl();
        }
        if (this.getPSAppView() != null && this.getPSAppView().isDynamicView()) {
            this.bDynamicCtrl = true;
        }
        if (this.iPSControlParam.isDynamicCtrl() != null) {
            this.bDynamicCtrl = this.iPSControlParam.isDynamicCtrl();
        }
        if (this.iPSControlParam.getOrderValue() != null) {
            this.nOrderValue = this.iPSControlParam.getOrderValue();
        }
        if (!StringHelper.isNullOrEmpty((String)((IPSControlParamRuntime)this.iPSControlParam).getPSSysPFPluginId())) {
            this.iPSSysPFPlugin = this.getPSSystemRuntime().getPSSysPFPlugin(((IPSControlParamRuntime)this.iPSControlParam).getPSSysPFPluginId());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSControlParam.getPSSysCssId())) {
            this.iPSSysCss = this.getPSSystem().getPSSysCss(this.iPSControlParam.getPSSysCssId());
            if (this.getPSAppView() != null) {
                this.getPSAppViewRuntime().registerPSSysCss(this.iPSSysCss);
            }
        }
        this.onInit();
        if (!this.isDesignMode()) {
            this.onCheckControlParam();
        }
    }

    protected void onCheckControlParam() throws Exception {
    }

    public IPSAppView getPSAppView() {
        if (this.iPSControlContainer != null) {
            return this.iPSControlContainer.getPSAppView();
        }
        return null;
    }

    protected IPSAppViewRuntime getPSAppViewRuntime() {
        return (IPSAppViewRuntime)this.getPSAppView();
    }

    public IPSControlParam getPSControlParam() {
        return this.iPSControlParam;
    }

    protected void setPSControlContainer(IPSControlContainer iPSControlContainer) {
        this.iPSControlContainer = iPSControlContainer;
        this.iPSControlXDataContainer = this.iPSControlContainer == null ? null : this.calcPSControlXDataContainer();
    }

    public IPSControlContainer getPSControlContainer() {
        return this.iPSControlContainer;
    }

    public IPSControlXDataContainer getPSControlXDataContainer() {
        return this.iPSControlXDataContainer;
    }

    protected IPSControlXDataContainer calcPSControlXDataContainer() {
        IPSControlContainer iPSControlContainer = this.getPSControlContainer();
        while (true) {
            if (iPSControlContainer instanceof IPSControlXDataContainer) {
                return (IPSControlXDataContainer)iPSControlContainer;
            }
            if (!(iPSControlContainer instanceof IPSControl)) break;
            iPSControlContainer = ((IPSControl)iPSControlContainer).getPSControlContainer();
        }
        return null;
    }

    public IPSControlTypeRuntime getPSControlType() {
        return this.iPSControlType;
    }

    @Override
    public void setPSControlType(IPSControlTypeRuntime iPSControlType) {
        this.iPSControlType = iPSControlType;
    }

    public IView getView() {
        return this.getPSAppView();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        if (this.iPSDataEntity == null && this.getPSAppView() instanceof IPSAppDEView) {
            this.iPSDataEntity = ((IPSAppDEView)this.getPSAppView()).getPSDataEntity();
        }
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    protected IPSDataEntityRuntime getPSDataEntityRuntime() {
        return (IPSDataEntityRuntime)this.getPSDataEntity();
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
    }

    @Override
    public boolean isDesignMode() {
        return this.bDesignMode;
    }

    protected void setDesignMode(boolean bDesignMode) {
        this.bDesignMode = bDesignMode;
    }

    public boolean hasCtrlModel() {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSControlContainer).getPSSysModelInstId();
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
    }

    @PSModelRTMeta(description="\u63a7\u4ef6\u5bbd\u5ea6")
    public double getWidth() {
        return this.fWidth;
    }

    @PSModelRTMeta(description="\u63a7\u4ef6\u9ad8\u5ea6")
    public double getHeight() {
        return this.fHeight;
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    public IPSSystem getPSSystem() {
        if (this.getPSAppView() == null) {
            return null;
        }
        return this.getPSAppView().getPSSystem();
    }

    protected IPSSystemRuntime getPSSystemRuntime() {
        return (IPSSystemRuntime)this.getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @PSModelRTMeta(description="\u90e8\u4ef6\u6837\u5f0f")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    public boolean isDefaultCtrl() {
        return this.bDefaultCtrl;
    }

    public boolean isDynamicCtrl() {
        return this.bDynamicCtrl;
    }

    @Override
    public boolean isEnableCol12ToCol24() {
        if (this.getPSAppView() != null) {
            return this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableCol12ToCol24();
        }
        return false;
    }

    public String getLogicName() {
        return this.strLogicName;
    }

    protected void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)this.getPSSystem();
    }

    public String getControlSubType() {
        return "";
    }

    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"name", (Object)this.getName());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"type", (Object)this.getControlType());
        if (!StringHelper.isNullOrEmpty((String)this.getControlSubType())) {
            JsonNodeHelper.put((ObjectNode)objectNode, (String)"subtype", (Object)this.getControlSubType());
        }
    }

    public String getDynaViewContent() throws Exception {
        IPSPF iPSPF = ((IPSApplicationRuntime)this.getPSAppView().getPSApplication()).getPSPF();
        if (iPSPF.getDynaViewPSPFPubCode() == null) {
            throw new Exception("\u5f53\u524d\u5e94\u7528\u6846\u67b6\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u89c6\u56fe\u53d1\u5e03\u4ee3\u7801\u7c7b\u578b");
        }
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSAppViewRuntime().getPSPFStyle().getPSPFCtrlTempl(this.getPSControlType(), iPSPF.getDynaViewPSPFPubCode());
        if (iPSPFCtrlTempl == null) {
            log.warn((Object)StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u6846\u67b6\u6ca1\u6709\u4e3a\u90e8\u4ef6[%1$s][%2$s]\u6307\u5b9a\u89c6\u56fe\u6a21\u677f", (Object)this.getPSControlType().getId(), (Object)this.getPSControlType().getName()));
            return "";
        }
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this);
        this.strDynaViewContent = iPSGenerateCodeResult.getCode();
        return this.strDynaViewContent;
    }

    public String getDynaModelContent() throws Exception {
        IPSPF iPSPF = ((IPSApplicationRuntime)this.getPSAppView().getPSApplication()).getPSPF();
        if (iPSPF.getDynaModelPSPFPubCode() == null) {
            log.warn((Object)StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u6846\u67b6\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u6a21\u578b\u53d1\u5e03\u4ee3\u7801\u7c7b\u578b"));
            return "";
        }
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSAppViewRuntime().getPSPFStyle().getPSPFCtrlTempl(this.getPSControlType(), iPSPF.getDynaModelPSPFPubCode());
        if (iPSPFCtrlTempl == null) {
            log.warn((Object)StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u6846\u67b6\u6ca1\u6709\u4e3a\u90e8\u4ef6[%1$s][%2$s]\u6307\u5b9a\u6a21\u578b\u6a21\u677f", (Object)this.getPSControlType().getId(), (Object)this.getPSControlType().getName()));
            return "";
        }
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this);
        this.strDynaModelContent = iPSGenerateCodeResult.getCode();
        return this.strDynaModelContent;
    }

    @Override
    public String getPSDynaInstId() {
        if (this.getPSAppViewRuntime() != null) {
            return this.getPSAppViewRuntime().getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }
}

