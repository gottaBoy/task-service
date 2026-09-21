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

public abstract class PSCodeNameBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCodeNameBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSCODENAMEID = "PSCODENAMEID";
    public static final String FIELD_PSCODENAMENAME = "PSCODENAMENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSCODENAMEID = 2;
    private static final int INDEX_PSCODENAMENAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCodeNameBase proxyPSCodeNameBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pscodenameidDirtyFlag = false;
    private boolean pscodenamenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pscodenameid")
    private String pscodenameid;
    @Column(name="pscodenamename")
    private String pscodenamename;
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

    public void setPSCodeNameId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeNameId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodenameid = string;
        this.pscodenameidDirtyFlag = true;
    }

    public String getPSCodeNameId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeNameId();
        }
        return this.pscodenameid;
    }

    public boolean isPSCodeNameIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeNameIdDirty();
        }
        return this.pscodenameidDirtyFlag;
    }

    public void resetPSCodeNameId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeNameId();
            return;
        }
        this.pscodenameidDirtyFlag = false;
        this.pscodenameid = null;
    }

    public void setPSCodeNameName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeNameName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodenamename = string;
        this.pscodenamenameDirtyFlag = true;
    }

    public String getPSCodeNameName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeNameName();
        }
        return this.pscodenamename;
    }

    public boolean isPSCodeNameNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeNameNameDirty();
        }
        return this.pscodenamenameDirtyFlag;
    }

    public void resetPSCodeNameName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeNameName();
            return;
        }
        this.pscodenamenameDirtyFlag = false;
        this.pscodenamename = null;
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
        PSCodeNameBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCodeNameBase pSCodeNameBase) {
        pSCodeNameBase.resetCreateDate();
        pSCodeNameBase.resetCreateMan();
        pSCodeNameBase.resetPSCodeNameId();
        pSCodeNameBase.resetPSCodeNameName();
        pSCodeNameBase.resetUpdateDate();
        pSCodeNameBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSCodeNameIdDirty()) {
            hashMap.put(FIELD_PSCODENAMEID, this.getPSCodeNameId());
        }
        if (!bl || this.isPSCodeNameNameDirty()) {
            hashMap.put(FIELD_PSCODENAMENAME, this.getPSCodeNameName());
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
        return PSCodeNameBase.get(this, n);
    }

    private static Object get(PSCodeNameBase pSCodeNameBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeNameBase.getCreateDate();
            }
            case 1: {
                return pSCodeNameBase.getCreateMan();
            }
            case 2: {
                return pSCodeNameBase.getPSCodeNameId();
            }
            case 3: {
                return pSCodeNameBase.getPSCodeNameName();
            }
            case 4: {
                return pSCodeNameBase.getUpdateDate();
            }
            case 5: {
                return pSCodeNameBase.getUpdateMan();
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
        PSCodeNameBase.set(this, n, object);
    }

    private static void set(PSCodeNameBase pSCodeNameBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCodeNameBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCodeNameBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCodeNameBase.setPSCodeNameId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCodeNameBase.setPSCodeNameName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCodeNameBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSCodeNameBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCodeNameBase.isNull(this, n);
    }

    private static boolean isNull(PSCodeNameBase pSCodeNameBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeNameBase.getCreateDate() == null;
            }
            case 1: {
                return pSCodeNameBase.getCreateMan() == null;
            }
            case 2: {
                return pSCodeNameBase.getPSCodeNameId() == null;
            }
            case 3: {
                return pSCodeNameBase.getPSCodeNameName() == null;
            }
            case 4: {
                return pSCodeNameBase.getUpdateDate() == null;
            }
            case 5: {
                return pSCodeNameBase.getUpdateMan() == null;
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
        return PSCodeNameBase.contains(this, n);
    }

    private static boolean contains(PSCodeNameBase pSCodeNameBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeNameBase.isCreateDateDirty();
            }
            case 1: {
                return pSCodeNameBase.isCreateManDirty();
            }
            case 2: {
                return pSCodeNameBase.isPSCodeNameIdDirty();
            }
            case 3: {
                return pSCodeNameBase.isPSCodeNameNameDirty();
            }
            case 4: {
                return pSCodeNameBase.isUpdateDateDirty();
            }
            case 5: {
                return pSCodeNameBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCodeNameBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCodeNameBase pSCodeNameBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCodeNameBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCodeNameBase.getJSONValue((Object)pSCodeNameBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCodeNameBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCodeNameBase.getJSONValue((Object)pSCodeNameBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCodeNameBase.getPSCodeNameId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodenameid", (Object)PSCodeNameBase.getJSONValue((Object)pSCodeNameBase.getPSCodeNameId()), (boolean)false);
        }
        if (bl || pSCodeNameBase.getPSCodeNameName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodenamename", (Object)PSCodeNameBase.getJSONValue((Object)pSCodeNameBase.getPSCodeNameName()), (boolean)false);
        }
        if (bl || pSCodeNameBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCodeNameBase.getJSONValue((Object)pSCodeNameBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCodeNameBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCodeNameBase.getJSONValue((Object)pSCodeNameBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCodeNameBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCodeNameBase pSCodeNameBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCodeNameBase.getCreateDate() != null) {
            object = pSCodeNameBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeNameBase.getCreateMan() != null) {
            object = pSCodeNameBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeNameBase.getPSCodeNameId() != null) {
            object = pSCodeNameBase.getPSCodeNameId();
            xmlNode.setAttribute(FIELD_PSCODENAMEID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeNameBase.getPSCodeNameName() != null) {
            object = pSCodeNameBase.getPSCodeNameName();
            xmlNode.setAttribute(FIELD_PSCODENAMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeNameBase.getUpdateDate() != null) {
            object = pSCodeNameBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeNameBase.getUpdateMan() != null) {
            object = pSCodeNameBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCodeNameBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCodeNameBase pSCodeNameBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCodeNameBase.isCreateDateDirty() && (bl || pSCodeNameBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCodeNameBase.getCreateDate());
        }
        if (pSCodeNameBase.isCreateManDirty() && (bl || pSCodeNameBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCodeNameBase.getCreateMan());
        }
        if (pSCodeNameBase.isPSCodeNameIdDirty() && (bl || pSCodeNameBase.getPSCodeNameId() != null)) {
            iDataObject.set(FIELD_PSCODENAMEID, (Object)pSCodeNameBase.getPSCodeNameId());
        }
        if (pSCodeNameBase.isPSCodeNameNameDirty() && (bl || pSCodeNameBase.getPSCodeNameName() != null)) {
            iDataObject.set(FIELD_PSCODENAMENAME, (Object)pSCodeNameBase.getPSCodeNameName());
        }
        if (pSCodeNameBase.isUpdateDateDirty() && (bl || pSCodeNameBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCodeNameBase.getUpdateDate());
        }
        if (pSCodeNameBase.isUpdateManDirty() && (bl || pSCodeNameBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCodeNameBase.getUpdateMan());
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
        return PSCodeNameBase.remove(this, n);
    }

    private static boolean remove(PSCodeNameBase pSCodeNameBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCodeNameBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCodeNameBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCodeNameBase.resetPSCodeNameId();
                return true;
            }
            case 3: {
                pSCodeNameBase.resetPSCodeNameName();
                return true;
            }
            case 4: {
                pSCodeNameBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSCodeNameBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCodeNameBase getProxyEntity() {
        return this.proxyPSCodeNameBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCodeNameBase = null;
        if (iDataObject != null && iDataObject instanceof PSCodeNameBase) {
            this.proxyPSCodeNameBase = (PSCodeNameBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCodeNameService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSCODENAMEID, 2);
        fieldIndexMap.put(FIELD_PSCODENAMENAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

