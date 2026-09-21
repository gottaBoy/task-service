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

public abstract class PSSysLanResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysLanResBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LANRESTYPE = "LANRESTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSLANRESID = "PSSYSLANRESID";
    public static final String FIELD_PSSYSLANRESNAME = "PSSYSLANRESNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LANRESTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSSYSLANRESID = 5;
    private static final int INDEX_PSSYSLANRESNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USERDATA = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysLanResBase proxyPSSysLanResBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lanrestypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssyslanresidDirtyFlag = false;
    private boolean pssyslanresnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lanrestype")
    private String lanrestype;
    @Column(name="memo")
    private String memo;
    @Column(name="pssyslanresid")
    private String pssyslanresid;
    @Column(name="pssyslanresname")
    private String pssyslanresname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="validflag")
    private Integer validflag;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setLanResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lanrestype = string;
        this.lanrestypeDirtyFlag = true;
    }

    public String getLanResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanResType();
        }
        return this.lanrestype;
    }

    public boolean isLanResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanResTypeDirty();
        }
        return this.lanrestypeDirtyFlag;
    }

    public void resetLanResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanResType();
            return;
        }
        this.lanrestypeDirtyFlag = false;
        this.lanrestype = null;
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

    public void setPSSysLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanresid = string;
        this.pssyslanresidDirtyFlag = true;
    }

    public String getPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanResId();
        }
        return this.pssyslanresid;
    }

    public boolean isPSSysLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanResIdDirty();
        }
        return this.pssyslanresidDirtyFlag;
    }

    public void resetPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanResId();
            return;
        }
        this.pssyslanresidDirtyFlag = false;
        this.pssyslanresid = null;
    }

    public void setPSSysLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanresname = string;
        this.pssyslanresnameDirtyFlag = true;
    }

    public String getPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanResName();
        }
        return this.pssyslanresname;
    }

    public boolean isPSSysLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanResNameDirty();
        }
        return this.pssyslanresnameDirtyFlag;
    }

    public void resetPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanResName();
            return;
        }
        this.pssyslanresnameDirtyFlag = false;
        this.pssyslanresname = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
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
        PSSysLanResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysLanResBase pSSysLanResBase) {
        pSSysLanResBase.resetContent();
        pSSysLanResBase.resetCreateDate();
        pSSysLanResBase.resetCreateMan();
        pSSysLanResBase.resetLanResType();
        pSSysLanResBase.resetMemo();
        pSSysLanResBase.resetPSSysLanResId();
        pSSysLanResBase.resetPSSysLanResName();
        pSSysLanResBase.resetUpdateDate();
        pSSysLanResBase.resetUpdateMan();
        pSSysLanResBase.resetUserData();
        pSSysLanResBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLanResTypeDirty()) {
            hashMap.put(FIELD_LANRESTYPE, this.getLanResType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysLanResIdDirty()) {
            hashMap.put(FIELD_PSSYSLANRESID, this.getPSSysLanResId());
        }
        if (!bl || this.isPSSysLanResNameDirty()) {
            hashMap.put(FIELD_PSSYSLANRESNAME, this.getPSSysLanResName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
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
        return PSSysLanResBase.get(this, n);
    }

    private static Object get(PSSysLanResBase pSSysLanResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysLanResBase.getContent();
            }
            case 1: {
                return pSSysLanResBase.getCreateDate();
            }
            case 2: {
                return pSSysLanResBase.getCreateMan();
            }
            case 3: {
                return pSSysLanResBase.getLanResType();
            }
            case 4: {
                return pSSysLanResBase.getMemo();
            }
            case 5: {
                return pSSysLanResBase.getPSSysLanResId();
            }
            case 6: {
                return pSSysLanResBase.getPSSysLanResName();
            }
            case 7: {
                return pSSysLanResBase.getUpdateDate();
            }
            case 8: {
                return pSSysLanResBase.getUpdateMan();
            }
            case 9: {
                return pSSysLanResBase.getUserData();
            }
            case 10: {
                return pSSysLanResBase.getValidFlag();
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
        PSSysLanResBase.set(this, n, object);
    }

    private static void set(PSSysLanResBase pSSysLanResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysLanResBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysLanResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysLanResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysLanResBase.setLanResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysLanResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysLanResBase.setPSSysLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysLanResBase.setPSSysLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysLanResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysLanResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysLanResBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysLanResBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysLanResBase.isNull(this, n);
    }

    private static boolean isNull(PSSysLanResBase pSSysLanResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysLanResBase.getContent() == null;
            }
            case 1: {
                return pSSysLanResBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysLanResBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysLanResBase.getLanResType() == null;
            }
            case 4: {
                return pSSysLanResBase.getMemo() == null;
            }
            case 5: {
                return pSSysLanResBase.getPSSysLanResId() == null;
            }
            case 6: {
                return pSSysLanResBase.getPSSysLanResName() == null;
            }
            case 7: {
                return pSSysLanResBase.getUpdateDate() == null;
            }
            case 8: {
                return pSSysLanResBase.getUpdateMan() == null;
            }
            case 9: {
                return pSSysLanResBase.getUserData() == null;
            }
            case 10: {
                return pSSysLanResBase.getValidFlag() == null;
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
        return PSSysLanResBase.contains(this, n);
    }

    private static boolean contains(PSSysLanResBase pSSysLanResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysLanResBase.isContentDirty();
            }
            case 1: {
                return pSSysLanResBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysLanResBase.isCreateManDirty();
            }
            case 3: {
                return pSSysLanResBase.isLanResTypeDirty();
            }
            case 4: {
                return pSSysLanResBase.isMemoDirty();
            }
            case 5: {
                return pSSysLanResBase.isPSSysLanResIdDirty();
            }
            case 6: {
                return pSSysLanResBase.isPSSysLanResNameDirty();
            }
            case 7: {
                return pSSysLanResBase.isUpdateDateDirty();
            }
            case 8: {
                return pSSysLanResBase.isUpdateManDirty();
            }
            case 9: {
                return pSSysLanResBase.isUserDataDirty();
            }
            case 10: {
                return pSSysLanResBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysLanResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysLanResBase pSSysLanResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysLanResBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getContent()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getLanResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanrestype", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getLanResType()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getPSSysLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanresid", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getPSSysLanResId()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getPSSysLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanresname", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getPSSysLanResName()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getUserData()), (boolean)false);
        }
        if (bl || pSSysLanResBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysLanResBase.getJSONValue((Object)pSSysLanResBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysLanResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysLanResBase pSSysLanResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysLanResBase.getContent() != null) {
            object = pSSysLanResBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getCreateDate() != null) {
            object = pSSysLanResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysLanResBase.getCreateMan() != null) {
            object = pSSysLanResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getLanResType() != null) {
            object = pSSysLanResBase.getLanResType();
            xmlNode.setAttribute(FIELD_LANRESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getMemo() != null) {
            object = pSSysLanResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getPSSysLanResId() != null) {
            object = pSSysLanResBase.getPSSysLanResId();
            xmlNode.setAttribute(FIELD_PSSYSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getPSSysLanResName() != null) {
            object = pSSysLanResBase.getPSSysLanResName();
            xmlNode.setAttribute(FIELD_PSSYSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getUpdateDate() != null) {
            object = pSSysLanResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysLanResBase.getUpdateMan() != null) {
            object = pSSysLanResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getUserData() != null) {
            object = pSSysLanResBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysLanResBase.getValidFlag() != null) {
            object = pSSysLanResBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysLanResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysLanResBase pSSysLanResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysLanResBase.isContentDirty() && (bl || pSSysLanResBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysLanResBase.getContent());
        }
        if (pSSysLanResBase.isCreateDateDirty() && (bl || pSSysLanResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysLanResBase.getCreateDate());
        }
        if (pSSysLanResBase.isCreateManDirty() && (bl || pSSysLanResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysLanResBase.getCreateMan());
        }
        if (pSSysLanResBase.isLanResTypeDirty() && (bl || pSSysLanResBase.getLanResType() != null)) {
            iDataObject.set(FIELD_LANRESTYPE, (Object)pSSysLanResBase.getLanResType());
        }
        if (pSSysLanResBase.isMemoDirty() && (bl || pSSysLanResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysLanResBase.getMemo());
        }
        if (pSSysLanResBase.isPSSysLanResIdDirty() && (bl || pSSysLanResBase.getPSSysLanResId() != null)) {
            iDataObject.set(FIELD_PSSYSLANRESID, (Object)pSSysLanResBase.getPSSysLanResId());
        }
        if (pSSysLanResBase.isPSSysLanResNameDirty() && (bl || pSSysLanResBase.getPSSysLanResName() != null)) {
            iDataObject.set(FIELD_PSSYSLANRESNAME, (Object)pSSysLanResBase.getPSSysLanResName());
        }
        if (pSSysLanResBase.isUpdateDateDirty() && (bl || pSSysLanResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysLanResBase.getUpdateDate());
        }
        if (pSSysLanResBase.isUpdateManDirty() && (bl || pSSysLanResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysLanResBase.getUpdateMan());
        }
        if (pSSysLanResBase.isUserDataDirty() && (bl || pSSysLanResBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSSysLanResBase.getUserData());
        }
        if (pSSysLanResBase.isValidFlagDirty() && (bl || pSSysLanResBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysLanResBase.getValidFlag());
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
        return PSSysLanResBase.remove(this, n);
    }

    private static boolean remove(PSSysLanResBase pSSysLanResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysLanResBase.resetContent();
                return true;
            }
            case 1: {
                pSSysLanResBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysLanResBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysLanResBase.resetLanResType();
                return true;
            }
            case 4: {
                pSSysLanResBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysLanResBase.resetPSSysLanResId();
                return true;
            }
            case 6: {
                pSSysLanResBase.resetPSSysLanResName();
                return true;
            }
            case 7: {
                pSSysLanResBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSSysLanResBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSSysLanResBase.resetUserData();
                return true;
            }
            case 10: {
                pSSysLanResBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysLanResBase getProxyEntity() {
        return this.proxyPSSysLanResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysLanResBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysLanResBase) {
            this.proxyPSSysLanResBase = (PSSysLanResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysLanResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LANRESTYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSSYSLANRESID, 5);
        fieldIndexMap.put(FIELD_PSSYSLANRESNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USERDATA, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

