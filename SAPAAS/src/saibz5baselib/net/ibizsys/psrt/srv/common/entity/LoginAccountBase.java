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
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class LoginAccountBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(LoginAccountBase.class);
    public static final String FIELD_APPUITHEME = "APPUITHEME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISENABLE = "ISENABLE";
    public static final String FIELD_LANGUAGE = "LANGUAGE";
    public static final String FIELD_LASTCHGPWDTIME = "LASTCHGPWDTIME";
    public static final String FIELD_LASTLOGINTIME = "LASTLOGINTIME";
    public static final String FIELD_LOGINACCOUNTID = "LOGINACCOUNTID";
    public static final String FIELD_LOGINACCOUNTNAME = "LOGINACCOUNTNAME";
    public static final String FIELD_ORGADMIN = "ORGADMIN";
    public static final String FIELD_PWD = "PWD";
    public static final String FIELD_SUPERUSER = "SUPERUSER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERDATA3 = "USERDATA3";
    public static final String FIELD_USERDATA4 = "USERDATA4";
    public static final String FIELD_USERID = "USERID";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_APPUITHEME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ISENABLE = 3;
    private static final int INDEX_LANGUAGE = 4;
    private static final int INDEX_LASTCHGPWDTIME = 5;
    private static final int INDEX_LASTLOGINTIME = 6;
    private static final int INDEX_LOGINACCOUNTID = 7;
    private static final int INDEX_LOGINACCOUNTNAME = 8;
    private static final int INDEX_ORGADMIN = 9;
    private static final int INDEX_PWD = 10;
    private static final int INDEX_SUPERUSER = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERDATA = 14;
    private static final int INDEX_USERDATA2 = 15;
    private static final int INDEX_USERDATA3 = 16;
    private static final int INDEX_USERDATA4 = 17;
    private static final int INDEX_USERID = 18;
    private static final int INDEX_USERNAME = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private LoginAccountBase proxyLoginAccountBase = null;
    private boolean appuithemeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean isenableDirtyFlag = false;
    private boolean languageDirtyFlag = false;
    private boolean lastchgpwdtimeDirtyFlag = false;
    private boolean lastlogintimeDirtyFlag = false;
    private boolean loginaccountidDirtyFlag = false;
    private boolean loginaccountnameDirtyFlag = false;
    private boolean orgadminDirtyFlag = false;
    private boolean pwdDirtyFlag = false;
    private boolean superuserDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userdata3DirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean useridDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="appuitheme")
    private String appuitheme;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="isenable")
    private Integer isenable;
    @Column(name="language")
    private String language;
    @Column(name="lastchgpwdtime")
    private Timestamp lastchgpwdtime;
    @Column(name="lastlogintime")
    private Timestamp lastlogintime;
    @Column(name="loginaccountid")
    private String loginaccountid;
    @Column(name="loginaccountname")
    private String loginaccountname;
    @Column(name="orgadmin")
    private Integer orgadmin;
    @Column(name="pwd")
    private String pwd;
    @Column(name="superuser")
    private Integer superuser;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userdata3")
    private String userdata3;
    @Column(name="userdata4")
    private String userdata4;
    @Column(name="userid")
    private String userid;
    @Column(name="username")
    private String username;
    private Integer objUserLock = new Integer(1);
    private User user = null;

    static {
        fieldIndexMap.put(FIELD_APPUITHEME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ISENABLE, 3);
        fieldIndexMap.put(FIELD_LANGUAGE, 4);
        fieldIndexMap.put(FIELD_LASTCHGPWDTIME, 5);
        fieldIndexMap.put(FIELD_LASTLOGINTIME, 6);
        fieldIndexMap.put(FIELD_LOGINACCOUNTID, 7);
        fieldIndexMap.put(FIELD_LOGINACCOUNTNAME, 8);
        fieldIndexMap.put(FIELD_ORGADMIN, 9);
        fieldIndexMap.put(FIELD_PWD, 10);
        fieldIndexMap.put(FIELD_SUPERUSER, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERDATA, 14);
        fieldIndexMap.put(FIELD_USERDATA2, 15);
        fieldIndexMap.put(FIELD_USERDATA3, 16);
        fieldIndexMap.put(FIELD_USERDATA4, 17);
        fieldIndexMap.put(FIELD_USERID, 18);
        fieldIndexMap.put(FIELD_USERNAME, 19);
    }

    public void setAppUITheme(String appuitheme) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppUITheme(appuitheme);
            return;
        }
        if (appuitheme != null && (appuitheme = StringHelper.trimRight(appuitheme)).length() == 0) {
            appuitheme = null;
        }
        this.appuitheme = appuitheme;
        this.appuithemeDirtyFlag = true;
    }

    public String getAppUITheme() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppUITheme();
        }
        return this.appuitheme;
    }

    public boolean isAppUIThemeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppUIThemeDirty();
        }
        return this.appuithemeDirtyFlag;
    }

    public void resetAppUITheme() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppUITheme();
            return;
        }
        this.appuithemeDirtyFlag = false;
        this.appuitheme = null;
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

    public void setIsEnable(Integer isenable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsEnable(isenable);
            return;
        }
        this.isenable = isenable;
        this.isenableDirtyFlag = true;
    }

    public Integer getIsEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsEnable();
        }
        return this.isenable;
    }

    public boolean isIsEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsEnableDirty();
        }
        return this.isenableDirtyFlag;
    }

    public void resetIsEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsEnable();
            return;
        }
        this.isenableDirtyFlag = false;
        this.isenable = null;
    }

    public void setLanguage(String language) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanguage(language);
            return;
        }
        if (language != null && (language = StringHelper.trimRight(language)).length() == 0) {
            language = null;
        }
        this.language = language;
        this.languageDirtyFlag = true;
    }

    public String getLanguage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanguage();
        }
        return this.language;
    }

    public boolean isLanguageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanguageDirty();
        }
        return this.languageDirtyFlag;
    }

    public void resetLanguage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanguage();
            return;
        }
        this.languageDirtyFlag = false;
        this.language = null;
    }

    public void setLastChgPwdTime(Timestamp lastchgpwdtime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastChgPwdTime(lastchgpwdtime);
            return;
        }
        this.lastchgpwdtime = lastchgpwdtime;
        this.lastchgpwdtimeDirtyFlag = true;
    }

    public Timestamp getLastChgPwdTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastChgPwdTime();
        }
        return this.lastchgpwdtime;
    }

    public boolean isLastChgPwdTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastChgPwdTimeDirty();
        }
        return this.lastchgpwdtimeDirtyFlag;
    }

    public void resetLastChgPwdTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastChgPwdTime();
            return;
        }
        this.lastchgpwdtimeDirtyFlag = false;
        this.lastchgpwdtime = null;
    }

    public void setLastLoginTime(Timestamp lastlogintime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastLoginTime(lastlogintime);
            return;
        }
        this.lastlogintime = lastlogintime;
        this.lastlogintimeDirtyFlag = true;
    }

    public Timestamp getLastLoginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastLoginTime();
        }
        return this.lastlogintime;
    }

    public boolean isLastLoginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastLoginTimeDirty();
        }
        return this.lastlogintimeDirtyFlag;
    }

    public void resetLastLoginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastLoginTime();
            return;
        }
        this.lastlogintimeDirtyFlag = false;
        this.lastlogintime = null;
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
        if (loginaccountname != null) {
            loginaccountname = loginaccountname.toLowerCase();
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

    public void setOrgAdmin(Integer orgadmin) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgAdmin(orgadmin);
            return;
        }
        this.orgadmin = orgadmin;
        this.orgadminDirtyFlag = true;
    }

    public Integer getOrgAdmin() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgAdmin();
        }
        return this.orgadmin;
    }

    public boolean isOrgAdminDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgAdminDirty();
        }
        return this.orgadminDirtyFlag;
    }

    public void resetOrgAdmin() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgAdmin();
            return;
        }
        this.orgadminDirtyFlag = false;
        this.orgadmin = null;
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

    public void setSuperUser(Integer superuser) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSuperUser(superuser);
            return;
        }
        this.superuser = superuser;
        this.superuserDirtyFlag = true;
    }

    public Integer getSuperUser() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSuperUser();
        }
        return this.superuser;
    }

    public boolean isSuperUserDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSuperUserDirty();
        }
        return this.superuserDirtyFlag;
    }

    public void resetSuperUser() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSuperUser();
            return;
        }
        this.superuserDirtyFlag = false;
        this.superuser = null;
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

    public void setUserData(String userdata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if (userdata != null && (userdata = StringHelper.trimRight(userdata)).length() == 0) {
            userdata = null;
        }
        this.userdata = userdata;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String userdata2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if (userdata2 != null && (userdata2 = StringHelper.trimRight(userdata2)).length() == 0) {
            userdata2 = null;
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setUserData3(String userdata3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData3(userdata3);
            return;
        }
        if (userdata3 != null && (userdata3 = StringHelper.trimRight(userdata3)).length() == 0) {
            userdata3 = null;
        }
        this.userdata3 = userdata3;
        this.userdata3DirtyFlag = true;
    }

    public String getUserData3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    public boolean isUserData3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    public void resetUserData3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData3();
            return;
        }
        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }

    public void setUserData4(String userdata4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData4(userdata4);
            return;
        }
        if (userdata4 != null && (userdata4 = StringHelper.trimRight(userdata4)).length() == 0) {
            userdata4 = null;
        }
        this.userdata4 = userdata4;
        this.userdata4DirtyFlag = true;
    }

    public String getUserData4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    public boolean isUserData4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    public void resetUserData4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData4();
            return;
        }
        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
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
        LoginAccountBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(LoginAccountBase et) {
        et.resetAppUITheme();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsEnable();
        et.resetLanguage();
        et.resetLastChgPwdTime();
        et.resetLastLoginTime();
        et.resetLoginAccountId();
        et.resetLoginAccountName();
        et.resetOrgAdmin();
        et.resetPwd();
        et.resetSuperUser();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserData3();
        et.resetUserData4();
        et.resetUserId();
        et.resetUserName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAppUIThemeDirty()) {
            params.put(FIELD_APPUITHEME, this.getAppUITheme());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isIsEnableDirty()) {
            params.put(FIELD_ISENABLE, this.getIsEnable());
        }
        if (!bDirtyOnly || this.isLanguageDirty()) {
            params.put(FIELD_LANGUAGE, this.getLanguage());
        }
        if (!bDirtyOnly || this.isLastChgPwdTimeDirty()) {
            params.put(FIELD_LASTCHGPWDTIME, this.getLastChgPwdTime());
        }
        if (!bDirtyOnly || this.isLastLoginTimeDirty()) {
            params.put(FIELD_LASTLOGINTIME, this.getLastLoginTime());
        }
        if (!bDirtyOnly || this.isLoginAccountIdDirty()) {
            params.put(FIELD_LOGINACCOUNTID, this.getLoginAccountId());
        }
        if (!bDirtyOnly || this.isLoginAccountNameDirty()) {
            params.put(FIELD_LOGINACCOUNTNAME, this.getLoginAccountName());
        }
        if (!bDirtyOnly || this.isOrgAdminDirty()) {
            params.put(FIELD_ORGADMIN, this.getOrgAdmin());
        }
        if (!bDirtyOnly || this.isPwdDirty()) {
            params.put(FIELD_PWD, this.getPwd());
        }
        if (!bDirtyOnly || this.isSuperUserDirty()) {
            params.put(FIELD_SUPERUSER, this.getSuperUser());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDataDirty()) {
            params.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bDirtyOnly || this.isUserData2Dirty()) {
            params.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bDirtyOnly || this.isUserData3Dirty()) {
            params.put(FIELD_USERDATA3, this.getUserData3());
        }
        if (!bDirtyOnly || this.isUserData4Dirty()) {
            params.put(FIELD_USERDATA4, this.getUserData4());
        }
        if (!bDirtyOnly || this.isUserIdDirty()) {
            params.put(FIELD_USERID, this.getUserId());
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
        return LoginAccountBase.get(this, index);
    }

    private static Object get(LoginAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAppUITheme();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getIsEnable();
            }
            case 4: {
                return et.getLanguage();
            }
            case 5: {
                return et.getLastChgPwdTime();
            }
            case 6: {
                return et.getLastLoginTime();
            }
            case 7: {
                return et.getLoginAccountId();
            }
            case 8: {
                return et.getLoginAccountName();
            }
            case 9: {
                return et.getOrgAdmin();
            }
            case 10: {
                return et.getPwd();
            }
            case 11: {
                return et.getSuperUser();
            }
            case 12: {
                return et.getUpdateDate();
            }
            case 13: {
                return et.getUpdateMan();
            }
            case 14: {
                return et.getUserData();
            }
            case 15: {
                return et.getUserData2();
            }
            case 16: {
                return et.getUserData3();
            }
            case 17: {
                return et.getUserData4();
            }
            case 18: {
                return et.getUserId();
            }
            case 19: {
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
        LoginAccountBase.set(this, index, objValue);
    }

    private static void set(LoginAccountBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAppUITheme(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setIsEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 4: {
                et.setLanguage(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setLastChgPwdTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 6: {
                et.setLastLoginTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 7: {
                et.setLoginAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setLoginAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setOrgAdmin(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setPwd(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setSuperUser(DataObject.getIntegerValue(obj));
                return;
            }
            case 12: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 13: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setUserData3(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setUserData4(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setUserId(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
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
        return LoginAccountBase.isNull(this, index);
    }

    private static boolean isNull(LoginAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAppUITheme() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getIsEnable() == null;
            }
            case 4: {
                return et.getLanguage() == null;
            }
            case 5: {
                return et.getLastChgPwdTime() == null;
            }
            case 6: {
                return et.getLastLoginTime() == null;
            }
            case 7: {
                return et.getLoginAccountId() == null;
            }
            case 8: {
                return et.getLoginAccountName() == null;
            }
            case 9: {
                return et.getOrgAdmin() == null;
            }
            case 10: {
                return et.getPwd() == null;
            }
            case 11: {
                return et.getSuperUser() == null;
            }
            case 12: {
                return et.getUpdateDate() == null;
            }
            case 13: {
                return et.getUpdateMan() == null;
            }
            case 14: {
                return et.getUserData() == null;
            }
            case 15: {
                return et.getUserData2() == null;
            }
            case 16: {
                return et.getUserData3() == null;
            }
            case 17: {
                return et.getUserData4() == null;
            }
            case 18: {
                return et.getUserId() == null;
            }
            case 19: {
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
        return LoginAccountBase.contains(this, index);
    }

    private static boolean contains(LoginAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAppUIThemeDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isIsEnableDirty();
            }
            case 4: {
                return et.isLanguageDirty();
            }
            case 5: {
                return et.isLastChgPwdTimeDirty();
            }
            case 6: {
                return et.isLastLoginTimeDirty();
            }
            case 7: {
                return et.isLoginAccountIdDirty();
            }
            case 8: {
                return et.isLoginAccountNameDirty();
            }
            case 9: {
                return et.isOrgAdminDirty();
            }
            case 10: {
                return et.isPwdDirty();
            }
            case 11: {
                return et.isSuperUserDirty();
            }
            case 12: {
                return et.isUpdateDateDirty();
            }
            case 13: {
                return et.isUpdateManDirty();
            }
            case 14: {
                return et.isUserDataDirty();
            }
            case 15: {
                return et.isUserData2Dirty();
            }
            case 16: {
                return et.isUserData3Dirty();
            }
            case 17: {
                return et.isUserData4Dirty();
            }
            case 18: {
                return et.isUserIdDirty();
            }
            case 19: {
                return et.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        LoginAccountBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(LoginAccountBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAppUITheme() != null) {
            JSONObjectHelper.put(json, "appuitheme", LoginAccountBase.getJSONValue(et.getAppUITheme()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", LoginAccountBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", LoginAccountBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getIsEnable() != null) {
            JSONObjectHelper.put(json, "isenable", LoginAccountBase.getJSONValue(et.getIsEnable()), false);
        }
        if (bIncEmpty || et.getLanguage() != null) {
            JSONObjectHelper.put(json, "language", LoginAccountBase.getJSONValue(et.getLanguage()), false);
        }
        if (bIncEmpty || et.getLastChgPwdTime() != null) {
            JSONObjectHelper.put(json, "lastchgpwdtime", LoginAccountBase.getJSONValue(et.getLastChgPwdTime()), false);
        }
        if (bIncEmpty || et.getLastLoginTime() != null) {
            JSONObjectHelper.put(json, "lastlogintime", LoginAccountBase.getJSONValue(et.getLastLoginTime()), false);
        }
        if (bIncEmpty || et.getLoginAccountId() != null) {
            JSONObjectHelper.put(json, "loginaccountid", LoginAccountBase.getJSONValue(et.getLoginAccountId()), false);
        }
        if (bIncEmpty || et.getLoginAccountName() != null) {
            JSONObjectHelper.put(json, "loginaccountname", LoginAccountBase.getJSONValue(et.getLoginAccountName()), false);
        }
        if (bIncEmpty || et.getOrgAdmin() != null) {
            JSONObjectHelper.put(json, "orgadmin", LoginAccountBase.getJSONValue(et.getOrgAdmin()), false);
        }
        if (bIncEmpty || et.getPwd() != null) {
            JSONObjectHelper.put(json, "pwd", LoginAccountBase.getJSONValue(et.getPwd()), false);
        }
        if (bIncEmpty || et.getSuperUser() != null) {
            JSONObjectHelper.put(json, "superuser", LoginAccountBase.getJSONValue(et.getSuperUser()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", LoginAccountBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", LoginAccountBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", LoginAccountBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", LoginAccountBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            JSONObjectHelper.put(json, "userdata3", LoginAccountBase.getJSONValue(et.getUserData3()), false);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            JSONObjectHelper.put(json, "userdata4", LoginAccountBase.getJSONValue(et.getUserData4()), false);
        }
        if (bIncEmpty || et.getUserId() != null) {
            JSONObjectHelper.put(json, "userid", LoginAccountBase.getJSONValue(et.getUserId()), false);
        }
        if (bIncEmpty || et.getUserName() != null) {
            JSONObjectHelper.put(json, "username", LoginAccountBase.getJSONValue(et.getUserName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        LoginAccountBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(LoginAccountBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAppUITheme() != null) {
            obj = et.getAppUITheme();
            node.setAttribute(FIELD_APPUITHEME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsEnable() != null) {
            obj = et.getIsEnable();
            node.setAttribute(FIELD_ISENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLanguage() != null) {
            obj = et.getLanguage();
            node.setAttribute(FIELD_LANGUAGE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLastChgPwdTime() != null) {
            obj = et.getLastChgPwdTime();
            node.setAttribute(FIELD_LASTCHGPWDTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getLastLoginTime() != null) {
            obj = et.getLastLoginTime();
            node.setAttribute(FIELD_LASTLOGINTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getLoginAccountId() != null) {
            obj = et.getLoginAccountId();
            node.setAttribute(FIELD_LOGINACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLoginAccountName() != null) {
            obj = et.getLoginAccountName();
            node.setAttribute(FIELD_LOGINACCOUNTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrgAdmin() != null) {
            obj = et.getOrgAdmin();
            node.setAttribute(FIELD_ORGADMIN, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getPwd() != null) {
            obj = et.getPwd();
            node.setAttribute(FIELD_PWD, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSuperUser() != null) {
            obj = et.getSuperUser();
            node.setAttribute(FIELD_SUPERUSER, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData() != null) {
            obj = et.getUserData();
            node.setAttribute(FIELD_USERDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            obj = et.getUserData2();
            node.setAttribute(FIELD_USERDATA2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            obj = et.getUserData3();
            node.setAttribute(FIELD_USERDATA3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            obj = et.getUserData4();
            node.setAttribute(FIELD_USERDATA4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserId() != null) {
            obj = et.getUserId();
            node.setAttribute(FIELD_USERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserName() != null) {
            obj = et.getUserName();
            node.setAttribute(FIELD_USERNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        LoginAccountBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(LoginAccountBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAppUIThemeDirty() && (bIncEmpty || et.getAppUITheme() != null)) {
            dst.set(FIELD_APPUITHEME, et.getAppUITheme());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isIsEnableDirty() && (bIncEmpty || et.getIsEnable() != null)) {
            dst.set(FIELD_ISENABLE, et.getIsEnable());
        }
        if (et.isLanguageDirty() && (bIncEmpty || et.getLanguage() != null)) {
            dst.set(FIELD_LANGUAGE, et.getLanguage());
        }
        if (et.isLastChgPwdTimeDirty() && (bIncEmpty || et.getLastChgPwdTime() != null)) {
            dst.set(FIELD_LASTCHGPWDTIME, et.getLastChgPwdTime());
        }
        if (et.isLastLoginTimeDirty() && (bIncEmpty || et.getLastLoginTime() != null)) {
            dst.set(FIELD_LASTLOGINTIME, et.getLastLoginTime());
        }
        if (et.isLoginAccountIdDirty() && (bIncEmpty || et.getLoginAccountId() != null)) {
            dst.set(FIELD_LOGINACCOUNTID, et.getLoginAccountId());
        }
        if (et.isLoginAccountNameDirty() && (bIncEmpty || et.getLoginAccountName() != null)) {
            dst.set(FIELD_LOGINACCOUNTNAME, et.getLoginAccountName());
        }
        if (et.isOrgAdminDirty() && (bIncEmpty || et.getOrgAdmin() != null)) {
            dst.set(FIELD_ORGADMIN, et.getOrgAdmin());
        }
        if (et.isPwdDirty() && (bIncEmpty || et.getPwd() != null)) {
            dst.set(FIELD_PWD, et.getPwd());
        }
        if (et.isSuperUserDirty() && (bIncEmpty || et.getSuperUser() != null)) {
            dst.set(FIELD_SUPERUSER, et.getSuperUser());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDataDirty() && (bIncEmpty || et.getUserData() != null)) {
            dst.set(FIELD_USERDATA, et.getUserData());
        }
        if (et.isUserData2Dirty() && (bIncEmpty || et.getUserData2() != null)) {
            dst.set(FIELD_USERDATA2, et.getUserData2());
        }
        if (et.isUserData3Dirty() && (bIncEmpty || et.getUserData3() != null)) {
            dst.set(FIELD_USERDATA3, et.getUserData3());
        }
        if (et.isUserData4Dirty() && (bIncEmpty || et.getUserData4() != null)) {
            dst.set(FIELD_USERDATA4, et.getUserData4());
        }
        if (et.isUserIdDirty() && (bIncEmpty || et.getUserId() != null)) {
            dst.set(FIELD_USERID, et.getUserId());
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
        return LoginAccountBase.remove(this, index);
    }

    private static boolean remove(LoginAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAppUITheme();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetIsEnable();
                return true;
            }
            case 4: {
                et.resetLanguage();
                return true;
            }
            case 5: {
                et.resetLastChgPwdTime();
                return true;
            }
            case 6: {
                et.resetLastLoginTime();
                return true;
            }
            case 7: {
                et.resetLoginAccountId();
                return true;
            }
            case 8: {
                et.resetLoginAccountName();
                return true;
            }
            case 9: {
                et.resetOrgAdmin();
                return true;
            }
            case 10: {
                et.resetPwd();
                return true;
            }
            case 11: {
                et.resetSuperUser();
                return true;
            }
            case 12: {
                et.resetUpdateDate();
                return true;
            }
            case 13: {
                et.resetUpdateMan();
                return true;
            }
            case 14: {
                et.resetUserData();
                return true;
            }
            case 15: {
                et.resetUserData2();
                return true;
            }
            case 16: {
                et.resetUserData3();
                return true;
            }
            case 17: {
                et.resetUserData4();
                return true;
            }
            case 18: {
                et.resetUserId();
                return true;
            }
            case 19: {
                et.resetUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public User getUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser();
        }
        if (this.getUserId() == null) {
            return null;
        }
        Integer n = this.objUserLock;
        synchronized (n) {
            if (this.user != null && DataTypeHelper.compare(25, (Object)this.getUserId(), (Object)this.user.getUserId()) != 0L) {
                this.user = null;
            }
            if (this.user == null) {
                User user = new User();
                user.setUserId(this.getUserId());
                UserService service = (UserService)ServiceGlobal.getService(UserService.class, this.getSessionFactory());
                service.autoGet(user);
                this.user = user;
            }
            return this.user;
        }
    }

    private LoginAccountBase getProxyEntity() {
        return this.proxyLoginAccountBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyLoginAccountBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof LoginAccountBase) {
            this.proxyLoginAccountBase = (LoginAccountBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.LoginAccountService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

