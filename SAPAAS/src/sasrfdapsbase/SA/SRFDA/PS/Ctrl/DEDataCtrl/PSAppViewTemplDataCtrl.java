/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppViewTempl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewTemplDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSAppViewTemplDataCtrl.class);
    public static final String CUSTOMCALL_MERGECODE = "MERGECODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSAppViewTempl psAppViewTempl = new PSAppViewTempl();
            psAppViewTempl.proxy(dataEntity);
            String strPSAPPVIEWTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s", (Object)psAppViewTempl.getPSAPPVIEWSTYLENAME(), (Object)psAppViewTempl.getPSPFPUBCODENAME());
            psAppViewTempl.setPSAPPVIEWTEMPLNAME(strPSAPPVIEWTEMPLNAME);
            psAppViewTempl.setPSAPPVIEWTEMPLID(Helper.GenUniqueId((String)psAppViewTempl.getPSAPPVIEWSTYLEID(), (String)psAppViewTempl.getPSPFPUBCODEID()));
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_MERGECODE, (boolean)true) == 0) {
            return this.mergeCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult mergeCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSAppViewTempl psAppViewTempl = new PSAppViewTempl();
            psAppViewTempl.proxy(dataEntity);
            this.onMergeCode(psAppViewTempl);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5408\u5e76\u89c6\u56fe\u6a21\u7248\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onMergeCode(PSAppViewTempl psAppViewTempl) throws Exception {
        String strTemplCode = psAppViewTempl.getTEMPLCODE2();
        String stPSAppViewTemplId = psAppViewTempl.getPSAPPVIEWTEMPLID();
        psAppViewTempl.Reset();
        psAppViewTempl.setPSAPPVIEWTEMPLID(stPSAppViewTemplId);
        psAppViewTempl.setTEMPLCODE(strTemplCode);
        CallResult callResult = this.Save(false, psAppViewTempl);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}

