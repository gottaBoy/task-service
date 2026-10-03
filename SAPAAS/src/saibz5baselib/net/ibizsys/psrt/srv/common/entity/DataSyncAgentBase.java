/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[DataSyncAgent] 数据对象基类
 */
public abstract class DataSyncAgentBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataSyncAgentBase.class);
    /**
     * 属性[代理参数]
     */
    public final static String FIELD_AGENTPARAM = "AGENTPARAM";
    /**
     * 属性[代理类型]
     */
    public final static String FIELD_AGENTTYPE = "AGENTTYPE";
    /**
     * 属性[客户端标识]
     */
    public final static String FIELD_CLIENTID = "CLIENTID";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[数据同步代理标识]
     */
    public final static String FIELD_DATASYNCAGENTID = "DATASYNCAGENTID";
    /**
     * 属性[数据同步代理名称]
     */
    public final static String FIELD_DATASYNCAGENTNAME = "DATASYNCAGENTNAME";
    /**
     * 属性[逻辑有效标志]
     */
    public final static String FIELD_ENABLE = "ENABLE";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[访问密码]
     */
    public final static String FIELD_PWD = "PWD";
    /**
     * 属性[远端地址]
     */
    public final static String FIELD_SERVERPATH = "SERVERPATH";
    /**
     * 属性[服务名称]
     */
    public final static String FIELD_SERVICENAME = "SERVICENAME";
    /**
     * 属性[数据同步方向]
     */
    public final static String FIELD_SYNCDIR = "SYNCDIR";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[访问用户]
     */
    public final static String FIELD_USERNAME = "USERNAME";

    private final static int INDEX_AGENTPARAM = 0;
    private final static int INDEX_AGENTTYPE = 1;
    private final static int INDEX_CLIENTID = 2;
    private final static int INDEX_CREATEDATE = 3;
    private final static int INDEX_CREATEMAN = 4;
    private final static int INDEX_DATASYNCAGENTID = 5;
    private final static int INDEX_DATASYNCAGENTNAME = 6;
    private final static int INDEX_ENABLE = 7;
    private final static int INDEX_MEMO = 8;
    private final static int INDEX_PWD = 9;
    private final static int INDEX_SERVERPATH = 10;
    private final static int INDEX_SERVICENAME = 11;
    private final static int INDEX_SYNCDIR = 12;
    private final static int INDEX_UPDATEDATE = 13;
    private final static int INDEX_UPDATEMAN = 14;
    private final static int INDEX_USERNAME = 15;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_AGENTPARAM, INDEX_AGENTPARAM);
        fieldIndexMap.put( FIELD_AGENTTYPE, INDEX_AGENTTYPE);
        fieldIndexMap.put( FIELD_CLIENTID, INDEX_CLIENTID);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DATASYNCAGENTID, INDEX_DATASYNCAGENTID);
        fieldIndexMap.put( FIELD_DATASYNCAGENTNAME, INDEX_DATASYNCAGENTNAME);
        fieldIndexMap.put( FIELD_ENABLE, INDEX_ENABLE);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_PWD, INDEX_PWD);
        fieldIndexMap.put( FIELD_SERVERPATH, INDEX_SERVERPATH);
        fieldIndexMap.put( FIELD_SERVICENAME, INDEX_SERVICENAME);
        fieldIndexMap.put( FIELD_SYNCDIR, INDEX_SYNCDIR);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERNAME, INDEX_USERNAME);
    }

    private DataSyncAgentBase proxyDataSyncAgentBase = null;
    public DataSyncAgentBase() {
        super();
    }
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


    /**
     *  设置属性值[代理参数]
     *  @param agentparam
     */
    public void setAgentParam(String agentparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAgentParam(agentparam);
            return;
        }
        if(agentparam!=null) {
            agentparam = StringHelper.trimRight(agentparam);
            if(agentparam.length()==0) {
                agentparam = null;
            }
        }
        this.agentparam = agentparam;
        this.agentparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[代理参数]
     */
    public String getAgentParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAgentParam();
        }
        return this.agentparam;
    }

    /**
     *  获取属性值[代理参数]是否修改
     */
    public boolean isAgentParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAgentParamDirty();
        }
        return this.agentparamDirtyFlag;
    }

    /**
     *  重置属性值[代理参数]
     */
    public void resetAgentParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAgentParam();
            return;
        }

        this.agentparamDirtyFlag = false;
        this.agentparam = null;
    }
    /**
     *  设置属性值[代理类型]代码表：net.ibizsys.psrt.srv.codelist.DataSyncAgentTypeCodeListModel
     *  @param agenttype
     */
    public void setAgentType(String agenttype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAgentType(agenttype);
            return;
        }
        if(agenttype!=null) {
            agenttype = StringHelper.trimRight(agenttype);
            if(agenttype.length()==0) {
                agenttype = null;
            }
        }
        this.agenttype = agenttype;
        this.agenttypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[代理类型]代码表：net.ibizsys.psrt.srv.codelist.DataSyncAgentTypeCodeListModel
     */
    public String getAgentType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAgentType();
        }
        return this.agenttype;
    }

    /**
     *  获取属性值[代理类型]是否修改
     */
    public boolean isAgentTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAgentTypeDirty();
        }
        return this.agenttypeDirtyFlag;
    }

    /**
     *  重置属性值[代理类型]
     */
    public void resetAgentType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAgentType();
            return;
        }

        this.agenttypeDirtyFlag = false;
        this.agenttype = null;
    }
    /**
     *  设置属性值[客户端标识]
     *  @param clientid
     */
    public void setClientId(String clientid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setClientId(clientid);
            return;
        }
        if(clientid!=null) {
            clientid = StringHelper.trimRight(clientid);
            if(clientid.length()==0) {
                clientid = null;
            }
        }
        this.clientid = clientid;
        this.clientidDirtyFlag  = true;
    }

    /**
     *  获取属性值[客户端标识]
     */
    public String getClientId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getClientId();
        }
        return this.clientid;
    }

    /**
     *  获取属性值[客户端标识]是否修改
     */
    public boolean isClientIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isClientIdDirty();
        }
        return this.clientidDirtyFlag;
    }

    /**
     *  重置属性值[客户端标识]
     */
    public void resetClientId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetClientId();
            return;
        }

        this.clientidDirtyFlag = false;
        this.clientid = null;
    }
    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[数据同步代理标识]
     *  @param datasyncagentid
     */
    public void setDataSyncAgentId(String datasyncagentid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataSyncAgentId(datasyncagentid);
            return;
        }
        if(datasyncagentid!=null) {
            datasyncagentid = StringHelper.trimRight(datasyncagentid);
            if(datasyncagentid.length()==0) {
                datasyncagentid = null;
            }
        }
        this.datasyncagentid = datasyncagentid;
        this.datasyncagentidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据同步代理标识]
     */
    public String getDataSyncAgentId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataSyncAgentId();
        }
        return this.datasyncagentid;
    }

    /**
     *  获取属性值[数据同步代理标识]是否修改
     */
    public boolean isDataSyncAgentIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataSyncAgentIdDirty();
        }
        return this.datasyncagentidDirtyFlag;
    }

    /**
     *  重置属性值[数据同步代理标识]
     */
    public void resetDataSyncAgentId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataSyncAgentId();
            return;
        }

        this.datasyncagentidDirtyFlag = false;
        this.datasyncagentid = null;
    }
    /**
     *  设置属性值[数据同步代理名称]
     *  @param datasyncagentname
     */
    public void setDataSyncAgentName(String datasyncagentname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataSyncAgentName(datasyncagentname);
            return;
        }
        if(datasyncagentname!=null) {
            datasyncagentname = StringHelper.trimRight(datasyncagentname);
            if(datasyncagentname.length()==0) {
                datasyncagentname = null;
            }
        }
        this.datasyncagentname = datasyncagentname;
        this.datasyncagentnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据同步代理名称]
     */
    public String getDataSyncAgentName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataSyncAgentName();
        }
        return this.datasyncagentname;
    }

    /**
     *  获取属性值[数据同步代理名称]是否修改
     */
    public boolean isDataSyncAgentNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataSyncAgentNameDirty();
        }
        return this.datasyncagentnameDirtyFlag;
    }

    /**
     *  重置属性值[数据同步代理名称]
     */
    public void resetDataSyncAgentName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataSyncAgentName();
            return;
        }

        this.datasyncagentnameDirtyFlag = false;
        this.datasyncagentname = null;
    }
    /**
     *  设置属性值[逻辑有效标志]
     *  @param enable
     */
    public void setEnable(Integer enable) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑有效标志]
     */
    public Integer getEnable() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    /**
     *  获取属性值[逻辑有效标志]是否修改
     */
    public boolean isEnableDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    /**
     *  重置属性值[逻辑有效标志]
     */
    public void resetEnable() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnable();
            return;
        }

        this.enableDirtyFlag = false;
        this.enable = null;
    }
    /**
     *  设置属性值[备注]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[访问密码]
     *  @param pwd
     */
    public void setPwd(String pwd) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPwd(pwd);
            return;
        }
        if(pwd!=null) {
            pwd = StringHelper.trimRight(pwd);
            if(pwd.length()==0) {
                pwd = null;
            }
        }
        this.pwd = pwd;
        this.pwdDirtyFlag  = true;
    }

    /**
     *  获取属性值[访问密码]
     */
    public String getPwd() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPwd();
        }
        return this.pwd;
    }

    /**
     *  获取属性值[访问密码]是否修改
     */
    public boolean isPwdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPwdDirty();
        }
        return this.pwdDirtyFlag;
    }

    /**
     *  重置属性值[访问密码]
     */
    public void resetPwd() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPwd();
            return;
        }

        this.pwdDirtyFlag = false;
        this.pwd = null;
    }
    /**
     *  设置属性值[远端地址]
     *  @param serverpath
     */
    public void setServerPath(String serverpath) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServerPath(serverpath);
            return;
        }
        if(serverpath!=null) {
            serverpath = StringHelper.trimRight(serverpath);
            if(serverpath.length()==0) {
                serverpath = null;
            }
        }
        this.serverpath = serverpath;
        this.serverpathDirtyFlag  = true;
    }

    /**
     *  获取属性值[远端地址]
     */
    public String getServerPath() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServerPath();
        }
        return this.serverpath;
    }

    /**
     *  获取属性值[远端地址]是否修改
     */
    public boolean isServerPathDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServerPathDirty();
        }
        return this.serverpathDirtyFlag;
    }

    /**
     *  重置属性值[远端地址]
     */
    public void resetServerPath() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServerPath();
            return;
        }

        this.serverpathDirtyFlag = false;
        this.serverpath = null;
    }
    /**
     *  设置属性值[服务名称]
     *  @param servicename
     */
    public void setServiceName(String servicename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServiceName(servicename);
            return;
        }
        if(servicename!=null) {
            servicename = StringHelper.trimRight(servicename);
            if(servicename.length()==0) {
                servicename = null;
            }
        }
        this.servicename = servicename;
        this.servicenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务名称]
     */
    public String getServiceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServiceName();
        }
        return this.servicename;
    }

    /**
     *  获取属性值[服务名称]是否修改
     */
    public boolean isServiceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServiceNameDirty();
        }
        return this.servicenameDirtyFlag;
    }

    /**
     *  重置属性值[服务名称]
     */
    public void resetServiceName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServiceName();
            return;
        }

        this.servicenameDirtyFlag = false;
        this.servicename = null;
    }
    /**
     *  设置属性值[数据同步方向]代码表：net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel
     *  @param syncdir
     */
    public void setSyncDir(String syncdir) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSyncDir(syncdir);
            return;
        }
        if(syncdir!=null) {
            syncdir = StringHelper.trimRight(syncdir);
            if(syncdir.length()==0) {
                syncdir = null;
            }
        }
        this.syncdir = syncdir;
        this.syncdirDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据同步方向]代码表：net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel
     */
    public String getSyncDir() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSyncDir();
        }
        return this.syncdir;
    }

    /**
     *  获取属性值[数据同步方向]是否修改
     */
    public boolean isSyncDirDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSyncDirDirty();
        }
        return this.syncdirDirtyFlag;
    }

    /**
     *  重置属性值[数据同步方向]
     */
    public void resetSyncDir() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSyncDir();
            return;
        }

        this.syncdirDirtyFlag = false;
        this.syncdir = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }
    /**
     *  设置属性值[访问用户]
     *  @param username
     */
    public void setUserName(String username) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserName(username);
            return;
        }
        if(username!=null) {
            username = StringHelper.trimRight(username);
            if(username.length()==0) {
                username = null;
            }
        }
        this.username = username;
        this.usernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[访问用户]
     */
    public String getUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    /**
     *  获取属性值[访问用户]是否修改
     */
    public boolean isUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    /**
     *  重置属性值[访问用户]
     */
    public void resetUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserName();
            return;
        }

        this.usernameDirtyFlag = false;
        this.username = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        DataSyncAgentBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isAgentParamDirty()) {
            params.put(FIELD_AGENTPARAM,getAgentParam());
        }
        if(!bDirtyOnly || isAgentTypeDirty()) {
            params.put(FIELD_AGENTTYPE,getAgentType());
        }
        if(!bDirtyOnly || isClientIdDirty()) {
            params.put(FIELD_CLIENTID,getClientId());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDataSyncAgentIdDirty()) {
            params.put(FIELD_DATASYNCAGENTID,getDataSyncAgentId());
        }
        if(!bDirtyOnly || isDataSyncAgentNameDirty()) {
            params.put(FIELD_DATASYNCAGENTNAME,getDataSyncAgentName());
        }
        if(!bDirtyOnly || isEnableDirty()) {
            params.put(FIELD_ENABLE,getEnable());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isPwdDirty()) {
            params.put(FIELD_PWD,getPwd());
        }
        if(!bDirtyOnly || isServerPathDirty()) {
            params.put(FIELD_SERVERPATH,getServerPath());
        }
        if(!bDirtyOnly || isServiceNameDirty()) {
            params.put(FIELD_SERVICENAME,getServiceName());
        }
        if(!bDirtyOnly || isSyncDirDirty()) {
            params.put(FIELD_SYNCDIR,getSyncDir());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserNameDirty()) {
            params.put(FIELD_USERNAME,getUserName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  DataSyncAgentBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DataSyncAgentBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AGENTPARAM:
            return et.getAgentParam();
        case INDEX_AGENTTYPE:
            return et.getAgentType();
        case INDEX_CLIENTID:
            return et.getClientId();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DATASYNCAGENTID:
            return et.getDataSyncAgentId();
        case INDEX_DATASYNCAGENTNAME:
            return et.getDataSyncAgentName();
        case INDEX_ENABLE:
            return et.getEnable();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_PWD:
            return et.getPwd();
        case INDEX_SERVERPATH:
            return et.getServerPath();
        case INDEX_SERVICENAME:
            return et.getServiceName();
        case INDEX_SYNCDIR:
            return et.getSyncDir();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERNAME:
            return et.getUserName();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        DataSyncAgentBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DataSyncAgentBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_AGENTPARAM:
            et.setAgentParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_AGENTTYPE:
            et.setAgentType(DataObject.getStringValue(obj));
            return ;
        case INDEX_CLIENTID:
            et.setClientId(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATASYNCAGENTID:
            et.setDataSyncAgentId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATASYNCAGENTNAME:
            et.setDataSyncAgentName(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENABLE:
            et.setEnable(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_PWD:
            et.setPwd(DataObject.getStringValue(obj));
            return ;
        case INDEX_SERVERPATH:
            et.setServerPath(DataObject.getStringValue(obj));
            return ;
        case INDEX_SERVICENAME:
            et.setServiceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYNCDIR:
            et.setSyncDir(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERNAME:
            et.setUserName(DataObject.getStringValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  DataSyncAgentBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DataSyncAgentBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AGENTPARAM:
            return et.getAgentParam()==null;
        case INDEX_AGENTTYPE:
            return et.getAgentType()==null;
        case INDEX_CLIENTID:
            return et.getClientId()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DATASYNCAGENTID:
            return et.getDataSyncAgentId()==null;
        case INDEX_DATASYNCAGENTNAME:
            return et.getDataSyncAgentName()==null;
        case INDEX_ENABLE:
            return et.getEnable()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_PWD:
            return et.getPwd()==null;
        case INDEX_SERVERPATH:
            return et.getServerPath()==null;
        case INDEX_SERVICENAME:
            return et.getServiceName()==null;
        case INDEX_SYNCDIR:
            return et.getSyncDir()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERNAME:
            return et.getUserName()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  DataSyncAgentBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DataSyncAgentBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AGENTPARAM:
            return et.isAgentParamDirty();
        case INDEX_AGENTTYPE:
            return et.isAgentTypeDirty();
        case INDEX_CLIENTID:
            return et.isClientIdDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DATASYNCAGENTID:
            return et.isDataSyncAgentIdDirty();
        case INDEX_DATASYNCAGENTNAME:
            return et.isDataSyncAgentNameDirty();
        case INDEX_ENABLE:
            return et.isEnableDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_PWD:
            return et.isPwdDirty();
        case INDEX_SERVERPATH:
            return et.isServerPathDirty();
        case INDEX_SERVICENAME:
            return et.isServiceNameDirty();
        case INDEX_SYNCDIR:
            return et.isSyncDirDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERNAME:
            return et.isUserNameDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(DataSyncAgentBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAgentParam()!=null) {
            JSONObjectHelper.put(json,"agentparam",getJSONValue(et.getAgentParam()),false);
        }
        if(bIncEmpty||et.getAgentType()!=null) {
            JSONObjectHelper.put(json,"agenttype",getJSONValue(et.getAgentType()),false);
        }
        if(bIncEmpty||et.getClientId()!=null) {
            JSONObjectHelper.put(json,"clientid",getJSONValue(et.getClientId()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDataSyncAgentId()!=null) {
            JSONObjectHelper.put(json,"datasyncagentid",getJSONValue(et.getDataSyncAgentId()),false);
        }
        if(bIncEmpty||et.getDataSyncAgentName()!=null) {
            JSONObjectHelper.put(json,"datasyncagentname",getJSONValue(et.getDataSyncAgentName()),false);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            JSONObjectHelper.put(json,"enable",getJSONValue(et.getEnable()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getPwd()!=null) {
            JSONObjectHelper.put(json,"pwd",getJSONValue(et.getPwd()),false);
        }
        if(bIncEmpty||et.getServerPath()!=null) {
            JSONObjectHelper.put(json,"serverpath",getJSONValue(et.getServerPath()),false);
        }
        if(bIncEmpty||et.getServiceName()!=null) {
            JSONObjectHelper.put(json,"servicename",getJSONValue(et.getServiceName()),false);
        }
        if(bIncEmpty||et.getSyncDir()!=null) {
            JSONObjectHelper.put(json,"syncdir",getJSONValue(et.getSyncDir()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserName()!=null) {
            JSONObjectHelper.put(json,"username",getJSONValue(et.getUserName()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(DataSyncAgentBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAgentParam()!=null) {
            Object obj = et.getAgentParam();
            node.setAttribute("AGENTPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAgentType()!=null) {
            Object obj = et.getAgentType();
            node.setAttribute("AGENTTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getClientId()!=null) {
            Object obj = et.getClientId();
            node.setAttribute("CLIENTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataSyncAgentId()!=null) {
            Object obj = et.getDataSyncAgentId();
            node.setAttribute("DATASYNCAGENTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataSyncAgentName()!=null) {
            Object obj = et.getDataSyncAgentName();
            node.setAttribute("DATASYNCAGENTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            Object obj = et.getEnable();
            node.setAttribute("ENABLE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPwd()!=null) {
            Object obj = et.getPwd();
            node.setAttribute("PWD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getServerPath()!=null) {
            Object obj = et.getServerPath();
            node.setAttribute("SERVERPATH",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getServiceName()!=null) {
            Object obj = et.getServiceName();
            node.setAttribute("SERVICENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSyncDir()!=null) {
            Object obj = et.getSyncDir();
            node.setAttribute("SYNCDIR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserName()!=null) {
            Object obj = et.getUserName();
            node.setAttribute("USERNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DataSyncAgentBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DataSyncAgentBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isAgentParamDirty() && (bIncEmpty||et.getAgentParam()!=null)) {
            dst.set(FIELD_AGENTPARAM,et.getAgentParam());
        }
        if(et.isAgentTypeDirty() && (bIncEmpty||et.getAgentType()!=null)) {
            dst.set(FIELD_AGENTTYPE,et.getAgentType());
        }
        if(et.isClientIdDirty() && (bIncEmpty||et.getClientId()!=null)) {
            dst.set(FIELD_CLIENTID,et.getClientId());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDataSyncAgentIdDirty() && (bIncEmpty||et.getDataSyncAgentId()!=null)) {
            dst.set(FIELD_DATASYNCAGENTID,et.getDataSyncAgentId());
        }
        if(et.isDataSyncAgentNameDirty() && (bIncEmpty||et.getDataSyncAgentName()!=null)) {
            dst.set(FIELD_DATASYNCAGENTNAME,et.getDataSyncAgentName());
        }
        if(et.isEnableDirty() && (bIncEmpty||et.getEnable()!=null)) {
            dst.set(FIELD_ENABLE,et.getEnable());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isPwdDirty() && (bIncEmpty||et.getPwd()!=null)) {
            dst.set(FIELD_PWD,et.getPwd());
        }
        if(et.isServerPathDirty() && (bIncEmpty||et.getServerPath()!=null)) {
            dst.set(FIELD_SERVERPATH,et.getServerPath());
        }
        if(et.isServiceNameDirty() && (bIncEmpty||et.getServiceName()!=null)) {
            dst.set(FIELD_SERVICENAME,et.getServiceName());
        }
        if(et.isSyncDirDirty() && (bIncEmpty||et.getSyncDir()!=null)) {
            dst.set(FIELD_SYNCDIR,et.getSyncDir());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserNameDirty() && (bIncEmpty||et.getUserName()!=null)) {
            dst.set(FIELD_USERNAME,et.getUserName());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  DataSyncAgentBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DataSyncAgentBase et,int index) throws Exception {
        switch(index) {
        case INDEX_AGENTPARAM:
            et.resetAgentParam();
            return true;
        case INDEX_AGENTTYPE:
            et.resetAgentType();
            return true;
        case INDEX_CLIENTID:
            et.resetClientId();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DATASYNCAGENTID:
            et.resetDataSyncAgentId();
            return true;
        case INDEX_DATASYNCAGENTNAME:
            et.resetDataSyncAgentName();
            return true;
        case INDEX_ENABLE:
            et.resetEnable();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_PWD:
            et.resetPwd();
            return true;
        case INDEX_SERVERPATH:
            et.resetServerPath();
            return true;
        case INDEX_SERVICENAME:
            et.resetServiceName();
            return true;
        case INDEX_SYNCDIR:
            et.resetSyncDir();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERNAME:
            et.resetUserName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private DataSyncAgentBase getProxyEntity() {
        return this.proxyDataSyncAgentBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataSyncAgentBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DataSyncAgentBase) {
            this.proxyDataSyncAgentBase = (DataSyncAgentBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataSyncAgentService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}