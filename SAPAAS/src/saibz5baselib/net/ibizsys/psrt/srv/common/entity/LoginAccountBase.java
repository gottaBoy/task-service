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
 * 实体[LoginAccount] 数据对象基类
 */
public abstract class LoginAccountBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(LoginAccountBase.class);
    /**
     * 属性[应用界面主题]
     */
    public final static String FIELD_APPUITHEME = "APPUITHEME";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[是否启用]
     */
    public final static String FIELD_ISENABLE = "ISENABLE";
    /**
     * 属性[默认语言]
     */
    public final static String FIELD_LANGUAGE = "LANGUAGE";
    /**
     * 属性[最后修改密码时间]
     */
    public final static String FIELD_LASTCHGPWDTIME = "LASTCHGPWDTIME";
    /**
     * 属性[最后登录时间]
     */
    public final static String FIELD_LASTLOGINTIME = "LASTLOGINTIME";
    /**
     * 属性[登录帐户标识]
     */
    public final static String FIELD_LOGINACCOUNTID = "LOGINACCOUNTID";
    /**
     * 属性[登录帐户]
     */
    public final static String FIELD_LOGINACCOUNTNAME = "LOGINACCOUNTNAME";
    /**
     * 属性[机构管理员]
     */
    public final static String FIELD_ORGADMIN = "ORGADMIN";
    /**
     * 属性[登录密码]
     */
    public final static String FIELD_PWD = "PWD";
    /**
     * 属性[超级用户]
     */
    public final static String FIELD_SUPERUSER = "SUPERUSER";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[USERDATA]
     */
    public final static String FIELD_USERDATA = "USERDATA";
    /**
     * 属性[USERDATA2]
     */
    public final static String FIELD_USERDATA2 = "USERDATA2";
    /**
     * 属性[USERDATA3]
     */
    public final static String FIELD_USERDATA3 = "USERDATA3";
    /**
     * 属性[USERDATA4]
     */
    public final static String FIELD_USERDATA4 = "USERDATA4";
    /**
     * 属性[用户]
     */
    public final static String FIELD_USERID = "USERID";
    /**
     * 属性[用户]
     */
    public final static String FIELD_USERNAME = "USERNAME";

    private final static int INDEX_APPUITHEME = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_ISENABLE = 3;
    private final static int INDEX_LANGUAGE = 4;
    private final static int INDEX_LASTCHGPWDTIME = 5;
    private final static int INDEX_LASTLOGINTIME = 6;
    private final static int INDEX_LOGINACCOUNTID = 7;
    private final static int INDEX_LOGINACCOUNTNAME = 8;
    private final static int INDEX_ORGADMIN = 9;
    private final static int INDEX_PWD = 10;
    private final static int INDEX_SUPERUSER = 11;
    private final static int INDEX_UPDATEDATE = 12;
    private final static int INDEX_UPDATEMAN = 13;
    private final static int INDEX_USERDATA = 14;
    private final static int INDEX_USERDATA2 = 15;
    private final static int INDEX_USERDATA3 = 16;
    private final static int INDEX_USERDATA4 = 17;
    private final static int INDEX_USERID = 18;
    private final static int INDEX_USERNAME = 19;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_APPUITHEME, INDEX_APPUITHEME);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ISENABLE, INDEX_ISENABLE);
        fieldIndexMap.put( FIELD_LANGUAGE, INDEX_LANGUAGE);
        fieldIndexMap.put( FIELD_LASTCHGPWDTIME, INDEX_LASTCHGPWDTIME);
        fieldIndexMap.put( FIELD_LASTLOGINTIME, INDEX_LASTLOGINTIME);
        fieldIndexMap.put( FIELD_LOGINACCOUNTID, INDEX_LOGINACCOUNTID);
        fieldIndexMap.put( FIELD_LOGINACCOUNTNAME, INDEX_LOGINACCOUNTNAME);
        fieldIndexMap.put( FIELD_ORGADMIN, INDEX_ORGADMIN);
        fieldIndexMap.put( FIELD_PWD, INDEX_PWD);
        fieldIndexMap.put( FIELD_SUPERUSER, INDEX_SUPERUSER);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_USERDATA3, INDEX_USERDATA3);
        fieldIndexMap.put( FIELD_USERDATA4, INDEX_USERDATA4);
        fieldIndexMap.put( FIELD_USERID, INDEX_USERID);
        fieldIndexMap.put( FIELD_USERNAME, INDEX_USERNAME);
    }

    private LoginAccountBase proxyLoginAccountBase = null;
    public LoginAccountBase() {
        super();
    }
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


    /**
     *  设置属性值[应用界面主题]代码表：net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel
     *  @param appuitheme
     */
    public void setAppUITheme(String appuitheme) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAppUITheme(appuitheme);
            return;
        }
        if(appuitheme!=null) {
            appuitheme = StringHelper.trimRight(appuitheme);
            if(appuitheme.length()==0) {
                appuitheme = null;
            }
        }
        this.appuitheme = appuitheme;
        this.appuithemeDirtyFlag  = true;
    }

    /**
     *  获取属性值[应用界面主题]代码表：net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel
     */
    public String getAppUITheme() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAppUITheme();
        }
        return this.appuitheme;
    }

    /**
     *  获取属性值[应用界面主题]是否修改
     */
    public boolean isAppUIThemeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAppUIThemeDirty();
        }
        return this.appuithemeDirtyFlag;
    }

    /**
     *  重置属性值[应用界面主题]
     */
    public void resetAppUITheme() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAppUITheme();
            return;
        }

        this.appuithemeDirtyFlag = false;
        this.appuitheme = null;
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
     *  设置属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isenable
     */
    public void setIsEnable(Integer isenable) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsEnable(isenable);
            return;
        }
        this.isenable = isenable;
        this.isenableDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsEnable() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsEnable();
        }
        return this.isenable;
    }

    /**
     *  获取属性值[是否启用]是否修改
     */
    public boolean isIsEnableDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsEnableDirty();
        }
        return this.isenableDirtyFlag;
    }

    /**
     *  重置属性值[是否启用]
     */
    public void resetIsEnable() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsEnable();
            return;
        }

        this.isenableDirtyFlag = false;
        this.isenable = null;
    }
    /**
     *  设置属性值[默认语言]代码表：net.ibizsys.psrt.srv.codelist.CodeList56CodeListModel
     *  @param language
     */
    public void setLanguage(String language) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLanguage(language);
            return;
        }
        if(language!=null) {
            language = StringHelper.trimRight(language);
            if(language.length()==0) {
                language = null;
            }
        }
        this.language = language;
        this.languageDirtyFlag  = true;
    }

    /**
     *  获取属性值[默认语言]代码表：net.ibizsys.psrt.srv.codelist.CodeList56CodeListModel
     */
    public String getLanguage() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLanguage();
        }
        return this.language;
    }

    /**
     *  获取属性值[默认语言]是否修改
     */
    public boolean isLanguageDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLanguageDirty();
        }
        return this.languageDirtyFlag;
    }

    /**
     *  重置属性值[默认语言]
     */
    public void resetLanguage() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLanguage();
            return;
        }

        this.languageDirtyFlag = false;
        this.language = null;
    }
    /**
     *  设置属性值[最后修改密码时间]
     *  @param lastchgpwdtime
     */
    public void setLastChgPwdTime(Timestamp lastchgpwdtime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLastChgPwdTime(lastchgpwdtime);
            return;
        }
        this.lastchgpwdtime = lastchgpwdtime;
        this.lastchgpwdtimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[最后修改密码时间]
     */
    public Timestamp getLastChgPwdTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLastChgPwdTime();
        }
        return this.lastchgpwdtime;
    }

    /**
     *  获取属性值[最后修改密码时间]是否修改
     */
    public boolean isLastChgPwdTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLastChgPwdTimeDirty();
        }
        return this.lastchgpwdtimeDirtyFlag;
    }

    /**
     *  重置属性值[最后修改密码时间]
     */
    public void resetLastChgPwdTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLastChgPwdTime();
            return;
        }

        this.lastchgpwdtimeDirtyFlag = false;
        this.lastchgpwdtime = null;
    }
    /**
     *  设置属性值[最后登录时间]
     *  @param lastlogintime
     */
    public void setLastLoginTime(Timestamp lastlogintime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLastLoginTime(lastlogintime);
            return;
        }
        this.lastlogintime = lastlogintime;
        this.lastlogintimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[最后登录时间]
     */
    public Timestamp getLastLoginTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLastLoginTime();
        }
        return this.lastlogintime;
    }

    /**
     *  获取属性值[最后登录时间]是否修改
     */
    public boolean isLastLoginTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLastLoginTimeDirty();
        }
        return this.lastlogintimeDirtyFlag;
    }

    /**
     *  重置属性值[最后登录时间]
     */
    public void resetLastLoginTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLastLoginTime();
            return;
        }

        this.lastlogintimeDirtyFlag = false;
        this.lastlogintime = null;
    }
    /**
     *  设置属性值[登录帐户标识]
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
     *  获取属性值[登录帐户标识]
     */
    public String getLoginAccountId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginAccountId();
        }
        return this.loginaccountid;
    }

    /**
     *  获取属性值[登录帐户标识]是否修改
     */
    public boolean isLoginAccountIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginAccountIdDirty();
        }
        return this.loginaccountidDirtyFlag;
    }

    /**
     *  重置属性值[登录帐户标识]
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
        if(loginaccountname!=null) {
            loginaccountname = loginaccountname.toLowerCase();
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
     *  设置属性值[机构管理员]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param orgadmin
     */
    public void setOrgAdmin(Integer orgadmin) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrgAdmin(orgadmin);
            return;
        }
        this.orgadmin = orgadmin;
        this.orgadminDirtyFlag  = true;
    }

    /**
     *  获取属性值[机构管理员]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getOrgAdmin() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrgAdmin();
        }
        return this.orgadmin;
    }

    /**
     *  获取属性值[机构管理员]是否修改
     */
    public boolean isOrgAdminDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrgAdminDirty();
        }
        return this.orgadminDirtyFlag;
    }

    /**
     *  重置属性值[机构管理员]
     */
    public void resetOrgAdmin() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrgAdmin();
            return;
        }

        this.orgadminDirtyFlag = false;
        this.orgadmin = null;
    }
    /**
     *  设置属性值[登录密码]
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
     *  获取属性值[登录密码]
     */
    public String getPwd() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPwd();
        }
        return this.pwd;
    }

    /**
     *  获取属性值[登录密码]是否修改
     */
    public boolean isPwdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPwdDirty();
        }
        return this.pwdDirtyFlag;
    }

    /**
     *  重置属性值[登录密码]
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
     *  设置属性值[超级用户]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param superuser
     */
    public void setSuperUser(Integer superuser) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSuperUser(superuser);
            return;
        }
        this.superuser = superuser;
        this.superuserDirtyFlag  = true;
    }

    /**
     *  获取属性值[超级用户]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getSuperUser() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSuperUser();
        }
        return this.superuser;
    }

    /**
     *  获取属性值[超级用户]是否修改
     */
    public boolean isSuperUserDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSuperUserDirty();
        }
        return this.superuserDirtyFlag;
    }

    /**
     *  重置属性值[超级用户]
     */
    public void resetSuperUser() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSuperUser();
            return;
        }

        this.superuserDirtyFlag = false;
        this.superuser = null;
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
     *  设置属性值[USERDATA]
     *  @param userdata
     */
    public void setUserData(String userdata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if(userdata!=null) {
            userdata = StringHelper.trimRight(userdata);
            if(userdata.length()==0) {
                userdata = null;
            }
        }
        this.userdata = userdata;
        this.userdataDirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATA]
     */
    public String getUserData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    /**
     *  获取属性值[USERDATA]是否修改
     */
    public boolean isUserDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    /**
     *  重置属性值[USERDATA]
     */
    public void resetUserData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData();
            return;
        }

        this.userdataDirtyFlag = false;
        this.userdata = null;
    }
    /**
     *  设置属性值[USERDATA2]
     *  @param userdata2
     */
    public void setUserData2(String userdata2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if(userdata2!=null) {
            userdata2 = StringHelper.trimRight(userdata2);
            if(userdata2.length()==0) {
                userdata2 = null;
            }
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATA2]
     */
    public String getUserData2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    /**
     *  获取属性值[USERDATA2]是否修改
     */
    public boolean isUserData2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    /**
     *  重置属性值[USERDATA2]
     */
    public void resetUserData2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData2();
            return;
        }

        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }
    /**
     *  设置属性值[USERDATA3]
     *  @param userdata3
     */
    public void setUserData3(String userdata3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData3(userdata3);
            return;
        }
        if(userdata3!=null) {
            userdata3 = StringHelper.trimRight(userdata3);
            if(userdata3.length()==0) {
                userdata3 = null;
            }
        }
        this.userdata3 = userdata3;
        this.userdata3DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATA3]
     */
    public String getUserData3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    /**
     *  获取属性值[USERDATA3]是否修改
     */
    public boolean isUserData3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    /**
     *  重置属性值[USERDATA3]
     */
    public void resetUserData3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData3();
            return;
        }

        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }
    /**
     *  设置属性值[USERDATA4]
     *  @param userdata4
     */
    public void setUserData4(String userdata4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData4(userdata4);
            return;
        }
        if(userdata4!=null) {
            userdata4 = StringHelper.trimRight(userdata4);
            if(userdata4.length()==0) {
                userdata4 = null;
            }
        }
        this.userdata4 = userdata4;
        this.userdata4DirtyFlag  = true;
    }

    /**
     *  获取属性值[USERDATA4]
     */
    public String getUserData4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    /**
     *  获取属性值[USERDATA4]是否修改
     */
    public boolean isUserData4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    /**
     *  重置属性值[USERDATA4]
     */
    public void resetUserData4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData4();
            return;
        }

        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
    }
    /**
     *  设置属性值[用户]
     *  @param userid
     */
    public void setUserId(String userid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserId(userid);
            return;
        }
        if(userid!=null) {
            userid = StringHelper.trimRight(userid);
            if(userid.length()==0) {
                userid = null;
            }
        }
        this.userid = userid;
        this.useridDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户]
     */
    public String getUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserId();
        }
        return this.userid;
    }

    /**
     *  获取属性值[用户]是否修改
     */
    public boolean isUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserIdDirty();
        }
        return this.useridDirtyFlag;
    }

    /**
     *  重置属性值[用户]
     */
    public void resetUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserId();
            return;
        }

        this.useridDirtyFlag = false;
        this.userid = null;
    }
    /**
     *  设置属性值[用户]
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
     *  获取属性值[用户]
     */
    public String getUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    /**
     *  获取属性值[用户]是否修改
     */
    public boolean isUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    /**
     *  重置属性值[用户]
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
        LoginAccountBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isAppUIThemeDirty()) {
            params.put(FIELD_APPUITHEME,getAppUITheme());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isIsEnableDirty()) {
            params.put(FIELD_ISENABLE,getIsEnable());
        }
        if(!bDirtyOnly || isLanguageDirty()) {
            params.put(FIELD_LANGUAGE,getLanguage());
        }
        if(!bDirtyOnly || isLastChgPwdTimeDirty()) {
            params.put(FIELD_LASTCHGPWDTIME,getLastChgPwdTime());
        }
        if(!bDirtyOnly || isLastLoginTimeDirty()) {
            params.put(FIELD_LASTLOGINTIME,getLastLoginTime());
        }
        if(!bDirtyOnly || isLoginAccountIdDirty()) {
            params.put(FIELD_LOGINACCOUNTID,getLoginAccountId());
        }
        if(!bDirtyOnly || isLoginAccountNameDirty()) {
            params.put(FIELD_LOGINACCOUNTNAME,getLoginAccountName());
        }
        if(!bDirtyOnly || isOrgAdminDirty()) {
            params.put(FIELD_ORGADMIN,getOrgAdmin());
        }
        if(!bDirtyOnly || isPwdDirty()) {
            params.put(FIELD_PWD,getPwd());
        }
        if(!bDirtyOnly || isSuperUserDirty()) {
            params.put(FIELD_SUPERUSER,getSuperUser());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserDataDirty()) {
            params.put(FIELD_USERDATA,getUserData());
        }
        if(!bDirtyOnly || isUserData2Dirty()) {
            params.put(FIELD_USERDATA2,getUserData2());
        }
        if(!bDirtyOnly || isUserData3Dirty()) {
            params.put(FIELD_USERDATA3,getUserData3());
        }
        if(!bDirtyOnly || isUserData4Dirty()) {
            params.put(FIELD_USERDATA4,getUserData4());
        }
        if(!bDirtyOnly || isUserIdDirty()) {
            params.put(FIELD_USERID,getUserId());
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

        return  LoginAccountBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(LoginAccountBase et,int index) throws Exception {

        switch(index) {
        case INDEX_APPUITHEME:
            return et.getAppUITheme();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ISENABLE:
            return et.getIsEnable();
        case INDEX_LANGUAGE:
            return et.getLanguage();
        case INDEX_LASTCHGPWDTIME:
            return et.getLastChgPwdTime();
        case INDEX_LASTLOGINTIME:
            return et.getLastLoginTime();
        case INDEX_LOGINACCOUNTID:
            return et.getLoginAccountId();
        case INDEX_LOGINACCOUNTNAME:
            return et.getLoginAccountName();
        case INDEX_ORGADMIN:
            return et.getOrgAdmin();
        case INDEX_PWD:
            return et.getPwd();
        case INDEX_SUPERUSER:
            return et.getSuperUser();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA2:
            return et.getUserData2();
        case INDEX_USERDATA3:
            return et.getUserData3();
        case INDEX_USERDATA4:
            return et.getUserData4();
        case INDEX_USERID:
            return et.getUserId();
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

        LoginAccountBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(LoginAccountBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_APPUITHEME:
            et.setAppUITheme(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISENABLE:
            et.setIsEnable(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_LANGUAGE:
            et.setLanguage(DataObject.getStringValue(obj));
            return ;
        case INDEX_LASTCHGPWDTIME:
            et.setLastChgPwdTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_LASTLOGINTIME:
            et.setLastLoginTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_LOGINACCOUNTID:
            et.setLoginAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINACCOUNTNAME:
            et.setLoginAccountName(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORGADMIN:
            et.setOrgAdmin(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_PWD:
            et.setPwd(DataObject.getStringValue(obj));
            return ;
        case INDEX_SUPERUSER:
            et.setSuperUser(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA:
            et.setUserData(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA2:
            et.setUserData2(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA3:
            et.setUserData3(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA4:
            et.setUserData4(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERID:
            et.setUserId(DataObject.getStringValue(obj));
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

        return  LoginAccountBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(LoginAccountBase et,int index) throws Exception {

        switch(index) {
        case INDEX_APPUITHEME:
            return et.getAppUITheme()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ISENABLE:
            return et.getIsEnable()==null;
        case INDEX_LANGUAGE:
            return et.getLanguage()==null;
        case INDEX_LASTCHGPWDTIME:
            return et.getLastChgPwdTime()==null;
        case INDEX_LASTLOGINTIME:
            return et.getLastLoginTime()==null;
        case INDEX_LOGINACCOUNTID:
            return et.getLoginAccountId()==null;
        case INDEX_LOGINACCOUNTNAME:
            return et.getLoginAccountName()==null;
        case INDEX_ORGADMIN:
            return et.getOrgAdmin()==null;
        case INDEX_PWD:
            return et.getPwd()==null;
        case INDEX_SUPERUSER:
            return et.getSuperUser()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA2:
            return et.getUserData2()==null;
        case INDEX_USERDATA3:
            return et.getUserData3()==null;
        case INDEX_USERDATA4:
            return et.getUserData4()==null;
        case INDEX_USERID:
            return et.getUserId()==null;
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
        return  LoginAccountBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(LoginAccountBase et,int index) throws Exception {

        switch(index) {
        case INDEX_APPUITHEME:
            return et.isAppUIThemeDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ISENABLE:
            return et.isIsEnableDirty();
        case INDEX_LANGUAGE:
            return et.isLanguageDirty();
        case INDEX_LASTCHGPWDTIME:
            return et.isLastChgPwdTimeDirty();
        case INDEX_LASTLOGINTIME:
            return et.isLastLoginTimeDirty();
        case INDEX_LOGINACCOUNTID:
            return et.isLoginAccountIdDirty();
        case INDEX_LOGINACCOUNTNAME:
            return et.isLoginAccountNameDirty();
        case INDEX_ORGADMIN:
            return et.isOrgAdminDirty();
        case INDEX_PWD:
            return et.isPwdDirty();
        case INDEX_SUPERUSER:
            return et.isSuperUserDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA2:
            return et.isUserData2Dirty();
        case INDEX_USERDATA3:
            return et.isUserData3Dirty();
        case INDEX_USERDATA4:
            return et.isUserData4Dirty();
        case INDEX_USERID:
            return et.isUserIdDirty();
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
    private static  void fillJSONObject(LoginAccountBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAppUITheme()!=null) {
            JSONObjectHelper.put(json,"appuitheme",getJSONValue(et.getAppUITheme()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getIsEnable()!=null) {
            JSONObjectHelper.put(json,"isenable",getJSONValue(et.getIsEnable()),false);
        }
        if(bIncEmpty||et.getLanguage()!=null) {
            JSONObjectHelper.put(json,"language",getJSONValue(et.getLanguage()),false);
        }
        if(bIncEmpty||et.getLastChgPwdTime()!=null) {
            JSONObjectHelper.put(json,"lastchgpwdtime",getJSONValue(et.getLastChgPwdTime()),false);
        }
        if(bIncEmpty||et.getLastLoginTime()!=null) {
            JSONObjectHelper.put(json,"lastlogintime",getJSONValue(et.getLastLoginTime()),false);
        }
        if(bIncEmpty||et.getLoginAccountId()!=null) {
            JSONObjectHelper.put(json,"loginaccountid",getJSONValue(et.getLoginAccountId()),false);
        }
        if(bIncEmpty||et.getLoginAccountName()!=null) {
            JSONObjectHelper.put(json,"loginaccountname",getJSONValue(et.getLoginAccountName()),false);
        }
        if(bIncEmpty||et.getOrgAdmin()!=null) {
            JSONObjectHelper.put(json,"orgadmin",getJSONValue(et.getOrgAdmin()),false);
        }
        if(bIncEmpty||et.getPwd()!=null) {
            JSONObjectHelper.put(json,"pwd",getJSONValue(et.getPwd()),false);
        }
        if(bIncEmpty||et.getSuperUser()!=null) {
            JSONObjectHelper.put(json,"superuser",getJSONValue(et.getSuperUser()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            JSONObjectHelper.put(json,"userdata",getJSONValue(et.getUserData()),false);
        }
        if(bIncEmpty||et.getUserData2()!=null) {
            JSONObjectHelper.put(json,"userdata2",getJSONValue(et.getUserData2()),false);
        }
        if(bIncEmpty||et.getUserData3()!=null) {
            JSONObjectHelper.put(json,"userdata3",getJSONValue(et.getUserData3()),false);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            JSONObjectHelper.put(json,"userdata4",getJSONValue(et.getUserData4()),false);
        }
        if(bIncEmpty||et.getUserId()!=null) {
            JSONObjectHelper.put(json,"userid",getJSONValue(et.getUserId()),false);
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
    private static void fillXmlNode(LoginAccountBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAppUITheme()!=null) {
            Object obj = et.getAppUITheme();
            node.setAttribute("APPUITHEME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsEnable()!=null) {
            Object obj = et.getIsEnable();
            node.setAttribute("ISENABLE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getLanguage()!=null) {
            Object obj = et.getLanguage();
            node.setAttribute("LANGUAGE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLastChgPwdTime()!=null) {
            Object obj = et.getLastChgPwdTime();
            node.setAttribute("LASTCHGPWDTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getLastLoginTime()!=null) {
            Object obj = et.getLastLoginTime();
            node.setAttribute("LASTLOGINTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getLoginAccountId()!=null) {
            Object obj = et.getLoginAccountId();
            node.setAttribute("LOGINACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLoginAccountName()!=null) {
            Object obj = et.getLoginAccountName();
            node.setAttribute("LOGINACCOUNTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOrgAdmin()!=null) {
            Object obj = et.getOrgAdmin();
            node.setAttribute("ORGADMIN",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getPwd()!=null) {
            Object obj = et.getPwd();
            node.setAttribute("PWD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSuperUser()!=null) {
            Object obj = et.getSuperUser();
            node.setAttribute("SUPERUSER",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData()!=null) {
            Object obj = et.getUserData();
            node.setAttribute("USERDATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData2()!=null) {
            Object obj = et.getUserData2();
            node.setAttribute("USERDATA2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData3()!=null) {
            Object obj = et.getUserData3();
            node.setAttribute("USERDATA3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            Object obj = et.getUserData4();
            node.setAttribute("USERDATA4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserId()!=null) {
            Object obj = et.getUserId();
            node.setAttribute("USERID",(obj==null)?"":(String)obj);
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
        LoginAccountBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(LoginAccountBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isAppUIThemeDirty() && (bIncEmpty||et.getAppUITheme()!=null)) {
            dst.set(FIELD_APPUITHEME,et.getAppUITheme());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isIsEnableDirty() && (bIncEmpty||et.getIsEnable()!=null)) {
            dst.set(FIELD_ISENABLE,et.getIsEnable());
        }
        if(et.isLanguageDirty() && (bIncEmpty||et.getLanguage()!=null)) {
            dst.set(FIELD_LANGUAGE,et.getLanguage());
        }
        if(et.isLastChgPwdTimeDirty() && (bIncEmpty||et.getLastChgPwdTime()!=null)) {
            dst.set(FIELD_LASTCHGPWDTIME,et.getLastChgPwdTime());
        }
        if(et.isLastLoginTimeDirty() && (bIncEmpty||et.getLastLoginTime()!=null)) {
            dst.set(FIELD_LASTLOGINTIME,et.getLastLoginTime());
        }
        if(et.isLoginAccountIdDirty() && (bIncEmpty||et.getLoginAccountId()!=null)) {
            dst.set(FIELD_LOGINACCOUNTID,et.getLoginAccountId());
        }
        if(et.isLoginAccountNameDirty() && (bIncEmpty||et.getLoginAccountName()!=null)) {
            dst.set(FIELD_LOGINACCOUNTNAME,et.getLoginAccountName());
        }
        if(et.isOrgAdminDirty() && (bIncEmpty||et.getOrgAdmin()!=null)) {
            dst.set(FIELD_ORGADMIN,et.getOrgAdmin());
        }
        if(et.isPwdDirty() && (bIncEmpty||et.getPwd()!=null)) {
            dst.set(FIELD_PWD,et.getPwd());
        }
        if(et.isSuperUserDirty() && (bIncEmpty||et.getSuperUser()!=null)) {
            dst.set(FIELD_SUPERUSER,et.getSuperUser());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserDataDirty() && (bIncEmpty||et.getUserData()!=null)) {
            dst.set(FIELD_USERDATA,et.getUserData());
        }
        if(et.isUserData2Dirty() && (bIncEmpty||et.getUserData2()!=null)) {
            dst.set(FIELD_USERDATA2,et.getUserData2());
        }
        if(et.isUserData3Dirty() && (bIncEmpty||et.getUserData3()!=null)) {
            dst.set(FIELD_USERDATA3,et.getUserData3());
        }
        if(et.isUserData4Dirty() && (bIncEmpty||et.getUserData4()!=null)) {
            dst.set(FIELD_USERDATA4,et.getUserData4());
        }
        if(et.isUserIdDirty() && (bIncEmpty||et.getUserId()!=null)) {
            dst.set(FIELD_USERID,et.getUserId());
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
        return  LoginAccountBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(LoginAccountBase et,int index) throws Exception {
        switch(index) {
        case INDEX_APPUITHEME:
            et.resetAppUITheme();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ISENABLE:
            et.resetIsEnable();
            return true;
        case INDEX_LANGUAGE:
            et.resetLanguage();
            return true;
        case INDEX_LASTCHGPWDTIME:
            et.resetLastChgPwdTime();
            return true;
        case INDEX_LASTLOGINTIME:
            et.resetLastLoginTime();
            return true;
        case INDEX_LOGINACCOUNTID:
            et.resetLoginAccountId();
            return true;
        case INDEX_LOGINACCOUNTNAME:
            et.resetLoginAccountName();
            return true;
        case INDEX_ORGADMIN:
            et.resetOrgAdmin();
            return true;
        case INDEX_PWD:
            et.resetPwd();
            return true;
        case INDEX_SUPERUSER:
            et.resetSuperUser();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERDATA:
            et.resetUserData();
            return true;
        case INDEX_USERDATA2:
            et.resetUserData2();
            return true;
        case INDEX_USERDATA3:
            et.resetUserData3();
            return true;
        case INDEX_USERDATA4:
            et.resetUserData4();
            return true;
        case INDEX_USERID:
            et.resetUserId();
            return true;
        case INDEX_USERNAME:
            et.resetUserName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.User user = null;
    /**
    * 获取父数据 用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.User getUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUser();
        }

        if(this.getUserId()==null)
            return null;
        synchronized(this.objUserLock) {
            if(this.user!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getUserId(),user.getUserId())!=0) {
                    this.user = null;
                }
            }


            if(this.user==null) {
                net.ibizsys.psrt.srv.common.entity.User user = new net.ibizsys.psrt.srv.common.entity.User();
                user.setUserId(this.getUserId());
                net.ibizsys.psrt.srv.common.service.UserService service = (net.ibizsys.psrt.srv.common.service.UserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserService.class,this.getSessionFactory());
                service.autoGet(user);
                this.user = user;
            }
            return this.user;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private LoginAccountBase getProxyEntity() {
        return this.proxyLoginAccountBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyLoginAccountBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof LoginAccountBase) {
            this.proxyLoginAccountBase = (LoginAccountBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.LoginAccountService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}