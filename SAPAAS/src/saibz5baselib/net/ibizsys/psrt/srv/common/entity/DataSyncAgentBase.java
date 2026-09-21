/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DataSyncAgentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataSyncAgentBase.class);
    public static final String FIELD_AGENTPARAM = "AGENTPARAM";
    public static final String FIELD_AGENTTYPE = "AGENTTYPE";
    public static final String FIELD_CLIENTID = "CLIENTID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATASYNCAGENTID = "DATASYNCAGENTID";
    public static final String FIELD_DATASYNCAGENTNAME = "DATASYNCAGENTNAME";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PWD = "PWD";
    public static final String FIELD_SERVERPATH = "SERVERPATH";
    public static final String FIELD_SERVICENAME = "SERVICENAME";
    public static final String FIELD_SYNCDIR = "SYNCDIR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_AGENTPARAM = 0;
    private static final int INDEX_AGENTTYPE = 1;
    private static final int INDEX_CLIENTID = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DATASYNCAGENTID = 5;
    private static final int INDEX_DATASYNCAGENTNAME = 6;
    private static final int INDEX_ENABLE = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PWD = 9;
    private static final int INDEX_SERVERPATH = 10;
    private static final int INDEX_SERVICENAME = 11;
    private static final int INDEX_SYNCDIR = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERNAME = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DataSyncAgentBase proxyDataSyncAgentBase = null;
    private boolean agentparamDirtyFlag = false;
    private boolean agenttypeDirtyFlag = false;
    private boolean clientidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datasyncagentidDirtyFlag = false;
    private boolean datasyncagentnameDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pwdDirtyFlag = false;
    private boolean serverpathDirtyFlag = false;
    private boolean servicenameDirtyFlag = false;
    private boolean syncdirDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="agentparam")
    private String agentparam;
    @Column(name="agenttype")
    private String agenttype;
    @Column(name="clientid")
    private String clientid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datasyncagentid")
    private String datasyncagentid;
    @Column(name="datasyncagentname")
    private String datasyncagentname;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="pwd")
    private String pwd;
    @Column(name="serverpath")
    private String serverpath;
    @Column(name="servicename")
    private String servicename;
    @Column(name="syncdir")
    private String syncdir;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="username")
    private String username;

    static {
        fieldIndexMap.put(FIELD_AGENTPARAM, 0);
        fieldIndexMap.put(FIELD_AGENTTYPE, 1);
        fieldIndexMap.put(FIELD_CLIENTID, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DATASYNCAGENTID, 5);
        fieldIndexMap.put(FIELD_DATASYNCAGENTNAME, 6);
        fieldIndexMap.put(FIELD_ENABLE, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PWD, 9);
        fieldIndexMap.put(FIELD_SERVERPATH, 10);
        fieldIndexMap.put(FIELD_SERVICENAME, 11);
        fieldIndexMap.put(FIELD_SYNCDIR, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERNAME, 15);
    }

    public void setAgentParam(String agentparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentParam(agentparam);
            return;
        }
        if (agentparam != null && (agentparam = StringHelper.trimRight(agentparam)).length() == 0) {
            agentparam = null;
        }
        this.agentparam = agentparam;
        this.agentparamDirtyFlag = true;
    }

    public String getAgentParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentParam();
        }
        return this.agentparam;
    }

    public boolean isAgentParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentParamDirty();
        }
        return this.agentparamDirtyFlag;
    }

    public void resetAgentParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentParam();
            return;
        }
        this.agentparamDirtyFlag = false;
        this.agentparam = null;
    }

    public void setAgentType(String agenttype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentType(agenttype);
            return;
        }
        if (agenttype != null && (agenttype = StringHelper.trimRight(agenttype)).length() == 0) {
            agenttype = null;
        }
        this.agenttype = agenttype;
        this.agenttypeDirtyFlag = true;
    }

    public String getAgentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentType();
        }
        return this.agenttype;
    }

    public boolean isAgentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentTypeDirty();
        }
        return this.agenttypeDirtyFlag;
    }

    public void resetAgentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentType();
            return;
        }
        this.agenttypeDirtyFlag = false;
        this.agenttype = null;
    }

    public void setClientId(String clientid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClientId(clientid);
            return;
        }
        if (clientid != null && (clientid = StringHelper.trimRight(clientid)).length() == 0) {
            clientid = null;
        }
        this.clientid = clientid;
        this.clientidDirtyFlag = true;
    }

    public String getClientId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClientId();
        }
        return this.clientid;
    }

    public boolean isClientIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClientIdDirty();
        }
        return this.clientidDirtyFlag;
    }

    public void resetClientId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClientId();
            return;
        }
        this.clientidDirtyFlag = false;
        this.clientid = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setDataSyncAgentId(String datasyncagentid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSyncAgentId(datasyncagentid);
            return;
        }
        if (datasyncagentid != null && (datasyncagentid = StringHelper.trimRight(datasyncagentid)).length() == 0) {
            datasyncagentid = null;
        }
        this.datasyncagentid = datasyncagentid;
        this.datasyncagentidDirtyFlag = true;
    }

    public String getDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSyncAgentId();
        }
        return this.datasyncagentid;
    }

    public boolean isDataSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSyncAgentIdDirty();
        }
        return this.datasyncagentidDirtyFlag;
    }

    public void resetDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSyncAgentId();
            return;
        }
        this.datasyncagentidDirtyFlag = false;
        this.datasyncagentid = null;
    }

    public void setDataSyncAgentName(String datasyncagentname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSyncAgentName(datasyncagentname);
            return;
        }
        if (datasyncagentname != null && (datasyncagentname = StringHelper.trimRight(datasyncagentname)).length() == 0) {
            datasyncagentname = null;
        }
        this.datasyncagentname = datasyncagentname;
        this.datasyncagentnameDirtyFlag = true;
    }

    public String getDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSyncAgentName();
        }
        return this.datasyncagentname;
    }

    public boolean isDataSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSyncAgentNameDirty();
        }
        return this.datasyncagentnameDirtyFlag;
    }

    public void resetDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSyncAgentName();
            return;
        }
        this.datasyncagentnameDirtyFlag = false;
        this.datasyncagentname = null;
    }

    public void setEnable(Integer enable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setPwd(String pwd) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPwd(pwd);
            return;
        }
        if (pwd != null && (pwd = StringHelper.trimRight(pwd)).length() == 0) {
            pwd = null;
        }
        this.pwd = pwd;
        this.pwdDirtyFlag = true;
    }

    public String getPwd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPwd();
        }
        return this.pwd;
    }

    public boolean isPwdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPwdDirty();
        }
        return this.pwdDirtyFlag;
    }

    public void resetPwd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPwd();
            return;
        }
        this.pwdDirtyFlag = false;
        this.pwd = null;
    }

    public void setServerPath(String serverpath) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerPath(serverpath);
            return;
        }
        if (serverpath != null && (serverpath = StringHelper.trimRight(serverpath)).length() == 0) {
            serverpath = null;
        }
        this.serverpath = serverpath;
        this.serverpathDirtyFlag = true;
    }

    public String getServerPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerPath();
        }
        return this.serverpath;
    }

    public boolean isServerPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerPathDirty();
        }
        return this.serverpathDirtyFlag;
    }

    public void resetServerPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerPath();
            return;
        }
        this.serverpathDirtyFlag = false;
        this.serverpath = null;
    }

    public void setServiceName(String servicename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceName(servicename);
            return;
        }
        if (servicename != null && (servicename = StringHelper.trimRight(servicename)).length() == 0) {
            servicename = null;
        }
        this.servicename = servicename;
        this.servicenameDirtyFlag = true;
    }

    public String getServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceName();
        }
        return this.servicename;
    }

    public boolean isServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceNameDirty();
        }
        return this.servicenameDirtyFlag;
    }

    public void resetServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceName();
            return;
        }
        this.servicenameDirtyFlag = false;
        this.servicename = null;
    }

    public void setSyncDir(String syncdir) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncDir(syncdir);
            return;
        }
        if (syncdir != null && (syncdir = StringHelper.trimRight(syncdir)).length() == 0) {
            syncdir = null;
        }
        this.syncdir = syncdir;
        this.syncdirDirtyFlag = true;
    }

    public String getSyncDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncDir();
        }
        return this.syncdir;
    }

    public boolean isSyncDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncDirDirty();
        }
        return this.syncdirDirtyFlag;
    }

    public void resetSyncDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncDir();
            return;
        }
        this.syncdirDirtyFlag = false;
        this.syncdir = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUserName(String username) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(username);
            return;
        }
        if (username != null && (username = StringHelper.trimRight(username)).length() == 0) {
            username = null;
        }
        this.username = username;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
    }

    @Override
    protected void onReset() {
        DataSyncAgentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DataSyncAgentBase et) {
        et.resetAgentParam();
        et.resetAgentType();
        et.resetClientId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataSyncAgentId();
        et.resetDataSyncAgentName();
        et.resetEnable();
        et.resetMemo();
        et.resetPwd();
        et.resetServerPath();
        et.resetServiceName();
        et.resetSyncDir();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAgentParamDirty()) {
            params.put(FIELD_AGENTPARAM, this.getAgentParam());
        }
        if (!bDirtyOnly || this.isAgentTypeDirty()) {
            params.put(FIELD_AGENTTYPE, this.getAgentType());
        }
        if (!bDirtyOnly || this.isClientIdDirty()) {
            params.put(FIELD_CLIENTID, this.getClientId());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDataSyncAgentIdDirty()) {
            params.put(FIELD_DATASYNCAGENTID, this.getDataSyncAgentId());
        }
        if (!bDirtyOnly || this.isDataSyncAgentNameDirty()) {
            params.put(FIELD_DATASYNCAGENTNAME, this.getDataSyncAgentName());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isPwdDirty()) {
            params.put(FIELD_PWD, this.getPwd());
        }
        if (!bDirtyOnly || this.isServerPathDirty()) {
            params.put(FIELD_SERVERPATH, this.getServerPath());
        }
        if (!bDirtyOnly || this.isServiceNameDirty()) {
            params.put(FIELD_SERVICENAME, this.getServiceName());
        }
        if (!bDirtyOnly || this.isSyncDirDirty()) {
            params.put(FIELD_SYNCDIR, this.getSyncDir());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserNameDirty()) {
            params.put(FIELD_USERNAME, this.getUserName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return DataSyncAgentBase.get(this, index);
    }

    private static Object get(DataSyncAgentBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAgentParam();
            }
            case 1: {
                return et.getAgentType();
            }
            case 2: {
                return et.getClientId();
            }
            case 3: {
                return et.getCreateDate();
            }
            case 4: {
                return et.getCreateMan();
            }
            case 5: {
                return et.getDataSyncAgentId();
            }
            case 6: {
                return et.getDataSyncAgentName();
            }
            case 7: {
                return et.getEnable();
            }
            case 8: {
                return et.getMemo();
            }
            case 9: {
                return et.getPwd();
            }
            case 10: {
                return et.getServerPath();
            }
            case 11: {
                return et.getServiceName();
            }
            case 12: {
                return et.getSyncDir();
            }
            case 13: {
                return et.getUpdateDate();
            }
            case 14: {
                return et.getUpdateMan();
            }
            case 15: {
                return et.getUserName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        DataSyncAgentBase.set(this, index, objValue);
    }

    private static void set(DataSyncAgentBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAgentParam(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setAgentType(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setClientId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDataSyncAgentId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setDataSyncAgentName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 8: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setPwd(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setServerPath(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setServiceName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setSyncDir(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 14: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return DataSyncAgentBase.isNull(this, index);
    }

    private static boolean isNull(DataSyncAgentBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAgentParam() == null;
            }
            case 1: {
                return et.getAgentType() == null;
            }
            case 2: {
                return et.getClientId() == null;
            }
            case 3: {
                return et.getCreateDate() == null;
            }
            case 4: {
                return et.getCreateMan() == null;
            }
            case 5: {
                return et.getDataSyncAgentId() == null;
            }
            case 6: {
                return et.getDataSyncAgentName() == null;
            }
            case 7: {
                return et.getEnable() == null;
            }
            case 8: {
                return et.getMemo() == null;
            }
            case 9: {
                return et.getPwd() == null;
            }
            case 10: {
                return et.getServerPath() == null;
            }
            case 11: {
                return et.getServiceName() == null;
            }
            case 12: {
                return et.getSyncDir() == null;
            }
            case 13: {
                return et.getUpdateDate() == null;
            }
            case 14: {
                return et.getUpdateMan() == null;
            }
            case 15: {
                return et.getUserName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return DataSyncAgentBase.contains(this, index);
    }

    private static boolean contains(DataSyncAgentBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAgentParamDirty();
            }
            case 1: {
                return et.isAgentTypeDirty();
            }
            case 2: {
                return et.isClientIdDirty();
            }
            case 3: {
                return et.isCreateDateDirty();
            }
            case 4: {
                return et.isCreateManDirty();
            }
            case 5: {
                return et.isDataSyncAgentIdDirty();
            }
            case 6: {
                return et.isDataSyncAgentNameDirty();
            }
            case 7: {
                return et.isEnableDirty();
            }
            case 8: {
                return et.isMemoDirty();
            }
            case 9: {
                return et.isPwdDirty();
            }
            case 10: {
                return et.isServerPathDirty();
            }
            case 11: {
                return et.isServiceNameDirty();
            }
            case 12: {
                return et.isSyncDirDirty();
            }
            case 13: {
                return et.isUpdateDateDirty();
            }
            case 14: {
                return et.isUpdateManDirty();
            }
            case 15: {
                return et.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DataSyncAgentBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DataSyncAgentBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAgentParam() != null) {
            JSONObjectHelper.put(json, "agentparam", DataSyncAgentBase.getJSONValue(et.getAgentParam()), false);
        }
        if (bIncEmpty || et.getAgentType() != null) {
            JSONObjectHelper.put(json, "agenttype", DataSyncAgentBase.getJSONValue(et.getAgentType()), false);
        }
        if (bIncEmpty || et.getClientId() != null) {
            JSONObjectHelper.put(json, "clientid", DataSyncAgentBase.getJSONValue(et.getClientId()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DataSyncAgentBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DataSyncAgentBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDataSyncAgentId() != null) {
            JSONObjectHelper.put(json, "datasyncagentid", DataSyncAgentBase.getJSONValue(et.getDataSyncAgentId()), false);
        }
        if (bIncEmpty || et.getDataSyncAgentName() != null) {
            JSONObjectHelper.put(json, "datasyncagentname", DataSyncAgentBase.getJSONValue(et.getDataSyncAgentName()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", DataSyncAgentBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", DataSyncAgentBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getPwd() != null) {
            JSONObjectHelper.put(json, "pwd", DataSyncAgentBase.getJSONValue(et.getPwd()), false);
        }
        if (bIncEmpty || et.getServerPath() != null) {
            JSONObjectHelper.put(json, "serverpath", DataSyncAgentBase.getJSONValue(et.getServerPath()), false);
        }
        if (bIncEmpty || et.getServiceName() != null) {
            JSONObjectHelper.put(json, "servicename", DataSyncAgentBase.getJSONValue(et.getServiceName()), false);
        }
        if (bIncEmpty || et.getSyncDir() != null) {
            JSONObjectHelper.put(json, "syncdir", DataSyncAgentBase.getJSONValue(et.getSyncDir()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DataSyncAgentBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DataSyncAgentBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserName() != null) {
            JSONObjectHelper.put(json, "username", DataSyncAgentBase.getJSONValue(et.getUserName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DataSyncAgentBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DataSyncAgentBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAgentParam() != null) {
            obj = et.getAgentParam();
            node.setAttribute(FIELD_AGENTPARAM, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getAgentType() != null) {
            obj = et.getAgentType();
            node.setAttribute(FIELD_AGENTTYPE, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getClientId() != null) {
            obj = et.getClientId();
            node.setAttribute(FIELD_CLIENTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataSyncAgentId() != null) {
            obj = et.getDataSyncAgentId();
            node.setAttribute(FIELD_DATASYNCAGENTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataSyncAgentName() != null) {
            obj = et.getDataSyncAgentName();
            node.setAttribute(FIELD_DATASYNCAGENTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPwd() != null) {
            obj = et.getPwd();
            node.setAttribute(FIELD_PWD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getServerPath() != null) {
            obj = et.getServerPath();
            node.setAttribute(FIELD_SERVERPATH, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getServiceName() != null) {
            obj = et.getServiceName();
            node.setAttribute(FIELD_SERVICENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSyncDir() != null) {
            obj = et.getSyncDir();
            node.setAttribute(FIELD_SYNCDIR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserName() != null) {
            obj = et.getUserName();
            node.setAttribute(FIELD_USERNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DataSyncAgentBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DataSyncAgentBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAgentParamDirty() && (bIncEmpty || et.getAgentParam() != null)) {
            dst.set(FIELD_AGENTPARAM, et.getAgentParam());
        }
        if (et.isAgentTypeDirty() && (bIncEmpty || et.getAgentType() != null)) {
            dst.set(FIELD_AGENTTYPE, et.getAgentType());
        }
        if (et.isClientIdDirty() && (bIncEmpty || et.getClientId() != null)) {
            dst.set(FIELD_CLIENTID, et.getClientId());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDataSyncAgentIdDirty() && (bIncEmpty || et.getDataSyncAgentId() != null)) {
            dst.set(FIELD_DATASYNCAGENTID, et.getDataSyncAgentId());
        }
        if (et.isDataSyncAgentNameDirty() && (bIncEmpty || et.getDataSyncAgentName() != null)) {
            dst.set(FIELD_DATASYNCAGENTNAME, et.getDataSyncAgentName());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isPwdDirty() && (bIncEmpty || et.getPwd() != null)) {
            dst.set(FIELD_PWD, et.getPwd());
        }
        if (et.isServerPathDirty() && (bIncEmpty || et.getServerPath() != null)) {
            dst.set(FIELD_SERVERPATH, et.getServerPath());
        }
        if (et.isServiceNameDirty() && (bIncEmpty || et.getServiceName() != null)) {
            dst.set(FIELD_SERVICENAME, et.getServiceName());
        }
        if (et.isSyncDirDirty() && (bIncEmpty || et.getSyncDir() != null)) {
            dst.set(FIELD_SYNCDIR, et.getSyncDir());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserNameDirty() && (bIncEmpty || et.getUserName() != null)) {
            dst.set(FIELD_USERNAME, et.getUserName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return DataSyncAgentBase.remove(this, index);
    }

    private static boolean remove(DataSyncAgentBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAgentParam();
                return true;
            }
            case 1: {
                et.resetAgentType();
                return true;
            }
            case 2: {
                et.resetClientId();
                return true;
            }
            case 3: {
                et.resetCreateDate();
                return true;
            }
            case 4: {
                et.resetCreateMan();
                return true;
            }
            case 5: {
                et.resetDataSyncAgentId();
                return true;
            }
            case 6: {
                et.resetDataSyncAgentName();
                return true;
            }
            case 7: {
                et.resetEnable();
                return true;
            }
            case 8: {
                et.resetMemo();
                return true;
            }
            case 9: {
                et.resetPwd();
                return true;
            }
            case 10: {
                et.resetServerPath();
                return true;
            }
            case 11: {
                et.resetServiceName();
                return true;
            }
            case 12: {
                et.resetSyncDir();
                return true;
            }
            case 13: {
                et.resetUpdateDate();
                return true;
            }
            case 14: {
                et.resetUpdateMan();
                return true;
            }
            case 15: {
                et.resetUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private DataSyncAgentBase getProxyEntity() {
        return this.proxyDataSyncAgentBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataSyncAgentBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DataSyncAgentBase) {
            this.proxyDataSyncAgentBase = (DataSyncAgentBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataSyncAgentService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

