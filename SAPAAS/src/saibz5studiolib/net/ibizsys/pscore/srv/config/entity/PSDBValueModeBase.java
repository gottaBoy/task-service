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

public abstract class PSDBValueModeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBValueModeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBVALUEMODEID = "PSDBVALUEMODEID";
    public static final String FIELD_PSDBVALUEMODENAME = "PSDBVALUEMODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDBVALUEMODEID = 3;
    private static final int INDEX_PSDBVALUEMODENAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBValueModeBase proxyPSDBValueModeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbvaluemodeidDirtyFlag = false;
    private boolean psdbvaluemodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbvaluemodeid")
    private String psdbvaluemodeid;
    @Column(name="psdbvaluemodename")
    private String psdbvaluemodename;
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

    public void setPSDBValueModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvaluemodeid = string;
        this.psdbvaluemodeidDirtyFlag = true;
    }

    public String getPSDBValueModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueModeId();
        }
        return this.psdbvaluemodeid;
    }

    public boolean isPSDBValueModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueModeIdDirty();
        }
        return this.psdbvaluemodeidDirtyFlag;
    }

    public void resetPSDBValueModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueModeId();
            return;
        }
        this.psdbvaluemodeidDirtyFlag = false;
        this.psdbvaluemodeid = null;
    }

    public void setPSDBValueModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvaluemodename = string;
        this.psdbvaluemodenameDirtyFlag = true;
    }

    public String getPSDBValueModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueModeName();
        }
        return this.psdbvaluemodename;
    }

    public boolean isPSDBValueModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueModeNameDirty();
        }
        return this.psdbvaluemodenameDirtyFlag;
    }

    public void resetPSDBValueModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueModeName();
            return;
        }
        this.psdbvaluemodenameDirtyFlag = false;
        this.psdbvaluemodename = null;
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
        PSDBValueModeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBValueModeBase pSDBValueModeBase) {
        pSDBValueModeBase.resetCreateDate();
        pSDBValueModeBase.resetCreateMan();
        pSDBValueModeBase.resetMemo();
        pSDBValueModeBase.resetPSDBValueModeId();
        pSDBValueModeBase.resetPSDBValueModeName();
        pSDBValueModeBase.resetUpdateDate();
        pSDBValueModeBase.resetUpdateMan();
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
        if (!bl || this.isPSDBValueModeIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEMODEID, this.getPSDBValueModeId());
        }
        if (!bl || this.isPSDBValueModeNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEMODENAME, this.getPSDBValueModeName());
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
        return PSDBValueModeBase.get(this, n);
    }

    private static Object get(PSDBValueModeBase pSDBValueModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueModeBase.getCreateDate();
            }
            case 1: {
                return pSDBValueModeBase.getCreateMan();
            }
            case 2: {
                return pSDBValueModeBase.getMemo();
            }
            case 3: {
                return pSDBValueModeBase.getPSDBValueModeId();
            }
            case 4: {
                return pSDBValueModeBase.getPSDBValueModeName();
            }
            case 5: {
                return pSDBValueModeBase.getUpdateDate();
            }
            case 6: {
                return pSDBValueModeBase.getUpdateMan();
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
        PSDBValueModeBase.set(this, n, object);
    }

    private static void set(PSDBValueModeBase pSDBValueModeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBValueModeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDBValueModeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBValueModeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBValueModeBase.setPSDBValueModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBValueModeBase.setPSDBValueModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBValueModeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDBValueModeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDBValueModeBase.isNull(this, n);
    }

    private static boolean isNull(PSDBValueModeBase pSDBValueModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueModeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDBValueModeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDBValueModeBase.getMemo() == null;
            }
            case 3: {
                return pSDBValueModeBase.getPSDBValueModeId() == null;
            }
            case 4: {
                return pSDBValueModeBase.getPSDBValueModeName() == null;
            }
            case 5: {
                return pSDBValueModeBase.getUpdateDate() == null;
            }
            case 6: {
                return pSDBValueModeBase.getUpdateMan() == null;
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
        return PSDBValueModeBase.contains(this, n);
    }

    private static boolean contains(PSDBValueModeBase pSDBValueModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueModeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDBValueModeBase.isCreateManDirty();
            }
            case 2: {
                return pSDBValueModeBase.isMemoDirty();
            }
            case 3: {
                return pSDBValueModeBase.isPSDBValueModeIdDirty();
            }
            case 4: {
                return pSDBValueModeBase.isPSDBValueModeNameDirty();
            }
            case 5: {
                return pSDBValueModeBase.isUpdateDateDirty();
            }
            case 6: {
                return pSDBValueModeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBValueModeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBValueModeBase pSDBValueModeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBValueModeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBValueModeBase.getJSONValue((Object)pSDBValueModeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBValueModeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBValueModeBase.getJSONValue((Object)pSDBValueModeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBValueModeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBValueModeBase.getJSONValue((Object)pSDBValueModeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBValueModeBase.getPSDBValueModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvaluemodeid", (Object)PSDBValueModeBase.getJSONValue((Object)pSDBValueModeBase.getPSDBValueModeId()), (boolean)false);
        }
        if (bl || pSDBValueModeBase.getPSDBValueModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvaluemodename", (Object)PSDBValueModeBase.getJSONValue((Object)pSDBValueModeBase.getPSDBValueModeName()), (boolean)false);
        }
        if (bl || pSDBValueModeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBValueModeBase.getJSONValue((Object)pSDBValueModeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBValueModeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBValueModeBase.getJSONValue((Object)pSDBValueModeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBValueModeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBValueModeBase pSDBValueModeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBValueModeBase.getCreateDate() != null) {
            object = pSDBValueModeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBValueModeBase.getCreateMan() != null) {
            object = pSDBValueModeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueModeBase.getMemo() != null) {
            object = pSDBValueModeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueModeBase.getPSDBValueModeId() != null) {
            object = pSDBValueModeBase.getPSDBValueModeId();
            xmlNode.setAttribute(FIELD_PSDBVALUEMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueModeBase.getPSDBValueModeName() != null) {
            object = pSDBValueModeBase.getPSDBValueModeName();
            xmlNode.setAttribute(FIELD_PSDBVALUEMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueModeBase.getUpdateDate() != null) {
            object = pSDBValueModeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBValueModeBase.getUpdateMan() != null) {
            object = pSDBValueModeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBValueModeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBValueModeBase pSDBValueModeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBValueModeBase.isCreateDateDirty() && (bl || pSDBValueModeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBValueModeBase.getCreateDate());
        }
        if (pSDBValueModeBase.isCreateManDirty() && (bl || pSDBValueModeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBValueModeBase.getCreateMan());
        }
        if (pSDBValueModeBase.isMemoDirty() && (bl || pSDBValueModeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBValueModeBase.getMemo());
        }
        if (pSDBValueModeBase.isPSDBValueModeIdDirty() && (bl || pSDBValueModeBase.getPSDBValueModeId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEMODEID, (Object)pSDBValueModeBase.getPSDBValueModeId());
        }
        if (pSDBValueModeBase.isPSDBValueModeNameDirty() && (bl || pSDBValueModeBase.getPSDBValueModeName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEMODENAME, (Object)pSDBValueModeBase.getPSDBValueModeName());
        }
        if (pSDBValueModeBase.isUpdateDateDirty() && (bl || pSDBValueModeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBValueModeBase.getUpdateDate());
        }
        if (pSDBValueModeBase.isUpdateManDirty() && (bl || pSDBValueModeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBValueModeBase.getUpdateMan());
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
        return PSDBValueModeBase.remove(this, n);
    }

    private static boolean remove(PSDBValueModeBase pSDBValueModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBValueModeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDBValueModeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDBValueModeBase.resetMemo();
                return true;
            }
            case 3: {
                pSDBValueModeBase.resetPSDBValueModeId();
                return true;
            }
            case 4: {
                pSDBValueModeBase.resetPSDBValueModeName();
                return true;
            }
            case 5: {
                pSDBValueModeBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSDBValueModeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDBValueModeBase getProxyEntity() {
        return this.proxyPSDBValueModeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBValueModeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBValueModeBase) {
            this.proxyPSDBValueModeBase = (PSDBValueModeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueModeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDBVALUEMODEID, 3);
        fieldIndexMap.put(FIELD_PSDBVALUEMODENAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
    }
}

