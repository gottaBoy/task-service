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

public abstract class PSOpenPlatformTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSOpenPlatformTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSOPENFLATFORMTYPEID = "PSOPENPLATFORMTYPEID";
    public static final String FIELD_PSOPENFLATFORMTYPENAME = "PSOPENPLATFORMTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSOPENFLATFORMTYPEID = 3;
    private static final int INDEX_PSOPENFLATFORMTYPENAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_VALIDFLAG = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSOpenPlatformTypeBase proxyPSOpenPlatformTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psopenflatformtypeidDirtyFlag = false;
    private boolean psopenflatformtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psopenflatformtypeid")
    private String psopenflatformtypeid;
    @Column(name="psopenflatformtypename")
    private String psopenflatformtypename;
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

    public void setPSOpenFlatformTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSOpenFlatformTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psopenflatformtypeid = string;
        this.psopenflatformtypeidDirtyFlag = true;
    }

    public String getPSOpenFlatformTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSOpenFlatformTypeId();
        }
        return this.psopenflatformtypeid;
    }

    public boolean isPSOpenFlatformTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSOpenFlatformTypeIdDirty();
        }
        return this.psopenflatformtypeidDirtyFlag;
    }

    public void resetPSOpenFlatformTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSOpenFlatformTypeId();
            return;
        }
        this.psopenflatformtypeidDirtyFlag = false;
        this.psopenflatformtypeid = null;
    }

    public void setPSOpenFlatformTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSOpenFlatformTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psopenflatformtypename = string;
        this.psopenflatformtypenameDirtyFlag = true;
    }

    public String getPSOpenFlatformTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSOpenFlatformTypeName();
        }
        return this.psopenflatformtypename;
    }

    public boolean isPSOpenFlatformTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSOpenFlatformTypeNameDirty();
        }
        return this.psopenflatformtypenameDirtyFlag;
    }

    public void resetPSOpenFlatformTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSOpenFlatformTypeName();
            return;
        }
        this.psopenflatformtypenameDirtyFlag = false;
        this.psopenflatformtypename = null;
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
        PSOpenPlatformTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSOpenPlatformTypeBase pSOpenPlatformTypeBase) {
        pSOpenPlatformTypeBase.resetCreateDate();
        pSOpenPlatformTypeBase.resetCreateMan();
        pSOpenPlatformTypeBase.resetMemo();
        pSOpenPlatformTypeBase.resetPSOpenFlatformTypeId();
        pSOpenPlatformTypeBase.resetPSOpenFlatformTypeName();
        pSOpenPlatformTypeBase.resetUpdateDate();
        pSOpenPlatformTypeBase.resetUpdateMan();
        pSOpenPlatformTypeBase.resetValidFlag();
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
        if (!bl || this.isPSOpenFlatformTypeIdDirty()) {
            hashMap.put(FIELD_PSOPENFLATFORMTYPEID, this.getPSOpenFlatformTypeId());
        }
        if (!bl || this.isPSOpenFlatformTypeNameDirty()) {
            hashMap.put(FIELD_PSOPENFLATFORMTYPENAME, this.getPSOpenFlatformTypeName());
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
        return PSOpenPlatformTypeBase.get(this, n);
    }

    private static Object get(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSOpenPlatformTypeBase.getCreateDate();
            }
            case 1: {
                return pSOpenPlatformTypeBase.getCreateMan();
            }
            case 2: {
                return pSOpenPlatformTypeBase.getMemo();
            }
            case 3: {
                return pSOpenPlatformTypeBase.getPSOpenFlatformTypeId();
            }
            case 4: {
                return pSOpenPlatformTypeBase.getPSOpenFlatformTypeName();
            }
            case 5: {
                return pSOpenPlatformTypeBase.getUpdateDate();
            }
            case 6: {
                return pSOpenPlatformTypeBase.getUpdateMan();
            }
            case 7: {
                return pSOpenPlatformTypeBase.getValidFlag();
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
        PSOpenPlatformTypeBase.set(this, n, object);
    }

    private static void set(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSOpenPlatformTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSOpenPlatformTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSOpenPlatformTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSOpenPlatformTypeBase.setPSOpenFlatformTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSOpenPlatformTypeBase.setPSOpenFlatformTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSOpenPlatformTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSOpenPlatformTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSOpenPlatformTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSOpenPlatformTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSOpenPlatformTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSOpenPlatformTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSOpenPlatformTypeBase.getMemo() == null;
            }
            case 3: {
                return pSOpenPlatformTypeBase.getPSOpenFlatformTypeId() == null;
            }
            case 4: {
                return pSOpenPlatformTypeBase.getPSOpenFlatformTypeName() == null;
            }
            case 5: {
                return pSOpenPlatformTypeBase.getUpdateDate() == null;
            }
            case 6: {
                return pSOpenPlatformTypeBase.getUpdateMan() == null;
            }
            case 7: {
                return pSOpenPlatformTypeBase.getValidFlag() == null;
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
        return PSOpenPlatformTypeBase.contains(this, n);
    }

    private static boolean contains(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSOpenPlatformTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSOpenPlatformTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSOpenPlatformTypeBase.isMemoDirty();
            }
            case 3: {
                return pSOpenPlatformTypeBase.isPSOpenFlatformTypeIdDirty();
            }
            case 4: {
                return pSOpenPlatformTypeBase.isPSOpenFlatformTypeNameDirty();
            }
            case 5: {
                return pSOpenPlatformTypeBase.isUpdateDateDirty();
            }
            case 6: {
                return pSOpenPlatformTypeBase.isUpdateManDirty();
            }
            case 7: {
                return pSOpenPlatformTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSOpenPlatformTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSOpenPlatformTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSOpenPlatformTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSOpenPlatformTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSOpenPlatformTypeBase.getPSOpenFlatformTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psopenplatformtypeid", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getPSOpenFlatformTypeId()), (boolean)false);
        }
        if (bl || pSOpenPlatformTypeBase.getPSOpenFlatformTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psopenplatformtypename", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getPSOpenFlatformTypeName()), (boolean)false);
        }
        if (bl || pSOpenPlatformTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSOpenPlatformTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSOpenPlatformTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSOpenPlatformTypeBase.getJSONValue((Object)pSOpenPlatformTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSOpenPlatformTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSOpenPlatformTypeBase.getCreateDate() != null) {
            object = pSOpenPlatformTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSOpenPlatformTypeBase.getCreateMan() != null) {
            object = pSOpenPlatformTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSOpenPlatformTypeBase.getMemo() != null) {
            object = pSOpenPlatformTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSOpenPlatformTypeBase.getPSOpenFlatformTypeId() != null) {
            object = pSOpenPlatformTypeBase.getPSOpenFlatformTypeId();
            xmlNode.setAttribute("PSOPENFLATFORMTYPEID", object == null ? "" : (String)object);
        }
        if (bl || pSOpenPlatformTypeBase.getPSOpenFlatformTypeName() != null) {
            object = pSOpenPlatformTypeBase.getPSOpenFlatformTypeName();
            xmlNode.setAttribute("PSOPENFLATFORMTYPENAME", object == null ? "" : (String)object);
        }
        if (bl || pSOpenPlatformTypeBase.getUpdateDate() != null) {
            object = pSOpenPlatformTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSOpenPlatformTypeBase.getUpdateMan() != null) {
            object = pSOpenPlatformTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSOpenPlatformTypeBase.getValidFlag() != null) {
            object = pSOpenPlatformTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSOpenPlatformTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSOpenPlatformTypeBase.isCreateDateDirty() && (bl || pSOpenPlatformTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSOpenPlatformTypeBase.getCreateDate());
        }
        if (pSOpenPlatformTypeBase.isCreateManDirty() && (bl || pSOpenPlatformTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSOpenPlatformTypeBase.getCreateMan());
        }
        if (pSOpenPlatformTypeBase.isMemoDirty() && (bl || pSOpenPlatformTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSOpenPlatformTypeBase.getMemo());
        }
        if (pSOpenPlatformTypeBase.isPSOpenFlatformTypeIdDirty() && (bl || pSOpenPlatformTypeBase.getPSOpenFlatformTypeId() != null)) {
            iDataObject.set(FIELD_PSOPENFLATFORMTYPEID, (Object)pSOpenPlatformTypeBase.getPSOpenFlatformTypeId());
        }
        if (pSOpenPlatformTypeBase.isPSOpenFlatformTypeNameDirty() && (bl || pSOpenPlatformTypeBase.getPSOpenFlatformTypeName() != null)) {
            iDataObject.set(FIELD_PSOPENFLATFORMTYPENAME, (Object)pSOpenPlatformTypeBase.getPSOpenFlatformTypeName());
        }
        if (pSOpenPlatformTypeBase.isUpdateDateDirty() && (bl || pSOpenPlatformTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSOpenPlatformTypeBase.getUpdateDate());
        }
        if (pSOpenPlatformTypeBase.isUpdateManDirty() && (bl || pSOpenPlatformTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSOpenPlatformTypeBase.getUpdateMan());
        }
        if (pSOpenPlatformTypeBase.isValidFlagDirty() && (bl || pSOpenPlatformTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSOpenPlatformTypeBase.getValidFlag());
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
        return PSOpenPlatformTypeBase.remove(this, n);
    }

    private static boolean remove(PSOpenPlatformTypeBase pSOpenPlatformTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSOpenPlatformTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSOpenPlatformTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSOpenPlatformTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSOpenPlatformTypeBase.resetPSOpenFlatformTypeId();
                return true;
            }
            case 4: {
                pSOpenPlatformTypeBase.resetPSOpenFlatformTypeName();
                return true;
            }
            case 5: {
                pSOpenPlatformTypeBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSOpenPlatformTypeBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSOpenPlatformTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSOpenPlatformTypeBase getProxyEntity() {
        return this.proxyPSOpenPlatformTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSOpenPlatformTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSOpenPlatformTypeBase) {
            this.proxyPSOpenPlatformTypeBase = (PSOpenPlatformTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSOpenPlatformTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSOPENFLATFORMTYPEID, 3);
        fieldIndexMap.put(FIELD_PSOPENFLATFORMTYPENAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_VALIDFLAG, 7);
    }
}

