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
import net.ibizsys.pscore.srv.config.entity.PSCssCatTempl;
import net.ibizsys.pscore.srv.config.service.PSCssCatTemplService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCssCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCssCatBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSCATNAME = "CSSCATNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCSSCATTEMPLID = "PSCSSCATTEMPLID";
    public static final String FIELD_PSCSSCATTEMPLNAME = "PSCSSCATTEMPLNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCSSCATID = "PSSYSCSSCATID";
    public static final String FIELD_PSSYSCSSCATNAME = "PSSYSCSSCATNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
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
    private static final int INDEX_CSSCATNAME = 3;
    private static final int INDEX_LOCKFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSCSSCATTEMPLID = 6;
    private static final int INDEX_PSCSSCATTEMPLNAME = 7;
    private static final int INDEX_PSMODULEID = 8;
    private static final int INDEX_PSMODULENAME = 9;
    private static final int INDEX_PSSYSCSSCATID = 10;
    private static final int INDEX_PSSYSCSSCATNAME = 11;
    private static final int INDEX_PSSYSTEMID = 12;
    private static final int INDEX_PSSYSTEMNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_USERTAG3 = 19;
    private static final int INDEX_USERTAG4 = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCssCatBase proxyPSSysCssCatBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean csscatnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscsscattemplidDirtyFlag = false;
    private boolean pscsscattemplnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscsscatidDirtyFlag = false;
    private boolean pssyscsscatnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
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
    @Column(name="csscatname")
    private String csscatname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="pscsscattemplid")
    private String pscsscattemplid;
    @Column(name="pscsscattemplname")
    private String pscsscattemplname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscsscatid")
    private String pssyscsscatid;
    @Column(name="pssyscsscatname")
    private String pssyscsscatname;
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
    private Integer objPSCssCatTemplLock = new Integer(1);
    private PSCssCatTempl pscsscattempl = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
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

    public void setCssCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.csscatname = string;
        this.csscatnameDirtyFlag = true;
    }

    public String getCssCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssCatName();
        }
        return this.csscatname;
    }

    public boolean isCssCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssCatNameDirty();
        }
        return this.csscatnameDirtyFlag;
    }

    public void resetCssCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssCatName();
            return;
        }
        this.csscatnameDirtyFlag = false;
        this.csscatname = null;
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

    public void setPSCssCatTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssCatTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsscattemplid = string;
        this.pscsscattemplidDirtyFlag = true;
    }

    public String getPSCssCatTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTemplId();
        }
        return this.pscsscattemplid;
    }

    public boolean isPSCssCatTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssCatTemplIdDirty();
        }
        return this.pscsscattemplidDirtyFlag;
    }

    public void resetPSCssCatTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssCatTemplId();
            return;
        }
        this.pscsscattemplidDirtyFlag = false;
        this.pscsscattemplid = null;
    }

    public void setPSCssCatTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssCatTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsscattemplname = string;
        this.pscsscattemplnameDirtyFlag = true;
    }

    public String getPSCssCatTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTemplName();
        }
        return this.pscsscattemplname;
    }

    public boolean isPSCssCatTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssCatTemplNameDirty();
        }
        return this.pscsscattemplnameDirtyFlag;
    }

    public void resetPSCssCatTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssCatTemplName();
            return;
        }
        this.pscsscattemplnameDirtyFlag = false;
        this.pscsscattemplname = null;
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

    public void setPSSysCssCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscsscatid = string;
        this.pssyscsscatidDirtyFlag = true;
    }

    public String getPSSysCssCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssCatId();
        }
        return this.pssyscsscatid;
    }

    public boolean isPSSysCssCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssCatIdDirty();
        }
        return this.pssyscsscatidDirtyFlag;
    }

    public void resetPSSysCssCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssCatId();
            return;
        }
        this.pssyscsscatidDirtyFlag = false;
        this.pssyscsscatid = null;
    }

    public void setPSSysCssCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscsscatname = string;
        this.pssyscsscatnameDirtyFlag = true;
    }

    public String getPSSysCssCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssCatName();
        }
        return this.pssyscsscatname;
    }

    public boolean isPSSysCssCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssCatNameDirty();
        }
        return this.pssyscsscatnameDirtyFlag;
    }

    public void resetPSSysCssCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssCatName();
            return;
        }
        this.pssyscsscatnameDirtyFlag = false;
        this.pssyscsscatname = null;
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
        PSSysCssCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCssCatBase pSSysCssCatBase) {
        pSSysCssCatBase.resetCodeName();
        pSSysCssCatBase.resetCreateDate();
        pSSysCssCatBase.resetCreateMan();
        pSSysCssCatBase.resetCssCatName();
        pSSysCssCatBase.resetLockFlag();
        pSSysCssCatBase.resetMemo();
        pSSysCssCatBase.resetPSCssCatTemplId();
        pSSysCssCatBase.resetPSCssCatTemplName();
        pSSysCssCatBase.resetPSModuleId();
        pSSysCssCatBase.resetPSModuleName();
        pSSysCssCatBase.resetPSSysCssCatId();
        pSSysCssCatBase.resetPSSysCssCatName();
        pSSysCssCatBase.resetPSSystemId();
        pSSysCssCatBase.resetPSSystemName();
        pSSysCssCatBase.resetUpdateDate();
        pSSysCssCatBase.resetUpdateMan();
        pSSysCssCatBase.resetUserCat();
        pSSysCssCatBase.resetUserTag();
        pSSysCssCatBase.resetUserTag2();
        pSSysCssCatBase.resetUserTag3();
        pSSysCssCatBase.resetUserTag4();
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
        if (!bl || this.isCssCatNameDirty()) {
            hashMap.put(FIELD_CSSCATNAME, this.getCssCatName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCssCatTemplIdDirty()) {
            hashMap.put(FIELD_PSCSSCATTEMPLID, this.getPSCssCatTemplId());
        }
        if (!bl || this.isPSCssCatTemplNameDirty()) {
            hashMap.put(FIELD_PSCSSCATTEMPLNAME, this.getPSCssCatTemplName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysCssCatIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSCATID, this.getPSSysCssCatId());
        }
        if (!bl || this.isPSSysCssCatNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSCATNAME, this.getPSSysCssCatName());
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
        return PSSysCssCatBase.get(this, n);
    }

    private static Object get(PSSysCssCatBase pSSysCssCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCssCatBase.getCodeName();
            }
            case 1: {
                return pSSysCssCatBase.getCreateDate();
            }
            case 2: {
                return pSSysCssCatBase.getCreateMan();
            }
            case 3: {
                return pSSysCssCatBase.getCssCatName();
            }
            case 4: {
                return pSSysCssCatBase.getLockFlag();
            }
            case 5: {
                return pSSysCssCatBase.getMemo();
            }
            case 6: {
                return pSSysCssCatBase.getPSCssCatTemplId();
            }
            case 7: {
                return pSSysCssCatBase.getPSCssCatTemplName();
            }
            case 8: {
                return pSSysCssCatBase.getPSModuleId();
            }
            case 9: {
                return pSSysCssCatBase.getPSModuleName();
            }
            case 10: {
                return pSSysCssCatBase.getPSSysCssCatId();
            }
            case 11: {
                return pSSysCssCatBase.getPSSysCssCatName();
            }
            case 12: {
                return pSSysCssCatBase.getPSSystemId();
            }
            case 13: {
                return pSSysCssCatBase.getPSSystemName();
            }
            case 14: {
                return pSSysCssCatBase.getUpdateDate();
            }
            case 15: {
                return pSSysCssCatBase.getUpdateMan();
            }
            case 16: {
                return pSSysCssCatBase.getUserCat();
            }
            case 17: {
                return pSSysCssCatBase.getUserTag();
            }
            case 18: {
                return pSSysCssCatBase.getUserTag2();
            }
            case 19: {
                return pSSysCssCatBase.getUserTag3();
            }
            case 20: {
                return pSSysCssCatBase.getUserTag4();
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
        PSSysCssCatBase.set(this, n, object);
    }

    private static void set(PSSysCssCatBase pSSysCssCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCssCatBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCssCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysCssCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCssCatBase.setCssCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCssCatBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysCssCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCssCatBase.setPSCssCatTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCssCatBase.setPSCssCatTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCssCatBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCssCatBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCssCatBase.setPSSysCssCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCssCatBase.setPSSysCssCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysCssCatBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCssCatBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysCssCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysCssCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCssCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCssCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysCssCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCssCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCssCatBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysCssCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCssCatBase pSSysCssCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCssCatBase.getCodeName() == null;
            }
            case 1: {
                return pSSysCssCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysCssCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysCssCatBase.getCssCatName() == null;
            }
            case 4: {
                return pSSysCssCatBase.getLockFlag() == null;
            }
            case 5: {
                return pSSysCssCatBase.getMemo() == null;
            }
            case 6: {
                return pSSysCssCatBase.getPSCssCatTemplId() == null;
            }
            case 7: {
                return pSSysCssCatBase.getPSCssCatTemplName() == null;
            }
            case 8: {
                return pSSysCssCatBase.getPSModuleId() == null;
            }
            case 9: {
                return pSSysCssCatBase.getPSModuleName() == null;
            }
            case 10: {
                return pSSysCssCatBase.getPSSysCssCatId() == null;
            }
            case 11: {
                return pSSysCssCatBase.getPSSysCssCatName() == null;
            }
            case 12: {
                return pSSysCssCatBase.getPSSystemId() == null;
            }
            case 13: {
                return pSSysCssCatBase.getPSSystemName() == null;
            }
            case 14: {
                return pSSysCssCatBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysCssCatBase.getUpdateMan() == null;
            }
            case 16: {
                return pSSysCssCatBase.getUserCat() == null;
            }
            case 17: {
                return pSSysCssCatBase.getUserTag() == null;
            }
            case 18: {
                return pSSysCssCatBase.getUserTag2() == null;
            }
            case 19: {
                return pSSysCssCatBase.getUserTag3() == null;
            }
            case 20: {
                return pSSysCssCatBase.getUserTag4() == null;
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
        return PSSysCssCatBase.contains(this, n);
    }

    private static boolean contains(PSSysCssCatBase pSSysCssCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCssCatBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysCssCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysCssCatBase.isCreateManDirty();
            }
            case 3: {
                return pSSysCssCatBase.isCssCatNameDirty();
            }
            case 4: {
                return pSSysCssCatBase.isLockFlagDirty();
            }
            case 5: {
                return pSSysCssCatBase.isMemoDirty();
            }
            case 6: {
                return pSSysCssCatBase.isPSCssCatTemplIdDirty();
            }
            case 7: {
                return pSSysCssCatBase.isPSCssCatTemplNameDirty();
            }
            case 8: {
                return pSSysCssCatBase.isPSModuleIdDirty();
            }
            case 9: {
                return pSSysCssCatBase.isPSModuleNameDirty();
            }
            case 10: {
                return pSSysCssCatBase.isPSSysCssCatIdDirty();
            }
            case 11: {
                return pSSysCssCatBase.isPSSysCssCatNameDirty();
            }
            case 12: {
                return pSSysCssCatBase.isPSSystemIdDirty();
            }
            case 13: {
                return pSSysCssCatBase.isPSSystemNameDirty();
            }
            case 14: {
                return pSSysCssCatBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysCssCatBase.isUpdateManDirty();
            }
            case 16: {
                return pSSysCssCatBase.isUserCatDirty();
            }
            case 17: {
                return pSSysCssCatBase.isUserTagDirty();
            }
            case 18: {
                return pSSysCssCatBase.isUserTag2Dirty();
            }
            case 19: {
                return pSSysCssCatBase.isUserTag3Dirty();
            }
            case 20: {
                return pSSysCssCatBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCssCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCssCatBase pSSysCssCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCssCatBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getCssCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csscatname", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getCssCatName()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSCssCatTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsscattemplid", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSCssCatTemplId()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSCssCatTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsscattemplname", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSCssCatTemplName()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSSysCssCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscsscatid", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSSysCssCatId()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSSysCssCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscsscatname", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSSysCssCatName()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCssCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCssCatBase.getJSONValue((Object)pSSysCssCatBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCssCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCssCatBase pSSysCssCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCssCatBase.getCodeName() != null) {
            object = pSSysCssCatBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getCreateDate() != null) {
            object = pSSysCssCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCssCatBase.getCreateMan() != null) {
            object = pSSysCssCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getCssCatName() != null) {
            object = pSSysCssCatBase.getCssCatName();
            xmlNode.setAttribute(FIELD_CSSCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getLockFlag() != null) {
            object = pSSysCssCatBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCssCatBase.getMemo() != null) {
            object = pSSysCssCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSCssCatTemplId() != null) {
            object = pSSysCssCatBase.getPSCssCatTemplId();
            xmlNode.setAttribute(FIELD_PSCSSCATTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSCssCatTemplName() != null) {
            object = pSSysCssCatBase.getPSCssCatTemplName();
            xmlNode.setAttribute(FIELD_PSCSSCATTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSModuleId() != null) {
            object = pSSysCssCatBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSModuleName() != null) {
            object = pSSysCssCatBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSSysCssCatId() != null) {
            object = pSSysCssCatBase.getPSSysCssCatId();
            xmlNode.setAttribute(FIELD_PSSYSCSSCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSSysCssCatName() != null) {
            object = pSSysCssCatBase.getPSSysCssCatName();
            xmlNode.setAttribute(FIELD_PSSYSCSSCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSSystemId() != null) {
            object = pSSysCssCatBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getPSSystemName() != null) {
            object = pSSysCssCatBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getUpdateDate() != null) {
            object = pSSysCssCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCssCatBase.getUpdateMan() != null) {
            object = pSSysCssCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getUserCat() != null) {
            object = pSSysCssCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getUserTag() != null) {
            object = pSSysCssCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getUserTag2() != null) {
            object = pSSysCssCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getUserTag3() != null) {
            object = pSSysCssCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssCatBase.getUserTag4() != null) {
            object = pSSysCssCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCssCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCssCatBase pSSysCssCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCssCatBase.isCodeNameDirty() && (bl || pSSysCssCatBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysCssCatBase.getCodeName());
        }
        if (pSSysCssCatBase.isCreateDateDirty() && (bl || pSSysCssCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCssCatBase.getCreateDate());
        }
        if (pSSysCssCatBase.isCreateManDirty() && (bl || pSSysCssCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCssCatBase.getCreateMan());
        }
        if (pSSysCssCatBase.isCssCatNameDirty() && (bl || pSSysCssCatBase.getCssCatName() != null)) {
            iDataObject.set(FIELD_CSSCATNAME, (Object)pSSysCssCatBase.getCssCatName());
        }
        if (pSSysCssCatBase.isLockFlagDirty() && (bl || pSSysCssCatBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysCssCatBase.getLockFlag());
        }
        if (pSSysCssCatBase.isMemoDirty() && (bl || pSSysCssCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCssCatBase.getMemo());
        }
        if (pSSysCssCatBase.isPSCssCatTemplIdDirty() && (bl || pSSysCssCatBase.getPSCssCatTemplId() != null)) {
            iDataObject.set(FIELD_PSCSSCATTEMPLID, (Object)pSSysCssCatBase.getPSCssCatTemplId());
        }
        if (pSSysCssCatBase.isPSCssCatTemplNameDirty() && (bl || pSSysCssCatBase.getPSCssCatTemplName() != null)) {
            iDataObject.set(FIELD_PSCSSCATTEMPLNAME, (Object)pSSysCssCatBase.getPSCssCatTemplName());
        }
        if (pSSysCssCatBase.isPSModuleIdDirty() && (bl || pSSysCssCatBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysCssCatBase.getPSModuleId());
        }
        if (pSSysCssCatBase.isPSModuleNameDirty() && (bl || pSSysCssCatBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysCssCatBase.getPSModuleName());
        }
        if (pSSysCssCatBase.isPSSysCssCatIdDirty() && (bl || pSSysCssCatBase.getPSSysCssCatId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSCATID, (Object)pSSysCssCatBase.getPSSysCssCatId());
        }
        if (pSSysCssCatBase.isPSSysCssCatNameDirty() && (bl || pSSysCssCatBase.getPSSysCssCatName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSCATNAME, (Object)pSSysCssCatBase.getPSSysCssCatName());
        }
        if (pSSysCssCatBase.isPSSystemIdDirty() && (bl || pSSysCssCatBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysCssCatBase.getPSSystemId());
        }
        if (pSSysCssCatBase.isPSSystemNameDirty() && (bl || pSSysCssCatBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysCssCatBase.getPSSystemName());
        }
        if (pSSysCssCatBase.isUpdateDateDirty() && (bl || pSSysCssCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCssCatBase.getUpdateDate());
        }
        if (pSSysCssCatBase.isUpdateManDirty() && (bl || pSSysCssCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCssCatBase.getUpdateMan());
        }
        if (pSSysCssCatBase.isUserCatDirty() && (bl || pSSysCssCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCssCatBase.getUserCat());
        }
        if (pSSysCssCatBase.isUserTagDirty() && (bl || pSSysCssCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCssCatBase.getUserTag());
        }
        if (pSSysCssCatBase.isUserTag2Dirty() && (bl || pSSysCssCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCssCatBase.getUserTag2());
        }
        if (pSSysCssCatBase.isUserTag3Dirty() && (bl || pSSysCssCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCssCatBase.getUserTag3());
        }
        if (pSSysCssCatBase.isUserTag4Dirty() && (bl || pSSysCssCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCssCatBase.getUserTag4());
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
        return PSSysCssCatBase.remove(this, n);
    }

    private static boolean remove(PSSysCssCatBase pSSysCssCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCssCatBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysCssCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysCssCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysCssCatBase.resetCssCatName();
                return true;
            }
            case 4: {
                pSSysCssCatBase.resetLockFlag();
                return true;
            }
            case 5: {
                pSSysCssCatBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysCssCatBase.resetPSCssCatTemplId();
                return true;
            }
            case 7: {
                pSSysCssCatBase.resetPSCssCatTemplName();
                return true;
            }
            case 8: {
                pSSysCssCatBase.resetPSModuleId();
                return true;
            }
            case 9: {
                pSSysCssCatBase.resetPSModuleName();
                return true;
            }
            case 10: {
                pSSysCssCatBase.resetPSSysCssCatId();
                return true;
            }
            case 11: {
                pSSysCssCatBase.resetPSSysCssCatName();
                return true;
            }
            case 12: {
                pSSysCssCatBase.resetPSSystemId();
                return true;
            }
            case 13: {
                pSSysCssCatBase.resetPSSystemName();
                return true;
            }
            case 14: {
                pSSysCssCatBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysCssCatBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSSysCssCatBase.resetUserCat();
                return true;
            }
            case 17: {
                pSSysCssCatBase.resetUserTag();
                return true;
            }
            case 18: {
                pSSysCssCatBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSSysCssCatBase.resetUserTag3();
                return true;
            }
            case 20: {
                pSSysCssCatBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCssCatTempl getPSCssCatTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTempl();
        }
        if (this.getPSCssCatTemplId() == null) {
            return null;
        }
        Integer n = this.objPSCssCatTemplLock;
        synchronized (n) {
            if (this.pscsscattempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSCssCatTemplId(), (Object)this.pscsscattempl.getPSCssCatTemplId()) != 0L) {
                this.pscsscattempl = null;
            }
            if (this.pscsscattempl == null) {
                PSCssCatTempl pSCssCatTempl = new PSCssCatTempl();
                pSCssCatTempl.setPSCssCatTemplId(this.getPSCssCatTemplId());
                PSCssCatTemplService pSCssCatTemplService = (PSCssCatTemplService)ServiceGlobal.getService(PSCssCatTemplService.class, (SessionFactory)this.getSessionFactory());
                pSCssCatTemplService.autoGet(pSCssCatTempl);
                this.pscsscattempl = pSCssCatTempl;
            }
            return this.pscsscattempl;
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

    private PSSysCssCatBase getProxyEntity() {
        return this.proxyPSSysCssCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCssCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCssCatBase) {
            this.proxyPSSysCssCatBase = (PSSysCssCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CSSCATNAME, 3);
        fieldIndexMap.put(FIELD_LOCKFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSCSSCATTEMPLID, 6);
        fieldIndexMap.put(FIELD_PSCSSCATTEMPLNAME, 7);
        fieldIndexMap.put(FIELD_PSMODULEID, 8);
        fieldIndexMap.put(FIELD_PSMODULENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSCSSCATID, 10);
        fieldIndexMap.put(FIELD_PSSYSCSSCATNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_USERTAG3, 19);
        fieldIndexMap.put(FIELD_USERTAG4, 20);
    }
}

