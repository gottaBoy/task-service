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

public abstract class PSSysModelFuncCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelFuncCatBase.class);
    public static final String FIELD_CATDESC = "CATDESC";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSMODELFUNCCATID = "PSSYSMODELFUNCCATID";
    public static final String FIELD_PSSYSMODELFUNCCATNAME = "PSSYSMODELFUNCCATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CATDESC = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSSYSMODELFUNCCATID = 5;
    private static final int INDEX_PSSYSMODELFUNCCATNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelFuncCatBase proxyPSSysModelFuncCatBase = null;
    private boolean catdescDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssysmodelfunccatidDirtyFlag = false;
    private boolean pssysmodelfunccatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="catdesc")
    private String catdesc;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssysmodelfunccatid")
    private String pssysmodelfunccatid;
    @Column(name="pssysmodelfunccatname")
    private String pssysmodelfunccatname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

    public void setCatDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.catdesc = string;
        this.catdescDirtyFlag = true;
    }

    public String getCatDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatDesc();
        }
        return this.catdesc;
    }

    public boolean isCatDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatDescDirty();
        }
        return this.catdescDirtyFlag;
    }

    public void resetCatDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatDesc();
            return;
        }
        this.catdescDirtyFlag = false;
        this.catdesc = null;
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

    public void setPSSysModelFuncCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfunccatid = string;
        this.pssysmodelfunccatidDirtyFlag = true;
    }

    public String getPSSysModelFuncCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncCatId();
        }
        return this.pssysmodelfunccatid;
    }

    public boolean isPSSysModelFuncCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncCatIdDirty();
        }
        return this.pssysmodelfunccatidDirtyFlag;
    }

    public void resetPSSysModelFuncCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncCatId();
            return;
        }
        this.pssysmodelfunccatidDirtyFlag = false;
        this.pssysmodelfunccatid = null;
    }

    public void setPSSysModelFuncCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfunccatname = string;
        this.pssysmodelfunccatnameDirtyFlag = true;
    }

    public String getPSSysModelFuncCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncCatName();
        }
        return this.pssysmodelfunccatname;
    }

    public boolean isPSSysModelFuncCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncCatNameDirty();
        }
        return this.pssysmodelfunccatnameDirtyFlag;
    }

    public void resetPSSysModelFuncCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncCatName();
            return;
        }
        this.pssysmodelfunccatnameDirtyFlag = false;
        this.pssysmodelfunccatname = null;
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
        PSSysModelFuncCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelFuncCatBase pSSysModelFuncCatBase) {
        pSSysModelFuncCatBase.resetCatDesc();
        pSSysModelFuncCatBase.resetCreateDate();
        pSSysModelFuncCatBase.resetCreateMan();
        pSSysModelFuncCatBase.resetMemo();
        pSSysModelFuncCatBase.resetOrderValue();
        pSSysModelFuncCatBase.resetPSSysModelFuncCatId();
        pSSysModelFuncCatBase.resetPSSysModelFuncCatName();
        pSSysModelFuncCatBase.resetUpdateDate();
        pSSysModelFuncCatBase.resetUpdateMan();
        pSSysModelFuncCatBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatDescDirty()) {
            hashMap.put(FIELD_CATDESC, this.getCatDesc());
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysModelFuncCatIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCCATID, this.getPSSysModelFuncCatId());
        }
        if (!bl || this.isPSSysModelFuncCatNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCCATNAME, this.getPSSysModelFuncCatName());
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
        return PSSysModelFuncCatBase.get(this, n);
    }

    private static Object get(PSSysModelFuncCatBase pSSysModelFuncCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncCatBase.getCatDesc();
            }
            case 1: {
                return pSSysModelFuncCatBase.getCreateDate();
            }
            case 2: {
                return pSSysModelFuncCatBase.getCreateMan();
            }
            case 3: {
                return pSSysModelFuncCatBase.getMemo();
            }
            case 4: {
                return pSSysModelFuncCatBase.getOrderValue();
            }
            case 5: {
                return pSSysModelFuncCatBase.getPSSysModelFuncCatId();
            }
            case 6: {
                return pSSysModelFuncCatBase.getPSSysModelFuncCatName();
            }
            case 7: {
                return pSSysModelFuncCatBase.getUpdateDate();
            }
            case 8: {
                return pSSysModelFuncCatBase.getUpdateMan();
            }
            case 9: {
                return pSSysModelFuncCatBase.getValidFlag();
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
        PSSysModelFuncCatBase.set(this, n, object);
    }

    private static void set(PSSysModelFuncCatBase pSSysModelFuncCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFuncCatBase.setCatDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelFuncCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelFuncCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelFuncCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelFuncCatBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelFuncCatBase.setPSSysModelFuncCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelFuncCatBase.setPSSysModelFuncCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelFuncCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelFuncCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelFuncCatBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysModelFuncCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelFuncCatBase pSSysModelFuncCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncCatBase.getCatDesc() == null;
            }
            case 1: {
                return pSSysModelFuncCatBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysModelFuncCatBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysModelFuncCatBase.getMemo() == null;
            }
            case 4: {
                return pSSysModelFuncCatBase.getOrderValue() == null;
            }
            case 5: {
                return pSSysModelFuncCatBase.getPSSysModelFuncCatId() == null;
            }
            case 6: {
                return pSSysModelFuncCatBase.getPSSysModelFuncCatName() == null;
            }
            case 7: {
                return pSSysModelFuncCatBase.getUpdateDate() == null;
            }
            case 8: {
                return pSSysModelFuncCatBase.getUpdateMan() == null;
            }
            case 9: {
                return pSSysModelFuncCatBase.getValidFlag() == null;
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
        return PSSysModelFuncCatBase.contains(this, n);
    }

    private static boolean contains(PSSysModelFuncCatBase pSSysModelFuncCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncCatBase.isCatDescDirty();
            }
            case 1: {
                return pSSysModelFuncCatBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysModelFuncCatBase.isCreateManDirty();
            }
            case 3: {
                return pSSysModelFuncCatBase.isMemoDirty();
            }
            case 4: {
                return pSSysModelFuncCatBase.isOrderValueDirty();
            }
            case 5: {
                return pSSysModelFuncCatBase.isPSSysModelFuncCatIdDirty();
            }
            case 6: {
                return pSSysModelFuncCatBase.isPSSysModelFuncCatNameDirty();
            }
            case 7: {
                return pSSysModelFuncCatBase.isUpdateDateDirty();
            }
            case 8: {
                return pSSysModelFuncCatBase.isUpdateManDirty();
            }
            case 9: {
                return pSSysModelFuncCatBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelFuncCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelFuncCatBase pSSysModelFuncCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelFuncCatBase.getCatDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catdesc", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getCatDesc()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getPSSysModelFuncCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfunccatid", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getPSSysModelFuncCatId()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getPSSysModelFuncCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfunccatname", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getPSSysModelFuncCatName()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelFuncCatBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysModelFuncCatBase.getJSONValue((Object)pSSysModelFuncCatBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelFuncCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelFuncCatBase pSSysModelFuncCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelFuncCatBase.getCatDesc() != null) {
            object = pSSysModelFuncCatBase.getCatDesc();
            xmlNode.setAttribute(FIELD_CATDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncCatBase.getCreateDate() != null) {
            object = pSSysModelFuncCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFuncCatBase.getCreateMan() != null) {
            object = pSSysModelFuncCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncCatBase.getMemo() != null) {
            object = pSSysModelFuncCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncCatBase.getOrderValue() != null) {
            object = pSSysModelFuncCatBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelFuncCatBase.getPSSysModelFuncCatId() != null) {
            object = pSSysModelFuncCatBase.getPSSysModelFuncCatId();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncCatBase.getPSSysModelFuncCatName() != null) {
            object = pSSysModelFuncCatBase.getPSSysModelFuncCatName();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncCatBase.getUpdateDate() != null) {
            object = pSSysModelFuncCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFuncCatBase.getUpdateMan() != null) {
            object = pSSysModelFuncCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncCatBase.getValidFlag() != null) {
            object = pSSysModelFuncCatBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelFuncCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelFuncCatBase pSSysModelFuncCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelFuncCatBase.isCatDescDirty() && (bl || pSSysModelFuncCatBase.getCatDesc() != null)) {
            iDataObject.set(FIELD_CATDESC, (Object)pSSysModelFuncCatBase.getCatDesc());
        }
        if (pSSysModelFuncCatBase.isCreateDateDirty() && (bl || pSSysModelFuncCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelFuncCatBase.getCreateDate());
        }
        if (pSSysModelFuncCatBase.isCreateManDirty() && (bl || pSSysModelFuncCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelFuncCatBase.getCreateMan());
        }
        if (pSSysModelFuncCatBase.isMemoDirty() && (bl || pSSysModelFuncCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelFuncCatBase.getMemo());
        }
        if (pSSysModelFuncCatBase.isOrderValueDirty() && (bl || pSSysModelFuncCatBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysModelFuncCatBase.getOrderValue());
        }
        if (pSSysModelFuncCatBase.isPSSysModelFuncCatIdDirty() && (bl || pSSysModelFuncCatBase.getPSSysModelFuncCatId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCCATID, (Object)pSSysModelFuncCatBase.getPSSysModelFuncCatId());
        }
        if (pSSysModelFuncCatBase.isPSSysModelFuncCatNameDirty() && (bl || pSSysModelFuncCatBase.getPSSysModelFuncCatName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCCATNAME, (Object)pSSysModelFuncCatBase.getPSSysModelFuncCatName());
        }
        if (pSSysModelFuncCatBase.isUpdateDateDirty() && (bl || pSSysModelFuncCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelFuncCatBase.getUpdateDate());
        }
        if (pSSysModelFuncCatBase.isUpdateManDirty() && (bl || pSSysModelFuncCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelFuncCatBase.getUpdateMan());
        }
        if (pSSysModelFuncCatBase.isValidFlagDirty() && (bl || pSSysModelFuncCatBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysModelFuncCatBase.getValidFlag());
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
        return PSSysModelFuncCatBase.remove(this, n);
    }

    private static boolean remove(PSSysModelFuncCatBase pSSysModelFuncCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFuncCatBase.resetCatDesc();
                return true;
            }
            case 1: {
                pSSysModelFuncCatBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysModelFuncCatBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysModelFuncCatBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysModelFuncCatBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSSysModelFuncCatBase.resetPSSysModelFuncCatId();
                return true;
            }
            case 6: {
                pSSysModelFuncCatBase.resetPSSysModelFuncCatName();
                return true;
            }
            case 7: {
                pSSysModelFuncCatBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSSysModelFuncCatBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSSysModelFuncCatBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysModelFuncCatBase getProxyEntity() {
        return this.proxyPSSysModelFuncCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelFuncCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelFuncCatBase) {
            this.proxyPSSysModelFuncCatBase = (PSSysModelFuncCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysModelFuncCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CATDESC, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCCATID, 5);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCCATNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

