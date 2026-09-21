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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserObjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevUserObjBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DUTAG = "DUTAG";
    public static final String FIELD_DUTAG2 = "DUTAG2";
    public static final String FIELD_DUTAG3 = "DUTAG3";
    public static final String FIELD_DUTAG4 = "DUTAG4";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVUSEROBJECTID = "PSDEVUSEROBJID";
    public static final String FIELD_PSDEVUSEROBJNAME = "PSDEVUSEROBJNAME";
    public static final String FIELD_PSDEVUSEROBJTYPE = "PSDEVUSEROBJTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTFLAG = 2;
    private static final int INDEX_DUTAG = 3;
    private static final int INDEX_DUTAG2 = 4;
    private static final int INDEX_DUTAG3 = 5;
    private static final int INDEX_DUTAG4 = 6;
    private static final int INDEX_ENABLE = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSDEVCENTERID = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_PSDEVUSEROBJECTID = 11;
    private static final int INDEX_PSDEVUSEROBJNAME = 12;
    private static final int INDEX_PSDEVUSEROBJTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevUserObjBase proxyPSDevUserObjBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dutagDirtyFlag = false;
    private boolean dutag2DirtyFlag = false;
    private boolean dutag3DirtyFlag = false;
    private boolean dutag4DirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevuserobjectidDirtyFlag = false;
    private boolean psdevuserobjnameDirtyFlag = false;
    private boolean psdevuserobjtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dutag")
    private String dutag;
    @Column(name="dutag2")
    private String dutag2;
    @Column(name="dutag3")
    private String dutag3;
    @Column(name="dutag4")
    private String dutag4;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevuserobjectid")
    private String psdevuserobjectid;
    @Column(name="psdevuserobjname")
    private String psdevuserobjname;
    @Column(name="psdevuserobjtype")
    private String psdevuserobjtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setDUTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDUTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dutag = string;
        this.dutagDirtyFlag = true;
    }

    public String getDUTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDUTag();
        }
        return this.dutag;
    }

    public boolean isDUTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDUTagDirty();
        }
        return this.dutagDirtyFlag;
    }

    public void resetDUTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDUTag();
            return;
        }
        this.dutagDirtyFlag = false;
        this.dutag = null;
    }

    public void setDUTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDUTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dutag2 = string;
        this.dutag2DirtyFlag = true;
    }

    public String getDUTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDUTag2();
        }
        return this.dutag2;
    }

    public boolean isDUTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDUTag2Dirty();
        }
        return this.dutag2DirtyFlag;
    }

    public void resetDUTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDUTag2();
            return;
        }
        this.dutag2DirtyFlag = false;
        this.dutag2 = null;
    }

    public void setDUTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDUTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dutag3 = string;
        this.dutag3DirtyFlag = true;
    }

    public String getDUTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDUTag3();
        }
        return this.dutag3;
    }

    public boolean isDUTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDUTag3Dirty();
        }
        return this.dutag3DirtyFlag;
    }

    public void resetDUTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDUTag3();
            return;
        }
        this.dutag3DirtyFlag = false;
        this.dutag3 = null;
    }

    public void setDUTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDUTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dutag4 = string;
        this.dutag4DirtyFlag = true;
    }

    public String getDUTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDUTag4();
        }
        return this.dutag4;
    }

    public boolean isDUTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDUTag4Dirty();
        }
        return this.dutag4DirtyFlag;
    }

    public void resetDUTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDUTag4();
            return;
        }
        this.dutag4DirtyFlag = false;
        this.dutag4 = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevUserObjectId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserObjectId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserobjectid = string;
        this.psdevuserobjectidDirtyFlag = true;
    }

    public String getPSDevUserObjectId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObjectId();
        }
        return this.psdevuserobjectid;
    }

    public boolean isPSDevUserObjectIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserObjectIdDirty();
        }
        return this.psdevuserobjectidDirtyFlag;
    }

    public void resetPSDevUserObjectId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserObjectId();
            return;
        }
        this.psdevuserobjectidDirtyFlag = false;
        this.psdevuserobjectid = null;
    }

    public void setPSDevUserObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserobjname = string;
        this.psdevuserobjnameDirtyFlag = true;
    }

    public String getPSDevUserObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObjName();
        }
        return this.psdevuserobjname;
    }

    public boolean isPSDevUserObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserObjNameDirty();
        }
        return this.psdevuserobjnameDirtyFlag;
    }

    public void resetPSDevUserObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserObjName();
            return;
        }
        this.psdevuserobjnameDirtyFlag = false;
        this.psdevuserobjname = null;
    }

    public void setPSDevUserObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserobjtype = string;
        this.psdevuserobjtypeDirtyFlag = true;
    }

    public String getPSDevUserObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserObjType();
        }
        return this.psdevuserobjtype;
    }

    public boolean isPSDevUserObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserObjTypeDirty();
        }
        return this.psdevuserobjtypeDirtyFlag;
    }

    public void resetPSDevUserObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserObjType();
            return;
        }
        this.psdevuserobjtypeDirtyFlag = false;
        this.psdevuserobjtype = null;
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
        PSDevUserObjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevUserObjBase pSDevUserObjBase) {
        pSDevUserObjBase.resetCreateDate();
        pSDevUserObjBase.resetCreateMan();
        pSDevUserObjBase.resetDefaultFlag();
        pSDevUserObjBase.resetDUTag();
        pSDevUserObjBase.resetDUTag2();
        pSDevUserObjBase.resetDUTag3();
        pSDevUserObjBase.resetDUTag4();
        pSDevUserObjBase.resetEnable();
        pSDevUserObjBase.resetMemo();
        pSDevUserObjBase.resetPSDevCenterId();
        pSDevUserObjBase.resetPSDevCenterName();
        pSDevUserObjBase.resetPSDevUserObjectId();
        pSDevUserObjBase.resetPSDevUserObjName();
        pSDevUserObjBase.resetPSDevUserObjType();
        pSDevUserObjBase.resetUpdateDate();
        pSDevUserObjBase.resetUpdateMan();
        pSDevUserObjBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDUTagDirty()) {
            hashMap.put(FIELD_DUTAG, this.getDUTag());
        }
        if (!bl || this.isDUTag2Dirty()) {
            hashMap.put(FIELD_DUTAG2, this.getDUTag2());
        }
        if (!bl || this.isDUTag3Dirty()) {
            hashMap.put(FIELD_DUTAG3, this.getDUTag3());
        }
        if (!bl || this.isDUTag4Dirty()) {
            hashMap.put(FIELD_DUTAG4, this.getDUTag4());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevUserObjectIdDirty()) {
            hashMap.put(FIELD_PSDEVUSEROBJECTID, this.getPSDevUserObjectId());
        }
        if (!bl || this.isPSDevUserObjNameDirty()) {
            hashMap.put(FIELD_PSDEVUSEROBJNAME, this.getPSDevUserObjName());
        }
        if (!bl || this.isPSDevUserObjTypeDirty()) {
            hashMap.put(FIELD_PSDEVUSEROBJTYPE, this.getPSDevUserObjType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDevUserObjBase.get(this, n);
    }

    private static Object get(PSDevUserObjBase pSDevUserObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserObjBase.getCreateDate();
            }
            case 1: {
                return pSDevUserObjBase.getCreateMan();
            }
            case 2: {
                return pSDevUserObjBase.getDefaultFlag();
            }
            case 3: {
                return pSDevUserObjBase.getDUTag();
            }
            case 4: {
                return pSDevUserObjBase.getDUTag2();
            }
            case 5: {
                return pSDevUserObjBase.getDUTag3();
            }
            case 6: {
                return pSDevUserObjBase.getDUTag4();
            }
            case 7: {
                return pSDevUserObjBase.getEnable();
            }
            case 8: {
                return pSDevUserObjBase.getMemo();
            }
            case 9: {
                return pSDevUserObjBase.getPSDevCenterId();
            }
            case 10: {
                return pSDevUserObjBase.getPSDevCenterName();
            }
            case 11: {
                return pSDevUserObjBase.getPSDevUserObjectId();
            }
            case 12: {
                return pSDevUserObjBase.getPSDevUserObjName();
            }
            case 13: {
                return pSDevUserObjBase.getPSDevUserObjType();
            }
            case 14: {
                return pSDevUserObjBase.getUpdateDate();
            }
            case 15: {
                return pSDevUserObjBase.getUpdateMan();
            }
            case 16: {
                return pSDevUserObjBase.getValidFlag();
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
        PSDevUserObjBase.set(this, n, object);
    }

    private static void set(PSDevUserObjBase pSDevUserObjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserObjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevUserObjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevUserObjBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevUserObjBase.setDUTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevUserObjBase.setDUTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevUserObjBase.setDUTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevUserObjBase.setDUTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevUserObjBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevUserObjBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevUserObjBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevUserObjBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevUserObjBase.setPSDevUserObjectId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevUserObjBase.setPSDevUserObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevUserObjBase.setPSDevUserObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevUserObjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDevUserObjBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevUserObjBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevUserObjBase.isNull(this, n);
    }

    private static boolean isNull(PSDevUserObjBase pSDevUserObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserObjBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevUserObjBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevUserObjBase.getDefaultFlag() == null;
            }
            case 3: {
                return pSDevUserObjBase.getDUTag() == null;
            }
            case 4: {
                return pSDevUserObjBase.getDUTag2() == null;
            }
            case 5: {
                return pSDevUserObjBase.getDUTag3() == null;
            }
            case 6: {
                return pSDevUserObjBase.getDUTag4() == null;
            }
            case 7: {
                return pSDevUserObjBase.getEnable() == null;
            }
            case 8: {
                return pSDevUserObjBase.getMemo() == null;
            }
            case 9: {
                return pSDevUserObjBase.getPSDevCenterId() == null;
            }
            case 10: {
                return pSDevUserObjBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDevUserObjBase.getPSDevUserObjectId() == null;
            }
            case 12: {
                return pSDevUserObjBase.getPSDevUserObjName() == null;
            }
            case 13: {
                return pSDevUserObjBase.getPSDevUserObjType() == null;
            }
            case 14: {
                return pSDevUserObjBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDevUserObjBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDevUserObjBase.getValidFlag() == null;
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
        return PSDevUserObjBase.contains(this, n);
    }

    private static boolean contains(PSDevUserObjBase pSDevUserObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserObjBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevUserObjBase.isCreateManDirty();
            }
            case 2: {
                return pSDevUserObjBase.isDefaultFlagDirty();
            }
            case 3: {
                return pSDevUserObjBase.isDUTagDirty();
            }
            case 4: {
                return pSDevUserObjBase.isDUTag2Dirty();
            }
            case 5: {
                return pSDevUserObjBase.isDUTag3Dirty();
            }
            case 6: {
                return pSDevUserObjBase.isDUTag4Dirty();
            }
            case 7: {
                return pSDevUserObjBase.isEnableDirty();
            }
            case 8: {
                return pSDevUserObjBase.isMemoDirty();
            }
            case 9: {
                return pSDevUserObjBase.isPSDevCenterIdDirty();
            }
            case 10: {
                return pSDevUserObjBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDevUserObjBase.isPSDevUserObjectIdDirty();
            }
            case 12: {
                return pSDevUserObjBase.isPSDevUserObjNameDirty();
            }
            case 13: {
                return pSDevUserObjBase.isPSDevUserObjTypeDirty();
            }
            case 14: {
                return pSDevUserObjBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDevUserObjBase.isUpdateManDirty();
            }
            case 16: {
                return pSDevUserObjBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevUserObjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevUserObjBase pSDevUserObjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevUserObjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getDUTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dutag", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getDUTag()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getDUTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dutag2", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getDUTag2()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getDUTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dutag3", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getDUTag3()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getDUTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dutag4", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getDUTag4()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getEnable()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getPSDevUserObjectId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserobjid", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getPSDevUserObjectId()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getPSDevUserObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserobjname", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getPSDevUserObjName()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getPSDevUserObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserobjtype", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getPSDevUserObjType()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevUserObjBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevUserObjBase.getJSONValue((Object)pSDevUserObjBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevUserObjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevUserObjBase pSDevUserObjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevUserObjBase.getCreateDate() != null) {
            object = pSDevUserObjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserObjBase.getCreateMan() != null) {
            object = pSDevUserObjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getDefaultFlag() != null) {
            object = pSDevUserObjBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserObjBase.getDUTag() != null) {
            object = pSDevUserObjBase.getDUTag();
            xmlNode.setAttribute(FIELD_DUTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getDUTag2() != null) {
            object = pSDevUserObjBase.getDUTag2();
            xmlNode.setAttribute(FIELD_DUTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getDUTag3() != null) {
            object = pSDevUserObjBase.getDUTag3();
            xmlNode.setAttribute(FIELD_DUTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getDUTag4() != null) {
            object = pSDevUserObjBase.getDUTag4();
            xmlNode.setAttribute(FIELD_DUTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getEnable() != null) {
            object = pSDevUserObjBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserObjBase.getMemo() != null) {
            object = pSDevUserObjBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getPSDevCenterId() != null) {
            object = pSDevUserObjBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getPSDevCenterName() != null) {
            object = pSDevUserObjBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getPSDevUserObjectId() != null) {
            object = pSDevUserObjBase.getPSDevUserObjectId();
            xmlNode.setAttribute("PSDEVUSEROBJECTID", object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getPSDevUserObjName() != null) {
            object = pSDevUserObjBase.getPSDevUserObjName();
            xmlNode.setAttribute(FIELD_PSDEVUSEROBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getPSDevUserObjType() != null) {
            object = pSDevUserObjBase.getPSDevUserObjType();
            xmlNode.setAttribute(FIELD_PSDEVUSEROBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getUpdateDate() != null) {
            object = pSDevUserObjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserObjBase.getUpdateMan() != null) {
            object = pSDevUserObjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserObjBase.getValidFlag() != null) {
            object = pSDevUserObjBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevUserObjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevUserObjBase pSDevUserObjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevUserObjBase.isCreateDateDirty() && (bl || pSDevUserObjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevUserObjBase.getCreateDate());
        }
        if (pSDevUserObjBase.isCreateManDirty() && (bl || pSDevUserObjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevUserObjBase.getCreateMan());
        }
        if (pSDevUserObjBase.isDefaultFlagDirty() && (bl || pSDevUserObjBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDevUserObjBase.getDefaultFlag());
        }
        if (pSDevUserObjBase.isDUTagDirty() && (bl || pSDevUserObjBase.getDUTag() != null)) {
            iDataObject.set(FIELD_DUTAG, (Object)pSDevUserObjBase.getDUTag());
        }
        if (pSDevUserObjBase.isDUTag2Dirty() && (bl || pSDevUserObjBase.getDUTag2() != null)) {
            iDataObject.set(FIELD_DUTAG2, (Object)pSDevUserObjBase.getDUTag2());
        }
        if (pSDevUserObjBase.isDUTag3Dirty() && (bl || pSDevUserObjBase.getDUTag3() != null)) {
            iDataObject.set(FIELD_DUTAG3, (Object)pSDevUserObjBase.getDUTag3());
        }
        if (pSDevUserObjBase.isDUTag4Dirty() && (bl || pSDevUserObjBase.getDUTag4() != null)) {
            iDataObject.set(FIELD_DUTAG4, (Object)pSDevUserObjBase.getDUTag4());
        }
        if (pSDevUserObjBase.isEnableDirty() && (bl || pSDevUserObjBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSDevUserObjBase.getEnable());
        }
        if (pSDevUserObjBase.isMemoDirty() && (bl || pSDevUserObjBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevUserObjBase.getMemo());
        }
        if (pSDevUserObjBase.isPSDevCenterIdDirty() && (bl || pSDevUserObjBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevUserObjBase.getPSDevCenterId());
        }
        if (pSDevUserObjBase.isPSDevCenterNameDirty() && (bl || pSDevUserObjBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevUserObjBase.getPSDevCenterName());
        }
        if (pSDevUserObjBase.isPSDevUserObjectIdDirty() && (bl || pSDevUserObjBase.getPSDevUserObjectId() != null)) {
            iDataObject.set(FIELD_PSDEVUSEROBJECTID, (Object)pSDevUserObjBase.getPSDevUserObjectId());
        }
        if (pSDevUserObjBase.isPSDevUserObjNameDirty() && (bl || pSDevUserObjBase.getPSDevUserObjName() != null)) {
            iDataObject.set(FIELD_PSDEVUSEROBJNAME, (Object)pSDevUserObjBase.getPSDevUserObjName());
        }
        if (pSDevUserObjBase.isPSDevUserObjTypeDirty() && (bl || pSDevUserObjBase.getPSDevUserObjType() != null)) {
            iDataObject.set(FIELD_PSDEVUSEROBJTYPE, (Object)pSDevUserObjBase.getPSDevUserObjType());
        }
        if (pSDevUserObjBase.isUpdateDateDirty() && (bl || pSDevUserObjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevUserObjBase.getUpdateDate());
        }
        if (pSDevUserObjBase.isUpdateManDirty() && (bl || pSDevUserObjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevUserObjBase.getUpdateMan());
        }
        if (pSDevUserObjBase.isValidFlagDirty() && (bl || pSDevUserObjBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevUserObjBase.getValidFlag());
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
        return PSDevUserObjBase.remove(this, n);
    }

    private static boolean remove(PSDevUserObjBase pSDevUserObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserObjBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevUserObjBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevUserObjBase.resetDefaultFlag();
                return true;
            }
            case 3: {
                pSDevUserObjBase.resetDUTag();
                return true;
            }
            case 4: {
                pSDevUserObjBase.resetDUTag2();
                return true;
            }
            case 5: {
                pSDevUserObjBase.resetDUTag3();
                return true;
            }
            case 6: {
                pSDevUserObjBase.resetDUTag4();
                return true;
            }
            case 7: {
                pSDevUserObjBase.resetEnable();
                return true;
            }
            case 8: {
                pSDevUserObjBase.resetMemo();
                return true;
            }
            case 9: {
                pSDevUserObjBase.resetPSDevCenterId();
                return true;
            }
            case 10: {
                pSDevUserObjBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDevUserObjBase.resetPSDevUserObjectId();
                return true;
            }
            case 12: {
                pSDevUserObjBase.resetPSDevUserObjName();
                return true;
            }
            case 13: {
                pSDevUserObjBase.resetPSDevUserObjType();
                return true;
            }
            case 14: {
                pSDevUserObjBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDevUserObjBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDevUserObjBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDevUserObjBase getProxyEntity() {
        return this.proxyPSDevUserObjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevUserObjBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevUserObjBase) {
            this.proxyPSDevUserObjBase = (PSDevUserObjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 2);
        fieldIndexMap.put(FIELD_DUTAG, 3);
        fieldIndexMap.put(FIELD_DUTAG2, 4);
        fieldIndexMap.put(FIELD_DUTAG3, 5);
        fieldIndexMap.put(FIELD_DUTAG4, 6);
        fieldIndexMap.put(FIELD_ENABLE, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVUSEROBJECTID, 11);
        fieldIndexMap.put(FIELD_PSDEVUSEROBJNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVUSEROBJTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

