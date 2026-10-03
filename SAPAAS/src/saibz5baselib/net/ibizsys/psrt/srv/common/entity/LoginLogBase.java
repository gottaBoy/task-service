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
 * 实体[LoginLog] 数据对象基类
 */
public abstract class LoginLogBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(LoginLogBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[IP地址]
     */
    public final static String FIELD_IPADDRESS = "IPADDRESS";
    /**
     * 属性[登录帐户]
     */
    public final static String FIELD_LOGINACCOUNTID = "LOGINACCOUNTID";
    /**
     * 属性[登录帐户]
     */
    public final static String FIELD_LOGINACCOUNTNAME = "LOGINACCOUNTNAME";
    /**
     * 属性[帐户使用记录标识]
     */
    public final static String FIELD_LOGINLOGID = "LOGINLOGID";
    /**
     * 属性[帐户使用记录名称]
     */
    public final static String FIELD_LOGINLOGNAME = "LOGINLOGNAME";
    /**
     * 属性[登录时间]
     */
    public final static String FIELD_LOGINTIME = "LOGINTIME";
    /**
     * 属性[注销时间]
     */
    public final static String FIELD_LOGOUTTIME = "LOGOUTTIME";
    /**
     * 属性[服务器地址]
     */
    public final static String FIELD_SERVERADDR = "SERVERADDR";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[客户端标识]
     */
    public final static String FIELD_USERAGENT = "USERAGENT";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_IPADDRESS = 2;
    private final static int INDEX_LOGINACCOUNTID = 3;
    private final static int INDEX_LOGINACCOUNTNAME = 4;
    private final static int INDEX_LOGINLOGID = 5;
    private final static int INDEX_LOGINLOGNAME = 6;
    private final static int INDEX_LOGINTIME = 7;
    private final static int INDEX_LOGOUTTIME = 8;
    private final static int INDEX_SERVERADDR = 9;
    private final static int INDEX_UPDATEDATE = 10;
    private final static int INDEX_UPDATEMAN = 11;
    private final static int INDEX_USERAGENT = 12;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_IPADDRESS, INDEX_IPADDRESS);
        fieldIndexMap.put( FIELD_LOGINACCOUNTID, INDEX_LOGINACCOUNTID);
        fieldIndexMap.put( FIELD_LOGINACCOUNTNAME, INDEX_LOGINACCOUNTNAME);
        fieldIndexMap.put( FIELD_LOGINLOGID, INDEX_LOGINLOGID);
        fieldIndexMap.put( FIELD_LOGINLOGNAME, INDEX_LOGINLOGNAME);
        fieldIndexMap.put( FIELD_LOGINTIME, INDEX_LOGINTIME);
        fieldIndexMap.put( FIELD_LOGOUTTIME, INDEX_LOGOUTTIME);
        fieldIndexMap.put( FIELD_SERVERADDR, INDEX_SERVERADDR);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERAGENT, INDEX_USERAGENT);
    }

    private LoginLogBase proxyLoginLogBase = null;
    public LoginLogBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ipaddressDirtyFlag = false;
    private boolean loginaccountidDirtyFlag = false;
    private boolean loginaccountnameDirtyFlag = false;
    private boolean loginlogidDirtyFlag = false;
    private boolean loginlognameDirtyFlag = false;
    private boolean logintimeDirtyFlag = false;
    private boolean logouttimeDirtyFlag = false;
    private boolean serveraddrDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean useragentDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ipaddress")
    private String ipaddress;
    @Column(name="loginaccountid")
    private String loginaccountid;
    @Column(name="loginaccountname")
    private String loginaccountname;
    @Column(name="loginlogid")
    private String loginlogid;
    @Column(name="loginlogname")
    private String loginlogname;
    @Column(name="logintime")
    private Timestamp logintime;
    @Column(name="logouttime")
    private Timestamp logouttime;
    @Column(name="serveraddr")
    private String serveraddr;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="useragent")
    private String useragent;


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
     *  设置属性值[IP地址]
     *  @param ipaddress
     */
    public void setIpAddress(String ipaddress) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIpAddress(ipaddress);
            return;
        }
        if(ipaddress!=null) {
            ipaddress = StringHelper.trimRight(ipaddress);
            if(ipaddress.length()==0) {
                ipaddress = null;
            }
        }
        this.ipaddress = ipaddress;
        this.ipaddressDirtyFlag  = true;
    }

    /**
     *  获取属性值[IP地址]
     */
    public String getIpAddress() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIpAddress();
        }
        return this.ipaddress;
    }

    /**
     *  获取属性值[IP地址]是否修改
     */
    public boolean isIpAddressDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIpAddressDirty();
        }
        return this.ipaddressDirtyFlag;
    }

    /**
     *  重置属性值[IP地址]
     */
    public void resetIpAddress() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIpAddress();
            return;
        }

        this.ipaddressDirtyFlag = false;
        this.ipaddress = null;
    }
    /**
     *  设置属性值[登录帐户]
     *  @param loginaccountid
     */
    public void setLoginAccountId(String loginaccountid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLoginAccountId(loginaccountid);
            return;
        }
        if(loginaccountid!=null) {
            loginaccountid = StringHelper.trimRight(loginaccountid);
            if(loginaccountid.length()==0) {
                loginaccountid = null;
            }
        }
        this.loginaccountid = loginaccountid;
        this.loginaccountidDirtyFlag  = true;
    }

    /**
     *  获取属性值[登录帐户]
     */
    public String getLoginAccountId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginAccountId();
        }
        return this.loginaccountid;
    }

    /**
     *  获取属性值[登录帐户]是否修改
     */
    public boolean isLoginAccountIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginAccountIdDirty();
        }
        return this.loginaccountidDirtyFlag;
    }

    /**
     *  重置属性值[登录帐户]
     */
    public void resetLoginAccountId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLoginAccountId();
            return;
        }

        this.loginaccountidDirtyFlag = false;
        this.loginaccountid = null;
    }
    /**
     *  设置属性值[登录帐户]
     *  @param loginaccountname
     */
    public void setLoginAccountName(String loginaccountname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLoginAccountName(loginaccountname);
            return;
        }
        if(loginaccountname!=null) {
            loginaccountname = StringHelper.trimRight(loginaccountname);
            if(loginaccountname.length()==0) {
                loginaccountname = null;
            }
        }
        this.loginaccountname = loginaccountname;
        this.loginaccountnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[登录帐户]
     */
    public String getLoginAccountName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginAccountName();
        }
        return this.loginaccountname;
    }

    /**
     *  获取属性值[登录帐户]是否修改
     */
    public boolean isLoginAccountNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginAccountNameDirty();
        }
        return this.loginaccountnameDirtyFlag;
    }

    /**
     *  重置属性值[登录帐户]
     */
    public void resetLoginAccountName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLoginAccountName();
            return;
        }

        this.loginaccountnameDirtyFlag = false;
        this.loginaccountname = null;
    }
    /**
     *  设置属性值[帐户使用记录标识]
     *  @param loginlogid
     */
    public void setLoginLogId(String loginlogid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLoginLogId(loginlogid);
            return;
        }
        if(loginlogid!=null) {
            loginlogid = StringHelper.trimRight(loginlogid);
            if(loginlogid.length()==0) {
                loginlogid = null;
            }
        }
        this.loginlogid = loginlogid;
        this.loginlogidDirtyFlag  = true;
    }

    /**
     *  获取属性值[帐户使用记录标识]
     */
    public String getLoginLogId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginLogId();
        }
        return this.loginlogid;
    }

    /**
     *  获取属性值[帐户使用记录标识]是否修改
     */
    public boolean isLoginLogIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginLogIdDirty();
        }
        return this.loginlogidDirtyFlag;
    }

    /**
     *  重置属性值[帐户使用记录标识]
     */
    public void resetLoginLogId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLoginLogId();
            return;
        }

        this.loginlogidDirtyFlag = false;
        this.loginlogid = null;
    }
    /**
     *  设置属性值[帐户使用记录名称]
     *  @param loginlogname
     */
    public void setLoginLogName(String loginlogname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLoginLogName(loginlogname);
            return;
        }
        if(loginlogname!=null) {
            loginlogname = StringHelper.trimRight(loginlogname);
            if(loginlogname.length()==0) {
                loginlogname = null;
            }
        }
        this.loginlogname = loginlogname;
        this.loginlognameDirtyFlag  = true;
    }

    /**
     *  获取属性值[帐户使用记录名称]
     */
    public String getLoginLogName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginLogName();
        }
        return this.loginlogname;
    }

    /**
     *  获取属性值[帐户使用记录名称]是否修改
     */
    public boolean isLoginLogNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginLogNameDirty();
        }
        return this.loginlognameDirtyFlag;
    }

    /**
     *  重置属性值[帐户使用记录名称]
     */
    public void resetLoginLogName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLoginLogName();
            return;
        }

        this.loginlognameDirtyFlag = false;
        this.loginlogname = null;
    }
    /**
     *  设置属性值[登录时间]
     *  @param logintime
     */
    public void setLoginTime(Timestamp logintime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLoginTime(logintime);
            return;
        }
        this.logintime = logintime;
        this.logintimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[登录时间]
     */
    public Timestamp getLoginTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginTime();
        }
        return this.logintime;
    }

    /**
     *  获取属性值[登录时间]是否修改
     */
    public boolean isLoginTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginTimeDirty();
        }
        return this.logintimeDirtyFlag;
    }

    /**
     *  重置属性值[登录时间]
     */
    public void resetLoginTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLoginTime();
            return;
        }

        this.logintimeDirtyFlag = false;
        this.logintime = null;
    }
    /**
     *  设置属性值[注销时间]
     *  @param logouttime
     */
    public void setLogoutTime(Timestamp logouttime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLogoutTime(logouttime);
            return;
        }
        this.logouttime = logouttime;
        this.logouttimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[注销时间]
     */
    public Timestamp getLogoutTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLogoutTime();
        }
        return this.logouttime;
    }

    /**
     *  获取属性值[注销时间]是否修改
     */
    public boolean isLogoutTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLogoutTimeDirty();
        }
        return this.logouttimeDirtyFlag;
    }

    /**
     *  重置属性值[注销时间]
     */
    public void resetLogoutTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLogoutTime();
            return;
        }

        this.logouttimeDirtyFlag = false;
        this.logouttime = null;
    }
    /**
     *  设置属性值[服务器地址]
     *  @param serveraddr
     */
    public void setServerAddr(String serveraddr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServerAddr(serveraddr);
            return;
        }
        if(serveraddr!=null) {
            serveraddr = StringHelper.trimRight(serveraddr);
            if(serveraddr.length()==0) {
                serveraddr = null;
            }
        }
        this.serveraddr = serveraddr;
        this.serveraddrDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务器地址]
     */
    public String getServerAddr() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServerAddr();
        }
        return this.serveraddr;
    }

    /**
     *  获取属性值[服务器地址]是否修改
     */
    public boolean isServerAddrDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServerAddrDirty();
        }
        return this.serveraddrDirtyFlag;
    }

    /**
     *  重置属性值[服务器地址]
     */
    public void resetServerAddr() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServerAddr();
            return;
        }

        this.serveraddrDirtyFlag = false;
        this.serveraddr = null;
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
     *  设置属性值[客户端标识]
     *  @param useragent
     */
    public void setUserAgent(String useragent) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserAgent(useragent);
            return;
        }
        if(useragent!=null) {
            useragent = StringHelper.trimRight(useragent);
            if(useragent.length()==0) {
                useragent = null;
            }
        }
        this.useragent = useragent;
        this.useragentDirtyFlag  = true;
    }

    /**
     *  获取属性值[客户端标识]
     */
    public String getUserAgent() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserAgent();
        }
        return this.useragent;
    }

    /**
     *  获取属性值[客户端标识]是否修改
     */
    public boolean isUserAgentDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserAgentDirty();
        }
        return this.useragentDirtyFlag;
    }

    /**
     *  重置属性值[客户端标识]
     */
    public void resetUserAgent() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserAgent();
            return;
        }

        this.useragentDirtyFlag = false;
        this.useragent = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        LoginLogBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(LoginLogBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIpAddress();
        et.resetLoginAccountId();
        et.resetLoginAccountName();
        et.resetLoginLogId();
        et.resetLoginLogName();
        et.resetLoginTime();
        et.resetLogoutTime();
        et.resetServerAddr();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserAgent();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isIpAddressDirty()) {
            params.put(FIELD_IPADDRESS,getIpAddress());
        }
        if(!bDirtyOnly || isLoginAccountIdDirty()) {
            params.put(FIELD_LOGINACCOUNTID,getLoginAccountId());
        }
        if(!bDirtyOnly || isLoginAccountNameDirty()) {
            params.put(FIELD_LOGINACCOUNTNAME,getLoginAccountName());
        }
        if(!bDirtyOnly || isLoginLogIdDirty()) {
            params.put(FIELD_LOGINLOGID,getLoginLogId());
        }
        if(!bDirtyOnly || isLoginLogNameDirty()) {
            params.put(FIELD_LOGINLOGNAME,getLoginLogName());
        }
        if(!bDirtyOnly || isLoginTimeDirty()) {
            params.put(FIELD_LOGINTIME,getLoginTime());
        }
        if(!bDirtyOnly || isLogoutTimeDirty()) {
            params.put(FIELD_LOGOUTTIME,getLogoutTime());
        }
        if(!bDirtyOnly || isServerAddrDirty()) {
            params.put(FIELD_SERVERADDR,getServerAddr());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserAgentDirty()) {
            params.put(FIELD_USERAGENT,getUserAgent());
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

        return  LoginLogBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(LoginLogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_IPADDRESS:
            return et.getIpAddress();
        case INDEX_LOGINACCOUNTID:
            return et.getLoginAccountId();
        case INDEX_LOGINACCOUNTNAME:
            return et.getLoginAccountName();
        case INDEX_LOGINLOGID:
            return et.getLoginLogId();
        case INDEX_LOGINLOGNAME:
            return et.getLoginLogName();
        case INDEX_LOGINTIME:
            return et.getLoginTime();
        case INDEX_LOGOUTTIME:
            return et.getLogoutTime();
        case INDEX_SERVERADDR:
            return et.getServerAddr();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERAGENT:
            return et.getUserAgent();
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

        LoginLogBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(LoginLogBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_IPADDRESS:
            et.setIpAddress(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINACCOUNTID:
            et.setLoginAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINACCOUNTNAME:
            et.setLoginAccountName(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINLOGID:
            et.setLoginLogId(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINLOGNAME:
            et.setLoginLogName(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINTIME:
            et.setLoginTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_LOGOUTTIME:
            et.setLogoutTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_SERVERADDR:
            et.setServerAddr(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERAGENT:
            et.setUserAgent(DataObject.getStringValue(obj));
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

        return  LoginLogBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(LoginLogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_IPADDRESS:
            return et.getIpAddress()==null;
        case INDEX_LOGINACCOUNTID:
            return et.getLoginAccountId()==null;
        case INDEX_LOGINACCOUNTNAME:
            return et.getLoginAccountName()==null;
        case INDEX_LOGINLOGID:
            return et.getLoginLogId()==null;
        case INDEX_LOGINLOGNAME:
            return et.getLoginLogName()==null;
        case INDEX_LOGINTIME:
            return et.getLoginTime()==null;
        case INDEX_LOGOUTTIME:
            return et.getLogoutTime()==null;
        case INDEX_SERVERADDR:
            return et.getServerAddr()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERAGENT:
            return et.getUserAgent()==null;
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
        return  LoginLogBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(LoginLogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_IPADDRESS:
            return et.isIpAddressDirty();
        case INDEX_LOGINACCOUNTID:
            return et.isLoginAccountIdDirty();
        case INDEX_LOGINACCOUNTNAME:
            return et.isLoginAccountNameDirty();
        case INDEX_LOGINLOGID:
            return et.isLoginLogIdDirty();
        case INDEX_LOGINLOGNAME:
            return et.isLoginLogNameDirty();
        case INDEX_LOGINTIME:
            return et.isLoginTimeDirty();
        case INDEX_LOGOUTTIME:
            return et.isLogoutTimeDirty();
        case INDEX_SERVERADDR:
            return et.isServerAddrDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERAGENT:
            return et.isUserAgentDirty();
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
    private static  void fillJSONObject(LoginLogBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getIpAddress()!=null) {
            JSONObjectHelper.put(json,"ipaddress",getJSONValue(et.getIpAddress()),false);
        }
        if(bIncEmpty||et.getLoginAccountId()!=null) {
            JSONObjectHelper.put(json,"loginaccountid",getJSONValue(et.getLoginAccountId()),false);
        }
        if(bIncEmpty||et.getLoginAccountName()!=null) {
            JSONObjectHelper.put(json,"loginaccountname",getJSONValue(et.getLoginAccountName()),false);
        }
        if(bIncEmpty||et.getLoginLogId()!=null) {
            JSONObjectHelper.put(json,"loginlogid",getJSONValue(et.getLoginLogId()),false);
        }
        if(bIncEmpty||et.getLoginLogName()!=null) {
            JSONObjectHelper.put(json,"loginlogname",getJSONValue(et.getLoginLogName()),false);
        }
        if(bIncEmpty||et.getLoginTime()!=null) {
            JSONObjectHelper.put(json,"logintime",getJSONValue(et.getLoginTime()),false);
        }
        if(bIncEmpty||et.getLogoutTime()!=null) {
            JSONObjectHelper.put(json,"logouttime",getJSONValue(et.getLogoutTime()),false);
        }
        if(bIncEmpty||et.getServerAddr()!=null) {
            JSONObjectHelper.put(json,"serveraddr",getJSONValue(et.getServerAddr()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserAgent()!=null) {
            JSONObjectHelper.put(json,"useragent",getJSONValue(et.getUserAgent()),false);
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
    private static void fillXmlNode(LoginLogBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIpAddress()!=null) {
            Object obj = et.getIpAddress();
            node.setAttribute("IPADDRESS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLoginAccountId()!=null) {
            Object obj = et.getLoginAccountId();
            node.setAttribute("LOGINACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLoginAccountName()!=null) {
            Object obj = et.getLoginAccountName();
            node.setAttribute("LOGINACCOUNTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLoginLogId()!=null) {
            Object obj = et.getLoginLogId();
            node.setAttribute("LOGINLOGID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLoginLogName()!=null) {
            Object obj = et.getLoginLogName();
            node.setAttribute("LOGINLOGNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLoginTime()!=null) {
            Object obj = et.getLoginTime();
            node.setAttribute("LOGINTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getLogoutTime()!=null) {
            Object obj = et.getLogoutTime();
            node.setAttribute("LOGOUTTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getServerAddr()!=null) {
            Object obj = et.getServerAddr();
            node.setAttribute("SERVERADDR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserAgent()!=null) {
            Object obj = et.getUserAgent();
            node.setAttribute("USERAGENT",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        LoginLogBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(LoginLogBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isIpAddressDirty() && (bIncEmpty||et.getIpAddress()!=null)) {
            dst.set(FIELD_IPADDRESS,et.getIpAddress());
        }
        if(et.isLoginAccountIdDirty() && (bIncEmpty||et.getLoginAccountId()!=null)) {
            dst.set(FIELD_LOGINACCOUNTID,et.getLoginAccountId());
        }
        if(et.isLoginAccountNameDirty() && (bIncEmpty||et.getLoginAccountName()!=null)) {
            dst.set(FIELD_LOGINACCOUNTNAME,et.getLoginAccountName());
        }
        if(et.isLoginLogIdDirty() && (bIncEmpty||et.getLoginLogId()!=null)) {
            dst.set(FIELD_LOGINLOGID,et.getLoginLogId());
        }
        if(et.isLoginLogNameDirty() && (bIncEmpty||et.getLoginLogName()!=null)) {
            dst.set(FIELD_LOGINLOGNAME,et.getLoginLogName());
        }
        if(et.isLoginTimeDirty() && (bIncEmpty||et.getLoginTime()!=null)) {
            dst.set(FIELD_LOGINTIME,et.getLoginTime());
        }
        if(et.isLogoutTimeDirty() && (bIncEmpty||et.getLogoutTime()!=null)) {
            dst.set(FIELD_LOGOUTTIME,et.getLogoutTime());
        }
        if(et.isServerAddrDirty() && (bIncEmpty||et.getServerAddr()!=null)) {
            dst.set(FIELD_SERVERADDR,et.getServerAddr());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserAgentDirty() && (bIncEmpty||et.getUserAgent()!=null)) {
            dst.set(FIELD_USERAGENT,et.getUserAgent());
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
        return  LoginLogBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(LoginLogBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_IPADDRESS:
            et.resetIpAddress();
            return true;
        case INDEX_LOGINACCOUNTID:
            et.resetLoginAccountId();
            return true;
        case INDEX_LOGINACCOUNTNAME:
            et.resetLoginAccountName();
            return true;
        case INDEX_LOGINLOGID:
            et.resetLoginLogId();
            return true;
        case INDEX_LOGINLOGNAME:
            et.resetLoginLogName();
            return true;
        case INDEX_LOGINTIME:
            et.resetLoginTime();
            return true;
        case INDEX_LOGOUTTIME:
            et.resetLogoutTime();
            return true;
        case INDEX_SERVERADDR:
            et.resetServerAddr();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERAGENT:
            et.resetUserAgent();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objLoginaccountLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.LoginAccount loginaccount = null;
    /**
    * 获取父数据 登录帐户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.LoginAccount getLoginaccount() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginaccount();
        }

        if(this.getLoginAccountId()==null)
            return null;
        synchronized(this.objLoginaccountLock) {
            if(this.loginaccount!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getLoginAccountId(),loginaccount.getLoginAccountId())!=0) {
                    this.loginaccount = null;
                }
            }


            if(this.loginaccount==null) {
                net.ibizsys.psrt.srv.common.entity.LoginAccount loginaccount = new net.ibizsys.psrt.srv.common.entity.LoginAccount();
                loginaccount.setLoginAccountId(this.getLoginAccountId());
                net.ibizsys.psrt.srv.common.service.LoginAccountService service = (net.ibizsys.psrt.srv.common.service.LoginAccountService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.LoginAccountService.class,this.getSessionFactory());
                service.autoGet(loginaccount);
                this.loginaccount = loginaccount;
            }
            return this.loginaccount;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private LoginLogBase getProxyEntity() {
        return this.proxyLoginLogBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyLoginLogBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof LoginLogBase) {
            this.proxyLoginLogBase = (LoginLogBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.LoginLogService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}