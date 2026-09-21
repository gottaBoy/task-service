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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStyleCodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFSTYLECODEID = "PSSFSTYLECODEID";
    public static final String FIELD_PSSFSTYLECODENAME = "PSSFSTYLECODENAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_STYLECODE = "STYLECODE";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSFSTYLECODEID = 3;
    private static final int INDEX_PSSFSTYLECODENAME = 4;
    private static final int INDEX_PSSFSTYLEID = 5;
    private static final int INDEX_PSSFSTYLENAME = 6;
    private static final int INDEX_STYLECODE = 7;
    private static final int INDEX_TEMPLDESC = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStyleCodeBase proxyPSSFStyleCodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfstylecodeidDirtyFlag = false;
    private boolean pssfstylecodenameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean stylecodeDirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfstylecodeid")
    private String pssfstylecodeid;
    @Column(name="pssfstylecodename")
    private String pssfstylecodename;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="stylecode")
    private String stylecode;
    @Column(name="templdesc")
    private String templdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;

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

    public void setPSSFStyleCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylecodeid = string;
        this.pssfstylecodeidDirtyFlag = true;
    }

    public String getPSSFStyleCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleCodeId();
        }
        return this.pssfstylecodeid;
    }

    public boolean isPSSFStyleCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleCodeIdDirty();
        }
        return this.pssfstylecodeidDirtyFlag;
    }

    public void resetPSSFStyleCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleCodeId();
            return;
        }
        this.pssfstylecodeidDirtyFlag = false;
        this.pssfstylecodeid = null;
    }

    public void setPSSFStyleCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylecodename = string;
        this.pssfstylecodenameDirtyFlag = true;
    }

    public String getPSSFStyleCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleCodeName();
        }
        return this.pssfstylecodename;
    }

    public boolean isPSSFStyleCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleCodeNameDirty();
        }
        return this.pssfstylecodenameDirtyFlag;
    }

    public void resetPSSFStyleCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleCodeName();
            return;
        }
        this.pssfstylecodenameDirtyFlag = false;
        this.pssfstylecodename = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setStyleCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stylecode = string;
        this.stylecodeDirtyFlag = true;
    }

    public String getStyleCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleCode();
        }
        return this.stylecode;
    }

    public boolean isStyleCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleCodeDirty();
        }
        return this.stylecodeDirtyFlag;
    }

    public void resetStyleCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleCode();
            return;
        }
        this.stylecodeDirtyFlag = false;
        this.stylecode = null;
    }

    public void setTemplDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templdesc = string;
        this.templdescDirtyFlag = true;
    }

    public String getTemplDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplDesc();
        }
        return this.templdesc;
    }

    public boolean isTemplDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplDescDirty();
        }
        return this.templdescDirtyFlag;
    }

    public void resetTemplDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplDesc();
            return;
        }
        this.templdescDirtyFlag = false;
        this.templdesc = null;
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
        PSSFStyleCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStyleCodeBase pSSFStyleCodeBase) {
        pSSFStyleCodeBase.resetCreateDate();
        pSSFStyleCodeBase.resetCreateMan();
        pSSFStyleCodeBase.resetMemo();
        pSSFStyleCodeBase.resetPSSFStyleCodeId();
        pSSFStyleCodeBase.resetPSSFStyleCodeName();
        pSSFStyleCodeBase.resetPSSFStyleId();
        pSSFStyleCodeBase.resetPSSFStyleName();
        pSSFStyleCodeBase.resetStyleCode();
        pSSFStyleCodeBase.resetTemplDesc();
        pSSFStyleCodeBase.resetUpdateDate();
        pSSFStyleCodeBase.resetUpdateMan();
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
        if (!bl || this.isPSSFStyleCodeIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLECODEID, this.getPSSFStyleCodeId());
        }
        if (!bl || this.isPSSFStyleCodeNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLECODENAME, this.getPSSFStyleCodeName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isStyleCodeDirty()) {
            hashMap.put(FIELD_STYLECODE, this.getStyleCode());
        }
        if (!bl || this.isTemplDescDirty()) {
            hashMap.put(FIELD_TEMPLDESC, this.getTemplDesc());
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
        return PSSFStyleCodeBase.get(this, n);
    }

    private static Object get(PSSFStyleCodeBase pSSFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleCodeBase.getCreateDate();
            }
            case 1: {
                return pSSFStyleCodeBase.getCreateMan();
            }
            case 2: {
                return pSSFStyleCodeBase.getMemo();
            }
            case 3: {
                return pSSFStyleCodeBase.getPSSFStyleCodeId();
            }
            case 4: {
                return pSSFStyleCodeBase.getPSSFStyleCodeName();
            }
            case 5: {
                return pSSFStyleCodeBase.getPSSFStyleId();
            }
            case 6: {
                return pSSFStyleCodeBase.getPSSFStyleName();
            }
            case 7: {
                return pSSFStyleCodeBase.getStyleCode();
            }
            case 8: {
                return pSSFStyleCodeBase.getTemplDesc();
            }
            case 9: {
                return pSSFStyleCodeBase.getUpdateDate();
            }
            case 10: {
                return pSSFStyleCodeBase.getUpdateMan();
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
        PSSFStyleCodeBase.set(this, n, object);
    }

    private static void set(PSSFStyleCodeBase pSSFStyleCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFStyleCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFStyleCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFStyleCodeBase.setPSSFStyleCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFStyleCodeBase.setPSSFStyleCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFStyleCodeBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFStyleCodeBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFStyleCodeBase.setStyleCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFStyleCodeBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFStyleCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSFStyleCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFStyleCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStyleCodeBase pSSFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleCodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFStyleCodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFStyleCodeBase.getMemo() == null;
            }
            case 3: {
                return pSSFStyleCodeBase.getPSSFStyleCodeId() == null;
            }
            case 4: {
                return pSSFStyleCodeBase.getPSSFStyleCodeName() == null;
            }
            case 5: {
                return pSSFStyleCodeBase.getPSSFStyleId() == null;
            }
            case 6: {
                return pSSFStyleCodeBase.getPSSFStyleName() == null;
            }
            case 7: {
                return pSSFStyleCodeBase.getStyleCode() == null;
            }
            case 8: {
                return pSSFStyleCodeBase.getTemplDesc() == null;
            }
            case 9: {
                return pSSFStyleCodeBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSFStyleCodeBase.getUpdateMan() == null;
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
        return PSSFStyleCodeBase.contains(this, n);
    }

    private static boolean contains(PSSFStyleCodeBase pSSFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleCodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFStyleCodeBase.isCreateManDirty();
            }
            case 2: {
                return pSSFStyleCodeBase.isMemoDirty();
            }
            case 3: {
                return pSSFStyleCodeBase.isPSSFStyleCodeIdDirty();
            }
            case 4: {
                return pSSFStyleCodeBase.isPSSFStyleCodeNameDirty();
            }
            case 5: {
                return pSSFStyleCodeBase.isPSSFStyleIdDirty();
            }
            case 6: {
                return pSSFStyleCodeBase.isPSSFStyleNameDirty();
            }
            case 7: {
                return pSSFStyleCodeBase.isStyleCodeDirty();
            }
            case 8: {
                return pSSFStyleCodeBase.isTemplDescDirty();
            }
            case 9: {
                return pSSFStyleCodeBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSFStyleCodeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStyleCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStyleCodeBase pSSFStyleCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStyleCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylecodeid", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getPSSFStyleCodeId()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylecodename", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getPSSFStyleCodeName()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getStyleCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stylecode", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getStyleCode()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStyleCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStyleCodeBase.getJSONValue((Object)pSSFStyleCodeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStyleCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStyleCodeBase pSSFStyleCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStyleCodeBase.getCreateDate() != null) {
            object = pSSFStyleCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleCodeBase.getCreateMan() != null) {
            object = pSSFStyleCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getMemo() != null) {
            object = pSSFStyleCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleCodeId() != null) {
            object = pSSFStyleCodeBase.getPSSFStyleCodeId();
            xmlNode.setAttribute(FIELD_PSSFSTYLECODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleCodeName() != null) {
            object = pSSFStyleCodeBase.getPSSFStyleCodeName();
            xmlNode.setAttribute(FIELD_PSSFSTYLECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleId() != null) {
            object = pSSFStyleCodeBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getPSSFStyleName() != null) {
            object = pSSFStyleCodeBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getStyleCode() != null) {
            object = pSSFStyleCodeBase.getStyleCode();
            xmlNode.setAttribute(FIELD_STYLECODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getTemplDesc() != null) {
            object = pSSFStyleCodeBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleCodeBase.getUpdateDate() != null) {
            object = pSSFStyleCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleCodeBase.getUpdateMan() != null) {
            object = pSSFStyleCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStyleCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStyleCodeBase pSSFStyleCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStyleCodeBase.isCreateDateDirty() && (bl || pSSFStyleCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStyleCodeBase.getCreateDate());
        }
        if (pSSFStyleCodeBase.isCreateManDirty() && (bl || pSSFStyleCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStyleCodeBase.getCreateMan());
        }
        if (pSSFStyleCodeBase.isMemoDirty() && (bl || pSSFStyleCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFStyleCodeBase.getMemo());
        }
        if (pSSFStyleCodeBase.isPSSFStyleCodeIdDirty() && (bl || pSSFStyleCodeBase.getPSSFStyleCodeId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLECODEID, (Object)pSSFStyleCodeBase.getPSSFStyleCodeId());
        }
        if (pSSFStyleCodeBase.isPSSFStyleCodeNameDirty() && (bl || pSSFStyleCodeBase.getPSSFStyleCodeName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLECODENAME, (Object)pSSFStyleCodeBase.getPSSFStyleCodeName());
        }
        if (pSSFStyleCodeBase.isPSSFStyleIdDirty() && (bl || pSSFStyleCodeBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStyleCodeBase.getPSSFStyleId());
        }
        if (pSSFStyleCodeBase.isPSSFStyleNameDirty() && (bl || pSSFStyleCodeBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStyleCodeBase.getPSSFStyleName());
        }
        if (pSSFStyleCodeBase.isStyleCodeDirty() && (bl || pSSFStyleCodeBase.getStyleCode() != null)) {
            iDataObject.set(FIELD_STYLECODE, (Object)pSSFStyleCodeBase.getStyleCode());
        }
        if (pSSFStyleCodeBase.isTemplDescDirty() && (bl || pSSFStyleCodeBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSSFStyleCodeBase.getTemplDesc());
        }
        if (pSSFStyleCodeBase.isUpdateDateDirty() && (bl || pSSFStyleCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStyleCodeBase.getUpdateDate());
        }
        if (pSSFStyleCodeBase.isUpdateManDirty() && (bl || pSSFStyleCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStyleCodeBase.getUpdateMan());
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
        return PSSFStyleCodeBase.remove(this, n);
    }

    private static boolean remove(PSSFStyleCodeBase pSSFStyleCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleCodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFStyleCodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFStyleCodeBase.resetMemo();
                return true;
            }
            case 3: {
                pSSFStyleCodeBase.resetPSSFStyleCodeId();
                return true;
            }
            case 4: {
                pSSFStyleCodeBase.resetPSSFStyleCodeName();
                return true;
            }
            case 5: {
                pSSFStyleCodeBase.resetPSSFStyleId();
                return true;
            }
            case 6: {
                pSSFStyleCodeBase.resetPSSFStyleName();
                return true;
            }
            case 7: {
                pSSFStyleCodeBase.resetStyleCode();
                return true;
            }
            case 8: {
                pSSFStyleCodeBase.resetTemplDesc();
                return true;
            }
            case 9: {
                pSSFStyleCodeBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSFStyleCodeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    private PSSFStyleCodeBase getProxyEntity() {
        return this.proxyPSSFStyleCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStyleCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStyleCodeBase) {
            this.proxyPSSFStyleCodeBase = (PSSFStyleCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSFSTYLECODEID, 3);
        fieldIndexMap.put(FIELD_PSSFSTYLECODENAME, 4);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 5);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 6);
        fieldIndexMap.put(FIELD_STYLECODE, 7);
        fieldIndexMap.put(FIELD_TEMPLDESC, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

