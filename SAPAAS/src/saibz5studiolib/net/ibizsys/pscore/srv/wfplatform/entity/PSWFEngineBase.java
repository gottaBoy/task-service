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
package net.ibizsys.pscore.srv.wfplatform.entity;

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

public abstract class PSWFEngineBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFEngineBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSWPENGINEID = "PSWPENGINEID";
    public static final String FIELD_PSWPENGINENAME = "PSWPENGINENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSWPENGINEID = 2;
    private static final int INDEX_PSWPENGINENAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFEngineBase proxyPSWFEngineBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pswpengineidDirtyFlag = false;
    private boolean pswpenginenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pswpengineid")
    private String pswpengineid;
    @Column(name="pswpenginename")
    private String pswpenginename;
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

    public void setPSWPEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpengineid = string;
        this.pswpengineidDirtyFlag = true;
    }

    public String getPSWPEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineId();
        }
        return this.pswpengineid;
    }

    public boolean isPSWPEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineIdDirty();
        }
        return this.pswpengineidDirtyFlag;
    }

    public void resetPSWPEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineId();
            return;
        }
        this.pswpengineidDirtyFlag = false;
        this.pswpengineid = null;
    }

    public void setPSWPEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpenginename = string;
        this.pswpenginenameDirtyFlag = true;
    }

    public String getPSWPEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineName();
        }
        return this.pswpenginename;
    }

    public boolean isPSWPEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineNameDirty();
        }
        return this.pswpenginenameDirtyFlag;
    }

    public void resetPSWPEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineName();
            return;
        }
        this.pswpenginenameDirtyFlag = false;
        this.pswpenginename = null;
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
        PSWFEngineBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFEngineBase pSWFEngineBase) {
        pSWFEngineBase.resetCreateDate();
        pSWFEngineBase.resetCreateMan();
        pSWFEngineBase.resetPSWPEngineId();
        pSWFEngineBase.resetPSWPEngineName();
        pSWFEngineBase.resetUpdateDate();
        pSWFEngineBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSWPEngineIdDirty()) {
            hashMap.put(FIELD_PSWPENGINEID, this.getPSWPEngineId());
        }
        if (!bl || this.isPSWPEngineNameDirty()) {
            hashMap.put(FIELD_PSWPENGINENAME, this.getPSWPEngineName());
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
        return PSWFEngineBase.get(this, n);
    }

    private static Object get(PSWFEngineBase pSWFEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFEngineBase.getCreateDate();
            }
            case 1: {
                return pSWFEngineBase.getCreateMan();
            }
            case 2: {
                return pSWFEngineBase.getPSWPEngineId();
            }
            case 3: {
                return pSWFEngineBase.getPSWPEngineName();
            }
            case 4: {
                return pSWFEngineBase.getUpdateDate();
            }
            case 5: {
                return pSWFEngineBase.getUpdateMan();
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
        PSWFEngineBase.set(this, n, object);
    }

    private static void set(PSWFEngineBase pSWFEngineBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFEngineBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWFEngineBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFEngineBase.setPSWPEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFEngineBase.setPSWPEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFEngineBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSWFEngineBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWFEngineBase.isNull(this, n);
    }

    private static boolean isNull(PSWFEngineBase pSWFEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFEngineBase.getCreateDate() == null;
            }
            case 1: {
                return pSWFEngineBase.getCreateMan() == null;
            }
            case 2: {
                return pSWFEngineBase.getPSWPEngineId() == null;
            }
            case 3: {
                return pSWFEngineBase.getPSWPEngineName() == null;
            }
            case 4: {
                return pSWFEngineBase.getUpdateDate() == null;
            }
            case 5: {
                return pSWFEngineBase.getUpdateMan() == null;
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
        return PSWFEngineBase.contains(this, n);
    }

    private static boolean contains(PSWFEngineBase pSWFEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFEngineBase.isCreateDateDirty();
            }
            case 1: {
                return pSWFEngineBase.isCreateManDirty();
            }
            case 2: {
                return pSWFEngineBase.isPSWPEngineIdDirty();
            }
            case 3: {
                return pSWFEngineBase.isPSWPEngineNameDirty();
            }
            case 4: {
                return pSWFEngineBase.isUpdateDateDirty();
            }
            case 5: {
                return pSWFEngineBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFEngineBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFEngineBase pSWFEngineBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFEngineBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFEngineBase.getJSONValue((Object)pSWFEngineBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFEngineBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFEngineBase.getJSONValue((Object)pSWFEngineBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFEngineBase.getPSWPEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpengineid", (Object)PSWFEngineBase.getJSONValue((Object)pSWFEngineBase.getPSWPEngineId()), (boolean)false);
        }
        if (bl || pSWFEngineBase.getPSWPEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpenginename", (Object)PSWFEngineBase.getJSONValue((Object)pSWFEngineBase.getPSWPEngineName()), (boolean)false);
        }
        if (bl || pSWFEngineBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFEngineBase.getJSONValue((Object)pSWFEngineBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFEngineBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFEngineBase.getJSONValue((Object)pSWFEngineBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFEngineBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFEngineBase pSWFEngineBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFEngineBase.getCreateDate() != null) {
            object = pSWFEngineBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFEngineBase.getCreateMan() != null) {
            object = pSWFEngineBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineBase.getPSWPEngineId() != null) {
            object = pSWFEngineBase.getPSWPEngineId();
            xmlNode.setAttribute(FIELD_PSWPENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineBase.getPSWPEngineName() != null) {
            object = pSWFEngineBase.getPSWPEngineName();
            xmlNode.setAttribute(FIELD_PSWPENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFEngineBase.getUpdateDate() != null) {
            object = pSWFEngineBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFEngineBase.getUpdateMan() != null) {
            object = pSWFEngineBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFEngineBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFEngineBase pSWFEngineBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFEngineBase.isCreateDateDirty() && (bl || pSWFEngineBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFEngineBase.getCreateDate());
        }
        if (pSWFEngineBase.isCreateManDirty() && (bl || pSWFEngineBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFEngineBase.getCreateMan());
        }
        if (pSWFEngineBase.isPSWPEngineIdDirty() && (bl || pSWFEngineBase.getPSWPEngineId() != null)) {
            iDataObject.set(FIELD_PSWPENGINEID, (Object)pSWFEngineBase.getPSWPEngineId());
        }
        if (pSWFEngineBase.isPSWPEngineNameDirty() && (bl || pSWFEngineBase.getPSWPEngineName() != null)) {
            iDataObject.set(FIELD_PSWPENGINENAME, (Object)pSWFEngineBase.getPSWPEngineName());
        }
        if (pSWFEngineBase.isUpdateDateDirty() && (bl || pSWFEngineBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFEngineBase.getUpdateDate());
        }
        if (pSWFEngineBase.isUpdateManDirty() && (bl || pSWFEngineBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFEngineBase.getUpdateMan());
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
        return PSWFEngineBase.remove(this, n);
    }

    private static boolean remove(PSWFEngineBase pSWFEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFEngineBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWFEngineBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWFEngineBase.resetPSWPEngineId();
                return true;
            }
            case 3: {
                pSWFEngineBase.resetPSWPEngineName();
                return true;
            }
            case 4: {
                pSWFEngineBase.resetUpdateDate();
                return true;
            }
            case 5: {
                pSWFEngineBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSWFEngineBase getProxyEntity() {
        return this.proxyPSWFEngineBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFEngineBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFEngineBase) {
            this.proxyPSWFEngineBase = (PSWFEngineBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWFEngineService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSWPENGINEID, 2);
        fieldIndexMap.put(FIELD_PSWPENGINENAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
    }
}

