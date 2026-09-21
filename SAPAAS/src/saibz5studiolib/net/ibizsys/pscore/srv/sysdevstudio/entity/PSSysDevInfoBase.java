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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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

public abstract class PSSysDevInfoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDevInfoBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSDEVINFOID = "PSSYSDEVINFOID";
    public static final String FIELD_PSSYSDEVINFONAME = "PSSYSDEVINFONAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSDEVINFOID = 2;
    private static final int INDEX_PSSYSDEVINFONAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDevInfoBase proxyPSSysDevInfoBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysdevinfoidDirtyFlag = false;
    private boolean pssysdevinfonameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysdevinfoid")
    private String pssysdevinfoid;
    @Column(name="pssysdevinfoname")
    private String pssysdevinfoname;
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

    public void setPSSysDevInfoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevInfoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevinfoid = string;
        this.pssysdevinfoidDirtyFlag = true;
    }

    public String getPSSysDevInfoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevInfoId();
        }
        return this.pssysdevinfoid;
    }

    public boolean isPSSysDevInfoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevInfoIdDirty();
        }
        return this.pssysdevinfoidDirtyFlag;
    }

    public void resetPSSysDevInfoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevInfoId();
            return;
        }
        this.pssysdevinfoidDirtyFlag = false;
        this.pssysdevinfoid = null;
    }

    public void setPSSysDevInfoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevInfoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevinfoname = string;
        this.pssysdevinfonameDirtyFlag = true;
    }

    public String getPSSysDevInfoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevInfoName();
        }
        return this.pssysdevinfoname;
    }

    public boolean isPSSysDevInfoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevInfoNameDirty();
        }
        return this.pssysdevinfonameDirtyFlag;
    }

    public void resetPSSysDevInfoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevInfoName();
            return;
        }
        this.pssysdevinfonameDirtyFlag = false;
        this.pssysdevinfoname = null;
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
        PSSysDevInfoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDevInfoBase pSSysDevInfoBase) {
        pSSysDevInfoBase.resetCreateDate();
        pSSysDevInfoBase.resetCreateMan();
        pSSysDevInfoBase.resetPSSysDevInfoId();
        pSSysDevInfoBase.resetPSSysDevInfoName();
        pSSysDevInfoBase.resetUpdateDate();
        pSSysDevInfoBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysDevInfoIdDirty()) {
            hashMap.put(FIELD_PSSYSDEVINFOID, this.getPSSysDevInfoId());
        }
        if (!bl || this.isPSSysDevInfoNameDirty()) {
            hashMap.put(FIELD_PSSYSDEVINFONAME, this.getPSSysDevInfoName());
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
        return PSSysDevInfoBase.get(this, n);
    }

    private static Object get(PSSysDevInfoBase pSSysDevInfoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevInfoBase.getCreateDate();
            }
            case 1: {
                return pSSysDevInfoBase.getCreateMan();
            }
            case 2: {
                return pSSysDevInfoBase.getPSSysDevInfoId();
            }
            case 3: {
                return pSSysDevInfoBase.getPSSysDevInfoName();
            }
            case 4: {
                return pSSysDevInfoBase.getUpdateDate();
            }
            case 5: {
                return pSSysDevInfoBase.getUpdateMan();
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
        PSSysDevInfoBase.set(this, n, object);
    }

    private static void set(PSSysDevInfoBase pSSysDevInfoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevInfoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDevInfoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDevInfoBase.setPSSysDevInfoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDevInfoBase.setPSSysDevInfoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDevInfoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysDevInfoBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDevInfoBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDevInfoBase pSSysDevInfoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevInfoBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDevInfoBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDevInfoBase.getPSSysDevInfoId() == null;
            }
            case 3: {
                return pSSysDevInfoBase.getPSSysDevInfoName() == null;
            }
            case 4: {
                return pSSysDevInfoBase.getUpdateDate() == null;
            }
            case 5: {
                return pSSysDevInfoBase.getUpdateMan() == null;
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
        return PSSysDevInfoBase.contains(this, n);
    }

    private static boolean contains(PSSysDevInfoBase pSSysDevInfoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevInfoBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDevInfoBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDevInfoBase.isPSSysDevInfoIdDirty();
            }
            case 3: {
                return pSSysDevInfoBase.isPSSysDevInfoNameDirty();
            }
            case 4: {
                return pSSysDevInfoBase.isUpdateDateDirty();
            }
            case 5: {
                return pSSysDevInfoBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDevInfoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDevInfoBase pSSysDevInfoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDevInfoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDevInfoBase.getJSONValue((Object)pSSysDevInfoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDevInfoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDevInfoBase.getJSONValue((Object)pSSysDevInfoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDevInfoBase.getPSSysDevInfoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevinfoid", (Object)PSSysDevInfoBase.getJSONValue((Object)pSSysDevInfoBase.getPSSysDevInfoId()), (boolean)false);
        }
        if (bl || pSSysDevInfoBase.getPSSysDevInfoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevinfoname", (Object)PSSysDevInfoBase.getJSONValue((Object)pSSysDevInfoBase.getPSSysDevInfoName()), (boolean)false);
        }
        if (bl || pSSysDevInfoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDevInfoBase.getJSONValue((Object)pSSysDevInfoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDevInfoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDevInfoBase.getJSONValue((Object)pSSysDevInfoBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDevInfoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDevInfoBase pSSysDevInfoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDevInfoBase.getCreateDate() != null) {
            object = pSSysDevInfoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevInfoBase.getCreateMan() != null) {
            object = pSSysDevInfoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevInfoBase.getPSSysDevInfoId() != null) {
            object = pSSysDevInfoBase.getPSSysDevInfoId();
            xmlNode.setAttribute(FIELD_PSSYSDEVINFOID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevInfoBase.getPSSysDevInfoName() != null) {
            object = pSSysDevInfoBase.getPSSysDevInfoName();
            xmlNode.setAttribute(FIELD_PSSYSDEVINFONAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevInfoBase.getUpdateDate() != null) {
            object = pSSysDevInfoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevInfoBase.getUpdateMan() != null) {
            object = pSSysDevInfoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDevInfoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDevInfoBase pSSysDevInfoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDevInfoBase.isCreateDateDirty() && (bl || pSSysDevInfoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDevInfoBase.getCreateDate());
        }
        if (pSSysDevInfoBase.isCreateManDirty() && (bl || pSSysDevInfoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDevInfoBase.getCreateMan());
        }
        if (pSSysDevInfoBase.isPSSysDevInfoIdDirty() && (bl || pSSysDevInfoBase.getPSSysDevInfoId() != null)) {
            iDataObject.set(FIELD_PSSYSDEVINFOID, (Object)pSSysDevInfoBase.getPSSysDevInfoId());
        }
        if (pSSysDevInfoBase.isPSSysDevInfoNameDirty() && (bl || pSSysDevInfoBase.getPSSysDevInfoName() != null)) {
            iDataObject.set(FIELD_PSSYSDEVINFONAME, (Object)pSSysDevInfoBase.getPSSysDevInfoName());
        }
        if (pSSysDevInfoBase.isUpdateDateDirty() && (bl || pSSysDevInfoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDevInfoBase.getUpdateDate());
        }
        if (pSSysDevInfoBase.isUpdateManDirty() && (bl || pSSysDevInfoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDevInfoBase.getUpdateMan());
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
        return PSSysDevInfoBase.remove(this, n);
    }

    private static boolean remove(PSSysDevInfoBase pSSysDevInfoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevInfoBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDevInfoBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDevInfoBase.resetPSSysDevInfoId();
                return true;
            }
            case 3: {
                pSSysDevInfoBase.resetPSSysDevInfoName();
                return true;
            }
            case 4: {
                pSSysDevInfoBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSSysDevInfoBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysDevInfoBase getProxyEntity() {
        return this.proxyPSSysDevInfoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDevInfoBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDevInfoBase) {
            this.proxyPSSysDevInfoBase = (PSSysDevInfoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevInfoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSDEVINFOID, 2);
        fieldIndexMap.put(FIELD_PSSYSDEVINFONAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

