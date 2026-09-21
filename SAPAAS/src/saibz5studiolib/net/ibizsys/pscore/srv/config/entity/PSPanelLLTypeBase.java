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

public abstract class PSPanelLLTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLLTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPANELLLTYPEID = "PSPANELLLTYPEID";
    public static final String FIELD_PSPANELLLTYPENAME = "PSPANELLLTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_ITEMOBJ = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSPANELLLTYPEID = 5;
    private static final int INDEX_PSPANELLLTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLLTypeBase proxyPSPanelLLTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspanellltypeidDirtyFlag = false;
    private boolean pspanellltypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
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
    @Column(name="pspanellltypeid")
    private String pspanellltypeid;
    @Column(name="pspanellltypename")
    private String pspanellltypename;
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

    public void setPSPanelLLTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLLTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellltypeid = string;
        this.pspanellltypeidDirtyFlag = true;
    }

    public String getPSPanelLLTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLTypeId();
        }
        return this.pspanellltypeid;
    }

    public boolean isPSPanelLLTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLLTypeIdDirty();
        }
        return this.pspanellltypeidDirtyFlag;
    }

    public void resetPSPanelLLTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLLTypeId();
            return;
        }
        this.pspanellltypeidDirtyFlag = false;
        this.pspanellltypeid = null;
    }

    public void setPSPanelLLTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLLTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellltypename = string;
        this.pspanellltypenameDirtyFlag = true;
    }

    public String getPSPanelLLTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLTypeName();
        }
        return this.pspanellltypename;
    }

    public boolean isPSPanelLLTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLLTypeNameDirty();
        }
        return this.pspanellltypenameDirtyFlag;
    }

    public void resetPSPanelLLTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLLTypeName();
            return;
        }
        this.pspanellltypenameDirtyFlag = false;
        this.pspanellltypename = null;
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
        PSPanelLLTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLLTypeBase pSPanelLLTypeBase) {
        pSPanelLLTypeBase.resetCreateDate();
        pSPanelLLTypeBase.resetCreateMan();
        pSPanelLLTypeBase.resetIconPath();
        pSPanelLLTypeBase.resetItemObj();
        pSPanelLLTypeBase.resetMemo();
        pSPanelLLTypeBase.resetPSPanelLLTypeId();
        pSPanelLLTypeBase.resetPSPanelLLTypeName();
        pSPanelLLTypeBase.resetUpdateDate();
        pSPanelLLTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSPanelLLTypeIdDirty()) {
            hashMap.put(FIELD_PSPANELLLTYPEID, this.getPSPanelLLTypeId());
        }
        if (!bl || this.isPSPanelLLTypeNameDirty()) {
            hashMap.put(FIELD_PSPANELLLTYPENAME, this.getPSPanelLLTypeName());
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
        return PSPanelLLTypeBase.get(this, n);
    }

    private static Object get(PSPanelLLTypeBase pSPanelLLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLTypeBase.getCreateDate();
            }
            case 1: {
                return pSPanelLLTypeBase.getCreateMan();
            }
            case 2: {
                return pSPanelLLTypeBase.getIconPath();
            }
            case 3: {
                return pSPanelLLTypeBase.getItemObj();
            }
            case 4: {
                return pSPanelLLTypeBase.getMemo();
            }
            case 5: {
                return pSPanelLLTypeBase.getPSPanelLLTypeId();
            }
            case 6: {
                return pSPanelLLTypeBase.getPSPanelLLTypeName();
            }
            case 7: {
                return pSPanelLLTypeBase.getUpdateDate();
            }
            case 8: {
                return pSPanelLLTypeBase.getUpdateMan();
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
        PSPanelLLTypeBase.set(this, n, object);
    }

    private static void set(PSPanelLLTypeBase pSPanelLLTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLLTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLLTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLLTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLLTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLLTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLLTypeBase.setPSPanelLLTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLLTypeBase.setPSPanelLLTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLLTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSPanelLLTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLLTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLLTypeBase pSPanelLLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPanelLLTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPanelLLTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSPanelLLTypeBase.getItemObj() == null;
            }
            case 4: {
                return pSPanelLLTypeBase.getMemo() == null;
            }
            case 5: {
                return pSPanelLLTypeBase.getPSPanelLLTypeId() == null;
            }
            case 6: {
                return pSPanelLLTypeBase.getPSPanelLLTypeName() == null;
            }
            case 7: {
                return pSPanelLLTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSPanelLLTypeBase.getUpdateMan() == null;
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
        return PSPanelLLTypeBase.contains(this, n);
    }

    private static boolean contains(PSPanelLLTypeBase pSPanelLLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPanelLLTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPanelLLTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSPanelLLTypeBase.isItemObjDirty();
            }
            case 4: {
                return pSPanelLLTypeBase.isMemoDirty();
            }
            case 5: {
                return pSPanelLLTypeBase.isPSPanelLLTypeIdDirty();
            }
            case 6: {
                return pSPanelLLTypeBase.isPSPanelLLTypeNameDirty();
            }
            case 7: {
                return pSPanelLLTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSPanelLLTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLLTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLLTypeBase pSPanelLLTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLLTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getPSPanelLLTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellltypeid", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getPSPanelLLTypeId()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getPSPanelLLTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellltypename", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getPSPanelLLTypeName()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLLTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLLTypeBase.getJSONValue((Object)pSPanelLLTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLLTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLLTypeBase pSPanelLLTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLLTypeBase.getCreateDate() != null) {
            object = pSPanelLLTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLLTypeBase.getCreateMan() != null) {
            object = pSPanelLLTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLTypeBase.getIconPath() != null) {
            object = pSPanelLLTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLTypeBase.getItemObj() != null) {
            object = pSPanelLLTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLTypeBase.getMemo() != null) {
            object = pSPanelLLTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLTypeBase.getPSPanelLLTypeId() != null) {
            object = pSPanelLLTypeBase.getPSPanelLLTypeId();
            xmlNode.setAttribute(FIELD_PSPANELLLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLTypeBase.getPSPanelLLTypeName() != null) {
            object = pSPanelLLTypeBase.getPSPanelLLTypeName();
            xmlNode.setAttribute(FIELD_PSPANELLLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLTypeBase.getUpdateDate() != null) {
            object = pSPanelLLTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLLTypeBase.getUpdateMan() != null) {
            object = pSPanelLLTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLLTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLLTypeBase pSPanelLLTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLLTypeBase.isCreateDateDirty() && (bl || pSPanelLLTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLLTypeBase.getCreateDate());
        }
        if (pSPanelLLTypeBase.isCreateManDirty() && (bl || pSPanelLLTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLLTypeBase.getCreateMan());
        }
        if (pSPanelLLTypeBase.isIconPathDirty() && (bl || pSPanelLLTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSPanelLLTypeBase.getIconPath());
        }
        if (pSPanelLLTypeBase.isItemObjDirty() && (bl || pSPanelLLTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSPanelLLTypeBase.getItemObj());
        }
        if (pSPanelLLTypeBase.isMemoDirty() && (bl || pSPanelLLTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelLLTypeBase.getMemo());
        }
        if (pSPanelLLTypeBase.isPSPanelLLTypeIdDirty() && (bl || pSPanelLLTypeBase.getPSPanelLLTypeId() != null)) {
            iDataObject.set(FIELD_PSPANELLLTYPEID, (Object)pSPanelLLTypeBase.getPSPanelLLTypeId());
        }
        if (pSPanelLLTypeBase.isPSPanelLLTypeNameDirty() && (bl || pSPanelLLTypeBase.getPSPanelLLTypeName() != null)) {
            iDataObject.set(FIELD_PSPANELLLTYPENAME, (Object)pSPanelLLTypeBase.getPSPanelLLTypeName());
        }
        if (pSPanelLLTypeBase.isUpdateDateDirty() && (bl || pSPanelLLTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLLTypeBase.getUpdateDate());
        }
        if (pSPanelLLTypeBase.isUpdateManDirty() && (bl || pSPanelLLTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLLTypeBase.getUpdateMan());
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
        return PSPanelLLTypeBase.remove(this, n);
    }

    private static boolean remove(PSPanelLLTypeBase pSPanelLLTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLLTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPanelLLTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPanelLLTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSPanelLLTypeBase.resetItemObj();
                return true;
            }
            case 4: {
                pSPanelLLTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSPanelLLTypeBase.resetPSPanelLLTypeId();
                return true;
            }
            case 6: {
                pSPanelLLTypeBase.resetPSPanelLLTypeName();
                return true;
            }
            case 7: {
                pSPanelLLTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSPanelLLTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPanelLLTypeBase getProxyEntity() {
        return this.proxyPSPanelLLTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLLTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLLTypeBase) {
            this.proxyPSPanelLLTypeBase = (PSPanelLLTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPanelLLTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_ITEMOBJ, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSPANELLLTYPEID, 5);
        fieldIndexMap.put(FIELD_PSPANELLLTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

