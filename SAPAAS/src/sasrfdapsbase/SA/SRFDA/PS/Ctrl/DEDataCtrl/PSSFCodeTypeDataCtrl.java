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
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFCodeTypeDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFCodeTypeDataCtrl.class);
    public static final String CUSTOMCALL_ENABLEBAT = "ENABLEBAT";
    public static final String CUSTOMCALL_DISABLEBAT = "DISABLEBAT";

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSSFCodeType psSFCodeType = new PSSFCodeType();
        psSFCodeType.proxy(dataEntity);
        BaseDataEntity psSFStyle = this.GetRelatedData("DE1513", psSFCodeType.getPSSFSTYLEID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1513");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psSFStyle);
        return StringHelper.Format((String)"%1$s%2$sPSSFCODETYPE%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)psSFCodeType.getTYPECODE());
    }

    @Override
    protected HashMap<String, String> getCodeTemplMap() throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("CODETEMPL", "");
        map.put("TEMPLCODE2", "");
        return map;
    }

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSSFCodeTypeId = dataEntity.getParamStringValue("PSSFCODETYPEID", "");
        IDEDataCtrl iPSSFCodeTemplDataCtrl = this.GetRelatedDataCtrl("DE1516");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSFCODETYPEID", (Object)strPSSFCodeTypeId);
        Vector psSFCodeTemplList = new Vector();
        iPSSFCodeTemplDataCtrl.Select(cond, psSFCodeTemplList);
        for (BaseDataEntity baseDataEntity : psSFCodeTemplList) {
            iPSSFCodeTemplDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ENABLEBAT, (boolean)true) == 0) {
            return this.enableBat(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_DISABLEBAT, (boolean)true) == 0) {
            return this.disableBat(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult enableBat(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSFCodeType psSFCodeType = new PSSFCodeType();
            psSFCodeType.proxy(dataEntity);
            psSFCodeType.setVALIDFLAG(1);
            this.Save(false, psSFCodeType);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u542f\u7528\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult disableBat(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSFCodeType psSFCodeType = new PSSFCodeType();
            psSFCodeType.proxy(dataEntity);
            psSFCodeType.setVALIDFLAG(0);
            this.Save(false, psSFCodeType);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u7981\u7528\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

