/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEViewCtrlDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEViewCtrlDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
        psDEViewCtrl.proxy(dataEntity);
        String strConfigInfo = "";
        if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDETOOLBARNAME())) {
            if (!StringHelper.IsNullOrEmpty((String)strConfigInfo)) {
                strConfigInfo = String.valueOf(strConfigInfo) + ";";
            }
            strConfigInfo = String.valueOf(strConfigInfo) + "[\u5de5\u5177\u680f]";
            strConfigInfo = String.valueOf(strConfigInfo) + psDEViewCtrl.getPSDETOOLBARNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEGRIDNAME())) {
            if (!StringHelper.IsNullOrEmpty((String)strConfigInfo)) {
                strConfigInfo = String.valueOf(strConfigInfo) + ";";
            }
            strConfigInfo = String.valueOf(strConfigInfo) + "[\u8868\u683c]";
            strConfigInfo = String.valueOf(strConfigInfo) + psDEViewCtrl.getPSDEGRIDNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEDATAVIEWNAME())) {
            if (!StringHelper.IsNullOrEmpty((String)strConfigInfo)) {
                strConfigInfo = String.valueOf(strConfigInfo) + ";";
            }
            strConfigInfo = String.valueOf(strConfigInfo) + "[\u6570\u636e\u89c6\u56fe]";
            strConfigInfo = String.valueOf(strConfigInfo) + psDEViewCtrl.getPSDEDATAVIEWNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEFORMNAME())) {
            if (!StringHelper.IsNullOrEmpty((String)strConfigInfo)) {
                strConfigInfo = String.valueOf(strConfigInfo) + ";";
            }
            strConfigInfo = String.valueOf(strConfigInfo) + "[\u8868\u5355]";
            strConfigInfo = String.valueOf(strConfigInfo) + psDEViewCtrl.getPSDEFORMNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEDRNAME())) {
            if (!StringHelper.IsNullOrEmpty((String)strConfigInfo)) {
                strConfigInfo = String.valueOf(strConfigInfo) + ";";
            }
            strConfigInfo = String.valueOf(strConfigInfo) + "[\u5173\u7cfb\u7ec4]";
            strConfigInfo = String.valueOf(strConfigInfo) + psDEViewCtrl.getPSDEDRNAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSDEVIEWNAME())) {
            if (!StringHelper.IsNullOrEmpty((String)strConfigInfo)) {
                strConfigInfo = String.valueOf(strConfigInfo) + ";";
            }
            strConfigInfo = String.valueOf(strConfigInfo) + "[\u5b9e\u4f53\u89c6\u56fe]";
            strConfigInfo = String.valueOf(strConfigInfo) + psDEViewCtrl.getPSDEVIEWNAME();
        }
        psDEViewCtrl.setCONFIGINFO(strConfigInfo);
        return callResult;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        String strPSViewCtrlType = webContext.GetParamValue("PSDEVIEWCTRLTYPE");
        if (!StringHelper.IsNullOrEmpty((String)strPSViewCtrlType)) {
            // empty if block
        }
        return callResult;
    }
}

