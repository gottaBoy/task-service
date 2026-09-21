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

public abstract class PSUACAppTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUACAppTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSUACAPPTYPEID = "PSUACAPPTYPEID";
    public static final String FIELD_PSUACAPPTYPENAME = "PSUACAPPTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSUACAPPTYPEID = 3;
    private static final int INDEX_PSUACAPPTYPENAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_VALIDFLAG = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUACAppTypeBase proxyPSUACAppTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psuacapptypeidDirtyFlag = false;
    private boolean psuacapptypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psuacapptypeid")
    private String psuacapptypeid;
    @Column(name="psuacapptypename")
    private String psuacapptypename;
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

    public void setPSUACAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUACAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuacapptypeid = string;
        this.psuacapptypeidDirtyFlag = true;
    }

    public String getPSUACAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUACAppTypeId();
        }
        return this.psuacapptypeid;
    }

    public boolean isPSUACAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUACAppTypeIdDirty();
        }
        return this.psuacapptypeidDirtyFlag;
    }

    public void resetPSUACAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUACAppTypeId();
            return;
        }
        this.psuacapptypeidDirtyFlag = false;
        this.psuacapptypeid = null;
    }

    public void setPSUACAppTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUACAppTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuacapptypename = string;
        this.psuacapptypenameDirtyFlag = true;
    }

    public String getPSUACAppTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUACAppTypeName();
        }
        return this.psuacapptypename;
    }

    public boolean isPSUACAppTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUACAppTypeNameDirty();
        }
        return this.psuacapptypenameDirtyFlag;
    }

    public void resetPSUACAppTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUACAppTypeName();
            return;
        }
        this.psuacapptypenameDirtyFlag = false;
        this.psuacapptypename = null;
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
        PSUACAppTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUACAppTypeBase pSUACAppTypeBase) {
        pSUACAppTypeBase.resetCreateDate();
        pSUACAppTypeBase.resetCreateMan();
        pSUACAppTypeBase.resetMemo();
        pSUACAppTypeBase.resetPSUACAppTypeId();
        pSUACAppTypeBase.resetPSUACAppTypeName();
        pSUACAppTypeBase.resetUpdateDate();
        pSUACAppTypeBase.resetUpdateMan();
        pSUACAppTypeBase.resetValidFlag();
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
        if (!bl || this.isPSUACAppTypeIdDirty()) {
            hashMap.put(FIELD_PSUACAPPTYPEID, this.getPSUACAppTypeId());
        }
        if (!bl || this.isPSUACAppTypeNameDirty()) {
            hashMap.put(FIELD_PSUACAPPTYPENAME, this.getPSUACAppTypeName());
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
        return PSUACAppTypeBase.get(this, n);
    }

    private static Object get(PSUACAppTypeBase pSUACAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUACAppTypeBase.getCreateDate();
            }
            case 1: {
                return pSUACAppTypeBase.getCreateMan();
            }
            case 2: {
                return pSUACAppTypeBase.getMemo();
            }
            case 3: {
                return pSUACAppTypeBase.getPSUACAppTypeId();
            }
            case 4: {
                return pSUACAppTypeBase.getPSUACAppTypeName();
            }
            case 5: {
                return pSUACAppTypeBase.getUpdateDate();
            }
            case 6: {
                return pSUACAppTypeBase.getUpdateMan();
            }
            case 7: {
                return pSUACAppTypeBase.getValidFlag();
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
        PSUACAppTypeBase.set(this, n, object);
    }

    private static void set(PSUACAppTypeBase pSUACAppTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUACAppTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUACAppTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUACAppTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUACAppTypeBase.setPSUACAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUACAppTypeBase.setPSUACAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUACAppTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSUACAppTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUACAppTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUACAppTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSUACAppTypeBase pSUACAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUACAppTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSUACAppTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSUACAppTypeBase.getMemo() == null;
            }
            case 3: {
                return pSUACAppTypeBase.getPSUACAppTypeId() == null;
            }
            case 4: {
                return pSUACAppTypeBase.getPSUACAppTypeName() == null;
            }
            case 5: {
                return pSUACAppTypeBase.getUpdateDate() == null;
            }
            case 6: {
                return pSUACAppTypeBase.getUpdateMan() == null;
            }
            case 7: {
                return pSUACAppTypeBase.getValidFlag() == null;
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
        return PSUACAppTypeBase.contains(this, n);
    }

    private static boolean contains(PSUACAppTypeBase pSUACAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUACAppTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSUACAppTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSUACAppTypeBase.isMemoDirty();
            }
            case 3: {
                return pSUACAppTypeBase.isPSUACAppTypeIdDirty();
            }
            case 4: {
                return pSUACAppTypeBase.isPSUACAppTypeNameDirty();
            }
            case 5: {
                return pSUACAppTypeBase.isUpdateDateDirty();
            }
            case 6: {
                return pSUACAppTypeBase.isUpdateManDirty();
            }
            case 7: {
                return pSUACAppTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUACAppTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUACAppTypeBase pSUACAppTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUACAppTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUACAppTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUACAppTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSUACAppTypeBase.getPSUACAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuacapptypeid", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getPSUACAppTypeId()), (boolean)false);
        }
        if (bl || pSUACAppTypeBase.getPSUACAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuacapptypename", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getPSUACAppTypeName()), (boolean)false);
        }
        if (bl || pSUACAppTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUACAppTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUACAppTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUACAppTypeBase.getJSONValue((Object)pSUACAppTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUACAppTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUACAppTypeBase pSUACAppTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUACAppTypeBase.getCreateDate() != null) {
            object = pSUACAppTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUACAppTypeBase.getCreateMan() != null) {
            object = pSUACAppTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUACAppTypeBase.getMemo() != null) {
            object = pSUACAppTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUACAppTypeBase.getPSUACAppTypeId() != null) {
            object = pSUACAppTypeBase.getPSUACAppTypeId();
            xmlNode.setAttribute(FIELD_PSUACAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSUACAppTypeBase.getPSUACAppTypeName() != null) {
            object = pSUACAppTypeBase.getPSUACAppTypeName();
            xmlNode.setAttribute(FIELD_PSUACAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUACAppTypeBase.getUpdateDate() != null) {
            object = pSUACAppTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUACAppTypeBase.getUpdateMan() != null) {
            object = pSUACAppTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUACAppTypeBase.getValidFlag() != null) {
            object = pSUACAppTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUACAppTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUACAppTypeBase pSUACAppTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUACAppTypeBase.isCreateDateDirty() && (bl || pSUACAppTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUACAppTypeBase.getCreateDate());
        }
        if (pSUACAppTypeBase.isCreateManDirty() && (bl || pSUACAppTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUACAppTypeBase.getCreateMan());
        }
        if (pSUACAppTypeBase.isMemoDirty() && (bl || pSUACAppTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUACAppTypeBase.getMemo());
        }
        if (pSUACAppTypeBase.isPSUACAppTypeIdDirty() && (bl || pSUACAppTypeBase.getPSUACAppTypeId() != null)) {
            iDataObject.set(FIELD_PSUACAPPTYPEID, (Object)pSUACAppTypeBase.getPSUACAppTypeId());
        }
        if (pSUACAppTypeBase.isPSUACAppTypeNameDirty() && (bl || pSUACAppTypeBase.getPSUACAppTypeName() != null)) {
            iDataObject.set(FIELD_PSUACAPPTYPENAME, (Object)pSUACAppTypeBase.getPSUACAppTypeName());
        }
        if (pSUACAppTypeBase.isUpdateDateDirty() && (bl || pSUACAppTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUACAppTypeBase.getUpdateDate());
        }
        if (pSUACAppTypeBase.isUpdateManDirty() && (bl || pSUACAppTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUACAppTypeBase.getUpdateMan());
        }
        if (pSUACAppTypeBase.isValidFlagDirty() && (bl || pSUACAppTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUACAppTypeBase.getValidFlag());
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
        return PSUACAppTypeBase.remove(this, n);
    }

    private static boolean remove(PSUACAppTypeBase pSUACAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUACAppTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUACAppTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUACAppTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSUACAppTypeBase.resetPSUACAppTypeId();
                return true;
            }
            case 4: {
                pSUACAppTypeBase.resetPSUACAppTypeName();
                return true;
            }
            case 5: {
                pSUACAppTypeBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSUACAppTypeBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSUACAppTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUACAppTypeBase getProxyEntity() {
        return this.proxyPSUACAppTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUACAppTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSUACAppTypeBase) {
            this.proxyPSUACAppTypeBase = (PSUACAppTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUACAppTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSUACAPPTYPEID, 3);
        fieldIndexMap.put(FIELD_PSUACAPPTYPENAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_VALIDFLAG, 7);
    }
}

