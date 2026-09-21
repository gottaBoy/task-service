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

public abstract class PSDevEnvBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevEnvBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVENVID = "PSDEVENVID";
    public static final String FIELD_PSDEVENVNAME = "PSDEVENVNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVENVID = 2;
    private static final int INDEX_PSDEVENVNAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevEnvBase proxyPSDevEnvBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevenvidDirtyFlag = false;
    private boolean psdevenvnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevenvid")
    private String psdevenvid;
    @Column(name="psdevenvname")
    private String psdevenvname;
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

    public void setPSDevEnvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevEnvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevenvid = string;
        this.psdevenvidDirtyFlag = true;
    }

    public String getPSDevEnvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevEnvId();
        }
        return this.psdevenvid;
    }

    public boolean isPSDevEnvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevEnvIdDirty();
        }
        return this.psdevenvidDirtyFlag;
    }

    public void resetPSDevEnvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevEnvId();
            return;
        }
        this.psdevenvidDirtyFlag = false;
        this.psdevenvid = null;
    }

    public void setPSDevEnvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevEnvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevenvname = string;
        this.psdevenvnameDirtyFlag = true;
    }

    public String getPSDevEnvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevEnvName();
        }
        return this.psdevenvname;
    }

    public boolean isPSDevEnvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevEnvNameDirty();
        }
        return this.psdevenvnameDirtyFlag;
    }

    public void resetPSDevEnvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevEnvName();
            return;
        }
        this.psdevenvnameDirtyFlag = false;
        this.psdevenvname = null;
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
        PSDevEnvBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevEnvBase pSDevEnvBase) {
        pSDevEnvBase.resetCreateDate();
        pSDevEnvBase.resetCreateMan();
        pSDevEnvBase.resetPSDevEnvId();
        pSDevEnvBase.resetPSDevEnvName();
        pSDevEnvBase.resetUpdateDate();
        pSDevEnvBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDevEnvIdDirty()) {
            hashMap.put(FIELD_PSDEVENVID, this.getPSDevEnvId());
        }
        if (!bl || this.isPSDevEnvNameDirty()) {
            hashMap.put(FIELD_PSDEVENVNAME, this.getPSDevEnvName());
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
        return PSDevEnvBase.get(this, n);
    }

    private static Object get(PSDevEnvBase pSDevEnvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevEnvBase.getCreateDate();
            }
            case 1: {
                return pSDevEnvBase.getCreateMan();
            }
            case 2: {
                return pSDevEnvBase.getPSDevEnvId();
            }
            case 3: {
                return pSDevEnvBase.getPSDevEnvName();
            }
            case 4: {
                return pSDevEnvBase.getUpdateDate();
            }
            case 5: {
                return pSDevEnvBase.getUpdateMan();
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
        PSDevEnvBase.set(this, n, object);
    }

    private static void set(PSDevEnvBase pSDevEnvBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevEnvBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevEnvBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevEnvBase.setPSDevEnvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevEnvBase.setPSDevEnvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevEnvBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDevEnvBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevEnvBase.isNull(this, n);
    }

    private static boolean isNull(PSDevEnvBase pSDevEnvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevEnvBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevEnvBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevEnvBase.getPSDevEnvId() == null;
            }
            case 3: {
                return pSDevEnvBase.getPSDevEnvName() == null;
            }
            case 4: {
                return pSDevEnvBase.getUpdateDate() == null;
            }
            case 5: {
                return pSDevEnvBase.getUpdateMan() == null;
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
        return PSDevEnvBase.contains(this, n);
    }

    private static boolean contains(PSDevEnvBase pSDevEnvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevEnvBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevEnvBase.isCreateManDirty();
            }
            case 2: {
                return pSDevEnvBase.isPSDevEnvIdDirty();
            }
            case 3: {
                return pSDevEnvBase.isPSDevEnvNameDirty();
            }
            case 4: {
                return pSDevEnvBase.isUpdateDateDirty();
            }
            case 5: {
                return pSDevEnvBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevEnvBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevEnvBase pSDevEnvBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevEnvBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevEnvBase.getJSONValue((Object)pSDevEnvBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevEnvBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevEnvBase.getJSONValue((Object)pSDevEnvBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevEnvBase.getPSDevEnvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevenvid", (Object)PSDevEnvBase.getJSONValue((Object)pSDevEnvBase.getPSDevEnvId()), (boolean)false);
        }
        if (bl || pSDevEnvBase.getPSDevEnvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevenvname", (Object)PSDevEnvBase.getJSONValue((Object)pSDevEnvBase.getPSDevEnvName()), (boolean)false);
        }
        if (bl || pSDevEnvBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevEnvBase.getJSONValue((Object)pSDevEnvBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevEnvBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevEnvBase.getJSONValue((Object)pSDevEnvBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevEnvBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevEnvBase pSDevEnvBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevEnvBase.getCreateDate() != null) {
            object = pSDevEnvBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevEnvBase.getCreateMan() != null) {
            object = pSDevEnvBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevEnvBase.getPSDevEnvId() != null) {
            object = pSDevEnvBase.getPSDevEnvId();
            xmlNode.setAttribute(FIELD_PSDEVENVID, object == null ? "" : (String)object);
        }
        if (bl || pSDevEnvBase.getPSDevEnvName() != null) {
            object = pSDevEnvBase.getPSDevEnvName();
            xmlNode.setAttribute(FIELD_PSDEVENVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevEnvBase.getUpdateDate() != null) {
            object = pSDevEnvBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevEnvBase.getUpdateMan() != null) {
            object = pSDevEnvBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevEnvBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevEnvBase pSDevEnvBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevEnvBase.isCreateDateDirty() && (bl || pSDevEnvBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevEnvBase.getCreateDate());
        }
        if (pSDevEnvBase.isCreateManDirty() && (bl || pSDevEnvBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevEnvBase.getCreateMan());
        }
        if (pSDevEnvBase.isPSDevEnvIdDirty() && (bl || pSDevEnvBase.getPSDevEnvId() != null)) {
            iDataObject.set(FIELD_PSDEVENVID, (Object)pSDevEnvBase.getPSDevEnvId());
        }
        if (pSDevEnvBase.isPSDevEnvNameDirty() && (bl || pSDevEnvBase.getPSDevEnvName() != null)) {
            iDataObject.set(FIELD_PSDEVENVNAME, (Object)pSDevEnvBase.getPSDevEnvName());
        }
        if (pSDevEnvBase.isUpdateDateDirty() && (bl || pSDevEnvBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevEnvBase.getUpdateDate());
        }
        if (pSDevEnvBase.isUpdateManDirty() && (bl || pSDevEnvBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevEnvBase.getUpdateMan());
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
        return PSDevEnvBase.remove(this, n);
    }

    private static boolean remove(PSDevEnvBase pSDevEnvBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevEnvBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevEnvBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevEnvBase.resetPSDevEnvId();
                return true;
            }
            case 3: {
                pSDevEnvBase.resetPSDevEnvName();
                return true;
            }
            case 4: {
                pSDevEnvBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSDevEnvBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDevEnvBase getProxyEntity() {
        return this.proxyPSDevEnvBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevEnvBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevEnvBase) {
            this.proxyPSDevEnvBase = (PSDevEnvBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDevEnvService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVENVID, 2);
        fieldIndexMap.put(FIELD_PSDEVENVNAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

