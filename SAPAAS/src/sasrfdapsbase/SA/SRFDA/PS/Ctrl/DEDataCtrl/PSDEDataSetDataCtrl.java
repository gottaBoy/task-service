/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
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
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDSCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDSDQ;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFDA.PS.Data.PSDEDataSet;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSetDataCtrl
extends PSModelDEDataCtrl
implements IPSModelInitDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDataSetDataCtrl.class);
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEDataSet psDEDataSet = new PSDEDataSet();
            psDEDataSet.proxy(dataEntity);
            this.onGenerateCode(psDEDataSet);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u751f\u6210\u7ed3\u679c\u96c6\u5408\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateCode(PSDEDataSet psDEDataSet) throws Exception {
        IPSDataEntity iPSDataEntity = this.getPSModelStorage().getPSDataEntity(psDEDataSet.getPSDEID());
        IPSDEDataSet iPSDEDataSet = iPSDataEntity.getPSDEDataSet(psDEDataSet.getPSDEDATASETID());
        IPSSystem iPSSystem = iPSDataEntity.getPSSystem();
        Iterator<String> dbTypes = iPSSystem.getSupportDBTypes();
        while (dbTypes.hasNext()) {
            PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
            String strDBType = dbTypes.next();
            IPSDBType iDBType = this.getPSModelStorage().getPSDBType(strDBType);
            IPSDEDSCodePublisher iPSDEDSCodePublisher = iDBType.getPSDEDSCodePublisher();
            iPSDEDSCodePublisher.generateCode(psPublishContextImpl, iPSDEDataSet);
            iPSDEDSCodePublisher.close();
        }
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                String strIndexType;
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                PSDEDataSet psDEDataSet = new PSDEDataSet();
                psDEDataSet.setPSDEDATASETID(psDataEntity.getPSDATAENTITYID());
                callResult = this.Get(psDEDataSet);
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                    psDEDataSet.Reset();
                    psDEDataSet.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDEDataSet.setDEFAULTMODE(true);
                    boolean bDefault = true;
                    callResult = this.Select(psDEDataSet);
                    if (!callResult.isError()) {
                        bDefault = false;
                    }
                    psDEDataSet.Reset();
                    psDEDataSet.setPSDEDATASETID(psDataEntity.getPSDATAENTITYID());
                    psDEDataSet.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDEDataSet.setDEFAULTMODE(bDefault);
                    psDEDataSet.setPSDEDATASETNAME("DEFAULT");
                    callResult = this.Save(true, psDEDataSet);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u9ed8\u8ba4\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                    }
                    IDEDataCtrl psDEDataQueryDataCtrl = this.GetRelatedDataCtrl("DE2057");
                    PSDEDataQuery psDEDataQuery = new PSDEDataQuery();
                    psDEDataQuery.setPSDEID(psDataEntity.getPSDATAENTITYID());
                    psDEDataQuery.setPSDEDATAQUERYNAME("DEFAULT");
                    callResult = psDEDataQueryDataCtrl.Save(true, (BaseDataEntity)psDEDataQuery);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u9ed8\u8ba4\u67e5\u8be2\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                    }
                    PSDEDSDQ psDEDSDQ = new PSDEDSDQ();
                    psDEDSDQ.setPSDEDATASETID(psDEDataSet.getPSDEDATASETID());
                    psDEDSDQ.setPSDEDQID(psDEDataQuery.getPSDEDATAQUERYID());
                    IDEDataCtrl psDEDSDQDataCtrl = this.GetRelatedDataCtrl("DE2061");
                    callResult = psDEDSDQDataCtrl.Save(true, (BaseDataEntity)psDEDSDQ);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u6570\u636e\u96c6\u67e5\u8be2\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)(strIndexType = psDataEntity.getINDEXDETYPE()))) {
                    PSDEDataSet psDEDataSet2 = new PSDEDataSet();
                    psDEDataSet2.setPSDEDATASETID(Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"INDEXDETYPE", (String)strIndexType));
                    callResult = this.Get(psDEDataSet2);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        psDEDataSet2.Reset();
                        psDEDataSet2.setPSDEDATASETID(Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"INDEXDETYPE", (String)strIndexType));
                        psDEDataSet2.setPSDEID(psDataEntity.getPSDATAENTITYID());
                        psDEDataSet2.setDEFAULTMODE(false);
                        psDEDataSet2.setPREDEFINETYPE("INDEXDE");
                        psDEDataSet2.setPSDEDATASETNAME("IndexDER");
                        psDEDataSet2.setCODENAME("IndexDER");
                        callResult = this.Save(true, psDEDataSet2);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u7d22\u5f15\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                }
                if (psDataEntity.getENAMULTIFORM() > 0) {
                    PSDEDataSet psDEDataSet3 = new PSDEDataSet();
                    psDEDataSet3.setPSDEDATASETID(Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"FORMTYPE", (String)""));
                    callResult = this.Get(psDEDataSet3);
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
                        psDEDataSet3.Reset();
                        psDEDataSet3.setPSDEDATASETID(Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"FORMTYPE", (String)""));
                        psDEDataSet3.setPSDEID(psDataEntity.getPSDATAENTITYID());
                        psDEDataSet3.setDEFAULTMODE(false);
                        psDEDataSet3.setPREDEFINETYPE("MULTIFORM");
                        psDEDataSet3.setPSDEDATASETNAME("FormType");
                        psDEDataSet3.setCODENAME("FormType");
                        callResult = this.Save(true, psDEDataSet3);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u8868\u5355\u7c7b\u578b\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                        }
                    }
                }
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
}

