/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.BaseDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Ctrl.IDBOPRecordSet;
import SA.SRFDA.EAI.Data.DBSelLoop;
import SA.SRFDA.EAI.Model.DBOPBaseProcessConfig;
import SA.SRFDA.EAI.Model.DBOPConnectionConfig;
import SA.SRFDA.EAI.Model.DBOPDicisionConfig;
import SA.SRFDA.EAI.Model.DBOPEndConfig;
import SA.SRFDA.EAI.Model.DBOPPKGConfig;
import SA.SRFDA.EAI.Model.DBOPProcessConfig;
import SA.SRFDA.EAI.Model.DBOPStartConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeMap;

public abstract class BaseDBOPSelLoopProcess
extends BaseDBOPProcess {
    protected DBSelLoop dbSelLoop = null;
    protected IDBOPRecordSet iRecordSet = null;
    protected DBOPPKGConfig dbOPKpgConfig = null;
    protected TreeMap<String, String> insertFieldMap = new TreeMap();
    protected String strQueryCond = "";
    private int nLoopCount = 0;

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.dbSelLoop = new DBSelLoop();
        this.dbSelLoop.setEAIDBSELLOOPID(this.dbOPProc.GetParamStringValue("EAIDBOPPROCID", ""));
        IDEDataCtrl iDEDataCtrl = this.context.FindDEDataCtrl("EAI0062");
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)this.dbSelLoop);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5904\u7406[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.dbSelLoop.getEAIDBSELLOOPID(), (Object)callResult.getErrorInfo()));
        }
        this.iRecordSet = this.context.FindDBRecordSet(this.dbSelLoop.getEAIDBRSID());
        String strFieldMap = this.dbSelLoop.getFIELDMAP();
        Properties fieldMap = PropertiesHelper.Load((String)strFieldMap);
        Enumeration<Object> en = fieldMap.keys();
        while (en.hasMoreElements()) {
            String strInsertField = (String)en.nextElement();
            String strInsertValue = PropertiesHelper.GetProperty((Properties)fieldMap, (String)strInsertField);
            strInsertValue = this.context.ParseMacro(strInsertValue);
            strInsertValue = this.iRecordSet.ParseMacro(strInsertValue);
            this.insertFieldMap.put(strInsertField, strInsertValue);
        }
        this.strQueryCond = this.context.ParseMacro(this.dbSelLoop.getQUERYCOND());
        this.dbOPKpgConfig = new DBOPPKGConfig();
        XMLConfig.LoadFromXML((String)this.dbSelLoop.getPROCMODEL(), (XMLConfig)this.dbOPKpgConfig);
        if (this.dbOPKpgConfig.getProcessesConfig().GetStartProcessConfig() == null) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5904\u7406\u5305[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8d77\u70b9", (Object)this.dbSelLoop.getEAIDBSELLOOPID()));
        }
        this.OnPrepareProcesses();
    }

    protected void OnPrepareProcesses() throws Exception {
        Hashtable<String, String> loadedMap = new Hashtable<String, String>();
        this.OnPrepareProcess(this.dbOPKpgConfig.getProcessesConfig().GetStartProcessConfig(), loadedMap);
    }

    protected void OnPrepareProcess(DBOPBaseProcessConfig processConfig, Hashtable<String, String> loadedMap) throws Exception {
        if (loadedMap.containsKey(processConfig.getID())) {
            return;
        }
        loadedMap.put(processConfig.getID(), "");
        if (processConfig instanceof DBOPEndConfig) {
            return;
        }
        if (processConfig instanceof DBOPDicisionConfig) {
            DBOPDicisionConfig dicisionConfig = (DBOPDicisionConfig)processConfig;
            Iterator iterator = dicisionConfig.getConnectionsConfig().iterator();
            while (iterator.hasNext()) {
                DBOPConnectionConfig connectionConfig = (DBOPConnectionConfig)((Object)iterator.next());
                DBOPBaseProcessConfig nextProcessConfig = this.dbOPKpgConfig.getProcessesConfig().FindProcessConfig(connectionConfig.getNext());
                if (nextProcessConfig == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]", (Object)connectionConfig.getNext()));
                }
                this.OnPrepareProcess(nextProcessConfig, loadedMap);
            }
            return;
        }
        if (processConfig instanceof DBOPStartConfig) {
            DBOPBaseProcessConfig nextProcessConfig = this.dbOPKpgConfig.getProcessesConfig().FindProcessConfig(processConfig.getNext());
            if (nextProcessConfig == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]", (Object)processConfig.getNext()));
            }
            this.OnPrepareProcess(nextProcessConfig, loadedMap);
        }
        if (processConfig instanceof DBOPProcessConfig) {
            DBOPProcessConfig procConfig = (DBOPProcessConfig)processConfig;
            this.context.FindDBOPProcess(procConfig.getProcessConfig());
            DBOPBaseProcessConfig nextProcessConfig = this.dbOPKpgConfig.getProcessesConfig().FindProcessConfig(processConfig.getNext());
            if (nextProcessConfig == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]", (Object)processConfig.getNext()));
            }
            this.OnPrepareProcess(nextProcessConfig, loadedMap);
        }
    }

    protected void OnPublishProcess(IDBOPPublishContext context, DBOPBaseProcessConfig processConfig) throws Exception {
        ++this.nLoopCount;
        if (this.nLoopCount > 100) {
            throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801\u9012\u5f52\u8c03\u7528\u8d85\u8fc7[%1$s]\uff0c\u53ef\u80fd\u51fa\u73b0\u6b7b\u5faa\u73af", (Object)this.nLoopCount));
        }
        if (processConfig instanceof DBOPEndConfig) {
            return;
        }
        if (processConfig instanceof DBOPDicisionConfig) {
            DBOPDicisionConfig dicisionConfig = (DBOPDicisionConfig)processConfig;
            Iterator iterator = dicisionConfig.getConnectionsConfig().iterator();
            while (iterator.hasNext()) {
                DBOPConnectionConfig connectionConfig = (DBOPConnectionConfig)((Object)iterator.next());
                DBOPBaseProcessConfig nextProcessConfig = this.dbOPKpgConfig.getProcessesConfig().FindProcessConfig(connectionConfig.getNext());
                if (nextProcessConfig == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]", (Object)connectionConfig.getNext()));
                }
                this.OnPublishConnectionStart(context, connectionConfig);
                context.ShiftRight();
                this.OnPublishProcess(context, nextProcessConfig);
                context.ShiftLeft();
                this.OnPublishConnectionEnd(context, connectionConfig);
            }
            return;
        }
        if (processConfig instanceof DBOPStartConfig) {
            DBOPBaseProcessConfig nextProcessConfig = this.dbOPKpgConfig.getProcessesConfig().FindProcessConfig(processConfig.getNext());
            if (nextProcessConfig == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]", (Object)processConfig.getNext()));
            }
            this.OnPublishProcess(context, nextProcessConfig);
        }
        if (processConfig instanceof DBOPProcessConfig) {
            DBOPProcessConfig procConfig = (DBOPProcessConfig)processConfig;
            IDBOPProcess iDBOPProcess = this.context.FindDBOPProcess(procConfig.getProcessConfig());
            iDBOPProcess.Publish(context);
            DBOPBaseProcessConfig nextProcessConfig = this.dbOPKpgConfig.getProcessesConfig().FindProcessConfig(processConfig.getNext());
            if (nextProcessConfig == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]", (Object)processConfig.getNext()));
            }
            this.OnPublishProcess(context, nextProcessConfig);
        }
    }

    protected abstract void OnPublishConnectionStart(IDBOPPublishContext var1, DBOPConnectionConfig var2) throws Exception;

    protected abstract void OnPublishConnectionEnd(IDBOPPublishContext var1, DBOPConnectionConfig var2) throws Exception;
}

