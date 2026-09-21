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

public abstract class PSDBObjTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBObjTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJORDERVALUE = "OBJORDERVALUE";
    public static final String FIELD_PSDBOBJTYPEID = "PSDBOBJTYPEID";
    public static final String FIELD_PSDBOBJTYPENAME = "PSDBOBJTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_OBJORDERVALUE = 4;
    private static final int INDEX_PSDBOBJTYPEID = 5;
    private static final int INDEX_PSDBOBJTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBObjTypeBase proxyPSDBObjTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objordervalueDirtyFlag = false;
    private boolean psdbobjtypeidDirtyFlag = false;
    private boolean psdbobjtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="objordervalue")
    private Integer objordervalue;
    @Column(name="psdbobjtypeid")
    private String psdbobjtypeid;
    @Column(name="psdbobjtypename")
    private String psdbobjtypename;
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

    public void setObjOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjOrderValue(n);
            return;
        }
        this.objordervalue = n;
        this.objordervalueDirtyFlag = true;
    }

    public Integer getObjOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjOrderValue();
        }
        return this.objordervalue;
    }

    public boolean isObjOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjOrderValueDirty();
        }
        return this.objordervalueDirtyFlag;
    }

    public void resetObjOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjOrderValue();
            return;
        }
        this.objordervalueDirtyFlag = false;
        this.objordervalue = null;
    }

    public void setPSDBObjTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBObjTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbobjtypeid = string;
        this.psdbobjtypeidDirtyFlag = true;
    }

    public String getPSDBObjTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBObjTypeId();
        }
        return this.psdbobjtypeid;
    }

    public boolean isPSDBObjTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBObjTypeIdDirty();
        }
        return this.psdbobjtypeidDirtyFlag;
    }

    public void resetPSDBObjTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBObjTypeId();
            return;
        }
        this.psdbobjtypeidDirtyFlag = false;
        this.psdbobjtypeid = null;
    }

    public void setPSDBObjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBObjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbobjtypename = string;
        this.psdbobjtypenameDirtyFlag = true;
    }

    public String getPSDBObjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBObjTypeName();
        }
        return this.psdbobjtypename;
    }

    public boolean isPSDBObjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBObjTypeNameDirty();
        }
        return this.psdbobjtypenameDirtyFlag;
    }

    public void resetPSDBObjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBObjTypeName();
            return;
        }
        this.psdbobjtypenameDirtyFlag = false;
        this.psdbobjtypename = null;
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
        PSDBObjTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBObjTypeBase pSDBObjTypeBase) {
        pSDBObjTypeBase.resetCreateDate();
        pSDBObjTypeBase.resetCreateMan();
        pSDBObjTypeBase.resetIconPath();
        pSDBObjTypeBase.resetMemo();
        pSDBObjTypeBase.resetObjOrderValue();
        pSDBObjTypeBase.resetPSDBObjTypeId();
        pSDBObjTypeBase.resetPSDBObjTypeName();
        pSDBObjTypeBase.resetUpdateDate();
        pSDBObjTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isObjOrderValueDirty()) {
            hashMap.put(FIELD_OBJORDERVALUE, this.getObjOrderValue());
        }
        if (!bl || this.isPSDBObjTypeIdDirty()) {
            hashMap.put(FIELD_PSDBOBJTYPEID, this.getPSDBObjTypeId());
        }
        if (!bl || this.isPSDBObjTypeNameDirty()) {
            hashMap.put(FIELD_PSDBOBJTYPENAME, this.getPSDBObjTypeName());
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
        return PSDBObjTypeBase.get(this, n);
    }

    private static Object get(PSDBObjTypeBase pSDBObjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBObjTypeBase.getCreateDate();
            }
            case 1: {
                return pSDBObjTypeBase.getCreateMan();
            }
            case 2: {
                return pSDBObjTypeBase.getIconPath();
            }
            case 3: {
                return pSDBObjTypeBase.getMemo();
            }
            case 4: {
                return pSDBObjTypeBase.getObjOrderValue();
            }
            case 5: {
                return pSDBObjTypeBase.getPSDBObjTypeId();
            }
            case 6: {
                return pSDBObjTypeBase.getPSDBObjTypeName();
            }
            case 7: {
                return pSDBObjTypeBase.getUpdateDate();
            }
            case 8: {
                return pSDBObjTypeBase.getUpdateMan();
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
        PSDBObjTypeBase.set(this, n, object);
    }

    private static void set(PSDBObjTypeBase pSDBObjTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBObjTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDBObjTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBObjTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBObjTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBObjTypeBase.setObjOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDBObjTypeBase.setPSDBObjTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBObjTypeBase.setPSDBObjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBObjTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDBObjTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDBObjTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDBObjTypeBase pSDBObjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBObjTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDBObjTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDBObjTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSDBObjTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDBObjTypeBase.getObjOrderValue() == null;
            }
            case 5: {
                return pSDBObjTypeBase.getPSDBObjTypeId() == null;
            }
            case 6: {
                return pSDBObjTypeBase.getPSDBObjTypeName() == null;
            }
            case 7: {
                return pSDBObjTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDBObjTypeBase.getUpdateMan() == null;
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
        return PSDBObjTypeBase.contains(this, n);
    }

    private static boolean contains(PSDBObjTypeBase pSDBObjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBObjTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDBObjTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDBObjTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSDBObjTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDBObjTypeBase.isObjOrderValueDirty();
            }
            case 5: {
                return pSDBObjTypeBase.isPSDBObjTypeIdDirty();
            }
            case 6: {
                return pSDBObjTypeBase.isPSDBObjTypeNameDirty();
            }
            case 7: {
                return pSDBObjTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDBObjTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBObjTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBObjTypeBase pSDBObjTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBObjTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getObjOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objordervalue", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getObjOrderValue()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getPSDBObjTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbobjtypeid", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getPSDBObjTypeId()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getPSDBObjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbobjtypename", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getPSDBObjTypeName()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBObjTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBObjTypeBase.getJSONValue((Object)pSDBObjTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBObjTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBObjTypeBase pSDBObjTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBObjTypeBase.getCreateDate() != null) {
            object = pSDBObjTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBObjTypeBase.getCreateMan() != null) {
            object = pSDBObjTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBObjTypeBase.getIconPath() != null) {
            object = pSDBObjTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBObjTypeBase.getMemo() != null) {
            object = pSDBObjTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBObjTypeBase.getObjOrderValue() != null) {
            object = pSDBObjTypeBase.getObjOrderValue();
            xmlNode.setAttribute(FIELD_OBJORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBObjTypeBase.getPSDBObjTypeId() != null) {
            object = pSDBObjTypeBase.getPSDBObjTypeId();
            xmlNode.setAttribute(FIELD_PSDBOBJTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBObjTypeBase.getPSDBObjTypeName() != null) {
            object = pSDBObjTypeBase.getPSDBObjTypeName();
            xmlNode.setAttribute(FIELD_PSDBOBJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBObjTypeBase.getUpdateDate() != null) {
            object = pSDBObjTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBObjTypeBase.getUpdateMan() != null) {
            object = pSDBObjTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBObjTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBObjTypeBase pSDBObjTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBObjTypeBase.isCreateDateDirty() && (bl || pSDBObjTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBObjTypeBase.getCreateDate());
        }
        if (pSDBObjTypeBase.isCreateManDirty() && (bl || pSDBObjTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBObjTypeBase.getCreateMan());
        }
        if (pSDBObjTypeBase.isIconPathDirty() && (bl || pSDBObjTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDBObjTypeBase.getIconPath());
        }
        if (pSDBObjTypeBase.isMemoDirty() && (bl || pSDBObjTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBObjTypeBase.getMemo());
        }
        if (pSDBObjTypeBase.isObjOrderValueDirty() && (bl || pSDBObjTypeBase.getObjOrderValue() != null)) {
            iDataObject.set(FIELD_OBJORDERVALUE, (Object)pSDBObjTypeBase.getObjOrderValue());
        }
        if (pSDBObjTypeBase.isPSDBObjTypeIdDirty() && (bl || pSDBObjTypeBase.getPSDBObjTypeId() != null)) {
            iDataObject.set(FIELD_PSDBOBJTYPEID, (Object)pSDBObjTypeBase.getPSDBObjTypeId());
        }
        if (pSDBObjTypeBase.isPSDBObjTypeNameDirty() && (bl || pSDBObjTypeBase.getPSDBObjTypeName() != null)) {
            iDataObject.set(FIELD_PSDBOBJTYPENAME, (Object)pSDBObjTypeBase.getPSDBObjTypeName());
        }
        if (pSDBObjTypeBase.isUpdateDateDirty() && (bl || pSDBObjTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBObjTypeBase.getUpdateDate());
        }
        if (pSDBObjTypeBase.isUpdateManDirty() && (bl || pSDBObjTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBObjTypeBase.getUpdateMan());
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
        return PSDBObjTypeBase.remove(this, n);
    }

    private static boolean remove(PSDBObjTypeBase pSDBObjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBObjTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDBObjTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDBObjTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSDBObjTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDBObjTypeBase.resetObjOrderValue();
                return true;
            }
            case 5: {
                pSDBObjTypeBase.resetPSDBObjTypeId();
                return true;
            }
            case 6: {
                pSDBObjTypeBase.resetPSDBObjTypeName();
                return true;
            }
            case 7: {
                pSDBObjTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDBObjTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDBObjTypeBase getProxyEntity() {
        return this.proxyPSDBObjTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBObjTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBObjTypeBase) {
            this.proxyPSDBObjTypeBase = (PSDBObjTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBObjTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_OBJORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDBOBJTYPEID, 5);
        fieldIndexMap.put(FIELD_PSDBOBJTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

