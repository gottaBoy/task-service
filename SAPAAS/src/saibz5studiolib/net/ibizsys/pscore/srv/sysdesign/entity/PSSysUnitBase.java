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
import net.ibizsys.pscore.srv.config.entity.PSUnit;
import net.ibizsys.pscore.srv.config.service.PSUnitService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUnitBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUnitBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEPSLANGUAGERESID = "NAMEPSLANGUAGERESID";
    public static final String FIELD_NAMEPSLANGUAGERESNAME = "NAMEPSLANGUAGERESNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNITID = "PSSYSUNITID";
    public static final String FIELD_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String FIELD_PSUNITID = "PSUNITID";
    public static final String FIELD_PSUNITNAME = "PSUNITNAME";
    public static final String FIELD_UNITTAG = "UNITTAG";
    public static final String FIELD_UNITTAG2 = "UNITTAG2";
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
    private static final int INDEX_NAMEPSLANGUAGERESID = 5;
    private static final int INDEX_NAMEPSLANGUAGERESNAME = 6;
    private static final int INDEX_PSMODULEID = 7;
    private static final int INDEX_PSMODULENAME = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_PSSYSTEMNAME = 10;
    private static final int INDEX_PSSYSUNITID = 11;
    private static final int INDEX_PSSYSUNITNAME = 12;
    private static final int INDEX_PSUNITID = 13;
    private static final int INDEX_PSUNITNAME = 14;
    private static final int INDEX_UNITTAG = 15;
    private static final int INDEX_UNITTAG2 = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUnitBase proxyPSSysUnitBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namepslanguageresidDirtyFlag = false;
    private boolean namepslanguageresnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysunitidDirtyFlag = false;
    private boolean pssysunitnameDirtyFlag = false;
    private boolean psunitidDirtyFlag = false;
    private boolean psunitnameDirtyFlag = false;
    private boolean unittagDirtyFlag = false;
    private boolean unittag2DirtyFlag = false;
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
    @Column(name="namepslanguageresid")
    private String namepslanguageresid;
    @Column(name="namepslanguageresname")
    private String namepslanguageresname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysunitid")
    private String pssysunitid;
    @Column(name="pssysunitname")
    private String pssysunitname;
    @Column(name="psunitid")
    private String psunitid;
    @Column(name="psunitname")
    private String psunitname;
    @Column(name="unittag")
    private String unittag;
    @Column(name="unittag2")
    private String unittag2;
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
    private Integer objNamePSLanguageResLock = new Integer(1);
    private PSLanguageRes namepslanguageres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSUnitLock = new Integer(1);
    private PSUnit psunit = null;

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

    public void setNamePSLanguageResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanguageResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanguageresid = string;
        this.namepslanguageresidDirtyFlag = true;
    }

    public String getNamePSLanguageResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanguageResId();
        }
        return this.namepslanguageresid;
    }

    public boolean isNamePSLanguageResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanguageResIdDirty();
        }
        return this.namepslanguageresidDirtyFlag;
    }

    public void resetNamePSLanguageResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanguageResId();
            return;
        }
        this.namepslanguageresidDirtyFlag = false;
        this.namepslanguageresid = null;
    }

    public void setNamePSLanguageResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanguageResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanguageresname = string;
        this.namepslanguageresnameDirtyFlag = true;
    }

    public String getNamePSLanguageResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanguageResName();
        }
        return this.namepslanguageresname;
    }

    public boolean isNamePSLanguageResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanguageResNameDirty();
        }
        return this.namepslanguageresnameDirtyFlag;
    }

    public void resetNamePSLanguageResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanguageResName();
            return;
        }
        this.namepslanguageresnameDirtyFlag = false;
        this.namepslanguageresname = null;
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

    public void setPSSysUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitid = string;
        this.pssysunitidDirtyFlag = true;
    }

    public String getPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitId();
        }
        return this.pssysunitid;
    }

    public boolean isPSSysUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitIdDirty();
        }
        return this.pssysunitidDirtyFlag;
    }

    public void resetPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitId();
            return;
        }
        this.pssysunitidDirtyFlag = false;
        this.pssysunitid = null;
    }

    public void setPSSysUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitname = string;
        this.pssysunitnameDirtyFlag = true;
    }

    public String getPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitName();
        }
        return this.pssysunitname;
    }

    public boolean isPSSysUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitNameDirty();
        }
        return this.pssysunitnameDirtyFlag;
    }

    public void resetPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitName();
            return;
        }
        this.pssysunitnameDirtyFlag = false;
        this.pssysunitname = null;
    }

    public void setPSUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitid = string;
        this.psunitidDirtyFlag = true;
    }

    public String getPSUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitId();
        }
        return this.psunitid;
    }

    public boolean isPSUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitIdDirty();
        }
        return this.psunitidDirtyFlag;
    }

    public void resetPSUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitId();
            return;
        }
        this.psunitidDirtyFlag = false;
        this.psunitid = null;
    }

    public void setPSUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitname = string;
        this.psunitnameDirtyFlag = true;
    }

    public String getPSUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitName();
        }
        return this.psunitname;
    }

    public boolean isPSUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitNameDirty();
        }
        return this.psunitnameDirtyFlag;
    }

    public void resetPSUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitName();
            return;
        }
        this.psunitnameDirtyFlag = false;
        this.psunitname = null;
    }

    public void setUnitTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnitTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unittag = string;
        this.unittagDirtyFlag = true;
    }

    public String getUnitTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnitTag();
        }
        return this.unittag;
    }

    public boolean isUnitTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnitTagDirty();
        }
        return this.unittagDirtyFlag;
    }

    public void resetUnitTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnitTag();
            return;
        }
        this.unittagDirtyFlag = false;
        this.unittag = null;
    }

    public void setUnitTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnitTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unittag2 = string;
        this.unittag2DirtyFlag = true;
    }

    public String getUnitTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnitTag2();
        }
        return this.unittag2;
    }

    public boolean isUnitTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnitTag2Dirty();
        }
        return this.unittag2DirtyFlag;
    }

    public void resetUnitTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnitTag2();
            return;
        }
        this.unittag2DirtyFlag = false;
        this.unittag2 = null;
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
        PSSysUnitBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUnitBase pSSysUnitBase) {
        pSSysUnitBase.resetCodeName();
        pSSysUnitBase.resetCreateDate();
        pSSysUnitBase.resetCreateMan();
        pSSysUnitBase.resetLockFlag();
        pSSysUnitBase.resetMemo();
        pSSysUnitBase.resetNamePSLanguageResId();
        pSSysUnitBase.resetNamePSLanguageResName();
        pSSysUnitBase.resetPSModuleId();
        pSSysUnitBase.resetPSModuleName();
        pSSysUnitBase.resetPSSystemId();
        pSSysUnitBase.resetPSSystemName();
        pSSysUnitBase.resetPSSysUnitId();
        pSSysUnitBase.resetPSSysUnitName();
        pSSysUnitBase.resetPSUnitId();
        pSSysUnitBase.resetPSUnitName();
        pSSysUnitBase.resetUnitTag();
        pSSysUnitBase.resetUnitTag2();
        pSSysUnitBase.resetUpdateDate();
        pSSysUnitBase.resetUpdateMan();
        pSSysUnitBase.resetUserCat();
        pSSysUnitBase.resetUserTag();
        pSSysUnitBase.resetUserTag2();
        pSSysUnitBase.resetUserTag3();
        pSSysUnitBase.resetUserTag4();
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
        if (!bl || this.isNamePSLanguageResIdDirty()) {
            hashMap.put(FIELD_NAMEPSLANGUAGERESID, this.getNamePSLanguageResId());
        }
        if (!bl || this.isNamePSLanguageResNameDirty()) {
            hashMap.put(FIELD_NAMEPSLANGUAGERESNAME, this.getNamePSLanguageResName());
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
        if (!bl || this.isPSSysUnitIdDirty()) {
            hashMap.put(FIELD_PSSYSUNITID, this.getPSSysUnitId());
        }
        if (!bl || this.isPSSysUnitNameDirty()) {
            hashMap.put(FIELD_PSSYSUNITNAME, this.getPSSysUnitName());
        }
        if (!bl || this.isPSUnitIdDirty()) {
            hashMap.put(FIELD_PSUNITID, this.getPSUnitId());
        }
        if (!bl || this.isPSUnitNameDirty()) {
            hashMap.put(FIELD_PSUNITNAME, this.getPSUnitName());
        }
        if (!bl || this.isUnitTagDirty()) {
            hashMap.put(FIELD_UNITTAG, this.getUnitTag());
        }
        if (!bl || this.isUnitTag2Dirty()) {
            hashMap.put(FIELD_UNITTAG2, this.getUnitTag2());
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
        return PSSysUnitBase.get(this, n);
    }

    private static Object get(PSSysUnitBase pSSysUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUnitBase.getCodeName();
            }
            case 1: {
                return pSSysUnitBase.getCreateDate();
            }
            case 2: {
                return pSSysUnitBase.getCreateMan();
            }
            case 3: {
                return pSSysUnitBase.getLockFlag();
            }
            case 4: {
                return pSSysUnitBase.getMemo();
            }
            case 5: {
                return pSSysUnitBase.getNamePSLanguageResId();
            }
            case 6: {
                return pSSysUnitBase.getNamePSLanguageResName();
            }
            case 7: {
                return pSSysUnitBase.getPSModuleId();
            }
            case 8: {
                return pSSysUnitBase.getPSModuleName();
            }
            case 9: {
                return pSSysUnitBase.getPSSystemId();
            }
            case 10: {
                return pSSysUnitBase.getPSSystemName();
            }
            case 11: {
                return pSSysUnitBase.getPSSysUnitId();
            }
            case 12: {
                return pSSysUnitBase.getPSSysUnitName();
            }
            case 13: {
                return pSSysUnitBase.getPSUnitId();
            }
            case 14: {
                return pSSysUnitBase.getPSUnitName();
            }
            case 15: {
                return pSSysUnitBase.getUnitTag();
            }
            case 16: {
                return pSSysUnitBase.getUnitTag2();
            }
            case 17: {
                return pSSysUnitBase.getUpdateDate();
            }
            case 18: {
                return pSSysUnitBase.getUpdateMan();
            }
            case 19: {
                return pSSysUnitBase.getUserCat();
            }
            case 20: {
                return pSSysUnitBase.getUserTag();
            }
            case 21: {
                return pSSysUnitBase.getUserTag2();
            }
            case 22: {
                return pSSysUnitBase.getUserTag3();
            }
            case 23: {
                return pSSysUnitBase.getUserTag4();
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
        PSSysUnitBase.set(this, n, object);
    }

    private static void set(PSSysUnitBase pSSysUnitBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUnitBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUnitBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysUnitBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUnitBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysUnitBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUnitBase.setNamePSLanguageResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUnitBase.setNamePSLanguageResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUnitBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUnitBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUnitBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUnitBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUnitBase.setPSSysUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUnitBase.setPSSysUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUnitBase.setPSUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUnitBase.setPSUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUnitBase.setUnitTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUnitBase.setUnitTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUnitBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSysUnitBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUnitBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUnitBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUnitBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUnitBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysUnitBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysUnitBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUnitBase pSSysUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUnitBase.getCodeName() == null;
            }
            case 1: {
                return pSSysUnitBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysUnitBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysUnitBase.getLockFlag() == null;
            }
            case 4: {
                return pSSysUnitBase.getMemo() == null;
            }
            case 5: {
                return pSSysUnitBase.getNamePSLanguageResId() == null;
            }
            case 6: {
                return pSSysUnitBase.getNamePSLanguageResName() == null;
            }
            case 7: {
                return pSSysUnitBase.getPSModuleId() == null;
            }
            case 8: {
                return pSSysUnitBase.getPSModuleName() == null;
            }
            case 9: {
                return pSSysUnitBase.getPSSystemId() == null;
            }
            case 10: {
                return pSSysUnitBase.getPSSystemName() == null;
            }
            case 11: {
                return pSSysUnitBase.getPSSysUnitId() == null;
            }
            case 12: {
                return pSSysUnitBase.getPSSysUnitName() == null;
            }
            case 13: {
                return pSSysUnitBase.getPSUnitId() == null;
            }
            case 14: {
                return pSSysUnitBase.getPSUnitName() == null;
            }
            case 15: {
                return pSSysUnitBase.getUnitTag() == null;
            }
            case 16: {
                return pSSysUnitBase.getUnitTag2() == null;
            }
            case 17: {
                return pSSysUnitBase.getUpdateDate() == null;
            }
            case 18: {
                return pSSysUnitBase.getUpdateMan() == null;
            }
            case 19: {
                return pSSysUnitBase.getUserCat() == null;
            }
            case 20: {
                return pSSysUnitBase.getUserTag() == null;
            }
            case 21: {
                return pSSysUnitBase.getUserTag2() == null;
            }
            case 22: {
                return pSSysUnitBase.getUserTag3() == null;
            }
            case 23: {
                return pSSysUnitBase.getUserTag4() == null;
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
        return PSSysUnitBase.contains(this, n);
    }

    private static boolean contains(PSSysUnitBase pSSysUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUnitBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysUnitBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysUnitBase.isCreateManDirty();
            }
            case 3: {
                return pSSysUnitBase.isLockFlagDirty();
            }
            case 4: {
                return pSSysUnitBase.isMemoDirty();
            }
            case 5: {
                return pSSysUnitBase.isNamePSLanguageResIdDirty();
            }
            case 6: {
                return pSSysUnitBase.isNamePSLanguageResNameDirty();
            }
            case 7: {
                return pSSysUnitBase.isPSModuleIdDirty();
            }
            case 8: {
                return pSSysUnitBase.isPSModuleNameDirty();
            }
            case 9: {
                return pSSysUnitBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSSysUnitBase.isPSSystemNameDirty();
            }
            case 11: {
                return pSSysUnitBase.isPSSysUnitIdDirty();
            }
            case 12: {
                return pSSysUnitBase.isPSSysUnitNameDirty();
            }
            case 13: {
                return pSSysUnitBase.isPSUnitIdDirty();
            }
            case 14: {
                return pSSysUnitBase.isPSUnitNameDirty();
            }
            case 15: {
                return pSSysUnitBase.isUnitTagDirty();
            }
            case 16: {
                return pSSysUnitBase.isUnitTag2Dirty();
            }
            case 17: {
                return pSSysUnitBase.isUpdateDateDirty();
            }
            case 18: {
                return pSSysUnitBase.isUpdateManDirty();
            }
            case 19: {
                return pSSysUnitBase.isUserCatDirty();
            }
            case 20: {
                return pSSysUnitBase.isUserTagDirty();
            }
            case 21: {
                return pSSysUnitBase.isUserTag2Dirty();
            }
            case 22: {
                return pSSysUnitBase.isUserTag3Dirty();
            }
            case 23: {
                return pSSysUnitBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUnitBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUnitBase pSSysUnitBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUnitBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getNamePSLanguageResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanguageresid", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getNamePSLanguageResId()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getNamePSLanguageResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanguageresname", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getNamePSLanguageResName()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSSysUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitid", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSSysUnitId()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSSysUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitname", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSSysUnitName()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitid", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSUnitId()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getPSUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitname", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getPSUnitName()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUnitTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unittag", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUnitTag()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUnitTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unittag2", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUnitTag2()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUnitBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUnitBase.getJSONValue((Object)pSSysUnitBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUnitBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUnitBase pSSysUnitBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUnitBase.getCodeName() != null) {
            object = pSSysUnitBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getCreateDate() != null) {
            object = pSSysUnitBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUnitBase.getCreateMan() != null) {
            object = pSSysUnitBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getLockFlag() != null) {
            object = pSSysUnitBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUnitBase.getMemo() != null) {
            object = pSSysUnitBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getNamePSLanguageResId() != null) {
            object = pSSysUnitBase.getNamePSLanguageResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANGUAGERESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getNamePSLanguageResName() != null) {
            object = pSSysUnitBase.getNamePSLanguageResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANGUAGERESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSModuleId() != null) {
            object = pSSysUnitBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSModuleName() != null) {
            object = pSSysUnitBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSSystemId() != null) {
            object = pSSysUnitBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSSystemName() != null) {
            object = pSSysUnitBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSSysUnitId() != null) {
            object = pSSysUnitBase.getPSSysUnitId();
            xmlNode.setAttribute(FIELD_PSSYSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSSysUnitName() != null) {
            object = pSSysUnitBase.getPSSysUnitName();
            xmlNode.setAttribute(FIELD_PSSYSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSUnitId() != null) {
            object = pSSysUnitBase.getPSUnitId();
            xmlNode.setAttribute(FIELD_PSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getPSUnitName() != null) {
            object = pSSysUnitBase.getPSUnitName();
            xmlNode.setAttribute(FIELD_PSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUnitTag() != null) {
            object = pSSysUnitBase.getUnitTag();
            xmlNode.setAttribute(FIELD_UNITTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUnitTag2() != null) {
            object = pSSysUnitBase.getUnitTag2();
            xmlNode.setAttribute(FIELD_UNITTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUpdateDate() != null) {
            object = pSSysUnitBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUnitBase.getUpdateMan() != null) {
            object = pSSysUnitBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUserCat() != null) {
            object = pSSysUnitBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUserTag() != null) {
            object = pSSysUnitBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUserTag2() != null) {
            object = pSSysUnitBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUserTag3() != null) {
            object = pSSysUnitBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUnitBase.getUserTag4() != null) {
            object = pSSysUnitBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUnitBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUnitBase pSSysUnitBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUnitBase.isCodeNameDirty() && (bl || pSSysUnitBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUnitBase.getCodeName());
        }
        if (pSSysUnitBase.isCreateDateDirty() && (bl || pSSysUnitBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUnitBase.getCreateDate());
        }
        if (pSSysUnitBase.isCreateManDirty() && (bl || pSSysUnitBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUnitBase.getCreateMan());
        }
        if (pSSysUnitBase.isLockFlagDirty() && (bl || pSSysUnitBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysUnitBase.getLockFlag());
        }
        if (pSSysUnitBase.isMemoDirty() && (bl || pSSysUnitBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUnitBase.getMemo());
        }
        if (pSSysUnitBase.isNamePSLanguageResIdDirty() && (bl || pSSysUnitBase.getNamePSLanguageResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANGUAGERESID, (Object)pSSysUnitBase.getNamePSLanguageResId());
        }
        if (pSSysUnitBase.isNamePSLanguageResNameDirty() && (bl || pSSysUnitBase.getNamePSLanguageResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANGUAGERESNAME, (Object)pSSysUnitBase.getNamePSLanguageResName());
        }
        if (pSSysUnitBase.isPSModuleIdDirty() && (bl || pSSysUnitBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUnitBase.getPSModuleId());
        }
        if (pSSysUnitBase.isPSModuleNameDirty() && (bl || pSSysUnitBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUnitBase.getPSModuleName());
        }
        if (pSSysUnitBase.isPSSystemIdDirty() && (bl || pSSysUnitBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUnitBase.getPSSystemId());
        }
        if (pSSysUnitBase.isPSSystemNameDirty() && (bl || pSSysUnitBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUnitBase.getPSSystemName());
        }
        if (pSSysUnitBase.isPSSysUnitIdDirty() && (bl || pSSysUnitBase.getPSSysUnitId() != null)) {
            iDataObject.set(FIELD_PSSYSUNITID, (Object)pSSysUnitBase.getPSSysUnitId());
        }
        if (pSSysUnitBase.isPSSysUnitNameDirty() && (bl || pSSysUnitBase.getPSSysUnitName() != null)) {
            iDataObject.set(FIELD_PSSYSUNITNAME, (Object)pSSysUnitBase.getPSSysUnitName());
        }
        if (pSSysUnitBase.isPSUnitIdDirty() && (bl || pSSysUnitBase.getPSUnitId() != null)) {
            iDataObject.set(FIELD_PSUNITID, (Object)pSSysUnitBase.getPSUnitId());
        }
        if (pSSysUnitBase.isPSUnitNameDirty() && (bl || pSSysUnitBase.getPSUnitName() != null)) {
            iDataObject.set(FIELD_PSUNITNAME, (Object)pSSysUnitBase.getPSUnitName());
        }
        if (pSSysUnitBase.isUnitTagDirty() && (bl || pSSysUnitBase.getUnitTag() != null)) {
            iDataObject.set(FIELD_UNITTAG, (Object)pSSysUnitBase.getUnitTag());
        }
        if (pSSysUnitBase.isUnitTag2Dirty() && (bl || pSSysUnitBase.getUnitTag2() != null)) {
            iDataObject.set(FIELD_UNITTAG2, (Object)pSSysUnitBase.getUnitTag2());
        }
        if (pSSysUnitBase.isUpdateDateDirty() && (bl || pSSysUnitBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUnitBase.getUpdateDate());
        }
        if (pSSysUnitBase.isUpdateManDirty() && (bl || pSSysUnitBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUnitBase.getUpdateMan());
        }
        if (pSSysUnitBase.isUserCatDirty() && (bl || pSSysUnitBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUnitBase.getUserCat());
        }
        if (pSSysUnitBase.isUserTagDirty() && (bl || pSSysUnitBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUnitBase.getUserTag());
        }
        if (pSSysUnitBase.isUserTag2Dirty() && (bl || pSSysUnitBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUnitBase.getUserTag2());
        }
        if (pSSysUnitBase.isUserTag3Dirty() && (bl || pSSysUnitBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUnitBase.getUserTag3());
        }
        if (pSSysUnitBase.isUserTag4Dirty() && (bl || pSSysUnitBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUnitBase.getUserTag4());
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
        return PSSysUnitBase.remove(this, n);
    }

    private static boolean remove(PSSysUnitBase pSSysUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUnitBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysUnitBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysUnitBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysUnitBase.resetLockFlag();
                return true;
            }
            case 4: {
                pSSysUnitBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysUnitBase.resetNamePSLanguageResId();
                return true;
            }
            case 6: {
                pSSysUnitBase.resetNamePSLanguageResName();
                return true;
            }
            case 7: {
                pSSysUnitBase.resetPSModuleId();
                return true;
            }
            case 8: {
                pSSysUnitBase.resetPSModuleName();
                return true;
            }
            case 9: {
                pSSysUnitBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSSysUnitBase.resetPSSystemName();
                return true;
            }
            case 11: {
                pSSysUnitBase.resetPSSysUnitId();
                return true;
            }
            case 12: {
                pSSysUnitBase.resetPSSysUnitName();
                return true;
            }
            case 13: {
                pSSysUnitBase.resetPSUnitId();
                return true;
            }
            case 14: {
                pSSysUnitBase.resetPSUnitName();
                return true;
            }
            case 15: {
                pSSysUnitBase.resetUnitTag();
                return true;
            }
            case 16: {
                pSSysUnitBase.resetUnitTag2();
                return true;
            }
            case 17: {
                pSSysUnitBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSSysUnitBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSSysUnitBase.resetUserCat();
                return true;
            }
            case 20: {
                pSSysUnitBase.resetUserTag();
                return true;
            }
            case 21: {
                pSSysUnitBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSSysUnitBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSSysUnitBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getNamePSLanguageRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanguageRes();
        }
        if (this.getNamePSLanguageResId() == null) {
            return null;
        }
        Integer n = this.objNamePSLanguageResLock;
        synchronized (n) {
            if (this.namepslanguageres != null && DataTypeHelper.compare((int)25, (Object)this.getNamePSLanguageResId(), (Object)this.namepslanguageres.getPSLanguageResId()) != 0L) {
                this.namepslanguageres = null;
            }
            if (this.namepslanguageres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getNamePSLanguageResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.namepslanguageres = pSLanguageRes;
            }
            return this.namepslanguageres;
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
    public PSUnit getPSUnit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnit();
        }
        if (this.getPSUnitId() == null) {
            return null;
        }
        Integer n = this.objPSUnitLock;
        synchronized (n) {
            if (this.psunit != null && DataTypeHelper.compare((int)25, (Object)this.getPSUnitId(), (Object)this.psunit.getPSUnitId()) != 0L) {
                this.psunit = null;
            }
            if (this.psunit == null) {
                PSUnit pSUnit = new PSUnit();
                pSUnit.setPSUnitId(this.getPSUnitId());
                PSUnitService pSUnitService = (PSUnitService)ServiceGlobal.getService(PSUnitService.class, (SessionFactory)this.getSessionFactory());
                pSUnitService.autoGet(pSUnit);
                this.psunit = pSUnit;
            }
            return this.psunit;
        }
    }

    private PSSysUnitBase getProxyEntity() {
        return this.proxyPSSysUnitBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUnitBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUnitBase) {
            this.proxyPSSysUnitBase = (PSSysUnitBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_NAMEPSLANGUAGERESID, 5);
        fieldIndexMap.put(FIELD_NAMEPSLANGUAGERESNAME, 6);
        fieldIndexMap.put(FIELD_PSMODULEID, 7);
        fieldIndexMap.put(FIELD_PSMODULENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSUNITID, 11);
        fieldIndexMap.put(FIELD_PSSYSUNITNAME, 12);
        fieldIndexMap.put(FIELD_PSUNITID, 13);
        fieldIndexMap.put(FIELD_PSUNITNAME, 14);
        fieldIndexMap.put(FIELD_UNITTAG, 15);
        fieldIndexMap.put(FIELD_UNITTAG2, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
    }
}

