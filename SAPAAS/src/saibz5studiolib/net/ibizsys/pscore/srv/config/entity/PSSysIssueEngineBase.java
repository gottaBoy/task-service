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

public abstract class PSSysIssueEngineBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysIssueEngineBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENGINEOBJ = "ENGINEOBJ";
    public static final String FIELD_ENGINEPARAMS = "ENGINEPARAMS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSISSUEENGINEID = "PSSYSISSUEENGINEID";
    public static final String FIELD_PSSYSISSUEENGINENAME = "PSSYSISSUEENGINENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENGINEOBJ = 2;
    private static final int INDEX_ENGINEPARAMS = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSSYSISSUEENGINEID = 6;
    private static final int INDEX_PSSYSISSUEENGINENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysIssueEngineBase proxyPSSysIssueEngineBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean engineobjDirtyFlag = false;
    private boolean engineparamsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssysissueengineidDirtyFlag = false;
    private boolean pssysissueenginenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="engineobj")
    private String engineobj;
    @Column(name="engineparams")
    private String engineparams;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssysissueengineid")
    private String pssysissueengineid;
    @Column(name="pssysissueenginename")
    private String pssysissueenginename;
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

    public void setEngineObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineobj = string;
        this.engineobjDirtyFlag = true;
    }

    public String getEngineObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineObj();
        }
        return this.engineobj;
    }

    public boolean isEngineObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineObjDirty();
        }
        return this.engineobjDirtyFlag;
    }

    public void resetEngineObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineObj();
            return;
        }
        this.engineobjDirtyFlag = false;
        this.engineobj = null;
    }

    public void setEngineParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineparams = string;
        this.engineparamsDirtyFlag = true;
    }

    public String getEngineParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineParams();
        }
        return this.engineparams;
    }

    public boolean isEngineParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineParamsDirty();
        }
        return this.engineparamsDirtyFlag;
    }

    public void resetEngineParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineParams();
            return;
        }
        this.engineparamsDirtyFlag = false;
        this.engineparams = null;
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

    public void setPSSysIssueEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissueengineid = string;
        this.pssysissueengineidDirtyFlag = true;
    }

    public String getPSSysIssueEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueEngineId();
        }
        return this.pssysissueengineid;
    }

    public boolean isPSSysIssueEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueEngineIdDirty();
        }
        return this.pssysissueengineidDirtyFlag;
    }

    public void resetPSSysIssueEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueEngineId();
            return;
        }
        this.pssysissueengineidDirtyFlag = false;
        this.pssysissueengineid = null;
    }

    public void setPSSysIssueEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissueenginename = string;
        this.pssysissueenginenameDirtyFlag = true;
    }

    public String getPSSysIssueEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueEngineName();
        }
        return this.pssysissueenginename;
    }

    public boolean isPSSysIssueEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueEngineNameDirty();
        }
        return this.pssysissueenginenameDirtyFlag;
    }

    public void resetPSSysIssueEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueEngineName();
            return;
        }
        this.pssysissueenginenameDirtyFlag = false;
        this.pssysissueenginename = null;
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
        PSSysIssueEngineBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysIssueEngineBase pSSysIssueEngineBase) {
        pSSysIssueEngineBase.resetCreateDate();
        pSSysIssueEngineBase.resetCreateMan();
        pSSysIssueEngineBase.resetEngineObj();
        pSSysIssueEngineBase.resetEngineParams();
        pSSysIssueEngineBase.resetMemo();
        pSSysIssueEngineBase.resetOrderValue();
        pSSysIssueEngineBase.resetPSSysIssueEngineId();
        pSSysIssueEngineBase.resetPSSysIssueEngineName();
        pSSysIssueEngineBase.resetUpdateDate();
        pSSysIssueEngineBase.resetUpdateMan();
        pSSysIssueEngineBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEngineObjDirty()) {
            hashMap.put(FIELD_ENGINEOBJ, this.getEngineObj());
        }
        if (!bl || this.isEngineParamsDirty()) {
            hashMap.put(FIELD_ENGINEPARAMS, this.getEngineParams());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysIssueEngineIdDirty()) {
            hashMap.put(FIELD_PSSYSISSUEENGINEID, this.getPSSysIssueEngineId());
        }
        if (!bl || this.isPSSysIssueEngineNameDirty()) {
            hashMap.put(FIELD_PSSYSISSUEENGINENAME, this.getPSSysIssueEngineName());
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
        return PSSysIssueEngineBase.get(this, n);
    }

    private static Object get(PSSysIssueEngineBase pSSysIssueEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueEngineBase.getCreateDate();
            }
            case 1: {
                return pSSysIssueEngineBase.getCreateMan();
            }
            case 2: {
                return pSSysIssueEngineBase.getEngineObj();
            }
            case 3: {
                return pSSysIssueEngineBase.getEngineParams();
            }
            case 4: {
                return pSSysIssueEngineBase.getMemo();
            }
            case 5: {
                return pSSysIssueEngineBase.getOrderValue();
            }
            case 6: {
                return pSSysIssueEngineBase.getPSSysIssueEngineId();
            }
            case 7: {
                return pSSysIssueEngineBase.getPSSysIssueEngineName();
            }
            case 8: {
                return pSSysIssueEngineBase.getUpdateDate();
            }
            case 9: {
                return pSSysIssueEngineBase.getUpdateMan();
            }
            case 10: {
                return pSSysIssueEngineBase.getValidFlag();
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
        PSSysIssueEngineBase.set(this, n, object);
    }

    private static void set(PSSysIssueEngineBase pSSysIssueEngineBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysIssueEngineBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysIssueEngineBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysIssueEngineBase.setEngineObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysIssueEngineBase.setEngineParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysIssueEngineBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysIssueEngineBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysIssueEngineBase.setPSSysIssueEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysIssueEngineBase.setPSSysIssueEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysIssueEngineBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysIssueEngineBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysIssueEngineBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysIssueEngineBase.isNull(this, n);
    }

    private static boolean isNull(PSSysIssueEngineBase pSSysIssueEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueEngineBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysIssueEngineBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysIssueEngineBase.getEngineObj() == null;
            }
            case 3: {
                return pSSysIssueEngineBase.getEngineParams() == null;
            }
            case 4: {
                return pSSysIssueEngineBase.getMemo() == null;
            }
            case 5: {
                return pSSysIssueEngineBase.getOrderValue() == null;
            }
            case 6: {
                return pSSysIssueEngineBase.getPSSysIssueEngineId() == null;
            }
            case 7: {
                return pSSysIssueEngineBase.getPSSysIssueEngineName() == null;
            }
            case 8: {
                return pSSysIssueEngineBase.getUpdateDate() == null;
            }
            case 9: {
                return pSSysIssueEngineBase.getUpdateMan() == null;
            }
            case 10: {
                return pSSysIssueEngineBase.getValidFlag() == null;
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
        return PSSysIssueEngineBase.contains(this, n);
    }

    private static boolean contains(PSSysIssueEngineBase pSSysIssueEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueEngineBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysIssueEngineBase.isCreateManDirty();
            }
            case 2: {
                return pSSysIssueEngineBase.isEngineObjDirty();
            }
            case 3: {
                return pSSysIssueEngineBase.isEngineParamsDirty();
            }
            case 4: {
                return pSSysIssueEngineBase.isMemoDirty();
            }
            case 5: {
                return pSSysIssueEngineBase.isOrderValueDirty();
            }
            case 6: {
                return pSSysIssueEngineBase.isPSSysIssueEngineIdDirty();
            }
            case 7: {
                return pSSysIssueEngineBase.isPSSysIssueEngineNameDirty();
            }
            case 8: {
                return pSSysIssueEngineBase.isUpdateDateDirty();
            }
            case 9: {
                return pSSysIssueEngineBase.isUpdateManDirty();
            }
            case 10: {
                return pSSysIssueEngineBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysIssueEngineBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysIssueEngineBase pSSysIssueEngineBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysIssueEngineBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getEngineObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineobj", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getEngineObj()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getEngineParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineparams", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getEngineParams()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getPSSysIssueEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissueengineid", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getPSSysIssueEngineId()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getPSSysIssueEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissueenginename", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getPSSysIssueEngineName()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysIssueEngineBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysIssueEngineBase.getJSONValue((Object)pSSysIssueEngineBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysIssueEngineBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysIssueEngineBase pSSysIssueEngineBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysIssueEngineBase.getCreateDate() != null) {
            object = pSSysIssueEngineBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueEngineBase.getCreateMan() != null) {
            object = pSSysIssueEngineBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueEngineBase.getEngineObj() != null) {
            object = pSSysIssueEngineBase.getEngineObj();
            xmlNode.setAttribute(FIELD_ENGINEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueEngineBase.getEngineParams() != null) {
            object = pSSysIssueEngineBase.getEngineParams();
            xmlNode.setAttribute(FIELD_ENGINEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueEngineBase.getMemo() != null) {
            object = pSSysIssueEngineBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueEngineBase.getOrderValue() != null) {
            object = pSSysIssueEngineBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysIssueEngineBase.getPSSysIssueEngineId() != null) {
            object = pSSysIssueEngineBase.getPSSysIssueEngineId();
            xmlNode.setAttribute(FIELD_PSSYSISSUEENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueEngineBase.getPSSysIssueEngineName() != null) {
            object = pSSysIssueEngineBase.getPSSysIssueEngineName();
            xmlNode.setAttribute(FIELD_PSSYSISSUEENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueEngineBase.getUpdateDate() != null) {
            object = pSSysIssueEngineBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueEngineBase.getUpdateMan() != null) {
            object = pSSysIssueEngineBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueEngineBase.getValidFlag() != null) {
            object = pSSysIssueEngineBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysIssueEngineBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysIssueEngineBase pSSysIssueEngineBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysIssueEngineBase.isCreateDateDirty() && (bl || pSSysIssueEngineBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysIssueEngineBase.getCreateDate());
        }
        if (pSSysIssueEngineBase.isCreateManDirty() && (bl || pSSysIssueEngineBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysIssueEngineBase.getCreateMan());
        }
        if (pSSysIssueEngineBase.isEngineObjDirty() && (bl || pSSysIssueEngineBase.getEngineObj() != null)) {
            iDataObject.set(FIELD_ENGINEOBJ, (Object)pSSysIssueEngineBase.getEngineObj());
        }
        if (pSSysIssueEngineBase.isEngineParamsDirty() && (bl || pSSysIssueEngineBase.getEngineParams() != null)) {
            iDataObject.set(FIELD_ENGINEPARAMS, (Object)pSSysIssueEngineBase.getEngineParams());
        }
        if (pSSysIssueEngineBase.isMemoDirty() && (bl || pSSysIssueEngineBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysIssueEngineBase.getMemo());
        }
        if (pSSysIssueEngineBase.isOrderValueDirty() && (bl || pSSysIssueEngineBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysIssueEngineBase.getOrderValue());
        }
        if (pSSysIssueEngineBase.isPSSysIssueEngineIdDirty() && (bl || pSSysIssueEngineBase.getPSSysIssueEngineId() != null)) {
            iDataObject.set(FIELD_PSSYSISSUEENGINEID, (Object)pSSysIssueEngineBase.getPSSysIssueEngineId());
        }
        if (pSSysIssueEngineBase.isPSSysIssueEngineNameDirty() && (bl || pSSysIssueEngineBase.getPSSysIssueEngineName() != null)) {
            iDataObject.set(FIELD_PSSYSISSUEENGINENAME, (Object)pSSysIssueEngineBase.getPSSysIssueEngineName());
        }
        if (pSSysIssueEngineBase.isUpdateDateDirty() && (bl || pSSysIssueEngineBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysIssueEngineBase.getUpdateDate());
        }
        if (pSSysIssueEngineBase.isUpdateManDirty() && (bl || pSSysIssueEngineBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysIssueEngineBase.getUpdateMan());
        }
        if (pSSysIssueEngineBase.isValidFlagDirty() && (bl || pSSysIssueEngineBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysIssueEngineBase.getValidFlag());
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
        return PSSysIssueEngineBase.remove(this, n);
    }

    private static boolean remove(PSSysIssueEngineBase pSSysIssueEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysIssueEngineBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysIssueEngineBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysIssueEngineBase.resetEngineObj();
                return true;
            }
            case 3: {
                pSSysIssueEngineBase.resetEngineParams();
                return true;
            }
            case 4: {
                pSSysIssueEngineBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysIssueEngineBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSSysIssueEngineBase.resetPSSysIssueEngineId();
                return true;
            }
            case 7: {
                pSSysIssueEngineBase.resetPSSysIssueEngineName();
                return true;
            }
            case 8: {
                pSSysIssueEngineBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSSysIssueEngineBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSSysIssueEngineBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysIssueEngineBase getProxyEntity() {
        return this.proxyPSSysIssueEngineBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysIssueEngineBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysIssueEngineBase) {
            this.proxyPSSysIssueEngineBase = (PSSysIssueEngineBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysIssueEngineService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENGINEOBJ, 2);
        fieldIndexMap.put(FIELD_ENGINEPARAMS, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSSYSISSUEENGINEID, 6);
        fieldIndexMap.put(FIELD_PSSYSISSUEENGINENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

