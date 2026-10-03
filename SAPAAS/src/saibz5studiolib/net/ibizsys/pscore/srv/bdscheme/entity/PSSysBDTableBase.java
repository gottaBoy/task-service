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
package net.ibizsys.pscore.srv.bdscheme.entity;

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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColumn;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModule;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPart;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDER;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDModuleService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDTableBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDTableBase.class);
    public static final String FIELD_BDTABLETYPE = "BDTABLETYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INHERITPSDEID = "INHERITPSDEID";
    public static final String FIELD_INHERITPSDENAME = "INHERITPSDENAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORPSDEID = "MINORPSDEID";
    public static final String FIELD_MINORPSDENAME = "MINORPSDENAME";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_PICKUPDEFNAME = "PICKUPDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSSYSBDCOLSETSCNT = "PSSYSBDCOLSETSCNT";
    public static final String FIELD_PSSYSBDCOLUMNSCNT = "PSSYSBDCOLUMNSCNT";
    public static final String FIELD_PSSYSBDMODULEID = "PSSYSBDMODULEID";
    public static final String FIELD_PSSYSBDMODULENAME = "PSSYSBDMODULENAME";
    public static final String FIELD_PSSYSBDPARTID = "PSSYSBDPARTID";
    public static final String FIELD_PSSYSBDPARTNAME = "PSSYSBDPARTNAME";
    public static final String FIELD_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String FIELD_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String FIELD_PSSYSBDTABLEDERSCNT = "PSSYSBDTABLEDERSCNT";
    public static final String FIELD_PSSYSBDTABLEDESCNT = "PSSYSBDTABLEDESCNT";
    public static final String FIELD_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String FIELD_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String FIELD_TYPEVALUE = "TYPEVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BDTABLETYPE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_INHERITPSDEID = 4;
    private static final int INDEX_INHERITPSDENAME = 5;
    private static final int INDEX_LOCKFLAG = 6;
    private static final int INDEX_LOGICNAME = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_MINORPSDEID = 9;
    private static final int INDEX_MINORPSDENAME = 10;
    private static final int INDEX_MODELVER = 11;
    private static final int INDEX_PICKUPDEFNAME = 12;
    private static final int INDEX_PSDEID = 13;
    private static final int INDEX_PSDENAME = 14;
    private static final int INDEX_PSDERID = 15;
    private static final int INDEX_PSDERNAME = 16;
    private static final int INDEX_PSSYSBDCOLSETSCNT = 17;
    private static final int INDEX_PSSYSBDCOLUMNSCNT = 18;
    private static final int INDEX_PSSYSBDMODULEID = 19;
    private static final int INDEX_PSSYSBDMODULENAME = 20;
    private static final int INDEX_PSSYSBDPARTID = 21;
    private static final int INDEX_PSSYSBDPARTNAME = 22;
    private static final int INDEX_PSSYSBDSCHEMEID = 23;
    private static final int INDEX_PSSYSBDSCHEMENAME = 24;
    private static final int INDEX_PSSYSBDTABLEDERSCNT = 25;
    private static final int INDEX_PSSYSBDTABLEDESCNT = 26;
    private static final int INDEX_PSSYSBDTABLEID = 27;
    private static final int INDEX_PSSYSBDTABLENAME = 28;
    private static final int INDEX_TYPEVALUE = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_USERCAT = 32;
    private static final int INDEX_USERTAG = 33;
    private static final int INDEX_USERTAG2 = 34;
    private static final int INDEX_USERTAG3 = 35;
    private static final int INDEX_USERTAG4 = 36;
    private static final int INDEX_VALIDFLAG = 37;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBDTableBase proxyPSSysBDTableBase = null;
    private boolean bdtabletypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean inheritpsdeidDirtyFlag = false;
    private boolean inheritpsdenameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorpsdeidDirtyFlag = false;
    private boolean minorpsdenameDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean pickupdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean pssysbdcolsetscntDirtyFlag = false;
    private boolean pssysbdcolumnscntDirtyFlag = false;
    private boolean pssysbdmoduleidDirtyFlag = false;
    private boolean pssysbdmodulenameDirtyFlag = false;
    private boolean pssysbdpartidDirtyFlag = false;
    private boolean pssysbdpartnameDirtyFlag = false;
    private boolean pssysbdschemeidDirtyFlag = false;
    private boolean pssysbdschemenameDirtyFlag = false;
    private boolean pssysbdtablederscntDirtyFlag = false;
    private boolean pssysbdtabledescntDirtyFlag = false;
    private boolean pssysbdtableidDirtyFlag = false;
    private boolean pssysbdtablenameDirtyFlag = false;
    private boolean typevalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bdtabletype")
    private Integer bdtabletype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="inheritpsdeid")
    private String inheritpsdeid;
    @Column(name="inheritpsdename")
    private String inheritpsdename;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorpsdeid")
    private String minorpsdeid;
    @Column(name="minorpsdename")
    private String minorpsdename;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="pickupdefname")
    private String pickupdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="pssysbdcolsetscnt")
    private Integer pssysbdcolsetscnt;
    @Column(name="pssysbdcolumnscnt")
    private Integer pssysbdcolumnscnt;
    @Column(name="pssysbdmoduleid")
    private String pssysbdmoduleid;
    @Column(name="pssysbdmodulename")
    private String pssysbdmodulename;
    @Column(name="pssysbdpartid")
    private String pssysbdpartid;
    @Column(name="pssysbdpartname")
    private String pssysbdpartname;
    @Column(name="pssysbdschemeid")
    private String pssysbdschemeid;
    @Column(name="pssysbdschemename")
    private String pssysbdschemename;
    @Column(name="pssysbdtablederscnt")
    private Integer pssysbdtablederscnt;
    @Column(name="pssysbdtabledescnt")
    private Integer pssysbdtabledescnt;
    @Column(name="pssysbdtableid")
    private String pssysbdtableid;
    @Column(name="pssysbdtablename")
    private String pssysbdtablename;
    @Column(name="typevalue")
    private String typevalue;
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
    private Integer objInheritPSDELock = new Integer(1);
    private PSDataEntity inheritpsde = null;
    private Integer objMinorPSDELock = new Integer(1);
    private PSDataEntity minorpsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSSysBDModuleLock = new Integer(1);
    private PSSysBDModule pssysbdmodule = null;
    private Integer objPSSysBDPartLock = new Integer(1);
    private PSSysBDPart pssysbdpart = null;
    private Integer objPSSysBDSchemeLock = new Integer(1);
    private PSSysBDScheme pssysbdscheme = null;
    private Integer objPSSysBDColSetsLock = new Integer(1);
    private ArrayList<PSSysBDColSet> pssysbdcolsets = null;
    private Integer objPSSysBDColumnsLock = new Integer(1);
    private ArrayList<PSSysBDColumn> pssysbdcolumns = null;
    private Integer objPSSysBDTableDERsLock = new Integer(1);
    private ArrayList<PSSysBDTableDER> pssysbdtableders = null;
    private Integer objPSSysBDTableDEsLock = new Integer(1);
    private ArrayList<PSSysBDTableDE> pssysbdtabledes = null;

    public void setBDTableType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBDTableType(n);
            return;
        }
        this.bdtabletype = n;
        this.bdtabletypeDirtyFlag = true;
    }

    public Integer getBDTableType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBDTableType();
        }
        return this.bdtabletype;
    }

    public boolean isBDTableTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBDTableTypeDirty();
        }
        return this.bdtabletypeDirtyFlag;
    }

    public void resetBDTableType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBDTableType();
            return;
        }
        this.bdtabletypeDirtyFlag = false;
        this.bdtabletype = null;
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

    public void setInheritPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInheritPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inheritpsdeid = string;
        this.inheritpsdeidDirtyFlag = true;
    }

    public String getInheritPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInheritPSDEId();
        }
        return this.inheritpsdeid;
    }

    public boolean isInheritPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInheritPSDEIdDirty();
        }
        return this.inheritpsdeidDirtyFlag;
    }

    public void resetInheritPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInheritPSDEId();
            return;
        }
        this.inheritpsdeidDirtyFlag = false;
        this.inheritpsdeid = null;
    }

    public void setInheritPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInheritPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inheritpsdename = string;
        this.inheritpsdenameDirtyFlag = true;
    }

    public String getInheritPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInheritPSDEName();
        }
        return this.inheritpsdename;
    }

    public boolean isInheritPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInheritPSDENameDirty();
        }
        return this.inheritpsdenameDirtyFlag;
    }

    public void resetInheritPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInheritPSDEName();
            return;
        }
        this.inheritpsdenameDirtyFlag = false;
        this.inheritpsdename = null;
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

    public void setMinorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdeid = string;
        this.minorpsdeidDirtyFlag = true;
    }

    public String getMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEId();
        }
        return this.minorpsdeid;
    }

    public boolean isMinorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDEIdDirty();
        }
        return this.minorpsdeidDirtyFlag;
    }

    public void resetMinorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEId();
            return;
        }
        this.minorpsdeidDirtyFlag = false;
        this.minorpsdeid = null;
    }

    public void setMinorPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorpsdename = string;
        this.minorpsdenameDirtyFlag = true;
    }

    public String getMinorPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDEName();
        }
        return this.minorpsdename;
    }

    public boolean isMinorPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorPSDENameDirty();
        }
        return this.minorpsdenameDirtyFlag;
    }

    public void resetMinorPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorPSDEName();
            return;
        }
        this.minorpsdenameDirtyFlag = false;
        this.minorpsdename = null;
    }

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
    }

    public void setPickupDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPickupDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pickupdefname = string;
        this.pickupdefnameDirtyFlag = true;
    }

    public String getPickupDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupDEFName();
        }
        return this.pickupdefname;
    }

    public boolean isPickupDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPickupDEFNameDirty();
        }
        return this.pickupdefnameDirtyFlag;
    }

    public void resetPickupDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPickupDEFName();
            return;
        }
        this.pickupdefnameDirtyFlag = false;
        this.pickupdefname = null;
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

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
    }

    public void setPSSysBDColSetsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColSetsCnt(n);
            return;
        }
        this.pssysbdcolsetscnt = n;
        this.pssysbdcolsetscntDirtyFlag = true;
    }

    public Integer getPSSysBDColSetsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColSetsCnt();
        }
        return this.pssysbdcolsetscnt;
    }

    public boolean isPSSysBDColSetsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColSetsCntDirty();
        }
        return this.pssysbdcolsetscntDirtyFlag;
    }

    public void resetPSSysBDColSetsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColSetsCnt();
            return;
        }
        this.pssysbdcolsetscntDirtyFlag = false;
        this.pssysbdcolsetscnt = null;
    }

    public void setPSSysBDColumnsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColumnsCnt(n);
            return;
        }
        this.pssysbdcolumnscnt = n;
        this.pssysbdcolumnscntDirtyFlag = true;
    }

    public Integer getPSSysBDColumnsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColumnsCnt();
        }
        return this.pssysbdcolumnscnt;
    }

    public boolean isPSSysBDColumnsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColumnsCntDirty();
        }
        return this.pssysbdcolumnscntDirtyFlag;
    }

    public void resetPSSysBDColumnsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColumnsCnt();
            return;
        }
        this.pssysbdcolumnscntDirtyFlag = false;
        this.pssysbdcolumnscnt = null;
    }

    public void setPSSysBDModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdmoduleid = string;
        this.pssysbdmoduleidDirtyFlag = true;
    }

    public String getPSSysBDModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDModuleId();
        }
        return this.pssysbdmoduleid;
    }

    public boolean isPSSysBDModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDModuleIdDirty();
        }
        return this.pssysbdmoduleidDirtyFlag;
    }

    public void resetPSSysBDModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDModuleId();
            return;
        }
        this.pssysbdmoduleidDirtyFlag = false;
        this.pssysbdmoduleid = null;
    }

    public void setPSSysBDModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdmodulename = string;
        this.pssysbdmodulenameDirtyFlag = true;
    }

    public String getPSSysBDModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDModuleName();
        }
        return this.pssysbdmodulename;
    }

    public boolean isPSSysBDModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDModuleNameDirty();
        }
        return this.pssysbdmodulenameDirtyFlag;
    }

    public void resetPSSysBDModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDModuleName();
            return;
        }
        this.pssysbdmodulenameDirtyFlag = false;
        this.pssysbdmodulename = null;
    }

    public void setPSSysBDPartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDPartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdpartid = string;
        this.pssysbdpartidDirtyFlag = true;
    }

    public String getPSSysBDPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDPartId();
        }
        return this.pssysbdpartid;
    }

    public boolean isPSSysBDPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDPartIdDirty();
        }
        return this.pssysbdpartidDirtyFlag;
    }

    public void resetPSSysBDPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDPartId();
            return;
        }
        this.pssysbdpartidDirtyFlag = false;
        this.pssysbdpartid = null;
    }

    public void setPSSysBDPartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDPartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdpartname = string;
        this.pssysbdpartnameDirtyFlag = true;
    }

    public String getPSSysBDPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDPartName();
        }
        return this.pssysbdpartname;
    }

    public boolean isPSSysBDPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDPartNameDirty();
        }
        return this.pssysbdpartnameDirtyFlag;
    }

    public void resetPSSysBDPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDPartName();
            return;
        }
        this.pssysbdpartnameDirtyFlag = false;
        this.pssysbdpartname = null;
    }

    public void setPSSysBDSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemeid = string;
        this.pssysbdschemeidDirtyFlag = true;
    }

    public String getPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeId();
        }
        return this.pssysbdschemeid;
    }

    public boolean isPSSysBDSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeIdDirty();
        }
        return this.pssysbdschemeidDirtyFlag;
    }

    public void resetPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeId();
            return;
        }
        this.pssysbdschemeidDirtyFlag = false;
        this.pssysbdschemeid = null;
    }

    public void setPSSysBDSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemename = string;
        this.pssysbdschemenameDirtyFlag = true;
    }

    public String getPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeName();
        }
        return this.pssysbdschemename;
    }

    public boolean isPSSysBDSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeNameDirty();
        }
        return this.pssysbdschemenameDirtyFlag;
    }

    public void resetPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeName();
            return;
        }
        this.pssysbdschemenameDirtyFlag = false;
        this.pssysbdschemename = null;
    }

    public void setPSSysBDTableDERsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableDERsCnt(n);
            return;
        }
        this.pssysbdtablederscnt = n;
        this.pssysbdtablederscntDirtyFlag = true;
    }

    public Integer getPSSysBDTableDERsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDERsCnt();
        }
        return this.pssysbdtablederscnt;
    }

    public boolean isPSSysBDTableDERsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableDERsCntDirty();
        }
        return this.pssysbdtablederscntDirtyFlag;
    }

    public void resetPSSysBDTableDERsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableDERsCnt();
            return;
        }
        this.pssysbdtablederscntDirtyFlag = false;
        this.pssysbdtablederscnt = null;
    }

    public void setPSSysBDTableDEsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableDEsCnt(n);
            return;
        }
        this.pssysbdtabledescnt = n;
        this.pssysbdtabledescntDirtyFlag = true;
    }

    public Integer getPSSysBDTableDEsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDEsCnt();
        }
        return this.pssysbdtabledescnt;
    }

    public boolean isPSSysBDTableDEsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableDEsCntDirty();
        }
        return this.pssysbdtabledescntDirtyFlag;
    }

    public void resetPSSysBDTableDEsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableDEsCnt();
            return;
        }
        this.pssysbdtabledescntDirtyFlag = false;
        this.pssysbdtabledescnt = null;
    }

    public void setPSSysBDTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtableid = string;
        this.pssysbdtableidDirtyFlag = true;
    }

    public String getPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableId();
        }
        return this.pssysbdtableid;
    }

    public boolean isPSSysBDTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableIdDirty();
        }
        return this.pssysbdtableidDirtyFlag;
    }

    public void resetPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableId();
            return;
        }
        this.pssysbdtableidDirtyFlag = false;
        this.pssysbdtableid = null;
    }

    public void setPSSysBDTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssysbdtablename = string;
        this.pssysbdtablenameDirtyFlag = true;
    }

    public String getPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableName();
        }
        return this.pssysbdtablename;
    }

    public boolean isPSSysBDTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableNameDirty();
        }
        return this.pssysbdtablenameDirtyFlag;
    }

    public void resetPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableName();
            return;
        }
        this.pssysbdtablenameDirtyFlag = false;
        this.pssysbdtablename = null;
    }

    public void setTypeValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typevalue = string;
        this.typevalueDirtyFlag = true;
    }

    public String getTypeValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeValue();
        }
        return this.typevalue;
    }

    public boolean isTypeValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeValueDirty();
        }
        return this.typevalueDirtyFlag;
    }

    public void resetTypeValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeValue();
            return;
        }
        this.typevalueDirtyFlag = false;
        this.typevalue = null;
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
        PSSysBDTableBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDTableBase pSSysBDTableBase) {
        pSSysBDTableBase.resetBDTableType();
        pSSysBDTableBase.resetCodeName();
        pSSysBDTableBase.resetCreateDate();
        pSSysBDTableBase.resetCreateMan();
        pSSysBDTableBase.resetInheritPSDEId();
        pSSysBDTableBase.resetInheritPSDEName();
        pSSysBDTableBase.resetLockFlag();
        pSSysBDTableBase.resetLogicName();
        pSSysBDTableBase.resetMemo();
        pSSysBDTableBase.resetMinorPSDEId();
        pSSysBDTableBase.resetMinorPSDEName();
        pSSysBDTableBase.resetModelVer();
        pSSysBDTableBase.resetPickupDEFName();
        pSSysBDTableBase.resetPSDEId();
        pSSysBDTableBase.resetPSDEName();
        pSSysBDTableBase.resetPSDERId();
        pSSysBDTableBase.resetPSDERName();
        pSSysBDTableBase.resetPSSysBDColSetsCnt();
        pSSysBDTableBase.resetPSSysBDColumnsCnt();
        pSSysBDTableBase.resetPSSysBDModuleId();
        pSSysBDTableBase.resetPSSysBDModuleName();
        pSSysBDTableBase.resetPSSysBDPartId();
        pSSysBDTableBase.resetPSSysBDPartName();
        pSSysBDTableBase.resetPSSysBDSchemeId();
        pSSysBDTableBase.resetPSSysBDSchemeName();
        pSSysBDTableBase.resetPSSysBDTableDERsCnt();
        pSSysBDTableBase.resetPSSysBDTableDEsCnt();
        pSSysBDTableBase.resetPSSysBDTableId();
        pSSysBDTableBase.resetPSSysBDTableName();
        pSSysBDTableBase.resetTypeValue();
        pSSysBDTableBase.resetUpdateDate();
        pSSysBDTableBase.resetUpdateMan();
        pSSysBDTableBase.resetUserCat();
        pSSysBDTableBase.resetUserTag();
        pSSysBDTableBase.resetUserTag2();
        pSSysBDTableBase.resetUserTag3();
        pSSysBDTableBase.resetUserTag4();
        pSSysBDTableBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBDTableTypeDirty()) {
            hashMap.put(FIELD_BDTABLETYPE, this.getBDTableType());
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
        if (!bl || this.isInheritPSDEIdDirty()) {
            hashMap.put(FIELD_INHERITPSDEID, this.getInheritPSDEId());
        }
        if (!bl || this.isInheritPSDENameDirty()) {
            hashMap.put(FIELD_INHERITPSDENAME, this.getInheritPSDEName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinorPSDEIdDirty()) {
            hashMap.put(FIELD_MINORPSDEID, this.getMinorPSDEId());
        }
        if (!bl || this.isMinorPSDENameDirty()) {
            hashMap.put(FIELD_MINORPSDENAME, this.getMinorPSDEName());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isPickupDEFNameDirty()) {
            hashMap.put(FIELD_PICKUPDEFNAME, this.getPickupDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSSysBDColSetsCntDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLSETSCNT, this.getPSSysBDColSetsCnt());
        }
        if (!bl || this.isPSSysBDColumnsCntDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLUMNSCNT, this.getPSSysBDColumnsCnt());
        }
        if (!bl || this.isPSSysBDModuleIdDirty()) {
            hashMap.put(FIELD_PSSYSBDMODULEID, this.getPSSysBDModuleId());
        }
        if (!bl || this.isPSSysBDModuleNameDirty()) {
            hashMap.put(FIELD_PSSYSBDMODULENAME, this.getPSSysBDModuleName());
        }
        if (!bl || this.isPSSysBDPartIdDirty()) {
            hashMap.put(FIELD_PSSYSBDPARTID, this.getPSSysBDPartId());
        }
        if (!bl || this.isPSSysBDPartNameDirty()) {
            hashMap.put(FIELD_PSSYSBDPARTNAME, this.getPSSysBDPartName());
        }
        if (!bl || this.isPSSysBDSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMEID, this.getPSSysBDSchemeId());
        }
        if (!bl || this.isPSSysBDSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMENAME, this.getPSSysBDSchemeName());
        }
        if (!bl || this.isPSSysBDTableDERsCntDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEDERSCNT, this.getPSSysBDTableDERsCnt());
        }
        if (!bl || this.isPSSysBDTableDEsCntDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEDESCNT, this.getPSSysBDTableDEsCnt());
        }
        if (!bl || this.isPSSysBDTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEID, this.getPSSysBDTableId());
        }
        if (!bl || this.isPSSysBDTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLENAME, this.getPSSysBDTableName());
        }
        if (!bl || this.isTypeValueDirty()) {
            hashMap.put(FIELD_TYPEVALUE, this.getTypeValue());
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
        return PSSysBDTableBase.get(this, n);
    }

    private static Object get(PSSysBDTableBase pSSysBDTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableBase.getBDTableType();
            }
            case 1: {
                return pSSysBDTableBase.getCodeName();
            }
            case 2: {
                return pSSysBDTableBase.getCreateDate();
            }
            case 3: {
                return pSSysBDTableBase.getCreateMan();
            }
            case 4: {
                return pSSysBDTableBase.getInheritPSDEId();
            }
            case 5: {
                return pSSysBDTableBase.getInheritPSDEName();
            }
            case 6: {
                return pSSysBDTableBase.getLockFlag();
            }
            case 7: {
                return pSSysBDTableBase.getLogicName();
            }
            case 8: {
                return pSSysBDTableBase.getMemo();
            }
            case 9: {
                return pSSysBDTableBase.getMinorPSDEId();
            }
            case 10: {
                return pSSysBDTableBase.getMinorPSDEName();
            }
            case 11: {
                return pSSysBDTableBase.getModelVer();
            }
            case 12: {
                return pSSysBDTableBase.getPickupDEFName();
            }
            case 13: {
                return pSSysBDTableBase.getPSDEId();
            }
            case 14: {
                return pSSysBDTableBase.getPSDEName();
            }
            case 15: {
                return pSSysBDTableBase.getPSDERId();
            }
            case 16: {
                return pSSysBDTableBase.getPSDERName();
            }
            case 17: {
                return pSSysBDTableBase.getPSSysBDColSetsCnt();
            }
            case 18: {
                return pSSysBDTableBase.getPSSysBDColumnsCnt();
            }
            case 19: {
                return pSSysBDTableBase.getPSSysBDModuleId();
            }
            case 20: {
                return pSSysBDTableBase.getPSSysBDModuleName();
            }
            case 21: {
                return pSSysBDTableBase.getPSSysBDPartId();
            }
            case 22: {
                return pSSysBDTableBase.getPSSysBDPartName();
            }
            case 23: {
                return pSSysBDTableBase.getPSSysBDSchemeId();
            }
            case 24: {
                return pSSysBDTableBase.getPSSysBDSchemeName();
            }
            case 25: {
                return pSSysBDTableBase.getPSSysBDTableDERsCnt();
            }
            case 26: {
                return pSSysBDTableBase.getPSSysBDTableDEsCnt();
            }
            case 27: {
                return pSSysBDTableBase.getPSSysBDTableId();
            }
            case 28: {
                return pSSysBDTableBase.getPSSysBDTableName();
            }
            case 29: {
                return pSSysBDTableBase.getTypeValue();
            }
            case 30: {
                return pSSysBDTableBase.getUpdateDate();
            }
            case 31: {
                return pSSysBDTableBase.getUpdateMan();
            }
            case 32: {
                return pSSysBDTableBase.getUserCat();
            }
            case 33: {
                return pSSysBDTableBase.getUserTag();
            }
            case 34: {
                return pSSysBDTableBase.getUserTag2();
            }
            case 35: {
                return pSSysBDTableBase.getUserTag3();
            }
            case 36: {
                return pSSysBDTableBase.getUserTag4();
            }
            case 37: {
                return pSSysBDTableBase.getValidFlag();
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
        PSSysBDTableBase.set(this, n, object);
    }

    private static void set(PSSysBDTableBase pSSysBDTableBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDTableBase.setBDTableType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDTableBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDTableBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDTableBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDTableBase.setInheritPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDTableBase.setInheritPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDTableBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDTableBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDTableBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDTableBase.setMinorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDTableBase.setMinorPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDTableBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDTableBase.setPickupDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDTableBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDTableBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDTableBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBDTableBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBDTableBase.setPSSysBDColSetsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysBDTableBase.setPSSysBDColumnsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysBDTableBase.setPSSysBDModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBDTableBase.setPSSysBDModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBDTableBase.setPSSysBDPartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBDTableBase.setPSSysBDPartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBDTableBase.setPSSysBDSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBDTableBase.setPSSysBDSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBDTableBase.setPSSysBDTableDERsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSysBDTableBase.setPSSysBDTableDEsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysBDTableBase.setPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBDTableBase.setPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBDTableBase.setTypeValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBDTableBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSSysBDTableBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBDTableBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBDTableBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysBDTableBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBDTableBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBDTableBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBDTableBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBDTableBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDTableBase pSSysBDTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableBase.getBDTableType() == null;
            }
            case 1: {
                return pSSysBDTableBase.getCodeName() == null;
            }
            case 2: {
                return pSSysBDTableBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysBDTableBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysBDTableBase.getInheritPSDEId() == null;
            }
            case 5: {
                return pSSysBDTableBase.getInheritPSDEName() == null;
            }
            case 6: {
                return pSSysBDTableBase.getLockFlag() == null;
            }
            case 7: {
                return pSSysBDTableBase.getLogicName() == null;
            }
            case 8: {
                return pSSysBDTableBase.getMemo() == null;
            }
            case 9: {
                return pSSysBDTableBase.getMinorPSDEId() == null;
            }
            case 10: {
                return pSSysBDTableBase.getMinorPSDEName() == null;
            }
            case 11: {
                return pSSysBDTableBase.getModelVer() == null;
            }
            case 12: {
                return pSSysBDTableBase.getPickupDEFName() == null;
            }
            case 13: {
                return pSSysBDTableBase.getPSDEId() == null;
            }
            case 14: {
                return pSSysBDTableBase.getPSDEName() == null;
            }
            case 15: {
                return pSSysBDTableBase.getPSDERId() == null;
            }
            case 16: {
                return pSSysBDTableBase.getPSDERName() == null;
            }
            case 17: {
                return pSSysBDTableBase.getPSSysBDColSetsCnt() == null;
            }
            case 18: {
                return pSSysBDTableBase.getPSSysBDColumnsCnt() == null;
            }
            case 19: {
                return pSSysBDTableBase.getPSSysBDModuleId() == null;
            }
            case 20: {
                return pSSysBDTableBase.getPSSysBDModuleName() == null;
            }
            case 21: {
                return pSSysBDTableBase.getPSSysBDPartId() == null;
            }
            case 22: {
                return pSSysBDTableBase.getPSSysBDPartName() == null;
            }
            case 23: {
                return pSSysBDTableBase.getPSSysBDSchemeId() == null;
            }
            case 24: {
                return pSSysBDTableBase.getPSSysBDSchemeName() == null;
            }
            case 25: {
                return pSSysBDTableBase.getPSSysBDTableDERsCnt() == null;
            }
            case 26: {
                return pSSysBDTableBase.getPSSysBDTableDEsCnt() == null;
            }
            case 27: {
                return pSSysBDTableBase.getPSSysBDTableId() == null;
            }
            case 28: {
                return pSSysBDTableBase.getPSSysBDTableName() == null;
            }
            case 29: {
                return pSSysBDTableBase.getTypeValue() == null;
            }
            case 30: {
                return pSSysBDTableBase.getUpdateDate() == null;
            }
            case 31: {
                return pSSysBDTableBase.getUpdateMan() == null;
            }
            case 32: {
                return pSSysBDTableBase.getUserCat() == null;
            }
            case 33: {
                return pSSysBDTableBase.getUserTag() == null;
            }
            case 34: {
                return pSSysBDTableBase.getUserTag2() == null;
            }
            case 35: {
                return pSSysBDTableBase.getUserTag3() == null;
            }
            case 36: {
                return pSSysBDTableBase.getUserTag4() == null;
            }
            case 37: {
                return pSSysBDTableBase.getValidFlag() == null;
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
        return PSSysBDTableBase.contains(this, n);
    }

    private static boolean contains(PSSysBDTableBase pSSysBDTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableBase.isBDTableTypeDirty();
            }
            case 1: {
                return pSSysBDTableBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysBDTableBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysBDTableBase.isCreateManDirty();
            }
            case 4: {
                return pSSysBDTableBase.isInheritPSDEIdDirty();
            }
            case 5: {
                return pSSysBDTableBase.isInheritPSDENameDirty();
            }
            case 6: {
                return pSSysBDTableBase.isLockFlagDirty();
            }
            case 7: {
                return pSSysBDTableBase.isLogicNameDirty();
            }
            case 8: {
                return pSSysBDTableBase.isMemoDirty();
            }
            case 9: {
                return pSSysBDTableBase.isMinorPSDEIdDirty();
            }
            case 10: {
                return pSSysBDTableBase.isMinorPSDENameDirty();
            }
            case 11: {
                return pSSysBDTableBase.isModelVerDirty();
            }
            case 12: {
                return pSSysBDTableBase.isPickupDEFNameDirty();
            }
            case 13: {
                return pSSysBDTableBase.isPSDEIdDirty();
            }
            case 14: {
                return pSSysBDTableBase.isPSDENameDirty();
            }
            case 15: {
                return pSSysBDTableBase.isPSDERIdDirty();
            }
            case 16: {
                return pSSysBDTableBase.isPSDERNameDirty();
            }
            case 17: {
                return pSSysBDTableBase.isPSSysBDColSetsCntDirty();
            }
            case 18: {
                return pSSysBDTableBase.isPSSysBDColumnsCntDirty();
            }
            case 19: {
                return pSSysBDTableBase.isPSSysBDModuleIdDirty();
            }
            case 20: {
                return pSSysBDTableBase.isPSSysBDModuleNameDirty();
            }
            case 21: {
                return pSSysBDTableBase.isPSSysBDPartIdDirty();
            }
            case 22: {
                return pSSysBDTableBase.isPSSysBDPartNameDirty();
            }
            case 23: {
                return pSSysBDTableBase.isPSSysBDSchemeIdDirty();
            }
            case 24: {
                return pSSysBDTableBase.isPSSysBDSchemeNameDirty();
            }
            case 25: {
                return pSSysBDTableBase.isPSSysBDTableDERsCntDirty();
            }
            case 26: {
                return pSSysBDTableBase.isPSSysBDTableDEsCntDirty();
            }
            case 27: {
                return pSSysBDTableBase.isPSSysBDTableIdDirty();
            }
            case 28: {
                return pSSysBDTableBase.isPSSysBDTableNameDirty();
            }
            case 29: {
                return pSSysBDTableBase.isTypeValueDirty();
            }
            case 30: {
                return pSSysBDTableBase.isUpdateDateDirty();
            }
            case 31: {
                return pSSysBDTableBase.isUpdateManDirty();
            }
            case 32: {
                return pSSysBDTableBase.isUserCatDirty();
            }
            case 33: {
                return pSSysBDTableBase.isUserTagDirty();
            }
            case 34: {
                return pSSysBDTableBase.isUserTag2Dirty();
            }
            case 35: {
                return pSSysBDTableBase.isUserTag3Dirty();
            }
            case 36: {
                return pSSysBDTableBase.isUserTag4Dirty();
            }
            case 37: {
                return pSSysBDTableBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDTableBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDTableBase pSSysBDTableBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDTableBase.getBDTableType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bdtabletype", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getBDTableType()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getInheritPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inheritpsdeid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getInheritPSDEId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getInheritPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inheritpsdename", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getInheritPSDEName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getMinorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdeid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getMinorPSDEId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getMinorPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorpsdename", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getMinorPSDEName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getModelVer()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPickupDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickupdefname", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPickupDEFName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDColSetsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolsetscnt", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDColSetsCnt()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDColumnsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolumnscnt", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDColumnsCnt()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdmoduleid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDModuleId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdmodulename", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDModuleName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDPartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdpartid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDPartId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDPartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdpartname", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDPartName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemeid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDSchemeId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemename", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDSchemeName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableDERsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablederscnt", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDTableDERsCnt()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableDEsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtabledescnt", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDTableDEsCnt()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtableid", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablename", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getTypeValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typevalue", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getTypeValue()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBDTableBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBDTableBase.getJSONValue((Object)pSSysBDTableBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDTableBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDTableBase pSSysBDTableBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDTableBase.getBDTableType() != null) {
            object = pSSysBDTableBase.getBDTableType();
            xmlNode.setAttribute(FIELD_BDTABLETYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableBase.getCodeName() != null) {
            object = pSSysBDTableBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getCreateDate() != null) {
            object = pSSysBDTableBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDTableBase.getCreateMan() != null) {
            object = pSSysBDTableBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getInheritPSDEId() != null) {
            object = pSSysBDTableBase.getInheritPSDEId();
            xmlNode.setAttribute(FIELD_INHERITPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getInheritPSDEName() != null) {
            object = pSSysBDTableBase.getInheritPSDEName();
            xmlNode.setAttribute(FIELD_INHERITPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getLockFlag() != null) {
            object = pSSysBDTableBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableBase.getLogicName() != null) {
            object = pSSysBDTableBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getMemo() != null) {
            object = pSSysBDTableBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getMinorPSDEId() != null) {
            object = pSSysBDTableBase.getMinorPSDEId();
            xmlNode.setAttribute(FIELD_MINORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getMinorPSDEName() != null) {
            object = pSSysBDTableBase.getMinorPSDEName();
            xmlNode.setAttribute(FIELD_MINORPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getModelVer() != null) {
            object = pSSysBDTableBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableBase.getPickupDEFName() != null) {
            object = pSSysBDTableBase.getPickupDEFName();
            xmlNode.setAttribute(FIELD_PICKUPDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSDEId() != null) {
            object = pSSysBDTableBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSDEName() != null) {
            object = pSSysBDTableBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSDERId() != null) {
            object = pSSysBDTableBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSDERName() != null) {
            object = pSSysBDTableBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDColSetsCnt() != null) {
            object = pSSysBDTableBase.getPSSysBDColSetsCnt();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLSETSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableBase.getPSSysBDColumnsCnt() != null) {
            object = pSSysBDTableBase.getPSSysBDColumnsCnt();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLUMNSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableBase.getPSSysBDModuleId() != null) {
            object = pSSysBDTableBase.getPSSysBDModuleId();
            xmlNode.setAttribute(FIELD_PSSYSBDMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDModuleName() != null) {
            object = pSSysBDTableBase.getPSSysBDModuleName();
            xmlNode.setAttribute(FIELD_PSSYSBDMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDPartId() != null) {
            object = pSSysBDTableBase.getPSSysBDPartId();
            xmlNode.setAttribute(FIELD_PSSYSBDPARTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDPartName() != null) {
            object = pSSysBDTableBase.getPSSysBDPartName();
            xmlNode.setAttribute(FIELD_PSSYSBDPARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDSchemeId() != null) {
            object = pSSysBDTableBase.getPSSysBDSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDSchemeName() != null) {
            object = pSSysBDTableBase.getPSSysBDSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableDERsCnt() != null) {
            object = pSSysBDTableBase.getPSSysBDTableDERsCnt();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEDERSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableDEsCnt() != null) {
            object = pSSysBDTableBase.getPSSysBDTableDEsCnt();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEDESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableId() != null) {
            object = pSSysBDTableBase.getPSSysBDTableId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getPSSysBDTableName() != null) {
            object = pSSysBDTableBase.getPSSysBDTableName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getTypeValue() != null) {
            object = pSSysBDTableBase.getTypeValue();
            xmlNode.setAttribute(FIELD_TYPEVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getUpdateDate() != null) {
            object = pSSysBDTableBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDTableBase.getUpdateMan() != null) {
            object = pSSysBDTableBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getUserCat() != null) {
            object = pSSysBDTableBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getUserTag() != null) {
            object = pSSysBDTableBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getUserTag2() != null) {
            object = pSSysBDTableBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getUserTag3() != null) {
            object = pSSysBDTableBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getUserTag4() != null) {
            object = pSSysBDTableBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableBase.getValidFlag() != null) {
            object = pSSysBDTableBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDTableBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDTableBase pSSysBDTableBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDTableBase.isBDTableTypeDirty() && (bl || pSSysBDTableBase.getBDTableType() != null)) {
            iDataObject.set(FIELD_BDTABLETYPE, (Object)pSSysBDTableBase.getBDTableType());
        }
        if (pSSysBDTableBase.isCodeNameDirty() && (bl || pSSysBDTableBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBDTableBase.getCodeName());
        }
        if (pSSysBDTableBase.isCreateDateDirty() && (bl || pSSysBDTableBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDTableBase.getCreateDate());
        }
        if (pSSysBDTableBase.isCreateManDirty() && (bl || pSSysBDTableBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDTableBase.getCreateMan());
        }
        if (pSSysBDTableBase.isInheritPSDEIdDirty() && (bl || pSSysBDTableBase.getInheritPSDEId() != null)) {
            iDataObject.set(FIELD_INHERITPSDEID, (Object)pSSysBDTableBase.getInheritPSDEId());
        }
        if (pSSysBDTableBase.isInheritPSDENameDirty() && (bl || pSSysBDTableBase.getInheritPSDEName() != null)) {
            iDataObject.set(FIELD_INHERITPSDENAME, (Object)pSSysBDTableBase.getInheritPSDEName());
        }
        if (pSSysBDTableBase.isLockFlagDirty() && (bl || pSSysBDTableBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysBDTableBase.getLockFlag());
        }
        if (pSSysBDTableBase.isLogicNameDirty() && (bl || pSSysBDTableBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysBDTableBase.getLogicName());
        }
        if (pSSysBDTableBase.isMemoDirty() && (bl || pSSysBDTableBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDTableBase.getMemo());
        }
        if (pSSysBDTableBase.isMinorPSDEIdDirty() && (bl || pSSysBDTableBase.getMinorPSDEId() != null)) {
            iDataObject.set(FIELD_MINORPSDEID, (Object)pSSysBDTableBase.getMinorPSDEId());
        }
        if (pSSysBDTableBase.isMinorPSDENameDirty() && (bl || pSSysBDTableBase.getMinorPSDEName() != null)) {
            iDataObject.set(FIELD_MINORPSDENAME, (Object)pSSysBDTableBase.getMinorPSDEName());
        }
        if (pSSysBDTableBase.isModelVerDirty() && (bl || pSSysBDTableBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSSysBDTableBase.getModelVer());
        }
        if (pSSysBDTableBase.isPickupDEFNameDirty() && (bl || pSSysBDTableBase.getPickupDEFName() != null)) {
            iDataObject.set(FIELD_PICKUPDEFNAME, (Object)pSSysBDTableBase.getPickupDEFName());
        }
        if (pSSysBDTableBase.isPSDEIdDirty() && (bl || pSSysBDTableBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBDTableBase.getPSDEId());
        }
        if (pSSysBDTableBase.isPSDENameDirty() && (bl || pSSysBDTableBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysBDTableBase.getPSDEName());
        }
        if (pSSysBDTableBase.isPSDERIdDirty() && (bl || pSSysBDTableBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSSysBDTableBase.getPSDERId());
        }
        if (pSSysBDTableBase.isPSDERNameDirty() && (bl || pSSysBDTableBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSSysBDTableBase.getPSDERName());
        }
        if (pSSysBDTableBase.isPSSysBDColSetsCntDirty() && (bl || pSSysBDTableBase.getPSSysBDColSetsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLSETSCNT, (Object)pSSysBDTableBase.getPSSysBDColSetsCnt());
        }
        if (pSSysBDTableBase.isPSSysBDColumnsCntDirty() && (bl || pSSysBDTableBase.getPSSysBDColumnsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLUMNSCNT, (Object)pSSysBDTableBase.getPSSysBDColumnsCnt());
        }
        if (pSSysBDTableBase.isPSSysBDModuleIdDirty() && (bl || pSSysBDTableBase.getPSSysBDModuleId() != null)) {
            iDataObject.set(FIELD_PSSYSBDMODULEID, (Object)pSSysBDTableBase.getPSSysBDModuleId());
        }
        if (pSSysBDTableBase.isPSSysBDModuleNameDirty() && (bl || pSSysBDTableBase.getPSSysBDModuleName() != null)) {
            iDataObject.set(FIELD_PSSYSBDMODULENAME, (Object)pSSysBDTableBase.getPSSysBDModuleName());
        }
        if (pSSysBDTableBase.isPSSysBDPartIdDirty() && (bl || pSSysBDTableBase.getPSSysBDPartId() != null)) {
            iDataObject.set(FIELD_PSSYSBDPARTID, (Object)pSSysBDTableBase.getPSSysBDPartId());
        }
        if (pSSysBDTableBase.isPSSysBDPartNameDirty() && (bl || pSSysBDTableBase.getPSSysBDPartName() != null)) {
            iDataObject.set(FIELD_PSSYSBDPARTNAME, (Object)pSSysBDTableBase.getPSSysBDPartName());
        }
        if (pSSysBDTableBase.isPSSysBDSchemeIdDirty() && (bl || pSSysBDTableBase.getPSSysBDSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMEID, (Object)pSSysBDTableBase.getPSSysBDSchemeId());
        }
        if (pSSysBDTableBase.isPSSysBDSchemeNameDirty() && (bl || pSSysBDTableBase.getPSSysBDSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMENAME, (Object)pSSysBDTableBase.getPSSysBDSchemeName());
        }
        if (pSSysBDTableBase.isPSSysBDTableDERsCntDirty() && (bl || pSSysBDTableBase.getPSSysBDTableDERsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEDERSCNT, (Object)pSSysBDTableBase.getPSSysBDTableDERsCnt());
        }
        if (pSSysBDTableBase.isPSSysBDTableDEsCntDirty() && (bl || pSSysBDTableBase.getPSSysBDTableDEsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEDESCNT, (Object)pSSysBDTableBase.getPSSysBDTableDEsCnt());
        }
        if (pSSysBDTableBase.isPSSysBDTableIdDirty() && (bl || pSSysBDTableBase.getPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEID, (Object)pSSysBDTableBase.getPSSysBDTableId());
        }
        if (pSSysBDTableBase.isPSSysBDTableNameDirty() && (bl || pSSysBDTableBase.getPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLENAME, (Object)pSSysBDTableBase.getPSSysBDTableName());
        }
        if (pSSysBDTableBase.isTypeValueDirty() && (bl || pSSysBDTableBase.getTypeValue() != null)) {
            iDataObject.set(FIELD_TYPEVALUE, (Object)pSSysBDTableBase.getTypeValue());
        }
        if (pSSysBDTableBase.isUpdateDateDirty() && (bl || pSSysBDTableBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDTableBase.getUpdateDate());
        }
        if (pSSysBDTableBase.isUpdateManDirty() && (bl || pSSysBDTableBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDTableBase.getUpdateMan());
        }
        if (pSSysBDTableBase.isUserCatDirty() && (bl || pSSysBDTableBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDTableBase.getUserCat());
        }
        if (pSSysBDTableBase.isUserTagDirty() && (bl || pSSysBDTableBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDTableBase.getUserTag());
        }
        if (pSSysBDTableBase.isUserTag2Dirty() && (bl || pSSysBDTableBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDTableBase.getUserTag2());
        }
        if (pSSysBDTableBase.isUserTag3Dirty() && (bl || pSSysBDTableBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDTableBase.getUserTag3());
        }
        if (pSSysBDTableBase.isUserTag4Dirty() && (bl || pSSysBDTableBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDTableBase.getUserTag4());
        }
        if (pSSysBDTableBase.isValidFlagDirty() && (bl || pSSysBDTableBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBDTableBase.getValidFlag());
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
        return PSSysBDTableBase.remove(this, n);
    }

    private static boolean remove(PSSysBDTableBase pSSysBDTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDTableBase.resetBDTableType();
                return true;
            }
            case 1: {
                pSSysBDTableBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysBDTableBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysBDTableBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysBDTableBase.resetInheritPSDEId();
                return true;
            }
            case 5: {
                pSSysBDTableBase.resetInheritPSDEName();
                return true;
            }
            case 6: {
                pSSysBDTableBase.resetLockFlag();
                return true;
            }
            case 7: {
                pSSysBDTableBase.resetLogicName();
                return true;
            }
            case 8: {
                pSSysBDTableBase.resetMemo();
                return true;
            }
            case 9: {
                pSSysBDTableBase.resetMinorPSDEId();
                return true;
            }
            case 10: {
                pSSysBDTableBase.resetMinorPSDEName();
                return true;
            }
            case 11: {
                pSSysBDTableBase.resetModelVer();
                return true;
            }
            case 12: {
                pSSysBDTableBase.resetPickupDEFName();
                return true;
            }
            case 13: {
                pSSysBDTableBase.resetPSDEId();
                return true;
            }
            case 14: {
                pSSysBDTableBase.resetPSDEName();
                return true;
            }
            case 15: {
                pSSysBDTableBase.resetPSDERId();
                return true;
            }
            case 16: {
                pSSysBDTableBase.resetPSDERName();
                return true;
            }
            case 17: {
                pSSysBDTableBase.resetPSSysBDColSetsCnt();
                return true;
            }
            case 18: {
                pSSysBDTableBase.resetPSSysBDColumnsCnt();
                return true;
            }
            case 19: {
                pSSysBDTableBase.resetPSSysBDModuleId();
                return true;
            }
            case 20: {
                pSSysBDTableBase.resetPSSysBDModuleName();
                return true;
            }
            case 21: {
                pSSysBDTableBase.resetPSSysBDPartId();
                return true;
            }
            case 22: {
                pSSysBDTableBase.resetPSSysBDPartName();
                return true;
            }
            case 23: {
                pSSysBDTableBase.resetPSSysBDSchemeId();
                return true;
            }
            case 24: {
                pSSysBDTableBase.resetPSSysBDSchemeName();
                return true;
            }
            case 25: {
                pSSysBDTableBase.resetPSSysBDTableDERsCnt();
                return true;
            }
            case 26: {
                pSSysBDTableBase.resetPSSysBDTableDEsCnt();
                return true;
            }
            case 27: {
                pSSysBDTableBase.resetPSSysBDTableId();
                return true;
            }
            case 28: {
                pSSysBDTableBase.resetPSSysBDTableName();
                return true;
            }
            case 29: {
                pSSysBDTableBase.resetTypeValue();
                return true;
            }
            case 30: {
                pSSysBDTableBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSSysBDTableBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSSysBDTableBase.resetUserCat();
                return true;
            }
            case 33: {
                pSSysBDTableBase.resetUserTag();
                return true;
            }
            case 34: {
                pSSysBDTableBase.resetUserTag2();
                return true;
            }
            case 35: {
                pSSysBDTableBase.resetUserTag3();
                return true;
            }
            case 36: {
                pSSysBDTableBase.resetUserTag4();
                return true;
            }
            case 37: {
                pSSysBDTableBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getInheritPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInheritPSDE();
        }
        if (this.getInheritPSDEId() == null) {
            return null;
        }
        Integer n = this.objInheritPSDELock;
        synchronized (n) {
            if (this.inheritpsde != null && DataTypeHelper.compare((int)25, (Object)this.getInheritPSDEId(), (Object)this.inheritpsde.getPSDataEntityId()) != 0L) {
                this.inheritpsde = null;
            }
            if (this.inheritpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getInheritPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.inheritpsde = pSDataEntity;
            }
            return this.inheritpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getMinorPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorPSDE();
        }
        if (this.getMinorPSDEId() == null) {
            return null;
        }
        Integer n = this.objMinorPSDELock;
        synchronized (n) {
            if (this.minorpsde != null && DataTypeHelper.compare((int)25, (Object)this.getMinorPSDEId(), (Object)this.minorpsde.getPSDataEntityId()) != 0L) {
                this.minorpsde = null;
            }
            if (this.minorpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getMinorPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.minorpsde = pSDataEntity;
            }
            return this.minorpsde;
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
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet(pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDModule getPSSysBDModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDModule();
        }
        if (this.getPSSysBDModuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDModuleLock;
        synchronized (n) {
            if (this.pssysbdmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDModuleId(), (Object)this.pssysbdmodule.getPSSysBDModuleId()) != 0L) {
                this.pssysbdmodule = null;
            }
            if (this.pssysbdmodule == null) {
                PSSysBDModule pSSysBDModule = new PSSysBDModule();
                pSSysBDModule.setPSSysBDModuleId(this.getPSSysBDModuleId());
                PSSysBDModuleService pSSysBDModuleService = (PSSysBDModuleService)ServiceGlobal.getService(PSSysBDModuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDModuleService.autoGet(pSSysBDModule);
                this.pssysbdmodule = pSSysBDModule;
            }
            return this.pssysbdmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDPart getPSSysBDPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDPart();
        }
        if (this.getPSSysBDPartId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDPartLock;
        synchronized (n) {
            if (this.pssysbdpart != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDPartId(), (Object)this.pssysbdpart.getPSSysBDPartId()) != 0L) {
                this.pssysbdpart = null;
            }
            if (this.pssysbdpart == null) {
                PSSysBDPart pSSysBDPart = new PSSysBDPart();
                pSSysBDPart.setPSSysBDPartId(this.getPSSysBDPartId());
                PSSysBDPartService pSSysBDPartService = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDPartService.autoGet(pSSysBDPart);
                this.pssysbdpart = pSSysBDPart;
            }
            return this.pssysbdpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDScheme();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDSchemeLock;
        synchronized (n) {
            if (this.pssysbdscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDSchemeId(), (Object)this.pssysbdscheme.getPSSysBDSchemeId()) != 0L) {
                this.pssysbdscheme = null;
            }
            if (this.pssysbdscheme == null) {
                PSSysBDScheme pSSysBDScheme = new PSSysBDScheme();
                pSSysBDScheme.setPSSysBDSchemeId(this.getPSSysBDSchemeId());
                PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDSchemeService.autoGet(pSSysBDScheme);
                this.pssysbdscheme = pSSysBDScheme;
            }
            return this.pssysbdscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDColSet> getPSSysBDColSets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColSets();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        PSSysBDColSetService pSSysBDColSetService = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDColSetsLock;
        synchronized (n) {
            if (this.pssysbdcolsets == null) {
                this.pssysbdcolsets = pSSysBDColSetService.selectByPSSysBDTable(this);
            }
            return this.pssysbdcolsets;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDColumn> getPSSysBDColumns() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColumns();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        PSSysBDColumnService pSSysBDColumnService = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDColumnsLock;
        synchronized (n) {
            if (this.pssysbdcolumns == null) {
                this.pssysbdcolumns = pSSysBDColumnService.selectByPSSysBDTable(this);
            }
            return this.pssysbdcolumns;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDTableDER> getPSSysBDTableDERs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDERs();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        PSSysBDTableDERService pSSysBDTableDERService = (PSSysBDTableDERService)ServiceGlobal.getService(PSSysBDTableDERService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDTableDERsLock;
        synchronized (n) {
            if (this.pssysbdtableders == null) {
                this.pssysbdtableders = pSSysBDTableDERService.selectByPSSysBDTable(this);
            }
            return this.pssysbdtableders;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDTableDE> getPSSysBDTableDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDEs();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        PSSysBDTableDEService pSSysBDTableDEService = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDTableDEsLock;
        synchronized (n) {
            if (this.pssysbdtabledes == null) {
                this.pssysbdtabledes = pSSysBDTableDEService.selectByPSSysBDTable(this);
            }
            return this.pssysbdtabledes;
        }
    }

    private PSSysBDTableBase getProxyEntity() {
        return this.proxyPSSysBDTableBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDTableBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDTableBase) {
            this.proxyPSSysBDTableBase = (PSSysBDTableBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BDTABLETYPE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_INHERITPSDEID, 4);
        fieldIndexMap.put(FIELD_INHERITPSDENAME, 5);
        fieldIndexMap.put(FIELD_LOCKFLAG, 6);
        fieldIndexMap.put(FIELD_LOGICNAME, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_MINORPSDEID, 9);
        fieldIndexMap.put(FIELD_MINORPSDENAME, 10);
        fieldIndexMap.put(FIELD_MODELVER, 11);
        fieldIndexMap.put(FIELD_PICKUPDEFNAME, 12);
        fieldIndexMap.put(FIELD_PSDEID, 13);
        fieldIndexMap.put(FIELD_PSDENAME, 14);
        fieldIndexMap.put(FIELD_PSDERID, 15);
        fieldIndexMap.put(FIELD_PSDERNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSBDCOLSETSCNT, 17);
        fieldIndexMap.put(FIELD_PSSYSBDCOLUMNSCNT, 18);
        fieldIndexMap.put(FIELD_PSSYSBDMODULEID, 19);
        fieldIndexMap.put(FIELD_PSSYSBDMODULENAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBDPARTID, 21);
        fieldIndexMap.put(FIELD_PSSYSBDPARTNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMEID, 23);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMENAME, 24);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEDERSCNT, 25);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEDESCNT, 26);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEID, 27);
        fieldIndexMap.put(FIELD_PSSYSBDTABLENAME, 28);
        fieldIndexMap.put(FIELD_TYPEVALUE, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_USERCAT, 32);
        fieldIndexMap.put(FIELD_USERTAG, 33);
        fieldIndexMap.put(FIELD_USERTAG2, 34);
        fieldIndexMap.put(FIELD_USERTAG3, 35);
        fieldIndexMap.put(FIELD_USERTAG4, 36);
        fieldIndexMap.put(FIELD_VALIDFLAG, 37);
    }
}

