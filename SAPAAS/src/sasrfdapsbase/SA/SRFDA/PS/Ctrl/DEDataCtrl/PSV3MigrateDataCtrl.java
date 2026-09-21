/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDERService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModuleService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSCodeListTempl;
import SA.SRFDA.PS.Data.PSV3Migrate;
import SA.SRFDA.PS.Data.PSV3MigrateDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSV3MigrateDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSV3MigrateDataCtrl.class);
    public static final String CUSTOMCALL_INITDELIST = "INITDELIST";
    public static final String CUSTOMCALL_INITPSCODELISTTEMPL = "INITPSCODELISTTEMPL";
    public static final String CUSTOMCALL_SYNCBASE = "SYNCBASE";
    public static final String CUSTOMCALL_SYNCDER = "SYNCDER";
    public static final String CUSTOMCALL_SYNCCODELIST = "SYNCCODELIST";
    public static final String CUSTOMCALL_SYNCSYSMODEL = "SYNCSYSMODEL";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    public CallResult initDEList(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3Migrate psV3Migrate = new PSV3Migrate();
            psV3Migrate.proxy(dataEntity);
            this.onInitMigrateDEList(psV3Migrate);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u6e05\u5355\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITDELIST, (boolean)true) == 0) {
            return this.initDEList(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITPSCODELISTTEMPL, (boolean)true) == 0) {
            return this.initPSCodeListTempl(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCBASE, (boolean)true) == 0) {
            return this.syncBaseInfo(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCDER, (boolean)true) == 0) {
            return this.syncDER(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCCODELIST, (boolean)true) == 0) {
            return this.syncCodeList(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCSYSMODEL, (boolean)true) == 0) {
            return this.synsSysModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected void onInitMigrateDEList(PSV3Migrate psV3Migrate) throws Exception {
        SelectResult2 selectResult;
        int n;
        int n2;
        String[] stringArray;
        String[] preFixs;
        String strPSSystemId = psV3Migrate.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        String strSQL = "SELECT t1.* FROM V_SRFDATAENTITY t1";
        String strDENamePreFix = psV3Migrate.getDENAMEPREFIX();
        String strDEIdPreFix = psV3Migrate.getDEIDPREFIX();
        if (StringHelper.IsNullOrEmpty((String)strDEIdPreFix) && StringHelper.IsNullOrEmpty((String)strDENamePreFix)) {
            throw new Exception(StringHelper.Format((String)"\u5fc5\u987b\u5236\u5b9a\u5b9e\u4f53\u7f16\u53f7\u524d\u7f00\u6216\u662f\u540d\u79f0\u524d\u7f00"));
        }
        strDENamePreFix = strDENamePreFix.trim();
        strDENamePreFix = strDENamePreFix.toUpperCase();
        strDENamePreFix = strDENamePreFix.replace("\r\n", ";");
        strDENamePreFix = strDENamePreFix.replace("\r", ";");
        strDENamePreFix = strDENamePreFix.replace("\n", ";");
        String strCondition = "";
        if (!StringHelper.IsNullOrEmpty((String)strDENamePreFix)) {
            stringArray = preFixs = strDENamePreFix.split("[;]");
            n2 = preFixs.length;
            n = 0;
            while (n < n2) {
                String strDEName = stringArray[n];
                if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(UPPER(t1.DENAME) LIKE '%1$s%%')", (Object)strDEName);
                ++n;
            }
        }
        strDEIdPreFix = strDEIdPreFix.trim();
        strDEIdPreFix = strDEIdPreFix.toUpperCase();
        strDEIdPreFix = strDEIdPreFix.replace("\r\n", ";");
        strDEIdPreFix = strDEIdPreFix.replace("\r", ";");
        if (!StringHelper.IsNullOrEmpty((String)(strDEIdPreFix = strDEIdPreFix.replace("\n", ";")))) {
            stringArray = preFixs = strDEIdPreFix.split("[;]");
            n2 = preFixs.length;
            n = 0;
            while (n < n2) {
                String strDEId = stringArray[n];
                if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(UPPER(t1.DEID) LIKE '%1$s%%')", (Object)strDEId);
                ++n;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + StringHelper.Format((String)" WHERE (%1$s)", (Object)strCondition);
        }
        HashMap<String, String> excludeDENameMap = new HashMap<String, String>();
        String strExcludeName = psV3Migrate.getEXCLUDENAMES();
        strExcludeName = strExcludeName.toUpperCase();
        strExcludeName = strExcludeName.trim();
        strExcludeName = strExcludeName.replace("\r\n", ";");
        strExcludeName = strExcludeName.replace("\r", ";");
        if (!StringHelper.IsNullOrEmpty((String)(strExcludeName = strExcludeName.replace("\n", ";")))) {
            String[] excludes;
            String[] stringArray2 = excludes = strExcludeName.split("[;]");
            int n3 = excludes.length;
            int n4 = 0;
            while (n4 < n3) {
                String strName = stringArray2[n4];
                excludeDENameMap.put(strName, "");
                ++n4;
            }
        }
        HashMap<String, String> excludeDEIdMap = new HashMap<String, String>();
        String strExcludeId = psV3Migrate.getEXCLUDEIDS();
        strExcludeId = strExcludeId.toUpperCase();
        strExcludeId = strExcludeId.trim();
        strExcludeId = strExcludeId.replace("\r\n", ";");
        strExcludeId = strExcludeId.replace("\r", ";");
        if (!StringHelper.IsNullOrEmpty((String)(strExcludeId = strExcludeId.replace("\n", ";")))) {
            String[] excludes;
            String[] stringArray3 = excludes = strExcludeId.split("[;]");
            int n5 = excludes.length;
            int n6 = 0;
            while (n6 < n5) {
                String strId = stringArray3[n6];
                excludeDEIdMap.put(strId, "");
                ++n6;
            }
        }
        if ((selectResult = BaseDEDataCtrl.SelectMultiExReturnRS((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, null)) == null || selectResult.getRetCode() != 0) {
            connection.close();
            throw new Exception(StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo())));
        }
        try {
            try {
                int nReadSize;
                int PAGESIZE = 100;
                Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
                BaseDataEntity[] cacheDataEntities = null;
                do {
                    int i;
                    dataEntities.clear();
                    nReadSize = selectResult.getMainTable().ReadRows(PAGESIZE);
                    if (nReadSize > 0 && cacheDataEntities == null) {
                        cacheDataEntities = new BaseDataEntity[nReadSize];
                        i = 0;
                        while (i < nReadSize) {
                            cacheDataEntities[i] = new BaseDataEntity();
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < selectResult.getMainTable().GetRowCount()) {
                        DataRow dr = selectResult.getMainTable().GetRow(i);
                        BaseDataEntity dataEntity = cacheDataEntities[i];
                        dataEntity.FromDataRow(dr, true);
                        if (!excludeDENameMap.containsKey(dataEntity.getParamStringValue("DENAME", "").toUpperCase()) && !excludeDEIdMap.containsKey(dataEntity.getParamStringValue("DEID", "").toUpperCase())) {
                            dataEntities.add(dataEntity);
                        }
                        ++i;
                    }
                    if (nReadSize == 0) {
                        break;
                    }
                    this.onInitMigrateDE(psV3Migrate, dataEntities);
                    if (this.getTransactionManager() == null) continue;
                    this.getTransactionManager().CommitAndBegin();
                } while (nReadSize >= PAGESIZE);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                try {
                    selectResult.Close();
                    connection.close();
                }
                catch (Exception e) {
                    log.error((Object)e.getMessage(), (Throwable)e);
                }
                throw new Exception(StringHelper.Format((String)"\u8bbf\u95ee\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
            }
        }
        finally {
            try {
                selectResult.Close();
                connection.close();
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
            }
        }
    }

    protected void onInitMigrateDE(PSV3Migrate psV3Migrate, Vector<BaseDataEntity> dataEntities) throws Exception {
        DataEntity dataEntity = new DataEntity();
        IDEDataCtrl psV3MigrateDEDataCtrl = this.GetRelatedDataCtrl("DE2901");
        for (BaseDataEntity baseDataEntity : dataEntities) {
            dataEntity.proxy(baseDataEntity);
            PSV3MigrateDE psV3MigrateDE = new PSV3MigrateDE();
            psV3MigrateDE.setDEID(dataEntity.getDEID());
            psV3MigrateDE.setPSV3MIGRATEDENAME(dataEntity.getDENAME());
            psV3MigrateDE.setPSV3MIGRATEID(psV3Migrate.getPSV3MIGRATEID());
            CallResult callResult = psV3MigrateDEDataCtrl.AutoSave((BaseDataEntity)psV3MigrateDE);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u4fdd\u6301\u8fc1\u79fb\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult initPSCodeListTempl(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3Migrate psV3Migrate = new PSV3Migrate();
            psV3Migrate.proxy(dataEntity);
            this.onInitPSCodeListTempl(psV3Migrate);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u6e05\u5355\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitPSCodeListTempl(PSV3Migrate psV3Migrate) throws Exception {
        String strPSSystemId = psV3Migrate.getPSSYSTEMID();
        IDEDataCtrl psCodeListTemplDataCtrl = this.GetRelatedDataCtrl("DE1530");
        IDEDataCtrl psCodeListDataCtrl = this.GetRelatedDataCtrl("DE2040");
        BaseDataEntity cond = new BaseDataEntity();
        Vector psCodeListTemplList = new Vector();
        CallResult callResult = psCodeListTemplDataCtrl.Select(cond, psCodeListTemplList, PSCodeListTempl.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u4ee3\u7801\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSCodeListTempl psCodeListTempl : psCodeListTemplList) {
            SA.SRFDA.PS.Data.PSCodeList psCodeList = new SA.SRFDA.PS.Data.PSCodeList();
            psCodeListTempl.CopyTo(psCodeList, true);
            psCodeList.setPSCODELISTID(Helper.GenUniqueId((String)strPSSystemId, (String)psCodeListTempl.getPSCODELISTTEMPLID()));
            psCodeList.setPSCODELISTNAME(psCodeListTempl.getPSCODELISTTEMPLNAME());
            psCodeList.setPSSYSTEMID(strPSSystemId);
            psCodeList.setCLTYPE("STATIC");
            psCodeList.setCODELISTSN(psCodeListTempl.getPSCODELISTTEMPLID());
            psCodeList.setPSCODELISTTEMPLID(psCodeListTempl.getPSCODELISTTEMPLID());
            psCodeList.setUSERSCOPE(false);
            psCodeList.setCODENAME(psCodeListTempl.getCODENAME());
            callResult = psCodeListDataCtrl.AutoSave((BaseDataEntity)psCodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u4ee3\u7801\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.onInitPSCodeList(psCodeList);
            if (this.getTransactionManager() == null) continue;
            this.getTransactionManager().CommitAndBegin();
        }
    }

    protected void onInitPSCodeList(SA.SRFDA.PS.Data.PSCodeList psCodeList) throws Exception {
        CodeListConfig codeListConfig = this.getGlobalHelper().getCodeListMgr().GetCodeListConfig(psCodeList.getPSCODELISTTEMPLID());
        if (codeListConfig.getCodeItems() == null || codeListConfig.getCodeItems().size() == 0) {
            return;
        }
        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSCODELISTID", (Object)psCodeList.getPSCODELISTID());
        Vector psCodeItemList = new Vector();
        CallResult callResult = psCodeItemDataCtrl.Select(cond, psCodeItemList, SA.SRFDA.PS.Data.PSCodeItem.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u4ee3\u7801\u8868\u4ee3\u7801\u9879\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psCodeItemList.size() > 0) {
            return;
        }
        int i = 0;
        while (i < codeListConfig.getCodeItems().size()) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
            this.onInitPSCodeItem(psCodeList, null, codeItemConfig, i);
            ++i;
        }
    }

    protected void onInitPSCodeItem(SA.SRFDA.PS.Data.PSCodeList psCodeList, SA.SRFDA.PS.Data.PSCodeItem parentPSCodeItem, CodeItemConfig codeItemConfig, int nIndex) throws Exception {
        CallResult callResult;
        IDEDataCtrl psCodeItemDataCtrl = this.GetRelatedDataCtrl("DE2041");
        SA.SRFDA.PS.Data.PSCodeItem psCodeItem = new SA.SRFDA.PS.Data.PSCodeItem();
        psCodeItem.setPSCODELISTID(psCodeList.getPSCODELISTID());
        psCodeItem.setCODEITEMVALUE(codeItemConfig.getValue());
        psCodeItem.setPSCODEITEMNAME(codeItemConfig.getText());
        psCodeItem.setORDERVALUE(nIndex);
        if (parentPSCodeItem != null) {
            psCodeItem.setPPSCODEITEMID(parentPSCodeItem.getPSCODEITEMID());
        }
        if ((callResult = psCodeItemDataCtrl.Save(true, (BaseDataEntity)psCodeItem)).isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7cfb\u7edf\u4ee3\u7801\u8868\u4ee3\u7801\u9879\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (codeItemConfig.getCodeItems() == null || codeItemConfig.getCodeItems().size() == 0) {
            return;
        }
        int i = 0;
        while (i < codeItemConfig.getCodeItems().size()) {
            CodeItemConfig childCodeItemConfig = (CodeItemConfig)codeItemConfig.getCodeItems().get(i);
            this.onInitPSCodeItem(psCodeList, psCodeItem, childCodeItemConfig, i);
            ++i;
        }
    }

    public CallResult syncBaseInfo(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3Migrate psV3Migrate = new PSV3Migrate();
            psV3Migrate.proxy(dataEntity);
            this.onSyncBaseInfo(psV3Migrate);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncBaseInfo(PSV3Migrate psV3Migrate) throws Exception {
        IDEDataCtrl psV3MigrateDEDataCtl = this.GetRelatedDataCtrl("DE2901");
        BaseDataEntity selectCond = new BaseDataEntity();
        selectCond.set("PSV3MIGRATEID", (Object)psV3Migrate.getPSV3MIGRATEID());
        Vector psV3MigrateDEList = new Vector();
        CallResult callResult = psV3MigrateDEDataCtl.Select(selectCond, psV3MigrateDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8fc1\u79fb\u5b9e\u4f53\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BaseDataEntity baseDataEntity : psV3MigrateDEList) {
            log.debug((Object)StringHelper.Format((String)"\u540c\u6b65\u5b9e\u4f53[%1$s]\u57fa\u672c\u4fe1\u606f", (Object)baseDataEntity.getParamStringValue("PSDENAME", "")));
            callResult = psV3MigrateDEDataCtl.CustomCall(CUSTOMCALL_SYNCBASE, baseDataEntity);
            if (!callResult.isError()) continue;
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5b9e\u4f53[%2$s]\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)baseDataEntity.getParamStringValue("PSDENAME", "")));
        }
    }

    public CallResult syncDER(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3Migrate psV3Migrate = new PSV3Migrate();
            psV3Migrate.proxy(dataEntity);
            this.onSyncDER(psV3Migrate);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u5173\u7cfb\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncDER(PSV3Migrate psV3Migrate) throws Exception {
        IDEDataCtrl psV3MigrateDEDataCtl = this.GetRelatedDataCtrl("DE2901");
        BaseDataEntity selectCond = new BaseDataEntity();
        selectCond.set("PSV3MIGRATEID", (Object)psV3Migrate.getPSV3MIGRATEID());
        Vector psV3MigrateDEList = new Vector();
        CallResult callResult = psV3MigrateDEDataCtl.Select(selectCond, psV3MigrateDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8fc1\u79fb\u5b9e\u4f53\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BaseDataEntity baseDataEntity : psV3MigrateDEList) {
            log.debug((Object)StringHelper.Format((String)"\u540c\u6b65\u5b9e\u4f53[%1$s]\u5173\u7cfb\u4fe1\u606f", (Object)baseDataEntity.getParamStringValue("PSDENAME", "")));
            callResult = psV3MigrateDEDataCtl.CustomCall(CUSTOMCALL_SYNCDER, baseDataEntity);
            if (!callResult.isError()) continue;
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5b9e\u4f53[%2$s]\u5173\u7cfb\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)baseDataEntity.getParamStringValue("PSDENAME", "")));
        }
    }

    public CallResult syncCodeList(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3Migrate psV3Migrate = new PSV3Migrate();
            psV3Migrate.proxy(dataEntity);
            this.onSyncCodeList(psV3Migrate);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u4ee3\u7801\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncCodeList(PSV3Migrate psV3Migrate) throws Exception {
        IDEDataCtrl psV3MigrateDEDataCtl = this.GetRelatedDataCtrl("DE2901");
        BaseDataEntity selectCond = new BaseDataEntity();
        selectCond.set("PSV3MIGRATEID", (Object)psV3Migrate.getPSV3MIGRATEID());
        Vector psV3MigrateDEList = new Vector();
        CallResult callResult = psV3MigrateDEDataCtl.Select(selectCond, psV3MigrateDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8fc1\u79fb\u5b9e\u4f53\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BaseDataEntity baseDataEntity : psV3MigrateDEList) {
            log.debug((Object)StringHelper.Format((String)"\u540c\u6b65\u5b9e\u4f53[%1$s]\u4ee3\u7801\u8868\u4fe1\u606f", (Object)baseDataEntity.getParamStringValue("PSDENAME", "")));
            callResult = psV3MigrateDEDataCtl.CustomCall(CUSTOMCALL_SYNCCODELIST, baseDataEntity);
            if (!callResult.isError()) continue;
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u5b9e\u4f53[%2$s]\u4ee3\u7801\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)baseDataEntity.getParamStringValue("PSDENAME", "")));
        }
    }

    public CallResult synsSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class);
                    PSSystem psSystem = new PSSystem();
                    psSystem.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
                    psSystemService.get((IEntity)psSystem);
                    try {
                        PSCoreSysServiceBase.setCurrentPSSystemId((String)psSystem.getPSSystemId());
                        SessionFactoryManager.addRef();
                        PSCoreSysServiceBase.beginImpSysModel((PSSystem)psSystem);
                        ImportSessionManager.openSession();
                        PSV3MigrateDataCtrl.this.onSyncSysModel();
                        ImportSessionManager.closeSession();
                        PSCoreSysServiceBase.endImpSysModel();
                        SessionFactoryManager.releaseRef((boolean)true);
                        PSCoreSysServiceBase.setCurrentPSSystemId(null);
                    }
                    catch (Exception ex) {
                        PSCoreSysServiceBase.endImpSysModel();
                        PSCoreSysServiceBase.setCurrentPSSystemId(null);
                        SessionFactoryManager.releaseRef((boolean)false);
                        ImportSessionManager.closeSession();
                        throw ex;
                    }
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncSysModel() throws Exception {
        SessionFactory dstSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)"9D7EB067-9DCA-403C-B26B-347A5ABDA51B");
        PSSysModelInstGlobal.activeAlways((String)"9D7EB067-9DCA-403C-B26B-347A5ABDA51B");
        PSModuleService psModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class);
        PSModuleService dstPSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)dstSessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSYSTEMID", (Object)"86E2A266-4D1E-49F0-A12D-D636905457A3");
        ArrayList psModuleList = psModuleService.select((ISelectCond)selectCond);
        for (PSModule psModule : psModuleList) {
            if (dstPSModuleService.checkKey((IEntity)psModule) != 0) continue;
            dstPSModuleService.create((IEntity)psModule, false);
        }
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class);
        PSDataEntityService dstPSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)dstSessionFactory);
        ArrayList psDataEntityList = psDataEntityService.select((ISelectCond)selectCond);
        for (PSDataEntity psDataEntity : psDataEntityList) {
            try {
                PSDataEntity newPSDataEntity = new PSDataEntity();
                EntityBase.setIgnoreCheck((IEntity)newPSDataEntity, (boolean)true);
                newPSDataEntity.setPSDataEntityId(psDataEntity.getPSDataEntityId());
                newPSDataEntity.setPSDataEntityName(psDataEntity.getPSDataEntityName());
                newPSDataEntity.setPSSystemId(psDataEntity.getPSSystemId());
                newPSDataEntity.setPSSystemName(psDataEntity.getPSSystemName());
                newPSDataEntity.setPSModuleId(psDataEntity.getPSModuleId());
                newPSDataEntity.setPSModuleName(psDataEntity.getPSModuleName());
                newPSDataEntity.setDEType(psDataEntity.getDEType());
                newPSDataEntity.setLogicName(psDataEntity.getLogicName());
                newPSDataEntity.setEnaTempData(psDataEntity.getEnaTempData());
                newPSDataEntity.setIndexDEType(psDataEntity.getIndexDEType());
                newPSDataEntity.setCodeName(psDataEntity.getCodeName());
                newPSDataEntity.setTableName(psDataEntity.getTableName());
                newPSDataEntity.setViewName(psDataEntity.getViewName());
                newPSDataEntity.setLogicValid(psDataEntity.getLogicValid());
                if (dstPSDataEntityService.checkKey((IEntity)psDataEntity) != 0) continue;
                dstPSDataEntityService.create((IEntity)newPSDataEntity, false);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDataEntity.getPSDataEntityName(), (Object)ex.getMessage()));
            }
        }
        PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class);
        PSDEFieldService dstPSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)dstSessionFactory);
        for (PSDataEntity psDataEntity : psDataEntityList) {
            ArrayList psDEFieldList = psDataEntity.getPSDEFields();
            for (PSDEField psDEField : psDEFieldList) {
                try {
                    EntityBase.setIgnoreCheck((IEntity)psDEField, (boolean)true);
                    psDEField.setLNPSLanResId(null);
                    psDEField.setLNPSLanResName(null);
                    psDEField.setPSSysUnitId(null);
                    psDEField.setPSSysUnitName(null);
                    dstPSDEFieldService.save((IEntity)psDEField, false);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)psDataEntity.getPSDataEntityName(), (Object)psDEField.getPSDEFieldName(), (Object)ex.getMessage()));
                }
            }
        }
        PSCodeListService psCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class);
        PSCodeListService dstPSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)dstSessionFactory);
        PSCodeItemService dstPSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)dstSessionFactory);
        ArrayList psCodeListList = psCodeListService.select((ISelectCond)selectCond);
        for (PSCodeList psCodeList : psCodeListList) {
            try {
                if (dstPSCodeListService.checkKey((IEntity)psCodeList) != 0) continue;
                if (StringHelper.Compare((String)psCodeList.getCLType(), (String)"DYNAMIC", (boolean)true) == 0) {
                    psCodeList.setCLType("STATIC");
                    psCodeList.setPSDEDSId(null);
                    psCodeList.setPSDEDSName(null);
                    psCodeList.setMinorSortPSDEFId(null);
                    psCodeList.setMinorSortPSDEFName(null);
                    psCodeList.setMinorSortDir(null);
                    psCodeList.setIconClsPSDEFId(null);
                    psCodeList.setIconClsPSDEFName(null);
                    psCodeList.setIconClsXPSDEFId(null);
                    psCodeList.setIconClsXPSDEFName(null);
                }
                EntityBase.setIgnoreCheck((IEntity)psCodeList, (boolean)true);
                psCodeList.setEmptyTextPSLanResId(null);
                psCodeList.setEmptyTextPSLanResName(null);
                dstPSCodeListService.create((IEntity)psCodeList, false);
                ArrayList psCodeItems = psCodeList.getPSCodeItems();
                for (PSCodeItem psCodeItem : psCodeItems) {
                    EntityBase.setIgnoreCheck((IEntity)psCodeItem, (boolean)true);
                    dstPSCodeItemService.save((IEntity)psCodeItem, false);
                }
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4ee3\u7801\u8868[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psCodeList.getPSCodeListName(), (Object)ex.getMessage()));
            }
        }
        PSDERService psDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class);
        PSDERService dstPSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)dstSessionFactory);
        ArrayList psDERList = psDERService.select((ISelectCond)selectCond);
        for (PSDER psDER : psDERList) {
            try {
                if (dstPSDERService.checkKey((IEntity)psDER) != 0) continue;
                psDER.setEXTMajorPSDEFId(null);
                psDER.setEXTMajorPSDEFName(null);
                psDER.setEXTMinorPSDEFId(null);
                psDER.setEXTMinorPSDEFName(null);
                psDER.setEnaExtRange(null);
                psDER.setSDPSDEViewName(null);
                psDER.setSDPSDEViewID(null);
                psDER.setRSPSDEViewName(null);
                psDER.setRSPSDEViewId(null);
                psDER.setMDPSDEViewName(null);
                psDER.setMDPSDEViewId(null);
                psDER.setLinkPSDEViewName(null);
                psDER.setLinkPSDEViewId(null);
                psDER.setPSDEACModeId(null);
                psDER.setPSDEACModeName(null);
                psDER.setPSDEDataSetId(null);
                psDER.setPSDEDataSetName(null);
                EntityBase.setIgnoreCheck((IEntity)psDER, (boolean)true);
                dstPSDERService.save((IEntity)psDER, false);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5173\u7cfb[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDER.getPSDERName(), (Object)ex.getMessage()));
            }
        }
    }
}

