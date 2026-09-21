/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.PS.Data.PSSystemDeploy;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemDeployDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSystemDeployDataCtrl.class);

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            boolean bDefaultDeploy = false;
            boolean bDefaultDeployCancel = false;
            if (bInsert) {
                if (dataEntity.GetParamIntValue("DEFAULTDEPLOY", 0) == 1) {
                    bDefaultDeploy = true;
                }
            } else if (dataEntity.GetParamIntValue("DEFAULTDEPLOY", 0) == 1) {
                if (lastDataEntity.GetParamIntValue("DEFAULTDEPLOY", 0) != 1) {
                    bDefaultDeploy = true;
                }
            } else if (lastDataEntity.GetParamIntValue("DEFAULTDEPLOY", 0) == 1) {
                bDefaultDeployCancel = true;
            }
            if (bDefaultDeploy) {
                IDEDataCtrl psSystemDataCtrl = this.GetRelatedDataCtrl("DE2030");
                PSSystem psSystem = new PSSystem();
                psSystem.setPSSYSTEMID(dataEntity.getParamStringValue("PSSYSTEMID", ""));
                callResult = psSystemDataCtrl.Get((BaseDataEntity)psSystem);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                String strDEFPSSYSDEPLOYID = psSystem.getDEFPSSYSDEPLOYID();
                if (!StringHelper.IsNullOrEmpty((String)strDEFPSSYSDEPLOYID)) {
                    PSSystemDeploy psSystemDeploy = new PSSystemDeploy();
                    psSystemDeploy.setPSSYSDEPLOYID(strDEFPSSYSDEPLOYID);
                    psSystemDeploy.setDEFAULTDEPLOY(false);
                    callResult = this.Save(false, psSystemDeploy);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u66f4\u50cf\u7cfb\u7edf\u90e8\u7f72\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                psSystem.Reset();
                psSystem.setPSSYSTEMID(dataEntity.getParamStringValue("PSSYSTEMID", ""));
                psSystem.setDEFPSSYSDEPLOYID(dataEntity.getParamStringValue("PSSYSDEPLOYID", ""));
                callResult = psSystemDataCtrl.Save(false, (BaseDataEntity)psSystem);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            } else if (bDefaultDeployCancel) {
                IDEDataCtrl psSystemDataCtrl = this.GetRelatedDataCtrl("DE2030");
                PSSystem psSystem = new PSSystem();
                psSystem.setPSSYSTEMID(dataEntity.getParamStringValue("PSSYSTEMID", ""));
                psSystem.setDEFPSSYSDEPLOYID("");
                callResult = psSystemDataCtrl.Save(false, (BaseDataEntity)psSystem);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)ex.getMessage(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }
}

