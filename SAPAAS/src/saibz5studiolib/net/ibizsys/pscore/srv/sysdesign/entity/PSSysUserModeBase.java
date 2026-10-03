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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserModeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUserModeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSACTORID = "PSSYSACTORID";
    public static final String FIELD_PSSYSACTORNAME = "PSSYSACTORNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSERMODEID = "PSSYSUSERMODEID";
    public static final String FIELD_PSSYSUSERMODENAME = "PSSYSUSERMODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERMODESN = "USERMODESN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOGICNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSMODULEID = 5;
    private static final int INDEX_PSMODULENAME = 6;
    private static final int INDEX_PSSYSACTORID = 7;
    private static final int INDEX_PSSYSACTORNAME = 8;
    private static final int INDEX_PSSYSDYNAMODELID = 9;
    private static final int INDEX_PSSYSDYNAMODELNAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSSYSTEMNAME = 12;
    private static final int INDEX_PSSYSUSERMODEID = 13;
    private static final int INDEX_PSSYSUSERMODENAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERMODESN = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUserModeBase proxyPSSysUserModeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysactoridDirtyFlag = false;
    private boolean pssysactornameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysusermodeidDirtyFlag = false;
    private boolean pssysusermodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usermodesnDirtyFlag = false;
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
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysactorid")
    private String pssysactorid;
    @Column(name="pssysactorname")
    private String pssysactorname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysusermodeid")
    private String pssysusermodeid;
    @Column(name="pssysusermodename")
    private String pssysusermodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usermodesn")
    private String usermodesn;
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
    private Integer objPSSysActorLock = new Integer(1);
    private PSSysActor pssysactor = null;
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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSSysActorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysActorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysactorid = string;
        this.pssysactoridDirtyFlag = true;
    }

    public String getPSSysActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActorId();
        }
        return this.pssysactorid;
    }

    public boolean isPSSysActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysActorIdDirty();
        }
        return this.pssysactoridDirtyFlag;
    }

    public void resetPSSysActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysActorId();
            return;
        }
        this.pssysactoridDirtyFlag = false;
        this.pssysactorid = null;
    }

    public void setPSSysActorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysActorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysactorname = string;
        this.pssysactornameDirtyFlag = true;
    }

    public String getPSSysActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActorName();
        }
        return this.pssysactorname;
    }

    public boolean isPSSysActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysActorNameDirty();
        }
        return this.pssysactornameDirtyFlag;
    }

    public void resetPSSysActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysActorName();
            return;
        }
        this.pssysactornameDirtyFlag = false;
        this.pssysactorname = null;
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

    public void setPSSysUserModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusermodeid = string;
        this.pssysusermodeidDirtyFlag = true;
    }

    public String getPSSysUserModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserModeId();
        }
        return this.pssysusermodeid;
    }

    public boolean isPSSysUserModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserModeIdDirty();
        }
        return this.pssysusermodeidDirtyFlag;
    }

    public void resetPSSysUserModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserModeId();
            return;
        }
        this.pssysusermodeidDirtyFlag = false;
        this.pssysusermodeid = null;
    }

    public void setPSSysUserModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssysusermodename = string;
        this.pssysusermodenameDirtyFlag = true;
    }

    public String getPSSysUserModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserModeName();
        }
        return this.pssysusermodename;
    }

    public boolean isPSSysUserModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserModeNameDirty();
        }
        return this.pssysusermodenameDirtyFlag;
    }

    public void resetPSSysUserModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserModeName();
            return;
        }
        this.pssysusermodenameDirtyFlag = false;
        this.pssysusermodename = null;
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

    public void setUserModeSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserModeSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usermodesn = string;
        this.usermodesnDirtyFlag = true;
    }

    public String getUserModeSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserModeSN();
        }
        return this.usermodesn;
    }

    public boolean isUserModeSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserModeSNDirty();
        }
        return this.usermodesnDirtyFlag;
    }

    public void resetUserModeSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserModeSN();
            return;
        }
        this.usermodesnDirtyFlag = false;
        this.usermodesn = null;
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
        PSSysUserModeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUserModeBase pSSysUserModeBase) {
        pSSysUserModeBase.resetCodeName();
        pSSysUserModeBase.resetCreateDate();
        pSSysUserModeBase.resetCreateMan();
        pSSysUserModeBase.resetLogicName();
        pSSysUserModeBase.resetMemo();
        pSSysUserModeBase.resetPSModuleId();
        pSSysUserModeBase.resetPSModuleName();
        pSSysUserModeBase.resetPSSysActorId();
        pSSysUserModeBase.resetPSSysActorName();
        pSSysUserModeBase.resetPSSysDynaModelId();
        pSSysUserModeBase.resetPSSysDynaModelName();
        pSSysUserModeBase.resetPSSystemId();
        pSSysUserModeBase.resetPSSystemName();
        pSSysUserModeBase.resetPSSysUserModeId();
        pSSysUserModeBase.resetPSSysUserModeName();
        pSSysUserModeBase.resetUpdateDate();
        pSSysUserModeBase.resetUpdateMan();
        pSSysUserModeBase.resetUserCat();
        pSSysUserModeBase.resetUserModeSN();
        pSSysUserModeBase.resetUserTag();
        pSSysUserModeBase.resetUserTag2();
        pSSysUserModeBase.resetUserTag3();
        pSSysUserModeBase.resetUserTag4();
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
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
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
        if (!bl || this.isPSSysActorIdDirty()) {
            hashMap.put(FIELD_PSSYSACTORID, this.getPSSysActorId());
        }
        if (!bl || this.isPSSysActorNameDirty()) {
            hashMap.put(FIELD_PSSYSACTORNAME, this.getPSSysActorName());
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
        if (!bl || this.isPSSysUserModeIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERMODEID, this.getPSSysUserModeId());
        }
        if (!bl || this.isPSSysUserModeNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERMODENAME, this.getPSSysUserModeName());
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
        if (!bl || this.isUserModeSNDirty()) {
            hashMap.put(FIELD_USERMODESN, this.getUserModeSN());
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
        return PSSysUserModeBase.get(this, n);
    }

    private static Object get(PSSysUserModeBase pSSysUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserModeBase.getCodeName();
            }
            case 1: {
                return pSSysUserModeBase.getCreateDate();
            }
            case 2: {
                return pSSysUserModeBase.getCreateMan();
            }
            case 3: {
                return pSSysUserModeBase.getLogicName();
            }
            case 4: {
                return pSSysUserModeBase.getMemo();
            }
            case 5: {
                return pSSysUserModeBase.getPSModuleId();
            }
            case 6: {
                return pSSysUserModeBase.getPSModuleName();
            }
            case 7: {
                return pSSysUserModeBase.getPSSysActorId();
            }
            case 8: {
                return pSSysUserModeBase.getPSSysActorName();
            }
            case 9: {
                return pSSysUserModeBase.getPSSysDynaModelId();
            }
            case 10: {
                return pSSysUserModeBase.getPSSysDynaModelName();
            }
            case 11: {
                return pSSysUserModeBase.getPSSystemId();
            }
            case 12: {
                return pSSysUserModeBase.getPSSystemName();
            }
            case 13: {
                return pSSysUserModeBase.getPSSysUserModeId();
            }
            case 14: {
                return pSSysUserModeBase.getPSSysUserModeName();
            }
            case 15: {
                return pSSysUserModeBase.getUpdateDate();
            }
            case 16: {
                return pSSysUserModeBase.getUpdateMan();
            }
            case 17: {
                return pSSysUserModeBase.getUserCat();
            }
            case 18: {
                return pSSysUserModeBase.getUserModeSN();
            }
            case 19: {
                return pSSysUserModeBase.getUserTag();
            }
            case 20: {
                return pSSysUserModeBase.getUserTag2();
            }
            case 21: {
                return pSSysUserModeBase.getUserTag3();
            }
            case 22: {
                return pSSysUserModeBase.getUserTag4();
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
        PSSysUserModeBase.set(this, n, object);
    }

    private static void set(PSSysUserModeBase pSSysUserModeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserModeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUserModeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysUserModeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUserModeBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUserModeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUserModeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUserModeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUserModeBase.setPSSysActorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUserModeBase.setPSSysActorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUserModeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUserModeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUserModeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUserModeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUserModeBase.setPSSysUserModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUserModeBase.setPSSysUserModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUserModeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSSysUserModeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUserModeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUserModeBase.setUserModeSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUserModeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUserModeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUserModeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUserModeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysUserModeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUserModeBase pSSysUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserModeBase.getCodeName() == null;
            }
            case 1: {
                return pSSysUserModeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysUserModeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysUserModeBase.getLogicName() == null;
            }
            case 4: {
                return pSSysUserModeBase.getMemo() == null;
            }
            case 5: {
                return pSSysUserModeBase.getPSModuleId() == null;
            }
            case 6: {
                return pSSysUserModeBase.getPSModuleName() == null;
            }
            case 7: {
                return pSSysUserModeBase.getPSSysActorId() == null;
            }
            case 8: {
                return pSSysUserModeBase.getPSSysActorName() == null;
            }
            case 9: {
                return pSSysUserModeBase.getPSSysDynaModelId() == null;
            }
            case 10: {
                return pSSysUserModeBase.getPSSysDynaModelName() == null;
            }
            case 11: {
                return pSSysUserModeBase.getPSSystemId() == null;
            }
            case 12: {
                return pSSysUserModeBase.getPSSystemName() == null;
            }
            case 13: {
                return pSSysUserModeBase.getPSSysUserModeId() == null;
            }
            case 14: {
                return pSSysUserModeBase.getPSSysUserModeName() == null;
            }
            case 15: {
                return pSSysUserModeBase.getUpdateDate() == null;
            }
            case 16: {
                return pSSysUserModeBase.getUpdateMan() == null;
            }
            case 17: {
                return pSSysUserModeBase.getUserCat() == null;
            }
            case 18: {
                return pSSysUserModeBase.getUserModeSN() == null;
            }
            case 19: {
                return pSSysUserModeBase.getUserTag() == null;
            }
            case 20: {
                return pSSysUserModeBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysUserModeBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysUserModeBase.getUserTag4() == null;
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
        return PSSysUserModeBase.contains(this, n);
    }

    private static boolean contains(PSSysUserModeBase pSSysUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserModeBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysUserModeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysUserModeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysUserModeBase.isLogicNameDirty();
            }
            case 4: {
                return pSSysUserModeBase.isMemoDirty();
            }
            case 5: {
                return pSSysUserModeBase.isPSModuleIdDirty();
            }
            case 6: {
                return pSSysUserModeBase.isPSModuleNameDirty();
            }
            case 7: {
                return pSSysUserModeBase.isPSSysActorIdDirty();
            }
            case 8: {
                return pSSysUserModeBase.isPSSysActorNameDirty();
            }
            case 9: {
                return pSSysUserModeBase.isPSSysDynaModelIdDirty();
            }
            case 10: {
                return pSSysUserModeBase.isPSSysDynaModelNameDirty();
            }
            case 11: {
                return pSSysUserModeBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSSysUserModeBase.isPSSystemNameDirty();
            }
            case 13: {
                return pSSysUserModeBase.isPSSysUserModeIdDirty();
            }
            case 14: {
                return pSSysUserModeBase.isPSSysUserModeNameDirty();
            }
            case 15: {
                return pSSysUserModeBase.isUpdateDateDirty();
            }
            case 16: {
                return pSSysUserModeBase.isUpdateManDirty();
            }
            case 17: {
                return pSSysUserModeBase.isUserCatDirty();
            }
            case 18: {
                return pSSysUserModeBase.isUserModeSNDirty();
            }
            case 19: {
                return pSSysUserModeBase.isUserTagDirty();
            }
            case 20: {
                return pSSysUserModeBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysUserModeBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysUserModeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUserModeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUserModeBase pSSysUserModeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUserModeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSysActorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorid", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSysActorId()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSysActorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorname", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSysActorName()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSysUserModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusermodeid", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSysUserModeId()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getPSSysUserModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusermodename", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getPSSysUserModeName()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUserModeSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usermodesn", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUserModeSN()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUserModeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUserModeBase.getJSONValue((Object)pSSysUserModeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUserModeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUserModeBase pSSysUserModeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUserModeBase.getCodeName() != null) {
            object = pSSysUserModeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getCreateDate() != null) {
            object = pSSysUserModeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserModeBase.getCreateMan() != null) {
            object = pSSysUserModeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getLogicName() != null) {
            object = pSSysUserModeBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getMemo() != null) {
            object = pSSysUserModeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSModuleId() != null) {
            object = pSSysUserModeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSModuleName() != null) {
            object = pSSysUserModeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSysActorId() != null) {
            object = pSSysUserModeBase.getPSSysActorId();
            xmlNode.setAttribute(FIELD_PSSYSACTORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSysActorName() != null) {
            object = pSSysUserModeBase.getPSSysActorName();
            xmlNode.setAttribute(FIELD_PSSYSACTORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSysDynaModelId() != null) {
            object = pSSysUserModeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSysDynaModelName() != null) {
            object = pSSysUserModeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSystemId() != null) {
            object = pSSysUserModeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSystemName() != null) {
            object = pSSysUserModeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSysUserModeId() != null) {
            object = pSSysUserModeBase.getPSSysUserModeId();
            xmlNode.setAttribute(FIELD_PSSYSUSERMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getPSSysUserModeName() != null) {
            object = pSSysUserModeBase.getPSSysUserModeName();
            xmlNode.setAttribute(FIELD_PSSYSUSERMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getUpdateDate() != null) {
            object = pSSysUserModeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserModeBase.getUpdateMan() != null) {
            object = pSSysUserModeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getUserCat() != null) {
            object = pSSysUserModeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getUserModeSN() != null) {
            object = pSSysUserModeBase.getUserModeSN();
            xmlNode.setAttribute(FIELD_USERMODESN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getUserTag() != null) {
            object = pSSysUserModeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getUserTag2() != null) {
            object = pSSysUserModeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getUserTag3() != null) {
            object = pSSysUserModeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserModeBase.getUserTag4() != null) {
            object = pSSysUserModeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUserModeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUserModeBase pSSysUserModeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUserModeBase.isCodeNameDirty() && (bl || pSSysUserModeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUserModeBase.getCodeName());
        }
        if (pSSysUserModeBase.isCreateDateDirty() && (bl || pSSysUserModeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUserModeBase.getCreateDate());
        }
        if (pSSysUserModeBase.isCreateManDirty() && (bl || pSSysUserModeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUserModeBase.getCreateMan());
        }
        if (pSSysUserModeBase.isLogicNameDirty() && (bl || pSSysUserModeBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysUserModeBase.getLogicName());
        }
        if (pSSysUserModeBase.isMemoDirty() && (bl || pSSysUserModeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUserModeBase.getMemo());
        }
        if (pSSysUserModeBase.isPSModuleIdDirty() && (bl || pSSysUserModeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUserModeBase.getPSModuleId());
        }
        if (pSSysUserModeBase.isPSModuleNameDirty() && (bl || pSSysUserModeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUserModeBase.getPSModuleName());
        }
        if (pSSysUserModeBase.isPSSysActorIdDirty() && (bl || pSSysUserModeBase.getPSSysActorId() != null)) {
            iDataObject.set(FIELD_PSSYSACTORID, (Object)pSSysUserModeBase.getPSSysActorId());
        }
        if (pSSysUserModeBase.isPSSysActorNameDirty() && (bl || pSSysUserModeBase.getPSSysActorName() != null)) {
            iDataObject.set(FIELD_PSSYSACTORNAME, (Object)pSSysUserModeBase.getPSSysActorName());
        }
        if (pSSysUserModeBase.isPSSysDynaModelIdDirty() && (bl || pSSysUserModeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysUserModeBase.getPSSysDynaModelId());
        }
        if (pSSysUserModeBase.isPSSysDynaModelNameDirty() && (bl || pSSysUserModeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysUserModeBase.getPSSysDynaModelName());
        }
        if (pSSysUserModeBase.isPSSystemIdDirty() && (bl || pSSysUserModeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUserModeBase.getPSSystemId());
        }
        if (pSSysUserModeBase.isPSSystemNameDirty() && (bl || pSSysUserModeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUserModeBase.getPSSystemName());
        }
        if (pSSysUserModeBase.isPSSysUserModeIdDirty() && (bl || pSSysUserModeBase.getPSSysUserModeId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERMODEID, (Object)pSSysUserModeBase.getPSSysUserModeId());
        }
        if (pSSysUserModeBase.isPSSysUserModeNameDirty() && (bl || pSSysUserModeBase.getPSSysUserModeName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERMODENAME, (Object)pSSysUserModeBase.getPSSysUserModeName());
        }
        if (pSSysUserModeBase.isUpdateDateDirty() && (bl || pSSysUserModeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUserModeBase.getUpdateDate());
        }
        if (pSSysUserModeBase.isUpdateManDirty() && (bl || pSSysUserModeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUserModeBase.getUpdateMan());
        }
        if (pSSysUserModeBase.isUserCatDirty() && (bl || pSSysUserModeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUserModeBase.getUserCat());
        }
        if (pSSysUserModeBase.isUserModeSNDirty() && (bl || pSSysUserModeBase.getUserModeSN() != null)) {
            iDataObject.set(FIELD_USERMODESN, (Object)pSSysUserModeBase.getUserModeSN());
        }
        if (pSSysUserModeBase.isUserTagDirty() && (bl || pSSysUserModeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUserModeBase.getUserTag());
        }
        if (pSSysUserModeBase.isUserTag2Dirty() && (bl || pSSysUserModeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUserModeBase.getUserTag2());
        }
        if (pSSysUserModeBase.isUserTag3Dirty() && (bl || pSSysUserModeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUserModeBase.getUserTag3());
        }
        if (pSSysUserModeBase.isUserTag4Dirty() && (bl || pSSysUserModeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUserModeBase.getUserTag4());
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
        return PSSysUserModeBase.remove(this, n);
    }

    private static boolean remove(PSSysUserModeBase pSSysUserModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserModeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysUserModeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysUserModeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysUserModeBase.resetLogicName();
                return true;
            }
            case 4: {
                pSSysUserModeBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysUserModeBase.resetPSModuleId();
                return true;
            }
            case 6: {
                pSSysUserModeBase.resetPSModuleName();
                return true;
            }
            case 7: {
                pSSysUserModeBase.resetPSSysActorId();
                return true;
            }
            case 8: {
                pSSysUserModeBase.resetPSSysActorName();
                return true;
            }
            case 9: {
                pSSysUserModeBase.resetPSSysDynaModelId();
                return true;
            }
            case 10: {
                pSSysUserModeBase.resetPSSysDynaModelName();
                return true;
            }
            case 11: {
                pSSysUserModeBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSSysUserModeBase.resetPSSystemName();
                return true;
            }
            case 13: {
                pSSysUserModeBase.resetPSSysUserModeId();
                return true;
            }
            case 14: {
                pSSysUserModeBase.resetPSSysUserModeName();
                return true;
            }
            case 15: {
                pSSysUserModeBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSSysUserModeBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSSysUserModeBase.resetUserCat();
                return true;
            }
            case 18: {
                pSSysUserModeBase.resetUserModeSN();
                return true;
            }
            case 19: {
                pSSysUserModeBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysUserModeBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysUserModeBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysUserModeBase.resetUserTag4();
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
    public PSSysActor getPSSysActor() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActor();
        }
        if (this.getPSSysActorId() == null) {
            return null;
        }
        Integer n = this.objPSSysActorLock;
        synchronized (n) {
            if (this.pssysactor != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysActorId(), (Object)this.pssysactor.getPSSysActorId()) != 0L) {
                this.pssysactor = null;
            }
            if (this.pssysactor == null) {
                PSSysActor pSSysActor = new PSSysActor();
                pSSysActor.setPSSysActorId(this.getPSSysActorId());
                PSSysActorService pSSysActorService = (PSSysActorService)ServiceGlobal.getService(PSSysActorService.class, (SessionFactory)this.getSessionFactory());
                pSSysActorService.autoGet(pSSysActor);
                this.pssysactor = pSSysActor;
            }
            return this.pssysactor;
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

    private PSSysUserModeBase getProxyEntity() {
        return this.proxyPSSysUserModeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUserModeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUserModeBase) {
            this.proxyPSSysUserModeBase = (PSSysUserModeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserModeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOGICNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSMODULEID, 5);
        fieldIndexMap.put(FIELD_PSMODULENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSACTORID, 7);
        fieldIndexMap.put(FIELD_PSSYSACTORNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 9);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSUSERMODEID, 13);
        fieldIndexMap.put(FIELD_PSSYSUSERMODENAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERMODESN, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

