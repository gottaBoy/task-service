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

public abstract class PSRegistryServerTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRegistryServerTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSREGISTRYSERVERTYPEID = "PSREGISTRYSERVERTYPEID";
    public static final String FIELD_PSREGISTRYSERVERTYPENAME = "PSREGISTRYSERVERTYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSREGISTRYSERVERTYPEID = 3;
    private static final int INDEX_PSREGISTRYSERVERTYPENAME = 4;
    private static final int INDEX_TYPEOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRegistryServerTypeBase proxyPSRegistryServerTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psregistryservertypeidDirtyFlag = false;
    private boolean psregistryservertypenameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psregistryservertypeid")
    private String psregistryservertypeid;
    @Column(name="psregistryservertypename")
    private String psregistryservertypename;
    @Column(name="typeobj")
    private String typeobj;
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

    public void setPSRegistryServerTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryServerTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryservertypeid = string;
        this.psregistryservertypeidDirtyFlag = true;
    }

    public String getPSRegistryServerTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryServerTypeId();
        }
        return this.psregistryservertypeid;
    }

    public boolean isPSRegistryServerTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryServerTypeIdDirty();
        }
        return this.psregistryservertypeidDirtyFlag;
    }

    public void resetPSRegistryServerTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryServerTypeId();
            return;
        }
        this.psregistryservertypeidDirtyFlag = false;
        this.psregistryservertypeid = null;
    }

    public void setPSRegistryServerTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryServerTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryservertypename = string;
        this.psregistryservertypenameDirtyFlag = true;
    }

    public String getPSRegistryServerTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryServerTypeName();
        }
        return this.psregistryservertypename;
    }

    public boolean isPSRegistryServerTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryServerTypeNameDirty();
        }
        return this.psregistryservertypenameDirtyFlag;
    }

    public void resetPSRegistryServerTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryServerTypeName();
            return;
        }
        this.psregistryservertypenameDirtyFlag = false;
        this.psregistryservertypename = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSRegistryServerTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRegistryServerTypeBase pSRegistryServerTypeBase) {
        pSRegistryServerTypeBase.resetCreateDate();
        pSRegistryServerTypeBase.resetCreateMan();
        pSRegistryServerTypeBase.resetMemo();
        pSRegistryServerTypeBase.resetPSRegistryServerTypeId();
        pSRegistryServerTypeBase.resetPSRegistryServerTypeName();
        pSRegistryServerTypeBase.resetTypeObj();
        pSRegistryServerTypeBase.resetUpdateDate();
        pSRegistryServerTypeBase.resetUpdateMan();
        pSRegistryServerTypeBase.resetValidFlag();
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
        if (!bl || this.isPSRegistryServerTypeIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYSERVERTYPEID, this.getPSRegistryServerTypeId());
        }
        if (!bl || this.isPSRegistryServerTypeNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYSERVERTYPENAME, this.getPSRegistryServerTypeName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSRegistryServerTypeBase.get(this, n);
    }

    private static Object get(PSRegistryServerTypeBase pSRegistryServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryServerTypeBase.getCreateDate();
            }
            case 1: {
                return pSRegistryServerTypeBase.getCreateMan();
            }
            case 2: {
                return pSRegistryServerTypeBase.getMemo();
            }
            case 3: {
                return pSRegistryServerTypeBase.getPSRegistryServerTypeId();
            }
            case 4: {
                return pSRegistryServerTypeBase.getPSRegistryServerTypeName();
            }
            case 5: {
                return pSRegistryServerTypeBase.getTypeObj();
            }
            case 6: {
                return pSRegistryServerTypeBase.getUpdateDate();
            }
            case 7: {
                return pSRegistryServerTypeBase.getUpdateMan();
            }
            case 8: {
                return pSRegistryServerTypeBase.getValidFlag();
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
        PSRegistryServerTypeBase.set(this, n, object);
    }

    private static void set(PSRegistryServerTypeBase pSRegistryServerTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryServerTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRegistryServerTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRegistryServerTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSRegistryServerTypeBase.setPSRegistryServerTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRegistryServerTypeBase.setPSRegistryServerTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRegistryServerTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRegistryServerTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSRegistryServerTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRegistryServerTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRegistryServerTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSRegistryServerTypeBase pSRegistryServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryServerTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSRegistryServerTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSRegistryServerTypeBase.getMemo() == null;
            }
            case 3: {
                return pSRegistryServerTypeBase.getPSRegistryServerTypeId() == null;
            }
            case 4: {
                return pSRegistryServerTypeBase.getPSRegistryServerTypeName() == null;
            }
            case 5: {
                return pSRegistryServerTypeBase.getTypeObj() == null;
            }
            case 6: {
                return pSRegistryServerTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSRegistryServerTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSRegistryServerTypeBase.getValidFlag() == null;
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
        return PSRegistryServerTypeBase.contains(this, n);
    }

    private static boolean contains(PSRegistryServerTypeBase pSRegistryServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRegistryServerTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSRegistryServerTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSRegistryServerTypeBase.isMemoDirty();
            }
            case 3: {
                return pSRegistryServerTypeBase.isPSRegistryServerTypeIdDirty();
            }
            case 4: {
                return pSRegistryServerTypeBase.isPSRegistryServerTypeNameDirty();
            }
            case 5: {
                return pSRegistryServerTypeBase.isTypeObjDirty();
            }
            case 6: {
                return pSRegistryServerTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSRegistryServerTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSRegistryServerTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRegistryServerTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRegistryServerTypeBase pSRegistryServerTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRegistryServerTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getPSRegistryServerTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryservertypeid", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getPSRegistryServerTypeId()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getPSRegistryServerTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryservertypename", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getPSRegistryServerTypeName()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRegistryServerTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRegistryServerTypeBase.getJSONValue((Object)pSRegistryServerTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRegistryServerTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRegistryServerTypeBase pSRegistryServerTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRegistryServerTypeBase.getCreateDate() != null) {
            object = pSRegistryServerTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryServerTypeBase.getCreateMan() != null) {
            object = pSRegistryServerTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerTypeBase.getMemo() != null) {
            object = pSRegistryServerTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerTypeBase.getPSRegistryServerTypeId() != null) {
            object = pSRegistryServerTypeBase.getPSRegistryServerTypeId();
            xmlNode.setAttribute(FIELD_PSREGISTRYSERVERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerTypeBase.getPSRegistryServerTypeName() != null) {
            object = pSRegistryServerTypeBase.getPSRegistryServerTypeName();
            xmlNode.setAttribute(FIELD_PSREGISTRYSERVERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerTypeBase.getTypeObj() != null) {
            object = pSRegistryServerTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerTypeBase.getUpdateDate() != null) {
            object = pSRegistryServerTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRegistryServerTypeBase.getUpdateMan() != null) {
            object = pSRegistryServerTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRegistryServerTypeBase.getValidFlag() != null) {
            object = pSRegistryServerTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRegistryServerTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRegistryServerTypeBase pSRegistryServerTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRegistryServerTypeBase.isCreateDateDirty() && (bl || pSRegistryServerTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRegistryServerTypeBase.getCreateDate());
        }
        if (pSRegistryServerTypeBase.isCreateManDirty() && (bl || pSRegistryServerTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRegistryServerTypeBase.getCreateMan());
        }
        if (pSRegistryServerTypeBase.isMemoDirty() && (bl || pSRegistryServerTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRegistryServerTypeBase.getMemo());
        }
        if (pSRegistryServerTypeBase.isPSRegistryServerTypeIdDirty() && (bl || pSRegistryServerTypeBase.getPSRegistryServerTypeId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYSERVERTYPEID, (Object)pSRegistryServerTypeBase.getPSRegistryServerTypeId());
        }
        if (pSRegistryServerTypeBase.isPSRegistryServerTypeNameDirty() && (bl || pSRegistryServerTypeBase.getPSRegistryServerTypeName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYSERVERTYPENAME, (Object)pSRegistryServerTypeBase.getPSRegistryServerTypeName());
        }
        if (pSRegistryServerTypeBase.isTypeObjDirty() && (bl || pSRegistryServerTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSRegistryServerTypeBase.getTypeObj());
        }
        if (pSRegistryServerTypeBase.isUpdateDateDirty() && (bl || pSRegistryServerTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRegistryServerTypeBase.getUpdateDate());
        }
        if (pSRegistryServerTypeBase.isUpdateManDirty() && (bl || pSRegistryServerTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRegistryServerTypeBase.getUpdateMan());
        }
        if (pSRegistryServerTypeBase.isValidFlagDirty() && (bl || pSRegistryServerTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRegistryServerTypeBase.getValidFlag());
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
        return PSRegistryServerTypeBase.remove(this, n);
    }

    private static boolean remove(PSRegistryServerTypeBase pSRegistryServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRegistryServerTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRegistryServerTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRegistryServerTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSRegistryServerTypeBase.resetPSRegistryServerTypeId();
                return true;
            }
            case 4: {
                pSRegistryServerTypeBase.resetPSRegistryServerTypeName();
                return true;
            }
            case 5: {
                pSRegistryServerTypeBase.resetTypeObj();
                return true;
            }
            case 6: {
                pSRegistryServerTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSRegistryServerTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSRegistryServerTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSRegistryServerTypeBase getProxyEntity() {
        return this.proxyPSRegistryServerTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRegistryServerTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSRegistryServerTypeBase) {
            this.proxyPSRegistryServerTypeBase = (PSRegistryServerTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRegistryServerTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSREGISTRYSERVERTYPEID, 3);
        fieldIndexMap.put(FIELD_PSREGISTRYSERVERTYPENAME, 4);
        fieldIndexMap.put(FIELD_TYPEOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

