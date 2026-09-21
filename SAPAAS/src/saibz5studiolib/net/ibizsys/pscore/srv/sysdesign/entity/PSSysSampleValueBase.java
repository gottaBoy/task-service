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
import net.ibizsys.pscore.srv.config.entity.PSSampleValue;
import net.ibizsys.pscore.srv.config.service.PSSampleValueService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSampleValueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSampleValueBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NULLVALUE = "NULLVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSAMPLEVALUEID = "PSSAMPLEVALUEID";
    public static final String FIELD_PSSAMPLEVALUENAME = "PSSAMPLEVALUENAME";
    public static final String FIELD_PSSYSSAMPLEVALUEID = "PSSYSSAMPLEVALUEID";
    public static final String FIELD_PSSYSSAMPLEVALUENAME = "PSSYSSAMPLEVALUENAME";
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
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUELIST = "VALUELIST";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_LOCKFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_NULLVALUE = 7;
    private static final int INDEX_PSMODULEID = 8;
    private static final int INDEX_PSMODULENAME = 9;
    private static final int INDEX_PSSAMPLEVALUEID = 10;
    private static final int INDEX_PSSAMPLEVALUENAME = 11;
    private static final int INDEX_PSSYSSAMPLEVALUEID = 12;
    private static final int INDEX_PSSYSSAMPLEVALUENAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSTEMNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final int INDEX_VALUE = 24;
    private static final int INDEX_VALUELIST = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSampleValueBase proxyPSSysSampleValueBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nullvalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssamplevalueidDirtyFlag = false;
    private boolean pssamplevaluenameDirtyFlag = false;
    private boolean pssyssamplevalueidDirtyFlag = false;
    private boolean pssyssamplevaluenameDirtyFlag = false;
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
    private boolean valueDirtyFlag = false;
    private boolean valuelistDirtyFlag = false;
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
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="nullvalue")
    private Integer nullvalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssamplevalueid")
    private String pssamplevalueid;
    @Column(name="pssamplevaluename")
    private String pssamplevaluename;
    @Column(name="pssyssamplevalueid")
    private String pssyssamplevalueid;
    @Column(name="pssyssamplevaluename")
    private String pssyssamplevaluename;
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
    @Column(name="value")
    private String value;
    @Column(name="valuelist")
    private String valuelist;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSampleValueLock = new Integer(1);
    private PSSampleValue pssamplevalue = null;
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

    public void setNullValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNullValue(n);
            return;
        }
        this.nullvalue = n;
        this.nullvalueDirtyFlag = true;
    }

    public Integer getNullValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNullValue();
        }
        return this.nullvalue;
    }

    public boolean isNullValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNullValueDirty();
        }
        return this.nullvalueDirtyFlag;
    }

    public void resetNullValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNullValue();
            return;
        }
        this.nullvalueDirtyFlag = false;
        this.nullvalue = null;
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

    public void setPSSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssamplevalueid = string;
        this.pssamplevalueidDirtyFlag = true;
    }

    public String getPSSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSampleValueId();
        }
        return this.pssamplevalueid;
    }

    public boolean isPSSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSampleValueIdDirty();
        }
        return this.pssamplevalueidDirtyFlag;
    }

    public void resetPSSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSampleValueId();
            return;
        }
        this.pssamplevalueidDirtyFlag = false;
        this.pssamplevalueid = null;
    }

    public void setPSSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssamplevaluename = string;
        this.pssamplevaluenameDirtyFlag = true;
    }

    public String getPSSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSampleValueName();
        }
        return this.pssamplevaluename;
    }

    public boolean isPSSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSampleValueNameDirty();
        }
        return this.pssamplevaluenameDirtyFlag;
    }

    public void resetPSSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSampleValueName();
            return;
        }
        this.pssamplevaluenameDirtyFlag = false;
        this.pssamplevaluename = null;
    }

    public void setPSSysSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssamplevalueid = string;
        this.pssyssamplevalueidDirtyFlag = true;
    }

    public String getPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValueId();
        }
        return this.pssyssamplevalueid;
    }

    public boolean isPSSysSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSampleValueIdDirty();
        }
        return this.pssyssamplevalueidDirtyFlag;
    }

    public void resetPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSampleValueId();
            return;
        }
        this.pssyssamplevalueidDirtyFlag = false;
        this.pssyssamplevalueid = null;
    }

    public void setPSSysSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssamplevaluename = string;
        this.pssyssamplevaluenameDirtyFlag = true;
    }

    public String getPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValueName();
        }
        return this.pssyssamplevaluename;
    }

    public boolean isPSSysSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSampleValueNameDirty();
        }
        return this.pssyssamplevaluenameDirtyFlag;
    }

    public void resetPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSampleValueName();
            return;
        }
        this.pssyssamplevaluenameDirtyFlag = false;
        this.pssyssamplevaluename = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    public void setValueList(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueList(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuelist = string;
        this.valuelistDirtyFlag = true;
    }

    public String getValueList() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueList();
        }
        return this.valuelist;
    }

    public boolean isValueListDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueListDirty();
        }
        return this.valuelistDirtyFlag;
    }

    public void resetValueList() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueList();
            return;
        }
        this.valuelistDirtyFlag = false;
        this.valuelist = null;
    }

    protected void onReset() {
        PSSysSampleValueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSampleValueBase pSSysSampleValueBase) {
        pSSysSampleValueBase.resetCodeName();
        pSSysSampleValueBase.resetCreateDate();
        pSSysSampleValueBase.resetCreateMan();
        pSSysSampleValueBase.resetCustomCode();
        pSSysSampleValueBase.resetCustomMode();
        pSSysSampleValueBase.resetLockFlag();
        pSSysSampleValueBase.resetMemo();
        pSSysSampleValueBase.resetNullValue();
        pSSysSampleValueBase.resetPSModuleId();
        pSSysSampleValueBase.resetPSModuleName();
        pSSysSampleValueBase.resetPSSampleValueId();
        pSSysSampleValueBase.resetPSSampleValueName();
        pSSysSampleValueBase.resetPSSysSampleValueId();
        pSSysSampleValueBase.resetPSSysSampleValueName();
        pSSysSampleValueBase.resetPSSystemId();
        pSSysSampleValueBase.resetPSSystemName();
        pSSysSampleValueBase.resetUpdateDate();
        pSSysSampleValueBase.resetUpdateMan();
        pSSysSampleValueBase.resetUserCat();
        pSSysSampleValueBase.resetUserTag();
        pSSysSampleValueBase.resetUserTag2();
        pSSysSampleValueBase.resetUserTag3();
        pSSysSampleValueBase.resetUserTag4();
        pSSysSampleValueBase.resetValidFlag();
        pSSysSampleValueBase.resetValue();
        pSSysSampleValueBase.resetValueList();
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
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNullValueDirty()) {
            hashMap.put(FIELD_NULLVALUE, this.getNullValue());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSampleValueIdDirty()) {
            hashMap.put(FIELD_PSSAMPLEVALUEID, this.getPSSampleValueId());
        }
        if (!bl || this.isPSSampleValueNameDirty()) {
            hashMap.put(FIELD_PSSAMPLEVALUENAME, this.getPSSampleValueName());
        }
        if (!bl || this.isPSSysSampleValueIdDirty()) {
            hashMap.put(FIELD_PSSYSSAMPLEVALUEID, this.getPSSysSampleValueId());
        }
        if (!bl || this.isPSSysSampleValueNameDirty()) {
            hashMap.put(FIELD_PSSYSSAMPLEVALUENAME, this.getPSSysSampleValueName());
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
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
        }
        if (!bl || this.isValueListDirty()) {
            hashMap.put(FIELD_VALUELIST, this.getValueList());
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
        return PSSysSampleValueBase.get(this, n);
    }

    private static Object get(PSSysSampleValueBase pSSysSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSampleValueBase.getCodeName();
            }
            case 1: {
                return pSSysSampleValueBase.getCreateDate();
            }
            case 2: {
                return pSSysSampleValueBase.getCreateMan();
            }
            case 3: {
                return pSSysSampleValueBase.getCustomCode();
            }
            case 4: {
                return pSSysSampleValueBase.getCustomMode();
            }
            case 5: {
                return pSSysSampleValueBase.getLockFlag();
            }
            case 6: {
                return pSSysSampleValueBase.getMemo();
            }
            case 7: {
                return pSSysSampleValueBase.getNullValue();
            }
            case 8: {
                return pSSysSampleValueBase.getPSModuleId();
            }
            case 9: {
                return pSSysSampleValueBase.getPSModuleName();
            }
            case 10: {
                return pSSysSampleValueBase.getPSSampleValueId();
            }
            case 11: {
                return pSSysSampleValueBase.getPSSampleValueName();
            }
            case 12: {
                return pSSysSampleValueBase.getPSSysSampleValueId();
            }
            case 13: {
                return pSSysSampleValueBase.getPSSysSampleValueName();
            }
            case 14: {
                return pSSysSampleValueBase.getPSSystemId();
            }
            case 15: {
                return pSSysSampleValueBase.getPSSystemName();
            }
            case 16: {
                return pSSysSampleValueBase.getUpdateDate();
            }
            case 17: {
                return pSSysSampleValueBase.getUpdateMan();
            }
            case 18: {
                return pSSysSampleValueBase.getUserCat();
            }
            case 19: {
                return pSSysSampleValueBase.getUserTag();
            }
            case 20: {
                return pSSysSampleValueBase.getUserTag2();
            }
            case 21: {
                return pSSysSampleValueBase.getUserTag3();
            }
            case 22: {
                return pSSysSampleValueBase.getUserTag4();
            }
            case 23: {
                return pSSysSampleValueBase.getValidFlag();
            }
            case 24: {
                return pSSysSampleValueBase.getValue();
            }
            case 25: {
                return pSSysSampleValueBase.getValueList();
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
        PSSysSampleValueBase.set(this, n, object);
    }

    private static void set(PSSysSampleValueBase pSSysSampleValueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSampleValueBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSampleValueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSampleValueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSampleValueBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSampleValueBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysSampleValueBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysSampleValueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSampleValueBase.setNullValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysSampleValueBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSampleValueBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSampleValueBase.setPSSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSampleValueBase.setPSSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSampleValueBase.setPSSysSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSampleValueBase.setPSSysSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSampleValueBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSampleValueBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSampleValueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysSampleValueBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSampleValueBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSampleValueBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSampleValueBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSampleValueBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSampleValueBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSampleValueBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSysSampleValueBase.setValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSampleValueBase.setValueList(DataObject.getStringValue((Object)object));
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
        return PSSysSampleValueBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSampleValueBase pSSysSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSampleValueBase.getCodeName() == null;
            }
            case 1: {
                return pSSysSampleValueBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSampleValueBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSampleValueBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysSampleValueBase.getCustomMode() == null;
            }
            case 5: {
                return pSSysSampleValueBase.getLockFlag() == null;
            }
            case 6: {
                return pSSysSampleValueBase.getMemo() == null;
            }
            case 7: {
                return pSSysSampleValueBase.getNullValue() == null;
            }
            case 8: {
                return pSSysSampleValueBase.getPSModuleId() == null;
            }
            case 9: {
                return pSSysSampleValueBase.getPSModuleName() == null;
            }
            case 10: {
                return pSSysSampleValueBase.getPSSampleValueId() == null;
            }
            case 11: {
                return pSSysSampleValueBase.getPSSampleValueName() == null;
            }
            case 12: {
                return pSSysSampleValueBase.getPSSysSampleValueId() == null;
            }
            case 13: {
                return pSSysSampleValueBase.getPSSysSampleValueName() == null;
            }
            case 14: {
                return pSSysSampleValueBase.getPSSystemId() == null;
            }
            case 15: {
                return pSSysSampleValueBase.getPSSystemName() == null;
            }
            case 16: {
                return pSSysSampleValueBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysSampleValueBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysSampleValueBase.getUserCat() == null;
            }
            case 19: {
                return pSSysSampleValueBase.getUserTag() == null;
            }
            case 20: {
                return pSSysSampleValueBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysSampleValueBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysSampleValueBase.getUserTag4() == null;
            }
            case 23: {
                return pSSysSampleValueBase.getValidFlag() == null;
            }
            case 24: {
                return pSSysSampleValueBase.getValue() == null;
            }
            case 25: {
                return pSSysSampleValueBase.getValueList() == null;
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
        return PSSysSampleValueBase.contains(this, n);
    }

    private static boolean contains(PSSysSampleValueBase pSSysSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSampleValueBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysSampleValueBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSampleValueBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSampleValueBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysSampleValueBase.isCustomModeDirty();
            }
            case 5: {
                return pSSysSampleValueBase.isLockFlagDirty();
            }
            case 6: {
                return pSSysSampleValueBase.isMemoDirty();
            }
            case 7: {
                return pSSysSampleValueBase.isNullValueDirty();
            }
            case 8: {
                return pSSysSampleValueBase.isPSModuleIdDirty();
            }
            case 9: {
                return pSSysSampleValueBase.isPSModuleNameDirty();
            }
            case 10: {
                return pSSysSampleValueBase.isPSSampleValueIdDirty();
            }
            case 11: {
                return pSSysSampleValueBase.isPSSampleValueNameDirty();
            }
            case 12: {
                return pSSysSampleValueBase.isPSSysSampleValueIdDirty();
            }
            case 13: {
                return pSSysSampleValueBase.isPSSysSampleValueNameDirty();
            }
            case 14: {
                return pSSysSampleValueBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSSysSampleValueBase.isPSSystemNameDirty();
            }
            case 16: {
                return pSSysSampleValueBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysSampleValueBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysSampleValueBase.isUserCatDirty();
            }
            case 19: {
                return pSSysSampleValueBase.isUserTagDirty();
            }
            case 20: {
                return pSSysSampleValueBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysSampleValueBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysSampleValueBase.isUserTag4Dirty();
            }
            case 23: {
                return pSSysSampleValueBase.isValidFlagDirty();
            }
            case 24: {
                return pSSysSampleValueBase.isValueDirty();
            }
            case 25: {
                return pSSysSampleValueBase.isValueListDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSampleValueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSampleValueBase pSSysSampleValueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSampleValueBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getNullValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nullvalue", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getNullValue()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssamplevalueid", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSSampleValueId()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssamplevaluename", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSSampleValueName()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSSysSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssamplevalueid", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSSysSampleValueId()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSSysSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssamplevaluename", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSSysSampleValueName()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getValue()), (boolean)false);
        }
        if (bl || pSSysSampleValueBase.getValueList() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuelist", (Object)PSSysSampleValueBase.getJSONValue((Object)pSSysSampleValueBase.getValueList()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSampleValueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSampleValueBase pSSysSampleValueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSampleValueBase.getCodeName() != null) {
            object = pSSysSampleValueBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getCreateDate() != null) {
            object = pSSysSampleValueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSampleValueBase.getCreateMan() != null) {
            object = pSSysSampleValueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getCustomCode() != null) {
            object = pSSysSampleValueBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getCustomMode() != null) {
            object = pSSysSampleValueBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSampleValueBase.getLockFlag() != null) {
            object = pSSysSampleValueBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSampleValueBase.getMemo() != null) {
            object = pSSysSampleValueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getNullValue() != null) {
            object = pSSysSampleValueBase.getNullValue();
            xmlNode.setAttribute(FIELD_NULLVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSampleValueBase.getPSModuleId() != null) {
            object = pSSysSampleValueBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getPSModuleName() != null) {
            object = pSSysSampleValueBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getPSSampleValueId() != null) {
            object = pSSysSampleValueBase.getPSSampleValueId();
            xmlNode.setAttribute(FIELD_PSSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getPSSampleValueName() != null) {
            object = pSSysSampleValueBase.getPSSampleValueName();
            xmlNode.setAttribute(FIELD_PSSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getPSSysSampleValueId() != null) {
            object = pSSysSampleValueBase.getPSSysSampleValueId();
            xmlNode.setAttribute(FIELD_PSSYSSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getPSSysSampleValueName() != null) {
            object = pSSysSampleValueBase.getPSSysSampleValueName();
            xmlNode.setAttribute(FIELD_PSSYSSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getPSSystemId() != null) {
            object = pSSysSampleValueBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getPSSystemName() != null) {
            object = pSSysSampleValueBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getUpdateDate() != null) {
            object = pSSysSampleValueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSampleValueBase.getUpdateMan() != null) {
            object = pSSysSampleValueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getUserCat() != null) {
            object = pSSysSampleValueBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getUserTag() != null) {
            object = pSSysSampleValueBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getUserTag2() != null) {
            object = pSSysSampleValueBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getUserTag3() != null) {
            object = pSSysSampleValueBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getUserTag4() != null) {
            object = pSSysSampleValueBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getValidFlag() != null) {
            object = pSSysSampleValueBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSampleValueBase.getValue() != null) {
            object = pSSysSampleValueBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSampleValueBase.getValueList() != null) {
            object = pSSysSampleValueBase.getValueList();
            xmlNode.setAttribute(FIELD_VALUELIST, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSampleValueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSampleValueBase pSSysSampleValueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSampleValueBase.isCodeNameDirty() && (bl || pSSysSampleValueBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSampleValueBase.getCodeName());
        }
        if (pSSysSampleValueBase.isCreateDateDirty() && (bl || pSSysSampleValueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSampleValueBase.getCreateDate());
        }
        if (pSSysSampleValueBase.isCreateManDirty() && (bl || pSSysSampleValueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSampleValueBase.getCreateMan());
        }
        if (pSSysSampleValueBase.isCustomCodeDirty() && (bl || pSSysSampleValueBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysSampleValueBase.getCustomCode());
        }
        if (pSSysSampleValueBase.isCustomModeDirty() && (bl || pSSysSampleValueBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysSampleValueBase.getCustomMode());
        }
        if (pSSysSampleValueBase.isLockFlagDirty() && (bl || pSSysSampleValueBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysSampleValueBase.getLockFlag());
        }
        if (pSSysSampleValueBase.isMemoDirty() && (bl || pSSysSampleValueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSampleValueBase.getMemo());
        }
        if (pSSysSampleValueBase.isNullValueDirty() && (bl || pSSysSampleValueBase.getNullValue() != null)) {
            iDataObject.set(FIELD_NULLVALUE, (Object)pSSysSampleValueBase.getNullValue());
        }
        if (pSSysSampleValueBase.isPSModuleIdDirty() && (bl || pSSysSampleValueBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysSampleValueBase.getPSModuleId());
        }
        if (pSSysSampleValueBase.isPSModuleNameDirty() && (bl || pSSysSampleValueBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysSampleValueBase.getPSModuleName());
        }
        if (pSSysSampleValueBase.isPSSampleValueIdDirty() && (bl || pSSysSampleValueBase.getPSSampleValueId() != null)) {
            iDataObject.set(FIELD_PSSAMPLEVALUEID, (Object)pSSysSampleValueBase.getPSSampleValueId());
        }
        if (pSSysSampleValueBase.isPSSampleValueNameDirty() && (bl || pSSysSampleValueBase.getPSSampleValueName() != null)) {
            iDataObject.set(FIELD_PSSAMPLEVALUENAME, (Object)pSSysSampleValueBase.getPSSampleValueName());
        }
        if (pSSysSampleValueBase.isPSSysSampleValueIdDirty() && (bl || pSSysSampleValueBase.getPSSysSampleValueId() != null)) {
            iDataObject.set(FIELD_PSSYSSAMPLEVALUEID, (Object)pSSysSampleValueBase.getPSSysSampleValueId());
        }
        if (pSSysSampleValueBase.isPSSysSampleValueNameDirty() && (bl || pSSysSampleValueBase.getPSSysSampleValueName() != null)) {
            iDataObject.set(FIELD_PSSYSSAMPLEVALUENAME, (Object)pSSysSampleValueBase.getPSSysSampleValueName());
        }
        if (pSSysSampleValueBase.isPSSystemIdDirty() && (bl || pSSysSampleValueBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSampleValueBase.getPSSystemId());
        }
        if (pSSysSampleValueBase.isPSSystemNameDirty() && (bl || pSSysSampleValueBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSampleValueBase.getPSSystemName());
        }
        if (pSSysSampleValueBase.isUpdateDateDirty() && (bl || pSSysSampleValueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSampleValueBase.getUpdateDate());
        }
        if (pSSysSampleValueBase.isUpdateManDirty() && (bl || pSSysSampleValueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSampleValueBase.getUpdateMan());
        }
        if (pSSysSampleValueBase.isUserCatDirty() && (bl || pSSysSampleValueBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSampleValueBase.getUserCat());
        }
        if (pSSysSampleValueBase.isUserTagDirty() && (bl || pSSysSampleValueBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSampleValueBase.getUserTag());
        }
        if (pSSysSampleValueBase.isUserTag2Dirty() && (bl || pSSysSampleValueBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSampleValueBase.getUserTag2());
        }
        if (pSSysSampleValueBase.isUserTag3Dirty() && (bl || pSSysSampleValueBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSampleValueBase.getUserTag3());
        }
        if (pSSysSampleValueBase.isUserTag4Dirty() && (bl || pSSysSampleValueBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSampleValueBase.getUserTag4());
        }
        if (pSSysSampleValueBase.isValidFlagDirty() && (bl || pSSysSampleValueBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSampleValueBase.getValidFlag());
        }
        if (pSSysSampleValueBase.isValueDirty() && (bl || pSSysSampleValueBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSSysSampleValueBase.getValue());
        }
        if (pSSysSampleValueBase.isValueListDirty() && (bl || pSSysSampleValueBase.getValueList() != null)) {
            iDataObject.set(FIELD_VALUELIST, (Object)pSSysSampleValueBase.getValueList());
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
        return PSSysSampleValueBase.remove(this, n);
    }

    private static boolean remove(PSSysSampleValueBase pSSysSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSampleValueBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysSampleValueBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSampleValueBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSampleValueBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysSampleValueBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSSysSampleValueBase.resetLockFlag();
                return true;
            }
            case 6: {
                pSSysSampleValueBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysSampleValueBase.resetNullValue();
                return true;
            }
            case 8: {
                pSSysSampleValueBase.resetPSModuleId();
                return true;
            }
            case 9: {
                pSSysSampleValueBase.resetPSModuleName();
                return true;
            }
            case 10: {
                pSSysSampleValueBase.resetPSSampleValueId();
                return true;
            }
            case 11: {
                pSSysSampleValueBase.resetPSSampleValueName();
                return true;
            }
            case 12: {
                pSSysSampleValueBase.resetPSSysSampleValueId();
                return true;
            }
            case 13: {
                pSSysSampleValueBase.resetPSSysSampleValueName();
                return true;
            }
            case 14: {
                pSSysSampleValueBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSSysSampleValueBase.resetPSSystemName();
                return true;
            }
            case 16: {
                pSSysSampleValueBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysSampleValueBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysSampleValueBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysSampleValueBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysSampleValueBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysSampleValueBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysSampleValueBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSSysSampleValueBase.resetValidFlag();
                return true;
            }
            case 24: {
                pSSysSampleValueBase.resetValue();
                return true;
            }
            case 25: {
                pSSysSampleValueBase.resetValueList();
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSampleValue getPSSampleValue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSampleValue();
        }
        if (this.getPSSampleValueId() == null) {
            return null;
        }
        Integer n = this.objPSSampleValueLock;
        synchronized (n) {
            if (this.pssamplevalue != null && DataTypeHelper.compare((int)25, (Object)this.getPSSampleValueId(), (Object)this.pssamplevalue.getPSSampleValueId()) != 0L) {
                this.pssamplevalue = null;
            }
            if (this.pssamplevalue == null) {
                PSSampleValue pSSampleValue = new PSSampleValue();
                pSSampleValue.setPSSampleValueId(this.getPSSampleValueId());
                PSSampleValueService pSSampleValueService = (PSSampleValueService)ServiceGlobal.getService(PSSampleValueService.class, (SessionFactory)this.getSessionFactory());
                pSSampleValueService.autoGet((IEntity)pSSampleValue);
                this.pssamplevalue = pSSampleValue;
            }
            return this.pssamplevalue;
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

    private PSSysSampleValueBase getProxyEntity() {
        return this.proxyPSSysSampleValueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSampleValueBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSampleValueBase) {
            this.proxyPSSysSampleValueBase = (PSSysSampleValueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_LOCKFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_NULLVALUE, 7);
        fieldIndexMap.put(FIELD_PSMODULEID, 8);
        fieldIndexMap.put(FIELD_PSMODULENAME, 9);
        fieldIndexMap.put(FIELD_PSSAMPLEVALUEID, 10);
        fieldIndexMap.put(FIELD_PSSAMPLEVALUENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSSAMPLEVALUEID, 12);
        fieldIndexMap.put(FIELD_PSSYSSAMPLEVALUENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
        fieldIndexMap.put(FIELD_VALUE, 24);
        fieldIndexMap.put(FIELD_VALUELIST, 25);
    }
}

