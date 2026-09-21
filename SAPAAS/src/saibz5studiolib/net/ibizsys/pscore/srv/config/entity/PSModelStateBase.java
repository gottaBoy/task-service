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
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelStateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelStateBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELSTATEID = "PSMODELSTATEID";
    public static final String FIELD_PSMODELSTATENAME = "PSMODELSTATENAME";
    public static final String FIELD_STATEDESC = "STATEDESC";
    public static final String FIELD_STATEVALUE = "STATEVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSMODELID = 3;
    private static final int INDEX_PSMODELNAME = 4;
    private static final int INDEX_PSMODELSTATEID = 5;
    private static final int INDEX_PSMODELSTATENAME = 6;
    private static final int INDEX_STATEDESC = 7;
    private static final int INDEX_STATEVALUE = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelStateBase proxyPSModelStateBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodelstateidDirtyFlag = false;
    private boolean psmodelstatenameDirtyFlag = false;
    private boolean statedescDirtyFlag = false;
    private boolean statevalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodelstateid")
    private String psmodelstateid;
    @Column(name="psmodelstatename")
    private String psmodelstatename;
    @Column(name="statedesc")
    private String statedesc;
    @Column(name="statevalue")
    private Integer statevalue;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModelLock = new Integer(1);
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

    public void setPSModelStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelstateid = string;
        this.psmodelstateidDirtyFlag = true;
    }

    public String getPSModelStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelStateId();
        }
        return this.psmodelstateid;
    }

    public boolean isPSModelStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelStateIdDirty();
        }
        return this.psmodelstateidDirtyFlag;
    }

    public void resetPSModelStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelStateId();
            return;
        }
        this.psmodelstateidDirtyFlag = false;
        this.psmodelstateid = null;
    }

    public void setPSModelStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelstatename = string;
        this.psmodelstatenameDirtyFlag = true;
    }

    public String getPSModelStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelStateName();
        }
        return this.psmodelstatename;
    }

    public boolean isPSModelStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelStateNameDirty();
        }
        return this.psmodelstatenameDirtyFlag;
    }

    public void resetPSModelStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelStateName();
            return;
        }
        this.psmodelstatenameDirtyFlag = false;
        this.psmodelstatename = null;
    }

    public void setStateDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStateDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statedesc = string;
        this.statedescDirtyFlag = true;
    }

    public String getStateDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateDesc();
        }
        return this.statedesc;
    }

    public boolean isStateDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStateDescDirty();
        }
        return this.statedescDirtyFlag;
    }

    public void resetStateDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStateDesc();
            return;
        }
        this.statedescDirtyFlag = false;
        this.statedesc = null;
    }

    public void setStateValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStateValue(n);
            return;
        }
        this.statevalue = n;
        this.statevalueDirtyFlag = true;
    }

    public Integer getStateValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateValue();
        }
        return this.statevalue;
    }

    public boolean isStateValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStateValueDirty();
        }
        return this.statevalueDirtyFlag;
    }

    public void resetStateValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStateValue();
            return;
        }
        this.statevalueDirtyFlag = false;
        this.statevalue = null;
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

    protected void onReset() {
        PSModelStateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelStateBase pSModelStateBase) {
        pSModelStateBase.resetCreateDate();
        pSModelStateBase.resetCreateMan();
        pSModelStateBase.resetMemo();
        pSModelStateBase.resetPSModelId();
        pSModelStateBase.resetPSModelName();
        pSModelStateBase.resetPSModelStateId();
        pSModelStateBase.resetPSModelStateName();
        pSModelStateBase.resetStateDesc();
        pSModelStateBase.resetStateValue();
        pSModelStateBase.resetUpdateDate();
        pSModelStateBase.resetUpdateMan();
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
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelStateIdDirty()) {
            hashMap.put(FIELD_PSMODELSTATEID, this.getPSModelStateId());
        }
        if (!bl || this.isPSModelStateNameDirty()) {
            hashMap.put(FIELD_PSMODELSTATENAME, this.getPSModelStateName());
        }
        if (!bl || this.isStateDescDirty()) {
            hashMap.put(FIELD_STATEDESC, this.getStateDesc());
        }
        if (!bl || this.isStateValueDirty()) {
            hashMap.put(FIELD_STATEVALUE, this.getStateValue());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSModelStateBase.get(this, n);
    }

    private static Object get(PSModelStateBase pSModelStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelStateBase.getCreateDate();
            }
            case 1: {
                return pSModelStateBase.getCreateMan();
            }
            case 2: {
                return pSModelStateBase.getMemo();
            }
            case 3: {
                return pSModelStateBase.getPSModelId();
            }
            case 4: {
                return pSModelStateBase.getPSModelName();
            }
            case 5: {
                return pSModelStateBase.getPSModelStateId();
            }
            case 6: {
                return pSModelStateBase.getPSModelStateName();
            }
            case 7: {
                return pSModelStateBase.getStateDesc();
            }
            case 8: {
                return pSModelStateBase.getStateValue();
            }
            case 9: {
                return pSModelStateBase.getUpdateDate();
            }
            case 10: {
                return pSModelStateBase.getUpdateMan();
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
        PSModelStateBase.set(this, n, object);
    }

    private static void set(PSModelStateBase pSModelStateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelStateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelStateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelStateBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelStateBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelStateBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelStateBase.setPSModelStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelStateBase.setPSModelStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelStateBase.setStateDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelStateBase.setStateValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSModelStateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSModelStateBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelStateBase.isNull(this, n);
    }

    private static boolean isNull(PSModelStateBase pSModelStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelStateBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelStateBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelStateBase.getMemo() == null;
            }
            case 3: {
                return pSModelStateBase.getPSModelId() == null;
            }
            case 4: {
                return pSModelStateBase.getPSModelName() == null;
            }
            case 5: {
                return pSModelStateBase.getPSModelStateId() == null;
            }
            case 6: {
                return pSModelStateBase.getPSModelStateName() == null;
            }
            case 7: {
                return pSModelStateBase.getStateDesc() == null;
            }
            case 8: {
                return pSModelStateBase.getStateValue() == null;
            }
            case 9: {
                return pSModelStateBase.getUpdateDate() == null;
            }
            case 10: {
                return pSModelStateBase.getUpdateMan() == null;
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
        return PSModelStateBase.contains(this, n);
    }

    private static boolean contains(PSModelStateBase pSModelStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelStateBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelStateBase.isCreateManDirty();
            }
            case 2: {
                return pSModelStateBase.isMemoDirty();
            }
            case 3: {
                return pSModelStateBase.isPSModelIdDirty();
            }
            case 4: {
                return pSModelStateBase.isPSModelNameDirty();
            }
            case 5: {
                return pSModelStateBase.isPSModelStateIdDirty();
            }
            case 6: {
                return pSModelStateBase.isPSModelStateNameDirty();
            }
            case 7: {
                return pSModelStateBase.isStateDescDirty();
            }
            case 8: {
                return pSModelStateBase.isStateValueDirty();
            }
            case 9: {
                return pSModelStateBase.isUpdateDateDirty();
            }
            case 10: {
                return pSModelStateBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelStateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelStateBase pSModelStateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelStateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelStateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelStateBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelStateBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelStateBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelStateBase.getPSModelStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelstateid", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getPSModelStateId()), (boolean)false);
        }
        if (bl || pSModelStateBase.getPSModelStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelstatename", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getPSModelStateName()), (boolean)false);
        }
        if (bl || pSModelStateBase.getStateDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statedesc", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getStateDesc()), (boolean)false);
        }
        if (bl || pSModelStateBase.getStateValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statevalue", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getStateValue()), (boolean)false);
        }
        if (bl || pSModelStateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelStateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelStateBase.getJSONValue((Object)pSModelStateBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelStateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelStateBase pSModelStateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelStateBase.getCreateDate() != null) {
            object = pSModelStateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelStateBase.getCreateMan() != null) {
            object = pSModelStateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelStateBase.getMemo() != null) {
            object = pSModelStateBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelStateBase.getPSModelId() != null) {
            object = pSModelStateBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelStateBase.getPSModelName() != null) {
            object = pSModelStateBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelStateBase.getPSModelStateId() != null) {
            object = pSModelStateBase.getPSModelStateId();
            xmlNode.setAttribute(FIELD_PSMODELSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelStateBase.getPSModelStateName() != null) {
            object = pSModelStateBase.getPSModelStateName();
            xmlNode.setAttribute(FIELD_PSMODELSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelStateBase.getStateDesc() != null) {
            object = pSModelStateBase.getStateDesc();
            xmlNode.setAttribute(FIELD_STATEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelStateBase.getStateValue() != null) {
            object = pSModelStateBase.getStateValue();
            xmlNode.setAttribute(FIELD_STATEVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelStateBase.getUpdateDate() != null) {
            object = pSModelStateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelStateBase.getUpdateMan() != null) {
            object = pSModelStateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelStateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelStateBase pSModelStateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelStateBase.isCreateDateDirty() && (bl || pSModelStateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelStateBase.getCreateDate());
        }
        if (pSModelStateBase.isCreateManDirty() && (bl || pSModelStateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelStateBase.getCreateMan());
        }
        if (pSModelStateBase.isMemoDirty() && (bl || pSModelStateBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelStateBase.getMemo());
        }
        if (pSModelStateBase.isPSModelIdDirty() && (bl || pSModelStateBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelStateBase.getPSModelId());
        }
        if (pSModelStateBase.isPSModelNameDirty() && (bl || pSModelStateBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelStateBase.getPSModelName());
        }
        if (pSModelStateBase.isPSModelStateIdDirty() && (bl || pSModelStateBase.getPSModelStateId() != null)) {
            iDataObject.set(FIELD_PSMODELSTATEID, (Object)pSModelStateBase.getPSModelStateId());
        }
        if (pSModelStateBase.isPSModelStateNameDirty() && (bl || pSModelStateBase.getPSModelStateName() != null)) {
            iDataObject.set(FIELD_PSMODELSTATENAME, (Object)pSModelStateBase.getPSModelStateName());
        }
        if (pSModelStateBase.isStateDescDirty() && (bl || pSModelStateBase.getStateDesc() != null)) {
            iDataObject.set(FIELD_STATEDESC, (Object)pSModelStateBase.getStateDesc());
        }
        if (pSModelStateBase.isStateValueDirty() && (bl || pSModelStateBase.getStateValue() != null)) {
            iDataObject.set(FIELD_STATEVALUE, (Object)pSModelStateBase.getStateValue());
        }
        if (pSModelStateBase.isUpdateDateDirty() && (bl || pSModelStateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelStateBase.getUpdateDate());
        }
        if (pSModelStateBase.isUpdateManDirty() && (bl || pSModelStateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelStateBase.getUpdateMan());
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
        return PSModelStateBase.remove(this, n);
    }

    private static boolean remove(PSModelStateBase pSModelStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelStateBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelStateBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelStateBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelStateBase.resetPSModelId();
                return true;
            }
            case 4: {
                pSModelStateBase.resetPSModelName();
                return true;
            }
            case 5: {
                pSModelStateBase.resetPSModelStateId();
                return true;
            }
            case 6: {
                pSModelStateBase.resetPSModelStateName();
                return true;
            }
            case 7: {
                pSModelStateBase.resetStateDesc();
                return true;
            }
            case 8: {
                pSModelStateBase.resetStateValue();
                return true;
            }
            case 9: {
                pSModelStateBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSModelStateBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelStateBase getProxyEntity() {
        return this.proxyPSModelStateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelStateBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelStateBase) {
            this.proxyPSModelStateBase = (PSModelStateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelStateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSMODELID, 3);
        fieldIndexMap.put(FIELD_PSMODELNAME, 4);
        fieldIndexMap.put(FIELD_PSMODELSTATEID, 5);
        fieldIndexMap.put(FIELD_PSMODELSTATENAME, 6);
        fieldIndexMap.put(FIELD_STATEDESC, 7);
        fieldIndexMap.put(FIELD_STATEVALUE, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

