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

public abstract class PSCodeSnippetTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCodeSnippetTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCODESNIPPETTYPEID = "PSCODESNIPPETTYPEID";
    public static final String FIELD_PSCODESNIPPETTYPENAME = "PSCODESNIPPETTYPENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSCODESNIPPETTYPEID = 3;
    private static final int INDEX_PSCODESNIPPETTYPENAME = 4;
    private static final int INDEX_PUBOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCodeSnippetTypeBase proxyPSCodeSnippetTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscodesnippettypeidDirtyFlag = false;
    private boolean pscodesnippettypenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pscodesnippettypeid")
    private String pscodesnippettypeid;
    @Column(name="pscodesnippettypename")
    private String pscodesnippettypename;
    @Column(name="pubobj")
    private String pubobj;
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

    public void setPSCodeSnippetTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeSnippetTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodesnippettypeid = string;
        this.pscodesnippettypeidDirtyFlag = true;
    }

    public String getPSCodeSnippetTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeSnippetTypeId();
        }
        return this.pscodesnippettypeid;
    }

    public boolean isPSCodeSnippetTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeSnippetTypeIdDirty();
        }
        return this.pscodesnippettypeidDirtyFlag;
    }

    public void resetPSCodeSnippetTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeSnippetTypeId();
            return;
        }
        this.pscodesnippettypeidDirtyFlag = false;
        this.pscodesnippettypeid = null;
    }

    public void setPSCodeSnippetTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeSnippetTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodesnippettypename = string;
        this.pscodesnippettypenameDirtyFlag = true;
    }

    public String getPSCodeSnippetTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeSnippetTypeName();
        }
        return this.pscodesnippettypename;
    }

    public boolean isPSCodeSnippetTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeSnippetTypeNameDirty();
        }
        return this.pscodesnippettypenameDirtyFlag;
    }

    public void resetPSCodeSnippetTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeSnippetTypeName();
            return;
        }
        this.pscodesnippettypenameDirtyFlag = false;
        this.pscodesnippettypename = null;
    }

    public void setPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobj = string;
        this.pubobjDirtyFlag = true;
    }

    public String getPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObj();
        }
        return this.pubobj;
    }

    public boolean isPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjDirty();
        }
        return this.pubobjDirtyFlag;
    }

    public void resetPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObj();
            return;
        }
        this.pubobjDirtyFlag = false;
        this.pubobj = null;
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
        PSCodeSnippetTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCodeSnippetTypeBase pSCodeSnippetTypeBase) {
        pSCodeSnippetTypeBase.resetCreateDate();
        pSCodeSnippetTypeBase.resetCreateMan();
        pSCodeSnippetTypeBase.resetMemo();
        pSCodeSnippetTypeBase.resetPSCodeSnippetTypeId();
        pSCodeSnippetTypeBase.resetPSCodeSnippetTypeName();
        pSCodeSnippetTypeBase.resetPubObj();
        pSCodeSnippetTypeBase.resetUpdateDate();
        pSCodeSnippetTypeBase.resetUpdateMan();
        pSCodeSnippetTypeBase.resetValidFlag();
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
        if (!bl || this.isPSCodeSnippetTypeIdDirty()) {
            hashMap.put(FIELD_PSCODESNIPPETTYPEID, this.getPSCodeSnippetTypeId());
        }
        if (!bl || this.isPSCodeSnippetTypeNameDirty()) {
            hashMap.put(FIELD_PSCODESNIPPETTYPENAME, this.getPSCodeSnippetTypeName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
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
        return PSCodeSnippetTypeBase.get(this, n);
    }

    private static Object get(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeSnippetTypeBase.getCreateDate();
            }
            case 1: {
                return pSCodeSnippetTypeBase.getCreateMan();
            }
            case 2: {
                return pSCodeSnippetTypeBase.getMemo();
            }
            case 3: {
                return pSCodeSnippetTypeBase.getPSCodeSnippetTypeId();
            }
            case 4: {
                return pSCodeSnippetTypeBase.getPSCodeSnippetTypeName();
            }
            case 5: {
                return pSCodeSnippetTypeBase.getPubObj();
            }
            case 6: {
                return pSCodeSnippetTypeBase.getUpdateDate();
            }
            case 7: {
                return pSCodeSnippetTypeBase.getUpdateMan();
            }
            case 8: {
                return pSCodeSnippetTypeBase.getValidFlag();
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
        PSCodeSnippetTypeBase.set(this, n, object);
    }

    private static void set(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCodeSnippetTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCodeSnippetTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCodeSnippetTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCodeSnippetTypeBase.setPSCodeSnippetTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCodeSnippetTypeBase.setPSCodeSnippetTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCodeSnippetTypeBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCodeSnippetTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSCodeSnippetTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCodeSnippetTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCodeSnippetTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeSnippetTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSCodeSnippetTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSCodeSnippetTypeBase.getMemo() == null;
            }
            case 3: {
                return pSCodeSnippetTypeBase.getPSCodeSnippetTypeId() == null;
            }
            case 4: {
                return pSCodeSnippetTypeBase.getPSCodeSnippetTypeName() == null;
            }
            case 5: {
                return pSCodeSnippetTypeBase.getPubObj() == null;
            }
            case 6: {
                return pSCodeSnippetTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSCodeSnippetTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSCodeSnippetTypeBase.getValidFlag() == null;
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
        return PSCodeSnippetTypeBase.contains(this, n);
    }

    private static boolean contains(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeSnippetTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSCodeSnippetTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSCodeSnippetTypeBase.isMemoDirty();
            }
            case 3: {
                return pSCodeSnippetTypeBase.isPSCodeSnippetTypeIdDirty();
            }
            case 4: {
                return pSCodeSnippetTypeBase.isPSCodeSnippetTypeNameDirty();
            }
            case 5: {
                return pSCodeSnippetTypeBase.isPubObjDirty();
            }
            case 6: {
                return pSCodeSnippetTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSCodeSnippetTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSCodeSnippetTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCodeSnippetTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCodeSnippetTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getPSCodeSnippetTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodesnippettypeid", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getPSCodeSnippetTypeId()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getPSCodeSnippetTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodesnippettypename", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getPSCodeSnippetTypeName()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getPubObj()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCodeSnippetTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCodeSnippetTypeBase.getJSONValue((Object)pSCodeSnippetTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCodeSnippetTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCodeSnippetTypeBase.getCreateDate() != null) {
            object = pSCodeSnippetTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeSnippetTypeBase.getCreateMan() != null) {
            object = pSCodeSnippetTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeSnippetTypeBase.getMemo() != null) {
            object = pSCodeSnippetTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCodeSnippetTypeBase.getPSCodeSnippetTypeId() != null) {
            object = pSCodeSnippetTypeBase.getPSCodeSnippetTypeId();
            xmlNode.setAttribute(FIELD_PSCODESNIPPETTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeSnippetTypeBase.getPSCodeSnippetTypeName() != null) {
            object = pSCodeSnippetTypeBase.getPSCodeSnippetTypeName();
            xmlNode.setAttribute(FIELD_PSCODESNIPPETTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeSnippetTypeBase.getPubObj() != null) {
            object = pSCodeSnippetTypeBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCodeSnippetTypeBase.getUpdateDate() != null) {
            object = pSCodeSnippetTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeSnippetTypeBase.getUpdateMan() != null) {
            object = pSCodeSnippetTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeSnippetTypeBase.getValidFlag() != null) {
            object = pSCodeSnippetTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCodeSnippetTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCodeSnippetTypeBase.isCreateDateDirty() && (bl || pSCodeSnippetTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCodeSnippetTypeBase.getCreateDate());
        }
        if (pSCodeSnippetTypeBase.isCreateManDirty() && (bl || pSCodeSnippetTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCodeSnippetTypeBase.getCreateMan());
        }
        if (pSCodeSnippetTypeBase.isMemoDirty() && (bl || pSCodeSnippetTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCodeSnippetTypeBase.getMemo());
        }
        if (pSCodeSnippetTypeBase.isPSCodeSnippetTypeIdDirty() && (bl || pSCodeSnippetTypeBase.getPSCodeSnippetTypeId() != null)) {
            iDataObject.set(FIELD_PSCODESNIPPETTYPEID, (Object)pSCodeSnippetTypeBase.getPSCodeSnippetTypeId());
        }
        if (pSCodeSnippetTypeBase.isPSCodeSnippetTypeNameDirty() && (bl || pSCodeSnippetTypeBase.getPSCodeSnippetTypeName() != null)) {
            iDataObject.set(FIELD_PSCODESNIPPETTYPENAME, (Object)pSCodeSnippetTypeBase.getPSCodeSnippetTypeName());
        }
        if (pSCodeSnippetTypeBase.isPubObjDirty() && (bl || pSCodeSnippetTypeBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSCodeSnippetTypeBase.getPubObj());
        }
        if (pSCodeSnippetTypeBase.isUpdateDateDirty() && (bl || pSCodeSnippetTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCodeSnippetTypeBase.getUpdateDate());
        }
        if (pSCodeSnippetTypeBase.isUpdateManDirty() && (bl || pSCodeSnippetTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCodeSnippetTypeBase.getUpdateMan());
        }
        if (pSCodeSnippetTypeBase.isValidFlagDirty() && (bl || pSCodeSnippetTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCodeSnippetTypeBase.getValidFlag());
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
        return PSCodeSnippetTypeBase.remove(this, n);
    }

    private static boolean remove(PSCodeSnippetTypeBase pSCodeSnippetTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCodeSnippetTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCodeSnippetTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCodeSnippetTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSCodeSnippetTypeBase.resetPSCodeSnippetTypeId();
                return true;
            }
            case 4: {
                pSCodeSnippetTypeBase.resetPSCodeSnippetTypeName();
                return true;
            }
            case 5: {
                pSCodeSnippetTypeBase.resetPubObj();
                return true;
            }
            case 6: {
                pSCodeSnippetTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSCodeSnippetTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSCodeSnippetTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCodeSnippetTypeBase getProxyEntity() {
        return this.proxyPSCodeSnippetTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCodeSnippetTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSCodeSnippetTypeBase) {
            this.proxyPSCodeSnippetTypeBase = (PSCodeSnippetTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCodeSnippetTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSCODESNIPPETTYPEID, 3);
        fieldIndexMap.put(FIELD_PSCODESNIPPETTYPENAME, 4);
        fieldIndexMap.put(FIELD_PUBOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

