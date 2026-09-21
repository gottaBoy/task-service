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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleParam;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.service.PSSFStyleParamService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysProject;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFCode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPubBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSFPubBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_BASECLSPKGCODENAME = "BASECLSPKGCODENAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTPUB = "DEFAULTPUB";
    public static final String FIELD_DOCPSSFSTYLEID = "DOCPSSFSTYLEID";
    public static final String FIELD_DOCPSSFSTYLENAME = "DOCPSSFSTYLENAME";
    public static final String FIELD_DYNAMODELMODE = "DYNAMODELMODE";
    public static final String FIELD_GLOBALTSFLAG = "GLOBALTSFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PKGCODENAME = "PKGCODENAME";
    public static final String FIELD_PPSSYSSFPUBID = "PPSSYSSFPUBID";
    public static final String FIELD_PPSSYSSFPUBNAME = "PPSSYSSFPUBNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEPARAMID = "PSSFSTYLEPARAMID";
    public static final String FIELD_PSSFSTYLEPARAMNAME = "PSSFSTYLEPARAMNAME";
    public static final String FIELD_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String FIELD_PSSFSTYLEVERNAME = "PSSFSTYLEVERNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFCODESCNT = "PSSYSSFCODESCNT";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSSFPUBPKGSCNT = "PSSYSSFPUBPKGSCNT";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PUBFOLDER = "PUBFOLDER";
    public static final String FIELD_PUBTAG = "PUBTAG";
    public static final String FIELD_PUBTAG2 = "PUBTAG2";
    public static final String FIELD_PUBTAG3 = "PUBTAG3";
    public static final String FIELD_PUBTAG4 = "PUBTAG4";
    public static final String FIELD_REMOVEFLAG = "REMOVEFLAG";
    public static final String FIELD_STYLEPARAMS = "STYLEPARAMS";
    public static final String FIELD_SUBSYSPKGFLAG = "SUBSYSPKGFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VERSTR = "VERSTR";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_BASECLSPKGCODENAME = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CONTENTTYPE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DEFAULTPUB = 6;
    private static final int INDEX_DOCPSSFSTYLEID = 7;
    private static final int INDEX_DOCPSSFSTYLENAME = 8;
    private static final int INDEX_DYNAMODELMODE = 9;
    private static final int INDEX_GLOBALTSFLAG = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PKGCODENAME = 12;
    private static final int INDEX_PPSSYSSFPUBID = 13;
    private static final int INDEX_PPSSYSSFPUBNAME = 14;
    private static final int INDEX_PSSFSTYLEID = 15;
    private static final int INDEX_PSSFSTYLENAME = 16;
    private static final int INDEX_PSSFSTYLEPARAMID = 17;
    private static final int INDEX_PSSFSTYLEPARAMNAME = 18;
    private static final int INDEX_PSSFSTYLEVERID = 19;
    private static final int INDEX_PSSFSTYLEVERNAME = 20;
    private static final int INDEX_PSSYSDYNAMODELID = 21;
    private static final int INDEX_PSSYSDYNAMODELNAME = 22;
    private static final int INDEX_PSSYSSFCODESCNT = 23;
    private static final int INDEX_PSSYSSFPUBID = 24;
    private static final int INDEX_PSSYSSFPUBNAME = 25;
    private static final int INDEX_PSSYSSFPUBPKGSCNT = 26;
    private static final int INDEX_PSSYSTEMID = 27;
    private static final int INDEX_PSSYSTEMNAME = 28;
    private static final int INDEX_PUBFOLDER = 29;
    private static final int INDEX_PUBTAG = 30;
    private static final int INDEX_PUBTAG2 = 31;
    private static final int INDEX_PUBTAG3 = 32;
    private static final int INDEX_PUBTAG4 = 33;
    private static final int INDEX_REMOVEFLAG = 34;
    private static final int INDEX_STYLEPARAMS = 35;
    private static final int INDEX_SUBSYSPKGFLAG = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_USERCAT = 39;
    private static final int INDEX_USERTAG = 40;
    private static final int INDEX_USERTAG2 = 41;
    private static final int INDEX_USERTAG3 = 42;
    private static final int INDEX_USERTAG4 = 43;
    private static final int INDEX_VERSTR = 44;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSFPubBase proxyPSSysSFPubBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean baseclspkgcodenameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultpubDirtyFlag = false;
    private boolean docpssfstyleidDirtyFlag = false;
    private boolean docpssfstylenameDirtyFlag = false;
    private boolean dynamodelmodeDirtyFlag = false;
    private boolean globaltsflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pkgcodenameDirtyFlag = false;
    private boolean ppssyssfpubidDirtyFlag = false;
    private boolean ppssyssfpubnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstyleparamidDirtyFlag = false;
    private boolean pssfstyleparamnameDirtyFlag = false;
    private boolean pssfstyleveridDirtyFlag = false;
    private boolean pssfstylevernameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfcodescntDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssyssfpubpkgscntDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pubfolderDirtyFlag = false;
    private boolean pubtagDirtyFlag = false;
    private boolean pubtag2DirtyFlag = false;
    private boolean pubtag3DirtyFlag = false;
    private boolean pubtag4DirtyFlag = false;
    private boolean removeflagDirtyFlag = false;
    private boolean styleparamsDirtyFlag = false;
    private boolean subsyspkgflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean verstrDirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="baseclspkgcodename")
    private String baseclspkgcodename;
    @Column(name="codename")
    private String codename;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultpub")
    private Integer defaultpub;
    @Column(name="docpssfstyleid")
    private String docpssfstyleid;
    @Column(name="docpssfstylename")
    private String docpssfstylename;
    @Column(name="dynamodelmode")
    private String dynamodelmode;
    @Column(name="globaltsflag")
    private Integer globaltsflag;
    @Column(name="memo")
    private String memo;
    @Column(name="pkgcodename")
    private String pkgcodename;
    @Column(name="ppssyssfpubid")
    private String ppssyssfpubid;
    @Column(name="ppssyssfpubname")
    private String ppssyssfpubname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstyleparamid")
    private String pssfstyleparamid;
    @Column(name="pssfstyleparamname")
    private String pssfstyleparamname;
    @Column(name="pssfstyleverid")
    private String pssfstyleverid;
    @Column(name="pssfstylevername")
    private String pssfstylevername;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfcodescnt")
    private Integer pssyssfcodescnt;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssyssfpubpkgscnt")
    private Integer pssyssfpubpkgscnt;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pubfolder")
    private String pubfolder;
    @Column(name="pubtag")
    private String pubtag;
    @Column(name="pubtag2")
    private String pubtag2;
    @Column(name="pubtag3")
    private String pubtag3;
    @Column(name="pubtag4")
    private String pubtag4;
    @Column(name="removeflag")
    private Integer removeflag;
    @Column(name="styleparams")
    private String styleparams;
    @Column(name="subsyspkgflag")
    private Integer subsyspkgflag;
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
    @Column(name="verstr")
    private String verstr;
    private Integer objPSSFStyleParamLock = new Integer(1);
    private PSSFStyleParam pssfstyleparam = null;
    private Integer objPSSFStyleVerLock = new Integer(1);
    private PSSFStyleVer pssfstylever = null;
    private Integer objDocPSSFStyleLock = new Integer(1);
    private PSSFStyle docpssfstyle = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPPSSysSFPubLock = new Integer(1);
    private PSSysSFPub ppssyssfpub = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysProjectsLock = new Integer(1);
    private ArrayList<PSSysProject> pssysprojects = null;
    private Integer objPSSysSFCodesLock = new Integer(1);
    private ArrayList<PSSysSFCode> pssyssfcodes = null;
    private Integer objPSSysSFPubRefsLock = new Integer(1);
    private ArrayList<PSSysSFPubRef> pssyssfpubrefs = null;
    private Integer objPSSysSFPubsLock = new Integer(1);
    private ArrayList<PSSysSFPub> pssyssfpubs = null;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
    }

    public void setBaseCLSPKGCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseCLSPKGCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclspkgcodename = string;
        this.baseclspkgcodenameDirtyFlag = true;
    }

    public String getBaseCLSPKGCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseCLSPKGCodeName();
        }
        return this.baseclspkgcodename;
    }

    public boolean isBaseCLSPKGCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseCLSPKGCodeNameDirty();
        }
        return this.baseclspkgcodenameDirtyFlag;
    }

    public void resetBaseCLSPKGCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseCLSPKGCodeName();
            return;
        }
        this.baseclspkgcodenameDirtyFlag = false;
        this.baseclspkgcodename = null;
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

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
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

    public void setDefaultPub(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultPub(n);
            return;
        }
        this.defaultpub = n;
        this.defaultpubDirtyFlag = true;
    }

    public Integer getDefaultPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultPub();
        }
        return this.defaultpub;
    }

    public boolean isDefaultPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultPubDirty();
        }
        return this.defaultpubDirtyFlag;
    }

    public void resetDefaultPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultPub();
            return;
        }
        this.defaultpubDirtyFlag = false;
        this.defaultpub = null;
    }

    public void setDocPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docpssfstyleid = string;
        this.docpssfstyleidDirtyFlag = true;
    }

    public String getDocPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocPSSFStyleId();
        }
        return this.docpssfstyleid;
    }

    public boolean isDocPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocPSSFStyleIdDirty();
        }
        return this.docpssfstyleidDirtyFlag;
    }

    public void resetDocPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocPSSFStyleId();
            return;
        }
        this.docpssfstyleidDirtyFlag = false;
        this.docpssfstyleid = null;
    }

    public void setDocPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docpssfstylename = string;
        this.docpssfstylenameDirtyFlag = true;
    }

    public String getDocPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocPSSFStyleName();
        }
        return this.docpssfstylename;
    }

    public boolean isDocPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocPSSFStyleNameDirty();
        }
        return this.docpssfstylenameDirtyFlag;
    }

    public void resetDocPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocPSSFStyleName();
            return;
        }
        this.docpssfstylenameDirtyFlag = false;
        this.docpssfstylename = null;
    }

    public void setDynaModelMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodelmode = string;
        this.dynamodelmodeDirtyFlag = true;
    }

    public String getDynaModelMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelMode();
        }
        return this.dynamodelmode;
    }

    public boolean isDynaModelModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelModeDirty();
        }
        return this.dynamodelmodeDirtyFlag;
    }

    public void resetDynaModelMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelMode();
            return;
        }
        this.dynamodelmodeDirtyFlag = false;
        this.dynamodelmode = null;
    }

    public void setGlobalTSFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlobalTSFlag(n);
            return;
        }
        this.globaltsflag = n;
        this.globaltsflagDirtyFlag = true;
    }

    public Integer getGlobalTSFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlobalTSFlag();
        }
        return this.globaltsflag;
    }

    public boolean isGlobalTSFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlobalTSFlagDirty();
        }
        return this.globaltsflagDirtyFlag;
    }

    public void resetGlobalTSFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlobalTSFlag();
            return;
        }
        this.globaltsflagDirtyFlag = false;
        this.globaltsflag = null;
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

    public void setPKGCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKGCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgcodename = string;
        this.pkgcodenameDirtyFlag = true;
    }

    public String getPKGCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKGCodeName();
        }
        return this.pkgcodename;
    }

    public boolean isPKGCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKGCodeNameDirty();
        }
        return this.pkgcodenameDirtyFlag;
    }

    public void resetPKGCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKGCodeName();
            return;
        }
        this.pkgcodenameDirtyFlag = false;
        this.pkgcodename = null;
    }

    public void setPPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssyssfpubid = string;
        this.ppssyssfpubidDirtyFlag = true;
    }

    public String getPPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysSFPubId();
        }
        return this.ppssyssfpubid;
    }

    public boolean isPPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysSFPubIdDirty();
        }
        return this.ppssyssfpubidDirtyFlag;
    }

    public void resetPPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysSFPubId();
            return;
        }
        this.ppssyssfpubidDirtyFlag = false;
        this.ppssyssfpubid = null;
    }

    public void setPPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssyssfpubname = string;
        this.ppssyssfpubnameDirtyFlag = true;
    }

    public String getPPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysSFPubName();
        }
        return this.ppssyssfpubname;
    }

    public boolean isPPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysSFPubNameDirty();
        }
        return this.ppssyssfpubnameDirtyFlag;
    }

    public void resetPPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysSFPubName();
            return;
        }
        this.ppssyssfpubnameDirtyFlag = false;
        this.ppssyssfpubname = null;
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

    public void setPSSFStyleParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleparamid = string;
        this.pssfstyleparamidDirtyFlag = true;
    }

    public String getPSSFStyleParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleParamId();
        }
        return this.pssfstyleparamid;
    }

    public boolean isPSSFStyleParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleParamIdDirty();
        }
        return this.pssfstyleparamidDirtyFlag;
    }

    public void resetPSSFStyleParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleParamId();
            return;
        }
        this.pssfstyleparamidDirtyFlag = false;
        this.pssfstyleparamid = null;
    }

    public void setPSSFStyleParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleparamname = string;
        this.pssfstyleparamnameDirtyFlag = true;
    }

    public String getPSSFStyleParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleParamName();
        }
        return this.pssfstyleparamname;
    }

    public boolean isPSSFStyleParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleParamNameDirty();
        }
        return this.pssfstyleparamnameDirtyFlag;
    }

    public void resetPSSFStyleParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleParamName();
            return;
        }
        this.pssfstyleparamnameDirtyFlag = false;
        this.pssfstyleparamname = null;
    }

    public void setPSSFStyleVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleverid = string;
        this.pssfstyleveridDirtyFlag = true;
    }

    public String getPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerId();
        }
        return this.pssfstyleverid;
    }

    public boolean isPSSFStyleVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerIdDirty();
        }
        return this.pssfstyleveridDirtyFlag;
    }

    public void resetPSSFStyleVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerId();
            return;
        }
        this.pssfstyleveridDirtyFlag = false;
        this.pssfstyleverid = null;
    }

    public void setPSSFStyleVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylevername = string;
        this.pssfstylevernameDirtyFlag = true;
    }

    public String getPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVerName();
        }
        return this.pssfstylevername;
    }

    public boolean isPSSFStyleVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleVerNameDirty();
        }
        return this.pssfstylevernameDirtyFlag;
    }

    public void resetPSSFStyleVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleVerName();
            return;
        }
        this.pssfstylevernameDirtyFlag = false;
        this.pssfstylevername = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysSFCodesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFCodesCnt(n);
            return;
        }
        this.pssyssfcodescnt = n;
        this.pssyssfcodescntDirtyFlag = true;
    }

    public Integer getPSSysSFCodesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFCodesCnt();
        }
        return this.pssyssfcodescnt;
    }

    public boolean isPSSysSFCodesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFCodesCntDirty();
        }
        return this.pssyssfcodescntDirtyFlag;
    }

    public void resetPSSysSFCodesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFCodesCnt();
            return;
        }
        this.pssyssfcodescntDirtyFlag = false;
        this.pssyssfcodescnt = null;
    }

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
    }

    public void setPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubname = string;
        this.pssyssfpubnameDirtyFlag = true;
    }

    public String getPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubName();
        }
        return this.pssyssfpubname;
    }

    public boolean isPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubNameDirty();
        }
        return this.pssyssfpubnameDirtyFlag;
    }

    public void resetPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubName();
            return;
        }
        this.pssyssfpubnameDirtyFlag = false;
        this.pssyssfpubname = null;
    }

    public void setPSSysSFPubPkgsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubPkgsCnt(n);
            return;
        }
        this.pssyssfpubpkgscnt = n;
        this.pssyssfpubpkgscntDirtyFlag = true;
    }

    public Integer getPSSysSFPubPkgsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubPkgsCnt();
        }
        return this.pssyssfpubpkgscnt;
    }

    public boolean isPSSysSFPubPkgsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubPkgsCntDirty();
        }
        return this.pssyssfpubpkgscntDirtyFlag;
    }

    public void resetPSSysSFPubPkgsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubPkgsCnt();
            return;
        }
        this.pssyssfpubpkgscntDirtyFlag = false;
        this.pssyssfpubpkgscnt = null;
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

    public void setPubFolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubFolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubfolder = string;
        this.pubfolderDirtyFlag = true;
    }

    public String getPubFolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubFolder();
        }
        return this.pubfolder;
    }

    public boolean isPubFolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubFolderDirty();
        }
        return this.pubfolderDirtyFlag;
    }

    public void resetPubFolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubFolder();
            return;
        }
        this.pubfolderDirtyFlag = false;
        this.pubfolder = null;
    }

    public void setPubTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag = string;
        this.pubtagDirtyFlag = true;
    }

    public String getPubTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag();
        }
        return this.pubtag;
    }

    public boolean isPubTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTagDirty();
        }
        return this.pubtagDirtyFlag;
    }

    public void resetPubTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag();
            return;
        }
        this.pubtagDirtyFlag = false;
        this.pubtag = null;
    }

    public void setPubTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag2 = string;
        this.pubtag2DirtyFlag = true;
    }

    public String getPubTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag2();
        }
        return this.pubtag2;
    }

    public boolean isPubTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTag2Dirty();
        }
        return this.pubtag2DirtyFlag;
    }

    public void resetPubTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag2();
            return;
        }
        this.pubtag2DirtyFlag = false;
        this.pubtag2 = null;
    }

    public void setPubTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag3 = string;
        this.pubtag3DirtyFlag = true;
    }

    public String getPubTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag3();
        }
        return this.pubtag3;
    }

    public boolean isPubTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTag3Dirty();
        }
        return this.pubtag3DirtyFlag;
    }

    public void resetPubTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag3();
            return;
        }
        this.pubtag3DirtyFlag = false;
        this.pubtag3 = null;
    }

    public void setPubTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubtag4 = string;
        this.pubtag4DirtyFlag = true;
    }

    public String getPubTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubTag4();
        }
        return this.pubtag4;
    }

    public boolean isPubTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubTag4Dirty();
        }
        return this.pubtag4DirtyFlag;
    }

    public void resetPubTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubTag4();
            return;
        }
        this.pubtag4DirtyFlag = false;
        this.pubtag4 = null;
    }

    public void setRemoveFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoveFlag(n);
            return;
        }
        this.removeflag = n;
        this.removeflagDirtyFlag = true;
    }

    public Integer getRemoveFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoveFlag();
        }
        return this.removeflag;
    }

    public boolean isRemoveFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoveFlagDirty();
        }
        return this.removeflagDirtyFlag;
    }

    public void resetRemoveFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoveFlag();
            return;
        }
        this.removeflagDirtyFlag = false;
        this.removeflag = null;
    }

    public void setStyleParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.styleparams = string;
        this.styleparamsDirtyFlag = true;
    }

    public String getStyleParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleParams();
        }
        return this.styleparams;
    }

    public boolean isStyleParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleParamsDirty();
        }
        return this.styleparamsDirtyFlag;
    }

    public void resetStyleParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleParams();
            return;
        }
        this.styleparamsDirtyFlag = false;
        this.styleparams = null;
    }

    public void setSubSysPkgFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysPkgFlag(n);
            return;
        }
        this.subsyspkgflag = n;
        this.subsyspkgflagDirtyFlag = true;
    }

    public Integer getSubSysPkgFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysPkgFlag();
        }
        return this.subsyspkgflag;
    }

    public boolean isSubSysPkgFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysPkgFlagDirty();
        }
        return this.subsyspkgflagDirtyFlag;
    }

    public void resetSubSysPkgFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysPkgFlag();
            return;
        }
        this.subsyspkgflagDirtyFlag = false;
        this.subsyspkgflag = null;
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
        PSSysSFPubBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSFPubBase pSSysSFPubBase) {
        pSSysSFPubBase.resetBaseClsParams();
        pSSysSFPubBase.resetBaseCLSPKGCodeName();
        pSSysSFPubBase.resetCodeName();
        pSSysSFPubBase.resetContentType();
        pSSysSFPubBase.resetCreateDate();
        pSSysSFPubBase.resetCreateMan();
        pSSysSFPubBase.resetDefaultPub();
        pSSysSFPubBase.resetDocPSSFStyleId();
        pSSysSFPubBase.resetDocPSSFStyleName();
        pSSysSFPubBase.resetDynaModelMode();
        pSSysSFPubBase.resetGlobalTSFlag();
        pSSysSFPubBase.resetMemo();
        pSSysSFPubBase.resetPKGCodeName();
        pSSysSFPubBase.resetPPSSysSFPubId();
        pSSysSFPubBase.resetPPSSysSFPubName();
        pSSysSFPubBase.resetPSSFStyleId();
        pSSysSFPubBase.resetPSSFStyleName();
        pSSysSFPubBase.resetPSSFStyleParamId();
        pSSysSFPubBase.resetPSSFStyleParamName();
        pSSysSFPubBase.resetPSSFStyleVerId();
        pSSysSFPubBase.resetPSSFStyleVerName();
        pSSysSFPubBase.resetPSSysDynaModelId();
        pSSysSFPubBase.resetPSSysDynaModelName();
        pSSysSFPubBase.resetPSSysSFCodesCnt();
        pSSysSFPubBase.resetPSSysSFPubId();
        pSSysSFPubBase.resetPSSysSFPubName();
        pSSysSFPubBase.resetPSSysSFPubPkgsCnt();
        pSSysSFPubBase.resetPSSystemId();
        pSSysSFPubBase.resetPSSystemName();
        pSSysSFPubBase.resetPubFolder();
        pSSysSFPubBase.resetPubTag();
        pSSysSFPubBase.resetPubTag2();
        pSSysSFPubBase.resetPubTag3();
        pSSysSFPubBase.resetPubTag4();
        pSSysSFPubBase.resetRemoveFlag();
        pSSysSFPubBase.resetStyleParams();
        pSSysSFPubBase.resetSubSysPkgFlag();
        pSSysSFPubBase.resetUpdateDate();
        pSSysSFPubBase.resetUpdateMan();
        pSSysSFPubBase.resetUserCat();
        pSSysSFPubBase.resetUserTag();
        pSSysSFPubBase.resetUserTag2();
        pSSysSFPubBase.resetUserTag3();
        pSSysSFPubBase.resetUserTag4();
        pSSysSFPubBase.resetVerStr();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isBaseCLSPKGCodeNameDirty()) {
            hashMap.put(FIELD_BASECLSPKGCODENAME, this.getBaseCLSPKGCodeName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultPubDirty()) {
            hashMap.put(FIELD_DEFAULTPUB, this.getDefaultPub());
        }
        if (!bl || this.isDocPSSFStyleIdDirty()) {
            hashMap.put(FIELD_DOCPSSFSTYLEID, this.getDocPSSFStyleId());
        }
        if (!bl || this.isDocPSSFStyleNameDirty()) {
            hashMap.put(FIELD_DOCPSSFSTYLENAME, this.getDocPSSFStyleName());
        }
        if (!bl || this.isDynaModelModeDirty()) {
            hashMap.put(FIELD_DYNAMODELMODE, this.getDynaModelMode());
        }
        if (!bl || this.isGlobalTSFlagDirty()) {
            hashMap.put(FIELD_GLOBALTSFLAG, this.getGlobalTSFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPKGCodeNameDirty()) {
            hashMap.put(FIELD_PKGCODENAME, this.getPKGCodeName());
        }
        if (!bl || this.isPPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PPSSYSSFPUBID, this.getPPSSysSFPubId());
        }
        if (!bl || this.isPPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PPSSYSSFPUBNAME, this.getPPSSysSFPubName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStyleParamIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPARAMID, this.getPSSFStyleParamId());
        }
        if (!bl || this.isPSSFStyleParamNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPARAMNAME, this.getPSSFStyleParamName());
        }
        if (!bl || this.isPSSFStyleVerIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERID, this.getPSSFStyleVerId());
        }
        if (!bl || this.isPSSFStyleVerNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEVERNAME, this.getPSSFStyleVerName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysSFCodesCntDirty()) {
            hashMap.put(FIELD_PSSYSSFCODESCNT, this.getPSSysSFCodesCnt());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSysSFPubPkgsCntDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBPKGSCNT, this.getPSSysSFPubPkgsCnt());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPubFolderDirty()) {
            hashMap.put(FIELD_PUBFOLDER, this.getPubFolder());
        }
        if (!bl || this.isPubTagDirty()) {
            hashMap.put(FIELD_PUBTAG, this.getPubTag());
        }
        if (!bl || this.isPubTag2Dirty()) {
            hashMap.put(FIELD_PUBTAG2, this.getPubTag2());
        }
        if (!bl || this.isPubTag3Dirty()) {
            hashMap.put(FIELD_PUBTAG3, this.getPubTag3());
        }
        if (!bl || this.isPubTag4Dirty()) {
            hashMap.put(FIELD_PUBTAG4, this.getPubTag4());
        }
        if (!bl || this.isRemoveFlagDirty()) {
            hashMap.put(FIELD_REMOVEFLAG, this.getRemoveFlag());
        }
        if (!bl || this.isStyleParamsDirty()) {
            hashMap.put(FIELD_STYLEPARAMS, this.getStyleParams());
        }
        if (!bl || this.isSubSysPkgFlagDirty()) {
            hashMap.put(FIELD_SUBSYSPKGFLAG, this.getSubSysPkgFlag());
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
        return PSSysSFPubBase.get(this, n);
    }

    private static Object get(PSSysSFPubBase pSSysSFPubBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubBase.getBaseClsParams();
            }
            case 1: {
                return pSSysSFPubBase.getBaseCLSPKGCodeName();
            }
            case 2: {
                return pSSysSFPubBase.getCodeName();
            }
            case 3: {
                return pSSysSFPubBase.getContentType();
            }
            case 4: {
                return pSSysSFPubBase.getCreateDate();
            }
            case 5: {
                return pSSysSFPubBase.getCreateMan();
            }
            case 6: {
                return pSSysSFPubBase.getDefaultPub();
            }
            case 7: {
                return pSSysSFPubBase.getDocPSSFStyleId();
            }
            case 8: {
                return pSSysSFPubBase.getDocPSSFStyleName();
            }
            case 9: {
                return pSSysSFPubBase.getDynaModelMode();
            }
            case 10: {
                return pSSysSFPubBase.getGlobalTSFlag();
            }
            case 11: {
                return pSSysSFPubBase.getMemo();
            }
            case 12: {
                return pSSysSFPubBase.getPKGCodeName();
            }
            case 13: {
                return pSSysSFPubBase.getPPSSysSFPubId();
            }
            case 14: {
                return pSSysSFPubBase.getPPSSysSFPubName();
            }
            case 15: {
                return pSSysSFPubBase.getPSSFStyleId();
            }
            case 16: {
                return pSSysSFPubBase.getPSSFStyleName();
            }
            case 17: {
                return pSSysSFPubBase.getPSSFStyleParamId();
            }
            case 18: {
                return pSSysSFPubBase.getPSSFStyleParamName();
            }
            case 19: {
                return pSSysSFPubBase.getPSSFStyleVerId();
            }
            case 20: {
                return pSSysSFPubBase.getPSSFStyleVerName();
            }
            case 21: {
                return pSSysSFPubBase.getPSSysDynaModelId();
            }
            case 22: {
                return pSSysSFPubBase.getPSSysDynaModelName();
            }
            case 23: {
                return pSSysSFPubBase.getPSSysSFCodesCnt();
            }
            case 24: {
                return pSSysSFPubBase.getPSSysSFPubId();
            }
            case 25: {
                return pSSysSFPubBase.getPSSysSFPubName();
            }
            case 26: {
                return pSSysSFPubBase.getPSSysSFPubPkgsCnt();
            }
            case 27: {
                return pSSysSFPubBase.getPSSystemId();
            }
            case 28: {
                return pSSysSFPubBase.getPSSystemName();
            }
            case 29: {
                return pSSysSFPubBase.getPubFolder();
            }
            case 30: {
                return pSSysSFPubBase.getPubTag();
            }
            case 31: {
                return pSSysSFPubBase.getPubTag2();
            }
            case 32: {
                return pSSysSFPubBase.getPubTag3();
            }
            case 33: {
                return pSSysSFPubBase.getPubTag4();
            }
            case 34: {
                return pSSysSFPubBase.getRemoveFlag();
            }
            case 35: {
                return pSSysSFPubBase.getStyleParams();
            }
            case 36: {
                return pSSysSFPubBase.getSubSysPkgFlag();
            }
            case 37: {
                return pSSysSFPubBase.getUpdateDate();
            }
            case 38: {
                return pSSysSFPubBase.getUpdateMan();
            }
            case 39: {
                return pSSysSFPubBase.getUserCat();
            }
            case 40: {
                return pSSysSFPubBase.getUserTag();
            }
            case 41: {
                return pSSysSFPubBase.getUserTag2();
            }
            case 42: {
                return pSSysSFPubBase.getUserTag3();
            }
            case 43: {
                return pSSysSFPubBase.getUserTag4();
            }
            case 44: {
                return pSSysSFPubBase.getVerStr();
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
        PSSysSFPubBase.set(this, n, object);
    }

    private static void set(PSSysSFPubBase pSSysSFPubBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPubBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSFPubBase.setBaseCLSPKGCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSFPubBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSFPubBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSFPubBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysSFPubBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSFPubBase.setDefaultPub(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysSFPubBase.setDocPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSFPubBase.setDocPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSFPubBase.setDynaModelMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSFPubBase.setGlobalTSFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysSFPubBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSFPubBase.setPKGCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSFPubBase.setPPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSFPubBase.setPPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSFPubBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSFPubBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSFPubBase.setPSSFStyleParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSFPubBase.setPSSFStyleParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSFPubBase.setPSSFStyleVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSFPubBase.setPSSFStyleVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSFPubBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSFPubBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSFPubBase.setPSSysSFCodesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSysSFPubBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSFPubBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSFPubBase.setPSSysSFPubPkgsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysSFPubBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSFPubBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSFPubBase.setPubFolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSFPubBase.setPubTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysSFPubBase.setPubTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysSFPubBase.setPubTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysSFPubBase.setPubTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysSFPubBase.setRemoveFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSSysSFPubBase.setStyleParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysSFPubBase.setSubSysPkgFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSSysSFPubBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSSysSFPubBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysSFPubBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysSFPubBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysSFPubBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysSFPubBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysSFPubBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysSFPubBase.setVerStr(DataObject.getStringValue((Object)object));
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
        return PSSysSFPubBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSFPubBase pSSysSFPubBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSSysSFPubBase.getBaseCLSPKGCodeName() == null;
            }
            case 2: {
                return pSSysSFPubBase.getCodeName() == null;
            }
            case 3: {
                return pSSysSFPubBase.getContentType() == null;
            }
            case 4: {
                return pSSysSFPubBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysSFPubBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysSFPubBase.getDefaultPub() == null;
            }
            case 7: {
                return pSSysSFPubBase.getDocPSSFStyleId() == null;
            }
            case 8: {
                return pSSysSFPubBase.getDocPSSFStyleName() == null;
            }
            case 9: {
                return pSSysSFPubBase.getDynaModelMode() == null;
            }
            case 10: {
                return pSSysSFPubBase.getGlobalTSFlag() == null;
            }
            case 11: {
                return pSSysSFPubBase.getMemo() == null;
            }
            case 12: {
                return pSSysSFPubBase.getPKGCodeName() == null;
            }
            case 13: {
                return pSSysSFPubBase.getPPSSysSFPubId() == null;
            }
            case 14: {
                return pSSysSFPubBase.getPPSSysSFPubName() == null;
            }
            case 15: {
                return pSSysSFPubBase.getPSSFStyleId() == null;
            }
            case 16: {
                return pSSysSFPubBase.getPSSFStyleName() == null;
            }
            case 17: {
                return pSSysSFPubBase.getPSSFStyleParamId() == null;
            }
            case 18: {
                return pSSysSFPubBase.getPSSFStyleParamName() == null;
            }
            case 19: {
                return pSSysSFPubBase.getPSSFStyleVerId() == null;
            }
            case 20: {
                return pSSysSFPubBase.getPSSFStyleVerName() == null;
            }
            case 21: {
                return pSSysSFPubBase.getPSSysDynaModelId() == null;
            }
            case 22: {
                return pSSysSFPubBase.getPSSysDynaModelName() == null;
            }
            case 23: {
                return pSSysSFPubBase.getPSSysSFCodesCnt() == null;
            }
            case 24: {
                return pSSysSFPubBase.getPSSysSFPubId() == null;
            }
            case 25: {
                return pSSysSFPubBase.getPSSysSFPubName() == null;
            }
            case 26: {
                return pSSysSFPubBase.getPSSysSFPubPkgsCnt() == null;
            }
            case 27: {
                return pSSysSFPubBase.getPSSystemId() == null;
            }
            case 28: {
                return pSSysSFPubBase.getPSSystemName() == null;
            }
            case 29: {
                return pSSysSFPubBase.getPubFolder() == null;
            }
            case 30: {
                return pSSysSFPubBase.getPubTag() == null;
            }
            case 31: {
                return pSSysSFPubBase.getPubTag2() == null;
            }
            case 32: {
                return pSSysSFPubBase.getPubTag3() == null;
            }
            case 33: {
                return pSSysSFPubBase.getPubTag4() == null;
            }
            case 34: {
                return pSSysSFPubBase.getRemoveFlag() == null;
            }
            case 35: {
                return pSSysSFPubBase.getStyleParams() == null;
            }
            case 36: {
                return pSSysSFPubBase.getSubSysPkgFlag() == null;
            }
            case 37: {
                return pSSysSFPubBase.getUpdateDate() == null;
            }
            case 38: {
                return pSSysSFPubBase.getUpdateMan() == null;
            }
            case 39: {
                return pSSysSFPubBase.getUserCat() == null;
            }
            case 40: {
                return pSSysSFPubBase.getUserTag() == null;
            }
            case 41: {
                return pSSysSFPubBase.getUserTag2() == null;
            }
            case 42: {
                return pSSysSFPubBase.getUserTag3() == null;
            }
            case 43: {
                return pSSysSFPubBase.getUserTag4() == null;
            }
            case 44: {
                return pSSysSFPubBase.getVerStr() == null;
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
        return PSSysSFPubBase.contains(this, n);
    }

    private static boolean contains(PSSysSFPubBase pSSysSFPubBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSSysSFPubBase.isBaseCLSPKGCodeNameDirty();
            }
            case 2: {
                return pSSysSFPubBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysSFPubBase.isContentTypeDirty();
            }
            case 4: {
                return pSSysSFPubBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysSFPubBase.isCreateManDirty();
            }
            case 6: {
                return pSSysSFPubBase.isDefaultPubDirty();
            }
            case 7: {
                return pSSysSFPubBase.isDocPSSFStyleIdDirty();
            }
            case 8: {
                return pSSysSFPubBase.isDocPSSFStyleNameDirty();
            }
            case 9: {
                return pSSysSFPubBase.isDynaModelModeDirty();
            }
            case 10: {
                return pSSysSFPubBase.isGlobalTSFlagDirty();
            }
            case 11: {
                return pSSysSFPubBase.isMemoDirty();
            }
            case 12: {
                return pSSysSFPubBase.isPKGCodeNameDirty();
            }
            case 13: {
                return pSSysSFPubBase.isPPSSysSFPubIdDirty();
            }
            case 14: {
                return pSSysSFPubBase.isPPSSysSFPubNameDirty();
            }
            case 15: {
                return pSSysSFPubBase.isPSSFStyleIdDirty();
            }
            case 16: {
                return pSSysSFPubBase.isPSSFStyleNameDirty();
            }
            case 17: {
                return pSSysSFPubBase.isPSSFStyleParamIdDirty();
            }
            case 18: {
                return pSSysSFPubBase.isPSSFStyleParamNameDirty();
            }
            case 19: {
                return pSSysSFPubBase.isPSSFStyleVerIdDirty();
            }
            case 20: {
                return pSSysSFPubBase.isPSSFStyleVerNameDirty();
            }
            case 21: {
                return pSSysSFPubBase.isPSSysDynaModelIdDirty();
            }
            case 22: {
                return pSSysSFPubBase.isPSSysDynaModelNameDirty();
            }
            case 23: {
                return pSSysSFPubBase.isPSSysSFCodesCntDirty();
            }
            case 24: {
                return pSSysSFPubBase.isPSSysSFPubIdDirty();
            }
            case 25: {
                return pSSysSFPubBase.isPSSysSFPubNameDirty();
            }
            case 26: {
                return pSSysSFPubBase.isPSSysSFPubPkgsCntDirty();
            }
            case 27: {
                return pSSysSFPubBase.isPSSystemIdDirty();
            }
            case 28: {
                return pSSysSFPubBase.isPSSystemNameDirty();
            }
            case 29: {
                return pSSysSFPubBase.isPubFolderDirty();
            }
            case 30: {
                return pSSysSFPubBase.isPubTagDirty();
            }
            case 31: {
                return pSSysSFPubBase.isPubTag2Dirty();
            }
            case 32: {
                return pSSysSFPubBase.isPubTag3Dirty();
            }
            case 33: {
                return pSSysSFPubBase.isPubTag4Dirty();
            }
            case 34: {
                return pSSysSFPubBase.isRemoveFlagDirty();
            }
            case 35: {
                return pSSysSFPubBase.isStyleParamsDirty();
            }
            case 36: {
                return pSSysSFPubBase.isSubSysPkgFlagDirty();
            }
            case 37: {
                return pSSysSFPubBase.isUpdateDateDirty();
            }
            case 38: {
                return pSSysSFPubBase.isUpdateManDirty();
            }
            case 39: {
                return pSSysSFPubBase.isUserCatDirty();
            }
            case 40: {
                return pSSysSFPubBase.isUserTagDirty();
            }
            case 41: {
                return pSSysSFPubBase.isUserTag2Dirty();
            }
            case 42: {
                return pSSysSFPubBase.isUserTag3Dirty();
            }
            case 43: {
                return pSSysSFPubBase.isUserTag4Dirty();
            }
            case 44: {
                return pSSysSFPubBase.isVerStrDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSFPubBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSFPubBase pSSysSFPubBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSFPubBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getBaseCLSPKGCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclspkgcodename", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getBaseCLSPKGCodeName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getContentType()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getDefaultPub() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultpub", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getDefaultPub()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getDocPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docpssfstyleid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getDocPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getDocPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docpssfstylename", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getDocPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getDynaModelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelmode", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getDynaModelMode()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getGlobalTSFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"globaltsflag", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getGlobalTSFlag()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPKGCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgcodename", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPKGCodeName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssyssfpubid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssyssfpubname", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleparamid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSFStyleParamId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleparamname", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSFStyleParamName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleverid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSFStyleVerId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylevername", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSFStyleVerName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSysSFCodesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfcodescnt", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSysSFCodesCnt()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSysSFPubPkgsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubpkgscnt", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSysSFPubPkgsCnt()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPubFolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubfolder", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPubFolder()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPubTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPubTag()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPubTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag2", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPubTag2()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPubTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag3", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPubTag3()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getPubTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubtag4", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getPubTag4()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getRemoveFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"removeflag", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getRemoveFlag()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getStyleParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleparams", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getStyleParams()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getSubSysPkgFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsyspkgflag", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getSubSysPkgFlag()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSFPubBase.getVerStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verstr", (Object)PSSysSFPubBase.getJSONValue((Object)pSSysSFPubBase.getVerStr()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSFPubBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSFPubBase pSSysSFPubBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSFPubBase.getBaseClsParams() != null) {
            object = pSSysSFPubBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSFPubBase.getBaseCLSPKGCodeName() != null) {
            object = pSSysSFPubBase.getBaseCLSPKGCodeName();
            xmlNode.setAttribute(FIELD_BASECLSPKGCODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSFPubBase.getCodeName() != null) {
            object = pSSysSFPubBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSFPubBase.getContentType() != null) {
            object = pSSysSFPubBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getCreateDate() != null) {
            object = pSSysSFPubBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPubBase.getCreateMan() != null) {
            object = pSSysSFPubBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getDefaultPub() != null) {
            object = pSSysSFPubBase.getDefaultPub();
            xmlNode.setAttribute(FIELD_DEFAULTPUB, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubBase.getDocPSSFStyleId() != null) {
            object = pSSysSFPubBase.getDocPSSFStyleId();
            xmlNode.setAttribute(FIELD_DOCPSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getDocPSSFStyleName() != null) {
            object = pSSysSFPubBase.getDocPSSFStyleName();
            xmlNode.setAttribute(FIELD_DOCPSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getDynaModelMode() != null) {
            object = pSSysSFPubBase.getDynaModelMode();
            xmlNode.setAttribute(FIELD_DYNAMODELMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getGlobalTSFlag() != null) {
            object = pSSysSFPubBase.getGlobalTSFlag();
            xmlNode.setAttribute(FIELD_GLOBALTSFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubBase.getMemo() != null) {
            object = pSSysSFPubBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPKGCodeName() != null) {
            object = pSSysSFPubBase.getPKGCodeName();
            xmlNode.setAttribute(FIELD_PKGCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPPSSysSFPubId() != null) {
            object = pSSysSFPubBase.getPPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PPSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPPSSysSFPubName() != null) {
            object = pSSysSFPubBase.getPPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PPSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleId() != null) {
            object = pSSysSFPubBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleName() != null) {
            object = pSSysSFPubBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleParamId() != null) {
            object = pSSysSFPubBase.getPSSFStyleParamId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleParamName() != null) {
            object = pSSysSFPubBase.getPSSFStyleParamName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleVerId() != null) {
            object = pSSysSFPubBase.getPSSFStyleVerId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSFStyleVerName() != null) {
            object = pSSysSFPubBase.getPSSFStyleVerName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSysDynaModelId() != null) {
            object = pSSysSFPubBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSysDynaModelName() != null) {
            object = pSSysSFPubBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSysSFCodesCnt() != null) {
            object = pSSysSFPubBase.getPSSysSFCodesCnt();
            xmlNode.setAttribute(FIELD_PSSYSSFCODESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubBase.getPSSysSFPubId() != null) {
            object = pSSysSFPubBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSysSFPubName() != null) {
            object = pSSysSFPubBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSysSFPubPkgsCnt() != null) {
            object = pSSysSFPubBase.getPSSysSFPubPkgsCnt();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBPKGSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubBase.getPSSystemId() != null) {
            object = pSSysSFPubBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPSSystemName() != null) {
            object = pSSysSFPubBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPubFolder() != null) {
            object = pSSysSFPubBase.getPubFolder();
            xmlNode.setAttribute(FIELD_PUBFOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPubTag() != null) {
            object = pSSysSFPubBase.getPubTag();
            xmlNode.setAttribute(FIELD_PUBTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPubTag2() != null) {
            object = pSSysSFPubBase.getPubTag2();
            xmlNode.setAttribute(FIELD_PUBTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPubTag3() != null) {
            object = pSSysSFPubBase.getPubTag3();
            xmlNode.setAttribute(FIELD_PUBTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getPubTag4() != null) {
            object = pSSysSFPubBase.getPubTag4();
            xmlNode.setAttribute(FIELD_PUBTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getRemoveFlag() != null) {
            object = pSSysSFPubBase.getRemoveFlag();
            xmlNode.setAttribute(FIELD_REMOVEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubBase.getStyleParams() != null) {
            object = pSSysSFPubBase.getStyleParams();
            xmlNode.setAttribute(FIELD_STYLEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getSubSysPkgFlag() != null) {
            object = pSSysSFPubBase.getSubSysPkgFlag();
            xmlNode.setAttribute(FIELD_SUBSYSPKGFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubBase.getUpdateDate() != null) {
            object = pSSysSFPubBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPubBase.getUpdateMan() != null) {
            object = pSSysSFPubBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getUserCat() != null) {
            object = pSSysSFPubBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getUserTag() != null) {
            object = pSSysSFPubBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getUserTag2() != null) {
            object = pSSysSFPubBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getUserTag3() != null) {
            object = pSSysSFPubBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getUserTag4() != null) {
            object = pSSysSFPubBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubBase.getVerStr() != null) {
            object = pSSysSFPubBase.getVerStr();
            xmlNode.setAttribute(FIELD_VERSTR, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSFPubBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSFPubBase pSSysSFPubBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSFPubBase.isBaseClsParamsDirty() && (bl || pSSysSFPubBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSSysSFPubBase.getBaseClsParams());
        }
        if (pSSysSFPubBase.isBaseCLSPKGCodeNameDirty() && (bl || pSSysSFPubBase.getBaseCLSPKGCodeName() != null)) {
            iDataObject.set(FIELD_BASECLSPKGCODENAME, (Object)pSSysSFPubBase.getBaseCLSPKGCodeName());
        }
        if (pSSysSFPubBase.isCodeNameDirty() && (bl || pSSysSFPubBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSFPubBase.getCodeName());
        }
        if (pSSysSFPubBase.isContentTypeDirty() && (bl || pSSysSFPubBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSSysSFPubBase.getContentType());
        }
        if (pSSysSFPubBase.isCreateDateDirty() && (bl || pSSysSFPubBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSFPubBase.getCreateDate());
        }
        if (pSSysSFPubBase.isCreateManDirty() && (bl || pSSysSFPubBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSFPubBase.getCreateMan());
        }
        if (pSSysSFPubBase.isDefaultPubDirty() && (bl || pSSysSFPubBase.getDefaultPub() != null)) {
            iDataObject.set(FIELD_DEFAULTPUB, (Object)pSSysSFPubBase.getDefaultPub());
        }
        if (pSSysSFPubBase.isDocPSSFStyleIdDirty() && (bl || pSSysSFPubBase.getDocPSSFStyleId() != null)) {
            iDataObject.set(FIELD_DOCPSSFSTYLEID, (Object)pSSysSFPubBase.getDocPSSFStyleId());
        }
        if (pSSysSFPubBase.isDocPSSFStyleNameDirty() && (bl || pSSysSFPubBase.getDocPSSFStyleName() != null)) {
            iDataObject.set(FIELD_DOCPSSFSTYLENAME, (Object)pSSysSFPubBase.getDocPSSFStyleName());
        }
        if (pSSysSFPubBase.isDynaModelModeDirty() && (bl || pSSysSFPubBase.getDynaModelMode() != null)) {
            iDataObject.set(FIELD_DYNAMODELMODE, (Object)pSSysSFPubBase.getDynaModelMode());
        }
        if (pSSysSFPubBase.isGlobalTSFlagDirty() && (bl || pSSysSFPubBase.getGlobalTSFlag() != null)) {
            iDataObject.set(FIELD_GLOBALTSFLAG, (Object)pSSysSFPubBase.getGlobalTSFlag());
        }
        if (pSSysSFPubBase.isMemoDirty() && (bl || pSSysSFPubBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSFPubBase.getMemo());
        }
        if (pSSysSFPubBase.isPKGCodeNameDirty() && (bl || pSSysSFPubBase.getPKGCodeName() != null)) {
            iDataObject.set(FIELD_PKGCODENAME, (Object)pSSysSFPubBase.getPKGCodeName());
        }
        if (pSSysSFPubBase.isPPSSysSFPubIdDirty() && (bl || pSSysSFPubBase.getPPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PPSSYSSFPUBID, (Object)pSSysSFPubBase.getPPSSysSFPubId());
        }
        if (pSSysSFPubBase.isPPSSysSFPubNameDirty() && (bl || pSSysSFPubBase.getPPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PPSSYSSFPUBNAME, (Object)pSSysSFPubBase.getPPSSysSFPubName());
        }
        if (pSSysSFPubBase.isPSSFStyleIdDirty() && (bl || pSSysSFPubBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSysSFPubBase.getPSSFStyleId());
        }
        if (pSSysSFPubBase.isPSSFStyleNameDirty() && (bl || pSSysSFPubBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSysSFPubBase.getPSSFStyleName());
        }
        if (pSSysSFPubBase.isPSSFStyleParamIdDirty() && (bl || pSSysSFPubBase.getPSSFStyleParamId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPARAMID, (Object)pSSysSFPubBase.getPSSFStyleParamId());
        }
        if (pSSysSFPubBase.isPSSFStyleParamNameDirty() && (bl || pSSysSFPubBase.getPSSFStyleParamName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPARAMNAME, (Object)pSSysSFPubBase.getPSSFStyleParamName());
        }
        if (pSSysSFPubBase.isPSSFStyleVerIdDirty() && (bl || pSSysSFPubBase.getPSSFStyleVerId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERID, (Object)pSSysSFPubBase.getPSSFStyleVerId());
        }
        if (pSSysSFPubBase.isPSSFStyleVerNameDirty() && (bl || pSSysSFPubBase.getPSSFStyleVerName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEVERNAME, (Object)pSSysSFPubBase.getPSSFStyleVerName());
        }
        if (pSSysSFPubBase.isPSSysDynaModelIdDirty() && (bl || pSSysSFPubBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysSFPubBase.getPSSysDynaModelId());
        }
        if (pSSysSFPubBase.isPSSysDynaModelNameDirty() && (bl || pSSysSFPubBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysSFPubBase.getPSSysDynaModelName());
        }
        if (pSSysSFPubBase.isPSSysSFCodesCntDirty() && (bl || pSSysSFPubBase.getPSSysSFCodesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSSFCODESCNT, (Object)pSSysSFPubBase.getPSSysSFCodesCnt());
        }
        if (pSSysSFPubBase.isPSSysSFPubIdDirty() && (bl || pSSysSFPubBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysSFPubBase.getPSSysSFPubId());
        }
        if (pSSysSFPubBase.isPSSysSFPubNameDirty() && (bl || pSSysSFPubBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysSFPubBase.getPSSysSFPubName());
        }
        if (pSSysSFPubBase.isPSSysSFPubPkgsCntDirty() && (bl || pSSysSFPubBase.getPSSysSFPubPkgsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBPKGSCNT, (Object)pSSysSFPubBase.getPSSysSFPubPkgsCnt());
        }
        if (pSSysSFPubBase.isPSSystemIdDirty() && (bl || pSSysSFPubBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSFPubBase.getPSSystemId());
        }
        if (pSSysSFPubBase.isPSSystemNameDirty() && (bl || pSSysSFPubBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSFPubBase.getPSSystemName());
        }
        if (pSSysSFPubBase.isPubFolderDirty() && (bl || pSSysSFPubBase.getPubFolder() != null)) {
            iDataObject.set(FIELD_PUBFOLDER, (Object)pSSysSFPubBase.getPubFolder());
        }
        if (pSSysSFPubBase.isPubTagDirty() && (bl || pSSysSFPubBase.getPubTag() != null)) {
            iDataObject.set(FIELD_PUBTAG, (Object)pSSysSFPubBase.getPubTag());
        }
        if (pSSysSFPubBase.isPubTag2Dirty() && (bl || pSSysSFPubBase.getPubTag2() != null)) {
            iDataObject.set(FIELD_PUBTAG2, (Object)pSSysSFPubBase.getPubTag2());
        }
        if (pSSysSFPubBase.isPubTag3Dirty() && (bl || pSSysSFPubBase.getPubTag3() != null)) {
            iDataObject.set(FIELD_PUBTAG3, (Object)pSSysSFPubBase.getPubTag3());
        }
        if (pSSysSFPubBase.isPubTag4Dirty() && (bl || pSSysSFPubBase.getPubTag4() != null)) {
            iDataObject.set(FIELD_PUBTAG4, (Object)pSSysSFPubBase.getPubTag4());
        }
        if (pSSysSFPubBase.isRemoveFlagDirty() && (bl || pSSysSFPubBase.getRemoveFlag() != null)) {
            iDataObject.set(FIELD_REMOVEFLAG, (Object)pSSysSFPubBase.getRemoveFlag());
        }
        if (pSSysSFPubBase.isStyleParamsDirty() && (bl || pSSysSFPubBase.getStyleParams() != null)) {
            iDataObject.set(FIELD_STYLEPARAMS, (Object)pSSysSFPubBase.getStyleParams());
        }
        if (pSSysSFPubBase.isSubSysPkgFlagDirty() && (bl || pSSysSFPubBase.getSubSysPkgFlag() != null)) {
            iDataObject.set(FIELD_SUBSYSPKGFLAG, (Object)pSSysSFPubBase.getSubSysPkgFlag());
        }
        if (pSSysSFPubBase.isUpdateDateDirty() && (bl || pSSysSFPubBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSFPubBase.getUpdateDate());
        }
        if (pSSysSFPubBase.isUpdateManDirty() && (bl || pSSysSFPubBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSFPubBase.getUpdateMan());
        }
        if (pSSysSFPubBase.isUserCatDirty() && (bl || pSSysSFPubBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSFPubBase.getUserCat());
        }
        if (pSSysSFPubBase.isUserTagDirty() && (bl || pSSysSFPubBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSFPubBase.getUserTag());
        }
        if (pSSysSFPubBase.isUserTag2Dirty() && (bl || pSSysSFPubBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSFPubBase.getUserTag2());
        }
        if (pSSysSFPubBase.isUserTag3Dirty() && (bl || pSSysSFPubBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSFPubBase.getUserTag3());
        }
        if (pSSysSFPubBase.isUserTag4Dirty() && (bl || pSSysSFPubBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSFPubBase.getUserTag4());
        }
        if (pSSysSFPubBase.isVerStrDirty() && (bl || pSSysSFPubBase.getVerStr() != null)) {
            iDataObject.set(FIELD_VERSTR, (Object)pSSysSFPubBase.getVerStr());
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
        return PSSysSFPubBase.remove(this, n);
    }

    private static boolean remove(PSSysSFPubBase pSSysSFPubBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPubBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSSysSFPubBase.resetBaseCLSPKGCodeName();
                return true;
            }
            case 2: {
                pSSysSFPubBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysSFPubBase.resetContentType();
                return true;
            }
            case 4: {
                pSSysSFPubBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysSFPubBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysSFPubBase.resetDefaultPub();
                return true;
            }
            case 7: {
                pSSysSFPubBase.resetDocPSSFStyleId();
                return true;
            }
            case 8: {
                pSSysSFPubBase.resetDocPSSFStyleName();
                return true;
            }
            case 9: {
                pSSysSFPubBase.resetDynaModelMode();
                return true;
            }
            case 10: {
                pSSysSFPubBase.resetGlobalTSFlag();
                return true;
            }
            case 11: {
                pSSysSFPubBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysSFPubBase.resetPKGCodeName();
                return true;
            }
            case 13: {
                pSSysSFPubBase.resetPPSSysSFPubId();
                return true;
            }
            case 14: {
                pSSysSFPubBase.resetPPSSysSFPubName();
                return true;
            }
            case 15: {
                pSSysSFPubBase.resetPSSFStyleId();
                return true;
            }
            case 16: {
                pSSysSFPubBase.resetPSSFStyleName();
                return true;
            }
            case 17: {
                pSSysSFPubBase.resetPSSFStyleParamId();
                return true;
            }
            case 18: {
                pSSysSFPubBase.resetPSSFStyleParamName();
                return true;
            }
            case 19: {
                pSSysSFPubBase.resetPSSFStyleVerId();
                return true;
            }
            case 20: {
                pSSysSFPubBase.resetPSSFStyleVerName();
                return true;
            }
            case 21: {
                pSSysSFPubBase.resetPSSysDynaModelId();
                return true;
            }
            case 22: {
                pSSysSFPubBase.resetPSSysDynaModelName();
                return true;
            }
            case 23: {
                pSSysSFPubBase.resetPSSysSFCodesCnt();
                return true;
            }
            case 24: {
                pSSysSFPubBase.resetPSSysSFPubId();
                return true;
            }
            case 25: {
                pSSysSFPubBase.resetPSSysSFPubName();
                return true;
            }
            case 26: {
                pSSysSFPubBase.resetPSSysSFPubPkgsCnt();
                return true;
            }
            case 27: {
                pSSysSFPubBase.resetPSSystemId();
                return true;
            }
            case 28: {
                pSSysSFPubBase.resetPSSystemName();
                return true;
            }
            case 29: {
                pSSysSFPubBase.resetPubFolder();
                return true;
            }
            case 30: {
                pSSysSFPubBase.resetPubTag();
                return true;
            }
            case 31: {
                pSSysSFPubBase.resetPubTag2();
                return true;
            }
            case 32: {
                pSSysSFPubBase.resetPubTag3();
                return true;
            }
            case 33: {
                pSSysSFPubBase.resetPubTag4();
                return true;
            }
            case 34: {
                pSSysSFPubBase.resetRemoveFlag();
                return true;
            }
            case 35: {
                pSSysSFPubBase.resetStyleParams();
                return true;
            }
            case 36: {
                pSSysSFPubBase.resetSubSysPkgFlag();
                return true;
            }
            case 37: {
                pSSysSFPubBase.resetUpdateDate();
                return true;
            }
            case 38: {
                pSSysSFPubBase.resetUpdateMan();
                return true;
            }
            case 39: {
                pSSysSFPubBase.resetUserCat();
                return true;
            }
            case 40: {
                pSSysSFPubBase.resetUserTag();
                return true;
            }
            case 41: {
                pSSysSFPubBase.resetUserTag2();
                return true;
            }
            case 42: {
                pSSysSFPubBase.resetUserTag3();
                return true;
            }
            case 43: {
                pSSysSFPubBase.resetUserTag4();
                return true;
            }
            case 44: {
                pSSysSFPubBase.resetVerStr();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyleParam getPSSFStyleParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleParam();
        }
        if (this.getPSSFStyleParamId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleParamLock;
        synchronized (n) {
            if (this.pssfstyleparam != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleParamId(), (Object)this.pssfstyleparam.getPSSFStyleParamId()) != 0L) {
                this.pssfstyleparam = null;
            }
            if (this.pssfstyleparam == null) {
                PSSFStyleParam pSSFStyleParam = new PSSFStyleParam();
                pSSFStyleParam.setPSSFStyleParamId(this.getPSSFStyleParamId());
                PSSFStyleParamService pSSFStyleParamService = (PSSFStyleParamService)ServiceGlobal.getService(PSSFStyleParamService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleParamService.autoGet((IEntity)pSSFStyleParam);
                this.pssfstyleparam = pSSFStyleParam;
            }
            return this.pssfstyleparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyleVer getPSSFStyleVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleVer();
        }
        if (this.getPSSFStyleVerId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleVerLock;
        synchronized (n) {
            if (this.pssfstylever != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleVerId(), (Object)this.pssfstylever.getPSSFStyleVerId()) != 0L) {
                this.pssfstylever = null;
            }
            if (this.pssfstylever == null) {
                PSSFStyleVer pSSFStyleVer = new PSSFStyleVer();
                pSSFStyleVer.setPSSFStyleVerId(this.getPSSFStyleVerId());
                PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleVerService.autoGet((IEntity)pSSFStyleVer);
                this.pssfstylever = pSSFStyleVer;
            }
            return this.pssfstylever;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getDocPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocPSSFStyle();
        }
        if (this.getDocPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objDocPSSFStyleLock;
        synchronized (n) {
            if (this.docpssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getDocPSSFStyleId(), (Object)this.docpssfstyle.getPSSFStyleId()) != 0L) {
                this.docpssfstyle = null;
            }
            if (this.docpssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getDocPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.docpssfstyle = pSSFStyle;
            }
            return this.docpssfstyle;
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
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPub getPPSSysSFPub() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysSFPub();
        }
        if (this.getPPSSysSFPubId() == null) {
            return null;
        }
        Integer n = this.objPPSSysSFPubLock;
        synchronized (n) {
            if (this.ppssyssfpub != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysSFPubId(), (Object)this.ppssyssfpub.getPSSysSFPubId()) != 0L) {
                this.ppssyssfpub = null;
            }
            if (this.ppssyssfpub == null) {
                PSSysSFPub pSSysSFPub = new PSSysSFPub();
                pSSysSFPub.setPSSysSFPubId(this.getPPSSysSFPubId());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPubService.autoGet((IEntity)pSSysSFPub);
                this.ppssyssfpub = pSSysSFPub;
            }
            return this.ppssyssfpub;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysProject> getPSSysProjects() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProjects();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        PSSysProjectService pSSysProjectService = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysProjectsLock;
        synchronized (n) {
            if (this.pssysprojects == null) {
                this.pssysprojects = pSSysProjectService.selectByPSSysSFPub(this);
            }
            return this.pssysprojects;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSFCode> getPSSysSFCodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFCodes();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        PSSysSFCodeService pSSysSFCodeService = (PSSysSFCodeService)ServiceGlobal.getService(PSSysSFCodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSFCodesLock;
        synchronized (n) {
            if (this.pssyssfcodes == null) {
                this.pssyssfcodes = pSSysSFCodeService.selectByPSSysSFPub(this);
            }
            return this.pssyssfcodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSFPubRef> getPSSysSFPubRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubRefs();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        PSSysSFPubRefService pSSysSFPubRefService = (PSSysSFPubRefService)ServiceGlobal.getService(PSSysSFPubRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSFPubRefsLock;
        synchronized (n) {
            if (this.pssyssfpubrefs == null) {
                this.pssyssfpubrefs = pSSysSFPubRefService.selectByPSSysSFPub(this);
            }
            return this.pssyssfpubrefs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSFPub> getPSSysSFPubs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubs();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSFPubsLock;
        synchronized (n) {
            if (this.pssyssfpubs == null) {
                this.pssyssfpubs = pSSysSFPubService.selectByPPSSysSFPub(this);
            }
            return this.pssyssfpubs;
        }
    }

    private PSSysSFPubBase getProxyEntity() {
        return this.proxyPSSysSFPubBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSFPubBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSFPubBase) {
            this.proxyPSSysSFPubBase = (PSSysSFPubBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_BASECLSPKGCODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DEFAULTPUB, 6);
        fieldIndexMap.put(FIELD_DOCPSSFSTYLEID, 7);
        fieldIndexMap.put(FIELD_DOCPSSFSTYLENAME, 8);
        fieldIndexMap.put(FIELD_DYNAMODELMODE, 9);
        fieldIndexMap.put(FIELD_GLOBALTSFLAG, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PKGCODENAME, 12);
        fieldIndexMap.put(FIELD_PPSSYSSFPUBID, 13);
        fieldIndexMap.put(FIELD_PPSSYSSFPUBNAME, 14);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 15);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 16);
        fieldIndexMap.put(FIELD_PSSFSTYLEPARAMID, 17);
        fieldIndexMap.put(FIELD_PSSFSTYLEPARAMNAME, 18);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERID, 19);
        fieldIndexMap.put(FIELD_PSSFSTYLEVERNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 21);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSSFCODESCNT, 23);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 24);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSSFPUBPKGSCNT, 26);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 27);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 28);
        fieldIndexMap.put(FIELD_PUBFOLDER, 29);
        fieldIndexMap.put(FIELD_PUBTAG, 30);
        fieldIndexMap.put(FIELD_PUBTAG2, 31);
        fieldIndexMap.put(FIELD_PUBTAG3, 32);
        fieldIndexMap.put(FIELD_PUBTAG4, 33);
        fieldIndexMap.put(FIELD_REMOVEFLAG, 34);
        fieldIndexMap.put(FIELD_STYLEPARAMS, 35);
        fieldIndexMap.put(FIELD_SUBSYSPKGFLAG, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_USERCAT, 39);
        fieldIndexMap.put(FIELD_USERTAG, 40);
        fieldIndexMap.put(FIELD_USERTAG2, 41);
        fieldIndexMap.put(FIELD_USERTAG3, 42);
        fieldIndexMap.put(FIELD_USERTAG4, 43);
        fieldIndexMap.put(FIELD_VERSTR, 44);
    }
}

