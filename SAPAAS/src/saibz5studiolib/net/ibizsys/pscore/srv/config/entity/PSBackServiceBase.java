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

public abstract class PSBackServiceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSBackServiceBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSBACKSERVICEID = "PSBACKSERVICEID";
    public static final String FIELD_PSBACKSERVICENAME = "PSBACKSERVICENAME";
    public static final String FIELD_SERVICEOBJ = "SERVICEOBJ";
    public static final String FIELD_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSBACKSERVICEID = 3;
    private static final int INDEX_PSBACKSERVICENAME = 4;
    private static final int INDEX_SERVICEOBJ = 5;
    private static final int INDEX_SERVICEPARAMS = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSBackServiceBase proxyPSBackServiceBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psbackserviceidDirtyFlag = false;
    private boolean psbackservicenameDirtyFlag = false;
    private boolean serviceobjDirtyFlag = false;
    private boolean serviceparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psbackserviceid")
    private String psbackserviceid;
    @Column(name="psbackservicename")
    private String psbackservicename;
    @Column(name="serviceobj")
    private String serviceobj;
    @Column(name="serviceparams")
    private String serviceparams;
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

    public void setPSBackServiceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBackServiceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbackserviceid = string;
        this.psbackserviceidDirtyFlag = true;
    }

    public String getPSBackServiceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBackServiceId();
        }
        return this.psbackserviceid;
    }

    public boolean isPSBackServiceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBackServiceIdDirty();
        }
        return this.psbackserviceidDirtyFlag;
    }

    public void resetPSBackServiceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBackServiceId();
            return;
        }
        this.psbackserviceidDirtyFlag = false;
        this.psbackserviceid = null;
    }

    public void setPSBackServiceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBackServiceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbackservicename = string;
        this.psbackservicenameDirtyFlag = true;
    }

    public String getPSBackServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBackServiceName();
        }
        return this.psbackservicename;
    }

    public boolean isPSBackServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBackServiceNameDirty();
        }
        return this.psbackservicenameDirtyFlag;
    }

    public void resetPSBackServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBackServiceName();
            return;
        }
        this.psbackservicenameDirtyFlag = false;
        this.psbackservicename = null;
    }

    public void setServiceObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceobj = string;
        this.serviceobjDirtyFlag = true;
    }

    public String getServiceObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceObj();
        }
        return this.serviceobj;
    }

    public boolean isServiceObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceObjDirty();
        }
        return this.serviceobjDirtyFlag;
    }

    public void resetServiceObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceObj();
            return;
        }
        this.serviceobjDirtyFlag = false;
        this.serviceobj = null;
    }

    public void setServiceParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparams = string;
        this.serviceparamsDirtyFlag = true;
    }

    public String getServiceParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParams();
        }
        return this.serviceparams;
    }

    public boolean isServiceParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamsDirty();
        }
        return this.serviceparamsDirtyFlag;
    }

    public void resetServiceParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParams();
            return;
        }
        this.serviceparamsDirtyFlag = false;
        this.serviceparams = null;
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
        PSBackServiceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSBackServiceBase pSBackServiceBase) {
        pSBackServiceBase.resetCreateDate();
        pSBackServiceBase.resetCreateMan();
        pSBackServiceBase.resetMemo();
        pSBackServiceBase.resetPSBackServiceId();
        pSBackServiceBase.resetPSBackServiceName();
        pSBackServiceBase.resetServiceObj();
        pSBackServiceBase.resetServiceParams();
        pSBackServiceBase.resetUpdateDate();
        pSBackServiceBase.resetUpdateMan();
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
        if (!bl || this.isPSBackServiceIdDirty()) {
            hashMap.put(FIELD_PSBACKSERVICEID, this.getPSBackServiceId());
        }
        if (!bl || this.isPSBackServiceNameDirty()) {
            hashMap.put(FIELD_PSBACKSERVICENAME, this.getPSBackServiceName());
        }
        if (!bl || this.isServiceObjDirty()) {
            hashMap.put(FIELD_SERVICEOBJ, this.getServiceObj());
        }
        if (!bl || this.isServiceParamsDirty()) {
            hashMap.put(FIELD_SERVICEPARAMS, this.getServiceParams());
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
        return PSBackServiceBase.get(this, n);
    }

    private static Object get(PSBackServiceBase pSBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBackServiceBase.getCreateDate();
            }
            case 1: {
                return pSBackServiceBase.getCreateMan();
            }
            case 2: {
                return pSBackServiceBase.getMemo();
            }
            case 3: {
                return pSBackServiceBase.getPSBackServiceId();
            }
            case 4: {
                return pSBackServiceBase.getPSBackServiceName();
            }
            case 5: {
                return pSBackServiceBase.getServiceObj();
            }
            case 6: {
                return pSBackServiceBase.getServiceParams();
            }
            case 7: {
                return pSBackServiceBase.getUpdateDate();
            }
            case 8: {
                return pSBackServiceBase.getUpdateMan();
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
        PSBackServiceBase.set(this, n, object);
    }

    private static void set(PSBackServiceBase pSBackServiceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSBackServiceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSBackServiceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSBackServiceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSBackServiceBase.setPSBackServiceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSBackServiceBase.setPSBackServiceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSBackServiceBase.setServiceObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSBackServiceBase.setServiceParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSBackServiceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSBackServiceBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSBackServiceBase.isNull(this, n);
    }

    private static boolean isNull(PSBackServiceBase pSBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBackServiceBase.getCreateDate() == null;
            }
            case 1: {
                return pSBackServiceBase.getCreateMan() == null;
            }
            case 2: {
                return pSBackServiceBase.getMemo() == null;
            }
            case 3: {
                return pSBackServiceBase.getPSBackServiceId() == null;
            }
            case 4: {
                return pSBackServiceBase.getPSBackServiceName() == null;
            }
            case 5: {
                return pSBackServiceBase.getServiceObj() == null;
            }
            case 6: {
                return pSBackServiceBase.getServiceParams() == null;
            }
            case 7: {
                return pSBackServiceBase.getUpdateDate() == null;
            }
            case 8: {
                return pSBackServiceBase.getUpdateMan() == null;
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
        return PSBackServiceBase.contains(this, n);
    }

    private static boolean contains(PSBackServiceBase pSBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBackServiceBase.isCreateDateDirty();
            }
            case 1: {
                return pSBackServiceBase.isCreateManDirty();
            }
            case 2: {
                return pSBackServiceBase.isMemoDirty();
            }
            case 3: {
                return pSBackServiceBase.isPSBackServiceIdDirty();
            }
            case 4: {
                return pSBackServiceBase.isPSBackServiceNameDirty();
            }
            case 5: {
                return pSBackServiceBase.isServiceObjDirty();
            }
            case 6: {
                return pSBackServiceBase.isServiceParamsDirty();
            }
            case 7: {
                return pSBackServiceBase.isUpdateDateDirty();
            }
            case 8: {
                return pSBackServiceBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSBackServiceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSBackServiceBase pSBackServiceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSBackServiceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getMemo()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getPSBackServiceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbackserviceid", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getPSBackServiceId()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getPSBackServiceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbackservicename", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getPSBackServiceName()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getServiceObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceobj", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getServiceObj()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getServiceParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparams", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getServiceParams()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSBackServiceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSBackServiceBase.getJSONValue((Object)pSBackServiceBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSBackServiceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSBackServiceBase pSBackServiceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSBackServiceBase.getCreateDate() != null) {
            object = pSBackServiceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBackServiceBase.getCreateMan() != null) {
            object = pSBackServiceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBackServiceBase.getMemo() != null) {
            object = pSBackServiceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSBackServiceBase.getPSBackServiceId() != null) {
            object = pSBackServiceBase.getPSBackServiceId();
            xmlNode.setAttribute(FIELD_PSBACKSERVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSBackServiceBase.getPSBackServiceName() != null) {
            object = pSBackServiceBase.getPSBackServiceName();
            xmlNode.setAttribute(FIELD_PSBACKSERVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSBackServiceBase.getServiceObj() != null) {
            object = pSBackServiceBase.getServiceObj();
            xmlNode.setAttribute(FIELD_SERVICEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSBackServiceBase.getServiceParams() != null) {
            object = pSBackServiceBase.getServiceParams();
            xmlNode.setAttribute(FIELD_SERVICEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSBackServiceBase.getUpdateDate() != null) {
            object = pSBackServiceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBackServiceBase.getUpdateMan() != null) {
            object = pSBackServiceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSBackServiceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSBackServiceBase pSBackServiceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSBackServiceBase.isCreateDateDirty() && (bl || pSBackServiceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSBackServiceBase.getCreateDate());
        }
        if (pSBackServiceBase.isCreateManDirty() && (bl || pSBackServiceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSBackServiceBase.getCreateMan());
        }
        if (pSBackServiceBase.isMemoDirty() && (bl || pSBackServiceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSBackServiceBase.getMemo());
        }
        if (pSBackServiceBase.isPSBackServiceIdDirty() && (bl || pSBackServiceBase.getPSBackServiceId() != null)) {
            iDataObject.set(FIELD_PSBACKSERVICEID, (Object)pSBackServiceBase.getPSBackServiceId());
        }
        if (pSBackServiceBase.isPSBackServiceNameDirty() && (bl || pSBackServiceBase.getPSBackServiceName() != null)) {
            iDataObject.set(FIELD_PSBACKSERVICENAME, (Object)pSBackServiceBase.getPSBackServiceName());
        }
        if (pSBackServiceBase.isServiceObjDirty() && (bl || pSBackServiceBase.getServiceObj() != null)) {
            iDataObject.set(FIELD_SERVICEOBJ, (Object)pSBackServiceBase.getServiceObj());
        }
        if (pSBackServiceBase.isServiceParamsDirty() && (bl || pSBackServiceBase.getServiceParams() != null)) {
            iDataObject.set(FIELD_SERVICEPARAMS, (Object)pSBackServiceBase.getServiceParams());
        }
        if (pSBackServiceBase.isUpdateDateDirty() && (bl || pSBackServiceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSBackServiceBase.getUpdateDate());
        }
        if (pSBackServiceBase.isUpdateManDirty() && (bl || pSBackServiceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSBackServiceBase.getUpdateMan());
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
        return PSBackServiceBase.remove(this, n);
    }

    private static boolean remove(PSBackServiceBase pSBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSBackServiceBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSBackServiceBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSBackServiceBase.resetMemo();
                return true;
            }
            case 3: {
                pSBackServiceBase.resetPSBackServiceId();
                return true;
            }
            case 4: {
                pSBackServiceBase.resetPSBackServiceName();
                return true;
            }
            case 5: {
                pSBackServiceBase.resetServiceObj();
                return true;
            }
            case 6: {
                pSBackServiceBase.resetServiceParams();
                return true;
            }
            case 7: {
                pSBackServiceBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSBackServiceBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSBackServiceBase getProxyEntity() {
        return this.proxyPSBackServiceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSBackServiceBase = null;
        if (iDataObject != null && iDataObject instanceof PSBackServiceBase) {
            this.proxyPSBackServiceBase = (PSBackServiceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSBackServiceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSBACKSERVICEID, 3);
        fieldIndexMap.put(FIELD_PSBACKSERVICENAME, 4);
        fieldIndexMap.put(FIELD_SERVICEOBJ, 5);
        fieldIndexMap.put(FIELD_SERVICEPARAMS, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

