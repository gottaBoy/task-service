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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class LoginLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(LoginLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IPADDRESS = "IPADDRESS";
    public static final String FIELD_LOGINACCOUNTID = "LOGINACCOUNTID";
    public static final String FIELD_LOGINACCOUNTNAME = "LOGINACCOUNTNAME";
    public static final String FIELD_LOGINLOGID = "LOGINLOGID";
    public static final String FIELD_LOGINLOGNAME = "LOGINLOGNAME";
    public static final String FIELD_LOGINTIME = "LOGINTIME";
    public static final String FIELD_LOGOUTTIME = "LOGOUTTIME";
    public static final String FIELD_SERVERADDR = "SERVERADDR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERAGENT = "USERAGENT";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_IPADDRESS = 2;
    private static final int INDEX_LOGINACCOUNTID = 3;
    private static final int INDEX_LOGINACCOUNTNAME = 4;
    private static final int INDEX_LOGINLOGID = 5;
    private static final int INDEX_LOGINLOGNAME = 6;
    private static final int INDEX_LOGINTIME = 7;
    private static final int INDEX_LOGOUTTIME = 8;
    private static final int INDEX_SERVERADDR = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERAGENT = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private LoginLogBase proxyLoginLogBase = null;
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
    private Integer objLoginaccountLock = new Integer(1);
    private LoginAccount loginaccount = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_IPADDRESS, 2);
        fieldIndexMap.put(FIELD_LOGINACCOUNTID, 3);
        fieldIndexMap.put(FIELD_LOGINACCOUNTNAME, 4);
        fieldIndexMap.put(FIELD_LOGINLOGID, 5);
        fieldIndexMap.put(FIELD_LOGINLOGNAME, 6);
        fieldIndexMap.put(FIELD_LOGINTIME, 7);
        fieldIndexMap.put(FIELD_LOGOUTTIME, 8);
        fieldIndexMap.put(FIELD_SERVERADDR, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERAGENT, 12);
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

    public void setIpAddress(String ipaddress) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddress(ipaddress);
            return;
        }
        if (ipaddress != null && (ipaddress = StringHelper.trimRight(ipaddress)).length() == 0) {
            ipaddress = null;
        }
        this.ipaddress = ipaddress;
        this.ipaddressDirtyFlag = true;
    }

    public String getIpAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddress();
        }
        return this.ipaddress;
    }

    public boolean isIpAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddressDirty();
        }
        return this.ipaddressDirtyFlag;
    }

    public void resetIpAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddress();
            return;
        }
        this.ipaddressDirtyFlag = false;
        this.ipaddress = null;
    }

    public void setLoginAccountId(String loginaccountid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginAccountId(loginaccountid);
            return;
        }
        if (loginaccountid != null && (loginaccountid = StringHelper.trimRight(loginaccountid)).length() == 0) {
            loginaccountid = null;
        }
        this.loginaccountid = loginaccountid;
        this.loginaccountidDirtyFlag = true;
    }

    public String getLoginAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginAccountId();
        }
        return this.loginaccountid;
    }

    public boolean isLoginAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginAccountIdDirty();
        }
        return this.loginaccountidDirtyFlag;
    }

    public void resetLoginAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginAccountId();
            return;
        }
        this.loginaccountidDirtyFlag = false;
        this.loginaccountid = null;
    }

    public void setLoginAccountName(String loginaccountname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginAccountName(loginaccountname);
            return;
        }
        if (loginaccountname != null && (loginaccountname = StringHelper.trimRight(loginaccountname)).length() == 0) {
            loginaccountname = null;
        }
        this.loginaccountname = loginaccountname;
        this.loginaccountnameDirtyFlag = true;
    }

    public String getLoginAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginAccountName();
        }
        return this.loginaccountname;
    }

    public boolean isLoginAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginAccountNameDirty();
        }
        return this.loginaccountnameDirtyFlag;
    }

    public void resetLoginAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginAccountName();
            return;
        }
        this.loginaccountnameDirtyFlag = false;
        this.loginaccountname = null;
    }

    public void setLoginLogId(String loginlogid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginLogId(loginlogid);
            return;
        }
        if (loginlogid != null && (loginlogid = StringHelper.trimRight(loginlogid)).length() == 0) {
            loginlogid = null;
        }
        this.loginlogid = loginlogid;
        this.loginlogidDirtyFlag = true;
    }

    public String getLoginLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginLogId();
        }
        return this.loginlogid;
    }

    public boolean isLoginLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginLogIdDirty();
        }
        return this.loginlogidDirtyFlag;
    }

    public void resetLoginLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginLogId();
            return;
        }
        this.loginlogidDirtyFlag = false;
        this.loginlogid = null;
    }

    public void setLoginLogName(String loginlogname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginLogName(loginlogname);
            return;
        }
        if (loginlogname != null && (loginlogname = StringHelper.trimRight(loginlogname)).length() == 0) {
            loginlogname = null;
        }
        this.loginlogname = loginlogname;
        this.loginlognameDirtyFlag = true;
    }

    public String getLoginLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginLogName();
        }
        return this.loginlogname;
    }

    public boolean isLoginLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginLogNameDirty();
        }
        return this.loginlognameDirtyFlag;
    }

    public void resetLoginLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginLogName();
            return;
        }
        this.loginlognameDirtyFlag = false;
        this.loginlogname = null;
    }

    public void setLoginTime(Timestamp logintime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginTime(logintime);
            return;
        }
        this.logintime = logintime;
        this.logintimeDirtyFlag = true;
    }

    public Timestamp getLoginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginTime();
        }
        return this.logintime;
    }

    public boolean isLoginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginTimeDirty();
        }
        return this.logintimeDirtyFlag;
    }

    public void resetLoginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginTime();
            return;
        }
        this.logintimeDirtyFlag = false;
        this.logintime = null;
    }

    public void setLogoutTime(Timestamp logouttime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogoutTime(logouttime);
            return;
        }
        this.logouttime = logouttime;
        this.logouttimeDirtyFlag = true;
    }

    public Timestamp getLogoutTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogoutTime();
        }
        return this.logouttime;
    }

    public boolean isLogoutTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogoutTimeDirty();
        }
        return this.logouttimeDirtyFlag;
    }

    public void resetLogoutTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogoutTime();
            return;
        }
        this.logouttimeDirtyFlag = false;
        this.logouttime = null;
    }

    public void setServerAddr(String serveraddr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerAddr(serveraddr);
            return;
        }
        if (serveraddr != null && (serveraddr = StringHelper.trimRight(serveraddr)).length() == 0) {
            serveraddr = null;
        }
        this.serveraddr = serveraddr;
        this.serveraddrDirtyFlag = true;
    }

    public String getServerAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerAddr();
        }
        return this.serveraddr;
    }

    public boolean isServerAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerAddrDirty();
        }
        return this.serveraddrDirtyFlag;
    }

    public void resetServerAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerAddr();
            return;
        }
        this.serveraddrDirtyFlag = false;
        this.serveraddr = null;
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

    public void setUserAgent(String useragent) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserAgent(useragent);
            return;
        }
        if (useragent != null && (useragent = StringHelper.trimRight(useragent)).length() == 0) {
            useragent = null;
        }
        this.useragent = useragent;
        this.useragentDirtyFlag = true;
    }

    public String getUserAgent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserAgent();
        }
        return this.useragent;
    }

    public boolean isUserAgentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserAgentDirty();
        }
        return this.useragentDirtyFlag;
    }

    public void resetUserAgent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserAgent();
            return;
        }
        this.useragentDirtyFlag = false;
        this.useragent = null;
    }

    @Override
    protected void onReset() {
        LoginLogBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isIpAddressDirty()) {
            params.put(FIELD_IPADDRESS, this.getIpAddress());
        }
        if (!bDirtyOnly || this.isLoginAccountIdDirty()) {
            params.put(FIELD_LOGINACCOUNTID, this.getLoginAccountId());
        }
        if (!bDirtyOnly || this.isLoginAccountNameDirty()) {
            params.put(FIELD_LOGINACCOUNTNAME, this.getLoginAccountName());
        }
        if (!bDirtyOnly || this.isLoginLogIdDirty()) {
            params.put(FIELD_LOGINLOGID, this.getLoginLogId());
        }
        if (!bDirtyOnly || this.isLoginLogNameDirty()) {
            params.put(FIELD_LOGINLOGNAME, this.getLoginLogName());
        }
        if (!bDirtyOnly || this.isLoginTimeDirty()) {
            params.put(FIELD_LOGINTIME, this.getLoginTime());
        }
        if (!bDirtyOnly || this.isLogoutTimeDirty()) {
            params.put(FIELD_LOGOUTTIME, this.getLogoutTime());
        }
        if (!bDirtyOnly || this.isServerAddrDirty()) {
            params.put(FIELD_SERVERADDR, this.getServerAddr());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserAgentDirty()) {
            params.put(FIELD_USERAGENT, this.getUserAgent());
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
        return LoginLogBase.get(this, index);
    }

    private static Object get(LoginLogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getIpAddress();
            }
            case 3: {
                return et.getLoginAccountId();
            }
            case 4: {
                return et.getLoginAccountName();
            }
            case 5: {
                return et.getLoginLogId();
            }
            case 6: {
                return et.getLoginLogName();
            }
            case 7: {
                return et.getLoginTime();
            }
            case 8: {
                return et.getLogoutTime();
            }
            case 9: {
                return et.getServerAddr();
            }
            case 10: {
                return et.getUpdateDate();
            }
            case 11: {
                return et.getUpdateMan();
            }
            case 12: {
                return et.getUserAgent();
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
        LoginLogBase.set(this, index, objValue);
    }

    private static void set(LoginLogBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setIpAddress(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setLoginAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setLoginAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setLoginLogId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setLoginLogName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setLoginTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 8: {
                et.setLogoutTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
                et.setServerAddr(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 11: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserAgent(DataObject.getStringValue(obj));
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
        return LoginLogBase.isNull(this, index);
    }

    private static boolean isNull(LoginLogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getIpAddress() == null;
            }
            case 3: {
                return et.getLoginAccountId() == null;
            }
            case 4: {
                return et.getLoginAccountName() == null;
            }
            case 5: {
                return et.getLoginLogId() == null;
            }
            case 6: {
                return et.getLoginLogName() == null;
            }
            case 7: {
                return et.getLoginTime() == null;
            }
            case 8: {
                return et.getLogoutTime() == null;
            }
            case 9: {
                return et.getServerAddr() == null;
            }
            case 10: {
                return et.getUpdateDate() == null;
            }
            case 11: {
                return et.getUpdateMan() == null;
            }
            case 12: {
                return et.getUserAgent() == null;
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
        return LoginLogBase.contains(this, index);
    }

    private static boolean contains(LoginLogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isIpAddressDirty();
            }
            case 3: {
                return et.isLoginAccountIdDirty();
            }
            case 4: {
                return et.isLoginAccountNameDirty();
            }
            case 5: {
                return et.isLoginLogIdDirty();
            }
            case 6: {
                return et.isLoginLogNameDirty();
            }
            case 7: {
                return et.isLoginTimeDirty();
            }
            case 8: {
                return et.isLogoutTimeDirty();
            }
            case 9: {
                return et.isServerAddrDirty();
            }
            case 10: {
                return et.isUpdateDateDirty();
            }
            case 11: {
                return et.isUpdateManDirty();
            }
            case 12: {
                return et.isUserAgentDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        LoginLogBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(LoginLogBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", LoginLogBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", LoginLogBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getIpAddress() != null) {
            JSONObjectHelper.put(json, "ipaddress", LoginLogBase.getJSONValue(et.getIpAddress()), false);
        }
        if (bIncEmpty || et.getLoginAccountId() != null) {
            JSONObjectHelper.put(json, "loginaccountid", LoginLogBase.getJSONValue(et.getLoginAccountId()), false);
        }
        if (bIncEmpty || et.getLoginAccountName() != null) {
            JSONObjectHelper.put(json, "loginaccountname", LoginLogBase.getJSONValue(et.getLoginAccountName()), false);
        }
        if (bIncEmpty || et.getLoginLogId() != null) {
            JSONObjectHelper.put(json, "loginlogid", LoginLogBase.getJSONValue(et.getLoginLogId()), false);
        }
        if (bIncEmpty || et.getLoginLogName() != null) {
            JSONObjectHelper.put(json, "loginlogname", LoginLogBase.getJSONValue(et.getLoginLogName()), false);
        }
        if (bIncEmpty || et.getLoginTime() != null) {
            JSONObjectHelper.put(json, "logintime", LoginLogBase.getJSONValue(et.getLoginTime()), false);
        }
        if (bIncEmpty || et.getLogoutTime() != null) {
            JSONObjectHelper.put(json, "logouttime", LoginLogBase.getJSONValue(et.getLogoutTime()), false);
        }
        if (bIncEmpty || et.getServerAddr() != null) {
            JSONObjectHelper.put(json, "serveraddr", LoginLogBase.getJSONValue(et.getServerAddr()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", LoginLogBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", LoginLogBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserAgent() != null) {
            JSONObjectHelper.put(json, "useragent", LoginLogBase.getJSONValue(et.getUserAgent()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        LoginLogBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(LoginLogBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIpAddress() != null) {
            obj = et.getIpAddress();
            node.setAttribute(FIELD_IPADDRESS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLoginAccountId() != null) {
            obj = et.getLoginAccountId();
            node.setAttribute(FIELD_LOGINACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLoginAccountName() != null) {
            obj = et.getLoginAccountName();
            node.setAttribute(FIELD_LOGINACCOUNTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLoginLogId() != null) {
            obj = et.getLoginLogId();
            node.setAttribute(FIELD_LOGINLOGID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLoginLogName() != null) {
            obj = et.getLoginLogName();
            node.setAttribute(FIELD_LOGINLOGNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLoginTime() != null) {
            obj = et.getLoginTime();
            node.setAttribute(FIELD_LOGINTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getLogoutTime() != null) {
            obj = et.getLogoutTime();
            node.setAttribute(FIELD_LOGOUTTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getServerAddr() != null) {
            obj = et.getServerAddr();
            node.setAttribute(FIELD_SERVERADDR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserAgent() != null) {
            obj = et.getUserAgent();
            node.setAttribute(FIELD_USERAGENT, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        LoginLogBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(LoginLogBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isIpAddressDirty() && (bIncEmpty || et.getIpAddress() != null)) {
            dst.set(FIELD_IPADDRESS, et.getIpAddress());
        }
        if (et.isLoginAccountIdDirty() && (bIncEmpty || et.getLoginAccountId() != null)) {
            dst.set(FIELD_LOGINACCOUNTID, et.getLoginAccountId());
        }
        if (et.isLoginAccountNameDirty() && (bIncEmpty || et.getLoginAccountName() != null)) {
            dst.set(FIELD_LOGINACCOUNTNAME, et.getLoginAccountName());
        }
        if (et.isLoginLogIdDirty() && (bIncEmpty || et.getLoginLogId() != null)) {
            dst.set(FIELD_LOGINLOGID, et.getLoginLogId());
        }
        if (et.isLoginLogNameDirty() && (bIncEmpty || et.getLoginLogName() != null)) {
            dst.set(FIELD_LOGINLOGNAME, et.getLoginLogName());
        }
        if (et.isLoginTimeDirty() && (bIncEmpty || et.getLoginTime() != null)) {
            dst.set(FIELD_LOGINTIME, et.getLoginTime());
        }
        if (et.isLogoutTimeDirty() && (bIncEmpty || et.getLogoutTime() != null)) {
            dst.set(FIELD_LOGOUTTIME, et.getLogoutTime());
        }
        if (et.isServerAddrDirty() && (bIncEmpty || et.getServerAddr() != null)) {
            dst.set(FIELD_SERVERADDR, et.getServerAddr());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserAgentDirty() && (bIncEmpty || et.getUserAgent() != null)) {
            dst.set(FIELD_USERAGENT, et.getUserAgent());
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
        return LoginLogBase.remove(this, index);
    }

    private static boolean remove(LoginLogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetIpAddress();
                return true;
            }
            case 3: {
                et.resetLoginAccountId();
                return true;
            }
            case 4: {
                et.resetLoginAccountName();
                return true;
            }
            case 5: {
                et.resetLoginLogId();
                return true;
            }
            case 6: {
                et.resetLoginLogName();
                return true;
            }
            case 7: {
                et.resetLoginTime();
                return true;
            }
            case 8: {
                et.resetLogoutTime();
                return true;
            }
            case 9: {
                et.resetServerAddr();
                return true;
            }
            case 10: {
                et.resetUpdateDate();
                return true;
            }
            case 11: {
                et.resetUpdateMan();
                return true;
            }
            case 12: {
                et.resetUserAgent();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public LoginAccount getLoginaccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginaccount();
        }
        if (this.getLoginAccountId() == null) {
            return null;
        }
        Integer n = this.objLoginaccountLock;
        synchronized (n) {
            if (this.loginaccount != null && DataTypeHelper.compare(25, (Object)this.getLoginAccountId(), (Object)this.loginaccount.getLoginAccountId()) != 0L) {
                this.loginaccount = null;
            }
            if (this.loginaccount == null) {
                LoginAccount loginaccount = new LoginAccount();
                loginaccount.setLoginAccountId(this.getLoginAccountId());
                LoginAccountService service = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class, this.getSessionFactory());
                service.autoGet(loginaccount);
                this.loginaccount = loginaccount;
            }
            return this.loginaccount;
        }
    }

    private LoginLogBase getProxyEntity() {
        return this.proxyLoginLogBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyLoginLogBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof LoginLogBase) {
            this.proxyLoginLogBase = (LoginLogBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.LoginLogService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

