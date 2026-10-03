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
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDTableDERBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDTableDERBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DERLEVEL = "DERLEVEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSSYSBDTABLEDERID = "PSSYSBDTABLEDERID";
    public static final String FIELD_PSSYSBDTABLEDERNAME = "PSSYSBDTABLEDERNAME";
    public static final String FIELD_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String FIELD_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DERLEVEL = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDERID = 4;
    private static final int INDEX_PSDERNAME = 5;
    private static final int INDEX_PSSYSBDTABLEDERID = 6;
    private static final int INDEX_PSSYSBDTABLEDERNAME = 7;
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
    private PSSysBDTableDERBase proxyPSSysBDTableDERBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean derlevelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean pssysbdtablederidDirtyFlag = false;
    private boolean pssysbdtabledernameDirtyFlag = false;
    private boolean pssysbdtableidDirtyFlag = false;
    private boolean pssysbdtablenameDirtyFlag = false;
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
    @Column(name="derlevel")
    private Integer derlevel;
    @Column(name="memo")
    private String memo;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="pssysbdtablederid")
    private String pssysbdtablederid;
    @Column(name="pssysbdtabledername")
    private String pssysbdtabledername;
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
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objPSSysBDTableLock = new Integer(1);
    private PSSysBDTable pssysbdtable = null;

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

    public void setDERLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERLevel(n);
            return;
        }
        this.derlevel = n;
        this.derlevelDirtyFlag = true;
    }

    public Integer getDERLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERLevel();
        }
        return this.derlevel;
    }

    public boolean isDERLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERLevelDirty();
        }
        return this.derlevelDirtyFlag;
    }

    public void resetDERLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERLevel();
            return;
        }
        this.derlevelDirtyFlag = false;
        this.derlevel = null;
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

    public void setPSSysBDTableDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtablederid = string;
        this.pssysbdtablederidDirtyFlag = true;
    }

    public String getPSSysBDTableDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDERId();
        }
        return this.pssysbdtablederid;
    }

    public boolean isPSSysBDTableDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableDERIdDirty();
        }
        return this.pssysbdtablederidDirtyFlag;
    }

    public void resetPSSysBDTableDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableDERId();
            return;
        }
        this.pssysbdtablederidDirtyFlag = false;
        this.pssysbdtablederid = null;
    }

    public void setPSSysBDTableDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtabledername = string;
        this.pssysbdtabledernameDirtyFlag = true;
    }

    public String getPSSysBDTableDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDERName();
        }
        return this.pssysbdtabledername;
    }

    public boolean isPSSysBDTableDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableDERNameDirty();
        }
        return this.pssysbdtabledernameDirtyFlag;
    }

    public void resetPSSysBDTableDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableDERName();
            return;
        }
        this.pssysbdtabledernameDirtyFlag = false;
        this.pssysbdtabledername = null;
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
        PSSysBDTableDERBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDTableDERBase pSSysBDTableDERBase) {
        pSSysBDTableDERBase.resetCreateDate();
        pSSysBDTableDERBase.resetCreateMan();
        pSSysBDTableDERBase.resetDERLevel();
        pSSysBDTableDERBase.resetMemo();
        pSSysBDTableDERBase.resetPSDERId();
        pSSysBDTableDERBase.resetPSDERName();
        pSSysBDTableDERBase.resetPSSysBDTableDERId();
        pSSysBDTableDERBase.resetPSSysBDTableDERName();
        pSSysBDTableDERBase.resetPSSysBDTableId();
        pSSysBDTableDERBase.resetPSSysBDTableName();
        pSSysBDTableDERBase.resetUpdateDate();
        pSSysBDTableDERBase.resetUpdateMan();
        pSSysBDTableDERBase.resetUserCat();
        pSSysBDTableDERBase.resetUserTag();
        pSSysBDTableDERBase.resetUserTag2();
        pSSysBDTableDERBase.resetUserTag3();
        pSSysBDTableDERBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDERLevelDirty()) {
            hashMap.put(FIELD_DERLEVEL, this.getDERLevel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSSysBDTableDERIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEDERID, this.getPSSysBDTableDERId());
        }
        if (!bl || this.isPSSysBDTableDERNameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEDERNAME, this.getPSSysBDTableDERName());
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
        return PSSysBDTableDERBase.get(this, n);
    }

    private static Object get(PSSysBDTableDERBase pSSysBDTableDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableDERBase.getCreateDate();
            }
            case 1: {
                return pSSysBDTableDERBase.getCreateMan();
            }
            case 2: {
                return pSSysBDTableDERBase.getDERLevel();
            }
            case 3: {
                return pSSysBDTableDERBase.getMemo();
            }
            case 4: {
                return pSSysBDTableDERBase.getPSDERId();
            }
            case 5: {
                return pSSysBDTableDERBase.getPSDERName();
            }
            case 6: {
                return pSSysBDTableDERBase.getPSSysBDTableDERId();
            }
            case 7: {
                return pSSysBDTableDERBase.getPSSysBDTableDERName();
            }
            case 8: {
                return pSSysBDTableDERBase.getPSSysBDTableId();
            }
            case 9: {
                return pSSysBDTableDERBase.getPSSysBDTableName();
            }
            case 10: {
                return pSSysBDTableDERBase.getUpdateDate();
            }
            case 11: {
                return pSSysBDTableDERBase.getUpdateMan();
            }
            case 12: {
                return pSSysBDTableDERBase.getUserCat();
            }
            case 13: {
                return pSSysBDTableDERBase.getUserTag();
            }
            case 14: {
                return pSSysBDTableDERBase.getUserTag2();
            }
            case 15: {
                return pSSysBDTableDERBase.getUserTag3();
            }
            case 16: {
                return pSSysBDTableDERBase.getUserTag4();
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
        PSSysBDTableDERBase.set(this, n, object);
    }

    private static void set(PSSysBDTableDERBase pSSysBDTableDERBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDTableDERBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDTableDERBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDTableDERBase.setDERLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDTableDERBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDTableDERBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDTableDERBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDTableDERBase.setPSSysBDTableDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDTableDERBase.setPSSysBDTableDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDTableDERBase.setPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDTableDERBase.setPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDTableDERBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDTableDERBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDTableDERBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDTableDERBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDTableDERBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDTableDERBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBDTableDERBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBDTableDERBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDTableDERBase pSSysBDTableDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableDERBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysBDTableDERBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysBDTableDERBase.getDERLevel() == null;
            }
            case 3: {
                return pSSysBDTableDERBase.getMemo() == null;
            }
            case 4: {
                return pSSysBDTableDERBase.getPSDERId() == null;
            }
            case 5: {
                return pSSysBDTableDERBase.getPSDERName() == null;
            }
            case 6: {
                return pSSysBDTableDERBase.getPSSysBDTableDERId() == null;
            }
            case 7: {
                return pSSysBDTableDERBase.getPSSysBDTableDERName() == null;
            }
            case 8: {
                return pSSysBDTableDERBase.getPSSysBDTableId() == null;
            }
            case 9: {
                return pSSysBDTableDERBase.getPSSysBDTableName() == null;
            }
            case 10: {
                return pSSysBDTableDERBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysBDTableDERBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysBDTableDERBase.getUserCat() == null;
            }
            case 13: {
                return pSSysBDTableDERBase.getUserTag() == null;
            }
            case 14: {
                return pSSysBDTableDERBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysBDTableDERBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysBDTableDERBase.getUserTag4() == null;
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
        return PSSysBDTableDERBase.contains(this, n);
    }

    private static boolean contains(PSSysBDTableDERBase pSSysBDTableDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDTableDERBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysBDTableDERBase.isCreateManDirty();
            }
            case 2: {
                return pSSysBDTableDERBase.isDERLevelDirty();
            }
            case 3: {
                return pSSysBDTableDERBase.isMemoDirty();
            }
            case 4: {
                return pSSysBDTableDERBase.isPSDERIdDirty();
            }
            case 5: {
                return pSSysBDTableDERBase.isPSDERNameDirty();
            }
            case 6: {
                return pSSysBDTableDERBase.isPSSysBDTableDERIdDirty();
            }
            case 7: {
                return pSSysBDTableDERBase.isPSSysBDTableDERNameDirty();
            }
            case 8: {
                return pSSysBDTableDERBase.isPSSysBDTableIdDirty();
            }
            case 9: {
                return pSSysBDTableDERBase.isPSSysBDTableNameDirty();
            }
            case 10: {
                return pSSysBDTableDERBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysBDTableDERBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysBDTableDERBase.isUserCatDirty();
            }
            case 13: {
                return pSSysBDTableDERBase.isUserTagDirty();
            }
            case 14: {
                return pSSysBDTableDERBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysBDTableDERBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysBDTableDERBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDTableDERBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDTableDERBase pSSysBDTableDERBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDTableDERBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getDERLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derlevel", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getDERLevel()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablederid", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getPSSysBDTableDERId()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtabledername", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getPSSysBDTableDERName()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtableid", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablename", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDTableDERBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDTableDERBase.getJSONValue((Object)pSSysBDTableDERBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDTableDERBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDTableDERBase pSSysBDTableDERBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDTableDERBase.getCreateDate() != null) {
            object = pSSysBDTableDERBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDTableDERBase.getCreateMan() != null) {
            object = pSSysBDTableDERBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getDERLevel() != null) {
            object = pSSysBDTableDERBase.getDERLevel();
            xmlNode.setAttribute(FIELD_DERLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDTableDERBase.getMemo() != null) {
            object = pSSysBDTableDERBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getPSDERId() != null) {
            object = pSSysBDTableDERBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getPSDERName() != null) {
            object = pSSysBDTableDERBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableDERId() != null) {
            object = pSSysBDTableDERBase.getPSSysBDTableDERId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableDERName() != null) {
            object = pSSysBDTableDERBase.getPSSysBDTableDERName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableId() != null) {
            object = pSSysBDTableDERBase.getPSSysBDTableId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getPSSysBDTableName() != null) {
            object = pSSysBDTableDERBase.getPSSysBDTableName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getUpdateDate() != null) {
            object = pSSysBDTableDERBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDTableDERBase.getUpdateMan() != null) {
            object = pSSysBDTableDERBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getUserCat() != null) {
            object = pSSysBDTableDERBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getUserTag() != null) {
            object = pSSysBDTableDERBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getUserTag2() != null) {
            object = pSSysBDTableDERBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getUserTag3() != null) {
            object = pSSysBDTableDERBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDTableDERBase.getUserTag4() != null) {
            object = pSSysBDTableDERBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDTableDERBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDTableDERBase pSSysBDTableDERBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDTableDERBase.isCreateDateDirty() && (bl || pSSysBDTableDERBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDTableDERBase.getCreateDate());
        }
        if (pSSysBDTableDERBase.isCreateManDirty() && (bl || pSSysBDTableDERBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDTableDERBase.getCreateMan());
        }
        if (pSSysBDTableDERBase.isDERLevelDirty() && (bl || pSSysBDTableDERBase.getDERLevel() != null)) {
            iDataObject.set(FIELD_DERLEVEL, (Object)pSSysBDTableDERBase.getDERLevel());
        }
        if (pSSysBDTableDERBase.isMemoDirty() && (bl || pSSysBDTableDERBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDTableDERBase.getMemo());
        }
        if (pSSysBDTableDERBase.isPSDERIdDirty() && (bl || pSSysBDTableDERBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSSysBDTableDERBase.getPSDERId());
        }
        if (pSSysBDTableDERBase.isPSDERNameDirty() && (bl || pSSysBDTableDERBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSSysBDTableDERBase.getPSDERName());
        }
        if (pSSysBDTableDERBase.isPSSysBDTableDERIdDirty() && (bl || pSSysBDTableDERBase.getPSSysBDTableDERId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEDERID, (Object)pSSysBDTableDERBase.getPSSysBDTableDERId());
        }
        if (pSSysBDTableDERBase.isPSSysBDTableDERNameDirty() && (bl || pSSysBDTableDERBase.getPSSysBDTableDERName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEDERNAME, (Object)pSSysBDTableDERBase.getPSSysBDTableDERName());
        }
        if (pSSysBDTableDERBase.isPSSysBDTableIdDirty() && (bl || pSSysBDTableDERBase.getPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEID, (Object)pSSysBDTableDERBase.getPSSysBDTableId());
        }
        if (pSSysBDTableDERBase.isPSSysBDTableNameDirty() && (bl || pSSysBDTableDERBase.getPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLENAME, (Object)pSSysBDTableDERBase.getPSSysBDTableName());
        }
        if (pSSysBDTableDERBase.isUpdateDateDirty() && (bl || pSSysBDTableDERBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDTableDERBase.getUpdateDate());
        }
        if (pSSysBDTableDERBase.isUpdateManDirty() && (bl || pSSysBDTableDERBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDTableDERBase.getUpdateMan());
        }
        if (pSSysBDTableDERBase.isUserCatDirty() && (bl || pSSysBDTableDERBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDTableDERBase.getUserCat());
        }
        if (pSSysBDTableDERBase.isUserTagDirty() && (bl || pSSysBDTableDERBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDTableDERBase.getUserTag());
        }
        if (pSSysBDTableDERBase.isUserTag2Dirty() && (bl || pSSysBDTableDERBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDTableDERBase.getUserTag2());
        }
        if (pSSysBDTableDERBase.isUserTag3Dirty() && (bl || pSSysBDTableDERBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDTableDERBase.getUserTag3());
        }
        if (pSSysBDTableDERBase.isUserTag4Dirty() && (bl || pSSysBDTableDERBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDTableDERBase.getUserTag4());
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
        return PSSysBDTableDERBase.remove(this, n);
    }

    private static boolean remove(PSSysBDTableDERBase pSSysBDTableDERBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDTableDERBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysBDTableDERBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysBDTableDERBase.resetDERLevel();
                return true;
            }
            case 3: {
                pSSysBDTableDERBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysBDTableDERBase.resetPSDERId();
                return true;
            }
            case 5: {
                pSSysBDTableDERBase.resetPSDERName();
                return true;
            }
            case 6: {
                pSSysBDTableDERBase.resetPSSysBDTableDERId();
                return true;
            }
            case 7: {
                pSSysBDTableDERBase.resetPSSysBDTableDERName();
                return true;
            }
            case 8: {
                pSSysBDTableDERBase.resetPSSysBDTableId();
                return true;
            }
            case 9: {
                pSSysBDTableDERBase.resetPSSysBDTableName();
                return true;
            }
            case 10: {
                pSSysBDTableDERBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysBDTableDERBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysBDTableDERBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysBDTableDERBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysBDTableDERBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysBDTableDERBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysBDTableDERBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSSysBDTableDERBase getProxyEntity() {
        return this.proxyPSSysBDTableDERBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDTableDERBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDTableDERBase) {
            this.proxyPSSysBDTableDERBase = (PSSysBDTableDERBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DERLEVEL, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDERID, 4);
        fieldIndexMap.put(FIELD_PSDERNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEDERID, 6);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEDERNAME, 7);
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

