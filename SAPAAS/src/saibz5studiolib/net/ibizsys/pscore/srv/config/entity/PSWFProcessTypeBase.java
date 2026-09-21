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

public abstract class PSWFProcessTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFProcessTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSWFPROCESSTYPEID = "PSWFPROCESSTYPEID";
    public static final String FIELD_PSWFPROCESSTYPENAME = "PSWFPROCESSTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_ITEMOBJ = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSWFPROCESSTYPEID = 5;
    private static final int INDEX_PSWFPROCESSTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFProcessTypeBase proxyPSWFProcessTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pswfprocesstypeidDirtyFlag = false;
    private boolean pswfprocesstypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="itemobj")
    private String itemobj;
    @Column(name="memo")
    private String memo;
    @Column(name="pswfprocesstypeid")
    private String pswfprocesstypeid;
    @Column(name="pswfprocesstypename")
    private String pswfprocesstypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setPSWFProcessTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocesstypeid = string;
        this.pswfprocesstypeidDirtyFlag = true;
    }

    public String getPSWFProcessTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessTypeId();
        }
        return this.pswfprocesstypeid;
    }

    public boolean isPSWFProcessTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessTypeIdDirty();
        }
        return this.pswfprocesstypeidDirtyFlag;
    }

    public void resetPSWFProcessTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessTypeId();
            return;
        }
        this.pswfprocesstypeidDirtyFlag = false;
        this.pswfprocesstypeid = null;
    }

    public void setPSWFProcessTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFProcessTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfprocesstypename = string;
        this.pswfprocesstypenameDirtyFlag = true;
    }

    public String getPSWFProcessTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFProcessTypeName();
        }
        return this.pswfprocesstypename;
    }

    public boolean isPSWFProcessTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFProcessTypeNameDirty();
        }
        return this.pswfprocesstypenameDirtyFlag;
    }

    public void resetPSWFProcessTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFProcessTypeName();
            return;
        }
        this.pswfprocesstypenameDirtyFlag = false;
        this.pswfprocesstypename = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSWFProcessTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFProcessTypeBase pSWFProcessTypeBase) {
        pSWFProcessTypeBase.resetCreateDate();
        pSWFProcessTypeBase.resetCreateMan();
        pSWFProcessTypeBase.resetIconPath();
        pSWFProcessTypeBase.resetItemObj();
        pSWFProcessTypeBase.resetMemo();
        pSWFProcessTypeBase.resetPSWFProcessTypeId();
        pSWFProcessTypeBase.resetPSWFProcessTypeName();
        pSWFProcessTypeBase.resetUpdateDate();
        pSWFProcessTypeBase.resetUpdateMan();
        pSWFProcessTypeBase.resetValidFlag();
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
        if (!bl || this.isItemObjDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getItemObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSWFProcessTypeIdDirty()) {
            hashMap.put(FIELD_PSWFPROCESSTYPEID, this.getPSWFProcessTypeId());
        }
        if (!bl || this.isPSWFProcessTypeNameDirty()) {
            hashMap.put(FIELD_PSWFPROCESSTYPENAME, this.getPSWFProcessTypeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSWFProcessTypeBase.get(this, n);
    }

    private static Object get(PSWFProcessTypeBase pSWFProcessTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcessTypeBase.getCreateDate();
            }
            case 1: {
                return pSWFProcessTypeBase.getCreateMan();
            }
            case 2: {
                return pSWFProcessTypeBase.getIconPath();
            }
            case 3: {
                return pSWFProcessTypeBase.getItemObj();
            }
            case 4: {
                return pSWFProcessTypeBase.getMemo();
            }
            case 5: {
                return pSWFProcessTypeBase.getPSWFProcessTypeId();
            }
            case 6: {
                return pSWFProcessTypeBase.getPSWFProcessTypeName();
            }
            case 7: {
                return pSWFProcessTypeBase.getUpdateDate();
            }
            case 8: {
                return pSWFProcessTypeBase.getUpdateMan();
            }
            case 9: {
                return pSWFProcessTypeBase.getValidFlag();
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
        PSWFProcessTypeBase.set(this, n, object);
    }

    private static void set(PSWFProcessTypeBase pSWFProcessTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcessTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWFProcessTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFProcessTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFProcessTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFProcessTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFProcessTypeBase.setPSWFProcessTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFProcessTypeBase.setPSWFProcessTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFProcessTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSWFProcessTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFProcessTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSWFProcessTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSWFProcessTypeBase pSWFProcessTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcessTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSWFProcessTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSWFProcessTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSWFProcessTypeBase.getItemObj() == null;
            }
            case 4: {
                return pSWFProcessTypeBase.getMemo() == null;
            }
            case 5: {
                return pSWFProcessTypeBase.getPSWFProcessTypeId() == null;
            }
            case 6: {
                return pSWFProcessTypeBase.getPSWFProcessTypeName() == null;
            }
            case 7: {
                return pSWFProcessTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSWFProcessTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSWFProcessTypeBase.getValidFlag() == null;
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
        return PSWFProcessTypeBase.contains(this, n);
    }

    private static boolean contains(PSWFProcessTypeBase pSWFProcessTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFProcessTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSWFProcessTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSWFProcessTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSWFProcessTypeBase.isItemObjDirty();
            }
            case 4: {
                return pSWFProcessTypeBase.isMemoDirty();
            }
            case 5: {
                return pSWFProcessTypeBase.isPSWFProcessTypeIdDirty();
            }
            case 6: {
                return pSWFProcessTypeBase.isPSWFProcessTypeNameDirty();
            }
            case 7: {
                return pSWFProcessTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSWFProcessTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSWFProcessTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFProcessTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFProcessTypeBase pSWFProcessTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFProcessTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getPSWFProcessTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocesstypeid", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getPSWFProcessTypeId()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getPSWFProcessTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfprocesstypename", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getPSWFProcessTypeName()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFProcessTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSWFProcessTypeBase.getJSONValue((Object)pSWFProcessTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFProcessTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFProcessTypeBase pSWFProcessTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFProcessTypeBase.getCreateDate() != null) {
            object = pSWFProcessTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcessTypeBase.getCreateMan() != null) {
            object = pSWFProcessTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessTypeBase.getIconPath() != null) {
            object = pSWFProcessTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessTypeBase.getItemObj() != null) {
            object = pSWFProcessTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessTypeBase.getMemo() != null) {
            object = pSWFProcessTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessTypeBase.getPSWFProcessTypeId() != null) {
            object = pSWFProcessTypeBase.getPSWFProcessTypeId();
            xmlNode.setAttribute(FIELD_PSWFPROCESSTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessTypeBase.getPSWFProcessTypeName() != null) {
            object = pSWFProcessTypeBase.getPSWFProcessTypeName();
            xmlNode.setAttribute(FIELD_PSWFPROCESSTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessTypeBase.getUpdateDate() != null) {
            object = pSWFProcessTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFProcessTypeBase.getUpdateMan() != null) {
            object = pSWFProcessTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFProcessTypeBase.getValidFlag() != null) {
            object = pSWFProcessTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFProcessTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFProcessTypeBase pSWFProcessTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFProcessTypeBase.isCreateDateDirty() && (bl || pSWFProcessTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFProcessTypeBase.getCreateDate());
        }
        if (pSWFProcessTypeBase.isCreateManDirty() && (bl || pSWFProcessTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFProcessTypeBase.getCreateMan());
        }
        if (pSWFProcessTypeBase.isIconPathDirty() && (bl || pSWFProcessTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSWFProcessTypeBase.getIconPath());
        }
        if (pSWFProcessTypeBase.isItemObjDirty() && (bl || pSWFProcessTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSWFProcessTypeBase.getItemObj());
        }
        if (pSWFProcessTypeBase.isMemoDirty() && (bl || pSWFProcessTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFProcessTypeBase.getMemo());
        }
        if (pSWFProcessTypeBase.isPSWFProcessTypeIdDirty() && (bl || pSWFProcessTypeBase.getPSWFProcessTypeId() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSTYPEID, (Object)pSWFProcessTypeBase.getPSWFProcessTypeId());
        }
        if (pSWFProcessTypeBase.isPSWFProcessTypeNameDirty() && (bl || pSWFProcessTypeBase.getPSWFProcessTypeName() != null)) {
            iDataObject.set(FIELD_PSWFPROCESSTYPENAME, (Object)pSWFProcessTypeBase.getPSWFProcessTypeName());
        }
        if (pSWFProcessTypeBase.isUpdateDateDirty() && (bl || pSWFProcessTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFProcessTypeBase.getUpdateDate());
        }
        if (pSWFProcessTypeBase.isUpdateManDirty() && (bl || pSWFProcessTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFProcessTypeBase.getUpdateMan());
        }
        if (pSWFProcessTypeBase.isValidFlagDirty() && (bl || pSWFProcessTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSWFProcessTypeBase.getValidFlag());
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
        return PSWFProcessTypeBase.remove(this, n);
    }

    private static boolean remove(PSWFProcessTypeBase pSWFProcessTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFProcessTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWFProcessTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWFProcessTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSWFProcessTypeBase.resetItemObj();
                return true;
            }
            case 4: {
                pSWFProcessTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSWFProcessTypeBase.resetPSWFProcessTypeId();
                return true;
            }
            case 6: {
                pSWFProcessTypeBase.resetPSWFProcessTypeName();
                return true;
            }
            case 7: {
                pSWFProcessTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSWFProcessTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSWFProcessTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSWFProcessTypeBase getProxyEntity() {
        return this.proxyPSWFProcessTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFProcessTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFProcessTypeBase) {
            this.proxyPSWFProcessTypeBase = (PSWFProcessTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSWFProcessTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_ITEMOBJ, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSWFPROCESSTYPEID, 5);
        fieldIndexMap.put(FIELD_PSWFPROCESSTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

