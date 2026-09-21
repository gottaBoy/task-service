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
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFAppTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleCode;
import net.ibizsys.pscore.srv.config.entity.PSPFStylePkg;
import net.ibizsys.pscore.srv.config.entity.PSPFStylePrj;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleRef;
import net.ibizsys.pscore.srv.config.entity.PSPFViewTempl;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFStylePkgService;
import net.ibizsys.pscore.srv.config.service.PSPFStylePrjService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleRefService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFStyleBase.class);
    public static final String FIELD_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DCSTYLECODE = "DCSTYLECODE";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DYNADEPSTYLEFLAG = "DYNADEPSTYLEFLAG";
    public static final String FIELD_LASTESTFLAG = "LASTESTFLAG";
    public static final String FIELD_LASTIMPTIME = "LASTIMPTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PFSTYLEPARAM = "PFSTYLEPARAM";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_REFRESHVER = "REFRESHVER";
    public static final String FIELD_STYLECODE = "STYLECODE";
    public static final String FIELD_STYLEENGINE = "STYLEENGINE";
    public static final String FIELD_STYLERESURL = "STYLERESURL";
    public static final String FIELD_TEMPLFLAG = "TEMPLFLAG";
    public static final String FIELD_TEMPLINFO = "TEMPLINFO";
    public static final String FIELD_TEMPLPSPFSTYLEID = "TEMPLPSPFSTYLEID";
    public static final String FIELD_TEMPLPSPFSTYLENAME = "TEMPLPSPFSTYLENAME";
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
    private static final int INDEX_CLSPKGPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DCSTYLECODE = 3;
    private static final int INDEX_DEFAULTFLAG = 4;
    private static final int INDEX_DYNADEPSTYLEFLAG = 5;
    private static final int INDEX_LASTESTFLAG = 6;
    private static final int INDEX_LASTIMPTIME = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PFSTYLEPARAM = 9;
    private static final int INDEX_PSAPPTYPEID = 10;
    private static final int INDEX_PSAPPTYPENAME = 11;
    private static final int INDEX_PSDEVCENTERID = 12;
    private static final int INDEX_PSDEVCENTERNAME = 13;
    private static final int INDEX_PSDEVCENTERSVNID = 14;
    private static final int INDEX_PSDEVCENTERSVNNAME = 15;
    private static final int INDEX_PSDEVSLNID = 16;
    private static final int INDEX_PSPFID = 17;
    private static final int INDEX_PSPFNAME = 18;
    private static final int INDEX_PSPFSTYLEID = 19;
    private static final int INDEX_PSPFSTYLENAME = 20;
    private static final int INDEX_PUBMODE = 21;
    private static final int INDEX_REFRESHVER = 22;
    private static final int INDEX_STYLECODE = 23;
    private static final int INDEX_STYLEENGINE = 24;
    private static final int INDEX_STYLERESURL = 25;
    private static final int INDEX_TEMPLFLAG = 26;
    private static final int INDEX_TEMPLINFO = 27;
    private static final int INDEX_TEMPLPSPFSTYLEID = 28;
    private static final int INDEX_TEMPLPSPFSTYLENAME = 29;
    private static final int INDEX_TEMPLROOTURL = 30;
    private static final int INDEX_TEMPLSTATE = 31;
    private static final int INDEX_UPDATEDATE = 32;
    private static final int INDEX_UPDATEMAN = 33;
    private static final int INDEX_USERTAG = 34;
    private static final int INDEX_USERTAG2 = 35;
    private static final int INDEX_V2FOLDER = 36;
    private static final int INDEX_V2FOLDER2 = 37;
    private static final int INDEX_V2GITPATH = 38;
    private static final int INDEX_VERSION = 39;
    private static final int INDEX_VERSTR = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFStyleBase proxyPSPFStyleBase = null;
    private boolean clspkgparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dcstylecodeDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dynadepstyleflagDirtyFlag = false;
    private boolean lastestflagDirtyFlag = false;
    private boolean lastimptimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pfstyleparamDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psapptypenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean refreshverDirtyFlag = false;
    private boolean stylecodeDirtyFlag = false;
    private boolean styleengineDirtyFlag = false;
    private boolean styleresurlDirtyFlag = false;
    private boolean templflagDirtyFlag = false;
    private boolean templinfoDirtyFlag = false;
    private boolean templpspfstyleidDirtyFlag = false;
    private boolean templpspfstylenameDirtyFlag = false;
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
    @Column(name="clspkgparams")
    private String clspkgparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dcstylecode")
    private String dcstylecode;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dynadepstyleflag")
    private Integer dynadepstyleflag;
    @Column(name="lastestflag")
    private Integer lastestflag;
    @Column(name="lastimptime")
    private Timestamp lastimptime;
    @Column(name="memo")
    private String memo;
    @Column(name="pfstyleparam")
    private String pfstyleparam;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psapptypename")
    private String psapptypename;
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
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="refreshver")
    private Integer refreshver;
    @Column(name="stylecode")
    private String stylecode;
    @Column(name="styleengine")
    private String styleengine;
    @Column(name="styleresurl")
    private String styleresurl;
    @Column(name="templflag")
    private Integer templflag;
    @Column(name="templinfo")
    private String templinfo;
    @Column(name="templpspfstyleid")
    private String templpspfstyleid;
    @Column(name="templpspfstylename")
    private String templpspfstylename;
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
    private Integer objPSAppTypeLock = new Integer(1);
    private PSAppType psapptype = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objTemplPSPFStyleLock = new Integer(1);
    private PSPFStyle templpspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSPFAppTemplsLock = new Integer(1);
    private ArrayList<PSPFAppTempl> pspfapptempls = null;
    private Integer objPSPFCtrlTemplsLock = new Integer(1);
    private ArrayList<PSPFCtrlTempl> pspfctrltempls = null;
    private Integer objPSPFEditorTemplsLock = new Integer(1);
    private ArrayList<PSPFEditorTempl> pspfeditortempls = null;
    private Integer objPSPFStyleCodesLock = new Integer(1);
    private ArrayList<PSPFStyleCode> pspfstylecodes = null;
    private Integer objPSPFStylePkgsLock = new Integer(1);
    private ArrayList<PSPFStylePkg> pspfstylepkgs = null;
    private Integer objPSPFStylePrjsLock = new Integer(1);
    private ArrayList<PSPFStylePrj> pspfstyleprjs = null;
    private Integer objPSPFStyleRefsLock = new Integer(1);
    private ArrayList<PSPFStyleRef> pspfstylerefs = null;
    private Integer objPSPFViewTemplsLock = new Integer(1);
    private ArrayList<PSPFViewTempl> pspfviewtempls = null;

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

    public void setDCStyleCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDCStyleCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dcstylecode = string;
        this.dcstylecodeDirtyFlag = true;
    }

    public String getDCStyleCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDCStyleCode();
        }
        return this.dcstylecode;
    }

    public boolean isDCStyleCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDCStyleCodeDirty();
        }
        return this.dcstylecodeDirtyFlag;
    }

    public void resetDCStyleCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDCStyleCode();
            return;
        }
        this.dcstylecodeDirtyFlag = false;
        this.dcstylecode = null;
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

    public void setDynaDepStyleFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaDepStyleFlag(n);
            return;
        }
        this.dynadepstyleflag = n;
        this.dynadepstyleflagDirtyFlag = true;
    }

    public Integer getDynaDepStyleFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaDepStyleFlag();
        }
        return this.dynadepstyleflag;
    }

    public boolean isDynaDepStyleFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaDepStyleFlagDirty();
        }
        return this.dynadepstyleflagDirtyFlag;
    }

    public void resetDynaDepStyleFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaDepStyleFlag();
            return;
        }
        this.dynadepstyleflagDirtyFlag = false;
        this.dynadepstyleflag = null;
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

    public void setLastImpTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastImpTime(timestamp);
            return;
        }
        this.lastimptime = timestamp;
        this.lastimptimeDirtyFlag = true;
    }

    public Timestamp getLastImpTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastImpTime();
        }
        return this.lastimptime;
    }

    public boolean isLastImpTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastImpTimeDirty();
        }
        return this.lastimptimeDirtyFlag;
    }

    public void resetLastImpTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastImpTime();
            return;
        }
        this.lastimptimeDirtyFlag = false;
        this.lastimptime = null;
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

    public void setPFStyleParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPFStyleParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pfstyleparam = string;
        this.pfstyleparamDirtyFlag = true;
    }

    public String getPFStyleParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPFStyleParam();
        }
        return this.pfstyleparam;
    }

    public boolean isPFStyleParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPFStyleParamDirty();
        }
        return this.pfstyleparamDirtyFlag;
    }

    public void resetPFStyleParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPFStyleParam();
            return;
        }
        this.pfstyleparamDirtyFlag = false;
        this.pfstyleparam = null;
    }

    public void setPSAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypeid = string;
        this.psapptypeidDirtyFlag = true;
    }

    public String getPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeId();
        }
        return this.psapptypeid;
    }

    public boolean isPSAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeIdDirty();
        }
        return this.psapptypeidDirtyFlag;
    }

    public void resetPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeId();
            return;
        }
        this.psapptypeidDirtyFlag = false;
        this.psapptypeid = null;
    }

    public void setPSAppTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypename = string;
        this.psapptypenameDirtyFlag = true;
    }

    public String getPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeName();
        }
        return this.psapptypename;
    }

    public boolean isPSAppTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeNameDirty();
        }
        return this.psapptypenameDirtyFlag;
    }

    public void resetPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeName();
            return;
        }
        this.psapptypenameDirtyFlag = false;
        this.psapptypename = null;
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

    public void setTemplFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplFlag(n);
            return;
        }
        this.templflag = n;
        this.templflagDirtyFlag = true;
    }

    public Integer getTemplFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplFlag();
        }
        return this.templflag;
    }

    public boolean isTemplFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplFlagDirty();
        }
        return this.templflagDirtyFlag;
    }

    public void resetTemplFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplFlag();
            return;
        }
        this.templflagDirtyFlag = false;
        this.templflag = null;
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

    protected void onReset() {
        PSPFStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFStyleBase pSPFStyleBase) {
        pSPFStyleBase.resetClsPkgParams();
        pSPFStyleBase.resetCreateDate();
        pSPFStyleBase.resetCreateMan();
        pSPFStyleBase.resetDCStyleCode();
        pSPFStyleBase.resetDefaultFlag();
        pSPFStyleBase.resetDynaDepStyleFlag();
        pSPFStyleBase.resetLastestFlag();
        pSPFStyleBase.resetLastImpTime();
        pSPFStyleBase.resetMemo();
        pSPFStyleBase.resetPFStyleParam();
        pSPFStyleBase.resetPSAppTypeId();
        pSPFStyleBase.resetPSAppTypeName();
        pSPFStyleBase.resetPSDevCenterId();
        pSPFStyleBase.resetPSDevCenterName();
        pSPFStyleBase.resetPSDevCenterSVNId();
        pSPFStyleBase.resetPSDevCenterSVNName();
        pSPFStyleBase.resetPSDevSlnId();
        pSPFStyleBase.resetPSPFId();
        pSPFStyleBase.resetPSPFName();
        pSPFStyleBase.resetPSPFStyleId();
        pSPFStyleBase.resetPSPFStyleName();
        pSPFStyleBase.resetPubMode();
        pSPFStyleBase.resetRefreshVer();
        pSPFStyleBase.resetStyleCode();
        pSPFStyleBase.resetStyleEngine();
        pSPFStyleBase.resetStyleResUrl();
        pSPFStyleBase.resetTemplFlag();
        pSPFStyleBase.resetTemplInfo();
        pSPFStyleBase.resetTemplPSPFStyleId();
        pSPFStyleBase.resetTemplPSPFStyleName();
        pSPFStyleBase.resetTemplRootUrl();
        pSPFStyleBase.resetTemplState();
        pSPFStyleBase.resetUpdateDate();
        pSPFStyleBase.resetUpdateMan();
        pSPFStyleBase.resetUserTag();
        pSPFStyleBase.resetUserTag2();
        pSPFStyleBase.resetV2Folder();
        pSPFStyleBase.resetV2Folder2();
        pSPFStyleBase.resetV2GitPath();
        pSPFStyleBase.resetVersion();
        pSPFStyleBase.resetVerStr();
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
        if (!bl || this.isDCStyleCodeDirty()) {
            hashMap.put(FIELD_DCSTYLECODE, this.getDCStyleCode());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDynaDepStyleFlagDirty()) {
            hashMap.put(FIELD_DYNADEPSTYLEFLAG, this.getDynaDepStyleFlag());
        }
        if (!bl || this.isLastestFlagDirty()) {
            hashMap.put(FIELD_LASTESTFLAG, this.getLastestFlag());
        }
        if (!bl || this.isLastImpTimeDirty()) {
            hashMap.put(FIELD_LASTIMPTIME, this.getLastImpTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPFStyleParamDirty()) {
            hashMap.put(FIELD_PFSTYLEPARAM, this.getPFStyleParam());
        }
        if (!bl || this.isPSAppTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPTYPEID, this.getPSAppTypeId());
        }
        if (!bl || this.isPSAppTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPTYPENAME, this.getPSAppTypeName());
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
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isRefreshVerDirty()) {
            hashMap.put(FIELD_REFRESHVER, this.getRefreshVer());
        }
        if (!bl || this.isStyleCodeDirty()) {
            hashMap.put(FIELD_STYLECODE, this.getStyleCode());
        }
        if (!bl || this.isStyleEngineDirty()) {
            hashMap.put(FIELD_STYLEENGINE, this.getStyleEngine());
        }
        if (!bl || this.isStyleResUrlDirty()) {
            hashMap.put(FIELD_STYLERESURL, this.getStyleResUrl());
        }
        if (!bl || this.isTemplFlagDirty()) {
            hashMap.put(FIELD_TEMPLFLAG, this.getTemplFlag());
        }
        if (!bl || this.isTemplInfoDirty()) {
            hashMap.put(FIELD_TEMPLINFO, this.getTemplInfo());
        }
        if (!bl || this.isTemplPSPFStyleIdDirty()) {
            hashMap.put(FIELD_TEMPLPSPFSTYLEID, this.getTemplPSPFStyleId());
        }
        if (!bl || this.isTemplPSPFStyleNameDirty()) {
            hashMap.put(FIELD_TEMPLPSPFSTYLENAME, this.getTemplPSPFStyleName());
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
        return PSPFStyleBase.get(this, n);
    }

    private static Object get(PSPFStyleBase pSPFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleBase.getClsPkgParams();
            }
            case 1: {
                return pSPFStyleBase.getCreateDate();
            }
            case 2: {
                return pSPFStyleBase.getCreateMan();
            }
            case 3: {
                return pSPFStyleBase.getDCStyleCode();
            }
            case 4: {
                return pSPFStyleBase.getDefaultFlag();
            }
            case 5: {
                return pSPFStyleBase.getDynaDepStyleFlag();
            }
            case 6: {
                return pSPFStyleBase.getLastestFlag();
            }
            case 7: {
                return pSPFStyleBase.getLastImpTime();
            }
            case 8: {
                return pSPFStyleBase.getMemo();
            }
            case 9: {
                return pSPFStyleBase.getPFStyleParam();
            }
            case 10: {
                return pSPFStyleBase.getPSAppTypeId();
            }
            case 11: {
                return pSPFStyleBase.getPSAppTypeName();
            }
            case 12: {
                return pSPFStyleBase.getPSDevCenterId();
            }
            case 13: {
                return pSPFStyleBase.getPSDevCenterName();
            }
            case 14: {
                return pSPFStyleBase.getPSDevCenterSVNId();
            }
            case 15: {
                return pSPFStyleBase.getPSDevCenterSVNName();
            }
            case 16: {
                return pSPFStyleBase.getPSDevSlnId();
            }
            case 17: {
                return pSPFStyleBase.getPSPFId();
            }
            case 18: {
                return pSPFStyleBase.getPSPFName();
            }
            case 19: {
                return pSPFStyleBase.getPSPFStyleId();
            }
            case 20: {
                return pSPFStyleBase.getPSPFStyleName();
            }
            case 21: {
                return pSPFStyleBase.getPubMode();
            }
            case 22: {
                return pSPFStyleBase.getRefreshVer();
            }
            case 23: {
                return pSPFStyleBase.getStyleCode();
            }
            case 24: {
                return pSPFStyleBase.getStyleEngine();
            }
            case 25: {
                return pSPFStyleBase.getStyleResUrl();
            }
            case 26: {
                return pSPFStyleBase.getTemplFlag();
            }
            case 27: {
                return pSPFStyleBase.getTemplInfo();
            }
            case 28: {
                return pSPFStyleBase.getTemplPSPFStyleId();
            }
            case 29: {
                return pSPFStyleBase.getTemplPSPFStyleName();
            }
            case 30: {
                return pSPFStyleBase.getTemplRootUrl();
            }
            case 31: {
                return pSPFStyleBase.getTemplState();
            }
            case 32: {
                return pSPFStyleBase.getUpdateDate();
            }
            case 33: {
                return pSPFStyleBase.getUpdateMan();
            }
            case 34: {
                return pSPFStyleBase.getUserTag();
            }
            case 35: {
                return pSPFStyleBase.getUserTag2();
            }
            case 36: {
                return pSPFStyleBase.getV2Folder();
            }
            case 37: {
                return pSPFStyleBase.getV2Folder2();
            }
            case 38: {
                return pSPFStyleBase.getV2GitPath();
            }
            case 39: {
                return pSPFStyleBase.getVersion();
            }
            case 40: {
                return pSPFStyleBase.getVerStr();
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
        PSPFStyleBase.set(this, n, object);
    }

    private static void set(PSPFStyleBase pSPFStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleBase.setClsPkgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFStyleBase.setDCStyleCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFStyleBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSPFStyleBase.setDynaDepStyleFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSPFStyleBase.setLastestFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSPFStyleBase.setLastImpTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSPFStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFStyleBase.setPFStyleParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFStyleBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFStyleBase.setPSAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFStyleBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFStyleBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFStyleBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFStyleBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFStyleBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFStyleBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFStyleBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFStyleBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPFStyleBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFStyleBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSPFStyleBase.setRefreshVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSPFStyleBase.setStyleCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSPFStyleBase.setStyleEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPFStyleBase.setStyleResUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSPFStyleBase.setTemplFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSPFStyleBase.setTemplInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSPFStyleBase.setTemplPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSPFStyleBase.setTemplPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSPFStyleBase.setTemplRootUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSPFStyleBase.setTemplState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSPFStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSPFStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSPFStyleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSPFStyleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSPFStyleBase.setV2Folder(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSPFStyleBase.setV2Folder2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSPFStyleBase.setV2GitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSPFStyleBase.setVersion(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSPFStyleBase.setVerStr(DataObject.getStringValue((Object)object));
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
        return PSPFStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSPFStyleBase pSPFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleBase.getClsPkgParams() == null;
            }
            case 1: {
                return pSPFStyleBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFStyleBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFStyleBase.getDCStyleCode() == null;
            }
            case 4: {
                return pSPFStyleBase.getDefaultFlag() == null;
            }
            case 5: {
                return pSPFStyleBase.getDynaDepStyleFlag() == null;
            }
            case 6: {
                return pSPFStyleBase.getLastestFlag() == null;
            }
            case 7: {
                return pSPFStyleBase.getLastImpTime() == null;
            }
            case 8: {
                return pSPFStyleBase.getMemo() == null;
            }
            case 9: {
                return pSPFStyleBase.getPFStyleParam() == null;
            }
            case 10: {
                return pSPFStyleBase.getPSAppTypeId() == null;
            }
            case 11: {
                return pSPFStyleBase.getPSAppTypeName() == null;
            }
            case 12: {
                return pSPFStyleBase.getPSDevCenterId() == null;
            }
            case 13: {
                return pSPFStyleBase.getPSDevCenterName() == null;
            }
            case 14: {
                return pSPFStyleBase.getPSDevCenterSVNId() == null;
            }
            case 15: {
                return pSPFStyleBase.getPSDevCenterSVNName() == null;
            }
            case 16: {
                return pSPFStyleBase.getPSDevSlnId() == null;
            }
            case 17: {
                return pSPFStyleBase.getPSPFId() == null;
            }
            case 18: {
                return pSPFStyleBase.getPSPFName() == null;
            }
            case 19: {
                return pSPFStyleBase.getPSPFStyleId() == null;
            }
            case 20: {
                return pSPFStyleBase.getPSPFStyleName() == null;
            }
            case 21: {
                return pSPFStyleBase.getPubMode() == null;
            }
            case 22: {
                return pSPFStyleBase.getRefreshVer() == null;
            }
            case 23: {
                return pSPFStyleBase.getStyleCode() == null;
            }
            case 24: {
                return pSPFStyleBase.getStyleEngine() == null;
            }
            case 25: {
                return pSPFStyleBase.getStyleResUrl() == null;
            }
            case 26: {
                return pSPFStyleBase.getTemplFlag() == null;
            }
            case 27: {
                return pSPFStyleBase.getTemplInfo() == null;
            }
            case 28: {
                return pSPFStyleBase.getTemplPSPFStyleId() == null;
            }
            case 29: {
                return pSPFStyleBase.getTemplPSPFStyleName() == null;
            }
            case 30: {
                return pSPFStyleBase.getTemplRootUrl() == null;
            }
            case 31: {
                return pSPFStyleBase.getTemplState() == null;
            }
            case 32: {
                return pSPFStyleBase.getUpdateDate() == null;
            }
            case 33: {
                return pSPFStyleBase.getUpdateMan() == null;
            }
            case 34: {
                return pSPFStyleBase.getUserTag() == null;
            }
            case 35: {
                return pSPFStyleBase.getUserTag2() == null;
            }
            case 36: {
                return pSPFStyleBase.getV2Folder() == null;
            }
            case 37: {
                return pSPFStyleBase.getV2Folder2() == null;
            }
            case 38: {
                return pSPFStyleBase.getV2GitPath() == null;
            }
            case 39: {
                return pSPFStyleBase.getVersion() == null;
            }
            case 40: {
                return pSPFStyleBase.getVerStr() == null;
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
        return PSPFStyleBase.contains(this, n);
    }

    private static boolean contains(PSPFStyleBase pSPFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleBase.isClsPkgParamsDirty();
            }
            case 1: {
                return pSPFStyleBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFStyleBase.isCreateManDirty();
            }
            case 3: {
                return pSPFStyleBase.isDCStyleCodeDirty();
            }
            case 4: {
                return pSPFStyleBase.isDefaultFlagDirty();
            }
            case 5: {
                return pSPFStyleBase.isDynaDepStyleFlagDirty();
            }
            case 6: {
                return pSPFStyleBase.isLastestFlagDirty();
            }
            case 7: {
                return pSPFStyleBase.isLastImpTimeDirty();
            }
            case 8: {
                return pSPFStyleBase.isMemoDirty();
            }
            case 9: {
                return pSPFStyleBase.isPFStyleParamDirty();
            }
            case 10: {
                return pSPFStyleBase.isPSAppTypeIdDirty();
            }
            case 11: {
                return pSPFStyleBase.isPSAppTypeNameDirty();
            }
            case 12: {
                return pSPFStyleBase.isPSDevCenterIdDirty();
            }
            case 13: {
                return pSPFStyleBase.isPSDevCenterNameDirty();
            }
            case 14: {
                return pSPFStyleBase.isPSDevCenterSVNIdDirty();
            }
            case 15: {
                return pSPFStyleBase.isPSDevCenterSVNNameDirty();
            }
            case 16: {
                return pSPFStyleBase.isPSDevSlnIdDirty();
            }
            case 17: {
                return pSPFStyleBase.isPSPFIdDirty();
            }
            case 18: {
                return pSPFStyleBase.isPSPFNameDirty();
            }
            case 19: {
                return pSPFStyleBase.isPSPFStyleIdDirty();
            }
            case 20: {
                return pSPFStyleBase.isPSPFStyleNameDirty();
            }
            case 21: {
                return pSPFStyleBase.isPubModeDirty();
            }
            case 22: {
                return pSPFStyleBase.isRefreshVerDirty();
            }
            case 23: {
                return pSPFStyleBase.isStyleCodeDirty();
            }
            case 24: {
                return pSPFStyleBase.isStyleEngineDirty();
            }
            case 25: {
                return pSPFStyleBase.isStyleResUrlDirty();
            }
            case 26: {
                return pSPFStyleBase.isTemplFlagDirty();
            }
            case 27: {
                return pSPFStyleBase.isTemplInfoDirty();
            }
            case 28: {
                return pSPFStyleBase.isTemplPSPFStyleIdDirty();
            }
            case 29: {
                return pSPFStyleBase.isTemplPSPFStyleNameDirty();
            }
            case 30: {
                return pSPFStyleBase.isTemplRootUrlDirty();
            }
            case 31: {
                return pSPFStyleBase.isTemplStateDirty();
            }
            case 32: {
                return pSPFStyleBase.isUpdateDateDirty();
            }
            case 33: {
                return pSPFStyleBase.isUpdateManDirty();
            }
            case 34: {
                return pSPFStyleBase.isUserTagDirty();
            }
            case 35: {
                return pSPFStyleBase.isUserTag2Dirty();
            }
            case 36: {
                return pSPFStyleBase.isV2FolderDirty();
            }
            case 37: {
                return pSPFStyleBase.isV2Folder2Dirty();
            }
            case 38: {
                return pSPFStyleBase.isV2GitPathDirty();
            }
            case 39: {
                return pSPFStyleBase.isVersionDirty();
            }
            case 40: {
                return pSPFStyleBase.isVerStrDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFStyleBase pSPFStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFStyleBase.getClsPkgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspkgparams", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getClsPkgParams()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getDCStyleCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dcstylecode", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getDCStyleCode()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getDynaDepStyleFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynadepstyleflag", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getDynaDepStyleFlag()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getLastestFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastestflag", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getLastestFlag()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getLastImpTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastimptime", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getLastImpTime()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPFStyleParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pfstyleparam", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPFStyleParam()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypename", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSAppTypeName()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getPubMode()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getRefreshVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refreshver", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getRefreshVer()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getStyleCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stylecode", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getStyleCode()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getStyleEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleengine", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getStyleEngine()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getStyleResUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleresurl", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getStyleResUrl()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getTemplFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templflag", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getTemplFlag()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getTemplInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templinfo", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getTemplInfo()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getTemplPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpspfstyleid", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getTemplPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getTemplPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templpspfstylename", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getTemplPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getTemplRootUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templrooturl", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getTemplRootUrl()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getTemplState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templstate", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getTemplState()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getV2Folder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2folder", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getV2Folder()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getV2Folder2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2folder2", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getV2Folder2()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getV2GitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2gitpath", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getV2GitPath()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getVersion()), (boolean)false);
        }
        if (bl || pSPFStyleBase.getVerStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verstr", (Object)PSPFStyleBase.getJSONValue((Object)pSPFStyleBase.getVerStr()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFStyleBase pSPFStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFStyleBase.getClsPkgParams() != null) {
            object = pSPFStyleBase.getClsPkgParams();
            xmlNode.setAttribute(FIELD_CLSPKGPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getCreateDate() != null) {
            object = pSPFStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleBase.getCreateMan() != null) {
            object = pSPFStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getDCStyleCode() != null) {
            object = pSPFStyleBase.getDCStyleCode();
            xmlNode.setAttribute(FIELD_DCSTYLECODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getDefaultFlag() != null) {
            object = pSPFStyleBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getDynaDepStyleFlag() != null) {
            object = pSPFStyleBase.getDynaDepStyleFlag();
            xmlNode.setAttribute(FIELD_DYNADEPSTYLEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getLastestFlag() != null) {
            object = pSPFStyleBase.getLastestFlag();
            xmlNode.setAttribute(FIELD_LASTESTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getLastImpTime() != null) {
            object = pSPFStyleBase.getLastImpTime();
            xmlNode.setAttribute(FIELD_LASTIMPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleBase.getMemo() != null) {
            object = pSPFStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPFStyleParam() != null) {
            object = pSPFStyleBase.getPFStyleParam();
            xmlNode.setAttribute(FIELD_PFSTYLEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSAppTypeId() != null) {
            object = pSPFStyleBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSAppTypeName() != null) {
            object = pSPFStyleBase.getPSAppTypeName();
            xmlNode.setAttribute(FIELD_PSAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSDevCenterId() != null) {
            object = pSPFStyleBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSDevCenterName() != null) {
            object = pSPFStyleBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSDevCenterSVNId() != null) {
            object = pSPFStyleBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSDevCenterSVNName() != null) {
            object = pSPFStyleBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSDevSlnId() != null) {
            object = pSPFStyleBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSPFId() != null) {
            object = pSPFStyleBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSPFName() != null) {
            object = pSPFStyleBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSPFStyleId() != null) {
            object = pSPFStyleBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPSPFStyleName() != null) {
            object = pSPFStyleBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getPubMode() != null) {
            object = pSPFStyleBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getRefreshVer() != null) {
            object = pSPFStyleBase.getRefreshVer();
            xmlNode.setAttribute(FIELD_REFRESHVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getStyleCode() != null) {
            object = pSPFStyleBase.getStyleCode();
            xmlNode.setAttribute(FIELD_STYLECODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getStyleEngine() != null) {
            object = pSPFStyleBase.getStyleEngine();
            xmlNode.setAttribute(FIELD_STYLEENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getStyleResUrl() != null) {
            object = pSPFStyleBase.getStyleResUrl();
            xmlNode.setAttribute(FIELD_STYLERESURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getTemplFlag() != null) {
            object = pSPFStyleBase.getTemplFlag();
            xmlNode.setAttribute(FIELD_TEMPLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getTemplInfo() != null) {
            object = pSPFStyleBase.getTemplInfo();
            xmlNode.setAttribute(FIELD_TEMPLINFO, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getTemplPSPFStyleId() != null) {
            object = pSPFStyleBase.getTemplPSPFStyleId();
            xmlNode.setAttribute(FIELD_TEMPLPSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getTemplPSPFStyleName() != null) {
            object = pSPFStyleBase.getTemplPSPFStyleName();
            xmlNode.setAttribute(FIELD_TEMPLPSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getTemplRootUrl() != null) {
            object = pSPFStyleBase.getTemplRootUrl();
            xmlNode.setAttribute(FIELD_TEMPLROOTURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getTemplState() != null) {
            object = pSPFStyleBase.getTemplState();
            xmlNode.setAttribute(FIELD_TEMPLSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getUpdateDate() != null) {
            object = pSPFStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleBase.getUpdateMan() != null) {
            object = pSPFStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getUserTag() != null) {
            object = pSPFStyleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getUserTag2() != null) {
            object = pSPFStyleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getV2Folder() != null) {
            object = pSPFStyleBase.getV2Folder();
            xmlNode.setAttribute(FIELD_V2FOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getV2Folder2() != null) {
            object = pSPFStyleBase.getV2Folder2();
            xmlNode.setAttribute(FIELD_V2FOLDER2, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getV2GitPath() != null) {
            object = pSPFStyleBase.getV2GitPath();
            xmlNode.setAttribute(FIELD_V2GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleBase.getVersion() != null) {
            object = pSPFStyleBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleBase.getVerStr() != null) {
            object = pSPFStyleBase.getVerStr();
            xmlNode.setAttribute(FIELD_VERSTR, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFStyleBase pSPFStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFStyleBase.isClsPkgParamsDirty() && (bl || pSPFStyleBase.getClsPkgParams() != null)) {
            iDataObject.set(FIELD_CLSPKGPARAMS, (Object)pSPFStyleBase.getClsPkgParams());
        }
        if (pSPFStyleBase.isCreateDateDirty() && (bl || pSPFStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFStyleBase.getCreateDate());
        }
        if (pSPFStyleBase.isCreateManDirty() && (bl || pSPFStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFStyleBase.getCreateMan());
        }
        if (pSPFStyleBase.isDCStyleCodeDirty() && (bl || pSPFStyleBase.getDCStyleCode() != null)) {
            iDataObject.set(FIELD_DCSTYLECODE, (Object)pSPFStyleBase.getDCStyleCode());
        }
        if (pSPFStyleBase.isDefaultFlagDirty() && (bl || pSPFStyleBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSPFStyleBase.getDefaultFlag());
        }
        if (pSPFStyleBase.isDynaDepStyleFlagDirty() && (bl || pSPFStyleBase.getDynaDepStyleFlag() != null)) {
            iDataObject.set(FIELD_DYNADEPSTYLEFLAG, (Object)pSPFStyleBase.getDynaDepStyleFlag());
        }
        if (pSPFStyleBase.isLastestFlagDirty() && (bl || pSPFStyleBase.getLastestFlag() != null)) {
            iDataObject.set(FIELD_LASTESTFLAG, (Object)pSPFStyleBase.getLastestFlag());
        }
        if (pSPFStyleBase.isLastImpTimeDirty() && (bl || pSPFStyleBase.getLastImpTime() != null)) {
            iDataObject.set(FIELD_LASTIMPTIME, (Object)pSPFStyleBase.getLastImpTime());
        }
        if (pSPFStyleBase.isMemoDirty() && (bl || pSPFStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFStyleBase.getMemo());
        }
        if (pSPFStyleBase.isPFStyleParamDirty() && (bl || pSPFStyleBase.getPFStyleParam() != null)) {
            iDataObject.set(FIELD_PFSTYLEPARAM, (Object)pSPFStyleBase.getPFStyleParam());
        }
        if (pSPFStyleBase.isPSAppTypeIdDirty() && (bl || pSPFStyleBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSPFStyleBase.getPSAppTypeId());
        }
        if (pSPFStyleBase.isPSAppTypeNameDirty() && (bl || pSPFStyleBase.getPSAppTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPTYPENAME, (Object)pSPFStyleBase.getPSAppTypeName());
        }
        if (pSPFStyleBase.isPSDevCenterIdDirty() && (bl || pSPFStyleBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSPFStyleBase.getPSDevCenterId());
        }
        if (pSPFStyleBase.isPSDevCenterNameDirty() && (bl || pSPFStyleBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSPFStyleBase.getPSDevCenterName());
        }
        if (pSPFStyleBase.isPSDevCenterSVNIdDirty() && (bl || pSPFStyleBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSPFStyleBase.getPSDevCenterSVNId());
        }
        if (pSPFStyleBase.isPSDevCenterSVNNameDirty() && (bl || pSPFStyleBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSPFStyleBase.getPSDevCenterSVNName());
        }
        if (pSPFStyleBase.isPSDevSlnIdDirty() && (bl || pSPFStyleBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSPFStyleBase.getPSDevSlnId());
        }
        if (pSPFStyleBase.isPSPFIdDirty() && (bl || pSPFStyleBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFStyleBase.getPSPFId());
        }
        if (pSPFStyleBase.isPSPFNameDirty() && (bl || pSPFStyleBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFStyleBase.getPSPFName());
        }
        if (pSPFStyleBase.isPSPFStyleIdDirty() && (bl || pSPFStyleBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFStyleBase.getPSPFStyleId());
        }
        if (pSPFStyleBase.isPSPFStyleNameDirty() && (bl || pSPFStyleBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFStyleBase.getPSPFStyleName());
        }
        if (pSPFStyleBase.isPubModeDirty() && (bl || pSPFStyleBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSPFStyleBase.getPubMode());
        }
        if (pSPFStyleBase.isRefreshVerDirty() && (bl || pSPFStyleBase.getRefreshVer() != null)) {
            iDataObject.set(FIELD_REFRESHVER, (Object)pSPFStyleBase.getRefreshVer());
        }
        if (pSPFStyleBase.isStyleCodeDirty() && (bl || pSPFStyleBase.getStyleCode() != null)) {
            iDataObject.set(FIELD_STYLECODE, (Object)pSPFStyleBase.getStyleCode());
        }
        if (pSPFStyleBase.isStyleEngineDirty() && (bl || pSPFStyleBase.getStyleEngine() != null)) {
            iDataObject.set(FIELD_STYLEENGINE, (Object)pSPFStyleBase.getStyleEngine());
        }
        if (pSPFStyleBase.isStyleResUrlDirty() && (bl || pSPFStyleBase.getStyleResUrl() != null)) {
            iDataObject.set(FIELD_STYLERESURL, (Object)pSPFStyleBase.getStyleResUrl());
        }
        if (pSPFStyleBase.isTemplFlagDirty() && (bl || pSPFStyleBase.getTemplFlag() != null)) {
            iDataObject.set(FIELD_TEMPLFLAG, (Object)pSPFStyleBase.getTemplFlag());
        }
        if (pSPFStyleBase.isTemplInfoDirty() && (bl || pSPFStyleBase.getTemplInfo() != null)) {
            iDataObject.set(FIELD_TEMPLINFO, (Object)pSPFStyleBase.getTemplInfo());
        }
        if (pSPFStyleBase.isTemplPSPFStyleIdDirty() && (bl || pSPFStyleBase.getTemplPSPFStyleId() != null)) {
            iDataObject.set(FIELD_TEMPLPSPFSTYLEID, (Object)pSPFStyleBase.getTemplPSPFStyleId());
        }
        if (pSPFStyleBase.isTemplPSPFStyleNameDirty() && (bl || pSPFStyleBase.getTemplPSPFStyleName() != null)) {
            iDataObject.set(FIELD_TEMPLPSPFSTYLENAME, (Object)pSPFStyleBase.getTemplPSPFStyleName());
        }
        if (pSPFStyleBase.isTemplRootUrlDirty() && (bl || pSPFStyleBase.getTemplRootUrl() != null)) {
            iDataObject.set(FIELD_TEMPLROOTURL, (Object)pSPFStyleBase.getTemplRootUrl());
        }
        if (pSPFStyleBase.isTemplStateDirty() && (bl || pSPFStyleBase.getTemplState() != null)) {
            iDataObject.set(FIELD_TEMPLSTATE, (Object)pSPFStyleBase.getTemplState());
        }
        if (pSPFStyleBase.isUpdateDateDirty() && (bl || pSPFStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFStyleBase.getUpdateDate());
        }
        if (pSPFStyleBase.isUpdateManDirty() && (bl || pSPFStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFStyleBase.getUpdateMan());
        }
        if (pSPFStyleBase.isUserTagDirty() && (bl || pSPFStyleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSPFStyleBase.getUserTag());
        }
        if (pSPFStyleBase.isUserTag2Dirty() && (bl || pSPFStyleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSPFStyleBase.getUserTag2());
        }
        if (pSPFStyleBase.isV2FolderDirty() && (bl || pSPFStyleBase.getV2Folder() != null)) {
            iDataObject.set(FIELD_V2FOLDER, (Object)pSPFStyleBase.getV2Folder());
        }
        if (pSPFStyleBase.isV2Folder2Dirty() && (bl || pSPFStyleBase.getV2Folder2() != null)) {
            iDataObject.set(FIELD_V2FOLDER2, (Object)pSPFStyleBase.getV2Folder2());
        }
        if (pSPFStyleBase.isV2GitPathDirty() && (bl || pSPFStyleBase.getV2GitPath() != null)) {
            iDataObject.set(FIELD_V2GITPATH, (Object)pSPFStyleBase.getV2GitPath());
        }
        if (pSPFStyleBase.isVersionDirty() && (bl || pSPFStyleBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSPFStyleBase.getVersion());
        }
        if (pSPFStyleBase.isVerStrDirty() && (bl || pSPFStyleBase.getVerStr() != null)) {
            iDataObject.set(FIELD_VERSTR, (Object)pSPFStyleBase.getVerStr());
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
        return PSPFStyleBase.remove(this, n);
    }

    private static boolean remove(PSPFStyleBase pSPFStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleBase.resetClsPkgParams();
                return true;
            }
            case 1: {
                pSPFStyleBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFStyleBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFStyleBase.resetDCStyleCode();
                return true;
            }
            case 4: {
                pSPFStyleBase.resetDefaultFlag();
                return true;
            }
            case 5: {
                pSPFStyleBase.resetDynaDepStyleFlag();
                return true;
            }
            case 6: {
                pSPFStyleBase.resetLastestFlag();
                return true;
            }
            case 7: {
                pSPFStyleBase.resetLastImpTime();
                return true;
            }
            case 8: {
                pSPFStyleBase.resetMemo();
                return true;
            }
            case 9: {
                pSPFStyleBase.resetPFStyleParam();
                return true;
            }
            case 10: {
                pSPFStyleBase.resetPSAppTypeId();
                return true;
            }
            case 11: {
                pSPFStyleBase.resetPSAppTypeName();
                return true;
            }
            case 12: {
                pSPFStyleBase.resetPSDevCenterId();
                return true;
            }
            case 13: {
                pSPFStyleBase.resetPSDevCenterName();
                return true;
            }
            case 14: {
                pSPFStyleBase.resetPSDevCenterSVNId();
                return true;
            }
            case 15: {
                pSPFStyleBase.resetPSDevCenterSVNName();
                return true;
            }
            case 16: {
                pSPFStyleBase.resetPSDevSlnId();
                return true;
            }
            case 17: {
                pSPFStyleBase.resetPSPFId();
                return true;
            }
            case 18: {
                pSPFStyleBase.resetPSPFName();
                return true;
            }
            case 19: {
                pSPFStyleBase.resetPSPFStyleId();
                return true;
            }
            case 20: {
                pSPFStyleBase.resetPSPFStyleName();
                return true;
            }
            case 21: {
                pSPFStyleBase.resetPubMode();
                return true;
            }
            case 22: {
                pSPFStyleBase.resetRefreshVer();
                return true;
            }
            case 23: {
                pSPFStyleBase.resetStyleCode();
                return true;
            }
            case 24: {
                pSPFStyleBase.resetStyleEngine();
                return true;
            }
            case 25: {
                pSPFStyleBase.resetStyleResUrl();
                return true;
            }
            case 26: {
                pSPFStyleBase.resetTemplFlag();
                return true;
            }
            case 27: {
                pSPFStyleBase.resetTemplInfo();
                return true;
            }
            case 28: {
                pSPFStyleBase.resetTemplPSPFStyleId();
                return true;
            }
            case 29: {
                pSPFStyleBase.resetTemplPSPFStyleName();
                return true;
            }
            case 30: {
                pSPFStyleBase.resetTemplRootUrl();
                return true;
            }
            case 31: {
                pSPFStyleBase.resetTemplState();
                return true;
            }
            case 32: {
                pSPFStyleBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSPFStyleBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSPFStyleBase.resetUserTag();
                return true;
            }
            case 35: {
                pSPFStyleBase.resetUserTag2();
                return true;
            }
            case 36: {
                pSPFStyleBase.resetV2Folder();
                return true;
            }
            case 37: {
                pSPFStyleBase.resetV2Folder2();
                return true;
            }
            case 38: {
                pSPFStyleBase.resetV2GitPath();
                return true;
            }
            case 39: {
                pSPFStyleBase.resetVersion();
                return true;
            }
            case 40: {
                pSPFStyleBase.resetVerStr();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppType getPSAppType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppType();
        }
        if (this.getPSAppTypeId() == null) {
            return null;
        }
        Integer n = this.objPSAppTypeLock;
        synchronized (n) {
            if (this.psapptype != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppTypeId(), (Object)this.psapptype.getPSAppTypeId()) != 0L) {
                this.psapptype = null;
            }
            if (this.psapptype == null) {
                PSAppType pSAppType = new PSAppType();
                pSAppType.setPSAppTypeId(this.getPSAppTypeId());
                PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
                pSAppTypeService.autoGet((IEntity)pSAppType);
                this.psapptype = pSAppType;
            }
            return this.psapptype;
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
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
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
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
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
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFAppTempl> getPSPFAppTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFAppTempls();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFAppTemplService pSPFAppTemplService = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFAppTemplsLock;
        synchronized (n) {
            if (this.pspfapptempls == null) {
                this.pspfapptempls = pSPFAppTemplService.selectByPSPFStyle(this);
            }
            return this.pspfapptempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFCtrlTempl> getPSPFCtrlTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTempls();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFCtrlTemplService pSPFCtrlTemplService = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFCtrlTemplsLock;
        synchronized (n) {
            if (this.pspfctrltempls == null) {
                this.pspfctrltempls = pSPFCtrlTemplService.selectByPSPFStyle(this);
            }
            return this.pspfctrltempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFEditorTempl> getPSPFEditorTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFEditorTempls();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFEditorTemplService pSPFEditorTemplService = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFEditorTemplsLock;
        synchronized (n) {
            if (this.pspfeditortempls == null) {
                this.pspfeditortempls = pSPFEditorTemplService.selectByPSPFStyle(this);
            }
            return this.pspfeditortempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFStyleCode> getPSPFStyleCodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleCodes();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFStyleCodeService pSPFStyleCodeService = (PSPFStyleCodeService)ServiceGlobal.getService(PSPFStyleCodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFStyleCodesLock;
        synchronized (n) {
            if (this.pspfstylecodes == null) {
                this.pspfstylecodes = pSPFStyleCodeService.selectByPSPFStyle(this);
            }
            return this.pspfstylecodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFStylePkg> getPSPFStylePkgs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStylePkgs();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFStylePkgService pSPFStylePkgService = (PSPFStylePkgService)ServiceGlobal.getService(PSPFStylePkgService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFStylePkgsLock;
        synchronized (n) {
            if (this.pspfstylepkgs == null) {
                this.pspfstylepkgs = pSPFStylePkgService.selectByPSPFStyle(this);
            }
            return this.pspfstylepkgs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFStylePrj> getPSPFStylePrjs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStylePrjs();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFStylePrjService pSPFStylePrjService = (PSPFStylePrjService)ServiceGlobal.getService(PSPFStylePrjService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFStylePrjsLock;
        synchronized (n) {
            if (this.pspfstyleprjs == null) {
                this.pspfstyleprjs = pSPFStylePrjService.selectByPSPFStyle(this);
            }
            return this.pspfstyleprjs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFStyleRef> getPSPFStyleRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleRefs();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFStyleRefService pSPFStyleRefService = (PSPFStyleRefService)ServiceGlobal.getService(PSPFStyleRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFStyleRefsLock;
        synchronized (n) {
            if (this.pspfstylerefs == null) {
                this.pspfstylerefs = pSPFStyleRefService.selectByPSPFStyle(this);
            }
            return this.pspfstylerefs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFViewTempl> getPSPFViewTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFViewTempls();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        PSPFViewTemplService pSPFViewTemplService = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFViewTemplsLock;
        synchronized (n) {
            if (this.pspfviewtempls == null) {
                this.pspfviewtempls = pSPFViewTemplService.selectByPSPFStyle(this);
            }
            return this.pspfviewtempls;
        }
    }

    private PSPFStyleBase getProxyEntity() {
        return this.proxyPSPFStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFStyleBase) {
            this.proxyPSPFStyleBase = (PSPFStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLSPKGPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DCSTYLECODE, 3);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 4);
        fieldIndexMap.put(FIELD_DYNADEPSTYLEFLAG, 5);
        fieldIndexMap.put(FIELD_LASTESTFLAG, 6);
        fieldIndexMap.put(FIELD_LASTIMPTIME, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PFSTYLEPARAM, 9);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 10);
        fieldIndexMap.put(FIELD_PSAPPTYPENAME, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 16);
        fieldIndexMap.put(FIELD_PSPFID, 17);
        fieldIndexMap.put(FIELD_PSPFNAME, 18);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 19);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 20);
        fieldIndexMap.put(FIELD_PUBMODE, 21);
        fieldIndexMap.put(FIELD_REFRESHVER, 22);
        fieldIndexMap.put(FIELD_STYLECODE, 23);
        fieldIndexMap.put(FIELD_STYLEENGINE, 24);
        fieldIndexMap.put(FIELD_STYLERESURL, 25);
        fieldIndexMap.put(FIELD_TEMPLFLAG, 26);
        fieldIndexMap.put(FIELD_TEMPLINFO, 27);
        fieldIndexMap.put(FIELD_TEMPLPSPFSTYLEID, 28);
        fieldIndexMap.put(FIELD_TEMPLPSPFSTYLENAME, 29);
        fieldIndexMap.put(FIELD_TEMPLROOTURL, 30);
        fieldIndexMap.put(FIELD_TEMPLSTATE, 31);
        fieldIndexMap.put(FIELD_UPDATEDATE, 32);
        fieldIndexMap.put(FIELD_UPDATEMAN, 33);
        fieldIndexMap.put(FIELD_USERTAG, 34);
        fieldIndexMap.put(FIELD_USERTAG2, 35);
        fieldIndexMap.put(FIELD_V2FOLDER, 36);
        fieldIndexMap.put(FIELD_V2FOLDER2, 37);
        fieldIndexMap.put(FIELD_V2GITPATH, 38);
        fieldIndexMap.put(FIELD_VERSION, 39);
        fieldIndexMap.put(FIELD_VERSTR, 40);
    }
}

