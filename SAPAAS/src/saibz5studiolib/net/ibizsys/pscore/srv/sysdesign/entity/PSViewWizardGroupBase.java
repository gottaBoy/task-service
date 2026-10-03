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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewWizardGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewWizardGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSVIEWWIZARDGROUPID = "PSVIEWWIZARDGROUPID";
    public static final String FIELD_PSVIEWWIZARDGROUPNAME = "PSVIEWWIZARDGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOCKFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSMODULEID = 5;
    private static final int INDEX_PSMODULENAME = 6;
    private static final int INDEX_PSSYSDYNAMODELID = 7;
    private static final int INDEX_PSSYSDYNAMODELNAME = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_PSSYSTEMNAME = 10;
    private static final int INDEX_PSVIEWWIZARDGROUPID = 11;
    private static final int INDEX_PSVIEWWIZARDGROUPNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewWizardGroupBase proxyPSViewWizardGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psviewwizardgroupidDirtyFlag = false;
    private boolean psviewwizardgroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psviewwizardgroupid")
    private String psviewwizardgroupid;
    @Column(name="psviewwizardgroupname")
    private String psviewwizardgroupname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
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

    public void setPSViewWizardGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewWizardGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewwizardgroupid = string;
        this.psviewwizardgroupidDirtyFlag = true;
    }

    public String getPSViewWizardGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewWizardGroupId();
        }
        return this.psviewwizardgroupid;
    }

    public boolean isPSViewWizardGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewWizardGroupIdDirty();
        }
        return this.psviewwizardgroupidDirtyFlag;
    }

    public void resetPSViewWizardGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewWizardGroupId();
            return;
        }
        this.psviewwizardgroupidDirtyFlag = false;
        this.psviewwizardgroupid = null;
    }

    public void setPSViewWizardGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewWizardGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewwizardgroupname = string;
        this.psviewwizardgroupnameDirtyFlag = true;
    }

    public String getPSViewWizardGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewWizardGroupName();
        }
        return this.psviewwizardgroupname;
    }

    public boolean isPSViewWizardGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewWizardGroupNameDirty();
        }
        return this.psviewwizardgroupnameDirtyFlag;
    }

    public void resetPSViewWizardGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewWizardGroupName();
            return;
        }
        this.psviewwizardgroupnameDirtyFlag = false;
        this.psviewwizardgroupname = null;
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

    protected void onReset() {
        PSViewWizardGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewWizardGroupBase pSViewWizardGroupBase) {
        pSViewWizardGroupBase.resetCodeName();
        pSViewWizardGroupBase.resetCreateDate();
        pSViewWizardGroupBase.resetCreateMan();
        pSViewWizardGroupBase.resetLockFlag();
        pSViewWizardGroupBase.resetMemo();
        pSViewWizardGroupBase.resetPSModuleId();
        pSViewWizardGroupBase.resetPSModuleName();
        pSViewWizardGroupBase.resetPSSysDynaModelId();
        pSViewWizardGroupBase.resetPSSysDynaModelName();
        pSViewWizardGroupBase.resetPSSystemId();
        pSViewWizardGroupBase.resetPSSystemName();
        pSViewWizardGroupBase.resetPSViewWizardGroupId();
        pSViewWizardGroupBase.resetPSViewWizardGroupName();
        pSViewWizardGroupBase.resetUpdateDate();
        pSViewWizardGroupBase.resetUpdateMan();
        pSViewWizardGroupBase.resetUserCat();
        pSViewWizardGroupBase.resetUserTag();
        pSViewWizardGroupBase.resetUserTag2();
        pSViewWizardGroupBase.resetUserTag3();
        pSViewWizardGroupBase.resetUserTag4();
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
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSViewWizardGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWWIZARDGROUPID, this.getPSViewWizardGroupId());
        }
        if (!bl || this.isPSViewWizardGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWWIZARDGROUPNAME, this.getPSViewWizardGroupName());
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
        return PSViewWizardGroupBase.get(this, n);
    }

    private static Object get(PSViewWizardGroupBase pSViewWizardGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewWizardGroupBase.getCodeName();
            }
            case 1: {
                return pSViewWizardGroupBase.getCreateDate();
            }
            case 2: {
                return pSViewWizardGroupBase.getCreateMan();
            }
            case 3: {
                return pSViewWizardGroupBase.getLockFlag();
            }
            case 4: {
                return pSViewWizardGroupBase.getMemo();
            }
            case 5: {
                return pSViewWizardGroupBase.getPSModuleId();
            }
            case 6: {
                return pSViewWizardGroupBase.getPSModuleName();
            }
            case 7: {
                return pSViewWizardGroupBase.getPSSysDynaModelId();
            }
            case 8: {
                return pSViewWizardGroupBase.getPSSysDynaModelName();
            }
            case 9: {
                return pSViewWizardGroupBase.getPSSystemId();
            }
            case 10: {
                return pSViewWizardGroupBase.getPSSystemName();
            }
            case 11: {
                return pSViewWizardGroupBase.getPSViewWizardGroupId();
            }
            case 12: {
                return pSViewWizardGroupBase.getPSViewWizardGroupName();
            }
            case 13: {
                return pSViewWizardGroupBase.getUpdateDate();
            }
            case 14: {
                return pSViewWizardGroupBase.getUpdateMan();
            }
            case 15: {
                return pSViewWizardGroupBase.getUserCat();
            }
            case 16: {
                return pSViewWizardGroupBase.getUserTag();
            }
            case 17: {
                return pSViewWizardGroupBase.getUserTag2();
            }
            case 18: {
                return pSViewWizardGroupBase.getUserTag3();
            }
            case 19: {
                return pSViewWizardGroupBase.getUserTag4();
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
        PSViewWizardGroupBase.set(this, n, object);
    }

    private static void set(PSViewWizardGroupBase pSViewWizardGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewWizardGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSViewWizardGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSViewWizardGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewWizardGroupBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSViewWizardGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewWizardGroupBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewWizardGroupBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewWizardGroupBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewWizardGroupBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewWizardGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewWizardGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSViewWizardGroupBase.setPSViewWizardGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewWizardGroupBase.setPSViewWizardGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewWizardGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSViewWizardGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSViewWizardGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSViewWizardGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSViewWizardGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSViewWizardGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSViewWizardGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSViewWizardGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSViewWizardGroupBase pSViewWizardGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewWizardGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSViewWizardGroupBase.getCreateDate() == null;
            }
            case 2: {
                return pSViewWizardGroupBase.getCreateMan() == null;
            }
            case 3: {
                return pSViewWizardGroupBase.getLockFlag() == null;
            }
            case 4: {
                return pSViewWizardGroupBase.getMemo() == null;
            }
            case 5: {
                return pSViewWizardGroupBase.getPSModuleId() == null;
            }
            case 6: {
                return pSViewWizardGroupBase.getPSModuleName() == null;
            }
            case 7: {
                return pSViewWizardGroupBase.getPSSysDynaModelId() == null;
            }
            case 8: {
                return pSViewWizardGroupBase.getPSSysDynaModelName() == null;
            }
            case 9: {
                return pSViewWizardGroupBase.getPSSystemId() == null;
            }
            case 10: {
                return pSViewWizardGroupBase.getPSSystemName() == null;
            }
            case 11: {
                return pSViewWizardGroupBase.getPSViewWizardGroupId() == null;
            }
            case 12: {
                return pSViewWizardGroupBase.getPSViewWizardGroupName() == null;
            }
            case 13: {
                return pSViewWizardGroupBase.getUpdateDate() == null;
            }
            case 14: {
                return pSViewWizardGroupBase.getUpdateMan() == null;
            }
            case 15: {
                return pSViewWizardGroupBase.getUserCat() == null;
            }
            case 16: {
                return pSViewWizardGroupBase.getUserTag() == null;
            }
            case 17: {
                return pSViewWizardGroupBase.getUserTag2() == null;
            }
            case 18: {
                return pSViewWizardGroupBase.getUserTag3() == null;
            }
            case 19: {
                return pSViewWizardGroupBase.getUserTag4() == null;
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
        return PSViewWizardGroupBase.contains(this, n);
    }

    private static boolean contains(PSViewWizardGroupBase pSViewWizardGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewWizardGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSViewWizardGroupBase.isCreateDateDirty();
            }
            case 2: {
                return pSViewWizardGroupBase.isCreateManDirty();
            }
            case 3: {
                return pSViewWizardGroupBase.isLockFlagDirty();
            }
            case 4: {
                return pSViewWizardGroupBase.isMemoDirty();
            }
            case 5: {
                return pSViewWizardGroupBase.isPSModuleIdDirty();
            }
            case 6: {
                return pSViewWizardGroupBase.isPSModuleNameDirty();
            }
            case 7: {
                return pSViewWizardGroupBase.isPSSysDynaModelIdDirty();
            }
            case 8: {
                return pSViewWizardGroupBase.isPSSysDynaModelNameDirty();
            }
            case 9: {
                return pSViewWizardGroupBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSViewWizardGroupBase.isPSSystemNameDirty();
            }
            case 11: {
                return pSViewWizardGroupBase.isPSViewWizardGroupIdDirty();
            }
            case 12: {
                return pSViewWizardGroupBase.isPSViewWizardGroupNameDirty();
            }
            case 13: {
                return pSViewWizardGroupBase.isUpdateDateDirty();
            }
            case 14: {
                return pSViewWizardGroupBase.isUpdateManDirty();
            }
            case 15: {
                return pSViewWizardGroupBase.isUserCatDirty();
            }
            case 16: {
                return pSViewWizardGroupBase.isUserTagDirty();
            }
            case 17: {
                return pSViewWizardGroupBase.isUserTag2Dirty();
            }
            case 18: {
                return pSViewWizardGroupBase.isUserTag3Dirty();
            }
            case 19: {
                return pSViewWizardGroupBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewWizardGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewWizardGroupBase pSViewWizardGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewWizardGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSViewWizardGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewwizardgroupid", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSViewWizardGroupId()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getPSViewWizardGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewwizardgroupname", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getPSViewWizardGroupName()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSViewWizardGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSViewWizardGroupBase.getJSONValue((Object)pSViewWizardGroupBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewWizardGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewWizardGroupBase pSViewWizardGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewWizardGroupBase.getCodeName() != null) {
            object = pSViewWizardGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getCreateDate() != null) {
            object = pSViewWizardGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewWizardGroupBase.getCreateMan() != null) {
            object = pSViewWizardGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getLockFlag() != null) {
            object = pSViewWizardGroupBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewWizardGroupBase.getMemo() != null) {
            object = pSViewWizardGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSModuleId() != null) {
            object = pSViewWizardGroupBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSModuleName() != null) {
            object = pSViewWizardGroupBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSSysDynaModelId() != null) {
            object = pSViewWizardGroupBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSSysDynaModelName() != null) {
            object = pSViewWizardGroupBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSSystemId() != null) {
            object = pSViewWizardGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSSystemName() != null) {
            object = pSViewWizardGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSViewWizardGroupId() != null) {
            object = pSViewWizardGroupBase.getPSViewWizardGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWWIZARDGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getPSViewWizardGroupName() != null) {
            object = pSViewWizardGroupBase.getPSViewWizardGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWWIZARDGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getUpdateDate() != null) {
            object = pSViewWizardGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewWizardGroupBase.getUpdateMan() != null) {
            object = pSViewWizardGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getUserCat() != null) {
            object = pSViewWizardGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getUserTag() != null) {
            object = pSViewWizardGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getUserTag2() != null) {
            object = pSViewWizardGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getUserTag3() != null) {
            object = pSViewWizardGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSViewWizardGroupBase.getUserTag4() != null) {
            object = pSViewWizardGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewWizardGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewWizardGroupBase pSViewWizardGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewWizardGroupBase.isCodeNameDirty() && (bl || pSViewWizardGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSViewWizardGroupBase.getCodeName());
        }
        if (pSViewWizardGroupBase.isCreateDateDirty() && (bl || pSViewWizardGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewWizardGroupBase.getCreateDate());
        }
        if (pSViewWizardGroupBase.isCreateManDirty() && (bl || pSViewWizardGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewWizardGroupBase.getCreateMan());
        }
        if (pSViewWizardGroupBase.isLockFlagDirty() && (bl || pSViewWizardGroupBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSViewWizardGroupBase.getLockFlag());
        }
        if (pSViewWizardGroupBase.isMemoDirty() && (bl || pSViewWizardGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewWizardGroupBase.getMemo());
        }
        if (pSViewWizardGroupBase.isPSModuleIdDirty() && (bl || pSViewWizardGroupBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSViewWizardGroupBase.getPSModuleId());
        }
        if (pSViewWizardGroupBase.isPSModuleNameDirty() && (bl || pSViewWizardGroupBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSViewWizardGroupBase.getPSModuleName());
        }
        if (pSViewWizardGroupBase.isPSSysDynaModelIdDirty() && (bl || pSViewWizardGroupBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSViewWizardGroupBase.getPSSysDynaModelId());
        }
        if (pSViewWizardGroupBase.isPSSysDynaModelNameDirty() && (bl || pSViewWizardGroupBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSViewWizardGroupBase.getPSSysDynaModelName());
        }
        if (pSViewWizardGroupBase.isPSSystemIdDirty() && (bl || pSViewWizardGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSViewWizardGroupBase.getPSSystemId());
        }
        if (pSViewWizardGroupBase.isPSSystemNameDirty() && (bl || pSViewWizardGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSViewWizardGroupBase.getPSSystemName());
        }
        if (pSViewWizardGroupBase.isPSViewWizardGroupIdDirty() && (bl || pSViewWizardGroupBase.getPSViewWizardGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWWIZARDGROUPID, (Object)pSViewWizardGroupBase.getPSViewWizardGroupId());
        }
        if (pSViewWizardGroupBase.isPSViewWizardGroupNameDirty() && (bl || pSViewWizardGroupBase.getPSViewWizardGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWWIZARDGROUPNAME, (Object)pSViewWizardGroupBase.getPSViewWizardGroupName());
        }
        if (pSViewWizardGroupBase.isUpdateDateDirty() && (bl || pSViewWizardGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewWizardGroupBase.getUpdateDate());
        }
        if (pSViewWizardGroupBase.isUpdateManDirty() && (bl || pSViewWizardGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewWizardGroupBase.getUpdateMan());
        }
        if (pSViewWizardGroupBase.isUserCatDirty() && (bl || pSViewWizardGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSViewWizardGroupBase.getUserCat());
        }
        if (pSViewWizardGroupBase.isUserTagDirty() && (bl || pSViewWizardGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSViewWizardGroupBase.getUserTag());
        }
        if (pSViewWizardGroupBase.isUserTag2Dirty() && (bl || pSViewWizardGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSViewWizardGroupBase.getUserTag2());
        }
        if (pSViewWizardGroupBase.isUserTag3Dirty() && (bl || pSViewWizardGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSViewWizardGroupBase.getUserTag3());
        }
        if (pSViewWizardGroupBase.isUserTag4Dirty() && (bl || pSViewWizardGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSViewWizardGroupBase.getUserTag4());
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
        return PSViewWizardGroupBase.remove(this, n);
    }

    private static boolean remove(PSViewWizardGroupBase pSViewWizardGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewWizardGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSViewWizardGroupBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSViewWizardGroupBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSViewWizardGroupBase.resetLockFlag();
                return true;
            }
            case 4: {
                pSViewWizardGroupBase.resetMemo();
                return true;
            }
            case 5: {
                pSViewWizardGroupBase.resetPSModuleId();
                return true;
            }
            case 6: {
                pSViewWizardGroupBase.resetPSModuleName();
                return true;
            }
            case 7: {
                pSViewWizardGroupBase.resetPSSysDynaModelId();
                return true;
            }
            case 8: {
                pSViewWizardGroupBase.resetPSSysDynaModelName();
                return true;
            }
            case 9: {
                pSViewWizardGroupBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSViewWizardGroupBase.resetPSSystemName();
                return true;
            }
            case 11: {
                pSViewWizardGroupBase.resetPSViewWizardGroupId();
                return true;
            }
            case 12: {
                pSViewWizardGroupBase.resetPSViewWizardGroupName();
                return true;
            }
            case 13: {
                pSViewWizardGroupBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSViewWizardGroupBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSViewWizardGroupBase.resetUserCat();
                return true;
            }
            case 16: {
                pSViewWizardGroupBase.resetUserTag();
                return true;
            }
            case 17: {
                pSViewWizardGroupBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSViewWizardGroupBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSViewWizardGroupBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSViewWizardGroupBase getProxyEntity() {
        return this.proxyPSViewWizardGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewWizardGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewWizardGroupBase) {
            this.proxyPSViewWizardGroupBase = (PSViewWizardGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewWizardGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSMODULEID, 5);
        fieldIndexMap.put(FIELD_PSMODULENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 7);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 10);
        fieldIndexMap.put(FIELD_PSVIEWWIZARDGROUPID, 11);
        fieldIndexMap.put(FIELD_PSVIEWWIZARDGROUPNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
    }
}

