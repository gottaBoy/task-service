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

public abstract class PSSysDSActoinTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDSActoinTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSDSACTIONTYPEID = "PSSYSDSACTIONTYPEID";
    public static final String FIELD_PSSYSDSACTIONTYPENAME = "PSSYSDSACTIONTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSDSACTIONTYPEID = 2;
    private static final int INDEX_PSSYSDSACTIONTYPENAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDSActoinTypeBase proxyPSSysDSActoinTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysdsactiontypeidDirtyFlag = false;
    private boolean pssysdsactiontypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysdsactiontypeid")
    private String pssysdsactiontypeid;
    @Column(name="pssysdsactiontypename")
    private String pssysdsactiontypename;
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

    public void setPSSysDSActionTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDSActionTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdsactiontypeid = string;
        this.pssysdsactiontypeidDirtyFlag = true;
    }

    public String getPSSysDSActionTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDSActionTypeId();
        }
        return this.pssysdsactiontypeid;
    }

    public boolean isPSSysDSActionTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDSActionTypeIdDirty();
        }
        return this.pssysdsactiontypeidDirtyFlag;
    }

    public void resetPSSysDSActionTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDSActionTypeId();
            return;
        }
        this.pssysdsactiontypeidDirtyFlag = false;
        this.pssysdsactiontypeid = null;
    }

    public void setPSSysDSActionTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDSActionTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdsactiontypename = string;
        this.pssysdsactiontypenameDirtyFlag = true;
    }

    public String getPSSysDSActionTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDSActionTypeName();
        }
        return this.pssysdsactiontypename;
    }

    public boolean isPSSysDSActionTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDSActionTypeNameDirty();
        }
        return this.pssysdsactiontypenameDirtyFlag;
    }

    public void resetPSSysDSActionTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDSActionTypeName();
            return;
        }
        this.pssysdsactiontypenameDirtyFlag = false;
        this.pssysdsactiontypename = null;
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
        PSSysDSActoinTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDSActoinTypeBase pSSysDSActoinTypeBase) {
        pSSysDSActoinTypeBase.resetCreateDate();
        pSSysDSActoinTypeBase.resetCreateMan();
        pSSysDSActoinTypeBase.resetPSSysDSActionTypeId();
        pSSysDSActoinTypeBase.resetPSSysDSActionTypeName();
        pSSysDSActoinTypeBase.resetUpdateDate();
        pSSysDSActoinTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysDSActionTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSDSACTIONTYPEID, this.getPSSysDSActionTypeId());
        }
        if (!bl || this.isPSSysDSActionTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSDSACTIONTYPENAME, this.getPSSysDSActionTypeName());
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
        return PSSysDSActoinTypeBase.get(this, n);
    }

    private static Object get(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDSActoinTypeBase.getCreateDate();
            }
            case 1: {
                return pSSysDSActoinTypeBase.getCreateMan();
            }
            case 2: {
                return pSSysDSActoinTypeBase.getPSSysDSActionTypeId();
            }
            case 3: {
                return pSSysDSActoinTypeBase.getPSSysDSActionTypeName();
            }
            case 4: {
                return pSSysDSActoinTypeBase.getUpdateDate();
            }
            case 5: {
                return pSSysDSActoinTypeBase.getUpdateMan();
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
        PSSysDSActoinTypeBase.set(this, n, object);
    }

    private static void set(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDSActoinTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDSActoinTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDSActoinTypeBase.setPSSysDSActionTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDSActoinTypeBase.setPSSysDSActionTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDSActoinTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysDSActoinTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDSActoinTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDSActoinTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDSActoinTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDSActoinTypeBase.getPSSysDSActionTypeId() == null;
            }
            case 3: {
                return pSSysDSActoinTypeBase.getPSSysDSActionTypeName() == null;
            }
            case 4: {
                return pSSysDSActoinTypeBase.getUpdateDate() == null;
            }
            case 5: {
                return pSSysDSActoinTypeBase.getUpdateMan() == null;
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
        return PSSysDSActoinTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDSActoinTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDSActoinTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDSActoinTypeBase.isPSSysDSActionTypeIdDirty();
            }
            case 3: {
                return pSSysDSActoinTypeBase.isPSSysDSActionTypeNameDirty();
            }
            case 4: {
                return pSSysDSActoinTypeBase.isUpdateDateDirty();
            }
            case 5: {
                return pSSysDSActoinTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDSActoinTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDSActoinTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDSActoinTypeBase.getJSONValue((Object)pSSysDSActoinTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDSActoinTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDSActoinTypeBase.getJSONValue((Object)pSSysDSActoinTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDSActoinTypeBase.getPSSysDSActionTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdsactiontypeid", (Object)PSSysDSActoinTypeBase.getJSONValue((Object)pSSysDSActoinTypeBase.getPSSysDSActionTypeId()), (boolean)false);
        }
        if (bl || pSSysDSActoinTypeBase.getPSSysDSActionTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdsactiontypename", (Object)PSSysDSActoinTypeBase.getJSONValue((Object)pSSysDSActoinTypeBase.getPSSysDSActionTypeName()), (boolean)false);
        }
        if (bl || pSSysDSActoinTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDSActoinTypeBase.getJSONValue((Object)pSSysDSActoinTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDSActoinTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDSActoinTypeBase.getJSONValue((Object)pSSysDSActoinTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDSActoinTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDSActoinTypeBase.getCreateDate() != null) {
            object = pSSysDSActoinTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDSActoinTypeBase.getCreateMan() != null) {
            object = pSSysDSActoinTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActoinTypeBase.getPSSysDSActionTypeId() != null) {
            object = pSSysDSActoinTypeBase.getPSSysDSActionTypeId();
            xmlNode.setAttribute(FIELD_PSSYSDSACTIONTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActoinTypeBase.getPSSysDSActionTypeName() != null) {
            object = pSSysDSActoinTypeBase.getPSSysDSActionTypeName();
            xmlNode.setAttribute(FIELD_PSSYSDSACTIONTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDSActoinTypeBase.getUpdateDate() != null) {
            object = pSSysDSActoinTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDSActoinTypeBase.getUpdateMan() != null) {
            object = pSSysDSActoinTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDSActoinTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDSActoinTypeBase.isCreateDateDirty() && (bl || pSSysDSActoinTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDSActoinTypeBase.getCreateDate());
        }
        if (pSSysDSActoinTypeBase.isCreateManDirty() && (bl || pSSysDSActoinTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDSActoinTypeBase.getCreateMan());
        }
        if (pSSysDSActoinTypeBase.isPSSysDSActionTypeIdDirty() && (bl || pSSysDSActoinTypeBase.getPSSysDSActionTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSDSACTIONTYPEID, (Object)pSSysDSActoinTypeBase.getPSSysDSActionTypeId());
        }
        if (pSSysDSActoinTypeBase.isPSSysDSActionTypeNameDirty() && (bl || pSSysDSActoinTypeBase.getPSSysDSActionTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSDSACTIONTYPENAME, (Object)pSSysDSActoinTypeBase.getPSSysDSActionTypeName());
        }
        if (pSSysDSActoinTypeBase.isUpdateDateDirty() && (bl || pSSysDSActoinTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDSActoinTypeBase.getUpdateDate());
        }
        if (pSSysDSActoinTypeBase.isUpdateManDirty() && (bl || pSSysDSActoinTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDSActoinTypeBase.getUpdateMan());
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
        return PSSysDSActoinTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysDSActoinTypeBase pSSysDSActoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDSActoinTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDSActoinTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDSActoinTypeBase.resetPSSysDSActionTypeId();
                return true;
            }
            case 3: {
                pSSysDSActoinTypeBase.resetPSSysDSActionTypeName();
                return true;
            }
            case 4: {
                pSSysDSActoinTypeBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSSysDSActoinTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysDSActoinTypeBase getProxyEntity() {
        return this.proxyPSSysDSActoinTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDSActoinTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDSActoinTypeBase) {
            this.proxyPSSysDSActoinTypeBase = (PSSysDSActoinTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysDSActoinTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSDSACTIONTYPEID, 2);
        fieldIndexMap.put(FIELD_PSSYSDSACTIONTYPENAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

