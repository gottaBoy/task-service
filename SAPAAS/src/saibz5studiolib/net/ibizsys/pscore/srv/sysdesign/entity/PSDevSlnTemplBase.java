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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnTemplBase.class);
    public static final String FIELD_ACTIONOWNER = "ACTIONOWNER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURACTION = "CURACTION";
    public static final String FIELD_DEVTEMPLSTATE = "DEVTEMPLSTATE";
    public static final String FIELD_ENABLEREF = "ENABLEREF";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_GITBRANCH = "GITBRANCH";
    public static final String FIELD_GITPATH = "GITPATH";
    public static final String FIELD_LASTACTIVETIME = "LASTACTIVETIME";
    public static final String FIELD_LASTPUBDATE = "LASTPUBDATE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAINPSDEVSLNTEMPLID = "MAINPSDEVSLNTEMPLID";
    public static final String FIELD_MAINPSDEVSLNTEMPLNAME = "MAINPSDEVSLNTEMPLNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PKGPARAM = "PKGPARAM";
    public static final String FIELD_PKGPARAM2 = "PKGPARAM2";
    public static final String FIELD_PKGPARAM3 = "PKGPARAM3";
    public static final String FIELD_PKGPARAM4 = "PKGPARAM4";
    public static final String FIELD_PPSDEVSLNTEMPLID = "PPSDEVSLNTEMPLID";
    public static final String FIELD_PPSDEVSLNTEMPLNAME = "PPSDEVSLNTEMPLNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String FIELD_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSSRVID = "PSDEVSLNSYSSRVID";
    public static final String FIELD_PSDEVSLNSYSSRVNAME = "PSDEVSLNSYSSRVNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_REFCODE = "REFCODE";
    public static final String FIELD_STYLECODE = "STYLECODE";
    public static final String FIELD_STYLEENGINE = "STYLEENGINE";
    public static final String FIELD_TEMPLMDURL = "TEMPLMDURL";
    public static final String FIELD_TEMPLPARAMS = "TEMPLPARAMS";
    public static final String FIELD_TEMPLPSPFSTYLEID = "TEMPLPSPFSTYLEID";
    public static final String FIELD_TEMPLPSPFSTYLENAME = "TEMPLPSPFSTYLENAME";
    public static final String FIELD_TEMPLPSSFSTYLEID = "TEMPLPSSFSTYLEID";
    public static final String FIELD_TEMPLPSSFSTYLENAME = "TEMPLPSSFSTYLENAME";
    public static final String FIELD_TEMPLTAG = "TEMPLTAG";
    public static final String FIELD_TEMPLTAG2 = "TEMPLTAG2";
    public static final String FIELD_TEMPLTYPE = "TEMPLTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_V2GITPATH = "V2GITPATH";
    public static final String FIELD_VCTYPE = "VCTYPE";
    public static final String FIELD_VERSTR = "VERSTR";
    private static final int INDEX_ACTIONOWNER = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CURACTION = 3;
    private static final int INDEX_DEVTEMPLSTATE = 4;
    private static final int INDEX_ENABLEREF = 5;
    private static final int INDEX_EXPRIEDTIME = 6;
    private static final int INDEX_GITBRANCH = 7;
    private static final int INDEX_GITPATH = 8;
    private static final int INDEX_LASTACTIVETIME = 9;
    private static final int INDEX_LASTPUBDATE = 10;
    private static final int INDEX_LOGICNAME = 11;
    private static final int INDEX_MAINPSDEVSLNTEMPLID = 12;
    private static final int INDEX_MAINPSDEVSLNTEMPLNAME = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_PKGPARAM = 15;
    private static final int INDEX_PKGPARAM2 = 16;
    private static final int INDEX_PKGPARAM3 = 17;
    private static final int INDEX_PKGPARAM4 = 18;
    private static final int INDEX_PPSDEVSLNTEMPLID = 19;
    private static final int INDEX_PPSDEVSLNTEMPLNAME = 20;
    private static final int INDEX_PSDEVCENTERID = 21;
    private static final int INDEX_PSDEVCENTERNAME = 22;
    private static final int INDEX_PSDEVCENTERSVNID = 23;
    private static final int INDEX_PSDEVCENTERSVNNAME = 24;
    private static final int INDEX_PSDEVSLNID = 25;
    private static final int INDEX_PSDEVSLNNAME = 26;
    private static final int INDEX_PSDEVSLNSYSAPPID = 27;
    private static final int INDEX_PSDEVSLNSYSAPPNAME = 28;
    private static final int INDEX_PSDEVSLNSYSID = 29;
    private static final int INDEX_PSDEVSLNSYSNAME = 30;
    private static final int INDEX_PSDEVSLNSYSSRVID = 31;
    private static final int INDEX_PSDEVSLNSYSSRVNAME = 32;
    private static final int INDEX_PSDEVSLNTEMPLID = 33;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 34;
    private static final int INDEX_PSPFID = 35;
    private static final int INDEX_PSPFNAME = 36;
    private static final int INDEX_PSPFSTYLEID = 37;
    private static final int INDEX_PSPFSTYLENAME = 38;
    private static final int INDEX_PSSFID = 39;
    private static final int INDEX_PSSFNAME = 40;
    private static final int INDEX_PSSFSTYLEID = 41;
    private static final int INDEX_PSSFSTYLENAME = 42;
    private static final int INDEX_PUBMODE = 43;
    private static final int INDEX_REFCODE = 44;
    private static final int INDEX_STYLECODE = 45;
    private static final int INDEX_STYLEENGINE = 46;
    private static final int INDEX_TEMPLMDURL = 47;
    private static final int INDEX_TEMPLPARAMS = 48;
    private static final int INDEX_TEMPLPSPFSTYLEID = 49;
    private static final int INDEX_TEMPLPSPFSTYLENAME = 50;
    private static final int INDEX_TEMPLPSSFSTYLEID = 51;
    private static final int INDEX_TEMPLPSSFSTYLENAME = 52;
    private static final int INDEX_TEMPLTAG = 53;
    private static final int INDEX_TEMPLTAG2 = 54;
    private static final int INDEX_TEMPLTYPE = 55;
    private static final int INDEX_UPDATEDATE = 56;
    private static final int INDEX_UPDATEMAN = 57;
    private static final int INDEX_USERCAT = 58;
    private static final int INDEX_USERTAG = 59;
    private static final int INDEX_USERTAG2 = 60;
    private static final int INDEX_USERTAG3 = 61;
    private static final int INDEX_USERTAG4 = 62;
    private static final int INDEX_V2GITPATH = 63;
    private static final int INDEX_VCTYPE = 64;
    private static final int INDEX_VERSTR = 65;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnTemplBase proxyPSDevSlnTemplBase = null;
    private boolean actionownerDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curactionDirtyFlag = false;
    private boolean devtemplstateDirtyFlag = false;
    private boolean enablerefDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean gitbranchDirtyFlag = false;
    private boolean gitpathDirtyFlag = false;
    private boolean lastactivetimeDirtyFlag = false;
    private boolean lastpubdateDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean mainpsdevslntemplidDirtyFlag = false;
    private boolean mainpsdevslntemplnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pkgparamDirtyFlag = false;
    private boolean pkgparam2DirtyFlag = false;
    private boolean pkgparam3DirtyFlag = false;
    private boolean pkgparam4DirtyFlag = false;
    private boolean ppsdevslntemplidDirtyFlag = false;
    private boolean ppsdevslntemplnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysappidDirtyFlag = false;
    private boolean psdevslnsysappnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsyssrvidDirtyFlag = false;
    private boolean psdevslnsyssrvnameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean refcodeDirtyFlag = false;
    private boolean stylecodeDirtyFlag = false;
    private boolean styleengineDirtyFlag = false;
    private boolean templmdurlDirtyFlag = false;
    private boolean templparamsDirtyFlag = false;
    private boolean templpspfstyleidDirtyFlag = false;
    private boolean templpspfstylenameDirtyFlag = false;
    private boolean templpssfstyleidDirtyFlag = false;
    private boolean templpssfstylenameDirtyFlag = false;
    private boolean templtagDirtyFlag = false;
    private boolean templtag2DirtyFlag = false;
    private boolean templtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean v2gitpathDirtyFlag = false;
    private boolean vctypeDirtyFlag = false;
    private boolean verstrDirtyFlag = false;
    @Column(name="actionowner")
    private String actionowner;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curaction")
    private String curaction;
    @Column(name="devtemplstate")
    private Integer devtemplstate;
    @Column(name="enableref")
    private Integer enableref;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="gitbranch")
    private String gitbranch;
    @Column(name="gitpath")
    private String gitpath;
    @Column(name="lastactivetime")
    private Timestamp lastactivetime;
    @Column(name="lastpubdate")
    private Timestamp lastpubdate;
    @Column(name="logicname")
    private String logicname;
    @Column(name="mainpsdevslntemplid")
    private String mainpsdevslntemplid;
    @Column(name="mainpsdevslntemplname")
    private String mainpsdevslntemplname;
    @Column(name="memo")
    private String memo;
    @Column(name="pkgparam")
    private String pkgparam;
    @Column(name="pkgparam2")
    private String pkgparam2;
    @Column(name="pkgparam3")
    private String pkgparam3;
    @Column(name="pkgparam4")
    private String pkgparam4;
    @Column(name="ppsdevslntemplid")
    private String ppsdevslntemplid;
    @Column(name="ppsdevslntemplname")
    private String ppsdevslntemplname;
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
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysappid")
    private String psdevslnsysappid;
    @Column(name="psdevslnsysappname")
    private String psdevslnsysappname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsyssrvid")
    private String psdevslnsyssrvid;
    @Column(name="psdevslnsyssrvname")
    private String psdevslnsyssrvname;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="refcode")
    private String refcode;
    @Column(name="stylecode")
    private String stylecode;
    @Column(name="styleengine")
    private String styleengine;
    @Column(name="templmdurl")
    private String templmdurl;
    @Column(name="templparams")
    private String templparams;
    @Column(name="templpspfstyleid")
    private String templpspfstyleid;
    @Column(name="templpspfstylename")
    private String templpspfstylename;
    @Column(name="templpssfstyleid")
    private String templpssfstyleid;
    @Column(name="templpssfstylename")
    private String templpssfstylename;
    @Column(name="templtag")
    private String templtag;
    @Column(name="templtag2")
    private String templtag2;
    @Column(name="templtype")
    private String templtype;
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
    @Column(name="v2gitpath")
    private String v2gitpath;
    @Column(name="vctype")
    private String vctype;
    @Column(name="verstr")
    private String verstr;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevSlnSysAppLock = new Integer(1);
    private PSDevSlnSysApp psdevslnsysapp = null;
    private Integer objPSDevSlnSysSrvLock = new Integer(1);
    private PSDevSlnSysSrv psdevslnsyssrv = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objMainPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl mainpsdevslntempl = null;
    private Integer objPPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl ppsdevslntempl = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objTemplPSPFStyleLock = new Integer(1);
    private PSPFStyle templpspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objTemplPSSFStyleLock = new Integer(1);
    private PSSFStyle templpssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSDevSlnTemplRefsLock = new Integer(1);
    private ArrayList<PSDevSlnTemplRef> psdevslntemplrefs = null;

    public void setActionOwner(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionOwner(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionowner = string;
        this.actionownerDirtyFlag = true;
    }

    public String getActionOwner() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionOwner();
        }
        return this.actionowner;
    }

    public boolean isActionOwnerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionOwnerDirty();
        }
        return this.actionownerDirtyFlag;
    }

    public void resetActionOwner() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionOwner();
            return;
        }
        this.actionownerDirtyFlag = false;
        this.actionowner = null;
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

    public void setCurAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curaction = string;
        this.curactionDirtyFlag = true;
    }

    public String getCurAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurAction();
        }
        return this.curaction;
    }

    public boolean isCurActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurActionDirty();
        }
        return this.curactionDirtyFlag;
    }

    public void resetCurAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurAction();
            return;
        }
        this.curactionDirtyFlag = false;
        this.curaction = null;
    }

    public void setDevTemplState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDevTemplState(n);
            return;
        }
        this.devtemplstate = n;
        this.devtemplstateDirtyFlag = true;
    }

    public Integer getDevTemplState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDevTemplState();
        }
        return this.devtemplstate;
    }

    public boolean isDevTemplStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDevTemplStateDirty();
        }
        return this.devtemplstateDirtyFlag;
    }

    public void resetDevTemplState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDevTemplState();
            return;
        }
        this.devtemplstateDirtyFlag = false;
        this.devtemplstate = null;
    }

    public void setEnableRef(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableRef(n);
            return;
        }
        this.enableref = n;
        this.enablerefDirtyFlag = true;
    }

    public Integer getEnableRef() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableRef();
        }
        return this.enableref;
    }

    public boolean isEnableRefDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableRefDirty();
        }
        return this.enablerefDirtyFlag;
    }

    public void resetEnableRef() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableRef();
            return;
        }
        this.enablerefDirtyFlag = false;
        this.enableref = null;
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

    public void setGitBranch(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitBranch(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitbranch = string;
        this.gitbranchDirtyFlag = true;
    }

    public String getGitBranch() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitBranch();
        }
        return this.gitbranch;
    }

    public boolean isGitBranchDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitBranchDirty();
        }
        return this.gitbranchDirtyFlag;
    }

    public void resetGitBranch() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitBranch();
            return;
        }
        this.gitbranchDirtyFlag = false;
        this.gitbranch = null;
    }

    public void setGitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gitpath = string;
        this.gitpathDirtyFlag = true;
    }

    public String getGitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGitPath();
        }
        return this.gitpath;
    }

    public boolean isGitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGitPathDirty();
        }
        return this.gitpathDirtyFlag;
    }

    public void resetGitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGitPath();
            return;
        }
        this.gitpathDirtyFlag = false;
        this.gitpath = null;
    }

    public void setLastActiveTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastActiveTime(timestamp);
            return;
        }
        this.lastactivetime = timestamp;
        this.lastactivetimeDirtyFlag = true;
    }

    public Timestamp getLastActiveTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastActiveTime();
        }
        return this.lastactivetime;
    }

    public boolean isLastActiveTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastActiveTimeDirty();
        }
        return this.lastactivetimeDirtyFlag;
    }

    public void resetLastActiveTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastActiveTime();
            return;
        }
        this.lastactivetimeDirtyFlag = false;
        this.lastactivetime = null;
    }

    public void setLastPubDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastPubDate(timestamp);
            return;
        }
        this.lastpubdate = timestamp;
        this.lastpubdateDirtyFlag = true;
    }

    public Timestamp getLastPubDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastPubDate();
        }
        return this.lastpubdate;
    }

    public boolean isLastPubDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastPubDateDirty();
        }
        return this.lastpubdateDirtyFlag;
    }

    public void resetLastPubDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastPubDate();
            return;
        }
        this.lastpubdateDirtyFlag = false;
        this.lastpubdate = null;
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

    public void setMainPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpsdevslntemplid = string;
        this.mainpsdevslntemplidDirtyFlag = true;
    }

    public String getMainPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSDevSlnTemplId();
        }
        return this.mainpsdevslntemplid;
    }

    public boolean isMainPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSDevSlnTemplIdDirty();
        }
        return this.mainpsdevslntemplidDirtyFlag;
    }

    public void resetMainPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSDevSlnTemplId();
            return;
        }
        this.mainpsdevslntemplidDirtyFlag = false;
        this.mainpsdevslntemplid = null;
    }

    public void setMainPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpsdevslntemplname = string;
        this.mainpsdevslntemplnameDirtyFlag = true;
    }

    public String getMainPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSDevSlnTemplName();
        }
        return this.mainpsdevslntemplname;
    }

    public boolean isMainPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSDevSlnTemplNameDirty();
        }
        return this.mainpsdevslntemplnameDirtyFlag;
    }

    public void resetMainPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSDevSlnTemplName();
            return;
        }
        this.mainpsdevslntemplnameDirtyFlag = false;
        this.mainpsdevslntemplname = null;
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

    public void setPkgParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam = string;
        this.pkgparamDirtyFlag = true;
    }

    public String getPkgParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam();
        }
        return this.pkgparam;
    }

    public boolean isPkgParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParamDirty();
        }
        return this.pkgparamDirtyFlag;
    }

    public void resetPkgParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam();
            return;
        }
        this.pkgparamDirtyFlag = false;
        this.pkgparam = null;
    }

    public void setPkgParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam2 = string;
        this.pkgparam2DirtyFlag = true;
    }

    public String getPkgParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam2();
        }
        return this.pkgparam2;
    }

    public boolean isPkgParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam2Dirty();
        }
        return this.pkgparam2DirtyFlag;
    }

    public void resetPkgParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam2();
            return;
        }
        this.pkgparam2DirtyFlag = false;
        this.pkgparam2 = null;
    }

    public void setPkgParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam3 = string;
        this.pkgparam3DirtyFlag = true;
    }

    public String getPkgParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam3();
        }
        return this.pkgparam3;
    }

    public boolean isPkgParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam3Dirty();
        }
        return this.pkgparam3DirtyFlag;
    }

    public void resetPkgParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam3();
            return;
        }
        this.pkgparam3DirtyFlag = false;
        this.pkgparam3 = null;
    }

    public void setPkgParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam4 = string;
        this.pkgparam4DirtyFlag = true;
    }

    public String getPkgParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam4();
        }
        return this.pkgparam4;
    }

    public boolean isPkgParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam4Dirty();
        }
        return this.pkgparam4DirtyFlag;
    }

    public void resetPkgParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam4();
            return;
        }
        this.pkgparam4DirtyFlag = false;
        this.pkgparam4 = null;
    }

    public void setPPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslntemplid = string;
        this.ppsdevslntemplidDirtyFlag = true;
    }

    public String getPPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnTemplId();
        }
        return this.ppsdevslntemplid;
    }

    public boolean isPPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnTemplIdDirty();
        }
        return this.ppsdevslntemplidDirtyFlag;
    }

    public void resetPPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnTemplId();
            return;
        }
        this.ppsdevslntemplidDirtyFlag = false;
        this.ppsdevslntemplid = null;
    }

    public void setPPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslntemplname = string;
        this.ppsdevslntemplnameDirtyFlag = true;
    }

    public String getPPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnTemplName();
        }
        return this.ppsdevslntemplname;
    }

    public boolean isPPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnTemplNameDirty();
        }
        return this.ppsdevslntemplnameDirtyFlag;
    }

    public void resetPPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnTemplName();
            return;
        }
        this.ppsdevslntemplnameDirtyFlag = false;
        this.ppsdevslntemplname = null;
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

    public void setPSDevSlnSysSrvId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvid = string;
        this.psdevslnsyssrvidDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvId();
        }
        return this.psdevslnsyssrvid;
    }

    public boolean isPSDevSlnSysSrvIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvIdDirty();
        }
        return this.psdevslnsyssrvidDirtyFlag;
    }

    public void resetPSDevSlnSysSrvId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvId();
            return;
        }
        this.psdevslnsyssrvidDirtyFlag = false;
        this.psdevslnsyssrvid = null;
    }

    public void setPSDevSlnSysSrvName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrvName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrvname = string;
        this.psdevslnsyssrvnameDirtyFlag = true;
    }

    public String getPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrvName();
        }
        return this.psdevslnsyssrvname;
    }

    public boolean isPSDevSlnSysSrvNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrvNameDirty();
        }
        return this.psdevslnsyssrvnameDirtyFlag;
    }

    public void resetPSDevSlnSysSrvName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrvName();
            return;
        }
        this.psdevslnsyssrvnameDirtyFlag = false;
        this.psdevslnsyssrvname = null;
    }

    public void setPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplid = string;
        this.psdevslntemplidDirtyFlag = true;
    }

    public String getPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplId();
        }
        return this.psdevslntemplid;
    }

    public boolean isPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplIdDirty();
        }
        return this.psdevslntemplidDirtyFlag;
    }

    public void resetPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplId();
            return;
        }
        this.psdevslntemplidDirtyFlag = false;
        this.psdevslntemplid = null;
    }

    public void setPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplname = string;
        this.psdevslntemplnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplName();
        }
        return this.psdevslntemplname;
    }

    public boolean isPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplNameDirty();
        }
        return this.psdevslntemplnameDirtyFlag;
    }

    public void resetPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplName();
            return;
        }
        this.psdevslntemplnameDirtyFlag = false;
        this.psdevslntemplname = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
    }

    public void setRefCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refcode = string;
        this.refcodeDirtyFlag = true;
    }

    public String getRefCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCode();
        }
        return this.refcode;
    }

    public boolean isRefCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCodeDirty();
        }
        return this.refcodeDirtyFlag;
    }

    public void resetRefCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCode();
            return;
        }
        this.refcodeDirtyFlag = false;
        this.refcode = null;
    }

    public void setStyleCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stylecode = string;
        this.stylecodeDirtyFlag = true;
    }

    public String getStyleCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleCode();
        }
        return this.stylecode;
    }

    public boolean isStyleCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleCodeDirty();
        }
        return this.stylecodeDirtyFlag;
    }

    public void resetStyleCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleCode();
            return;
        }
        this.stylecodeDirtyFlag = false;
        this.stylecode = null;
    }

    public void setStyleEngine(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleEngine(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.styleengine = string;
        this.styleengineDirtyFlag = true;
    }

    public String getStyleEngine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleEngine();
        }
        return this.styleengine;
    }

    public boolean isStyleEngineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleEngineDirty();
        }
        return this.styleengineDirtyFlag;
    }

    public void resetStyleEngine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleEngine();
            return;
        }
        this.styleengineDirtyFlag = false;
        this.styleengine = null;
    }

    public void setTemplMDUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplMDUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templmdurl = string;
        this.templmdurlDirtyFlag = true;
    }

    public String getTemplMDUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplMDUrl();
        }
        return this.templmdurl;
    }

    public boolean isTemplMDUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplMDUrlDirty();
        }
        return this.templmdurlDirtyFlag;
    }

    public void resetTemplMDUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplMDUrl();
            return;
        }
        this.templmdurlDirtyFlag = false;
        this.templmdurl = null;
    }

    public void setTemplParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templparams = string;
        this.templparamsDirtyFlag = true;
    }

    public String getTemplParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplParams();
        }
        return this.templparams;
    }

    public boolean isTemplParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplParamsDirty();
        }
        return this.templparamsDirtyFlag;
    }

    public void resetTemplParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplParams();
            return;
        }
        this.templparamsDirtyFlag = false;
        this.templparams = null;
    }

    public void setTemplPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpspfstyleid = string;
        this.templpspfstyleidDirtyFlag = true;
    }

    public String getTemplPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSPFStyleId();
        }
        return this.templpspfstyleid;
    }

    public boolean isTemplPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSPFStyleIdDirty();
        }
        return this.templpspfstyleidDirtyFlag;
    }

    public void resetTemplPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSPFStyleId();
            return;
        }
        this.templpspfstyleidDirtyFlag = false;
        this.templpspfstyleid = null;
    }

    public void setTemplPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpspfstylename = string;
        this.templpspfstylenameDirtyFlag = true;
    }

    public String getTemplPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSPFStyleName();
        }
        return this.templpspfstylename;
    }

    public boolean isTemplPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSPFStyleNameDirty();
        }
        return this.templpspfstylenameDirtyFlag;
    }

    public void resetTemplPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSPFStyleName();
            return;
        }
        this.templpspfstylenameDirtyFlag = false;
        this.templpspfstylename = null;
    }

    public void setTemplPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpssfstyleid = string;
        this.templpssfstyleidDirtyFlag = true;
    }

    public String getTemplPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSSFStyleId();
        }
        return this.templpssfstyleid;
    }

    public boolean isTemplPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSSFStyleIdDirty();
        }
        return this.templpssfstyleidDirtyFlag;
    }

    public void resetTemplPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSSFStyleId();
            return;
        }
        this.templpssfstyleidDirtyFlag = false;
        this.templpssfstyleid = null;
    }

    public void setTemplPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templpssfstylename = string;
        this.templpssfstylenameDirtyFlag = true;
    }

    public String getTemplPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSSFStyleName();
        }
        return this.templpssfstylename;
    }

    public boolean isTemplPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplPSSFStyleNameDirty();
        }
        return this.templpssfstylenameDirtyFlag;
    }

    public void resetTemplPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplPSSFStyleName();
            return;
        }
        this.templpssfstylenameDirtyFlag = false;
        this.templpssfstylename = null;
    }

    public void setTemplTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templtag = string;
        this.templtagDirtyFlag = true;
    }

    public String getTemplTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplTag();
        }
        return this.templtag;
    }

    public boolean isTemplTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplTagDirty();
        }
        return this.templtagDirtyFlag;
    }

    public void resetTemplTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplTag();
            return;
        }
        this.templtagDirtyFlag = false;
        this.templtag = null;
    }

    public void setTemplTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templtag2 = string;
        this.templtag2DirtyFlag = true;
    }

    public String getTemplTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplTag2();
        }
        return this.templtag2;
    }

    public boolean isTemplTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplTag2Dirty();
        }
        return this.templtag2DirtyFlag;
    }

    public void resetTemplTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplTag2();
            return;
        }
        this.templtag2DirtyFlag = false;
        this.templtag2 = null;
    }

    public void setTemplType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templtype = string;
        this.templtypeDirtyFlag = true;
    }

    public String getTemplType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplType();
        }
        return this.templtype;
    }

    public boolean isTemplTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplTypeDirty();
        }
        return this.templtypeDirtyFlag;
    }

    public void resetTemplType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplType();
            return;
        }
        this.templtypeDirtyFlag = false;
        this.templtype = null;
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

    public void setV2GitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2GitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2gitpath = string;
        this.v2gitpathDirtyFlag = true;
    }

    public String getV2GitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2GitPath();
        }
        return this.v2gitpath;
    }

    public boolean isV2GitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2GitPathDirty();
        }
        return this.v2gitpathDirtyFlag;
    }

    public void resetV2GitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2GitPath();
            return;
        }
        this.v2gitpathDirtyFlag = false;
        this.v2gitpath = null;
    }

    public void setVCType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVCType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vctype = string;
        this.vctypeDirtyFlag = true;
    }

    public String getVCType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVCType();
        }
        return this.vctype;
    }

    public boolean isVCTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVCTypeDirty();
        }
        return this.vctypeDirtyFlag;
    }

    public void resetVCType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVCType();
            return;
        }
        this.vctypeDirtyFlag = false;
        this.vctype = null;
    }

    public void setVerStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verstr = string;
        this.verstrDirtyFlag = true;
    }

    public String getVerStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerStr();
        }
        return this.verstr;
    }

    public boolean isVerStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerStrDirty();
        }
        return this.verstrDirtyFlag;
    }

    public void resetVerStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerStr();
            return;
        }
        this.verstrDirtyFlag = false;
        this.verstr = null;
    }

    protected void onReset() {
        PSDevSlnTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnTemplBase pSDevSlnTemplBase) {
        pSDevSlnTemplBase.resetActionOwner();
        pSDevSlnTemplBase.resetCreateDate();
        pSDevSlnTemplBase.resetCreateMan();
        pSDevSlnTemplBase.resetCurAction();
        pSDevSlnTemplBase.resetDevTemplState();
        pSDevSlnTemplBase.resetEnableRef();
        pSDevSlnTemplBase.resetExpriedTime();
        pSDevSlnTemplBase.resetGitBranch();
        pSDevSlnTemplBase.resetGitPath();
        pSDevSlnTemplBase.resetLastActiveTime();
        pSDevSlnTemplBase.resetLastPubDate();
        pSDevSlnTemplBase.resetLogicName();
        pSDevSlnTemplBase.resetMainPSDevSlnTemplId();
        pSDevSlnTemplBase.resetMainPSDevSlnTemplName();
        pSDevSlnTemplBase.resetMemo();
        pSDevSlnTemplBase.resetPkgParam();
        pSDevSlnTemplBase.resetPkgParam2();
        pSDevSlnTemplBase.resetPkgParam3();
        pSDevSlnTemplBase.resetPkgParam4();
        pSDevSlnTemplBase.resetPPSDevSlnTemplId();
        pSDevSlnTemplBase.resetPPSDevSlnTemplName();
        pSDevSlnTemplBase.resetPSDevCenterId();
        pSDevSlnTemplBase.resetPSDevCenterName();
        pSDevSlnTemplBase.resetPSDevCenterSVNId();
        pSDevSlnTemplBase.resetPSDevCenterSVNName();
        pSDevSlnTemplBase.resetPSDevSlnId();
        pSDevSlnTemplBase.resetPSDevSlnName();
        pSDevSlnTemplBase.resetPSDevSlnSysAppId();
        pSDevSlnTemplBase.resetPSDevSlnSysAppName();
        pSDevSlnTemplBase.resetPSDevSlnSysId();
        pSDevSlnTemplBase.resetPSDevSlnSysName();
        pSDevSlnTemplBase.resetPSDevSlnSysSrvId();
        pSDevSlnTemplBase.resetPSDevSlnSysSrvName();
        pSDevSlnTemplBase.resetPSDevSlnTemplId();
        pSDevSlnTemplBase.resetPSDevSlnTemplName();
        pSDevSlnTemplBase.resetPSPFId();
        pSDevSlnTemplBase.resetPSPFName();
        pSDevSlnTemplBase.resetPSPFStyleId();
        pSDevSlnTemplBase.resetPSPFStyleName();
        pSDevSlnTemplBase.resetPSSFId();
        pSDevSlnTemplBase.resetPSSFName();
        pSDevSlnTemplBase.resetPSSFStyleId();
        pSDevSlnTemplBase.resetPSSFStyleName();
        pSDevSlnTemplBase.resetPubMode();
        pSDevSlnTemplBase.resetRefCode();
        pSDevSlnTemplBase.resetStyleCode();
        pSDevSlnTemplBase.resetStyleEngine();
        pSDevSlnTemplBase.resetTemplMDUrl();
        pSDevSlnTemplBase.resetTemplParams();
        pSDevSlnTemplBase.resetTemplPSPFStyleId();
        pSDevSlnTemplBase.resetTemplPSPFStyleName();
        pSDevSlnTemplBase.resetTemplPSSFStyleId();
        pSDevSlnTemplBase.resetTemplPSSFStyleName();
        pSDevSlnTemplBase.resetTemplTag();
        pSDevSlnTemplBase.resetTemplTag2();
        pSDevSlnTemplBase.resetTemplType();
        pSDevSlnTemplBase.resetUpdateDate();
        pSDevSlnTemplBase.resetUpdateMan();
        pSDevSlnTemplBase.resetUserCat();
        pSDevSlnTemplBase.resetUserTag();
        pSDevSlnTemplBase.resetUserTag2();
        pSDevSlnTemplBase.resetUserTag3();
        pSDevSlnTemplBase.resetUserTag4();
        pSDevSlnTemplBase.resetV2GitPath();
        pSDevSlnTemplBase.resetVCType();
        pSDevSlnTemplBase.resetVerStr();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionOwnerDirty()) {
            hashMap.put(FIELD_ACTIONOWNER, this.getActionOwner());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurActionDirty()) {
            hashMap.put(FIELD_CURACTION, this.getCurAction());
        }
        if (!bl || this.isDevTemplStateDirty()) {
            hashMap.put(FIELD_DEVTEMPLSTATE, this.getDevTemplState());
        }
        if (!bl || this.isEnableRefDirty()) {
            hashMap.put(FIELD_ENABLEREF, this.getEnableRef());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isGitBranchDirty()) {
            hashMap.put(FIELD_GITBRANCH, this.getGitBranch());
        }
        if (!bl || this.isGitPathDirty()) {
            hashMap.put(FIELD_GITPATH, this.getGitPath());
        }
        if (!bl || this.isLastActiveTimeDirty()) {
            hashMap.put(FIELD_LASTACTIVETIME, this.getLastActiveTime());
        }
        if (!bl || this.isLastPubDateDirty()) {
            hashMap.put(FIELD_LASTPUBDATE, this.getLastPubDate());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMainPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_MAINPSDEVSLNTEMPLID, this.getMainPSDevSlnTemplId());
        }
        if (!bl || this.isMainPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_MAINPSDEVSLNTEMPLNAME, this.getMainPSDevSlnTemplName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPkgParamDirty()) {
            hashMap.put(FIELD_PKGPARAM, this.getPkgParam());
        }
        if (!bl || this.isPkgParam2Dirty()) {
            hashMap.put(FIELD_PKGPARAM2, this.getPkgParam2());
        }
        if (!bl || this.isPkgParam3Dirty()) {
            hashMap.put(FIELD_PKGPARAM3, this.getPkgParam3());
        }
        if (!bl || this.isPkgParam4Dirty()) {
            hashMap.put(FIELD_PKGPARAM4, this.getPkgParam4());
        }
        if (!bl || this.isPPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PPSDEVSLNTEMPLID, this.getPPSDevSlnTemplId());
        }
        if (!bl || this.isPPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PPSDEVSLNTEMPLNAME, this.getPPSDevSlnTemplName());
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
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
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
        if (!bl || this.isPSDevSlnSysSrvIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVID, this.getPSDevSlnSysSrvId());
        }
        if (!bl || this.isPSDevSlnSysSrvNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRVNAME, this.getPSDevSlnSysSrvName());
        }
        if (!bl || this.isPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLID, this.getPSDevSlnTemplId());
        }
        if (!bl || this.isPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLNAME, this.getPSDevSlnTemplName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isRefCodeDirty()) {
            hashMap.put(FIELD_REFCODE, this.getRefCode());
        }
        if (!bl || this.isStyleCodeDirty()) {
            hashMap.put(FIELD_STYLECODE, this.getStyleCode());
        }
        if (!bl || this.isStyleEngineDirty()) {
            hashMap.put(FIELD_STYLEENGINE, this.getStyleEngine());
        }
        if (!bl || this.isTemplMDUrlDirty()) {
            hashMap.put(FIELD_TEMPLMDURL, this.getTemplMDUrl());
        }
        if (!bl || this.isTemplParamsDirty()) {
            hashMap.put(FIELD_TEMPLPARAMS, this.getTemplParams());
        }
        if (!bl || this.isTemplPSPFStyleIdDirty()) {
            hashMap.put(FIELD_TEMPLPSPFSTYLEID, this.getTemplPSPFStyleId());
        }
        if (!bl || this.isTemplPSPFStyleNameDirty()) {
            hashMap.put(FIELD_TEMPLPSPFSTYLENAME, this.getTemplPSPFStyleName());
        }
        if (!bl || this.isTemplPSSFStyleIdDirty()) {
            hashMap.put(FIELD_TEMPLPSSFSTYLEID, this.getTemplPSSFStyleId());
        }
        if (!bl || this.isTemplPSSFStyleNameDirty()) {
            hashMap.put(FIELD_TEMPLPSSFSTYLENAME, this.getTemplPSSFStyleName());
        }
        if (!bl || this.isTemplTagDirty()) {
            hashMap.put(FIELD_TEMPLTAG, this.getTemplTag());
        }
        if (!bl || this.isTemplTag2Dirty()) {
            hashMap.put(FIELD_TEMPLTAG2, this.getTemplTag2());
        }
        if (!bl || this.isTemplTypeDirty()) {
            hashMap.put(FIELD_TEMPLTYPE, this.getTemplType());
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
        if (!bl || this.isV2GitPathDirty()) {
            hashMap.put(FIELD_V2GITPATH, this.getV2GitPath());
        }
        if (!bl || this.isVCTypeDirty()) {
            hashMap.put(FIELD_VCTYPE, this.getVCType());
        }
        if (!bl || this.isVerStrDirty()) {
            hashMap.put(FIELD_VERSTR, this.getVerStr());
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
        return PSDevSlnTemplBase.get(this, n);
    }

    private static Object get(PSDevSlnTemplBase pSDevSlnTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnTemplBase.getActionOwner();
            }
            case 1: {
                return pSDevSlnTemplBase.getCreateDate();
            }
            case 2: {
                return pSDevSlnTemplBase.getCreateMan();
            }
            case 3: {
                return pSDevSlnTemplBase.getCurAction();
            }
            case 4: {
                return pSDevSlnTemplBase.getDevTemplState();
            }
            case 5: {
                return pSDevSlnTemplBase.getEnableRef();
            }
            case 6: {
                return pSDevSlnTemplBase.getExpriedTime();
            }
            case 7: {
                return pSDevSlnTemplBase.getGitBranch();
            }
            case 8: {
                return pSDevSlnTemplBase.getGitPath();
            }
            case 9: {
                return pSDevSlnTemplBase.getLastActiveTime();
            }
            case 10: {
                return pSDevSlnTemplBase.getLastPubDate();
            }
            case 11: {
                return pSDevSlnTemplBase.getLogicName();
            }
            case 12: {
                return pSDevSlnTemplBase.getMainPSDevSlnTemplId();
            }
            case 13: {
                return pSDevSlnTemplBase.getMainPSDevSlnTemplName();
            }
            case 14: {
                return pSDevSlnTemplBase.getMemo();
            }
            case 15: {
                return pSDevSlnTemplBase.getPkgParam();
            }
            case 16: {
                return pSDevSlnTemplBase.getPkgParam2();
            }
            case 17: {
                return pSDevSlnTemplBase.getPkgParam3();
            }
            case 18: {
                return pSDevSlnTemplBase.getPkgParam4();
            }
            case 19: {
                return pSDevSlnTemplBase.getPPSDevSlnTemplId();
            }
            case 20: {
                return pSDevSlnTemplBase.getPPSDevSlnTemplName();
            }
            case 21: {
                return pSDevSlnTemplBase.getPSDevCenterId();
            }
            case 22: {
                return pSDevSlnTemplBase.getPSDevCenterName();
            }
            case 23: {
                return pSDevSlnTemplBase.getPSDevCenterSVNId();
            }
            case 24: {
                return pSDevSlnTemplBase.getPSDevCenterSVNName();
            }
            case 25: {
                return pSDevSlnTemplBase.getPSDevSlnId();
            }
            case 26: {
                return pSDevSlnTemplBase.getPSDevSlnName();
            }
            case 27: {
                return pSDevSlnTemplBase.getPSDevSlnSysAppId();
            }
            case 28: {
                return pSDevSlnTemplBase.getPSDevSlnSysAppName();
            }
            case 29: {
                return pSDevSlnTemplBase.getPSDevSlnSysId();
            }
            case 30: {
                return pSDevSlnTemplBase.getPSDevSlnSysName();
            }
            case 31: {
                return pSDevSlnTemplBase.getPSDevSlnSysSrvId();
            }
            case 32: {
                return pSDevSlnTemplBase.getPSDevSlnSysSrvName();
            }
            case 33: {
                return pSDevSlnTemplBase.getPSDevSlnTemplId();
            }
            case 34: {
                return pSDevSlnTemplBase.getPSDevSlnTemplName();
            }
            case 35: {
                return pSDevSlnTemplBase.getPSPFId();
            }
            case 36: {
                return pSDevSlnTemplBase.getPSPFName();
            }
            case 37: {
                return pSDevSlnTemplBase.getPSPFStyleId();
            }
            case 38: {
                return pSDevSlnTemplBase.getPSPFStyleName();
            }
            case 39: {
                return pSDevSlnTemplBase.getPSSFId();
            }
            case 40: {
                return pSDevSlnTemplBase.getPSSFName();
            }
            case 41: {
                return pSDevSlnTemplBase.getPSSFStyleId();
            }
            case 42: {
                return pSDevSlnTemplBase.getPSSFStyleName();
            }
            case 43: {
                return pSDevSlnTemplBase.getPubMode();
            }
            case 44: {
                return pSDevSlnTemplBase.getRefCode();
            }
            case 45: {
                return pSDevSlnTemplBase.getStyleCode();
            }
            case 46: {
                return pSDevSlnTemplBase.getStyleEngine();
            }
            case 47: {
                return pSDevSlnTemplBase.getTemplMDUrl();
            }
            case 48: {
                return pSDevSlnTemplBase.getTemplParams();
            }
            case 49: {
                return pSDevSlnTemplBase.getTemplPSPFStyleId();
            }
            case 50: {
                return pSDevSlnTemplBase.getTemplPSPFStyleName();
            }
            case 51: {
                return pSDevSlnTemplBase.getTemplPSSFStyleId();
            }
            case 52: {
                return pSDevSlnTemplBase.getTemplPSSFStyleName();
            }
            case 53: {
                return pSDevSlnTemplBase.getTemplTag();
            }
            case 54: {
                return pSDevSlnTemplBase.getTemplTag2();
            }
            case 55: {
                return pSDevSlnTemplBase.getTemplType();
            }
            case 56: {
                return pSDevSlnTemplBase.getUpdateDate();
            }
            case 57: {
                return pSDevSlnTemplBase.getUpdateMan();
            }
            case 58: {
                return pSDevSlnTemplBase.getUserCat();
            }
            case 59: {
                return pSDevSlnTemplBase.getUserTag();
            }
            case 60: {
                return pSDevSlnTemplBase.getUserTag2();
            }
            case 61: {
                return pSDevSlnTemplBase.getUserTag3();
            }
            case 62: {
                return pSDevSlnTemplBase.getUserTag4();
            }
            case 63: {
                return pSDevSlnTemplBase.getV2GitPath();
            }
            case 64: {
                return pSDevSlnTemplBase.getVCType();
            }
            case 65: {
                return pSDevSlnTemplBase.getVerStr();
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
        PSDevSlnTemplBase.set(this, n, object);
    }

    private static void set(PSDevSlnTemplBase pSDevSlnTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnTemplBase.setActionOwner(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnTemplBase.setCurAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnTemplBase.setDevTemplState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnTemplBase.setEnableRef(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnTemplBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnTemplBase.setGitBranch(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnTemplBase.setGitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnTemplBase.setLastActiveTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnTemplBase.setLastPubDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnTemplBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnTemplBase.setMainPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnTemplBase.setMainPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnTemplBase.setPkgParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnTemplBase.setPkgParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnTemplBase.setPkgParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnTemplBase.setPkgParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnTemplBase.setPPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnTemplBase.setPPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnTemplBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnTemplBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnTemplBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnTemplBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnTemplBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnTemplBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnTemplBase.setPSDevSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnTemplBase.setPSDevSlnSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnTemplBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnTemplBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnTemplBase.setPSDevSlnSysSrvId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnTemplBase.setPSDevSlnSysSrvName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnTemplBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnTemplBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnTemplBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnTemplBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnTemplBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnTemplBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnTemplBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnTemplBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnTemplBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnTemplBase.setRefCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevSlnTemplBase.setStyleCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDevSlnTemplBase.setStyleEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDevSlnTemplBase.setTemplMDUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevSlnTemplBase.setTemplParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDevSlnTemplBase.setTemplPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDevSlnTemplBase.setTemplPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDevSlnTemplBase.setTemplPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDevSlnTemplBase.setTemplPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDevSlnTemplBase.setTemplTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDevSlnTemplBase.setTemplTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDevSlnTemplBase.setTemplType(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDevSlnTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 57: {
                pSDevSlnTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDevSlnTemplBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDevSlnTemplBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDevSlnTemplBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDevSlnTemplBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDevSlnTemplBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDevSlnTemplBase.setV2GitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDevSlnTemplBase.setVCType(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDevSlnTemplBase.setVerStr(DataObject.getStringValue((Object)object));
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
        return PSDevSlnTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnTemplBase pSDevSlnTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnTemplBase.getActionOwner() == null;
            }
            case 1: {
                return pSDevSlnTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevSlnTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevSlnTemplBase.getCurAction() == null;
            }
            case 4: {
                return pSDevSlnTemplBase.getDevTemplState() == null;
            }
            case 5: {
                return pSDevSlnTemplBase.getEnableRef() == null;
            }
            case 6: {
                return pSDevSlnTemplBase.getExpriedTime() == null;
            }
            case 7: {
                return pSDevSlnTemplBase.getGitBranch() == null;
            }
            case 8: {
                return pSDevSlnTemplBase.getGitPath() == null;
            }
            case 9: {
                return pSDevSlnTemplBase.getLastActiveTime() == null;
            }
            case 10: {
                return pSDevSlnTemplBase.getLastPubDate() == null;
            }
            case 11: {
                return pSDevSlnTemplBase.getLogicName() == null;
            }
            case 12: {
                return pSDevSlnTemplBase.getMainPSDevSlnTemplId() == null;
            }
            case 13: {
                return pSDevSlnTemplBase.getMainPSDevSlnTemplName() == null;
            }
            case 14: {
                return pSDevSlnTemplBase.getMemo() == null;
            }
            case 15: {
                return pSDevSlnTemplBase.getPkgParam() == null;
            }
            case 16: {
                return pSDevSlnTemplBase.getPkgParam2() == null;
            }
            case 17: {
                return pSDevSlnTemplBase.getPkgParam3() == null;
            }
            case 18: {
                return pSDevSlnTemplBase.getPkgParam4() == null;
            }
            case 19: {
                return pSDevSlnTemplBase.getPPSDevSlnTemplId() == null;
            }
            case 20: {
                return pSDevSlnTemplBase.getPPSDevSlnTemplName() == null;
            }
            case 21: {
                return pSDevSlnTemplBase.getPSDevCenterId() == null;
            }
            case 22: {
                return pSDevSlnTemplBase.getPSDevCenterName() == null;
            }
            case 23: {
                return pSDevSlnTemplBase.getPSDevCenterSVNId() == null;
            }
            case 24: {
                return pSDevSlnTemplBase.getPSDevCenterSVNName() == null;
            }
            case 25: {
                return pSDevSlnTemplBase.getPSDevSlnId() == null;
            }
            case 26: {
                return pSDevSlnTemplBase.getPSDevSlnName() == null;
            }
            case 27: {
                return pSDevSlnTemplBase.getPSDevSlnSysAppId() == null;
            }
            case 28: {
                return pSDevSlnTemplBase.getPSDevSlnSysAppName() == null;
            }
            case 29: {
                return pSDevSlnTemplBase.getPSDevSlnSysId() == null;
            }
            case 30: {
                return pSDevSlnTemplBase.getPSDevSlnSysName() == null;
            }
            case 31: {
                return pSDevSlnTemplBase.getPSDevSlnSysSrvId() == null;
            }
            case 32: {
                return pSDevSlnTemplBase.getPSDevSlnSysSrvName() == null;
            }
            case 33: {
                return pSDevSlnTemplBase.getPSDevSlnTemplId() == null;
            }
            case 34: {
                return pSDevSlnTemplBase.getPSDevSlnTemplName() == null;
            }
            case 35: {
                return pSDevSlnTemplBase.getPSPFId() == null;
            }
            case 36: {
                return pSDevSlnTemplBase.getPSPFName() == null;
            }
            case 37: {
                return pSDevSlnTemplBase.getPSPFStyleId() == null;
            }
            case 38: {
                return pSDevSlnTemplBase.getPSPFStyleName() == null;
            }
            case 39: {
                return pSDevSlnTemplBase.getPSSFId() == null;
            }
            case 40: {
                return pSDevSlnTemplBase.getPSSFName() == null;
            }
            case 41: {
                return pSDevSlnTemplBase.getPSSFStyleId() == null;
            }
            case 42: {
                return pSDevSlnTemplBase.getPSSFStyleName() == null;
            }
            case 43: {
                return pSDevSlnTemplBase.getPubMode() == null;
            }
            case 44: {
                return pSDevSlnTemplBase.getRefCode() == null;
            }
            case 45: {
                return pSDevSlnTemplBase.getStyleCode() == null;
            }
            case 46: {
                return pSDevSlnTemplBase.getStyleEngine() == null;
            }
            case 47: {
                return pSDevSlnTemplBase.getTemplMDUrl() == null;
            }
            case 48: {
                return pSDevSlnTemplBase.getTemplParams() == null;
            }
            case 49: {
                return pSDevSlnTemplBase.getTemplPSPFStyleId() == null;
            }
            case 50: {
                return pSDevSlnTemplBase.getTemplPSPFStyleName() == null;
            }
            case 51: {
                return pSDevSlnTemplBase.getTemplPSSFStyleId() == null;
            }
            case 52: {
                return pSDevSlnTemplBase.getTemplPSSFStyleName() == null;
            }
            case 53: {
                return pSDevSlnTemplBase.getTemplTag() == null;
            }
            case 54: {
                return pSDevSlnTemplBase.getTemplTag2() == null;
            }
            case 55: {
                return pSDevSlnTemplBase.getTemplType() == null;
            }
            case 56: {
                return pSDevSlnTemplBase.getUpdateDate() == null;
            }
            case 57: {
                return pSDevSlnTemplBase.getUpdateMan() == null;
            }
            case 58: {
                return pSDevSlnTemplBase.getUserCat() == null;
            }
            case 59: {
                return pSDevSlnTemplBase.getUserTag() == null;
            }
            case 60: {
                return pSDevSlnTemplBase.getUserTag2() == null;
            }
            case 61: {
                return pSDevSlnTemplBase.getUserTag3() == null;
            }
            case 62: {
                return pSDevSlnTemplBase.getUserTag4() == null;
            }
            case 63: {
                return pSDevSlnTemplBase.getV2GitPath() == null;
            }
            case 64: {
                return pSDevSlnTemplBase.getVCType() == null;
            }
            case 65: {
                return pSDevSlnTemplBase.getVerStr() == null;
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
        return PSDevSlnTemplBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnTemplBase pSDevSlnTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnTemplBase.isActionOwnerDirty();
            }
            case 1: {
                return pSDevSlnTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevSlnTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSDevSlnTemplBase.isCurActionDirty();
            }
            case 4: {
                return pSDevSlnTemplBase.isDevTemplStateDirty();
            }
            case 5: {
                return pSDevSlnTemplBase.isEnableRefDirty();
            }
            case 6: {
                return pSDevSlnTemplBase.isExpriedTimeDirty();
            }
            case 7: {
                return pSDevSlnTemplBase.isGitBranchDirty();
            }
            case 8: {
                return pSDevSlnTemplBase.isGitPathDirty();
            }
            case 9: {
                return pSDevSlnTemplBase.isLastActiveTimeDirty();
            }
            case 10: {
                return pSDevSlnTemplBase.isLastPubDateDirty();
            }
            case 11: {
                return pSDevSlnTemplBase.isLogicNameDirty();
            }
            case 12: {
                return pSDevSlnTemplBase.isMainPSDevSlnTemplIdDirty();
            }
            case 13: {
                return pSDevSlnTemplBase.isMainPSDevSlnTemplNameDirty();
            }
            case 14: {
                return pSDevSlnTemplBase.isMemoDirty();
            }
            case 15: {
                return pSDevSlnTemplBase.isPkgParamDirty();
            }
            case 16: {
                return pSDevSlnTemplBase.isPkgParam2Dirty();
            }
            case 17: {
                return pSDevSlnTemplBase.isPkgParam3Dirty();
            }
            case 18: {
                return pSDevSlnTemplBase.isPkgParam4Dirty();
            }
            case 19: {
                return pSDevSlnTemplBase.isPPSDevSlnTemplIdDirty();
            }
            case 20: {
                return pSDevSlnTemplBase.isPPSDevSlnTemplNameDirty();
            }
            case 21: {
                return pSDevSlnTemplBase.isPSDevCenterIdDirty();
            }
            case 22: {
                return pSDevSlnTemplBase.isPSDevCenterNameDirty();
            }
            case 23: {
                return pSDevSlnTemplBase.isPSDevCenterSVNIdDirty();
            }
            case 24: {
                return pSDevSlnTemplBase.isPSDevCenterSVNNameDirty();
            }
            case 25: {
                return pSDevSlnTemplBase.isPSDevSlnIdDirty();
            }
            case 26: {
                return pSDevSlnTemplBase.isPSDevSlnNameDirty();
            }
            case 27: {
                return pSDevSlnTemplBase.isPSDevSlnSysAppIdDirty();
            }
            case 28: {
                return pSDevSlnTemplBase.isPSDevSlnSysAppNameDirty();
            }
            case 29: {
                return pSDevSlnTemplBase.isPSDevSlnSysIdDirty();
            }
            case 30: {
                return pSDevSlnTemplBase.isPSDevSlnSysNameDirty();
            }
            case 31: {
                return pSDevSlnTemplBase.isPSDevSlnSysSrvIdDirty();
            }
            case 32: {
                return pSDevSlnTemplBase.isPSDevSlnSysSrvNameDirty();
            }
            case 33: {
                return pSDevSlnTemplBase.isPSDevSlnTemplIdDirty();
            }
            case 34: {
                return pSDevSlnTemplBase.isPSDevSlnTemplNameDirty();
            }
            case 35: {
                return pSDevSlnTemplBase.isPSPFIdDirty();
            }
            case 36: {
                return pSDevSlnTemplBase.isPSPFNameDirty();
            }
            case 37: {
                return pSDevSlnTemplBase.isPSPFStyleIdDirty();
            }
            case 38: {
                return pSDevSlnTemplBase.isPSPFStyleNameDirty();
            }
            case 39: {
                return pSDevSlnTemplBase.isPSSFIdDirty();
            }
            case 40: {
                return pSDevSlnTemplBase.isPSSFNameDirty();
            }
            case 41: {
                return pSDevSlnTemplBase.isPSSFStyleIdDirty();
            }
            case 42: {
                return pSDevSlnTemplBase.isPSSFStyleNameDirty();
            }
            case 43: {
                return pSDevSlnTemplBase.isPubModeDirty();
            }
            case 44: {
                return pSDevSlnTemplBase.isRefCodeDirty();
            }
            case 45: {
                return pSDevSlnTemplBase.isStyleCodeDirty();
            }
            case 46: {
                return pSDevSlnTemplBase.isStyleEngineDirty();
            }
            case 47: {
                return pSDevSlnTemplBase.isTemplMDUrlDirty();
            }
            case 48: {
                return pSDevSlnTemplBase.isTemplParamsDirty();
            }
            case 49: {
                return pSDevSlnTemplBase.isTemplPSPFStyleIdDirty();
            }
            case 50: {
                return pSDevSlnTemplBase.isTemplPSPFStyleNameDirty();
            }
            case 51: {
                return pSDevSlnTemplBase.isTemplPSSFStyleIdDirty();
            }
            case 52: {
                return pSDevSlnTemplBase.isTemplPSSFStyleNameDirty();
            }
            case 53: {
                return pSDevSlnTemplBase.isTemplTagDirty();
            }
            case 54: {
                return pSDevSlnTemplBase.isTemplTag2Dirty();
            }
            case 55: {
                return pSDevSlnTemplBase.isTemplTypeDirty();
            }
            case 56: {
                return pSDevSlnTemplBase.isUpdateDateDirty();
            }
            case 57: {
                return pSDevSlnTemplBase.isUpdateManDirty();
            }
            case 58: {
                return pSDevSlnTemplBase.isUserCatDirty();
            }
            case 59: {
                return pSDevSlnTemplBase.isUserTagDirty();
            }
            case 60: {
                return pSDevSlnTemplBase.isUserTag2Dirty();
            }
            case 61: {
                return pSDevSlnTemplBase.isUserTag3Dirty();
            }
            case 62: {
                return pSDevSlnTemplBase.isUserTag4Dirty();
            }
            case 63: {
                return pSDevSlnTemplBase.isV2GitPathDirty();
            }
            case 64: {
                return pSDevSlnTemplBase.isVCTypeDirty();
            }
            case 65: {
                return pSDevSlnTemplBase.isVerStrDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnTemplBase pSDevSlnTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnTemplBase.getActionOwner() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionowner", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getActionOwner()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getCurAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curaction", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getCurAction()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getDevTemplState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"devtemplstate", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getDevTemplState()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getEnableRef() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableref", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getEnableRef()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getGitBranch() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitbranch", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getGitBranch()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getGitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gitpath", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getGitPath()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getLastActiveTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastactivetime", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getLastActiveTime()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getLastPubDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastpubdate", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getLastPubDate()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getMainPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpsdevslntemplid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getMainPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getMainPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpsdevslntemplname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getMainPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPkgParam()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam2", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPkgParam2()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam3", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPkgParam3()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam4", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPkgParam4()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslntemplid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslntemplname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnSysAppId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysappname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnSysAppName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysSrvId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnSysSrvId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysSrvName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrvname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnSysSrvName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getPubMode()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getRefCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcode", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getRefCode()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getStyleCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stylecode", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getStyleCode()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getStyleEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleengine", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getStyleEngine()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplMDUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templmdurl", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplMDUrl()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templparams", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplParams()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpspfstyleid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplPSPFStyleId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpspfstylename", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplPSPFStyleName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpssfstyleid", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplPSSFStyleId()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpssfstylename", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplPSSFStyleName()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templtag", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplTag()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templtag2", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplTag2()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getTemplType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templtype", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getTemplType()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getV2GitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2gitpath", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getV2GitPath()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getVCType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vctype", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getVCType()), (boolean)false);
        }
        if (bl || pSDevSlnTemplBase.getVerStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verstr", (Object)PSDevSlnTemplBase.getJSONValue((Object)pSDevSlnTemplBase.getVerStr()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnTemplBase pSDevSlnTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnTemplBase.getActionOwner() != null) {
            object = pSDevSlnTemplBase.getActionOwner();
            xmlNode.setAttribute(FIELD_ACTIONOWNER, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getCreateDate() != null) {
            object = pSDevSlnTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getCreateMan() != null) {
            object = pSDevSlnTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getCurAction() != null) {
            object = pSDevSlnTemplBase.getCurAction();
            xmlNode.setAttribute(FIELD_CURACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getDevTemplState() != null) {
            object = pSDevSlnTemplBase.getDevTemplState();
            xmlNode.setAttribute(FIELD_DEVTEMPLSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getEnableRef() != null) {
            object = pSDevSlnTemplBase.getEnableRef();
            xmlNode.setAttribute(FIELD_ENABLEREF, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getExpriedTime() != null) {
            object = pSDevSlnTemplBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getGitBranch() != null) {
            object = pSDevSlnTemplBase.getGitBranch();
            xmlNode.setAttribute(FIELD_GITBRANCH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getGitPath() != null) {
            object = pSDevSlnTemplBase.getGitPath();
            xmlNode.setAttribute(FIELD_GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getLastActiveTime() != null) {
            object = pSDevSlnTemplBase.getLastActiveTime();
            xmlNode.setAttribute(FIELD_LASTACTIVETIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getLastPubDate() != null) {
            object = pSDevSlnTemplBase.getLastPubDate();
            xmlNode.setAttribute(FIELD_LASTPUBDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getLogicName() != null) {
            object = pSDevSlnTemplBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getMainPSDevSlnTemplId() != null) {
            object = pSDevSlnTemplBase.getMainPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_MAINPSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getMainPSDevSlnTemplName() != null) {
            object = pSDevSlnTemplBase.getMainPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_MAINPSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getMemo() != null) {
            object = pSDevSlnTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam() != null) {
            object = pSDevSlnTemplBase.getPkgParam();
            xmlNode.setAttribute(FIELD_PKGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam2() != null) {
            object = pSDevSlnTemplBase.getPkgParam2();
            xmlNode.setAttribute(FIELD_PKGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam3() != null) {
            object = pSDevSlnTemplBase.getPkgParam3();
            xmlNode.setAttribute(FIELD_PKGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPkgParam4() != null) {
            object = pSDevSlnTemplBase.getPkgParam4();
            xmlNode.setAttribute(FIELD_PKGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPPSDevSlnTemplId() != null) {
            object = pSDevSlnTemplBase.getPPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PPSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPPSDevSlnTemplName() != null) {
            object = pSDevSlnTemplBase.getPPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PPSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterId() != null) {
            object = pSDevSlnTemplBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterName() != null) {
            object = pSDevSlnTemplBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterSVNId() != null) {
            object = pSDevSlnTemplBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevCenterSVNName() != null) {
            object = pSDevSlnTemplBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnId() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnName() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysAppId() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysAppName() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnSysAppName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysSrvId() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnSysSrvId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnSysSrvName() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnSysSrvName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnTemplId() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSDevSlnTemplName() != null) {
            object = pSDevSlnTemplBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSPFId() != null) {
            object = pSDevSlnTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSPFName() != null) {
            object = pSDevSlnTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSPFStyleId() != null) {
            object = pSDevSlnTemplBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSPFStyleName() != null) {
            object = pSDevSlnTemplBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSSFId() != null) {
            object = pSDevSlnTemplBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSSFName() != null) {
            object = pSDevSlnTemplBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSSFStyleId() != null) {
            object = pSDevSlnTemplBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPSSFStyleName() != null) {
            object = pSDevSlnTemplBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getPubMode() != null) {
            object = pSDevSlnTemplBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getRefCode() != null) {
            object = pSDevSlnTemplBase.getRefCode();
            xmlNode.setAttribute(FIELD_REFCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getStyleCode() != null) {
            object = pSDevSlnTemplBase.getStyleCode();
            xmlNode.setAttribute(FIELD_STYLECODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getStyleEngine() != null) {
            object = pSDevSlnTemplBase.getStyleEngine();
            xmlNode.setAttribute(FIELD_STYLEENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplMDUrl() != null) {
            object = pSDevSlnTemplBase.getTemplMDUrl();
            xmlNode.setAttribute(FIELD_TEMPLMDURL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplParams() != null) {
            object = pSDevSlnTemplBase.getTemplParams();
            xmlNode.setAttribute(FIELD_TEMPLPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSPFStyleId() != null) {
            object = pSDevSlnTemplBase.getTemplPSPFStyleId();
            xmlNode.setAttribute(FIELD_TEMPLPSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSPFStyleName() != null) {
            object = pSDevSlnTemplBase.getTemplPSPFStyleName();
            xmlNode.setAttribute(FIELD_TEMPLPSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSSFStyleId() != null) {
            object = pSDevSlnTemplBase.getTemplPSSFStyleId();
            xmlNode.setAttribute(FIELD_TEMPLPSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplPSSFStyleName() != null) {
            object = pSDevSlnTemplBase.getTemplPSSFStyleName();
            xmlNode.setAttribute(FIELD_TEMPLPSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplTag() != null) {
            object = pSDevSlnTemplBase.getTemplTag();
            xmlNode.setAttribute(FIELD_TEMPLTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplTag2() != null) {
            object = pSDevSlnTemplBase.getTemplTag2();
            xmlNode.setAttribute(FIELD_TEMPLTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getTemplType() != null) {
            object = pSDevSlnTemplBase.getTemplType();
            xmlNode.setAttribute(FIELD_TEMPLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getUpdateDate() != null) {
            object = pSDevSlnTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnTemplBase.getUpdateMan() != null) {
            object = pSDevSlnTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getUserCat() != null) {
            object = pSDevSlnTemplBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getUserTag() != null) {
            object = pSDevSlnTemplBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getUserTag2() != null) {
            object = pSDevSlnTemplBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getUserTag3() != null) {
            object = pSDevSlnTemplBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getUserTag4() != null) {
            object = pSDevSlnTemplBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getV2GitPath() != null) {
            object = pSDevSlnTemplBase.getV2GitPath();
            xmlNode.setAttribute(FIELD_V2GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getVCType() != null) {
            object = pSDevSlnTemplBase.getVCType();
            xmlNode.setAttribute(FIELD_VCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnTemplBase.getVerStr() != null) {
            object = pSDevSlnTemplBase.getVerStr();
            xmlNode.setAttribute(FIELD_VERSTR, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnTemplBase pSDevSlnTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnTemplBase.isActionOwnerDirty() && (bl || pSDevSlnTemplBase.getActionOwner() != null)) {
            iDataObject.set(FIELD_ACTIONOWNER, (Object)pSDevSlnTemplBase.getActionOwner());
        }
        if (pSDevSlnTemplBase.isCreateDateDirty() && (bl || pSDevSlnTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnTemplBase.getCreateDate());
        }
        if (pSDevSlnTemplBase.isCreateManDirty() && (bl || pSDevSlnTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnTemplBase.getCreateMan());
        }
        if (pSDevSlnTemplBase.isCurActionDirty() && (bl || pSDevSlnTemplBase.getCurAction() != null)) {
            iDataObject.set(FIELD_CURACTION, (Object)pSDevSlnTemplBase.getCurAction());
        }
        if (pSDevSlnTemplBase.isDevTemplStateDirty() && (bl || pSDevSlnTemplBase.getDevTemplState() != null)) {
            iDataObject.set(FIELD_DEVTEMPLSTATE, (Object)pSDevSlnTemplBase.getDevTemplState());
        }
        if (pSDevSlnTemplBase.isEnableRefDirty() && (bl || pSDevSlnTemplBase.getEnableRef() != null)) {
            iDataObject.set(FIELD_ENABLEREF, (Object)pSDevSlnTemplBase.getEnableRef());
        }
        if (pSDevSlnTemplBase.isExpriedTimeDirty() && (bl || pSDevSlnTemplBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevSlnTemplBase.getExpriedTime());
        }
        if (pSDevSlnTemplBase.isGitBranchDirty() && (bl || pSDevSlnTemplBase.getGitBranch() != null)) {
            iDataObject.set(FIELD_GITBRANCH, (Object)pSDevSlnTemplBase.getGitBranch());
        }
        if (pSDevSlnTemplBase.isGitPathDirty() && (bl || pSDevSlnTemplBase.getGitPath() != null)) {
            iDataObject.set(FIELD_GITPATH, (Object)pSDevSlnTemplBase.getGitPath());
        }
        if (pSDevSlnTemplBase.isLastActiveTimeDirty() && (bl || pSDevSlnTemplBase.getLastActiveTime() != null)) {
            iDataObject.set(FIELD_LASTACTIVETIME, (Object)pSDevSlnTemplBase.getLastActiveTime());
        }
        if (pSDevSlnTemplBase.isLastPubDateDirty() && (bl || pSDevSlnTemplBase.getLastPubDate() != null)) {
            iDataObject.set(FIELD_LASTPUBDATE, (Object)pSDevSlnTemplBase.getLastPubDate());
        }
        if (pSDevSlnTemplBase.isLogicNameDirty() && (bl || pSDevSlnTemplBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDevSlnTemplBase.getLogicName());
        }
        if (pSDevSlnTemplBase.isMainPSDevSlnTemplIdDirty() && (bl || pSDevSlnTemplBase.getMainPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_MAINPSDEVSLNTEMPLID, (Object)pSDevSlnTemplBase.getMainPSDevSlnTemplId());
        }
        if (pSDevSlnTemplBase.isMainPSDevSlnTemplNameDirty() && (bl || pSDevSlnTemplBase.getMainPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_MAINPSDEVSLNTEMPLNAME, (Object)pSDevSlnTemplBase.getMainPSDevSlnTemplName());
        }
        if (pSDevSlnTemplBase.isMemoDirty() && (bl || pSDevSlnTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnTemplBase.getMemo());
        }
        if (pSDevSlnTemplBase.isPkgParamDirty() && (bl || pSDevSlnTemplBase.getPkgParam() != null)) {
            iDataObject.set(FIELD_PKGPARAM, (Object)pSDevSlnTemplBase.getPkgParam());
        }
        if (pSDevSlnTemplBase.isPkgParam2Dirty() && (bl || pSDevSlnTemplBase.getPkgParam2() != null)) {
            iDataObject.set(FIELD_PKGPARAM2, (Object)pSDevSlnTemplBase.getPkgParam2());
        }
        if (pSDevSlnTemplBase.isPkgParam3Dirty() && (bl || pSDevSlnTemplBase.getPkgParam3() != null)) {
            iDataObject.set(FIELD_PKGPARAM3, (Object)pSDevSlnTemplBase.getPkgParam3());
        }
        if (pSDevSlnTemplBase.isPkgParam4Dirty() && (bl || pSDevSlnTemplBase.getPkgParam4() != null)) {
            iDataObject.set(FIELD_PKGPARAM4, (Object)pSDevSlnTemplBase.getPkgParam4());
        }
        if (pSDevSlnTemplBase.isPPSDevSlnTemplIdDirty() && (bl || pSDevSlnTemplBase.getPPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNTEMPLID, (Object)pSDevSlnTemplBase.getPPSDevSlnTemplId());
        }
        if (pSDevSlnTemplBase.isPPSDevSlnTemplNameDirty() && (bl || pSDevSlnTemplBase.getPPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNTEMPLNAME, (Object)pSDevSlnTemplBase.getPPSDevSlnTemplName());
        }
        if (pSDevSlnTemplBase.isPSDevCenterIdDirty() && (bl || pSDevSlnTemplBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnTemplBase.getPSDevCenterId());
        }
        if (pSDevSlnTemplBase.isPSDevCenterNameDirty() && (bl || pSDevSlnTemplBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnTemplBase.getPSDevCenterName());
        }
        if (pSDevSlnTemplBase.isPSDevCenterSVNIdDirty() && (bl || pSDevSlnTemplBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevSlnTemplBase.getPSDevCenterSVNId());
        }
        if (pSDevSlnTemplBase.isPSDevCenterSVNNameDirty() && (bl || pSDevSlnTemplBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevSlnTemplBase.getPSDevCenterSVNName());
        }
        if (pSDevSlnTemplBase.isPSDevSlnIdDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnTemplBase.getPSDevSlnId());
        }
        if (pSDevSlnTemplBase.isPSDevSlnNameDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnTemplBase.getPSDevSlnName());
        }
        if (pSDevSlnTemplBase.isPSDevSlnSysAppIdDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPID, (Object)pSDevSlnTemplBase.getPSDevSlnSysAppId());
        }
        if (pSDevSlnTemplBase.isPSDevSlnSysAppNameDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPPNAME, (Object)pSDevSlnTemplBase.getPSDevSlnSysAppName());
        }
        if (pSDevSlnTemplBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnTemplBase.getPSDevSlnSysId());
        }
        if (pSDevSlnTemplBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnTemplBase.getPSDevSlnSysName());
        }
        if (pSDevSlnTemplBase.isPSDevSlnSysSrvIdDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnSysSrvId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVID, (Object)pSDevSlnTemplBase.getPSDevSlnSysSrvId());
        }
        if (pSDevSlnTemplBase.isPSDevSlnSysSrvNameDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnSysSrvName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRVNAME, (Object)pSDevSlnTemplBase.getPSDevSlnSysSrvName());
        }
        if (pSDevSlnTemplBase.isPSDevSlnTemplIdDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        }
        if (pSDevSlnTemplBase.isPSDevSlnTemplNameDirty() && (bl || pSDevSlnTemplBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSDevSlnTemplBase.getPSDevSlnTemplName());
        }
        if (pSDevSlnTemplBase.isPSPFIdDirty() && (bl || pSDevSlnTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDevSlnTemplBase.getPSPFId());
        }
        if (pSDevSlnTemplBase.isPSPFNameDirty() && (bl || pSDevSlnTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDevSlnTemplBase.getPSPFName());
        }
        if (pSDevSlnTemplBase.isPSPFStyleIdDirty() && (bl || pSDevSlnTemplBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSDevSlnTemplBase.getPSPFStyleId());
        }
        if (pSDevSlnTemplBase.isPSPFStyleNameDirty() && (bl || pSDevSlnTemplBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSDevSlnTemplBase.getPSPFStyleName());
        }
        if (pSDevSlnTemplBase.isPSSFIdDirty() && (bl || pSDevSlnTemplBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSDevSlnTemplBase.getPSSFId());
        }
        if (pSDevSlnTemplBase.isPSSFNameDirty() && (bl || pSDevSlnTemplBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSDevSlnTemplBase.getPSSFName());
        }
        if (pSDevSlnTemplBase.isPSSFStyleIdDirty() && (bl || pSDevSlnTemplBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSDevSlnTemplBase.getPSSFStyleId());
        }
        if (pSDevSlnTemplBase.isPSSFStyleNameDirty() && (bl || pSDevSlnTemplBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSDevSlnTemplBase.getPSSFStyleName());
        }
        if (pSDevSlnTemplBase.isPubModeDirty() && (bl || pSDevSlnTemplBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSDevSlnTemplBase.getPubMode());
        }
        if (pSDevSlnTemplBase.isRefCodeDirty() && (bl || pSDevSlnTemplBase.getRefCode() != null)) {
            iDataObject.set(FIELD_REFCODE, (Object)pSDevSlnTemplBase.getRefCode());
        }
        if (pSDevSlnTemplBase.isStyleCodeDirty() && (bl || pSDevSlnTemplBase.getStyleCode() != null)) {
            iDataObject.set(FIELD_STYLECODE, (Object)pSDevSlnTemplBase.getStyleCode());
        }
        if (pSDevSlnTemplBase.isStyleEngineDirty() && (bl || pSDevSlnTemplBase.getStyleEngine() != null)) {
            iDataObject.set(FIELD_STYLEENGINE, (Object)pSDevSlnTemplBase.getStyleEngine());
        }
        if (pSDevSlnTemplBase.isTemplMDUrlDirty() && (bl || pSDevSlnTemplBase.getTemplMDUrl() != null)) {
            iDataObject.set(FIELD_TEMPLMDURL, (Object)pSDevSlnTemplBase.getTemplMDUrl());
        }
        if (pSDevSlnTemplBase.isTemplParamsDirty() && (bl || pSDevSlnTemplBase.getTemplParams() != null)) {
            iDataObject.set(FIELD_TEMPLPARAMS, (Object)pSDevSlnTemplBase.getTemplParams());
        }
        if (pSDevSlnTemplBase.isTemplPSPFStyleIdDirty() && (bl || pSDevSlnTemplBase.getTemplPSPFStyleId() != null)) {
            iDataObject.set(FIELD_TEMPLPSPFSTYLEID, (Object)pSDevSlnTemplBase.getTemplPSPFStyleId());
        }
        if (pSDevSlnTemplBase.isTemplPSPFStyleNameDirty() && (bl || pSDevSlnTemplBase.getTemplPSPFStyleName() != null)) {
            iDataObject.set(FIELD_TEMPLPSPFSTYLENAME, (Object)pSDevSlnTemplBase.getTemplPSPFStyleName());
        }
        if (pSDevSlnTemplBase.isTemplPSSFStyleIdDirty() && (bl || pSDevSlnTemplBase.getTemplPSSFStyleId() != null)) {
            iDataObject.set(FIELD_TEMPLPSSFSTYLEID, (Object)pSDevSlnTemplBase.getTemplPSSFStyleId());
        }
        if (pSDevSlnTemplBase.isTemplPSSFStyleNameDirty() && (bl || pSDevSlnTemplBase.getTemplPSSFStyleName() != null)) {
            iDataObject.set(FIELD_TEMPLPSSFSTYLENAME, (Object)pSDevSlnTemplBase.getTemplPSSFStyleName());
        }
        if (pSDevSlnTemplBase.isTemplTagDirty() && (bl || pSDevSlnTemplBase.getTemplTag() != null)) {
            iDataObject.set(FIELD_TEMPLTAG, (Object)pSDevSlnTemplBase.getTemplTag());
        }
        if (pSDevSlnTemplBase.isTemplTag2Dirty() && (bl || pSDevSlnTemplBase.getTemplTag2() != null)) {
            iDataObject.set(FIELD_TEMPLTAG2, (Object)pSDevSlnTemplBase.getTemplTag2());
        }
        if (pSDevSlnTemplBase.isTemplTypeDirty() && (bl || pSDevSlnTemplBase.getTemplType() != null)) {
            iDataObject.set(FIELD_TEMPLTYPE, (Object)pSDevSlnTemplBase.getTemplType());
        }
        if (pSDevSlnTemplBase.isUpdateDateDirty() && (bl || pSDevSlnTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnTemplBase.getUpdateDate());
        }
        if (pSDevSlnTemplBase.isUpdateManDirty() && (bl || pSDevSlnTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnTemplBase.getUpdateMan());
        }
        if (pSDevSlnTemplBase.isUserCatDirty() && (bl || pSDevSlnTemplBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnTemplBase.getUserCat());
        }
        if (pSDevSlnTemplBase.isUserTagDirty() && (bl || pSDevSlnTemplBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnTemplBase.getUserTag());
        }
        if (pSDevSlnTemplBase.isUserTag2Dirty() && (bl || pSDevSlnTemplBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnTemplBase.getUserTag2());
        }
        if (pSDevSlnTemplBase.isUserTag3Dirty() && (bl || pSDevSlnTemplBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnTemplBase.getUserTag3());
        }
        if (pSDevSlnTemplBase.isUserTag4Dirty() && (bl || pSDevSlnTemplBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnTemplBase.getUserTag4());
        }
        if (pSDevSlnTemplBase.isV2GitPathDirty() && (bl || pSDevSlnTemplBase.getV2GitPath() != null)) {
            iDataObject.set(FIELD_V2GITPATH, (Object)pSDevSlnTemplBase.getV2GitPath());
        }
        if (pSDevSlnTemplBase.isVCTypeDirty() && (bl || pSDevSlnTemplBase.getVCType() != null)) {
            iDataObject.set(FIELD_VCTYPE, (Object)pSDevSlnTemplBase.getVCType());
        }
        if (pSDevSlnTemplBase.isVerStrDirty() && (bl || pSDevSlnTemplBase.getVerStr() != null)) {
            iDataObject.set(FIELD_VERSTR, (Object)pSDevSlnTemplBase.getVerStr());
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
        return PSDevSlnTemplBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnTemplBase pSDevSlnTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnTemplBase.resetActionOwner();
                return true;
            }
            case 1: {
                pSDevSlnTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevSlnTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevSlnTemplBase.resetCurAction();
                return true;
            }
            case 4: {
                pSDevSlnTemplBase.resetDevTemplState();
                return true;
            }
            case 5: {
                pSDevSlnTemplBase.resetEnableRef();
                return true;
            }
            case 6: {
                pSDevSlnTemplBase.resetExpriedTime();
                return true;
            }
            case 7: {
                pSDevSlnTemplBase.resetGitBranch();
                return true;
            }
            case 8: {
                pSDevSlnTemplBase.resetGitPath();
                return true;
            }
            case 9: {
                pSDevSlnTemplBase.resetLastActiveTime();
                return true;
            }
            case 10: {
                pSDevSlnTemplBase.resetLastPubDate();
                return true;
            }
            case 11: {
                pSDevSlnTemplBase.resetLogicName();
                return true;
            }
            case 12: {
                pSDevSlnTemplBase.resetMainPSDevSlnTemplId();
                return true;
            }
            case 13: {
                pSDevSlnTemplBase.resetMainPSDevSlnTemplName();
                return true;
            }
            case 14: {
                pSDevSlnTemplBase.resetMemo();
                return true;
            }
            case 15: {
                pSDevSlnTemplBase.resetPkgParam();
                return true;
            }
            case 16: {
                pSDevSlnTemplBase.resetPkgParam2();
                return true;
            }
            case 17: {
                pSDevSlnTemplBase.resetPkgParam3();
                return true;
            }
            case 18: {
                pSDevSlnTemplBase.resetPkgParam4();
                return true;
            }
            case 19: {
                pSDevSlnTemplBase.resetPPSDevSlnTemplId();
                return true;
            }
            case 20: {
                pSDevSlnTemplBase.resetPPSDevSlnTemplName();
                return true;
            }
            case 21: {
                pSDevSlnTemplBase.resetPSDevCenterId();
                return true;
            }
            case 22: {
                pSDevSlnTemplBase.resetPSDevCenterName();
                return true;
            }
            case 23: {
                pSDevSlnTemplBase.resetPSDevCenterSVNId();
                return true;
            }
            case 24: {
                pSDevSlnTemplBase.resetPSDevCenterSVNName();
                return true;
            }
            case 25: {
                pSDevSlnTemplBase.resetPSDevSlnId();
                return true;
            }
            case 26: {
                pSDevSlnTemplBase.resetPSDevSlnName();
                return true;
            }
            case 27: {
                pSDevSlnTemplBase.resetPSDevSlnSysAppId();
                return true;
            }
            case 28: {
                pSDevSlnTemplBase.resetPSDevSlnSysAppName();
                return true;
            }
            case 29: {
                pSDevSlnTemplBase.resetPSDevSlnSysId();
                return true;
            }
            case 30: {
                pSDevSlnTemplBase.resetPSDevSlnSysName();
                return true;
            }
            case 31: {
                pSDevSlnTemplBase.resetPSDevSlnSysSrvId();
                return true;
            }
            case 32: {
                pSDevSlnTemplBase.resetPSDevSlnSysSrvName();
                return true;
            }
            case 33: {
                pSDevSlnTemplBase.resetPSDevSlnTemplId();
                return true;
            }
            case 34: {
                pSDevSlnTemplBase.resetPSDevSlnTemplName();
                return true;
            }
            case 35: {
                pSDevSlnTemplBase.resetPSPFId();
                return true;
            }
            case 36: {
                pSDevSlnTemplBase.resetPSPFName();
                return true;
            }
            case 37: {
                pSDevSlnTemplBase.resetPSPFStyleId();
                return true;
            }
            case 38: {
                pSDevSlnTemplBase.resetPSPFStyleName();
                return true;
            }
            case 39: {
                pSDevSlnTemplBase.resetPSSFId();
                return true;
            }
            case 40: {
                pSDevSlnTemplBase.resetPSSFName();
                return true;
            }
            case 41: {
                pSDevSlnTemplBase.resetPSSFStyleId();
                return true;
            }
            case 42: {
                pSDevSlnTemplBase.resetPSSFStyleName();
                return true;
            }
            case 43: {
                pSDevSlnTemplBase.resetPubMode();
                return true;
            }
            case 44: {
                pSDevSlnTemplBase.resetRefCode();
                return true;
            }
            case 45: {
                pSDevSlnTemplBase.resetStyleCode();
                return true;
            }
            case 46: {
                pSDevSlnTemplBase.resetStyleEngine();
                return true;
            }
            case 47: {
                pSDevSlnTemplBase.resetTemplMDUrl();
                return true;
            }
            case 48: {
                pSDevSlnTemplBase.resetTemplParams();
                return true;
            }
            case 49: {
                pSDevSlnTemplBase.resetTemplPSPFStyleId();
                return true;
            }
            case 50: {
                pSDevSlnTemplBase.resetTemplPSPFStyleName();
                return true;
            }
            case 51: {
                pSDevSlnTemplBase.resetTemplPSSFStyleId();
                return true;
            }
            case 52: {
                pSDevSlnTemplBase.resetTemplPSSFStyleName();
                return true;
            }
            case 53: {
                pSDevSlnTemplBase.resetTemplTag();
                return true;
            }
            case 54: {
                pSDevSlnTemplBase.resetTemplTag2();
                return true;
            }
            case 55: {
                pSDevSlnTemplBase.resetTemplType();
                return true;
            }
            case 56: {
                pSDevSlnTemplBase.resetUpdateDate();
                return true;
            }
            case 57: {
                pSDevSlnTemplBase.resetUpdateMan();
                return true;
            }
            case 58: {
                pSDevSlnTemplBase.resetUserCat();
                return true;
            }
            case 59: {
                pSDevSlnTemplBase.resetUserTag();
                return true;
            }
            case 60: {
                pSDevSlnTemplBase.resetUserTag2();
                return true;
            }
            case 61: {
                pSDevSlnTemplBase.resetUserTag3();
                return true;
            }
            case 62: {
                pSDevSlnTemplBase.resetUserTag4();
                return true;
            }
            case 63: {
                pSDevSlnTemplBase.resetV2GitPath();
                return true;
            }
            case 64: {
                pSDevSlnTemplBase.resetVCType();
                return true;
            }
            case 65: {
                pSDevSlnTemplBase.resetVerStr();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDevSlnSysSrv getPSDevSlnSysSrv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrv();
        }
        if (this.getPSDevSlnSysSrvId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysSrvLock;
        synchronized (n) {
            if (this.psdevslnsyssrv != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysSrvId(), (Object)this.psdevslnsyssrv.getPSDevSlnSysSrvId()) != 0L) {
                this.psdevslnsyssrv = null;
            }
            if (this.psdevslnsyssrv == null) {
                PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
                pSDevSlnSysSrv.setPSDevSlnSysSrvId(this.getPSDevSlnSysSrvId());
                PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysSrvService.autoGet(pSDevSlnSysSrv);
                this.psdevslnsyssrv = pSDevSlnSysSrv;
            }
            return this.psdevslnsyssrv;
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
    public PSDevSlnTempl getMainPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSDevSlnTempl();
        }
        if (this.getMainPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objMainPSDevSlnTemplLock;
        synchronized (n) {
            if (this.mainpsdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getMainPSDevSlnTemplId(), (Object)this.mainpsdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.mainpsdevslntempl = null;
            }
            if (this.mainpsdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getMainPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet(pSDevSlnTempl);
                this.mainpsdevslntempl = pSDevSlnTempl;
            }
            return this.mainpsdevslntempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnTempl getPPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnTempl();
        }
        if (this.getPPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objPPSDevSlnTemplLock;
        synchronized (n) {
            if (this.ppsdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevSlnTemplId(), (Object)this.ppsdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.ppsdevslntempl = null;
            }
            if (this.ppsdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getPPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet(pSDevSlnTempl);
                this.ppsdevslntempl = pSDevSlnTempl;
            }
            return this.ppsdevslntempl;
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
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getTemplPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSPFStyle();
        }
        if (this.getTemplPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objTemplPSPFStyleLock;
        synchronized (n) {
            if (this.templpspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getTemplPSPFStyleId(), (Object)this.templpspfstyle.getPSPFStyleId()) != 0L) {
                this.templpspfstyle = null;
            }
            if (this.templpspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getTemplPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.templpspfstyle = pSPFStyle;
            }
            return this.templpspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getTemplPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplPSSFStyle();
        }
        if (this.getTemplPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objTemplPSSFStyleLock;
        synchronized (n) {
            if (this.templpssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getTemplPSSFStyleId(), (Object)this.templpssfstyle.getPSSFStyleId()) != 0L) {
                this.templpssfstyle = null;
            }
            if (this.templpssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getTemplPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.templpssfstyle = pSSFStyle;
            }
            return this.templpssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnTemplRef> getPSDevSlnTemplRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplRefs();
        }
        if (this.getPSDevSlnTemplId() == null) {
            return null;
        }
        PSDevSlnTemplRefService pSDevSlnTemplRefService = (PSDevSlnTemplRefService)ServiceGlobal.getService(PSDevSlnTemplRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnTemplRefsLock;
        synchronized (n) {
            if (this.psdevslntemplrefs == null) {
                this.psdevslntemplrefs = pSDevSlnTemplRefService.selectByPSDevSlnTempl(this);
            }
            return this.psdevslntemplrefs;
        }
    }

    private PSDevSlnTemplBase getProxyEntity() {
        return this.proxyPSDevSlnTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnTemplBase) {
            this.proxyPSDevSlnTemplBase = (PSDevSlnTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONOWNER, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CURACTION, 3);
        fieldIndexMap.put(FIELD_DEVTEMPLSTATE, 4);
        fieldIndexMap.put(FIELD_ENABLEREF, 5);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 6);
        fieldIndexMap.put(FIELD_GITBRANCH, 7);
        fieldIndexMap.put(FIELD_GITPATH, 8);
        fieldIndexMap.put(FIELD_LASTACTIVETIME, 9);
        fieldIndexMap.put(FIELD_LASTPUBDATE, 10);
        fieldIndexMap.put(FIELD_LOGICNAME, 11);
        fieldIndexMap.put(FIELD_MAINPSDEVSLNTEMPLID, 12);
        fieldIndexMap.put(FIELD_MAINPSDEVSLNTEMPLNAME, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_PKGPARAM, 15);
        fieldIndexMap.put(FIELD_PKGPARAM2, 16);
        fieldIndexMap.put(FIELD_PKGPARAM3, 17);
        fieldIndexMap.put(FIELD_PKGPARAM4, 18);
        fieldIndexMap.put(FIELD_PPSDEVSLNTEMPLID, 19);
        fieldIndexMap.put(FIELD_PPSDEVSLNTEMPLNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 23);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 25);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 26);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPID, 27);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPPNAME, 28);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 29);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 30);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVID, 31);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRVNAME, 32);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 33);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 34);
        fieldIndexMap.put(FIELD_PSPFID, 35);
        fieldIndexMap.put(FIELD_PSPFNAME, 36);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 37);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 38);
        fieldIndexMap.put(FIELD_PSSFID, 39);
        fieldIndexMap.put(FIELD_PSSFNAME, 40);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 41);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 42);
        fieldIndexMap.put(FIELD_PUBMODE, 43);
        fieldIndexMap.put(FIELD_REFCODE, 44);
        fieldIndexMap.put(FIELD_STYLECODE, 45);
        fieldIndexMap.put(FIELD_STYLEENGINE, 46);
        fieldIndexMap.put(FIELD_TEMPLMDURL, 47);
        fieldIndexMap.put(FIELD_TEMPLPARAMS, 48);
        fieldIndexMap.put(FIELD_TEMPLPSPFSTYLEID, 49);
        fieldIndexMap.put(FIELD_TEMPLPSPFSTYLENAME, 50);
        fieldIndexMap.put(FIELD_TEMPLPSSFSTYLEID, 51);
        fieldIndexMap.put(FIELD_TEMPLPSSFSTYLENAME, 52);
        fieldIndexMap.put(FIELD_TEMPLTAG, 53);
        fieldIndexMap.put(FIELD_TEMPLTAG2, 54);
        fieldIndexMap.put(FIELD_TEMPLTYPE, 55);
        fieldIndexMap.put(FIELD_UPDATEDATE, 56);
        fieldIndexMap.put(FIELD_UPDATEMAN, 57);
        fieldIndexMap.put(FIELD_USERCAT, 58);
        fieldIndexMap.put(FIELD_USERTAG, 59);
        fieldIndexMap.put(FIELD_USERTAG2, 60);
        fieldIndexMap.put(FIELD_USERTAG3, 61);
        fieldIndexMap.put(FIELD_USERTAG4, 62);
        fieldIndexMap.put(FIELD_V2GITPATH, 63);
        fieldIndexMap.put(FIELD_VCTYPE, 64);
        fieldIndexMap.put(FIELD_VERSTR, 65);
    }
}

