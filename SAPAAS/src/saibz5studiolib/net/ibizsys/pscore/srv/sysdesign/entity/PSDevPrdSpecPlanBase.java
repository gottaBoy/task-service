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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpec;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSpecPlanBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdSpecPlanBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLANSTATE = "PLANSTATE";
    public static final String FIELD_PSDEVPRDSPECID = "PSDEVPRDSPECID";
    public static final String FIELD_PSDEVPRDSPECNAME = "PSDEVPRDSPECNAME";
    public static final String FIELD_PSDEVPRDSPECPLANID = "PSDEVPRDSPECPLANID";
    public static final String FIELD_PSDEVPRDSPECPLANNAME = "PSDEVPRDSPECPLANNAME";
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
    private static final int INDEX_PSDEVPRDSPECID = 5;
    private static final int INDEX_PSDEVPRDSPECNAME = 6;
    private static final int INDEX_PSDEVPRDSPECPLANID = 7;
    private static final int INDEX_PSDEVPRDSPECPLANNAME = 8;
    private static final int INDEX_PSDEVPRDSUBVERID = 9;
    private static final int INDEX_PSDEVPRDSUBVERNAME = 10;
    private static final int INDEX_PSDEVPRDVERID = 11;
    private static final int INDEX_PSDEVPRDVERNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdSpecPlanBase proxyPSDevPrdSpecPlanBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean planstateDirtyFlag = false;
    private boolean psdevprdspecidDirtyFlag = false;
    private boolean psdevprdspecnameDirtyFlag = false;
    private boolean psdevprdspecplanidDirtyFlag = false;
    private boolean psdevprdspecplannameDirtyFlag = false;
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
    @Column(name="psdevprdspecid")
    private String psdevprdspecid;
    @Column(name="psdevprdspecname")
    private String psdevprdspecname;
    @Column(name="psdevprdspecplanid")
    private String psdevprdspecplanid;
    @Column(name="psdevprdspecplanname")
    private String psdevprdspecplanname;
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
    private Integer objPSDevPrdSpecLock = new Integer(1);
    private PSDevPrdSpec psdevprdspec = null;
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

    public void setPSDevPrdSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecid = string;
        this.psdevprdspecidDirtyFlag = true;
    }

    public String getPSDevPrdSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecId();
        }
        return this.psdevprdspecid;
    }

    public boolean isPSDevPrdSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecIdDirty();
        }
        return this.psdevprdspecidDirtyFlag;
    }

    public void resetPSDevPrdSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecId();
            return;
        }
        this.psdevprdspecidDirtyFlag = false;
        this.psdevprdspecid = null;
    }

    public void setPSDevPrdSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecname = string;
        this.psdevprdspecnameDirtyFlag = true;
    }

    public String getPSDevPrdSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecName();
        }
        return this.psdevprdspecname;
    }

    public boolean isPSDevPrdSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecNameDirty();
        }
        return this.psdevprdspecnameDirtyFlag;
    }

    public void resetPSDevPrdSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecName();
            return;
        }
        this.psdevprdspecnameDirtyFlag = false;
        this.psdevprdspecname = null;
    }

    public void setPSDevPrdSpecPlanId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecPlanId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecplanid = string;
        this.psdevprdspecplanidDirtyFlag = true;
    }

    public String getPSDevPrdSpecPlanId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecPlanId();
        }
        return this.psdevprdspecplanid;
    }

    public boolean isPSDevPrdSpecPlanIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecPlanIdDirty();
        }
        return this.psdevprdspecplanidDirtyFlag;
    }

    public void resetPSDevPrdSpecPlanId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecPlanId();
            return;
        }
        this.psdevprdspecplanidDirtyFlag = false;
        this.psdevprdspecplanid = null;
    }

    public void setPSDevPrdSpecPlanName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecPlanName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecplanname = string;
        this.psdevprdspecplannameDirtyFlag = true;
    }

    public String getPSDevPrdSpecPlanName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecPlanName();
        }
        return this.psdevprdspecplanname;
    }

    public boolean isPSDevPrdSpecPlanNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecPlanNameDirty();
        }
        return this.psdevprdspecplannameDirtyFlag;
    }

    public void resetPSDevPrdSpecPlanName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecPlanName();
            return;
        }
        this.psdevprdspecplannameDirtyFlag = false;
        this.psdevprdspecplanname = null;
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
        PSDevPrdSpecPlanBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase) {
        pSDevPrdSpecPlanBase.resetCreateDate();
        pSDevPrdSpecPlanBase.resetCreateMan();
        pSDevPrdSpecPlanBase.resetMemo();
        pSDevPrdSpecPlanBase.resetOrderValue();
        pSDevPrdSpecPlanBase.resetPlanState();
        pSDevPrdSpecPlanBase.resetPSDevPrdSpecId();
        pSDevPrdSpecPlanBase.resetPSDevPrdSpecName();
        pSDevPrdSpecPlanBase.resetPSDevPrdSpecPlanId();
        pSDevPrdSpecPlanBase.resetPSDevPrdSpecPlanName();
        pSDevPrdSpecPlanBase.resetPSDevPrdSubVerId();
        pSDevPrdSpecPlanBase.resetPSDevPrdSubVerName();
        pSDevPrdSpecPlanBase.resetPSDevPrdVerId();
        pSDevPrdSpecPlanBase.resetPSDevPrdVerName();
        pSDevPrdSpecPlanBase.resetUpdateDate();
        pSDevPrdSpecPlanBase.resetUpdateMan();
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
        if (!bl || this.isPSDevPrdSpecIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECID, this.getPSDevPrdSpecId());
        }
        if (!bl || this.isPSDevPrdSpecNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECNAME, this.getPSDevPrdSpecName());
        }
        if (!bl || this.isPSDevPrdSpecPlanIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECPLANID, this.getPSDevPrdSpecPlanId());
        }
        if (!bl || this.isPSDevPrdSpecPlanNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECPLANNAME, this.getPSDevPrdSpecPlanName());
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
        return PSDevPrdSpecPlanBase.get(this, n);
    }

    private static Object get(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSpecPlanBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdSpecPlanBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdSpecPlanBase.getMemo();
            }
            case 3: {
                return pSDevPrdSpecPlanBase.getOrderValue();
            }
            case 4: {
                return pSDevPrdSpecPlanBase.getPlanState();
            }
            case 5: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecId();
            }
            case 6: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecName();
            }
            case 7: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId();
            }
            case 8: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName();
            }
            case 9: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSubVerId();
            }
            case 10: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSubVerName();
            }
            case 11: {
                return pSDevPrdSpecPlanBase.getPSDevPrdVerId();
            }
            case 12: {
                return pSDevPrdSpecPlanBase.getPSDevPrdVerName();
            }
            case 13: {
                return pSDevPrdSpecPlanBase.getUpdateDate();
            }
            case 14: {
                return pSDevPrdSpecPlanBase.getUpdateMan();
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
        PSDevPrdSpecPlanBase.set(this, n, object);
    }

    private static void set(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSpecPlanBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdSpecPlanBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdSpecPlanBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdSpecPlanBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdSpecPlanBase.setPlanState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdSpecPlanBase.setPSDevPrdSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdSpecPlanBase.setPSDevPrdSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdSpecPlanBase.setPSDevPrdSpecPlanId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdSpecPlanBase.setPSDevPrdSpecPlanName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdSpecPlanBase.setPSDevPrdSubVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdSpecPlanBase.setPSDevPrdSubVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdSpecPlanBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdSpecPlanBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdSpecPlanBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDevPrdSpecPlanBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevPrdSpecPlanBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSpecPlanBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdSpecPlanBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdSpecPlanBase.getMemo() == null;
            }
            case 3: {
                return pSDevPrdSpecPlanBase.getOrderValue() == null;
            }
            case 4: {
                return pSDevPrdSpecPlanBase.getPlanState() == null;
            }
            case 5: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecId() == null;
            }
            case 6: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecName() == null;
            }
            case 7: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId() == null;
            }
            case 8: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName() == null;
            }
            case 9: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSubVerId() == null;
            }
            case 10: {
                return pSDevPrdSpecPlanBase.getPSDevPrdSubVerName() == null;
            }
            case 11: {
                return pSDevPrdSpecPlanBase.getPSDevPrdVerId() == null;
            }
            case 12: {
                return pSDevPrdSpecPlanBase.getPSDevPrdVerName() == null;
            }
            case 13: {
                return pSDevPrdSpecPlanBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDevPrdSpecPlanBase.getUpdateMan() == null;
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
        return PSDevPrdSpecPlanBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSpecPlanBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdSpecPlanBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdSpecPlanBase.isMemoDirty();
            }
            case 3: {
                return pSDevPrdSpecPlanBase.isOrderValueDirty();
            }
            case 4: {
                return pSDevPrdSpecPlanBase.isPlanStateDirty();
            }
            case 5: {
                return pSDevPrdSpecPlanBase.isPSDevPrdSpecIdDirty();
            }
            case 6: {
                return pSDevPrdSpecPlanBase.isPSDevPrdSpecNameDirty();
            }
            case 7: {
                return pSDevPrdSpecPlanBase.isPSDevPrdSpecPlanIdDirty();
            }
            case 8: {
                return pSDevPrdSpecPlanBase.isPSDevPrdSpecPlanNameDirty();
            }
            case 9: {
                return pSDevPrdSpecPlanBase.isPSDevPrdSubVerIdDirty();
            }
            case 10: {
                return pSDevPrdSpecPlanBase.isPSDevPrdSubVerNameDirty();
            }
            case 11: {
                return pSDevPrdSpecPlanBase.isPSDevPrdVerIdDirty();
            }
            case 12: {
                return pSDevPrdSpecPlanBase.isPSDevPrdVerNameDirty();
            }
            case 13: {
                return pSDevPrdSpecPlanBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDevPrdSpecPlanBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdSpecPlanBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdSpecPlanBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPlanState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planstate", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPlanState()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecid", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecId()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecname", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecName()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecplanid", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecplanname", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSubVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubverid", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdSubVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSubVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubvername", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdSubVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSpecPlanBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdSpecPlanBase.getJSONValue((Object)pSDevPrdSpecPlanBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdSpecPlanBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdSpecPlanBase.getCreateDate() != null) {
            object = pSDevPrdSpecPlanBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSpecPlanBase.getCreateMan() != null) {
            object = pSDevPrdSpecPlanBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getMemo() != null) {
            object = pSDevPrdSpecPlanBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getOrderValue() != null) {
            object = pSDevPrdSpecPlanBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSpecPlanBase.getPlanState() != null) {
            object = pSDevPrdSpecPlanBase.getPlanState();
            xmlNode.setAttribute(FIELD_PLANSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecId() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdSpecId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecName() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdSpecName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECPLANID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECPLANNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSubVerId() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdSubVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdSubVerName() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdSubVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdVerId() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getPSDevPrdVerName() != null) {
            object = pSDevPrdSpecPlanBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSpecPlanBase.getUpdateDate() != null) {
            object = pSDevPrdSpecPlanBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSpecPlanBase.getUpdateMan() != null) {
            object = pSDevPrdSpecPlanBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdSpecPlanBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdSpecPlanBase.isCreateDateDirty() && (bl || pSDevPrdSpecPlanBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdSpecPlanBase.getCreateDate());
        }
        if (pSDevPrdSpecPlanBase.isCreateManDirty() && (bl || pSDevPrdSpecPlanBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdSpecPlanBase.getCreateMan());
        }
        if (pSDevPrdSpecPlanBase.isMemoDirty() && (bl || pSDevPrdSpecPlanBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdSpecPlanBase.getMemo());
        }
        if (pSDevPrdSpecPlanBase.isOrderValueDirty() && (bl || pSDevPrdSpecPlanBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevPrdSpecPlanBase.getOrderValue());
        }
        if (pSDevPrdSpecPlanBase.isPlanStateDirty() && (bl || pSDevPrdSpecPlanBase.getPlanState() != null)) {
            iDataObject.set(FIELD_PLANSTATE, (Object)pSDevPrdSpecPlanBase.getPlanState());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdSpecIdDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECID, (Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecId());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdSpecNameDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECNAME, (Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecName());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdSpecPlanIdDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECPLANID, (Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanId());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdSpecPlanNameDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECPLANNAME, (Object)pSDevPrdSpecPlanBase.getPSDevPrdSpecPlanName());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdSubVerIdDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdSubVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERID, (Object)pSDevPrdSpecPlanBase.getPSDevPrdSubVerId());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdSubVerNameDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdSubVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERNAME, (Object)pSDevPrdSpecPlanBase.getPSDevPrdSubVerName());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdVerIdDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSDevPrdSpecPlanBase.getPSDevPrdVerId());
        }
        if (pSDevPrdSpecPlanBase.isPSDevPrdVerNameDirty() && (bl || pSDevPrdSpecPlanBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSDevPrdSpecPlanBase.getPSDevPrdVerName());
        }
        if (pSDevPrdSpecPlanBase.isUpdateDateDirty() && (bl || pSDevPrdSpecPlanBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdSpecPlanBase.getUpdateDate());
        }
        if (pSDevPrdSpecPlanBase.isUpdateManDirty() && (bl || pSDevPrdSpecPlanBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdSpecPlanBase.getUpdateMan());
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
        return PSDevPrdSpecPlanBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdSpecPlanBase pSDevPrdSpecPlanBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSpecPlanBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdSpecPlanBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdSpecPlanBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevPrdSpecPlanBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSDevPrdSpecPlanBase.resetPlanState();
                return true;
            }
            case 5: {
                pSDevPrdSpecPlanBase.resetPSDevPrdSpecId();
                return true;
            }
            case 6: {
                pSDevPrdSpecPlanBase.resetPSDevPrdSpecName();
                return true;
            }
            case 7: {
                pSDevPrdSpecPlanBase.resetPSDevPrdSpecPlanId();
                return true;
            }
            case 8: {
                pSDevPrdSpecPlanBase.resetPSDevPrdSpecPlanName();
                return true;
            }
            case 9: {
                pSDevPrdSpecPlanBase.resetPSDevPrdSubVerId();
                return true;
            }
            case 10: {
                pSDevPrdSpecPlanBase.resetPSDevPrdSubVerName();
                return true;
            }
            case 11: {
                pSDevPrdSpecPlanBase.resetPSDevPrdVerId();
                return true;
            }
            case 12: {
                pSDevPrdSpecPlanBase.resetPSDevPrdVerName();
                return true;
            }
            case 13: {
                pSDevPrdSpecPlanBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDevPrdSpecPlanBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSpec getPSDevPrdSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpec();
        }
        if (this.getPSDevPrdSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdSpecLock;
        synchronized (n) {
            if (this.psdevprdspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdSpecId(), (Object)this.psdevprdspec.getPSDevPrdSpecId()) != 0L) {
                this.psdevprdspec = null;
            }
            if (this.psdevprdspec == null) {
                PSDevPrdSpec pSDevPrdSpec = new PSDevPrdSpec();
                pSDevPrdSpec.setPSDevPrdSpecId(this.getPSDevPrdSpecId());
                PSDevPrdSpecService pSDevPrdSpecService = (PSDevPrdSpecService)ServiceGlobal.getService(PSDevPrdSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSpecService.autoGet((IEntity)pSDevPrdSpec);
                this.psdevprdspec = pSDevPrdSpec;
            }
            return this.psdevprdspec;
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
                pSDevPrdSubVerService.autoGet((IEntity)pSDevPrdSubVer);
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
                pSDevPrdVerService.autoGet((IEntity)pSDevPrdVer);
                this.psdevprdver = pSDevPrdVer;
            }
            return this.psdevprdver;
        }
    }

    private PSDevPrdSpecPlanBase getProxyEntity() {
        return this.proxyPSDevPrdSpecPlanBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdSpecPlanBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdSpecPlanBase) {
            this.proxyPSDevPrdSpecPlanBase = (PSDevPrdSpecPlanBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PLANSTATE, 4);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECID, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECPLANID, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECPLANNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERID, 9);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 11);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

