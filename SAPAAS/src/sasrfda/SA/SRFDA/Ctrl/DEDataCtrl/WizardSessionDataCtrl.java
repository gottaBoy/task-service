/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IWizardSessionDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.WizardStep;
import SA.SRFDA.Ctrl.Data.WizardStepData;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WizardSessionDataCtrl
extends BaseDEDataCtrl
implements IWizardSessionDataCtrl {
    private static final Log log = LogFactory.getLog(WizardSessionDataCtrl.class);

    @Override
    public CallResult SaveWizardStepDatas(String strWizardSessionId, Vector<BaseDataEntity> dataEntities) {
        CallResult callResult = new CallResult();
        try {
            this.OnSaveWizardStepDatas(strWizardSessionId, dataEntities);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)ex);
            return callResult;
        }
        return callResult;
    }

    protected void OnSaveWizardStepDatas(String strWizardSessionId, Vector<BaseDataEntity> dataEntities) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strWizardSessionId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5411\u5bfc\u4f1a\u8bdd\u6807\u8bc6");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("WIZARDSESSIONID", (Object)strWizardSessionId);
        Vector wizardSteps = new Vector();
        IDEDataCtrl wizardStepDataCtrl = this.GetRelatedDataCtrl("DE0267");
        CallResult callResult = wizardStepDataCtrl.Select(cond, wizardSteps, WizardStep.class.getName(), "ORDER BY CREATEDATE ASC");
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5411\u5bfc\u6b65\u9aa4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (wizardSteps.size() == 0) {
            throw new Exception("\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u5411\u5bfc\u6b65\u9aa4");
        }
        Vector<WizardStep> validWizardSteps = new Vector<WizardStep>();
        Hashtable<String, WizardStep> wizardStepMap = new Hashtable<String, WizardStep>();
        for (WizardStep wizardStep : wizardSteps) {
            wizardStepMap.put(wizardStep.getWIZARDSTEPID(), wizardStep);
        }
        Hashtable<String, String> validStepDataMap = new Hashtable<String, String>();
        WizardStep nextWizardStep = (WizardStep)((Object)wizardSteps.get(0));
        while (nextWizardStep != null) {
            validStepDataMap.put(nextWizardStep.getWIZARDSTEPDATAID(), "");
            validWizardSteps.add(nextWizardStep);
            String strNextStepId = nextWizardStep.getNEXTSTEPID();
            if (StringHelper.IsNullOrEmpty((String)strNextStepId)) break;
            nextWizardStep = (WizardStep)((Object)wizardStepMap.get(strNextStepId));
            if (nextWizardStep != null) continue;
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u6307\u5b9a\u5411\u5bfc\u6b65\u9aa4[%1$s]", (Object)strNextStepId));
        }
        Vector wizardStepDatas = new Vector();
        IDEDataCtrl wizardStepDataDataCtrl = this.GetRelatedDataCtrl("DE0266");
        callResult = wizardStepDataDataCtrl.Select(cond, wizardStepDatas, WizardStepData.class.getName(), "ORDER BY CREATEDATE ASC");
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5411\u5bfc\u6b65\u9aa4\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Hashtable<String, BaseDataEntity> wizardStepDataMap = new Hashtable<String, BaseDataEntity>();
        for (WizardStepData wizardStepData : wizardStepDatas) {
            if (!validStepDataMap.containsKey(wizardStepData.getWIZARDSTEPDATAID())) continue;
            BaseDataEntity dataEntity = BaseDataEntity.FromString((String)wizardStepData.getDEDATA());
            IDEDataCtrl iDEDataCtrl = this.GetRelatedDataCtrl(wizardStepData.getWIZARDSTEPDATANAME());
            IDEFHelper keyFieldHelper = iDEDataCtrl.GetDEHelper().GetKeyDEFHelper();
            dataEntity.RemoveParam(keyFieldHelper.getName());
            if (!StringHelper.IsNullOrEmpty((String)wizardStepData.getPKEYVALUE())) {
                Object objPKeyValue = keyFieldHelper.GetDEFValue(wizardStepData.getPKEYVALUE());
                dataEntity.SetParamValue(keyFieldHelper.getName(), objPKeyValue);
            }
            if (!StringHelper.IsNullOrEmpty((String)wizardStepData.getPSTEPDATAID())) {
                BaseDataEntity pStepData = (BaseDataEntity)wizardStepDataMap.get(wizardStepData.getPSTEPDATAID());
                if (pStepData == null) {
                    throw new Exception(StringHelper.Format((String)"\u7236\u6b65\u9aa4\u6570\u636e\u65e0\u6548"));
                }
                IDEFHelper iDEFHelper = iDEDataCtrl.GetDEHelper().GetDEFHelper(wizardStepData.getFOREIGNKEY());
                if (iDEFHelper == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEDataCtrl.GetDEHelper().getId(), (Object)wizardStepData.getFOREIGNKEY()));
                }
                if (iDEFHelper instanceof ILinkDEFHelper) {
                    ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                    dataEntity.SetParamValue(iDEFHelper.getName(), pStepData.get(iLinkDEFHelper.GetRelatedDEFHelper().getName()));
                } else {
                    dataEntity.SetParamValue(iDEFHelper.getName(), pStepData.get(iDEFHelper.getName()));
                }
            }
            if (wizardStepData.getIGNORESAVE()) {
                wizardStepDataMap.put(wizardStepData.getWIZARDSTEPDATAID(), dataEntity);
                continue;
            }
            if (StringHelper.IsNullOrEmpty((String)wizardStepData.getSAVEDATAACTIONID())) {
                boolean bInsert = StringHelper.IsNullOrEmpty((String)wizardStepData.getPKEYVALUE());
                callResult = iDEDataCtrl.Save(bInsert, dataEntity);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53[%1$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)iDEDataCtrl.GetDEHelper().getId(), (Object)callResult.getErrorInfo()));
                }
            } else {
                callResult = iDEDataCtrl.Execute(wizardStepData.getSAVEDATAACTIONID(), dataEntity);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53[%1$s]\u64cd\u4f5c[%2$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iDEDataCtrl.GetDEHelper().getId(), (Object)wizardStepData.getSAVEDATAACTIONID(), (Object)callResult.getErrorInfo()));
                }
            }
            wizardStepDataMap.put(wizardStepData.getWIZARDSTEPDATAID(), dataEntity);
            dataEntities.add(dataEntity);
        }
    }
}

