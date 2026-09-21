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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeModel;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlModelBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATATYPE = "DATATYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLMODELID = "PSCTRLMODELID";
    public static final String FIELD_PSCTRLMODELNAME = "PSCTRLMODELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DATATYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSCTRLMODELID = 5;
    private static final int INDEX_PSCTRLMODELNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlModelBase proxyPSCtrlModelBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datatypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrlmodelidDirtyFlag = false;
    private boolean psctrlmodelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datatype")
    private String datatype;
    @Column(name="memo")
    private String memo;
    @Column(name="psctrlmodelid")
    private String psctrlmodelid;
    @Column(name="psctrlmodelname")
    private String psctrlmodelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCtrlTypeModelsLock = new Integer(1);
    private ArrayList<PSCtrlTypeModel> psctrltypemodels = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatype = string;
        this.datatypeDirtyFlag = true;
    }

    public String getDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataType();
        }
        return this.datatype;
    }

    public boolean isDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypeDirty();
        }
        return this.datatypeDirtyFlag;
    }

    public void resetDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataType();
            return;
        }
        this.datatypeDirtyFlag = false;
        this.datatype = null;
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

    public void setPSCtrlModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmodelid = string;
        this.psctrlmodelidDirtyFlag = true;
    }

    public String getPSCtrlModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlModelId();
        }
        return this.psctrlmodelid;
    }

    public boolean isPSCtrlModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlModelIdDirty();
        }
        return this.psctrlmodelidDirtyFlag;
    }

    public void resetPSCtrlModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlModelId();
            return;
        }
        this.psctrlmodelidDirtyFlag = false;
        this.psctrlmodelid = null;
    }

    public void setPSCtrlModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmodelname = string;
        this.psctrlmodelnameDirtyFlag = true;
    }

    public String getPSCtrlModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlModelName();
        }
        return this.psctrlmodelname;
    }

    public boolean isPSCtrlModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlModelNameDirty();
        }
        return this.psctrlmodelnameDirtyFlag;
    }

    public void resetPSCtrlModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlModelName();
            return;
        }
        this.psctrlmodelnameDirtyFlag = false;
        this.psctrlmodelname = null;
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
        PSCtrlModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlModelBase pSCtrlModelBase) {
        pSCtrlModelBase.resetCodeName();
        pSCtrlModelBase.resetCreateDate();
        pSCtrlModelBase.resetCreateMan();
        pSCtrlModelBase.resetDataType();
        pSCtrlModelBase.resetMemo();
        pSCtrlModelBase.resetPSCtrlModelId();
        pSCtrlModelBase.resetPSCtrlModelName();
        pSCtrlModelBase.resetUpdateDate();
        pSCtrlModelBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataTypeDirty()) {
            hashMap.put(FIELD_DATATYPE, this.getDataType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlModelIdDirty()) {
            hashMap.put(FIELD_PSCTRLMODELID, this.getPSCtrlModelId());
        }
        if (!bl || this.isPSCtrlModelNameDirty()) {
            hashMap.put(FIELD_PSCTRLMODELNAME, this.getPSCtrlModelName());
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
        return PSCtrlModelBase.get(this, n);
    }

    private static Object get(PSCtrlModelBase pSCtrlModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlModelBase.getCodeName();
            }
            case 1: {
                return pSCtrlModelBase.getCreateDate();
            }
            case 2: {
                return pSCtrlModelBase.getCreateMan();
            }
            case 3: {
                return pSCtrlModelBase.getDataType();
            }
            case 4: {
                return pSCtrlModelBase.getMemo();
            }
            case 5: {
                return pSCtrlModelBase.getPSCtrlModelId();
            }
            case 6: {
                return pSCtrlModelBase.getPSCtrlModelName();
            }
            case 7: {
                return pSCtrlModelBase.getUpdateDate();
            }
            case 8: {
                return pSCtrlModelBase.getUpdateMan();
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
        PSCtrlModelBase.set(this, n, object);
    }

    private static void set(PSCtrlModelBase pSCtrlModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlModelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlModelBase.setDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlModelBase.setPSCtrlModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlModelBase.setPSCtrlModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCtrlModelBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlModelBase pSCtrlModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlModelBase.getCodeName() == null;
            }
            case 1: {
                return pSCtrlModelBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlModelBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlModelBase.getDataType() == null;
            }
            case 4: {
                return pSCtrlModelBase.getMemo() == null;
            }
            case 5: {
                return pSCtrlModelBase.getPSCtrlModelId() == null;
            }
            case 6: {
                return pSCtrlModelBase.getPSCtrlModelName() == null;
            }
            case 7: {
                return pSCtrlModelBase.getUpdateDate() == null;
            }
            case 8: {
                return pSCtrlModelBase.getUpdateMan() == null;
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
        return PSCtrlModelBase.contains(this, n);
    }

    private static boolean contains(PSCtrlModelBase pSCtrlModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlModelBase.isCodeNameDirty();
            }
            case 1: {
                return pSCtrlModelBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlModelBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlModelBase.isDataTypeDirty();
            }
            case 4: {
                return pSCtrlModelBase.isMemoDirty();
            }
            case 5: {
                return pSCtrlModelBase.isPSCtrlModelIdDirty();
            }
            case 6: {
                return pSCtrlModelBase.isPSCtrlModelNameDirty();
            }
            case 7: {
                return pSCtrlModelBase.isUpdateDateDirty();
            }
            case 8: {
                return pSCtrlModelBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlModelBase pSCtrlModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlModelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatype", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getDataType()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getPSCtrlModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmodelid", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getPSCtrlModelId()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getPSCtrlModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmodelname", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getPSCtrlModelName()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlModelBase.getJSONValue((Object)pSCtrlModelBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlModelBase pSCtrlModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlModelBase.getCodeName() != null) {
            object = pSCtrlModelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlModelBase.getCreateDate() != null) {
            object = pSCtrlModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlModelBase.getCreateMan() != null) {
            object = pSCtrlModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlModelBase.getDataType() != null) {
            object = pSCtrlModelBase.getDataType();
            xmlNode.setAttribute(FIELD_DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlModelBase.getMemo() != null) {
            object = pSCtrlModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlModelBase.getPSCtrlModelId() != null) {
            object = pSCtrlModelBase.getPSCtrlModelId();
            xmlNode.setAttribute(FIELD_PSCTRLMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlModelBase.getPSCtrlModelName() != null) {
            object = pSCtrlModelBase.getPSCtrlModelName();
            xmlNode.setAttribute(FIELD_PSCTRLMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlModelBase.getUpdateDate() != null) {
            object = pSCtrlModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlModelBase.getUpdateMan() != null) {
            object = pSCtrlModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlModelBase pSCtrlModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlModelBase.isCodeNameDirty() && (bl || pSCtrlModelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCtrlModelBase.getCodeName());
        }
        if (pSCtrlModelBase.isCreateDateDirty() && (bl || pSCtrlModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlModelBase.getCreateDate());
        }
        if (pSCtrlModelBase.isCreateManDirty() && (bl || pSCtrlModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlModelBase.getCreateMan());
        }
        if (pSCtrlModelBase.isDataTypeDirty() && (bl || pSCtrlModelBase.getDataType() != null)) {
            iDataObject.set(FIELD_DATATYPE, (Object)pSCtrlModelBase.getDataType());
        }
        if (pSCtrlModelBase.isMemoDirty() && (bl || pSCtrlModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlModelBase.getMemo());
        }
        if (pSCtrlModelBase.isPSCtrlModelIdDirty() && (bl || pSCtrlModelBase.getPSCtrlModelId() != null)) {
            iDataObject.set(FIELD_PSCTRLMODELID, (Object)pSCtrlModelBase.getPSCtrlModelId());
        }
        if (pSCtrlModelBase.isPSCtrlModelNameDirty() && (bl || pSCtrlModelBase.getPSCtrlModelName() != null)) {
            iDataObject.set(FIELD_PSCTRLMODELNAME, (Object)pSCtrlModelBase.getPSCtrlModelName());
        }
        if (pSCtrlModelBase.isUpdateDateDirty() && (bl || pSCtrlModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlModelBase.getUpdateDate());
        }
        if (pSCtrlModelBase.isUpdateManDirty() && (bl || pSCtrlModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlModelBase.getUpdateMan());
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
        return PSCtrlModelBase.remove(this, n);
    }

    private static boolean remove(PSCtrlModelBase pSCtrlModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlModelBase.resetCodeName();
                return true;
            }
            case 1: {
                pSCtrlModelBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlModelBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlModelBase.resetDataType();
                return true;
            }
            case 4: {
                pSCtrlModelBase.resetMemo();
                return true;
            }
            case 5: {
                pSCtrlModelBase.resetPSCtrlModelId();
                return true;
            }
            case 6: {
                pSCtrlModelBase.resetPSCtrlModelName();
                return true;
            }
            case 7: {
                pSCtrlModelBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSCtrlModelBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlTypeModel> getPSCtrlTypeModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeModels();
        }
        if (this.getPSCtrlModelId() == null) {
            return null;
        }
        PSCtrlTypeModelService pSCtrlTypeModelService = (PSCtrlTypeModelService)ServiceGlobal.getService(PSCtrlTypeModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlTypeModelsLock;
        synchronized (n) {
            if (this.psctrltypemodels == null) {
                this.psctrltypemodels = pSCtrlTypeModelService.selectByPSCtrlModel(this);
            }
            return this.psctrltypemodels;
        }
    }

    private PSCtrlModelBase getProxyEntity() {
        return this.proxyPSCtrlModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlModelBase) {
            this.proxyPSCtrlModelBase = (PSCtrlModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DATATYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSCTRLMODELID, 5);
        fieldIndexMap.put(FIELD_PSCTRLMODELNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

