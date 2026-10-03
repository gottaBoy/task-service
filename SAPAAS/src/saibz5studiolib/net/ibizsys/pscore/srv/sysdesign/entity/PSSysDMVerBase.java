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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDMVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDMVerBase.class);
    public static final String FIELD_ACTIVEFLAG = "ACTIVEFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DMVER = "DMVER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSDMVERID = "PSSYSDMVERID";
    public static final String FIELD_PSSYSDMVERNAME = "PSSYSDMVERNAME";
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
    private static final int INDEX_ACTIVEFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DMVER = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSSYSDMVERID = 5;
    private static final int INDEX_PSSYSDMVERNAME = 6;
    private static final int INDEX_PSSYSTEMID = 7;
    private static final int INDEX_PSSYSTEMNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERCAT = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_USERTAG3 = 14;
    private static final int INDEX_USERTAG4 = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDMVerBase proxyPSSysDMVerBase = null;
    private boolean activeflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dmverDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysdmveridDirtyFlag = false;
    private boolean pssysdmvernameDirtyFlag = false;
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
    @Column(name="activeflag")
    private Integer activeflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dmver")
    private Integer dmver;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysdmverid")
    private String pssysdmverid;
    @Column(name="pssysdmvername")
    private String pssysdmvername;
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
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysDMVerItemsLock = new Integer(1);
    private ArrayList<PSSysDMVerItem> pssysdmveritems = null;

    public void setActiveFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActiveFlag(n);
            return;
        }
        this.activeflag = n;
        this.activeflagDirtyFlag = true;
    }

    public Integer getActiveFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActiveFlag();
        }
        return this.activeflag;
    }

    public boolean isActiveFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActiveFlagDirty();
        }
        return this.activeflagDirtyFlag;
    }

    public void resetActiveFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActiveFlag();
            return;
        }
        this.activeflagDirtyFlag = false;
        this.activeflag = null;
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

    public void setDMVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDMVer(n);
            return;
        }
        this.dmver = n;
        this.dmverDirtyFlag = true;
    }

    public Integer getDMVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDMVer();
        }
        return this.dmver;
    }

    public boolean isDMVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDMVerDirty();
        }
        return this.dmverDirtyFlag;
    }

    public void resetDMVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDMVer();
            return;
        }
        this.dmverDirtyFlag = false;
        this.dmver = null;
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

    public void setPSSysDMVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdmverid = string;
        this.pssysdmveridDirtyFlag = true;
    }

    public String getPSSysDMVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVerId();
        }
        return this.pssysdmverid;
    }

    public boolean isPSSysDMVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMVerIdDirty();
        }
        return this.pssysdmveridDirtyFlag;
    }

    public void resetPSSysDMVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMVerId();
            return;
        }
        this.pssysdmveridDirtyFlag = false;
        this.pssysdmverid = null;
    }

    public void setPSSysDMVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdmvername = string;
        this.pssysdmvernameDirtyFlag = true;
    }

    public String getPSSysDMVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVerName();
        }
        return this.pssysdmvername;
    }

    public boolean isPSSysDMVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMVerNameDirty();
        }
        return this.pssysdmvernameDirtyFlag;
    }

    public void resetPSSysDMVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMVerName();
            return;
        }
        this.pssysdmvernameDirtyFlag = false;
        this.pssysdmvername = null;
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

    protected void onReset() {
        PSSysDMVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDMVerBase pSSysDMVerBase) {
        pSSysDMVerBase.resetActiveFlag();
        pSSysDMVerBase.resetCreateDate();
        pSSysDMVerBase.resetCreateMan();
        pSSysDMVerBase.resetDMVer();
        pSSysDMVerBase.resetMemo();
        pSSysDMVerBase.resetPSSysDMVerId();
        pSSysDMVerBase.resetPSSysDMVerName();
        pSSysDMVerBase.resetPSSystemId();
        pSSysDMVerBase.resetPSSystemName();
        pSSysDMVerBase.resetUpdateDate();
        pSSysDMVerBase.resetUpdateMan();
        pSSysDMVerBase.resetUserCat();
        pSSysDMVerBase.resetUserTag();
        pSSysDMVerBase.resetUserTag2();
        pSSysDMVerBase.resetUserTag3();
        pSSysDMVerBase.resetUserTag4();
        pSSysDMVerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActiveFlagDirty()) {
            hashMap.put(FIELD_ACTIVEFLAG, this.getActiveFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDMVerDirty()) {
            hashMap.put(FIELD_DMVER, this.getDMVer());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysDMVerIdDirty()) {
            hashMap.put(FIELD_PSSYSDMVERID, this.getPSSysDMVerId());
        }
        if (!bl || this.isPSSysDMVerNameDirty()) {
            hashMap.put(FIELD_PSSYSDMVERNAME, this.getPSSysDMVerName());
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
        return PSSysDMVerBase.get(this, n);
    }

    private static Object get(PSSysDMVerBase pSSysDMVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMVerBase.getActiveFlag();
            }
            case 1: {
                return pSSysDMVerBase.getCreateDate();
            }
            case 2: {
                return pSSysDMVerBase.getCreateMan();
            }
            case 3: {
                return pSSysDMVerBase.getDMVer();
            }
            case 4: {
                return pSSysDMVerBase.getMemo();
            }
            case 5: {
                return pSSysDMVerBase.getPSSysDMVerId();
            }
            case 6: {
                return pSSysDMVerBase.getPSSysDMVerName();
            }
            case 7: {
                return pSSysDMVerBase.getPSSystemId();
            }
            case 8: {
                return pSSysDMVerBase.getPSSystemName();
            }
            case 9: {
                return pSSysDMVerBase.getUpdateDate();
            }
            case 10: {
                return pSSysDMVerBase.getUpdateMan();
            }
            case 11: {
                return pSSysDMVerBase.getUserCat();
            }
            case 12: {
                return pSSysDMVerBase.getUserTag();
            }
            case 13: {
                return pSSysDMVerBase.getUserTag2();
            }
            case 14: {
                return pSSysDMVerBase.getUserTag3();
            }
            case 15: {
                return pSSysDMVerBase.getUserTag4();
            }
            case 16: {
                return pSSysDMVerBase.getValidFlag();
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
        PSSysDMVerBase.set(this, n, object);
    }

    private static void set(PSSysDMVerBase pSSysDMVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDMVerBase.setActiveFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysDMVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDMVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDMVerBase.setDMVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysDMVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDMVerBase.setPSSysDMVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDMVerBase.setPSSysDMVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDMVerBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDMVerBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDMVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysDMVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDMVerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDMVerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDMVerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDMVerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDMVerBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDMVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysDMVerBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDMVerBase pSSysDMVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMVerBase.getActiveFlag() == null;
            }
            case 1: {
                return pSSysDMVerBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDMVerBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDMVerBase.getDMVer() == null;
            }
            case 4: {
                return pSSysDMVerBase.getMemo() == null;
            }
            case 5: {
                return pSSysDMVerBase.getPSSysDMVerId() == null;
            }
            case 6: {
                return pSSysDMVerBase.getPSSysDMVerName() == null;
            }
            case 7: {
                return pSSysDMVerBase.getPSSystemId() == null;
            }
            case 8: {
                return pSSysDMVerBase.getPSSystemName() == null;
            }
            case 9: {
                return pSSysDMVerBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSysDMVerBase.getUpdateMan() == null;
            }
            case 11: {
                return pSSysDMVerBase.getUserCat() == null;
            }
            case 12: {
                return pSSysDMVerBase.getUserTag() == null;
            }
            case 13: {
                return pSSysDMVerBase.getUserTag2() == null;
            }
            case 14: {
                return pSSysDMVerBase.getUserTag3() == null;
            }
            case 15: {
                return pSSysDMVerBase.getUserTag4() == null;
            }
            case 16: {
                return pSSysDMVerBase.getValidFlag() == null;
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
        return PSSysDMVerBase.contains(this, n);
    }

    private static boolean contains(PSSysDMVerBase pSSysDMVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMVerBase.isActiveFlagDirty();
            }
            case 1: {
                return pSSysDMVerBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDMVerBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDMVerBase.isDMVerDirty();
            }
            case 4: {
                return pSSysDMVerBase.isMemoDirty();
            }
            case 5: {
                return pSSysDMVerBase.isPSSysDMVerIdDirty();
            }
            case 6: {
                return pSSysDMVerBase.isPSSysDMVerNameDirty();
            }
            case 7: {
                return pSSysDMVerBase.isPSSystemIdDirty();
            }
            case 8: {
                return pSSysDMVerBase.isPSSystemNameDirty();
            }
            case 9: {
                return pSSysDMVerBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSysDMVerBase.isUpdateManDirty();
            }
            case 11: {
                return pSSysDMVerBase.isUserCatDirty();
            }
            case 12: {
                return pSSysDMVerBase.isUserTagDirty();
            }
            case 13: {
                return pSSysDMVerBase.isUserTag2Dirty();
            }
            case 14: {
                return pSSysDMVerBase.isUserTag3Dirty();
            }
            case 15: {
                return pSSysDMVerBase.isUserTag4Dirty();
            }
            case 16: {
                return pSSysDMVerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDMVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDMVerBase pSSysDMVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDMVerBase.getActiveFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"activeflag", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getActiveFlag()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getDMVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dmver", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getDMVer()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getPSSysDMVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmverid", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getPSSysDMVerId()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getPSSysDMVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmvername", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getPSSysDMVerName()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysDMVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysDMVerBase.getJSONValue((Object)pSSysDMVerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDMVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDMVerBase pSSysDMVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDMVerBase.getActiveFlag() != null) {
            object = pSSysDMVerBase.getActiveFlag();
            xmlNode.setAttribute(FIELD_ACTIVEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDMVerBase.getCreateDate() != null) {
            object = pSSysDMVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDMVerBase.getCreateMan() != null) {
            object = pSSysDMVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getDMVer() != null) {
            object = pSSysDMVerBase.getDMVer();
            xmlNode.setAttribute(FIELD_DMVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDMVerBase.getMemo() != null) {
            object = pSSysDMVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getPSSysDMVerId() != null) {
            object = pSSysDMVerBase.getPSSysDMVerId();
            xmlNode.setAttribute(FIELD_PSSYSDMVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getPSSysDMVerName() != null) {
            object = pSSysDMVerBase.getPSSysDMVerName();
            xmlNode.setAttribute(FIELD_PSSYSDMVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getPSSystemId() != null) {
            object = pSSysDMVerBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getPSSystemName() != null) {
            object = pSSysDMVerBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getUpdateDate() != null) {
            object = pSSysDMVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDMVerBase.getUpdateMan() != null) {
            object = pSSysDMVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getUserCat() != null) {
            object = pSSysDMVerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getUserTag() != null) {
            object = pSSysDMVerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getUserTag2() != null) {
            object = pSSysDMVerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getUserTag3() != null) {
            object = pSSysDMVerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getUserTag4() != null) {
            object = pSSysDMVerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMVerBase.getValidFlag() != null) {
            object = pSSysDMVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDMVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDMVerBase pSSysDMVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDMVerBase.isActiveFlagDirty() && (bl || pSSysDMVerBase.getActiveFlag() != null)) {
            iDataObject.set(FIELD_ACTIVEFLAG, (Object)pSSysDMVerBase.getActiveFlag());
        }
        if (pSSysDMVerBase.isCreateDateDirty() && (bl || pSSysDMVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDMVerBase.getCreateDate());
        }
        if (pSSysDMVerBase.isCreateManDirty() && (bl || pSSysDMVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDMVerBase.getCreateMan());
        }
        if (pSSysDMVerBase.isDMVerDirty() && (bl || pSSysDMVerBase.getDMVer() != null)) {
            iDataObject.set(FIELD_DMVER, (Object)pSSysDMVerBase.getDMVer());
        }
        if (pSSysDMVerBase.isMemoDirty() && (bl || pSSysDMVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDMVerBase.getMemo());
        }
        if (pSSysDMVerBase.isPSSysDMVerIdDirty() && (bl || pSSysDMVerBase.getPSSysDMVerId() != null)) {
            iDataObject.set(FIELD_PSSYSDMVERID, (Object)pSSysDMVerBase.getPSSysDMVerId());
        }
        if (pSSysDMVerBase.isPSSysDMVerNameDirty() && (bl || pSSysDMVerBase.getPSSysDMVerName() != null)) {
            iDataObject.set(FIELD_PSSYSDMVERNAME, (Object)pSSysDMVerBase.getPSSysDMVerName());
        }
        if (pSSysDMVerBase.isPSSystemIdDirty() && (bl || pSSysDMVerBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDMVerBase.getPSSystemId());
        }
        if (pSSysDMVerBase.isPSSystemNameDirty() && (bl || pSSysDMVerBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDMVerBase.getPSSystemName());
        }
        if (pSSysDMVerBase.isUpdateDateDirty() && (bl || pSSysDMVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDMVerBase.getUpdateDate());
        }
        if (pSSysDMVerBase.isUpdateManDirty() && (bl || pSSysDMVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDMVerBase.getUpdateMan());
        }
        if (pSSysDMVerBase.isUserCatDirty() && (bl || pSSysDMVerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDMVerBase.getUserCat());
        }
        if (pSSysDMVerBase.isUserTagDirty() && (bl || pSSysDMVerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDMVerBase.getUserTag());
        }
        if (pSSysDMVerBase.isUserTag2Dirty() && (bl || pSSysDMVerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDMVerBase.getUserTag2());
        }
        if (pSSysDMVerBase.isUserTag3Dirty() && (bl || pSSysDMVerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDMVerBase.getUserTag3());
        }
        if (pSSysDMVerBase.isUserTag4Dirty() && (bl || pSSysDMVerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDMVerBase.getUserTag4());
        }
        if (pSSysDMVerBase.isValidFlagDirty() && (bl || pSSysDMVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysDMVerBase.getValidFlag());
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
        return PSSysDMVerBase.remove(this, n);
    }

    private static boolean remove(PSSysDMVerBase pSSysDMVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDMVerBase.resetActiveFlag();
                return true;
            }
            case 1: {
                pSSysDMVerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDMVerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDMVerBase.resetDMVer();
                return true;
            }
            case 4: {
                pSSysDMVerBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysDMVerBase.resetPSSysDMVerId();
                return true;
            }
            case 6: {
                pSSysDMVerBase.resetPSSysDMVerName();
                return true;
            }
            case 7: {
                pSSysDMVerBase.resetPSSystemId();
                return true;
            }
            case 8: {
                pSSysDMVerBase.resetPSSystemName();
                return true;
            }
            case 9: {
                pSSysDMVerBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSysDMVerBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSSysDMVerBase.resetUserCat();
                return true;
            }
            case 12: {
                pSSysDMVerBase.resetUserTag();
                return true;
            }
            case 13: {
                pSSysDMVerBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSSysDMVerBase.resetUserTag3();
                return true;
            }
            case 15: {
                pSSysDMVerBase.resetUserTag4();
                return true;
            }
            case 16: {
                pSSysDMVerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public ArrayList<PSSysDMVerItem> getPSSysDMVerItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVerItems();
        }
        if (this.getPSSysDMVerId() == null) {
            return null;
        }
        PSSysDMVerItemService pSSysDMVerItemService = (PSSysDMVerItemService)ServiceGlobal.getService(PSSysDMVerItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDMVerItemsLock;
        synchronized (n) {
            if (this.pssysdmveritems == null) {
                this.pssysdmveritems = pSSysDMVerItemService.selectByPSSysDMVer(this);
            }
            return this.pssysdmveritems;
        }
    }

    private PSSysDMVerBase getProxyEntity() {
        return this.proxyPSSysDMVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDMVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDMVerBase) {
            this.proxyPSSysDMVerBase = (PSSysDMVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIVEFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DMVER, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSSYSDMVERID, 5);
        fieldIndexMap.put(FIELD_PSSYSDMVERNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERCAT, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
        fieldIndexMap.put(FIELD_USERTAG3, 14);
        fieldIndexMap.put(FIELD_USERTAG4, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

