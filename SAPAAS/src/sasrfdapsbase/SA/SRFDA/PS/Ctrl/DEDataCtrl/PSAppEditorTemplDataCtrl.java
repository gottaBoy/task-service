/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppEditorTempl;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppEditorTemplDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSAppEditorTemplDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSAppEditorTempl psAppEditorTempl = new PSAppEditorTempl();
            psAppEditorTempl.proxy(dataEntity);
            CodeListConfig codeListConfig = this.getGlobalHelper().getCodeListMgr().GetCodeListConfig("CODELIST_DE1804_001");
            String strContainerType = psAppEditorTempl.getCONTAINERTYPE();
            String strPSPFEDITORTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s-%3$s/%4$s/%5$s", (Object)psAppEditorTempl.getPSSYSAPPNAME(), (Object)psAppEditorTempl.getPSEDITORTYPENAME(), (Object)psAppEditorTempl.getPSSYSEDITORSTYLENAME(), (Object)codeListConfig.GetCodeListValue(strContainerType, true), (Object)psAppEditorTempl.getPSPFPUBCODENAME());
            psAppEditorTempl.setPSAPPEDITORTEMPLNAME(strPSPFEDITORTEMPLNAME);
            psAppEditorTempl.setPSAPPEDITORTEMPLID(Helper.GenUniqueId((String)psAppEditorTempl.getPSSYSAPPID(), (String)psAppEditorTempl.getPSEDITORTYPEID(), (String)psAppEditorTempl.getPSSYSEDITORSTYLEID(), (String)strContainerType, (String)psAppEditorTempl.getPSPFPUBCODEID()));
        }
        return callResult;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            String strPSSysAppId = this.getWebContext().GetParamValue("PSSYSAPPID");
            if (!StringHelper.IsNullOrEmpty((String)strPSSysAppId)) {
                IDEDataCtrl psSysAppDataCtrl = this.GetRelatedDataCtrl("DE2500");
                PSSysApp psSysApp = new PSSysApp();
                psSysApp.setPSSYSAPPID(strPSSysAppId);
                callResult = psSysAppDataCtrl.Get((BaseDataEntity)psSysApp);
                if (callResult.isError()) {
                    return callResult;
                }
                dataEntity.setParamValue("PSSYSAPPID", (Object)strPSSysAppId);
                dataEntity.setParamValue("PSSYSTEMID", (Object)psSysApp.getPSSYSTEMID());
                dataEntity.setParamValue("PSPFID", (Object)psSysApp.getPSPFID());
            }
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
        return callResult;
    }
}

