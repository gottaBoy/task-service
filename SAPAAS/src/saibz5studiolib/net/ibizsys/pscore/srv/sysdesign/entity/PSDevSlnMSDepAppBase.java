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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAppBase.class);
    public static final String FIELD_APPMODE = "APPMODE";
    public static final String FIELD_APPTAG = "APPTAG";
    public static final String FIELD_APPTAG2 = "APPTAG2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPLOYSTATE = "DEPLOYSTATE";
    public static final String FIELD_DEPLOYTAG = "DEPLOYTAG";
    public static final String FIELD_DEPLOYTAG2 = "DEPLOYTAG2";
    public static final String FIELD_DEPLOYTAG3 = "DEPLOYTAG3";
    public static final String FIELD_DEPLOYTAG4 = "DEPLOYTAG4";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NODEIPADDR = "NODEIPADDR";
    public static final String FIELD_NODEPORT = "NODEPORT";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNODEID = "PSDCMSPLATFORMNODEID";
    public static final String FIELD_PSDCMSPLATFORMNODENAME = "PSDCMSPLATFORMNODENAME";
    public static final String FIELD_PSDCREGISTRYITEMID = "PSDCREGISTRYITEMID";
    public static final String FIELD_PSDCREGISTRYITEMNAME = "PSDCREGISTRYITEMNAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPAPPID = "PSDEVSLNMSDEPAPPID";
    public static final String FIELD_PSDEVSLNMSDEPAPPNAME = "PSDEVSLNMSDEPAPPNAME";
    public static final String FIELD_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String FIELD_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String FIELD_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APPMODE = 0;
    private static final int INDEX_APPTAG = 1;
    private static final int INDEX_APPTAG2 = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DEPLOYSTATE = 5;
    private static final int INDEX_DEPLOYTAG = 6;
    private static final int INDEX_DEPLOYTAG2 = 7;
    private static final int INDEX_DEPLOYTAG3 = 8;
    private static final int INDEX_DEPLOYTAG4 = 9;
    private static final int INDEX_HTTPADDRESS = 10;
    private static final int INDEX_HTTPPORT = 11;
    private static final int INDEX_HTTPSPORT = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_NODEIPADDR = 14;
    private static final int INDEX_NODEPORT = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSDCMSPLATFORMID = 17;
    private static final int INDEX_PSDCMSPLATFORMNODEID = 18;
    private static final int INDEX_PSDCMSPLATFORMNODENAME = 19;
    private static final int INDEX_PSDCREGISTRYITEMID = 20;
    private static final int INDEX_PSDCREGISTRYITEMNAME = 21;
    private static final int INDEX_PSDEVCENTERDBINSTID = 22;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 23;
    private static final int INDEX_PSDEVSLNID = 24;
    private static final int INDEX_PSDEVSLNMSDEPAPPID = 25;
    private static final int INDEX_PSDEVSLNMSDEPAPPNAME = 26;
    private static final int INDEX_PSDEVSLNMSDEPLOYID = 27;
    private static final int INDEX_PSDEVSLNMSDEPLOYNAME = 28;
    private static final int INDEX_PSDEVSLNNAME = 29;
    private static final int INDEX_PSDEVSLNPIPELINEID = 30;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 31;
    private static final int INDEX_PSDEVSLNSYSAPPID = 32;
    private static final int INDEX_PSDEVSLNSYSAPPNAME = 33;
    private static final int INDEX_PSDEVSLNSYSID = 34;
    private static final int INDEX_PSDEVSLNSYSNAME = 35;
    private static final int INDEX_PSSYSAPPID = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_USERPARAMS = 39;
    private static final int INDEX_VALIDFLAG = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnMSDepAppBase proxyPSDevSlnMSDepAppBase = null;
    private boolean appmodeDirtyFlag = false;
    private boolean apptagDirtyFlag = false;
    private boolean apptag2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deploystateDirtyFlag = false;
    private boolean deploytagDirtyFlag = false;
    private boolean deploytag2DirtyFlag = false;
    private boolean deploytag3DirtyFlag = false;
    private boolean deploytag4DirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nodeipaddrDirtyFlag = false;
    private boolean nodeportDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnodeidDirtyFlag = false;
    private boolean psdcmsplatformnodenameDirtyFlag = false;
    private boolean psdcregistryitemidDirtyFlag = false;
    private boolean psdcregistryitemnameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdepappidDirtyFlag = false;
    private boolean psdevslnmsdepappnameDirtyFlag = false;
    private boolean psdevslnmsdeployidDirtyFlag = false;
    private boolean psdevslnmsdeploynameDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnsysappidDirtyFlag = false;
    private boolean psdevslnsysappnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="appmode")
    private String appmode;
    @Column(name="apptag")
    private String apptag;
    @Column(name="apptag2")
    private String apptag2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deploystate")
    private Integer deploystate;
    @Column(name="deploytag")
    private String deploytag;
    @Column(name="deploytag2")
    private String deploytag2;
    @Column(name="deploytag3")
    private String deploytag3;
    @Column(name="deploytag4")
    private String deploytag4;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="memo")
    private String memo;
    @Column(name="nodeipaddr")
    private String nodeipaddr;
    @Column(name="nodeport")
    private Integer nodeport;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformnodeid")
    private String psdcmsplatformnodeid;
    @Column(name="psdcmsplatformnodename")
    private String psdcmsplatformnodename;
    @Column(name="psdcregistryitemid")
    private String psdcregistryitemid;
    @Column(name="psdcregistryitemname")
    private String psdcregistryitemname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdepappid")
    private String psdevslnmsdepappid;
    @Column(name="psdevslnmsdepappname")
    private String psdevslnmsdepappname;
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
    @Column(name="psdevslnsysappid")
    private String psdevslnsysappid;
    @Column(name="psdevslnsysappname")
    private String psdevslnsysappname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="pssysappid")
    private String pssysappid;
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
    private Integer objPSDevSlnMSDeployLock = new Integer(1);
    private PSDevSlnMSDeploy psdevslnmsdeploy = null;
    private Integer objPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline psdevslnpipeline = null;
    private Integer objPSDevSlnSysAppLock = new Integer(1);
    private PSDevSlnSysApp psdevslnsysapp = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setAppMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appmode = string;
        this.appmodeDirtyFlag = true;
    }

    public String getAppMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppMode();
        }
        return this.appmode;
    }

    public boolean isAppModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppModeDirty();
        }
        return this.appmodeDirtyFlag;
    }

    public void resetAppMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppMode();
            return;
        }
        this.appmodeDirtyFlag = false;
        this.appmode = null;
    }

    public void setAppTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag = string;
        this.apptagDirtyFlag = true;
    }

    public String getAppTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag();
        }
        return this.apptag;
    }

    public boolean isAppTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTagDirty();
        }
        return this.apptagDirtyFlag;
    }

    public void resetAppTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag();
            return;
        }
        this.apptagDirtyFlag = false;
        this.apptag = null;
    }

    public void setAppTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apptag2 = string;
        this.apptag2DirtyFlag = true;
    }

    public String getAppTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppTag2();
        }
        return this.apptag2;
    }

    public boolean isAppTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTag2Dirty();
        }
        return this.apptag2DirtyFlag;
    }

    public void resetAppTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppTag2();
            return;
        }
        this.apptag2DirtyFlag = false;
        this.apptag2 = null;
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

    public void setDeployTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag = string;
        this.deploytagDirtyFlag = true;
    }

    public String getDeployTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag();
        }
        return this.deploytag;
    }

    public boolean isDeployTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTagDirty();
        }
        return this.deploytagDirtyFlag;
    }

    public void resetDeployTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag();
            return;
        }
        this.deploytagDirtyFlag = false;
        this.deploytag = null;
    }

    public void setDeployTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag2 = string;
        this.deploytag2DirtyFlag = true;
    }

    public String getDeployTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag2();
        }
        return this.deploytag2;
    }

    public boolean isDeployTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTag2Dirty();
        }
        return this.deploytag2DirtyFlag;
    }

    public void resetDeployTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag2();
            return;
        }
        this.deploytag2DirtyFlag = false;
        this.deploytag2 = null;
    }

    public void setDeployTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag3 = string;
        this.deploytag3DirtyFlag = true;
    }

    public String getDeployTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag3();
        }
        return this.deploytag3;
    }

    public boolean isDeployTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTag3Dirty();
        }
        return this.deploytag3DirtyFlag;
    }

    public void resetDeployTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag3();
            return;
        }
        this.deploytag3DirtyFlag = false;
        this.deploytag3 = null;
    }

    public void setDeployTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag4 = string;
        this.deploytag4DirtyFlag = true;
    }

    public String getDeployTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag4();
        }
        return this.deploytag4;
    }

    public boolean isDeployTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTag4Dirty();
        }
        return this.deploytag4DirtyFlag;
    }

    public void resetDeployTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag4();
            return;
        }
        this.deploytag4DirtyFlag = false;
        this.deploytag4 = null;
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

    public void setNodeIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeipaddr = string;
        this.nodeipaddrDirtyFlag = true;
    }

    public String getNodeIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeIPAddr();
        }
        return this.nodeipaddr;
    }

    public boolean isNodeIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeIPAddrDirty();
        }
        return this.nodeipaddrDirtyFlag;
    }

    public void resetNodeIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeIPAddr();
            return;
        }
        this.nodeipaddrDirtyFlag = false;
        this.nodeipaddr = null;
    }

    public void setNodePort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodePort(n);
            return;
        }
        this.nodeport = n;
        this.nodeportDirtyFlag = true;
    }

    public Integer getNodePort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodePort();
        }
        return this.nodeport;
    }

    public boolean isNodePortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodePortDirty();
        }
        return this.nodeportDirtyFlag;
    }

    public void resetNodePort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodePort();
            return;
        }
        this.nodeportDirtyFlag = false;
        this.nodeport = null;
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

    public void setPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemid = string;
        this.psdcregistryitemidDirtyFlag = true;
    }

    public String getPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemId();
        }
        return this.psdcregistryitemid;
    }

    public boolean isPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemIdDirty();
        }
        return this.psdcregistryitemidDirtyFlag;
    }

    public void resetPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemId();
            return;
        }
        this.psdcregistryitemidDirtyFlag = false;
        this.psdcregistryitemid = null;
    }

    public void setPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemname = string;
        this.psdcregistryitemnameDirtyFlag = true;
    }

    public String getPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemName();
        }
        return this.psdcregistryitemname;
    }

    public boolean isPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemNameDirty();
        }
        return this.psdcregistryitemnameDirtyFlag;
    }

    public void resetPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemName();
            return;
        }
        this.psdcregistryitemnameDirtyFlag = false;
        this.psdcregistryitemname = null;
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

    public void setPSDevSlnMSDepAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepappid = string;
        this.psdevslnmsdepappidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAppId();
        }
        return this.psdevslnmsdepappid;
    }

    public boolean isPSDevSlnMSDepAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAppIdDirty();
        }
        return this.psdevslnmsdepappidDirtyFlag;
    }

    public void resetPSDevSlnMSDepAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAppId();
            return;
        }
        this.psdevslnmsdepappidDirtyFlag = false;
        this.psdevslnmsdepappid = null;
    }

    public void setPSDevSlnMSDepAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepappname = string;
        this.psdevslnmsdepappnameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAppName();
        }
        return this.psdevslnmsdepappname;
    }

    public boolean isPSDevSlnMSDepAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAppNameDirty();
        }
        return this.psdevslnmsdepappnameDirtyFlag;
    }

    public void resetPSDevSlnMSDepAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAppName();
            return;
        }
        this.psdevslnmsdepappnameDirtyFlag = false;
        this.psdevslnmsdepappname = null;
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

    public void setPSDevSlnSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappid = string;
        this.psdevslnsysappidDirtyFlag = true;
    }

    public String getPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppId();
        }
        return this.psdevslnsysappid;
    }

    public boolean isPSDevSlnSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppIdDirty();
        }
        return this.psdevslnsysappidDirtyFlag;
    }

    public void resetPSDevSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppId();
            return;
        }
        this.psdevslnsysappidDirtyFlag = false;
        this.psdevslnsysappid = null;
    }

    public void setPSDevSlnSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysappname = string;
        this.psdevslnsysappnameDirtyFlag = true;
    }

    public String getPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAppName();
        }
        return this.psdevslnsysappname;
    }

    public boolean isPSDevSlnSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAppNameDirty();
        }
        return this.psdevslnsysappnameDirtyFlag;
    }

    public void resetPSDevSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAppName();
            return;
        }
        this.psdevslnsysappnameDirtyFlag = false;
        this.psdevslnsysappname = null;
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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
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
        PSDevSlnMSDepAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase) {
        pSDevSlnMSDepAppBase.resetAppMode();
        pSDevSlnMSDepAppBase.resetAppTag();
        pSDevSlnMSDepAppBase.resetAppTag2();
        pSDevSlnMSDepAppBase.resetCreateDate();
        pSDevSlnMSDepAppBase.resetCreateMan();
        pSDevSlnMSDepAppBase.resetDeployState();
        pSDevSlnMSDepAppBase.resetDeployTag();
        pSDevSlnMSDepAppBase.resetDeployTag2();
        pSDevSlnMSDepAppBase.resetDeployTag3();
        pSDevSlnMSDepAppBase.resetDeployTag4();
        pSDevSlnMSDepAppBase.resetHttpAddress();
        pSDevSlnMSDepAppBase.resetHttpPort();
        pSDevSlnMSDepAppBase.resetHttpsPort();
        pSDevSlnMSDepAppBase.resetMemo();
        pSDevSlnMSDepAppBase.resetNodeIPAddr();
        pSDevSlnMSDepAppBase.resetNodePort();
        pSDevSlnMSDepAppBase.resetOrderValue();
        pSDevSlnMSDepAppBase.resetPSDCMSPlatformId();
        pSDevSlnMSDepAppBase.resetPSDCMSPlatformNodeId();
        pSDevSlnMSDepAppBase.resetPSDCMSPlatformNodeName();
        pSDevSlnMSDepAppBase.resetPSDCRegistryItemId();
        pSDevSlnMSDepAppBase.resetPSDCRegistryItemName();
        pSDevSlnMSDepAppBase.resetPSDevCenterDBInstId();
        pSDevSlnMSDepAppBase.resetPSDevCenterDBInstName();
        pSDevSlnMSDepAppBase.resetPSDevSlnId();
        pSDevSlnMSDepAppBase.resetPSDevSlnMSDepAppId();
        pSDevSlnMSDepAppBase.resetPSDevSlnMSDepAppName();
        pSDevSlnMSDepAppBase.resetPSDevSlnMSDeployId();
        pSDevSlnMSDepAppBase.resetPSDevSlnMSDeployName();
        pSDevSlnMSDepAppBase.resetPSDevSlnName();
        pSDevSlnMSDepAppBase.resetPSDevSlnPipelineId();
        pSDevSlnMSDepAppBase.resetPSDevSlnPipelineName();
        pSDevSlnMSDepAppBase.resetPSDevSlnSysAppId();
        pSDevSlnMSDepAppBase.resetPSDevSlnSysAppName();
        pSDevSlnMSDepAppBase.resetPSDevSlnSysId();
        pSDevSlnMSDepAppBase.resetPSDevSlnSysName();
        pSDevSlnMSDepAppBase.resetPSSysAppId();
        pSDevSlnMSDepAppBase.resetUpdateDate();
        pSDevSlnMSDepAppBase.resetUpdateMan();
        pSDevSlnMSDepAppBase.resetUserParams();
        pSDevSlnMSDepAppBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppModeDirty()) {
            hashMap.put(FIELD_APPMODE, this.getAppMode());
        }
        if (!bl || this.isAppTagDirty()) {
            hashMap.put(FIELD_APPTAG, this.getAppTag());
        }
        if (!bl || this.isAppTag2Dirty()) {
            hashMap.put(FIELD_APPTAG2, this.getAppTag2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDeployStateDirty()) {
            hashMap.put(FIELD_DEPLOYSTATE, this.getDeployState());
        }
        if (!bl || this.isDeployTagDirty()) {
            hashMap.put(FIELD_DEPLOYTAG, this.getDeployTag());
        }
        if (!bl || this.isDeployTag2Dirty()) {
            hashMap.put(FIELD_DEPLOYTAG2, this.getDeployTag2());
        }
        if (!bl || this.isDeployTag3Dirty()) {
            hashMap.put(FIELD_DEPLOYTAG3, this.getDeployTag3());
        }
        if (!bl || this.isDeployTag4Dirty()) {
            hashMap.put(FIELD_DEPLOYTAG4, this.getDeployTag4());
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
        if (!bl || this.isNodeIPAddrDirty()) {
            hashMap.put(FIELD_NODEIPADDR, this.getNodeIPAddr());
        }
        if (!bl || this.isNodePortDirty()) {
            hashMap.put(FIELD_NODEPORT, this.getNodePort());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
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
        if (!bl || this.isPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMID, this.getPSDCRegistryItemId());
        }
        if (!bl || this.isPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMNAME, this.getPSDCRegistryItemName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnMSDepAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPPID, this.getPSDevSlnMSDepAppId());
        }
        if (!bl || this.isPSDevSlnMSDepAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPPNAME, this.getPSDevSlnMSDepAppName());
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
        if (!bl || this.isPSDevSlnSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPID, this.getPSDevSlnSysAppId());
        }
        if (!bl || this.isPSDevSlnSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPPNAME, this.getPSDevSlnSysAppName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
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
        return PSDevSlnMSDepAppBase.get(this, n);
    }

    private static Object get(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepAppBase.getAppMode();
            }
            case 1: {
                return pSDevSlnMSDepAppBase.getAppTag();
            }
            case 2: {
                return pSDevSlnMSDepAppBase.getAppTag2();
            }
            case 3: {
                return pSDevSlnMSDepAppBase.getCreateDate();
            }
            case 4: {
                return pSDevSlnMSDepAppBase.getCreateMan();
            }
            case 5: {
                return pSDevSlnMSDepAppBase.getDeployState();
            }
            case 6: {
                return pSDevSlnMSDepAppBase.getDeployTag();
            }
            case 7: {
                return pSDevSlnMSDepAppBase.getDeployTag2();
            }
            case 8: {
                return pSDevSlnMSDepAppBase.getDeployTag3();
            }
            case 9: {
                return pSDevSlnMSDepAppBase.getDeployTag4();
            }
            case 10: {
                return pSDevSlnMSDepAppBase.getHttpAddress();
            }
            case 11: {
                return pSDevSlnMSDepAppBase.getHttpPort();
            }
            case 12: {
                return pSDevSlnMSDepAppBase.getHttpsPort();
            }
            case 13: {
                return pSDevSlnMSDepAppBase.getMemo();
            }
            case 14: {
                return pSDevSlnMSDepAppBase.getNodeIPAddr();
            }
            case 15: {
                return pSDevSlnMSDepAppBase.getNodePort();
            }
            case 16: {
                return pSDevSlnMSDepAppBase.getOrderValue();
            }
            case 17: {
                return pSDevSlnMSDepAppBase.getPSDCMSPlatformId();
            }
            case 18: {
                return pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId();
            }
            case 19: {
                return pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName();
            }
            case 20: {
                return pSDevSlnMSDepAppBase.getPSDCRegistryItemId();
            }
            case 21: {
                return pSDevSlnMSDepAppBase.getPSDCRegistryItemName();
            }
            case 22: {
                return pSDevSlnMSDepAppBase.getPSDevCenterDBInstId();
            }
            case 23: {
                return pSDevSlnMSDepAppBase.getPSDevCenterDBInstName();
            }
            case 24: {
                return pSDevSlnMSDepAppBase.getPSDevSlnId();
            }
            case 25: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId();
            }
            case 26: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName();
            }
            case 27: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId();
            }
            case 28: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName();
            }
            case 29: {
                return pSDevSlnMSDepAppBase.getPSDevSlnName();
            }
            case 30: {
                return pSDevSlnMSDepAppBase.getPSDevSlnPipelineId();
            }
            case 31: {
                return pSDevSlnMSDepAppBase.getPSDevSlnPipelineName();
            }
            case 32: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysAppId();
            }
            case 33: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysAppName();
            }
            case 34: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysId();
            }
            case 35: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysName();
            }
            case 36: {
                return pSDevSlnMSDepAppBase.getPSSysAppId();
            }
            case 37: {
                return pSDevSlnMSDepAppBase.getUpdateDate();
            }
            case 38: {
                return pSDevSlnMSDepAppBase.getUpdateMan();
            }
            case 39: {
                return pSDevSlnMSDepAppBase.getUserParams();
            }
            case 40: {
                return pSDevSlnMSDepAppBase.getValidFlag();
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
        PSDevSlnMSDepAppBase.set(this, n, object);
    }

    private static void set(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepAppBase.setAppMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnMSDepAppBase.setAppTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnMSDepAppBase.setAppTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnMSDepAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnMSDepAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnMSDepAppBase.setDeployState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnMSDepAppBase.setDeployTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnMSDepAppBase.setDeployTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnMSDepAppBase.setDeployTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnMSDepAppBase.setDeployTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnMSDepAppBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnMSDepAppBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnMSDepAppBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnMSDepAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnMSDepAppBase.setNodeIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnMSDepAppBase.setNodePort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnMSDepAppBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnMSDepAppBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnMSDepAppBase.setPSDCMSPlatformNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnMSDepAppBase.setPSDCMSPlatformNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnMSDepAppBase.setPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnMSDepAppBase.setPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnMSDepAppBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnMSDepAppBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnMSDepAppBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnMSDepAppBase.setPSDevSlnMSDepAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnMSDepAppBase.setPSDevSlnMSDepAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnMSDepAppBase.setPSDevSlnMSDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnMSDepAppBase.setPSDevSlnMSDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnMSDepAppBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnMSDepAppBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnMSDepAppBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnMSDepAppBase.setPSDevSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnMSDepAppBase.setPSDevSlnSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnMSDepAppBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnMSDepAppBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnMSDepAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnMSDepAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnMSDepAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnMSDepAppBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnMSDepAppBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnMSDepAppBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepAppBase.getAppMode() == null;
            }
            case 1: {
                return pSDevSlnMSDepAppBase.getAppTag() == null;
            }
            case 2: {
                return pSDevSlnMSDepAppBase.getAppTag2() == null;
            }
            case 3: {
                return pSDevSlnMSDepAppBase.getCreateDate() == null;
            }
            case 4: {
                return pSDevSlnMSDepAppBase.getCreateMan() == null;
            }
            case 5: {
                return pSDevSlnMSDepAppBase.getDeployState() == null;
            }
            case 6: {
                return pSDevSlnMSDepAppBase.getDeployTag() == null;
            }
            case 7: {
                return pSDevSlnMSDepAppBase.getDeployTag2() == null;
            }
            case 8: {
                return pSDevSlnMSDepAppBase.getDeployTag3() == null;
            }
            case 9: {
                return pSDevSlnMSDepAppBase.getDeployTag4() == null;
            }
            case 10: {
                return pSDevSlnMSDepAppBase.getHttpAddress() == null;
            }
            case 11: {
                return pSDevSlnMSDepAppBase.getHttpPort() == null;
            }
            case 12: {
                return pSDevSlnMSDepAppBase.getHttpsPort() == null;
            }
            case 13: {
                return pSDevSlnMSDepAppBase.getMemo() == null;
            }
            case 14: {
                return pSDevSlnMSDepAppBase.getNodeIPAddr() == null;
            }
            case 15: {
                return pSDevSlnMSDepAppBase.getNodePort() == null;
            }
            case 16: {
                return pSDevSlnMSDepAppBase.getOrderValue() == null;
            }
            case 17: {
                return pSDevSlnMSDepAppBase.getPSDCMSPlatformId() == null;
            }
            case 18: {
                return pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId() == null;
            }
            case 19: {
                return pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName() == null;
            }
            case 20: {
                return pSDevSlnMSDepAppBase.getPSDCRegistryItemId() == null;
            }
            case 21: {
                return pSDevSlnMSDepAppBase.getPSDCRegistryItemName() == null;
            }
            case 22: {
                return pSDevSlnMSDepAppBase.getPSDevCenterDBInstId() == null;
            }
            case 23: {
                return pSDevSlnMSDepAppBase.getPSDevCenterDBInstName() == null;
            }
            case 24: {
                return pSDevSlnMSDepAppBase.getPSDevSlnId() == null;
            }
            case 25: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId() == null;
            }
            case 26: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName() == null;
            }
            case 27: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId() == null;
            }
            case 28: {
                return pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName() == null;
            }
            case 29: {
                return pSDevSlnMSDepAppBase.getPSDevSlnName() == null;
            }
            case 30: {
                return pSDevSlnMSDepAppBase.getPSDevSlnPipelineId() == null;
            }
            case 31: {
                return pSDevSlnMSDepAppBase.getPSDevSlnPipelineName() == null;
            }
            case 32: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysAppId() == null;
            }
            case 33: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysAppName() == null;
            }
            case 34: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysId() == null;
            }
            case 35: {
                return pSDevSlnMSDepAppBase.getPSDevSlnSysName() == null;
            }
            case 36: {
                return pSDevSlnMSDepAppBase.getPSSysAppId() == null;
            }
            case 37: {
                return pSDevSlnMSDepAppBase.getUpdateDate() == null;
            }
            case 38: {
                return pSDevSlnMSDepAppBase.getUpdateMan() == null;
            }
            case 39: {
                return pSDevSlnMSDepAppBase.getUserParams() == null;
            }
            case 40: {
                return pSDevSlnMSDepAppBase.getValidFlag() == null;
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
        return PSDevSlnMSDepAppBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepAppBase.isAppModeDirty();
            }
            case 1: {
                return pSDevSlnMSDepAppBase.isAppTagDirty();
            }
            case 2: {
                return pSDevSlnMSDepAppBase.isAppTag2Dirty();
            }
            case 3: {
                return pSDevSlnMSDepAppBase.isCreateDateDirty();
            }
            case 4: {
                return pSDevSlnMSDepAppBase.isCreateManDirty();
            }
            case 5: {
                return pSDevSlnMSDepAppBase.isDeployStateDirty();
            }
            case 6: {
                return pSDevSlnMSDepAppBase.isDeployTagDirty();
            }
            case 7: {
                return pSDevSlnMSDepAppBase.isDeployTag2Dirty();
            }
            case 8: {
                return pSDevSlnMSDepAppBase.isDeployTag3Dirty();
            }
            case 9: {
                return pSDevSlnMSDepAppBase.isDeployTag4Dirty();
            }
            case 10: {
                return pSDevSlnMSDepAppBase.isHttpAddressDirty();
            }
            case 11: {
                return pSDevSlnMSDepAppBase.isHttpPortDirty();
            }
            case 12: {
                return pSDevSlnMSDepAppBase.isHttpsPortDirty();
            }
            case 13: {
                return pSDevSlnMSDepAppBase.isMemoDirty();
            }
            case 14: {
                return pSDevSlnMSDepAppBase.isNodeIPAddrDirty();
            }
            case 15: {
                return pSDevSlnMSDepAppBase.isNodePortDirty();
            }
            case 16: {
                return pSDevSlnMSDepAppBase.isOrderValueDirty();
            }
            case 17: {
                return pSDevSlnMSDepAppBase.isPSDCMSPlatformIdDirty();
            }
            case 18: {
                return pSDevSlnMSDepAppBase.isPSDCMSPlatformNodeIdDirty();
            }
            case 19: {
                return pSDevSlnMSDepAppBase.isPSDCMSPlatformNodeNameDirty();
            }
            case 20: {
                return pSDevSlnMSDepAppBase.isPSDCRegistryItemIdDirty();
            }
            case 21: {
                return pSDevSlnMSDepAppBase.isPSDCRegistryItemNameDirty();
            }
            case 22: {
                return pSDevSlnMSDepAppBase.isPSDevCenterDBInstIdDirty();
            }
            case 23: {
                return pSDevSlnMSDepAppBase.isPSDevCenterDBInstNameDirty();
            }
            case 24: {
                return pSDevSlnMSDepAppBase.isPSDevSlnIdDirty();
            }
            case 25: {
                return pSDevSlnMSDepAppBase.isPSDevSlnMSDepAppIdDirty();
            }
            case 26: {
                return pSDevSlnMSDepAppBase.isPSDevSlnMSDepAppNameDirty();
            }
            case 27: {
                return pSDevSlnMSDepAppBase.isPSDevSlnMSDeployIdDirty();
            }
            case 28: {
                return pSDevSlnMSDepAppBase.isPSDevSlnMSDeployNameDirty();
            }
            case 29: {
                return pSDevSlnMSDepAppBase.isPSDevSlnNameDirty();
            }
            case 30: {
                return pSDevSlnMSDepAppBase.isPSDevSlnPipelineIdDirty();
            }
            case 31: {
                return pSDevSlnMSDepAppBase.isPSDevSlnPipelineNameDirty();
            }
            case 32: {
                return pSDevSlnMSDepAppBase.isPSDevSlnSysAppIdDirty();
            }
            case 33: {
                return pSDevSlnMSDepAppBase.isPSDevSlnSysAppNameDirty();
            }
            case 34: {
                return pSDevSlnMSDepAppBase.isPSDevSlnSysIdDirty();
            }
            case 35: {
                return pSDevSlnMSDepAppBase.isPSDevSlnSysNameDirty();
            }
            case 36: {
                return pSDevSlnMSDepAppBase.isPSSysAppIdDirty();
            }
            case 37: {
                return pSDevSlnMSDepAppBase.isUpdateDateDirty();
            }
            case 38: {
                return pSDevSlnMSDepAppBase.isUpdateManDirty();
            }
            case 39: {
                return pSDevSlnMSDepAppBase.isUserParamsDirty();
            }
            case 40: {
                return pSDevSlnMSDepAppBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnMSDepAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnMSDepAppBase.getAppMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appmode", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getAppMode()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getAppTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getAppTag()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getAppTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apptag2", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getAppTag2()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploystate", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getDeployState()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getDeployTag()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag2", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getDeployTag2()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag3", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getDeployTag3()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag4", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getDeployTag4()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getNodeIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeipaddr", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getNodeIPAddr()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getNodePort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeport", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getNodePort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodeid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodename", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemname", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepappid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepappname", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployname", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappname", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnSysAppName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAppBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnMSDepAppBase.getJSONValue((Object)pSDevSlnMSDepAppBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnMSDepAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnMSDepAppBase.getAppMode() != null) {
            object = pSDevSlnMSDepAppBase.getAppMode();
            xmlNode.setAttribute(FIELD_APPMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnMSDepAppBase.getAppTag() != null) {
            object = pSDevSlnMSDepAppBase.getAppTag();
            xmlNode.setAttribute(FIELD_APPTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnMSDepAppBase.getAppTag2() != null) {
            object = pSDevSlnMSDepAppBase.getAppTag2();
            xmlNode.setAttribute(FIELD_APPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getCreateDate() != null) {
            object = pSDevSlnMSDepAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepAppBase.getCreateMan() != null) {
            object = pSDevSlnMSDepAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployState() != null) {
            object = pSDevSlnMSDepAppBase.getDeployState();
            xmlNode.setAttribute(FIELD_DEPLOYSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag() != null) {
            object = pSDevSlnMSDepAppBase.getDeployTag();
            xmlNode.setAttribute(FIELD_DEPLOYTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag2() != null) {
            object = pSDevSlnMSDepAppBase.getDeployTag2();
            xmlNode.setAttribute(FIELD_DEPLOYTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag3() != null) {
            object = pSDevSlnMSDepAppBase.getDeployTag3();
            xmlNode.setAttribute(FIELD_DEPLOYTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getDeployTag4() != null) {
            object = pSDevSlnMSDepAppBase.getDeployTag4();
            xmlNode.setAttribute(FIELD_DEPLOYTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getHttpAddress() != null) {
            object = pSDevSlnMSDepAppBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getHttpPort() != null) {
            object = pSDevSlnMSDepAppBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAppBase.getHttpsPort() != null) {
            object = pSDevSlnMSDepAppBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAppBase.getMemo() != null) {
            object = pSDevSlnMSDepAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getNodeIPAddr() != null) {
            object = pSDevSlnMSDepAppBase.getNodeIPAddr();
            xmlNode.setAttribute(FIELD_NODEIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getNodePort() != null) {
            object = pSDevSlnMSDepAppBase.getNodePort();
            xmlNode.setAttribute(FIELD_NODEPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAppBase.getOrderValue() != null) {
            object = pSDevSlnMSDepAppBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCRegistryItemId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDCRegistryItemName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevCenterDBInstId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevCenterDBInstName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysAppId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysAppName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnSysAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnMSDepAppBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getPSSysAppId() != null) {
            object = pSDevSlnMSDepAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getUpdateDate() != null) {
            object = pSDevSlnMSDepAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepAppBase.getUpdateMan() != null) {
            object = pSDevSlnMSDepAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getUserParams() != null) {
            object = pSDevSlnMSDepAppBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAppBase.getValidFlag() != null) {
            object = pSDevSlnMSDepAppBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnMSDepAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnMSDepAppBase.isAppModeDirty() && (bl || pSDevSlnMSDepAppBase.getAppMode() != null)) {
            iDataObject.set(FIELD_APPMODE, (Object)pSDevSlnMSDepAppBase.getAppMode());
        }
        if (pSDevSlnMSDepAppBase.isAppTagDirty() && (bl || pSDevSlnMSDepAppBase.getAppTag() != null)) {
            iDataObject.set(FIELD_APPTAG, (Object)pSDevSlnMSDepAppBase.getAppTag());
        }
        if (pSDevSlnMSDepAppBase.isAppTag2Dirty() && (bl || pSDevSlnMSDepAppBase.getAppTag2() != null)) {
            iDataObject.set(FIELD_APPTAG2, (Object)pSDevSlnMSDepAppBase.getAppTag2());
        }
        if (pSDevSlnMSDepAppBase.isCreateDateDirty() && (bl || pSDevSlnMSDepAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnMSDepAppBase.getCreateDate());
        }
        if (pSDevSlnMSDepAppBase.isCreateManDirty() && (bl || pSDevSlnMSDepAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnMSDepAppBase.getCreateMan());
        }
        if (pSDevSlnMSDepAppBase.isDeployStateDirty() && (bl || pSDevSlnMSDepAppBase.getDeployState() != null)) {
            iDataObject.set(FIELD_DEPLOYSTATE, (Object)pSDevSlnMSDepAppBase.getDeployState());
        }
        if (pSDevSlnMSDepAppBase.isDeployTagDirty() && (bl || pSDevSlnMSDepAppBase.getDeployTag() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG, (Object)pSDevSlnMSDepAppBase.getDeployTag());
        }
        if (pSDevSlnMSDepAppBase.isDeployTag2Dirty() && (bl || pSDevSlnMSDepAppBase.getDeployTag2() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG2, (Object)pSDevSlnMSDepAppBase.getDeployTag2());
        }
        if (pSDevSlnMSDepAppBase.isDeployTag3Dirty() && (bl || pSDevSlnMSDepAppBase.getDeployTag3() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG3, (Object)pSDevSlnMSDepAppBase.getDeployTag3());
        }
        if (pSDevSlnMSDepAppBase.isDeployTag4Dirty() && (bl || pSDevSlnMSDepAppBase.getDeployTag4() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG4, (Object)pSDevSlnMSDepAppBase.getDeployTag4());
        }
        if (pSDevSlnMSDepAppBase.isHttpAddressDirty() && (bl || pSDevSlnMSDepAppBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSDevSlnMSDepAppBase.getHttpAddress());
        }
        if (pSDevSlnMSDepAppBase.isHttpPortDirty() && (bl || pSDevSlnMSDepAppBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDevSlnMSDepAppBase.getHttpPort());
        }
        if (pSDevSlnMSDepAppBase.isHttpsPortDirty() && (bl || pSDevSlnMSDepAppBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSDevSlnMSDepAppBase.getHttpsPort());
        }
        if (pSDevSlnMSDepAppBase.isMemoDirty() && (bl || pSDevSlnMSDepAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnMSDepAppBase.getMemo());
        }
        if (pSDevSlnMSDepAppBase.isNodeIPAddrDirty() && (bl || pSDevSlnMSDepAppBase.getNodeIPAddr() != null)) {
            iDataObject.set(FIELD_NODEIPADDR, (Object)pSDevSlnMSDepAppBase.getNodeIPAddr());
        }
        if (pSDevSlnMSDepAppBase.isNodePortDirty() && (bl || pSDevSlnMSDepAppBase.getNodePort() != null)) {
            iDataObject.set(FIELD_NODEPORT, (Object)pSDevSlnMSDepAppBase.getNodePort());
        }
        if (pSDevSlnMSDepAppBase.isOrderValueDirty() && (bl || pSDevSlnMSDepAppBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnMSDepAppBase.getOrderValue());
        }
        if (pSDevSlnMSDepAppBase.isPSDCMSPlatformIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDevSlnMSDepAppBase.getPSDCMSPlatformId());
        }
        if (pSDevSlnMSDepAppBase.isPSDCMSPlatformNodeIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODEID, (Object)pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeId());
        }
        if (pSDevSlnMSDepAppBase.isPSDCMSPlatformNodeNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODENAME, (Object)pSDevSlnMSDepAppBase.getPSDCMSPlatformNodeName());
        }
        if (pSDevSlnMSDepAppBase.isPSDCRegistryItemIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMID, (Object)pSDevSlnMSDepAppBase.getPSDCRegistryItemId());
        }
        if (pSDevSlnMSDepAppBase.isPSDCRegistryItemNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMNAME, (Object)pSDevSlnMSDepAppBase.getPSDCRegistryItemName());
        }
        if (pSDevSlnMSDepAppBase.isPSDevCenterDBInstIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDevSlnMSDepAppBase.getPSDevCenterDBInstId());
        }
        if (pSDevSlnMSDepAppBase.isPSDevCenterDBInstNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDevSlnMSDepAppBase.getPSDevCenterDBInstName());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnMSDepAppBase.getPSDevSlnId());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnMSDepAppIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPPID, (Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnMSDepAppNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPPNAME, (Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppName());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnMSDeployIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYID, (Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDeployId());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnMSDeployNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYNAME, (Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDeployName());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnMSDepAppBase.getPSDevSlnName());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnMSDepAppBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnMSDepAppBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnSysAppIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPID, (Object)pSDevSlnMSDepAppBase.getPSDevSlnSysAppId());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnSysAppNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPNAME, (Object)pSDevSlnMSDepAppBase.getPSDevSlnSysAppName());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnMSDepAppBase.getPSDevSlnSysId());
        }
        if (pSDevSlnMSDepAppBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnMSDepAppBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnMSDepAppBase.getPSDevSlnSysName());
        }
        if (pSDevSlnMSDepAppBase.isPSSysAppIdDirty() && (bl || pSDevSlnMSDepAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDevSlnMSDepAppBase.getPSSysAppId());
        }
        if (pSDevSlnMSDepAppBase.isUpdateDateDirty() && (bl || pSDevSlnMSDepAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnMSDepAppBase.getUpdateDate());
        }
        if (pSDevSlnMSDepAppBase.isUpdateManDirty() && (bl || pSDevSlnMSDepAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnMSDepAppBase.getUpdateMan());
        }
        if (pSDevSlnMSDepAppBase.isUserParamsDirty() && (bl || pSDevSlnMSDepAppBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDevSlnMSDepAppBase.getUserParams());
        }
        if (pSDevSlnMSDepAppBase.isValidFlagDirty() && (bl || pSDevSlnMSDepAppBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnMSDepAppBase.getValidFlag());
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
        return PSDevSlnMSDepAppBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepAppBase.resetAppMode();
                return true;
            }
            case 1: {
                pSDevSlnMSDepAppBase.resetAppTag();
                return true;
            }
            case 2: {
                pSDevSlnMSDepAppBase.resetAppTag2();
                return true;
            }
            case 3: {
                pSDevSlnMSDepAppBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDevSlnMSDepAppBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDevSlnMSDepAppBase.resetDeployState();
                return true;
            }
            case 6: {
                pSDevSlnMSDepAppBase.resetDeployTag();
                return true;
            }
            case 7: {
                pSDevSlnMSDepAppBase.resetDeployTag2();
                return true;
            }
            case 8: {
                pSDevSlnMSDepAppBase.resetDeployTag3();
                return true;
            }
            case 9: {
                pSDevSlnMSDepAppBase.resetDeployTag4();
                return true;
            }
            case 10: {
                pSDevSlnMSDepAppBase.resetHttpAddress();
                return true;
            }
            case 11: {
                pSDevSlnMSDepAppBase.resetHttpPort();
                return true;
            }
            case 12: {
                pSDevSlnMSDepAppBase.resetHttpsPort();
                return true;
            }
            case 13: {
                pSDevSlnMSDepAppBase.resetMemo();
                return true;
            }
            case 14: {
                pSDevSlnMSDepAppBase.resetNodeIPAddr();
                return true;
            }
            case 15: {
                pSDevSlnMSDepAppBase.resetNodePort();
                return true;
            }
            case 16: {
                pSDevSlnMSDepAppBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSDevSlnMSDepAppBase.resetPSDCMSPlatformId();
                return true;
            }
            case 18: {
                pSDevSlnMSDepAppBase.resetPSDCMSPlatformNodeId();
                return true;
            }
            case 19: {
                pSDevSlnMSDepAppBase.resetPSDCMSPlatformNodeName();
                return true;
            }
            case 20: {
                pSDevSlnMSDepAppBase.resetPSDCRegistryItemId();
                return true;
            }
            case 21: {
                pSDevSlnMSDepAppBase.resetPSDCRegistryItemName();
                return true;
            }
            case 22: {
                pSDevSlnMSDepAppBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 23: {
                pSDevSlnMSDepAppBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 24: {
                pSDevSlnMSDepAppBase.resetPSDevSlnId();
                return true;
            }
            case 25: {
                pSDevSlnMSDepAppBase.resetPSDevSlnMSDepAppId();
                return true;
            }
            case 26: {
                pSDevSlnMSDepAppBase.resetPSDevSlnMSDepAppName();
                return true;
            }
            case 27: {
                pSDevSlnMSDepAppBase.resetPSDevSlnMSDeployId();
                return true;
            }
            case 28: {
                pSDevSlnMSDepAppBase.resetPSDevSlnMSDeployName();
                return true;
            }
            case 29: {
                pSDevSlnMSDepAppBase.resetPSDevSlnName();
                return true;
            }
            case 30: {
                pSDevSlnMSDepAppBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 31: {
                pSDevSlnMSDepAppBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 32: {
                pSDevSlnMSDepAppBase.resetPSDevSlnSysAppId();
                return true;
            }
            case 33: {
                pSDevSlnMSDepAppBase.resetPSDevSlnSysAppName();
                return true;
            }
            case 34: {
                pSDevSlnMSDepAppBase.resetPSDevSlnSysId();
                return true;
            }
            case 35: {
                pSDevSlnMSDepAppBase.resetPSDevSlnSysName();
                return true;
            }
            case 36: {
                pSDevSlnMSDepAppBase.resetPSSysAppId();
                return true;
            }
            case 37: {
                pSDevSlnMSDepAppBase.resetUpdateDate();
                return true;
            }
            case 38: {
                pSDevSlnMSDepAppBase.resetUpdateMan();
                return true;
            }
            case 39: {
                pSDevSlnMSDepAppBase.resetUserParams();
                return true;
            }
            case 40: {
                pSDevSlnMSDepAppBase.resetValidFlag();
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
    public PSDevSlnSysApp getPSDevSlnSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysApp();
        }
        if (this.getPSDevSlnSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAppLock;
        synchronized (n) {
            if (this.psdevslnsysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAppId(), (Object)this.psdevslnsysapp.getPSDevSlnSysAppId()) != 0L) {
                this.psdevslnsysapp = null;
            }
            if (this.psdevslnsysapp == null) {
                PSDevSlnSysApp pSDevSlnSysApp = new PSDevSlnSysApp();
                pSDevSlnSysApp.setPSDevSlnSysAppId(this.getPSDevSlnSysAppId());
                PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAppService.autoGet(pSDevSlnSysApp);
                this.psdevslnsysapp = pSDevSlnSysApp;
            }
            return this.psdevslnsysapp;
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

    private PSDevSlnMSDepAppBase getProxyEntity() {
        return this.proxyPSDevSlnMSDepAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnMSDepAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnMSDepAppBase) {
            this.proxyPSDevSlnMSDepAppBase = (PSDevSlnMSDepAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPMODE, 0);
        fieldIndexMap.put(FIELD_APPTAG, 1);
        fieldIndexMap.put(FIELD_APPTAG2, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DEPLOYSTATE, 5);
        fieldIndexMap.put(FIELD_DEPLOYTAG, 6);
        fieldIndexMap.put(FIELD_DEPLOYTAG2, 7);
        fieldIndexMap.put(FIELD_DEPLOYTAG3, 8);
        fieldIndexMap.put(FIELD_DEPLOYTAG4, 9);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 10);
        fieldIndexMap.put(FIELD_HTTPPORT, 11);
        fieldIndexMap.put(FIELD_HTTPSPORT, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_NODEIPADDR, 14);
        fieldIndexMap.put(FIELD_NODEPORT, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 17);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODEID, 18);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODENAME, 19);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMID, 20);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMNAME, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPPID, 25);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPPNAME, 26);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYID, 27);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, 28);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 29);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 30);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 31);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPID, 32);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPNAME, 33);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 34);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 35);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_USERPARAMS, 39);
        fieldIndexMap.put(FIELD_VALIDFLAG, 40);
    }
}

