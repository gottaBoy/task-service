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
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTempl;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpResource;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpResourceService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpSectionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpSectionBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENT2 = "CONTENT2";
    public static final String FIELD_CONTENTASCODE = "CONTENTASCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPANDMODE = "EXPANDMODE";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_LINKPSHELPRESOURCEID = "LINKPSHELPRESOURCEID";
    public static final String FIELD_LINKPSHELPRESOURCENAME = "LINKPSHELPRESOURCENAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPUTDIR = "OUTPUTDIR";
    public static final String FIELD_PPSHELPSECTORID = "PPSHELPSECTIONID";
    public static final String FIELD_PPSHELPSECTORNAME = "PPSHELPSECTIONNAME";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFIELDID = "PSDEFIELDID";
    public static final String FIELD_PSDEFIELDNAME = "PSDEFIELDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSHELPARTICLEID = "PSHELPARTICLEID";
    public static final String FIELD_PSHELPARTICLENAME = "PSHELPARTICLENAME";
    public static final String FIELD_PSHELPRESOURCEID = "PSHELPRESOURCEID";
    public static final String FIELD_PSHELPRESOURCENAME = "PSHELPRESOURCENAME";
    public static final String FIELD_PSHELPSECTIONID = "PSHELPSECTIONID";
    public static final String FIELD_PSHELPSECTIONNAME = "PSHELPSECTIONNAME";
    public static final String FIELD_PSHELPSECTIONTEMPLID = "PSHELPSECTIONTEMPLID";
    public static final String FIELD_PSHELPSECTIONTEMPLNAME = "PSHELPSECTIONTEMPLNAME";
    public static final String FIELD_REFPSHELPARTICLEID = "REFPSHELPARTICLEID";
    public static final String FIELD_REFPSHELPARTICLENAME = "REFPSHELPARTICLENAME";
    public static final String FIELD_SECTIONPARAM = "SECTIONPARAM";
    public static final String FIELD_SECTIONPARAM2 = "SECTIONPARAM2";
    public static final String FIELD_SECTIONSN = "SECTIONSN";
    public static final String FIELD_SECTIONTYPE = "SECTIONTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CONTENT = 2;
    private static final int INDEX_CONTENT2 = 3;
    private static final int INDEX_CONTENTASCODE = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_EXPANDMODE = 7;
    private static final int INDEX_HEADERCONTENT = 8;
    private static final int INDEX_LINKPSHELPRESOURCEID = 9;
    private static final int INDEX_LINKPSHELPRESOURCENAME = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_ORDERVALUE = 12;
    private static final int INDEX_OUTPUTDIR = 13;
    private static final int INDEX_PPSHELPSECTORID = 14;
    private static final int INDEX_PPSHELPSECTORNAME = 15;
    private static final int INDEX_PSCODELISTID = 16;
    private static final int INDEX_PSCODELISTNAME = 17;
    private static final int INDEX_PSDEFIELDID = 18;
    private static final int INDEX_PSDEFIELDNAME = 19;
    private static final int INDEX_PSDEID = 20;
    private static final int INDEX_PSDEUIACTIONID = 21;
    private static final int INDEX_PSDEUIACTIONNAME = 22;
    private static final int INDEX_PSHELPARTICLEID = 23;
    private static final int INDEX_PSHELPARTICLENAME = 24;
    private static final int INDEX_PSHELPRESOURCEID = 25;
    private static final int INDEX_PSHELPRESOURCENAME = 26;
    private static final int INDEX_PSHELPSECTIONID = 27;
    private static final int INDEX_PSHELPSECTIONNAME = 28;
    private static final int INDEX_PSHELPSECTIONTEMPLID = 29;
    private static final int INDEX_PSHELPSECTIONTEMPLNAME = 30;
    private static final int INDEX_REFPSHELPARTICLEID = 31;
    private static final int INDEX_REFPSHELPARTICLENAME = 32;
    private static final int INDEX_SECTIONPARAM = 33;
    private static final int INDEX_SECTIONPARAM2 = 34;
    private static final int INDEX_SECTIONSN = 35;
    private static final int INDEX_SECTIONTYPE = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_USERCAT = 39;
    private static final int INDEX_USERTAG = 40;
    private static final int INDEX_USERTAG2 = 41;
    private static final int INDEX_USERTAG3 = 42;
    private static final int INDEX_USERTAG4 = 43;
    private static final int INDEX_VALIDFLAG = 44;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpSectionBase proxyPSHelpSectionBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean content2DirtyFlag = false;
    private boolean contentascodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expandmodeDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean linkpshelpresourceidDirtyFlag = false;
    private boolean linkpshelpresourcenameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outputdirDirtyFlag = false;
    private boolean ppshelpsectoridDirtyFlag = false;
    private boolean ppshelpsectornameDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefieldidDirtyFlag = false;
    private boolean psdefieldnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pshelparticleidDirtyFlag = false;
    private boolean pshelparticlenameDirtyFlag = false;
    private boolean pshelpresourceidDirtyFlag = false;
    private boolean pshelpresourcenameDirtyFlag = false;
    private boolean pshelpsectionidDirtyFlag = false;
    private boolean pshelpsectionnameDirtyFlag = false;
    private boolean pshelpsectiontemplidDirtyFlag = false;
    private boolean pshelpsectiontemplnameDirtyFlag = false;
    private boolean refpshelparticleidDirtyFlag = false;
    private boolean refpshelparticlenameDirtyFlag = false;
    private boolean sectionparamDirtyFlag = false;
    private boolean sectionparam2DirtyFlag = false;
    private boolean sectionsnDirtyFlag = false;
    private boolean sectiontypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bottomcontent")
    private String bottomcontent;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="content2")
    private String content2;
    @Column(name="contentascode")
    private Integer contentascode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expandmode")
    private Integer expandmode;
    @Column(name="headercontent")
    private String headercontent;
    @Column(name="linkpshelpresourceid")
    private String linkpshelpresourceid;
    @Column(name="linkpshelpresourcename")
    private String linkpshelpresourcename;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="outputdir")
    private Integer outputdir;
    @Column(name="ppshelpsectorid")
    private String ppshelpsectorid;
    @Column(name="ppshelpsectorname")
    private String ppshelpsectorname;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdefieldid")
    private String psdefieldid;
    @Column(name="psdefieldname")
    private String psdefieldname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="pshelparticleid")
    private String pshelparticleid;
    @Column(name="pshelparticlename")
    private String pshelparticlename;
    @Column(name="pshelpresourceid")
    private String pshelpresourceid;
    @Column(name="pshelpresourcename")
    private String pshelpresourcename;
    @Column(name="pshelpsectionid")
    private String pshelpsectionid;
    @Column(name="pshelpsectionname")
    private String pshelpsectionname;
    @Column(name="pshelpsectiontemplid")
    private String pshelpsectiontemplid;
    @Column(name="pshelpsectiontemplname")
    private String pshelpsectiontemplname;
    @Column(name="refpshelparticleid")
    private String refpshelparticleid;
    @Column(name="refpshelparticlename")
    private String refpshelparticlename;
    @Column(name="sectionparam")
    private String sectionparam;
    @Column(name="sectionparam2")
    private String sectionparam2;
    @Column(name="sectionsn")
    private String sectionsn;
    @Column(name="sectiontype")
    private String sectiontype;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEFieldLock = new Integer(1);
    private PSDEField psdefield = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objPSHelpArticleLock = new Integer(1);
    private PSHelpArticle pshelparticle = null;
    private Integer objRefPSHelpArticleLock = new Integer(1);
    private PSHelpArticle refpshelparticle = null;
    private Integer objLinkPSHelpResourceLock = new Integer(1);
    private PSHelpResource linkpshelpresource = null;
    private Integer objPSHelpResourceLock = new Integer(1);
    private PSHelpResource pshelpresource = null;
    private Integer objPSHelpSectionTemplLock = new Integer(1);
    private PSHelpSectionTempl pshelpsectiontempl = null;
    private Integer objPPSHelpSectorLock = new Integer(1);
    private PSHelpSection ppshelpsector = null;
    private Integer objPSHelpSectionsLock = new Integer(1);
    private ArrayList<PSHelpSection> pshelpsections = null;

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

    public void setContent2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content2 = string;
        this.content2DirtyFlag = true;
    }

    public String getContent2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent2();
        }
        return this.content2;
    }

    public boolean isContent2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContent2Dirty();
        }
        return this.content2DirtyFlag;
    }

    public void resetContent2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent2();
            return;
        }
        this.content2DirtyFlag = false;
        this.content2 = null;
    }

    public void setContentAsCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentAsCode(n);
            return;
        }
        this.contentascode = n;
        this.contentascodeDirtyFlag = true;
    }

    public Integer getContentAsCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentAsCode();
        }
        return this.contentascode;
    }

    public boolean isContentAsCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentAsCodeDirty();
        }
        return this.contentascodeDirtyFlag;
    }

    public void resetContentAsCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentAsCode();
            return;
        }
        this.contentascodeDirtyFlag = false;
        this.contentascode = null;
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

    public void setExpandMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpandMode(n);
            return;
        }
        this.expandmode = n;
        this.expandmodeDirtyFlag = true;
    }

    public Integer getExpandMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpandMode();
        }
        return this.expandmode;
    }

    public boolean isExpandModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpandModeDirty();
        }
        return this.expandmodeDirtyFlag;
    }

    public void resetExpandMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpandMode();
            return;
        }
        this.expandmodeDirtyFlag = false;
        this.expandmode = null;
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

    public void setLinkPSHelpResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSHelpResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpshelpresourceid = string;
        this.linkpshelpresourceidDirtyFlag = true;
    }

    public String getLinkPSHelpResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSHelpResourceId();
        }
        return this.linkpshelpresourceid;
    }

    public boolean isLinkPSHelpResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSHelpResourceIdDirty();
        }
        return this.linkpshelpresourceidDirtyFlag;
    }

    public void resetLinkPSHelpResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSHelpResourceId();
            return;
        }
        this.linkpshelpresourceidDirtyFlag = false;
        this.linkpshelpresourceid = null;
    }

    public void setLinkPSHelpResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSHelpResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpshelpresourcename = string;
        this.linkpshelpresourcenameDirtyFlag = true;
    }

    public String getLinkPSHelpResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSHelpResourceName();
        }
        return this.linkpshelpresourcename;
    }

    public boolean isLinkPSHelpResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSHelpResourceNameDirty();
        }
        return this.linkpshelpresourcenameDirtyFlag;
    }

    public void resetLinkPSHelpResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSHelpResourceName();
            return;
        }
        this.linkpshelpresourcenameDirtyFlag = false;
        this.linkpshelpresourcename = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setOutputDir(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutputDir(n);
            return;
        }
        this.outputdir = n;
        this.outputdirDirtyFlag = true;
    }

    public Integer getOutputDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutputDir();
        }
        return this.outputdir;
    }

    public boolean isOutputDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutputDirDirty();
        }
        return this.outputdirDirtyFlag;
    }

    public void resetOutputDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutputDir();
            return;
        }
        this.outputdirDirtyFlag = false;
        this.outputdir = null;
    }

    public void setPPSHelpSectorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSHelpSectorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppshelpsectorid = string;
        this.ppshelpsectoridDirtyFlag = true;
    }

    public String getPPSHelpSectorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSHelpSectorId();
        }
        return this.ppshelpsectorid;
    }

    public boolean isPPSHelpSectorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSHelpSectorIdDirty();
        }
        return this.ppshelpsectoridDirtyFlag;
    }

    public void resetPPSHelpSectorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSHelpSectorId();
            return;
        }
        this.ppshelpsectoridDirtyFlag = false;
        this.ppshelpsectorid = null;
    }

    public void setPPSHelpSectorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSHelpSectorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppshelpsectorname = string;
        this.ppshelpsectornameDirtyFlag = true;
    }

    public String getPPSHelpSectorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSHelpSectorName();
        }
        return this.ppshelpsectorname;
    }

    public boolean isPPSHelpSectorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSHelpSectorNameDirty();
        }
        return this.ppshelpsectornameDirtyFlag;
    }

    public void resetPPSHelpSectorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSHelpSectorName();
            return;
        }
        this.ppshelpsectornameDirtyFlag = false;
        this.ppshelpsectorname = null;
    }

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDEFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefieldid = string;
        this.psdefieldidDirtyFlag = true;
    }

    public String getPSDEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldId();
        }
        return this.psdefieldid;
    }

    public boolean isPSDEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldIdDirty();
        }
        return this.psdefieldidDirtyFlag;
    }

    public void resetPSDEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldId();
            return;
        }
        this.psdefieldidDirtyFlag = false;
        this.psdefieldid = null;
    }

    public void setPSDEFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefieldname = string;
        this.psdefieldnameDirtyFlag = true;
    }

    public String getPSDEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldName();
        }
        return this.psdefieldname;
    }

    public boolean isPSDEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldNameDirty();
        }
        return this.psdefieldnameDirtyFlag;
    }

    public void resetPSDEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldName();
            return;
        }
        this.psdefieldnameDirtyFlag = false;
        this.psdefieldname = null;
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

    public void setPSHelpResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpresourceid = string;
        this.pshelpresourceidDirtyFlag = true;
    }

    public String getPSHelpResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpResourceId();
        }
        return this.pshelpresourceid;
    }

    public boolean isPSHelpResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpResourceIdDirty();
        }
        return this.pshelpresourceidDirtyFlag;
    }

    public void resetPSHelpResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpResourceId();
            return;
        }
        this.pshelpresourceidDirtyFlag = false;
        this.pshelpresourceid = null;
    }

    public void setPSHelpResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpresourcename = string;
        this.pshelpresourcenameDirtyFlag = true;
    }

    public String getPSHelpResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpResourceName();
        }
        return this.pshelpresourcename;
    }

    public boolean isPSHelpResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpResourceNameDirty();
        }
        return this.pshelpresourcenameDirtyFlag;
    }

    public void resetPSHelpResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpResourceName();
            return;
        }
        this.pshelpresourcenameDirtyFlag = false;
        this.pshelpresourcename = null;
    }

    public void setPSHelpSectionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectionid = string;
        this.pshelpsectionidDirtyFlag = true;
    }

    public String getPSHelpSectionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionId();
        }
        return this.pshelpsectionid;
    }

    public boolean isPSHelpSectionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionIdDirty();
        }
        return this.pshelpsectionidDirtyFlag;
    }

    public void resetPSHelpSectionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionId();
            return;
        }
        this.pshelpsectionidDirtyFlag = false;
        this.pshelpsectionid = null;
    }

    public void setPSHelpSectionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectionname = string;
        this.pshelpsectionnameDirtyFlag = true;
    }

    public String getPSHelpSectionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionName();
        }
        return this.pshelpsectionname;
    }

    public boolean isPSHelpSectionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionNameDirty();
        }
        return this.pshelpsectionnameDirtyFlag;
    }

    public void resetPSHelpSectionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionName();
            return;
        }
        this.pshelpsectionnameDirtyFlag = false;
        this.pshelpsectionname = null;
    }

    public void setPSHelpSectionTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontemplid = string;
        this.pshelpsectiontemplidDirtyFlag = true;
    }

    public String getPSHelpSectionTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTemplId();
        }
        return this.pshelpsectiontemplid;
    }

    public boolean isPSHelpSectionTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTemplIdDirty();
        }
        return this.pshelpsectiontemplidDirtyFlag;
    }

    public void resetPSHelpSectionTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTemplId();
            return;
        }
        this.pshelpsectiontemplidDirtyFlag = false;
        this.pshelpsectiontemplid = null;
    }

    public void setPSHelpSectionTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpSectionTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpsectiontemplname = string;
        this.pshelpsectiontemplnameDirtyFlag = true;
    }

    public String getPSHelpSectionTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTemplName();
        }
        return this.pshelpsectiontemplname;
    }

    public boolean isPSHelpSectionTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpSectionTemplNameDirty();
        }
        return this.pshelpsectiontemplnameDirtyFlag;
    }

    public void resetPSHelpSectionTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpSectionTemplName();
            return;
        }
        this.pshelpsectiontemplnameDirtyFlag = false;
        this.pshelpsectiontemplname = null;
    }

    public void setRefPSHelpArticleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSHelpArticleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpshelparticleid = string;
        this.refpshelparticleidDirtyFlag = true;
    }

    public String getRefPSHelpArticleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSHelpArticleId();
        }
        return this.refpshelparticleid;
    }

    public boolean isRefPSHelpArticleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSHelpArticleIdDirty();
        }
        return this.refpshelparticleidDirtyFlag;
    }

    public void resetRefPSHelpArticleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSHelpArticleId();
            return;
        }
        this.refpshelparticleidDirtyFlag = false;
        this.refpshelparticleid = null;
    }

    public void setRefPSHelpArticleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSHelpArticleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpshelparticlename = string;
        this.refpshelparticlenameDirtyFlag = true;
    }

    public String getRefPSHelpArticleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSHelpArticleName();
        }
        return this.refpshelparticlename;
    }

    public boolean isRefPSHelpArticleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSHelpArticleNameDirty();
        }
        return this.refpshelparticlenameDirtyFlag;
    }

    public void resetRefPSHelpArticleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSHelpArticleName();
            return;
        }
        this.refpshelparticlenameDirtyFlag = false;
        this.refpshelparticlename = null;
    }

    public void setSectionParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSectionParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sectionparam = string;
        this.sectionparamDirtyFlag = true;
    }

    public String getSectionParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSectionParam();
        }
        return this.sectionparam;
    }

    public boolean isSectionParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSectionParamDirty();
        }
        return this.sectionparamDirtyFlag;
    }

    public void resetSectionParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSectionParam();
            return;
        }
        this.sectionparamDirtyFlag = false;
        this.sectionparam = null;
    }

    public void setSectionParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSectionParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sectionparam2 = string;
        this.sectionparam2DirtyFlag = true;
    }

    public String getSectionParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSectionParam2();
        }
        return this.sectionparam2;
    }

    public boolean isSectionParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSectionParam2Dirty();
        }
        return this.sectionparam2DirtyFlag;
    }

    public void resetSectionParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSectionParam2();
            return;
        }
        this.sectionparam2DirtyFlag = false;
        this.sectionparam2 = null;
    }

    public void setSectionSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSectionSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sectionsn = string;
        this.sectionsnDirtyFlag = true;
    }

    public String getSectionSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSectionSN();
        }
        return this.sectionsn;
    }

    public boolean isSectionSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSectionSNDirty();
        }
        return this.sectionsnDirtyFlag;
    }

    public void resetSectionSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSectionSN();
            return;
        }
        this.sectionsnDirtyFlag = false;
        this.sectionsn = null;
    }

    public void setSectionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSectionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sectiontype = string;
        this.sectiontypeDirtyFlag = true;
    }

    public String getSectionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSectionType();
        }
        return this.sectiontype;
    }

    public boolean isSectionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSectionTypeDirty();
        }
        return this.sectiontypeDirtyFlag;
    }

    public void resetSectionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSectionType();
            return;
        }
        this.sectiontypeDirtyFlag = false;
        this.sectiontype = null;
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
        PSHelpSectionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpSectionBase pSHelpSectionBase) {
        pSHelpSectionBase.resetBottomContent();
        pSHelpSectionBase.resetCodeName();
        pSHelpSectionBase.resetContent();
        pSHelpSectionBase.resetContent2();
        pSHelpSectionBase.resetContentAsCode();
        pSHelpSectionBase.resetCreateDate();
        pSHelpSectionBase.resetCreateMan();
        pSHelpSectionBase.resetExpandMode();
        pSHelpSectionBase.resetHeaderContent();
        pSHelpSectionBase.resetLinkPSHelpResourceId();
        pSHelpSectionBase.resetLinkPSHelpResourceName();
        pSHelpSectionBase.resetMemo();
        pSHelpSectionBase.resetOrderValue();
        pSHelpSectionBase.resetOutputDir();
        pSHelpSectionBase.resetPPSHelpSectorId();
        pSHelpSectionBase.resetPPSHelpSectorName();
        pSHelpSectionBase.resetPSCodeListId();
        pSHelpSectionBase.resetPSCodeListName();
        pSHelpSectionBase.resetPSDEFieldId();
        pSHelpSectionBase.resetPSDEFieldName();
        pSHelpSectionBase.resetPSDEId();
        pSHelpSectionBase.resetPSDEUIActionId();
        pSHelpSectionBase.resetPSDEUIActionName();
        pSHelpSectionBase.resetPSHelpArticleId();
        pSHelpSectionBase.resetPSHelpArticleName();
        pSHelpSectionBase.resetPSHelpResourceId();
        pSHelpSectionBase.resetPSHelpResourceName();
        pSHelpSectionBase.resetPSHelpSectionId();
        pSHelpSectionBase.resetPSHelpSectionName();
        pSHelpSectionBase.resetPSHelpSectionTemplId();
        pSHelpSectionBase.resetPSHelpSectionTemplName();
        pSHelpSectionBase.resetRefPSHelpArticleId();
        pSHelpSectionBase.resetRefPSHelpArticleName();
        pSHelpSectionBase.resetSectionParam();
        pSHelpSectionBase.resetSectionParam2();
        pSHelpSectionBase.resetSectionSN();
        pSHelpSectionBase.resetSectionType();
        pSHelpSectionBase.resetUpdateDate();
        pSHelpSectionBase.resetUpdateMan();
        pSHelpSectionBase.resetUserCat();
        pSHelpSectionBase.resetUserTag();
        pSHelpSectionBase.resetUserTag2();
        pSHelpSectionBase.resetUserTag3();
        pSHelpSectionBase.resetUserTag4();
        pSHelpSectionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBottomContentDirty()) {
            hashMap.put(FIELD_BOTTOMCONTENT, this.getBottomContent());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContent2Dirty()) {
            hashMap.put(FIELD_CONTENT2, this.getContent2());
        }
        if (!bl || this.isContentAsCodeDirty()) {
            hashMap.put(FIELD_CONTENTASCODE, this.getContentAsCode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpandModeDirty()) {
            hashMap.put(FIELD_EXPANDMODE, this.getExpandMode());
        }
        if (!bl || this.isHeaderContentDirty()) {
            hashMap.put(FIELD_HEADERCONTENT, this.getHeaderContent());
        }
        if (!bl || this.isLinkPSHelpResourceIdDirty()) {
            hashMap.put(FIELD_LINKPSHELPRESOURCEID, this.getLinkPSHelpResourceId());
        }
        if (!bl || this.isLinkPSHelpResourceNameDirty()) {
            hashMap.put(FIELD_LINKPSHELPRESOURCENAME, this.getLinkPSHelpResourceName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOutputDirDirty()) {
            hashMap.put(FIELD_OUTPUTDIR, this.getOutputDir());
        }
        if (!bl || this.isPPSHelpSectorIdDirty()) {
            hashMap.put(FIELD_PPSHELPSECTORID, this.getPPSHelpSectorId());
        }
        if (!bl || this.isPPSHelpSectorNameDirty()) {
            hashMap.put(FIELD_PPSHELPSECTORNAME, this.getPPSHelpSectorName());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEFieldIdDirty()) {
            hashMap.put(FIELD_PSDEFIELDID, this.getPSDEFieldId());
        }
        if (!bl || this.isPSDEFieldNameDirty()) {
            hashMap.put(FIELD_PSDEFIELDNAME, this.getPSDEFieldName());
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
        if (!bl || this.isPSHelpArticleIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLEID, this.getPSHelpArticleId());
        }
        if (!bl || this.isPSHelpArticleNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLENAME, this.getPSHelpArticleName());
        }
        if (!bl || this.isPSHelpResourceIdDirty()) {
            hashMap.put(FIELD_PSHELPRESOURCEID, this.getPSHelpResourceId());
        }
        if (!bl || this.isPSHelpResourceNameDirty()) {
            hashMap.put(FIELD_PSHELPRESOURCENAME, this.getPSHelpResourceName());
        }
        if (!bl || this.isPSHelpSectionIdDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONID, this.getPSHelpSectionId());
        }
        if (!bl || this.isPSHelpSectionNameDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONNAME, this.getPSHelpSectionName());
        }
        if (!bl || this.isPSHelpSectionTemplIdDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTEMPLID, this.getPSHelpSectionTemplId());
        }
        if (!bl || this.isPSHelpSectionTemplNameDirty()) {
            hashMap.put(FIELD_PSHELPSECTIONTEMPLNAME, this.getPSHelpSectionTemplName());
        }
        if (!bl || this.isRefPSHelpArticleIdDirty()) {
            hashMap.put(FIELD_REFPSHELPARTICLEID, this.getRefPSHelpArticleId());
        }
        if (!bl || this.isRefPSHelpArticleNameDirty()) {
            hashMap.put(FIELD_REFPSHELPARTICLENAME, this.getRefPSHelpArticleName());
        }
        if (!bl || this.isSectionParamDirty()) {
            hashMap.put(FIELD_SECTIONPARAM, this.getSectionParam());
        }
        if (!bl || this.isSectionParam2Dirty()) {
            hashMap.put(FIELD_SECTIONPARAM2, this.getSectionParam2());
        }
        if (!bl || this.isSectionSNDirty()) {
            hashMap.put(FIELD_SECTIONSN, this.getSectionSN());
        }
        if (!bl || this.isSectionTypeDirty()) {
            hashMap.put(FIELD_SECTIONTYPE, this.getSectionType());
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
        return PSHelpSectionBase.get(this, n);
    }

    private static Object get(PSHelpSectionBase pSHelpSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionBase.getBottomContent();
            }
            case 1: {
                return pSHelpSectionBase.getCodeName();
            }
            case 2: {
                return pSHelpSectionBase.getContent();
            }
            case 3: {
                return pSHelpSectionBase.getContent2();
            }
            case 4: {
                return pSHelpSectionBase.getContentAsCode();
            }
            case 5: {
                return pSHelpSectionBase.getCreateDate();
            }
            case 6: {
                return pSHelpSectionBase.getCreateMan();
            }
            case 7: {
                return pSHelpSectionBase.getExpandMode();
            }
            case 8: {
                return pSHelpSectionBase.getHeaderContent();
            }
            case 9: {
                return pSHelpSectionBase.getLinkPSHelpResourceId();
            }
            case 10: {
                return pSHelpSectionBase.getLinkPSHelpResourceName();
            }
            case 11: {
                return pSHelpSectionBase.getMemo();
            }
            case 12: {
                return pSHelpSectionBase.getOrderValue();
            }
            case 13: {
                return pSHelpSectionBase.getOutputDir();
            }
            case 14: {
                return pSHelpSectionBase.getPPSHelpSectorId();
            }
            case 15: {
                return pSHelpSectionBase.getPPSHelpSectorName();
            }
            case 16: {
                return pSHelpSectionBase.getPSCodeListId();
            }
            case 17: {
                return pSHelpSectionBase.getPSCodeListName();
            }
            case 18: {
                return pSHelpSectionBase.getPSDEFieldId();
            }
            case 19: {
                return pSHelpSectionBase.getPSDEFieldName();
            }
            case 20: {
                return pSHelpSectionBase.getPSDEId();
            }
            case 21: {
                return pSHelpSectionBase.getPSDEUIActionId();
            }
            case 22: {
                return pSHelpSectionBase.getPSDEUIActionName();
            }
            case 23: {
                return pSHelpSectionBase.getPSHelpArticleId();
            }
            case 24: {
                return pSHelpSectionBase.getPSHelpArticleName();
            }
            case 25: {
                return pSHelpSectionBase.getPSHelpResourceId();
            }
            case 26: {
                return pSHelpSectionBase.getPSHelpResourceName();
            }
            case 27: {
                return pSHelpSectionBase.getPSHelpSectionId();
            }
            case 28: {
                return pSHelpSectionBase.getPSHelpSectionName();
            }
            case 29: {
                return pSHelpSectionBase.getPSHelpSectionTemplId();
            }
            case 30: {
                return pSHelpSectionBase.getPSHelpSectionTemplName();
            }
            case 31: {
                return pSHelpSectionBase.getRefPSHelpArticleId();
            }
            case 32: {
                return pSHelpSectionBase.getRefPSHelpArticleName();
            }
            case 33: {
                return pSHelpSectionBase.getSectionParam();
            }
            case 34: {
                return pSHelpSectionBase.getSectionParam2();
            }
            case 35: {
                return pSHelpSectionBase.getSectionSN();
            }
            case 36: {
                return pSHelpSectionBase.getSectionType();
            }
            case 37: {
                return pSHelpSectionBase.getUpdateDate();
            }
            case 38: {
                return pSHelpSectionBase.getUpdateMan();
            }
            case 39: {
                return pSHelpSectionBase.getUserCat();
            }
            case 40: {
                return pSHelpSectionBase.getUserTag();
            }
            case 41: {
                return pSHelpSectionBase.getUserTag2();
            }
            case 42: {
                return pSHelpSectionBase.getUserTag3();
            }
            case 43: {
                return pSHelpSectionBase.getUserTag4();
            }
            case 44: {
                return pSHelpSectionBase.getValidFlag();
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
        PSHelpSectionBase.set(this, n, object);
    }

    private static void set(PSHelpSectionBase pSHelpSectionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpSectionBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSHelpSectionBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpSectionBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSHelpSectionBase.setContent2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpSectionBase.setContentAsCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSHelpSectionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSHelpSectionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpSectionBase.setExpandMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSHelpSectionBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpSectionBase.setLinkPSHelpResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpSectionBase.setLinkPSHelpResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSHelpSectionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpSectionBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSHelpSectionBase.setOutputDir(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSHelpSectionBase.setPPSHelpSectorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSHelpSectionBase.setPPSHelpSectorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSHelpSectionBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSHelpSectionBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSHelpSectionBase.setPSDEFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSHelpSectionBase.setPSDEFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSHelpSectionBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSHelpSectionBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSHelpSectionBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSHelpSectionBase.setPSHelpArticleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSHelpSectionBase.setPSHelpArticleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSHelpSectionBase.setPSHelpResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSHelpSectionBase.setPSHelpResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSHelpSectionBase.setPSHelpSectionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSHelpSectionBase.setPSHelpSectionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSHelpSectionBase.setPSHelpSectionTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSHelpSectionBase.setPSHelpSectionTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSHelpSectionBase.setRefPSHelpArticleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSHelpSectionBase.setRefPSHelpArticleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSHelpSectionBase.setSectionParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSHelpSectionBase.setSectionParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSHelpSectionBase.setSectionSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSHelpSectionBase.setSectionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSHelpSectionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSHelpSectionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSHelpSectionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSHelpSectionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSHelpSectionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSHelpSectionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSHelpSectionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSHelpSectionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpSectionBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpSectionBase pSHelpSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionBase.getBottomContent() == null;
            }
            case 1: {
                return pSHelpSectionBase.getCodeName() == null;
            }
            case 2: {
                return pSHelpSectionBase.getContent() == null;
            }
            case 3: {
                return pSHelpSectionBase.getContent2() == null;
            }
            case 4: {
                return pSHelpSectionBase.getContentAsCode() == null;
            }
            case 5: {
                return pSHelpSectionBase.getCreateDate() == null;
            }
            case 6: {
                return pSHelpSectionBase.getCreateMan() == null;
            }
            case 7: {
                return pSHelpSectionBase.getExpandMode() == null;
            }
            case 8: {
                return pSHelpSectionBase.getHeaderContent() == null;
            }
            case 9: {
                return pSHelpSectionBase.getLinkPSHelpResourceId() == null;
            }
            case 10: {
                return pSHelpSectionBase.getLinkPSHelpResourceName() == null;
            }
            case 11: {
                return pSHelpSectionBase.getMemo() == null;
            }
            case 12: {
                return pSHelpSectionBase.getOrderValue() == null;
            }
            case 13: {
                return pSHelpSectionBase.getOutputDir() == null;
            }
            case 14: {
                return pSHelpSectionBase.getPPSHelpSectorId() == null;
            }
            case 15: {
                return pSHelpSectionBase.getPPSHelpSectorName() == null;
            }
            case 16: {
                return pSHelpSectionBase.getPSCodeListId() == null;
            }
            case 17: {
                return pSHelpSectionBase.getPSCodeListName() == null;
            }
            case 18: {
                return pSHelpSectionBase.getPSDEFieldId() == null;
            }
            case 19: {
                return pSHelpSectionBase.getPSDEFieldName() == null;
            }
            case 20: {
                return pSHelpSectionBase.getPSDEId() == null;
            }
            case 21: {
                return pSHelpSectionBase.getPSDEUIActionId() == null;
            }
            case 22: {
                return pSHelpSectionBase.getPSDEUIActionName() == null;
            }
            case 23: {
                return pSHelpSectionBase.getPSHelpArticleId() == null;
            }
            case 24: {
                return pSHelpSectionBase.getPSHelpArticleName() == null;
            }
            case 25: {
                return pSHelpSectionBase.getPSHelpResourceId() == null;
            }
            case 26: {
                return pSHelpSectionBase.getPSHelpResourceName() == null;
            }
            case 27: {
                return pSHelpSectionBase.getPSHelpSectionId() == null;
            }
            case 28: {
                return pSHelpSectionBase.getPSHelpSectionName() == null;
            }
            case 29: {
                return pSHelpSectionBase.getPSHelpSectionTemplId() == null;
            }
            case 30: {
                return pSHelpSectionBase.getPSHelpSectionTemplName() == null;
            }
            case 31: {
                return pSHelpSectionBase.getRefPSHelpArticleId() == null;
            }
            case 32: {
                return pSHelpSectionBase.getRefPSHelpArticleName() == null;
            }
            case 33: {
                return pSHelpSectionBase.getSectionParam() == null;
            }
            case 34: {
                return pSHelpSectionBase.getSectionParam2() == null;
            }
            case 35: {
                return pSHelpSectionBase.getSectionSN() == null;
            }
            case 36: {
                return pSHelpSectionBase.getSectionType() == null;
            }
            case 37: {
                return pSHelpSectionBase.getUpdateDate() == null;
            }
            case 38: {
                return pSHelpSectionBase.getUpdateMan() == null;
            }
            case 39: {
                return pSHelpSectionBase.getUserCat() == null;
            }
            case 40: {
                return pSHelpSectionBase.getUserTag() == null;
            }
            case 41: {
                return pSHelpSectionBase.getUserTag2() == null;
            }
            case 42: {
                return pSHelpSectionBase.getUserTag3() == null;
            }
            case 43: {
                return pSHelpSectionBase.getUserTag4() == null;
            }
            case 44: {
                return pSHelpSectionBase.getValidFlag() == null;
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
        return PSHelpSectionBase.contains(this, n);
    }

    private static boolean contains(PSHelpSectionBase pSHelpSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpSectionBase.isBottomContentDirty();
            }
            case 1: {
                return pSHelpSectionBase.isCodeNameDirty();
            }
            case 2: {
                return pSHelpSectionBase.isContentDirty();
            }
            case 3: {
                return pSHelpSectionBase.isContent2Dirty();
            }
            case 4: {
                return pSHelpSectionBase.isContentAsCodeDirty();
            }
            case 5: {
                return pSHelpSectionBase.isCreateDateDirty();
            }
            case 6: {
                return pSHelpSectionBase.isCreateManDirty();
            }
            case 7: {
                return pSHelpSectionBase.isExpandModeDirty();
            }
            case 8: {
                return pSHelpSectionBase.isHeaderContentDirty();
            }
            case 9: {
                return pSHelpSectionBase.isLinkPSHelpResourceIdDirty();
            }
            case 10: {
                return pSHelpSectionBase.isLinkPSHelpResourceNameDirty();
            }
            case 11: {
                return pSHelpSectionBase.isMemoDirty();
            }
            case 12: {
                return pSHelpSectionBase.isOrderValueDirty();
            }
            case 13: {
                return pSHelpSectionBase.isOutputDirDirty();
            }
            case 14: {
                return pSHelpSectionBase.isPPSHelpSectorIdDirty();
            }
            case 15: {
                return pSHelpSectionBase.isPPSHelpSectorNameDirty();
            }
            case 16: {
                return pSHelpSectionBase.isPSCodeListIdDirty();
            }
            case 17: {
                return pSHelpSectionBase.isPSCodeListNameDirty();
            }
            case 18: {
                return pSHelpSectionBase.isPSDEFieldIdDirty();
            }
            case 19: {
                return pSHelpSectionBase.isPSDEFieldNameDirty();
            }
            case 20: {
                return pSHelpSectionBase.isPSDEIdDirty();
            }
            case 21: {
                return pSHelpSectionBase.isPSDEUIActionIdDirty();
            }
            case 22: {
                return pSHelpSectionBase.isPSDEUIActionNameDirty();
            }
            case 23: {
                return pSHelpSectionBase.isPSHelpArticleIdDirty();
            }
            case 24: {
                return pSHelpSectionBase.isPSHelpArticleNameDirty();
            }
            case 25: {
                return pSHelpSectionBase.isPSHelpResourceIdDirty();
            }
            case 26: {
                return pSHelpSectionBase.isPSHelpResourceNameDirty();
            }
            case 27: {
                return pSHelpSectionBase.isPSHelpSectionIdDirty();
            }
            case 28: {
                return pSHelpSectionBase.isPSHelpSectionNameDirty();
            }
            case 29: {
                return pSHelpSectionBase.isPSHelpSectionTemplIdDirty();
            }
            case 30: {
                return pSHelpSectionBase.isPSHelpSectionTemplNameDirty();
            }
            case 31: {
                return pSHelpSectionBase.isRefPSHelpArticleIdDirty();
            }
            case 32: {
                return pSHelpSectionBase.isRefPSHelpArticleNameDirty();
            }
            case 33: {
                return pSHelpSectionBase.isSectionParamDirty();
            }
            case 34: {
                return pSHelpSectionBase.isSectionParam2Dirty();
            }
            case 35: {
                return pSHelpSectionBase.isSectionSNDirty();
            }
            case 36: {
                return pSHelpSectionBase.isSectionTypeDirty();
            }
            case 37: {
                return pSHelpSectionBase.isUpdateDateDirty();
            }
            case 38: {
                return pSHelpSectionBase.isUpdateManDirty();
            }
            case 39: {
                return pSHelpSectionBase.isUserCatDirty();
            }
            case 40: {
                return pSHelpSectionBase.isUserTagDirty();
            }
            case 41: {
                return pSHelpSectionBase.isUserTag2Dirty();
            }
            case 42: {
                return pSHelpSectionBase.isUserTag3Dirty();
            }
            case 43: {
                return pSHelpSectionBase.isUserTag4Dirty();
            }
            case 44: {
                return pSHelpSectionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpSectionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpSectionBase pSHelpSectionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpSectionBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getCodeName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getContent()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getContent2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content2", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getContent2()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getContentAsCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentascode", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getContentAsCode()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getExpandMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expandmode", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getExpandMode()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getLinkPSHelpResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpshelpresourceid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getLinkPSHelpResourceId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getLinkPSHelpResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpshelpresourcename", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getLinkPSHelpResourceName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getOutputDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outputdir", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getOutputDir()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPPSHelpSectorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppshelpsectionid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPPSHelpSectorId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPPSHelpSectorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppshelpsectionname", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPPSHelpSectorName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSDEFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSDEFieldId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSDEFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldname", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSDEFieldName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpArticleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticleid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpArticleId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpArticleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticlename", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpArticleName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpresourceid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpResourceId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpresourcename", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpResourceName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectionid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpSectionId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectionname", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpSectionName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontemplid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpSectionTemplId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpsectiontemplname", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getPSHelpSectionTemplName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getRefPSHelpArticleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpshelparticleid", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getRefPSHelpArticleId()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getRefPSHelpArticleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpshelparticlename", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getRefPSHelpArticleName()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getSectionParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sectionparam", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getSectionParam()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getSectionParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sectionparam2", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getSectionParam2()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getSectionSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sectionsn", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getSectionSN()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getSectionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sectiontype", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getSectionType()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSHelpSectionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpSectionBase.getJSONValue((Object)pSHelpSectionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpSectionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpSectionBase pSHelpSectionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpSectionBase.getBottomContent() != null) {
            object = pSHelpSectionBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpSectionBase.getCodeName() != null) {
            object = pSHelpSectionBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpSectionBase.getContent() != null) {
            object = pSHelpSectionBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpSectionBase.getContent2() != null) {
            object = pSHelpSectionBase.getContent2();
            xmlNode.setAttribute(FIELD_CONTENT2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getContentAsCode() != null) {
            object = pSHelpSectionBase.getContentAsCode();
            xmlNode.setAttribute(FIELD_CONTENTASCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpSectionBase.getCreateDate() != null) {
            object = pSHelpSectionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpSectionBase.getCreateMan() != null) {
            object = pSHelpSectionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getExpandMode() != null) {
            object = pSHelpSectionBase.getExpandMode();
            xmlNode.setAttribute(FIELD_EXPANDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpSectionBase.getHeaderContent() != null) {
            object = pSHelpSectionBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getLinkPSHelpResourceId() != null) {
            object = pSHelpSectionBase.getLinkPSHelpResourceId();
            xmlNode.setAttribute(FIELD_LINKPSHELPRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getLinkPSHelpResourceName() != null) {
            object = pSHelpSectionBase.getLinkPSHelpResourceName();
            xmlNode.setAttribute(FIELD_LINKPSHELPRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getMemo() != null) {
            object = pSHelpSectionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getOrderValue() != null) {
            object = pSHelpSectionBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpSectionBase.getOutputDir() != null) {
            object = pSHelpSectionBase.getOutputDir();
            xmlNode.setAttribute(FIELD_OUTPUTDIR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpSectionBase.getPPSHelpSectorId() != null) {
            object = pSHelpSectionBase.getPPSHelpSectorId();
            xmlNode.setAttribute("PPSHELPSECTORID", object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPPSHelpSectorName() != null) {
            object = pSHelpSectionBase.getPPSHelpSectorName();
            xmlNode.setAttribute("PPSHELPSECTORNAME", object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSCodeListId() != null) {
            object = pSHelpSectionBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSCodeListName() != null) {
            object = pSHelpSectionBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSDEFieldId() != null) {
            object = pSHelpSectionBase.getPSDEFieldId();
            xmlNode.setAttribute(FIELD_PSDEFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSDEFieldName() != null) {
            object = pSHelpSectionBase.getPSDEFieldName();
            xmlNode.setAttribute(FIELD_PSDEFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSDEId() != null) {
            object = pSHelpSectionBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSDEUIActionId() != null) {
            object = pSHelpSectionBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSDEUIActionName() != null) {
            object = pSHelpSectionBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpArticleId() != null) {
            object = pSHelpSectionBase.getPSHelpArticleId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpArticleName() != null) {
            object = pSHelpSectionBase.getPSHelpArticleName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpResourceId() != null) {
            object = pSHelpSectionBase.getPSHelpResourceId();
            xmlNode.setAttribute(FIELD_PSHELPRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpResourceName() != null) {
            object = pSHelpSectionBase.getPSHelpResourceName();
            xmlNode.setAttribute(FIELD_PSHELPRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionId() != null) {
            object = pSHelpSectionBase.getPSHelpSectionId();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionName() != null) {
            object = pSHelpSectionBase.getPSHelpSectionName();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionTemplId() != null) {
            object = pSHelpSectionBase.getPSHelpSectionTemplId();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getPSHelpSectionTemplName() != null) {
            object = pSHelpSectionBase.getPSHelpSectionTemplName();
            xmlNode.setAttribute(FIELD_PSHELPSECTIONTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getRefPSHelpArticleId() != null) {
            object = pSHelpSectionBase.getRefPSHelpArticleId();
            xmlNode.setAttribute(FIELD_REFPSHELPARTICLEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getRefPSHelpArticleName() != null) {
            object = pSHelpSectionBase.getRefPSHelpArticleName();
            xmlNode.setAttribute(FIELD_REFPSHELPARTICLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getSectionParam() != null) {
            object = pSHelpSectionBase.getSectionParam();
            xmlNode.setAttribute(FIELD_SECTIONPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getSectionParam2() != null) {
            object = pSHelpSectionBase.getSectionParam2();
            xmlNode.setAttribute(FIELD_SECTIONPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getSectionSN() != null) {
            object = pSHelpSectionBase.getSectionSN();
            xmlNode.setAttribute(FIELD_SECTIONSN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getSectionType() != null) {
            object = pSHelpSectionBase.getSectionType();
            xmlNode.setAttribute(FIELD_SECTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getUpdateDate() != null) {
            object = pSHelpSectionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpSectionBase.getUpdateMan() != null) {
            object = pSHelpSectionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getUserCat() != null) {
            object = pSHelpSectionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getUserTag() != null) {
            object = pSHelpSectionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getUserTag2() != null) {
            object = pSHelpSectionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getUserTag3() != null) {
            object = pSHelpSectionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getUserTag4() != null) {
            object = pSHelpSectionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSHelpSectionBase.getValidFlag() != null) {
            object = pSHelpSectionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpSectionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpSectionBase pSHelpSectionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpSectionBase.isBottomContentDirty() && (bl || pSHelpSectionBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSHelpSectionBase.getBottomContent());
        }
        if (pSHelpSectionBase.isCodeNameDirty() && (bl || pSHelpSectionBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSHelpSectionBase.getCodeName());
        }
        if (pSHelpSectionBase.isContentDirty() && (bl || pSHelpSectionBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSHelpSectionBase.getContent());
        }
        if (pSHelpSectionBase.isContent2Dirty() && (bl || pSHelpSectionBase.getContent2() != null)) {
            iDataObject.set(FIELD_CONTENT2, (Object)pSHelpSectionBase.getContent2());
        }
        if (pSHelpSectionBase.isContentAsCodeDirty() && (bl || pSHelpSectionBase.getContentAsCode() != null)) {
            iDataObject.set(FIELD_CONTENTASCODE, (Object)pSHelpSectionBase.getContentAsCode());
        }
        if (pSHelpSectionBase.isCreateDateDirty() && (bl || pSHelpSectionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpSectionBase.getCreateDate());
        }
        if (pSHelpSectionBase.isCreateManDirty() && (bl || pSHelpSectionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpSectionBase.getCreateMan());
        }
        if (pSHelpSectionBase.isExpandModeDirty() && (bl || pSHelpSectionBase.getExpandMode() != null)) {
            iDataObject.set(FIELD_EXPANDMODE, (Object)pSHelpSectionBase.getExpandMode());
        }
        if (pSHelpSectionBase.isHeaderContentDirty() && (bl || pSHelpSectionBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSHelpSectionBase.getHeaderContent());
        }
        if (pSHelpSectionBase.isLinkPSHelpResourceIdDirty() && (bl || pSHelpSectionBase.getLinkPSHelpResourceId() != null)) {
            iDataObject.set(FIELD_LINKPSHELPRESOURCEID, (Object)pSHelpSectionBase.getLinkPSHelpResourceId());
        }
        if (pSHelpSectionBase.isLinkPSHelpResourceNameDirty() && (bl || pSHelpSectionBase.getLinkPSHelpResourceName() != null)) {
            iDataObject.set(FIELD_LINKPSHELPRESOURCENAME, (Object)pSHelpSectionBase.getLinkPSHelpResourceName());
        }
        if (pSHelpSectionBase.isMemoDirty() && (bl || pSHelpSectionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpSectionBase.getMemo());
        }
        if (pSHelpSectionBase.isOrderValueDirty() && (bl || pSHelpSectionBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSHelpSectionBase.getOrderValue());
        }
        if (pSHelpSectionBase.isOutputDirDirty() && (bl || pSHelpSectionBase.getOutputDir() != null)) {
            iDataObject.set(FIELD_OUTPUTDIR, (Object)pSHelpSectionBase.getOutputDir());
        }
        if (pSHelpSectionBase.isPPSHelpSectorIdDirty() && (bl || pSHelpSectionBase.getPPSHelpSectorId() != null)) {
            iDataObject.set(FIELD_PPSHELPSECTORID, (Object)pSHelpSectionBase.getPPSHelpSectorId());
        }
        if (pSHelpSectionBase.isPPSHelpSectorNameDirty() && (bl || pSHelpSectionBase.getPPSHelpSectorName() != null)) {
            iDataObject.set(FIELD_PPSHELPSECTORNAME, (Object)pSHelpSectionBase.getPPSHelpSectorName());
        }
        if (pSHelpSectionBase.isPSCodeListIdDirty() && (bl || pSHelpSectionBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSHelpSectionBase.getPSCodeListId());
        }
        if (pSHelpSectionBase.isPSCodeListNameDirty() && (bl || pSHelpSectionBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSHelpSectionBase.getPSCodeListName());
        }
        if (pSHelpSectionBase.isPSDEFieldIdDirty() && (bl || pSHelpSectionBase.getPSDEFieldId() != null)) {
            iDataObject.set(FIELD_PSDEFIELDID, (Object)pSHelpSectionBase.getPSDEFieldId());
        }
        if (pSHelpSectionBase.isPSDEFieldNameDirty() && (bl || pSHelpSectionBase.getPSDEFieldName() != null)) {
            iDataObject.set(FIELD_PSDEFIELDNAME, (Object)pSHelpSectionBase.getPSDEFieldName());
        }
        if (pSHelpSectionBase.isPSDEIdDirty() && (bl || pSHelpSectionBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSHelpSectionBase.getPSDEId());
        }
        if (pSHelpSectionBase.isPSDEUIActionIdDirty() && (bl || pSHelpSectionBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSHelpSectionBase.getPSDEUIActionId());
        }
        if (pSHelpSectionBase.isPSDEUIActionNameDirty() && (bl || pSHelpSectionBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSHelpSectionBase.getPSDEUIActionName());
        }
        if (pSHelpSectionBase.isPSHelpArticleIdDirty() && (bl || pSHelpSectionBase.getPSHelpArticleId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLEID, (Object)pSHelpSectionBase.getPSHelpArticleId());
        }
        if (pSHelpSectionBase.isPSHelpArticleNameDirty() && (bl || pSHelpSectionBase.getPSHelpArticleName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLENAME, (Object)pSHelpSectionBase.getPSHelpArticleName());
        }
        if (pSHelpSectionBase.isPSHelpResourceIdDirty() && (bl || pSHelpSectionBase.getPSHelpResourceId() != null)) {
            iDataObject.set(FIELD_PSHELPRESOURCEID, (Object)pSHelpSectionBase.getPSHelpResourceId());
        }
        if (pSHelpSectionBase.isPSHelpResourceNameDirty() && (bl || pSHelpSectionBase.getPSHelpResourceName() != null)) {
            iDataObject.set(FIELD_PSHELPRESOURCENAME, (Object)pSHelpSectionBase.getPSHelpResourceName());
        }
        if (pSHelpSectionBase.isPSHelpSectionIdDirty() && (bl || pSHelpSectionBase.getPSHelpSectionId() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONID, (Object)pSHelpSectionBase.getPSHelpSectionId());
        }
        if (pSHelpSectionBase.isPSHelpSectionNameDirty() && (bl || pSHelpSectionBase.getPSHelpSectionName() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONNAME, (Object)pSHelpSectionBase.getPSHelpSectionName());
        }
        if (pSHelpSectionBase.isPSHelpSectionTemplIdDirty() && (bl || pSHelpSectionBase.getPSHelpSectionTemplId() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTEMPLID, (Object)pSHelpSectionBase.getPSHelpSectionTemplId());
        }
        if (pSHelpSectionBase.isPSHelpSectionTemplNameDirty() && (bl || pSHelpSectionBase.getPSHelpSectionTemplName() != null)) {
            iDataObject.set(FIELD_PSHELPSECTIONTEMPLNAME, (Object)pSHelpSectionBase.getPSHelpSectionTemplName());
        }
        if (pSHelpSectionBase.isRefPSHelpArticleIdDirty() && (bl || pSHelpSectionBase.getRefPSHelpArticleId() != null)) {
            iDataObject.set(FIELD_REFPSHELPARTICLEID, (Object)pSHelpSectionBase.getRefPSHelpArticleId());
        }
        if (pSHelpSectionBase.isRefPSHelpArticleNameDirty() && (bl || pSHelpSectionBase.getRefPSHelpArticleName() != null)) {
            iDataObject.set(FIELD_REFPSHELPARTICLENAME, (Object)pSHelpSectionBase.getRefPSHelpArticleName());
        }
        if (pSHelpSectionBase.isSectionParamDirty() && (bl || pSHelpSectionBase.getSectionParam() != null)) {
            iDataObject.set(FIELD_SECTIONPARAM, (Object)pSHelpSectionBase.getSectionParam());
        }
        if (pSHelpSectionBase.isSectionParam2Dirty() && (bl || pSHelpSectionBase.getSectionParam2() != null)) {
            iDataObject.set(FIELD_SECTIONPARAM2, (Object)pSHelpSectionBase.getSectionParam2());
        }
        if (pSHelpSectionBase.isSectionSNDirty() && (bl || pSHelpSectionBase.getSectionSN() != null)) {
            iDataObject.set(FIELD_SECTIONSN, (Object)pSHelpSectionBase.getSectionSN());
        }
        if (pSHelpSectionBase.isSectionTypeDirty() && (bl || pSHelpSectionBase.getSectionType() != null)) {
            iDataObject.set(FIELD_SECTIONTYPE, (Object)pSHelpSectionBase.getSectionType());
        }
        if (pSHelpSectionBase.isUpdateDateDirty() && (bl || pSHelpSectionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpSectionBase.getUpdateDate());
        }
        if (pSHelpSectionBase.isUpdateManDirty() && (bl || pSHelpSectionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpSectionBase.getUpdateMan());
        }
        if (pSHelpSectionBase.isUserCatDirty() && (bl || pSHelpSectionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSHelpSectionBase.getUserCat());
        }
        if (pSHelpSectionBase.isUserTagDirty() && (bl || pSHelpSectionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSHelpSectionBase.getUserTag());
        }
        if (pSHelpSectionBase.isUserTag2Dirty() && (bl || pSHelpSectionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSHelpSectionBase.getUserTag2());
        }
        if (pSHelpSectionBase.isUserTag3Dirty() && (bl || pSHelpSectionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSHelpSectionBase.getUserTag3());
        }
        if (pSHelpSectionBase.isUserTag4Dirty() && (bl || pSHelpSectionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSHelpSectionBase.getUserTag4());
        }
        if (pSHelpSectionBase.isValidFlagDirty() && (bl || pSHelpSectionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpSectionBase.getValidFlag());
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
        return PSHelpSectionBase.remove(this, n);
    }

    private static boolean remove(PSHelpSectionBase pSHelpSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpSectionBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSHelpSectionBase.resetCodeName();
                return true;
            }
            case 2: {
                pSHelpSectionBase.resetContent();
                return true;
            }
            case 3: {
                pSHelpSectionBase.resetContent2();
                return true;
            }
            case 4: {
                pSHelpSectionBase.resetContentAsCode();
                return true;
            }
            case 5: {
                pSHelpSectionBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSHelpSectionBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSHelpSectionBase.resetExpandMode();
                return true;
            }
            case 8: {
                pSHelpSectionBase.resetHeaderContent();
                return true;
            }
            case 9: {
                pSHelpSectionBase.resetLinkPSHelpResourceId();
                return true;
            }
            case 10: {
                pSHelpSectionBase.resetLinkPSHelpResourceName();
                return true;
            }
            case 11: {
                pSHelpSectionBase.resetMemo();
                return true;
            }
            case 12: {
                pSHelpSectionBase.resetOrderValue();
                return true;
            }
            case 13: {
                pSHelpSectionBase.resetOutputDir();
                return true;
            }
            case 14: {
                pSHelpSectionBase.resetPPSHelpSectorId();
                return true;
            }
            case 15: {
                pSHelpSectionBase.resetPPSHelpSectorName();
                return true;
            }
            case 16: {
                pSHelpSectionBase.resetPSCodeListId();
                return true;
            }
            case 17: {
                pSHelpSectionBase.resetPSCodeListName();
                return true;
            }
            case 18: {
                pSHelpSectionBase.resetPSDEFieldId();
                return true;
            }
            case 19: {
                pSHelpSectionBase.resetPSDEFieldName();
                return true;
            }
            case 20: {
                pSHelpSectionBase.resetPSDEId();
                return true;
            }
            case 21: {
                pSHelpSectionBase.resetPSDEUIActionId();
                return true;
            }
            case 22: {
                pSHelpSectionBase.resetPSDEUIActionName();
                return true;
            }
            case 23: {
                pSHelpSectionBase.resetPSHelpArticleId();
                return true;
            }
            case 24: {
                pSHelpSectionBase.resetPSHelpArticleName();
                return true;
            }
            case 25: {
                pSHelpSectionBase.resetPSHelpResourceId();
                return true;
            }
            case 26: {
                pSHelpSectionBase.resetPSHelpResourceName();
                return true;
            }
            case 27: {
                pSHelpSectionBase.resetPSHelpSectionId();
                return true;
            }
            case 28: {
                pSHelpSectionBase.resetPSHelpSectionName();
                return true;
            }
            case 29: {
                pSHelpSectionBase.resetPSHelpSectionTemplId();
                return true;
            }
            case 30: {
                pSHelpSectionBase.resetPSHelpSectionTemplName();
                return true;
            }
            case 31: {
                pSHelpSectionBase.resetRefPSHelpArticleId();
                return true;
            }
            case 32: {
                pSHelpSectionBase.resetRefPSHelpArticleName();
                return true;
            }
            case 33: {
                pSHelpSectionBase.resetSectionParam();
                return true;
            }
            case 34: {
                pSHelpSectionBase.resetSectionParam2();
                return true;
            }
            case 35: {
                pSHelpSectionBase.resetSectionSN();
                return true;
            }
            case 36: {
                pSHelpSectionBase.resetSectionType();
                return true;
            }
            case 37: {
                pSHelpSectionBase.resetUpdateDate();
                return true;
            }
            case 38: {
                pSHelpSectionBase.resetUpdateMan();
                return true;
            }
            case 39: {
                pSHelpSectionBase.resetUserCat();
                return true;
            }
            case 40: {
                pSHelpSectionBase.resetUserTag();
                return true;
            }
            case 41: {
                pSHelpSectionBase.resetUserTag2();
                return true;
            }
            case 42: {
                pSHelpSectionBase.resetUserTag3();
                return true;
            }
            case 43: {
                pSHelpSectionBase.resetUserTag4();
                return true;
            }
            case 44: {
                pSHelpSectionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEField() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEField();
        }
        if (this.getPSDEFieldId() == null) {
            return null;
        }
        Integer n = this.objPSDEFieldLock;
        synchronized (n) {
            if (this.psdefield != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFieldId(), (Object)this.psdefield.getPSDEFieldId()) != 0L) {
                this.psdefield = null;
            }
            if (this.psdefield == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFieldId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdefield = pSDEField;
            }
            return this.psdefield;
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
    public PSHelpArticle getPSHelpArticle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticle();
        }
        if (this.getPSHelpArticleId() == null) {
            return null;
        }
        Integer n = this.objPSHelpArticleLock;
        synchronized (n) {
            if (this.pshelparticle != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpArticleId(), (Object)this.pshelparticle.getPSHelpArticleId()) != 0L) {
                this.pshelparticle = null;
            }
            if (this.pshelparticle == null) {
                PSHelpArticle pSHelpArticle = new PSHelpArticle();
                pSHelpArticle.setPSHelpArticleId(this.getPSHelpArticleId());
                PSHelpArticleService pSHelpArticleService = (PSHelpArticleService)ServiceGlobal.getService(PSHelpArticleService.class, (SessionFactory)this.getSessionFactory());
                pSHelpArticleService.autoGet((IEntity)pSHelpArticle);
                this.pshelparticle = pSHelpArticle;
            }
            return this.pshelparticle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpArticle getRefPSHelpArticle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSHelpArticle();
        }
        if (this.getRefPSHelpArticleId() == null) {
            return null;
        }
        Integer n = this.objRefPSHelpArticleLock;
        synchronized (n) {
            if (this.refpshelparticle != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSHelpArticleId(), (Object)this.refpshelparticle.getPSHelpArticleId()) != 0L) {
                this.refpshelparticle = null;
            }
            if (this.refpshelparticle == null) {
                PSHelpArticle pSHelpArticle = new PSHelpArticle();
                pSHelpArticle.setPSHelpArticleId(this.getRefPSHelpArticleId());
                PSHelpArticleService pSHelpArticleService = (PSHelpArticleService)ServiceGlobal.getService(PSHelpArticleService.class, (SessionFactory)this.getSessionFactory());
                pSHelpArticleService.autoGet((IEntity)pSHelpArticle);
                this.refpshelparticle = pSHelpArticle;
            }
            return this.refpshelparticle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpResource getLinkPSHelpResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSHelpResource();
        }
        if (this.getLinkPSHelpResourceId() == null) {
            return null;
        }
        Integer n = this.objLinkPSHelpResourceLock;
        synchronized (n) {
            if (this.linkpshelpresource != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSHelpResourceId(), (Object)this.linkpshelpresource.getPSHelpResourceId()) != 0L) {
                this.linkpshelpresource = null;
            }
            if (this.linkpshelpresource == null) {
                PSHelpResource pSHelpResource = new PSHelpResource();
                pSHelpResource.setPSHelpResourceId(this.getLinkPSHelpResourceId());
                PSHelpResourceService pSHelpResourceService = (PSHelpResourceService)ServiceGlobal.getService(PSHelpResourceService.class, (SessionFactory)this.getSessionFactory());
                pSHelpResourceService.autoGet((IEntity)pSHelpResource);
                this.linkpshelpresource = pSHelpResource;
            }
            return this.linkpshelpresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpResource getPSHelpResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpResource();
        }
        if (this.getPSHelpResourceId() == null) {
            return null;
        }
        Integer n = this.objPSHelpResourceLock;
        synchronized (n) {
            if (this.pshelpresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpResourceId(), (Object)this.pshelpresource.getPSHelpResourceId()) != 0L) {
                this.pshelpresource = null;
            }
            if (this.pshelpresource == null) {
                PSHelpResource pSHelpResource = new PSHelpResource();
                pSHelpResource.setPSHelpResourceId(this.getPSHelpResourceId());
                PSHelpResourceService pSHelpResourceService = (PSHelpResourceService)ServiceGlobal.getService(PSHelpResourceService.class, (SessionFactory)this.getSessionFactory());
                pSHelpResourceService.autoGet((IEntity)pSHelpResource);
                this.pshelpresource = pSHelpResource;
            }
            return this.pshelpresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpSectionTempl getPSHelpSectionTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSectionTempl();
        }
        if (this.getPSHelpSectionTemplId() == null) {
            return null;
        }
        Integer n = this.objPSHelpSectionTemplLock;
        synchronized (n) {
            if (this.pshelpsectiontempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpSectionTemplId(), (Object)this.pshelpsectiontempl.getPSHelpSectionTemplId()) != 0L) {
                this.pshelpsectiontempl = null;
            }
            if (this.pshelpsectiontempl == null) {
                PSHelpSectionTempl pSHelpSectionTempl = new PSHelpSectionTempl();
                pSHelpSectionTempl.setPSHelpSectionTemplId(this.getPSHelpSectionTemplId());
                PSHelpSectionTemplService pSHelpSectionTemplService = (PSHelpSectionTemplService)ServiceGlobal.getService(PSHelpSectionTemplService.class, (SessionFactory)this.getSessionFactory());
                pSHelpSectionTemplService.autoGet((IEntity)pSHelpSectionTempl);
                this.pshelpsectiontempl = pSHelpSectionTempl;
            }
            return this.pshelpsectiontempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpSection getPPSHelpSector() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSHelpSector();
        }
        if (this.getPPSHelpSectorId() == null) {
            return null;
        }
        Integer n = this.objPPSHelpSectorLock;
        synchronized (n) {
            if (this.ppshelpsector != null && DataTypeHelper.compare((int)25, (Object)this.getPPSHelpSectorId(), (Object)this.ppshelpsector.getPSHelpSectionId()) != 0L) {
                this.ppshelpsector = null;
            }
            if (this.ppshelpsector == null) {
                PSHelpSection pSHelpSection = new PSHelpSection();
                pSHelpSection.setPSHelpSectionId(this.getPPSHelpSectorId());
                PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
                pSHelpSectionService.autoGet((IEntity)pSHelpSection);
                this.ppshelpsector = pSHelpSection;
            }
            return this.ppshelpsector;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSHelpSection> getPSHelpSections() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpSections();
        }
        if (this.getPSHelpSectionId() == null) {
            return null;
        }
        PSHelpSectionService pSHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSHelpSectionsLock;
        synchronized (n) {
            if (this.pshelpsections == null) {
                this.pshelpsections = pSHelpSectionService.selectByPPSHelpSector(this);
            }
            return this.pshelpsections;
        }
    }

    private PSHelpSectionBase getProxyEntity() {
        return this.proxyPSHelpSectionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpSectionBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpSectionBase) {
            this.proxyPSHelpSectionBase = (PSHelpSectionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CONTENT, 2);
        fieldIndexMap.put(FIELD_CONTENT2, 3);
        fieldIndexMap.put(FIELD_CONTENTASCODE, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_EXPANDMODE, 7);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 8);
        fieldIndexMap.put(FIELD_LINKPSHELPRESOURCEID, 9);
        fieldIndexMap.put(FIELD_LINKPSHELPRESOURCENAME, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_ORDERVALUE, 12);
        fieldIndexMap.put(FIELD_OUTPUTDIR, 13);
        fieldIndexMap.put(FIELD_PPSHELPSECTORID, 14);
        fieldIndexMap.put(FIELD_PPSHELPSECTORNAME, 15);
        fieldIndexMap.put(FIELD_PSCODELISTID, 16);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 17);
        fieldIndexMap.put(FIELD_PSDEFIELDID, 18);
        fieldIndexMap.put(FIELD_PSDEFIELDNAME, 19);
        fieldIndexMap.put(FIELD_PSDEID, 20);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 21);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 22);
        fieldIndexMap.put(FIELD_PSHELPARTICLEID, 23);
        fieldIndexMap.put(FIELD_PSHELPARTICLENAME, 24);
        fieldIndexMap.put(FIELD_PSHELPRESOURCEID, 25);
        fieldIndexMap.put(FIELD_PSHELPRESOURCENAME, 26);
        fieldIndexMap.put(FIELD_PSHELPSECTIONID, 27);
        fieldIndexMap.put(FIELD_PSHELPSECTIONNAME, 28);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTEMPLID, 29);
        fieldIndexMap.put(FIELD_PSHELPSECTIONTEMPLNAME, 30);
        fieldIndexMap.put(FIELD_REFPSHELPARTICLEID, 31);
        fieldIndexMap.put(FIELD_REFPSHELPARTICLENAME, 32);
        fieldIndexMap.put(FIELD_SECTIONPARAM, 33);
        fieldIndexMap.put(FIELD_SECTIONPARAM2, 34);
        fieldIndexMap.put(FIELD_SECTIONSN, 35);
        fieldIndexMap.put(FIELD_SECTIONTYPE, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_USERCAT, 39);
        fieldIndexMap.put(FIELD_USERTAG, 40);
        fieldIndexMap.put(FIELD_USERTAG2, 41);
        fieldIndexMap.put(FIELD_USERTAG3, 42);
        fieldIndexMap.put(FIELD_USERTAG4, 43);
        fieldIndexMap.put(FIELD_VALIDFLAG, 44);
    }
}

