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

public abstract class PSModelResourceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelResourceBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IMAGEURL = "IMAGEURL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELRESOURCEID = "PSMODELRESOURCEID";
    public static final String FIELD_PSMODELRESOURCENAME = "PSMODELRESOURCENAME";
    public static final String FIELD_RESOURCETYPE = "RESOURCETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_IMAGEURL = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSMODELRESOURCEID = 4;
    private static final int INDEX_PSMODELRESOURCENAME = 5;
    private static final int INDEX_RESOURCETYPE = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelResourceBase proxyPSModelResourceBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean imageurlDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodelresourceidDirtyFlag = false;
    private boolean psmodelresourcenameDirtyFlag = false;
    private boolean resourcetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="imageurl")
    private String imageurl;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodelresourceid")
    private String psmodelresourceid;
    @Column(name="psmodelresourcename")
    private String psmodelresourcename;
    @Column(name="resourcetype")
    private String resourcetype;
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

    public void setImageURL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImageURL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.imageurl = string;
        this.imageurlDirtyFlag = true;
    }

    public String getImageURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImageURL();
        }
        return this.imageurl;
    }

    public boolean isImageURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImageURLDirty();
        }
        return this.imageurlDirtyFlag;
    }

    public void resetImageURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImageURL();
            return;
        }
        this.imageurlDirtyFlag = false;
        this.imageurl = null;
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

    public void setPSModelResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelresourceid = string;
        this.psmodelresourceidDirtyFlag = true;
    }

    public String getPSModelResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelResourceId();
        }
        return this.psmodelresourceid;
    }

    public boolean isPSModelResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelResourceIdDirty();
        }
        return this.psmodelresourceidDirtyFlag;
    }

    public void resetPSModelResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelResourceId();
            return;
        }
        this.psmodelresourceidDirtyFlag = false;
        this.psmodelresourceid = null;
    }

    public void setPSModelResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelresourcename = string;
        this.psmodelresourcenameDirtyFlag = true;
    }

    public String getPSModelResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelResourceName();
        }
        return this.psmodelresourcename;
    }

    public boolean isPSModelResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelResourceNameDirty();
        }
        return this.psmodelresourcenameDirtyFlag;
    }

    public void resetPSModelResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelResourceName();
            return;
        }
        this.psmodelresourcenameDirtyFlag = false;
        this.psmodelresourcename = null;
    }

    public void setResourceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResourceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resourcetype = string;
        this.resourcetypeDirtyFlag = true;
    }

    public String getResourceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResourceType();
        }
        return this.resourcetype;
    }

    public boolean isResourceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResourceTypeDirty();
        }
        return this.resourcetypeDirtyFlag;
    }

    public void resetResourceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResourceType();
            return;
        }
        this.resourcetypeDirtyFlag = false;
        this.resourcetype = null;
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
        PSModelResourceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelResourceBase pSModelResourceBase) {
        pSModelResourceBase.resetCreateDate();
        pSModelResourceBase.resetCreateMan();
        pSModelResourceBase.resetImageURL();
        pSModelResourceBase.resetMemo();
        pSModelResourceBase.resetPSModelResourceId();
        pSModelResourceBase.resetPSModelResourceName();
        pSModelResourceBase.resetResourceType();
        pSModelResourceBase.resetUpdateDate();
        pSModelResourceBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isImageURLDirty()) {
            hashMap.put(FIELD_IMAGEURL, this.getImageURL());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModelResourceIdDirty()) {
            hashMap.put(FIELD_PSMODELRESOURCEID, this.getPSModelResourceId());
        }
        if (!bl || this.isPSModelResourceNameDirty()) {
            hashMap.put(FIELD_PSMODELRESOURCENAME, this.getPSModelResourceName());
        }
        if (!bl || this.isResourceTypeDirty()) {
            hashMap.put(FIELD_RESOURCETYPE, this.getResourceType());
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
        return PSModelResourceBase.get(this, n);
    }

    private static Object get(PSModelResourceBase pSModelResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelResourceBase.getCreateDate();
            }
            case 1: {
                return pSModelResourceBase.getCreateMan();
            }
            case 2: {
                return pSModelResourceBase.getImageURL();
            }
            case 3: {
                return pSModelResourceBase.getMemo();
            }
            case 4: {
                return pSModelResourceBase.getPSModelResourceId();
            }
            case 5: {
                return pSModelResourceBase.getPSModelResourceName();
            }
            case 6: {
                return pSModelResourceBase.getResourceType();
            }
            case 7: {
                return pSModelResourceBase.getUpdateDate();
            }
            case 8: {
                return pSModelResourceBase.getUpdateMan();
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
        PSModelResourceBase.set(this, n, object);
    }

    private static void set(PSModelResourceBase pSModelResourceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelResourceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelResourceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelResourceBase.setImageURL(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelResourceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelResourceBase.setPSModelResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelResourceBase.setPSModelResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelResourceBase.setResourceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelResourceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSModelResourceBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelResourceBase.isNull(this, n);
    }

    private static boolean isNull(PSModelResourceBase pSModelResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelResourceBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelResourceBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelResourceBase.getImageURL() == null;
            }
            case 3: {
                return pSModelResourceBase.getMemo() == null;
            }
            case 4: {
                return pSModelResourceBase.getPSModelResourceId() == null;
            }
            case 5: {
                return pSModelResourceBase.getPSModelResourceName() == null;
            }
            case 6: {
                return pSModelResourceBase.getResourceType() == null;
            }
            case 7: {
                return pSModelResourceBase.getUpdateDate() == null;
            }
            case 8: {
                return pSModelResourceBase.getUpdateMan() == null;
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
        return PSModelResourceBase.contains(this, n);
    }

    private static boolean contains(PSModelResourceBase pSModelResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelResourceBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelResourceBase.isCreateManDirty();
            }
            case 2: {
                return pSModelResourceBase.isImageURLDirty();
            }
            case 3: {
                return pSModelResourceBase.isMemoDirty();
            }
            case 4: {
                return pSModelResourceBase.isPSModelResourceIdDirty();
            }
            case 5: {
                return pSModelResourceBase.isPSModelResourceNameDirty();
            }
            case 6: {
                return pSModelResourceBase.isResourceTypeDirty();
            }
            case 7: {
                return pSModelResourceBase.isUpdateDateDirty();
            }
            case 8: {
                return pSModelResourceBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelResourceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelResourceBase pSModelResourceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelResourceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getImageURL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageurl", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getImageURL()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getPSModelResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelresourceid", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getPSModelResourceId()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getPSModelResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelresourcename", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getPSModelResourceName()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getResourceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resourcetype", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getResourceType()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelResourceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelResourceBase.getJSONValue((Object)pSModelResourceBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelResourceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelResourceBase pSModelResourceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelResourceBase.getCreateDate() != null) {
            object = pSModelResourceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelResourceBase.getCreateMan() != null) {
            object = pSModelResourceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelResourceBase.getImageURL() != null) {
            object = pSModelResourceBase.getImageURL();
            xmlNode.setAttribute(FIELD_IMAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSModelResourceBase.getMemo() != null) {
            object = pSModelResourceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelResourceBase.getPSModelResourceId() != null) {
            object = pSModelResourceBase.getPSModelResourceId();
            xmlNode.setAttribute(FIELD_PSMODELRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelResourceBase.getPSModelResourceName() != null) {
            object = pSModelResourceBase.getPSModelResourceName();
            xmlNode.setAttribute(FIELD_PSMODELRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelResourceBase.getResourceType() != null) {
            object = pSModelResourceBase.getResourceType();
            xmlNode.setAttribute(FIELD_RESOURCETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelResourceBase.getUpdateDate() != null) {
            object = pSModelResourceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelResourceBase.getUpdateMan() != null) {
            object = pSModelResourceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelResourceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelResourceBase pSModelResourceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelResourceBase.isCreateDateDirty() && (bl || pSModelResourceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelResourceBase.getCreateDate());
        }
        if (pSModelResourceBase.isCreateManDirty() && (bl || pSModelResourceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelResourceBase.getCreateMan());
        }
        if (pSModelResourceBase.isImageURLDirty() && (bl || pSModelResourceBase.getImageURL() != null)) {
            iDataObject.set(FIELD_IMAGEURL, (Object)pSModelResourceBase.getImageURL());
        }
        if (pSModelResourceBase.isMemoDirty() && (bl || pSModelResourceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelResourceBase.getMemo());
        }
        if (pSModelResourceBase.isPSModelResourceIdDirty() && (bl || pSModelResourceBase.getPSModelResourceId() != null)) {
            iDataObject.set(FIELD_PSMODELRESOURCEID, (Object)pSModelResourceBase.getPSModelResourceId());
        }
        if (pSModelResourceBase.isPSModelResourceNameDirty() && (bl || pSModelResourceBase.getPSModelResourceName() != null)) {
            iDataObject.set(FIELD_PSMODELRESOURCENAME, (Object)pSModelResourceBase.getPSModelResourceName());
        }
        if (pSModelResourceBase.isResourceTypeDirty() && (bl || pSModelResourceBase.getResourceType() != null)) {
            iDataObject.set(FIELD_RESOURCETYPE, (Object)pSModelResourceBase.getResourceType());
        }
        if (pSModelResourceBase.isUpdateDateDirty() && (bl || pSModelResourceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelResourceBase.getUpdateDate());
        }
        if (pSModelResourceBase.isUpdateManDirty() && (bl || pSModelResourceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelResourceBase.getUpdateMan());
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
        return PSModelResourceBase.remove(this, n);
    }

    private static boolean remove(PSModelResourceBase pSModelResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelResourceBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelResourceBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelResourceBase.resetImageURL();
                return true;
            }
            case 3: {
                pSModelResourceBase.resetMemo();
                return true;
            }
            case 4: {
                pSModelResourceBase.resetPSModelResourceId();
                return true;
            }
            case 5: {
                pSModelResourceBase.resetPSModelResourceName();
                return true;
            }
            case 6: {
                pSModelResourceBase.resetResourceType();
                return true;
            }
            case 7: {
                pSModelResourceBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSModelResourceBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelResourceBase getProxyEntity() {
        return this.proxyPSModelResourceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelResourceBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelResourceBase) {
            this.proxyPSModelResourceBase = (PSModelResourceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelResourceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_IMAGEURL, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSMODELRESOURCEID, 4);
        fieldIndexMap.put(FIELD_PSMODELRESOURCENAME, 5);
        fieldIndexMap.put(FIELD_RESOURCETYPE, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

