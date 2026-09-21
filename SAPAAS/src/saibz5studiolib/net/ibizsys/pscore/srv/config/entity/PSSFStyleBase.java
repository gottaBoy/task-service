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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStylePrj;
import net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStylePrjService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStyleBase.class);
    public static final String FIELD_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENABLEDEPLOYCENTER = "ENABLEDEPLOYCENTER";
    public static final String FIELD_ENABLEWSSERVER = "ENABLEWSSERVER";
    public static final String FIELD_LASTESTFLAG = "LASTESTFLAG";
    public static final String FIELD_MAINPSSFSTYLEID = "MAINPSSFSTYLEID";
    public static final String FIELD_MAINPSSFSTYLENAME = "MAINPSSFSTYLENAME";
    public static final String FIELD_MAINSTYLEFLAG = "MAINSTYLEFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PKGINHERITMODE = "PKGINHERITMODE";
    public static final String FIELD_PPSSFSTYLEID = "PPSSFSTYLEID";
    public static final String FIELD_PPSSFSTYLENAME = "PPSSFSTYLENAME";
    public static final String FIELD_PRJLIST = "PRJLIST";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_REFRESHVER = "REFRESHVER";
    public static final String FIELD_STYLEENGINE = "STYLEENGINE";
    public static final String FIELD_STYLERESURL = "STYLERESURL";
    public static final String FIELD_TEMPLINFO = "TEMPLINFO";
    public static final String FIELD_TEMPLROOTURL = "TEMPLROOTURL";
    public static final String FIELD_TEMPLSTATE = "TEMPLSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_V2FOLDER = "V2FOLDER";
    public static final String FIELD_V2FOLDER2 = "V2FOLDER2";
    public static final String FIELD_V2GITPATH = "V2GITPATH";
    public static final String FIELD_VERSION = "VERSION";
    public static final String FIELD_VERSTR = "VERSTR";
    public static final String FIELD_WORKSHOPNAME = "WORKSHOPNAME";
    private static final int INDEX_CLSPKGPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_ENABLEDEPLOYCENTER = 4;
    private static final int INDEX_ENABLEWSSERVER = 5;
    private static final int INDEX_LASTESTFLAG = 6;
    private static final int INDEX_MAINPSSFSTYLEID = 7;
    private static final int INDEX_MAINPSSFSTYLENAME = 8;
    private static final int INDEX_MAINSTYLEFLAG = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PKGINHERITMODE = 11;
    private static final int INDEX_PPSSFSTYLEID = 12;
    private static final int INDEX_PPSSFSTYLENAME = 13;
    private static final int INDEX_PRJLIST = 14;
    private static final int INDEX_PRJTYPE = 15;
    private static final int INDEX_PSDEVCENTERID = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_PSDEVSLNID = 18;
    private static final int INDEX_PSSFID = 19;
    private static final int INDEX_PSSFNAME = 20;
    private static final int INDEX_PSSFSTYLEID = 21;
    private static final int INDEX_PSSFSTYLENAME = 22;
    private static final int INDEX_PUBMODE = 23;
    private static final int INDEX_REFRESHVER = 24;
    private static final int INDEX_STYLEENGINE = 25;
    private static final int INDEX_STYLERESURL = 26;
    private static final int INDEX_TEMPLINFO = 27;
    private static final int INDEX_TEMPLROOTURL = 28;
    private static final int INDEX_TEMPLSTATE = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_V2FOLDER = 34;
    private static final int INDEX_V2FOLDER2 = 35;
    private static final int INDEX_V2GITPATH = 36;
    private static final int INDEX_VERSION = 37;
    private static final int INDEX_VERSTR = 38;
    private static final int INDEX_WORKSHOPNAME = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStyleBase proxyPSSFStyleBase = null;
    private boolean clspkgparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean enabledeploycenterDirtyFlag = false;
    private boolean enablewsserverDirtyFlag = false;
    private boolean lastestflagDirtyFlag = false;
    private boolean mainpssfstyleidDirtyFlag = false;
    private boolean mainpssfstylenameDirtyFlag = false;
    private boolean mainstyleflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pkginheritmodeDirtyFlag = false;
    private boolean ppssfstyleidDirtyFlag = false;
    private boolean ppssfstylenameDirtyFlag = false;
    private boolean prjlistDirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean refreshverDirtyFlag = false;
    private boolean styleengineDirtyFlag = false;
    private boolean styleresurlDirtyFlag = false;
    private boolean templinfoDirtyFlag = false;
    private boolean templrooturlDirtyFlag = false;
    private boolean templstateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean v2folderDirtyFlag = false;
    private boolean v2folder2DirtyFlag = false;
    private boolean v2gitpathDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    private boolean verstrDirtyFlag = false;
    private boolean workshopnameDirtyFlag = false;
    @Column(name="clspkgparams")
    private String clspkgparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="enabledeploycenter")
    private Integer enabledeploycenter;
    @Column(name="enablewsserver")
    private Integer enablewsserver;
    @Column(name="lastestflag")
    private Integer lastestflag;
    @Column(name="mainpssfstyleid")
    private String mainpssfstyleid;
    @Column(name="mainpssfstylename")
    private String mainpssfstylename;
    @Column(name="mainstyleflag")
    private Integer mainstyleflag;
    @Column(name="memo")
    private String memo;
    @Column(name="pkginheritmode")
    private Integer pkginheritmode;
    @Column(name="ppssfstyleid")
    private String ppssfstyleid;
    @Column(name="ppssfstylename")
    private String ppssfstylename;
    @Column(name="prjlist")
    private String prjlist;
    @Column(name="prjtype")
    private Integer prjtype;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
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
    @Column(name="refreshver")
    private Integer refreshver;
    @Column(name="styleengine")
    private String styleengine;
    @Column(name="styleresurl")
    private String styleresurl;
    @Column(name="templinfo")
    private String templinfo;
    @Column(name="templrooturl")
    private String templrooturl;
    @Column(name="templstate")
    private Integer templstate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="v2folder")
    private String v2folder;
    @Column(name="v2folder2")
    private String v2folder2;
    @Column(name="v2gitpath")
    private String v2gitpath;
    @Column(name="version")
    private Integer version;
    @Column(name="verstr")
    private String verstr;
    @Column(name="workshopname")
    private String workshopname;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objMainPSSFStyleLock = new Integer(1);
    private PSSFStyle mainpssfstyle = null;
    private Integer objPPSSFStyleLock = new Integer(1);
    private PSSFStyle ppssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSSFCodeFoldersLock = new Integer(1);
    private ArrayList<PSSFCodeFolder> pssfcodefolders = null;
    private Integer objPSSFStylePrjsLock = new Integer(1);
    private ArrayList<PSSFStylePrj> pssfstyleprjs = null;

    public void setClsPkgParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPkgParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspkgparams = string;
        this.clspkgparamsDirtyFlag = true;
    }

    public String getClsPkgParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPkgParams();
        }
        return this.clspkgparams;
    }

    public boolean isClsPkgParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPkgParamsDirty();
        }
        return this.clspkgparamsDirtyFlag;
    }

    public void resetClsPkgParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPkgParams();
            return;
        }
        this.clspkgparamsDirtyFlag = false;
        this.clspkgparams = null;
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

    public void setEnableDeployCenter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDeployCenter(n);
            return;
        }
        this.enabledeploycenter = n;
        this.enabledeploycenterDirtyFlag = true;
    }

    public Integer getEnableDeployCenter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDeployCenter();
        }
        return this.enabledeploycenter;
    }

    public boolean isEnableDeployCenterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDeployCenterDirty();
        }
        return this.enabledeploycenterDirtyFlag;
    }

    public void resetEnableDeployCenter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDeployCenter();
            return;
        }
        this.enabledeploycenterDirtyFlag = false;
        this.enabledeploycenter = null;
    }

    public void setEnableWSServer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableWSServer(n);
            return;
        }
        this.enablewsserver = n;
        this.enablewsserverDirtyFlag = true;
    }

    public Integer getEnableWSServer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableWSServer();
        }
        return this.enablewsserver;
    }

    public boolean isEnableWSServerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableWSServerDirty();
        }
        return this.enablewsserverDirtyFlag;
    }

    public void resetEnableWSServer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableWSServer();
            return;
        }
        this.enablewsserverDirtyFlag = false;
        this.enablewsserver = null;
    }

    public void setLastestFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastestFlag(n);
            return;
        }
        this.lastestflag = n;
        this.lastestflagDirtyFlag = true;
    }

    public Integer getLastestFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastestFlag();
        }
        return this.lastestflag;
    }

    public boolean isLastestFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastestFlagDirty();
        }
        return this.lastestflagDirtyFlag;
    }

    public void resetLastestFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastestFlag();
            return;
        }
        this.lastestflagDirtyFlag = false;
        this.lastestflag = null;
    }

    public void setMainPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpssfstyleid = string;
        this.mainpssfstyleidDirtyFlag = true;
    }

    public String getMainPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSSFStyleId();
        }
        return this.mainpssfstyleid;
    }

    public boolean isMainPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSSFStyleIdDirty();
        }
        return this.mainpssfstyleidDirtyFlag;
    }

    public void resetMainPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSSFStyleId();
            return;
        }
        this.mainpssfstyleidDirtyFlag = false;
        this.mainpssfstyleid = null;
    }

    public void setMainPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpssfstylename = string;
        this.mainpssfstylenameDirtyFlag = true;
    }

    public String getMainPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSSFStyleName();
        }
        return this.mainpssfstylename;
    }

    public boolean isMainPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSSFStyleNameDirty();
        }
        return this.mainpssfstylenameDirtyFlag;
    }

    public void resetMainPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSSFStyleName();
            return;
        }
        this.mainpssfstylenameDirtyFlag = false;
        this.mainpssfstylename = null;
    }

    public void setMainStyleFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainStyleFlag(n);
            return;
        }
        this.mainstyleflag = n;
        this.mainstyleflagDirtyFlag = true;
    }

    public Integer getMainStyleFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainStyleFlag();
        }
        return this.mainstyleflag;
    }

    public boolean isMainStyleFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainStyleFlagDirty();
        }
        return this.mainstyleflagDirtyFlag;
    }

    public void resetMainStyleFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainStyleFlag();
            return;
        }
        this.mainstyleflagDirtyFlag = false;
        this.mainstyleflag = null;
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

    public void setPkgInheritMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgInheritMode(n);
            return;
        }
        this.pkginheritmode = n;
        this.pkginheritmodeDirtyFlag = true;
    }

    public Integer getPkgInheritMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgInheritMode();
        }
        return this.pkginheritmode;
    }

    public boolean isPkgInheritModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgInheritModeDirty();
        }
        return this.pkginheritmodeDirtyFlag;
    }

    public void resetPkgInheritMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgInheritMode();
            return;
        }
        this.pkginheritmodeDirtyFlag = false;
        this.pkginheritmode = null;
    }

    public void setPPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssfstyleid = string;
        this.ppssfstyleidDirtyFlag = true;
    }

    public String getPPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSFStyleId();
        }
        return this.ppssfstyleid;
    }

    public boolean isPPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSFStyleIdDirty();
        }
        return this.ppssfstyleidDirtyFlag;
    }

    public void resetPPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSFStyleId();
            return;
        }
        this.ppssfstyleidDirtyFlag = false;
        this.ppssfstyleid = null;
    }

    public void setPPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssfstylename = string;
        this.ppssfstylenameDirtyFlag = true;
    }

    public String getPPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSFStyleName();
        }
        return this.ppssfstylename;
    }

    public boolean isPPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSFStyleNameDirty();
        }
        return this.ppssfstylenameDirtyFlag;
    }

    public void resetPPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSFStyleName();
            return;
        }
        this.ppssfstylenameDirtyFlag = false;
        this.ppssfstylename = null;
    }

    public void setPrjList(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjList(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjlist = string;
        this.prjlistDirtyFlag = true;
    }

    public String getPrjList() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjList();
        }
        return this.prjlist;
    }

    public boolean isPrjListDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjListDirty();
        }
        return this.prjlistDirtyFlag;
    }

    public void resetPrjList() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjList();
            return;
        }
        this.prjlistDirtyFlag = false;
        this.prjlist = null;
    }

    public void setPrjType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjType(n);
            return;
        }
        this.prjtype = n;
        this.prjtypeDirtyFlag = true;
    }

    public Integer getPrjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjType();
        }
        return this.prjtype;
    }

    public boolean isPrjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjTypeDirty();
        }
        return this.prjtypeDirtyFlag;
    }

    public void resetPrjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjType();
            return;
        }
        this.prjtypeDirtyFlag = false;
        this.prjtype = null;
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

    public void setRefreshVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefreshVer(n);
            return;
        }
        this.refreshver = n;
        this.refreshverDirtyFlag = true;
    }

    public Integer getRefreshVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefreshVer();
        }
        return this.refreshver;
    }

    public boolean isRefreshVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefreshVerDirty();
        }
        return this.refreshverDirtyFlag;
    }

    public void resetRefreshVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefreshVer();
            return;
        }
        this.refreshverDirtyFlag = false;
        this.refreshver = null;
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

    public void setStyleResUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleResUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.styleresurl = string;
        this.styleresurlDirtyFlag = true;
    }

    public String getStyleResUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleResUrl();
        }
        return this.styleresurl;
    }

    public boolean isStyleResUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleResUrlDirty();
        }
        return this.styleresurlDirtyFlag;
    }

    public void resetStyleResUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleResUrl();
            return;
        }
        this.styleresurlDirtyFlag = false;
        this.styleresurl = null;
    }

    public void setTemplInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templinfo = string;
        this.templinfoDirtyFlag = true;
    }

    public String getTemplInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplInfo();
        }
        return this.templinfo;
    }

    public boolean isTemplInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplInfoDirty();
        }
        return this.templinfoDirtyFlag;
    }

    public void resetTemplInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplInfo();
            return;
        }
        this.templinfoDirtyFlag = false;
        this.templinfo = null;
    }

    public void setTemplRootUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplRootUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templrooturl = string;
        this.templrooturlDirtyFlag = true;
    }

    public String getTemplRootUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplRootUrl();
        }
        return this.templrooturl;
    }

    public boolean isTemplRootUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplRootUrlDirty();
        }
        return this.templrooturlDirtyFlag;
    }

    public void resetTemplRootUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplRootUrl();
            return;
        }
        this.templrooturlDirtyFlag = false;
        this.templrooturl = null;
    }

    public void setTemplState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplState(n);
            return;
        }
        this.templstate = n;
        this.templstateDirtyFlag = true;
    }

    public Integer getTemplState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplState();
        }
        return this.templstate;
    }

    public boolean isTemplStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplStateDirty();
        }
        return this.templstateDirtyFlag;
    }

    public void resetTemplState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplState();
            return;
        }
        this.templstateDirtyFlag = false;
        this.templstate = null;
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

    public void setV2Folder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2Folder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2folder = string;
        this.v2folderDirtyFlag = true;
    }

    public String getV2Folder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2Folder();
        }
        return this.v2folder;
    }

    public boolean isV2FolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2FolderDirty();
        }
        return this.v2folderDirtyFlag;
    }

    public void resetV2Folder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2Folder();
            return;
        }
        this.v2folderDirtyFlag = false;
        this.v2folder = null;
    }

    public void setV2Folder2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2Folder2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2folder2 = string;
        this.v2folder2DirtyFlag = true;
    }

    public String getV2Folder2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2Folder2();
        }
        return this.v2folder2;
    }

    public boolean isV2Folder2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2Folder2Dirty();
        }
        return this.v2folder2DirtyFlag;
    }

    public void resetV2Folder2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2Folder2();
            return;
        }
        this.v2folder2DirtyFlag = false;
        this.v2folder2 = null;
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

    public void setVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(n);
            return;
        }
        this.version = n;
        this.versionDirtyFlag = true;
    }

    public Integer getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
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

    public void setWorkshopName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWorkshopName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.workshopname = string;
        this.workshopnameDirtyFlag = true;
    }

    public String getWorkshopName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWorkshopName();
        }
        return this.workshopname;
    }

    public boolean isWorkshopNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWorkshopNameDirty();
        }
        return this.workshopnameDirtyFlag;
    }

    public void resetWorkshopName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWorkshopName();
            return;
        }
        this.workshopnameDirtyFlag = false;
        this.workshopname = null;
    }

    protected void onReset() {
        PSSFStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStyleBase pSSFStyleBase) {
        pSSFStyleBase.resetClsPkgParams();
        pSSFStyleBase.resetCreateDate();
        pSSFStyleBase.resetCreateMan();
        pSSFStyleBase.resetDefaultFlag();
        pSSFStyleBase.resetEnableDeployCenter();
        pSSFStyleBase.resetEnableWSServer();
        pSSFStyleBase.resetLastestFlag();
        pSSFStyleBase.resetMainPSSFStyleId();
        pSSFStyleBase.resetMainPSSFStyleName();
        pSSFStyleBase.resetMainStyleFlag();
        pSSFStyleBase.resetMemo();
        pSSFStyleBase.resetPkgInheritMode();
        pSSFStyleBase.resetPPSSFStyleId();
        pSSFStyleBase.resetPPSSFStyleName();
        pSSFStyleBase.resetPrjList();
        pSSFStyleBase.resetPrjType();
        pSSFStyleBase.resetPSDevCenterId();
        pSSFStyleBase.resetPSDevCenterName();
        pSSFStyleBase.resetPSDevSlnId();
        pSSFStyleBase.resetPSSFId();
        pSSFStyleBase.resetPSSFName();
        pSSFStyleBase.resetPSSFStyleId();
        pSSFStyleBase.resetPSSFStyleName();
        pSSFStyleBase.resetPubMode();
        pSSFStyleBase.resetRefreshVer();
        pSSFStyleBase.resetStyleEngine();
        pSSFStyleBase.resetStyleResUrl();
        pSSFStyleBase.resetTemplInfo();
        pSSFStyleBase.resetTemplRootUrl();
        pSSFStyleBase.resetTemplState();
        pSSFStyleBase.resetUpdateDate();
        pSSFStyleBase.resetUpdateMan();
        pSSFStyleBase.resetUserTag();
        pSSFStyleBase.resetUserTag2();
        pSSFStyleBase.resetV2Folder();
        pSSFStyleBase.resetV2Folder2();
        pSSFStyleBase.resetV2GitPath();
        pSSFStyleBase.resetVersion();
        pSSFStyleBase.resetVerStr();
        pSSFStyleBase.resetWorkshopName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClsPkgParamsDirty()) {
            hashMap.put(FIELD_CLSPKGPARAMS, this.getClsPkgParams());
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
        if (!bl || this.isEnableDeployCenterDirty()) {
            hashMap.put(FIELD_ENABLEDEPLOYCENTER, this.getEnableDeployCenter());
        }
        if (!bl || this.isEnableWSServerDirty()) {
            hashMap.put(FIELD_ENABLEWSSERVER, this.getEnableWSServer());
        }
        if (!bl || this.isLastestFlagDirty()) {
            hashMap.put(FIELD_LASTESTFLAG, this.getLastestFlag());
        }
        if (!bl || this.isMainPSSFStyleIdDirty()) {
            hashMap.put(FIELD_MAINPSSFSTYLEID, this.getMainPSSFStyleId());
        }
        if (!bl || this.isMainPSSFStyleNameDirty()) {
            hashMap.put(FIELD_MAINPSSFSTYLENAME, this.getMainPSSFStyleName());
        }
        if (!bl || this.isMainStyleFlagDirty()) {
            hashMap.put(FIELD_MAINSTYLEFLAG, this.getMainStyleFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPkgInheritModeDirty()) {
            hashMap.put(FIELD_PKGINHERITMODE, this.getPkgInheritMode());
        }
        if (!bl || this.isPPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PPSSFSTYLEID, this.getPPSSFStyleId());
        }
        if (!bl || this.isPPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PPSSFSTYLENAME, this.getPPSSFStyleName());
        }
        if (!bl || this.isPrjListDirty()) {
            hashMap.put(FIELD_PRJLIST, this.getPrjList());
        }
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
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
        if (!bl || this.isRefreshVerDirty()) {
            hashMap.put(FIELD_REFRESHVER, this.getRefreshVer());
        }
        if (!bl || this.isStyleEngineDirty()) {
            hashMap.put(FIELD_STYLEENGINE, this.getStyleEngine());
        }
        if (!bl || this.isStyleResUrlDirty()) {
            hashMap.put(FIELD_STYLERESURL, this.getStyleResUrl());
        }
        if (!bl || this.isTemplInfoDirty()) {
            hashMap.put(FIELD_TEMPLINFO, this.getTemplInfo());
        }
        if (!bl || this.isTemplRootUrlDirty()) {
            hashMap.put(FIELD_TEMPLROOTURL, this.getTemplRootUrl());
        }
        if (!bl || this.isTemplStateDirty()) {
            hashMap.put(FIELD_TEMPLSTATE, this.getTemplState());
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
        if (!bl || this.isV2FolderDirty()) {
            hashMap.put(FIELD_V2FOLDER, this.getV2Folder());
        }
        if (!bl || this.isV2Folder2Dirty()) {
            hashMap.put(FIELD_V2FOLDER2, this.getV2Folder2());
        }
        if (!bl || this.isV2GitPathDirty()) {
            hashMap.put(FIELD_V2GITPATH, this.getV2GitPath());
        }
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
        }
        if (!bl || this.isVerStrDirty()) {
            hashMap.put(FIELD_VERSTR, this.getVerStr());
        }
        if (!bl || this.isWorkshopNameDirty()) {
            hashMap.put(FIELD_WORKSHOPNAME, this.getWorkshopName());
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
        return PSSFStyleBase.get(this, n);
    }

    private static Object get(PSSFStyleBase pSSFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleBase.getClsPkgParams();
            }
            case 1: {
                return pSSFStyleBase.getCreateDate();
            }
            case 2: {
                return pSSFStyleBase.getCreateMan();
            }
            case 3: {
                return pSSFStyleBase.getDefaultFlag();
            }
            case 4: {
                return pSSFStyleBase.getEnableDeployCenter();
            }
            case 5: {
                return pSSFStyleBase.getEnableWSServer();
            }
            case 6: {
                return pSSFStyleBase.getLastestFlag();
            }
            case 7: {
                return pSSFStyleBase.getMainPSSFStyleId();
            }
            case 8: {
                return pSSFStyleBase.getMainPSSFStyleName();
            }
            case 9: {
                return pSSFStyleBase.getMainStyleFlag();
            }
            case 10: {
                return pSSFStyleBase.getMemo();
            }
            case 11: {
                return pSSFStyleBase.getPkgInheritMode();
            }
            case 12: {
                return pSSFStyleBase.getPPSSFStyleId();
            }
            case 13: {
                return pSSFStyleBase.getPPSSFStyleName();
            }
            case 14: {
                return pSSFStyleBase.getPrjList();
            }
            case 15: {
                return pSSFStyleBase.getPrjType();
            }
            case 16: {
                return pSSFStyleBase.getPSDevCenterId();
            }
            case 17: {
                return pSSFStyleBase.getPSDevCenterName();
            }
            case 18: {
                return pSSFStyleBase.getPSDevSlnId();
            }
            case 19: {
                return pSSFStyleBase.getPSSFId();
            }
            case 20: {
                return pSSFStyleBase.getPSSFName();
            }
            case 21: {
                return pSSFStyleBase.getPSSFStyleId();
            }
            case 22: {
                return pSSFStyleBase.getPSSFStyleName();
            }
            case 23: {
                return pSSFStyleBase.getPubMode();
            }
            case 24: {
                return pSSFStyleBase.getRefreshVer();
            }
            case 25: {
                return pSSFStyleBase.getStyleEngine();
            }
            case 26: {
                return pSSFStyleBase.getStyleResUrl();
            }
            case 27: {
                return pSSFStyleBase.getTemplInfo();
            }
            case 28: {
                return pSSFStyleBase.getTemplRootUrl();
            }
            case 29: {
                return pSSFStyleBase.getTemplState();
            }
            case 30: {
                return pSSFStyleBase.getUpdateDate();
            }
            case 31: {
                return pSSFStyleBase.getUpdateMan();
            }
            case 32: {
                return pSSFStyleBase.getUserTag();
            }
            case 33: {
                return pSSFStyleBase.getUserTag2();
            }
            case 34: {
                return pSSFStyleBase.getV2Folder();
            }
            case 35: {
                return pSSFStyleBase.getV2Folder2();
            }
            case 36: {
                return pSSFStyleBase.getV2GitPath();
            }
            case 37: {
                return pSSFStyleBase.getVersion();
            }
            case 38: {
                return pSSFStyleBase.getVerStr();
            }
            case 39: {
                return pSSFStyleBase.getWorkshopName();
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
        PSSFStyleBase.set(this, n, object);
    }

    private static void set(PSSFStyleBase pSSFStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleBase.setClsPkgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSFStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFStyleBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSFStyleBase.setEnableDeployCenter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSFStyleBase.setEnableWSServer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSFStyleBase.setLastestFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSFStyleBase.setMainPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFStyleBase.setMainPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFStyleBase.setMainStyleFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSFStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFStyleBase.setPkgInheritMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSFStyleBase.setPPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFStyleBase.setPPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFStyleBase.setPrjList(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFStyleBase.setPrjType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSFStyleBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSFStyleBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSFStyleBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSFStyleBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSFStyleBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSFStyleBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSFStyleBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSFStyleBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSFStyleBase.setRefreshVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSFStyleBase.setStyleEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSFStyleBase.setStyleResUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSFStyleBase.setTemplInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSFStyleBase.setTemplRootUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSFStyleBase.setTemplState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSFStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSSFStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSFStyleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSFStyleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSFStyleBase.setV2Folder(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSFStyleBase.setV2Folder2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSFStyleBase.setV2GitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSFStyleBase.setVersion(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSFStyleBase.setVerStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSFStyleBase.setWorkshopName(DataObject.getStringValue((Object)object));
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
        return PSSFStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStyleBase pSSFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleBase.getClsPkgParams() == null;
            }
            case 1: {
                return pSSFStyleBase.getCreateDate() == null;
            }
            case 2: {
                return pSSFStyleBase.getCreateMan() == null;
            }
            case 3: {
                return pSSFStyleBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSSFStyleBase.getEnableDeployCenter() == null;
            }
            case 5: {
                return pSSFStyleBase.getEnableWSServer() == null;
            }
            case 6: {
                return pSSFStyleBase.getLastestFlag() == null;
            }
            case 7: {
                return pSSFStyleBase.getMainPSSFStyleId() == null;
            }
            case 8: {
                return pSSFStyleBase.getMainPSSFStyleName() == null;
            }
            case 9: {
                return pSSFStyleBase.getMainStyleFlag() == null;
            }
            case 10: {
                return pSSFStyleBase.getMemo() == null;
            }
            case 11: {
                return pSSFStyleBase.getPkgInheritMode() == null;
            }
            case 12: {
                return pSSFStyleBase.getPPSSFStyleId() == null;
            }
            case 13: {
                return pSSFStyleBase.getPPSSFStyleName() == null;
            }
            case 14: {
                return pSSFStyleBase.getPrjList() == null;
            }
            case 15: {
                return pSSFStyleBase.getPrjType() == null;
            }
            case 16: {
                return pSSFStyleBase.getPSDevCenterId() == null;
            }
            case 17: {
                return pSSFStyleBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSSFStyleBase.getPSDevSlnId() == null;
            }
            case 19: {
                return pSSFStyleBase.getPSSFId() == null;
            }
            case 20: {
                return pSSFStyleBase.getPSSFName() == null;
            }
            case 21: {
                return pSSFStyleBase.getPSSFStyleId() == null;
            }
            case 22: {
                return pSSFStyleBase.getPSSFStyleName() == null;
            }
            case 23: {
                return pSSFStyleBase.getPubMode() == null;
            }
            case 24: {
                return pSSFStyleBase.getRefreshVer() == null;
            }
            case 25: {
                return pSSFStyleBase.getStyleEngine() == null;
            }
            case 26: {
                return pSSFStyleBase.getStyleResUrl() == null;
            }
            case 27: {
                return pSSFStyleBase.getTemplInfo() == null;
            }
            case 28: {
                return pSSFStyleBase.getTemplRootUrl() == null;
            }
            case 29: {
                return pSSFStyleBase.getTemplState() == null;
            }
            case 30: {
                return pSSFStyleBase.getUpdateDate() == null;
            }
            case 31: {
                return pSSFStyleBase.getUpdateMan() == null;
            }
            case 32: {
                return pSSFStyleBase.getUserTag() == null;
            }
            case 33: {
                return pSSFStyleBase.getUserTag2() == null;
            }
            case 34: {
                return pSSFStyleBase.getV2Folder() == null;
            }
            case 35: {
                return pSSFStyleBase.getV2Folder2() == null;
            }
            case 36: {
                return pSSFStyleBase.getV2GitPath() == null;
            }
            case 37: {
                return pSSFStyleBase.getVersion() == null;
            }
            case 38: {
                return pSSFStyleBase.getVerStr() == null;
            }
            case 39: {
                return pSSFStyleBase.getWorkshopName() == null;
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
        return PSSFStyleBase.contains(this, n);
    }

    private static boolean contains(PSSFStyleBase pSSFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleBase.isClsPkgParamsDirty();
            }
            case 1: {
                return pSSFStyleBase.isCreateDateDirty();
            }
            case 2: {
                return pSSFStyleBase.isCreateManDirty();
            }
            case 3: {
                return pSSFStyleBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSSFStyleBase.isEnableDeployCenterDirty();
            }
            case 5: {
                return pSSFStyleBase.isEnableWSServerDirty();
            }
            case 6: {
                return pSSFStyleBase.isLastestFlagDirty();
            }
            case 7: {
                return pSSFStyleBase.isMainPSSFStyleIdDirty();
            }
            case 8: {
                return pSSFStyleBase.isMainPSSFStyleNameDirty();
            }
            case 9: {
                return pSSFStyleBase.isMainStyleFlagDirty();
            }
            case 10: {
                return pSSFStyleBase.isMemoDirty();
            }
            case 11: {
                return pSSFStyleBase.isPkgInheritModeDirty();
            }
            case 12: {
                return pSSFStyleBase.isPPSSFStyleIdDirty();
            }
            case 13: {
                return pSSFStyleBase.isPPSSFStyleNameDirty();
            }
            case 14: {
                return pSSFStyleBase.isPrjListDirty();
            }
            case 15: {
                return pSSFStyleBase.isPrjTypeDirty();
            }
            case 16: {
                return pSSFStyleBase.isPSDevCenterIdDirty();
            }
            case 17: {
                return pSSFStyleBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSSFStyleBase.isPSDevSlnIdDirty();
            }
            case 19: {
                return pSSFStyleBase.isPSSFIdDirty();
            }
            case 20: {
                return pSSFStyleBase.isPSSFNameDirty();
            }
            case 21: {
                return pSSFStyleBase.isPSSFStyleIdDirty();
            }
            case 22: {
                return pSSFStyleBase.isPSSFStyleNameDirty();
            }
            case 23: {
                return pSSFStyleBase.isPubModeDirty();
            }
            case 24: {
                return pSSFStyleBase.isRefreshVerDirty();
            }
            case 25: {
                return pSSFStyleBase.isStyleEngineDirty();
            }
            case 26: {
                return pSSFStyleBase.isStyleResUrlDirty();
            }
            case 27: {
                return pSSFStyleBase.isTemplInfoDirty();
            }
            case 28: {
                return pSSFStyleBase.isTemplRootUrlDirty();
            }
            case 29: {
                return pSSFStyleBase.isTemplStateDirty();
            }
            case 30: {
                return pSSFStyleBase.isUpdateDateDirty();
            }
            case 31: {
                return pSSFStyleBase.isUpdateManDirty();
            }
            case 32: {
                return pSSFStyleBase.isUserTagDirty();
            }
            case 33: {
                return pSSFStyleBase.isUserTag2Dirty();
            }
            case 34: {
                return pSSFStyleBase.isV2FolderDirty();
            }
            case 35: {
                return pSSFStyleBase.isV2Folder2Dirty();
            }
            case 36: {
                return pSSFStyleBase.isV2GitPathDirty();
            }
            case 37: {
                return pSSFStyleBase.isVersionDirty();
            }
            case 38: {
                return pSSFStyleBase.isVerStrDirty();
            }
            case 39: {
                return pSSFStyleBase.isWorkshopNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStyleBase pSSFStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStyleBase.getClsPkgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspkgparams", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getClsPkgParams()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getEnableDeployCenter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledeploycenter", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getEnableDeployCenter()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getEnableWSServer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablewsserver", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getEnableWSServer()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getLastestFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastestflag", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getLastestFlag()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getMainPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpssfstyleid", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getMainPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getMainPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpssfstylename", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getMainPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getMainStyleFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainstyleflag", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getMainStyleFlag()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPkgInheritMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkginheritmode", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPkgInheritMode()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssfstyleid", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssfstylename", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPrjList() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjlist", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPrjList()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPrjType()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getPubMode()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getRefreshVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refreshver", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getRefreshVer()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getStyleEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleengine", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getStyleEngine()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getStyleResUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleresurl", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getStyleResUrl()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getTemplInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templinfo", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getTemplInfo()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getTemplRootUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templrooturl", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getTemplRootUrl()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getTemplState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templstate", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getTemplState()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getV2Folder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2folder", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getV2Folder()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getV2Folder2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2folder2", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getV2Folder2()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getV2GitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2gitpath", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getV2GitPath()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getVersion()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getVerStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verstr", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getVerStr()), (boolean)false);
        }
        if (bl || pSSFStyleBase.getWorkshopName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"workshopname", (Object)PSSFStyleBase.getJSONValue((Object)pSSFStyleBase.getWorkshopName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStyleBase pSSFStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStyleBase.getClsPkgParams() != null) {
            object = pSSFStyleBase.getClsPkgParams();
            xmlNode.setAttribute(FIELD_CLSPKGPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getCreateDate() != null) {
            object = pSSFStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleBase.getCreateMan() != null) {
            object = pSSFStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getDefaultFlag() != null) {
            object = pSSFStyleBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getEnableDeployCenter() != null) {
            object = pSSFStyleBase.getEnableDeployCenter();
            xmlNode.setAttribute(FIELD_ENABLEDEPLOYCENTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getEnableWSServer() != null) {
            object = pSSFStyleBase.getEnableWSServer();
            xmlNode.setAttribute(FIELD_ENABLEWSSERVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getLastestFlag() != null) {
            object = pSSFStyleBase.getLastestFlag();
            xmlNode.setAttribute(FIELD_LASTESTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getMainPSSFStyleId() != null) {
            object = pSSFStyleBase.getMainPSSFStyleId();
            xmlNode.setAttribute(FIELD_MAINPSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getMainPSSFStyleName() != null) {
            object = pSSFStyleBase.getMainPSSFStyleName();
            xmlNode.setAttribute(FIELD_MAINPSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getMainStyleFlag() != null) {
            object = pSSFStyleBase.getMainStyleFlag();
            xmlNode.setAttribute(FIELD_MAINSTYLEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getMemo() != null) {
            object = pSSFStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPkgInheritMode() != null) {
            object = pSSFStyleBase.getPkgInheritMode();
            xmlNode.setAttribute(FIELD_PKGINHERITMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getPPSSFStyleId() != null) {
            object = pSSFStyleBase.getPPSSFStyleId();
            xmlNode.setAttribute(FIELD_PPSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPPSSFStyleName() != null) {
            object = pSSFStyleBase.getPPSSFStyleName();
            xmlNode.setAttribute(FIELD_PPSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPrjList() != null) {
            object = pSSFStyleBase.getPrjList();
            xmlNode.setAttribute(FIELD_PRJLIST, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPrjType() != null) {
            object = pSSFStyleBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getPSDevCenterId() != null) {
            object = pSSFStyleBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPSDevCenterName() != null) {
            object = pSSFStyleBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPSDevSlnId() != null) {
            object = pSSFStyleBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPSSFId() != null) {
            object = pSSFStyleBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPSSFName() != null) {
            object = pSSFStyleBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPSSFStyleId() != null) {
            object = pSSFStyleBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPSSFStyleName() != null) {
            object = pSSFStyleBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getPubMode() != null) {
            object = pSSFStyleBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getRefreshVer() != null) {
            object = pSSFStyleBase.getRefreshVer();
            xmlNode.setAttribute(FIELD_REFRESHVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getStyleEngine() != null) {
            object = pSSFStyleBase.getStyleEngine();
            xmlNode.setAttribute(FIELD_STYLEENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getStyleResUrl() != null) {
            object = pSSFStyleBase.getStyleResUrl();
            xmlNode.setAttribute(FIELD_STYLERESURL, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getTemplInfo() != null) {
            object = pSSFStyleBase.getTemplInfo();
            xmlNode.setAttribute(FIELD_TEMPLINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getTemplRootUrl() != null) {
            object = pSSFStyleBase.getTemplRootUrl();
            xmlNode.setAttribute(FIELD_TEMPLROOTURL, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getTemplState() != null) {
            object = pSSFStyleBase.getTemplState();
            xmlNode.setAttribute(FIELD_TEMPLSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getUpdateDate() != null) {
            object = pSSFStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleBase.getUpdateMan() != null) {
            object = pSSFStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getUserTag() != null) {
            object = pSSFStyleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getUserTag2() != null) {
            object = pSSFStyleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getV2Folder() != null) {
            object = pSSFStyleBase.getV2Folder();
            xmlNode.setAttribute(FIELD_V2FOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getV2Folder2() != null) {
            object = pSSFStyleBase.getV2Folder2();
            xmlNode.setAttribute(FIELD_V2FOLDER2, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getV2GitPath() != null) {
            object = pSSFStyleBase.getV2GitPath();
            xmlNode.setAttribute(FIELD_V2GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getVersion() != null) {
            object = pSSFStyleBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleBase.getVerStr() != null) {
            object = pSSFStyleBase.getVerStr();
            xmlNode.setAttribute(FIELD_VERSTR, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleBase.getWorkshopName() != null) {
            object = pSSFStyleBase.getWorkshopName();
            xmlNode.setAttribute(FIELD_WORKSHOPNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStyleBase pSSFStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStyleBase.isClsPkgParamsDirty() && (bl || pSSFStyleBase.getClsPkgParams() != null)) {
            iDataObject.set(FIELD_CLSPKGPARAMS, (Object)pSSFStyleBase.getClsPkgParams());
        }
        if (pSSFStyleBase.isCreateDateDirty() && (bl || pSSFStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStyleBase.getCreateDate());
        }
        if (pSSFStyleBase.isCreateManDirty() && (bl || pSSFStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStyleBase.getCreateMan());
        }
        if (pSSFStyleBase.isDefaultFlagDirty() && (bl || pSSFStyleBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSFStyleBase.getDefaultFlag());
        }
        if (pSSFStyleBase.isEnableDeployCenterDirty() && (bl || pSSFStyleBase.getEnableDeployCenter() != null)) {
            iDataObject.set(FIELD_ENABLEDEPLOYCENTER, (Object)pSSFStyleBase.getEnableDeployCenter());
        }
        if (pSSFStyleBase.isEnableWSServerDirty() && (bl || pSSFStyleBase.getEnableWSServer() != null)) {
            iDataObject.set(FIELD_ENABLEWSSERVER, (Object)pSSFStyleBase.getEnableWSServer());
        }
        if (pSSFStyleBase.isLastestFlagDirty() && (bl || pSSFStyleBase.getLastestFlag() != null)) {
            iDataObject.set(FIELD_LASTESTFLAG, (Object)pSSFStyleBase.getLastestFlag());
        }
        if (pSSFStyleBase.isMainPSSFStyleIdDirty() && (bl || pSSFStyleBase.getMainPSSFStyleId() != null)) {
            iDataObject.set(FIELD_MAINPSSFSTYLEID, (Object)pSSFStyleBase.getMainPSSFStyleId());
        }
        if (pSSFStyleBase.isMainPSSFStyleNameDirty() && (bl || pSSFStyleBase.getMainPSSFStyleName() != null)) {
            iDataObject.set(FIELD_MAINPSSFSTYLENAME, (Object)pSSFStyleBase.getMainPSSFStyleName());
        }
        if (pSSFStyleBase.isMainStyleFlagDirty() && (bl || pSSFStyleBase.getMainStyleFlag() != null)) {
            iDataObject.set(FIELD_MAINSTYLEFLAG, (Object)pSSFStyleBase.getMainStyleFlag());
        }
        if (pSSFStyleBase.isMemoDirty() && (bl || pSSFStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFStyleBase.getMemo());
        }
        if (pSSFStyleBase.isPkgInheritModeDirty() && (bl || pSSFStyleBase.getPkgInheritMode() != null)) {
            iDataObject.set(FIELD_PKGINHERITMODE, (Object)pSSFStyleBase.getPkgInheritMode());
        }
        if (pSSFStyleBase.isPPSSFStyleIdDirty() && (bl || pSSFStyleBase.getPPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PPSSFSTYLEID, (Object)pSSFStyleBase.getPPSSFStyleId());
        }
        if (pSSFStyleBase.isPPSSFStyleNameDirty() && (bl || pSSFStyleBase.getPPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PPSSFSTYLENAME, (Object)pSSFStyleBase.getPPSSFStyleName());
        }
        if (pSSFStyleBase.isPrjListDirty() && (bl || pSSFStyleBase.getPrjList() != null)) {
            iDataObject.set(FIELD_PRJLIST, (Object)pSSFStyleBase.getPrjList());
        }
        if (pSSFStyleBase.isPrjTypeDirty() && (bl || pSSFStyleBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSSFStyleBase.getPrjType());
        }
        if (pSSFStyleBase.isPSDevCenterIdDirty() && (bl || pSSFStyleBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSFStyleBase.getPSDevCenterId());
        }
        if (pSSFStyleBase.isPSDevCenterNameDirty() && (bl || pSSFStyleBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSFStyleBase.getPSDevCenterName());
        }
        if (pSSFStyleBase.isPSDevSlnIdDirty() && (bl || pSSFStyleBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSSFStyleBase.getPSDevSlnId());
        }
        if (pSSFStyleBase.isPSSFIdDirty() && (bl || pSSFStyleBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFStyleBase.getPSSFId());
        }
        if (pSSFStyleBase.isPSSFNameDirty() && (bl || pSSFStyleBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFStyleBase.getPSSFName());
        }
        if (pSSFStyleBase.isPSSFStyleIdDirty() && (bl || pSSFStyleBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStyleBase.getPSSFStyleId());
        }
        if (pSSFStyleBase.isPSSFStyleNameDirty() && (bl || pSSFStyleBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStyleBase.getPSSFStyleName());
        }
        if (pSSFStyleBase.isPubModeDirty() && (bl || pSSFStyleBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSSFStyleBase.getPubMode());
        }
        if (pSSFStyleBase.isRefreshVerDirty() && (bl || pSSFStyleBase.getRefreshVer() != null)) {
            iDataObject.set(FIELD_REFRESHVER, (Object)pSSFStyleBase.getRefreshVer());
        }
        if (pSSFStyleBase.isStyleEngineDirty() && (bl || pSSFStyleBase.getStyleEngine() != null)) {
            iDataObject.set(FIELD_STYLEENGINE, (Object)pSSFStyleBase.getStyleEngine());
        }
        if (pSSFStyleBase.isStyleResUrlDirty() && (bl || pSSFStyleBase.getStyleResUrl() != null)) {
            iDataObject.set(FIELD_STYLERESURL, (Object)pSSFStyleBase.getStyleResUrl());
        }
        if (pSSFStyleBase.isTemplInfoDirty() && (bl || pSSFStyleBase.getTemplInfo() != null)) {
            iDataObject.set(FIELD_TEMPLINFO, (Object)pSSFStyleBase.getTemplInfo());
        }
        if (pSSFStyleBase.isTemplRootUrlDirty() && (bl || pSSFStyleBase.getTemplRootUrl() != null)) {
            iDataObject.set(FIELD_TEMPLROOTURL, (Object)pSSFStyleBase.getTemplRootUrl());
        }
        if (pSSFStyleBase.isTemplStateDirty() && (bl || pSSFStyleBase.getTemplState() != null)) {
            iDataObject.set(FIELD_TEMPLSTATE, (Object)pSSFStyleBase.getTemplState());
        }
        if (pSSFStyleBase.isUpdateDateDirty() && (bl || pSSFStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStyleBase.getUpdateDate());
        }
        if (pSSFStyleBase.isUpdateManDirty() && (bl || pSSFStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStyleBase.getUpdateMan());
        }
        if (pSSFStyleBase.isUserTagDirty() && (bl || pSSFStyleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSFStyleBase.getUserTag());
        }
        if (pSSFStyleBase.isUserTag2Dirty() && (bl || pSSFStyleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSFStyleBase.getUserTag2());
        }
        if (pSSFStyleBase.isV2FolderDirty() && (bl || pSSFStyleBase.getV2Folder() != null)) {
            iDataObject.set(FIELD_V2FOLDER, (Object)pSSFStyleBase.getV2Folder());
        }
        if (pSSFStyleBase.isV2Folder2Dirty() && (bl || pSSFStyleBase.getV2Folder2() != null)) {
            iDataObject.set(FIELD_V2FOLDER2, (Object)pSSFStyleBase.getV2Folder2());
        }
        if (pSSFStyleBase.isV2GitPathDirty() && (bl || pSSFStyleBase.getV2GitPath() != null)) {
            iDataObject.set(FIELD_V2GITPATH, (Object)pSSFStyleBase.getV2GitPath());
        }
        if (pSSFStyleBase.isVersionDirty() && (bl || pSSFStyleBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSSFStyleBase.getVersion());
        }
        if (pSSFStyleBase.isVerStrDirty() && (bl || pSSFStyleBase.getVerStr() != null)) {
            iDataObject.set(FIELD_VERSTR, (Object)pSSFStyleBase.getVerStr());
        }
        if (pSSFStyleBase.isWorkshopNameDirty() && (bl || pSSFStyleBase.getWorkshopName() != null)) {
            iDataObject.set(FIELD_WORKSHOPNAME, (Object)pSSFStyleBase.getWorkshopName());
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
        return PSSFStyleBase.remove(this, n);
    }

    private static boolean remove(PSSFStyleBase pSSFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleBase.resetClsPkgParams();
                return true;
            }
            case 1: {
                pSSFStyleBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSFStyleBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSFStyleBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSSFStyleBase.resetEnableDeployCenter();
                return true;
            }
            case 5: {
                pSSFStyleBase.resetEnableWSServer();
                return true;
            }
            case 6: {
                pSSFStyleBase.resetLastestFlag();
                return true;
            }
            case 7: {
                pSSFStyleBase.resetMainPSSFStyleId();
                return true;
            }
            case 8: {
                pSSFStyleBase.resetMainPSSFStyleName();
                return true;
            }
            case 9: {
                pSSFStyleBase.resetMainStyleFlag();
                return true;
            }
            case 10: {
                pSSFStyleBase.resetMemo();
                return true;
            }
            case 11: {
                pSSFStyleBase.resetPkgInheritMode();
                return true;
            }
            case 12: {
                pSSFStyleBase.resetPPSSFStyleId();
                return true;
            }
            case 13: {
                pSSFStyleBase.resetPPSSFStyleName();
                return true;
            }
            case 14: {
                pSSFStyleBase.resetPrjList();
                return true;
            }
            case 15: {
                pSSFStyleBase.resetPrjType();
                return true;
            }
            case 16: {
                pSSFStyleBase.resetPSDevCenterId();
                return true;
            }
            case 17: {
                pSSFStyleBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSSFStyleBase.resetPSDevSlnId();
                return true;
            }
            case 19: {
                pSSFStyleBase.resetPSSFId();
                return true;
            }
            case 20: {
                pSSFStyleBase.resetPSSFName();
                return true;
            }
            case 21: {
                pSSFStyleBase.resetPSSFStyleId();
                return true;
            }
            case 22: {
                pSSFStyleBase.resetPSSFStyleName();
                return true;
            }
            case 23: {
                pSSFStyleBase.resetPubMode();
                return true;
            }
            case 24: {
                pSSFStyleBase.resetRefreshVer();
                return true;
            }
            case 25: {
                pSSFStyleBase.resetStyleEngine();
                return true;
            }
            case 26: {
                pSSFStyleBase.resetStyleResUrl();
                return true;
            }
            case 27: {
                pSSFStyleBase.resetTemplInfo();
                return true;
            }
            case 28: {
                pSSFStyleBase.resetTemplRootUrl();
                return true;
            }
            case 29: {
                pSSFStyleBase.resetTemplState();
                return true;
            }
            case 30: {
                pSSFStyleBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSSFStyleBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSSFStyleBase.resetUserTag();
                return true;
            }
            case 33: {
                pSSFStyleBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSSFStyleBase.resetV2Folder();
                return true;
            }
            case 35: {
                pSSFStyleBase.resetV2Folder2();
                return true;
            }
            case 36: {
                pSSFStyleBase.resetV2GitPath();
                return true;
            }
            case 37: {
                pSSFStyleBase.resetVersion();
                return true;
            }
            case 38: {
                pSSFStyleBase.resetVerStr();
                return true;
            }
            case 39: {
                pSSFStyleBase.resetWorkshopName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSFStyle getMainPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSSFStyle();
        }
        if (this.getMainPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objMainPSSFStyleLock;
        synchronized (n) {
            if (this.mainpssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getMainPSSFStyleId(), (Object)this.mainpssfstyle.getPSSFStyleId()) != 0L) {
                this.mainpssfstyle = null;
            }
            if (this.mainpssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getMainPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.mainpssfstyle = pSSFStyle;
            }
            return this.mainpssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSFStyle();
        }
        if (this.getPPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPPSSFStyleLock;
        synchronized (n) {
            if (this.ppssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSFStyleId(), (Object)this.ppssfstyle.getPSSFStyleId()) != 0L) {
                this.ppssfstyle = null;
            }
            if (this.ppssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.ppssfstyle = pSSFStyle;
            }
            return this.ppssfstyle;
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
                pSSFService.autoGet((IEntity)pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFCodeFolder> getPSSFCodeFolders() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeFolders();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        PSSFCodeFolderService pSSFCodeFolderService = (PSSFCodeFolderService)ServiceGlobal.getService(PSSFCodeFolderService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFCodeFoldersLock;
        synchronized (n) {
            if (this.pssfcodefolders == null) {
                this.pssfcodefolders = pSSFCodeFolderService.selectByPSSFStyle(this);
            }
            return this.pssfcodefolders;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFStylePrj> getPSSFStylePrjs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePrjs();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        PSSFStylePrjService pSSFStylePrjService = (PSSFStylePrjService)ServiceGlobal.getService(PSSFStylePrjService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFStylePrjsLock;
        synchronized (n) {
            if (this.pssfstyleprjs == null) {
                this.pssfstyleprjs = pSSFStylePrjService.selectByPSSFStyle(this);
            }
            return this.pssfstyleprjs;
        }
    }

    private PSSFStyleBase getProxyEntity() {
        return this.proxyPSSFStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStyleBase) {
            this.proxyPSSFStyleBase = (PSSFStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLSPKGPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_ENABLEDEPLOYCENTER, 4);
        fieldIndexMap.put(FIELD_ENABLEWSSERVER, 5);
        fieldIndexMap.put(FIELD_LASTESTFLAG, 6);
        fieldIndexMap.put(FIELD_MAINPSSFSTYLEID, 7);
        fieldIndexMap.put(FIELD_MAINPSSFSTYLENAME, 8);
        fieldIndexMap.put(FIELD_MAINSTYLEFLAG, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PKGINHERITMODE, 11);
        fieldIndexMap.put(FIELD_PPSSFSTYLEID, 12);
        fieldIndexMap.put(FIELD_PPSSFSTYLENAME, 13);
        fieldIndexMap.put(FIELD_PRJLIST, 14);
        fieldIndexMap.put(FIELD_PRJTYPE, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 18);
        fieldIndexMap.put(FIELD_PSSFID, 19);
        fieldIndexMap.put(FIELD_PSSFNAME, 20);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 21);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 22);
        fieldIndexMap.put(FIELD_PUBMODE, 23);
        fieldIndexMap.put(FIELD_REFRESHVER, 24);
        fieldIndexMap.put(FIELD_STYLEENGINE, 25);
        fieldIndexMap.put(FIELD_STYLERESURL, 26);
        fieldIndexMap.put(FIELD_TEMPLINFO, 27);
        fieldIndexMap.put(FIELD_TEMPLROOTURL, 28);
        fieldIndexMap.put(FIELD_TEMPLSTATE, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_V2FOLDER, 34);
        fieldIndexMap.put(FIELD_V2FOLDER2, 35);
        fieldIndexMap.put(FIELD_V2GITPATH, 36);
        fieldIndexMap.put(FIELD_VERSION, 37);
        fieldIndexMap.put(FIELD_VERSTR, 38);
        fieldIndexMap.put(FIELD_WORKSHOPNAME, 39);
    }
}

