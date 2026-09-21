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

public abstract class PSModelInitBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelInitBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELINITID = "PSMODELINITID";
    public static final String FIELD_PSMODELINITNAME = "PSMODELINITNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSMODELINITID = 3;
    private static final int INDEX_PSMODELINITNAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelInitBase proxyPSModelInitBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodelinitidDirtyFlag = false;
    private boolean psmodelinitnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodelinitid")
    private String psmodelinitid;
    @Column(name="psmodelinitname")
    private String psmodelinitname;
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

    public void setPSModelInitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelInitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelinitid = string;
        this.psmodelinitidDirtyFlag = true;
    }

    public String getPSModelInitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelInitId();
        }
        return this.psmodelinitid;
    }

    public boolean isPSModelInitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelInitIdDirty();
        }
        return this.psmodelinitidDirtyFlag;
    }

    public void resetPSModelInitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelInitId();
            return;
        }
        this.psmodelinitidDirtyFlag = false;
        this.psmodelinitid = null;
    }

    public void setPSModelInitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelInitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelinitname = string;
        this.psmodelinitnameDirtyFlag = true;
    }

    public String getPSModelInitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelInitName();
        }
        return this.psmodelinitname;
    }

    public boolean isPSModelInitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelInitNameDirty();
        }
        return this.psmodelinitnameDirtyFlag;
    }

    public void resetPSModelInitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelInitName();
            return;
        }
        this.psmodelinitnameDirtyFlag = false;
        this.psmodelinitname = null;
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
        PSModelInitBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelInitBase pSModelInitBase) {
        pSModelInitBase.resetCreateDate();
        pSModelInitBase.resetCreateMan();
        pSModelInitBase.resetMemo();
        pSModelInitBase.resetPSModelInitId();
        pSModelInitBase.resetPSModelInitName();
        pSModelInitBase.resetUpdateDate();
        pSModelInitBase.resetUpdateMan();
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
        if (!bl || this.isPSModelInitIdDirty()) {
            hashMap.put(FIELD_PSMODELINITID, this.getPSModelInitId());
        }
        if (!bl || this.isPSModelInitNameDirty()) {
            hashMap.put(FIELD_PSMODELINITNAME, this.getPSModelInitName());
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
        return PSModelInitBase.get(this, n);
    }

    private static Object get(PSModelInitBase pSModelInitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelInitBase.getCreateDate();
            }
            case 1: {
                return pSModelInitBase.getCreateMan();
            }
            case 2: {
                return pSModelInitBase.getMemo();
            }
            case 3: {
                return pSModelInitBase.getPSModelInitId();
            }
            case 4: {
                return pSModelInitBase.getPSModelInitName();
            }
            case 5: {
                return pSModelInitBase.getUpdateDate();
            }
            case 6: {
                return pSModelInitBase.getUpdateMan();
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
        PSModelInitBase.set(this, n, object);
    }

    private static void set(PSModelInitBase pSModelInitBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelInitBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelInitBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelInitBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelInitBase.setPSModelInitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelInitBase.setPSModelInitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelInitBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSModelInitBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelInitBase.isNull(this, n);
    }

    private static boolean isNull(PSModelInitBase pSModelInitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelInitBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelInitBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelInitBase.getMemo() == null;
            }
            case 3: {
                return pSModelInitBase.getPSModelInitId() == null;
            }
            case 4: {
                return pSModelInitBase.getPSModelInitName() == null;
            }
            case 5: {
                return pSModelInitBase.getUpdateDate() == null;
            }
            case 6: {
                return pSModelInitBase.getUpdateMan() == null;
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
        return PSModelInitBase.contains(this, n);
    }

    private static boolean contains(PSModelInitBase pSModelInitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelInitBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelInitBase.isCreateManDirty();
            }
            case 2: {
                return pSModelInitBase.isMemoDirty();
            }
            case 3: {
                return pSModelInitBase.isPSModelInitIdDirty();
            }
            case 4: {
                return pSModelInitBase.isPSModelInitNameDirty();
            }
            case 5: {
                return pSModelInitBase.isUpdateDateDirty();
            }
            case 6: {
                return pSModelInitBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelInitBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelInitBase pSModelInitBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelInitBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelInitBase.getJSONValue((Object)pSModelInitBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelInitBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelInitBase.getJSONValue((Object)pSModelInitBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelInitBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelInitBase.getJSONValue((Object)pSModelInitBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelInitBase.getPSModelInitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelinitid", (Object)PSModelInitBase.getJSONValue((Object)pSModelInitBase.getPSModelInitId()), (boolean)false);
        }
        if (bl || pSModelInitBase.getPSModelInitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelinitname", (Object)PSModelInitBase.getJSONValue((Object)pSModelInitBase.getPSModelInitName()), (boolean)false);
        }
        if (bl || pSModelInitBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelInitBase.getJSONValue((Object)pSModelInitBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelInitBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelInitBase.getJSONValue((Object)pSModelInitBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelInitBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelInitBase pSModelInitBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelInitBase.getCreateDate() != null) {
            object = pSModelInitBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelInitBase.getCreateMan() != null) {
            object = pSModelInitBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelInitBase.getMemo() != null) {
            object = pSModelInitBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelInitBase.getPSModelInitId() != null) {
            object = pSModelInitBase.getPSModelInitId();
            xmlNode.setAttribute(FIELD_PSMODELINITID, object == null ? "" : (String)object);
        }
        if (bl || pSModelInitBase.getPSModelInitName() != null) {
            object = pSModelInitBase.getPSModelInitName();
            xmlNode.setAttribute(FIELD_PSMODELINITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelInitBase.getUpdateDate() != null) {
            object = pSModelInitBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelInitBase.getUpdateMan() != null) {
            object = pSModelInitBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelInitBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelInitBase pSModelInitBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelInitBase.isCreateDateDirty() && (bl || pSModelInitBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelInitBase.getCreateDate());
        }
        if (pSModelInitBase.isCreateManDirty() && (bl || pSModelInitBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelInitBase.getCreateMan());
        }
        if (pSModelInitBase.isMemoDirty() && (bl || pSModelInitBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelInitBase.getMemo());
        }
        if (pSModelInitBase.isPSModelInitIdDirty() && (bl || pSModelInitBase.getPSModelInitId() != null)) {
            iDataObject.set(FIELD_PSMODELINITID, (Object)pSModelInitBase.getPSModelInitId());
        }
        if (pSModelInitBase.isPSModelInitNameDirty() && (bl || pSModelInitBase.getPSModelInitName() != null)) {
            iDataObject.set(FIELD_PSMODELINITNAME, (Object)pSModelInitBase.getPSModelInitName());
        }
        if (pSModelInitBase.isUpdateDateDirty() && (bl || pSModelInitBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelInitBase.getUpdateDate());
        }
        if (pSModelInitBase.isUpdateManDirty() && (bl || pSModelInitBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelInitBase.getUpdateMan());
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
        return PSModelInitBase.remove(this, n);
    }

    private static boolean remove(PSModelInitBase pSModelInitBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelInitBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelInitBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelInitBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelInitBase.resetPSModelInitId();
                return true;
            }
            case 4: {
                pSModelInitBase.resetPSModelInitName();
                return true;
            }
            case 5: {
                pSModelInitBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSModelInitBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelInitBase getProxyEntity() {
        return this.proxyPSModelInitBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelInitBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelInitBase) {
            this.proxyPSModelInitBase = (PSModelInitBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelInitService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSMODELINITID, 3);
        fieldIndexMap.put(FIELD_PSMODELINITNAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
    }
}

