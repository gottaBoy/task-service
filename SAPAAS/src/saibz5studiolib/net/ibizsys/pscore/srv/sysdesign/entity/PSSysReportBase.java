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
package net.ibizsys.pscore.srv.sysdesign.entity;

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

public abstract class PSSysReportBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysReportBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSREPORTID = "PSSYSREPORTID";
    public static final String FIELD_PSSYSREPORTNAME = "PSSYSREPORTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSYSREPORTID = 2;
    private static final int INDEX_PSSYSREPORTNAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysReportBase proxyPSSysReportBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssysreportidDirtyFlag = false;
    private boolean pssysreportnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssysreportid")
    private String pssysreportid;
    @Column(name="pssysreportname")
    private String pssysreportname;
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

    public void setPSSysReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreportid = string;
        this.pssysreportidDirtyFlag = true;
    }

    public String getPSSysReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReportId();
        }
        return this.pssysreportid;
    }

    public boolean isPSSysReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReportIdDirty();
        }
        return this.pssysreportidDirtyFlag;
    }

    public void resetPSSysReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReportId();
            return;
        }
        this.pssysreportidDirtyFlag = false;
        this.pssysreportid = null;
    }

    public void setPSSYSReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSYSReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreportname = string;
        this.pssysreportnameDirtyFlag = true;
    }

    public String getPSSYSReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSYSReportName();
        }
        return this.pssysreportname;
    }

    public boolean isPSSYSReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSYSReportNameDirty();
        }
        return this.pssysreportnameDirtyFlag;
    }

    public void resetPSSYSReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSYSReportName();
            return;
        }
        this.pssysreportnameDirtyFlag = false;
        this.pssysreportname = null;
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
        PSSysReportBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysReportBase pSSysReportBase) {
        pSSysReportBase.resetCreateDate();
        pSSysReportBase.resetCreateMan();
        pSSysReportBase.resetPSSysReportId();
        pSSysReportBase.resetPSSYSReportName();
        pSSysReportBase.resetUpdateDate();
        pSSysReportBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysReportIdDirty()) {
            hashMap.put(FIELD_PSSYSREPORTID, this.getPSSysReportId());
        }
        if (!bl || this.isPSSYSReportNameDirty()) {
            hashMap.put(FIELD_PSSYSREPORTNAME, this.getPSSYSReportName());
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
        return PSSysReportBase.get(this, n);
    }

    private static Object get(PSSysReportBase pSSysReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReportBase.getCreateDate();
            }
            case 1: {
                return pSSysReportBase.getCreateMan();
            }
            case 2: {
                return pSSysReportBase.getPSSysReportId();
            }
            case 3: {
                return pSSysReportBase.getPSSYSReportName();
            }
            case 4: {
                return pSSysReportBase.getUpdateDate();
            }
            case 5: {
                return pSSysReportBase.getUpdateMan();
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
        PSSysReportBase.set(this, n, object);
    }

    private static void set(PSSysReportBase pSSysReportBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysReportBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysReportBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysReportBase.setPSSysReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysReportBase.setPSSYSReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysReportBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysReportBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysReportBase.isNull(this, n);
    }

    private static boolean isNull(PSSysReportBase pSSysReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReportBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysReportBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysReportBase.getPSSysReportId() == null;
            }
            case 3: {
                return pSSysReportBase.getPSSYSReportName() == null;
            }
            case 4: {
                return pSSysReportBase.getUpdateDate() == null;
            }
            case 5: {
                return pSSysReportBase.getUpdateMan() == null;
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
        return PSSysReportBase.contains(this, n);
    }

    private static boolean contains(PSSysReportBase pSSysReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReportBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysReportBase.isCreateManDirty();
            }
            case 2: {
                return pSSysReportBase.isPSSysReportIdDirty();
            }
            case 3: {
                return pSSysReportBase.isPSSYSReportNameDirty();
            }
            case 4: {
                return pSSysReportBase.isUpdateDateDirty();
            }
            case 5: {
                return pSSysReportBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysReportBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysReportBase pSSysReportBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysReportBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysReportBase.getJSONValue((Object)pSSysReportBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysReportBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysReportBase.getJSONValue((Object)pSSysReportBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysReportBase.getPSSysReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreportid", (Object)PSSysReportBase.getJSONValue((Object)pSSysReportBase.getPSSysReportId()), (boolean)false);
        }
        if (bl || pSSysReportBase.getPSSYSReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreportname", (Object)PSSysReportBase.getJSONValue((Object)pSSysReportBase.getPSSYSReportName()), (boolean)false);
        }
        if (bl || pSSysReportBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysReportBase.getJSONValue((Object)pSSysReportBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysReportBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysReportBase.getJSONValue((Object)pSSysReportBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysReportBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysReportBase pSSysReportBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysReportBase.getCreateDate() != null) {
            object = pSSysReportBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReportBase.getCreateMan() != null) {
            object = pSSysReportBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReportBase.getPSSysReportId() != null) {
            object = pSSysReportBase.getPSSysReportId();
            xmlNode.setAttribute(FIELD_PSSYSREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReportBase.getPSSYSReportName() != null) {
            object = pSSysReportBase.getPSSYSReportName();
            xmlNode.setAttribute(FIELD_PSSYSREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReportBase.getUpdateDate() != null) {
            object = pSSysReportBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReportBase.getUpdateMan() != null) {
            object = pSSysReportBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysReportBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysReportBase pSSysReportBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysReportBase.isCreateDateDirty() && (bl || pSSysReportBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysReportBase.getCreateDate());
        }
        if (pSSysReportBase.isCreateManDirty() && (bl || pSSysReportBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysReportBase.getCreateMan());
        }
        if (pSSysReportBase.isPSSysReportIdDirty() && (bl || pSSysReportBase.getPSSysReportId() != null)) {
            iDataObject.set(FIELD_PSSYSREPORTID, (Object)pSSysReportBase.getPSSysReportId());
        }
        if (pSSysReportBase.isPSSYSReportNameDirty() && (bl || pSSysReportBase.getPSSYSReportName() != null)) {
            iDataObject.set(FIELD_PSSYSREPORTNAME, (Object)pSSysReportBase.getPSSYSReportName());
        }
        if (pSSysReportBase.isUpdateDateDirty() && (bl || pSSysReportBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysReportBase.getUpdateDate());
        }
        if (pSSysReportBase.isUpdateManDirty() && (bl || pSSysReportBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysReportBase.getUpdateMan());
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
        return PSSysReportBase.remove(this, n);
    }

    private static boolean remove(PSSysReportBase pSSysReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysReportBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysReportBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysReportBase.resetPSSysReportId();
                return true;
            }
            case 3: {
                pSSysReportBase.resetPSSYSReportName();
                return true;
            }
            case 4: {
                pSSysReportBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSSysReportBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysReportBase getProxyEntity() {
        return this.proxyPSSysReportBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysReportBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysReportBase) {
            this.proxyPSSysReportBase = (PSSysReportBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReportService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSYSREPORTID, 2);
        fieldIndexMap.put(FIELD_PSSYSREPORTNAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

