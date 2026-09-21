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

public abstract class PSUnitBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUnitBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSUNITID = "PSUNITID";
    public static final String FIELD_PSUNITNAME = "PSUNITNAME";
    public static final String FIELD_UNITWIDTH = "UNITWIDTH";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSUNITID = 3;
    private static final int INDEX_PSUNITNAME = 4;
    private static final int INDEX_UNITWIDTH = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUnitBase proxyPSUnitBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psunitidDirtyFlag = false;
    private boolean psunitnameDirtyFlag = false;
    private boolean unitwidthDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psunitid")
    private String psunitid;
    @Column(name="psunitname")
    private String psunitname;
    @Column(name="unitwidth")
    private Integer unitwidth;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setPSUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitid = string;
        this.psunitidDirtyFlag = true;
    }

    public String getPSUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitId();
        }
        return this.psunitid;
    }

    public boolean isPSUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitIdDirty();
        }
        return this.psunitidDirtyFlag;
    }

    public void resetPSUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitId();
            return;
        }
        this.psunitidDirtyFlag = false;
        this.psunitid = null;
    }

    public void setPSUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitname = string;
        this.psunitnameDirtyFlag = true;
    }

    public String getPSUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitName();
        }
        return this.psunitname;
    }

    public boolean isPSUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitNameDirty();
        }
        return this.psunitnameDirtyFlag;
    }

    public void resetPSUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitName();
            return;
        }
        this.psunitnameDirtyFlag = false;
        this.psunitname = null;
    }

    public void setUnitWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnitWidth(n);
            return;
        }
        this.unitwidth = n;
        this.unitwidthDirtyFlag = true;
    }

    public Integer getUnitWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnitWidth();
        }
        return this.unitwidth;
    }

    public boolean isUnitWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnitWidthDirty();
        }
        return this.unitwidthDirtyFlag;
    }

    public void resetUnitWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnitWidth();
            return;
        }
        this.unitwidthDirtyFlag = false;
        this.unitwidth = null;
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
        PSUnitBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUnitBase pSUnitBase) {
        pSUnitBase.resetCreateDate();
        pSUnitBase.resetCreateMan();
        pSUnitBase.resetMemo();
        pSUnitBase.resetPSUnitId();
        pSUnitBase.resetPSUnitName();
        pSUnitBase.resetUnitWidth();
        pSUnitBase.resetUpdateDate();
        pSUnitBase.resetUpdateMan();
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
        if (!bl || this.isPSUnitIdDirty()) {
            hashMap.put(FIELD_PSUNITID, this.getPSUnitId());
        }
        if (!bl || this.isPSUnitNameDirty()) {
            hashMap.put(FIELD_PSUNITNAME, this.getPSUnitName());
        }
        if (!bl || this.isUnitWidthDirty()) {
            hashMap.put(FIELD_UNITWIDTH, this.getUnitWidth());
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
        return PSUnitBase.get(this, n);
    }

    private static Object get(PSUnitBase pSUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUnitBase.getCreateDate();
            }
            case 1: {
                return pSUnitBase.getCreateMan();
            }
            case 2: {
                return pSUnitBase.getMemo();
            }
            case 3: {
                return pSUnitBase.getPSUnitId();
            }
            case 4: {
                return pSUnitBase.getPSUnitName();
            }
            case 5: {
                return pSUnitBase.getUnitWidth();
            }
            case 6: {
                return pSUnitBase.getUpdateDate();
            }
            case 7: {
                return pSUnitBase.getUpdateMan();
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
        PSUnitBase.set(this, n, object);
    }

    private static void set(PSUnitBase pSUnitBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUnitBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUnitBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUnitBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUnitBase.setPSUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUnitBase.setPSUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUnitBase.setUnitWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSUnitBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSUnitBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUnitBase.isNull(this, n);
    }

    private static boolean isNull(PSUnitBase pSUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUnitBase.getCreateDate() == null;
            }
            case 1: {
                return pSUnitBase.getCreateMan() == null;
            }
            case 2: {
                return pSUnitBase.getMemo() == null;
            }
            case 3: {
                return pSUnitBase.getPSUnitId() == null;
            }
            case 4: {
                return pSUnitBase.getPSUnitName() == null;
            }
            case 5: {
                return pSUnitBase.getUnitWidth() == null;
            }
            case 6: {
                return pSUnitBase.getUpdateDate() == null;
            }
            case 7: {
                return pSUnitBase.getUpdateMan() == null;
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
        return PSUnitBase.contains(this, n);
    }

    private static boolean contains(PSUnitBase pSUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUnitBase.isCreateDateDirty();
            }
            case 1: {
                return pSUnitBase.isCreateManDirty();
            }
            case 2: {
                return pSUnitBase.isMemoDirty();
            }
            case 3: {
                return pSUnitBase.isPSUnitIdDirty();
            }
            case 4: {
                return pSUnitBase.isPSUnitNameDirty();
            }
            case 5: {
                return pSUnitBase.isUnitWidthDirty();
            }
            case 6: {
                return pSUnitBase.isUpdateDateDirty();
            }
            case 7: {
                return pSUnitBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUnitBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUnitBase pSUnitBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUnitBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUnitBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUnitBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getMemo()), (boolean)false);
        }
        if (bl || pSUnitBase.getPSUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitid", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getPSUnitId()), (boolean)false);
        }
        if (bl || pSUnitBase.getPSUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitname", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getPSUnitName()), (boolean)false);
        }
        if (bl || pSUnitBase.getUnitWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unitwidth", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getUnitWidth()), (boolean)false);
        }
        if (bl || pSUnitBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUnitBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUnitBase.getJSONValue((Object)pSUnitBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUnitBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUnitBase pSUnitBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUnitBase.getCreateDate() != null) {
            object = pSUnitBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUnitBase.getCreateMan() != null) {
            object = pSUnitBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUnitBase.getMemo() != null) {
            object = pSUnitBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUnitBase.getPSUnitId() != null) {
            object = pSUnitBase.getPSUnitId();
            xmlNode.setAttribute(FIELD_PSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSUnitBase.getPSUnitName() != null) {
            object = pSUnitBase.getPSUnitName();
            xmlNode.setAttribute(FIELD_PSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUnitBase.getUnitWidth() != null) {
            object = pSUnitBase.getUnitWidth();
            xmlNode.setAttribute(FIELD_UNITWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUnitBase.getUpdateDate() != null) {
            object = pSUnitBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUnitBase.getUpdateMan() != null) {
            object = pSUnitBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUnitBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUnitBase pSUnitBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUnitBase.isCreateDateDirty() && (bl || pSUnitBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUnitBase.getCreateDate());
        }
        if (pSUnitBase.isCreateManDirty() && (bl || pSUnitBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUnitBase.getCreateMan());
        }
        if (pSUnitBase.isMemoDirty() && (bl || pSUnitBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUnitBase.getMemo());
        }
        if (pSUnitBase.isPSUnitIdDirty() && (bl || pSUnitBase.getPSUnitId() != null)) {
            iDataObject.set(FIELD_PSUNITID, (Object)pSUnitBase.getPSUnitId());
        }
        if (pSUnitBase.isPSUnitNameDirty() && (bl || pSUnitBase.getPSUnitName() != null)) {
            iDataObject.set(FIELD_PSUNITNAME, (Object)pSUnitBase.getPSUnitName());
        }
        if (pSUnitBase.isUnitWidthDirty() && (bl || pSUnitBase.getUnitWidth() != null)) {
            iDataObject.set(FIELD_UNITWIDTH, (Object)pSUnitBase.getUnitWidth());
        }
        if (pSUnitBase.isUpdateDateDirty() && (bl || pSUnitBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUnitBase.getUpdateDate());
        }
        if (pSUnitBase.isUpdateManDirty() && (bl || pSUnitBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUnitBase.getUpdateMan());
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
        return PSUnitBase.remove(this, n);
    }

    private static boolean remove(PSUnitBase pSUnitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUnitBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUnitBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUnitBase.resetMemo();
                return true;
            }
            case 3: {
                pSUnitBase.resetPSUnitId();
                return true;
            }
            case 4: {
                pSUnitBase.resetPSUnitName();
                return true;
            }
            case 5: {
                pSUnitBase.resetUnitWidth();
                return true;
            }
            case 6: {
                pSUnitBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSUnitBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUnitBase getProxyEntity() {
        return this.proxyPSUnitBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUnitBase = null;
        if (iDataObject != null && iDataObject instanceof PSUnitBase) {
            this.proxyPSUnitBase = (PSUnitBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUnitService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSUNITID, 3);
        fieldIndexMap.put(FIELD_PSUNITNAME, 4);
        fieldIndexMap.put(FIELD_UNITWIDTH, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

