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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDInstCfgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDInstCfgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCBDINSTID = "PSDCBDINSTID";
    public static final String FIELD_PSDCBDINSTNAME = "PSDCBDINSTNAME";
    public static final String FIELD_PSSYSBDINSTCFGID = "PSSYSBDINSTCFGID";
    public static final String FIELD_PSSYSBDINSTCFGNAME = "PSSYSBDINSTCFGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCBDINSTID = 3;
    private static final int INDEX_PSDCBDINSTNAME = 4;
    private static final int INDEX_PSSYSBDINSTCFGID = 5;
    private static final int INDEX_PSSYSBDINSTCFGNAME = 6;
    private static final int INDEX_PSSYSTEMID = 7;
    private static final int INDEX_PSSYSTEMNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERCAT = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_USERTAG3 = 14;
    private static final int INDEX_USERTAG4 = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBDInstCfgBase proxyPSSysBDInstCfgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcbdinstidDirtyFlag = false;
    private boolean psdcbdinstnameDirtyFlag = false;
    private boolean pssysbdinstcfgidDirtyFlag = false;
    private boolean pssysbdinstcfgnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="psdcbdinstid")
    private String psdcbdinstid;
    @Column(name="psdcbdinstname")
    private String psdcbdinstname;
    @Column(name="pssysbdinstcfgid")
    private String pssysbdinstcfgid;
    @Column(name="pssysbdinstcfgname")
    private String pssysbdinstcfgname;
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
    private Integer objPSDCBDInstLock = new Integer(1);
    private PSDCBDInst psdcbdinst = null;
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

    public void setPSDCBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstid = string;
        this.psdcbdinstidDirtyFlag = true;
    }

    public String getPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstId();
        }
        return this.psdcbdinstid;
    }

    public boolean isPSDCBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstIdDirty();
        }
        return this.psdcbdinstidDirtyFlag;
    }

    public void resetPSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstId();
            return;
        }
        this.psdcbdinstidDirtyFlag = false;
        this.psdcbdinstid = null;
    }

    public void setPSDCBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbdinstname = string;
        this.psdcbdinstnameDirtyFlag = true;
    }

    public String getPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInstName();
        }
        return this.psdcbdinstname;
    }

    public boolean isPSDCBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBDInstNameDirty();
        }
        return this.psdcbdinstnameDirtyFlag;
    }

    public void resetPSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBDInstName();
            return;
        }
        this.psdcbdinstnameDirtyFlag = false;
        this.psdcbdinstname = null;
    }

    public void setPSSysBDInstCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDInstCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdinstcfgid = string;
        this.pssysbdinstcfgidDirtyFlag = true;
    }

    public String getPSSysBDInstCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfgId();
        }
        return this.pssysbdinstcfgid;
    }

    public boolean isPSSysBDInstCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDInstCfgIdDirty();
        }
        return this.pssysbdinstcfgidDirtyFlag;
    }

    public void resetPSSysBDInstCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDInstCfgId();
            return;
        }
        this.pssysbdinstcfgidDirtyFlag = false;
        this.pssysbdinstcfgid = null;
    }

    public void setPSSysBDInstCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDInstCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdinstcfgname = string;
        this.pssysbdinstcfgnameDirtyFlag = true;
    }

    public String getPSSysBDInstCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDInstCfgName();
        }
        return this.pssysbdinstcfgname;
    }

    public boolean isPSSysBDInstCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDInstCfgNameDirty();
        }
        return this.pssysbdinstcfgnameDirtyFlag;
    }

    public void resetPSSysBDInstCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDInstCfgName();
            return;
        }
        this.pssysbdinstcfgnameDirtyFlag = false;
        this.pssysbdinstcfgname = null;
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
        PSSysBDInstCfgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDInstCfgBase pSSysBDInstCfgBase) {
        pSSysBDInstCfgBase.resetCreateDate();
        pSSysBDInstCfgBase.resetCreateMan();
        pSSysBDInstCfgBase.resetMemo();
        pSSysBDInstCfgBase.resetPSDCBDInstId();
        pSSysBDInstCfgBase.resetPSDCBDInstName();
        pSSysBDInstCfgBase.resetPSSysBDInstCfgId();
        pSSysBDInstCfgBase.resetPSSysBDInstCfgName();
        pSSysBDInstCfgBase.resetPSSystemId();
        pSSysBDInstCfgBase.resetPSSystemName();
        pSSysBDInstCfgBase.resetUpdateDate();
        pSSysBDInstCfgBase.resetUpdateMan();
        pSSysBDInstCfgBase.resetUserCat();
        pSSysBDInstCfgBase.resetUserTag();
        pSSysBDInstCfgBase.resetUserTag2();
        pSSysBDInstCfgBase.resetUserTag3();
        pSSysBDInstCfgBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCBDInstIdDirty()) {
            hashMap.put(FIELD_PSDCBDINSTID, this.getPSDCBDInstId());
        }
        if (!bl || this.isPSDCBDInstNameDirty()) {
            hashMap.put(FIELD_PSDCBDINSTNAME, this.getPSDCBDInstName());
        }
        if (!bl || this.isPSSysBDInstCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSBDINSTCFGID, this.getPSSysBDInstCfgId());
        }
        if (!bl || this.isPSSysBDInstCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSBDINSTCFGNAME, this.getPSSysBDInstCfgName());
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
        return PSSysBDInstCfgBase.get(this, n);
    }

    private static Object get(PSSysBDInstCfgBase pSSysBDInstCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDInstCfgBase.getCreateDate();
            }
            case 1: {
                return pSSysBDInstCfgBase.getCreateMan();
            }
            case 2: {
                return pSSysBDInstCfgBase.getMemo();
            }
            case 3: {
                return pSSysBDInstCfgBase.getPSDCBDInstId();
            }
            case 4: {
                return pSSysBDInstCfgBase.getPSDCBDInstName();
            }
            case 5: {
                return pSSysBDInstCfgBase.getPSSysBDInstCfgId();
            }
            case 6: {
                return pSSysBDInstCfgBase.getPSSysBDInstCfgName();
            }
            case 7: {
                return pSSysBDInstCfgBase.getPSSystemId();
            }
            case 8: {
                return pSSysBDInstCfgBase.getPSSystemName();
            }
            case 9: {
                return pSSysBDInstCfgBase.getUpdateDate();
            }
            case 10: {
                return pSSysBDInstCfgBase.getUpdateMan();
            }
            case 11: {
                return pSSysBDInstCfgBase.getUserCat();
            }
            case 12: {
                return pSSysBDInstCfgBase.getUserTag();
            }
            case 13: {
                return pSSysBDInstCfgBase.getUserTag2();
            }
            case 14: {
                return pSSysBDInstCfgBase.getUserTag3();
            }
            case 15: {
                return pSSysBDInstCfgBase.getUserTag4();
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
        PSSysBDInstCfgBase.set(this, n, object);
    }

    private static void set(PSSysBDInstCfgBase pSSysBDInstCfgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDInstCfgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDInstCfgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDInstCfgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDInstCfgBase.setPSDCBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDInstCfgBase.setPSDCBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDInstCfgBase.setPSSysBDInstCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDInstCfgBase.setPSSysBDInstCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDInstCfgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDInstCfgBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDInstCfgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDInstCfgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDInstCfgBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDInstCfgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDInstCfgBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDInstCfgBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDInstCfgBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBDInstCfgBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDInstCfgBase pSSysBDInstCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDInstCfgBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysBDInstCfgBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysBDInstCfgBase.getMemo() == null;
            }
            case 3: {
                return pSSysBDInstCfgBase.getPSDCBDInstId() == null;
            }
            case 4: {
                return pSSysBDInstCfgBase.getPSDCBDInstName() == null;
            }
            case 5: {
                return pSSysBDInstCfgBase.getPSSysBDInstCfgId() == null;
            }
            case 6: {
                return pSSysBDInstCfgBase.getPSSysBDInstCfgName() == null;
            }
            case 7: {
                return pSSysBDInstCfgBase.getPSSystemId() == null;
            }
            case 8: {
                return pSSysBDInstCfgBase.getPSSystemName() == null;
            }
            case 9: {
                return pSSysBDInstCfgBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSysBDInstCfgBase.getUpdateMan() == null;
            }
            case 11: {
                return pSSysBDInstCfgBase.getUserCat() == null;
            }
            case 12: {
                return pSSysBDInstCfgBase.getUserTag() == null;
            }
            case 13: {
                return pSSysBDInstCfgBase.getUserTag2() == null;
            }
            case 14: {
                return pSSysBDInstCfgBase.getUserTag3() == null;
            }
            case 15: {
                return pSSysBDInstCfgBase.getUserTag4() == null;
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
        return PSSysBDInstCfgBase.contains(this, n);
    }

    private static boolean contains(PSSysBDInstCfgBase pSSysBDInstCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDInstCfgBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysBDInstCfgBase.isCreateManDirty();
            }
            case 2: {
                return pSSysBDInstCfgBase.isMemoDirty();
            }
            case 3: {
                return pSSysBDInstCfgBase.isPSDCBDInstIdDirty();
            }
            case 4: {
                return pSSysBDInstCfgBase.isPSDCBDInstNameDirty();
            }
            case 5: {
                return pSSysBDInstCfgBase.isPSSysBDInstCfgIdDirty();
            }
            case 6: {
                return pSSysBDInstCfgBase.isPSSysBDInstCfgNameDirty();
            }
            case 7: {
                return pSSysBDInstCfgBase.isPSSystemIdDirty();
            }
            case 8: {
                return pSSysBDInstCfgBase.isPSSystemNameDirty();
            }
            case 9: {
                return pSSysBDInstCfgBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSysBDInstCfgBase.isUpdateManDirty();
            }
            case 11: {
                return pSSysBDInstCfgBase.isUserCatDirty();
            }
            case 12: {
                return pSSysBDInstCfgBase.isUserTagDirty();
            }
            case 13: {
                return pSSysBDInstCfgBase.isUserTag2Dirty();
            }
            case 14: {
                return pSSysBDInstCfgBase.isUserTag3Dirty();
            }
            case 15: {
                return pSSysBDInstCfgBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDInstCfgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDInstCfgBase pSSysBDInstCfgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDInstCfgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getPSDCBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstid", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getPSDCBDInstId()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getPSDCBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbdinstname", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getPSDCBDInstName()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getPSSysBDInstCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdinstcfgid", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getPSSysBDInstCfgId()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getPSSysBDInstCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdinstcfgname", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getPSSysBDInstCfgName()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDInstCfgBase.getJSONValue((Object)pSSysBDInstCfgBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDInstCfgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDInstCfgBase pSSysBDInstCfgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDInstCfgBase.getCreateDate() != null) {
            object = pSSysBDInstCfgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDInstCfgBase.getCreateMan() != null) {
            object = pSSysBDInstCfgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getMemo() != null) {
            object = pSSysBDInstCfgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getPSDCBDInstId() != null) {
            object = pSSysBDInstCfgBase.getPSDCBDInstId();
            xmlNode.setAttribute(FIELD_PSDCBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getPSDCBDInstName() != null) {
            object = pSSysBDInstCfgBase.getPSDCBDInstName();
            xmlNode.setAttribute(FIELD_PSDCBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getPSSysBDInstCfgId() != null) {
            object = pSSysBDInstCfgBase.getPSSysBDInstCfgId();
            xmlNode.setAttribute(FIELD_PSSYSBDINSTCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getPSSysBDInstCfgName() != null) {
            object = pSSysBDInstCfgBase.getPSSysBDInstCfgName();
            xmlNode.setAttribute(FIELD_PSSYSBDINSTCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getPSSystemId() != null) {
            object = pSSysBDInstCfgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getPSSystemName() != null) {
            object = pSSysBDInstCfgBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getUpdateDate() != null) {
            object = pSSysBDInstCfgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDInstCfgBase.getUpdateMan() != null) {
            object = pSSysBDInstCfgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getUserCat() != null) {
            object = pSSysBDInstCfgBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag() != null) {
            object = pSSysBDInstCfgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag2() != null) {
            object = pSSysBDInstCfgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag3() != null) {
            object = pSSysBDInstCfgBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDInstCfgBase.getUserTag4() != null) {
            object = pSSysBDInstCfgBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDInstCfgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDInstCfgBase pSSysBDInstCfgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDInstCfgBase.isCreateDateDirty() && (bl || pSSysBDInstCfgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDInstCfgBase.getCreateDate());
        }
        if (pSSysBDInstCfgBase.isCreateManDirty() && (bl || pSSysBDInstCfgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDInstCfgBase.getCreateMan());
        }
        if (pSSysBDInstCfgBase.isMemoDirty() && (bl || pSSysBDInstCfgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDInstCfgBase.getMemo());
        }
        if (pSSysBDInstCfgBase.isPSDCBDInstIdDirty() && (bl || pSSysBDInstCfgBase.getPSDCBDInstId() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTID, (Object)pSSysBDInstCfgBase.getPSDCBDInstId());
        }
        if (pSSysBDInstCfgBase.isPSDCBDInstNameDirty() && (bl || pSSysBDInstCfgBase.getPSDCBDInstName() != null)) {
            iDataObject.set(FIELD_PSDCBDINSTNAME, (Object)pSSysBDInstCfgBase.getPSDCBDInstName());
        }
        if (pSSysBDInstCfgBase.isPSSysBDInstCfgIdDirty() && (bl || pSSysBDInstCfgBase.getPSSysBDInstCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSBDINSTCFGID, (Object)pSSysBDInstCfgBase.getPSSysBDInstCfgId());
        }
        if (pSSysBDInstCfgBase.isPSSysBDInstCfgNameDirty() && (bl || pSSysBDInstCfgBase.getPSSysBDInstCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSBDINSTCFGNAME, (Object)pSSysBDInstCfgBase.getPSSysBDInstCfgName());
        }
        if (pSSysBDInstCfgBase.isPSSystemIdDirty() && (bl || pSSysBDInstCfgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysBDInstCfgBase.getPSSystemId());
        }
        if (pSSysBDInstCfgBase.isPSSystemNameDirty() && (bl || pSSysBDInstCfgBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysBDInstCfgBase.getPSSystemName());
        }
        if (pSSysBDInstCfgBase.isUpdateDateDirty() && (bl || pSSysBDInstCfgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDInstCfgBase.getUpdateDate());
        }
        if (pSSysBDInstCfgBase.isUpdateManDirty() && (bl || pSSysBDInstCfgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDInstCfgBase.getUpdateMan());
        }
        if (pSSysBDInstCfgBase.isUserCatDirty() && (bl || pSSysBDInstCfgBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDInstCfgBase.getUserCat());
        }
        if (pSSysBDInstCfgBase.isUserTagDirty() && (bl || pSSysBDInstCfgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDInstCfgBase.getUserTag());
        }
        if (pSSysBDInstCfgBase.isUserTag2Dirty() && (bl || pSSysBDInstCfgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDInstCfgBase.getUserTag2());
        }
        if (pSSysBDInstCfgBase.isUserTag3Dirty() && (bl || pSSysBDInstCfgBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDInstCfgBase.getUserTag3());
        }
        if (pSSysBDInstCfgBase.isUserTag4Dirty() && (bl || pSSysBDInstCfgBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDInstCfgBase.getUserTag4());
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
        return PSSysBDInstCfgBase.remove(this, n);
    }

    private static boolean remove(PSSysBDInstCfgBase pSSysBDInstCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDInstCfgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysBDInstCfgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysBDInstCfgBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysBDInstCfgBase.resetPSDCBDInstId();
                return true;
            }
            case 4: {
                pSSysBDInstCfgBase.resetPSDCBDInstName();
                return true;
            }
            case 5: {
                pSSysBDInstCfgBase.resetPSSysBDInstCfgId();
                return true;
            }
            case 6: {
                pSSysBDInstCfgBase.resetPSSysBDInstCfgName();
                return true;
            }
            case 7: {
                pSSysBDInstCfgBase.resetPSSystemId();
                return true;
            }
            case 8: {
                pSSysBDInstCfgBase.resetPSSystemName();
                return true;
            }
            case 9: {
                pSSysBDInstCfgBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSysBDInstCfgBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSSysBDInstCfgBase.resetUserCat();
                return true;
            }
            case 12: {
                pSSysBDInstCfgBase.resetUserTag();
                return true;
            }
            case 13: {
                pSSysBDInstCfgBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSSysBDInstCfgBase.resetUserTag3();
                return true;
            }
            case 15: {
                pSSysBDInstCfgBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCBDInst getPSDCBDInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBDInst();
        }
        if (this.getPSDCBDInstId() == null) {
            return null;
        }
        Integer n = this.objPSDCBDInstLock;
        synchronized (n) {
            if (this.psdcbdinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCBDInstId(), (Object)this.psdcbdinst.getPSDCBDInstId()) != 0L) {
                this.psdcbdinst = null;
            }
            if (this.psdcbdinst == null) {
                PSDCBDInst pSDCBDInst = new PSDCBDInst();
                pSDCBDInst.setPSDCBDInstId(this.getPSDCBDInstId());
                PSDCBDInstService pSDCBDInstService = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCBDInstService.autoGet(pSDCBDInst);
                this.psdcbdinst = pSDCBDInst;
            }
            return this.psdcbdinst;
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

    private PSSysBDInstCfgBase getProxyEntity() {
        return this.proxyPSSysBDInstCfgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDInstCfgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDInstCfgBase) {
            this.proxyPSSysBDInstCfgBase = (PSSysBDInstCfgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCBDINSTID, 3);
        fieldIndexMap.put(FIELD_PSDCBDINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSBDINSTCFGID, 5);
        fieldIndexMap.put(FIELD_PSSYSBDINSTCFGNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERCAT, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
        fieldIndexMap.put(FIELD_USERTAG3, 14);
        fieldIndexMap.put(FIELD_USERTAG4, 15);
    }
}

