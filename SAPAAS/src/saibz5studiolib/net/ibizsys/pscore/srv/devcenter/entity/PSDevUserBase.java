/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObj;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserBase
extends PSDevUserObj {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevUserBase.class);
    public static final String FIELD_ADMINMODE = "ADMINMODE";
    public static final String FIELD_AIAGENTMODE = "AIAGENTMODE";
    public static final String FIELD_ALIASPSDEVUSERID = "ALIASPSDEVUSERID";
    public static final String FIELD_ALIASPSDEVUSERNAME = "ALIASPSDEVUSERNAME";
    public static final String FIELD_ALIASUSERMODE = "ALIASUSERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_FROMLOGINNAME = "FROMLOGINNAME";
    public static final String FIELD_FROMPSDCID = "FROMPSDCID";
    public static final String FIELD_FROMPSDCNAME = "FROMPSDCNAME";
    public static final String FIELD_FROMPSDEVUSERID = "FROMPSDEVUSERID";
    public static final String FIELD_FROMPSDEVUSERNAME = "FROMPSDEVUSERNAME";
    public static final String FIELD_FROMUSERMODE = "FROMUSERMODE";
    public static final String FIELD_FULLLOGINNAME = "FULLLOGINNAME";
    public static final String FIELD_FULLLOGINNAME2 = "FULLLOGINNAME2";
    public static final String FIELD_LOGINNAME = "LOGINNAME";
    public static final String FIELD_LOGINPWD = "LOGINPWD";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERMODE = "USERMODE";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ADMINMODE = 0;
    private static final int INDEX_AIAGENTMODE = 1;
    private static final int INDEX_ALIASPSDEVUSERID = 2;
    private static final int INDEX_ALIASPSDEVUSERNAME = 3;
    private static final int INDEX_ALIASUSERMODE = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_ENABLE = 12;
    private static final int INDEX_FROMLOGINNAME = 13;
    private static final int INDEX_FROMPSDCID = 14;
    private static final int INDEX_FROMPSDCNAME = 15;
    private static final int INDEX_FROMPSDEVUSERID = 16;
    private static final int INDEX_FROMPSDEVUSERNAME = 17;
    private static final int INDEX_FROMUSERMODE = 18;
    private static final int INDEX_FULLLOGINNAME = 19;
    private static final int INDEX_FULLLOGINNAME2 = 20;
    private static final int INDEX_LOGINNAME = 21;
    private static final int INDEX_LOGINPWD = 22;
    private static final int INDEX_PSDEVUSERID = 26;
    private static final int INDEX_PSDEVUSERNAME = 27;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERMODE = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevUserBase proxyPSDevUserBase = null;
    private boolean adminmodeDirtyFlag = false;
    private boolean aiagentmodeDirtyFlag = false;
    private boolean aliaspsdevuseridDirtyFlag = false;
    private boolean aliaspsdevusernameDirtyFlag = false;
    private boolean aliasusermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean fromloginnameDirtyFlag = false;
    private boolean frompsdcidDirtyFlag = false;
    private boolean frompsdcnameDirtyFlag = false;
    private boolean frompsdevuseridDirtyFlag = false;
    private boolean frompsdevusernameDirtyFlag = false;
    private boolean fromusermodeDirtyFlag = false;
    private boolean fullloginnameDirtyFlag = false;
    private boolean fullloginname2DirtyFlag = false;
    private boolean loginnameDirtyFlag = false;
    private boolean loginpwdDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usermodeDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="adminmode")
    private Integer adminmode;
    @Column(name="aiagentmode")
    private String aiagentmode;
    @Column(name="aliaspsdevuserid")
    private String aliaspsdevuserid;
    @Column(name="aliaspsdevusername")
    private String aliaspsdevusername;
    @Column(name="aliasusermode")
    private Integer aliasusermode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="fromloginname")
    private String fromloginname;
    @Column(name="frompsdcid")
    private String frompsdcid;
    @Column(name="frompsdcname")
    private String frompsdcname;
    @Column(name="frompsdevuserid")
    private String frompsdevuserid;
    @Column(name="frompsdevusername")
    private String frompsdevusername;
    @Column(name="fromusermode")
    private Integer fromusermode;
    @Column(name="fullloginname")
    private String fullloginname;
    @Column(name="fullloginname2")
    private String fullloginname2;
    @Column(name="loginname")
    private String loginname;
    @Column(name="loginpwd")
    private String loginpwd;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usermode")
    private String usermode;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;

    public PSDevUserBase() {
        try {
            this.set("PSDEVUSEROBJTYPE", "USER");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void setAdminMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminMode(n);
            return;
        }
        this.adminmode = n;
        this.adminmodeDirtyFlag = true;
    }

    public Integer getAdminMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminMode();
        }
        return this.adminmode;
    }

    public boolean isAdminModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminModeDirty();
        }
        return this.adminmodeDirtyFlag;
    }

    public void resetAdminMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminMode();
            return;
        }
        this.adminmodeDirtyFlag = false;
        this.adminmode = null;
    }

    public void setAIAgentMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIAgentMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiagentmode = string;
        this.aiagentmodeDirtyFlag = true;
    }

    public String getAIAgentMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIAgentMode();
        }
        return this.aiagentmode;
    }

    public boolean isAIAgentModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIAgentModeDirty();
        }
        return this.aiagentmodeDirtyFlag;
    }

    public void resetAIAgentMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIAgentMode();
            return;
        }
        this.aiagentmodeDirtyFlag = false;
        this.aiagentmode = null;
    }

    public void setAliasPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAliasPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aliaspsdevuserid = string;
        this.aliaspsdevuseridDirtyFlag = true;
    }

    public String getAliasPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAliasPSDevUserId();
        }
        return this.aliaspsdevuserid;
    }

    public boolean isAliasPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAliasPSDevUserIdDirty();
        }
        return this.aliaspsdevuseridDirtyFlag;
    }

    public void resetAliasPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAliasPSDevUserId();
            return;
        }
        this.aliaspsdevuseridDirtyFlag = false;
        this.aliaspsdevuserid = null;
    }

    public void setAliasPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAliasPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aliaspsdevusername = string;
        this.aliaspsdevusernameDirtyFlag = true;
    }

    public String getAliasPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAliasPSDevUserName();
        }
        return this.aliaspsdevusername;
    }

    public boolean isAliasPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAliasPSDevUserNameDirty();
        }
        return this.aliaspsdevusernameDirtyFlag;
    }

    public void resetAliasPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAliasPSDevUserName();
            return;
        }
        this.aliaspsdevusernameDirtyFlag = false;
        this.aliaspsdevusername = null;
    }

    public void setAliasUserMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAliasUserMode(n);
            return;
        }
        this.aliasusermode = n;
        this.aliasusermodeDirtyFlag = true;
    }

    public Integer getAliasUserMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAliasUserMode();
        }
        return this.aliasusermode;
    }

    public boolean isAliasUserModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAliasUserModeDirty();
        }
        return this.aliasusermodeDirtyFlag;
    }

    public void resetAliasUserMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAliasUserMode();
            return;
        }
        this.aliasusermodeDirtyFlag = false;
        this.aliasusermode = null;
    }

    @Override
    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
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
    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
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
    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
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

    public void setFromLoginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromLoginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fromloginname = string;
        this.fromloginnameDirtyFlag = true;
    }

    public String getFromLoginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromLoginName();
        }
        return this.fromloginname;
    }

    public boolean isFromLoginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromLoginNameDirty();
        }
        return this.fromloginnameDirtyFlag;
    }

    public void resetFromLoginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromLoginName();
            return;
        }
        this.fromloginnameDirtyFlag = false;
        this.fromloginname = null;
    }

    public void setFromPSDCId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDCId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdcid = string;
        this.frompsdcidDirtyFlag = true;
    }

    public String getFromPSDCId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDCId();
        }
        return this.frompsdcid;
    }

    public boolean isFromPSDCIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDCIdDirty();
        }
        return this.frompsdcidDirtyFlag;
    }

    public void resetFromPSDCId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDCId();
            return;
        }
        this.frompsdcidDirtyFlag = false;
        this.frompsdcid = null;
    }

    public void setFromPSDCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdcname = string;
        this.frompsdcnameDirtyFlag = true;
    }

    public String getFromPSDCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDCName();
        }
        return this.frompsdcname;
    }

    public boolean isFromPSDCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDCNameDirty();
        }
        return this.frompsdcnameDirtyFlag;
    }

    public void resetFromPSDCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDCName();
            return;
        }
        this.frompsdcnameDirtyFlag = false;
        this.frompsdcname = null;
    }

    public void setFromPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdevuserid = string;
        this.frompsdevuseridDirtyFlag = true;
    }

    public String getFromPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDevUserId();
        }
        return this.frompsdevuserid;
    }

    public boolean isFromPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDevUserIdDirty();
        }
        return this.frompsdevuseridDirtyFlag;
    }

    public void resetFromPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDevUserId();
            return;
        }
        this.frompsdevuseridDirtyFlag = false;
        this.frompsdevuserid = null;
    }

    public void setFromPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdevusername = string;
        this.frompsdevusernameDirtyFlag = true;
    }

    public String getFromPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDevUserName();
        }
        return this.frompsdevusername;
    }

    public boolean isFromPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDevUserNameDirty();
        }
        return this.frompsdevusernameDirtyFlag;
    }

    public void resetFromPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDevUserName();
            return;
        }
        this.frompsdevusernameDirtyFlag = false;
        this.frompsdevusername = null;
    }

    public void setFromUserMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromUserMode(n);
            return;
        }
        this.fromusermode = n;
        this.fromusermodeDirtyFlag = true;
    }

    public Integer getFromUserMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromUserMode();
        }
        return this.fromusermode;
    }

    public boolean isFromUserModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromUserModeDirty();
        }
        return this.fromusermodeDirtyFlag;
    }

    public void resetFromUserMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromUserMode();
            return;
        }
        this.fromusermodeDirtyFlag = false;
        this.fromusermode = null;
    }

    public void setFullLoginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullLoginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullloginname = string;
        this.fullloginnameDirtyFlag = true;
    }

    public String getFullLoginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullLoginName();
        }
        return this.fullloginname;
    }

    public boolean isFullLoginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullLoginNameDirty();
        }
        return this.fullloginnameDirtyFlag;
    }

    public void resetFullLoginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullLoginName();
            return;
        }
        this.fullloginnameDirtyFlag = false;
        this.fullloginname = null;
    }

    public void setFullLoginName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullLoginName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullloginname2 = string;
        this.fullloginname2DirtyFlag = true;
    }

    public String getFullLoginName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullLoginName2();
        }
        return this.fullloginname2;
    }

    public boolean isFullLoginName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullLoginName2Dirty();
        }
        return this.fullloginname2DirtyFlag;
    }

    public void resetFullLoginName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullLoginName2();
            return;
        }
        this.fullloginname2DirtyFlag = false;
        this.fullloginname2 = null;
    }

    public void setLoginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toLowerCase();
        }
        this.loginname = string;
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

    public void setLoginPwd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoginPwd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginpwd = string;
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

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
        super.setPSDevUserObjectId(string);
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
        super.resetPSDevUserObjectId();
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
        super.setPSDevUserObjName(string);
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
    }

    @Override
    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
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
    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
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

    public void setUserMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usermode = string;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    @Override
    protected void onReset() {
        PSDevUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevUserBase pSDevUserBase) {
        pSDevUserBase.resetAdminMode();
        pSDevUserBase.resetAIAgentMode();
        pSDevUserBase.resetAliasPSDevUserId();
        pSDevUserBase.resetAliasPSDevUserName();
        pSDevUserBase.resetAliasUserMode();
        pSDevUserBase.resetCreateDate();
        pSDevUserBase.resetCreateMan();
        pSDevUserBase.resetEnable();
        pSDevUserBase.resetFromLoginName();
        pSDevUserBase.resetFromPSDCId();
        pSDevUserBase.resetFromPSDCName();
        pSDevUserBase.resetFromPSDevUserId();
        pSDevUserBase.resetFromPSDevUserName();
        pSDevUserBase.resetFromUserMode();
        pSDevUserBase.resetFullLoginName();
        pSDevUserBase.resetFullLoginName2();
        pSDevUserBase.resetLoginName();
        pSDevUserBase.resetLoginPwd();
        pSDevUserBase.resetPSDevUserId();
        pSDevUserBase.resetPSDevUserName();
        pSDevUserBase.resetUpdateDate();
        pSDevUserBase.resetUpdateMan();
        pSDevUserBase.resetUserMode();
        pSDevUserBase.resetUserTag();
        pSDevUserBase.resetUserTag2();
        pSDevUserBase.resetUserTag3();
        pSDevUserBase.resetUserTag4();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminModeDirty()) {
            hashMap.put(FIELD_ADMINMODE, this.getAdminMode());
        }
        if (!bl || this.isAIAgentModeDirty()) {
            hashMap.put(FIELD_AIAGENTMODE, this.getAIAgentMode());
        }
        if (!bl || this.isAliasPSDevUserIdDirty()) {
            hashMap.put(FIELD_ALIASPSDEVUSERID, this.getAliasPSDevUserId());
        }
        if (!bl || this.isAliasPSDevUserNameDirty()) {
            hashMap.put(FIELD_ALIASPSDEVUSERNAME, this.getAliasPSDevUserName());
        }
        if (!bl || this.isAliasUserModeDirty()) {
            hashMap.put(FIELD_ALIASUSERMODE, this.getAliasUserMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isFromLoginNameDirty()) {
            hashMap.put(FIELD_FROMLOGINNAME, this.getFromLoginName());
        }
        if (!bl || this.isFromPSDCIdDirty()) {
            hashMap.put(FIELD_FROMPSDCID, this.getFromPSDCId());
        }
        if (!bl || this.isFromPSDCNameDirty()) {
            hashMap.put(FIELD_FROMPSDCNAME, this.getFromPSDCName());
        }
        if (!bl || this.isFromPSDevUserIdDirty()) {
            hashMap.put(FIELD_FROMPSDEVUSERID, this.getFromPSDevUserId());
        }
        if (!bl || this.isFromPSDevUserNameDirty()) {
            hashMap.put(FIELD_FROMPSDEVUSERNAME, this.getFromPSDevUserName());
        }
        if (!bl || this.isFromUserModeDirty()) {
            hashMap.put(FIELD_FROMUSERMODE, this.getFromUserMode());
        }
        if (!bl || this.isFullLoginNameDirty()) {
            hashMap.put(FIELD_FULLLOGINNAME, this.getFullLoginName());
        }
        if (!bl || this.isFullLoginName2Dirty()) {
            hashMap.put(FIELD_FULLLOGINNAME2, this.getFullLoginName2());
        }
        if (!bl || this.isLoginNameDirty()) {
            hashMap.put(FIELD_LOGINNAME, this.getLoginName());
        }
        if (!bl || this.isLoginPwdDirty()) {
            hashMap.put(FIELD_LOGINPWD, this.getLoginPwd());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserModeDirty()) {
            hashMap.put(FIELD_USERMODE, this.getUserMode());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        super.onFillMap(hashMap, bl);
    }

    @Override
    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDevUserBase.get(this, n);
    }

    private static Object get(PSDevUserBase pSDevUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserBase.getAdminMode();
            }
            case 1: {
                return pSDevUserBase.getAIAgentMode();
            }
            case 2: {
                return pSDevUserBase.getAliasPSDevUserId();
            }
            case 3: {
                return pSDevUserBase.getAliasPSDevUserName();
            }
            case 4: {
                return pSDevUserBase.getAliasUserMode();
            }
            case 5: {
                return pSDevUserBase.getCreateDate();
            }
            case 6: {
                return pSDevUserBase.getCreateMan();
            }
            case 12: {
                return pSDevUserBase.getEnable();
            }
            case 13: {
                return pSDevUserBase.getFromLoginName();
            }
            case 14: {
                return pSDevUserBase.getFromPSDCId();
            }
            case 15: {
                return pSDevUserBase.getFromPSDCName();
            }
            case 16: {
                return pSDevUserBase.getFromPSDevUserId();
            }
            case 17: {
                return pSDevUserBase.getFromPSDevUserName();
            }
            case 18: {
                return pSDevUserBase.getFromUserMode();
            }
            case 19: {
                return pSDevUserBase.getFullLoginName();
            }
            case 20: {
                return pSDevUserBase.getFullLoginName2();
            }
            case 21: {
                return pSDevUserBase.getLoginName();
            }
            case 22: {
                return pSDevUserBase.getLoginPwd();
            }
            case 26: {
                return pSDevUserBase.getPSDevUserId();
            }
            case 27: {
                return pSDevUserBase.getPSDevUserName();
            }
            case 29: {
                return pSDevUserBase.getUpdateDate();
            }
            case 30: {
                return pSDevUserBase.getUpdateMan();
            }
            case 31: {
                return pSDevUserBase.getUserMode();
            }
            case 32: {
                return pSDevUserBase.getUserTag();
            }
            case 33: {
                return pSDevUserBase.getUserTag2();
            }
            case 34: {
                return pSDevUserBase.getUserTag3();
            }
            case 35: {
                return pSDevUserBase.getUserTag4();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDevUserBase.set(this, n, object);
    }

    private static void set(PSDevUserBase pSDevUserBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserBase.setAdminMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevUserBase.setAIAgentMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevUserBase.setAliasPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevUserBase.setAliasPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevUserBase.setAliasUserMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevUserBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevUserBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevUserBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevUserBase.setFromLoginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevUserBase.setFromPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevUserBase.setFromPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevUserBase.setFromPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevUserBase.setFromPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevUserBase.setFromUserMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDevUserBase.setFullLoginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevUserBase.setFullLoginName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevUserBase.setLoginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevUserBase.setLoginPwd(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevUserBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevUserBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevUserBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSDevUserBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevUserBase.setUserMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevUserBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevUserBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevUserBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevUserBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDevUserBase.isNull(this, n);
    }

    private static boolean isNull(PSDevUserBase pSDevUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserBase.getAdminMode() == null;
            }
            case 1: {
                return pSDevUserBase.getAIAgentMode() == null;
            }
            case 2: {
                return pSDevUserBase.getAliasPSDevUserId() == null;
            }
            case 3: {
                return pSDevUserBase.getAliasPSDevUserName() == null;
            }
            case 4: {
                return pSDevUserBase.getAliasUserMode() == null;
            }
            case 5: {
                return pSDevUserBase.getCreateDate() == null;
            }
            case 6: {
                return pSDevUserBase.getCreateMan() == null;
            }
            case 12: {
                return pSDevUserBase.getEnable() == null;
            }
            case 13: {
                return pSDevUserBase.getFromLoginName() == null;
            }
            case 14: {
                return pSDevUserBase.getFromPSDCId() == null;
            }
            case 15: {
                return pSDevUserBase.getFromPSDCName() == null;
            }
            case 16: {
                return pSDevUserBase.getFromPSDevUserId() == null;
            }
            case 17: {
                return pSDevUserBase.getFromPSDevUserName() == null;
            }
            case 18: {
                return pSDevUserBase.getFromUserMode() == null;
            }
            case 19: {
                return pSDevUserBase.getFullLoginName() == null;
            }
            case 20: {
                return pSDevUserBase.getFullLoginName2() == null;
            }
            case 21: {
                return pSDevUserBase.getLoginName() == null;
            }
            case 22: {
                return pSDevUserBase.getLoginPwd() == null;
            }
            case 26: {
                return pSDevUserBase.getPSDevUserId() == null;
            }
            case 27: {
                return pSDevUserBase.getPSDevUserName() == null;
            }
            case 29: {
                return pSDevUserBase.getUpdateDate() == null;
            }
            case 30: {
                return pSDevUserBase.getUpdateMan() == null;
            }
            case 31: {
                return pSDevUserBase.getUserMode() == null;
            }
            case 32: {
                return pSDevUserBase.getUserTag() == null;
            }
            case 33: {
                return pSDevUserBase.getUserTag2() == null;
            }
            case 34: {
                return pSDevUserBase.getUserTag3() == null;
            }
            case 35: {
                return pSDevUserBase.getUserTag4() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDevUserBase.contains(this, n);
    }

    private static boolean contains(PSDevUserBase pSDevUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserBase.isAdminModeDirty();
            }
            case 1: {
                return pSDevUserBase.isAIAgentModeDirty();
            }
            case 2: {
                return pSDevUserBase.isAliasPSDevUserIdDirty();
            }
            case 3: {
                return pSDevUserBase.isAliasPSDevUserNameDirty();
            }
            case 4: {
                return pSDevUserBase.isAliasUserModeDirty();
            }
            case 5: {
                return pSDevUserBase.isCreateDateDirty();
            }
            case 6: {
                return pSDevUserBase.isCreateManDirty();
            }
            case 12: {
                return pSDevUserBase.isEnableDirty();
            }
            case 13: {
                return pSDevUserBase.isFromLoginNameDirty();
            }
            case 14: {
                return pSDevUserBase.isFromPSDCIdDirty();
            }
            case 15: {
                return pSDevUserBase.isFromPSDCNameDirty();
            }
            case 16: {
                return pSDevUserBase.isFromPSDevUserIdDirty();
            }
            case 17: {
                return pSDevUserBase.isFromPSDevUserNameDirty();
            }
            case 18: {
                return pSDevUserBase.isFromUserModeDirty();
            }
            case 19: {
                return pSDevUserBase.isFullLoginNameDirty();
            }
            case 20: {
                return pSDevUserBase.isFullLoginName2Dirty();
            }
            case 21: {
                return pSDevUserBase.isLoginNameDirty();
            }
            case 22: {
                return pSDevUserBase.isLoginPwdDirty();
            }
            case 26: {
                return pSDevUserBase.isPSDevUserIdDirty();
            }
            case 27: {
                return pSDevUserBase.isPSDevUserNameDirty();
            }
            case 29: {
                return pSDevUserBase.isUpdateDateDirty();
            }
            case 30: {
                return pSDevUserBase.isUpdateManDirty();
            }
            case 31: {
                return pSDevUserBase.isUserModeDirty();
            }
            case 32: {
                return pSDevUserBase.isUserTagDirty();
            }
            case 33: {
                return pSDevUserBase.isUserTag2Dirty();
            }
            case 34: {
                return pSDevUserBase.isUserTag3Dirty();
            }
            case 35: {
                return pSDevUserBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevUserBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevUserBase pSDevUserBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevUserBase.getAdminMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminmode", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getAdminMode()), (boolean)false);
        }
        if (bl || pSDevUserBase.getAIAgentMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiagentmode", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getAIAgentMode()), (boolean)false);
        }
        if (bl || pSDevUserBase.getAliasPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aliaspsdevuserid", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getAliasPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevUserBase.getAliasPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aliaspsdevusername", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getAliasPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevUserBase.getAliasUserMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aliasusermode", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getAliasUserMode()), (boolean)false);
        }
        if (bl || pSDevUserBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevUserBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevUserBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getEnable()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFromLoginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromloginname", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFromLoginName()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFromPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdcid", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFromPSDCId()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFromPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdcname", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFromPSDCName()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFromPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdevuserid", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFromPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFromPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdevusername", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFromPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFromUserMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromusermode", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFromUserMode()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFullLoginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullloginname", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFullLoginName()), (boolean)false);
        }
        if (bl || pSDevUserBase.getFullLoginName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullloginname2", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getFullLoginName2()), (boolean)false);
        }
        if (bl || pSDevUserBase.getLoginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginname", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getLoginName()), (boolean)false);
        }
        if (bl || pSDevUserBase.getLoginPwd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginpwd", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getLoginPwd()), (boolean)false);
        }
        if (bl || pSDevUserBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevUserBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevUserBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevUserBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevUserBase.getUserMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usermode", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getUserMode()), (boolean)false);
        }
        if (bl || pSDevUserBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevUserBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevUserBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevUserBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevUserBase.getJSONValue((Object)pSDevUserBase.getUserTag4()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevUserBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevUserBase pSDevUserBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevUserBase.getAdminMode() != null) {
            object = pSDevUserBase.getAdminMode();
            xmlNode.setAttribute(FIELD_ADMINMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserBase.getAIAgentMode() != null) {
            object = pSDevUserBase.getAIAgentMode();
            xmlNode.setAttribute(FIELD_AIAGENTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getAliasPSDevUserId() != null) {
            object = pSDevUserBase.getAliasPSDevUserId();
            xmlNode.setAttribute(FIELD_ALIASPSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getAliasPSDevUserName() != null) {
            object = pSDevUserBase.getAliasPSDevUserName();
            xmlNode.setAttribute(FIELD_ALIASPSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getAliasUserMode() != null) {
            object = pSDevUserBase.getAliasUserMode();
            xmlNode.setAttribute(FIELD_ALIASUSERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserBase.getCreateDate() != null) {
            object = pSDevUserBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserBase.getCreateMan() != null) {
            object = pSDevUserBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getEnable() != null) {
            object = pSDevUserBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserBase.getFromLoginName() != null) {
            object = pSDevUserBase.getFromLoginName();
            xmlNode.setAttribute(FIELD_FROMLOGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getFromPSDCId() != null) {
            object = pSDevUserBase.getFromPSDCId();
            xmlNode.setAttribute(FIELD_FROMPSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getFromPSDCName() != null) {
            object = pSDevUserBase.getFromPSDCName();
            xmlNode.setAttribute(FIELD_FROMPSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getFromPSDevUserId() != null) {
            object = pSDevUserBase.getFromPSDevUserId();
            xmlNode.setAttribute(FIELD_FROMPSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getFromPSDevUserName() != null) {
            object = pSDevUserBase.getFromPSDevUserName();
            xmlNode.setAttribute(FIELD_FROMPSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getFromUserMode() != null) {
            object = pSDevUserBase.getFromUserMode();
            xmlNode.setAttribute(FIELD_FROMUSERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserBase.getFullLoginName() != null) {
            object = pSDevUserBase.getFullLoginName();
            xmlNode.setAttribute(FIELD_FULLLOGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getFullLoginName2() != null) {
            object = pSDevUserBase.getFullLoginName2();
            xmlNode.setAttribute(FIELD_FULLLOGINNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getLoginName() != null) {
            object = pSDevUserBase.getLoginName();
            xmlNode.setAttribute(FIELD_LOGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getLoginPwd() != null) {
            object = pSDevUserBase.getLoginPwd();
            xmlNode.setAttribute(FIELD_LOGINPWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getPSDevUserId() != null) {
            object = pSDevUserBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getPSDevUserName() != null) {
            object = pSDevUserBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getUpdateDate() != null) {
            object = pSDevUserBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserBase.getUpdateMan() != null) {
            object = pSDevUserBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getUserMode() != null) {
            object = pSDevUserBase.getUserMode();
            xmlNode.setAttribute(FIELD_USERMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getUserTag() != null) {
            object = pSDevUserBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getUserTag2() != null) {
            object = pSDevUserBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getUserTag3() != null) {
            object = pSDevUserBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserBase.getUserTag4() != null) {
            object = pSDevUserBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevUserBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevUserBase pSDevUserBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevUserBase.isAdminModeDirty() && (bl || pSDevUserBase.getAdminMode() != null)) {
            iDataObject.set(FIELD_ADMINMODE, (Object)pSDevUserBase.getAdminMode());
        }
        if (pSDevUserBase.isAIAgentModeDirty() && (bl || pSDevUserBase.getAIAgentMode() != null)) {
            iDataObject.set(FIELD_AIAGENTMODE, (Object)pSDevUserBase.getAIAgentMode());
        }
        if (pSDevUserBase.isAliasPSDevUserIdDirty() && (bl || pSDevUserBase.getAliasPSDevUserId() != null)) {
            iDataObject.set(FIELD_ALIASPSDEVUSERID, (Object)pSDevUserBase.getAliasPSDevUserId());
        }
        if (pSDevUserBase.isAliasPSDevUserNameDirty() && (bl || pSDevUserBase.getAliasPSDevUserName() != null)) {
            iDataObject.set(FIELD_ALIASPSDEVUSERNAME, (Object)pSDevUserBase.getAliasPSDevUserName());
        }
        if (pSDevUserBase.isAliasUserModeDirty() && (bl || pSDevUserBase.getAliasUserMode() != null)) {
            iDataObject.set(FIELD_ALIASUSERMODE, (Object)pSDevUserBase.getAliasUserMode());
        }
        if (pSDevUserBase.isCreateDateDirty() && (bl || pSDevUserBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevUserBase.getCreateDate());
        }
        if (pSDevUserBase.isCreateManDirty() && (bl || pSDevUserBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevUserBase.getCreateMan());
        }
        if (pSDevUserBase.isEnableDirty() && (bl || pSDevUserBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSDevUserBase.getEnable());
        }
        if (pSDevUserBase.isFromLoginNameDirty() && (bl || pSDevUserBase.getFromLoginName() != null)) {
            iDataObject.set(FIELD_FROMLOGINNAME, (Object)pSDevUserBase.getFromLoginName());
        }
        if (pSDevUserBase.isFromPSDCIdDirty() && (bl || pSDevUserBase.getFromPSDCId() != null)) {
            iDataObject.set(FIELD_FROMPSDCID, (Object)pSDevUserBase.getFromPSDCId());
        }
        if (pSDevUserBase.isFromPSDCNameDirty() && (bl || pSDevUserBase.getFromPSDCName() != null)) {
            iDataObject.set(FIELD_FROMPSDCNAME, (Object)pSDevUserBase.getFromPSDCName());
        }
        if (pSDevUserBase.isFromPSDevUserIdDirty() && (bl || pSDevUserBase.getFromPSDevUserId() != null)) {
            iDataObject.set(FIELD_FROMPSDEVUSERID, (Object)pSDevUserBase.getFromPSDevUserId());
        }
        if (pSDevUserBase.isFromPSDevUserNameDirty() && (bl || pSDevUserBase.getFromPSDevUserName() != null)) {
            iDataObject.set(FIELD_FROMPSDEVUSERNAME, (Object)pSDevUserBase.getFromPSDevUserName());
        }
        if (pSDevUserBase.isFromUserModeDirty() && (bl || pSDevUserBase.getFromUserMode() != null)) {
            iDataObject.set(FIELD_FROMUSERMODE, (Object)pSDevUserBase.getFromUserMode());
        }
        if (pSDevUserBase.isFullLoginNameDirty() && (bl || pSDevUserBase.getFullLoginName() != null)) {
            iDataObject.set(FIELD_FULLLOGINNAME, (Object)pSDevUserBase.getFullLoginName());
        }
        if (pSDevUserBase.isFullLoginName2Dirty() && (bl || pSDevUserBase.getFullLoginName2() != null)) {
            iDataObject.set(FIELD_FULLLOGINNAME2, (Object)pSDevUserBase.getFullLoginName2());
        }
        if (pSDevUserBase.isLoginNameDirty() && (bl || pSDevUserBase.getLoginName() != null)) {
            iDataObject.set(FIELD_LOGINNAME, (Object)pSDevUserBase.getLoginName());
        }
        if (pSDevUserBase.isLoginPwdDirty() && (bl || pSDevUserBase.getLoginPwd() != null)) {
            iDataObject.set(FIELD_LOGINPWD, (Object)pSDevUserBase.getLoginPwd());
        }
        if (pSDevUserBase.isPSDevUserIdDirty() && (bl || pSDevUserBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDevUserBase.getPSDevUserId());
        }
        if (pSDevUserBase.isPSDevUserNameDirty() && (bl || pSDevUserBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDevUserBase.getPSDevUserName());
        }
        if (pSDevUserBase.isUpdateDateDirty() && (bl || pSDevUserBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevUserBase.getUpdateDate());
        }
        if (pSDevUserBase.isUpdateManDirty() && (bl || pSDevUserBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevUserBase.getUpdateMan());
        }
        if (pSDevUserBase.isUserModeDirty() && (bl || pSDevUserBase.getUserMode() != null)) {
            iDataObject.set(FIELD_USERMODE, (Object)pSDevUserBase.getUserMode());
        }
        if (pSDevUserBase.isUserTagDirty() && (bl || pSDevUserBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevUserBase.getUserTag());
        }
        if (pSDevUserBase.isUserTag2Dirty() && (bl || pSDevUserBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevUserBase.getUserTag2());
        }
        if (pSDevUserBase.isUserTag3Dirty() && (bl || pSDevUserBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevUserBase.getUserTag3());
        }
        if (pSDevUserBase.isUserTag4Dirty() && (bl || pSDevUserBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevUserBase.getUserTag4());
        }
    }

    @Override
    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDevUserBase.remove(this, n);
    }

    private static boolean remove(PSDevUserBase pSDevUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserBase.resetAdminMode();
                return true;
            }
            case 1: {
                pSDevUserBase.resetAIAgentMode();
                return true;
            }
            case 2: {
                pSDevUserBase.resetAliasPSDevUserId();
                return true;
            }
            case 3: {
                pSDevUserBase.resetAliasPSDevUserName();
                return true;
            }
            case 4: {
                pSDevUserBase.resetAliasUserMode();
                return true;
            }
            case 5: {
                pSDevUserBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDevUserBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSDevUserBase.resetEnable();
                return true;
            }
            case 13: {
                pSDevUserBase.resetFromLoginName();
                return true;
            }
            case 14: {
                pSDevUserBase.resetFromPSDCId();
                return true;
            }
            case 15: {
                pSDevUserBase.resetFromPSDCName();
                return true;
            }
            case 16: {
                pSDevUserBase.resetFromPSDevUserId();
                return true;
            }
            case 17: {
                pSDevUserBase.resetFromPSDevUserName();
                return true;
            }
            case 18: {
                pSDevUserBase.resetFromUserMode();
                return true;
            }
            case 19: {
                pSDevUserBase.resetFullLoginName();
                return true;
            }
            case 20: {
                pSDevUserBase.resetFullLoginName2();
                return true;
            }
            case 21: {
                pSDevUserBase.resetLoginName();
                return true;
            }
            case 22: {
                pSDevUserBase.resetLoginPwd();
                return true;
            }
            case 26: {
                pSDevUserBase.resetPSDevUserId();
                return true;
            }
            case 27: {
                pSDevUserBase.resetPSDevUserName();
                return true;
            }
            case 29: {
                pSDevUserBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSDevUserBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSDevUserBase.resetUserMode();
                return true;
            }
            case 32: {
                pSDevUserBase.resetUserTag();
                return true;
            }
            case 33: {
                pSDevUserBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSDevUserBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSDevUserBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDevUserBase getProxyEntity() {
        return this.proxyPSDevUserBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevUserBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevUserBase) {
            this.proxyPSDevUserBase = (PSDevUserBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINMODE, 0);
        fieldIndexMap.put(FIELD_AIAGENTMODE, 1);
        fieldIndexMap.put(FIELD_ALIASPSDEVUSERID, 2);
        fieldIndexMap.put(FIELD_ALIASPSDEVUSERNAME, 3);
        fieldIndexMap.put(FIELD_ALIASUSERMODE, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_ENABLE, 12);
        fieldIndexMap.put(FIELD_FROMLOGINNAME, 13);
        fieldIndexMap.put(FIELD_FROMPSDCID, 14);
        fieldIndexMap.put(FIELD_FROMPSDCNAME, 15);
        fieldIndexMap.put(FIELD_FROMPSDEVUSERID, 16);
        fieldIndexMap.put(FIELD_FROMPSDEVUSERNAME, 17);
        fieldIndexMap.put(FIELD_FROMUSERMODE, 18);
        fieldIndexMap.put(FIELD_FULLLOGINNAME, 19);
        fieldIndexMap.put(FIELD_FULLLOGINNAME2, 20);
        fieldIndexMap.put(FIELD_LOGINNAME, 21);
        fieldIndexMap.put(FIELD_LOGINPWD, 22);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 26);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERMODE, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
    }
}

