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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCredential;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRegistryRepo;
import net.ibizsys.pscore.srv.paasmgr.service.PSCredentialService;
import net.ibizsys.pscore.srv.paasmgr.service.PSRegistryRepoService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRegistryRepoBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCRegistryRepoBase.class);
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PSCREDENTIALID = "PSCREDENTIALID";
    public static final String FIELD_PSCREDENTIALNAME = "PSCREDENTIALNAME";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDCREGISTRYREPOID = "PSDCREGISTRYREPOID";
    public static final String FIELD_PSDCREGISTRYREPONAME = "PSDCREGISTRYREPONAME";
    public static final String FIELD_PSDCREGISTRYSERVERID = "PSDCREGISTRYSERVERID";
    public static final String FIELD_PSDCREGISTRYSERVERNAME = "PSDCREGISTRYSERVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSREGISTRYREPOID = "PSREGISTRYREPOID";
    public static final String FIELD_PSREGISTRYREPONAME = "PSREGISTRYREPONAME";
    public static final String FIELD_REGISTRYPASSWD = "REGISTRYPASSWD";
    public static final String FIELD_REGISTRYTYPE = "REGISTRYTYPE";
    public static final String FIELD_REGISTRYUSERNAME = "REGISTRYUSERNAME";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_ROPASSWD = "ROPASSWD";
    public static final String FIELD_ROPSCREDENTIALID = "ROPSCREDENTIALID";
    public static final String FIELD_ROPSCREDENTIALNAME = "ROPSCREDENTIALNAME";
    public static final String FIELD_ROUSERNAME = "ROUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONNSTR = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PARAM = 5;
    private static final int INDEX_PARAM2 = 6;
    private static final int INDEX_PARAM3 = 7;
    private static final int INDEX_PARAM4 = 8;
    private static final int INDEX_PSCREDENTIALID = 9;
    private static final int INDEX_PSCREDENTIALNAME = 10;
    private static final int INDEX_PSDCCLUSTERID = 11;
    private static final int INDEX_PSDCCLUSTERNAME = 12;
    private static final int INDEX_PSDCCONTAINERSPECID = 13;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 14;
    private static final int INDEX_PSDCFILEID = 15;
    private static final int INDEX_PSDCFILENAME = 16;
    private static final int INDEX_PSDCREGISTRYREPOID = 17;
    private static final int INDEX_PSDCREGISTRYREPONAME = 18;
    private static final int INDEX_PSDCREGISTRYSERVERID = 19;
    private static final int INDEX_PSDCREGISTRYSERVERNAME = 20;
    private static final int INDEX_PSDEVCENTERID = 21;
    private static final int INDEX_PSDEVCENTERNAME = 22;
    private static final int INDEX_PSDEVSLNID = 23;
    private static final int INDEX_PSDEVSLNNAME = 24;
    private static final int INDEX_PSREGISTRYREPOID = 25;
    private static final int INDEX_PSREGISTRYREPONAME = 26;
    private static final int INDEX_REGISTRYPASSWD = 27;
    private static final int INDEX_REGISTRYTYPE = 28;
    private static final int INDEX_REGISTRYUSERNAME = 29;
    private static final int INDEX_RESPOS = 30;
    private static final int INDEX_RESSTATE = 31;
    private static final int INDEX_ROPASSWD = 32;
    private static final int INDEX_ROPSCREDENTIALID = 33;
    private static final int INDEX_ROPSCREDENTIALNAME = 34;
    private static final int INDEX_ROUSERNAME = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERTAG = 38;
    private static final int INDEX_USERTAG2 = 39;
    private static final int INDEX_USERTAG3 = 40;
    private static final int INDEX_USERTAG4 = 41;
    private static final int INDEX_VALIDFLAG = 42;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCRegistryRepoBase proxyPSDCRegistryRepoBase = null;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean pscredentialidDirtyFlag = false;
    private boolean pscredentialnameDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdcregistryrepoidDirtyFlag = false;
    private boolean psdcregistryreponameDirtyFlag = false;
    private boolean psdcregistryserveridDirtyFlag = false;
    private boolean psdcregistryservernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psregistryrepoidDirtyFlag = false;
    private boolean psregistryreponameDirtyFlag = false;
    private boolean registrypasswdDirtyFlag = false;
    private boolean registrytypeDirtyFlag = false;
    private boolean registryusernameDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean ropasswdDirtyFlag = false;
    private boolean ropscredentialidDirtyFlag = false;
    private boolean ropscredentialnameDirtyFlag = false;
    private boolean rousernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
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
    @Column(name="pscredentialid")
    private String pscredentialid;
    @Column(name="pscredentialname")
    private String pscredentialname;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdcregistryrepoid")
    private String psdcregistryrepoid;
    @Column(name="psdcregistryreponame")
    private String psdcregistryreponame;
    @Column(name="psdcregistryserverid")
    private String psdcregistryserverid;
    @Column(name="psdcregistryservername")
    private String psdcregistryservername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psregistryrepoid")
    private String psregistryrepoid;
    @Column(name="psregistryreponame")
    private String psregistryreponame;
    @Column(name="registrypasswd")
    private String registrypasswd;
    @Column(name="registrytype")
    private String registrytype;
    @Column(name="registryusername")
    private String registryusername;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="ropasswd")
    private String ropasswd;
    @Column(name="ropscredentialid")
    private String ropscredentialid;
    @Column(name="ropscredentialname")
    private String ropscredentialname;
    @Column(name="rousername")
    private String rousername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
    private Integer objPSCredentialLock = new Integer(1);
    private PSCredential pscredential = null;
    private Integer objROPSCredentialLock = new Integer(1);
    private PSCredential ropscredential = null;
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDCRegistryServerLock = new Integer(1);
    private PSDCRegistryServer psdcregistryserver = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSRegistryRepoLock = new Integer(1);
    private PSRegistryRepo psregistryrepo = null;
    private Integer objPSDCRegistryItemsLock = new Integer(1);
    private ArrayList<PSDCRegistryItem> psdcregistryitems = null;

    public void setConnStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstr = string;
        this.connstrDirtyFlag = true;
    }

    public String getConnStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStr();
        }
        return this.connstr;
    }

    public boolean isConnStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrDirty();
        }
        return this.connstrDirtyFlag;
    }

    public void resetConnStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStr();
            return;
        }
        this.connstrDirtyFlag = false;
        this.connstr = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
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

    public void setPSDCRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryrepoid = string;
        this.psdcregistryrepoidDirtyFlag = true;
    }

    public String getPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoId();
        }
        return this.psdcregistryrepoid;
    }

    public boolean isPSDCRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoIdDirty();
        }
        return this.psdcregistryrepoidDirtyFlag;
    }

    public void resetPSDCRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoId();
            return;
        }
        this.psdcregistryrepoidDirtyFlag = false;
        this.psdcregistryrepoid = null;
    }

    public void setPSDCRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryreponame = string;
        this.psdcregistryreponameDirtyFlag = true;
    }

    public String getPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepoName();
        }
        return this.psdcregistryreponame;
    }

    public boolean isPSDCRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryRepoNameDirty();
        }
        return this.psdcregistryreponameDirtyFlag;
    }

    public void resetPSDCRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryRepoName();
            return;
        }
        this.psdcregistryreponameDirtyFlag = false;
        this.psdcregistryreponame = null;
    }

    public void setPSDCRegistryServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryserverid = string;
        this.psdcregistryserveridDirtyFlag = true;
    }

    public String getPSDCRegistryServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryServerId();
        }
        return this.psdcregistryserverid;
    }

    public boolean isPSDCRegistryServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryServerIdDirty();
        }
        return this.psdcregistryserveridDirtyFlag;
    }

    public void resetPSDCRegistryServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryServerId();
            return;
        }
        this.psdcregistryserveridDirtyFlag = false;
        this.psdcregistryserverid = null;
    }

    public void setPSDCRegistryServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryservername = string;
        this.psdcregistryservernameDirtyFlag = true;
    }

    public String getPSDCRegistryServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryServerName();
        }
        return this.psdcregistryservername;
    }

    public boolean isPSDCRegistryServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryServerNameDirty();
        }
        return this.psdcregistryservernameDirtyFlag;
    }

    public void resetPSDCRegistryServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryServerName();
            return;
        }
        this.psdcregistryservernameDirtyFlag = false;
        this.psdcregistryservername = null;
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

    public void setPSRegistryRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryrepoid = string;
        this.psregistryrepoidDirtyFlag = true;
    }

    public String getPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoId();
        }
        return this.psregistryrepoid;
    }

    public boolean isPSRegistryRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoIdDirty();
        }
        return this.psregistryrepoidDirtyFlag;
    }

    public void resetPSRegistryRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoId();
            return;
        }
        this.psregistryrepoidDirtyFlag = false;
        this.psregistryrepoid = null;
    }

    public void setPSRegistryRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRegistryRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psregistryreponame = string;
        this.psregistryreponameDirtyFlag = true;
    }

    public String getPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepoName();
        }
        return this.psregistryreponame;
    }

    public boolean isPSRegistryRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRegistryRepoNameDirty();
        }
        return this.psregistryreponameDirtyFlag;
    }

    public void resetPSRegistryRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRegistryRepoName();
            return;
        }
        this.psregistryreponameDirtyFlag = false;
        this.psregistryreponame = null;
    }

    public void setRegistryPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registrypasswd = string;
        this.registrypasswdDirtyFlag = true;
    }

    public String getRegistryPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryPasswd();
        }
        return this.registrypasswd;
    }

    public boolean isRegistryPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryPasswdDirty();
        }
        return this.registrypasswdDirtyFlag;
    }

    public void resetRegistryPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryPasswd();
            return;
        }
        this.registrypasswdDirtyFlag = false;
        this.registrypasswd = null;
    }

    public void setRegistryType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registrytype = string;
        this.registrytypeDirtyFlag = true;
    }

    public String getRegistryType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryType();
        }
        return this.registrytype;
    }

    public boolean isRegistryTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryTypeDirty();
        }
        return this.registrytypeDirtyFlag;
    }

    public void resetRegistryType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryType();
            return;
        }
        this.registrytypeDirtyFlag = false;
        this.registrytype = null;
    }

    public void setRegistryUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.registryusername = string;
        this.registryusernameDirtyFlag = true;
    }

    public String getRegistryUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryUserName();
        }
        return this.registryusername;
    }

    public boolean isRegistryUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryUserNameDirty();
        }
        return this.registryusernameDirtyFlag;
    }

    public void resetRegistryUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryUserName();
            return;
        }
        this.registryusernameDirtyFlag = false;
        this.registryusername = null;
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

    public void setROPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropasswd = string;
        this.ropasswdDirtyFlag = true;
    }

    public String getROPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPasswd();
        }
        return this.ropasswd;
    }

    public boolean isROPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPasswdDirty();
        }
        return this.ropasswdDirtyFlag;
    }

    public void resetROPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPasswd();
            return;
        }
        this.ropasswdDirtyFlag = false;
        this.ropasswd = null;
    }

    public void setROPSCredentialId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSCredentialId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropscredentialid = string;
        this.ropscredentialidDirtyFlag = true;
    }

    public String getROPSCredentialId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSCredentialId();
        }
        return this.ropscredentialid;
    }

    public boolean isROPSCredentialIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSCredentialIdDirty();
        }
        return this.ropscredentialidDirtyFlag;
    }

    public void resetROPSCredentialId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSCredentialId();
            return;
        }
        this.ropscredentialidDirtyFlag = false;
        this.ropscredentialid = null;
    }

    public void setROPSCredentialName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSCredentialName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropscredentialname = string;
        this.ropscredentialnameDirtyFlag = true;
    }

    public String getROPSCredentialName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSCredentialName();
        }
        return this.ropscredentialname;
    }

    public boolean isROPSCredentialNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSCredentialNameDirty();
        }
        return this.ropscredentialnameDirtyFlag;
    }

    public void resetROPSCredentialName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSCredentialName();
            return;
        }
        this.ropscredentialnameDirtyFlag = false;
        this.ropscredentialname = null;
    }

    public void setROUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rousername = string;
        this.rousernameDirtyFlag = true;
    }

    public String getROUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROUserName();
        }
        return this.rousername;
    }

    public boolean isROUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROUserNameDirty();
        }
        return this.rousernameDirtyFlag;
    }

    public void resetROUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROUserName();
            return;
        }
        this.rousernameDirtyFlag = false;
        this.rousername = null;
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

    protected void onReset() {
        PSDCRegistryRepoBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCRegistryRepoBase pSDCRegistryRepoBase) {
        pSDCRegistryRepoBase.resetConnStr();
        pSDCRegistryRepoBase.resetCreateDate();
        pSDCRegistryRepoBase.resetCreateMan();
        pSDCRegistryRepoBase.resetDefaultFlag();
        pSDCRegistryRepoBase.resetMemo();
        pSDCRegistryRepoBase.resetParam();
        pSDCRegistryRepoBase.resetParam2();
        pSDCRegistryRepoBase.resetParam3();
        pSDCRegistryRepoBase.resetParam4();
        pSDCRegistryRepoBase.resetPSCredentialId();
        pSDCRegistryRepoBase.resetPSCredentialName();
        pSDCRegistryRepoBase.resetPSDCClusterId();
        pSDCRegistryRepoBase.resetPSDCClusterName();
        pSDCRegistryRepoBase.resetPSDCContainerSpecId();
        pSDCRegistryRepoBase.resetPSDCContainerSpecName();
        pSDCRegistryRepoBase.resetPSDCFileId();
        pSDCRegistryRepoBase.resetPSDCFileName();
        pSDCRegistryRepoBase.resetPSDCRegistryRepoId();
        pSDCRegistryRepoBase.resetPSDCRegistryRepoName();
        pSDCRegistryRepoBase.resetPSDCRegistryServerId();
        pSDCRegistryRepoBase.resetPSDCRegistryServerName();
        pSDCRegistryRepoBase.resetPSDevCenterId();
        pSDCRegistryRepoBase.resetPSDevCenterName();
        pSDCRegistryRepoBase.resetPSDevSlnId();
        pSDCRegistryRepoBase.resetPSDevSlnName();
        pSDCRegistryRepoBase.resetPSRegistryRepoId();
        pSDCRegistryRepoBase.resetPSRegistryRepoName();
        pSDCRegistryRepoBase.resetRegistryPasswd();
        pSDCRegistryRepoBase.resetRegistryType();
        pSDCRegistryRepoBase.resetRegistryUserName();
        pSDCRegistryRepoBase.resetResPos();
        pSDCRegistryRepoBase.resetResState();
        pSDCRegistryRepoBase.resetROPasswd();
        pSDCRegistryRepoBase.resetROPSCredentialId();
        pSDCRegistryRepoBase.resetROPSCredentialName();
        pSDCRegistryRepoBase.resetROUserName();
        pSDCRegistryRepoBase.resetUpdateDate();
        pSDCRegistryRepoBase.resetUpdateMan();
        pSDCRegistryRepoBase.resetUserTag();
        pSDCRegistryRepoBase.resetUserTag2();
        pSDCRegistryRepoBase.resetUserTag3();
        pSDCRegistryRepoBase.resetUserTag4();
        pSDCRegistryRepoBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
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
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDCRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPOID, this.getPSDCRegistryRepoId());
        }
        if (!bl || this.isPSDCRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYREPONAME, this.getPSDCRegistryRepoName());
        }
        if (!bl || this.isPSDCRegistryServerIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYSERVERID, this.getPSDCRegistryServerId());
        }
        if (!bl || this.isPSDCRegistryServerNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYSERVERNAME, this.getPSDCRegistryServerName());
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
        if (!bl || this.isPSRegistryRepoIdDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPOID, this.getPSRegistryRepoId());
        }
        if (!bl || this.isPSRegistryRepoNameDirty()) {
            hashMap.put(FIELD_PSREGISTRYREPONAME, this.getPSRegistryRepoName());
        }
        if (!bl || this.isRegistryPasswdDirty()) {
            hashMap.put(FIELD_REGISTRYPASSWD, this.getRegistryPasswd());
        }
        if (!bl || this.isRegistryTypeDirty()) {
            hashMap.put(FIELD_REGISTRYTYPE, this.getRegistryType());
        }
        if (!bl || this.isRegistryUserNameDirty()) {
            hashMap.put(FIELD_REGISTRYUSERNAME, this.getRegistryUserName());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isROPasswdDirty()) {
            hashMap.put(FIELD_ROPASSWD, this.getROPasswd());
        }
        if (!bl || this.isROPSCredentialIdDirty()) {
            hashMap.put(FIELD_ROPSCREDENTIALID, this.getROPSCredentialId());
        }
        if (!bl || this.isROPSCredentialNameDirty()) {
            hashMap.put(FIELD_ROPSCREDENTIALNAME, this.getROPSCredentialName());
        }
        if (!bl || this.isROUserNameDirty()) {
            hashMap.put(FIELD_ROUSERNAME, this.getROUserName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDCRegistryRepoBase.get(this, n);
    }

    private static Object get(PSDCRegistryRepoBase pSDCRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryRepoBase.getConnStr();
            }
            case 1: {
                return pSDCRegistryRepoBase.getCreateDate();
            }
            case 2: {
                return pSDCRegistryRepoBase.getCreateMan();
            }
            case 3: {
                return pSDCRegistryRepoBase.getDefaultFlag();
            }
            case 4: {
                return pSDCRegistryRepoBase.getMemo();
            }
            case 5: {
                return pSDCRegistryRepoBase.getParam();
            }
            case 6: {
                return pSDCRegistryRepoBase.getParam2();
            }
            case 7: {
                return pSDCRegistryRepoBase.getParam3();
            }
            case 8: {
                return pSDCRegistryRepoBase.getParam4();
            }
            case 9: {
                return pSDCRegistryRepoBase.getPSCredentialId();
            }
            case 10: {
                return pSDCRegistryRepoBase.getPSCredentialName();
            }
            case 11: {
                return pSDCRegistryRepoBase.getPSDCClusterId();
            }
            case 12: {
                return pSDCRegistryRepoBase.getPSDCClusterName();
            }
            case 13: {
                return pSDCRegistryRepoBase.getPSDCContainerSpecId();
            }
            case 14: {
                return pSDCRegistryRepoBase.getPSDCContainerSpecName();
            }
            case 15: {
                return pSDCRegistryRepoBase.getPSDCFileId();
            }
            case 16: {
                return pSDCRegistryRepoBase.getPSDCFileName();
            }
            case 17: {
                return pSDCRegistryRepoBase.getPSDCRegistryRepoId();
            }
            case 18: {
                return pSDCRegistryRepoBase.getPSDCRegistryRepoName();
            }
            case 19: {
                return pSDCRegistryRepoBase.getPSDCRegistryServerId();
            }
            case 20: {
                return pSDCRegistryRepoBase.getPSDCRegistryServerName();
            }
            case 21: {
                return pSDCRegistryRepoBase.getPSDevCenterId();
            }
            case 22: {
                return pSDCRegistryRepoBase.getPSDevCenterName();
            }
            case 23: {
                return pSDCRegistryRepoBase.getPSDevSlnId();
            }
            case 24: {
                return pSDCRegistryRepoBase.getPSDevSlnName();
            }
            case 25: {
                return pSDCRegistryRepoBase.getPSRegistryRepoId();
            }
            case 26: {
                return pSDCRegistryRepoBase.getPSRegistryRepoName();
            }
            case 27: {
                return pSDCRegistryRepoBase.getRegistryPasswd();
            }
            case 28: {
                return pSDCRegistryRepoBase.getRegistryType();
            }
            case 29: {
                return pSDCRegistryRepoBase.getRegistryUserName();
            }
            case 30: {
                return pSDCRegistryRepoBase.getResPos();
            }
            case 31: {
                return pSDCRegistryRepoBase.getResState();
            }
            case 32: {
                return pSDCRegistryRepoBase.getROPasswd();
            }
            case 33: {
                return pSDCRegistryRepoBase.getROPSCredentialId();
            }
            case 34: {
                return pSDCRegistryRepoBase.getROPSCredentialName();
            }
            case 35: {
                return pSDCRegistryRepoBase.getROUserName();
            }
            case 36: {
                return pSDCRegistryRepoBase.getUpdateDate();
            }
            case 37: {
                return pSDCRegistryRepoBase.getUpdateMan();
            }
            case 38: {
                return pSDCRegistryRepoBase.getUserTag();
            }
            case 39: {
                return pSDCRegistryRepoBase.getUserTag2();
            }
            case 40: {
                return pSDCRegistryRepoBase.getUserTag3();
            }
            case 41: {
                return pSDCRegistryRepoBase.getUserTag4();
            }
            case 42: {
                return pSDCRegistryRepoBase.getValidFlag();
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
        PSDCRegistryRepoBase.set(this, n, object);
    }

    private static void set(PSDCRegistryRepoBase pSDCRegistryRepoBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCRegistryRepoBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCRegistryRepoBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCRegistryRepoBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCRegistryRepoBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCRegistryRepoBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCRegistryRepoBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCRegistryRepoBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCRegistryRepoBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCRegistryRepoBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCRegistryRepoBase.setPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCRegistryRepoBase.setPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCRegistryRepoBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCRegistryRepoBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCRegistryRepoBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCRegistryRepoBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCRegistryRepoBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCRegistryRepoBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCRegistryRepoBase.setPSDCRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCRegistryRepoBase.setPSDCRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCRegistryRepoBase.setPSDCRegistryServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCRegistryRepoBase.setPSDCRegistryServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCRegistryRepoBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCRegistryRepoBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCRegistryRepoBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCRegistryRepoBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCRegistryRepoBase.setPSRegistryRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCRegistryRepoBase.setPSRegistryRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCRegistryRepoBase.setRegistryPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCRegistryRepoBase.setRegistryType(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCRegistryRepoBase.setRegistryUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCRegistryRepoBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDCRegistryRepoBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDCRegistryRepoBase.setROPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCRegistryRepoBase.setROPSCredentialId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDCRegistryRepoBase.setROPSCredentialName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDCRegistryRepoBase.setROUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDCRegistryRepoBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDCRegistryRepoBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDCRegistryRepoBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDCRegistryRepoBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDCRegistryRepoBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDCRegistryRepoBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDCRegistryRepoBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCRegistryRepoBase.isNull(this, n);
    }

    private static boolean isNull(PSDCRegistryRepoBase pSDCRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryRepoBase.getConnStr() == null;
            }
            case 1: {
                return pSDCRegistryRepoBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCRegistryRepoBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCRegistryRepoBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSDCRegistryRepoBase.getMemo() == null;
            }
            case 5: {
                return pSDCRegistryRepoBase.getParam() == null;
            }
            case 6: {
                return pSDCRegistryRepoBase.getParam2() == null;
            }
            case 7: {
                return pSDCRegistryRepoBase.getParam3() == null;
            }
            case 8: {
                return pSDCRegistryRepoBase.getParam4() == null;
            }
            case 9: {
                return pSDCRegistryRepoBase.getPSCredentialId() == null;
            }
            case 10: {
                return pSDCRegistryRepoBase.getPSCredentialName() == null;
            }
            case 11: {
                return pSDCRegistryRepoBase.getPSDCClusterId() == null;
            }
            case 12: {
                return pSDCRegistryRepoBase.getPSDCClusterName() == null;
            }
            case 13: {
                return pSDCRegistryRepoBase.getPSDCContainerSpecId() == null;
            }
            case 14: {
                return pSDCRegistryRepoBase.getPSDCContainerSpecName() == null;
            }
            case 15: {
                return pSDCRegistryRepoBase.getPSDCFileId() == null;
            }
            case 16: {
                return pSDCRegistryRepoBase.getPSDCFileName() == null;
            }
            case 17: {
                return pSDCRegistryRepoBase.getPSDCRegistryRepoId() == null;
            }
            case 18: {
                return pSDCRegistryRepoBase.getPSDCRegistryRepoName() == null;
            }
            case 19: {
                return pSDCRegistryRepoBase.getPSDCRegistryServerId() == null;
            }
            case 20: {
                return pSDCRegistryRepoBase.getPSDCRegistryServerName() == null;
            }
            case 21: {
                return pSDCRegistryRepoBase.getPSDevCenterId() == null;
            }
            case 22: {
                return pSDCRegistryRepoBase.getPSDevCenterName() == null;
            }
            case 23: {
                return pSDCRegistryRepoBase.getPSDevSlnId() == null;
            }
            case 24: {
                return pSDCRegistryRepoBase.getPSDevSlnName() == null;
            }
            case 25: {
                return pSDCRegistryRepoBase.getPSRegistryRepoId() == null;
            }
            case 26: {
                return pSDCRegistryRepoBase.getPSRegistryRepoName() == null;
            }
            case 27: {
                return pSDCRegistryRepoBase.getRegistryPasswd() == null;
            }
            case 28: {
                return pSDCRegistryRepoBase.getRegistryType() == null;
            }
            case 29: {
                return pSDCRegistryRepoBase.getRegistryUserName() == null;
            }
            case 30: {
                return pSDCRegistryRepoBase.getResPos() == null;
            }
            case 31: {
                return pSDCRegistryRepoBase.getResState() == null;
            }
            case 32: {
                return pSDCRegistryRepoBase.getROPasswd() == null;
            }
            case 33: {
                return pSDCRegistryRepoBase.getROPSCredentialId() == null;
            }
            case 34: {
                return pSDCRegistryRepoBase.getROPSCredentialName() == null;
            }
            case 35: {
                return pSDCRegistryRepoBase.getROUserName() == null;
            }
            case 36: {
                return pSDCRegistryRepoBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDCRegistryRepoBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDCRegistryRepoBase.getUserTag() == null;
            }
            case 39: {
                return pSDCRegistryRepoBase.getUserTag2() == null;
            }
            case 40: {
                return pSDCRegistryRepoBase.getUserTag3() == null;
            }
            case 41: {
                return pSDCRegistryRepoBase.getUserTag4() == null;
            }
            case 42: {
                return pSDCRegistryRepoBase.getValidFlag() == null;
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
        return PSDCRegistryRepoBase.contains(this, n);
    }

    private static boolean contains(PSDCRegistryRepoBase pSDCRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRegistryRepoBase.isConnStrDirty();
            }
            case 1: {
                return pSDCRegistryRepoBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCRegistryRepoBase.isCreateManDirty();
            }
            case 3: {
                return pSDCRegistryRepoBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSDCRegistryRepoBase.isMemoDirty();
            }
            case 5: {
                return pSDCRegistryRepoBase.isParamDirty();
            }
            case 6: {
                return pSDCRegistryRepoBase.isParam2Dirty();
            }
            case 7: {
                return pSDCRegistryRepoBase.isParam3Dirty();
            }
            case 8: {
                return pSDCRegistryRepoBase.isParam4Dirty();
            }
            case 9: {
                return pSDCRegistryRepoBase.isPSCredentialIdDirty();
            }
            case 10: {
                return pSDCRegistryRepoBase.isPSCredentialNameDirty();
            }
            case 11: {
                return pSDCRegistryRepoBase.isPSDCClusterIdDirty();
            }
            case 12: {
                return pSDCRegistryRepoBase.isPSDCClusterNameDirty();
            }
            case 13: {
                return pSDCRegistryRepoBase.isPSDCContainerSpecIdDirty();
            }
            case 14: {
                return pSDCRegistryRepoBase.isPSDCContainerSpecNameDirty();
            }
            case 15: {
                return pSDCRegistryRepoBase.isPSDCFileIdDirty();
            }
            case 16: {
                return pSDCRegistryRepoBase.isPSDCFileNameDirty();
            }
            case 17: {
                return pSDCRegistryRepoBase.isPSDCRegistryRepoIdDirty();
            }
            case 18: {
                return pSDCRegistryRepoBase.isPSDCRegistryRepoNameDirty();
            }
            case 19: {
                return pSDCRegistryRepoBase.isPSDCRegistryServerIdDirty();
            }
            case 20: {
                return pSDCRegistryRepoBase.isPSDCRegistryServerNameDirty();
            }
            case 21: {
                return pSDCRegistryRepoBase.isPSDevCenterIdDirty();
            }
            case 22: {
                return pSDCRegistryRepoBase.isPSDevCenterNameDirty();
            }
            case 23: {
                return pSDCRegistryRepoBase.isPSDevSlnIdDirty();
            }
            case 24: {
                return pSDCRegistryRepoBase.isPSDevSlnNameDirty();
            }
            case 25: {
                return pSDCRegistryRepoBase.isPSRegistryRepoIdDirty();
            }
            case 26: {
                return pSDCRegistryRepoBase.isPSRegistryRepoNameDirty();
            }
            case 27: {
                return pSDCRegistryRepoBase.isRegistryPasswdDirty();
            }
            case 28: {
                return pSDCRegistryRepoBase.isRegistryTypeDirty();
            }
            case 29: {
                return pSDCRegistryRepoBase.isRegistryUserNameDirty();
            }
            case 30: {
                return pSDCRegistryRepoBase.isResPosDirty();
            }
            case 31: {
                return pSDCRegistryRepoBase.isResStateDirty();
            }
            case 32: {
                return pSDCRegistryRepoBase.isROPasswdDirty();
            }
            case 33: {
                return pSDCRegistryRepoBase.isROPSCredentialIdDirty();
            }
            case 34: {
                return pSDCRegistryRepoBase.isROPSCredentialNameDirty();
            }
            case 35: {
                return pSDCRegistryRepoBase.isROUserNameDirty();
            }
            case 36: {
                return pSDCRegistryRepoBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDCRegistryRepoBase.isUpdateManDirty();
            }
            case 38: {
                return pSDCRegistryRepoBase.isUserTagDirty();
            }
            case 39: {
                return pSDCRegistryRepoBase.isUserTag2Dirty();
            }
            case 40: {
                return pSDCRegistryRepoBase.isUserTag3Dirty();
            }
            case 41: {
                return pSDCRegistryRepoBase.isUserTag4Dirty();
            }
            case 42: {
                return pSDCRegistryRepoBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCRegistryRepoBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCRegistryRepoBase pSDCRegistryRepoBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCRegistryRepoBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getParam()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getParam2()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getParam3()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getParam4()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSCredentialId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscredentialname", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSCredentialName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryrepoid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCRegistryRepoId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryreponame", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCRegistryRepoName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryserverid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCRegistryServerId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryservername", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDCRegistryServerName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSRegistryRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryrepoid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSRegistryRepoId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getPSRegistryRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psregistryreponame", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getPSRegistryRepoName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getRegistryPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registrypasswd", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getRegistryPasswd()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getRegistryType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registrytype", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getRegistryType()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getRegistryUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"registryusername", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getRegistryUserName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getResPos()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getResState()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getROPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropasswd", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getROPasswd()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getROPSCredentialId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropscredentialid", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getROPSCredentialId()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getROPSCredentialName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropscredentialname", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getROPSCredentialName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getROUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rousername", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getROUserName()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCRegistryRepoBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCRegistryRepoBase.getJSONValue((Object)pSDCRegistryRepoBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCRegistryRepoBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCRegistryRepoBase pSDCRegistryRepoBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCRegistryRepoBase.getConnStr() != null) {
            object = pSDCRegistryRepoBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getCreateDate() != null) {
            object = pSDCRegistryRepoBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRegistryRepoBase.getCreateMan() != null) {
            object = pSDCRegistryRepoBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getDefaultFlag() != null) {
            object = pSDCRegistryRepoBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRegistryRepoBase.getMemo() != null) {
            object = pSDCRegistryRepoBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getParam() != null) {
            object = pSDCRegistryRepoBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getParam2() != null) {
            object = pSDCRegistryRepoBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getParam3() != null) {
            object = pSDCRegistryRepoBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getParam4() != null) {
            object = pSDCRegistryRepoBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSCredentialId() != null) {
            object = pSDCRegistryRepoBase.getPSCredentialId();
            xmlNode.setAttribute(FIELD_PSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSCredentialName() != null) {
            object = pSDCRegistryRepoBase.getPSCredentialName();
            xmlNode.setAttribute(FIELD_PSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCClusterId() != null) {
            object = pSDCRegistryRepoBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCClusterName() != null) {
            object = pSDCRegistryRepoBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCContainerSpecId() != null) {
            object = pSDCRegistryRepoBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCContainerSpecName() != null) {
            object = pSDCRegistryRepoBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCFileId() != null) {
            object = pSDCRegistryRepoBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCFileName() != null) {
            object = pSDCRegistryRepoBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryRepoId() != null) {
            object = pSDCRegistryRepoBase.getPSDCRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryRepoName() != null) {
            object = pSDCRegistryRepoBase.getPSDCRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryServerId() != null) {
            object = pSDCRegistryRepoBase.getPSDCRegistryServerId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDCRegistryServerName() != null) {
            object = pSDCRegistryRepoBase.getPSDCRegistryServerName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevCenterId() != null) {
            object = pSDCRegistryRepoBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevCenterName() != null) {
            object = pSDCRegistryRepoBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevSlnId() != null) {
            object = pSDCRegistryRepoBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSDevSlnName() != null) {
            object = pSDCRegistryRepoBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSRegistryRepoId() != null) {
            object = pSDCRegistryRepoBase.getPSRegistryRepoId();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getPSRegistryRepoName() != null) {
            object = pSDCRegistryRepoBase.getPSRegistryRepoName();
            xmlNode.setAttribute(FIELD_PSREGISTRYREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getRegistryPasswd() != null) {
            object = pSDCRegistryRepoBase.getRegistryPasswd();
            xmlNode.setAttribute(FIELD_REGISTRYPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getRegistryType() != null) {
            object = pSDCRegistryRepoBase.getRegistryType();
            xmlNode.setAttribute(FIELD_REGISTRYTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getRegistryUserName() != null) {
            object = pSDCRegistryRepoBase.getRegistryUserName();
            xmlNode.setAttribute(FIELD_REGISTRYUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getResPos() != null) {
            object = pSDCRegistryRepoBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRegistryRepoBase.getResState() != null) {
            object = pSDCRegistryRepoBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRegistryRepoBase.getROPasswd() != null) {
            object = pSDCRegistryRepoBase.getROPasswd();
            xmlNode.setAttribute(FIELD_ROPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getROPSCredentialId() != null) {
            object = pSDCRegistryRepoBase.getROPSCredentialId();
            xmlNode.setAttribute(FIELD_ROPSCREDENTIALID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getROPSCredentialName() != null) {
            object = pSDCRegistryRepoBase.getROPSCredentialName();
            xmlNode.setAttribute(FIELD_ROPSCREDENTIALNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getROUserName() != null) {
            object = pSDCRegistryRepoBase.getROUserName();
            xmlNode.setAttribute(FIELD_ROUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getUpdateDate() != null) {
            object = pSDCRegistryRepoBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRegistryRepoBase.getUpdateMan() != null) {
            object = pSDCRegistryRepoBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag() != null) {
            object = pSDCRegistryRepoBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag2() != null) {
            object = pSDCRegistryRepoBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag3() != null) {
            object = pSDCRegistryRepoBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getUserTag4() != null) {
            object = pSDCRegistryRepoBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCRegistryRepoBase.getValidFlag() != null) {
            object = pSDCRegistryRepoBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCRegistryRepoBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCRegistryRepoBase pSDCRegistryRepoBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCRegistryRepoBase.isConnStrDirty() && (bl || pSDCRegistryRepoBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDCRegistryRepoBase.getConnStr());
        }
        if (pSDCRegistryRepoBase.isCreateDateDirty() && (bl || pSDCRegistryRepoBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCRegistryRepoBase.getCreateDate());
        }
        if (pSDCRegistryRepoBase.isCreateManDirty() && (bl || pSDCRegistryRepoBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCRegistryRepoBase.getCreateMan());
        }
        if (pSDCRegistryRepoBase.isDefaultFlagDirty() && (bl || pSDCRegistryRepoBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDCRegistryRepoBase.getDefaultFlag());
        }
        if (pSDCRegistryRepoBase.isMemoDirty() && (bl || pSDCRegistryRepoBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCRegistryRepoBase.getMemo());
        }
        if (pSDCRegistryRepoBase.isParamDirty() && (bl || pSDCRegistryRepoBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDCRegistryRepoBase.getParam());
        }
        if (pSDCRegistryRepoBase.isParam2Dirty() && (bl || pSDCRegistryRepoBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDCRegistryRepoBase.getParam2());
        }
        if (pSDCRegistryRepoBase.isParam3Dirty() && (bl || pSDCRegistryRepoBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDCRegistryRepoBase.getParam3());
        }
        if (pSDCRegistryRepoBase.isParam4Dirty() && (bl || pSDCRegistryRepoBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDCRegistryRepoBase.getParam4());
        }
        if (pSDCRegistryRepoBase.isPSCredentialIdDirty() && (bl || pSDCRegistryRepoBase.getPSCredentialId() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALID, (Object)pSDCRegistryRepoBase.getPSCredentialId());
        }
        if (pSDCRegistryRepoBase.isPSCredentialNameDirty() && (bl || pSDCRegistryRepoBase.getPSCredentialName() != null)) {
            iDataObject.set(FIELD_PSCREDENTIALNAME, (Object)pSDCRegistryRepoBase.getPSCredentialName());
        }
        if (pSDCRegistryRepoBase.isPSDCClusterIdDirty() && (bl || pSDCRegistryRepoBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDCRegistryRepoBase.getPSDCClusterId());
        }
        if (pSDCRegistryRepoBase.isPSDCClusterNameDirty() && (bl || pSDCRegistryRepoBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDCRegistryRepoBase.getPSDCClusterName());
        }
        if (pSDCRegistryRepoBase.isPSDCContainerSpecIdDirty() && (bl || pSDCRegistryRepoBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDCRegistryRepoBase.getPSDCContainerSpecId());
        }
        if (pSDCRegistryRepoBase.isPSDCContainerSpecNameDirty() && (bl || pSDCRegistryRepoBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDCRegistryRepoBase.getPSDCContainerSpecName());
        }
        if (pSDCRegistryRepoBase.isPSDCFileIdDirty() && (bl || pSDCRegistryRepoBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDCRegistryRepoBase.getPSDCFileId());
        }
        if (pSDCRegistryRepoBase.isPSDCFileNameDirty() && (bl || pSDCRegistryRepoBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDCRegistryRepoBase.getPSDCFileName());
        }
        if (pSDCRegistryRepoBase.isPSDCRegistryRepoIdDirty() && (bl || pSDCRegistryRepoBase.getPSDCRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPOID, (Object)pSDCRegistryRepoBase.getPSDCRegistryRepoId());
        }
        if (pSDCRegistryRepoBase.isPSDCRegistryRepoNameDirty() && (bl || pSDCRegistryRepoBase.getPSDCRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYREPONAME, (Object)pSDCRegistryRepoBase.getPSDCRegistryRepoName());
        }
        if (pSDCRegistryRepoBase.isPSDCRegistryServerIdDirty() && (bl || pSDCRegistryRepoBase.getPSDCRegistryServerId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYSERVERID, (Object)pSDCRegistryRepoBase.getPSDCRegistryServerId());
        }
        if (pSDCRegistryRepoBase.isPSDCRegistryServerNameDirty() && (bl || pSDCRegistryRepoBase.getPSDCRegistryServerName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYSERVERNAME, (Object)pSDCRegistryRepoBase.getPSDCRegistryServerName());
        }
        if (pSDCRegistryRepoBase.isPSDevCenterIdDirty() && (bl || pSDCRegistryRepoBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCRegistryRepoBase.getPSDevCenterId());
        }
        if (pSDCRegistryRepoBase.isPSDevCenterNameDirty() && (bl || pSDCRegistryRepoBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCRegistryRepoBase.getPSDevCenterName());
        }
        if (pSDCRegistryRepoBase.isPSDevSlnIdDirty() && (bl || pSDCRegistryRepoBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCRegistryRepoBase.getPSDevSlnId());
        }
        if (pSDCRegistryRepoBase.isPSDevSlnNameDirty() && (bl || pSDCRegistryRepoBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCRegistryRepoBase.getPSDevSlnName());
        }
        if (pSDCRegistryRepoBase.isPSRegistryRepoIdDirty() && (bl || pSDCRegistryRepoBase.getPSRegistryRepoId() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPOID, (Object)pSDCRegistryRepoBase.getPSRegistryRepoId());
        }
        if (pSDCRegistryRepoBase.isPSRegistryRepoNameDirty() && (bl || pSDCRegistryRepoBase.getPSRegistryRepoName() != null)) {
            iDataObject.set(FIELD_PSREGISTRYREPONAME, (Object)pSDCRegistryRepoBase.getPSRegistryRepoName());
        }
        if (pSDCRegistryRepoBase.isRegistryPasswdDirty() && (bl || pSDCRegistryRepoBase.getRegistryPasswd() != null)) {
            iDataObject.set(FIELD_REGISTRYPASSWD, (Object)pSDCRegistryRepoBase.getRegistryPasswd());
        }
        if (pSDCRegistryRepoBase.isRegistryTypeDirty() && (bl || pSDCRegistryRepoBase.getRegistryType() != null)) {
            iDataObject.set(FIELD_REGISTRYTYPE, (Object)pSDCRegistryRepoBase.getRegistryType());
        }
        if (pSDCRegistryRepoBase.isRegistryUserNameDirty() && (bl || pSDCRegistryRepoBase.getRegistryUserName() != null)) {
            iDataObject.set(FIELD_REGISTRYUSERNAME, (Object)pSDCRegistryRepoBase.getRegistryUserName());
        }
        if (pSDCRegistryRepoBase.isResPosDirty() && (bl || pSDCRegistryRepoBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDCRegistryRepoBase.getResPos());
        }
        if (pSDCRegistryRepoBase.isResStateDirty() && (bl || pSDCRegistryRepoBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCRegistryRepoBase.getResState());
        }
        if (pSDCRegistryRepoBase.isROPasswdDirty() && (bl || pSDCRegistryRepoBase.getROPasswd() != null)) {
            iDataObject.set(FIELD_ROPASSWD, (Object)pSDCRegistryRepoBase.getROPasswd());
        }
        if (pSDCRegistryRepoBase.isROPSCredentialIdDirty() && (bl || pSDCRegistryRepoBase.getROPSCredentialId() != null)) {
            iDataObject.set(FIELD_ROPSCREDENTIALID, (Object)pSDCRegistryRepoBase.getROPSCredentialId());
        }
        if (pSDCRegistryRepoBase.isROPSCredentialNameDirty() && (bl || pSDCRegistryRepoBase.getROPSCredentialName() != null)) {
            iDataObject.set(FIELD_ROPSCREDENTIALNAME, (Object)pSDCRegistryRepoBase.getROPSCredentialName());
        }
        if (pSDCRegistryRepoBase.isROUserNameDirty() && (bl || pSDCRegistryRepoBase.getROUserName() != null)) {
            iDataObject.set(FIELD_ROUSERNAME, (Object)pSDCRegistryRepoBase.getROUserName());
        }
        if (pSDCRegistryRepoBase.isUpdateDateDirty() && (bl || pSDCRegistryRepoBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCRegistryRepoBase.getUpdateDate());
        }
        if (pSDCRegistryRepoBase.isUpdateManDirty() && (bl || pSDCRegistryRepoBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCRegistryRepoBase.getUpdateMan());
        }
        if (pSDCRegistryRepoBase.isUserTagDirty() && (bl || pSDCRegistryRepoBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCRegistryRepoBase.getUserTag());
        }
        if (pSDCRegistryRepoBase.isUserTag2Dirty() && (bl || pSDCRegistryRepoBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCRegistryRepoBase.getUserTag2());
        }
        if (pSDCRegistryRepoBase.isUserTag3Dirty() && (bl || pSDCRegistryRepoBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCRegistryRepoBase.getUserTag3());
        }
        if (pSDCRegistryRepoBase.isUserTag4Dirty() && (bl || pSDCRegistryRepoBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCRegistryRepoBase.getUserTag4());
        }
        if (pSDCRegistryRepoBase.isValidFlagDirty() && (bl || pSDCRegistryRepoBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCRegistryRepoBase.getValidFlag());
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
        return PSDCRegistryRepoBase.remove(this, n);
    }

    private static boolean remove(PSDCRegistryRepoBase pSDCRegistryRepoBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCRegistryRepoBase.resetConnStr();
                return true;
            }
            case 1: {
                pSDCRegistryRepoBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCRegistryRepoBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCRegistryRepoBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSDCRegistryRepoBase.resetMemo();
                return true;
            }
            case 5: {
                pSDCRegistryRepoBase.resetParam();
                return true;
            }
            case 6: {
                pSDCRegistryRepoBase.resetParam2();
                return true;
            }
            case 7: {
                pSDCRegistryRepoBase.resetParam3();
                return true;
            }
            case 8: {
                pSDCRegistryRepoBase.resetParam4();
                return true;
            }
            case 9: {
                pSDCRegistryRepoBase.resetPSCredentialId();
                return true;
            }
            case 10: {
                pSDCRegistryRepoBase.resetPSCredentialName();
                return true;
            }
            case 11: {
                pSDCRegistryRepoBase.resetPSDCClusterId();
                return true;
            }
            case 12: {
                pSDCRegistryRepoBase.resetPSDCClusterName();
                return true;
            }
            case 13: {
                pSDCRegistryRepoBase.resetPSDCContainerSpecId();
                return true;
            }
            case 14: {
                pSDCRegistryRepoBase.resetPSDCContainerSpecName();
                return true;
            }
            case 15: {
                pSDCRegistryRepoBase.resetPSDCFileId();
                return true;
            }
            case 16: {
                pSDCRegistryRepoBase.resetPSDCFileName();
                return true;
            }
            case 17: {
                pSDCRegistryRepoBase.resetPSDCRegistryRepoId();
                return true;
            }
            case 18: {
                pSDCRegistryRepoBase.resetPSDCRegistryRepoName();
                return true;
            }
            case 19: {
                pSDCRegistryRepoBase.resetPSDCRegistryServerId();
                return true;
            }
            case 20: {
                pSDCRegistryRepoBase.resetPSDCRegistryServerName();
                return true;
            }
            case 21: {
                pSDCRegistryRepoBase.resetPSDevCenterId();
                return true;
            }
            case 22: {
                pSDCRegistryRepoBase.resetPSDevCenterName();
                return true;
            }
            case 23: {
                pSDCRegistryRepoBase.resetPSDevSlnId();
                return true;
            }
            case 24: {
                pSDCRegistryRepoBase.resetPSDevSlnName();
                return true;
            }
            case 25: {
                pSDCRegistryRepoBase.resetPSRegistryRepoId();
                return true;
            }
            case 26: {
                pSDCRegistryRepoBase.resetPSRegistryRepoName();
                return true;
            }
            case 27: {
                pSDCRegistryRepoBase.resetRegistryPasswd();
                return true;
            }
            case 28: {
                pSDCRegistryRepoBase.resetRegistryType();
                return true;
            }
            case 29: {
                pSDCRegistryRepoBase.resetRegistryUserName();
                return true;
            }
            case 30: {
                pSDCRegistryRepoBase.resetResPos();
                return true;
            }
            case 31: {
                pSDCRegistryRepoBase.resetResState();
                return true;
            }
            case 32: {
                pSDCRegistryRepoBase.resetROPasswd();
                return true;
            }
            case 33: {
                pSDCRegistryRepoBase.resetROPSCredentialId();
                return true;
            }
            case 34: {
                pSDCRegistryRepoBase.resetROPSCredentialName();
                return true;
            }
            case 35: {
                pSDCRegistryRepoBase.resetROUserName();
                return true;
            }
            case 36: {
                pSDCRegistryRepoBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDCRegistryRepoBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDCRegistryRepoBase.resetUserTag();
                return true;
            }
            case 39: {
                pSDCRegistryRepoBase.resetUserTag2();
                return true;
            }
            case 40: {
                pSDCRegistryRepoBase.resetUserTag3();
                return true;
            }
            case 41: {
                pSDCRegistryRepoBase.resetUserTag4();
                return true;
            }
            case 42: {
                pSDCRegistryRepoBase.resetValidFlag();
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
    public PSCredential getROPSCredential() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSCredential();
        }
        if (this.getROPSCredentialId() == null) {
            return null;
        }
        Integer n = this.objROPSCredentialLock;
        synchronized (n) {
            if (this.ropscredential != null && DataTypeHelper.compare((int)25, (Object)this.getROPSCredentialId(), (Object)this.ropscredential.getPSCredentialId()) != 0L) {
                this.ropscredential = null;
            }
            if (this.ropscredential == null) {
                PSCredential pSCredential = new PSCredential();
                pSCredential.setPSCredentialId(this.getROPSCredentialId());
                PSCredentialService pSCredentialService = (PSCredentialService)ServiceGlobal.getService(PSCredentialService.class, (SessionFactory)this.getSessionFactory());
                pSCredentialService.autoGet((IEntity)pSCredential);
                this.ropscredential = pSCredential;
            }
            return this.ropscredential;
        }
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
    public PSDCRegistryServer getPSDCRegistryServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryServer();
        }
        if (this.getPSDCRegistryServerId() == null) {
            return null;
        }
        Integer n = this.objPSDCRegistryServerLock;
        synchronized (n) {
            if (this.psdcregistryserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRegistryServerId(), (Object)this.psdcregistryserver.getPSDCRegistryServerId()) != 0L) {
                this.psdcregistryserver = null;
            }
            if (this.psdcregistryserver == null) {
                PSDCRegistryServer pSDCRegistryServer = new PSDCRegistryServer();
                pSDCRegistryServer.setPSDCRegistryServerId(this.getPSDCRegistryServerId());
                PSDCRegistryServerService pSDCRegistryServerService = (PSDCRegistryServerService)ServiceGlobal.getService(PSDCRegistryServerService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryServerService.autoGet((IEntity)pSDCRegistryServer);
                this.psdcregistryserver = pSDCRegistryServer;
            }
            return this.psdcregistryserver;
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
    public PSRegistryRepo getPSRegistryRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRegistryRepo();
        }
        if (this.getPSRegistryRepoId() == null) {
            return null;
        }
        Integer n = this.objPSRegistryRepoLock;
        synchronized (n) {
            if (this.psregistryrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSRegistryRepoId(), (Object)this.psregistryrepo.getPSRegistryRepoId()) != 0L) {
                this.psregistryrepo = null;
            }
            if (this.psregistryrepo == null) {
                PSRegistryRepo pSRegistryRepo = new PSRegistryRepo();
                pSRegistryRepo.setPSRegistryRepoId(this.getPSRegistryRepoId());
                PSRegistryRepoService pSRegistryRepoService = (PSRegistryRepoService)ServiceGlobal.getService(PSRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
                pSRegistryRepoService.autoGet((IEntity)pSRegistryRepo);
                this.psregistryrepo = pSRegistryRepo;
            }
            return this.psregistryrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCRegistryItem> getPSDCRegistryItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItems();
        }
        if (this.getPSDCRegistryRepoId() == null) {
            return null;
        }
        PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCRegistryItemsLock;
        synchronized (n) {
            if (this.psdcregistryitems == null) {
                this.psdcregistryitems = pSDCRegistryItemService.selectByPSDCRegistryRepo(this);
            }
            return this.psdcregistryitems;
        }
    }

    private PSDCRegistryRepoBase getProxyEntity() {
        return this.proxyPSDCRegistryRepoBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCRegistryRepoBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCRegistryRepoBase) {
            this.proxyPSDCRegistryRepoBase = (PSDCRegistryRepoBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONNSTR, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PARAM, 5);
        fieldIndexMap.put(FIELD_PARAM2, 6);
        fieldIndexMap.put(FIELD_PARAM3, 7);
        fieldIndexMap.put(FIELD_PARAM4, 8);
        fieldIndexMap.put(FIELD_PSCREDENTIALID, 9);
        fieldIndexMap.put(FIELD_PSCREDENTIALNAME, 10);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 11);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 12);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 13);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 14);
        fieldIndexMap.put(FIELD_PSDCFILEID, 15);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 16);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPOID, 17);
        fieldIndexMap.put(FIELD_PSDCREGISTRYREPONAME, 18);
        fieldIndexMap.put(FIELD_PSDCREGISTRYSERVERID, 19);
        fieldIndexMap.put(FIELD_PSDCREGISTRYSERVERNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 24);
        fieldIndexMap.put(FIELD_PSREGISTRYREPOID, 25);
        fieldIndexMap.put(FIELD_PSREGISTRYREPONAME, 26);
        fieldIndexMap.put(FIELD_REGISTRYPASSWD, 27);
        fieldIndexMap.put(FIELD_REGISTRYTYPE, 28);
        fieldIndexMap.put(FIELD_REGISTRYUSERNAME, 29);
        fieldIndexMap.put(FIELD_RESPOS, 30);
        fieldIndexMap.put(FIELD_RESSTATE, 31);
        fieldIndexMap.put(FIELD_ROPASSWD, 32);
        fieldIndexMap.put(FIELD_ROPSCREDENTIALID, 33);
        fieldIndexMap.put(FIELD_ROPSCREDENTIALNAME, 34);
        fieldIndexMap.put(FIELD_ROUSERNAME, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERTAG, 38);
        fieldIndexMap.put(FIELD_USERTAG2, 39);
        fieldIndexMap.put(FIELD_USERTAG3, 40);
        fieldIndexMap.put(FIELD_USERTAG4, 41);
        fieldIndexMap.put(FIELD_VALIDFLAG, 42);
    }
}

