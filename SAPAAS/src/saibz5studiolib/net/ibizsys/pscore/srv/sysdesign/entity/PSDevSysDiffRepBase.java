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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSysDiffRepBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSysDiffRepBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTPSDEVSLNSYSID = "DSTPSDEVSLNSYSID";
    public static final String FIELD_DSTPSDEVSLNSYSNAME = "DSTPSDEVSLNSYSNAME";
    public static final String FIELD_DSTSYSMODELVER = "DSTSYSMODELVER";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSYSDIFFREPID = "PSDEVSYSDIFFREPID";
    public static final String FIELD_PSDEVSYSDIFFREPNAME = "PSDEVSYSDIFFREPNAME";
    public static final String FIELD_REPSTATE = "REPSTATE";
    public static final String FIELD_SYSMODELVER = "SYSMODELVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DSTPSDEVSLNSYSID = 3;
    private static final int INDEX_DSTPSDEVSLNSYSNAME = 4;
    private static final int INDEX_DSTSYSMODELVER = 5;
    private static final int INDEX_ENDTIME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEVSLNSYSID = 8;
    private static final int INDEX_PSDEVSLNSYSNAME = 9;
    private static final int INDEX_PSDEVSYSDIFFREPID = 10;
    private static final int INDEX_PSDEVSYSDIFFREPNAME = 11;
    private static final int INDEX_REPSTATE = 12;
    private static final int INDEX_SYSMODELVER = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSysDiffRepBase proxyPSDevSysDiffRepBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstpsdevslnsysidDirtyFlag = false;
    private boolean dstpsdevslnsysnameDirtyFlag = false;
    private boolean dstsysmodelverDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevsysdiffrepidDirtyFlag = false;
    private boolean psdevsysdiffrepnameDirtyFlag = false;
    private boolean repstateDirtyFlag = false;
    private boolean sysmodelverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstpsdevslnsysid")
    private String dstpsdevslnsysid;
    @Column(name="dstpsdevslnsysname")
    private String dstpsdevslnsysname;
    @Column(name="dstsysmodelver")
    private Integer dstsysmodelver;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevsysdiffrepid")
    private String psdevsysdiffrepid;
    @Column(name="psdevsysdiffrepname")
    private String psdevsysdiffrepname;
    @Column(name="repstate")
    private Integer repstate;
    @Column(name="sysmodelver")
    private Integer sysmodelver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objDstPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys dstpsdevslnsys = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
    }

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

    public void setDstPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdevslnsysid = string;
        this.dstpsdevslnsysidDirtyFlag = true;
    }

    public String getDstPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDevSlnSysId();
        }
        return this.dstpsdevslnsysid;
    }

    public boolean isDstPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDevSlnSysIdDirty();
        }
        return this.dstpsdevslnsysidDirtyFlag;
    }

    public void resetDstPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDevSlnSysId();
            return;
        }
        this.dstpsdevslnsysidDirtyFlag = false;
        this.dstpsdevslnsysid = null;
    }

    public void setDstPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdevslnsysname = string;
        this.dstpsdevslnsysnameDirtyFlag = true;
    }

    public String getDstPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDevSlnSysName();
        }
        return this.dstpsdevslnsysname;
    }

    public boolean isDstPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDevSlnSysNameDirty();
        }
        return this.dstpsdevslnsysnameDirtyFlag;
    }

    public void resetDstPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDevSlnSysName();
            return;
        }
        this.dstpsdevslnsysnameDirtyFlag = false;
        this.dstpsdevslnsysname = null;
    }

    public void setDstSysModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstSysModelVer(n);
            return;
        }
        this.dstsysmodelver = n;
        this.dstsysmodelverDirtyFlag = true;
    }

    public Integer getDstSysModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstSysModelVer();
        }
        return this.dstsysmodelver;
    }

    public boolean isDstSysModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstSysModelVerDirty();
        }
        return this.dstsysmodelverDirtyFlag;
    }

    public void resetDstSysModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstSysModelVer();
            return;
        }
        this.dstsysmodelverDirtyFlag = false;
        this.dstsysmodelver = null;
    }

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setPSDevSysDiffRepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSysDiffRepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevsysdiffrepid = string;
        this.psdevsysdiffrepidDirtyFlag = true;
    }

    public String getPSDevSysDiffRepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSysDiffRepId();
        }
        return this.psdevsysdiffrepid;
    }

    public boolean isPSDevSysDiffRepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSysDiffRepIdDirty();
        }
        return this.psdevsysdiffrepidDirtyFlag;
    }

    public void resetPSDevSysDiffRepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSysDiffRepId();
            return;
        }
        this.psdevsysdiffrepidDirtyFlag = false;
        this.psdevsysdiffrepid = null;
    }

    public void setPSDevSysDiffRepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSysDiffRepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevsysdiffrepname = string;
        this.psdevsysdiffrepnameDirtyFlag = true;
    }

    public String getPSDevSysDiffRepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSysDiffRepName();
        }
        return this.psdevsysdiffrepname;
    }

    public boolean isPSDevSysDiffRepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSysDiffRepNameDirty();
        }
        return this.psdevsysdiffrepnameDirtyFlag;
    }

    public void resetPSDevSysDiffRepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSysDiffRepName();
            return;
        }
        this.psdevsysdiffrepnameDirtyFlag = false;
        this.psdevsysdiffrepname = null;
    }

    public void setRepState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepState(n);
            return;
        }
        this.repstate = n;
        this.repstateDirtyFlag = true;
    }

    public Integer getRepState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepState();
        }
        return this.repstate;
    }

    public boolean isRepStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepStateDirty();
        }
        return this.repstateDirtyFlag;
    }

    public void resetRepState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepState();
            return;
        }
        this.repstateDirtyFlag = false;
        this.repstate = null;
    }

    public void setSysModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysModelVer(n);
            return;
        }
        this.sysmodelver = n;
        this.sysmodelverDirtyFlag = true;
    }

    public Integer getSysModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysModelVer();
        }
        return this.sysmodelver;
    }

    public boolean isSysModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysModelVerDirty();
        }
        return this.sysmodelverDirtyFlag;
    }

    public void resetSysModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysModelVer();
            return;
        }
        this.sysmodelverDirtyFlag = false;
        this.sysmodelver = null;
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
        PSDevSysDiffRepBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSysDiffRepBase pSDevSysDiffRepBase) {
        pSDevSysDiffRepBase.resetBeginTime();
        pSDevSysDiffRepBase.resetCreateDate();
        pSDevSysDiffRepBase.resetCreateMan();
        pSDevSysDiffRepBase.resetDstPSDevSlnSysId();
        pSDevSysDiffRepBase.resetDstPSDevSlnSysName();
        pSDevSysDiffRepBase.resetDstSysModelVer();
        pSDevSysDiffRepBase.resetEndTime();
        pSDevSysDiffRepBase.resetMemo();
        pSDevSysDiffRepBase.resetPSDevSlnSysId();
        pSDevSysDiffRepBase.resetPSDevSlnSysName();
        pSDevSysDiffRepBase.resetPSDevSysDiffRepId();
        pSDevSysDiffRepBase.resetPSDevSysDiffRepName();
        pSDevSysDiffRepBase.resetRepState();
        pSDevSysDiffRepBase.resetSysModelVer();
        pSDevSysDiffRepBase.resetUpdateDate();
        pSDevSysDiffRepBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_DSTPSDEVSLNSYSID, this.getDstPSDevSlnSysId());
        }
        if (!bl || this.isDstPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_DSTPSDEVSLNSYSNAME, this.getDstPSDevSlnSysName());
        }
        if (!bl || this.isDstSysModelVerDirty()) {
            hashMap.put(FIELD_DSTSYSMODELVER, this.getDstSysModelVer());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSysDiffRepIdDirty()) {
            hashMap.put(FIELD_PSDEVSYSDIFFREPID, this.getPSDevSysDiffRepId());
        }
        if (!bl || this.isPSDevSysDiffRepNameDirty()) {
            hashMap.put(FIELD_PSDEVSYSDIFFREPNAME, this.getPSDevSysDiffRepName());
        }
        if (!bl || this.isRepStateDirty()) {
            hashMap.put(FIELD_REPSTATE, this.getRepState());
        }
        if (!bl || this.isSysModelVerDirty()) {
            hashMap.put(FIELD_SYSMODELVER, this.getSysModelVer());
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
        return PSDevSysDiffRepBase.get(this, n);
    }

    private static Object get(PSDevSysDiffRepBase pSDevSysDiffRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSysDiffRepBase.getBeginTime();
            }
            case 1: {
                return pSDevSysDiffRepBase.getCreateDate();
            }
            case 2: {
                return pSDevSysDiffRepBase.getCreateMan();
            }
            case 3: {
                return pSDevSysDiffRepBase.getDstPSDevSlnSysId();
            }
            case 4: {
                return pSDevSysDiffRepBase.getDstPSDevSlnSysName();
            }
            case 5: {
                return pSDevSysDiffRepBase.getDstSysModelVer();
            }
            case 6: {
                return pSDevSysDiffRepBase.getEndTime();
            }
            case 7: {
                return pSDevSysDiffRepBase.getMemo();
            }
            case 8: {
                return pSDevSysDiffRepBase.getPSDevSlnSysId();
            }
            case 9: {
                return pSDevSysDiffRepBase.getPSDevSlnSysName();
            }
            case 10: {
                return pSDevSysDiffRepBase.getPSDevSysDiffRepId();
            }
            case 11: {
                return pSDevSysDiffRepBase.getPSDevSysDiffRepName();
            }
            case 12: {
                return pSDevSysDiffRepBase.getRepState();
            }
            case 13: {
                return pSDevSysDiffRepBase.getSysModelVer();
            }
            case 14: {
                return pSDevSysDiffRepBase.getUpdateDate();
            }
            case 15: {
                return pSDevSysDiffRepBase.getUpdateMan();
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
        PSDevSysDiffRepBase.set(this, n, object);
    }

    private static void set(PSDevSysDiffRepBase pSDevSysDiffRepBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSysDiffRepBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSysDiffRepBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevSysDiffRepBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSysDiffRepBase.setDstPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSysDiffRepBase.setDstPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSysDiffRepBase.setDstSysModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSysDiffRepBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDevSysDiffRepBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSysDiffRepBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSysDiffRepBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSysDiffRepBase.setPSDevSysDiffRepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSysDiffRepBase.setPSDevSysDiffRepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSysDiffRepBase.setRepState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevSysDiffRepBase.setSysModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevSysDiffRepBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDevSysDiffRepBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSysDiffRepBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSysDiffRepBase pSDevSysDiffRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSysDiffRepBase.getBeginTime() == null;
            }
            case 1: {
                return pSDevSysDiffRepBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevSysDiffRepBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevSysDiffRepBase.getDstPSDevSlnSysId() == null;
            }
            case 4: {
                return pSDevSysDiffRepBase.getDstPSDevSlnSysName() == null;
            }
            case 5: {
                return pSDevSysDiffRepBase.getDstSysModelVer() == null;
            }
            case 6: {
                return pSDevSysDiffRepBase.getEndTime() == null;
            }
            case 7: {
                return pSDevSysDiffRepBase.getMemo() == null;
            }
            case 8: {
                return pSDevSysDiffRepBase.getPSDevSlnSysId() == null;
            }
            case 9: {
                return pSDevSysDiffRepBase.getPSDevSlnSysName() == null;
            }
            case 10: {
                return pSDevSysDiffRepBase.getPSDevSysDiffRepId() == null;
            }
            case 11: {
                return pSDevSysDiffRepBase.getPSDevSysDiffRepName() == null;
            }
            case 12: {
                return pSDevSysDiffRepBase.getRepState() == null;
            }
            case 13: {
                return pSDevSysDiffRepBase.getSysModelVer() == null;
            }
            case 14: {
                return pSDevSysDiffRepBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDevSysDiffRepBase.getUpdateMan() == null;
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
        return PSDevSysDiffRepBase.contains(this, n);
    }

    private static boolean contains(PSDevSysDiffRepBase pSDevSysDiffRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSysDiffRepBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDevSysDiffRepBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevSysDiffRepBase.isCreateManDirty();
            }
            case 3: {
                return pSDevSysDiffRepBase.isDstPSDevSlnSysIdDirty();
            }
            case 4: {
                return pSDevSysDiffRepBase.isDstPSDevSlnSysNameDirty();
            }
            case 5: {
                return pSDevSysDiffRepBase.isDstSysModelVerDirty();
            }
            case 6: {
                return pSDevSysDiffRepBase.isEndTimeDirty();
            }
            case 7: {
                return pSDevSysDiffRepBase.isMemoDirty();
            }
            case 8: {
                return pSDevSysDiffRepBase.isPSDevSlnSysIdDirty();
            }
            case 9: {
                return pSDevSysDiffRepBase.isPSDevSlnSysNameDirty();
            }
            case 10: {
                return pSDevSysDiffRepBase.isPSDevSysDiffRepIdDirty();
            }
            case 11: {
                return pSDevSysDiffRepBase.isPSDevSysDiffRepNameDirty();
            }
            case 12: {
                return pSDevSysDiffRepBase.isRepStateDirty();
            }
            case 13: {
                return pSDevSysDiffRepBase.isSysModelVerDirty();
            }
            case 14: {
                return pSDevSysDiffRepBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDevSysDiffRepBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSysDiffRepBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSysDiffRepBase pSDevSysDiffRepBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSysDiffRepBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getDstPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdevslnsysid", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getDstPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getDstPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdevslnsysname", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getDstPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getDstSysModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstsysmodelver", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getDstSysModelVer()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSysDiffRepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevsysdiffrepid", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getPSDevSysDiffRepId()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSysDiffRepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevsysdiffrepname", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getPSDevSysDiffRepName()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getRepState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"repstate", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getRepState()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getSysModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelver", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getSysModelVer()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSysDiffRepBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSysDiffRepBase.getJSONValue((Object)pSDevSysDiffRepBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSysDiffRepBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSysDiffRepBase pSDevSysDiffRepBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSysDiffRepBase.getBeginTime() != null) {
            object = pSDevSysDiffRepBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSysDiffRepBase.getCreateDate() != null) {
            object = pSDevSysDiffRepBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSysDiffRepBase.getCreateMan() != null) {
            object = pSDevSysDiffRepBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getDstPSDevSlnSysId() != null) {
            object = pSDevSysDiffRepBase.getDstPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_DSTPSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getDstPSDevSlnSysName() != null) {
            object = pSDevSysDiffRepBase.getDstPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_DSTPSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getDstSysModelVer() != null) {
            object = pSDevSysDiffRepBase.getDstSysModelVer();
            xmlNode.setAttribute(FIELD_DSTSYSMODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSysDiffRepBase.getEndTime() != null) {
            object = pSDevSysDiffRepBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSysDiffRepBase.getMemo() != null) {
            object = pSDevSysDiffRepBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSlnSysId() != null) {
            object = pSDevSysDiffRepBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSlnSysName() != null) {
            object = pSDevSysDiffRepBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSysDiffRepId() != null) {
            object = pSDevSysDiffRepBase.getPSDevSysDiffRepId();
            xmlNode.setAttribute(FIELD_PSDEVSYSDIFFREPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getPSDevSysDiffRepName() != null) {
            object = pSDevSysDiffRepBase.getPSDevSysDiffRepName();
            xmlNode.setAttribute(FIELD_PSDEVSYSDIFFREPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSysDiffRepBase.getRepState() != null) {
            object = pSDevSysDiffRepBase.getRepState();
            xmlNode.setAttribute(FIELD_REPSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSysDiffRepBase.getSysModelVer() != null) {
            object = pSDevSysDiffRepBase.getSysModelVer();
            xmlNode.setAttribute(FIELD_SYSMODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSysDiffRepBase.getUpdateDate() != null) {
            object = pSDevSysDiffRepBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSysDiffRepBase.getUpdateMan() != null) {
            object = pSDevSysDiffRepBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSysDiffRepBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSysDiffRepBase pSDevSysDiffRepBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSysDiffRepBase.isBeginTimeDirty() && (bl || pSDevSysDiffRepBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevSysDiffRepBase.getBeginTime());
        }
        if (pSDevSysDiffRepBase.isCreateDateDirty() && (bl || pSDevSysDiffRepBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSysDiffRepBase.getCreateDate());
        }
        if (pSDevSysDiffRepBase.isCreateManDirty() && (bl || pSDevSysDiffRepBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSysDiffRepBase.getCreateMan());
        }
        if (pSDevSysDiffRepBase.isDstPSDevSlnSysIdDirty() && (bl || pSDevSysDiffRepBase.getDstPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_DSTPSDEVSLNSYSID, (Object)pSDevSysDiffRepBase.getDstPSDevSlnSysId());
        }
        if (pSDevSysDiffRepBase.isDstPSDevSlnSysNameDirty() && (bl || pSDevSysDiffRepBase.getDstPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_DSTPSDEVSLNSYSNAME, (Object)pSDevSysDiffRepBase.getDstPSDevSlnSysName());
        }
        if (pSDevSysDiffRepBase.isDstSysModelVerDirty() && (bl || pSDevSysDiffRepBase.getDstSysModelVer() != null)) {
            iDataObject.set(FIELD_DSTSYSMODELVER, (Object)pSDevSysDiffRepBase.getDstSysModelVer());
        }
        if (pSDevSysDiffRepBase.isEndTimeDirty() && (bl || pSDevSysDiffRepBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevSysDiffRepBase.getEndTime());
        }
        if (pSDevSysDiffRepBase.isMemoDirty() && (bl || pSDevSysDiffRepBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSysDiffRepBase.getMemo());
        }
        if (pSDevSysDiffRepBase.isPSDevSlnSysIdDirty() && (bl || pSDevSysDiffRepBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSysDiffRepBase.getPSDevSlnSysId());
        }
        if (pSDevSysDiffRepBase.isPSDevSlnSysNameDirty() && (bl || pSDevSysDiffRepBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSysDiffRepBase.getPSDevSlnSysName());
        }
        if (pSDevSysDiffRepBase.isPSDevSysDiffRepIdDirty() && (bl || pSDevSysDiffRepBase.getPSDevSysDiffRepId() != null)) {
            iDataObject.set(FIELD_PSDEVSYSDIFFREPID, (Object)pSDevSysDiffRepBase.getPSDevSysDiffRepId());
        }
        if (pSDevSysDiffRepBase.isPSDevSysDiffRepNameDirty() && (bl || pSDevSysDiffRepBase.getPSDevSysDiffRepName() != null)) {
            iDataObject.set(FIELD_PSDEVSYSDIFFREPNAME, (Object)pSDevSysDiffRepBase.getPSDevSysDiffRepName());
        }
        if (pSDevSysDiffRepBase.isRepStateDirty() && (bl || pSDevSysDiffRepBase.getRepState() != null)) {
            iDataObject.set(FIELD_REPSTATE, (Object)pSDevSysDiffRepBase.getRepState());
        }
        if (pSDevSysDiffRepBase.isSysModelVerDirty() && (bl || pSDevSysDiffRepBase.getSysModelVer() != null)) {
            iDataObject.set(FIELD_SYSMODELVER, (Object)pSDevSysDiffRepBase.getSysModelVer());
        }
        if (pSDevSysDiffRepBase.isUpdateDateDirty() && (bl || pSDevSysDiffRepBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSysDiffRepBase.getUpdateDate());
        }
        if (pSDevSysDiffRepBase.isUpdateManDirty() && (bl || pSDevSysDiffRepBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSysDiffRepBase.getUpdateMan());
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
        return PSDevSysDiffRepBase.remove(this, n);
    }

    private static boolean remove(PSDevSysDiffRepBase pSDevSysDiffRepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSysDiffRepBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDevSysDiffRepBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevSysDiffRepBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevSysDiffRepBase.resetDstPSDevSlnSysId();
                return true;
            }
            case 4: {
                pSDevSysDiffRepBase.resetDstPSDevSlnSysName();
                return true;
            }
            case 5: {
                pSDevSysDiffRepBase.resetDstSysModelVer();
                return true;
            }
            case 6: {
                pSDevSysDiffRepBase.resetEndTime();
                return true;
            }
            case 7: {
                pSDevSysDiffRepBase.resetMemo();
                return true;
            }
            case 8: {
                pSDevSysDiffRepBase.resetPSDevSlnSysId();
                return true;
            }
            case 9: {
                pSDevSysDiffRepBase.resetPSDevSlnSysName();
                return true;
            }
            case 10: {
                pSDevSysDiffRepBase.resetPSDevSysDiffRepId();
                return true;
            }
            case 11: {
                pSDevSysDiffRepBase.resetPSDevSysDiffRepName();
                return true;
            }
            case 12: {
                pSDevSysDiffRepBase.resetRepState();
                return true;
            }
            case 13: {
                pSDevSysDiffRepBase.resetSysModelVer();
                return true;
            }
            case 14: {
                pSDevSysDiffRepBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDevSysDiffRepBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getDstPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDevSlnSys();
        }
        if (this.getDstPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objDstPSDevSlnSysLock;
        synchronized (n) {
            if (this.dstpsdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDevSlnSysId(), (Object)this.dstpsdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.dstpsdevslnsys = null;
            }
            if (this.dstpsdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getDstPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.dstpsdevslnsys = pSDevSlnSys;
            }
            return this.dstpsdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevSysDiffRepBase getProxyEntity() {
        return this.proxyPSDevSysDiffRepBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSysDiffRepBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSysDiffRepBase) {
            this.proxyPSDevSysDiffRepBase = (PSDevSysDiffRepBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DSTPSDEVSLNSYSID, 3);
        fieldIndexMap.put(FIELD_DSTPSDEVSLNSYSNAME, 4);
        fieldIndexMap.put(FIELD_DSTSYSMODELVER, 5);
        fieldIndexMap.put(FIELD_ENDTIME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSYSDIFFREPID, 10);
        fieldIndexMap.put(FIELD_PSDEVSYSDIFFREPNAME, 11);
        fieldIndexMap.put(FIELD_REPSTATE, 12);
        fieldIndexMap.put(FIELD_SYSMODELVER, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

