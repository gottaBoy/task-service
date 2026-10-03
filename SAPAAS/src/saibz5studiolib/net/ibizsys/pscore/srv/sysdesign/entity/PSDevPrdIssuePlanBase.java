/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdIssuePlanBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdIssuePlanBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLANSTATE = "PLANSTATE";
    public static final String FIELD_PSDEVPRDISSUEID = "PSDEVPRDISSUEID";
    public static final String FIELD_PSDEVPRDISSUENAME = "PSDEVPRDISSUENAME";
    public static final String FIELD_PSDEVPRDISSUEPLANID = "PSDEVPRDISSUEPLANID";
    public static final String FIELD_PSDEVPRDISSUEPLANNAME = "PSDEVPRDISSUEPLANNAME";
    public static final String FIELD_PSDEVPRDSUBVERID = "PSDEVPRDSUBVERID";
    public static final String FIELD_PSDEVPRDSUBVERNAME = "PSDEVPRDSUBVERNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PLANSTATE = 4;
    private static final int INDEX_PSDEVPRDISSUEID = 5;
    private static final int INDEX_PSDEVPRDISSUENAME = 6;
    private static final int INDEX_PSDEVPRDISSUEPLANID = 7;
    private static final int INDEX_PSDEVPRDISSUEPLANNAME = 8;
    private static final int INDEX_PSDEVPRDSUBVERID = 9;
    private static final int INDEX_PSDEVPRDSUBVERNAME = 10;
    private static final int INDEX_PSDEVPRDVERID = 11;
    private static final int INDEX_PSDEVPRDVERNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdIssuePlanBase proxyPSDevPrdIssuePlanBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean planstateDirtyFlag = false;
    private boolean psdevprdissueidDirtyFlag = false;
    private boolean psdevprdissuenameDirtyFlag = false;
    private boolean psdevprdissueplanidDirtyFlag = false;
    private boolean psdevprdissueplannameDirtyFlag = false;
    private boolean psdevprdsubveridDirtyFlag = false;
    private boolean psdevprdsubvernameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="planstate")
    private Integer planstate;
    @Column(name="psdevprdissueid")
    private String psdevprdissueid;
    @Column(name="psdevprdissuename")
    private String psdevprdissuename;
    @Column(name="psdevprdissueplanid")
    private String psdevprdissueplanid;
    @Column(name="psdevprdissueplanname")
    private String psdevprdissueplanname;
    @Column(name="psdevprdsubverid")
    private String psdevprdsubverid;
    @Column(name="psdevprdsubvername")
    private String psdevprdsubvername;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevPrdIssueLock = new Integer(1);
    private PSDevPrdIssue psdevprdissue = null;
    private Integer objPSDevPrdSubVerLock = new Integer(1);
    private PSDevPrdSubVer psdevprdsubver = null;
    private Integer objPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer psdevprdver = null;

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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPlanState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlanState(n);
            return;
        }
        this.planstate = n;
        this.planstateDirtyFlag = true;
    }

    public Integer getPlanState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlanState();
        }
        return this.planstate;
    }

    public boolean isPlanStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlanStateDirty();
        }
        return this.planstateDirtyFlag;
    }

    public void resetPlanState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlanState();
            return;
        }
        this.planstateDirtyFlag = false;
        this.planstate = null;
    }

    public void setPSDevPrdIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdissueid = string;
        this.psdevprdissueidDirtyFlag = true;
    }

    public String getPSDevPrdIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssueId();
        }
        return this.psdevprdissueid;
    }

    public boolean isPSDevPrdIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIssueIdDirty();
        }
        return this.psdevprdissueidDirtyFlag;
    }

    public void resetPSDevPrdIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdIssueId();
            return;
        }
        this.psdevprdissueidDirtyFlag = false;
        this.psdevprdissueid = null;
    }

    public void setPSDevPrdIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdissuename = string;
        this.psdevprdissuenameDirtyFlag = true;
    }

    public String getPSDevPrdIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssueName();
        }
        return this.psdevprdissuename;
    }

    public boolean isPSDevPrdIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIssueNameDirty();
        }
        return this.psdevprdissuenameDirtyFlag;
    }

    public void resetPSDevPrdIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdIssueName();
            return;
        }
        this.psdevprdissuenameDirtyFlag = false;
        this.psdevprdissuename = null;
    }

    public void setPSDevPrdIssuePlanId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdIssuePlanId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdissueplanid = string;
        this.psdevprdissueplanidDirtyFlag = true;
    }

    public String getPSDevPrdIssuePlanId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssuePlanId();
        }
        return this.psdevprdissueplanid;
    }

    public boolean isPSDevPrdIssuePlanIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIssuePlanIdDirty();
        }
        return this.psdevprdissueplanidDirtyFlag;
    }

    public void resetPSDevPrdIssuePlanId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdIssuePlanId();
            return;
        }
        this.psdevprdissueplanidDirtyFlag = false;
        this.psdevprdissueplanid = null;
    }

    public void setPSDevPrdIssuePlanName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdIssuePlanName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdissueplanname = string;
        this.psdevprdissueplannameDirtyFlag = true;
    }

    public String getPSDevPrdIssuePlanName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssuePlanName();
        }
        return this.psdevprdissueplanname;
    }

    public boolean isPSDevPrdIssuePlanNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIssuePlanNameDirty();
        }
        return this.psdevprdissueplannameDirtyFlag;
    }

    public void resetPSDevPrdIssuePlanName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdIssuePlanName();
            return;
        }
        this.psdevprdissueplannameDirtyFlag = false;
        this.psdevprdissueplanname = null;
    }

    public void setPSDevPrdSubVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubverid = string;
        this.psdevprdsubveridDirtyFlag = true;
    }

    public String getPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerId();
        }
        return this.psdevprdsubverid;
    }

    public boolean isPSDevPrdSubVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerIdDirty();
        }
        return this.psdevprdsubveridDirtyFlag;
    }

    public void resetPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerId();
            return;
        }
        this.psdevprdsubveridDirtyFlag = false;
        this.psdevprdsubverid = null;
    }

    public void setPSDevPrdSubVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubvername = string;
        this.psdevprdsubvernameDirtyFlag = true;
    }

    public String getPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerName();
        }
        return this.psdevprdsubvername;
    }

    public boolean isPSDevPrdSubVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerNameDirty();
        }
        return this.psdevprdsubvernameDirtyFlag;
    }

    public void resetPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerName();
            return;
        }
        this.psdevprdsubvernameDirtyFlag = false;
        this.psdevprdsubvername = null;
    }

    public void setPSDevPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdverid = string;
        this.psdevprdveridDirtyFlag = true;
    }

    public String getPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerId();
        }
        return this.psdevprdverid;
    }

    public boolean isPSDevPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerIdDirty();
        }
        return this.psdevprdveridDirtyFlag;
    }

    public void resetPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerId();
            return;
        }
        this.psdevprdveridDirtyFlag = false;
        this.psdevprdverid = null;
    }

    public void setPSDevPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdvername = string;
        this.psdevprdvernameDirtyFlag = true;
    }

    public String getPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerName();
        }
        return this.psdevprdvername;
    }

    public boolean isPSDevPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerNameDirty();
        }
        return this.psdevprdvernameDirtyFlag;
    }

    public void resetPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerName();
            return;
        }
        this.psdevprdvernameDirtyFlag = false;
        this.psdevprdvername = null;
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
        PSDevPrdIssuePlanBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase) {
        pSDevPrdIssuePlanBase.resetCreateDate();
        pSDevPrdIssuePlanBase.resetCreateMan();
        pSDevPrdIssuePlanBase.resetMemo();
        pSDevPrdIssuePlanBase.resetOrderValue();
        pSDevPrdIssuePlanBase.resetPlanState();
        pSDevPrdIssuePlanBase.resetPSDevPrdIssueId();
        pSDevPrdIssuePlanBase.resetPSDevPrdIssueName();
        pSDevPrdIssuePlanBase.resetPSDevPrdIssuePlanId();
        pSDevPrdIssuePlanBase.resetPSDevPrdIssuePlanName();
        pSDevPrdIssuePlanBase.resetPSDevPrdSubVerId();
        pSDevPrdIssuePlanBase.resetPSDevPrdSubVerName();
        pSDevPrdIssuePlanBase.resetPSDevPrdVerId();
        pSDevPrdIssuePlanBase.resetPSDevPrdVerName();
        pSDevPrdIssuePlanBase.resetUpdateDate();
        pSDevPrdIssuePlanBase.resetUpdateMan();
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPlanStateDirty()) {
            hashMap.put(FIELD_PLANSTATE, this.getPlanState());
        }
        if (!bl || this.isPSDevPrdIssueIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDISSUEID, this.getPSDevPrdIssueId());
        }
        if (!bl || this.isPSDevPrdIssueNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDISSUENAME, this.getPSDevPrdIssueName());
        }
        if (!bl || this.isPSDevPrdIssuePlanIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDISSUEPLANID, this.getPSDevPrdIssuePlanId());
        }
        if (!bl || this.isPSDevPrdIssuePlanNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDISSUEPLANNAME, this.getPSDevPrdIssuePlanName());
        }
        if (!bl || this.isPSDevPrdSubVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERID, this.getPSDevPrdSubVerId());
        }
        if (!bl || this.isPSDevPrdSubVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERNAME, this.getPSDevPrdSubVerName());
        }
        if (!bl || this.isPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERID, this.getPSDevPrdVerId());
        }
        if (!bl || this.isPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERNAME, this.getPSDevPrdVerName());
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
        return PSDevPrdIssuePlanBase.get(this, n);
    }

    private static Object get(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdIssuePlanBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdIssuePlanBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdIssuePlanBase.getMemo();
            }
            case 3: {
                return pSDevPrdIssuePlanBase.getOrderValue();
            }
            case 4: {
                return pSDevPrdIssuePlanBase.getPlanState();
            }
            case 5: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssueId();
            }
            case 6: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssueName();
            }
            case 7: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId();
            }
            case 8: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName();
            }
            case 9: {
                return pSDevPrdIssuePlanBase.getPSDevPrdSubVerId();
            }
            case 10: {
                return pSDevPrdIssuePlanBase.getPSDevPrdSubVerName();
            }
            case 11: {
                return pSDevPrdIssuePlanBase.getPSDevPrdVerId();
            }
            case 12: {
                return pSDevPrdIssuePlanBase.getPSDevPrdVerName();
            }
            case 13: {
                return pSDevPrdIssuePlanBase.getUpdateDate();
            }
            case 14: {
                return pSDevPrdIssuePlanBase.getUpdateMan();
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
        PSDevPrdIssuePlanBase.set(this, n, object);
    }

    private static void set(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdIssuePlanBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdIssuePlanBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdIssuePlanBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdIssuePlanBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdIssuePlanBase.setPlanState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdIssuePlanBase.setPSDevPrdIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdIssuePlanBase.setPSDevPrdIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdIssuePlanBase.setPSDevPrdIssuePlanId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdIssuePlanBase.setPSDevPrdIssuePlanName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdIssuePlanBase.setPSDevPrdSubVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdIssuePlanBase.setPSDevPrdSubVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdIssuePlanBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdIssuePlanBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdIssuePlanBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDevPrdIssuePlanBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevPrdIssuePlanBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdIssuePlanBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdIssuePlanBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdIssuePlanBase.getMemo() == null;
            }
            case 3: {
                return pSDevPrdIssuePlanBase.getOrderValue() == null;
            }
            case 4: {
                return pSDevPrdIssuePlanBase.getPlanState() == null;
            }
            case 5: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssueId() == null;
            }
            case 6: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssueName() == null;
            }
            case 7: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId() == null;
            }
            case 8: {
                return pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName() == null;
            }
            case 9: {
                return pSDevPrdIssuePlanBase.getPSDevPrdSubVerId() == null;
            }
            case 10: {
                return pSDevPrdIssuePlanBase.getPSDevPrdSubVerName() == null;
            }
            case 11: {
                return pSDevPrdIssuePlanBase.getPSDevPrdVerId() == null;
            }
            case 12: {
                return pSDevPrdIssuePlanBase.getPSDevPrdVerName() == null;
            }
            case 13: {
                return pSDevPrdIssuePlanBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDevPrdIssuePlanBase.getUpdateMan() == null;
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
        return PSDevPrdIssuePlanBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdIssuePlanBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdIssuePlanBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdIssuePlanBase.isMemoDirty();
            }
            case 3: {
                return pSDevPrdIssuePlanBase.isOrderValueDirty();
            }
            case 4: {
                return pSDevPrdIssuePlanBase.isPlanStateDirty();
            }
            case 5: {
                return pSDevPrdIssuePlanBase.isPSDevPrdIssueIdDirty();
            }
            case 6: {
                return pSDevPrdIssuePlanBase.isPSDevPrdIssueNameDirty();
            }
            case 7: {
                return pSDevPrdIssuePlanBase.isPSDevPrdIssuePlanIdDirty();
            }
            case 8: {
                return pSDevPrdIssuePlanBase.isPSDevPrdIssuePlanNameDirty();
            }
            case 9: {
                return pSDevPrdIssuePlanBase.isPSDevPrdSubVerIdDirty();
            }
            case 10: {
                return pSDevPrdIssuePlanBase.isPSDevPrdSubVerNameDirty();
            }
            case 11: {
                return pSDevPrdIssuePlanBase.isPSDevPrdVerIdDirty();
            }
            case 12: {
                return pSDevPrdIssuePlanBase.isPSDevPrdVerNameDirty();
            }
            case 13: {
                return pSDevPrdIssuePlanBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDevPrdIssuePlanBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdIssuePlanBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdIssuePlanBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPlanState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planstate", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPlanState()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdissueid", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdIssueId()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdissuename", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdIssueName()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdissueplanid", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdissueplanname", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdSubVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubverid", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdSubVerId()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdSubVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubvername", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdSubVerName()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdIssuePlanBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdIssuePlanBase.getJSONValue((Object)pSDevPrdIssuePlanBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdIssuePlanBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdIssuePlanBase.getCreateDate() != null) {
            object = pSDevPrdIssuePlanBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdIssuePlanBase.getCreateMan() != null) {
            object = pSDevPrdIssuePlanBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getMemo() != null) {
            object = pSDevPrdIssuePlanBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getOrderValue() != null) {
            object = pSDevPrdIssuePlanBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdIssuePlanBase.getPlanState() != null) {
            object = pSDevPrdIssuePlanBase.getPlanState();
            xmlNode.setAttribute(FIELD_PLANSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssueId() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdIssueId();
            xmlNode.setAttribute(FIELD_PSDEVPRDISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssueName() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdIssueName();
            xmlNode.setAttribute(FIELD_PSDEVPRDISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId();
            xmlNode.setAttribute(FIELD_PSDEVPRDISSUEPLANID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName();
            xmlNode.setAttribute(FIELD_PSDEVPRDISSUEPLANNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdSubVerId() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdSubVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdSubVerName() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdSubVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdVerId() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getPSDevPrdVerName() != null) {
            object = pSDevPrdIssuePlanBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssuePlanBase.getUpdateDate() != null) {
            object = pSDevPrdIssuePlanBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdIssuePlanBase.getUpdateMan() != null) {
            object = pSDevPrdIssuePlanBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdIssuePlanBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdIssuePlanBase.isCreateDateDirty() && (bl || pSDevPrdIssuePlanBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdIssuePlanBase.getCreateDate());
        }
        if (pSDevPrdIssuePlanBase.isCreateManDirty() && (bl || pSDevPrdIssuePlanBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdIssuePlanBase.getCreateMan());
        }
        if (pSDevPrdIssuePlanBase.isMemoDirty() && (bl || pSDevPrdIssuePlanBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdIssuePlanBase.getMemo());
        }
        if (pSDevPrdIssuePlanBase.isOrderValueDirty() && (bl || pSDevPrdIssuePlanBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevPrdIssuePlanBase.getOrderValue());
        }
        if (pSDevPrdIssuePlanBase.isPlanStateDirty() && (bl || pSDevPrdIssuePlanBase.getPlanState() != null)) {
            iDataObject.set(FIELD_PLANSTATE, (Object)pSDevPrdIssuePlanBase.getPlanState());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdIssueIdDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssueId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDISSUEID, (Object)pSDevPrdIssuePlanBase.getPSDevPrdIssueId());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdIssueNameDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssueName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDISSUENAME, (Object)pSDevPrdIssuePlanBase.getPSDevPrdIssueName());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdIssuePlanIdDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDISSUEPLANID, (Object)pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanId());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdIssuePlanNameDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDISSUEPLANNAME, (Object)pSDevPrdIssuePlanBase.getPSDevPrdIssuePlanName());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdSubVerIdDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdSubVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERID, (Object)pSDevPrdIssuePlanBase.getPSDevPrdSubVerId());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdSubVerNameDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdSubVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERNAME, (Object)pSDevPrdIssuePlanBase.getPSDevPrdSubVerName());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdVerIdDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSDevPrdIssuePlanBase.getPSDevPrdVerId());
        }
        if (pSDevPrdIssuePlanBase.isPSDevPrdVerNameDirty() && (bl || pSDevPrdIssuePlanBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSDevPrdIssuePlanBase.getPSDevPrdVerName());
        }
        if (pSDevPrdIssuePlanBase.isUpdateDateDirty() && (bl || pSDevPrdIssuePlanBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdIssuePlanBase.getUpdateDate());
        }
        if (pSDevPrdIssuePlanBase.isUpdateManDirty() && (bl || pSDevPrdIssuePlanBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdIssuePlanBase.getUpdateMan());
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
        return PSDevPrdIssuePlanBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdIssuePlanBase pSDevPrdIssuePlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdIssuePlanBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdIssuePlanBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdIssuePlanBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevPrdIssuePlanBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSDevPrdIssuePlanBase.resetPlanState();
                return true;
            }
            case 5: {
                pSDevPrdIssuePlanBase.resetPSDevPrdIssueId();
                return true;
            }
            case 6: {
                pSDevPrdIssuePlanBase.resetPSDevPrdIssueName();
                return true;
            }
            case 7: {
                pSDevPrdIssuePlanBase.resetPSDevPrdIssuePlanId();
                return true;
            }
            case 8: {
                pSDevPrdIssuePlanBase.resetPSDevPrdIssuePlanName();
                return true;
            }
            case 9: {
                pSDevPrdIssuePlanBase.resetPSDevPrdSubVerId();
                return true;
            }
            case 10: {
                pSDevPrdIssuePlanBase.resetPSDevPrdSubVerName();
                return true;
            }
            case 11: {
                pSDevPrdIssuePlanBase.resetPSDevPrdVerId();
                return true;
            }
            case 12: {
                pSDevPrdIssuePlanBase.resetPSDevPrdVerName();
                return true;
            }
            case 13: {
                pSDevPrdIssuePlanBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDevPrdIssuePlanBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdIssue getPSDevPrdIssue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssue();
        }
        if (this.getPSDevPrdIssueId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdIssueLock;
        synchronized (n) {
            if (this.psdevprdissue != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdIssueId(), (Object)this.psdevprdissue.getPSDevPrdIssueId()) != 0L) {
                this.psdevprdissue = null;
            }
            if (this.psdevprdissue == null) {
                PSDevPrdIssue pSDevPrdIssue = new PSDevPrdIssue();
                pSDevPrdIssue.setPSDevPrdIssueId(this.getPSDevPrdIssueId());
                PSDevPrdIssueService pSDevPrdIssueService = (PSDevPrdIssueService)ServiceGlobal.getService(PSDevPrdIssueService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdIssueService.autoGet(pSDevPrdIssue);
                this.psdevprdissue = pSDevPrdIssue;
            }
            return this.psdevprdissue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSubVer getPSDevPrdSubVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVer();
        }
        if (this.getPSDevPrdSubVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdSubVerLock;
        synchronized (n) {
            if (this.psdevprdsubver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdSubVerId(), (Object)this.psdevprdsubver.getPSDevPrdSubVerId()) != 0L) {
                this.psdevprdsubver = null;
            }
            if (this.psdevprdsubver == null) {
                PSDevPrdSubVer pSDevPrdSubVer = new PSDevPrdSubVer();
                pSDevPrdSubVer.setPSDevPrdSubVerId(this.getPSDevPrdSubVerId());
                PSDevPrdSubVerService pSDevPrdSubVerService = (PSDevPrdSubVerService)ServiceGlobal.getService(PSDevPrdSubVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSubVerService.autoGet(pSDevPrdSubVer);
                this.psdevprdsubver = pSDevPrdSubVer;
            }
            return this.psdevprdsubver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdVer getPSDevPrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVer();
        }
        if (this.getPSDevPrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdVerLock;
        synchronized (n) {
            if (this.psdevprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdVerId(), (Object)this.psdevprdver.getPSDevPrdVerId()) != 0L) {
                this.psdevprdver = null;
            }
            if (this.psdevprdver == null) {
                PSDevPrdVer pSDevPrdVer = new PSDevPrdVer();
                pSDevPrdVer.setPSDevPrdVerId(this.getPSDevPrdVerId());
                PSDevPrdVerService pSDevPrdVerService = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdVerService.autoGet(pSDevPrdVer);
                this.psdevprdver = pSDevPrdVer;
            }
            return this.psdevprdver;
        }
    }

    private PSDevPrdIssuePlanBase getProxyEntity() {
        return this.proxyPSDevPrdIssuePlanBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdIssuePlanBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdIssuePlanBase) {
            this.proxyPSDevPrdIssuePlanBase = (PSDevPrdIssuePlanBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssuePlanService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PLANSTATE, 4);
        fieldIndexMap.put(FIELD_PSDEVPRDISSUEID, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDISSUENAME, 6);
        fieldIndexMap.put(FIELD_PSDEVPRDISSUEPLANID, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDISSUEPLANNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERID, 9);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 11);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

