/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAActionContext
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEField
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.Data.MainMenu
 *  SA.SRFDA.Ctrl.Data.MobileApp
 *  SA.SRFDA.Ctrl.Data.MobileAppDE
 *  SA.SRFDA.Ctrl.Data.MobileAppData
 *  SA.SRFDA.Ctrl.Data.MobileAppPage
 *  SA.SRFDA.Ctrl.Data.MobilePage
 *  SA.SRFDA.Ctrl.Data.MobilePageConfig
 *  SA.SRFDA.Ctrl.IDAActionContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Ctrl.DAActionContext;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.MainMenu;
import SA.SRFDA.Ctrl.Data.MobileApp;
import SA.SRFDA.Ctrl.Data.MobileAppDE;
import SA.SRFDA.Ctrl.Data.MobileAppData;
import SA.SRFDA.Ctrl.Data.MobileAppPage;
import SA.SRFDA.Ctrl.Data.MobilePage;
import SA.SRFDA.Ctrl.Data.MobilePageConfig;
import SA.SRFDA.Ctrl.IDAActionContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.Ctrl.DEDataCtrl.MobilePageDataCtrl;
import SA.SRFDA.Mobile.Ctrl.MobileAppDBHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SqliteDBHelper
extends MobileAppDBHelper {
    private static final Log log = LogFactory.getLog(SqliteDBHelper.class);

    public void InitMobileAppDB(MobileApp mobileApp) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            try {
                File file2;
                String strOfflineDBPath = mobileApp.getOLDBPATH();
                if (StringHelper.IsNullOrEmpty((String)strOfflineDBPath)) {
                    throw new Exception(StringHelper.Format((String)"\u79bb\u7ebf\u6570\u636e\u5e93\u5730\u5740\u65e0\u6548"));
                }
                File file = new File(strOfflineDBPath);
                if (file.exists()) {
                    file.delete();
                }
                if ((file2 = new File(String.valueOf(strOfflineDBPath) + ".zip")).exists()) {
                    file2.delete();
                }
                connection = DriverManager.getConnection(StringHelper.Format((String)"jdbc:sqlite:%1$s", (Object)strOfflineDBPath));
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(300);
                ArrayList<String> sqlList = new ArrayList<String>();
                this.GenCreateTableSql("DE0001", sqlList);
                this.GenCreateTableSql("DE0002", sqlList);
                this.GenCreateTableSql("DE0003", sqlList);
                this.GenCreateTableSql("DE0016", sqlList);
                this.GenCreateTableSql("DE0009", sqlList);
                this.GenCreateTableSql("DE0046", sqlList);
                this.GenCreateTableSql("DE0382", sqlList);
                this.GenCreateTableSql("DE0383", sqlList);
                IDEDataCtrl mobAppDEDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0381", "SYSTEM", null);
                IDEDataCtrl mobAppPageDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0385", "SYSTEM", null);
                IDEDataCtrl mobAppDataDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0389", "SYSTEM", null);
                DAActionContext iActionContext = new DAActionContext(mobAppDEDataCtrl);
                this.GenMobileAppMenuSql((IDAActionContext)iActionContext, mobileApp, sqlList);
                BaseDataEntity cond = new BaseDataEntity();
                cond.SetParamValue("MOBILEAPPID", (Object)mobileApp.getMOBILEAPPID());
                Vector<MobileAppDE> mobleAppDEList = new Vector();
                CallResult callResult = mobAppDEDataCtrl.Select(cond, mobleAppDEList, MobileAppDE.class.getName(), "");
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u79fb\u52a8\u5e94\u7528\u79bb\u7ebf\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                Vector<String> sysMobleAppDEList = new Vector<String>();
                sysMobleAppDEList.add("DE0010");
                sysMobleAppDEList.add("DE0110");
                sysMobleAppDEList.add("DE0111");
                sysMobleAppDEList.add("DE0386");
                sysMobleAppDEList.add("DE0389");
                HashMap<String, String> codeListMap = new HashMap<String, String>();
                HashMap<String, MobileAppDE> mobileAppDEMap = new HashMap<String, MobileAppDE>();
                for (MobileAppDE mobileAppDE : mobleAppDEList) {
                    mobileAppDEMap.put(mobileAppDE.getDEID(), mobileAppDE);
                }
                for (String strSysMobleAppDEId : sysMobleAppDEList) {
                    if (mobileAppDEMap.containsKey(strSysMobleAppDEId)) continue;
                    MobileAppDE mobileAppDE = new MobileAppDE();
                    mobileAppDE.setDEID(strSysMobleAppDEId);
                    mobileAppDEMap.put(mobileAppDE.getDEID(), mobileAppDE);
                }
                for (MobileAppDE mobileAppDE : mobileAppDEMap.values()) {
                    this.GenMobileAppDESql((IDAActionContext)iActionContext, mobileAppDE, sqlList, codeListMap);
                }
                this.GenMobileAppCodeListSql((IDAActionContext)iActionContext, codeListMap, sqlList);
                cond.Reset();
                cond.SetParamValue("MOBILEAPPID", (Object)mobileApp.getMOBILEAPPID());
                Vector<MobileAppPage> mobleAppPageList = new Vector();
                callResult = mobAppPageDataCtrl.Select(cond, mobleAppPageList, MobileAppPage.class.getName(), "");
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u79fb\u52a8\u5e94\u7528\u79bb\u7ebf\u754c\u9762\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (MobileAppPage mobileAppPage : mobleAppPageList) {
                    this.GenMobileAppPageSql((IDAActionContext)iActionContext, mobileAppPage, sqlList);
                }
                cond.Reset();
                cond.SetParamValue("MOBILEAPPID", (Object)mobileApp.getMOBILEAPPID());
                Vector<MobileAppData> mobileAppDataList = new Vector();
                callResult = mobAppDataDataCtrl.Select(cond, mobileAppDataList, MobileAppData.class.getName(), "");
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u79fb\u52a8\u5e94\u7528\u79bb\u7ebf\u6570\u636e\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (MobileAppData mobileAppData : mobileAppDataList) {
                    this.GenMobileAppDataSql((IDAActionContext)iActionContext, mobileAppData, sqlList);
                }
                for (String strSQL : sqlList) {
                    log.debug((Object)StringHelper.Format((String)"\u6267\u884cSQL : \r\n%1$s", (Object)strSQL));
                    statement.executeUpdate(strSQL);
                }
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
                try {
                    if (connection != null) {
                        connection.close();
                    }
                }
                catch (SQLException e2) {
                    System.err.println(e2);
                }
            }
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void GenMobileAppDESql(IDAActionContext iDAActionContext, MobileAppDE mobleAppDE, ArrayList<String> sqlList, HashMap<String, String> codeListMap) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper2(mobleAppDE.getDEID());
        IDEDataCtrl dataEntityDataCtrl = iDAActionContext.getDEDataCtrl("DE0001");
        DataEntity dataEntity = new DataEntity();
        dataEntity.setDEID(mobleAppDE.getDEID());
        CallResult callResult = dataEntityDataCtrl.Get((BaseDataEntity)dataEntity);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.GenInsertTableSql(iDAActionContext, dataEntityDataCtrl.GetDEHelper(), (BaseDataEntity)dataEntity, sqlList);
        IDEDataCtrl deFieldDataCtrl = iDAActionContext.getDEDataCtrl("DE0002");
        cond.Reset();
        cond.SetParamValue("DEID", (Object)mobleAppDE.getDEID());
        Vector<DEField> deFieldList = new Vector();
        callResult = deFieldDataCtrl.Select(cond, deFieldList, DEField.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DEField deField : deFieldList) {
            IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(deField);
            if (iDEFHelper == null) continue;
            deField.setREALDATATYPE(iDEFHelper.GetStdDataType());
            this.GenInsertTableSql(iDAActionContext, deFieldDataCtrl.GetDEHelper(), (BaseDataEntity)deField, sqlList);
            if (StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) continue;
            codeListMap.put(iDEFHelper.GetCodeList(), "");
        }
        IDEDataCtrl der1nDataCtrl = iDAActionContext.getDEDataCtrl("DE0003");
        cond.Reset();
        cond.SetParamValue("MINORDEID", (Object)mobleAppDE.getDEID());
        Vector<DER1N> der1nList = new Vector();
        callResult = der1nDataCtrl.Select(cond, der1nList, DER1N.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f531:N\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DER1N der1n : der1nList) {
            this.GenInsertTableSql(iDAActionContext, der1nDataCtrl.GetDEHelper(), (BaseDataEntity)der1n, sqlList);
        }
        IDEDataCtrl derIndexDataCtrl = iDAActionContext.getDEDataCtrl("DE0016");
        cond.Reset();
        cond.SetParamValue("DEID", (Object)mobleAppDE.getDEID());
        Vector<DERINDEX> derIndexList = new Vector();
        callResult = derIndexDataCtrl.Select(cond, derIndexList, DERINDEX.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53INDEX\u5173\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DERINDEX derIndex : derIndexList) {
            this.GenInsertTableSql(iDAActionContext, derIndexDataCtrl.GetDEHelper(), (BaseDataEntity)derIndex, sqlList);
        }
        this.GenCreateTableSql(iDEHelper, sqlList);
    }

    public void GenMobileAppPageSql(IDAActionContext iDAActionContext, MobileAppPage mobleAppPage, ArrayList<String> sqlList) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        IDEDataCtrl mobilePageDataCtrl = iDAActionContext.getDEDataCtrl("DE0382");
        MobilePage mobilePage = new MobilePage();
        mobilePage.setMOBILEPAGEID(mobleAppPage.getMOBILEPAGEID());
        CallResult callResult = mobilePageDataCtrl.Get((BaseDataEntity)mobilePage);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u79bb\u7ebf\u754c\u9762\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.GenInsertTableSql(iDAActionContext, mobilePageDataCtrl.GetDEHelper(), (BaseDataEntity)mobilePage, sqlList);
        IDEDataCtrl mobileCtrlConfigDataCtrl = iDAActionContext.getDEDataCtrl("DE0383");
        cond.Reset();
        cond.SetParamValue("MOBILEPAGEID", (Object)mobilePage.getMOBILEPAGEID());
        Vector<MobilePageConfig> mobilePageConfigList = new Vector();
        callResult = mobileCtrlConfigDataCtrl.Select(cond, mobilePageConfigList, MobilePageConfig.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u79bb\u7ebf\u754c\u9762\u90e8\u4ef6\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (MobilePageConfig mobilePageConfig : mobilePageConfigList) {
            this.GenInsertTableSql(iDAActionContext, mobileCtrlConfigDataCtrl.GetDEHelper(), (BaseDataEntity)mobilePageConfig, sqlList);
        }
    }

    public void GenMobileAppDataSql(IDAActionContext iDAActionContext, MobileAppData mobileAppData, ArrayList<String> sqlList) throws Exception {
        IDEDataCtrl mobileDataDataCtrl = iDAActionContext.getDEDataCtrl("DE0389");
        this.GenInsertTableSql(iDAActionContext, mobileDataDataCtrl.GetDEHelper(), (BaseDataEntity)mobileAppData, sqlList);
    }

    public void GenMobileAppMenuSql(IDAActionContext iDAActionContext, MobileApp mobileApp, ArrayList<String> sqlList) throws Exception {
        String strMainMenuId = mobileApp.getOFFLINEMENUID();
        if (StringHelper.IsNullOrEmpty((String)strMainMenuId) && StringHelper.IsNullOrEmpty((String)(strMainMenuId = mobileApp.getMAINMENUID()))) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u83dc\u5355"));
        }
        IDEDataCtrl mainMenuDataCtrl = iDAActionContext.getDEDataCtrl("DE0014");
        MainMenu mainMenu = new MainMenu();
        mainMenu.setMAINMENU_ID(strMainMenuId);
        CallResult callResult = mainMenuDataCtrl.Get((BaseDataEntity)mainMenu);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strConfigPath = this.iDAGlobalHelper.getDAConfigHelper("", "SL").GetRIAMainMenuExConfigPath(null, mainMenu.getUSERMODE());
        IDEDataCtrl mobilePageConfigDataCtrl = iDAActionContext.getDEDataCtrl("DE0383");
        MobilePageConfig mobilePageConfig = new MobilePageConfig();
        mobilePageConfig.setMOBPAGECFGID(StringHelper.Format((String)"%1$s_APPMAINMENU", (Object)mobileApp.getMOBILEAPPID()));
        mobilePageConfig.setCONFIGID(mainMenu.getUSERMODE());
        mobilePageConfig.setMOBPAGECFGNAME("APPMAINMENU");
        mobilePageConfig.setCONFIGTYPE("MAINMENU");
        if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
            StringBuilderEx sb = new StringBuilderEx();
            MobilePageDataCtrl.ReadConfigFile(strConfigPath, sb);
            mobilePageConfig.setCONFIGMODEL(sb.toString());
        }
        if ((callResult = mobilePageConfigDataCtrl.AutoSave((BaseDataEntity)mobilePageConfig)).IsError()) {
            throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u79bb\u7ebf\u83dc\u5355\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.GenInsertTableSql(iDAActionContext, mobilePageConfigDataCtrl.GetDEHelper(), (BaseDataEntity)mobilePageConfig, sqlList);
    }

    public void GenMobileAppCodeListSql(IDAActionContext iDAActionContext, HashMap<String, String> codeListMap, ArrayList<String> sqlList) throws Exception {
        IDEDataCtrl mobilePageConfigDataCtrl = iDAActionContext.getDEDataCtrl("DE0383");
        for (String strCodeListId : codeListMap.keySet()) {
            CodeListConfig codeListConfig = this.getDAGlobalHelper().getCodeListMgr().GetCodeListConfig(strCodeListId);
            if (codeListConfig == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
            }
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter simpleXMLWriter = new SimpleXMLWriter(sb);
            simpleXMLWriter.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            codeListConfig.Save(simpleXMLWriter);
            MobilePageConfig mobilePageConfig = new MobilePageConfig();
            mobilePageConfig.setMOBPAGECFGID(StringHelper.Format((String)"%1$s", (Object)strCodeListId));
            mobilePageConfig.setCONFIGID(strCodeListId);
            mobilePageConfig.setMOBPAGECFGNAME("CODELIST");
            mobilePageConfig.setCONFIGTYPE("CODELIST");
            mobilePageConfig.setCONFIGMODEL(sb.toString());
            CallResult callResult = mobilePageConfigDataCtrl.AutoSave((BaseDataEntity)mobilePageConfig);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u79bb\u7ebf\u4ee3\u7801\u8868\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.GenInsertTableSql(iDAActionContext, mobilePageConfigDataCtrl.GetDEHelper(), (BaseDataEntity)mobilePageConfig, sqlList);
        }
    }

    public void GenCreateTableSql(String strDEId, ArrayList<String> sqlList) throws Exception {
        IDEHelper iDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper2(strDEId);
        this.GenCreateTableSql(iDEHelper, sqlList);
    }

    public void GenCreateTableSql(IDEHelper iDEHelper, ArrayList<String> sqlList) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("CREATE TABLE %1$s (\r\n", (Object)iDEHelper.GetMainTable());
        sb.Append("%1$s %2$s  primary key \r\n", (Object)iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), (Object)this.GetDBDataType(iDEHelper.GetKeyDEFHelper(), true, false, false, ""));
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsKeyDEField()) continue;
            sb.Append(",%1$s %2$s \r\n", (Object)iDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetDBDataType(iDEFHelper, false, false, false, ""));
        }
        sb.Append(");\r\n");
        sqlList.add(sb.toString());
    }

    public void GenInsertTableSql(IDAActionContext iDAActionContext, String strDEId, String strDataKey, ArrayList<String> sqlList) throws Exception {
        IDEHelper iDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper2(strDEId);
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), iDEHelper.GetKeyDEFHelper().GetDEFValue(strDataKey));
        IDEDataCtrl relatedDataCtrl = iDAActionContext.getDEDataCtrl(strDEId);
        CallResult callResult = relatedDataCtrl.Get(dataEntity);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)callResult.getErrorInfo()));
        }
        this.GenInsertTableSql(iDAActionContext, iDEHelper, dataEntity, sqlList);
    }

    public void GenInsertTableSql(IDAActionContext iDAActionContext, IDEHelper iDEHelper, BaseDataEntity dataEntity, ArrayList<String> sqlList) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("INSERT INTO  %1$s (\r\n", (Object)iDEHelper.GetMainTable());
        sb.Append("%1$s \r\n", (Object)iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName());
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsKeyDEField()) continue;
            sb.Append(",%1$s \r\n", (Object)iDEFHelper.GetDTColumn().GetColumnName());
        }
        sb.Append(") VALUES (\r\n");
        sb.Append("%1$s \r\n", (Object)this.GetDBColumeValue(iDEHelper.GetKeyDEFHelper(), dataEntity));
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (iDEFHelper.IsKeyDEField()) continue;
            sb.Append(",%1$s \r\n", (Object)this.GetDBColumeValue(iDEFHelper, dataEntity));
        }
        sb.Append(");\r\n");
        sqlList.add(sb.toString());
    }

    protected String GetDBDataType(IDEFHelper iDEFHelper) throws Exception {
        String strStdDataType = iDEFHelper.GetStdDataType();
        if (StringHelper.Compare((String)strStdDataType, (String)"VARCHAR", (boolean)true) == 0) {
            return "VARCHAR";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TEXT", (boolean)true) == 0) {
            return "TEXT";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"INT", (boolean)true) == 0) {
            return "INTEGER";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"FLOAT", (boolean)true) == 0) {
            return "DOUBLE";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATETIME", (boolean)true) == 0) {
            return "TIMESTAMP";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATE", (boolean)true) == 0) {
            return "DATE";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TIME", (boolean)true) == 0) {
            return "TIMESTAMP";
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6807\u51c6\u6570\u636e\u7c7b\u578b[%1$s]", (Object)strStdDataType));
    }

    protected String GetDBDataType(IDEFHelper iDEFHelper, boolean appendNullFlag, boolean allowNull, boolean appendDefault, String strDefault) throws Exception {
        String strStdDataType = iDEFHelper.GetStdDataType();
        if (StringHelper.Compare((String)strStdDataType, (String)"VARCHAR", (boolean)true) == 0) {
            int nLength = iDEFHelper.GetDTColumn().GetLength();
            if (nLength <= 0) {
                nLength = 200;
            }
            if (nLength >= 4000) {
                nLength = 4000;
            }
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" NVARCHAR(%1$s) ", (Object)nLength);
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TEXT", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" TEXT ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"INT", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" INTEGER ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"FLOAT", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DOUBLE ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATETIME", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" TIMESTAMP ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATE", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATE ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TIME", (boolean)true) == 0) {
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" TIMESTAMP ");
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DECIMAL", (boolean)true) == 0) {
            int nPRECISION;
            int nLength = iDEFHelper.GetDTColumn().GetLength();
            if (nLength <= 0) {
                nLength = 12;
            }
            if ((nPRECISION = iDEFHelper.GetPrecision()) <= 0) {
                nPRECISION = 0;
            }
            String strDBType = "";
            strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DECIMAL(%1$s,%2$s) ", (Object)nLength, (Object)nPRECISION);
            if (appendNullFlag) {
                strDBType = allowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
            }
            return strDBType;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6807\u51c6\u6570\u636e\u7c7b\u578b[%1$s]", (Object)strStdDataType));
    }

    protected String GetDBColumeValue(IDEFHelper iDEFHelper, BaseDataEntity dataEntity) throws Exception {
        String strStdDataType = iDEFHelper.GetStdDataType();
        Object objValue = dataEntity.GetParamValue(iDEFHelper.GetDTColumn().GetColumnName());
        if (objValue == null) {
            return "NULL";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"VARCHAR", (boolean)true) == 0) {
            String strValue = objValue.toString();
            return "'" + strValue.replace("'", "''") + "'";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TEXT", (boolean)true) == 0) {
            String strValue = objValue.toString();
            return "'" + strValue.replace("'", "''") + "'";
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"INT", (boolean)true) == 0) {
            return objValue.toString();
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"FLOAT", (boolean)true) == 0) {
            return objValue.toString();
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATETIME", (boolean)true) == 0) {
            return StringHelper.Format((String)"'%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS'", (Object)objValue);
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DATE", (boolean)true) == 0) {
            return StringHelper.Format((String)"'%1$tY-%1$tm-%1$td 00:00:00'", (Object)objValue);
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"TIME", (boolean)true) == 0) {
            return StringHelper.Format((String)"'%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS'", (Object)objValue);
        }
        if (StringHelper.Compare((String)strStdDataType, (String)"DECIMAL", (boolean)true) == 0) {
            return objValue.toString();
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6807\u51c6\u6570\u636e\u7c7b\u578b[%1$s]", (Object)strStdDataType));
    }
}

