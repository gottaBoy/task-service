/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanel;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.PSControlAttributeProxy5;
import SA.SRFDA.PS.Core.Control.PSControlLogicProxy5;
import SA.SRFDA.PS.Core.Control.PSControlRenderProxy5;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDETabViewPanel;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDETabViewPanelParam;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDETabViewPanelRuntime;
import SA.SRFDA.PS.Core.Control.ViewPanel.PSDEViewPanelImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"TABVIEWPANEL"})
public class PSDETabViewPanelImpl
extends PSDEViewPanelImpl
implements IPSDETabViewPanel,
IPSDETabViewPanelRuntime {
    private static final Log log = LogFactory.getLog(PSDETabViewPanelImpl.class);
    private IPSDETabViewPanelParam iPSDETabViewPanelParam = null;
    private IPSSysCounterRef iPSSysCounterRef = null;
    private IPSDERBase navPSDERBase = null;
    private IPSSysImage iPSSysImage = null;
    private JSONObject parentDataJO = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private int nIndex = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDETabViewPanelParam = (IPSDETabViewPanelParam)iPSControlParam;
            this.setId(String.valueOf(iPSControlContainer.getPSAppView().getId()) + "_" + strName);
            this.setName(strName);
            super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        JSONObject parentDataJO;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getNavPSDERId())) {
            this.navPSDERBase = this.getPSSystem().getPSDER(this.getNavPSDERId());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDETabViewPanelParam.getPSSysImageId())) {
            this.iPSSysImage = this.getPSSystem().getPSSysImage(this.iPSDETabViewPanelParam.getPSSysImageId());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDETabViewPanelParam.getPSDEOPPrivId()) && this.getPSDataEntity() != null) {
            this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.iPSDETabViewPanelParam.getPSDEOPPrivId());
        }
        if (this.getNavPSDER() != null && this.getNavPSDER() instanceof IPSDER1N) {
            IPSDER1N iPSDER1N = (IPSDER1N)this.getNavPSDER();
            JSONObject parentDataJO2 = this.getParentDataJO(true);
            parentDataJO2.put("srfparentmode", (Object)iPSDER1N.getName());
            parentDataJO2.put("srfparentdename", (Object)iPSDER1N.getMajorDEName());
            parentDataJO2.put("srfparentdefname", (Object)iPSDER1N.getPickupDEFName());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getNavFilter()) && !(parentDataJO = this.getParentDataJO(true)).has("srfparentdefname")) {
            parentDataJO.put("srfparentdefname", (Object)this.getNavFilter());
        }
        super.onInit();
        this.setPSSysCounterRef(this.preparePSSysCounterRef());
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strExpBarCounterId = this.iPSDETabViewPanelParam.getPSSysCounterId();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strExpBarCounterId)) {
            IPSAppCounter iPSSysCounter = this.getPSAppView().getPSApplication().getPSAppCounter(strExpBarCounterId, false);
            JSONObject refModeObj = new JSONObject();
            if (this.isPrepareDefaultPSAppViewLogics()) {
                return this.getPSControlContainer().registerPSAppCounter(iPSSysCounter, refModeObj);
            }
            return this.getPSAppView().registerPSSysCounter(iPSSysCounter, refModeObj);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6", model="PSDEViewCtrl", fields={"CTRLPARAM3"})
    public String getCounterId() {
        return this.iPSDETabViewPanelParam.getCounterId();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true)
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    @Override
    protected String onGetControlType() {
        return "TABVIEWPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5173\u7cfb\u6807\u8bc6", dump=false)
    public String getNavPSDERId() {
        return this.iPSDETabViewPanelParam.getNavPSDERId();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5173\u7cfb\u5bf9\u8c61", child=true, model="PSDEViewCtrl", fields={"CTRLPARAM2"})
    public IPSDERBase getNavPSDER() {
        return this.navPSDERBase;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u56fe\u6807", model="PSDEViewCtrl", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public JSONObject getParentDataJO(boolean bCreate) {
        if (this.parentDataJO == null && bCreate) {
            this.parentDataJO = new JSONObject();
        }
        return this.parentDataJO;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u7236\u6570\u636e\u5bf9\u8c61")
    public JSONObject getParentDataJO() {
        return this.getParentDataJO(false);
    }

    @Override
    public String getParamJOString() {
        return null;
    }

    @Override
    public String getContextJOString() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u8fc7\u6ee4\u9879", model="PSDEViewCtrl", fields={"CTRLPARAM4"})
    public String getNavFilter() {
        return this.iPSDETabViewPanelParam.getNavFilter();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6")
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    public void setIndex(int nIndex) {
        this.nIndex = nIndex;
    }

    @Override
    public int getIndex() {
        return this.nIndex;
    }

    @Override
    protected Iterator<? extends IPSControlLogic> onGetAllPSControlLogics() {
        IPSControlLogic iPSControlLogic;
        IPSTabExpPanel iPSTabExpPanel;
        Iterator<? extends IPSControlLogic> psControlLogics;
        ArrayList<IPSControlLogic> psControlLogicList = null;
        if (this.getPSControlContainer() instanceof IPSTabExpPanel && (psControlLogics = (iPSTabExpPanel = (IPSTabExpPanel)this.getPSControlContainer()).getAllPSControlLogics()) != null) {
            while (psControlLogics.hasNext()) {
                iPSControlLogic = psControlLogics.next();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSControlLogic.getItemName()) || SA.SRFramework.Utility.StringHelper.Compare((String)this.getName(), (String)iPSControlLogic.getItemName(), (boolean)true) != 0 || "CTRLEVENT".equals(iPSControlLogic.getTriggerType()) || "TIMER".equals(iPSControlLogic.getTriggerType()) || "CUSTOM".equals(iPSControlLogic.getTriggerType())) continue;
                PSControlLogicProxy5 psControlLogicProxy = new PSControlLogicProxy5(this, iPSControlLogic);
                if (psControlLogicList == null) {
                    psControlLogicList = new ArrayList<IPSControlLogic>();
                }
                psControlLogicList.add(psControlLogicProxy);
            }
        }
        if (psControlLogicList == null) {
            return super.onGetAllPSControlLogics();
        }
        Iterator<? extends IPSControlLogic> psControlLogics2 = super.onGetAllPSControlLogics();
        if (psControlLogics2 != null) {
            int nIndex = 0;
            while (psControlLogics2.hasNext()) {
                iPSControlLogic = psControlLogics2.next();
                psControlLogicList.add(nIndex, iPSControlLogic);
                ++nIndex;
            }
        }
        return psControlLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSControlAttribute> onGetAllPSControlAttributes() {
        IPSControlAttribute iPSControlAttribute;
        IPSTabExpPanel iPSTabExpPanel;
        Iterator<? extends IPSControlAttribute> psControlAttributes;
        ArrayList<IPSControlAttribute> psControlAttributeList = null;
        if (this.getPSControlContainer() instanceof IPSTabExpPanel && (psControlAttributes = (iPSTabExpPanel = (IPSTabExpPanel)this.getPSControlContainer()).getAllPSControlAttributes()) != null) {
            while (psControlAttributes.hasNext()) {
                iPSControlAttribute = psControlAttributes.next();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSControlAttribute.getItemName()) || SA.SRFramework.Utility.StringHelper.Compare((String)this.getName(), (String)iPSControlAttribute.getItemName(), (boolean)true) != 0) continue;
                PSControlAttributeProxy5 psControlAttributeProxy = new PSControlAttributeProxy5(this, iPSControlAttribute);
                if (psControlAttributeList == null) {
                    psControlAttributeList = new ArrayList<IPSControlAttribute>();
                }
                psControlAttributeList.add(psControlAttributeProxy);
            }
        }
        if (psControlAttributeList == null) {
            return super.onGetAllPSControlAttributes();
        }
        Iterator<? extends IPSControlAttribute> psControlAttributes2 = super.onGetAllPSControlAttributes();
        if (psControlAttributes2 != null) {
            int nIndex = 0;
            while (psControlAttributes2.hasNext()) {
                iPSControlAttribute = psControlAttributes2.next();
                psControlAttributeList.add(nIndex, iPSControlAttribute);
                ++nIndex;
            }
        }
        return psControlAttributeList.iterator();
    }

    @Override
    protected Iterator<? extends IPSControlRender> onGetAllPSControlRenders() {
        IPSControlRender iPSControlRender;
        IPSTabExpPanel iPSTabExpPanel;
        Iterator<? extends IPSControlRender> psControlRenders;
        ArrayList<IPSControlRender> psControlRenderList = null;
        if (this.getPSControlContainer() instanceof IPSTabExpPanel && (psControlRenders = (iPSTabExpPanel = (IPSTabExpPanel)this.getPSControlContainer()).getAllPSControlRenders()) != null) {
            while (psControlRenders.hasNext()) {
                iPSControlRender = psControlRenders.next();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSControlRender.getItemName()) || SA.SRFramework.Utility.StringHelper.Compare((String)this.getName(), (String)iPSControlRender.getItemName(), (boolean)true) != 0) continue;
                PSControlRenderProxy5 psControlRenderProxy = new PSControlRenderProxy5(this, iPSControlRender);
                if (psControlRenderList == null) {
                    psControlRenderList = new ArrayList<IPSControlRender>();
                }
                psControlRenderList.add(psControlRenderProxy);
            }
        }
        if (psControlRenderList == null) {
            return super.onGetAllPSControlRenders();
        }
        Iterator<? extends IPSControlRender> psControlRenders2 = super.onGetAllPSControlRenders();
        if (psControlRenders2 != null) {
            int nIndex = 0;
            while (psControlRenders2.hasNext()) {
                iPSControlRender = psControlRenders2.next();
                psControlRenderList.add(nIndex, iPSControlRender);
                ++nIndex;
            }
        }
        return psControlRenderList.iterator();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (!PSDETabViewPanelImpl.isEmbeddedPSAppDEViewMustLink() && this.getIndex() == 0 && this.getEmbeddedPSAppDEView() != null) {
            objectNode.remove("getEmbeddedPSAppDEView");
            objectNode.put("getEmbeddedPSAppDEView", (JsonNode)this.getEmbeddedPSAppDEView().getModel());
        }
    }
}

