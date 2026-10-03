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
package net.ibizsys.pscore.srv.helpdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticleCat;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleCatService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArticleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpArticleBase.class);
    public static final String FIELD_ARTICLEPARAM = "ARTICLEPARAM";
    public static final String FIELD_ARTICLEPARAM2 = "ARTICLEPARAM2";
    public static final String FIELD_ARTICLEPARAM3 = "ARTICLEPARAM3";
    public static final String FIELD_ARTICLEPARAM4 = "ARTICLEPARAM4";
    public static final String FIELD_ARTICLEPARAM5 = "ARTICLEPARAM5";
    public static final String FIELD_ARTICLEPARAM6 = "ARTICLEPARAM6";
    public static final String FIELD_ARTICLEPARAM7 = "ARTICLEPARAM7";
    public static final String FIELD_ARTICLEPARAM8 = "ARTICLEPARAM8";
    public static final String FIELD_ARTICLESN = "ARTICLESN";
    public static final String FIELD_ARTICLETYPE = "ARTICLETYPE";
    public static final String FIELD_ARTICLEVER = "ARTICLEVER";
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_KEYWORDS = "KEYWORDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSHELPARTICLECATID = "PSHELPARTICLECATID";
    public static final String FIELD_PSHELPARTICLECATNAME = "PSHELPARTICLECATNAME";
    public static final String FIELD_PSHELPARTICLEID = "PSHELPARTICLEID";
    public static final String FIELD_PSHELPARTICLENAME = "PSHELPARTICLENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String FIELD_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String FIELD_SUBCAPTION = "SUBCAPTION";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ARTICLEPARAM = 0;
    private static final int INDEX_ARTICLEPARAM2 = 1;
    private static final int INDEX_ARTICLEPARAM3 = 2;
    private static final int INDEX_ARTICLEPARAM4 = 3;
    private static final int INDEX_ARTICLEPARAM5 = 4;
    private static final int INDEX_ARTICLEPARAM6 = 5;
    private static final int INDEX_ARTICLEPARAM7 = 6;
    private static final int INDEX_ARTICLEPARAM8 = 7;
    private static final int INDEX_ARTICLESN = 8;
    private static final int INDEX_ARTICLETYPE = 9;
    private static final int INDEX_ARTICLEVER = 10;
    private static final int INDEX_BOTTOMCONTENT = 11;
    private static final int INDEX_CODENAME = 12;
    private static final int INDEX_CONTENT = 13;
    private static final int INDEX_CREATEDATE = 14;
    private static final int INDEX_CREATEMAN = 15;
    private static final int INDEX_HEADERCONTENT = 16;
    private static final int INDEX_KEYWORDS = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_PSDEID = 19;
    private static final int INDEX_PSDENAME = 20;
    private static final int INDEX_PSHELPARTICLECATID = 21;
    private static final int INDEX_PSHELPARTICLECATNAME = 22;
    private static final int INDEX_PSHELPARTICLEID = 23;
    private static final int INDEX_PSHELPARTICLENAME = 24;
    private static final int INDEX_PSMODULEID = 25;
    private static final int INDEX_PSMODULENAME = 26;
    private static final int INDEX_PSSYSTEMID = 27;
    private static final int INDEX_PSSYSTEMNAME = 28;
    private static final int INDEX_PSSYSUSERCASEID = 29;
    private static final int INDEX_PSSYSUSERCASENAME = 30;
    private static final int INDEX_SUBCAPTION = 31;
    private static final int INDEX_TITLE = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_USERCAT = 35;
    private static final int INDEX_USERTAG = 36;
    private static final int INDEX_USERTAG2 = 37;
    private static final int INDEX_USERTAG3 = 38;
    private static final int INDEX_USERTAG4 = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpArticleBase proxyPSHelpArticleBase = null;
    private boolean articleparamDirtyFlag = false;
    private boolean articleparam2DirtyFlag = false;
    private boolean articleparam3DirtyFlag = false;
    private boolean articleparam4DirtyFlag = false;
    private boolean articleparam5DirtyFlag = false;
    private boolean articleparam6DirtyFlag = false;
    private boolean articleparam7DirtyFlag = false;
    private boolean articleparam8DirtyFlag = false;
    private boolean articlesnDirtyFlag = false;
    private boolean articletypeDirtyFlag = false;
    private boolean articleverDirtyFlag = false;
    private boolean bottomcontentDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean keywordsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pshelparticlecatidDirtyFlag = false;
    private boolean pshelparticlecatnameDirtyFlag = false;
    private boolean pshelparticleidDirtyFlag = false;
    private boolean pshelparticlenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysusercaseidDirtyFlag = false;
    private boolean pssysusercasenameDirtyFlag = false;
    private boolean subcaptionDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="articleparam")
    private String articleparam;
    @Column(name="articleparam2")
    private String articleparam2;
    @Column(name="articleparam3")
    private String articleparam3;
    @Column(name="articleparam4")
    private String articleparam4;
    @Column(name="articleparam5")
    private Integer articleparam5;
    @Column(name="articleparam6")
    private Integer articleparam6;
    @Column(name="articleparam7")
    private Integer articleparam7;
    @Column(name="articleparam8")
    private Integer articleparam8;
    @Column(name="articlesn")
    private String articlesn;
    @Column(name="articletype")
    private String articletype;
    @Column(name="articlever")
    private String articlever;
    @Column(name="bottomcontent")
    private String bottomcontent;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="headercontent")
    private String headercontent;
    @Column(name="keywords")
    private String keywords;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pshelparticlecatid")
    private String pshelparticlecatid;
    @Column(name="pshelparticlecatname")
    private String pshelparticlecatname;
    @Column(name="pshelparticleid")
    private String pshelparticleid;
    @Column(name="pshelparticlename")
    private String pshelparticlename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysusercaseid")
    private String pssysusercaseid;
    @Column(name="pssysusercasename")
    private String pssysusercasename;
    @Column(name="subcaption")
    private String subcaption;
    @Column(name="title")
    private String title;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSHelpArticleCatLock = new Integer(1);
    private PSHelpArticleCat pshelparticlecat = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUserCaseLock = new Integer(1);
    private PSSysUserCase pssysusercase = null;
    private Integer objPSHelpSectionsLock = new Integer(1);
    private ArrayList<PSHelpSection> pshelpsections = null;

    public void setArticleParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articleparam = string;
        this.articleparamDirtyFlag = true;
    }

    public String getArticleParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam();
        }
        return this.articleparam;
    }

    public boolean isArticleParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParamDirty();
        }
        return this.articleparamDirtyFlag;
    }

    public void resetArticleParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam();
            return;
        }
        this.articleparamDirtyFlag = false;
        this.articleparam = null;
    }

    public void setArticleParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articleparam2 = string;
        this.articleparam2DirtyFlag = true;
    }

    public String getArticleParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam2();
        }
        return this.articleparam2;
    }

    public boolean isArticleParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParam2Dirty();
        }
        return this.articleparam2DirtyFlag;
    }

    public void resetArticleParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam2();
            return;
        }
        this.articleparam2DirtyFlag = false;
        this.articleparam2 = null;
    }

    public void setArticleParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articleparam3 = string;
        this.articleparam3DirtyFlag = true;
    }

    public String getArticleParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam3();
        }
        return this.articleparam3;
    }

    public boolean isArticleParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParam3Dirty();
        }
        return this.articleparam3DirtyFlag;
    }

    public void resetArticleParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam3();
            return;
        }
        this.articleparam3DirtyFlag = false;
        this.articleparam3 = null;
    }

    public void setArticleParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articleparam4 = string;
        this.articleparam4DirtyFlag = true;
    }

    public String getArticleParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam4();
        }
        return this.articleparam4;
    }

    public boolean isArticleParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParam4Dirty();
        }
        return this.articleparam4DirtyFlag;
    }

    public void resetArticleParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam4();
            return;
        }
        this.articleparam4DirtyFlag = false;
        this.articleparam4 = null;
    }

    public void setArticleParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam5(n);
            return;
        }
        this.articleparam5 = n;
        this.articleparam5DirtyFlag = true;
    }

    public Integer getArticleParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam5();
        }
        return this.articleparam5;
    }

    public boolean isArticleParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParam5Dirty();
        }
        return this.articleparam5DirtyFlag;
    }

    public void resetArticleParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam5();
            return;
        }
        this.articleparam5DirtyFlag = false;
        this.articleparam5 = null;
    }

    public void setArticleParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam6(n);
            return;
        }
        this.articleparam6 = n;
        this.articleparam6DirtyFlag = true;
    }

    public Integer getArticleParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam6();
        }
        return this.articleparam6;
    }

    public boolean isArticleParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParam6Dirty();
        }
        return this.articleparam6DirtyFlag;
    }

    public void resetArticleParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam6();
            return;
        }
        this.articleparam6DirtyFlag = false;
        this.articleparam6 = null;
    }

    public void setArticleParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam7(n);
            return;
        }
        this.articleparam7 = n;
        this.articleparam7DirtyFlag = true;
    }

    public Integer getArticleParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam7();
        }
        return this.articleparam7;
    }

    public boolean isArticleParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParam7Dirty();
        }
        return this.articleparam7DirtyFlag;
    }

    public void resetArticleParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam7();
            return;
        }
        this.articleparam7DirtyFlag = false;
        this.articleparam7 = null;
    }

    public void setArticleParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleParam8(n);
            return;
        }
        this.articleparam8 = n;
        this.articleparam8DirtyFlag = true;
    }

    public Integer getArticleParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleParam8();
        }
        return this.articleparam8;
    }

    public boolean isArticleParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleParam8Dirty();
        }
        return this.articleparam8DirtyFlag;
    }

    public void resetArticleParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleParam8();
            return;
        }
        this.articleparam8DirtyFlag = false;
        this.articleparam8 = null;
    }

    public void setArticleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articlesn = string;
        this.articlesnDirtyFlag = true;
    }

    public String getArticleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleSN();
        }
        return this.articlesn;
    }

    public boolean isArticleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleSNDirty();
        }
        return this.articlesnDirtyFlag;
    }

    public void resetArticleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleSN();
            return;
        }
        this.articlesnDirtyFlag = false;
        this.articlesn = null;
    }

    public void setArticleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articletype = string;
        this.articletypeDirtyFlag = true;
    }

    public String getArticleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleType();
        }
        return this.articletype;
    }

    public boolean isArticleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleTypeDirty();
        }
        return this.articletypeDirtyFlag;
    }

    public void resetArticleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleType();
            return;
        }
        this.articletypeDirtyFlag = false;
        this.articletype = null;
    }

    public void setArticleVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articlever = string;
        this.articleverDirtyFlag = true;
    }

    public String getArticleVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleVer();
        }
        return this.articlever;
    }

    public boolean isArticleVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleVerDirty();
        }
        return this.articleverDirtyFlag;
    }

    public void resetArticleVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleVer();
            return;
        }
        this.articleverDirtyFlag = false;
        this.articlever = null;
    }

    public void setBottomContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottomcontent = string;
        this.bottomcontentDirtyFlag = true;
    }

    public String getBottomContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomContent();
        }
        return this.bottomcontent;
    }

    public boolean isBottomContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomContentDirty();
        }
        return this.bottomcontentDirtyFlag;
    }

    public void resetBottomContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomContent();
            return;
        }
        this.bottomcontentDirtyFlag = false;
        this.bottomcontent = null;
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

    public void setHeaderContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headercontent = string;
        this.headercontentDirtyFlag = true;
    }

    public String getHeaderContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderContent();
        }
        return this.headercontent;
    }

    public boolean isHeaderContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderContentDirty();
        }
        return this.headercontentDirtyFlag;
    }

    public void resetHeaderContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderContent();
            return;
        }
        this.headercontentDirtyFlag = false;
        this.headercontent = null;
    }

    public void setKeywords(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeywords(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keywords = string;
        this.keywordsDirtyFlag = true;
    }

    public String getKeywords() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeywords();
        }
        return this.keywords;
    }

    public boolean isKeywordsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeywordsDirty();
        }
        return this.keywordsDirtyFlag;
    }

    public void resetKeywords() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeywords();
            return;
        }
        this.keywordsDirtyFlag = false;
        this.keywords = null;
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

    public void setPSHelpArticleCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticlecatid = string;
        this.pshelparticlecatidDirtyFlag = true;
    }

    public String getPSHelpArticleCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleCatId();
        }
        return this.pshelparticlecatid;
    }

    public boolean isPSHelpArticleCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleCatIdDirty();
        }
        return this.pshelparticlecatidDirtyFlag;
    }

    public void resetPSHelpArticleCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleCatId();
            return;
        }
        this.pshelparticlecatidDirtyFlag = false;
        this.pshelparticlecatid = null;
    }

    public void setPSHelpArticleCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticlecatname = string;
        this.pshelparticlecatnameDirtyFlag = true;
    }

    public String getPSHelpArticleCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleCatName();
        }
        return this.pshelparticlecatname;
    }

    public boolean isPSHelpArticleCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleCatNameDirty();
        }
        return this.pshelparticlecatnameDirtyFlag;
    }

    public void resetPSHelpArticleCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleCatName();
            return;
        }
        this.pshelparticlecatnameDirtyFlag = false;
        this.pshelparticlecatname = null;
    }

    public void setPSHelpArticleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticleid = string;
        this.pshelparticleidDirtyFlag = true;
    }

    public String getPSHelpArticleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleId();
        }
        return this.pshelparticleid;
    }

    public boolean isPSHelpArticleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleIdDirty();
        }
        return this.pshelparticleidDirtyFlag;
    }

    public void resetPSHelpArticleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleId();
            return;
        }
        this.pshelparticleidDirtyFlag = false;
        this.pshelparticleid = null;
    }

    public void setPSHelpArticleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticlename = string;
        this.pshelparticlenameDirtyFlag = true;
    }

    public String getPSHelpArticleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleName();
        }
        return this.pshelparticlename;
    }

    public boolean isPSHelpArticleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleNameDirty();
        }
        return this.pshelparticlenameDirtyFlag;
    }

    public void resetPSHelpArticleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleName();
            return;
        }
        this.pshelparticlenameDirtyFlag = false;
        this.pshelparticlename = null;
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

    public void setPSSysUserCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercaseid = string;
        this.pssysusercaseidDirtyFlag = true;
    }

    public String getPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseId();
        }
        return this.pssysusercaseid;
    }

    public boolean isPSSysUserCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseIdDirty();
        }
        return this.pssysusercaseidDirtyFlag;
    }

    public void resetPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseId();
            return;
        }
        this.pssysusercaseidDirtyFlag = false;
        this.pssysusercaseid = null;
    }

    public void setPSSysUserCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercasename = string;
        this.pssysusercasenameDirtyFlag = true;
    }

    public String getPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseName();
        }
        return this.pssysusercasename;
    }

    public boolean isPSSysUserCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseNameDirty();
        }
        return this.pssysusercasenameDirtyFlag;
    }

    public void resetPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseName();
            return;
        }
        this.pssysusercasenameDirtyFlag = false;
        this.pssysusercasename = null;
    }

    public void setSubCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subcaption = string;
        this.subcaptionDirtyFlag = true;
    }

    public String getSubCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCaption();
        }
        return this.subcaption;
    }

    public boolean isSubCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubCaptionDirty();
        }
        return this.subcaptionDirtyFlag;
    }

    public void resetSubCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubCaption();
            return;
        }
        this.subcaptionDirtyFlag = false;
        this.subcaption = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
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

    protected void onReset() {
        PSHelpArticleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpArticleBase pSHelpArticleBase) {
        pSHelpArticleBase.resetArticleParam();
        pSHelpArticleBase.resetArticleParam2();
        pSHelpArticleBase.resetArticleParam3();
        pSHelpArticleBase.resetArticleParam4();
        pSHelpArticleBase.resetArticleParam5();
        pSHelpArticleBase.resetArticleParam6();
        pSHelpArticleBase.resetArticleParam7();
        pSHelpArticleBase.resetArticleParam8();
        pSHelpArticleBase.resetArticleSN();
        pSHelpArticleBase.resetArticleType();
        pSHelpArticleBase.resetArticleVer();
        pSHelpArticleBase.resetBottomContent();
        pSHelpArticleBase.resetCodeName();
        pSHelpArticleBase.resetContent();
        pSHelpArticleBase.resetCreateDate();
        pSHelpArticleBase.resetCreateMan();
        pSHelpArticleBase.resetHeaderContent();
        pSHelpArticleBase.resetKeywords();
        pSHelpArticleBase.resetMemo();
        pSHelpArticleBase.resetPSDEId();
        pSHelpArticleBase.resetPSDEName();
        pSHelpArticleBase.resetPSHelpArticleCatId();
        pSHelpArticleBase.resetPSHelpArticleCatName();
        pSHelpArticleBase.resetPSHelpArticleId();
        pSHelpArticleBase.resetPSHelpArticleName();
        pSHelpArticleBase.resetPSModuleId();
        pSHelpArticleBase.resetPSModuleName();
        pSHelpArticleBase.resetPSSystemId();
        pSHelpArticleBase.resetPSSystemName();
        pSHelpArticleBase.resetPSSysUserCaseId();
        pSHelpArticleBase.resetPSSysUserCaseName();
        pSHelpArticleBase.resetSubCaption();
        pSHelpArticleBase.resetTitle();
        pSHelpArticleBase.resetUpdateDate();
        pSHelpArticleBase.resetUpdateMan();
        pSHelpArticleBase.resetUserCat();
        pSHelpArticleBase.resetUserTag();
        pSHelpArticleBase.resetUserTag2();
        pSHelpArticleBase.resetUserTag3();
        pSHelpArticleBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArticleParamDirty()) {
            hashMap.put(FIELD_ARTICLEPARAM, this.getArticleParam());
        }
        if (!bl || this.isArticleParam2Dirty()) {
            hashMap.put(FIELD_ARTICLEPARAM2, this.getArticleParam2());
        }
        if (!bl || this.isArticleParam3Dirty()) {
            hashMap.put(FIELD_ARTICLEPARAM3, this.getArticleParam3());
        }
        if (!bl || this.isArticleParam4Dirty()) {
            hashMap.put(FIELD_ARTICLEPARAM4, this.getArticleParam4());
        }
        if (!bl || this.isArticleParam5Dirty()) {
            hashMap.put(FIELD_ARTICLEPARAM5, this.getArticleParam5());
        }
        if (!bl || this.isArticleParam6Dirty()) {
            hashMap.put(FIELD_ARTICLEPARAM6, this.getArticleParam6());
        }
        if (!bl || this.isArticleParam7Dirty()) {
            hashMap.put(FIELD_ARTICLEPARAM7, this.getArticleParam7());
        }
        if (!bl || this.isArticleParam8Dirty()) {
            hashMap.put(FIELD_ARTICLEPARAM8, this.getArticleParam8());
        }
        if (!bl || this.isArticleSNDirty()) {
            hashMap.put(FIELD_ARTICLESN, this.getArticleSN());
        }
        if (!bl || this.isArticleTypeDirty()) {
            hashMap.put(FIELD_ARTICLETYPE, this.getArticleType());
        }
        if (!bl || this.isArticleVerDirty()) {
            hashMap.put(FIELD_ARTICLEVER, this.getArticleVer());
        }
        if (!bl || this.isBottomContentDirty()) {
            hashMap.put(FIELD_BOTTOMCONTENT, this.getBottomContent());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isHeaderContentDirty()) {
            hashMap.put(FIELD_HEADERCONTENT, this.getHeaderContent());
        }
        if (!bl || this.isKeywordsDirty()) {
            hashMap.put(FIELD_KEYWORDS, this.getKeywords());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSHelpArticleCatIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLECATID, this.getPSHelpArticleCatId());
        }
        if (!bl || this.isPSHelpArticleCatNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLECATNAME, this.getPSHelpArticleCatName());
        }
        if (!bl || this.isPSHelpArticleIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLEID, this.getPSHelpArticleId());
        }
        if (!bl || this.isPSHelpArticleNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLENAME, this.getPSHelpArticleName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASEID, this.getPSSysUserCaseId());
        }
        if (!bl || this.isPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASENAME, this.getPSSysUserCaseName());
        }
        if (!bl || this.isSubCaptionDirty()) {
            hashMap.put(FIELD_SUBCAPTION, this.getSubCaption());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
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
        return PSHelpArticleBase.get(this, n);
    }

    private static Object get(PSHelpArticleBase pSHelpArticleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleBase.getArticleParam();
            }
            case 1: {
                return pSHelpArticleBase.getArticleParam2();
            }
            case 2: {
                return pSHelpArticleBase.getArticleParam3();
            }
            case 3: {
                return pSHelpArticleBase.getArticleParam4();
            }
            case 4: {
                return pSHelpArticleBase.getArticleParam5();
            }
            case 5: {
                return pSHelpArticleBase.getArticleParam6();
            }
            case 6: {
                return pSHelpArticleBase.getArticleParam7();
            }
            case 7: {
                return pSHelpArticleBase.getArticleParam8();
            }
            case 8: {
                return pSHelpArticleBase.getArticleSN();
            }
            case 9: {
                return pSHelpArticleBase.getArticleType();
            }
            case 10: {
                return pSHelpArticleBase.getArticleVer();
            }
            case 11: {
                return pSHelpArticleBase.getBottomContent();
            }
            case 12: {
                return pSHelpArticleBase.getCodeName();
            }
            case 13: {
                return pSHelpArticleBase.getContent();
            }
            case 14: {
                return pSHelpArticleBase.getCreateDate();
            }
            case 15: {
                return pSHelpArticleBase.getCreateMan();
            }
            case 16: {
                return pSHelpArticleBase.getHeaderContent();
            }
            case 17: {
                return pSHelpArticleBase.getKeywords();
            }
            case 18: {
                return pSHelpArticleBase.getMemo();
            }
            case 19: {
                return pSHelpArticleBase.getPSDEId();
            }
            case 20: {
                return pSHelpArticleBase.getPSDEName();
            }
            case 21: {
                return pSHelpArticleBase.getPSHelpArticleCatId();
            }
            case 22: {
                return pSHelpArticleBase.getPSHelpArticleCatName();
            }
            case 23: {
                return pSHelpArticleBase.getPSHelpArticleId();
            }
            case 24: {
                return pSHelpArticleBase.getPSHelpArticleName();
            }
            case 25: {
                return pSHelpArticleBase.getPSModuleId();
            }
            case 26: {
                return pSHelpArticleBase.getPSModuleName();
            }
            case 27: {
                return pSHelpArticleBase.getPSSystemId();
            }
            case 28: {
                return pSHelpArticleBase.getPSSystemName();
            }
            case 29: {
                return pSHelpArticleBase.getPSSysUserCaseId();
            }
            case 30: {
                return pSHelpArticleBase.getPSSysUserCaseName();
            }
            case 31: {
                return pSHelpArticleBase.getSubCaption();
            }
            case 32: {
                return pSHelpArticleBase.getTitle();
            }
            case 33: {
                return pSHelpArticleBase.getUpdateDate();
            }
            case 34: {
                return pSHelpArticleBase.getUpdateMan();
            }
            case 35: {
                return pSHelpArticleBase.getUserCat();
            }
            case 36: {
                return pSHelpArticleBase.getUserTag();
            }
            case 37: {
                return pSHelpArticleBase.getUserTag2();
            }
            case 38: {
                return pSHelpArticleBase.getUserTag3();
            }
            case 39: {
                return pSHelpArticleBase.getUserTag4();
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
        PSHelpArticleBase.set(this, n, object);
    }

    private static void set(PSHelpArticleBase pSHelpArticleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleBase.setArticleParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSHelpArticleBase.setArticleParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpArticleBase.setArticleParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSHelpArticleBase.setArticleParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpArticleBase.setArticleParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSHelpArticleBase.setArticleParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSHelpArticleBase.setArticleParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSHelpArticleBase.setArticleParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSHelpArticleBase.setArticleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpArticleBase.setArticleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpArticleBase.setArticleVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSHelpArticleBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpArticleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSHelpArticleBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSHelpArticleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSHelpArticleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSHelpArticleBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSHelpArticleBase.setKeywords(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSHelpArticleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSHelpArticleBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSHelpArticleBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSHelpArticleBase.setPSHelpArticleCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSHelpArticleBase.setPSHelpArticleCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSHelpArticleBase.setPSHelpArticleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSHelpArticleBase.setPSHelpArticleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSHelpArticleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSHelpArticleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSHelpArticleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSHelpArticleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSHelpArticleBase.setPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSHelpArticleBase.setPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSHelpArticleBase.setSubCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSHelpArticleBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSHelpArticleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSHelpArticleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSHelpArticleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSHelpArticleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSHelpArticleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSHelpArticleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSHelpArticleBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSHelpArticleBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpArticleBase pSHelpArticleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleBase.getArticleParam() == null;
            }
            case 1: {
                return pSHelpArticleBase.getArticleParam2() == null;
            }
            case 2: {
                return pSHelpArticleBase.getArticleParam3() == null;
            }
            case 3: {
                return pSHelpArticleBase.getArticleParam4() == null;
            }
            case 4: {
                return pSHelpArticleBase.getArticleParam5() == null;
            }
            case 5: {
                return pSHelpArticleBase.getArticleParam6() == null;
            }
            case 6: {
                return pSHelpArticleBase.getArticleParam7() == null;
            }
            case 7: {
                return pSHelpArticleBase.getArticleParam8() == null;
            }
            case 8: {
                return pSHelpArticleBase.getArticleSN() == null;
            }
            case 9: {
                return pSHelpArticleBase.getArticleType() == null;
            }
            case 10: {
                return pSHelpArticleBase.getArticleVer() == null;
            }
            case 11: {
                return pSHelpArticleBase.getBottomContent() == null;
            }
            case 12: {
                return pSHelpArticleBase.getCodeName() == null;
            }
            case 13: {
                return pSHelpArticleBase.getContent() == null;
            }
            case 14: {
                return pSHelpArticleBase.getCreateDate() == null;
            }
            case 15: {
                return pSHelpArticleBase.getCreateMan() == null;
            }
            case 16: {
                return pSHelpArticleBase.getHeaderContent() == null;
            }
            case 17: {
                return pSHelpArticleBase.getKeywords() == null;
            }
            case 18: {
                return pSHelpArticleBase.getMemo() == null;
            }
            case 19: {
                return pSHelpArticleBase.getPSDEId() == null;
            }
            case 20: {
                return pSHelpArticleBase.getPSDEName() == null;
            }
            case 21: {
                return pSHelpArticleBase.getPSHelpArticleCatId() == null;
            }
            case 22: {
                return pSHelpArticleBase.getPSHelpArticleCatName() == null;
            }
            case 23: {
                return pSHelpArticleBase.getPSHelpArticleId() == null;
            }
            case 24: {
                return pSHelpArticleBase.getPSHelpArticleName() == null;
            }
            case 25: {
                return pSHelpArticleBase.getPSModuleId() == null;
            }
            case 26: {
                return pSHelpArticleBase.getPSModuleName() == null;
            }
            case 27: {
                return pSHelpArticleBase.getPSSystemId() == null;
            }
            case 28: {
                return pSHelpArticleBase.getPSSystemName() == null;
            }
            case 29: {
                return pSHelpArticleBase.getPSSysUserCaseId() == null;
            }
            case 30: {
                return pSHelpArticleBase.getPSSysUserCaseName() == null;
            }
            case 31: {
                return pSHelpArticleBase.getSubCaption() == null;
            }
            case 32: {
                return pSHelpArticleBase.getTitle() == null;
            }
            case 33: {
                return pSHelpArticleBase.getUpdateDate() == null;
            }
            case 34: {
                return pSHelpArticleBase.getUpdateMan() == null;
            }
            case 35: {
                return pSHelpArticleBase.getUserCat() == null;
            }
            case 36: {
                return pSHelpArticleBase.getUserTag() == null;
            }
            case 37: {
                return pSHelpArticleBase.getUserTag2() == null;
            }
            case 38: {
                return pSHelpArticleBase.getUserTag3() == null;
            }
            case 39: {
                return pSHelpArticleBase.getUserTag4() == null;
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
        return PSHelpArticleBase.contains(this, n);
    }

    private static boolean contains(PSHelpArticleBase pSHelpArticleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpArticleBase.isArticleParamDirty();
            }
            case 1: {
                return pSHelpArticleBase.isArticleParam2Dirty();
            }
            case 2: {
                return pSHelpArticleBase.isArticleParam3Dirty();
            }
            case 3: {
                return pSHelpArticleBase.isArticleParam4Dirty();
            }
            case 4: {
                return pSHelpArticleBase.isArticleParam5Dirty();
            }
            case 5: {
                return pSHelpArticleBase.isArticleParam6Dirty();
            }
            case 6: {
                return pSHelpArticleBase.isArticleParam7Dirty();
            }
            case 7: {
                return pSHelpArticleBase.isArticleParam8Dirty();
            }
            case 8: {
                return pSHelpArticleBase.isArticleSNDirty();
            }
            case 9: {
                return pSHelpArticleBase.isArticleTypeDirty();
            }
            case 10: {
                return pSHelpArticleBase.isArticleVerDirty();
            }
            case 11: {
                return pSHelpArticleBase.isBottomContentDirty();
            }
            case 12: {
                return pSHelpArticleBase.isCodeNameDirty();
            }
            case 13: {
                return pSHelpArticleBase.isContentDirty();
            }
            case 14: {
                return pSHelpArticleBase.isCreateDateDirty();
            }
            case 15: {
                return pSHelpArticleBase.isCreateManDirty();
            }
            case 16: {
                return pSHelpArticleBase.isHeaderContentDirty();
            }
            case 17: {
                return pSHelpArticleBase.isKeywordsDirty();
            }
            case 18: {
                return pSHelpArticleBase.isMemoDirty();
            }
            case 19: {
                return pSHelpArticleBase.isPSDEIdDirty();
            }
            case 20: {
                return pSHelpArticleBase.isPSDENameDirty();
            }
            case 21: {
                return pSHelpArticleBase.isPSHelpArticleCatIdDirty();
            }
            case 22: {
                return pSHelpArticleBase.isPSHelpArticleCatNameDirty();
            }
            case 23: {
                return pSHelpArticleBase.isPSHelpArticleIdDirty();
            }
            case 24: {
                return pSHelpArticleBase.isPSHelpArticleNameDirty();
            }
            case 25: {
                return pSHelpArticleBase.isPSModuleIdDirty();
            }
            case 26: {
                return pSHelpArticleBase.isPSModuleNameDirty();
            }
            case 27: {
                return pSHelpArticleBase.isPSSystemIdDirty();
            }
            case 28: {
                return pSHelpArticleBase.isPSSystemNameDirty();
            }
            case 29: {
                return pSHelpArticleBase.isPSSysUserCaseIdDirty();
            }
            case 30: {
                return pSHelpArticleBase.isPSSysUserCaseNameDirty();
            }
            case 31: {
                return pSHelpArticleBase.isSubCaptionDirty();
            }
            case 32: {
                return pSHelpArticleBase.isTitleDirty();
            }
            case 33: {
                return pSHelpArticleBase.isUpdateDateDirty();
            }
            case 34: {
                return pSHelpArticleBase.isUpdateManDirty();
            }
            case 35: {
                return pSHelpArticleBase.isUserCatDirty();
            }
            case 36: {
                return pSHelpArticleBase.isUserTagDirty();
            }
            case 37: {
                return pSHelpArticleBase.isUserTag2Dirty();
            }
            case 38: {
                return pSHelpArticleBase.isUserTag3Dirty();
            }
            case 39: {
                return pSHelpArticleBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpArticleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpArticleBase pSHelpArticleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpArticleBase.getArticleParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam2", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam2()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam3", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam3()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam4", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam4()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam5", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam5()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam6", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam6()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam7", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam7()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleparam8", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleParam8()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articlesn", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleSN()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articletype", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleType()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getArticleVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articlever", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getArticleVer()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getContent()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getKeywords() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keywords", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getKeywords()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticlecatid", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSHelpArticleCatId()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticlecatname", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSHelpArticleCatName()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticleid", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSHelpArticleId()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticlename", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSHelpArticleName()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercaseid", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasename", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getSubCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcaption", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getSubCaption()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getTitle()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSHelpArticleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSHelpArticleBase.getJSONValue((Object)pSHelpArticleBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpArticleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpArticleBase pSHelpArticleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpArticleBase.getArticleParam() != null) {
            object = pSHelpArticleBase.getArticleParam();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpArticleBase.getArticleParam2() != null) {
            object = pSHelpArticleBase.getArticleParam2();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpArticleBase.getArticleParam3() != null) {
            object = pSHelpArticleBase.getArticleParam3();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM3, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpArticleBase.getArticleParam4() != null) {
            object = pSHelpArticleBase.getArticleParam4();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getArticleParam5() != null) {
            object = pSHelpArticleBase.getArticleParam5();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpArticleBase.getArticleParam6() != null) {
            object = pSHelpArticleBase.getArticleParam6();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpArticleBase.getArticleParam7() != null) {
            object = pSHelpArticleBase.getArticleParam7();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpArticleBase.getArticleParam8() != null) {
            object = pSHelpArticleBase.getArticleParam8();
            xmlNode.setAttribute(FIELD_ARTICLEPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpArticleBase.getArticleSN() != null) {
            object = pSHelpArticleBase.getArticleSN();
            xmlNode.setAttribute(FIELD_ARTICLESN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getArticleType() != null) {
            object = pSHelpArticleBase.getArticleType();
            xmlNode.setAttribute(FIELD_ARTICLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getArticleVer() != null) {
            object = pSHelpArticleBase.getArticleVer();
            xmlNode.setAttribute(FIELD_ARTICLEVER, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getBottomContent() != null) {
            object = pSHelpArticleBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getCodeName() != null) {
            object = pSHelpArticleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getContent() != null) {
            object = pSHelpArticleBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getCreateDate() != null) {
            object = pSHelpArticleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleBase.getCreateMan() != null) {
            object = pSHelpArticleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getHeaderContent() != null) {
            object = pSHelpArticleBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getKeywords() != null) {
            object = pSHelpArticleBase.getKeywords();
            xmlNode.setAttribute(FIELD_KEYWORDS, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getMemo() != null) {
            object = pSHelpArticleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSDEId() != null) {
            object = pSHelpArticleBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSDEName() != null) {
            object = pSHelpArticleBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleCatId() != null) {
            object = pSHelpArticleBase.getPSHelpArticleCatId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLECATID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleCatName() != null) {
            object = pSHelpArticleBase.getPSHelpArticleCatName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleId() != null) {
            object = pSHelpArticleBase.getPSHelpArticleId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSHelpArticleName() != null) {
            object = pSHelpArticleBase.getPSHelpArticleName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSModuleId() != null) {
            object = pSHelpArticleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSModuleName() != null) {
            object = pSHelpArticleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSSystemId() != null) {
            object = pSHelpArticleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSSystemName() != null) {
            object = pSHelpArticleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSSysUserCaseId() != null) {
            object = pSHelpArticleBase.getPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getPSSysUserCaseName() != null) {
            object = pSHelpArticleBase.getPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getSubCaption() != null) {
            object = pSHelpArticleBase.getSubCaption();
            xmlNode.setAttribute(FIELD_SUBCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getTitle() != null) {
            object = pSHelpArticleBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getUpdateDate() != null) {
            object = pSHelpArticleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpArticleBase.getUpdateMan() != null) {
            object = pSHelpArticleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getUserCat() != null) {
            object = pSHelpArticleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getUserTag() != null) {
            object = pSHelpArticleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getUserTag2() != null) {
            object = pSHelpArticleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getUserTag3() != null) {
            object = pSHelpArticleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSHelpArticleBase.getUserTag4() != null) {
            object = pSHelpArticleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpArticleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpArticleBase pSHelpArticleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpArticleBase.isArticleParamDirty() && (bl || pSHelpArticleBase.getArticleParam() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM, (Object)pSHelpArticleBase.getArticleParam());
        }
        if (pSHelpArticleBase.isArticleParam2Dirty() && (bl || pSHelpArticleBase.getArticleParam2() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM2, (Object)pSHelpArticleBase.getArticleParam2());
        }
        if (pSHelpArticleBase.isArticleParam3Dirty() && (bl || pSHelpArticleBase.getArticleParam3() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM3, (Object)pSHelpArticleBase.getArticleParam3());
        }
        if (pSHelpArticleBase.isArticleParam4Dirty() && (bl || pSHelpArticleBase.getArticleParam4() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM4, (Object)pSHelpArticleBase.getArticleParam4());
        }
        if (pSHelpArticleBase.isArticleParam5Dirty() && (bl || pSHelpArticleBase.getArticleParam5() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM5, (Object)pSHelpArticleBase.getArticleParam5());
        }
        if (pSHelpArticleBase.isArticleParam6Dirty() && (bl || pSHelpArticleBase.getArticleParam6() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM6, (Object)pSHelpArticleBase.getArticleParam6());
        }
        if (pSHelpArticleBase.isArticleParam7Dirty() && (bl || pSHelpArticleBase.getArticleParam7() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM7, (Object)pSHelpArticleBase.getArticleParam7());
        }
        if (pSHelpArticleBase.isArticleParam8Dirty() && (bl || pSHelpArticleBase.getArticleParam8() != null)) {
            iDataObject.set(FIELD_ARTICLEPARAM8, (Object)pSHelpArticleBase.getArticleParam8());
        }
        if (pSHelpArticleBase.isArticleSNDirty() && (bl || pSHelpArticleBase.getArticleSN() != null)) {
            iDataObject.set(FIELD_ARTICLESN, (Object)pSHelpArticleBase.getArticleSN());
        }
        if (pSHelpArticleBase.isArticleTypeDirty() && (bl || pSHelpArticleBase.getArticleType() != null)) {
            iDataObject.set(FIELD_ARTICLETYPE, (Object)pSHelpArticleBase.getArticleType());
        }
        if (pSHelpArticleBase.isArticleVerDirty() && (bl || pSHelpArticleBase.getArticleVer() != null)) {
            iDataObject.set(FIELD_ARTICLEVER, (Object)pSHelpArticleBase.getArticleVer());
        }
        if (pSHelpArticleBase.isBottomContentDirty() && (bl || pSHelpArticleBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSHelpArticleBase.getBottomContent());
        }
        if (pSHelpArticleBase.isCodeNameDirty() && (bl || pSHelpArticleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSHelpArticleBase.getCodeName());
        }
        if (pSHelpArticleBase.isContentDirty() && (bl || pSHelpArticleBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSHelpArticleBase.getContent());
        }
        if (pSHelpArticleBase.isCreateDateDirty() && (bl || pSHelpArticleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpArticleBase.getCreateDate());
        }
        if (pSHelpArticleBase.isCreateManDirty() && (bl || pSHelpArticleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpArticleBase.getCreateMan());
        }
        if (pSHelpArticleBase.isHeaderContentDirty() && (bl || pSHelpArticleBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSHelpArticleBase.getHeaderContent());
        }
        if (pSHelpArticleBase.isKeywordsDirty() && (bl || pSHelpArticleBase.getKeywords() != null)) {
            iDataObject.set(FIELD_KEYWORDS, (Object)pSHelpArticleBase.getKeywords());
        }
        if (pSHelpArticleBase.isMemoDirty() && (bl || pSHelpArticleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpArticleBase.getMemo());
        }
        if (pSHelpArticleBase.isPSDEIdDirty() && (bl || pSHelpArticleBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSHelpArticleBase.getPSDEId());
        }
        if (pSHelpArticleBase.isPSDENameDirty() && (bl || pSHelpArticleBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSHelpArticleBase.getPSDEName());
        }
        if (pSHelpArticleBase.isPSHelpArticleCatIdDirty() && (bl || pSHelpArticleBase.getPSHelpArticleCatId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLECATID, (Object)pSHelpArticleBase.getPSHelpArticleCatId());
        }
        if (pSHelpArticleBase.isPSHelpArticleCatNameDirty() && (bl || pSHelpArticleBase.getPSHelpArticleCatName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLECATNAME, (Object)pSHelpArticleBase.getPSHelpArticleCatName());
        }
        if (pSHelpArticleBase.isPSHelpArticleIdDirty() && (bl || pSHelpArticleBase.getPSHelpArticleId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLEID, (Object)pSHelpArticleBase.getPSHelpArticleId());
        }
        if (pSHelpArticleBase.isPSHelpArticleNameDirty() && (bl || pSHelpArticleBase.getPSHelpArticleName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLENAME, (Object)pSHelpArticleBase.getPSHelpArticleName());
        }
        if (pSHelpArticleBase.isPSModuleIdDirty() && (bl || pSHelpArticleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSHelpArticleBase.getPSModuleId());
        }
        if (pSHelpArticleBase.isPSModuleNameDirty() && (bl || pSHelpArticleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSHelpArticleBase.getPSModuleName());
        }
        if (pSHelpArticleBase.isPSSystemIdDirty() && (bl || pSHelpArticleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSHelpArticleBase.getPSSystemId());
        }
        if (pSHelpArticleBase.isPSSystemNameDirty() && (bl || pSHelpArticleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSHelpArticleBase.getPSSystemName());
        }
        if (pSHelpArticleBase.isPSSysUserCaseIdDirty() && (bl || pSHelpArticleBase.getPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASEID, (Object)pSHelpArticleBase.getPSSysUserCaseId());
        }
        if (pSHelpArticleBase.isPSSysUserCaseNameDirty() && (bl || pSHelpArticleBase.getPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASENAME, (Object)pSHelpArticleBase.getPSSysUserCaseName());
        }
        if (pSHelpArticleBase.isSubCaptionDirty() && (bl || pSHelpArticleBase.getSubCaption() != null)) {
            iDataObject.set(FIELD_SUBCAPTION, (Object)pSHelpArticleBase.getSubCaption());
        }
        if (pSHelpArticleBase.isTitleDirty() && (bl || pSHelpArticleBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSHelpArticleBase.getTitle());
        }
        if (pSHelpArticleBase.isUpdateDateDirty() && (bl || pSHelpArticleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpArticleBase.getUpdateDate());
        }
        if (pSHelpArticleBase.isUpdateManDirty() && (bl || pSHelpArticleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpArticleBase.getUpdateMan());
        }
        if (pSHelpArticleBase.isUserCatDirty() && (bl || pSHelpArticleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSHelpArticleBase.getUserCat());
        }
        if (pSHelpArticleBase.isUserTagDirty() && (bl || pSHelpArticleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSHelpArticleBase.getUserTag());
        }
        if (pSHelpArticleBase.isUserTag2Dirty() && (bl || pSHelpArticleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSHelpArticleBase.getUserTag2());
        }
        if (pSHelpArticleBase.isUserTag3Dirty() && (bl || pSHelpArticleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSHelpArticleBase.getUserTag3());
        }
        if (pSHelpArticleBase.isUserTag4Dirty() && (bl || pSHelpArticleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSHelpArticleBase.getUserTag4());
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
        return PSHelpArticleBase.remove(this, n);
    }

    private static boolean remove(PSHelpArticleBase pSHelpArticleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpArticleBase.resetArticleParam();
                return true;
            }
            case 1: {
                pSHelpArticleBase.resetArticleParam2();
                return true;
            }
            case 2: {
                pSHelpArticleBase.resetArticleParam3();
                return true;
            }
            case 3: {
                pSHelpArticleBase.resetArticleParam4();
                return true;
            }
            case 4: {
                pSHelpArticleBase.resetArticleParam5();
                return true;
            }
            case 5: {
                pSHelpArticleBase.resetArticleParam6();
                return true;
            }
            case 6: {
                pSHelpArticleBase.resetArticleParam7();
                return true;
            }
            case 7: {
                pSHelpArticleBase.resetArticleParam8();
                return true;
            }
            case 8: {
                pSHelpArticleBase.resetArticleSN();
                return true;
            }
            case 9: {
                pSHelpArticleBase.resetArticleType();
                return true;
            }
            case 10: {
                pSHelpArticleBase.resetArticleVer();
                return true;
            }
            case 11: {
                pSHelpArticleBase.resetBottomContent();
                return true;
            }
            case 12: {
                pSHelpArticleBase.resetCodeName();
                return true;
            }
            case 13: {
                pSHelpArticleBase.resetContent();
                return true;
            }
            case 14: {
                pSHelpArticleBase.resetCreateDate();
                return true;
            }
            case 15: {
                pSHelpArticleBase.resetCreateMan();
                return true;
            }
            case 16: {
                pSHelpArticleBase.resetHeaderContent();
                return true;
            }
            case 17: {
                pSHelpArticleBase.resetKeywords();
                return true;
            }
            case 18: {
                pSHelpArticleBase.resetMemo();
                return true;
            }
            case 19: {
                pSHelpArticleBase.resetPSDEId();
                return true;
            }
            case 20: {
                pSHelpArticleBase.resetPSDEName();
                return true;
            }
            case 21: {
                pSHelpArticleBase.resetPSHelpArticleCatId();
                return true;
            }
            case 22: {
                pSHelpArticleBase.resetPSHelpArticleCatName();
                return true;
            }
            case 23: {
                pSHelpArticleBase.resetPSHelpArticleId();
                return true;
            }
            case 24: {
                pSHelpArticleBase.resetPSHelpArticleName();
                return true;
            }
            case 25: {
                pSHelpArticleBase.resetPSModuleId();
                return true;
            }
            case 26: {
                pSHelpArticleBase.resetPSModuleName();
                return true;
            }
            case 27: {
                pSHelpArticleBase.resetPSSystemId();
                return true;
            }
            case 28: {
                pSHelpArticleBase.resetPSSystemName();
                return true;
            }
            case 29: {
                pSHelpArticleBase.resetPSSysUserCaseId();
                return true;
            }
            case 30: {
                pSHelpArticleBase.resetPSSysUserCaseName();
                return true;
            }
            case 31: {
                pSHelpArticleBase.resetSubCaption();
                return true;
            }
            case 32: {
                pSHelpArticleBase.resetTitle();
                return true;
            }
            case 33: {
                pSHelpArticleBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSHelpArticleBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSHelpArticleBase.resetUserCat();
                return true;
            }
            case 36: {
                pSHelpArticleBase.resetUserTag();
                return true;
            }
            case 37: {
                pSHelpArticleBase.resetUserTag2();
                return true;
            }
            case 38: {
                pSHelpArticleBase.resetUserTag3();
                return true;
            }
            case 39: {
                pSHelpArticleBase.resetUserTag4();
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
    public PSHelpArticleCat getPSHelpArticleCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleCat();
        }
        if (this.getPSHelpArticleCatId() == null) {
            return null;
        }
        Integer n = this.objPSHelpArticleCatLock;
        synchronized (n) {
            if (this.pshelparticlecat != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpArticleCatId(), (Object)this.pshelparticlecat.getPSHelpArticleCatId()) != 0L) {
                this.pshelparticlecat = null;
            }
            if (this.pshelparticlecat == null) {
                PSHelpArticleCat pSHelpArticleCat = new PSHelpArticleCat();
                pSHelpArticleCat.setPSHelpArticleCatId(this.getPSHelpArticleCatId());
                PSHelpArticleCatService pSHelpArticleCatService = (PSHelpArticleCatService)ServiceGlobal.getService(PSHelpArticleCatService.class, (SessionFactory)this.getSessionFactory());
                pSHelpArticleCatService.autoGet(pSHelpArticleCat);
                this.pshelparticlecat = pSHelpArticleCat;
            }
            return this.pshelparticlecat;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserCase getPSSysUserCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCase();
        }
        if (this.getPSSysUserCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserCaseLock;
        synchronized (n) {
            if (this.pssysusercase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserCaseId(), (Object)this.pssysusercase.getPSSysUserCaseId()) != 0L) {
                this.pssysusercase = null;
            }
            if (this.pssysusercase == null) {
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                pSSysUserCase.setPSSysUserCaseId(this.getPSSysUserCaseId());
                PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserCaseService.autoGet(pSSysUserCase);
                this.pssysusercase = pSSysUserCase;
            }
            return this.pssysusercase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSHelpSection> getPSHelpSections() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSections();
        }
        if (this.getPSHelpArticleId() == null) {
            return null;
        }
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSHelpSectionsLock;
        synchronized (n) {
            if (this.pshelpsections == null) {
                this.pshelpsections = pSHelpSectionService.selectByPSHelpArticle(this);
            }
            return this.pshelpsections;
        }
    }

    private PSHelpArticleBase getProxyEntity() {
        return this.proxyPSHelpArticleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpArticleBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpArticleBase) {
            this.proxyPSHelpArticleBase = (PSHelpArticleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARTICLEPARAM, 0);
        fieldIndexMap.put(FIELD_ARTICLEPARAM2, 1);
        fieldIndexMap.put(FIELD_ARTICLEPARAM3, 2);
        fieldIndexMap.put(FIELD_ARTICLEPARAM4, 3);
        fieldIndexMap.put(FIELD_ARTICLEPARAM5, 4);
        fieldIndexMap.put(FIELD_ARTICLEPARAM6, 5);
        fieldIndexMap.put(FIELD_ARTICLEPARAM7, 6);
        fieldIndexMap.put(FIELD_ARTICLEPARAM8, 7);
        fieldIndexMap.put(FIELD_ARTICLESN, 8);
        fieldIndexMap.put(FIELD_ARTICLETYPE, 9);
        fieldIndexMap.put(FIELD_ARTICLEVER, 10);
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 11);
        fieldIndexMap.put(FIELD_CODENAME, 12);
        fieldIndexMap.put(FIELD_CONTENT, 13);
        fieldIndexMap.put(FIELD_CREATEDATE, 14);
        fieldIndexMap.put(FIELD_CREATEMAN, 15);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 16);
        fieldIndexMap.put(FIELD_KEYWORDS, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_PSDEID, 19);
        fieldIndexMap.put(FIELD_PSDENAME, 20);
        fieldIndexMap.put(FIELD_PSHELPARTICLECATID, 21);
        fieldIndexMap.put(FIELD_PSHELPARTICLECATNAME, 22);
        fieldIndexMap.put(FIELD_PSHELPARTICLEID, 23);
        fieldIndexMap.put(FIELD_PSHELPARTICLENAME, 24);
        fieldIndexMap.put(FIELD_PSMODULEID, 25);
        fieldIndexMap.put(FIELD_PSMODULENAME, 26);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 27);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSUSERCASEID, 29);
        fieldIndexMap.put(FIELD_PSSYSUSERCASENAME, 30);
        fieldIndexMap.put(FIELD_SUBCAPTION, 31);
        fieldIndexMap.put(FIELD_TITLE, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_USERCAT, 35);
        fieldIndexMap.put(FIELD_USERTAG, 36);
        fieldIndexMap.put(FIELD_USERTAG2, 37);
        fieldIndexMap.put(FIELD_USERTAG3, 38);
        fieldIndexMap.put(FIELD_USERTAG4, 39);
    }
}

