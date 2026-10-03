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
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGrpDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlLogicGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlLogicGroupBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSCTRLLOGICGROUPID = "PPSCTRLLOGICGROUPID";
    public static final String FIELD_PPSCTRLLOGICGROUPNAME = "PPSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CTRLTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PPSCTRLLOGICGROUPID = 5;
    private static final int INDEX_PPSCTRLLOGICGROUPNAME = 6;
    private static final int INDEX_PSCTRLLOGICGROUPID = 7;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSDENAME = 10;
    private static final int INDEX_PSMODULEID = 11;
    private static final int INDEX_PSMODULENAME = 12;
    private static final int INDEX_PSSYSTEMID = 13;
    private static final int INDEX_PSSYSTEMNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_USERTAG3 = 20;
    private static final int INDEX_USERTAG4 = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlLogicGroupBase proxyPSCtrlLogicGroupBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsctrllogicgroupidDirtyFlag = false;
    private boolean ppsctrllogicgroupnameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
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
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsctrllogicgroupid")
    private String ppsctrllogicgroupid;
    @Column(name="ppsctrllogicgroupname")
    private String ppsctrllogicgroupname;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup ppsctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSCtrlLogicGrpDetailsLock = new Integer(1);
    private ArrayList<PSCtrlLogicGrpDetail> psctrllogicgrpdetails = null;

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

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
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

    public void setPPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsctrllogicgroupid = string;
        this.ppsctrllogicgroupidDirtyFlag = true;
    }

    public String getPPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCtrlLogicGroupId();
        }
        return this.ppsctrllogicgroupid;
    }

    public boolean isPPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSCtrlLogicGroupIdDirty();
        }
        return this.ppsctrllogicgroupidDirtyFlag;
    }

    public void resetPPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSCtrlLogicGroupId();
            return;
        }
        this.ppsctrllogicgroupidDirtyFlag = false;
        this.ppsctrllogicgroupid = null;
    }

    public void setPPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsctrllogicgroupname = string;
        this.ppsctrllogicgroupnameDirtyFlag = true;
    }

    public String getPPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCtrlLogicGroupName();
        }
        return this.ppsctrllogicgroupname;
    }

    public boolean isPPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSCtrlLogicGroupNameDirty();
        }
        return this.ppsctrllogicgroupnameDirtyFlag;
    }

    public void resetPPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSCtrlLogicGroupName();
            return;
        }
        this.ppsctrllogicgroupnameDirtyFlag = false;
        this.ppsctrllogicgroupname = null;
    }

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
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
        PSCtrlLogicGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) {
        pSCtrlLogicGroupBase.resetCodeName();
        pSCtrlLogicGroupBase.resetCreateDate();
        pSCtrlLogicGroupBase.resetCreateMan();
        pSCtrlLogicGroupBase.resetCtrlType();
        pSCtrlLogicGroupBase.resetMemo();
        pSCtrlLogicGroupBase.resetPPSCtrlLogicGroupId();
        pSCtrlLogicGroupBase.resetPPSCtrlLogicGroupName();
        pSCtrlLogicGroupBase.resetPSCtrlLogicGroupId();
        pSCtrlLogicGroupBase.resetPSCtrlLogicGroupName();
        pSCtrlLogicGroupBase.resetPSDEId();
        pSCtrlLogicGroupBase.resetPSDEName();
        pSCtrlLogicGroupBase.resetPSModuleId();
        pSCtrlLogicGroupBase.resetPSModuleName();
        pSCtrlLogicGroupBase.resetPSSystemId();
        pSCtrlLogicGroupBase.resetPSSystemName();
        pSCtrlLogicGroupBase.resetUpdateDate();
        pSCtrlLogicGroupBase.resetUpdateMan();
        pSCtrlLogicGroupBase.resetUserCat();
        pSCtrlLogicGroupBase.resetUserTag();
        pSCtrlLogicGroupBase.resetUserTag2();
        pSCtrlLogicGroupBase.resetUserTag3();
        pSCtrlLogicGroupBase.resetUserTag4();
        pSCtrlLogicGroupBase.resetValidFlag();
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
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PPSCTRLLOGICGROUPID, this.getPPSCtrlLogicGroupId());
        }
        if (!bl || this.isPPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PPSCTRLLOGICGROUPNAME, this.getPPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
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
        return PSCtrlLogicGroupBase.get(this, n);
    }

    private static Object get(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlLogicGroupBase.getCodeName();
            }
            case 1: {
                return pSCtrlLogicGroupBase.getCreateDate();
            }
            case 2: {
                return pSCtrlLogicGroupBase.getCreateMan();
            }
            case 3: {
                return pSCtrlLogicGroupBase.getCtrlType();
            }
            case 4: {
                return pSCtrlLogicGroupBase.getMemo();
            }
            case 5: {
                return pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId();
            }
            case 6: {
                return pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName();
            }
            case 7: {
                return pSCtrlLogicGroupBase.getPSCtrlLogicGroupId();
            }
            case 8: {
                return pSCtrlLogicGroupBase.getPSCtrlLogicGroupName();
            }
            case 9: {
                return pSCtrlLogicGroupBase.getPSDEId();
            }
            case 10: {
                return pSCtrlLogicGroupBase.getPSDEName();
            }
            case 11: {
                return pSCtrlLogicGroupBase.getPSModuleId();
            }
            case 12: {
                return pSCtrlLogicGroupBase.getPSModuleName();
            }
            case 13: {
                return pSCtrlLogicGroupBase.getPSSystemId();
            }
            case 14: {
                return pSCtrlLogicGroupBase.getPSSystemName();
            }
            case 15: {
                return pSCtrlLogicGroupBase.getUpdateDate();
            }
            case 16: {
                return pSCtrlLogicGroupBase.getUpdateMan();
            }
            case 17: {
                return pSCtrlLogicGroupBase.getUserCat();
            }
            case 18: {
                return pSCtrlLogicGroupBase.getUserTag();
            }
            case 19: {
                return pSCtrlLogicGroupBase.getUserTag2();
            }
            case 20: {
                return pSCtrlLogicGroupBase.getUserTag3();
            }
            case 21: {
                return pSCtrlLogicGroupBase.getUserTag4();
            }
            case 22: {
                return pSCtrlLogicGroupBase.getValidFlag();
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
        PSCtrlLogicGroupBase.set(this, n, object);
    }

    private static void set(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlLogicGroupBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlLogicGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlLogicGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlLogicGroupBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlLogicGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlLogicGroupBase.setPPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlLogicGroupBase.setPPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlLogicGroupBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlLogicGroupBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlLogicGroupBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlLogicGroupBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlLogicGroupBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlLogicGroupBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlLogicGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCtrlLogicGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCtrlLogicGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSCtrlLogicGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCtrlLogicGroupBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCtrlLogicGroupBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCtrlLogicGroupBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCtrlLogicGroupBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCtrlLogicGroupBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCtrlLogicGroupBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlLogicGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlLogicGroupBase.getCodeName() == null;
            }
            case 1: {
                return pSCtrlLogicGroupBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlLogicGroupBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlLogicGroupBase.getCtrlType() == null;
            }
            case 4: {
                return pSCtrlLogicGroupBase.getMemo() == null;
            }
            case 5: {
                return pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId() == null;
            }
            case 6: {
                return pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName() == null;
            }
            case 7: {
                return pSCtrlLogicGroupBase.getPSCtrlLogicGroupId() == null;
            }
            case 8: {
                return pSCtrlLogicGroupBase.getPSCtrlLogicGroupName() == null;
            }
            case 9: {
                return pSCtrlLogicGroupBase.getPSDEId() == null;
            }
            case 10: {
                return pSCtrlLogicGroupBase.getPSDEName() == null;
            }
            case 11: {
                return pSCtrlLogicGroupBase.getPSModuleId() == null;
            }
            case 12: {
                return pSCtrlLogicGroupBase.getPSModuleName() == null;
            }
            case 13: {
                return pSCtrlLogicGroupBase.getPSSystemId() == null;
            }
            case 14: {
                return pSCtrlLogicGroupBase.getPSSystemName() == null;
            }
            case 15: {
                return pSCtrlLogicGroupBase.getUpdateDate() == null;
            }
            case 16: {
                return pSCtrlLogicGroupBase.getUpdateMan() == null;
            }
            case 17: {
                return pSCtrlLogicGroupBase.getUserCat() == null;
            }
            case 18: {
                return pSCtrlLogicGroupBase.getUserTag() == null;
            }
            case 19: {
                return pSCtrlLogicGroupBase.getUserTag2() == null;
            }
            case 20: {
                return pSCtrlLogicGroupBase.getUserTag3() == null;
            }
            case 21: {
                return pSCtrlLogicGroupBase.getUserTag4() == null;
            }
            case 22: {
                return pSCtrlLogicGroupBase.getValidFlag() == null;
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
        return PSCtrlLogicGroupBase.contains(this, n);
    }

    private static boolean contains(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlLogicGroupBase.isCodeNameDirty();
            }
            case 1: {
                return pSCtrlLogicGroupBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlLogicGroupBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlLogicGroupBase.isCtrlTypeDirty();
            }
            case 4: {
                return pSCtrlLogicGroupBase.isMemoDirty();
            }
            case 5: {
                return pSCtrlLogicGroupBase.isPPSCtrlLogicGroupIdDirty();
            }
            case 6: {
                return pSCtrlLogicGroupBase.isPPSCtrlLogicGroupNameDirty();
            }
            case 7: {
                return pSCtrlLogicGroupBase.isPSCtrlLogicGroupIdDirty();
            }
            case 8: {
                return pSCtrlLogicGroupBase.isPSCtrlLogicGroupNameDirty();
            }
            case 9: {
                return pSCtrlLogicGroupBase.isPSDEIdDirty();
            }
            case 10: {
                return pSCtrlLogicGroupBase.isPSDENameDirty();
            }
            case 11: {
                return pSCtrlLogicGroupBase.isPSModuleIdDirty();
            }
            case 12: {
                return pSCtrlLogicGroupBase.isPSModuleNameDirty();
            }
            case 13: {
                return pSCtrlLogicGroupBase.isPSSystemIdDirty();
            }
            case 14: {
                return pSCtrlLogicGroupBase.isPSSystemNameDirty();
            }
            case 15: {
                return pSCtrlLogicGroupBase.isUpdateDateDirty();
            }
            case 16: {
                return pSCtrlLogicGroupBase.isUpdateManDirty();
            }
            case 17: {
                return pSCtrlLogicGroupBase.isUserCatDirty();
            }
            case 18: {
                return pSCtrlLogicGroupBase.isUserTagDirty();
            }
            case 19: {
                return pSCtrlLogicGroupBase.isUserTag2Dirty();
            }
            case 20: {
                return pSCtrlLogicGroupBase.isUserTag3Dirty();
            }
            case 21: {
                return pSCtrlLogicGroupBase.isUserTag4Dirty();
            }
            case 22: {
                return pSCtrlLogicGroupBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlLogicGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlLogicGroupBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsctrllogicgroupid", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsctrllogicgroupname", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getUserCat()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getUserTag()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSCtrlLogicGroupBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlLogicGroupBase.getJSONValue((Object)pSCtrlLogicGroupBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlLogicGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlLogicGroupBase.getCodeName() != null) {
            object = pSCtrlLogicGroupBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getCreateDate() != null) {
            object = pSCtrlLogicGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlLogicGroupBase.getCreateMan() != null) {
            object = pSCtrlLogicGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getCtrlType() != null) {
            object = pSCtrlLogicGroupBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getMemo() != null) {
            object = pSCtrlLogicGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId() != null) {
            object = pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PPSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName() != null) {
            object = pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PPSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSCtrlLogicGroupId() != null) {
            object = pSCtrlLogicGroupBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSCtrlLogicGroupName() != null) {
            object = pSCtrlLogicGroupBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSDEId() != null) {
            object = pSCtrlLogicGroupBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSDEName() != null) {
            object = pSCtrlLogicGroupBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSModuleId() != null) {
            object = pSCtrlLogicGroupBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSModuleName() != null) {
            object = pSCtrlLogicGroupBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSSystemId() != null) {
            object = pSCtrlLogicGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getPSSystemName() != null) {
            object = pSCtrlLogicGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getUpdateDate() != null) {
            object = pSCtrlLogicGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlLogicGroupBase.getUpdateMan() != null) {
            object = pSCtrlLogicGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getUserCat() != null) {
            object = pSCtrlLogicGroupBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag() != null) {
            object = pSCtrlLogicGroupBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag2() != null) {
            object = pSCtrlLogicGroupBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag3() != null) {
            object = pSCtrlLogicGroupBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getUserTag4() != null) {
            object = pSCtrlLogicGroupBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlLogicGroupBase.getValidFlag() != null) {
            object = pSCtrlLogicGroupBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlLogicGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlLogicGroupBase.isCodeNameDirty() && (bl || pSCtrlLogicGroupBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCtrlLogicGroupBase.getCodeName());
        }
        if (pSCtrlLogicGroupBase.isCreateDateDirty() && (bl || pSCtrlLogicGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlLogicGroupBase.getCreateDate());
        }
        if (pSCtrlLogicGroupBase.isCreateManDirty() && (bl || pSCtrlLogicGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlLogicGroupBase.getCreateMan());
        }
        if (pSCtrlLogicGroupBase.isCtrlTypeDirty() && (bl || pSCtrlLogicGroupBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSCtrlLogicGroupBase.getCtrlType());
        }
        if (pSCtrlLogicGroupBase.isMemoDirty() && (bl || pSCtrlLogicGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlLogicGroupBase.getMemo());
        }
        if (pSCtrlLogicGroupBase.isPPSCtrlLogicGroupIdDirty() && (bl || pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PPSCTRLLOGICGROUPID, (Object)pSCtrlLogicGroupBase.getPPSCtrlLogicGroupId());
        }
        if (pSCtrlLogicGroupBase.isPPSCtrlLogicGroupNameDirty() && (bl || pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PPSCTRLLOGICGROUPNAME, (Object)pSCtrlLogicGroupBase.getPPSCtrlLogicGroupName());
        }
        if (pSCtrlLogicGroupBase.isPSCtrlLogicGroupIdDirty() && (bl || pSCtrlLogicGroupBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId());
        }
        if (pSCtrlLogicGroupBase.isPSCtrlLogicGroupNameDirty() && (bl || pSCtrlLogicGroupBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupName());
        }
        if (pSCtrlLogicGroupBase.isPSDEIdDirty() && (bl || pSCtrlLogicGroupBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSCtrlLogicGroupBase.getPSDEId());
        }
        if (pSCtrlLogicGroupBase.isPSDENameDirty() && (bl || pSCtrlLogicGroupBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSCtrlLogicGroupBase.getPSDEName());
        }
        if (pSCtrlLogicGroupBase.isPSModuleIdDirty() && (bl || pSCtrlLogicGroupBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSCtrlLogicGroupBase.getPSModuleId());
        }
        if (pSCtrlLogicGroupBase.isPSModuleNameDirty() && (bl || pSCtrlLogicGroupBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSCtrlLogicGroupBase.getPSModuleName());
        }
        if (pSCtrlLogicGroupBase.isPSSystemIdDirty() && (bl || pSCtrlLogicGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSCtrlLogicGroupBase.getPSSystemId());
        }
        if (pSCtrlLogicGroupBase.isPSSystemNameDirty() && (bl || pSCtrlLogicGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSCtrlLogicGroupBase.getPSSystemName());
        }
        if (pSCtrlLogicGroupBase.isUpdateDateDirty() && (bl || pSCtrlLogicGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlLogicGroupBase.getUpdateDate());
        }
        if (pSCtrlLogicGroupBase.isUpdateManDirty() && (bl || pSCtrlLogicGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlLogicGroupBase.getUpdateMan());
        }
        if (pSCtrlLogicGroupBase.isUserCatDirty() && (bl || pSCtrlLogicGroupBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSCtrlLogicGroupBase.getUserCat());
        }
        if (pSCtrlLogicGroupBase.isUserTagDirty() && (bl || pSCtrlLogicGroupBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSCtrlLogicGroupBase.getUserTag());
        }
        if (pSCtrlLogicGroupBase.isUserTag2Dirty() && (bl || pSCtrlLogicGroupBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSCtrlLogicGroupBase.getUserTag2());
        }
        if (pSCtrlLogicGroupBase.isUserTag3Dirty() && (bl || pSCtrlLogicGroupBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSCtrlLogicGroupBase.getUserTag3());
        }
        if (pSCtrlLogicGroupBase.isUserTag4Dirty() && (bl || pSCtrlLogicGroupBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSCtrlLogicGroupBase.getUserTag4());
        }
        if (pSCtrlLogicGroupBase.isValidFlagDirty() && (bl || pSCtrlLogicGroupBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlLogicGroupBase.getValidFlag());
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
        return PSCtrlLogicGroupBase.remove(this, n);
    }

    private static boolean remove(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlLogicGroupBase.resetCodeName();
                return true;
            }
            case 1: {
                pSCtrlLogicGroupBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlLogicGroupBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlLogicGroupBase.resetCtrlType();
                return true;
            }
            case 4: {
                pSCtrlLogicGroupBase.resetMemo();
                return true;
            }
            case 5: {
                pSCtrlLogicGroupBase.resetPPSCtrlLogicGroupId();
                return true;
            }
            case 6: {
                pSCtrlLogicGroupBase.resetPPSCtrlLogicGroupName();
                return true;
            }
            case 7: {
                pSCtrlLogicGroupBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 8: {
                pSCtrlLogicGroupBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 9: {
                pSCtrlLogicGroupBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSCtrlLogicGroupBase.resetPSDEName();
                return true;
            }
            case 11: {
                pSCtrlLogicGroupBase.resetPSModuleId();
                return true;
            }
            case 12: {
                pSCtrlLogicGroupBase.resetPSModuleName();
                return true;
            }
            case 13: {
                pSCtrlLogicGroupBase.resetPSSystemId();
                return true;
            }
            case 14: {
                pSCtrlLogicGroupBase.resetPSSystemName();
                return true;
            }
            case 15: {
                pSCtrlLogicGroupBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSCtrlLogicGroupBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSCtrlLogicGroupBase.resetUserCat();
                return true;
            }
            case 18: {
                pSCtrlLogicGroupBase.resetUserTag();
                return true;
            }
            case 19: {
                pSCtrlLogicGroupBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSCtrlLogicGroupBase.resetUserTag3();
                return true;
            }
            case 21: {
                pSCtrlLogicGroupBase.resetUserTag4();
                return true;
            }
            case 22: {
                pSCtrlLogicGroupBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCtrlLogicGroup();
        }
        if (this.getPPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.ppsctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPPSCtrlLogicGroupId(), (Object)this.ppsctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.ppsctrllogicgroup = null;
            }
            if (this.ppsctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet(pSCtrlLogicGroup);
                this.ppsctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.ppsctrllogicgroup;
        }
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
    public ArrayList<PSCtrlLogicGrpDetail> getPSCtrlLogicGrpDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGrpDetails();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
        PSCtrlLogicGrpDetailService pSCtrlLogicGrpDetailService = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlLogicGrpDetailsLock;
        synchronized (n) {
            if (this.psctrllogicgrpdetails == null) {
                this.psctrllogicgrpdetails = pSCtrlLogicGroupService.isTempData(this) ? pSCtrlLogicGrpDetailService.selectTempByPSCtrlLogicGroup(this) : pSCtrlLogicGrpDetailService.selectByPSCtrlLogicGroup(this);
            }
            return this.psctrllogicgrpdetails;
        }
    }

    private PSCtrlLogicGroupBase getProxyEntity() {
        return this.proxyPSCtrlLogicGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlLogicGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlLogicGroupBase) {
            this.proxyPSCtrlLogicGroupBase = (PSCtrlLogicGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CTRLTYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PPSCTRLLOGICGROUPID, 5);
        fieldIndexMap.put(FIELD_PPSCTRLLOGICGROUPNAME, 6);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 7);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSDENAME, 10);
        fieldIndexMap.put(FIELD_PSMODULEID, 11);
        fieldIndexMap.put(FIELD_PSMODULENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_USERTAG3, 20);
        fieldIndexMap.put(FIELD_USERTAG4, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

