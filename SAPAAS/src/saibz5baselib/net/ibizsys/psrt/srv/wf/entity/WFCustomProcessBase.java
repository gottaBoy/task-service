/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

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

public abstract class WFCustomProcessBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFCustomProcessBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCESSOBJECT = "PROCESSOBJECT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VERSION = "VERSION";
    public static final String FIELD_WFCUSTOMPROCESSID = "WFCUSTOMPROCESSID";
    public static final String FIELD_WFCUSTOMPROCESSNAME = "WFCUSTOMPROCESSNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PROCESSOBJECT = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final int INDEX_VERSION = 6;
    private static final int INDEX_WFCUSTOMPROCESSID = 7;
    private static final int INDEX_WFCUSTOMPROCESSNAME = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFCustomProcessBase proxyWFCustomProcessBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processobjectDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    private boolean wfcustomprocessidDirtyFlag = false;
    private boolean wfcustomprocessnameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="processobject")
    private String processobject;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="version")
    private String version;
    @Column(name="wfcustomprocessid")
    private String wfcustomprocessid;
    @Column(name="wfcustomprocessname")
    private String wfcustomprocessname;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PROCESSOBJECT, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
        fieldIndexMap.put(FIELD_VERSION, 6);
        fieldIndexMap.put(FIELD_WFCUSTOMPROCESSID, 7);
        fieldIndexMap.put(FIELD_WFCUSTOMPROCESSNAME, 8);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setProcessObject(String processobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessObject(processobject);
            return;
        }
        if (processobject != null && (processobject = StringHelper.trimRight(processobject)).length() == 0) {
            processobject = null;
        }
        this.processobject = processobject;
        this.processobjectDirtyFlag = true;
    }

    public String getProcessObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessObject();
        }
        return this.processobject;
    }

    public boolean isProcessObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessObjectDirty();
        }
        return this.processobjectDirtyFlag;
    }

    public void resetProcessObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessObject();
            return;
        }
        this.processobjectDirtyFlag = false;
        this.processobject = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setVersion(String version) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(version);
            return;
        }
        if (version != null && (version = StringHelper.trimRight(version)).length() == 0) {
            version = null;
        }
        this.version = version;
        this.versionDirtyFlag = true;
    }

    public String getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    public void setWFCustomProcessId(String wfcustomprocessid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFCustomProcessId(wfcustomprocessid);
            return;
        }
        if (wfcustomprocessid != null && (wfcustomprocessid = StringHelper.trimRight(wfcustomprocessid)).length() == 0) {
            wfcustomprocessid = null;
        }
        this.wfcustomprocessid = wfcustomprocessid;
        this.wfcustomprocessidDirtyFlag = true;
    }

    public String getWFCustomProcessId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFCustomProcessId();
        }
        return this.wfcustomprocessid;
    }

    public boolean isWFCustomProcessIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFCustomProcessIdDirty();
        }
        return this.wfcustomprocessidDirtyFlag;
    }

    public void resetWFCustomProcessId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFCustomProcessId();
            return;
        }
        this.wfcustomprocessidDirtyFlag = false;
        this.wfcustomprocessid = null;
    }

    public void setWFCustomProcessName(String wfcustomprocessname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFCustomProcessName(wfcustomprocessname);
            return;
        }
        if (wfcustomprocessname != null && (wfcustomprocessname = StringHelper.trimRight(wfcustomprocessname)).length() == 0) {
            wfcustomprocessname = null;
        }
        this.wfcustomprocessname = wfcustomprocessname;
        this.wfcustomprocessnameDirtyFlag = true;
    }

    public String getWFCustomProcessName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFCustomProcessName();
        }
        return this.wfcustomprocessname;
    }

    public boolean isWFCustomProcessNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFCustomProcessNameDirty();
        }
        return this.wfcustomprocessnameDirtyFlag;
    }

    public void resetWFCustomProcessName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFCustomProcessName();
            return;
        }
        this.wfcustomprocessnameDirtyFlag = false;
        this.wfcustomprocessname = null;
    }

    @Override
    protected void onReset() {
        WFCustomProcessBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFCustomProcessBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetProcessObject();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetVersion();
        et.resetWFCustomProcessId();
        et.resetWFCustomProcessName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isProcessObjectDirty()) {
            params.put(FIELD_PROCESSOBJECT, this.getProcessObject());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isVersionDirty()) {
            params.put(FIELD_VERSION, this.getVersion());
        }
        if (!bDirtyOnly || this.isWFCustomProcessIdDirty()) {
            params.put(FIELD_WFCUSTOMPROCESSID, this.getWFCustomProcessId());
        }
        if (!bDirtyOnly || this.isWFCustomProcessNameDirty()) {
            params.put(FIELD_WFCUSTOMPROCESSNAME, this.getWFCustomProcessName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return WFCustomProcessBase.get(this, index);
    }

    private static Object get(WFCustomProcessBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getMemo();
            }
            case 3: {
                return et.getProcessObject();
            }
            case 4: {
                return et.getUpdateDate();
            }
            case 5: {
                return et.getUpdateMan();
            }
            case 6: {
                return et.getVersion();
            }
            case 7: {
                return et.getWFCustomProcessId();
            }
            case 8: {
                return et.getWFCustomProcessName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        WFCustomProcessBase.set(this, index, objValue);
    }

    private static void set(WFCustomProcessBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setProcessObject(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 5: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setVersion(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFCustomProcessId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFCustomProcessName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return WFCustomProcessBase.isNull(this, index);
    }

    private static boolean isNull(WFCustomProcessBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getMemo() == null;
            }
            case 3: {
                return et.getProcessObject() == null;
            }
            case 4: {
                return et.getUpdateDate() == null;
            }
            case 5: {
                return et.getUpdateMan() == null;
            }
            case 6: {
                return et.getVersion() == null;
            }
            case 7: {
                return et.getWFCustomProcessId() == null;
            }
            case 8: {
                return et.getWFCustomProcessName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return WFCustomProcessBase.contains(this, index);
    }

    private static boolean contains(WFCustomProcessBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isMemoDirty();
            }
            case 3: {
                return et.isProcessObjectDirty();
            }
            case 4: {
                return et.isUpdateDateDirty();
            }
            case 5: {
                return et.isUpdateManDirty();
            }
            case 6: {
                return et.isVersionDirty();
            }
            case 7: {
                return et.isWFCustomProcessIdDirty();
            }
            case 8: {
                return et.isWFCustomProcessNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFCustomProcessBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFCustomProcessBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFCustomProcessBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFCustomProcessBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFCustomProcessBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getProcessObject() != null) {
            JSONObjectHelper.put(json, "processobject", WFCustomProcessBase.getJSONValue(et.getProcessObject()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFCustomProcessBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFCustomProcessBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getVersion() != null) {
            JSONObjectHelper.put(json, "version", WFCustomProcessBase.getJSONValue(et.getVersion()), false);
        }
        if (bIncEmpty || et.getWFCustomProcessId() != null) {
            JSONObjectHelper.put(json, "wfcustomprocessid", WFCustomProcessBase.getJSONValue(et.getWFCustomProcessId()), false);
        }
        if (bIncEmpty || et.getWFCustomProcessName() != null) {
            JSONObjectHelper.put(json, "wfcustomprocessname", WFCustomProcessBase.getJSONValue(et.getWFCustomProcessName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFCustomProcessBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFCustomProcessBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getProcessObject() != null) {
            obj = et.getProcessObject();
            node.setAttribute(FIELD_PROCESSOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getVersion() != null) {
            obj = et.getVersion();
            node.setAttribute(FIELD_VERSION, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFCustomProcessId() != null) {
            obj = et.getWFCustomProcessId();
            node.setAttribute(FIELD_WFCUSTOMPROCESSID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFCustomProcessName() != null) {
            obj = et.getWFCustomProcessName();
            node.setAttribute(FIELD_WFCUSTOMPROCESSNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFCustomProcessBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFCustomProcessBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isProcessObjectDirty() && (bIncEmpty || et.getProcessObject() != null)) {
            dst.set(FIELD_PROCESSOBJECT, et.getProcessObject());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isVersionDirty() && (bIncEmpty || et.getVersion() != null)) {
            dst.set(FIELD_VERSION, et.getVersion());
        }
        if (et.isWFCustomProcessIdDirty() && (bIncEmpty || et.getWFCustomProcessId() != null)) {
            dst.set(FIELD_WFCUSTOMPROCESSID, et.getWFCustomProcessId());
        }
        if (et.isWFCustomProcessNameDirty() && (bIncEmpty || et.getWFCustomProcessName() != null)) {
            dst.set(FIELD_WFCUSTOMPROCESSNAME, et.getWFCustomProcessName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return WFCustomProcessBase.remove(this, index);
    }

    private static boolean remove(WFCustomProcessBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetMemo();
                return true;
            }
            case 3: {
                et.resetProcessObject();
                return true;
            }
            case 4: {
                et.resetUpdateDate();
                return true;
            }
            case 5: {
                et.resetUpdateMan();
                return true;
            }
            case 6: {
                et.resetVersion();
                return true;
            }
            case 7: {
                et.resetWFCustomProcessId();
                return true;
            }
            case 8: {
                et.resetWFCustomProcessName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private WFCustomProcessBase getProxyEntity() {
        return this.proxyWFCustomProcessBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFCustomProcessBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFCustomProcessBase) {
            this.proxyWFCustomProcessBase = (WFCustomProcessBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFCustomProcessService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

