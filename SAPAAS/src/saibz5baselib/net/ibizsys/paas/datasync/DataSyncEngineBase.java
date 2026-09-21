/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datasync;

import java.util.Properties;
import net.ibizsys.paas.datasync.IDataSyncEngine;
import net.ibizsys.paas.datasync.IDataSyncInEngine;
import net.ibizsys.paas.datasync.IDataSyncOutEngine;
import net.ibizsys.paas.datasync.IDataSyncParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;

public class DataSyncEngineBase
implements IDataSyncEngine,
IDataSyncOutEngine,
IDataSyncInEngine {
    protected DataSyncAgent dataSyncAgent = null;
    private boolean bSyncOut = false;
    protected Properties properties = null;

    @Override
    public void init(DataSyncAgent dataSyncAgent) throws Exception {
        this.dataSyncAgent = dataSyncAgent;
        this.bSyncOut = StringHelper.compare(dataSyncAgent.getSyncDir(), "OUT", true) == 0;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.dataSyncAgent.getDataSyncAgentId();
    }

    @Override
    public String getName() {
        return this.dataSyncAgent.getDataSyncAgentName();
    }

    @Override
    public String getSyncDir() {
        return this.dataSyncAgent.getSyncDir();
    }

    protected Properties getParams() {
        return this.properties;
    }

    @Override
    public boolean checkSend() throws Exception {
        return this.onCheckSend();
    }

    protected boolean onCheckSend() throws Exception {
        return true;
    }

    @Override
    public void send(IDataSyncParam iDataSyncParam) throws Exception {
        if (!this.bSyncOut) {
            throw new Exception("\u036c\u5f53\u524d\u5f15\u64ce\u4e0d\u662f\u8f93\u51fa\u5f15\u64ce");
        }
        this.onSend(iDataSyncParam);
    }

    protected void onSend(IDataSyncParam iDataSyncParam) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void recv(IDataSyncParam iDataSyncParam) throws Exception {
        if (this.bSyncOut) {
            throw new Exception("\u036c\u5f53\u524d\u5f15\u64ce\u4e0d\u662f\u8f93\u5165\u5f15\u64ce");
        }
        this.onRecv(iDataSyncParam);
    }

    protected void onRecv(IDataSyncParam iDataSyncParam) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void quit() throws Exception {
        this.onQuit();
    }

    protected void onQuit() throws Exception {
    }

    @Override
    public boolean checkRecv() throws Exception {
        return this.onCheckRecv();
    }

    protected boolean onCheckRecv() throws Exception {
        return true;
    }
}

