/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.PS.Data.PSPFStyleCode;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFAppTemplDataCtrl
extends PSPFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSPFAppTemplDataCtrl.class);
    public static final String CUSTOMCALL_MERGECODE = "MERGECODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSPFAppTempl psPFAppTempl = new PSPFAppTempl();
            psPFAppTempl.proxy(dataEntity);
            String strPSPFAPPTEMPLNAME = StringHelper.Format((String)"%1$s/%2$s/%3$s", (Object)psPFAppTempl.getPSPFNAME(), (Object)psPFAppTempl.getPSPFSTYLENAME(), (Object)psPFAppTempl.getPSPFPUBCODENAME());
            psPFAppTempl.setPSPFAPPTEMPLNAME(strPSPFAPPTEMPLNAME);
            psPFAppTempl.setPSPFAPPTEMPLID(Helper.GenUniqueId((String)psPFAppTempl.getPSPFID(), (String)psPFAppTempl.getPSPFSTYLEID(), (String)psPFAppTempl.getPSPFPUBCODEID()));
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
            PSPFAppTempl psPFAppTempl = new PSPFAppTempl();
            psPFAppTempl.proxy(dataEntity);
            this.onMergeCode(psPFAppTempl);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5408\u5e76\u5e94\u7528\u6a21\u7248\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onMergeCode(PSPFAppTempl psPFAppTempl) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSPFSTYLEID", (Object)psPFAppTempl.getPSPFSTYLEID());
        IDEDataCtrl psPFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1800");
        Vector<PSPFStyleCode> psPFStyleCodes = new Vector<PSPFStyleCode>();
        CallResult callResult = psPFStyleCodeDataCtrl.Select(cond, psPFStyleCodes, PSPFStyleCode.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5c55\u73b0\u6837\u5f0f\u5b8f\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strTEMPLCODE = psPFAppTempl.getTEMPLCODE2();
        if (psPFStyleCodes.size() != 0) {
            int i = 0;
            while (i < 10) {
                boolean bChanged = false;
                for (PSPFStyleCode psPFStyleCode : psPFStyleCodes) {
                    String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)psPFStyleCode.getPSPFSTYLECODENAME().toUpperCase());
                    if (strTEMPLCODE.indexOf(strTag) == -1) continue;
                    strTEMPLCODE = strTEMPLCODE.replace(strTag, psPFStyleCode.getSTYLECODE());
                    bChanged = true;
                }
                if (!bChanged) break;
                ++i;
            }
        }
        if (StringHelper.Compare((String)strTEMPLCODE, (String)psPFAppTempl.getTEMPLCODE(), (boolean)true) == 0) {
            return;
        }
        psPFAppTempl.setTEMPLCODE(strTEMPLCODE);
        callResult = this.Save(false, psPFAppTempl);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u5408\u5e76\u5c55\u73b0\u6837\u5f0f\u5e94\u7528\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSPFAppTempl psPFAppTempl = new PSPFAppTempl();
        psPFAppTempl.proxy(dataEntity);
        BaseDataEntity psPFStyle = this.GetRelatedData("DE1595", psPFAppTempl.getPSPFSTYLEID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1595");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psPFStyle);
        return StringHelper.Format((String)"%1$s%2$sPSPFAPPTEMPL%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)psPFAppTempl.getPSPFPUBCODENAME());
    }

    @Override
    protected HashMap<String, String> getCodeTemplMap() throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("TEMPLCODE", "");
        map.put("TEMPLCODE2", "");
        return map;
    }
}
