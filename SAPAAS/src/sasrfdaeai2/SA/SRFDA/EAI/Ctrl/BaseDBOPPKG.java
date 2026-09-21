/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.EAI.Ctrl.BaseDBOPDataObject;
import SA.SRFDA.EAI.Ctrl.BaseDBOPObject;
import SA.SRFDA.EAI.Ctrl.BaseDBOPRecordSet;
import SA.SRFDA.EAI.Ctrl.DBOPPublishContext;
import SA.SRFDA.EAI.Ctrl.IDBOPDataObject;
import SA.SRFDA.EAI.Ctrl.IDBOPPKG;
import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Ctrl.IDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPRecordSet;
import SA.SRFDA.EAI.Ctrl.IDBOPSetting;
import SA.SRFDA.EAI.Ctrl.IDBOPTmpTable;
import SA.SRFDA.EAI.Ctrl.Templ.DBOPPKGDBSchemaMethod;
import SA.SRFDA.EAI.Ctrl.Templ.DBOPPKGMacroMethod;
import SA.SRFDA.EAI.Ctrl.Templ.DBOPPKGParamMethod;
import SA.SRFDA.EAI.Data.DBDO;
import SA.SRFDA.EAI.Data.DBOPPKG;
import SA.SRFDA.EAI.Data.DBOPPKGParam;
import SA.SRFDA.EAI.Data.DBOPProc;
import SA.SRFDA.EAI.Data.DBRS;
import SA.SRFDA.EAI.Data.DBTmpTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDBOPPKG
extends BaseDBOPObject
implements IDBOPPKG,
IDBOPPKGContext {
    private static final Log log = LogFactory.getLog(BaseDBOPPKG.class);
    protected DBOPPKG dbOPPkg = null;
    protected IDBOPSetting iDBOPSetting = null;
    protected String strDBSCHEMA = "";
    protected Hashtable<String, IDBOPProcess> processMap = new Hashtable();
    protected Hashtable<String, IDEDataCtrl> dataCtrlMap = new Hashtable();
    protected Hashtable<String, IDBOPDataObject> dataObjectMap = new Hashtable();
    protected Hashtable<String, IDBOPRecordSet> recordSetMap = new Hashtable();
    protected Hashtable<String, IDBOPTmpTable> tmpTableMap = new Hashtable();
    protected Hashtable<String, String> paramMap = new Hashtable();
    private int nPID = 100;
    private String strProcName = "";
    private boolean bPreparePKG = false;
    protected IDBOPProcess pkgBodyProcess = null;
    protected Vector<DBOPPKGParam> procParams = new Vector();
    protected Vector<DBOPPKGParam> internalParams = new Vector();
    public static final String TAG_VAR = "VAR_";
    public static final String TAG_SRF = "SRF_";
    protected Map<String, Object> templMethodMap = new TreeMap<String, Object>();
    protected Hashtable<String, String> dbSchemaMap = new Hashtable();

    @Override
    public void Init(DBOPPKG dbOPPkg, IDBOPSetting iDBOPSetting, ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.dbOPPkg = dbOPPkg;
        this.iDBOPSetting = iDBOPSetting;
        if (!StringHelper.IsNullOrEmpty((String)this.OnGetDBStorage())) {
            IDBStorage iDBStorage = iDAGlobalHelper.getDAModelStorage().FindDBStorage(this.OnGetDBStorage());
            if (iDBStorage == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b58\u50a8[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.OnGetDBStorage()));
            }
            this.strDBSCHEMA = iDBStorage.GetDBSCHEMA();
        } else {
            this.strDBSCHEMA = iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DBSCHEMA", this.strDBSCHEMA);
        }
        this.strProcName = StringHelper.IsNullOrEmpty((String)dbOPPkg.getPROCNAME()) ? StringHelper.Format((String)"SRFSP_%1$s", (Object)dbOPPkg.getEAIDBOPPKGNAME()) : dbOPPkg.getPROCNAME();
        this.OnPrepareDBSchema();
        this.OnPrepareTemplEnv();
        this.OnPreparePkgParams();
        this.OnInit();
    }

    protected void OnPreparePkgParams() throws Exception {
        Vector<DBOPPKGParam> list = new Vector<DBOPPKGParam>();
        CallResult callResult = this.getDBOPModelHelper().GetDBOPPkgParams(this.dbOPPkg.getEAIDBOPPKGID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53c2\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DBOPPKGParam param : list) {
            if (StringHelper.Compare((String)param.getPARAMTYPE(), (String)"INTERNAL", (boolean)true) == 0) {
                this.internalParams.add(param);
                this.paramMap.put(param.getEAIDBOPPKGPARAMNAME(), StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAR, (Object)param.getEAIDBOPPKGPARAMNAME()));
                continue;
            }
            this.procParams.add(param);
            this.paramMap.put(param.getEAIDBOPPKGPARAMNAME(), StringHelper.Format((String)"%1$s%2$s", (Object)TAG_SRF, (Object)param.getEAIDBOPPKGPARAMNAME()));
        }
    }

    protected void OnPrepareDBSchema() throws Exception {
        Properties dbSchemaMap = PropertiesHelper.Load((String)this.dbOPPkg.getDBSCHEMAMAP());
        Enumeration<Object> en = dbSchemaMap.keys();
        while (en.hasMoreElements()) {
            String strDBSchemaId = (String)en.nextElement();
            String strDBSchemaName = PropertiesHelper.GetProperty((Properties)dbSchemaMap, (String)strDBSchemaId);
            dbSchemaMap.put(strDBSchemaId.toUpperCase(), strDBSchemaName);
        }
    }

    protected void OnPrepareTemplEnv() throws Exception {
        DBOPPKGMacroMethod macroMethod = new DBOPPKGMacroMethod();
        macroMethod.setDBOPPKGContext(this);
        this.templMethodMap.put("macro", macroMethod);
        DBOPPKGParamMethod paramMethod = new DBOPPKGParamMethod();
        paramMethod.setDBOPPKGContext(this);
        this.templMethodMap.put("param", paramMethod);
        DBOPPKGDBSchemaMethod dboMethod = new DBOPPKGDBSchemaMethod();
        dboMethod.setDBOPPKGContext(this);
        this.templMethodMap.put("dbo", dboMethod);
        this.templMethodMap.put("pkgid", this.dbOPPkg.getEAIDBOPPKGID());
        this.templMethodMap.put("pkgname", this.dbOPPkg.getEAIDBOPPKGNAME());
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public void Publish(boolean bAlwaysCreate) throws Exception {
        this.OnPublish(bAlwaysCreate);
    }

    protected void OnPublish(boolean bAlwaysCreate) throws Exception {
        if (!bAlwaysCreate && this.IsDBProcExist(this.getProcName())) {
            return;
        }
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(this.getProcName());
        if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
            this.DropDBProc(this.getProcName(), strSQL);
        }
        this.PreparePKG();
        String strCode = this.OnGenDBOPPKGCode();
        log.info((Object)StringHelper.Format((String)"\u6570\u636e\u5e93\u4f5c\u4e1a\u5305[%1$s]\u4ee3\u7801\r\n%2$s", (Object)this.dbOPPkg.getEAIDBOPPKGNAME(), (Object)strCode));
        CallResult callResult = this.CompileDBProc(this.getProcName(), strCode);
        if (callResult.IsError()) {
            throw new Exception(callResult.getErrorInfo());
        }
    }

    protected String OnGenDBOPPKGCode() throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.OnGenDBOPPKG_Header(stringBuilder);
        this.OnGenDBOPPKG_Body(stringBuilder);
        return stringBuilder.toString();
    }

    protected abstract void OnGenDBOPPKG_Header(StringBuilderEx var1) throws Exception;

    protected abstract void OnGenDBOPPKG_Body(StringBuilderEx var1) throws Exception;

    @Override
    public IDBOPDataObject FindDBDataObject(String strDBDataObjectId) throws Exception {
        if (this.dataObjectMap.containsKey(strDBDataObjectId)) {
            return this.dataObjectMap.get(strDBDataObjectId);
        }
        IDEDataCtrl iDEDataCtrl = this.FindDEDataCtrl("EAI0052");
        DBDO dbDO = new DBDO();
        dbDO.setEAIDBDOID(strDBDataObjectId);
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)dbDO);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u6570\u636e\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDBDataObjectId, (Object)callResult.getErrorInfo()));
        }
        IDBOPDataObject iDBOPDataObject = this.OnCreateDBDataObject(dbDO);
        iDBOPDataObject.Init(this, dbDO);
        this.dataObjectMap.put(strDBDataObjectId, iDBOPDataObject);
        return iDBOPDataObject;
    }

    @Override
    public IDBOPProcess FindDBOPProcess(String strDBOPProcessId) throws Exception {
        if (this.processMap.containsKey(strDBOPProcessId)) {
            return this.processMap.get(strDBOPProcessId);
        }
        IDEDataCtrl iDEDataCtrl = this.FindDEDataCtrl("EAI0060");
        DBOPProc dbOPProc = new DBOPProc();
        dbOPProc.setEAIDBOPPROCID(strDBOPProcessId);
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)dbOPProc);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5904\u7406[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDBOPProcessId, (Object)callResult.getErrorInfo()));
        }
        IDBOPProcess dbOPProcess = this.OnCreateDBOPProcess(dbOPProc);
        dbOPProcess.Init(this, dbOPProc);
        this.processMap.put(strDBOPProcessId, dbOPProcess);
        return dbOPProcess;
    }

    @Override
    public IDBOPRecordSet FindDBRecordSet(String strDBRecordSetId) throws Exception {
        if (this.recordSetMap.containsKey(strDBRecordSetId)) {
            return this.recordSetMap.get(strDBRecordSetId);
        }
        IDEDataCtrl iDEDataCtrl = this.FindDEDataCtrl("EAI0053");
        DBRS dbRS = new DBRS();
        dbRS.setEAIDBRSID(strDBRecordSetId);
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)dbRS);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u7ed3\u679c\u96c6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDBRecordSetId, (Object)callResult.getErrorInfo()));
        }
        IDBOPRecordSet iDBOPDataObject = this.OnCreateDBRecordSet(dbRS);
        iDBOPDataObject.Init(this, dbRS);
        this.recordSetMap.put(strDBRecordSetId, iDBOPDataObject);
        return iDBOPDataObject;
    }

    @Override
    public IDBOPTmpTable FindDBOPTmpTable(String strDBOPTmpTableId) throws Exception {
        if (this.tmpTableMap.containsKey(strDBOPTmpTableId)) {
            return this.tmpTableMap.get(strDBOPTmpTableId);
        }
        IDEDataCtrl iDEDataCtrl = this.FindDEDataCtrl("EAI0045");
        DBTmpTable tmpTable = new DBTmpTable();
        tmpTable.setEAIDBTMPTABID(strDBOPTmpTableId);
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)tmpTable);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u4e34\u65f6\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDBOPTmpTableId, (Object)callResult.getErrorInfo()));
        }
        IDBOPTmpTable iDBOPTmpTable = this.OnCreateDBOPTmpTable(tmpTable);
        iDBOPTmpTable.Init(this, tmpTable);
        this.tmpTableMap.put(strDBOPTmpTableId, iDBOPTmpTable);
        return iDBOPTmpTable;
    }

    @Override
    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected abstract IDBOPProcess OnCreateDBOPProcess(DBOPProc var1) throws Exception;

    protected abstract IDBOPTmpTable OnCreateDBOPTmpTable(DBTmpTable var1) throws Exception;

    protected IDBOPRecordSet OnCreateDBRecordSet(DBRS dbRS) throws Exception {
        return new BaseDBOPRecordSet();
    }

    protected IDBOPDataObject OnCreateDBDataObject(DBDO dbDataObject) throws Exception {
        BaseDBOPDataObject dbOPDataObject = new BaseDBOPDataObject();
        return dbOPDataObject;
    }

    @Override
    public IDEDataCtrl FindDEDataCtrl(String strDEId) throws Exception {
        if (this.dataCtrlMap.containsKey(strDEId)) {
            return this.dataCtrlMap.get(strDEId);
        }
        IDEDataCtrl iDEDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl(strDEId, "SYSTEM", null);
        if (iDEDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
        }
        this.dataCtrlMap.put(strDEId, iDEDataCtrl);
        return iDEDataCtrl;
    }

    @Override
    public synchronized String GetUniqueProcId() {
        ++this.nPID;
        return StringHelper.Format((String)"P%1$s", (Object)this.nPID);
    }

    @Override
    public String getProcName() {
        return this.strProcName;
    }

    protected CallResult CompileDBProc(String strProcName, String strSQL) {
        CallResult calLResult = new CallResult();
        try {
            SelectResult result = this.getDAGlobalHelper().getDBCaller(this.OnGetDBStorage()).CallRaw2(strSQL);
            if (result.getRetCode() != 0) {
                calLResult.From((DBResult)result);
                return calLResult;
            }
            if (this.IsDBProcExist(strProcName)) {
                calLResult.setRetCode(0);
                return calLResult;
            }
            calLResult.setRetCode(1);
            return calLResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u7f16\u8bd1\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef\r\n%2$s", (Object)strProcName, (Object)strSQL), (Throwable)ex);
            calLResult.setRetCode(1);
            calLResult.setErrorInfo(StringHelper.Format((String)"\u7f16\u8bd1\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName));
            return calLResult;
        }
    }

    protected CallResult DropDBProc(String strProcName, String strSQL) {
        CallResult calLResult = new CallResult();
        try {
            DBResult result = this.getDAGlobalHelper().getDBCaller(this.OnGetDBStorage()).CallRaw3WithoutReturn(strSQL, null);
            if (result.getRetCode() != 0) {
                calLResult.From(result);
                return calLResult;
            }
            if (this.IsDBProcExist(strProcName)) {
                calLResult.setRetCode(1);
                return calLResult;
            }
            calLResult.setRetCode(0);
            return calLResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName), (Throwable)ex);
            calLResult.setRetCode(1);
            calLResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName));
            return calLResult;
        }
    }

    protected String OnGetDBStorage() {
        return this.dbOPPkg.getDBSTORAGE();
    }

    protected IDEDataCtrlHelper GetDEDataCtrlHelper() {
        return this.getDAGlobalHelper().getDEDataCtrlHelper(this.OnGetDBStorage());
    }

    protected synchronized void PreparePKG() throws Exception {
        if (this.bPreparePKG) {
            return;
        }
        this.bPreparePKG = true;
        this.pkgBodyProcess = this.OnCreatePkgBodyProcess();
        this.PreparePKGParams();
    }

    protected void PreparePKGParams() throws Exception {
    }

    protected abstract IDBOPProcess OnCreatePkgBodyProcess() throws Exception;

    @Override
    public String ParseMacro(String strCode) throws Exception {
        StringTemplateLoader dpTemplateLoader = new StringTemplateLoader();
        dpTemplateLoader.putTemplate("CODE", strCode);
        Configuration config = new Configuration();
        config.setTemplateLoader((TemplateLoader)dpTemplateLoader);
        Template template = config.getTemplate("CODE");
        StringWriter sw = new StringWriter();
        template.process(this.templMethodMap, (Writer)sw);
        return sw.toString();
    }

    @Override
    public String ParseMacro(Map<String, Object> extParam, String strCode) throws Exception {
        StringTemplateLoader dpTemplateLoader = new StringTemplateLoader();
        dpTemplateLoader.putTemplate("CODE", strCode);
        Configuration config = new Configuration();
        config.setTemplateLoader((TemplateLoader)dpTemplateLoader);
        Template template = config.getTemplate("CODE");
        StringWriter sw = new StringWriter();
        if (extParam != null) {
            for (String strKey : extParam.keySet()) {
                this.templMethodMap.put(strKey, extParam.get(strKey));
            }
        }
        template.process(this.templMethodMap, (Writer)sw);
        if (extParam != null) {
            for (String strKey : extParam.keySet()) {
                this.templMethodMap.remove(strKey);
            }
        }
        return sw.toString();
    }

    @Override
    public String FindDBSchema(String strDBSchemaId) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strDBSchemaId)) {
            return this.getDBSchema();
        }
        String strDBSchemaId2 = strDBSchemaId.toUpperCase();
        if (this.dbSchemaMap.containsKey(strDBSchemaId2)) {
            return this.dbSchemaMap.get(strDBSchemaId2);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6807\u8bc6[%1$s]\u7684\u6570\u636e\u5e93\u6240\u6709\u8005", (Object)strDBSchemaId));
    }

    protected boolean IsDBProcExist(String strProcName) throws Exception {
        Integer nRowCnt = 0;
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsProcExist(strProcName);
        BaseDataEntity rowCount = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getDAGlobalHelper(), (String)this.OnGetDBStorage(), (String)strSQL, (BaseDataEntity)rowCount);
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u5224\u65ad\u5b58\u50a8\u8fc7\u7a0b[%1$s]\u662f\u5426\u5b58\u5728\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strProcName, (Object)callResult.getErrorInfo()));
        }
        nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        return nRowCnt == 1;
    }

    protected String getDBSchema() {
        return this.strDBSCHEMA;
    }

    protected void OnGenDBOPPKG_Body_UserDeclare(StringBuilderEx stringBuilder) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.dbOPPkg.getDECLARECODE())) {
            stringBuilder.Append("\n");
            stringBuilder.Append(this.dbOPPkg.getDECLARECODE());
            stringBuilder.Append("\n");
        }
    }

    protected void OnGenDBOPPKG_Body_SystemInit(StringBuilderEx stringBuilder) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.iDBOPSetting.getInitCode())) {
            stringBuilder.Append("\n");
            stringBuilder.Append(this.ParseMacro(this.iDBOPSetting.getInitCode()));
            stringBuilder.Append("\n");
        }
    }

    protected void OnGenDBOPPKG_Body_UserInit(StringBuilderEx stringBuilder) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.dbOPPkg.getINITCODE())) {
            stringBuilder.Append("\n");
            stringBuilder.Append(this.dbOPPkg.getINITCODE());
            stringBuilder.Append("\n");
        }
    }

    protected void OnGenDBOPPKG_Body_CreateTmpTable(StringBuilderEx stringBuilder) throws Exception {
        DBOPPublishContext publicContext = new DBOPPublishContext();
        publicContext.setWriter(stringBuilder.getWriter());
        for (IDBOPTmpTable iDBOPTmpTable : this.tmpTableMap.values()) {
            iDBOPTmpTable.Publish(publicContext);
        }
    }

    protected void OnGenDBOPPKG_Body_DropTmpTable(StringBuilderEx stringBuilder) throws Exception {
        DBOPPublishContext publicContext = new DBOPPublishContext();
        publicContext.setWriter(stringBuilder.getWriter());
        for (IDBOPTmpTable iDBOPTmpTable : this.tmpTableMap.values()) {
            iDBOPTmpTable.PublishDrop(publicContext);
        }
    }

    protected void OnGenDBOPPKG_Body_Process(StringBuilderEx stringBuilder) throws Exception {
        DBOPPublishContext publicContext = new DBOPPublishContext();
        publicContext.setWriter(stringBuilder.getWriter());
        this.pkgBodyProcess.Publish(publicContext);
    }

    @Override
    public IDBOPSetting getDBOPSetting() {
        return this.iDBOPSetting;
    }

    @Override
    public String FindPkgParam(String strParamId) {
        if (!StringHelper.IsNullOrEmpty((String)this.iDBOPSetting.FindPkgParam(strParamId))) {
            return this.iDBOPSetting.FindPkgParam(strParamId);
        }
        if (this.paramMap.containsKey(strParamId)) {
            return this.paramMap.get(strParamId);
        }
        this.iDBOPSetting.getSysDeclareParams();
        return "";
    }
}

