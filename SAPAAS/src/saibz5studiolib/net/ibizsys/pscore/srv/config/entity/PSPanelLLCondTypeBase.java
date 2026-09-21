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

public abstract class PSPanelLLCondTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLLCondTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPANELLLCONDTYPEID = "PSPANELLLCONDTYPEID";
    public static final String FIELD_PSPANELLLCONDTYPENAME = "PSPANELLLCONDTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSPANELLLCONDTYPEID = 4;
    private static final int INDEX_PSPANELLLCONDTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLLCondTypeBase proxyPSPanelLLCondTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspanelllcondtypeidDirtyFlag = false;
    private boolean pspanelllcondtypenameDirtyFlag = false;
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
    @Column(name="pspanelllcondtypeid")
    private String pspanelllcondtypeid;
    @Column(name="pspanelllcondtypename")
    private String pspanelllcondtypename;
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

    public void setPSPanelLLCondTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLLCondTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelllcondtypeid = string;
        this.pspanelllcondtypeidDirtyFlag = true;
    }

    public String getPSPanelLLCondTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLCondTypeId();
        }
        return this.pspanelllcondtypeid;
    }

    public boolean isPSPanelLLCondTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLLCondTypeIdDirty();
        }
        return this.pspanelllcondtypeidDirtyFlag;
    }

    public void resetPSPanelLLCondTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLLCondTypeId();
            return;
        }
        this.pspanelllcondtypeidDirtyFlag = false;
        this.pspanelllcondtypeid = null;
    }

    public void setPSPanelLLCondTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLLCondTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelllcondtypename = string;
        this.pspanelllcondtypenameDirtyFlag = true;
    }

    public String getPSPanelLLCondTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLCondTypeName();
        }
        return this.pspanelllcondtypename;
    }

    public boolean isPSPanelLLCondTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLLCondTypeNameDirty();
        }
        return this.pspanelllcondtypenameDirtyFlag;
    }

    public void resetPSPanelLLCondTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLLCondTypeName();
            return;
        }
        this.pspanelllcondtypenameDirtyFlag = false;
        this.pspanelllcondtypename = null;
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
        PSPanelLLCondTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLLCondTypeBase pSPanelLLCondTypeBase) {
        pSPanelLLCondTypeBase.resetCreateDate();
        pSPanelLLCondTypeBase.resetCreateMan();
        pSPanelLLCondTypeBase.resetItemObj();
        pSPanelLLCondTypeBase.resetMemo();
        pSPanelLLCondTypeBase.resetPSPanelLLCondTypeId();
        pSPanelLLCondTypeBase.resetPSPanelLLCondTypeName();
        pSPanelLLCondTypeBase.resetUpdateDate();
        pSPanelLLCondTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSPanelLLCondTypeIdDirty()) {
            hashMap.put(FIELD_PSPANELLLCONDTYPEID, this.getPSPanelLLCondTypeId());
        }
        if (!bl || this.isPSPanelLLCondTypeNameDirty()) {
            hashMap.put(FIELD_PSPANELLLCONDTYPENAME, this.getPSPanelLLCondTypeName());
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
        return PSPanelLLCondTypeBase.get(this, n);
    }

    private static Object get(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLCondTypeBase.getCreateDate();
            }
            case 1: {
                return pSPanelLLCondTypeBase.getCreateMan();
            }
            case 2: {
                return pSPanelLLCondTypeBase.getItemObj();
            }
            case 3: {
                return pSPanelLLCondTypeBase.getMemo();
            }
            case 4: {
                return pSPanelLLCondTypeBase.getPSPanelLLCondTypeId();
            }
            case 5: {
                return pSPanelLLCondTypeBase.getPSPanelLLCondTypeName();
            }
            case 6: {
                return pSPanelLLCondTypeBase.getUpdateDate();
            }
            case 7: {
                return pSPanelLLCondTypeBase.getUpdateMan();
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
        PSPanelLLCondTypeBase.set(this, n, object);
    }

    private static void set(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLLCondTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLLCondTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLLCondTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLLCondTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLLCondTypeBase.setPSPanelLLCondTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLLCondTypeBase.setPSPanelLLCondTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLLCondTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLLCondTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLLCondTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLCondTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPanelLLCondTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPanelLLCondTypeBase.getItemObj() == null;
            }
            case 3: {
                return pSPanelLLCondTypeBase.getMemo() == null;
            }
            case 4: {
                return pSPanelLLCondTypeBase.getPSPanelLLCondTypeId() == null;
            }
            case 5: {
                return pSPanelLLCondTypeBase.getPSPanelLLCondTypeName() == null;
            }
            case 6: {
                return pSPanelLLCondTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSPanelLLCondTypeBase.getUpdateMan() == null;
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
        return PSPanelLLCondTypeBase.contains(this, n);
    }

    private static boolean contains(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLCondTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPanelLLCondTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPanelLLCondTypeBase.isItemObjDirty();
            }
            case 3: {
                return pSPanelLLCondTypeBase.isMemoDirty();
            }
            case 4: {
                return pSPanelLLCondTypeBase.isPSPanelLLCondTypeIdDirty();
            }
            case 5: {
                return pSPanelLLCondTypeBase.isPSPanelLLCondTypeNameDirty();
            }
            case 6: {
                return pSPanelLLCondTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSPanelLLCondTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLLCondTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLLCondTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLLCondTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLLCondTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSPanelLLCondTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelLLCondTypeBase.getPSPanelLLCondTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelllcondtypeid", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getPSPanelLLCondTypeId()), (boolean)false);
        }
        if (bl || pSPanelLLCondTypeBase.getPSPanelLLCondTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelllcondtypename", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getPSPanelLLCondTypeName()), (boolean)false);
        }
        if (bl || pSPanelLLCondTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLLCondTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLLCondTypeBase.getJSONValue((Object)pSPanelLLCondTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLLCondTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLLCondTypeBase.getCreateDate() != null) {
            object = pSPanelLLCondTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLLCondTypeBase.getCreateMan() != null) {
            object = pSPanelLLCondTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondTypeBase.getItemObj() != null) {
            object = pSPanelLLCondTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondTypeBase.getMemo() != null) {
            object = pSPanelLLCondTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondTypeBase.getPSPanelLLCondTypeId() != null) {
            object = pSPanelLLCondTypeBase.getPSPanelLLCondTypeId();
            xmlNode.setAttribute(FIELD_PSPANELLLCONDTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondTypeBase.getPSPanelLLCondTypeName() != null) {
            object = pSPanelLLCondTypeBase.getPSPanelLLCondTypeName();
            xmlNode.setAttribute(FIELD_PSPANELLLCONDTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondTypeBase.getUpdateDate() != null) {
            object = pSPanelLLCondTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLLCondTypeBase.getUpdateMan() != null) {
            object = pSPanelLLCondTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLLCondTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLLCondTypeBase.isCreateDateDirty() && (bl || pSPanelLLCondTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLLCondTypeBase.getCreateDate());
        }
        if (pSPanelLLCondTypeBase.isCreateManDirty() && (bl || pSPanelLLCondTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLLCondTypeBase.getCreateMan());
        }
        if (pSPanelLLCondTypeBase.isItemObjDirty() && (bl || pSPanelLLCondTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSPanelLLCondTypeBase.getItemObj());
        }
        if (pSPanelLLCondTypeBase.isMemoDirty() && (bl || pSPanelLLCondTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelLLCondTypeBase.getMemo());
        }
        if (pSPanelLLCondTypeBase.isPSPanelLLCondTypeIdDirty() && (bl || pSPanelLLCondTypeBase.getPSPanelLLCondTypeId() != null)) {
            iDataObject.set(FIELD_PSPANELLLCONDTYPEID, (Object)pSPanelLLCondTypeBase.getPSPanelLLCondTypeId());
        }
        if (pSPanelLLCondTypeBase.isPSPanelLLCondTypeNameDirty() && (bl || pSPanelLLCondTypeBase.getPSPanelLLCondTypeName() != null)) {
            iDataObject.set(FIELD_PSPANELLLCONDTYPENAME, (Object)pSPanelLLCondTypeBase.getPSPanelLLCondTypeName());
        }
        if (pSPanelLLCondTypeBase.isUpdateDateDirty() && (bl || pSPanelLLCondTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLLCondTypeBase.getUpdateDate());
        }
        if (pSPanelLLCondTypeBase.isUpdateManDirty() && (bl || pSPanelLLCondTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLLCondTypeBase.getUpdateMan());
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
        return PSPanelLLCondTypeBase.remove(this, n);
    }

    private static boolean remove(PSPanelLLCondTypeBase pSPanelLLCondTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLLCondTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPanelLLCondTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPanelLLCondTypeBase.resetItemObj();
                return true;
            }
            case 3: {
                pSPanelLLCondTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSPanelLLCondTypeBase.resetPSPanelLLCondTypeId();
                return true;
            }
            case 5: {
                pSPanelLLCondTypeBase.resetPSPanelLLCondTypeName();
                return true;
            }
            case 6: {
                pSPanelLLCondTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSPanelLLCondTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPanelLLCondTypeBase getProxyEntity() {
        return this.proxyPSPanelLLCondTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLLCondTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLLCondTypeBase) {
            this.proxyPSPanelLLCondTypeBase = (PSPanelLLCondTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPanelLLCondTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSPANELLLCONDTYPEID, 4);
        fieldIndexMap.put(FIELD_PSPANELLLCONDTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

