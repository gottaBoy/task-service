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

public abstract class PSUILogicTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUILogicTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSUILOGICTYPEID = "PSUILOGICTYPEID";
    public static final String FIELD_PSUILOGICTYPENAME = "PSUILOGICTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSUILOGICTYPEID = 2;
    private static final int INDEX_PSUILOGICTYPENAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUILogicTypeBase proxyPSUILogicTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psuilogictypeidDirtyFlag = false;
    private boolean psuilogictypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psuilogictypeid")
    private String psuilogictypeid;
    @Column(name="psuilogictypename")
    private String psuilogictypename;
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

    public void setPSUILogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUILogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuilogictypeid = string;
        this.psuilogictypeidDirtyFlag = true;
    }

    public String getPSUILogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUILogicTypeId();
        }
        return this.psuilogictypeid;
    }

    public boolean isPSUILogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUILogicTypeIdDirty();
        }
        return this.psuilogictypeidDirtyFlag;
    }

    public void resetPSUILogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUILogicTypeId();
            return;
        }
        this.psuilogictypeidDirtyFlag = false;
        this.psuilogictypeid = null;
    }

    public void setPSUILogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUILogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuilogictypename = string;
        this.psuilogictypenameDirtyFlag = true;
    }

    public String getPSUILogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUILogicTypeName();
        }
        return this.psuilogictypename;
    }

    public boolean isPSUILogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUILogicTypeNameDirty();
        }
        return this.psuilogictypenameDirtyFlag;
    }

    public void resetPSUILogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUILogicTypeName();
            return;
        }
        this.psuilogictypenameDirtyFlag = false;
        this.psuilogictypename = null;
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
        PSUILogicTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUILogicTypeBase pSUILogicTypeBase) {
        pSUILogicTypeBase.resetCreateDate();
        pSUILogicTypeBase.resetCreateMan();
        pSUILogicTypeBase.resetPSUILogicTypeId();
        pSUILogicTypeBase.resetPSUILogicTypeName();
        pSUILogicTypeBase.resetUpdateDate();
        pSUILogicTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSUILogicTypeIdDirty()) {
            hashMap.put(FIELD_PSUILOGICTYPEID, this.getPSUILogicTypeId());
        }
        if (!bl || this.isPSUILogicTypeNameDirty()) {
            hashMap.put(FIELD_PSUILOGICTYPENAME, this.getPSUILogicTypeName());
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
        return PSUILogicTypeBase.get(this, n);
    }

    private static Object get(PSUILogicTypeBase pSUILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUILogicTypeBase.getCreateDate();
            }
            case 1: {
                return pSUILogicTypeBase.getCreateMan();
            }
            case 2: {
                return pSUILogicTypeBase.getPSUILogicTypeId();
            }
            case 3: {
                return pSUILogicTypeBase.getPSUILogicTypeName();
            }
            case 4: {
                return pSUILogicTypeBase.getUpdateDate();
            }
            case 5: {
                return pSUILogicTypeBase.getUpdateMan();
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
        PSUILogicTypeBase.set(this, n, object);
    }

    private static void set(PSUILogicTypeBase pSUILogicTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUILogicTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUILogicTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUILogicTypeBase.setPSUILogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUILogicTypeBase.setPSUILogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUILogicTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSUILogicTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUILogicTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSUILogicTypeBase pSUILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUILogicTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSUILogicTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSUILogicTypeBase.getPSUILogicTypeId() == null;
            }
            case 3: {
                return pSUILogicTypeBase.getPSUILogicTypeName() == null;
            }
            case 4: {
                return pSUILogicTypeBase.getUpdateDate() == null;
            }
            case 5: {
                return pSUILogicTypeBase.getUpdateMan() == null;
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
        return PSUILogicTypeBase.contains(this, n);
    }

    private static boolean contains(PSUILogicTypeBase pSUILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUILogicTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSUILogicTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSUILogicTypeBase.isPSUILogicTypeIdDirty();
            }
            case 3: {
                return pSUILogicTypeBase.isPSUILogicTypeNameDirty();
            }
            case 4: {
                return pSUILogicTypeBase.isUpdateDateDirty();
            }
            case 5: {
                return pSUILogicTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUILogicTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUILogicTypeBase pSUILogicTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUILogicTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUILogicTypeBase.getJSONValue((Object)pSUILogicTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUILogicTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUILogicTypeBase.getJSONValue((Object)pSUILogicTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUILogicTypeBase.getPSUILogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuilogictypeid", (Object)PSUILogicTypeBase.getJSONValue((Object)pSUILogicTypeBase.getPSUILogicTypeId()), (boolean)false);
        }
        if (bl || pSUILogicTypeBase.getPSUILogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuilogictypename", (Object)PSUILogicTypeBase.getJSONValue((Object)pSUILogicTypeBase.getPSUILogicTypeName()), (boolean)false);
        }
        if (bl || pSUILogicTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUILogicTypeBase.getJSONValue((Object)pSUILogicTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUILogicTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUILogicTypeBase.getJSONValue((Object)pSUILogicTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUILogicTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUILogicTypeBase pSUILogicTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUILogicTypeBase.getCreateDate() != null) {
            object = pSUILogicTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUILogicTypeBase.getCreateMan() != null) {
            object = pSUILogicTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUILogicTypeBase.getPSUILogicTypeId() != null) {
            object = pSUILogicTypeBase.getPSUILogicTypeId();
            xmlNode.setAttribute(FIELD_PSUILOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSUILogicTypeBase.getPSUILogicTypeName() != null) {
            object = pSUILogicTypeBase.getPSUILogicTypeName();
            xmlNode.setAttribute(FIELD_PSUILOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUILogicTypeBase.getUpdateDate() != null) {
            object = pSUILogicTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUILogicTypeBase.getUpdateMan() != null) {
            object = pSUILogicTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUILogicTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUILogicTypeBase pSUILogicTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUILogicTypeBase.isCreateDateDirty() && (bl || pSUILogicTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUILogicTypeBase.getCreateDate());
        }
        if (pSUILogicTypeBase.isCreateManDirty() && (bl || pSUILogicTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUILogicTypeBase.getCreateMan());
        }
        if (pSUILogicTypeBase.isPSUILogicTypeIdDirty() && (bl || pSUILogicTypeBase.getPSUILogicTypeId() != null)) {
            iDataObject.set(FIELD_PSUILOGICTYPEID, (Object)pSUILogicTypeBase.getPSUILogicTypeId());
        }
        if (pSUILogicTypeBase.isPSUILogicTypeNameDirty() && (bl || pSUILogicTypeBase.getPSUILogicTypeName() != null)) {
            iDataObject.set(FIELD_PSUILOGICTYPENAME, (Object)pSUILogicTypeBase.getPSUILogicTypeName());
        }
        if (pSUILogicTypeBase.isUpdateDateDirty() && (bl || pSUILogicTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUILogicTypeBase.getUpdateDate());
        }
        if (pSUILogicTypeBase.isUpdateManDirty() && (bl || pSUILogicTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUILogicTypeBase.getUpdateMan());
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
        return PSUILogicTypeBase.remove(this, n);
    }

    private static boolean remove(PSUILogicTypeBase pSUILogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUILogicTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUILogicTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUILogicTypeBase.resetPSUILogicTypeId();
                return true;
            }
            case 3: {
                pSUILogicTypeBase.resetPSUILogicTypeName();
                return true;
            }
            case 4: {
                pSUILogicTypeBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSUILogicTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUILogicTypeBase getProxyEntity() {
        return this.proxyPSUILogicTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUILogicTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSUILogicTypeBase) {
            this.proxyPSUILogicTypeBase = (PSUILogicTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUILogicTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSUILOGICTYPEID, 2);
        fieldIndexMap.put(FIELD_PSUILOGICTYPENAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

