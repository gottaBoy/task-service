/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysMsgTargetBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysMsgTargetBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSGTARGETPARAMS = "MSGTARGETPARAMS";
    public static final String FIELD_MSGTARGETTAG = "MSGTARGETTAG";
    public static final String FIELD_MSGTARGETTAG2 = "MSGTARGETTAG2";
    public static final String FIELD_MSGTARGETTYPE = "MSGTARGETTYPE";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSMSGTARGETID = "PSSYSMSGTARGETID";
    public static final String FIELD_PSSYSMSGTARGETNAME = "PSSYSMSGTARGETNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String FIELD_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String FIELD_TARGETPSDEFID = "TARGETPSDEFID";
    public static final String FIELD_TARGETPSDEFNAME = "TARGETPSDEFNAME";
    public static final String FIELD_TARGETTYPEPSDEFID = "TARGETTYPEPSDEFID";
    public static final String FIELD_TARGETTYPEPSDEFNAME = "TARGETTYPEPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USER2PSDEFID = "USER2PSDEFID";
    public static final String FIELD_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPSDEFID = "USERPSDEFID";
    public static final String FIELD_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MSGTARGETPARAMS = 6;
    private static final int INDEX_MSGTARGETTAG = 7;
    private static final int INDEX_MSGTARGETTAG2 = 8;
    private static final int INDEX_MSGTARGETTYPE = 9;
    private static final int INDEX_PSDEDSID = 10;
    private static final int INDEX_PSDEDSNAME = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSSYSDYNAMODELID = 16;
    private static final int INDEX_PSSYSDYNAMODELNAME = 17;
    private static final int INDEX_PSSYSMSGTARGETID = 18;
    private static final int INDEX_PSSYSMSGTARGETNAME = 19;
    private static final int INDEX_PSSYSSFPLUGINID = 20;
    private static final int INDEX_PSSYSSFPLUGINNAME = 21;
    private static final int INDEX_PSSYSTEMID = 22;
    private static final int INDEX_PSSYSTEMNAME = 23;
    private static final int INDEX_PSSYSUTILDEID = 24;
    private static final int INDEX_PSSYSUTILDENAME = 25;
    private static final int INDEX_TARGETPSDEFID = 26;
    private static final int INDEX_TARGETPSDEFNAME = 27;
    private static final int INDEX_TARGETTYPEPSDEFID = 28;
    private static final int INDEX_TARGETTYPEPSDEFNAME = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_USER2PSDEFID = 32;
    private static final int INDEX_USER2PSDEFNAME = 33;
    private static final int INDEX_USERCAT = 34;
    private static final int INDEX_USERPSDEFID = 35;
    private static final int INDEX_USERPSDEFNAME = 36;
    private static final int INDEX_USERTAG = 37;
    private static final int INDEX_USERTAG2 = 38;
    private static final int INDEX_USERTAG3 = 39;
    private static final int INDEX_USERTAG4 = 40;
    private static final int INDEX_VALIDFLAG = 41;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysMsgTargetBase proxyPSSysMsgTargetBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean msgtargetparamsDirtyFlag = false;
    private boolean msgtargettagDirtyFlag = false;
    private boolean msgtargettag2DirtyFlag = false;
    private boolean msgtargettypeDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysmsgtargetidDirtyFlag = false;
    private boolean pssysmsgtargetnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysutildeidDirtyFlag = false;
    private boolean pssysutildenameDirtyFlag = false;
    private boolean targetpsdefidDirtyFlag = false;
    private boolean targetpsdefnameDirtyFlag = false;
    private boolean targettypepsdefidDirtyFlag = false;
    private boolean targettypepsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean user2psdefidDirtyFlag = false;
    private boolean user2psdefnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userpsdefidDirtyFlag = false;
    private boolean userpsdefnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="memo")
    private String memo;
    @Column(name="msgtargetparams")
    private String msgtargetparams;
    @Column(name="msgtargettag")
    private String msgtargettag;
    @Column(name="msgtargettag2")
    private String msgtargettag2;
    @Column(name="msgtargettype")
    private String msgtargettype;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysmsgtargetid")
    private String pssysmsgtargetid;
    @Column(name="pssysmsgtargetname")
    private String pssysmsgtargetname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysutildeid")
    private String pssysutildeid;
    @Column(name="pssysutildename")
    private String pssysutildename;
    @Column(name="targetpsdefid")
    private String targetpsdefid;
    @Column(name="targetpsdefname")
    private String targetpsdefname;
    @Column(name="targettypepsdefid")
    private String targettypepsdefid;
    @Column(name="targettypepsdefname")
    private String targettypepsdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="user2psdefid")
    private String user2psdefid;
    @Column(name="user2psdefname")
    private String user2psdefname;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userpsdefid")
    private String userpsdefid;
    @Column(name="userpsdefname")
    private String userpsdefname;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objTargetPSDEFLock = new Integer(1);
    private PSDEField targetpsdef = null;
    private Integer objTargetTypePSDEFLock = new Integer(1);
    private PSDEField targettypepsdef = null;
    private Integer objUser2PSDEFLock = new Integer(1);
    private PSDEField user2psdef = null;
    private Integer objUserPSDEFLock = new Integer(1);
    private PSDEField userpsdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUtilDELock = new Integer(1);
    private PSSysUtilDE pssysutilde = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
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

    public void setMsgTargetParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTargetParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtargetparams = string;
        this.msgtargetparamsDirtyFlag = true;
    }

    public String getMsgTargetParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTargetParams();
        }
        return this.msgtargetparams;
    }

    public boolean isMsgTargetParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTargetParamsDirty();
        }
        return this.msgtargetparamsDirtyFlag;
    }

    public void resetMsgTargetParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTargetParams();
            return;
        }
        this.msgtargetparamsDirtyFlag = false;
        this.msgtargetparams = null;
    }

    public void setMsgTargetTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTargetTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtargettag = string;
        this.msgtargettagDirtyFlag = true;
    }

    public String getMsgTargetTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTargetTag();
        }
        return this.msgtargettag;
    }

    public boolean isMsgTargetTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTargetTagDirty();
        }
        return this.msgtargettagDirtyFlag;
    }

    public void resetMsgTargetTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTargetTag();
            return;
        }
        this.msgtargettagDirtyFlag = false;
        this.msgtargettag = null;
    }

    public void setMsgTargetTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTargetTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtargettag2 = string;
        this.msgtargettag2DirtyFlag = true;
    }

    public String getMsgTargetTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTargetTag2();
        }
        return this.msgtargettag2;
    }

    public boolean isMsgTargetTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTargetTag2Dirty();
        }
        return this.msgtargettag2DirtyFlag;
    }

    public void resetMsgTargetTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTargetTag2();
            return;
        }
        this.msgtargettag2DirtyFlag = false;
        this.msgtargettag2 = null;
    }

    public void setMsgTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtargettype = string;
        this.msgtargettypeDirtyFlag = true;
    }

    public String getMsgTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgTargetType();
        }
        return this.msgtargettype;
    }

    public boolean isMsgTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTargetTypeDirty();
        }
        return this.msgtargettypeDirtyFlag;
    }

    public void resetMsgTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgTargetType();
            return;
        }
        this.msgtargettypeDirtyFlag = false;
        this.msgtargettype = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysMsgTargetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTargetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtargetid = string;
        this.pssysmsgtargetidDirtyFlag = true;
    }

    public String getPSSysMsgTargetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTargetId();
        }
        return this.pssysmsgtargetid;
    }

    public boolean isPSSysMsgTargetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTargetIdDirty();
        }
        return this.pssysmsgtargetidDirtyFlag;
    }

    public void resetPSSysMsgTargetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTargetId();
            return;
        }
        this.pssysmsgtargetidDirtyFlag = false;
        this.pssysmsgtargetid = null;
    }

    public void setPSSysMsgTargetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTargetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtargetname = string;
        this.pssysmsgtargetnameDirtyFlag = true;
    }

    public String getPSSysMsgTargetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTargetName();
        }
        return this.pssysmsgtargetname;
    }

    public boolean isPSSysMsgTargetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTargetNameDirty();
        }
        return this.pssysmsgtargetnameDirtyFlag;
    }

    public void resetPSSysMsgTargetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTargetName();
            return;
        }
        this.pssysmsgtargetnameDirtyFlag = false;
        this.pssysmsgtargetname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSSysUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildeid = string;
        this.pssysutildeidDirtyFlag = true;
    }

    public String getPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEId();
        }
        return this.pssysutildeid;
    }

    public boolean isPSSysUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDEIdDirty();
        }
        return this.pssysutildeidDirtyFlag;
    }

    public void resetPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEId();
            return;
        }
        this.pssysutildeidDirtyFlag = false;
        this.pssysutildeid = null;
    }

    public void setPSSysUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildename = string;
        this.pssysutildenameDirtyFlag = true;
    }

    public String getPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEName();
        }
        return this.pssysutildename;
    }

    public boolean isPSSysUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDENameDirty();
        }
        return this.pssysutildenameDirtyFlag;
    }

    public void resetPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEName();
            return;
        }
        this.pssysutildenameDirtyFlag = false;
        this.pssysutildename = null;
    }

    public void setTargetPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetpsdefid = string;
        this.targetpsdefidDirtyFlag = true;
    }

    public String getTargetPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEFId();
        }
        return this.targetpsdefid;
    }

    public boolean isTargetPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetPSDEFIdDirty();
        }
        return this.targetpsdefidDirtyFlag;
    }

    public void resetTargetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetPSDEFId();
            return;
        }
        this.targetpsdefidDirtyFlag = false;
        this.targetpsdefid = null;
    }

    public void setTargetPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetpsdefname = string;
        this.targetpsdefnameDirtyFlag = true;
    }

    public String getTargetPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEFName();
        }
        return this.targetpsdefname;
    }

    public boolean isTargetPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetPSDEFNameDirty();
        }
        return this.targetpsdefnameDirtyFlag;
    }

    public void resetTargetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetPSDEFName();
            return;
        }
        this.targetpsdefnameDirtyFlag = false;
        this.targetpsdefname = null;
    }

    public void setTargetTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettypepsdefid = string;
        this.targettypepsdefidDirtyFlag = true;
    }

    public String getTargetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEFId();
        }
        return this.targettypepsdefid;
    }

    public boolean isTargetTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypePSDEFIdDirty();
        }
        return this.targettypepsdefidDirtyFlag;
    }

    public void resetTargetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetTypePSDEFId();
            return;
        }
        this.targettypepsdefidDirtyFlag = false;
        this.targettypepsdefid = null;
    }

    public void setTargetTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettypepsdefname = string;
        this.targettypepsdefnameDirtyFlag = true;
    }

    public String getTargetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEFName();
        }
        return this.targettypepsdefname;
    }

    public boolean isTargetTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypePSDEFNameDirty();
        }
        return this.targettypepsdefnameDirtyFlag;
    }

    public void resetTargetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetTypePSDEFName();
            return;
        }
        this.targettypepsdefnameDirtyFlag = false;
        this.targettypepsdefname = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
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

    public void setUser2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefid = string;
        this.user2psdefidDirtyFlag = true;
    }

    public String getUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFId();
        }
        return this.user2psdefid;
    }

    public boolean isUser2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFIdDirty();
        }
        return this.user2psdefidDirtyFlag;
    }

    public void resetUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFId();
            return;
        }
        this.user2psdefidDirtyFlag = false;
        this.user2psdefid = null;
    }

    public void setUser2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefname = string;
        this.user2psdefnameDirtyFlag = true;
    }

    public String getUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFName();
        }
        return this.user2psdefname;
    }

    public boolean isUser2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFNameDirty();
        }
        return this.user2psdefnameDirtyFlag;
    }

    public void resetUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFName();
            return;
        }
        this.user2psdefnameDirtyFlag = false;
        this.user2psdefname = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefid = string;
        this.userpsdefidDirtyFlag = true;
    }

    public String getUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFId();
        }
        return this.userpsdefid;
    }

    public boolean isUserPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFIdDirty();
        }
        return this.userpsdefidDirtyFlag;
    }

    public void resetUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFId();
            return;
        }
        this.userpsdefidDirtyFlag = false;
        this.userpsdefid = null;
    }

    public void setUserPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefname = string;
        this.userpsdefnameDirtyFlag = true;
    }

    public String getUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFName();
        }
        return this.userpsdefname;
    }

    public boolean isUserPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFNameDirty();
        }
        return this.userpsdefnameDirtyFlag;
    }

    public void resetUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFName();
            return;
        }
        this.userpsdefnameDirtyFlag = false;
        this.userpsdefname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
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

    protected void onReset() {
        PSSysMsgTargetBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysMsgTargetBase pSSysMsgTargetBase) {
        pSSysMsgTargetBase.resetCodeName();
        pSSysMsgTargetBase.resetCreateDate();
        pSSysMsgTargetBase.resetCreateMan();
        pSSysMsgTargetBase.resetCustomCode();
        pSSysMsgTargetBase.resetCustomMode();
        pSSysMsgTargetBase.resetMemo();
        pSSysMsgTargetBase.resetMsgTargetParams();
        pSSysMsgTargetBase.resetMsgTargetTag();
        pSSysMsgTargetBase.resetMsgTargetTag2();
        pSSysMsgTargetBase.resetMsgTargetType();
        pSSysMsgTargetBase.resetPSDEDSId();
        pSSysMsgTargetBase.resetPSDEDSName();
        pSSysMsgTargetBase.resetPSDEId();
        pSSysMsgTargetBase.resetPSDEName();
        pSSysMsgTargetBase.resetPSModuleId();
        pSSysMsgTargetBase.resetPSModuleName();
        pSSysMsgTargetBase.resetPSSysDynaModelId();
        pSSysMsgTargetBase.resetPSSysDynaModelName();
        pSSysMsgTargetBase.resetPSSysMsgTargetId();
        pSSysMsgTargetBase.resetPSSysMsgTargetName();
        pSSysMsgTargetBase.resetPSSysSFPluginId();
        pSSysMsgTargetBase.resetPSSysSFPluginName();
        pSSysMsgTargetBase.resetPSSystemId();
        pSSysMsgTargetBase.resetPSSystemName();
        pSSysMsgTargetBase.resetPSSysUtilDEId();
        pSSysMsgTargetBase.resetPSSysUtilDEName();
        pSSysMsgTargetBase.resetTargetPSDEFId();
        pSSysMsgTargetBase.resetTargetPSDEFName();
        pSSysMsgTargetBase.resetTargetTypePSDEFId();
        pSSysMsgTargetBase.resetTargetTypePSDEFName();
        pSSysMsgTargetBase.resetUpdateDate();
        pSSysMsgTargetBase.resetUpdateMan();
        pSSysMsgTargetBase.resetUser2PSDEFId();
        pSSysMsgTargetBase.resetUser2PSDEFName();
        pSSysMsgTargetBase.resetUserCat();
        pSSysMsgTargetBase.resetUserPSDEFId();
        pSSysMsgTargetBase.resetUserPSDEFName();
        pSSysMsgTargetBase.resetUserTag();
        pSSysMsgTargetBase.resetUserTag2();
        pSSysMsgTargetBase.resetUserTag3();
        pSSysMsgTargetBase.resetUserTag4();
        pSSysMsgTargetBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMsgTargetParamsDirty()) {
            hashMap.put(FIELD_MSGTARGETPARAMS, this.getMsgTargetParams());
        }
        if (!bl || this.isMsgTargetTagDirty()) {
            hashMap.put(FIELD_MSGTARGETTAG, this.getMsgTargetTag());
        }
        if (!bl || this.isMsgTargetTag2Dirty()) {
            hashMap.put(FIELD_MSGTARGETTAG2, this.getMsgTargetTag2());
        }
        if (!bl || this.isMsgTargetTypeDirty()) {
            hashMap.put(FIELD_MSGTARGETTYPE, this.getMsgTargetType());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysMsgTargetIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTARGETID, this.getPSSysMsgTargetId());
        }
        if (!bl || this.isPSSysMsgTargetNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTARGETNAME, this.getPSSysMsgTargetName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUtilDEIdDirty()) {
            hashMap.put(FIELD_PSSYSUTILDEID, this.getPSSysUtilDEId());
        }
        if (!bl || this.isPSSysUtilDENameDirty()) {
            hashMap.put(FIELD_PSSYSUTILDENAME, this.getPSSysUtilDEName());
        }
        if (!bl || this.isTargetPSDEFIdDirty()) {
            hashMap.put(FIELD_TARGETPSDEFID, this.getTargetPSDEFId());
        }
        if (!bl || this.isTargetPSDEFNameDirty()) {
            hashMap.put(FIELD_TARGETPSDEFNAME, this.getTargetPSDEFName());
        }
        if (!bl || this.isTargetTypePSDEFIdDirty()) {
            hashMap.put(FIELD_TARGETTYPEPSDEFID, this.getTargetTypePSDEFId());
        }
        if (!bl || this.isTargetTypePSDEFNameDirty()) {
            hashMap.put(FIELD_TARGETTYPEPSDEFNAME, this.getTargetTypePSDEFName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUser2PSDEFIdDirty()) {
            hashMap.put(FIELD_USER2PSDEFID, this.getUser2PSDEFId());
        }
        if (!bl || this.isUser2PSDEFNameDirty()) {
            hashMap.put(FIELD_USER2PSDEFNAME, this.getUser2PSDEFName());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserPSDEFIdDirty()) {
            hashMap.put(FIELD_USERPSDEFID, this.getUserPSDEFId());
        }
        if (!bl || this.isUserPSDEFNameDirty()) {
            hashMap.put(FIELD_USERPSDEFNAME, this.getUserPSDEFName());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        super.onFillMap(hashMap, bl);
    }

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
        return PSSysMsgTargetBase.get(this, n);
    }

    private static Object get(PSSysMsgTargetBase pSSysMsgTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgTargetBase.getCodeName();
            }
            case 1: {
                return pSSysMsgTargetBase.getCreateDate();
            }
            case 2: {
                return pSSysMsgTargetBase.getCreateMan();
            }
            case 3: {
                return pSSysMsgTargetBase.getCustomCode();
            }
            case 4: {
                return pSSysMsgTargetBase.getCustomMode();
            }
            case 5: {
                return pSSysMsgTargetBase.getMemo();
            }
            case 6: {
                return pSSysMsgTargetBase.getMsgTargetParams();
            }
            case 7: {
                return pSSysMsgTargetBase.getMsgTargetTag();
            }
            case 8: {
                return pSSysMsgTargetBase.getMsgTargetTag2();
            }
            case 9: {
                return pSSysMsgTargetBase.getMsgTargetType();
            }
            case 10: {
                return pSSysMsgTargetBase.getPSDEDSId();
            }
            case 11: {
                return pSSysMsgTargetBase.getPSDEDSName();
            }
            case 12: {
                return pSSysMsgTargetBase.getPSDEId();
            }
            case 13: {
                return pSSysMsgTargetBase.getPSDEName();
            }
            case 14: {
                return pSSysMsgTargetBase.getPSModuleId();
            }
            case 15: {
                return pSSysMsgTargetBase.getPSModuleName();
            }
            case 16: {
                return pSSysMsgTargetBase.getPSSysDynaModelId();
            }
            case 17: {
                return pSSysMsgTargetBase.getPSSysDynaModelName();
            }
            case 18: {
                return pSSysMsgTargetBase.getPSSysMsgTargetId();
            }
            case 19: {
                return pSSysMsgTargetBase.getPSSysMsgTargetName();
            }
            case 20: {
                return pSSysMsgTargetBase.getPSSysSFPluginId();
            }
            case 21: {
                return pSSysMsgTargetBase.getPSSysSFPluginName();
            }
            case 22: {
                return pSSysMsgTargetBase.getPSSystemId();
            }
            case 23: {
                return pSSysMsgTargetBase.getPSSystemName();
            }
            case 24: {
                return pSSysMsgTargetBase.getPSSysUtilDEId();
            }
            case 25: {
                return pSSysMsgTargetBase.getPSSysUtilDEName();
            }
            case 26: {
                return pSSysMsgTargetBase.getTargetPSDEFId();
            }
            case 27: {
                return pSSysMsgTargetBase.getTargetPSDEFName();
            }
            case 28: {
                return pSSysMsgTargetBase.getTargetTypePSDEFId();
            }
            case 29: {
                return pSSysMsgTargetBase.getTargetTypePSDEFName();
            }
            case 30: {
                return pSSysMsgTargetBase.getUpdateDate();
            }
            case 31: {
                return pSSysMsgTargetBase.getUpdateMan();
            }
            case 32: {
                return pSSysMsgTargetBase.getUser2PSDEFId();
            }
            case 33: {
                return pSSysMsgTargetBase.getUser2PSDEFName();
            }
            case 34: {
                return pSSysMsgTargetBase.getUserCat();
            }
            case 35: {
                return pSSysMsgTargetBase.getUserPSDEFId();
            }
            case 36: {
                return pSSysMsgTargetBase.getUserPSDEFName();
            }
            case 37: {
                return pSSysMsgTargetBase.getUserTag();
            }
            case 38: {
                return pSSysMsgTargetBase.getUserTag2();
            }
            case 39: {
                return pSSysMsgTargetBase.getUserTag3();
            }
            case 40: {
                return pSSysMsgTargetBase.getUserTag4();
            }
            case 41: {
                return pSSysMsgTargetBase.getValidFlag();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

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
        PSSysMsgTargetBase.set(this, n, object);
    }

    private static void set(PSSysMsgTargetBase pSSysMsgTargetBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysMsgTargetBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysMsgTargetBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysMsgTargetBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysMsgTargetBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysMsgTargetBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysMsgTargetBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysMsgTargetBase.setMsgTargetParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysMsgTargetBase.setMsgTargetTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysMsgTargetBase.setMsgTargetTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysMsgTargetBase.setMsgTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysMsgTargetBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysMsgTargetBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysMsgTargetBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysMsgTargetBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysMsgTargetBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysMsgTargetBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysMsgTargetBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysMsgTargetBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysMsgTargetBase.setPSSysMsgTargetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysMsgTargetBase.setPSSysMsgTargetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysMsgTargetBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysMsgTargetBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysMsgTargetBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysMsgTargetBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysMsgTargetBase.setPSSysUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysMsgTargetBase.setPSSysUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysMsgTargetBase.setTargetPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysMsgTargetBase.setTargetPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysMsgTargetBase.setTargetTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysMsgTargetBase.setTargetTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysMsgTargetBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSSysMsgTargetBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysMsgTargetBase.setUser2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysMsgTargetBase.setUser2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysMsgTargetBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysMsgTargetBase.setUserPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysMsgTargetBase.setUserPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysMsgTargetBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysMsgTargetBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysMsgTargetBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysMsgTargetBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysMsgTargetBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

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
        return PSSysMsgTargetBase.isNull(this, n);
    }

    private static boolean isNull(PSSysMsgTargetBase pSSysMsgTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgTargetBase.getCodeName() == null;
            }
            case 1: {
                return pSSysMsgTargetBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysMsgTargetBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysMsgTargetBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysMsgTargetBase.getCustomMode() == null;
            }
            case 5: {
                return pSSysMsgTargetBase.getMemo() == null;
            }
            case 6: {
                return pSSysMsgTargetBase.getMsgTargetParams() == null;
            }
            case 7: {
                return pSSysMsgTargetBase.getMsgTargetTag() == null;
            }
            case 8: {
                return pSSysMsgTargetBase.getMsgTargetTag2() == null;
            }
            case 9: {
                return pSSysMsgTargetBase.getMsgTargetType() == null;
            }
            case 10: {
                return pSSysMsgTargetBase.getPSDEDSId() == null;
            }
            case 11: {
                return pSSysMsgTargetBase.getPSDEDSName() == null;
            }
            case 12: {
                return pSSysMsgTargetBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysMsgTargetBase.getPSDEName() == null;
            }
            case 14: {
                return pSSysMsgTargetBase.getPSModuleId() == null;
            }
            case 15: {
                return pSSysMsgTargetBase.getPSModuleName() == null;
            }
            case 16: {
                return pSSysMsgTargetBase.getPSSysDynaModelId() == null;
            }
            case 17: {
                return pSSysMsgTargetBase.getPSSysDynaModelName() == null;
            }
            case 18: {
                return pSSysMsgTargetBase.getPSSysMsgTargetId() == null;
            }
            case 19: {
                return pSSysMsgTargetBase.getPSSysMsgTargetName() == null;
            }
            case 20: {
                return pSSysMsgTargetBase.getPSSysSFPluginId() == null;
            }
            case 21: {
                return pSSysMsgTargetBase.getPSSysSFPluginName() == null;
            }
            case 22: {
                return pSSysMsgTargetBase.getPSSystemId() == null;
            }
            case 23: {
                return pSSysMsgTargetBase.getPSSystemName() == null;
            }
            case 24: {
                return pSSysMsgTargetBase.getPSSysUtilDEId() == null;
            }
            case 25: {
                return pSSysMsgTargetBase.getPSSysUtilDEName() == null;
            }
            case 26: {
                return pSSysMsgTargetBase.getTargetPSDEFId() == null;
            }
            case 27: {
                return pSSysMsgTargetBase.getTargetPSDEFName() == null;
            }
            case 28: {
                return pSSysMsgTargetBase.getTargetTypePSDEFId() == null;
            }
            case 29: {
                return pSSysMsgTargetBase.getTargetTypePSDEFName() == null;
            }
            case 30: {
                return pSSysMsgTargetBase.getUpdateDate() == null;
            }
            case 31: {
                return pSSysMsgTargetBase.getUpdateMan() == null;
            }
            case 32: {
                return pSSysMsgTargetBase.getUser2PSDEFId() == null;
            }
            case 33: {
                return pSSysMsgTargetBase.getUser2PSDEFName() == null;
            }
            case 34: {
                return pSSysMsgTargetBase.getUserCat() == null;
            }
            case 35: {
                return pSSysMsgTargetBase.getUserPSDEFId() == null;
            }
            case 36: {
                return pSSysMsgTargetBase.getUserPSDEFName() == null;
            }
            case 37: {
                return pSSysMsgTargetBase.getUserTag() == null;
            }
            case 38: {
                return pSSysMsgTargetBase.getUserTag2() == null;
            }
            case 39: {
                return pSSysMsgTargetBase.getUserTag3() == null;
            }
            case 40: {
                return pSSysMsgTargetBase.getUserTag4() == null;
            }
            case 41: {
                return pSSysMsgTargetBase.getValidFlag() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

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
        return PSSysMsgTargetBase.contains(this, n);
    }

    private static boolean contains(PSSysMsgTargetBase pSSysMsgTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysMsgTargetBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysMsgTargetBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysMsgTargetBase.isCreateManDirty();
            }
            case 3: {
                return pSSysMsgTargetBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysMsgTargetBase.isCustomModeDirty();
            }
            case 5: {
                return pSSysMsgTargetBase.isMemoDirty();
            }
            case 6: {
                return pSSysMsgTargetBase.isMsgTargetParamsDirty();
            }
            case 7: {
                return pSSysMsgTargetBase.isMsgTargetTagDirty();
            }
            case 8: {
                return pSSysMsgTargetBase.isMsgTargetTag2Dirty();
            }
            case 9: {
                return pSSysMsgTargetBase.isMsgTargetTypeDirty();
            }
            case 10: {
                return pSSysMsgTargetBase.isPSDEDSIdDirty();
            }
            case 11: {
                return pSSysMsgTargetBase.isPSDEDSNameDirty();
            }
            case 12: {
                return pSSysMsgTargetBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysMsgTargetBase.isPSDENameDirty();
            }
            case 14: {
                return pSSysMsgTargetBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSSysMsgTargetBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSSysMsgTargetBase.isPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSSysMsgTargetBase.isPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSSysMsgTargetBase.isPSSysMsgTargetIdDirty();
            }
            case 19: {
                return pSSysMsgTargetBase.isPSSysMsgTargetNameDirty();
            }
            case 20: {
                return pSSysMsgTargetBase.isPSSysSFPluginIdDirty();
            }
            case 21: {
                return pSSysMsgTargetBase.isPSSysSFPluginNameDirty();
            }
            case 22: {
                return pSSysMsgTargetBase.isPSSystemIdDirty();
            }
            case 23: {
                return pSSysMsgTargetBase.isPSSystemNameDirty();
            }
            case 24: {
                return pSSysMsgTargetBase.isPSSysUtilDEIdDirty();
            }
            case 25: {
                return pSSysMsgTargetBase.isPSSysUtilDENameDirty();
            }
            case 26: {
                return pSSysMsgTargetBase.isTargetPSDEFIdDirty();
            }
            case 27: {
                return pSSysMsgTargetBase.isTargetPSDEFNameDirty();
            }
            case 28: {
                return pSSysMsgTargetBase.isTargetTypePSDEFIdDirty();
            }
            case 29: {
                return pSSysMsgTargetBase.isTargetTypePSDEFNameDirty();
            }
            case 30: {
                return pSSysMsgTargetBase.isUpdateDateDirty();
            }
            case 31: {
                return pSSysMsgTargetBase.isUpdateManDirty();
            }
            case 32: {
                return pSSysMsgTargetBase.isUser2PSDEFIdDirty();
            }
            case 33: {
                return pSSysMsgTargetBase.isUser2PSDEFNameDirty();
            }
            case 34: {
                return pSSysMsgTargetBase.isUserCatDirty();
            }
            case 35: {
                return pSSysMsgTargetBase.isUserPSDEFIdDirty();
            }
            case 36: {
                return pSSysMsgTargetBase.isUserPSDEFNameDirty();
            }
            case 37: {
                return pSSysMsgTargetBase.isUserTagDirty();
            }
            case 38: {
                return pSSysMsgTargetBase.isUserTag2Dirty();
            }
            case 39: {
                return pSSysMsgTargetBase.isUserTag3Dirty();
            }
            case 40: {
                return pSSysMsgTargetBase.isUserTag4Dirty();
            }
            case 41: {
                return pSSysMsgTargetBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysMsgTargetBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysMsgTargetBase pSSysMsgTargetBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysMsgTargetBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtargetparams", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getMsgTargetParams()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtargettag", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getMsgTargetTag()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtargettag2", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getMsgTargetTag2()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtargettype", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getMsgTargetType()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysMsgTargetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtargetid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysMsgTargetId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysMsgTargetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtargetname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysMsgTargetName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildeid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysUtilDEId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getPSSysUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildename", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getPSSysUtilDEName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getTargetPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetpsdefid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getTargetPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getTargetPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetpsdefname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getTargetPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getTargetTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettypepsdefid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getTargetTypePSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getTargetTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettypepsdefname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getTargetTypePSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUser2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUser2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUser2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUser2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUserPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefid", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUserPSDEFId()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUserPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefname", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUserPSDEFName()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysMsgTargetBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysMsgTargetBase.getJSONValue((Object)pSSysMsgTargetBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysMsgTargetBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysMsgTargetBase pSSysMsgTargetBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysMsgTargetBase.getCodeName() != null) {
            object = pSSysMsgTargetBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getCreateDate() != null) {
            object = pSSysMsgTargetBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMsgTargetBase.getCreateMan() != null) {
            object = pSSysMsgTargetBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getCustomCode() != null) {
            object = pSSysMsgTargetBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getCustomMode() != null) {
            object = pSSysMsgTargetBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysMsgTargetBase.getMemo() != null) {
            object = pSSysMsgTargetBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetParams() != null) {
            object = pSSysMsgTargetBase.getMsgTargetParams();
            xmlNode.setAttribute(FIELD_MSGTARGETPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetTag() != null) {
            object = pSSysMsgTargetBase.getMsgTargetTag();
            xmlNode.setAttribute(FIELD_MSGTARGETTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetTag2() != null) {
            object = pSSysMsgTargetBase.getMsgTargetTag2();
            xmlNode.setAttribute(FIELD_MSGTARGETTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getMsgTargetType() != null) {
            object = pSSysMsgTargetBase.getMsgTargetType();
            xmlNode.setAttribute(FIELD_MSGTARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSDEDSId() != null) {
            object = pSSysMsgTargetBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSDEDSName() != null) {
            object = pSSysMsgTargetBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSDEId() != null) {
            object = pSSysMsgTargetBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSDEName() != null) {
            object = pSSysMsgTargetBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSModuleId() != null) {
            object = pSSysMsgTargetBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSModuleName() != null) {
            object = pSSysMsgTargetBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysDynaModelId() != null) {
            object = pSSysMsgTargetBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysDynaModelName() != null) {
            object = pSSysMsgTargetBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysMsgTargetId() != null) {
            object = pSSysMsgTargetBase.getPSSysMsgTargetId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTARGETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysMsgTargetName() != null) {
            object = pSSysMsgTargetBase.getPSSysMsgTargetName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTARGETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysSFPluginId() != null) {
            object = pSSysMsgTargetBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysSFPluginName() != null) {
            object = pSSysMsgTargetBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSystemId() != null) {
            object = pSSysMsgTargetBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSystemName() != null) {
            object = pSSysMsgTargetBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysUtilDEId() != null) {
            object = pSSysMsgTargetBase.getPSSysUtilDEId();
            xmlNode.setAttribute(FIELD_PSSYSUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getPSSysUtilDEName() != null) {
            object = pSSysMsgTargetBase.getPSSysUtilDEName();
            xmlNode.setAttribute(FIELD_PSSYSUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getTargetPSDEFId() != null) {
            object = pSSysMsgTargetBase.getTargetPSDEFId();
            xmlNode.setAttribute(FIELD_TARGETPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getTargetPSDEFName() != null) {
            object = pSSysMsgTargetBase.getTargetPSDEFName();
            xmlNode.setAttribute(FIELD_TARGETPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getTargetTypePSDEFId() != null) {
            object = pSSysMsgTargetBase.getTargetTypePSDEFId();
            xmlNode.setAttribute(FIELD_TARGETTYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getTargetTypePSDEFName() != null) {
            object = pSSysMsgTargetBase.getTargetTypePSDEFName();
            xmlNode.setAttribute(FIELD_TARGETTYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUpdateDate() != null) {
            object = pSSysMsgTargetBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysMsgTargetBase.getUpdateMan() != null) {
            object = pSSysMsgTargetBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUser2PSDEFId() != null) {
            object = pSSysMsgTargetBase.getUser2PSDEFId();
            xmlNode.setAttribute(FIELD_USER2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUser2PSDEFName() != null) {
            object = pSSysMsgTargetBase.getUser2PSDEFName();
            xmlNode.setAttribute(FIELD_USER2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUserCat() != null) {
            object = pSSysMsgTargetBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUserPSDEFId() != null) {
            object = pSSysMsgTargetBase.getUserPSDEFId();
            xmlNode.setAttribute(FIELD_USERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUserPSDEFName() != null) {
            object = pSSysMsgTargetBase.getUserPSDEFName();
            xmlNode.setAttribute(FIELD_USERPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUserTag() != null) {
            object = pSSysMsgTargetBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUserTag2() != null) {
            object = pSSysMsgTargetBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUserTag3() != null) {
            object = pSSysMsgTargetBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getUserTag4() != null) {
            object = pSSysMsgTargetBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysMsgTargetBase.getValidFlag() != null) {
            object = pSSysMsgTargetBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysMsgTargetBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysMsgTargetBase pSSysMsgTargetBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysMsgTargetBase.isCodeNameDirty() && (bl || pSSysMsgTargetBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysMsgTargetBase.getCodeName());
        }
        if (pSSysMsgTargetBase.isCreateDateDirty() && (bl || pSSysMsgTargetBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysMsgTargetBase.getCreateDate());
        }
        if (pSSysMsgTargetBase.isCreateManDirty() && (bl || pSSysMsgTargetBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysMsgTargetBase.getCreateMan());
        }
        if (pSSysMsgTargetBase.isCustomCodeDirty() && (bl || pSSysMsgTargetBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysMsgTargetBase.getCustomCode());
        }
        if (pSSysMsgTargetBase.isCustomModeDirty() && (bl || pSSysMsgTargetBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysMsgTargetBase.getCustomMode());
        }
        if (pSSysMsgTargetBase.isMemoDirty() && (bl || pSSysMsgTargetBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysMsgTargetBase.getMemo());
        }
        if (pSSysMsgTargetBase.isMsgTargetParamsDirty() && (bl || pSSysMsgTargetBase.getMsgTargetParams() != null)) {
            iDataObject.set(FIELD_MSGTARGETPARAMS, (Object)pSSysMsgTargetBase.getMsgTargetParams());
        }
        if (pSSysMsgTargetBase.isMsgTargetTagDirty() && (bl || pSSysMsgTargetBase.getMsgTargetTag() != null)) {
            iDataObject.set(FIELD_MSGTARGETTAG, (Object)pSSysMsgTargetBase.getMsgTargetTag());
        }
        if (pSSysMsgTargetBase.isMsgTargetTag2Dirty() && (bl || pSSysMsgTargetBase.getMsgTargetTag2() != null)) {
            iDataObject.set(FIELD_MSGTARGETTAG2, (Object)pSSysMsgTargetBase.getMsgTargetTag2());
        }
        if (pSSysMsgTargetBase.isMsgTargetTypeDirty() && (bl || pSSysMsgTargetBase.getMsgTargetType() != null)) {
            iDataObject.set(FIELD_MSGTARGETTYPE, (Object)pSSysMsgTargetBase.getMsgTargetType());
        }
        if (pSSysMsgTargetBase.isPSDEDSIdDirty() && (bl || pSSysMsgTargetBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSSysMsgTargetBase.getPSDEDSId());
        }
        if (pSSysMsgTargetBase.isPSDEDSNameDirty() && (bl || pSSysMsgTargetBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSSysMsgTargetBase.getPSDEDSName());
        }
        if (pSSysMsgTargetBase.isPSDEIdDirty() && (bl || pSSysMsgTargetBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysMsgTargetBase.getPSDEId());
        }
        if (pSSysMsgTargetBase.isPSDENameDirty() && (bl || pSSysMsgTargetBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysMsgTargetBase.getPSDEName());
        }
        if (pSSysMsgTargetBase.isPSModuleIdDirty() && (bl || pSSysMsgTargetBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysMsgTargetBase.getPSModuleId());
        }
        if (pSSysMsgTargetBase.isPSModuleNameDirty() && (bl || pSSysMsgTargetBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysMsgTargetBase.getPSModuleName());
        }
        if (pSSysMsgTargetBase.isPSSysDynaModelIdDirty() && (bl || pSSysMsgTargetBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysMsgTargetBase.getPSSysDynaModelId());
        }
        if (pSSysMsgTargetBase.isPSSysDynaModelNameDirty() && (bl || pSSysMsgTargetBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysMsgTargetBase.getPSSysDynaModelName());
        }
        if (pSSysMsgTargetBase.isPSSysMsgTargetIdDirty() && (bl || pSSysMsgTargetBase.getPSSysMsgTargetId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTARGETID, (Object)pSSysMsgTargetBase.getPSSysMsgTargetId());
        }
        if (pSSysMsgTargetBase.isPSSysMsgTargetNameDirty() && (bl || pSSysMsgTargetBase.getPSSysMsgTargetName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTARGETNAME, (Object)pSSysMsgTargetBase.getPSSysMsgTargetName());
        }
        if (pSSysMsgTargetBase.isPSSysSFPluginIdDirty() && (bl || pSSysMsgTargetBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysMsgTargetBase.getPSSysSFPluginId());
        }
        if (pSSysMsgTargetBase.isPSSysSFPluginNameDirty() && (bl || pSSysMsgTargetBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysMsgTargetBase.getPSSysSFPluginName());
        }
        if (pSSysMsgTargetBase.isPSSystemIdDirty() && (bl || pSSysMsgTargetBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysMsgTargetBase.getPSSystemId());
        }
        if (pSSysMsgTargetBase.isPSSystemNameDirty() && (bl || pSSysMsgTargetBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysMsgTargetBase.getPSSystemName());
        }
        if (pSSysMsgTargetBase.isPSSysUtilDEIdDirty() && (bl || pSSysMsgTargetBase.getPSSysUtilDEId() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDEID, (Object)pSSysMsgTargetBase.getPSSysUtilDEId());
        }
        if (pSSysMsgTargetBase.isPSSysUtilDENameDirty() && (bl || pSSysMsgTargetBase.getPSSysUtilDEName() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDENAME, (Object)pSSysMsgTargetBase.getPSSysUtilDEName());
        }
        if (pSSysMsgTargetBase.isTargetPSDEFIdDirty() && (bl || pSSysMsgTargetBase.getTargetPSDEFId() != null)) {
            iDataObject.set(FIELD_TARGETPSDEFID, (Object)pSSysMsgTargetBase.getTargetPSDEFId());
        }
        if (pSSysMsgTargetBase.isTargetPSDEFNameDirty() && (bl || pSSysMsgTargetBase.getTargetPSDEFName() != null)) {
            iDataObject.set(FIELD_TARGETPSDEFNAME, (Object)pSSysMsgTargetBase.getTargetPSDEFName());
        }
        if (pSSysMsgTargetBase.isTargetTypePSDEFIdDirty() && (bl || pSSysMsgTargetBase.getTargetTypePSDEFId() != null)) {
            iDataObject.set(FIELD_TARGETTYPEPSDEFID, (Object)pSSysMsgTargetBase.getTargetTypePSDEFId());
        }
        if (pSSysMsgTargetBase.isTargetTypePSDEFNameDirty() && (bl || pSSysMsgTargetBase.getTargetTypePSDEFName() != null)) {
            iDataObject.set(FIELD_TARGETTYPEPSDEFNAME, (Object)pSSysMsgTargetBase.getTargetTypePSDEFName());
        }
        if (pSSysMsgTargetBase.isUpdateDateDirty() && (bl || pSSysMsgTargetBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysMsgTargetBase.getUpdateDate());
        }
        if (pSSysMsgTargetBase.isUpdateManDirty() && (bl || pSSysMsgTargetBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysMsgTargetBase.getUpdateMan());
        }
        if (pSSysMsgTargetBase.isUser2PSDEFIdDirty() && (bl || pSSysMsgTargetBase.getUser2PSDEFId() != null)) {
            iDataObject.set(FIELD_USER2PSDEFID, (Object)pSSysMsgTargetBase.getUser2PSDEFId());
        }
        if (pSSysMsgTargetBase.isUser2PSDEFNameDirty() && (bl || pSSysMsgTargetBase.getUser2PSDEFName() != null)) {
            iDataObject.set(FIELD_USER2PSDEFNAME, (Object)pSSysMsgTargetBase.getUser2PSDEFName());
        }
        if (pSSysMsgTargetBase.isUserCatDirty() && (bl || pSSysMsgTargetBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysMsgTargetBase.getUserCat());
        }
        if (pSSysMsgTargetBase.isUserPSDEFIdDirty() && (bl || pSSysMsgTargetBase.getUserPSDEFId() != null)) {
            iDataObject.set(FIELD_USERPSDEFID, (Object)pSSysMsgTargetBase.getUserPSDEFId());
        }
        if (pSSysMsgTargetBase.isUserPSDEFNameDirty() && (bl || pSSysMsgTargetBase.getUserPSDEFName() != null)) {
            iDataObject.set(FIELD_USERPSDEFNAME, (Object)pSSysMsgTargetBase.getUserPSDEFName());
        }
        if (pSSysMsgTargetBase.isUserTagDirty() && (bl || pSSysMsgTargetBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysMsgTargetBase.getUserTag());
        }
        if (pSSysMsgTargetBase.isUserTag2Dirty() && (bl || pSSysMsgTargetBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysMsgTargetBase.getUserTag2());
        }
        if (pSSysMsgTargetBase.isUserTag3Dirty() && (bl || pSSysMsgTargetBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysMsgTargetBase.getUserTag3());
        }
        if (pSSysMsgTargetBase.isUserTag4Dirty() && (bl || pSSysMsgTargetBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysMsgTargetBase.getUserTag4());
        }
        if (pSSysMsgTargetBase.isValidFlagDirty() && (bl || pSSysMsgTargetBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysMsgTargetBase.getValidFlag());
        }
    }

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
        return PSSysMsgTargetBase.remove(this, n);
    }

    private static boolean remove(PSSysMsgTargetBase pSSysMsgTargetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysMsgTargetBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysMsgTargetBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysMsgTargetBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysMsgTargetBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysMsgTargetBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSSysMsgTargetBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysMsgTargetBase.resetMsgTargetParams();
                return true;
            }
            case 7: {
                pSSysMsgTargetBase.resetMsgTargetTag();
                return true;
            }
            case 8: {
                pSSysMsgTargetBase.resetMsgTargetTag2();
                return true;
            }
            case 9: {
                pSSysMsgTargetBase.resetMsgTargetType();
                return true;
            }
            case 10: {
                pSSysMsgTargetBase.resetPSDEDSId();
                return true;
            }
            case 11: {
                pSSysMsgTargetBase.resetPSDEDSName();
                return true;
            }
            case 12: {
                pSSysMsgTargetBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysMsgTargetBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSSysMsgTargetBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSSysMsgTargetBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSSysMsgTargetBase.resetPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSSysMsgTargetBase.resetPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSSysMsgTargetBase.resetPSSysMsgTargetId();
                return true;
            }
            case 19: {
                pSSysMsgTargetBase.resetPSSysMsgTargetName();
                return true;
            }
            case 20: {
                pSSysMsgTargetBase.resetPSSysSFPluginId();
                return true;
            }
            case 21: {
                pSSysMsgTargetBase.resetPSSysSFPluginName();
                return true;
            }
            case 22: {
                pSSysMsgTargetBase.resetPSSystemId();
                return true;
            }
            case 23: {
                pSSysMsgTargetBase.resetPSSystemName();
                return true;
            }
            case 24: {
                pSSysMsgTargetBase.resetPSSysUtilDEId();
                return true;
            }
            case 25: {
                pSSysMsgTargetBase.resetPSSysUtilDEName();
                return true;
            }
            case 26: {
                pSSysMsgTargetBase.resetTargetPSDEFId();
                return true;
            }
            case 27: {
                pSSysMsgTargetBase.resetTargetPSDEFName();
                return true;
            }
            case 28: {
                pSSysMsgTargetBase.resetTargetTypePSDEFId();
                return true;
            }
            case 29: {
                pSSysMsgTargetBase.resetTargetTypePSDEFName();
                return true;
            }
            case 30: {
                pSSysMsgTargetBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSSysMsgTargetBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSSysMsgTargetBase.resetUser2PSDEFId();
                return true;
            }
            case 33: {
                pSSysMsgTargetBase.resetUser2PSDEFName();
                return true;
            }
            case 34: {
                pSSysMsgTargetBase.resetUserCat();
                return true;
            }
            case 35: {
                pSSysMsgTargetBase.resetUserPSDEFId();
                return true;
            }
            case 36: {
                pSSysMsgTargetBase.resetUserPSDEFName();
                return true;
            }
            case 37: {
                pSSysMsgTargetBase.resetUserTag();
                return true;
            }
            case 38: {
                pSSysMsgTargetBase.resetUserTag2();
                return true;
            }
            case 39: {
                pSSysMsgTargetBase.resetUserTag3();
                return true;
            }
            case 40: {
                pSSysMsgTargetBase.resetUserTag4();
                return true;
            }
            case 41: {
                pSSysMsgTargetBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTargetPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetPSDEF();
        }
        if (this.getTargetPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTargetPSDEFLock;
        synchronized (n) {
            if (this.targetpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTargetPSDEFId(), (Object)this.targetpsdef.getPSDEFieldId()) != 0L) {
                this.targetpsdef = null;
            }
            if (this.targetpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTargetPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.targetpsdef = pSDEField;
            }
            return this.targetpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTargetTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetTypePSDEF();
        }
        if (this.getTargetTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTargetTypePSDEFLock;
        synchronized (n) {
            if (this.targettypepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTargetTypePSDEFId(), (Object)this.targettypepsdef.getPSDEFieldId()) != 0L) {
                this.targettypepsdef = null;
            }
            if (this.targettypepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTargetTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.targettypepsdef = pSDEField;
            }
            return this.targettypepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUser2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEF();
        }
        if (this.getUser2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEFLock;
        synchronized (n) {
            if (this.user2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEFId(), (Object)this.user2psdef.getPSDEFieldId()) != 0L) {
                this.user2psdef = null;
            }
            if (this.user2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUser2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.user2psdef = pSDEField;
            }
            return this.user2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUserPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEF();
        }
        if (this.getUserPSDEFId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEFLock;
        synchronized (n) {
            if (this.userpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEFId(), (Object)this.userpsdef.getPSDEFieldId()) != 0L) {
                this.userpsdef = null;
            }
            if (this.userpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUserPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.userpsdef = pSDEField;
            }
            return this.userpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUtilDE getPSSysUtilDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDE();
        }
        if (this.getPSSysUtilDEId() == null) {
            return null;
        }
        Integer n = this.objPSSysUtilDELock;
        synchronized (n) {
            if (this.pssysutilde != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUtilDEId(), (Object)this.pssysutilde.getPSSysUtilDEId()) != 0L) {
                this.pssysutilde = null;
            }
            if (this.pssysutilde == null) {
                PSSysUtilDE pSSysUtilDE = new PSSysUtilDE();
                pSSysUtilDE.setPSSysUtilDEId(this.getPSSysUtilDEId());
                PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysUtilDEService.autoGet(pSSysUtilDE);
                this.pssysutilde = pSSysUtilDE;
            }
            return this.pssysutilde;
        }
    }

    private PSSysMsgTargetBase getProxyEntity() {
        return this.proxyPSSysMsgTargetBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysMsgTargetBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysMsgTargetBase) {
            this.proxyPSSysMsgTargetBase = (PSSysMsgTargetBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MSGTARGETPARAMS, 6);
        fieldIndexMap.put(FIELD_MSGTARGETTAG, 7);
        fieldIndexMap.put(FIELD_MSGTARGETTAG2, 8);
        fieldIndexMap.put(FIELD_MSGTARGETTYPE, 9);
        fieldIndexMap.put(FIELD_PSDEDSID, 10);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSMSGTARGETID, 18);
        fieldIndexMap.put(FIELD_PSSYSMSGTARGETNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 20);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 22);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSUTILDEID, 24);
        fieldIndexMap.put(FIELD_PSSYSUTILDENAME, 25);
        fieldIndexMap.put(FIELD_TARGETPSDEFID, 26);
        fieldIndexMap.put(FIELD_TARGETPSDEFNAME, 27);
        fieldIndexMap.put(FIELD_TARGETTYPEPSDEFID, 28);
        fieldIndexMap.put(FIELD_TARGETTYPEPSDEFNAME, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_USER2PSDEFID, 32);
        fieldIndexMap.put(FIELD_USER2PSDEFNAME, 33);
        fieldIndexMap.put(FIELD_USERCAT, 34);
        fieldIndexMap.put(FIELD_USERPSDEFID, 35);
        fieldIndexMap.put(FIELD_USERPSDEFNAME, 36);
        fieldIndexMap.put(FIELD_USERTAG, 37);
        fieldIndexMap.put(FIELD_USERTAG2, 38);
        fieldIndexMap.put(FIELD_USERTAG3, 39);
        fieldIndexMap.put(FIELD_USERTAG4, 40);
        fieldIndexMap.put(FIELD_VALIDFLAG, 41);
    }
}

