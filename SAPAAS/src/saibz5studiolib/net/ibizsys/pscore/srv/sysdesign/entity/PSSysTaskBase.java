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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTaskData;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTaskBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTaskBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FINISHFLAG = "FINISHFLAG";
    public static final String FIELD_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELTYPEID = "MODELTYPEID";
    public static final String FIELD_MODELTYPENAME = "MODELTYPENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTASKDATASCNT = "PSSYSTASKDATASCNT";
    public static final String FIELD_PSSYSTASKID = "PSSYSTASKID";
    public static final String FIELD_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_TARGET = "TARGET";
    public static final String FIELD_TASKTYPE = "TASKTYPE";
    public static final String FIELD_TODOTASKINFO = "TODOTASKINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FINISHFLAG = 3;
    private static final int INDEX_IMPORTANCEFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MODELTYPEID = 6;
    private static final int INDEX_MODELTYPENAME = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDENAME = 9;
    private static final int INDEX_PSMODULEID = 10;
    private static final int INDEX_PSMODULENAME = 11;
    private static final int INDEX_PSOBJID = 12;
    private static final int INDEX_PSOBJNAME = 13;
    private static final int INDEX_PSSYSAPPID = 14;
    private static final int INDEX_PSSYSAPPNAME = 15;
    private static final int INDEX_PSSYSREQITEMID = 16;
    private static final int INDEX_PSSYSREQITEMNAME = 17;
    private static final int INDEX_PSSYSTASKDATASCNT = 18;
    private static final int INDEX_PSSYSTASKID = 19;
    private static final int INDEX_PSSYSTASKNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_TARGET = 23;
    private static final int INDEX_TASKTYPE = 24;
    private static final int INDEX_TODOTASKINFO = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final int INDEX_USERTAG3 = 30;
    private static final int INDEX_USERTAG4 = 31;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTaskBase proxyPSSysTaskBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean finishflagDirtyFlag = false;
    private boolean importanceflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modeltypeidDirtyFlag = false;
    private boolean modeltypenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystaskdatascntDirtyFlag = false;
    private boolean pssystaskidDirtyFlag = false;
    private boolean pssystasknameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean targetDirtyFlag = false;
    private boolean tasktypeDirtyFlag = false;
    private boolean todotaskinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
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
    @Column(name="finishflag")
    private Integer finishflag;
    @Column(name="importanceflag")
    private Integer importanceflag;
    @Column(name="memo")
    private String memo;
    @Column(name="modeltypeid")
    private String modeltypeid;
    @Column(name="modeltypename")
    private String modeltypename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystaskdatascnt")
    private Integer pssystaskdatascnt;
    @Column(name="pssystaskid")
    private String pssystaskid;
    @Column(name="pssystaskname")
    private String pssystaskname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="target")
    private String target;
    @Column(name="tasktype")
    private Integer tasktype;
    @Column(name="todotaskinfo")
    private String todotaskinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysTaskDatasLock = new Integer(1);
    private ArrayList<PSSysTaskData> pssystaskdatas = null;

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

    public void setFinishFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishFlag(n);
            return;
        }
        this.finishflag = n;
        this.finishflagDirtyFlag = true;
    }

    public Integer getFinishFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishFlag();
        }
        return this.finishflag;
    }

    public boolean isFinishFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishFlagDirty();
        }
        return this.finishflagDirtyFlag;
    }

    public void resetFinishFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishFlag();
            return;
        }
        this.finishflagDirtyFlag = false;
        this.finishflag = null;
    }

    public void setImportanceFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportanceFlag(n);
            return;
        }
        this.importanceflag = n;
        this.importanceflagDirtyFlag = true;
    }

    public Integer getImportanceFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportanceFlag();
        }
        return this.importanceflag;
    }

    public boolean isImportanceFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportanceFlagDirty();
        }
        return this.importanceflagDirtyFlag;
    }

    public void resetImportanceFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportanceFlag();
            return;
        }
        this.importanceflagDirtyFlag = false;
        this.importanceflag = null;
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

    public void setModelTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltypeid = string;
        this.modeltypeidDirtyFlag = true;
    }

    public String getModelTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTypeId();
        }
        return this.modeltypeid;
    }

    public boolean isModelTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTypeIdDirty();
        }
        return this.modeltypeidDirtyFlag;
    }

    public void resetModelTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTypeId();
            return;
        }
        this.modeltypeidDirtyFlag = false;
        this.modeltypeid = null;
    }

    public void setModelTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltypename = string;
        this.modeltypenameDirtyFlag = true;
    }

    public String getModelTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTypeName();
        }
        return this.modeltypename;
    }

    public boolean isModelTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTypeNameDirty();
        }
        return this.modeltypenameDirtyFlag;
    }

    public void resetModelTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTypeName();
            return;
        }
        this.modeltypenameDirtyFlag = false;
        this.modeltypename = null;
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

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSSysTaskDatasCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskDatasCnt(n);
            return;
        }
        this.pssystaskdatascnt = n;
        this.pssystaskdatascntDirtyFlag = true;
    }

    public Integer getPSSysTaskDatasCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskDatasCnt();
        }
        return this.pssystaskdatascnt;
    }

    public boolean isPSSysTaskDatasCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskDatasCntDirty();
        }
        return this.pssystaskdatascntDirtyFlag;
    }

    public void resetPSSysTaskDatasCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskDatasCnt();
            return;
        }
        this.pssystaskdatascntDirtyFlag = false;
        this.pssystaskdatascnt = null;
    }

    public void setPSSysTaskId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskid = string;
        this.pssystaskidDirtyFlag = true;
    }

    public String getPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskId();
        }
        return this.pssystaskid;
    }

    public boolean isPSSysTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskIdDirty();
        }
        return this.pssystaskidDirtyFlag;
    }

    public void resetPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskId();
            return;
        }
        this.pssystaskidDirtyFlag = false;
        this.pssystaskid = null;
    }

    public void setPSSysTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskname = string;
        this.pssystasknameDirtyFlag = true;
    }

    public String getPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskName();
        }
        return this.pssystaskname;
    }

    public boolean isPSSysTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskNameDirty();
        }
        return this.pssystasknameDirtyFlag;
    }

    public void resetPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskName();
            return;
        }
        this.pssystasknameDirtyFlag = false;
        this.pssystaskname = null;
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

    public void setTarget(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTarget(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.target = string;
        this.targetDirtyFlag = true;
    }

    public String getTarget() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTarget();
        }
        return this.target;
    }

    public boolean isTargetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetDirty();
        }
        return this.targetDirtyFlag;
    }

    public void resetTarget() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTarget();
            return;
        }
        this.targetDirtyFlag = false;
        this.target = null;
    }

    public void setTaskType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskType(n);
            return;
        }
        this.tasktype = n;
        this.tasktypeDirtyFlag = true;
    }

    public Integer getTaskType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskType();
        }
        return this.tasktype;
    }

    public boolean isTaskTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskTypeDirty();
        }
        return this.tasktypeDirtyFlag;
    }

    public void resetTaskType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskType();
            return;
        }
        this.tasktypeDirtyFlag = false;
        this.tasktype = null;
    }

    public void setToDoTaskInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTaskInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotaskinfo = string;
        this.todotaskinfoDirtyFlag = true;
    }

    public String getToDoTaskInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTaskInfo();
        }
        return this.todotaskinfo;
    }

    public boolean isToDoTaskInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskInfoDirty();
        }
        return this.todotaskinfoDirtyFlag;
    }

    public void resetToDoTaskInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTaskInfo();
            return;
        }
        this.todotaskinfoDirtyFlag = false;
        this.todotaskinfo = null;
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
        PSSysTaskBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTaskBase pSSysTaskBase) {
        pSSysTaskBase.resetCodeName();
        pSSysTaskBase.resetCreateDate();
        pSSysTaskBase.resetCreateMan();
        pSSysTaskBase.resetFinishFlag();
        pSSysTaskBase.resetImportanceFlag();
        pSSysTaskBase.resetMemo();
        pSSysTaskBase.resetModelTypeId();
        pSSysTaskBase.resetModelTypeName();
        pSSysTaskBase.resetPSDEId();
        pSSysTaskBase.resetPSDEName();
        pSSysTaskBase.resetPSModuleId();
        pSSysTaskBase.resetPSModuleName();
        pSSysTaskBase.resetPSObjId();
        pSSysTaskBase.resetPSObjName();
        pSSysTaskBase.resetPSSysAppId();
        pSSysTaskBase.resetPSSysAppName();
        pSSysTaskBase.resetPSSysReqItemId();
        pSSysTaskBase.resetPSSysReqItemName();
        pSSysTaskBase.resetPSSysTaskDatasCnt();
        pSSysTaskBase.resetPSSysTaskId();
        pSSysTaskBase.resetPSSysTaskName();
        pSSysTaskBase.resetPSSystemId();
        pSSysTaskBase.resetPSSystemName();
        pSSysTaskBase.resetTarget();
        pSSysTaskBase.resetTaskType();
        pSSysTaskBase.resetToDoTaskInfo();
        pSSysTaskBase.resetUpdateDate();
        pSSysTaskBase.resetUpdateMan();
        pSSysTaskBase.resetUserTag();
        pSSysTaskBase.resetUserTag2();
        pSSysTaskBase.resetUserTag3();
        pSSysTaskBase.resetUserTag4();
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
        if (!bl || this.isFinishFlagDirty()) {
            hashMap.put(FIELD_FINISHFLAG, this.getFinishFlag());
        }
        if (!bl || this.isImportanceFlagDirty()) {
            hashMap.put(FIELD_IMPORTANCEFLAG, this.getImportanceFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelTypeIdDirty()) {
            hashMap.put(FIELD_MODELTYPEID, this.getModelTypeId());
        }
        if (!bl || this.isModelTypeNameDirty()) {
            hashMap.put(FIELD_MODELTYPENAME, this.getModelTypeName());
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
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysTaskDatasCntDirty()) {
            hashMap.put(FIELD_PSSYSTASKDATASCNT, this.getPSSysTaskDatasCnt());
        }
        if (!bl || this.isPSSysTaskIdDirty()) {
            hashMap.put(FIELD_PSSYSTASKID, this.getPSSysTaskId());
        }
        if (!bl || this.isPSSysTaskNameDirty()) {
            hashMap.put(FIELD_PSSYSTASKNAME, this.getPSSysTaskName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isTargetDirty()) {
            hashMap.put(FIELD_TARGET, this.getTarget());
        }
        if (!bl || this.isTaskTypeDirty()) {
            hashMap.put(FIELD_TASKTYPE, this.getTaskType());
        }
        if (!bl || this.isToDoTaskInfoDirty()) {
            hashMap.put(FIELD_TODOTASKINFO, this.getToDoTaskInfo());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSysTaskBase.get(this, n);
    }

    private static Object get(PSSysTaskBase pSSysTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTaskBase.getCodeName();
            }
            case 1: {
                return pSSysTaskBase.getCreateDate();
            }
            case 2: {
                return pSSysTaskBase.getCreateMan();
            }
            case 3: {
                return pSSysTaskBase.getFinishFlag();
            }
            case 4: {
                return pSSysTaskBase.getImportanceFlag();
            }
            case 5: {
                return pSSysTaskBase.getMemo();
            }
            case 6: {
                return pSSysTaskBase.getModelTypeId();
            }
            case 7: {
                return pSSysTaskBase.getModelTypeName();
            }
            case 8: {
                return pSSysTaskBase.getPSDEId();
            }
            case 9: {
                return pSSysTaskBase.getPSDEName();
            }
            case 10: {
                return pSSysTaskBase.getPSModuleId();
            }
            case 11: {
                return pSSysTaskBase.getPSModuleName();
            }
            case 12: {
                return pSSysTaskBase.getPSObjId();
            }
            case 13: {
                return pSSysTaskBase.getPSObjName();
            }
            case 14: {
                return pSSysTaskBase.getPSSysAppId();
            }
            case 15: {
                return pSSysTaskBase.getPSSysAppName();
            }
            case 16: {
                return pSSysTaskBase.getPSSysReqItemId();
            }
            case 17: {
                return pSSysTaskBase.getPSSysReqItemName();
            }
            case 18: {
                return pSSysTaskBase.getPSSysTaskDatasCnt();
            }
            case 19: {
                return pSSysTaskBase.getPSSysTaskId();
            }
            case 20: {
                return pSSysTaskBase.getPSSysTaskName();
            }
            case 21: {
                return pSSysTaskBase.getPSSystemId();
            }
            case 22: {
                return pSSysTaskBase.getPSSystemName();
            }
            case 23: {
                return pSSysTaskBase.getTarget();
            }
            case 24: {
                return pSSysTaskBase.getTaskType();
            }
            case 25: {
                return pSSysTaskBase.getToDoTaskInfo();
            }
            case 26: {
                return pSSysTaskBase.getUpdateDate();
            }
            case 27: {
                return pSSysTaskBase.getUpdateMan();
            }
            case 28: {
                return pSSysTaskBase.getUserTag();
            }
            case 29: {
                return pSSysTaskBase.getUserTag2();
            }
            case 30: {
                return pSSysTaskBase.getUserTag3();
            }
            case 31: {
                return pSSysTaskBase.getUserTag4();
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
        PSSysTaskBase.set(this, n, object);
    }

    private static void set(PSSysTaskBase pSSysTaskBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTaskBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTaskBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTaskBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTaskBase.setFinishFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysTaskBase.setImportanceFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysTaskBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTaskBase.setModelTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTaskBase.setModelTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTaskBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTaskBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTaskBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTaskBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTaskBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTaskBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTaskBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTaskBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTaskBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTaskBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTaskBase.setPSSysTaskDatasCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysTaskBase.setPSSysTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTaskBase.setPSSysTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTaskBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTaskBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTaskBase.setTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTaskBase.setTaskType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysTaskBase.setToDoTaskInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTaskBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSSysTaskBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysTaskBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysTaskBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysTaskBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysTaskBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysTaskBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTaskBase pSSysTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTaskBase.getCodeName() == null;
            }
            case 1: {
                return pSSysTaskBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTaskBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTaskBase.getFinishFlag() == null;
            }
            case 4: {
                return pSSysTaskBase.getImportanceFlag() == null;
            }
            case 5: {
                return pSSysTaskBase.getMemo() == null;
            }
            case 6: {
                return pSSysTaskBase.getModelTypeId() == null;
            }
            case 7: {
                return pSSysTaskBase.getModelTypeName() == null;
            }
            case 8: {
                return pSSysTaskBase.getPSDEId() == null;
            }
            case 9: {
                return pSSysTaskBase.getPSDEName() == null;
            }
            case 10: {
                return pSSysTaskBase.getPSModuleId() == null;
            }
            case 11: {
                return pSSysTaskBase.getPSModuleName() == null;
            }
            case 12: {
                return pSSysTaskBase.getPSObjId() == null;
            }
            case 13: {
                return pSSysTaskBase.getPSObjName() == null;
            }
            case 14: {
                return pSSysTaskBase.getPSSysAppId() == null;
            }
            case 15: {
                return pSSysTaskBase.getPSSysAppName() == null;
            }
            case 16: {
                return pSSysTaskBase.getPSSysReqItemId() == null;
            }
            case 17: {
                return pSSysTaskBase.getPSSysReqItemName() == null;
            }
            case 18: {
                return pSSysTaskBase.getPSSysTaskDatasCnt() == null;
            }
            case 19: {
                return pSSysTaskBase.getPSSysTaskId() == null;
            }
            case 20: {
                return pSSysTaskBase.getPSSysTaskName() == null;
            }
            case 21: {
                return pSSysTaskBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysTaskBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysTaskBase.getTarget() == null;
            }
            case 24: {
                return pSSysTaskBase.getTaskType() == null;
            }
            case 25: {
                return pSSysTaskBase.getToDoTaskInfo() == null;
            }
            case 26: {
                return pSSysTaskBase.getUpdateDate() == null;
            }
            case 27: {
                return pSSysTaskBase.getUpdateMan() == null;
            }
            case 28: {
                return pSSysTaskBase.getUserTag() == null;
            }
            case 29: {
                return pSSysTaskBase.getUserTag2() == null;
            }
            case 30: {
                return pSSysTaskBase.getUserTag3() == null;
            }
            case 31: {
                return pSSysTaskBase.getUserTag4() == null;
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
        return PSSysTaskBase.contains(this, n);
    }

    private static boolean contains(PSSysTaskBase pSSysTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTaskBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysTaskBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTaskBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTaskBase.isFinishFlagDirty();
            }
            case 4: {
                return pSSysTaskBase.isImportanceFlagDirty();
            }
            case 5: {
                return pSSysTaskBase.isMemoDirty();
            }
            case 6: {
                return pSSysTaskBase.isModelTypeIdDirty();
            }
            case 7: {
                return pSSysTaskBase.isModelTypeNameDirty();
            }
            case 8: {
                return pSSysTaskBase.isPSDEIdDirty();
            }
            case 9: {
                return pSSysTaskBase.isPSDENameDirty();
            }
            case 10: {
                return pSSysTaskBase.isPSModuleIdDirty();
            }
            case 11: {
                return pSSysTaskBase.isPSModuleNameDirty();
            }
            case 12: {
                return pSSysTaskBase.isPSObjIdDirty();
            }
            case 13: {
                return pSSysTaskBase.isPSObjNameDirty();
            }
            case 14: {
                return pSSysTaskBase.isPSSysAppIdDirty();
            }
            case 15: {
                return pSSysTaskBase.isPSSysAppNameDirty();
            }
            case 16: {
                return pSSysTaskBase.isPSSysReqItemIdDirty();
            }
            case 17: {
                return pSSysTaskBase.isPSSysReqItemNameDirty();
            }
            case 18: {
                return pSSysTaskBase.isPSSysTaskDatasCntDirty();
            }
            case 19: {
                return pSSysTaskBase.isPSSysTaskIdDirty();
            }
            case 20: {
                return pSSysTaskBase.isPSSysTaskNameDirty();
            }
            case 21: {
                return pSSysTaskBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysTaskBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysTaskBase.isTargetDirty();
            }
            case 24: {
                return pSSysTaskBase.isTaskTypeDirty();
            }
            case 25: {
                return pSSysTaskBase.isToDoTaskInfoDirty();
            }
            case 26: {
                return pSSysTaskBase.isUpdateDateDirty();
            }
            case 27: {
                return pSSysTaskBase.isUpdateManDirty();
            }
            case 28: {
                return pSSysTaskBase.isUserTagDirty();
            }
            case 29: {
                return pSSysTaskBase.isUserTag2Dirty();
            }
            case 30: {
                return pSSysTaskBase.isUserTag3Dirty();
            }
            case 31: {
                return pSSysTaskBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTaskBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTaskBase pSSysTaskBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTaskBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getFinishFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishflag", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getFinishFlag()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getImportanceFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importanceflag", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getImportanceFlag()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getModelTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltypeid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getModelTypeId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getModelTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltypename", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getModelTypeName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSysTaskDatasCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskdatascnt", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSysTaskDatasCnt()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSysTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSysTaskId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSysTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskname", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSysTaskName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"target", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getTarget()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getTaskType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tasktype", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getTaskType()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getToDoTaskInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotaskinfo", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getToDoTaskInfo()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTaskBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTaskBase.getJSONValue((Object)pSSysTaskBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTaskBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTaskBase pSSysTaskBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTaskBase.getCodeName() != null) {
            object = pSSysTaskBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getCreateDate() != null) {
            object = pSSysTaskBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTaskBase.getCreateMan() != null) {
            object = pSSysTaskBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getFinishFlag() != null) {
            object = pSSysTaskBase.getFinishFlag();
            xmlNode.setAttribute(FIELD_FINISHFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTaskBase.getImportanceFlag() != null) {
            object = pSSysTaskBase.getImportanceFlag();
            xmlNode.setAttribute(FIELD_IMPORTANCEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTaskBase.getMemo() != null) {
            object = pSSysTaskBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getModelTypeId() != null) {
            object = pSSysTaskBase.getModelTypeId();
            xmlNode.setAttribute(FIELD_MODELTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getModelTypeName() != null) {
            object = pSSysTaskBase.getModelTypeName();
            xmlNode.setAttribute(FIELD_MODELTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSDEId() != null) {
            object = pSSysTaskBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSDEName() != null) {
            object = pSSysTaskBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSModuleId() != null) {
            object = pSSysTaskBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSModuleName() != null) {
            object = pSSysTaskBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSObjId() != null) {
            object = pSSysTaskBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSObjName() != null) {
            object = pSSysTaskBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSysAppId() != null) {
            object = pSSysTaskBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSysAppName() != null) {
            object = pSSysTaskBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSysReqItemId() != null) {
            object = pSSysTaskBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSysReqItemName() != null) {
            object = pSSysTaskBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSysTaskDatasCnt() != null) {
            object = pSSysTaskBase.getPSSysTaskDatasCnt();
            xmlNode.setAttribute(FIELD_PSSYSTASKDATASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTaskBase.getPSSysTaskId() != null) {
            object = pSSysTaskBase.getPSSysTaskId();
            xmlNode.setAttribute(FIELD_PSSYSTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSysTaskName() != null) {
            object = pSSysTaskBase.getPSSysTaskName();
            xmlNode.setAttribute(FIELD_PSSYSTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSystemId() != null) {
            object = pSSysTaskBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getPSSystemName() != null) {
            object = pSSysTaskBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getTarget() != null) {
            object = pSSysTaskBase.getTarget();
            xmlNode.setAttribute(FIELD_TARGET, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getTaskType() != null) {
            object = pSSysTaskBase.getTaskType();
            xmlNode.setAttribute(FIELD_TASKTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTaskBase.getToDoTaskInfo() != null) {
            object = pSSysTaskBase.getToDoTaskInfo();
            xmlNode.setAttribute(FIELD_TODOTASKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getUpdateDate() != null) {
            object = pSSysTaskBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTaskBase.getUpdateMan() != null) {
            object = pSSysTaskBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getUserTag() != null) {
            object = pSSysTaskBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getUserTag2() != null) {
            object = pSSysTaskBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getUserTag3() != null) {
            object = pSSysTaskBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskBase.getUserTag4() != null) {
            object = pSSysTaskBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTaskBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTaskBase pSSysTaskBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTaskBase.isCodeNameDirty() && (bl || pSSysTaskBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysTaskBase.getCodeName());
        }
        if (pSSysTaskBase.isCreateDateDirty() && (bl || pSSysTaskBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTaskBase.getCreateDate());
        }
        if (pSSysTaskBase.isCreateManDirty() && (bl || pSSysTaskBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTaskBase.getCreateMan());
        }
        if (pSSysTaskBase.isFinishFlagDirty() && (bl || pSSysTaskBase.getFinishFlag() != null)) {
            iDataObject.set(FIELD_FINISHFLAG, (Object)pSSysTaskBase.getFinishFlag());
        }
        if (pSSysTaskBase.isImportanceFlagDirty() && (bl || pSSysTaskBase.getImportanceFlag() != null)) {
            iDataObject.set(FIELD_IMPORTANCEFLAG, (Object)pSSysTaskBase.getImportanceFlag());
        }
        if (pSSysTaskBase.isMemoDirty() && (bl || pSSysTaskBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTaskBase.getMemo());
        }
        if (pSSysTaskBase.isModelTypeIdDirty() && (bl || pSSysTaskBase.getModelTypeId() != null)) {
            iDataObject.set(FIELD_MODELTYPEID, (Object)pSSysTaskBase.getModelTypeId());
        }
        if (pSSysTaskBase.isModelTypeNameDirty() && (bl || pSSysTaskBase.getModelTypeName() != null)) {
            iDataObject.set(FIELD_MODELTYPENAME, (Object)pSSysTaskBase.getModelTypeName());
        }
        if (pSSysTaskBase.isPSDEIdDirty() && (bl || pSSysTaskBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysTaskBase.getPSDEId());
        }
        if (pSSysTaskBase.isPSDENameDirty() && (bl || pSSysTaskBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysTaskBase.getPSDEName());
        }
        if (pSSysTaskBase.isPSModuleIdDirty() && (bl || pSSysTaskBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysTaskBase.getPSModuleId());
        }
        if (pSSysTaskBase.isPSModuleNameDirty() && (bl || pSSysTaskBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysTaskBase.getPSModuleName());
        }
        if (pSSysTaskBase.isPSObjIdDirty() && (bl || pSSysTaskBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysTaskBase.getPSObjId());
        }
        if (pSSysTaskBase.isPSObjNameDirty() && (bl || pSSysTaskBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysTaskBase.getPSObjName());
        }
        if (pSSysTaskBase.isPSSysAppIdDirty() && (bl || pSSysTaskBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysTaskBase.getPSSysAppId());
        }
        if (pSSysTaskBase.isPSSysAppNameDirty() && (bl || pSSysTaskBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysTaskBase.getPSSysAppName());
        }
        if (pSSysTaskBase.isPSSysReqItemIdDirty() && (bl || pSSysTaskBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysTaskBase.getPSSysReqItemId());
        }
        if (pSSysTaskBase.isPSSysReqItemNameDirty() && (bl || pSSysTaskBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysTaskBase.getPSSysReqItemName());
        }
        if (pSSysTaskBase.isPSSysTaskDatasCntDirty() && (bl || pSSysTaskBase.getPSSysTaskDatasCnt() != null)) {
            iDataObject.set(FIELD_PSSYSTASKDATASCNT, (Object)pSSysTaskBase.getPSSysTaskDatasCnt());
        }
        if (pSSysTaskBase.isPSSysTaskIdDirty() && (bl || pSSysTaskBase.getPSSysTaskId() != null)) {
            iDataObject.set(FIELD_PSSYSTASKID, (Object)pSSysTaskBase.getPSSysTaskId());
        }
        if (pSSysTaskBase.isPSSysTaskNameDirty() && (bl || pSSysTaskBase.getPSSysTaskName() != null)) {
            iDataObject.set(FIELD_PSSYSTASKNAME, (Object)pSSysTaskBase.getPSSysTaskName());
        }
        if (pSSysTaskBase.isPSSystemIdDirty() && (bl || pSSysTaskBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysTaskBase.getPSSystemId());
        }
        if (pSSysTaskBase.isPSSystemNameDirty() && (bl || pSSysTaskBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysTaskBase.getPSSystemName());
        }
        if (pSSysTaskBase.isTargetDirty() && (bl || pSSysTaskBase.getTarget() != null)) {
            iDataObject.set(FIELD_TARGET, (Object)pSSysTaskBase.getTarget());
        }
        if (pSSysTaskBase.isTaskTypeDirty() && (bl || pSSysTaskBase.getTaskType() != null)) {
            iDataObject.set(FIELD_TASKTYPE, (Object)pSSysTaskBase.getTaskType());
        }
        if (pSSysTaskBase.isToDoTaskInfoDirty() && (bl || pSSysTaskBase.getToDoTaskInfo() != null)) {
            iDataObject.set(FIELD_TODOTASKINFO, (Object)pSSysTaskBase.getToDoTaskInfo());
        }
        if (pSSysTaskBase.isUpdateDateDirty() && (bl || pSSysTaskBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTaskBase.getUpdateDate());
        }
        if (pSSysTaskBase.isUpdateManDirty() && (bl || pSSysTaskBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTaskBase.getUpdateMan());
        }
        if (pSSysTaskBase.isUserTagDirty() && (bl || pSSysTaskBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTaskBase.getUserTag());
        }
        if (pSSysTaskBase.isUserTag2Dirty() && (bl || pSSysTaskBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTaskBase.getUserTag2());
        }
        if (pSSysTaskBase.isUserTag3Dirty() && (bl || pSSysTaskBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTaskBase.getUserTag3());
        }
        if (pSSysTaskBase.isUserTag4Dirty() && (bl || pSSysTaskBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTaskBase.getUserTag4());
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
        return PSSysTaskBase.remove(this, n);
    }

    private static boolean remove(PSSysTaskBase pSSysTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTaskBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysTaskBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTaskBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTaskBase.resetFinishFlag();
                return true;
            }
            case 4: {
                pSSysTaskBase.resetImportanceFlag();
                return true;
            }
            case 5: {
                pSSysTaskBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysTaskBase.resetModelTypeId();
                return true;
            }
            case 7: {
                pSSysTaskBase.resetModelTypeName();
                return true;
            }
            case 8: {
                pSSysTaskBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSSysTaskBase.resetPSDEName();
                return true;
            }
            case 10: {
                pSSysTaskBase.resetPSModuleId();
                return true;
            }
            case 11: {
                pSSysTaskBase.resetPSModuleName();
                return true;
            }
            case 12: {
                pSSysTaskBase.resetPSObjId();
                return true;
            }
            case 13: {
                pSSysTaskBase.resetPSObjName();
                return true;
            }
            case 14: {
                pSSysTaskBase.resetPSSysAppId();
                return true;
            }
            case 15: {
                pSSysTaskBase.resetPSSysAppName();
                return true;
            }
            case 16: {
                pSSysTaskBase.resetPSSysReqItemId();
                return true;
            }
            case 17: {
                pSSysTaskBase.resetPSSysReqItemName();
                return true;
            }
            case 18: {
                pSSysTaskBase.resetPSSysTaskDatasCnt();
                return true;
            }
            case 19: {
                pSSysTaskBase.resetPSSysTaskId();
                return true;
            }
            case 20: {
                pSSysTaskBase.resetPSSysTaskName();
                return true;
            }
            case 21: {
                pSSysTaskBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysTaskBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysTaskBase.resetTarget();
                return true;
            }
            case 24: {
                pSSysTaskBase.resetTaskType();
                return true;
            }
            case 25: {
                pSSysTaskBase.resetToDoTaskInfo();
                return true;
            }
            case 26: {
                pSSysTaskBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSSysTaskBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSSysTaskBase.resetUserTag();
                return true;
            }
            case 29: {
                pSSysTaskBase.resetUserTag2();
                return true;
            }
            case 30: {
                pSSysTaskBase.resetUserTag3();
                return true;
            }
            case 31: {
                pSSysTaskBase.resetUserTag4();
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
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
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
    public ArrayList<PSSysTaskData> getPSSysTaskDatas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskDatas();
        }
        if (this.getPSSysTaskId() == null) {
            return null;
        }
        PSSysTaskDataService pSSysTaskDataService = (PSSysTaskDataService)ServiceGlobal.getService(PSSysTaskDataService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTaskDatasLock;
        synchronized (n) {
            if (this.pssystaskdatas == null) {
                this.pssystaskdatas = pSSysTaskDataService.selectByPSSysTask(this);
            }
            return this.pssystaskdatas;
        }
    }

    private PSSysTaskBase getProxyEntity() {
        return this.proxyPSSysTaskBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTaskBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTaskBase) {
            this.proxyPSSysTaskBase = (PSSysTaskBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FINISHFLAG, 3);
        fieldIndexMap.put(FIELD_IMPORTANCEFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MODELTYPEID, 6);
        fieldIndexMap.put(FIELD_MODELTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDENAME, 9);
        fieldIndexMap.put(FIELD_PSMODULEID, 10);
        fieldIndexMap.put(FIELD_PSMODULENAME, 11);
        fieldIndexMap.put(FIELD_PSOBJID, 12);
        fieldIndexMap.put(FIELD_PSOBJNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSTASKDATASCNT, 18);
        fieldIndexMap.put(FIELD_PSSYSTASKID, 19);
        fieldIndexMap.put(FIELD_PSSYSTASKNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_TARGET, 23);
        fieldIndexMap.put(FIELD_TASKTYPE, 24);
        fieldIndexMap.put(FIELD_TODOTASKINFO, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
        fieldIndexMap.put(FIELD_USERTAG3, 30);
        fieldIndexMap.put(FIELD_USERTAG4, 31);
    }
}

