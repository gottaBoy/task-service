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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysWFModeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysWFModeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSWFMODEID = "PSSYSWFMODEID";
    public static final String FIELD_PSSYSWFMODENAME = "PSSYSWFMODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WFMODE = "WFMODE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOCKFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSMODULEID = 4;
    private static final int INDEX_PSMODULENAME = 5;
    private static final int INDEX_PSSYSTEMID = 6;
    private static final int INDEX_PSSYSTEMNAME = 7;
    private static final int INDEX_PSSYSWFMODEID = 8;
    private static final int INDEX_PSSYSWFMODENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_WFMODE = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysWFModeBase proxyPSSysWFModeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssyswfmodeidDirtyFlag = false;
    private boolean pssyswfmodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean wfmodeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssyswfmodeid")
    private String pssyswfmodeid;
    @Column(name="pssyswfmodename")
    private String pssyswfmodename;
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
    @Column(name="wfmode")
    private String wfmode;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSSysWFModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfmodeid = string;
        this.pssyswfmodeidDirtyFlag = true;
    }

    public String getPSSysWFModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFModeId();
        }
        return this.pssyswfmodeid;
    }

    public boolean isPSSysWFModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFModeIdDirty();
        }
        return this.pssyswfmodeidDirtyFlag;
    }

    public void resetPSSysWFModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFModeId();
            return;
        }
        this.pssyswfmodeidDirtyFlag = false;
        this.pssyswfmodeid = null;
    }

    public void setPSSysWFModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfmodename = string;
        this.pssyswfmodenameDirtyFlag = true;
    }

    public String getPSSysWFModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFModeName();
        }
        return this.pssyswfmodename;
    }

    public boolean isPSSysWFModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFModeNameDirty();
        }
        return this.pssyswfmodenameDirtyFlag;
    }

    public void resetPSSysWFModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFModeName();
            return;
        }
        this.pssyswfmodenameDirtyFlag = false;
        this.pssyswfmodename = null;
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

    public void setWFMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfmode = string;
        this.wfmodeDirtyFlag = true;
    }

    public String getWFMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMode();
        }
        return this.wfmode;
    }

    public boolean isWFModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFModeDirty();
        }
        return this.wfmodeDirtyFlag;
    }

    public void resetWFMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMode();
            return;
        }
        this.wfmodeDirtyFlag = false;
        this.wfmode = null;
    }

    protected void onReset() {
        PSSysWFModeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysWFModeBase pSSysWFModeBase) {
        pSSysWFModeBase.resetCreateDate();
        pSSysWFModeBase.resetCreateMan();
        pSSysWFModeBase.resetLockFlag();
        pSSysWFModeBase.resetMemo();
        pSSysWFModeBase.resetPSModuleId();
        pSSysWFModeBase.resetPSModuleName();
        pSSysWFModeBase.resetPSSystemId();
        pSSysWFModeBase.resetPSSystemName();
        pSSysWFModeBase.resetPSSysWFModeId();
        pSSysWFModeBase.resetPSSysWFModeName();
        pSSysWFModeBase.resetUpdateDate();
        pSSysWFModeBase.resetUpdateMan();
        pSSysWFModeBase.resetUserCat();
        pSSysWFModeBase.resetUserTag();
        pSSysWFModeBase.resetUserTag2();
        pSSysWFModeBase.resetUserTag3();
        pSSysWFModeBase.resetUserTag4();
        pSSysWFModeBase.resetWFMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSSysWFModeIdDirty()) {
            hashMap.put(FIELD_PSSYSWFMODEID, this.getPSSysWFModeId());
        }
        if (!bl || this.isPSSysWFModeNameDirty()) {
            hashMap.put(FIELD_PSSYSWFMODENAME, this.getPSSysWFModeName());
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
        if (!bl || this.isWFModeDirty()) {
            hashMap.put(FIELD_WFMODE, this.getWFMode());
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
        return PSSysWFModeBase.get(this, n);
    }

    private static Object get(PSSysWFModeBase pSSysWFModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFModeBase.getCreateDate();
            }
            case 1: {
                return pSSysWFModeBase.getCreateMan();
            }
            case 2: {
                return pSSysWFModeBase.getLockFlag();
            }
            case 3: {
                return pSSysWFModeBase.getMemo();
            }
            case 4: {
                return pSSysWFModeBase.getPSModuleId();
            }
            case 5: {
                return pSSysWFModeBase.getPSModuleName();
            }
            case 6: {
                return pSSysWFModeBase.getPSSystemId();
            }
            case 7: {
                return pSSysWFModeBase.getPSSystemName();
            }
            case 8: {
                return pSSysWFModeBase.getPSSysWFModeId();
            }
            case 9: {
                return pSSysWFModeBase.getPSSysWFModeName();
            }
            case 10: {
                return pSSysWFModeBase.getUpdateDate();
            }
            case 11: {
                return pSSysWFModeBase.getUpdateMan();
            }
            case 12: {
                return pSSysWFModeBase.getUserCat();
            }
            case 13: {
                return pSSysWFModeBase.getUserTag();
            }
            case 14: {
                return pSSysWFModeBase.getUserTag2();
            }
            case 15: {
                return pSSysWFModeBase.getUserTag3();
            }
            case 16: {
                return pSSysWFModeBase.getUserTag4();
            }
            case 17: {
                return pSSysWFModeBase.getWFMode();
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
        PSSysWFModeBase.set(this, n, object);
    }

    private static void set(PSSysWFModeBase pSSysWFModeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysWFModeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysWFModeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysWFModeBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysWFModeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysWFModeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysWFModeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysWFModeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysWFModeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysWFModeBase.setPSSysWFModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysWFModeBase.setPSSysWFModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysWFModeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysWFModeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysWFModeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysWFModeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysWFModeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysWFModeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysWFModeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysWFModeBase.setWFMode(DataObject.getStringValue((Object)object));
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
        return PSSysWFModeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysWFModeBase pSSysWFModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFModeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysWFModeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysWFModeBase.getLockFlag() == null;
            }
            case 3: {
                return pSSysWFModeBase.getMemo() == null;
            }
            case 4: {
                return pSSysWFModeBase.getPSModuleId() == null;
            }
            case 5: {
                return pSSysWFModeBase.getPSModuleName() == null;
            }
            case 6: {
                return pSSysWFModeBase.getPSSystemId() == null;
            }
            case 7: {
                return pSSysWFModeBase.getPSSystemName() == null;
            }
            case 8: {
                return pSSysWFModeBase.getPSSysWFModeId() == null;
            }
            case 9: {
                return pSSysWFModeBase.getPSSysWFModeName() == null;
            }
            case 10: {
                return pSSysWFModeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysWFModeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysWFModeBase.getUserCat() == null;
            }
            case 13: {
                return pSSysWFModeBase.getUserTag() == null;
            }
            case 14: {
                return pSSysWFModeBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysWFModeBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysWFModeBase.getUserTag4() == null;
            }
            case 17: {
                return pSSysWFModeBase.getWFMode() == null;
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
        return PSSysWFModeBase.contains(this, n);
    }

    private static boolean contains(PSSysWFModeBase pSSysWFModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFModeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysWFModeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysWFModeBase.isLockFlagDirty();
            }
            case 3: {
                return pSSysWFModeBase.isMemoDirty();
            }
            case 4: {
                return pSSysWFModeBase.isPSModuleIdDirty();
            }
            case 5: {
                return pSSysWFModeBase.isPSModuleNameDirty();
            }
            case 6: {
                return pSSysWFModeBase.isPSSystemIdDirty();
            }
            case 7: {
                return pSSysWFModeBase.isPSSystemNameDirty();
            }
            case 8: {
                return pSSysWFModeBase.isPSSysWFModeIdDirty();
            }
            case 9: {
                return pSSysWFModeBase.isPSSysWFModeNameDirty();
            }
            case 10: {
                return pSSysWFModeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysWFModeBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysWFModeBase.isUserCatDirty();
            }
            case 13: {
                return pSSysWFModeBase.isUserTagDirty();
            }
            case 14: {
                return pSSysWFModeBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysWFModeBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysWFModeBase.isUserTag4Dirty();
            }
            case 17: {
                return pSSysWFModeBase.isWFModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysWFModeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysWFModeBase pSSysWFModeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysWFModeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getPSSysWFModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfmodeid", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getPSSysWFModeId()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getPSSysWFModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfmodename", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getPSSysWFModeName()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysWFModeBase.getWFMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfmode", (Object)PSSysWFModeBase.getJSONValue((Object)pSSysWFModeBase.getWFMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysWFModeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysWFModeBase pSSysWFModeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysWFModeBase.getCreateDate() != null) {
            object = pSSysWFModeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysWFModeBase.getCreateMan() != null) {
            object = pSSysWFModeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getLockFlag() != null) {
            object = pSSysWFModeBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysWFModeBase.getMemo() != null) {
            object = pSSysWFModeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getPSModuleId() != null) {
            object = pSSysWFModeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getPSModuleName() != null) {
            object = pSSysWFModeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getPSSystemId() != null) {
            object = pSSysWFModeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getPSSystemName() != null) {
            object = pSSysWFModeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getPSSysWFModeId() != null) {
            object = pSSysWFModeBase.getPSSysWFModeId();
            xmlNode.setAttribute(FIELD_PSSYSWFMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getPSSysWFModeName() != null) {
            object = pSSysWFModeBase.getPSSysWFModeName();
            xmlNode.setAttribute(FIELD_PSSYSWFMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getUpdateDate() != null) {
            object = pSSysWFModeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysWFModeBase.getUpdateMan() != null) {
            object = pSSysWFModeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getUserCat() != null) {
            object = pSSysWFModeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getUserTag() != null) {
            object = pSSysWFModeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getUserTag2() != null) {
            object = pSSysWFModeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getUserTag3() != null) {
            object = pSSysWFModeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getUserTag4() != null) {
            object = pSSysWFModeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFModeBase.getWFMode() != null) {
            object = pSSysWFModeBase.getWFMode();
            xmlNode.setAttribute(FIELD_WFMODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysWFModeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysWFModeBase pSSysWFModeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysWFModeBase.isCreateDateDirty() && (bl || pSSysWFModeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysWFModeBase.getCreateDate());
        }
        if (pSSysWFModeBase.isCreateManDirty() && (bl || pSSysWFModeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysWFModeBase.getCreateMan());
        }
        if (pSSysWFModeBase.isLockFlagDirty() && (bl || pSSysWFModeBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysWFModeBase.getLockFlag());
        }
        if (pSSysWFModeBase.isMemoDirty() && (bl || pSSysWFModeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysWFModeBase.getMemo());
        }
        if (pSSysWFModeBase.isPSModuleIdDirty() && (bl || pSSysWFModeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysWFModeBase.getPSModuleId());
        }
        if (pSSysWFModeBase.isPSModuleNameDirty() && (bl || pSSysWFModeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysWFModeBase.getPSModuleName());
        }
        if (pSSysWFModeBase.isPSSystemIdDirty() && (bl || pSSysWFModeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysWFModeBase.getPSSystemId());
        }
        if (pSSysWFModeBase.isPSSystemNameDirty() && (bl || pSSysWFModeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysWFModeBase.getPSSystemName());
        }
        if (pSSysWFModeBase.isPSSysWFModeIdDirty() && (bl || pSSysWFModeBase.getPSSysWFModeId() != null)) {
            iDataObject.set(FIELD_PSSYSWFMODEID, (Object)pSSysWFModeBase.getPSSysWFModeId());
        }
        if (pSSysWFModeBase.isPSSysWFModeNameDirty() && (bl || pSSysWFModeBase.getPSSysWFModeName() != null)) {
            iDataObject.set(FIELD_PSSYSWFMODENAME, (Object)pSSysWFModeBase.getPSSysWFModeName());
        }
        if (pSSysWFModeBase.isUpdateDateDirty() && (bl || pSSysWFModeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysWFModeBase.getUpdateDate());
        }
        if (pSSysWFModeBase.isUpdateManDirty() && (bl || pSSysWFModeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysWFModeBase.getUpdateMan());
        }
        if (pSSysWFModeBase.isUserCatDirty() && (bl || pSSysWFModeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysWFModeBase.getUserCat());
        }
        if (pSSysWFModeBase.isUserTagDirty() && (bl || pSSysWFModeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysWFModeBase.getUserTag());
        }
        if (pSSysWFModeBase.isUserTag2Dirty() && (bl || pSSysWFModeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysWFModeBase.getUserTag2());
        }
        if (pSSysWFModeBase.isUserTag3Dirty() && (bl || pSSysWFModeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysWFModeBase.getUserTag3());
        }
        if (pSSysWFModeBase.isUserTag4Dirty() && (bl || pSSysWFModeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysWFModeBase.getUserTag4());
        }
        if (pSSysWFModeBase.isWFModeDirty() && (bl || pSSysWFModeBase.getWFMode() != null)) {
            iDataObject.set(FIELD_WFMODE, (Object)pSSysWFModeBase.getWFMode());
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
        return PSSysWFModeBase.remove(this, n);
    }

    private static boolean remove(PSSysWFModeBase pSSysWFModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysWFModeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysWFModeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysWFModeBase.resetLockFlag();
                return true;
            }
            case 3: {
                pSSysWFModeBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysWFModeBase.resetPSModuleId();
                return true;
            }
            case 5: {
                pSSysWFModeBase.resetPSModuleName();
                return true;
            }
            case 6: {
                pSSysWFModeBase.resetPSSystemId();
                return true;
            }
            case 7: {
                pSSysWFModeBase.resetPSSystemName();
                return true;
            }
            case 8: {
                pSSysWFModeBase.resetPSSysWFModeId();
                return true;
            }
            case 9: {
                pSSysWFModeBase.resetPSSysWFModeName();
                return true;
            }
            case 10: {
                pSSysWFModeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysWFModeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysWFModeBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysWFModeBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysWFModeBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysWFModeBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysWFModeBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSSysWFModeBase.resetWFMode();
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

    private PSSysWFModeBase getProxyEntity() {
        return this.proxyPSSysWFModeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysWFModeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysWFModeBase) {
            this.proxyPSSysWFModeBase = (PSSysWFModeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSSysWFModeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOCKFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSMODULEID, 4);
        fieldIndexMap.put(FIELD_PSMODULENAME, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSWFMODEID, 8);
        fieldIndexMap.put(FIELD_PSSYSWFMODENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_WFMODE, 17);
    }
}

