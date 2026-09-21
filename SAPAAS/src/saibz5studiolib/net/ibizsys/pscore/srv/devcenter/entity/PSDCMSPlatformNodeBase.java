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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformNode;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformNodeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMSPlatformNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMSPlatformNodeBase.class);
    public static final String FIELD_CFGTYPE = "CFGTYPE";
    public static final String FIELD_CONTAINERCFG = "CONTAINERCFG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCREGISTRYITEMTAG = "DCREGISTRYITEMTAG";
    public static final String FIELD_DCREGISTRYITEMTAG2 = "DCREGISTRYITEMTAG2";
    public static final String FIELD_DCREGISTRYITEMTAG3 = "DCREGISTRYITEMTAG3";
    public static final String FIELD_DCREGISTRYITEMTAG4 = "DCREGISTRYITEMTAG4";
    public static final String FIELD_ENVPARAMS = "ENVPARAMS";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MAXCPU = "MAXCPU";
    public static final String FIELD_MAXMEM = "MAXMEN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINCPU = "MINCPU";
    public static final String FIELD_MINMEM = "MINMEN";
    public static final String FIELD_NODEINFO = "NODEINFO";
    public static final String FIELD_NODESTATE = "NODESTATE";
    public static final String FIELD_NODETAG = "NODETAG";
    public static final String FIELD_NODETAG2 = "NODETAG2";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PORT = "PORT";
    public static final String FIELD_PORT2 = "PORT2";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String FIELD_PSDCMSPLATFORMNODEID = "PSDCMSPLATFORMNODEID";
    public static final String FIELD_PSDCMSPLATFORMNODENAME = "PSDCMSPLATFORMNODENAME";
    public static final String FIELD_PSDCREGISTRYITEMID = "PSDCREGISTRYITEMID";
    public static final String FIELD_PSDCREGISTRYITEMNAME = "PSDCREGISTRYITEMNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSMSPLATFORMNODEID = "PSMSPLATFORMNODEID";
    public static final String FIELD_PSMSPLATFORMNODENAME = "PSMSPLATFORMNODENAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_REPLICATED = "REPLICATED";
    public static final String FIELD_SCALE = "SCALE";
    public static final String FIELD_SERVICEID = "SERVICEID";
    public static final String FIELD_SERVICENAME = "SERVICENAME";
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
    public static final String FIELD_WORKSHOPPATH = "WORKSHOPPATH";
    private static final int INDEX_CFGTYPE = 0;
    private static final int INDEX_CONTAINERCFG = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DCREGISTRYITEMTAG = 4;
    private static final int INDEX_DCREGISTRYITEMTAG2 = 5;
    private static final int INDEX_DCREGISTRYITEMTAG3 = 6;
    private static final int INDEX_DCREGISTRYITEMTAG4 = 7;
    private static final int INDEX_ENVPARAMS = 8;
    private static final int INDEX_IPADDR = 9;
    private static final int INDEX_IPADDR2 = 10;
    private static final int INDEX_MAXCPU = 11;
    private static final int INDEX_MAXMEM = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_MINCPU = 14;
    private static final int INDEX_MINMEM = 15;
    private static final int INDEX_NODEINFO = 16;
    private static final int INDEX_NODESTATE = 17;
    private static final int INDEX_NODETAG = 18;
    private static final int INDEX_NODETAG2 = 19;
    private static final int INDEX_PASSWD = 20;
    private static final int INDEX_PORT = 21;
    private static final int INDEX_PORT2 = 22;
    private static final int INDEX_PSDCMSPLATFORMID = 23;
    private static final int INDEX_PSDCMSPLATFORMNAME = 24;
    private static final int INDEX_PSDCMSPLATFORMNODEID = 25;
    private static final int INDEX_PSDCMSPLATFORMNODENAME = 26;
    private static final int INDEX_PSDCREGISTRYITEMID = 27;
    private static final int INDEX_PSDCREGISTRYITEMNAME = 28;
    private static final int INDEX_PSDEVSLNID = 29;
    private static final int INDEX_PSDEVSLNNAME = 30;
    private static final int INDEX_PSMSPLATFORMNODEID = 31;
    private static final int INDEX_PSMSPLATFORMNODENAME = 32;
    private static final int INDEX_REFCOUNT = 33;
    private static final int INDEX_REFINFO = 34;
    private static final int INDEX_REPLICATED = 35;
    private static final int INDEX_SCALE = 36;
    private static final int INDEX_SERVICEID = 37;
    private static final int INDEX_SERVICENAME = 38;
    private static final int INDEX_SERVICEURL = 39;
    private static final int INDEX_SSHIPADDR = 40;
    private static final int INDEX_SSHPORT = 41;
    private static final int INDEX_UPDATEDATE = 42;
    private static final int INDEX_UPDATEMAN = 43;
    private static final int INDEX_UPLOADFILEMODE = 44;
    private static final int INDEX_UPLOADPATH = 45;
    private static final int INDEX_USERNAME = 46;
    private static final int INDEX_USERPARAMS = 47;
    private static final int INDEX_USERTAG = 48;
    private static final int INDEX_USERTAG2 = 49;
    private static final int INDEX_USERTAG3 = 50;
    private static final int INDEX_USERTAG4 = 51;
    private static final int INDEX_VALIDFLAG = 52;
    private static final int INDEX_WORKSHOPPATH = 53;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMSPlatformNodeBase proxyPSDCMSPlatformNodeBase = null;
    private boolean cfgtypeDirtyFlag = false;
    private boolean containercfgDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dcregistryitemtagDirtyFlag = false;
    private boolean dcregistryitemtag2DirtyFlag = false;
    private boolean dcregistryitemtag3DirtyFlag = false;
    private boolean dcregistryitemtag4DirtyFlag = false;
    private boolean envparamsDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean maxcpuDirtyFlag = false;
    private boolean maxmemDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mincpuDirtyFlag = false;
    private boolean minmemDirtyFlag = false;
    private boolean nodeinfoDirtyFlag = false;
    private boolean nodestateDirtyFlag = false;
    private boolean nodetagDirtyFlag = false;
    private boolean nodetag2DirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean portDirtyFlag = false;
    private boolean port2DirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnameDirtyFlag = false;
    private boolean psdcmsplatformnodeidDirtyFlag = false;
    private boolean psdcmsplatformnodenameDirtyFlag = false;
    private boolean psdcregistryitemidDirtyFlag = false;
    private boolean psdcregistryitemnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psmsplatformnodeidDirtyFlag = false;
    private boolean psmsplatformnodenameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean replicatedDirtyFlag = false;
    private boolean scaleDirtyFlag = false;
    private boolean serviceidDirtyFlag = false;
    private boolean servicenameDirtyFlag = false;
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
    private boolean workshoppathDirtyFlag = false;
    @Column(name="cfgtype")
    private String cfgtype;
    @Column(name="containercfg")
    private String containercfg;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dcregistryitemtag")
    private String dcregistryitemtag;
    @Column(name="dcregistryitemtag2")
    private String dcregistryitemtag2;
    @Column(name="dcregistryitemtag3")
    private String dcregistryitemtag3;
    @Column(name="dcregistryitemtag4")
    private String dcregistryitemtag4;
    @Column(name="envparams")
    private String envparams;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="maxcpu")
    private Double maxcpu;
    @Column(name="maxmem")
    private Double maxmem;
    @Column(name="memo")
    private String memo;
    @Column(name="mincpu")
    private Double mincpu;
    @Column(name="minmem")
    private Double minmem;
    @Column(name="nodeinfo")
    private String nodeinfo;
    @Column(name="nodestate")
    private String nodestate;
    @Column(name="nodetag")
    private String nodetag;
    @Column(name="nodetag2")
    private String nodetag2;
    @Column(name="passwd")
    private String passwd;
    @Column(name="port")
    private Integer port;
    @Column(name="port2")
    private Integer port2;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformname")
    private String psdcmsplatformname;
    @Column(name="psdcmsplatformnodeid")
    private String psdcmsplatformnodeid;
    @Column(name="psdcmsplatformnodename")
    private String psdcmsplatformnodename;
    @Column(name="psdcregistryitemid")
    private String psdcregistryitemid;
    @Column(name="psdcregistryitemname")
    private String psdcregistryitemname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psmsplatformnodeid")
    private String psmsplatformnodeid;
    @Column(name="psmsplatformnodename")
    private String psmsplatformnodename;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="replicated")
    private Integer replicated;
    @Column(name="scale")
    private Integer scale;
    @Column(name="serviceid")
    private String serviceid;
    @Column(name="servicename")
    private String servicename;
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
    @Column(name="workshoppath")
    private String workshoppath;
    private Integer objPSDCMSPlatformLock = new Integer(1);
    private PSDCMSPlatform psdcmsplatform = null;
    private Integer objPSDCRegistryItemLock = new Integer(1);
    private PSDCRegistryItem psdcregistryitem = null;
    private Integer objPSMSPlatformNodeLock = new Integer(1);
    private PSMSPlatformNode psmsplatformnode = null;

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

    public void setDCRegistryItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCRegistryItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcregistryitemtag = string;
        this.dcregistryitemtagDirtyFlag = true;
    }

    public String getDCRegistryItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCRegistryItemTag();
        }
        return this.dcregistryitemtag;
    }

    public boolean isDCRegistryItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCRegistryItemTagDirty();
        }
        return this.dcregistryitemtagDirtyFlag;
    }

    public void resetDCRegistryItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCRegistryItemTag();
            return;
        }
        this.dcregistryitemtagDirtyFlag = false;
        this.dcregistryitemtag = null;
    }

    public void setDCRegistryItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCRegistryItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcregistryitemtag2 = string;
        this.dcregistryitemtag2DirtyFlag = true;
    }

    public String getDCRegistryItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCRegistryItemTag2();
        }
        return this.dcregistryitemtag2;
    }

    public boolean isDCRegistryItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCRegistryItemTag2Dirty();
        }
        return this.dcregistryitemtag2DirtyFlag;
    }

    public void resetDCRegistryItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCRegistryItemTag2();
            return;
        }
        this.dcregistryitemtag2DirtyFlag = false;
        this.dcregistryitemtag2 = null;
    }

    public void setDCRegistryItemTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCRegistryItemTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcregistryitemtag3 = string;
        this.dcregistryitemtag3DirtyFlag = true;
    }

    public String getDCRegistryItemTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCRegistryItemTag3();
        }
        return this.dcregistryitemtag3;
    }

    public boolean isDCRegistryItemTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCRegistryItemTag3Dirty();
        }
        return this.dcregistryitemtag3DirtyFlag;
    }

    public void resetDCRegistryItemTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCRegistryItemTag3();
            return;
        }
        this.dcregistryitemtag3DirtyFlag = false;
        this.dcregistryitemtag3 = null;
    }

    public void setDCRegistryItemTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCRegistryItemTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcregistryitemtag4 = string;
        this.dcregistryitemtag4DirtyFlag = true;
    }

    public String getDCRegistryItemTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCRegistryItemTag4();
        }
        return this.dcregistryitemtag4;
    }

    public boolean isDCRegistryItemTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCRegistryItemTag4Dirty();
        }
        return this.dcregistryitemtag4DirtyFlag;
    }

    public void resetDCRegistryItemTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCRegistryItemTag4();
            return;
        }
        this.dcregistryitemtag4DirtyFlag = false;
        this.dcregistryitemtag4 = null;
    }

    public void setEnvParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnvParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.envparams = string;
        this.envparamsDirtyFlag = true;
    }

    public String getEnvParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnvParams();
        }
        return this.envparams;
    }

    public boolean isEnvParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnvParamsDirty();
        }
        return this.envparamsDirtyFlag;
    }

    public void resetEnvParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnvParams();
            return;
        }
        this.envparamsDirtyFlag = false;
        this.envparams = null;
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

    public void setMaxCPU(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxCPU(d);
            return;
        }
        this.maxcpu = d;
        this.maxcpuDirtyFlag = true;
    }

    public Double getMaxCPU() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxCPU();
        }
        return this.maxcpu;
    }

    public boolean isMaxCPUDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxCPUDirty();
        }
        return this.maxcpuDirtyFlag;
    }

    public void resetMaxCPU() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxCPU();
            return;
        }
        this.maxcpuDirtyFlag = false;
        this.maxcpu = null;
    }

    public void setMaxMem(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxMem(d);
            return;
        }
        this.maxmem = d;
        this.maxmemDirtyFlag = true;
    }

    public Double getMaxMem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxMem();
        }
        return this.maxmem;
    }

    public boolean isMaxMemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxMemDirty();
        }
        return this.maxmemDirtyFlag;
    }

    public void resetMaxMem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxMem();
            return;
        }
        this.maxmemDirtyFlag = false;
        this.maxmem = null;
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

    public void setMinCPU(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinCPU(d);
            return;
        }
        this.mincpu = d;
        this.mincpuDirtyFlag = true;
    }

    public Double getMinCPU() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinCPU();
        }
        return this.mincpu;
    }

    public boolean isMinCPUDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinCPUDirty();
        }
        return this.mincpuDirtyFlag;
    }

    public void resetMinCPU() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinCPU();
            return;
        }
        this.mincpuDirtyFlag = false;
        this.mincpu = null;
    }

    public void setMinMem(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinMem(d);
            return;
        }
        this.minmem = d;
        this.minmemDirtyFlag = true;
    }

    public Double getMinMem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinMem();
        }
        return this.minmem;
    }

    public boolean isMinMemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinMemDirty();
        }
        return this.minmemDirtyFlag;
    }

    public void resetMinMem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinMem();
            return;
        }
        this.minmemDirtyFlag = false;
        this.minmem = null;
    }

    public void setNodeInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeinfo = string;
        this.nodeinfoDirtyFlag = true;
    }

    public String getNodeInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeInfo();
        }
        return this.nodeinfo;
    }

    public boolean isNodeInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeInfoDirty();
        }
        return this.nodeinfoDirtyFlag;
    }

    public void resetNodeInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeInfo();
            return;
        }
        this.nodeinfoDirtyFlag = false;
        this.nodeinfo = null;
    }

    public void setNodeState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodestate = string;
        this.nodestateDirtyFlag = true;
    }

    public String getNodeState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeState();
        }
        return this.nodestate;
    }

    public boolean isNodeStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeStateDirty();
        }
        return this.nodestateDirtyFlag;
    }

    public void resetNodeState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeState();
            return;
        }
        this.nodestateDirtyFlag = false;
        this.nodestate = null;
    }

    public void setNodeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodetag = string;
        this.nodetagDirtyFlag = true;
    }

    public String getNodeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeTag();
        }
        return this.nodetag;
    }

    public boolean isNodeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeTagDirty();
        }
        return this.nodetagDirtyFlag;
    }

    public void resetNodeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeTag();
            return;
        }
        this.nodetagDirtyFlag = false;
        this.nodetag = null;
    }

    public void setNodeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodetag2 = string;
        this.nodetag2DirtyFlag = true;
    }

    public String getNodeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeTag2();
        }
        return this.nodetag2;
    }

    public boolean isNodeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeTag2Dirty();
        }
        return this.nodetag2DirtyFlag;
    }

    public void resetNodeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeTag2();
            return;
        }
        this.nodetag2DirtyFlag = false;
        this.nodetag2 = null;
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

    public void setPort2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPort2(n);
            return;
        }
        this.port2 = n;
        this.port2DirtyFlag = true;
    }

    public Integer getPort2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPort2();
        }
        return this.port2;
    }

    public boolean isPort2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPort2Dirty();
        }
        return this.port2DirtyFlag;
    }

    public void resetPort2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPort2();
            return;
        }
        this.port2DirtyFlag = false;
        this.port2 = null;
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

    public void setPSMSPlatformNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformnodeid = string;
        this.psmsplatformnodeidDirtyFlag = true;
    }

    public String getPSMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformNodeId();
        }
        return this.psmsplatformnodeid;
    }

    public boolean isPSMSPlatformNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformNodeIdDirty();
        }
        return this.psmsplatformnodeidDirtyFlag;
    }

    public void resetPSMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformNodeId();
            return;
        }
        this.psmsplatformnodeidDirtyFlag = false;
        this.psmsplatformnodeid = null;
    }

    public void setPSMSPlatformNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMSPlatformNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmsplatformnodename = string;
        this.psmsplatformnodenameDirtyFlag = true;
    }

    public String getPSMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformNodeName();
        }
        return this.psmsplatformnodename;
    }

    public boolean isPSMSPlatformNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMSPlatformNodeNameDirty();
        }
        return this.psmsplatformnodenameDirtyFlag;
    }

    public void resetPSMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMSPlatformNodeName();
            return;
        }
        this.psmsplatformnodenameDirtyFlag = false;
        this.psmsplatformnodename = null;
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

    public void setRefInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refinfo = string;
        this.refinfoDirtyFlag = true;
    }

    public String getRefInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefInfo();
        }
        return this.refinfo;
    }

    public boolean isRefInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefInfoDirty();
        }
        return this.refinfoDirtyFlag;
    }

    public void resetRefInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefInfo();
            return;
        }
        this.refinfoDirtyFlag = false;
        this.refinfo = null;
    }

    public void setReplicated(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReplicated(n);
            return;
        }
        this.replicated = n;
        this.replicatedDirtyFlag = true;
    }

    public Integer getReplicated() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReplicated();
        }
        return this.replicated;
    }

    public boolean isReplicatedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReplicatedDirty();
        }
        return this.replicatedDirtyFlag;
    }

    public void resetReplicated() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReplicated();
            return;
        }
        this.replicatedDirtyFlag = false;
        this.replicated = null;
    }

    public void setScale(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScale(n);
            return;
        }
        this.scale = n;
        this.scaleDirtyFlag = true;
    }

    public Integer getScale() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScale();
        }
        return this.scale;
    }

    public boolean isScaleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScaleDirty();
        }
        return this.scaleDirtyFlag;
    }

    public void resetScale() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScale();
            return;
        }
        this.scaleDirtyFlag = false;
        this.scale = null;
    }

    public void setServiceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceid = string;
        this.serviceidDirtyFlag = true;
    }

    public String getServiceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceId();
        }
        return this.serviceid;
    }

    public boolean isServiceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceIdDirty();
        }
        return this.serviceidDirtyFlag;
    }

    public void resetServiceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceId();
            return;
        }
        this.serviceidDirtyFlag = false;
        this.serviceid = null;
    }

    public void setServiceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicename = string;
        this.servicenameDirtyFlag = true;
    }

    public String getServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceName();
        }
        return this.servicename;
    }

    public boolean isServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceNameDirty();
        }
        return this.servicenameDirtyFlag;
    }

    public void resetServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceName();
            return;
        }
        this.servicenameDirtyFlag = false;
        this.servicename = null;
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
        PSDCMSPlatformNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase) {
        pSDCMSPlatformNodeBase.resetCfgType();
        pSDCMSPlatformNodeBase.resetContainerCfg();
        pSDCMSPlatformNodeBase.resetCreateDate();
        pSDCMSPlatformNodeBase.resetCreateMan();
        pSDCMSPlatformNodeBase.resetDCRegistryItemTag();
        pSDCMSPlatformNodeBase.resetDCRegistryItemTag2();
        pSDCMSPlatformNodeBase.resetDCRegistryItemTag3();
        pSDCMSPlatformNodeBase.resetDCRegistryItemTag4();
        pSDCMSPlatformNodeBase.resetEnvParams();
        pSDCMSPlatformNodeBase.resetIpAddr();
        pSDCMSPlatformNodeBase.resetIpAddr2();
        pSDCMSPlatformNodeBase.resetMaxCPU();
        pSDCMSPlatformNodeBase.resetMaxMem();
        pSDCMSPlatformNodeBase.resetMemo();
        pSDCMSPlatformNodeBase.resetMinCPU();
        pSDCMSPlatformNodeBase.resetMinMem();
        pSDCMSPlatformNodeBase.resetNodeInfo();
        pSDCMSPlatformNodeBase.resetNodeState();
        pSDCMSPlatformNodeBase.resetNodeTag();
        pSDCMSPlatformNodeBase.resetNodeTag2();
        pSDCMSPlatformNodeBase.resetPasswd();
        pSDCMSPlatformNodeBase.resetPort();
        pSDCMSPlatformNodeBase.resetPort2();
        pSDCMSPlatformNodeBase.resetPSDCMSPlatformId();
        pSDCMSPlatformNodeBase.resetPSDCMSPlatformName();
        pSDCMSPlatformNodeBase.resetPSDCMSPlatformNodeId();
        pSDCMSPlatformNodeBase.resetPSDCMSPlatformNodeName();
        pSDCMSPlatformNodeBase.resetPSDCRegistryItemId();
        pSDCMSPlatformNodeBase.resetPSDCRegistryItemName();
        pSDCMSPlatformNodeBase.resetPSDevSlnId();
        pSDCMSPlatformNodeBase.resetPSDevSlnName();
        pSDCMSPlatformNodeBase.resetPSMSPlatformNodeId();
        pSDCMSPlatformNodeBase.resetPSMSPlatformNodeName();
        pSDCMSPlatformNodeBase.resetRefCount();
        pSDCMSPlatformNodeBase.resetRefInfo();
        pSDCMSPlatformNodeBase.resetReplicated();
        pSDCMSPlatformNodeBase.resetScale();
        pSDCMSPlatformNodeBase.resetServiceId();
        pSDCMSPlatformNodeBase.resetServiceName();
        pSDCMSPlatformNodeBase.resetServiceUrl();
        pSDCMSPlatformNodeBase.resetSSHIPAddr();
        pSDCMSPlatformNodeBase.resetSSHPort();
        pSDCMSPlatformNodeBase.resetUpdateDate();
        pSDCMSPlatformNodeBase.resetUpdateMan();
        pSDCMSPlatformNodeBase.resetUploadFileMode();
        pSDCMSPlatformNodeBase.resetUploadPath();
        pSDCMSPlatformNodeBase.resetUserName();
        pSDCMSPlatformNodeBase.resetUserParams();
        pSDCMSPlatformNodeBase.resetUserTag();
        pSDCMSPlatformNodeBase.resetUserTag2();
        pSDCMSPlatformNodeBase.resetUserTag3();
        pSDCMSPlatformNodeBase.resetUserTag4();
        pSDCMSPlatformNodeBase.resetValidFlag();
        pSDCMSPlatformNodeBase.resetWorkshopPath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCfgTypeDirty()) {
            hashMap.put(FIELD_CFGTYPE, this.getCfgType());
        }
        if (!bl || this.isContainerCfgDirty()) {
            hashMap.put(FIELD_CONTAINERCFG, this.getContainerCfg());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDCRegistryItemTagDirty()) {
            hashMap.put(FIELD_DCREGISTRYITEMTAG, this.getDCRegistryItemTag());
        }
        if (!bl || this.isDCRegistryItemTag2Dirty()) {
            hashMap.put(FIELD_DCREGISTRYITEMTAG2, this.getDCRegistryItemTag2());
        }
        if (!bl || this.isDCRegistryItemTag3Dirty()) {
            hashMap.put(FIELD_DCREGISTRYITEMTAG3, this.getDCRegistryItemTag3());
        }
        if (!bl || this.isDCRegistryItemTag4Dirty()) {
            hashMap.put(FIELD_DCREGISTRYITEMTAG4, this.getDCRegistryItemTag4());
        }
        if (!bl || this.isEnvParamsDirty()) {
            hashMap.put(FIELD_ENVPARAMS, this.getEnvParams());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isMaxCPUDirty()) {
            hashMap.put(FIELD_MAXCPU, this.getMaxCPU());
        }
        if (!bl || this.isMaxMemDirty()) {
            hashMap.put(FIELD_MAXMEM, this.getMaxMem());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinCPUDirty()) {
            hashMap.put(FIELD_MINCPU, this.getMinCPU());
        }
        if (!bl || this.isMinMemDirty()) {
            hashMap.put(FIELD_MINMEM, this.getMinMem());
        }
        if (!bl || this.isNodeInfoDirty()) {
            hashMap.put(FIELD_NODEINFO, this.getNodeInfo());
        }
        if (!bl || this.isNodeStateDirty()) {
            hashMap.put(FIELD_NODESTATE, this.getNodeState());
        }
        if (!bl || this.isNodeTagDirty()) {
            hashMap.put(FIELD_NODETAG, this.getNodeTag());
        }
        if (!bl || this.isNodeTag2Dirty()) {
            hashMap.put(FIELD_NODETAG2, this.getNodeTag2());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPortDirty()) {
            hashMap.put(FIELD_PORT, this.getPort());
        }
        if (!bl || this.isPort2Dirty()) {
            hashMap.put(FIELD_PORT2, this.getPort2());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNAME, this.getPSDCMSPlatformName());
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
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSMSPlatformNodeIdDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNODEID, this.getPSMSPlatformNodeId());
        }
        if (!bl || this.isPSMSPlatformNodeNameDirty()) {
            hashMap.put(FIELD_PSMSPLATFORMNODENAME, this.getPSMSPlatformNodeName());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isReplicatedDirty()) {
            hashMap.put(FIELD_REPLICATED, this.getReplicated());
        }
        if (!bl || this.isScaleDirty()) {
            hashMap.put(FIELD_SCALE, this.getScale());
        }
        if (!bl || this.isServiceIdDirty()) {
            hashMap.put(FIELD_SERVICEID, this.getServiceId());
        }
        if (!bl || this.isServiceNameDirty()) {
            hashMap.put(FIELD_SERVICENAME, this.getServiceName());
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
        return PSDCMSPlatformNodeBase.get(this, n);
    }

    private static Object get(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformNodeBase.getCfgType();
            }
            case 1: {
                return pSDCMSPlatformNodeBase.getContainerCfg();
            }
            case 2: {
                return pSDCMSPlatformNodeBase.getCreateDate();
            }
            case 3: {
                return pSDCMSPlatformNodeBase.getCreateMan();
            }
            case 4: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag();
            }
            case 5: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag2();
            }
            case 6: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag3();
            }
            case 7: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag4();
            }
            case 8: {
                return pSDCMSPlatformNodeBase.getEnvParams();
            }
            case 9: {
                return pSDCMSPlatformNodeBase.getIpAddr();
            }
            case 10: {
                return pSDCMSPlatformNodeBase.getIpAddr2();
            }
            case 11: {
                return pSDCMSPlatformNodeBase.getMaxCPU();
            }
            case 12: {
                return pSDCMSPlatformNodeBase.getMaxMem();
            }
            case 13: {
                return pSDCMSPlatformNodeBase.getMemo();
            }
            case 14: {
                return pSDCMSPlatformNodeBase.getMinCPU();
            }
            case 15: {
                return pSDCMSPlatformNodeBase.getMinMem();
            }
            case 16: {
                return pSDCMSPlatformNodeBase.getNodeInfo();
            }
            case 17: {
                return pSDCMSPlatformNodeBase.getNodeState();
            }
            case 18: {
                return pSDCMSPlatformNodeBase.getNodeTag();
            }
            case 19: {
                return pSDCMSPlatformNodeBase.getNodeTag2();
            }
            case 20: {
                return pSDCMSPlatformNodeBase.getPasswd();
            }
            case 21: {
                return pSDCMSPlatformNodeBase.getPort();
            }
            case 22: {
                return pSDCMSPlatformNodeBase.getPort2();
            }
            case 23: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformId();
            }
            case 24: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformName();
            }
            case 25: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId();
            }
            case 26: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName();
            }
            case 27: {
                return pSDCMSPlatformNodeBase.getPSDCRegistryItemId();
            }
            case 28: {
                return pSDCMSPlatformNodeBase.getPSDCRegistryItemName();
            }
            case 29: {
                return pSDCMSPlatformNodeBase.getPSDevSlnId();
            }
            case 30: {
                return pSDCMSPlatformNodeBase.getPSDevSlnName();
            }
            case 31: {
                return pSDCMSPlatformNodeBase.getPSMSPlatformNodeId();
            }
            case 32: {
                return pSDCMSPlatformNodeBase.getPSMSPlatformNodeName();
            }
            case 33: {
                return pSDCMSPlatformNodeBase.getRefCount();
            }
            case 34: {
                return pSDCMSPlatformNodeBase.getRefInfo();
            }
            case 35: {
                return pSDCMSPlatformNodeBase.getReplicated();
            }
            case 36: {
                return pSDCMSPlatformNodeBase.getScale();
            }
            case 37: {
                return pSDCMSPlatformNodeBase.getServiceId();
            }
            case 38: {
                return pSDCMSPlatformNodeBase.getServiceName();
            }
            case 39: {
                return pSDCMSPlatformNodeBase.getServiceUrl();
            }
            case 40: {
                return pSDCMSPlatformNodeBase.getSSHIPAddr();
            }
            case 41: {
                return pSDCMSPlatformNodeBase.getSSHPort();
            }
            case 42: {
                return pSDCMSPlatformNodeBase.getUpdateDate();
            }
            case 43: {
                return pSDCMSPlatformNodeBase.getUpdateMan();
            }
            case 44: {
                return pSDCMSPlatformNodeBase.getUploadFileMode();
            }
            case 45: {
                return pSDCMSPlatformNodeBase.getUploadPath();
            }
            case 46: {
                return pSDCMSPlatformNodeBase.getUserName();
            }
            case 47: {
                return pSDCMSPlatformNodeBase.getUserParams();
            }
            case 48: {
                return pSDCMSPlatformNodeBase.getUserTag();
            }
            case 49: {
                return pSDCMSPlatformNodeBase.getUserTag2();
            }
            case 50: {
                return pSDCMSPlatformNodeBase.getUserTag3();
            }
            case 51: {
                return pSDCMSPlatformNodeBase.getUserTag4();
            }
            case 52: {
                return pSDCMSPlatformNodeBase.getValidFlag();
            }
            case 53: {
                return pSDCMSPlatformNodeBase.getWorkshopPath();
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
        PSDCMSPlatformNodeBase.set(this, n, object);
    }

    private static void set(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMSPlatformNodeBase.setCfgType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCMSPlatformNodeBase.setContainerCfg(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMSPlatformNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCMSPlatformNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMSPlatformNodeBase.setDCRegistryItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMSPlatformNodeBase.setDCRegistryItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMSPlatformNodeBase.setDCRegistryItemTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCMSPlatformNodeBase.setDCRegistryItemTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCMSPlatformNodeBase.setEnvParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCMSPlatformNodeBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCMSPlatformNodeBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCMSPlatformNodeBase.setMaxCPU(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 12: {
                pSDCMSPlatformNodeBase.setMaxMem(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 13: {
                pSDCMSPlatformNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCMSPlatformNodeBase.setMinCPU(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 15: {
                pSDCMSPlatformNodeBase.setMinMem(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 16: {
                pSDCMSPlatformNodeBase.setNodeInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCMSPlatformNodeBase.setNodeState(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCMSPlatformNodeBase.setNodeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCMSPlatformNodeBase.setNodeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCMSPlatformNodeBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCMSPlatformNodeBase.setPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDCMSPlatformNodeBase.setPort2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDCMSPlatformNodeBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCMSPlatformNodeBase.setPSDCMSPlatformName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCMSPlatformNodeBase.setPSDCMSPlatformNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDCMSPlatformNodeBase.setPSDCMSPlatformNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCMSPlatformNodeBase.setPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCMSPlatformNodeBase.setPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCMSPlatformNodeBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCMSPlatformNodeBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCMSPlatformNodeBase.setPSMSPlatformNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCMSPlatformNodeBase.setPSMSPlatformNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCMSPlatformNodeBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDCMSPlatformNodeBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDCMSPlatformNodeBase.setReplicated(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDCMSPlatformNodeBase.setScale(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDCMSPlatformNodeBase.setServiceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDCMSPlatformNodeBase.setServiceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDCMSPlatformNodeBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDCMSPlatformNodeBase.setSSHIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDCMSPlatformNodeBase.setSSHPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDCMSPlatformNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 43: {
                pSDCMSPlatformNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDCMSPlatformNodeBase.setUploadFileMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDCMSPlatformNodeBase.setUploadPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDCMSPlatformNodeBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDCMSPlatformNodeBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDCMSPlatformNodeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDCMSPlatformNodeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDCMSPlatformNodeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDCMSPlatformNodeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDCMSPlatformNodeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSDCMSPlatformNodeBase.setWorkshopPath(DataObject.getStringValue((Object)object));
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
        return PSDCMSPlatformNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformNodeBase.getCfgType() == null;
            }
            case 1: {
                return pSDCMSPlatformNodeBase.getContainerCfg() == null;
            }
            case 2: {
                return pSDCMSPlatformNodeBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCMSPlatformNodeBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag() == null;
            }
            case 5: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag2() == null;
            }
            case 6: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag3() == null;
            }
            case 7: {
                return pSDCMSPlatformNodeBase.getDCRegistryItemTag4() == null;
            }
            case 8: {
                return pSDCMSPlatformNodeBase.getEnvParams() == null;
            }
            case 9: {
                return pSDCMSPlatformNodeBase.getIpAddr() == null;
            }
            case 10: {
                return pSDCMSPlatformNodeBase.getIpAddr2() == null;
            }
            case 11: {
                return pSDCMSPlatformNodeBase.getMaxCPU() == null;
            }
            case 12: {
                return pSDCMSPlatformNodeBase.getMaxMem() == null;
            }
            case 13: {
                return pSDCMSPlatformNodeBase.getMemo() == null;
            }
            case 14: {
                return pSDCMSPlatformNodeBase.getMinCPU() == null;
            }
            case 15: {
                return pSDCMSPlatformNodeBase.getMinMem() == null;
            }
            case 16: {
                return pSDCMSPlatformNodeBase.getNodeInfo() == null;
            }
            case 17: {
                return pSDCMSPlatformNodeBase.getNodeState() == null;
            }
            case 18: {
                return pSDCMSPlatformNodeBase.getNodeTag() == null;
            }
            case 19: {
                return pSDCMSPlatformNodeBase.getNodeTag2() == null;
            }
            case 20: {
                return pSDCMSPlatformNodeBase.getPasswd() == null;
            }
            case 21: {
                return pSDCMSPlatformNodeBase.getPort() == null;
            }
            case 22: {
                return pSDCMSPlatformNodeBase.getPort2() == null;
            }
            case 23: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformId() == null;
            }
            case 24: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformName() == null;
            }
            case 25: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId() == null;
            }
            case 26: {
                return pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName() == null;
            }
            case 27: {
                return pSDCMSPlatformNodeBase.getPSDCRegistryItemId() == null;
            }
            case 28: {
                return pSDCMSPlatformNodeBase.getPSDCRegistryItemName() == null;
            }
            case 29: {
                return pSDCMSPlatformNodeBase.getPSDevSlnId() == null;
            }
            case 30: {
                return pSDCMSPlatformNodeBase.getPSDevSlnName() == null;
            }
            case 31: {
                return pSDCMSPlatformNodeBase.getPSMSPlatformNodeId() == null;
            }
            case 32: {
                return pSDCMSPlatformNodeBase.getPSMSPlatformNodeName() == null;
            }
            case 33: {
                return pSDCMSPlatformNodeBase.getRefCount() == null;
            }
            case 34: {
                return pSDCMSPlatformNodeBase.getRefInfo() == null;
            }
            case 35: {
                return pSDCMSPlatformNodeBase.getReplicated() == null;
            }
            case 36: {
                return pSDCMSPlatformNodeBase.getScale() == null;
            }
            case 37: {
                return pSDCMSPlatformNodeBase.getServiceId() == null;
            }
            case 38: {
                return pSDCMSPlatformNodeBase.getServiceName() == null;
            }
            case 39: {
                return pSDCMSPlatformNodeBase.getServiceUrl() == null;
            }
            case 40: {
                return pSDCMSPlatformNodeBase.getSSHIPAddr() == null;
            }
            case 41: {
                return pSDCMSPlatformNodeBase.getSSHPort() == null;
            }
            case 42: {
                return pSDCMSPlatformNodeBase.getUpdateDate() == null;
            }
            case 43: {
                return pSDCMSPlatformNodeBase.getUpdateMan() == null;
            }
            case 44: {
                return pSDCMSPlatformNodeBase.getUploadFileMode() == null;
            }
            case 45: {
                return pSDCMSPlatformNodeBase.getUploadPath() == null;
            }
            case 46: {
                return pSDCMSPlatformNodeBase.getUserName() == null;
            }
            case 47: {
                return pSDCMSPlatformNodeBase.getUserParams() == null;
            }
            case 48: {
                return pSDCMSPlatformNodeBase.getUserTag() == null;
            }
            case 49: {
                return pSDCMSPlatformNodeBase.getUserTag2() == null;
            }
            case 50: {
                return pSDCMSPlatformNodeBase.getUserTag3() == null;
            }
            case 51: {
                return pSDCMSPlatformNodeBase.getUserTag4() == null;
            }
            case 52: {
                return pSDCMSPlatformNodeBase.getValidFlag() == null;
            }
            case 53: {
                return pSDCMSPlatformNodeBase.getWorkshopPath() == null;
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
        return PSDCMSPlatformNodeBase.contains(this, n);
    }

    private static boolean contains(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMSPlatformNodeBase.isCfgTypeDirty();
            }
            case 1: {
                return pSDCMSPlatformNodeBase.isContainerCfgDirty();
            }
            case 2: {
                return pSDCMSPlatformNodeBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCMSPlatformNodeBase.isCreateManDirty();
            }
            case 4: {
                return pSDCMSPlatformNodeBase.isDCRegistryItemTagDirty();
            }
            case 5: {
                return pSDCMSPlatformNodeBase.isDCRegistryItemTag2Dirty();
            }
            case 6: {
                return pSDCMSPlatformNodeBase.isDCRegistryItemTag3Dirty();
            }
            case 7: {
                return pSDCMSPlatformNodeBase.isDCRegistryItemTag4Dirty();
            }
            case 8: {
                return pSDCMSPlatformNodeBase.isEnvParamsDirty();
            }
            case 9: {
                return pSDCMSPlatformNodeBase.isIpAddrDirty();
            }
            case 10: {
                return pSDCMSPlatformNodeBase.isIpAddr2Dirty();
            }
            case 11: {
                return pSDCMSPlatformNodeBase.isMaxCPUDirty();
            }
            case 12: {
                return pSDCMSPlatformNodeBase.isMaxMemDirty();
            }
            case 13: {
                return pSDCMSPlatformNodeBase.isMemoDirty();
            }
            case 14: {
                return pSDCMSPlatformNodeBase.isMinCPUDirty();
            }
            case 15: {
                return pSDCMSPlatformNodeBase.isMinMemDirty();
            }
            case 16: {
                return pSDCMSPlatformNodeBase.isNodeInfoDirty();
            }
            case 17: {
                return pSDCMSPlatformNodeBase.isNodeStateDirty();
            }
            case 18: {
                return pSDCMSPlatformNodeBase.isNodeTagDirty();
            }
            case 19: {
                return pSDCMSPlatformNodeBase.isNodeTag2Dirty();
            }
            case 20: {
                return pSDCMSPlatformNodeBase.isPasswdDirty();
            }
            case 21: {
                return pSDCMSPlatformNodeBase.isPortDirty();
            }
            case 22: {
                return pSDCMSPlatformNodeBase.isPort2Dirty();
            }
            case 23: {
                return pSDCMSPlatformNodeBase.isPSDCMSPlatformIdDirty();
            }
            case 24: {
                return pSDCMSPlatformNodeBase.isPSDCMSPlatformNameDirty();
            }
            case 25: {
                return pSDCMSPlatformNodeBase.isPSDCMSPlatformNodeIdDirty();
            }
            case 26: {
                return pSDCMSPlatformNodeBase.isPSDCMSPlatformNodeNameDirty();
            }
            case 27: {
                return pSDCMSPlatformNodeBase.isPSDCRegistryItemIdDirty();
            }
            case 28: {
                return pSDCMSPlatformNodeBase.isPSDCRegistryItemNameDirty();
            }
            case 29: {
                return pSDCMSPlatformNodeBase.isPSDevSlnIdDirty();
            }
            case 30: {
                return pSDCMSPlatformNodeBase.isPSDevSlnNameDirty();
            }
            case 31: {
                return pSDCMSPlatformNodeBase.isPSMSPlatformNodeIdDirty();
            }
            case 32: {
                return pSDCMSPlatformNodeBase.isPSMSPlatformNodeNameDirty();
            }
            case 33: {
                return pSDCMSPlatformNodeBase.isRefCountDirty();
            }
            case 34: {
                return pSDCMSPlatformNodeBase.isRefInfoDirty();
            }
            case 35: {
                return pSDCMSPlatformNodeBase.isReplicatedDirty();
            }
            case 36: {
                return pSDCMSPlatformNodeBase.isScaleDirty();
            }
            case 37: {
                return pSDCMSPlatformNodeBase.isServiceIdDirty();
            }
            case 38: {
                return pSDCMSPlatformNodeBase.isServiceNameDirty();
            }
            case 39: {
                return pSDCMSPlatformNodeBase.isServiceUrlDirty();
            }
            case 40: {
                return pSDCMSPlatformNodeBase.isSSHIPAddrDirty();
            }
            case 41: {
                return pSDCMSPlatformNodeBase.isSSHPortDirty();
            }
            case 42: {
                return pSDCMSPlatformNodeBase.isUpdateDateDirty();
            }
            case 43: {
                return pSDCMSPlatformNodeBase.isUpdateManDirty();
            }
            case 44: {
                return pSDCMSPlatformNodeBase.isUploadFileModeDirty();
            }
            case 45: {
                return pSDCMSPlatformNodeBase.isUploadPathDirty();
            }
            case 46: {
                return pSDCMSPlatformNodeBase.isUserNameDirty();
            }
            case 47: {
                return pSDCMSPlatformNodeBase.isUserParamsDirty();
            }
            case 48: {
                return pSDCMSPlatformNodeBase.isUserTagDirty();
            }
            case 49: {
                return pSDCMSPlatformNodeBase.isUserTag2Dirty();
            }
            case 50: {
                return pSDCMSPlatformNodeBase.isUserTag3Dirty();
            }
            case 51: {
                return pSDCMSPlatformNodeBase.isUserTag4Dirty();
            }
            case 52: {
                return pSDCMSPlatformNodeBase.isValidFlagDirty();
            }
            case 53: {
                return pSDCMSPlatformNodeBase.isWorkshopPathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMSPlatformNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMSPlatformNodeBase.getCfgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgtype", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getCfgType()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getContainerCfg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"containercfg", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getContainerCfg()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcregistryitemtag", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcregistryitemtag2", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcregistryitemtag3", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag3()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcregistryitemtag4", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag4()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getEnvParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"envparams", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getEnvParams()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getMaxCPU() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxcpu", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getMaxCPU()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getMaxMem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxmen", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getMaxMem()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getMinCPU() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mincpu", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getMinCPU()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getMinMem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minmen", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getMinMem()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeinfo", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getNodeInfo()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodestate", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getNodeState()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodetag", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getNodeTag()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodetag2", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getNodeTag2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPort()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPort2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"port2", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPort2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformname", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodeid", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodename", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemid", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemname", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSMSPlatformNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformnodeid", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSMSPlatformNodeId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSMSPlatformNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmsplatformnodename", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getPSMSPlatformNodeName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getReplicated() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"replicated", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getReplicated()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getScale() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"scale", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getScale()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getServiceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceid", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getServiceId()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getServiceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicename", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getServiceName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getSSHIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshipaddr", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getSSHIPAddr()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getSSHPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sshport", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getSSHPort()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUploadFileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadfilemode", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUploadFileMode()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUploadPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uploadpath", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUploadPath()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUserName()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDCMSPlatformNodeBase.getWorkshopPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshoppath", (Object)PSDCMSPlatformNodeBase.getJSONValue((Object)pSDCMSPlatformNodeBase.getWorkshopPath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMSPlatformNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMSPlatformNodeBase.getCfgType() != null) {
            object = pSDCMSPlatformNodeBase.getCfgType();
            xmlNode.setAttribute(FIELD_CFGTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDCMSPlatformNodeBase.getContainerCfg() != null) {
            object = pSDCMSPlatformNodeBase.getContainerCfg();
            xmlNode.setAttribute(FIELD_CONTAINERCFG, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getCreateDate() != null) {
            object = pSDCMSPlatformNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getCreateMan() != null) {
            object = pSDCMSPlatformNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag() != null) {
            object = pSDCMSPlatformNodeBase.getDCRegistryItemTag();
            xmlNode.setAttribute(FIELD_DCREGISTRYITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag2() != null) {
            object = pSDCMSPlatformNodeBase.getDCRegistryItemTag2();
            xmlNode.setAttribute(FIELD_DCREGISTRYITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag3() != null) {
            object = pSDCMSPlatformNodeBase.getDCRegistryItemTag3();
            xmlNode.setAttribute(FIELD_DCREGISTRYITEMTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag4() != null) {
            object = pSDCMSPlatformNodeBase.getDCRegistryItemTag4();
            xmlNode.setAttribute(FIELD_DCREGISTRYITEMTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getEnvParams() != null) {
            object = pSDCMSPlatformNodeBase.getEnvParams();
            xmlNode.setAttribute(FIELD_ENVPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getIpAddr() != null) {
            object = pSDCMSPlatformNodeBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getIpAddr2() != null) {
            object = pSDCMSPlatformNodeBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getMaxCPU() != null) {
            object = pSDCMSPlatformNodeBase.getMaxCPU();
            xmlNode.setAttribute(FIELD_MAXCPU, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getMaxMem() != null) {
            object = pSDCMSPlatformNodeBase.getMaxMem();
            xmlNode.setAttribute("MAXMEM", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getMemo() != null) {
            object = pSDCMSPlatformNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getMinCPU() != null) {
            object = pSDCMSPlatformNodeBase.getMinCPU();
            xmlNode.setAttribute(FIELD_MINCPU, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getMinMem() != null) {
            object = pSDCMSPlatformNodeBase.getMinMem();
            xmlNode.setAttribute("MINMEM", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeInfo() != null) {
            object = pSDCMSPlatformNodeBase.getNodeInfo();
            xmlNode.setAttribute(FIELD_NODEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeState() != null) {
            object = pSDCMSPlatformNodeBase.getNodeState();
            xmlNode.setAttribute(FIELD_NODESTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeTag() != null) {
            object = pSDCMSPlatformNodeBase.getNodeTag();
            xmlNode.setAttribute(FIELD_NODETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getNodeTag2() != null) {
            object = pSDCMSPlatformNodeBase.getNodeTag2();
            xmlNode.setAttribute(FIELD_NODETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPasswd() != null) {
            object = pSDCMSPlatformNodeBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPort() != null) {
            object = pSDCMSPlatformNodeBase.getPort();
            xmlNode.setAttribute(FIELD_PORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getPort2() != null) {
            object = pSDCMSPlatformNodeBase.getPort2();
            xmlNode.setAttribute(FIELD_PORT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformId() != null) {
            object = pSDCMSPlatformNodeBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformName() != null) {
            object = pSDCMSPlatformNodeBase.getPSDCMSPlatformName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId() != null) {
            object = pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName() != null) {
            object = pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCRegistryItemId() != null) {
            object = pSDCMSPlatformNodeBase.getPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDCRegistryItemName() != null) {
            object = pSDCMSPlatformNodeBase.getPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDevSlnId() != null) {
            object = pSDCMSPlatformNodeBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSDevSlnName() != null) {
            object = pSDCMSPlatformNodeBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSMSPlatformNodeId() != null) {
            object = pSDCMSPlatformNodeBase.getPSMSPlatformNodeId();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getPSMSPlatformNodeName() != null) {
            object = pSDCMSPlatformNodeBase.getPSMSPlatformNodeName();
            xmlNode.setAttribute(FIELD_PSMSPLATFORMNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getRefCount() != null) {
            object = pSDCMSPlatformNodeBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getRefInfo() != null) {
            object = pSDCMSPlatformNodeBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getReplicated() != null) {
            object = pSDCMSPlatformNodeBase.getReplicated();
            xmlNode.setAttribute(FIELD_REPLICATED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getScale() != null) {
            object = pSDCMSPlatformNodeBase.getScale();
            xmlNode.setAttribute(FIELD_SCALE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getServiceId() != null) {
            object = pSDCMSPlatformNodeBase.getServiceId();
            xmlNode.setAttribute(FIELD_SERVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getServiceName() != null) {
            object = pSDCMSPlatformNodeBase.getServiceName();
            xmlNode.setAttribute(FIELD_SERVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getServiceUrl() != null) {
            object = pSDCMSPlatformNodeBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getSSHIPAddr() != null) {
            object = pSDCMSPlatformNodeBase.getSSHIPAddr();
            xmlNode.setAttribute(FIELD_SSHIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getSSHPort() != null) {
            object = pSDCMSPlatformNodeBase.getSSHPort();
            xmlNode.setAttribute(FIELD_SSHPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getUpdateDate() != null) {
            object = pSDCMSPlatformNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getUpdateMan() != null) {
            object = pSDCMSPlatformNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUploadFileMode() != null) {
            object = pSDCMSPlatformNodeBase.getUploadFileMode();
            xmlNode.setAttribute(FIELD_UPLOADFILEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUploadPath() != null) {
            object = pSDCMSPlatformNodeBase.getUploadPath();
            xmlNode.setAttribute(FIELD_UPLOADPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserName() != null) {
            object = pSDCMSPlatformNodeBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserParams() != null) {
            object = pSDCMSPlatformNodeBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag() != null) {
            object = pSDCMSPlatformNodeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag2() != null) {
            object = pSDCMSPlatformNodeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag3() != null) {
            object = pSDCMSPlatformNodeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getUserTag4() != null) {
            object = pSDCMSPlatformNodeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDCMSPlatformNodeBase.getValidFlag() != null) {
            object = pSDCMSPlatformNodeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMSPlatformNodeBase.getWorkshopPath() != null) {
            object = pSDCMSPlatformNodeBase.getWorkshopPath();
            xmlNode.setAttribute(FIELD_WORKSHOPPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMSPlatformNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMSPlatformNodeBase.isCfgTypeDirty() && (bl || pSDCMSPlatformNodeBase.getCfgType() != null)) {
            iDataObject.set(FIELD_CFGTYPE, (Object)pSDCMSPlatformNodeBase.getCfgType());
        }
        if (pSDCMSPlatformNodeBase.isContainerCfgDirty() && (bl || pSDCMSPlatformNodeBase.getContainerCfg() != null)) {
            iDataObject.set(FIELD_CONTAINERCFG, (Object)pSDCMSPlatformNodeBase.getContainerCfg());
        }
        if (pSDCMSPlatformNodeBase.isCreateDateDirty() && (bl || pSDCMSPlatformNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMSPlatformNodeBase.getCreateDate());
        }
        if (pSDCMSPlatformNodeBase.isCreateManDirty() && (bl || pSDCMSPlatformNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMSPlatformNodeBase.getCreateMan());
        }
        if (pSDCMSPlatformNodeBase.isDCRegistryItemTagDirty() && (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag() != null)) {
            iDataObject.set(FIELD_DCREGISTRYITEMTAG, (Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag());
        }
        if (pSDCMSPlatformNodeBase.isDCRegistryItemTag2Dirty() && (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag2() != null)) {
            iDataObject.set(FIELD_DCREGISTRYITEMTAG2, (Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag2());
        }
        if (pSDCMSPlatformNodeBase.isDCRegistryItemTag3Dirty() && (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag3() != null)) {
            iDataObject.set(FIELD_DCREGISTRYITEMTAG3, (Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag3());
        }
        if (pSDCMSPlatformNodeBase.isDCRegistryItemTag4Dirty() && (bl || pSDCMSPlatformNodeBase.getDCRegistryItemTag4() != null)) {
            iDataObject.set(FIELD_DCREGISTRYITEMTAG4, (Object)pSDCMSPlatformNodeBase.getDCRegistryItemTag4());
        }
        if (pSDCMSPlatformNodeBase.isEnvParamsDirty() && (bl || pSDCMSPlatformNodeBase.getEnvParams() != null)) {
            iDataObject.set(FIELD_ENVPARAMS, (Object)pSDCMSPlatformNodeBase.getEnvParams());
        }
        if (pSDCMSPlatformNodeBase.isIpAddrDirty() && (bl || pSDCMSPlatformNodeBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSDCMSPlatformNodeBase.getIpAddr());
        }
        if (pSDCMSPlatformNodeBase.isIpAddr2Dirty() && (bl || pSDCMSPlatformNodeBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSDCMSPlatformNodeBase.getIpAddr2());
        }
        if (pSDCMSPlatformNodeBase.isMaxCPUDirty() && (bl || pSDCMSPlatformNodeBase.getMaxCPU() != null)) {
            iDataObject.set(FIELD_MAXCPU, (Object)pSDCMSPlatformNodeBase.getMaxCPU());
        }
        if (pSDCMSPlatformNodeBase.isMaxMemDirty() && (bl || pSDCMSPlatformNodeBase.getMaxMem() != null)) {
            iDataObject.set(FIELD_MAXMEM, (Object)pSDCMSPlatformNodeBase.getMaxMem());
        }
        if (pSDCMSPlatformNodeBase.isMemoDirty() && (bl || pSDCMSPlatformNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMSPlatformNodeBase.getMemo());
        }
        if (pSDCMSPlatformNodeBase.isMinCPUDirty() && (bl || pSDCMSPlatformNodeBase.getMinCPU() != null)) {
            iDataObject.set(FIELD_MINCPU, (Object)pSDCMSPlatformNodeBase.getMinCPU());
        }
        if (pSDCMSPlatformNodeBase.isMinMemDirty() && (bl || pSDCMSPlatformNodeBase.getMinMem() != null)) {
            iDataObject.set(FIELD_MINMEM, (Object)pSDCMSPlatformNodeBase.getMinMem());
        }
        if (pSDCMSPlatformNodeBase.isNodeInfoDirty() && (bl || pSDCMSPlatformNodeBase.getNodeInfo() != null)) {
            iDataObject.set(FIELD_NODEINFO, (Object)pSDCMSPlatformNodeBase.getNodeInfo());
        }
        if (pSDCMSPlatformNodeBase.isNodeStateDirty() && (bl || pSDCMSPlatformNodeBase.getNodeState() != null)) {
            iDataObject.set(FIELD_NODESTATE, (Object)pSDCMSPlatformNodeBase.getNodeState());
        }
        if (pSDCMSPlatformNodeBase.isNodeTagDirty() && (bl || pSDCMSPlatformNodeBase.getNodeTag() != null)) {
            iDataObject.set(FIELD_NODETAG, (Object)pSDCMSPlatformNodeBase.getNodeTag());
        }
        if (pSDCMSPlatformNodeBase.isNodeTag2Dirty() && (bl || pSDCMSPlatformNodeBase.getNodeTag2() != null)) {
            iDataObject.set(FIELD_NODETAG2, (Object)pSDCMSPlatformNodeBase.getNodeTag2());
        }
        if (pSDCMSPlatformNodeBase.isPasswdDirty() && (bl || pSDCMSPlatformNodeBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCMSPlatformNodeBase.getPasswd());
        }
        if (pSDCMSPlatformNodeBase.isPortDirty() && (bl || pSDCMSPlatformNodeBase.getPort() != null)) {
            iDataObject.set(FIELD_PORT, (Object)pSDCMSPlatformNodeBase.getPort());
        }
        if (pSDCMSPlatformNodeBase.isPort2Dirty() && (bl || pSDCMSPlatformNodeBase.getPort2() != null)) {
            iDataObject.set(FIELD_PORT2, (Object)pSDCMSPlatformNodeBase.getPort2());
        }
        if (pSDCMSPlatformNodeBase.isPSDCMSPlatformIdDirty() && (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformId());
        }
        if (pSDCMSPlatformNodeBase.isPSDCMSPlatformNameDirty() && (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNAME, (Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformName());
        }
        if (pSDCMSPlatformNodeBase.isPSDCMSPlatformNodeIdDirty() && (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODEID, (Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeId());
        }
        if (pSDCMSPlatformNodeBase.isPSDCMSPlatformNodeNameDirty() && (bl || pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODENAME, (Object)pSDCMSPlatformNodeBase.getPSDCMSPlatformNodeName());
        }
        if (pSDCMSPlatformNodeBase.isPSDCRegistryItemIdDirty() && (bl || pSDCMSPlatformNodeBase.getPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMID, (Object)pSDCMSPlatformNodeBase.getPSDCRegistryItemId());
        }
        if (pSDCMSPlatformNodeBase.isPSDCRegistryItemNameDirty() && (bl || pSDCMSPlatformNodeBase.getPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMNAME, (Object)pSDCMSPlatformNodeBase.getPSDCRegistryItemName());
        }
        if (pSDCMSPlatformNodeBase.isPSDevSlnIdDirty() && (bl || pSDCMSPlatformNodeBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCMSPlatformNodeBase.getPSDevSlnId());
        }
        if (pSDCMSPlatformNodeBase.isPSDevSlnNameDirty() && (bl || pSDCMSPlatformNodeBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCMSPlatformNodeBase.getPSDevSlnName());
        }
        if (pSDCMSPlatformNodeBase.isPSMSPlatformNodeIdDirty() && (bl || pSDCMSPlatformNodeBase.getPSMSPlatformNodeId() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNODEID, (Object)pSDCMSPlatformNodeBase.getPSMSPlatformNodeId());
        }
        if (pSDCMSPlatformNodeBase.isPSMSPlatformNodeNameDirty() && (bl || pSDCMSPlatformNodeBase.getPSMSPlatformNodeName() != null)) {
            iDataObject.set(FIELD_PSMSPLATFORMNODENAME, (Object)pSDCMSPlatformNodeBase.getPSMSPlatformNodeName());
        }
        if (pSDCMSPlatformNodeBase.isRefCountDirty() && (bl || pSDCMSPlatformNodeBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCMSPlatformNodeBase.getRefCount());
        }
        if (pSDCMSPlatformNodeBase.isRefInfoDirty() && (bl || pSDCMSPlatformNodeBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSDCMSPlatformNodeBase.getRefInfo());
        }
        if (pSDCMSPlatformNodeBase.isReplicatedDirty() && (bl || pSDCMSPlatformNodeBase.getReplicated() != null)) {
            iDataObject.set(FIELD_REPLICATED, (Object)pSDCMSPlatformNodeBase.getReplicated());
        }
        if (pSDCMSPlatformNodeBase.isScaleDirty() && (bl || pSDCMSPlatformNodeBase.getScale() != null)) {
            iDataObject.set(FIELD_SCALE, (Object)pSDCMSPlatformNodeBase.getScale());
        }
        if (pSDCMSPlatformNodeBase.isServiceIdDirty() && (bl || pSDCMSPlatformNodeBase.getServiceId() != null)) {
            iDataObject.set(FIELD_SERVICEID, (Object)pSDCMSPlatformNodeBase.getServiceId());
        }
        if (pSDCMSPlatformNodeBase.isServiceNameDirty() && (bl || pSDCMSPlatformNodeBase.getServiceName() != null)) {
            iDataObject.set(FIELD_SERVICENAME, (Object)pSDCMSPlatformNodeBase.getServiceName());
        }
        if (pSDCMSPlatformNodeBase.isServiceUrlDirty() && (bl || pSDCMSPlatformNodeBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSDCMSPlatformNodeBase.getServiceUrl());
        }
        if (pSDCMSPlatformNodeBase.isSSHIPAddrDirty() && (bl || pSDCMSPlatformNodeBase.getSSHIPAddr() != null)) {
            iDataObject.set(FIELD_SSHIPADDR, (Object)pSDCMSPlatformNodeBase.getSSHIPAddr());
        }
        if (pSDCMSPlatformNodeBase.isSSHPortDirty() && (bl || pSDCMSPlatformNodeBase.getSSHPort() != null)) {
            iDataObject.set(FIELD_SSHPORT, (Object)pSDCMSPlatformNodeBase.getSSHPort());
        }
        if (pSDCMSPlatformNodeBase.isUpdateDateDirty() && (bl || pSDCMSPlatformNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMSPlatformNodeBase.getUpdateDate());
        }
        if (pSDCMSPlatformNodeBase.isUpdateManDirty() && (bl || pSDCMSPlatformNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMSPlatformNodeBase.getUpdateMan());
        }
        if (pSDCMSPlatformNodeBase.isUploadFileModeDirty() && (bl || pSDCMSPlatformNodeBase.getUploadFileMode() != null)) {
            iDataObject.set(FIELD_UPLOADFILEMODE, (Object)pSDCMSPlatformNodeBase.getUploadFileMode());
        }
        if (pSDCMSPlatformNodeBase.isUploadPathDirty() && (bl || pSDCMSPlatformNodeBase.getUploadPath() != null)) {
            iDataObject.set(FIELD_UPLOADPATH, (Object)pSDCMSPlatformNodeBase.getUploadPath());
        }
        if (pSDCMSPlatformNodeBase.isUserNameDirty() && (bl || pSDCMSPlatformNodeBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDCMSPlatformNodeBase.getUserName());
        }
        if (pSDCMSPlatformNodeBase.isUserParamsDirty() && (bl || pSDCMSPlatformNodeBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDCMSPlatformNodeBase.getUserParams());
        }
        if (pSDCMSPlatformNodeBase.isUserTagDirty() && (bl || pSDCMSPlatformNodeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCMSPlatformNodeBase.getUserTag());
        }
        if (pSDCMSPlatformNodeBase.isUserTag2Dirty() && (bl || pSDCMSPlatformNodeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCMSPlatformNodeBase.getUserTag2());
        }
        if (pSDCMSPlatformNodeBase.isUserTag3Dirty() && (bl || pSDCMSPlatformNodeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCMSPlatformNodeBase.getUserTag3());
        }
        if (pSDCMSPlatformNodeBase.isUserTag4Dirty() && (bl || pSDCMSPlatformNodeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCMSPlatformNodeBase.getUserTag4());
        }
        if (pSDCMSPlatformNodeBase.isValidFlagDirty() && (bl || pSDCMSPlatformNodeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCMSPlatformNodeBase.getValidFlag());
        }
        if (pSDCMSPlatformNodeBase.isWorkshopPathDirty() && (bl || pSDCMSPlatformNodeBase.getWorkshopPath() != null)) {
            iDataObject.set(FIELD_WORKSHOPPATH, (Object)pSDCMSPlatformNodeBase.getWorkshopPath());
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
        return PSDCMSPlatformNodeBase.remove(this, n);
    }

    private static boolean remove(PSDCMSPlatformNodeBase pSDCMSPlatformNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMSPlatformNodeBase.resetCfgType();
                return true;
            }
            case 1: {
                pSDCMSPlatformNodeBase.resetContainerCfg();
                return true;
            }
            case 2: {
                pSDCMSPlatformNodeBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCMSPlatformNodeBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCMSPlatformNodeBase.resetDCRegistryItemTag();
                return true;
            }
            case 5: {
                pSDCMSPlatformNodeBase.resetDCRegistryItemTag2();
                return true;
            }
            case 6: {
                pSDCMSPlatformNodeBase.resetDCRegistryItemTag3();
                return true;
            }
            case 7: {
                pSDCMSPlatformNodeBase.resetDCRegistryItemTag4();
                return true;
            }
            case 8: {
                pSDCMSPlatformNodeBase.resetEnvParams();
                return true;
            }
            case 9: {
                pSDCMSPlatformNodeBase.resetIpAddr();
                return true;
            }
            case 10: {
                pSDCMSPlatformNodeBase.resetIpAddr2();
                return true;
            }
            case 11: {
                pSDCMSPlatformNodeBase.resetMaxCPU();
                return true;
            }
            case 12: {
                pSDCMSPlatformNodeBase.resetMaxMem();
                return true;
            }
            case 13: {
                pSDCMSPlatformNodeBase.resetMemo();
                return true;
            }
            case 14: {
                pSDCMSPlatformNodeBase.resetMinCPU();
                return true;
            }
            case 15: {
                pSDCMSPlatformNodeBase.resetMinMem();
                return true;
            }
            case 16: {
                pSDCMSPlatformNodeBase.resetNodeInfo();
                return true;
            }
            case 17: {
                pSDCMSPlatformNodeBase.resetNodeState();
                return true;
            }
            case 18: {
                pSDCMSPlatformNodeBase.resetNodeTag();
                return true;
            }
            case 19: {
                pSDCMSPlatformNodeBase.resetNodeTag2();
                return true;
            }
            case 20: {
                pSDCMSPlatformNodeBase.resetPasswd();
                return true;
            }
            case 21: {
                pSDCMSPlatformNodeBase.resetPort();
                return true;
            }
            case 22: {
                pSDCMSPlatformNodeBase.resetPort2();
                return true;
            }
            case 23: {
                pSDCMSPlatformNodeBase.resetPSDCMSPlatformId();
                return true;
            }
            case 24: {
                pSDCMSPlatformNodeBase.resetPSDCMSPlatformName();
                return true;
            }
            case 25: {
                pSDCMSPlatformNodeBase.resetPSDCMSPlatformNodeId();
                return true;
            }
            case 26: {
                pSDCMSPlatformNodeBase.resetPSDCMSPlatformNodeName();
                return true;
            }
            case 27: {
                pSDCMSPlatformNodeBase.resetPSDCRegistryItemId();
                return true;
            }
            case 28: {
                pSDCMSPlatformNodeBase.resetPSDCRegistryItemName();
                return true;
            }
            case 29: {
                pSDCMSPlatformNodeBase.resetPSDevSlnId();
                return true;
            }
            case 30: {
                pSDCMSPlatformNodeBase.resetPSDevSlnName();
                return true;
            }
            case 31: {
                pSDCMSPlatformNodeBase.resetPSMSPlatformNodeId();
                return true;
            }
            case 32: {
                pSDCMSPlatformNodeBase.resetPSMSPlatformNodeName();
                return true;
            }
            case 33: {
                pSDCMSPlatformNodeBase.resetRefCount();
                return true;
            }
            case 34: {
                pSDCMSPlatformNodeBase.resetRefInfo();
                return true;
            }
            case 35: {
                pSDCMSPlatformNodeBase.resetReplicated();
                return true;
            }
            case 36: {
                pSDCMSPlatformNodeBase.resetScale();
                return true;
            }
            case 37: {
                pSDCMSPlatformNodeBase.resetServiceId();
                return true;
            }
            case 38: {
                pSDCMSPlatformNodeBase.resetServiceName();
                return true;
            }
            case 39: {
                pSDCMSPlatformNodeBase.resetServiceUrl();
                return true;
            }
            case 40: {
                pSDCMSPlatformNodeBase.resetSSHIPAddr();
                return true;
            }
            case 41: {
                pSDCMSPlatformNodeBase.resetSSHPort();
                return true;
            }
            case 42: {
                pSDCMSPlatformNodeBase.resetUpdateDate();
                return true;
            }
            case 43: {
                pSDCMSPlatformNodeBase.resetUpdateMan();
                return true;
            }
            case 44: {
                pSDCMSPlatformNodeBase.resetUploadFileMode();
                return true;
            }
            case 45: {
                pSDCMSPlatformNodeBase.resetUploadPath();
                return true;
            }
            case 46: {
                pSDCMSPlatformNodeBase.resetUserName();
                return true;
            }
            case 47: {
                pSDCMSPlatformNodeBase.resetUserParams();
                return true;
            }
            case 48: {
                pSDCMSPlatformNodeBase.resetUserTag();
                return true;
            }
            case 49: {
                pSDCMSPlatformNodeBase.resetUserTag2();
                return true;
            }
            case 50: {
                pSDCMSPlatformNodeBase.resetUserTag3();
                return true;
            }
            case 51: {
                pSDCMSPlatformNodeBase.resetUserTag4();
                return true;
            }
            case 52: {
                pSDCMSPlatformNodeBase.resetValidFlag();
                return true;
            }
            case 53: {
                pSDCMSPlatformNodeBase.resetWorkshopPath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatform getPSDCMSPlatform() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatform();
        }
        if (this.getPSDCMSPlatformId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformLock;
        synchronized (n) {
            if (this.psdcmsplatform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformId(), (Object)this.psdcmsplatform.getPSDCMSPlatformId()) != 0L) {
                this.psdcmsplatform = null;
            }
            if (this.psdcmsplatform == null) {
                PSDCMSPlatform pSDCMSPlatform = new PSDCMSPlatform();
                pSDCMSPlatform.setPSDCMSPlatformId(this.getPSDCMSPlatformId());
                PSDCMSPlatformService pSDCMSPlatformService = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformService.autoGet((IEntity)pSDCMSPlatform);
                this.psdcmsplatform = pSDCMSPlatform;
            }
            return this.psdcmsplatform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryItem getPSDCRegistryItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItem();
        }
        if (this.getPSDCRegistryItemId() == null) {
            return null;
        }
        Integer n = this.objPSDCRegistryItemLock;
        synchronized (n) {
            if (this.psdcregistryitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRegistryItemId(), (Object)this.psdcregistryitem.getPSDCRegistryItemId()) != 0L) {
                this.psdcregistryitem = null;
            }
            if (this.psdcregistryitem == null) {
                PSDCRegistryItem pSDCRegistryItem = new PSDCRegistryItem();
                pSDCRegistryItem.setPSDCRegistryItemId(this.getPSDCRegistryItemId());
                PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryItemService.autoGet((IEntity)pSDCRegistryItem);
                this.psdcregistryitem = pSDCRegistryItem;
            }
            return this.psdcregistryitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMSPlatformNode getPSMSPlatformNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMSPlatformNode();
        }
        if (this.getPSMSPlatformNodeId() == null) {
            return null;
        }
        Integer n = this.objPSMSPlatformNodeLock;
        synchronized (n) {
            if (this.psmsplatformnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSMSPlatformNodeId(), (Object)this.psmsplatformnode.getPSMSPlatformNodeId()) != 0L) {
                this.psmsplatformnode = null;
            }
            if (this.psmsplatformnode == null) {
                PSMSPlatformNode pSMSPlatformNode = new PSMSPlatformNode();
                pSMSPlatformNode.setPSMSPlatformNodeId(this.getPSMSPlatformNodeId());
                PSMSPlatformNodeService pSMSPlatformNodeService = (PSMSPlatformNodeService)ServiceGlobal.getService(PSMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
                pSMSPlatformNodeService.autoGet((IEntity)pSMSPlatformNode);
                this.psmsplatformnode = pSMSPlatformNode;
            }
            return this.psmsplatformnode;
        }
    }

    private PSDCMSPlatformNodeBase getProxyEntity() {
        return this.proxyPSDCMSPlatformNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMSPlatformNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMSPlatformNodeBase) {
            this.proxyPSDCMSPlatformNodeBase = (PSDCMSPlatformNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CFGTYPE, 0);
        fieldIndexMap.put(FIELD_CONTAINERCFG, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DCREGISTRYITEMTAG, 4);
        fieldIndexMap.put(FIELD_DCREGISTRYITEMTAG2, 5);
        fieldIndexMap.put(FIELD_DCREGISTRYITEMTAG3, 6);
        fieldIndexMap.put(FIELD_DCREGISTRYITEMTAG4, 7);
        fieldIndexMap.put(FIELD_ENVPARAMS, 8);
        fieldIndexMap.put(FIELD_IPADDR, 9);
        fieldIndexMap.put(FIELD_IPADDR2, 10);
        fieldIndexMap.put(FIELD_MAXCPU, 11);
        fieldIndexMap.put(FIELD_MAXMEM, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_MINCPU, 14);
        fieldIndexMap.put(FIELD_MINMEM, 15);
        fieldIndexMap.put(FIELD_NODEINFO, 16);
        fieldIndexMap.put(FIELD_NODESTATE, 17);
        fieldIndexMap.put(FIELD_NODETAG, 18);
        fieldIndexMap.put(FIELD_NODETAG2, 19);
        fieldIndexMap.put(FIELD_PASSWD, 20);
        fieldIndexMap.put(FIELD_PORT, 21);
        fieldIndexMap.put(FIELD_PORT2, 22);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 23);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNAME, 24);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODEID, 25);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODENAME, 26);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMID, 27);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMNAME, 28);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 29);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 30);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNODEID, 31);
        fieldIndexMap.put(FIELD_PSMSPLATFORMNODENAME, 32);
        fieldIndexMap.put(FIELD_REFCOUNT, 33);
        fieldIndexMap.put(FIELD_REFINFO, 34);
        fieldIndexMap.put(FIELD_REPLICATED, 35);
        fieldIndexMap.put(FIELD_SCALE, 36);
        fieldIndexMap.put(FIELD_SERVICEID, 37);
        fieldIndexMap.put(FIELD_SERVICENAME, 38);
        fieldIndexMap.put(FIELD_SERVICEURL, 39);
        fieldIndexMap.put(FIELD_SSHIPADDR, 40);
        fieldIndexMap.put(FIELD_SSHPORT, 41);
        fieldIndexMap.put(FIELD_UPDATEDATE, 42);
        fieldIndexMap.put(FIELD_UPDATEMAN, 43);
        fieldIndexMap.put(FIELD_UPLOADFILEMODE, 44);
        fieldIndexMap.put(FIELD_UPLOADPATH, 45);
        fieldIndexMap.put(FIELD_USERNAME, 46);
        fieldIndexMap.put(FIELD_USERPARAMS, 47);
        fieldIndexMap.put(FIELD_USERTAG, 48);
        fieldIndexMap.put(FIELD_USERTAG2, 49);
        fieldIndexMap.put(FIELD_USERTAG3, 50);
        fieldIndexMap.put(FIELD_USERTAG4, 51);
        fieldIndexMap.put(FIELD_VALIDFLAG, 52);
        fieldIndexMap.put(FIELD_WORKSHOPPATH, 53);
    }
}

