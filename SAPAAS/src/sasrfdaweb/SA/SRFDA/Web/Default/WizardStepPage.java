/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DEWizardDetail
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.WizardSession
 *  SA.SRFDA.Ctrl.Data.WizardStep
 *  SA.SRFDA.Ctrl.Data.WizardStepData
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DEWizardDetail;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.WizardSession;
import SA.SRFDA.Ctrl.Data.WizardStep;
import SA.SRFDA.Ctrl.Data.WizardStepData;
import SA.SRFDA.Ctrl.Form.WizardStepFormActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.Default.ViewModel.WizardStepViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import net.sf.json.JSONObject;

public class WizardStepPage
extends BaseMainPage {
    protected SRFExDPEx panel = null;
    protected Form formView = new Form();
    protected String strFormViewId = "";
    private boolean bContainKey = false;
    private JSONObject keyJson = new JSONObject();
    protected String strDPConfigId = "";
    protected WizardStepViewModel wizardStepViewModel = null;
    protected DEWizardDetail deWizardDetail = null;
    protected String strWizardSessionId = "";
    protected String strWizardStepDataId = "";

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strDEWizardId = "";
        String strDEWZPageId = "";
        if (!this.IsBackEndMode()) {
            strDEWizardId = this.getWebContext().GetParamValue("SRFDEWIZARDID");
            if (StringHelper.IsNullOrEmpty((String)strDEWizardId)) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u7f16\u53f7"));
                return false;
            }
            strDEWZPageId = this.getWebContext().GetParamValue("SRFDEWZPAGEID");
            if (StringHelper.IsNullOrEmpty((String)strDEWZPageId)) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4\u7f16\u53f7"));
                return false;
            }
            this.deWizardDetail = new DEWizardDetail();
            CallResult callResult = this.getDAModelHelper().GetDEWizardDetail(strDEWizardId, strDEWZPageId, this.deWizardDetail);
            if (callResult.IsError()) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4[%1$s-%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEWizardId, (Object)strDEWZPageId, (Object)callResult.getErrorInfo()));
                return false;
            }
            this.strFormViewId = this.deWizardDetail.getFORMID();
            this.getWebContext().SetParamValue("SRFFORMVIEW", this.strFormViewId);
        } else {
            this.strFormViewId = this.getWebContext().getSRFFormView();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strFormViewId)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4[%1$s-%2$s]\u8868\u5355\u7f16\u53f7", (Object)strDEWizardId, (Object)strDEWZPageId));
            if (this.pageModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4[%1$s-%2$s]\u8868\u5355\u7f16\u53f7", (Object)strDEWizardId, (Object)strDEWZPageId)));
                    this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
                }
                this.OutputDirect(this.pageModel.toString());
            }
            return false;
        }
        this.formView = this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), this.strFormViewId);
        if (this.formView == null) {
            if (this.pageModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u5355[%1$s]", (Object)this.strFormViewId)));
                    this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
                }
                this.OutputDirect(this.pageModel.toString());
            }
            return false;
        }
        this.strPageDataEntityId = this.formView.getDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.setPageParam("FORMVIEW", this.formView);
        this.strWizardSessionId = this.getWebContext().GetParamValue("SRFWZSESSIONID");
        if (!this.IsBackEndMode() && !StringHelper.IsNullOrEmpty((String)this.strWizardSessionId)) {
            WizardSession wizardSession = new WizardSession();
            wizardSession.setWIZARDSESSIONID(this.strWizardSessionId);
            IDEDataCtrl wizardSessionDataCtrl = this.GetDEDataCtrl("DE0265");
            CallResult callResult = wizardSessionDataCtrl.Get((BaseDataEntity)wizardSession);
            if (callResult.IsError()) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5411\u5bfc\u4f1a\u8bdd[%1$s-%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEWizardId, (Object)this.strWizardSessionId, (Object)callResult.getErrorInfo()));
                return false;
            }
            IDEDataCtrl wizardStepDataDataCtrl = this.GetDEDataCtrl("DE0266");
            IDEDataCtrl wizardStepDataCtrl = this.GetDEDataCtrl("DE0267");
            WizardStep wizardStep = new WizardStep();
            String strWizardStepId = this.getWebContext().GetParamValue("SRFWZSTEPID");
            if (StringHelper.IsNullOrEmpty((String)strWizardStepId)) {
                WizardStepData wizardStepData;
                String strLastWizardStepId = this.getWebContext().GetParamValue("SRFLASTWZSTEPID");
                wizardStep.setWIZARDSESSIONID(this.strWizardSessionId);
                String strStepDataType = this.deWizardDetail.getSTEPDATATYPE();
                if (StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL1DATA", (boolean)true) == 0 || StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL2DATA", (boolean)true) == 0 || StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL3DATA", (boolean)true) == 0) {
                    if (StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL1DATA", (boolean)true) == 0) {
                        this.strWizardStepDataId = wizardSession.getL1STEPDATAID();
                    } else if (StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL2DATA", (boolean)true) == 0) {
                        this.strWizardStepDataId = wizardSession.getL2STEPDATAID();
                    } else if (StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL3DATA", (boolean)true) == 0) {
                        this.strWizardStepDataId = wizardSession.getL3STEPDATAID();
                    }
                } else if (StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL1DATA", (boolean)true) == 0 || StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL2DATA", (boolean)true) == 0 || StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL3DATA", (boolean)true) == 0) {
                    wizardStepData = new WizardStepData();
                    wizardStepData.setWIZARDSTEPDATANAME(this.getDEHelper().getId());
                    wizardStepData.setWIZARDSESSIONID(this.strWizardSessionId);
                    wizardStepData.setSAVEDATAACTIONID(this.deWizardDetail.getREALSAVEDEACTIONID());
                    BaseDataEntity baseDataEntity = new BaseDataEntity();
                    if (!StringHelper.IsNullOrEmpty((String)this.deWizardDetail.getDEACTIONID()) && (callResult = this.GetDEDataCtrl().Execute(this.deWizardDetail.getDEACTIONID(), baseDataEntity)).IsError()) {
                        this.OutputPreparePageEnvError(StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53\u64cd\u4f5c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.deWizardDetail.getDEACTIONID(), (Object)callResult.getErrorInfo()));
                        return false;
                    }
                    if (StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL2DATA", (boolean)true) == 0) {
                        wizardStepData.setPSTEPDATAID(wizardSession.getL1STEPDATAID());
                        wizardStepData.setFOREIGNKEY(this.deWizardDetail.getFOREIGNKEY());
                    } else if (StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL3DATA", (boolean)true) == 0) {
                        wizardStepData.setPSTEPDATAID(wizardSession.getL2STEPDATAID());
                        wizardStepData.setFOREIGNKEY(this.deWizardDetail.getFOREIGNKEY());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)this.deWizardDetail.getPDATAMAP()) && (callResult = this.ProcessDataMap(wizardSession, wizardStepData, baseDataEntity)).IsError()) {
                        this.OutputPreparePageEnvError(StringHelper.Format((String)"\u5904\u7406\u6570\u636e\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return false;
                    }
                    if (this.deWizardDetail.getREALDATAMODE()) {
                        callResult = this.GetDEDataCtrl().Get(baseDataEntity);
                        if (callResult.IsError()) {
                            this.OutputPreparePageEnvError(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u9645\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            return false;
                        }
                        wizardStepData.setPKEYVALUE(baseDataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), ""));
                        baseDataEntity.SetParamValue("SRFWZREALID", baseDataEntity.GetParamValue(this.getDEHelper().GetKeyDEFHelper().getName()));
                    }
                    wizardStepData.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)baseDataEntity, (boolean)true));
                    callResult = wizardStepDataDataCtrl.Save(true, (BaseDataEntity)wizardStepData);
                    if (callResult.IsError()) {
                        this.OutputPreparePageEnvError(StringHelper.Format((String)"\u83b7\u53d6\u5411\u5bfc\u6b65\u9aa4\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return false;
                    }
                    this.strWizardStepDataId = wizardStepData.getWIZARDSTEPDATAID();
                    if (StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL1DATA", (boolean)true) == 0) {
                        wizardSession.setL1STEPDATAID(this.strWizardStepDataId);
                        wizardSession.setL2STEPDATAID("");
                        wizardSession.setL3STEPDATAID("");
                    } else if (StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL2DATA", (boolean)true) == 0) {
                        wizardSession.setL2STEPDATAID(this.strWizardStepDataId);
                        wizardSession.setL3STEPDATAID("");
                    } else if (StringHelper.Compare((String)this.deWizardDetail.getSTEPDATATYPE(), (String)"NEWL3DATA", (boolean)true) == 0) {
                        wizardSession.setL3STEPDATAID(this.strWizardStepDataId);
                    }
                    callResult = wizardSessionDataCtrl.Save(false, (BaseDataEntity)wizardSession);
                    if (callResult.IsError()) {
                        this.OutputPreparePageEnvError(StringHelper.Format((String)"\u66f4\u65b0\u5b9e\u4f53\u5411\u5bfc\u4f1a\u8bdd[%1$s-%2$s]\u5931\u8d25\uff0c%3$s", (Object)strDEWizardId, (Object)this.strWizardSessionId, (Object)callResult.getErrorInfo()));
                        return false;
                    }
                } else {
                    wizardStepData = new WizardStepData();
                    wizardStepData.setWIZARDSTEPDATANAME(this.getDEHelper().getId());
                    wizardStepData.setWIZARDSESSIONID(this.strWizardSessionId);
                    wizardStepData.setIGNORESAVE(true);
                    BaseDataEntity baseDataEntity = new BaseDataEntity();
                    wizardStepData.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)baseDataEntity, (boolean)true));
                    callResult = wizardStepDataDataCtrl.Save(true, (BaseDataEntity)wizardStepData);
                    if (callResult.IsError()) {
                        this.OutputPreparePageEnvError(StringHelper.Format((String)"\u83b7\u53d6\u5411\u5bfc\u6b65\u9aa4\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return false;
                    }
                    this.strWizardStepDataId = wizardStepData.getWIZARDSTEPDATAID();
                }
                wizardStep.setWIZARDSTEPDATAID(this.strWizardStepDataId);
                callResult = wizardStepDataCtrl.Save(true, (BaseDataEntity)wizardStep);
                if (callResult.IsError()) {
                    this.OutputPreparePageEnvError(StringHelper.Format((String)"\u4fdd\u5b58\u5411\u5bfc\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
                if (!StringHelper.IsNullOrEmpty((String)strLastWizardStepId)) {
                    WizardStep lastWizardStep = new WizardStep();
                    lastWizardStep.setWIZARDSTEPID(strLastWizardStepId);
                    lastWizardStep.setNEXTSTEPID(wizardStep.getWIZARDSTEPID());
                    callResult = wizardStepDataCtrl.Save(false, (BaseDataEntity)lastWizardStep);
                    if (callResult.IsError()) {
                        this.OutputPreparePageEnvError(StringHelper.Format((String)"\u4fdd\u5b58\u4e0a\u4e00\u4e2a\u5411\u5bfc\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return false;
                    }
                }
                this.getWebContext().SetParamValue("SRFWZSTEPID", wizardStep.getWIZARDSTEPID());
            } else {
                wizardStep.setWIZARDSTEPID(strWizardStepId);
                callResult = wizardStepDataCtrl.Get((BaseDataEntity)wizardStep);
                if (callResult.IsError()) {
                    this.OutputPreparePageEnvError(StringHelper.Format((String)"\u83b7\u53d6\u5411\u5bfc\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
                this.strWizardStepDataId = wizardStep.getWIZARDSTEPDATAID();
                wizardSession.Reset();
                wizardSession.setWIZARDSESSIONID(this.strWizardSessionId);
                String strStepDataType = this.deWizardDetail.getSTEPDATATYPE();
                if (StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL1DATA", (boolean)true) == 0 || StringHelper.Compare((String)strStepDataType, (String)"NEWL1DATA", (boolean)true) == 0) {
                    wizardSession.setL1STEPDATAID(this.strWizardStepDataId);
                    wizardSession.setL2STEPDATAID("");
                    wizardSession.setL3STEPDATAID("");
                } else if (StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL2DATA", (boolean)true) == 0 || StringHelper.Compare((String)strStepDataType, (String)"NEWL2DATA", (boolean)true) == 0) {
                    wizardSession.setL2STEPDATAID(this.strWizardStepDataId);
                    wizardSession.setL3STEPDATAID("");
                } else if (StringHelper.Compare((String)strStepDataType, (String)"ACTIVEL3DATA", (boolean)true) == 0 || StringHelper.Compare((String)strStepDataType, (String)"NEWL3DATA", (boolean)true) == 0) {
                    wizardSession.setL3STEPDATAID(this.strWizardStepDataId);
                }
                callResult = wizardSessionDataCtrl.Save(false, (BaseDataEntity)wizardSession);
                if (callResult.IsError()) {
                    this.OutputPreparePageEnvError(StringHelper.Format((String)"\u66f4\u65b0\u5411\u5bfc\u4f1a\u8bdd\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
            }
            wizardSession.Reset();
            wizardSession.setWIZARDSESSIONID(this.strWizardSessionId);
            wizardSession.setLASTSTEPDATAID(this.strWizardStepDataId);
            callResult = wizardSessionDataCtrl.Save(false, (BaseDataEntity)wizardSession);
            if (callResult.IsError()) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u66f4\u65b0\u5411\u5bfc\u4f1a\u8bdd\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
            WizardStepData wizardStepData = new WizardStepData();
            wizardStepData.setWIZARDSTEPDATAID(this.strWizardStepDataId);
            if (StringHelper.IsNullOrEmpty((String)this.deWizardDetail.getSTEPDATATYPE()) || this.deWizardDetail.getIGNORESTEPDATA()) {
                wizardStepData.setIGNORESAVE(true);
            } else {
                wizardStepData.setIGNORESAVE(false);
            }
            callResult = wizardStepDataDataCtrl.Save(false, (BaseDataEntity)wizardStepData);
            if (callResult.IsError()) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u66f4\u65b0\u5411\u5bfc\u6b65\u9aa4\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
        }
        return true;
    }

    protected CallResult ProcessDataMap(WizardSession wizardSession, WizardStepData wizardStepData, BaseDataEntity baseDataEntity) {
        CallResult callResult = new CallResult();
        try {
            this.OnProcessDataMap(wizardSession, wizardStepData, baseDataEntity);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            this.PageLog(this, 1, callResult.getErrorInfo(), ex);
            return callResult;
        }
    }

    protected void OnProcessDataMap(WizardSession wizardSession, WizardStepData wizardStepData, BaseDataEntity baseDataEntity) throws Exception {
        Properties properties;
        if (StringHelper.IsNullOrEmpty((String)this.deWizardDetail.getPDATAMAP())) {
            return;
        }
        String strPStepDataId = wizardStepData.getPSTEPDATAID();
        if (!StringHelper.IsNullOrEmpty((String)this.deWizardDetail.getREFSTEPDATATYPE())) {
            if (StringHelper.Compare((String)this.deWizardDetail.getREFSTEPDATATYPE(), (String)"LASTDATA", (boolean)true) == 0) {
                strPStepDataId = wizardSession.getLASTSTEPDATAID();
            } else if (StringHelper.Compare((String)this.deWizardDetail.getREFSTEPDATATYPE(), (String)"ACTIVEL1DATA", (boolean)true) == 0) {
                strPStepDataId = wizardSession.getL1STEPDATAID();
            } else if (StringHelper.Compare((String)this.deWizardDetail.getREFSTEPDATATYPE(), (String)"ACTIVEL2DATA", (boolean)true) == 0) {
                strPStepDataId = wizardSession.getL2STEPDATAID();
            } else if (StringHelper.Compare((String)this.deWizardDetail.getREFSTEPDATATYPE(), (String)"ACTIVEL3DATA", (boolean)true) == 0) {
                strPStepDataId = wizardSession.getL3STEPDATAID();
            }
        }
        BaseDataEntity pDataEntity = null;
        if (!StringHelper.IsNullOrEmpty((String)strPStepDataId)) {
            IDEDataCtrl wizardStepDataDataCtrl = this.GetDEDataCtrl("DE0266");
            WizardStepData pWizardStepData = new WizardStepData();
            pWizardStepData.setWIZARDSTEPDATAID(strPStepDataId);
            CallResult callResult = wizardStepDataDataCtrl.Get((BaseDataEntity)pWizardStepData);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5411\u5bfc\u6b65\u9aa4\u6570\u636e[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strPStepDataId, (Object)callResult.getErrorInfo()));
            }
            pDataEntity = BaseDataEntity.FromString((String)pWizardStepData.getDEDATA());
        }
        if ((properties = PropertiesHelper.Load((String)this.deWizardDetail.getPDATAMAP())) == null) {
            return;
        }
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (StringHelper.Compare((String)"%%SRFREMOVE()%%", (String)strValue, (boolean)true) == 0 || StringHelper.Compare((String)"%%SRFREMOVE%%", (String)strValue, (boolean)true) == 0) {
                baseDataEntity.RemoveParam(strKey);
                continue;
            }
            CallResult callResult = MacroHelper.GetValue((String)strValue, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getDAGlobalHelper(), (String)this.getWebContext().getCurUserId(), (BaseDataEntity)pDataEntity);
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                baseDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    baseDataEntity.SetParamValue(strKey, null);
                    continue;
                }
                IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(strKey);
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                }
                baseDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            baseDataEntity.SetParamValue(strKey, obj);
        }
    }

    @Override
    protected PageModel CreatePageModel() {
        return new WizardStepViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.wizardStepViewModel = (WizardStepViewModel)this.pageModel;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
    }

    protected String GetFormActionHelper() {
        String strFormActionHelper = this.getPageParam("PAGE.FORMACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strFormActionHelper)) {
            return strFormActionHelper;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getBACKENDCTRL())) {
            return this.formView.getBACKENDCTRL();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strWizardSessionId)) {
            return this.getWebContext().getWebExConfig().GetValue("SRFDA", "FORMACTIONHELPER", "");
        }
        return WizardStepFormActionHelper.class.getName();
    }

    protected void LoadDPEx() {
        this.strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        DPConfig panelConfig = this.getWebContext().GetConfigCache().GetDPConfig(this.getWebContext(), "Panel", this.strDPConfigId);
        if (panelConfig == null) {
            this.PageLog(this.page, 1, StringHelper.Format((String)"\u52a8\u6001\u9762\u677f[%1$s]\u65e0\u6548", (Object)this.strDPConfigId));
            return;
        }
        this.panel = WizardStepPage.CreateDPEx((SRFDAPage)this, "Panel", true, this.strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.panel.getDPConfig().getPageGroupsConfig().size() == 1) {
                this.panel.getDPConfig().setSimpleMode(true);
            }
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(false);
        if (this.wizardStepViewModel != null) {
            DPExModel dpExModel = this.wizardStepViewModel.getDPExModel();
            dpExModel.setConfigId(this.strDPConfigId);
            dpExModel.setRemoteCtrlId(this.panel.getUniqueID());
            FormModel formModel = this.wizardStepViewModel.getFormModel();
            formModel.setRemoteCtrlId(form.getFormId());
            formModel.setItemPrivilege(false);
        }
        if (!this.IsBackEndMode()) {
            if (StringHelper.IsNullOrEmpty((String)this.strWizardSessionId)) {
                StringBuilderEx script = new StringBuilderEx();
                script.Reset();
                script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
                script.Append("$P.mainform.newdata=function(){%1$s.loaddefault(); };", (Object)form.getFormId());
                this.RegisterOnReadyScript(3, script.toString());
                script.Reset();
                ArrayList keyControls = form.GetKeyFormControls();
                int nCount = keyControls.size();
                if (nCount == 0) {
                    script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
                }
                String strParamName = "";
                String strParamValue = "";
                int i = 0;
                while (i < nCount) {
                    SRFExControl control = (SRFExControl)keyControls.get(i);
                    IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(control.getID());
                    if (iDEFHelper == null) {
                        script.Append("alert('\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53\u4e3b\u952e\u8f85\u52a9\u5bf9\u8c61\uff0c\u5904\u7406\u505c\u6b62!');");
                        break;
                    }
                    if (iDEFHelper.IsLinkDEField()) {
                        ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                        strParamValue = this.getWebContext().GetParamValue(linkDEFHelper.GetRelatedDEFHelper().getName());
                        strParamName = linkDEFHelper.GetRelatedDEFHelper().getName();
                    } else {
                        strParamValue = this.getWebContext().GetParamValue(iDEFHelper.getName());
                        strParamName = iDEFHelper.getName();
                    }
                    ++i;
                }
                if (SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false)) {
                    strParamValue = this.getWebContext().GetParamValue("SRFDATEMPKEYID");
                } else if (StringHelper.IsNullOrEmpty((String)strParamValue) && !StringHelper.IsNullOrEmpty((String)(strParamValue = SRFDAWebCTXHelper.GetDAKey((ISRFDAWebContext)this.getWebContext())))) {
                    this.getWebContext().SetParamValue(strParamName, strParamValue);
                    this.getWebContext().SetParamValue("SRFDAKEYS", "");
                }
                if (StringHelper.IsNullOrEmpty((String)strParamValue) || SRFDAWebCTXHelper.IsNewDataMode((ISRFDAWebContext)this.getWebContext())) {
                    this.bContainKey = false;
                    script.Append("%1$s", (Object)FormJSHelper.getLoadDefaultScript((SRFExForm)form));
                } else {
                    String strFKey = "";
                    String strSRFDERId = this.getWebContext().getSRFDERID();
                    if (!StringHelper.IsNullOrEmpty((String)strSRFDERId)) {
                        DER1N der1N = new DER1N();
                        CallResult callResult = this.getDAModelHelper().GetDER1N(strSRFDERId, der1N);
                        if (callResult.getRetCode() != 0) {
                            this.PageLog(null, 1, StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strSRFDERId, (Object)callResult.getErrorInfo()));
                        } else {
                            IDEHelper iMajorDEHelper = this.getDAModelStorage().FindDEHelper(der1N.getMAJORDEID());
                            if (iMajorDEHelper == null) {
                                this.PageLog(null, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1N.getMAJORDEID()));
                            } else {
                                strFKey = iMajorDEHelper.GetKeyDEFHelper().getName();
                            }
                        }
                    }
                    if (StringHelper.Compare((String)strFKey, (String)strParamName, (boolean)true) == 0) {
                        this.bContainKey = false;
                        script.Append("%1$s", (Object)FormJSHelper.getLoadDefaultScript((SRFExForm)form));
                    } else {
                        this.bContainKey = true;
                        this.keyJson.put(strParamName.toLowerCase(), (Object)strParamValue);
                        script.Append("%1$s", (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)("'" + strParamValue + "'" + ",false")));
                    }
                }
                this.RegisterOnReadyScript(5, script.toString());
                script.Reset();
                script.Append("SRFUtility.refreshpdg();");
                script.Append("if($V(%1$s.saveandclose,false)){ window.close();return ;}", (Object)form.getFormId());
                script.Append("if($V(%1$s.saveandnew,false)){%1$s.loaddefault(); return ;}", (Object)form.getFormId());
                form.getSaveAction().getSuccessAction().RegisterProcessCode(0, script.toString());
            } else {
                String strParamName = this.getDEHelper().GetKeyDEFHelper().getName();
                this.bContainKey = true;
                this.keyJson.put(strParamName.toLowerCase(), (Object)this.strWizardStepDataId);
            }
        }
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator(String.valueOf(this.getDefaultFormId()) + "_indicator");
            strOutput = String.valueOf(strOutput) + this.Render("panel");
        }
        return strOutput;
    }

    public String RenderErrorPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:150px;display:none;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDPEx();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        FormModifyAlertJSGear.Load(this);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        String strStepAction = this.deWizardDetail.getSTEPACTION();
        if (!StringHelper.IsNullOrEmpty((String)strStepAction)) {
            String[] step = strStepAction.split("[;]");
            Hashtable<String, String> stepMap = new Hashtable<String, String>();
            int i = 0;
            while (i < step.length) {
                stepMap.put(step[i].toUpperCase(), "");
                ++i;
            }
            if (stepMap.containsKey("FINISH")) {
                this.wizardStepViewModel.setFinish(true);
            }
            if (stepMap.containsKey("NEXT")) {
                this.wizardStepViewModel.setNext(true);
            }
            if (stepMap.containsKey("PREV")) {
                this.wizardStepViewModel.setPrev(true);
            }
        }
        this.wizardStepViewModel.setContainKey(this.bContainKey);
        if (this.bContainKey) {
            this.wizardStepViewModel.setKeyData(this.keyJson);
        }
        return true;
    }

    @Override
    protected String OnGetPageTitle() {
        if (this.deWizardDetail != null) {
            return StringHelper.Format((String)"%1$s - %2$s", (Object)this.deWizardDetail.getDEWIZARDNAME(), (Object)this.deWizardDetail.getDEWIZARDDETAILNAME());
        }
        return super.OnGetPageTitle();
    }
}

