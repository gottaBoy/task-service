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

public abstract class PSPILogicTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPILogicTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPILOGICTYPEID = "PSPILOGICTYPEID";
    public static final String FIELD_PSPILOGICTYPENAME = "PSPILOGICTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSPILOGICTYPEID = 4;
    private static final int INDEX_PSPILOGICTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPILogicTypeBase proxyPSPILogicTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspilogictypeidDirtyFlag = false;
    private boolean pspilogictypenameDirtyFlag = false;
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
    @Column(name="pspilogictypeid")
    private String pspilogictypeid;
    @Column(name="pspilogictypename")
    private String pspilogictypename;
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

    public void setPSPILogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPILogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspilogictypeid = string;
        this.pspilogictypeidDirtyFlag = true;
    }

    public String getPSPILogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPILogicTypeId();
        }
        return this.pspilogictypeid;
    }

    public boolean isPSPILogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPILogicTypeIdDirty();
        }
        return this.pspilogictypeidDirtyFlag;
    }

    public void resetPSPILogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPILogicTypeId();
            return;
        }
        this.pspilogictypeidDirtyFlag = false;
        this.pspilogictypeid = null;
    }

    public void setPSPILogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPILogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspilogictypename = string;
        this.pspilogictypenameDirtyFlag = true;
    }

    public String getPSPILogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPILogicTypeName();
        }
        return this.pspilogictypename;
    }

    public boolean isPSPILogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPILogicTypeNameDirty();
        }
        return this.pspilogictypenameDirtyFlag;
    }

    public void resetPSPILogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPILogicTypeName();
            return;
        }
        this.pspilogictypenameDirtyFlag = false;
        this.pspilogictypename = null;
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
        PSPILogicTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPILogicTypeBase pSPILogicTypeBase) {
        pSPILogicTypeBase.resetCreateDate();
        pSPILogicTypeBase.resetCreateMan();
        pSPILogicTypeBase.resetItemObj();
        pSPILogicTypeBase.resetMemo();
        pSPILogicTypeBase.resetPSPILogicTypeId();
        pSPILogicTypeBase.resetPSPILogicTypeName();
        pSPILogicTypeBase.resetUpdateDate();
        pSPILogicTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSPILogicTypeIdDirty()) {
            hashMap.put(FIELD_PSPILOGICTYPEID, this.getPSPILogicTypeId());
        }
        if (!bl || this.isPSPILogicTypeNameDirty()) {
            hashMap.put(FIELD_PSPILOGICTYPENAME, this.getPSPILogicTypeName());
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
        return PSPILogicTypeBase.get(this, n);
    }

    private static Object get(PSPILogicTypeBase pSPILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPILogicTypeBase.getCreateDate();
            }
            case 1: {
                return pSPILogicTypeBase.getCreateMan();
            }
            case 2: {
                return pSPILogicTypeBase.getItemObj();
            }
            case 3: {
                return pSPILogicTypeBase.getMemo();
            }
            case 4: {
                return pSPILogicTypeBase.getPSPILogicTypeId();
            }
            case 5: {
                return pSPILogicTypeBase.getPSPILogicTypeName();
            }
            case 6: {
                return pSPILogicTypeBase.getUpdateDate();
            }
            case 7: {
                return pSPILogicTypeBase.getUpdateMan();
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
        PSPILogicTypeBase.set(this, n, object);
    }

    private static void set(PSPILogicTypeBase pSPILogicTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPILogicTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPILogicTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPILogicTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPILogicTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPILogicTypeBase.setPSPILogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPILogicTypeBase.setPSPILogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPILogicTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSPILogicTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPILogicTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPILogicTypeBase pSPILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPILogicTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPILogicTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPILogicTypeBase.getItemObj() == null;
            }
            case 3: {
                return pSPILogicTypeBase.getMemo() == null;
            }
            case 4: {
                return pSPILogicTypeBase.getPSPILogicTypeId() == null;
            }
            case 5: {
                return pSPILogicTypeBase.getPSPILogicTypeName() == null;
            }
            case 6: {
                return pSPILogicTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSPILogicTypeBase.getUpdateMan() == null;
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
        return PSPILogicTypeBase.contains(this, n);
    }

    private static boolean contains(PSPILogicTypeBase pSPILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPILogicTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPILogicTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPILogicTypeBase.isItemObjDirty();
            }
            case 3: {
                return pSPILogicTypeBase.isMemoDirty();
            }
            case 4: {
                return pSPILogicTypeBase.isPSPILogicTypeIdDirty();
            }
            case 5: {
                return pSPILogicTypeBase.isPSPILogicTypeNameDirty();
            }
            case 6: {
                return pSPILogicTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSPILogicTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPILogicTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPILogicTypeBase pSPILogicTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPILogicTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPILogicTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPILogicTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSPILogicTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPILogicTypeBase.getPSPILogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspilogictypeid", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getPSPILogicTypeId()), (boolean)false);
        }
        if (bl || pSPILogicTypeBase.getPSPILogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspilogictypename", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getPSPILogicTypeName()), (boolean)false);
        }
        if (bl || pSPILogicTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPILogicTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPILogicTypeBase.getJSONValue((Object)pSPILogicTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPILogicTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPILogicTypeBase pSPILogicTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPILogicTypeBase.getCreateDate() != null) {
            object = pSPILogicTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPILogicTypeBase.getCreateMan() != null) {
            object = pSPILogicTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPILogicTypeBase.getItemObj() != null) {
            object = pSPILogicTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPILogicTypeBase.getMemo() != null) {
            object = pSPILogicTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPILogicTypeBase.getPSPILogicTypeId() != null) {
            object = pSPILogicTypeBase.getPSPILogicTypeId();
            xmlNode.setAttribute(FIELD_PSPILOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPILogicTypeBase.getPSPILogicTypeName() != null) {
            object = pSPILogicTypeBase.getPSPILogicTypeName();
            xmlNode.setAttribute(FIELD_PSPILOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPILogicTypeBase.getUpdateDate() != null) {
            object = pSPILogicTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPILogicTypeBase.getUpdateMan() != null) {
            object = pSPILogicTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPILogicTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPILogicTypeBase pSPILogicTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPILogicTypeBase.isCreateDateDirty() && (bl || pSPILogicTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPILogicTypeBase.getCreateDate());
        }
        if (pSPILogicTypeBase.isCreateManDirty() && (bl || pSPILogicTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPILogicTypeBase.getCreateMan());
        }
        if (pSPILogicTypeBase.isItemObjDirty() && (bl || pSPILogicTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSPILogicTypeBase.getItemObj());
        }
        if (pSPILogicTypeBase.isMemoDirty() && (bl || pSPILogicTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPILogicTypeBase.getMemo());
        }
        if (pSPILogicTypeBase.isPSPILogicTypeIdDirty() && (bl || pSPILogicTypeBase.getPSPILogicTypeId() != null)) {
            iDataObject.set(FIELD_PSPILOGICTYPEID, (Object)pSPILogicTypeBase.getPSPILogicTypeId());
        }
        if (pSPILogicTypeBase.isPSPILogicTypeNameDirty() && (bl || pSPILogicTypeBase.getPSPILogicTypeName() != null)) {
            iDataObject.set(FIELD_PSPILOGICTYPENAME, (Object)pSPILogicTypeBase.getPSPILogicTypeName());
        }
        if (pSPILogicTypeBase.isUpdateDateDirty() && (bl || pSPILogicTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPILogicTypeBase.getUpdateDate());
        }
        if (pSPILogicTypeBase.isUpdateManDirty() && (bl || pSPILogicTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPILogicTypeBase.getUpdateMan());
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
        return PSPILogicTypeBase.remove(this, n);
    }

    private static boolean remove(PSPILogicTypeBase pSPILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPILogicTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPILogicTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPILogicTypeBase.resetItemObj();
                return true;
            }
            case 3: {
                pSPILogicTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSPILogicTypeBase.resetPSPILogicTypeId();
                return true;
            }
            case 5: {
                pSPILogicTypeBase.resetPSPILogicTypeName();
                return true;
            }
            case 6: {
                pSPILogicTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSPILogicTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPILogicTypeBase getProxyEntity() {
        return this.proxyPSPILogicTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPILogicTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPILogicTypeBase) {
            this.proxyPSPILogicTypeBase = (PSPILogicTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPILogicTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSPILOGICTYPEID, 4);
        fieldIndexMap.put(FIELD_PSPILOGICTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

