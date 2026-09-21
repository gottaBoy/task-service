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

public abstract class PSFDLogicTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSFDLogicTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSFDLOGICTYPEID = "PSFDLOGICTYPEID";
    public static final String FIELD_PSFDLOGICTYPENAME = "PSFDLOGICTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSFDLOGICTYPEID = 4;
    private static final int INDEX_PSFDLOGICTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSFDLogicTypeBase proxyPSFDLogicTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psfdlogictypeidDirtyFlag = false;
    private boolean psfdlogictypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemobj")
    private String itemobj;
    @Column(name="memo")
    private String memo;
    @Column(name="psfdlogictypeid")
    private String psfdlogictypeid;
    @Column(name="psfdlogictypename")
    private String psfdlogictypename;
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

    public void setItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj = string;
        this.itemobjDirtyFlag = true;
    }

    public String getItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj();
        }
        return this.itemobj;
    }

    public boolean isItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObjDirty();
        }
        return this.itemobjDirtyFlag;
    }

    public void resetItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj();
            return;
        }
        this.itemobjDirtyFlag = false;
        this.itemobj = null;
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

    public void setPSFDLogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSFDLogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psfdlogictypeid = string;
        this.psfdlogictypeidDirtyFlag = true;
    }

    public String getPSFDLogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSFDLogicTypeId();
        }
        return this.psfdlogictypeid;
    }

    public boolean isPSFDLogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSFDLogicTypeIdDirty();
        }
        return this.psfdlogictypeidDirtyFlag;
    }

    public void resetPSFDLogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSFDLogicTypeId();
            return;
        }
        this.psfdlogictypeidDirtyFlag = false;
        this.psfdlogictypeid = null;
    }

    public void setPSFDLogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSFDLogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psfdlogictypename = string;
        this.psfdlogictypenameDirtyFlag = true;
    }

    public String getPSFDLogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSFDLogicTypeName();
        }
        return this.psfdlogictypename;
    }

    public boolean isPSFDLogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSFDLogicTypeNameDirty();
        }
        return this.psfdlogictypenameDirtyFlag;
    }

    public void resetPSFDLogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSFDLogicTypeName();
            return;
        }
        this.psfdlogictypenameDirtyFlag = false;
        this.psfdlogictypename = null;
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
        PSFDLogicTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSFDLogicTypeBase pSFDLogicTypeBase) {
        pSFDLogicTypeBase.resetCreateDate();
        pSFDLogicTypeBase.resetCreateMan();
        pSFDLogicTypeBase.resetItemObj();
        pSFDLogicTypeBase.resetMemo();
        pSFDLogicTypeBase.resetPSFDLogicTypeId();
        pSFDLogicTypeBase.resetPSFDLogicTypeName();
        pSFDLogicTypeBase.resetUpdateDate();
        pSFDLogicTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isItemObjDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getItemObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSFDLogicTypeIdDirty()) {
            hashMap.put(FIELD_PSFDLOGICTYPEID, this.getPSFDLogicTypeId());
        }
        if (!bl || this.isPSFDLogicTypeNameDirty()) {
            hashMap.put(FIELD_PSFDLOGICTYPENAME, this.getPSFDLogicTypeName());
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
        return PSFDLogicTypeBase.get(this, n);
    }

    private static Object get(PSFDLogicTypeBase pSFDLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFDLogicTypeBase.getCreateDate();
            }
            case 1: {
                return pSFDLogicTypeBase.getCreateMan();
            }
            case 2: {
                return pSFDLogicTypeBase.getItemObj();
            }
            case 3: {
                return pSFDLogicTypeBase.getMemo();
            }
            case 4: {
                return pSFDLogicTypeBase.getPSFDLogicTypeId();
            }
            case 5: {
                return pSFDLogicTypeBase.getPSFDLogicTypeName();
            }
            case 6: {
                return pSFDLogicTypeBase.getUpdateDate();
            }
            case 7: {
                return pSFDLogicTypeBase.getUpdateMan();
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
        PSFDLogicTypeBase.set(this, n, object);
    }

    private static void set(PSFDLogicTypeBase pSFDLogicTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSFDLogicTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSFDLogicTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSFDLogicTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSFDLogicTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSFDLogicTypeBase.setPSFDLogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSFDLogicTypeBase.setPSFDLogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSFDLogicTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSFDLogicTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSFDLogicTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSFDLogicTypeBase pSFDLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFDLogicTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSFDLogicTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSFDLogicTypeBase.getItemObj() == null;
            }
            case 3: {
                return pSFDLogicTypeBase.getMemo() == null;
            }
            case 4: {
                return pSFDLogicTypeBase.getPSFDLogicTypeId() == null;
            }
            case 5: {
                return pSFDLogicTypeBase.getPSFDLogicTypeName() == null;
            }
            case 6: {
                return pSFDLogicTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSFDLogicTypeBase.getUpdateMan() == null;
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
        return PSFDLogicTypeBase.contains(this, n);
    }

    private static boolean contains(PSFDLogicTypeBase pSFDLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFDLogicTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSFDLogicTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSFDLogicTypeBase.isItemObjDirty();
            }
            case 3: {
                return pSFDLogicTypeBase.isMemoDirty();
            }
            case 4: {
                return pSFDLogicTypeBase.isPSFDLogicTypeIdDirty();
            }
            case 5: {
                return pSFDLogicTypeBase.isPSFDLogicTypeNameDirty();
            }
            case 6: {
                return pSFDLogicTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSFDLogicTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSFDLogicTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSFDLogicTypeBase pSFDLogicTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSFDLogicTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSFDLogicTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSFDLogicTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSFDLogicTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSFDLogicTypeBase.getPSFDLogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psfdlogictypeid", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getPSFDLogicTypeId()), (boolean)false);
        }
        if (bl || pSFDLogicTypeBase.getPSFDLogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psfdlogictypename", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getPSFDLogicTypeName()), (boolean)false);
        }
        if (bl || pSFDLogicTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSFDLogicTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSFDLogicTypeBase.getJSONValue((Object)pSFDLogicTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSFDLogicTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSFDLogicTypeBase pSFDLogicTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSFDLogicTypeBase.getCreateDate() != null) {
            object = pSFDLogicTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSFDLogicTypeBase.getCreateMan() != null) {
            object = pSFDLogicTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSFDLogicTypeBase.getItemObj() != null) {
            object = pSFDLogicTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSFDLogicTypeBase.getMemo() != null) {
            object = pSFDLogicTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSFDLogicTypeBase.getPSFDLogicTypeId() != null) {
            object = pSFDLogicTypeBase.getPSFDLogicTypeId();
            xmlNode.setAttribute(FIELD_PSFDLOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSFDLogicTypeBase.getPSFDLogicTypeName() != null) {
            object = pSFDLogicTypeBase.getPSFDLogicTypeName();
            xmlNode.setAttribute(FIELD_PSFDLOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSFDLogicTypeBase.getUpdateDate() != null) {
            object = pSFDLogicTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSFDLogicTypeBase.getUpdateMan() != null) {
            object = pSFDLogicTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSFDLogicTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSFDLogicTypeBase pSFDLogicTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSFDLogicTypeBase.isCreateDateDirty() && (bl || pSFDLogicTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSFDLogicTypeBase.getCreateDate());
        }
        if (pSFDLogicTypeBase.isCreateManDirty() && (bl || pSFDLogicTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSFDLogicTypeBase.getCreateMan());
        }
        if (pSFDLogicTypeBase.isItemObjDirty() && (bl || pSFDLogicTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSFDLogicTypeBase.getItemObj());
        }
        if (pSFDLogicTypeBase.isMemoDirty() && (bl || pSFDLogicTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSFDLogicTypeBase.getMemo());
        }
        if (pSFDLogicTypeBase.isPSFDLogicTypeIdDirty() && (bl || pSFDLogicTypeBase.getPSFDLogicTypeId() != null)) {
            iDataObject.set(FIELD_PSFDLOGICTYPEID, (Object)pSFDLogicTypeBase.getPSFDLogicTypeId());
        }
        if (pSFDLogicTypeBase.isPSFDLogicTypeNameDirty() && (bl || pSFDLogicTypeBase.getPSFDLogicTypeName() != null)) {
            iDataObject.set(FIELD_PSFDLOGICTYPENAME, (Object)pSFDLogicTypeBase.getPSFDLogicTypeName());
        }
        if (pSFDLogicTypeBase.isUpdateDateDirty() && (bl || pSFDLogicTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSFDLogicTypeBase.getUpdateDate());
        }
        if (pSFDLogicTypeBase.isUpdateManDirty() && (bl || pSFDLogicTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSFDLogicTypeBase.getUpdateMan());
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
        return PSFDLogicTypeBase.remove(this, n);
    }

    private static boolean remove(PSFDLogicTypeBase pSFDLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSFDLogicTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSFDLogicTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSFDLogicTypeBase.resetItemObj();
                return true;
            }
            case 3: {
                pSFDLogicTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSFDLogicTypeBase.resetPSFDLogicTypeId();
                return true;
            }
            case 5: {
                pSFDLogicTypeBase.resetPSFDLogicTypeName();
                return true;
            }
            case 6: {
                pSFDLogicTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSFDLogicTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSFDLogicTypeBase getProxyEntity() {
        return this.proxyPSFDLogicTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSFDLogicTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSFDLogicTypeBase) {
            this.proxyPSFDLogicTypeBase = (PSFDLogicTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSFDLogicTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSFDLOGICTYPEID, 4);
        fieldIndexMap.put(FIELD_PSFDLOGICTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

