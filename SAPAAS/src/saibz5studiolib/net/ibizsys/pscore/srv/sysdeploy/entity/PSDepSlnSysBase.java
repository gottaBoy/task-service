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
package net.ibizsys.pscore.srv.sysdeploy.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnParam;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysAPI;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysApp;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBD;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysFile;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysKey;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysWF;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysAPI;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysApp;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnParamService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAppService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysBDService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysFileService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysKeyService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysWFService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAPIService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysBase.class);
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CPULIMIT = "CPULIMIT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPSYSSTATE = "DEPSYSSTATE";
    public static final String FIELD_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MEMORYLIMIT = "MEMORYLIMIT";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_PSDEPSYSAPIID = "PSDEPSYSAPIID";
    public static final String FIELD_PSDEPSYSAPINAME = "PSDEPSYSAPINAME";
    public static final String FIELD_PSDEPSYSAPPID = "PSDEPSYSAPPID";
    public static final String FIELD_PSDEPSYSAPPNAME = "PSDEPSYSAPPNAME";
    public static final String FIELD_PSDEPSYSID = "PSDEPSYSID";
    public static final String FIELD_PSDEPSYSNAME = "PSDEPSYSNAME";
    public static final String FIELD_PSDEPSYSVERID = "PSDEPSYSVERID";
    public static final String FIELD_PSDEPSYSVERNAME = "PSDEPSYSVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_REPLICATION = "REPLICATION";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONTENTTYPE = 0;
    private static final int INDEX_CPULIMIT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEPSYSSTATE = 4;
    private static final int INDEX_ENABLEDYNASYS = 5;
    private static final int INDEX_EXPRIEDTIME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_MEMORYLIMIT = 8;
    private static final int INDEX_PSDCCONTAINERSPECID = 9;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 10;
    private static final int INDEX_PSDEPSLNID = 11;
    private static final int INDEX_PSDEPSLNNAME = 12;
    private static final int INDEX_PSDEPSLNSYSID = 13;
    private static final int INDEX_PSDEPSLNSYSNAME = 14;
    private static final int INDEX_PSDEPSYSAPIID = 15;
    private static final int INDEX_PSDEPSYSAPINAME = 16;
    private static final int INDEX_PSDEPSYSAPPID = 17;
    private static final int INDEX_PSDEPSYSAPPNAME = 18;
    private static final int INDEX_PSDEPSYSID = 19;
    private static final int INDEX_PSDEPSYSNAME = 20;
    private static final int INDEX_PSDEPSYSVERID = 21;
    private static final int INDEX_PSDEPSYSVERNAME = 22;
    private static final int INDEX_PSDEVCENTERID = 23;
    private static final int INDEX_PSDEVCENTERNAME = 24;
    private static final int INDEX_PSSYSMODELINSTID = 25;
    private static final int INDEX_PSSYSMODELINSTNAME = 26;
    private static final int INDEX_PSSYSTEMID = 27;
    private static final int INDEX_REPLICATION = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_VALIDFLAG = 31;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysBase proxyPSDepSlnSysBase = null;
    private boolean contenttypeDirtyFlag = false;
    private boolean cpulimitDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean depsysstateDirtyFlag = false;
    private boolean enabledynasysDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean memorylimitDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean psdepsysapiidDirtyFlag = false;
    private boolean psdepsysapinameDirtyFlag = false;
    private boolean psdepsysappidDirtyFlag = false;
    private boolean psdepsysappnameDirtyFlag = false;
    private boolean psdepsysidDirtyFlag = false;
    private boolean psdepsysnameDirtyFlag = false;
    private boolean psdepsysveridDirtyFlag = false;
    private boolean psdepsysvernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean replicationDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="cpulimit")
    private Integer cpulimit;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="depsysstate")
    private Integer depsysstate;
    @Column(name="enabledynasys")
    private Integer enabledynasys;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="memo")
    private String memo;
    @Column(name="memorylimit")
    private Integer memorylimit;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="psdepsysapiid")
    private String psdepsysapiid;
    @Column(name="psdepsysapiname")
    private String psdepsysapiname;
    @Column(name="psdepsysappid")
    private String psdepsysappid;
    @Column(name="psdepsysappname")
    private String psdepsysappname;
    @Column(name="psdepsysid")
    private String psdepsysid;
    @Column(name="psdepsysname")
    private String psdepsysname;
    @Column(name="psdepsysverid")
    private String psdepsysverid;
    @Column(name="psdepsysvername")
    private String psdepsysvername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="replication")
    private Integer replication;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;
    private Integer objPSDepSysAPILock = new Integer(1);
    private PSDepSysAPI psdepsysapi = null;
    private Integer objPSDepSysAppLock = new Integer(1);
    private PSDepSysApp psdepsysapp = null;
    private Integer objPSDepSysVerLock = new Integer(1);
    private PSDepSysVer psdepsysver = null;
    private Integer objPSDepSysLock = new Integer(1);
    private PSDepSys psdepsys = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;
    private Integer objPSDepSlnParamsLock = new Integer(1);
    private ArrayList<PSDepSlnParam> psdepslnparams = null;
    private Integer objPSDepSlnSysAPIsLock = new Integer(1);
    private ArrayList<PSDepSlnSysAPI> psdepslnsysapis = null;
    private Integer objPSDepSlnSysAppsLock = new Integer(1);
    private ArrayList<PSDepSlnSysApp> psdepslnsysapps = null;
    private Integer objPSDepSlnSysAsesLock = new Integer(1);
    private ArrayList<PSDepSlnSysAS> psdepslnsysases = null;
    private Integer objPSDepSlnSysBDsLock = new Integer(1);
    private ArrayList<PSDepSlnSysBD> psdepslnsysbds = null;
    private Integer objPSDepSlnSysDynaInstsLock = new Integer(1);
    private ArrayList<PSDepSlnSysDynaInst> psdepslnsysdynainsts = null;
    private Integer objPSDepSlnSysFilesLock = new Integer(1);
    private ArrayList<PSDepSlnSysFile> psdepslnsysfiles = null;
    private Integer objPSDepSlnSysKeysLock = new Integer(1);
    private ArrayList<PSDepSlnSysKey> psdepslnsyskeys = null;
    private Integer objPSDepSlnSysWFsLock = new Integer(1);
    private ArrayList<PSDepSlnSysWF> psdepslnsyswfs = null;

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
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

    public void setDepSysState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepSysState(n);
            return;
        }
        this.depsysstate = n;
        this.depsysstateDirtyFlag = true;
    }

    public Integer getDepSysState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepSysState();
        }
        return this.depsysstate;
    }

    public boolean isDepSysStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepSysStateDirty();
        }
        return this.depsysstateDirtyFlag;
    }

    public void resetDepSysState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepSysState();
            return;
        }
        this.depsysstateDirtyFlag = false;
        this.depsysstate = null;
    }

    public void setEnableDynaSys(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaSys(n);
            return;
        }
        this.enabledynasys = n;
        this.enabledynasysDirtyFlag = true;
    }

    public Integer getEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaSys();
        }
        return this.enabledynasys;
    }

    public boolean isEnableDynaSysDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaSysDirty();
        }
        return this.enabledynasysDirtyFlag;
    }

    public void resetEnableDynaSys() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaSys();
            return;
        }
        this.enabledynasysDirtyFlag = false;
        this.enabledynasys = null;
    }

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
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

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
    }

    public void setPSDepSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysapiid = string;
        this.psdepsysapiidDirtyFlag = true;
    }

    public String getPSDepSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAPIId();
        }
        return this.psdepsysapiid;
    }

    public boolean isPSDepSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAPIIdDirty();
        }
        return this.psdepsysapiidDirtyFlag;
    }

    public void resetPSDepSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAPIId();
            return;
        }
        this.psdepsysapiidDirtyFlag = false;
        this.psdepsysapiid = null;
    }

    public void setPSDepSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysapiname = string;
        this.psdepsysapinameDirtyFlag = true;
    }

    public String getPSDepSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAPIName();
        }
        return this.psdepsysapiname;
    }

    public boolean isPSDepSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAPINameDirty();
        }
        return this.psdepsysapinameDirtyFlag;
    }

    public void resetPSDepSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAPIName();
            return;
        }
        this.psdepsysapinameDirtyFlag = false;
        this.psdepsysapiname = null;
    }

    public void setPSDepSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysappid = string;
        this.psdepsysappidDirtyFlag = true;
    }

    public String getPSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAppId();
        }
        return this.psdepsysappid;
    }

    public boolean isPSDepSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAppIdDirty();
        }
        return this.psdepsysappidDirtyFlag;
    }

    public void resetPSDepSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAppId();
            return;
        }
        this.psdepsysappidDirtyFlag = false;
        this.psdepsysappid = null;
    }

    public void setPSDepSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysappname = string;
        this.psdepsysappnameDirtyFlag = true;
    }

    public String getPSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAppName();
        }
        return this.psdepsysappname;
    }

    public boolean isPSDepSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysAppNameDirty();
        }
        return this.psdepsysappnameDirtyFlag;
    }

    public void resetPSDepSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysAppName();
            return;
        }
        this.psdepsysappnameDirtyFlag = false;
        this.psdepsysappname = null;
    }

    public void setPSDepSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysid = string;
        this.psdepsysidDirtyFlag = true;
    }

    public String getPSDepSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysId();
        }
        return this.psdepsysid;
    }

    public boolean isPSDepSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysIdDirty();
        }
        return this.psdepsysidDirtyFlag;
    }

    public void resetPSDepSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysId();
            return;
        }
        this.psdepsysidDirtyFlag = false;
        this.psdepsysid = null;
    }

    public void setPSDepSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysname = string;
        this.psdepsysnameDirtyFlag = true;
    }

    public String getPSDepSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysName();
        }
        return this.psdepsysname;
    }

    public boolean isPSDepSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysNameDirty();
        }
        return this.psdepsysnameDirtyFlag;
    }

    public void resetPSDepSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysName();
            return;
        }
        this.psdepsysnameDirtyFlag = false;
        this.psdepsysname = null;
    }

    public void setPSDepSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysverid = string;
        this.psdepsysveridDirtyFlag = true;
    }

    public String getPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerId();
        }
        return this.psdepsysverid;
    }

    public boolean isPSDepSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerIdDirty();
        }
        return this.psdepsysveridDirtyFlag;
    }

    public void resetPSDepSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerId();
            return;
        }
        this.psdepsysveridDirtyFlag = false;
        this.psdepsysverid = null;
    }

    public void setPSDepSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsysvername = string;
        this.psdepsysvernameDirtyFlag = true;
    }

    public String getPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVerName();
        }
        return this.psdepsysvername;
    }

    public boolean isPSDepSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysVerNameDirty();
        }
        return this.psdepsysvernameDirtyFlag;
    }

    public void resetPSDepSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysVerName();
            return;
        }
        this.psdepsysvernameDirtyFlag = false;
        this.psdepsysvername = null;
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

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setReplication(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReplication(n);
            return;
        }
        this.replication = n;
        this.replicationDirtyFlag = true;
    }

    public Integer getReplication() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReplication();
        }
        return this.replication;
    }

    public boolean isReplicationDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReplicationDirty();
        }
        return this.replicationDirtyFlag;
    }

    public void resetReplication() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReplication();
            return;
        }
        this.replicationDirtyFlag = false;
        this.replication = null;
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
        PSDepSlnSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysBase pSDepSlnSysBase) {
        pSDepSlnSysBase.resetContentType();
        pSDepSlnSysBase.resetCPULimit();
        pSDepSlnSysBase.resetCreateDate();
        pSDepSlnSysBase.resetCreateMan();
        pSDepSlnSysBase.resetDepSysState();
        pSDepSlnSysBase.resetEnableDynaSys();
        pSDepSlnSysBase.resetExpriedTime();
        pSDepSlnSysBase.resetMemo();
        pSDepSlnSysBase.resetMemoryLimit();
        pSDepSlnSysBase.resetPSDCContainerSpecId();
        pSDepSlnSysBase.resetPSDCContainerSpecName();
        pSDepSlnSysBase.resetPSDepSlnId();
        pSDepSlnSysBase.resetPSDepSlnName();
        pSDepSlnSysBase.resetPSDepSlnSysId();
        pSDepSlnSysBase.resetPSDepSlnSysName();
        pSDepSlnSysBase.resetPSDepSysAPIId();
        pSDepSlnSysBase.resetPSDepSysAPIName();
        pSDepSlnSysBase.resetPSDepSysAppId();
        pSDepSlnSysBase.resetPSDepSysAppName();
        pSDepSlnSysBase.resetPSDepSysId();
        pSDepSlnSysBase.resetPSDepSysName();
        pSDepSlnSysBase.resetPSDepSysVerId();
        pSDepSlnSysBase.resetPSDepSysVerName();
        pSDepSlnSysBase.resetPSDevCenterId();
        pSDepSlnSysBase.resetPSDevCenterName();
        pSDepSlnSysBase.resetPSSysModelInstId();
        pSDepSlnSysBase.resetPSSysModelInstName();
        pSDepSlnSysBase.resetPSSystemId();
        pSDepSlnSysBase.resetReplication();
        pSDepSlnSysBase.resetUpdateDate();
        pSDepSlnSysBase.resetUpdateMan();
        pSDepSlnSysBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
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
        if (!bl || this.isDepSysStateDirty()) {
            hashMap.put(FIELD_DEPSYSSTATE, this.getDepSysState());
        }
        if (!bl || this.isEnableDynaSysDirty()) {
            hashMap.put(FIELD_ENABLEDYNASYS, this.getEnableDynaSys());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
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
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
        }
        if (!bl || this.isPSDepSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPIID, this.getPSDepSysAPIId());
        }
        if (!bl || this.isPSDepSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPINAME, this.getPSDepSysAPIName());
        }
        if (!bl || this.isPSDepSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPPID, this.getPSDepSysAppId());
        }
        if (!bl || this.isPSDepSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSAPPNAME, this.getPSDepSysAppName());
        }
        if (!bl || this.isPSDepSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSID, this.getPSDepSysId());
        }
        if (!bl || this.isPSDepSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSNAME, this.getPSDepSysName());
        }
        if (!bl || this.isPSDepSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERID, this.getPSDepSysVerId());
        }
        if (!bl || this.isPSDepSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSVERNAME, this.getPSDepSysVerName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isReplicationDirty()) {
            hashMap.put(FIELD_REPLICATION, this.getReplication());
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
        return PSDepSlnSysBase.get(this, n);
    }

    private static Object get(PSDepSlnSysBase pSDepSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysBase.getContentType();
            }
            case 1: {
                return pSDepSlnSysBase.getCPULimit();
            }
            case 2: {
                return pSDepSlnSysBase.getCreateDate();
            }
            case 3: {
                return pSDepSlnSysBase.getCreateMan();
            }
            case 4: {
                return pSDepSlnSysBase.getDepSysState();
            }
            case 5: {
                return pSDepSlnSysBase.getEnableDynaSys();
            }
            case 6: {
                return pSDepSlnSysBase.getExpriedTime();
            }
            case 7: {
                return pSDepSlnSysBase.getMemo();
            }
            case 8: {
                return pSDepSlnSysBase.getMemoryLimit();
            }
            case 9: {
                return pSDepSlnSysBase.getPSDCContainerSpecId();
            }
            case 10: {
                return pSDepSlnSysBase.getPSDCContainerSpecName();
            }
            case 11: {
                return pSDepSlnSysBase.getPSDepSlnId();
            }
            case 12: {
                return pSDepSlnSysBase.getPSDepSlnName();
            }
            case 13: {
                return pSDepSlnSysBase.getPSDepSlnSysId();
            }
            case 14: {
                return pSDepSlnSysBase.getPSDepSlnSysName();
            }
            case 15: {
                return pSDepSlnSysBase.getPSDepSysAPIId();
            }
            case 16: {
                return pSDepSlnSysBase.getPSDepSysAPIName();
            }
            case 17: {
                return pSDepSlnSysBase.getPSDepSysAppId();
            }
            case 18: {
                return pSDepSlnSysBase.getPSDepSysAppName();
            }
            case 19: {
                return pSDepSlnSysBase.getPSDepSysId();
            }
            case 20: {
                return pSDepSlnSysBase.getPSDepSysName();
            }
            case 21: {
                return pSDepSlnSysBase.getPSDepSysVerId();
            }
            case 22: {
                return pSDepSlnSysBase.getPSDepSysVerName();
            }
            case 23: {
                return pSDepSlnSysBase.getPSDevCenterId();
            }
            case 24: {
                return pSDepSlnSysBase.getPSDevCenterName();
            }
            case 25: {
                return pSDepSlnSysBase.getPSSysModelInstId();
            }
            case 26: {
                return pSDepSlnSysBase.getPSSysModelInstName();
            }
            case 27: {
                return pSDepSlnSysBase.getPSSystemId();
            }
            case 28: {
                return pSDepSlnSysBase.getReplication();
            }
            case 29: {
                return pSDepSlnSysBase.getUpdateDate();
            }
            case 30: {
                return pSDepSlnSysBase.getUpdateMan();
            }
            case 31: {
                return pSDepSlnSysBase.getValidFlag();
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
        PSDepSlnSysBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysBase pSDepSlnSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysBase.setCPULimit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysBase.setDepSysState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysBase.setEnableDynaSys(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysBase.setMemoryLimit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnSysBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnSysBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnSysBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnSysBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnSysBase.setPSDepSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnSysBase.setPSDepSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnSysBase.setPSDepSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDepSlnSysBase.setPSDepSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDepSlnSysBase.setPSDepSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDepSlnSysBase.setPSDepSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDepSlnSysBase.setPSDepSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDepSlnSysBase.setPSDepSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDepSlnSysBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDepSlnSysBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDepSlnSysBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDepSlnSysBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDepSlnSysBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDepSlnSysBase.setReplication(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDepSlnSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSDepSlnSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDepSlnSysBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSlnSysBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysBase pSDepSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysBase.getContentType() == null;
            }
            case 1: {
                return pSDepSlnSysBase.getCPULimit() == null;
            }
            case 2: {
                return pSDepSlnSysBase.getCreateDate() == null;
            }
            case 3: {
                return pSDepSlnSysBase.getCreateMan() == null;
            }
            case 4: {
                return pSDepSlnSysBase.getDepSysState() == null;
            }
            case 5: {
                return pSDepSlnSysBase.getEnableDynaSys() == null;
            }
            case 6: {
                return pSDepSlnSysBase.getExpriedTime() == null;
            }
            case 7: {
                return pSDepSlnSysBase.getMemo() == null;
            }
            case 8: {
                return pSDepSlnSysBase.getMemoryLimit() == null;
            }
            case 9: {
                return pSDepSlnSysBase.getPSDCContainerSpecId() == null;
            }
            case 10: {
                return pSDepSlnSysBase.getPSDCContainerSpecName() == null;
            }
            case 11: {
                return pSDepSlnSysBase.getPSDepSlnId() == null;
            }
            case 12: {
                return pSDepSlnSysBase.getPSDepSlnName() == null;
            }
            case 13: {
                return pSDepSlnSysBase.getPSDepSlnSysId() == null;
            }
            case 14: {
                return pSDepSlnSysBase.getPSDepSlnSysName() == null;
            }
            case 15: {
                return pSDepSlnSysBase.getPSDepSysAPIId() == null;
            }
            case 16: {
                return pSDepSlnSysBase.getPSDepSysAPIName() == null;
            }
            case 17: {
                return pSDepSlnSysBase.getPSDepSysAppId() == null;
            }
            case 18: {
                return pSDepSlnSysBase.getPSDepSysAppName() == null;
            }
            case 19: {
                return pSDepSlnSysBase.getPSDepSysId() == null;
            }
            case 20: {
                return pSDepSlnSysBase.getPSDepSysName() == null;
            }
            case 21: {
                return pSDepSlnSysBase.getPSDepSysVerId() == null;
            }
            case 22: {
                return pSDepSlnSysBase.getPSDepSysVerName() == null;
            }
            case 23: {
                return pSDepSlnSysBase.getPSDevCenterId() == null;
            }
            case 24: {
                return pSDepSlnSysBase.getPSDevCenterName() == null;
            }
            case 25: {
                return pSDepSlnSysBase.getPSSysModelInstId() == null;
            }
            case 26: {
                return pSDepSlnSysBase.getPSSysModelInstName() == null;
            }
            case 27: {
                return pSDepSlnSysBase.getPSSystemId() == null;
            }
            case 28: {
                return pSDepSlnSysBase.getReplication() == null;
            }
            case 29: {
                return pSDepSlnSysBase.getUpdateDate() == null;
            }
            case 30: {
                return pSDepSlnSysBase.getUpdateMan() == null;
            }
            case 31: {
                return pSDepSlnSysBase.getValidFlag() == null;
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
        return PSDepSlnSysBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysBase pSDepSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysBase.isContentTypeDirty();
            }
            case 1: {
                return pSDepSlnSysBase.isCPULimitDirty();
            }
            case 2: {
                return pSDepSlnSysBase.isCreateDateDirty();
            }
            case 3: {
                return pSDepSlnSysBase.isCreateManDirty();
            }
            case 4: {
                return pSDepSlnSysBase.isDepSysStateDirty();
            }
            case 5: {
                return pSDepSlnSysBase.isEnableDynaSysDirty();
            }
            case 6: {
                return pSDepSlnSysBase.isExpriedTimeDirty();
            }
            case 7: {
                return pSDepSlnSysBase.isMemoDirty();
            }
            case 8: {
                return pSDepSlnSysBase.isMemoryLimitDirty();
            }
            case 9: {
                return pSDepSlnSysBase.isPSDCContainerSpecIdDirty();
            }
            case 10: {
                return pSDepSlnSysBase.isPSDCContainerSpecNameDirty();
            }
            case 11: {
                return pSDepSlnSysBase.isPSDepSlnIdDirty();
            }
            case 12: {
                return pSDepSlnSysBase.isPSDepSlnNameDirty();
            }
            case 13: {
                return pSDepSlnSysBase.isPSDepSlnSysIdDirty();
            }
            case 14: {
                return pSDepSlnSysBase.isPSDepSlnSysNameDirty();
            }
            case 15: {
                return pSDepSlnSysBase.isPSDepSysAPIIdDirty();
            }
            case 16: {
                return pSDepSlnSysBase.isPSDepSysAPINameDirty();
            }
            case 17: {
                return pSDepSlnSysBase.isPSDepSysAppIdDirty();
            }
            case 18: {
                return pSDepSlnSysBase.isPSDepSysAppNameDirty();
            }
            case 19: {
                return pSDepSlnSysBase.isPSDepSysIdDirty();
            }
            case 20: {
                return pSDepSlnSysBase.isPSDepSysNameDirty();
            }
            case 21: {
                return pSDepSlnSysBase.isPSDepSysVerIdDirty();
            }
            case 22: {
                return pSDepSlnSysBase.isPSDepSysVerNameDirty();
            }
            case 23: {
                return pSDepSlnSysBase.isPSDevCenterIdDirty();
            }
            case 24: {
                return pSDepSlnSysBase.isPSDevCenterNameDirty();
            }
            case 25: {
                return pSDepSlnSysBase.isPSSysModelInstIdDirty();
            }
            case 26: {
                return pSDepSlnSysBase.isPSSysModelInstNameDirty();
            }
            case 27: {
                return pSDepSlnSysBase.isPSSystemIdDirty();
            }
            case 28: {
                return pSDepSlnSysBase.isReplicationDirty();
            }
            case 29: {
                return pSDepSlnSysBase.isUpdateDateDirty();
            }
            case 30: {
                return pSDepSlnSysBase.isUpdateManDirty();
            }
            case 31: {
                return pSDepSlnSysBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysBase pSDepSlnSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getContentType()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getCPULimit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpulimit", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getCPULimit()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getDepSysState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depsysstate", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getDepSysState()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getEnableDynaSys() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynasys", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getEnableDynaSys()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getMemoryLimit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memorylimit", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getMemoryLimit()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysapiid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysAPIId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysapiname", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysAPIName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysappid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysAppId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysappname", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysAppName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysname", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysverid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysVerId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsysvername", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDepSysVerName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getReplication() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"replication", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getReplication()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSlnSysBase.getJSONValue((Object)pSDepSlnSysBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysBase pSDepSlnSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysBase.getContentType() != null) {
            object = pSDepSlnSysBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getCPULimit() != null) {
            object = pSDepSlnSysBase.getCPULimit();
            xmlNode.setAttribute(FIELD_CPULIMIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getCreateDate() != null) {
            object = pSDepSlnSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getCreateMan() != null) {
            object = pSDepSlnSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getDepSysState() != null) {
            object = pSDepSlnSysBase.getDepSysState();
            xmlNode.setAttribute(FIELD_DEPSYSSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getEnableDynaSys() != null) {
            object = pSDepSlnSysBase.getEnableDynaSys();
            xmlNode.setAttribute(FIELD_ENABLEDYNASYS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getExpriedTime() != null) {
            object = pSDepSlnSysBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getMemo() != null) {
            object = pSDepSlnSysBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getMemoryLimit() != null) {
            object = pSDepSlnSysBase.getMemoryLimit();
            xmlNode.setAttribute(FIELD_MEMORYLIMIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getPSDCContainerSpecId() != null) {
            object = pSDepSlnSysBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDCContainerSpecName() != null) {
            object = pSDepSlnSysBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnId() != null) {
            object = pSDepSlnSysBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnName() != null) {
            object = pSDepSlnSysBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAPIId() != null) {
            object = pSDepSlnSysBase.getPSDepSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAPIName() != null) {
            object = pSDepSlnSysBase.getPSDepSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAppId() != null) {
            object = pSDepSlnSysBase.getPSDepSysAppId();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysAppName() != null) {
            object = pSDepSlnSysBase.getPSDepSysAppName();
            xmlNode.setAttribute(FIELD_PSDEPSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysId() != null) {
            object = pSDepSlnSysBase.getPSDepSysId();
            xmlNode.setAttribute(FIELD_PSDEPSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysName() != null) {
            object = pSDepSlnSysBase.getPSDepSysName();
            xmlNode.setAttribute(FIELD_PSDEPSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysVerId() != null) {
            object = pSDepSlnSysBase.getPSDepSysVerId();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDepSysVerName() != null) {
            object = pSDepSlnSysBase.getPSDepSysVerName();
            xmlNode.setAttribute(FIELD_PSDEPSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDevCenterId() != null) {
            object = pSDepSlnSysBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSDevCenterName() != null) {
            object = pSDepSlnSysBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSSysModelInstId() != null) {
            object = pSDepSlnSysBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSSysModelInstName() != null) {
            object = pSDepSlnSysBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getPSSystemId() != null) {
            object = pSDepSlnSysBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getReplication() != null) {
            object = pSDepSlnSysBase.getReplication();
            xmlNode.setAttribute(FIELD_REPLICATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getUpdateDate() != null) {
            object = pSDepSlnSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysBase.getUpdateMan() != null) {
            object = pSDepSlnSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysBase.getValidFlag() != null) {
            object = pSDepSlnSysBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysBase pSDepSlnSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysBase.isContentTypeDirty() && (bl || pSDepSlnSysBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDepSlnSysBase.getContentType());
        }
        if (pSDepSlnSysBase.isCPULimitDirty() && (bl || pSDepSlnSysBase.getCPULimit() != null)) {
            iDataObject.set(FIELD_CPULIMIT, (Object)pSDepSlnSysBase.getCPULimit());
        }
        if (pSDepSlnSysBase.isCreateDateDirty() && (bl || pSDepSlnSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysBase.getCreateDate());
        }
        if (pSDepSlnSysBase.isCreateManDirty() && (bl || pSDepSlnSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysBase.getCreateMan());
        }
        if (pSDepSlnSysBase.isDepSysStateDirty() && (bl || pSDepSlnSysBase.getDepSysState() != null)) {
            iDataObject.set(FIELD_DEPSYSSTATE, (Object)pSDepSlnSysBase.getDepSysState());
        }
        if (pSDepSlnSysBase.isEnableDynaSysDirty() && (bl || pSDepSlnSysBase.getEnableDynaSys() != null)) {
            iDataObject.set(FIELD_ENABLEDYNASYS, (Object)pSDepSlnSysBase.getEnableDynaSys());
        }
        if (pSDepSlnSysBase.isExpriedTimeDirty() && (bl || pSDepSlnSysBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDepSlnSysBase.getExpriedTime());
        }
        if (pSDepSlnSysBase.isMemoDirty() && (bl || pSDepSlnSysBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysBase.getMemo());
        }
        if (pSDepSlnSysBase.isMemoryLimitDirty() && (bl || pSDepSlnSysBase.getMemoryLimit() != null)) {
            iDataObject.set(FIELD_MEMORYLIMIT, (Object)pSDepSlnSysBase.getMemoryLimit());
        }
        if (pSDepSlnSysBase.isPSDCContainerSpecIdDirty() && (bl || pSDepSlnSysBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDepSlnSysBase.getPSDCContainerSpecId());
        }
        if (pSDepSlnSysBase.isPSDCContainerSpecNameDirty() && (bl || pSDepSlnSysBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDepSlnSysBase.getPSDCContainerSpecName());
        }
        if (pSDepSlnSysBase.isPSDepSlnIdDirty() && (bl || pSDepSlnSysBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnSysBase.getPSDepSlnId());
        }
        if (pSDepSlnSysBase.isPSDepSlnNameDirty() && (bl || pSDepSlnSysBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnSysBase.getPSDepSlnName());
        }
        if (pSDepSlnSysBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysBase.isPSDepSysAPIIdDirty() && (bl || pSDepSlnSysBase.getPSDepSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPIID, (Object)pSDepSlnSysBase.getPSDepSysAPIId());
        }
        if (pSDepSlnSysBase.isPSDepSysAPINameDirty() && (bl || pSDepSlnSysBase.getPSDepSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPINAME, (Object)pSDepSlnSysBase.getPSDepSysAPIName());
        }
        if (pSDepSlnSysBase.isPSDepSysAppIdDirty() && (bl || pSDepSlnSysBase.getPSDepSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPPID, (Object)pSDepSlnSysBase.getPSDepSysAppId());
        }
        if (pSDepSlnSysBase.isPSDepSysAppNameDirty() && (bl || pSDepSlnSysBase.getPSDepSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSAPPNAME, (Object)pSDepSlnSysBase.getPSDepSysAppName());
        }
        if (pSDepSlnSysBase.isPSDepSysIdDirty() && (bl || pSDepSlnSysBase.getPSDepSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSID, (Object)pSDepSlnSysBase.getPSDepSysId());
        }
        if (pSDepSlnSysBase.isPSDepSysNameDirty() && (bl || pSDepSlnSysBase.getPSDepSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSNAME, (Object)pSDepSlnSysBase.getPSDepSysName());
        }
        if (pSDepSlnSysBase.isPSDepSysVerIdDirty() && (bl || pSDepSlnSysBase.getPSDepSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERID, (Object)pSDepSlnSysBase.getPSDepSysVerId());
        }
        if (pSDepSlnSysBase.isPSDepSysVerNameDirty() && (bl || pSDepSlnSysBase.getPSDepSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSVERNAME, (Object)pSDepSlnSysBase.getPSDepSysVerName());
        }
        if (pSDepSlnSysBase.isPSDevCenterIdDirty() && (bl || pSDepSlnSysBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDepSlnSysBase.getPSDevCenterId());
        }
        if (pSDepSlnSysBase.isPSDevCenterNameDirty() && (bl || pSDepSlnSysBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDepSlnSysBase.getPSDevCenterName());
        }
        if (pSDepSlnSysBase.isPSSysModelInstIdDirty() && (bl || pSDepSlnSysBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDepSlnSysBase.getPSSysModelInstId());
        }
        if (pSDepSlnSysBase.isPSSysModelInstNameDirty() && (bl || pSDepSlnSysBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSDepSlnSysBase.getPSSysModelInstName());
        }
        if (pSDepSlnSysBase.isPSSystemIdDirty() && (bl || pSDepSlnSysBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDepSlnSysBase.getPSSystemId());
        }
        if (pSDepSlnSysBase.isReplicationDirty() && (bl || pSDepSlnSysBase.getReplication() != null)) {
            iDataObject.set(FIELD_REPLICATION, (Object)pSDepSlnSysBase.getReplication());
        }
        if (pSDepSlnSysBase.isUpdateDateDirty() && (bl || pSDepSlnSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysBase.getUpdateDate());
        }
        if (pSDepSlnSysBase.isUpdateManDirty() && (bl || pSDepSlnSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysBase.getUpdateMan());
        }
        if (pSDepSlnSysBase.isValidFlagDirty() && (bl || pSDepSlnSysBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSlnSysBase.getValidFlag());
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
        return PSDepSlnSysBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysBase pSDepSlnSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysBase.resetContentType();
                return true;
            }
            case 1: {
                pSDepSlnSysBase.resetCPULimit();
                return true;
            }
            case 2: {
                pSDepSlnSysBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDepSlnSysBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDepSlnSysBase.resetDepSysState();
                return true;
            }
            case 5: {
                pSDepSlnSysBase.resetEnableDynaSys();
                return true;
            }
            case 6: {
                pSDepSlnSysBase.resetExpriedTime();
                return true;
            }
            case 7: {
                pSDepSlnSysBase.resetMemo();
                return true;
            }
            case 8: {
                pSDepSlnSysBase.resetMemoryLimit();
                return true;
            }
            case 9: {
                pSDepSlnSysBase.resetPSDCContainerSpecId();
                return true;
            }
            case 10: {
                pSDepSlnSysBase.resetPSDCContainerSpecName();
                return true;
            }
            case 11: {
                pSDepSlnSysBase.resetPSDepSlnId();
                return true;
            }
            case 12: {
                pSDepSlnSysBase.resetPSDepSlnName();
                return true;
            }
            case 13: {
                pSDepSlnSysBase.resetPSDepSlnSysId();
                return true;
            }
            case 14: {
                pSDepSlnSysBase.resetPSDepSlnSysName();
                return true;
            }
            case 15: {
                pSDepSlnSysBase.resetPSDepSysAPIId();
                return true;
            }
            case 16: {
                pSDepSlnSysBase.resetPSDepSysAPIName();
                return true;
            }
            case 17: {
                pSDepSlnSysBase.resetPSDepSysAppId();
                return true;
            }
            case 18: {
                pSDepSlnSysBase.resetPSDepSysAppName();
                return true;
            }
            case 19: {
                pSDepSlnSysBase.resetPSDepSysId();
                return true;
            }
            case 20: {
                pSDepSlnSysBase.resetPSDepSysName();
                return true;
            }
            case 21: {
                pSDepSlnSysBase.resetPSDepSysVerId();
                return true;
            }
            case 22: {
                pSDepSlnSysBase.resetPSDepSysVerName();
                return true;
            }
            case 23: {
                pSDepSlnSysBase.resetPSDevCenterId();
                return true;
            }
            case 24: {
                pSDepSlnSysBase.resetPSDevCenterName();
                return true;
            }
            case 25: {
                pSDepSlnSysBase.resetPSSysModelInstId();
                return true;
            }
            case 26: {
                pSDepSlnSysBase.resetPSSysModelInstName();
                return true;
            }
            case 27: {
                pSDepSlnSysBase.resetPSSystemId();
                return true;
            }
            case 28: {
                pSDepSlnSysBase.resetReplication();
                return true;
            }
            case 29: {
                pSDepSlnSysBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSDepSlnSysBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSDepSlnSysBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCContainerSpec getPSDCContainerSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpec();
        }
        if (this.getPSDCContainerSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDCContainerSpecLock;
        synchronized (n) {
            if (this.psdccontainerspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCContainerSpecId(), (Object)this.psdccontainerspec.getPSDCContainerSpecId()) != 0L) {
                this.psdccontainerspec = null;
            }
            if (this.psdccontainerspec == null) {
                PSDCContainerSpec pSDCContainerSpec = new PSDCContainerSpec();
                pSDCContainerSpec.setPSDCContainerSpecId(this.getPSDCContainerSpecId());
                PSDCContainerSpecService pSDCContainerSpecService = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDCContainerSpecService.autoGet((IEntity)pSDCContainerSpec);
                this.psdccontainerspec = pSDCContainerSpec;
            }
            return this.psdccontainerspec;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSysAPI getPSDepSysAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysAPI();
        }
        if (this.getPSDepSysAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysAPILock;
        synchronized (n) {
            if (this.psdepsysapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysAPIId(), (Object)this.psdepsysapi.getPSDepSysAPIId()) != 0L) {
                this.psdepsysapi = null;
            }
            if (this.psdepsysapi == null) {
                PSDepSysAPI pSDepSysAPI = new PSDepSysAPI();
                pSDepSysAPI.setPSDepSysAPIId(this.getPSDepSysAPIId());
                PSDepSysAPIService pSDepSysAPIService = (PSDepSysAPIService)ServiceGlobal.getService(PSDepSysAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysAPIService.autoGet((IEntity)pSDepSysAPI);
                this.psdepsysapi = pSDepSysAPI;
            }
            return this.psdepsysapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSysApp getPSDepSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysApp();
        }
        if (this.getPSDepSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysAppLock;
        synchronized (n) {
            if (this.psdepsysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysAppId(), (Object)this.psdepsysapp.getPSDepSysAppId()) != 0L) {
                this.psdepsysapp = null;
            }
            if (this.psdepsysapp == null) {
                PSDepSysApp pSDepSysApp = new PSDepSysApp();
                pSDepSysApp.setPSDepSysAppId(this.getPSDepSysAppId());
                PSDepSysAppService pSDepSysAppService = (PSDepSysAppService)ServiceGlobal.getService(PSDepSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysAppService.autoGet((IEntity)pSDepSysApp);
                this.psdepsysapp = pSDepSysApp;
            }
            return this.psdepsysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSysVer getPSDepSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysVer();
        }
        if (this.getPSDepSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysVerLock;
        synchronized (n) {
            if (this.psdepsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysVerId(), (Object)this.psdepsysver.getPSDepSysVerId()) != 0L) {
                this.psdepsysver = null;
            }
            if (this.psdepsysver == null) {
                PSDepSysVer pSDepSysVer = new PSDepSysVer();
                pSDepSysVer.setPSDepSysVerId(this.getPSDepSysVerId());
                PSDepSysVerService pSDepSysVerService = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysVerService.autoGet((IEntity)pSDepSysVer);
                this.psdepsysver = pSDepSysVer;
            }
            return this.psdepsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSys getPSDepSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSys();
        }
        if (this.getPSDepSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSysLock;
        synchronized (n) {
            if (this.psdepsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSysId(), (Object)this.psdepsys.getPSDepSysId()) != 0L) {
                this.psdepsys = null;
            }
            if (this.psdepsys == null) {
                PSDepSys pSDepSys = new PSDepSys();
                pSDepSys.setPSDepSysId(this.getPSDepSysId());
                PSDepSysService pSDepSysService = (PSDepSysService)ServiceGlobal.getService(PSDepSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSysService.autoGet((IEntity)pSDepSys);
                this.psdepsys = pSDepSys;
            }
            return this.psdepsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnParam> getPSDepSlnParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnParams();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnParamService pSDepSlnParamService = (PSDepSlnParamService)ServiceGlobal.getService(PSDepSlnParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnParamsLock;
        synchronized (n) {
            if (this.psdepslnparams == null) {
                this.psdepslnparams = pSDepSlnParamService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnparams;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysAPI> getPSDepSlnSysAPIs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysAPIs();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysAPIService pSDepSlnSysAPIService = (PSDepSlnSysAPIService)ServiceGlobal.getService(PSDepSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysAPIsLock;
        synchronized (n) {
            if (this.psdepslnsysapis == null) {
                this.psdepslnsysapis = pSDepSlnSysAPIService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsysapis;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysApp> getPSDepSlnSysApps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysApps();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysAppService pSDepSlnSysAppService = (PSDepSlnSysAppService)ServiceGlobal.getService(PSDepSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysAppsLock;
        synchronized (n) {
            if (this.psdepslnsysapps == null) {
                this.psdepslnsysapps = pSDepSlnSysAppService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsysapps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysAS> getPSDepSlnSysAses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysAses();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysASService pSDepSlnSysASService = (PSDepSlnSysASService)ServiceGlobal.getService(PSDepSlnSysASService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysAsesLock;
        synchronized (n) {
            if (this.psdepslnsysases == null) {
                this.psdepslnsysases = pSDepSlnSysASService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsysases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysBD> getPSDepSlnSysBDs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysBDs();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysBDService pSDepSlnSysBDService = (PSDepSlnSysBDService)ServiceGlobal.getService(PSDepSlnSysBDService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysBDsLock;
        synchronized (n) {
            if (this.psdepslnsysbds == null) {
                this.psdepslnsysbds = pSDepSlnSysBDService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsysbds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysDynaInst> getPSDepSlnSysDynaInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDynaInsts();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysDynaInstService pSDepSlnSysDynaInstService = (PSDepSlnSysDynaInstService)ServiceGlobal.getService(PSDepSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysDynaInstsLock;
        synchronized (n) {
            if (this.psdepslnsysdynainsts == null) {
                this.psdepslnsysdynainsts = pSDepSlnSysDynaInstService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsysdynainsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysFile> getPSDepSlnSysFiles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysFiles();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysFileService pSDepSlnSysFileService = (PSDepSlnSysFileService)ServiceGlobal.getService(PSDepSlnSysFileService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysFilesLock;
        synchronized (n) {
            if (this.psdepslnsysfiles == null) {
                this.psdepslnsysfiles = pSDepSlnSysFileService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsysfiles;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysKey> getPSDepSlnSysKeys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysKeys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysKeyService pSDepSlnSysKeyService = (PSDepSlnSysKeyService)ServiceGlobal.getService(PSDepSlnSysKeyService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysKeysLock;
        synchronized (n) {
            if (this.psdepslnsyskeys == null) {
                this.psdepslnsyskeys = pSDepSlnSysKeyService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsyskeys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDepSlnSysWF> getPSDepSlnSysWFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysWFs();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        PSDepSlnSysWFService pSDepSlnSysWFService = (PSDepSlnSysWFService)ServiceGlobal.getService(PSDepSlnSysWFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDepSlnSysWFsLock;
        synchronized (n) {
            if (this.psdepslnsyswfs == null) {
                this.psdepslnsyswfs = pSDepSlnSysWFService.selectByPSDepSlnSys(this);
            }
            return this.psdepslnsyswfs;
        }
    }

    private PSDepSlnSysBase getProxyEntity() {
        return this.proxyPSDepSlnSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysBase) {
            this.proxyPSDepSlnSysBase = (PSDepSlnSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENTTYPE, 0);
        fieldIndexMap.put(FIELD_CPULIMIT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEPSYSSTATE, 4);
        fieldIndexMap.put(FIELD_ENABLEDYNASYS, 5);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_MEMORYLIMIT, 8);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 9);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 12);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 13);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 14);
        fieldIndexMap.put(FIELD_PSDEPSYSAPIID, 15);
        fieldIndexMap.put(FIELD_PSDEPSYSAPINAME, 16);
        fieldIndexMap.put(FIELD_PSDEPSYSAPPID, 17);
        fieldIndexMap.put(FIELD_PSDEPSYSAPPNAME, 18);
        fieldIndexMap.put(FIELD_PSDEPSYSID, 19);
        fieldIndexMap.put(FIELD_PSDEPSYSNAME, 20);
        fieldIndexMap.put(FIELD_PSDEPSYSVERID, 21);
        fieldIndexMap.put(FIELD_PSDEPSYSVERNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 23);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 25);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 27);
        fieldIndexMap.put(FIELD_REPLICATION, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_VALIDFLAG, 31);
    }
}

