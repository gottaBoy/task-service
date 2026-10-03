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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDColSetBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDColSetBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSBDCOLSETID = "PSSYSBDCOLSETID";
    public static final String FIELD_PSSYSBDCOLSETNAME = "PSSYSBDCOLSETNAME";
    public static final String FIELD_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String FIELD_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
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
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSSYSBDCOLSETID = 6;
    private static final int INDEX_PSSYSBDCOLSETNAME = 7;
    private static final int INDEX_PSSYSBDTABLEID = 8;
    private static final int INDEX_PSSYSBDTABLENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBDColSetBase proxyPSSysBDColSetBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysbdcolsetidDirtyFlag = false;
    private boolean pssysbdcolsetnameDirtyFlag = false;
    private boolean pssysbdtableidDirtyFlag = false;
    private boolean pssysbdtablenameDirtyFlag = false;
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
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysbdcolsetid")
    private String pssysbdcolsetid;
    @Column(name="pssysbdcolsetname")
    private String pssysbdcolsetname;
    @Column(name="pssysbdtableid")
    private String pssysbdtableid;
    @Column(name="pssysbdtablename")
    private String pssysbdtablename;
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
    private Integer objPSSysBDTableLock = new Integer(1);
    private PSSysBDTable pssysbdtable = null;

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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPSSysBDColSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdcolsetid = string;
        this.pssysbdcolsetidDirtyFlag = true;
    }

    public String getPSSysBDColSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColSetId();
        }
        return this.pssysbdcolsetid;
    }

    public boolean isPSSysBDColSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColSetIdDirty();
        }
        return this.pssysbdcolsetidDirtyFlag;
    }

    public void resetPSSysBDColSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColSetId();
            return;
        }
        this.pssysbdcolsetidDirtyFlag = false;
        this.pssysbdcolsetid = null;
    }

    public void setPSSysBDColSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdcolsetname = string;
        this.pssysbdcolsetnameDirtyFlag = true;
    }

    public String getPSSysBDColSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColSetName();
        }
        return this.pssysbdcolsetname;
    }

    public boolean isPSSysBDColSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColSetNameDirty();
        }
        return this.pssysbdcolsetnameDirtyFlag;
    }

    public void resetPSSysBDColSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColSetName();
            return;
        }
        this.pssysbdcolsetnameDirtyFlag = false;
        this.pssysbdcolsetname = null;
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
        PSSysBDColSetBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDColSetBase pSSysBDColSetBase) {
        pSSysBDColSetBase.resetCodeName();
        pSSysBDColSetBase.resetCreateDate();
        pSSysBDColSetBase.resetCreateMan();
        pSSysBDColSetBase.resetDefaultFlag();
        pSSysBDColSetBase.resetLogicName();
        pSSysBDColSetBase.resetMemo();
        pSSysBDColSetBase.resetPSSysBDColSetId();
        pSSysBDColSetBase.resetPSSysBDColSetName();
        pSSysBDColSetBase.resetPSSysBDTableId();
        pSSysBDColSetBase.resetPSSysBDTableName();
        pSSysBDColSetBase.resetUpdateDate();
        pSSysBDColSetBase.resetUpdateMan();
        pSSysBDColSetBase.resetUserCat();
        pSSysBDColSetBase.resetUserTag();
        pSSysBDColSetBase.resetUserTag2();
        pSSysBDColSetBase.resetUserTag3();
        pSSysBDColSetBase.resetUserTag4();
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysBDColSetIdDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLSETID, this.getPSSysBDColSetId());
        }
        if (!bl || this.isPSSysBDColSetNameDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLSETNAME, this.getPSSysBDColSetName());
        }
        if (!bl || this.isPSSysBDTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEID, this.getPSSysBDTableId());
        }
        if (!bl || this.isPSSysBDTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLENAME, this.getPSSysBDTableName());
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
        return PSSysBDColSetBase.get(this, n);
    }

    private static Object get(PSSysBDColSetBase pSSysBDColSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDColSetBase.getCodeName();
            }
            case 1: {
                return pSSysBDColSetBase.getCreateDate();
            }
            case 2: {
                return pSSysBDColSetBase.getCreateMan();
            }
            case 3: {
                return pSSysBDColSetBase.getDefaultFlag();
            }
            case 4: {
                return pSSysBDColSetBase.getLogicName();
            }
            case 5: {
                return pSSysBDColSetBase.getMemo();
            }
            case 6: {
                return pSSysBDColSetBase.getPSSysBDColSetId();
            }
            case 7: {
                return pSSysBDColSetBase.getPSSysBDColSetName();
            }
            case 8: {
                return pSSysBDColSetBase.getPSSysBDTableId();
            }
            case 9: {
                return pSSysBDColSetBase.getPSSysBDTableName();
            }
            case 10: {
                return pSSysBDColSetBase.getUpdateDate();
            }
            case 11: {
                return pSSysBDColSetBase.getUpdateMan();
            }
            case 12: {
                return pSSysBDColSetBase.getUserCat();
            }
            case 13: {
                return pSSysBDColSetBase.getUserTag();
            }
            case 14: {
                return pSSysBDColSetBase.getUserTag2();
            }
            case 15: {
                return pSSysBDColSetBase.getUserTag3();
            }
            case 16: {
                return pSSysBDColSetBase.getUserTag4();
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
        PSSysBDColSetBase.set(this, n, object);
    }

    private static void set(PSSysBDColSetBase pSSysBDColSetBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDColSetBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDColSetBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDColSetBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDColSetBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDColSetBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDColSetBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDColSetBase.setPSSysBDColSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDColSetBase.setPSSysBDColSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDColSetBase.setPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDColSetBase.setPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDColSetBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDColSetBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDColSetBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDColSetBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDColSetBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDColSetBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBDColSetBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBDColSetBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDColSetBase pSSysBDColSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDColSetBase.getCodeName() == null;
            }
            case 1: {
                return pSSysBDColSetBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysBDColSetBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysBDColSetBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSSysBDColSetBase.getLogicName() == null;
            }
            case 5: {
                return pSSysBDColSetBase.getMemo() == null;
            }
            case 6: {
                return pSSysBDColSetBase.getPSSysBDColSetId() == null;
            }
            case 7: {
                return pSSysBDColSetBase.getPSSysBDColSetName() == null;
            }
            case 8: {
                return pSSysBDColSetBase.getPSSysBDTableId() == null;
            }
            case 9: {
                return pSSysBDColSetBase.getPSSysBDTableName() == null;
            }
            case 10: {
                return pSSysBDColSetBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysBDColSetBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysBDColSetBase.getUserCat() == null;
            }
            case 13: {
                return pSSysBDColSetBase.getUserTag() == null;
            }
            case 14: {
                return pSSysBDColSetBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysBDColSetBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysBDColSetBase.getUserTag4() == null;
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
        return PSSysBDColSetBase.contains(this, n);
    }

    private static boolean contains(PSSysBDColSetBase pSSysBDColSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDColSetBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysBDColSetBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysBDColSetBase.isCreateManDirty();
            }
            case 3: {
                return pSSysBDColSetBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSSysBDColSetBase.isLogicNameDirty();
            }
            case 5: {
                return pSSysBDColSetBase.isMemoDirty();
            }
            case 6: {
                return pSSysBDColSetBase.isPSSysBDColSetIdDirty();
            }
            case 7: {
                return pSSysBDColSetBase.isPSSysBDColSetNameDirty();
            }
            case 8: {
                return pSSysBDColSetBase.isPSSysBDTableIdDirty();
            }
            case 9: {
                return pSSysBDColSetBase.isPSSysBDTableNameDirty();
            }
            case 10: {
                return pSSysBDColSetBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysBDColSetBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysBDColSetBase.isUserCatDirty();
            }
            case 13: {
                return pSSysBDColSetBase.isUserTagDirty();
            }
            case 14: {
                return pSSysBDColSetBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysBDColSetBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysBDColSetBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDColSetBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDColSetBase pSSysBDColSetBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDColSetBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDColSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolsetid", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getPSSysBDColSetId()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDColSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolsetname", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getPSSysBDColSetName()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtableid", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablename", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDColSetBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDColSetBase.getJSONValue((Object)pSSysBDColSetBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDColSetBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDColSetBase pSSysBDColSetBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDColSetBase.getCodeName() != null) {
            object = pSSysBDColSetBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getCreateDate() != null) {
            object = pSSysBDColSetBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDColSetBase.getCreateMan() != null) {
            object = pSSysBDColSetBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getDefaultFlag() != null) {
            object = pSSysBDColSetBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDColSetBase.getLogicName() != null) {
            object = pSSysBDColSetBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getMemo() != null) {
            object = pSSysBDColSetBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDColSetId() != null) {
            object = pSSysBDColSetBase.getPSSysBDColSetId();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLSETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDColSetName() != null) {
            object = pSSysBDColSetBase.getPSSysBDColSetName();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLSETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDTableId() != null) {
            object = pSSysBDColSetBase.getPSSysBDTableId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getPSSysBDTableName() != null) {
            object = pSSysBDColSetBase.getPSSysBDTableName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getUpdateDate() != null) {
            object = pSSysBDColSetBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDColSetBase.getUpdateMan() != null) {
            object = pSSysBDColSetBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getUserCat() != null) {
            object = pSSysBDColSetBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getUserTag() != null) {
            object = pSSysBDColSetBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getUserTag2() != null) {
            object = pSSysBDColSetBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getUserTag3() != null) {
            object = pSSysBDColSetBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColSetBase.getUserTag4() != null) {
            object = pSSysBDColSetBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDColSetBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDColSetBase pSSysBDColSetBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDColSetBase.isCodeNameDirty() && (bl || pSSysBDColSetBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBDColSetBase.getCodeName());
        }
        if (pSSysBDColSetBase.isCreateDateDirty() && (bl || pSSysBDColSetBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDColSetBase.getCreateDate());
        }
        if (pSSysBDColSetBase.isCreateManDirty() && (bl || pSSysBDColSetBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDColSetBase.getCreateMan());
        }
        if (pSSysBDColSetBase.isDefaultFlagDirty() && (bl || pSSysBDColSetBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSysBDColSetBase.getDefaultFlag());
        }
        if (pSSysBDColSetBase.isLogicNameDirty() && (bl || pSSysBDColSetBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysBDColSetBase.getLogicName());
        }
        if (pSSysBDColSetBase.isMemoDirty() && (bl || pSSysBDColSetBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDColSetBase.getMemo());
        }
        if (pSSysBDColSetBase.isPSSysBDColSetIdDirty() && (bl || pSSysBDColSetBase.getPSSysBDColSetId() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLSETID, (Object)pSSysBDColSetBase.getPSSysBDColSetId());
        }
        if (pSSysBDColSetBase.isPSSysBDColSetNameDirty() && (bl || pSSysBDColSetBase.getPSSysBDColSetName() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLSETNAME, (Object)pSSysBDColSetBase.getPSSysBDColSetName());
        }
        if (pSSysBDColSetBase.isPSSysBDTableIdDirty() && (bl || pSSysBDColSetBase.getPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEID, (Object)pSSysBDColSetBase.getPSSysBDTableId());
        }
        if (pSSysBDColSetBase.isPSSysBDTableNameDirty() && (bl || pSSysBDColSetBase.getPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLENAME, (Object)pSSysBDColSetBase.getPSSysBDTableName());
        }
        if (pSSysBDColSetBase.isUpdateDateDirty() && (bl || pSSysBDColSetBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDColSetBase.getUpdateDate());
        }
        if (pSSysBDColSetBase.isUpdateManDirty() && (bl || pSSysBDColSetBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDColSetBase.getUpdateMan());
        }
        if (pSSysBDColSetBase.isUserCatDirty() && (bl || pSSysBDColSetBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDColSetBase.getUserCat());
        }
        if (pSSysBDColSetBase.isUserTagDirty() && (bl || pSSysBDColSetBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDColSetBase.getUserTag());
        }
        if (pSSysBDColSetBase.isUserTag2Dirty() && (bl || pSSysBDColSetBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDColSetBase.getUserTag2());
        }
        if (pSSysBDColSetBase.isUserTag3Dirty() && (bl || pSSysBDColSetBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDColSetBase.getUserTag3());
        }
        if (pSSysBDColSetBase.isUserTag4Dirty() && (bl || pSSysBDColSetBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDColSetBase.getUserTag4());
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
        return PSSysBDColSetBase.remove(this, n);
    }

    private static boolean remove(PSSysBDColSetBase pSSysBDColSetBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDColSetBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysBDColSetBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysBDColSetBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysBDColSetBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSSysBDColSetBase.resetLogicName();
                return true;
            }
            case 5: {
                pSSysBDColSetBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysBDColSetBase.resetPSSysBDColSetId();
                return true;
            }
            case 7: {
                pSSysBDColSetBase.resetPSSysBDColSetName();
                return true;
            }
            case 8: {
                pSSysBDColSetBase.resetPSSysBDTableId();
                return true;
            }
            case 9: {
                pSSysBDColSetBase.resetPSSysBDTableName();
                return true;
            }
            case 10: {
                pSSysBDColSetBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysBDColSetBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysBDColSetBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysBDColSetBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysBDColSetBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysBDColSetBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysBDColSetBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDTable getPSSysBDTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTable();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDTableLock;
        synchronized (n) {
            if (this.pssysbdtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDTableId(), (Object)this.pssysbdtable.getPSSysBDTableId()) != 0L) {
                this.pssysbdtable = null;
            }
            if (this.pssysbdtable == null) {
                PSSysBDTable pSSysBDTable = new PSSysBDTable();
                pSSysBDTable.setPSSysBDTableId(this.getPSSysBDTableId());
                PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDTableService.autoGet(pSSysBDTable);
                this.pssysbdtable = pSSysBDTable;
            }
            return this.pssysbdtable;
        }
    }

    private PSSysBDColSetBase getProxyEntity() {
        return this.proxyPSSysBDColSetBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDColSetBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDColSetBase) {
            this.proxyPSSysBDColSetBase = (PSSysBDColSetBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSSYSBDCOLSETID, 6);
        fieldIndexMap.put(FIELD_PSSYSBDCOLSETNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEID, 8);
        fieldIndexMap.put(FIELD_PSSYSBDTABLENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
    }
}

