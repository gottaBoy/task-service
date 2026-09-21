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

public abstract class PSWFLinkCondTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFLinkCondTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSWFLINKCONDTYPEID = "PSWFLINKCONDTYPEID";
    public static final String FIELD_PSWFLINKCONDTYPENAME = "PSWFLINKCONDTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSWFLINKCONDTYPEID = 4;
    private static final int INDEX_PSWFLINKCONDTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFLinkCondTypeBase proxyPSWFLinkCondTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pswflinkcondtypeidDirtyFlag = false;
    private boolean pswflinkcondtypenameDirtyFlag = false;
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
    @Column(name="pswflinkcondtypeid")
    private String pswflinkcondtypeid;
    @Column(name="pswflinkcondtypename")
    private String pswflinkcondtypename;
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

    public void setPSWFLinkCondTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkCondTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkcondtypeid = string;
        this.pswflinkcondtypeidDirtyFlag = true;
    }

    public String getPSWFLinkCondTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkCondTypeId();
        }
        return this.pswflinkcondtypeid;
    }

    public boolean isPSWFLinkCondTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkCondTypeIdDirty();
        }
        return this.pswflinkcondtypeidDirtyFlag;
    }

    public void resetPSWFLinkCondTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkCondTypeId();
            return;
        }
        this.pswflinkcondtypeidDirtyFlag = false;
        this.pswflinkcondtypeid = null;
    }

    public void setPSWFLinkCondTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkCondTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkcondtypename = string;
        this.pswflinkcondtypenameDirtyFlag = true;
    }

    public String getPSWFLinkCondTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkCondTypeName();
        }
        return this.pswflinkcondtypename;
    }

    public boolean isPSWFLinkCondTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkCondTypeNameDirty();
        }
        return this.pswflinkcondtypenameDirtyFlag;
    }

    public void resetPSWFLinkCondTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkCondTypeName();
            return;
        }
        this.pswflinkcondtypenameDirtyFlag = false;
        this.pswflinkcondtypename = null;
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
        PSWFLinkCondTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFLinkCondTypeBase pSWFLinkCondTypeBase) {
        pSWFLinkCondTypeBase.resetCreateDate();
        pSWFLinkCondTypeBase.resetCreateMan();
        pSWFLinkCondTypeBase.resetItemObj();
        pSWFLinkCondTypeBase.resetMemo();
        pSWFLinkCondTypeBase.resetPSWFLinkCondTypeId();
        pSWFLinkCondTypeBase.resetPSWFLinkCondTypeName();
        pSWFLinkCondTypeBase.resetUpdateDate();
        pSWFLinkCondTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSWFLinkCondTypeIdDirty()) {
            hashMap.put(FIELD_PSWFLINKCONDTYPEID, this.getPSWFLinkCondTypeId());
        }
        if (!bl || this.isPSWFLinkCondTypeNameDirty()) {
            hashMap.put(FIELD_PSWFLINKCONDTYPENAME, this.getPSWFLinkCondTypeName());
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
        return PSWFLinkCondTypeBase.get(this, n);
    }

    private static Object get(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkCondTypeBase.getCreateDate();
            }
            case 1: {
                return pSWFLinkCondTypeBase.getCreateMan();
            }
            case 2: {
                return pSWFLinkCondTypeBase.getItemObj();
            }
            case 3: {
                return pSWFLinkCondTypeBase.getMemo();
            }
            case 4: {
                return pSWFLinkCondTypeBase.getPSWFLinkCondTypeId();
            }
            case 5: {
                return pSWFLinkCondTypeBase.getPSWFLinkCondTypeName();
            }
            case 6: {
                return pSWFLinkCondTypeBase.getUpdateDate();
            }
            case 7: {
                return pSWFLinkCondTypeBase.getUpdateMan();
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
        PSWFLinkCondTypeBase.set(this, n, object);
    }

    private static void set(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkCondTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWFLinkCondTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFLinkCondTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFLinkCondTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFLinkCondTypeBase.setPSWFLinkCondTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFLinkCondTypeBase.setPSWFLinkCondTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFLinkCondTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSWFLinkCondTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWFLinkCondTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkCondTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSWFLinkCondTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSWFLinkCondTypeBase.getItemObj() == null;
            }
            case 3: {
                return pSWFLinkCondTypeBase.getMemo() == null;
            }
            case 4: {
                return pSWFLinkCondTypeBase.getPSWFLinkCondTypeId() == null;
            }
            case 5: {
                return pSWFLinkCondTypeBase.getPSWFLinkCondTypeName() == null;
            }
            case 6: {
                return pSWFLinkCondTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSWFLinkCondTypeBase.getUpdateMan() == null;
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
        return PSWFLinkCondTypeBase.contains(this, n);
    }

    private static boolean contains(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkCondTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSWFLinkCondTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSWFLinkCondTypeBase.isItemObjDirty();
            }
            case 3: {
                return pSWFLinkCondTypeBase.isMemoDirty();
            }
            case 4: {
                return pSWFLinkCondTypeBase.isPSWFLinkCondTypeIdDirty();
            }
            case 5: {
                return pSWFLinkCondTypeBase.isPSWFLinkCondTypeNameDirty();
            }
            case 6: {
                return pSWFLinkCondTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSWFLinkCondTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFLinkCondTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFLinkCondTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFLinkCondTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFLinkCondTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSWFLinkCondTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFLinkCondTypeBase.getPSWFLinkCondTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkcondtypeid", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getPSWFLinkCondTypeId()), (boolean)false);
        }
        if (bl || pSWFLinkCondTypeBase.getPSWFLinkCondTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkcondtypename", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getPSWFLinkCondTypeName()), (boolean)false);
        }
        if (bl || pSWFLinkCondTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFLinkCondTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFLinkCondTypeBase.getJSONValue((Object)pSWFLinkCondTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFLinkCondTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFLinkCondTypeBase.getCreateDate() != null) {
            object = pSWFLinkCondTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkCondTypeBase.getCreateMan() != null) {
            object = pSWFLinkCondTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondTypeBase.getItemObj() != null) {
            object = pSWFLinkCondTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondTypeBase.getMemo() != null) {
            object = pSWFLinkCondTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondTypeBase.getPSWFLinkCondTypeId() != null) {
            object = pSWFLinkCondTypeBase.getPSWFLinkCondTypeId();
            xmlNode.setAttribute(FIELD_PSWFLINKCONDTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondTypeBase.getPSWFLinkCondTypeName() != null) {
            object = pSWFLinkCondTypeBase.getPSWFLinkCondTypeName();
            xmlNode.setAttribute(FIELD_PSWFLINKCONDTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondTypeBase.getUpdateDate() != null) {
            object = pSWFLinkCondTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkCondTypeBase.getUpdateMan() != null) {
            object = pSWFLinkCondTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFLinkCondTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFLinkCondTypeBase.isCreateDateDirty() && (bl || pSWFLinkCondTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFLinkCondTypeBase.getCreateDate());
        }
        if (pSWFLinkCondTypeBase.isCreateManDirty() && (bl || pSWFLinkCondTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFLinkCondTypeBase.getCreateMan());
        }
        if (pSWFLinkCondTypeBase.isItemObjDirty() && (bl || pSWFLinkCondTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSWFLinkCondTypeBase.getItemObj());
        }
        if (pSWFLinkCondTypeBase.isMemoDirty() && (bl || pSWFLinkCondTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFLinkCondTypeBase.getMemo());
        }
        if (pSWFLinkCondTypeBase.isPSWFLinkCondTypeIdDirty() && (bl || pSWFLinkCondTypeBase.getPSWFLinkCondTypeId() != null)) {
            iDataObject.set(FIELD_PSWFLINKCONDTYPEID, (Object)pSWFLinkCondTypeBase.getPSWFLinkCondTypeId());
        }
        if (pSWFLinkCondTypeBase.isPSWFLinkCondTypeNameDirty() && (bl || pSWFLinkCondTypeBase.getPSWFLinkCondTypeName() != null)) {
            iDataObject.set(FIELD_PSWFLINKCONDTYPENAME, (Object)pSWFLinkCondTypeBase.getPSWFLinkCondTypeName());
        }
        if (pSWFLinkCondTypeBase.isUpdateDateDirty() && (bl || pSWFLinkCondTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFLinkCondTypeBase.getUpdateDate());
        }
        if (pSWFLinkCondTypeBase.isUpdateManDirty() && (bl || pSWFLinkCondTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFLinkCondTypeBase.getUpdateMan());
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
        return PSWFLinkCondTypeBase.remove(this, n);
    }

    private static boolean remove(PSWFLinkCondTypeBase pSWFLinkCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkCondTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWFLinkCondTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWFLinkCondTypeBase.resetItemObj();
                return true;
            }
            case 3: {
                pSWFLinkCondTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSWFLinkCondTypeBase.resetPSWFLinkCondTypeId();
                return true;
            }
            case 5: {
                pSWFLinkCondTypeBase.resetPSWFLinkCondTypeName();
                return true;
            }
            case 6: {
                pSWFLinkCondTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSWFLinkCondTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSWFLinkCondTypeBase getProxyEntity() {
        return this.proxyPSWFLinkCondTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFLinkCondTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFLinkCondTypeBase) {
            this.proxyPSWFLinkCondTypeBase = (PSWFLinkCondTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSWFLinkCondTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSWFLINKCONDTYPEID, 4);
        fieldIndexMap.put(FIELD_PSWFLINKCONDTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

