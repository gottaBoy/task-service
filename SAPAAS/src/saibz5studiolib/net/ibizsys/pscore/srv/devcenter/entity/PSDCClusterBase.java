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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCClusterBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCClusterBase.class);
    public static final String FIELD_CLUSTERCFG = "CLUSTERCFG";
    public static final String FIELD_CLUSTERPARAMS = "CLUSTERPARAMS";
    public static final String FIELD_CLUSTERTYPE = "CLUSTERTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREDENTIALSYNCMODE = "CREDENTIALSYNCMODE";
    public static final String FIELD_DOMAINNAME = "DOMAINNAME";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PSCREDENTIALID = "PSCREDENTIALID";
    public static final String FIELD_PSCREDENTIALNAME = "PSCREDENTIALNAME";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_URL = "URL";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CLUSTERCFG = 0;
    private static final int INDEX_CLUSTERPARAMS = 1;
    private static final int INDEX_CLUSTERTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CREDENTIALSYNCMODE = 5;
    private static final int INDEX_DOMAINNAME = 6;
    private static final int INDEX_EXPRIEDTIME = 7;
    private static final int INDEX_IPADDR = 8;
    private static final int INDEX_IPADDR2 = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PARAM = 11;
    private static final int INDEX_PARAM2 = 12;
    private static final int INDEX_PARAM3 = 13;
    private static final int INDEX_PARAM4 = 14;
    private static final int INDEX_PORT = 15;
    private static final int INDEX_PSCREDENTIALID = 16;
    private static final int INDEX_PSCREDENTIALNAME = 17;
    private static final int INDEX_PSDCCLUSTERID = 18;
    private static final int INDEX_PSDCCLUSTERNAME = 19;
    private static final int INDEX_PSDEVCENTERID = 20;
    private static final int INDEX_PSDEVCENTERNAME = 21;
    private static final int INDEX_RESPOS = 22;
    private static final int INDEX_RESREADYTIME = 23;
    private static final int INDEX_RESSTATE = 24;
    private static final int INDEX_RESVER = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_URL = 28;
    private static final int INDEX_USERNAME = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCClusterBase proxyPSDCClusterBase = null;
    private boolean clustercfgDirtyFlag = false;
    private boolean clusterparamsDirtyFlag = false;
    private boolean clustertypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean credentialsyncmodeDirtyFlag = false;
    private boolean domainnameDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean pscredentialidDirtyFlag = false;
    private boolean pscredentialnameDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean urlDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="clustercfg")
    private String clustercfg;
    @Column(name="clusterparams")
    private String clusterparams;
    @Column(name="clustertype")
    private String clustertype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="credentialsyncmode")
    private Integer credentialsyncmode;
    @Column(name="domainname")
    private String domainname;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="port")
    private Integer port;
    @Column(name="pscredentialid")
    private String pscredentialid;
    @Column(name="pscredentialname")
    private String pscredentialname;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="url")
    private String url;
    @Column(name="username")
    private String username;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSCredentialLock = new Integer(1);
    private PSCredential pscredential = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setClusterCfg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClusterCfg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clustercfg = string;
        this.clustercfgDirtyFlag = true;
    }

    public String getClusterCfg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClusterCfg();
        }
        return this.clustercfg;
    }

    public boolean isClusterCfgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClusterCfgDirty();
        }
        return this.clustercfgDirtyFlag;
    }

    public void resetClusterCfg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClusterCfg();
            return;
        }
        this.clustercfgDirtyFlag = false;
        this.clustercfg = null;
    }

    public void setClusterParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClusterParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clusterparams = string;
        this.clusterparamsDirtyFlag = true;
    }

    public String getClusterParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClusterParams();
        }
        return this.clusterparams;
    }

    public boolean isClusterParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClusterParamsDirty();
        }
        return this.clusterparamsDirtyFlag;
    }

    public void resetClusterParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClusterParams();
            return;
        }
        this.clusterparamsDirtyFlag = false;
        this.clusterparams = null;
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

    public void setCredentialSyncMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCredentialSyncMode(n);
            return;
        }
        this.credentialsyncmode = n;
        this.credentialsyncmodeDirtyFlag = true;
    }

    public Integer getCredentialSyncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCredentialSyncMode();
        }
        return this.credentialsyncmode;
    }

    public boolean isCredentialSyncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCredentialSyncModeDirty();
        }
        return this.credentialsyncmodeDirtyFlag;
    }

    public void resetCredentialSyncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCredentialSyncMode();
            return;
        }
        this.credentialsyncmodeDirtyFlag = false;
        this.credentialsyncmode = null;
    }

    public void setDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainname = string;
        this.domainnameDirtyFlag = true;
    }

    public String getDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainName();
        }
        return this.domainname;
    }

    public boolean isDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainNameDirty();
        }
        return this.domainnameDirtyFlag;
    }

    public void resetDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainName();
            return;
        }
        this.domainnameDirtyFlag = false;
        this.domainname = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
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

    public void setPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialid = string;
        this.pscredentialidDirtyFlag = true;
    }

    public String getPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialId();
        }
        return this.pscredentialid;
    }

    public boolean isPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialIdDirty();
        }
        return this.pscredentialidDirtyFlag;
    }

    public void resetPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialId();
            return;
        }
        this.pscredentialidDirtyFlag = false;
        this.pscredentialid = null;
    }

    public void setPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscredentialname = string;
        this.pscredentialnameDirtyFlag = true;
    }

    public String getPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredentialName();
        }
        return this.pscredentialname;
    }

    public boolean isPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCredentialNameDirty();
        }
        return this.pscredentialnameDirtyFlag;
    }

    public void resetPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCredentialName();
            return;
        }
        this.pscredentialnameDirtyFlag = false;
        this.pscredentialname = null;
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

    public void setUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.url = string;
        this.urlDirtyFlag = true;
    }

    public String getUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUrl();
        }
        return this.url;
    }

    public boolean isUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUrlDirty();
        }
        return this.urlDirtyFlag;
    }

    public void resetUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUrl();
            return;
        }
        this.urlDirtyFlag = false;
        this.url = null;
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

    protected void onReset() {
        PSDCClusterBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCClusterBase pSDCClusterBase) {
        pSDCClusterBase.resetClusterCfg();
        pSDCClusterBase.resetClusterParams();
        pSDCClusterBase.resetClusterType();
        pSDCClusterBase.resetCreateDate();
        pSDCClusterBase.resetCreateMan();
        pSDCClusterBase.resetCredentialSyncMode();
        pSDCClusterBase.resetDomainName();
        pSDCClusterBase.resetExpriedTime();
        pSDCClusterBase.resetIpAddr();
        pSDCClusterBase.resetIpAddr2();
        pSDCClusterBase.resetMemo();
        pSDCClusterBase.resetParam();
        pSDCClusterBase.resetParam2();
        pSDCClusterBase.resetParam3();
        pSDCClusterBase.resetParam4();
        pSDCClusterBase.resetPort();
        pSDCClusterBase.resetPSCredentialId();
        pSDCClusterBase.resetPSCredentialName();
        pSDCClusterBase.resetPSDCClusterId();
        pSDCClusterBase.resetPSDCClusterName();
        pSDCClusterBase.resetPSDevCenterId();
        pSDCClusterBase.resetPSDevCenterName();
        pSDCClusterBase.resetResPos();
        pSDCClusterBase.resetResReadyTime();
        pSDCClusterBase.resetResState();
        pSDCClusterBase.resetResVer();
        pSDCClusterBase.resetUpdateDate();
        pSDCClusterBase.resetUpdateMan();
        pSDCClusterBase.resetUrl();
        pSDCClusterBase.resetUserName();
        pSDCClusterBase.resetUserTag();
        pSDCClusterBase.resetUserTag2();
        pSDCClusterBase.resetUserTag3();
        pSDCClusterBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClusterCfgDirty()) {
            hashMap.put(FIELD_CLUSTERCFG, this.getClusterCfg());
        }
        if (!bl || this.isClusterParamsDirty()) {
            hashMap.put(FIELD_CLUSTERPARAMS, this.getClusterParams());
        }
        if (!bl || this.isClusterTypeDirty()) {
            hashMap.put(FIELD_CLUSTERTYPE, this.getClusterType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCredentialSyncModeDirty()) {
            hashMap.put(FIELD_CREDENTIALSYNCMODE, this.getCredentialSyncMode());
        }
        if (!bl || this.isDomainNameDirty()) {
            hashMap.put(FIELD_DOMAINNAME, this.getDomainName());
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
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPSCredentialIdDirty()) {
            hashMap.put(FIELD_PSCREDENTIALID, this.getPSCredentialId());
        }
        if (!bl || this.isPSCredentialNameDirty()) {
            hashMap.put(FIELD_PSCREDENTIALNAME, this.getPSCredentialName());
        }
        if (!bl || this.isPSDCClusterIdDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERID, this.getPSDCClusterId());
        }
        if (!bl || this.isPSDCClusterNameDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERNAME, this.getPSDCClusterName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUrlDirty()) {
            hashMap.put(FIELD_URL, this.getUrl());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSDCClusterBase.get(this, n);
    }

    private static Object get(PSDCClusterBase pSDCClusterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCClusterBase.getClusterCfg();
            }
            case 1: {
                return pSDCClusterBase.getClusterParams();
            }
            case 2: {
                return pSDCClusterBase.getClusterType();
            }
            case 3: {
                return pSDCClusterBase.getCreateDate();
            }
            case 4: {
                return pSDCClusterBase.getCreateMan();
            }
            case 5: {
                return pSDCClusterBase.getCredentialSyncMode();
            }
            case 6: {
                return pSDCClusterBase.getDomainName();
            }
            case 7: {
                return pSDCClusterBase.getExpriedTime();
            }
            case 8: {
                return pSDCClusterBase.getIpAddr();
            }
            case 9: {
                return pSDCClusterBase.getIpAddr2();
            }
            case 10: {
                return pSDCClusterBase.getMemo();
            }
            case 11: {
                return pSDCClusterBase.getParam();
            }
            case 12: {
                return pSDCClusterBase.getParam2();
            }
            case 13: {
                return pSDCClusterBase.getParam3();
            }
            case 14: {
                return pSDCClusterBase.getParam4();
            }
            case 15: {
                return pSDCClusterBase.getPort();
            }
            case 16: {
                return pSDCClusterBase.getPSCredentialId();
            }
            case 17: {
                return pSDCClusterBase.getPSCredentialName();
            }
            case 18: {
                return pSDCClusterBase.getPSDCClusterId();
            }
            case 19: {
                return pSDCClusterBase.getPSDCClusterName();
            }
            case 20: {
                return pSDCClusterBase.getPSDevCenterId();
            }
            case 21: {
                return pSDCClusterBase.getPSDevCenterName();
            }
            case 22: {
                return pSDCClusterBase.getResPos();
            }
            case 23: {
                return pSDCClusterBase.getResReadyTime();
            }
            case 24: {
                return pSDCClusterBase.getResState();
            }
            case 25: {
                return pSDCClusterBase.getResVer();
            }
            case 26: {
                return pSDCClusterBase.getUpdateDate();
            }
            case 27: {
                return pSDCClusterBase.getUpdateMan();
            }
            case 28: {
                return pSDCClusterBase.getUrl();
            }
            case 29: {
                return pSDCClusterBase.getUserName();
            }
            case 30: {
                return pSDCClusterBase.getUserTag();
            }
            case 31: {
                return pSDCClusterBase.getUserTag2();
            }
            case 32: {
                return pSDCClusterBase.getUserTag3();
            }
            case 33: {
                return pSDCClusterBase.getUserTag4();
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
        PSDCClusterBase.set(this, n, object);
    }

    private static void set(PSDCClusterBase pSDCClusterBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCClusterBase.setClusterCfg(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCClusterBase.setClusterParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCClusterBase.setClusterType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCClusterBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCClusterBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCClusterBase.setCredentialSyncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCClusterBase.setDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCClusterBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDCClusterBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCClusterBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCClusterBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCClusterBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCClusterBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCClusterBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCClusterBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCClusterBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDCClusterBase.setPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCClusterBase.setPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCClusterBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCClusterBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCClusterBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCClusterBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCClusterBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDCClusterBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSDCClusterBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDCClusterBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDCClusterBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDCClusterBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCClusterBase.setUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCClusterBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCClusterBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCClusterBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCClusterBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCClusterBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDCClusterBase.isNull(this, n);
    }

    private static boolean isNull(PSDCClusterBase pSDCClusterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCClusterBase.getClusterCfg() == null;
            }
            case 1: {
                return pSDCClusterBase.getClusterParams() == null;
            }
            case 2: {
                return pSDCClusterBase.getClusterType() == null;
            }
            case 3: {
                return pSDCClusterBase.getCreateDate() == null;
            }
            case 4: {
                return pSDCClusterBase.getCreateMan() == null;
            }
            case 5: {
                return pSDCClusterBase.getCredentialSyncMode() == null;
            }
            case 6: {
                return pSDCClusterBase.getDomainName() == null;
            }
            case 7: {
                return pSDCClusterBase.getExpriedTime() == null;
            }
            case 8: {
                return pSDCClusterBase.getIpAddr() == null;
            }
            case 9: {
                return pSDCClusterBase.getIpAddr2() == null;
            }
            case 10: {
                return pSDCClusterBase.getMemo() == null;
            }
            case 11: {
                return pSDCClusterBase.getParam() == null;
            }
            case 12: {
                return pSDCClusterBase.getParam2() == null;
            }
            case 13: {
                return pSDCClusterBase.getParam3() == null;
            }
            case 14: {
                return pSDCClusterBase.getParam4() == null;
            }
            case 15: {
                return pSDCClusterBase.getPort() == null;
            }
            case 16: {
                return pSDCClusterBase.getPSCredentialId() == null;
            }
            case 17: {
                return pSDCClusterBase.getPSCredentialName() == null;
            }
            case 18: {
                return pSDCClusterBase.getPSDCClusterId() == null;
            }
            case 19: {
                return pSDCClusterBase.getPSDCClusterName() == null;
            }
            case 20: {
                return pSDCClusterBase.getPSDevCenterId() == null;
            }
            case 21: {
                return pSDCClusterBase.getPSDevCenterName() == null;
            }
            case 22: {
                return pSDCClusterBase.getResPos() == null;
            }
            case 23: {
                return pSDCClusterBase.getResReadyTime() == null;
            }
            case 24: {
                return pSDCClusterBase.getResState() == null;
            }
            case 25: {
                return pSDCClusterBase.getResVer() == null;
            }
            case 26: {
                return pSDCClusterBase.getUpdateDate() == null;
            }
            case 27: {
                return pSDCClusterBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDCClusterBase.getUrl() == null;
            }
            case 29: {
                return pSDCClusterBase.getUserName() == null;
            }
            case 30: {
                return pSDCClusterBase.getUserTag() == null;
            }
            case 31: {
                return pSDCClusterBase.getUserTag2() == null;
            }
            case 32: {
                return pSDCClusterBase.getUserTag3() == null;
            }
            case 33: {
                return pSDCClusterBase.getUserTag4() == null;
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
        return PSDCClusterBase.contains(this, n);
    }

    private static boolean contains(PSDCClusterBase pSDCClusterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCClusterBase.isClusterCfgDirty();
            }
            case 1: {
                return pSDCClusterBase.isClusterParamsDirty();
            }
            case 2: {
                return pSDCClusterBase.isClusterTypeDirty();
            }
            case 3: {
                return pSDCClusterBase.isCreateDateDirty();
            }
            case 4: {
                return pSDCClusterBase.isCreateManDirty();
            }
            case 5: {
                return pSDCClusterBase.isCredentialSyncModeDirty();
            }
            case 6: {
                return pSDCClusterBase.isDomainNameDirty();
            }
            case 7: {
                return pSDCClusterBase.isExpriedTimeDirty();
            }
            case 8: {
                return pSDCClusterBase.isIpAddrDirty();
            }
            case 9: {
                return pSDCClusterBase.isIpAddr2Dirty();
            }
            case 10: {
                return pSDCClusterBase.isMemoDirty();
            }
            case 11: {
                return pSDCClusterBase.isParamDirty();
            }
            case 12: {
                return pSDCClusterBase.isParam2Dirty();
            }
            case 13: {
                return pSDCClusterBase.isParam3Dirty();
            }
            case 14: {
                return pSDCClusterBase.isParam4Dirty();
            }
            case 15: {
                return pSDCClusterBase.isPortDirty();
            }
            case 16: {
                return pSDCClusterBase.isPSCredentialIdDirty();
            }
            case 17: {
                return pSDCClusterBase.isPSCredentialNameDirty();
            }
            case 18: {
                return pSDCClusterBase.isPSDCClusterIdDirty();
            }
            case 19: {
                return pSDCClusterBase.isPSDCClusterNameDirty();
            }
            case 20: {
                return pSDCClusterBase.isPSDevCenterIdDirty();
            }
            case 21: {
                return pSDCClusterBase.isPSDevCenterNameDirty();
            }
            case 22: {
                return pSDCClusterBase.isResPosDirty();
            }
            case 23: {
                return pSDCClusterBase.isResReadyTimeDirty();
            }
            case 24: {
                return pSDCClusterBase.isResStateDirty();
            }
            case 25: {
                return pSDCClusterBase.isResVerDirty();
            }
            case 26: {
                return pSDCClusterBase.isUpdateDateDirty();
            }
            case 27: {
                return pSDCClusterBase.isUpdateManDirty();
            }
            case 28: {
                return pSDCClusterBase.isUrlDirty();
            }
            case 29: {
                return pSDCClusterBase.isUserNameDirty();
            }
            case 30: {
                return pSDCClusterBase.isUserTagDirty();
            }
            case 31: {
                return pSDCClusterBase.isUserTag2Dirty();
            }
            case 32: {
                return pSDCClusterBase.isUserTag3Dirty();
            }
            case 33: {
                return pSDCClusterBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCClusterBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCClusterBase pSDCClusterBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCClusterBase.getClusterCfg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clustercfg", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getClusterCfg()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getClusterParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clusterparams", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getClusterParams()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getClusterType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clustertype", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getClusterType()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getCredentialSyncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"credentialsyncmode", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getCredentialSyncMode()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainname", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getDomainName()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getParam()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getParam2()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getParam3()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getParam4()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getPort()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialid", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getPSCredentialId()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialname", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getPSCredentialName()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getResState()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getResVer()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"url", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUrl()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCClusterBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCClusterBase.getJSONValue((Object)pSDCClusterBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCClusterBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCClusterBase pSDCClusterBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCClusterBase.getClusterCfg() != null) {
            object = pSDCClusterBase.getClusterCfg();
            xmlNode.setAttribute(FIELD_CLUSTERCFG, (String)(object == null ? "" : object));
        }
        if (bl || pSDCClusterBase.getClusterParams() != null) {
            object = pSDCClusterBase.getClusterParams();
            xmlNode.setAttribute(FIELD_CLUSTERPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSDCClusterBase.getClusterType() != null) {
            object = pSDCClusterBase.getClusterType();
            xmlNode.setAttribute(FIELD_CLUSTERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getCreateDate() != null) {
            object = pSDCClusterBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCClusterBase.getCreateMan() != null) {
            object = pSDCClusterBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getCredentialSyncMode() != null) {
            object = pSDCClusterBase.getCredentialSyncMode();
            xmlNode.setAttribute(FIELD_CREDENTIALSYNCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCClusterBase.getDomainName() != null) {
            object = pSDCClusterBase.getDomainName();
            xmlNode.setAttribute(FIELD_DOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getExpriedTime() != null) {
            object = pSDCClusterBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCClusterBase.getIpAddr() != null) {
            object = pSDCClusterBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getIpAddr2() != null) {
            object = pSDCClusterBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getMemo() != null) {
            object = pSDCClusterBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getParam() != null) {
            object = pSDCClusterBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getParam2() != null) {
            object = pSDCClusterBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getParam3() != null) {
            object = pSDCClusterBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getParam4() != null) {
            object = pSDCClusterBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getPort() != null) {
            object = pSDCClusterBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCClusterBase.getPSCredentialId() != null) {
            object = pSDCClusterBase.getPSCredentialId();
            xmlNode.setAttribute(FIELD_PSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getPSCredentialName() != null) {
            object = pSDCClusterBase.getPSCredentialName();
            xmlNode.setAttribute(FIELD_PSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getPSDCClusterId() != null) {
            object = pSDCClusterBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getPSDCClusterName() != null) {
            object = pSDCClusterBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getPSDevCenterId() != null) {
            object = pSDCClusterBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getPSDevCenterName() != null) {
            object = pSDCClusterBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getResPos() != null) {
            object = pSDCClusterBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCClusterBase.getResReadyTime() != null) {
            object = pSDCClusterBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCClusterBase.getResState() != null) {
            object = pSDCClusterBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCClusterBase.getResVer() != null) {
            object = pSDCClusterBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCClusterBase.getUpdateDate() != null) {
            object = pSDCClusterBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCClusterBase.getUpdateMan() != null) {
            object = pSDCClusterBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getUrl() != null) {
            object = pSDCClusterBase.getUrl();
            xmlNode.setAttribute(FIELD_URL, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getUserName() != null) {
            object = pSDCClusterBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getUserTag() != null) {
            object = pSDCClusterBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getUserTag2() != null) {
            object = pSDCClusterBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getUserTag3() != null) {
            object = pSDCClusterBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCClusterBase.getUserTag4() != null) {
            object = pSDCClusterBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCClusterBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCClusterBase pSDCClusterBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCClusterBase.isClusterCfgDirty() && (bl || pSDCClusterBase.getClusterCfg() != null)) {
            iDataObject.set(FIELD_CLUSTERCFG, (Object)pSDCClusterBase.getClusterCfg());
        }
        if (pSDCClusterBase.isClusterParamsDirty() && (bl || pSDCClusterBase.getClusterParams() != null)) {
            iDataObject.set(FIELD_CLUSTERPARAMS, (Object)pSDCClusterBase.getClusterParams());
        }
        if (pSDCClusterBase.isClusterTypeDirty() && (bl || pSDCClusterBase.getClusterType() != null)) {
            iDataObject.set(FIELD_CLUSTERTYPE, (Object)pSDCClusterBase.getClusterType());
        }
        if (pSDCClusterBase.isCreateDateDirty() && (bl || pSDCClusterBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCClusterBase.getCreateDate());
        }
        if (pSDCClusterBase.isCreateManDirty() && (bl || pSDCClusterBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCClusterBase.getCreateMan());
        }
        if (pSDCClusterBase.isCredentialSyncModeDirty() && (bl || pSDCClusterBase.getCredentialSyncMode() != null)) {
            iDataObject.set(FIELD_CREDENTIALSYNCMODE, (Object)pSDCClusterBase.getCredentialSyncMode());
        }
        if (pSDCClusterBase.isDomainNameDirty() && (bl || pSDCClusterBase.getDomainName() != null)) {
            iDataObject.set(FIELD_DOMAINNAME, (Object)pSDCClusterBase.getDomainName());
        }
        if (pSDCClusterBase.isExpriedTimeDirty() && (bl || pSDCClusterBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDCClusterBase.getExpriedTime());
        }
        if (pSDCClusterBase.isIpAddrDirty() && (bl || pSDCClusterBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCClusterBase.getIpAddr());
        }
        if (pSDCClusterBase.isIpAddr2Dirty() && (bl || pSDCClusterBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCClusterBase.getIpAddr2());
        }
        if (pSDCClusterBase.isMemoDirty() && (bl || pSDCClusterBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCClusterBase.getMemo());
        }
        if (pSDCClusterBase.isParamDirty() && (bl || pSDCClusterBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDCClusterBase.getParam());
        }
        if (pSDCClusterBase.isParam2Dirty() && (bl || pSDCClusterBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDCClusterBase.getParam2());
        }
        if (pSDCClusterBase.isParam3Dirty() && (bl || pSDCClusterBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDCClusterBase.getParam3());
        }
        if (pSDCClusterBase.isParam4Dirty() && (bl || pSDCClusterBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDCClusterBase.getParam4());
        }
        if (pSDCClusterBase.isPortDirty() && (bl || pSDCClusterBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCClusterBase.getPort());
        }
        if (pSDCClusterBase.isPSCredentialIdDirty() && (bl || pSDCClusterBase.getPSCredentialId() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALID, (Object)pSDCClusterBase.getPSCredentialId());
        }
        if (pSDCClusterBase.isPSCredentialNameDirty() && (bl || pSDCClusterBase.getPSCredentialName() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALNAME, (Object)pSDCClusterBase.getPSCredentialName());
        }
        if (pSDCClusterBase.isPSDCClusterIdDirty() && (bl || pSDCClusterBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDCClusterBase.getPSDCClusterId());
        }
        if (pSDCClusterBase.isPSDCClusterNameDirty() && (bl || pSDCClusterBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDCClusterBase.getPSDCClusterName());
        }
        if (pSDCClusterBase.isPSDevCenterIdDirty() && (bl || pSDCClusterBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCClusterBase.getPSDevCenterId());
        }
        if (pSDCClusterBase.isPSDevCenterNameDirty() && (bl || pSDCClusterBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCClusterBase.getPSDevCenterName());
        }
        if (pSDCClusterBase.isResPosDirty() && (bl || pSDCClusterBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCClusterBase.getResPos());
        }
        if (pSDCClusterBase.isResReadyTimeDirty() && (bl || pSDCClusterBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDCClusterBase.getResReadyTime());
        }
        if (pSDCClusterBase.isResStateDirty() && (bl || pSDCClusterBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCClusterBase.getResState());
        }
        if (pSDCClusterBase.isResVerDirty() && (bl || pSDCClusterBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDCClusterBase.getResVer());
        }
        if (pSDCClusterBase.isUpdateDateDirty() && (bl || pSDCClusterBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCClusterBase.getUpdateDate());
        }
        if (pSDCClusterBase.isUpdateManDirty() && (bl || pSDCClusterBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCClusterBase.getUpdateMan());
        }
        if (pSDCClusterBase.isUrlDirty() && (bl || pSDCClusterBase.getUrl() != null)) {
            iDataObject.set(FIELD_URL, (Object)pSDCClusterBase.getUrl());
        }
        if (pSDCClusterBase.isUserNameDirty() && (bl || pSDCClusterBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCClusterBase.getUserName());
        }
        if (pSDCClusterBase.isUserTagDirty() && (bl || pSDCClusterBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCClusterBase.getUserTag());
        }
        if (pSDCClusterBase.isUserTag2Dirty() && (bl || pSDCClusterBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCClusterBase.getUserTag2());
        }
        if (pSDCClusterBase.isUserTag3Dirty() && (bl || pSDCClusterBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCClusterBase.getUserTag3());
        }
        if (pSDCClusterBase.isUserTag4Dirty() && (bl || pSDCClusterBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCClusterBase.getUserTag4());
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
        return PSDCClusterBase.remove(this, n);
    }

    private static boolean remove(PSDCClusterBase pSDCClusterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCClusterBase.resetClusterCfg();
                return true;
            }
            case 1: {
                pSDCClusterBase.resetClusterParams();
                return true;
            }
            case 2: {
                pSDCClusterBase.resetClusterType();
                return true;
            }
            case 3: {
                pSDCClusterBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDCClusterBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDCClusterBase.resetCredentialSyncMode();
                return true;
            }
            case 6: {
                pSDCClusterBase.resetDomainName();
                return true;
            }
            case 7: {
                pSDCClusterBase.resetExpriedTime();
                return true;
            }
            case 8: {
                pSDCClusterBase.resetIpAddr();
                return true;
            }
            case 9: {
                pSDCClusterBase.resetIpAddr2();
                return true;
            }
            case 10: {
                pSDCClusterBase.resetMemo();
                return true;
            }
            case 11: {
                pSDCClusterBase.resetParam();
                return true;
            }
            case 12: {
                pSDCClusterBase.resetParam2();
                return true;
            }
            case 13: {
                pSDCClusterBase.resetParam3();
                return true;
            }
            case 14: {
                pSDCClusterBase.resetParam4();
                return true;
            }
            case 15: {
                pSDCClusterBase.resetPort();
                return true;
            }
            case 16: {
                pSDCClusterBase.resetPSCredentialId();
                return true;
            }
            case 17: {
                pSDCClusterBase.resetPSCredentialName();
                return true;
            }
            case 18: {
                pSDCClusterBase.resetPSDCClusterId();
                return true;
            }
            case 19: {
                pSDCClusterBase.resetPSDCClusterName();
                return true;
            }
            case 20: {
                pSDCClusterBase.resetPSDevCenterId();
                return true;
            }
            case 21: {
                pSDCClusterBase.resetPSDevCenterName();
                return true;
            }
            case 22: {
                pSDCClusterBase.resetResPos();
                return true;
            }
            case 23: {
                pSDCClusterBase.resetResReadyTime();
                return true;
            }
            case 24: {
                pSDCClusterBase.resetResState();
                return true;
            }
            case 25: {
                pSDCClusterBase.resetResVer();
                return true;
            }
            case 26: {
                pSDCClusterBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSDCClusterBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDCClusterBase.resetUrl();
                return true;
            }
            case 29: {
                pSDCClusterBase.resetUserName();
                return true;
            }
            case 30: {
                pSDCClusterBase.resetUserTag();
                return true;
            }
            case 31: {
                pSDCClusterBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSDCClusterBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSDCClusterBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCredential getPSCredential() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCredential();
        }
        if (this.getPSCredentialId() == null) {
            return null;
        }
        Integer n = this.objPSCredentialLock;
        synchronized (n) {
            if (this.pscredential != null && DataTypeHelper.compare((int)25, (Object)this.getPSCredentialId(), (Object)this.pscredential.getPSCredentialId()) != 0L) {
                this.pscredential = null;
            }
            if (this.pscredential == null) {
                PSCredential pSCredential = new PSCredential();
                pSCredential.setPSCredentialId(this.getPSCredentialId());
                PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
                pSCredentialService.autoGet((IEntity)pSCredential);
                this.pscredential = pSCredential;
            }
            return this.pscredential;
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

    private PSDCClusterBase getProxyEntity() {
        return this.proxyPSDCClusterBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCClusterBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCClusterBase) {
            this.proxyPSDCClusterBase = (PSDCClusterBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLUSTERCFG, 0);
        fieldIndexMap.put(FIELD_CLUSTERPARAMS, 1);
        fieldIndexMap.put(FIELD_CLUSTERTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CREDENTIALSYNCMODE, 5);
        fieldIndexMap.put(FIELD_DOMAINNAME, 6);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 7);
        fieldIndexMap.put(FIELD_IPADDR, 8);
        fieldIndexMap.put(FIELD_IPADDR2, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PARAM, 11);
        fieldIndexMap.put(FIELD_PARAM2, 12);
        fieldIndexMap.put(FIELD_PARAM3, 13);
        fieldIndexMap.put(FIELD_PARAM4, 14);
        fieldIndexMap.put(FIELD_PORT, 15);
        fieldIndexMap.put(FIELD_PSCREDENTIALID, 16);
        fieldIndexMap.put(FIELD_PSCREDENTIALNAME, 17);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 18);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 21);
        fieldIndexMap.put(FIELD_RESPOS, 22);
        fieldIndexMap.put(FIELD_RESREADYTIME, 23);
        fieldIndexMap.put(FIELD_RESSTATE, 24);
        fieldIndexMap.put(FIELD_RESVER, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_URL, 28);
        fieldIndexMap.put(FIELD_USERNAME, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

