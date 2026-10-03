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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContentCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysResourceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysResourceBase.class);
    public static final String FIELD_AUTHACCESSTOKENURI = "AUTHACCESSTOKENURI";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String FIELD_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String FIELD_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String FIELD_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NAMEPSDEFID = "NAMEPSDEFID";
    public static final String FIELD_NAMEPSDEFNAME = "NAMEPSDEFNAME";
    public static final String FIELD_PATHPSDEFID = "PATHPSDEFID";
    public static final String FIELD_PATHPSDEFNAME = "PATHPSDEFNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCONTENTCATID = "PSSYSCONTENTCATID";
    public static final String FIELD_PSSYSCONTENTCATNAME = "PSSYSCONTENTCATNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RESOURCEPARAMS = "RESOURCEPARAMS";
    public static final String FIELD_RESOURCETYPE = "RESOURCETYPE";
    public static final String FIELD_RESOURCEURI = "RESOURCEURI";
    public static final String FIELD_RESTAG = "RESTAG";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_TAGPSDEFID = "TAGPSDEFID";
    public static final String FIELD_TAGPSDEFNAME = "TAGPSDEFNAME";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USER2PSDEFID = "USER2PSDEFID";
    public static final String FIELD_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPSDEFID = "USERPSDEFID";
    public static final String FIELD_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AUTHACCESSTOKENURI = 0;
    private static final int INDEX_AUTHCLIENTID = 1;
    private static final int INDEX_AUTHCLIENTSECRET = 2;
    private static final int INDEX_AUTHMODE = 3;
    private static final int INDEX_AUTHPARAM = 4;
    private static final int INDEX_AUTHPARAM2 = 5;
    private static final int INDEX_CONTENT = 6;
    private static final int INDEX_CONTENTPSDEFID = 7;
    private static final int INDEX_CONTENTPSDEFNAME = 8;
    private static final int INDEX_CONTENTPSLANRESID = 9;
    private static final int INDEX_CONTENTPSLANRESNAME = 10;
    private static final int INDEX_CREATEDATE = 11;
    private static final int INDEX_CREATEMAN = 12;
    private static final int INDEX_CUSTOMCODE = 13;
    private static final int INDEX_CUSTOMMODE = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_NAMEPSDEFID = 16;
    private static final int INDEX_NAMEPSDEFNAME = 17;
    private static final int INDEX_PATHPSDEFID = 18;
    private static final int INDEX_PATHPSDEFNAME = 19;
    private static final int INDEX_PSDEDSID = 20;
    private static final int INDEX_PSDEDSNAME = 21;
    private static final int INDEX_PSDEID = 22;
    private static final int INDEX_PSDENAME = 23;
    private static final int INDEX_PSMODULEID = 24;
    private static final int INDEX_PSMODULENAME = 25;
    private static final int INDEX_PSSYSCONTENTCATID = 26;
    private static final int INDEX_PSSYSCONTENTCATNAME = 27;
    private static final int INDEX_PSSYSRESOURCEID = 28;
    private static final int INDEX_PSSYSRESOURCENAME = 29;
    private static final int INDEX_PSSYSSFPLUGINID = 30;
    private static final int INDEX_PSSYSSFPLUGINNAME = 31;
    private static final int INDEX_PSSYSTEMID = 32;
    private static final int INDEX_PSSYSTEMNAME = 33;
    private static final int INDEX_RESOURCEPARAMS = 34;
    private static final int INDEX_RESOURCETYPE = 35;
    private static final int INDEX_RESOURCEURI = 36;
    private static final int INDEX_RESTAG = 37;
    private static final int INDEX_SUBJECT = 38;
    private static final int INDEX_TAGPSDEFID = 39;
    private static final int INDEX_TAGPSDEFNAME = 40;
    private static final int INDEX_TAGS = 41;
    private static final int INDEX_UPDATEDATE = 42;
    private static final int INDEX_UPDATEMAN = 43;
    private static final int INDEX_USER2PSDEFID = 44;
    private static final int INDEX_USER2PSDEFNAME = 45;
    private static final int INDEX_USERCAT = 46;
    private static final int INDEX_USERPSDEFID = 47;
    private static final int INDEX_USERPSDEFNAME = 48;
    private static final int INDEX_USERTAG = 49;
    private static final int INDEX_USERTAG2 = 50;
    private static final int INDEX_USERTAG3 = 51;
    private static final int INDEX_USERTAG4 = 52;
    private static final int INDEX_VALIDFLAG = 53;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysResourceBase proxyPSSysResourceBase = null;
    private boolean authaccesstokenuriDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean contentpsdefidDirtyFlag = false;
    private boolean contentpsdefnameDirtyFlag = false;
    private boolean contentpslanresidDirtyFlag = false;
    private boolean contentpslanresnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean namepsdefidDirtyFlag = false;
    private boolean namepsdefnameDirtyFlag = false;
    private boolean pathpsdefidDirtyFlag = false;
    private boolean pathpsdefnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscontentcatidDirtyFlag = false;
    private boolean pssyscontentcatnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean resourceparamsDirtyFlag = false;
    private boolean resourcetypeDirtyFlag = false;
    private boolean resourceuriDirtyFlag = false;
    private boolean restagDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean tagpsdefidDirtyFlag = false;
    private boolean tagpsdefnameDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean user2psdefidDirtyFlag = false;
    private boolean user2psdefnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userpsdefidDirtyFlag = false;
    private boolean userpsdefnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="authaccesstokenuri")
    private String authaccesstokenuri;
    @Column(name="authclientid")
    private String authclientid;
    @Column(name="authclientsecret")
    private String authclientsecret;
    @Column(name="authmode")
    private String authmode;
    @Column(name="authparam")
    private String authparam;
    @Column(name="authparam2")
    private String authparam2;
    @Column(name="content")
    private String content;
    @Column(name="contentpsdefid")
    private String contentpsdefid;
    @Column(name="contentpsdefname")
    private String contentpsdefname;
    @Column(name="contentpslanresid")
    private String contentpslanresid;
    @Column(name="contentpslanresname")
    private String contentpslanresname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="memo")
    private String memo;
    @Column(name="namepsdefid")
    private String namepsdefid;
    @Column(name="namepsdefname")
    private String namepsdefname;
    @Column(name="pathpsdefid")
    private String pathpsdefid;
    @Column(name="pathpsdefname")
    private String pathpsdefname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscontentcatid")
    private String pssyscontentcatid;
    @Column(name="pssyscontentcatname")
    private String pssyscontentcatname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="resourceparams")
    private String resourceparams;
    @Column(name="resourcetype")
    private String resourcetype;
    @Column(name="resourceuri")
    private String resourceuri;
    @Column(name="restag")
    private String restag;
    @Column(name="subject")
    private String subject;
    @Column(name="tagpsdefid")
    private String tagpsdefid;
    @Column(name="tagpsdefname")
    private String tagpsdefname;
    @Column(name="tags")
    private String tags;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="user2psdefid")
    private String user2psdefid;
    @Column(name="user2psdefname")
    private String user2psdefname;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userpsdefid")
    private String userpsdefid;
    @Column(name="userpsdefname")
    private String userpsdefname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objContentPSDEFLock = new Integer(1);
    private PSDEField contentpsdef = null;
    private Integer objNamePSDEFLock = new Integer(1);
    private PSDEField namepsdef = null;
    private Integer objPathPSDEFLock = new Integer(1);
    private PSDEField pathpsdef = null;
    private Integer objTagPSDEFLock = new Integer(1);
    private PSDEField tagpsdef = null;
    private Integer objUser2PSDEFLock = new Integer(1);
    private PSDEField user2psdef = null;
    private Integer objUserPSDEFLock = new Integer(1);
    private PSDEField userpsdef = null;
    private Integer objContentPSLanResLock = new Integer(1);
    private PSLanguageRes contentpslanres = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysContentCatLock = new Integer(1);
    private PSSysContentCat pssyscontentcat = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setAuthAccessTokenUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthAccessTokenUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authaccesstokenuri = string;
        this.authaccesstokenuriDirtyFlag = true;
    }

    public String getAuthAccessTokenUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthAccessTokenUri();
        }
        return this.authaccesstokenuri;
    }

    public boolean isAuthAccessTokenUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthAccessTokenUriDirty();
        }
        return this.authaccesstokenuriDirtyFlag;
    }

    public void resetAuthAccessTokenUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthAccessTokenUri();
            return;
        }
        this.authaccesstokenuriDirtyFlag = false;
        this.authaccesstokenuri = null;
    }

    public void setAuthClientId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientid = string;
        this.authclientidDirtyFlag = true;
    }

    public String getAuthClientId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientId();
        }
        return this.authclientid;
    }

    public boolean isAuthClientIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientIdDirty();
        }
        return this.authclientidDirtyFlag;
    }

    public void resetAuthClientId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientId();
            return;
        }
        this.authclientidDirtyFlag = false;
        this.authclientid = null;
    }

    public void setAuthClientSecret(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientSecret(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientsecret = string;
        this.authclientsecretDirtyFlag = true;
    }

    public String getAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientSecret();
        }
        return this.authclientsecret;
    }

    public boolean isAuthClientSecretDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientSecretDirty();
        }
        return this.authclientsecretDirtyFlag;
    }

    public void resetAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientSecret();
            return;
        }
        this.authclientsecretDirtyFlag = false;
        this.authclientsecret = null;
    }

    public void setAuthMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authmode = string;
        this.authmodeDirtyFlag = true;
    }

    public String getAuthMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthMode();
        }
        return this.authmode;
    }

    public boolean isAuthModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthModeDirty();
        }
        return this.authmodeDirtyFlag;
    }

    public void resetAuthMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthMode();
            return;
        }
        this.authmodeDirtyFlag = false;
        this.authmode = null;
    }

    public void setAuthParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam = string;
        this.authparamDirtyFlag = true;
    }

    public String getAuthParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam();
        }
        return this.authparam;
    }

    public boolean isAuthParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParamDirty();
        }
        return this.authparamDirtyFlag;
    }

    public void resetAuthParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam();
            return;
        }
        this.authparamDirtyFlag = false;
        this.authparam = null;
    }

    public void setAuthParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam2 = string;
        this.authparam2DirtyFlag = true;
    }

    public String getAuthParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam2();
        }
        return this.authparam2;
    }

    public boolean isAuthParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParam2Dirty();
        }
        return this.authparam2DirtyFlag;
    }

    public void resetAuthParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam2();
            return;
        }
        this.authparam2DirtyFlag = false;
        this.authparam2 = null;
    }

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
    }

    public void setContentPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefid = string;
        this.contentpsdefidDirtyFlag = true;
    }

    public String getContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFId();
        }
        return this.contentpsdefid;
    }

    public boolean isContentPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFIdDirty();
        }
        return this.contentpsdefidDirtyFlag;
    }

    public void resetContentPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFId();
            return;
        }
        this.contentpsdefidDirtyFlag = false;
        this.contentpsdefid = null;
    }

    public void setContentPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpsdefname = string;
        this.contentpsdefnameDirtyFlag = true;
    }

    public String getContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEFName();
        }
        return this.contentpsdefname;
    }

    public boolean isContentPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSDEFNameDirty();
        }
        return this.contentpsdefnameDirtyFlag;
    }

    public void resetContentPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSDEFName();
            return;
        }
        this.contentpsdefnameDirtyFlag = false;
        this.contentpsdefname = null;
    }

    public void setContentPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresid = string;
        this.contentpslanresidDirtyFlag = true;
    }

    public String getContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResId();
        }
        return this.contentpslanresid;
    }

    public boolean isContentPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResIdDirty();
        }
        return this.contentpslanresidDirtyFlag;
    }

    public void resetContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResId();
            return;
        }
        this.contentpslanresidDirtyFlag = false;
        this.contentpslanresid = null;
    }

    public void setContentPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresname = string;
        this.contentpslanresnameDirtyFlag = true;
    }

    public String getContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResName();
        }
        return this.contentpslanresname;
    }

    public boolean isContentPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResNameDirty();
        }
        return this.contentpslanresnameDirtyFlag;
    }

    public void resetContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResName();
            return;
        }
        this.contentpslanresnameDirtyFlag = false;
        this.contentpslanresname = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
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

    public void setNamePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepsdefid = string;
        this.namepsdefidDirtyFlag = true;
    }

    public String getNamePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSDEFId();
        }
        return this.namepsdefid;
    }

    public boolean isNamePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSDEFIdDirty();
        }
        return this.namepsdefidDirtyFlag;
    }

    public void resetNamePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSDEFId();
            return;
        }
        this.namepsdefidDirtyFlag = false;
        this.namepsdefid = null;
    }

    public void setNamePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNamePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.namepsdefname = string;
        this.namepsdefnameDirtyFlag = true;
    }

    public String getNamePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSDEFName();
        }
        return this.namepsdefname;
    }

    public boolean isNamePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNamePSDEFNameDirty();
        }
        return this.namepsdefnameDirtyFlag;
    }

    public void resetNamePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNamePSDEFName();
            return;
        }
        this.namepsdefnameDirtyFlag = false;
        this.namepsdefname = null;
    }

    public void setPathPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPathPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pathpsdefid = string;
        this.pathpsdefidDirtyFlag = true;
    }

    public String getPathPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPathPSDEFId();
        }
        return this.pathpsdefid;
    }

    public boolean isPathPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPathPSDEFIdDirty();
        }
        return this.pathpsdefidDirtyFlag;
    }

    public void resetPathPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPathPSDEFId();
            return;
        }
        this.pathpsdefidDirtyFlag = false;
        this.pathpsdefid = null;
    }

    public void setPathPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPathPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pathpsdefname = string;
        this.pathpsdefnameDirtyFlag = true;
    }

    public String getPathPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPathPSDEFName();
        }
        return this.pathpsdefname;
    }

    public boolean isPathPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPathPSDEFNameDirty();
        }
        return this.pathpsdefnameDirtyFlag;
    }

    public void resetPathPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPathPSDEFName();
            return;
        }
        this.pathpsdefnameDirtyFlag = false;
        this.pathpsdefname = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysContentCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysContentCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscontentcatid = string;
        this.pssyscontentcatidDirtyFlag = true;
    }

    public String getPSSysContentCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentCatId();
        }
        return this.pssyscontentcatid;
    }

    public boolean isPSSysContentCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysContentCatIdDirty();
        }
        return this.pssyscontentcatidDirtyFlag;
    }

    public void resetPSSysContentCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysContentCatId();
            return;
        }
        this.pssyscontentcatidDirtyFlag = false;
        this.pssyscontentcatid = null;
    }

    public void setPSSysContentCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysContentCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscontentcatname = string;
        this.pssyscontentcatnameDirtyFlag = true;
    }

    public String getPSSysContentCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentCatName();
        }
        return this.pssyscontentcatname;
    }

    public boolean isPSSysContentCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysContentCatNameDirty();
        }
        return this.pssyscontentcatnameDirtyFlag;
    }

    public void resetPSSysContentCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysContentCatName();
            return;
        }
        this.pssyscontentcatnameDirtyFlag = false;
        this.pssyscontentcatname = null;
    }

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setResourceParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResourceParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resourceparams = string;
        this.resourceparamsDirtyFlag = true;
    }

    public String getResourceParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResourceParams();
        }
        return this.resourceparams;
    }

    public boolean isResourceParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResourceParamsDirty();
        }
        return this.resourceparamsDirtyFlag;
    }

    public void resetResourceParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResourceParams();
            return;
        }
        this.resourceparamsDirtyFlag = false;
        this.resourceparams = null;
    }

    public void setResourceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResourceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resourcetype = string;
        this.resourcetypeDirtyFlag = true;
    }

    public String getResourceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResourceType();
        }
        return this.resourcetype;
    }

    public boolean isResourceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResourceTypeDirty();
        }
        return this.resourcetypeDirtyFlag;
    }

    public void resetResourceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResourceType();
            return;
        }
        this.resourcetypeDirtyFlag = false;
        this.resourcetype = null;
    }

    public void setResourceUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResourceUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resourceuri = string;
        this.resourceuriDirtyFlag = true;
    }

    public String getResourceUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResourceUri();
        }
        return this.resourceuri;
    }

    public boolean isResourceUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResourceUriDirty();
        }
        return this.resourceuriDirtyFlag;
    }

    public void resetResourceUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResourceUri();
            return;
        }
        this.resourceuriDirtyFlag = false;
        this.resourceuri = null;
    }

    public void setResTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restag = string;
        this.restagDirtyFlag = true;
    }

    public String getResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResTag();
        }
        return this.restag;
    }

    public boolean isResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTagDirty();
        }
        return this.restagDirtyFlag;
    }

    public void resetResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResTag();
            return;
        }
        this.restagDirtyFlag = false;
        this.restag = null;
    }

    public void setSubject(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubject(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subject = string;
        this.subjectDirtyFlag = true;
    }

    public String getSubject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubject();
        }
        return this.subject;
    }

    public boolean isSubjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubjectDirty();
        }
        return this.subjectDirtyFlag;
    }

    public void resetSubject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubject();
            return;
        }
        this.subjectDirtyFlag = false;
        this.subject = null;
    }

    public void setTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagpsdefid = string;
        this.tagpsdefidDirtyFlag = true;
    }

    public String getTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEFId();
        }
        return this.tagpsdefid;
    }

    public boolean isTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagPSDEFIdDirty();
        }
        return this.tagpsdefidDirtyFlag;
    }

    public void resetTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagPSDEFId();
            return;
        }
        this.tagpsdefidDirtyFlag = false;
        this.tagpsdefid = null;
    }

    public void setTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagpsdefname = string;
        this.tagpsdefnameDirtyFlag = true;
    }

    public String getTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEFName();
        }
        return this.tagpsdefname;
    }

    public boolean isTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagPSDEFNameDirty();
        }
        return this.tagpsdefnameDirtyFlag;
    }

    public void resetTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagPSDEFName();
            return;
        }
        this.tagpsdefnameDirtyFlag = false;
        this.tagpsdefname = null;
    }

    public void setTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tags = string;
        this.tagsDirtyFlag = true;
    }

    public String getTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTags();
        }
        return this.tags;
    }

    public boolean isTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagsDirty();
        }
        return this.tagsDirtyFlag;
    }

    public void resetTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTags();
            return;
        }
        this.tagsDirtyFlag = false;
        this.tags = null;
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

    public void setUser2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefid = string;
        this.user2psdefidDirtyFlag = true;
    }

    public String getUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFId();
        }
        return this.user2psdefid;
    }

    public boolean isUser2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFIdDirty();
        }
        return this.user2psdefidDirtyFlag;
    }

    public void resetUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFId();
            return;
        }
        this.user2psdefidDirtyFlag = false;
        this.user2psdefid = null;
    }

    public void setUser2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefname = string;
        this.user2psdefnameDirtyFlag = true;
    }

    public String getUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFName();
        }
        return this.user2psdefname;
    }

    public boolean isUser2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFNameDirty();
        }
        return this.user2psdefnameDirtyFlag;
    }

    public void resetUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFName();
            return;
        }
        this.user2psdefnameDirtyFlag = false;
        this.user2psdefname = null;
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

    public void setUserPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefid = string;
        this.userpsdefidDirtyFlag = true;
    }

    public String getUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFId();
        }
        return this.userpsdefid;
    }

    public boolean isUserPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFIdDirty();
        }
        return this.userpsdefidDirtyFlag;
    }

    public void resetUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFId();
            return;
        }
        this.userpsdefidDirtyFlag = false;
        this.userpsdefid = null;
    }

    public void setUserPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefname = string;
        this.userpsdefnameDirtyFlag = true;
    }

    public String getUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFName();
        }
        return this.userpsdefname;
    }

    public boolean isUserPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFNameDirty();
        }
        return this.userpsdefnameDirtyFlag;
    }

    public void resetUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFName();
            return;
        }
        this.userpsdefnameDirtyFlag = false;
        this.userpsdefname = null;
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
        PSSysResourceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysResourceBase pSSysResourceBase) {
        pSSysResourceBase.resetAuthAccessTokenUri();
        pSSysResourceBase.resetAuthClientId();
        pSSysResourceBase.resetAuthClientSecret();
        pSSysResourceBase.resetAuthMode();
        pSSysResourceBase.resetAuthParam();
        pSSysResourceBase.resetAuthParam2();
        pSSysResourceBase.resetContent();
        pSSysResourceBase.resetContentPSDEFId();
        pSSysResourceBase.resetContentPSDEFName();
        pSSysResourceBase.resetContentPSLanResId();
        pSSysResourceBase.resetContentPSLanResName();
        pSSysResourceBase.resetCreateDate();
        pSSysResourceBase.resetCreateMan();
        pSSysResourceBase.resetCustomCode();
        pSSysResourceBase.resetCustomMode();
        pSSysResourceBase.resetMemo();
        pSSysResourceBase.resetNamePSDEFId();
        pSSysResourceBase.resetNamePSDEFName();
        pSSysResourceBase.resetPathPSDEFId();
        pSSysResourceBase.resetPathPSDEFName();
        pSSysResourceBase.resetPSDEDSId();
        pSSysResourceBase.resetPSDEDSName();
        pSSysResourceBase.resetPSDEId();
        pSSysResourceBase.resetPSDEName();
        pSSysResourceBase.resetPSModuleId();
        pSSysResourceBase.resetPSModuleName();
        pSSysResourceBase.resetPSSysContentCatId();
        pSSysResourceBase.resetPSSysContentCatName();
        pSSysResourceBase.resetPSSysResourceId();
        pSSysResourceBase.resetPSSysResourceName();
        pSSysResourceBase.resetPSSysSFPluginId();
        pSSysResourceBase.resetPSSysSFPluginName();
        pSSysResourceBase.resetPSSystemId();
        pSSysResourceBase.resetPSSystemName();
        pSSysResourceBase.resetResourceParams();
        pSSysResourceBase.resetResourceType();
        pSSysResourceBase.resetResourceUri();
        pSSysResourceBase.resetResTag();
        pSSysResourceBase.resetSubject();
        pSSysResourceBase.resetTagPSDEFId();
        pSSysResourceBase.resetTagPSDEFName();
        pSSysResourceBase.resetTags();
        pSSysResourceBase.resetUpdateDate();
        pSSysResourceBase.resetUpdateMan();
        pSSysResourceBase.resetUser2PSDEFId();
        pSSysResourceBase.resetUser2PSDEFName();
        pSSysResourceBase.resetUserCat();
        pSSysResourceBase.resetUserPSDEFId();
        pSSysResourceBase.resetUserPSDEFName();
        pSSysResourceBase.resetUserTag();
        pSSysResourceBase.resetUserTag2();
        pSSysResourceBase.resetUserTag3();
        pSSysResourceBase.resetUserTag4();
        pSSysResourceBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAuthAccessTokenUriDirty()) {
            hashMap.put(FIELD_AUTHACCESSTOKENURI, this.getAuthAccessTokenUri());
        }
        if (!bl || this.isAuthClientIdDirty()) {
            hashMap.put(FIELD_AUTHCLIENTID, this.getAuthClientId());
        }
        if (!bl || this.isAuthClientSecretDirty()) {
            hashMap.put(FIELD_AUTHCLIENTSECRET, this.getAuthClientSecret());
        }
        if (!bl || this.isAuthModeDirty()) {
            hashMap.put(FIELD_AUTHMODE, this.getAuthMode());
        }
        if (!bl || this.isAuthParamDirty()) {
            hashMap.put(FIELD_AUTHPARAM, this.getAuthParam());
        }
        if (!bl || this.isAuthParam2Dirty()) {
            hashMap.put(FIELD_AUTHPARAM2, this.getAuthParam2());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContentPSDEFIdDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFID, this.getContentPSDEFId());
        }
        if (!bl || this.isContentPSDEFNameDirty()) {
            hashMap.put(FIELD_CONTENTPSDEFNAME, this.getContentPSDEFName());
        }
        if (!bl || this.isContentPSLanResIdDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESID, this.getContentPSLanResId());
        }
        if (!bl || this.isContentPSLanResNameDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESNAME, this.getContentPSLanResName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNamePSDEFIdDirty()) {
            hashMap.put(FIELD_NAMEPSDEFID, this.getNamePSDEFId());
        }
        if (!bl || this.isNamePSDEFNameDirty()) {
            hashMap.put(FIELD_NAMEPSDEFNAME, this.getNamePSDEFName());
        }
        if (!bl || this.isPathPSDEFIdDirty()) {
            hashMap.put(FIELD_PATHPSDEFID, this.getPathPSDEFId());
        }
        if (!bl || this.isPathPSDEFNameDirty()) {
            hashMap.put(FIELD_PATHPSDEFNAME, this.getPathPSDEFName());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysContentCatIdDirty()) {
            hashMap.put(FIELD_PSSYSCONTENTCATID, this.getPSSysContentCatId());
        }
        if (!bl || this.isPSSysContentCatNameDirty()) {
            hashMap.put(FIELD_PSSYSCONTENTCATNAME, this.getPSSysContentCatName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isResourceParamsDirty()) {
            hashMap.put(FIELD_RESOURCEPARAMS, this.getResourceParams());
        }
        if (!bl || this.isResourceTypeDirty()) {
            hashMap.put(FIELD_RESOURCETYPE, this.getResourceType());
        }
        if (!bl || this.isResourceUriDirty()) {
            hashMap.put(FIELD_RESOURCEURI, this.getResourceUri());
        }
        if (!bl || this.isResTagDirty()) {
            hashMap.put(FIELD_RESTAG, this.getResTag());
        }
        if (!bl || this.isSubjectDirty()) {
            hashMap.put(FIELD_SUBJECT, this.getSubject());
        }
        if (!bl || this.isTagPSDEFIdDirty()) {
            hashMap.put(FIELD_TAGPSDEFID, this.getTagPSDEFId());
        }
        if (!bl || this.isTagPSDEFNameDirty()) {
            hashMap.put(FIELD_TAGPSDEFNAME, this.getTagPSDEFName());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUser2PSDEFIdDirty()) {
            hashMap.put(FIELD_USER2PSDEFID, this.getUser2PSDEFId());
        }
        if (!bl || this.isUser2PSDEFNameDirty()) {
            hashMap.put(FIELD_USER2PSDEFNAME, this.getUser2PSDEFName());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserPSDEFIdDirty()) {
            hashMap.put(FIELD_USERPSDEFID, this.getUserPSDEFId());
        }
        if (!bl || this.isUserPSDEFNameDirty()) {
            hashMap.put(FIELD_USERPSDEFNAME, this.getUserPSDEFName());
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
        return PSSysResourceBase.get(this, n);
    }

    private static Object get(PSSysResourceBase pSSysResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysResourceBase.getAuthAccessTokenUri();
            }
            case 1: {
                return pSSysResourceBase.getAuthClientId();
            }
            case 2: {
                return pSSysResourceBase.getAuthClientSecret();
            }
            case 3: {
                return pSSysResourceBase.getAuthMode();
            }
            case 4: {
                return pSSysResourceBase.getAuthParam();
            }
            case 5: {
                return pSSysResourceBase.getAuthParam2();
            }
            case 6: {
                return pSSysResourceBase.getContent();
            }
            case 7: {
                return pSSysResourceBase.getContentPSDEFId();
            }
            case 8: {
                return pSSysResourceBase.getContentPSDEFName();
            }
            case 9: {
                return pSSysResourceBase.getContentPSLanResId();
            }
            case 10: {
                return pSSysResourceBase.getContentPSLanResName();
            }
            case 11: {
                return pSSysResourceBase.getCreateDate();
            }
            case 12: {
                return pSSysResourceBase.getCreateMan();
            }
            case 13: {
                return pSSysResourceBase.getCustomCode();
            }
            case 14: {
                return pSSysResourceBase.getCustomMode();
            }
            case 15: {
                return pSSysResourceBase.getMemo();
            }
            case 16: {
                return pSSysResourceBase.getNamePSDEFId();
            }
            case 17: {
                return pSSysResourceBase.getNamePSDEFName();
            }
            case 18: {
                return pSSysResourceBase.getPathPSDEFId();
            }
            case 19: {
                return pSSysResourceBase.getPathPSDEFName();
            }
            case 20: {
                return pSSysResourceBase.getPSDEDSId();
            }
            case 21: {
                return pSSysResourceBase.getPSDEDSName();
            }
            case 22: {
                return pSSysResourceBase.getPSDEId();
            }
            case 23: {
                return pSSysResourceBase.getPSDEName();
            }
            case 24: {
                return pSSysResourceBase.getPSModuleId();
            }
            case 25: {
                return pSSysResourceBase.getPSModuleName();
            }
            case 26: {
                return pSSysResourceBase.getPSSysContentCatId();
            }
            case 27: {
                return pSSysResourceBase.getPSSysContentCatName();
            }
            case 28: {
                return pSSysResourceBase.getPSSysResourceId();
            }
            case 29: {
                return pSSysResourceBase.getPSSysResourceName();
            }
            case 30: {
                return pSSysResourceBase.getPSSysSFPluginId();
            }
            case 31: {
                return pSSysResourceBase.getPSSysSFPluginName();
            }
            case 32: {
                return pSSysResourceBase.getPSSystemId();
            }
            case 33: {
                return pSSysResourceBase.getPSSystemName();
            }
            case 34: {
                return pSSysResourceBase.getResourceParams();
            }
            case 35: {
                return pSSysResourceBase.getResourceType();
            }
            case 36: {
                return pSSysResourceBase.getResourceUri();
            }
            case 37: {
                return pSSysResourceBase.getResTag();
            }
            case 38: {
                return pSSysResourceBase.getSubject();
            }
            case 39: {
                return pSSysResourceBase.getTagPSDEFId();
            }
            case 40: {
                return pSSysResourceBase.getTagPSDEFName();
            }
            case 41: {
                return pSSysResourceBase.getTags();
            }
            case 42: {
                return pSSysResourceBase.getUpdateDate();
            }
            case 43: {
                return pSSysResourceBase.getUpdateMan();
            }
            case 44: {
                return pSSysResourceBase.getUser2PSDEFId();
            }
            case 45: {
                return pSSysResourceBase.getUser2PSDEFName();
            }
            case 46: {
                return pSSysResourceBase.getUserCat();
            }
            case 47: {
                return pSSysResourceBase.getUserPSDEFId();
            }
            case 48: {
                return pSSysResourceBase.getUserPSDEFName();
            }
            case 49: {
                return pSSysResourceBase.getUserTag();
            }
            case 50: {
                return pSSysResourceBase.getUserTag2();
            }
            case 51: {
                return pSSysResourceBase.getUserTag3();
            }
            case 52: {
                return pSSysResourceBase.getUserTag4();
            }
            case 53: {
                return pSSysResourceBase.getValidFlag();
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
        PSSysResourceBase.set(this, n, object);
    }

    private static void set(PSSysResourceBase pSSysResourceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysResourceBase.setAuthAccessTokenUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysResourceBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysResourceBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysResourceBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysResourceBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysResourceBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysResourceBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysResourceBase.setContentPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysResourceBase.setContentPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysResourceBase.setContentPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysResourceBase.setContentPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysResourceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysResourceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysResourceBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysResourceBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysResourceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysResourceBase.setNamePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysResourceBase.setNamePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysResourceBase.setPathPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysResourceBase.setPathPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysResourceBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysResourceBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysResourceBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysResourceBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysResourceBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysResourceBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysResourceBase.setPSSysContentCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysResourceBase.setPSSysContentCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysResourceBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysResourceBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysResourceBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysResourceBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysResourceBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysResourceBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysResourceBase.setResourceParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysResourceBase.setResourceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysResourceBase.setResourceUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysResourceBase.setResTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysResourceBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysResourceBase.setTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysResourceBase.setTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysResourceBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysResourceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 43: {
                pSSysResourceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysResourceBase.setUser2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysResourceBase.setUser2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysResourceBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysResourceBase.setUserPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysResourceBase.setUserPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysResourceBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysResourceBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysResourceBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysResourceBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysResourceBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysResourceBase.isNull(this, n);
    }

    private static boolean isNull(PSSysResourceBase pSSysResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysResourceBase.getAuthAccessTokenUri() == null;
            }
            case 1: {
                return pSSysResourceBase.getAuthClientId() == null;
            }
            case 2: {
                return pSSysResourceBase.getAuthClientSecret() == null;
            }
            case 3: {
                return pSSysResourceBase.getAuthMode() == null;
            }
            case 4: {
                return pSSysResourceBase.getAuthParam() == null;
            }
            case 5: {
                return pSSysResourceBase.getAuthParam2() == null;
            }
            case 6: {
                return pSSysResourceBase.getContent() == null;
            }
            case 7: {
                return pSSysResourceBase.getContentPSDEFId() == null;
            }
            case 8: {
                return pSSysResourceBase.getContentPSDEFName() == null;
            }
            case 9: {
                return pSSysResourceBase.getContentPSLanResId() == null;
            }
            case 10: {
                return pSSysResourceBase.getContentPSLanResName() == null;
            }
            case 11: {
                return pSSysResourceBase.getCreateDate() == null;
            }
            case 12: {
                return pSSysResourceBase.getCreateMan() == null;
            }
            case 13: {
                return pSSysResourceBase.getCustomCode() == null;
            }
            case 14: {
                return pSSysResourceBase.getCustomMode() == null;
            }
            case 15: {
                return pSSysResourceBase.getMemo() == null;
            }
            case 16: {
                return pSSysResourceBase.getNamePSDEFId() == null;
            }
            case 17: {
                return pSSysResourceBase.getNamePSDEFName() == null;
            }
            case 18: {
                return pSSysResourceBase.getPathPSDEFId() == null;
            }
            case 19: {
                return pSSysResourceBase.getPathPSDEFName() == null;
            }
            case 20: {
                return pSSysResourceBase.getPSDEDSId() == null;
            }
            case 21: {
                return pSSysResourceBase.getPSDEDSName() == null;
            }
            case 22: {
                return pSSysResourceBase.getPSDEId() == null;
            }
            case 23: {
                return pSSysResourceBase.getPSDEName() == null;
            }
            case 24: {
                return pSSysResourceBase.getPSModuleId() == null;
            }
            case 25: {
                return pSSysResourceBase.getPSModuleName() == null;
            }
            case 26: {
                return pSSysResourceBase.getPSSysContentCatId() == null;
            }
            case 27: {
                return pSSysResourceBase.getPSSysContentCatName() == null;
            }
            case 28: {
                return pSSysResourceBase.getPSSysResourceId() == null;
            }
            case 29: {
                return pSSysResourceBase.getPSSysResourceName() == null;
            }
            case 30: {
                return pSSysResourceBase.getPSSysSFPluginId() == null;
            }
            case 31: {
                return pSSysResourceBase.getPSSysSFPluginName() == null;
            }
            case 32: {
                return pSSysResourceBase.getPSSystemId() == null;
            }
            case 33: {
                return pSSysResourceBase.getPSSystemName() == null;
            }
            case 34: {
                return pSSysResourceBase.getResourceParams() == null;
            }
            case 35: {
                return pSSysResourceBase.getResourceType() == null;
            }
            case 36: {
                return pSSysResourceBase.getResourceUri() == null;
            }
            case 37: {
                return pSSysResourceBase.getResTag() == null;
            }
            case 38: {
                return pSSysResourceBase.getSubject() == null;
            }
            case 39: {
                return pSSysResourceBase.getTagPSDEFId() == null;
            }
            case 40: {
                return pSSysResourceBase.getTagPSDEFName() == null;
            }
            case 41: {
                return pSSysResourceBase.getTags() == null;
            }
            case 42: {
                return pSSysResourceBase.getUpdateDate() == null;
            }
            case 43: {
                return pSSysResourceBase.getUpdateMan() == null;
            }
            case 44: {
                return pSSysResourceBase.getUser2PSDEFId() == null;
            }
            case 45: {
                return pSSysResourceBase.getUser2PSDEFName() == null;
            }
            case 46: {
                return pSSysResourceBase.getUserCat() == null;
            }
            case 47: {
                return pSSysResourceBase.getUserPSDEFId() == null;
            }
            case 48: {
                return pSSysResourceBase.getUserPSDEFName() == null;
            }
            case 49: {
                return pSSysResourceBase.getUserTag() == null;
            }
            case 50: {
                return pSSysResourceBase.getUserTag2() == null;
            }
            case 51: {
                return pSSysResourceBase.getUserTag3() == null;
            }
            case 52: {
                return pSSysResourceBase.getUserTag4() == null;
            }
            case 53: {
                return pSSysResourceBase.getValidFlag() == null;
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
        return PSSysResourceBase.contains(this, n);
    }

    private static boolean contains(PSSysResourceBase pSSysResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysResourceBase.isAuthAccessTokenUriDirty();
            }
            case 1: {
                return pSSysResourceBase.isAuthClientIdDirty();
            }
            case 2: {
                return pSSysResourceBase.isAuthClientSecretDirty();
            }
            case 3: {
                return pSSysResourceBase.isAuthModeDirty();
            }
            case 4: {
                return pSSysResourceBase.isAuthParamDirty();
            }
            case 5: {
                return pSSysResourceBase.isAuthParam2Dirty();
            }
            case 6: {
                return pSSysResourceBase.isContentDirty();
            }
            case 7: {
                return pSSysResourceBase.isContentPSDEFIdDirty();
            }
            case 8: {
                return pSSysResourceBase.isContentPSDEFNameDirty();
            }
            case 9: {
                return pSSysResourceBase.isContentPSLanResIdDirty();
            }
            case 10: {
                return pSSysResourceBase.isContentPSLanResNameDirty();
            }
            case 11: {
                return pSSysResourceBase.isCreateDateDirty();
            }
            case 12: {
                return pSSysResourceBase.isCreateManDirty();
            }
            case 13: {
                return pSSysResourceBase.isCustomCodeDirty();
            }
            case 14: {
                return pSSysResourceBase.isCustomModeDirty();
            }
            case 15: {
                return pSSysResourceBase.isMemoDirty();
            }
            case 16: {
                return pSSysResourceBase.isNamePSDEFIdDirty();
            }
            case 17: {
                return pSSysResourceBase.isNamePSDEFNameDirty();
            }
            case 18: {
                return pSSysResourceBase.isPathPSDEFIdDirty();
            }
            case 19: {
                return pSSysResourceBase.isPathPSDEFNameDirty();
            }
            case 20: {
                return pSSysResourceBase.isPSDEDSIdDirty();
            }
            case 21: {
                return pSSysResourceBase.isPSDEDSNameDirty();
            }
            case 22: {
                return pSSysResourceBase.isPSDEIdDirty();
            }
            case 23: {
                return pSSysResourceBase.isPSDENameDirty();
            }
            case 24: {
                return pSSysResourceBase.isPSModuleIdDirty();
            }
            case 25: {
                return pSSysResourceBase.isPSModuleNameDirty();
            }
            case 26: {
                return pSSysResourceBase.isPSSysContentCatIdDirty();
            }
            case 27: {
                return pSSysResourceBase.isPSSysContentCatNameDirty();
            }
            case 28: {
                return pSSysResourceBase.isPSSysResourceIdDirty();
            }
            case 29: {
                return pSSysResourceBase.isPSSysResourceNameDirty();
            }
            case 30: {
                return pSSysResourceBase.isPSSysSFPluginIdDirty();
            }
            case 31: {
                return pSSysResourceBase.isPSSysSFPluginNameDirty();
            }
            case 32: {
                return pSSysResourceBase.isPSSystemIdDirty();
            }
            case 33: {
                return pSSysResourceBase.isPSSystemNameDirty();
            }
            case 34: {
                return pSSysResourceBase.isResourceParamsDirty();
            }
            case 35: {
                return pSSysResourceBase.isResourceTypeDirty();
            }
            case 36: {
                return pSSysResourceBase.isResourceUriDirty();
            }
            case 37: {
                return pSSysResourceBase.isResTagDirty();
            }
            case 38: {
                return pSSysResourceBase.isSubjectDirty();
            }
            case 39: {
                return pSSysResourceBase.isTagPSDEFIdDirty();
            }
            case 40: {
                return pSSysResourceBase.isTagPSDEFNameDirty();
            }
            case 41: {
                return pSSysResourceBase.isTagsDirty();
            }
            case 42: {
                return pSSysResourceBase.isUpdateDateDirty();
            }
            case 43: {
                return pSSysResourceBase.isUpdateManDirty();
            }
            case 44: {
                return pSSysResourceBase.isUser2PSDEFIdDirty();
            }
            case 45: {
                return pSSysResourceBase.isUser2PSDEFNameDirty();
            }
            case 46: {
                return pSSysResourceBase.isUserCatDirty();
            }
            case 47: {
                return pSSysResourceBase.isUserPSDEFIdDirty();
            }
            case 48: {
                return pSSysResourceBase.isUserPSDEFNameDirty();
            }
            case 49: {
                return pSSysResourceBase.isUserTagDirty();
            }
            case 50: {
                return pSSysResourceBase.isUserTag2Dirty();
            }
            case 51: {
                return pSSysResourceBase.isUserTag3Dirty();
            }
            case 52: {
                return pSSysResourceBase.isUserTag4Dirty();
            }
            case 53: {
                return pSSysResourceBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysResourceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysResourceBase pSSysResourceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysResourceBase.getAuthAccessTokenUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authaccesstokenuri", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getAuthAccessTokenUri()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getContent()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getContentPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getContentPSDEFId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getContentPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpsdefname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getContentPSDEFName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getContentPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getContentPSLanResId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getContentPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getContentPSLanResName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getNamePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepsdefid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getNamePSDEFId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getNamePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"namepsdefname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getNamePSDEFName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPathPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pathpsdefid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPathPSDEFId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPathPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pathpsdefname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPathPSDEFName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSysContentCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentcatid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSysContentCatId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSysContentCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentcatname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSysContentCatName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getResourceParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resourceparams", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getResourceParams()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getResourceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resourcetype", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getResourceType()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getResourceUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resourceuri", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getResourceUri()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getResTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restag", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getResTag()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getTagPSDEFId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagpsdefname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getTagPSDEFName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getTags()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUser2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUser2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUser2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUser2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUserPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefid", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUserPSDEFId()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUserPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefname", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUserPSDEFName()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysResourceBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysResourceBase.getJSONValue((Object)pSSysResourceBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysResourceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysResourceBase pSSysResourceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysResourceBase.getAuthAccessTokenUri() != null) {
            object = pSSysResourceBase.getAuthAccessTokenUri();
            xmlNode.setAttribute(FIELD_AUTHACCESSTOKENURI, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getAuthClientId() != null) {
            object = pSSysResourceBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getAuthClientSecret() != null) {
            object = pSSysResourceBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getAuthMode() != null) {
            object = pSSysResourceBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getAuthParam() != null) {
            object = pSSysResourceBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getAuthParam2() != null) {
            object = pSSysResourceBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getContent() != null) {
            object = pSSysResourceBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getContentPSDEFId() != null) {
            object = pSSysResourceBase.getContentPSDEFId();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getContentPSDEFName() != null) {
            object = pSSysResourceBase.getContentPSDEFName();
            xmlNode.setAttribute(FIELD_CONTENTPSDEFNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getContentPSLanResId() != null) {
            object = pSSysResourceBase.getContentPSLanResId();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysResourceBase.getContentPSLanResName() != null) {
            object = pSSysResourceBase.getContentPSLanResName();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getCreateDate() != null) {
            object = pSSysResourceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysResourceBase.getCreateMan() != null) {
            object = pSSysResourceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getCustomCode() != null) {
            object = pSSysResourceBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getCustomMode() != null) {
            object = pSSysResourceBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysResourceBase.getMemo() != null) {
            object = pSSysResourceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getNamePSDEFId() != null) {
            object = pSSysResourceBase.getNamePSDEFId();
            xmlNode.setAttribute(FIELD_NAMEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getNamePSDEFName() != null) {
            object = pSSysResourceBase.getNamePSDEFName();
            xmlNode.setAttribute(FIELD_NAMEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPathPSDEFId() != null) {
            object = pSSysResourceBase.getPathPSDEFId();
            xmlNode.setAttribute(FIELD_PATHPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPathPSDEFName() != null) {
            object = pSSysResourceBase.getPathPSDEFName();
            xmlNode.setAttribute(FIELD_PATHPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSDEDSId() != null) {
            object = pSSysResourceBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSDEDSName() != null) {
            object = pSSysResourceBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSDEId() != null) {
            object = pSSysResourceBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSDEName() != null) {
            object = pSSysResourceBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSModuleId() != null) {
            object = pSSysResourceBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSModuleName() != null) {
            object = pSSysResourceBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSysContentCatId() != null) {
            object = pSSysResourceBase.getPSSysContentCatId();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSysContentCatName() != null) {
            object = pSSysResourceBase.getPSSysContentCatName();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSysResourceId() != null) {
            object = pSSysResourceBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSysResourceName() != null) {
            object = pSSysResourceBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSysSFPluginId() != null) {
            object = pSSysResourceBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSysSFPluginName() != null) {
            object = pSSysResourceBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSystemId() != null) {
            object = pSSysResourceBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getPSSystemName() != null) {
            object = pSSysResourceBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getResourceParams() != null) {
            object = pSSysResourceBase.getResourceParams();
            xmlNode.setAttribute(FIELD_RESOURCEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getResourceType() != null) {
            object = pSSysResourceBase.getResourceType();
            xmlNode.setAttribute(FIELD_RESOURCETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getResourceUri() != null) {
            object = pSSysResourceBase.getResourceUri();
            xmlNode.setAttribute(FIELD_RESOURCEURI, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getResTag() != null) {
            object = pSSysResourceBase.getResTag();
            xmlNode.setAttribute(FIELD_RESTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getSubject() != null) {
            object = pSSysResourceBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getTagPSDEFId() != null) {
            object = pSSysResourceBase.getTagPSDEFId();
            xmlNode.setAttribute(FIELD_TAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getTagPSDEFName() != null) {
            object = pSSysResourceBase.getTagPSDEFName();
            xmlNode.setAttribute(FIELD_TAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getTags() != null) {
            object = pSSysResourceBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUpdateDate() != null) {
            object = pSSysResourceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysResourceBase.getUpdateMan() != null) {
            object = pSSysResourceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUser2PSDEFId() != null) {
            object = pSSysResourceBase.getUser2PSDEFId();
            xmlNode.setAttribute(FIELD_USER2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUser2PSDEFName() != null) {
            object = pSSysResourceBase.getUser2PSDEFName();
            xmlNode.setAttribute(FIELD_USER2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUserCat() != null) {
            object = pSSysResourceBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUserPSDEFId() != null) {
            object = pSSysResourceBase.getUserPSDEFId();
            xmlNode.setAttribute(FIELD_USERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUserPSDEFName() != null) {
            object = pSSysResourceBase.getUserPSDEFName();
            xmlNode.setAttribute(FIELD_USERPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUserTag() != null) {
            object = pSSysResourceBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUserTag2() != null) {
            object = pSSysResourceBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUserTag3() != null) {
            object = pSSysResourceBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getUserTag4() != null) {
            object = pSSysResourceBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysResourceBase.getValidFlag() != null) {
            object = pSSysResourceBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysResourceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysResourceBase pSSysResourceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysResourceBase.isAuthAccessTokenUriDirty() && (bl || pSSysResourceBase.getAuthAccessTokenUri() != null)) {
            iDataObject.set(FIELD_AUTHACCESSTOKENURI, (Object)pSSysResourceBase.getAuthAccessTokenUri());
        }
        if (pSSysResourceBase.isAuthClientIdDirty() && (bl || pSSysResourceBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysResourceBase.getAuthClientId());
        }
        if (pSSysResourceBase.isAuthClientSecretDirty() && (bl || pSSysResourceBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysResourceBase.getAuthClientSecret());
        }
        if (pSSysResourceBase.isAuthModeDirty() && (bl || pSSysResourceBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysResourceBase.getAuthMode());
        }
        if (pSSysResourceBase.isAuthParamDirty() && (bl || pSSysResourceBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysResourceBase.getAuthParam());
        }
        if (pSSysResourceBase.isAuthParam2Dirty() && (bl || pSSysResourceBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysResourceBase.getAuthParam2());
        }
        if (pSSysResourceBase.isContentDirty() && (bl || pSSysResourceBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysResourceBase.getContent());
        }
        if (pSSysResourceBase.isContentPSDEFIdDirty() && (bl || pSSysResourceBase.getContentPSDEFId() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFID, (Object)pSSysResourceBase.getContentPSDEFId());
        }
        if (pSSysResourceBase.isContentPSDEFNameDirty() && (bl || pSSysResourceBase.getContentPSDEFName() != null)) {
            iDataObject.set(FIELD_CONTENTPSDEFNAME, (Object)pSSysResourceBase.getContentPSDEFName());
        }
        if (pSSysResourceBase.isContentPSLanResIdDirty() && (bl || pSSysResourceBase.getContentPSLanResId() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESID, (Object)pSSysResourceBase.getContentPSLanResId());
        }
        if (pSSysResourceBase.isContentPSLanResNameDirty() && (bl || pSSysResourceBase.getContentPSLanResName() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESNAME, (Object)pSSysResourceBase.getContentPSLanResName());
        }
        if (pSSysResourceBase.isCreateDateDirty() && (bl || pSSysResourceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysResourceBase.getCreateDate());
        }
        if (pSSysResourceBase.isCreateManDirty() && (bl || pSSysResourceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysResourceBase.getCreateMan());
        }
        if (pSSysResourceBase.isCustomCodeDirty() && (bl || pSSysResourceBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysResourceBase.getCustomCode());
        }
        if (pSSysResourceBase.isCustomModeDirty() && (bl || pSSysResourceBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysResourceBase.getCustomMode());
        }
        if (pSSysResourceBase.isMemoDirty() && (bl || pSSysResourceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysResourceBase.getMemo());
        }
        if (pSSysResourceBase.isNamePSDEFIdDirty() && (bl || pSSysResourceBase.getNamePSDEFId() != null)) {
            iDataObject.set(FIELD_NAMEPSDEFID, (Object)pSSysResourceBase.getNamePSDEFId());
        }
        if (pSSysResourceBase.isNamePSDEFNameDirty() && (bl || pSSysResourceBase.getNamePSDEFName() != null)) {
            iDataObject.set(FIELD_NAMEPSDEFNAME, (Object)pSSysResourceBase.getNamePSDEFName());
        }
        if (pSSysResourceBase.isPathPSDEFIdDirty() && (bl || pSSysResourceBase.getPathPSDEFId() != null)) {
            iDataObject.set(FIELD_PATHPSDEFID, (Object)pSSysResourceBase.getPathPSDEFId());
        }
        if (pSSysResourceBase.isPathPSDEFNameDirty() && (bl || pSSysResourceBase.getPathPSDEFName() != null)) {
            iDataObject.set(FIELD_PATHPSDEFNAME, (Object)pSSysResourceBase.getPathPSDEFName());
        }
        if (pSSysResourceBase.isPSDEDSIdDirty() && (bl || pSSysResourceBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSSysResourceBase.getPSDEDSId());
        }
        if (pSSysResourceBase.isPSDEDSNameDirty() && (bl || pSSysResourceBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSSysResourceBase.getPSDEDSName());
        }
        if (pSSysResourceBase.isPSDEIdDirty() && (bl || pSSysResourceBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysResourceBase.getPSDEId());
        }
        if (pSSysResourceBase.isPSDENameDirty() && (bl || pSSysResourceBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysResourceBase.getPSDEName());
        }
        if (pSSysResourceBase.isPSModuleIdDirty() && (bl || pSSysResourceBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysResourceBase.getPSModuleId());
        }
        if (pSSysResourceBase.isPSModuleNameDirty() && (bl || pSSysResourceBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysResourceBase.getPSModuleName());
        }
        if (pSSysResourceBase.isPSSysContentCatIdDirty() && (bl || pSSysResourceBase.getPSSysContentCatId() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTCATID, (Object)pSSysResourceBase.getPSSysContentCatId());
        }
        if (pSSysResourceBase.isPSSysContentCatNameDirty() && (bl || pSSysResourceBase.getPSSysContentCatName() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTCATNAME, (Object)pSSysResourceBase.getPSSysContentCatName());
        }
        if (pSSysResourceBase.isPSSysResourceIdDirty() && (bl || pSSysResourceBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysResourceBase.getPSSysResourceId());
        }
        if (pSSysResourceBase.isPSSysResourceNameDirty() && (bl || pSSysResourceBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysResourceBase.getPSSysResourceName());
        }
        if (pSSysResourceBase.isPSSysSFPluginIdDirty() && (bl || pSSysResourceBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysResourceBase.getPSSysSFPluginId());
        }
        if (pSSysResourceBase.isPSSysSFPluginNameDirty() && (bl || pSSysResourceBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysResourceBase.getPSSysSFPluginName());
        }
        if (pSSysResourceBase.isPSSystemIdDirty() && (bl || pSSysResourceBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysResourceBase.getPSSystemId());
        }
        if (pSSysResourceBase.isPSSystemNameDirty() && (bl || pSSysResourceBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysResourceBase.getPSSystemName());
        }
        if (pSSysResourceBase.isResourceParamsDirty() && (bl || pSSysResourceBase.getResourceParams() != null)) {
            iDataObject.set(FIELD_RESOURCEPARAMS, (Object)pSSysResourceBase.getResourceParams());
        }
        if (pSSysResourceBase.isResourceTypeDirty() && (bl || pSSysResourceBase.getResourceType() != null)) {
            iDataObject.set(FIELD_RESOURCETYPE, (Object)pSSysResourceBase.getResourceType());
        }
        if (pSSysResourceBase.isResourceUriDirty() && (bl || pSSysResourceBase.getResourceUri() != null)) {
            iDataObject.set(FIELD_RESOURCEURI, (Object)pSSysResourceBase.getResourceUri());
        }
        if (pSSysResourceBase.isResTagDirty() && (bl || pSSysResourceBase.getResTag() != null)) {
            iDataObject.set(FIELD_RESTAG, (Object)pSSysResourceBase.getResTag());
        }
        if (pSSysResourceBase.isSubjectDirty() && (bl || pSSysResourceBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysResourceBase.getSubject());
        }
        if (pSSysResourceBase.isTagPSDEFIdDirty() && (bl || pSSysResourceBase.getTagPSDEFId() != null)) {
            iDataObject.set(FIELD_TAGPSDEFID, (Object)pSSysResourceBase.getTagPSDEFId());
        }
        if (pSSysResourceBase.isTagPSDEFNameDirty() && (bl || pSSysResourceBase.getTagPSDEFName() != null)) {
            iDataObject.set(FIELD_TAGPSDEFNAME, (Object)pSSysResourceBase.getTagPSDEFName());
        }
        if (pSSysResourceBase.isTagsDirty() && (bl || pSSysResourceBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysResourceBase.getTags());
        }
        if (pSSysResourceBase.isUpdateDateDirty() && (bl || pSSysResourceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysResourceBase.getUpdateDate());
        }
        if (pSSysResourceBase.isUpdateManDirty() && (bl || pSSysResourceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysResourceBase.getUpdateMan());
        }
        if (pSSysResourceBase.isUser2PSDEFIdDirty() && (bl || pSSysResourceBase.getUser2PSDEFId() != null)) {
            iDataObject.set(FIELD_USER2PSDEFID, (Object)pSSysResourceBase.getUser2PSDEFId());
        }
        if (pSSysResourceBase.isUser2PSDEFNameDirty() && (bl || pSSysResourceBase.getUser2PSDEFName() != null)) {
            iDataObject.set(FIELD_USER2PSDEFNAME, (Object)pSSysResourceBase.getUser2PSDEFName());
        }
        if (pSSysResourceBase.isUserCatDirty() && (bl || pSSysResourceBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysResourceBase.getUserCat());
        }
        if (pSSysResourceBase.isUserPSDEFIdDirty() && (bl || pSSysResourceBase.getUserPSDEFId() != null)) {
            iDataObject.set(FIELD_USERPSDEFID, (Object)pSSysResourceBase.getUserPSDEFId());
        }
        if (pSSysResourceBase.isUserPSDEFNameDirty() && (bl || pSSysResourceBase.getUserPSDEFName() != null)) {
            iDataObject.set(FIELD_USERPSDEFNAME, (Object)pSSysResourceBase.getUserPSDEFName());
        }
        if (pSSysResourceBase.isUserTagDirty() && (bl || pSSysResourceBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysResourceBase.getUserTag());
        }
        if (pSSysResourceBase.isUserTag2Dirty() && (bl || pSSysResourceBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysResourceBase.getUserTag2());
        }
        if (pSSysResourceBase.isUserTag3Dirty() && (bl || pSSysResourceBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysResourceBase.getUserTag3());
        }
        if (pSSysResourceBase.isUserTag4Dirty() && (bl || pSSysResourceBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysResourceBase.getUserTag4());
        }
        if (pSSysResourceBase.isValidFlagDirty() && (bl || pSSysResourceBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysResourceBase.getValidFlag());
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
        return PSSysResourceBase.remove(this, n);
    }

    private static boolean remove(PSSysResourceBase pSSysResourceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysResourceBase.resetAuthAccessTokenUri();
                return true;
            }
            case 1: {
                pSSysResourceBase.resetAuthClientId();
                return true;
            }
            case 2: {
                pSSysResourceBase.resetAuthClientSecret();
                return true;
            }
            case 3: {
                pSSysResourceBase.resetAuthMode();
                return true;
            }
            case 4: {
                pSSysResourceBase.resetAuthParam();
                return true;
            }
            case 5: {
                pSSysResourceBase.resetAuthParam2();
                return true;
            }
            case 6: {
                pSSysResourceBase.resetContent();
                return true;
            }
            case 7: {
                pSSysResourceBase.resetContentPSDEFId();
                return true;
            }
            case 8: {
                pSSysResourceBase.resetContentPSDEFName();
                return true;
            }
            case 9: {
                pSSysResourceBase.resetContentPSLanResId();
                return true;
            }
            case 10: {
                pSSysResourceBase.resetContentPSLanResName();
                return true;
            }
            case 11: {
                pSSysResourceBase.resetCreateDate();
                return true;
            }
            case 12: {
                pSSysResourceBase.resetCreateMan();
                return true;
            }
            case 13: {
                pSSysResourceBase.resetCustomCode();
                return true;
            }
            case 14: {
                pSSysResourceBase.resetCustomMode();
                return true;
            }
            case 15: {
                pSSysResourceBase.resetMemo();
                return true;
            }
            case 16: {
                pSSysResourceBase.resetNamePSDEFId();
                return true;
            }
            case 17: {
                pSSysResourceBase.resetNamePSDEFName();
                return true;
            }
            case 18: {
                pSSysResourceBase.resetPathPSDEFId();
                return true;
            }
            case 19: {
                pSSysResourceBase.resetPathPSDEFName();
                return true;
            }
            case 20: {
                pSSysResourceBase.resetPSDEDSId();
                return true;
            }
            case 21: {
                pSSysResourceBase.resetPSDEDSName();
                return true;
            }
            case 22: {
                pSSysResourceBase.resetPSDEId();
                return true;
            }
            case 23: {
                pSSysResourceBase.resetPSDEName();
                return true;
            }
            case 24: {
                pSSysResourceBase.resetPSModuleId();
                return true;
            }
            case 25: {
                pSSysResourceBase.resetPSModuleName();
                return true;
            }
            case 26: {
                pSSysResourceBase.resetPSSysContentCatId();
                return true;
            }
            case 27: {
                pSSysResourceBase.resetPSSysContentCatName();
                return true;
            }
            case 28: {
                pSSysResourceBase.resetPSSysResourceId();
                return true;
            }
            case 29: {
                pSSysResourceBase.resetPSSysResourceName();
                return true;
            }
            case 30: {
                pSSysResourceBase.resetPSSysSFPluginId();
                return true;
            }
            case 31: {
                pSSysResourceBase.resetPSSysSFPluginName();
                return true;
            }
            case 32: {
                pSSysResourceBase.resetPSSystemId();
                return true;
            }
            case 33: {
                pSSysResourceBase.resetPSSystemName();
                return true;
            }
            case 34: {
                pSSysResourceBase.resetResourceParams();
                return true;
            }
            case 35: {
                pSSysResourceBase.resetResourceType();
                return true;
            }
            case 36: {
                pSSysResourceBase.resetResourceUri();
                return true;
            }
            case 37: {
                pSSysResourceBase.resetResTag();
                return true;
            }
            case 38: {
                pSSysResourceBase.resetSubject();
                return true;
            }
            case 39: {
                pSSysResourceBase.resetTagPSDEFId();
                return true;
            }
            case 40: {
                pSSysResourceBase.resetTagPSDEFName();
                return true;
            }
            case 41: {
                pSSysResourceBase.resetTags();
                return true;
            }
            case 42: {
                pSSysResourceBase.resetUpdateDate();
                return true;
            }
            case 43: {
                pSSysResourceBase.resetUpdateMan();
                return true;
            }
            case 44: {
                pSSysResourceBase.resetUser2PSDEFId();
                return true;
            }
            case 45: {
                pSSysResourceBase.resetUser2PSDEFName();
                return true;
            }
            case 46: {
                pSSysResourceBase.resetUserCat();
                return true;
            }
            case 47: {
                pSSysResourceBase.resetUserPSDEFId();
                return true;
            }
            case 48: {
                pSSysResourceBase.resetUserPSDEFName();
                return true;
            }
            case 49: {
                pSSysResourceBase.resetUserTag();
                return true;
            }
            case 50: {
                pSSysResourceBase.resetUserTag2();
                return true;
            }
            case 51: {
                pSSysResourceBase.resetUserTag3();
                return true;
            }
            case 52: {
                pSSysResourceBase.resetUserTag4();
                return true;
            }
            case 53: {
                pSSysResourceBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getContentPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSDEF();
        }
        if (this.getContentPSDEFId() == null) {
            return null;
        }
        Integer n = this.objContentPSDEFLock;
        synchronized (n) {
            if (this.contentpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSDEFId(), (Object)this.contentpsdef.getPSDEFieldId()) != 0L) {
                this.contentpsdef = null;
            }
            if (this.contentpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getContentPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.contentpsdef = pSDEField;
            }
            return this.contentpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getNamePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNamePSDEF();
        }
        if (this.getNamePSDEFId() == null) {
            return null;
        }
        Integer n = this.objNamePSDEFLock;
        synchronized (n) {
            if (this.namepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getNamePSDEFId(), (Object)this.namepsdef.getPSDEFieldId()) != 0L) {
                this.namepsdef = null;
            }
            if (this.namepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getNamePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.namepsdef = pSDEField;
            }
            return this.namepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPathPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPathPSDEF();
        }
        if (this.getPathPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPathPSDEFLock;
        synchronized (n) {
            if (this.pathpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getPathPSDEFId(), (Object)this.pathpsdef.getPSDEFieldId()) != 0L) {
                this.pathpsdef = null;
            }
            if (this.pathpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPathPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.pathpsdef = pSDEField;
            }
            return this.pathpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagPSDEF();
        }
        if (this.getTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTagPSDEFLock;
        synchronized (n) {
            if (this.tagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTagPSDEFId(), (Object)this.tagpsdef.getPSDEFieldId()) != 0L) {
                this.tagpsdef = null;
            }
            if (this.tagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.tagpsdef = pSDEField;
            }
            return this.tagpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUser2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEF();
        }
        if (this.getUser2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEFLock;
        synchronized (n) {
            if (this.user2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEFId(), (Object)this.user2psdef.getPSDEFieldId()) != 0L) {
                this.user2psdef = null;
            }
            if (this.user2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUser2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.user2psdef = pSDEField;
            }
            return this.user2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUserPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEF();
        }
        if (this.getUserPSDEFId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEFLock;
        synchronized (n) {
            if (this.userpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEFId(), (Object)this.userpsdef.getPSDEFieldId()) != 0L) {
                this.userpsdef = null;
            }
            if (this.userpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUserPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.userpsdef = pSDEField;
            }
            return this.userpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getContentPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanRes();
        }
        if (this.getContentPSLanResId() == null) {
            return null;
        }
        Integer n = this.objContentPSLanResLock;
        synchronized (n) {
            if (this.contentpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSLanResId(), (Object)this.contentpslanres.getPSLanguageResId()) != 0L) {
                this.contentpslanres = null;
            }
            if (this.contentpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getContentPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.contentpslanres = pSLanguageRes;
            }
            return this.contentpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysContentCat getPSSysContentCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentCat();
        }
        if (this.getPSSysContentCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysContentCatLock;
        synchronized (n) {
            if (this.pssyscontentcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysContentCatId(), (Object)this.pssyscontentcat.getPSSysContentCatId()) != 0L) {
                this.pssyscontentcat = null;
            }
            if (this.pssyscontentcat == null) {
                PSSysContentCat pSSysContentCat = new PSSysContentCat();
                pSSysContentCat.setPSSysContentCatId(this.getPSSysContentCatId());
                PSSysContentCatService pSSysContentCatService = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysContentCatService.autoGet(pSSysContentCat);
                this.pssyscontentcat = pSSysContentCat;
            }
            return this.pssyscontentcat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysResourceBase getProxyEntity() {
        return this.proxyPSSysResourceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysResourceBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysResourceBase) {
            this.proxyPSSysResourceBase = (PSSysResourceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHACCESSTOKENURI, 0);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 1);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 2);
        fieldIndexMap.put(FIELD_AUTHMODE, 3);
        fieldIndexMap.put(FIELD_AUTHPARAM, 4);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 5);
        fieldIndexMap.put(FIELD_CONTENT, 6);
        fieldIndexMap.put(FIELD_CONTENTPSDEFID, 7);
        fieldIndexMap.put(FIELD_CONTENTPSDEFNAME, 8);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESID, 9);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESNAME, 10);
        fieldIndexMap.put(FIELD_CREATEDATE, 11);
        fieldIndexMap.put(FIELD_CREATEMAN, 12);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 13);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_NAMEPSDEFID, 16);
        fieldIndexMap.put(FIELD_NAMEPSDEFNAME, 17);
        fieldIndexMap.put(FIELD_PATHPSDEFID, 18);
        fieldIndexMap.put(FIELD_PATHPSDEFNAME, 19);
        fieldIndexMap.put(FIELD_PSDEDSID, 20);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 21);
        fieldIndexMap.put(FIELD_PSDEID, 22);
        fieldIndexMap.put(FIELD_PSDENAME, 23);
        fieldIndexMap.put(FIELD_PSMODULEID, 24);
        fieldIndexMap.put(FIELD_PSMODULENAME, 25);
        fieldIndexMap.put(FIELD_PSSYSCONTENTCATID, 26);
        fieldIndexMap.put(FIELD_PSSYSCONTENTCATNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 28);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 29);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 30);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 33);
        fieldIndexMap.put(FIELD_RESOURCEPARAMS, 34);
        fieldIndexMap.put(FIELD_RESOURCETYPE, 35);
        fieldIndexMap.put(FIELD_RESOURCEURI, 36);
        fieldIndexMap.put(FIELD_RESTAG, 37);
        fieldIndexMap.put(FIELD_SUBJECT, 38);
        fieldIndexMap.put(FIELD_TAGPSDEFID, 39);
        fieldIndexMap.put(FIELD_TAGPSDEFNAME, 40);
        fieldIndexMap.put(FIELD_TAGS, 41);
        fieldIndexMap.put(FIELD_UPDATEDATE, 42);
        fieldIndexMap.put(FIELD_UPDATEMAN, 43);
        fieldIndexMap.put(FIELD_USER2PSDEFID, 44);
        fieldIndexMap.put(FIELD_USER2PSDEFNAME, 45);
        fieldIndexMap.put(FIELD_USERCAT, 46);
        fieldIndexMap.put(FIELD_USERPSDEFID, 47);
        fieldIndexMap.put(FIELD_USERPSDEFNAME, 48);
        fieldIndexMap.put(FIELD_USERTAG, 49);
        fieldIndexMap.put(FIELD_USERTAG2, 50);
        fieldIndexMap.put(FIELD_USERTAG3, 51);
        fieldIndexMap.put(FIELD_USERTAG4, 52);
        fieldIndexMap.put(FIELD_VALIDFLAG, 53);
    }
}

