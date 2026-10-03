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
import net.ibizsys.pscore.srv.config.entity.PSCtrlAction;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.service.PSCtrlActionService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlTypeActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCTRLACTIONID = "PSCTRLACTIONID";
    public static final String FIELD_PSCTRLACTIONNAME = "PSCTRLACTIONNAME";
    public static final String FIELD_PSCTRLTYPEACTIONID = "PSCTRLTYPEACTIONID";
    public static final String FIELD_PSCTRLTYPEACTIONNAME = "PSCTRLTYPEACTIONNAME";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_R7DEXAMPLE = "R7DEXAMPLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSCTRLACTIONID = 4;
    private static final int INDEX_PSCTRLACTIONNAME = 5;
    private static final int INDEX_PSCTRLTYPEACTIONID = 6;
    private static final int INDEX_PSCTRLTYPEACTIONNAME = 7;
    private static final int INDEX_PSCTRLTYPEID = 8;
    private static final int INDEX_PSCTRLTYPENAME = 9;
    private static final int INDEX_R7DEXAMPLE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlTypeActionBase proxyPSCtrlTypeActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psctrlactionidDirtyFlag = false;
    private boolean psctrlactionnameDirtyFlag = false;
    private boolean psctrltypeactionidDirtyFlag = false;
    private boolean psctrltypeactionnameDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
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
    @Column(name="psctrlactionid")
    private String psctrlactionid;
    @Column(name="psctrlactionname")
    private String psctrlactionname;
    @Column(name="psctrltypeactionid")
    private String psctrltypeactionid;
    @Column(name="psctrltypeactionname")
    private String psctrltypeactionname;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
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
    private Integer objPSCtrlActionLock = new Integer(1);
    private PSCtrlAction psctrlaction = null;
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

    public void setPSCtrlActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlactionid = string;
        this.psctrlactionidDirtyFlag = true;
    }

    public String getPSCtrlActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlActionId();
        }
        return this.psctrlactionid;
    }

    public boolean isPSCtrlActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlActionIdDirty();
        }
        return this.psctrlactionidDirtyFlag;
    }

    public void resetPSCtrlActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlActionId();
            return;
        }
        this.psctrlactionidDirtyFlag = false;
        this.psctrlactionid = null;
    }

    public void setPSCtrlActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlactionname = string;
        this.psctrlactionnameDirtyFlag = true;
    }

    public String getPSCtrlActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlActionName();
        }
        return this.psctrlactionname;
    }

    public boolean isPSCtrlActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlActionNameDirty();
        }
        return this.psctrlactionnameDirtyFlag;
    }

    public void resetPSCtrlActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlActionName();
            return;
        }
        this.psctrlactionnameDirtyFlag = false;
        this.psctrlactionname = null;
    }

    public void setPSCtrlTypeActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeactionid = string;
        this.psctrltypeactionidDirtyFlag = true;
    }

    public String getPSCtrlTypeActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeActionId();
        }
        return this.psctrltypeactionid;
    }

    public boolean isPSCtrlTypeActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeActionIdDirty();
        }
        return this.psctrltypeactionidDirtyFlag;
    }

    public void resetPSCtrlTypeActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeActionId();
            return;
        }
        this.psctrltypeactionidDirtyFlag = false;
        this.psctrltypeactionid = null;
    }

    public void setPSCtrlTypeActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeactionname = string;
        this.psctrltypeactionnameDirtyFlag = true;
    }

    public String getPSCtrlTypeActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeActionName();
        }
        return this.psctrltypeactionname;
    }

    public boolean isPSCtrlTypeActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeActionNameDirty();
        }
        return this.psctrltypeactionnameDirtyFlag;
    }

    public void resetPSCtrlTypeActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeActionName();
            return;
        }
        this.psctrltypeactionnameDirtyFlag = false;
        this.psctrltypeactionname = null;
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
        PSCtrlTypeActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlTypeActionBase pSCtrlTypeActionBase) {
        pSCtrlTypeActionBase.resetCreateDate();
        pSCtrlTypeActionBase.resetCreateMan();
        pSCtrlTypeActionBase.resetMemo();
        pSCtrlTypeActionBase.resetOrderValue();
        pSCtrlTypeActionBase.resetPSCtrlActionId();
        pSCtrlTypeActionBase.resetPSCtrlActionName();
        pSCtrlTypeActionBase.resetPSCtrlTypeActionId();
        pSCtrlTypeActionBase.resetPSCtrlTypeActionName();
        pSCtrlTypeActionBase.resetPSCtrlTypeId();
        pSCtrlTypeActionBase.resetPSCtrlTypeName();
        pSCtrlTypeActionBase.resetR7DExample();
        pSCtrlTypeActionBase.resetUpdateDate();
        pSCtrlTypeActionBase.resetUpdateMan();
        pSCtrlTypeActionBase.resetValidFlag();
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
        if (!bl || this.isPSCtrlActionIdDirty()) {
            hashMap.put(FIELD_PSCTRLACTIONID, this.getPSCtrlActionId());
        }
        if (!bl || this.isPSCtrlActionNameDirty()) {
            hashMap.put(FIELD_PSCTRLACTIONNAME, this.getPSCtrlActionName());
        }
        if (!bl || this.isPSCtrlTypeActionIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEACTIONID, this.getPSCtrlTypeActionId());
        }
        if (!bl || this.isPSCtrlTypeActionNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEACTIONNAME, this.getPSCtrlTypeActionName());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
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
        return PSCtrlTypeActionBase.get(this, n);
    }

    private static Object get(PSCtrlTypeActionBase pSCtrlTypeActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeActionBase.getCreateDate();
            }
            case 1: {
                return pSCtrlTypeActionBase.getCreateMan();
            }
            case 2: {
                return pSCtrlTypeActionBase.getMemo();
            }
            case 3: {
                return pSCtrlTypeActionBase.getOrderValue();
            }
            case 4: {
                return pSCtrlTypeActionBase.getPSCtrlActionId();
            }
            case 5: {
                return pSCtrlTypeActionBase.getPSCtrlActionName();
            }
            case 6: {
                return pSCtrlTypeActionBase.getPSCtrlTypeActionId();
            }
            case 7: {
                return pSCtrlTypeActionBase.getPSCtrlTypeActionName();
            }
            case 8: {
                return pSCtrlTypeActionBase.getPSCtrlTypeId();
            }
            case 9: {
                return pSCtrlTypeActionBase.getPSCtrlTypeName();
            }
            case 10: {
                return pSCtrlTypeActionBase.getR7DExample();
            }
            case 11: {
                return pSCtrlTypeActionBase.getUpdateDate();
            }
            case 12: {
                return pSCtrlTypeActionBase.getUpdateMan();
            }
            case 13: {
                return pSCtrlTypeActionBase.getValidFlag();
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
        PSCtrlTypeActionBase.set(this, n, object);
    }

    private static void set(PSCtrlTypeActionBase pSCtrlTypeActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlTypeActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlTypeActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlTypeActionBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlTypeActionBase.setPSCtrlActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlTypeActionBase.setPSCtrlActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlTypeActionBase.setPSCtrlTypeActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlTypeActionBase.setPSCtrlTypeActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlTypeActionBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlTypeActionBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlTypeActionBase.setR7DExample(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlTypeActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlTypeActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlTypeActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlTypeActionBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlTypeActionBase pSCtrlTypeActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeActionBase.getCreateDate() == null;
            }
            case 1: {
                return pSCtrlTypeActionBase.getCreateMan() == null;
            }
            case 2: {
                return pSCtrlTypeActionBase.getMemo() == null;
            }
            case 3: {
                return pSCtrlTypeActionBase.getOrderValue() == null;
            }
            case 4: {
                return pSCtrlTypeActionBase.getPSCtrlActionId() == null;
            }
            case 5: {
                return pSCtrlTypeActionBase.getPSCtrlActionName() == null;
            }
            case 6: {
                return pSCtrlTypeActionBase.getPSCtrlTypeActionId() == null;
            }
            case 7: {
                return pSCtrlTypeActionBase.getPSCtrlTypeActionName() == null;
            }
            case 8: {
                return pSCtrlTypeActionBase.getPSCtrlTypeId() == null;
            }
            case 9: {
                return pSCtrlTypeActionBase.getPSCtrlTypeName() == null;
            }
            case 10: {
                return pSCtrlTypeActionBase.getR7DExample() == null;
            }
            case 11: {
                return pSCtrlTypeActionBase.getUpdateDate() == null;
            }
            case 12: {
                return pSCtrlTypeActionBase.getUpdateMan() == null;
            }
            case 13: {
                return pSCtrlTypeActionBase.getValidFlag() == null;
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
        return PSCtrlTypeActionBase.contains(this, n);
    }

    private static boolean contains(PSCtrlTypeActionBase pSCtrlTypeActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeActionBase.isCreateDateDirty();
            }
            case 1: {
                return pSCtrlTypeActionBase.isCreateManDirty();
            }
            case 2: {
                return pSCtrlTypeActionBase.isMemoDirty();
            }
            case 3: {
                return pSCtrlTypeActionBase.isOrderValueDirty();
            }
            case 4: {
                return pSCtrlTypeActionBase.isPSCtrlActionIdDirty();
            }
            case 5: {
                return pSCtrlTypeActionBase.isPSCtrlActionNameDirty();
            }
            case 6: {
                return pSCtrlTypeActionBase.isPSCtrlTypeActionIdDirty();
            }
            case 7: {
                return pSCtrlTypeActionBase.isPSCtrlTypeActionNameDirty();
            }
            case 8: {
                return pSCtrlTypeActionBase.isPSCtrlTypeIdDirty();
            }
            case 9: {
                return pSCtrlTypeActionBase.isPSCtrlTypeNameDirty();
            }
            case 10: {
                return pSCtrlTypeActionBase.isR7DExampleDirty();
            }
            case 11: {
                return pSCtrlTypeActionBase.isUpdateDateDirty();
            }
            case 12: {
                return pSCtrlTypeActionBase.isUpdateManDirty();
            }
            case 13: {
                return pSCtrlTypeActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlTypeActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlTypeActionBase pSCtrlTypeActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlTypeActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlactionid", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getPSCtrlActionId()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlactionname", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getPSCtrlActionName()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeactionid", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getPSCtrlTypeActionId()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeactionname", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getPSCtrlTypeActionName()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getR7DExample() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"r7dexample", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getR7DExample()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlTypeActionBase.getJSONValue((Object)pSCtrlTypeActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlTypeActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlTypeActionBase pSCtrlTypeActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlTypeActionBase.getCreateDate() != null) {
            object = pSCtrlTypeActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeActionBase.getCreateMan() != null) {
            object = pSCtrlTypeActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getMemo() != null) {
            object = pSCtrlTypeActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getOrderValue() != null) {
            object = pSCtrlTypeActionBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlActionId() != null) {
            object = pSCtrlTypeActionBase.getPSCtrlActionId();
            xmlNode.setAttribute(FIELD_PSCTRLACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlActionName() != null) {
            object = pSCtrlTypeActionBase.getPSCtrlActionName();
            xmlNode.setAttribute(FIELD_PSCTRLACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeActionId() != null) {
            object = pSCtrlTypeActionBase.getPSCtrlTypeActionId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeActionName() != null) {
            object = pSCtrlTypeActionBase.getPSCtrlTypeActionName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeId() != null) {
            object = pSCtrlTypeActionBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getPSCtrlTypeName() != null) {
            object = pSCtrlTypeActionBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getR7DExample() != null) {
            object = pSCtrlTypeActionBase.getR7DExample();
            xmlNode.setAttribute(FIELD_R7DEXAMPLE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getUpdateDate() != null) {
            object = pSCtrlTypeActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeActionBase.getUpdateMan() != null) {
            object = pSCtrlTypeActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeActionBase.getValidFlag() != null) {
            object = pSCtrlTypeActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlTypeActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlTypeActionBase pSCtrlTypeActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlTypeActionBase.isCreateDateDirty() && (bl || pSCtrlTypeActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlTypeActionBase.getCreateDate());
        }
        if (pSCtrlTypeActionBase.isCreateManDirty() && (bl || pSCtrlTypeActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlTypeActionBase.getCreateMan());
        }
        if (pSCtrlTypeActionBase.isMemoDirty() && (bl || pSCtrlTypeActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlTypeActionBase.getMemo());
        }
        if (pSCtrlTypeActionBase.isOrderValueDirty() && (bl || pSCtrlTypeActionBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCtrlTypeActionBase.getOrderValue());
        }
        if (pSCtrlTypeActionBase.isPSCtrlActionIdDirty() && (bl || pSCtrlTypeActionBase.getPSCtrlActionId() != null)) {
            iDataObject.set(FIELD_PSCTRLACTIONID, (Object)pSCtrlTypeActionBase.getPSCtrlActionId());
        }
        if (pSCtrlTypeActionBase.isPSCtrlActionNameDirty() && (bl || pSCtrlTypeActionBase.getPSCtrlActionName() != null)) {
            iDataObject.set(FIELD_PSCTRLACTIONNAME, (Object)pSCtrlTypeActionBase.getPSCtrlActionName());
        }
        if (pSCtrlTypeActionBase.isPSCtrlTypeActionIdDirty() && (bl || pSCtrlTypeActionBase.getPSCtrlTypeActionId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEACTIONID, (Object)pSCtrlTypeActionBase.getPSCtrlTypeActionId());
        }
        if (pSCtrlTypeActionBase.isPSCtrlTypeActionNameDirty() && (bl || pSCtrlTypeActionBase.getPSCtrlTypeActionName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEACTIONNAME, (Object)pSCtrlTypeActionBase.getPSCtrlTypeActionName());
        }
        if (pSCtrlTypeActionBase.isPSCtrlTypeIdDirty() && (bl || pSCtrlTypeActionBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSCtrlTypeActionBase.getPSCtrlTypeId());
        }
        if (pSCtrlTypeActionBase.isPSCtrlTypeNameDirty() && (bl || pSCtrlTypeActionBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSCtrlTypeActionBase.getPSCtrlTypeName());
        }
        if (pSCtrlTypeActionBase.isR7DExampleDirty() && (bl || pSCtrlTypeActionBase.getR7DExample() != null)) {
            iDataObject.set(FIELD_R7DEXAMPLE, (Object)pSCtrlTypeActionBase.getR7DExample());
        }
        if (pSCtrlTypeActionBase.isUpdateDateDirty() && (bl || pSCtrlTypeActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlTypeActionBase.getUpdateDate());
        }
        if (pSCtrlTypeActionBase.isUpdateManDirty() && (bl || pSCtrlTypeActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlTypeActionBase.getUpdateMan());
        }
        if (pSCtrlTypeActionBase.isValidFlagDirty() && (bl || pSCtrlTypeActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlTypeActionBase.getValidFlag());
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
        return PSCtrlTypeActionBase.remove(this, n);
    }

    private static boolean remove(PSCtrlTypeActionBase pSCtrlTypeActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeActionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCtrlTypeActionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCtrlTypeActionBase.resetMemo();
                return true;
            }
            case 3: {
                pSCtrlTypeActionBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSCtrlTypeActionBase.resetPSCtrlActionId();
                return true;
            }
            case 5: {
                pSCtrlTypeActionBase.resetPSCtrlActionName();
                return true;
            }
            case 6: {
                pSCtrlTypeActionBase.resetPSCtrlTypeActionId();
                return true;
            }
            case 7: {
                pSCtrlTypeActionBase.resetPSCtrlTypeActionName();
                return true;
            }
            case 8: {
                pSCtrlTypeActionBase.resetPSCtrlTypeId();
                return true;
            }
            case 9: {
                pSCtrlTypeActionBase.resetPSCtrlTypeName();
                return true;
            }
            case 10: {
                pSCtrlTypeActionBase.resetR7DExample();
                return true;
            }
            case 11: {
                pSCtrlTypeActionBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSCtrlTypeActionBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSCtrlTypeActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlAction getPSCtrlAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlAction();
        }
        if (this.getPSCtrlActionId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlActionLock;
        synchronized (n) {
            if (this.psctrlaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlActionId(), (Object)this.psctrlaction.getPSCtrlActionId()) != 0L) {
                this.psctrlaction = null;
            }
            if (this.psctrlaction == null) {
                PSCtrlAction pSCtrlAction = new PSCtrlAction();
                pSCtrlAction.setPSCtrlActionId(this.getPSCtrlActionId());
                PSCtrlActionService pSCtrlActionService = (PSCtrlActionService)ServiceGlobal.getService(PSCtrlActionService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlActionService.autoGet(pSCtrlAction);
                this.psctrlaction = pSCtrlAction;
            }
            return this.psctrlaction;
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

    private PSCtrlTypeActionBase getProxyEntity() {
        return this.proxyPSCtrlTypeActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlTypeActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlTypeActionBase) {
            this.proxyPSCtrlTypeActionBase = (PSCtrlTypeActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSCTRLACTIONID, 4);
        fieldIndexMap.put(FIELD_PSCTRLACTIONNAME, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPEACTIONID, 6);
        fieldIndexMap.put(FIELD_PSCTRLTYPEACTIONNAME, 7);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 8);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 9);
        fieldIndexMap.put(FIELD_R7DEXAMPLE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

