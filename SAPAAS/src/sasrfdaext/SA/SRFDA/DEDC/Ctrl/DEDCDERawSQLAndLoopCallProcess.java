/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.Data.DEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
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
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDCDERawSQLAndLoopCallProcess
extends DEDCProcess {
    private static final Log log = LogFactory.getLog(DEDCDERawSQLAndLoopCallProcess.class);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        BaseDAQueryModelHelper daQueryModelHelper;
        Vector<DEDataCtrl> dedcs;
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        String strDstDataEntity = processConfig.getDEDCProcess().getDSTDATAENTITY();
        BaseDataEntity dstDataEntity = null;
        if (!StringHelper.IsNullOrEmpty((String)strDstDataEntity)) {
            dstDataEntity = dedcContext.GetDataEntity(strDstDataEntity);
            if (dstDataEntity == null) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u989d\u5916\u5c5e\u6027\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strDstDataEntity));
                return callResult;
            }
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u989d\u5916\u5c5e\u6027\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strDstDataEntity));
        }
        if ((dedcs = dedcContext.GetDEHelper().GetDEDC("INTERNALCALL", processConfig.getDEDCProcess().getPARAM3())) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u64cd\u4f5c\u914d\u7f6e[%1$s]", (Object)processConfig.getDEDCProcess().getPARAM3()));
            return callResult;
        }
        boolean bEnableTran = processConfig.getDEDCProcess().getPARAM10();
        String strDBStorage = processConfig.getDEDCProcess().getPARAM1();
        String strWriteBackProperty = processConfig.getDEDCProcess().getPARAM11();
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u542f\u7528\u4e8b\u52a1[%1$s]", (Object)(bEnableTran ? "\u662f" : "\u5426")));
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6570\u636e\u5b58\u50a8\u533a\u57df[%1$s]", (Object)strDBStorage));
        Connection conn = null;
        String strSQL = processConfig.getDEDCProcess().getPARAM4();
        CallParamList callParamList = new CallParamList();
        if (dedcContext.isDebugOutput()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"SQL{\r\n%1$s\r\n}", (Object)strSQL));
        }
        try {
            String strQueryParam = processConfig.getDEDCProcess().getPARAM5();
            strQueryParam = strQueryParam.replace("\r\n", "\n");
            String[] params = strQueryParam.split("[\n]");
            int i = 0;
            while (i < params.length) {
                String strParam = params[i];
                if (!StringHelper.IsNullOrEmpty((String)(strParam = strParam.trim()))) {
                    callResult = MacroHelper.GetValue((String)strParam, (ISRFDAWebContext)dedcContext.GetWebContext(), (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)srcDataEntity);
                    if (callResult.IsError()) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5b8f\u53d8\u91cf[%1$s]", (Object)strParam));
                        return callResult;
                    }
                    callParamList.Add(callResult.getUserObject());
                    if (dedcContext.isDebugOutput()) {
                        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8ba1\u7b97\u53d8\u91cf[%1$s][%2$s]", (Object)strParam, (Object)callResult.getUserObject()));
                    }
                }
                ++i;
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            e.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u52a0\u8f7dSQL\u53d8\u91cf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()));
            return callResult;
        }
        if (bEnableTran && dedcContext.GetDataCtrl().getTransactionManager() != null) {
            conn = dedcContext.GetDataCtrl().getTransactionManager().GetConnection(strDBStorage);
        }
        String strDEHelperObject = "";
        if (!StringHelper.IsNullOrEmpty((String)strDBStorage)) {
            strDEHelperObject = dedcContext.GetGlobalHelper().getDAModelStorage().FindDBStorage(strDBStorage).GetProperty("DAQUERYMODELHELPER");
        }
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            strDEHelperObject = dedcContext.GetGlobalHelper().getWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
        }
        if ((daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strDEHelperObject)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strDEHelperObject));
            return callResult;
        }
        int nStartRow = 0;
        int nPageSize = processConfig.getDEDCProcess().getPARAM7();
        if (nPageSize <= 0) {
            nPageSize = 100;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u67e5\u8be2\u5206\u9875\u5927\u5c0f[%1$s]", (Object)nPageSize));
        int nTotalRowCount = 0;
        String strSortInfo = processConfig.getDEDCProcess().getPARAM2();
        if (StringHelper.IsNullOrEmpty((String)strSortInfo)) {
            block45: {
                SelectResult2 selectResult;
                block44: {
                    dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6267\u884c\u67e5\u8be2{\r\n%1$s\r\n}", (Object)strSQL));
                    selectResult = BaseDEDataCtrl.SelectMultiExReturnRS((ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), null, (String)strDBStorage, (String)strSQL, (Vector)callParamList.GetList());
                    if (selectResult == null || selectResult.getRetCode() != 0) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo())));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    try {
                        try {
                            int PAGESIZE = nPageSize;
                            Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
                            BaseDataEntity[] cacheDataEntities = null;
                            block7: while (true) {
                                DEDataCtrl dedc;
                                dataEntities.clear();
                                int nReadSize = selectResult.getMainTable().ReadRows(PAGESIZE);
                                if (nReadSize > 0 && cacheDataEntities == null) {
                                    cacheDataEntities = new BaseDataEntity[nReadSize];
                                    int i = 0;
                                    while (i < nReadSize) {
                                        cacheDataEntities[i] = new BaseDataEntity();
                                        ++i;
                                    }
                                }
                                int i = 0;
                                while (true) {
                                    if (i >= selectResult.getMainTable().GetRowCount()) {
                                        log.debug((Object)StringHelper.Format((String)"\u8bfb\u53d6\u8bb0\u5f55\u6570[%1$s]\uff0c\u603b\u8bb0\u5f55\u6570[%2$s]", (Object)nReadSize, (Object)(nTotalRowCount += nReadSize)));
                                        if (nReadSize != 0) break;
                                        break block44;
                                    }
                                    DataRow dr = selectResult.getMainTable().GetRow(i);
                                    BaseDataEntity dataEntity = cacheDataEntities[i];
                                    dataEntity.FromDataRow(dr, true);
                                    dataEntities.add(dataEntity);
                                    ++i;
                                }
                                if (dstDataEntity != null) {
                                    for (BaseDataEntity de : dataEntities) {
                                        dstDataEntity.CopyTo(de, false);
                                    }
                                }
                                Iterator iterator = dedcs.iterator();
                                do {
                                    if (iterator.hasNext()) continue;
                                    if (dedcContext.GetDataCtrl().getTransactionManager() != null) {
                                        dedcContext.GetDataCtrl().getTransactionManager().CommitAndBegin();
                                    }
                                    if (nReadSize >= PAGESIZE) continue block7;
                                    break block44;
                                } while (!(callResult = dedcContext.InternalCall(dedc = (DEDataCtrl)iterator.next(), dataEntities, processConfig.getDEDCProcess().getPARAM3())).IsError());
                                break;
                            }
                            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u5185\u90e8\u8c03\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            throw new Exception(StringHelper.Format((String)"\u6267\u884c\u5185\u90e8\u8c03\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        catch (Exception ex) {
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u8bbf\u95ee\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
                            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                            selectResult.Close();
                            break block45;
                        }
                    }
                    catch (Throwable throwable) {
                        selectResult.Close();
                        throw throwable;
                    }
                }
                selectResult.Close();
            }
            if (callResult.IsError()) {
                return callResult;
            }
        } else {
            strSortInfo = strSortInfo.trim();
            String strSortField = "";
            String strSordDir = "";
            if (!StringHelper.IsNullOrEmpty((String)strSortInfo)) {
                String[] parts = strSortInfo.split("[ ]");
                if (parts.length >= 1) {
                    strSortField = parts[0];
                }
                if (parts.length >= 2) {
                    strSordDir = parts[1];
                }
            }
            while (true) {
                String strPageSQL = daQueryModelHelper.GetPagingSQL(strSQL, nStartRow, nPageSize, strSortField, strSordDir, "", "");
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6267\u884c\u5206\u9875\u67e5\u8be2{\r\n%1$s\r\n}", (Object)strPageSQL));
                log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u5206\u9875\u67e5\u8be2{\r\n%1$s\r\n}", (Object)strPageSQL));
                System.out.print(StringHelper.Format((String)"\u6267\u884c\u5206\u9875\u67e5\u8be2{\r\n%1$s\r\n}\r\n", (Object)strPageSQL));
                Vector<BaseDataEntity> dataEntities = new Vector();
                callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (Connection)conn, (String)strDBStorage, (String)strPageSQL, (Vector)callParamList.GetList(), dataEntities, (String)"");
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u67e5\u8be2\u8bb0\u5f55[%1$s~%2$s]\uff0c\u83b7\u53d6\u8bb0\u5f55\u6570[%3$s]", (Object)(nStartRow + 1), (Object)(nStartRow + nPageSize), (Object)dataEntities.size()));
                log.debug((Object)StringHelper.Format((String)"\u67e5\u8be2\u8bb0\u5f55[%1$s~%2$s]\uff0c\u83b7\u53d6\u8bb0\u5f55\u6570[%3$s]", (Object)(nStartRow + 1), (Object)(nStartRow + nPageSize), (Object)dataEntities.size()));
                nTotalRowCount += dataEntities.size();
                if (dataEntities.size() == 0) break;
                if (dstDataEntity != null) {
                    for (BaseDataEntity de : dataEntities) {
                        dstDataEntity.CopyTo(de, false);
                    }
                }
                for (DEDataCtrl dedc : dedcs) {
                    callResult = dedcContext.InternalCall(dedc, dataEntities, processConfig.getDEDCProcess().getPARAM3());
                    if (!callResult.IsError()) continue;
                    log.error((Object)StringHelper.Format((String)"\u6267\u884c\u5185\u90e8\u8c03\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                if (dedcContext.GetDataCtrl().getTransactionManager() != null) {
                    dedcContext.GetDataCtrl().getTransactionManager().CommitAndBegin();
                }
                if (dataEntities.size() < nPageSize) break;
                nStartRow += nPageSize;
            }
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5904\u7406\u603b\u8bb0\u5f55\u6570[%1$s]", (Object)nTotalRowCount));
        if (!StringHelper.IsNullOrEmpty((String)strWriteBackProperty)) {
            srcDataEntity.SetParamValue(strWriteBackProperty, (Object)nTotalRowCount);
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u56de\u5199\u6e90\u6570\u636e\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)nTotalRowCount));
        }
        return callResult;
    }
}

