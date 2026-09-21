/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PSDCInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Paas.PSDCInstImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSysModelInstDataCtrl;
import SA.SRFDA.PS.Data.PSDCInst;
import SA.SRFDA.PS.Data.PSSysModelVer;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.pscore.srv.util.PSDCInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCInstDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCInstDataCtrl.class);
    public static final String CUSTOMCALL_INIT = "INIT";
    public static final String CUSTOMCALL_CLOSESF = "CLOSESF";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INIT, (boolean)true) == 0) {
            return this.initSysModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CLOSESF, (boolean)true) == 0) {
            return this.closeSessionFactory(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDCInst psDCInst = new PSDCInst();
            psDCInst.proxy(dataEntity);
            this.onInitSysModel(psDCInst);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitSysModel(PSDCInst psDCInst) throws Exception {
        IDEDataCtrl psSysModelVerDataCtrl = this.GetRelatedDataCtrl("DE1896");
        PSSysModelVer psSysModelVer = new PSSysModelVer();
        psSysModelVer.setACTIVEFLAG(true);
        psSysModelVer.setDBTYPE(psDCInst.getDBTYPE());
        CallResult callResult = psSysModelVerDataCtrl.Select((BaseDataEntity)psSysModelVer, "", "ORDER BY MODELVER DESC ");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u6a21\u578b\u7248\u672c"));
        }
        PSSysModelInstDataCtrl.fillPSSysModelVer(this.getGlobalHelper(), psSysModelVer);
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(psDCInst.getDBTYPE());
        PSSysModelVer curPSSysModelVer = null;
        int nCurModelVer = psDCInst.getMODELVER();
        if (nCurModelVer != psSysModelVer.getMODELVER()) {
            curPSSysModelVer = new PSSysModelVer();
            curPSSysModelVer.setMODELVER(nCurModelVer);
            curPSSysModelVer.setDBTYPE(psDCInst.getDBTYPE());
            callResult = psSysModelVerDataCtrl.Select((BaseDataEntity)curPSSysModelVer);
            if (callResult.isError()) {
                log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b\u7248\u672c[%1$s][%2$s]", (Object)psDCInst.getDBTYPE(), (Object)nCurModelVer));
                curPSSysModelVer = null;
            }
            if (curPSSysModelVer != null) {
                PSSysModelInstDataCtrl.fillPSSysModelVer(this.getGlobalHelper(), curPSSysModelVer);
            }
        }
        HashMap<Object, String> lastSqlMap = new HashMap<Object, String>();
        if (curPSSysModelVer != null) {
            ArrayList<String> modelList = new ArrayList<String>();
            if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getMODELSQL())) {
                modelList.add(curPSSysModelVer.getMODELSQL());
            }
            if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getMODELSQL2())) {
                modelList.add(curPSSysModelVer.getMODELSQL2());
            }
            if (!StringHelper.IsNullOrEmpty((String)curPSSysModelVer.getMODELSQL3())) {
                modelList.add(curPSSysModelVer.getMODELSQL3());
            }
            for (String strModel : modelList) {
                String[] sqls;
                String[] stringArray = sqls = StringHelper.Split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
                int n = sqls.length;
                int n2 = 0;
                while (n2 < n) {
                    Object strSql = stringArray[n2];
                    if (!StringHelper.IsNullOrEmpty((String)(strSql = ((String)strSql).trim()))) {
                        lastSqlMap.put(strSql, "");
                    }
                    ++n2;
                }
            }
        }
        PSDCInstImpl psDCInstImpl = null;
        try {
            psDCInstImpl = new PSDCInstImpl();
            psDCInstImpl.init(this.getGlobalHelper(), psDCInst);
            ArrayList<String> modelList = new ArrayList<String>();
            if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL())) {
                modelList.add(psSysModelVer.getMODELSQL());
            }
            if (StringHelper.Compare((String)psDCInst.getINSTSTATE(), (String)"10", (boolean)true) != 0 && !StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL2())) {
                modelList.add(psSysModelVer.getMODELSQL2());
            }
            if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL3())) {
                modelList.add(psSysModelVer.getMODELSQL3());
            }
            if (!StringHelper.IsNullOrEmpty((String)psSysModelVer.getMODELSQL4())) {
                modelList.add(psSysModelVer.getMODELSQL4());
            }
            ArrayList<String> modelList2 = new ArrayList<String>();
            for (String strModel : modelList) {
                String[] sqls;
                String[] stringArray = sqls = StringHelper.Split((String)strModel, (String)"/**\u5206\u5272\u7ebf**/");
                int n = sqls.length;
                int n3 = 0;
                while (n3 < n) {
                    String strSql = stringArray[n3];
                    if (!StringHelper.IsNullOrEmpty((String)(strSql = strSql.trim())) && !lastSqlMap.containsKey(strSql)) {
                        modelList2.add(strSql);
                    }
                    ++n3;
                }
            }
            int nIndex = 0;
            int nTotalSize = modelList2.size();
            for (String strSql : modelList2) {
                log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u6a21\u578b\u4ee3\u7801[%1$s/%2$s]\r\n%3$s", (Object)(++nIndex), (Object)nTotalSize, (Object)strSql));
                callResult = iPSDBType.callCreateDBModelSql(psDCInstImpl, strSql);
                if (!callResult.isError()) continue;
                log.error((Object)callResult.getErrorInfo());
            }
            if (psDCInstImpl != null) {
                psDCInstImpl.close();
            }
        }
        catch (Exception ex) {
            if (psDCInstImpl != null) {
                psDCInstImpl.close();
            }
            throw ex;
        }
        if (StringHelper.IsNullOrEmpty((String)psDCInst.getINSTSTATE()) || StringHelper.Compare((String)psDCInst.getINSTSTATE(), (String)"10", (boolean)true) == 0) {
            psDCInst.setINSTSTATE("20");
        }
        psDCInst.setMODELVER(psSysModelVer.getMODELVER());
        callResult = this.Save(false, psDCInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u6a21\u578b\u5b9e\u4f8b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult closeSessionFactory(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            PSDCInst psDCInst = new PSDCInst();
            psDCInst.proxy(dataEntity);
            PSDCInstGlobal.resetSessionFactory((String)psDCInst.getPSDCINSTID());
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u4e2d\u5fc3\u5b9e\u4f8b\u4f1a\u8bdd\u5de5\u5382\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

