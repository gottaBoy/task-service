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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdInstLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenter;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMobAppPackServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkshopServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdInstLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMobAppPackServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkshopServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSTaskServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSTaskServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVSYSDEPLOYMODE = "DEVSYSDEPLOYMODE";
    public static final String FIELD_DOMAINPARAMS = "DOMAINPARAMS";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_LICINFO = "LICINFO";
    public static final String FIELD_LICKEY = "LICKEY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NO2PSMOBAPPPSID = "NO2PSMOBAPPPSID";
    public static final String FIELD_NO2PSMOBAPPPSNAME = "NO2PSMOBAPPPSNAME";
    public static final String FIELD_PSCOREPRDID = "PSCOREPRDID";
    public static final String FIELD_PSCOREPRDNAME = "PSCOREPRDNAME";
    public static final String FIELD_PSCOREPRDVERID = "PSCOREPRDVERID";
    public static final String FIELD_PSCOREPRDVERNAME = "PSCOREPRDVERNAME";
    public static final String FIELD_PSDEPLOYCENTERID = "PSDEPLOYCENTERID";
    public static final String FIELD_PSDEPLOYCENTERNAME = "PSDEPLOYCENTERNAME";
    public static final String FIELD_PSMOBAPPPACKSERVERID = "PSMOBAPPPACKSERVERID";
    public static final String FIELD_PSMOBAPPPACKSERVERNAME = "PSMOBAPPPACKSERVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_PSWORKSHOPSERVERID = "PSWORKSHOPSERVERID";
    public static final String FIELD_PSWORKSHOPSERVERNAME = "PSWORKSHOPSERVERNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_SERVERURL = "SERVERURL";
    public static final String FIELD_SERVERURL2 = "SERVERURL2";
    public static final String FIELD_SERVERUSAGE = "SERVERUSAGE";
    public static final String FIELD_SYSVER = "SYSVER";
    public static final String FIELD_TSPARAMS = "TSPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEVSYSDEPLOYMODE = 2;
    private static final int INDEX_DOMAINPARAMS = 3;
    private static final int INDEX_IPADDR = 4;
    private static final int INDEX_IPADDR2 = 5;
    private static final int INDEX_LICINFO = 6;
    private static final int INDEX_LICKEY = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_NO2PSMOBAPPPSID = 9;
    private static final int INDEX_NO2PSMOBAPPPSNAME = 10;
    private static final int INDEX_PSCOREPRDID = 11;
    private static final int INDEX_PSCOREPRDNAME = 12;
    private static final int INDEX_PSCOREPRDVERID = 13;
    private static final int INDEX_PSCOREPRDVERNAME = 14;
    private static final int INDEX_PSDEPLOYCENTERID = 15;
    private static final int INDEX_PSDEPLOYCENTERNAME = 16;
    private static final int INDEX_PSMOBAPPPACKSERVERID = 17;
    private static final int INDEX_PSMOBAPPPACKSERVERNAME = 18;
    private static final int INDEX_PSSVRDOMAINID = 19;
    private static final int INDEX_PSSVRDOMAINNAME = 20;
    private static final int INDEX_PSTASKSERVERID = 21;
    private static final int INDEX_PSTASKSERVERNAME = 22;
    private static final int INDEX_PSWORKSHOPSERVERID = 23;
    private static final int INDEX_PSWORKSHOPSERVERNAME = 24;
    private static final int INDEX_REFINFO = 25;
    private static final int INDEX_SERVERURL = 26;
    private static final int INDEX_SERVERURL2 = 27;
    private static final int INDEX_SERVERUSAGE = 28;
    private static final int INDEX_SYSVER = 29;
    private static final int INDEX_TSPARAMS = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final int INDEX_VALIDFLAG = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSTaskServerBase proxyPSTaskServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean devsysdeploymodeDirtyFlag = false;
    private boolean domainparamsDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean licinfoDirtyFlag = false;
    private boolean lickeyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean no2psmobapppsidDirtyFlag = false;
    private boolean no2psmobapppsnameDirtyFlag = false;
    private boolean pscoreprdidDirtyFlag = false;
    private boolean pscoreprdnameDirtyFlag = false;
    private boolean pscoreprdveridDirtyFlag = false;
    private boolean pscoreprdvernameDirtyFlag = false;
    private boolean psdeploycenteridDirtyFlag = false;
    private boolean psdeploycenternameDirtyFlag = false;
    private boolean psmobapppackserveridDirtyFlag = false;
    private boolean psmobapppackservernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean psworkshopserveridDirtyFlag = false;
    private boolean psworkshopservernameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean serverurlDirtyFlag = false;
    private boolean serverurl2DirtyFlag = false;
    private boolean serverusageDirtyFlag = false;
    private boolean sysverDirtyFlag = false;
    private boolean tsparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="devsysdeploymode")
    private Integer devsysdeploymode;
    @Column(name="domainparams")
    private String domainparams;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="licinfo")
    private String licinfo;
    @Column(name="lickey")
    private String lickey;
    @Column(name="memo")
    private String memo;
    @Column(name="no2psmobapppsid")
    private String no2psmobapppsid;
    @Column(name="no2psmobapppsname")
    private String no2psmobapppsname;
    @Column(name="pscoreprdid")
    private String pscoreprdid;
    @Column(name="pscoreprdname")
    private String pscoreprdname;
    @Column(name="pscoreprdverid")
    private String pscoreprdverid;
    @Column(name="pscoreprdvername")
    private String pscoreprdvername;
    @Column(name="psdeploycenterid")
    private String psdeploycenterid;
    @Column(name="psdeploycentername")
    private String psdeploycentername;
    @Column(name="psmobapppackserverid")
    private String psmobapppackserverid;
    @Column(name="psmobapppackservername")
    private String psmobapppackservername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="psworkshopserverid")
    private String psworkshopserverid;
    @Column(name="psworkshopservername")
    private String psworkshopservername;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="serverurl")
    private String serverurl;
    @Column(name="serverurl2")
    private String serverurl2;
    @Column(name="serverusage")
    private String serverusage;
    @Column(name="sysver")
    private String sysver;
    @Column(name="tsparams")
    private String tsparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCorePrdVerLock = new Integer(1);
    private PSCorePrdVer pscoreprdver = null;
    private Integer objPSCorePrdLock = new Integer(1);
    private PSCorePrd pscoreprd = null;
    private Integer objPSDeployCenterLock = new Integer(1);
    private PSDeployCenter psdeploycenter = null;
    private Integer objNo2PSMobAppPSLock = new Integer(1);
    private PSMobAppPackServer no2psmobappps = null;
    private Integer objPSMobAppPackServerLock = new Integer(1);
    private PSMobAppPackServer psmobapppackserver = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSWorkshopServerLock = new Integer(1);
    private PSWorkshopServer psworkshopserver = null;
    private Integer objPSCorePrdInstLogsLock = new Integer(1);
    private ArrayList<PSCorePrdInstLog> pscoreprdinstlogs = null;

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

    public void setDevSysDeployMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevSysDeployMode(n);
            return;
        }
        this.devsysdeploymode = n;
        this.devsysdeploymodeDirtyFlag = true;
    }

    public Integer getDevSysDeployMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevSysDeployMode();
        }
        return this.devsysdeploymode;
    }

    public boolean isDevSysDeployModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevSysDeployModeDirty();
        }
        return this.devsysdeploymodeDirtyFlag;
    }

    public void resetDevSysDeployMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevSysDeployMode();
            return;
        }
        this.devsysdeploymodeDirtyFlag = false;
        this.devsysdeploymode = null;
    }

    public void setDomainParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainparams = string;
        this.domainparamsDirtyFlag = true;
    }

    public String getDomainParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParams();
        }
        return this.domainparams;
    }

    public boolean isDomainParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParamsDirty();
        }
        return this.domainparamsDirtyFlag;
    }

    public void resetDomainParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParams();
            return;
        }
        this.domainparamsDirtyFlag = false;
        this.domainparams = null;
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

    public void setLicInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLicInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.licinfo = string;
        this.licinfoDirtyFlag = true;
    }

    public String getLicInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLicInfo();
        }
        return this.licinfo;
    }

    public boolean isLicInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLicInfoDirty();
        }
        return this.licinfoDirtyFlag;
    }

    public void resetLicInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLicInfo();
            return;
        }
        this.licinfoDirtyFlag = false;
        this.licinfo = null;
    }

    public void setLicKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLicKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lickey = string;
        this.lickeyDirtyFlag = true;
    }

    public String getLicKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLicKey();
        }
        return this.lickey;
    }

    public boolean isLicKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLicKeyDirty();
        }
        return this.lickeyDirtyFlag;
    }

    public void resetLicKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLicKey();
            return;
        }
        this.lickeyDirtyFlag = false;
        this.lickey = null;
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

    public void setNo2PSMobAppPSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSMobAppPSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psmobapppsid = string;
        this.no2psmobapppsidDirtyFlag = true;
    }

    public String getNo2PSMobAppPSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSMobAppPSId();
        }
        return this.no2psmobapppsid;
    }

    public boolean isNo2PSMobAppPSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSMobAppPSIdDirty();
        }
        return this.no2psmobapppsidDirtyFlag;
    }

    public void resetNo2PSMobAppPSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSMobAppPSId();
            return;
        }
        this.no2psmobapppsidDirtyFlag = false;
        this.no2psmobapppsid = null;
    }

    public void setNo2PSMobAppPSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNo2PSMobAppPSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.no2psmobapppsname = string;
        this.no2psmobapppsnameDirtyFlag = true;
    }

    public String getNo2PSMobAppPSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSMobAppPSName();
        }
        return this.no2psmobapppsname;
    }

    public boolean isNo2PSMobAppPSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNo2PSMobAppPSNameDirty();
        }
        return this.no2psmobapppsnameDirtyFlag;
    }

    public void resetNo2PSMobAppPSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNo2PSMobAppPSName();
            return;
        }
        this.no2psmobapppsnameDirtyFlag = false;
        this.no2psmobapppsname = null;
    }

    public void setPSCorePrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdid = string;
        this.pscoreprdidDirtyFlag = true;
    }

    public String getPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdId();
        }
        return this.pscoreprdid;
    }

    public boolean isPSCorePrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIdDirty();
        }
        return this.pscoreprdidDirtyFlag;
    }

    public void resetPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdId();
            return;
        }
        this.pscoreprdidDirtyFlag = false;
        this.pscoreprdid = null;
    }

    public void setPSCorePrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdname = string;
        this.pscoreprdnameDirtyFlag = true;
    }

    public String getPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdName();
        }
        return this.pscoreprdname;
    }

    public boolean isPSCorePrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdNameDirty();
        }
        return this.pscoreprdnameDirtyFlag;
    }

    public void resetPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdName();
            return;
        }
        this.pscoreprdnameDirtyFlag = false;
        this.pscoreprdname = null;
    }

    public void setPSCorePrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdverid = string;
        this.pscoreprdveridDirtyFlag = true;
    }

    public String getPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerId();
        }
        return this.pscoreprdverid;
    }

    public boolean isPSCorePrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerIdDirty();
        }
        return this.pscoreprdveridDirtyFlag;
    }

    public void resetPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerId();
            return;
        }
        this.pscoreprdveridDirtyFlag = false;
        this.pscoreprdverid = null;
    }

    public void setPSCorePrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdvername = string;
        this.pscoreprdvernameDirtyFlag = true;
    }

    public String getPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerName();
        }
        return this.pscoreprdvername;
    }

    public boolean isPSCorePrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerNameDirty();
        }
        return this.pscoreprdvernameDirtyFlag;
    }

    public void resetPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerName();
            return;
        }
        this.pscoreprdvernameDirtyFlag = false;
        this.pscoreprdvername = null;
    }

    public void setPSDeployCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDeployCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeploycenterid = string;
        this.psdeploycenteridDirtyFlag = true;
    }

    public String getPSDeployCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenterId();
        }
        return this.psdeploycenterid;
    }

    public boolean isPSDeployCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDeployCenterIdDirty();
        }
        return this.psdeploycenteridDirtyFlag;
    }

    public void resetPSDeployCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDeployCenterId();
            return;
        }
        this.psdeploycenteridDirtyFlag = false;
        this.psdeploycenterid = null;
    }

    public void setPSDeployCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDeployCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeploycentername = string;
        this.psdeploycenternameDirtyFlag = true;
    }

    public String getPSDeployCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenterName();
        }
        return this.psdeploycentername;
    }

    public boolean isPSDeployCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDeployCenterNameDirty();
        }
        return this.psdeploycenternameDirtyFlag;
    }

    public void resetPSDeployCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDeployCenterName();
            return;
        }
        this.psdeploycenternameDirtyFlag = false;
        this.psdeploycentername = null;
    }

    public void setPSMobAppPackServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackserverid = string;
        this.psmobapppackserveridDirtyFlag = true;
    }

    public String getPSMobAppPackServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackServerId();
        }
        return this.psmobapppackserverid;
    }

    public boolean isPSMobAppPackServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackServerIdDirty();
        }
        return this.psmobapppackserveridDirtyFlag;
    }

    public void resetPSMobAppPackServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackServerId();
            return;
        }
        this.psmobapppackserveridDirtyFlag = false;
        this.psmobapppackserverid = null;
    }

    public void setPSMobAppPackServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackservername = string;
        this.psmobapppackservernameDirtyFlag = true;
    }

    public String getPSMobAppPackServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackServerName();
        }
        return this.psmobapppackservername;
    }

    public boolean isPSMobAppPackServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackServerNameDirty();
        }
        return this.psmobapppackservernameDirtyFlag;
    }

    public void resetPSMobAppPackServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackServerName();
            return;
        }
        this.psmobapppackservernameDirtyFlag = false;
        this.psmobapppackservername = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
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

    public void setPSWorkshopServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkshopServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkshopserverid = string;
        this.psworkshopserveridDirtyFlag = true;
    }

    public String getPSWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkshopServerId();
        }
        return this.psworkshopserverid;
    }

    public boolean isPSWorkshopServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkshopServerIdDirty();
        }
        return this.psworkshopserveridDirtyFlag;
    }

    public void resetPSWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkshopServerId();
            return;
        }
        this.psworkshopserveridDirtyFlag = false;
        this.psworkshopserverid = null;
    }

    public void setPSWorkshopServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkshopServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkshopservername = string;
        this.psworkshopservernameDirtyFlag = true;
    }

    public String getPSWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkshopServerName();
        }
        return this.psworkshopservername;
    }

    public boolean isPSWorkshopServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkshopServerNameDirty();
        }
        return this.psworkshopservernameDirtyFlag;
    }

    public void resetPSWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkshopServerName();
            return;
        }
        this.psworkshopservernameDirtyFlag = false;
        this.psworkshopservername = null;
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

    public void setServerUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverurl = string;
        this.serverurlDirtyFlag = true;
    }

    public String getServerUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerUrl();
        }
        return this.serverurl;
    }

    public boolean isServerUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerUrlDirty();
        }
        return this.serverurlDirtyFlag;
    }

    public void resetServerUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerUrl();
            return;
        }
        this.serverurlDirtyFlag = false;
        this.serverurl = null;
    }

    public void setServerUrl2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerUrl2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverurl2 = string;
        this.serverurl2DirtyFlag = true;
    }

    public String getServerUrl2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerUrl2();
        }
        return this.serverurl2;
    }

    public boolean isServerUrl2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerUrl2Dirty();
        }
        return this.serverurl2DirtyFlag;
    }

    public void resetServerUrl2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerUrl2();
            return;
        }
        this.serverurl2DirtyFlag = false;
        this.serverurl2 = null;
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

    public void setTSParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tsparams = string;
        this.tsparamsDirtyFlag = true;
    }

    public String getTSParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSParams();
        }
        return this.tsparams;
    }

    public boolean isTSParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSParamsDirty();
        }
        return this.tsparamsDirtyFlag;
    }

    public void resetTSParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSParams();
            return;
        }
        this.tsparamsDirtyFlag = false;
        this.tsparams = null;
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
        PSTaskServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSTaskServerBase pSTaskServerBase) {
        pSTaskServerBase.resetCreateDate();
        pSTaskServerBase.resetCreateMan();
        pSTaskServerBase.resetDevSysDeployMode();
        pSTaskServerBase.resetDomainParams();
        pSTaskServerBase.resetIpAddr();
        pSTaskServerBase.resetIpAddr2();
        pSTaskServerBase.resetLicInfo();
        pSTaskServerBase.resetLicKey();
        pSTaskServerBase.resetMemo();
        pSTaskServerBase.resetNo2PSMobAppPSId();
        pSTaskServerBase.resetNo2PSMobAppPSName();
        pSTaskServerBase.resetPSCorePrdId();
        pSTaskServerBase.resetPSCorePrdName();
        pSTaskServerBase.resetPSCorePrdVerId();
        pSTaskServerBase.resetPSCorePrdVerName();
        pSTaskServerBase.resetPSDeployCenterId();
        pSTaskServerBase.resetPSDeployCenterName();
        pSTaskServerBase.resetPSMobAppPackServerId();
        pSTaskServerBase.resetPSMobAppPackServerName();
        pSTaskServerBase.resetPSSvrDomainId();
        pSTaskServerBase.resetPSSvrDomainName();
        pSTaskServerBase.resetPSTaskServerId();
        pSTaskServerBase.resetPSTaskServerName();
        pSTaskServerBase.resetPSWorkshopServerId();
        pSTaskServerBase.resetPSWorkshopServerName();
        pSTaskServerBase.resetRefInfo();
        pSTaskServerBase.resetServerUrl();
        pSTaskServerBase.resetServerUrl2();
        pSTaskServerBase.resetServerUsage();
        pSTaskServerBase.resetSysVer();
        pSTaskServerBase.resetTSParams();
        pSTaskServerBase.resetUpdateDate();
        pSTaskServerBase.resetUpdateMan();
        pSTaskServerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDevSysDeployModeDirty()) {
            hashMap.put(FIELD_DEVSYSDEPLOYMODE, this.getDevSysDeployMode());
        }
        if (!bl || this.isDomainParamsDirty()) {
            hashMap.put(FIELD_DOMAINPARAMS, this.getDomainParams());
        }
        if (!bl || this.isIpAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIpAddr());
        }
        if (!bl || this.isIpAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIpAddr2());
        }
        if (!bl || this.isLicInfoDirty()) {
            hashMap.put(FIELD_LICINFO, this.getLicInfo());
        }
        if (!bl || this.isLicKeyDirty()) {
            hashMap.put(FIELD_LICKEY, this.getLicKey());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNo2PSMobAppPSIdDirty()) {
            hashMap.put(FIELD_NO2PSMOBAPPPSID, this.getNo2PSMobAppPSId());
        }
        if (!bl || this.isNo2PSMobAppPSNameDirty()) {
            hashMap.put(FIELD_NO2PSMOBAPPPSNAME, this.getNo2PSMobAppPSName());
        }
        if (!bl || this.isPSCorePrdIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDID, this.getPSCorePrdId());
        }
        if (!bl || this.isPSCorePrdNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDNAME, this.getPSCorePrdName());
        }
        if (!bl || this.isPSCorePrdVerIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERID, this.getPSCorePrdVerId());
        }
        if (!bl || this.isPSCorePrdVerNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERNAME, this.getPSCorePrdVerName());
        }
        if (!bl || this.isPSDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDEPLOYCENTERID, this.getPSDeployCenterId());
        }
        if (!bl || this.isPSDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDEPLOYCENTERNAME, this.getPSDeployCenterName());
        }
        if (!bl || this.isPSMobAppPackServerIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKSERVERID, this.getPSMobAppPackServerId());
        }
        if (!bl || this.isPSMobAppPackServerNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKSERVERNAME, this.getPSMobAppPackServerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isPSWorkshopServerIdDirty()) {
            hashMap.put(FIELD_PSWORKSHOPSERVERID, this.getPSWorkshopServerId());
        }
        if (!bl || this.isPSWorkshopServerNameDirty()) {
            hashMap.put(FIELD_PSWORKSHOPSERVERNAME, this.getPSWorkshopServerName());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isServerUrlDirty()) {
            hashMap.put(FIELD_SERVERURL, this.getServerUrl());
        }
        if (!bl || this.isServerUrl2Dirty()) {
            hashMap.put(FIELD_SERVERURL2, this.getServerUrl2());
        }
        if (!bl || this.isServerUsageDirty()) {
            hashMap.put(FIELD_SERVERUSAGE, this.getServerUsage());
        }
        if (!bl || this.isSysVerDirty()) {
            hashMap.put(FIELD_SYSVER, this.getSysVer());
        }
        if (!bl || this.isTSParamsDirty()) {
            hashMap.put(FIELD_TSPARAMS, this.getTSParams());
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
        return PSTaskServerBase.get(this, n);
    }

    private static Object get(PSTaskServerBase pSTaskServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTaskServerBase.getCreateDate();
            }
            case 1: {
                return pSTaskServerBase.getCreateMan();
            }
            case 2: {
                return pSTaskServerBase.getDevSysDeployMode();
            }
            case 3: {
                return pSTaskServerBase.getDomainParams();
            }
            case 4: {
                return pSTaskServerBase.getIpAddr();
            }
            case 5: {
                return pSTaskServerBase.getIpAddr2();
            }
            case 6: {
                return pSTaskServerBase.getLicInfo();
            }
            case 7: {
                return pSTaskServerBase.getLicKey();
            }
            case 8: {
                return pSTaskServerBase.getMemo();
            }
            case 9: {
                return pSTaskServerBase.getNo2PSMobAppPSId();
            }
            case 10: {
                return pSTaskServerBase.getNo2PSMobAppPSName();
            }
            case 11: {
                return pSTaskServerBase.getPSCorePrdId();
            }
            case 12: {
                return pSTaskServerBase.getPSCorePrdName();
            }
            case 13: {
                return pSTaskServerBase.getPSCorePrdVerId();
            }
            case 14: {
                return pSTaskServerBase.getPSCorePrdVerName();
            }
            case 15: {
                return pSTaskServerBase.getPSDeployCenterId();
            }
            case 16: {
                return pSTaskServerBase.getPSDeployCenterName();
            }
            case 17: {
                return pSTaskServerBase.getPSMobAppPackServerId();
            }
            case 18: {
                return pSTaskServerBase.getPSMobAppPackServerName();
            }
            case 19: {
                return pSTaskServerBase.getPSSvrDomainId();
            }
            case 20: {
                return pSTaskServerBase.getPSSvrDomainName();
            }
            case 21: {
                return pSTaskServerBase.getPSTaskServerId();
            }
            case 22: {
                return pSTaskServerBase.getPSTaskServerName();
            }
            case 23: {
                return pSTaskServerBase.getPSWorkshopServerId();
            }
            case 24: {
                return pSTaskServerBase.getPSWorkshopServerName();
            }
            case 25: {
                return pSTaskServerBase.getRefInfo();
            }
            case 26: {
                return pSTaskServerBase.getServerUrl();
            }
            case 27: {
                return pSTaskServerBase.getServerUrl2();
            }
            case 28: {
                return pSTaskServerBase.getServerUsage();
            }
            case 29: {
                return pSTaskServerBase.getSysVer();
            }
            case 30: {
                return pSTaskServerBase.getTSParams();
            }
            case 31: {
                return pSTaskServerBase.getUpdateDate();
            }
            case 32: {
                return pSTaskServerBase.getUpdateMan();
            }
            case 33: {
                return pSTaskServerBase.getValidFlag();
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
        PSTaskServerBase.set(this, n, object);
    }

    private static void set(PSTaskServerBase pSTaskServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSTaskServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSTaskServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSTaskServerBase.setDevSysDeployMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSTaskServerBase.setDomainParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSTaskServerBase.setIpAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSTaskServerBase.setIpAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSTaskServerBase.setLicInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSTaskServerBase.setLicKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSTaskServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSTaskServerBase.setNo2PSMobAppPSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSTaskServerBase.setNo2PSMobAppPSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSTaskServerBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSTaskServerBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSTaskServerBase.setPSCorePrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSTaskServerBase.setPSCorePrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSTaskServerBase.setPSDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSTaskServerBase.setPSDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSTaskServerBase.setPSMobAppPackServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSTaskServerBase.setPSMobAppPackServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSTaskServerBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSTaskServerBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSTaskServerBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSTaskServerBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSTaskServerBase.setPSWorkshopServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSTaskServerBase.setPSWorkshopServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSTaskServerBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSTaskServerBase.setServerUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSTaskServerBase.setServerUrl2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSTaskServerBase.setServerUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSTaskServerBase.setSysVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSTaskServerBase.setTSParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSTaskServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSTaskServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSTaskServerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSTaskServerBase.isNull(this, n);
    }

    private static boolean isNull(PSTaskServerBase pSTaskServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTaskServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSTaskServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSTaskServerBase.getDevSysDeployMode() == null;
            }
            case 3: {
                return pSTaskServerBase.getDomainParams() == null;
            }
            case 4: {
                return pSTaskServerBase.getIpAddr() == null;
            }
            case 5: {
                return pSTaskServerBase.getIpAddr2() == null;
            }
            case 6: {
                return pSTaskServerBase.getLicInfo() == null;
            }
            case 7: {
                return pSTaskServerBase.getLicKey() == null;
            }
            case 8: {
                return pSTaskServerBase.getMemo() == null;
            }
            case 9: {
                return pSTaskServerBase.getNo2PSMobAppPSId() == null;
            }
            case 10: {
                return pSTaskServerBase.getNo2PSMobAppPSName() == null;
            }
            case 11: {
                return pSTaskServerBase.getPSCorePrdId() == null;
            }
            case 12: {
                return pSTaskServerBase.getPSCorePrdName() == null;
            }
            case 13: {
                return pSTaskServerBase.getPSCorePrdVerId() == null;
            }
            case 14: {
                return pSTaskServerBase.getPSCorePrdVerName() == null;
            }
            case 15: {
                return pSTaskServerBase.getPSDeployCenterId() == null;
            }
            case 16: {
                return pSTaskServerBase.getPSDeployCenterName() == null;
            }
            case 17: {
                return pSTaskServerBase.getPSMobAppPackServerId() == null;
            }
            case 18: {
                return pSTaskServerBase.getPSMobAppPackServerName() == null;
            }
            case 19: {
                return pSTaskServerBase.getPSSvrDomainId() == null;
            }
            case 20: {
                return pSTaskServerBase.getPSSvrDomainName() == null;
            }
            case 21: {
                return pSTaskServerBase.getPSTaskServerId() == null;
            }
            case 22: {
                return pSTaskServerBase.getPSTaskServerName() == null;
            }
            case 23: {
                return pSTaskServerBase.getPSWorkshopServerId() == null;
            }
            case 24: {
                return pSTaskServerBase.getPSWorkshopServerName() == null;
            }
            case 25: {
                return pSTaskServerBase.getRefInfo() == null;
            }
            case 26: {
                return pSTaskServerBase.getServerUrl() == null;
            }
            case 27: {
                return pSTaskServerBase.getServerUrl2() == null;
            }
            case 28: {
                return pSTaskServerBase.getServerUsage() == null;
            }
            case 29: {
                return pSTaskServerBase.getSysVer() == null;
            }
            case 30: {
                return pSTaskServerBase.getTSParams() == null;
            }
            case 31: {
                return pSTaskServerBase.getUpdateDate() == null;
            }
            case 32: {
                return pSTaskServerBase.getUpdateMan() == null;
            }
            case 33: {
                return pSTaskServerBase.getValidFlag() == null;
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
        return PSTaskServerBase.contains(this, n);
    }

    private static boolean contains(PSTaskServerBase pSTaskServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTaskServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSTaskServerBase.isCreateManDirty();
            }
            case 2: {
                return pSTaskServerBase.isDevSysDeployModeDirty();
            }
            case 3: {
                return pSTaskServerBase.isDomainParamsDirty();
            }
            case 4: {
                return pSTaskServerBase.isIpAddrDirty();
            }
            case 5: {
                return pSTaskServerBase.isIpAddr2Dirty();
            }
            case 6: {
                return pSTaskServerBase.isLicInfoDirty();
            }
            case 7: {
                return pSTaskServerBase.isLicKeyDirty();
            }
            case 8: {
                return pSTaskServerBase.isMemoDirty();
            }
            case 9: {
                return pSTaskServerBase.isNo2PSMobAppPSIdDirty();
            }
            case 10: {
                return pSTaskServerBase.isNo2PSMobAppPSNameDirty();
            }
            case 11: {
                return pSTaskServerBase.isPSCorePrdIdDirty();
            }
            case 12: {
                return pSTaskServerBase.isPSCorePrdNameDirty();
            }
            case 13: {
                return pSTaskServerBase.isPSCorePrdVerIdDirty();
            }
            case 14: {
                return pSTaskServerBase.isPSCorePrdVerNameDirty();
            }
            case 15: {
                return pSTaskServerBase.isPSDeployCenterIdDirty();
            }
            case 16: {
                return pSTaskServerBase.isPSDeployCenterNameDirty();
            }
            case 17: {
                return pSTaskServerBase.isPSMobAppPackServerIdDirty();
            }
            case 18: {
                return pSTaskServerBase.isPSMobAppPackServerNameDirty();
            }
            case 19: {
                return pSTaskServerBase.isPSSvrDomainIdDirty();
            }
            case 20: {
                return pSTaskServerBase.isPSSvrDomainNameDirty();
            }
            case 21: {
                return pSTaskServerBase.isPSTaskServerIdDirty();
            }
            case 22: {
                return pSTaskServerBase.isPSTaskServerNameDirty();
            }
            case 23: {
                return pSTaskServerBase.isPSWorkshopServerIdDirty();
            }
            case 24: {
                return pSTaskServerBase.isPSWorkshopServerNameDirty();
            }
            case 25: {
                return pSTaskServerBase.isRefInfoDirty();
            }
            case 26: {
                return pSTaskServerBase.isServerUrlDirty();
            }
            case 27: {
                return pSTaskServerBase.isServerUrl2Dirty();
            }
            case 28: {
                return pSTaskServerBase.isServerUsageDirty();
            }
            case 29: {
                return pSTaskServerBase.isSysVerDirty();
            }
            case 30: {
                return pSTaskServerBase.isTSParamsDirty();
            }
            case 31: {
                return pSTaskServerBase.isUpdateDateDirty();
            }
            case 32: {
                return pSTaskServerBase.isUpdateManDirty();
            }
            case 33: {
                return pSTaskServerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSTaskServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSTaskServerBase pSTaskServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSTaskServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getDevSysDeployMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devsysdeploymode", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getDevSysDeployMode()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getDomainParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparams", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getDomainParams()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getIpAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getIpAddr()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getIpAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getIpAddr2()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getLicInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"licinfo", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getLicInfo()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getLicKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lickey", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getLicKey()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getNo2PSMobAppPSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psmobapppsid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getNo2PSMobAppPSId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getNo2PSMobAppPSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"no2psmobapppsname", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getNo2PSMobAppPSName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSCorePrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdverid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSCorePrdVerId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSCorePrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdvername", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSCorePrdVerName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycenterid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSDeployCenterId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeploycentername", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSDeployCenterName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSMobAppPackServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackserverid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSMobAppPackServerId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSMobAppPackServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackservername", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSMobAppPackServerName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSWorkshopServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkshopserverid", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSWorkshopServerId()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getPSWorkshopServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkshopservername", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getPSWorkshopServerName()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getServerUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getServerUrl()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getServerUrl2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl2", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getServerUrl2()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getServerUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverusage", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getServerUsage()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getSysVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysver", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getSysVer()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getTSParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tsparams", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getTSParams()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSTaskServerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSTaskServerBase.getJSONValue((Object)pSTaskServerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSTaskServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSTaskServerBase pSTaskServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSTaskServerBase.getCreateDate() != null) {
            object = pSTaskServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTaskServerBase.getCreateMan() != null) {
            object = pSTaskServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getDevSysDeployMode() != null) {
            object = pSTaskServerBase.getDevSysDeployMode();
            xmlNode.setAttribute(FIELD_DEVSYSDEPLOYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSTaskServerBase.getDomainParams() != null) {
            object = pSTaskServerBase.getDomainParams();
            xmlNode.setAttribute(FIELD_DOMAINPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getIpAddr() != null) {
            object = pSTaskServerBase.getIpAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getIpAddr2() != null) {
            object = pSTaskServerBase.getIpAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getLicInfo() != null) {
            object = pSTaskServerBase.getLicInfo();
            xmlNode.setAttribute(FIELD_LICINFO, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getLicKey() != null) {
            object = pSTaskServerBase.getLicKey();
            xmlNode.setAttribute(FIELD_LICKEY, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getMemo() != null) {
            object = pSTaskServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getNo2PSMobAppPSId() != null) {
            object = pSTaskServerBase.getNo2PSMobAppPSId();
            xmlNode.setAttribute(FIELD_NO2PSMOBAPPPSID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getNo2PSMobAppPSName() != null) {
            object = pSTaskServerBase.getNo2PSMobAppPSName();
            xmlNode.setAttribute(FIELD_NO2PSMOBAPPPSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSCorePrdId() != null) {
            object = pSTaskServerBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSCorePrdName() != null) {
            object = pSTaskServerBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSCorePrdVerId() != null) {
            object = pSTaskServerBase.getPSCorePrdVerId();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSCorePrdVerName() != null) {
            object = pSTaskServerBase.getPSCorePrdVerName();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSDeployCenterId() != null) {
            object = pSTaskServerBase.getPSDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSDeployCenterName() != null) {
            object = pSTaskServerBase.getPSDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSMobAppPackServerId() != null) {
            object = pSTaskServerBase.getPSMobAppPackServerId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSMobAppPackServerName() != null) {
            object = pSTaskServerBase.getPSMobAppPackServerName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSSvrDomainId() != null) {
            object = pSTaskServerBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSSvrDomainName() != null) {
            object = pSTaskServerBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSTaskServerId() != null) {
            object = pSTaskServerBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSTaskServerName() != null) {
            object = pSTaskServerBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSWorkshopServerId() != null) {
            object = pSTaskServerBase.getPSWorkshopServerId();
            xmlNode.setAttribute(FIELD_PSWORKSHOPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getPSWorkshopServerName() != null) {
            object = pSTaskServerBase.getPSWorkshopServerName();
            xmlNode.setAttribute(FIELD_PSWORKSHOPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getRefInfo() != null) {
            object = pSTaskServerBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getServerUrl() != null) {
            object = pSTaskServerBase.getServerUrl();
            xmlNode.setAttribute(FIELD_SERVERURL, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getServerUrl2() != null) {
            object = pSTaskServerBase.getServerUrl2();
            xmlNode.setAttribute(FIELD_SERVERURL2, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getServerUsage() != null) {
            object = pSTaskServerBase.getServerUsage();
            xmlNode.setAttribute(FIELD_SERVERUSAGE, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getSysVer() != null) {
            object = pSTaskServerBase.getSysVer();
            xmlNode.setAttribute(FIELD_SYSVER, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getTSParams() != null) {
            object = pSTaskServerBase.getTSParams();
            xmlNode.setAttribute(FIELD_TSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getUpdateDate() != null) {
            object = pSTaskServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTaskServerBase.getUpdateMan() != null) {
            object = pSTaskServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSTaskServerBase.getValidFlag() != null) {
            object = pSTaskServerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSTaskServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSTaskServerBase pSTaskServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSTaskServerBase.isCreateDateDirty() && (bl || pSTaskServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSTaskServerBase.getCreateDate());
        }
        if (pSTaskServerBase.isCreateManDirty() && (bl || pSTaskServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSTaskServerBase.getCreateMan());
        }
        if (pSTaskServerBase.isDevSysDeployModeDirty() && (bl || pSTaskServerBase.getDevSysDeployMode() != null)) {
            iDataObject.set(FIELD_DEVSYSDEPLOYMODE, (Object)pSTaskServerBase.getDevSysDeployMode());
        }
        if (pSTaskServerBase.isDomainParamsDirty() && (bl || pSTaskServerBase.getDomainParams() != null)) {
            iDataObject.set(FIELD_DOMAINPARAMS, (Object)pSTaskServerBase.getDomainParams());
        }
        if (pSTaskServerBase.isIpAddrDirty() && (bl || pSTaskServerBase.getIpAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSTaskServerBase.getIpAddr());
        }
        if (pSTaskServerBase.isIpAddr2Dirty() && (bl || pSTaskServerBase.getIpAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSTaskServerBase.getIpAddr2());
        }
        if (pSTaskServerBase.isLicInfoDirty() && (bl || pSTaskServerBase.getLicInfo() != null)) {
            iDataObject.set(FIELD_LICINFO, (Object)pSTaskServerBase.getLicInfo());
        }
        if (pSTaskServerBase.isLicKeyDirty() && (bl || pSTaskServerBase.getLicKey() != null)) {
            iDataObject.set(FIELD_LICKEY, (Object)pSTaskServerBase.getLicKey());
        }
        if (pSTaskServerBase.isMemoDirty() && (bl || pSTaskServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSTaskServerBase.getMemo());
        }
        if (pSTaskServerBase.isNo2PSMobAppPSIdDirty() && (bl || pSTaskServerBase.getNo2PSMobAppPSId() != null)) {
            iDataObject.set(FIELD_NO2PSMOBAPPPSID, (Object)pSTaskServerBase.getNo2PSMobAppPSId());
        }
        if (pSTaskServerBase.isNo2PSMobAppPSNameDirty() && (bl || pSTaskServerBase.getNo2PSMobAppPSName() != null)) {
            iDataObject.set(FIELD_NO2PSMOBAPPPSNAME, (Object)pSTaskServerBase.getNo2PSMobAppPSName());
        }
        if (pSTaskServerBase.isPSCorePrdIdDirty() && (bl || pSTaskServerBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSTaskServerBase.getPSCorePrdId());
        }
        if (pSTaskServerBase.isPSCorePrdNameDirty() && (bl || pSTaskServerBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSTaskServerBase.getPSCorePrdName());
        }
        if (pSTaskServerBase.isPSCorePrdVerIdDirty() && (bl || pSTaskServerBase.getPSCorePrdVerId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERID, (Object)pSTaskServerBase.getPSCorePrdVerId());
        }
        if (pSTaskServerBase.isPSCorePrdVerNameDirty() && (bl || pSTaskServerBase.getPSCorePrdVerName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERNAME, (Object)pSTaskServerBase.getPSCorePrdVerName());
        }
        if (pSTaskServerBase.isPSDeployCenterIdDirty() && (bl || pSTaskServerBase.getPSDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERID, (Object)pSTaskServerBase.getPSDeployCenterId());
        }
        if (pSTaskServerBase.isPSDeployCenterNameDirty() && (bl || pSTaskServerBase.getPSDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDEPLOYCENTERNAME, (Object)pSTaskServerBase.getPSDeployCenterName());
        }
        if (pSTaskServerBase.isPSMobAppPackServerIdDirty() && (bl || pSTaskServerBase.getPSMobAppPackServerId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKSERVERID, (Object)pSTaskServerBase.getPSMobAppPackServerId());
        }
        if (pSTaskServerBase.isPSMobAppPackServerNameDirty() && (bl || pSTaskServerBase.getPSMobAppPackServerName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKSERVERNAME, (Object)pSTaskServerBase.getPSMobAppPackServerName());
        }
        if (pSTaskServerBase.isPSSvrDomainIdDirty() && (bl || pSTaskServerBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSTaskServerBase.getPSSvrDomainId());
        }
        if (pSTaskServerBase.isPSSvrDomainNameDirty() && (bl || pSTaskServerBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSTaskServerBase.getPSSvrDomainName());
        }
        if (pSTaskServerBase.isPSTaskServerIdDirty() && (bl || pSTaskServerBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSTaskServerBase.getPSTaskServerId());
        }
        if (pSTaskServerBase.isPSTaskServerNameDirty() && (bl || pSTaskServerBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSTaskServerBase.getPSTaskServerName());
        }
        if (pSTaskServerBase.isPSWorkshopServerIdDirty() && (bl || pSTaskServerBase.getPSWorkshopServerId() != null)) {
            iDataObject.set(FIELD_PSWORKSHOPSERVERID, (Object)pSTaskServerBase.getPSWorkshopServerId());
        }
        if (pSTaskServerBase.isPSWorkshopServerNameDirty() && (bl || pSTaskServerBase.getPSWorkshopServerName() != null)) {
            iDataObject.set(FIELD_PSWORKSHOPSERVERNAME, (Object)pSTaskServerBase.getPSWorkshopServerName());
        }
        if (pSTaskServerBase.isRefInfoDirty() && (bl || pSTaskServerBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSTaskServerBase.getRefInfo());
        }
        if (pSTaskServerBase.isServerUrlDirty() && (bl || pSTaskServerBase.getServerUrl() != null)) {
            iDataObject.set(FIELD_SERVERURL, (Object)pSTaskServerBase.getServerUrl());
        }
        if (pSTaskServerBase.isServerUrl2Dirty() && (bl || pSTaskServerBase.getServerUrl2() != null)) {
            iDataObject.set(FIELD_SERVERURL2, (Object)pSTaskServerBase.getServerUrl2());
        }
        if (pSTaskServerBase.isServerUsageDirty() && (bl || pSTaskServerBase.getServerUsage() != null)) {
            iDataObject.set(FIELD_SERVERUSAGE, (Object)pSTaskServerBase.getServerUsage());
        }
        if (pSTaskServerBase.isSysVerDirty() && (bl || pSTaskServerBase.getSysVer() != null)) {
            iDataObject.set(FIELD_SYSVER, (Object)pSTaskServerBase.getSysVer());
        }
        if (pSTaskServerBase.isTSParamsDirty() && (bl || pSTaskServerBase.getTSParams() != null)) {
            iDataObject.set(FIELD_TSPARAMS, (Object)pSTaskServerBase.getTSParams());
        }
        if (pSTaskServerBase.isUpdateDateDirty() && (bl || pSTaskServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSTaskServerBase.getUpdateDate());
        }
        if (pSTaskServerBase.isUpdateManDirty() && (bl || pSTaskServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSTaskServerBase.getUpdateMan());
        }
        if (pSTaskServerBase.isValidFlagDirty() && (bl || pSTaskServerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSTaskServerBase.getValidFlag());
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
        return PSTaskServerBase.remove(this, n);
    }

    private static boolean remove(PSTaskServerBase pSTaskServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSTaskServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSTaskServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSTaskServerBase.resetDevSysDeployMode();
                return true;
            }
            case 3: {
                pSTaskServerBase.resetDomainParams();
                return true;
            }
            case 4: {
                pSTaskServerBase.resetIpAddr();
                return true;
            }
            case 5: {
                pSTaskServerBase.resetIpAddr2();
                return true;
            }
            case 6: {
                pSTaskServerBase.resetLicInfo();
                return true;
            }
            case 7: {
                pSTaskServerBase.resetLicKey();
                return true;
            }
            case 8: {
                pSTaskServerBase.resetMemo();
                return true;
            }
            case 9: {
                pSTaskServerBase.resetNo2PSMobAppPSId();
                return true;
            }
            case 10: {
                pSTaskServerBase.resetNo2PSMobAppPSName();
                return true;
            }
            case 11: {
                pSTaskServerBase.resetPSCorePrdId();
                return true;
            }
            case 12: {
                pSTaskServerBase.resetPSCorePrdName();
                return true;
            }
            case 13: {
                pSTaskServerBase.resetPSCorePrdVerId();
                return true;
            }
            case 14: {
                pSTaskServerBase.resetPSCorePrdVerName();
                return true;
            }
            case 15: {
                pSTaskServerBase.resetPSDeployCenterId();
                return true;
            }
            case 16: {
                pSTaskServerBase.resetPSDeployCenterName();
                return true;
            }
            case 17: {
                pSTaskServerBase.resetPSMobAppPackServerId();
                return true;
            }
            case 18: {
                pSTaskServerBase.resetPSMobAppPackServerName();
                return true;
            }
            case 19: {
                pSTaskServerBase.resetPSSvrDomainId();
                return true;
            }
            case 20: {
                pSTaskServerBase.resetPSSvrDomainName();
                return true;
            }
            case 21: {
                pSTaskServerBase.resetPSTaskServerId();
                return true;
            }
            case 22: {
                pSTaskServerBase.resetPSTaskServerName();
                return true;
            }
            case 23: {
                pSTaskServerBase.resetPSWorkshopServerId();
                return true;
            }
            case 24: {
                pSTaskServerBase.resetPSWorkshopServerName();
                return true;
            }
            case 25: {
                pSTaskServerBase.resetRefInfo();
                return true;
            }
            case 26: {
                pSTaskServerBase.resetServerUrl();
                return true;
            }
            case 27: {
                pSTaskServerBase.resetServerUrl2();
                return true;
            }
            case 28: {
                pSTaskServerBase.resetServerUsage();
                return true;
            }
            case 29: {
                pSTaskServerBase.resetSysVer();
                return true;
            }
            case 30: {
                pSTaskServerBase.resetTSParams();
                return true;
            }
            case 31: {
                pSTaskServerBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSTaskServerBase.resetUpdateMan();
                return true;
            }
            case 33: {
                pSTaskServerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdVer getPSCorePrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVer();
        }
        if (this.getPSCorePrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdVerLock;
        synchronized (n) {
            if (this.pscoreprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdVerId(), (Object)this.pscoreprdver.getPSCorePrdVerId()) != 0L) {
                this.pscoreprdver = null;
            }
            if (this.pscoreprdver == null) {
                PSCorePrdVer pSCorePrdVer = new PSCorePrdVer();
                pSCorePrdVer.setPSCorePrdVerId(this.getPSCorePrdVerId());
                PSCorePrdVerService pSCorePrdVerService = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdVerService.autoGet(pSCorePrdVer);
                this.pscoreprdver = pSCorePrdVer;
            }
            return this.pscoreprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrd getPSCorePrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrd();
        }
        if (this.getPSCorePrdId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdLock;
        synchronized (n) {
            if (this.pscoreprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdId(), (Object)this.pscoreprd.getPSCorePrdId()) != 0L) {
                this.pscoreprd = null;
            }
            if (this.pscoreprd == null) {
                PSCorePrd pSCorePrd = new PSCorePrd();
                pSCorePrd.setPSCorePrdId(this.getPSCorePrdId());
                PSCorePrdService pSCorePrdService = (PSCorePrdService)ServiceGlobal.getService(PSCorePrdService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdService.autoGet(pSCorePrd);
                this.pscoreprd = pSCorePrd;
            }
            return this.pscoreprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDeployCenter getPSDeployCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDeployCenter();
        }
        if (this.getPSDeployCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDeployCenterLock;
        synchronized (n) {
            if (this.psdeploycenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDeployCenterId(), (Object)this.psdeploycenter.getPSDeployCenterId()) != 0L) {
                this.psdeploycenter = null;
            }
            if (this.psdeploycenter == null) {
                PSDeployCenter pSDeployCenter = new PSDeployCenter();
                pSDeployCenter.setPSDeployCenterId(this.getPSDeployCenterId());
                PSDeployCenterService pSDeployCenterService = (PSDeployCenterService)ServiceGlobal.getService(PSDeployCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDeployCenterService.autoGet(pSDeployCenter);
                this.psdeploycenter = pSDeployCenter;
            }
            return this.psdeploycenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMobAppPackServer getNo2PSMobAppPS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNo2PSMobAppPS();
        }
        if (this.getNo2PSMobAppPSId() == null) {
            return null;
        }
        Integer n = this.objNo2PSMobAppPSLock;
        synchronized (n) {
            if (this.no2psmobappps != null && DataTypeHelper.compare((int)25, (Object)this.getNo2PSMobAppPSId(), (Object)this.no2psmobappps.getPSMobAppPackServerId()) != 0L) {
                this.no2psmobappps = null;
            }
            if (this.no2psmobappps == null) {
                PSMobAppPackServer pSMobAppPackServer = new PSMobAppPackServer();
                pSMobAppPackServer.setPSMobAppPackServerId(this.getNo2PSMobAppPSId());
                PSMobAppPackServerService pSMobAppPackServerService = (PSMobAppPackServerService)ServiceGlobal.getService(PSMobAppPackServerService.class, (SessionFactory)this.getSessionFactory());
                pSMobAppPackServerService.autoGet(pSMobAppPackServer);
                this.no2psmobappps = pSMobAppPackServer;
            }
            return this.no2psmobappps;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMobAppPackServer getPSMobAppPackServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackServer();
        }
        if (this.getPSMobAppPackServerId() == null) {
            return null;
        }
        Integer n = this.objPSMobAppPackServerLock;
        synchronized (n) {
            if (this.psmobapppackserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSMobAppPackServerId(), (Object)this.psmobapppackserver.getPSMobAppPackServerId()) != 0L) {
                this.psmobapppackserver = null;
            }
            if (this.psmobapppackserver == null) {
                PSMobAppPackServer pSMobAppPackServer = new PSMobAppPackServer();
                pSMobAppPackServer.setPSMobAppPackServerId(this.getPSMobAppPackServerId());
                PSMobAppPackServerService pSMobAppPackServerService = (PSMobAppPackServerService)ServiceGlobal.getService(PSMobAppPackServerService.class, (SessionFactory)this.getSessionFactory());
                pSMobAppPackServerService.autoGet(pSMobAppPackServer);
                this.psmobapppackserver = pSMobAppPackServer;
            }
            return this.psmobapppackserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkshopServer getPSWorkshopServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkshopServer();
        }
        if (this.getPSWorkshopServerId() == null) {
            return null;
        }
        Integer n = this.objPSWorkshopServerLock;
        synchronized (n) {
            if (this.psworkshopserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkshopServerId(), (Object)this.psworkshopserver.getPSWorkshopServerId()) != 0L) {
                this.psworkshopserver = null;
            }
            if (this.psworkshopserver == null) {
                PSWorkshopServer pSWorkshopServer = new PSWorkshopServer();
                pSWorkshopServer.setPSWorkshopServerId(this.getPSWorkshopServerId());
                PSWorkshopServerService pSWorkshopServerService = (PSWorkshopServerService)ServiceGlobal.getService(PSWorkshopServerService.class, (SessionFactory)this.getSessionFactory());
                pSWorkshopServerService.autoGet(pSWorkshopServer);
                this.psworkshopserver = pSWorkshopServer;
            }
            return this.psworkshopserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCorePrdInstLog> getPSCorePrdInstLogs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdInstLogs();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        PSCorePrdInstLogService pSCorePrdInstLogService = (PSCorePrdInstLogService)ServiceGlobal.getService(PSCorePrdInstLogService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCorePrdInstLogsLock;
        synchronized (n) {
            if (this.pscoreprdinstlogs == null) {
                this.pscoreprdinstlogs = pSCorePrdInstLogService.selectByPSTaskServer(this);
            }
            return this.pscoreprdinstlogs;
        }
    }

    private PSTaskServerBase getProxyEntity() {
        return this.proxyPSTaskServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSTaskServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSTaskServerBase) {
            this.proxyPSTaskServerBase = (PSTaskServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEVSYSDEPLOYMODE, 2);
        fieldIndexMap.put(FIELD_DOMAINPARAMS, 3);
        fieldIndexMap.put(FIELD_IPADDR, 4);
        fieldIndexMap.put(FIELD_IPADDR2, 5);
        fieldIndexMap.put(FIELD_LICINFO, 6);
        fieldIndexMap.put(FIELD_LICKEY, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_NO2PSMOBAPPPSID, 9);
        fieldIndexMap.put(FIELD_NO2PSMOBAPPPSNAME, 10);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 11);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 12);
        fieldIndexMap.put(FIELD_PSCOREPRDVERID, 13);
        fieldIndexMap.put(FIELD_PSCOREPRDVERNAME, 14);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERID, 15);
        fieldIndexMap.put(FIELD_PSDEPLOYCENTERNAME, 16);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKSERVERID, 17);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKSERVERNAME, 18);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 19);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 20);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 21);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 22);
        fieldIndexMap.put(FIELD_PSWORKSHOPSERVERID, 23);
        fieldIndexMap.put(FIELD_PSWORKSHOPSERVERNAME, 24);
        fieldIndexMap.put(FIELD_REFINFO, 25);
        fieldIndexMap.put(FIELD_SERVERURL, 26);
        fieldIndexMap.put(FIELD_SERVERURL2, 27);
        fieldIndexMap.put(FIELD_SERVERUSAGE, 28);
        fieldIndexMap.put(FIELD_SYSVER, 29);
        fieldIndexMap.put(FIELD_TSPARAMS, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
        fieldIndexMap.put(FIELD_VALIDFLAG, 33);
    }
}

