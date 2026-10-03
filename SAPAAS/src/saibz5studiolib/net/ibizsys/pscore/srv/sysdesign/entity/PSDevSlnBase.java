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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMavenRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryRepo;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkshopServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMavenRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryRepoService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkshopServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCanvas;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCanvasService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnBase.class);
    public static final String FIELD_ADMINPSDEVUSERID = "ADMINPSDEVUSERID";
    public static final String FIELD_ADMINPSDEVUSERNAME = "ADMINPSDEVUSERNAME";
    public static final String FIELD_CALLBACKTAG = "CALLBACKTAG";
    public static final String FIELD_CALLBACKURL = "CALLBACKURL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLECALLBACK = "ENABLECALLBACK";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String FIELD_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String FIELD_PSDCMAVENREPOID = "PSDCMAVENREPOID";
    public static final String FIELD_PSDCMAVENREPONAME = "PSDCMAVENREPONAME";
    public static final String FIELD_PSDCWORKSHOPSERVERID = "PSDCWORKSHOPSERVERID";
    public static final String FIELD_PSDCWORKSHOPSERVERNAME = "PSDCWORKSHOPSERVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPLOYSCNT = "PSDEVSLNMSDEPLOYSCNT";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSSCNT = "PSDEVSLNSYSSCNT";
    public static final String FIELD_PSDEVSLNUSERSCNT = "PSDEVSLNUSERSCNT";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_SLNFOLDER = "SLNFOLDER";
    public static final String FIELD_SLNMDURL = "SLNMDURL";
    public static final String FIELD_SLNSN = "SLNSN";
    public static final String FIELD_SLNTAG = "SLNTAG";
    public static final String FIELD_SLNTAG2 = "SLNTAG2";
    public static final String FIELD_SLNTYPE = "SLNTYPE";
    public static final String FIELD_SLNVER = "SLNVER";
    public static final String FIELD_STUDIOTAG = "STUDIOTAG";
    public static final String FIELD_STUDIOTAG2 = "STUDIOTAG2";
    public static final String FIELD_STUDIOVER = "STUDIOVER";
    public static final String FIELD_SYSAPIFLAG = "SYSAPIFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VCPASSWORD = "VCPASSWORD";
    public static final String FIELD_VCUSER = "VCUSER";
    private static final int INDEX_ADMINPSDEVUSERID = 0;
    private static final int INDEX_ADMINPSDEVUSERNAME = 1;
    private static final int INDEX_CALLBACKTAG = 2;
    private static final int INDEX_CALLBACKURL = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_ENABLECALLBACK = 7;
    private static final int INDEX_LOGICNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSDCDEPLOYCENTERID = 10;
    private static final int INDEX_PSDCDEPLOYCENTERNAME = 11;
    private static final int INDEX_PSDCMAVENREPOID = 12;
    private static final int INDEX_PSDCMAVENREPONAME = 13;
    private static final int INDEX_PSDCWORKSHOPSERVERID = 14;
    private static final int INDEX_PSDCWORKSHOPSERVERNAME = 15;
    private static final int INDEX_PSDEVCENTERID = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_PSDEVCENTERSVNID = 18;
    private static final int INDEX_PSDEVCENTERSVNNAME = 19;
    private static final int INDEX_PSDEVSLNID = 20;
    private static final int INDEX_PSDEVSLNMSDEPLOYSCNT = 21;
    private static final int INDEX_PSDEVSLNNAME = 22;
    private static final int INDEX_PSDEVSLNSYSSCNT = 23;
    private static final int INDEX_PSDEVSLNUSERSCNT = 24;
    private static final int INDEX_PSSYSTEMID = 25;
    private static final int INDEX_SLNFOLDER = 26;
    private static final int INDEX_SLNMDURL = 27;
    private static final int INDEX_SLNSN = 28;
    private static final int INDEX_SLNTAG = 29;
    private static final int INDEX_SLNTAG2 = 30;
    private static final int INDEX_SLNTYPE = 31;
    private static final int INDEX_SLNVER = 32;
    private static final int INDEX_STUDIOTAG = 33;
    private static final int INDEX_STUDIOTAG2 = 34;
    private static final int INDEX_STUDIOVER = 35;
    private static final int INDEX_SYSAPIFLAG = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_USERCAT = 39;
    private static final int INDEX_USERTAG = 40;
    private static final int INDEX_USERTAG2 = 41;
    private static final int INDEX_USERTAG3 = 42;
    private static final int INDEX_USERTAG4 = 43;
    private static final int INDEX_VCPASSWORD = 44;
    private static final int INDEX_VCUSER = 45;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnBase proxyPSDevSlnBase = null;
    private boolean adminpsdevuseridDirtyFlag = false;
    private boolean adminpsdevusernameDirtyFlag = false;
    private boolean callbacktagDirtyFlag = false;
    private boolean callbackurlDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablecallbackDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdeploycenteridDirtyFlag = false;
    private boolean psdcdeploycenternameDirtyFlag = false;
    private boolean psdcmavenrepoidDirtyFlag = false;
    private boolean psdcmavenreponameDirtyFlag = false;
    private boolean psdcworkshopserveridDirtyFlag = false;
    private boolean psdcworkshopservernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdeployscntDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysscntDirtyFlag = false;
    private boolean psdevslnuserscntDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean slnfolderDirtyFlag = false;
    private boolean slnmdurlDirtyFlag = false;
    private boolean slnsnDirtyFlag = false;
    private boolean slntagDirtyFlag = false;
    private boolean slntag2DirtyFlag = false;
    private boolean slntypeDirtyFlag = false;
    private boolean slnverDirtyFlag = false;
    private boolean studiotagDirtyFlag = false;
    private boolean studiotag2DirtyFlag = false;
    private boolean studioverDirtyFlag = false;
    private boolean sysapiflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean vcpasswordDirtyFlag = false;
    private boolean vcuserDirtyFlag = false;
    @Column(name="adminpsdevuserid")
    private String adminpsdevuserid;
    @Column(name="adminpsdevusername")
    private String adminpsdevusername;
    @Column(name="callbacktag")
    private String callbacktag;
    @Column(name="callbackurl")
    private String callbackurl;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablecallback")
    private Integer enablecallback;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcdeploycenterid")
    private String psdcdeploycenterid;
    @Column(name="psdcdeploycentername")
    private String psdcdeploycentername;
    @Column(name="psdcmavenrepoid")
    private String psdcmavenrepoid;
    @Column(name="psdcmavenreponame")
    private String psdcmavenreponame;
    @Column(name="psdcworkshopserverid")
    private String psdcworkshopserverid;
    @Column(name="psdcworkshopservername")
    private String psdcworkshopservername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdeployscnt")
    private Integer psdevslnmsdeployscnt;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysscnt")
    private Integer psdevslnsysscnt;
    @Column(name="psdevslnuserscnt")
    private Integer psdevslnuserscnt;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="slnfolder")
    private String slnfolder;
    @Column(name="slnmdurl")
    private String slnmdurl;
    @Column(name="slnsn")
    private String slnsn;
    @Column(name="slntag")
    private String slntag;
    @Column(name="slntag2")
    private String slntag2;
    @Column(name="slntype")
    private String slntype;
    @Column(name="slnver")
    private Integer slnver;
    @Column(name="studiotag")
    private String studiotag;
    @Column(name="studiotag2")
    private String studiotag2;
    @Column(name="studiover")
    private String studiover;
    @Column(name="sysapiflag")
    private Integer sysapiflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="vcpassword")
    private String vcpassword;
    @Column(name="vcuser")
    private String vcuser;
    private Integer objPSDCDeployCenterLock = new Integer(1);
    private PSDCDeployCenter psdcdeploycenter = null;
    private Integer objPSDCMavenRepoLock = new Integer(1);
    private PSDCMavenRepo psdcmavenrepo = null;
    private Integer objPSDCWorkshopServerLock = new Integer(1);
    private PSDCWorkshopServer psdcworkshopserver = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objAdminPSDevUserLock = new Integer(1);
    private PSDevUser adminpsdevuser = null;
    private Integer objPSDCDETemplsLock = new Integer(1);
    private ArrayList<PSDCDETempl> psdcdetempls = null;
    private Integer objPSDCModelTemplsLock = new Integer(1);
    private ArrayList<PSDCModelTempl> psdcmodeltempls = null;
    private Integer objPSDCRegistryRepoLock = new Integer(1);
    private ArrayList<PSDCRegistryRepo> psdcregistryrepo = null;
    private Integer objPSDevCenterSVNsLock = new Integer(1);
    private ArrayList<PSDevCenterSVN> psdevcentersvns = null;
    private Integer objPSDevPrdsLock = new Integer(1);
    private ArrayList<PSDevPrd> psdevprds = null;
    private Integer objPSDevSlnCanvasesLock = new Integer(1);
    private ArrayList<PSDevSlnCanvas> psdevslncanvases = null;
    private Integer objPSDevSlnLinksLock = new Integer(1);
    private ArrayList<PSDevSlnLink> psdevslnlinks = null;
    private Integer objPSDevSlnMSDeploysLock = new Integer(1);
    private ArrayList<PSDevSlnMSDeploy> psdevslnmsdeploys = null;
    private Integer objPSDevSlnMSDepResesLock = new Integer(1);
    private ArrayList<PSDevSlnMSDepRes> psdevslnmsdepreses = null;
    private Integer objPSDevSlnResesLock = new Integer(1);
    private ArrayList<PSDevSlnRes> psdevslnreses = null;
    private Integer objPSDevSlnSysDynaInstsLock = new Integer(1);
    private ArrayList<PSDevSlnSysDynaInst> psdevslnsysdynainsts = null;
    private Integer objPSDevSlnSysGroupsLock = new Integer(1);
    private ArrayList<PSDevSlnSysGroup> psdevslnsysgroups = null;
    private Integer objPSDevSlnSyssLock = new Integer(1);
    private ArrayList<PSDevSlnSys> psdevslnsyss = null;
    private Integer objPSDevSlnTemplsLock = new Integer(1);
    private ArrayList<PSDevSlnTempl> psdevslntempls = null;
    private Integer objPSDevSlnUsersLock = new Integer(1);
    private ArrayList<PSDevSlnUser> psdevslnusers = null;

    public void setAdminPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminpsdevuserid = string;
        this.adminpsdevuseridDirtyFlag = true;
    }

    public String getAdminPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPSDevUserId();
        }
        return this.adminpsdevuserid;
    }

    public boolean isAdminPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminPSDevUserIdDirty();
        }
        return this.adminpsdevuseridDirtyFlag;
    }

    public void resetAdminPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminPSDevUserId();
            return;
        }
        this.adminpsdevuseridDirtyFlag = false;
        this.adminpsdevuserid = null;
    }

    public void setAdminPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adminpsdevusername = string;
        this.adminpsdevusernameDirtyFlag = true;
    }

    public String getAdminPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPSDevUserName();
        }
        return this.adminpsdevusername;
    }

    public boolean isAdminPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminPSDevUserNameDirty();
        }
        return this.adminpsdevusernameDirtyFlag;
    }

    public void resetAdminPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminPSDevUserName();
            return;
        }
        this.adminpsdevusernameDirtyFlag = false;
        this.adminpsdevusername = null;
    }

    public void setCallbackTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallbackTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.callbacktag = string;
        this.callbacktagDirtyFlag = true;
    }

    public String getCallbackTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallbackTag();
        }
        return this.callbacktag;
    }

    public boolean isCallbackTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallbackTagDirty();
        }
        return this.callbacktagDirtyFlag;
    }

    public void resetCallbackTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallbackTag();
            return;
        }
        this.callbacktagDirtyFlag = false;
        this.callbacktag = null;
    }

    public void setCallbackUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallbackUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.callbackurl = string;
        this.callbackurlDirtyFlag = true;
    }

    public String getCallbackUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallbackUrl();
        }
        return this.callbackurl;
    }

    public boolean isCallbackUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallbackUrlDirty();
        }
        return this.callbackurlDirtyFlag;
    }

    public void resetCallbackUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallbackUrl();
            return;
        }
        this.callbackurlDirtyFlag = false;
        this.callbackurl = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setEnableCallback(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCallback(n);
            return;
        }
        this.enablecallback = n;
        this.enablecallbackDirtyFlag = true;
    }

    public Integer getEnableCallback() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCallback();
        }
        return this.enablecallback;
    }

    public boolean isEnableCallbackDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCallbackDirty();
        }
        return this.enablecallbackDirtyFlag;
    }

    public void resetEnableCallback() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCallback();
            return;
        }
        this.enablecallbackDirtyFlag = false;
        this.enablecallback = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSDCMavenRepoId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMavenRepoId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmavenrepoid = string;
        this.psdcmavenrepoidDirtyFlag = true;
    }

    public String getPSDCMavenRepoId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMavenRepoId();
        }
        return this.psdcmavenrepoid;
    }

    public boolean isPSDCMavenRepoIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMavenRepoIdDirty();
        }
        return this.psdcmavenrepoidDirtyFlag;
    }

    public void resetPSDCMavenRepoId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMavenRepoId();
            return;
        }
        this.psdcmavenrepoidDirtyFlag = false;
        this.psdcmavenrepoid = null;
    }

    public void setPSDCMavenRepoName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMavenRepoName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmavenreponame = string;
        this.psdcmavenreponameDirtyFlag = true;
    }

    public String getPSDCMavenRepoName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMavenRepoName();
        }
        return this.psdcmavenreponame;
    }

    public boolean isPSDCMavenRepoNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMavenRepoNameDirty();
        }
        return this.psdcmavenreponameDirtyFlag;
    }

    public void resetPSDCMavenRepoName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMavenRepoName();
            return;
        }
        this.psdcmavenreponameDirtyFlag = false;
        this.psdcmavenreponame = null;
    }

    public void setPSDCWorkshopServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkshopServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkshopserverid = string;
        this.psdcworkshopserveridDirtyFlag = true;
    }

    public String getPSDCWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServerId();
        }
        return this.psdcworkshopserverid;
    }

    public boolean isPSDCWorkshopServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkshopServerIdDirty();
        }
        return this.psdcworkshopserveridDirtyFlag;
    }

    public void resetPSDCWorkshopServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkshopServerId();
            return;
        }
        this.psdcworkshopserveridDirtyFlag = false;
        this.psdcworkshopserverid = null;
    }

    public void setPSDCWorkshopServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkshopServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkshopservername = string;
        this.psdcworkshopservernameDirtyFlag = true;
    }

    public String getPSDCWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServerName();
        }
        return this.psdcworkshopservername;
    }

    public boolean isPSDCWorkshopServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkshopServerNameDirty();
        }
        return this.psdcworkshopservernameDirtyFlag;
    }

    public void resetPSDCWorkshopServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkshopServerName();
            return;
        }
        this.psdcworkshopservernameDirtyFlag = false;
        this.psdcworkshopservername = null;
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

    public void setPSDevSlnMSDeploysCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeploysCnt(n);
            return;
        }
        this.psdevslnmsdeployscnt = n;
        this.psdevslnmsdeployscntDirtyFlag = true;
    }

    public Integer getPSDevSlnMSDeploysCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeploysCnt();
        }
        return this.psdevslnmsdeployscnt;
    }

    public boolean isPSDevSlnMSDeploysCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeploysCntDirty();
        }
        return this.psdevslnmsdeployscntDirtyFlag;
    }

    public void resetPSDevSlnMSDeploysCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeploysCnt();
            return;
        }
        this.psdevslnmsdeployscntDirtyFlag = false;
        this.psdevslnmsdeployscnt = null;
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

    public void setPSDevSlnSyssCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSyssCnt(n);
            return;
        }
        this.psdevslnsysscnt = n;
        this.psdevslnsysscntDirtyFlag = true;
    }

    public Integer getPSDevSlnSyssCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSyssCnt();
        }
        return this.psdevslnsysscnt;
    }

    public boolean isPSDevSlnSyssCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSyssCntDirty();
        }
        return this.psdevslnsysscntDirtyFlag;
    }

    public void resetPSDevSlnSyssCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSyssCnt();
            return;
        }
        this.psdevslnsysscntDirtyFlag = false;
        this.psdevslnsysscnt = null;
    }

    public void setPSDevSlnUsersCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnUsersCnt(n);
            return;
        }
        this.psdevslnuserscnt = n;
        this.psdevslnuserscntDirtyFlag = true;
    }

    public Integer getPSDevSlnUsersCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnUsersCnt();
        }
        return this.psdevslnuserscnt;
    }

    public boolean isPSDevSlnUsersCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnUsersCntDirty();
        }
        return this.psdevslnuserscntDirtyFlag;
    }

    public void resetPSDevSlnUsersCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnUsersCnt();
            return;
        }
        this.psdevslnuserscntDirtyFlag = false;
        this.psdevslnuserscnt = null;
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

    public void setSLNFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSLNFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slnfolder = string;
        this.slnfolderDirtyFlag = true;
    }

    public String getSLNFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSLNFolder();
        }
        return this.slnfolder;
    }

    public boolean isSLNFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSLNFolderDirty();
        }
        return this.slnfolderDirtyFlag;
    }

    public void resetSLNFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSLNFolder();
            return;
        }
        this.slnfolderDirtyFlag = false;
        this.slnfolder = null;
    }

    public void setSlnMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlnMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slnmdurl = string;
        this.slnmdurlDirtyFlag = true;
    }

    public String getSlnMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlnMDUrl();
        }
        return this.slnmdurl;
    }

    public boolean isSlnMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlnMDUrlDirty();
        }
        return this.slnmdurlDirtyFlag;
    }

    public void resetSlnMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlnMDUrl();
            return;
        }
        this.slnmdurlDirtyFlag = false;
        this.slnmdurl = null;
    }

    public void setSLNSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSLNSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slnsn = string;
        this.slnsnDirtyFlag = true;
    }

    public String getSLNSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSLNSN();
        }
        return this.slnsn;
    }

    public boolean isSLNSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSLNSNDirty();
        }
        return this.slnsnDirtyFlag;
    }

    public void resetSLNSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSLNSN();
            return;
        }
        this.slnsnDirtyFlag = false;
        this.slnsn = null;
    }

    public void setSlnTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlnTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slntag = string;
        this.slntagDirtyFlag = true;
    }

    public String getSlnTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlnTag();
        }
        return this.slntag;
    }

    public boolean isSlnTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlnTagDirty();
        }
        return this.slntagDirtyFlag;
    }

    public void resetSlnTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlnTag();
            return;
        }
        this.slntagDirtyFlag = false;
        this.slntag = null;
    }

    public void setSlnTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSlnTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slntag2 = string;
        this.slntag2DirtyFlag = true;
    }

    public String getSlnTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSlnTag2();
        }
        return this.slntag2;
    }

    public boolean isSlnTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSlnTag2Dirty();
        }
        return this.slntag2DirtyFlag;
    }

    public void resetSlnTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSlnTag2();
            return;
        }
        this.slntag2DirtyFlag = false;
        this.slntag2 = null;
    }

    public void setSLNType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSLNType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.slntype = string;
        this.slntypeDirtyFlag = true;
    }

    public String getSLNType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSLNType();
        }
        return this.slntype;
    }

    public boolean isSLNTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSLNTypeDirty();
        }
        return this.slntypeDirtyFlag;
    }

    public void resetSLNType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSLNType();
            return;
        }
        this.slntypeDirtyFlag = false;
        this.slntype = null;
    }

    public void setSLNVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSLNVer(n);
            return;
        }
        this.slnver = n;
        this.slnverDirtyFlag = true;
    }

    public Integer getSLNVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSLNVer();
        }
        return this.slnver;
    }

    public boolean isSLNVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSLNVerDirty();
        }
        return this.slnverDirtyFlag;
    }

    public void resetSLNVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSLNVer();
            return;
        }
        this.slnverDirtyFlag = false;
        this.slnver = null;
    }

    public void setStudioTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiotag = string;
        this.studiotagDirtyFlag = true;
    }

    public String getStudioTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioTag();
        }
        return this.studiotag;
    }

    public boolean isStudioTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioTagDirty();
        }
        return this.studiotagDirtyFlag;
    }

    public void resetStudioTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioTag();
            return;
        }
        this.studiotagDirtyFlag = false;
        this.studiotag = null;
    }

    public void setStudioTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiotag2 = string;
        this.studiotag2DirtyFlag = true;
    }

    public String getStudioTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioTag2();
        }
        return this.studiotag2;
    }

    public boolean isStudioTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioTag2Dirty();
        }
        return this.studiotag2DirtyFlag;
    }

    public void resetStudioTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioTag2();
            return;
        }
        this.studiotag2DirtyFlag = false;
        this.studiotag2 = null;
    }

    public void setStudioVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStudioVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.studiover = string;
        this.studioverDirtyFlag = true;
    }

    public String getStudioVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStudioVer();
        }
        return this.studiover;
    }

    public boolean isStudioVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStudioVerDirty();
        }
        return this.studioverDirtyFlag;
    }

    public void resetStudioVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStudioVer();
            return;
        }
        this.studioverDirtyFlag = false;
        this.studiover = null;
    }

    public void setSysAPIFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAPIFlag(n);
            return;
        }
        this.sysapiflag = n;
        this.sysapiflagDirtyFlag = true;
    }

    public Integer getSysAPIFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAPIFlag();
        }
        return this.sysapiflag;
    }

    public boolean isSysAPIFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAPIFlagDirty();
        }
        return this.sysapiflagDirtyFlag;
    }

    public void resetSysAPIFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAPIFlag();
            return;
        }
        this.sysapiflagDirtyFlag = false;
        this.sysapiflag = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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

    public void setVCPassword(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVCPassword(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vcpassword = string;
        this.vcpasswordDirtyFlag = true;
    }

    public String getVCPassword() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVCPassword();
        }
        return this.vcpassword;
    }

    public boolean isVCPasswordDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVCPasswordDirty();
        }
        return this.vcpasswordDirtyFlag;
    }

    public void resetVCPassword() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVCPassword();
            return;
        }
        this.vcpasswordDirtyFlag = false;
        this.vcpassword = null;
    }

    public void setVCUser(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVCUser(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vcuser = string;
        this.vcuserDirtyFlag = true;
    }

    public String getVCUser() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVCUser();
        }
        return this.vcuser;
    }

    public boolean isVCUserDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVCUserDirty();
        }
        return this.vcuserDirtyFlag;
    }

    public void resetVCUser() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVCUser();
            return;
        }
        this.vcuserDirtyFlag = false;
        this.vcuser = null;
    }

    protected void onReset() {
        PSDevSlnBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnBase pSDevSlnBase) {
        pSDevSlnBase.resetAdminPSDevUserId();
        pSDevSlnBase.resetAdminPSDevUserName();
        pSDevSlnBase.resetCallbackTag();
        pSDevSlnBase.resetCallbackUrl();
        pSDevSlnBase.resetCodeName();
        pSDevSlnBase.resetCreateDate();
        pSDevSlnBase.resetCreateMan();
        pSDevSlnBase.resetEnableCallback();
        pSDevSlnBase.resetLogicName();
        pSDevSlnBase.resetMemo();
        pSDevSlnBase.resetPSDCDeployCenterId();
        pSDevSlnBase.resetPSDCDeployCenterName();
        pSDevSlnBase.resetPSDCMavenRepoId();
        pSDevSlnBase.resetPSDCMavenRepoName();
        pSDevSlnBase.resetPSDCWorkshopServerId();
        pSDevSlnBase.resetPSDCWorkshopServerName();
        pSDevSlnBase.resetPSDevCenterId();
        pSDevSlnBase.resetPSDevCenterName();
        pSDevSlnBase.resetPSDevCenterSVNId();
        pSDevSlnBase.resetPSDevCenterSVNName();
        pSDevSlnBase.resetPSDevSlnId();
        pSDevSlnBase.resetPSDevSlnMSDeploysCnt();
        pSDevSlnBase.resetPSDevSlnName();
        pSDevSlnBase.resetPSDevSlnSyssCnt();
        pSDevSlnBase.resetPSDevSlnUsersCnt();
        pSDevSlnBase.resetPSSystemId();
        pSDevSlnBase.resetSLNFolder();
        pSDevSlnBase.resetSlnMDUrl();
        pSDevSlnBase.resetSLNSN();
        pSDevSlnBase.resetSlnTag();
        pSDevSlnBase.resetSlnTag2();
        pSDevSlnBase.resetSLNType();
        pSDevSlnBase.resetSLNVer();
        pSDevSlnBase.resetStudioTag();
        pSDevSlnBase.resetStudioTag2();
        pSDevSlnBase.resetStudioVer();
        pSDevSlnBase.resetSysAPIFlag();
        pSDevSlnBase.resetUpdateDate();
        pSDevSlnBase.resetUpdateMan();
        pSDevSlnBase.resetUserCat();
        pSDevSlnBase.resetUserTag();
        pSDevSlnBase.resetUserTag2();
        pSDevSlnBase.resetUserTag3();
        pSDevSlnBase.resetUserTag4();
        pSDevSlnBase.resetVCPassword();
        pSDevSlnBase.resetVCUser();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminPSDevUserIdDirty()) {
            hashMap.put(FIELD_ADMINPSDEVUSERID, this.getAdminPSDevUserId());
        }
        if (!bl || this.isAdminPSDevUserNameDirty()) {
            hashMap.put(FIELD_ADMINPSDEVUSERNAME, this.getAdminPSDevUserName());
        }
        if (!bl || this.isCallbackTagDirty()) {
            hashMap.put(FIELD_CALLBACKTAG, this.getCallbackTag());
        }
        if (!bl || this.isCallbackUrlDirty()) {
            hashMap.put(FIELD_CALLBACKURL, this.getCallbackUrl());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableCallbackDirty()) {
            hashMap.put(FIELD_ENABLECALLBACK, this.getEnableCallback());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERID, this.getPSDCDeployCenterId());
        }
        if (!bl || this.isPSDCDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERNAME, this.getPSDCDeployCenterName());
        }
        if (!bl || this.isPSDCMavenRepoIdDirty()) {
            hashMap.put(FIELD_PSDCMAVENREPOID, this.getPSDCMavenRepoId());
        }
        if (!bl || this.isPSDCMavenRepoNameDirty()) {
            hashMap.put(FIELD_PSDCMAVENREPONAME, this.getPSDCMavenRepoName());
        }
        if (!bl || this.isPSDCWorkshopServerIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSHOPSERVERID, this.getPSDCWorkshopServerId());
        }
        if (!bl || this.isPSDCWorkshopServerNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSHOPSERVERNAME, this.getPSDCWorkshopServerName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        if (!bl || this.isPSDevSlnMSDeploysCntDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYSCNT, this.getPSDevSlnMSDeploysCnt());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSyssCntDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSCNT, this.getPSDevSlnSyssCnt());
        }
        if (!bl || this.isPSDevSlnUsersCntDirty()) {
            hashMap.put(FIELD_PSDEVSLNUSERSCNT, this.getPSDevSlnUsersCnt());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isSLNFolderDirty()) {
            hashMap.put(FIELD_SLNFOLDER, this.getSLNFolder());
        }
        if (!bl || this.isSlnMDUrlDirty()) {
            hashMap.put(FIELD_SLNMDURL, this.getSlnMDUrl());
        }
        if (!bl || this.isSLNSNDirty()) {
            hashMap.put(FIELD_SLNSN, this.getSLNSN());
        }
        if (!bl || this.isSlnTagDirty()) {
            hashMap.put(FIELD_SLNTAG, this.getSlnTag());
        }
        if (!bl || this.isSlnTag2Dirty()) {
            hashMap.put(FIELD_SLNTAG2, this.getSlnTag2());
        }
        if (!bl || this.isSLNTypeDirty()) {
            hashMap.put(FIELD_SLNTYPE, this.getSLNType());
        }
        if (!bl || this.isSLNVerDirty()) {
            hashMap.put(FIELD_SLNVER, this.getSLNVer());
        }
        if (!bl || this.isStudioTagDirty()) {
            hashMap.put(FIELD_STUDIOTAG, this.getStudioTag());
        }
        if (!bl || this.isStudioTag2Dirty()) {
            hashMap.put(FIELD_STUDIOTAG2, this.getStudioTag2());
        }
        if (!bl || this.isStudioVerDirty()) {
            hashMap.put(FIELD_STUDIOVER, this.getStudioVer());
        }
        if (!bl || this.isSysAPIFlagDirty()) {
            hashMap.put(FIELD_SYSAPIFLAG, this.getSysAPIFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        if (!bl || this.isVCPasswordDirty()) {
            hashMap.put(FIELD_VCPASSWORD, this.getVCPassword());
        }
        if (!bl || this.isVCUserDirty()) {
            hashMap.put(FIELD_VCUSER, this.getVCUser());
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
        return PSDevSlnBase.get(this, n);
    }

    private static Object get(PSDevSlnBase pSDevSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnBase.getAdminPSDevUserId();
            }
            case 1: {
                return pSDevSlnBase.getAdminPSDevUserName();
            }
            case 2: {
                return pSDevSlnBase.getCallbackTag();
            }
            case 3: {
                return pSDevSlnBase.getCallbackUrl();
            }
            case 4: {
                return pSDevSlnBase.getCodeName();
            }
            case 5: {
                return pSDevSlnBase.getCreateDate();
            }
            case 6: {
                return pSDevSlnBase.getCreateMan();
            }
            case 7: {
                return pSDevSlnBase.getEnableCallback();
            }
            case 8: {
                return pSDevSlnBase.getLogicName();
            }
            case 9: {
                return pSDevSlnBase.getMemo();
            }
            case 10: {
                return pSDevSlnBase.getPSDCDeployCenterId();
            }
            case 11: {
                return pSDevSlnBase.getPSDCDeployCenterName();
            }
            case 12: {
                return pSDevSlnBase.getPSDCMavenRepoId();
            }
            case 13: {
                return pSDevSlnBase.getPSDCMavenRepoName();
            }
            case 14: {
                return pSDevSlnBase.getPSDCWorkshopServerId();
            }
            case 15: {
                return pSDevSlnBase.getPSDCWorkshopServerName();
            }
            case 16: {
                return pSDevSlnBase.getPSDevCenterId();
            }
            case 17: {
                return pSDevSlnBase.getPSDevCenterName();
            }
            case 18: {
                return pSDevSlnBase.getPSDevCenterSVNId();
            }
            case 19: {
                return pSDevSlnBase.getPSDevCenterSVNName();
            }
            case 20: {
                return pSDevSlnBase.getPSDevSlnId();
            }
            case 21: {
                return pSDevSlnBase.getPSDevSlnMSDeploysCnt();
            }
            case 22: {
                return pSDevSlnBase.getPSDevSlnName();
            }
            case 23: {
                return pSDevSlnBase.getPSDevSlnSyssCnt();
            }
            case 24: {
                return pSDevSlnBase.getPSDevSlnUsersCnt();
            }
            case 25: {
                return pSDevSlnBase.getPSSystemId();
            }
            case 26: {
                return pSDevSlnBase.getSLNFolder();
            }
            case 27: {
                return pSDevSlnBase.getSlnMDUrl();
            }
            case 28: {
                return pSDevSlnBase.getSLNSN();
            }
            case 29: {
                return pSDevSlnBase.getSlnTag();
            }
            case 30: {
                return pSDevSlnBase.getSlnTag2();
            }
            case 31: {
                return pSDevSlnBase.getSLNType();
            }
            case 32: {
                return pSDevSlnBase.getSLNVer();
            }
            case 33: {
                return pSDevSlnBase.getStudioTag();
            }
            case 34: {
                return pSDevSlnBase.getStudioTag2();
            }
            case 35: {
                return pSDevSlnBase.getStudioVer();
            }
            case 36: {
                return pSDevSlnBase.getSysAPIFlag();
            }
            case 37: {
                return pSDevSlnBase.getUpdateDate();
            }
            case 38: {
                return pSDevSlnBase.getUpdateMan();
            }
            case 39: {
                return pSDevSlnBase.getUserCat();
            }
            case 40: {
                return pSDevSlnBase.getUserTag();
            }
            case 41: {
                return pSDevSlnBase.getUserTag2();
            }
            case 42: {
                return pSDevSlnBase.getUserTag3();
            }
            case 43: {
                return pSDevSlnBase.getUserTag4();
            }
            case 44: {
                return pSDevSlnBase.getVCPassword();
            }
            case 45: {
                return pSDevSlnBase.getVCUser();
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
        PSDevSlnBase.set(this, n, object);
    }

    private static void set(PSDevSlnBase pSDevSlnBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnBase.setAdminPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnBase.setAdminPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnBase.setCallbackTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnBase.setCallbackUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnBase.setEnableCallback(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnBase.setPSDCDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnBase.setPSDCDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnBase.setPSDCMavenRepoId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnBase.setPSDCMavenRepoName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnBase.setPSDCWorkshopServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnBase.setPSDCWorkshopServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnBase.setPSDevSlnMSDeploysCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnBase.setPSDevSlnSyssCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnBase.setPSDevSlnUsersCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnBase.setSLNFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnBase.setSlnMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnBase.setSLNSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnBase.setSlnTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnBase.setSlnTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnBase.setSLNType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnBase.setSLNVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnBase.setStudioTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnBase.setStudioTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnBase.setStudioVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnBase.setSysAPIFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnBase.setVCPassword(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevSlnBase.setVCUser(DataObject.getStringValue((Object)object));
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
        return PSDevSlnBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnBase pSDevSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnBase.getAdminPSDevUserId() == null;
            }
            case 1: {
                return pSDevSlnBase.getAdminPSDevUserName() == null;
            }
            case 2: {
                return pSDevSlnBase.getCallbackTag() == null;
            }
            case 3: {
                return pSDevSlnBase.getCallbackUrl() == null;
            }
            case 4: {
                return pSDevSlnBase.getCodeName() == null;
            }
            case 5: {
                return pSDevSlnBase.getCreateDate() == null;
            }
            case 6: {
                return pSDevSlnBase.getCreateMan() == null;
            }
            case 7: {
                return pSDevSlnBase.getEnableCallback() == null;
            }
            case 8: {
                return pSDevSlnBase.getLogicName() == null;
            }
            case 9: {
                return pSDevSlnBase.getMemo() == null;
            }
            case 10: {
                return pSDevSlnBase.getPSDCDeployCenterId() == null;
            }
            case 11: {
                return pSDevSlnBase.getPSDCDeployCenterName() == null;
            }
            case 12: {
                return pSDevSlnBase.getPSDCMavenRepoId() == null;
            }
            case 13: {
                return pSDevSlnBase.getPSDCMavenRepoName() == null;
            }
            case 14: {
                return pSDevSlnBase.getPSDCWorkshopServerId() == null;
            }
            case 15: {
                return pSDevSlnBase.getPSDCWorkshopServerName() == null;
            }
            case 16: {
                return pSDevSlnBase.getPSDevCenterId() == null;
            }
            case 17: {
                return pSDevSlnBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSDevSlnBase.getPSDevCenterSVNId() == null;
            }
            case 19: {
                return pSDevSlnBase.getPSDevCenterSVNName() == null;
            }
            case 20: {
                return pSDevSlnBase.getPSDevSlnId() == null;
            }
            case 21: {
                return pSDevSlnBase.getPSDevSlnMSDeploysCnt() == null;
            }
            case 22: {
                return pSDevSlnBase.getPSDevSlnName() == null;
            }
            case 23: {
                return pSDevSlnBase.getPSDevSlnSyssCnt() == null;
            }
            case 24: {
                return pSDevSlnBase.getPSDevSlnUsersCnt() == null;
            }
            case 25: {
                return pSDevSlnBase.getPSSystemId() == null;
            }
            case 26: {
                return pSDevSlnBase.getSLNFolder() == null;
            }
            case 27: {
                return pSDevSlnBase.getSlnMDUrl() == null;
            }
            case 28: {
                return pSDevSlnBase.getSLNSN() == null;
            }
            case 29: {
                return pSDevSlnBase.getSlnTag() == null;
            }
            case 30: {
                return pSDevSlnBase.getSlnTag2() == null;
            }
            case 31: {
                return pSDevSlnBase.getSLNType() == null;
            }
            case 32: {
                return pSDevSlnBase.getSLNVer() == null;
            }
            case 33: {
                return pSDevSlnBase.getStudioTag() == null;
            }
            case 34: {
                return pSDevSlnBase.getStudioTag2() == null;
            }
            case 35: {
                return pSDevSlnBase.getStudioVer() == null;
            }
            case 36: {
                return pSDevSlnBase.getSysAPIFlag() == null;
            }
            case 37: {
                return pSDevSlnBase.getUpdateDate() == null;
            }
            case 38: {
                return pSDevSlnBase.getUpdateMan() == null;
            }
            case 39: {
                return pSDevSlnBase.getUserCat() == null;
            }
            case 40: {
                return pSDevSlnBase.getUserTag() == null;
            }
            case 41: {
                return pSDevSlnBase.getUserTag2() == null;
            }
            case 42: {
                return pSDevSlnBase.getUserTag3() == null;
            }
            case 43: {
                return pSDevSlnBase.getUserTag4() == null;
            }
            case 44: {
                return pSDevSlnBase.getVCPassword() == null;
            }
            case 45: {
                return pSDevSlnBase.getVCUser() == null;
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
        return PSDevSlnBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnBase pSDevSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnBase.isAdminPSDevUserIdDirty();
            }
            case 1: {
                return pSDevSlnBase.isAdminPSDevUserNameDirty();
            }
            case 2: {
                return pSDevSlnBase.isCallbackTagDirty();
            }
            case 3: {
                return pSDevSlnBase.isCallbackUrlDirty();
            }
            case 4: {
                return pSDevSlnBase.isCodeNameDirty();
            }
            case 5: {
                return pSDevSlnBase.isCreateDateDirty();
            }
            case 6: {
                return pSDevSlnBase.isCreateManDirty();
            }
            case 7: {
                return pSDevSlnBase.isEnableCallbackDirty();
            }
            case 8: {
                return pSDevSlnBase.isLogicNameDirty();
            }
            case 9: {
                return pSDevSlnBase.isMemoDirty();
            }
            case 10: {
                return pSDevSlnBase.isPSDCDeployCenterIdDirty();
            }
            case 11: {
                return pSDevSlnBase.isPSDCDeployCenterNameDirty();
            }
            case 12: {
                return pSDevSlnBase.isPSDCMavenRepoIdDirty();
            }
            case 13: {
                return pSDevSlnBase.isPSDCMavenRepoNameDirty();
            }
            case 14: {
                return pSDevSlnBase.isPSDCWorkshopServerIdDirty();
            }
            case 15: {
                return pSDevSlnBase.isPSDCWorkshopServerNameDirty();
            }
            case 16: {
                return pSDevSlnBase.isPSDevCenterIdDirty();
            }
            case 17: {
                return pSDevSlnBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSDevSlnBase.isPSDevCenterSVNIdDirty();
            }
            case 19: {
                return pSDevSlnBase.isPSDevCenterSVNNameDirty();
            }
            case 20: {
                return pSDevSlnBase.isPSDevSlnIdDirty();
            }
            case 21: {
                return pSDevSlnBase.isPSDevSlnMSDeploysCntDirty();
            }
            case 22: {
                return pSDevSlnBase.isPSDevSlnNameDirty();
            }
            case 23: {
                return pSDevSlnBase.isPSDevSlnSyssCntDirty();
            }
            case 24: {
                return pSDevSlnBase.isPSDevSlnUsersCntDirty();
            }
            case 25: {
                return pSDevSlnBase.isPSSystemIdDirty();
            }
            case 26: {
                return pSDevSlnBase.isSLNFolderDirty();
            }
            case 27: {
                return pSDevSlnBase.isSlnMDUrlDirty();
            }
            case 28: {
                return pSDevSlnBase.isSLNSNDirty();
            }
            case 29: {
                return pSDevSlnBase.isSlnTagDirty();
            }
            case 30: {
                return pSDevSlnBase.isSlnTag2Dirty();
            }
            case 31: {
                return pSDevSlnBase.isSLNTypeDirty();
            }
            case 32: {
                return pSDevSlnBase.isSLNVerDirty();
            }
            case 33: {
                return pSDevSlnBase.isStudioTagDirty();
            }
            case 34: {
                return pSDevSlnBase.isStudioTag2Dirty();
            }
            case 35: {
                return pSDevSlnBase.isStudioVerDirty();
            }
            case 36: {
                return pSDevSlnBase.isSysAPIFlagDirty();
            }
            case 37: {
                return pSDevSlnBase.isUpdateDateDirty();
            }
            case 38: {
                return pSDevSlnBase.isUpdateManDirty();
            }
            case 39: {
                return pSDevSlnBase.isUserCatDirty();
            }
            case 40: {
                return pSDevSlnBase.isUserTagDirty();
            }
            case 41: {
                return pSDevSlnBase.isUserTag2Dirty();
            }
            case 42: {
                return pSDevSlnBase.isUserTag3Dirty();
            }
            case 43: {
                return pSDevSlnBase.isUserTag4Dirty();
            }
            case 44: {
                return pSDevSlnBase.isVCPasswordDirty();
            }
            case 45: {
                return pSDevSlnBase.isVCUserDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnBase pSDevSlnBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnBase.getAdminPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpsdevuserid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getAdminPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getAdminPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminpsdevusername", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getAdminPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getCallbackTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"callbacktag", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getCallbackTag()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getCallbackUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"callbackurl", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getCallbackUrl()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getEnableCallback() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecallback", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getEnableCallback()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDCDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycenterid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDCDeployCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDCDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycentername", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDCDeployCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDCMavenRepoId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmavenrepoid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDCMavenRepoId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDCMavenRepoName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmavenreponame", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDCMavenRepoName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDCWorkshopServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkshopserverid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDCWorkshopServerId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDCWorkshopServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkshopservername", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDCWorkshopServerName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevSlnMSDeploysCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployscnt", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevSlnMSDeploysCnt()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevSlnSyssCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysscnt", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevSlnSyssCnt()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSDevSlnUsersCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnuserscnt", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSDevSlnUsersCnt()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSLNFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slnfolder", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSLNFolder()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSlnMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slnmdurl", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSlnMDUrl()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSLNSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slnsn", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSLNSN()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSlnTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slntag", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSlnTag()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSlnTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slntag2", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSlnTag2()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSLNType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slntype", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSLNType()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSLNVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"slnver", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSLNVer()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getStudioTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getStudioTag()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getStudioTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiotag2", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getStudioTag2()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getStudioVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"studiover", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getStudioVer()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getSysAPIFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysapiflag", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getSysAPIFlag()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getVCPassword() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vcpassword", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getVCPassword()), (boolean)false);
        }
        if (bl || pSDevSlnBase.getVCUser() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vcuser", (Object)PSDevSlnBase.getJSONValue((Object)pSDevSlnBase.getVCUser()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnBase pSDevSlnBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnBase.getAdminPSDevUserId() != null) {
            object = pSDevSlnBase.getAdminPSDevUserId();
            xmlNode.setAttribute(FIELD_ADMINPSDEVUSERID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnBase.getAdminPSDevUserName() != null) {
            object = pSDevSlnBase.getAdminPSDevUserName();
            xmlNode.setAttribute(FIELD_ADMINPSDEVUSERNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnBase.getCallbackTag() != null) {
            object = pSDevSlnBase.getCallbackTag();
            xmlNode.setAttribute(FIELD_CALLBACKTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnBase.getCallbackUrl() != null) {
            object = pSDevSlnBase.getCallbackUrl();
            xmlNode.setAttribute(FIELD_CALLBACKURL, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnBase.getCodeName() != null) {
            object = pSDevSlnBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getCreateDate() != null) {
            object = pSDevSlnBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnBase.getCreateMan() != null) {
            object = pSDevSlnBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getEnableCallback() != null) {
            object = pSDevSlnBase.getEnableCallback();
            xmlNode.setAttribute(FIELD_ENABLECALLBACK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnBase.getLogicName() != null) {
            object = pSDevSlnBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getMemo() != null) {
            object = pSDevSlnBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDCDeployCenterId() != null) {
            object = pSDevSlnBase.getPSDCDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDCDeployCenterName() != null) {
            object = pSDevSlnBase.getPSDCDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDCMavenRepoId() != null) {
            object = pSDevSlnBase.getPSDCMavenRepoId();
            xmlNode.setAttribute(FIELD_PSDCMAVENREPOID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDCMavenRepoName() != null) {
            object = pSDevSlnBase.getPSDCMavenRepoName();
            xmlNode.setAttribute(FIELD_PSDCMAVENREPONAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDCWorkshopServerId() != null) {
            object = pSDevSlnBase.getPSDCWorkshopServerId();
            xmlNode.setAttribute(FIELD_PSDCWORKSHOPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDCWorkshopServerName() != null) {
            object = pSDevSlnBase.getPSDCWorkshopServerName();
            xmlNode.setAttribute(FIELD_PSDCWORKSHOPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDevCenterId() != null) {
            object = pSDevSlnBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDevCenterName() != null) {
            object = pSDevSlnBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDevCenterSVNId() != null) {
            object = pSDevSlnBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDevCenterSVNName() != null) {
            object = pSDevSlnBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDevSlnId() != null) {
            object = pSDevSlnBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDevSlnMSDeploysCnt() != null) {
            object = pSDevSlnBase.getPSDevSlnMSDeploysCnt();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnBase.getPSDevSlnName() != null) {
            object = pSDevSlnBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getPSDevSlnSyssCnt() != null) {
            object = pSDevSlnBase.getPSDevSlnSyssCnt();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnBase.getPSDevSlnUsersCnt() != null) {
            object = pSDevSlnBase.getPSDevSlnUsersCnt();
            xmlNode.setAttribute(FIELD_PSDEVSLNUSERSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnBase.getPSSystemId() != null) {
            object = pSDevSlnBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSLNFolder() != null) {
            object = pSDevSlnBase.getSLNFolder();
            xmlNode.setAttribute(FIELD_SLNFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSlnMDUrl() != null) {
            object = pSDevSlnBase.getSlnMDUrl();
            xmlNode.setAttribute(FIELD_SLNMDURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSLNSN() != null) {
            object = pSDevSlnBase.getSLNSN();
            xmlNode.setAttribute(FIELD_SLNSN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSlnTag() != null) {
            object = pSDevSlnBase.getSlnTag();
            xmlNode.setAttribute(FIELD_SLNTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSlnTag2() != null) {
            object = pSDevSlnBase.getSlnTag2();
            xmlNode.setAttribute(FIELD_SLNTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSLNType() != null) {
            object = pSDevSlnBase.getSLNType();
            xmlNode.setAttribute(FIELD_SLNTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSLNVer() != null) {
            object = pSDevSlnBase.getSLNVer();
            xmlNode.setAttribute(FIELD_SLNVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnBase.getStudioTag() != null) {
            object = pSDevSlnBase.getStudioTag();
            xmlNode.setAttribute(FIELD_STUDIOTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getStudioTag2() != null) {
            object = pSDevSlnBase.getStudioTag2();
            xmlNode.setAttribute(FIELD_STUDIOTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getStudioVer() != null) {
            object = pSDevSlnBase.getStudioVer();
            xmlNode.setAttribute(FIELD_STUDIOVER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getSysAPIFlag() != null) {
            object = pSDevSlnBase.getSysAPIFlag();
            xmlNode.setAttribute(FIELD_SYSAPIFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnBase.getUpdateDate() != null) {
            object = pSDevSlnBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnBase.getUpdateMan() != null) {
            object = pSDevSlnBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getUserCat() != null) {
            object = pSDevSlnBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getUserTag() != null) {
            object = pSDevSlnBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getUserTag2() != null) {
            object = pSDevSlnBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getUserTag3() != null) {
            object = pSDevSlnBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getUserTag4() != null) {
            object = pSDevSlnBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getVCPassword() != null) {
            object = pSDevSlnBase.getVCPassword();
            xmlNode.setAttribute(FIELD_VCPASSWORD, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnBase.getVCUser() != null) {
            object = pSDevSlnBase.getVCUser();
            xmlNode.setAttribute(FIELD_VCUSER, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnBase pSDevSlnBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnBase.isAdminPSDevUserIdDirty() && (bl || pSDevSlnBase.getAdminPSDevUserId() != null)) {
            iDataObject.set(FIELD_ADMINPSDEVUSERID, (Object)pSDevSlnBase.getAdminPSDevUserId());
        }
        if (pSDevSlnBase.isAdminPSDevUserNameDirty() && (bl || pSDevSlnBase.getAdminPSDevUserName() != null)) {
            iDataObject.set(FIELD_ADMINPSDEVUSERNAME, (Object)pSDevSlnBase.getAdminPSDevUserName());
        }
        if (pSDevSlnBase.isCallbackTagDirty() && (bl || pSDevSlnBase.getCallbackTag() != null)) {
            iDataObject.set(FIELD_CALLBACKTAG, (Object)pSDevSlnBase.getCallbackTag());
        }
        if (pSDevSlnBase.isCallbackUrlDirty() && (bl || pSDevSlnBase.getCallbackUrl() != null)) {
            iDataObject.set(FIELD_CALLBACKURL, (Object)pSDevSlnBase.getCallbackUrl());
        }
        if (pSDevSlnBase.isCodeNameDirty() && (bl || pSDevSlnBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnBase.getCodeName());
        }
        if (pSDevSlnBase.isCreateDateDirty() && (bl || pSDevSlnBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnBase.getCreateDate());
        }
        if (pSDevSlnBase.isCreateManDirty() && (bl || pSDevSlnBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnBase.getCreateMan());
        }
        if (pSDevSlnBase.isEnableCallbackDirty() && (bl || pSDevSlnBase.getEnableCallback() != null)) {
            iDataObject.set(FIELD_ENABLECALLBACK, (Object)pSDevSlnBase.getEnableCallback());
        }
        if (pSDevSlnBase.isLogicNameDirty() && (bl || pSDevSlnBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDevSlnBase.getLogicName());
        }
        if (pSDevSlnBase.isMemoDirty() && (bl || pSDevSlnBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnBase.getMemo());
        }
        if (pSDevSlnBase.isPSDCDeployCenterIdDirty() && (bl || pSDevSlnBase.getPSDCDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERID, (Object)pSDevSlnBase.getPSDCDeployCenterId());
        }
        if (pSDevSlnBase.isPSDCDeployCenterNameDirty() && (bl || pSDevSlnBase.getPSDCDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERNAME, (Object)pSDevSlnBase.getPSDCDeployCenterName());
        }
        if (pSDevSlnBase.isPSDCMavenRepoIdDirty() && (bl || pSDevSlnBase.getPSDCMavenRepoId() != null)) {
            iDataObject.set(FIELD_PSDCMAVENREPOID, (Object)pSDevSlnBase.getPSDCMavenRepoId());
        }
        if (pSDevSlnBase.isPSDCMavenRepoNameDirty() && (bl || pSDevSlnBase.getPSDCMavenRepoName() != null)) {
            iDataObject.set(FIELD_PSDCMAVENREPONAME, (Object)pSDevSlnBase.getPSDCMavenRepoName());
        }
        if (pSDevSlnBase.isPSDCWorkshopServerIdDirty() && (bl || pSDevSlnBase.getPSDCWorkshopServerId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSHOPSERVERID, (Object)pSDevSlnBase.getPSDCWorkshopServerId());
        }
        if (pSDevSlnBase.isPSDCWorkshopServerNameDirty() && (bl || pSDevSlnBase.getPSDCWorkshopServerName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSHOPSERVERNAME, (Object)pSDevSlnBase.getPSDCWorkshopServerName());
        }
        if (pSDevSlnBase.isPSDevCenterIdDirty() && (bl || pSDevSlnBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnBase.getPSDevCenterId());
        }
        if (pSDevSlnBase.isPSDevCenterNameDirty() && (bl || pSDevSlnBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnBase.getPSDevCenterName());
        }
        if (pSDevSlnBase.isPSDevCenterSVNIdDirty() && (bl || pSDevSlnBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevSlnBase.getPSDevCenterSVNId());
        }
        if (pSDevSlnBase.isPSDevCenterSVNNameDirty() && (bl || pSDevSlnBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevSlnBase.getPSDevCenterSVNName());
        }
        if (pSDevSlnBase.isPSDevSlnIdDirty() && (bl || pSDevSlnBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnBase.getPSDevSlnId());
        }
        if (pSDevSlnBase.isPSDevSlnMSDeploysCntDirty() && (bl || pSDevSlnBase.getPSDevSlnMSDeploysCnt() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYSCNT, (Object)pSDevSlnBase.getPSDevSlnMSDeploysCnt());
        }
        if (pSDevSlnBase.isPSDevSlnNameDirty() && (bl || pSDevSlnBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnBase.getPSDevSlnName());
        }
        if (pSDevSlnBase.isPSDevSlnSyssCntDirty() && (bl || pSDevSlnBase.getPSDevSlnSyssCnt() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSCNT, (Object)pSDevSlnBase.getPSDevSlnSyssCnt());
        }
        if (pSDevSlnBase.isPSDevSlnUsersCntDirty() && (bl || pSDevSlnBase.getPSDevSlnUsersCnt() != null)) {
            iDataObject.set(FIELD_PSDEVSLNUSERSCNT, (Object)pSDevSlnBase.getPSDevSlnUsersCnt());
        }
        if (pSDevSlnBase.isPSSystemIdDirty() && (bl || pSDevSlnBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDevSlnBase.getPSSystemId());
        }
        if (pSDevSlnBase.isSLNFolderDirty() && (bl || pSDevSlnBase.getSLNFolder() != null)) {
            iDataObject.set(FIELD_SLNFOLDER, (Object)pSDevSlnBase.getSLNFolder());
        }
        if (pSDevSlnBase.isSlnMDUrlDirty() && (bl || pSDevSlnBase.getSlnMDUrl() != null)) {
            iDataObject.set(FIELD_SLNMDURL, (Object)pSDevSlnBase.getSlnMDUrl());
        }
        if (pSDevSlnBase.isSLNSNDirty() && (bl || pSDevSlnBase.getSLNSN() != null)) {
            iDataObject.set(FIELD_SLNSN, (Object)pSDevSlnBase.getSLNSN());
        }
        if (pSDevSlnBase.isSlnTagDirty() && (bl || pSDevSlnBase.getSlnTag() != null)) {
            iDataObject.set(FIELD_SLNTAG, (Object)pSDevSlnBase.getSlnTag());
        }
        if (pSDevSlnBase.isSlnTag2Dirty() && (bl || pSDevSlnBase.getSlnTag2() != null)) {
            iDataObject.set(FIELD_SLNTAG2, (Object)pSDevSlnBase.getSlnTag2());
        }
        if (pSDevSlnBase.isSLNTypeDirty() && (bl || pSDevSlnBase.getSLNType() != null)) {
            iDataObject.set(FIELD_SLNTYPE, (Object)pSDevSlnBase.getSLNType());
        }
        if (pSDevSlnBase.isSLNVerDirty() && (bl || pSDevSlnBase.getSLNVer() != null)) {
            iDataObject.set(FIELD_SLNVER, (Object)pSDevSlnBase.getSLNVer());
        }
        if (pSDevSlnBase.isStudioTagDirty() && (bl || pSDevSlnBase.getStudioTag() != null)) {
            iDataObject.set(FIELD_STUDIOTAG, (Object)pSDevSlnBase.getStudioTag());
        }
        if (pSDevSlnBase.isStudioTag2Dirty() && (bl || pSDevSlnBase.getStudioTag2() != null)) {
            iDataObject.set(FIELD_STUDIOTAG2, (Object)pSDevSlnBase.getStudioTag2());
        }
        if (pSDevSlnBase.isStudioVerDirty() && (bl || pSDevSlnBase.getStudioVer() != null)) {
            iDataObject.set(FIELD_STUDIOVER, (Object)pSDevSlnBase.getStudioVer());
        }
        if (pSDevSlnBase.isSysAPIFlagDirty() && (bl || pSDevSlnBase.getSysAPIFlag() != null)) {
            iDataObject.set(FIELD_SYSAPIFLAG, (Object)pSDevSlnBase.getSysAPIFlag());
        }
        if (pSDevSlnBase.isUpdateDateDirty() && (bl || pSDevSlnBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnBase.getUpdateDate());
        }
        if (pSDevSlnBase.isUpdateManDirty() && (bl || pSDevSlnBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnBase.getUpdateMan());
        }
        if (pSDevSlnBase.isUserCatDirty() && (bl || pSDevSlnBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnBase.getUserCat());
        }
        if (pSDevSlnBase.isUserTagDirty() && (bl || pSDevSlnBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnBase.getUserTag());
        }
        if (pSDevSlnBase.isUserTag2Dirty() && (bl || pSDevSlnBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnBase.getUserTag2());
        }
        if (pSDevSlnBase.isUserTag3Dirty() && (bl || pSDevSlnBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnBase.getUserTag3());
        }
        if (pSDevSlnBase.isUserTag4Dirty() && (bl || pSDevSlnBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnBase.getUserTag4());
        }
        if (pSDevSlnBase.isVCPasswordDirty() && (bl || pSDevSlnBase.getVCPassword() != null)) {
            iDataObject.set(FIELD_VCPASSWORD, (Object)pSDevSlnBase.getVCPassword());
        }
        if (pSDevSlnBase.isVCUserDirty() && (bl || pSDevSlnBase.getVCUser() != null)) {
            iDataObject.set(FIELD_VCUSER, (Object)pSDevSlnBase.getVCUser());
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
        return PSDevSlnBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnBase pSDevSlnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnBase.resetAdminPSDevUserId();
                return true;
            }
            case 1: {
                pSDevSlnBase.resetAdminPSDevUserName();
                return true;
            }
            case 2: {
                pSDevSlnBase.resetCallbackTag();
                return true;
            }
            case 3: {
                pSDevSlnBase.resetCallbackUrl();
                return true;
            }
            case 4: {
                pSDevSlnBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDevSlnBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDevSlnBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDevSlnBase.resetEnableCallback();
                return true;
            }
            case 8: {
                pSDevSlnBase.resetLogicName();
                return true;
            }
            case 9: {
                pSDevSlnBase.resetMemo();
                return true;
            }
            case 10: {
                pSDevSlnBase.resetPSDCDeployCenterId();
                return true;
            }
            case 11: {
                pSDevSlnBase.resetPSDCDeployCenterName();
                return true;
            }
            case 12: {
                pSDevSlnBase.resetPSDCMavenRepoId();
                return true;
            }
            case 13: {
                pSDevSlnBase.resetPSDCMavenRepoName();
                return true;
            }
            case 14: {
                pSDevSlnBase.resetPSDCWorkshopServerId();
                return true;
            }
            case 15: {
                pSDevSlnBase.resetPSDCWorkshopServerName();
                return true;
            }
            case 16: {
                pSDevSlnBase.resetPSDevCenterId();
                return true;
            }
            case 17: {
                pSDevSlnBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSDevSlnBase.resetPSDevCenterSVNId();
                return true;
            }
            case 19: {
                pSDevSlnBase.resetPSDevCenterSVNName();
                return true;
            }
            case 20: {
                pSDevSlnBase.resetPSDevSlnId();
                return true;
            }
            case 21: {
                pSDevSlnBase.resetPSDevSlnMSDeploysCnt();
                return true;
            }
            case 22: {
                pSDevSlnBase.resetPSDevSlnName();
                return true;
            }
            case 23: {
                pSDevSlnBase.resetPSDevSlnSyssCnt();
                return true;
            }
            case 24: {
                pSDevSlnBase.resetPSDevSlnUsersCnt();
                return true;
            }
            case 25: {
                pSDevSlnBase.resetPSSystemId();
                return true;
            }
            case 26: {
                pSDevSlnBase.resetSLNFolder();
                return true;
            }
            case 27: {
                pSDevSlnBase.resetSlnMDUrl();
                return true;
            }
            case 28: {
                pSDevSlnBase.resetSLNSN();
                return true;
            }
            case 29: {
                pSDevSlnBase.resetSlnTag();
                return true;
            }
            case 30: {
                pSDevSlnBase.resetSlnTag2();
                return true;
            }
            case 31: {
                pSDevSlnBase.resetSLNType();
                return true;
            }
            case 32: {
                pSDevSlnBase.resetSLNVer();
                return true;
            }
            case 33: {
                pSDevSlnBase.resetStudioTag();
                return true;
            }
            case 34: {
                pSDevSlnBase.resetStudioTag2();
                return true;
            }
            case 35: {
                pSDevSlnBase.resetStudioVer();
                return true;
            }
            case 36: {
                pSDevSlnBase.resetSysAPIFlag();
                return true;
            }
            case 37: {
                pSDevSlnBase.resetUpdateDate();
                return true;
            }
            case 38: {
                pSDevSlnBase.resetUpdateMan();
                return true;
            }
            case 39: {
                pSDevSlnBase.resetUserCat();
                return true;
            }
            case 40: {
                pSDevSlnBase.resetUserTag();
                return true;
            }
            case 41: {
                pSDevSlnBase.resetUserTag2();
                return true;
            }
            case 42: {
                pSDevSlnBase.resetUserTag3();
                return true;
            }
            case 43: {
                pSDevSlnBase.resetUserTag4();
                return true;
            }
            case 44: {
                pSDevSlnBase.resetVCPassword();
                return true;
            }
            case 45: {
                pSDevSlnBase.resetVCUser();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDCDeployCenterService.autoGet(pSDCDeployCenter);
                this.psdcdeploycenter = pSDCDeployCenter;
            }
            return this.psdcdeploycenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMavenRepo getPSDCMavenRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMavenRepo();
        }
        if (this.getPSDCMavenRepoId() == null) {
            return null;
        }
        Integer n = this.objPSDCMavenRepoLock;
        synchronized (n) {
            if (this.psdcmavenrepo != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMavenRepoId(), (Object)this.psdcmavenrepo.getPSDCMavenRepoId()) != 0L) {
                this.psdcmavenrepo = null;
            }
            if (this.psdcmavenrepo == null) {
                PSDCMavenRepo pSDCMavenRepo = new PSDCMavenRepo();
                pSDCMavenRepo.setPSDCMavenRepoId(this.getPSDCMavenRepoId());
                PSDCMavenRepoService pSDCMavenRepoService = (PSDCMavenRepoService)ServiceGlobal.getService(PSDCMavenRepoService.class, (SessionFactory)this.getSessionFactory());
                pSDCMavenRepoService.autoGet(pSDCMavenRepo);
                this.psdcmavenrepo = pSDCMavenRepo;
            }
            return this.psdcmavenrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWorkshopServer getPSDCWorkshopServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkshopServer();
        }
        if (this.getPSDCWorkshopServerId() == null) {
            return null;
        }
        Integer n = this.objPSDCWorkshopServerLock;
        synchronized (n) {
            if (this.psdcworkshopserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCWorkshopServerId(), (Object)this.psdcworkshopserver.getPSDCWorkshopServerId()) != 0L) {
                this.psdcworkshopserver = null;
            }
            if (this.psdcworkshopserver == null) {
                PSDCWorkshopServer pSDCWorkshopServer = new PSDCWorkshopServer();
                pSDCWorkshopServer.setPSDCWorkshopServerId(this.getPSDCWorkshopServerId());
                PSDCWorkshopServerService pSDCWorkshopServerService = (PSDCWorkshopServerService)ServiceGlobal.getService(PSDCWorkshopServerService.class, (SessionFactory)this.getSessionFactory());
                pSDCWorkshopServerService.autoGet(pSDCWorkshopServer);
                this.psdcworkshopserver = pSDCWorkshopServer;
            }
            return this.psdcworkshopserver;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getAdminPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminPSDevUser();
        }
        if (this.getAdminPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objAdminPSDevUserLock;
        synchronized (n) {
            if (this.adminpsdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getAdminPSDevUserId(), (Object)this.adminpsdevuser.getPSDevUserId()) != 0L) {
                this.adminpsdevuser = null;
            }
            if (this.adminpsdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getAdminPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet(pSDevUser);
                this.adminpsdevuser = pSDevUser;
            }
            return this.adminpsdevuser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCDETempl> getPSDCDETempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETempls();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDCDETemplService pSDCDETemplService = (PSDCDETemplService)ServiceGlobal.getService(PSDCDETemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCDETemplsLock;
        synchronized (n) {
            if (this.psdcdetempls == null) {
                this.psdcdetempls = pSDCDETemplService.selectByPSDevSln(this);
            }
            return this.psdcdetempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCModelTempl> getPSDCModelTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTempls();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDCModelTemplService pSDCModelTemplService = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCModelTemplsLock;
        synchronized (n) {
            if (this.psdcmodeltempls == null) {
                this.psdcmodeltempls = pSDCModelTemplService.selectByPSDevSln(this);
            }
            return this.psdcmodeltempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCRegistryRepo> getPSDCRegistryRepo() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryRepo();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDCRegistryRepoService pSDCRegistryRepoService = (PSDCRegistryRepoService)ServiceGlobal.getService(PSDCRegistryRepoService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCRegistryRepoLock;
        synchronized (n) {
            if (this.psdcregistryrepo == null) {
                this.psdcregistryrepo = pSDCRegistryRepoService.selectByPSDevSln(this);
            }
            return this.psdcregistryrepo;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevCenterSVN> getPSDevCenterSVNs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNs();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevCenterSVNsLock;
        synchronized (n) {
            if (this.psdevcentersvns == null) {
                this.psdevcentersvns = pSDevCenterSVNService.selectByPSDevSln(this);
            }
            return this.psdevcentersvns;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevPrd> getPSDevPrds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrds();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevPrdService pSDevPrdService = (PSDevPrdService)ServiceGlobal.getService(PSDevPrdService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevPrdsLock;
        synchronized (n) {
            if (this.psdevprds == null) {
                this.psdevprds = pSDevPrdService.selectByPSDevSln(this);
            }
            return this.psdevprds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnCanvas> getPSDevSlnCanvases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCanvases();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnCanvasService pSDevSlnCanvasService = (PSDevSlnCanvasService)ServiceGlobal.getService(PSDevSlnCanvasService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnCanvasesLock;
        synchronized (n) {
            if (this.psdevslncanvases == null) {
                this.psdevslncanvases = pSDevSlnCanvasService.selectByPSDevSln(this);
            }
            return this.psdevslncanvases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnLink> getPSDevSlnLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnLinks();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnLinkService pSDevSlnLinkService = (PSDevSlnLinkService)ServiceGlobal.getService(PSDevSlnLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnLinksLock;
        synchronized (n) {
            if (this.psdevslnlinks == null) {
                this.psdevslnlinks = pSDevSlnLinkService.selectByPSDevSln(this);
            }
            return this.psdevslnlinks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDeploy> getPSDevSlnMSDeploys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeploys();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnMSDeployService pSDevSlnMSDeployService = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDeploysLock;
        synchronized (n) {
            if (this.psdevslnmsdeploys == null) {
                this.psdevslnmsdeploys = pSDevSlnMSDeployService.selectByPSDevSln(this);
            }
            return this.psdevslnmsdeploys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnMSDepRes> getPSDevSlnMSDepReses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepReses();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnMSDepResService pSDevSlnMSDepResService = (PSDevSlnMSDepResService)ServiceGlobal.getService(PSDevSlnMSDepResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnMSDepResesLock;
        synchronized (n) {
            if (this.psdevslnmsdepreses == null) {
                this.psdevslnmsdepreses = pSDevSlnMSDepResService.selectByPSDevSln(this);
            }
            return this.psdevslnmsdepreses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnRes> getPSDevSlnReses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnReses();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnResService pSDevSlnResService = (PSDevSlnResService)ServiceGlobal.getService(PSDevSlnResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnResesLock;
        synchronized (n) {
            if (this.psdevslnreses == null) {
                this.psdevslnreses = pSDevSlnResService.selectByPSDevSln(this);
            }
            return this.psdevslnreses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysDynaInst> getPSDevSlnSysDynaInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInsts();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysDynaInstsLock;
        synchronized (n) {
            if (this.psdevslnsysdynainsts == null) {
                this.psdevslnsysdynainsts = pSDevSlnSysDynaInstService.selectByPSDevSln(this);
            }
            return this.psdevslnsysdynainsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysGroup> getPSDevSlnSysGroups() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysGroups();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnSysGroupService pSDevSlnSysGroupService = (PSDevSlnSysGroupService)ServiceGlobal.getService(PSDevSlnSysGroupService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysGroupsLock;
        synchronized (n) {
            if (this.psdevslnsysgroups == null) {
                this.psdevslnsysgroups = pSDevSlnSysGroupService.selectByPSDevSln(this);
            }
            return this.psdevslnsysgroups;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSys> getPSDevSlnSyss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSyss();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSyssLock;
        synchronized (n) {
            if (this.psdevslnsyss == null) {
                this.psdevslnsyss = pSDevSlnSysService.selectByPSDevSln(this);
            }
            return this.psdevslnsyss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnTempl> getPSDevSlnTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempls();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnTemplsLock;
        synchronized (n) {
            if (this.psdevslntempls == null) {
                this.psdevslntempls = pSDevSlnTemplService.selectByPSDevSln(this);
            }
            return this.psdevslntempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnUser> getPSDevSlnUsers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnUsers();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        PSDevSlnUserService pSDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnUsersLock;
        synchronized (n) {
            if (this.psdevslnusers == null) {
                this.psdevslnusers = pSDevSlnUserService.selectByPSDevSln(this);
            }
            return this.psdevslnusers;
        }
    }

    private PSDevSlnBase getProxyEntity() {
        return this.proxyPSDevSlnBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnBase) {
            this.proxyPSDevSlnBase = (PSDevSlnBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINPSDEVUSERID, 0);
        fieldIndexMap.put(FIELD_ADMINPSDEVUSERNAME, 1);
        fieldIndexMap.put(FIELD_CALLBACKTAG, 2);
        fieldIndexMap.put(FIELD_CALLBACKURL, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_ENABLECALLBACK, 7);
        fieldIndexMap.put(FIELD_LOGICNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERID, 10);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERNAME, 11);
        fieldIndexMap.put(FIELD_PSDCMAVENREPOID, 12);
        fieldIndexMap.put(FIELD_PSDCMAVENREPONAME, 13);
        fieldIndexMap.put(FIELD_PSDCWORKSHOPSERVERID, 14);
        fieldIndexMap.put(FIELD_PSDCWORKSHOPSERVERNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYSCNT, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSCNT, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNUSERSCNT, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 25);
        fieldIndexMap.put(FIELD_SLNFOLDER, 26);
        fieldIndexMap.put(FIELD_SLNMDURL, 27);
        fieldIndexMap.put(FIELD_SLNSN, 28);
        fieldIndexMap.put(FIELD_SLNTAG, 29);
        fieldIndexMap.put(FIELD_SLNTAG2, 30);
        fieldIndexMap.put(FIELD_SLNTYPE, 31);
        fieldIndexMap.put(FIELD_SLNVER, 32);
        fieldIndexMap.put(FIELD_STUDIOTAG, 33);
        fieldIndexMap.put(FIELD_STUDIOTAG2, 34);
        fieldIndexMap.put(FIELD_STUDIOVER, 35);
        fieldIndexMap.put(FIELD_SYSAPIFLAG, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_USERCAT, 39);
        fieldIndexMap.put(FIELD_USERTAG, 40);
        fieldIndexMap.put(FIELD_USERTAG2, 41);
        fieldIndexMap.put(FIELD_USERTAG3, 42);
        fieldIndexMap.put(FIELD_USERTAG4, 43);
        fieldIndexMap.put(FIELD_VCPASSWORD, 44);
        fieldIndexMap.put(FIELD_VCUSER, 45);
    }
}

