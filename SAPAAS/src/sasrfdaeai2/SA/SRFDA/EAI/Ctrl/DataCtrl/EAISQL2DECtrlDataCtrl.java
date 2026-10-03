/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DEAction
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTask
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTaskPolicy
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Data.EAISQL2DECtrl;
import SA.SRFDA.EAI.Data.EAISQL2DECtrlLog;
import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskPolicy;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EAISQL2DECtrlDataCtrl
extends BaseDEDataCtrl {
    public static final String CUSTOMCALL_RUNCTRL = "RUNCTRL";
    private static final Log log = LogFactory.getLog(EAISQL2DECtrlDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RUNCTRL, (boolean)false) == 0) {
            return this.RunCtrl(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult RunCtrl(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        EAISQL2DECtrl eaiSQL2DECtrl = new EAISQL2DECtrl();
        dataEntity.CopyTo((BaseDataEntity)eaiSQL2DECtrl, false);
        callResult = this.Get(eaiSQL2DECtrl);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8f6c\u6362\u903b\u8f91[%1$s]\u53d1\u751f\u9519\u8bef,%2$s", (Object)eaiSQL2DECtrl.getEAISQL2DECTRLID(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        if (eaiSQL2DECtrl.getRUNFLAG()) {
            log.warn((Object)StringHelper.Format((String)"\u8f6c\u6362\u903b\u8f91[%1$s]\u6807\u8bb0\u4e3a\u6b63\u5728\u8fd0\u884c\uff0c\u65e0\u6cd5\u518d\u6b21\u8fd0\u884c\u3002", (Object)eaiSQL2DECtrl.getEAISQL2DECTRLID()));
            return callResult;
        }
        EAISQL2DECtrl eaiSQL2DECtrl2 = new EAISQL2DECtrl();
        eaiSQL2DECtrl2.setEAISQL2DECTRLID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
        eaiSQL2DECtrl2.SetParamValue("SRFDAUPDATEDATE", eaiSQL2DECtrl.GetParamValue("UPDATEDATE"));
        eaiSQL2DECtrl2.setRUNFLAG(true);
        callResult = this.Save(false, eaiSQL2DECtrl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8f6c\u6362\u903b\u8f91[%1$s]\u4e3a\u8fd0\u884c\u72b6\u6001\u53d1\u751f\u9519\u8bef,%2$s", (Object)eaiSQL2DECtrl.getEAISQL2DECTRLID(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        eaiSQL2DECtrl2.Reset();
        eaiSQL2DECtrl2.setEAISQL2DECTRLID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
        eaiSQL2DECtrl2.setRUNFLAG(false);
        EAISQL2DECtrlLog eaiSQL2DECtrlLog = new EAISQL2DECtrlLog();
        eaiSQL2DECtrlLog.setEAISQL2DECTRLID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
        eaiSQL2DECtrlLog.setEAISQL2DECTRLNAME(eaiSQL2DECtrl.getEAISQL2DECTRLNAME());
        eaiSQL2DECtrlLog.setRETCODE(0);
        try {
            eaiSQL2DECtrlLog.setSTARTTIME(new Timestamp(new Date().getTime()));
            this.OnRunCtrl(eaiSQL2DECtrl);
        }
        catch (Exception ex) {
            eaiSQL2DECtrlLog.setRETCODE(1);
            eaiSQL2DECtrlLog.setRETINFO(ex.getMessage());
            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u903b\u8f91[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)eaiSQL2DECtrl.getEAISQL2DECTRLID(), (Object)ex.getMessage()));
        }
        eaiSQL2DECtrlLog.setENDTIME(new Timestamp(new Date().getTime()));
        eaiSQL2DECtrlLog.SetParamValue("LASTRUNTAG", eaiSQL2DECtrl.GetParamValue("LASTRUNTAG"));
        eaiSQL2DECtrlLog.SetParamValue("LASTRUNTAG2", eaiSQL2DECtrl.GetParamValue("LASTRUNTAG2"));
        eaiSQL2DECtrlLog.SetParamValue("LASTRUNTAG3", eaiSQL2DECtrl.GetParamValue("LASTRUNTAG3"));
        eaiSQL2DECtrlLog.SetParamValue("ROWCOUNT", eaiSQL2DECtrl.GetParamValue("EXECUTECOUNT"));
        eaiSQL2DECtrl2.SetParamValue("LASTRUNTAG", eaiSQL2DECtrl.GetParamValue("LASTRUNTAG"));
        eaiSQL2DECtrl2.SetParamValue("LASTRUNTAG2", eaiSQL2DECtrl.GetParamValue("LASTRUNTAG2"));
        eaiSQL2DECtrl2.SetParamValue("LASTRUNTAG3", eaiSQL2DECtrl.GetParamValue("LASTRUNTAG3"));
        eaiSQL2DECtrl2.SetParamValue("LASTRUNTIME", new Timestamp(new Date().getTime()));
        try {
            IDEDataCtrl eaiSQL2DECtrlLogDataCtrl = this.GetRelatedDataCtrl("EAI0091");
            callResult = eaiSQL2DECtrlLogDataCtrl.Save(true, (BaseDataEntity)eaiSQL2DECtrlLog);
            if (callResult.IsError()) {
                throw new Exception(callResult.getErrorInfo());
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6dfb\u52a0\u903b\u8f91[%1$s]\u8fd0\u884c\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)eaiSQL2DECtrl.getEAISQL2DECTRLID(), (Object)ex.getMessage()));
        }
        callResult = this.Save(false, eaiSQL2DECtrl2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8f6c\u6362\u903b\u8f91[%1$s]\u751f\u9519\u8bef,%2$s", (Object)eaiSQL2DECtrl2.getEAISQL2DECTRLID(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void OnRunCtrl(EAISQL2DECtrl eaiSQL2DECtrl) throws Exception {
        CallResult callResult;
        block32: {
            SelectResult2 selectResult;
            block31: {
                BaseDAQueryModelHelper daQueryModelHelper;
                String strDBStorage = eaiSQL2DECtrl.getDBSTORAGE();
                String strDEHelperObject = "";
                if (!StringHelper.IsNullOrEmpty((String)strDBStorage)) {
                    strDEHelperObject = this.globalHelperEx.getDAModelStorage().FindDBStorage(strDBStorage).GetProperty("DAQUERYMODELHELPER");
                }
                if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
                    strDEHelperObject = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
                }
                if ((daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strDEHelperObject)) == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strDEHelperObject));
                }
                int nTotalRowCount = 0;
                int nExecuteCount = 0;
                int nPageSize = eaiSQL2DECtrl.getPAGESIZE();
                if (nPageSize <= 0) {
                    nPageSize = 100;
                }
                nPageSize = 100;
                log.debug((Object)StringHelper.Format((String)"\u67e5\u8be2\u5206\u9875\u5927\u5c0f[%1$s]", (Object)nPageSize));
                String strSortField = "";
                String strSordDir = "";
                String strSortField2 = "";
                String strSordDir2 = "";
                String strSortInfo = eaiSQL2DECtrl.getORDERINFO();
                if (!StringHelper.IsNullOrEmpty((String)strSortInfo)) {
                    strSortInfo = strSortInfo.trim();
                    strSortInfo = strSortInfo.replace("  ", " ");
                    strSortInfo = strSortInfo.replace("  ", " ");
                    if (!StringHelper.IsNullOrEmpty((String)(strSortInfo = strSortInfo.replace("  ", " ")))) {
                        String[] parts;
                        String[] items = strSortInfo.split(",");
                        if (items.length >= 1) {
                            strSortInfo = items[0];
                            parts = strSortInfo.split("[ ]");
                            if (parts.length >= 1) {
                                strSortField = parts[0];
                            }
                            if (parts.length >= 2) {
                                strSordDir = parts[1];
                            }
                        }
                        if (items.length >= 2) {
                            strSortInfo = items[1];
                            parts = strSortInfo.split("[ ]");
                            if (parts.length >= 1) {
                                strSortField2 = parts[0];
                            }
                            if (parts.length >= 2) {
                                strSordDir2 = parts[1];
                            }
                        }
                    }
                }
                DEAction deAction = new DEAction();
                deAction.setDEACTIONID(eaiSQL2DECtrl.getDEACTIONID());
                IDEDataCtrl deActionDataCtrl = this.GetRelatedDataCtrl("DE0205");
                callResult = deActionDataCtrl.Get((BaseDataEntity)deAction);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u884c\u4e3a[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)deAction.getDEACTIONID(), (Object)callResult.getErrorInfo()));
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u884c\u4e3a[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)deAction.getDEACTIONID(), (Object)callResult.getErrorInfo()));
                }
                String strSQL = eaiSQL2DECtrl.getQUERYSQL();
                BaseDataEntity lastRunInfo = new BaseDataEntity();
                eaiSQL2DECtrl.CopyTo(lastRunInfo, true);
                CallParamList callParamList = null;
                if (!StringHelper.IsNullOrEmpty((String)eaiSQL2DECtrl.getCONTEXTPARAMS())) {
                    callParamList = new CallParamList();
                    String[] params = StringHelper.SplitEx((String)eaiSQL2DECtrl.getCONTEXTPARAMS());
                    int i = 0;
                    while (i < params.length) {
                        callParamList.Add(lastRunInfo.get(params[i]));
                        ++i;
                    }
                }
                String strPageSQL = daQueryModelHelper.GetSortSQL(strSQL, strSortField, strSordDir, strSortField2, strSordDir2);
                log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u5206\u9875\u67e5\u8be2{\r\n%1$s\r\n}", (Object)strPageSQL));
                selectResult = BaseDEDataCtrl.SelectMultiExReturnRS((ISRFDAGlobalHelper)this.getGlobalHelper(), null, (String)strDBStorage, (String)strPageSQL, (Vector)(callParamList == null ? null : callParamList.GetList()));
                if (selectResult == null || selectResult.getRetCode() != 0) {
                    String string;
                    if (selectResult == null) {
                        string = "\u672a\u77e5\u9519\u8bef";
                        throw new Exception(StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)string));
                    }
                    string = selectResult.getErrorInfo();
                    throw new Exception(StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)string));
                }
                try {
                    try {
                        int PAGESIZE = nPageSize;
                        Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
                        BaseDataEntity[] cacheDataEntities = null;
                        block5: while (true) {
                            int i;
                            dataEntities.clear();
                            int nReadSize = selectResult.getMainTable().ReadRows(PAGESIZE);
                            if (nReadSize > 0 && cacheDataEntities == null) {
                                cacheDataEntities = new BaseDataEntity[nReadSize];
                                i = 0;
                                while (i < nReadSize) {
                                    cacheDataEntities[i] = new BaseDataEntity();
                                    ++i;
                                }
                            }
                            i = 0;
                            while (true) {
                                if (i >= selectResult.getMainTable().GetRowCount()) {
                                    log.debug((Object)StringHelper.Format((String)"\u8bfb\u53d6\u8bb0\u5f55\u6570[%1$s]\uff0c\u603b\u8bb0\u5f55\u6570[%2$s]", (Object)nReadSize, (Object)(nTotalRowCount += nReadSize)));
                                    if (nReadSize != 0) break;
                                    break block31;
                                }
                                DataRow dr = selectResult.getMainTable().GetRow(i);
                                BaseDataEntity dataEntity = cacheDataEntities[i];
                                dataEntity.FromDataRow(dr, true);
                                dataEntities.add(dataEntity);
                                ++i;
                            }
                            DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                            transactionManager.Init(this.getGlobalHelper());
                            IDEDataCtrl iDEDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl(deAction.getDEID(), this.getOPPersonId(), this.getWebContext());
                            transactionManager.Register(iDEDataCtrl);
                            int i2 = 0;
                            while (true) {
                                if (i2 >= dataEntities.size()) {
                                    if (nReadSize >= PAGESIZE) continue block5;
                                    break block31;
                                }
                                BaseDataEntity dataEntity = (BaseDataEntity)dataEntities.get(i2);
                                callResult = iDEDataCtrl.Execute(deAction, dataEntity);
                                if (callResult.IsError()) {
                                    transactionManager.Rollback();
                                    throw new Exception(StringHelper.Format((String)"\u6267\u884c\u903b\u8f91\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                                }
                                ++nExecuteCount;
                                if (i2 == dataEntities.size() - 1) {
                                    transactionManager.Commit();
                                } else {
                                    transactionManager.CommitAndBegin();
                                }
                                dataEntity.CopyTo(lastRunInfo, true);
                                eaiSQL2DECtrl.SetParamValue("LASTRUNTAG", lastRunInfo.GetParamValue("LASTRUNTAG"));
                                eaiSQL2DECtrl.SetParamValue("LASTRUNTAG2", lastRunInfo.GetParamValue("LASTRUNTAG2"));
                                eaiSQL2DECtrl.SetParamValue("LASTRUNTAG3", lastRunInfo.GetParamValue("LASTRUNTAG3"));
                                eaiSQL2DECtrl.SetParamValue("LASTRUNTIME", new Timestamp(new Date().getTime()));
                                eaiSQL2DECtrl.SetParamValue("EXECUTECOUNT", nExecuteCount);
                                ++i2;
                            }
                        }
                    }
                    catch (Exception ex) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(ex.getMessage());
                        log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                        selectResult.Close();
                        break block32;
                    }
                }
                catch (Throwable throwable) {
                    selectResult.Close();
                    throw throwable;
                }
            }
            selectResult.Close();
        }
        if (!callResult.IsError()) return;
        throw new Exception(callResult.getErrorInfo());
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            IDEDataCtrl tsSDTaskDataCtrl;
            EAISQL2DECtrl eaiSQL2DECtrl = new EAISQL2DECtrl();
            dataEntity.CopyTo((BaseDataEntity)eaiSQL2DECtrl, false);
            TSSDTask tsSDTask = new TSSDTask();
            tsSDTask.setTSSDTASKID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
            tsSDTask.setTSSDTASKNAME(eaiSQL2DECtrl.getEAISQL2DECTRLNAME());
            tsSDTask.setTSSDENGINEID(eaiSQL2DECtrl.getTASKENGINE());
            tsSDTask.setENABLEFLAG(eaiSQL2DECtrl.getVALIDFLAG());
            tsSDTask.setDESCRIPTION(eaiSQL2DECtrl.getMEMO());
            if (bInsert) {
                tsSDTask.setTSSDTASKTYPEID("UID_201262611574165800110987939");
                String strTaskParam = StringHelper.Format((String)"DEID=%1$s\r\n", (Object)this.GetDEHelper().getId());
                strTaskParam = String.valueOf(strTaskParam) + StringHelper.Format((String)"CUSTOMCALL=RUNCTRL\r\n");
                strTaskParam = String.valueOf(strTaskParam) + StringHelper.Format((String)"EAISQL2DECTRLID=%1$s\r\n", (Object)eaiSQL2DECtrl.getEAISQL2DECTRLID());
                tsSDTask.setTASKPARAM(strTaskParam);
                tsSDTask.setUSERDATA(StringHelper.Format((String)"EAISQL2DECTRLID=%1$s", (Object)eaiSQL2DECtrl.getEAISQL2DECTRLID()));
            }
            if ((callResult = (tsSDTaskDataCtrl = this.GetRelatedDataCtrl("TS0026")).Save(bInsert, (BaseDataEntity)tsSDTask)).IsError()) {
                return callResult;
            }
            TSSDTaskPolicy tsSDTaskPolicy = new TSSDTaskPolicy();
            tsSDTaskPolicy.setTSSDTASKPOLICYID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
            tsSDTaskPolicy.setTSSDTASKID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
            tsSDTaskPolicy.setTSSDPOLICYID(eaiSQL2DECtrl.getTASKTIME());
            IDEDataCtrl tsSDTaskPolicyDataCtrl = this.GetRelatedDataCtrl("TS0027");
            callResult = tsSDTaskPolicyDataCtrl.Save(bInsert, (BaseDataEntity)tsSDTaskPolicy);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            EAISQL2DECtrl eaiSQL2DECtrl = new EAISQL2DECtrl();
            dataEntity.CopyTo((BaseDataEntity)eaiSQL2DECtrl, false);
            TSSDTaskPolicy tsSDTaskPolicy = new TSSDTaskPolicy();
            tsSDTaskPolicy.setTSSDTASKPOLICYID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
            IDEDataCtrl tsSDTaskPolicyDataCtrl = this.GetRelatedDataCtrl("TS0027");
            callResult = tsSDTaskPolicyDataCtrl.Remove(strActionMode, (BaseDataEntity)tsSDTaskPolicy);
            if (callResult.IsError()) {
                return callResult;
            }
            TSSDTask tsSDTask = new TSSDTask();
            tsSDTask.setTSSDTASKID(eaiSQL2DECtrl.getEAISQL2DECTRLID());
            IDEDataCtrl tsSDTaskDataCtrl = this.GetRelatedDataCtrl("TS0026");
            callResult = tsSDTaskDataCtrl.Remove(strActionMode, (BaseDataEntity)tsSDTask);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return super.OnBeforeRemove(strActionMode, dataEntity);
    }
}

