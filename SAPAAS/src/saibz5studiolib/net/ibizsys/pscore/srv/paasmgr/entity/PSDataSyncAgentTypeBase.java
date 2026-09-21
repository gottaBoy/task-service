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
package net.ibizsys.pscore.srv.paasmgr.entity;

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

public abstract class PSDataSyncAgentTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDataSyncAgentTypeBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDATASYNCAGENTTYPEID = "PSDATASYNCAGENTTYPEID";
    public static final String FIELD_PSDATASYNCAGENTTYPENAME = "PSDATASYNCAGENTTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDATASYNCAGENTTYPEID = 5;
    private static final int INDEX_PSDATASYNCAGENTTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDataSyncAgentTypeBase proxyPSDataSyncAgentTypeBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdatasyncagenttypeidDirtyFlag = false;
    private boolean psdatasyncagenttypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="psdatasyncagenttypeid")
    private String psdatasyncagenttypeid;
    @Column(name="psdatasyncagenttypename")
    private String psdatasyncagenttypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
    }

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

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setPSDataSyncAgentTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataSyncAgentTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatasyncagenttypeid = string;
        this.psdatasyncagenttypeidDirtyFlag = true;
    }

    public String getPSDataSyncAgentTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataSyncAgentTypeId();
        }
        return this.psdatasyncagenttypeid;
    }

    public boolean isPSDataSyncAgentTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataSyncAgentTypeIdDirty();
        }
        return this.psdatasyncagenttypeidDirtyFlag;
    }

    public void resetPSDataSyncAgentTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataSyncAgentTypeId();
            return;
        }
        this.psdatasyncagenttypeidDirtyFlag = false;
        this.psdatasyncagenttypeid = null;
    }

    public void setPSDataSyncAgentTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataSyncAgentTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatasyncagenttypename = string;
        this.psdatasyncagenttypenameDirtyFlag = true;
    }

    public String getPSDataSyncAgentTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataSyncAgentTypeName();
        }
        return this.psdatasyncagenttypename;
    }

    public boolean isPSDataSyncAgentTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataSyncAgentTypeNameDirty();
        }
        return this.psdatasyncagenttypenameDirtyFlag;
    }

    public void resetPSDataSyncAgentTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataSyncAgentTypeName();
            return;
        }
        this.psdatasyncagenttypenameDirtyFlag = false;
        this.psdatasyncagenttypename = null;
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
        PSDataSyncAgentTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase) {
        pSDataSyncAgentTypeBase.resetBaseClsParams();
        pSDataSyncAgentTypeBase.resetCreateDate();
        pSDataSyncAgentTypeBase.resetCreateMan();
        pSDataSyncAgentTypeBase.resetEnable();
        pSDataSyncAgentTypeBase.resetMemo();
        pSDataSyncAgentTypeBase.resetPSDataSyncAgentTypeId();
        pSDataSyncAgentTypeBase.resetPSDataSyncAgentTypeName();
        pSDataSyncAgentTypeBase.resetUpdateDate();
        pSDataSyncAgentTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDataSyncAgentTypeIdDirty()) {
            hashMap.put(FIELD_PSDATASYNCAGENTTYPEID, this.getPSDataSyncAgentTypeId());
        }
        if (!bl || this.isPSDataSyncAgentTypeNameDirty()) {
            hashMap.put(FIELD_PSDATASYNCAGENTTYPENAME, this.getPSDataSyncAgentTypeName());
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
        return PSDataSyncAgentTypeBase.get(this, n);
    }

    private static Object get(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDataSyncAgentTypeBase.getBaseClsParams();
            }
            case 1: {
                return pSDataSyncAgentTypeBase.getCreateDate();
            }
            case 2: {
                return pSDataSyncAgentTypeBase.getCreateMan();
            }
            case 3: {
                return pSDataSyncAgentTypeBase.getEnable();
            }
            case 4: {
                return pSDataSyncAgentTypeBase.getMemo();
            }
            case 5: {
                return pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId();
            }
            case 6: {
                return pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName();
            }
            case 7: {
                return pSDataSyncAgentTypeBase.getUpdateDate();
            }
            case 8: {
                return pSDataSyncAgentTypeBase.getUpdateMan();
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
        PSDataSyncAgentTypeBase.set(this, n, object);
    }

    private static void set(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDataSyncAgentTypeBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDataSyncAgentTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDataSyncAgentTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDataSyncAgentTypeBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDataSyncAgentTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDataSyncAgentTypeBase.setPSDataSyncAgentTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDataSyncAgentTypeBase.setPSDataSyncAgentTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDataSyncAgentTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDataSyncAgentTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDataSyncAgentTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDataSyncAgentTypeBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSDataSyncAgentTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSDataSyncAgentTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSDataSyncAgentTypeBase.getEnable() == null;
            }
            case 4: {
                return pSDataSyncAgentTypeBase.getMemo() == null;
            }
            case 5: {
                return pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId() == null;
            }
            case 6: {
                return pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName() == null;
            }
            case 7: {
                return pSDataSyncAgentTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDataSyncAgentTypeBase.getUpdateMan() == null;
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
        return PSDataSyncAgentTypeBase.contains(this, n);
    }

    private static boolean contains(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDataSyncAgentTypeBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSDataSyncAgentTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSDataSyncAgentTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSDataSyncAgentTypeBase.isEnableDirty();
            }
            case 4: {
                return pSDataSyncAgentTypeBase.isMemoDirty();
            }
            case 5: {
                return pSDataSyncAgentTypeBase.isPSDataSyncAgentTypeIdDirty();
            }
            case 6: {
                return pSDataSyncAgentTypeBase.isPSDataSyncAgentTypeNameDirty();
            }
            case 7: {
                return pSDataSyncAgentTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDataSyncAgentTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDataSyncAgentTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDataSyncAgentTypeBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getEnable()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatasyncagenttypeid", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatasyncagenttypename", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDataSyncAgentTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDataSyncAgentTypeBase.getJSONValue((Object)pSDataSyncAgentTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDataSyncAgentTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDataSyncAgentTypeBase.getBaseClsParams() != null) {
            object = pSDataSyncAgentTypeBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDataSyncAgentTypeBase.getCreateDate() != null) {
            object = pSDataSyncAgentTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDataSyncAgentTypeBase.getCreateMan() != null) {
            object = pSDataSyncAgentTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDataSyncAgentTypeBase.getEnable() != null) {
            object = pSDataSyncAgentTypeBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDataSyncAgentTypeBase.getMemo() != null) {
            object = pSDataSyncAgentTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId() != null) {
            object = pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId();
            xmlNode.setAttribute(FIELD_PSDATASYNCAGENTTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName() != null) {
            object = pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName();
            xmlNode.setAttribute(FIELD_PSDATASYNCAGENTTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDataSyncAgentTypeBase.getUpdateDate() != null) {
            object = pSDataSyncAgentTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDataSyncAgentTypeBase.getUpdateMan() != null) {
            object = pSDataSyncAgentTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDataSyncAgentTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDataSyncAgentTypeBase.isBaseClsParamsDirty() && (bl || pSDataSyncAgentTypeBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSDataSyncAgentTypeBase.getBaseClsParams());
        }
        if (pSDataSyncAgentTypeBase.isCreateDateDirty() && (bl || pSDataSyncAgentTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDataSyncAgentTypeBase.getCreateDate());
        }
        if (pSDataSyncAgentTypeBase.isCreateManDirty() && (bl || pSDataSyncAgentTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDataSyncAgentTypeBase.getCreateMan());
        }
        if (pSDataSyncAgentTypeBase.isEnableDirty() && (bl || pSDataSyncAgentTypeBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSDataSyncAgentTypeBase.getEnable());
        }
        if (pSDataSyncAgentTypeBase.isMemoDirty() && (bl || pSDataSyncAgentTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDataSyncAgentTypeBase.getMemo());
        }
        if (pSDataSyncAgentTypeBase.isPSDataSyncAgentTypeIdDirty() && (bl || pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId() != null)) {
            iDataObject.set(FIELD_PSDATASYNCAGENTTYPEID, (Object)pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeId());
        }
        if (pSDataSyncAgentTypeBase.isPSDataSyncAgentTypeNameDirty() && (bl || pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName() != null)) {
            iDataObject.set(FIELD_PSDATASYNCAGENTTYPENAME, (Object)pSDataSyncAgentTypeBase.getPSDataSyncAgentTypeName());
        }
        if (pSDataSyncAgentTypeBase.isUpdateDateDirty() && (bl || pSDataSyncAgentTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDataSyncAgentTypeBase.getUpdateDate());
        }
        if (pSDataSyncAgentTypeBase.isUpdateManDirty() && (bl || pSDataSyncAgentTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDataSyncAgentTypeBase.getUpdateMan());
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
        return PSDataSyncAgentTypeBase.remove(this, n);
    }

    private static boolean remove(PSDataSyncAgentTypeBase pSDataSyncAgentTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDataSyncAgentTypeBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSDataSyncAgentTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDataSyncAgentTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDataSyncAgentTypeBase.resetEnable();
                return true;
            }
            case 4: {
                pSDataSyncAgentTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSDataSyncAgentTypeBase.resetPSDataSyncAgentTypeId();
                return true;
            }
            case 6: {
                pSDataSyncAgentTypeBase.resetPSDataSyncAgentTypeName();
                return true;
            }
            case 7: {
                pSDataSyncAgentTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDataSyncAgentTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDataSyncAgentTypeBase getProxyEntity() {
        return this.proxyPSDataSyncAgentTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDataSyncAgentTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDataSyncAgentTypeBase) {
            this.proxyPSDataSyncAgentTypeBase = (PSDataSyncAgentTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDataSyncAgentTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDATASYNCAGENTTYPEID, 5);
        fieldIndexMap.put(FIELD_PSDATASYNCAGENTTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

