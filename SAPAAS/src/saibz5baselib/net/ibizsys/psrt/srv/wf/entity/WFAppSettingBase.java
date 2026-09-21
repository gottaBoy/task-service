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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFAppSettingBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFAppSettingBase.class);
    public static final String FIELD_APPLICATIONID = "APPLICATIONID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_REMINDMSGTEMPLID = "REMINDMSGTEMPID";
    public static final String FIELD_REMINDMSGTEMPLNAME = "REMINDMSGTEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFAPPSETTINGID = "WFAPPSETTINGID";
    public static final String FIELD_WFAPPSETTINGNAME = "WFAPPSETTINGNAME";
    private static final int INDEX_APPLICATIONID = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_REMINDMSGTEMPLID = 4;
    private static final int INDEX_REMINDMSGTEMPLNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_WFAPPSETTINGID = 8;
    private static final int INDEX_WFAPPSETTINGNAME = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFAppSettingBase proxyWFAppSettingBase = null;
    private boolean applicationidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean remindmsgtemplidDirtyFlag = false;
    private boolean remindmsgtemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfappsettingidDirtyFlag = false;
    private boolean wfappsettingnameDirtyFlag = false;
    @Column(name="applicationid")
    private String applicationid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="remindmsgtemplid")
    private String remindmsgtemplid;
    @Column(name="remindmsgtemplname")
    private String remindmsgtemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfappsettingid")
    private String wfappsettingid;
    @Column(name="wfappsettingname")
    private String wfappsettingname;
    private Integer objRemindMsgTemplLock = new Integer(1);
    private MsgTemplate remindmsgtempl = null;

    static {
        fieldIndexMap.put(FIELD_APPLICATIONID, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_REMINDMSGTEMPLID, 4);
        fieldIndexMap.put(FIELD_REMINDMSGTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_WFAPPSETTINGID, 8);
        fieldIndexMap.put(FIELD_WFAPPSETTINGNAME, 9);
    }

    public void setApplicationId(String applicationid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setApplicationId(applicationid);
            return;
        }
        if (applicationid != null && (applicationid = StringHelper.trimRight(applicationid)).length() == 0) {
            applicationid = null;
        }
        this.applicationid = applicationid;
        this.applicationidDirtyFlag = true;
    }

    public String getApplicationId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getApplicationId();
        }
        return this.applicationid;
    }

    public boolean isApplicationIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isApplicationIdDirty();
        }
        return this.applicationidDirtyFlag;
    }

    public void resetApplicationId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetApplicationId();
            return;
        }
        this.applicationidDirtyFlag = false;
        this.applicationid = null;
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

    public void setRemindMsgTemplId(String remindmsgtemplid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemindMsgTemplId(remindmsgtemplid);
            return;
        }
        if (remindmsgtemplid != null && (remindmsgtemplid = StringHelper.trimRight(remindmsgtemplid)).length() == 0) {
            remindmsgtemplid = null;
        }
        this.remindmsgtemplid = remindmsgtemplid;
        this.remindmsgtemplidDirtyFlag = true;
    }

    public String getRemindMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindMsgTemplId();
        }
        return this.remindmsgtemplid;
    }

    public boolean isRemindMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemindMsgTemplIdDirty();
        }
        return this.remindmsgtemplidDirtyFlag;
    }

    public void resetRemindMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemindMsgTemplId();
            return;
        }
        this.remindmsgtemplidDirtyFlag = false;
        this.remindmsgtemplid = null;
    }

    public void setRemindMsgTemplName(String remindmsgtemplname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemindMsgTemplName(remindmsgtemplname);
            return;
        }
        if (remindmsgtemplname != null && (remindmsgtemplname = StringHelper.trimRight(remindmsgtemplname)).length() == 0) {
            remindmsgtemplname = null;
        }
        this.remindmsgtemplname = remindmsgtemplname;
        this.remindmsgtemplnameDirtyFlag = true;
    }

    public String getRemindMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindMsgTemplName();
        }
        return this.remindmsgtemplname;
    }

    public boolean isRemindMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemindMsgTemplNameDirty();
        }
        return this.remindmsgtemplnameDirtyFlag;
    }

    public void resetRemindMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemindMsgTemplName();
            return;
        }
        this.remindmsgtemplnameDirtyFlag = false;
        this.remindmsgtemplname = null;
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

    public void setWFAppSettingId(String wfappsettingid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFAppSettingId(wfappsettingid);
            return;
        }
        if (wfappsettingid != null && (wfappsettingid = StringHelper.trimRight(wfappsettingid)).length() == 0) {
            wfappsettingid = null;
        }
        this.wfappsettingid = wfappsettingid;
        this.wfappsettingidDirtyFlag = true;
    }

    public String getWFAppSettingId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFAppSettingId();
        }
        return this.wfappsettingid;
    }

    public boolean isWFAppSettingIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFAppSettingIdDirty();
        }
        return this.wfappsettingidDirtyFlag;
    }

    public void resetWFAppSettingId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFAppSettingId();
            return;
        }
        this.wfappsettingidDirtyFlag = false;
        this.wfappsettingid = null;
    }

    public void setWFAppSettingName(String wfappsettingname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFAppSettingName(wfappsettingname);
            return;
        }
        if (wfappsettingname != null && (wfappsettingname = StringHelper.trimRight(wfappsettingname)).length() == 0) {
            wfappsettingname = null;
        }
        this.wfappsettingname = wfappsettingname;
        this.wfappsettingnameDirtyFlag = true;
    }

    public String getWFAppSettingName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFAppSettingName();
        }
        return this.wfappsettingname;
    }

    public boolean isWFAppSettingNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFAppSettingNameDirty();
        }
        return this.wfappsettingnameDirtyFlag;
    }

    public void resetWFAppSettingName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFAppSettingName();
            return;
        }
        this.wfappsettingnameDirtyFlag = false;
        this.wfappsettingname = null;
    }

    @Override
    protected void onReset() {
        WFAppSettingBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFAppSettingBase et) {
        et.resetApplicationId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetRemindMsgTemplId();
        et.resetRemindMsgTemplName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFAppSettingId();
        et.resetWFAppSettingName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isApplicationIdDirty()) {
            params.put(FIELD_APPLICATIONID, this.getApplicationId());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isRemindMsgTemplIdDirty()) {
            params.put(FIELD_REMINDMSGTEMPLID, this.getRemindMsgTemplId());
        }
        if (!bDirtyOnly || this.isRemindMsgTemplNameDirty()) {
            params.put(FIELD_REMINDMSGTEMPLNAME, this.getRemindMsgTemplName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFAppSettingIdDirty()) {
            params.put(FIELD_WFAPPSETTINGID, this.getWFAppSettingId());
        }
        if (!bDirtyOnly || this.isWFAppSettingNameDirty()) {
            params.put(FIELD_WFAPPSETTINGNAME, this.getWFAppSettingName());
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
        return WFAppSettingBase.get(this, index);
    }

    private static Object get(WFAppSettingBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getApplicationId();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getRemindMsgTemplId();
            }
            case 5: {
                return et.getRemindMsgTemplName();
            }
            case 6: {
                return et.getUpdateDate();
            }
            case 7: {
                return et.getUpdateMan();
            }
            case 8: {
                return et.getWFAppSettingId();
            }
            case 9: {
                return et.getWFAppSettingName();
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
        WFAppSettingBase.set(this, index, objValue);
    }

    private static void set(WFAppSettingBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setApplicationId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setRemindMsgTemplId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setRemindMsgTemplName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 7: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFAppSettingId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFAppSettingName(DataObject.getStringValue(obj));
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
        return WFAppSettingBase.isNull(this, index);
    }

    private static boolean isNull(WFAppSettingBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getApplicationId() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getRemindMsgTemplId() == null;
            }
            case 5: {
                return et.getRemindMsgTemplName() == null;
            }
            case 6: {
                return et.getUpdateDate() == null;
            }
            case 7: {
                return et.getUpdateMan() == null;
            }
            case 8: {
                return et.getWFAppSettingId() == null;
            }
            case 9: {
                return et.getWFAppSettingName() == null;
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
        return WFAppSettingBase.contains(this, index);
    }

    private static boolean contains(WFAppSettingBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isApplicationIdDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isRemindMsgTemplIdDirty();
            }
            case 5: {
                return et.isRemindMsgTemplNameDirty();
            }
            case 6: {
                return et.isUpdateDateDirty();
            }
            case 7: {
                return et.isUpdateManDirty();
            }
            case 8: {
                return et.isWFAppSettingIdDirty();
            }
            case 9: {
                return et.isWFAppSettingNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFAppSettingBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFAppSettingBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getApplicationId() != null) {
            JSONObjectHelper.put(json, "applicationid", WFAppSettingBase.getJSONValue(et.getApplicationId()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFAppSettingBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFAppSettingBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFAppSettingBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getRemindMsgTemplId() != null) {
            JSONObjectHelper.put(json, "remindmsgtempid", WFAppSettingBase.getJSONValue(et.getRemindMsgTemplId()), false);
        }
        if (bIncEmpty || et.getRemindMsgTemplName() != null) {
            JSONObjectHelper.put(json, "remindmsgtemplname", WFAppSettingBase.getJSONValue(et.getRemindMsgTemplName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFAppSettingBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFAppSettingBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFAppSettingId() != null) {
            JSONObjectHelper.put(json, "wfappsettingid", WFAppSettingBase.getJSONValue(et.getWFAppSettingId()), false);
        }
        if (bIncEmpty || et.getWFAppSettingName() != null) {
            JSONObjectHelper.put(json, "wfappsettingname", WFAppSettingBase.getJSONValue(et.getWFAppSettingName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFAppSettingBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFAppSettingBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getApplicationId() != null) {
            obj = et.getApplicationId();
            node.setAttribute(FIELD_APPLICATIONID, obj == null ? "" : (String)obj);
        }
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
        if (bIncEmpty || et.getRemindMsgTemplId() != null) {
            obj = et.getRemindMsgTemplId();
            node.setAttribute("REMINDMSGTEMPLID", obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRemindMsgTemplName() != null) {
            obj = et.getRemindMsgTemplName();
            node.setAttribute(FIELD_REMINDMSGTEMPLNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFAppSettingId() != null) {
            obj = et.getWFAppSettingId();
            node.setAttribute(FIELD_WFAPPSETTINGID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFAppSettingName() != null) {
            obj = et.getWFAppSettingName();
            node.setAttribute(FIELD_WFAPPSETTINGNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFAppSettingBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFAppSettingBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isApplicationIdDirty() && (bIncEmpty || et.getApplicationId() != null)) {
            dst.set(FIELD_APPLICATIONID, et.getApplicationId());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isRemindMsgTemplIdDirty() && (bIncEmpty || et.getRemindMsgTemplId() != null)) {
            dst.set(FIELD_REMINDMSGTEMPLID, et.getRemindMsgTemplId());
        }
        if (et.isRemindMsgTemplNameDirty() && (bIncEmpty || et.getRemindMsgTemplName() != null)) {
            dst.set(FIELD_REMINDMSGTEMPLNAME, et.getRemindMsgTemplName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFAppSettingIdDirty() && (bIncEmpty || et.getWFAppSettingId() != null)) {
            dst.set(FIELD_WFAPPSETTINGID, et.getWFAppSettingId());
        }
        if (et.isWFAppSettingNameDirty() && (bIncEmpty || et.getWFAppSettingName() != null)) {
            dst.set(FIELD_WFAPPSETTINGNAME, et.getWFAppSettingName());
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
        return WFAppSettingBase.remove(this, index);
    }

    private static boolean remove(WFAppSettingBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetApplicationId();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetRemindMsgTemplId();
                return true;
            }
            case 5: {
                et.resetRemindMsgTemplName();
                return true;
            }
            case 6: {
                et.resetUpdateDate();
                return true;
            }
            case 7: {
                et.resetUpdateMan();
                return true;
            }
            case 8: {
                et.resetWFAppSettingId();
                return true;
            }
            case 9: {
                et.resetWFAppSettingName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MsgTemplate getRemindMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemindMsgTempl();
        }
        if (this.getRemindMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objRemindMsgTemplLock;
        synchronized (n) {
            if (this.remindmsgtempl != null && DataTypeHelper.compare(25, (Object)this.getRemindMsgTemplId(), (Object)this.remindmsgtempl.getMsgTemplateId()) != 0L) {
                this.remindmsgtempl = null;
            }
            if (this.remindmsgtempl == null) {
                MsgTemplate remindmsgtempl = new MsgTemplate();
                remindmsgtempl.setMsgTemplateId(this.getRemindMsgTemplId());
                MsgTemplateService service = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class, this.getSessionFactory());
                service.autoGet(remindmsgtempl);
                this.remindmsgtempl = remindmsgtempl;
            }
            return this.remindmsgtempl;
        }
    }

    private WFAppSettingBase getProxyEntity() {
        return this.proxyWFAppSettingBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFAppSettingBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFAppSettingBase) {
            this.proxyWFAppSettingBase = (WFAppSettingBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFAppSettingService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

