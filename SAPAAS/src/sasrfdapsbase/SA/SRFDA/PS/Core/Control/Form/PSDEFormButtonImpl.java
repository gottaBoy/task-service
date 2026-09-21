/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormButton;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormButtonImpl
extends PSDEFormDetailImpl
implements IPSDEFormButton {
    private static final Log log = LogFactory.getLog(PSDEFormButtonImpl.class);
    private String strButtonActionType = "";
    private String strPSDEUIActonId = "";
    private IPSDEUIAction iPSDEUIAction = null;
    private IPSDEFormItemUpdate iPSDEFormItemUpdate = null;
    private String strPSDEFIUpdateId = "";
    private IPSWFUIAction iPSWFUIAction = null;
    private String strTooltip = null;
    private JSONObject paramViewParamJO = null;
    private PSAppViewUIActionProxy psAppViewUIActionProxy = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;

    @Override
    protected void onInit() throws Exception {
        String strViewParams;
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getBTNACTIONTYPE())) {
            this.strButtonActionType = this.psDEFormDetail.getBTNACTIONTYPE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEUIACTIONID())) {
            this.strPSDEUIActonId = this.psDEFormDetail.getPSDEUIACTIONID();
            if (this.iPSDEUIAction == null) {
                if (this.getPSDEForm().getPSAppDataEntity() != null) {
                    this.iPSDEUIAction = this.getPSDEForm().getPSAppDataEntity().getPSAppDEUIAction(this.strPSDEUIActonId, true, this.getOwnedPSControl());
                }
                if (this.iPSDEUIAction == null) {
                    this.iPSDEUIAction = this.getPSDEForm().getPSDataEntity().getPSDEUIAction(this.strPSDEUIActonId);
                }
            }
            if (this.iPSDEUIAction instanceof IPSWFUIAction) {
                this.iPSWFUIAction = (IPSWFUIAction)((Object)this.iPSDEUIAction);
            }
            if (this.isPrepareTemplV2logic()) {
                this.psAppViewUIActionProxy = new PSAppViewUIActionProxy(this.getId(), this.getName(), this, this);
                this.psAppViewUIActionProxy.setPSAppCounterRef(this.getPSAppCounterRef());
                this.getPSDEForm().registerPSAppViewUIAction(this.psAppViewUIActionProxy);
                this.registerPSAppViewLogic();
            } else {
                this.getPSDEForm().getPSAppView().registerPSUIAction(this.iPSDEUIAction);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEFIUPDATEID())) {
            this.strPSDEFIUpdateId = this.psDEFormDetail.getPSDEFIUPDATEID();
            this.iPSDEFormItemUpdate = this.getPSDEForm().getPSDEFormItemUpdate(this.strPSDEFIUpdateId);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPICKUPPSDEVIEWID()) && !StringHelper.IsNullOrEmpty((String)(strViewParams = this.psDEFormDetail.getEDITORPARAMS()))) {
            this.paramViewParamJO = new JSONObject();
            Properties properties = PropertiesHelper.load((String)strViewParams);
            if (properties != null) {
                for (Object objKey : properties.keySet()) {
                    PSNavigateParamImpl PSNavigateParamImpl2;
                    String strKey = (String)objKey;
                    String strTag = strKey.toUpperCase();
                    String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
                    boolean bRawValue = true;
                    if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    if (strTag.indexOf("SRFNAVCTX.") == 0) {
                        strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                        PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                        PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                        if (this.psNavigateContextMap == null) {
                            this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                        }
                        this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                        continue;
                    }
                    if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                        strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                        PSNavigateParamImpl2 = new PSNavigateParamImpl();
                        PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                        if (this.psNavigateParamMap == null) {
                            this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                        }
                        this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                        continue;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag.toLowerCase(), strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag.toLowerCase(), PSNavigateParamImpl2);
                    if (this.paramViewParamJO.has(strKey)) continue;
                    this.paramViewParamJO.put(strKey, (Object)PropertiesHelper.getProperty((Properties)properties, (String)((String)objKey), (String)""));
                }
            }
        }
        super.onInit();
    }

    @Override
    protected void onCheckModel() throws Exception {
        if (StringHelper.Compare((String)this.getActionType(), (String)"UIACTION", (boolean)true) == 0) {
            if (this.getPSUIAction() == null) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6309\u94ae\u8c03\u7528\u7684\u754c\u9762\u884c\u4e3a"));
            }
        } else if (StringHelper.Compare((String)this.getActionType(), (String)"FIUPDATE", (boolean)true) == 0 && this.getPSDEFormItemUpdate() == null) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6309\u94ae\u8c03\u7528\u7684\u8868\u5355\u9879\u66f4\u65b0"));
        }
        super.onCheckModel();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u884c\u4e3a\u7c7b\u578b", codelist="FormButtonActionType", fields={"BTNACTIONTYPE"})
    public String getActionType() {
        return this.strButtonActionType;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u754c\u9762\u884c\u4e3a", hideempty=true, child=true, fields={"PSDEUIACTIONID"})
    public IPSUIAction getPSUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    public String getPSUIActionId() {
        return this.strPSDEUIActonId;
    }

    @Override
    public String getPSDEFIUpdateId() {
        return this.strPSDEFIUpdateId;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8868\u5355\u9879\u66f4\u65b0", hideempty=true, dumpref=true, from="IPSDEForm", fields={"PSDEFIUPDATEID"})
    public IPSDEFormItemUpdate getPSDEFormItemUpdate() {
        return this.iPSDEFormItemUpdate;
    }

    @Override
    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    public IPSWFUIAction getPSWFUIAction() {
        return this.iPSWFUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        if (StringHelper.IsNullOrEmpty((String)this.strTooltip)) {
            return this.getCaption();
        }
        return this.strTooltip;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return super.getTooltipPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u9009\u62e9\u89c6\u56fe", dumpref=true, fields={"PICKUPPSDEVIEWID"})
    public IPSAppView getParamPickupPSAppView() throws Exception {
        String strPickupPSDEViewId = this.psDEFormDetail.getPICKUPPSDEVIEWID();
        if (!StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            return this.getPSDEForm().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDEForm().getPSAppView());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u9009\u62e9\u89c6\u56fe\u53c2\u6570", fields={"EDITORPARAMS"})
    public JSONObject getParamViewParamJO() throws Exception {
        return this.paramViewParamJO;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        IPSAppView iPSAppView = this.getParamPickupPSAppView();
        if (iPSAppView != null) {
            relatedAppViewList.add(iPSAppView);
        }
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_BUTTON";
    }

    @Override
    protected String onGetCaption() {
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().getCaption();
        }
        return super.onGetCaption();
    }

    @Override
    protected IPSLanguageRes onGetCapPSLanguageRes() {
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().getCapPSLanguageRes();
        }
        return super.onGetCapPSLanguageRes();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSControlContainer().getPSAppView();
    }

    @Override
    public JSONObject getUIActionParamJO() {
        return null;
    }

    @Override
    public String getXDataControlName() {
        return this.getPSDEForm().getName();
    }

    @Override
    public IPSControl getXDataPSControl() throws Exception {
        return this.getPSDEForm();
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.getPSDEForm();
    }

    protected void registerPSAppViewLogic() throws Exception {
        if (this.psAppViewUIActionProxy != null) {
            String strCtrlName = this.getPSDEForm().getName();
            String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_click", (Object)strCtrlName, (Object)this.getName()).toLowerCase();
            PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
            psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
            psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
            psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
            psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
            PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
            psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSDEForm(), psAppViewLogic, this.psAppViewUIActionProxy);
            this.getPSDEForm().registerPSAppViewLogic(psAppDEViewLogicImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6807\u9898\u7ed1\u5b9a\u503c\u9879", fields={"VALUEITEMNAME"})
    public String getCaptionItemName() {
        return this.psDEFormDetail.getVALUEITEMNAME();
    }

    @Override
    public boolean isSaveTargetFirst() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().isSaveTargetFirst();
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().isSaveTargetFirst();
        }
        return false;
    }

    @Override
    public IPSAppCounterRef getPSAppCounterRef() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", codelist="DEUIActionDataRange")
    public String getUIActionTarget() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().getActionTarget();
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().getActionTarget();
        }
        return "NONE";
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u754c\u9762\u884c\u4e3a", dumpref=true)
    public IPSAppViewUIAction getPSAppViewUIAction() {
        return this.psAppViewUIActionProxy;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    protected IPSSysImage onGetPSSysImage() {
        if (super.onGetPSSysImage() == null && this.getPSUIAction() != null) {
            return this.getPSUIAction().getPSSysImage();
        }
        return super.onGetPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\uff08\u8fd0\u884c\u65f6\u5185\u8054\uff09", rtdump=2, hideempty=true, child=true)
    public IPSUIAction getInlinePSUIAction() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u9f50", codelist="ButtonIconAlign", fields={"ICONALIGN"})
    public String getIconAlign() {
        return this.psDEFormDetail.getICONALIGN();
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u6846\u6837\u5f0f", codelist="BorderStyle", fields={"BORDERSTYLE"})
    public String getBorderStyle() {
        return this.psDEFormDetail.getBORDERSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", ignoredumpvalues="DEFAULT", fields={"DETAILSTYLE"})
    public String getButtonStyle() {
        String strItemStyle = this.psDEFormDetail.getDETAILSTYLE();
        if (StringHelper.IsNullOrEmpty((String)strItemStyle) && this.getPSUIAction() != null) {
            strItemStyle = this.getPSUIAction().getButtonStyle();
        }
        if (!StringHelper.IsNullOrEmpty((String)strItemStyle)) {
            return strItemStyle;
        }
        return this.getDetailStyle();
    }
}

