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

public abstract class WFVersionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFVersionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFMODEL = "WFMODEL";
    public static final String FIELD_WFVERLANRESTAG = "WFVERLANRESTAG";
    public static final String FIELD_WFVERSION = "WFVERSION";
    public static final String FIELD_WFWFID = "WFWFID";
    public static final String FIELD_WFWFNAME = "WFWFNAME";
    public static final String FIELD_WFVERSIONID = "WFWFVERSIONID";
    public static final String FIELD_WFVERSIONNAME = "WFWFVERSIONNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_UPDATEDATE = 2;
    private static final int INDEX_UPDATEMAN = 3;
    private static final int INDEX_WFMODEL = 4;
    private static final int INDEX_WFVERLANRESTAG = 5;
    private static final int INDEX_WFVERSION = 6;
    private static final int INDEX_WFWFID = 7;
    private static final int INDEX_WFWFNAME = 8;
    private static final int INDEX_WFVERSIONID = 9;
    private static final int INDEX_WFVERSIONNAME = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFVersionBase proxyWFVersionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfmodelDirtyFlag = false;
    private boolean wfverlanrestagDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    private boolean wfwfidDirtyFlag = false;
    private boolean wfwfnameDirtyFlag = false;
    private boolean wfversionidDirtyFlag = false;
    private boolean wfversionnameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfmodel")
    private String wfmodel;
    @Column(name="wfverlanrestag")
    private String wfverlanrestag;
    @Column(name="wfversion")
    private Integer wfversion;
    @Column(name="wfwfid")
    private String wfwfid;
    @Column(name="wfwfname")
    private String wfwfname;
    @Column(name="wfversionid")
    private String wfversionid;
    @Column(name="wfversionname")
    private String wfversionname;
    private Integer objWFWorkflowLock = new Integer(1);
    private WFWorkflow wfworkflow = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_UPDATEDATE, 2);
        fieldIndexMap.put(FIELD_UPDATEMAN, 3);
        fieldIndexMap.put(FIELD_WFMODEL, 4);
        fieldIndexMap.put(FIELD_WFVERLANRESTAG, 5);
        fieldIndexMap.put(FIELD_WFVERSION, 6);
        fieldIndexMap.put(FIELD_WFWFID, 7);
        fieldIndexMap.put(FIELD_WFWFNAME, 8);
        fieldIndexMap.put(FIELD_WFVERSIONID, 9);
        fieldIndexMap.put(FIELD_WFVERSIONNAME, 10);
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

    public void setWFModel(String wfmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFModel(wfmodel);
            return;
        }
        if (wfmodel != null && (wfmodel = StringHelper.trimRight(wfmodel)).length() == 0) {
            wfmodel = null;
        }
        this.wfmodel = wfmodel;
        this.wfmodelDirtyFlag = true;
    }

    public String getWFModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFModel();
        }
        return this.wfmodel;
    }

    public boolean isWFModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFModelDirty();
        }
        return this.wfmodelDirtyFlag;
    }

    public void resetWFModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFModel();
            return;
        }
        this.wfmodelDirtyFlag = false;
        this.wfmodel = null;
    }

    public void setWFVerLanResTag(String wfverlanrestag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVerLanResTag(wfverlanrestag);
            return;
        }
        if (wfverlanrestag != null && (wfverlanrestag = StringHelper.trimRight(wfverlanrestag)).length() == 0) {
            wfverlanrestag = null;
        }
        this.wfverlanrestag = wfverlanrestag;
        this.wfverlanrestagDirtyFlag = true;
    }

    public String getWFVerLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVerLanResTag();
        }
        return this.wfverlanrestag;
    }

    public boolean isWFVerLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVerLanResTagDirty();
        }
        return this.wfverlanrestagDirtyFlag;
    }

    public void resetWFVerLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVerLanResTag();
            return;
        }
        this.wfverlanrestagDirtyFlag = false;
        this.wfverlanrestag = null;
    }

    public void setWFVersion(Integer wfversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersion(wfversion);
            return;
        }
        this.wfversion = wfversion;
        this.wfversionDirtyFlag = true;
    }

    public Integer getWFVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    public boolean isWFVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    public void resetWFVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }

    public void setWFWFId(String wfwfid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWFId(wfwfid);
            return;
        }
        if (wfwfid != null && (wfwfid = StringHelper.trimRight(wfwfid)).length() == 0) {
            wfwfid = null;
        }
        this.wfwfid = wfwfid;
        this.wfwfidDirtyFlag = true;
    }

    public String getWFWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWFId();
        }
        return this.wfwfid;
    }

    public boolean isWFWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWFIdDirty();
        }
        return this.wfwfidDirtyFlag;
    }

    public void resetWFWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWFId();
            return;
        }
        this.wfwfidDirtyFlag = false;
        this.wfwfid = null;
    }

    public void setWFWFName(String wfwfname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWFName(wfwfname);
            return;
        }
        if (wfwfname != null && (wfwfname = StringHelper.trimRight(wfwfname)).length() == 0) {
            wfwfname = null;
        }
        this.wfwfname = wfwfname;
        this.wfwfnameDirtyFlag = true;
    }

    public String getWFWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWFName();
        }
        return this.wfwfname;
    }

    public boolean isWFWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWFNameDirty();
        }
        return this.wfwfnameDirtyFlag;
    }

    public void resetWFWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWFName();
            return;
        }
        this.wfwfnameDirtyFlag = false;
        this.wfwfname = null;
    }

    public void setWFVersionId(String wfversionid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersionId(wfversionid);
            return;
        }
        if (wfversionid != null && (wfversionid = StringHelper.trimRight(wfversionid)).length() == 0) {
            wfversionid = null;
        }
        this.wfversionid = wfversionid;
        this.wfversionidDirtyFlag = true;
    }

    public String getWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersionId();
        }
        return this.wfversionid;
    }

    public boolean isWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionIdDirty();
        }
        return this.wfversionidDirtyFlag;
    }

    public void resetWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersionId();
            return;
        }
        this.wfversionidDirtyFlag = false;
        this.wfversionid = null;
    }

    public void setWFVersionName(String wfversionname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersionName(wfversionname);
            return;
        }
        if (wfversionname != null && (wfversionname = StringHelper.trimRight(wfversionname)).length() == 0) {
            wfversionname = null;
        }
        this.wfversionname = wfversionname;
        this.wfversionnameDirtyFlag = true;
    }

    public String getWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersionName();
        }
        return this.wfversionname;
    }

    public boolean isWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionNameDirty();
        }
        return this.wfversionnameDirtyFlag;
    }

    public void resetWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersionName();
            return;
        }
        this.wfversionnameDirtyFlag = false;
        this.wfversionname = null;
    }

    @Override
    protected void onReset() {
        WFVersionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFVersionBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFModel();
        et.resetWFVerLanResTag();
        et.resetWFVersion();
        et.resetWFWFId();
        et.resetWFWFName();
        et.resetWFVersionId();
        et.resetWFVersionName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFModelDirty()) {
            params.put(FIELD_WFMODEL, this.getWFModel());
        }
        if (!bDirtyOnly || this.isWFVerLanResTagDirty()) {
            params.put(FIELD_WFVERLANRESTAG, this.getWFVerLanResTag());
        }
        if (!bDirtyOnly || this.isWFVersionDirty()) {
            params.put(FIELD_WFVERSION, this.getWFVersion());
        }
        if (!bDirtyOnly || this.isWFWFIdDirty()) {
            params.put(FIELD_WFWFID, this.getWFWFId());
        }
        if (!bDirtyOnly || this.isWFWFNameDirty()) {
            params.put(FIELD_WFWFNAME, this.getWFWFName());
        }
        if (!bDirtyOnly || this.isWFVersionIdDirty()) {
            params.put(FIELD_WFVERSIONID, this.getWFVersionId());
        }
        if (!bDirtyOnly || this.isWFVersionNameDirty()) {
            params.put(FIELD_WFVERSIONNAME, this.getWFVersionName());
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
        return WFVersionBase.get(this, index);
    }

    private static Object get(WFVersionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getUpdateDate();
            }
            case 3: {
                return et.getUpdateMan();
            }
            case 4: {
                return et.getWFModel();
            }
            case 5: {
                return et.getWFVerLanResTag();
            }
            case 6: {
                return et.getWFVersion();
            }
            case 7: {
                return et.getWFWFId();
            }
            case 8: {
                return et.getWFWFName();
            }
            case 9: {
                return et.getWFVersionId();
            }
            case 10: {
                return et.getWFVersionName();
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
        WFVersionBase.set(this, index, objValue);
    }

    private static void set(WFVersionBase et, int index, Object obj) throws Exception {
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
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setWFModel(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setWFVerLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setWFVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 7: {
                et.setWFWFId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFWFName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFVersionId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFVersionName(DataObject.getStringValue(obj));
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
        return WFVersionBase.isNull(this, index);
    }

    private static boolean isNull(WFVersionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getUpdateDate() == null;
            }
            case 3: {
                return et.getUpdateMan() == null;
            }
            case 4: {
                return et.getWFModel() == null;
            }
            case 5: {
                return et.getWFVerLanResTag() == null;
            }
            case 6: {
                return et.getWFVersion() == null;
            }
            case 7: {
                return et.getWFWFId() == null;
            }
            case 8: {
                return et.getWFWFName() == null;
            }
            case 9: {
                return et.getWFVersionId() == null;
            }
            case 10: {
                return et.getWFVersionName() == null;
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
        return WFVersionBase.contains(this, index);
    }

    private static boolean contains(WFVersionBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isUpdateDateDirty();
            }
            case 3: {
                return et.isUpdateManDirty();
            }
            case 4: {
                return et.isWFModelDirty();
            }
            case 5: {
                return et.isWFVerLanResTagDirty();
            }
            case 6: {
                return et.isWFVersionDirty();
            }
            case 7: {
                return et.isWFWFIdDirty();
            }
            case 8: {
                return et.isWFWFNameDirty();
            }
            case 9: {
                return et.isWFVersionIdDirty();
            }
            case 10: {
                return et.isWFVersionNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFVersionBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFVersionBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFVersionBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFVersionBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFVersionBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFVersionBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFModel() != null) {
            JSONObjectHelper.put(json, "wfmodel", WFVersionBase.getJSONValue(et.getWFModel()), false);
        }
        if (bIncEmpty || et.getWFVerLanResTag() != null) {
            JSONObjectHelper.put(json, "wfverlanrestag", WFVersionBase.getJSONValue(et.getWFVerLanResTag()), false);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            JSONObjectHelper.put(json, "wfversion", WFVersionBase.getJSONValue(et.getWFVersion()), false);
        }
        if (bIncEmpty || et.getWFWFId() != null) {
            JSONObjectHelper.put(json, "wfwfid", WFVersionBase.getJSONValue(et.getWFWFId()), false);
        }
        if (bIncEmpty || et.getWFWFName() != null) {
            JSONObjectHelper.put(json, "wfwfname", WFVersionBase.getJSONValue(et.getWFWFName()), false);
        }
        if (bIncEmpty || et.getWFVersionId() != null) {
            JSONObjectHelper.put(json, "wfwfversionid", WFVersionBase.getJSONValue(et.getWFVersionId()), false);
        }
        if (bIncEmpty || et.getWFVersionName() != null) {
            JSONObjectHelper.put(json, "wfwfversionname", WFVersionBase.getJSONValue(et.getWFVersionName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFVersionBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFVersionBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFModel() != null) {
            obj = et.getWFModel();
            node.setAttribute(FIELD_WFMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVerLanResTag() != null) {
            obj = et.getWFVerLanResTag();
            node.setAttribute(FIELD_WFVERLANRESTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            obj = et.getWFVersion();
            node.setAttribute(FIELD_WFVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getWFWFId() != null) {
            obj = et.getWFWFId();
            node.setAttribute(FIELD_WFWFID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWFName() != null) {
            obj = et.getWFWFName();
            node.setAttribute(FIELD_WFWFNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersionId() != null) {
            obj = et.getWFVersionId();
            node.setAttribute("WFVERSIONID", obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersionName() != null) {
            obj = et.getWFVersionName();
            node.setAttribute("WFVERSIONNAME", obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFVersionBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFVersionBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFModelDirty() && (bIncEmpty || et.getWFModel() != null)) {
            dst.set(FIELD_WFMODEL, et.getWFModel());
        }
        if (et.isWFVerLanResTagDirty() && (bIncEmpty || et.getWFVerLanResTag() != null)) {
            dst.set(FIELD_WFVERLANRESTAG, et.getWFVerLanResTag());
        }
        if (et.isWFVersionDirty() && (bIncEmpty || et.getWFVersion() != null)) {
            dst.set(FIELD_WFVERSION, et.getWFVersion());
        }
        if (et.isWFWFIdDirty() && (bIncEmpty || et.getWFWFId() != null)) {
            dst.set(FIELD_WFWFID, et.getWFWFId());
        }
        if (et.isWFWFNameDirty() && (bIncEmpty || et.getWFWFName() != null)) {
            dst.set(FIELD_WFWFNAME, et.getWFWFName());
        }
        if (et.isWFVersionIdDirty() && (bIncEmpty || et.getWFVersionId() != null)) {
            dst.set(FIELD_WFVERSIONID, et.getWFVersionId());
        }
        if (et.isWFVersionNameDirty() && (bIncEmpty || et.getWFVersionName() != null)) {
            dst.set(FIELD_WFVERSIONNAME, et.getWFVersionName());
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
        return WFVersionBase.remove(this, index);
    }

    private static boolean remove(WFVersionBase et, int index) throws Exception {
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
                et.resetUpdateDate();
                return true;
            }
            case 3: {
                et.resetUpdateMan();
                return true;
            }
            case 4: {
                et.resetWFModel();
                return true;
            }
            case 5: {
                et.resetWFVerLanResTag();
                return true;
            }
            case 6: {
                et.resetWFVersion();
                return true;
            }
            case 7: {
                et.resetWFWFId();
                return true;
            }
            case 8: {
                et.resetWFWFName();
                return true;
            }
            case 9: {
                et.resetWFVersionId();
                return true;
            }
            case 10: {
                et.resetWFVersionName();
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
        if (this.getWFWFId() == null) {
            return null;
        }
        Integer n = this.objWFWorkflowLock;
        synchronized (n) {
            if (this.wfworkflow != null && DataTypeHelper.compare(25, (Object)this.getWFWFId(), (Object)this.wfworkflow.getWFWorkflowId()) != 0L) {
                this.wfworkflow = null;
            }
            if (this.wfworkflow == null) {
                WFWorkflow wfworkflow = new WFWorkflow();
                wfworkflow.setWFWorkflowId(this.getWFWFId());
                WFWorkflowService service = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class, this.getSessionFactory());
                service.autoGet(wfworkflow);
                this.wfworkflow = wfworkflow;
            }
            return this.wfworkflow;
        }
    }

    private WFVersionBase getProxyEntity() {
        return this.proxyWFVersionBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFVersionBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFVersionBase) {
            this.proxyWFVersionBase = (WFVersionBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFVersionService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

