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
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUAGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUAGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String FIELD_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_UAGROUPPARAM = "UAGROUPPARAM";
    public static final String FIELD_UAGTAG = "UAGTAG";
    public static final String FIELD_UAGTAG2 = "UAGTAG2";
    public static final String FIELD_UAGTAG3 = "UAGTAG3";
    public static final String FIELD_UAGTAG4 = "UAGTAG4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERREFFLAG = "USERREFFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_LOCKFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDENAME = 7;
    private static final int INDEX_PSDEUAGROUPID = 8;
    private static final int INDEX_PSDEUAGROUPNAME = 9;
    private static final int INDEX_PSDYNAINSTID = 10;
    private static final int INDEX_PSMODULEID = 11;
    private static final int INDEX_PSMODULENAME = 12;
    private static final int INDEX_PSSYSTEMID = 13;
    private static final int INDEX_PSSYSTEMNAME = 14;
    private static final int INDEX_PSWFID = 15;
    private static final int INDEX_PSWFNAME = 16;
    private static final int INDEX_PSWFPROCESSID = 17;
    private static final int INDEX_PSWFPROCESSNAME = 18;
    private static final int INDEX_PSWFVERSIONID = 19;
    private static final int INDEX_PSWFVERSIONNAME = 20;
    private static final int INDEX_UAGROUPPARAM = 21;
    private static final int INDEX_UAGTAG = 22;
    private static final int INDEX_UAGTAG2 = 23;
    private static final int INDEX_UAGTAG3 = 24;
    private static final int INDEX_UAGTAG4 = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERREFFLAG = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUAGroupBase proxyPSDEUAGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswfprocessidDirtyFlag = false;
    private boolean pswfprocessnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean uagroupparamDirtyFlag = false;
    private boolean uagtagDirtyFlag = false;
    private boolean uagtag2DirtyFlag = false;
    private boolean uagtag3DirtyFlag = false;
    private boolean uagtag4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userrefflagDirtyFlag = false;
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
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswfprocessid")
    private String pswfprocessid;
    @Column(name="pswfprocessname")
    private String pswfprocessname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="uagroupparam")
    private String uagroupparam;
    @Column(name="uagtag")
    private String uagtag;
    @Column(name="uagtag2")
    private String uagtag2;
    @Column(name="uagtag3")
    private String uagtag3;
    @Column(name="uagtag4")
    private String uagtag4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userrefflag")
    private Integer userrefflag;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSWFProcessLock = new Integer(1);
    private PSWFProcess pswfprocess = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;
    private Integer objPSDEUAGrpDetailsLock = new Integer(1);
    private ArrayList<PSDEUAGroupDetail> psdeuagrpdetails = null;

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

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
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

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfname = string;
        this.pswfnameDirtyFlag = true;
    }

    public String getPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFName();
        }
        return this.pswfname;
    }

    public boolean isPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFNameDirty();
        }
        return this.pswfnameDirtyFlag;
    }

    public void resetPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFName();
            return;
        }
        this.pswfnameDirtyFlag = false;
        this.pswfname = null;
    }

    public void setPSWFProcessId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessid = string;
        this.pswfprocessidDirtyFlag = true;
    }

    public String getPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessId();
        }
        return this.pswfprocessid;
    }

    public boolean isPSWFProcessIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessIdDirty();
        }
        return this.pswfprocessidDirtyFlag;
    }

    public void resetPSWFProcessId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessId();
            return;
        }
        this.pswfprocessidDirtyFlag = false;
        this.pswfprocessid = null;
    }

    public void setPSWFProcessName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocessname = string;
        this.pswfprocessnameDirtyFlag = true;
    }

    public String getPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessName();
        }
        return this.pswfprocessname;
    }

    public boolean isPSWFProcessNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessNameDirty();
        }
        return this.pswfprocessnameDirtyFlag;
    }

    public void resetPSWFProcessName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessName();
            return;
        }
        this.pswfprocessnameDirtyFlag = false;
        this.pswfprocessname = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
    }

    public void setUAGroupParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUAGroupParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uagroupparam = string;
        this.uagroupparamDirtyFlag = true;
    }

    public String getUAGroupParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUAGroupParam();
        }
        return this.uagroupparam;
    }

    public boolean isUAGroupParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUAGroupParamDirty();
        }
        return this.uagroupparamDirtyFlag;
    }

    public void resetUAGroupParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUAGroupParam();
            return;
        }
        this.uagroupparamDirtyFlag = false;
        this.uagroupparam = null;
    }

    public void setUAGTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUAGTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uagtag = string;
        this.uagtagDirtyFlag = true;
    }

    public String getUAGTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUAGTag();
        }
        return this.uagtag;
    }

    public boolean isUAGTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUAGTagDirty();
        }
        return this.uagtagDirtyFlag;
    }

    public void resetUAGTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUAGTag();
            return;
        }
        this.uagtagDirtyFlag = false;
        this.uagtag = null;
    }

    public void setUAGTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUAGTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uagtag2 = string;
        this.uagtag2DirtyFlag = true;
    }

    public String getUAGTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUAGTag2();
        }
        return this.uagtag2;
    }

    public boolean isUAGTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUAGTag2Dirty();
        }
        return this.uagtag2DirtyFlag;
    }

    public void resetUAGTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUAGTag2();
            return;
        }
        this.uagtag2DirtyFlag = false;
        this.uagtag2 = null;
    }

    public void setUAGTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUAGTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uagtag3 = string;
        this.uagtag3DirtyFlag = true;
    }

    public String getUAGTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUAGTag3();
        }
        return this.uagtag3;
    }

    public boolean isUAGTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUAGTag3Dirty();
        }
        return this.uagtag3DirtyFlag;
    }

    public void resetUAGTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUAGTag3();
            return;
        }
        this.uagtag3DirtyFlag = false;
        this.uagtag3 = null;
    }

    public void setUAGTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUAGTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uagtag4 = string;
        this.uagtag4DirtyFlag = true;
    }

    public String getUAGTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUAGTag4();
        }
        return this.uagtag4;
    }

    public boolean isUAGTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUAGTag4Dirty();
        }
        return this.uagtag4DirtyFlag;
    }

    public void resetUAGTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUAGTag4();
            return;
        }
        this.uagtag4DirtyFlag = false;
        this.uagtag4 = null;
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

    public void setUserRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRefFlag(n);
            return;
        }
        this.userrefflag = n;
        this.userrefflagDirtyFlag = true;
    }

    public Integer getUserRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRefFlag();
        }
        return this.userrefflag;
    }

    public boolean isUserRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRefFlagDirty();
        }
        return this.userrefflagDirtyFlag;
    }

    public void resetUserRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRefFlag();
            return;
        }
        this.userrefflagDirtyFlag = false;
        this.userrefflag = null;
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
        PSDEUAGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUAGroupBase pSDEUAGroupBase) {
        pSDEUAGroupBase.resetCodeName();
        pSDEUAGroupBase.resetCreateDate();
        pSDEUAGroupBase.resetCreateMan();
        pSDEUAGroupBase.resetDynaModelFlag();
        pSDEUAGroupBase.resetLockFlag();
        pSDEUAGroupBase.resetMemo();
        pSDEUAGroupBase.resetPSDEId();
        pSDEUAGroupBase.resetPSDEName();
        pSDEUAGroupBase.resetPSDEUAGroupId();
        pSDEUAGroupBase.resetPSDEUAGroupName();
        pSDEUAGroupBase.resetPSDynaInstId();
        pSDEUAGroupBase.resetPSModuleId();
        pSDEUAGroupBase.resetPSModuleName();
        pSDEUAGroupBase.resetPSSystemId();
        pSDEUAGroupBase.resetPSSystemName();
        pSDEUAGroupBase.resetPSWFId();
        pSDEUAGroupBase.resetPSWFName();
        pSDEUAGroupBase.resetPSWFProcessId();
        pSDEUAGroupBase.resetPSWFProcessName();
        pSDEUAGroupBase.resetPSWFVersionId();
        pSDEUAGroupBase.resetPSWFVersionName();
        pSDEUAGroupBase.resetUAGroupParam();
        pSDEUAGroupBase.resetUAGTag();
        pSDEUAGroupBase.resetUAGTag2();
        pSDEUAGroupBase.resetUAGTag3();
        pSDEUAGroupBase.resetUAGTag4();
        pSDEUAGroupBase.resetUpdateDate();
        pSDEUAGroupBase.resetUpdateMan();
        pSDEUAGroupBase.resetUserCat();
        pSDEUAGroupBase.resetUserRefFlag();
        pSDEUAGroupBase.resetUserTag();
        pSDEUAGroupBase.resetUserTag2();
        pSDEUAGroupBase.resetUserTag3();
        pSDEUAGroupBase.resetUserTag4();
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
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
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
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
        }
        if (!bl || this.isPSWFProcessIdDirty()) {
            hashMap.put(FIELD_PSWFPROCESSID, this.getPSWFProcessId());
        }
        if (!bl || this.isPSWFProcessNameDirty()) {
            hashMap.put(FIELD_PSWFPROCESSNAME, this.getPSWFProcessName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isUAGroupParamDirty()) {
            hashMap.put(FIELD_UAGROUPPARAM, this.getUAGroupParam());
        }
        if (!bl || this.isUAGTagDirty()) {
            hashMap.put(FIELD_UAGTAG, this.getUAGTag());
        }
        if (!bl || this.isUAGTag2Dirty()) {
            hashMap.put(FIELD_UAGTAG2, this.getUAGTag2());
        }
        if (!bl || this.isUAGTag3Dirty()) {
            hashMap.put(FIELD_UAGTAG3, this.getUAGTag3());
        }
        if (!bl || this.isUAGTag4Dirty()) {
            hashMap.put(FIELD_UAGTAG4, this.getUAGTag4());
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
        if (!bl || this.isUserRefFlagDirty()) {
            hashMap.put(FIELD_USERREFFLAG, this.getUserRefFlag());
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
        return PSDEUAGroupBase.get(this, n);
    }

    private static Object get(PSDEUAGroupBase pSDEUAGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAGroupBase.getCodeName();
            }
            case 1: {
                return pSDEUAGroupBase.getCreateDate();
            }
            case 2: {
                return pSDEUAGroupBase.getCreateMan();
            }
            case 3: {
                return pSDEUAGroupBase.getDynaModelFlag();
            }
            case 4: {
                return pSDEUAGroupBase.getLockFlag();
            }
            case 5: {
                return pSDEUAGroupBase.getMemo();
            }
            case 6: {
                return pSDEUAGroupBase.getPSDEId();
            }
            case 7: {
                return pSDEUAGroupBase.getPSDEName();
            }
            case 8: {
                return pSDEUAGroupBase.getPSDEUAGroupId();
            }
            case 9: {
                return pSDEUAGroupBase.getPSDEUAGroupName();
            }
            case 10: {
                return pSDEUAGroupBase.getPSDynaInstId();
            }
            case 11: {
                return pSDEUAGroupBase.getPSModuleId();
            }
            case 12: {
                return pSDEUAGroupBase.getPSModuleName();
            }
            case 13: {
                return pSDEUAGroupBase.getPSSystemId();
            }
            case 14: {
                return pSDEUAGroupBase.getPSSystemName();
            }
            case 15: {
                return pSDEUAGroupBase.getPSWFId();
            }
            case 16: {
                return pSDEUAGroupBase.getPSWFName();
            }
            case 17: {
                return pSDEUAGroupBase.getPSWFProcessId();
            }
            case 18: {
                return pSDEUAGroupBase.getPSWFProcessName();
            }
            case 19: {
                return pSDEUAGroupBase.getPSWFVersionId();
            }
            case 20: {
                return pSDEUAGroupBase.getPSWFVersionName();
            }
            case 21: {
                return pSDEUAGroupBase.getUAGroupParam();
            }
            case 22: {
                return pSDEUAGroupBase.getUAGTag();
            }
            case 23: {
                return pSDEUAGroupBase.getUAGTag2();
            }
            case 24: {
                return pSDEUAGroupBase.getUAGTag3();
            }
            case 25: {
                return pSDEUAGroupBase.getUAGTag4();
            }
            case 26: {
                return pSDEUAGroupBase.getUpdateDate();
            }
            case 27: {
                return pSDEUAGroupBase.getUpdateMan();
            }
            case 28: {
                return pSDEUAGroupBase.getUserCat();
            }
            case 29: {
                return pSDEUAGroupBase.getUserRefFlag();
            }
            case 30: {
                return pSDEUAGroupBase.getUserTag();
            }
            case 31: {
                return pSDEUAGroupBase.getUserTag2();
            }
            case 32: {
                return pSDEUAGroupBase.getUserTag3();
            }
            case 33: {
                return pSDEUAGroupBase.getUserTag4();
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
        PSDEUAGroupBase.set(this, n, object);
    }

    private static void set(PSDEUAGroupBase pSDEUAGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUAGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEUAGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEUAGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUAGroupBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEUAGroupBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEUAGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUAGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEUAGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEUAGroupBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEUAGroupBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEUAGroupBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEUAGroupBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUAGroupBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEUAGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEUAGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEUAGroupBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEUAGroupBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEUAGroupBase.setPSWFProcessId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEUAGroupBase.setPSWFProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEUAGroupBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEUAGroupBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEUAGroupBase.setUAGroupParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEUAGroupBase.setUAGTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEUAGroupBase.setUAGTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEUAGroupBase.setUAGTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEUAGroupBase.setUAGTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEUAGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDEUAGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEUAGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEUAGroupBase.setUserRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEUAGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEUAGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEUAGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEUAGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEUAGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUAGroupBase pSDEUAGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSDEUAGroupBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEUAGroupBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEUAGroupBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSDEUAGroupBase.getLockFlag() == null;
            }
            case 5: {
                return pSDEUAGroupBase.getMemo() == null;
            }
            case 6: {
                return pSDEUAGroupBase.getPSDEId() == null;
            }
            case 7: {
                return pSDEUAGroupBase.getPSDEName() == null;
            }
            case 8: {
                return pSDEUAGroupBase.getPSDEUAGroupId() == null;
            }
            case 9: {
                return pSDEUAGroupBase.getPSDEUAGroupName() == null;
            }
            case 10: {
                return pSDEUAGroupBase.getPSDynaInstId() == null;
            }
            case 11: {
                return pSDEUAGroupBase.getPSModuleId() == null;
            }
            case 12: {
                return pSDEUAGroupBase.getPSModuleName() == null;
            }
            case 13: {
                return pSDEUAGroupBase.getPSSystemId() == null;
            }
            case 14: {
                return pSDEUAGroupBase.getPSSystemName() == null;
            }
            case 15: {
                return pSDEUAGroupBase.getPSWFId() == null;
            }
            case 16: {
                return pSDEUAGroupBase.getPSWFName() == null;
            }
            case 17: {
                return pSDEUAGroupBase.getPSWFProcessId() == null;
            }
            case 18: {
                return pSDEUAGroupBase.getPSWFProcessName() == null;
            }
            case 19: {
                return pSDEUAGroupBase.getPSWFVersionId() == null;
            }
            case 20: {
                return pSDEUAGroupBase.getPSWFVersionName() == null;
            }
            case 21: {
                return pSDEUAGroupBase.getUAGroupParam() == null;
            }
            case 22: {
                return pSDEUAGroupBase.getUAGTag() == null;
            }
            case 23: {
                return pSDEUAGroupBase.getUAGTag2() == null;
            }
            case 24: {
                return pSDEUAGroupBase.getUAGTag3() == null;
            }
            case 25: {
                return pSDEUAGroupBase.getUAGTag4() == null;
            }
            case 26: {
                return pSDEUAGroupBase.getUpdateDate() == null;
            }
            case 27: {
                return pSDEUAGroupBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDEUAGroupBase.getUserCat() == null;
            }
            case 29: {
                return pSDEUAGroupBase.getUserRefFlag() == null;
            }
            case 30: {
                return pSDEUAGroupBase.getUserTag() == null;
            }
            case 31: {
                return pSDEUAGroupBase.getUserTag2() == null;
            }
            case 32: {
                return pSDEUAGroupBase.getUserTag3() == null;
            }
            case 33: {
                return pSDEUAGroupBase.getUserTag4() == null;
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
        return PSDEUAGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEUAGroupBase pSDEUAGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEUAGroupBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEUAGroupBase.isCreateManDirty();
            }
            case 3: {
                return pSDEUAGroupBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSDEUAGroupBase.isLockFlagDirty();
            }
            case 5: {
                return pSDEUAGroupBase.isMemoDirty();
            }
            case 6: {
                return pSDEUAGroupBase.isPSDEIdDirty();
            }
            case 7: {
                return pSDEUAGroupBase.isPSDENameDirty();
            }
            case 8: {
                return pSDEUAGroupBase.isPSDEUAGroupIdDirty();
            }
            case 9: {
                return pSDEUAGroupBase.isPSDEUAGroupNameDirty();
            }
            case 10: {
                return pSDEUAGroupBase.isPSDynaInstIdDirty();
            }
            case 11: {
                return pSDEUAGroupBase.isPSModuleIdDirty();
            }
            case 12: {
                return pSDEUAGroupBase.isPSModuleNameDirty();
            }
            case 13: {
                return pSDEUAGroupBase.isPSSystemIdDirty();
            }
            case 14: {
                return pSDEUAGroupBase.isPSSystemNameDirty();
            }
            case 15: {
                return pSDEUAGroupBase.isPSWFIdDirty();
            }
            case 16: {
                return pSDEUAGroupBase.isPSWFNameDirty();
            }
            case 17: {
                return pSDEUAGroupBase.isPSWFProcessIdDirty();
            }
            case 18: {
                return pSDEUAGroupBase.isPSWFProcessNameDirty();
            }
            case 19: {
                return pSDEUAGroupBase.isPSWFVersionIdDirty();
            }
            case 20: {
                return pSDEUAGroupBase.isPSWFVersionNameDirty();
            }
            case 21: {
                return pSDEUAGroupBase.isUAGroupParamDirty();
            }
            case 22: {
                return pSDEUAGroupBase.isUAGTagDirty();
            }
            case 23: {
                return pSDEUAGroupBase.isUAGTag2Dirty();
            }
            case 24: {
                return pSDEUAGroupBase.isUAGTag3Dirty();
            }
            case 25: {
                return pSDEUAGroupBase.isUAGTag4Dirty();
            }
            case 26: {
                return pSDEUAGroupBase.isUpdateDateDirty();
            }
            case 27: {
                return pSDEUAGroupBase.isUpdateManDirty();
            }
            case 28: {
                return pSDEUAGroupBase.isUserCatDirty();
            }
            case 29: {
                return pSDEUAGroupBase.isUserRefFlagDirty();
            }
            case 30: {
                return pSDEUAGroupBase.isUserTagDirty();
            }
            case 31: {
                return pSDEUAGroupBase.isUserTag2Dirty();
            }
            case 32: {
                return pSDEUAGroupBase.isUserTag3Dirty();
            }
            case 33: {
                return pSDEUAGroupBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUAGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUAGroupBase pSDEUAGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUAGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSWFProcessId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSWFProcessId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSWFProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocessname", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSWFProcessName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUAGroupParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uagroupparam", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUAGroupParam()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUAGTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uagtag", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUAGTag()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUAGTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uagtag2", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUAGTag2()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUAGTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uagtag3", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUAGTag3()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUAGTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uagtag4", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUAGTag4()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUserRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userrefflag", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUserRefFlag()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEUAGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEUAGroupBase.getJSONValue((Object)pSDEUAGroupBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUAGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUAGroupBase pSDEUAGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUAGroupBase.getCodeName() != null) {
            object = pSDEUAGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getCreateDate() != null) {
            object = pSDEUAGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUAGroupBase.getCreateMan() != null) {
            object = pSDEUAGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getDynaModelFlag() != null) {
            object = pSDEUAGroupBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupBase.getLockFlag() != null) {
            object = pSDEUAGroupBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupBase.getMemo() != null) {
            object = pSDEUAGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSDEId() != null) {
            object = pSDEUAGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSDEName() != null) {
            object = pSDEUAGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSDEUAGroupId() != null) {
            object = pSDEUAGroupBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSDEUAGroupName() != null) {
            object = pSDEUAGroupBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSDynaInstId() != null) {
            object = pSDEUAGroupBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSModuleId() != null) {
            object = pSDEUAGroupBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSModuleName() != null) {
            object = pSDEUAGroupBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSSystemId() != null) {
            object = pSDEUAGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSSystemName() != null) {
            object = pSDEUAGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSWFId() != null) {
            object = pSDEUAGroupBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSWFName() != null) {
            object = pSDEUAGroupBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSWFProcessId() != null) {
            object = pSDEUAGroupBase.getPSWFProcessId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSWFProcessName() != null) {
            object = pSDEUAGroupBase.getPSWFProcessName();
            xmlNode.setAttribute(FIELD_PSWFPROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSWFVersionId() != null) {
            object = pSDEUAGroupBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getPSWFVersionName() != null) {
            object = pSDEUAGroupBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUAGroupParam() != null) {
            object = pSDEUAGroupBase.getUAGroupParam();
            xmlNode.setAttribute(FIELD_UAGROUPPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUAGTag() != null) {
            object = pSDEUAGroupBase.getUAGTag();
            xmlNode.setAttribute(FIELD_UAGTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUAGTag2() != null) {
            object = pSDEUAGroupBase.getUAGTag2();
            xmlNode.setAttribute(FIELD_UAGTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUAGTag3() != null) {
            object = pSDEUAGroupBase.getUAGTag3();
            xmlNode.setAttribute(FIELD_UAGTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUAGTag4() != null) {
            object = pSDEUAGroupBase.getUAGTag4();
            xmlNode.setAttribute(FIELD_UAGTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUpdateDate() != null) {
            object = pSDEUAGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUAGroupBase.getUpdateMan() != null) {
            object = pSDEUAGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUserCat() != null) {
            object = pSDEUAGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUserRefFlag() != null) {
            object = pSDEUAGroupBase.getUserRefFlag();
            xmlNode.setAttribute(FIELD_USERREFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupBase.getUserTag() != null) {
            object = pSDEUAGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUserTag2() != null) {
            object = pSDEUAGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUserTag3() != null) {
            object = pSDEUAGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupBase.getUserTag4() != null) {
            object = pSDEUAGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUAGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUAGroupBase pSDEUAGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUAGroupBase.isCodeNameDirty() && (bl || pSDEUAGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEUAGroupBase.getCodeName());
        }
        if (pSDEUAGroupBase.isCreateDateDirty() && (bl || pSDEUAGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUAGroupBase.getCreateDate());
        }
        if (pSDEUAGroupBase.isCreateManDirty() && (bl || pSDEUAGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUAGroupBase.getCreateMan());
        }
        if (pSDEUAGroupBase.isDynaModelFlagDirty() && (bl || pSDEUAGroupBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEUAGroupBase.getDynaModelFlag());
        }
        if (pSDEUAGroupBase.isLockFlagDirty() && (bl || pSDEUAGroupBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEUAGroupBase.getLockFlag());
        }
        if (pSDEUAGroupBase.isMemoDirty() && (bl || pSDEUAGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUAGroupBase.getMemo());
        }
        if (pSDEUAGroupBase.isPSDEIdDirty() && (bl || pSDEUAGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEUAGroupBase.getPSDEId());
        }
        if (pSDEUAGroupBase.isPSDENameDirty() && (bl || pSDEUAGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEUAGroupBase.getPSDEName());
        }
        if (pSDEUAGroupBase.isPSDEUAGroupIdDirty() && (bl || pSDEUAGroupBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        }
        if (pSDEUAGroupBase.isPSDEUAGroupNameDirty() && (bl || pSDEUAGroupBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEUAGroupBase.getPSDEUAGroupName());
        }
        if (pSDEUAGroupBase.isPSDynaInstIdDirty() && (bl || pSDEUAGroupBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEUAGroupBase.getPSDynaInstId());
        }
        if (pSDEUAGroupBase.isPSModuleIdDirty() && (bl || pSDEUAGroupBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEUAGroupBase.getPSModuleId());
        }
        if (pSDEUAGroupBase.isPSModuleNameDirty() && (bl || pSDEUAGroupBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEUAGroupBase.getPSModuleName());
        }
        if (pSDEUAGroupBase.isPSSystemIdDirty() && (bl || pSDEUAGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEUAGroupBase.getPSSystemId());
        }
        if (pSDEUAGroupBase.isPSSystemNameDirty() && (bl || pSDEUAGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEUAGroupBase.getPSSystemName());
        }
        if (pSDEUAGroupBase.isPSWFIdDirty() && (bl || pSDEUAGroupBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSDEUAGroupBase.getPSWFId());
        }
        if (pSDEUAGroupBase.isPSWFNameDirty() && (bl || pSDEUAGroupBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSDEUAGroupBase.getPSWFName());
        }
        if (pSDEUAGroupBase.isPSWFProcessIdDirty() && (bl || pSDEUAGroupBase.getPSWFProcessId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSID, (Object)pSDEUAGroupBase.getPSWFProcessId());
        }
        if (pSDEUAGroupBase.isPSWFProcessNameDirty() && (bl || pSDEUAGroupBase.getPSWFProcessName() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSNAME, (Object)pSDEUAGroupBase.getPSWFProcessName());
        }
        if (pSDEUAGroupBase.isPSWFVersionIdDirty() && (bl || pSDEUAGroupBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSDEUAGroupBase.getPSWFVersionId());
        }
        if (pSDEUAGroupBase.isPSWFVersionNameDirty() && (bl || pSDEUAGroupBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSDEUAGroupBase.getPSWFVersionName());
        }
        if (pSDEUAGroupBase.isUAGroupParamDirty() && (bl || pSDEUAGroupBase.getUAGroupParam() != null)) {
            iDataObject.set(FIELD_UAGROUPPARAM, (Object)pSDEUAGroupBase.getUAGroupParam());
        }
        if (pSDEUAGroupBase.isUAGTagDirty() && (bl || pSDEUAGroupBase.getUAGTag() != null)) {
            iDataObject.set(FIELD_UAGTAG, (Object)pSDEUAGroupBase.getUAGTag());
        }
        if (pSDEUAGroupBase.isUAGTag2Dirty() && (bl || pSDEUAGroupBase.getUAGTag2() != null)) {
            iDataObject.set(FIELD_UAGTAG2, (Object)pSDEUAGroupBase.getUAGTag2());
        }
        if (pSDEUAGroupBase.isUAGTag3Dirty() && (bl || pSDEUAGroupBase.getUAGTag3() != null)) {
            iDataObject.set(FIELD_UAGTAG3, (Object)pSDEUAGroupBase.getUAGTag3());
        }
        if (pSDEUAGroupBase.isUAGTag4Dirty() && (bl || pSDEUAGroupBase.getUAGTag4() != null)) {
            iDataObject.set(FIELD_UAGTAG4, (Object)pSDEUAGroupBase.getUAGTag4());
        }
        if (pSDEUAGroupBase.isUpdateDateDirty() && (bl || pSDEUAGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUAGroupBase.getUpdateDate());
        }
        if (pSDEUAGroupBase.isUpdateManDirty() && (bl || pSDEUAGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUAGroupBase.getUpdateMan());
        }
        if (pSDEUAGroupBase.isUserCatDirty() && (bl || pSDEUAGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEUAGroupBase.getUserCat());
        }
        if (pSDEUAGroupBase.isUserRefFlagDirty() && (bl || pSDEUAGroupBase.getUserRefFlag() != null)) {
            iDataObject.set(FIELD_USERREFFLAG, (Object)pSDEUAGroupBase.getUserRefFlag());
        }
        if (pSDEUAGroupBase.isUserTagDirty() && (bl || pSDEUAGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEUAGroupBase.getUserTag());
        }
        if (pSDEUAGroupBase.isUserTag2Dirty() && (bl || pSDEUAGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEUAGroupBase.getUserTag2());
        }
        if (pSDEUAGroupBase.isUserTag3Dirty() && (bl || pSDEUAGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEUAGroupBase.getUserTag3());
        }
        if (pSDEUAGroupBase.isUserTag4Dirty() && (bl || pSDEUAGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEUAGroupBase.getUserTag4());
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
        return PSDEUAGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEUAGroupBase pSDEUAGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUAGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEUAGroupBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEUAGroupBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEUAGroupBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSDEUAGroupBase.resetLockFlag();
                return true;
            }
            case 5: {
                pSDEUAGroupBase.resetMemo();
                return true;
            }
            case 6: {
                pSDEUAGroupBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSDEUAGroupBase.resetPSDEName();
                return true;
            }
            case 8: {
                pSDEUAGroupBase.resetPSDEUAGroupId();
                return true;
            }
            case 9: {
                pSDEUAGroupBase.resetPSDEUAGroupName();
                return true;
            }
            case 10: {
                pSDEUAGroupBase.resetPSDynaInstId();
                return true;
            }
            case 11: {
                pSDEUAGroupBase.resetPSModuleId();
                return true;
            }
            case 12: {
                pSDEUAGroupBase.resetPSModuleName();
                return true;
            }
            case 13: {
                pSDEUAGroupBase.resetPSSystemId();
                return true;
            }
            case 14: {
                pSDEUAGroupBase.resetPSSystemName();
                return true;
            }
            case 15: {
                pSDEUAGroupBase.resetPSWFId();
                return true;
            }
            case 16: {
                pSDEUAGroupBase.resetPSWFName();
                return true;
            }
            case 17: {
                pSDEUAGroupBase.resetPSWFProcessId();
                return true;
            }
            case 18: {
                pSDEUAGroupBase.resetPSWFProcessName();
                return true;
            }
            case 19: {
                pSDEUAGroupBase.resetPSWFVersionId();
                return true;
            }
            case 20: {
                pSDEUAGroupBase.resetPSWFVersionName();
                return true;
            }
            case 21: {
                pSDEUAGroupBase.resetUAGroupParam();
                return true;
            }
            case 22: {
                pSDEUAGroupBase.resetUAGTag();
                return true;
            }
            case 23: {
                pSDEUAGroupBase.resetUAGTag2();
                return true;
            }
            case 24: {
                pSDEUAGroupBase.resetUAGTag3();
                return true;
            }
            case 25: {
                pSDEUAGroupBase.resetUAGTag4();
                return true;
            }
            case 26: {
                pSDEUAGroupBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSDEUAGroupBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDEUAGroupBase.resetUserCat();
                return true;
            }
            case 29: {
                pSDEUAGroupBase.resetUserRefFlag();
                return true;
            }
            case 30: {
                pSDEUAGroupBase.resetUserTag();
                return true;
            }
            case 31: {
                pSDEUAGroupBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSDEUAGroupBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSDEUAGroupBase.resetUserTag4();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFProcess getPSWFProcess() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcess();
        }
        if (this.getPSWFProcessId() == null) {
            return null;
        }
        Integer n = this.objPSWFProcessLock;
        synchronized (n) {
            if (this.pswfprocess != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFProcessId(), (Object)this.pswfprocess.getPSWFProcessId()) != 0L) {
                this.pswfprocess = null;
            }
            if (this.pswfprocess == null) {
                PSWFProcess pSWFProcess = new PSWFProcess();
                pSWFProcess.setPSWFProcessId(this.getPSWFProcessId());
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                pSWFProcessService.autoGet((IEntity)pSWFProcess);
                this.pswfprocess = pSWFProcess;
            }
            return this.pswfprocess;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWF();
        }
        if (this.getPSWFId() == null) {
            return null;
        }
        Integer n = this.objPSWFLock;
        synchronized (n) {
            if (this.pswf != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFId(), (Object)this.pswf.getPSWorkflowId()) != 0L) {
                this.pswf = null;
            }
            if (this.pswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.pswf = pSWorkflow;
            }
            return this.pswf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEUAGroupDetail> getPSDEUAGrpDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGrpDetails();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEUAGrpDetailsLock;
        synchronized (n) {
            if (this.psdeuagrpdetails == null) {
                this.psdeuagrpdetails = pSDEUAGroupService.isTempData((IEntity)this) ? pSDEUAGroupDetailService.selectTempByPSDEUAGroup(this) : pSDEUAGroupDetailService.selectByPSDEUAGroup(this);
            }
            return this.psdeuagrpdetails;
        }
    }

    private PSDEUAGroupBase getProxyEntity() {
        return this.proxyPSDEUAGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUAGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUAGroupBase) {
            this.proxyPSDEUAGroupBase = (PSDEUAGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_LOCKFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDENAME, 7);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 8);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 9);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 10);
        fieldIndexMap.put(FIELD_PSMODULEID, 11);
        fieldIndexMap.put(FIELD_PSMODULENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 14);
        fieldIndexMap.put(FIELD_PSWFID, 15);
        fieldIndexMap.put(FIELD_PSWFNAME, 16);
        fieldIndexMap.put(FIELD_PSWFPROCESSID, 17);
        fieldIndexMap.put(FIELD_PSWFPROCESSNAME, 18);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 19);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 20);
        fieldIndexMap.put(FIELD_UAGROUPPARAM, 21);
        fieldIndexMap.put(FIELD_UAGTAG, 22);
        fieldIndexMap.put(FIELD_UAGTAG2, 23);
        fieldIndexMap.put(FIELD_UAGTAG3, 24);
        fieldIndexMap.put(FIELD_UAGTAG4, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERREFFLAG, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

