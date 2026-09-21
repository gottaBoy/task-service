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

public abstract class PSDRItemTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDRItemTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDRITEMTYPEID = "PSDRITEMTYPEID";
    public static final String FIELD_PSDRITEMTYPENAME = "PSDRITEMTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ITEMOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDRITEMTYPEID = 4;
    private static final int INDEX_PSDRITEMTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDRItemTypeBase proxyPSDRItemTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdritemtypeidDirtyFlag = false;
    private boolean psdritemtypenameDirtyFlag = false;
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
    @Column(name="psdritemtypeid")
    private String psdritemtypeid;
    @Column(name="psdritemtypename")
    private String psdritemtypename;
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

    public void setPSDRItemTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDRItemTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdritemtypeid = string;
        this.psdritemtypeidDirtyFlag = true;
    }

    public String getPSDRItemTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDRItemTypeId();
        }
        return this.psdritemtypeid;
    }

    public boolean isPSDRItemTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDRItemTypeIdDirty();
        }
        return this.psdritemtypeidDirtyFlag;
    }

    public void resetPSDRItemTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDRItemTypeId();
            return;
        }
        this.psdritemtypeidDirtyFlag = false;
        this.psdritemtypeid = null;
    }

    public void setPSDRItemTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDRItemTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdritemtypename = string;
        this.psdritemtypenameDirtyFlag = true;
    }

    public String getPSDRItemTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDRItemTypeName();
        }
        return this.psdritemtypename;
    }

    public boolean isPSDRItemTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDRItemTypeNameDirty();
        }
        return this.psdritemtypenameDirtyFlag;
    }

    public void resetPSDRItemTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDRItemTypeName();
            return;
        }
        this.psdritemtypenameDirtyFlag = false;
        this.psdritemtypename = null;
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
        PSDRItemTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDRItemTypeBase pSDRItemTypeBase) {
        pSDRItemTypeBase.resetCreateDate();
        pSDRItemTypeBase.resetCreateMan();
        pSDRItemTypeBase.resetITEMOBJ();
        pSDRItemTypeBase.resetMemo();
        pSDRItemTypeBase.resetPSDRItemTypeId();
        pSDRItemTypeBase.resetPSDRItemTypeName();
        pSDRItemTypeBase.resetUpdateDate();
        pSDRItemTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSDRItemTypeIdDirty()) {
            hashMap.put(FIELD_PSDRITEMTYPEID, this.getPSDRItemTypeId());
        }
        if (!bl || this.isPSDRItemTypeNameDirty()) {
            hashMap.put(FIELD_PSDRITEMTYPENAME, this.getPSDRItemTypeName());
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
        return PSDRItemTypeBase.get(this, n);
    }

    private static Object get(PSDRItemTypeBase pSDRItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDRItemTypeBase.getCreateDate();
            }
            case 1: {
                return pSDRItemTypeBase.getCreateMan();
            }
            case 2: {
                return pSDRItemTypeBase.getITEMOBJ();
            }
            case 3: {
                return pSDRItemTypeBase.getMemo();
            }
            case 4: {
                return pSDRItemTypeBase.getPSDRItemTypeId();
            }
            case 5: {
                return pSDRItemTypeBase.getPSDRItemTypeName();
            }
            case 6: {
                return pSDRItemTypeBase.getUpdateDate();
            }
            case 7: {
                return pSDRItemTypeBase.getUpdateMan();
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
        PSDRItemTypeBase.set(this, n, object);
    }

    private static void set(PSDRItemTypeBase pSDRItemTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDRItemTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDRItemTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDRItemTypeBase.setITEMOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDRItemTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDRItemTypeBase.setPSDRItemTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDRItemTypeBase.setPSDRItemTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDRItemTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDRItemTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDRItemTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDRItemTypeBase pSDRItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDRItemTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDRItemTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDRItemTypeBase.getITEMOBJ() == null;
            }
            case 3: {
                return pSDRItemTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDRItemTypeBase.getPSDRItemTypeId() == null;
            }
            case 5: {
                return pSDRItemTypeBase.getPSDRItemTypeName() == null;
            }
            case 6: {
                return pSDRItemTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDRItemTypeBase.getUpdateMan() == null;
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
        return PSDRItemTypeBase.contains(this, n);
    }

    private static boolean contains(PSDRItemTypeBase pSDRItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDRItemTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDRItemTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDRItemTypeBase.isITEMOBJDirty();
            }
            case 3: {
                return pSDRItemTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDRItemTypeBase.isPSDRItemTypeIdDirty();
            }
            case 5: {
                return pSDRItemTypeBase.isPSDRItemTypeNameDirty();
            }
            case 6: {
                return pSDRItemTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDRItemTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDRItemTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDRItemTypeBase pSDRItemTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDRItemTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDRItemTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDRItemTypeBase.getITEMOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getITEMOBJ()), (boolean)false);
        }
        if (bl || pSDRItemTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDRItemTypeBase.getPSDRItemTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdritemtypeid", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getPSDRItemTypeId()), (boolean)false);
        }
        if (bl || pSDRItemTypeBase.getPSDRItemTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdritemtypename", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getPSDRItemTypeName()), (boolean)false);
        }
        if (bl || pSDRItemTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDRItemTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDRItemTypeBase.getJSONValue((Object)pSDRItemTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDRItemTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDRItemTypeBase pSDRItemTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDRItemTypeBase.getCreateDate() != null) {
            object = pSDRItemTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDRItemTypeBase.getCreateMan() != null) {
            object = pSDRItemTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDRItemTypeBase.getITEMOBJ() != null) {
            object = pSDRItemTypeBase.getITEMOBJ();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDRItemTypeBase.getMemo() != null) {
            object = pSDRItemTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDRItemTypeBase.getPSDRItemTypeId() != null) {
            object = pSDRItemTypeBase.getPSDRItemTypeId();
            xmlNode.setAttribute(FIELD_PSDRITEMTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDRItemTypeBase.getPSDRItemTypeName() != null) {
            object = pSDRItemTypeBase.getPSDRItemTypeName();
            xmlNode.setAttribute(FIELD_PSDRITEMTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDRItemTypeBase.getUpdateDate() != null) {
            object = pSDRItemTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDRItemTypeBase.getUpdateMan() != null) {
            object = pSDRItemTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDRItemTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDRItemTypeBase pSDRItemTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDRItemTypeBase.isCreateDateDirty() && (bl || pSDRItemTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDRItemTypeBase.getCreateDate());
        }
        if (pSDRItemTypeBase.isCreateManDirty() && (bl || pSDRItemTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDRItemTypeBase.getCreateMan());
        }
        if (pSDRItemTypeBase.isITEMOBJDirty() && (bl || pSDRItemTypeBase.getITEMOBJ() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSDRItemTypeBase.getITEMOBJ());
        }
        if (pSDRItemTypeBase.isMemoDirty() && (bl || pSDRItemTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDRItemTypeBase.getMemo());
        }
        if (pSDRItemTypeBase.isPSDRItemTypeIdDirty() && (bl || pSDRItemTypeBase.getPSDRItemTypeId() != null)) {
            iDataObject.set(FIELD_PSDRITEMTYPEID, (Object)pSDRItemTypeBase.getPSDRItemTypeId());
        }
        if (pSDRItemTypeBase.isPSDRItemTypeNameDirty() && (bl || pSDRItemTypeBase.getPSDRItemTypeName() != null)) {
            iDataObject.set(FIELD_PSDRITEMTYPENAME, (Object)pSDRItemTypeBase.getPSDRItemTypeName());
        }
        if (pSDRItemTypeBase.isUpdateDateDirty() && (bl || pSDRItemTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDRItemTypeBase.getUpdateDate());
        }
        if (pSDRItemTypeBase.isUpdateManDirty() && (bl || pSDRItemTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDRItemTypeBase.getUpdateMan());
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
        return PSDRItemTypeBase.remove(this, n);
    }

    private static boolean remove(PSDRItemTypeBase pSDRItemTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDRItemTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDRItemTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDRItemTypeBase.resetITEMOBJ();
                return true;
            }
            case 3: {
                pSDRItemTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDRItemTypeBase.resetPSDRItemTypeId();
                return true;
            }
            case 5: {
                pSDRItemTypeBase.resetPSDRItemTypeName();
                return true;
            }
            case 6: {
                pSDRItemTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDRItemTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDRItemTypeBase getProxyEntity() {
        return this.proxyPSDRItemTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDRItemTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDRItemTypeBase) {
            this.proxyPSDRItemTypeBase = (PSDRItemTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDRItemTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ITEMOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDRITEMTYPEID, 4);
        fieldIndexMap.put(FIELD_PSDRITEMTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

