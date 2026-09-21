/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IView
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPreview;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlPreviewable;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.PSControlAttributeProxy;
import SA.SRFDA.PS.Core.Control.PSControlAttributeProxy4;
import SA.SRFDA.PS.Core.Control.PSControlLogicProxy;
import SA.SRFDA.PS.Core.Control.PSControlLogicProxy2;
import SA.SRFDA.PS.Core.Control.PSControlLogicProxy4;
import SA.SRFDA.PS.Core.Control.PSControlRenderProxy;
import SA.SRFDA.PS.Core.Control.PSControlRenderProxy4;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl3;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPFPubSupportable;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlImpl
extends PSObjectImpl3
implements IPSControl,
IPSControlPreviewable,
IPSPFPubSupportable {
    private static final Log log = LogFactory.getLog(PSControlImpl.class);
    public static final String MODELGROUP_DETAIL = "\u90e8\u4ef6\u5143\u7d20";
    public static final String MODELGROUP_LOGIC = "\u90e8\u4ef6\u903b\u8f91";
    public static final String MODELGROUP_NAV = "\u90e8\u4ef6\u5bfc\u822a";
    public static final String[] MODELGROUPS = new String[]{"\u57fa\u672c", "\u90e8\u4ef6\u5143\u7d20", "\u90e8\u4ef6\u903b\u8f91", "\u90e8\u4ef6\u5bfc\u822a", "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    public static final int MODELORDER_DETAIL = 150;
    public static final int MODELORDER_LOGIC = 200;
    public static final int MODELORDER_NAV = 300;
    public static final int DEFAULTORDERVALUE = 99999;
    public static final String MODELREF_LINK = "LINK";
    public static final String MODELREF_MUSTREF = "MUSTREF";
    public static final String MODEL_SINGLE = "SINGLE";
    public static final String MODELREF_INDIVIDUAL = "INDIVIDUAL";
    private IPSControlContainer iPSControlContainer = null;
    private IPSControlType iPSControlType = null;
    private IPSDataEntity iPSDataEntity = null;
    protected IPSControlParam iPSControlParam = null;
    private IPSSysCss iPSSysCss = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSCtrlMsg iPSCtrlMsg = null;
    private boolean bDesignMode = false;
    private String strUniqueId = "";
    private double fWidth = 0.0;
    private double fHeight = 0.0;
    private int nOrderValue = 99999;
    private IPSControlXDataContainer iPSControlXDataContainer = null;
    private boolean bDefaultCtrl = false;
    private Boolean bDynamicCtrl = null;
    private String strLogicName = null;
    private IPSPF previewPSPF = null;
    private List<IPSControlLogic> psControlLogicList = null;
    private Map<String, ArrayList<IPSControlLogic>> hookEventMap = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSPFPubHelp iPSPFPubHelp = null;
    private List<IPSControlAttribute> psControlAttributeList = null;
    private List<IPSControlRender> psControlRenderList = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        this.setName(strName);
        this.iPSControlParam = iPSControlParam;
        this.strUniqueId = this.getPSAppView() != null ? this.getPSAppView().generateCtrlUniId() : "";
        if (this.iPSControlParam.getWidth() != null) {
            this.fWidth = this.iPSControlParam.getWidth();
        }
        if (this.iPSControlParam.getHeight() != null) {
            this.fHeight = this.iPSControlParam.getHeight();
        }
        if (this.iPSControlParam.isDefaultCtrl() != null) {
            this.bDefaultCtrl = this.iPSControlParam.isDefaultCtrl();
        }
        if (this.iPSControlParam.getOrderValue() != null) {
            this.nOrderValue = this.iPSControlParam.getOrderValue();
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSControlParam.getPSSysPFPluginId())) {
            this.iPSSysPFPlugin = this.getPSApplication() != null ? this.getPSApplication().getPSSysPFPlugin(this.iPSControlParam.getPSSysPFPluginId(), "CONTROL", this.getControlType(), null) : this.getPSSystem().getPSSysPFPlugin(this.iPSControlParam.getPSSysPFPluginId());
            if (this.getPSAppView() != null) {
                this.getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSControlParam.getPSSysCssId())) {
            this.iPSSysCss = this.getPSSystem().getPSSysCss(this.iPSControlParam.getPSSysCssId());
            if (this.getPSAppView() != null) {
                if (this.getPSAppView().getPSPFStyle().isRegisterToContainer()) {
                    this.getPSControlContainer().registerPSSysCss(this.iPSSysCss);
                } else {
                    this.getPSAppView().registerPSSysCss(this.iPSSysCss);
                }
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSControlParam.getPSCtrlMsgId())) {
            this.iPSCtrlMsg = this.getPSSystem().getPSCtrlMsg(this.iPSControlParam.getPSCtrlMsgId());
        }
        if (!this.isDesignMode() && !StringHelper.isNullOrEmpty((String)this.getId()) && this.getId().indexOf("SRFTEMPKEY:") == 0) {
            this.setDesignMode(true);
            if (this.getPreviewPSPF() == null) {
                this.setPreviewPSPF(this.calcPreviewPSPF());
            }
        }
        if (!this.isDesignMode() && this.getPSAppView() instanceof IPSAppViewPreview) {
            this.setDesignMode(((IPSAppViewPreview)((Object)this.getPSAppView())).isDesignMode());
            if (this.isDesignMode() && this.getPreviewPSPF() == null) {
                this.setPreviewPSPF(this.calcPreviewPSPF());
            }
        }
        if (this.iPSDataEntity == null && !StringHelper.isNullOrEmpty((String)this.iPSControlParam.getPSDEId())) {
            this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.iPSControlParam.getPSDEId(), false));
        }
        if (this.getPSDataEntity() != null && this.getPSAppDataEntity() == null) {
            if (this.getPSAppView().getPSAppDataEntity() != null) {
                if (StringHelper.compare((String)this.getPSAppView().getPSAppDataEntity().getPSDE().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) == 0) {
                    this.setPSAppDataEntity(this.getPSAppView().getPSAppDataEntity());
                } else if (this.getPSAppDataEntity() == null) {
                    this.setPSAppDataEntity(this.getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.getPSDataEntity().getId(), true));
                }
            } else {
                this.setPSAppDataEntity(this.getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.getPSDataEntity().getId(), true));
            }
        }
        ServiceWorkHelper.getInstance().execute(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (!StringHelper.isNullOrEmpty((String)PSControlImpl.this.getModelType()) && !StringHelper.isNullOrEmpty((String)PSControlImpl.this.getId())) {
                    String strUniqueTag = String.valueOf(PSControlImpl.this.getPSAppView().getName()) + "_" + PSControlImpl.this.getId();
                    if (!ActionSessionManager.getCurrentSession().registerRecursion(PSControlImpl.this.getModelType(), (Object)strUniqueTag)) {
                        throw new Exception(StringHelper.format((String)"\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u5b58\u5728\u9012\u5f52\u5f15\u7528", (Object)PSControlImpl.this.getPSAppView().getName(), (Object)PSControlImpl.this.getName()));
                    }
                    try {
                        PSControlImpl.this.onInit();
                        ActionSessionManager.getCurrentSession().unregisterRecursion(PSControlImpl.this.getModelType(), (Object)strUniqueTag);
                    }
                    catch (Exception ex) {
                        ActionSessionManager.getCurrentSession().unregisterRecursion(PSControlImpl.this.getModelType(), (Object)strUniqueTag);
                        throw ex;
                    }
                } else {
                    PSControlImpl.this.onInit();
                }
            }
        });
        if (this.isRegisterToPSAppDataEntity() && this.getPSAppDataEntity() != null) {
            this.getPSAppDataEntity().registerPSControl(this);
        }
        if (!this.isDesignMode()) {
            if (this.getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppView().getPSPFStyle().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSAppView(), (Object)this);
                }
            }
            this.registerPSControlLogics();
            this.onCheckControlParam();
        }
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.isPrepareTemplV2logic()) {
            Iterator<? extends IPSControlRender> psControlRenders;
            Iterator<? extends IPSControlLogic> psControlLogics;
            Iterator<? extends IPSControlAction> psControlActions = this.getPSControlActions();
            if (psControlActions != null) {
                while (psControlActions.hasNext()) {
                    IPSControlAction iPSControlAction = psControlActions.next();
                    iPSControlAction.getPSAppDataEntity();
                }
            }
            if ((psControlLogics = this.getAllPSControlLogics()) != null) {
                while (psControlLogics.hasNext()) {
                    IPSControlLogic iPSControlLogic = psControlLogics.next();
                    iPSControlLogic.getPSAppDataEntity();
                    iPSControlLogic.getPSAppDEUIAction();
                    if (iPSControlLogic.getPSAppDEUILogic() != null) {
                        iPSControlLogic.getPSAppDEUILogic().check();
                    }
                    iPSControlLogic.getPSAppUILogic();
                    iPSControlLogic.getPSAppViewEngine();
                    iPSControlLogic.getPSAppViewLogic();
                }
            }
            if ((psControlRenders = this.getAllPSControlRenders()) != null) {
                while (psControlRenders.hasNext()) {
                    IPSControlRender iPSControlRender = psControlRenders.next();
                    if (iPSControlRender.getPSLayoutPanel() == null) continue;
                    iPSControlRender.getPSLayoutPanel().check();
                }
            }
        }
        return super.onCheck();
    }

    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        return null;
    }

    /*
     * Unable to fully structure code
     */
    private void registerPSControlLogics() throws Exception {
        block7: {
            map = new LinkedHashMap<String, IPSAppDEUILogicGroupDetail>();
            psAppDEUILogicGroupDetails = this.getPSAppDEUILogicGroupDetails();
            if (psAppDEUILogicGroupDetails != null) {
                while (psAppDEUILogicGroupDetails.hasNext()) {
                    iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                    strName = iPSAppDEUILogicGroupDetail.getName();
                    if (StringHelper.isNullOrEmpty((String)strName) || map.containsKey(strName = strName.toLowerCase())) continue;
                    map.put(strName, iPSAppDEUILogicGroupDetail);
                    this.registerPSAppDEUILogicGroupDetail(iPSAppDEUILogicGroupDetail);
                }
            }
            if (StringHelper.isNullOrEmpty((String)(strPPSDEUILogicGroupId = this.iPSControlParam.getPSDEUILogicGroupId()))) break block7;
            if (this.getPSAppDataEntity() == null) {
                PSControlImpl.log.warn((Object)String.format("\u90e8\u4ef6[%1$s]\u5e94\u7528\u5b9e\u4f53\u65e0\u6548\uff0c\u65e0\u6cd5\u52a0\u8f7d\u90e8\u4ef6\u903b\u8f91\u7ec4", new Object[]{this.getName()}));
                return;
            }
            list = new ArrayList<IPSAppDEUILogicGroup>();
            while (!StringHelper.isNullOrEmpty((String)strPPSDEUILogicGroupId)) {
                parent = this.getPSAppDataEntity().getPSAppDEUILogicGroup(strPPSDEUILogicGroupId);
                if (list.contains(parent)) {
                    throw new Exception(String.format("\u754c\u9762\u903b\u8f91\u7ec4[%1$s]\u51fa\u73b0\u9012\u5f52\u5f15\u7528", new Object[]{parent.getFullName()}));
                }
                list.add(parent);
                strPPSDEUILogicGroupId = parent.getParentPSDEUILogicGroupId();
            }
            for (IPSAppDEUILogicGroup item : list) {
                psAppDEUILogicGroupDetails = item.getPSAppDEUILogicGroupDetails();
                if (psAppDEUILogicGroupDetails != null) ** GOTO lbl35
                continue;
lbl-1000:
                // 1 sources

                {
                    iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                    strName = iPSAppDEUILogicGroupDetail.getName();
                    if (StringHelper.isNullOrEmpty((String)strName) || map.containsKey(strName = strName.toLowerCase())) continue;
                    map.put(strName, iPSAppDEUILogicGroupDetail);
                    this.registerPSAppDEUILogicGroupDetail(iPSAppDEUILogicGroupDetail);
lbl35:
                    // 3 sources

                    ** while (psAppDEUILogicGroupDetails.hasNext())
                }
lbl36:
                // 1 sources

            }
        }
    }

    protected void registerPSAppDEUILogicGroupDetail(IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail) throws Exception {
        if ("CTRLEVENT".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) || "TIMER".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) || "CUSTOM".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) || "ITEMBLANK".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) || "ITEMENABLE".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) || "ITEMVISIBLE".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) || "ITEMDYNACLASS".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
            IPSAppDEUIAction iPSAppDEUIAction = null;
            if (StringHelper.compare((String)iPSAppDEUILogicGroupDetail.getLogicType(), (String)"DEUIACTION", (boolean)true) == 0) {
                IPSDataEntity iPSDataEntity = iPSAppDEUILogicGroupDetail.getPSDataEntity();
                if (iPSDataEntity == null) {
                    iPSDataEntity = this.getPSDataEntity();
                }
                if (iPSDataEntity == null) {
                    throw new Exception("\u5f53\u524d\u5b9e\u4f53\u65e0\u6548");
                }
                IPSAppDataEntity iPSAppDataEntity = this.getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, false);
                iPSAppDEUIAction = iPSAppDataEntity.getPSAppDEUIAction(iPSAppDEUILogicGroupDetail.getPSDEUIActionId(), false, this);
            }
            PSControlLogicProxy2 psControlLogicProxy2 = new PSControlLogicProxy2(this, iPSAppDEUILogicGroupDetail, iPSAppDEUIAction);
            this.registerPSControlLogic(psControlLogicProxy2);
            return;
        }
        if ("RENDER".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
            PSControlRenderProxy psControlRenderProxy = new PSControlRenderProxy(this, iPSAppDEUILogicGroupDetail);
            this.registerPSControlRender(psControlRenderProxy);
            return;
        }
        if ("ATTRIBUTE".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
            PSControlAttributeProxy psControlAttributeProxy = new PSControlAttributeProxy(this, iPSAppDEUILogicGroupDetail);
            this.registerPSControlAttribute(psControlAttributeProxy);
            return;
        }
    }

    protected void onCheckControlParam() throws Exception {
    }

    protected IPSPF calcPreviewPSPF() throws Exception {
        IPSPF iPSPF = this.getPSAppView().getPSApplication().getPSPF();
        if (iPSPF.isUseJITDesignPreview() && !this.getPSApplication().isEnableUIModelEx()) {
            iPSPF = iPSPF.getPSAppType().isMobileApp() ? this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFId()) : this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFId());
        }
        return iPSPF;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe", debugmode=true)
    public IPSAppView getPSAppView() {
        if (this.iPSControlContainer != null) {
            return this.iPSControlContainer.getPSAppView();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u53c2\u6570", child=true, outputdoc="false")
    public IPSControlParam getPSControlParam() {
        return this.onGetPSControlParam();
    }

    protected IPSControlParam onGetPSControlParam() {
        return this.iPSControlParam;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5904\u7406", child=true, outputdoc="false", ignorert=3)
    public IPSControlHandler getPSControlHandler() {
        return this.onGetPSControlHandler();
    }

    protected IPSControlHandler onGetPSControlHandler() {
        return null;
    }

    protected void setPSControlContainer(IPSControlContainer iPSControlContainer) {
        this.iPSControlContainer = iPSControlContainer;
        this.iPSControlXDataContainer = this.iPSControlContainer == null ? null : this.calcPSControlXDataContainer();
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.iPSControlContainer;
    }

    @Override
    public IPSControlXDataContainer getPSControlXDataContainer() {
        return this.iPSControlXDataContainer;
    }

    protected IPSControlXDataContainer calcPSControlXDataContainer() {
        IPSControlContainer iPSControlContainer = this.getPSControlContainer();
        while (true) {
            if (iPSControlContainer instanceof IPSControlXDataContainer) {
                return (IPSControlXDataContainer)((Object)iPSControlContainer);
            }
            if (!(iPSControlContainer instanceof IPSControl)) break;
            iPSControlContainer = ((IPSControl)((Object)iPSControlContainer)).getPSControlContainer();
        }
        return null;
    }

    @Override
    public IPSControlType getPSControlType() {
        return this.iPSControlType;
    }

    @Override
    public void setPSControlType(IPSControlType iPSControlType) {
        this.iPSControlType = iPSControlType;
    }

    public IView getView() {
        return this.getPSAppView();
    }

    @Override
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        if (this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20 && this.getPSAppView() instanceof IPSAppDEView) {
            if (this.isEnableUIModelEx()) {
                return this.getPSApplication().getViewCodeName(((IPSAppDEView)this.getPSAppView()).getPSDEViewCodeName(), this.getName(), null);
            }
            return StringHelper.format((String)"%1$s%2$s", (Object)((IPSAppDEView)this.getPSAppView()).getPSDEViewCodeName(), (Object)this.getName());
        }
        return this.getPSApplication().getViewCodeName(null, this.getName(), null);
    }

    @Override
    public boolean isDesignMode() {
        if (this.bDesignMode) {
            return true;
        }
        Boolean bRet = PSAppViewImpl.getCurrentDesignMode();
        if (bRet == null) {
            return false;
        }
        return bRet;
    }

    protected void setDesignMode(boolean bDesignMode) {
        this.bDesignMode = bDesignMode;
    }

    @Override
    public boolean hasCtrlModel() {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSControlContainer.getPSSysModelInstId();
    }

    @Override
    public final String getUniqueId() {
        return this.strUniqueId;
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
    }

    @Override
    @PSModelRTMeta(description="\u63a7\u4ef6\u5bbd\u5ea6", ignoredumpvalues="0.0", outputdoc="(%1$s.getWidth() gt 0)")
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    @PSModelRTMeta(description="\u63a7\u4ef6\u9ad8\u5ea6", ignoredumpvalues="0.0", outputdoc="(%1$s.getHeight() gt 0)")
    public double getHeight() {
        return this.fHeight;
    }

    @Override
    @PSModelRTMeta(description="\u63a7\u4ef6\u6b21\u5e8f", dump=false)
    public int getOrderValue() {
        return this.nOrderValue;
    }

    public IPSSystem getPSSystem() {
        if (this.getPSAppView() == null) {
            return null;
        }
        return this.getPSAppView().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6d88\u606f", child=true)
    public IPSCtrlMsg getPSCtrlMsg() {
        return this.iPSCtrlMsg;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f", dumpref=true)
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u90e8\u4ef6", dump=false)
    public boolean isDefaultCtrl() {
        return this.bDefaultCtrl;
    }

    @Override
    public boolean isDynamicCtrl() {
        if (this.bDynamicCtrl == null) {
            return false;
        }
        return this.bDynamicCtrl;
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    public String getModelId() {
        if (this.getPSAppView() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppView().getId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public String getFullModelName() {
        if (this.getPSAppView() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    @Override
    public boolean isEnableCol12ToCol24() {
        if (this.isDesignMode()) {
            if (this.getPSAppView() != null && this.getPSAppView().getPSApplication().getPFType().indexOf("PREVIEW_") == 0) {
                return true;
            }
            if (StringHelper.compare((String)this.getPreviewPSPF().getFormLayoutMode(), (String)"TABLE_24COL", (boolean)true) != 0) {
                return false;
            }
        }
        if (this.getPSAppView() != null) {
            return this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableCol12ToCol24();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u540d\u79f0", hideempty2=true)
    public String getLogicName() {
        return this.strLogicName;
    }

    protected void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    @Override
    public String getControlSubType() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6837\u5f0f")
    public final String getControlStyle() {
        String strControlSubType = this.getControlSubType();
        if (!StringHelper.isNullOrEmpty((String)strControlSubType)) {
            return strControlSubType;
        }
        if (this.getRender() == null && this.getPSSysPFPlugin() != null && !StringHelper.isNullOrEmpty((String)(strControlSubType = this.getPSSysPFPlugin().getPluginCode()))) {
            return strControlSubType;
        }
        if (this.getPSAppView() == null) {
            return "";
        }
        return this.getPSAppView().getPSApplication().getPSApplicationUI().getDefaultControlStyle();
    }

    @Override
    public IPSPF getPreviewPSPF() {
        return this.previewPSPF;
    }

    protected void setPreviewPSPF(IPSPF previewPSPF) {
        this.previewPSPF = previewPSPF;
    }

    @Override
    public void registerPSControlLogic(IPSControlLogic iPSControlLogic) throws Exception {
        String[] events;
        if (this.psControlLogicList == null) {
            this.psControlLogicList = new ArrayList<IPSControlLogic>();
        }
        iPSControlLogic = new PSControlLogicProxy(this, iPSControlLogic);
        this.psControlLogicList.add(iPSControlLogic);
        String strEventNames = iPSControlLogic.getEventNames();
        if (!StringHelper.isNullOrEmpty((String)strEventNames) && (events = StringHelper.splitEx((String)(strEventNames = strEventNames.toUpperCase()))) != null) {
            String[] stringArray = events;
            int n = events.length;
            int n2 = 0;
            while (n2 < n) {
                String strEvent = stringArray[n2];
                if (!StringHelper.isNullOrEmpty((String)(strEvent = strEvent.trim()))) {
                    ArrayList<IPSControlLogic> list;
                    if (this.hookEventMap == null) {
                        this.hookEventMap = new LinkedHashMap<String, ArrayList<IPSControlLogic>>();
                    }
                    if ((list = this.hookEventMap.get(strEvent)) == null) {
                        list = new ArrayList();
                        this.hookEventMap.put(strEvent, list);
                    }
                    list.add(iPSControlLogic);
                }
                ++n2;
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", hideempty2=true, child=true, group="\u90e8\u4ef6\u903b\u8f91", order=220)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        if (this.isEnableUIModelEx()) {
            Iterator<? extends IPSControlLogic> psControlLogics = this.getAllPSControlLogics();
            if (psControlLogics == null) {
                return null;
            }
            ArrayList<IPSControlLogic> psControlLogicList = null;
            while (psControlLogics.hasNext()) {
                IPSControlLogic iPSControlLogic = psControlLogics.next();
                if ("CTRLEVENT".equals(iPSControlLogic.getTriggerType()) || "TIMER".equals(iPSControlLogic.getTriggerType()) || "CUSTOM".equals(iPSControlLogic.getTriggerType())) {
                    if (psControlLogicList == null) {
                        psControlLogicList = new ArrayList<IPSControlLogic>();
                    }
                    psControlLogicList.add(iPSControlLogic);
                    continue;
                }
                if (!"ITEMBLANK".equals(iPSControlLogic.getTriggerType()) && !"ITEMENABLE".equals(iPSControlLogic.getTriggerType()) && !"ITEMVISIBLE".equals(iPSControlLogic.getTriggerType()) && !"ITEMDYNACLASS".equals(iPSControlLogic.getTriggerType()) || !StringHelper.isNullOrEmpty((String)iPSControlLogic.getItemName())) continue;
                if (psControlLogicList == null) {
                    psControlLogicList = new ArrayList();
                }
                psControlLogicList.add(iPSControlLogic);
            }
            if (psControlLogicList == null || psControlLogicList.size() == 0) {
                return null;
            }
            return psControlLogicList.iterator();
        }
        return this.getAllPSControlLogics();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5168\u90e8\u903b\u8f91\u96c6\u5408", hideempty2=true)
    public Iterator<? extends IPSControlLogic> getAllPSControlLogics() {
        return this.onGetAllPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetAllPSControlLogics() {
        if (this.psControlLogicList == null || this.psControlLogicList.size() == 0) {
            return null;
        }
        return this.psControlLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u4e8b\u4ef6\u540d\u79f0\u96c6\u5408", hideempty2=true, child=true, rtname="hookEventNames", ignorert=3)
    public Iterator<String> getHookEventNames() {
        if (this.hookEventMap == null || this.hookEventMap.size() == 0) {
            return null;
        }
        return this.hookEventMap.keySet().iterator();
    }

    @Override
    public Iterator<? extends IPSControlLogic> getPSControlLogics(String strEventName) {
        if (this.hookEventMap == null) {
            return null;
        }
        ArrayList<IPSControlLogic> list = this.hookEventMap.get(strEventName.toUpperCase());
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", hideempty2=true, child=true, group="\u90e8\u4ef6\u903b\u8f91", order=222)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        Iterator<? extends IPSControlAttribute> psControlAttributes = this.getAllPSControlAttributes();
        if (psControlAttributes == null) {
            return null;
        }
        ArrayList<IPSControlAttribute> psControlAttributeList = null;
        while (psControlAttributes.hasNext()) {
            IPSControlAttribute iPSControlAttribute = psControlAttributes.next();
            if (!StringHelper.isNullOrEmpty((String)iPSControlAttribute.getItemName())) continue;
            if (psControlAttributeList == null) {
                psControlAttributeList = new ArrayList<IPSControlAttribute>();
            }
            psControlAttributeList.add(iPSControlAttribute);
        }
        if (psControlAttributeList == null || psControlAttributeList.size() == 0) {
            return null;
        }
        return psControlAttributeList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5168\u90e8\u5c5e\u6027\u6ce8\u5165\u96c6\u5408", hideempty2=true)
    public Iterator<? extends IPSControlAttribute> getAllPSControlAttributes() {
        return this.onGetAllPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetAllPSControlAttributes() {
        if (this.psControlAttributeList == null || this.psControlAttributeList.size() == 0) {
            return null;
        }
        return this.psControlAttributeList.iterator();
    }

    public void registerPSControlAttribute(IPSControlAttribute iPSControlAttribute) throws Exception {
        if (this.psControlAttributeList == null) {
            this.psControlAttributeList = new ArrayList<IPSControlAttribute>();
        }
        this.psControlAttributeList.add(iPSControlAttribute);
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", hideempty2=true, child=true, group="\u90e8\u4ef6\u903b\u8f91", order=223)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        Iterator<? extends IPSControlRender> psControlRenders = this.getAllPSControlRenders();
        if (psControlRenders == null) {
            return null;
        }
        ArrayList<IPSControlRender> psControlRenderList = null;
        while (psControlRenders.hasNext()) {
            IPSControlRender iPSControlRender = psControlRenders.next();
            if (!StringHelper.isNullOrEmpty((String)iPSControlRender.getItemName())) continue;
            if (psControlRenderList == null) {
                psControlRenderList = new ArrayList<IPSControlRender>();
            }
            psControlRenderList.add(iPSControlRender);
        }
        if (psControlRenderList == null || psControlRenderList.size() == 0) {
            return null;
        }
        return psControlRenderList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5168\u90e8\u7ed8\u5236\u5668\u96c6\u5408", hideempty2=true)
    public Iterator<? extends IPSControlRender> getAllPSControlRenders() {
        return this.onGetAllPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetAllPSControlRenders() {
        if (this.psControlRenderList == null || this.psControlRenderList.size() == 0) {
            return null;
        }
        return this.psControlRenderList.iterator();
    }

    public void registerPSControlRender(IPSControlRender iPSControlRender) throws Exception {
        if (this.psControlRenderList == null) {
            this.psControlRenderList = new ArrayList<IPSControlRender>();
        }
        this.psControlRenderList.add(iPSControlRender);
    }

    @Override
    public Iterator<? extends IPSControlAttribute> getPSControlAttributesByItemName(String strItemName) {
        Iterator<? extends IPSControlAttribute> psControlAttributes = this.getAllPSControlAttributes();
        if (psControlAttributes == null) {
            return null;
        }
        ArrayList<IPSControlAttribute> psControlAttributeList = null;
        while (psControlAttributes.hasNext()) {
            IPSControlAttribute iPSControlAttribute = psControlAttributes.next();
            if (StringHelper.isNullOrEmpty((String)iPSControlAttribute.getItemName()) || StringHelper.compare((String)iPSControlAttribute.getItemName(), (String)strItemName, (boolean)true) != 0) continue;
            if (psControlAttributeList == null) {
                psControlAttributeList = new ArrayList<IPSControlAttribute>();
            }
            psControlAttributeList.add(iPSControlAttribute);
        }
        if (psControlAttributeList == null || psControlAttributeList.size() == 0) {
            return null;
        }
        return psControlAttributeList.iterator();
    }

    @Override
    public Iterator<? extends IPSControlRender> getPSControlRendersByItemName(String strItemName) {
        Iterator<? extends IPSControlRender> psControlRenders = this.getAllPSControlRenders();
        if (psControlRenders == null) {
            return null;
        }
        ArrayList<IPSControlRender> psControlRenderList = null;
        while (psControlRenders.hasNext()) {
            IPSControlRender iPSControlRender = psControlRenders.next();
            if (StringHelper.isNullOrEmpty((String)iPSControlRender.getItemName()) || StringHelper.compare((String)iPSControlRender.getItemName(), (String)strItemName, (boolean)true) != 0) continue;
            if (psControlRenderList == null) {
                psControlRenderList = new ArrayList<IPSControlRender>();
            }
            psControlRenderList.add(iPSControlRender);
        }
        if (psControlRenderList == null || psControlRenderList.size() == 0) {
            return null;
        }
        return psControlRenderList.iterator();
    }

    @Override
    public Iterator<? extends IPSControlLogic> getPSControlLogicsByItemName(String strItemName) {
        Iterator<? extends IPSControlLogic> psControlLogics = this.getAllPSControlLogics();
        if (psControlLogics == null) {
            return null;
        }
        ArrayList<IPSControlLogic> psControlLogicList = null;
        while (psControlLogics.hasNext()) {
            IPSControlLogic iPSControlLogic = psControlLogics.next();
            if (StringHelper.isNullOrEmpty((String)iPSControlLogic.getItemName()) || !"ITEMBLANK".equals(iPSControlLogic.getTriggerType()) && !"ITEMENABLE".equals(iPSControlLogic.getTriggerType()) && !"ITEMVISIBLE".equals(iPSControlLogic.getTriggerType()) && !"ITEMDYNACLASS".equals(iPSControlLogic.getTriggerType()) || StringHelper.compare((String)iPSControlLogic.getItemName(), (String)strItemName, (boolean)true) != 0) continue;
            if (psControlLogicList == null) {
                psControlLogicList = new ArrayList<IPSControlLogic>();
            }
            psControlLogicList.add(iPSControlLogic);
        }
        if (psControlLogicList == null || psControlLogicList.size() == 0) {
            return null;
        }
        return psControlLogicList.iterator();
    }

    @Override
    public boolean isRegisterToPSAppDataEntity() {
        if (this.getPSAppView() == null) {
            return false;
        }
        return this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    public boolean isPrepareDefaultPSAppViewLogics() {
        if (this.getPSAppView() == null) {
            return false;
        }
        return this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    public boolean isPrepareTemplV2logic() {
        if (this.getPSAppView() == null) {
            return false;
        }
        return this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    public Object getCtrlParam(String strParamName) {
        if (this.getPSControlParam() == null) {
            return null;
        }
        return this.getPSControlParam().getCtrlParam(strParamName);
    }

    @Override
    public boolean containsCtrlParam(String strParamName) {
        if (this.getPSControlParam() == null) {
            return false;
        }
        return this.getPSControlParam().containsCtrlParam(strParamName);
    }

    @Override
    public String getCtrlParam(String strParamName, String strDefault) {
        if (this.getPSControlParam() == null) {
            return strDefault;
        }
        return this.getPSControlParam().getCtrlParam(strParamName, strDefault);
    }

    @Override
    public boolean getCtrlParam(String strParamName, boolean bDefault) {
        if (this.getPSControlParam() == null) {
            return bDefault;
        }
        return this.getPSControlParam().getCtrlParam(strParamName, bDefault);
    }

    @Override
    public int getCtrlParam(String strParamName, int nDefault) {
        if (this.getPSControlParam() == null) {
            return nDefault;
        }
        return this.getPSControlParam().getCtrlParam(strParamName, nDefault);
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570\u96c6\u5408")
    public Iterator<String> getCtrlParamNames() {
        if (this.getPSControlParam() == null) {
            return null;
        }
        return this.getPSControlParam().getCtrlParamNames();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0")
    public String getUserTag() {
        if (this.getPSControlParam() == null) {
            return null;
        }
        return this.getPSControlParam().getUserTag();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02")
    public String getUserTag2() {
        if (this.getPSControlParam() == null) {
            return null;
        }
        return this.getPSControlParam().getUserTag2();
    }

    @Override
    public String getPSDynaModelId() {
        if (this.getPSControlParam() == null) {
            return null;
        }
        return this.getPSControlParam().getPSDynaModelId();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    public String getPreviewHtml() {
        if (!this.isDesignMode() || this.getPSSysPFPlugin() == null) {
            return null;
        }
        return this.getPSSysPFPlugin().getPreviewHtml();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    protected void setPSAppDataEntity(IPSAppDataEntity iPSAppDataEntity) {
        this.iPSAppDataEntity = iPSAppDataEntity;
    }

    @Override
    public Iterator<? extends IPSControlAction> getPSControlActions() {
        return null;
    }

    @Override
    public IPSControlAction getUserPSControlAction() {
        return null;
    }

    @Override
    public IPSControlAction getUser2PSControlAction() {
        return null;
    }

    public IPSApplication getPSApplication() {
        if (this.getPSAppView() != null) {
            return this.getPSAppView().getPSApplication();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        if (this.getPSAppView() != null) {
            return KeyValueHelper.genUniqueId((String)this.getPSAppView().getDeployId(), (String)this.getName());
        }
        return super.getDeployId();
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        if (this.getPSSystem() != null) {
            return this.getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
        }
        return super.internalGetPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    @PSModelRTMeta(name="[H]\u524d\u7aef\u6a21\u677f\u53d1\u5e03\u5e2e\u52a9", hideempty=true)
    public IPSPFPubHelp getPSPFPubHelp() {
        block4: {
            try {
                if (!PSTemplHelper.isBusy()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.iPSPFPubHelp != null) {
            return this.iPSPFPubHelp;
        }
        LinkedHashMap<String, IPSCodePublisherParam> publisherParamMap = new LinkedHashMap<String, IPSCodePublisherParam>();
        this.iPSPFPubHelp = PSPFCtrlPubHelpImpl.createPSPFPubHelp(this, publisherParamMap);
        return this.iPSPFPubHelp;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (!StringHelper.isNullOrEmpty((String)this.getDynaModelFilePath())) {
            objectNode.remove("name");
        }
        if (StringHelper.compare((String)strModelType, (String)MODEL_SINGLE, (boolean)true) != 0) {
            if (!objectNode.has("name")) {
                PSControlImpl.putJsonProperty(objectNode, "name", this.getName().toLowerCase());
            }
        } else {
            objectNode.remove("getPSControlParam");
            objectNode.remove("getPSControlHandler");
        }
        if (!(objectNode.has("modelid") || StringHelper.isNullOrEmpty((String)this.getId()) || this.getId().equals("SRFCURRENTVIEW"))) {
            PSControlImpl.putJsonProperty(objectNode, "modelid", this.getId());
            PSControlImpl.putJsonProperty(objectNode, "modeltype", this.getModelType());
        }
    }

    @Override
    public ObjectNode toModelRef(String strType) {
        if (StringHelper.compare((String)MODELREF_LINK, (String)strType, (boolean)true) == 0) {
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            objectNode.put("name", this.getName().toLowerCase());
            return objectNode;
        }
        if (StringHelper.compare((String)"IGNOREDESIGN", (String)strType, (boolean)true) == 0 && this.isDesignMode()) {
            return this.toModel(null);
        }
        if (this.isExportModelAlways() && StringHelper.compare((String)MODELREF_MUSTREF, (String)strType, (boolean)true) != 0) {
            return this.toModel(strType);
        }
        return super.toModelRef(strType);
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        if (!MODELREF_INDIVIDUAL.equals(strModelRefType)) {
            ObjectNode objNode;
            if (!objectNode.has("name")) {
                PSControlImpl.putJsonProperty(objectNode, "name", this.getName().toLowerCase());
            }
            if (this.getPSControlParam() != null) {
                objNode = this.getPSControlParam().getModel();
                PSControlImpl.putJsonProperty(objectNode, "getPSControlParam", objNode);
            }
            if (this.getPSControlHandler() != null) {
                objNode = this.getPSControlHandler().getModel();
                PSControlImpl.putJsonProperty(objectNode, "getPSControlHandler", objNode);
            }
        }
        objectNode.put("controlType", this.getControlType());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6587\u4ef6\u8def\u5f84", hideempty=true)
    public String getDynaModelFilePath() {
        if (this.isExportModelAlways()) {
            return null;
        }
        if (!this.isEnableDynaModel()) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)this.getDynaModelTag())) {
            return null;
        }
        return String.format("%1$s/%2$s.json", this.getDynaModelFolder(), this.getDynaModelTag());
    }

    @Override
    protected boolean isExportModelAlways() {
        return false;
    }

    protected Boolean getDynamicCtrl() {
        return this.bDynamicCtrl;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", dump=false, codelist="DynaInstMode3")
    public int getDynaInstMode() {
        if (this.getPSApplication() != null && this.getPSApplication().getDynaInstMode() == 0) {
            return 0;
        }
        return this.onGetDynaInstMode();
    }

    @Override
    protected int onGetDynaInstMode() {
        if (this.getDynamicCtrl() != null) {
            if (this.isDynamicCtrl()) {
                if (this.getPSAppDataEntity() != null && this.getPSApplication().getDynaInstMode() == 0) {
                    return 0;
                }
                return 1;
            }
            return 0;
        }
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getDynaInstMode();
        }
        return 0;
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        if (this.getDynamicCtrl() != null) {
            return this.isDynamicCtrl();
        }
        return true;
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSAppDataEntity() != null) {
            String strDynaModelFolder = this.getPSAppDataEntity().getDynaModelFolder();
            if (StringHelper.isNullOrEmpty((String)strDynaModelFolder)) {
                return null;
            }
            return String.format("%1$s/PS%2$s", strDynaModelFolder, Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase());
        }
        if (this.getPSAppView() != null) {
            String strDynaModelFolder = this.getPSAppView().getDynaModelFolder();
            if (StringHelper.isNullOrEmpty((String)strDynaModelFolder)) {
                return null;
            }
            return String.format("%1$s/PS%2$s", strDynaModelFolder, Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase());
        }
        if (this.getPSApplication() != null) {
            String strDynaModelFolder = this.getPSApplication().getDynaModelFolder();
            if (StringHelper.isNullOrEmpty((String)strDynaModelFolder)) {
                return null;
            }
            return String.format("%1$s/PS%2$s", strDynaModelFolder, Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    public String getDumpModelType() {
        return this.getControlType();
    }

    protected boolean isNeedFillPSACHandlerData() {
        return false;
    }

    protected void fillPSACHandlerData(PSACHandler psACHandler) throws Exception {
    }

    @Override
    public String getModelScope() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7c7b\u578b", codelist="CtrlType", group="\u57fa\u672c", order=125)
    public String getControlType() {
        return this.onGetControlType();
    }

    protected String onGetControlType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u90e8\u4ef6", dump=false, hideempty=true)
    public IPSControl getRefPSControl() throws Exception {
        if (this.getPSControlParam() == null || StringHelper.isNullOrEmpty((String)this.getPSControlParam().getRefCtrlName())) {
            return null;
        }
        if (StringHelper.compare((String)this.getPSControlParam().getRefCtrlName(), (String)this.getName(), (boolean)true) == 0) {
            throw new Exception(String.format("\u5f15\u7528\u90e8\u4ef6\u4e0d\u80fd\u4e3a\u81ea\u5df1", new Object[0]));
        }
        return this.getPSControlContainer().getPSControl(this.getPSControlParam().getRefCtrlName());
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u90e8\u4ef62", dump=false, hideempty=true)
    public IPSControl getRefPSControl2() throws Exception {
        if (this.getPSControlParam() == null || StringHelper.isNullOrEmpty((String)this.getPSControlParam().getRefCtrl2Name())) {
            return null;
        }
        if (StringHelper.compare((String)this.getPSControlParam().getRefCtrl2Name(), (String)this.getName(), (boolean)true) == 0) {
            throw new Exception(String.format("\u5f15\u7528\u90e8\u4ef6\u4e0d\u80fd\u4e3a\u81ea\u5df1", new Object[0]));
        }
        return this.getPSControlContainer().getPSControl(this.getPSControlParam().getRefCtrl2Name());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5b89\u88c5\u754c\u9762\u5f15\u64ce", dump=false, hideempty2=true)
    public String getInstallUIEngine() {
        if (this.getPSControlParam() == null) {
            return null;
        }
        return this.getPSControlParam().getInstallUIEngine();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5b89\u88c5\u754c\u9762\u5f15\u64ce", dump=false, hideempty2=true)
    public String getInstallUIEngine2() {
        if (this.getPSControlParam() == null) {
            return null;
        }
        return this.getPSControlParam().getInstallUIEngine2();
    }

    @Override
    protected String onGetMOSFolder() {
        String strRootPath = "";
        if (this.getPSDataEntity() != null && StringHelper.isNullOrEmpty((String)(strRootPath = this.getPSDataEntity().getMOSFilePath()))) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)strRootPath)) {
            return String.valueOf(strRootPath) + "/" + Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFileName() {
        return this.getName();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getCodeName();
    }

    @Override
    protected String onGetRTMOSFolder() {
        String strRootPath = "";
        if (this.getPSAppView() != null) {
            strRootPath = this.getPSAppView().getRTMOSFilePath();
        } else if (this.getPSAppDataEntity() != null) {
            strRootPath = this.getPSAppDataEntity().getRTMOSFilePath();
        } else if (this.getPSApplication() != null) {
            strRootPath = this.getPSApplication().getRTMOSFilePath();
        }
        if (!StringHelper.isNullOrEmpty((String)strRootPath)) {
            return String.valueOf(strRootPath) + "/" + Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
        }
        return super.onGetRTMOSFolder();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSAppView() != null) {
            return this.getPSAppView();
        }
        return this.getPSApplication();
    }

    @Override
    public boolean isIndividualCtrl() {
        return !this.isExportModelAlways();
    }

    @Override
    public boolean isEnableUIModelEx() {
        if (this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().isEnableUIModelEx();
        }
        return false;
    }

    @Override
    public String getRTMOSModelType() {
        if (this.getPSAppView() != null) {
            return "PSAPPVIEWCTRL";
        }
        return this.getModelType();
    }

    @Override
    public void registerPSControlLogic(IPSAppViewLogic iPSAppViewLogic) throws Exception {
        if (StringHelper.isNullOrEmpty((String)iPSAppViewLogic.getPSViewCtrlName()) || StringHelper.compare((String)iPSAppViewLogic.getPSViewCtrlName(), (String)this.getName(), (boolean)true) == 0) {
            if ("ITEMBLANK".equals(iPSAppViewLogic.getLogicTrigger()) || "ITEMENABLE".equals(iPSAppViewLogic.getLogicTrigger()) || "ITEMVISIBLE".equals(iPSAppViewLogic.getLogicTrigger()) || "ITEMDYNACLASS".equals(iPSAppViewLogic.getLogicTrigger())) {
                PSControlLogicProxy4 psControlLogicProxy4 = new PSControlLogicProxy4(this, iPSAppViewLogic);
                this.registerPSControlLogic(psControlLogicProxy4);
                return;
            }
            if ("RENDER".equals(iPSAppViewLogic.getLogicTrigger())) {
                PSControlRenderProxy4 psControlRenderProxy = new PSControlRenderProxy4(this, iPSAppViewLogic);
                this.registerPSControlRender(psControlRenderProxy);
                return;
            }
            if ("ATTRIBUTE".equals(iPSAppViewLogic.getLogicTrigger())) {
                PSControlAttributeProxy4 psControlAttributeProxy = new PSControlAttributeProxy4(this, iPSAppViewLogic);
                this.registerPSControlAttribute(psControlAttributeProxy);
                return;
            }
        }
        log.warn((Object)String.format("\u672a\u652f\u6301\u7684\u5e94\u7528\u89c6\u56fe\u903b\u8f91[%1$s][%2$s]", iPSAppViewLogic.getName(), iPSAppViewLogic.getLogicTrigger()));
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="ControlDynaSysMode", ignoredumpvalues="0")
    public int getDynaSysMode() {
        if (this.getPSControlParam() == null || this.getPSControlParam().getDynaSysMode() == null) {
            return 0;
        }
        return this.getPSControlParam().getDynaSysMode();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u4f18\u5148\u7ea7", codelist="ControlPriority", ignoredumpvalues="-1")
    public int getPriority() {
        if (this.onGetPriority() == null) {
            return -1;
        }
        return this.onGetPriority();
    }

    protected Integer onGetPriority() {
        if (this.getPSControlParam() == null || this.getPSControlParam().getPriority() == null) {
            return -1;
        }
        return this.getPSControlParam().getPriority();
    }
}

