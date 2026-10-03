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
import net.ibizsys.pscore.srv.config.entity.PSCtrlModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.service.PSCtrlModelService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlTypeModelBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCTRLMODELID = "PSCTRLMODELID";
    public static final String FIELD_PSCTRLMODELNAME = "PSCTRLMODELNAME";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPEMODELID = "PSCTRLTYPEMODELID";
    public static final String FIELD_PSCTRLTYPEMODELNAME = "PSCTRLTYPEMODELNAME";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_R7DEXAMPLE = "R7DEXAMPLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSCTRLMODELID = 4;
    private static final int INDEX_PSCTRLMODELNAME = 5;
    private static final int INDEX_PSCTRLTYPEID = 6;
    private static final int INDEX_PSCTRLTYPEMODELID = 7;
    private static final int INDEX_PSCTRLTYPEMODELNAME = 8;
    private static final int INDEX_PSCTRLTYPENAME = 9;
    private static final int INDEX_R7DEXAMPLE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlTypeModelBase proxyPSCtrlTypeModelBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psctrlmodelidDirtyFlag = false;
    private boolean psctrlmodelnameDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypemodelidDirtyFlag = false;
    private boolean psctrltypemodelnameDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean r7dexampleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psctrlmodelid")
    private String psctrlmodelid;
    @Column(name="psctrlmodelname")
    private String psctrlmodelname;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypemodelid")
    private String psctrltypemodelid;
    @Column(name="psctrltypemodelname")
    private String psctrltypemodelname;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="r7dexample")
    private String r7dexample;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCtrlModelLock = new Integer(1);
    private PSCtrlModel psctrlmodel = null;
    private Integer objPSCtrlTypeLock = new Integer(1);
    private PSCtrlType psctrltype = null;

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

    public void setPSCtrlModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmodelid = string;
        this.psctrlmodelidDirtyFlag = true;
    }

    public String getPSCtrlModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlModelId();
        }
        return this.psctrlmodelid;
    }

    public boolean isPSCtrlModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlModelIdDirty();
        }
        return this.psctrlmodelidDirtyFlag;
    }

    public void resetPSCtrlModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlModelId();
            return;
        }
        this.psctrlmodelidDirtyFlag = false;
        this.psctrlmodelid = null;
    }

    public void setPSCtrlModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmodelname = string;
        this.psctrlmodelnameDirtyFlag = true;
    }

    public String getPSCtrlModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlModelName();
        }
        return this.psctrlmodelname;
    }

    public boolean isPSCtrlModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlModelNameDirty();
        }
        return this.psctrlmodelnameDirtyFlag;
    }

    public void resetPSCtrlModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlModelName();
            return;
        }
        this.psctrlmodelnameDirtyFlag = false;
        this.psctrlmodelname = null;
    }

    public void setPSCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeid = string;
        this.psctrltypeidDirtyFlag = true;
    }

    public String getPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeId();
        }
        return this.psctrltypeid;
    }

    public boolean isPSCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeIdDirty();
        }
        return this.psctrltypeidDirtyFlag;
    }

    public void resetPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeId();
            return;
        }
        this.psctrltypeidDirtyFlag = false;
        this.psctrltypeid = null;
    }

    public void setPSCtrlTypeModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypemodelid = string;
        this.psctrltypemodelidDirtyFlag = true;
    }

    public String getPSCtrlTypeModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeModelId();
        }
        return this.psctrltypemodelid;
    }

    public boolean isPSCtrlTypeModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeModelIdDirty();
        }
        return this.psctrltypemodelidDirtyFlag;
    }

    public void resetPSCtrlTypeModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeModelId();
            return;
        }
        this.psctrltypemodelidDirtyFlag = false;
        this.psctrltypemodelid = null;
    }

    public void setPSCtrlTypeModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypemodelname = string;
        this.psctrltypemodelnameDirtyFlag = true;
    }

    public String getPSCtrlTypeModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeModelName();
        }
        return this.psctrltypemodelname;
    }

    public boolean isPSCtrlTypeModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeModelNameDirty();
        }
        return this.psctrltypemodelnameDirtyFlag;
    }

    public void resetPSCtrlTypeModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeModelName();
            return;
        }
        this.psctrltypemodelnameDirtyFlag = false;
        this.psctrltypemodelname = null;
    }

    public void setPSCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypename = string;
        this.psctrltypenameDirtyFlag = true;
    }

    public String getPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeName();
        }
        return this.psctrltypename;
    }

    public boolean isPSCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeNameDirty();
        }
        return this.psctrltypenameDirtyFlag;
    }

    public void resetPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeName();
            return;
        }
        this.psctrltypenameDirtyFlag = false;
        this.psctrltypename = null;
    }

    public void setR7DExample(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR7DExample(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.r7dexample = string;
        this.r7dexampleDirtyFlag = true;
    }

    public String getR7DExample() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR7DExample();
        }
        return this.r7dexample;
    }

    public boolean isR7DExampleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR7DExampleDirty();
        }
        return this.r7dexampleDirtyFlag;
    }

    public void resetR7DExample() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR7DExample();
            return;
        }
        this.r7dexampleDirtyFlag = false;
        this.r7dexample = null;
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
        PSCtrlTypeModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlTypeModelBase pSCtrlTypeModelBase) {
        pSCtrlTypeModelBase.resetCreateDate();
        pSCtrlTypeModelBase.resetCreateMan();
        pSCtrlTypeModelBase.resetMemo();
        pSCtrlTypeModelBase.resetOrderValue();
        pSCtrlTypeModelBase.resetPSCtrlModelId();
        pSCtrlTypeModelBase.resetPSCtrlModelName();
        pSCtrlTypeModelBase.resetPSCtrlTypeId();
        pSCtrlTypeModelBase.resetPSCtrlTypeModelId();
        pSCtrlTypeModelBase.resetPSCtrlTypeModelName();
        pSCtrlTypeModelBase.resetPSCtrlTypeName();
        pSCtrlTypeModelBase.resetR7DExample();
        pSCtrlTypeModelBase.resetUpdateDate();
        pSCtrlTypeModelBase.resetUpdateMan();
        pSCtrlTypeModelBase.resetValidFlag();
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSCtrlModelIdDirty()) {
            hashMap.put(FIELD_PSCTRLMODELID, this.getPSCtrlModelId());
        }
        if (!bl || this.isPSCtrlModelNameDirty()) {
            hashMap.put(FIELD_PSCTRLMODELNAME, this.getPSCtrlModelName());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeModelIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEMODELID, this.getPSCtrlTypeModelId());
        }
        if (!bl || this.isPSCtrlTypeModelNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEMODELNAME, this.getPSCtrlTypeModelName());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isR7DExampleDirty()) {
            hashMap.put(FIELD_R7DEXAMPLE, this.getR7DExample());
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
        return PSCtrlTypeModelBase.get(this, n);
    }

    private static Object get(PSCtrlTypeModelBase pSCtrlTypeModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeModelBase.getCreateDate();
            }
            case 1: {
                return pSCtrlTypeModelBase.getCreateMan();
            }
            case 2: {
                return pSCtrlTypeModelBase.getMemo();
            }
            case 3: {
                return pSCtrlTypeModelBase.getOrderValue();
            }
            case 4: {
                return pSCtrlTypeModelBase.getPSCtrlModelId();
            }
            case 5: {
                return pSCtrlTypeModelBase.getPSCtrlModelName();
            }
            case 6: {
                return pSCtrlTypeModelBase.getPSCtrlTypeId();
            }
            case 7: {
                return pSCtrlTypeModelBase.getPSCtrlTypeModelId();
            }
            case 8: {
                return pSCtrlTypeModelBase.getPSCtrlTypeModelName();
            }
            case 9: {
                return pSCtrlTypeModelBase.getPSCtrlTypeName();
            }
            case 10: {
                return pSCtrlTypeModelBase.getR7DExample();
            }
            case 11: {
                return pSCtrlTypeModelBase.getUpdateDate();
            }
            case 12: {
                return pSCtrlTypeModelBase.getUpdateMan();
            }
            case 13: {
                return pSCtrlTypeModelBase.getValidFlag();
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
        PSCtrlTypeModelBase.set(this, n, object);
    }

    private static void set(PSCtrlTypeModelBase pSCtrlTypeModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlTypeModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlTypeModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlTypeModelBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlTypeModelBase.setPSCtrlModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlTypeModelBase.setPSCtrlModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlTypeModelBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlTypeModelBase.setPSCtrlTypeModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlTypeModelBase.setPSCtrlTypeModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlTypeModelBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlTypeModelBase.setR7DExample(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlTypeModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlTypeModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlTypeModelBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlTypeModelBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlTypeModelBase pSCtrlTypeModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeModelBase.getCreateDate() == null;
            }
            case 1: {
                return pSCtrlTypeModelBase.getCreateMan() == null;
            }
            case 2: {
                return pSCtrlTypeModelBase.getMemo() == null;
            }
            case 3: {
                return pSCtrlTypeModelBase.getOrderValue() == null;
            }
            case 4: {
                return pSCtrlTypeModelBase.getPSCtrlModelId() == null;
            }
            case 5: {
                return pSCtrlTypeModelBase.getPSCtrlModelName() == null;
            }
            case 6: {
                return pSCtrlTypeModelBase.getPSCtrlTypeId() == null;
            }
            case 7: {
                return pSCtrlTypeModelBase.getPSCtrlTypeModelId() == null;
            }
            case 8: {
                return pSCtrlTypeModelBase.getPSCtrlTypeModelName() == null;
            }
            case 9: {
                return pSCtrlTypeModelBase.getPSCtrlTypeName() == null;
            }
            case 10: {
                return pSCtrlTypeModelBase.getR7DExample() == null;
            }
            case 11: {
                return pSCtrlTypeModelBase.getUpdateDate() == null;
            }
            case 12: {
                return pSCtrlTypeModelBase.getUpdateMan() == null;
            }
            case 13: {
                return pSCtrlTypeModelBase.getValidFlag() == null;
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
        return PSCtrlTypeModelBase.contains(this, n);
    }

    private static boolean contains(PSCtrlTypeModelBase pSCtrlTypeModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeModelBase.isCreateDateDirty();
            }
            case 1: {
                return pSCtrlTypeModelBase.isCreateManDirty();
            }
            case 2: {
                return pSCtrlTypeModelBase.isMemoDirty();
            }
            case 3: {
                return pSCtrlTypeModelBase.isOrderValueDirty();
            }
            case 4: {
                return pSCtrlTypeModelBase.isPSCtrlModelIdDirty();
            }
            case 5: {
                return pSCtrlTypeModelBase.isPSCtrlModelNameDirty();
            }
            case 6: {
                return pSCtrlTypeModelBase.isPSCtrlTypeIdDirty();
            }
            case 7: {
                return pSCtrlTypeModelBase.isPSCtrlTypeModelIdDirty();
            }
            case 8: {
                return pSCtrlTypeModelBase.isPSCtrlTypeModelNameDirty();
            }
            case 9: {
                return pSCtrlTypeModelBase.isPSCtrlTypeNameDirty();
            }
            case 10: {
                return pSCtrlTypeModelBase.isR7DExampleDirty();
            }
            case 11: {
                return pSCtrlTypeModelBase.isUpdateDateDirty();
            }
            case 12: {
                return pSCtrlTypeModelBase.isUpdateManDirty();
            }
            case 13: {
                return pSCtrlTypeModelBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlTypeModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlTypeModelBase pSCtrlTypeModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlTypeModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmodelid", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getPSCtrlModelId()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmodelname", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getPSCtrlModelName()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypemodelid", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getPSCtrlTypeModelId()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypemodelname", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getPSCtrlTypeModelName()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getR7DExample() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"r7dexample", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getR7DExample()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeModelBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlTypeModelBase.getJSONValue((Object)pSCtrlTypeModelBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlTypeModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlTypeModelBase pSCtrlTypeModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlTypeModelBase.getCreateDate() != null) {
            object = pSCtrlTypeModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeModelBase.getCreateMan() != null) {
            object = pSCtrlTypeModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getMemo() != null) {
            object = pSCtrlTypeModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getOrderValue() != null) {
            object = pSCtrlTypeModelBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlModelId() != null) {
            object = pSCtrlTypeModelBase.getPSCtrlModelId();
            xmlNode.setAttribute(FIELD_PSCTRLMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlModelName() != null) {
            object = pSCtrlTypeModelBase.getPSCtrlModelName();
            xmlNode.setAttribute(FIELD_PSCTRLMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeId() != null) {
            object = pSCtrlTypeModelBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeModelId() != null) {
            object = pSCtrlTypeModelBase.getPSCtrlTypeModelId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeModelName() != null) {
            object = pSCtrlTypeModelBase.getPSCtrlTypeModelName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getPSCtrlTypeName() != null) {
            object = pSCtrlTypeModelBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getR7DExample() != null) {
            object = pSCtrlTypeModelBase.getR7DExample();
            xmlNode.setAttribute(FIELD_R7DEXAMPLE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getUpdateDate() != null) {
            object = pSCtrlTypeModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeModelBase.getUpdateMan() != null) {
            object = pSCtrlTypeModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeModelBase.getValidFlag() != null) {
            object = pSCtrlTypeModelBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlTypeModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlTypeModelBase pSCtrlTypeModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlTypeModelBase.isCreateDateDirty() && (bl || pSCtrlTypeModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlTypeModelBase.getCreateDate());
        }
        if (pSCtrlTypeModelBase.isCreateManDirty() && (bl || pSCtrlTypeModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlTypeModelBase.getCreateMan());
        }
        if (pSCtrlTypeModelBase.isMemoDirty() && (bl || pSCtrlTypeModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlTypeModelBase.getMemo());
        }
        if (pSCtrlTypeModelBase.isOrderValueDirty() && (bl || pSCtrlTypeModelBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCtrlTypeModelBase.getOrderValue());
        }
        if (pSCtrlTypeModelBase.isPSCtrlModelIdDirty() && (bl || pSCtrlTypeModelBase.getPSCtrlModelId() != null)) {
            iDataObject.set(FIELD_PSCTRLMODELID, (Object)pSCtrlTypeModelBase.getPSCtrlModelId());
        }
        if (pSCtrlTypeModelBase.isPSCtrlModelNameDirty() && (bl || pSCtrlTypeModelBase.getPSCtrlModelName() != null)) {
            iDataObject.set(FIELD_PSCTRLMODELNAME, (Object)pSCtrlTypeModelBase.getPSCtrlModelName());
        }
        if (pSCtrlTypeModelBase.isPSCtrlTypeIdDirty() && (bl || pSCtrlTypeModelBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSCtrlTypeModelBase.getPSCtrlTypeId());
        }
        if (pSCtrlTypeModelBase.isPSCtrlTypeModelIdDirty() && (bl || pSCtrlTypeModelBase.getPSCtrlTypeModelId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEMODELID, (Object)pSCtrlTypeModelBase.getPSCtrlTypeModelId());
        }
        if (pSCtrlTypeModelBase.isPSCtrlTypeModelNameDirty() && (bl || pSCtrlTypeModelBase.getPSCtrlTypeModelName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEMODELNAME, (Object)pSCtrlTypeModelBase.getPSCtrlTypeModelName());
        }
        if (pSCtrlTypeModelBase.isPSCtrlTypeNameDirty() && (bl || pSCtrlTypeModelBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSCtrlTypeModelBase.getPSCtrlTypeName());
        }
        if (pSCtrlTypeModelBase.isR7DExampleDirty() && (bl || pSCtrlTypeModelBase.getR7DExample() != null)) {
            iDataObject.set(FIELD_R7DEXAMPLE, (Object)pSCtrlTypeModelBase.getR7DExample());
        }
        if (pSCtrlTypeModelBase.isUpdateDateDirty() && (bl || pSCtrlTypeModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlTypeModelBase.getUpdateDate());
        }
        if (pSCtrlTypeModelBase.isUpdateManDirty() && (bl || pSCtrlTypeModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlTypeModelBase.getUpdateMan());
        }
        if (pSCtrlTypeModelBase.isValidFlagDirty() && (bl || pSCtrlTypeModelBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlTypeModelBase.getValidFlag());
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
        return PSCtrlTypeModelBase.remove(this, n);
    }

    private static boolean remove(PSCtrlTypeModelBase pSCtrlTypeModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeModelBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCtrlTypeModelBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCtrlTypeModelBase.resetMemo();
                return true;
            }
            case 3: {
                pSCtrlTypeModelBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSCtrlTypeModelBase.resetPSCtrlModelId();
                return true;
            }
            case 5: {
                pSCtrlTypeModelBase.resetPSCtrlModelName();
                return true;
            }
            case 6: {
                pSCtrlTypeModelBase.resetPSCtrlTypeId();
                return true;
            }
            case 7: {
                pSCtrlTypeModelBase.resetPSCtrlTypeModelId();
                return true;
            }
            case 8: {
                pSCtrlTypeModelBase.resetPSCtrlTypeModelName();
                return true;
            }
            case 9: {
                pSCtrlTypeModelBase.resetPSCtrlTypeName();
                return true;
            }
            case 10: {
                pSCtrlTypeModelBase.resetR7DExample();
                return true;
            }
            case 11: {
                pSCtrlTypeModelBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSCtrlTypeModelBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSCtrlTypeModelBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlModel getPSCtrlModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlModel();
        }
        if (this.getPSCtrlModelId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlModelLock;
        synchronized (n) {
            if (this.psctrlmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlModelId(), (Object)this.psctrlmodel.getPSCtrlModelId()) != 0L) {
                this.psctrlmodel = null;
            }
            if (this.psctrlmodel == null) {
                PSCtrlModel pSCtrlModel = new PSCtrlModel();
                pSCtrlModel.setPSCtrlModelId(this.getPSCtrlModelId());
                PSCtrlModelService pSCtrlModelService = (PSCtrlModelService)ServiceGlobal.getService(PSCtrlModelService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlModelService.autoGet(pSCtrlModel);
                this.psctrlmodel = pSCtrlModel;
            }
            return this.psctrlmodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlType getPSCtrlType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlType();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlTypeLock;
        synchronized (n) {
            if (this.psctrltype != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlTypeId(), (Object)this.psctrltype.getPSCtrlTypeId()) != 0L) {
                this.psctrltype = null;
            }
            if (this.psctrltype == null) {
                PSCtrlType pSCtrlType = new PSCtrlType();
                pSCtrlType.setPSCtrlTypeId(this.getPSCtrlTypeId());
                PSCtrlTypeService pSCtrlTypeService = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlTypeService.autoGet(pSCtrlType);
                this.psctrltype = pSCtrlType;
            }
            return this.psctrltype;
        }
    }

    private PSCtrlTypeModelBase getProxyEntity() {
        return this.proxyPSCtrlTypeModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlTypeModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlTypeModelBase) {
            this.proxyPSCtrlTypeModelBase = (PSCtrlTypeModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSCTRLMODELID, 4);
        fieldIndexMap.put(FIELD_PSCTRLMODELNAME, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 6);
        fieldIndexMap.put(FIELD_PSCTRLTYPEMODELID, 7);
        fieldIndexMap.put(FIELD_PSCTRLTYPEMODELNAME, 8);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 9);
        fieldIndexMap.put(FIELD_R7DEXAMPLE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

