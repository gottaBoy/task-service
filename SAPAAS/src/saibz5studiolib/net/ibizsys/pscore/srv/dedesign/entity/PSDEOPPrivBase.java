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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEOPPrivBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEOPPrivBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DERVALIDFLAG = "DERVALIDFLAG";
    public static final String FIELD_DEVALIDFLAG = "DEVALIDFLAG";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORPSDEID = "MAJORPSDEID";
    public static final String FIELD_MAPPSDEOPPRIVID = "MAPPSDEOPPRIVID";
    public static final String FIELD_MAPPSDEOPPRIVNAME = "MAPPSDEOPPRIVNAME";
    public static final String FIELD_MAPSYSUNIRESMODE = "MAPSYSUNIRESMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OPPRIVTYPE = "OPPRIVTYPE";
    public static final String FIELD_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String FIELD_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String FIELD_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DERVALIDFLAG = 2;
    private static final int INDEX_DEVALIDFLAG = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_LOCKFLAG = 5;
    private static final int INDEX_LOGICNAME = 6;
    private static final int INDEX_MAJORPSDEID = 7;
    private static final int INDEX_MAPPSDEOPPRIVID = 8;
    private static final int INDEX_MAPPSDEOPPRIVNAME = 9;
    private static final int INDEX_MAPSYSUNIRESMODE = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_OPPRIVTYPE = 12;
    private static final int INDEX_PSDEFGROUPID = 13;
    private static final int INDEX_PSDEFGROUPNAME = 14;
    private static final int INDEX_PSDEID = 15;
    private static final int INDEX_PSDENAME = 16;
    private static final int INDEX_PSDEOPPRIVID = 17;
    private static final int INDEX_PSDEOPPRIVNAME = 18;
    private static final int INDEX_PSDERID = 19;
    private static final int INDEX_PSDERNAME = 20;
    private static final int INDEX_PSDYNAINSTID = 21;
    private static final int INDEX_PSMODULEID = 22;
    private static final int INDEX_PSMODULENAME = 23;
    private static final int INDEX_PSSYSTEMID = 24;
    private static final int INDEX_PSSYSTEMNAME = 25;
    private static final int INDEX_PSSYSUNIRESID = 26;
    private static final int INDEX_PSSYSUNIRESNAME = 27;
    private static final int INDEX_SYSTEMFLAG = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERCAT = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEOPPrivBase proxyPSDEOPPrivBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dervalidflagDirtyFlag = false;
    private boolean devalidflagDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorpsdeidDirtyFlag = false;
    private boolean mappsdeopprividDirtyFlag = false;
    private boolean mappsdeopprivnameDirtyFlag = false;
    private boolean mapsysuniresmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean opprivtypeDirtyFlag = false;
    private boolean psdefgroupidDirtyFlag = false;
    private boolean psdefgroupnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeopprividDirtyFlag = false;
    private boolean psdeopprivnameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean systemflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dervalidflag")
    private Integer dervalidflag;
    @Column(name="devalidflag")
    private Integer devalidflag;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorpsdeid")
    private String majorpsdeid;
    @Column(name="mappsdeopprivid")
    private String mappsdeopprivid;
    @Column(name="mappsdeopprivname")
    private String mappsdeopprivname;
    @Column(name="mapsysuniresmode")
    private Integer mapsysuniresmode;
    @Column(name="memo")
    private String memo;
    @Column(name="opprivtype")
    private String opprivtype;
    @Column(name="psdefgroupid")
    private String psdefgroupid;
    @Column(name="psdefgroupname")
    private String psdefgroupname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeopprivid")
    private String psdeopprivid;
    @Column(name="psdeopprivname")
    private String psdeopprivname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
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
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="systemflag")
    private Integer systemflag;
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
    private Integer objPSDEFGroupLock = new Integer(1);
    private PSDEFGroup psdefgroup = null;
    private Integer objMapPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv mappsdeoppriv = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;

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

    public void setDERValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERValidFlag(n);
            return;
        }
        this.dervalidflag = n;
        this.dervalidflagDirtyFlag = true;
    }

    public Integer getDERValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERValidFlag();
        }
        return this.dervalidflag;
    }

    public boolean isDERValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERValidFlagDirty();
        }
        return this.dervalidflagDirtyFlag;
    }

    public void resetDERValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERValidFlag();
            return;
        }
        this.dervalidflagDirtyFlag = false;
        this.dervalidflag = null;
    }

    public void setDEValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEValidFlag(n);
            return;
        }
        this.devalidflag = n;
        this.devalidflagDirtyFlag = true;
    }

    public Integer getDEValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEValidFlag();
        }
        return this.devalidflag;
    }

    public boolean isDEValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEValidFlagDirty();
        }
        return this.devalidflagDirtyFlag;
    }

    public void resetDEValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEValidFlag();
            return;
        }
        this.devalidflagDirtyFlag = false;
        this.devalidflag = null;
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

    public void setMajorPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.majorpsdeid = string;
        this.majorpsdeidDirtyFlag = true;
    }

    public String getMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorPSDEId();
        }
        return this.majorpsdeid;
    }

    public boolean isMajorPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorPSDEIdDirty();
        }
        return this.majorpsdeidDirtyFlag;
    }

    public void resetMajorPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorPSDEId();
            return;
        }
        this.majorpsdeidDirtyFlag = false;
        this.majorpsdeid = null;
    }

    public void setMapPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mappsdeopprivid = string;
        this.mappsdeopprividDirtyFlag = true;
    }

    public String getMapPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapPSDEOPPrivId();
        }
        return this.mappsdeopprivid;
    }

    public boolean isMapPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapPSDEOPPrivIdDirty();
        }
        return this.mappsdeopprividDirtyFlag;
    }

    public void resetMapPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapPSDEOPPrivId();
            return;
        }
        this.mappsdeopprividDirtyFlag = false;
        this.mappsdeopprivid = null;
    }

    public void setMapPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mappsdeopprivname = string;
        this.mappsdeopprivnameDirtyFlag = true;
    }

    public String getMapPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapPSDEOPPrivName();
        }
        return this.mappsdeopprivname;
    }

    public boolean isMapPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapPSDEOPPrivNameDirty();
        }
        return this.mappsdeopprivnameDirtyFlag;
    }

    public void resetMapPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapPSDEOPPrivName();
            return;
        }
        this.mappsdeopprivnameDirtyFlag = false;
        this.mappsdeopprivname = null;
    }

    public void setMapSysUniResMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapSysUniResMode(n);
            return;
        }
        this.mapsysuniresmode = n;
        this.mapsysuniresmodeDirtyFlag = true;
    }

    public Integer getMapSysUniResMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapSysUniResMode();
        }
        return this.mapsysuniresmode;
    }

    public boolean isMapSysUniResModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapSysUniResModeDirty();
        }
        return this.mapsysuniresmodeDirtyFlag;
    }

    public void resetMapSysUniResMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapSysUniResMode();
            return;
        }
        this.mapsysuniresmodeDirtyFlag = false;
        this.mapsysuniresmode = null;
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

    public void setOPPrivType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOPPrivType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.opprivtype = string;
        this.opprivtypeDirtyFlag = true;
    }

    public String getOPPrivType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOPPrivType();
        }
        return this.opprivtype;
    }

    public boolean isOPPrivTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOPPrivTypeDirty();
        }
        return this.opprivtypeDirtyFlag;
    }

    public void resetOPPrivType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOPPrivType();
            return;
        }
        this.opprivtypeDirtyFlag = false;
        this.opprivtype = null;
    }

    public void setPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupid = string;
        this.psdefgroupidDirtyFlag = true;
    }

    public String getPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupId();
        }
        return this.psdefgroupid;
    }

    public boolean isPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupIdDirty();
        }
        return this.psdefgroupidDirtyFlag;
    }

    public void resetPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupId();
            return;
        }
        this.psdefgroupidDirtyFlag = false;
        this.psdefgroupid = null;
    }

    public void setPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgroupname = string;
        this.psdefgroupnameDirtyFlag = true;
    }

    public String getPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroupName();
        }
        return this.psdefgroupname;
    }

    public boolean isPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGroupNameDirty();
        }
        return this.psdefgroupnameDirtyFlag;
    }

    public void resetPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGroupName();
            return;
        }
        this.psdefgroupnameDirtyFlag = false;
        this.psdefgroupname = null;
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

    public void setPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeopprivid = string;
        this.psdeopprividDirtyFlag = true;
    }

    public String getPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivId();
        }
        return this.psdeopprivid;
    }

    public boolean isPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivIdDirty();
        }
        return this.psdeopprividDirtyFlag;
    }

    public void resetPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivId();
            return;
        }
        this.psdeopprividDirtyFlag = false;
        this.psdeopprivid = null;
    }

    public void setPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdeopprivname = string;
        this.psdeopprivnameDirtyFlag = true;
    }

    public String getPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEOPPrivName();
        }
        return this.psdeopprivname;
    }

    public boolean isPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEOPPrivNameDirty();
        }
        return this.psdeopprivnameDirtyFlag;
    }

    public void resetPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEOPPrivName();
            return;
        }
        this.psdeopprivnameDirtyFlag = false;
        this.psdeopprivname = null;
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

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
    }

    public void setSystemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemFlag(n);
            return;
        }
        this.systemflag = n;
        this.systemflagDirtyFlag = true;
    }

    public Integer getSystemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemFlag();
        }
        return this.systemflag;
    }

    public boolean isSystemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemFlagDirty();
        }
        return this.systemflagDirtyFlag;
    }

    public void resetSystemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemFlag();
            return;
        }
        this.systemflagDirtyFlag = false;
        this.systemflag = null;
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
        PSDEOPPrivBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEOPPrivBase pSDEOPPrivBase) {
        pSDEOPPrivBase.resetCreateDate();
        pSDEOPPrivBase.resetCreateMan();
        pSDEOPPrivBase.resetDERValidFlag();
        pSDEOPPrivBase.resetDEValidFlag();
        pSDEOPPrivBase.resetDynaModelFlag();
        pSDEOPPrivBase.resetLockFlag();
        pSDEOPPrivBase.resetLogicName();
        pSDEOPPrivBase.resetMajorPSDEId();
        pSDEOPPrivBase.resetMapPSDEOPPrivId();
        pSDEOPPrivBase.resetMapPSDEOPPrivName();
        pSDEOPPrivBase.resetMapSysUniResMode();
        pSDEOPPrivBase.resetMemo();
        pSDEOPPrivBase.resetOPPrivType();
        pSDEOPPrivBase.resetPSDEFGroupId();
        pSDEOPPrivBase.resetPSDEFGroupName();
        pSDEOPPrivBase.resetPSDEId();
        pSDEOPPrivBase.resetPSDEName();
        pSDEOPPrivBase.resetPSDEOPPrivId();
        pSDEOPPrivBase.resetPSDEOPPrivName();
        pSDEOPPrivBase.resetPSDERId();
        pSDEOPPrivBase.resetPSDERName();
        pSDEOPPrivBase.resetPSDynaInstId();
        pSDEOPPrivBase.resetPSModuleId();
        pSDEOPPrivBase.resetPSModuleName();
        pSDEOPPrivBase.resetPSSystemId();
        pSDEOPPrivBase.resetPSSystemName();
        pSDEOPPrivBase.resetPSSysUniResId();
        pSDEOPPrivBase.resetPSSysUniResName();
        pSDEOPPrivBase.resetSystemFlag();
        pSDEOPPrivBase.resetUpdateDate();
        pSDEOPPrivBase.resetUpdateMan();
        pSDEOPPrivBase.resetUserCat();
        pSDEOPPrivBase.resetUserTag();
        pSDEOPPrivBase.resetUserTag2();
        pSDEOPPrivBase.resetUserTag3();
        pSDEOPPrivBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDERValidFlagDirty()) {
            hashMap.put(FIELD_DERVALIDFLAG, this.getDERValidFlag());
        }
        if (!bl || this.isDEValidFlagDirty()) {
            hashMap.put(FIELD_DEVALIDFLAG, this.getDEValidFlag());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMajorPSDEIdDirty()) {
            hashMap.put(FIELD_MAJORPSDEID, this.getMajorPSDEId());
        }
        if (!bl || this.isMapPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_MAPPSDEOPPRIVID, this.getMapPSDEOPPrivId());
        }
        if (!bl || this.isMapPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_MAPPSDEOPPRIVNAME, this.getMapPSDEOPPrivName());
        }
        if (!bl || this.isMapSysUniResModeDirty()) {
            hashMap.put(FIELD_MAPSYSUNIRESMODE, this.getMapSysUniResMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOPPrivTypeDirty()) {
            hashMap.put(FIELD_OPPRIVTYPE, this.getOPPrivType());
        }
        if (!bl || this.isPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_PSDEFGROUPID, this.getPSDEFGroupId());
        }
        if (!bl || this.isPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_PSDEFGROUPNAME, this.getPSDEFGroupName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVID, this.getPSDEOPPrivId());
        }
        if (!bl || this.isPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_PSDEOPPRIVNAME, this.getPSDEOPPrivName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
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
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isSystemFlagDirty()) {
            hashMap.put(FIELD_SYSTEMFLAG, this.getSystemFlag());
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
        return PSDEOPPrivBase.get(this, n);
    }

    private static Object get(PSDEOPPrivBase pSDEOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEOPPrivBase.getCreateDate();
            }
            case 1: {
                return pSDEOPPrivBase.getCreateMan();
            }
            case 2: {
                return pSDEOPPrivBase.getDERValidFlag();
            }
            case 3: {
                return pSDEOPPrivBase.getDEValidFlag();
            }
            case 4: {
                return pSDEOPPrivBase.getDynaModelFlag();
            }
            case 5: {
                return pSDEOPPrivBase.getLockFlag();
            }
            case 6: {
                return pSDEOPPrivBase.getLogicName();
            }
            case 7: {
                return pSDEOPPrivBase.getMajorPSDEId();
            }
            case 8: {
                return pSDEOPPrivBase.getMapPSDEOPPrivId();
            }
            case 9: {
                return pSDEOPPrivBase.getMapPSDEOPPrivName();
            }
            case 10: {
                return pSDEOPPrivBase.getMapSysUniResMode();
            }
            case 11: {
                return pSDEOPPrivBase.getMemo();
            }
            case 12: {
                return pSDEOPPrivBase.getOPPrivType();
            }
            case 13: {
                return pSDEOPPrivBase.getPSDEFGroupId();
            }
            case 14: {
                return pSDEOPPrivBase.getPSDEFGroupName();
            }
            case 15: {
                return pSDEOPPrivBase.getPSDEId();
            }
            case 16: {
                return pSDEOPPrivBase.getPSDEName();
            }
            case 17: {
                return pSDEOPPrivBase.getPSDEOPPrivId();
            }
            case 18: {
                return pSDEOPPrivBase.getPSDEOPPrivName();
            }
            case 19: {
                return pSDEOPPrivBase.getPSDERId();
            }
            case 20: {
                return pSDEOPPrivBase.getPSDERName();
            }
            case 21: {
                return pSDEOPPrivBase.getPSDynaInstId();
            }
            case 22: {
                return pSDEOPPrivBase.getPSModuleId();
            }
            case 23: {
                return pSDEOPPrivBase.getPSModuleName();
            }
            case 24: {
                return pSDEOPPrivBase.getPSSystemId();
            }
            case 25: {
                return pSDEOPPrivBase.getPSSystemName();
            }
            case 26: {
                return pSDEOPPrivBase.getPSSysUniResId();
            }
            case 27: {
                return pSDEOPPrivBase.getPSSysUniResName();
            }
            case 28: {
                return pSDEOPPrivBase.getSystemFlag();
            }
            case 29: {
                return pSDEOPPrivBase.getUpdateDate();
            }
            case 30: {
                return pSDEOPPrivBase.getUpdateMan();
            }
            case 31: {
                return pSDEOPPrivBase.getUserCat();
            }
            case 32: {
                return pSDEOPPrivBase.getUserTag();
            }
            case 33: {
                return pSDEOPPrivBase.getUserTag2();
            }
            case 34: {
                return pSDEOPPrivBase.getUserTag3();
            }
            case 35: {
                return pSDEOPPrivBase.getUserTag4();
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
        PSDEOPPrivBase.set(this, n, object);
    }

    private static void set(PSDEOPPrivBase pSDEOPPrivBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEOPPrivBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEOPPrivBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEOPPrivBase.setDERValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEOPPrivBase.setDEValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEOPPrivBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEOPPrivBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEOPPrivBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEOPPrivBase.setMajorPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEOPPrivBase.setMapPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEOPPrivBase.setMapPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEOPPrivBase.setMapSysUniResMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEOPPrivBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEOPPrivBase.setOPPrivType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEOPPrivBase.setPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEOPPrivBase.setPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEOPPrivBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEOPPrivBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEOPPrivBase.setPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEOPPrivBase.setPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEOPPrivBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEOPPrivBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEOPPrivBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEOPPrivBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEOPPrivBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEOPPrivBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEOPPrivBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEOPPrivBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEOPPrivBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEOPPrivBase.setSystemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEOPPrivBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSDEOPPrivBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEOPPrivBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEOPPrivBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEOPPrivBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEOPPrivBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEOPPrivBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEOPPrivBase.isNull(this, n);
    }

    private static boolean isNull(PSDEOPPrivBase pSDEOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEOPPrivBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEOPPrivBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEOPPrivBase.getDERValidFlag() == null;
            }
            case 3: {
                return pSDEOPPrivBase.getDEValidFlag() == null;
            }
            case 4: {
                return pSDEOPPrivBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSDEOPPrivBase.getLockFlag() == null;
            }
            case 6: {
                return pSDEOPPrivBase.getLogicName() == null;
            }
            case 7: {
                return pSDEOPPrivBase.getMajorPSDEId() == null;
            }
            case 8: {
                return pSDEOPPrivBase.getMapPSDEOPPrivId() == null;
            }
            case 9: {
                return pSDEOPPrivBase.getMapPSDEOPPrivName() == null;
            }
            case 10: {
                return pSDEOPPrivBase.getMapSysUniResMode() == null;
            }
            case 11: {
                return pSDEOPPrivBase.getMemo() == null;
            }
            case 12: {
                return pSDEOPPrivBase.getOPPrivType() == null;
            }
            case 13: {
                return pSDEOPPrivBase.getPSDEFGroupId() == null;
            }
            case 14: {
                return pSDEOPPrivBase.getPSDEFGroupName() == null;
            }
            case 15: {
                return pSDEOPPrivBase.getPSDEId() == null;
            }
            case 16: {
                return pSDEOPPrivBase.getPSDEName() == null;
            }
            case 17: {
                return pSDEOPPrivBase.getPSDEOPPrivId() == null;
            }
            case 18: {
                return pSDEOPPrivBase.getPSDEOPPrivName() == null;
            }
            case 19: {
                return pSDEOPPrivBase.getPSDERId() == null;
            }
            case 20: {
                return pSDEOPPrivBase.getPSDERName() == null;
            }
            case 21: {
                return pSDEOPPrivBase.getPSDynaInstId() == null;
            }
            case 22: {
                return pSDEOPPrivBase.getPSModuleId() == null;
            }
            case 23: {
                return pSDEOPPrivBase.getPSModuleName() == null;
            }
            case 24: {
                return pSDEOPPrivBase.getPSSystemId() == null;
            }
            case 25: {
                return pSDEOPPrivBase.getPSSystemName() == null;
            }
            case 26: {
                return pSDEOPPrivBase.getPSSysUniResId() == null;
            }
            case 27: {
                return pSDEOPPrivBase.getPSSysUniResName() == null;
            }
            case 28: {
                return pSDEOPPrivBase.getSystemFlag() == null;
            }
            case 29: {
                return pSDEOPPrivBase.getUpdateDate() == null;
            }
            case 30: {
                return pSDEOPPrivBase.getUpdateMan() == null;
            }
            case 31: {
                return pSDEOPPrivBase.getUserCat() == null;
            }
            case 32: {
                return pSDEOPPrivBase.getUserTag() == null;
            }
            case 33: {
                return pSDEOPPrivBase.getUserTag2() == null;
            }
            case 34: {
                return pSDEOPPrivBase.getUserTag3() == null;
            }
            case 35: {
                return pSDEOPPrivBase.getUserTag4() == null;
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
        return PSDEOPPrivBase.contains(this, n);
    }

    private static boolean contains(PSDEOPPrivBase pSDEOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEOPPrivBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEOPPrivBase.isCreateManDirty();
            }
            case 2: {
                return pSDEOPPrivBase.isDERValidFlagDirty();
            }
            case 3: {
                return pSDEOPPrivBase.isDEValidFlagDirty();
            }
            case 4: {
                return pSDEOPPrivBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSDEOPPrivBase.isLockFlagDirty();
            }
            case 6: {
                return pSDEOPPrivBase.isLogicNameDirty();
            }
            case 7: {
                return pSDEOPPrivBase.isMajorPSDEIdDirty();
            }
            case 8: {
                return pSDEOPPrivBase.isMapPSDEOPPrivIdDirty();
            }
            case 9: {
                return pSDEOPPrivBase.isMapPSDEOPPrivNameDirty();
            }
            case 10: {
                return pSDEOPPrivBase.isMapSysUniResModeDirty();
            }
            case 11: {
                return pSDEOPPrivBase.isMemoDirty();
            }
            case 12: {
                return pSDEOPPrivBase.isOPPrivTypeDirty();
            }
            case 13: {
                return pSDEOPPrivBase.isPSDEFGroupIdDirty();
            }
            case 14: {
                return pSDEOPPrivBase.isPSDEFGroupNameDirty();
            }
            case 15: {
                return pSDEOPPrivBase.isPSDEIdDirty();
            }
            case 16: {
                return pSDEOPPrivBase.isPSDENameDirty();
            }
            case 17: {
                return pSDEOPPrivBase.isPSDEOPPrivIdDirty();
            }
            case 18: {
                return pSDEOPPrivBase.isPSDEOPPrivNameDirty();
            }
            case 19: {
                return pSDEOPPrivBase.isPSDERIdDirty();
            }
            case 20: {
                return pSDEOPPrivBase.isPSDERNameDirty();
            }
            case 21: {
                return pSDEOPPrivBase.isPSDynaInstIdDirty();
            }
            case 22: {
                return pSDEOPPrivBase.isPSModuleIdDirty();
            }
            case 23: {
                return pSDEOPPrivBase.isPSModuleNameDirty();
            }
            case 24: {
                return pSDEOPPrivBase.isPSSystemIdDirty();
            }
            case 25: {
                return pSDEOPPrivBase.isPSSystemNameDirty();
            }
            case 26: {
                return pSDEOPPrivBase.isPSSysUniResIdDirty();
            }
            case 27: {
                return pSDEOPPrivBase.isPSSysUniResNameDirty();
            }
            case 28: {
                return pSDEOPPrivBase.isSystemFlagDirty();
            }
            case 29: {
                return pSDEOPPrivBase.isUpdateDateDirty();
            }
            case 30: {
                return pSDEOPPrivBase.isUpdateManDirty();
            }
            case 31: {
                return pSDEOPPrivBase.isUserCatDirty();
            }
            case 32: {
                return pSDEOPPrivBase.isUserTagDirty();
            }
            case 33: {
                return pSDEOPPrivBase.isUserTag2Dirty();
            }
            case 34: {
                return pSDEOPPrivBase.isUserTag3Dirty();
            }
            case 35: {
                return pSDEOPPrivBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEOPPrivBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEOPPrivBase pSDEOPPrivBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEOPPrivBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getDERValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dervalidflag", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getDERValidFlag()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getDEValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devalidflag", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getDEValidFlag()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getMajorPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorpsdeid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getMajorPSDEId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getMapPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mappsdeopprivid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getMapPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getMapPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mappsdeopprivname", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getMapPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getMapSysUniResMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapsysuniresmode", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getMapSysUniResMode()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getOPPrivType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"opprivtype", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getOPPrivType()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgroupname", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeopprivname", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getSystemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systemflag", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getSystemFlag()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEOPPrivBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEOPPrivBase.getJSONValue((Object)pSDEOPPrivBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEOPPrivBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEOPPrivBase pSDEOPPrivBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEOPPrivBase.getCreateDate() != null) {
            object = pSDEOPPrivBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getCreateMan() != null) {
            object = pSDEOPPrivBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getDERValidFlag() != null) {
            object = pSDEOPPrivBase.getDERValidFlag();
            xmlNode.setAttribute(FIELD_DERVALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getDEValidFlag() != null) {
            object = pSDEOPPrivBase.getDEValidFlag();
            xmlNode.setAttribute(FIELD_DEVALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getDynaModelFlag() != null) {
            object = pSDEOPPrivBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getLockFlag() != null) {
            object = pSDEOPPrivBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getLogicName() != null) {
            object = pSDEOPPrivBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getMajorPSDEId() != null) {
            object = pSDEOPPrivBase.getMajorPSDEId();
            xmlNode.setAttribute(FIELD_MAJORPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getMapPSDEOPPrivId() != null) {
            object = pSDEOPPrivBase.getMapPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_MAPPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getMapPSDEOPPrivName() != null) {
            object = pSDEOPPrivBase.getMapPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_MAPPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getMapSysUniResMode() != null) {
            object = pSDEOPPrivBase.getMapSysUniResMode();
            xmlNode.setAttribute(FIELD_MAPSYSUNIRESMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getMemo() != null) {
            object = pSDEOPPrivBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getOPPrivType() != null) {
            object = pSDEOPPrivBase.getOPPrivType();
            xmlNode.setAttribute(FIELD_OPPRIVTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDEFGroupId() != null) {
            object = pSDEOPPrivBase.getPSDEFGroupId();
            xmlNode.setAttribute(FIELD_PSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDEFGroupName() != null) {
            object = pSDEOPPrivBase.getPSDEFGroupName();
            xmlNode.setAttribute(FIELD_PSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDEId() != null) {
            object = pSDEOPPrivBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDEName() != null) {
            object = pSDEOPPrivBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDEOPPrivId() != null) {
            object = pSDEOPPrivBase.getPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDEOPPrivName() != null) {
            object = pSDEOPPrivBase.getPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_PSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDERId() != null) {
            object = pSDEOPPrivBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDERName() != null) {
            object = pSDEOPPrivBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSDynaInstId() != null) {
            object = pSDEOPPrivBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSModuleId() != null) {
            object = pSDEOPPrivBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSModuleName() != null) {
            object = pSDEOPPrivBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSSystemId() != null) {
            object = pSDEOPPrivBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSSystemName() != null) {
            object = pSDEOPPrivBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSSysUniResId() != null) {
            object = pSDEOPPrivBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getPSSysUniResName() != null) {
            object = pSDEOPPrivBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getSystemFlag() != null) {
            object = pSDEOPPrivBase.getSystemFlag();
            xmlNode.setAttribute(FIELD_SYSTEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getUpdateDate() != null) {
            object = pSDEOPPrivBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEOPPrivBase.getUpdateMan() != null) {
            object = pSDEOPPrivBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getUserCat() != null) {
            object = pSDEOPPrivBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getUserTag() != null) {
            object = pSDEOPPrivBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getUserTag2() != null) {
            object = pSDEOPPrivBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getUserTag3() != null) {
            object = pSDEOPPrivBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEOPPrivBase.getUserTag4() != null) {
            object = pSDEOPPrivBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEOPPrivBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEOPPrivBase pSDEOPPrivBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEOPPrivBase.isCreateDateDirty() && (bl || pSDEOPPrivBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEOPPrivBase.getCreateDate());
        }
        if (pSDEOPPrivBase.isCreateManDirty() && (bl || pSDEOPPrivBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEOPPrivBase.getCreateMan());
        }
        if (pSDEOPPrivBase.isDERValidFlagDirty() && (bl || pSDEOPPrivBase.getDERValidFlag() != null)) {
            iDataObject.set(FIELD_DERVALIDFLAG, (Object)pSDEOPPrivBase.getDERValidFlag());
        }
        if (pSDEOPPrivBase.isDEValidFlagDirty() && (bl || pSDEOPPrivBase.getDEValidFlag() != null)) {
            iDataObject.set(FIELD_DEVALIDFLAG, (Object)pSDEOPPrivBase.getDEValidFlag());
        }
        if (pSDEOPPrivBase.isDynaModelFlagDirty() && (bl || pSDEOPPrivBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEOPPrivBase.getDynaModelFlag());
        }
        if (pSDEOPPrivBase.isLockFlagDirty() && (bl || pSDEOPPrivBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEOPPrivBase.getLockFlag());
        }
        if (pSDEOPPrivBase.isLogicNameDirty() && (bl || pSDEOPPrivBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEOPPrivBase.getLogicName());
        }
        if (pSDEOPPrivBase.isMajorPSDEIdDirty() && (bl || pSDEOPPrivBase.getMajorPSDEId() != null)) {
            iDataObject.set(FIELD_MAJORPSDEID, (Object)pSDEOPPrivBase.getMajorPSDEId());
        }
        if (pSDEOPPrivBase.isMapPSDEOPPrivIdDirty() && (bl || pSDEOPPrivBase.getMapPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_MAPPSDEOPPRIVID, (Object)pSDEOPPrivBase.getMapPSDEOPPrivId());
        }
        if (pSDEOPPrivBase.isMapPSDEOPPrivNameDirty() && (bl || pSDEOPPrivBase.getMapPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_MAPPSDEOPPRIVNAME, (Object)pSDEOPPrivBase.getMapPSDEOPPrivName());
        }
        if (pSDEOPPrivBase.isMapSysUniResModeDirty() && (bl || pSDEOPPrivBase.getMapSysUniResMode() != null)) {
            iDataObject.set(FIELD_MAPSYSUNIRESMODE, (Object)pSDEOPPrivBase.getMapSysUniResMode());
        }
        if (pSDEOPPrivBase.isMemoDirty() && (bl || pSDEOPPrivBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEOPPrivBase.getMemo());
        }
        if (pSDEOPPrivBase.isOPPrivTypeDirty() && (bl || pSDEOPPrivBase.getOPPrivType() != null)) {
            iDataObject.set(FIELD_OPPRIVTYPE, (Object)pSDEOPPrivBase.getOPPrivType());
        }
        if (pSDEOPPrivBase.isPSDEFGroupIdDirty() && (bl || pSDEOPPrivBase.getPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPID, (Object)pSDEOPPrivBase.getPSDEFGroupId());
        }
        if (pSDEOPPrivBase.isPSDEFGroupNameDirty() && (bl || pSDEOPPrivBase.getPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_PSDEFGROUPNAME, (Object)pSDEOPPrivBase.getPSDEFGroupName());
        }
        if (pSDEOPPrivBase.isPSDEIdDirty() && (bl || pSDEOPPrivBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEOPPrivBase.getPSDEId());
        }
        if (pSDEOPPrivBase.isPSDENameDirty() && (bl || pSDEOPPrivBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEOPPrivBase.getPSDEName());
        }
        if (pSDEOPPrivBase.isPSDEOPPrivIdDirty() && (bl || pSDEOPPrivBase.getPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVID, (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        }
        if (pSDEOPPrivBase.isPSDEOPPrivNameDirty() && (bl || pSDEOPPrivBase.getPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_PSDEOPPRIVNAME, (Object)pSDEOPPrivBase.getPSDEOPPrivName());
        }
        if (pSDEOPPrivBase.isPSDERIdDirty() && (bl || pSDEOPPrivBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDEOPPrivBase.getPSDERId());
        }
        if (pSDEOPPrivBase.isPSDERNameDirty() && (bl || pSDEOPPrivBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDEOPPrivBase.getPSDERName());
        }
        if (pSDEOPPrivBase.isPSDynaInstIdDirty() && (bl || pSDEOPPrivBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEOPPrivBase.getPSDynaInstId());
        }
        if (pSDEOPPrivBase.isPSModuleIdDirty() && (bl || pSDEOPPrivBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEOPPrivBase.getPSModuleId());
        }
        if (pSDEOPPrivBase.isPSModuleNameDirty() && (bl || pSDEOPPrivBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEOPPrivBase.getPSModuleName());
        }
        if (pSDEOPPrivBase.isPSSystemIdDirty() && (bl || pSDEOPPrivBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEOPPrivBase.getPSSystemId());
        }
        if (pSDEOPPrivBase.isPSSystemNameDirty() && (bl || pSDEOPPrivBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEOPPrivBase.getPSSystemName());
        }
        if (pSDEOPPrivBase.isPSSysUniResIdDirty() && (bl || pSDEOPPrivBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDEOPPrivBase.getPSSysUniResId());
        }
        if (pSDEOPPrivBase.isPSSysUniResNameDirty() && (bl || pSDEOPPrivBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDEOPPrivBase.getPSSysUniResName());
        }
        if (pSDEOPPrivBase.isSystemFlagDirty() && (bl || pSDEOPPrivBase.getSystemFlag() != null)) {
            iDataObject.set(FIELD_SYSTEMFLAG, (Object)pSDEOPPrivBase.getSystemFlag());
        }
        if (pSDEOPPrivBase.isUpdateDateDirty() && (bl || pSDEOPPrivBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEOPPrivBase.getUpdateDate());
        }
        if (pSDEOPPrivBase.isUpdateManDirty() && (bl || pSDEOPPrivBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEOPPrivBase.getUpdateMan());
        }
        if (pSDEOPPrivBase.isUserCatDirty() && (bl || pSDEOPPrivBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEOPPrivBase.getUserCat());
        }
        if (pSDEOPPrivBase.isUserTagDirty() && (bl || pSDEOPPrivBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEOPPrivBase.getUserTag());
        }
        if (pSDEOPPrivBase.isUserTag2Dirty() && (bl || pSDEOPPrivBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEOPPrivBase.getUserTag2());
        }
        if (pSDEOPPrivBase.isUserTag3Dirty() && (bl || pSDEOPPrivBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEOPPrivBase.getUserTag3());
        }
        if (pSDEOPPrivBase.isUserTag4Dirty() && (bl || pSDEOPPrivBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEOPPrivBase.getUserTag4());
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
        return PSDEOPPrivBase.remove(this, n);
    }

    private static boolean remove(PSDEOPPrivBase pSDEOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEOPPrivBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEOPPrivBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEOPPrivBase.resetDERValidFlag();
                return true;
            }
            case 3: {
                pSDEOPPrivBase.resetDEValidFlag();
                return true;
            }
            case 4: {
                pSDEOPPrivBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSDEOPPrivBase.resetLockFlag();
                return true;
            }
            case 6: {
                pSDEOPPrivBase.resetLogicName();
                return true;
            }
            case 7: {
                pSDEOPPrivBase.resetMajorPSDEId();
                return true;
            }
            case 8: {
                pSDEOPPrivBase.resetMapPSDEOPPrivId();
                return true;
            }
            case 9: {
                pSDEOPPrivBase.resetMapPSDEOPPrivName();
                return true;
            }
            case 10: {
                pSDEOPPrivBase.resetMapSysUniResMode();
                return true;
            }
            case 11: {
                pSDEOPPrivBase.resetMemo();
                return true;
            }
            case 12: {
                pSDEOPPrivBase.resetOPPrivType();
                return true;
            }
            case 13: {
                pSDEOPPrivBase.resetPSDEFGroupId();
                return true;
            }
            case 14: {
                pSDEOPPrivBase.resetPSDEFGroupName();
                return true;
            }
            case 15: {
                pSDEOPPrivBase.resetPSDEId();
                return true;
            }
            case 16: {
                pSDEOPPrivBase.resetPSDEName();
                return true;
            }
            case 17: {
                pSDEOPPrivBase.resetPSDEOPPrivId();
                return true;
            }
            case 18: {
                pSDEOPPrivBase.resetPSDEOPPrivName();
                return true;
            }
            case 19: {
                pSDEOPPrivBase.resetPSDERId();
                return true;
            }
            case 20: {
                pSDEOPPrivBase.resetPSDERName();
                return true;
            }
            case 21: {
                pSDEOPPrivBase.resetPSDynaInstId();
                return true;
            }
            case 22: {
                pSDEOPPrivBase.resetPSModuleId();
                return true;
            }
            case 23: {
                pSDEOPPrivBase.resetPSModuleName();
                return true;
            }
            case 24: {
                pSDEOPPrivBase.resetPSSystemId();
                return true;
            }
            case 25: {
                pSDEOPPrivBase.resetPSSystemName();
                return true;
            }
            case 26: {
                pSDEOPPrivBase.resetPSSysUniResId();
                return true;
            }
            case 27: {
                pSDEOPPrivBase.resetPSSysUniResName();
                return true;
            }
            case 28: {
                pSDEOPPrivBase.resetSystemFlag();
                return true;
            }
            case 29: {
                pSDEOPPrivBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSDEOPPrivBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSDEOPPrivBase.resetUserCat();
                return true;
            }
            case 32: {
                pSDEOPPrivBase.resetUserTag();
                return true;
            }
            case 33: {
                pSDEOPPrivBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSDEOPPrivBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSDEOPPrivBase.resetUserTag4();
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
    public PSDEFGroup getPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGroup();
        }
        if (this.getPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEFGroupLock;
        synchronized (n) {
            if (this.psdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFGroupId(), (Object)this.psdefgroup.getPSDEFGroupId()) != 0L) {
                this.psdefgroup = null;
            }
            if (this.psdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet((IEntity)pSDEFGroup);
                this.psdefgroup = pSDEFGroup;
            }
            return this.psdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getMapPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapPSDEOPPriv();
        }
        if (this.getMapPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objMapPSDEOPPrivLock;
        synchronized (n) {
            if (this.mappsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getMapPSDEOPPrivId(), (Object)this.mappsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.mappsdeoppriv = null;
            }
            if (this.mappsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getMapPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet((IEntity)pSDEOPPriv);
                this.mappsdeoppriv = pSDEOPPriv;
            }
            return this.mappsdeoppriv;
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
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
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
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    private PSDEOPPrivBase getProxyEntity() {
        return this.proxyPSDEOPPrivBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEOPPrivBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEOPPrivBase) {
            this.proxyPSDEOPPrivBase = (PSDEOPPrivBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DERVALIDFLAG, 2);
        fieldIndexMap.put(FIELD_DEVALIDFLAG, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_LOCKFLAG, 5);
        fieldIndexMap.put(FIELD_LOGICNAME, 6);
        fieldIndexMap.put(FIELD_MAJORPSDEID, 7);
        fieldIndexMap.put(FIELD_MAPPSDEOPPRIVID, 8);
        fieldIndexMap.put(FIELD_MAPPSDEOPPRIVNAME, 9);
        fieldIndexMap.put(FIELD_MAPSYSUNIRESMODE, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_OPPRIVTYPE, 12);
        fieldIndexMap.put(FIELD_PSDEFGROUPID, 13);
        fieldIndexMap.put(FIELD_PSDEFGROUPNAME, 14);
        fieldIndexMap.put(FIELD_PSDEID, 15);
        fieldIndexMap.put(FIELD_PSDENAME, 16);
        fieldIndexMap.put(FIELD_PSDEOPPRIVID, 17);
        fieldIndexMap.put(FIELD_PSDEOPPRIVNAME, 18);
        fieldIndexMap.put(FIELD_PSDERID, 19);
        fieldIndexMap.put(FIELD_PSDERNAME, 20);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 21);
        fieldIndexMap.put(FIELD_PSMODULEID, 22);
        fieldIndexMap.put(FIELD_PSMODULENAME, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 26);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 27);
        fieldIndexMap.put(FIELD_SYSTEMFLAG, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERCAT, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
    }
}

