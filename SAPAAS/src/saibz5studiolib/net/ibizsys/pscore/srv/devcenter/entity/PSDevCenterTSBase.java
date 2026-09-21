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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterTSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterTSBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_JITPSTASKSERVERID = "JITPSTASKSERVERID";
    public static final String FIELD_JITPSTASKSERVERNAME = "JITPSTASKSERVERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERTSID = "PSDEVCENTERTSID";
    public static final String FIELD_PSDEVCENTERTSNAME = "PSDEVCENTERTSNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_SERVERUSAGE = "SERVERUSAGE";
    public static final String FIELD_SYSVER = "SYSVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_JITPSTASKSERVERID = 2;
    private static final int INDEX_JITPSTASKSERVERNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSDEVCENTERTSID = 7;
    private static final int INDEX_PSDEVCENTERTSNAME = 8;
    private static final int INDEX_PSTASKSERVERID = 9;
    private static final int INDEX_PSTASKSERVERNAME = 10;
    private static final int INDEX_SERVERUSAGE = 11;
    private static final int INDEX_SYSVER = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterTSBase proxyPSDevCenterTSBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean jitpstaskserveridDirtyFlag = false;
    private boolean jitpstaskservernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentertsidDirtyFlag = false;
    private boolean psdevcentertsnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean serverusageDirtyFlag = false;
    private boolean sysverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="jitpstaskserverid")
    private String jitpstaskserverid;
    @Column(name="jitpstaskservername")
    private String jitpstaskservername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentertsid")
    private String psdevcentertsid;
    @Column(name="psdevcentertsname")
    private String psdevcentertsname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="serverusage")
    private String serverusage;
    @Column(name="sysver")
    private String sysver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objJITPSTaskServerLock = new Integer(1);
    private PSTaskServer jitpstaskserver = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setJITPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitpstaskserverid = string;
        this.jitpstaskserveridDirtyFlag = true;
    }

    public String getJITPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSTaskServerId();
        }
        return this.jitpstaskserverid;
    }

    public boolean isJITPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITPSTaskServerIdDirty();
        }
        return this.jitpstaskserveridDirtyFlag;
    }

    public void resetJITPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITPSTaskServerId();
            return;
        }
        this.jitpstaskserveridDirtyFlag = false;
        this.jitpstaskserverid = null;
    }

    public void setJITPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitpstaskservername = string;
        this.jitpstaskservernameDirtyFlag = true;
    }

    public String getJITPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSTaskServerName();
        }
        return this.jitpstaskservername;
    }

    public boolean isJITPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITPSTaskServerNameDirty();
        }
        return this.jitpstaskservernameDirtyFlag;
    }

    public void resetJITPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITPSTaskServerName();
            return;
        }
        this.jitpstaskservernameDirtyFlag = false;
        this.jitpstaskservername = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevCenterTSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertsid = string;
        this.psdevcentertsidDirtyFlag = true;
    }

    public String getPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTSId();
        }
        return this.psdevcentertsid;
    }

    public boolean isPSDevCenterTSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTSIdDirty();
        }
        return this.psdevcentertsidDirtyFlag;
    }

    public void resetPSDevCenterTSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTSId();
            return;
        }
        this.psdevcentertsidDirtyFlag = false;
        this.psdevcentertsid = null;
    }

    public void setPSDevCenterTSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterTSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentertsname = string;
        this.psdevcentertsnameDirtyFlag = true;
    }

    public String getPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterTSName();
        }
        return this.psdevcentertsname;
    }

    public boolean isPSDevCenterTSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterTSNameDirty();
        }
        return this.psdevcentertsnameDirtyFlag;
    }

    public void resetPSDevCenterTSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterTSName();
            return;
        }
        this.psdevcentertsnameDirtyFlag = false;
        this.psdevcentertsname = null;
    }

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
    }

    public void setServerUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverusage = string;
        this.serverusageDirtyFlag = true;
    }

    public String getServerUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerUsage();
        }
        return this.serverusage;
    }

    public boolean isServerUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerUsageDirty();
        }
        return this.serverusageDirtyFlag;
    }

    public void resetServerUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerUsage();
            return;
        }
        this.serverusageDirtyFlag = false;
        this.serverusage = null;
    }

    public void setSysVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysver = string;
        this.sysverDirtyFlag = true;
    }

    public String getSysVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysVer();
        }
        return this.sysver;
    }

    public boolean isSysVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysVerDirty();
        }
        return this.sysverDirtyFlag;
    }

    public void resetSysVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysVer();
            return;
        }
        this.sysverDirtyFlag = false;
        this.sysver = null;
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
        PSDevCenterTSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterTSBase pSDevCenterTSBase) {
        pSDevCenterTSBase.resetCreateDate();
        pSDevCenterTSBase.resetCreateMan();
        pSDevCenterTSBase.resetJITPSTaskServerId();
        pSDevCenterTSBase.resetJITPSTaskServerName();
        pSDevCenterTSBase.resetMemo();
        pSDevCenterTSBase.resetPSDevCenterId();
        pSDevCenterTSBase.resetPSDevCenterName();
        pSDevCenterTSBase.resetPSDevCenterTSId();
        pSDevCenterTSBase.resetPSDevCenterTSName();
        pSDevCenterTSBase.resetPSTaskServerId();
        pSDevCenterTSBase.resetPSTaskServerName();
        pSDevCenterTSBase.resetServerUsage();
        pSDevCenterTSBase.resetSysVer();
        pSDevCenterTSBase.resetUpdateDate();
        pSDevCenterTSBase.resetUpdateMan();
        pSDevCenterTSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isJITPSTaskServerIdDirty()) {
            hashMap.put(FIELD_JITPSTASKSERVERID, this.getJITPSTaskServerId());
        }
        if (!bl || this.isJITPSTaskServerNameDirty()) {
            hashMap.put(FIELD_JITPSTASKSERVERNAME, this.getJITPSTaskServerName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterTSIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTSID, this.getPSDevCenterTSId());
        }
        if (!bl || this.isPSDevCenterTSNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERTSNAME, this.getPSDevCenterTSName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isServerUsageDirty()) {
            hashMap.put(FIELD_SERVERUSAGE, this.getServerUsage());
        }
        if (!bl || this.isSysVerDirty()) {
            hashMap.put(FIELD_SYSVER, this.getSysVer());
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
        return PSDevCenterTSBase.get(this, n);
    }

    private static Object get(PSDevCenterTSBase pSDevCenterTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterTSBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterTSBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterTSBase.getJITPSTaskServerId();
            }
            case 3: {
                return pSDevCenterTSBase.getJITPSTaskServerName();
            }
            case 4: {
                return pSDevCenterTSBase.getMemo();
            }
            case 5: {
                return pSDevCenterTSBase.getPSDevCenterId();
            }
            case 6: {
                return pSDevCenterTSBase.getPSDevCenterName();
            }
            case 7: {
                return pSDevCenterTSBase.getPSDevCenterTSId();
            }
            case 8: {
                return pSDevCenterTSBase.getPSDevCenterTSName();
            }
            case 9: {
                return pSDevCenterTSBase.getPSTaskServerId();
            }
            case 10: {
                return pSDevCenterTSBase.getPSTaskServerName();
            }
            case 11: {
                return pSDevCenterTSBase.getServerUsage();
            }
            case 12: {
                return pSDevCenterTSBase.getSysVer();
            }
            case 13: {
                return pSDevCenterTSBase.getUpdateDate();
            }
            case 14: {
                return pSDevCenterTSBase.getUpdateMan();
            }
            case 15: {
                return pSDevCenterTSBase.getValidFlag();
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
        PSDevCenterTSBase.set(this, n, object);
    }

    private static void set(PSDevCenterTSBase pSDevCenterTSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterTSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterTSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterTSBase.setJITPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterTSBase.setJITPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterTSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterTSBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterTSBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterTSBase.setPSDevCenterTSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterTSBase.setPSDevCenterTSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterTSBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterTSBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterTSBase.setServerUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterTSBase.setSysVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterTSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterTSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterTSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevCenterTSBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterTSBase pSDevCenterTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterTSBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterTSBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterTSBase.getJITPSTaskServerId() == null;
            }
            case 3: {
                return pSDevCenterTSBase.getJITPSTaskServerName() == null;
            }
            case 4: {
                return pSDevCenterTSBase.getMemo() == null;
            }
            case 5: {
                return pSDevCenterTSBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSDevCenterTSBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSDevCenterTSBase.getPSDevCenterTSId() == null;
            }
            case 8: {
                return pSDevCenterTSBase.getPSDevCenterTSName() == null;
            }
            case 9: {
                return pSDevCenterTSBase.getPSTaskServerId() == null;
            }
            case 10: {
                return pSDevCenterTSBase.getPSTaskServerName() == null;
            }
            case 11: {
                return pSDevCenterTSBase.getServerUsage() == null;
            }
            case 12: {
                return pSDevCenterTSBase.getSysVer() == null;
            }
            case 13: {
                return pSDevCenterTSBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDevCenterTSBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDevCenterTSBase.getValidFlag() == null;
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
        return PSDevCenterTSBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterTSBase pSDevCenterTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterTSBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterTSBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterTSBase.isJITPSTaskServerIdDirty();
            }
            case 3: {
                return pSDevCenterTSBase.isJITPSTaskServerNameDirty();
            }
            case 4: {
                return pSDevCenterTSBase.isMemoDirty();
            }
            case 5: {
                return pSDevCenterTSBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSDevCenterTSBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSDevCenterTSBase.isPSDevCenterTSIdDirty();
            }
            case 8: {
                return pSDevCenterTSBase.isPSDevCenterTSNameDirty();
            }
            case 9: {
                return pSDevCenterTSBase.isPSTaskServerIdDirty();
            }
            case 10: {
                return pSDevCenterTSBase.isPSTaskServerNameDirty();
            }
            case 11: {
                return pSDevCenterTSBase.isServerUsageDirty();
            }
            case 12: {
                return pSDevCenterTSBase.isSysVerDirty();
            }
            case 13: {
                return pSDevCenterTSBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDevCenterTSBase.isUpdateManDirty();
            }
            case 15: {
                return pSDevCenterTSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterTSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterTSBase pSDevCenterTSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterTSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getJITPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitpstaskserverid", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getJITPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getJITPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitpstaskservername", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getJITPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterTSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertsid", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getPSDevCenterTSId()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterTSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentertsname", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getPSDevCenterTSName()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getServerUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverusage", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getServerUsage()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getSysVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysver", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getSysVer()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterTSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevCenterTSBase.getJSONValue((Object)pSDevCenterTSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterTSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterTSBase pSDevCenterTSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterTSBase.getCreateDate() != null) {
            object = pSDevCenterTSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterTSBase.getCreateMan() != null) {
            object = pSDevCenterTSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getJITPSTaskServerId() != null) {
            object = pSDevCenterTSBase.getJITPSTaskServerId();
            xmlNode.setAttribute(FIELD_JITPSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getJITPSTaskServerName() != null) {
            object = pSDevCenterTSBase.getJITPSTaskServerName();
            xmlNode.setAttribute(FIELD_JITPSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getMemo() != null) {
            object = pSDevCenterTSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterId() != null) {
            object = pSDevCenterTSBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterName() != null) {
            object = pSDevCenterTSBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterTSId() != null) {
            object = pSDevCenterTSBase.getPSDevCenterTSId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getPSDevCenterTSName() != null) {
            object = pSDevCenterTSBase.getPSDevCenterTSName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERTSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getPSTaskServerId() != null) {
            object = pSDevCenterTSBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getPSTaskServerName() != null) {
            object = pSDevCenterTSBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getServerUsage() != null) {
            object = pSDevCenterTSBase.getServerUsage();
            xmlNode.setAttribute(FIELD_SERVERUSAGE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getSysVer() != null) {
            object = pSDevCenterTSBase.getSysVer();
            xmlNode.setAttribute(FIELD_SYSVER, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getUpdateDate() != null) {
            object = pSDevCenterTSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterTSBase.getUpdateMan() != null) {
            object = pSDevCenterTSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterTSBase.getValidFlag() != null) {
            object = pSDevCenterTSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterTSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterTSBase pSDevCenterTSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterTSBase.isCreateDateDirty() && (bl || pSDevCenterTSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterTSBase.getCreateDate());
        }
        if (pSDevCenterTSBase.isCreateManDirty() && (bl || pSDevCenterTSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterTSBase.getCreateMan());
        }
        if (pSDevCenterTSBase.isJITPSTaskServerIdDirty() && (bl || pSDevCenterTSBase.getJITPSTaskServerId() != null)) {
            iDataObject.set(FIELD_JITPSTASKSERVERID, (Object)pSDevCenterTSBase.getJITPSTaskServerId());
        }
        if (pSDevCenterTSBase.isJITPSTaskServerNameDirty() && (bl || pSDevCenterTSBase.getJITPSTaskServerName() != null)) {
            iDataObject.set(FIELD_JITPSTASKSERVERNAME, (Object)pSDevCenterTSBase.getJITPSTaskServerName());
        }
        if (pSDevCenterTSBase.isMemoDirty() && (bl || pSDevCenterTSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterTSBase.getMemo());
        }
        if (pSDevCenterTSBase.isPSDevCenterIdDirty() && (bl || pSDevCenterTSBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterTSBase.getPSDevCenterId());
        }
        if (pSDevCenterTSBase.isPSDevCenterNameDirty() && (bl || pSDevCenterTSBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterTSBase.getPSDevCenterName());
        }
        if (pSDevCenterTSBase.isPSDevCenterTSIdDirty() && (bl || pSDevCenterTSBase.getPSDevCenterTSId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTSID, (Object)pSDevCenterTSBase.getPSDevCenterTSId());
        }
        if (pSDevCenterTSBase.isPSDevCenterTSNameDirty() && (bl || pSDevCenterTSBase.getPSDevCenterTSName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERTSNAME, (Object)pSDevCenterTSBase.getPSDevCenterTSName());
        }
        if (pSDevCenterTSBase.isPSTaskServerIdDirty() && (bl || pSDevCenterTSBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDevCenterTSBase.getPSTaskServerId());
        }
        if (pSDevCenterTSBase.isPSTaskServerNameDirty() && (bl || pSDevCenterTSBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDevCenterTSBase.getPSTaskServerName());
        }
        if (pSDevCenterTSBase.isServerUsageDirty() && (bl || pSDevCenterTSBase.getServerUsage() != null)) {
            iDataObject.set(FIELD_SERVERUSAGE, (Object)pSDevCenterTSBase.getServerUsage());
        }
        if (pSDevCenterTSBase.isSysVerDirty() && (bl || pSDevCenterTSBase.getSysVer() != null)) {
            iDataObject.set(FIELD_SYSVER, (Object)pSDevCenterTSBase.getSysVer());
        }
        if (pSDevCenterTSBase.isUpdateDateDirty() && (bl || pSDevCenterTSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterTSBase.getUpdateDate());
        }
        if (pSDevCenterTSBase.isUpdateManDirty() && (bl || pSDevCenterTSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterTSBase.getUpdateMan());
        }
        if (pSDevCenterTSBase.isValidFlagDirty() && (bl || pSDevCenterTSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevCenterTSBase.getValidFlag());
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
        return PSDevCenterTSBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterTSBase pSDevCenterTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterTSBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterTSBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterTSBase.resetJITPSTaskServerId();
                return true;
            }
            case 3: {
                pSDevCenterTSBase.resetJITPSTaskServerName();
                return true;
            }
            case 4: {
                pSDevCenterTSBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevCenterTSBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSDevCenterTSBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSDevCenterTSBase.resetPSDevCenterTSId();
                return true;
            }
            case 8: {
                pSDevCenterTSBase.resetPSDevCenterTSName();
                return true;
            }
            case 9: {
                pSDevCenterTSBase.resetPSTaskServerId();
                return true;
            }
            case 10: {
                pSDevCenterTSBase.resetPSTaskServerName();
                return true;
            }
            case 11: {
                pSDevCenterTSBase.resetServerUsage();
                return true;
            }
            case 12: {
                pSDevCenterTSBase.resetSysVer();
                return true;
            }
            case 13: {
                pSDevCenterTSBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDevCenterTSBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDevCenterTSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getJITPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITPSTaskServer();
        }
        if (this.getJITPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objJITPSTaskServerLock;
        synchronized (n) {
            if (this.jitpstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getJITPSTaskServerId(), (Object)this.jitpstaskserver.getPSTaskServerId()) != 0L) {
                this.jitpstaskserver = null;
            }
            if (this.jitpstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getJITPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.jitpstaskserver = pSTaskServer;
            }
            return this.jitpstaskserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSDevCenterTSBase getProxyEntity() {
        return this.proxyPSDevCenterTSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterTSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterTSBase) {
            this.proxyPSDevCenterTSBase = (PSDevCenterTSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_JITPSTASKSERVERID, 2);
        fieldIndexMap.put(FIELD_JITPSTASKSERVERNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERTSID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERTSNAME, 8);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 9);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 10);
        fieldIndexMap.put(FIELD_SERVERUSAGE, 11);
        fieldIndexMap.put(FIELD_SYSVER, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

