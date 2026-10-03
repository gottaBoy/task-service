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
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModule;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstFunc;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstRef;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstFuncService;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstRefService;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSModuleInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSModuleInstBase.class);
    public static final String FIELD_ADMINSERVICEURL = "ADMINSERVICEURL";
    public static final String FIELD_ADMINURL = "ADMINURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSUSMODULEID = "PSUSMODULEID";
    public static final String FIELD_PSUSMODULEINSTID = "PSUSMODULEINSTID";
    public static final String FIELD_PSUSMODULEINSTNAME = "PSUSMODULEINSTNAME";
    public static final String FIELD_PSUSMODULENAME = "PSUSMODULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ADMINSERVICEURL = 0;
    private static final int INDEX_ADMINURL = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSUSMODULEID = 5;
    private static final int INDEX_PSUSMODULEINSTID = 6;
    private static final int INDEX_PSUSMODULEINSTNAME = 7;
    private static final int INDEX_PSUSMODULENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSModuleInstBase proxyPSUSModuleInstBase = null;
    private boolean adminserviceurlDirtyFlag = false;
    private boolean adminurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psusmoduleidDirtyFlag = false;
    private boolean psusmoduleinstidDirtyFlag = false;
    private boolean psusmoduleinstnameDirtyFlag = false;
    private boolean psusmodulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="adminserviceurl")
    private String adminserviceurl;
    @Column(name="adminurl")
    private String adminurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psusmoduleid")
    private String psusmoduleid;
    @Column(name="psusmoduleinstid")
    private String psusmoduleinstid;
    @Column(name="psusmoduleinstname")
    private String psusmoduleinstname;
    @Column(name="psusmodulename")
    private String psusmodulename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSUSModuleLock = new Integer(1);
    private PSUSModule psusmodule = null;
    private Integer objPSUSDCModuleInstsLock = new Integer(1);
    private ArrayList<PSUSDCModuleInst> psusdcmoduleinsts = null;
    private Integer objPSUSModuleInstFuncsLock = new Integer(1);
    private ArrayList<PSUSModuleInstFunc> psusmoduleinstfuncs = null;
    private Integer objPSUSModuleInstRefsLock = new Integer(1);
    private ArrayList<PSUSModuleInstRef> psusmoduleinstrefs = null;

    public void setAdminServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminserviceurl = string;
        this.adminserviceurlDirtyFlag = true;
    }

    public String getAdminServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminServiceUrl();
        }
        return this.adminserviceurl;
    }

    public boolean isAdminServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminServiceUrlDirty();
        }
        return this.adminserviceurlDirtyFlag;
    }

    public void resetAdminServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminServiceUrl();
            return;
        }
        this.adminserviceurlDirtyFlag = false;
        this.adminserviceurl = null;
    }

    public void setAdminUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminurl = string;
        this.adminurlDirtyFlag = true;
    }

    public String getAdminUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminUrl();
        }
        return this.adminurl;
    }

    public boolean isAdminUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminUrlDirty();
        }
        return this.adminurlDirtyFlag;
    }

    public void resetAdminUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminUrl();
            return;
        }
        this.adminurlDirtyFlag = false;
        this.adminurl = null;
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

    public void setPSUSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleid = string;
        this.psusmoduleidDirtyFlag = true;
    }

    public String getPSUSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleId();
        }
        return this.psusmoduleid;
    }

    public boolean isPSUSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleIdDirty();
        }
        return this.psusmoduleidDirtyFlag;
    }

    public void resetPSUSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleId();
            return;
        }
        this.psusmoduleidDirtyFlag = false;
        this.psusmoduleid = null;
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

    public void setPSUSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmodulename = string;
        this.psusmodulenameDirtyFlag = true;
    }

    public String getPSUSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleName();
        }
        return this.psusmodulename;
    }

    public boolean isPSUSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleNameDirty();
        }
        return this.psusmodulenameDirtyFlag;
    }

    public void resetPSUSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleName();
            return;
        }
        this.psusmodulenameDirtyFlag = false;
        this.psusmodulename = null;
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
        PSUSModuleInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSModuleInstBase pSUSModuleInstBase) {
        pSUSModuleInstBase.resetAdminServiceUrl();
        pSUSModuleInstBase.resetAdminUrl();
        pSUSModuleInstBase.resetCreateDate();
        pSUSModuleInstBase.resetCreateMan();
        pSUSModuleInstBase.resetMemo();
        pSUSModuleInstBase.resetPSUSModuleId();
        pSUSModuleInstBase.resetPSUSModuleInstId();
        pSUSModuleInstBase.resetPSUSModuleInstName();
        pSUSModuleInstBase.resetPSUSModuleName();
        pSUSModuleInstBase.resetUpdateDate();
        pSUSModuleInstBase.resetUpdateMan();
        pSUSModuleInstBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminServiceUrlDirty()) {
            hashMap.put(FIELD_ADMINSERVICEURL, this.getAdminServiceUrl());
        }
        if (!bl || this.isAdminUrlDirty()) {
            hashMap.put(FIELD_ADMINURL, this.getAdminUrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSUSModuleIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEID, this.getPSUSModuleId());
        }
        if (!bl || this.isPSUSModuleInstIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTID, this.getPSUSModuleInstId());
        }
        if (!bl || this.isPSUSModuleInstNameDirty()) {
            hashMap.put(FIELD_PSUSMODULEINSTNAME, this.getPSUSModuleInstName());
        }
        if (!bl || this.isPSUSModuleNameDirty()) {
            hashMap.put(FIELD_PSUSMODULENAME, this.getPSUSModuleName());
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
        return PSUSModuleInstBase.get(this, n);
    }

    private static Object get(PSUSModuleInstBase pSUSModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstBase.getAdminServiceUrl();
            }
            case 1: {
                return pSUSModuleInstBase.getAdminUrl();
            }
            case 2: {
                return pSUSModuleInstBase.getCreateDate();
            }
            case 3: {
                return pSUSModuleInstBase.getCreateMan();
            }
            case 4: {
                return pSUSModuleInstBase.getMemo();
            }
            case 5: {
                return pSUSModuleInstBase.getPSUSModuleId();
            }
            case 6: {
                return pSUSModuleInstBase.getPSUSModuleInstId();
            }
            case 7: {
                return pSUSModuleInstBase.getPSUSModuleInstName();
            }
            case 8: {
                return pSUSModuleInstBase.getPSUSModuleName();
            }
            case 9: {
                return pSUSModuleInstBase.getUpdateDate();
            }
            case 10: {
                return pSUSModuleInstBase.getUpdateMan();
            }
            case 11: {
                return pSUSModuleInstBase.getValidFlag();
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
        PSUSModuleInstBase.set(this, n, object);
    }

    private static void set(PSUSModuleInstBase pSUSModuleInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleInstBase.setAdminServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUSModuleInstBase.setAdminUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSModuleInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSUSModuleInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSModuleInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSModuleInstBase.setPSUSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUSModuleInstBase.setPSUSModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUSModuleInstBase.setPSUSModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUSModuleInstBase.setPSUSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUSModuleInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSUSModuleInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUSModuleInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUSModuleInstBase.isNull(this, n);
    }

    private static boolean isNull(PSUSModuleInstBase pSUSModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstBase.getAdminServiceUrl() == null;
            }
            case 1: {
                return pSUSModuleInstBase.getAdminUrl() == null;
            }
            case 2: {
                return pSUSModuleInstBase.getCreateDate() == null;
            }
            case 3: {
                return pSUSModuleInstBase.getCreateMan() == null;
            }
            case 4: {
                return pSUSModuleInstBase.getMemo() == null;
            }
            case 5: {
                return pSUSModuleInstBase.getPSUSModuleId() == null;
            }
            case 6: {
                return pSUSModuleInstBase.getPSUSModuleInstId() == null;
            }
            case 7: {
                return pSUSModuleInstBase.getPSUSModuleInstName() == null;
            }
            case 8: {
                return pSUSModuleInstBase.getPSUSModuleName() == null;
            }
            case 9: {
                return pSUSModuleInstBase.getUpdateDate() == null;
            }
            case 10: {
                return pSUSModuleInstBase.getUpdateMan() == null;
            }
            case 11: {
                return pSUSModuleInstBase.getValidFlag() == null;
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
        return PSUSModuleInstBase.contains(this, n);
    }

    private static boolean contains(PSUSModuleInstBase pSUSModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleInstBase.isAdminServiceUrlDirty();
            }
            case 1: {
                return pSUSModuleInstBase.isAdminUrlDirty();
            }
            case 2: {
                return pSUSModuleInstBase.isCreateDateDirty();
            }
            case 3: {
                return pSUSModuleInstBase.isCreateManDirty();
            }
            case 4: {
                return pSUSModuleInstBase.isMemoDirty();
            }
            case 5: {
                return pSUSModuleInstBase.isPSUSModuleIdDirty();
            }
            case 6: {
                return pSUSModuleInstBase.isPSUSModuleInstIdDirty();
            }
            case 7: {
                return pSUSModuleInstBase.isPSUSModuleInstNameDirty();
            }
            case 8: {
                return pSUSModuleInstBase.isPSUSModuleNameDirty();
            }
            case 9: {
                return pSUSModuleInstBase.isUpdateDateDirty();
            }
            case 10: {
                return pSUSModuleInstBase.isUpdateManDirty();
            }
            case 11: {
                return pSUSModuleInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSModuleInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSModuleInstBase pSUSModuleInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSModuleInstBase.getAdminServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminserviceurl", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getAdminServiceUrl()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getAdminUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminurl", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getAdminUrl()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleid", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getPSUSModuleId()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstid", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getPSUSModuleInstId()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleinstname", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getPSUSModuleInstName()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmodulename", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getPSUSModuleName()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUSModuleInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUSModuleInstBase.getJSONValue((Object)pSUSModuleInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSModuleInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSModuleInstBase pSUSModuleInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSModuleInstBase.getAdminServiceUrl() != null) {
            object = pSUSModuleInstBase.getAdminServiceUrl();
            xmlNode.setAttribute(FIELD_ADMINSERVICEURL, (String)(object == null ? "" : object));
        }
        if (bl || pSUSModuleInstBase.getAdminUrl() != null) {
            object = pSUSModuleInstBase.getAdminUrl();
            xmlNode.setAttribute(FIELD_ADMINURL, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getCreateDate() != null) {
            object = pSUSModuleInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleInstBase.getCreateMan() != null) {
            object = pSUSModuleInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getMemo() != null) {
            object = pSUSModuleInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleId() != null) {
            object = pSUSModuleInstBase.getPSUSModuleId();
            xmlNode.setAttribute(FIELD_PSUSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleInstId() != null) {
            object = pSUSModuleInstBase.getPSUSModuleInstId();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleInstName() != null) {
            object = pSUSModuleInstBase.getPSUSModuleInstName();
            xmlNode.setAttribute(FIELD_PSUSMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getPSUSModuleName() != null) {
            object = pSUSModuleInstBase.getPSUSModuleName();
            xmlNode.setAttribute(FIELD_PSUSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getUpdateDate() != null) {
            object = pSUSModuleInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleInstBase.getUpdateMan() != null) {
            object = pSUSModuleInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleInstBase.getValidFlag() != null) {
            object = pSUSModuleInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSModuleInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSModuleInstBase pSUSModuleInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSModuleInstBase.isAdminServiceUrlDirty() && (bl || pSUSModuleInstBase.getAdminServiceUrl() != null)) {
            iDataObject.set(FIELD_ADMINSERVICEURL, (Object)pSUSModuleInstBase.getAdminServiceUrl());
        }
        if (pSUSModuleInstBase.isAdminUrlDirty() && (bl || pSUSModuleInstBase.getAdminUrl() != null)) {
            iDataObject.set(FIELD_ADMINURL, (Object)pSUSModuleInstBase.getAdminUrl());
        }
        if (pSUSModuleInstBase.isCreateDateDirty() && (bl || pSUSModuleInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSModuleInstBase.getCreateDate());
        }
        if (pSUSModuleInstBase.isCreateManDirty() && (bl || pSUSModuleInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSModuleInstBase.getCreateMan());
        }
        if (pSUSModuleInstBase.isMemoDirty() && (bl || pSUSModuleInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUSModuleInstBase.getMemo());
        }
        if (pSUSModuleInstBase.isPSUSModuleIdDirty() && (bl || pSUSModuleInstBase.getPSUSModuleId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEID, (Object)pSUSModuleInstBase.getPSUSModuleId());
        }
        if (pSUSModuleInstBase.isPSUSModuleInstIdDirty() && (bl || pSUSModuleInstBase.getPSUSModuleInstId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTID, (Object)pSUSModuleInstBase.getPSUSModuleInstId());
        }
        if (pSUSModuleInstBase.isPSUSModuleInstNameDirty() && (bl || pSUSModuleInstBase.getPSUSModuleInstName() != null)) {
            iDataObject.set(FIELD_PSUSMODULEINSTNAME, (Object)pSUSModuleInstBase.getPSUSModuleInstName());
        }
        if (pSUSModuleInstBase.isPSUSModuleNameDirty() && (bl || pSUSModuleInstBase.getPSUSModuleName() != null)) {
            iDataObject.set(FIELD_PSUSMODULENAME, (Object)pSUSModuleInstBase.getPSUSModuleName());
        }
        if (pSUSModuleInstBase.isUpdateDateDirty() && (bl || pSUSModuleInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSModuleInstBase.getUpdateDate());
        }
        if (pSUSModuleInstBase.isUpdateManDirty() && (bl || pSUSModuleInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSModuleInstBase.getUpdateMan());
        }
        if (pSUSModuleInstBase.isValidFlagDirty() && (bl || pSUSModuleInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUSModuleInstBase.getValidFlag());
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
        return PSUSModuleInstBase.remove(this, n);
    }

    private static boolean remove(PSUSModuleInstBase pSUSModuleInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleInstBase.resetAdminServiceUrl();
                return true;
            }
            case 1: {
                pSUSModuleInstBase.resetAdminUrl();
                return true;
            }
            case 2: {
                pSUSModuleInstBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSUSModuleInstBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSUSModuleInstBase.resetMemo();
                return true;
            }
            case 5: {
                pSUSModuleInstBase.resetPSUSModuleId();
                return true;
            }
            case 6: {
                pSUSModuleInstBase.resetPSUSModuleInstId();
                return true;
            }
            case 7: {
                pSUSModuleInstBase.resetPSUSModuleInstName();
                return true;
            }
            case 8: {
                pSUSModuleInstBase.resetPSUSModuleName();
                return true;
            }
            case 9: {
                pSUSModuleInstBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSUSModuleInstBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSUSModuleInstBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSModule getPSUSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModule();
        }
        if (this.getPSUSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSUSModuleLock;
        synchronized (n) {
            if (this.psusmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSModuleId(), (Object)this.psusmodule.getPSUSModuleId()) != 0L) {
                this.psusmodule = null;
            }
            if (this.psusmodule == null) {
                PSUSModule pSUSModule = new PSUSModule();
                pSUSModule.setPSUSModuleId(this.getPSUSModuleId());
                PSUSModuleService pSUSModuleService = (PSUSModuleService)ServiceGlobal.getService(PSUSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSUSModuleService.autoGet(pSUSModule);
                this.psusmodule = pSUSModule;
            }
            return this.psusmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUSDCModuleInst> getPSUSDCModuleInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInsts();
        }
        if (this.getPSUSModuleInstId() == null) {
            return null;
        }
        PSUSDCModuleInstService pSUSDCModuleInstService = (PSUSDCModuleInstService)ServiceGlobal.getService(PSUSDCModuleInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUSDCModuleInstsLock;
        synchronized (n) {
            if (this.psusdcmoduleinsts == null) {
                this.psusdcmoduleinsts = pSUSDCModuleInstService.selectByPSUSModuleInst(this);
            }
            return this.psusdcmoduleinsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUSModuleInstFunc> getPSUSModuleInstFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstFuncs();
        }
        if (this.getPSUSModuleInstId() == null) {
            return null;
        }
        PSUSModuleInstFuncService pSUSModuleInstFuncService = (PSUSModuleInstFuncService)ServiceGlobal.getService(PSUSModuleInstFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUSModuleInstFuncsLock;
        synchronized (n) {
            if (this.psusmoduleinstfuncs == null) {
                this.psusmoduleinstfuncs = pSUSModuleInstFuncService.selectByPSUSModuleInst(this);
            }
            return this.psusmoduleinstfuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUSModuleInstRef> getPSUSModuleInstRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInstRefs();
        }
        if (this.getPSUSModuleInstId() == null) {
            return null;
        }
        PSUSModuleInstRefService pSUSModuleInstRefService = (PSUSModuleInstRefService)ServiceGlobal.getService(PSUSModuleInstRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUSModuleInstRefsLock;
        synchronized (n) {
            if (this.psusmoduleinstrefs == null) {
                this.psusmoduleinstrefs = pSUSModuleInstRefService.selectByPSUSModuleInst(this);
            }
            return this.psusmoduleinstrefs;
        }
    }

    private PSUSModuleInstBase getProxyEntity() {
        return this.proxyPSUSModuleInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSModuleInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSModuleInstBase) {
            this.proxyPSUSModuleInstBase = (PSUSModuleInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINSERVICEURL, 0);
        fieldIndexMap.put(FIELD_ADMINURL, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSUSMODULEID, 5);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTID, 6);
        fieldIndexMap.put(FIELD_PSUSMODULEINSTNAME, 7);
        fieldIndexMap.put(FIELD_PSUSMODULENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

