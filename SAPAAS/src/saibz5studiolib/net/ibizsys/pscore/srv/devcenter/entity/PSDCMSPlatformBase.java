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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatform;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMSPlatformBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMSPlatformBase.class);
    public static final String FIELD_ADMINPASSWD = "ADMINPASSWD";
    public static final String FIELD_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String FIELD_CFGSERVICEURL = "CFGSERVICEURL";
    public static final String FIELD_CLUSTERNAMESPACE = "CLUSTERNAMESPACE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSTYPE = "MSTYPE";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String FIELD_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSMSPLATFORMID = "PSMSPLATFORMID";
    public static final String FIELD_PSMSPLATFORMNAME = "PSMSPLATFORMNAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_SERVICEURL = "SERVICEURL";
    public static final String FIELD_SSHIPADDR = "SSHIPADDR";
    public static final String FIELD_SSHPORT = "SSHPORT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String FIELD_UPLOADPATH = "UPLOADPATH";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    public static final String FIELD_WORKSHOPPATH = "WORKSHOPPATH";
    private static final int INDEX_ADMINPASSWD = 0;
    private static final int INDEX_ADMINUSERNAME = 1;
    private static final int INDEX_CFGSERVICEURL = 2;
    private static final int INDEX_CLUSTERNAMESPACE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_EXPRIEDTIME = 6;
    private static final int INDEX_IPADDR = 7;
    private static final int INDEX_IPADDR2 = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_MSTYPE = 10;
    private static final int INDEX_PASSWD = 11;
    private static final int INDEX_PORT = 12;
    private static final int INDEX_PSDCCLUSTERID = 13;
    private static final int INDEX_PSDCCLUSTERNAME = 14;
    private static final int INDEX_PSDCCONTAINERSPECID = 15;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 16;
    private static final int INDEX_PSDCDEPLOYCENTERID = 17;
    private static final int INDEX_PSDCDEPLOYCENTERNAME = 18;
    private static final int INDEX_PSDCFILEID = 19;
    private static final int INDEX_PSDCFILENAME = 20;
    private static final int INDEX_PSDCMSPLATFORMID = 21;
    private static final int INDEX_PSDCMSPLATFORMNAME = 22;
    private static final int INDEX_PSDEVCENTERID = 23;
    private static final int INDEX_PSDEVCENTERNAME = 24;
    private static final int INDEX_PSDEVSLNID = 25;
    private static final int INDEX_PSDEVSLNNAME = 26;
    private static final int INDEX_PSMSPLATFORMID = 27;
    private static final int INDEX_PSMSPLATFORMNAME = 28;
    private static final int INDEX_REFCOUNT = 29;
    private static final int INDEX_RESPOS = 30;
    private static final int INDEX_RESREADYTIME = 31;
    private static final int INDEX_RESSTATE = 32;
    private static final int INDEX_RESVER = 33;
    private static final int INDEX_SERVICEURL = 34;
    private static final int INDEX_SSHIPADDR = 35;
    private static final int INDEX_SSHPORT = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_UPLOADFILEMODE = 39;
    private static final int INDEX_UPLOADPATH = 40;
    private static final int INDEX_USERNAME = 41;
    private static final int INDEX_USERPARAMS = 42;
    private static final int INDEX_USERTAG = 43;
    private static final int INDEX_USERTAG2 = 44;
    private static final int INDEX_USERTAG3 = 45;
    private static final int INDEX_USERTAG4 = 46;
    private static final int INDEX_VALIDFLAG = 47;
    private static final int INDEX_WEBCONSOLEPATH = 48;
    private static final int INDEX_WORKSHOPPATH = 49;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMSPlatformBase proxyPSDCMSPlatformBase = null;
    private boolean adminpasswdDirtyFlag = false;
    private boolean adminusernameDirtyFlag = false;
    private boolean cfgserviceurlDirtyFlag = false;
    private boolean clusternamespaceDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mstypeDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcdeploycenteridDirtyFlag = false;
    private boolean psdcdeploycenternameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psmsplatformidDirtyFlag = false;
    private boolean psmsplatformnameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean serviceurlDirtyFlag = false;
    private boolean sshipaddrDirtyFlag = false;
    private boolean sshportDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uploadfilemodeDirtyFlag = false;
    private boolean uploadpathDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean webconsolepathDirtyFlag = false;
    private boolean workshoppathDirtyFlag = false;
    @Column(name="adminpasswd")
    private String adminpasswd;
    @Column(name="adminusername")
    private String adminusername;
    @Column(name="cfgserviceurl")
    private String cfgserviceurl;
    @Column(name="clusternamespace")
    private String clusternamespace;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="mstype")
    private String mstype;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcdeploycenterid")
    private String psdcdeploycenterid;
    @Column(name="psdcdeploycentername")
    private String psdcdeploycentername;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformname")
    private String psdcmsplatformname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psmsplatformid")
    private String psmsplatformid;
    @Column(name="psmsplatformname")
    private String psmsplatformname;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="serviceurl")
    private String serviceurl;
    @Column(name="sshipaddr")
    private String sshipaddr;
    @Column(name="sshport")
    private Integer sshport;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="uploadfilemode")
    private String uploadfilemode;
    @Column(name="uploadpath")
    private String uploadpath;
    @Column(name="username")
    private String username;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="webconsolepath")
    private String webconsolepath;
    @Column(name="workshoppath")
    private String workshoppath;
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCDeployCenterLock = new Integer(1);
    private PSDCDeployCenter psdcdeploycenter = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSMSPlatformLock = new Integer(1);
    private PSMSPlatform psmsplatform = null;
    private Integer objPSDCMSPlatformFuncsLock = new Integer(1);
    private ArrayList<PSDCMSPlatformFunc> psdcmsplatformfuncs = null;
    private Integer objPSDCMSPlatformNodesLock = new Integer(1);
    private ArrayList<PSDCMSPlatformNode> psdcmsplatformnodes = null;

    public void setAdminPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminpasswd = string;
        this.adminpasswdDirtyFlag = true;
    }

    public String getAdminPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPasswd();
        }
        return this.adminpasswd;
    }

    public boolean isAdminPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminPasswdDirty();
        }
        return this.adminpasswdDirtyFlag;
    }

    public void resetAdminPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminPasswd();
            return;
        }
        this.adminpasswdDirtyFlag = false;
        this.adminpasswd = null;
    }

    public void setAdminUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminusername = string;
        this.adminusernameDirtyFlag = true;
    }

    public String getAdminUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminUserName();
        }
        return this.adminusername;
    }

    public boolean isAdminUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminUserNameDirty();
        }
        return this.adminusernameDirtyFlag;
    }

    public void resetAdminUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminUserName();
            return;
        }
        this.adminusernameDirtyFlag = false;
        this.adminusername = null;
    }

    public void setCfgServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgserviceurl = string;
        this.cfgserviceurlDirtyFlag = true;
    }

    public String getCfgServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgServiceUrl();
        }
        return this.cfgserviceurl;
    }

    public boolean isCfgServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgServiceUrlDirty();
        }
        return this.cfgserviceurlDirtyFlag;
    }

    public void resetCfgServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgServiceUrl();
            return;
        }
        this.cfgserviceurlDirtyFlag = false;
        this.cfgserviceurl = null;
    }

    public void setClusterNamespace(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClusterNamespace(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clusternamespace = string;
        this.clusternamespaceDirtyFlag = true;
    }

    public String getClusterNamespace() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClusterNamespace();
        }
        return this.clusternamespace;
    }

    public boolean isClusterNamespaceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClusterNamespaceDirty();
        }
        return this.clusternamespaceDirtyFlag;
    }

    public void resetClusterNamespace() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClusterNamespace();
            return;
        }
        this.clusternamespaceDirtyFlag = false;
        this.clusternamespace = null;
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

    public void setIpAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIpAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr();
        }
        return this.ipaddr;
    }

    public boolean isIpAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIpAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
    }

    public void setIpAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIpAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr2 = string;
        this.ipaddr2DirtyFlag = true;
    }

    public String getIpAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIpAddr2();
        }
        return this.ipaddr2;
    }

    public boolean isIpAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIpAddr2Dirty();
        }
        return this.ipaddr2DirtyFlag;
    }

    public void resetIpAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIpAddr2();
            return;
        }
        this.ipaddr2DirtyFlag = false;
        this.ipaddr2 = null;
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

    public void setMSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mstype = string;
        this.mstypeDirtyFlag = true;
    }

    public String getMSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSType();
        }
        return this.mstype;
    }

    public boolean isMSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSTypeDirty();
        }
        return this.mstypeDirtyFlag;
    }

    public void resetMSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSType();
            return;
        }
        this.mstypeDirtyFlag = false;
        this.mstype = null;
    }

    public void setPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasswd();
        }
        return this.passwd;
    }

    public boolean isPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasswdDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasswd();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPort(n);
            return;
        }
        this.port = n;
        this.portDirtyFlag = true;
    }

    public Integer getPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPort();
        }
        return this.port;
    }

    public boolean isPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortDirty();
        }
        return this.portDirtyFlag;
    }

    public void resetPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPort();
            return;
        }
        this.portDirtyFlag = false;
        this.port = null;
    }

    public void setPSDCClusterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclusterid = string;
        this.psdcclusteridDirtyFlag = true;
    }

    public String getPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterId();
        }
        return this.psdcclusterid;
    }

    public boolean isPSDCClusterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterIdDirty();
        }
        return this.psdcclusteridDirtyFlag;
    }

    public void resetPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterId();
            return;
        }
        this.psdcclusteridDirtyFlag = false;
        this.psdcclusterid = null;
    }

    public void setPSDCClusterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclustername = string;
        this.psdcclusternameDirtyFlag = true;
    }

    public String getPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterName();
        }
        return this.psdcclustername;
    }

    public boolean isPSDCClusterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterNameDirty();
        }
        return this.psdcclusternameDirtyFlag;
    }

    public void resetPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterName();
            return;
        }
        this.psdcclusternameDirtyFlag = false;
        this.psdcclustername = null;
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

    public void setPSDCDeployCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycenterid = string;
        this.psdcdeploycenteridDirtyFlag = true;
    }

    public String getPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterId();
        }
        return this.psdcdeploycenterid;
    }

    public boolean isPSDCDeployCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterIdDirty();
        }
        return this.psdcdeploycenteridDirtyFlag;
    }

    public void resetPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterId();
            return;
        }
        this.psdcdeploycenteridDirtyFlag = false;
        this.psdcdeploycenterid = null;
    }

    public void setPSDCDeployCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycentername = string;
        this.psdcdeploycenternameDirtyFlag = true;
    }

    public String getPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterName();
        }
        return this.psdcdeploycentername;
    }

    public boolean isPSDCDeployCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterNameDirty();
        }
        return this.psdcdeploycenternameDirtyFlag;
    }

    public void resetPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterName();
            return;
        }
        this.psdcdeploycenternameDirtyFlag = false;
        this.psdcdeploycentername = null;
    }

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
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

    public void setPSDCMSPlatformName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformname = string;
        this.psdcmsplatformnameDirtyFlag = true;
    }

    public String getPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformName();
        }
        return this.psdcmsplatformname;
    }

    public boolean isPSDCMSPlatformNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNameDirty();
        }
        return this.psdcmsplatformnameDirtyFlag;
    }

    public void resetPSDCMSPlatformName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformName();
            return;
        }
        this.psdcmsplatformnameDirtyFlag = false;
        this.psdcmsplatformname = null;
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

    public void setPSMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformid = string;
        this.psmsplatformidDirtyFlag = true;
    }

    public String getPSMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformId();
        }
        return this.psmsplatformid;
    }

    public boolean isPSMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformIdDirty();
        }
        return this.psmsplatformidDirtyFlag;
    }

    public void resetPSMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformId();
            return;
        }
        this.psmsplatformidDirtyFlag = false;
        this.psmsplatformid = null;
    }

    public void setPSMSPlatformName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformname = string;
        this.psmsplatformnameDirtyFlag = true;
    }

    public String getPSMSPlatformName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformName();
        }
        return this.psmsplatformname;
    }

    public boolean isPSMSPlatformNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformNameDirty();
        }
        return this.psmsplatformnameDirtyFlag;
    }

    public void resetPSMSPlatformName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformName();
            return;
        }
        this.psmsplatformnameDirtyFlag = false;
        this.psmsplatformname = null;
    }

    public void setRefCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCount(n);
            return;
        }
        this.refcount = n;
        this.refcountDirtyFlag = true;
    }

    public Integer getRefCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCount();
        }
        return this.refcount;
    }

    public boolean isRefCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCountDirty();
        }
        return this.refcountDirtyFlag;
    }

    public void resetRefCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCount();
            return;
        }
        this.refcountDirtyFlag = false;
        this.refcount = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
    }

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
    }

    public void setResVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResVer(n);
            return;
        }
        this.resver = n;
        this.resverDirtyFlag = true;
    }

    public Integer getResVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResVer();
        }
        return this.resver;
    }

    public boolean isResVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResVerDirty();
        }
        return this.resverDirtyFlag;
    }

    public void resetResVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResVer();
            return;
        }
        this.resverDirtyFlag = false;
        this.resver = null;
    }

    public void setServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceurl = string;
        this.serviceurlDirtyFlag = true;
    }

    public String getServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceUrl();
        }
        return this.serviceurl;
    }

    public boolean isServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceUrlDirty();
        }
        return this.serviceurlDirtyFlag;
    }

    public void resetServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceUrl();
            return;
        }
        this.serviceurlDirtyFlag = false;
        this.serviceurl = null;
    }

    public void setSSHIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sshipaddr = string;
        this.sshipaddrDirtyFlag = true;
    }

    public String getSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHIPAddr();
        }
        return this.sshipaddr;
    }

    public boolean isSSHIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHIPAddrDirty();
        }
        return this.sshipaddrDirtyFlag;
    }

    public void resetSSHIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHIPAddr();
            return;
        }
        this.sshipaddrDirtyFlag = false;
        this.sshipaddr = null;
    }

    public void setSSHPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSSHPort(n);
            return;
        }
        this.sshport = n;
        this.sshportDirtyFlag = true;
    }

    public Integer getSSHPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSSHPort();
        }
        return this.sshport;
    }

    public boolean isSSHPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSSHPortDirty();
        }
        return this.sshportDirtyFlag;
    }

    public void resetSSHPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSSHPort();
            return;
        }
        this.sshportDirtyFlag = false;
        this.sshport = null;
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

    public void setUploadFileMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadFileMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadfilemode = string;
        this.uploadfilemodeDirtyFlag = true;
    }

    public String getUploadFileMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadFileMode();
        }
        return this.uploadfilemode;
    }

    public boolean isUploadFileModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadFileModeDirty();
        }
        return this.uploadfilemodeDirtyFlag;
    }

    public void resetUploadFileMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadFileMode();
            return;
        }
        this.uploadfilemodeDirtyFlag = false;
        this.uploadfilemode = null;
    }

    public void setUploadPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUploadPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uploadpath = string;
        this.uploadpathDirtyFlag = true;
    }

    public String getUploadPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUploadPath();
        }
        return this.uploadpath;
    }

    public boolean isUploadPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUploadPathDirty();
        }
        return this.uploadpathDirtyFlag;
    }

    public void resetUploadPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUploadPath();
            return;
        }
        this.uploadpathDirtyFlag = false;
        this.uploadpath = null;
    }

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
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

    public void setWebConsolePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWebConsolePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.webconsolepath = string;
        this.webconsolepathDirtyFlag = true;
    }

    public String getWebConsolePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWebConsolePath();
        }
        return this.webconsolepath;
    }

    public boolean isWebConsolePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWebConsolePathDirty();
        }
        return this.webconsolepathDirtyFlag;
    }

    public void resetWebConsolePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWebConsolePath();
            return;
        }
        this.webconsolepathDirtyFlag = false;
        this.webconsolepath = null;
    }

    public void setWorkshopPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkshopPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workshoppath = string;
        this.workshoppathDirtyFlag = true;
    }

    public String getWorkshopPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkshopPath();
        }
        return this.workshoppath;
    }

    public boolean isWorkshopPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkshopPathDirty();
        }
        return this.workshoppathDirtyFlag;
    }

    public void resetWorkshopPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkshopPath();
            return;
        }
        this.workshoppathDirtyFlag = false;
        this.workshoppath = null;
    }

    protected void onReset() {
        PSDCMSPlatformBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMSPlatformBase pSDCMSPlatformBase) {
        pSDCMSPlatformBase.resetAdminPasswd();
        pSDCMSPlatformBase.resetAdminUserName();
        pSDCMSPlatformBase.resetCfgServiceUrl();
        pSDCMSPlatformBase.resetClusterNamespace();
        pSDCMSPlatformBase.resetCreateDate();
        pSDCMSPlatformBase.resetCreateMan();
        pSDCMSPlatformBase.resetExpriedTime();
        pSDCMSPlatformBase.resetIpAddr();
        pSDCMSPlatformBase.resetIpAddr2();
        pSDCMSPlatformBase.resetMemo();
        pSDCMSPlatformBase.resetMSType();
        pSDCMSPlatformBase.resetPasswd();
        pSDCMSPlatformBase.resetPort();
        pSDCMSPlatformBase.resetPSDCClusterId();
        pSDCMSPlatformBase.resetPSDCClusterName();
        pSDCMSPlatformBase.resetPSDCContainerSpecId();
        pSDCMSPlatformBase.resetPSDCContainerSpecName();
        pSDCMSPlatformBase.resetPSDCDeployCenterId();
        pSDCMSPlatformBase.resetPSDCDeployCenterName();
        pSDCMSPlatformBase.resetPSDCFileId();
        pSDCMSPlatformBase.resetPSDCFileName();
        pSDCMSPlatformBase.resetPSDCMSPlatformId();
        pSDCMSPlatformBase.resetPSDCMSPlatformName();
        pSDCMSPlatformBase.resetPSDevCenterId();
        pSDCMSPlatformBase.resetPSDevCenterName();
        pSDCMSPlatformBase.resetPSDevSlnId();
        pSDCMSPlatformBase.resetPSDevSlnName();
        pSDCMSPlatformBase.resetPSMSPlatformId();
        pSDCMSPlatformBase.resetPSMSPlatformName();
        pSDCMSPlatformBase.resetRefCount();
        pSDCMSPlatformBase.resetResPos();
        pSDCMSPlatformBase.resetResReadyTime();
        pSDCMSPlatformBase.resetResState();
        pSDCMSPlatformBase.resetResVer();
        pSDCMSPlatformBase.resetServiceUrl();
        pSDCMSPlatformBase.resetSSHIPAddr();
        pSDCMSPlatformBase.resetSSHPort();
        pSDCMSPlatformBase.resetUpdateDate();
        pSDCMSPlatformBase.resetUpdateMan();
        pSDCMSPlatformBase.resetUploadFileMode();
        pSDCMSPlatformBase.resetUploadPath();
        pSDCMSPlatformBase.resetUserName();
        pSDCMSPlatformBase.resetUserParams();
        pSDCMSPlatformBase.resetUserTag();
        pSDCMSPlatformBase.resetUserTag2();
        pSDCMSPlatformBase.resetUserTag3();
        pSDCMSPlatformBase.resetUserTag4();
        pSDCMSPlatformBase.resetValidFlag();
        pSDCMSPlatformBase.resetWebConsolePath();
        pSDCMSPlatformBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPasswdDirty()) {
            hashMap.put(FIELD_ADMINPASSWD, this.getAdminPasswd());
        }
        if (!bl || this.isAdminUserNameDirty()) {
            hashMap.put(FIELD_ADMINUSERNAME, this.getAdminUserName());
        }
        if (!bl || this.isCfgServiceUrlDirty()) {
            hashMap.put(FIELD_CFGSERVICEURL, this.getCfgServiceUrl());
        }
        if (!bl || this.isClusterNamespaceDirty()) {
            hashMap.put(FIELD_CLUSTERNAMESPACE, this.getClusterNamespace());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMSTypeDirty()) {
            hashMap.put(FIELD_MSTYPE, this.getMSType());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSDCClusterIdDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERID, this.getPSDCClusterId());
        }
        if (!bl || this.isPSDCClusterNameDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERNAME, this.getPSDCClusterName());
        }
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDCDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERID, this.getPSDCDeployCenterId());
        }
        if (!bl || this.isPSDCDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERNAME, this.getPSDCDeployCenterName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNAME, this.getPSDCMSPlatformName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMID, this.getPSMSPlatformId());
        }
        if (!bl || this.isPSMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNAME, this.getPSMSPlatformName());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isResVerDirty()) {
            hashMap.put(FIELD_RESVER, this.getResVer());
        }
        if (!bl || this.isServiceUrlDirty()) {
            hashMap.put(FIELD_SERVICEURL, this.getServiceUrl());
        }
        if (!bl || this.isSSHIPAddrDirty()) {
            hashMap.put(FIELD_SSHIPADDR, this.getSSHIPAddr());
        }
        if (!bl || this.isSSHPortDirty()) {
            hashMap.put(FIELD_SSHPORT, this.getSSHPort());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUploadFileModeDirty()) {
            hashMap.put(FIELD_UPLOADFILEMODE, this.getUploadFileMode());
        }
        if (!bl || this.isUploadPathDirty()) {
            hashMap.put(FIELD_UPLOADPATH, this.getUploadPath());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isWebConsolePathDirty()) {
            hashMap.put(FIELD_WEBCONSOLEPATH, this.getWebConsolePath());
        }
        if (!bl || this.isWorkshopPathDirty()) {
            hashMap.put(FIELD_WORKSHOPPATH, this.getWorkshopPath());
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
        return PSDCMSPlatformBase.get(this, n);
    }

    private static Object get(PSDCMSPlatformBase pSDCMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformBase.getAdminPasswd();
            }
            case 1: {
                return pSDCMSPlatformBase.getAdminUserName();
            }
            case 2: {
                return pSDCMSPlatformBase.getCfgServiceUrl();
            }
            case 3: {
                return pSDCMSPlatformBase.getClusterNamespace();
            }
            case 4: {
                return pSDCMSPlatformBase.getCreateDate();
            }
            case 5: {
                return pSDCMSPlatformBase.getCreateMan();
            }
            case 6: {
                return pSDCMSPlatformBase.getExpriedTime();
            }
            case 7: {
                return pSDCMSPlatformBase.getIpAddr();
            }
            case 8: {
                return pSDCMSPlatformBase.getIpAddr2();
            }
            case 9: {
                return pSDCMSPlatformBase.getMemo();
            }
            case 10: {
                return pSDCMSPlatformBase.getMSType();
            }
            case 11: {
                return pSDCMSPlatformBase.getPasswd();
            }
            case 12: {
                return pSDCMSPlatformBase.getPort();
            }
            case 13: {
                return pSDCMSPlatformBase.getPSDCClusterId();
            }
            case 14: {
                return pSDCMSPlatformBase.getPSDCClusterName();
            }
            case 15: {
                return pSDCMSPlatformBase.getPSDCContainerSpecId();
            }
            case 16: {
                return pSDCMSPlatformBase.getPSDCContainerSpecName();
            }
            case 17: {
                return pSDCMSPlatformBase.getPSDCDeployCenterId();
            }
            case 18: {
                return pSDCMSPlatformBase.getPSDCDeployCenterName();
            }
            case 19: {
                return pSDCMSPlatformBase.getPSDCFileId();
            }
            case 20: {
                return pSDCMSPlatformBase.getPSDCFileName();
            }
            case 21: {
                return pSDCMSPlatformBase.getPSDCMSPlatformId();
            }
            case 22: {
                return pSDCMSPlatformBase.getPSDCMSPlatformName();
            }
            case 23: {
                return pSDCMSPlatformBase.getPSDevCenterId();
            }
            case 24: {
                return pSDCMSPlatformBase.getPSDevCenterName();
            }
            case 25: {
                return pSDCMSPlatformBase.getPSDevSlnId();
            }
            case 26: {
                return pSDCMSPlatformBase.getPSDevSlnName();
            }
            case 27: {
                return pSDCMSPlatformBase.getPSMSPlatformId();
            }
            case 28: {
                return pSDCMSPlatformBase.getPSMSPlatformName();
            }
            case 29: {
                return pSDCMSPlatformBase.getRefCount();
            }
            case 30: {
                return pSDCMSPlatformBase.getResPos();
            }
            case 31: {
                return pSDCMSPlatformBase.getResReadyTime();
            }
            case 32: {
                return pSDCMSPlatformBase.getResState();
            }
            case 33: {
                return pSDCMSPlatformBase.getResVer();
            }
            case 34: {
                return pSDCMSPlatformBase.getServiceUrl();
            }
            case 35: {
                return pSDCMSPlatformBase.getSSHIPAddr();
            }
            case 36: {
                return pSDCMSPlatformBase.getSSHPort();
            }
            case 37: {
                return pSDCMSPlatformBase.getUpdateDate();
            }
            case 38: {
                return pSDCMSPlatformBase.getUpdateMan();
            }
            case 39: {
                return pSDCMSPlatformBase.getUploadFileMode();
            }
            case 40: {
                return pSDCMSPlatformBase.getUploadPath();
            }
            case 41: {
                return pSDCMSPlatformBase.getUserName();
            }
            case 42: {
                return pSDCMSPlatformBase.getUserParams();
            }
            case 43: {
                return pSDCMSPlatformBase.getUserTag();
            }
            case 44: {
                return pSDCMSPlatformBase.getUserTag2();
            }
            case 45: {
                return pSDCMSPlatformBase.getUserTag3();
            }
            case 46: {
                return pSDCMSPlatformBase.getUserTag4();
            }
            case 47: {
                return pSDCMSPlatformBase.getValidFlag();
            }
            case 48: {
                return pSDCMSPlatformBase.getWebConsolePath();
            }
            case 49: {
                return pSDCMSPlatformBase.getWorkshopPath();
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
        PSDCMSPlatformBase.set(this, n, object);
    }

    private static void set(PSDCMSPlatformBase pSDCMSPlatformBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMSPlatformBase.setAdminPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCMSPlatformBase.setAdminUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMSPlatformBase.setCfgServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMSPlatformBase.setClusterNamespace(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMSPlatformBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDCMSPlatformBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMSPlatformBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCMSPlatformBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCMSPlatformBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCMSPlatformBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCMSPlatformBase.setMSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCMSPlatformBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCMSPlatformBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDCMSPlatformBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCMSPlatformBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCMSPlatformBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCMSPlatformBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCMSPlatformBase.setPSDCDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCMSPlatformBase.setPSDCDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCMSPlatformBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCMSPlatformBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCMSPlatformBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCMSPlatformBase.setPSDCMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCMSPlatformBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCMSPlatformBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCMSPlatformBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCMSPlatformBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCMSPlatformBase.setPSMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCMSPlatformBase.setPSMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCMSPlatformBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDCMSPlatformBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDCMSPlatformBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSDCMSPlatformBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDCMSPlatformBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDCMSPlatformBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDCMSPlatformBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDCMSPlatformBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDCMSPlatformBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSDCMSPlatformBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDCMSPlatformBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDCMSPlatformBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDCMSPlatformBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDCMSPlatformBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDCMSPlatformBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDCMSPlatformBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDCMSPlatformBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDCMSPlatformBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDCMSPlatformBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSDCMSPlatformBase.setWebConsolePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDCMSPlatformBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDCMSPlatformBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMSPlatformBase pSDCMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformBase.getAdminPasswd() == null;
            }
            case 1: {
                return pSDCMSPlatformBase.getAdminUserName() == null;
            }
            case 2: {
                return pSDCMSPlatformBase.getCfgServiceUrl() == null;
            }
            case 3: {
                return pSDCMSPlatformBase.getClusterNamespace() == null;
            }
            case 4: {
                return pSDCMSPlatformBase.getCreateDate() == null;
            }
            case 5: {
                return pSDCMSPlatformBase.getCreateMan() == null;
            }
            case 6: {
                return pSDCMSPlatformBase.getExpriedTime() == null;
            }
            case 7: {
                return pSDCMSPlatformBase.getIpAddr() == null;
            }
            case 8: {
                return pSDCMSPlatformBase.getIpAddr2() == null;
            }
            case 9: {
                return pSDCMSPlatformBase.getMemo() == null;
            }
            case 10: {
                return pSDCMSPlatformBase.getMSType() == null;
            }
            case 11: {
                return pSDCMSPlatformBase.getPasswd() == null;
            }
            case 12: {
                return pSDCMSPlatformBase.getPort() == null;
            }
            case 13: {
                return pSDCMSPlatformBase.getPSDCClusterId() == null;
            }
            case 14: {
                return pSDCMSPlatformBase.getPSDCClusterName() == null;
            }
            case 15: {
                return pSDCMSPlatformBase.getPSDCContainerSpecId() == null;
            }
            case 16: {
                return pSDCMSPlatformBase.getPSDCContainerSpecName() == null;
            }
            case 17: {
                return pSDCMSPlatformBase.getPSDCDeployCenterId() == null;
            }
            case 18: {
                return pSDCMSPlatformBase.getPSDCDeployCenterName() == null;
            }
            case 19: {
                return pSDCMSPlatformBase.getPSDCFileId() == null;
            }
            case 20: {
                return pSDCMSPlatformBase.getPSDCFileName() == null;
            }
            case 21: {
                return pSDCMSPlatformBase.getPSDCMSPlatformId() == null;
            }
            case 22: {
                return pSDCMSPlatformBase.getPSDCMSPlatformName() == null;
            }
            case 23: {
                return pSDCMSPlatformBase.getPSDevCenterId() == null;
            }
            case 24: {
                return pSDCMSPlatformBase.getPSDevCenterName() == null;
            }
            case 25: {
                return pSDCMSPlatformBase.getPSDevSlnId() == null;
            }
            case 26: {
                return pSDCMSPlatformBase.getPSDevSlnName() == null;
            }
            case 27: {
                return pSDCMSPlatformBase.getPSMSPlatformId() == null;
            }
            case 28: {
                return pSDCMSPlatformBase.getPSMSPlatformName() == null;
            }
            case 29: {
                return pSDCMSPlatformBase.getRefCount() == null;
            }
            case 30: {
                return pSDCMSPlatformBase.getResPos() == null;
            }
            case 31: {
                return pSDCMSPlatformBase.getResReadyTime() == null;
            }
            case 32: {
                return pSDCMSPlatformBase.getResState() == null;
            }
            case 33: {
                return pSDCMSPlatformBase.getResVer() == null;
            }
            case 34: {
                return pSDCMSPlatformBase.getServiceUrl() == null;
            }
            case 35: {
                return pSDCMSPlatformBase.getSSHIPAddr() == null;
            }
            case 36: {
                return pSDCMSPlatformBase.getSSHPort() == null;
            }
            case 37: {
                return pSDCMSPlatformBase.getUpdateDate() == null;
            }
            case 38: {
                return pSDCMSPlatformBase.getUpdateMan() == null;
            }
            case 39: {
                return pSDCMSPlatformBase.getUploadFileMode() == null;
            }
            case 40: {
                return pSDCMSPlatformBase.getUploadPath() == null;
            }
            case 41: {
                return pSDCMSPlatformBase.getUserName() == null;
            }
            case 42: {
                return pSDCMSPlatformBase.getUserParams() == null;
            }
            case 43: {
                return pSDCMSPlatformBase.getUserTag() == null;
            }
            case 44: {
                return pSDCMSPlatformBase.getUserTag2() == null;
            }
            case 45: {
                return pSDCMSPlatformBase.getUserTag3() == null;
            }
            case 46: {
                return pSDCMSPlatformBase.getUserTag4() == null;
            }
            case 47: {
                return pSDCMSPlatformBase.getValidFlag() == null;
            }
            case 48: {
                return pSDCMSPlatformBase.getWebConsolePath() == null;
            }
            case 49: {
                return pSDCMSPlatformBase.getWorkshopPath() == null;
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
        return PSDCMSPlatformBase.contains(this, n);
    }

    private static boolean contains(PSDCMSPlatformBase pSDCMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformBase.isAdminPasswdDirty();
            }
            case 1: {
                return pSDCMSPlatformBase.isAdminUserNameDirty();
            }
            case 2: {
                return pSDCMSPlatformBase.isCfgServiceUrlDirty();
            }
            case 3: {
                return pSDCMSPlatformBase.isClusterNamespaceDirty();
            }
            case 4: {
                return pSDCMSPlatformBase.isCreateDateDirty();
            }
            case 5: {
                return pSDCMSPlatformBase.isCreateManDirty();
            }
            case 6: {
                return pSDCMSPlatformBase.isExpriedTimeDirty();
            }
            case 7: {
                return pSDCMSPlatformBase.isIpAddrDirty();
            }
            case 8: {
                return pSDCMSPlatformBase.isIpAddr2Dirty();
            }
            case 9: {
                return pSDCMSPlatformBase.isMemoDirty();
            }
            case 10: {
                return pSDCMSPlatformBase.isMSTypeDirty();
            }
            case 11: {
                return pSDCMSPlatformBase.isPasswdDirty();
            }
            case 12: {
                return pSDCMSPlatformBase.isPortDirty();
            }
            case 13: {
                return pSDCMSPlatformBase.isPSDCClusterIdDirty();
            }
            case 14: {
                return pSDCMSPlatformBase.isPSDCClusterNameDirty();
            }
            case 15: {
                return pSDCMSPlatformBase.isPSDCContainerSpecIdDirty();
            }
            case 16: {
                return pSDCMSPlatformBase.isPSDCContainerSpecNameDirty();
            }
            case 17: {
                return pSDCMSPlatformBase.isPSDCDeployCenterIdDirty();
            }
            case 18: {
                return pSDCMSPlatformBase.isPSDCDeployCenterNameDirty();
            }
            case 19: {
                return pSDCMSPlatformBase.isPSDCFileIdDirty();
            }
            case 20: {
                return pSDCMSPlatformBase.isPSDCFileNameDirty();
            }
            case 21: {
                return pSDCMSPlatformBase.isPSDCMSPlatformIdDirty();
            }
            case 22: {
                return pSDCMSPlatformBase.isPSDCMSPlatformNameDirty();
            }
            case 23: {
                return pSDCMSPlatformBase.isPSDevCenterIdDirty();
            }
            case 24: {
                return pSDCMSPlatformBase.isPSDevCenterNameDirty();
            }
            case 25: {
                return pSDCMSPlatformBase.isPSDevSlnIdDirty();
            }
            case 26: {
                return pSDCMSPlatformBase.isPSDevSlnNameDirty();
            }
            case 27: {
                return pSDCMSPlatformBase.isPSMSPlatformIdDirty();
            }
            case 28: {
                return pSDCMSPlatformBase.isPSMSPlatformNameDirty();
            }
            case 29: {
                return pSDCMSPlatformBase.isRefCountDirty();
            }
            case 30: {
                return pSDCMSPlatformBase.isResPosDirty();
            }
            case 31: {
                return pSDCMSPlatformBase.isResReadyTimeDirty();
            }
            case 32: {
                return pSDCMSPlatformBase.isResStateDirty();
            }
            case 33: {
                return pSDCMSPlatformBase.isResVerDirty();
            }
            case 34: {
                return pSDCMSPlatformBase.isServiceUrlDirty();
            }
            case 35: {
                return pSDCMSPlatformBase.isSSHIPAddrDirty();
            }
            case 36: {
                return pSDCMSPlatformBase.isSSHPortDirty();
            }
            case 37: {
                return pSDCMSPlatformBase.isUpdateDateDirty();
            }
            case 38: {
                return pSDCMSPlatformBase.isUpdateManDirty();
            }
            case 39: {
                return pSDCMSPlatformBase.isUploadFileModeDirty();
            }
            case 40: {
                return pSDCMSPlatformBase.isUploadPathDirty();
            }
            case 41: {
                return pSDCMSPlatformBase.isUserNameDirty();
            }
            case 42: {
                return pSDCMSPlatformBase.isUserParamsDirty();
            }
            case 43: {
                return pSDCMSPlatformBase.isUserTagDirty();
            }
            case 44: {
                return pSDCMSPlatformBase.isUserTag2Dirty();
            }
            case 45: {
                return pSDCMSPlatformBase.isUserTag3Dirty();
            }
            case 46: {
                return pSDCMSPlatformBase.isUserTag4Dirty();
            }
            case 47: {
                return pSDCMSPlatformBase.isValidFlagDirty();
            }
            case 48: {
                return pSDCMSPlatformBase.isWebConsolePathDirty();
            }
            case 49: {
                return pSDCMSPlatformBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMSPlatformBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMSPlatformBase pSDCMSPlatformBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMSPlatformBase.getAdminPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpasswd", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getAdminPasswd()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getAdminUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminusername", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getAdminUserName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getCfgServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgserviceurl", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getCfgServiceUrl()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getClusterNamespace() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clusternamespace", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getClusterNamespace()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getMSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mstype", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getMSType()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPort()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycenterid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCDeployCenterId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycentername", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCDeployCenterName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDCMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformname", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDCMSPlatformName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformid", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSMSPlatformId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getPSMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformname", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getPSMSPlatformName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getResState()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getResVer()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getWebConsolePath()), (boolean)false);
        }
        if (bl || pSDCMSPlatformBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDCMSPlatformBase.getJSONValue((Object)pSDCMSPlatformBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMSPlatformBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMSPlatformBase pSDCMSPlatformBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMSPlatformBase.getAdminPasswd() != null) {
            object = pSDCMSPlatformBase.getAdminPasswd();
            xmlNode.setAttribute(FIELD_ADMINPASSWD, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMSPlatformBase.getAdminUserName() != null) {
            object = pSDCMSPlatformBase.getAdminUserName();
            xmlNode.setAttribute(FIELD_ADMINUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMSPlatformBase.getCfgServiceUrl() != null) {
            object = pSDCMSPlatformBase.getCfgServiceUrl();
            xmlNode.setAttribute(FIELD_CFGSERVICEURL, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMSPlatformBase.getClusterNamespace() != null) {
            object = pSDCMSPlatformBase.getClusterNamespace();
            xmlNode.setAttribute(FIELD_CLUSTERNAMESPACE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getCreateDate() != null) {
            object = pSDCMSPlatformBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getCreateMan() != null) {
            object = pSDCMSPlatformBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getExpriedTime() != null) {
            object = pSDCMSPlatformBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getIpAddr() != null) {
            object = pSDCMSPlatformBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getIpAddr2() != null) {
            object = pSDCMSPlatformBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getMemo() != null) {
            object = pSDCMSPlatformBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getMSType() != null) {
            object = pSDCMSPlatformBase.getMSType();
            xmlNode.setAttribute(FIELD_MSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPasswd() != null) {
            object = pSDCMSPlatformBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPort() != null) {
            object = pSDCMSPlatformBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getPSDCClusterId() != null) {
            object = pSDCMSPlatformBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCClusterName() != null) {
            object = pSDCMSPlatformBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCContainerSpecId() != null) {
            object = pSDCMSPlatformBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCContainerSpecName() != null) {
            object = pSDCMSPlatformBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCDeployCenterId() != null) {
            object = pSDCMSPlatformBase.getPSDCDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCDeployCenterName() != null) {
            object = pSDCMSPlatformBase.getPSDCDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCFileId() != null) {
            object = pSDCMSPlatformBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCFileName() != null) {
            object = pSDCMSPlatformBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCMSPlatformId() != null) {
            object = pSDCMSPlatformBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDCMSPlatformName() != null) {
            object = pSDCMSPlatformBase.getPSDCMSPlatformName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDevCenterId() != null) {
            object = pSDCMSPlatformBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDevCenterName() != null) {
            object = pSDCMSPlatformBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDevSlnId() != null) {
            object = pSDCMSPlatformBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSDevSlnName() != null) {
            object = pSDCMSPlatformBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSMSPlatformId() != null) {
            object = pSDCMSPlatformBase.getPSMSPlatformId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getPSMSPlatformName() != null) {
            object = pSDCMSPlatformBase.getPSMSPlatformName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getRefCount() != null) {
            object = pSDCMSPlatformBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getResPos() != null) {
            object = pSDCMSPlatformBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getResReadyTime() != null) {
            object = pSDCMSPlatformBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getResState() != null) {
            object = pSDCMSPlatformBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getResVer() != null) {
            object = pSDCMSPlatformBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getServiceUrl() != null) {
            object = pSDCMSPlatformBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getSSHIPAddr() != null) {
            object = pSDCMSPlatformBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getSSHPort() != null) {
            object = pSDCMSPlatformBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getUpdateDate() != null) {
            object = pSDCMSPlatformBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getUpdateMan() != null) {
            object = pSDCMSPlatformBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUploadFileMode() != null) {
            object = pSDCMSPlatformBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUploadPath() != null) {
            object = pSDCMSPlatformBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUserName() != null) {
            object = pSDCMSPlatformBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUserParams() != null) {
            object = pSDCMSPlatformBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUserTag() != null) {
            object = pSDCMSPlatformBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUserTag2() != null) {
            object = pSDCMSPlatformBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUserTag3() != null) {
            object = pSDCMSPlatformBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getUserTag4() != null) {
            object = pSDCMSPlatformBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getValidFlag() != null) {
            object = pSDCMSPlatformBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformBase.getWebConsolePath() != null) {
            object = pSDCMSPlatformBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformBase.getWorkshopPath() != null) {
            object = pSDCMSPlatformBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMSPlatformBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMSPlatformBase pSDCMSPlatformBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMSPlatformBase.isAdminPasswdDirty() && (bl || pSDCMSPlatformBase.getAdminPasswd() != null)) {
            iDataObject.set(FIELD_ADMINPASSWD, (Object)pSDCMSPlatformBase.getAdminPasswd());
        }
        if (pSDCMSPlatformBase.isAdminUserNameDirty() && (bl || pSDCMSPlatformBase.getAdminUserName() != null)) {
            iDataObject.set(FIELD_ADMINUSERNAME, (Object)pSDCMSPlatformBase.getAdminUserName());
        }
        if (pSDCMSPlatformBase.isCfgServiceUrlDirty() && (bl || pSDCMSPlatformBase.getCfgServiceUrl() != null)) {
            iDataObject.set(FIELD_CFGSERVICEURL, (Object)pSDCMSPlatformBase.getCfgServiceUrl());
        }
        if (pSDCMSPlatformBase.isClusterNamespaceDirty() && (bl || pSDCMSPlatformBase.getClusterNamespace() != null)) {
            iDataObject.set(FIELD_CLUSTERNAMESPACE, (Object)pSDCMSPlatformBase.getClusterNamespace());
        }
        if (pSDCMSPlatformBase.isCreateDateDirty() && (bl || pSDCMSPlatformBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMSPlatformBase.getCreateDate());
        }
        if (pSDCMSPlatformBase.isCreateManDirty() && (bl || pSDCMSPlatformBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMSPlatformBase.getCreateMan());
        }
        if (pSDCMSPlatformBase.isExpriedTimeDirty() && (bl || pSDCMSPlatformBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCMSPlatformBase.getExpriedTime());
        }
        if (pSDCMSPlatformBase.isIpAddrDirty() && (bl || pSDCMSPlatformBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCMSPlatformBase.getIpAddr());
        }
        if (pSDCMSPlatformBase.isIpAddr2Dirty() && (bl || pSDCMSPlatformBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCMSPlatformBase.getIpAddr2());
        }
        if (pSDCMSPlatformBase.isMemoDirty() && (bl || pSDCMSPlatformBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMSPlatformBase.getMemo());
        }
        if (pSDCMSPlatformBase.isMSTypeDirty() && (bl || pSDCMSPlatformBase.getMSType() != null)) {
            iDataObject.set(FIELD_MSTYPE, (Object)pSDCMSPlatformBase.getMSType());
        }
        if (pSDCMSPlatformBase.isPasswdDirty() && (bl || pSDCMSPlatformBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCMSPlatformBase.getPasswd());
        }
        if (pSDCMSPlatformBase.isPortDirty() && (bl || pSDCMSPlatformBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCMSPlatformBase.getPort());
        }
        if (pSDCMSPlatformBase.isPSDCClusterIdDirty() && (bl || pSDCMSPlatformBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDCMSPlatformBase.getPSDCClusterId());
        }
        if (pSDCMSPlatformBase.isPSDCClusterNameDirty() && (bl || pSDCMSPlatformBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDCMSPlatformBase.getPSDCClusterName());
        }
        if (pSDCMSPlatformBase.isPSDCContainerSpecIdDirty() && (bl || pSDCMSPlatformBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDCMSPlatformBase.getPSDCContainerSpecId());
        }
        if (pSDCMSPlatformBase.isPSDCContainerSpecNameDirty() && (bl || pSDCMSPlatformBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDCMSPlatformBase.getPSDCContainerSpecName());
        }
        if (pSDCMSPlatformBase.isPSDCDeployCenterIdDirty() && (bl || pSDCMSPlatformBase.getPSDCDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERID, (Object)pSDCMSPlatformBase.getPSDCDeployCenterId());
        }
        if (pSDCMSPlatformBase.isPSDCDeployCenterNameDirty() && (bl || pSDCMSPlatformBase.getPSDCDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERNAME, (Object)pSDCMSPlatformBase.getPSDCDeployCenterName());
        }
        if (pSDCMSPlatformBase.isPSDCFileIdDirty() && (bl || pSDCMSPlatformBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDCMSPlatformBase.getPSDCFileId());
        }
        if (pSDCMSPlatformBase.isPSDCFileNameDirty() && (bl || pSDCMSPlatformBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDCMSPlatformBase.getPSDCFileName());
        }
        if (pSDCMSPlatformBase.isPSDCMSPlatformIdDirty() && (bl || pSDCMSPlatformBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDCMSPlatformBase.getPSDCMSPlatformId());
        }
        if (pSDCMSPlatformBase.isPSDCMSPlatformNameDirty() && (bl || pSDCMSPlatformBase.getPSDCMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNAME, (Object)pSDCMSPlatformBase.getPSDCMSPlatformName());
        }
        if (pSDCMSPlatformBase.isPSDevCenterIdDirty() && (bl || pSDCMSPlatformBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCMSPlatformBase.getPSDevCenterId());
        }
        if (pSDCMSPlatformBase.isPSDevCenterNameDirty() && (bl || pSDCMSPlatformBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCMSPlatformBase.getPSDevCenterName());
        }
        if (pSDCMSPlatformBase.isPSDevSlnIdDirty() && (bl || pSDCMSPlatformBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCMSPlatformBase.getPSDevSlnId());
        }
        if (pSDCMSPlatformBase.isPSDevSlnNameDirty() && (bl || pSDCMSPlatformBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCMSPlatformBase.getPSDevSlnName());
        }
        if (pSDCMSPlatformBase.isPSMSPlatformIdDirty() && (bl || pSDCMSPlatformBase.getPSMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMID, (Object)pSDCMSPlatformBase.getPSMSPlatformId());
        }
        if (pSDCMSPlatformBase.isPSMSPlatformNameDirty() && (bl || pSDCMSPlatformBase.getPSMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNAME, (Object)pSDCMSPlatformBase.getPSMSPlatformName());
        }
        if (pSDCMSPlatformBase.isRefCountDirty() && (bl || pSDCMSPlatformBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCMSPlatformBase.getRefCount());
        }
        if (pSDCMSPlatformBase.isResPosDirty() && (bl || pSDCMSPlatformBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCMSPlatformBase.getResPos());
        }
        if (pSDCMSPlatformBase.isResReadyTimeDirty() && (bl || pSDCMSPlatformBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCMSPlatformBase.getResReadyTime());
        }
        if (pSDCMSPlatformBase.isResStateDirty() && (bl || pSDCMSPlatformBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCMSPlatformBase.getResState());
        }
        if (pSDCMSPlatformBase.isResVerDirty() && (bl || pSDCMSPlatformBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDCMSPlatformBase.getResVer());
        }
        if (pSDCMSPlatformBase.isServiceUrlDirty() && (bl || pSDCMSPlatformBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSDCMSPlatformBase.getServiceUrl());
        }
        if (pSDCMSPlatformBase.isSSHIPAddrDirty() && (bl || pSDCMSPlatformBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDCMSPlatformBase.getSSHIPAddr());
        }
        if (pSDCMSPlatformBase.isSSHPortDirty() && (bl || pSDCMSPlatformBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDCMSPlatformBase.getSSHPort());
        }
        if (pSDCMSPlatformBase.isUpdateDateDirty() && (bl || pSDCMSPlatformBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMSPlatformBase.getUpdateDate());
        }
        if (pSDCMSPlatformBase.isUpdateManDirty() && (bl || pSDCMSPlatformBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMSPlatformBase.getUpdateMan());
        }
        if (pSDCMSPlatformBase.isUploadFileModeDirty() && (bl || pSDCMSPlatformBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDCMSPlatformBase.getUploadFileMode());
        }
        if (pSDCMSPlatformBase.isUploadPathDirty() && (bl || pSDCMSPlatformBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDCMSPlatformBase.getUploadPath());
        }
        if (pSDCMSPlatformBase.isUserNameDirty() && (bl || pSDCMSPlatformBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCMSPlatformBase.getUserName());
        }
        if (pSDCMSPlatformBase.isUserParamsDirty() && (bl || pSDCMSPlatformBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDCMSPlatformBase.getUserParams());
        }
        if (pSDCMSPlatformBase.isUserTagDirty() && (bl || pSDCMSPlatformBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCMSPlatformBase.getUserTag());
        }
        if (pSDCMSPlatformBase.isUserTag2Dirty() && (bl || pSDCMSPlatformBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCMSPlatformBase.getUserTag2());
        }
        if (pSDCMSPlatformBase.isUserTag3Dirty() && (bl || pSDCMSPlatformBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCMSPlatformBase.getUserTag3());
        }
        if (pSDCMSPlatformBase.isUserTag4Dirty() && (bl || pSDCMSPlatformBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCMSPlatformBase.getUserTag4());
        }
        if (pSDCMSPlatformBase.isValidFlagDirty() && (bl || pSDCMSPlatformBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCMSPlatformBase.getValidFlag());
        }
        if (pSDCMSPlatformBase.isWebConsolePathDirty() && (bl || pSDCMSPlatformBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSDCMSPlatformBase.getWebConsolePath());
        }
        if (pSDCMSPlatformBase.isWorkshopPathDirty() && (bl || pSDCMSPlatformBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDCMSPlatformBase.getWorkshopPath());
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
        return PSDCMSPlatformBase.remove(this, n);
    }

    private static boolean remove(PSDCMSPlatformBase pSDCMSPlatformBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMSPlatformBase.resetAdminPasswd();
                return true;
            }
            case 1: {
                pSDCMSPlatformBase.resetAdminUserName();
                return true;
            }
            case 2: {
                pSDCMSPlatformBase.resetCfgServiceUrl();
                return true;
            }
            case 3: {
                pSDCMSPlatformBase.resetClusterNamespace();
                return true;
            }
            case 4: {
                pSDCMSPlatformBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDCMSPlatformBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDCMSPlatformBase.resetExpriedTime();
                return true;
            }
            case 7: {
                pSDCMSPlatformBase.resetIpAddr();
                return true;
            }
            case 8: {
                pSDCMSPlatformBase.resetIpAddr2();
                return true;
            }
            case 9: {
                pSDCMSPlatformBase.resetMemo();
                return true;
            }
            case 10: {
                pSDCMSPlatformBase.resetMSType();
                return true;
            }
            case 11: {
                pSDCMSPlatformBase.resetPasswd();
                return true;
            }
            case 12: {
                pSDCMSPlatformBase.resetPort();
                return true;
            }
            case 13: {
                pSDCMSPlatformBase.resetPSDCClusterId();
                return true;
            }
            case 14: {
                pSDCMSPlatformBase.resetPSDCClusterName();
                return true;
            }
            case 15: {
                pSDCMSPlatformBase.resetPSDCContainerSpecId();
                return true;
            }
            case 16: {
                pSDCMSPlatformBase.resetPSDCContainerSpecName();
                return true;
            }
            case 17: {
                pSDCMSPlatformBase.resetPSDCDeployCenterId();
                return true;
            }
            case 18: {
                pSDCMSPlatformBase.resetPSDCDeployCenterName();
                return true;
            }
            case 19: {
                pSDCMSPlatformBase.resetPSDCFileId();
                return true;
            }
            case 20: {
                pSDCMSPlatformBase.resetPSDCFileName();
                return true;
            }
            case 21: {
                pSDCMSPlatformBase.resetPSDCMSPlatformId();
                return true;
            }
            case 22: {
                pSDCMSPlatformBase.resetPSDCMSPlatformName();
                return true;
            }
            case 23: {
                pSDCMSPlatformBase.resetPSDevCenterId();
                return true;
            }
            case 24: {
                pSDCMSPlatformBase.resetPSDevCenterName();
                return true;
            }
            case 25: {
                pSDCMSPlatformBase.resetPSDevSlnId();
                return true;
            }
            case 26: {
                pSDCMSPlatformBase.resetPSDevSlnName();
                return true;
            }
            case 27: {
                pSDCMSPlatformBase.resetPSMSPlatformId();
                return true;
            }
            case 28: {
                pSDCMSPlatformBase.resetPSMSPlatformName();
                return true;
            }
            case 29: {
                pSDCMSPlatformBase.resetRefCount();
                return true;
            }
            case 30: {
                pSDCMSPlatformBase.resetResPos();
                return true;
            }
            case 31: {
                pSDCMSPlatformBase.resetResReadyTime();
                return true;
            }
            case 32: {
                pSDCMSPlatformBase.resetResState();
                return true;
            }
            case 33: {
                pSDCMSPlatformBase.resetResVer();
                return true;
            }
            case 34: {
                pSDCMSPlatformBase.resetServiceUrl();
                return true;
            }
            case 35: {
                pSDCMSPlatformBase.resetSSHIPAddr();
                return true;
            }
            case 36: {
                pSDCMSPlatformBase.resetSSHPort();
                return true;
            }
            case 37: {
                pSDCMSPlatformBase.resetUpdateDate();
                return true;
            }
            case 38: {
                pSDCMSPlatformBase.resetUpdateMan();
                return true;
            }
            case 39: {
                pSDCMSPlatformBase.resetUploadFileMode();
                return true;
            }
            case 40: {
                pSDCMSPlatformBase.resetUploadPath();
                return true;
            }
            case 41: {
                pSDCMSPlatformBase.resetUserName();
                return true;
            }
            case 42: {
                pSDCMSPlatformBase.resetUserParams();
                return true;
            }
            case 43: {
                pSDCMSPlatformBase.resetUserTag();
                return true;
            }
            case 44: {
                pSDCMSPlatformBase.resetUserTag2();
                return true;
            }
            case 45: {
                pSDCMSPlatformBase.resetUserTag3();
                return true;
            }
            case 46: {
                pSDCMSPlatformBase.resetUserTag4();
                return true;
            }
            case 47: {
                pSDCMSPlatformBase.resetValidFlag();
                return true;
            }
            case 48: {
                pSDCMSPlatformBase.resetWebConsolePath();
                return true;
            }
            case 49: {
                pSDCMSPlatformBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCluster getPSDCCluster() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCluster();
        }
        if (this.getPSDCClusterId() == null) {
            return null;
        }
        Integer n = this.objPSDCClusterLock;
        synchronized (n) {
            if (this.psdccluster != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCClusterId(), (Object)this.psdccluster.getPSDCClusterId()) != 0L) {
                this.psdccluster = null;
            }
            if (this.psdccluster == null) {
                PSDCCluster pSDCCluster = new PSDCCluster();
                pSDCCluster.setPSDCClusterId(this.getPSDCClusterId());
                PSDCClusterService pSDCClusterService = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
                pSDCClusterService.autoGet((IEntity)pSDCCluster);
                this.psdccluster = pSDCCluster;
            }
            return this.psdccluster;
        }
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
    public PSDCDeployCenter getPSDCDeployCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenter();
        }
        if (this.getPSDCDeployCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDCDeployCenterLock;
        synchronized (n) {
            if (this.psdcdeploycenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDeployCenterId(), (Object)this.psdcdeploycenter.getPSDCDeployCenterId()) != 0L) {
                this.psdcdeploycenter = null;
            }
            if (this.psdcdeploycenter == null) {
                PSDCDeployCenter pSDCDeployCenter = new PSDCDeployCenter();
                pSDCDeployCenter.setPSDCDeployCenterId(this.getPSDCDeployCenterId());
                PSDCDeployCenterService pSDCDeployCenterService = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDCDeployCenterService.autoGet((IEntity)pSDCDeployCenter);
                this.psdcdeploycenter = pSDCDeployCenter;
            }
            return this.psdcdeploycenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCFile getPSDCFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFile();
        }
        if (this.getPSDCFileId() == null) {
            return null;
        }
        Integer n = this.objPSDCFileLock;
        synchronized (n) {
            if (this.psdcfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCFileId(), (Object)this.psdcfile.getPSDCFileId()) != 0L) {
                this.psdcfile = null;
            }
            if (this.psdcfile == null) {
                PSDCFile pSDCFile = new PSDCFile();
                pSDCFile.setPSDCFileId(this.getPSDCFileId());
                PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
                pSDCFileService.autoGet((IEntity)pSDCFile);
                this.psdcfile = pSDCFile;
            }
            return this.psdcfile;
        }
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
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMSPlatform getPSMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatform();
        }
        if (this.getPSMSPlatformId() == null) {
            return null;
        }
        Integer n = this.objPSMSPlatformLock;
        synchronized (n) {
            if (this.psmsplatform != null && DataTypeHelper.compare((int)25, (Object)this.getPSMSPlatformId(), (Object)this.psmsplatform.getPSMSPlatformId()) != 0L) {
                this.psmsplatform = null;
            }
            if (this.psmsplatform == null) {
                PSMSPlatform pSMSPlatform = new PSMSPlatform();
                pSMSPlatform.setPSMSPlatformId(this.getPSMSPlatformId());
                PSMSPlatformService pSMSPlatformService = (PSMSPlatformService)ServiceGlobal.getService(PSMSPlatformService.class, (SessionFactory)this.getSessionFactory());
                pSMSPlatformService.autoGet((IEntity)pSMSPlatform);
                this.psmsplatform = pSMSPlatform;
            }
            return this.psmsplatform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCMSPlatformFunc> getPSDCMSPlatformFuncs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformFuncs();
        }
        if (this.getPSDCMSPlatformId() == null) {
            return null;
        }
        PSDCMSPlatformFuncService pSDCMSPlatformFuncService = (PSDCMSPlatformFuncService)ServiceGlobal.getService(PSDCMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCMSPlatformFuncsLock;
        synchronized (n) {
            if (this.psdcmsplatformfuncs == null) {
                this.psdcmsplatformfuncs = pSDCMSPlatformFuncService.selectByPSDCMSPlatform(this);
            }
            return this.psdcmsplatformfuncs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCMSPlatformNode> getPSDCMSPlatformNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNodes();
        }
        if (this.getPSDCMSPlatformId() == null) {
            return null;
        }
        PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCMSPlatformNodesLock;
        synchronized (n) {
            if (this.psdcmsplatformnodes == null) {
                this.psdcmsplatformnodes = pSDCMSPlatformNodeService.selectByPSDCMSPlatform(this);
            }
            return this.psdcmsplatformnodes;
        }
    }

    private PSDCMSPlatformBase getProxyEntity() {
        return this.proxyPSDCMSPlatformBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMSPlatformBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMSPlatformBase) {
            this.proxyPSDCMSPlatformBase = (PSDCMSPlatformBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPASSWD, 0);
        fieldIndexMap.put(FIELD_ADMINUSERNAME, 1);
        fieldIndexMap.put(FIELD_CFGSERVICEURL, 2);
        fieldIndexMap.put(FIELD_CLUSTERNAMESPACE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 6);
        fieldIndexMap.put(FIELD_IPADDR, 7);
        fieldIndexMap.put(FIELD_IPADDR2, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_MSTYPE, 10);
        fieldIndexMap.put(FIELD_PASSWD, 11);
        fieldIndexMap.put(FIELD_PORT, 12);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 13);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 14);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 15);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 16);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERID, 17);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERNAME, 18);
        fieldIndexMap.put(FIELD_PSDCFILEID, 19);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 20);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 21);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 23);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 25);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 26);
        fieldIndexMap.put(FIELD_PSMSPLATFORMID, 27);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNAME, 28);
        fieldIndexMap.put(FIELD_REFCOUNT, 29);
        fieldIndexMap.put(FIELD_RESPOS, 30);
        fieldIndexMap.put(FIELD_RESREADYTIME, 31);
        fieldIndexMap.put(FIELD_RESSTATE, 32);
        fieldIndexMap.put(FIELD_RESVER, 33);
        fieldIndexMap.put(FIELD_SERVICEURL, 34);
        fieldIndexMap.put(FIELD_SSHIPADDR, 35);
        fieldIndexMap.put(FIELD_SSHPORT, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 39);
        fieldIndexMap.put(FIELD_UPLOADPATH, 40);
        fieldIndexMap.put(FIELD_USERNAME, 41);
        fieldIndexMap.put(FIELD_USERPARAMS, 42);
        fieldIndexMap.put(FIELD_USERTAG, 43);
        fieldIndexMap.put(FIELD_USERTAG2, 44);
        fieldIndexMap.put(FIELD_USERTAG3, 45);
        fieldIndexMap.put(FIELD_USERTAG4, 46);
        fieldIndexMap.put(FIELD_VALIDFLAG, 47);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 48);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 49);
    }
}

