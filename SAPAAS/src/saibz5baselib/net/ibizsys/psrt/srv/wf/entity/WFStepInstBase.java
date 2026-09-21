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
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFStepInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepInstBase.class);
    public static final String FIELD_CLOSEFLAG = "CLOSEFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_RETURNDATA = "RETURNDATA";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFINSTANCEID = "WFINSTANCEID";
    public static final String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String FIELD_WFSTEPID = "WFSTEPID";
    public static final String FIELD_WFSTEPINSTID = "WFSTEPINSTID";
    public static final String FIELD_WFSTEPINSTNAME = "WFSTEPINSTNAME";
    public static final String FIELD_WFSTEPLANRESTAG = "WFSTEPLANRESTAG";
    public static final String FIELD_WFSTEPNAME = "WFSTEPNAME";
    private static final int INDEX_CLOSEFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_RETURNDATA = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final int INDEX_WFINSTANCEID = 6;
    private static final int INDEX_WFINSTANCENAME = 7;
    private static final int INDEX_WFSTEPID = 8;
    private static final int INDEX_WFSTEPINSTID = 9;
    private static final int INDEX_WFSTEPINSTNAME = 10;
    private static final int INDEX_WFSTEPLANRESTAG = 11;
    private static final int INDEX_WFSTEPNAME = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFStepInstBase proxyWFStepInstBase = null;
    private boolean closeflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean returndataDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfstepinstidDirtyFlag = false;
    private boolean wfstepinstnameDirtyFlag = false;
    private boolean wfsteplanrestagDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;
    @Column(name="closeflag")
    private Integer closeflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="returndata")
    private String returndata;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfstepinstid")
    private String wfstepinstid;
    @Column(name="wfstepinstname")
    private String wfstepinstname;
    @Column(name="wfsteplanrestag")
    private String wfsteplanrestag;
    @Column(name="wfstepname")
    private String wfstepname;
    private Integer objWFInstanceLock = new Integer(1);
    private WFInstance wfinstance = null;
    private Integer objWfstepLock = new Integer(1);
    private WFStep wfstep = null;

    static {
        fieldIndexMap.put(FIELD_CLOSEFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_RETURNDATA, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
        fieldIndexMap.put(FIELD_WFINSTANCEID, 6);
        fieldIndexMap.put(FIELD_WFINSTANCENAME, 7);
        fieldIndexMap.put(FIELD_WFSTEPID, 8);
        fieldIndexMap.put(FIELD_WFSTEPINSTID, 9);
        fieldIndexMap.put(FIELD_WFSTEPINSTNAME, 10);
        fieldIndexMap.put(FIELD_WFSTEPLANRESTAG, 11);
        fieldIndexMap.put(FIELD_WFSTEPNAME, 12);
    }

    public void setCloseFlag(Integer closeflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCloseFlag(closeflag);
            return;
        }
        this.closeflag = closeflag;
        this.closeflagDirtyFlag = true;
    }

    public Integer getCloseFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCloseFlag();
        }
        return this.closeflag;
    }

    public boolean isCloseFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCloseFlagDirty();
        }
        return this.closeflagDirtyFlag;
    }

    public void resetCloseFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCloseFlag();
            return;
        }
        this.closeflagDirtyFlag = false;
        this.closeflag = null;
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

    public void setReturnData(String returndata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReturnData(returndata);
            return;
        }
        if (returndata != null && (returndata = StringHelper.trimRight(returndata)).length() == 0) {
            returndata = null;
        }
        this.returndata = returndata;
        this.returndataDirtyFlag = true;
    }

    public String getReturnData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReturnData();
        }
        return this.returndata;
    }

    public boolean isReturnDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReturnDataDirty();
        }
        return this.returndataDirtyFlag;
    }

    public void resetReturnData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReturnData();
            return;
        }
        this.returndataDirtyFlag = false;
        this.returndata = null;
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

    public void setWFInstanceId(String wfinstanceid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstanceId(wfinstanceid);
            return;
        }
        if (wfinstanceid != null && (wfinstanceid = StringHelper.trimRight(wfinstanceid)).length() == 0) {
            wfinstanceid = null;
        }
        this.wfinstanceid = wfinstanceid;
        this.wfinstanceidDirtyFlag = true;
    }

    public String getWFInstanceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    public boolean isWFInstanceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    public void resetWFInstanceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstanceId();
            return;
        }
        this.wfinstanceidDirtyFlag = false;
        this.wfinstanceid = null;
    }

    public void setWFInstanceName(String wfinstancename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstanceName(wfinstancename);
            return;
        }
        if (wfinstancename != null && (wfinstancename = StringHelper.trimRight(wfinstancename)).length() == 0) {
            wfinstancename = null;
        }
        this.wfinstancename = wfinstancename;
        this.wfinstancenameDirtyFlag = true;
    }

    public String getWFInstanceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    public boolean isWFInstanceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    public void resetWFInstanceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstanceName();
            return;
        }
        this.wfinstancenameDirtyFlag = false;
        this.wfinstancename = null;
    }

    public void setWFStepId(String wfstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepId(wfstepid);
            return;
        }
        if (wfstepid != null && (wfstepid = StringHelper.trimRight(wfstepid)).length() == 0) {
            wfstepid = null;
        }
        this.wfstepid = wfstepid;
        this.wfstepidDirtyFlag = true;
    }

    public String getWFStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    public boolean isWFStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    public void resetWFStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepId();
            return;
        }
        this.wfstepidDirtyFlag = false;
        this.wfstepid = null;
    }

    public void setWFStepInstId(String wfstepinstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepInstId(wfstepinstid);
            return;
        }
        if (wfstepinstid != null && (wfstepinstid = StringHelper.trimRight(wfstepinstid)).length() == 0) {
            wfstepinstid = null;
        }
        this.wfstepinstid = wfstepinstid;
        this.wfstepinstidDirtyFlag = true;
    }

    public String getWFStepInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepInstId();
        }
        return this.wfstepinstid;
    }

    public boolean isWFStepInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepInstIdDirty();
        }
        return this.wfstepinstidDirtyFlag;
    }

    public void resetWFStepInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepInstId();
            return;
        }
        this.wfstepinstidDirtyFlag = false;
        this.wfstepinstid = null;
    }

    public void setWFStepInstName(String wfstepinstname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepInstName(wfstepinstname);
            return;
        }
        if (wfstepinstname != null && (wfstepinstname = StringHelper.trimRight(wfstepinstname)).length() == 0) {
            wfstepinstname = null;
        }
        this.wfstepinstname = wfstepinstname;
        this.wfstepinstnameDirtyFlag = true;
    }

    public String getWFStepInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepInstName();
        }
        return this.wfstepinstname;
    }

    public boolean isWFStepInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepInstNameDirty();
        }
        return this.wfstepinstnameDirtyFlag;
    }

    public void resetWFStepInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepInstName();
            return;
        }
        this.wfstepinstnameDirtyFlag = false;
        this.wfstepinstname = null;
    }

    public void setWFStepLanResTag(String wfsteplanrestag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepLanResTag(wfsteplanrestag);
            return;
        }
        if (wfsteplanrestag != null && (wfsteplanrestag = StringHelper.trimRight(wfsteplanrestag)).length() == 0) {
            wfsteplanrestag = null;
        }
        this.wfsteplanrestag = wfsteplanrestag;
        this.wfsteplanrestagDirtyFlag = true;
    }

    public String getWFStepLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepLanResTag();
        }
        return this.wfsteplanrestag;
    }

    public boolean isWFStepLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepLanResTagDirty();
        }
        return this.wfsteplanrestagDirtyFlag;
    }

    public void resetWFStepLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepLanResTag();
            return;
        }
        this.wfsteplanrestagDirtyFlag = false;
        this.wfsteplanrestag = null;
    }

    public void setWFStepName(String wfstepname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepName(wfstepname);
            return;
        }
        if (wfstepname != null && (wfstepname = StringHelper.trimRight(wfstepname)).length() == 0) {
            wfstepname = null;
        }
        this.wfstepname = wfstepname;
        this.wfstepnameDirtyFlag = true;
    }

    public String getWFStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    public boolean isWFStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    public void resetWFStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }
        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    @Override
    protected void onReset() {
        WFStepInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFStepInstBase et) {
        et.resetCloseFlag();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReturnData();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFStepId();
        et.resetWFStepInstId();
        et.resetWFStepInstName();
        et.resetWFStepLanResTag();
        et.resetWFStepName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCloseFlagDirty()) {
            params.put(FIELD_CLOSEFLAG, this.getCloseFlag());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isReturnDataDirty()) {
            params.put(FIELD_RETURNDATA, this.getReturnData());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID, this.getWFInstanceId());
        }
        if (!bDirtyOnly || this.isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME, this.getWFInstanceName());
        }
        if (!bDirtyOnly || this.isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID, this.getWFStepId());
        }
        if (!bDirtyOnly || this.isWFStepInstIdDirty()) {
            params.put(FIELD_WFSTEPINSTID, this.getWFStepInstId());
        }
        if (!bDirtyOnly || this.isWFStepInstNameDirty()) {
            params.put(FIELD_WFSTEPINSTNAME, this.getWFStepInstName());
        }
        if (!bDirtyOnly || this.isWFStepLanResTagDirty()) {
            params.put(FIELD_WFSTEPLANRESTAG, this.getWFStepLanResTag());
        }
        if (!bDirtyOnly || this.isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME, this.getWFStepName());
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
        return WFStepInstBase.get(this, index);
    }

    private static Object get(WFStepInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCloseFlag();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getReturnData();
            }
            case 4: {
                return et.getUpdateDate();
            }
            case 5: {
                return et.getUpdateMan();
            }
            case 6: {
                return et.getWFInstanceId();
            }
            case 7: {
                return et.getWFInstanceName();
            }
            case 8: {
                return et.getWFStepId();
            }
            case 9: {
                return et.getWFStepInstId();
            }
            case 10: {
                return et.getWFStepInstName();
            }
            case 11: {
                return et.getWFStepLanResTag();
            }
            case 12: {
                return et.getWFStepName();
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
        WFStepInstBase.set(this, index, objValue);
    }

    private static void set(WFStepInstBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCloseFlag(DataObject.getIntegerValue(obj));
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
                et.setReturnData(DataObject.getStringValue(obj));
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
                et.setWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFInstanceName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFStepInstId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFStepInstName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWFStepLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWFStepName(DataObject.getStringValue(obj));
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
        return WFStepInstBase.isNull(this, index);
    }

    private static boolean isNull(WFStepInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCloseFlag() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getReturnData() == null;
            }
            case 4: {
                return et.getUpdateDate() == null;
            }
            case 5: {
                return et.getUpdateMan() == null;
            }
            case 6: {
                return et.getWFInstanceId() == null;
            }
            case 7: {
                return et.getWFInstanceName() == null;
            }
            case 8: {
                return et.getWFStepId() == null;
            }
            case 9: {
                return et.getWFStepInstId() == null;
            }
            case 10: {
                return et.getWFStepInstName() == null;
            }
            case 11: {
                return et.getWFStepLanResTag() == null;
            }
            case 12: {
                return et.getWFStepName() == null;
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
        return WFStepInstBase.contains(this, index);
    }

    private static boolean contains(WFStepInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCloseFlagDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isReturnDataDirty();
            }
            case 4: {
                return et.isUpdateDateDirty();
            }
            case 5: {
                return et.isUpdateManDirty();
            }
            case 6: {
                return et.isWFInstanceIdDirty();
            }
            case 7: {
                return et.isWFInstanceNameDirty();
            }
            case 8: {
                return et.isWFStepIdDirty();
            }
            case 9: {
                return et.isWFStepInstIdDirty();
            }
            case 10: {
                return et.isWFStepInstNameDirty();
            }
            case 11: {
                return et.isWFStepLanResTagDirty();
            }
            case 12: {
                return et.isWFStepNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFStepInstBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFStepInstBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCloseFlag() != null) {
            JSONObjectHelper.put(json, "closeflag", WFStepInstBase.getJSONValue(et.getCloseFlag()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFStepInstBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFStepInstBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getReturnData() != null) {
            JSONObjectHelper.put(json, "returndata", WFStepInstBase.getJSONValue(et.getReturnData()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFStepInstBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFStepInstBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            JSONObjectHelper.put(json, "wfinstanceid", WFStepInstBase.getJSONValue(et.getWFInstanceId()), false);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            JSONObjectHelper.put(json, "wfinstancename", WFStepInstBase.getJSONValue(et.getWFInstanceName()), false);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            JSONObjectHelper.put(json, "wfstepid", WFStepInstBase.getJSONValue(et.getWFStepId()), false);
        }
        if (bIncEmpty || et.getWFStepInstId() != null) {
            JSONObjectHelper.put(json, "wfstepinstid", WFStepInstBase.getJSONValue(et.getWFStepInstId()), false);
        }
        if (bIncEmpty || et.getWFStepInstName() != null) {
            JSONObjectHelper.put(json, "wfstepinstname", WFStepInstBase.getJSONValue(et.getWFStepInstName()), false);
        }
        if (bIncEmpty || et.getWFStepLanResTag() != null) {
            JSONObjectHelper.put(json, "wfsteplanrestag", WFStepInstBase.getJSONValue(et.getWFStepLanResTag()), false);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            JSONObjectHelper.put(json, "wfstepname", WFStepInstBase.getJSONValue(et.getWFStepName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFStepInstBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFStepInstBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCloseFlag() != null) {
            obj = et.getCloseFlag();
            node.setAttribute(FIELD_CLOSEFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReturnData() != null) {
            obj = et.getReturnData();
            node.setAttribute(FIELD_RETURNDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            obj = et.getWFInstanceId();
            node.setAttribute(FIELD_WFINSTANCEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            obj = et.getWFInstanceName();
            node.setAttribute(FIELD_WFINSTANCENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            obj = et.getWFStepId();
            node.setAttribute(FIELD_WFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepInstId() != null) {
            obj = et.getWFStepInstId();
            node.setAttribute(FIELD_WFSTEPINSTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepInstName() != null) {
            obj = et.getWFStepInstName();
            node.setAttribute(FIELD_WFSTEPINSTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepLanResTag() != null) {
            obj = et.getWFStepLanResTag();
            node.setAttribute(FIELD_WFSTEPLANRESTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            obj = et.getWFStepName();
            node.setAttribute(FIELD_WFSTEPNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepInstBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFStepInstBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCloseFlagDirty() && (bIncEmpty || et.getCloseFlag() != null)) {
            dst.set(FIELD_CLOSEFLAG, et.getCloseFlag());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isReturnDataDirty() && (bIncEmpty || et.getReturnData() != null)) {
            dst.set(FIELD_RETURNDATA, et.getReturnData());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFInstanceIdDirty() && (bIncEmpty || et.getWFInstanceId() != null)) {
            dst.set(FIELD_WFINSTANCEID, et.getWFInstanceId());
        }
        if (et.isWFInstanceNameDirty() && (bIncEmpty || et.getWFInstanceName() != null)) {
            dst.set(FIELD_WFINSTANCENAME, et.getWFInstanceName());
        }
        if (et.isWFStepIdDirty() && (bIncEmpty || et.getWFStepId() != null)) {
            dst.set(FIELD_WFSTEPID, et.getWFStepId());
        }
        if (et.isWFStepInstIdDirty() && (bIncEmpty || et.getWFStepInstId() != null)) {
            dst.set(FIELD_WFSTEPINSTID, et.getWFStepInstId());
        }
        if (et.isWFStepInstNameDirty() && (bIncEmpty || et.getWFStepInstName() != null)) {
            dst.set(FIELD_WFSTEPINSTNAME, et.getWFStepInstName());
        }
        if (et.isWFStepLanResTagDirty() && (bIncEmpty || et.getWFStepLanResTag() != null)) {
            dst.set(FIELD_WFSTEPLANRESTAG, et.getWFStepLanResTag());
        }
        if (et.isWFStepNameDirty() && (bIncEmpty || et.getWFStepName() != null)) {
            dst.set(FIELD_WFSTEPNAME, et.getWFStepName());
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
        return WFStepInstBase.remove(this, index);
    }

    private static boolean remove(WFStepInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCloseFlag();
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
                et.resetReturnData();
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
                et.resetWFInstanceId();
                return true;
            }
            case 7: {
                et.resetWFInstanceName();
                return true;
            }
            case 8: {
                et.resetWFStepId();
                return true;
            }
            case 9: {
                et.resetWFStepInstId();
                return true;
            }
            case 10: {
                et.resetWFStepInstName();
                return true;
            }
            case 11: {
                et.resetWFStepLanResTag();
                return true;
            }
            case 12: {
                et.resetWFStepName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFInstance getWFInstance() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstance();
        }
        if (this.getWFInstanceId() == null) {
            return null;
        }
        Integer n = this.objWFInstanceLock;
        synchronized (n) {
            if (this.wfinstance != null && DataTypeHelper.compare(25, (Object)this.getWFInstanceId(), (Object)this.wfinstance.getWFInstanceId()) != 0L) {
                this.wfinstance = null;
            }
            if (this.wfinstance == null) {
                WFInstance wfinstance = new WFInstance();
                wfinstance.setWFInstanceId(this.getWFInstanceId());
                WFInstanceService service = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
                service.autoGet(wfinstance);
                this.wfinstance = wfinstance;
            }
            return this.wfinstance;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFStep getWfstep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWfstep();
        }
        if (this.getWFStepId() == null) {
            return null;
        }
        Integer n = this.objWfstepLock;
        synchronized (n) {
            if (this.wfstep != null && DataTypeHelper.compare(25, (Object)this.getWFStepId(), (Object)this.wfstep.getWFStepId()) != 0L) {
                this.wfstep = null;
            }
            if (this.wfstep == null) {
                WFStep wfstep = new WFStep();
                wfstep.setWFStepId(this.getWFStepId());
                WFStepService service = (WFStepService)ServiceGlobal.getService(WFStepService.class, this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }

    private WFStepInstBase getProxyEntity() {
        return this.proxyWFStepInstBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepInstBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFStepInstBase) {
            this.proxyWFStepInstBase = (WFStepInstBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepInstService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

