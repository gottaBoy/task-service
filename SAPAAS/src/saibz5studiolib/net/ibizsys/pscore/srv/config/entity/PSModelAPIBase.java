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

public abstract class PSModelAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelAPIBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELAPIID = "PSMODELAPIID";
    public static final String FIELD_PSMODELAPINAME = "PSMODELAPINAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSMODELAPIID = 3;
    private static final int INDEX_PSMODELAPINAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_VALIDFLAG = 7;
    private static final int INDEX_VERSION = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelAPIBase proxyPSModelAPIBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodelapiidDirtyFlag = false;
    private boolean psmodelapinameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodelapiid")
    private String psmodelapiid;
    @Column(name="psmodelapiname")
    private String psmodelapiname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="version")
    private String version;

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

    public void setPSModelAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiid = string;
        this.psmodelapiidDirtyFlag = true;
    }

    public String getPSModelAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIId();
        }
        return this.psmodelapiid;
    }

    public boolean isPSModelAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIdDirty();
        }
        return this.psmodelapiidDirtyFlag;
    }

    public void resetPSModelAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIId();
            return;
        }
        this.psmodelapiidDirtyFlag = false;
        this.psmodelapiid = null;
    }

    public void setPSModelAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiname = string;
        this.psmodelapinameDirtyFlag = true;
    }

    public String getPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIName();
        }
        return this.psmodelapiname;
    }

    public boolean isPSModelAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPINameDirty();
        }
        return this.psmodelapinameDirtyFlag;
    }

    public void resetPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIName();
            return;
        }
        this.psmodelapinameDirtyFlag = false;
        this.psmodelapiname = null;
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

    public void setVersion(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.version = string;
        this.versionDirtyFlag = true;
    }

    public String getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    protected void onReset() {
        PSModelAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelAPIBase pSModelAPIBase) {
        pSModelAPIBase.resetCreateDate();
        pSModelAPIBase.resetCreateMan();
        pSModelAPIBase.resetMemo();
        pSModelAPIBase.resetPSModelAPIId();
        pSModelAPIBase.resetPSModelAPIName();
        pSModelAPIBase.resetUpdateDate();
        pSModelAPIBase.resetUpdateMan();
        pSModelAPIBase.resetValidFlag();
        pSModelAPIBase.resetVersion();
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
        if (!bl || this.isPSModelAPIIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIID, this.getPSModelAPIId());
        }
        if (!bl || this.isPSModelAPINameDirty()) {
            hashMap.put(FIELD_PSMODELAPINAME, this.getPSModelAPIName());
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
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSModelAPIBase.get(this, n);
    }

    private static Object get(PSModelAPIBase pSModelAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIBase.getCreateDate();
            }
            case 1: {
                return pSModelAPIBase.getCreateMan();
            }
            case 2: {
                return pSModelAPIBase.getMemo();
            }
            case 3: {
                return pSModelAPIBase.getPSModelAPIId();
            }
            case 4: {
                return pSModelAPIBase.getPSModelAPIName();
            }
            case 5: {
                return pSModelAPIBase.getUpdateDate();
            }
            case 6: {
                return pSModelAPIBase.getUpdateMan();
            }
            case 7: {
                return pSModelAPIBase.getValidFlag();
            }
            case 8: {
                return pSModelAPIBase.getVersion();
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
        PSModelAPIBase.set(this, n, object);
    }

    private static void set(PSModelAPIBase pSModelAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelAPIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelAPIBase.setPSModelAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelAPIBase.setPSModelAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSModelAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelAPIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSModelAPIBase.setVersion(DataObject.getStringValue((Object)object));
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
        return PSModelAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSModelAPIBase pSModelAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelAPIBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelAPIBase.getMemo() == null;
            }
            case 3: {
                return pSModelAPIBase.getPSModelAPIId() == null;
            }
            case 4: {
                return pSModelAPIBase.getPSModelAPIName() == null;
            }
            case 5: {
                return pSModelAPIBase.getUpdateDate() == null;
            }
            case 6: {
                return pSModelAPIBase.getUpdateMan() == null;
            }
            case 7: {
                return pSModelAPIBase.getValidFlag() == null;
            }
            case 8: {
                return pSModelAPIBase.getVersion() == null;
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
        return PSModelAPIBase.contains(this, n);
    }

    private static boolean contains(PSModelAPIBase pSModelAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelAPIBase.isCreateManDirty();
            }
            case 2: {
                return pSModelAPIBase.isMemoDirty();
            }
            case 3: {
                return pSModelAPIBase.isPSModelAPIIdDirty();
            }
            case 4: {
                return pSModelAPIBase.isPSModelAPINameDirty();
            }
            case 5: {
                return pSModelAPIBase.isUpdateDateDirty();
            }
            case 6: {
                return pSModelAPIBase.isUpdateManDirty();
            }
            case 7: {
                return pSModelAPIBase.isValidFlagDirty();
            }
            case 8: {
                return pSModelAPIBase.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelAPIBase pSModelAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getPSModelAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiid", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getPSModelAPIId()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getPSModelAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiname", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getPSModelAPIName()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSModelAPIBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSModelAPIBase.getJSONValue((Object)pSModelAPIBase.getVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelAPIBase pSModelAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelAPIBase.getCreateDate() != null) {
            object = pSModelAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIBase.getCreateMan() != null) {
            object = pSModelAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIBase.getMemo() != null) {
            object = pSModelAPIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIBase.getPSModelAPIId() != null) {
            object = pSModelAPIBase.getPSModelAPIId();
            xmlNode.setAttribute(FIELD_PSMODELAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIBase.getPSModelAPIName() != null) {
            object = pSModelAPIBase.getPSModelAPIName();
            xmlNode.setAttribute(FIELD_PSMODELAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIBase.getUpdateDate() != null) {
            object = pSModelAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIBase.getUpdateMan() != null) {
            object = pSModelAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIBase.getValidFlag() != null) {
            object = pSModelAPIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelAPIBase.getVersion() != null) {
            object = pSModelAPIBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelAPIBase pSModelAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelAPIBase.isCreateDateDirty() && (bl || pSModelAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelAPIBase.getCreateDate());
        }
        if (pSModelAPIBase.isCreateManDirty() && (bl || pSModelAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelAPIBase.getCreateMan());
        }
        if (pSModelAPIBase.isMemoDirty() && (bl || pSModelAPIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelAPIBase.getMemo());
        }
        if (pSModelAPIBase.isPSModelAPIIdDirty() && (bl || pSModelAPIBase.getPSModelAPIId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIID, (Object)pSModelAPIBase.getPSModelAPIId());
        }
        if (pSModelAPIBase.isPSModelAPINameDirty() && (bl || pSModelAPIBase.getPSModelAPIName() != null)) {
            iDataObject.set(FIELD_PSMODELAPINAME, (Object)pSModelAPIBase.getPSModelAPIName());
        }
        if (pSModelAPIBase.isUpdateDateDirty() && (bl || pSModelAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelAPIBase.getUpdateDate());
        }
        if (pSModelAPIBase.isUpdateManDirty() && (bl || pSModelAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelAPIBase.getUpdateMan());
        }
        if (pSModelAPIBase.isValidFlagDirty() && (bl || pSModelAPIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelAPIBase.getValidFlag());
        }
        if (pSModelAPIBase.isVersionDirty() && (bl || pSModelAPIBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSModelAPIBase.getVersion());
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
        return PSModelAPIBase.remove(this, n);
    }

    private static boolean remove(PSModelAPIBase pSModelAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelAPIBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelAPIBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelAPIBase.resetPSModelAPIId();
                return true;
            }
            case 4: {
                pSModelAPIBase.resetPSModelAPIName();
                return true;
            }
            case 5: {
                pSModelAPIBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSModelAPIBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSModelAPIBase.resetValidFlag();
                return true;
            }
            case 8: {
                pSModelAPIBase.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelAPIBase getProxyEntity() {
        return this.proxyPSModelAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelAPIBase) {
            this.proxyPSModelAPIBase = (PSModelAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSMODELAPIID, 3);
        fieldIndexMap.put(FIELD_PSMODELAPINAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_VALIDFLAG, 7);
        fieldIndexMap.put(FIELD_VERSION, 8);
    }
}

