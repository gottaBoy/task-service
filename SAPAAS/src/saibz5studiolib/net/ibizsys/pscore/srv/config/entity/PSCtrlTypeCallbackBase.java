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
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeCallbackBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlTypeCallbackBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCTRLTYPECALLBACKID = "PSCTRLTYPECALLBACKID";
    public static final String FIELD_PSCTRLTYPECALLBACKNAME = "PSCTRLTYPECALLBACKNAME";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_R7DEXAMPLE = "R7DEXAMPLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ORDERVALUE = 2;
    private static final int INDEX_PSCTRLTYPECALLBACKID = 3;
    private static final int INDEX_PSCTRLTYPECALLBACKNAME = 4;
    private static final int INDEX_PSCTRLTYPEID = 5;
    private static final int INDEX_PSCTRLTYPENAME = 6;
    private static final int INDEX_R7DEXAMPLE = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlTypeCallbackBase proxyPSCtrlTypeCallbackBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psctrltypecallbackidDirtyFlag = false;
    private boolean psctrltypecallbacknameDirtyFlag = false;
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
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psctrltypecallbackid")
    private String psctrltypecallbackid;
    @Column(name="psctrltypecallbackname")
    private String psctrltypecallbackname;
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

    public void setPSCtrlTypeCallbackId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeCallbackId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypecallbackid = string;
        this.psctrltypecallbackidDirtyFlag = true;
    }

    public String getPSCtrlTypeCallbackId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeCallbackId();
        }
        return this.psctrltypecallbackid;
    }

    public boolean isPSCtrlTypeCallbackIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeCallbackIdDirty();
        }
        return this.psctrltypecallbackidDirtyFlag;
    }

    public void resetPSCtrlTypeCallbackId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeCallbackId();
            return;
        }
        this.psctrltypecallbackidDirtyFlag = false;
        this.psctrltypecallbackid = null;
    }

    public void setPSCtrlTypeCallbackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeCallbackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypecallbackname = string;
        this.psctrltypecallbacknameDirtyFlag = true;
    }

    public String getPSCtrlTypeCallbackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeCallbackName();
        }
        return this.psctrltypecallbackname;
    }

    public boolean isPSCtrlTypeCallbackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeCallbackNameDirty();
        }
        return this.psctrltypecallbacknameDirtyFlag;
    }

    public void resetPSCtrlTypeCallbackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeCallbackName();
            return;
        }
        this.psctrltypecallbacknameDirtyFlag = false;
        this.psctrltypecallbackname = null;
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
        PSCtrlTypeCallbackBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase) {
        pSCtrlTypeCallbackBase.resetCreateDate();
        pSCtrlTypeCallbackBase.resetCreateMan();
        pSCtrlTypeCallbackBase.resetOrderValue();
        pSCtrlTypeCallbackBase.resetPSCtrlTypeCallbackId();
        pSCtrlTypeCallbackBase.resetPSCtrlTypeCallbackName();
        pSCtrlTypeCallbackBase.resetPSCtrlTypeId();
        pSCtrlTypeCallbackBase.resetPSCtrlTypeName();
        pSCtrlTypeCallbackBase.resetR7DExample();
        pSCtrlTypeCallbackBase.resetUpdateDate();
        pSCtrlTypeCallbackBase.resetUpdateMan();
        pSCtrlTypeCallbackBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSCtrlTypeCallbackIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPECALLBACKID, this.getPSCtrlTypeCallbackId());
        }
        if (!bl || this.isPSCtrlTypeCallbackNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPECALLBACKNAME, this.getPSCtrlTypeCallbackName());
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
        return PSCtrlTypeCallbackBase.get(this, n);
    }

    private static Object get(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeCallbackBase.getCreateDate();
            }
            case 1: {
                return pSCtrlTypeCallbackBase.getCreateMan();
            }
            case 2: {
                return pSCtrlTypeCallbackBase.getOrderValue();
            }
            case 3: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId();
            }
            case 4: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName();
            }
            case 5: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeId();
            }
            case 6: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeName();
            }
            case 7: {
                return pSCtrlTypeCallbackBase.getR7DExample();
            }
            case 8: {
                return pSCtrlTypeCallbackBase.getUpdateDate();
            }
            case 9: {
                return pSCtrlTypeCallbackBase.getUpdateMan();
            }
            case 10: {
                return pSCtrlTypeCallbackBase.getValidFlag();
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
        PSCtrlTypeCallbackBase.set(this, n, object);
    }

    private static void set(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeCallbackBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlTypeCallbackBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlTypeCallbackBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlTypeCallbackBase.setPSCtrlTypeCallbackId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlTypeCallbackBase.setPSCtrlTypeCallbackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlTypeCallbackBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlTypeCallbackBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlTypeCallbackBase.setR7DExample(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlTypeCallbackBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlTypeCallbackBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlTypeCallbackBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlTypeCallbackBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeCallbackBase.getCreateDate() == null;
            }
            case 1: {
                return pSCtrlTypeCallbackBase.getCreateMan() == null;
            }
            case 2: {
                return pSCtrlTypeCallbackBase.getOrderValue() == null;
            }
            case 3: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId() == null;
            }
            case 4: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName() == null;
            }
            case 5: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeId() == null;
            }
            case 6: {
                return pSCtrlTypeCallbackBase.getPSCtrlTypeName() == null;
            }
            case 7: {
                return pSCtrlTypeCallbackBase.getR7DExample() == null;
            }
            case 8: {
                return pSCtrlTypeCallbackBase.getUpdateDate() == null;
            }
            case 9: {
                return pSCtrlTypeCallbackBase.getUpdateMan() == null;
            }
            case 10: {
                return pSCtrlTypeCallbackBase.getValidFlag() == null;
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
        return PSCtrlTypeCallbackBase.contains(this, n);
    }

    private static boolean contains(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeCallbackBase.isCreateDateDirty();
            }
            case 1: {
                return pSCtrlTypeCallbackBase.isCreateManDirty();
            }
            case 2: {
                return pSCtrlTypeCallbackBase.isOrderValueDirty();
            }
            case 3: {
                return pSCtrlTypeCallbackBase.isPSCtrlTypeCallbackIdDirty();
            }
            case 4: {
                return pSCtrlTypeCallbackBase.isPSCtrlTypeCallbackNameDirty();
            }
            case 5: {
                return pSCtrlTypeCallbackBase.isPSCtrlTypeIdDirty();
            }
            case 6: {
                return pSCtrlTypeCallbackBase.isPSCtrlTypeNameDirty();
            }
            case 7: {
                return pSCtrlTypeCallbackBase.isR7DExampleDirty();
            }
            case 8: {
                return pSCtrlTypeCallbackBase.isUpdateDateDirty();
            }
            case 9: {
                return pSCtrlTypeCallbackBase.isUpdateManDirty();
            }
            case 10: {
                return pSCtrlTypeCallbackBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlTypeCallbackBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlTypeCallbackBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypecallbackid", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypecallbackname", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getR7DExample() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"r7dexample", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getR7DExample()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeCallbackBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlTypeCallbackBase.getJSONValue((Object)pSCtrlTypeCallbackBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlTypeCallbackBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlTypeCallbackBase.getCreateDate() != null) {
            object = pSCtrlTypeCallbackBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeCallbackBase.getCreateMan() != null) {
            object = pSCtrlTypeCallbackBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeCallbackBase.getOrderValue() != null) {
            object = pSCtrlTypeCallbackBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId() != null) {
            object = pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPECALLBACKID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName() != null) {
            object = pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPECALLBACKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeId() != null) {
            object = pSCtrlTypeCallbackBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeName() != null) {
            object = pSCtrlTypeCallbackBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeCallbackBase.getR7DExample() != null) {
            object = pSCtrlTypeCallbackBase.getR7DExample();
            xmlNode.setAttribute(FIELD_R7DEXAMPLE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeCallbackBase.getUpdateDate() != null) {
            object = pSCtrlTypeCallbackBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeCallbackBase.getUpdateMan() != null) {
            object = pSCtrlTypeCallbackBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeCallbackBase.getValidFlag() != null) {
            object = pSCtrlTypeCallbackBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlTypeCallbackBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlTypeCallbackBase.isCreateDateDirty() && (bl || pSCtrlTypeCallbackBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlTypeCallbackBase.getCreateDate());
        }
        if (pSCtrlTypeCallbackBase.isCreateManDirty() && (bl || pSCtrlTypeCallbackBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlTypeCallbackBase.getCreateMan());
        }
        if (pSCtrlTypeCallbackBase.isOrderValueDirty() && (bl || pSCtrlTypeCallbackBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCtrlTypeCallbackBase.getOrderValue());
        }
        if (pSCtrlTypeCallbackBase.isPSCtrlTypeCallbackIdDirty() && (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPECALLBACKID, (Object)pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackId());
        }
        if (pSCtrlTypeCallbackBase.isPSCtrlTypeCallbackNameDirty() && (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPECALLBACKNAME, (Object)pSCtrlTypeCallbackBase.getPSCtrlTypeCallbackName());
        }
        if (pSCtrlTypeCallbackBase.isPSCtrlTypeIdDirty() && (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSCtrlTypeCallbackBase.getPSCtrlTypeId());
        }
        if (pSCtrlTypeCallbackBase.isPSCtrlTypeNameDirty() && (bl || pSCtrlTypeCallbackBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSCtrlTypeCallbackBase.getPSCtrlTypeName());
        }
        if (pSCtrlTypeCallbackBase.isR7DExampleDirty() && (bl || pSCtrlTypeCallbackBase.getR7DExample() != null)) {
            iDataObject.set(FIELD_R7DEXAMPLE, (Object)pSCtrlTypeCallbackBase.getR7DExample());
        }
        if (pSCtrlTypeCallbackBase.isUpdateDateDirty() && (bl || pSCtrlTypeCallbackBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlTypeCallbackBase.getUpdateDate());
        }
        if (pSCtrlTypeCallbackBase.isUpdateManDirty() && (bl || pSCtrlTypeCallbackBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlTypeCallbackBase.getUpdateMan());
        }
        if (pSCtrlTypeCallbackBase.isValidFlagDirty() && (bl || pSCtrlTypeCallbackBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlTypeCallbackBase.getValidFlag());
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
        return PSCtrlTypeCallbackBase.remove(this, n);
    }

    private static boolean remove(PSCtrlTypeCallbackBase pSCtrlTypeCallbackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeCallbackBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCtrlTypeCallbackBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCtrlTypeCallbackBase.resetOrderValue();
                return true;
            }
            case 3: {
                pSCtrlTypeCallbackBase.resetPSCtrlTypeCallbackId();
                return true;
            }
            case 4: {
                pSCtrlTypeCallbackBase.resetPSCtrlTypeCallbackName();
                return true;
            }
            case 5: {
                pSCtrlTypeCallbackBase.resetPSCtrlTypeId();
                return true;
            }
            case 6: {
                pSCtrlTypeCallbackBase.resetPSCtrlTypeName();
                return true;
            }
            case 7: {
                pSCtrlTypeCallbackBase.resetR7DExample();
                return true;
            }
            case 8: {
                pSCtrlTypeCallbackBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSCtrlTypeCallbackBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSCtrlTypeCallbackBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSCtrlTypeCallbackBase getProxyEntity() {
        return this.proxyPSCtrlTypeCallbackBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlTypeCallbackBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlTypeCallbackBase) {
            this.proxyPSCtrlTypeCallbackBase = (PSCtrlTypeCallbackBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeCallbackService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ORDERVALUE, 2);
        fieldIndexMap.put(FIELD_PSCTRLTYPECALLBACKID, 3);
        fieldIndexMap.put(FIELD_PSCTRLTYPECALLBACKNAME, 4);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 6);
        fieldIndexMap.put(FIELD_R7DEXAMPLE, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

