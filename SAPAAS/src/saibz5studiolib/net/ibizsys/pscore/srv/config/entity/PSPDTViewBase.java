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

public abstract class PSPDTViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPDTViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPDTVIEWID = "PSPDTVIEWID";
    public static final String FIELD_PSPDTVIEWNAME = "PSPDTVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSPDTVIEWID = 3;
    private static final int INDEX_PSPDTVIEWNAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPDTViewBase proxyPSPDTViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspdtviewidDirtyFlag = false;
    private boolean pspdtviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pspdtviewid")
    private String pspdtviewid;
    @Column(name="pspdtviewname")
    private String pspdtviewname;
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

    public void setPSPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtviewid = string;
        this.pspdtviewidDirtyFlag = true;
    }

    public String getPSPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTViewId();
        }
        return this.pspdtviewid;
    }

    public boolean isPSPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTViewIdDirty();
        }
        return this.pspdtviewidDirtyFlag;
    }

    public void resetPSPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTViewId();
            return;
        }
        this.pspdtviewidDirtyFlag = false;
        this.pspdtviewid = null;
    }

    public void setPSPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtviewname = string;
        this.pspdtviewnameDirtyFlag = true;
    }

    public String getPSPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTViewName();
        }
        return this.pspdtviewname;
    }

    public boolean isPSPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTViewNameDirty();
        }
        return this.pspdtviewnameDirtyFlag;
    }

    public void resetPSPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTViewName();
            return;
        }
        this.pspdtviewnameDirtyFlag = false;
        this.pspdtviewname = null;
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
        PSPDTViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPDTViewBase pSPDTViewBase) {
        pSPDTViewBase.resetCreateDate();
        pSPDTViewBase.resetCreateMan();
        pSPDTViewBase.resetMemo();
        pSPDTViewBase.resetPSPDTViewId();
        pSPDTViewBase.resetPSPDTViewName();
        pSPDTViewBase.resetUpdateDate();
        pSPDTViewBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSPDTViewIdDirty()) {
            hashMap.put(FIELD_PSPDTVIEWID, this.getPSPDTViewId());
        }
        if (!bl || this.isPSPDTViewNameDirty()) {
            hashMap.put(FIELD_PSPDTVIEWNAME, this.getPSPDTViewName());
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
        return PSPDTViewBase.get(this, n);
    }

    private static Object get(PSPDTViewBase pSPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPDTViewBase.getCreateDate();
            }
            case 1: {
                return pSPDTViewBase.getCreateMan();
            }
            case 2: {
                return pSPDTViewBase.getMemo();
            }
            case 3: {
                return pSPDTViewBase.getPSPDTViewId();
            }
            case 4: {
                return pSPDTViewBase.getPSPDTViewName();
            }
            case 5: {
                return pSPDTViewBase.getUpdateDate();
            }
            case 6: {
                return pSPDTViewBase.getUpdateMan();
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
        PSPDTViewBase.set(this, n, object);
    }

    private static void set(PSPDTViewBase pSPDTViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPDTViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPDTViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPDTViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPDTViewBase.setPSPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPDTViewBase.setPSPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPDTViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSPDTViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPDTViewBase.isNull(this, n);
    }

    private static boolean isNull(PSPDTViewBase pSPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPDTViewBase.getCreateDate() == null;
            }
            case 1: {
                return pSPDTViewBase.getCreateMan() == null;
            }
            case 2: {
                return pSPDTViewBase.getMemo() == null;
            }
            case 3: {
                return pSPDTViewBase.getPSPDTViewId() == null;
            }
            case 4: {
                return pSPDTViewBase.getPSPDTViewName() == null;
            }
            case 5: {
                return pSPDTViewBase.getUpdateDate() == null;
            }
            case 6: {
                return pSPDTViewBase.getUpdateMan() == null;
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
        return PSPDTViewBase.contains(this, n);
    }

    private static boolean contains(PSPDTViewBase pSPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPDTViewBase.isCreateDateDirty();
            }
            case 1: {
                return pSPDTViewBase.isCreateManDirty();
            }
            case 2: {
                return pSPDTViewBase.isMemoDirty();
            }
            case 3: {
                return pSPDTViewBase.isPSPDTViewIdDirty();
            }
            case 4: {
                return pSPDTViewBase.isPSPDTViewNameDirty();
            }
            case 5: {
                return pSPDTViewBase.isUpdateDateDirty();
            }
            case 6: {
                return pSPDTViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPDTViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPDTViewBase pSPDTViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPDTViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPDTViewBase.getJSONValue((Object)pSPDTViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPDTViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPDTViewBase.getJSONValue((Object)pSPDTViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPDTViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPDTViewBase.getJSONValue((Object)pSPDTViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSPDTViewBase.getPSPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtviewid", (Object)PSPDTViewBase.getJSONValue((Object)pSPDTViewBase.getPSPDTViewId()), (boolean)false);
        }
        if (bl || pSPDTViewBase.getPSPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtviewname", (Object)PSPDTViewBase.getJSONValue((Object)pSPDTViewBase.getPSPDTViewName()), (boolean)false);
        }
        if (bl || pSPDTViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPDTViewBase.getJSONValue((Object)pSPDTViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPDTViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPDTViewBase.getJSONValue((Object)pSPDTViewBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPDTViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPDTViewBase pSPDTViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPDTViewBase.getCreateDate() != null) {
            object = pSPDTViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPDTViewBase.getCreateMan() != null) {
            object = pSPDTViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPDTViewBase.getMemo() != null) {
            object = pSPDTViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPDTViewBase.getPSPDTViewId() != null) {
            object = pSPDTViewBase.getPSPDTViewId();
            xmlNode.setAttribute(FIELD_PSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSPDTViewBase.getPSPDTViewName() != null) {
            object = pSPDTViewBase.getPSPDTViewName();
            xmlNode.setAttribute(FIELD_PSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPDTViewBase.getUpdateDate() != null) {
            object = pSPDTViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPDTViewBase.getUpdateMan() != null) {
            object = pSPDTViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPDTViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPDTViewBase pSPDTViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPDTViewBase.isCreateDateDirty() && (bl || pSPDTViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPDTViewBase.getCreateDate());
        }
        if (pSPDTViewBase.isCreateManDirty() && (bl || pSPDTViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPDTViewBase.getCreateMan());
        }
        if (pSPDTViewBase.isMemoDirty() && (bl || pSPDTViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPDTViewBase.getMemo());
        }
        if (pSPDTViewBase.isPSPDTViewIdDirty() && (bl || pSPDTViewBase.getPSPDTViewId() != null)) {
            iDataObject.set(FIELD_PSPDTVIEWID, (Object)pSPDTViewBase.getPSPDTViewId());
        }
        if (pSPDTViewBase.isPSPDTViewNameDirty() && (bl || pSPDTViewBase.getPSPDTViewName() != null)) {
            iDataObject.set(FIELD_PSPDTVIEWNAME, (Object)pSPDTViewBase.getPSPDTViewName());
        }
        if (pSPDTViewBase.isUpdateDateDirty() && (bl || pSPDTViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPDTViewBase.getUpdateDate());
        }
        if (pSPDTViewBase.isUpdateManDirty() && (bl || pSPDTViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPDTViewBase.getUpdateMan());
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
        return PSPDTViewBase.remove(this, n);
    }

    private static boolean remove(PSPDTViewBase pSPDTViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPDTViewBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPDTViewBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPDTViewBase.resetMemo();
                return true;
            }
            case 3: {
                pSPDTViewBase.resetPSPDTViewId();
                return true;
            }
            case 4: {
                pSPDTViewBase.resetPSPDTViewName();
                return true;
            }
            case 5: {
                pSPDTViewBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSPDTViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPDTViewBase getProxyEntity() {
        return this.proxyPSPDTViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPDTViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSPDTViewBase) {
            this.proxyPSPDTViewBase = (PSPDTViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPDTViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSPDTVIEWID, 3);
        fieldIndexMap.put(FIELD_PSPDTVIEWNAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
    }
}

