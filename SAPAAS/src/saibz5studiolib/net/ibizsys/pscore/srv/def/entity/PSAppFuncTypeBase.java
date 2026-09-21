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
package net.ibizsys.pscore.srv.def.entity;

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

public abstract class PSAppFuncTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppFuncTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPFUNCTYPEID = "PSAPPFUNCTYPEID";
    public static final String FIELD_PSAPPFUNCTYPENAME = "PSAPPFUNCTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPFUNCTYPEID = 3;
    private static final int INDEX_PSAPPFUNCTYPENAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppFuncTypeBase proxyPSAppFuncTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappfunctypeidDirtyFlag = false;
    private boolean psappfunctypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappfunctypeid")
    private String psappfunctypeid;
    @Column(name="psappfunctypename")
    private String psappfunctypename;
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

    public void setPSAppFuncTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfunctypeid = string;
        this.psappfunctypeidDirtyFlag = true;
    }

    public String getPSAppFuncTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncTypeId();
        }
        return this.psappfunctypeid;
    }

    public boolean isPSAppFuncTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncTypeIdDirty();
        }
        return this.psappfunctypeidDirtyFlag;
    }

    public void resetPSAppFuncTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncTypeId();
            return;
        }
        this.psappfunctypeidDirtyFlag = false;
        this.psappfunctypeid = null;
    }

    public void setPSAppFuncTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfunctypename = string;
        this.psappfunctypenameDirtyFlag = true;
    }

    public String getPSAppFuncTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncTypeName();
        }
        return this.psappfunctypename;
    }

    public boolean isPSAppFuncTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncTypeNameDirty();
        }
        return this.psappfunctypenameDirtyFlag;
    }

    public void resetPSAppFuncTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncTypeName();
            return;
        }
        this.psappfunctypenameDirtyFlag = false;
        this.psappfunctypename = null;
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
        PSAppFuncTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppFuncTypeBase pSAppFuncTypeBase) {
        pSAppFuncTypeBase.resetCreateDate();
        pSAppFuncTypeBase.resetCreateMan();
        pSAppFuncTypeBase.resetMemo();
        pSAppFuncTypeBase.resetPSAppFuncTypeId();
        pSAppFuncTypeBase.resetPSAppFuncTypeName();
        pSAppFuncTypeBase.resetUpdateDate();
        pSAppFuncTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSAppFuncTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPFUNCTYPEID, this.getPSAppFuncTypeId());
        }
        if (!bl || this.isPSAppFuncTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPFUNCTYPENAME, this.getPSAppFuncTypeName());
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
        return PSAppFuncTypeBase.get(this, n);
    }

    private static Object get(PSAppFuncTypeBase pSAppFuncTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppFuncTypeBase.getCreateDate();
            }
            case 1: {
                return pSAppFuncTypeBase.getCreateMan();
            }
            case 2: {
                return pSAppFuncTypeBase.getMemo();
            }
            case 3: {
                return pSAppFuncTypeBase.getPSAppFuncTypeId();
            }
            case 4: {
                return pSAppFuncTypeBase.getPSAppFuncTypeName();
            }
            case 5: {
                return pSAppFuncTypeBase.getUpdateDate();
            }
            case 6: {
                return pSAppFuncTypeBase.getUpdateMan();
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
        PSAppFuncTypeBase.set(this, n, object);
    }

    private static void set(PSAppFuncTypeBase pSAppFuncTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppFuncTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppFuncTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppFuncTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppFuncTypeBase.setPSAppFuncTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppFuncTypeBase.setPSAppFuncTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppFuncTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSAppFuncTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppFuncTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSAppFuncTypeBase pSAppFuncTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppFuncTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppFuncTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppFuncTypeBase.getMemo() == null;
            }
            case 3: {
                return pSAppFuncTypeBase.getPSAppFuncTypeId() == null;
            }
            case 4: {
                return pSAppFuncTypeBase.getPSAppFuncTypeName() == null;
            }
            case 5: {
                return pSAppFuncTypeBase.getUpdateDate() == null;
            }
            case 6: {
                return pSAppFuncTypeBase.getUpdateMan() == null;
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
        return PSAppFuncTypeBase.contains(this, n);
    }

    private static boolean contains(PSAppFuncTypeBase pSAppFuncTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppFuncTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppFuncTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSAppFuncTypeBase.isMemoDirty();
            }
            case 3: {
                return pSAppFuncTypeBase.isPSAppFuncTypeIdDirty();
            }
            case 4: {
                return pSAppFuncTypeBase.isPSAppFuncTypeNameDirty();
            }
            case 5: {
                return pSAppFuncTypeBase.isUpdateDateDirty();
            }
            case 6: {
                return pSAppFuncTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppFuncTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppFuncTypeBase pSAppFuncTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppFuncTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppFuncTypeBase.getJSONValue((Object)pSAppFuncTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppFuncTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppFuncTypeBase.getJSONValue((Object)pSAppFuncTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppFuncTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppFuncTypeBase.getJSONValue((Object)pSAppFuncTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppFuncTypeBase.getPSAppFuncTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfunctypeid", (Object)PSAppFuncTypeBase.getJSONValue((Object)pSAppFuncTypeBase.getPSAppFuncTypeId()), (boolean)false);
        }
        if (bl || pSAppFuncTypeBase.getPSAppFuncTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfunctypename", (Object)PSAppFuncTypeBase.getJSONValue((Object)pSAppFuncTypeBase.getPSAppFuncTypeName()), (boolean)false);
        }
        if (bl || pSAppFuncTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppFuncTypeBase.getJSONValue((Object)pSAppFuncTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppFuncTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppFuncTypeBase.getJSONValue((Object)pSAppFuncTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppFuncTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppFuncTypeBase pSAppFuncTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppFuncTypeBase.getCreateDate() != null) {
            object = pSAppFuncTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppFuncTypeBase.getCreateMan() != null) {
            object = pSAppFuncTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncTypeBase.getMemo() != null) {
            object = pSAppFuncTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncTypeBase.getPSAppFuncTypeId() != null) {
            object = pSAppFuncTypeBase.getPSAppFuncTypeId();
            xmlNode.setAttribute(FIELD_PSAPPFUNCTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncTypeBase.getPSAppFuncTypeName() != null) {
            object = pSAppFuncTypeBase.getPSAppFuncTypeName();
            xmlNode.setAttribute(FIELD_PSAPPFUNCTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncTypeBase.getUpdateDate() != null) {
            object = pSAppFuncTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppFuncTypeBase.getUpdateMan() != null) {
            object = pSAppFuncTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppFuncTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppFuncTypeBase pSAppFuncTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppFuncTypeBase.isCreateDateDirty() && (bl || pSAppFuncTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppFuncTypeBase.getCreateDate());
        }
        if (pSAppFuncTypeBase.isCreateManDirty() && (bl || pSAppFuncTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppFuncTypeBase.getCreateMan());
        }
        if (pSAppFuncTypeBase.isMemoDirty() && (bl || pSAppFuncTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppFuncTypeBase.getMemo());
        }
        if (pSAppFuncTypeBase.isPSAppFuncTypeIdDirty() && (bl || pSAppFuncTypeBase.getPSAppFuncTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCTYPEID, (Object)pSAppFuncTypeBase.getPSAppFuncTypeId());
        }
        if (pSAppFuncTypeBase.isPSAppFuncTypeNameDirty() && (bl || pSAppFuncTypeBase.getPSAppFuncTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCTYPENAME, (Object)pSAppFuncTypeBase.getPSAppFuncTypeName());
        }
        if (pSAppFuncTypeBase.isUpdateDateDirty() && (bl || pSAppFuncTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppFuncTypeBase.getUpdateDate());
        }
        if (pSAppFuncTypeBase.isUpdateManDirty() && (bl || pSAppFuncTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppFuncTypeBase.getUpdateMan());
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
        return PSAppFuncTypeBase.remove(this, n);
    }

    private static boolean remove(PSAppFuncTypeBase pSAppFuncTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppFuncTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppFuncTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppFuncTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppFuncTypeBase.resetPSAppFuncTypeId();
                return true;
            }
            case 4: {
                pSAppFuncTypeBase.resetPSAppFuncTypeName();
                return true;
            }
            case 5: {
                pSAppFuncTypeBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSAppFuncTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSAppFuncTypeBase getProxyEntity() {
        return this.proxyPSAppFuncTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppFuncTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppFuncTypeBase) {
            this.proxyPSAppFuncTypeBase = (PSAppFuncTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSAppFuncTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPFUNCTYPEID, 3);
        fieldIndexMap.put(FIELD_PSAPPFUNCTYPENAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
    }
}

