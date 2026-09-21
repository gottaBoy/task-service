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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFRoleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFRoleBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSWFROLEID = "PSWFROLEID";
    public static final String FIELD_PSWFROLENAME = "PSWFROLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WFROLESN = "WFROLESN";
    public static final String FIELD_WFROLETYPE = "WFROLETYPE";
    public static final String FIELD_WFUSERIDPSDEFID = "WFUSERIDPSDEFID";
    public static final String FIELD_WFUSERIDPSDEFNAME = "WFUSERIDPSDEFNAME";
    public static final String FIELD_WFUSERNAMEPSDEFID = "WFUSERNAMEPSDEFID";
    public static final String FIELD_WFUSERNAMEPSDEFNAME = "WFUSERNAMEPSDEFNAME";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_ENABLE = 4;
    private static final int INDEX_LOCKFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEDSID = 7;
    private static final int INDEX_PSDEDSNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSDENAME = 10;
    private static final int INDEX_PSDYNAINSTID = 11;
    private static final int INDEX_PSMODULEID = 12;
    private static final int INDEX_PSMODULENAME = 13;
    private static final int INDEX_PSSYSSFPLUGINID = 14;
    private static final int INDEX_PSSYSSFPLUGINNAME = 15;
    private static final int INDEX_PSSYSTEMID = 16;
    private static final int INDEX_PSSYSTEMNAME = 17;
    private static final int INDEX_PSWFROLEID = 18;
    private static final int INDEX_PSWFROLENAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERDATA = 23;
    private static final int INDEX_USERDATA2 = 24;
    private static final int INDEX_USERTAG = 25;
    private static final int INDEX_USERTAG2 = 26;
    private static final int INDEX_USERTAG3 = 27;
    private static final int INDEX_USERTAG4 = 28;
    private static final int INDEX_WFROLESN = 29;
    private static final int INDEX_WFROLETYPE = 30;
    private static final int INDEX_WFUSERIDPSDEFID = 31;
    private static final int INDEX_WFUSERIDPSDEFNAME = 32;
    private static final int INDEX_WFUSERNAMEPSDEFID = 33;
    private static final int INDEX_WFUSERNAMEPSDEFNAME = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFRoleBase proxyPSWFRoleBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pswfroleidDirtyFlag = false;
    private boolean pswfrolenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean wfrolesnDirtyFlag = false;
    private boolean wfroletypeDirtyFlag = false;
    private boolean wfuseridpsdefidDirtyFlag = false;
    private boolean wfuseridpsdefnameDirtyFlag = false;
    private boolean wfusernamepsdefidDirtyFlag = false;
    private boolean wfusernamepsdefnameDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enable")
    private Integer enable;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pswfroleid")
    private String pswfroleid;
    @Column(name="pswfrolename")
    private String pswfrolename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="wfrolesn")
    private String wfrolesn;
    @Column(name="wfroletype")
    private String wfroletype;
    @Column(name="wfuseridpsdefid")
    private String wfuseridpsdefid;
    @Column(name="wfuseridpsdefname")
    private String wfuseridpsdefname;
    @Column(name="wfusernamepsdefid")
    private String wfusernamepsdefid;
    @Column(name="wfusernamepsdefname")
    private String wfusernamepsdefname;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objWFUserIdPSDEFLock = new Integer(1);
    private PSDEField wfuseridpsdef = null;
    private Integer objWFUserNamePSDEFLock = new Integer(1);
    private PSDEField wfusernamepsdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
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

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setPSWFRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfroleid = string;
        this.pswfroleidDirtyFlag = true;
    }

    public String getPSWFRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRoleId();
        }
        return this.pswfroleid;
    }

    public boolean isPSWFRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFRoleIdDirty();
        }
        return this.pswfroleidDirtyFlag;
    }

    public void resetPSWFRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFRoleId();
            return;
        }
        this.pswfroleidDirtyFlag = false;
        this.pswfroleid = null;
    }

    public void setPSWFRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfrolename = string;
        this.pswfrolenameDirtyFlag = true;
    }

    public String getPSWFRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRoleName();
        }
        return this.pswfrolename;
    }

    public boolean isPSWFRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFRoleNameDirty();
        }
        return this.pswfrolenameDirtyFlag;
    }

    public void resetPSWFRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFRoleName();
            return;
        }
        this.pswfrolenameDirtyFlag = false;
        this.pswfrolename = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
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

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
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

    public void setWFRoleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFRoleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfrolesn = string;
        this.wfrolesnDirtyFlag = true;
    }

    public String getWFRoleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFRoleSN();
        }
        return this.wfrolesn;
    }

    public boolean isWFRoleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFRoleSNDirty();
        }
        return this.wfrolesnDirtyFlag;
    }

    public void resetWFRoleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFRoleSN();
            return;
        }
        this.wfrolesnDirtyFlag = false;
        this.wfrolesn = null;
    }

    public void setWFRoleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFRoleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfroletype = string;
        this.wfroletypeDirtyFlag = true;
    }

    public String getWFRoleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFRoleType();
        }
        return this.wfroletype;
    }

    public boolean isWFRoleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFRoleTypeDirty();
        }
        return this.wfroletypeDirtyFlag;
    }

    public void resetWFRoleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFRoleType();
            return;
        }
        this.wfroletypeDirtyFlag = false;
        this.wfroletype = null;
    }

    public void setWFUserIdPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserIdPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfuseridpsdefid = string;
        this.wfuseridpsdefidDirtyFlag = true;
    }

    public String getWFUserIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserIdPSDEFId();
        }
        return this.wfuseridpsdefid;
    }

    public boolean isWFUserIdPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserIdPSDEFIdDirty();
        }
        return this.wfuseridpsdefidDirtyFlag;
    }

    public void resetWFUserIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserIdPSDEFId();
            return;
        }
        this.wfuseridpsdefidDirtyFlag = false;
        this.wfuseridpsdefid = null;
    }

    public void setWFUserIdPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserIdPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfuseridpsdefname = string;
        this.wfuseridpsdefnameDirtyFlag = true;
    }

    public String getWFUserIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserIdPSDEFName();
        }
        return this.wfuseridpsdefname;
    }

    public boolean isWFUserIdPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserIdPSDEFNameDirty();
        }
        return this.wfuseridpsdefnameDirtyFlag;
    }

    public void resetWFUserIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserIdPSDEFName();
            return;
        }
        this.wfuseridpsdefnameDirtyFlag = false;
        this.wfuseridpsdefname = null;
    }

    public void setWFUserNamePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserNamePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfusernamepsdefid = string;
        this.wfusernamepsdefidDirtyFlag = true;
    }

    public String getWFUserNamePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserNamePSDEFId();
        }
        return this.wfusernamepsdefid;
    }

    public boolean isWFUserNamePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserNamePSDEFIdDirty();
        }
        return this.wfusernamepsdefidDirtyFlag;
    }

    public void resetWFUserNamePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserNamePSDEFId();
            return;
        }
        this.wfusernamepsdefidDirtyFlag = false;
        this.wfusernamepsdefid = null;
    }

    public void setWFUserNamePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserNamePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfusernamepsdefname = string;
        this.wfusernamepsdefnameDirtyFlag = true;
    }

    public String getWFUserNamePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserNamePSDEFName();
        }
        return this.wfusernamepsdefname;
    }

    public boolean isWFUserNamePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserNamePSDEFNameDirty();
        }
        return this.wfusernamepsdefnameDirtyFlag;
    }

    public void resetWFUserNamePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserNamePSDEFName();
            return;
        }
        this.wfusernamepsdefnameDirtyFlag = false;
        this.wfusernamepsdefname = null;
    }

    protected void onReset() {
        PSWFRoleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFRoleBase pSWFRoleBase) {
        pSWFRoleBase.resetCodeName();
        pSWFRoleBase.resetCreateDate();
        pSWFRoleBase.resetCreateMan();
        pSWFRoleBase.resetDynaModelFlag();
        pSWFRoleBase.resetEnable();
        pSWFRoleBase.resetLockFlag();
        pSWFRoleBase.resetMemo();
        pSWFRoleBase.resetPSDEDSId();
        pSWFRoleBase.resetPSDEDSName();
        pSWFRoleBase.resetPSDEId();
        pSWFRoleBase.resetPSDEName();
        pSWFRoleBase.resetPSDynaInstId();
        pSWFRoleBase.resetPSModuleId();
        pSWFRoleBase.resetPSModuleName();
        pSWFRoleBase.resetPSSysSFPluginId();
        pSWFRoleBase.resetPSSysSFPluginName();
        pSWFRoleBase.resetPSSystemId();
        pSWFRoleBase.resetPSSystemName();
        pSWFRoleBase.resetPSWFRoleId();
        pSWFRoleBase.resetPSWFRoleName();
        pSWFRoleBase.resetUpdateDate();
        pSWFRoleBase.resetUpdateMan();
        pSWFRoleBase.resetUserCat();
        pSWFRoleBase.resetUserData();
        pSWFRoleBase.resetUserData2();
        pSWFRoleBase.resetUserTag();
        pSWFRoleBase.resetUserTag2();
        pSWFRoleBase.resetUserTag3();
        pSWFRoleBase.resetUserTag4();
        pSWFRoleBase.resetWFRoleSN();
        pSWFRoleBase.resetWFRoleType();
        pSWFRoleBase.resetWFUserIdPSDEFId();
        pSWFRoleBase.resetWFUserIdPSDEFName();
        pSWFRoleBase.resetWFUserNamePSDEFId();
        pSWFRoleBase.resetWFUserNamePSDEFName();
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
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
        if (!bl || this.isPSWFRoleIdDirty()) {
            hashMap.put(FIELD_PSWFROLEID, this.getPSWFRoleId());
        }
        if (!bl || this.isPSWFRoleNameDirty()) {
            hashMap.put(FIELD_PSWFROLENAME, this.getPSWFRoleName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        if (!bl || this.isWFRoleSNDirty()) {
            hashMap.put(FIELD_WFROLESN, this.getWFRoleSN());
        }
        if (!bl || this.isWFRoleTypeDirty()) {
            hashMap.put(FIELD_WFROLETYPE, this.getWFRoleType());
        }
        if (!bl || this.isWFUserIdPSDEFIdDirty()) {
            hashMap.put(FIELD_WFUSERIDPSDEFID, this.getWFUserIdPSDEFId());
        }
        if (!bl || this.isWFUserIdPSDEFNameDirty()) {
            hashMap.put(FIELD_WFUSERIDPSDEFNAME, this.getWFUserIdPSDEFName());
        }
        if (!bl || this.isWFUserNamePSDEFIdDirty()) {
            hashMap.put(FIELD_WFUSERNAMEPSDEFID, this.getWFUserNamePSDEFId());
        }
        if (!bl || this.isWFUserNamePSDEFNameDirty()) {
            hashMap.put(FIELD_WFUSERNAMEPSDEFNAME, this.getWFUserNamePSDEFName());
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
        return PSWFRoleBase.get(this, n);
    }

    private static Object get(PSWFRoleBase pSWFRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFRoleBase.getCodeName();
            }
            case 1: {
                return pSWFRoleBase.getCreateDate();
            }
            case 2: {
                return pSWFRoleBase.getCreateMan();
            }
            case 3: {
                return pSWFRoleBase.getDynaModelFlag();
            }
            case 4: {
                return pSWFRoleBase.getEnable();
            }
            case 5: {
                return pSWFRoleBase.getLockFlag();
            }
            case 6: {
                return pSWFRoleBase.getMemo();
            }
            case 7: {
                return pSWFRoleBase.getPSDEDSId();
            }
            case 8: {
                return pSWFRoleBase.getPSDEDSName();
            }
            case 9: {
                return pSWFRoleBase.getPSDEId();
            }
            case 10: {
                return pSWFRoleBase.getPSDEName();
            }
            case 11: {
                return pSWFRoleBase.getPSDynaInstId();
            }
            case 12: {
                return pSWFRoleBase.getPSModuleId();
            }
            case 13: {
                return pSWFRoleBase.getPSModuleName();
            }
            case 14: {
                return pSWFRoleBase.getPSSysSFPluginId();
            }
            case 15: {
                return pSWFRoleBase.getPSSysSFPluginName();
            }
            case 16: {
                return pSWFRoleBase.getPSSystemId();
            }
            case 17: {
                return pSWFRoleBase.getPSSystemName();
            }
            case 18: {
                return pSWFRoleBase.getPSWFRoleId();
            }
            case 19: {
                return pSWFRoleBase.getPSWFRoleName();
            }
            case 20: {
                return pSWFRoleBase.getUpdateDate();
            }
            case 21: {
                return pSWFRoleBase.getUpdateMan();
            }
            case 22: {
                return pSWFRoleBase.getUserCat();
            }
            case 23: {
                return pSWFRoleBase.getUserData();
            }
            case 24: {
                return pSWFRoleBase.getUserData2();
            }
            case 25: {
                return pSWFRoleBase.getUserTag();
            }
            case 26: {
                return pSWFRoleBase.getUserTag2();
            }
            case 27: {
                return pSWFRoleBase.getUserTag3();
            }
            case 28: {
                return pSWFRoleBase.getUserTag4();
            }
            case 29: {
                return pSWFRoleBase.getWFRoleSN();
            }
            case 30: {
                return pSWFRoleBase.getWFRoleType();
            }
            case 31: {
                return pSWFRoleBase.getWFUserIdPSDEFId();
            }
            case 32: {
                return pSWFRoleBase.getWFUserIdPSDEFName();
            }
            case 33: {
                return pSWFRoleBase.getWFUserNamePSDEFId();
            }
            case 34: {
                return pSWFRoleBase.getWFUserNamePSDEFName();
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
        PSWFRoleBase.set(this, n, object);
    }

    private static void set(PSWFRoleBase pSWFRoleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFRoleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFRoleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWFRoleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFRoleBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWFRoleBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWFRoleBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSWFRoleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFRoleBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFRoleBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFRoleBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFRoleBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFRoleBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFRoleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFRoleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFRoleBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFRoleBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFRoleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFRoleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFRoleBase.setPSWFRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFRoleBase.setPSWFRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFRoleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSWFRoleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFRoleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFRoleBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFRoleBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWFRoleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFRoleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWFRoleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWFRoleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWFRoleBase.setWFRoleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSWFRoleBase.setWFRoleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSWFRoleBase.setWFUserIdPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSWFRoleBase.setWFUserIdPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSWFRoleBase.setWFUserNamePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSWFRoleBase.setWFUserNamePSDEFName(DataObject.getStringValue((Object)object));
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
        return PSWFRoleBase.isNull(this, n);
    }

    private static boolean isNull(PSWFRoleBase pSWFRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFRoleBase.getCodeName() == null;
            }
            case 1: {
                return pSWFRoleBase.getCreateDate() == null;
            }
            case 2: {
                return pSWFRoleBase.getCreateMan() == null;
            }
            case 3: {
                return pSWFRoleBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSWFRoleBase.getEnable() == null;
            }
            case 5: {
                return pSWFRoleBase.getLockFlag() == null;
            }
            case 6: {
                return pSWFRoleBase.getMemo() == null;
            }
            case 7: {
                return pSWFRoleBase.getPSDEDSId() == null;
            }
            case 8: {
                return pSWFRoleBase.getPSDEDSName() == null;
            }
            case 9: {
                return pSWFRoleBase.getPSDEId() == null;
            }
            case 10: {
                return pSWFRoleBase.getPSDEName() == null;
            }
            case 11: {
                return pSWFRoleBase.getPSDynaInstId() == null;
            }
            case 12: {
                return pSWFRoleBase.getPSModuleId() == null;
            }
            case 13: {
                return pSWFRoleBase.getPSModuleName() == null;
            }
            case 14: {
                return pSWFRoleBase.getPSSysSFPluginId() == null;
            }
            case 15: {
                return pSWFRoleBase.getPSSysSFPluginName() == null;
            }
            case 16: {
                return pSWFRoleBase.getPSSystemId() == null;
            }
            case 17: {
                return pSWFRoleBase.getPSSystemName() == null;
            }
            case 18: {
                return pSWFRoleBase.getPSWFRoleId() == null;
            }
            case 19: {
                return pSWFRoleBase.getPSWFRoleName() == null;
            }
            case 20: {
                return pSWFRoleBase.getUpdateDate() == null;
            }
            case 21: {
                return pSWFRoleBase.getUpdateMan() == null;
            }
            case 22: {
                return pSWFRoleBase.getUserCat() == null;
            }
            case 23: {
                return pSWFRoleBase.getUserData() == null;
            }
            case 24: {
                return pSWFRoleBase.getUserData2() == null;
            }
            case 25: {
                return pSWFRoleBase.getUserTag() == null;
            }
            case 26: {
                return pSWFRoleBase.getUserTag2() == null;
            }
            case 27: {
                return pSWFRoleBase.getUserTag3() == null;
            }
            case 28: {
                return pSWFRoleBase.getUserTag4() == null;
            }
            case 29: {
                return pSWFRoleBase.getWFRoleSN() == null;
            }
            case 30: {
                return pSWFRoleBase.getWFRoleType() == null;
            }
            case 31: {
                return pSWFRoleBase.getWFUserIdPSDEFId() == null;
            }
            case 32: {
                return pSWFRoleBase.getWFUserIdPSDEFName() == null;
            }
            case 33: {
                return pSWFRoleBase.getWFUserNamePSDEFId() == null;
            }
            case 34: {
                return pSWFRoleBase.getWFUserNamePSDEFName() == null;
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
        return PSWFRoleBase.contains(this, n);
    }

    private static boolean contains(PSWFRoleBase pSWFRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFRoleBase.isCodeNameDirty();
            }
            case 1: {
                return pSWFRoleBase.isCreateDateDirty();
            }
            case 2: {
                return pSWFRoleBase.isCreateManDirty();
            }
            case 3: {
                return pSWFRoleBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSWFRoleBase.isEnableDirty();
            }
            case 5: {
                return pSWFRoleBase.isLockFlagDirty();
            }
            case 6: {
                return pSWFRoleBase.isMemoDirty();
            }
            case 7: {
                return pSWFRoleBase.isPSDEDSIdDirty();
            }
            case 8: {
                return pSWFRoleBase.isPSDEDSNameDirty();
            }
            case 9: {
                return pSWFRoleBase.isPSDEIdDirty();
            }
            case 10: {
                return pSWFRoleBase.isPSDENameDirty();
            }
            case 11: {
                return pSWFRoleBase.isPSDynaInstIdDirty();
            }
            case 12: {
                return pSWFRoleBase.isPSModuleIdDirty();
            }
            case 13: {
                return pSWFRoleBase.isPSModuleNameDirty();
            }
            case 14: {
                return pSWFRoleBase.isPSSysSFPluginIdDirty();
            }
            case 15: {
                return pSWFRoleBase.isPSSysSFPluginNameDirty();
            }
            case 16: {
                return pSWFRoleBase.isPSSystemIdDirty();
            }
            case 17: {
                return pSWFRoleBase.isPSSystemNameDirty();
            }
            case 18: {
                return pSWFRoleBase.isPSWFRoleIdDirty();
            }
            case 19: {
                return pSWFRoleBase.isPSWFRoleNameDirty();
            }
            case 20: {
                return pSWFRoleBase.isUpdateDateDirty();
            }
            case 21: {
                return pSWFRoleBase.isUpdateManDirty();
            }
            case 22: {
                return pSWFRoleBase.isUserCatDirty();
            }
            case 23: {
                return pSWFRoleBase.isUserDataDirty();
            }
            case 24: {
                return pSWFRoleBase.isUserData2Dirty();
            }
            case 25: {
                return pSWFRoleBase.isUserTagDirty();
            }
            case 26: {
                return pSWFRoleBase.isUserTag2Dirty();
            }
            case 27: {
                return pSWFRoleBase.isUserTag3Dirty();
            }
            case 28: {
                return pSWFRoleBase.isUserTag4Dirty();
            }
            case 29: {
                return pSWFRoleBase.isWFRoleSNDirty();
            }
            case 30: {
                return pSWFRoleBase.isWFRoleTypeDirty();
            }
            case 31: {
                return pSWFRoleBase.isWFUserIdPSDEFIdDirty();
            }
            case 32: {
                return pSWFRoleBase.isWFUserIdPSDEFNameDirty();
            }
            case 33: {
                return pSWFRoleBase.isWFUserNamePSDEFIdDirty();
            }
            case 34: {
                return pSWFRoleBase.isWFUserNamePSDEFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFRoleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFRoleBase pSWFRoleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFRoleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getEnable()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSWFRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfroleid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSWFRoleId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getPSWFRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfrolename", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getPSWFRoleName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUserData()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUserData2()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getWFRoleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfrolesn", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getWFRoleSN()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getWFRoleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfroletype", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getWFRoleType()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getWFUserIdPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfuseridpsdefid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getWFUserIdPSDEFId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getWFUserIdPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfuseridpsdefname", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getWFUserIdPSDEFName()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getWFUserNamePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfusernamepsdefid", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getWFUserNamePSDEFId()), (boolean)false);
        }
        if (bl || pSWFRoleBase.getWFUserNamePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfusernamepsdefname", (Object)PSWFRoleBase.getJSONValue((Object)pSWFRoleBase.getWFUserNamePSDEFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFRoleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFRoleBase pSWFRoleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFRoleBase.getCodeName() != null) {
            object = pSWFRoleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getCreateDate() != null) {
            object = pSWFRoleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFRoleBase.getCreateMan() != null) {
            object = pSWFRoleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getDynaModelFlag() != null) {
            object = pSWFRoleBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFRoleBase.getEnable() != null) {
            object = pSWFRoleBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFRoleBase.getLockFlag() != null) {
            object = pSWFRoleBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFRoleBase.getMemo() != null) {
            object = pSWFRoleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSDEDSId() != null) {
            object = pSWFRoleBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSDEDSName() != null) {
            object = pSWFRoleBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSDEId() != null) {
            object = pSWFRoleBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSDEName() != null) {
            object = pSWFRoleBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSDynaInstId() != null) {
            object = pSWFRoleBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSModuleId() != null) {
            object = pSWFRoleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSModuleName() != null) {
            object = pSWFRoleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSSysSFPluginId() != null) {
            object = pSWFRoleBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSSysSFPluginName() != null) {
            object = pSWFRoleBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSSystemId() != null) {
            object = pSWFRoleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSSystemName() != null) {
            object = pSWFRoleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSWFRoleId() != null) {
            object = pSWFRoleBase.getPSWFRoleId();
            xmlNode.setAttribute(FIELD_PSWFROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getPSWFRoleName() != null) {
            object = pSWFRoleBase.getPSWFRoleName();
            xmlNode.setAttribute(FIELD_PSWFROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUpdateDate() != null) {
            object = pSWFRoleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFRoleBase.getUpdateMan() != null) {
            object = pSWFRoleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUserCat() != null) {
            object = pSWFRoleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUserData() != null) {
            object = pSWFRoleBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUserData2() != null) {
            object = pSWFRoleBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUserTag() != null) {
            object = pSWFRoleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUserTag2() != null) {
            object = pSWFRoleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUserTag3() != null) {
            object = pSWFRoleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getUserTag4() != null) {
            object = pSWFRoleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getWFRoleSN() != null) {
            object = pSWFRoleBase.getWFRoleSN();
            xmlNode.setAttribute(FIELD_WFROLESN, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getWFRoleType() != null) {
            object = pSWFRoleBase.getWFRoleType();
            xmlNode.setAttribute(FIELD_WFROLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getWFUserIdPSDEFId() != null) {
            object = pSWFRoleBase.getWFUserIdPSDEFId();
            xmlNode.setAttribute(FIELD_WFUSERIDPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getWFUserIdPSDEFName() != null) {
            object = pSWFRoleBase.getWFUserIdPSDEFName();
            xmlNode.setAttribute(FIELD_WFUSERIDPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getWFUserNamePSDEFId() != null) {
            object = pSWFRoleBase.getWFUserNamePSDEFId();
            xmlNode.setAttribute(FIELD_WFUSERNAMEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFRoleBase.getWFUserNamePSDEFName() != null) {
            object = pSWFRoleBase.getWFUserNamePSDEFName();
            xmlNode.setAttribute(FIELD_WFUSERNAMEPSDEFNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFRoleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFRoleBase pSWFRoleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFRoleBase.isCodeNameDirty() && (bl || pSWFRoleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWFRoleBase.getCodeName());
        }
        if (pSWFRoleBase.isCreateDateDirty() && (bl || pSWFRoleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFRoleBase.getCreateDate());
        }
        if (pSWFRoleBase.isCreateManDirty() && (bl || pSWFRoleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFRoleBase.getCreateMan());
        }
        if (pSWFRoleBase.isDynaModelFlagDirty() && (bl || pSWFRoleBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFRoleBase.getDynaModelFlag());
        }
        if (pSWFRoleBase.isEnableDirty() && (bl || pSWFRoleBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWFRoleBase.getEnable());
        }
        if (pSWFRoleBase.isLockFlagDirty() && (bl || pSWFRoleBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSWFRoleBase.getLockFlag());
        }
        if (pSWFRoleBase.isMemoDirty() && (bl || pSWFRoleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFRoleBase.getMemo());
        }
        if (pSWFRoleBase.isPSDEDSIdDirty() && (bl || pSWFRoleBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSWFRoleBase.getPSDEDSId());
        }
        if (pSWFRoleBase.isPSDEDSNameDirty() && (bl || pSWFRoleBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSWFRoleBase.getPSDEDSName());
        }
        if (pSWFRoleBase.isPSDEIdDirty() && (bl || pSWFRoleBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSWFRoleBase.getPSDEId());
        }
        if (pSWFRoleBase.isPSDENameDirty() && (bl || pSWFRoleBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSWFRoleBase.getPSDEName());
        }
        if (pSWFRoleBase.isPSDynaInstIdDirty() && (bl || pSWFRoleBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFRoleBase.getPSDynaInstId());
        }
        if (pSWFRoleBase.isPSModuleIdDirty() && (bl || pSWFRoleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSWFRoleBase.getPSModuleId());
        }
        if (pSWFRoleBase.isPSModuleNameDirty() && (bl || pSWFRoleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSWFRoleBase.getPSModuleName());
        }
        if (pSWFRoleBase.isPSSysSFPluginIdDirty() && (bl || pSWFRoleBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSWFRoleBase.getPSSysSFPluginId());
        }
        if (pSWFRoleBase.isPSSysSFPluginNameDirty() && (bl || pSWFRoleBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSWFRoleBase.getPSSysSFPluginName());
        }
        if (pSWFRoleBase.isPSSystemIdDirty() && (bl || pSWFRoleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFRoleBase.getPSSystemId());
        }
        if (pSWFRoleBase.isPSSystemNameDirty() && (bl || pSWFRoleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSWFRoleBase.getPSSystemName());
        }
        if (pSWFRoleBase.isPSWFRoleIdDirty() && (bl || pSWFRoleBase.getPSWFRoleId() != null)) {
            iDataObject.set(FIELD_PSWFROLEID, (Object)pSWFRoleBase.getPSWFRoleId());
        }
        if (pSWFRoleBase.isPSWFRoleNameDirty() && (bl || pSWFRoleBase.getPSWFRoleName() != null)) {
            iDataObject.set(FIELD_PSWFROLENAME, (Object)pSWFRoleBase.getPSWFRoleName());
        }
        if (pSWFRoleBase.isUpdateDateDirty() && (bl || pSWFRoleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFRoleBase.getUpdateDate());
        }
        if (pSWFRoleBase.isUpdateManDirty() && (bl || pSWFRoleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFRoleBase.getUpdateMan());
        }
        if (pSWFRoleBase.isUserCatDirty() && (bl || pSWFRoleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFRoleBase.getUserCat());
        }
        if (pSWFRoleBase.isUserDataDirty() && (bl || pSWFRoleBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSWFRoleBase.getUserData());
        }
        if (pSWFRoleBase.isUserData2Dirty() && (bl || pSWFRoleBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSWFRoleBase.getUserData2());
        }
        if (pSWFRoleBase.isUserTagDirty() && (bl || pSWFRoleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFRoleBase.getUserTag());
        }
        if (pSWFRoleBase.isUserTag2Dirty() && (bl || pSWFRoleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFRoleBase.getUserTag2());
        }
        if (pSWFRoleBase.isUserTag3Dirty() && (bl || pSWFRoleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFRoleBase.getUserTag3());
        }
        if (pSWFRoleBase.isUserTag4Dirty() && (bl || pSWFRoleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFRoleBase.getUserTag4());
        }
        if (pSWFRoleBase.isWFRoleSNDirty() && (bl || pSWFRoleBase.getWFRoleSN() != null)) {
            iDataObject.set(FIELD_WFROLESN, (Object)pSWFRoleBase.getWFRoleSN());
        }
        if (pSWFRoleBase.isWFRoleTypeDirty() && (bl || pSWFRoleBase.getWFRoleType() != null)) {
            iDataObject.set(FIELD_WFROLETYPE, (Object)pSWFRoleBase.getWFRoleType());
        }
        if (pSWFRoleBase.isWFUserIdPSDEFIdDirty() && (bl || pSWFRoleBase.getWFUserIdPSDEFId() != null)) {
            iDataObject.set(FIELD_WFUSERIDPSDEFID, (Object)pSWFRoleBase.getWFUserIdPSDEFId());
        }
        if (pSWFRoleBase.isWFUserIdPSDEFNameDirty() && (bl || pSWFRoleBase.getWFUserIdPSDEFName() != null)) {
            iDataObject.set(FIELD_WFUSERIDPSDEFNAME, (Object)pSWFRoleBase.getWFUserIdPSDEFName());
        }
        if (pSWFRoleBase.isWFUserNamePSDEFIdDirty() && (bl || pSWFRoleBase.getWFUserNamePSDEFId() != null)) {
            iDataObject.set(FIELD_WFUSERNAMEPSDEFID, (Object)pSWFRoleBase.getWFUserNamePSDEFId());
        }
        if (pSWFRoleBase.isWFUserNamePSDEFNameDirty() && (bl || pSWFRoleBase.getWFUserNamePSDEFName() != null)) {
            iDataObject.set(FIELD_WFUSERNAMEPSDEFNAME, (Object)pSWFRoleBase.getWFUserNamePSDEFName());
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
        return PSWFRoleBase.remove(this, n);
    }

    private static boolean remove(PSWFRoleBase pSWFRoleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFRoleBase.resetCodeName();
                return true;
            }
            case 1: {
                pSWFRoleBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWFRoleBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWFRoleBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSWFRoleBase.resetEnable();
                return true;
            }
            case 5: {
                pSWFRoleBase.resetLockFlag();
                return true;
            }
            case 6: {
                pSWFRoleBase.resetMemo();
                return true;
            }
            case 7: {
                pSWFRoleBase.resetPSDEDSId();
                return true;
            }
            case 8: {
                pSWFRoleBase.resetPSDEDSName();
                return true;
            }
            case 9: {
                pSWFRoleBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSWFRoleBase.resetPSDEName();
                return true;
            }
            case 11: {
                pSWFRoleBase.resetPSDynaInstId();
                return true;
            }
            case 12: {
                pSWFRoleBase.resetPSModuleId();
                return true;
            }
            case 13: {
                pSWFRoleBase.resetPSModuleName();
                return true;
            }
            case 14: {
                pSWFRoleBase.resetPSSysSFPluginId();
                return true;
            }
            case 15: {
                pSWFRoleBase.resetPSSysSFPluginName();
                return true;
            }
            case 16: {
                pSWFRoleBase.resetPSSystemId();
                return true;
            }
            case 17: {
                pSWFRoleBase.resetPSSystemName();
                return true;
            }
            case 18: {
                pSWFRoleBase.resetPSWFRoleId();
                return true;
            }
            case 19: {
                pSWFRoleBase.resetPSWFRoleName();
                return true;
            }
            case 20: {
                pSWFRoleBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSWFRoleBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSWFRoleBase.resetUserCat();
                return true;
            }
            case 23: {
                pSWFRoleBase.resetUserData();
                return true;
            }
            case 24: {
                pSWFRoleBase.resetUserData2();
                return true;
            }
            case 25: {
                pSWFRoleBase.resetUserTag();
                return true;
            }
            case 26: {
                pSWFRoleBase.resetUserTag2();
                return true;
            }
            case 27: {
                pSWFRoleBase.resetUserTag3();
                return true;
            }
            case 28: {
                pSWFRoleBase.resetUserTag4();
                return true;
            }
            case 29: {
                pSWFRoleBase.resetWFRoleSN();
                return true;
            }
            case 30: {
                pSWFRoleBase.resetWFRoleType();
                return true;
            }
            case 31: {
                pSWFRoleBase.resetWFUserIdPSDEFId();
                return true;
            }
            case 32: {
                pSWFRoleBase.resetWFUserIdPSDEFName();
                return true;
            }
            case 33: {
                pSWFRoleBase.resetWFUserNamePSDEFId();
                return true;
            }
            case 34: {
                pSWFRoleBase.resetWFUserNamePSDEFName();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
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
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFUserIdPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserIdPSDEF();
        }
        if (this.getWFUserIdPSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFUserIdPSDEFLock;
        synchronized (n) {
            if (this.wfuseridpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFUserIdPSDEFId(), (Object)this.wfuseridpsdef.getPSDEFieldId()) != 0L) {
                this.wfuseridpsdef = null;
            }
            if (this.wfuseridpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFUserIdPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.wfuseridpsdef = pSDEField;
            }
            return this.wfuseridpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getWFUserNamePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserNamePSDEF();
        }
        if (this.getWFUserNamePSDEFId() == null) {
            return null;
        }
        Integer n = this.objWFUserNamePSDEFLock;
        synchronized (n) {
            if (this.wfusernamepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getWFUserNamePSDEFId(), (Object)this.wfusernamepsdef.getPSDEFieldId()) != 0L) {
                this.wfusernamepsdef = null;
            }
            if (this.wfusernamepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getWFUserNamePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.wfusernamepsdef = pSDEField;
            }
            return this.wfusernamepsdef;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
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
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSWFRoleBase getProxyEntity() {
        return this.proxyPSWFRoleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFRoleBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFRoleBase) {
            this.proxyPSWFRoleBase = (PSWFRoleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_ENABLE, 4);
        fieldIndexMap.put(FIELD_LOCKFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEDSID, 7);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSDENAME, 10);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 11);
        fieldIndexMap.put(FIELD_PSMODULEID, 12);
        fieldIndexMap.put(FIELD_PSMODULENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 14);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 17);
        fieldIndexMap.put(FIELD_PSWFROLEID, 18);
        fieldIndexMap.put(FIELD_PSWFROLENAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERCAT, 22);
        fieldIndexMap.put(FIELD_USERDATA, 23);
        fieldIndexMap.put(FIELD_USERDATA2, 24);
        fieldIndexMap.put(FIELD_USERTAG, 25);
        fieldIndexMap.put(FIELD_USERTAG2, 26);
        fieldIndexMap.put(FIELD_USERTAG3, 27);
        fieldIndexMap.put(FIELD_USERTAG4, 28);
        fieldIndexMap.put(FIELD_WFROLESN, 29);
        fieldIndexMap.put(FIELD_WFROLETYPE, 30);
        fieldIndexMap.put(FIELD_WFUSERIDPSDEFID, 31);
        fieldIndexMap.put(FIELD_WFUSERIDPSDEFNAME, 32);
        fieldIndexMap.put(FIELD_WFUSERNAMEPSDEFID, 33);
        fieldIndexMap.put(FIELD_WFUSERNAMEPSDEFNAME, 34);
    }
}

