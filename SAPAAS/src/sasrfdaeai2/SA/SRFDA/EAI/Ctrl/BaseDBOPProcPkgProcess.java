/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.BaseDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Data.DBProcPkg;
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
import java.util.Hashtable;
import java.util.Iterator;

public abstract class BaseDBOPProcPkgProcess
extends BaseDBOPProcess {
    protected DBProcPkg dbProcPkg = null;
    protected boolean bOPPkgBody = false;
    protected DBOPPKGConfig dbOPKpgConfig = null;
    private int nLoopCount = 0;

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        if (this.dbOPProc instanceof DBProcPkg) {
            this.dbProcPkg = (DBProcPkg)this.dbOPProc;
            if (StringHelper.IsNullOrEmpty((String)this.dbProcPkg.getEAIDBPROCPKGID())) {
                this.bOPPkgBody = true;
            }
        }
        if (this.dbProcPkg == null) {
            this.dbProcPkg = new DBProcPkg();
            this.dbProcPkg.setEAIDBPROCPKGID(this.dbOPProc.GetParamStringValue("EAIDBOPPROCID", ""));
            IDEDataCtrl iDEDataCtrl = this.context.FindDEDataCtrl("EAI0064");
            CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)this.dbProcPkg);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5904\u7406\u5305[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.dbProcPkg.getEAIDBPROCPKGID(), (Object)callResult.getErrorInfo()));
            }
        }
        this.dbOPKpgConfig = new DBOPPKGConfig();
        XMLConfig.LoadFromXML((String)this.dbProcPkg.getPROCMODEL(), (XMLConfig)this.dbOPKpgConfig);
        if (this.dbOPKpgConfig.getProcessesConfig().GetStartProcessConfig() == null) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5904\u7406\u5305[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8d77\u70b9", (Object)this.dbProcPkg.getEAIDBPROCPKGID()));
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

    @Override
    protected void OnPublish(IDBOPPublishContext context) throws Exception {
        this.nLoopCount = 0;
        this.OnPublishProcess(context, this.dbOPKpgConfig.getProcessesConfig().GetStartProcessConfig());
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

