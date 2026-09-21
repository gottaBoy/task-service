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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSubApp;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSPDTAppFunc;
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubAppView;
import net.ibizsys.pscore.srv.config.service.PSPDTAppFuncService;
import net.ibizsys.pscore.srv.config.service.PSSubAppService;
import net.ibizsys.pscore.srv.config.service.PSSubAppViewService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppFuncBase.class);
    public static final String FIELD_APPFUNCTYPE = "APPFUNCTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAINSTTAG = "DYNAINSTTAG";
    public static final String FIELD_DYNAINSTTAG2 = "DYNAINSTTAG2";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_FROMOBJID = "FROMOBJID";
    public static final String FIELD_FUNCSN = "FUNCSN";
    public static final String FIELD_JSCODE = "JSCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String FIELD_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String FIELD_OPENMODE = "OPENMODE";
    public static final String FIELD_OPENVIEWPARAM = "OPENVIEWPARAM";
    public static final String FIELD_PAGEURL = "PAGEURL";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String FIELD_PSAPPFUNCID = "PSAPPFUNCID";
    public static final String FIELD_PSAPPFUNCNAME = "PSAPPFUNCNAME";
    public static final String FIELD_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String FIELD_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String FIELD_PSAPPSUBAPPID = "PSAPPSUBAPPID";
    public static final String FIELD_PSAPPSUBAPPNAME = "PSAPPSUBAPPNAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDEACMODEID = "PSDEACMODEID";
    public static final String FIELD_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDYNAAPPID = "PSDYNAAPPID";
    public static final String FIELD_PSDYNAAPPNAME = "PSDYNAAPPNAME";
    public static final String FIELD_PSPDTAPPFUNCID = "PSPDTAPPFUNCID";
    public static final String FIELD_PSPDTAPPFUNCNAME = "PSPDTAPPFUNCNAME";
    public static final String FIELD_PSSUBAPPID = "PSSUBAPPID";
    public static final String FIELD_PSSUBAPPNAME = "PSSUBAPPNAME";
    public static final String FIELD_PSSUBAPPVIEWID = "PSSUBAPPVIEWID";
    public static final String FIELD_PSSUBAPPVIEWNAME = "PSSUBAPPVIEWNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_APPFUNCTYPE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DYNAINSTTAG = 4;
    private static final int INDEX_DYNAINSTTAG2 = 5;
    private static final int INDEX_DYNAMODELFLAG = 6;
    private static final int INDEX_FROMOBJID = 7;
    private static final int INDEX_FUNCSN = 8;
    private static final int INDEX_JSCODE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_NAMEPSLANRESID = 11;
    private static final int INDEX_NAMEPSLANRESNAME = 12;
    private static final int INDEX_OPENMODE = 13;
    private static final int INDEX_OPENVIEWPARAM = 14;
    private static final int INDEX_PAGEURL = 15;
    private static final int INDEX_PREDEFINEDTYPE = 16;
    private static final int INDEX_PREDEFINEDTYPEPARAM = 17;
    private static final int INDEX_PSAPPFUNCID = 18;
    private static final int INDEX_PSAPPFUNCNAME = 19;
    private static final int INDEX_PSAPPLOCALDEID = 20;
    private static final int INDEX_PSAPPLOCALDENAME = 21;
    private static final int INDEX_PSAPPSUBAPPID = 22;
    private static final int INDEX_PSAPPSUBAPPNAME = 23;
    private static final int INDEX_PSAPPVIEWID = 24;
    private static final int INDEX_PSAPPVIEWNAME = 25;
    private static final int INDEX_PSDEACMODEID = 26;
    private static final int INDEX_PSDEACMODENAME = 27;
    private static final int INDEX_PSDEID = 28;
    private static final int INDEX_PSDEUIACTIONID = 29;
    private static final int INDEX_PSDEUIACTIONNAME = 30;
    private static final int INDEX_PSDYNAAPPID = 31;
    private static final int INDEX_PSDYNAAPPNAME = 32;
    private static final int INDEX_PSPDTAPPFUNCID = 33;
    private static final int INDEX_PSPDTAPPFUNCNAME = 34;
    private static final int INDEX_PSSUBAPPID = 35;
    private static final int INDEX_PSSUBAPPNAME = 36;
    private static final int INDEX_PSSUBAPPVIEWID = 37;
    private static final int INDEX_PSSUBAPPVIEWNAME = 38;
    private static final int INDEX_PSSYSAPPID = 39;
    private static final int INDEX_PSSYSAPPNAME = 40;
    private static final int INDEX_PSSYSREQITEMID = 41;
    private static final int INDEX_PSSYSREQITEMNAME = 42;
    private static final int INDEX_SYSTEMFLAG = 43;
    private static final int INDEX_TIPPSLANRESID = 44;
    private static final int INDEX_TIPPSLANRESNAME = 45;
    private static final int INDEX_TOOLTIPINFO = 46;
    private static final int INDEX_UPDATEDATE = 47;
    private static final int INDEX_UPDATEMAN = 48;
    private static final int INDEX_USERCAT = 49;
    private static final int INDEX_USERDATA = 50;
    private static final int INDEX_USERDATA2 = 51;
    private static final int INDEX_USERPARAMS = 52;
    private static final int INDEX_USERTAG = 53;
    private static final int INDEX_USERTAG2 = 54;
    private static final int INDEX_USERTAG3 = 55;
    private static final int INDEX_USERTAG4 = 56;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppFuncBase proxyPSAppFuncBase = null;
    private boolean appfunctypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynainsttagDirtyFlag = false;
    private boolean dynainsttag2DirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean fromobjidDirtyFlag = false;
    private boolean funcsnDirtyFlag = false;
    private boolean jscodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namepslanresidDirtyFlag = false;
    private boolean namepslanresnameDirtyFlag = false;
    private boolean openmodeDirtyFlag = false;
    private boolean openviewparamDirtyFlag = false;
    private boolean pageurlDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypeparamDirtyFlag = false;
    private boolean psappfuncidDirtyFlag = false;
    private boolean psappfuncnameDirtyFlag = false;
    private boolean psapplocaldeidDirtyFlag = false;
    private boolean psapplocaldenameDirtyFlag = false;
    private boolean psappsubappidDirtyFlag = false;
    private boolean psappsubappnameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdeacmodeidDirtyFlag = false;
    private boolean psdeacmodenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdynaappidDirtyFlag = false;
    private boolean psdynaappnameDirtyFlag = false;
    private boolean pspdtappfuncidDirtyFlag = false;
    private boolean pspdtappfuncnameDirtyFlag = false;
    private boolean pssubappidDirtyFlag = false;
    private boolean pssubappnameDirtyFlag = false;
    private boolean pssubappviewidDirtyFlag = false;
    private boolean pssubappviewnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean systemflagDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="appfunctype")
    private String appfunctype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynainsttag")
    private String dynainsttag;
    @Column(name="dynainsttag2")
    private String dynainsttag2;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="fromobjid")
    private String fromobjid;
    @Column(name="funcsn")
    private String funcsn;
    @Column(name="jscode")
    private String jscode;
    @Column(name="memo")
    private String memo;
    @Column(name="namepslanresid")
    private String namepslanresid;
    @Column(name="namepslanresname")
    private String namepslanresname;
    @Column(name="openmode")
    private String openmode;
    @Column(name="openviewparam")
    private String openviewparam;
    @Column(name="pageurl")
    private String pageurl;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypeparam")
    private String predefinedtypeparam;
    @Column(name="psappfuncid")
    private String psappfuncid;
    @Column(name="psappfuncname")
    private String psappfuncname;
    @Column(name="psapplocaldeid")
    private String psapplocaldeid;
    @Column(name="psapplocaldename")
    private String psapplocaldename;
    @Column(name="psappsubappid")
    private String psappsubappid;
    @Column(name="psappsubappname")
    private String psappsubappname;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdeacmodeid")
    private String psdeacmodeid;
    @Column(name="psdeacmodename")
    private String psdeacmodename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="psdynaappid")
    private String psdynaappid;
    @Column(name="psdynaappname")
    private String psdynaappname;
    @Column(name="pspdtappfuncid")
    private String pspdtappfuncid;
    @Column(name="pspdtappfuncname")
    private String pspdtappfuncname;
    @Column(name="pssubappid")
    private String pssubappid;
    @Column(name="pssubappname")
    private String pssubappname;
    @Column(name="pssubappviewid")
    private String pssubappviewid;
    @Column(name="pssubappviewname")
    private String pssubappviewname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="systemflag")
    private Integer systemflag;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
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
    private Integer objPSAppLocalDELock = new Integer(1);
    private PSAppLocalDE psapplocalde = null;
    private Integer objPSAppSubAppLock = new Integer(1);
    private PSAppSubApp psappsubapp = null;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSDEACModeLock = new Integer(1);
    private PSDEACMode psdeacmode = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objPSDynaAppLock = new Integer(1);
    private PSDynaApp psdynaapp = null;
    private Integer objNamePSLanResLock = new Integer(1);
    private PSLanguageRes namepslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSPDTAppFuncLock = new Integer(1);
    private PSPDTAppFunc pspdtappfunc = null;
    private Integer objPSSubAppViewLock = new Integer(1);
    private PSSubAppView pssubappview = null;
    private Integer objPSSubAppLock = new Integer(1);
    private PSSubApp pssubapp = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;

    public void setAppFuncType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppFuncType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appfunctype = string;
        this.appfunctypeDirtyFlag = true;
    }

    public String getAppFuncType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppFuncType();
        }
        return this.appfunctype;
    }

    public boolean isAppFuncTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppFuncTypeDirty();
        }
        return this.appfunctypeDirtyFlag;
    }

    public void resetAppFuncType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppFuncType();
            return;
        }
        this.appfunctypeDirtyFlag = false;
        this.appfunctype = null;
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

    public void setDynaInstTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynainsttag = string;
        this.dynainsttagDirtyFlag = true;
    }

    public String getDynaInstTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstTag();
        }
        return this.dynainsttag;
    }

    public boolean isDynaInstTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstTagDirty();
        }
        return this.dynainsttagDirtyFlag;
    }

    public void resetDynaInstTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstTag();
            return;
        }
        this.dynainsttagDirtyFlag = false;
        this.dynainsttag = null;
    }

    public void setDynaInstTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaInstTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynainsttag2 = string;
        this.dynainsttag2DirtyFlag = true;
    }

    public String getDynaInstTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaInstTag2();
        }
        return this.dynainsttag2;
    }

    public boolean isDynaInstTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaInstTag2Dirty();
        }
        return this.dynainsttag2DirtyFlag;
    }

    public void resetDynaInstTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaInstTag2();
            return;
        }
        this.dynainsttag2DirtyFlag = false;
        this.dynainsttag2 = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setFromObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fromobjid = string;
        this.fromobjidDirtyFlag = true;
    }

    public String getFromObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromObjId();
        }
        return this.fromobjid;
    }

    public boolean isFromObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromObjIdDirty();
        }
        return this.fromobjidDirtyFlag;
    }

    public void resetFromObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromObjId();
            return;
        }
        this.fromobjidDirtyFlag = false;
        this.fromobjid = null;
    }

    public void setFuncSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcsn = string;
        this.funcsnDirtyFlag = true;
    }

    public String getFuncSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncSN();
        }
        return this.funcsn;
    }

    public boolean isFuncSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncSNDirty();
        }
        return this.funcsnDirtyFlag;
    }

    public void resetFuncSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncSN();
            return;
        }
        this.funcsnDirtyFlag = false;
        this.funcsn = null;
    }

    public void setJSCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJSCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jscode = string;
        this.jscodeDirtyFlag = true;
    }

    public String getJSCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJSCode();
        }
        return this.jscode;
    }

    public boolean isJSCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJSCodeDirty();
        }
        return this.jscodeDirtyFlag;
    }

    public void resetJSCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJSCode();
            return;
        }
        this.jscodeDirtyFlag = false;
        this.jscode = null;
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

    public void setNamePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresid = string;
        this.namepslanresidDirtyFlag = true;
    }

    public String getNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResId();
        }
        return this.namepslanresid;
    }

    public boolean isNamePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResIdDirty();
        }
        return this.namepslanresidDirtyFlag;
    }

    public void resetNamePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResId();
            return;
        }
        this.namepslanresidDirtyFlag = false;
        this.namepslanresid = null;
    }

    public void setNamePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepslanresname = string;
        this.namepslanresnameDirtyFlag = true;
    }

    public String getNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanResName();
        }
        return this.namepslanresname;
    }

    public boolean isNamePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSLanResNameDirty();
        }
        return this.namepslanresnameDirtyFlag;
    }

    public void resetNamePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSLanResName();
            return;
        }
        this.namepslanresnameDirtyFlag = false;
        this.namepslanresname = null;
    }

    public void setOpenMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openmode = string;
        this.openmodeDirtyFlag = true;
    }

    public String getOpenMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenMode();
        }
        return this.openmode;
    }

    public boolean isOpenModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenModeDirty();
        }
        return this.openmodeDirtyFlag;
    }

    public void resetOpenMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenMode();
            return;
        }
        this.openmodeDirtyFlag = false;
        this.openmode = null;
    }

    public void setOpenViewParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenViewParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openviewparam = string;
        this.openviewparamDirtyFlag = true;
    }

    public String getOpenViewParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenViewParam();
        }
        return this.openviewparam;
    }

    public boolean isOpenViewParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenViewParamDirty();
        }
        return this.openviewparamDirtyFlag;
    }

    public void resetOpenViewParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenViewParam();
            return;
        }
        this.openviewparamDirtyFlag = false;
        this.openviewparam = null;
    }

    public void setPageUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPageUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pageurl = string;
        this.pageurlDirtyFlag = true;
    }

    public String getPageUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPageUrl();
        }
        return this.pageurl;
    }

    public boolean isPageUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPageUrlDirty();
        }
        return this.pageurlDirtyFlag;
    }

    public void resetPageUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPageUrl();
            return;
        }
        this.pageurlDirtyFlag = false;
        this.pageurl = null;
    }

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPredefinedTypeParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypeparam = string;
        this.predefinedtypeparamDirtyFlag = true;
    }

    public String getPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeParam();
        }
        return this.predefinedtypeparam;
    }

    public boolean isPredefinedTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeParamDirty();
        }
        return this.predefinedtypeparamDirtyFlag;
    }

    public void resetPredefinedTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeParam();
            return;
        }
        this.predefinedtypeparamDirtyFlag = false;
        this.predefinedtypeparam = null;
    }

    public void setPSAppFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfuncid = string;
        this.psappfuncidDirtyFlag = true;
    }

    public String getPSAppFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncId();
        }
        return this.psappfuncid;
    }

    public boolean isPSAppFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncIdDirty();
        }
        return this.psappfuncidDirtyFlag;
    }

    public void resetPSAppFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncId();
            return;
        }
        this.psappfuncidDirtyFlag = false;
        this.psappfuncid = null;
    }

    public void setPSAppFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappfuncname = string;
        this.psappfuncnameDirtyFlag = true;
    }

    public String getPSAppFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppFuncName();
        }
        return this.psappfuncname;
    }

    public boolean isPSAppFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppFuncNameDirty();
        }
        return this.psappfuncnameDirtyFlag;
    }

    public void resetPSAppFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppFuncName();
            return;
        }
        this.psappfuncnameDirtyFlag = false;
        this.psappfuncname = null;
    }

    public void setPSAppLocalDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldeid = string;
        this.psapplocaldeidDirtyFlag = true;
    }

    public String getPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEId();
        }
        return this.psapplocaldeid;
    }

    public boolean isPSAppLocalDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDEIdDirty();
        }
        return this.psapplocaldeidDirtyFlag;
    }

    public void resetPSAppLocalDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEId();
            return;
        }
        this.psapplocaldeidDirtyFlag = false;
        this.psapplocaldeid = null;
    }

    public void setPSAppLocalDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppLocalDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapplocaldename = string;
        this.psapplocaldenameDirtyFlag = true;
    }

    public String getPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDEName();
        }
        return this.psapplocaldename;
    }

    public boolean isPSAppLocalDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppLocalDENameDirty();
        }
        return this.psapplocaldenameDirtyFlag;
    }

    public void resetPSAppLocalDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppLocalDEName();
            return;
        }
        this.psapplocaldenameDirtyFlag = false;
        this.psapplocaldename = null;
    }

    public void setPSAppSubAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSubAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsubappid = string;
        this.psappsubappidDirtyFlag = true;
    }

    public String getPSAppSubAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSubAppId();
        }
        return this.psappsubappid;
    }

    public boolean isPSAppSubAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSubAppIdDirty();
        }
        return this.psappsubappidDirtyFlag;
    }

    public void resetPSAppSubAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSubAppId();
            return;
        }
        this.psappsubappidDirtyFlag = false;
        this.psappsubappid = null;
    }

    public void setPSAppSubAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSubAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsubappname = string;
        this.psappsubappnameDirtyFlag = true;
    }

    public String getPSAppSubAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSubAppName();
        }
        return this.psappsubappname;
    }

    public boolean isPSAppSubAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSubAppNameDirty();
        }
        return this.psappsubappnameDirtyFlag;
    }

    public void resetPSAppSubAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSubAppName();
            return;
        }
        this.psappsubappnameDirtyFlag = false;
        this.psappsubappname = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSDEACModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodeid = string;
        this.psdeacmodeidDirtyFlag = true;
    }

    public String getPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeId();
        }
        return this.psdeacmodeid;
    }

    public boolean isPSDEACModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeIdDirty();
        }
        return this.psdeacmodeidDirtyFlag;
    }

    public void resetPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeId();
            return;
        }
        this.psdeacmodeidDirtyFlag = false;
        this.psdeacmodeid = null;
    }

    public void setPSDEACModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodename = string;
        this.psdeacmodenameDirtyFlag = true;
    }

    public String getPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeName();
        }
        return this.psdeacmodename;
    }

    public boolean isPSDEACModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeNameDirty();
        }
        return this.psdeacmodenameDirtyFlag;
    }

    public void resetPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeName();
            return;
        }
        this.psdeacmodenameDirtyFlag = false;
        this.psdeacmodename = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
    }

    public void setPSDynaAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappid = string;
        this.psdynaappidDirtyFlag = true;
    }

    public String getPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppId();
        }
        return this.psdynaappid;
    }

    public boolean isPSDynaAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppIdDirty();
        }
        return this.psdynaappidDirtyFlag;
    }

    public void resetPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppId();
            return;
        }
        this.psdynaappidDirtyFlag = false;
        this.psdynaappid = null;
    }

    public void setPSDynaAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappname = string;
        this.psdynaappnameDirtyFlag = true;
    }

    public String getPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppName();
        }
        return this.psdynaappname;
    }

    public boolean isPSDynaAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppNameDirty();
        }
        return this.psdynaappnameDirtyFlag;
    }

    public void resetPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppName();
            return;
        }
        this.psdynaappnameDirtyFlag = false;
        this.psdynaappname = null;
    }

    public void setPSPDTAppFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTAppFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtappfuncid = string;
        this.pspdtappfuncidDirtyFlag = true;
    }

    public String getPSPDTAppFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTAppFuncId();
        }
        return this.pspdtappfuncid;
    }

    public boolean isPSPDTAppFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTAppFuncIdDirty();
        }
        return this.pspdtappfuncidDirtyFlag;
    }

    public void resetPSPDTAppFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTAppFuncId();
            return;
        }
        this.pspdtappfuncidDirtyFlag = false;
        this.pspdtappfuncid = null;
    }

    public void setPSPDTAppFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTAppFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtappfuncname = string;
        this.pspdtappfuncnameDirtyFlag = true;
    }

    public String getPSPDTAppFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTAppFuncName();
        }
        return this.pspdtappfuncname;
    }

    public boolean isPSPDTAppFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTAppFuncNameDirty();
        }
        return this.pspdtappfuncnameDirtyFlag;
    }

    public void resetPSPDTAppFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTAppFuncName();
            return;
        }
        this.pspdtappfuncnameDirtyFlag = false;
        this.pspdtappfuncname = null;
    }

    public void setPSSubAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappid = string;
        this.pssubappidDirtyFlag = true;
    }

    public String getPSSubAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppId();
        }
        return this.pssubappid;
    }

    public boolean isPSSubAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppIdDirty();
        }
        return this.pssubappidDirtyFlag;
    }

    public void resetPSSubAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppId();
            return;
        }
        this.pssubappidDirtyFlag = false;
        this.pssubappid = null;
    }

    public void setPSSubAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappname = string;
        this.pssubappnameDirtyFlag = true;
    }

    public String getPSSubAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppName();
        }
        return this.pssubappname;
    }

    public boolean isPSSubAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppNameDirty();
        }
        return this.pssubappnameDirtyFlag;
    }

    public void resetPSSubAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppName();
            return;
        }
        this.pssubappnameDirtyFlag = false;
        this.pssubappname = null;
    }

    public void setPSSubAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappviewid = string;
        this.pssubappviewidDirtyFlag = true;
    }

    public String getPSSubAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppViewId();
        }
        return this.pssubappviewid;
    }

    public boolean isPSSubAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppViewIdDirty();
        }
        return this.pssubappviewidDirtyFlag;
    }

    public void resetPSSubAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppViewId();
            return;
        }
        this.pssubappviewidDirtyFlag = false;
        this.pssubappviewid = null;
    }

    public void setPSSubAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappviewname = string;
        this.pssubappviewnameDirtyFlag = true;
    }

    public String getPSSubAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppViewName();
        }
        return this.pssubappviewname;
    }

    public boolean isPSSubAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppViewNameDirty();
        }
        return this.pssubappviewnameDirtyFlag;
    }

    public void resetPSSubAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppViewName();
            return;
        }
        this.pssubappviewnameDirtyFlag = false;
        this.pssubappviewname = null;
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

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setSystemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemFlag(n);
            return;
        }
        this.systemflag = n;
        this.systemflagDirtyFlag = true;
    }

    public Integer getSystemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemFlag();
        }
        return this.systemflag;
    }

    public boolean isSystemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemFlagDirty();
        }
        return this.systemflagDirtyFlag;
    }

    public void resetSystemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemFlag();
            return;
        }
        this.systemflagDirtyFlag = false;
        this.systemflag = null;
    }

    public void setTipPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresid = string;
        this.tippslanresidDirtyFlag = true;
    }

    public String getTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResId();
        }
        return this.tippslanresid;
    }

    public boolean isTipPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResIdDirty();
        }
        return this.tippslanresidDirtyFlag;
    }

    public void resetTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResId();
            return;
        }
        this.tippslanresidDirtyFlag = false;
        this.tippslanresid = null;
    }

    public void setTipPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresname = string;
        this.tippslanresnameDirtyFlag = true;
    }

    public String getTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResName();
        }
        return this.tippslanresname;
    }

    public boolean isTipPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResNameDirty();
        }
        return this.tippslanresnameDirtyFlag;
    }

    public void resetTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResName();
            return;
        }
        this.tippslanresnameDirtyFlag = false;
        this.tippslanresname = null;
    }

    public void setTooltipInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTooltipInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltipinfo = string;
        this.tooltipinfoDirtyFlag = true;
    }

    public String getTooltipInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTooltipInfo();
        }
        return this.tooltipinfo;
    }

    public boolean isTooltipInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTooltipInfoDirty();
        }
        return this.tooltipinfoDirtyFlag;
    }

    public void resetTooltipInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTooltipInfo();
            return;
        }
        this.tooltipinfoDirtyFlag = false;
        this.tooltipinfo = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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

    protected void onReset() {
        PSAppFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppFuncBase pSAppFuncBase) {
        pSAppFuncBase.resetAppFuncType();
        pSAppFuncBase.resetCodeName();
        pSAppFuncBase.resetCreateDate();
        pSAppFuncBase.resetCreateMan();
        pSAppFuncBase.resetDynaInstTag();
        pSAppFuncBase.resetDynaInstTag2();
        pSAppFuncBase.resetDynaModelFlag();
        pSAppFuncBase.resetFromObjId();
        pSAppFuncBase.resetFuncSN();
        pSAppFuncBase.resetJSCode();
        pSAppFuncBase.resetMemo();
        pSAppFuncBase.resetNamePSLanResId();
        pSAppFuncBase.resetNamePSLanResName();
        pSAppFuncBase.resetOpenMode();
        pSAppFuncBase.resetOpenViewParam();
        pSAppFuncBase.resetPageUrl();
        pSAppFuncBase.resetPredefinedType();
        pSAppFuncBase.resetPredefinedTypeParam();
        pSAppFuncBase.resetPSAppFuncId();
        pSAppFuncBase.resetPSAppFuncName();
        pSAppFuncBase.resetPSAppLocalDEId();
        pSAppFuncBase.resetPSAppLocalDEName();
        pSAppFuncBase.resetPSAppSubAppId();
        pSAppFuncBase.resetPSAppSubAppName();
        pSAppFuncBase.resetPSAppViewId();
        pSAppFuncBase.resetPSAppViewName();
        pSAppFuncBase.resetPSDEACModeId();
        pSAppFuncBase.resetPSDEACModeName();
        pSAppFuncBase.resetPSDEId();
        pSAppFuncBase.resetPSDEUIActionId();
        pSAppFuncBase.resetPSDEUIActionName();
        pSAppFuncBase.resetPSDynaAppId();
        pSAppFuncBase.resetPSDynaAppName();
        pSAppFuncBase.resetPSPDTAppFuncId();
        pSAppFuncBase.resetPSPDTAppFuncName();
        pSAppFuncBase.resetPSSubAppId();
        pSAppFuncBase.resetPSSubAppName();
        pSAppFuncBase.resetPSSubAppViewId();
        pSAppFuncBase.resetPSSubAppViewName();
        pSAppFuncBase.resetPSSysAppId();
        pSAppFuncBase.resetPSSysAppName();
        pSAppFuncBase.resetPSSysReqItemId();
        pSAppFuncBase.resetPSSysReqItemName();
        pSAppFuncBase.resetSystemFlag();
        pSAppFuncBase.resetTipPSLanResId();
        pSAppFuncBase.resetTipPSLanResName();
        pSAppFuncBase.resetTooltipInfo();
        pSAppFuncBase.resetUpdateDate();
        pSAppFuncBase.resetUpdateMan();
        pSAppFuncBase.resetUserCat();
        pSAppFuncBase.resetUserData();
        pSAppFuncBase.resetUserData2();
        pSAppFuncBase.resetUserParams();
        pSAppFuncBase.resetUserTag();
        pSAppFuncBase.resetUserTag2();
        pSAppFuncBase.resetUserTag3();
        pSAppFuncBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppFuncTypeDirty()) {
            hashMap.put(FIELD_APPFUNCTYPE, this.getAppFuncType());
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
        if (!bl || this.isDynaInstTagDirty()) {
            hashMap.put(FIELD_DYNAINSTTAG, this.getDynaInstTag());
        }
        if (!bl || this.isDynaInstTag2Dirty()) {
            hashMap.put(FIELD_DYNAINSTTAG2, this.getDynaInstTag2());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isFromObjIdDirty()) {
            hashMap.put(FIELD_FROMOBJID, this.getFromObjId());
        }
        if (!bl || this.isFuncSNDirty()) {
            hashMap.put(FIELD_FUNCSN, this.getFuncSN());
        }
        if (!bl || this.isJSCodeDirty()) {
            hashMap.put(FIELD_JSCODE, this.getJSCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNamePSLanResIdDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESID, this.getNamePSLanResId());
        }
        if (!bl || this.isNamePSLanResNameDirty()) {
            hashMap.put(FIELD_NAMEPSLANRESNAME, this.getNamePSLanResName());
        }
        if (!bl || this.isOpenModeDirty()) {
            hashMap.put(FIELD_OPENMODE, this.getOpenMode());
        }
        if (!bl || this.isOpenViewParamDirty()) {
            hashMap.put(FIELD_OPENVIEWPARAM, this.getOpenViewParam());
        }
        if (!bl || this.isPageUrlDirty()) {
            hashMap.put(FIELD_PAGEURL, this.getPageUrl());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeParamDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPEPARAM, this.getPredefinedTypeParam());
        }
        if (!bl || this.isPSAppFuncIdDirty()) {
            hashMap.put(FIELD_PSAPPFUNCID, this.getPSAppFuncId());
        }
        if (!bl || this.isPSAppFuncNameDirty()) {
            hashMap.put(FIELD_PSAPPFUNCNAME, this.getPSAppFuncName());
        }
        if (!bl || this.isPSAppLocalDEIdDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDEID, this.getPSAppLocalDEId());
        }
        if (!bl || this.isPSAppLocalDENameDirty()) {
            hashMap.put(FIELD_PSAPPLOCALDENAME, this.getPSAppLocalDEName());
        }
        if (!bl || this.isPSAppSubAppIdDirty()) {
            hashMap.put(FIELD_PSAPPSUBAPPID, this.getPSAppSubAppId());
        }
        if (!bl || this.isPSAppSubAppNameDirty()) {
            hashMap.put(FIELD_PSAPPSUBAPPNAME, this.getPSAppSubAppName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSDEACModeIdDirty()) {
            hashMap.put(FIELD_PSDEACMODEID, this.getPSDEACModeId());
        }
        if (!bl || this.isPSDEACModeNameDirty()) {
            hashMap.put(FIELD_PSDEACMODENAME, this.getPSDEACModeName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSDynaAppIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPID, this.getPSDynaAppId());
        }
        if (!bl || this.isPSDynaAppNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPNAME, this.getPSDynaAppName());
        }
        if (!bl || this.isPSPDTAppFuncIdDirty()) {
            hashMap.put(FIELD_PSPDTAPPFUNCID, this.getPSPDTAppFuncId());
        }
        if (!bl || this.isPSPDTAppFuncNameDirty()) {
            hashMap.put(FIELD_PSPDTAPPFUNCNAME, this.getPSPDTAppFuncName());
        }
        if (!bl || this.isPSSubAppIdDirty()) {
            hashMap.put(FIELD_PSSUBAPPID, this.getPSSubAppId());
        }
        if (!bl || this.isPSSubAppNameDirty()) {
            hashMap.put(FIELD_PSSUBAPPNAME, this.getPSSubAppName());
        }
        if (!bl || this.isPSSubAppViewIdDirty()) {
            hashMap.put(FIELD_PSSUBAPPVIEWID, this.getPSSubAppViewId());
        }
        if (!bl || this.isPSSubAppViewNameDirty()) {
            hashMap.put(FIELD_PSSUBAPPVIEWNAME, this.getPSSubAppViewName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isSystemFlagDirty()) {
            hashMap.put(FIELD_SYSTEMFLAG, this.getSystemFlag());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        return PSAppFuncBase.get(this, n);
    }

    private static Object get(PSAppFuncBase pSAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppFuncBase.getAppFuncType();
            }
            case 1: {
                return pSAppFuncBase.getCodeName();
            }
            case 2: {
                return pSAppFuncBase.getCreateDate();
            }
            case 3: {
                return pSAppFuncBase.getCreateMan();
            }
            case 4: {
                return pSAppFuncBase.getDynaInstTag();
            }
            case 5: {
                return pSAppFuncBase.getDynaInstTag2();
            }
            case 6: {
                return pSAppFuncBase.getDynaModelFlag();
            }
            case 7: {
                return pSAppFuncBase.getFromObjId();
            }
            case 8: {
                return pSAppFuncBase.getFuncSN();
            }
            case 9: {
                return pSAppFuncBase.getJSCode();
            }
            case 10: {
                return pSAppFuncBase.getMemo();
            }
            case 11: {
                return pSAppFuncBase.getNamePSLanResId();
            }
            case 12: {
                return pSAppFuncBase.getNamePSLanResName();
            }
            case 13: {
                return pSAppFuncBase.getOpenMode();
            }
            case 14: {
                return pSAppFuncBase.getOpenViewParam();
            }
            case 15: {
                return pSAppFuncBase.getPageUrl();
            }
            case 16: {
                return pSAppFuncBase.getPredefinedType();
            }
            case 17: {
                return pSAppFuncBase.getPredefinedTypeParam();
            }
            case 18: {
                return pSAppFuncBase.getPSAppFuncId();
            }
            case 19: {
                return pSAppFuncBase.getPSAppFuncName();
            }
            case 20: {
                return pSAppFuncBase.getPSAppLocalDEId();
            }
            case 21: {
                return pSAppFuncBase.getPSAppLocalDEName();
            }
            case 22: {
                return pSAppFuncBase.getPSAppSubAppId();
            }
            case 23: {
                return pSAppFuncBase.getPSAppSubAppName();
            }
            case 24: {
                return pSAppFuncBase.getPSAppViewId();
            }
            case 25: {
                return pSAppFuncBase.getPSAppViewName();
            }
            case 26: {
                return pSAppFuncBase.getPSDEACModeId();
            }
            case 27: {
                return pSAppFuncBase.getPSDEACModeName();
            }
            case 28: {
                return pSAppFuncBase.getPSDEId();
            }
            case 29: {
                return pSAppFuncBase.getPSDEUIActionId();
            }
            case 30: {
                return pSAppFuncBase.getPSDEUIActionName();
            }
            case 31: {
                return pSAppFuncBase.getPSDynaAppId();
            }
            case 32: {
                return pSAppFuncBase.getPSDynaAppName();
            }
            case 33: {
                return pSAppFuncBase.getPSPDTAppFuncId();
            }
            case 34: {
                return pSAppFuncBase.getPSPDTAppFuncName();
            }
            case 35: {
                return pSAppFuncBase.getPSSubAppId();
            }
            case 36: {
                return pSAppFuncBase.getPSSubAppName();
            }
            case 37: {
                return pSAppFuncBase.getPSSubAppViewId();
            }
            case 38: {
                return pSAppFuncBase.getPSSubAppViewName();
            }
            case 39: {
                return pSAppFuncBase.getPSSysAppId();
            }
            case 40: {
                return pSAppFuncBase.getPSSysAppName();
            }
            case 41: {
                return pSAppFuncBase.getPSSysReqItemId();
            }
            case 42: {
                return pSAppFuncBase.getPSSysReqItemName();
            }
            case 43: {
                return pSAppFuncBase.getSystemFlag();
            }
            case 44: {
                return pSAppFuncBase.getTipPSLanResId();
            }
            case 45: {
                return pSAppFuncBase.getTipPSLanResName();
            }
            case 46: {
                return pSAppFuncBase.getTooltipInfo();
            }
            case 47: {
                return pSAppFuncBase.getUpdateDate();
            }
            case 48: {
                return pSAppFuncBase.getUpdateMan();
            }
            case 49: {
                return pSAppFuncBase.getUserCat();
            }
            case 50: {
                return pSAppFuncBase.getUserData();
            }
            case 51: {
                return pSAppFuncBase.getUserData2();
            }
            case 52: {
                return pSAppFuncBase.getUserParams();
            }
            case 53: {
                return pSAppFuncBase.getUserTag();
            }
            case 54: {
                return pSAppFuncBase.getUserTag2();
            }
            case 55: {
                return pSAppFuncBase.getUserTag3();
            }
            case 56: {
                return pSAppFuncBase.getUserTag4();
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
        PSAppFuncBase.set(this, n, object);
    }

    private static void set(PSAppFuncBase pSAppFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppFuncBase.setAppFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppFuncBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSAppFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppFuncBase.setDynaInstTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppFuncBase.setDynaInstTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppFuncBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSAppFuncBase.setFromObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppFuncBase.setFuncSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppFuncBase.setJSCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppFuncBase.setNamePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppFuncBase.setNamePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppFuncBase.setOpenMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppFuncBase.setOpenViewParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppFuncBase.setPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppFuncBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppFuncBase.setPredefinedTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSAppFuncBase.setPSAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSAppFuncBase.setPSAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSAppFuncBase.setPSAppLocalDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppFuncBase.setPSAppLocalDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppFuncBase.setPSAppSubAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSAppFuncBase.setPSAppSubAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSAppFuncBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSAppFuncBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSAppFuncBase.setPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppFuncBase.setPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppFuncBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSAppFuncBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSAppFuncBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSAppFuncBase.setPSDynaAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSAppFuncBase.setPSDynaAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSAppFuncBase.setPSPDTAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSAppFuncBase.setPSPDTAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSAppFuncBase.setPSSubAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSAppFuncBase.setPSSubAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSAppFuncBase.setPSSubAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSAppFuncBase.setPSSubAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSAppFuncBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSAppFuncBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSAppFuncBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSAppFuncBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSAppFuncBase.setSystemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSAppFuncBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSAppFuncBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSAppFuncBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSAppFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 48: {
                pSAppFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSAppFuncBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSAppFuncBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSAppFuncBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSAppFuncBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSAppFuncBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSAppFuncBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSAppFuncBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSAppFuncBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSAppFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSAppFuncBase pSAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppFuncBase.getAppFuncType() == null;
            }
            case 1: {
                return pSAppFuncBase.getCodeName() == null;
            }
            case 2: {
                return pSAppFuncBase.getCreateDate() == null;
            }
            case 3: {
                return pSAppFuncBase.getCreateMan() == null;
            }
            case 4: {
                return pSAppFuncBase.getDynaInstTag() == null;
            }
            case 5: {
                return pSAppFuncBase.getDynaInstTag2() == null;
            }
            case 6: {
                return pSAppFuncBase.getDynaModelFlag() == null;
            }
            case 7: {
                return pSAppFuncBase.getFromObjId() == null;
            }
            case 8: {
                return pSAppFuncBase.getFuncSN() == null;
            }
            case 9: {
                return pSAppFuncBase.getJSCode() == null;
            }
            case 10: {
                return pSAppFuncBase.getMemo() == null;
            }
            case 11: {
                return pSAppFuncBase.getNamePSLanResId() == null;
            }
            case 12: {
                return pSAppFuncBase.getNamePSLanResName() == null;
            }
            case 13: {
                return pSAppFuncBase.getOpenMode() == null;
            }
            case 14: {
                return pSAppFuncBase.getOpenViewParam() == null;
            }
            case 15: {
                return pSAppFuncBase.getPageUrl() == null;
            }
            case 16: {
                return pSAppFuncBase.getPredefinedType() == null;
            }
            case 17: {
                return pSAppFuncBase.getPredefinedTypeParam() == null;
            }
            case 18: {
                return pSAppFuncBase.getPSAppFuncId() == null;
            }
            case 19: {
                return pSAppFuncBase.getPSAppFuncName() == null;
            }
            case 20: {
                return pSAppFuncBase.getPSAppLocalDEId() == null;
            }
            case 21: {
                return pSAppFuncBase.getPSAppLocalDEName() == null;
            }
            case 22: {
                return pSAppFuncBase.getPSAppSubAppId() == null;
            }
            case 23: {
                return pSAppFuncBase.getPSAppSubAppName() == null;
            }
            case 24: {
                return pSAppFuncBase.getPSAppViewId() == null;
            }
            case 25: {
                return pSAppFuncBase.getPSAppViewName() == null;
            }
            case 26: {
                return pSAppFuncBase.getPSDEACModeId() == null;
            }
            case 27: {
                return pSAppFuncBase.getPSDEACModeName() == null;
            }
            case 28: {
                return pSAppFuncBase.getPSDEId() == null;
            }
            case 29: {
                return pSAppFuncBase.getPSDEUIActionId() == null;
            }
            case 30: {
                return pSAppFuncBase.getPSDEUIActionName() == null;
            }
            case 31: {
                return pSAppFuncBase.getPSDynaAppId() == null;
            }
            case 32: {
                return pSAppFuncBase.getPSDynaAppName() == null;
            }
            case 33: {
                return pSAppFuncBase.getPSPDTAppFuncId() == null;
            }
            case 34: {
                return pSAppFuncBase.getPSPDTAppFuncName() == null;
            }
            case 35: {
                return pSAppFuncBase.getPSSubAppId() == null;
            }
            case 36: {
                return pSAppFuncBase.getPSSubAppName() == null;
            }
            case 37: {
                return pSAppFuncBase.getPSSubAppViewId() == null;
            }
            case 38: {
                return pSAppFuncBase.getPSSubAppViewName() == null;
            }
            case 39: {
                return pSAppFuncBase.getPSSysAppId() == null;
            }
            case 40: {
                return pSAppFuncBase.getPSSysAppName() == null;
            }
            case 41: {
                return pSAppFuncBase.getPSSysReqItemId() == null;
            }
            case 42: {
                return pSAppFuncBase.getPSSysReqItemName() == null;
            }
            case 43: {
                return pSAppFuncBase.getSystemFlag() == null;
            }
            case 44: {
                return pSAppFuncBase.getTipPSLanResId() == null;
            }
            case 45: {
                return pSAppFuncBase.getTipPSLanResName() == null;
            }
            case 46: {
                return pSAppFuncBase.getTooltipInfo() == null;
            }
            case 47: {
                return pSAppFuncBase.getUpdateDate() == null;
            }
            case 48: {
                return pSAppFuncBase.getUpdateMan() == null;
            }
            case 49: {
                return pSAppFuncBase.getUserCat() == null;
            }
            case 50: {
                return pSAppFuncBase.getUserData() == null;
            }
            case 51: {
                return pSAppFuncBase.getUserData2() == null;
            }
            case 52: {
                return pSAppFuncBase.getUserParams() == null;
            }
            case 53: {
                return pSAppFuncBase.getUserTag() == null;
            }
            case 54: {
                return pSAppFuncBase.getUserTag2() == null;
            }
            case 55: {
                return pSAppFuncBase.getUserTag3() == null;
            }
            case 56: {
                return pSAppFuncBase.getUserTag4() == null;
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
        return PSAppFuncBase.contains(this, n);
    }

    private static boolean contains(PSAppFuncBase pSAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppFuncBase.isAppFuncTypeDirty();
            }
            case 1: {
                return pSAppFuncBase.isCodeNameDirty();
            }
            case 2: {
                return pSAppFuncBase.isCreateDateDirty();
            }
            case 3: {
                return pSAppFuncBase.isCreateManDirty();
            }
            case 4: {
                return pSAppFuncBase.isDynaInstTagDirty();
            }
            case 5: {
                return pSAppFuncBase.isDynaInstTag2Dirty();
            }
            case 6: {
                return pSAppFuncBase.isDynaModelFlagDirty();
            }
            case 7: {
                return pSAppFuncBase.isFromObjIdDirty();
            }
            case 8: {
                return pSAppFuncBase.isFuncSNDirty();
            }
            case 9: {
                return pSAppFuncBase.isJSCodeDirty();
            }
            case 10: {
                return pSAppFuncBase.isMemoDirty();
            }
            case 11: {
                return pSAppFuncBase.isNamePSLanResIdDirty();
            }
            case 12: {
                return pSAppFuncBase.isNamePSLanResNameDirty();
            }
            case 13: {
                return pSAppFuncBase.isOpenModeDirty();
            }
            case 14: {
                return pSAppFuncBase.isOpenViewParamDirty();
            }
            case 15: {
                return pSAppFuncBase.isPageUrlDirty();
            }
            case 16: {
                return pSAppFuncBase.isPredefinedTypeDirty();
            }
            case 17: {
                return pSAppFuncBase.isPredefinedTypeParamDirty();
            }
            case 18: {
                return pSAppFuncBase.isPSAppFuncIdDirty();
            }
            case 19: {
                return pSAppFuncBase.isPSAppFuncNameDirty();
            }
            case 20: {
                return pSAppFuncBase.isPSAppLocalDEIdDirty();
            }
            case 21: {
                return pSAppFuncBase.isPSAppLocalDENameDirty();
            }
            case 22: {
                return pSAppFuncBase.isPSAppSubAppIdDirty();
            }
            case 23: {
                return pSAppFuncBase.isPSAppSubAppNameDirty();
            }
            case 24: {
                return pSAppFuncBase.isPSAppViewIdDirty();
            }
            case 25: {
                return pSAppFuncBase.isPSAppViewNameDirty();
            }
            case 26: {
                return pSAppFuncBase.isPSDEACModeIdDirty();
            }
            case 27: {
                return pSAppFuncBase.isPSDEACModeNameDirty();
            }
            case 28: {
                return pSAppFuncBase.isPSDEIdDirty();
            }
            case 29: {
                return pSAppFuncBase.isPSDEUIActionIdDirty();
            }
            case 30: {
                return pSAppFuncBase.isPSDEUIActionNameDirty();
            }
            case 31: {
                return pSAppFuncBase.isPSDynaAppIdDirty();
            }
            case 32: {
                return pSAppFuncBase.isPSDynaAppNameDirty();
            }
            case 33: {
                return pSAppFuncBase.isPSPDTAppFuncIdDirty();
            }
            case 34: {
                return pSAppFuncBase.isPSPDTAppFuncNameDirty();
            }
            case 35: {
                return pSAppFuncBase.isPSSubAppIdDirty();
            }
            case 36: {
                return pSAppFuncBase.isPSSubAppNameDirty();
            }
            case 37: {
                return pSAppFuncBase.isPSSubAppViewIdDirty();
            }
            case 38: {
                return pSAppFuncBase.isPSSubAppViewNameDirty();
            }
            case 39: {
                return pSAppFuncBase.isPSSysAppIdDirty();
            }
            case 40: {
                return pSAppFuncBase.isPSSysAppNameDirty();
            }
            case 41: {
                return pSAppFuncBase.isPSSysReqItemIdDirty();
            }
            case 42: {
                return pSAppFuncBase.isPSSysReqItemNameDirty();
            }
            case 43: {
                return pSAppFuncBase.isSystemFlagDirty();
            }
            case 44: {
                return pSAppFuncBase.isTipPSLanResIdDirty();
            }
            case 45: {
                return pSAppFuncBase.isTipPSLanResNameDirty();
            }
            case 46: {
                return pSAppFuncBase.isTooltipInfoDirty();
            }
            case 47: {
                return pSAppFuncBase.isUpdateDateDirty();
            }
            case 48: {
                return pSAppFuncBase.isUpdateManDirty();
            }
            case 49: {
                return pSAppFuncBase.isUserCatDirty();
            }
            case 50: {
                return pSAppFuncBase.isUserDataDirty();
            }
            case 51: {
                return pSAppFuncBase.isUserData2Dirty();
            }
            case 52: {
                return pSAppFuncBase.isUserParamsDirty();
            }
            case 53: {
                return pSAppFuncBase.isUserTagDirty();
            }
            case 54: {
                return pSAppFuncBase.isUserTag2Dirty();
            }
            case 55: {
                return pSAppFuncBase.isUserTag3Dirty();
            }
            case 56: {
                return pSAppFuncBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppFuncBase pSAppFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppFuncBase.getAppFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfunctype", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getAppFuncType()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getDynaInstTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getDynaInstTag()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getDynaInstTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag2", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getDynaInstTag2()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getFromObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromobjid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getFromObjId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getFuncSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcsn", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getFuncSN()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getJSCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jscode", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getJSCode()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getNamePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getNamePSLanResId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getNamePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepslanresname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getNamePSLanResName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getOpenMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openmode", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getOpenMode()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getOpenViewParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openviewparam", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getOpenViewParam()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pageurl", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPageUrl()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPredefinedTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypeparam", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPredefinedTypeParam()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppFuncId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppFuncName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppLocalDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldeid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppLocalDEId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppLocalDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapplocaldename", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppLocalDEName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppSubAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsubappid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppSubAppId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppSubAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsubappname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppSubAppName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodeid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSDEACModeId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodename", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSDEACModeName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSDynaAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSDynaAppId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSDynaAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSDynaAppName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSPDTAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtappfuncid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSPDTAppFuncId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSPDTAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtappfuncname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSPDTAppFuncName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSubAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSubAppId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSubAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSubAppName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSubAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappviewid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSubAppViewId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSubAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappviewname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSubAppViewName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getSystemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systemflag", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getSystemFlag()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserData()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserData2()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserParams()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppFuncBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppFuncBase.getJSONValue((Object)pSAppFuncBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppFuncBase pSAppFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppFuncBase.getAppFuncType() != null) {
            object = pSAppFuncBase.getAppFuncType();
            xmlNode.setAttribute(FIELD_APPFUNCTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSAppFuncBase.getCodeName() != null) {
            object = pSAppFuncBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getCreateDate() != null) {
            object = pSAppFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppFuncBase.getCreateMan() != null) {
            object = pSAppFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getDynaInstTag() != null) {
            object = pSAppFuncBase.getDynaInstTag();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getDynaInstTag2() != null) {
            object = pSAppFuncBase.getDynaInstTag2();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getDynaModelFlag() != null) {
            object = pSAppFuncBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppFuncBase.getFromObjId() != null) {
            object = pSAppFuncBase.getFromObjId();
            xmlNode.setAttribute(FIELD_FROMOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getFuncSN() != null) {
            object = pSAppFuncBase.getFuncSN();
            xmlNode.setAttribute(FIELD_FUNCSN, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getJSCode() != null) {
            object = pSAppFuncBase.getJSCode();
            xmlNode.setAttribute(FIELD_JSCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getMemo() != null) {
            object = pSAppFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getNamePSLanResId() != null) {
            object = pSAppFuncBase.getNamePSLanResId();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getNamePSLanResName() != null) {
            object = pSAppFuncBase.getNamePSLanResName();
            xmlNode.setAttribute(FIELD_NAMEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getOpenMode() != null) {
            object = pSAppFuncBase.getOpenMode();
            xmlNode.setAttribute(FIELD_OPENMODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getOpenViewParam() != null) {
            object = pSAppFuncBase.getOpenViewParam();
            xmlNode.setAttribute(FIELD_OPENVIEWPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPageUrl() != null) {
            object = pSAppFuncBase.getPageUrl();
            xmlNode.setAttribute(FIELD_PAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPredefinedType() != null) {
            object = pSAppFuncBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPredefinedTypeParam() != null) {
            object = pSAppFuncBase.getPredefinedTypeParam();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppFuncId() != null) {
            object = pSAppFuncBase.getPSAppFuncId();
            xmlNode.setAttribute(FIELD_PSAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppFuncName() != null) {
            object = pSAppFuncBase.getPSAppFuncName();
            xmlNode.setAttribute(FIELD_PSAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppLocalDEId() != null) {
            object = pSAppFuncBase.getPSAppLocalDEId();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppLocalDEName() != null) {
            object = pSAppFuncBase.getPSAppLocalDEName();
            xmlNode.setAttribute(FIELD_PSAPPLOCALDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppSubAppId() != null) {
            object = pSAppFuncBase.getPSAppSubAppId();
            xmlNode.setAttribute(FIELD_PSAPPSUBAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppSubAppName() != null) {
            object = pSAppFuncBase.getPSAppSubAppName();
            xmlNode.setAttribute(FIELD_PSAPPSUBAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppViewId() != null) {
            object = pSAppFuncBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSAppViewName() != null) {
            object = pSAppFuncBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSDEACModeId() != null) {
            object = pSAppFuncBase.getPSDEACModeId();
            xmlNode.setAttribute(FIELD_PSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSDEACModeName() != null) {
            object = pSAppFuncBase.getPSDEACModeName();
            xmlNode.setAttribute(FIELD_PSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSDEId() != null) {
            object = pSAppFuncBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSDEUIActionId() != null) {
            object = pSAppFuncBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSDEUIActionName() != null) {
            object = pSAppFuncBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSDynaAppId() != null) {
            object = pSAppFuncBase.getPSDynaAppId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSDynaAppName() != null) {
            object = pSAppFuncBase.getPSDynaAppName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSPDTAppFuncId() != null) {
            object = pSAppFuncBase.getPSPDTAppFuncId();
            xmlNode.setAttribute(FIELD_PSPDTAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSPDTAppFuncName() != null) {
            object = pSAppFuncBase.getPSPDTAppFuncName();
            xmlNode.setAttribute(FIELD_PSPDTAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSubAppId() != null) {
            object = pSAppFuncBase.getPSSubAppId();
            xmlNode.setAttribute(FIELD_PSSUBAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSubAppName() != null) {
            object = pSAppFuncBase.getPSSubAppName();
            xmlNode.setAttribute(FIELD_PSSUBAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSubAppViewId() != null) {
            object = pSAppFuncBase.getPSSubAppViewId();
            xmlNode.setAttribute(FIELD_PSSUBAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSubAppViewName() != null) {
            object = pSAppFuncBase.getPSSubAppViewName();
            xmlNode.setAttribute(FIELD_PSSUBAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSysAppId() != null) {
            object = pSAppFuncBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSysAppName() != null) {
            object = pSAppFuncBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSysReqItemId() != null) {
            object = pSAppFuncBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getPSSysReqItemName() != null) {
            object = pSAppFuncBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getSystemFlag() != null) {
            object = pSAppFuncBase.getSystemFlag();
            xmlNode.setAttribute(FIELD_SYSTEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppFuncBase.getTipPSLanResId() != null) {
            object = pSAppFuncBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getTipPSLanResName() != null) {
            object = pSAppFuncBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getTooltipInfo() != null) {
            object = pSAppFuncBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUpdateDate() != null) {
            object = pSAppFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppFuncBase.getUpdateMan() != null) {
            object = pSAppFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserCat() != null) {
            object = pSAppFuncBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserData() != null) {
            object = pSAppFuncBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserData2() != null) {
            object = pSAppFuncBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserParams() != null) {
            object = pSAppFuncBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserTag() != null) {
            object = pSAppFuncBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserTag2() != null) {
            object = pSAppFuncBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserTag3() != null) {
            object = pSAppFuncBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppFuncBase.getUserTag4() != null) {
            object = pSAppFuncBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppFuncBase pSAppFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppFuncBase.isAppFuncTypeDirty() && (bl || pSAppFuncBase.getAppFuncType() != null)) {
            iDataObject.set(FIELD_APPFUNCTYPE, (Object)pSAppFuncBase.getAppFuncType());
        }
        if (pSAppFuncBase.isCodeNameDirty() && (bl || pSAppFuncBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppFuncBase.getCodeName());
        }
        if (pSAppFuncBase.isCreateDateDirty() && (bl || pSAppFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppFuncBase.getCreateDate());
        }
        if (pSAppFuncBase.isCreateManDirty() && (bl || pSAppFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppFuncBase.getCreateMan());
        }
        if (pSAppFuncBase.isDynaInstTagDirty() && (bl || pSAppFuncBase.getDynaInstTag() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG, (Object)pSAppFuncBase.getDynaInstTag());
        }
        if (pSAppFuncBase.isDynaInstTag2Dirty() && (bl || pSAppFuncBase.getDynaInstTag2() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG2, (Object)pSAppFuncBase.getDynaInstTag2());
        }
        if (pSAppFuncBase.isDynaModelFlagDirty() && (bl || pSAppFuncBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSAppFuncBase.getDynaModelFlag());
        }
        if (pSAppFuncBase.isFromObjIdDirty() && (bl || pSAppFuncBase.getFromObjId() != null)) {
            iDataObject.set(FIELD_FROMOBJID, (Object)pSAppFuncBase.getFromObjId());
        }
        if (pSAppFuncBase.isFuncSNDirty() && (bl || pSAppFuncBase.getFuncSN() != null)) {
            iDataObject.set(FIELD_FUNCSN, (Object)pSAppFuncBase.getFuncSN());
        }
        if (pSAppFuncBase.isJSCodeDirty() && (bl || pSAppFuncBase.getJSCode() != null)) {
            iDataObject.set(FIELD_JSCODE, (Object)pSAppFuncBase.getJSCode());
        }
        if (pSAppFuncBase.isMemoDirty() && (bl || pSAppFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppFuncBase.getMemo());
        }
        if (pSAppFuncBase.isNamePSLanResIdDirty() && (bl || pSAppFuncBase.getNamePSLanResId() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESID, (Object)pSAppFuncBase.getNamePSLanResId());
        }
        if (pSAppFuncBase.isNamePSLanResNameDirty() && (bl || pSAppFuncBase.getNamePSLanResName() != null)) {
            iDataObject.set(FIELD_NAMEPSLANRESNAME, (Object)pSAppFuncBase.getNamePSLanResName());
        }
        if (pSAppFuncBase.isOpenModeDirty() && (bl || pSAppFuncBase.getOpenMode() != null)) {
            iDataObject.set(FIELD_OPENMODE, (Object)pSAppFuncBase.getOpenMode());
        }
        if (pSAppFuncBase.isOpenViewParamDirty() && (bl || pSAppFuncBase.getOpenViewParam() != null)) {
            iDataObject.set(FIELD_OPENVIEWPARAM, (Object)pSAppFuncBase.getOpenViewParam());
        }
        if (pSAppFuncBase.isPageUrlDirty() && (bl || pSAppFuncBase.getPageUrl() != null)) {
            iDataObject.set(FIELD_PAGEURL, (Object)pSAppFuncBase.getPageUrl());
        }
        if (pSAppFuncBase.isPredefinedTypeDirty() && (bl || pSAppFuncBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSAppFuncBase.getPredefinedType());
        }
        if (pSAppFuncBase.isPredefinedTypeParamDirty() && (bl || pSAppFuncBase.getPredefinedTypeParam() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPEPARAM, (Object)pSAppFuncBase.getPredefinedTypeParam());
        }
        if (pSAppFuncBase.isPSAppFuncIdDirty() && (bl || pSAppFuncBase.getPSAppFuncId() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCID, (Object)pSAppFuncBase.getPSAppFuncId());
        }
        if (pSAppFuncBase.isPSAppFuncNameDirty() && (bl || pSAppFuncBase.getPSAppFuncName() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCNAME, (Object)pSAppFuncBase.getPSAppFuncName());
        }
        if (pSAppFuncBase.isPSAppLocalDEIdDirty() && (bl || pSAppFuncBase.getPSAppLocalDEId() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDEID, (Object)pSAppFuncBase.getPSAppLocalDEId());
        }
        if (pSAppFuncBase.isPSAppLocalDENameDirty() && (bl || pSAppFuncBase.getPSAppLocalDEName() != null)) {
            iDataObject.set(FIELD_PSAPPLOCALDENAME, (Object)pSAppFuncBase.getPSAppLocalDEName());
        }
        if (pSAppFuncBase.isPSAppSubAppIdDirty() && (bl || pSAppFuncBase.getPSAppSubAppId() != null)) {
            iDataObject.set(FIELD_PSAPPSUBAPPID, (Object)pSAppFuncBase.getPSAppSubAppId());
        }
        if (pSAppFuncBase.isPSAppSubAppNameDirty() && (bl || pSAppFuncBase.getPSAppSubAppName() != null)) {
            iDataObject.set(FIELD_PSAPPSUBAPPNAME, (Object)pSAppFuncBase.getPSAppSubAppName());
        }
        if (pSAppFuncBase.isPSAppViewIdDirty() && (bl || pSAppFuncBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppFuncBase.getPSAppViewId());
        }
        if (pSAppFuncBase.isPSAppViewNameDirty() && (bl || pSAppFuncBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppFuncBase.getPSAppViewName());
        }
        if (pSAppFuncBase.isPSDEACModeIdDirty() && (bl || pSAppFuncBase.getPSDEACModeId() != null)) {
            iDataObject.set(FIELD_PSDEACMODEID, (Object)pSAppFuncBase.getPSDEACModeId());
        }
        if (pSAppFuncBase.isPSDEACModeNameDirty() && (bl || pSAppFuncBase.getPSDEACModeName() != null)) {
            iDataObject.set(FIELD_PSDEACMODENAME, (Object)pSAppFuncBase.getPSDEACModeName());
        }
        if (pSAppFuncBase.isPSDEIdDirty() && (bl || pSAppFuncBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSAppFuncBase.getPSDEId());
        }
        if (pSAppFuncBase.isPSDEUIActionIdDirty() && (bl || pSAppFuncBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSAppFuncBase.getPSDEUIActionId());
        }
        if (pSAppFuncBase.isPSDEUIActionNameDirty() && (bl || pSAppFuncBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSAppFuncBase.getPSDEUIActionName());
        }
        if (pSAppFuncBase.isPSDynaAppIdDirty() && (bl || pSAppFuncBase.getPSDynaAppId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPID, (Object)pSAppFuncBase.getPSDynaAppId());
        }
        if (pSAppFuncBase.isPSDynaAppNameDirty() && (bl || pSAppFuncBase.getPSDynaAppName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPNAME, (Object)pSAppFuncBase.getPSDynaAppName());
        }
        if (pSAppFuncBase.isPSPDTAppFuncIdDirty() && (bl || pSAppFuncBase.getPSPDTAppFuncId() != null)) {
            iDataObject.set(FIELD_PSPDTAPPFUNCID, (Object)pSAppFuncBase.getPSPDTAppFuncId());
        }
        if (pSAppFuncBase.isPSPDTAppFuncNameDirty() && (bl || pSAppFuncBase.getPSPDTAppFuncName() != null)) {
            iDataObject.set(FIELD_PSPDTAPPFUNCNAME, (Object)pSAppFuncBase.getPSPDTAppFuncName());
        }
        if (pSAppFuncBase.isPSSubAppIdDirty() && (bl || pSAppFuncBase.getPSSubAppId() != null)) {
            iDataObject.set(FIELD_PSSUBAPPID, (Object)pSAppFuncBase.getPSSubAppId());
        }
        if (pSAppFuncBase.isPSSubAppNameDirty() && (bl || pSAppFuncBase.getPSSubAppName() != null)) {
            iDataObject.set(FIELD_PSSUBAPPNAME, (Object)pSAppFuncBase.getPSSubAppName());
        }
        if (pSAppFuncBase.isPSSubAppViewIdDirty() && (bl || pSAppFuncBase.getPSSubAppViewId() != null)) {
            iDataObject.set(FIELD_PSSUBAPPVIEWID, (Object)pSAppFuncBase.getPSSubAppViewId());
        }
        if (pSAppFuncBase.isPSSubAppViewNameDirty() && (bl || pSAppFuncBase.getPSSubAppViewName() != null)) {
            iDataObject.set(FIELD_PSSUBAPPVIEWNAME, (Object)pSAppFuncBase.getPSSubAppViewName());
        }
        if (pSAppFuncBase.isPSSysAppIdDirty() && (bl || pSAppFuncBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppFuncBase.getPSSysAppId());
        }
        if (pSAppFuncBase.isPSSysAppNameDirty() && (bl || pSAppFuncBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppFuncBase.getPSSysAppName());
        }
        if (pSAppFuncBase.isPSSysReqItemIdDirty() && (bl || pSAppFuncBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSAppFuncBase.getPSSysReqItemId());
        }
        if (pSAppFuncBase.isPSSysReqItemNameDirty() && (bl || pSAppFuncBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSAppFuncBase.getPSSysReqItemName());
        }
        if (pSAppFuncBase.isSystemFlagDirty() && (bl || pSAppFuncBase.getSystemFlag() != null)) {
            iDataObject.set(FIELD_SYSTEMFLAG, (Object)pSAppFuncBase.getSystemFlag());
        }
        if (pSAppFuncBase.isTipPSLanResIdDirty() && (bl || pSAppFuncBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSAppFuncBase.getTipPSLanResId());
        }
        if (pSAppFuncBase.isTipPSLanResNameDirty() && (bl || pSAppFuncBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSAppFuncBase.getTipPSLanResName());
        }
        if (pSAppFuncBase.isTooltipInfoDirty() && (bl || pSAppFuncBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSAppFuncBase.getTooltipInfo());
        }
        if (pSAppFuncBase.isUpdateDateDirty() && (bl || pSAppFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppFuncBase.getUpdateDate());
        }
        if (pSAppFuncBase.isUpdateManDirty() && (bl || pSAppFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppFuncBase.getUpdateMan());
        }
        if (pSAppFuncBase.isUserCatDirty() && (bl || pSAppFuncBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppFuncBase.getUserCat());
        }
        if (pSAppFuncBase.isUserDataDirty() && (bl || pSAppFuncBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSAppFuncBase.getUserData());
        }
        if (pSAppFuncBase.isUserData2Dirty() && (bl || pSAppFuncBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSAppFuncBase.getUserData2());
        }
        if (pSAppFuncBase.isUserParamsDirty() && (bl || pSAppFuncBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppFuncBase.getUserParams());
        }
        if (pSAppFuncBase.isUserTagDirty() && (bl || pSAppFuncBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppFuncBase.getUserTag());
        }
        if (pSAppFuncBase.isUserTag2Dirty() && (bl || pSAppFuncBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppFuncBase.getUserTag2());
        }
        if (pSAppFuncBase.isUserTag3Dirty() && (bl || pSAppFuncBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppFuncBase.getUserTag3());
        }
        if (pSAppFuncBase.isUserTag4Dirty() && (bl || pSAppFuncBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppFuncBase.getUserTag4());
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
        return PSAppFuncBase.remove(this, n);
    }

    private static boolean remove(PSAppFuncBase pSAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppFuncBase.resetAppFuncType();
                return true;
            }
            case 1: {
                pSAppFuncBase.resetCodeName();
                return true;
            }
            case 2: {
                pSAppFuncBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSAppFuncBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSAppFuncBase.resetDynaInstTag();
                return true;
            }
            case 5: {
                pSAppFuncBase.resetDynaInstTag2();
                return true;
            }
            case 6: {
                pSAppFuncBase.resetDynaModelFlag();
                return true;
            }
            case 7: {
                pSAppFuncBase.resetFromObjId();
                return true;
            }
            case 8: {
                pSAppFuncBase.resetFuncSN();
                return true;
            }
            case 9: {
                pSAppFuncBase.resetJSCode();
                return true;
            }
            case 10: {
                pSAppFuncBase.resetMemo();
                return true;
            }
            case 11: {
                pSAppFuncBase.resetNamePSLanResId();
                return true;
            }
            case 12: {
                pSAppFuncBase.resetNamePSLanResName();
                return true;
            }
            case 13: {
                pSAppFuncBase.resetOpenMode();
                return true;
            }
            case 14: {
                pSAppFuncBase.resetOpenViewParam();
                return true;
            }
            case 15: {
                pSAppFuncBase.resetPageUrl();
                return true;
            }
            case 16: {
                pSAppFuncBase.resetPredefinedType();
                return true;
            }
            case 17: {
                pSAppFuncBase.resetPredefinedTypeParam();
                return true;
            }
            case 18: {
                pSAppFuncBase.resetPSAppFuncId();
                return true;
            }
            case 19: {
                pSAppFuncBase.resetPSAppFuncName();
                return true;
            }
            case 20: {
                pSAppFuncBase.resetPSAppLocalDEId();
                return true;
            }
            case 21: {
                pSAppFuncBase.resetPSAppLocalDEName();
                return true;
            }
            case 22: {
                pSAppFuncBase.resetPSAppSubAppId();
                return true;
            }
            case 23: {
                pSAppFuncBase.resetPSAppSubAppName();
                return true;
            }
            case 24: {
                pSAppFuncBase.resetPSAppViewId();
                return true;
            }
            case 25: {
                pSAppFuncBase.resetPSAppViewName();
                return true;
            }
            case 26: {
                pSAppFuncBase.resetPSDEACModeId();
                return true;
            }
            case 27: {
                pSAppFuncBase.resetPSDEACModeName();
                return true;
            }
            case 28: {
                pSAppFuncBase.resetPSDEId();
                return true;
            }
            case 29: {
                pSAppFuncBase.resetPSDEUIActionId();
                return true;
            }
            case 30: {
                pSAppFuncBase.resetPSDEUIActionName();
                return true;
            }
            case 31: {
                pSAppFuncBase.resetPSDynaAppId();
                return true;
            }
            case 32: {
                pSAppFuncBase.resetPSDynaAppName();
                return true;
            }
            case 33: {
                pSAppFuncBase.resetPSPDTAppFuncId();
                return true;
            }
            case 34: {
                pSAppFuncBase.resetPSPDTAppFuncName();
                return true;
            }
            case 35: {
                pSAppFuncBase.resetPSSubAppId();
                return true;
            }
            case 36: {
                pSAppFuncBase.resetPSSubAppName();
                return true;
            }
            case 37: {
                pSAppFuncBase.resetPSSubAppViewId();
                return true;
            }
            case 38: {
                pSAppFuncBase.resetPSSubAppViewName();
                return true;
            }
            case 39: {
                pSAppFuncBase.resetPSSysAppId();
                return true;
            }
            case 40: {
                pSAppFuncBase.resetPSSysAppName();
                return true;
            }
            case 41: {
                pSAppFuncBase.resetPSSysReqItemId();
                return true;
            }
            case 42: {
                pSAppFuncBase.resetPSSysReqItemName();
                return true;
            }
            case 43: {
                pSAppFuncBase.resetSystemFlag();
                return true;
            }
            case 44: {
                pSAppFuncBase.resetTipPSLanResId();
                return true;
            }
            case 45: {
                pSAppFuncBase.resetTipPSLanResName();
                return true;
            }
            case 46: {
                pSAppFuncBase.resetTooltipInfo();
                return true;
            }
            case 47: {
                pSAppFuncBase.resetUpdateDate();
                return true;
            }
            case 48: {
                pSAppFuncBase.resetUpdateMan();
                return true;
            }
            case 49: {
                pSAppFuncBase.resetUserCat();
                return true;
            }
            case 50: {
                pSAppFuncBase.resetUserData();
                return true;
            }
            case 51: {
                pSAppFuncBase.resetUserData2();
                return true;
            }
            case 52: {
                pSAppFuncBase.resetUserParams();
                return true;
            }
            case 53: {
                pSAppFuncBase.resetUserTag();
                return true;
            }
            case 54: {
                pSAppFuncBase.resetUserTag2();
                return true;
            }
            case 55: {
                pSAppFuncBase.resetUserTag3();
                return true;
            }
            case 56: {
                pSAppFuncBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppLocalDE getPSAppLocalDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppLocalDE();
        }
        if (this.getPSAppLocalDEId() == null) {
            return null;
        }
        Integer n = this.objPSAppLocalDELock;
        synchronized (n) {
            if (this.psapplocalde != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppLocalDEId(), (Object)this.psapplocalde.getPSAppLocalDEId()) != 0L) {
                this.psapplocalde = null;
            }
            if (this.psapplocalde == null) {
                PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
                pSAppLocalDE.setPSAppLocalDEId(this.getPSAppLocalDEId());
                PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                pSAppLocalDEService.autoGet((IEntity)pSAppLocalDE);
                this.psapplocalde = pSAppLocalDE;
            }
            return this.psapplocalde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppSubApp getPSAppSubApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSubApp();
        }
        if (this.getPSAppSubAppId() == null) {
            return null;
        }
        Integer n = this.objPSAppSubAppLock;
        synchronized (n) {
            if (this.psappsubapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppSubAppId(), (Object)this.psappsubapp.getPSAppSubAppId()) != 0L) {
                this.psappsubapp = null;
            }
            if (this.psappsubapp == null) {
                PSAppSubApp pSAppSubApp = new PSAppSubApp();
                pSAppSubApp.setPSAppSubAppId(this.getPSAppSubAppId());
                PSAppSubAppService pSAppSubAppService = (PSAppSubAppService)ServiceGlobal.getService(PSAppSubAppService.class, (SessionFactory)this.getSessionFactory());
                pSAppSubAppService.autoGet((IEntity)pSAppSubApp);
                this.psappsubapp = pSAppSubApp;
            }
            return this.psappsubapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppView();
        }
        if (this.getPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppViewLock;
        synchronized (n) {
            if (this.psappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppViewId(), (Object)this.psappview.getPSAppViewId()) != 0L) {
                this.psappview = null;
            }
            if (this.psappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet((IEntity)pSAppView);
                this.psappview = pSAppView;
            }
            return this.psappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEACMode getPSDEACMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACMode();
        }
        if (this.getPSDEACModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEACModeLock;
        synchronized (n) {
            if (this.psdeacmode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEACModeId(), (Object)this.psdeacmode.getPSDEACModeId()) != 0L) {
                this.psdeacmode = null;
            }
            if (this.psdeacmode == null) {
                PSDEACMode pSDEACMode = new PSDEACMode();
                pSDEACMode.setPSDEACModeId(this.getPSDEACModeId());
                PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEACModeService.autoGet((IEntity)pSDEACMode);
                this.psdeacmode = pSDEACMode;
            }
            return this.psdeacmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUIActionLock;
        synchronized (n) {
            if (this.psdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuiaction.getPSDEUIActionId()) != 0L) {
                this.psdeuiaction = null;
            }
            if (this.psdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaApp getPSDynaApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaApp();
        }
        if (this.getPSDynaAppId() == null) {
            return null;
        }
        Integer n = this.objPSDynaAppLock;
        synchronized (n) {
            if (this.psdynaapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaAppId(), (Object)this.psdynaapp.getPSDynaAppId()) != 0L) {
                this.psdynaapp = null;
            }
            if (this.psdynaapp == null) {
                PSDynaApp pSDynaApp = new PSDynaApp();
                pSDynaApp.setPSDynaAppId(this.getPSDynaAppId());
                PSDynaAppService pSDynaAppService = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
                pSDynaAppService.autoGet((IEntity)pSDynaApp);
                this.psdynaapp = pSDynaApp;
            }
            return this.psdynaapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getNamePSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSLanRes();
        }
        if (this.getNamePSLanResId() == null) {
            return null;
        }
        Integer n = this.objNamePSLanResLock;
        synchronized (n) {
            if (this.namepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getNamePSLanResId(), (Object)this.namepslanres.getPSLanguageResId()) != 0L) {
                this.namepslanres = null;
            }
            if (this.namepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getNamePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.namepslanres = pSLanguageRes;
            }
            return this.namepslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTipPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanRes();
        }
        if (this.getTipPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSLanResLock;
        synchronized (n) {
            if (this.tippslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSLanResId(), (Object)this.tippslanres.getPSLanguageResId()) != 0L) {
                this.tippslanres = null;
            }
            if (this.tippslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTipPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPDTAppFunc getPSPDTAppFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTAppFunc();
        }
        if (this.getPSPDTAppFuncId() == null) {
            return null;
        }
        Integer n = this.objPSPDTAppFuncLock;
        synchronized (n) {
            if (this.pspdtappfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSPDTAppFuncId(), (Object)this.pspdtappfunc.getPSPDTAppFuncId()) != 0L) {
                this.pspdtappfunc = null;
            }
            if (this.pspdtappfunc == null) {
                PSPDTAppFunc pSPDTAppFunc = new PSPDTAppFunc();
                pSPDTAppFunc.setPSPDTAppFuncId(this.getPSPDTAppFuncId());
                PSPDTAppFuncService pSPDTAppFuncService = (PSPDTAppFuncService)ServiceGlobal.getService(PSPDTAppFuncService.class, (SessionFactory)this.getSessionFactory());
                pSPDTAppFuncService.autoGet((IEntity)pSPDTAppFunc);
                this.pspdtappfunc = pSPDTAppFunc;
            }
            return this.pspdtappfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubAppView getPSSubAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppView();
        }
        if (this.getPSSubAppViewId() == null) {
            return null;
        }
        Integer n = this.objPSSubAppViewLock;
        synchronized (n) {
            if (this.pssubappview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubAppViewId(), (Object)this.pssubappview.getPSSubAppViewId()) != 0L) {
                this.pssubappview = null;
            }
            if (this.pssubappview == null) {
                PSSubAppView pSSubAppView = new PSSubAppView();
                pSSubAppView.setPSSubAppViewId(this.getPSSubAppViewId());
                PSSubAppViewService pSSubAppViewService = (PSSubAppViewService)ServiceGlobal.getService(PSSubAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSSubAppViewService.autoGet((IEntity)pSSubAppView);
                this.pssubappview = pSSubAppView;
            }
            return this.pssubappview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubApp getPSSubApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubApp();
        }
        if (this.getPSSubAppId() == null) {
            return null;
        }
        Integer n = this.objPSSubAppLock;
        synchronized (n) {
            if (this.pssubapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubAppId(), (Object)this.pssubapp.getPSSubAppId()) != 0L) {
                this.pssubapp = null;
            }
            if (this.pssubapp == null) {
                PSSubApp pSSubApp = new PSSubApp();
                pSSubApp.setPSSubAppId(this.getPSSubAppId());
                PSSubAppService pSSubAppService = (PSSubAppService)ServiceGlobal.getService(PSSubAppService.class, (SessionFactory)this.getSessionFactory());
                pSSubAppService.autoGet((IEntity)pSSubApp);
                this.pssubapp = pSSubApp;
            }
            return this.pssubapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    private PSAppFuncBase getProxyEntity() {
        return this.proxyPSAppFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppFuncBase) {
            this.proxyPSAppFuncBase = (PSAppFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPFUNCTYPE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DYNAINSTTAG, 4);
        fieldIndexMap.put(FIELD_DYNAINSTTAG2, 5);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 6);
        fieldIndexMap.put(FIELD_FROMOBJID, 7);
        fieldIndexMap.put(FIELD_FUNCSN, 8);
        fieldIndexMap.put(FIELD_JSCODE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_NAMEPSLANRESID, 11);
        fieldIndexMap.put(FIELD_NAMEPSLANRESNAME, 12);
        fieldIndexMap.put(FIELD_OPENMODE, 13);
        fieldIndexMap.put(FIELD_OPENVIEWPARAM, 14);
        fieldIndexMap.put(FIELD_PAGEURL, 15);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 16);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPEPARAM, 17);
        fieldIndexMap.put(FIELD_PSAPPFUNCID, 18);
        fieldIndexMap.put(FIELD_PSAPPFUNCNAME, 19);
        fieldIndexMap.put(FIELD_PSAPPLOCALDEID, 20);
        fieldIndexMap.put(FIELD_PSAPPLOCALDENAME, 21);
        fieldIndexMap.put(FIELD_PSAPPSUBAPPID, 22);
        fieldIndexMap.put(FIELD_PSAPPSUBAPPNAME, 23);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 24);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 25);
        fieldIndexMap.put(FIELD_PSDEACMODEID, 26);
        fieldIndexMap.put(FIELD_PSDEACMODENAME, 27);
        fieldIndexMap.put(FIELD_PSDEID, 28);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 29);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 30);
        fieldIndexMap.put(FIELD_PSDYNAAPPID, 31);
        fieldIndexMap.put(FIELD_PSDYNAAPPNAME, 32);
        fieldIndexMap.put(FIELD_PSPDTAPPFUNCID, 33);
        fieldIndexMap.put(FIELD_PSPDTAPPFUNCNAME, 34);
        fieldIndexMap.put(FIELD_PSSUBAPPID, 35);
        fieldIndexMap.put(FIELD_PSSUBAPPNAME, 36);
        fieldIndexMap.put(FIELD_PSSUBAPPVIEWID, 37);
        fieldIndexMap.put(FIELD_PSSUBAPPVIEWNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 39);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 40);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 41);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 42);
        fieldIndexMap.put(FIELD_SYSTEMFLAG, 43);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 44);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 45);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 46);
        fieldIndexMap.put(FIELD_UPDATEDATE, 47);
        fieldIndexMap.put(FIELD_UPDATEMAN, 48);
        fieldIndexMap.put(FIELD_USERCAT, 49);
        fieldIndexMap.put(FIELD_USERDATA, 50);
        fieldIndexMap.put(FIELD_USERDATA2, 51);
        fieldIndexMap.put(FIELD_USERPARAMS, 52);
        fieldIndexMap.put(FIELD_USERTAG, 53);
        fieldIndexMap.put(FIELD_USERTAG2, 54);
        fieldIndexMap.put(FIELD_USERTAG3, 55);
        fieldIndexMap.put(FIELD_USERTAG4, 56);
    }
}

