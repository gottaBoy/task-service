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

public abstract class PSListItemTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSListItemTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ITEMTOBJ = "ITEMTOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSLISTITEMTYPEID = "PSLISTITEMTYPEID";
    public static final String FIELD_PSLISTITEMTYPENAME = "PSLISTITEMTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 2;
    private static final int INDEX_ITEMTOBJ = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSLISTITEMTYPEID = 5;
    private static final int INDEX_PSLISTITEMTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSListItemTypeBase proxyPSListItemTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean itemtobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pslistitemtypeidDirtyFlag = false;
    private boolean pslistitemtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="itemtobj")
    private String itemtobj;
    @Column(name="memo")
    private String memo;
    @Column(name="pslistitemtypeid")
    private String pslistitemtypeid;
    @Column(name="pslistitemtypename")
    private String pslistitemtypename;
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

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setITEMTOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setITEMTOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtobj = string;
        this.itemtobjDirtyFlag = true;
    }

    public String getITEMTOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getITEMTOBJ();
        }
        return this.itemtobj;
    }

    public boolean isITEMTOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isITEMTOBJDirty();
        }
        return this.itemtobjDirtyFlag;
    }

    public void resetITEMTOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetITEMTOBJ();
            return;
        }
        this.itemtobjDirtyFlag = false;
        this.itemtobj = null;
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

    public void setPSLISTITEMTypeID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLISTITEMTypeID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslistitemtypeid = string;
        this.pslistitemtypeidDirtyFlag = true;
    }

    public String getPSLISTITEMTypeID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLISTITEMTypeID();
        }
        return this.pslistitemtypeid;
    }

    public boolean isPSLISTITEMTypeIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLISTITEMTypeIDDirty();
        }
        return this.pslistitemtypeidDirtyFlag;
    }

    public void resetPSLISTITEMTypeID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLISTITEMTypeID();
            return;
        }
        this.pslistitemtypeidDirtyFlag = false;
        this.pslistitemtypeid = null;
    }

    public void setPSLISTITEMTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLISTITEMTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslistitemtypename = string;
        this.pslistitemtypenameDirtyFlag = true;
    }

    public String getPSLISTITEMTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLISTITEMTypeName();
        }
        return this.pslistitemtypename;
    }

    public boolean isPSLISTITEMTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLISTITEMTypeNameDirty();
        }
        return this.pslistitemtypenameDirtyFlag;
    }

    public void resetPSLISTITEMTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLISTITEMTypeName();
            return;
        }
        this.pslistitemtypenameDirtyFlag = false;
        this.pslistitemtypename = null;
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
        PSListItemTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSListItemTypeBase pSListItemTypeBase) {
        pSListItemTypeBase.resetCreateDate();
        pSListItemTypeBase.resetCreateMan();
        pSListItemTypeBase.resetEnable();
        pSListItemTypeBase.resetITEMTOBJ();
        pSListItemTypeBase.resetMemo();
        pSListItemTypeBase.resetPSLISTITEMTypeID();
        pSListItemTypeBase.resetPSLISTITEMTypeName();
        pSListItemTypeBase.resetUpdateDate();
        pSListItemTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isITEMTOBJDirty()) {
            hashMap.put(FIELD_ITEMTOBJ, this.getITEMTOBJ());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSLISTITEMTypeIDDirty()) {
            hashMap.put(FIELD_PSLISTITEMTYPEID, this.getPSLISTITEMTypeID());
        }
        if (!bl || this.isPSLISTITEMTypeNameDirty()) {
            hashMap.put(FIELD_PSLISTITEMTYPENAME, this.getPSLISTITEMTypeName());
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
        return PSListItemTypeBase.get(this, n);
    }

    private static Object get(PSListItemTypeBase pSListItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSListItemTypeBase.getCreateDate();
            }
            case 1: {
                return pSListItemTypeBase.getCreateMan();
            }
            case 2: {
                return pSListItemTypeBase.getEnable();
            }
            case 3: {
                return pSListItemTypeBase.getITEMTOBJ();
            }
            case 4: {
                return pSListItemTypeBase.getMemo();
            }
            case 5: {
                return pSListItemTypeBase.getPSLISTITEMTypeID();
            }
            case 6: {
                return pSListItemTypeBase.getPSLISTITEMTypeName();
            }
            case 7: {
                return pSListItemTypeBase.getUpdateDate();
            }
            case 8: {
                return pSListItemTypeBase.getUpdateMan();
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
        PSListItemTypeBase.set(this, n, object);
    }

    private static void set(PSListItemTypeBase pSListItemTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSListItemTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSListItemTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSListItemTypeBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSListItemTypeBase.setITEMTOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSListItemTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSListItemTypeBase.setPSLISTITEMTypeID(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSListItemTypeBase.setPSLISTITEMTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSListItemTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSListItemTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSListItemTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSListItemTypeBase pSListItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSListItemTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSListItemTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSListItemTypeBase.getEnable() == null;
            }
            case 3: {
                return pSListItemTypeBase.getITEMTOBJ() == null;
            }
            case 4: {
                return pSListItemTypeBase.getMemo() == null;
            }
            case 5: {
                return pSListItemTypeBase.getPSLISTITEMTypeID() == null;
            }
            case 6: {
                return pSListItemTypeBase.getPSLISTITEMTypeName() == null;
            }
            case 7: {
                return pSListItemTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSListItemTypeBase.getUpdateMan() == null;
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
        return PSListItemTypeBase.contains(this, n);
    }

    private static boolean contains(PSListItemTypeBase pSListItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSListItemTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSListItemTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSListItemTypeBase.isEnableDirty();
            }
            case 3: {
                return pSListItemTypeBase.isITEMTOBJDirty();
            }
            case 4: {
                return pSListItemTypeBase.isMemoDirty();
            }
            case 5: {
                return pSListItemTypeBase.isPSLISTITEMTypeIDDirty();
            }
            case 6: {
                return pSListItemTypeBase.isPSLISTITEMTypeNameDirty();
            }
            case 7: {
                return pSListItemTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSListItemTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSListItemTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSListItemTypeBase pSListItemTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSListItemTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getEnable()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getITEMTOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtobj", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getITEMTOBJ()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getPSLISTITEMTypeID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslistitemtypeid", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getPSLISTITEMTypeID()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getPSLISTITEMTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslistitemtypename", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getPSLISTITEMTypeName()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSListItemTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSListItemTypeBase.getJSONValue((Object)pSListItemTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSListItemTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSListItemTypeBase pSListItemTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSListItemTypeBase.getCreateDate() != null) {
            object = pSListItemTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSListItemTypeBase.getCreateMan() != null) {
            object = pSListItemTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSListItemTypeBase.getEnable() != null) {
            object = pSListItemTypeBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSListItemTypeBase.getITEMTOBJ() != null) {
            object = pSListItemTypeBase.getITEMTOBJ();
            xmlNode.setAttribute(FIELD_ITEMTOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSListItemTypeBase.getMemo() != null) {
            object = pSListItemTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSListItemTypeBase.getPSLISTITEMTypeID() != null) {
            object = pSListItemTypeBase.getPSLISTITEMTypeID();
            xmlNode.setAttribute(FIELD_PSLISTITEMTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSListItemTypeBase.getPSLISTITEMTypeName() != null) {
            object = pSListItemTypeBase.getPSLISTITEMTypeName();
            xmlNode.setAttribute(FIELD_PSLISTITEMTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSListItemTypeBase.getUpdateDate() != null) {
            object = pSListItemTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSListItemTypeBase.getUpdateMan() != null) {
            object = pSListItemTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSListItemTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSListItemTypeBase pSListItemTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSListItemTypeBase.isCreateDateDirty() && (bl || pSListItemTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSListItemTypeBase.getCreateDate());
        }
        if (pSListItemTypeBase.isCreateManDirty() && (bl || pSListItemTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSListItemTypeBase.getCreateMan());
        }
        if (pSListItemTypeBase.isEnableDirty() && (bl || pSListItemTypeBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSListItemTypeBase.getEnable());
        }
        if (pSListItemTypeBase.isITEMTOBJDirty() && (bl || pSListItemTypeBase.getITEMTOBJ() != null)) {
            iDataObject.set(FIELD_ITEMTOBJ, (Object)pSListItemTypeBase.getITEMTOBJ());
        }
        if (pSListItemTypeBase.isMemoDirty() && (bl || pSListItemTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSListItemTypeBase.getMemo());
        }
        if (pSListItemTypeBase.isPSLISTITEMTypeIDDirty() && (bl || pSListItemTypeBase.getPSLISTITEMTypeID() != null)) {
            iDataObject.set(FIELD_PSLISTITEMTYPEID, (Object)pSListItemTypeBase.getPSLISTITEMTypeID());
        }
        if (pSListItemTypeBase.isPSLISTITEMTypeNameDirty() && (bl || pSListItemTypeBase.getPSLISTITEMTypeName() != null)) {
            iDataObject.set(FIELD_PSLISTITEMTYPENAME, (Object)pSListItemTypeBase.getPSLISTITEMTypeName());
        }
        if (pSListItemTypeBase.isUpdateDateDirty() && (bl || pSListItemTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSListItemTypeBase.getUpdateDate());
        }
        if (pSListItemTypeBase.isUpdateManDirty() && (bl || pSListItemTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSListItemTypeBase.getUpdateMan());
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
        return PSListItemTypeBase.remove(this, n);
    }

    private static boolean remove(PSListItemTypeBase pSListItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSListItemTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSListItemTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSListItemTypeBase.resetEnable();
                return true;
            }
            case 3: {
                pSListItemTypeBase.resetITEMTOBJ();
                return true;
            }
            case 4: {
                pSListItemTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSListItemTypeBase.resetPSLISTITEMTypeID();
                return true;
            }
            case 6: {
                pSListItemTypeBase.resetPSLISTITEMTypeName();
                return true;
            }
            case 7: {
                pSListItemTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSListItemTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSListItemTypeBase getProxyEntity() {
        return this.proxyPSListItemTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSListItemTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSListItemTypeBase) {
            this.proxyPSListItemTypeBase = (PSListItemTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSListItemTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 2);
        fieldIndexMap.put(FIELD_ITEMTOBJ, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSLISTITEMTYPEID, 5);
        fieldIndexMap.put(FIELD_PSLISTITEMTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

