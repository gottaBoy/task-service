/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Control.Form.IPSFormDetailType;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSDEFormDetailV3;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormDetailDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEFormDetailDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSDEFormDetailV3 psDEFormDetail = new PSDEFormDetailV3();
        psDEFormDetail.proxy(dataEntity);
        String strPPSDEFormDetailId = psDEFormDetail.getPPSDEFORMDETAILID();
        String strPSDEFormId = psDEFormDetail.getPSDEFORMID();
        String strFormType = psDEFormDetail.getFORMTYPE();
        String strDetailType = psDEFormDetail.getDETAILTYPE();
        if (StringHelper.IsNullOrEmpty((String)strDetailType) && lastDataEntity != null) {
            strDetailType = lastDataEntity.getParamStringValue("DETAILTYPE", "");
        }
        try {
            IPSFormDetailType iPSFormDetailType = this.getPSModelStorage().getPSFormDetailType(strDetailType);
            if (!StringHelper.IsNullOrEmpty((String)strPPSDEFormDetailId)) {
                if (lastDataEntity == null || StringHelper.Compare((String)lastDataEntity.getParamStringValue("PPSDEFORMDETAILID", ""), (String)strPPSDEFormDetailId, (boolean)false) != 0) {
                    PSDEFormDetailV3 parentPSDEFormDetail = new PSDEFormDetailV3();
                    parentPSDEFormDetail.setPSDEFORMDETAILID(strPPSDEFormDetailId);
                    callResult = this.Get(parentPSDEFormDetail);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7236\u5bf9\u8c61\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    if (!iPSFormDetailType.isSupportPFDType(parentPSDEFormDetail.getDETAILTYPE())) {
                        throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61\u4e0d\u652f\u6301\u653e\u5165\u5230\u7236\u5bf9\u8c61\u4e2d\uff0c\u7c7b\u578b\u4e0d\u652f\u6301"));
                    }
                }
            } else if (!iPSFormDetailType.isRootFDType()) {
                throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61\u4e0d\u652f\u6301\u4f5c\u4e3a\u6839\u5bf9\u8c61\uff0c\u7c7b\u578b\u4e0d\u652f\u6301"));
            }
            if (bInsert) {
                if (StringHelper.IsNullOrEmpty((String)strPSDEFormId) && !StringHelper.IsNullOrEmpty((String)strPPSDEFormDetailId)) {
                    PSDEFormDetailV3 psDEFormDetail2 = new PSDEFormDetailV3();
                    psDEFormDetail2.setPSDEFORMDETAILID(strPPSDEFormDetailId);
                    callResult = this.Get(psDEFormDetail2);
                    if (callResult.isError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7236\u8868\u5355\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    strPSDEFormId = psDEFormDetail2.getPSDEFORMID();
                    psDEFormDetail.setPSDEFORMID(strPSDEFormId);
                    psDEFormDetail.setPSDEFORMNAME(psDEFormDetail2.getPSDEFORMNAME());
                }
                if (StringHelper.IsNullOrEmpty((String)psDEFormDetail.getPSDEFORMDETAILNAME())) {
                    String strName;
                    BaseDataEntity cond = new BaseDataEntity();
                    cond.setParamValue("PSDEFORMID", (Object)strPSDEFormId);
                    Vector<PSDEFormDetailV3> psDEFormDetailList = new Vector<>();
                    callResult = StringHelper.Compare((String)strDetailType, (String)"FORMITEM", (boolean)true) == 0 ? (StringHelper.Compare((String)strFormType, (String)"EDITFORM", (boolean)true) == 0 ? this.Select(cond, psDEFormDetailList, PSDEFormDetailV3.class.getName(), "UPPER(PSDEFORMDETAILNAME) LIKE '" + psDEFormDetail.getPSDEFNAME() + "%'", "") : this.Select(cond, psDEFormDetailList, PSDEFormDetailV3.class.getName(), "UPPER(PSDEFORMDETAILNAME) LIKE '" + psDEFormDetail.getPSDEFSFITEMNAME() + "%'", "")) : this.Select(cond, psDEFormDetailList, PSDEFormDetailV3.class.getName(), "UPPER(PSDEFORMDETAILNAME) LIKE '" + strDetailType + "%'", "");
                    if (callResult.isError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u540c\u7c7b\u8868\u5355\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                    HashMap<String, PSDEFormDetailV3> psDEFormDetailMap = new HashMap<String, PSDEFormDetailV3>();
                    for (PSDEFormDetailV3 psDEFormDetail2 : psDEFormDetailList) {
                        psDEFormDetailMap.put(psDEFormDetail2.getPSDEFORMDETAILNAME().toUpperCase(), psDEFormDetail2);
                    }
                    int i = 0;
                    do {
                        strName = "";
                        ++i;
                        if (StringHelper.Compare((String)strDetailType, (String)"FORMITEM", (boolean)true) == 0) {
                            if (StringHelper.Compare((String)strFormType, (String)"EDITFORM", (boolean)true) == 0) {
                                strName = StringHelper.Format((String)"%1$s%2$s", (Object)psDEFormDetail.getPSDEFNAME(), (Object)(i == 1 ? "" : Integer.valueOf(i)));
                                continue;
                            }
                            strName = StringHelper.Format((String)"%1$s%2$s", (Object)psDEFormDetail.getPSDEFSFITEMNAME(), (Object)(i == 1 ? "" : Integer.valueOf(i)));
                            continue;
                        }
                        strName = StringHelper.Format((String)"%1$s%2$s", (Object)strDetailType, (Object)i);
                    } while (psDEFormDetailMap.containsKey(strName));
                    psDEFormDetail.setPSDEFORMDETAILNAME(strName.toLowerCase());
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

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            String strDetailType = webContext.GetParamValue("DETAILTYPE");
            dataEntity.setParamValue("DETAILTYPE", (Object)strDetailType);
            String strPSDEFormDetailId = this.getWebContext().GetParamValue("PSDEFORMDETAILID");
            if (!StringHelper.IsNullOrEmpty((String)strPSDEFormDetailId)) {
                PSDEFormDetailV3 psDEFormDetail = new PSDEFormDetailV3();
                psDEFormDetail.setPSDEFORMDETAILID(strPSDEFormDetailId);
                callResult = this.Get(psDEFormDetail);
                if (callResult.isError()) {
                    return callResult;
                }
                dataEntity.setParamValue("PPSDEFORMDETAILID", (Object)psDEFormDetail.getPSDEFORMDETAILID());
                dataEntity.setParamValue("PSDEFORMID", (Object)psDEFormDetail.getPSDEFORMID());
                dataEntity.setParamValue("FORMTYPE", (Object)psDEFormDetail.getFORMTYPE());
                dataEntity.setParamValue("PSDEID", (Object)psDEFormDetail.getPSDEID());
            } else {
                String strPSDEFormId = this.getWebContext().GetParamValue("PSDEFORMID");
                if (!StringHelper.IsNullOrEmpty((String)strPSDEFormId)) {
                    IDEDataCtrl psFormDataCtrl = this.GetRelatedDataCtrl("DE2201");
                    PSDEForm psDEForm = new PSDEForm();
                    psDEForm.setPSDEFORMID(strPSDEFormId);
                    callResult = psFormDataCtrl.Get((BaseDataEntity)psDEForm);
                    if (callResult.isError()) {
                        return callResult;
                    }
                    dataEntity.setParamValue("PSDEFORMID", (Object)psDEForm.getPSDEFORMID());
                    dataEntity.setParamValue("FORMTYPE", (Object)psDEForm.getFORMTYPE());
                    dataEntity.setParamValue("PSDEID", (Object)psDEForm.getPSDEID());
                }
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
