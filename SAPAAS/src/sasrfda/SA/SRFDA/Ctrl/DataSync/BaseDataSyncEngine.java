/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.Data.DataSyncAgent;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngine;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngineParam;
import SA.SRFDA.Ctrl.DataSync.IDataSyncInEngine;
import SA.SRFDA.Ctrl.DataSync.IDataSyncOutEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class BaseDataSyncEngine
implements IDataSyncEngine,
IDataSyncOutEngine,
IDataSyncInEngine {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected DataSyncAgent dataSyncAgent = null;
    private boolean bSyncOut = false;
    protected Properties properties = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DataSyncAgent dataSyncAgent) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.dataSyncAgent = dataSyncAgent;
        this.bSyncOut = StringHelper.Compare((String)dataSyncAgent.getSYNCDIR(), (String)"OUT", (boolean)true) == 0;
        this.properties = PropertiesHelper.Load((String)dataSyncAgent.getAGENTPARAM());
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    protected ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    public String getId() {
        return this.dataSyncAgent.getDATASYNCAGENTID();
    }

    @Override
    public String getName() {
        return this.dataSyncAgent.getDATASYNCAGENTNAME();
    }

    @Override
    public String getSyncDir() {
        return this.dataSyncAgent.getSYNCDIR();
    }

    protected Properties getParams() {
        return this.properties;
    }

    @Override
    public boolean CheckSend() {
        return this.OnCheckSend();
    }

    protected boolean OnCheckSend() {
        return true;
    }

    @Override
    public void Send(IDataSyncEngineParam param) throws Exception {
        if (!this.bSyncOut) {
            throw new Exception("\u540c\u6b65\u4ee3\u7406\u4e0d\u662f\u7528\u4e8e\u8f93\u51fa");
        }
        this.OnSend(param);
    }

    protected void OnSend(IDataSyncEngineParam param) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u8be5\u65b9\u6cd5");
    }

    @Override
    public void Recv(IDataSyncEngineParam iDataSyncEngineParam) throws Exception {
        this.OnRecv(iDataSyncEngineParam);
    }

    protected void OnRecv(IDataSyncEngineParam iDataSyncEngineParam) throws Exception {
    }

    @Override
    public void Quit() throws Exception {
        this.OnQuit();
    }

    protected void OnQuit() throws Exception {
    }

    @Override
    public boolean CheckRecv() {
        return this.OnCheckRecv();
    }

    public boolean OnCheckRecv() {
        return true;
    }
}

