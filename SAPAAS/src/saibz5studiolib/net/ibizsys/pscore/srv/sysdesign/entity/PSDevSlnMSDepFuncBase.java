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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPLOYSTATE = "DEPLOYSTATE";
    public static final String FIELD_FUNCTYPE = "FUNCTYPE";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNODEID = "PSDCMSPLATFORMNODEID";
    public static final String FIELD_PSDCMSPLATFORMNODENAME = "PSDCMSPLATFORMNODENAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPFUNCID = "PSDEVSLNMSDEPFUNCID";
    public static final String FIELD_PSDEVSLNMSDEPFUNCNAME = "PSDEVSLNMSDEPFUNCNAME";
    public static final String FIELD_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String FIELD_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEPLOYSTATE = 2;
    private static final int INDEX_FUNCTYPE = 3;
    private static final int INDEX_HTTPADDRESS = 4;
    private static final int INDEX_HTTPPORT = 5;
    private static final int INDEX_HTTPSPORT = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDCMSPLATFORMID = 8;
    private static final int INDEX_PSDCMSPLATFORMNODEID = 9;
    private static final int INDEX_PSDCMSPLATFORMNODENAME = 10;
    private static final int INDEX_PSDEVCENTERDBINSTID = 11;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 12;
    private static final int INDEX_PSDEVCENTERSVNID = 13;
    private static final int INDEX_PSDEVCENTERSVNNAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNMSDEPFUNCID = 16;
    private static final int INDEX_PSDEVSLNMSDEPFUNCNAME = 17;
    private static final int INDEX_PSDEVSLNMSDEPLOYID = 18;
    private static final int INDEX_PSDEVSLNMSDEPLOYNAME = 19;
    private static final int INDEX_PSDEVSLNNAME = 20;
    private static final int INDEX_PSDEVSLNPIPELINEID = 21;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 22;
    private static final int INDEX_PSDEVSLNSYSID = 23;
    private static final int INDEX_PSDEVSLNSYSNAME = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_USERPARAMS = 27;
    private static final int INDEX_VALIDFLAG = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnMSDepFuncBase proxyPSDevSlnMSDepFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deploystateDirtyFlag = false;
    private boolean functypeDirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnodeidDirtyFlag = false;
    private boolean psdcmsplatformnodenameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdepfuncidDirtyFlag = false;
    private boolean psdevslnmsdepfuncnameDirtyFlag = false;
    private boolean psdevslnmsdeployidDirtyFlag = false;
    private boolean psdevslnmsdeploynameDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deploystate")
    private Integer deploystate;
    @Column(name="functype")
    private String functype;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformnodeid")
    private String psdcmsplatformnodeid;
    @Column(name="psdcmsplatformnodename")
    private String psdcmsplatformnodename;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdepfuncid")
    private String psdevslnmsdepfuncid;
    @Column(name="psdevslnmsdepfuncname")
    private String psdevslnmsdepfuncname;
    @Column(name="psdevslnmsdeployid")
    private String psdevslnmsdeployid;
    @Column(name="psdevslnmsdeployname")
    private String psdevslnmsdeployname;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnpipelineid")
    private String psdevslnpipelineid;
    @Column(name="psdevslnpipelinename")
    private String psdevslnpipelinename;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCMSPlatformNodeLock = new Integer(1);
    private PSDCMSPlatformNode psdcmsplatformnode = null;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevSlnMSDeployLock = new Integer(1);
    private PSDevSlnMSDeploy psdevslnmsdeploy = null;
    private Integer objPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline psdevslnpipeline = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevSlnMSDepFuncItemsLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepFuncItem> psdevslnmsdepfuncitems = null;

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

    public void setDeployState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployState(n);
            return;
        }
        this.deploystate = n;
        this.deploystateDirtyFlag = true;
    }

    public Integer getDeployState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployState();
        }
        return this.deploystate;
    }

    public boolean isDeployStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployStateDirty();
        }
        return this.deploystateDirtyFlag;
    }

    public void resetDeployState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployState();
            return;
        }
        this.deploystateDirtyFlag = false;
        this.deploystate = null;
    }

    public void setFuncType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.functype = string;
        this.functypeDirtyFlag = true;
    }

    public String getFuncType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncType();
        }
        return this.functype;
    }

    public boolean isFuncTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncTypeDirty();
        }
        return this.functypeDirtyFlag;
    }

    public void resetFuncType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncType();
            return;
        }
        this.functypeDirtyFlag = false;
        this.functype = null;
    }

    public void setHttpAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.httpaddress = string;
        this.httpaddressDirtyFlag = true;
    }

    public String getHttpAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpAddress();
        }
        return this.httpaddress;
    }

    public boolean isHttpAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpAddressDirty();
        }
        return this.httpaddressDirtyFlag;
    }

    public void resetHttpAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpAddress();
            return;
        }
        this.httpaddressDirtyFlag = false;
        this.httpaddress = null;
    }

    public void setHttpPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpPort(n);
            return;
        }
        this.httpport = n;
        this.httpportDirtyFlag = true;
    }

    public Integer getHttpPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpPort();
        }
        return this.httpport;
    }

    public boolean isHttpPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpPortDirty();
        }
        return this.httpportDirtyFlag;
    }

    public void resetHttpPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpPort();
            return;
        }
        this.httpportDirtyFlag = false;
        this.httpport = null;
    }

    public void setHttpsPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpsPort(n);
            return;
        }
        this.httpsport = n;
        this.httpsportDirtyFlag = true;
    }

    public Integer getHttpsPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpsPort();
        }
        return this.httpsport;
    }

    public boolean isHttpsPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpsPortDirty();
        }
        return this.httpsportDirtyFlag;
    }

    public void resetHttpsPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpsPort();
            return;
        }
        this.httpsportDirtyFlag = false;
        this.httpsport = null;
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

    public void setPSDCMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformid = string;
        this.psdcmsplatformidDirtyFlag = true;
    }

    public String getPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformId();
        }
        return this.psdcmsplatformid;
    }

    public boolean isPSDCMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformIdDirty();
        }
        return this.psdcmsplatformidDirtyFlag;
    }

    public void resetPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformId();
            return;
        }
        this.psdcmsplatformidDirtyFlag = false;
        this.psdcmsplatformid = null;
    }

    public void setPSDCMSPlatformNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformnodeid = string;
        this.psdcmsplatformnodeidDirtyFlag = true;
    }

    public String getPSDCMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNodeId();
        }
        return this.psdcmsplatformnodeid;
    }

    public boolean isPSDCMSPlatformNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNodeIdDirty();
        }
        return this.psdcmsplatformnodeidDirtyFlag;
    }

    public void resetPSDCMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformNodeId();
            return;
        }
        this.psdcmsplatformnodeidDirtyFlag = false;
        this.psdcmsplatformnodeid = null;
    }

    public void setPSDCMSPlatformNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformnodename = string;
        this.psdcmsplatformnodenameDirtyFlag = true;
    }

    public String getPSDCMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNodeName();
        }
        return this.psdcmsplatformnodename;
    }

    public boolean isPSDCMSPlatformNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNodeNameDirty();
        }
        return this.psdcmsplatformnodenameDirtyFlag;
    }

    public void resetPSDCMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformNodeName();
            return;
        }
        this.psdcmsplatformnodenameDirtyFlag = false;
        this.psdcmsplatformnodename = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
    }

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnMSDepFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncid = string;
        this.psdevslnmsdepfuncidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncId();
        }
        return this.psdevslnmsdepfuncid;
    }

    public boolean isPSDevSlnMSDepFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncIdDirty();
        }
        return this.psdevslnmsdepfuncidDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncId();
            return;
        }
        this.psdevslnmsdepfuncidDirtyFlag = false;
        this.psdevslnmsdepfuncid = null;
    }

    public void setPSDevSlnMSDepFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepfuncname = string;
        this.psdevslnmsdepfuncnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncName();
        }
        return this.psdevslnmsdepfuncname;
    }

    public boolean isPSDevSlnMSDepFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepFuncNameDirty();
        }
        return this.psdevslnmsdepfuncnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepFuncName();
            return;
        }
        this.psdevslnmsdepfuncnameDirtyFlag = false;
        this.psdevslnmsdepfuncname = null;
    }

    public void setPSDevSlnMSDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployid = string;
        this.psdevslnmsdeployidDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployId();
        }
        return this.psdevslnmsdeployid;
    }

    public boolean isPSDevSlnMSDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployIdDirty();
        }
        return this.psdevslnmsdeployidDirtyFlag;
    }

    public void resetPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployId();
            return;
        }
        this.psdevslnmsdeployidDirtyFlag = false;
        this.psdevslnmsdeployid = null;
    }

    public void setPSDevSlnMSDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployname = string;
        this.psdevslnmsdeploynameDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployName();
        }
        return this.psdevslnmsdeployname;
    }

    public boolean isPSDevSlnMSDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployNameDirty();
        }
        return this.psdevslnmsdeploynameDirtyFlag;
    }

    public void resetPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployName();
            return;
        }
        this.psdevslnmsdeploynameDirtyFlag = false;
        this.psdevslnmsdeployname = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnPipelineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelineid = string;
        this.psdevslnpipelineidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineId();
        }
        return this.psdevslnpipelineid;
    }

    public boolean isPSDevSlnPipelineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineIdDirty();
        }
        return this.psdevslnpipelineidDirtyFlag;
    }

    public void resetPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineId();
            return;
        }
        this.psdevslnpipelineidDirtyFlag = false;
        this.psdevslnpipelineid = null;
    }

    public void setPSDevSlnPipelineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinename = string;
        this.psdevslnpipelinenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineName();
        }
        return this.psdevslnpipelinename;
    }

    public boolean isPSDevSlnPipelineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineNameDirty();
        }
        return this.psdevslnpipelinenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineName();
            return;
        }
        this.psdevslnpipelinenameDirtyFlag = false;
        this.psdevslnpipelinename = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSDevSlnMSDepFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase) {
        pSDevSlnMSDepFuncBase.resetCreateDate();
        pSDevSlnMSDepFuncBase.resetCreateMan();
        pSDevSlnMSDepFuncBase.resetDeployState();
        pSDevSlnMSDepFuncBase.resetFuncType();
        pSDevSlnMSDepFuncBase.resetHttpAddress();
        pSDevSlnMSDepFuncBase.resetHttpPort();
        pSDevSlnMSDepFuncBase.resetHttpsPort();
        pSDevSlnMSDepFuncBase.resetMemo();
        pSDevSlnMSDepFuncBase.resetPSDCMSPlatformId();
        pSDevSlnMSDepFuncBase.resetPSDCMSPlatformNodeId();
        pSDevSlnMSDepFuncBase.resetPSDCMSPlatformNodeName();
        pSDevSlnMSDepFuncBase.resetPSDevCenterDBInstId();
        pSDevSlnMSDepFuncBase.resetPSDevCenterDBInstName();
        pSDevSlnMSDepFuncBase.resetPSDevCenterSVNId();
        pSDevSlnMSDepFuncBase.resetPSDevCenterSVNName();
        pSDevSlnMSDepFuncBase.resetPSDevSlnId();
        pSDevSlnMSDepFuncBase.resetPSDevSlnMSDepFuncId();
        pSDevSlnMSDepFuncBase.resetPSDevSlnMSDepFuncName();
        pSDevSlnMSDepFuncBase.resetPSDevSlnMSDeployId();
        pSDevSlnMSDepFuncBase.resetPSDevSlnMSDeployName();
        pSDevSlnMSDepFuncBase.resetPSDevSlnName();
        pSDevSlnMSDepFuncBase.resetPSDevSlnPipelineId();
        pSDevSlnMSDepFuncBase.resetPSDevSlnPipelineName();
        pSDevSlnMSDepFuncBase.resetPSDevSlnSysId();
        pSDevSlnMSDepFuncBase.resetPSDevSlnSysName();
        pSDevSlnMSDepFuncBase.resetUpdateDate();
        pSDevSlnMSDepFuncBase.resetUpdateMan();
        pSDevSlnMSDepFuncBase.resetUserParams();
        pSDevSlnMSDepFuncBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDeployStateDirty()) {
            hashMap.put(FIELD_DEPLOYSTATE, this.getDeployState());
        }
        if (!bl || this.isFuncTypeDirty()) {
            hashMap.put(FIELD_FUNCTYPE, this.getFuncType());
        }
        if (!bl || this.isHttpAddressDirty()) {
            hashMap.put(FIELD_HTTPADDRESS, this.getHttpAddress());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isHttpsPortDirty()) {
            hashMap.put(FIELD_HTTPSPORT, this.getHttpsPort());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNodeIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNODEID, this.getPSDCMSPlatformNodeId());
        }
        if (!bl || this.isPSDCMSPlatformNodeNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNODENAME, this.getPSDCMSPlatformNodeName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnMSDepFuncIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCID, this.getPSDevSlnMSDepFuncId());
        }
        if (!bl || this.isPSDevSlnMSDepFuncNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, this.getPSDevSlnMSDepFuncName());
        }
        if (!bl || this.isPSDevSlnMSDeployIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYID, this.getPSDevSlnMSDeployId());
        }
        if (!bl || this.isPSDevSlnMSDeployNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, this.getPSDevSlnMSDeployName());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEID, this.getPSDevSlnPipelineId());
        }
        if (!bl || this.isPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINENAME, this.getPSDevSlnPipelineName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDevSlnMSDepFuncBase.get(this, n);
    }

    private static Object get(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepFuncBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnMSDepFuncBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnMSDepFuncBase.getDeployState();
            }
            case 3: {
                return pSDevSlnMSDepFuncBase.getFuncType();
            }
            case 4: {
                return pSDevSlnMSDepFuncBase.getHttpAddress();
            }
            case 5: {
                return pSDevSlnMSDepFuncBase.getHttpPort();
            }
            case 6: {
                return pSDevSlnMSDepFuncBase.getHttpsPort();
            }
            case 7: {
                return pSDevSlnMSDepFuncBase.getMemo();
            }
            case 8: {
                return pSDevSlnMSDepFuncBase.getPSDCMSPlatformId();
            }
            case 9: {
                return pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId();
            }
            case 10: {
                return pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName();
            }
            case 11: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId();
            }
            case 12: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName();
            }
            case 13: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterSVNId();
            }
            case 14: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterSVNName();
            }
            case 15: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnId();
            }
            case 16: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId();
            }
            case 17: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName();
            }
            case 18: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId();
            }
            case 19: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName();
            }
            case 20: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnName();
            }
            case 21: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId();
            }
            case 22: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName();
            }
            case 23: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnSysId();
            }
            case 24: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnSysName();
            }
            case 25: {
                return pSDevSlnMSDepFuncBase.getUpdateDate();
            }
            case 26: {
                return pSDevSlnMSDepFuncBase.getUpdateMan();
            }
            case 27: {
                return pSDevSlnMSDepFuncBase.getUserParams();
            }
            case 28: {
                return pSDevSlnMSDepFuncBase.getValidFlag();
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
        PSDevSlnMSDepFuncBase.set(this, n, object);
    }

    private static void set(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnMSDepFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnMSDepFuncBase.setDeployState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnMSDepFuncBase.setFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnMSDepFuncBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnMSDepFuncBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnMSDepFuncBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnMSDepFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnMSDepFuncBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnMSDepFuncBase.setPSDCMSPlatformNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnMSDepFuncBase.setPSDCMSPlatformNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnMSDepFuncBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnMSDepFuncBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnMSDepFuncBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnMSDepFuncBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnMSDepFuncBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnMSDepFuncBase.setPSDevSlnMSDepFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnMSDepFuncBase.setPSDevSlnMSDepFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnMSDepFuncBase.setPSDevSlnMSDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnMSDepFuncBase.setPSDevSlnMSDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnMSDepFuncBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnMSDepFuncBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnMSDepFuncBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnMSDepFuncBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnMSDepFuncBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnMSDepFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnMSDepFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnMSDepFuncBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnMSDepFuncBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnMSDepFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnMSDepFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnMSDepFuncBase.getDeployState() == null;
            }
            case 3: {
                return pSDevSlnMSDepFuncBase.getFuncType() == null;
            }
            case 4: {
                return pSDevSlnMSDepFuncBase.getHttpAddress() == null;
            }
            case 5: {
                return pSDevSlnMSDepFuncBase.getHttpPort() == null;
            }
            case 6: {
                return pSDevSlnMSDepFuncBase.getHttpsPort() == null;
            }
            case 7: {
                return pSDevSlnMSDepFuncBase.getMemo() == null;
            }
            case 8: {
                return pSDevSlnMSDepFuncBase.getPSDCMSPlatformId() == null;
            }
            case 9: {
                return pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId() == null;
            }
            case 10: {
                return pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName() == null;
            }
            case 11: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId() == null;
            }
            case 12: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName() == null;
            }
            case 13: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterSVNId() == null;
            }
            case 14: {
                return pSDevSlnMSDepFuncBase.getPSDevCenterSVNName() == null;
            }
            case 15: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId() == null;
            }
            case 17: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName() == null;
            }
            case 18: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId() == null;
            }
            case 19: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName() == null;
            }
            case 20: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnName() == null;
            }
            case 21: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId() == null;
            }
            case 22: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName() == null;
            }
            case 23: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnSysId() == null;
            }
            case 24: {
                return pSDevSlnMSDepFuncBase.getPSDevSlnSysName() == null;
            }
            case 25: {
                return pSDevSlnMSDepFuncBase.getUpdateDate() == null;
            }
            case 26: {
                return pSDevSlnMSDepFuncBase.getUpdateMan() == null;
            }
            case 27: {
                return pSDevSlnMSDepFuncBase.getUserParams() == null;
            }
            case 28: {
                return pSDevSlnMSDepFuncBase.getValidFlag() == null;
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
        return PSDevSlnMSDepFuncBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnMSDepFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnMSDepFuncBase.isDeployStateDirty();
            }
            case 3: {
                return pSDevSlnMSDepFuncBase.isFuncTypeDirty();
            }
            case 4: {
                return pSDevSlnMSDepFuncBase.isHttpAddressDirty();
            }
            case 5: {
                return pSDevSlnMSDepFuncBase.isHttpPortDirty();
            }
            case 6: {
                return pSDevSlnMSDepFuncBase.isHttpsPortDirty();
            }
            case 7: {
                return pSDevSlnMSDepFuncBase.isMemoDirty();
            }
            case 8: {
                return pSDevSlnMSDepFuncBase.isPSDCMSPlatformIdDirty();
            }
            case 9: {
                return pSDevSlnMSDepFuncBase.isPSDCMSPlatformNodeIdDirty();
            }
            case 10: {
                return pSDevSlnMSDepFuncBase.isPSDCMSPlatformNodeNameDirty();
            }
            case 11: {
                return pSDevSlnMSDepFuncBase.isPSDevCenterDBInstIdDirty();
            }
            case 12: {
                return pSDevSlnMSDepFuncBase.isPSDevCenterDBInstNameDirty();
            }
            case 13: {
                return pSDevSlnMSDepFuncBase.isPSDevCenterSVNIdDirty();
            }
            case 14: {
                return pSDevSlnMSDepFuncBase.isPSDevCenterSVNNameDirty();
            }
            case 15: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnMSDepFuncIdDirty();
            }
            case 17: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnMSDepFuncNameDirty();
            }
            case 18: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnMSDeployIdDirty();
            }
            case 19: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnMSDeployNameDirty();
            }
            case 20: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnNameDirty();
            }
            case 21: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnPipelineIdDirty();
            }
            case 22: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnPipelineNameDirty();
            }
            case 23: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnSysIdDirty();
            }
            case 24: {
                return pSDevSlnMSDepFuncBase.isPSDevSlnSysNameDirty();
            }
            case 25: {
                return pSDevSlnMSDepFuncBase.isUpdateDateDirty();
            }
            case 26: {
                return pSDevSlnMSDepFuncBase.isUpdateManDirty();
            }
            case 27: {
                return pSDevSlnMSDepFuncBase.isUserParamsDirty();
            }
            case 28: {
                return pSDevSlnMSDepFuncBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnMSDepFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnMSDepFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getDeployState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploystate", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getDeployState()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functype", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getFuncType()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodeid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodename", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepfuncname", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployname", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepFuncBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnMSDepFuncBase.getJSONValue((Object)pSDevSlnMSDepFuncBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnMSDepFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnMSDepFuncBase.getCreateDate() != null) {
            object = pSDevSlnMSDepFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepFuncBase.getCreateMan() != null) {
            object = pSDevSlnMSDepFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getDeployState() != null) {
            object = pSDevSlnMSDepFuncBase.getDeployState();
            xmlNode.setAttribute(FIELD_DEPLOYSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepFuncBase.getFuncType() != null) {
            object = pSDevSlnMSDepFuncBase.getFuncType();
            xmlNode.setAttribute(FIELD_FUNCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getHttpAddress() != null) {
            object = pSDevSlnMSDepFuncBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getHttpPort() != null) {
            object = pSDevSlnMSDepFuncBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepFuncBase.getHttpsPort() != null) {
            object = pSDevSlnMSDepFuncBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepFuncBase.getMemo() != null) {
            object = pSDevSlnMSDepFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterSVNId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevCenterSVNName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnMSDepFuncBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getUpdateDate() != null) {
            object = pSDevSlnMSDepFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepFuncBase.getUpdateMan() != null) {
            object = pSDevSlnMSDepFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getUserParams() != null) {
            object = pSDevSlnMSDepFuncBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepFuncBase.getValidFlag() != null) {
            object = pSDevSlnMSDepFuncBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnMSDepFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnMSDepFuncBase.isCreateDateDirty() && (bl || pSDevSlnMSDepFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnMSDepFuncBase.getCreateDate());
        }
        if (pSDevSlnMSDepFuncBase.isCreateManDirty() && (bl || pSDevSlnMSDepFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnMSDepFuncBase.getCreateMan());
        }
        if (pSDevSlnMSDepFuncBase.isDeployStateDirty() && (bl || pSDevSlnMSDepFuncBase.getDeployState() != null)) {
            iDataObject.set(FIELD_DEPLOYSTATE, (Object)pSDevSlnMSDepFuncBase.getDeployState());
        }
        if (pSDevSlnMSDepFuncBase.isFuncTypeDirty() && (bl || pSDevSlnMSDepFuncBase.getFuncType() != null)) {
            iDataObject.set(FIELD_FUNCTYPE, (Object)pSDevSlnMSDepFuncBase.getFuncType());
        }
        if (pSDevSlnMSDepFuncBase.isHttpAddressDirty() && (bl || pSDevSlnMSDepFuncBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSDevSlnMSDepFuncBase.getHttpAddress());
        }
        if (pSDevSlnMSDepFuncBase.isHttpPortDirty() && (bl || pSDevSlnMSDepFuncBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDevSlnMSDepFuncBase.getHttpPort());
        }
        if (pSDevSlnMSDepFuncBase.isHttpsPortDirty() && (bl || pSDevSlnMSDepFuncBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSDevSlnMSDepFuncBase.getHttpsPort());
        }
        if (pSDevSlnMSDepFuncBase.isMemoDirty() && (bl || pSDevSlnMSDepFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnMSDepFuncBase.getMemo());
        }
        if (pSDevSlnMSDepFuncBase.isPSDCMSPlatformIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDevSlnMSDepFuncBase.getPSDCMSPlatformId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDCMSPlatformNodeIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODEID, (Object)pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDCMSPlatformNodeNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODENAME, (Object)pSDevSlnMSDepFuncBase.getPSDCMSPlatformNodeName());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevCenterDBInstIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDevSlnMSDepFuncBase.getPSDevCenterDBInstId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevCenterDBInstNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDevSlnMSDepFuncBase.getPSDevCenterDBInstName());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevCenterSVNIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevSlnMSDepFuncBase.getPSDevCenterSVNId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevCenterSVNNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevSlnMSDepFuncBase.getPSDevCenterSVNName());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnMSDepFuncIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCID, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnMSDepFuncNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPFUNCNAME, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncName());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnMSDeployIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYID, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnMSDeployNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYNAME, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDeployName());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnName());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnSysId());
        }
        if (pSDevSlnMSDepFuncBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnMSDepFuncBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnMSDepFuncBase.getPSDevSlnSysName());
        }
        if (pSDevSlnMSDepFuncBase.isUpdateDateDirty() && (bl || pSDevSlnMSDepFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnMSDepFuncBase.getUpdateDate());
        }
        if (pSDevSlnMSDepFuncBase.isUpdateManDirty() && (bl || pSDevSlnMSDepFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnMSDepFuncBase.getUpdateMan());
        }
        if (pSDevSlnMSDepFuncBase.isUserParamsDirty() && (bl || pSDevSlnMSDepFuncBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDevSlnMSDepFuncBase.getUserParams());
        }
        if (pSDevSlnMSDepFuncBase.isValidFlagDirty() && (bl || pSDevSlnMSDepFuncBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnMSDepFuncBase.getValidFlag());
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
        return PSDevSlnMSDepFuncBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnMSDepFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnMSDepFuncBase.resetDeployState();
                return true;
            }
            case 3: {
                pSDevSlnMSDepFuncBase.resetFuncType();
                return true;
            }
            case 4: {
                pSDevSlnMSDepFuncBase.resetHttpAddress();
                return true;
            }
            case 5: {
                pSDevSlnMSDepFuncBase.resetHttpPort();
                return true;
            }
            case 6: {
                pSDevSlnMSDepFuncBase.resetHttpsPort();
                return true;
            }
            case 7: {
                pSDevSlnMSDepFuncBase.resetMemo();
                return true;
            }
            case 8: {
                pSDevSlnMSDepFuncBase.resetPSDCMSPlatformId();
                return true;
            }
            case 9: {
                pSDevSlnMSDepFuncBase.resetPSDCMSPlatformNodeId();
                return true;
            }
            case 10: {
                pSDevSlnMSDepFuncBase.resetPSDCMSPlatformNodeName();
                return true;
            }
            case 11: {
                pSDevSlnMSDepFuncBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 12: {
                pSDevSlnMSDepFuncBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 13: {
                pSDevSlnMSDepFuncBase.resetPSDevCenterSVNId();
                return true;
            }
            case 14: {
                pSDevSlnMSDepFuncBase.resetPSDevCenterSVNName();
                return true;
            }
            case 15: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnMSDepFuncId();
                return true;
            }
            case 17: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnMSDepFuncName();
                return true;
            }
            case 18: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnMSDeployId();
                return true;
            }
            case 19: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnMSDeployName();
                return true;
            }
            case 20: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnName();
                return true;
            }
            case 21: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 22: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 23: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnSysId();
                return true;
            }
            case 24: {
                pSDevSlnMSDepFuncBase.resetPSDevSlnSysName();
                return true;
            }
            case 25: {
                pSDevSlnMSDepFuncBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSDevSlnMSDepFuncBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSDevSlnMSDepFuncBase.resetUserParams();
                return true;
            }
            case 28: {
                pSDevSlnMSDepFuncBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatformNode getPSDCMSPlatformNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNode();
        }
        if (this.getPSDCMSPlatformNodeId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformNodeLock;
        synchronized (n) {
            if (this.psdcmsplatformnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformNodeId(), (Object)this.psdcmsplatformnode.getPSDCMSPlatformNodeId()) != 0L) {
                this.psdcmsplatformnode = null;
            }
            if (this.psdcmsplatformnode == null) {
                PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
                pSDCMSPlatformNode.setPSDCMSPlatformNodeId(this.getPSDCMSPlatformNodeId());
                PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformNodeService.autoGet(pSDCMSPlatformNode);
                this.psdcmsplatformnode = pSDCMSPlatformNode;
            }
            return this.psdcmsplatformnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet(pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDeploy getPSDevSlnMSDeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeploy();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDeployLock;
        synchronized (n) {
            if (this.psdevslnmsdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDeployId(), (Object)this.psdevslnmsdeploy.getPSDevSlnMSDeployId()) != 0L) {
                this.psdevslnmsdeploy = null;
            }
            if (this.psdevslnmsdeploy == null) {
                PSDevSlnMSDeploy pSDevSlnMSDeploy = new PSDevSlnMSDeploy();
                pSDevSlnMSDeploy.setPSDevSlnMSDeployId(this.getPSDevSlnMSDeployId());
                PSDevSlnMSDeployService pSDevSlnMSDeployService = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDeployService.autoGet(pSDevSlnMSDeploy);
                this.psdevslnmsdeploy = pSDevSlnMSDeploy;
            }
            return this.psdevslnmsdeploy;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipeline getPSDevSlnPipeline() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipeline();
        }
        if (this.getPSDevSlnPipelineId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineLock;
        synchronized (n) {
            if (this.psdevslnpipeline != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineId(), (Object)this.psdevslnpipeline.getPSDevSlnPipelineId()) != 0L) {
                this.psdevslnpipeline = null;
            }
            if (this.psdevslnpipeline == null) {
                PSDevSlnPipeline pSDevSlnPipeline = new PSDevSlnPipeline();
                pSDevSlnPipeline.setPSDevSlnPipelineId(this.getPSDevSlnPipelineId());
                PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineService.autoGet(pSDevSlnPipeline);
                this.psdevslnpipeline = pSDevSlnPipeline;
            }
            return this.psdevslnpipeline;
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepFuncItem> getPSDevSlnMSDepFuncItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepFuncItems();
        }
        if (this.getPSDevSlnMSDepFuncId() == null) {
            return null;
        }
        PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnMSDepFuncItemService pSDevSlnMSDepFuncItemService = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepFuncItemsLock;
        synchronized (n) {
            if (this.psdevslnmsdepfuncitems == null) {
                this.psdevslnmsdepfuncitems = pSDevSlnMSDepFuncService.isTempData(this) ? pSDevSlnMSDepFuncItemService.selectTempByPSDevSlnMSDepFunc(this) : pSDevSlnMSDepFuncItemService.selectByPSDevSlnMSDepFunc(this);
            }
            return this.psdevslnmsdepfuncitems;
        }
    }

    private PSDevSlnMSDepFuncBase getProxyEntity() {
        return this.proxyPSDevSlnMSDepFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnMSDepFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnMSDepFuncBase) {
            this.proxyPSDevSlnMSDepFuncBase = (PSDevSlnMSDepFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEPLOYSTATE, 2);
        fieldIndexMap.put(FIELD_FUNCTYPE, 3);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 4);
        fieldIndexMap.put(FIELD_HTTPPORT, 5);
        fieldIndexMap.put(FIELD_HTTPSPORT, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 8);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODEID, 9);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODENAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPFUNCNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_USERPARAMS, 27);
        fieldIndexMap.put(FIELD_VALIDFLAG, 28);
    }
}

