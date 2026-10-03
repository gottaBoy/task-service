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

import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.service.UserObjectService;

/**
 * 实体[User] 数据对象基类
 */
public abstract class UserBase extends net.ibizsys.psrt.srv.common.entity.UserObject {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[逻辑有效标志]
     */
    public final static String FIELD_ENABLE = "ENABLE";
    /**
     * 属性[系统数据]
     */
    public final static String FIELD_ISSYSTEM = "ISSYSTEM";
    /**
     * 属性[登录名称]
     */
    public final static String FIELD_LOGINNAME = "LOGINNAME";
    /**
     * 属性[登录密码]
     */
    public final static String FIELD_LOGINPWD = "LOGINPWD";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留字段2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[所在时区]
     */
    public final static String FIELD_TIMEZONE = "TIMEZONE";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户标识]
     */
    public final static String FIELD_USERID = "USERID";
    /**
     * 属性[用户模式]
     */
    public final static String FIELD_USERMODE = "USERMODE";
    /**
     * 属性[用户名称]
     */
    public final static String FIELD_USERNAME = "USERNAME";
    /**
     * 属性[是否启用]
     */
    public final static String FIELD_VALIDFLAG = "VALIDFLAG";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_ENABLE = 2;
    private final static int INDEX_ISSYSTEM = 3;
    private final static int INDEX_LOGINNAME = 4;
    private final static int INDEX_LOGINPWD = 5;
    private final static int INDEX_RESERVER = 9;
    private final static int INDEX_RESERVER2 = 10;
    private final static int INDEX_TIMEZONE = 12;
    private final static int INDEX_UPDATEDATE = 13;
    private final static int INDEX_UPDATEMAN = 14;
    private final static int INDEX_USERID = 17;
    private final static int INDEX_USERMODE = 18;
    private final static int INDEX_USERNAME = 19;
    private final static int INDEX_VALIDFLAG = 22;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ENABLE, INDEX_ENABLE);
        fieldIndexMap.put( FIELD_ISSYSTEM, INDEX_ISSYSTEM);
        fieldIndexMap.put( FIELD_LOGINNAME, INDEX_LOGINNAME);
        fieldIndexMap.put( FIELD_LOGINPWD, INDEX_LOGINPWD);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_TIMEZONE, INDEX_TIMEZONE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERID, INDEX_USERID);
        fieldIndexMap.put( FIELD_USERMODE, INDEX_USERMODE);
        fieldIndexMap.put( FIELD_USERNAME, INDEX_USERNAME);
        fieldIndexMap.put( FIELD_VALIDFLAG, INDEX_VALIDFLAG);
    }

    private UserBase proxyUserBase = null;
    public UserBase() {
        super();
        try {
            this.set(UserObject.FIELD_USEROBJECTTYPE,"USER");
        } catch(Exception ex) {

        }
    }
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
     *  设置属性值[系统数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param issystem
     */
    public void setIsSystem(Integer issystem) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsSystem() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    /**
     *  获取属性值[系统数据]是否修改
     */
    public boolean isIsSystemDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    /**
     *  重置属性值[系统数据]
     */
    public void resetIsSystem() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }

        this.issystemDirtyFlag = false;
        this.issystem = null;
    }
    /**
     *  设置属性值[登录名称]
     *  @param loginname
     */
    public void setLoginName(String loginname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLoginName(loginname);
            return;
        }
        if(loginname!=null) {
            loginname = StringHelper.trimRight(loginname);
            if(loginname.length()==0) {
                loginname = null;
            }
        }
        this.loginname = loginname;
        this.loginnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[登录名称]
     */
    public String getLoginName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginName();
        }
        return this.loginname;
    }

    /**
     *  获取属性值[登录名称]是否修改
     */
    public boolean isLoginNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginNameDirty();
        }
        return this.loginnameDirtyFlag;
    }

    /**
     *  重置属性值[登录名称]
     */
    public void resetLoginName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLoginName();
            return;
        }

        this.loginnameDirtyFlag = false;
        this.loginname = null;
    }
    /**
     *  设置属性值[登录密码]
     *  @param loginpwd
     */
    public void setLoginPwd(String loginpwd) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLoginPwd(loginpwd);
            return;
        }
        if(loginpwd!=null) {
            loginpwd = StringHelper.trimRight(loginpwd);
            if(loginpwd.length()==0) {
                loginpwd = null;
            }
        }
        this.loginpwd = loginpwd;
        this.loginpwdDirtyFlag  = true;
    }

    /**
     *  获取属性值[登录密码]
     */
    public String getLoginPwd() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLoginPwd();
        }
        return this.loginpwd;
    }

    /**
     *  获取属性值[登录密码]是否修改
     */
    public boolean isLoginPwdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLoginPwdDirty();
        }
        return this.loginpwdDirtyFlag;
    }

    /**
     *  重置属性值[登录密码]
     */
    public void resetLoginPwd() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLoginPwd();
            return;
        }

        this.loginpwdDirtyFlag = false;
        this.loginpwd = null;
    }
    /**
     *  设置属性值[保留字段]
     *  @param reserver
     */
    public void setReserver(String reserver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if(reserver!=null) {
            reserver = StringHelper.trimRight(reserver);
            if(reserver.length()==0) {
                reserver = null;
            }
        }
        this.reserver = reserver;
        this.reserverDirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[保留字段]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[保留字段]
     */
    public void resetReserver() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver();
            return;
        }

        this.reserverDirtyFlag = false;
        this.reserver = null;
    }
    /**
     *  设置属性值[保留字段2]
     *  @param reserver2
     */
    public void setReserver2(String reserver2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if(reserver2!=null) {
            reserver2 = StringHelper.trimRight(reserver2);
            if(reserver2.length()==0) {
                reserver2 = null;
            }
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[保留字段2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[保留字段2]
     */
    public void resetReserver2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver2();
            return;
        }

        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }
    /**
     *  设置属性值[所在时区]代码表：net.ibizsys.psrt.srv.codelist.CodeList59CodeListModel
     *  @param timezone
     */
    public void setTimeZone(String timezone) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTimeZone(timezone);
            return;
        }
        if(timezone!=null) {
            timezone = StringHelper.trimRight(timezone);
            if(timezone.length()==0) {
                timezone = null;
            }
        }
        this.timezone = timezone;
        this.timezoneDirtyFlag  = true;
    }

    /**
     *  获取属性值[所在时区]代码表：net.ibizsys.psrt.srv.codelist.CodeList59CodeListModel
     */
    public String getTimeZone() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTimeZone();
        }
        return this.timezone;
    }

    /**
     *  获取属性值[所在时区]是否修改
     */
    public boolean isTimeZoneDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTimeZoneDirty();
        }
        return this.timezoneDirtyFlag;
    }

    /**
     *  重置属性值[所在时区]
     */
    public void resetTimeZone() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTimeZone();
            return;
        }

        this.timezoneDirtyFlag = false;
        this.timezone = null;
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
     *  设置属性值[用户标识]
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
        //设置父数据主键
        super.setUserObjectId(userid);
    }

    /**
     *  获取属性值[用户标识]
     */
    public String getUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserId();
        }
        return this.userid;
    }

    /**
     *  获取属性值[用户标识]是否修改
     */
    public boolean isUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserIdDirty();
        }
        return this.useridDirtyFlag;
    }

    /**
     *  重置属性值[用户标识]
     */
    public void resetUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserId();
            return;
        }

        this.useridDirtyFlag = false;
        this.userid = null;
        //设置父数据主键
        super.resetUserObjectId();
    }
    /**
     *  设置属性值[用户模式]
     *  @param usermode
     */
    public void setUserMode(String usermode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserMode(usermode);
            return;
        }
        if(usermode!=null) {
            usermode = StringHelper.trimRight(usermode);
            if(usermode.length()==0) {
                usermode = null;
            }
        }
        this.usermode = usermode;
        this.usermodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户模式]
     */
    public String getUserMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserMode();
        }
        return this.usermode;
    }

    /**
     *  获取属性值[用户模式]是否修改
     */
    public boolean isUserModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserModeDirty();
        }
        return this.usermodeDirtyFlag;
    }

    /**
     *  重置属性值[用户模式]
     */
    public void resetUserMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserMode();
            return;
        }

        this.usermodeDirtyFlag = false;
        this.usermode = null;
    }
    /**
     *  设置属性值[用户名称]
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
        //设置父数据主属性
        super.setUserObjectName(username);
    }

    /**
     *  获取属性值[用户名称]
     */
    public String getUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    /**
     *  获取属性值[用户名称]是否修改
     */
    public boolean isUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    /**
     *  重置属性值[用户名称]
     */
    public void resetUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserName();
            return;
        }

        this.usernameDirtyFlag = false;
        this.username = null;
    }
    /**
     *  设置属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param validflag
     */
    public void setValidFlag(Integer validflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getValidFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    /**
     *  获取属性值[是否启用]是否修改
     */
    public boolean isValidFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    /**
     *  重置属性值[是否启用]
     */
    public void resetValidFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }

        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        UserBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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
        if(!bDirtyOnly || isEnableDirty()) {
            params.put(FIELD_ENABLE,getEnable());
        }
        if(!bDirtyOnly || isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM,getIsSystem());
        }
        if(!bDirtyOnly || isLoginNameDirty()) {
            params.put(FIELD_LOGINNAME,getLoginName());
        }
        if(!bDirtyOnly || isLoginPwdDirty()) {
            params.put(FIELD_LOGINPWD,getLoginPwd());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isTimeZoneDirty()) {
            params.put(FIELD_TIMEZONE,getTimeZone());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserIdDirty()) {
            params.put(FIELD_USERID,getUserId());
        }
        if(!bDirtyOnly || isUserModeDirty()) {
            params.put(FIELD_USERMODE,getUserMode());
        }
        if(!bDirtyOnly || isUserNameDirty()) {
            params.put(FIELD_USERNAME,getUserName());
        }
        if(!bDirtyOnly || isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG,getValidFlag());
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

        return  UserBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(UserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ENABLE:
            return et.getEnable();
        case INDEX_ISSYSTEM:
            return et.getIsSystem();
        case INDEX_LOGINNAME:
            return et.getLoginName();
        case INDEX_LOGINPWD:
            return et.getLoginPwd();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_TIMEZONE:
            return et.getTimeZone();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERID:
            return et.getUserId();
        case INDEX_USERMODE:
            return et.getUserMode();
        case INDEX_USERNAME:
            return et.getUserName();
        case INDEX_VALIDFLAG:
            return et.getValidFlag();
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

        UserBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(UserBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENABLE:
            et.setEnable(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISSYSTEM:
            et.setIsSystem(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_LOGINNAME:
            et.setLoginName(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINPWD:
            et.setLoginPwd(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_TIMEZONE:
            et.setTimeZone(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERID:
            et.setUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERMODE:
            et.setUserMode(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERNAME:
            et.setUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_VALIDFLAG:
            et.setValidFlag(DataObject.getIntegerValue(obj));
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

        return  UserBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(UserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ENABLE:
            return et.getEnable()==null;
        case INDEX_ISSYSTEM:
            return et.getIsSystem()==null;
        case INDEX_LOGINNAME:
            return et.getLoginName()==null;
        case INDEX_LOGINPWD:
            return et.getLoginPwd()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_TIMEZONE:
            return et.getTimeZone()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERID:
            return et.getUserId()==null;
        case INDEX_USERMODE:
            return et.getUserMode()==null;
        case INDEX_USERNAME:
            return et.getUserName()==null;
        case INDEX_VALIDFLAG:
            return et.getValidFlag()==null;
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
        return  UserBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(UserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ENABLE:
            return et.isEnableDirty();
        case INDEX_ISSYSTEM:
            return et.isIsSystemDirty();
        case INDEX_LOGINNAME:
            return et.isLoginNameDirty();
        case INDEX_LOGINPWD:
            return et.isLoginPwdDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_TIMEZONE:
            return et.isTimeZoneDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERID:
            return et.isUserIdDirty();
        case INDEX_USERMODE:
            return et.isUserModeDirty();
        case INDEX_USERNAME:
            return et.isUserNameDirty();
        case INDEX_VALIDFLAG:
            return et.isValidFlagDirty();
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
    private static  void fillJSONObject(UserBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            JSONObjectHelper.put(json,"enable",getJSONValue(et.getEnable()),false);
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            JSONObjectHelper.put(json,"issystem",getJSONValue(et.getIsSystem()),false);
        }
        if(bIncEmpty||et.getLoginName()!=null) {
            JSONObjectHelper.put(json,"loginname",getJSONValue(et.getLoginName()),false);
        }
        if(bIncEmpty||et.getLoginPwd()!=null) {
            JSONObjectHelper.put(json,"loginpwd",getJSONValue(et.getLoginPwd()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getTimeZone()!=null) {
            JSONObjectHelper.put(json,"timezone",getJSONValue(et.getTimeZone()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserId()!=null) {
            JSONObjectHelper.put(json,"userid",getJSONValue(et.getUserId()),false);
        }
        if(bIncEmpty||et.getUserMode()!=null) {
            JSONObjectHelper.put(json,"usermode",getJSONValue(et.getUserMode()),false);
        }
        if(bIncEmpty||et.getUserName()!=null) {
            JSONObjectHelper.put(json,"username",getJSONValue(et.getUserName()),false);
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            JSONObjectHelper.put(json,"validflag",getJSONValue(et.getValidFlag()),false);
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
    private static void fillXmlNode(UserBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            Object obj = et.getEnable();
            node.setAttribute("ENABLE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            Object obj = et.getIsSystem();
            node.setAttribute("ISSYSTEM",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getLoginName()!=null) {
            Object obj = et.getLoginName();
            node.setAttribute("LOGINNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLoginPwd()!=null) {
            Object obj = et.getLoginPwd();
            node.setAttribute("LOGINPWD",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getTimeZone()!=null) {
            Object obj = et.getTimeZone();
            node.setAttribute("TIMEZONE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserId()!=null) {
            Object obj = et.getUserId();
            node.setAttribute("USERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserMode()!=null) {
            Object obj = et.getUserMode();
            node.setAttribute("USERMODE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserName()!=null) {
            Object obj = et.getUserName();
            node.setAttribute("USERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            Object obj = et.getValidFlag();
            node.setAttribute("VALIDFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(UserBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEnableDirty() && (bIncEmpty||et.getEnable()!=null)) {
            dst.set(FIELD_ENABLE,et.getEnable());
        }
        if(et.isIsSystemDirty() && (bIncEmpty||et.getIsSystem()!=null)) {
            dst.set(FIELD_ISSYSTEM,et.getIsSystem());
        }
        if(et.isLoginNameDirty() && (bIncEmpty||et.getLoginName()!=null)) {
            dst.set(FIELD_LOGINNAME,et.getLoginName());
        }
        if(et.isLoginPwdDirty() && (bIncEmpty||et.getLoginPwd()!=null)) {
            dst.set(FIELD_LOGINPWD,et.getLoginPwd());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isTimeZoneDirty() && (bIncEmpty||et.getTimeZone()!=null)) {
            dst.set(FIELD_TIMEZONE,et.getTimeZone());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserIdDirty() && (bIncEmpty||et.getUserId()!=null)) {
            dst.set(FIELD_USERID,et.getUserId());
        }
        if(et.isUserModeDirty() && (bIncEmpty||et.getUserMode()!=null)) {
            dst.set(FIELD_USERMODE,et.getUserMode());
        }
        if(et.isUserNameDirty() && (bIncEmpty||et.getUserName()!=null)) {
            dst.set(FIELD_USERNAME,et.getUserName());
        }
        if(et.isValidFlagDirty() && (bIncEmpty||et.getValidFlag()!=null)) {
            dst.set(FIELD_VALIDFLAG,et.getValidFlag());
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
        return  UserBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(UserBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ENABLE:
            et.resetEnable();
            return true;
        case INDEX_ISSYSTEM:
            et.resetIsSystem();
            return true;
        case INDEX_LOGINNAME:
            et.resetLoginName();
            return true;
        case INDEX_LOGINPWD:
            et.resetLoginPwd();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_TIMEZONE:
            et.resetTimeZone();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USERID:
            et.resetUserId();
            return true;
        case INDEX_USERMODE:
            et.resetUserMode();
            return true;
        case INDEX_USERNAME:
            et.resetUserName();
            return true;
        case INDEX_VALIDFLAG:
            et.resetValidFlag();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private UserBase getProxyEntity() {
        return this.proxyUserBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof UserBase) {
            this.proxyUserBase = (UserBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}