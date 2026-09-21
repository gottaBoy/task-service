/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWAppFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWAppFuncBase.class);
    public static final String FIELD_APPFUNCTYPE = "APPFUNCTYPE";
    public static final String FIELD_APPFUNCTYPENAME = "APPFUNCTYPENAME";
    public static final String FIELD_APPVIEWTYPE = "APPVIEWTYPE";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAINSTTAG = "DYNAINSTTAG";
    public static final String FIELD_DYNAINSTTAG2 = "DYNAINSTTAG2";
    public static final String FIELD_JSCODE = "JSCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OPENMODE = "OPENMODE";
    public static final String FIELD_PAGEURL = "PAGEURL";
    public static final String FIELD_PSAPPFUNCID = "PSAPPFUNCID";
    public static final String FIELD_PSAPPFUNCNAME = "PSAPPFUNCNAME";
    public static final String FIELD_PSAPPINDEXVIEWID = "PSAPPINDEXVIEWID";
    public static final String FIELD_PSAPPINDEXVIEWNAME = "PSAPPINDEXVIEWNAME";
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String FIELD_PSAPPPORTALVIEWID = "PSAPPPORTALVIEWID";
    public static final String FIELD_PSAPPPORTALVIEWNAME = "PSAPPPORTALVIEWNAME";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSPDTAPPFUNCID = "PSPDTAPPFUNCID";
    public static final String FIELD_PSPDTAPPFUNCNAME = "PSPDTAPPFUNCNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSUWAPPFUNCID = "PSUWAPPFUNCID";
    public static final String FIELD_PSUWAPPFUNCNAME = "PSUWAPPFUNCNAME";
    public static final String FIELD_SRFNEXTFORM = "SRFNEXTFORM";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    private static final int INDEX_APPFUNCTYPE = 0;
    private static final int INDEX_APPFUNCTYPENAME = 1;
    private static final int INDEX_APPVIEWTYPE = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DYNAINSTTAG = 6;
    private static final int INDEX_DYNAINSTTAG2 = 7;
    private static final int INDEX_JSCODE = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_OPENMODE = 10;
    private static final int INDEX_PAGEURL = 11;
    private static final int INDEX_PSAPPFUNCID = 12;
    private static final int INDEX_PSAPPFUNCNAME = 13;
    private static final int INDEX_PSAPPINDEXVIEWID = 14;
    private static final int INDEX_PSAPPINDEXVIEWNAME = 15;
    private static final int INDEX_PSAPPMODULEID = 16;
    private static final int INDEX_PSAPPMODULENAME = 17;
    private static final int INDEX_PSAPPPORTALVIEWID = 18;
    private static final int INDEX_PSAPPPORTALVIEWNAME = 19;
    private static final int INDEX_PSAPPVIEWID = 20;
    private static final int INDEX_PSAPPVIEWNAME = 21;
    private static final int INDEX_PSDEID = 22;
    private static final int INDEX_PSDENAME = 23;
    private static final int INDEX_PSDEVIEWBASEID = 24;
    private static final int INDEX_PSDEVIEWBASENAME = 25;
    private static final int INDEX_PSDYNAINSTID = 26;
    private static final int INDEX_PSPDTAPPFUNCID = 27;
    private static final int INDEX_PSPDTAPPFUNCNAME = 28;
    private static final int INDEX_PSSYSAPPID = 29;
    private static final int INDEX_PSUWAPPFUNCID = 30;
    private static final int INDEX_PSUWAPPFUNCNAME = 31;
    private static final int INDEX_SRFNEXTFORM = 32;
    private static final int INDEX_TOOLTIPINFO = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_WIZARDMODE = 36;
    private static final int INDEX_WIZARDPARAM = 37;
    private static final int INDEX_WIZARDPARAM2 = 38;
    private static final int INDEX_WIZARDPARAM3 = 39;
    private static final int INDEX_WIZARDPARAM4 = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWAppFuncBase proxyPSUWAppFuncBase = null;
    private boolean appfunctypeDirtyFlag = false;
    private boolean appfunctypenameDirtyFlag = false;
    private boolean appviewtypeDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynainsttagDirtyFlag = false;
    private boolean dynainsttag2DirtyFlag = false;
    private boolean jscodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean openmodeDirtyFlag = false;
    private boolean pageurlDirtyFlag = false;
    private boolean psappfuncidDirtyFlag = false;
    private boolean psappfuncnameDirtyFlag = false;
    private boolean psappindexviewidDirtyFlag = false;
    private boolean psappindexviewnameDirtyFlag = false;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappmodulenameDirtyFlag = false;
    private boolean psappportalviewidDirtyFlag = false;
    private boolean psappportalviewnameDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pspdtappfuncidDirtyFlag = false;
    private boolean pspdtappfuncnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean psuwappfuncidDirtyFlag = false;
    private boolean psuwappfuncnameDirtyFlag = false;
    private boolean srfnextformDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    @Column(name="appfunctype")
    private String appfunctype;
    @Column(name="appfunctypename")
    private String appfunctypename;
    @Column(name="appviewtype")
    private String appviewtype;
    @Column(name="caption")
    private String caption;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynainsttag")
    private String dynainsttag;
    @Column(name="dynainsttag2")
    private String dynainsttag2;
    @Column(name="jscode")
    private String jscode;
    @Column(name="memo")
    private String memo;
    @Column(name="openmode")
    private String openmode;
    @Column(name="pageurl")
    private String pageurl;
    @Column(name="psappfuncid")
    private String psappfuncid;
    @Column(name="psappfuncname")
    private String psappfuncname;
    @Column(name="psappindexviewid")
    private String psappindexviewid;
    @Column(name="psappindexviewname")
    private String psappindexviewname;
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappmodulename")
    private String psappmodulename;
    @Column(name="psappportalviewid")
    private String psappportalviewid;
    @Column(name="psappportalviewname")
    private String psappportalviewname;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pspdtappfuncid")
    private String pspdtappfuncid;
    @Column(name="pspdtappfuncname")
    private String pspdtappfuncname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="psuwappfuncid")
    private String psuwappfuncid;
    @Column(name="psuwappfuncname")
    private String psuwappfuncname;
    @Column(name="srfnextform")
    private String srfnextform;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private String wizardparam;
    @Column(name="wizardparam2")
    private String wizardparam2;
    @Column(name="wizardparam3")
    private Integer wizardparam3;
    @Column(name="wizardparam4")
    private Integer wizardparam4;

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

    public void setAppFuncTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppFuncTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appfunctypename = string;
        this.appfunctypenameDirtyFlag = true;
    }

    public String getAppFuncTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppFuncTypeName();
        }
        return this.appfunctypename;
    }

    public boolean isAppFuncTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppFuncTypeNameDirty();
        }
        return this.appfunctypenameDirtyFlag;
    }

    public void resetAppFuncTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppFuncTypeName();
            return;
        }
        this.appfunctypenameDirtyFlag = false;
        this.appfunctypename = null;
    }

    public void setAppViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appviewtype = string;
        this.appviewtypeDirtyFlag = true;
    }

    public String getAppViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppViewType();
        }
        return this.appviewtype;
    }

    public boolean isAppViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppViewTypeDirty();
        }
        return this.appviewtypeDirtyFlag;
    }

    public void resetAppViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppViewType();
            return;
        }
        this.appviewtypeDirtyFlag = false;
        this.appviewtype = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setPSAppIndexViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppIndexViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappindexviewid = string;
        this.psappindexviewidDirtyFlag = true;
    }

    public String getPSAppIndexViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppIndexViewId();
        }
        return this.psappindexviewid;
    }

    public boolean isPSAppIndexViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppIndexViewIdDirty();
        }
        return this.psappindexviewidDirtyFlag;
    }

    public void resetPSAppIndexViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppIndexViewId();
            return;
        }
        this.psappindexviewidDirtyFlag = false;
        this.psappindexviewid = null;
    }

    public void setPSAppIndexViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppIndexViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappindexviewname = string;
        this.psappindexviewnameDirtyFlag = true;
    }

    public String getPSAppIndexViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppIndexViewName();
        }
        return this.psappindexviewname;
    }

    public boolean isPSAppIndexViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppIndexViewNameDirty();
        }
        return this.psappindexviewnameDirtyFlag;
    }

    public void resetPSAppIndexViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppIndexViewName();
            return;
        }
        this.psappindexviewnameDirtyFlag = false;
        this.psappindexviewname = null;
    }

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmodulename = string;
        this.psappmodulenameDirtyFlag = true;
    }

    public String getPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleName();
        }
        return this.psappmodulename;
    }

    public boolean isPSAppModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleNameDirty();
        }
        return this.psappmodulenameDirtyFlag;
    }

    public void resetPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleName();
            return;
        }
        this.psappmodulenameDirtyFlag = false;
        this.psappmodulename = null;
    }

    public void setPSAppPortalViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPortalViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappportalviewid = string;
        this.psappportalviewidDirtyFlag = true;
    }

    public String getPSAppPortalViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortalViewId();
        }
        return this.psappportalviewid;
    }

    public boolean isPSAppPortalViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPortalViewIdDirty();
        }
        return this.psappportalviewidDirtyFlag;
    }

    public void resetPSAppPortalViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPortalViewId();
            return;
        }
        this.psappportalviewidDirtyFlag = false;
        this.psappportalviewid = null;
    }

    public void setPSAppPortalViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPortalViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappportalviewname = string;
        this.psappportalviewnameDirtyFlag = true;
    }

    public String getPSAppPortalViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPortalViewName();
        }
        return this.psappportalviewname;
    }

    public boolean isPSAppPortalViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPortalViewNameDirty();
        }
        return this.psappportalviewnameDirtyFlag;
    }

    public void resetPSAppPortalViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPortalViewName();
            return;
        }
        this.psappportalviewnameDirtyFlag = false;
        this.psappportalviewname = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setPSUWAppFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWAppFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwappfuncid = string;
        this.psuwappfuncidDirtyFlag = true;
    }

    public String getPSUWAppFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWAppFuncId();
        }
        return this.psuwappfuncid;
    }

    public boolean isPSUWAppFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWAppFuncIdDirty();
        }
        return this.psuwappfuncidDirtyFlag;
    }

    public void resetPSUWAppFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWAppFuncId();
            return;
        }
        this.psuwappfuncidDirtyFlag = false;
        this.psuwappfuncid = null;
    }

    public void setPSUWAppFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWAppFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwappfuncname = string;
        this.psuwappfuncnameDirtyFlag = true;
    }

    public String getPSUWAppFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWAppFuncName();
        }
        return this.psuwappfuncname;
    }

    public boolean isPSUWAppFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWAppFuncNameDirty();
        }
        return this.psuwappfuncnameDirtyFlag;
    }

    public void resetPSUWAppFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWAppFuncName();
            return;
        }
        this.psuwappfuncnameDirtyFlag = false;
        this.psuwappfuncname = null;
    }

    public void setSRFNextForm(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFNextForm(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfnextform = string;
        this.srfnextformDirtyFlag = true;
    }

    public String getSRFNextForm() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFNextForm();
        }
        return this.srfnextform;
    }

    public boolean isSRFNextFormDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFNextFormDirty();
        }
        return this.srfnextformDirtyFlag;
    }

    public void resetSRFNextForm() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFNextForm();
            return;
        }
        this.srfnextformDirtyFlag = false;
        this.srfnextform = null;
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

    public void setWizardMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardmode = string;
        this.wizardmodeDirtyFlag = true;
    }

    public String getWizardMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardMode();
        }
        return this.wizardmode;
    }

    public boolean isWizardModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardModeDirty();
        }
        return this.wizardmodeDirtyFlag;
    }

    public void resetWizardMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardMode();
            return;
        }
        this.wizardmodeDirtyFlag = false;
        this.wizardmode = null;
    }

    public void setWizardParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam = string;
        this.wizardparamDirtyFlag = true;
    }

    public String getWizardParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam();
        }
        return this.wizardparam;
    }

    public boolean isWizardParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParamDirty();
        }
        return this.wizardparamDirtyFlag;
    }

    public void resetWizardParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam();
            return;
        }
        this.wizardparamDirtyFlag = false;
        this.wizardparam = null;
    }

    public void setWizardParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam2 = string;
        this.wizardparam2DirtyFlag = true;
    }

    public String getWizardParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam2();
        }
        return this.wizardparam2;
    }

    public boolean isWizardParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam2Dirty();
        }
        return this.wizardparam2DirtyFlag;
    }

    public void resetWizardParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam2();
            return;
        }
        this.wizardparam2DirtyFlag = false;
        this.wizardparam2 = null;
    }

    public void setWizardParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(n);
            return;
        }
        this.wizardparam3 = n;
        this.wizardparam3DirtyFlag = true;
    }

    public Integer getWizardParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam3();
        }
        return this.wizardparam3;
    }

    public boolean isWizardParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam3Dirty();
        }
        return this.wizardparam3DirtyFlag;
    }

    public void resetWizardParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam3();
            return;
        }
        this.wizardparam3DirtyFlag = false;
        this.wizardparam3 = null;
    }

    public void setWizardParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(n);
            return;
        }
        this.wizardparam4 = n;
        this.wizardparam4DirtyFlag = true;
    }

    public Integer getWizardParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam4();
        }
        return this.wizardparam4;
    }

    public boolean isWizardParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam4Dirty();
        }
        return this.wizardparam4DirtyFlag;
    }

    public void resetWizardParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam4();
            return;
        }
        this.wizardparam4DirtyFlag = false;
        this.wizardparam4 = null;
    }

    protected void onReset() {
        PSUWAppFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWAppFuncBase pSUWAppFuncBase) {
        pSUWAppFuncBase.resetAppFuncType();
        pSUWAppFuncBase.resetAppFuncTypeName();
        pSUWAppFuncBase.resetAppViewType();
        pSUWAppFuncBase.resetCaption();
        pSUWAppFuncBase.resetCreateDate();
        pSUWAppFuncBase.resetCreateMan();
        pSUWAppFuncBase.resetDynaInstTag();
        pSUWAppFuncBase.resetDynaInstTag2();
        pSUWAppFuncBase.resetJSCode();
        pSUWAppFuncBase.resetMemo();
        pSUWAppFuncBase.resetOpenMode();
        pSUWAppFuncBase.resetPageUrl();
        pSUWAppFuncBase.resetPSAppFuncId();
        pSUWAppFuncBase.resetPSAppFuncName();
        pSUWAppFuncBase.resetPSAppIndexViewId();
        pSUWAppFuncBase.resetPSAppIndexViewName();
        pSUWAppFuncBase.resetPSAppModuleId();
        pSUWAppFuncBase.resetPSAppModuleName();
        pSUWAppFuncBase.resetPSAppPortalViewId();
        pSUWAppFuncBase.resetPSAppPortalViewName();
        pSUWAppFuncBase.resetPSAppViewId();
        pSUWAppFuncBase.resetPSAppViewName();
        pSUWAppFuncBase.resetPSDEId();
        pSUWAppFuncBase.resetPSDEName();
        pSUWAppFuncBase.resetPSDEViewBaseId();
        pSUWAppFuncBase.resetPSDEViewBaseName();
        pSUWAppFuncBase.resetPSDynaInstId();
        pSUWAppFuncBase.resetPSPDTAppFuncId();
        pSUWAppFuncBase.resetPSPDTAppFuncName();
        pSUWAppFuncBase.resetPSSysAppId();
        pSUWAppFuncBase.resetPSUWAppFuncId();
        pSUWAppFuncBase.resetPSUWAppFuncName();
        pSUWAppFuncBase.resetSRFNextForm();
        pSUWAppFuncBase.resetTooltipInfo();
        pSUWAppFuncBase.resetUpdateDate();
        pSUWAppFuncBase.resetUpdateMan();
        pSUWAppFuncBase.resetWizardMode();
        pSUWAppFuncBase.resetWizardParam();
        pSUWAppFuncBase.resetWizardParam2();
        pSUWAppFuncBase.resetWizardParam3();
        pSUWAppFuncBase.resetWizardParam4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppFuncTypeDirty()) {
            hashMap.put(FIELD_APPFUNCTYPE, this.getAppFuncType());
        }
        if (!bl || this.isAppFuncTypeNameDirty()) {
            hashMap.put(FIELD_APPFUNCTYPENAME, this.getAppFuncTypeName());
        }
        if (!bl || this.isAppViewTypeDirty()) {
            hashMap.put(FIELD_APPVIEWTYPE, this.getAppViewType());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
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
        if (!bl || this.isJSCodeDirty()) {
            hashMap.put(FIELD_JSCODE, this.getJSCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOpenModeDirty()) {
            hashMap.put(FIELD_OPENMODE, this.getOpenMode());
        }
        if (!bl || this.isPageUrlDirty()) {
            hashMap.put(FIELD_PAGEURL, this.getPageUrl());
        }
        if (!bl || this.isPSAppFuncIdDirty()) {
            hashMap.put(FIELD_PSAPPFUNCID, this.getPSAppFuncId());
        }
        if (!bl || this.isPSAppFuncNameDirty()) {
            hashMap.put(FIELD_PSAPPFUNCNAME, this.getPSAppFuncName());
        }
        if (!bl || this.isPSAppIndexViewIdDirty()) {
            hashMap.put(FIELD_PSAPPINDEXVIEWID, this.getPSAppIndexViewId());
        }
        if (!bl || this.isPSAppIndexViewNameDirty()) {
            hashMap.put(FIELD_PSAPPINDEXVIEWNAME, this.getPSAppIndexViewName());
        }
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppModuleNameDirty()) {
            hashMap.put(FIELD_PSAPPMODULENAME, this.getPSAppModuleName());
        }
        if (!bl || this.isPSAppPortalViewIdDirty()) {
            hashMap.put(FIELD_PSAPPPORTALVIEWID, this.getPSAppPortalViewId());
        }
        if (!bl || this.isPSAppPortalViewNameDirty()) {
            hashMap.put(FIELD_PSAPPPORTALVIEWNAME, this.getPSAppPortalViewName());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSPDTAppFuncIdDirty()) {
            hashMap.put(FIELD_PSPDTAPPFUNCID, this.getPSPDTAppFuncId());
        }
        if (!bl || this.isPSPDTAppFuncNameDirty()) {
            hashMap.put(FIELD_PSPDTAPPFUNCNAME, this.getPSPDTAppFuncName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSUWAppFuncIdDirty()) {
            hashMap.put(FIELD_PSUWAPPFUNCID, this.getPSUWAppFuncId());
        }
        if (!bl || this.isPSUWAppFuncNameDirty()) {
            hashMap.put(FIELD_PSUWAPPFUNCNAME, this.getPSUWAppFuncName());
        }
        if (!bl || this.isSRFNextFormDirty()) {
            hashMap.put(FIELD_SRFNEXTFORM, this.getSRFNextForm());
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
        if (!bl || this.isWizardModeDirty()) {
            hashMap.put(FIELD_WIZARDMODE, this.getWizardMode());
        }
        if (!bl || this.isWizardParamDirty()) {
            hashMap.put(FIELD_WIZARDPARAM, this.getWizardParam());
        }
        if (!bl || this.isWizardParam2Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM2, this.getWizardParam2());
        }
        if (!bl || this.isWizardParam3Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM3, this.getWizardParam3());
        }
        if (!bl || this.isWizardParam4Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM4, this.getWizardParam4());
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
        return PSUWAppFuncBase.get(this, n);
    }

    private static Object get(PSUWAppFuncBase pSUWAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAppFuncBase.getAppFuncType();
            }
            case 1: {
                return pSUWAppFuncBase.getAppFuncTypeName();
            }
            case 2: {
                return pSUWAppFuncBase.getAppViewType();
            }
            case 3: {
                return pSUWAppFuncBase.getCaption();
            }
            case 4: {
                return pSUWAppFuncBase.getCreateDate();
            }
            case 5: {
                return pSUWAppFuncBase.getCreateMan();
            }
            case 6: {
                return pSUWAppFuncBase.getDynaInstTag();
            }
            case 7: {
                return pSUWAppFuncBase.getDynaInstTag2();
            }
            case 8: {
                return pSUWAppFuncBase.getJSCode();
            }
            case 9: {
                return pSUWAppFuncBase.getMemo();
            }
            case 10: {
                return pSUWAppFuncBase.getOpenMode();
            }
            case 11: {
                return pSUWAppFuncBase.getPageUrl();
            }
            case 12: {
                return pSUWAppFuncBase.getPSAppFuncId();
            }
            case 13: {
                return pSUWAppFuncBase.getPSAppFuncName();
            }
            case 14: {
                return pSUWAppFuncBase.getPSAppIndexViewId();
            }
            case 15: {
                return pSUWAppFuncBase.getPSAppIndexViewName();
            }
            case 16: {
                return pSUWAppFuncBase.getPSAppModuleId();
            }
            case 17: {
                return pSUWAppFuncBase.getPSAppModuleName();
            }
            case 18: {
                return pSUWAppFuncBase.getPSAppPortalViewId();
            }
            case 19: {
                return pSUWAppFuncBase.getPSAppPortalViewName();
            }
            case 20: {
                return pSUWAppFuncBase.getPSAppViewId();
            }
            case 21: {
                return pSUWAppFuncBase.getPSAppViewName();
            }
            case 22: {
                return pSUWAppFuncBase.getPSDEId();
            }
            case 23: {
                return pSUWAppFuncBase.getPSDEName();
            }
            case 24: {
                return pSUWAppFuncBase.getPSDEViewBaseId();
            }
            case 25: {
                return pSUWAppFuncBase.getPSDEViewBaseName();
            }
            case 26: {
                return pSUWAppFuncBase.getPSDynaInstId();
            }
            case 27: {
                return pSUWAppFuncBase.getPSPDTAppFuncId();
            }
            case 28: {
                return pSUWAppFuncBase.getPSPDTAppFuncName();
            }
            case 29: {
                return pSUWAppFuncBase.getPSSysAppId();
            }
            case 30: {
                return pSUWAppFuncBase.getPSUWAppFuncId();
            }
            case 31: {
                return pSUWAppFuncBase.getPSUWAppFuncName();
            }
            case 32: {
                return pSUWAppFuncBase.getSRFNextForm();
            }
            case 33: {
                return pSUWAppFuncBase.getTooltipInfo();
            }
            case 34: {
                return pSUWAppFuncBase.getUpdateDate();
            }
            case 35: {
                return pSUWAppFuncBase.getUpdateMan();
            }
            case 36: {
                return pSUWAppFuncBase.getWizardMode();
            }
            case 37: {
                return pSUWAppFuncBase.getWizardParam();
            }
            case 38: {
                return pSUWAppFuncBase.getWizardParam2();
            }
            case 39: {
                return pSUWAppFuncBase.getWizardParam3();
            }
            case 40: {
                return pSUWAppFuncBase.getWizardParam4();
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
        PSUWAppFuncBase.set(this, n, object);
    }

    private static void set(PSUWAppFuncBase pSUWAppFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWAppFuncBase.setAppFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWAppFuncBase.setAppFuncTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWAppFuncBase.setAppViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWAppFuncBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWAppFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSUWAppFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWAppFuncBase.setDynaInstTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWAppFuncBase.setDynaInstTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWAppFuncBase.setJSCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWAppFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWAppFuncBase.setOpenMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWAppFuncBase.setPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWAppFuncBase.setPSAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWAppFuncBase.setPSAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWAppFuncBase.setPSAppIndexViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWAppFuncBase.setPSAppIndexViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWAppFuncBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWAppFuncBase.setPSAppModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWAppFuncBase.setPSAppPortalViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWAppFuncBase.setPSAppPortalViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWAppFuncBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSUWAppFuncBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUWAppFuncBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUWAppFuncBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUWAppFuncBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSUWAppFuncBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSUWAppFuncBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSUWAppFuncBase.setPSPDTAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSUWAppFuncBase.setPSPDTAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSUWAppFuncBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSUWAppFuncBase.setPSUWAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSUWAppFuncBase.setPSUWAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSUWAppFuncBase.setSRFNextForm(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSUWAppFuncBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSUWAppFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSUWAppFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSUWAppFuncBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSUWAppFuncBase.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSUWAppFuncBase.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSUWAppFuncBase.setWizardParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSUWAppFuncBase.setWizardParam4(DataObject.getIntegerValue((Object)object));
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
        return PSUWAppFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSUWAppFuncBase pSUWAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAppFuncBase.getAppFuncType() == null;
            }
            case 1: {
                return pSUWAppFuncBase.getAppFuncTypeName() == null;
            }
            case 2: {
                return pSUWAppFuncBase.getAppViewType() == null;
            }
            case 3: {
                return pSUWAppFuncBase.getCaption() == null;
            }
            case 4: {
                return pSUWAppFuncBase.getCreateDate() == null;
            }
            case 5: {
                return pSUWAppFuncBase.getCreateMan() == null;
            }
            case 6: {
                return pSUWAppFuncBase.getDynaInstTag() == null;
            }
            case 7: {
                return pSUWAppFuncBase.getDynaInstTag2() == null;
            }
            case 8: {
                return pSUWAppFuncBase.getJSCode() == null;
            }
            case 9: {
                return pSUWAppFuncBase.getMemo() == null;
            }
            case 10: {
                return pSUWAppFuncBase.getOpenMode() == null;
            }
            case 11: {
                return pSUWAppFuncBase.getPageUrl() == null;
            }
            case 12: {
                return pSUWAppFuncBase.getPSAppFuncId() == null;
            }
            case 13: {
                return pSUWAppFuncBase.getPSAppFuncName() == null;
            }
            case 14: {
                return pSUWAppFuncBase.getPSAppIndexViewId() == null;
            }
            case 15: {
                return pSUWAppFuncBase.getPSAppIndexViewName() == null;
            }
            case 16: {
                return pSUWAppFuncBase.getPSAppModuleId() == null;
            }
            case 17: {
                return pSUWAppFuncBase.getPSAppModuleName() == null;
            }
            case 18: {
                return pSUWAppFuncBase.getPSAppPortalViewId() == null;
            }
            case 19: {
                return pSUWAppFuncBase.getPSAppPortalViewName() == null;
            }
            case 20: {
                return pSUWAppFuncBase.getPSAppViewId() == null;
            }
            case 21: {
                return pSUWAppFuncBase.getPSAppViewName() == null;
            }
            case 22: {
                return pSUWAppFuncBase.getPSDEId() == null;
            }
            case 23: {
                return pSUWAppFuncBase.getPSDEName() == null;
            }
            case 24: {
                return pSUWAppFuncBase.getPSDEViewBaseId() == null;
            }
            case 25: {
                return pSUWAppFuncBase.getPSDEViewBaseName() == null;
            }
            case 26: {
                return pSUWAppFuncBase.getPSDynaInstId() == null;
            }
            case 27: {
                return pSUWAppFuncBase.getPSPDTAppFuncId() == null;
            }
            case 28: {
                return pSUWAppFuncBase.getPSPDTAppFuncName() == null;
            }
            case 29: {
                return pSUWAppFuncBase.getPSSysAppId() == null;
            }
            case 30: {
                return pSUWAppFuncBase.getPSUWAppFuncId() == null;
            }
            case 31: {
                return pSUWAppFuncBase.getPSUWAppFuncName() == null;
            }
            case 32: {
                return pSUWAppFuncBase.getSRFNextForm() == null;
            }
            case 33: {
                return pSUWAppFuncBase.getTooltipInfo() == null;
            }
            case 34: {
                return pSUWAppFuncBase.getUpdateDate() == null;
            }
            case 35: {
                return pSUWAppFuncBase.getUpdateMan() == null;
            }
            case 36: {
                return pSUWAppFuncBase.getWizardMode() == null;
            }
            case 37: {
                return pSUWAppFuncBase.getWizardParam() == null;
            }
            case 38: {
                return pSUWAppFuncBase.getWizardParam2() == null;
            }
            case 39: {
                return pSUWAppFuncBase.getWizardParam3() == null;
            }
            case 40: {
                return pSUWAppFuncBase.getWizardParam4() == null;
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
        return PSUWAppFuncBase.contains(this, n);
    }

    private static boolean contains(PSUWAppFuncBase pSUWAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWAppFuncBase.isAppFuncTypeDirty();
            }
            case 1: {
                return pSUWAppFuncBase.isAppFuncTypeNameDirty();
            }
            case 2: {
                return pSUWAppFuncBase.isAppViewTypeDirty();
            }
            case 3: {
                return pSUWAppFuncBase.isCaptionDirty();
            }
            case 4: {
                return pSUWAppFuncBase.isCreateDateDirty();
            }
            case 5: {
                return pSUWAppFuncBase.isCreateManDirty();
            }
            case 6: {
                return pSUWAppFuncBase.isDynaInstTagDirty();
            }
            case 7: {
                return pSUWAppFuncBase.isDynaInstTag2Dirty();
            }
            case 8: {
                return pSUWAppFuncBase.isJSCodeDirty();
            }
            case 9: {
                return pSUWAppFuncBase.isMemoDirty();
            }
            case 10: {
                return pSUWAppFuncBase.isOpenModeDirty();
            }
            case 11: {
                return pSUWAppFuncBase.isPageUrlDirty();
            }
            case 12: {
                return pSUWAppFuncBase.isPSAppFuncIdDirty();
            }
            case 13: {
                return pSUWAppFuncBase.isPSAppFuncNameDirty();
            }
            case 14: {
                return pSUWAppFuncBase.isPSAppIndexViewIdDirty();
            }
            case 15: {
                return pSUWAppFuncBase.isPSAppIndexViewNameDirty();
            }
            case 16: {
                return pSUWAppFuncBase.isPSAppModuleIdDirty();
            }
            case 17: {
                return pSUWAppFuncBase.isPSAppModuleNameDirty();
            }
            case 18: {
                return pSUWAppFuncBase.isPSAppPortalViewIdDirty();
            }
            case 19: {
                return pSUWAppFuncBase.isPSAppPortalViewNameDirty();
            }
            case 20: {
                return pSUWAppFuncBase.isPSAppViewIdDirty();
            }
            case 21: {
                return pSUWAppFuncBase.isPSAppViewNameDirty();
            }
            case 22: {
                return pSUWAppFuncBase.isPSDEIdDirty();
            }
            case 23: {
                return pSUWAppFuncBase.isPSDENameDirty();
            }
            case 24: {
                return pSUWAppFuncBase.isPSDEViewBaseIdDirty();
            }
            case 25: {
                return pSUWAppFuncBase.isPSDEViewBaseNameDirty();
            }
            case 26: {
                return pSUWAppFuncBase.isPSDynaInstIdDirty();
            }
            case 27: {
                return pSUWAppFuncBase.isPSPDTAppFuncIdDirty();
            }
            case 28: {
                return pSUWAppFuncBase.isPSPDTAppFuncNameDirty();
            }
            case 29: {
                return pSUWAppFuncBase.isPSSysAppIdDirty();
            }
            case 30: {
                return pSUWAppFuncBase.isPSUWAppFuncIdDirty();
            }
            case 31: {
                return pSUWAppFuncBase.isPSUWAppFuncNameDirty();
            }
            case 32: {
                return pSUWAppFuncBase.isSRFNextFormDirty();
            }
            case 33: {
                return pSUWAppFuncBase.isTooltipInfoDirty();
            }
            case 34: {
                return pSUWAppFuncBase.isUpdateDateDirty();
            }
            case 35: {
                return pSUWAppFuncBase.isUpdateManDirty();
            }
            case 36: {
                return pSUWAppFuncBase.isWizardModeDirty();
            }
            case 37: {
                return pSUWAppFuncBase.isWizardParamDirty();
            }
            case 38: {
                return pSUWAppFuncBase.isWizardParam2Dirty();
            }
            case 39: {
                return pSUWAppFuncBase.isWizardParam3Dirty();
            }
            case 40: {
                return pSUWAppFuncBase.isWizardParam4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWAppFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWAppFuncBase pSUWAppFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWAppFuncBase.getAppFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfunctype", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getAppFuncType()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getAppFuncTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appfunctypename", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getAppFuncTypeName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getAppViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appviewtype", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getAppViewType()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getCaption()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getDynaInstTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getDynaInstTag()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getDynaInstTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynainsttag2", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getDynaInstTag2()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getJSCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jscode", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getJSCode()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getOpenMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openmode", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getOpenMode()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pageurl", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPageUrl()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppFuncId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappfuncname", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppFuncName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppIndexViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappindexviewid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppIndexViewId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppIndexViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappindexviewname", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppIndexViewName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulename", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppModuleName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppPortalViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportalviewid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppPortalViewId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppPortalViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappportalviewname", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppPortalViewName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSPDTAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtappfuncid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSPDTAppFuncId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSPDTAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtappfuncname", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSPDTAppFuncName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSUWAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwappfuncid", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSUWAppFuncId()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getPSUWAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwappfuncname", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getPSUWAppFuncName()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getSRFNextForm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfnextform", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getSRFNextForm()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUWAppFuncBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUWAppFuncBase.getJSONValue((Object)pSUWAppFuncBase.getWizardParam4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWAppFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWAppFuncBase pSUWAppFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWAppFuncBase.getAppFuncType() != null) {
            object = pSUWAppFuncBase.getAppFuncType();
            xmlNode.setAttribute(FIELD_APPFUNCTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAppFuncBase.getAppFuncTypeName() != null) {
            object = pSUWAppFuncBase.getAppFuncTypeName();
            xmlNode.setAttribute(FIELD_APPFUNCTYPENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAppFuncBase.getAppViewType() != null) {
            object = pSUWAppFuncBase.getAppViewType();
            xmlNode.setAttribute(FIELD_APPVIEWTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSUWAppFuncBase.getCaption() != null) {
            object = pSUWAppFuncBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getCreateDate() != null) {
            object = pSUWAppFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAppFuncBase.getCreateMan() != null) {
            object = pSUWAppFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getDynaInstTag() != null) {
            object = pSUWAppFuncBase.getDynaInstTag();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getDynaInstTag2() != null) {
            object = pSUWAppFuncBase.getDynaInstTag2();
            xmlNode.setAttribute(FIELD_DYNAINSTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getJSCode() != null) {
            object = pSUWAppFuncBase.getJSCode();
            xmlNode.setAttribute(FIELD_JSCODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getMemo() != null) {
            object = pSUWAppFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getOpenMode() != null) {
            object = pSUWAppFuncBase.getOpenMode();
            xmlNode.setAttribute(FIELD_OPENMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPageUrl() != null) {
            object = pSUWAppFuncBase.getPageUrl();
            xmlNode.setAttribute(FIELD_PAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppFuncId() != null) {
            object = pSUWAppFuncBase.getPSAppFuncId();
            xmlNode.setAttribute(FIELD_PSAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppFuncName() != null) {
            object = pSUWAppFuncBase.getPSAppFuncName();
            xmlNode.setAttribute(FIELD_PSAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppIndexViewId() != null) {
            object = pSUWAppFuncBase.getPSAppIndexViewId();
            xmlNode.setAttribute(FIELD_PSAPPINDEXVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppIndexViewName() != null) {
            object = pSUWAppFuncBase.getPSAppIndexViewName();
            xmlNode.setAttribute(FIELD_PSAPPINDEXVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppModuleId() != null) {
            object = pSUWAppFuncBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppModuleName() != null) {
            object = pSUWAppFuncBase.getPSAppModuleName();
            xmlNode.setAttribute(FIELD_PSAPPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppPortalViewId() != null) {
            object = pSUWAppFuncBase.getPSAppPortalViewId();
            xmlNode.setAttribute(FIELD_PSAPPPORTALVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppPortalViewName() != null) {
            object = pSUWAppFuncBase.getPSAppPortalViewName();
            xmlNode.setAttribute(FIELD_PSAPPPORTALVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppViewId() != null) {
            object = pSUWAppFuncBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSAppViewName() != null) {
            object = pSUWAppFuncBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSDEId() != null) {
            object = pSUWAppFuncBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSDEName() != null) {
            object = pSUWAppFuncBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSDEViewBaseId() != null) {
            object = pSUWAppFuncBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSDEViewBaseName() != null) {
            object = pSUWAppFuncBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSDynaInstId() != null) {
            object = pSUWAppFuncBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSPDTAppFuncId() != null) {
            object = pSUWAppFuncBase.getPSPDTAppFuncId();
            xmlNode.setAttribute(FIELD_PSPDTAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSPDTAppFuncName() != null) {
            object = pSUWAppFuncBase.getPSPDTAppFuncName();
            xmlNode.setAttribute(FIELD_PSPDTAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSSysAppId() != null) {
            object = pSUWAppFuncBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSUWAppFuncId() != null) {
            object = pSUWAppFuncBase.getPSUWAppFuncId();
            xmlNode.setAttribute(FIELD_PSUWAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getPSUWAppFuncName() != null) {
            object = pSUWAppFuncBase.getPSUWAppFuncName();
            xmlNode.setAttribute(FIELD_PSUWAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getSRFNextForm() != null) {
            object = pSUWAppFuncBase.getSRFNextForm();
            xmlNode.setAttribute(FIELD_SRFNEXTFORM, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getTooltipInfo() != null) {
            object = pSUWAppFuncBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getUpdateDate() != null) {
            object = pSUWAppFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWAppFuncBase.getUpdateMan() != null) {
            object = pSUWAppFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getWizardMode() != null) {
            object = pSUWAppFuncBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getWizardParam() != null) {
            object = pSUWAppFuncBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getWizardParam2() != null) {
            object = pSUWAppFuncBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWAppFuncBase.getWizardParam3() != null) {
            object = pSUWAppFuncBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWAppFuncBase.getWizardParam4() != null) {
            object = pSUWAppFuncBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWAppFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWAppFuncBase pSUWAppFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWAppFuncBase.isAppFuncTypeDirty() && (bl || pSUWAppFuncBase.getAppFuncType() != null)) {
            iDataObject.set(FIELD_APPFUNCTYPE, (Object)pSUWAppFuncBase.getAppFuncType());
        }
        if (pSUWAppFuncBase.isAppFuncTypeNameDirty() && (bl || pSUWAppFuncBase.getAppFuncTypeName() != null)) {
            iDataObject.set(FIELD_APPFUNCTYPENAME, (Object)pSUWAppFuncBase.getAppFuncTypeName());
        }
        if (pSUWAppFuncBase.isAppViewTypeDirty() && (bl || pSUWAppFuncBase.getAppViewType() != null)) {
            iDataObject.set(FIELD_APPVIEWTYPE, (Object)pSUWAppFuncBase.getAppViewType());
        }
        if (pSUWAppFuncBase.isCaptionDirty() && (bl || pSUWAppFuncBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSUWAppFuncBase.getCaption());
        }
        if (pSUWAppFuncBase.isCreateDateDirty() && (bl || pSUWAppFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWAppFuncBase.getCreateDate());
        }
        if (pSUWAppFuncBase.isCreateManDirty() && (bl || pSUWAppFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWAppFuncBase.getCreateMan());
        }
        if (pSUWAppFuncBase.isDynaInstTagDirty() && (bl || pSUWAppFuncBase.getDynaInstTag() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG, (Object)pSUWAppFuncBase.getDynaInstTag());
        }
        if (pSUWAppFuncBase.isDynaInstTag2Dirty() && (bl || pSUWAppFuncBase.getDynaInstTag2() != null)) {
            iDataObject.set(FIELD_DYNAINSTTAG2, (Object)pSUWAppFuncBase.getDynaInstTag2());
        }
        if (pSUWAppFuncBase.isJSCodeDirty() && (bl || pSUWAppFuncBase.getJSCode() != null)) {
            iDataObject.set(FIELD_JSCODE, (Object)pSUWAppFuncBase.getJSCode());
        }
        if (pSUWAppFuncBase.isMemoDirty() && (bl || pSUWAppFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUWAppFuncBase.getMemo());
        }
        if (pSUWAppFuncBase.isOpenModeDirty() && (bl || pSUWAppFuncBase.getOpenMode() != null)) {
            iDataObject.set(FIELD_OPENMODE, (Object)pSUWAppFuncBase.getOpenMode());
        }
        if (pSUWAppFuncBase.isPageUrlDirty() && (bl || pSUWAppFuncBase.getPageUrl() != null)) {
            iDataObject.set(FIELD_PAGEURL, (Object)pSUWAppFuncBase.getPageUrl());
        }
        if (pSUWAppFuncBase.isPSAppFuncIdDirty() && (bl || pSUWAppFuncBase.getPSAppFuncId() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCID, (Object)pSUWAppFuncBase.getPSAppFuncId());
        }
        if (pSUWAppFuncBase.isPSAppFuncNameDirty() && (bl || pSUWAppFuncBase.getPSAppFuncName() != null)) {
            iDataObject.set(FIELD_PSAPPFUNCNAME, (Object)pSUWAppFuncBase.getPSAppFuncName());
        }
        if (pSUWAppFuncBase.isPSAppIndexViewIdDirty() && (bl || pSUWAppFuncBase.getPSAppIndexViewId() != null)) {
            iDataObject.set(FIELD_PSAPPINDEXVIEWID, (Object)pSUWAppFuncBase.getPSAppIndexViewId());
        }
        if (pSUWAppFuncBase.isPSAppIndexViewNameDirty() && (bl || pSUWAppFuncBase.getPSAppIndexViewName() != null)) {
            iDataObject.set(FIELD_PSAPPINDEXVIEWNAME, (Object)pSUWAppFuncBase.getPSAppIndexViewName());
        }
        if (pSUWAppFuncBase.isPSAppModuleIdDirty() && (bl || pSUWAppFuncBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSUWAppFuncBase.getPSAppModuleId());
        }
        if (pSUWAppFuncBase.isPSAppModuleNameDirty() && (bl || pSUWAppFuncBase.getPSAppModuleName() != null)) {
            iDataObject.set(FIELD_PSAPPMODULENAME, (Object)pSUWAppFuncBase.getPSAppModuleName());
        }
        if (pSUWAppFuncBase.isPSAppPortalViewIdDirty() && (bl || pSUWAppFuncBase.getPSAppPortalViewId() != null)) {
            iDataObject.set(FIELD_PSAPPPORTALVIEWID, (Object)pSUWAppFuncBase.getPSAppPortalViewId());
        }
        if (pSUWAppFuncBase.isPSAppPortalViewNameDirty() && (bl || pSUWAppFuncBase.getPSAppPortalViewName() != null)) {
            iDataObject.set(FIELD_PSAPPPORTALVIEWNAME, (Object)pSUWAppFuncBase.getPSAppPortalViewName());
        }
        if (pSUWAppFuncBase.isPSAppViewIdDirty() && (bl || pSUWAppFuncBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSUWAppFuncBase.getPSAppViewId());
        }
        if (pSUWAppFuncBase.isPSAppViewNameDirty() && (bl || pSUWAppFuncBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSUWAppFuncBase.getPSAppViewName());
        }
        if (pSUWAppFuncBase.isPSDEIdDirty() && (bl || pSUWAppFuncBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWAppFuncBase.getPSDEId());
        }
        if (pSUWAppFuncBase.isPSDENameDirty() && (bl || pSUWAppFuncBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSUWAppFuncBase.getPSDEName());
        }
        if (pSUWAppFuncBase.isPSDEViewBaseIdDirty() && (bl || pSUWAppFuncBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSUWAppFuncBase.getPSDEViewBaseId());
        }
        if (pSUWAppFuncBase.isPSDEViewBaseNameDirty() && (bl || pSUWAppFuncBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSUWAppFuncBase.getPSDEViewBaseName());
        }
        if (pSUWAppFuncBase.isPSDynaInstIdDirty() && (bl || pSUWAppFuncBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWAppFuncBase.getPSDynaInstId());
        }
        if (pSUWAppFuncBase.isPSPDTAppFuncIdDirty() && (bl || pSUWAppFuncBase.getPSPDTAppFuncId() != null)) {
            iDataObject.set(FIELD_PSPDTAPPFUNCID, (Object)pSUWAppFuncBase.getPSPDTAppFuncId());
        }
        if (pSUWAppFuncBase.isPSPDTAppFuncNameDirty() && (bl || pSUWAppFuncBase.getPSPDTAppFuncName() != null)) {
            iDataObject.set(FIELD_PSPDTAPPFUNCNAME, (Object)pSUWAppFuncBase.getPSPDTAppFuncName());
        }
        if (pSUWAppFuncBase.isPSSysAppIdDirty() && (bl || pSUWAppFuncBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSUWAppFuncBase.getPSSysAppId());
        }
        if (pSUWAppFuncBase.isPSUWAppFuncIdDirty() && (bl || pSUWAppFuncBase.getPSUWAppFuncId() != null)) {
            iDataObject.set(FIELD_PSUWAPPFUNCID, (Object)pSUWAppFuncBase.getPSUWAppFuncId());
        }
        if (pSUWAppFuncBase.isPSUWAppFuncNameDirty() && (bl || pSUWAppFuncBase.getPSUWAppFuncName() != null)) {
            iDataObject.set(FIELD_PSUWAPPFUNCNAME, (Object)pSUWAppFuncBase.getPSUWAppFuncName());
        }
        if (pSUWAppFuncBase.isSRFNextFormDirty() && (bl || pSUWAppFuncBase.getSRFNextForm() != null)) {
            iDataObject.set(FIELD_SRFNEXTFORM, (Object)pSUWAppFuncBase.getSRFNextForm());
        }
        if (pSUWAppFuncBase.isTooltipInfoDirty() && (bl || pSUWAppFuncBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSUWAppFuncBase.getTooltipInfo());
        }
        if (pSUWAppFuncBase.isUpdateDateDirty() && (bl || pSUWAppFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWAppFuncBase.getUpdateDate());
        }
        if (pSUWAppFuncBase.isUpdateManDirty() && (bl || pSUWAppFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWAppFuncBase.getUpdateMan());
        }
        if (pSUWAppFuncBase.isWizardModeDirty() && (bl || pSUWAppFuncBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWAppFuncBase.getWizardMode());
        }
        if (pSUWAppFuncBase.isWizardParamDirty() && (bl || pSUWAppFuncBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUWAppFuncBase.getWizardParam());
        }
        if (pSUWAppFuncBase.isWizardParam2Dirty() && (bl || pSUWAppFuncBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUWAppFuncBase.getWizardParam2());
        }
        if (pSUWAppFuncBase.isWizardParam3Dirty() && (bl || pSUWAppFuncBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUWAppFuncBase.getWizardParam3());
        }
        if (pSUWAppFuncBase.isWizardParam4Dirty() && (bl || pSUWAppFuncBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUWAppFuncBase.getWizardParam4());
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
        return PSUWAppFuncBase.remove(this, n);
    }

    private static boolean remove(PSUWAppFuncBase pSUWAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWAppFuncBase.resetAppFuncType();
                return true;
            }
            case 1: {
                pSUWAppFuncBase.resetAppFuncTypeName();
                return true;
            }
            case 2: {
                pSUWAppFuncBase.resetAppViewType();
                return true;
            }
            case 3: {
                pSUWAppFuncBase.resetCaption();
                return true;
            }
            case 4: {
                pSUWAppFuncBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSUWAppFuncBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSUWAppFuncBase.resetDynaInstTag();
                return true;
            }
            case 7: {
                pSUWAppFuncBase.resetDynaInstTag2();
                return true;
            }
            case 8: {
                pSUWAppFuncBase.resetJSCode();
                return true;
            }
            case 9: {
                pSUWAppFuncBase.resetMemo();
                return true;
            }
            case 10: {
                pSUWAppFuncBase.resetOpenMode();
                return true;
            }
            case 11: {
                pSUWAppFuncBase.resetPageUrl();
                return true;
            }
            case 12: {
                pSUWAppFuncBase.resetPSAppFuncId();
                return true;
            }
            case 13: {
                pSUWAppFuncBase.resetPSAppFuncName();
                return true;
            }
            case 14: {
                pSUWAppFuncBase.resetPSAppIndexViewId();
                return true;
            }
            case 15: {
                pSUWAppFuncBase.resetPSAppIndexViewName();
                return true;
            }
            case 16: {
                pSUWAppFuncBase.resetPSAppModuleId();
                return true;
            }
            case 17: {
                pSUWAppFuncBase.resetPSAppModuleName();
                return true;
            }
            case 18: {
                pSUWAppFuncBase.resetPSAppPortalViewId();
                return true;
            }
            case 19: {
                pSUWAppFuncBase.resetPSAppPortalViewName();
                return true;
            }
            case 20: {
                pSUWAppFuncBase.resetPSAppViewId();
                return true;
            }
            case 21: {
                pSUWAppFuncBase.resetPSAppViewName();
                return true;
            }
            case 22: {
                pSUWAppFuncBase.resetPSDEId();
                return true;
            }
            case 23: {
                pSUWAppFuncBase.resetPSDEName();
                return true;
            }
            case 24: {
                pSUWAppFuncBase.resetPSDEViewBaseId();
                return true;
            }
            case 25: {
                pSUWAppFuncBase.resetPSDEViewBaseName();
                return true;
            }
            case 26: {
                pSUWAppFuncBase.resetPSDynaInstId();
                return true;
            }
            case 27: {
                pSUWAppFuncBase.resetPSPDTAppFuncId();
                return true;
            }
            case 28: {
                pSUWAppFuncBase.resetPSPDTAppFuncName();
                return true;
            }
            case 29: {
                pSUWAppFuncBase.resetPSSysAppId();
                return true;
            }
            case 30: {
                pSUWAppFuncBase.resetPSUWAppFuncId();
                return true;
            }
            case 31: {
                pSUWAppFuncBase.resetPSUWAppFuncName();
                return true;
            }
            case 32: {
                pSUWAppFuncBase.resetSRFNextForm();
                return true;
            }
            case 33: {
                pSUWAppFuncBase.resetTooltipInfo();
                return true;
            }
            case 34: {
                pSUWAppFuncBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSUWAppFuncBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSUWAppFuncBase.resetWizardMode();
                return true;
            }
            case 37: {
                pSUWAppFuncBase.resetWizardParam();
                return true;
            }
            case 38: {
                pSUWAppFuncBase.resetWizardParam2();
                return true;
            }
            case 39: {
                pSUWAppFuncBase.resetWizardParam3();
                return true;
            }
            case 40: {
                pSUWAppFuncBase.resetWizardParam4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWAppFuncBase getProxyEntity() {
        return this.proxyPSUWAppFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWAppFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWAppFuncBase) {
            this.proxyPSUWAppFuncBase = (PSUWAppFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWAppFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPFUNCTYPE, 0);
        fieldIndexMap.put(FIELD_APPFUNCTYPENAME, 1);
        fieldIndexMap.put(FIELD_APPVIEWTYPE, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DYNAINSTTAG, 6);
        fieldIndexMap.put(FIELD_DYNAINSTTAG2, 7);
        fieldIndexMap.put(FIELD_JSCODE, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_OPENMODE, 10);
        fieldIndexMap.put(FIELD_PAGEURL, 11);
        fieldIndexMap.put(FIELD_PSAPPFUNCID, 12);
        fieldIndexMap.put(FIELD_PSAPPFUNCNAME, 13);
        fieldIndexMap.put(FIELD_PSAPPINDEXVIEWID, 14);
        fieldIndexMap.put(FIELD_PSAPPINDEXVIEWNAME, 15);
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 16);
        fieldIndexMap.put(FIELD_PSAPPMODULENAME, 17);
        fieldIndexMap.put(FIELD_PSAPPPORTALVIEWID, 18);
        fieldIndexMap.put(FIELD_PSAPPPORTALVIEWNAME, 19);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 20);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 21);
        fieldIndexMap.put(FIELD_PSDEID, 22);
        fieldIndexMap.put(FIELD_PSDENAME, 23);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 24);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 25);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 26);
        fieldIndexMap.put(FIELD_PSPDTAPPFUNCID, 27);
        fieldIndexMap.put(FIELD_PSPDTAPPFUNCNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 29);
        fieldIndexMap.put(FIELD_PSUWAPPFUNCID, 30);
        fieldIndexMap.put(FIELD_PSUWAPPFUNCNAME, 31);
        fieldIndexMap.put(FIELD_SRFNEXTFORM, 32);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_WIZARDMODE, 36);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 37);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 38);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 39);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 40);
    }
}

