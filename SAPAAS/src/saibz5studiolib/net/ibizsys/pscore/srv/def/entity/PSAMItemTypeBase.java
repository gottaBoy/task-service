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

public abstract class PSAMItemTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAMItemTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAMITEMTYPEID = "PSAMITEMTYPEID";
    public static final String FIELD_PSAMITEMTYPENAME = "PSAMITEMTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAMITEMTYPEID = 4;
    private static final int INDEX_PSAMITEMTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAMItemTypeBase proxyPSAMItemTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psamitemtypeidDirtyFlag = false;
    private boolean psamitemtypenameDirtyFlag = false;
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
    @Column(name="psamitemtypeid")
    private String psamitemtypeid;
    @Column(name="psamitemtypename")
    private String psamitemtypename;
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

    public void setITEMOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setITEMOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj = string;
        this.itemobjDirtyFlag = true;
    }

    public String getITEMOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getITEMOBJ();
        }
        return this.itemobj;
    }

    public boolean isITEMOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isITEMOBJDirty();
        }
        return this.itemobjDirtyFlag;
    }

    public void resetITEMOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetITEMOBJ();
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

    public void setPSAMItemTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAMItemTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psamitemtypeid = string;
        this.psamitemtypeidDirtyFlag = true;
    }

    public String getPSAMItemTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAMItemTypeId();
        }
        return this.psamitemtypeid;
    }

    public boolean isPSAMItemTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAMItemTypeIdDirty();
        }
        return this.psamitemtypeidDirtyFlag;
    }

    public void resetPSAMItemTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAMItemTypeId();
            return;
        }
        this.psamitemtypeidDirtyFlag = false;
        this.psamitemtypeid = null;
    }

    public void setPSAMItemTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAMItemTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psamitemtypename = string;
        this.psamitemtypenameDirtyFlag = true;
    }

    public String getPSAMItemTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAMItemTypeName();
        }
        return this.psamitemtypename;
    }

    public boolean isPSAMItemTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAMItemTypeNameDirty();
        }
        return this.psamitemtypenameDirtyFlag;
    }

    public void resetPSAMItemTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAMItemTypeName();
            return;
        }
        this.psamitemtypenameDirtyFlag = false;
        this.psamitemtypename = null;
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
        PSAMItemTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAMItemTypeBase pSAMItemTypeBase) {
        pSAMItemTypeBase.resetCreateDate();
        pSAMItemTypeBase.resetCreateMan();
        pSAMItemTypeBase.resetITEMOBJ();
        pSAMItemTypeBase.resetMemo();
        pSAMItemTypeBase.resetPSAMItemTypeId();
        pSAMItemTypeBase.resetPSAMItemTypeName();
        pSAMItemTypeBase.resetUpdateDate();
        pSAMItemTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isITEMOBJDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getITEMOBJ());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAMItemTypeIdDirty()) {
            hashMap.put(FIELD_PSAMITEMTYPEID, this.getPSAMItemTypeId());
        }
        if (!bl || this.isPSAMItemTypeNameDirty()) {
            hashMap.put(FIELD_PSAMITEMTYPENAME, this.getPSAMItemTypeName());
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
        return PSAMItemTypeBase.get(this, n);
    }

    private static Object get(PSAMItemTypeBase pSAMItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAMItemTypeBase.getCreateDate();
            }
            case 1: {
                return pSAMItemTypeBase.getCreateMan();
            }
            case 2: {
                return pSAMItemTypeBase.getITEMOBJ();
            }
            case 3: {
                return pSAMItemTypeBase.getMemo();
            }
            case 4: {
                return pSAMItemTypeBase.getPSAMItemTypeId();
            }
            case 5: {
                return pSAMItemTypeBase.getPSAMItemTypeName();
            }
            case 6: {
                return pSAMItemTypeBase.getUpdateDate();
            }
            case 7: {
                return pSAMItemTypeBase.getUpdateMan();
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
        PSAMItemTypeBase.set(this, n, object);
    }

    private static void set(PSAMItemTypeBase pSAMItemTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAMItemTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAMItemTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAMItemTypeBase.setITEMOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAMItemTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAMItemTypeBase.setPSAMItemTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAMItemTypeBase.setPSAMItemTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAMItemTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSAMItemTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAMItemTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSAMItemTypeBase pSAMItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAMItemTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSAMItemTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSAMItemTypeBase.getITEMOBJ() == null;
            }
            case 3: {
                return pSAMItemTypeBase.getMemo() == null;
            }
            case 4: {
                return pSAMItemTypeBase.getPSAMItemTypeId() == null;
            }
            case 5: {
                return pSAMItemTypeBase.getPSAMItemTypeName() == null;
            }
            case 6: {
                return pSAMItemTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSAMItemTypeBase.getUpdateMan() == null;
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
        return PSAMItemTypeBase.contains(this, n);
    }

    private static boolean contains(PSAMItemTypeBase pSAMItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAMItemTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSAMItemTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSAMItemTypeBase.isITEMOBJDirty();
            }
            case 3: {
                return pSAMItemTypeBase.isMemoDirty();
            }
            case 4: {
                return pSAMItemTypeBase.isPSAMItemTypeIdDirty();
            }
            case 5: {
                return pSAMItemTypeBase.isPSAMItemTypeNameDirty();
            }
            case 6: {
                return pSAMItemTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSAMItemTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAMItemTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAMItemTypeBase pSAMItemTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAMItemTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAMItemTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAMItemTypeBase.getITEMOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getITEMOBJ()), (boolean)false);
        }
        if (bl || pSAMItemTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSAMItemTypeBase.getPSAMItemTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psamitemtypeid", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getPSAMItemTypeId()), (boolean)false);
        }
        if (bl || pSAMItemTypeBase.getPSAMItemTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psamitemtypename", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getPSAMItemTypeName()), (boolean)false);
        }
        if (bl || pSAMItemTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAMItemTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAMItemTypeBase.getJSONValue((Object)pSAMItemTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAMItemTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAMItemTypeBase pSAMItemTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAMItemTypeBase.getCreateDate() != null) {
            object = pSAMItemTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAMItemTypeBase.getCreateMan() != null) {
            object = pSAMItemTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAMItemTypeBase.getITEMOBJ() != null) {
            object = pSAMItemTypeBase.getITEMOBJ();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSAMItemTypeBase.getMemo() != null) {
            object = pSAMItemTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAMItemTypeBase.getPSAMItemTypeId() != null) {
            object = pSAMItemTypeBase.getPSAMItemTypeId();
            xmlNode.setAttribute(FIELD_PSAMITEMTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSAMItemTypeBase.getPSAMItemTypeName() != null) {
            object = pSAMItemTypeBase.getPSAMItemTypeName();
            xmlNode.setAttribute(FIELD_PSAMITEMTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAMItemTypeBase.getUpdateDate() != null) {
            object = pSAMItemTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAMItemTypeBase.getUpdateMan() != null) {
            object = pSAMItemTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAMItemTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAMItemTypeBase pSAMItemTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAMItemTypeBase.isCreateDateDirty() && (bl || pSAMItemTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAMItemTypeBase.getCreateDate());
        }
        if (pSAMItemTypeBase.isCreateManDirty() && (bl || pSAMItemTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAMItemTypeBase.getCreateMan());
        }
        if (pSAMItemTypeBase.isITEMOBJDirty() && (bl || pSAMItemTypeBase.getITEMOBJ() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSAMItemTypeBase.getITEMOBJ());
        }
        if (pSAMItemTypeBase.isMemoDirty() && (bl || pSAMItemTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAMItemTypeBase.getMemo());
        }
        if (pSAMItemTypeBase.isPSAMItemTypeIdDirty() && (bl || pSAMItemTypeBase.getPSAMItemTypeId() != null)) {
            iDataObject.set(FIELD_PSAMITEMTYPEID, (Object)pSAMItemTypeBase.getPSAMItemTypeId());
        }
        if (pSAMItemTypeBase.isPSAMItemTypeNameDirty() && (bl || pSAMItemTypeBase.getPSAMItemTypeName() != null)) {
            iDataObject.set(FIELD_PSAMITEMTYPENAME, (Object)pSAMItemTypeBase.getPSAMItemTypeName());
        }
        if (pSAMItemTypeBase.isUpdateDateDirty() && (bl || pSAMItemTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAMItemTypeBase.getUpdateDate());
        }
        if (pSAMItemTypeBase.isUpdateManDirty() && (bl || pSAMItemTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAMItemTypeBase.getUpdateMan());
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
        return PSAMItemTypeBase.remove(this, n);
    }

    private static boolean remove(PSAMItemTypeBase pSAMItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAMItemTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAMItemTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAMItemTypeBase.resetITEMOBJ();
                return true;
            }
            case 3: {
                pSAMItemTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSAMItemTypeBase.resetPSAMItemTypeId();
                return true;
            }
            case 5: {
                pSAMItemTypeBase.resetPSAMItemTypeName();
                return true;
            }
            case 6: {
                pSAMItemTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSAMItemTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSAMItemTypeBase getProxyEntity() {
        return this.proxyPSAMItemTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAMItemTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSAMItemTypeBase) {
            this.proxyPSAMItemTypeBase = (PSAMItemTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSAMItemTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAMITEMTYPEID, 4);
        fieldIndexMap.put(FIELD_PSAMITEMTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

