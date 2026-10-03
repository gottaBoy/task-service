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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelModule;
import net.ibizsys.pscore.srv.config.service.PSModelModuleService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelModuleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODULETYPE = "MODULETYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSMODELMODULEID = "PPSMODELMODULEID";
    public static final String FIELD_PPSMODELMODULENAME = "PPSMODELMODULENAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELMODULEID = "PSMODELMODULEID";
    public static final String FIELD_PSMODELMODULENAME = "PSMODELMODULENAME";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_MODULETYPE = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PPSMODELMODULEID = 5;
    private static final int INDEX_PPSMODELMODULENAME = 6;
    private static final int INDEX_PSMODELID = 7;
    private static final int INDEX_PSMODELMODULEID = 8;
    private static final int INDEX_PSMODELMODULENAME = 9;
    private static final int INDEX_PSMODELNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelModuleBase proxyPSModelModuleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean moduletypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsmodelmoduleidDirtyFlag = false;
    private boolean ppsmodelmodulenameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelmoduleidDirtyFlag = false;
    private boolean psmodelmodulenameDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="moduletype")
    private String moduletype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsmodelmoduleid")
    private String ppsmodelmoduleid;
    @Column(name="ppsmodelmodulename")
    private String ppsmodelmodulename;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelmoduleid")
    private String psmodelmoduleid;
    @Column(name="psmodelmodulename")
    private String psmodelmodulename;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPpsmodelmoduleLock = new Integer(1);
    private PSModelModule ppsmodelmodule = null;
    private Integer objPsmodelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setModuleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletype = string;
        this.moduletypeDirtyFlag = true;
    }

    public String getModuleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleType();
        }
        return this.moduletype;
    }

    public boolean isModuleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTypeDirty();
        }
        return this.moduletypeDirtyFlag;
    }

    public void resetModuleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleType();
            return;
        }
        this.moduletypeDirtyFlag = false;
        this.moduletype = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPPSModelModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelmoduleid = string;
        this.ppsmodelmoduleidDirtyFlag = true;
    }

    public String getPPSModelModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelModuleId();
        }
        return this.ppsmodelmoduleid;
    }

    public boolean isPPSModelModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelModuleIdDirty();
        }
        return this.ppsmodelmoduleidDirtyFlag;
    }

    public void resetPPSModelModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelModuleId();
            return;
        }
        this.ppsmodelmoduleidDirtyFlag = false;
        this.ppsmodelmoduleid = null;
    }

    public void setPPSModelModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelmodulename = string;
        this.ppsmodelmodulenameDirtyFlag = true;
    }

    public String getPPSModelModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelModuleName();
        }
        return this.ppsmodelmodulename;
    }

    public boolean isPPSModelModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelModuleNameDirty();
        }
        return this.ppsmodelmodulenameDirtyFlag;
    }

    public void resetPPSModelModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelModuleName();
            return;
        }
        this.ppsmodelmodulenameDirtyFlag = false;
        this.ppsmodelmodulename = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelmoduleid = string;
        this.psmodelmoduleidDirtyFlag = true;
    }

    public String getPSModelModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelModuleId();
        }
        return this.psmodelmoduleid;
    }

    public boolean isPSModelModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelModuleIdDirty();
        }
        return this.psmodelmoduleidDirtyFlag;
    }

    public void resetPSModelModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelModuleId();
            return;
        }
        this.psmodelmoduleidDirtyFlag = false;
        this.psmodelmoduleid = null;
    }

    public void setPSModelModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelmodulename = string;
        this.psmodelmodulenameDirtyFlag = true;
    }

    public String getPSModelModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelModuleName();
        }
        return this.psmodelmodulename;
    }

    public boolean isPSModelModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelModuleNameDirty();
        }
        return this.psmodelmodulenameDirtyFlag;
    }

    public void resetPSModelModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelModuleName();
            return;
        }
        this.psmodelmodulenameDirtyFlag = false;
        this.psmodelmodulename = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
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
        PSModelModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelModuleBase pSModelModuleBase) {
        pSModelModuleBase.resetCreateDate();
        pSModelModuleBase.resetCreateMan();
        pSModelModuleBase.resetMemo();
        pSModelModuleBase.resetModuleType();
        pSModelModuleBase.resetOrderValue();
        pSModelModuleBase.resetPPSModelModuleId();
        pSModelModuleBase.resetPPSModelModuleName();
        pSModelModuleBase.resetPSModelId();
        pSModelModuleBase.resetPSModelModuleId();
        pSModelModuleBase.resetPSModelModuleName();
        pSModelModuleBase.resetPSModelName();
        pSModelModuleBase.resetUpdateDate();
        pSModelModuleBase.resetUpdateMan();
        pSModelModuleBase.resetValidFlag();
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
        if (!bl || this.isModuleTypeDirty()) {
            hashMap.put(FIELD_MODULETYPE, this.getModuleType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSModelModuleIdDirty()) {
            hashMap.put(FIELD_PPSMODELMODULEID, this.getPPSModelModuleId());
        }
        if (!bl || this.isPPSModelModuleNameDirty()) {
            hashMap.put(FIELD_PPSMODELMODULENAME, this.getPPSModelModuleName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelModuleIdDirty()) {
            hashMap.put(FIELD_PSMODELMODULEID, this.getPSModelModuleId());
        }
        if (!bl || this.isPSModelModuleNameDirty()) {
            hashMap.put(FIELD_PSMODELMODULENAME, this.getPSModelModuleName());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
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
        return PSModelModuleBase.get(this, n);
    }

    private static Object get(PSModelModuleBase pSModelModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelModuleBase.getCreateDate();
            }
            case 1: {
                return pSModelModuleBase.getCreateMan();
            }
            case 2: {
                return pSModelModuleBase.getMemo();
            }
            case 3: {
                return pSModelModuleBase.getModuleType();
            }
            case 4: {
                return pSModelModuleBase.getOrderValue();
            }
            case 5: {
                return pSModelModuleBase.getPPSModelModuleId();
            }
            case 6: {
                return pSModelModuleBase.getPPSModelModuleName();
            }
            case 7: {
                return pSModelModuleBase.getPSModelId();
            }
            case 8: {
                return pSModelModuleBase.getPSModelModuleId();
            }
            case 9: {
                return pSModelModuleBase.getPSModelModuleName();
            }
            case 10: {
                return pSModelModuleBase.getPSModelName();
            }
            case 11: {
                return pSModelModuleBase.getUpdateDate();
            }
            case 12: {
                return pSModelModuleBase.getUpdateMan();
            }
            case 13: {
                return pSModelModuleBase.getValidFlag();
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
        PSModelModuleBase.set(this, n, object);
    }

    private static void set(PSModelModuleBase pSModelModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelModuleBase.setModuleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelModuleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSModelModuleBase.setPPSModelModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelModuleBase.setPPSModelModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelModuleBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelModuleBase.setPSModelModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelModuleBase.setPSModelModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelModuleBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSModelModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelModuleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSModelModuleBase pSModelModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelModuleBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelModuleBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelModuleBase.getMemo() == null;
            }
            case 3: {
                return pSModelModuleBase.getModuleType() == null;
            }
            case 4: {
                return pSModelModuleBase.getOrderValue() == null;
            }
            case 5: {
                return pSModelModuleBase.getPPSModelModuleId() == null;
            }
            case 6: {
                return pSModelModuleBase.getPPSModelModuleName() == null;
            }
            case 7: {
                return pSModelModuleBase.getPSModelId() == null;
            }
            case 8: {
                return pSModelModuleBase.getPSModelModuleId() == null;
            }
            case 9: {
                return pSModelModuleBase.getPSModelModuleName() == null;
            }
            case 10: {
                return pSModelModuleBase.getPSModelName() == null;
            }
            case 11: {
                return pSModelModuleBase.getUpdateDate() == null;
            }
            case 12: {
                return pSModelModuleBase.getUpdateMan() == null;
            }
            case 13: {
                return pSModelModuleBase.getValidFlag() == null;
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
        return PSModelModuleBase.contains(this, n);
    }

    private static boolean contains(PSModelModuleBase pSModelModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelModuleBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelModuleBase.isCreateManDirty();
            }
            case 2: {
                return pSModelModuleBase.isMemoDirty();
            }
            case 3: {
                return pSModelModuleBase.isModuleTypeDirty();
            }
            case 4: {
                return pSModelModuleBase.isOrderValueDirty();
            }
            case 5: {
                return pSModelModuleBase.isPPSModelModuleIdDirty();
            }
            case 6: {
                return pSModelModuleBase.isPPSModelModuleNameDirty();
            }
            case 7: {
                return pSModelModuleBase.isPSModelIdDirty();
            }
            case 8: {
                return pSModelModuleBase.isPSModelModuleIdDirty();
            }
            case 9: {
                return pSModelModuleBase.isPSModelModuleNameDirty();
            }
            case 10: {
                return pSModelModuleBase.isPSModelNameDirty();
            }
            case 11: {
                return pSModelModuleBase.isUpdateDateDirty();
            }
            case 12: {
                return pSModelModuleBase.isUpdateManDirty();
            }
            case 13: {
                return pSModelModuleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelModuleBase pSModelModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getModuleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletype", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getModuleType()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getPPSModelModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelmoduleid", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getPPSModelModuleId()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getPPSModelModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelmodulename", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getPPSModelModuleName()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getPSModelModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelmoduleid", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getPSModelModuleId()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getPSModelModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelmodulename", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getPSModelModuleName()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelModuleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelModuleBase.getJSONValue((Object)pSModelModuleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelModuleBase pSModelModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelModuleBase.getCreateDate() != null) {
            object = pSModelModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelModuleBase.getCreateMan() != null) {
            object = pSModelModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getMemo() != null) {
            object = pSModelModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getModuleType() != null) {
            object = pSModelModuleBase.getModuleType();
            xmlNode.setAttribute(FIELD_MODULETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getOrderValue() != null) {
            object = pSModelModuleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelModuleBase.getPPSModelModuleId() != null) {
            object = pSModelModuleBase.getPPSModelModuleId();
            xmlNode.setAttribute(FIELD_PPSMODELMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getPPSModelModuleName() != null) {
            object = pSModelModuleBase.getPPSModelModuleName();
            xmlNode.setAttribute(FIELD_PPSMODELMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getPSModelId() != null) {
            object = pSModelModuleBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getPSModelModuleId() != null) {
            object = pSModelModuleBase.getPSModelModuleId();
            xmlNode.setAttribute(FIELD_PSMODELMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getPSModelModuleName() != null) {
            object = pSModelModuleBase.getPSModelModuleName();
            xmlNode.setAttribute(FIELD_PSMODELMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getPSModelName() != null) {
            object = pSModelModuleBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getUpdateDate() != null) {
            object = pSModelModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelModuleBase.getUpdateMan() != null) {
            object = pSModelModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelModuleBase.getValidFlag() != null) {
            object = pSModelModuleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelModuleBase pSModelModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelModuleBase.isCreateDateDirty() && (bl || pSModelModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelModuleBase.getCreateDate());
        }
        if (pSModelModuleBase.isCreateManDirty() && (bl || pSModelModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelModuleBase.getCreateMan());
        }
        if (pSModelModuleBase.isMemoDirty() && (bl || pSModelModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelModuleBase.getMemo());
        }
        if (pSModelModuleBase.isModuleTypeDirty() && (bl || pSModelModuleBase.getModuleType() != null)) {
            iDataObject.set(FIELD_MODULETYPE, (Object)pSModelModuleBase.getModuleType());
        }
        if (pSModelModuleBase.isOrderValueDirty() && (bl || pSModelModuleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelModuleBase.getOrderValue());
        }
        if (pSModelModuleBase.isPPSModelModuleIdDirty() && (bl || pSModelModuleBase.getPPSModelModuleId() != null)) {
            iDataObject.set(FIELD_PPSMODELMODULEID, (Object)pSModelModuleBase.getPPSModelModuleId());
        }
        if (pSModelModuleBase.isPPSModelModuleNameDirty() && (bl || pSModelModuleBase.getPPSModelModuleName() != null)) {
            iDataObject.set(FIELD_PPSMODELMODULENAME, (Object)pSModelModuleBase.getPPSModelModuleName());
        }
        if (pSModelModuleBase.isPSModelIdDirty() && (bl || pSModelModuleBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelModuleBase.getPSModelId());
        }
        if (pSModelModuleBase.isPSModelModuleIdDirty() && (bl || pSModelModuleBase.getPSModelModuleId() != null)) {
            iDataObject.set(FIELD_PSMODELMODULEID, (Object)pSModelModuleBase.getPSModelModuleId());
        }
        if (pSModelModuleBase.isPSModelModuleNameDirty() && (bl || pSModelModuleBase.getPSModelModuleName() != null)) {
            iDataObject.set(FIELD_PSMODELMODULENAME, (Object)pSModelModuleBase.getPSModelModuleName());
        }
        if (pSModelModuleBase.isPSModelNameDirty() && (bl || pSModelModuleBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelModuleBase.getPSModelName());
        }
        if (pSModelModuleBase.isUpdateDateDirty() && (bl || pSModelModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelModuleBase.getUpdateDate());
        }
        if (pSModelModuleBase.isUpdateManDirty() && (bl || pSModelModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelModuleBase.getUpdateMan());
        }
        if (pSModelModuleBase.isValidFlagDirty() && (bl || pSModelModuleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelModuleBase.getValidFlag());
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
        return PSModelModuleBase.remove(this, n);
    }

    private static boolean remove(PSModelModuleBase pSModelModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelModuleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelModuleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelModuleBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelModuleBase.resetModuleType();
                return true;
            }
            case 4: {
                pSModelModuleBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSModelModuleBase.resetPPSModelModuleId();
                return true;
            }
            case 6: {
                pSModelModuleBase.resetPPSModelModuleName();
                return true;
            }
            case 7: {
                pSModelModuleBase.resetPSModelId();
                return true;
            }
            case 8: {
                pSModelModuleBase.resetPSModelModuleId();
                return true;
            }
            case 9: {
                pSModelModuleBase.resetPSModelModuleName();
                return true;
            }
            case 10: {
                pSModelModuleBase.resetPSModelName();
                return true;
            }
            case 11: {
                pSModelModuleBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSModelModuleBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSModelModuleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelModule getPpsmodelmodule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPpsmodelmodule();
        }
        if (this.getPPSModelModuleId() == null) {
            return null;
        }
        Integer n = this.objPpsmodelmoduleLock;
        synchronized (n) {
            if (this.ppsmodelmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPPSModelModuleId(), (Object)this.ppsmodelmodule.getPSModelModuleId()) != 0L) {
                this.ppsmodelmodule = null;
            }
            if (this.ppsmodelmodule == null) {
                PSModelModule pSModelModule = new PSModelModule();
                pSModelModule.setPSModelModuleId(this.getPPSModelModuleId());
                PSModelModuleService pSModelModuleService = (PSModelModuleService)ServiceGlobal.getService(PSModelModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModelModuleService.autoGet(pSModelModule);
                this.ppsmodelmodule = pSModelModule;
            }
            return this.ppsmodelmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPsmodel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsmodel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPsmodelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet(pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelModuleBase getProxyEntity() {
        return this.proxyPSModelModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelModuleBase) {
            this.proxyPSModelModuleBase = (PSModelModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_MODULETYPE, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PPSMODELMODULEID, 5);
        fieldIndexMap.put(FIELD_PPSMODELMODULENAME, 6);
        fieldIndexMap.put(FIELD_PSMODELID, 7);
        fieldIndexMap.put(FIELD_PSMODELMODULEID, 8);
        fieldIndexMap.put(FIELD_PSMODELMODULENAME, 9);
        fieldIndexMap.put(FIELD_PSMODELNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

