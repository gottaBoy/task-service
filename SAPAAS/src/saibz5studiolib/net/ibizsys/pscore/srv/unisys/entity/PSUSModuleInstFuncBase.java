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
package net.ibizsys.pscore.srv.unisys.entity;

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
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSModuleInstFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSModuleInstFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCTAG = "FUNCTAG";
    public static final String FIELD_FUNCTYPE = "FUNCTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBILEAPPFLAG = "MOBILEAPPFLAG";
    public static final String FIELD_PSUSMODULEINSTFUNCID = "PSUSMODULEINSTFUNCID";
    public static final String FIELD_PSUSMODULEINSTFUNCNAME = "PSUSMODULEINSTFUNCNAME";
    public static final String FIELD_PSUSMODULEINSTID = "PSUSMODULEINSTID";
    public static final String FIELD_PSUSMODULEINSTNAME = "PSUSMODULEINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_URL = "URL";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FUNCTAG = 2;
    private static final int INDEX_FUNCTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MOBILEAPPFLAG = 5;
    private static final int INDEX_PSUSMODULEINSTFUNCID = 6;
    private static final int INDEX_PSUSMODULEINSTFUNCNAME = 7;
    private static final int INDEX_PSUSMODULEINSTID = 8;
    private static final int INDEX_PSUSMODULEINSTNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_URL = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSModuleInstFuncBase proxyPSUSModuleInstFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean functagDirtyFlag = false;
    private boolean functypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobileappflagDirtyFlag = false;
    private boolean psusmoduleinstfuncidDirtyFlag = false;
    private boolean psusmoduleinstfuncnameDirtyFlag = false;
    private boolean psusmoduleinstidDirtyFlag = false;
    private boolean psusmoduleinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean urlDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="functag")
    private String functag;
    @Column(name="functype")
    private String functype;
    @Column(name="memo")
    private String memo;
    @Column(name="mobileappflag")
    private Integer mobileappflag;
    @Column(name="psusmoduleinstfuncid")
    private String psusmoduleinstfuncid;
    @Column(name="psusmoduleinstfuncname")
    private String psusmoduleinstfuncname;
    @Column(name="psusmoduleinstid")
    private String psusmoduleinstid;
    @Column(name="psusmoduleinstname")
    private String psusmoduleinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="url")
    private String url;
    private Integer objPSUSModuleInstLock = new Integer(1);
    private PSUSModuleInst psusmoduleinst = null;

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

    public void setFuncTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.functag = string;
        this.functagDirtyFlag = true;
    }

    public String getFuncTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncTag();
        }
        return this.functag;
    }

    public boolean isFuncTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncTagDirty();
        }
        return this.functagDirtyFlag;
    }

    public void resetFuncTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncTag();
            return;
        }
        this.functagDirtyFlag = false;
        this.functag = null;
    }

    public void setFuncType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.functype = string;
        this.functypeDirtyFlag = true;
    }

    public String getFuncType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncType();
        }
        return this.functype;
    }

    public boolean isFuncTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncTypeDirty();
        }
        return this.functypeDirtyFlag;
    }

    public void resetFuncType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncType();
            return;
        }
        this.functypeDirtyFlag = false;
        this.functype = null;
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

    public void setMobileAppFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobileAppFlag(n);
            return;
        }
        this.mobileappflag = n;
        this.mobileappflagDirtyFlag = true;
    }

    public Integer getMobileAppFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobileAppFlag();
        }
        return this.mobileappflag;
    }

    public boolean isMobileAppFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobileAppFlagDirty();
        }
        return this.mobileappflagDirtyFlag;
    }

    public void resetMobileAppFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobileAppFlag();
            return;
        }
        this.mobileappflagDirtyFlag = false;
        this.mobileappflag = null;
    }

    public void setPSUSModuleInstFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstfuncid = string;
        this.psusmoduleinstfuncidDirtyFlag = true;
    }

    public String getPSUSModuleInstFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstFuncId();
        }
        return this.psusmoduleinstfuncid;
    }

    public boolean isPSUSModuleInstFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstFuncIdDirty();
        }
        return this.psusmoduleinstfuncidDirtyFlag;
    }

    public void resetPSUSModuleInstFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstFuncId();
            return;
        }
        this.psusmoduleinstfuncidDirtyFlag = false;
        this.psusmoduleinstfuncid = null;
    }

    public void setPSUSModuleInstFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstfuncname = string;
        this.psusmoduleinstfuncnameDirtyFlag = true;
    }

    public String getPSUSModuleInstFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstFuncName();
        }
        return this.psusmoduleinstfuncname;
    }

    public boolean isPSUSModuleInstFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstFuncNameDirty();
        }
        return this.psusmoduleinstfuncnameDirtyFlag;
    }

    public void resetPSUSModuleInstFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstFuncName();
            return;
        }
        this.psusmoduleinstfuncnameDirtyFlag = false;
        this.psusmoduleinstfuncname = null;
    }

    public void setPSUSModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstid = string;
        this.psusmoduleinstidDirtyFlag = true;
    }

    public String getPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstId();
        }
        return this.psusmoduleinstid;
    }

    public boolean isPSUSModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstIdDirty();
        }
        return this.psusmoduleinstidDirtyFlag;
    }

    public void resetPSUSModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstId();
            return;
        }
        this.psusmoduleinstidDirtyFlag = false;
        this.psusmoduleinstid = null;
    }

    public void setPSUSModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleinstname = string;
        this.psusmoduleinstnameDirtyFlag = true;
    }

    public String getPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstName();
        }
        return this.psusmoduleinstname;
    }

    public boolean isPSUSModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleInstNameDirty();
        }
        return this.psusmoduleinstnameDirtyFlag;
    }

    public void resetPSUSModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleInstName();
            return;
        }
        this.psusmoduleinstnameDirtyFlag = false;
        this.psusmoduleinstname = null;
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

    public void setUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.url = string;
        this.urlDirtyFlag = true;
    }

    public String getUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUrl();
        }
        return this.url;
    }

    public boolean isUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUrlDirty();
        }
        return this.urlDirtyFlag;
    }

    public void resetUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUrl();
            return;
        }
        this.urlDirtyFlag = false;
        this.url = null;
    }

    protected void onReset() {
        PSUSModuleInstFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSModuleInstFuncBase pSUSModuleInstFuncBase) {
        pSUSModuleInstFuncBase.resetCreateDate();
        pSUSModuleInstFuncBase.resetCreateMan();
        pSUSModuleInstFuncBase.resetFuncTag();
        pSUSModuleInstFuncBase.resetFuncType();
        pSUSModuleInstFuncBase.resetMemo();
        pSUSModuleInstFuncBase.resetMobileAppFlag();
        pSUSModuleInstFuncBase.resetPSUSModuleInstFuncId();
        pSUSModuleInstFuncBase.resetPSUSModuleInstFuncName();
        pSUSModuleInstFuncBase.resetPSUSModuleInstId();
        pSUSModuleInstFuncBase.resetPSUSModuleInstName();
        pSUSModuleInstFuncBase.resetUpdateDate();
        pSUSModuleInstFuncBase.resetUpdateMan();
        pSUSModuleInstFuncBase.resetUrl();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFuncTagDirty()) {
            hashMap.put(FIELD_FUNCTAG, this.getFuncTag());
        }
        if (!bl || this.isFuncTypeDirty()) {
            hashMap.put(FIELD_FUNCTYPE, this.getFuncType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobileAppFlagDirty()) {
            hashMap.put(FIELD_MOBILEAPPFLAG, this.getMobileAppFlag());
        }
        if (!bl || this.isPSUSModuleInstFuncIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTFUNCID, this.getPSUSModuleInstFuncId());
        }
        if (!bl || this.isPSUSModuleInstFuncNameDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTFUNCNAME, this.getPSUSModuleInstFuncName());
        }
        if (!bl || this.isPSUSModuleInstIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTID, this.getPSUSModuleInstId());
        }
        if (!bl || this.isPSUSModuleInstNameDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTNAME, this.getPSUSModuleInstName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUrlDirty()) {
            hashMap.put(FIELD_URL, this.getUrl());
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
        return PSUSModuleInstFuncBase.get(this, n);
    }

    private static Object get(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstFuncBase.getCreateDate();
            }
            case 1: {
                return pSUSModuleInstFuncBase.getCreateMan();
            }
            case 2: {
                return pSUSModuleInstFuncBase.getFuncTag();
            }
            case 3: {
                return pSUSModuleInstFuncBase.getFuncType();
            }
            case 4: {
                return pSUSModuleInstFuncBase.getMemo();
            }
            case 5: {
                return pSUSModuleInstFuncBase.getMobileAppFlag();
            }
            case 6: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstFuncId();
            }
            case 7: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstFuncName();
            }
            case 8: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstId();
            }
            case 9: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstName();
            }
            case 10: {
                return pSUSModuleInstFuncBase.getUpdateDate();
            }
            case 11: {
                return pSUSModuleInstFuncBase.getUpdateMan();
            }
            case 12: {
                return pSUSModuleInstFuncBase.getUrl();
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
        PSUSModuleInstFuncBase.set(this, n, object);
    }

    private static void set(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleInstFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUSModuleInstFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSModuleInstFuncBase.setFuncTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSModuleInstFuncBase.setFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSModuleInstFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSModuleInstFuncBase.setMobileAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSUSModuleInstFuncBase.setPSUSModuleInstFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUSModuleInstFuncBase.setPSUSModuleInstFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUSModuleInstFuncBase.setPSUSModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUSModuleInstFuncBase.setPSUSModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUSModuleInstFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSUSModuleInstFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUSModuleInstFuncBase.setUrl(DataObject.getStringValue((Object)object));
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
        return PSUSModuleInstFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSUSModuleInstFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSUSModuleInstFuncBase.getFuncTag() == null;
            }
            case 3: {
                return pSUSModuleInstFuncBase.getFuncType() == null;
            }
            case 4: {
                return pSUSModuleInstFuncBase.getMemo() == null;
            }
            case 5: {
                return pSUSModuleInstFuncBase.getMobileAppFlag() == null;
            }
            case 6: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstFuncId() == null;
            }
            case 7: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstFuncName() == null;
            }
            case 8: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstId() == null;
            }
            case 9: {
                return pSUSModuleInstFuncBase.getPSUSModuleInstName() == null;
            }
            case 10: {
                return pSUSModuleInstFuncBase.getUpdateDate() == null;
            }
            case 11: {
                return pSUSModuleInstFuncBase.getUpdateMan() == null;
            }
            case 12: {
                return pSUSModuleInstFuncBase.getUrl() == null;
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
        return PSUSModuleInstFuncBase.contains(this, n);
    }

    private static boolean contains(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSUSModuleInstFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSUSModuleInstFuncBase.isFuncTagDirty();
            }
            case 3: {
                return pSUSModuleInstFuncBase.isFuncTypeDirty();
            }
            case 4: {
                return pSUSModuleInstFuncBase.isMemoDirty();
            }
            case 5: {
                return pSUSModuleInstFuncBase.isMobileAppFlagDirty();
            }
            case 6: {
                return pSUSModuleInstFuncBase.isPSUSModuleInstFuncIdDirty();
            }
            case 7: {
                return pSUSModuleInstFuncBase.isPSUSModuleInstFuncNameDirty();
            }
            case 8: {
                return pSUSModuleInstFuncBase.isPSUSModuleInstIdDirty();
            }
            case 9: {
                return pSUSModuleInstFuncBase.isPSUSModuleInstNameDirty();
            }
            case 10: {
                return pSUSModuleInstFuncBase.isUpdateDateDirty();
            }
            case 11: {
                return pSUSModuleInstFuncBase.isUpdateManDirty();
            }
            case 12: {
                return pSUSModuleInstFuncBase.isUrlDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSModuleInstFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSModuleInstFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getFuncTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functag", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getFuncTag()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functype", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getFuncType()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getMobileAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobileappflag", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getMobileAppFlag()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstfuncid", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getPSUSModuleInstFuncId()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstfuncname", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getPSUSModuleInstFuncName()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstid", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getPSUSModuleInstId()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstname", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getPSUSModuleInstName()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUSModuleInstFuncBase.getUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"url", (Object)PSUSModuleInstFuncBase.getJSONValue((Object)pSUSModuleInstFuncBase.getUrl()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSModuleInstFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSModuleInstFuncBase.getCreateDate() != null) {
            object = pSUSModuleInstFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleInstFuncBase.getCreateMan() != null) {
            object = pSUSModuleInstFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getFuncTag() != null) {
            object = pSUSModuleInstFuncBase.getFuncTag();
            xmlNode.setAttribute(FIELD_FUNCTAG, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getFuncType() != null) {
            object = pSUSModuleInstFuncBase.getFuncType();
            xmlNode.setAttribute(FIELD_FUNCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getMemo() != null) {
            object = pSUSModuleInstFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getMobileAppFlag() != null) {
            object = pSUSModuleInstFuncBase.getMobileAppFlag();
            xmlNode.setAttribute(FIELD_MOBILEAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstFuncId() != null) {
            object = pSUSModuleInstFuncBase.getPSUSModuleInstFuncId();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstFuncName() != null) {
            object = pSUSModuleInstFuncBase.getPSUSModuleInstFuncName();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstId() != null) {
            object = pSUSModuleInstFuncBase.getPSUSModuleInstId();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getPSUSModuleInstName() != null) {
            object = pSUSModuleInstFuncBase.getPSUSModuleInstName();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getUpdateDate() != null) {
            object = pSUSModuleInstFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleInstFuncBase.getUpdateMan() != null) {
            object = pSUSModuleInstFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstFuncBase.getUrl() != null) {
            object = pSUSModuleInstFuncBase.getUrl();
            xmlNode.setAttribute(FIELD_URL, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSModuleInstFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSModuleInstFuncBase.isCreateDateDirty() && (bl || pSUSModuleInstFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSModuleInstFuncBase.getCreateDate());
        }
        if (pSUSModuleInstFuncBase.isCreateManDirty() && (bl || pSUSModuleInstFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSModuleInstFuncBase.getCreateMan());
        }
        if (pSUSModuleInstFuncBase.isFuncTagDirty() && (bl || pSUSModuleInstFuncBase.getFuncTag() != null)) {
            iDataObject.set(FIELD_FUNCTAG, (Object)pSUSModuleInstFuncBase.getFuncTag());
        }
        if (pSUSModuleInstFuncBase.isFuncTypeDirty() && (bl || pSUSModuleInstFuncBase.getFuncType() != null)) {
            iDataObject.set(FIELD_FUNCTYPE, (Object)pSUSModuleInstFuncBase.getFuncType());
        }
        if (pSUSModuleInstFuncBase.isMemoDirty() && (bl || pSUSModuleInstFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUSModuleInstFuncBase.getMemo());
        }
        if (pSUSModuleInstFuncBase.isMobileAppFlagDirty() && (bl || pSUSModuleInstFuncBase.getMobileAppFlag() != null)) {
            iDataObject.set(FIELD_MOBILEAPPFLAG, (Object)pSUSModuleInstFuncBase.getMobileAppFlag());
        }
        if (pSUSModuleInstFuncBase.isPSUSModuleInstFuncIdDirty() && (bl || pSUSModuleInstFuncBase.getPSUSModuleInstFuncId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTFUNCID, (Object)pSUSModuleInstFuncBase.getPSUSModuleInstFuncId());
        }
        if (pSUSModuleInstFuncBase.isPSUSModuleInstFuncNameDirty() && (bl || pSUSModuleInstFuncBase.getPSUSModuleInstFuncName() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTFUNCNAME, (Object)pSUSModuleInstFuncBase.getPSUSModuleInstFuncName());
        }
        if (pSUSModuleInstFuncBase.isPSUSModuleInstIdDirty() && (bl || pSUSModuleInstFuncBase.getPSUSModuleInstId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTID, (Object)pSUSModuleInstFuncBase.getPSUSModuleInstId());
        }
        if (pSUSModuleInstFuncBase.isPSUSModuleInstNameDirty() && (bl || pSUSModuleInstFuncBase.getPSUSModuleInstName() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTNAME, (Object)pSUSModuleInstFuncBase.getPSUSModuleInstName());
        }
        if (pSUSModuleInstFuncBase.isUpdateDateDirty() && (bl || pSUSModuleInstFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSModuleInstFuncBase.getUpdateDate());
        }
        if (pSUSModuleInstFuncBase.isUpdateManDirty() && (bl || pSUSModuleInstFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSModuleInstFuncBase.getUpdateMan());
        }
        if (pSUSModuleInstFuncBase.isUrlDirty() && (bl || pSUSModuleInstFuncBase.getUrl() != null)) {
            iDataObject.set(FIELD_URL, (Object)pSUSModuleInstFuncBase.getUrl());
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
        return PSUSModuleInstFuncBase.remove(this, n);
    }

    private static boolean remove(PSUSModuleInstFuncBase pSUSModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleInstFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUSModuleInstFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUSModuleInstFuncBase.resetFuncTag();
                return true;
            }
            case 3: {
                pSUSModuleInstFuncBase.resetFuncType();
                return true;
            }
            case 4: {
                pSUSModuleInstFuncBase.resetMemo();
                return true;
            }
            case 5: {
                pSUSModuleInstFuncBase.resetMobileAppFlag();
                return true;
            }
            case 6: {
                pSUSModuleInstFuncBase.resetPSUSModuleInstFuncId();
                return true;
            }
            case 7: {
                pSUSModuleInstFuncBase.resetPSUSModuleInstFuncName();
                return true;
            }
            case 8: {
                pSUSModuleInstFuncBase.resetPSUSModuleInstId();
                return true;
            }
            case 9: {
                pSUSModuleInstFuncBase.resetPSUSModuleInstName();
                return true;
            }
            case 10: {
                pSUSModuleInstFuncBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSUSModuleInstFuncBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSUSModuleInstFuncBase.resetUrl();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSModuleInst getPSUSModuleInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInst();
        }
        if (this.getPSUSModuleInstId() == null) {
            return null;
        }
        Integer n = this.objPSUSModuleInstLock;
        synchronized (n) {
            if (this.psusmoduleinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSModuleInstId(), (Object)this.psusmoduleinst.getPSUSModuleInstId()) != 0L) {
                this.psusmoduleinst = null;
            }
            if (this.psusmoduleinst == null) {
                PSUSModuleInst pSUSModuleInst = new PSUSModuleInst();
                pSUSModuleInst.setPSUSModuleInstId(this.getPSUSModuleInstId());
                PSUSModuleInstService pSUSModuleInstService = (PSUSModuleInstService)ServiceGlobal.getService(PSUSModuleInstService.class, (SessionFactory)this.getSessionFactory());
                pSUSModuleInstService.autoGet((IEntity)pSUSModuleInst);
                this.psusmoduleinst = pSUSModuleInst;
            }
            return this.psusmoduleinst;
        }
    }

    private PSUSModuleInstFuncBase getProxyEntity() {
        return this.proxyPSUSModuleInstFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSModuleInstFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSModuleInstFuncBase) {
            this.proxyPSUSModuleInstFuncBase = (PSUSModuleInstFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FUNCTAG, 2);
        fieldIndexMap.put(FIELD_FUNCTYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MOBILEAPPFLAG, 5);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTFUNCID, 6);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTFUNCNAME, 7);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTID, 8);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_URL, 12);
    }
}

