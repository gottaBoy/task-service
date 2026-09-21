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
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFActionBase.class);
    public static final String FIELD_ACTIONCODE = "ACTIONCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFACTIONID = "WFACTIONID";
    public static final String FIELD_WFACTIONNAME = "WFACTIONNAME";
    public static final String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    private static final int INDEX_ACTIONCODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final int INDEX_WFACTIONID = 6;
    private static final int INDEX_WFACTIONNAME = 7;
    private static final int INDEX_WFWORKFLOWID = 8;
    private static final int INDEX_WFWORKFLOWNAME = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFActionBase proxyWFActionBase = null;
    private boolean actioncodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfactionidDirtyFlag = false;
    private boolean wfactionnameDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;
    @Column(name="actioncode")
    private String actioncode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfactionid")
    private String wfactionid;
    @Column(name="wfactionname")
    private String wfactionname;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;
    private Integer objWFWorkflowLock = new Integer(1);
    private WFWorkflow wfworkflow = null;

    static {
        fieldIndexMap.put(FIELD_ACTIONCODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
        fieldIndexMap.put(FIELD_WFACTIONID, 6);
        fieldIndexMap.put(FIELD_WFACTIONNAME, 7);
        fieldIndexMap.put(FIELD_WFWORKFLOWID, 8);
        fieldIndexMap.put(FIELD_WFWORKFLOWNAME, 9);
    }

    public void setActionCode(String actioncode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionCode(actioncode);
            return;
        }
        if (actioncode != null && (actioncode = StringHelper.trimRight(actioncode)).length() == 0) {
            actioncode = null;
        }
        this.actioncode = actioncode;
        this.actioncodeDirtyFlag = true;
    }

    public String getActionCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionCode();
        }
        return this.actioncode;
    }

    public boolean isActionCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionCodeDirty();
        }
        return this.actioncodeDirtyFlag;
    }

    public void resetActionCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionCode();
            return;
        }
        this.actioncodeDirtyFlag = false;
        this.actioncode = null;
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

    public void setWFActionId(String wfactionid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActionId(wfactionid);
            return;
        }
        if (wfactionid != null && (wfactionid = StringHelper.trimRight(wfactionid)).length() == 0) {
            wfactionid = null;
        }
        this.wfactionid = wfactionid;
        this.wfactionidDirtyFlag = true;
    }

    public String getWFActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActionId();
        }
        return this.wfactionid;
    }

    public boolean isWFActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActionIdDirty();
        }
        return this.wfactionidDirtyFlag;
    }

    public void resetWFActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActionId();
            return;
        }
        this.wfactionidDirtyFlag = false;
        this.wfactionid = null;
    }

    public void setWFActionName(String wfactionname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActionName(wfactionname);
            return;
        }
        if (wfactionname != null && (wfactionname = StringHelper.trimRight(wfactionname)).length() == 0) {
            wfactionname = null;
        }
        this.wfactionname = wfactionname;
        this.wfactionnameDirtyFlag = true;
    }

    public String getWFActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActionName();
        }
        return this.wfactionname;
    }

    public boolean isWFActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActionNameDirty();
        }
        return this.wfactionnameDirtyFlag;
    }

    public void resetWFActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActionName();
            return;
        }
        this.wfactionnameDirtyFlag = false;
        this.wfactionname = null;
    }

    public void setWFWorkflowId(String wfworkflowid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowId(wfworkflowid);
            return;
        }
        if (wfworkflowid != null && (wfworkflowid = StringHelper.trimRight(wfworkflowid)).length() == 0) {
            wfworkflowid = null;
        }
        this.wfworkflowid = wfworkflowid;
        this.wfworkflowidDirtyFlag = true;
    }

    public String getWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    public boolean isWFWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    public void resetWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowId();
            return;
        }
        this.wfworkflowidDirtyFlag = false;
        this.wfworkflowid = null;
    }

    public void setWFWorkflowName(String wfworkflowname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowName(wfworkflowname);
            return;
        }
        if (wfworkflowname != null && (wfworkflowname = StringHelper.trimRight(wfworkflowname)).length() == 0) {
            wfworkflowname = null;
        }
        this.wfworkflowname = wfworkflowname;
        this.wfworkflownameDirtyFlag = true;
    }

    public String getWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    public boolean isWFWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    public void resetWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowName();
            return;
        }
        this.wfworkflownameDirtyFlag = false;
        this.wfworkflowname = null;
    }

    @Override
    protected void onReset() {
        WFActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFActionBase et) {
        et.resetActionCode();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFActionId();
        et.resetWFActionName();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActionCodeDirty()) {
            params.put(FIELD_ACTIONCODE, this.getActionCode());
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
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFActionIdDirty()) {
            params.put(FIELD_WFACTIONID, this.getWFActionId());
        }
        if (!bDirtyOnly || this.isWFActionNameDirty()) {
            params.put(FIELD_WFACTIONNAME, this.getWFActionName());
        }
        if (!bDirtyOnly || this.isWFWorkflowIdDirty()) {
            params.put(FIELD_WFWORKFLOWID, this.getWFWorkflowId());
        }
        if (!bDirtyOnly || this.isWFWorkflowNameDirty()) {
            params.put(FIELD_WFWORKFLOWNAME, this.getWFWorkflowName());
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
        return WFActionBase.get(this, index);
    }

    private static Object get(WFActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionCode();
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
                return et.getUpdateDate();
            }
            case 5: {
                return et.getUpdateMan();
            }
            case 6: {
                return et.getWFActionId();
            }
            case 7: {
                return et.getWFActionName();
            }
            case 8: {
                return et.getWFWorkflowId();
            }
            case 9: {
                return et.getWFWorkflowName();
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
        WFActionBase.set(this, index, objValue);
    }

    private static void set(WFActionBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActionCode(DataObject.getStringValue(obj));
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
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 5: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setWFActionId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFActionName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFWorkflowId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFWorkflowName(DataObject.getStringValue(obj));
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
        return WFActionBase.isNull(this, index);
    }

    private static boolean isNull(WFActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActionCode() == null;
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
                return et.getUpdateDate() == null;
            }
            case 5: {
                return et.getUpdateMan() == null;
            }
            case 6: {
                return et.getWFActionId() == null;
            }
            case 7: {
                return et.getWFActionName() == null;
            }
            case 8: {
                return et.getWFWorkflowId() == null;
            }
            case 9: {
                return et.getWFWorkflowName() == null;
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
        return WFActionBase.contains(this, index);
    }

    private static boolean contains(WFActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActionCodeDirty();
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
                return et.isUpdateDateDirty();
            }
            case 5: {
                return et.isUpdateManDirty();
            }
            case 6: {
                return et.isWFActionIdDirty();
            }
            case 7: {
                return et.isWFActionNameDirty();
            }
            case 8: {
                return et.isWFWorkflowIdDirty();
            }
            case 9: {
                return et.isWFWorkflowNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFActionBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFActionBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActionCode() != null) {
            JSONObjectHelper.put(json, "actioncode", WFActionBase.getJSONValue(et.getActionCode()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFActionBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFActionBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFActionBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFActionBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFActionBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFActionId() != null) {
            JSONObjectHelper.put(json, "wfactionid", WFActionBase.getJSONValue(et.getWFActionId()), false);
        }
        if (bIncEmpty || et.getWFActionName() != null) {
            JSONObjectHelper.put(json, "wfactionname", WFActionBase.getJSONValue(et.getWFActionName()), false);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            JSONObjectHelper.put(json, "wfworkflowid", WFActionBase.getJSONValue(et.getWFWorkflowId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            JSONObjectHelper.put(json, "wfworkflowname", WFActionBase.getJSONValue(et.getWFWorkflowName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFActionBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFActionBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActionCode() != null) {
            obj = et.getActionCode();
            node.setAttribute(FIELD_ACTIONCODE, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActionId() != null) {
            obj = et.getWFActionId();
            node.setAttribute(FIELD_WFACTIONID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActionName() != null) {
            obj = et.getWFActionName();
            node.setAttribute(FIELD_WFACTIONNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            obj = et.getWFWorkflowId();
            node.setAttribute(FIELD_WFWORKFLOWID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            obj = et.getWFWorkflowName();
            node.setAttribute(FIELD_WFWORKFLOWNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFActionBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFActionBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActionCodeDirty() && (bIncEmpty || et.getActionCode() != null)) {
            dst.set(FIELD_ACTIONCODE, et.getActionCode());
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
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFActionIdDirty() && (bIncEmpty || et.getWFActionId() != null)) {
            dst.set(FIELD_WFACTIONID, et.getWFActionId());
        }
        if (et.isWFActionNameDirty() && (bIncEmpty || et.getWFActionName() != null)) {
            dst.set(FIELD_WFACTIONNAME, et.getWFActionName());
        }
        if (et.isWFWorkflowIdDirty() && (bIncEmpty || et.getWFWorkflowId() != null)) {
            dst.set(FIELD_WFWORKFLOWID, et.getWFWorkflowId());
        }
        if (et.isWFWorkflowNameDirty() && (bIncEmpty || et.getWFWorkflowName() != null)) {
            dst.set(FIELD_WFWORKFLOWNAME, et.getWFWorkflowName());
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
        return WFActionBase.remove(this, index);
    }

    private static boolean remove(WFActionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActionCode();
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
                et.resetUpdateDate();
                return true;
            }
            case 5: {
                et.resetUpdateMan();
                return true;
            }
            case 6: {
                et.resetWFActionId();
                return true;
            }
            case 7: {
                et.resetWFActionName();
                return true;
            }
            case 8: {
                et.resetWFWorkflowId();
                return true;
            }
            case 9: {
                et.resetWFWorkflowName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFWorkflow getWFWorkflow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflow();
        }
        if (this.getWFWorkflowId() == null) {
            return null;
        }
        Integer n = this.objWFWorkflowLock;
        synchronized (n) {
            if (this.wfworkflow != null && DataTypeHelper.compare(25, (Object)this.getWFWorkflowId(), (Object)this.wfworkflow.getWFWorkflowId()) != 0L) {
                this.wfworkflow = null;
            }
            if (this.wfworkflow == null) {
                WFWorkflow wfworkflow = new WFWorkflow();
                wfworkflow.setWFWorkflowId(this.getWFWorkflowId());
                WFWorkflowService service = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class, this.getSessionFactory());
                service.autoGet(wfworkflow);
                this.wfworkflow = wfworkflow;
            }
            return this.wfworkflow;
        }
    }

    private WFActionBase getProxyEntity() {
        return this.proxyWFActionBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFActionBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFActionBase) {
            this.proxyWFActionBase = (WFActionBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFActionService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

