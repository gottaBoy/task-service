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
package net.ibizsys.pscore.srv.def.entity;

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

public abstract class PSTBItemTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSTBItemTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSTBITEMTYPEID = "PSTBITEMTYPEID";
    public static final String FIELD_PSTBITEMTYPENAME = "PSTBITEMTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSTBITEMTYPEID = 4;
    private static final int INDEX_PSTBITEMTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSTBItemTypeBase proxyPSTBItemTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pstbitemtypeidDirtyFlag = false;
    private boolean pstbitemtypenameDirtyFlag = false;
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
    @Column(name="pstbitemtypeid")
    private String pstbitemtypeid;
    @Column(name="pstbitemtypename")
    private String pstbitemtypename;
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

    public void setPSTBItemTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTBItemTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstbitemtypeid = string;
        this.pstbitemtypeidDirtyFlag = true;
    }

    public String getPSTBItemTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTBItemTypeId();
        }
        return this.pstbitemtypeid;
    }

    public boolean isPSTBItemTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTBItemTypeIdDirty();
        }
        return this.pstbitemtypeidDirtyFlag;
    }

    public void resetPSTBItemTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTBItemTypeId();
            return;
        }
        this.pstbitemtypeidDirtyFlag = false;
        this.pstbitemtypeid = null;
    }

    public void setPSTBItemTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTBItemTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstbitemtypename = string;
        this.pstbitemtypenameDirtyFlag = true;
    }

    public String getPSTBItemTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTBItemTypeName();
        }
        return this.pstbitemtypename;
    }

    public boolean isPSTBItemTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTBItemTypeNameDirty();
        }
        return this.pstbitemtypenameDirtyFlag;
    }

    public void resetPSTBItemTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTBItemTypeName();
            return;
        }
        this.pstbitemtypenameDirtyFlag = false;
        this.pstbitemtypename = null;
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
        PSTBItemTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSTBItemTypeBase pSTBItemTypeBase) {
        pSTBItemTypeBase.resetCreateDate();
        pSTBItemTypeBase.resetCreateMan();
        pSTBItemTypeBase.resetItemObj();
        pSTBItemTypeBase.resetMemo();
        pSTBItemTypeBase.resetPSTBItemTypeId();
        pSTBItemTypeBase.resetPSTBItemTypeName();
        pSTBItemTypeBase.resetUpdateDate();
        pSTBItemTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSTBItemTypeIdDirty()) {
            hashMap.put(FIELD_PSTBITEMTYPEID, this.getPSTBItemTypeId());
        }
        if (!bl || this.isPSTBItemTypeNameDirty()) {
            hashMap.put(FIELD_PSTBITEMTYPENAME, this.getPSTBItemTypeName());
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
        return PSTBItemTypeBase.get(this, n);
    }

    private static Object get(PSTBItemTypeBase pSTBItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTBItemTypeBase.getCreateDate();
            }
            case 1: {
                return pSTBItemTypeBase.getCreateMan();
            }
            case 2: {
                return pSTBItemTypeBase.getItemObj();
            }
            case 3: {
                return pSTBItemTypeBase.getMemo();
            }
            case 4: {
                return pSTBItemTypeBase.getPSTBItemTypeId();
            }
            case 5: {
                return pSTBItemTypeBase.getPSTBItemTypeName();
            }
            case 6: {
                return pSTBItemTypeBase.getUpdateDate();
            }
            case 7: {
                return pSTBItemTypeBase.getUpdateMan();
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
        PSTBItemTypeBase.set(this, n, object);
    }

    private static void set(PSTBItemTypeBase pSTBItemTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSTBItemTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSTBItemTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSTBItemTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSTBItemTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSTBItemTypeBase.setPSTBItemTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSTBItemTypeBase.setPSTBItemTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSTBItemTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSTBItemTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSTBItemTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSTBItemTypeBase pSTBItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTBItemTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSTBItemTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSTBItemTypeBase.getItemObj() == null;
            }
            case 3: {
                return pSTBItemTypeBase.getMemo() == null;
            }
            case 4: {
                return pSTBItemTypeBase.getPSTBItemTypeId() == null;
            }
            case 5: {
                return pSTBItemTypeBase.getPSTBItemTypeName() == null;
            }
            case 6: {
                return pSTBItemTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSTBItemTypeBase.getUpdateMan() == null;
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
        return PSTBItemTypeBase.contains(this, n);
    }

    private static boolean contains(PSTBItemTypeBase pSTBItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTBItemTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSTBItemTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSTBItemTypeBase.isItemObjDirty();
            }
            case 3: {
                return pSTBItemTypeBase.isMemoDirty();
            }
            case 4: {
                return pSTBItemTypeBase.isPSTBItemTypeIdDirty();
            }
            case 5: {
                return pSTBItemTypeBase.isPSTBItemTypeNameDirty();
            }
            case 6: {
                return pSTBItemTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSTBItemTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSTBItemTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSTBItemTypeBase pSTBItemTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSTBItemTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSTBItemTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSTBItemTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSTBItemTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSTBItemTypeBase.getPSTBItemTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstbitemtypeid", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getPSTBItemTypeId()), (boolean)false);
        }
        if (bl || pSTBItemTypeBase.getPSTBItemTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstbitemtypename", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getPSTBItemTypeName()), (boolean)false);
        }
        if (bl || pSTBItemTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSTBItemTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSTBItemTypeBase.getJSONValue((Object)pSTBItemTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSTBItemTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSTBItemTypeBase pSTBItemTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSTBItemTypeBase.getCreateDate() != null) {
            object = pSTBItemTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTBItemTypeBase.getCreateMan() != null) {
            object = pSTBItemTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSTBItemTypeBase.getItemObj() != null) {
            object = pSTBItemTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSTBItemTypeBase.getMemo() != null) {
            object = pSTBItemTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSTBItemTypeBase.getPSTBItemTypeId() != null) {
            object = pSTBItemTypeBase.getPSTBItemTypeId();
            xmlNode.setAttribute(FIELD_PSTBITEMTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSTBItemTypeBase.getPSTBItemTypeName() != null) {
            object = pSTBItemTypeBase.getPSTBItemTypeName();
            xmlNode.setAttribute(FIELD_PSTBITEMTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSTBItemTypeBase.getUpdateDate() != null) {
            object = pSTBItemTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTBItemTypeBase.getUpdateMan() != null) {
            object = pSTBItemTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSTBItemTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSTBItemTypeBase pSTBItemTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSTBItemTypeBase.isCreateDateDirty() && (bl || pSTBItemTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSTBItemTypeBase.getCreateDate());
        }
        if (pSTBItemTypeBase.isCreateManDirty() && (bl || pSTBItemTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSTBItemTypeBase.getCreateMan());
        }
        if (pSTBItemTypeBase.isItemObjDirty() && (bl || pSTBItemTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSTBItemTypeBase.getItemObj());
        }
        if (pSTBItemTypeBase.isMemoDirty() && (bl || pSTBItemTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSTBItemTypeBase.getMemo());
        }
        if (pSTBItemTypeBase.isPSTBItemTypeIdDirty() && (bl || pSTBItemTypeBase.getPSTBItemTypeId() != null)) {
            iDataObject.set(FIELD_PSTBITEMTYPEID, (Object)pSTBItemTypeBase.getPSTBItemTypeId());
        }
        if (pSTBItemTypeBase.isPSTBItemTypeNameDirty() && (bl || pSTBItemTypeBase.getPSTBItemTypeName() != null)) {
            iDataObject.set(FIELD_PSTBITEMTYPENAME, (Object)pSTBItemTypeBase.getPSTBItemTypeName());
        }
        if (pSTBItemTypeBase.isUpdateDateDirty() && (bl || pSTBItemTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSTBItemTypeBase.getUpdateDate());
        }
        if (pSTBItemTypeBase.isUpdateManDirty() && (bl || pSTBItemTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSTBItemTypeBase.getUpdateMan());
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
        return PSTBItemTypeBase.remove(this, n);
    }

    private static boolean remove(PSTBItemTypeBase pSTBItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSTBItemTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSTBItemTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSTBItemTypeBase.resetItemObj();
                return true;
            }
            case 3: {
                pSTBItemTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSTBItemTypeBase.resetPSTBItemTypeId();
                return true;
            }
            case 5: {
                pSTBItemTypeBase.resetPSTBItemTypeName();
                return true;
            }
            case 6: {
                pSTBItemTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSTBItemTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSTBItemTypeBase getProxyEntity() {
        return this.proxyPSTBItemTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSTBItemTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSTBItemTypeBase) {
            this.proxyPSTBItemTypeBase = (PSTBItemTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSTBItemTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSTBITEMTYPEID, 4);
        fieldIndexMap.put(FIELD_PSTBITEMTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

