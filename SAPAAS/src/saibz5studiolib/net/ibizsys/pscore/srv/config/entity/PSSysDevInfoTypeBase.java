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

public abstract class PSSysDevInfoTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDevInfoTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSDEVINFOTYPEID = "PSSYSDEVINFOTYPEID";
    public static final String FIELD_PSSYSDEVINFOTYPENAME = "PSSYSDEVINFOTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSDEVINFOTYPEID = 2;
    private static final int INDEX_PSSYSDEVINFOTYPENAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDevInfoTypeBase proxyPSSysDevInfoTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysdevinfotypeidDirtyFlag = false;
    private boolean pssysdevinfotypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysdevinfotypeid")
    private String pssysdevinfotypeid;
    @Column(name="pssysdevinfotypename")
    private String pssysdevinfotypename;
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

    public void setPSSysDevInfoTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevInfoTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevinfotypeid = string;
        this.pssysdevinfotypeidDirtyFlag = true;
    }

    public String getPSSysDevInfoTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevInfoTypeId();
        }
        return this.pssysdevinfotypeid;
    }

    public boolean isPSSysDevInfoTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevInfoTypeIdDirty();
        }
        return this.pssysdevinfotypeidDirtyFlag;
    }

    public void resetPSSysDevInfoTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevInfoTypeId();
            return;
        }
        this.pssysdevinfotypeidDirtyFlag = false;
        this.pssysdevinfotypeid = null;
    }

    public void setPSSysDevInfoTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevInfoTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevinfotypename = string;
        this.pssysdevinfotypenameDirtyFlag = true;
    }

    public String getPSSysDevInfoTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevInfoTypeName();
        }
        return this.pssysdevinfotypename;
    }

    public boolean isPSSysDevInfoTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevInfoTypeNameDirty();
        }
        return this.pssysdevinfotypenameDirtyFlag;
    }

    public void resetPSSysDevInfoTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevInfoTypeName();
            return;
        }
        this.pssysdevinfotypenameDirtyFlag = false;
        this.pssysdevinfotypename = null;
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
        PSSysDevInfoTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDevInfoTypeBase pSSysDevInfoTypeBase) {
        pSSysDevInfoTypeBase.resetCreateDate();
        pSSysDevInfoTypeBase.resetCreateMan();
        pSSysDevInfoTypeBase.resetPSSysDevInfoTypeId();
        pSSysDevInfoTypeBase.resetPSSysDevInfoTypeName();
        pSSysDevInfoTypeBase.resetUpdateDate();
        pSSysDevInfoTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysDevInfoTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSDEVINFOTYPEID, this.getPSSysDevInfoTypeId());
        }
        if (!bl || this.isPSSysDevInfoTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSDEVINFOTYPENAME, this.getPSSysDevInfoTypeName());
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
        return PSSysDevInfoTypeBase.get(this, n);
    }

    private static Object get(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevInfoTypeBase.getCreateDate();
            }
            case 1: {
                return pSSysDevInfoTypeBase.getCreateMan();
            }
            case 2: {
                return pSSysDevInfoTypeBase.getPSSysDevInfoTypeId();
            }
            case 3: {
                return pSSysDevInfoTypeBase.getPSSysDevInfoTypeName();
            }
            case 4: {
                return pSSysDevInfoTypeBase.getUpdateDate();
            }
            case 5: {
                return pSSysDevInfoTypeBase.getUpdateMan();
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
        PSSysDevInfoTypeBase.set(this, n, object);
    }

    private static void set(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevInfoTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDevInfoTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDevInfoTypeBase.setPSSysDevInfoTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDevInfoTypeBase.setPSSysDevInfoTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDevInfoTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysDevInfoTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDevInfoTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevInfoTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDevInfoTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDevInfoTypeBase.getPSSysDevInfoTypeId() == null;
            }
            case 3: {
                return pSSysDevInfoTypeBase.getPSSysDevInfoTypeName() == null;
            }
            case 4: {
                return pSSysDevInfoTypeBase.getUpdateDate() == null;
            }
            case 5: {
                return pSSysDevInfoTypeBase.getUpdateMan() == null;
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
        return PSSysDevInfoTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevInfoTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDevInfoTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDevInfoTypeBase.isPSSysDevInfoTypeIdDirty();
            }
            case 3: {
                return pSSysDevInfoTypeBase.isPSSysDevInfoTypeNameDirty();
            }
            case 4: {
                return pSSysDevInfoTypeBase.isUpdateDateDirty();
            }
            case 5: {
                return pSSysDevInfoTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDevInfoTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDevInfoTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDevInfoTypeBase.getJSONValue((Object)pSSysDevInfoTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDevInfoTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDevInfoTypeBase.getJSONValue((Object)pSSysDevInfoTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDevInfoTypeBase.getPSSysDevInfoTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevinfotypeid", (Object)PSSysDevInfoTypeBase.getJSONValue((Object)pSSysDevInfoTypeBase.getPSSysDevInfoTypeId()), (boolean)false);
        }
        if (bl || pSSysDevInfoTypeBase.getPSSysDevInfoTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevinfotypename", (Object)PSSysDevInfoTypeBase.getJSONValue((Object)pSSysDevInfoTypeBase.getPSSysDevInfoTypeName()), (boolean)false);
        }
        if (bl || pSSysDevInfoTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDevInfoTypeBase.getJSONValue((Object)pSSysDevInfoTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDevInfoTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDevInfoTypeBase.getJSONValue((Object)pSSysDevInfoTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDevInfoTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDevInfoTypeBase.getCreateDate() != null) {
            object = pSSysDevInfoTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevInfoTypeBase.getCreateMan() != null) {
            object = pSSysDevInfoTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevInfoTypeBase.getPSSysDevInfoTypeId() != null) {
            object = pSSysDevInfoTypeBase.getPSSysDevInfoTypeId();
            xmlNode.setAttribute(FIELD_PSSYSDEVINFOTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevInfoTypeBase.getPSSysDevInfoTypeName() != null) {
            object = pSSysDevInfoTypeBase.getPSSysDevInfoTypeName();
            xmlNode.setAttribute(FIELD_PSSYSDEVINFOTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevInfoTypeBase.getUpdateDate() != null) {
            object = pSSysDevInfoTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevInfoTypeBase.getUpdateMan() != null) {
            object = pSSysDevInfoTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDevInfoTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDevInfoTypeBase.isCreateDateDirty() && (bl || pSSysDevInfoTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDevInfoTypeBase.getCreateDate());
        }
        if (pSSysDevInfoTypeBase.isCreateManDirty() && (bl || pSSysDevInfoTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDevInfoTypeBase.getCreateMan());
        }
        if (pSSysDevInfoTypeBase.isPSSysDevInfoTypeIdDirty() && (bl || pSSysDevInfoTypeBase.getPSSysDevInfoTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSDEVINFOTYPEID, (Object)pSSysDevInfoTypeBase.getPSSysDevInfoTypeId());
        }
        if (pSSysDevInfoTypeBase.isPSSysDevInfoTypeNameDirty() && (bl || pSSysDevInfoTypeBase.getPSSysDevInfoTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSDEVINFOTYPENAME, (Object)pSSysDevInfoTypeBase.getPSSysDevInfoTypeName());
        }
        if (pSSysDevInfoTypeBase.isUpdateDateDirty() && (bl || pSSysDevInfoTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDevInfoTypeBase.getUpdateDate());
        }
        if (pSSysDevInfoTypeBase.isUpdateManDirty() && (bl || pSSysDevInfoTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDevInfoTypeBase.getUpdateMan());
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
        return PSSysDevInfoTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysDevInfoTypeBase pSSysDevInfoTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevInfoTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDevInfoTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDevInfoTypeBase.resetPSSysDevInfoTypeId();
                return true;
            }
            case 3: {
                pSSysDevInfoTypeBase.resetPSSysDevInfoTypeName();
                return true;
            }
            case 4: {
                pSSysDevInfoTypeBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSSysDevInfoTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysDevInfoTypeBase getProxyEntity() {
        return this.proxyPSSysDevInfoTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDevInfoTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDevInfoTypeBase) {
            this.proxyPSSysDevInfoTypeBase = (PSSysDevInfoTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysDevInfoTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSDEVINFOTYPEID, 2);
        fieldIndexMap.put(FIELD_PSSYSDEVINFOTYPENAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

