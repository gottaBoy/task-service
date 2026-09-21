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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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

public abstract class PSModelSummaryTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelSummaryTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELDEID = "MODELDEID";
    public static final String FIELD_PSMODELSUMMARYTEMPLID = "PSMODELSUMMARYTEMPLID";
    public static final String FIELD_PSMODELSUMMARYTEMPLNAME = "PSMODELSUMMARYTEMPLNAME";
    public static final String FIELD_TEMPLCONTENT = "TEMPLCONTENT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_MODELDEID = 3;
    private static final int INDEX_PSMODELSUMMARYTEMPLID = 4;
    private static final int INDEX_PSMODELSUMMARYTEMPLNAME = 5;
    private static final int INDEX_TEMPLCONTENT = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelSummaryTemplBase proxyPSModelSummaryTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modeldeidDirtyFlag = false;
    private boolean psmodelsummarytemplidDirtyFlag = false;
    private boolean psmodelsummarytemplnameDirtyFlag = false;
    private boolean templcontentDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="modeldeid")
    private String modeldeid;
    @Column(name="psmodelsummarytemplid")
    private String psmodelsummarytemplid;
    @Column(name="psmodelsummarytemplname")
    private String psmodelsummarytemplname;
    @Column(name="templcontent")
    private String templcontent;
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

    public void setModelDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeldeid = string;
        this.modeldeidDirtyFlag = true;
    }

    public String getModelDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelDEId();
        }
        return this.modeldeid;
    }

    public boolean isModelDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelDEIdDirty();
        }
        return this.modeldeidDirtyFlag;
    }

    public void resetModelDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelDEId();
            return;
        }
        this.modeldeidDirtyFlag = false;
        this.modeldeid = null;
    }

    public void setPSModelSummaryTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSummaryTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsummarytemplid = string;
        this.psmodelsummarytemplidDirtyFlag = true;
    }

    public String getPSModelSummaryTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSummaryTemplId();
        }
        return this.psmodelsummarytemplid;
    }

    public boolean isPSModelSummaryTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSummaryTemplIdDirty();
        }
        return this.psmodelsummarytemplidDirtyFlag;
    }

    public void resetPSModelSummaryTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSummaryTemplId();
            return;
        }
        this.psmodelsummarytemplidDirtyFlag = false;
        this.psmodelsummarytemplid = null;
    }

    public void setPSModelSummaryTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSummaryTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsummarytemplname = string;
        this.psmodelsummarytemplnameDirtyFlag = true;
    }

    public String getPSModelSummaryTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSummaryTemplName();
        }
        return this.psmodelsummarytemplname;
    }

    public boolean isPSModelSummaryTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSummaryTemplNameDirty();
        }
        return this.psmodelsummarytemplnameDirtyFlag;
    }

    public void resetPSModelSummaryTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSummaryTemplName();
            return;
        }
        this.psmodelsummarytemplnameDirtyFlag = false;
        this.psmodelsummarytemplname = null;
    }

    public void setTemplContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcontent = string;
        this.templcontentDirtyFlag = true;
    }

    public String getTemplContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplContent();
        }
        return this.templcontent;
    }

    public boolean isTemplContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplContentDirty();
        }
        return this.templcontentDirtyFlag;
    }

    public void resetTemplContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplContent();
            return;
        }
        this.templcontentDirtyFlag = false;
        this.templcontent = null;
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
        PSModelSummaryTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelSummaryTemplBase pSModelSummaryTemplBase) {
        pSModelSummaryTemplBase.resetCreateDate();
        pSModelSummaryTemplBase.resetCreateMan();
        pSModelSummaryTemplBase.resetMemo();
        pSModelSummaryTemplBase.resetModelDEId();
        pSModelSummaryTemplBase.resetPSModelSummaryTemplId();
        pSModelSummaryTemplBase.resetPSModelSummaryTemplName();
        pSModelSummaryTemplBase.resetTemplContent();
        pSModelSummaryTemplBase.resetUpdateDate();
        pSModelSummaryTemplBase.resetUpdateMan();
        pSModelSummaryTemplBase.resetValidFlag();
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
        if (!bl || this.isModelDEIdDirty()) {
            hashMap.put(FIELD_MODELDEID, this.getModelDEId());
        }
        if (!bl || this.isPSModelSummaryTemplIdDirty()) {
            hashMap.put(FIELD_PSMODELSUMMARYTEMPLID, this.getPSModelSummaryTemplId());
        }
        if (!bl || this.isPSModelSummaryTemplNameDirty()) {
            hashMap.put(FIELD_PSMODELSUMMARYTEMPLNAME, this.getPSModelSummaryTemplName());
        }
        if (!bl || this.isTemplContentDirty()) {
            hashMap.put(FIELD_TEMPLCONTENT, this.getTemplContent());
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
        return PSModelSummaryTemplBase.get(this, n);
    }

    private static Object get(PSModelSummaryTemplBase pSModelSummaryTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSummaryTemplBase.getCreateDate();
            }
            case 1: {
                return pSModelSummaryTemplBase.getCreateMan();
            }
            case 2: {
                return pSModelSummaryTemplBase.getMemo();
            }
            case 3: {
                return pSModelSummaryTemplBase.getModelDEId();
            }
            case 4: {
                return pSModelSummaryTemplBase.getPSModelSummaryTemplId();
            }
            case 5: {
                return pSModelSummaryTemplBase.getPSModelSummaryTemplName();
            }
            case 6: {
                return pSModelSummaryTemplBase.getTemplContent();
            }
            case 7: {
                return pSModelSummaryTemplBase.getUpdateDate();
            }
            case 8: {
                return pSModelSummaryTemplBase.getUpdateMan();
            }
            case 9: {
                return pSModelSummaryTemplBase.getValidFlag();
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
        PSModelSummaryTemplBase.set(this, n, object);
    }

    private static void set(PSModelSummaryTemplBase pSModelSummaryTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelSummaryTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelSummaryTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelSummaryTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelSummaryTemplBase.setModelDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelSummaryTemplBase.setPSModelSummaryTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelSummaryTemplBase.setPSModelSummaryTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelSummaryTemplBase.setTemplContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelSummaryTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSModelSummaryTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelSummaryTemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelSummaryTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSModelSummaryTemplBase pSModelSummaryTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSummaryTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelSummaryTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelSummaryTemplBase.getMemo() == null;
            }
            case 3: {
                return pSModelSummaryTemplBase.getModelDEId() == null;
            }
            case 4: {
                return pSModelSummaryTemplBase.getPSModelSummaryTemplId() == null;
            }
            case 5: {
                return pSModelSummaryTemplBase.getPSModelSummaryTemplName() == null;
            }
            case 6: {
                return pSModelSummaryTemplBase.getTemplContent() == null;
            }
            case 7: {
                return pSModelSummaryTemplBase.getUpdateDate() == null;
            }
            case 8: {
                return pSModelSummaryTemplBase.getUpdateMan() == null;
            }
            case 9: {
                return pSModelSummaryTemplBase.getValidFlag() == null;
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
        return PSModelSummaryTemplBase.contains(this, n);
    }

    private static boolean contains(PSModelSummaryTemplBase pSModelSummaryTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSummaryTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelSummaryTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSModelSummaryTemplBase.isMemoDirty();
            }
            case 3: {
                return pSModelSummaryTemplBase.isModelDEIdDirty();
            }
            case 4: {
                return pSModelSummaryTemplBase.isPSModelSummaryTemplIdDirty();
            }
            case 5: {
                return pSModelSummaryTemplBase.isPSModelSummaryTemplNameDirty();
            }
            case 6: {
                return pSModelSummaryTemplBase.isTemplContentDirty();
            }
            case 7: {
                return pSModelSummaryTemplBase.isUpdateDateDirty();
            }
            case 8: {
                return pSModelSummaryTemplBase.isUpdateManDirty();
            }
            case 9: {
                return pSModelSummaryTemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelSummaryTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelSummaryTemplBase pSModelSummaryTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelSummaryTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getModelDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeldeid", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getModelDEId()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getPSModelSummaryTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsummarytemplid", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getPSModelSummaryTemplId()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getPSModelSummaryTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsummarytemplname", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getPSModelSummaryTemplName()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getTemplContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcontent", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getTemplContent()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelSummaryTemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelSummaryTemplBase.getJSONValue((Object)pSModelSummaryTemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelSummaryTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelSummaryTemplBase pSModelSummaryTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelSummaryTemplBase.getCreateDate() != null) {
            object = pSModelSummaryTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSummaryTemplBase.getCreateMan() != null) {
            object = pSModelSummaryTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSummaryTemplBase.getMemo() != null) {
            object = pSModelSummaryTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelSummaryTemplBase.getModelDEId() != null) {
            object = pSModelSummaryTemplBase.getModelDEId();
            xmlNode.setAttribute(FIELD_MODELDEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSummaryTemplBase.getPSModelSummaryTemplId() != null) {
            object = pSModelSummaryTemplBase.getPSModelSummaryTemplId();
            xmlNode.setAttribute(FIELD_PSMODELSUMMARYTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSummaryTemplBase.getPSModelSummaryTemplName() != null) {
            object = pSModelSummaryTemplBase.getPSModelSummaryTemplName();
            xmlNode.setAttribute(FIELD_PSMODELSUMMARYTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSummaryTemplBase.getTemplContent() != null) {
            object = pSModelSummaryTemplBase.getTemplContent();
            xmlNode.setAttribute(FIELD_TEMPLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelSummaryTemplBase.getUpdateDate() != null) {
            object = pSModelSummaryTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSummaryTemplBase.getUpdateMan() != null) {
            object = pSModelSummaryTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSummaryTemplBase.getValidFlag() != null) {
            object = pSModelSummaryTemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelSummaryTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelSummaryTemplBase pSModelSummaryTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelSummaryTemplBase.isCreateDateDirty() && (bl || pSModelSummaryTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelSummaryTemplBase.getCreateDate());
        }
        if (pSModelSummaryTemplBase.isCreateManDirty() && (bl || pSModelSummaryTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelSummaryTemplBase.getCreateMan());
        }
        if (pSModelSummaryTemplBase.isMemoDirty() && (bl || pSModelSummaryTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelSummaryTemplBase.getMemo());
        }
        if (pSModelSummaryTemplBase.isModelDEIdDirty() && (bl || pSModelSummaryTemplBase.getModelDEId() != null)) {
            iDataObject.set(FIELD_MODELDEID, (Object)pSModelSummaryTemplBase.getModelDEId());
        }
        if (pSModelSummaryTemplBase.isPSModelSummaryTemplIdDirty() && (bl || pSModelSummaryTemplBase.getPSModelSummaryTemplId() != null)) {
            iDataObject.set(FIELD_PSMODELSUMMARYTEMPLID, (Object)pSModelSummaryTemplBase.getPSModelSummaryTemplId());
        }
        if (pSModelSummaryTemplBase.isPSModelSummaryTemplNameDirty() && (bl || pSModelSummaryTemplBase.getPSModelSummaryTemplName() != null)) {
            iDataObject.set(FIELD_PSMODELSUMMARYTEMPLNAME, (Object)pSModelSummaryTemplBase.getPSModelSummaryTemplName());
        }
        if (pSModelSummaryTemplBase.isTemplContentDirty() && (bl || pSModelSummaryTemplBase.getTemplContent() != null)) {
            iDataObject.set(FIELD_TEMPLCONTENT, (Object)pSModelSummaryTemplBase.getTemplContent());
        }
        if (pSModelSummaryTemplBase.isUpdateDateDirty() && (bl || pSModelSummaryTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelSummaryTemplBase.getUpdateDate());
        }
        if (pSModelSummaryTemplBase.isUpdateManDirty() && (bl || pSModelSummaryTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelSummaryTemplBase.getUpdateMan());
        }
        if (pSModelSummaryTemplBase.isValidFlagDirty() && (bl || pSModelSummaryTemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelSummaryTemplBase.getValidFlag());
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
        return PSModelSummaryTemplBase.remove(this, n);
    }

    private static boolean remove(PSModelSummaryTemplBase pSModelSummaryTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelSummaryTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelSummaryTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelSummaryTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelSummaryTemplBase.resetModelDEId();
                return true;
            }
            case 4: {
                pSModelSummaryTemplBase.resetPSModelSummaryTemplId();
                return true;
            }
            case 5: {
                pSModelSummaryTemplBase.resetPSModelSummaryTemplName();
                return true;
            }
            case 6: {
                pSModelSummaryTemplBase.resetTemplContent();
                return true;
            }
            case 7: {
                pSModelSummaryTemplBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSModelSummaryTemplBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSModelSummaryTemplBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelSummaryTemplBase getProxyEntity() {
        return this.proxyPSModelSummaryTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelSummaryTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelSummaryTemplBase) {
            this.proxyPSModelSummaryTemplBase = (PSModelSummaryTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSModelSummaryTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_MODELDEID, 3);
        fieldIndexMap.put(FIELD_PSMODELSUMMARYTEMPLID, 4);
        fieldIndexMap.put(FIELD_PSMODELSUMMARYTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_TEMPLCONTENT, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

