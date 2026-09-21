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
import net.ibizsys.psrt.srv.wf.entity.WFActor;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.service.WFActorService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFTmpStepActorBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFTmpStepActorBase.class);
    public static final String FIELD_CONNECTION = "CONNECTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PREVPROCESS = "PREVPROCESS";
    public static final String FIELD_PREVWFSTEPID = "PREVWFSTEPID";
    public static final String FIELD_PREVWFSTEPNAME = "PREVWFSTEPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFACTORID = "WFACTORID";
    public static final String FIELD_WFACTORNAME = "WFACTORNAME";
    public static final String FIELD_WFTMPSTEPACTORID = "WFTMPSTEPACTORID";
    public static final String FIELD_WFTMPSTEPACTORNAME = "WFTMPSTEPACTORNAME";
    private static final int INDEX_CONNECTION = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PREVPROCESS = 4;
    private static final int INDEX_PREVWFSTEPID = 5;
    private static final int INDEX_PREVWFSTEPNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_WFACTORID = 9;
    private static final int INDEX_WFACTORNAME = 10;
    private static final int INDEX_WFTMPSTEPACTORID = 11;
    private static final int INDEX_WFTMPSTEPACTORNAME = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFTmpStepActorBase proxyWFTmpStepActorBase = null;
    private boolean connectionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prevprocessDirtyFlag = false;
    private boolean prevwfstepidDirtyFlag = false;
    private boolean prevwfstepnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfactoridDirtyFlag = false;
    private boolean wfactornameDirtyFlag = false;
    private boolean wftmpstepactoridDirtyFlag = false;
    private boolean wftmpstepactornameDirtyFlag = false;
    @Column(name="connection")
    private String connection;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="prevprocess")
    private String prevprocess;
    @Column(name="prevwfstepid")
    private String prevwfstepid;
    @Column(name="prevwfstepname")
    private String prevwfstepname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfactorid")
    private String wfactorid;
    @Column(name="wfactorname")
    private String wfactorname;
    @Column(name="wftmpstepactorid")
    private String wftmpstepactorid;
    @Column(name="wftmpstepactorname")
    private String wftmpstepactorname;
    private Integer objWFActorLock = new Integer(1);
    private WFActor wfactor = null;
    private Integer objWFStepLock = new Integer(1);
    private WFStep wfstep = null;

    static {
        fieldIndexMap.put(FIELD_CONNECTION, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PREVPROCESS, 4);
        fieldIndexMap.put(FIELD_PREVWFSTEPID, 5);
        fieldIndexMap.put(FIELD_PREVWFSTEPNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_WFACTORID, 9);
        fieldIndexMap.put(FIELD_WFACTORNAME, 10);
        fieldIndexMap.put(FIELD_WFTMPSTEPACTORID, 11);
        fieldIndexMap.put(FIELD_WFTMPSTEPACTORNAME, 12);
    }

    public void setConnection(String connection) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnection(connection);
            return;
        }
        if (connection != null && (connection = StringHelper.trimRight(connection)).length() == 0) {
            connection = null;
        }
        this.connection = connection;
        this.connectionDirtyFlag = true;
    }

    public String getConnection() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnection();
        }
        return this.connection;
    }

    public boolean isConnectionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnectionDirty();
        }
        return this.connectionDirtyFlag;
    }

    public void resetConnection() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnection();
            return;
        }
        this.connectionDirtyFlag = false;
        this.connection = null;
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

    public void setPrevProcess(String prevprocess) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevProcess(prevprocess);
            return;
        }
        if (prevprocess != null && (prevprocess = StringHelper.trimRight(prevprocess)).length() == 0) {
            prevprocess = null;
        }
        this.prevprocess = prevprocess;
        this.prevprocessDirtyFlag = true;
    }

    public String getPrevProcess() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevProcess();
        }
        return this.prevprocess;
    }

    public boolean isPrevProcessDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevProcessDirty();
        }
        return this.prevprocessDirtyFlag;
    }

    public void resetPrevProcess() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevProcess();
            return;
        }
        this.prevprocessDirtyFlag = false;
        this.prevprocess = null;
    }

    public void setPrevWFStepId(String prevwfstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevWFStepId(prevwfstepid);
            return;
        }
        if (prevwfstepid != null && (prevwfstepid = StringHelper.trimRight(prevwfstepid)).length() == 0) {
            prevwfstepid = null;
        }
        this.prevwfstepid = prevwfstepid;
        this.prevwfstepidDirtyFlag = true;
    }

    public String getPrevWFStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevWFStepId();
        }
        return this.prevwfstepid;
    }

    public boolean isPrevWFStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevWFStepIdDirty();
        }
        return this.prevwfstepidDirtyFlag;
    }

    public void resetPrevWFStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevWFStepId();
            return;
        }
        this.prevwfstepidDirtyFlag = false;
        this.prevwfstepid = null;
    }

    public void setPrevWFStepName(String prevwfstepname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevWFStepName(prevwfstepname);
            return;
        }
        if (prevwfstepname != null && (prevwfstepname = StringHelper.trimRight(prevwfstepname)).length() == 0) {
            prevwfstepname = null;
        }
        this.prevwfstepname = prevwfstepname;
        this.prevwfstepnameDirtyFlag = true;
    }

    public String getPrevWFStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevWFStepName();
        }
        return this.prevwfstepname;
    }

    public boolean isPrevWFStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevWFStepNameDirty();
        }
        return this.prevwfstepnameDirtyFlag;
    }

    public void resetPrevWFStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevWFStepName();
            return;
        }
        this.prevwfstepnameDirtyFlag = false;
        this.prevwfstepname = null;
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

    public void setWFActorId(String wfactorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorId(wfactorid);
            return;
        }
        if (wfactorid != null && (wfactorid = StringHelper.trimRight(wfactorid)).length() == 0) {
            wfactorid = null;
        }
        this.wfactorid = wfactorid;
        this.wfactoridDirtyFlag = true;
    }

    public String getWFActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorId();
        }
        return this.wfactorid;
    }

    public boolean isWFActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorIdDirty();
        }
        return this.wfactoridDirtyFlag;
    }

    public void resetWFActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorId();
            return;
        }
        this.wfactoridDirtyFlag = false;
        this.wfactorid = null;
    }

    public void setWFActorName(String wfactorname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorName(wfactorname);
            return;
        }
        if (wfactorname != null && (wfactorname = StringHelper.trimRight(wfactorname)).length() == 0) {
            wfactorname = null;
        }
        this.wfactorname = wfactorname;
        this.wfactornameDirtyFlag = true;
    }

    public String getWFActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorName();
        }
        return this.wfactorname;
    }

    public boolean isWFActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorNameDirty();
        }
        return this.wfactornameDirtyFlag;
    }

    public void resetWFActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorName();
            return;
        }
        this.wfactornameDirtyFlag = false;
        this.wfactorname = null;
    }

    public void setWFTmpStepActorId(String wftmpstepactorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFTmpStepActorId(wftmpstepactorid);
            return;
        }
        if (wftmpstepactorid != null && (wftmpstepactorid = StringHelper.trimRight(wftmpstepactorid)).length() == 0) {
            wftmpstepactorid = null;
        }
        this.wftmpstepactorid = wftmpstepactorid;
        this.wftmpstepactoridDirtyFlag = true;
    }

    public String getWFTmpStepActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFTmpStepActorId();
        }
        return this.wftmpstepactorid;
    }

    public boolean isWFTmpStepActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTmpStepActorIdDirty();
        }
        return this.wftmpstepactoridDirtyFlag;
    }

    public void resetWFTmpStepActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFTmpStepActorId();
            return;
        }
        this.wftmpstepactoridDirtyFlag = false;
        this.wftmpstepactorid = null;
    }

    public void setWFTmpStepActorName(String wftmpstepactorname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFTmpStepActorName(wftmpstepactorname);
            return;
        }
        if (wftmpstepactorname != null && (wftmpstepactorname = StringHelper.trimRight(wftmpstepactorname)).length() == 0) {
            wftmpstepactorname = null;
        }
        this.wftmpstepactorname = wftmpstepactorname;
        this.wftmpstepactornameDirtyFlag = true;
    }

    public String getWFTmpStepActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFTmpStepActorName();
        }
        return this.wftmpstepactorname;
    }

    public boolean isWFTmpStepActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFTmpStepActorNameDirty();
        }
        return this.wftmpstepactornameDirtyFlag;
    }

    public void resetWFTmpStepActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFTmpStepActorName();
            return;
        }
        this.wftmpstepactornameDirtyFlag = false;
        this.wftmpstepactorname = null;
    }

    @Override
    protected void onReset() {
        WFTmpStepActorBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFTmpStepActorBase et) {
        et.resetConnection();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetPrevProcess();
        et.resetPrevWFStepId();
        et.resetPrevWFStepName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFActorId();
        et.resetWFActorName();
        et.resetWFTmpStepActorId();
        et.resetWFTmpStepActorName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isConnectionDirty()) {
            params.put(FIELD_CONNECTION, this.getConnection());
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
        if (!bDirtyOnly || this.isPrevProcessDirty()) {
            params.put(FIELD_PREVPROCESS, this.getPrevProcess());
        }
        if (!bDirtyOnly || this.isPrevWFStepIdDirty()) {
            params.put(FIELD_PREVWFSTEPID, this.getPrevWFStepId());
        }
        if (!bDirtyOnly || this.isPrevWFStepNameDirty()) {
            params.put(FIELD_PREVWFSTEPNAME, this.getPrevWFStepName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFActorIdDirty()) {
            params.put(FIELD_WFACTORID, this.getWFActorId());
        }
        if (!bDirtyOnly || this.isWFActorNameDirty()) {
            params.put(FIELD_WFACTORNAME, this.getWFActorName());
        }
        if (!bDirtyOnly || this.isWFTmpStepActorIdDirty()) {
            params.put(FIELD_WFTMPSTEPACTORID, this.getWFTmpStepActorId());
        }
        if (!bDirtyOnly || this.isWFTmpStepActorNameDirty()) {
            params.put(FIELD_WFTMPSTEPACTORNAME, this.getWFTmpStepActorName());
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
        return WFTmpStepActorBase.get(this, index);
    }

    private static Object get(WFTmpStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getConnection();
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
                return et.getPrevProcess();
            }
            case 5: {
                return et.getPrevWFStepId();
            }
            case 6: {
                return et.getPrevWFStepName();
            }
            case 7: {
                return et.getUpdateDate();
            }
            case 8: {
                return et.getUpdateMan();
            }
            case 9: {
                return et.getWFActorId();
            }
            case 10: {
                return et.getWFActorName();
            }
            case 11: {
                return et.getWFTmpStepActorId();
            }
            case 12: {
                return et.getWFTmpStepActorName();
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
        WFTmpStepActorBase.set(this, index, objValue);
    }

    private static void set(WFTmpStepActorBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setConnection(DataObject.getStringValue(obj));
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
                et.setPrevProcess(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setPrevWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setPrevWFStepName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 8: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFActorId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFActorName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWFTmpStepActorId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWFTmpStepActorName(DataObject.getStringValue(obj));
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
        return WFTmpStepActorBase.isNull(this, index);
    }

    private static boolean isNull(WFTmpStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getConnection() == null;
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
                return et.getPrevProcess() == null;
            }
            case 5: {
                return et.getPrevWFStepId() == null;
            }
            case 6: {
                return et.getPrevWFStepName() == null;
            }
            case 7: {
                return et.getUpdateDate() == null;
            }
            case 8: {
                return et.getUpdateMan() == null;
            }
            case 9: {
                return et.getWFActorId() == null;
            }
            case 10: {
                return et.getWFActorName() == null;
            }
            case 11: {
                return et.getWFTmpStepActorId() == null;
            }
            case 12: {
                return et.getWFTmpStepActorName() == null;
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
        return WFTmpStepActorBase.contains(this, index);
    }

    private static boolean contains(WFTmpStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isConnectionDirty();
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
                return et.isPrevProcessDirty();
            }
            case 5: {
                return et.isPrevWFStepIdDirty();
            }
            case 6: {
                return et.isPrevWFStepNameDirty();
            }
            case 7: {
                return et.isUpdateDateDirty();
            }
            case 8: {
                return et.isUpdateManDirty();
            }
            case 9: {
                return et.isWFActorIdDirty();
            }
            case 10: {
                return et.isWFActorNameDirty();
            }
            case 11: {
                return et.isWFTmpStepActorIdDirty();
            }
            case 12: {
                return et.isWFTmpStepActorNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFTmpStepActorBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFTmpStepActorBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getConnection() != null) {
            JSONObjectHelper.put(json, "connection", WFTmpStepActorBase.getJSONValue(et.getConnection()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFTmpStepActorBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFTmpStepActorBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFTmpStepActorBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getPrevProcess() != null) {
            JSONObjectHelper.put(json, "prevprocess", WFTmpStepActorBase.getJSONValue(et.getPrevProcess()), false);
        }
        if (bIncEmpty || et.getPrevWFStepId() != null) {
            JSONObjectHelper.put(json, "prevwfstepid", WFTmpStepActorBase.getJSONValue(et.getPrevWFStepId()), false);
        }
        if (bIncEmpty || et.getPrevWFStepName() != null) {
            JSONObjectHelper.put(json, "prevwfstepname", WFTmpStepActorBase.getJSONValue(et.getPrevWFStepName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFTmpStepActorBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFTmpStepActorBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFActorId() != null) {
            JSONObjectHelper.put(json, "wfactorid", WFTmpStepActorBase.getJSONValue(et.getWFActorId()), false);
        }
        if (bIncEmpty || et.getWFActorName() != null) {
            JSONObjectHelper.put(json, "wfactorname", WFTmpStepActorBase.getJSONValue(et.getWFActorName()), false);
        }
        if (bIncEmpty || et.getWFTmpStepActorId() != null) {
            JSONObjectHelper.put(json, "wftmpstepactorid", WFTmpStepActorBase.getJSONValue(et.getWFTmpStepActorId()), false);
        }
        if (bIncEmpty || et.getWFTmpStepActorName() != null) {
            JSONObjectHelper.put(json, "wftmpstepactorname", WFTmpStepActorBase.getJSONValue(et.getWFTmpStepActorName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFTmpStepActorBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFTmpStepActorBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getConnection() != null) {
            obj = et.getConnection();
            node.setAttribute(FIELD_CONNECTION, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getPrevProcess() != null) {
            obj = et.getPrevProcess();
            node.setAttribute(FIELD_PREVPROCESS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPrevWFStepId() != null) {
            obj = et.getPrevWFStepId();
            node.setAttribute(FIELD_PREVWFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPrevWFStepName() != null) {
            obj = et.getPrevWFStepName();
            node.setAttribute(FIELD_PREVWFSTEPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorId() != null) {
            obj = et.getWFActorId();
            node.setAttribute(FIELD_WFACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorName() != null) {
            obj = et.getWFActorName();
            node.setAttribute(FIELD_WFACTORNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFTmpStepActorId() != null) {
            obj = et.getWFTmpStepActorId();
            node.setAttribute(FIELD_WFTMPSTEPACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFTmpStepActorName() != null) {
            obj = et.getWFTmpStepActorName();
            node.setAttribute(FIELD_WFTMPSTEPACTORNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFTmpStepActorBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFTmpStepActorBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isConnectionDirty() && (bIncEmpty || et.getConnection() != null)) {
            dst.set(FIELD_CONNECTION, et.getConnection());
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
        if (et.isPrevProcessDirty() && (bIncEmpty || et.getPrevProcess() != null)) {
            dst.set(FIELD_PREVPROCESS, et.getPrevProcess());
        }
        if (et.isPrevWFStepIdDirty() && (bIncEmpty || et.getPrevWFStepId() != null)) {
            dst.set(FIELD_PREVWFSTEPID, et.getPrevWFStepId());
        }
        if (et.isPrevWFStepNameDirty() && (bIncEmpty || et.getPrevWFStepName() != null)) {
            dst.set(FIELD_PREVWFSTEPNAME, et.getPrevWFStepName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFActorIdDirty() && (bIncEmpty || et.getWFActorId() != null)) {
            dst.set(FIELD_WFACTORID, et.getWFActorId());
        }
        if (et.isWFActorNameDirty() && (bIncEmpty || et.getWFActorName() != null)) {
            dst.set(FIELD_WFACTORNAME, et.getWFActorName());
        }
        if (et.isWFTmpStepActorIdDirty() && (bIncEmpty || et.getWFTmpStepActorId() != null)) {
            dst.set(FIELD_WFTMPSTEPACTORID, et.getWFTmpStepActorId());
        }
        if (et.isWFTmpStepActorNameDirty() && (bIncEmpty || et.getWFTmpStepActorName() != null)) {
            dst.set(FIELD_WFTMPSTEPACTORNAME, et.getWFTmpStepActorName());
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
        return WFTmpStepActorBase.remove(this, index);
    }

    private static boolean remove(WFTmpStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetConnection();
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
                et.resetPrevProcess();
                return true;
            }
            case 5: {
                et.resetPrevWFStepId();
                return true;
            }
            case 6: {
                et.resetPrevWFStepName();
                return true;
            }
            case 7: {
                et.resetUpdateDate();
                return true;
            }
            case 8: {
                et.resetUpdateMan();
                return true;
            }
            case 9: {
                et.resetWFActorId();
                return true;
            }
            case 10: {
                et.resetWFActorName();
                return true;
            }
            case 11: {
                et.resetWFTmpStepActorId();
                return true;
            }
            case 12: {
                et.resetWFTmpStepActorName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFActor getWFActor() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActor();
        }
        if (this.getWFActorId() == null) {
            return null;
        }
        Integer n = this.objWFActorLock;
        synchronized (n) {
            if (this.wfactor != null && DataTypeHelper.compare(25, (Object)this.getWFActorId(), (Object)this.wfactor.getWFActorId()) != 0L) {
                this.wfactor = null;
            }
            if (this.wfactor == null) {
                WFActor wfactor = new WFActor();
                wfactor.setWFActorId(this.getWFActorId());
                WFActorService service = (WFActorService)ServiceGlobal.getService(WFActorService.class, this.getSessionFactory());
                service.autoGet(wfactor);
                this.wfactor = wfactor;
            }
            return this.wfactor;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFStep getWFStep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStep();
        }
        if (this.getPrevWFStepId() == null) {
            return null;
        }
        Integer n = this.objWFStepLock;
        synchronized (n) {
            if (this.wfstep != null && DataTypeHelper.compare(25, (Object)this.getPrevWFStepId(), (Object)this.wfstep.getWFStepId()) != 0L) {
                this.wfstep = null;
            }
            if (this.wfstep == null) {
                WFStep wfstep = new WFStep();
                wfstep.setWFStepId(this.getPrevWFStepId());
                WFStepService service = (WFStepService)ServiceGlobal.getService(WFStepService.class, this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }

    private WFTmpStepActorBase getProxyEntity() {
        return this.proxyWFTmpStepActorBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFTmpStepActorBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFTmpStepActorBase) {
            this.proxyWFTmpStepActorBase = (WFTmpStepActorBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

