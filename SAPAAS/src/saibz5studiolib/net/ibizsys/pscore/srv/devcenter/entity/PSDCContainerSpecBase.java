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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCContainerSpecBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCContainerSpecBase.class);
    public static final String FIELD_CFGTYPE = "CFGTYPE";
    public static final String FIELD_CLUSTERTYPE = "CLUSTERTYPE";
    public static final String FIELD_CONTAINERCFG = "CONTAINERCFG";
    public static final String FIELD_CPULIMIT = "CPULIMIT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MEMORYLIMIT = "MEMORYLIMIT";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_SPECPARAMS = "SPECPARAMS";
    public static final String FIELD_SPECTAG = "SPECTAG";
    public static final String FIELD_SPECTAG2 = "SPECTAG2";
    public static final String FIELD_SPECVER = "SPECVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CFGTYPE = 0;
    private static final int INDEX_CLUSTERTYPE = 1;
    private static final int INDEX_CONTAINERCFG = 2;
    private static final int INDEX_CPULIMIT = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MEMORYLIMIT = 7;
    private static final int INDEX_PSDCCONTAINERSPECID = 8;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 9;
    private static final int INDEX_PSDEVCENTERID = 10;
    private static final int INDEX_PSDEVCENTERNAME = 11;
    private static final int INDEX_SPECPARAMS = 12;
    private static final int INDEX_SPECTAG = 13;
    private static final int INDEX_SPECTAG2 = 14;
    private static final int INDEX_SPECVER = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCContainerSpecBase proxyPSDCContainerSpecBase = null;
    private boolean cfgtypeDirtyFlag = false;
    private boolean clustertypeDirtyFlag = false;
    private boolean containercfgDirtyFlag = false;
    private boolean cpulimitDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean memorylimitDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean specparamsDirtyFlag = false;
    private boolean spectagDirtyFlag = false;
    private boolean spectag2DirtyFlag = false;
    private boolean specverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cfgtype")
    private String cfgtype;
    @Column(name="clustertype")
    private String clustertype;
    @Column(name="containercfg")
    private String containercfg;
    @Column(name="cpulimit")
    private Integer cpulimit;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="memorylimit")
    private Integer memorylimit;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="specparams")
    private String specparams;
    @Column(name="spectag")
    private String spectag;
    @Column(name="spectag2")
    private String spectag2;
    @Column(name="specver")
    private Integer specver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setCfgType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgtype = string;
        this.cfgtypeDirtyFlag = true;
    }

    public String getCfgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgType();
        }
        return this.cfgtype;
    }

    public boolean isCfgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgTypeDirty();
        }
        return this.cfgtypeDirtyFlag;
    }

    public void resetCfgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgType();
            return;
        }
        this.cfgtypeDirtyFlag = false;
        this.cfgtype = null;
    }

    public void setClusterType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClusterType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clustertype = string;
        this.clustertypeDirtyFlag = true;
    }

    public String getClusterType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClusterType();
        }
        return this.clustertype;
    }

    public boolean isClusterTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClusterTypeDirty();
        }
        return this.clustertypeDirtyFlag;
    }

    public void resetClusterType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClusterType();
            return;
        }
        this.clustertypeDirtyFlag = false;
        this.clustertype = null;
    }

    public void setContainerCfg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContainerCfg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.containercfg = string;
        this.containercfgDirtyFlag = true;
    }

    public String getContainerCfg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContainerCfg();
        }
        return this.containercfg;
    }

    public boolean isContainerCfgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContainerCfgDirty();
        }
        return this.containercfgDirtyFlag;
    }

    public void resetContainerCfg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContainerCfg();
            return;
        }
        this.containercfgDirtyFlag = false;
        this.containercfg = null;
    }

    public void setCPULimit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPULimit(n);
            return;
        }
        this.cpulimit = n;
        this.cpulimitDirtyFlag = true;
    }

    public Integer getCPULimit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPULimit();
        }
        return this.cpulimit;
    }

    public boolean isCPULimitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPULimitDirty();
        }
        return this.cpulimitDirtyFlag;
    }

    public void resetCPULimit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPULimit();
            return;
        }
        this.cpulimitDirtyFlag = false;
        this.cpulimit = null;
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

    public void setMemoryLimit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemoryLimit(n);
            return;
        }
        this.memorylimit = n;
        this.memorylimitDirtyFlag = true;
    }

    public Integer getMemoryLimit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemoryLimit();
        }
        return this.memorylimit;
    }

    public boolean isMemoryLimitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoryLimitDirty();
        }
        return this.memorylimitDirtyFlag;
    }

    public void resetMemoryLimit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemoryLimit();
            return;
        }
        this.memorylimitDirtyFlag = false;
        this.memorylimit = null;
    }

    public void setPSDCContainerSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecid = string;
        this.psdccontainerspecidDirtyFlag = true;
    }

    public String getPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecId();
        }
        return this.psdccontainerspecid;
    }

    public boolean isPSDCContainerSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecIdDirty();
        }
        return this.psdccontainerspecidDirtyFlag;
    }

    public void resetPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecId();
            return;
        }
        this.psdccontainerspecidDirtyFlag = false;
        this.psdccontainerspecid = null;
    }

    public void setPSDCContainerSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecname = string;
        this.psdccontainerspecnameDirtyFlag = true;
    }

    public String getPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecName();
        }
        return this.psdccontainerspecname;
    }

    public boolean isPSDCContainerSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecNameDirty();
        }
        return this.psdccontainerspecnameDirtyFlag;
    }

    public void resetPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecName();
            return;
        }
        this.psdccontainerspecnameDirtyFlag = false;
        this.psdccontainerspecname = null;
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

    public void setSpecParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpecParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.specparams = string;
        this.specparamsDirtyFlag = true;
    }

    public String getSpecParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpecParams();
        }
        return this.specparams;
    }

    public boolean isSpecParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpecParamsDirty();
        }
        return this.specparamsDirtyFlag;
    }

    public void resetSpecParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpecParams();
            return;
        }
        this.specparamsDirtyFlag = false;
        this.specparams = null;
    }

    public void setSpecTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpecTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.spectag = string;
        this.spectagDirtyFlag = true;
    }

    public String getSpecTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpecTag();
        }
        return this.spectag;
    }

    public boolean isSpecTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpecTagDirty();
        }
        return this.spectagDirtyFlag;
    }

    public void resetSpecTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpecTag();
            return;
        }
        this.spectagDirtyFlag = false;
        this.spectag = null;
    }

    public void setSpecTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpecTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.spectag2 = string;
        this.spectag2DirtyFlag = true;
    }

    public String getSpecTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpecTag2();
        }
        return this.spectag2;
    }

    public boolean isSpecTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpecTag2Dirty();
        }
        return this.spectag2DirtyFlag;
    }

    public void resetSpecTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpecTag2();
            return;
        }
        this.spectag2DirtyFlag = false;
        this.spectag2 = null;
    }

    public void setSpecVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpecVer(n);
            return;
        }
        this.specver = n;
        this.specverDirtyFlag = true;
    }

    public Integer getSpecVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpecVer();
        }
        return this.specver;
    }

    public boolean isSpecVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpecVerDirty();
        }
        return this.specverDirtyFlag;
    }

    public void resetSpecVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpecVer();
            return;
        }
        this.specverDirtyFlag = false;
        this.specver = null;
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
        PSDCContainerSpecBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCContainerSpecBase pSDCContainerSpecBase) {
        pSDCContainerSpecBase.resetCfgType();
        pSDCContainerSpecBase.resetClusterType();
        pSDCContainerSpecBase.resetContainerCfg();
        pSDCContainerSpecBase.resetCPULimit();
        pSDCContainerSpecBase.resetCreateDate();
        pSDCContainerSpecBase.resetCreateMan();
        pSDCContainerSpecBase.resetMemo();
        pSDCContainerSpecBase.resetMemoryLimit();
        pSDCContainerSpecBase.resetPSDCContainerSpecId();
        pSDCContainerSpecBase.resetPSDCContainerSpecName();
        pSDCContainerSpecBase.resetPSDevCenterId();
        pSDCContainerSpecBase.resetPSDevCenterName();
        pSDCContainerSpecBase.resetSpecParams();
        pSDCContainerSpecBase.resetSpecTag();
        pSDCContainerSpecBase.resetSpecTag2();
        pSDCContainerSpecBase.resetSpecVer();
        pSDCContainerSpecBase.resetUpdateDate();
        pSDCContainerSpecBase.resetUpdateMan();
        pSDCContainerSpecBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCfgTypeDirty()) {
            hashMap.put(FIELD_CFGTYPE, this.getCfgType());
        }
        if (!bl || this.isClusterTypeDirty()) {
            hashMap.put(FIELD_CLUSTERTYPE, this.getClusterType());
        }
        if (!bl || this.isContainerCfgDirty()) {
            hashMap.put(FIELD_CONTAINERCFG, this.getContainerCfg());
        }
        if (!bl || this.isCPULimitDirty()) {
            hashMap.put(FIELD_CPULIMIT, this.getCPULimit());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMemoryLimitDirty()) {
            hashMap.put(FIELD_MEMORYLIMIT, this.getMemoryLimit());
        }
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isSpecParamsDirty()) {
            hashMap.put(FIELD_SPECPARAMS, this.getSpecParams());
        }
        if (!bl || this.isSpecTagDirty()) {
            hashMap.put(FIELD_SPECTAG, this.getSpecTag());
        }
        if (!bl || this.isSpecTag2Dirty()) {
            hashMap.put(FIELD_SPECTAG2, this.getSpecTag2());
        }
        if (!bl || this.isSpecVerDirty()) {
            hashMap.put(FIELD_SPECVER, this.getSpecVer());
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
        return PSDCContainerSpecBase.get(this, n);
    }

    private static Object get(PSDCContainerSpecBase pSDCContainerSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCContainerSpecBase.getCfgType();
            }
            case 1: {
                return pSDCContainerSpecBase.getClusterType();
            }
            case 2: {
                return pSDCContainerSpecBase.getContainerCfg();
            }
            case 3: {
                return pSDCContainerSpecBase.getCPULimit();
            }
            case 4: {
                return pSDCContainerSpecBase.getCreateDate();
            }
            case 5: {
                return pSDCContainerSpecBase.getCreateMan();
            }
            case 6: {
                return pSDCContainerSpecBase.getMemo();
            }
            case 7: {
                return pSDCContainerSpecBase.getMemoryLimit();
            }
            case 8: {
                return pSDCContainerSpecBase.getPSDCContainerSpecId();
            }
            case 9: {
                return pSDCContainerSpecBase.getPSDCContainerSpecName();
            }
            case 10: {
                return pSDCContainerSpecBase.getPSDevCenterId();
            }
            case 11: {
                return pSDCContainerSpecBase.getPSDevCenterName();
            }
            case 12: {
                return pSDCContainerSpecBase.getSpecParams();
            }
            case 13: {
                return pSDCContainerSpecBase.getSpecTag();
            }
            case 14: {
                return pSDCContainerSpecBase.getSpecTag2();
            }
            case 15: {
                return pSDCContainerSpecBase.getSpecVer();
            }
            case 16: {
                return pSDCContainerSpecBase.getUpdateDate();
            }
            case 17: {
                return pSDCContainerSpecBase.getUpdateMan();
            }
            case 18: {
                return pSDCContainerSpecBase.getValidFlag();
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
        PSDCContainerSpecBase.set(this, n, object);
    }

    private static void set(PSDCContainerSpecBase pSDCContainerSpecBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCContainerSpecBase.setCfgType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCContainerSpecBase.setClusterType(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCContainerSpecBase.setContainerCfg(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCContainerSpecBase.setCPULimit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCContainerSpecBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDCContainerSpecBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCContainerSpecBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCContainerSpecBase.setMemoryLimit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCContainerSpecBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCContainerSpecBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCContainerSpecBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCContainerSpecBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCContainerSpecBase.setSpecParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCContainerSpecBase.setSpecTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCContainerSpecBase.setSpecTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCContainerSpecBase.setSpecVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDCContainerSpecBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDCContainerSpecBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCContainerSpecBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCContainerSpecBase.isNull(this, n);
    }

    private static boolean isNull(PSDCContainerSpecBase pSDCContainerSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCContainerSpecBase.getCfgType() == null;
            }
            case 1: {
                return pSDCContainerSpecBase.getClusterType() == null;
            }
            case 2: {
                return pSDCContainerSpecBase.getContainerCfg() == null;
            }
            case 3: {
                return pSDCContainerSpecBase.getCPULimit() == null;
            }
            case 4: {
                return pSDCContainerSpecBase.getCreateDate() == null;
            }
            case 5: {
                return pSDCContainerSpecBase.getCreateMan() == null;
            }
            case 6: {
                return pSDCContainerSpecBase.getMemo() == null;
            }
            case 7: {
                return pSDCContainerSpecBase.getMemoryLimit() == null;
            }
            case 8: {
                return pSDCContainerSpecBase.getPSDCContainerSpecId() == null;
            }
            case 9: {
                return pSDCContainerSpecBase.getPSDCContainerSpecName() == null;
            }
            case 10: {
                return pSDCContainerSpecBase.getPSDevCenterId() == null;
            }
            case 11: {
                return pSDCContainerSpecBase.getPSDevCenterName() == null;
            }
            case 12: {
                return pSDCContainerSpecBase.getSpecParams() == null;
            }
            case 13: {
                return pSDCContainerSpecBase.getSpecTag() == null;
            }
            case 14: {
                return pSDCContainerSpecBase.getSpecTag2() == null;
            }
            case 15: {
                return pSDCContainerSpecBase.getSpecVer() == null;
            }
            case 16: {
                return pSDCContainerSpecBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDCContainerSpecBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDCContainerSpecBase.getValidFlag() == null;
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
        return PSDCContainerSpecBase.contains(this, n);
    }

    private static boolean contains(PSDCContainerSpecBase pSDCContainerSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCContainerSpecBase.isCfgTypeDirty();
            }
            case 1: {
                return pSDCContainerSpecBase.isClusterTypeDirty();
            }
            case 2: {
                return pSDCContainerSpecBase.isContainerCfgDirty();
            }
            case 3: {
                return pSDCContainerSpecBase.isCPULimitDirty();
            }
            case 4: {
                return pSDCContainerSpecBase.isCreateDateDirty();
            }
            case 5: {
                return pSDCContainerSpecBase.isCreateManDirty();
            }
            case 6: {
                return pSDCContainerSpecBase.isMemoDirty();
            }
            case 7: {
                return pSDCContainerSpecBase.isMemoryLimitDirty();
            }
            case 8: {
                return pSDCContainerSpecBase.isPSDCContainerSpecIdDirty();
            }
            case 9: {
                return pSDCContainerSpecBase.isPSDCContainerSpecNameDirty();
            }
            case 10: {
                return pSDCContainerSpecBase.isPSDevCenterIdDirty();
            }
            case 11: {
                return pSDCContainerSpecBase.isPSDevCenterNameDirty();
            }
            case 12: {
                return pSDCContainerSpecBase.isSpecParamsDirty();
            }
            case 13: {
                return pSDCContainerSpecBase.isSpecTagDirty();
            }
            case 14: {
                return pSDCContainerSpecBase.isSpecTag2Dirty();
            }
            case 15: {
                return pSDCContainerSpecBase.isSpecVerDirty();
            }
            case 16: {
                return pSDCContainerSpecBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDCContainerSpecBase.isUpdateManDirty();
            }
            case 18: {
                return pSDCContainerSpecBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCContainerSpecBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCContainerSpecBase pSDCContainerSpecBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCContainerSpecBase.getCfgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgtype", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getCfgType()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getClusterType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clustertype", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getClusterType()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getContainerCfg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"containercfg", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getContainerCfg()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getCPULimit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpulimit", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getCPULimit()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getMemoryLimit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memorylimit", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getMemoryLimit()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getSpecParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"specparams", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getSpecParams()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getSpecTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spectag", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getSpecTag()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getSpecTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spectag2", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getSpecTag2()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getSpecVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"specver", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getSpecVer()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCContainerSpecBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCContainerSpecBase.getJSONValue((Object)pSDCContainerSpecBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCContainerSpecBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCContainerSpecBase pSDCContainerSpecBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCContainerSpecBase.getCfgType() != null) {
            object = pSDCContainerSpecBase.getCfgType();
            xmlNode.setAttribute(FIELD_CFGTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDCContainerSpecBase.getClusterType() != null) {
            object = pSDCContainerSpecBase.getClusterType();
            xmlNode.setAttribute(FIELD_CLUSTERTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDCContainerSpecBase.getContainerCfg() != null) {
            object = pSDCContainerSpecBase.getContainerCfg();
            xmlNode.setAttribute(FIELD_CONTAINERCFG, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getCPULimit() != null) {
            object = pSDCContainerSpecBase.getCPULimit();
            xmlNode.setAttribute(FIELD_CPULIMIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCContainerSpecBase.getCreateDate() != null) {
            object = pSDCContainerSpecBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCContainerSpecBase.getCreateMan() != null) {
            object = pSDCContainerSpecBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getMemo() != null) {
            object = pSDCContainerSpecBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getMemoryLimit() != null) {
            object = pSDCContainerSpecBase.getMemoryLimit();
            xmlNode.setAttribute(FIELD_MEMORYLIMIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCContainerSpecBase.getPSDCContainerSpecId() != null) {
            object = pSDCContainerSpecBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getPSDCContainerSpecName() != null) {
            object = pSDCContainerSpecBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getPSDevCenterId() != null) {
            object = pSDCContainerSpecBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getPSDevCenterName() != null) {
            object = pSDCContainerSpecBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getSpecParams() != null) {
            object = pSDCContainerSpecBase.getSpecParams();
            xmlNode.setAttribute(FIELD_SPECPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getSpecTag() != null) {
            object = pSDCContainerSpecBase.getSpecTag();
            xmlNode.setAttribute(FIELD_SPECTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getSpecTag2() != null) {
            object = pSDCContainerSpecBase.getSpecTag2();
            xmlNode.setAttribute(FIELD_SPECTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getSpecVer() != null) {
            object = pSDCContainerSpecBase.getSpecVer();
            xmlNode.setAttribute(FIELD_SPECVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCContainerSpecBase.getUpdateDate() != null) {
            object = pSDCContainerSpecBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCContainerSpecBase.getUpdateMan() != null) {
            object = pSDCContainerSpecBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCContainerSpecBase.getValidFlag() != null) {
            object = pSDCContainerSpecBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCContainerSpecBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCContainerSpecBase pSDCContainerSpecBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCContainerSpecBase.isCfgTypeDirty() && (bl || pSDCContainerSpecBase.getCfgType() != null)) {
            iDataObject.set(FIELD_CFGTYPE, (Object)pSDCContainerSpecBase.getCfgType());
        }
        if (pSDCContainerSpecBase.isClusterTypeDirty() && (bl || pSDCContainerSpecBase.getClusterType() != null)) {
            iDataObject.set(FIELD_CLUSTERTYPE, (Object)pSDCContainerSpecBase.getClusterType());
        }
        if (pSDCContainerSpecBase.isContainerCfgDirty() && (bl || pSDCContainerSpecBase.getContainerCfg() != null)) {
            iDataObject.set(FIELD_CONTAINERCFG, (Object)pSDCContainerSpecBase.getContainerCfg());
        }
        if (pSDCContainerSpecBase.isCPULimitDirty() && (bl || pSDCContainerSpecBase.getCPULimit() != null)) {
            iDataObject.set(FIELD_CPULIMIT, (Object)pSDCContainerSpecBase.getCPULimit());
        }
        if (pSDCContainerSpecBase.isCreateDateDirty() && (bl || pSDCContainerSpecBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCContainerSpecBase.getCreateDate());
        }
        if (pSDCContainerSpecBase.isCreateManDirty() && (bl || pSDCContainerSpecBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCContainerSpecBase.getCreateMan());
        }
        if (pSDCContainerSpecBase.isMemoDirty() && (bl || pSDCContainerSpecBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCContainerSpecBase.getMemo());
        }
        if (pSDCContainerSpecBase.isMemoryLimitDirty() && (bl || pSDCContainerSpecBase.getMemoryLimit() != null)) {
            iDataObject.set(FIELD_MEMORYLIMIT, (Object)pSDCContainerSpecBase.getMemoryLimit());
        }
        if (pSDCContainerSpecBase.isPSDCContainerSpecIdDirty() && (bl || pSDCContainerSpecBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDCContainerSpecBase.getPSDCContainerSpecId());
        }
        if (pSDCContainerSpecBase.isPSDCContainerSpecNameDirty() && (bl || pSDCContainerSpecBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDCContainerSpecBase.getPSDCContainerSpecName());
        }
        if (pSDCContainerSpecBase.isPSDevCenterIdDirty() && (bl || pSDCContainerSpecBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCContainerSpecBase.getPSDevCenterId());
        }
        if (pSDCContainerSpecBase.isPSDevCenterNameDirty() && (bl || pSDCContainerSpecBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCContainerSpecBase.getPSDevCenterName());
        }
        if (pSDCContainerSpecBase.isSpecParamsDirty() && (bl || pSDCContainerSpecBase.getSpecParams() != null)) {
            iDataObject.set(FIELD_SPECPARAMS, (Object)pSDCContainerSpecBase.getSpecParams());
        }
        if (pSDCContainerSpecBase.isSpecTagDirty() && (bl || pSDCContainerSpecBase.getSpecTag() != null)) {
            iDataObject.set(FIELD_SPECTAG, (Object)pSDCContainerSpecBase.getSpecTag());
        }
        if (pSDCContainerSpecBase.isSpecTag2Dirty() && (bl || pSDCContainerSpecBase.getSpecTag2() != null)) {
            iDataObject.set(FIELD_SPECTAG2, (Object)pSDCContainerSpecBase.getSpecTag2());
        }
        if (pSDCContainerSpecBase.isSpecVerDirty() && (bl || pSDCContainerSpecBase.getSpecVer() != null)) {
            iDataObject.set(FIELD_SPECVER, (Object)pSDCContainerSpecBase.getSpecVer());
        }
        if (pSDCContainerSpecBase.isUpdateDateDirty() && (bl || pSDCContainerSpecBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCContainerSpecBase.getUpdateDate());
        }
        if (pSDCContainerSpecBase.isUpdateManDirty() && (bl || pSDCContainerSpecBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCContainerSpecBase.getUpdateMan());
        }
        if (pSDCContainerSpecBase.isValidFlagDirty() && (bl || pSDCContainerSpecBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCContainerSpecBase.getValidFlag());
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
        return PSDCContainerSpecBase.remove(this, n);
    }

    private static boolean remove(PSDCContainerSpecBase pSDCContainerSpecBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCContainerSpecBase.resetCfgType();
                return true;
            }
            case 1: {
                pSDCContainerSpecBase.resetClusterType();
                return true;
            }
            case 2: {
                pSDCContainerSpecBase.resetContainerCfg();
                return true;
            }
            case 3: {
                pSDCContainerSpecBase.resetCPULimit();
                return true;
            }
            case 4: {
                pSDCContainerSpecBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDCContainerSpecBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDCContainerSpecBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCContainerSpecBase.resetMemoryLimit();
                return true;
            }
            case 8: {
                pSDCContainerSpecBase.resetPSDCContainerSpecId();
                return true;
            }
            case 9: {
                pSDCContainerSpecBase.resetPSDCContainerSpecName();
                return true;
            }
            case 10: {
                pSDCContainerSpecBase.resetPSDevCenterId();
                return true;
            }
            case 11: {
                pSDCContainerSpecBase.resetPSDevCenterName();
                return true;
            }
            case 12: {
                pSDCContainerSpecBase.resetSpecParams();
                return true;
            }
            case 13: {
                pSDCContainerSpecBase.resetSpecTag();
                return true;
            }
            case 14: {
                pSDCContainerSpecBase.resetSpecTag2();
                return true;
            }
            case 15: {
                pSDCContainerSpecBase.resetSpecVer();
                return true;
            }
            case 16: {
                pSDCContainerSpecBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDCContainerSpecBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDCContainerSpecBase.resetValidFlag();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCContainerSpecBase getProxyEntity() {
        return this.proxyPSDCContainerSpecBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCContainerSpecBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCContainerSpecBase) {
            this.proxyPSDCContainerSpecBase = (PSDCContainerSpecBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CFGTYPE, 0);
        fieldIndexMap.put(FIELD_CLUSTERTYPE, 1);
        fieldIndexMap.put(FIELD_CONTAINERCFG, 2);
        fieldIndexMap.put(FIELD_CPULIMIT, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MEMORYLIMIT, 7);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 8);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 11);
        fieldIndexMap.put(FIELD_SPECPARAMS, 12);
        fieldIndexMap.put(FIELD_SPECTAG, 13);
        fieldIndexMap.put(FIELD_SPECTAG2, 14);
        fieldIndexMap.put(FIELD_SPECVER, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

