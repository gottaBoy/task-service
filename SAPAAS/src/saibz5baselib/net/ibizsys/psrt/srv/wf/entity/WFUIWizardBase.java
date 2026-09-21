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

public abstract class WFUIWizardBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUIWizardBase.class);
    public static final String FIELD_ACTIONMODE = "ACTIONMODE";
    public static final String FIELD_ACTIONPARAM = "ACTIONPARAM";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATAINFO = "DATAINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFSTEPVALUE = "WFSTEPVALUE";
    public static final String FIELD_WFUIWIZARDID = "WFUIWIZARDID";
    public static final String FIELD_WFUIWIZARDNAME = "WFUIWIZARDNAME";
    private static final int INDEX_ACTIONMODE = 0;
    private static final int INDEX_ACTIONPARAM = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DATAINFO = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_WFSTEPVALUE = 7;
    private static final int INDEX_WFUIWIZARDID = 8;
    private static final int INDEX_WFUIWIZARDNAME = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFUIWizardBase proxyWFUIWizardBase = null;
    private boolean actionmodeDirtyFlag = false;
    private boolean actionparamDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datainfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfstepvalueDirtyFlag = false;
    private boolean wfuiwizardidDirtyFlag = false;
    private boolean wfuiwizardnameDirtyFlag = false;
    @Column(name="actionmode")
    private String actionmode;
    @Column(name="actionparam")
    private String actionparam;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datainfo")
    private String datainfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfstepvalue")
    private String wfstepvalue;
    @Column(name="wfuiwizardid")
    private String wfuiwizardid;
    @Column(name="wfuiwizardname")
    private String wfuiwizardname;

    static {
        fieldIndexMap.put(FIELD_ACTIONMODE, 0);
        fieldIndexMap.put(FIELD_ACTIONPARAM, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DATAINFO, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_WFSTEPVALUE, 7);
        fieldIndexMap.put(FIELD_WFUIWIZARDID, 8);
        fieldIndexMap.put(FIELD_WFUIWIZARDNAME, 9);
    }

    public void setActionMode(String actionmode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionMode(actionmode);
            return;
        }
        if (actionmode != null && (actionmode = StringHelper.trimRight(actionmode)).length() == 0) {
            actionmode = null;
        }
        this.actionmode = actionmode;
        this.actionmodeDirtyFlag = true;
    }

    public String getActionMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionMode();
        }
        return this.actionmode;
    }

    public boolean isActionModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionModeDirty();
        }
        return this.actionmodeDirtyFlag;
    }

    public void resetActionMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionMode();
            return;
        }
        this.actionmodeDirtyFlag = false;
        this.actionmode = null;
    }

    public void setActionParam(String actionparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParam(actionparam);
            return;
        }
        if (actionparam != null && (actionparam = StringHelper.trimRight(actionparam)).length() == 0) {
            actionparam = null;
        }
        this.actionparam = actionparam;
        this.actionparamDirtyFlag = true;
    }

    public String getActionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParam();
        }
        return this.actionparam;
    }

    public boolean isActionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamDirty();
        }
        return this.actionparamDirtyFlag;
    }

    public void resetActionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParam();
            return;
        }
        this.actionparamDirtyFlag = false;
        this.actionparam = null;
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

    public void setDataInfo(String datainfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataInfo(datainfo);
            return;
        }
        if (datainfo != null && (datainfo = StringHelper.trimRight(datainfo)).length() == 0) {
            datainfo = null;
        }
        this.datainfo = datainfo;
        this.datainfoDirtyFlag = true;
    }

    public String getDataInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataInfo();
        }
        return this.datainfo;
    }

    public boolean isDataInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataInfoDirty();
        }
        return this.datainfoDirtyFlag;
    }

    public void resetDataInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataInfo();
            return;
        }
        this.datainfoDirtyFlag = false;
        this.datainfo = null;
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

    public void setWFStepValue(String wfstepvalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepValue(wfstepvalue);
            return;
        }
        if (wfstepvalue != null && (wfstepvalue = StringHelper.trimRight(wfstepvalue)).length() == 0) {
            wfstepvalue = null;
        }
        this.wfstepvalue = wfstepvalue;
        this.wfstepvalueDirtyFlag = true;
    }

    public String getWFStepValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepValue();
        }
        return this.wfstepvalue;
    }

    public boolean isWFStepValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepValueDirty();
        }
        return this.wfstepvalueDirtyFlag;
    }

    public void resetWFStepValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepValue();
            return;
        }
        this.wfstepvalueDirtyFlag = false;
        this.wfstepvalue = null;
    }

    public void setWFUIWizardId(String wfuiwizardid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUIWizardId(wfuiwizardid);
            return;
        }
        if (wfuiwizardid != null && (wfuiwizardid = StringHelper.trimRight(wfuiwizardid)).length() == 0) {
            wfuiwizardid = null;
        }
        this.wfuiwizardid = wfuiwizardid;
        this.wfuiwizardidDirtyFlag = true;
    }

    public String getWFUIWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUIWizardId();
        }
        return this.wfuiwizardid;
    }

    public boolean isWFUIWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUIWizardIdDirty();
        }
        return this.wfuiwizardidDirtyFlag;
    }

    public void resetWFUIWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUIWizardId();
            return;
        }
        this.wfuiwizardidDirtyFlag = false;
        this.wfuiwizardid = null;
    }

    public void setWFUIWizardName(String wfuiwizardname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUIWizardName(wfuiwizardname);
            return;
        }
        if (wfuiwizardname != null && (wfuiwizardname = StringHelper.trimRight(wfuiwizardname)).length() == 0) {
            wfuiwizardname = null;
        }
        this.wfuiwizardname = wfuiwizardname;
        this.wfuiwizardnameDirtyFlag = true;
    }

    public String getWFUIWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUIWizardName();
        }
        return this.wfuiwizardname;
    }

    public boolean isWFUIWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUIWizardNameDirty();
        }
        return this.wfuiwizardnameDirtyFlag;
    }

    public void resetWFUIWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUIWizardName();
            return;
        }
        this.wfuiwizardnameDirtyFlag = false;
        this.wfuiwizardname = null;
    }

    @Override
    protected void onReset() {
        WFUIWizardBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFUIWizardBase et) {
        et.resetActionMode();
        et.resetActionParam();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataInfo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFStepValue();
        et.resetWFUIWizardId();
        et.resetWFUIWizardName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActionModeDirty()) {
            params.put(FIELD_ACTIONMODE, this.getActionMode());
        }
        if (!bDirtyOnly || this.isActionParamDirty()) {
            params.put(FIELD_ACTIONPARAM, this.getActionParam());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDataInfoDirty()) {
            params.put(FIELD_DATAINFO, this.getDataInfo());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFStepValueDirty()) {
            params.put(FIELD_WFSTEPVALUE, this.getWFStepValue());
        }
        if (!bDirtyOnly || this.isWFUIWizardIdDirty()) {
            params.put(FIELD_WFUIWIZARDID, this.getWFUIWizardId());
        }
        if (!bDirtyOnly || this.isWFUIWizardNameDirty()) {
            params.put(FIELD_WFUIWIZARDNAME, this.getWFUIWizardName());
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
        return WFUIWizardBase.get(this, index);
    }

    private static Object get(WFUIWizardBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionMode();
            }
            case 1: {
                return et.getActionParam();
            }
            case 2: {
                return et.getCreateDate();
            }
            case 3: {
                return et.getCreateMan();
            }
            case 4: {
                return et.getDataInfo();
            }
            case 5: {
                return et.getUpdateDate();
            }
            case 6: {
                return et.getUpdateMan();
            }
            case 7: {
                return et.getWFStepValue();
            }
            case 8: {
                return et.getWFUIWizardId();
            }
            case 9: {
                return et.getWFUIWizardName();
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
        WFUIWizardBase.set(this, index, objValue);
    }

    private static void set(WFUIWizardBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActionMode(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setActionParam(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDataInfo(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 6: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFStepValue(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFUIWizardId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFUIWizardName(DataObject.getStringValue(obj));
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
        return WFUIWizardBase.isNull(this, index);
    }

    private static boolean isNull(WFUIWizardBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionMode() == null;
            }
            case 1: {
                return et.getActionParam() == null;
            }
            case 2: {
                return et.getCreateDate() == null;
            }
            case 3: {
                return et.getCreateMan() == null;
            }
            case 4: {
                return et.getDataInfo() == null;
            }
            case 5: {
                return et.getUpdateDate() == null;
            }
            case 6: {
                return et.getUpdateMan() == null;
            }
            case 7: {
                return et.getWFStepValue() == null;
            }
            case 8: {
                return et.getWFUIWizardId() == null;
            }
            case 9: {
                return et.getWFUIWizardName() == null;
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
        return WFUIWizardBase.contains(this, index);
    }

    private static boolean contains(WFUIWizardBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActionModeDirty();
            }
            case 1: {
                return et.isActionParamDirty();
            }
            case 2: {
                return et.isCreateDateDirty();
            }
            case 3: {
                return et.isCreateManDirty();
            }
            case 4: {
                return et.isDataInfoDirty();
            }
            case 5: {
                return et.isUpdateDateDirty();
            }
            case 6: {
                return et.isUpdateManDirty();
            }
            case 7: {
                return et.isWFStepValueDirty();
            }
            case 8: {
                return et.isWFUIWizardIdDirty();
            }
            case 9: {
                return et.isWFUIWizardNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFUIWizardBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFUIWizardBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActionMode() != null) {
            JSONObjectHelper.put(json, "actionmode", WFUIWizardBase.getJSONValue(et.getActionMode()), false);
        }
        if (bIncEmpty || et.getActionParam() != null) {
            JSONObjectHelper.put(json, "actionparam", WFUIWizardBase.getJSONValue(et.getActionParam()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFUIWizardBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFUIWizardBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDataInfo() != null) {
            JSONObjectHelper.put(json, "datainfo", WFUIWizardBase.getJSONValue(et.getDataInfo()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFUIWizardBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFUIWizardBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFStepValue() != null) {
            JSONObjectHelper.put(json, "wfstepvalue", WFUIWizardBase.getJSONValue(et.getWFStepValue()), false);
        }
        if (bIncEmpty || et.getWFUIWizardId() != null) {
            JSONObjectHelper.put(json, "wfuiwizardid", WFUIWizardBase.getJSONValue(et.getWFUIWizardId()), false);
        }
        if (bIncEmpty || et.getWFUIWizardName() != null) {
            JSONObjectHelper.put(json, "wfuiwizardname", WFUIWizardBase.getJSONValue(et.getWFUIWizardName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFUIWizardBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFUIWizardBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActionMode() != null) {
            obj = et.getActionMode();
            node.setAttribute(FIELD_ACTIONMODE, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getActionParam() != null) {
            obj = et.getActionParam();
            node.setAttribute(FIELD_ACTIONPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataInfo() != null) {
            obj = et.getDataInfo();
            node.setAttribute(FIELD_DATAINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepValue() != null) {
            obj = et.getWFStepValue();
            node.setAttribute(FIELD_WFSTEPVALUE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUIWizardId() != null) {
            obj = et.getWFUIWizardId();
            node.setAttribute(FIELD_WFUIWIZARDID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUIWizardName() != null) {
            obj = et.getWFUIWizardName();
            node.setAttribute(FIELD_WFUIWIZARDNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUIWizardBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFUIWizardBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActionModeDirty() && (bIncEmpty || et.getActionMode() != null)) {
            dst.set(FIELD_ACTIONMODE, et.getActionMode());
        }
        if (et.isActionParamDirty() && (bIncEmpty || et.getActionParam() != null)) {
            dst.set(FIELD_ACTIONPARAM, et.getActionParam());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDataInfoDirty() && (bIncEmpty || et.getDataInfo() != null)) {
            dst.set(FIELD_DATAINFO, et.getDataInfo());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFStepValueDirty() && (bIncEmpty || et.getWFStepValue() != null)) {
            dst.set(FIELD_WFSTEPVALUE, et.getWFStepValue());
        }
        if (et.isWFUIWizardIdDirty() && (bIncEmpty || et.getWFUIWizardId() != null)) {
            dst.set(FIELD_WFUIWIZARDID, et.getWFUIWizardId());
        }
        if (et.isWFUIWizardNameDirty() && (bIncEmpty || et.getWFUIWizardName() != null)) {
            dst.set(FIELD_WFUIWIZARDNAME, et.getWFUIWizardName());
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
        return WFUIWizardBase.remove(this, index);
    }

    private static boolean remove(WFUIWizardBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActionMode();
                return true;
            }
            case 1: {
                et.resetActionParam();
                return true;
            }
            case 2: {
                et.resetCreateDate();
                return true;
            }
            case 3: {
                et.resetCreateMan();
                return true;
            }
            case 4: {
                et.resetDataInfo();
                return true;
            }
            case 5: {
                et.resetUpdateDate();
                return true;
            }
            case 6: {
                et.resetUpdateMan();
                return true;
            }
            case 7: {
                et.resetWFStepValue();
                return true;
            }
            case 8: {
                et.resetWFUIWizardId();
                return true;
            }
            case 9: {
                et.resetWFUIWizardName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private WFUIWizardBase getProxyEntity() {
        return this.proxyWFUIWizardBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUIWizardBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFUIWizardBase) {
            this.proxyWFUIWizardBase = (WFUIWizardBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUIWizardService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

