/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.DGModelColumnConfig
 *  SA.SRFDA.Model.DataGridModelConfig
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DGModelColumnConfig;
import SA.SRFDA.Model.DataGridModelConfig;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEGrid;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSV3Migrate;
import SA.SRFDA.PS.Data.PSV3MigrateDEGrid;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.Random;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSV3MigrateDEGridDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSV3MigrateDEGridDataCtrl.class);
    public static final String CUSTOMCALL_SYNCBASE = "SYNCBASE";
    public static final String CUSTOMCALL_REPLACEDEFAULT = "REPLACEDEFAULT";
    private static Random random = new Random();

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCBASE, (boolean)true) == 0) {
            return this.syncBaseInfo(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_REPLACEDEFAULT, (boolean)true) == 0) {
            return this.replaceDefaultGrid(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult syncBaseInfo(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDEGrid psV3MigrateDEGrid = new PSV3MigrateDEGrid();
            psV3MigrateDEGrid.proxy(dataEntity);
            if (psV3MigrateDEGrid.getIGNOREFLAG()) {
                return callResult;
            }
            this.onSyncBaseInfo(psV3MigrateDEGrid);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u8868\u683c\u57fa\u672c\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncBaseInfo(PSV3MigrateDEGrid psV3MigrateDEGrid) throws Exception {
        PSV3Migrate psV3Migrate = new PSV3Migrate();
        psV3Migrate.setPSV3MIGRATEID(psV3MigrateDEGrid.getPSV3MIGRATEID());
        IDEDataCtrl psV3MigrateDataCtrl = this.GetRelatedDataCtrl("DE2900");
        CallResult callResult = psV3MigrateDataCtrl.Get((BaseDataEntity)psV3Migrate);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u8fc1\u79fb\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strPSSystemId = psV3Migrate.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        IPSSystemDeploy defaultPSSystemDeploy = iPSSystem.getDefaultPSSystemDeploy();
        Exception exception = null;
        Connection connection = defaultPSSystemDeploy.getDefaultPSSystemDeployDB().getConnection();
        try {
            String strSQL = "SELECT t1.* FROM V_SRFDATAGRID t1 WHERE DATAGRIDID=?";
            CallParamList callParamList = new CallParamList();
            callParamList.Add((Object)psV3MigrateDEGrid.getDEGRIDID());
            DataGrid dataGrid = new DataGrid();
            callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)connection, (String)"", (String)strSQL, (Vector)callParamList.GetList(), (BaseDataEntity)dataGrid);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            IDEDataCtrl psDEGridDataCtrl = this.GetRelatedDataCtrl("DE2210");
            IDEDataCtrl psDEGridColDataCtrl = this.GetRelatedDataCtrl("DE2211");
            String strPSDEId = Helper.GenUniqueId((String)iPSSystem.getId(), (String)psV3MigrateDEGrid.getDENAME().toUpperCase());
            String strPSDEGridId = Helper.GenUniqueId((String)strPSDEId, (String)dataGrid.getDATAGRIDID());
            PSDEGrid psDEGrid = new PSDEGrid();
            psDEGrid.setPSDEGRIDID(strPSDEGridId);
            callResult = psDEGridDataCtrl.Get((BaseDataEntity)psDEGrid);
            if (callResult.isError()) {
                psDEGrid.setPSDEID(strPSDEId);
                psDEGrid.setPSDENAME(psV3MigrateDEGrid.getDENAME());
                psDEGrid.setPSDEGRIDNAME(dataGrid.getDATAGRIDNAME());
                psDEGrid.setPAGINGSIZE(dataGrid.getPAGESIZE());
                psDEGrid.setENABLEPAGINGBAR(1);
                psDEGrid.setGRIDSN(dataGrid.getDATAGRIDID());
                if (dataGrid.GetParamIntValue("ISMAJOR", 1) == 1) {
                    psDEGrid.setCODENAME("Main2");
                } else {
                    psDEGrid.setCODENAME(StringHelper.Format((String)"G%1$s", (Object)random.nextInt(100)));
                }
                callResult = psDEGridDataCtrl.Save(true, (BaseDataEntity)psDEGrid);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSDEGRIDID", (Object)psDEGrid.getPSDEGRIDID());
            Vector psDEGridColumnList = new Vector();
            callResult = psDEGridColDataCtrl.Select(cond, psDEGridColumnList, PSDEGridColumn.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5b9e\u4f53\u8868\u683c\u5217\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (psDEGridColumnList.size() > 0) {
                return;
            }
            try {
                DataGridModelConfig dataGridModelConfig = dataGrid.getDataGridModelConfig();
                IDEHelper iDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(dataGrid.getDEID());
                int nOrderValue = 0;
                for (DGModelColumnConfig columnConfig : dataGridModelConfig.getColumnsConfig()) {
                    ++nOrderValue;
                    IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(columnConfig.getDEField());
                    if (iDEFHelper == null) continue;
                    PSDEGridColumn psDEGridColumn = new PSDEGridColumn();
                    psDEGridColumn.setPSDEGRIDCOLNAME(iDEFHelper.getName());
                    psDEGridColumn.setORDERVALUE(nOrderValue);
                    psDEGridColumn.setPSDEGRIDID(psDEGrid.getPSDEGRIDID());
                    psDEGridColumn.setPSDEID(psDEGrid.getPSDEID());
                    psDEGridColumn.setWIDTH(columnConfig.getWidth());
                    psDEGridColumn.setPSDEFID(Helper.GenUniqueId((String)psDEGrid.getPSDEID(), (String)iDEFHelper.getName().toUpperCase()));
                    psDEGridColumn.setGRIDCOLTYPE("DEFGRIDCOLUMN");
                    callResult = psDEGridColDataCtrl.Save(true, (BaseDataEntity)psDEGridColumn);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u4e91\u5b9e\u4f53\u8868\u683c\u5217[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)iDEFHelper.getName(), (Object)callResult.getErrorInfo()));
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
                exception = new Exception(e);
                connection.close();
                if (exception != null) {
                    throw exception;
                }
            }
        }
        finally {
            connection.close();
            if (exception != null) {
                throw exception;
            }
        }
    }

    public CallResult replaceDefaultGrid(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSV3MigrateDEGrid psV3MigrateDEGrid = new PSV3MigrateDEGrid();
            psV3MigrateDEGrid.proxy(dataEntity);
            if (psV3MigrateDEGrid.getIGNOREFLAG()) {
                return callResult;
            }
            this.onReplaceDefaultGrid(psV3MigrateDEGrid);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66ff\u6362\u9ed8\u8ba4\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onReplaceDefaultGrid(PSV3MigrateDEGrid psV3MigrateDEGrid) throws Exception {
        String strPSDEId;
        PSV3Migrate psV3Migrate = new PSV3Migrate();
        psV3Migrate.setPSV3MIGRATEID(psV3MigrateDEGrid.getPSV3MIGRATEID());
        IDEDataCtrl psV3MigrateDataCtrl = this.GetRelatedDataCtrl("DE2900");
        CallResult callResult = psV3MigrateDataCtrl.Get((BaseDataEntity)psV3Migrate);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u8fc1\u79fb\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strPSSystemId = psV3Migrate.getPSSYSTEMID();
        String strDefaultEditGridId = strPSDEId = Helper.GenUniqueId((String)strPSSystemId, (String)psV3MigrateDEGrid.getDENAME().toUpperCase());
        String strPSDEGridId = Helper.GenUniqueId((String)strPSDEId, (String)psV3MigrateDEGrid.getDEGRIDID());
        String strPSDEGridName = psV3MigrateDEGrid.getPSV3MGGRIDNAME();
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEGRIDID", (Object)strDefaultEditGridId);
        Vector<PSDEViewCtrl> psDEViewCtrlList = new Vector<PSDEViewCtrl>();
        IDEDataCtrl psDEViewCtrlDataCtrl = this.GetRelatedDataCtrl("DE2302");
        callResult = psDEViewCtrlDataCtrl.Select(cond, psDEViewCtrlList, PSDEViewCtrl.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u8868\u683c\u5f15\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList) {
            psDEViewCtrl.setPSDEGRIDID(strPSDEGridId);
            psDEViewCtrl.setPSDEGRIDNAME(strPSDEGridName);
            callResult = psDEViewCtrlDataCtrl.Save(false, (BaseDataEntity)psDEViewCtrl);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u89c6\u56fe\u8868\u683c\u5f15\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}
