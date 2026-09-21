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

public abstract class PSUAPolicyTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUAPolicyTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSUACPOLICYTYPEID = "PSUACPOLICYTYPEID";
    public static final String FIELD_PSUACPOLICYTYPENAME = "PSUACPOLICYTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSUACPOLICYTYPEID = 3;
    private static final int INDEX_PSUACPOLICYTYPENAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_VALIDFLAG = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUAPolicyTypeBase proxyPSUAPolicyTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psuacpolicytypeidDirtyFlag = false;
    private boolean psuacpolicytypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psuacpolicytypeid")
    private String psuacpolicytypeid;
    @Column(name="psuacpolicytypename")
    private String psuacpolicytypename;
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

    public void setPSUACPolicyTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUACPolicyTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuacpolicytypeid = string;
        this.psuacpolicytypeidDirtyFlag = true;
    }

    public String getPSUACPolicyTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUACPolicyTypeId();
        }
        return this.psuacpolicytypeid;
    }

    public boolean isPSUACPolicyTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUACPolicyTypeIdDirty();
        }
        return this.psuacpolicytypeidDirtyFlag;
    }

    public void resetPSUACPolicyTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUACPolicyTypeId();
            return;
        }
        this.psuacpolicytypeidDirtyFlag = false;
        this.psuacpolicytypeid = null;
    }

    public void setPSUACPolicyTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUACPolicyTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuacpolicytypename = string;
        this.psuacpolicytypenameDirtyFlag = true;
    }

    public String getPSUACPolicyTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUACPolicyTypeName();
        }
        return this.psuacpolicytypename;
    }

    public boolean isPSUACPolicyTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUACPolicyTypeNameDirty();
        }
        return this.psuacpolicytypenameDirtyFlag;
    }

    public void resetPSUACPolicyTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUACPolicyTypeName();
            return;
        }
        this.psuacpolicytypenameDirtyFlag = false;
        this.psuacpolicytypename = null;
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
        PSUAPolicyTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUAPolicyTypeBase pSUAPolicyTypeBase) {
        pSUAPolicyTypeBase.resetCreateDate();
        pSUAPolicyTypeBase.resetCreateMan();
        pSUAPolicyTypeBase.resetMemo();
        pSUAPolicyTypeBase.resetPSUACPolicyTypeId();
        pSUAPolicyTypeBase.resetPSUACPolicyTypeName();
        pSUAPolicyTypeBase.resetUpdateDate();
        pSUAPolicyTypeBase.resetUpdateMan();
        pSUAPolicyTypeBase.resetValidFlag();
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
        if (!bl || this.isPSUACPolicyTypeIdDirty()) {
            hashMap.put(FIELD_PSUACPOLICYTYPEID, this.getPSUACPolicyTypeId());
        }
        if (!bl || this.isPSUACPolicyTypeNameDirty()) {
            hashMap.put(FIELD_PSUACPOLICYTYPENAME, this.getPSUACPolicyTypeName());
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
        return PSUAPolicyTypeBase.get(this, n);
    }

    private static Object get(PSUAPolicyTypeBase pSUAPolicyTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAPolicyTypeBase.getCreateDate();
            }
            case 1: {
                return pSUAPolicyTypeBase.getCreateMan();
            }
            case 2: {
                return pSUAPolicyTypeBase.getMemo();
            }
            case 3: {
                return pSUAPolicyTypeBase.getPSUACPolicyTypeId();
            }
            case 4: {
                return pSUAPolicyTypeBase.getPSUACPolicyTypeName();
            }
            case 5: {
                return pSUAPolicyTypeBase.getUpdateDate();
            }
            case 6: {
                return pSUAPolicyTypeBase.getUpdateMan();
            }
            case 7: {
                return pSUAPolicyTypeBase.getValidFlag();
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
        PSUAPolicyTypeBase.set(this, n, object);
    }

    private static void set(PSUAPolicyTypeBase pSUAPolicyTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUAPolicyTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUAPolicyTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUAPolicyTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUAPolicyTypeBase.setPSUACPolicyTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUAPolicyTypeBase.setPSUACPolicyTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUAPolicyTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSUAPolicyTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUAPolicyTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUAPolicyTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSUAPolicyTypeBase pSUAPolicyTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAPolicyTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSUAPolicyTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSUAPolicyTypeBase.getMemo() == null;
            }
            case 3: {
                return pSUAPolicyTypeBase.getPSUACPolicyTypeId() == null;
            }
            case 4: {
                return pSUAPolicyTypeBase.getPSUACPolicyTypeName() == null;
            }
            case 5: {
                return pSUAPolicyTypeBase.getUpdateDate() == null;
            }
            case 6: {
                return pSUAPolicyTypeBase.getUpdateMan() == null;
            }
            case 7: {
                return pSUAPolicyTypeBase.getValidFlag() == null;
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
        return PSUAPolicyTypeBase.contains(this, n);
    }

    private static boolean contains(PSUAPolicyTypeBase pSUAPolicyTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUAPolicyTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSUAPolicyTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSUAPolicyTypeBase.isMemoDirty();
            }
            case 3: {
                return pSUAPolicyTypeBase.isPSUACPolicyTypeIdDirty();
            }
            case 4: {
                return pSUAPolicyTypeBase.isPSUACPolicyTypeNameDirty();
            }
            case 5: {
                return pSUAPolicyTypeBase.isUpdateDateDirty();
            }
            case 6: {
                return pSUAPolicyTypeBase.isUpdateManDirty();
            }
            case 7: {
                return pSUAPolicyTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUAPolicyTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUAPolicyTypeBase pSUAPolicyTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUAPolicyTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUAPolicyTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUAPolicyTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSUAPolicyTypeBase.getPSUACPolicyTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuacpolicytypeid", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getPSUACPolicyTypeId()), (boolean)false);
        }
        if (bl || pSUAPolicyTypeBase.getPSUACPolicyTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuacpolicytypename", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getPSUACPolicyTypeName()), (boolean)false);
        }
        if (bl || pSUAPolicyTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUAPolicyTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUAPolicyTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUAPolicyTypeBase.getJSONValue((Object)pSUAPolicyTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUAPolicyTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUAPolicyTypeBase pSUAPolicyTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUAPolicyTypeBase.getCreateDate() != null) {
            object = pSUAPolicyTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAPolicyTypeBase.getCreateMan() != null) {
            object = pSUAPolicyTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUAPolicyTypeBase.getMemo() != null) {
            object = pSUAPolicyTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUAPolicyTypeBase.getPSUACPolicyTypeId() != null) {
            object = pSUAPolicyTypeBase.getPSUACPolicyTypeId();
            xmlNode.setAttribute(FIELD_PSUACPOLICYTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSUAPolicyTypeBase.getPSUACPolicyTypeName() != null) {
            object = pSUAPolicyTypeBase.getPSUACPolicyTypeName();
            xmlNode.setAttribute(FIELD_PSUACPOLICYTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUAPolicyTypeBase.getUpdateDate() != null) {
            object = pSUAPolicyTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUAPolicyTypeBase.getUpdateMan() != null) {
            object = pSUAPolicyTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUAPolicyTypeBase.getValidFlag() != null) {
            object = pSUAPolicyTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUAPolicyTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUAPolicyTypeBase pSUAPolicyTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUAPolicyTypeBase.isCreateDateDirty() && (bl || pSUAPolicyTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUAPolicyTypeBase.getCreateDate());
        }
        if (pSUAPolicyTypeBase.isCreateManDirty() && (bl || pSUAPolicyTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUAPolicyTypeBase.getCreateMan());
        }
        if (pSUAPolicyTypeBase.isMemoDirty() && (bl || pSUAPolicyTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUAPolicyTypeBase.getMemo());
        }
        if (pSUAPolicyTypeBase.isPSUACPolicyTypeIdDirty() && (bl || pSUAPolicyTypeBase.getPSUACPolicyTypeId() != null)) {
            iDataObject.set(FIELD_PSUACPOLICYTYPEID, (Object)pSUAPolicyTypeBase.getPSUACPolicyTypeId());
        }
        if (pSUAPolicyTypeBase.isPSUACPolicyTypeNameDirty() && (bl || pSUAPolicyTypeBase.getPSUACPolicyTypeName() != null)) {
            iDataObject.set(FIELD_PSUACPOLICYTYPENAME, (Object)pSUAPolicyTypeBase.getPSUACPolicyTypeName());
        }
        if (pSUAPolicyTypeBase.isUpdateDateDirty() && (bl || pSUAPolicyTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUAPolicyTypeBase.getUpdateDate());
        }
        if (pSUAPolicyTypeBase.isUpdateManDirty() && (bl || pSUAPolicyTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUAPolicyTypeBase.getUpdateMan());
        }
        if (pSUAPolicyTypeBase.isValidFlagDirty() && (bl || pSUAPolicyTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUAPolicyTypeBase.getValidFlag());
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
        return PSUAPolicyTypeBase.remove(this, n);
    }

    private static boolean remove(PSUAPolicyTypeBase pSUAPolicyTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUAPolicyTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUAPolicyTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUAPolicyTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSUAPolicyTypeBase.resetPSUACPolicyTypeId();
                return true;
            }
            case 4: {
                pSUAPolicyTypeBase.resetPSUACPolicyTypeName();
                return true;
            }
            case 5: {
                pSUAPolicyTypeBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSUAPolicyTypeBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSUAPolicyTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUAPolicyTypeBase getProxyEntity() {
        return this.proxyPSUAPolicyTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUAPolicyTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSUAPolicyTypeBase) {
            this.proxyPSUAPolicyTypeBase = (PSUAPolicyTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUAPolicyTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSUACPOLICYTYPEID, 3);
        fieldIndexMap.put(FIELD_PSUACPOLICYTYPENAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_VALIDFLAG, 7);
    }
}

