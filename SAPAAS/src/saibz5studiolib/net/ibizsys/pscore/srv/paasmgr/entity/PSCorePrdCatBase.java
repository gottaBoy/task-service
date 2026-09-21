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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCat;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCorePrdCatBase.class);
    public static final String FIELD_AVATARURL = "AVATARURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FULLNAME = "FULLNAME";
    public static final String FIELD_FULLPATH = "FULLPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PATH = "PATH";
    public static final String FIELD_PPSCOREPRDCATID = "PPSCOREPRDCATID";
    public static final String FIELD_PPSCOREPRDCATNAME = "PPSCOREPRDCATNAME";
    public static final String FIELD_PSCOREPRDCATID = "PSCOREPRDCATID";
    public static final String FIELD_PSCOREPRDCATNAME = "PSCOREPRDCATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_AVATARURL = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FULLNAME = 3;
    private static final int INDEX_FULLPATH = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PATH = 6;
    private static final int INDEX_PPSCOREPRDCATID = 7;
    private static final int INDEX_PPSCOREPRDCATNAME = 8;
    private static final int INDEX_PSCOREPRDCATID = 9;
    private static final int INDEX_PSCOREPRDCATNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCorePrdCatBase proxyPSCorePrdCatBase = null;
    private boolean avatarurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fullnameDirtyFlag = false;
    private boolean fullpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pathDirtyFlag = false;
    private boolean ppscoreprdcatidDirtyFlag = false;
    private boolean ppscoreprdcatnameDirtyFlag = false;
    private boolean pscoreprdcatidDirtyFlag = false;
    private boolean pscoreprdcatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="avatarurl")
    private String avatarurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fullname")
    private String fullname;
    @Column(name="fullpath")
    private String fullpath;
    @Column(name="memo")
    private String memo;
    @Column(name="path")
    private String path;
    @Column(name="ppscoreprdcatid")
    private String ppscoreprdcatid;
    @Column(name="ppscoreprdcatname")
    private String ppscoreprdcatname;
    @Column(name="pscoreprdcatid")
    private String pscoreprdcatid;
    @Column(name="pscoreprdcatname")
    private String pscoreprdcatname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSCorePrdCatLock = new Integer(1);
    private PSCorePrdCat ppscoreprdcat = null;

    public void setAvatarUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAvatarUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.avatarurl = string;
        this.avatarurlDirtyFlag = true;
    }

    public String getAvatarUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAvatarUrl();
        }
        return this.avatarurl;
    }

    public boolean isAvatarUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAvatarUrlDirty();
        }
        return this.avatarurlDirtyFlag;
    }

    public void resetAvatarUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAvatarUrl();
            return;
        }
        this.avatarurlDirtyFlag = false;
        this.avatarurl = null;
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

    public void setFullName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullname = string;
        this.fullnameDirtyFlag = true;
    }

    public String getFullName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullName();
        }
        return this.fullname;
    }

    public boolean isFullNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullNameDirty();
        }
        return this.fullnameDirtyFlag;
    }

    public void resetFullName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullName();
            return;
        }
        this.fullnameDirtyFlag = false;
        this.fullname = null;
    }

    public void setFullPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullpath = string;
        this.fullpathDirtyFlag = true;
    }

    public String getFullPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullPath();
        }
        return this.fullpath;
    }

    public boolean isFullPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullPathDirty();
        }
        return this.fullpathDirtyFlag;
    }

    public void resetFullPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullPath();
            return;
        }
        this.fullpathDirtyFlag = false;
        this.fullpath = null;
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

    public void setPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.path = string;
        this.pathDirtyFlag = true;
    }

    public String getPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPath();
        }
        return this.path;
    }

    public boolean isPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPathDirty();
        }
        return this.pathDirtyFlag;
    }

    public void resetPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPath();
            return;
        }
        this.pathDirtyFlag = false;
        this.path = null;
    }

    public void setPPSCorePrdCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSCorePrdCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppscoreprdcatid = string;
        this.ppscoreprdcatidDirtyFlag = true;
    }

    public String getPPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCorePrdCatId();
        }
        return this.ppscoreprdcatid;
    }

    public boolean isPPSCorePrdCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSCorePrdCatIdDirty();
        }
        return this.ppscoreprdcatidDirtyFlag;
    }

    public void resetPPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSCorePrdCatId();
            return;
        }
        this.ppscoreprdcatidDirtyFlag = false;
        this.ppscoreprdcatid = null;
    }

    public void setPPSCorePrdCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSCorePrdCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppscoreprdcatname = string;
        this.ppscoreprdcatnameDirtyFlag = true;
    }

    public String getPPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCorePrdCatName();
        }
        return this.ppscoreprdcatname;
    }

    public boolean isPPSCorePrdCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSCorePrdCatNameDirty();
        }
        return this.ppscoreprdcatnameDirtyFlag;
    }

    public void resetPPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSCorePrdCatName();
            return;
        }
        this.ppscoreprdcatnameDirtyFlag = false;
        this.ppscoreprdcatname = null;
    }

    public void setPSCorePrdCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdcatid = string;
        this.pscoreprdcatidDirtyFlag = true;
    }

    public String getPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCatId();
        }
        return this.pscoreprdcatid;
    }

    public boolean isPSCorePrdCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdCatIdDirty();
        }
        return this.pscoreprdcatidDirtyFlag;
    }

    public void resetPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdCatId();
            return;
        }
        this.pscoreprdcatidDirtyFlag = false;
        this.pscoreprdcatid = null;
    }

    public void setPSCorePrdCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdcatname = string;
        this.pscoreprdcatnameDirtyFlag = true;
    }

    public String getPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCatName();
        }
        return this.pscoreprdcatname;
    }

    public boolean isPSCorePrdCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdCatNameDirty();
        }
        return this.pscoreprdcatnameDirtyFlag;
    }

    public void resetPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdCatName();
            return;
        }
        this.pscoreprdcatnameDirtyFlag = false;
        this.pscoreprdcatname = null;
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

    protected void onReset() {
        PSCorePrdCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCorePrdCatBase pSCorePrdCatBase) {
        pSCorePrdCatBase.resetAvatarUrl();
        pSCorePrdCatBase.resetCreateDate();
        pSCorePrdCatBase.resetCreateMan();
        pSCorePrdCatBase.resetFullName();
        pSCorePrdCatBase.resetFullPath();
        pSCorePrdCatBase.resetMemo();
        pSCorePrdCatBase.resetPath();
        pSCorePrdCatBase.resetPPSCorePrdCatId();
        pSCorePrdCatBase.resetPPSCorePrdCatName();
        pSCorePrdCatBase.resetPSCorePrdCatId();
        pSCorePrdCatBase.resetPSCorePrdCatName();
        pSCorePrdCatBase.resetUpdateDate();
        pSCorePrdCatBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAvatarUrlDirty()) {
            hashMap.put(FIELD_AVATARURL, this.getAvatarUrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFullNameDirty()) {
            hashMap.put(FIELD_FULLNAME, this.getFullName());
        }
        if (!bl || this.isFullPathDirty()) {
            hashMap.put(FIELD_FULLPATH, this.getFullPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPathDirty()) {
            hashMap.put(FIELD_PATH, this.getPath());
        }
        if (!bl || this.isPPSCorePrdCatIdDirty()) {
            hashMap.put(FIELD_PPSCOREPRDCATID, this.getPPSCorePrdCatId());
        }
        if (!bl || this.isPPSCorePrdCatNameDirty()) {
            hashMap.put(FIELD_PPSCOREPRDCATNAME, this.getPPSCorePrdCatName());
        }
        if (!bl || this.isPSCorePrdCatIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDCATID, this.getPSCorePrdCatId());
        }
        if (!bl || this.isPSCorePrdCatNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDCATNAME, this.getPSCorePrdCatName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSCorePrdCatBase.get(this, n);
    }

    private static Object get(PSCorePrdCatBase pSCorePrdCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdCatBase.getAvatarUrl();
            }
            case 1: {
                return pSCorePrdCatBase.getCreateDate();
            }
            case 2: {
                return pSCorePrdCatBase.getCreateMan();
            }
            case 3: {
                return pSCorePrdCatBase.getFullName();
            }
            case 4: {
                return pSCorePrdCatBase.getFullPath();
            }
            case 5: {
                return pSCorePrdCatBase.getMemo();
            }
            case 6: {
                return pSCorePrdCatBase.getPath();
            }
            case 7: {
                return pSCorePrdCatBase.getPPSCorePrdCatId();
            }
            case 8: {
                return pSCorePrdCatBase.getPPSCorePrdCatName();
            }
            case 9: {
                return pSCorePrdCatBase.getPSCorePrdCatId();
            }
            case 10: {
                return pSCorePrdCatBase.getPSCorePrdCatName();
            }
            case 11: {
                return pSCorePrdCatBase.getUpdateDate();
            }
            case 12: {
                return pSCorePrdCatBase.getUpdateMan();
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
        PSCorePrdCatBase.set(this, n, object);
    }

    private static void set(PSCorePrdCatBase pSCorePrdCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdCatBase.setAvatarUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCorePrdCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCorePrdCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCorePrdCatBase.setFullName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCorePrdCatBase.setFullPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCorePrdCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCorePrdCatBase.setPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCorePrdCatBase.setPPSCorePrdCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCorePrdCatBase.setPPSCorePrdCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCorePrdCatBase.setPSCorePrdCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCorePrdCatBase.setPSCorePrdCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCorePrdCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSCorePrdCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCorePrdCatBase.isNull(this, n);
    }

    private static boolean isNull(PSCorePrdCatBase pSCorePrdCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdCatBase.getAvatarUrl() == null;
            }
            case 1: {
                return pSCorePrdCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSCorePrdCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSCorePrdCatBase.getFullName() == null;
            }
            case 4: {
                return pSCorePrdCatBase.getFullPath() == null;
            }
            case 5: {
                return pSCorePrdCatBase.getMemo() == null;
            }
            case 6: {
                return pSCorePrdCatBase.getPath() == null;
            }
            case 7: {
                return pSCorePrdCatBase.getPPSCorePrdCatId() == null;
            }
            case 8: {
                return pSCorePrdCatBase.getPPSCorePrdCatName() == null;
            }
            case 9: {
                return pSCorePrdCatBase.getPSCorePrdCatId() == null;
            }
            case 10: {
                return pSCorePrdCatBase.getPSCorePrdCatName() == null;
            }
            case 11: {
                return pSCorePrdCatBase.getUpdateDate() == null;
            }
            case 12: {
                return pSCorePrdCatBase.getUpdateMan() == null;
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
        return PSCorePrdCatBase.contains(this, n);
    }

    private static boolean contains(PSCorePrdCatBase pSCorePrdCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdCatBase.isAvatarUrlDirty();
            }
            case 1: {
                return pSCorePrdCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSCorePrdCatBase.isCreateManDirty();
            }
            case 3: {
                return pSCorePrdCatBase.isFullNameDirty();
            }
            case 4: {
                return pSCorePrdCatBase.isFullPathDirty();
            }
            case 5: {
                return pSCorePrdCatBase.isMemoDirty();
            }
            case 6: {
                return pSCorePrdCatBase.isPathDirty();
            }
            case 7: {
                return pSCorePrdCatBase.isPPSCorePrdCatIdDirty();
            }
            case 8: {
                return pSCorePrdCatBase.isPPSCorePrdCatNameDirty();
            }
            case 9: {
                return pSCorePrdCatBase.isPSCorePrdCatIdDirty();
            }
            case 10: {
                return pSCorePrdCatBase.isPSCorePrdCatNameDirty();
            }
            case 11: {
                return pSCorePrdCatBase.isUpdateDateDirty();
            }
            case 12: {
                return pSCorePrdCatBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCorePrdCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCorePrdCatBase pSCorePrdCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCorePrdCatBase.getAvatarUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"avatarurl", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getAvatarUrl()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getFullName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullname", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getFullName()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getFullPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullpath", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getFullPath()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"path", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getPath()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getPPSCorePrdCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppscoreprdcatid", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getPPSCorePrdCatId()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getPPSCorePrdCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppscoreprdcatname", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getPPSCorePrdCatName()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getPSCorePrdCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdcatid", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getPSCorePrdCatId()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getPSCorePrdCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdcatname", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getPSCorePrdCatName()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCorePrdCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCorePrdCatBase.getJSONValue((Object)pSCorePrdCatBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCorePrdCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCorePrdCatBase pSCorePrdCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCorePrdCatBase.getAvatarUrl() != null) {
            object = pSCorePrdCatBase.getAvatarUrl();
            xmlNode.setAttribute(FIELD_AVATARURL, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getCreateDate() != null) {
            object = pSCorePrdCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdCatBase.getCreateMan() != null) {
            object = pSCorePrdCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getFullName() != null) {
            object = pSCorePrdCatBase.getFullName();
            xmlNode.setAttribute(FIELD_FULLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getFullPath() != null) {
            object = pSCorePrdCatBase.getFullPath();
            xmlNode.setAttribute(FIELD_FULLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getMemo() != null) {
            object = pSCorePrdCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getPath() != null) {
            object = pSCorePrdCatBase.getPath();
            xmlNode.setAttribute(FIELD_PATH, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getPPSCorePrdCatId() != null) {
            object = pSCorePrdCatBase.getPPSCorePrdCatId();
            xmlNode.setAttribute(FIELD_PPSCOREPRDCATID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getPPSCorePrdCatName() != null) {
            object = pSCorePrdCatBase.getPPSCorePrdCatName();
            xmlNode.setAttribute(FIELD_PPSCOREPRDCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getPSCorePrdCatId() != null) {
            object = pSCorePrdCatBase.getPSCorePrdCatId();
            xmlNode.setAttribute(FIELD_PSCOREPRDCATID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getPSCorePrdCatName() != null) {
            object = pSCorePrdCatBase.getPSCorePrdCatName();
            xmlNode.setAttribute(FIELD_PSCOREPRDCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdCatBase.getUpdateDate() != null) {
            object = pSCorePrdCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdCatBase.getUpdateMan() != null) {
            object = pSCorePrdCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCorePrdCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCorePrdCatBase pSCorePrdCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCorePrdCatBase.isAvatarUrlDirty() && (bl || pSCorePrdCatBase.getAvatarUrl() != null)) {
            iDataObject.set(FIELD_AVATARURL, (Object)pSCorePrdCatBase.getAvatarUrl());
        }
        if (pSCorePrdCatBase.isCreateDateDirty() && (bl || pSCorePrdCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCorePrdCatBase.getCreateDate());
        }
        if (pSCorePrdCatBase.isCreateManDirty() && (bl || pSCorePrdCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCorePrdCatBase.getCreateMan());
        }
        if (pSCorePrdCatBase.isFullNameDirty() && (bl || pSCorePrdCatBase.getFullName() != null)) {
            iDataObject.set(FIELD_FULLNAME, (Object)pSCorePrdCatBase.getFullName());
        }
        if (pSCorePrdCatBase.isFullPathDirty() && (bl || pSCorePrdCatBase.getFullPath() != null)) {
            iDataObject.set(FIELD_FULLPATH, (Object)pSCorePrdCatBase.getFullPath());
        }
        if (pSCorePrdCatBase.isMemoDirty() && (bl || pSCorePrdCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCorePrdCatBase.getMemo());
        }
        if (pSCorePrdCatBase.isPathDirty() && (bl || pSCorePrdCatBase.getPath() != null)) {
            iDataObject.set(FIELD_PATH, (Object)pSCorePrdCatBase.getPath());
        }
        if (pSCorePrdCatBase.isPPSCorePrdCatIdDirty() && (bl || pSCorePrdCatBase.getPPSCorePrdCatId() != null)) {
            iDataObject.set(FIELD_PPSCOREPRDCATID, (Object)pSCorePrdCatBase.getPPSCorePrdCatId());
        }
        if (pSCorePrdCatBase.isPPSCorePrdCatNameDirty() && (bl || pSCorePrdCatBase.getPPSCorePrdCatName() != null)) {
            iDataObject.set(FIELD_PPSCOREPRDCATNAME, (Object)pSCorePrdCatBase.getPPSCorePrdCatName());
        }
        if (pSCorePrdCatBase.isPSCorePrdCatIdDirty() && (bl || pSCorePrdCatBase.getPSCorePrdCatId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDCATID, (Object)pSCorePrdCatBase.getPSCorePrdCatId());
        }
        if (pSCorePrdCatBase.isPSCorePrdCatNameDirty() && (bl || pSCorePrdCatBase.getPSCorePrdCatName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDCATNAME, (Object)pSCorePrdCatBase.getPSCorePrdCatName());
        }
        if (pSCorePrdCatBase.isUpdateDateDirty() && (bl || pSCorePrdCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCorePrdCatBase.getUpdateDate());
        }
        if (pSCorePrdCatBase.isUpdateManDirty() && (bl || pSCorePrdCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCorePrdCatBase.getUpdateMan());
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
        return PSCorePrdCatBase.remove(this, n);
    }

    private static boolean remove(PSCorePrdCatBase pSCorePrdCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdCatBase.resetAvatarUrl();
                return true;
            }
            case 1: {
                pSCorePrdCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCorePrdCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCorePrdCatBase.resetFullName();
                return true;
            }
            case 4: {
                pSCorePrdCatBase.resetFullPath();
                return true;
            }
            case 5: {
                pSCorePrdCatBase.resetMemo();
                return true;
            }
            case 6: {
                pSCorePrdCatBase.resetPath();
                return true;
            }
            case 7: {
                pSCorePrdCatBase.resetPPSCorePrdCatId();
                return true;
            }
            case 8: {
                pSCorePrdCatBase.resetPPSCorePrdCatName();
                return true;
            }
            case 9: {
                pSCorePrdCatBase.resetPSCorePrdCatId();
                return true;
            }
            case 10: {
                pSCorePrdCatBase.resetPSCorePrdCatName();
                return true;
            }
            case 11: {
                pSCorePrdCatBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSCorePrdCatBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdCat getPPSCorePrdCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCorePrdCat();
        }
        if (this.getPPSCorePrdCatId() == null) {
            return null;
        }
        Integer n = this.objPPSCorePrdCatLock;
        synchronized (n) {
            if (this.ppscoreprdcat != null && DataTypeHelper.compare((int)25, (Object)this.getPPSCorePrdCatId(), (Object)this.ppscoreprdcat.getPSCorePrdCatId()) != 0L) {
                this.ppscoreprdcat = null;
            }
            if (this.ppscoreprdcat == null) {
                PSCorePrdCat pSCorePrdCat = new PSCorePrdCat();
                pSCorePrdCat.setPSCorePrdCatId(this.getPPSCorePrdCatId());
                PSCorePrdCatService pSCorePrdCatService = (PSCorePrdCatService)ServiceGlobal.getService(PSCorePrdCatService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdCatService.autoGet((IEntity)pSCorePrdCat);
                this.ppscoreprdcat = pSCorePrdCat;
            }
            return this.ppscoreprdcat;
        }
    }

    private PSCorePrdCatBase getProxyEntity() {
        return this.proxyPSCorePrdCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCorePrdCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSCorePrdCatBase) {
            this.proxyPSCorePrdCatBase = (PSCorePrdCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AVATARURL, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FULLNAME, 3);
        fieldIndexMap.put(FIELD_FULLPATH, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PATH, 6);
        fieldIndexMap.put(FIELD_PPSCOREPRDCATID, 7);
        fieldIndexMap.put(FIELD_PPSCOREPRDCATNAME, 8);
        fieldIndexMap.put(FIELD_PSCOREPRDCATID, 9);
        fieldIndexMap.put(FIELD_PSCOREPRDCATNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

