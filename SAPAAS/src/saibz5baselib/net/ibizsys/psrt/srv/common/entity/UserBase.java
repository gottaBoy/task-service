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

import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserBase
extends UserObject {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ISSYSTEM = "ISSYSTEM";
    public static final String FIELD_LOGINNAME = "LOGINNAME";
    public static final String FIELD_LOGINPWD = "LOGINPWD";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_TIMEZONE = "TIMEZONE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERID = "USERID";
    public static final String FIELD_USERMODE = "USERMODE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 2;
    private static final int INDEX_ISSYSTEM = 3;
    private static final int INDEX_LOGINNAME = 4;
    private static final int INDEX_LOGINPWD = 5;
    private static final int INDEX_RESERVER = 9;
    private static final int INDEX_RESERVER2 = 10;
    private static final int INDEX_TIMEZONE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERID = 17;
    private static final int INDEX_USERMODE = 18;
    private static final int INDEX_USERNAME = 19;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserBase proxyUserBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean issystemDirtyFlag = false;
    private boolean loginnameDirtyFlag = false;
    private boolean loginpwdDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean timezoneDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean useridDirtyFlag = false;
    private boolean usermodeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="issystem")
    private Integer issystem;
    @Column(name="loginname")
    private String loginname;
    @Column(name="loginpwd")
    private String loginpwd;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="timezone")
    private String timezone;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userid")
    private String userid;
    @Column(name="usermode")
    private String usermode;
    @Column(name="username")
    private String username;
    @Column(name="validflag")
    private Integer validflag;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 2);
        fieldIndexMap.put(FIELD_ISSYSTEM, 3);
        fieldIndexMap.put(FIELD_LOGINNAME, 4);
        fieldIndexMap.put(FIELD_LOGINPWD, 5);
        fieldIndexMap.put(FIELD_RESERVER, 9);
        fieldIndexMap.put(FIELD_RESERVER2, 10);
        fieldIndexMap.put(FIELD_TIMEZONE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERID, 17);
        fieldIndexMap.put(FIELD_USERMODE, 18);
        fieldIndexMap.put(FIELD_USERNAME, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }

    public UserBase() {
        try {
            this.set("USEROBJECTTYPE", "USER");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag = true;
    }

    @Override
    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    @Override
    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    @Override
    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    @Override
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

    @Override
    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    @Override
    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    @Override
    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    @Override
    public void setEnable(Integer enable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag = true;
    }

    @Override
    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    @Override
    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    @Override
    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setIsSystem(Integer issystem) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag = true;
    }

    public Integer getIsSystem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    public boolean isIsSystemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    public void resetIsSystem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }
        this.issystemDirtyFlag = false;
        this.issystem = null;
    }

    public void setLoginName(String loginname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginName(loginname);
            return;
        }
        if (loginname != null && (loginname = StringHelper.trimRight(loginname)).length() == 0) {
            loginname = null;
        }
        this.loginname = loginname;
        this.loginnameDirtyFlag = true;
    }

    public String getLoginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginName();
        }
        return this.loginname;
    }

    public boolean isLoginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginNameDirty();
        }
        return this.loginnameDirtyFlag;
    }

    public void resetLoginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginName();
            return;
        }
        this.loginnameDirtyFlag = false;
        this.loginname = null;
    }

    public void setLoginPwd(String loginpwd) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginPwd(loginpwd);
            return;
        }
        if (loginpwd != null && (loginpwd = StringHelper.trimRight(loginpwd)).length() == 0) {
            loginpwd = null;
        }
        this.loginpwd = loginpwd;
        this.loginpwdDirtyFlag = true;
    }

    public String getLoginPwd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoginPwd();
        }
        return this.loginpwd;
    }

    public boolean isLoginPwdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoginPwdDirty();
        }
        return this.loginpwdDirtyFlag;
    }

    public void resetLoginPwd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoginPwd();
            return;
        }
        this.loginpwdDirtyFlag = false;
        this.loginpwd = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setTimeZone(String timezone) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeZone(timezone);
            return;
        }
        if (timezone != null && (timezone = StringHelper.trimRight(timezone)).length() == 0) {
            timezone = null;
        }
        this.timezone = timezone;
        this.timezoneDirtyFlag = true;
    }

    public String getTimeZone() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeZone();
        }
        return this.timezone;
    }

    public boolean isTimeZoneDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeZoneDirty();
        }
        return this.timezoneDirtyFlag;
    }

    public void resetTimeZone() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeZone();
            return;
        }
        this.timezoneDirtyFlag = false;
        this.timezone = null;
    }

    @Override
    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag = true;
    }

    @Override
    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    @Override
    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    @Override
    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    @Override
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

    @Override
    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    @Override
    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    @Override
    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUserId(String userid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserId(userid);
            return;
        }
        if (userid != null && (userid = StringHelper.trimRight(userid)).length() == 0) {
            userid = null;
        }
        this.userid = userid;
        this.useridDirtyFlag = true;
        super.setUserObjectId(userid);
    }

    public String getUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserId();
        }
        return this.userid;
    }

    public boolean isUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserIdDirty();
        }
        return this.useridDirtyFlag;
    }

    public void resetUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserId();
            return;
        }
        this.useridDirtyFlag = false;
        this.userid = null;
        super.resetUserObjectId();
    }

    public void setUserMode(String usermode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserMode(usermode);
            return;
        }
        if (usermode != null && (usermode = StringHelper.trimRight(usermode)).length() == 0) {
            usermode = null;
        }
        this.usermode = usermode;
        this.usermodeDirtyFlag = true;
    }

    public String getUserMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserMode();
        }
        return this.usermode;
    }

    public boolean isUserModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserModeDirty();
        }
        return this.usermodeDirtyFlag;
    }

    public void resetUserMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserMode();
            return;
        }
        this.usermodeDirtyFlag = false;
        this.usermode = null;
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
        super.setUserObjectName(username);
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

    public void setValidFlag(Integer validflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    @Override
    protected void onReset() {
        UserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnable();
        et.resetIsSystem();
        et.resetLoginName();
        et.resetLoginPwd();
        et.resetReserver();
        et.resetReserver2();
        et.resetTimeZone();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserId();
        et.resetUserMode();
        et.resetUserName();
        et.resetValidFlag();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM, this.getIsSystem());
        }
        if (!bDirtyOnly || this.isLoginNameDirty()) {
            params.put(FIELD_LOGINNAME, this.getLoginName());
        }
        if (!bDirtyOnly || this.isLoginPwdDirty()) {
            params.put(FIELD_LOGINPWD, this.getLoginPwd());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isTimeZoneDirty()) {
            params.put(FIELD_TIMEZONE, this.getTimeZone());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserIdDirty()) {
            params.put(FIELD_USERID, this.getUserId());
        }
        if (!bDirtyOnly || this.isUserModeDirty()) {
            params.put(FIELD_USERMODE, this.getUserMode());
        }
        if (!bDirtyOnly || this.isUserNameDirty()) {
            params.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bDirtyOnly || this.isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return UserBase.get(this, index);
    }

    private static Object get(UserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getEnable();
            }
            case 3: {
                return et.getIsSystem();
            }
            case 4: {
                return et.getLoginName();
            }
            case 5: {
                return et.getLoginPwd();
            }
            case 9: {
                return et.getReserver();
            }
            case 10: {
                return et.getReserver2();
            }
            case 12: {
                return et.getTimeZone();
            }
            case 13: {
                return et.getUpdateDate();
            }
            case 14: {
                return et.getUpdateMan();
            }
            case 17: {
                return et.getUserId();
            }
            case 18: {
                return et.getUserMode();
            }
            case 19: {
                return et.getUserName();
            }
            case 22: {
                return et.getValidFlag();
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
        UserBase.set(this, index, objValue);
    }

    private static void set(UserBase et, int index, Object obj) throws Exception {
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
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setIsSystem(DataObject.getIntegerValue(obj));
                return;
            }
            case 4: {
                et.setLoginName(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setLoginPwd(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setTimeZone(DataObject.getStringValue(obj));
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
            case 17: {
                et.setUserId(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setUserMode(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setUserName(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
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
        return UserBase.isNull(this, index);
    }

    private static boolean isNull(UserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getEnable() == null;
            }
            case 3: {
                return et.getIsSystem() == null;
            }
            case 4: {
                return et.getLoginName() == null;
            }
            case 5: {
                return et.getLoginPwd() == null;
            }
            case 9: {
                return et.getReserver() == null;
            }
            case 10: {
                return et.getReserver2() == null;
            }
            case 12: {
                return et.getTimeZone() == null;
            }
            case 13: {
                return et.getUpdateDate() == null;
            }
            case 14: {
                return et.getUpdateMan() == null;
            }
            case 17: {
                return et.getUserId() == null;
            }
            case 18: {
                return et.getUserMode() == null;
            }
            case 19: {
                return et.getUserName() == null;
            }
            case 22: {
                return et.getValidFlag() == null;
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
        return UserBase.contains(this, index);
    }

    private static boolean contains(UserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isEnableDirty();
            }
            case 3: {
                return et.isIsSystemDirty();
            }
            case 4: {
                return et.isLoginNameDirty();
            }
            case 5: {
                return et.isLoginPwdDirty();
            }
            case 9: {
                return et.isReserverDirty();
            }
            case 10: {
                return et.isReserver2Dirty();
            }
            case 12: {
                return et.isTimeZoneDirty();
            }
            case 13: {
                return et.isUpdateDateDirty();
            }
            case 14: {
                return et.isUpdateManDirty();
            }
            case 17: {
                return et.isUserIdDirty();
            }
            case 18: {
                return et.isUserModeDirty();
            }
            case 19: {
                return et.isUserNameDirty();
            }
            case 22: {
                return et.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", UserBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            JSONObjectHelper.put(json, "issystem", UserBase.getJSONValue(et.getIsSystem()), false);
        }
        if (bIncEmpty || et.getLoginName() != null) {
            JSONObjectHelper.put(json, "loginname", UserBase.getJSONValue(et.getLoginName()), false);
        }
        if (bIncEmpty || et.getLoginPwd() != null) {
            JSONObjectHelper.put(json, "loginpwd", UserBase.getJSONValue(et.getLoginPwd()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getTimeZone() != null) {
            JSONObjectHelper.put(json, "timezone", UserBase.getJSONValue(et.getTimeZone()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserId() != null) {
            JSONObjectHelper.put(json, "userid", UserBase.getJSONValue(et.getUserId()), false);
        }
        if (bIncEmpty || et.getUserMode() != null) {
            JSONObjectHelper.put(json, "usermode", UserBase.getJSONValue(et.getUserMode()), false);
        }
        if (bIncEmpty || et.getUserName() != null) {
            JSONObjectHelper.put(json, "username", UserBase.getJSONValue(et.getUserName()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", UserBase.getJSONValue(et.getValidFlag()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            obj = et.getIsSystem();
            node.setAttribute(FIELD_ISSYSTEM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLoginName() != null) {
            obj = et.getLoginName();
            node.setAttribute(FIELD_LOGINNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLoginPwd() != null) {
            obj = et.getLoginPwd();
            node.setAttribute(FIELD_LOGINPWD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTimeZone() != null) {
            obj = et.getTimeZone();
            node.setAttribute(FIELD_TIMEZONE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserId() != null) {
            obj = et.getUserId();
            node.setAttribute(FIELD_USERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserMode() != null) {
            obj = et.getUserMode();
            node.setAttribute(FIELD_USERMODE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserName() != null) {
            obj = et.getUserName();
            node.setAttribute(FIELD_USERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            obj = et.getValidFlag();
            node.setAttribute(FIELD_VALIDFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isIsSystemDirty() && (bIncEmpty || et.getIsSystem() != null)) {
            dst.set(FIELD_ISSYSTEM, et.getIsSystem());
        }
        if (et.isLoginNameDirty() && (bIncEmpty || et.getLoginName() != null)) {
            dst.set(FIELD_LOGINNAME, et.getLoginName());
        }
        if (et.isLoginPwdDirty() && (bIncEmpty || et.getLoginPwd() != null)) {
            dst.set(FIELD_LOGINPWD, et.getLoginPwd());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isTimeZoneDirty() && (bIncEmpty || et.getTimeZone() != null)) {
            dst.set(FIELD_TIMEZONE, et.getTimeZone());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserIdDirty() && (bIncEmpty || et.getUserId() != null)) {
            dst.set(FIELD_USERID, et.getUserId());
        }
        if (et.isUserModeDirty() && (bIncEmpty || et.getUserMode() != null)) {
            dst.set(FIELD_USERMODE, et.getUserMode());
        }
        if (et.isUserNameDirty() && (bIncEmpty || et.getUserName() != null)) {
            dst.set(FIELD_USERNAME, et.getUserName());
        }
        if (et.isValidFlagDirty() && (bIncEmpty || et.getValidFlag() != null)) {
            dst.set(FIELD_VALIDFLAG, et.getValidFlag());
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
        return UserBase.remove(this, index);
    }

    private static boolean remove(UserBase et, int index) throws Exception {
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
                et.resetEnable();
                return true;
            }
            case 3: {
                et.resetIsSystem();
                return true;
            }
            case 4: {
                et.resetLoginName();
                return true;
            }
            case 5: {
                et.resetLoginPwd();
                return true;
            }
            case 9: {
                et.resetReserver();
                return true;
            }
            case 10: {
                et.resetReserver2();
                return true;
            }
            case 12: {
                et.resetTimeZone();
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
            case 17: {
                et.resetUserId();
                return true;
            }
            case 18: {
                et.resetUserMode();
                return true;
            }
            case 19: {
                et.resetUserName();
                return true;
            }
            case 22: {
                et.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private UserBase getProxyEntity() {
        return this.proxyUserBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserBase) {
            this.proxyUserBase = (UserBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

