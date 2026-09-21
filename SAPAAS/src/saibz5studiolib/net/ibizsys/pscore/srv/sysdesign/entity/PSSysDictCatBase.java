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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDictCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDictCatBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DICTCATTAG = "DICTCATTAG";
    public static final String FIELD_DICTCATTAG2 = "DICTCATTAG2";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String FIELD_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
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
    private static final int INDEX_DICTCATTAG = 3;
    private static final int INDEX_DICTCATTAG2 = 4;
    private static final int INDEX_LOCKFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSMODULEID = 7;
    private static final int INDEX_PSMODULENAME = 8;
    private static final int INDEX_PSSYSDICTCATID = 9;
    private static final int INDEX_PSSYSDICTCATNAME = 10;
    private static final int INDEX_PSSYSDYNAMODELID = 11;
    private static final int INDEX_PSSYSDYNAMODELNAME = 12;
    private static final int INDEX_PSSYSTEMID = 13;
    private static final int INDEX_PSSYSTEMNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_USERTAG3 = 20;
    private static final int INDEX_USERTAG4 = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDictCatBase proxyPSSysDictCatBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dictcattagDirtyFlag = false;
    private boolean dictcattag2DirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdictcatidDirtyFlag = false;
    private boolean pssysdictcatnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
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
    @Column(name="dictcattag")
    private String dictcattag;
    @Column(name="dictcattag2")
    private String dictcattag2;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdictcatid")
    private String pssysdictcatid;
    @Column(name="pssysdictcatname")
    private String pssysdictcatname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private Integer usercat;
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

    public void setDictCatTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDictCatTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dictcattag = string;
        this.dictcattagDirtyFlag = true;
    }

    public String getDictCatTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDictCatTag();
        }
        return this.dictcattag;
    }

    public boolean isDictCatTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDictCatTagDirty();
        }
        return this.dictcattagDirtyFlag;
    }

    public void resetDictCatTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDictCatTag();
            return;
        }
        this.dictcattagDirtyFlag = false;
        this.dictcattag = null;
    }

    public void setDictCatTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDictCatTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dictcattag2 = string;
        this.dictcattag2DirtyFlag = true;
    }

    public String getDictCatTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDictCatTag2();
        }
        return this.dictcattag2;
    }

    public boolean isDictCatTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDictCatTag2Dirty();
        }
        return this.dictcattag2DirtyFlag;
    }

    public void resetDictCatTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDictCatTag2();
            return;
        }
        this.dictcattag2DirtyFlag = false;
        this.dictcattag2 = null;
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

    public void setPSSysDictCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDictCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdictcatid = string;
        this.pssysdictcatidDirtyFlag = true;
    }

    public String getPSSysDictCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCatId();
        }
        return this.pssysdictcatid;
    }

    public boolean isPSSysDictCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDictCatIdDirty();
        }
        return this.pssysdictcatidDirtyFlag;
    }

    public void resetPSSysDictCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDictCatId();
            return;
        }
        this.pssysdictcatidDirtyFlag = false;
        this.pssysdictcatid = null;
    }

    public void setPSSysDictCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDictCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdictcatname = string;
        this.pssysdictcatnameDirtyFlag = true;
    }

    public String getPSSysDictCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCatName();
        }
        return this.pssysdictcatname;
    }

    public boolean isPSSysDictCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDictCatNameDirty();
        }
        return this.pssysdictcatnameDirtyFlag;
    }

    public void resetPSSysDictCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDictCatName();
            return;
        }
        this.pssysdictcatnameDirtyFlag = false;
        this.pssysdictcatname = null;
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

    public void setUserCat(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(n);
            return;
        }
        this.usercat = n;
        this.usercatDirtyFlag = true;
    }

    public Integer getUserCat() {
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
        PSSysDictCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDictCatBase pSSysDictCatBase) {
        pSSysDictCatBase.resetCodeName();
        pSSysDictCatBase.resetCreateDate();
        pSSysDictCatBase.resetCreateMan();
        pSSysDictCatBase.resetDictCatTag();
        pSSysDictCatBase.resetDictCatTag2();
        pSSysDictCatBase.resetLockFlag();
        pSSysDictCatBase.resetMemo();
        pSSysDictCatBase.resetPSModuleId();
        pSSysDictCatBase.resetPSModuleName();
        pSSysDictCatBase.resetPSSysDictCatId();
        pSSysDictCatBase.resetPSSysDictCatName();
        pSSysDictCatBase.resetPSSysDynaModelId();
        pSSysDictCatBase.resetPSSysDynaModelName();
        pSSysDictCatBase.resetPSSystemId();
        pSSysDictCatBase.resetPSSystemName();
        pSSysDictCatBase.resetUpdateDate();
        pSSysDictCatBase.resetUpdateMan();
        pSSysDictCatBase.resetUserCat();
        pSSysDictCatBase.resetUserTag();
        pSSysDictCatBase.resetUserTag2();
        pSSysDictCatBase.resetUserTag3();
        pSSysDictCatBase.resetUserTag4();
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
        if (!bl || this.isDictCatTagDirty()) {
            hashMap.put(FIELD_DICTCATTAG, this.getDictCatTag());
        }
        if (!bl || this.isDictCatTag2Dirty()) {
            hashMap.put(FIELD_DICTCATTAG2, this.getDictCatTag2());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
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
        if (!bl || this.isPSSysDictCatIdDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATID, this.getPSSysDictCatId());
        }
        if (!bl || this.isPSSysDictCatNameDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATNAME, this.getPSSysDictCatName());
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
        return PSSysDictCatBase.get(this, n);
    }

    private static Object get(PSSysDictCatBase pSSysDictCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDictCatBase.getCodeName();
            }
            case 1: {
                return pSSysDictCatBase.getCreateDate();
            }
            case 2: {
                return pSSysDictCatBase.getCreateMan();
            }
            case 3: {
                return pSSysDictCatBase.getDictCatTag();
            }
            case 4: {
                return pSSysDictCatBase.getDictCatTag2();
            }
            case 5: {
                return pSSysDictCatBase.getLockFlag();
            }
            case 6: {
                return pSSysDictCatBase.getMemo();
            }
            case 7: {
                return pSSysDictCatBase.getPSModuleId();
            }
            case 8: {
                return pSSysDictCatBase.getPSModuleName();
            }
            case 9: {
                return pSSysDictCatBase.getPSSysDictCatId();
            }
            case 10: {
                return pSSysDictCatBase.getPSSysDictCatName();
            }
            case 11: {
                return pSSysDictCatBase.getPSSysDynaModelId();
            }
            case 12: {
                return pSSysDictCatBase.getPSSysDynaModelName();
            }
            case 13: {
                return pSSysDictCatBase.getPSSystemId();
            }
            case 14: {
                return pSSysDictCatBase.getPSSystemName();
            }
            case 15: {
                return pSSysDictCatBase.getUpdateDate();
            }
            case 16: {
                return pSSysDictCatBase.getUpdateMan();
            }
            case 17: {
                return pSSysDictCatBase.getUserCat();
            }
            case 18: {
                return pSSysDictCatBase.getUserTag();
            }
            case 19: {
                return pSSysDictCatBase.getUserTag2();
            }
            case 20: {
                return pSSysDictCatBase.getUserTag3();
            }
            case 21: {
                return pSSysDictCatBase.getUserTag4();
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
        PSSysDictCatBase.set(this, n, object);
    }

    private static void set(PSSysDictCatBase pSSysDictCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDictCatBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDictCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDictCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDictCatBase.setDictCatTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDictCatBase.setDictCatTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDictCatBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysDictCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDictCatBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDictCatBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDictCatBase.setPSSysDictCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDictCatBase.setPSSysDictCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDictCatBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDictCatBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDictCatBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDictCatBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDictCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSSysDictCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDictCatBase.setUserCat(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysDictCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDictCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDictCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDictCatBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDictCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDictCatBase pSSysDictCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDictCatBase.getCodeName() == null;
            }
            case 1: {
                return pSSysDictCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDictCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDictCatBase.getDictCatTag() == null;
            }
            case 4: {
                return pSSysDictCatBase.getDictCatTag2() == null;
            }
            case 5: {
                return pSSysDictCatBase.getLockFlag() == null;
            }
            case 6: {
                return pSSysDictCatBase.getMemo() == null;
            }
            case 7: {
                return pSSysDictCatBase.getPSModuleId() == null;
            }
            case 8: {
                return pSSysDictCatBase.getPSModuleName() == null;
            }
            case 9: {
                return pSSysDictCatBase.getPSSysDictCatId() == null;
            }
            case 10: {
                return pSSysDictCatBase.getPSSysDictCatName() == null;
            }
            case 11: {
                return pSSysDictCatBase.getPSSysDynaModelId() == null;
            }
            case 12: {
                return pSSysDictCatBase.getPSSysDynaModelName() == null;
            }
            case 13: {
                return pSSysDictCatBase.getPSSystemId() == null;
            }
            case 14: {
                return pSSysDictCatBase.getPSSystemName() == null;
            }
            case 15: {
                return pSSysDictCatBase.getUpdateDate() == null;
            }
            case 16: {
                return pSSysDictCatBase.getUpdateMan() == null;
            }
            case 17: {
                return pSSysDictCatBase.getUserCat() == null;
            }
            case 18: {
                return pSSysDictCatBase.getUserTag() == null;
            }
            case 19: {
                return pSSysDictCatBase.getUserTag2() == null;
            }
            case 20: {
                return pSSysDictCatBase.getUserTag3() == null;
            }
            case 21: {
                return pSSysDictCatBase.getUserTag4() == null;
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
        return PSSysDictCatBase.contains(this, n);
    }

    private static boolean contains(PSSysDictCatBase pSSysDictCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDictCatBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysDictCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDictCatBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDictCatBase.isDictCatTagDirty();
            }
            case 4: {
                return pSSysDictCatBase.isDictCatTag2Dirty();
            }
            case 5: {
                return pSSysDictCatBase.isLockFlagDirty();
            }
            case 6: {
                return pSSysDictCatBase.isMemoDirty();
            }
            case 7: {
                return pSSysDictCatBase.isPSModuleIdDirty();
            }
            case 8: {
                return pSSysDictCatBase.isPSModuleNameDirty();
            }
            case 9: {
                return pSSysDictCatBase.isPSSysDictCatIdDirty();
            }
            case 10: {
                return pSSysDictCatBase.isPSSysDictCatNameDirty();
            }
            case 11: {
                return pSSysDictCatBase.isPSSysDynaModelIdDirty();
            }
            case 12: {
                return pSSysDictCatBase.isPSSysDynaModelNameDirty();
            }
            case 13: {
                return pSSysDictCatBase.isPSSystemIdDirty();
            }
            case 14: {
                return pSSysDictCatBase.isPSSystemNameDirty();
            }
            case 15: {
                return pSSysDictCatBase.isUpdateDateDirty();
            }
            case 16: {
                return pSSysDictCatBase.isUpdateManDirty();
            }
            case 17: {
                return pSSysDictCatBase.isUserCatDirty();
            }
            case 18: {
                return pSSysDictCatBase.isUserTagDirty();
            }
            case 19: {
                return pSSysDictCatBase.isUserTag2Dirty();
            }
            case 20: {
                return pSSysDictCatBase.isUserTag3Dirty();
            }
            case 21: {
                return pSSysDictCatBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDictCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDictCatBase pSSysDictCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDictCatBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getDictCatTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dictcattag", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getDictCatTag()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getDictCatTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dictcattag2", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getDictCatTag2()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSSysDictCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatid", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSSysDictCatId()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSSysDictCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatname", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSSysDictCatName()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDictCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDictCatBase.getJSONValue((Object)pSSysDictCatBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDictCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDictCatBase pSSysDictCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDictCatBase.getCodeName() != null) {
            object = pSSysDictCatBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getCreateDate() != null) {
            object = pSSysDictCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDictCatBase.getCreateMan() != null) {
            object = pSSysDictCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getDictCatTag() != null) {
            object = pSSysDictCatBase.getDictCatTag();
            xmlNode.setAttribute(FIELD_DICTCATTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getDictCatTag2() != null) {
            object = pSSysDictCatBase.getDictCatTag2();
            xmlNode.setAttribute(FIELD_DICTCATTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getLockFlag() != null) {
            object = pSSysDictCatBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDictCatBase.getMemo() != null) {
            object = pSSysDictCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSModuleId() != null) {
            object = pSSysDictCatBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSModuleName() != null) {
            object = pSSysDictCatBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSSysDictCatId() != null) {
            object = pSSysDictCatBase.getPSSysDictCatId();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSSysDictCatName() != null) {
            object = pSSysDictCatBase.getPSSysDictCatName();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSSysDynaModelId() != null) {
            object = pSSysDictCatBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSSysDynaModelName() != null) {
            object = pSSysDictCatBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSSystemId() != null) {
            object = pSSysDictCatBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getPSSystemName() != null) {
            object = pSSysDictCatBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getUpdateDate() != null) {
            object = pSSysDictCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDictCatBase.getUpdateMan() != null) {
            object = pSSysDictCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getUserCat() != null) {
            object = pSSysDictCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDictCatBase.getUserTag() != null) {
            object = pSSysDictCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getUserTag2() != null) {
            object = pSSysDictCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getUserTag3() != null) {
            object = pSSysDictCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDictCatBase.getUserTag4() != null) {
            object = pSSysDictCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDictCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDictCatBase pSSysDictCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDictCatBase.isCodeNameDirty() && (bl || pSSysDictCatBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDictCatBase.getCodeName());
        }
        if (pSSysDictCatBase.isCreateDateDirty() && (bl || pSSysDictCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDictCatBase.getCreateDate());
        }
        if (pSSysDictCatBase.isCreateManDirty() && (bl || pSSysDictCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDictCatBase.getCreateMan());
        }
        if (pSSysDictCatBase.isDictCatTagDirty() && (bl || pSSysDictCatBase.getDictCatTag() != null)) {
            iDataObject.set(FIELD_DICTCATTAG, (Object)pSSysDictCatBase.getDictCatTag());
        }
        if (pSSysDictCatBase.isDictCatTag2Dirty() && (bl || pSSysDictCatBase.getDictCatTag2() != null)) {
            iDataObject.set(FIELD_DICTCATTAG2, (Object)pSSysDictCatBase.getDictCatTag2());
        }
        if (pSSysDictCatBase.isLockFlagDirty() && (bl || pSSysDictCatBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysDictCatBase.getLockFlag());
        }
        if (pSSysDictCatBase.isMemoDirty() && (bl || pSSysDictCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDictCatBase.getMemo());
        }
        if (pSSysDictCatBase.isPSModuleIdDirty() && (bl || pSSysDictCatBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDictCatBase.getPSModuleId());
        }
        if (pSSysDictCatBase.isPSModuleNameDirty() && (bl || pSSysDictCatBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDictCatBase.getPSModuleName());
        }
        if (pSSysDictCatBase.isPSSysDictCatIdDirty() && (bl || pSSysDictCatBase.getPSSysDictCatId() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATID, (Object)pSSysDictCatBase.getPSSysDictCatId());
        }
        if (pSSysDictCatBase.isPSSysDictCatNameDirty() && (bl || pSSysDictCatBase.getPSSysDictCatName() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATNAME, (Object)pSSysDictCatBase.getPSSysDictCatName());
        }
        if (pSSysDictCatBase.isPSSysDynaModelIdDirty() && (bl || pSSysDictCatBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysDictCatBase.getPSSysDynaModelId());
        }
        if (pSSysDictCatBase.isPSSysDynaModelNameDirty() && (bl || pSSysDictCatBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysDictCatBase.getPSSysDynaModelName());
        }
        if (pSSysDictCatBase.isPSSystemIdDirty() && (bl || pSSysDictCatBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDictCatBase.getPSSystemId());
        }
        if (pSSysDictCatBase.isPSSystemNameDirty() && (bl || pSSysDictCatBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDictCatBase.getPSSystemName());
        }
        if (pSSysDictCatBase.isUpdateDateDirty() && (bl || pSSysDictCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDictCatBase.getUpdateDate());
        }
        if (pSSysDictCatBase.isUpdateManDirty() && (bl || pSSysDictCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDictCatBase.getUpdateMan());
        }
        if (pSSysDictCatBase.isUserCatDirty() && (bl || pSSysDictCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDictCatBase.getUserCat());
        }
        if (pSSysDictCatBase.isUserTagDirty() && (bl || pSSysDictCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDictCatBase.getUserTag());
        }
        if (pSSysDictCatBase.isUserTag2Dirty() && (bl || pSSysDictCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDictCatBase.getUserTag2());
        }
        if (pSSysDictCatBase.isUserTag3Dirty() && (bl || pSSysDictCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDictCatBase.getUserTag3());
        }
        if (pSSysDictCatBase.isUserTag4Dirty() && (bl || pSSysDictCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDictCatBase.getUserTag4());
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
        return PSSysDictCatBase.remove(this, n);
    }

    private static boolean remove(PSSysDictCatBase pSSysDictCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDictCatBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysDictCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDictCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDictCatBase.resetDictCatTag();
                return true;
            }
            case 4: {
                pSSysDictCatBase.resetDictCatTag2();
                return true;
            }
            case 5: {
                pSSysDictCatBase.resetLockFlag();
                return true;
            }
            case 6: {
                pSSysDictCatBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysDictCatBase.resetPSModuleId();
                return true;
            }
            case 8: {
                pSSysDictCatBase.resetPSModuleName();
                return true;
            }
            case 9: {
                pSSysDictCatBase.resetPSSysDictCatId();
                return true;
            }
            case 10: {
                pSSysDictCatBase.resetPSSysDictCatName();
                return true;
            }
            case 11: {
                pSSysDictCatBase.resetPSSysDynaModelId();
                return true;
            }
            case 12: {
                pSSysDictCatBase.resetPSSysDynaModelName();
                return true;
            }
            case 13: {
                pSSysDictCatBase.resetPSSystemId();
                return true;
            }
            case 14: {
                pSSysDictCatBase.resetPSSystemName();
                return true;
            }
            case 15: {
                pSSysDictCatBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSSysDictCatBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSSysDictCatBase.resetUserCat();
                return true;
            }
            case 18: {
                pSSysDictCatBase.resetUserTag();
                return true;
            }
            case 19: {
                pSSysDictCatBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSSysDictCatBase.resetUserTag3();
                return true;
            }
            case 21: {
                pSSysDictCatBase.resetUserTag4();
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysDictCatBase getProxyEntity() {
        return this.proxyPSSysDictCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDictCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDictCatBase) {
            this.proxyPSSysDictCatBase = (PSSysDictCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DICTCATTAG, 3);
        fieldIndexMap.put(FIELD_DICTCATTAG2, 4);
        fieldIndexMap.put(FIELD_LOCKFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSMODULEID, 7);
        fieldIndexMap.put(FIELD_PSMODULENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSDICTCATID, 9);
        fieldIndexMap.put(FIELD_PSSYSDICTCATNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 11);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_USERTAG3, 20);
        fieldIndexMap.put(FIELD_USERTAG4, 21);
    }
}

