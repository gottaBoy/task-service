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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURISSUESN = "CURISSUESN";
    public static final String FIELD_CURSPECSN = "CURSPECSN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSDEVPRDVERID = "PPSDEVPRDVERID";
    public static final String FIELD_PPSDEVPRDVERNAME = "PPSDEVPRDVERNAME";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_STARTISSUESN = "STARTISSUESN";
    public static final String FIELD_STARTSPECSN = "STARTSPECSN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CURISSUESN = 2;
    private static final int INDEX_CURSPECSN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PPSDEVPRDVERID = 6;
    private static final int INDEX_PPSDEVPRDVERNAME = 7;
    private static final int INDEX_PSDEVPRDID = 8;
    private static final int INDEX_PSDEVPRDNAME = 9;
    private static final int INDEX_PSDEVPRDVERID = 10;
    private static final int INDEX_PSDEVPRDVERNAME = 11;
    private static final int INDEX_STARTISSUESN = 12;
    private static final int INDEX_STARTSPECSN = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdVerBase proxyPSDevPrdVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curissuesnDirtyFlag = false;
    private boolean curspecsnDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsdevprdveridDirtyFlag = false;
    private boolean ppsdevprdvernameDirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean startissuesnDirtyFlag = false;
    private boolean startspecsnDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curissuesn")
    private Integer curissuesn;
    @Column(name="curspecsn")
    private Integer curspecsn;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsdevprdverid")
    private String ppsdevprdverid;
    @Column(name="ppsdevprdvername")
    private String ppsdevprdvername;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="startissuesn")
    private Integer startissuesn;
    @Column(name="startspecsn")
    private Integer startspecsn;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer ppsdevprdver = null;
    private Integer objPSDevPrdLock = new Integer(1);
    private PSDevPrd psdevprd = null;

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

    public void setCurIssueSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurIssueSN(n);
            return;
        }
        this.curissuesn = n;
        this.curissuesnDirtyFlag = true;
    }

    public Integer getCurIssueSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurIssueSN();
        }
        return this.curissuesn;
    }

    public boolean isCurIssueSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurIssueSNDirty();
        }
        return this.curissuesnDirtyFlag;
    }

    public void resetCurIssueSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurIssueSN();
            return;
        }
        this.curissuesnDirtyFlag = false;
        this.curissuesn = null;
    }

    public void setCurSpecSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurSpecSN(n);
            return;
        }
        this.curspecsn = n;
        this.curspecsnDirtyFlag = true;
    }

    public Integer getCurSpecSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurSpecSN();
        }
        return this.curspecsn;
    }

    public boolean isCurSpecSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurSpecSNDirty();
        }
        return this.curspecsnDirtyFlag;
    }

    public void resetCurSpecSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurSpecSN();
            return;
        }
        this.curspecsnDirtyFlag = false;
        this.curspecsn = null;
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

    public void setPPSDevPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevprdverid = string;
        this.ppsdevprdveridDirtyFlag = true;
    }

    public String getPPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevPrdVerId();
        }
        return this.ppsdevprdverid;
    }

    public boolean isPPSDevPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevPrdVerIdDirty();
        }
        return this.ppsdevprdveridDirtyFlag;
    }

    public void resetPPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevPrdVerId();
            return;
        }
        this.ppsdevprdveridDirtyFlag = false;
        this.ppsdevprdverid = null;
    }

    public void setPPSDevPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevprdvername = string;
        this.ppsdevprdvernameDirtyFlag = true;
    }

    public String getPPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevPrdVerName();
        }
        return this.ppsdevprdvername;
    }

    public boolean isPPSDevPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevPrdVerNameDirty();
        }
        return this.ppsdevprdvernameDirtyFlag;
    }

    public void resetPPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevPrdVerName();
            return;
        }
        this.ppsdevprdvernameDirtyFlag = false;
        this.ppsdevprdvername = null;
    }

    public void setPSDevPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdid = string;
        this.psdevprdidDirtyFlag = true;
    }

    public String getPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdId();
        }
        return this.psdevprdid;
    }

    public boolean isPSDevPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIdDirty();
        }
        return this.psdevprdidDirtyFlag;
    }

    public void resetPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdId();
            return;
        }
        this.psdevprdidDirtyFlag = false;
        this.psdevprdid = null;
    }

    public void setPSDevPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdname = string;
        this.psdevprdnameDirtyFlag = true;
    }

    public String getPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdName();
        }
        return this.psdevprdname;
    }

    public boolean isPSDevPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdNameDirty();
        }
        return this.psdevprdnameDirtyFlag;
    }

    public void resetPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdName();
            return;
        }
        this.psdevprdnameDirtyFlag = false;
        this.psdevprdname = null;
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

    public void setStartIssueSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartIssueSN(n);
            return;
        }
        this.startissuesn = n;
        this.startissuesnDirtyFlag = true;
    }

    public Integer getStartIssueSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartIssueSN();
        }
        return this.startissuesn;
    }

    public boolean isStartIssueSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartIssueSNDirty();
        }
        return this.startissuesnDirtyFlag;
    }

    public void resetStartIssueSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartIssueSN();
            return;
        }
        this.startissuesnDirtyFlag = false;
        this.startissuesn = null;
    }

    public void setStartSpecSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartSpecSN(n);
            return;
        }
        this.startspecsn = n;
        this.startspecsnDirtyFlag = true;
    }

    public Integer getStartSpecSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartSpecSN();
        }
        return this.startspecsn;
    }

    public boolean isStartSpecSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartSpecSNDirty();
        }
        return this.startspecsnDirtyFlag;
    }

    public void resetStartSpecSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartSpecSN();
            return;
        }
        this.startspecsnDirtyFlag = false;
        this.startspecsn = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDevPrdVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdVerBase pSDevPrdVerBase) {
        pSDevPrdVerBase.resetCreateDate();
        pSDevPrdVerBase.resetCreateMan();
        pSDevPrdVerBase.resetCurIssueSN();
        pSDevPrdVerBase.resetCurSpecSN();
        pSDevPrdVerBase.resetMemo();
        pSDevPrdVerBase.resetOrderValue();
        pSDevPrdVerBase.resetPPSDevPrdVerId();
        pSDevPrdVerBase.resetPPSDevPrdVerName();
        pSDevPrdVerBase.resetPSDevPrdId();
        pSDevPrdVerBase.resetPSDevPrdName();
        pSDevPrdVerBase.resetPSDevPrdVerId();
        pSDevPrdVerBase.resetPSDevPrdVerName();
        pSDevPrdVerBase.resetStartIssueSN();
        pSDevPrdVerBase.resetStartSpecSN();
        pSDevPrdVerBase.resetUpdateDate();
        pSDevPrdVerBase.resetUpdateMan();
        pSDevPrdVerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurIssueSNDirty()) {
            hashMap.put(FIELD_CURISSUESN, this.getCurIssueSN());
        }
        if (!bl || this.isCurSpecSNDirty()) {
            hashMap.put(FIELD_CURSPECSN, this.getCurSpecSN());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PPSDEVPRDVERID, this.getPPSDevPrdVerId());
        }
        if (!bl || this.isPPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PPSDEVPRDVERNAME, this.getPPSDevPrdVerName());
        }
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERID, this.getPSDevPrdVerId());
        }
        if (!bl || this.isPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERNAME, this.getPSDevPrdVerName());
        }
        if (!bl || this.isStartIssueSNDirty()) {
            hashMap.put(FIELD_STARTISSUESN, this.getStartIssueSN());
        }
        if (!bl || this.isStartSpecSNDirty()) {
            hashMap.put(FIELD_STARTSPECSN, this.getStartSpecSN());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDevPrdVerBase.get(this, n);
    }

    private static Object get(PSDevPrdVerBase pSDevPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdVerBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdVerBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdVerBase.getCurIssueSN();
            }
            case 3: {
                return pSDevPrdVerBase.getCurSpecSN();
            }
            case 4: {
                return pSDevPrdVerBase.getMemo();
            }
            case 5: {
                return pSDevPrdVerBase.getOrderValue();
            }
            case 6: {
                return pSDevPrdVerBase.getPPSDevPrdVerId();
            }
            case 7: {
                return pSDevPrdVerBase.getPPSDevPrdVerName();
            }
            case 8: {
                return pSDevPrdVerBase.getPSDevPrdId();
            }
            case 9: {
                return pSDevPrdVerBase.getPSDevPrdName();
            }
            case 10: {
                return pSDevPrdVerBase.getPSDevPrdVerId();
            }
            case 11: {
                return pSDevPrdVerBase.getPSDevPrdVerName();
            }
            case 12: {
                return pSDevPrdVerBase.getStartIssueSN();
            }
            case 13: {
                return pSDevPrdVerBase.getStartSpecSN();
            }
            case 14: {
                return pSDevPrdVerBase.getUpdateDate();
            }
            case 15: {
                return pSDevPrdVerBase.getUpdateMan();
            }
            case 16: {
                return pSDevPrdVerBase.getValidFlag();
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
        PSDevPrdVerBase.set(this, n, object);
    }

    private static void set(PSDevPrdVerBase pSDevPrdVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdVerBase.setCurIssueSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdVerBase.setCurSpecSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdVerBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdVerBase.setPPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdVerBase.setPPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdVerBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdVerBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdVerBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdVerBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdVerBase.setStartIssueSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdVerBase.setStartSpecSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevPrdVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDevPrdVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevPrdVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevPrdVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdVerBase pSDevPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdVerBase.getCurIssueSN() == null;
            }
            case 3: {
                return pSDevPrdVerBase.getCurSpecSN() == null;
            }
            case 4: {
                return pSDevPrdVerBase.getMemo() == null;
            }
            case 5: {
                return pSDevPrdVerBase.getOrderValue() == null;
            }
            case 6: {
                return pSDevPrdVerBase.getPPSDevPrdVerId() == null;
            }
            case 7: {
                return pSDevPrdVerBase.getPPSDevPrdVerName() == null;
            }
            case 8: {
                return pSDevPrdVerBase.getPSDevPrdId() == null;
            }
            case 9: {
                return pSDevPrdVerBase.getPSDevPrdName() == null;
            }
            case 10: {
                return pSDevPrdVerBase.getPSDevPrdVerId() == null;
            }
            case 11: {
                return pSDevPrdVerBase.getPSDevPrdVerName() == null;
            }
            case 12: {
                return pSDevPrdVerBase.getStartIssueSN() == null;
            }
            case 13: {
                return pSDevPrdVerBase.getStartSpecSN() == null;
            }
            case 14: {
                return pSDevPrdVerBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDevPrdVerBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDevPrdVerBase.getValidFlag() == null;
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
        return PSDevPrdVerBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdVerBase pSDevPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdVerBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdVerBase.isCurIssueSNDirty();
            }
            case 3: {
                return pSDevPrdVerBase.isCurSpecSNDirty();
            }
            case 4: {
                return pSDevPrdVerBase.isMemoDirty();
            }
            case 5: {
                return pSDevPrdVerBase.isOrderValueDirty();
            }
            case 6: {
                return pSDevPrdVerBase.isPPSDevPrdVerIdDirty();
            }
            case 7: {
                return pSDevPrdVerBase.isPPSDevPrdVerNameDirty();
            }
            case 8: {
                return pSDevPrdVerBase.isPSDevPrdIdDirty();
            }
            case 9: {
                return pSDevPrdVerBase.isPSDevPrdNameDirty();
            }
            case 10: {
                return pSDevPrdVerBase.isPSDevPrdVerIdDirty();
            }
            case 11: {
                return pSDevPrdVerBase.isPSDevPrdVerNameDirty();
            }
            case 12: {
                return pSDevPrdVerBase.isStartIssueSNDirty();
            }
            case 13: {
                return pSDevPrdVerBase.isStartSpecSNDirty();
            }
            case 14: {
                return pSDevPrdVerBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDevPrdVerBase.isUpdateManDirty();
            }
            case 16: {
                return pSDevPrdVerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdVerBase pSDevPrdVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getCurIssueSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curissuesn", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getCurIssueSN()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getCurSpecSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curspecsn", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getCurSpecSN()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getPPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevprdverid", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getPPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getPPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevprdvername", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getPPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getStartIssueSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startissuesn", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getStartIssueSN()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getStartSpecSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startspecsn", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getStartSpecSN()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevPrdVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevPrdVerBase.getJSONValue((Object)pSDevPrdVerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdVerBase pSDevPrdVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdVerBase.getCreateDate() != null) {
            object = pSDevPrdVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdVerBase.getCreateMan() != null) {
            object = pSDevPrdVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getCurIssueSN() != null) {
            object = pSDevPrdVerBase.getCurIssueSN();
            xmlNode.setAttribute(FIELD_CURISSUESN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdVerBase.getCurSpecSN() != null) {
            object = pSDevPrdVerBase.getCurSpecSN();
            xmlNode.setAttribute(FIELD_CURSPECSN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdVerBase.getMemo() != null) {
            object = pSDevPrdVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getOrderValue() != null) {
            object = pSDevPrdVerBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdVerBase.getPPSDevPrdVerId() != null) {
            object = pSDevPrdVerBase.getPPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PPSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getPPSDevPrdVerName() != null) {
            object = pSDevPrdVerBase.getPPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PPSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdId() != null) {
            object = pSDevPrdVerBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdName() != null) {
            object = pSDevPrdVerBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdVerId() != null) {
            object = pSDevPrdVerBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getPSDevPrdVerName() != null) {
            object = pSDevPrdVerBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getStartIssueSN() != null) {
            object = pSDevPrdVerBase.getStartIssueSN();
            xmlNode.setAttribute(FIELD_STARTISSUESN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdVerBase.getStartSpecSN() != null) {
            object = pSDevPrdVerBase.getStartSpecSN();
            xmlNode.setAttribute(FIELD_STARTSPECSN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdVerBase.getUpdateDate() != null) {
            object = pSDevPrdVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdVerBase.getUpdateMan() != null) {
            object = pSDevPrdVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdVerBase.getValidFlag() != null) {
            object = pSDevPrdVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdVerBase pSDevPrdVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdVerBase.isCreateDateDirty() && (bl || pSDevPrdVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdVerBase.getCreateDate());
        }
        if (pSDevPrdVerBase.isCreateManDirty() && (bl || pSDevPrdVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdVerBase.getCreateMan());
        }
        if (pSDevPrdVerBase.isCurIssueSNDirty() && (bl || pSDevPrdVerBase.getCurIssueSN() != null)) {
            iDataObject.set(FIELD_CURISSUESN, (Object)pSDevPrdVerBase.getCurIssueSN());
        }
        if (pSDevPrdVerBase.isCurSpecSNDirty() && (bl || pSDevPrdVerBase.getCurSpecSN() != null)) {
            iDataObject.set(FIELD_CURSPECSN, (Object)pSDevPrdVerBase.getCurSpecSN());
        }
        if (pSDevPrdVerBase.isMemoDirty() && (bl || pSDevPrdVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdVerBase.getMemo());
        }
        if (pSDevPrdVerBase.isOrderValueDirty() && (bl || pSDevPrdVerBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevPrdVerBase.getOrderValue());
        }
        if (pSDevPrdVerBase.isPPSDevPrdVerIdDirty() && (bl || pSDevPrdVerBase.getPPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PPSDEVPRDVERID, (Object)pSDevPrdVerBase.getPPSDevPrdVerId());
        }
        if (pSDevPrdVerBase.isPPSDevPrdVerNameDirty() && (bl || pSDevPrdVerBase.getPPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PPSDEVPRDVERNAME, (Object)pSDevPrdVerBase.getPPSDevPrdVerName());
        }
        if (pSDevPrdVerBase.isPSDevPrdIdDirty() && (bl || pSDevPrdVerBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSDevPrdVerBase.getPSDevPrdId());
        }
        if (pSDevPrdVerBase.isPSDevPrdNameDirty() && (bl || pSDevPrdVerBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSDevPrdVerBase.getPSDevPrdName());
        }
        if (pSDevPrdVerBase.isPSDevPrdVerIdDirty() && (bl || pSDevPrdVerBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSDevPrdVerBase.getPSDevPrdVerId());
        }
        if (pSDevPrdVerBase.isPSDevPrdVerNameDirty() && (bl || pSDevPrdVerBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSDevPrdVerBase.getPSDevPrdVerName());
        }
        if (pSDevPrdVerBase.isStartIssueSNDirty() && (bl || pSDevPrdVerBase.getStartIssueSN() != null)) {
            iDataObject.set(FIELD_STARTISSUESN, (Object)pSDevPrdVerBase.getStartIssueSN());
        }
        if (pSDevPrdVerBase.isStartSpecSNDirty() && (bl || pSDevPrdVerBase.getStartSpecSN() != null)) {
            iDataObject.set(FIELD_STARTSPECSN, (Object)pSDevPrdVerBase.getStartSpecSN());
        }
        if (pSDevPrdVerBase.isUpdateDateDirty() && (bl || pSDevPrdVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdVerBase.getUpdateDate());
        }
        if (pSDevPrdVerBase.isUpdateManDirty() && (bl || pSDevPrdVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdVerBase.getUpdateMan());
        }
        if (pSDevPrdVerBase.isValidFlagDirty() && (bl || pSDevPrdVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevPrdVerBase.getValidFlag());
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
        return PSDevPrdVerBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdVerBase pSDevPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdVerBase.resetCurIssueSN();
                return true;
            }
            case 3: {
                pSDevPrdVerBase.resetCurSpecSN();
                return true;
            }
            case 4: {
                pSDevPrdVerBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevPrdVerBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDevPrdVerBase.resetPPSDevPrdVerId();
                return true;
            }
            case 7: {
                pSDevPrdVerBase.resetPPSDevPrdVerName();
                return true;
            }
            case 8: {
                pSDevPrdVerBase.resetPSDevPrdId();
                return true;
            }
            case 9: {
                pSDevPrdVerBase.resetPSDevPrdName();
                return true;
            }
            case 10: {
                pSDevPrdVerBase.resetPSDevPrdVerId();
                return true;
            }
            case 11: {
                pSDevPrdVerBase.resetPSDevPrdVerName();
                return true;
            }
            case 12: {
                pSDevPrdVerBase.resetStartIssueSN();
                return true;
            }
            case 13: {
                pSDevPrdVerBase.resetStartSpecSN();
                return true;
            }
            case 14: {
                pSDevPrdVerBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDevPrdVerBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDevPrdVerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdVer getPPSDevPrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevPrdVer();
        }
        if (this.getPPSDevPrdVerId() == null) {
            return null;
        }
        Integer n = this.objPPSDevPrdVerLock;
        synchronized (n) {
            if (this.ppsdevprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevPrdVerId(), (Object)this.ppsdevprdver.getPSDevPrdVerId()) != 0L) {
                this.ppsdevprdver = null;
            }
            if (this.ppsdevprdver == null) {
                PSDevPrdVer pSDevPrdVer = new PSDevPrdVer();
                pSDevPrdVer.setPSDevPrdVerId(this.getPPSDevPrdVerId());
                PSDevPrdVerService pSDevPrdVerService = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdVerService.autoGet((IEntity)pSDevPrdVer);
                this.ppsdevprdver = pSDevPrdVer;
            }
            return this.ppsdevprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrd getPSDevPrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrd();
        }
        if (this.getPSDevPrdId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdLock;
        synchronized (n) {
            if (this.psdevprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdId(), (Object)this.psdevprd.getPSDevPrdId()) != 0L) {
                this.psdevprd = null;
            }
            if (this.psdevprd == null) {
                PSDevPrd pSDevPrd = new PSDevPrd();
                pSDevPrd.setPSDevPrdId(this.getPSDevPrdId());
                PSDevPrdService pSDevPrdService = (PSDevPrdService)ServiceGlobal.getService(PSDevPrdService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdService.autoGet((IEntity)pSDevPrd);
                this.psdevprd = pSDevPrd;
            }
            return this.psdevprd;
        }
    }

    private PSDevPrdVerBase getProxyEntity() {
        return this.proxyPSDevPrdVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdVerBase) {
            this.proxyPSDevPrdVerBase = (PSDevPrdVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CURISSUESN, 2);
        fieldIndexMap.put(FIELD_CURSPECSN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PPSDEVPRDVERID, 6);
        fieldIndexMap.put(FIELD_PPSDEVPRDVERNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 8);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 10);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 11);
        fieldIndexMap.put(FIELD_STARTISSUESN, 12);
        fieldIndexMap.put(FIELD_STARTSPECSN, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

