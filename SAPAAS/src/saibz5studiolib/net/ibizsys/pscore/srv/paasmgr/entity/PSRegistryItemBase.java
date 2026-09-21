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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRegistryItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRegistryItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSREGISTRYITEMID = "PSREGISTRYITEMID";
    public static final String FIELD_PSREGISTRYITEMNAME = "PSREGISTRYITEMNAME";
    public static final String FIELD_PSREGISTRYREPOID = "PSREGISTRYREPOID";
    public static final String FIELD_PSREGISTRYREPONAME = "PSREGISTRYREPONAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMTAG = 2;
    private static final int INDEX_ITEMTAG2 = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSREGISTRYITEMID = 5;
    private static final int INDEX_PSREGISTRYITEMNAME = 6;
    private static final int INDEX_PSREGISTRYREPOID = 7;
    private static final int INDEX_PSREGISTRYREPONAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERCAT = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_USERTAG3 = 14;
    private static final int INDEX_USERTAG4 = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRegistryItemBase proxyPSRegistryItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psregistryitemidDirtyFlag = false;
    private boolean psregistryitemnameDirtyFlag = false;
    private boolean psregistryrepoidDirtyFlag = false;
    private boolean psregistryreponameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="memo")
    private String memo;
    @Column(name="psregistryitemid")
    private String psregistryitemid;
    @Column(name="psregistryitemname")
    private String psregistryitemname;
    @Column(name="psregistryrepoid")
    private String psregistryrepoid;
    @Column(name="psregistryreponame")
    private String psregistryreponame;
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
    private Integer objPsregistryrepoLock = new Integer(1);
    private PSRegistryRepo psregistryrepo = null;

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

    public void setItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag = string;
        this.itemtagDirtyFlag = true;
    }

    public String getItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag();
        }
        return this.itemtag;
    }

    public boolean isItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTagDirty();
        }
        return this.itemtagDirtyFlag;
    }

    public void resetItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag();
            return;
        }
        this.itemtagDirtyFlag = false;
        this.itemtag = null;
    }

    public void setItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag2 = string;
        this.itemtag2DirtyFlag = true;
    }

    public String getItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag2();
        }
        return this.itemtag2;
    }

    public boolean isItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag2Dirty();
        }
        return this.itemtag2DirtyFlag;
    }

    public void resetItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag2();
            return;
        }
        this.itemtag2DirtyFlag = false;
        this.itemtag2 = null;
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

    public void setPSRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryitemid = string;
        this.psregistryitemidDirtyFlag = true;
    }

    public String getPSRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryItemId();
        }
        return this.psregistryitemid;
    }

    public boolean isPSRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryItemIdDirty();
        }
        return this.psregistryitemidDirtyFlag;
    }

    public void resetPSRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryItemId();
            return;
        }
        this.psregistryitemidDirtyFlag = false;
        this.psregistryitemid = null;
    }

    public void setPSRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryitemname = string;
        this.psregistryitemnameDirtyFlag = true;
    }

    public String getPSRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryItemName();
        }
        return this.psregistryitemname;
    }

    public boolean isPSRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryItemNameDirty();
        }
        return this.psregistryitemnameDirtyFlag;
    }

    public void resetPSRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryItemName();
            return;
        }
        this.psregistryitemnameDirtyFlag = false;
        this.psregistryitemname = null;
    }

    public void setPSRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryrepoid = string;
        this.psregistryrepoidDirtyFlag = true;
    }

    public String getPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoId();
        }
        return this.psregistryrepoid;
    }

    public boolean isPSRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoIdDirty();
        }
        return this.psregistryrepoidDirtyFlag;
    }

    public void resetPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoId();
            return;
        }
        this.psregistryrepoidDirtyFlag = false;
        this.psregistryrepoid = null;
    }

    public void setPSRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryreponame = string;
        this.psregistryreponameDirtyFlag = true;
    }

    public String getPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoName();
        }
        return this.psregistryreponame;
    }

    public boolean isPSRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoNameDirty();
        }
        return this.psregistryreponameDirtyFlag;
    }

    public void resetPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoName();
            return;
        }
        this.psregistryreponameDirtyFlag = false;
        this.psregistryreponame = null;
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
        PSRegistryItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRegistryItemBase pSRegistryItemBase) {
        pSRegistryItemBase.resetCreateDate();
        pSRegistryItemBase.resetCreateMan();
        pSRegistryItemBase.resetItemTag();
        pSRegistryItemBase.resetItemTag2();
        pSRegistryItemBase.resetMemo();
        pSRegistryItemBase.resetPSRegistryItemId();
        pSRegistryItemBase.resetPSRegistryItemName();
        pSRegistryItemBase.resetPSRegistryRepoId();
        pSRegistryItemBase.resetPSRegistryRepoName();
        pSRegistryItemBase.resetUpdateDate();
        pSRegistryItemBase.resetUpdateMan();
        pSRegistryItemBase.resetUserCat();
        pSRegistryItemBase.resetUserTag();
        pSRegistryItemBase.resetUserTag2();
        pSRegistryItemBase.resetUserTag3();
        pSRegistryItemBase.resetUserTag4();
        pSRegistryItemBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isItemTagDirty()) {
            hashMap.put(FIELD_ITEMTAG, this.getItemTag());
        }
        if (!bl || this.isItemTag2Dirty()) {
            hashMap.put(FIELD_ITEMTAG2, this.getItemTag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSRegistryItemIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYITEMID, this.getPSRegistryItemId());
        }
        if (!bl || this.isPSRegistryItemNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYITEMNAME, this.getPSRegistryItemName());
        }
        if (!bl || this.isPSRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPOID, this.getPSRegistryRepoId());
        }
        if (!bl || this.isPSRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPONAME, this.getPSRegistryRepoName());
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
        return PSRegistryItemBase.get(this, n);
    }

    private static Object get(PSRegistryItemBase pSRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryItemBase.getCreateDate();
            }
            case 1: {
                return pSRegistryItemBase.getCreateMan();
            }
            case 2: {
                return pSRegistryItemBase.getItemTag();
            }
            case 3: {
                return pSRegistryItemBase.getItemTag2();
            }
            case 4: {
                return pSRegistryItemBase.getMemo();
            }
            case 5: {
                return pSRegistryItemBase.getPSRegistryItemId();
            }
            case 6: {
                return pSRegistryItemBase.getPSRegistryItemName();
            }
            case 7: {
                return pSRegistryItemBase.getPSRegistryRepoId();
            }
            case 8: {
                return pSRegistryItemBase.getPSRegistryRepoName();
            }
            case 9: {
                return pSRegistryItemBase.getUpdateDate();
            }
            case 10: {
                return pSRegistryItemBase.getUpdateMan();
            }
            case 11: {
                return pSRegistryItemBase.getUserCat();
            }
            case 12: {
                return pSRegistryItemBase.getUserTag();
            }
            case 13: {
                return pSRegistryItemBase.getUserTag2();
            }
            case 14: {
                return pSRegistryItemBase.getUserTag3();
            }
            case 15: {
                return pSRegistryItemBase.getUserTag4();
            }
            case 16: {
                return pSRegistryItemBase.getValidFlag();
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
        PSRegistryItemBase.set(this, n, object);
    }

    private static void set(PSRegistryItemBase pSRegistryItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRegistryItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRegistryItemBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSRegistryItemBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRegistryItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRegistryItemBase.setPSRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRegistryItemBase.setPSRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSRegistryItemBase.setPSRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRegistryItemBase.setPSRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRegistryItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSRegistryItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSRegistryItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSRegistryItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSRegistryItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSRegistryItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSRegistryItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSRegistryItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRegistryItemBase.isNull(this, n);
    }

    private static boolean isNull(PSRegistryItemBase pSRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSRegistryItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSRegistryItemBase.getItemTag() == null;
            }
            case 3: {
                return pSRegistryItemBase.getItemTag2() == null;
            }
            case 4: {
                return pSRegistryItemBase.getMemo() == null;
            }
            case 5: {
                return pSRegistryItemBase.getPSRegistryItemId() == null;
            }
            case 6: {
                return pSRegistryItemBase.getPSRegistryItemName() == null;
            }
            case 7: {
                return pSRegistryItemBase.getPSRegistryRepoId() == null;
            }
            case 8: {
                return pSRegistryItemBase.getPSRegistryRepoName() == null;
            }
            case 9: {
                return pSRegistryItemBase.getUpdateDate() == null;
            }
            case 10: {
                return pSRegistryItemBase.getUpdateMan() == null;
            }
            case 11: {
                return pSRegistryItemBase.getUserCat() == null;
            }
            case 12: {
                return pSRegistryItemBase.getUserTag() == null;
            }
            case 13: {
                return pSRegistryItemBase.getUserTag2() == null;
            }
            case 14: {
                return pSRegistryItemBase.getUserTag3() == null;
            }
            case 15: {
                return pSRegistryItemBase.getUserTag4() == null;
            }
            case 16: {
                return pSRegistryItemBase.getValidFlag() == null;
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
        return PSRegistryItemBase.contains(this, n);
    }

    private static boolean contains(PSRegistryItemBase pSRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSRegistryItemBase.isCreateManDirty();
            }
            case 2: {
                return pSRegistryItemBase.isItemTagDirty();
            }
            case 3: {
                return pSRegistryItemBase.isItemTag2Dirty();
            }
            case 4: {
                return pSRegistryItemBase.isMemoDirty();
            }
            case 5: {
                return pSRegistryItemBase.isPSRegistryItemIdDirty();
            }
            case 6: {
                return pSRegistryItemBase.isPSRegistryItemNameDirty();
            }
            case 7: {
                return pSRegistryItemBase.isPSRegistryRepoIdDirty();
            }
            case 8: {
                return pSRegistryItemBase.isPSRegistryRepoNameDirty();
            }
            case 9: {
                return pSRegistryItemBase.isUpdateDateDirty();
            }
            case 10: {
                return pSRegistryItemBase.isUpdateManDirty();
            }
            case 11: {
                return pSRegistryItemBase.isUserCatDirty();
            }
            case 12: {
                return pSRegistryItemBase.isUserTagDirty();
            }
            case 13: {
                return pSRegistryItemBase.isUserTag2Dirty();
            }
            case 14: {
                return pSRegistryItemBase.isUserTag3Dirty();
            }
            case 15: {
                return pSRegistryItemBase.isUserTag4Dirty();
            }
            case 16: {
                return pSRegistryItemBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRegistryItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRegistryItemBase pSRegistryItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRegistryItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getItemTag()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getPSRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryitemid", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getPSRegistryItemId()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getPSRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryitemname", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getPSRegistryItemName()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getPSRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryrepoid", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getPSRegistryRepoId()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getPSRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryreponame", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getPSRegistryRepoName()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSRegistryItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRegistryItemBase.getJSONValue((Object)pSRegistryItemBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRegistryItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRegistryItemBase pSRegistryItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRegistryItemBase.getCreateDate() != null) {
            object = pSRegistryItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryItemBase.getCreateMan() != null) {
            object = pSRegistryItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getItemTag() != null) {
            object = pSRegistryItemBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getItemTag2() != null) {
            object = pSRegistryItemBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getMemo() != null) {
            object = pSRegistryItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getPSRegistryItemId() != null) {
            object = pSRegistryItemBase.getPSRegistryItemId();
            xmlNode.setAttribute(FIELD_PSREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getPSRegistryItemName() != null) {
            object = pSRegistryItemBase.getPSRegistryItemName();
            xmlNode.setAttribute(FIELD_PSREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getPSRegistryRepoId() != null) {
            object = pSRegistryItemBase.getPSRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getPSRegistryRepoName() != null) {
            object = pSRegistryItemBase.getPSRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getUpdateDate() != null) {
            object = pSRegistryItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryItemBase.getUpdateMan() != null) {
            object = pSRegistryItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getUserCat() != null) {
            object = pSRegistryItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getUserTag() != null) {
            object = pSRegistryItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getUserTag2() != null) {
            object = pSRegistryItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getUserTag3() != null) {
            object = pSRegistryItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getUserTag4() != null) {
            object = pSRegistryItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryItemBase.getValidFlag() != null) {
            object = pSRegistryItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRegistryItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRegistryItemBase pSRegistryItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRegistryItemBase.isCreateDateDirty() && (bl || pSRegistryItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRegistryItemBase.getCreateDate());
        }
        if (pSRegistryItemBase.isCreateManDirty() && (bl || pSRegistryItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRegistryItemBase.getCreateMan());
        }
        if (pSRegistryItemBase.isItemTagDirty() && (bl || pSRegistryItemBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSRegistryItemBase.getItemTag());
        }
        if (pSRegistryItemBase.isItemTag2Dirty() && (bl || pSRegistryItemBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSRegistryItemBase.getItemTag2());
        }
        if (pSRegistryItemBase.isMemoDirty() && (bl || pSRegistryItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRegistryItemBase.getMemo());
        }
        if (pSRegistryItemBase.isPSRegistryItemIdDirty() && (bl || pSRegistryItemBase.getPSRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYITEMID, (Object)pSRegistryItemBase.getPSRegistryItemId());
        }
        if (pSRegistryItemBase.isPSRegistryItemNameDirty() && (bl || pSRegistryItemBase.getPSRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYITEMNAME, (Object)pSRegistryItemBase.getPSRegistryItemName());
        }
        if (pSRegistryItemBase.isPSRegistryRepoIdDirty() && (bl || pSRegistryItemBase.getPSRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPOID, (Object)pSRegistryItemBase.getPSRegistryRepoId());
        }
        if (pSRegistryItemBase.isPSRegistryRepoNameDirty() && (bl || pSRegistryItemBase.getPSRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPONAME, (Object)pSRegistryItemBase.getPSRegistryRepoName());
        }
        if (pSRegistryItemBase.isUpdateDateDirty() && (bl || pSRegistryItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRegistryItemBase.getUpdateDate());
        }
        if (pSRegistryItemBase.isUpdateManDirty() && (bl || pSRegistryItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRegistryItemBase.getUpdateMan());
        }
        if (pSRegistryItemBase.isUserCatDirty() && (bl || pSRegistryItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSRegistryItemBase.getUserCat());
        }
        if (pSRegistryItemBase.isUserTagDirty() && (bl || pSRegistryItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSRegistryItemBase.getUserTag());
        }
        if (pSRegistryItemBase.isUserTag2Dirty() && (bl || pSRegistryItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSRegistryItemBase.getUserTag2());
        }
        if (pSRegistryItemBase.isUserTag3Dirty() && (bl || pSRegistryItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSRegistryItemBase.getUserTag3());
        }
        if (pSRegistryItemBase.isUserTag4Dirty() && (bl || pSRegistryItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSRegistryItemBase.getUserTag4());
        }
        if (pSRegistryItemBase.isValidFlagDirty() && (bl || pSRegistryItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRegistryItemBase.getValidFlag());
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
        return PSRegistryItemBase.remove(this, n);
    }

    private static boolean remove(PSRegistryItemBase pSRegistryItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRegistryItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRegistryItemBase.resetItemTag();
                return true;
            }
            case 3: {
                pSRegistryItemBase.resetItemTag2();
                return true;
            }
            case 4: {
                pSRegistryItemBase.resetMemo();
                return true;
            }
            case 5: {
                pSRegistryItemBase.resetPSRegistryItemId();
                return true;
            }
            case 6: {
                pSRegistryItemBase.resetPSRegistryItemName();
                return true;
            }
            case 7: {
                pSRegistryItemBase.resetPSRegistryRepoId();
                return true;
            }
            case 8: {
                pSRegistryItemBase.resetPSRegistryRepoName();
                return true;
            }
            case 9: {
                pSRegistryItemBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSRegistryItemBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSRegistryItemBase.resetUserCat();
                return true;
            }
            case 12: {
                pSRegistryItemBase.resetUserTag();
                return true;
            }
            case 13: {
                pSRegistryItemBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSRegistryItemBase.resetUserTag3();
                return true;
            }
            case 15: {
                pSRegistryItemBase.resetUserTag4();
                return true;
            }
            case 16: {
                pSRegistryItemBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSRegistryRepo getPsregistryrepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsregistryrepo();
        }
        if (this.getPSRegistryRepoId() == null) {
            return null;
        }
        Integer n = this.objPsregistryrepoLock;
        synchronized (n) {
            if (this.psregistryrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSRegistryRepoId(), (Object)this.psregistryrepo.getPSRegistryRepoId()) != 0L) {
                this.psregistryrepo = null;
            }
            if (this.psregistryrepo == null) {
                PSRegistryRepo pSRegistryRepo = new PSRegistryRepo();
                pSRegistryRepo.setPSRegistryRepoId(this.getPSRegistryRepoId());
                PSRegistryRepoService pSRegistryRepoService = (PSRegistryRepoService)ServiceGlobal.getService(PSRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
                pSRegistryRepoService.autoGet((IEntity)pSRegistryRepo);
                this.psregistryrepo = pSRegistryRepo;
            }
            return this.psregistryrepo;
        }
    }

    private PSRegistryItemBase getProxyEntity() {
        return this.proxyPSRegistryItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRegistryItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSRegistryItemBase) {
            this.proxyPSRegistryItemBase = (PSRegistryItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRegistryItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMTAG, 2);
        fieldIndexMap.put(FIELD_ITEMTAG2, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSREGISTRYITEMID, 5);
        fieldIndexMap.put(FIELD_PSREGISTRYITEMNAME, 6);
        fieldIndexMap.put(FIELD_PSREGISTRYREPOID, 7);
        fieldIndexMap.put(FIELD_PSREGISTRYREPONAME, 8);
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

