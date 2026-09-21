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
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDERDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (bInsert) {
                String strMinorPSDEName;
                PSDER psDER = new PSDER();
                psDER.proxy(dataEntity);
                String strPSDERName = "";
                String strPSDERType = psDER.getDERTYPE();
                String strMajorPSDEName = psDER.getMAJORPSDENAME();
                if (StringHelper.IsNullOrEmpty((String)strMajorPSDEName)) {
                    IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                    PSDataEntity psDataEntity = new PSDataEntity();
                    psDataEntity.setPSDATAENTITYID(psDER.getMAJORPSDEID());
                    callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4e3b\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    strMajorPSDEName = psDataEntity.getPSDATAENTITYNAME();
                }
                if (StringHelper.IsNullOrEmpty((String)(strMinorPSDEName = psDER.getMINORPSDENAME()))) {
                    IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                    PSDataEntity psDataEntity = new PSDataEntity();
                    psDataEntity.setPSDATAENTITYID(psDER.getMINORPSDEID());
                    callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5173\u7cfb\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    strMinorPSDEName = psDataEntity.getPSDATAENTITYNAME();
                }
                if (StringHelper.Compare((String)psDER.getDERTYPE(), (String)"DER1N", (boolean)true) == 0) {
                    strPSDERName = StringHelper.Format((String)"%1$s_%2$s_%3$s_%4$s", (Object)strPSDERType, (Object)strMinorPSDEName, (Object)strMajorPSDEName, (Object)psDER.getDERFIELDNAME());
                }
                if (StringHelper.Compare((String)psDER.getDERTYPE(), (String)"DERINHERIT", (boolean)true) == 0 || StringHelper.Compare((String)psDER.getDERTYPE(), (String)"DERINDEX", (boolean)true) == 0) {
                    strPSDERName = StringHelper.Format((String)"%1$s_%2$s_%3$s", (Object)strPSDERType, (Object)strMinorPSDEName, (Object)strMajorPSDEName);
                }
                psDER.setPSDERNAME(strPSDERName);
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

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (bInsert) {
                PSDER psDER = new PSDER();
                psDER.proxy(dataEntity);
                if (StringHelper.Compare((String)psDER.getDERTYPE(), (String)"DER1N", (boolean)true) == 0) {
                    IDEDataCtrl psDEFieldDataCtrl = this.GetRelatedDataCtrl("DE2051");
                    PSDEField keyPSDEField = new PSDEField();
                    keyPSDEField.setParamValue("PSDEID", psDER.getMAJORPSDEID());
                    keyPSDEField.setParamValue("PKEY", 1);
                    callResult = psDEFieldDataCtrl.Select((BaseDataEntity)keyPSDEField);
                    if (callResult.isError()) {
                        String strErrorInfo = StringHelper.Format((String)"\u83b7\u53d6\u4e3b\u5b9e\u4f53[%1$s]\u4e3b\u952e\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psDER.getMAJORPSDENAME(), (Object)callResult.getErrorInfo());
                        throw new Exception(strErrorInfo);
                    }
                    IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                    PSDataEntity minorPSDataEntity = new PSDataEntity();
                    minorPSDataEntity.setPSDATAENTITYID(psDER.getMINORPSDEID());
                    callResult = psDataEntityDataCtrl.Get((BaseDataEntity)minorPSDataEntity);
                    if (callResult.isError()) {
                        String strErrorInfo = StringHelper.Format((String)"\u83b7\u53d6\u5173\u7cfb\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psDER.getMINORPSDENAME(), (Object)callResult.getErrorInfo());
                        throw new Exception(strErrorInfo);
                    }
                    String strTableName = minorPSDataEntity.getTABLENAME();
                    PSDEField minorKeyField = new PSDEField();
                    minorKeyField.setPSDEFIELDNAME(psDER.getDERFIELDNAME());
                    minorKeyField.setDERPSDEFID(keyPSDEField.getPSDEFIELDID());
                    minorKeyField.setDERPSDEFNAME(keyPSDEField.getPSDEFIELDNAME());
                    minorKeyField.setPSDERID(psDER.getPSDERID());
                    minorKeyField.setPSDERNAME(psDER.getPSDERNAME());
                    minorKeyField.setPSDEID(minorPSDataEntity.getPSDATAENTITYID());
                    minorKeyField.setLOGICNAME(psDER.getDERFIELDLNAME());
                    if (StringHelper.IsNullOrEmpty((String)minorKeyField.getLOGICNAME())) {
                        minorKeyField.setLOGICNAME(keyPSDEField.getLOGICNAME());
                    }
                    minorKeyField.setTABLENAME(strTableName);
                    minorKeyField.setDEFTYPE(1);
                    minorKeyField.setALLOWEMPTY(true);
                    minorKeyField.setPSDATATYPEID("PICKUP");
                    minorKeyField.setMAJORFIELD(0);
                    minorKeyField.setPKEY(0);
                    minorKeyField.setFKEY(true);
                    minorKeyField.setENABLEUSERINPUT(3);
                    callResult = psDEFieldDataCtrl.AutoSave((BaseDataEntity)minorKeyField);
                    if (callResult.getRetCode() != 0) {
                        throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5916\u952e\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)ex.getMessage(), (Throwable)ex);
            return callResult;
        }
        return super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        String strDERType = webContext.GetParamValue("DERTYPE");
        dataEntity.setParamValue("DERTYPE", (Object)strDERType);
        PSDER psDER = new PSDER();
        psDER.proxy(dataEntity);
        if (StringHelper.IsNullOrEmpty((String)psDER.getPSSYSTEMID())) {
            try {
                String strPSDEId = psDER.getMAJORPSDEID();
                if (StringHelper.IsNullOrEmpty((String)strPSDEId)) {
                    strPSDEId = psDER.getMINORPSDEID();
                }
                if (!StringHelper.IsNullOrEmpty((String)strPSDEId)) {
                    IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                    PSDataEntity psDataEntity = new PSDataEntity();
                    psDataEntity.setPSDATAENTITYID(strPSDEId);
                    CallResult callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4e91\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psDER.setPSSYSTEMID(psDataEntity.getPSSYSTEMID());
                    psDER.setPSSYSTEMNAME(psDataEntity.getPSSYSTEMNAME());
                }
            }
            catch (Exception ex) {
                CallResult callResult = new CallResult();
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                log.error((Object)ex.getMessage(), (Throwable)ex);
                return callResult;
            }
        }
        return super.GetDefault(webContext, dataEntity);
    }
}

