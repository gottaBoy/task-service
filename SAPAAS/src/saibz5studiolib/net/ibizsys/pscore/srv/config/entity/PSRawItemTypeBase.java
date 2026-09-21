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

public abstract class PSRawItemTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRawItemTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLOBJ = "CTRLOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSRAWITEMTYPEID = "PSRAWITEMTYPEID";
    public static final String FIELD_PSRAWITEMTYPENAME = "PSRAWITEMTYPENAME";
    public static final String FIELD_ITEMPARAMS = "RAWITEMPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSRAWITEMTYPEID = 5;
    private static final int INDEX_PSRAWITEMTYPENAME = 6;
    private static final int INDEX_ITEMPARAMS = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRawItemTypeBase proxyPSRawItemTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psrawitemtypeidDirtyFlag = false;
    private boolean psrawitemtypenameDirtyFlag = false;
    private boolean itemparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
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
    @Column(name="psrawitemtypeid")
    private String psrawitemtypeid;
    @Column(name="psrawitemtypename")
    private String psrawitemtypename;
    @Column(name="itemparams")
    private String itemparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setPSRawItemTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRawItemTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrawitemtypeid = string;
        this.psrawitemtypeidDirtyFlag = true;
    }

    public String getPSRawItemTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRawItemTypeId();
        }
        return this.psrawitemtypeid;
    }

    public boolean isPSRawItemTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRawItemTypeIdDirty();
        }
        return this.psrawitemtypeidDirtyFlag;
    }

    public void resetPSRawItemTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRawItemTypeId();
            return;
        }
        this.psrawitemtypeidDirtyFlag = false;
        this.psrawitemtypeid = null;
    }

    public void setPSRawItemTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRawItemTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrawitemtypename = string;
        this.psrawitemtypenameDirtyFlag = true;
    }

    public String getPSRawItemTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRawItemTypeName();
        }
        return this.psrawitemtypename;
    }

    public boolean isPSRawItemTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRawItemTypeNameDirty();
        }
        return this.psrawitemtypenameDirtyFlag;
    }

    public void resetPSRawItemTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRawItemTypeName();
            return;
        }
        this.psrawitemtypenameDirtyFlag = false;
        this.psrawitemtypename = null;
    }

    public void setItemParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparams = string;
        this.itemparamsDirtyFlag = true;
    }

    public String getItemParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParams();
        }
        return this.itemparams;
    }

    public boolean isItemParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParamsDirty();
        }
        return this.itemparamsDirtyFlag;
    }

    public void resetItemParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParams();
            return;
        }
        this.itemparamsDirtyFlag = false;
        this.itemparams = null;
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
        PSRawItemTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRawItemTypeBase pSRawItemTypeBase) {
        pSRawItemTypeBase.resetCreateDate();
        pSRawItemTypeBase.resetCreateMan();
        pSRawItemTypeBase.resetCtrlObj();
        pSRawItemTypeBase.resetMemo();
        pSRawItemTypeBase.resetOrderValue();
        pSRawItemTypeBase.resetPSRawItemTypeId();
        pSRawItemTypeBase.resetPSRawItemTypeName();
        pSRawItemTypeBase.resetItemParams();
        pSRawItemTypeBase.resetUpdateDate();
        pSRawItemTypeBase.resetUpdateMan();
        pSRawItemTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSRawItemTypeIdDirty()) {
            hashMap.put(FIELD_PSRAWITEMTYPEID, this.getPSRawItemTypeId());
        }
        if (!bl || this.isPSRawItemTypeNameDirty()) {
            hashMap.put(FIELD_PSRAWITEMTYPENAME, this.getPSRawItemTypeName());
        }
        if (!bl || this.isItemParamsDirty()) {
            hashMap.put(FIELD_ITEMPARAMS, this.getItemParams());
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
        return PSRawItemTypeBase.get(this, n);
    }

    private static Object get(PSRawItemTypeBase pSRawItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRawItemTypeBase.getCreateDate();
            }
            case 1: {
                return pSRawItemTypeBase.getCreateMan();
            }
            case 2: {
                return pSRawItemTypeBase.getCtrlObj();
            }
            case 3: {
                return pSRawItemTypeBase.getMemo();
            }
            case 4: {
                return pSRawItemTypeBase.getOrderValue();
            }
            case 5: {
                return pSRawItemTypeBase.getPSRawItemTypeId();
            }
            case 6: {
                return pSRawItemTypeBase.getPSRawItemTypeName();
            }
            case 7: {
                return pSRawItemTypeBase.getItemParams();
            }
            case 8: {
                return pSRawItemTypeBase.getUpdateDate();
            }
            case 9: {
                return pSRawItemTypeBase.getUpdateMan();
            }
            case 10: {
                return pSRawItemTypeBase.getValidFlag();
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
        PSRawItemTypeBase.set(this, n, object);
    }

    private static void set(PSRawItemTypeBase pSRawItemTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRawItemTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRawItemTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRawItemTypeBase.setCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSRawItemTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRawItemTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSRawItemTypeBase.setPSRawItemTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRawItemTypeBase.setPSRawItemTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSRawItemTypeBase.setItemParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRawItemTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSRawItemTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRawItemTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRawItemTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSRawItemTypeBase pSRawItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRawItemTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSRawItemTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSRawItemTypeBase.getCtrlObj() == null;
            }
            case 3: {
                return pSRawItemTypeBase.getMemo() == null;
            }
            case 4: {
                return pSRawItemTypeBase.getOrderValue() == null;
            }
            case 5: {
                return pSRawItemTypeBase.getPSRawItemTypeId() == null;
            }
            case 6: {
                return pSRawItemTypeBase.getPSRawItemTypeName() == null;
            }
            case 7: {
                return pSRawItemTypeBase.getItemParams() == null;
            }
            case 8: {
                return pSRawItemTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSRawItemTypeBase.getUpdateMan() == null;
            }
            case 10: {
                return pSRawItemTypeBase.getValidFlag() == null;
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
        return PSRawItemTypeBase.contains(this, n);
    }

    private static boolean contains(PSRawItemTypeBase pSRawItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRawItemTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSRawItemTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSRawItemTypeBase.isCtrlObjDirty();
            }
            case 3: {
                return pSRawItemTypeBase.isMemoDirty();
            }
            case 4: {
                return pSRawItemTypeBase.isOrderValueDirty();
            }
            case 5: {
                return pSRawItemTypeBase.isPSRawItemTypeIdDirty();
            }
            case 6: {
                return pSRawItemTypeBase.isPSRawItemTypeNameDirty();
            }
            case 7: {
                return pSRawItemTypeBase.isItemParamsDirty();
            }
            case 8: {
                return pSRawItemTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSRawItemTypeBase.isUpdateManDirty();
            }
            case 10: {
                return pSRawItemTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRawItemTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRawItemTypeBase pSRawItemTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRawItemTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlobj", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getCtrlObj()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getPSRawItemTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrawitemtypeid", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getPSRawItemTypeId()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getPSRawItemTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrawitemtypename", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getPSRawItemTypeName()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getItemParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawitemparams", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getItemParams()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRawItemTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRawItemTypeBase.getJSONValue((Object)pSRawItemTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRawItemTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRawItemTypeBase pSRawItemTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRawItemTypeBase.getCreateDate() != null) {
            object = pSRawItemTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRawItemTypeBase.getCreateMan() != null) {
            object = pSRawItemTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRawItemTypeBase.getCtrlObj() != null) {
            object = pSRawItemTypeBase.getCtrlObj();
            xmlNode.setAttribute(FIELD_CTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSRawItemTypeBase.getMemo() != null) {
            object = pSRawItemTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRawItemTypeBase.getOrderValue() != null) {
            object = pSRawItemTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRawItemTypeBase.getPSRawItemTypeId() != null) {
            object = pSRawItemTypeBase.getPSRawItemTypeId();
            xmlNode.setAttribute(FIELD_PSRAWITEMTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSRawItemTypeBase.getPSRawItemTypeName() != null) {
            object = pSRawItemTypeBase.getPSRawItemTypeName();
            xmlNode.setAttribute(FIELD_PSRAWITEMTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSRawItemTypeBase.getItemParams() != null) {
            object = pSRawItemTypeBase.getItemParams();
            xmlNode.setAttribute("ITEMPARAMS", object == null ? "" : (String)object);
        }
        if (bl || pSRawItemTypeBase.getUpdateDate() != null) {
            object = pSRawItemTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRawItemTypeBase.getUpdateMan() != null) {
            object = pSRawItemTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRawItemTypeBase.getValidFlag() != null) {
            object = pSRawItemTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRawItemTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRawItemTypeBase pSRawItemTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRawItemTypeBase.isCreateDateDirty() && (bl || pSRawItemTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRawItemTypeBase.getCreateDate());
        }
        if (pSRawItemTypeBase.isCreateManDirty() && (bl || pSRawItemTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRawItemTypeBase.getCreateMan());
        }
        if (pSRawItemTypeBase.isCtrlObjDirty() && (bl || pSRawItemTypeBase.getCtrlObj() != null)) {
            iDataObject.set(FIELD_CTRLOBJ, (Object)pSRawItemTypeBase.getCtrlObj());
        }
        if (pSRawItemTypeBase.isMemoDirty() && (bl || pSRawItemTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRawItemTypeBase.getMemo());
        }
        if (pSRawItemTypeBase.isOrderValueDirty() && (bl || pSRawItemTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSRawItemTypeBase.getOrderValue());
        }
        if (pSRawItemTypeBase.isPSRawItemTypeIdDirty() && (bl || pSRawItemTypeBase.getPSRawItemTypeId() != null)) {
            iDataObject.set(FIELD_PSRAWITEMTYPEID, (Object)pSRawItemTypeBase.getPSRawItemTypeId());
        }
        if (pSRawItemTypeBase.isPSRawItemTypeNameDirty() && (bl || pSRawItemTypeBase.getPSRawItemTypeName() != null)) {
            iDataObject.set(FIELD_PSRAWITEMTYPENAME, (Object)pSRawItemTypeBase.getPSRawItemTypeName());
        }
        if (pSRawItemTypeBase.isItemParamsDirty() && (bl || pSRawItemTypeBase.getItemParams() != null)) {
            iDataObject.set(FIELD_ITEMPARAMS, (Object)pSRawItemTypeBase.getItemParams());
        }
        if (pSRawItemTypeBase.isUpdateDateDirty() && (bl || pSRawItemTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRawItemTypeBase.getUpdateDate());
        }
        if (pSRawItemTypeBase.isUpdateManDirty() && (bl || pSRawItemTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRawItemTypeBase.getUpdateMan());
        }
        if (pSRawItemTypeBase.isValidFlagDirty() && (bl || pSRawItemTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRawItemTypeBase.getValidFlag());
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
        return PSRawItemTypeBase.remove(this, n);
    }

    private static boolean remove(PSRawItemTypeBase pSRawItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRawItemTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRawItemTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRawItemTypeBase.resetCtrlObj();
                return true;
            }
            case 3: {
                pSRawItemTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSRawItemTypeBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSRawItemTypeBase.resetPSRawItemTypeId();
                return true;
            }
            case 6: {
                pSRawItemTypeBase.resetPSRawItemTypeName();
                return true;
            }
            case 7: {
                pSRawItemTypeBase.resetItemParams();
                return true;
            }
            case 8: {
                pSRawItemTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSRawItemTypeBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSRawItemTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSRawItemTypeBase getProxyEntity() {
        return this.proxyPSRawItemTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRawItemTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSRawItemTypeBase) {
            this.proxyPSRawItemTypeBase = (PSRawItemTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRawItemTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSRAWITEMTYPEID, 5);
        fieldIndexMap.put(FIELD_PSRAWITEMTYPENAME, 6);
        fieldIndexMap.put(FIELD_ITEMPARAMS, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

