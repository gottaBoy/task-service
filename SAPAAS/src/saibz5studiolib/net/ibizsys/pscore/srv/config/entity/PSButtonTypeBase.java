/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSButtonTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSButtonTypeBase.class);
    public static final String FIELD_BUTTONPARAMS = "BUTTONPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLOBJ = "CTRLOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSBUTTONTYPEID = "PSBUTTONTYPEID";
    public static final String FIELD_PSBUTTONTYPENAME = "PSBUTTONTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BUTTONPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CTRLOBJ = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSBUTTONTYPEID = 6;
    private static final int INDEX_PSBUTTONTYPENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSButtonTypeBase proxyPSButtonTypeBase = null;
    private boolean buttonparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psbuttontypeidDirtyFlag = false;
    private boolean psbuttontypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="buttonparams")
    private String buttonparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlobj")
    private String ctrlobj;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psbuttontypeid")
    private String psbuttontypeid;
    @Column(name="psbuttontypename")
    private String psbuttontypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

    public void setButtonParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setButtonParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.buttonparams = string;
        this.buttonparamsDirtyFlag = true;
    }

    public String getButtonParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getButtonParams();
        }
        return this.buttonparams;
    }

    public boolean isButtonParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isButtonParamsDirty();
        }
        return this.buttonparamsDirtyFlag;
    }

    public void resetButtonParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetButtonParams();
            return;
        }
        this.buttonparamsDirtyFlag = false;
        this.buttonparams = null;
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

    public void setCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlobj = string;
        this.ctrlobjDirtyFlag = true;
    }

    public String getCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlObj();
        }
        return this.ctrlobj;
    }

    public boolean isCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlObjDirty();
        }
        return this.ctrlobjDirtyFlag;
    }

    public void resetCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlObj();
            return;
        }
        this.ctrlobjDirtyFlag = false;
        this.ctrlobj = null;
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

    public void setPSButtonTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSButtonTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbuttontypeid = string;
        this.psbuttontypeidDirtyFlag = true;
    }

    public String getPSButtonTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSButtonTypeId();
        }
        return this.psbuttontypeid;
    }

    public boolean isPSButtonTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSButtonTypeIdDirty();
        }
        return this.psbuttontypeidDirtyFlag;
    }

    public void resetPSButtonTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSButtonTypeId();
            return;
        }
        this.psbuttontypeidDirtyFlag = false;
        this.psbuttontypeid = null;
    }

    public void setPSButtonTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSButtonTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbuttontypename = string;
        this.psbuttontypenameDirtyFlag = true;
    }

    public String getPSButtonTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSButtonTypeName();
        }
        return this.psbuttontypename;
    }

    public boolean isPSButtonTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSButtonTypeNameDirty();
        }
        return this.psbuttontypenameDirtyFlag;
    }

    public void resetPSButtonTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSButtonTypeName();
            return;
        }
        this.psbuttontypenameDirtyFlag = false;
        this.psbuttontypename = null;
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
        PSButtonTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSButtonTypeBase pSButtonTypeBase) {
        pSButtonTypeBase.resetButtonParams();
        pSButtonTypeBase.resetCreateDate();
        pSButtonTypeBase.resetCreateMan();
        pSButtonTypeBase.resetCtrlObj();
        pSButtonTypeBase.resetMemo();
        pSButtonTypeBase.resetOrderValue();
        pSButtonTypeBase.resetPSButtonTypeId();
        pSButtonTypeBase.resetPSButtonTypeName();
        pSButtonTypeBase.resetUpdateDate();
        pSButtonTypeBase.resetUpdateMan();
        pSButtonTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isButtonParamsDirty()) {
            hashMap.put(FIELD_BUTTONPARAMS, this.getButtonParams());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlObjDirty()) {
            hashMap.put(FIELD_CTRLOBJ, this.getCtrlObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSButtonTypeIdDirty()) {
            hashMap.put(FIELD_PSBUTTONTYPEID, this.getPSButtonTypeId());
        }
        if (!bl || this.isPSButtonTypeNameDirty()) {
            hashMap.put(FIELD_PSBUTTONTYPENAME, this.getPSButtonTypeName());
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
        return PSButtonTypeBase.get(this, n);
    }

    private static Object get(PSButtonTypeBase pSButtonTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSButtonTypeBase.getButtonParams();
            }
            case 1: {
                return pSButtonTypeBase.getCreateDate();
            }
            case 2: {
                return pSButtonTypeBase.getCreateMan();
            }
            case 3: {
                return pSButtonTypeBase.getCtrlObj();
            }
            case 4: {
                return pSButtonTypeBase.getMemo();
            }
            case 5: {
                return pSButtonTypeBase.getOrderValue();
            }
            case 6: {
                return pSButtonTypeBase.getPSButtonTypeId();
            }
            case 7: {
                return pSButtonTypeBase.getPSButtonTypeName();
            }
            case 8: {
                return pSButtonTypeBase.getUpdateDate();
            }
            case 9: {
                return pSButtonTypeBase.getUpdateMan();
            }
            case 10: {
                return pSButtonTypeBase.getValidFlag();
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
        PSButtonTypeBase.set(this, n, object);
    }

    private static void set(PSButtonTypeBase pSButtonTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSButtonTypeBase.setButtonParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSButtonTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSButtonTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSButtonTypeBase.setCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSButtonTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSButtonTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSButtonTypeBase.setPSButtonTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSButtonTypeBase.setPSButtonTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSButtonTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSButtonTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSButtonTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSButtonTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSButtonTypeBase pSButtonTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSButtonTypeBase.getButtonParams() == null;
            }
            case 1: {
                return pSButtonTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSButtonTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSButtonTypeBase.getCtrlObj() == null;
            }
            case 4: {
                return pSButtonTypeBase.getMemo() == null;
            }
            case 5: {
                return pSButtonTypeBase.getOrderValue() == null;
            }
            case 6: {
                return pSButtonTypeBase.getPSButtonTypeId() == null;
            }
            case 7: {
                return pSButtonTypeBase.getPSButtonTypeName() == null;
            }
            case 8: {
                return pSButtonTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSButtonTypeBase.getUpdateMan() == null;
            }
            case 10: {
                return pSButtonTypeBase.getValidFlag() == null;
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
        return PSButtonTypeBase.contains(this, n);
    }

    private static boolean contains(PSButtonTypeBase pSButtonTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSButtonTypeBase.isButtonParamsDirty();
            }
            case 1: {
                return pSButtonTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSButtonTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSButtonTypeBase.isCtrlObjDirty();
            }
            case 4: {
                return pSButtonTypeBase.isMemoDirty();
            }
            case 5: {
                return pSButtonTypeBase.isOrderValueDirty();
            }
            case 6: {
                return pSButtonTypeBase.isPSButtonTypeIdDirty();
            }
            case 7: {
                return pSButtonTypeBase.isPSButtonTypeNameDirty();
            }
            case 8: {
                return pSButtonTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSButtonTypeBase.isUpdateManDirty();
            }
            case 10: {
                return pSButtonTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSButtonTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSButtonTypeBase pSButtonTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSButtonTypeBase.getButtonParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"buttonparams", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getButtonParams()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlobj", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getCtrlObj()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getPSButtonTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbuttontypeid", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getPSButtonTypeId()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getPSButtonTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbuttontypename", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getPSButtonTypeName()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSButtonTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSButtonTypeBase.getJSONValue((Object)pSButtonTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSButtonTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSButtonTypeBase pSButtonTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSButtonTypeBase.getButtonParams() != null) {
            object = pSButtonTypeBase.getButtonParams();
            xmlNode.setAttribute(FIELD_BUTTONPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSButtonTypeBase.getCreateDate() != null) {
            object = pSButtonTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSButtonTypeBase.getCreateMan() != null) {
            object = pSButtonTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSButtonTypeBase.getCtrlObj() != null) {
            object = pSButtonTypeBase.getCtrlObj();
            xmlNode.setAttribute(FIELD_CTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSButtonTypeBase.getMemo() != null) {
            object = pSButtonTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSButtonTypeBase.getOrderValue() != null) {
            object = pSButtonTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSButtonTypeBase.getPSButtonTypeId() != null) {
            object = pSButtonTypeBase.getPSButtonTypeId();
            xmlNode.setAttribute(FIELD_PSBUTTONTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSButtonTypeBase.getPSButtonTypeName() != null) {
            object = pSButtonTypeBase.getPSButtonTypeName();
            xmlNode.setAttribute(FIELD_PSBUTTONTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSButtonTypeBase.getUpdateDate() != null) {
            object = pSButtonTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSButtonTypeBase.getUpdateMan() != null) {
            object = pSButtonTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSButtonTypeBase.getValidFlag() != null) {
            object = pSButtonTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSButtonTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSButtonTypeBase pSButtonTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSButtonTypeBase.isButtonParamsDirty() && (bl || pSButtonTypeBase.getButtonParams() != null)) {
            iDataObject.set(FIELD_BUTTONPARAMS, (Object)pSButtonTypeBase.getButtonParams());
        }
        if (pSButtonTypeBase.isCreateDateDirty() && (bl || pSButtonTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSButtonTypeBase.getCreateDate());
        }
        if (pSButtonTypeBase.isCreateManDirty() && (bl || pSButtonTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSButtonTypeBase.getCreateMan());
        }
        if (pSButtonTypeBase.isCtrlObjDirty() && (bl || pSButtonTypeBase.getCtrlObj() != null)) {
            iDataObject.set(FIELD_CTRLOBJ, (Object)pSButtonTypeBase.getCtrlObj());
        }
        if (pSButtonTypeBase.isMemoDirty() && (bl || pSButtonTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSButtonTypeBase.getMemo());
        }
        if (pSButtonTypeBase.isOrderValueDirty() && (bl || pSButtonTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSButtonTypeBase.getOrderValue());
        }
        if (pSButtonTypeBase.isPSButtonTypeIdDirty() && (bl || pSButtonTypeBase.getPSButtonTypeId() != null)) {
            iDataObject.set(FIELD_PSBUTTONTYPEID, (Object)pSButtonTypeBase.getPSButtonTypeId());
        }
        if (pSButtonTypeBase.isPSButtonTypeNameDirty() && (bl || pSButtonTypeBase.getPSButtonTypeName() != null)) {
            iDataObject.set(FIELD_PSBUTTONTYPENAME, (Object)pSButtonTypeBase.getPSButtonTypeName());
        }
        if (pSButtonTypeBase.isUpdateDateDirty() && (bl || pSButtonTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSButtonTypeBase.getUpdateDate());
        }
        if (pSButtonTypeBase.isUpdateManDirty() && (bl || pSButtonTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSButtonTypeBase.getUpdateMan());
        }
        if (pSButtonTypeBase.isValidFlagDirty() && (bl || pSButtonTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSButtonTypeBase.getValidFlag());
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
        return PSButtonTypeBase.remove(this, n);
    }

    private static boolean remove(PSButtonTypeBase pSButtonTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSButtonTypeBase.resetButtonParams();
                return true;
            }
            case 1: {
                pSButtonTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSButtonTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSButtonTypeBase.resetCtrlObj();
                return true;
            }
            case 4: {
                pSButtonTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSButtonTypeBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSButtonTypeBase.resetPSButtonTypeId();
                return true;
            }
            case 7: {
                pSButtonTypeBase.resetPSButtonTypeName();
                return true;
            }
            case 8: {
                pSButtonTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSButtonTypeBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSButtonTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSButtonTypeBase getProxyEntity() {
        return this.proxyPSButtonTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSButtonTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSButtonTypeBase) {
            this.proxyPSButtonTypeBase = (PSButtonTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSButtonTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUTTONPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CTRLOBJ, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSBUTTONTYPEID, 6);
        fieldIndexMap.put(FIELD_PSBUTTONTYPENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

