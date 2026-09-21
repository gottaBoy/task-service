/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DETrigger;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.TriggerCode;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDBModelHelper
implements IDBModelHelper {
    protected IDEHelper iDEHelper = null;
    protected DataEntity dataEntity = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;
    private static final Log log = LogFactory.getLog(BaseDBModelHelper.class);
    protected IDEDataCtrl deFieldDataCtrl = null;
    protected static TreeMap<String, String> sysColumns = new TreeMap();
    protected String strDBSCHEMA = "DB2ADMIN";

    static {
        sysColumns.put("ENABLE", "");
        sysColumns.put("UPDATEMAN", "");
        sysColumns.put("UPDATEDATE", "");
        sysColumns.put("CREATEMAN", "");
        sysColumns.put("CREATEDATE", "");
    }

    @Override
    public CallResult Init(DataEntity dataEntity, ISRFDAGlobalHelper globalHelperEx) {
        this.dataEntity = dataEntity;
        this.globalHelperEx = globalHelperEx;
        if (!StringHelper.IsNullOrEmpty((String)dataEntity.getDBSTORAGE())) {
            IDBStorage iDBStorage = globalHelperEx.getDAModelStorage().FindDBStorage(dataEntity.getDBSTORAGE());
            this.strDBSCHEMA = iDBStorage.GetDBSCHEMA();
        } else {
            this.strDBSCHEMA = globalHelperEx.getWebExConfig().GetValue("SRFDA", "DBSCHEMA", this.strDBSCHEMA);
        }
        return new CallResult();
    }

    @Override
    public CallResult CreateTableAndView() {
        CallResult callResult = new CallResult();
        try {
            IDEHelper relatedDEHelper = null;
            String strDER11DEID = this.dataEntity.getDER11DEID();
            if (!StringHelper.IsNullOrEmpty((String)strDER11DEID) && (relatedDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDER11DEID)) == null) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDER11DEID));
                callResult.setRetCode(3);
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            String strStorageType = this.dataEntity.getSTORAGETYPE();
            if (StringHelper.IsNullOrEmpty((String)strStorageType) || StringHelper.Compare((String)strStorageType, (String)"STATIC", (boolean)true) == 0) {
                StringBuilderEx stringBuilder = new StringBuilderEx();
                this.AppendSql_CreateTable(stringBuilder, true, relatedDEHelper);
                String strCreateUserTable = this.dataEntity.GetParamStringValue("CREATEUSERTABLE", "");
                if (StringHelper.Compare((String)strCreateUserTable, (String)"FALSE", (boolean)true) != 0) {
                    this.AppendSql_CreateTable(stringBuilder, false, relatedDEHelper);
                }
                this.AppendSql_CreateFirstView(stringBuilder, relatedDEHelper);
                log.info((Object)stringBuilder.toString());
                callResult = this.CallCreateDBModelSql(stringBuilder.toString());
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
            }
            DER11 der11 = null;
            IDEFHelper keyDEFHelper = null;
            if (relatedDEHelper != null) {
                keyDEFHelper = relatedDEHelper.GetKeyDEFHelper();
                der11 = new DER11();
                String strDER11ID = StringHelper.Format((String)"DER11_%1$s", (Object)this.dataEntity.getDEID());
                der11.setDERID(strDER11ID);
                der11.setDERNAME(StringHelper.Format((String)"%1$s_%2$s", (Object)this.dataEntity.getDENAME().toUpperCase(), (Object)keyDEFHelper.getName()));
                der11.setDERLOGICNAME(StringHelper.Format((String)"%1$s:%2$s", (Object)relatedDEHelper.getLogicName(""), (Object)this.dataEntity.getDELOGICNAME()));
                der11.setMAJORDEID(relatedDEHelper.getId());
                der11.setMINORDEID(this.dataEntity.getDEID());
                IDEHelper der11DEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0015");
                IDEDataCtrl der11DataCtrl = der11DEHelper.GetDEDataCtrl("SYSTEM", null);
                callResult = der11DataCtrl.Save(true, der11);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u5efa\u7acbDER11\u5173\u7cfb\u5931\u8d25,%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
            }
            String strDEName = this.dataEntity.getDENAME().toUpperCase();
            DEField base_id = new DEField();
            if (keyDEFHelper == null) {
                base_id.setDEFNAME(StringHelper.Format((String)"%1$sID", (Object)strDEName));
                base_id.setDEFLOGICNAME(StringHelper.Format((String)"%1$s\u6807\u8bc6", (Object)this.dataEntity.getDELOGICNAME()));
                base_id.setISFKEY(false);
                base_id.setDATATYPE("GUID");
            } else {
                base_id.setDEFNAME(StringHelper.Format((String)"%1$s", (Object)keyDEFHelper.getName()));
                base_id.setDEFLOGICNAME(StringHelper.Format((String)"%1$s", (Object)keyDEFHelper.getLogicName("")));
                base_id.setISFKEY(true);
                base_id.setDATATYPE("PICKUP");
                base_id.setRELATEDDEFIELD(keyDEFHelper.getId());
                base_id.setDATATYPEPARAM2(relatedDEHelper.GetMajorDEFHelper().getName());
                base_id.setDERID(der11.getDERID());
            }
            base_id.setDEID(this.dataEntity.getDEID());
            base_id.setTABLENAME(this.dataEntity.getTABLENAME());
            base_id.setDEFTYPE(1);
            base_id.setISNULLABLE(false);
            base_id.setLENGTH(100);
            base_id.setISMAJOR(false);
            base_id.setISPKEY(true);
            base_id.setISSEARCHABLE(false);
            base_id.setISENABLECREATE(false);
            base_id.setISENABLEMODIFY(false);
            base_id.setISSYSTEM(true);
            callResult = this.GetDEFieldDataCtrl().Save(true, base_id);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            DEField base_name = new DEField();
            if (keyDEFHelper == null) {
                base_name.setDEFNAME(StringHelper.Format((String)"%1$sNAME", (Object)strDEName));
                base_name.setDEFLOGICNAME(StringHelper.Format((String)"%1$s\u540d\u79f0", (Object)this.dataEntity.getDELOGICNAME()));
                base_name.setTABLENAME(this.dataEntity.getTABLENAME());
                base_name.setDEFTYPE(1);
                base_name.setDATATYPE("TEXT");
                base_name.setLENGTH(200);
                base_name.setISENABLECREATE(true);
                base_name.setISENABLEMODIFY(true);
                base_name.setISNULLABLE(false);
            } else {
                base_name.setDEFNAME(relatedDEHelper.GetMajorDEFHelper().getName());
                base_name.setDEFLOGICNAME(relatedDEHelper.GetMajorDEFHelper().getLogicName(""));
                base_name.setDEFTYPE(3);
                base_name.setDATATYPE("PICKUPTEXT");
                base_name.setISENABLECREATE(false);
                base_name.setISENABLEMODIFY(false);
                base_name.setRELATEDDEFIELD(relatedDEHelper.GetMajorDEFHelper().getId());
                base_name.setDERID(der11.getDERID());
                base_name.setISNULLABLE(false);
            }
            base_name.setDEID(this.dataEntity.getDEID());
            base_name.setISMAJOR(true);
            base_name.setISPKEY(false);
            base_name.setISFKEY(false);
            base_name.setISSEARCHABLE(true);
            base_name.setISSYSTEM(true);
            String strSearchModel = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<SRFDASEARCHMODEL>\n<SRFDASEARCHITEM ACTION=\"LIKE\" />\n<SRFDASEARCHITEM ACTION=\"=\" GROUP=\"\u9ad8\u7ea7\"/>\n</SRFDASEARCHMODEL>";
            base_name.setSEARCHMODEL(strSearchModel);
            callResult = this.GetDEFieldDataCtrl().Save(true, base_name);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            if (this.dataEntity.isLOGICVALID()) {
                DEField validflag = new DEField();
                validflag.setDEFNAME("ENABLE");
                validflag.setDEID(this.dataEntity.getDEID());
                validflag.setDEFLOGICNAME("\u903b\u8f91\u6709\u6548\u6807\u5fd7");
                validflag.setTABLENAME(this.dataEntity.getTABLENAME());
                validflag.setDEFTYPE(1);
                validflag.setISNULLABLE(false);
                validflag.setDATATYPE("YESNO");
                validflag.setLENGTH(8);
                validflag.setISMAJOR(false);
                validflag.setISPKEY(false);
                validflag.setISFKEY(false);
                validflag.setISSEARCHABLE(false);
                validflag.setISENABLECREATE(false);
                validflag.setISENABLEMODIFY(false);
                validflag.setISSYSTEM(true);
                validflag.setEXCELIMPORDER(-1);
                callResult = this.GetDEFieldDataCtrl().Save(true, validflag);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
            }
            if (this.dataEntity.isINDEXDE()) {
                DEField indextype = new DEField();
                indextype.setDEFNAME(StringHelper.Format((String)"%1$sTYPE", (Object)strDEName));
                indextype.setDEID(this.dataEntity.getDEID());
                indextype.setDEFLOGICNAME("\u5206\u7ec4\u7c7b\u578b");
                indextype.setTABLENAME(this.GetTableName(true));
                indextype.setDEFTYPE(1);
                indextype.setISNULLABLE(false);
                indextype.setDATATYPE("SSCODELIST");
                indextype.setLENGTH(100);
                indextype.setISINDEXTYPE(true);
                indextype.setISMAJOR(false);
                indextype.setISPKEY(false);
                indextype.setISFKEY(false);
                indextype.setISSEARCHABLE(true);
                indextype.setISENABLECREATE(false);
                indextype.setISENABLEMODIFY(false);
                indextype.setISSYSTEM(true);
                callResult = this.GetDEFieldDataCtrl().Save(true, indextype);
                if (callResult.getRetCode() != 0) {
                    return callResult;
                }
                if (this.dataEntity.getINDEXMODE() == 1) {
                    indextype = new DEField();
                    indextype.setDEFNAME(StringHelper.Format((String)"%1$sID2", (Object)strDEName));
                    indextype.setDEID(this.dataEntity.getDEID());
                    indextype.setDEFLOGICNAME("\u5b9e\u9645\u952e\u503c");
                    indextype.setTABLENAME(this.GetTableName(true));
                    indextype.setDEFTYPE(1);
                    indextype.setISNULLABLE(false);
                    indextype.setDATATYPE("TEXT");
                    indextype.setLENGTH(100);
                    indextype.setISINDEXTYPE(false);
                    indextype.setISMAJOR(false);
                    indextype.setISPKEY(false);
                    indextype.setISFKEY(false);
                    indextype.setISSEARCHABLE(false);
                    indextype.setISENABLECREATE(true);
                    indextype.setISENABLEMODIFY(false);
                    indextype.setISSYSTEM(true);
                    callResult = this.GetDEFieldDataCtrl().Save(true, indextype);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                }
            }
            DEField createman = new DEField();
            createman.setDEFNAME(StringHelper.Format((String)"CREATEMAN", (Object)strDEName));
            createman.setDEID(this.dataEntity.getDEID());
            createman.setDEFLOGICNAME("\u5efa\u7acb\u4eba");
            createman.setTABLENAME(this.dataEntity.getTABLENAME());
            createman.setDEFTYPE(1);
            createman.setISNULLABLE(false);
            createman.setDATATYPE("TEXT");
            createman.setLENGTH(60);
            createman.setISMAJOR(false);
            createman.setISPKEY(false);
            createman.setISFKEY(false);
            createman.setISSEARCHABLE(true);
            createman.setISENABLECREATE(false);
            createman.setISENABLEMODIFY(false);
            createman.setISSYSTEM(true);
            createman.setEXCELIMPORDER(-1);
            callResult = this.GetDEFieldDataCtrl().Save(true, createman);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            DEField createdate = new DEField();
            createdate.setDEFNAME(StringHelper.Format((String)"CREATEDATE", (Object)strDEName));
            createdate.setDEID(this.dataEntity.getDEID());
            createdate.setDEFLOGICNAME("\u5efa\u7acb\u65f6\u95f4");
            createdate.setTABLENAME(this.dataEntity.getTABLENAME());
            createdate.setDEFTYPE(1);
            createdate.setISNULLABLE(false);
            createdate.setDATATYPE("DATETIME");
            createdate.setLENGTH(8);
            createdate.setISMAJOR(false);
            createdate.setISPKEY(false);
            createdate.setISFKEY(false);
            createdate.setISSEARCHABLE(true);
            createdate.setISENABLECREATE(false);
            createdate.setISENABLEMODIFY(false);
            createdate.setISSYSTEM(true);
            createdate.setEXCELIMPORDER(-1);
            callResult = this.GetDEFieldDataCtrl().Save(true, createdate);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            DEField updateman = new DEField();
            updateman.setDEFNAME(StringHelper.Format((String)"UPDATEMAN", (Object)strDEName));
            updateman.setDEID(this.dataEntity.getDEID());
            updateman.setDEFLOGICNAME("\u66f4\u65b0\u4eba");
            updateman.setTABLENAME(this.dataEntity.getTABLENAME());
            updateman.setDEFTYPE(1);
            updateman.setISNULLABLE(false);
            updateman.setDATATYPE("TEXT");
            updateman.setLENGTH(60);
            updateman.setISMAJOR(false);
            updateman.setISPKEY(false);
            updateman.setISFKEY(false);
            updateman.setISSEARCHABLE(true);
            updateman.setISENABLECREATE(false);
            updateman.setISENABLEMODIFY(false);
            updateman.setISSYSTEM(true);
            updateman.setEXCELIMPORDER(-1);
            callResult = this.GetDEFieldDataCtrl().Save(true, updateman);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            DEField updatedate = new DEField();
            updatedate.setDEFNAME(StringHelper.Format((String)"UPDATEDATE", (Object)strDEName));
            updatedate.setDEID(this.dataEntity.getDEID());
            updatedate.setDEFLOGICNAME("\u66f4\u65b0\u65f6\u95f4");
            updatedate.setTABLENAME(this.dataEntity.getTABLENAME());
            updatedate.setDEFTYPE(1);
            updatedate.setISNULLABLE(false);
            updatedate.setDATATYPE("DATETIME");
            updatedate.setLENGTH(8);
            updatedate.setISMAJOR(false);
            updatedate.setISPKEY(false);
            updatedate.setISFKEY(false);
            updatedate.setISSEARCHABLE(true);
            updatedate.setISENABLECREATE(false);
            updatedate.setISENABLEMODIFY(false);
            updatedate.setISSYSTEM(true);
            updatedate.setEXCELIMPORDER(-1);
            callResult = this.GetDEFieldDataCtrl().Save(true, updatedate);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            callResult = this.CreateCustomField();
            if (callResult.IsError()) {
                return callResult;
            }
            Form formView = new Form();
            formView.setFORMID(StringHelper.Format((String)"%1$s_MAINFORM", (Object)this.dataEntity.getDEID()));
            formView.setFORMNAME(StringHelper.Format((String)"MAINFORM_%1$s", (Object)this.dataEntity.getDENAME()));
            formView.setDEID(this.dataEntity.getDEID());
            formView.setISMAJOR(true);
            formView.setISPRINT(false);
            StringBuilderEx formModel = new StringBuilderEx();
            formModel.Append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
            formModel.Append("<SRFEXDP>\n");
            formModel.Append("\t<SRFEXDPPAGEGROUP CAPTIOn=\"\u57fa\u672c\u4fe1\u606f\" >\n");
            formModel.Append("\t<SRFEXDPGROUP CAPTION=\"%1$s\u4fe1\u606f\" SHOWCAPTION=\"TRUE\" COLUMNS=\"50%%;50%%\">\n", (Object)this.dataEntity.getDELOGICNAME());
            if (keyDEFHelper == null) {
                formModel.Append("\t\t<SRFEXDPFORMITEM DEFIELD=\"%1$s\"/>\n", (Object)base_name.getDEFNAME());
            } else {
                formModel.Append("\t\t<SRFEXDPFORMITEM DEFIELD=\"%1$s\"/>\n", (Object)base_id.getDEFNAME());
            }
            formModel.Append("\t\t</SRFEXDPGROUP>\n");
            formModel.Append("\t</SRFEXDPPAGEGROUP>\n");
            formModel.Append("\t<SRFEXDPPAGEGROUP CAPTIOn=\"\u5176\u5b83\">\n");
            formModel.Append("\t\t<SRFEXDPGROUP CAPTION=\"\u64cd\u4f5c\u4fe1\u606f\" SHOWCAPTION=\"TRUE\" COLUMNS=\"50%%;50%%\">\n");
            formModel.Append("\t\t\t<SRFEXDPFORMITEM DEFIELD=\"CREATEMAN\"/>\n");
            formModel.Append("\t\t\t<SRFEXDPFORMITEM DEFIELD=\"CREATEDATE\"/>\n");
            formModel.Append("\t\t\t<SRFEXDPFORMITEM DEFIELD=\"UPDATEMAN\"/>\n");
            formModel.Append("\t\t\t<SRFEXDPFORMITEM DEFIELD=\"UPDATEDATE\"/>\n");
            formModel.Append("\t\t</SRFEXDPGROUP>\n");
            formModel.Append("\t</SRFEXDPPAGEGROUP>\n");
            formModel.Append("</SRFEXDP>\n");
            formView.setFORMMODEL(formModel.toString());
            IDEDataCtrl iFormDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0007").GetDEDataCtrl("SYSTEM", null);
            callResult = iFormDataCtrl.Save(true, formView);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            DataGrid gridView = new DataGrid();
            gridView.setDATAGRIDID(StringHelper.Format((String)"%1$s_DATAGRID", (Object)this.dataEntity.getDEID()));
            gridView.setDATAGRIDNAME(StringHelper.Format((String)"DATAGRID_%1$s", (Object)this.dataEntity.getDENAME()));
            gridView.setDEID(this.dataEntity.getDEID());
            gridView.setISMAJOR(true);
            StringBuilderEx gridModel = new StringBuilderEx();
            gridModel.Append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
            gridModel.Append("<SRFDADATAGRIDMODEL>\n");
            gridModel.Append("\t<SRFDADGMODELCOLUMNS>\n");
            gridModel.Append("\t\t<SRFDADGMODELCOLUMN DEFIELD=\"%1$s\" WIDTH=\"150\"/>\n", (Object)base_name.getDEFNAME());
            gridModel.Append("\t</SRFDADGMODELCOLUMNS>\n");
            gridModel.Append("</SRFDADATAGRIDMODEL>\n");
            gridView.setDGMODEL(gridModel.toString());
            IDEDataCtrl iGridDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0008").GetDEDataCtrl("SYSTEM", null);
            callResult = iGridDataCtrl.Save(true, gridView);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u5efa\u7acb\u5b9e\u4f53\u8868\u53ca\u89c6\u56fe\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected CallResult CreateCustomField() {
        return new CallResult();
    }

    protected String GetTableName(boolean bMain) {
        String strTableName = "";
        String strDEName = this.dataEntity.getDENAME().toUpperCase();
        strTableName = StringHelper.Compare((String)this.dataEntity.getDEGROUP(), (String)"SRFDA", (boolean)true) == 0 ? StringHelper.Format((String)"T_SRF%1$s%2$s", (Object)strDEName, (Object)(bMain ? "" : "_USER")) : StringHelper.Format((String)"SRFT_%1$s%2$s", (Object)strDEName, (Object)(bMain ? "_BASE" : "_USER"));
        return strTableName;
    }

    protected void AppendSql_CreateTable(StringBuilderEx stringBuilder, boolean bMain, IDEHelper relatedDEHelper) {
    }

    protected void AppendSql_CreateFirstView(StringBuilderEx stringBuilder, IDEHelper relatedDEHelper) {
        String strDEName = this.dataEntity.getDENAME();
        strDEName.toUpperCase();
        String strViewName = "";
        strViewName = StringHelper.Compare((String)this.dataEntity.getDEGROUP(), (String)"SRFDA", (boolean)true) == 0 ? StringHelper.Format((String)"V_SRF%1$s", (Object)strDEName) : StringHelper.Format((String)"SRFV_%1$s", (Object)strDEName);
        IDEFHelper keyDEFHelper = null;
        if (relatedDEHelper != null) {
            keyDEFHelper = relatedDEHelper.GetKeyDEFHelper();
        }
        this.dataEntity.setVIEWNAME(strViewName);
        String strMainTable = this.dataEntity.getTABLENAME();
        String strUserTable = this.dataEntity.getEXTABLENAME();
        stringBuilder.Append("CREATE VIEW %1$s AS \n", (Object)strViewName);
        stringBuilder.Append("SELECT \n");
        if (keyDEFHelper != null) {
            stringBuilder.Append("%2$s.%1$s\n", (Object)keyDEFHelper.getName(), (Object)strMainTable);
        } else {
            stringBuilder.Append("%2$s.%1$sID\n", (Object)strDEName, (Object)strMainTable);
            stringBuilder.Append(",%2$s.%1$sNAME\n", (Object)strDEName, (Object)strMainTable);
        }
        if (this.dataEntity.isLOGICVALID()) {
            stringBuilder.Append(",%2$s.ENABLE\n", (Object)strDEName, (Object)strMainTable);
        }
        if (this.dataEntity.isINDEXDE()) {
            stringBuilder.Append(",%2$s.%1$sTYPE\n", (Object)strDEName, (Object)strMainTable);
        }
        stringBuilder.Append(",%2$s.CREATEMAN\n", (Object)strDEName, (Object)strMainTable);
        stringBuilder.Append(",%2$s.CREATEDATE\n", (Object)strDEName, (Object)strMainTable);
        stringBuilder.Append(",%2$s.UPDATEMAN\n", (Object)strDEName, (Object)strMainTable);
        stringBuilder.Append(",%2$s.UPDATEDATE\n", (Object)strDEName, (Object)strMainTable);
        stringBuilder.Append(" from %1$s \n", (Object)strMainTable);
        if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
            if (keyDEFHelper != null) {
                stringBuilder.Append(" INNER JOIN %2$s on %3$s.%1$s = %2$s.%1$s ;\n", (Object)keyDEFHelper.getName(), (Object)strUserTable, (Object)strMainTable);
            } else {
                stringBuilder.Append(" INNER JOIN %2$s on %3$s.%1$sID = %2$s.%1$sID ;\n", (Object)strDEName, (Object)strUserTable, (Object)strMainTable);
            }
        }
    }

    @Override
    public CallResult CreateView() {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        StringBuilderEx script = new StringBuilderEx();
        String strViewName = this.getDEHelper().GetDEViewName();
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            log.error((Object)"\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            callResult.setErrorInfo("\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            return callResult;
        }
        callResult = this.AppendSql_CreateView(script, strViewName);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String strCreateViewCode = script.toString();
        script.Reset();
        this.AppendSql_DropView(script, strViewName);
        String strDropViewCode = script.toString();
        if (!StringHelper.IsNullOrEmpty((String)strDropViewCode)) {
            try {
                log.info((Object)strDropViewCode);
                this.CallCreateDBModelSql(strDropViewCode.toString());
            }
            catch (Exception ex) {
                log.error((Object)"\u5220\u9664\u89c6\u56fe\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            }
        }
        try {
            log.info((Object)strCreateViewCode);
            callResult = this.CallCreateDBModelSql(strCreateViewCode);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u5efa\u7acb\u89c6\u56fe\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult AppendSql_CreateView(StringBuilderEx script, String strViewName) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            log.error((Object)"\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            callResult.setErrorInfo("\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            return callResult;
        }
        this.AppendSql_CreateViewEx(script, strViewName);
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult AppendSql_CreateViewEx(StringBuilderEx script, String strViewName) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            log.error((Object)"\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            callResult.setErrorInfo("\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            return callResult;
        }
        script.Append("create  view %1$s as \n", (Object)strViewName);
        script.Append("SELECT\n");
        Vector<String> derList = new Vector<String>();
        TreeMap<String, Integer> derAliasMap = new TreeMap<String, Integer>();
        boolean bFirst = true;
        IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
        if (keyDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e3b\u952e\u5c5e\u6027 ", (Object)this.getDEHelper().GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
            if (!iDEFHelper.GetDTColumn().isViewColumn()) continue;
            callResult = this.GetDEFieldExp(iDEFHelper, "", derAliasMap, derList, "t");
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5c5e\u6027[%1$s]\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)iDEFHelper.getName(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            if (bFirst) {
                bFirst = false;
            } else {
                script.Append(",\n");
            }
            script.Append("%1$s AS %2$s", callResult.getUserObject(), (Object)iDEFHelper.GetDTColumn().GetFormalColumnName());
        }
        String strMainTable = this.iDEHelper.getDataEntity().getTABLENAME();
        String strUserTable = this.iDEHelper.getDataEntity().getEXTABLENAME();
        script.Append("\nFROM %1$s t1 \n", (Object)strMainTable);
        if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
            script.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s\n", (Object)strUserTable, (Object)keyDEFHelper.GetDTColumn().GetFormalColumnName());
        }
        TreeMap<String, Integer> joinMap = new TreeMap<String, Integer>();
        for (String strDERs : derList) {
            callResult = this.GetJoin(script, this.iDEHelper, "", strDERs, derAliasMap, joinMap, "t");
            if (callResult.getRetCode() == 0) continue;
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5173\u7cfb\u8fde\u63a5[%1$s]\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strDERs, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult GetJoin(StringBuilderEx script, IDEHelper iDEHelper, String strParentDERs, String strDER, TreeMap<String, Integer> derAliasMap, TreeMap<String, Integer> joinMap, String strPreFix) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (StringHelper.IsNullOrEmpty((String)strDER)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u6307\u5b9a\u8fde\u63a5\u5173\u7cfb"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String[] strDERs = strDER.split("[|]");
        String strCurDERId = strDERs[0];
        String strCurTotalDER = strParentDERs;
        if (!StringHelper.IsNullOrEmpty((String)strCurTotalDER)) {
            strCurTotalDER = String.valueOf(strCurTotalDER) + "|";
        }
        strCurTotalDER = String.valueOf(strCurTotalDER) + strCurDERId;
        IDEHelper iNextDEHelper = null;
        ILinkDEFHelper joinDEFHelper = null;
        boolean bInheritMode = false;
        DERCUSTOM derCustom = iDEHelper.FindDERCUSTOM(false, strCurDERId);
        if (derCustom != null) {
            if (!joinMap.containsKey(strCurTotalDER)) {
                iNextDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(derCustom.getMAJORDEID());
                if (iNextDEHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derCustom.getMAJORDEID()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                String strMTAlias = "";
                String strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                    strMTAlias = String.valueOf(strPreFix) + "1";
                    strUTAlias = String.valueOf(strPreFix) + "2";
                } else {
                    if (!derAliasMap.containsKey(strParentDERs)) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    Integer nAlias = derAliasMap.get(strParentDERs);
                    strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                }
                String strCurMTAlias = "";
                String strCurUTAlias = "";
                if (!derAliasMap.containsKey(strCurTotalDER)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                Integer nAlias = derAliasMap.get(strCurTotalDER);
                strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                String strMainTable = iNextDEHelper.GetMainTable();
                String strUserTable = iNextDEHelper.GetUserTable();
                String strMainTable2 = strMainTable;
                String strUserTable2 = strUserTable;
                if (StringHelper.Compare((String)iNextDEHelper.GetDBStorage(), (String)this.dataEntity.getDBSTORAGE(), (boolean)true) != 0) {
                    strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strMainTable);
                    strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strUserTable);
                }
                String strCustomJoin = derCustom.getJOINCOND().replace("%%SRFMAJOR%%", strCurMTAlias);
                strCustomJoin = strCustomJoin.replace("%%SRFMINOR%%", strMTAlias);
                script.Append("LEFT JOIN %1$s %2$s ON %3$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)strCustomJoin);
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    IDEFHelper pkeyDEFHelper = iNextDEHelper.GetKeyDEFHelper();
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)strUserTable2, (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)pkeyDEFHelper.GetDTColumn().GetFormalColumnName());
                }
                joinMap.put(strCurTotalDER, 1);
            }
            String strNextDERId = "";
            int i = 1;
            while (i < strDERs.length) {
                if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    strNextDERId = String.valueOf(strNextDERId) + "|";
                }
                strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                callResult.setRetCode(0);
                return callResult;
            }
            return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap, strPreFix);
        }
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            ILinkDEFHelper linkDEFHelper;
            if (!iDEFHelper.IsLinkDEField() || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strCurDERId, (boolean)true) != 0) continue;
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) == 0) {
                joinDEFHelper = linkDEFHelper;
                break;
            }
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) != 0) continue;
            bInheritMode = true;
            iNextDEHelper = linkDEFHelper.GetRelatedDEFHelper().getDEHelper();
            break;
        }
        if (bInheritMode) {
            if (!joinMap.containsKey(strCurTotalDER)) {
                String strMTAlias = "";
                String strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                    strMTAlias = String.valueOf(strPreFix) + "1";
                    strUTAlias = String.valueOf(strPreFix) + "2";
                } else {
                    if (!derAliasMap.containsKey(strParentDERs)) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    Integer nAlias = derAliasMap.get(strParentDERs);
                    strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                }
                String strCurMTAlias = "";
                String strCurUTAlias = "";
                if (!derAliasMap.containsKey(strCurTotalDER)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                Integer nAlias = derAliasMap.get(strCurTotalDER);
                strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                boolean bJoinAsMain = true;
                IDEFHelper iKeyDEFHelper = iDEHelper.GetKeyDEFHelper();
                bJoinAsMain = StringHelper.Compare((String)iKeyDEFHelper.GetDTColumn().GetTableName(), (String)iDEHelper.getDataEntity().getTABLENAME(), (boolean)true) == 0;
                String strMainTable = iNextDEHelper.GetMainTable();
                String strUserTable = iNextDEHelper.GetUserTable();
                String strMainTable2 = strMainTable;
                String strUserTable2 = strUserTable;
                if (StringHelper.Compare((String)iNextDEHelper.GetDBStorage(), (String)this.dataEntity.getDBSTORAGE(), (boolean)true) != 0) {
                    strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strMainTable);
                    strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strUserTable);
                }
                script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)iKeyDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)iNextDEHelper.GetKeyDEFHelper().GetDTColumn().GetFormalColumnName());
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    IDEFHelper pkeyDEFHelper = iNextDEHelper.GetKeyDEFHelper();
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)strUserTable2, (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)pkeyDEFHelper.GetDTColumn().GetFormalColumnName());
                }
                joinMap.put(strCurTotalDER, 1);
            }
            String strNextDERId = "";
            int i = 1;
            while (i < strDERs.length) {
                if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    strNextDERId = String.valueOf(strNextDERId) + "|";
                }
                strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                callResult.setRetCode(0);
                return callResult;
            }
            return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap, strPreFix);
        }
        if (joinDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iDEHelper.GetFullName(), (Object)strCurDERId));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEFHelper joinRelatedDEFHelper = joinDEFHelper.GetRelatedDEFHelper();
        if (joinRelatedDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5c5e\u6027[%1$s]\u5173\u8054\u5c5e\u6027", (Object)joinDEFHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        iNextDEHelper = joinRelatedDEFHelper.getDEHelper();
        if (!joinMap.containsKey(strCurTotalDER)) {
            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                strMTAlias = String.valueOf(strPreFix) + "1";
                strUTAlias = String.valueOf(strPreFix) + "2";
            } else {
                if (!derAliasMap.containsKey(strParentDERs)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                Integer nAlias = derAliasMap.get(strParentDERs);
                strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
            }
            String strCurMTAlias = "";
            String strCurUTAlias = "";
            if (!derAliasMap.containsKey(strCurTotalDER)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            Integer nAlias = derAliasMap.get(strCurTotalDER);
            strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
            strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
            boolean bJoinAsMain = true;
            bJoinAsMain = StringHelper.Compare((String)joinDEFHelper.GetDTColumn().GetTableName(), (String)iDEHelper.getDataEntity().getTABLENAME(), (boolean)true) == 0;
            String strMainTable = iNextDEHelper.GetMainTable();
            String strUserTable = iNextDEHelper.GetUserTable();
            String strMainTable2 = strMainTable;
            String strUserTable2 = strUserTable;
            if (StringHelper.Compare((String)iNextDEHelper.GetDBStorage(), (String)this.dataEntity.getDBSTORAGE(), (boolean)true) != 0) {
                strMainTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strMainTable);
                strUserTable2 = StringHelper.Format((String)"%1$s.%2$s", (Object)iNextDEHelper.GetDBSchema(), (Object)strUserTable);
            }
            script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)strMainTable2, (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)joinDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)joinRelatedDEFHelper.GetDTColumn().GetFormalColumnName());
            if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                IDEFHelper pkeyDEFHelper = null;
                pkeyDEFHelper = joinRelatedDEFHelper.GetDTColumn().IsPKey() ? joinRelatedDEFHelper : iNextDEHelper.GetKeyDEFHelper();
                script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)strUserTable2, (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)pkeyDEFHelper.GetDTColumn().GetFormalColumnName());
            }
            joinMap.put(strCurTotalDER, 1);
        }
        String strNextDERId = "";
        int i = 1;
        while (i < strDERs.length) {
            if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                strNextDERId = String.valueOf(strNextDERId) + "|";
            }
            strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
            ++i;
        }
        if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
            callResult.setRetCode(0);
            return callResult;
        }
        return this.GetJoin(script, iNextDEHelper, strCurTotalDER, strNextDERId, derAliasMap, joinMap, strPreFix);
    }

    protected CallResult GetDEFieldExp(IDEFHelper iDEFHelper, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList, String strPreFix) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        IDEHelper iDEHelper = iDEFHelper.getDEHelper();
        if (iDEFHelper.IsFormulaDEField()) {
            String strFormulaFields = iDEFHelper.GetDTColumn().GetFormulaColumns();
            if (!StringHelper.IsNullOrEmpty((String)strFormulaFields)) {
                Object[] params = null;
                String[] strFields = strFormulaFields.split("[;]");
                params = new Object[strFields.length];
                int i = 0;
                while (i < strFields.length) {
                    String strDEFName = strFields[i].toUpperCase();
                    IDEFHelper argvField = iDEHelper.GetDEFHelper(strDEFName);
                    if (argvField == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u903b\u8f91\u5c5e\u6027\u53c2\u6570[%1$s]\u65e0\u6548", (Object)strDEFName));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    callResult = this.GetDEFieldExp(argvField, strParentDER, derAliasMap, derList, strPreFix);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    params[i] = callResult.getUserObject();
                    ++i;
                }
                String strExp = StringHelper.Format((String)iDEFHelper.GetDTColumn().GetFormulaFormat(), (Object[])params);
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                return callResult;
            }
            String strExp = StringHelper.Format((String)iDEFHelper.GetDTColumn().GetFormulaFormat());
            callResult.setRetCode(0);
            callResult.setUserObject((Object)strExp);
            return callResult;
        }
        String strDERID = "";
        ILinkDEFHelper linkDEFHelper = null;
        if (iDEFHelper instanceof ILinkDEFHelper) {
            linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
            strDERID = linkDEFHelper.GetDERId();
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) == 0) {
                strDERID = "";
            } else if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 && iDEFHelper.getDEField().getDEFTYPE() == 1) {
                strDERID = "";
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            String strMainTable = iDEHelper.GetMainTable();
            String strUserTable = iDEHelper.GetUserTable();
            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty((String)strParentDER)) {
                strMTAlias = String.valueOf(strPreFix) + "1";
                strUTAlias = String.valueOf(strPreFix) + "2";
            } else {
                if (!derAliasMap.containsKey(strParentDER)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDER));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                Integer nAlias = derAliasMap.get(strParentDER);
                strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
            }
            String strDEFTableName = iDEFHelper.GetDTColumn().GetTableName();
            if (StringHelper.Compare((String)strMainTable, (String)strDEFTableName, (boolean)true) == 0) {
                String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strMTAlias, (Object)iDEFHelper.GetDTColumn().GetFormalColumnName());
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                return callResult;
            }
            if (StringHelper.Compare((String)strUserTable, (String)strDEFTableName, (boolean)true) == 0) {
                String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strUTAlias, (Object)iDEFHelper.GetDTColumn().GetFormalColumnName());
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                return callResult;
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5c5e\u6027[%1$s]\u8868\u540d[%2$s]", (Object)iDEFHelper.GetFullName(), (Object)strDEFTableName));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strNewDER = strParentDER;
        if (!StringHelper.IsNullOrEmpty((String)strNewDER)) {
            strNewDER = String.valueOf(strNewDER) + "|";
        }
        strNewDER = String.valueOf(strNewDER) + strDERID;
        IDEFHelper relatedDEFHelper = linkDEFHelper.GetRelatedDEFHelper();
        if (relatedDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027", (Object)linkDEFHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (!derAliasMap.containsKey(strNewDER)) {
            Integer nCurIndex = derAliasMap.get("%CURVALUE%");
            if (nCurIndex == null) {
                nCurIndex = 0;
            }
            nCurIndex = nCurIndex + 10;
            derAliasMap.put(strNewDER, nCurIndex);
            derAliasMap.put("%CURVALUE%", nCurIndex);
            String strLastDERID = "";
            if (derList.size() > 0) {
                strLastDERID = derList.get(derList.size() - 1);
            }
            if (!(strNewDER.indexOf(strLastDERID) != 0 || strNewDER.length() != strLastDERID.length() && strNewDER.charAt(strLastDERID.length()) != '|' || StringHelper.IsNullOrEmpty((String)strLastDERID))) {
                derList.set(derList.size() - 1, strNewDER);
            } else {
                derList.add(strNewDER);
            }
        }
        return this.GetDEFieldExp(relatedDEFHelper, strNewDER, derAliasMap, derList, strPreFix);
    }

    protected void AppendSql_DropView(StringBuilderEx stringBuilder, String strViewName) {
        stringBuilder.Append("DROP VIEW %1$s;", (Object)strViewName);
    }

    @Override
    public CallResult AddDER1N(DER1N der1n) {
        CallResult callResult = new CallResult();
        IDEHelper iMajorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMAJORDEID());
        if (iMajorDEHelper == null) {
            String strErrorInfo = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u8f85\u52a9\u5bf9\u8c61", (Object)der1n.getMAJORDEID());
            callResult.setErrorInfo(strErrorInfo);
            callResult.setRetCode(1);
            log.error((Object)strErrorInfo);
            return callResult;
        }
        IDEFHelper keyDEFHelper = iMajorDEHelper.GetKeyDEFHelper();
        IDEFHelper majorDEFHelper = iMajorDEHelper.GetMajorDEFHelper();
        if (keyDEFHelper == null || keyDEFHelper == null) {
            String strErrorInfo = StringHelper.Format((String)"\u4e3b\u6570\u636e\u5b9e\u4f53[%1$s]\u5c5e\u6027\u6709\u8bef", (Object)iMajorDEHelper.GetFullName());
            callResult.setErrorInfo(strErrorInfo);
            callResult.setRetCode(1);
            log.error((Object)strErrorInfo);
            return callResult;
        }
        IDEHelper iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
        if (iMinorDEHelper == null) {
            String strErrorInfo = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u8f85\u52a9\u5bf9\u8c61", (Object)der1n.getMINORDEID());
            callResult.setErrorInfo(strErrorInfo);
            callResult.setRetCode(1);
            log.error((Object)strErrorInfo);
            return callResult;
        }
        String strTableName = "";
        if (der1n.isMTFIELD()) {
            strTableName = iMinorDEHelper.GetMainTable();
        } else {
            strTableName = iMinorDEHelper.GetUserTable();
            if (StringHelper.IsNullOrEmpty((String)strTableName)) {
                strTableName = iMinorDEHelper.GetMainTable();
            }
        }
        DEField minorKeyField = new DEField();
        minorKeyField.setDEFNAME(der1n.getMAJORKEYDEFNAME());
        minorKeyField.setRELATEDDEFIELD(keyDEFHelper.getId());
        minorKeyField.setDATATYPEPARAM2(der1n.getMAJORTEXTDEFNAME());
        minorKeyField.setDERID(der1n.getDERID());
        minorKeyField.setDEID(iMinorDEHelper.getId());
        minorKeyField.setDEFLOGICNAME(der1n.getDERLOGICNAME());
        minorKeyField.setTABLENAME(strTableName);
        minorKeyField.setDEFTYPE(1);
        minorKeyField.setISNULLABLE(der1n.isNULLABLE());
        minorKeyField.setDATATYPE("PICKUP");
        minorKeyField.setQUERYCS("=");
        minorKeyField.setISMAJOR(false);
        minorKeyField.setISPKEY(false);
        minorKeyField.setISFKEY(true);
        minorKeyField.setISSEARCHABLE(true);
        minorKeyField.setISENABLECREATE(true);
        minorKeyField.setISENABLEMODIFY(true);
        minorKeyField.setISSYSTEM(false);
        callResult = this.GetDEFieldDataCtrl().Save(true, minorKeyField);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DEField minorTextField = new DEField();
        minorTextField.setDEFNAME(der1n.getMAJORTEXTDEFNAME());
        if (StringHelper.IsNullOrEmpty((String)der1n.getRELATEDTEXTDEFID())) {
            minorTextField.setRELATEDDEFIELD(majorDEFHelper.getId());
        } else {
            minorTextField.setRELATEDDEFIELD(der1n.getRELATEDTEXTDEFID());
        }
        minorTextField.setDERID(der1n.getDERID());
        minorTextField.setDEID(iMinorDEHelper.getId());
        minorTextField.setDEFLOGICNAME(der1n.getDERLOGICNAME());
        if (der1n.getPHYSICALMODE()) {
            minorTextField.setTABLENAME(strTableName);
            minorTextField.setDEFTYPE(1);
            minorTextField.setISENABLECREATE(true);
            minorTextField.setISENABLEMODIFY(true);
        } else {
            minorTextField.setDEFTYPE(3);
            minorTextField.setISENABLECREATE(false);
            minorTextField.setISENABLEMODIFY(false);
        }
        minorTextField.setISNULLABLE(true);
        minorTextField.setDATATYPE("PICKUPTEXT");
        minorTextField.setISMAJOR(false);
        minorTextField.setISPKEY(false);
        minorTextField.setISFKEY(false);
        minorTextField.setISSEARCHABLE(true);
        minorTextField.setISSYSTEM(false);
        callResult = this.GetDEFieldDataCtrl().Save(true, minorTextField);
        if (callResult.getRetCode() != 0) {
            this.GetDEFieldDataCtrl().Remove(minorKeyField);
            return callResult;
        }
        callResult = this.InternalAddDER1NColumns(minorKeyField, minorTextField);
        if (callResult.IsError()) {
            this.GetDEFieldDataCtrl().Remove(minorKeyField);
            this.GetDEFieldDataCtrl().Remove(minorTextField);
            this.getDEHelper().PrepareDEFields(true);
            this.CreateView();
        }
        return callResult;
    }

    protected CallResult InternalAddDER1NColumns(DEField minorKeyField, DEField minorTextField) {
        CallResult callResult = new CallResult();
        try {
            String strDataType;
            String strRealDataType;
            BaseDataEntity dataType;
            IDEFHelper iDEFHelper;
            StringBuilderEx stringBuilder = new StringBuilderEx();
            if (!this.getDEHelper().PrepareDEFields(true)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5237\u65b0\u5c5e\u6027\u5931\u8d25\uff01", (Object)this.getDEHelper().GetFullName()));
                return callResult;
            }
            if (this.IsTableColumnExist(minorKeyField)) {
                log.info((Object)StringHelper.Format((String)"\u8868[%1$s]\u5217[%2$s]\u5df2\u7ecf\u5b58\u5728\uff0c\u4e0d\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", (Object)minorKeyField.getTABLENAME(), (Object)minorKeyField.getDEFNAME()));
                iDEFHelper = this.getDEHelper().GetDEFHelper(minorKeyField.getDEFID());
                if (iDEFHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5c5e\u6027[%1$s]\u7684\u8f85\u52a9\u5bf9\u8c61", (Object)minorKeyField.getDEFID()));
                    return callResult;
                }
                dataType = new BaseDataEntity();
                if (!this.GetTableColumnRealDataType(iDEFHelper.getDEField(), dataType)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b57\u6bb5[%1$s:%2$s]\u7269\u7406\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.getDEField().getTABLENAME(), (Object)iDEFHelper.getDEField().getDEFNAME()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                strRealDataType = dataType.GetParamStringValue("TYPENAME", "");
                if (StringHelper.Compare((String)strRealDataType, (String)(strDataType = iDEFHelper.GetDTColumn().GetDBDataType()), (boolean)true) != 0) {
                    iDEFHelper.getDEField().SetParamValue("REALDATATYPE", strRealDataType);
                }
                if ((callResult = this.GetDEFieldDataCtrl().Save(false, iDEFHelper.getDEField())).getRetCode() != 0) {
                    return callResult;
                }
            } else {
                log.info((Object)StringHelper.Format((String)"\u8868[%1$s]\u5217[%2$s]\u4e0d\u5b58\u5728\uff0c\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", (Object)minorKeyField.getTABLENAME(), (Object)minorKeyField.getDEFNAME()));
                this.AppendSql_AddPickupColumn(stringBuilder, this.getDEHelper().GetDEFHelper(minorKeyField.getDEFID()));
                log.info((Object)stringBuilder.toString());
                callResult = this.CallCreateDBModelSql(stringBuilder.toString());
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u589e\u52a0\u5b57\u6bb5\u51fa\u73b0\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
            }
            if (minorTextField.getDEFTYPE() == 1) {
                if (this.IsTableColumnExist(minorTextField)) {
                    log.info((Object)StringHelper.Format((String)"\u8868[%1$s]\u5217[%2$s]\u5df2\u7ecf\u5b58\u5728\uff0c\u4e0d\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", (Object)minorTextField.getTABLENAME(), (Object)minorTextField.getDEFNAME()));
                    iDEFHelper = this.getDEHelper().GetDEFHelper(minorTextField.getDEFID());
                    if (iDEFHelper == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5c5e\u6027[%1$s]\u7684\u8f85\u52a9\u5bf9\u8c61", (Object)minorTextField.getDEFID()));
                        return callResult;
                    }
                    dataType = new BaseDataEntity();
                    if (!this.GetTableColumnRealDataType(iDEFHelper.getDEField(), dataType)) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b57\u6bb5[%1$s:%2$s]\u7269\u7406\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.getDEField().getTABLENAME(), (Object)iDEFHelper.getDEField().getDEFNAME()));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    strRealDataType = dataType.GetParamStringValue("TYPENAME", "");
                    if (StringHelper.Compare((String)strRealDataType, (String)(strDataType = iDEFHelper.GetDTColumn().GetDBDataType()), (boolean)true) != 0) {
                        iDEFHelper.getDEField().SetParamValue("REALDATATYPE", strRealDataType);
                    }
                    if ((callResult = this.GetDEFieldDataCtrl().Save(false, iDEFHelper.getDEField())).getRetCode() != 0) {
                        return callResult;
                    }
                } else {
                    stringBuilder.Reset();
                    log.info((Object)StringHelper.Format((String)"\u8868[%1$s]\u5217[%2$s]\u4e0d\u5b58\u5728\uff0c\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", (Object)minorTextField.getTABLENAME(), (Object)minorTextField.getDEFNAME()));
                    this.AppendSql_AddPickupColumn(stringBuilder, this.getDEHelper().GetDEFHelper(minorTextField.getDEFID()));
                    log.info((Object)stringBuilder.toString());
                    callResult = this.CallCreateDBModelSql(stringBuilder.toString());
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u589e\u52a0\u5b57\u6bb5\u51fa\u73b0\u9519\u8bef,%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                }
            }
            this.getDEHelper().PrepareDEFields(true);
            return this.CreateView();
        }
        catch (Exception ex) {
            log.error((Object)"\u589e\u52a0\u5b57\u6bb5\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void AppendSql_AddPickupColumn(StringBuilderEx stringBuilder, IDEFHelper iDEFHelper) {
    }

    protected IDEDataCtrl GetDEDataCtrl() {
        return null;
    }

    protected IDEDataCtrl GetDEFieldDataCtrl() {
        if (this.deFieldDataCtrl != null) {
            return this.deFieldDataCtrl;
        }
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0002");
        if (iDEHelper == null) {
            return this.deFieldDataCtrl;
        }
        this.deFieldDataCtrl = iDEHelper.GetDEDataCtrl("SYSTEM", null);
        return this.deFieldDataCtrl;
    }

    @Override
    public CallResult AddColumn(DEField deField) {
        CallResult callResult = new CallResult();
        try {
            if (BaseDBModelHelper.IsDEFieldNeedCreateColumn(this.getDEHelper(), deField)) {
                if (!this.getDEHelper().PrepareDEFields(true)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5237\u65b0\u5c5e\u6027\u5931\u8d25\uff01", (Object)this.getDEHelper().GetFullName()));
                    return callResult;
                }
                IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(deField.getDEFID());
                if (iDEFHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5c5e\u6027[%1$s]\u7684\u8f85\u52a9\u5bf9\u8c61", (Object)deField.getDEFID()));
                    return callResult;
                }
                if (iDEFHelper.IsPhisicalDEField() || !iDEFHelper.IsLinkDEField() && iDEFHelper.IsFormulaPhisical()) {
                    String strTableName = "";
                    if (iDEFHelper.getDEField().isMTFIELD()) {
                        strTableName = this.iDEHelper.GetMainTable();
                    } else {
                        strTableName = this.iDEHelper.GetUserTable();
                        if (StringHelper.IsNullOrEmpty((String)strTableName)) {
                            strTableName = this.iDEHelper.GetMainTable();
                        }
                    }
                    if (StringHelper.IsNullOrEmpty((String)strTableName)) {
                        return callResult;
                    }
                    iDEFHelper.getDEField().setTABLENAME(strTableName);
                    if (this.IsTableColumnExist(iDEFHelper.getDEField())) {
                        String strDataType;
                        log.info((Object)StringHelper.Format((String)"\u8868[%1$s]\u5217[%2$s]\u5df2\u7ecf\u5b58\u5728\uff0c\u4e0d\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", (Object)iDEFHelper.getDEField().getTABLENAME(), (Object)iDEFHelper.getDEField().getDEFNAME()));
                        BaseDataEntity dataType = new BaseDataEntity();
                        if (!this.GetTableColumnRealDataType(iDEFHelper.getDEField(), dataType)) {
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b57\u6bb5[%1$s:%2$s]\u7269\u7406\u6570\u636e\u7c7b\u578b", (Object)iDEFHelper.getDEField().getTABLENAME(), (Object)iDEFHelper.getDEField().getDEFNAME()));
                            log.error((Object)callResult.getErrorInfo());
                            return callResult;
                        }
                        String strRealDataType = dataType.GetParamStringValue("TYPENAME", "");
                        if (StringHelper.Compare((String)strRealDataType, (String)(strDataType = iDEFHelper.GetDTColumn().GetDBDataType()), (boolean)true) != 0) {
                            iDEFHelper.getDEField().SetParamValue("REALDATATYPE", strRealDataType);
                        }
                        if ((callResult = this.GetDEFieldDataCtrl().Save(false, "UPDATETABLENAME", iDEFHelper.getDEField())).getRetCode() != 0) {
                            return callResult;
                        }
                    } else {
                        log.info((Object)StringHelper.Format((String)"\u8868[%1$s]\u5217[%2$s]\u4e0d\u5b58\u5728\uff0c\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", (Object)iDEFHelper.getDEField().getTABLENAME(), (Object)iDEFHelper.getDEField().getDEFNAME()));
                        StringBuilderEx stringBuilder = new StringBuilderEx();
                        this.AppendSql_AddColumn(stringBuilder, iDEFHelper);
                        log.info((Object)stringBuilder.toString());
                        callResult = this.CallCreateDBModelSql(stringBuilder.toString());
                        if (callResult.getRetCode() != 0) {
                            return callResult;
                        }
                        callResult = this.GetDEFieldDataCtrl().Save(false, "UPDATETABLENAME", iDEFHelper.getDEField());
                        if (callResult.getRetCode() != 0) {
                            return callResult;
                        }
                    }
                    iDEFHelper.getDEField().CopyTo(deField, true);
                    if (!this.getDEHelper().PrepareDEFields(true)) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5237\u65b0\u5c5e\u6027\u5931\u8d25\uff01", (Object)this.getDEHelper().GetFullName()));
                        return callResult;
                    }
                    return this.CreateView();
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u589e\u52a0\u5b57\u6bb5\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected static boolean IsDEFieldNeedCreateColumn(IDEHelper iDEHelper, DEField deField) {
        String strStorageType = iDEHelper.getDataEntity().getSTORAGETYPE();
        if (StringHelper.Compare((String)strStorageType, (String)"NONE", (boolean)true) == 0 || StringHelper.Compare((String)strStorageType, (String)"DYNAMIC", (boolean)true) == 0) {
            return false;
        }
        if (iDEHelper.IsExistingModel()) {
            return true;
        }
        if (deField.isPKEY() || deField.isFKEY()) {
            return false;
        }
        if (deField.isMAJOR()) {
            return true;
        }
        if (deField.isINDEXTYPE()) {
            return true;
        }
        if (StringHelper.Compare((String)deField.getDATATYPE(), (String)"PICKUPTEXT", (boolean)true) == 0) {
            return false;
        }
        String strDEFName = deField.getDEFNAME().toUpperCase();
        return !sysColumns.containsKey(strDEFName);
    }

    protected void AppendSql_AddColumn(StringBuilderEx stringBuilder, IDEFHelper iDEFHelper) {
    }

    public IDEHelper getDEHelper() {
        if (this.iDEHelper != null) {
            return this.iDEHelper;
        }
        this.iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(this.dataEntity.getDEID());
        return this.iDEHelper;
    }

    protected boolean IsTableColumnExist(DEField field) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsTableColumnExist(field.getTABLENAME(), field.getDEFNAME());
        BaseDataEntity rowCount = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.globalHelperEx, this.dataEntity.getDBSTORAGE(), strSQL, rowCount);
        if (callResult.getRetCode() != 0) {
            return false;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        return nRowCnt == 1;
    }

    protected boolean GetTableColumnRealDataType(DEField field, BaseDataEntity dataType) {
        return false;
    }

    protected IDEDataCtrlHelper GetDEDataCtrlHelper() {
        return this.globalHelperEx.getDEDataCtrlHelper(this.dataEntity.getDBSTORAGE());
    }

    protected CallResult CallCreateDBModelSql(String strSql) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.globalHelperEx.getDBCaller(this.dataEntity.getDBSTORAGE()).CallRaw3(strSql, null);
            callResult.From((DBResult)selectResult);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)strSql));
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)strSql), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult CallCreateDBModelSql2(String strSql) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.globalHelperEx.getDBCaller(this.dataEntity.getDBSTORAGE()).CallRaw3(strSql, null);
            callResult.From((DBResult)selectResult);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)strSql));
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)strSql), (Throwable)ex);
            return callResult;
        }
    }

    @Override
    public CallResult AddTrigger(DETrigger trigger, TriggerCode triggerCode) {
        CallResult callResult = this.DropTrigger(trigger);
        if (callResult.IsError()) {
            return callResult;
        }
        StringBuilderEx sb = new StringBuilderEx();
        this.AppendSql_AddTrigger(sb, trigger, triggerCode);
        return this.CallCreateDBModelSql2(sb.toString());
    }

    protected void AppendSql_AddTrigger(StringBuilderEx stringBuilder, DETrigger trigger, TriggerCode triggerCode) {
    }

    @Override
    public CallResult DropTrigger(DETrigger trigger) {
        String strTriggerName = this.GetTriggerName(trigger);
        if (this.IsTriggerExist(strTriggerName)) {
            String strDropCode = this.GetDEDataCtrlHelper().GetSQL_DropTrigger(strTriggerName);
            return this.CallCreateDBModelSql(strDropCode);
        }
        return new CallResult();
    }

    protected boolean IsTriggerExist(String strTriggerName) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsTriggerExist(strTriggerName);
        BaseDataEntity rowCount = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.globalHelperEx, this.dataEntity.getDBSTORAGE(), strSQL, rowCount);
        if (callResult.getRetCode() != 0) {
            return false;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        return nRowCnt == 1;
    }

    @Override
    public String GetDBType() {
        return "";
    }

    protected String GetTriggerName(DETrigger trigger) {
        return StringHelper.Format((String)"srftr_%1$s_%2$s", (Object)this.dataEntity.getDENAME(), (Object)trigger.getDETRIGGERNAME()).toUpperCase();
    }

    @Override
    public CallResult AddIndex(DBIndex dbIndex) {
        CallResult callResult = new CallResult();
        String strField = dbIndex.getINDEXFIELDS();
        strField = strField.replace("\r", "\n");
        String[] fields = strField.split("[\n]");
        Vector<DBIndexField> indexFields = new Vector<DBIndexField>();
        Hashtable<String, String> indexFieldMap = new Hashtable<String, String>();
        String strTableName = this.getDEHelper().GetMainTable();
        int i = 0;
        while (i < fields.length) {
            String strIndexField = fields[i].trim();
            if (!StringHelper.IsNullOrEmpty((String)strIndexField)) {
                IDEFHelper iDEFHelper;
                String strSortDir = "ASC";
                if (strIndexField.indexOf(32) != -1) {
                    String[] temp = strIndexField.split("[ ]");
                    if (temp.length != 2) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7d22\u5f15\u5c5e\u6027[%1$s]", (Object)strIndexField));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    strIndexField = temp[0];
                    strSortDir = temp[1];
                }
                if ((iDEFHelper = this.getDEHelper().GetDEFHelper(strIndexField)) == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7d22\u5f15\u5c5e\u6027[%1$s]\uff0c\u5b9e\u4f53\u4e2d\u4e0d\u5b58\u5728\u6b64\u5c5e\u6027", (Object)strIndexField));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (!iDEFHelper.IsPhisicalDEField()) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u7d22\u5f15\u5c5e\u6027[%1$s]\u975e\u7269\u7406\u5c5e\u6027\uff0c\u65e0\u6cd5\u8fdb\u884c\u7d22\u5f15", (Object)strIndexField));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (StringHelper.Compare((String)strTableName, (String)iDEFHelper.GetDTColumn().GetTableName(), (boolean)true) != 0) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u7d22\u5f15\u5c5e\u6027[%1$s]\u4e0d\u5728\u4e3b\u8868\u4e2d\uff0c\u65e0\u6cd5\u8fdb\u884c\u7d22\u5f15", (Object)strIndexField));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                if (!indexFieldMap.containsKey(iDEFHelper.getName())) {
                    indexFieldMap.put(iDEFHelper.getName(), "");
                    DBIndexField dbIndexField = new DBIndexField();
                    dbIndexField.setField(iDEFHelper.getName());
                    dbIndexField.setSortAsc(StringHelper.Compare((String)strSortDir, (String)"ASC", (boolean)true) == 0);
                    indexFields.add(dbIndexField);
                }
            }
            ++i;
        }
        if (indexFields.size() == 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u6307\u5b9a\u4efb\u4f55\u7d22\u5f15\u5c5e\u6027\uff0c\u65e0\u6cd5\u8fdb\u884c\u7d22\u5f15"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = this.DropIndex(dbIndex);
        if (callResult.IsError()) {
            return callResult;
        }
        StringBuilderEx sb = new StringBuilderEx();
        this.AppendSql_AddIndex(sb, dbIndex, indexFields);
        String strCreateCode = sb.toString();
        log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u5efa\u7acb\u7d22\u5f15\u4ee3\u7801\r\n%1$s", (Object)strCreateCode));
        callResult = this.CallCreateDBModelSql2(strCreateCode);
        if (callResult.IsError()) {
            return callResult;
        }
        sb.Reset();
        this.AppendSql_AfterAddIndex(sb, dbIndex);
        String strAfterCode = sb.toString();
        if (!StringHelper.IsNullOrEmpty((String)strAfterCode)) {
            log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u5efa\u7acb\u7d22\u5f15\u540e\u7eed\u4ee3\u7801\r\n%1$s", (Object)strAfterCode));
            callResult = this.CallCreateDBModelSql2(strAfterCode);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        return callResult;
    }

    protected void AppendSql_AddIndex(StringBuilderEx stringBuilder, DBIndex dbIndex, Vector<DBIndexField> indexFields) {
    }

    protected void AppendSql_AfterAddIndex(StringBuilderEx stringBuilder, DBIndex dbIndex) {
    }

    @Override
    public CallResult DropIndex(DBIndex dbIndex) {
        String strIndexName = dbIndex.getDBINDEXNAME();
        if (this.IsIndexExist(dbIndex)) {
            String strDropCode = this.GetDEDataCtrlHelper().GetSQL_DropIndex(dbIndex);
            log.debug((Object)StringHelper.Format((String)"\u6267\u884c\u79fb\u9664\u7d22\u5f15\u4ee3\u7801\r\n%1$s", (Object)strDropCode));
            return this.CallCreateDBModelSql(strDropCode);
        }
        return new CallResult();
    }

    protected boolean IsIndexExist(DBIndex dbIndex) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsIndexExist(dbIndex);
        BaseDataEntity rowCount = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.globalHelperEx, this.dataEntity.getDBSTORAGE(), strSQL, rowCount);
        if (callResult.getRetCode() != 0) {
            return false;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        return nRowCnt == 1;
    }

    protected class DBIndexField {
        protected String strField = "";
        protected boolean bSortAsc = true;

        protected DBIndexField() {
        }

        public String getField() {
            return this.strField;
        }

        public void setField(String strField) {
            this.strField = strField;
        }

        public boolean isSortAsc() {
            return this.bSortAsc;
        }

        public void setSortAsc(boolean bSortAsc) {
            this.bSortAsc = bSortAsc;
        }
    }
}

