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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmdSQL;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdSQLService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSQLCmdBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSQLCmdBase.class);
    public static final String FIELD_CMDSN = "CMDSN";
    public static final String FIELD_CMDTAG = "CMDTAG";
    public static final String FIELD_CMDTAG2 = "CMDTAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSSQLCMDID = "PSSYSSQLCMDID";
    public static final String FIELD_PSSYSSQLCMDNAME = "PSSYSSQLCMDNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CMDSN = 0;
    private static final int INDEX_CMDTAG = 1;
    private static final int INDEX_CMDTAG2 = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_LOGICNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDENAME = 9;
    private static final int INDEX_PSMODULEID = 10;
    private static final int INDEX_PSMODULENAME = 11;
    private static final int INDEX_PSSYSSQLCMDID = 12;
    private static final int INDEX_PSSYSSQLCMDNAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSTEMNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSQLCmdBase proxyPSSysSQLCmdBase = null;
    private boolean cmdsnDirtyFlag = false;
    private boolean cmdtagDirtyFlag = false;
    private boolean cmdtag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyssqlcmdidDirtyFlag = false;
    private boolean pssyssqlcmdnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="cmdsn")
    private String cmdsn;
    @Column(name="cmdtag")
    private String cmdtag;
    @Column(name="cmdtag2")
    private String cmdtag2;
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
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyssqlcmdid")
    private String pssyssqlcmdid;
    @Column(name="pssyssqlcmdname")
    private String pssyssqlcmdname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysSqlCmdSqlsLock = new Integer(1);
    private ArrayList<PSSysSQLCmdSQL> pssyssqlcmdsqls = null;

    public void setCmdSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCmdSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmdsn = string;
        this.cmdsnDirtyFlag = true;
    }

    public String getCmdSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCmdSN();
        }
        return this.cmdsn;
    }

    public boolean isCmdSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCmdSNDirty();
        }
        return this.cmdsnDirtyFlag;
    }

    public void resetCmdSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCmdSN();
            return;
        }
        this.cmdsnDirtyFlag = false;
        this.cmdsn = null;
    }

    public void setCmdTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCmdTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmdtag = string;
        this.cmdtagDirtyFlag = true;
    }

    public String getCmdTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCmdTag();
        }
        return this.cmdtag;
    }

    public boolean isCmdTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCmdTagDirty();
        }
        return this.cmdtagDirtyFlag;
    }

    public void resetCmdTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCmdTag();
            return;
        }
        this.cmdtagDirtyFlag = false;
        this.cmdtag = null;
    }

    public void setCmdTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCmdTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmdtag2 = string;
        this.cmdtag2DirtyFlag = true;
    }

    public String getCmdTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCmdTag2();
        }
        return this.cmdtag2;
    }

    public boolean isCmdTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCmdTag2Dirty();
        }
        return this.cmdtag2DirtyFlag;
    }

    public void resetCmdTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCmdTag2();
            return;
        }
        this.cmdtag2DirtyFlag = false;
        this.cmdtag2 = null;
    }

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

    public void setPSSysSQLCmdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdid = string;
        this.pssyssqlcmdidDirtyFlag = true;
    }

    public String getPSSysSQLCmdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdId();
        }
        return this.pssyssqlcmdid;
    }

    public boolean isPSSysSQLCmdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdIdDirty();
        }
        return this.pssyssqlcmdidDirtyFlag;
    }

    public void resetPSSysSQLCmdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdId();
            return;
        }
        this.pssyssqlcmdidDirtyFlag = false;
        this.pssyssqlcmdid = null;
    }

    public void setPSSysSQLCmdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdname = string;
        this.pssyssqlcmdnameDirtyFlag = true;
    }

    public String getPSSysSQLCmdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdName();
        }
        return this.pssyssqlcmdname;
    }

    public boolean isPSSysSQLCmdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdNameDirty();
        }
        return this.pssyssqlcmdnameDirtyFlag;
    }

    public void resetPSSysSQLCmdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdName();
            return;
        }
        this.pssyssqlcmdnameDirtyFlag = false;
        this.pssyssqlcmdname = null;
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
        PSSysSQLCmdBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSQLCmdBase pSSysSQLCmdBase) {
        pSSysSQLCmdBase.resetCmdSN();
        pSSysSQLCmdBase.resetCmdTag();
        pSSysSQLCmdBase.resetCmdTag2();
        pSSysSQLCmdBase.resetCodeName();
        pSSysSQLCmdBase.resetCreateDate();
        pSSysSQLCmdBase.resetCreateMan();
        pSSysSQLCmdBase.resetLogicName();
        pSSysSQLCmdBase.resetMemo();
        pSSysSQLCmdBase.resetPSDEId();
        pSSysSQLCmdBase.resetPSDEName();
        pSSysSQLCmdBase.resetPSModuleId();
        pSSysSQLCmdBase.resetPSModuleName();
        pSSysSQLCmdBase.resetPSSysSQLCmdId();
        pSSysSQLCmdBase.resetPSSysSQLCmdName();
        pSSysSQLCmdBase.resetPSSystemId();
        pSSysSQLCmdBase.resetPSSystemName();
        pSSysSQLCmdBase.resetUpdateDate();
        pSSysSQLCmdBase.resetUpdateMan();
        pSSysSQLCmdBase.resetUserCat();
        pSSysSQLCmdBase.resetUserTag();
        pSSysSQLCmdBase.resetUserTag2();
        pSSysSQLCmdBase.resetUserTag3();
        pSSysSQLCmdBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCmdSNDirty()) {
            hashMap.put(FIELD_CMDSN, this.getCmdSN());
        }
        if (!bl || this.isCmdTagDirty()) {
            hashMap.put(FIELD_CMDTAG, this.getCmdTag());
        }
        if (!bl || this.isCmdTag2Dirty()) {
            hashMap.put(FIELD_CMDTAG2, this.getCmdTag2());
        }
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
        if (!bl || this.isPSSysSQLCmdIdDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDID, this.getPSSysSQLCmdId());
        }
        if (!bl || this.isPSSysSQLCmdNameDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDNAME, this.getPSSysSQLCmdName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysSQLCmdBase.get(this, n);
    }

    private static Object get(PSSysSQLCmdBase pSSysSQLCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSQLCmdBase.getCmdSN();
            }
            case 1: {
                return pSSysSQLCmdBase.getCmdTag();
            }
            case 2: {
                return pSSysSQLCmdBase.getCmdTag2();
            }
            case 3: {
                return pSSysSQLCmdBase.getCodeName();
            }
            case 4: {
                return pSSysSQLCmdBase.getCreateDate();
            }
            case 5: {
                return pSSysSQLCmdBase.getCreateMan();
            }
            case 6: {
                return pSSysSQLCmdBase.getLogicName();
            }
            case 7: {
                return pSSysSQLCmdBase.getMemo();
            }
            case 8: {
                return pSSysSQLCmdBase.getPSDEId();
            }
            case 9: {
                return pSSysSQLCmdBase.getPSDEName();
            }
            case 10: {
                return pSSysSQLCmdBase.getPSModuleId();
            }
            case 11: {
                return pSSysSQLCmdBase.getPSModuleName();
            }
            case 12: {
                return pSSysSQLCmdBase.getPSSysSQLCmdId();
            }
            case 13: {
                return pSSysSQLCmdBase.getPSSysSQLCmdName();
            }
            case 14: {
                return pSSysSQLCmdBase.getPSSystemId();
            }
            case 15: {
                return pSSysSQLCmdBase.getPSSystemName();
            }
            case 16: {
                return pSSysSQLCmdBase.getUpdateDate();
            }
            case 17: {
                return pSSysSQLCmdBase.getUpdateMan();
            }
            case 18: {
                return pSSysSQLCmdBase.getUserCat();
            }
            case 19: {
                return pSSysSQLCmdBase.getUserTag();
            }
            case 20: {
                return pSSysSQLCmdBase.getUserTag2();
            }
            case 21: {
                return pSSysSQLCmdBase.getUserTag3();
            }
            case 22: {
                return pSSysSQLCmdBase.getUserTag4();
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
        PSSysSQLCmdBase.set(this, n, object);
    }

    private static void set(PSSysSQLCmdBase pSSysSQLCmdBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSQLCmdBase.setCmdSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSQLCmdBase.setCmdTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSQLCmdBase.setCmdTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSQLCmdBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSQLCmdBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysSQLCmdBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSQLCmdBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSQLCmdBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSQLCmdBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSQLCmdBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSQLCmdBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSQLCmdBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSQLCmdBase.setPSSysSQLCmdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSQLCmdBase.setPSSysSQLCmdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSQLCmdBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSQLCmdBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSQLCmdBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysSQLCmdBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSQLCmdBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSQLCmdBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSQLCmdBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSQLCmdBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSQLCmdBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysSQLCmdBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSQLCmdBase pSSysSQLCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSQLCmdBase.getCmdSN() == null;
            }
            case 1: {
                return pSSysSQLCmdBase.getCmdTag() == null;
            }
            case 2: {
                return pSSysSQLCmdBase.getCmdTag2() == null;
            }
            case 3: {
                return pSSysSQLCmdBase.getCodeName() == null;
            }
            case 4: {
                return pSSysSQLCmdBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysSQLCmdBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysSQLCmdBase.getLogicName() == null;
            }
            case 7: {
                return pSSysSQLCmdBase.getMemo() == null;
            }
            case 8: {
                return pSSysSQLCmdBase.getPSDEId() == null;
            }
            case 9: {
                return pSSysSQLCmdBase.getPSDEName() == null;
            }
            case 10: {
                return pSSysSQLCmdBase.getPSModuleId() == null;
            }
            case 11: {
                return pSSysSQLCmdBase.getPSModuleName() == null;
            }
            case 12: {
                return pSSysSQLCmdBase.getPSSysSQLCmdId() == null;
            }
            case 13: {
                return pSSysSQLCmdBase.getPSSysSQLCmdName() == null;
            }
            case 14: {
                return pSSysSQLCmdBase.getPSSystemId() == null;
            }
            case 15: {
                return pSSysSQLCmdBase.getPSSystemName() == null;
            }
            case 16: {
                return pSSysSQLCmdBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysSQLCmdBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysSQLCmdBase.getUserCat() == null;
            }
            case 19: {
                return pSSysSQLCmdBase.getUserTag() == null;
            }
            case 20: {
                return pSSysSQLCmdBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysSQLCmdBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysSQLCmdBase.getUserTag4() == null;
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
        return PSSysSQLCmdBase.contains(this, n);
    }

    private static boolean contains(PSSysSQLCmdBase pSSysSQLCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSQLCmdBase.isCmdSNDirty();
            }
            case 1: {
                return pSSysSQLCmdBase.isCmdTagDirty();
            }
            case 2: {
                return pSSysSQLCmdBase.isCmdTag2Dirty();
            }
            case 3: {
                return pSSysSQLCmdBase.isCodeNameDirty();
            }
            case 4: {
                return pSSysSQLCmdBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysSQLCmdBase.isCreateManDirty();
            }
            case 6: {
                return pSSysSQLCmdBase.isLogicNameDirty();
            }
            case 7: {
                return pSSysSQLCmdBase.isMemoDirty();
            }
            case 8: {
                return pSSysSQLCmdBase.isPSDEIdDirty();
            }
            case 9: {
                return pSSysSQLCmdBase.isPSDENameDirty();
            }
            case 10: {
                return pSSysSQLCmdBase.isPSModuleIdDirty();
            }
            case 11: {
                return pSSysSQLCmdBase.isPSModuleNameDirty();
            }
            case 12: {
                return pSSysSQLCmdBase.isPSSysSQLCmdIdDirty();
            }
            case 13: {
                return pSSysSQLCmdBase.isPSSysSQLCmdNameDirty();
            }
            case 14: {
                return pSSysSQLCmdBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSSysSQLCmdBase.isPSSystemNameDirty();
            }
            case 16: {
                return pSSysSQLCmdBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysSQLCmdBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysSQLCmdBase.isUserCatDirty();
            }
            case 19: {
                return pSSysSQLCmdBase.isUserTagDirty();
            }
            case 20: {
                return pSSysSQLCmdBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysSQLCmdBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysSQLCmdBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSQLCmdBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSQLCmdBase pSSysSQLCmdBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSQLCmdBase.getCmdSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmdsn", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getCmdSN()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getCmdTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmdtag", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getCmdTag()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getCmdTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmdtag2", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getCmdTag2()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSSysSQLCmdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdid", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSSysSQLCmdId()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSSysSQLCmdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdname", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSSysSQLCmdName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSQLCmdBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSQLCmdBase.getJSONValue((Object)pSSysSQLCmdBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSQLCmdBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSQLCmdBase pSSysSQLCmdBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSQLCmdBase.getCmdSN() != null) {
            object = pSSysSQLCmdBase.getCmdSN();
            xmlNode.setAttribute(FIELD_CMDSN, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSQLCmdBase.getCmdTag() != null) {
            object = pSSysSQLCmdBase.getCmdTag();
            xmlNode.setAttribute(FIELD_CMDTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSQLCmdBase.getCmdTag2() != null) {
            object = pSSysSQLCmdBase.getCmdTag2();
            xmlNode.setAttribute(FIELD_CMDTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSQLCmdBase.getCodeName() != null) {
            object = pSSysSQLCmdBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getCreateDate() != null) {
            object = pSSysSQLCmdBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSQLCmdBase.getCreateMan() != null) {
            object = pSSysSQLCmdBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getLogicName() != null) {
            object = pSSysSQLCmdBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getMemo() != null) {
            object = pSSysSQLCmdBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSDEId() != null) {
            object = pSSysSQLCmdBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSDEName() != null) {
            object = pSSysSQLCmdBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSModuleId() != null) {
            object = pSSysSQLCmdBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSModuleName() != null) {
            object = pSSysSQLCmdBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSSysSQLCmdId() != null) {
            object = pSSysSQLCmdBase.getPSSysSQLCmdId();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSSysSQLCmdName() != null) {
            object = pSSysSQLCmdBase.getPSSysSQLCmdName();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSSystemId() != null) {
            object = pSSysSQLCmdBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getPSSystemName() != null) {
            object = pSSysSQLCmdBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getUpdateDate() != null) {
            object = pSSysSQLCmdBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSQLCmdBase.getUpdateMan() != null) {
            object = pSSysSQLCmdBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getUserCat() != null) {
            object = pSSysSQLCmdBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getUserTag() != null) {
            object = pSSysSQLCmdBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getUserTag2() != null) {
            object = pSSysSQLCmdBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getUserTag3() != null) {
            object = pSSysSQLCmdBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSQLCmdBase.getUserTag4() != null) {
            object = pSSysSQLCmdBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSQLCmdBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSQLCmdBase pSSysSQLCmdBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSQLCmdBase.isCmdSNDirty() && (bl || pSSysSQLCmdBase.getCmdSN() != null)) {
            iDataObject.set(FIELD_CMDSN, (Object)pSSysSQLCmdBase.getCmdSN());
        }
        if (pSSysSQLCmdBase.isCmdTagDirty() && (bl || pSSysSQLCmdBase.getCmdTag() != null)) {
            iDataObject.set(FIELD_CMDTAG, (Object)pSSysSQLCmdBase.getCmdTag());
        }
        if (pSSysSQLCmdBase.isCmdTag2Dirty() && (bl || pSSysSQLCmdBase.getCmdTag2() != null)) {
            iDataObject.set(FIELD_CMDTAG2, (Object)pSSysSQLCmdBase.getCmdTag2());
        }
        if (pSSysSQLCmdBase.isCodeNameDirty() && (bl || pSSysSQLCmdBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSQLCmdBase.getCodeName());
        }
        if (pSSysSQLCmdBase.isCreateDateDirty() && (bl || pSSysSQLCmdBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSQLCmdBase.getCreateDate());
        }
        if (pSSysSQLCmdBase.isCreateManDirty() && (bl || pSSysSQLCmdBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSQLCmdBase.getCreateMan());
        }
        if (pSSysSQLCmdBase.isLogicNameDirty() && (bl || pSSysSQLCmdBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysSQLCmdBase.getLogicName());
        }
        if (pSSysSQLCmdBase.isMemoDirty() && (bl || pSSysSQLCmdBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSQLCmdBase.getMemo());
        }
        if (pSSysSQLCmdBase.isPSDEIdDirty() && (bl || pSSysSQLCmdBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysSQLCmdBase.getPSDEId());
        }
        if (pSSysSQLCmdBase.isPSDENameDirty() && (bl || pSSysSQLCmdBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysSQLCmdBase.getPSDEName());
        }
        if (pSSysSQLCmdBase.isPSModuleIdDirty() && (bl || pSSysSQLCmdBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysSQLCmdBase.getPSModuleId());
        }
        if (pSSysSQLCmdBase.isPSModuleNameDirty() && (bl || pSSysSQLCmdBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysSQLCmdBase.getPSModuleName());
        }
        if (pSSysSQLCmdBase.isPSSysSQLCmdIdDirty() && (bl || pSSysSQLCmdBase.getPSSysSQLCmdId() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDID, (Object)pSSysSQLCmdBase.getPSSysSQLCmdId());
        }
        if (pSSysSQLCmdBase.isPSSysSQLCmdNameDirty() && (bl || pSSysSQLCmdBase.getPSSysSQLCmdName() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDNAME, (Object)pSSysSQLCmdBase.getPSSysSQLCmdName());
        }
        if (pSSysSQLCmdBase.isPSSystemIdDirty() && (bl || pSSysSQLCmdBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSQLCmdBase.getPSSystemId());
        }
        if (pSSysSQLCmdBase.isPSSystemNameDirty() && (bl || pSSysSQLCmdBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSQLCmdBase.getPSSystemName());
        }
        if (pSSysSQLCmdBase.isUpdateDateDirty() && (bl || pSSysSQLCmdBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSQLCmdBase.getUpdateDate());
        }
        if (pSSysSQLCmdBase.isUpdateManDirty() && (bl || pSSysSQLCmdBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSQLCmdBase.getUpdateMan());
        }
        if (pSSysSQLCmdBase.isUserCatDirty() && (bl || pSSysSQLCmdBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSQLCmdBase.getUserCat());
        }
        if (pSSysSQLCmdBase.isUserTagDirty() && (bl || pSSysSQLCmdBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSQLCmdBase.getUserTag());
        }
        if (pSSysSQLCmdBase.isUserTag2Dirty() && (bl || pSSysSQLCmdBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSQLCmdBase.getUserTag2());
        }
        if (pSSysSQLCmdBase.isUserTag3Dirty() && (bl || pSSysSQLCmdBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSQLCmdBase.getUserTag3());
        }
        if (pSSysSQLCmdBase.isUserTag4Dirty() && (bl || pSSysSQLCmdBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSQLCmdBase.getUserTag4());
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
        return PSSysSQLCmdBase.remove(this, n);
    }

    private static boolean remove(PSSysSQLCmdBase pSSysSQLCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSQLCmdBase.resetCmdSN();
                return true;
            }
            case 1: {
                pSSysSQLCmdBase.resetCmdTag();
                return true;
            }
            case 2: {
                pSSysSQLCmdBase.resetCmdTag2();
                return true;
            }
            case 3: {
                pSSysSQLCmdBase.resetCodeName();
                return true;
            }
            case 4: {
                pSSysSQLCmdBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysSQLCmdBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysSQLCmdBase.resetLogicName();
                return true;
            }
            case 7: {
                pSSysSQLCmdBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysSQLCmdBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSSysSQLCmdBase.resetPSDEName();
                return true;
            }
            case 10: {
                pSSysSQLCmdBase.resetPSModuleId();
                return true;
            }
            case 11: {
                pSSysSQLCmdBase.resetPSModuleName();
                return true;
            }
            case 12: {
                pSSysSQLCmdBase.resetPSSysSQLCmdId();
                return true;
            }
            case 13: {
                pSSysSQLCmdBase.resetPSSysSQLCmdName();
                return true;
            }
            case 14: {
                pSSysSQLCmdBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSSysSQLCmdBase.resetPSSystemName();
                return true;
            }
            case 16: {
                pSSysSQLCmdBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysSQLCmdBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysSQLCmdBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysSQLCmdBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysSQLCmdBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysSQLCmdBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysSQLCmdBase.resetUserTag4();
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
    public ArrayList<PSSysSQLCmdSQL> getPSSysSqlCmdSqls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSqlCmdSqls();
        }
        if (this.getPSSysSQLCmdId() == null) {
            return null;
        }
        PSSysSQLCmdSQLService pSSysSQLCmdSQLService = (PSSysSQLCmdSQLService)ServiceGlobal.getService(PSSysSQLCmdSQLService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSqlCmdSqlsLock;
        synchronized (n) {
            if (this.pssyssqlcmdsqls == null) {
                this.pssyssqlcmdsqls = pSSysSQLCmdSQLService.selectByPSSysSqlCmd(this);
            }
            return this.pssyssqlcmdsqls;
        }
    }

    private PSSysSQLCmdBase getProxyEntity() {
        return this.proxyPSSysSQLCmdBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSQLCmdBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSQLCmdBase) {
            this.proxyPSSysSQLCmdBase = (PSSysSQLCmdBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CMDSN, 0);
        fieldIndexMap.put(FIELD_CMDTAG, 1);
        fieldIndexMap.put(FIELD_CMDTAG2, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_LOGICNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDENAME, 9);
        fieldIndexMap.put(FIELD_PSMODULEID, 10);
        fieldIndexMap.put(FIELD_PSMODULENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDID, 12);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

