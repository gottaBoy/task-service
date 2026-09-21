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

public abstract class PSFormTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSFormTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FORMOBJ = "FORMOBJ";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSFORMTYPEID = "PSFORMTYPEID";
    public static final String FIELD_PSFORMTYPENAME = "PSFORMTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FORMOBJ = 2;
    private static final int INDEX_ICONPATH = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSFORMTYPEID = 5;
    private static final int INDEX_PSFORMTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSFormTypeBase proxyPSFormTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean formobjDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psformtypeidDirtyFlag = false;
    private boolean psformtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="formobj")
    private String formobj;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="psformtypeid")
    private String psformtypeid;
    @Column(name="psformtypename")
    private String psformtypename;
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

    public void setFORMOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFORMOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formobj = string;
        this.formobjDirtyFlag = true;
    }

    public String getFORMOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFORMOBJ();
        }
        return this.formobj;
    }

    public boolean isFORMOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFORMOBJDirty();
        }
        return this.formobjDirtyFlag;
    }

    public void resetFORMOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFORMOBJ();
            return;
        }
        this.formobjDirtyFlag = false;
        this.formobj = null;
    }

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
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

    public void setPSFormTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSFormTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psformtypeid = string;
        this.psformtypeidDirtyFlag = true;
    }

    public String getPSFormTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSFormTypeId();
        }
        return this.psformtypeid;
    }

    public boolean isPSFormTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSFormTypeIdDirty();
        }
        return this.psformtypeidDirtyFlag;
    }

    public void resetPSFormTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSFormTypeId();
            return;
        }
        this.psformtypeidDirtyFlag = false;
        this.psformtypeid = null;
    }

    public void setPSFormTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSFormTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psformtypename = string;
        this.psformtypenameDirtyFlag = true;
    }

    public String getPSFormTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSFormTypeName();
        }
        return this.psformtypename;
    }

    public boolean isPSFormTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSFormTypeNameDirty();
        }
        return this.psformtypenameDirtyFlag;
    }

    public void resetPSFormTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSFormTypeName();
            return;
        }
        this.psformtypenameDirtyFlag = false;
        this.psformtypename = null;
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
        PSFormTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSFormTypeBase pSFormTypeBase) {
        pSFormTypeBase.resetCreateDate();
        pSFormTypeBase.resetCreateMan();
        pSFormTypeBase.resetFORMOBJ();
        pSFormTypeBase.resetIconPath();
        pSFormTypeBase.resetMemo();
        pSFormTypeBase.resetPSFormTypeId();
        pSFormTypeBase.resetPSFormTypeName();
        pSFormTypeBase.resetUpdateDate();
        pSFormTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFORMOBJDirty()) {
            hashMap.put(FIELD_FORMOBJ, this.getFORMOBJ());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSFormTypeIdDirty()) {
            hashMap.put(FIELD_PSFORMTYPEID, this.getPSFormTypeId());
        }
        if (!bl || this.isPSFormTypeNameDirty()) {
            hashMap.put(FIELD_PSFORMTYPENAME, this.getPSFormTypeName());
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
        return PSFormTypeBase.get(this, n);
    }

    private static Object get(PSFormTypeBase pSFormTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFormTypeBase.getCreateDate();
            }
            case 1: {
                return pSFormTypeBase.getCreateMan();
            }
            case 2: {
                return pSFormTypeBase.getFORMOBJ();
            }
            case 3: {
                return pSFormTypeBase.getIconPath();
            }
            case 4: {
                return pSFormTypeBase.getMemo();
            }
            case 5: {
                return pSFormTypeBase.getPSFormTypeId();
            }
            case 6: {
                return pSFormTypeBase.getPSFormTypeName();
            }
            case 7: {
                return pSFormTypeBase.getUpdateDate();
            }
            case 8: {
                return pSFormTypeBase.getUpdateMan();
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
        PSFormTypeBase.set(this, n, object);
    }

    private static void set(PSFormTypeBase pSFormTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSFormTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSFormTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSFormTypeBase.setFORMOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSFormTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSFormTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSFormTypeBase.setPSFormTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSFormTypeBase.setPSFormTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSFormTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSFormTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSFormTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSFormTypeBase pSFormTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFormTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSFormTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSFormTypeBase.getFORMOBJ() == null;
            }
            case 3: {
                return pSFormTypeBase.getIconPath() == null;
            }
            case 4: {
                return pSFormTypeBase.getMemo() == null;
            }
            case 5: {
                return pSFormTypeBase.getPSFormTypeId() == null;
            }
            case 6: {
                return pSFormTypeBase.getPSFormTypeName() == null;
            }
            case 7: {
                return pSFormTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSFormTypeBase.getUpdateMan() == null;
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
        return PSFormTypeBase.contains(this, n);
    }

    private static boolean contains(PSFormTypeBase pSFormTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFormTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSFormTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSFormTypeBase.isFORMOBJDirty();
            }
            case 3: {
                return pSFormTypeBase.isIconPathDirty();
            }
            case 4: {
                return pSFormTypeBase.isMemoDirty();
            }
            case 5: {
                return pSFormTypeBase.isPSFormTypeIdDirty();
            }
            case 6: {
                return pSFormTypeBase.isPSFormTypeNameDirty();
            }
            case 7: {
                return pSFormTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSFormTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSFormTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSFormTypeBase pSFormTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSFormTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getFORMOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formobj", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getFORMOBJ()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getPSFormTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psformtypeid", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getPSFormTypeId()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getPSFormTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psformtypename", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getPSFormTypeName()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSFormTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSFormTypeBase.getJSONValue((Object)pSFormTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSFormTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSFormTypeBase pSFormTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSFormTypeBase.getCreateDate() != null) {
            object = pSFormTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSFormTypeBase.getCreateMan() != null) {
            object = pSFormTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSFormTypeBase.getFORMOBJ() != null) {
            object = pSFormTypeBase.getFORMOBJ();
            xmlNode.setAttribute(FIELD_FORMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSFormTypeBase.getIconPath() != null) {
            object = pSFormTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSFormTypeBase.getMemo() != null) {
            object = pSFormTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSFormTypeBase.getPSFormTypeId() != null) {
            object = pSFormTypeBase.getPSFormTypeId();
            xmlNode.setAttribute(FIELD_PSFORMTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSFormTypeBase.getPSFormTypeName() != null) {
            object = pSFormTypeBase.getPSFormTypeName();
            xmlNode.setAttribute(FIELD_PSFORMTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSFormTypeBase.getUpdateDate() != null) {
            object = pSFormTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSFormTypeBase.getUpdateMan() != null) {
            object = pSFormTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSFormTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSFormTypeBase pSFormTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSFormTypeBase.isCreateDateDirty() && (bl || pSFormTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSFormTypeBase.getCreateDate());
        }
        if (pSFormTypeBase.isCreateManDirty() && (bl || pSFormTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSFormTypeBase.getCreateMan());
        }
        if (pSFormTypeBase.isFORMOBJDirty() && (bl || pSFormTypeBase.getFORMOBJ() != null)) {
            iDataObject.set(FIELD_FORMOBJ, (Object)pSFormTypeBase.getFORMOBJ());
        }
        if (pSFormTypeBase.isIconPathDirty() && (bl || pSFormTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSFormTypeBase.getIconPath());
        }
        if (pSFormTypeBase.isMemoDirty() && (bl || pSFormTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSFormTypeBase.getMemo());
        }
        if (pSFormTypeBase.isPSFormTypeIdDirty() && (bl || pSFormTypeBase.getPSFormTypeId() != null)) {
            iDataObject.set(FIELD_PSFORMTYPEID, (Object)pSFormTypeBase.getPSFormTypeId());
        }
        if (pSFormTypeBase.isPSFormTypeNameDirty() && (bl || pSFormTypeBase.getPSFormTypeName() != null)) {
            iDataObject.set(FIELD_PSFORMTYPENAME, (Object)pSFormTypeBase.getPSFormTypeName());
        }
        if (pSFormTypeBase.isUpdateDateDirty() && (bl || pSFormTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSFormTypeBase.getUpdateDate());
        }
        if (pSFormTypeBase.isUpdateManDirty() && (bl || pSFormTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSFormTypeBase.getUpdateMan());
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
        return PSFormTypeBase.remove(this, n);
    }

    private static boolean remove(PSFormTypeBase pSFormTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSFormTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSFormTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSFormTypeBase.resetFORMOBJ();
                return true;
            }
            case 3: {
                pSFormTypeBase.resetIconPath();
                return true;
            }
            case 4: {
                pSFormTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSFormTypeBase.resetPSFormTypeId();
                return true;
            }
            case 6: {
                pSFormTypeBase.resetPSFormTypeName();
                return true;
            }
            case 7: {
                pSFormTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSFormTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSFormTypeBase getProxyEntity() {
        return this.proxyPSFormTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSFormTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSFormTypeBase) {
            this.proxyPSFormTypeBase = (PSFormTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSFormTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FORMOBJ, 2);
        fieldIndexMap.put(FIELD_ICONPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSFORMTYPEID, 5);
        fieldIndexMap.put(FIELD_PSFORMTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

