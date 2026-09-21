/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.SASRFDataException
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DBUtility;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DERType;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.SASRFDataException;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataEntityDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DataEntityDataCtrl.class);
    public static final String CUSTOMCALL_CREATEVIEW = "CREATEVIEW";
    public static final String CUSTOMCALL_CREATEDECLASS = "CREATEDECLASS";
    public static final String CUSTOMCALL_PREPAREMETHOD = "PREPAREMETHOD";
    public static final String CUSTOMCALL_CHANGEVERSION = "CHANGEVERSION";
    public static final String CUSTOMCALL_EMPTYUSERTABLE = "EMPTYUSERTABLE";
    public static final String GETMODE_FULLINFO = "FULLINFO";
    protected IDBModelHelper iDBModelHelper = null;
    protected String strCreateUserTable = "";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (bInsert) {
            this.strCreateUserTable = dataEntity.GetParamStringValue("CREATEUSERTABLE", "");
        }
        return callResult;
    }

    @Override
    protected CallResult OnTestSave(boolean insert, String strActionType, BaseDataEntity dataEntity, Vector<ValueError> errors) {
        String strStorageType;
        CallResult callResult = super.OnTestSave(insert, strActionType, dataEntity, errors);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DataEntity de = new DataEntity();
        de.Proxy(dataEntity);
        String strDER11DEID = de.getDER11DEID();
        if (!StringHelper.IsNullOrEmpty((String)strDER11DEID) && de.isINDEXDE()) {
            ValueError valueError1 = new ValueError();
            valueError1.setValue("DER11DEID");
            valueError1.setErrorCode(3);
            valueError1.setErrorInfo("1:1\u5173\u7cfb\u5b9e\u4f53\u4e0e\u7d22\u5f15\u5b9e\u4f53\u4e0d\u80fd\u540c\u65f6\u6307\u5b9a");
            errors.add(valueError1);
            ValueError valueError2 = new ValueError();
            valueError2.setValue("ISINDEXDE");
            valueError2.setErrorCode(3);
            valueError2.setErrorInfo("1:1\u5173\u7cfb\u5b9e\u4f53\u4e0e\u7d22\u5f15\u5b9e\u4f53\u4e0d\u80fd\u540c\u65f6\u6307\u5b9a");
            errors.add(valueError2);
            callResult.setRetCode(5);
            return callResult;
        }
        if (insert && de.isEXITINGMODEL() && (StringHelper.IsNullOrEmpty((String)(strStorageType = de.getSTORAGETYPE())) || StringHelper.Compare((String)strStorageType, (String)"STATIC", (boolean)true) == 0)) {
            String strTableName = de.getTABLENAME();
            if (StringHelper.IsNullOrEmpty((String)strTableName)) {
                errors.add(new ValueError("TABLENAME", 1));
                callResult.setRetCode(5);
                return callResult;
            }
            if (!this.IsTableExist(de.getDBSTORAGE(), strTableName)) {
                errors.add(new ValueError("TABLENAME", 3, "\u6307\u5b9a\u7684\u8868\u4e0d\u5b58\u5728"));
                callResult.setRetCode(5);
                return callResult;
            }
        }
        return callResult;
    }

    protected boolean IsTableExist(String strDBStorage, String strTableName) {
        BaseDataEntity rowCount;
        String strSQL = this.GetDEDataCtrlHelper(strDBStorage).GetSQL_IsTableExist(strTableName);
        CallResult callResult = DataEntityDataCtrl.SelectSingleEx(this.globalHelperEx, strDBStorage, strSQL, rowCount = new BaseDataEntity());
        if (callResult.getRetCode() != 0) {
            return false;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        return nRowCnt == 1;
    }

    protected IDEDataCtrlHelper GetDEDataCtrlHelper(String strDBStorage) {
        return this.globalHelperEx.getDEDataCtrlHelper(strDBStorage);
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean insert, String strActionType, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        IDEHelper iDEHelper;
        IDEDataCtrl iDEDataCtrl;
        CallResult callResult = super.OnAfterSaveOK(insert, strActionType, dataEntity, lastDataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DataEntity de = new DataEntity();
        dataEntity.CopyTo((BaseDataEntity)de, true);
        if (insert) {
            boolean bCreateTable = true;
            String strStorageType = this.iDEHelper.getDataEntity().getSTORAGETYPE();
            if (StringHelper.Compare((String)strStorageType, (String)"NONE", (boolean)true) == 0 || StringHelper.Compare((String)strStorageType, (String)"DYNAMIC", (boolean)true) == 0) {
                bCreateTable = false;
            }
            if (bCreateTable) {
                boolean bl = bCreateTable = !de.isEXITINGMODEL();
            }
            if (bCreateTable) {
                IDBModelHelper iDBModelHelper;
                if (!StringHelper.IsNullOrEmpty((String)this.strCreateUserTable)) {
                    de.set("CREATEUSERTABLE", this.strCreateUserTable);
                }
                if ((callResult = (iDBModelHelper = DBUtility.GetDBModelHelper(de, this.globalHelperEx)).CreateTableAndView()).getRetCode() == 0) {
                    DataEntity updateDE = new DataEntity();
                    de.CopyTo(updateDE, "DEID|TABLENAME|VIEWNAME|EXTABLENAME", true);
                    callResult = this.Save(false, updateDE);
                    if (callResult.getRetCode() == 0) {
                        String strTableName = dataEntity.GetParamStringValue("TABLENAME", "");
                        String strUserTableName = dataEntity.GetParamStringValue("EXTABLENAME", "");
                        if (!StringHelper.IsNullOrEmpty((String)strTableName) && StringHelper.IsNullOrEmpty((String)strUserTableName)) {
                            updateDE.SetParamValue("EXTABLENAME", "");
                            callResult = this.Save(false, updateDE);
                            if (!callResult.IsError()) {
                                log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5b9e\u4f53\u8868\u53ca\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            } else {
                                iDBModelHelper = DBUtility.GetDBModelHelper(updateDE, this.globalHelperEx);
                                callResult = iDBModelHelper.CreateView();
                            }
                        }
                        updateDE.CopyTo(dataEntity, true);
                        return callResult;
                    }
                }
            } else {
                log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5b9e\u4f53\u8868\u53ca\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        if (StringHelper.Compare((String)de.getDEID(), (String)"DE0001", (boolean)true) != 0 && (iDEDataCtrl = (iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(de.getDEID(), true)).GetDEDataCtrl(this.getOPPersonId(), this.getWebContext())) != null && iDEDataCtrl.GetDEHelper().GetKeyDEFHelper() != null) {
            iDEDataCtrl.PrepareMethod(true);
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CREATEVIEW, (boolean)true) == 0) {
            String strDEId = dataEntity.GetParamStringValue("DEID", "");
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo("\u6570\u636e\u5b9e\u4f53\u7f16\u53f7\u65e0\u6548");
                return callResult;
            }
            IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                return callResult;
            }
            IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(iDEHelper.getDataEntity(), this.globalHelperEx);
            if (iDBModelHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6DB\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61"));
                return callResult;
            }
            return iDBModelHelper.CreateView();
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PREPAREMETHOD, (boolean)true) == 0) {
            String strDEId = dataEntity.GetParamStringValue("DEID", "");
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo("\u6570\u636e\u5b9e\u4f53\u7f16\u53f7\u65e0\u6548");
                return callResult;
            }
            IDEDataCtrl iDEDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl(strDEId, this.getWebContext());
            if (iDEDataCtrl != null) {
                return iDEDataCtrl.PrepareMethod(true);
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
            return callResult;
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CHANGEVERSION, (boolean)true) == 0) {
            String strDEId = dataEntity.GetParamStringValue("DEID", "");
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo("\u6570\u636e\u5b9e\u4f53\u7f16\u53f7\u65e0\u6548");
                return callResult;
            }
            DataEntity de = new DataEntity();
            de.setDEID(strDEId);
            return this.Save(false, de);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CREATEDECLASS, (boolean)true) == 0) {
            return this.CreateDEClass(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EMPTYUSERTABLE, (boolean)true) == 0) {
            return this.EmptyUserTable(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult EmptyUserTable(BaseDataEntity dataEntity) {
        CallResult callresult = new CallResult();
        DataEntity de = new DataEntity();
        dataEntity.CopyTo((BaseDataEntity)de, true);
        callresult = this.Get(de);
        if (callresult.getRetCode() != 0) {
            return callresult;
        }
        String strEXTABLENAME = de.getEXTABLENAME();
        if (!StringHelper.IsNullOrEmpty((String)strEXTABLENAME)) {
            de.setEXTABLENAME("");
            callresult = this.Save(false, de);
            if (callresult.getRetCode() != 0) {
                return callresult;
            }
            String strSQL = "DROP TABLE %1$s";
            strSQL = StringHelper.Format((String)strSQL, (Object)strEXTABLENAME);
            try {
                this.globalHelperEx.getDBCaller().CallRaw2(strSQL);
            }
            catch (SASRFDataException e) {
                e.printStackTrace();
                callresult.setRetCode(1);
                callresult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u7528\u6237\u8868\u51fa\u9519\uff0c%1$s", (Object)e.getMessage()));
                log.error((Object)e.getMessage());
            }
        } else {
            return callresult;
        }
        return callresult;
    }

    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult;
        if (bFrameOnly) {
            baseDataEntity.RemoveParam("DEUSERPARAM");
        }
        if ((callResult = super.OnExport(baseDataEntity, list, bFrameOnly)).getRetCode() != 0) {
            return callResult;
        }
        String strDEId = baseDataEntity.GetParamStringValue("DEID", "");
        Vector<DERType> derTypes = new Vector<DERType>();
        callResult = this.globalHelperEx.getDAModelHelper().GetDERTypes(strDEId, derTypes);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b\u96c6\u5408\u9519\u8bef");
            return callResult;
        }
        IDEDataCtrl derTypeDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0005", this.strCurOpPersonId, this.getWebContext());
        if (derTypeDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61", (Object)"DE0005"));
            return callResult;
        }
        for (DERType derType : derTypes) {
            derTypeDataCtrl.Export(derType, list, true, bFrameOnly);
        }
        Vector<DER1N> der1ns = new Vector<DER1N>();
        callResult = this.globalHelperEx.getDAModelHelper().GetDERN1s(strDEId, der1ns);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53N:1\u5173\u7cfb\u96c6\u5408\u9519\u8bef");
            return callResult;
        }
        IDEDataCtrl der1nDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0003", this.strCurOpPersonId, this.getWebContext());
        if (der1nDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[DE0003]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61"));
            return callResult;
        }
        for (DER1N der1n : der1ns) {
            der1nDataCtrl.Export(der1n, list, true, bFrameOnly);
        }
        Vector<DERINDEX> derIndexs = new Vector<DERINDEX>();
        callResult = this.globalHelperEx.getDAModelHelper().GetDERINDEXs(false, strDEId, derIndexs);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53INDEX\u5173\u7cfb\u96c6\u5408\u9519\u8bef");
            return callResult;
        }
        IDEDataCtrl derIndexDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0016", this.strCurOpPersonId, this.getWebContext());
        if (derIndexDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[DE0016]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61"));
            return callResult;
        }
        for (DERINDEX derIndex : derIndexs) {
            derIndexDataCtrl.Export(derIndex, list, true, bFrameOnly);
        }
        IDEHelper iTargetDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId);
        if (iTargetDEHelper != null && iTargetDEHelper.IsInheritMode()) {
            XMLNode xmlNode = new XMLNode();
            xmlNode.SetValue("SRFDEID", "DE0001");
            BaseDataEntity tempDE = new BaseDataEntity();
            tempDE.SetParamValue("DEID", (Object)strDEId);
            xmlNode.SetValue("SRFARG", BaseDataEntity.ToString((BaseDataEntity)tempDE));
            xmlNode.SetValue("SRFCUSTOMCALL", CUSTOMCALL_CHANGEVERSION);
            list.add(xmlNode);
            xmlNode = new XMLNode();
            xmlNode.SetValue("SRFDEID", "DE0002");
            tempDE = new BaseDataEntity();
            tempDE.SetParamValue("DEID", (Object)strDEId);
            xmlNode.SetValue("SRFARG", BaseDataEntity.ToString((BaseDataEntity)tempDE));
            xmlNode.SetValue("SRFCUSTOMCALL", "SYNCINHERITDEFIELD");
            list.add(xmlNode);
        }
        Vector<DEField> defields = new Vector<DEField>();
        callResult = this.globalHelperEx.getDAModelHelper().GetDEFields(strDEId, defields);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u9519\u8bef");
            return callResult;
        }
        IDEHelper fieldDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0002");
        if (fieldDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[DE0002]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61"));
            return callResult;
        }
        IDEDataCtrl fieldDataCtrl = fieldDEHelper.GetDEDataCtrl(this.strCurOpPersonId, this.getWebContext());
        for (DEField field : defields) {
            fieldDataCtrl.Export(field, list, true, bFrameOnly);
        }
        IDEDataCtrl formDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0007", this.strCurOpPersonId, this.getWebContext());
        if (formDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[DE0007]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61"));
            return callResult;
        }
        Form form = new Form();
        String strMainFormId = StringHelper.Format((String)"%1$s_MAINFORM", (Object)strDEId);
        form.setFORMID(strMainFormId);
        formDataCtrl.Export(form, list, true, bFrameOnly);
        IDEDataCtrl dataGridDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0008", this.strCurOpPersonId, this.getWebContext());
        if (dataGridDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[DE0008]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61"));
            return callResult;
        }
        DataGrid dataGrid = new DataGrid();
        String strDataGridId = StringHelper.Format((String)"%1$s_DATAGRID", (Object)strDEId);
        dataGrid.setDATAGRIDID(strDataGridId);
        dataGridDataCtrl.Export(dataGrid, list, true, bFrameOnly);
        Vector<DEDataCtrl> deDataCtrls = new Vector<DEDataCtrl>();
        callResult = this.globalHelperEx.getDAModelHelper().GetDEDataCtrls(strDEId, deDataCtrls);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u6709\u8bef");
            return callResult;
        }
        IDEDataCtrl iDEDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0210", this.getWebContext());
        if (iDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61", (Object)"DE0210"));
            return callResult;
        }
        for (DEDataCtrl deDataCtrl : deDataCtrls) {
            iDEDataCtrl.Export(deDataCtrl, list, true, bFrameOnly);
        }
        Vector<BaseDataEntity> dbActions = new Vector<BaseDataEntity>();
        iDEDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0047", this.getWebContext());
        if (iDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61", (Object)"DE0047"));
            return callResult;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("DEID", (Object)strDEId);
        callResult = iDEDataCtrl.Select(cond, dbActions);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u6570\u636e\u64cd\u4f5c\u903b\u8f91\u6709\u8bef");
            return callResult;
        }
        for (BaseDataEntity de : dbActions) {
            iDEDataCtrl.Export(de, list, true, bFrameOnly);
        }
        Vector<BaseDataEntity> dbActionSteps = new Vector<BaseDataEntity>();
        iDEDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0048", this.getWebContext());
        if (iDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61", (Object)"DE0048"));
            return callResult;
        }
        cond = new BaseDataEntity();
        cond.SetParamValue("DEID", (Object)strDEId);
        callResult = iDEDataCtrl.Select(cond, dbActionSteps);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u6570\u636e\u64cd\u4f5c\u903b\u8f91\u6709\u8bef");
            return callResult;
        }
        for (BaseDataEntity de : dbActionSteps) {
            iDEDataCtrl.Export(de, list, true, bFrameOnly);
        }
        Vector<QueryModel> queryModels = new Vector<QueryModel>();
        callResult = this.globalHelperEx.getDAModelHelper().GetSelectQueryModels(strDEId, queryModels);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u67e5\u8be2\u641c\u7d22\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        if (queryModels.size() > 0) {
            iDEDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0023", this.getWebContext());
            if (iDEDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61", (Object)"DE0023"));
                return callResult;
            }
            for (QueryModel queryModel : queryModels) {
                iDEDataCtrl.Export(queryModel, list, true, bFrameOnly);
            }
        }
        XMLNode xmlNode = new XMLNode();
        xmlNode.SetValue("SRFDEID", "DE0001");
        BaseDataEntity tempDE = new BaseDataEntity();
        tempDE.SetParamValue("DEID", (Object)strDEId);
        xmlNode.SetValue("SRFARG", BaseDataEntity.ToString((BaseDataEntity)tempDE));
        xmlNode.SetValue("SRFCUSTOMCALL", CUSTOMCALL_CREATEVIEW);
        list.add(xmlNode);
        xmlNode = new XMLNode();
        xmlNode.SetValue("SRFDEID", "DE0001");
        tempDE = new BaseDataEntity();
        tempDE.SetParamValue("DEID", (Object)strDEId);
        xmlNode.SetValue("SRFARG", BaseDataEntity.ToString((BaseDataEntity)tempDE));
        xmlNode.SetValue("SRFCUSTOMCALL", CUSTOMCALL_PREPAREMETHOD);
        list.add(xmlNode);
        if (StringHelper.Compare((String)strDEId, (String)"DE0001", (boolean)true) == 0) {
            callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            xmlNode = new XMLNode();
            xmlNode.SetValue("SRFDEID", "DE0001");
            tempDE = new BaseDataEntity();
            tempDE.SetParamValue("DEID", (Object)strDEId);
            xmlNode.SetValue("SRFARG", BaseDataEntity.ToString((BaseDataEntity)tempDE));
            xmlNode.SetValue("SRFCUSTOMCALL", CUSTOMCALL_CREATEVIEW);
            list.add(xmlNode);
            xmlNode = new XMLNode();
            xmlNode.SetValue("SRFDEID", "DE0001");
            tempDE = new BaseDataEntity();
            tempDE.SetParamValue("DEID", (Object)strDEId);
            xmlNode.SetValue("SRFARG", BaseDataEntity.ToString((BaseDataEntity)tempDE));
            xmlNode.SetValue("SRFCUSTOMCALL", CUSTOMCALL_PREPAREMETHOD);
            list.add(xmlNode);
        }
        return callResult;
    }

    protected CallResult CreateDEClass(BaseDataEntity dataEntity) {
        ILinkDEFHelper linkDEFHelper;
        String temp;
        CallResult callResult = new CallResult();
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(dataEntity.GetParamStringValue("DEID", ""));
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dataEntity.GetParamValue("DEID")));
            return callResult;
        }
        StringBuilderEx sb = new StringBuilderEx();
        String strClassName = iDEHelper.GetDEViewName();
        int nPos = strClassName.indexOf("_");
        strClassName = strClassName.substring(nPos + 1);
        sb.Append("----------\u5f00\u59cb-----------\r\n");
        sb.Append("import java.util.Date;");
        sb.Append("import SA.SRFramework.DataEx.BaseDataEntity;\r\n\r\n");
        sb.Append("public class " + strClassName + " extends BaseDataEntity{\r\n");
        sb.Append("//SA iBizSys 3.0 \u81ea\u52a8\u53d1\u5e03\u4ee3\u7801\uff0c\u5f00\u59cb\r\n");
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            CodeItemConfig codeItemConfig;
            int i;
            String temp2;
            String strCodeListId;
            if (iDEFHelper.IsSystemReserver() || StringHelper.IsNullOrEmpty((String)(strCodeListId = iDEFHelper.GetCodeList())) || (temp2 = iDEFHelper.GetDataType().toString()).equals("YESNO") || temp2.equals("TRUEFALSE")) continue;
            CodeListConfig codeListConfig = this.getGlobalHelper().getCodeListMgr().GetCodeListConfig(strCodeListId);
            if (codeListConfig == null) {
                sb.Append("\r\n//\u5c5e\u6027[%1$s]\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%2$s]\u914d\u7f6e\uff0c\u8bf7\u68c0\u67e5\r\n\r\n", (Object)iDEFHelper.getName(), (Object)strCodeListId);
                continue;
            }
            if (codeListConfig.isUserScope() || codeListConfig.getCodeItems() == null) continue;
            sb.Append("\r\n//\u5b9a\u4e49" + iDEFHelper.getLogicName("").toString() + "\u4ee3\u7801\u8868\r\n\r\n");
            if (temp2.equals("NSCODELIST") || temp2.equals("NMCODELIST")) {
                i = 0;
                while (i < codeListConfig.getCodeItems().size()) {
                    codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                    sb.Append("/**\r\n*%1$s\r\n*/", (Object)codeItemConfig.getText());
                    sb.Append("\r\npublic final static int " + iDEFHelper.getName() + "_%1$s = %1$s ;\r\n\r\n", (Object)codeItemConfig.getValue());
                    ++i;
                }
                continue;
            }
            i = 0;
            while (i < codeListConfig.getCodeItems().size()) {
                codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                sb.Append("/**\r\n*%1$s\r\n*/", (Object)codeItemConfig.getText());
                sb.Append("\r\npublic final static String " + iDEFHelper.getName() + "_%1$s = \"%1$s\" ;\r\n\r\n", (Object)codeItemConfig.getValue());
                ++i;
            }
        }
        sb.Append("\r\n\r\n\r\n\r\n//----------------------------\u5c5e\u6027\u9759\u6001\u6807\u8bc6\u5b9a\u4e49---------------------------\r\n");
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            sb.Append("/**\r\n*\u5b9a\u4e49" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/");
            sb.Append("\r\npublic final static String TAG_" + iDEFHelper.getName() + " =\"" + iDEFHelper.getName() + "\";\r\n\r\n");
        }
        sb.Append("\r\n\r\n\r\n\r\n//-------------------------------------------------------------------------------\r\n");
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            temp = iDEFHelper.GetDataType().toString();
            if (iDEFHelper.IsLinkDEField()) {
                linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                temp = linkDEFHelper.GetRealDEFHelper().GetDataType();
            }
            sb.Append("/**\r\n*\u5224\u65ad" + iDEFHelper.getLogicName("").toString() + "\u662f\u5426\u6709\u503c\r\n*/\r\n");
            sb.Append("final public boolean is" + iDEFHelper.getName() + "Null() {return IsParamNull(TAG_" + iDEFHelper.getName() + ");}\r\n");
            if (temp.equals("YESNO") || temp.equals("TRUEFALSE")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public boolean get" + iDEFHelper.getName() + "() {return GetParamIntValue(TAG_" + iDEFHelper.getName() + ",0) == 1;}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public void set" + iDEFHelper.getName() + "(boolean bValue){SetParamValue(TAG_" + iDEFHelper.getName() + ",bValue?1:0);}\r\n");
                continue;
            }
            if (temp.equals("FLOAT") || temp.equals("DOUBLE") || temp.equals("CURRENCY")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public float get" + iDEFHelper.getName() + "() {return GetParamFloatValue(TAG_" + iDEFHelper.getName() + ",0);}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public void set" + iDEFHelper.getName() + "(float fValue){SetParamValue(TAG_" + iDEFHelper.getName() + ",fValue);}\r\n");
                continue;
            }
            if (temp.equals("INT") || temp.equals("NBID") || temp.equals("NSCODELIST") || temp.equals("NMCODELIST")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public int get" + iDEFHelper.getName() + "() {return GetParamIntValue(TAG_" + iDEFHelper.getName() + ",0);}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public void set" + iDEFHelper.getName() + "(int nValue){SetParamValue(TAG_" + iDEFHelper.getName() + ",nValue);}\r\n");
                continue;
            }
            if (temp.equals("DATETIME") || temp.equals("DATE") || temp.equals("TIME")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public Date get" + iDEFHelper.getName() + "() {return GetParamDateValue(TAG_" + iDEFHelper.getName() + ",null);}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public void set" + iDEFHelper.getName() + "(Date dtValue){SetParamValue(TAG_" + iDEFHelper.getName() + ",dtValue);}\r\n");
                continue;
            }
            sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
            sb.Append("final public String get" + iDEFHelper.getName() + "() {return GetParamStringValue(TAG_" + iDEFHelper.getName() + ",\"\");}\r\n");
            sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
            sb.Append("final public void set" + iDEFHelper.getName() + "(String strValue){SetParamValue(TAG_" + iDEFHelper.getName() + ",strValue);}\r\n");
        }
        sb.Append("//SA iBizSys 3.0 \u81ea\u52a8\u53d1\u5e03\u4ee3\u7801\uff0c\u7ed3\u675f\r\n");
        sb.Append("}");
        sb.Append("----------\u7ed3\u675f-----------\r\n\r\n\r\n\r\n\r\n\r\n");
        sb.Append("//----------get \u63a5\u53e3\u65b9\u6cd5-----------\r\n");
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsSystemReserver() || iDEFHelper.IsKeyDEField() || iDEFHelper.IsMajorDEField()) continue;
            temp = iDEFHelper.GetDataType().toString();
            if (iDEFHelper.IsLinkDEField()) {
                linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                if (!linkDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)linkDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) continue;
                temp = linkDEFHelper.GetRealDEFHelper().GetDataType();
            }
            if (temp.equals("YESNO") || temp.equals("TRUEFALSE")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\r\n*/\r\n");
                sb.Append("boolean is" + iDEFHelper.getCodeName() + "();\r\n");
                continue;
            }
            if (temp.equals("FLOAT") || temp.equals("DOUBLE") || temp.equals("CURRENCY")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\r\n*/\r\n");
                sb.Append("float get" + iDEFHelper.getCodeName() + "() ;\r\n");
                continue;
            }
            if (temp.equals("INT") || temp.equals("NBID") || temp.equals("NSCODELIST") || temp.equals("NMCODELIST")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\r\n*/\r\n");
                sb.Append("int get" + iDEFHelper.getCodeName() + "();\r\n");
                continue;
            }
            if (temp.equals("DATETIME") || temp.equals("DATE") || temp.equals("TIME")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\r\n*/\r\n");
                sb.Append("Date get" + iDEFHelper.getCodeName() + "() ;\r\n");
                continue;
            }
            sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\r\n*/\r\n");
            sb.Append(" String get" + iDEFHelper.getCodeName() + "();\r\n");
        }
        sb.Append("//----------\u53d8\u91cf\u5b9a\u4e49-----------\r\n");
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsSystemReserver() || iDEFHelper.IsKeyDEField() || iDEFHelper.IsMajorDEField()) continue;
            temp = iDEFHelper.GetDataType().toString();
            if (iDEFHelper.IsLinkDEField()) {
                linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                if (!linkDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)linkDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) continue;
                temp = linkDEFHelper.GetRealDEFHelper().GetDataType();
            }
            sb.Append("/**\r\n*" + iDEFHelper.getLogicName("").toString() + "\r\n*/\r\n");
            if (temp.equals("YESNO") || temp.equals("TRUEFALSE")) {
                sb.Append("private boolean b" + iDEFHelper.getCodeName() + "=false;\r\n");
                continue;
            }
            if (temp.equals("FLOAT") || temp.equals("DOUBLE") || temp.equals("CURRENCY")) {
                sb.Append("private float f" + iDEFHelper.getCodeName() + "=0;\r\n");
                continue;
            }
            if (temp.equals("INT") || temp.equals("NBID") || temp.equals("NSCODELIST") || temp.equals("NMCODELIST")) {
                sb.Append("private int n" + iDEFHelper.getCodeName() + "=0;\r\n");
                continue;
            }
            if (temp.equals("DATETIME") || temp.equals("DATE") || temp.equals("TIME")) {
                sb.Append("private Date dt" + iDEFHelper.getCodeName() + "=null;\r\n");
                continue;
            }
            sb.Append("private String str" + iDEFHelper.getCodeName() + "=\"\";\r\n");
        }
        sb.Append("//----------get/set\u65b9\u6cd5-----------\r\n");
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsSystemReserver() || iDEFHelper.IsKeyDEField() || iDEFHelper.IsMajorDEField()) continue;
            temp = iDEFHelper.GetDataType().toString();
            if (iDEFHelper.IsLinkDEField()) {
                linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                if (!linkDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)linkDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) continue;
                temp = linkDEFHelper.GetRealDEFHelper().GetDataType();
            }
            if (temp.equals("YESNO") || temp.equals("TRUEFALSE")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public boolean is" + iDEFHelper.getCodeName() + "() {return this.b" + iDEFHelper.getCodeName() + ";}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final protected void set" + iDEFHelper.getCodeName() + "(boolean bValue){this.b" + iDEFHelper.getCodeName() + "=bValue;}\r\n");
                continue;
            }
            if (temp.equals("FLOAT") || temp.equals("DOUBLE") || temp.equals("CURRENCY")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public float get" + iDEFHelper.getCodeName() + "() {return this.f" + iDEFHelper.getCodeName() + ";}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final protected void set" + iDEFHelper.getCodeName() + "(float fValue){this.f" + iDEFHelper.getCodeName() + "=fValue;}\r\n");
                continue;
            }
            if (temp.equals("INT") || temp.equals("NBID") || temp.equals("NSCODELIST") || temp.equals("NMCODELIST")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public int get" + iDEFHelper.getCodeName() + "() {return this.n" + iDEFHelper.getCodeName() + ";}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final protected void set" + iDEFHelper.getCodeName() + "(int nValue){this.n" + iDEFHelper.getCodeName() + "=nValue;}\r\n");
                continue;
            }
            if (temp.equals("DATETIME") || temp.equals("DATE") || temp.equals("TIME")) {
                sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final public Date get" + iDEFHelper.getCodeName() + "() {return this.dt" + iDEFHelper.getCodeName() + ";}\r\n");
                sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
                sb.Append("final protected void set" + iDEFHelper.getCodeName() + "(Date dtValue){this.dt" + iDEFHelper.getCodeName() + "=dtValue;}\r\n");
                continue;
            }
            sb.Append("/**\r\n*\u83b7\u53d6" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
            sb.Append("final public String get" + iDEFHelper.getCodeName() + "() {return this.str" + iDEFHelper.getCodeName() + ";}\r\n");
            sb.Append("/**\r\n*\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n*/\r\n");
            sb.Append("final protected void set" + iDEFHelper.getCodeName() + "(String strValue){this.str" + iDEFHelper.getCodeName() + "=strValue;}\r\n");
        }
        sb.Append("/**\r\n");
        sb.Append(" * \u5c06\u6570\u636e\u5bf9\u8c61\u503c\u63d0\u53d6\u5230\u6a21\u578b\r\n");
        sb.Append(" * \r\n");
        sb.Append(" * @param item\r\n");
        sb.Append("*/\r\n");
        sb.Append("private void InitModel(BaseDataEntity item)\r\n");
        sb.Append("{\r\n");
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            ILinkDEFHelper linkDEFHelper2;
            if (iDEFHelper.IsSystemReserver() || iDEFHelper.IsKeyDEField() || iDEFHelper.IsMajorDEField() || iDEFHelper.IsLinkDEField() && !(linkDEFHelper2 = (ILinkDEFHelper)iDEFHelper).IsPhisicalDEField() && StringHelper.Compare((String)linkDEFHelper2.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) continue;
            sb.Append("//\u8bbe\u7f6e" + iDEFHelper.getLogicName("").toString() + "\u5b57\u6bb5\r\n");
            sb.Append("if(!item.is" + iDEFHelper.getName() + "Null())\r\n");
            sb.Append("this.set" + iDEFHelper.getCodeName() + "(item.get" + iDEFHelper.getName() + "());\r\n\r\n");
        }
        sb.Append("}\r\n");
        System.out.print(sb.toString());
        try {
            File file = new File("d:\\code.java");
            FileOutputStream out = new FileOutputStream(file);
            ((OutputStream)out).write(sb.toString().getBytes());
            out.flush();
            ((OutputStream)out).close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return callResult;
    }

    @Override
    protected Connection getConnection(String strAction, String strActionMode) {
        return null;
    }

    @Override
    protected CallResult OnAfterGet(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterGet(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (StringHelper.Compare((String)strActionMode, (String)GETMODE_FULLINFO, (boolean)true) == 0) {
            IDEHelper iDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(dataEntity.GetParamStringValue("DEID", ""));
            dataEntity.SetParamValue("RTINFO", (Object)iDEHelper.GetRuntimeInfo());
        }
        return callResult;
    }
}

