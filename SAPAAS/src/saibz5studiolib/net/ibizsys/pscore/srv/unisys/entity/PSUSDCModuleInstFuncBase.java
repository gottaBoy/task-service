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
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstFunc;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstFuncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCModuleInstFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSDCModuleInstFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCTAG = "FUNCTAG";
    public static final String FIELD_FUNCTYPE = "FUNCTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBILEAPPFLAG = "MOBILEAPPFLAG";
    public static final String FIELD_PSUSDCMODULEINSTFUNCID = "PSUSDCMODULEINSTFUNCID";
    public static final String FIELD_PSUSDCMODULEINSTFUNCNAME = "PSUSDCMODULEINSTFUNCNAME";
    public static final String FIELD_PSUSDCMODULEINSTID = "PSUSDCMODULEINSTID";
    public static final String FIELD_PSUSDCMODULEINSTNAME = "PSUSDCMODULEINSTNAME";
    public static final String FIELD_PSUSMODULEINSTFUNCID = "PSUSMODULEINSTFUNCID";
    public static final String FIELD_PSUSMODULEINSTFUNCNAME = "PSUSMODULEINSTFUNCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_URL = "URL";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FUNCTAG = 2;
    private static final int INDEX_FUNCTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MOBILEAPPFLAG = 5;
    private static final int INDEX_PSUSDCMODULEINSTFUNCID = 6;
    private static final int INDEX_PSUSDCMODULEINSTFUNCNAME = 7;
    private static final int INDEX_PSUSDCMODULEINSTID = 8;
    private static final int INDEX_PSUSDCMODULEINSTNAME = 9;
    private static final int INDEX_PSUSMODULEINSTFUNCID = 10;
    private static final int INDEX_PSUSMODULEINSTFUNCNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_URL = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSDCModuleInstFuncBase proxyPSUSDCModuleInstFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean functagDirtyFlag = false;
    private boolean functypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobileappflagDirtyFlag = false;
    private boolean psusdcmoduleinstfuncidDirtyFlag = false;
    private boolean psusdcmoduleinstfuncnameDirtyFlag = false;
    private boolean psusdcmoduleinstidDirtyFlag = false;
    private boolean psusdcmoduleinstnameDirtyFlag = false;
    private boolean psusmoduleinstfuncidDirtyFlag = false;
    private boolean psusmoduleinstfuncnameDirtyFlag = false;
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
    @Column(name="psusdcmoduleinstfuncid")
    private String psusdcmoduleinstfuncid;
    @Column(name="psusdcmoduleinstfuncname")
    private String psusdcmoduleinstfuncname;
    @Column(name="psusdcmoduleinstid")
    private String psusdcmoduleinstid;
    @Column(name="psusdcmoduleinstname")
    private String psusdcmoduleinstname;
    @Column(name="psusmoduleinstfuncid")
    private String psusmoduleinstfuncid;
    @Column(name="psusmoduleinstfuncname")
    private String psusmoduleinstfuncname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="url")
    private String url;
    private Integer objPSUSDCModuleInstLock = new Integer(1);
    private PSUSDCModuleInst psusdcmoduleinst = null;
    private Integer objPSUSModuleInstFuncLock = new Integer(1);
    private PSUSModuleInstFunc psusmoduleinstfunc = null;

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

    public void setPSUSDCModuleInstFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstfuncid = string;
        this.psusdcmoduleinstfuncidDirtyFlag = true;
    }

    public String getPSUSDCModuleInstFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstFuncId();
        }
        return this.psusdcmoduleinstfuncid;
    }

    public boolean isPSUSDCModuleInstFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstFuncIdDirty();
        }
        return this.psusdcmoduleinstfuncidDirtyFlag;
    }

    public void resetPSUSDCModuleInstFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstFuncId();
            return;
        }
        this.psusdcmoduleinstfuncidDirtyFlag = false;
        this.psusdcmoduleinstfuncid = null;
    }

    public void setPSUSDCModuleInstFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstfuncname = string;
        this.psusdcmoduleinstfuncnameDirtyFlag = true;
    }

    public String getPSUSDCModuleInstFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstFuncName();
        }
        return this.psusdcmoduleinstfuncname;
    }

    public boolean isPSUSDCModuleInstFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstFuncNameDirty();
        }
        return this.psusdcmoduleinstfuncnameDirtyFlag;
    }

    public void resetPSUSDCModuleInstFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstFuncName();
            return;
        }
        this.psusdcmoduleinstfuncnameDirtyFlag = false;
        this.psusdcmoduleinstfuncname = null;
    }

    public void setPSUSDCModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstid = string;
        this.psusdcmoduleinstidDirtyFlag = true;
    }

    public String getPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstId();
        }
        return this.psusdcmoduleinstid;
    }

    public boolean isPSUSDCModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstIdDirty();
        }
        return this.psusdcmoduleinstidDirtyFlag;
    }

    public void resetPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstId();
            return;
        }
        this.psusdcmoduleinstidDirtyFlag = false;
        this.psusdcmoduleinstid = null;
    }

    public void setPSUSDCModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstname = string;
        this.psusdcmoduleinstnameDirtyFlag = true;
    }

    public String getPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstName();
        }
        return this.psusdcmoduleinstname;
    }

    public boolean isPSUSDCModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstNameDirty();
        }
        return this.psusdcmoduleinstnameDirtyFlag;
    }

    public void resetPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstName();
            return;
        }
        this.psusdcmoduleinstnameDirtyFlag = false;
        this.psusdcmoduleinstname = null;
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
        PSUSDCModuleInstFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase) {
        pSUSDCModuleInstFuncBase.resetCreateDate();
        pSUSDCModuleInstFuncBase.resetCreateMan();
        pSUSDCModuleInstFuncBase.resetFuncTag();
        pSUSDCModuleInstFuncBase.resetFuncType();
        pSUSDCModuleInstFuncBase.resetMemo();
        pSUSDCModuleInstFuncBase.resetMobileAppFlag();
        pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstFuncId();
        pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstFuncName();
        pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstId();
        pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstName();
        pSUSDCModuleInstFuncBase.resetPSUSModuleInstFuncId();
        pSUSDCModuleInstFuncBase.resetPSUSModuleInstFuncName();
        pSUSDCModuleInstFuncBase.resetUpdateDate();
        pSUSDCModuleInstFuncBase.resetUpdateMan();
        pSUSDCModuleInstFuncBase.resetUrl();
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
        if (!bl || this.isPSUSDCModuleInstFuncIdDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTFUNCID, this.getPSUSDCModuleInstFuncId());
        }
        if (!bl || this.isPSUSDCModuleInstFuncNameDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTFUNCNAME, this.getPSUSDCModuleInstFuncName());
        }
        if (!bl || this.isPSUSDCModuleInstIdDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTID, this.getPSUSDCModuleInstId());
        }
        if (!bl || this.isPSUSDCModuleInstNameDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTNAME, this.getPSUSDCModuleInstName());
        }
        if (!bl || this.isPSUSModuleInstFuncIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTFUNCID, this.getPSUSModuleInstFuncId());
        }
        if (!bl || this.isPSUSModuleInstFuncNameDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTFUNCNAME, this.getPSUSModuleInstFuncName());
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
        return PSUSDCModuleInstFuncBase.get(this, n);
    }

    private static Object get(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstFuncBase.getCreateDate();
            }
            case 1: {
                return pSUSDCModuleInstFuncBase.getCreateMan();
            }
            case 2: {
                return pSUSDCModuleInstFuncBase.getFuncTag();
            }
            case 3: {
                return pSUSDCModuleInstFuncBase.getFuncType();
            }
            case 4: {
                return pSUSDCModuleInstFuncBase.getMemo();
            }
            case 5: {
                return pSUSDCModuleInstFuncBase.getMobileAppFlag();
            }
            case 6: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId();
            }
            case 7: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName();
            }
            case 8: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId();
            }
            case 9: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName();
            }
            case 10: {
                return pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId();
            }
            case 11: {
                return pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName();
            }
            case 12: {
                return pSUSDCModuleInstFuncBase.getUpdateDate();
            }
            case 13: {
                return pSUSDCModuleInstFuncBase.getUpdateMan();
            }
            case 14: {
                return pSUSDCModuleInstFuncBase.getUrl();
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
        PSUSDCModuleInstFuncBase.set(this, n, object);
    }

    private static void set(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleInstFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUSDCModuleInstFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSDCModuleInstFuncBase.setFuncTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSDCModuleInstFuncBase.setFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSDCModuleInstFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSDCModuleInstFuncBase.setMobileAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSUSDCModuleInstFuncBase.setPSUSDCModuleInstFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUSDCModuleInstFuncBase.setPSUSDCModuleInstFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUSDCModuleInstFuncBase.setPSUSDCModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUSDCModuleInstFuncBase.setPSUSDCModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUSDCModuleInstFuncBase.setPSUSModuleInstFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUSDCModuleInstFuncBase.setPSUSModuleInstFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUSDCModuleInstFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSUSDCModuleInstFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUSDCModuleInstFuncBase.setUrl(DataObject.getStringValue((Object)object));
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
        return PSUSDCModuleInstFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSUSDCModuleInstFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSUSDCModuleInstFuncBase.getFuncTag() == null;
            }
            case 3: {
                return pSUSDCModuleInstFuncBase.getFuncType() == null;
            }
            case 4: {
                return pSUSDCModuleInstFuncBase.getMemo() == null;
            }
            case 5: {
                return pSUSDCModuleInstFuncBase.getMobileAppFlag() == null;
            }
            case 6: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId() == null;
            }
            case 7: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName() == null;
            }
            case 8: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId() == null;
            }
            case 9: {
                return pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName() == null;
            }
            case 10: {
                return pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId() == null;
            }
            case 11: {
                return pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName() == null;
            }
            case 12: {
                return pSUSDCModuleInstFuncBase.getUpdateDate() == null;
            }
            case 13: {
                return pSUSDCModuleInstFuncBase.getUpdateMan() == null;
            }
            case 14: {
                return pSUSDCModuleInstFuncBase.getUrl() == null;
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
        return PSUSDCModuleInstFuncBase.contains(this, n);
    }

    private static boolean contains(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSUSDCModuleInstFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSUSDCModuleInstFuncBase.isFuncTagDirty();
            }
            case 3: {
                return pSUSDCModuleInstFuncBase.isFuncTypeDirty();
            }
            case 4: {
                return pSUSDCModuleInstFuncBase.isMemoDirty();
            }
            case 5: {
                return pSUSDCModuleInstFuncBase.isMobileAppFlagDirty();
            }
            case 6: {
                return pSUSDCModuleInstFuncBase.isPSUSDCModuleInstFuncIdDirty();
            }
            case 7: {
                return pSUSDCModuleInstFuncBase.isPSUSDCModuleInstFuncNameDirty();
            }
            case 8: {
                return pSUSDCModuleInstFuncBase.isPSUSDCModuleInstIdDirty();
            }
            case 9: {
                return pSUSDCModuleInstFuncBase.isPSUSDCModuleInstNameDirty();
            }
            case 10: {
                return pSUSDCModuleInstFuncBase.isPSUSModuleInstFuncIdDirty();
            }
            case 11: {
                return pSUSDCModuleInstFuncBase.isPSUSModuleInstFuncNameDirty();
            }
            case 12: {
                return pSUSDCModuleInstFuncBase.isUpdateDateDirty();
            }
            case 13: {
                return pSUSDCModuleInstFuncBase.isUpdateManDirty();
            }
            case 14: {
                return pSUSDCModuleInstFuncBase.isUrlDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSDCModuleInstFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSDCModuleInstFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getFuncTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functag", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getFuncTag()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functype", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getFuncType()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getMobileAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobileappflag", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getMobileAppFlag()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstfuncid", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstfuncname", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstid", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstname", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstfuncid", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstfuncname", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstFuncBase.getUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"url", (Object)PSUSDCModuleInstFuncBase.getJSONValue((Object)pSUSDCModuleInstFuncBase.getUrl()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSDCModuleInstFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSDCModuleInstFuncBase.getCreateDate() != null) {
            object = pSUSDCModuleInstFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleInstFuncBase.getCreateMan() != null) {
            object = pSUSDCModuleInstFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getFuncTag() != null) {
            object = pSUSDCModuleInstFuncBase.getFuncTag();
            xmlNode.setAttribute(FIELD_FUNCTAG, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getFuncType() != null) {
            object = pSUSDCModuleInstFuncBase.getFuncType();
            xmlNode.setAttribute(FIELD_FUNCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getMemo() != null) {
            object = pSUSDCModuleInstFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getMobileAppFlag() != null) {
            object = pSUSDCModuleInstFuncBase.getMobileAppFlag();
            xmlNode.setAttribute(FIELD_MOBILEAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId() != null) {
            object = pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName() != null) {
            object = pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId() != null) {
            object = pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName() != null) {
            object = pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId() != null) {
            object = pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName() != null) {
            object = pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getUpdateDate() != null) {
            object = pSUSDCModuleInstFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleInstFuncBase.getUpdateMan() != null) {
            object = pSUSDCModuleInstFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstFuncBase.getUrl() != null) {
            object = pSUSDCModuleInstFuncBase.getUrl();
            xmlNode.setAttribute(FIELD_URL, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSDCModuleInstFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSDCModuleInstFuncBase.isCreateDateDirty() && (bl || pSUSDCModuleInstFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSDCModuleInstFuncBase.getCreateDate());
        }
        if (pSUSDCModuleInstFuncBase.isCreateManDirty() && (bl || pSUSDCModuleInstFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSDCModuleInstFuncBase.getCreateMan());
        }
        if (pSUSDCModuleInstFuncBase.isFuncTagDirty() && (bl || pSUSDCModuleInstFuncBase.getFuncTag() != null)) {
            iDataObject.set(FIELD_FUNCTAG, (Object)pSUSDCModuleInstFuncBase.getFuncTag());
        }
        if (pSUSDCModuleInstFuncBase.isFuncTypeDirty() && (bl || pSUSDCModuleInstFuncBase.getFuncType() != null)) {
            iDataObject.set(FIELD_FUNCTYPE, (Object)pSUSDCModuleInstFuncBase.getFuncType());
        }
        if (pSUSDCModuleInstFuncBase.isMemoDirty() && (bl || pSUSDCModuleInstFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUSDCModuleInstFuncBase.getMemo());
        }
        if (pSUSDCModuleInstFuncBase.isMobileAppFlagDirty() && (bl || pSUSDCModuleInstFuncBase.getMobileAppFlag() != null)) {
            iDataObject.set(FIELD_MOBILEAPPFLAG, (Object)pSUSDCModuleInstFuncBase.getMobileAppFlag());
        }
        if (pSUSDCModuleInstFuncBase.isPSUSDCModuleInstFuncIdDirty() && (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTFUNCID, (Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncId());
        }
        if (pSUSDCModuleInstFuncBase.isPSUSDCModuleInstFuncNameDirty() && (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTFUNCNAME, (Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstFuncName());
        }
        if (pSUSDCModuleInstFuncBase.isPSUSDCModuleInstIdDirty() && (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTID, (Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstId());
        }
        if (pSUSDCModuleInstFuncBase.isPSUSDCModuleInstNameDirty() && (bl || pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTNAME, (Object)pSUSDCModuleInstFuncBase.getPSUSDCModuleInstName());
        }
        if (pSUSDCModuleInstFuncBase.isPSUSModuleInstFuncIdDirty() && (bl || pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTFUNCID, (Object)pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncId());
        }
        if (pSUSDCModuleInstFuncBase.isPSUSModuleInstFuncNameDirty() && (bl || pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTFUNCNAME, (Object)pSUSDCModuleInstFuncBase.getPSUSModuleInstFuncName());
        }
        if (pSUSDCModuleInstFuncBase.isUpdateDateDirty() && (bl || pSUSDCModuleInstFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSDCModuleInstFuncBase.getUpdateDate());
        }
        if (pSUSDCModuleInstFuncBase.isUpdateManDirty() && (bl || pSUSDCModuleInstFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSDCModuleInstFuncBase.getUpdateMan());
        }
        if (pSUSDCModuleInstFuncBase.isUrlDirty() && (bl || pSUSDCModuleInstFuncBase.getUrl() != null)) {
            iDataObject.set(FIELD_URL, (Object)pSUSDCModuleInstFuncBase.getUrl());
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
        return PSUSDCModuleInstFuncBase.remove(this, n);
    }

    private static boolean remove(PSUSDCModuleInstFuncBase pSUSDCModuleInstFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleInstFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUSDCModuleInstFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUSDCModuleInstFuncBase.resetFuncTag();
                return true;
            }
            case 3: {
                pSUSDCModuleInstFuncBase.resetFuncType();
                return true;
            }
            case 4: {
                pSUSDCModuleInstFuncBase.resetMemo();
                return true;
            }
            case 5: {
                pSUSDCModuleInstFuncBase.resetMobileAppFlag();
                return true;
            }
            case 6: {
                pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstFuncId();
                return true;
            }
            case 7: {
                pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstFuncName();
                return true;
            }
            case 8: {
                pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstId();
                return true;
            }
            case 9: {
                pSUSDCModuleInstFuncBase.resetPSUSDCModuleInstName();
                return true;
            }
            case 10: {
                pSUSDCModuleInstFuncBase.resetPSUSModuleInstFuncId();
                return true;
            }
            case 11: {
                pSUSDCModuleInstFuncBase.resetPSUSModuleInstFuncName();
                return true;
            }
            case 12: {
                pSUSDCModuleInstFuncBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSUSDCModuleInstFuncBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSUSDCModuleInstFuncBase.resetUrl();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSDCModuleInst getPSUSDCModuleInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInst();
        }
        if (this.getPSUSDCModuleInstId() == null) {
            return null;
        }
        Integer n = this.objPSUSDCModuleInstLock;
        synchronized (n) {
            if (this.psusdcmoduleinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSDCModuleInstId(), (Object)this.psusdcmoduleinst.getPSUSDCModuleInstId()) != 0L) {
                this.psusdcmoduleinst = null;
            }
            if (this.psusdcmoduleinst == null) {
                PSUSDCModuleInst pSUSDCModuleInst = new PSUSDCModuleInst();
                pSUSDCModuleInst.setPSUSDCModuleInstId(this.getPSUSDCModuleInstId());
                PSUSDCModuleInstService pSUSDCModuleInstService = (PSUSDCModuleInstService)ServiceGlobal.getService(PSUSDCModuleInstService.class, (SessionFactory)this.getSessionFactory());
                pSUSDCModuleInstService.autoGet((IEntity)pSUSDCModuleInst);
                this.psusdcmoduleinst = pSUSDCModuleInst;
            }
            return this.psusdcmoduleinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSModuleInstFunc getPSUSModuleInstFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstFunc();
        }
        if (this.getPSUSModuleInstFuncId() == null) {
            return null;
        }
        Integer n = this.objPSUSModuleInstFuncLock;
        synchronized (n) {
            if (this.psusmoduleinstfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSModuleInstFuncId(), (Object)this.psusmoduleinstfunc.getPSUSModuleInstFuncId()) != 0L) {
                this.psusmoduleinstfunc = null;
            }
            if (this.psusmoduleinstfunc == null) {
                PSUSModuleInstFunc pSUSModuleInstFunc = new PSUSModuleInstFunc();
                pSUSModuleInstFunc.setPSUSModuleInstFuncId(this.getPSUSModuleInstFuncId());
                PSUSModuleInstFuncService pSUSModuleInstFuncService = (PSUSModuleInstFuncService)ServiceGlobal.getService(PSUSModuleInstFuncService.class, (SessionFactory)this.getSessionFactory());
                pSUSModuleInstFuncService.autoGet((IEntity)pSUSModuleInstFunc);
                this.psusmoduleinstfunc = pSUSModuleInstFunc;
            }
            return this.psusmoduleinstfunc;
        }
    }

    private PSUSDCModuleInstFuncBase getProxyEntity() {
        return this.proxyPSUSDCModuleInstFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSDCModuleInstFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSDCModuleInstFuncBase) {
            this.proxyPSUSDCModuleInstFuncBase = (PSUSDCModuleInstFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTFUNCID, 6);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTFUNCNAME, 7);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTID, 8);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTNAME, 9);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTFUNCID, 10);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTFUNCNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_URL, 14);
    }
}

