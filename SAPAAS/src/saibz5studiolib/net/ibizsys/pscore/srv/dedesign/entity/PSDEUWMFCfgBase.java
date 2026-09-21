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
package net.ibizsys.pscore.srv.dedesign.entity;

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

public abstract class PSDEUWMFCfgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUWMFCfgBase.class);
    public static final String FIELD_ENAMULTIFORM = "ENAMULTIFORM";
    public static final String FIELD_PSDATAENTITYID = "PSDATAENTITYID";
    public static final String FIELD_PSDATAENTITYNAME = "PSDATAENTITYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    private static final int INDEX_ENAMULTIFORM = 0;
    private static final int INDEX_PSDATAENTITYID = 1;
    private static final int INDEX_PSDATAENTITYNAME = 2;
    private static final int INDEX_UPDATEDATE = 3;
    private static final int INDEX_UPDATEMAN = 4;
    private static final int INDEX_USERTAG = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUWMFCfgBase proxyPSDEUWMFCfgBase = null;
    private boolean enamultiformDirtyFlag = false;
    private boolean psdataentityidDirtyFlag = false;
    private boolean psdataentitynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    @Column(name="enamultiform")
    private Integer enamultiform;
    @Column(name="psdataentityid")
    private String psdataentityid;
    @Column(name="psdataentityname")
    private String psdataentityname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;

    public void setEnaMultiForm(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnaMultiForm(n);
            return;
        }
        this.enamultiform = n;
        this.enamultiformDirtyFlag = true;
    }

    public Integer getEnaMultiForm() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnaMultiForm();
        }
        return this.enamultiform;
    }

    public boolean isEnaMultiFormDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnaMultiFormDirty();
        }
        return this.enamultiformDirtyFlag;
    }

    public void resetEnaMultiForm() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnaMultiForm();
            return;
        }
        this.enamultiformDirtyFlag = false;
        this.enamultiform = null;
    }

    public void setPSDataEntityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataEntityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdataentityid = string;
        this.psdataentityidDirtyFlag = true;
    }

    public String getPSDataEntityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntityId();
        }
        return this.psdataentityid;
    }

    public boolean isPSDataEntityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataEntityIdDirty();
        }
        return this.psdataentityidDirtyFlag;
    }

    public void resetPSDataEntityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataEntityId();
            return;
        }
        this.psdataentityidDirtyFlag = false;
        this.psdataentityid = null;
    }

    public void setPSDataEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdataentityname = string;
        this.psdataentitynameDirtyFlag = true;
    }

    public String getPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntityName();
        }
        return this.psdataentityname;
    }

    public boolean isPSDataEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataEntityNameDirty();
        }
        return this.psdataentitynameDirtyFlag;
    }

    public void resetPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataEntityName();
            return;
        }
        this.psdataentitynameDirtyFlag = false;
        this.psdataentityname = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    protected void onReset() {
        PSDEUWMFCfgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUWMFCfgBase pSDEUWMFCfgBase) {
        pSDEUWMFCfgBase.resetEnaMultiForm();
        pSDEUWMFCfgBase.resetPSDataEntityId();
        pSDEUWMFCfgBase.resetPSDataEntityName();
        pSDEUWMFCfgBase.resetUpdateDate();
        pSDEUWMFCfgBase.resetUpdateMan();
        pSDEUWMFCfgBase.resetUserTag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isEnaMultiFormDirty()) {
            hashMap.put(FIELD_ENAMULTIFORM, this.getEnaMultiForm());
        }
        if (!bl || this.isPSDataEntityIdDirty()) {
            hashMap.put(FIELD_PSDATAENTITYID, this.getPSDataEntityId());
        }
        if (!bl || this.isPSDataEntityNameDirty()) {
            hashMap.put(FIELD_PSDATAENTITYNAME, this.getPSDataEntityName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
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
        return PSDEUWMFCfgBase.get(this, n);
    }

    private static Object get(PSDEUWMFCfgBase pSDEUWMFCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUWMFCfgBase.getEnaMultiForm();
            }
            case 1: {
                return pSDEUWMFCfgBase.getPSDataEntityId();
            }
            case 2: {
                return pSDEUWMFCfgBase.getPSDataEntityName();
            }
            case 3: {
                return pSDEUWMFCfgBase.getUpdateDate();
            }
            case 4: {
                return pSDEUWMFCfgBase.getUpdateMan();
            }
            case 5: {
                return pSDEUWMFCfgBase.getUserTag();
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
        PSDEUWMFCfgBase.set(this, n, object);
    }

    private static void set(PSDEUWMFCfgBase pSDEUWMFCfgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUWMFCfgBase.setEnaMultiForm(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEUWMFCfgBase.setPSDataEntityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEUWMFCfgBase.setPSDataEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUWMFCfgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEUWMFCfgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUWMFCfgBase.setUserTag(DataObject.getStringValue((Object)object));
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
        return PSDEUWMFCfgBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUWMFCfgBase pSDEUWMFCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUWMFCfgBase.getEnaMultiForm() == null;
            }
            case 1: {
                return pSDEUWMFCfgBase.getPSDataEntityId() == null;
            }
            case 2: {
                return pSDEUWMFCfgBase.getPSDataEntityName() == null;
            }
            case 3: {
                return pSDEUWMFCfgBase.getUpdateDate() == null;
            }
            case 4: {
                return pSDEUWMFCfgBase.getUpdateMan() == null;
            }
            case 5: {
                return pSDEUWMFCfgBase.getUserTag() == null;
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
        return PSDEUWMFCfgBase.contains(this, n);
    }

    private static boolean contains(PSDEUWMFCfgBase pSDEUWMFCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUWMFCfgBase.isEnaMultiFormDirty();
            }
            case 1: {
                return pSDEUWMFCfgBase.isPSDataEntityIdDirty();
            }
            case 2: {
                return pSDEUWMFCfgBase.isPSDataEntityNameDirty();
            }
            case 3: {
                return pSDEUWMFCfgBase.isUpdateDateDirty();
            }
            case 4: {
                return pSDEUWMFCfgBase.isUpdateManDirty();
            }
            case 5: {
                return pSDEUWMFCfgBase.isUserTagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUWMFCfgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUWMFCfgBase pSDEUWMFCfgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUWMFCfgBase.getEnaMultiForm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enamultiform", (Object)PSDEUWMFCfgBase.getJSONValue((Object)pSDEUWMFCfgBase.getEnaMultiForm()), (boolean)false);
        }
        if (bl || pSDEUWMFCfgBase.getPSDataEntityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityid", (Object)PSDEUWMFCfgBase.getJSONValue((Object)pSDEUWMFCfgBase.getPSDataEntityId()), (boolean)false);
        }
        if (bl || pSDEUWMFCfgBase.getPSDataEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityname", (Object)PSDEUWMFCfgBase.getJSONValue((Object)pSDEUWMFCfgBase.getPSDataEntityName()), (boolean)false);
        }
        if (bl || pSDEUWMFCfgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUWMFCfgBase.getJSONValue((Object)pSDEUWMFCfgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUWMFCfgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUWMFCfgBase.getJSONValue((Object)pSDEUWMFCfgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUWMFCfgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEUWMFCfgBase.getJSONValue((Object)pSDEUWMFCfgBase.getUserTag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUWMFCfgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUWMFCfgBase pSDEUWMFCfgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUWMFCfgBase.getEnaMultiForm() != null) {
            object = pSDEUWMFCfgBase.getEnaMultiForm();
            xmlNode.setAttribute(FIELD_ENAMULTIFORM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUWMFCfgBase.getPSDataEntityId() != null) {
            object = pSDEUWMFCfgBase.getPSDataEntityId();
            xmlNode.setAttribute(FIELD_PSDATAENTITYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUWMFCfgBase.getPSDataEntityName() != null) {
            object = pSDEUWMFCfgBase.getPSDataEntityName();
            xmlNode.setAttribute(FIELD_PSDATAENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUWMFCfgBase.getUpdateDate() != null) {
            object = pSDEUWMFCfgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUWMFCfgBase.getUpdateMan() != null) {
            object = pSDEUWMFCfgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUWMFCfgBase.getUserTag() != null) {
            object = pSDEUWMFCfgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUWMFCfgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUWMFCfgBase pSDEUWMFCfgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUWMFCfgBase.isEnaMultiFormDirty() && (bl || pSDEUWMFCfgBase.getEnaMultiForm() != null)) {
            iDataObject.set(FIELD_ENAMULTIFORM, (Object)pSDEUWMFCfgBase.getEnaMultiForm());
        }
        if (pSDEUWMFCfgBase.isPSDataEntityIdDirty() && (bl || pSDEUWMFCfgBase.getPSDataEntityId() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYID, (Object)pSDEUWMFCfgBase.getPSDataEntityId());
        }
        if (pSDEUWMFCfgBase.isPSDataEntityNameDirty() && (bl || pSDEUWMFCfgBase.getPSDataEntityName() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYNAME, (Object)pSDEUWMFCfgBase.getPSDataEntityName());
        }
        if (pSDEUWMFCfgBase.isUpdateDateDirty() && (bl || pSDEUWMFCfgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUWMFCfgBase.getUpdateDate());
        }
        if (pSDEUWMFCfgBase.isUpdateManDirty() && (bl || pSDEUWMFCfgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUWMFCfgBase.getUpdateMan());
        }
        if (pSDEUWMFCfgBase.isUserTagDirty() && (bl || pSDEUWMFCfgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEUWMFCfgBase.getUserTag());
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
        return PSDEUWMFCfgBase.remove(this, n);
    }

    private static boolean remove(PSDEUWMFCfgBase pSDEUWMFCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUWMFCfgBase.resetEnaMultiForm();
                return true;
            }
            case 1: {
                pSDEUWMFCfgBase.resetPSDataEntityId();
                return true;
            }
            case 2: {
                pSDEUWMFCfgBase.resetPSDataEntityName();
                return true;
            }
            case 3: {
                pSDEUWMFCfgBase.resetUpdateDate();
                return true;
            }
            case 4: {
                pSDEUWMFCfgBase.resetUpdateMan();
                return true;
            }
            case 5: {
                pSDEUWMFCfgBase.resetUserTag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEUWMFCfgBase getProxyEntity() {
        return this.proxyPSDEUWMFCfgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUWMFCfgBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUWMFCfgBase) {
            this.proxyPSDEUWMFCfgBase = (PSDEUWMFCfgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUWMFCfgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ENAMULTIFORM, 0);
        fieldIndexMap.put(FIELD_PSDATAENTITYID, 1);
        fieldIndexMap.put(FIELD_PSDATAENTITYNAME, 2);
        fieldIndexMap.put(FIELD_UPDATEDATE, 3);
        fieldIndexMap.put(FIELD_UPDATEMAN, 4);
        fieldIndexMap.put(FIELD_USERTAG, 5);
    }
}

