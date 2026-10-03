/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDRDetail;
import SA.SRFDA.PS.Data.PSDEDRItem;
import SA.SRFDA.PS.Data.PSDEDataRelation;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRItemDataCtrl
extends PSDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDRItemDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSDEDRItem psDEDRItem = new PSDEDRItem();
        psDEDRItem.proxy(dataEntity);
        return callResult;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            String strDRItemType = webContext.GetParamValue("DRITEMTYPE");
            dataEntity.setParamValue("DRITEMTYPE", (Object)strDRItemType);
            String strPSDEDRIdId = this.getWebContext().GetParamValue("PSDEDATARELATIONID");
            if (!StringHelper.IsNullOrEmpty((String)strPSDEDRIdId)) {
                IDEDataCtrl psDEDRDataCtrl = this.GetRelatedDataCtrl("DE2081");
                PSDEDataRelation psDEDataRelation = new PSDEDataRelation();
                psDEDataRelation.setPSDEDATARELATIONID(strPSDEDRIdId);
                callResult = psDEDRDataCtrl.Get((BaseDataEntity)psDEDataRelation);
                if (callResult.isError()) {
                    return callResult;
                }
                dataEntity.setParamValue("PSDEDRID", (Object)psDEDataRelation.getPSDEDATARELATIONID());
                dataEntity.setParamValue("DRITEMTYPE", (Object)strDRItemType);
                dataEntity.setParamValue("PSDEID", (Object)psDEDataRelation.getPSDEID());
            }
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2052", (boolean)true) == 0) {
                PSDER psDER = new PSDER();
                psDER.proxy(dataEntity);
                StringHelper.Compare((String)psDER.getDERTYPE(), (String)"DER1N", (boolean)true);
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void initDefaultDER1NItem(PSDER psDER) throws Exception {
        PSDEDRItem psDEDRItem = new PSDEDRItem();
        psDEDRItem.setPSDEDRITEMID(psDER.getPSDERID());
        CallResult callResult = this.Get(psDEDRItem);
        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
            psDEDRItem.setDRITEMTYPE("DER1N");
            psDEDRItem.setPSDEID(psDER.getMAJORPSDEID());
            psDEDRItem.setPSDEDRITEMNAME(psDER.getLOGICNAME());
            if (StringHelper.IsNullOrEmpty((String)psDEDRItem.getPSDEDRITEMNAME())) {
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.setPSDATAENTITYID(psDER.getMINORPSDEID());
                callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5173\u7cfb\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psDER.getMINORPSDENAME(), (Object)callResult.getErrorInfo()));
                }
                psDEDRItem.setPSDEDRITEMNAME(psDataEntity.getLOGICNAME());
            }
            psDEDRItem.setPSDEDRGROUPID(psDER.getMAJORPSDEID());
            psDEDRItem.setPSDERID(psDER.getPSDERID());
            psDEDRItem.setPSDEVIEWBASEID(psDER.getRSPSDEVIEWID());
            psDEDRItem.setVIEWPSDEID(psDER.getMINORPSDEID());
            if (StringHelper.IsNullOrEmpty((String)psDEDRItem.getPSDEVIEWBASEID())) {
                psDEDRItem.setPSDEVIEWBASEID(Helper.GenUniqueId((String)psDER.getMINORPSDEID(), (String)"DEGRIDVIEW"));
            }
            if ((callResult = this.Save(true, psDEDRItem)).isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5173\u7cfb\u754c\u9762\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            Vector<PSDEDRDetail> psDEDRDetailList = new Vector<PSDEDRDetail>();
            IDEDataCtrl psDEDRDetailDataCtrl = this.GetRelatedDataCtrl("DE2092");
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSDEDRID", (Object)psDER.getMAJORPSDEID());
            callResult = psDEDRDetailDataCtrl.Select(cond, psDEDRDetailList, PSDEDRDetail.class.getName(), "ORDER BY ORDERVALUE DESC");
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5173\u7cfb\u754c\u9762\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            PSDEDRDetail psDEDRDetail = new PSDEDRDetail();
            psDEDRDetail.setPSDEDRID(psDER.getMAJORPSDEID());
            psDEDRDetail.setPSDEDRITEMID(psDEDRItem.getPSDEDRITEMID());
            psDEDRDetail.setPSDEDRGROUPID(psDER.getMAJORPSDEID());
            if (psDEDRDetailList.size() == 0) {
                psDEDRDetail.setORDERVALUE(100);
                psDEDRDetail.setPSDEDRDETAILNAME("dritem1");
            } else {
                psDEDRDetail.setORDERVALUE(((PSDEDRDetail)((Object)psDEDRDetailList.get(0))).getORDERVALUE() + 100);
                HashMap<String, String> nameMap = new HashMap<String, String>();
                for (PSDEDRDetail psdedrDetail2 : psDEDRDetailList) {
                    nameMap.put(psdedrDetail2.getPSDEDRDETAILNAME().toLowerCase(), "");
                }
                int nIndex = 0;
                String strName = "";
                while (nameMap.containsKey(strName = StringHelper.Format((String)"dritem%1$s", (Object)(++nIndex)))) {
                }
                psDEDRDetail.setPSDEDRDETAILNAME(strName);
            }
            callResult = psDEDRDetailDataCtrl.Save(true, (BaseDataEntity)psDEDRDetail);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5173\u7cfb\u754c\u9762\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }
}
