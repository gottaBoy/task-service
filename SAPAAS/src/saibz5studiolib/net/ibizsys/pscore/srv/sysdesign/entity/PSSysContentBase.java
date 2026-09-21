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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContentCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysContentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysContentBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTPATH = "CONTENTPATH";
    public static final String FIELD_CONTENTTAG = "CONTENTTAG";
    public static final String FIELD_CONTENTTAG2 = "CONTENTTAG2";
    public static final String FIELD_CONTENTTAG3 = "CONTENTTAG3";
    public static final String FIELD_CONTENTTAG4 = "CONTENTTAG4";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCONTENTCATID = "PSSYSCONTENTCATID";
    public static final String FIELD_PSSYSCONTENTCATNAME = "PSSYSCONTENTCATNAME";
    public static final String FIELD_PSSYSCONTENTID = "PSSYSCONTENTID";
    public static final String FIELD_PSSYSCONTENTNAME = "PSSYSCONTENTNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTENTPATH = 1;
    private static final int INDEX_CONTENTTAG = 2;
    private static final int INDEX_CONTENTTAG2 = 3;
    private static final int INDEX_CONTENTTAG3 = 4;
    private static final int INDEX_CONTENTTAG4 = 5;
    private static final int INDEX_CONTENTTYPE = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_HTMLCONTENT = 9;
    private static final int INDEX_LOCKFLAG = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_ORDERVALUE = 12;
    private static final int INDEX_PSMODULEID = 13;
    private static final int INDEX_PSMODULENAME = 14;
    private static final int INDEX_PSSYSCONTENTCATID = 15;
    private static final int INDEX_PSSYSCONTENTCATNAME = 16;
    private static final int INDEX_PSSYSCONTENTID = 17;
    private static final int INDEX_PSSYSCONTENTNAME = 18;
    private static final int INDEX_PSSYSDYNAMODELID = 19;
    private static final int INDEX_PSSYSDYNAMODELNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_RAWCONTENT = 23;
    private static final int INDEX_SUBJECT = 24;
    private static final int INDEX_TAGS = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_VALIDFLAG = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysContentBase proxyPSSysContentBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean contentpathDirtyFlag = false;
    private boolean contenttagDirtyFlag = false;
    private boolean contenttag2DirtyFlag = false;
    private boolean contenttag3DirtyFlag = false;
    private boolean contenttag4DirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscontentcatidDirtyFlag = false;
    private boolean pssyscontentcatnameDirtyFlag = false;
    private boolean pssyscontentidDirtyFlag = false;
    private boolean pssyscontentnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="contentpath")
    private String contentpath;
    @Column(name="contenttag")
    private String contenttag;
    @Column(name="contenttag2")
    private String contenttag2;
    @Column(name="contenttag3")
    private String contenttag3;
    @Column(name="contenttag4")
    private String contenttag4;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="htmlcontent")
    private String htmlcontent;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscontentcatid")
    private String pssyscontentcatid;
    @Column(name="pssyscontentcatname")
    private String pssyscontentcatname;
    @Column(name="pssyscontentid")
    private String pssyscontentid;
    @Column(name="pssyscontentname")
    private String pssyscontentname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="subject")
    private String subject;
    @Column(name="tags")
    private String tags;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysContentCatLock = new Integer(1);
    private PSSysContentCat pssyscontentcat = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setContentPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpath = string;
        this.contentpathDirtyFlag = true;
    }

    public String getContentPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPath();
        }
        return this.contentpath;
    }

    public boolean isContentPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPathDirty();
        }
        return this.contentpathDirtyFlag;
    }

    public void resetContentPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPath();
            return;
        }
        this.contentpathDirtyFlag = false;
        this.contentpath = null;
    }

    public void setContentTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttag = string;
        this.contenttagDirtyFlag = true;
    }

    public String getContentTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTag();
        }
        return this.contenttag;
    }

    public boolean isContentTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTagDirty();
        }
        return this.contenttagDirtyFlag;
    }

    public void resetContentTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTag();
            return;
        }
        this.contenttagDirtyFlag = false;
        this.contenttag = null;
    }

    public void setContentTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttag2 = string;
        this.contenttag2DirtyFlag = true;
    }

    public String getContentTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTag2();
        }
        return this.contenttag2;
    }

    public boolean isContentTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTag2Dirty();
        }
        return this.contenttag2DirtyFlag;
    }

    public void resetContentTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTag2();
            return;
        }
        this.contenttag2DirtyFlag = false;
        this.contenttag2 = null;
    }

    public void setContentTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttag3 = string;
        this.contenttag3DirtyFlag = true;
    }

    public String getContentTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTag3();
        }
        return this.contenttag3;
    }

    public boolean isContentTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTag3Dirty();
        }
        return this.contenttag3DirtyFlag;
    }

    public void resetContentTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTag3();
            return;
        }
        this.contenttag3DirtyFlag = false;
        this.contenttag3 = null;
    }

    public void setContentTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttag4 = string;
        this.contenttag4DirtyFlag = true;
    }

    public String getContentTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentTag4();
        }
        return this.contenttag4;
    }

    public boolean isContentTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTag4Dirty();
        }
        return this.contenttag4DirtyFlag;
    }

    public void resetContentTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentTag4();
            return;
        }
        this.contenttag4DirtyFlag = false;
        this.contenttag4 = null;
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

    public void setHtmlContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlcontent = string;
        this.htmlcontentDirtyFlag = true;
    }

    public String getHtmlContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlContent();
        }
        return this.htmlcontent;
    }

    public boolean isHtmlContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlContentDirty();
        }
        return this.htmlcontentDirtyFlag;
    }

    public void resetHtmlContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlContent();
            return;
        }
        this.htmlcontentDirtyFlag = false;
        this.htmlcontent = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPSSysContentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysContentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscontentid = string;
        this.pssyscontentidDirtyFlag = true;
    }

    public String getPSSysContentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentId();
        }
        return this.pssyscontentid;
    }

    public boolean isPSSysContentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysContentIdDirty();
        }
        return this.pssyscontentidDirtyFlag;
    }

    public void resetPSSysContentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysContentId();
            return;
        }
        this.pssyscontentidDirtyFlag = false;
        this.pssyscontentid = null;
    }

    public void setPSSysContentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysContentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscontentname = string;
        this.pssyscontentnameDirtyFlag = true;
    }

    public String getPSSysContentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentName();
        }
        return this.pssyscontentname;
    }

    public boolean isPSSysContentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysContentNameDirty();
        }
        return this.pssyscontentnameDirtyFlag;
    }

    public void resetPSSysContentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysContentName();
            return;
        }
        this.pssyscontentnameDirtyFlag = false;
        this.pssyscontentname = null;
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

    public void setRawContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcontent = string;
        this.rawcontentDirtyFlag = true;
    }

    public String getRawContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawContent();
        }
        return this.rawcontent;
    }

    public boolean isRawContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawContentDirty();
        }
        return this.rawcontentDirtyFlag;
    }

    public void resetRawContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawContent();
            return;
        }
        this.rawcontentDirtyFlag = false;
        this.rawcontent = null;
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
        PSSysContentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysContentBase pSSysContentBase) {
        pSSysContentBase.resetCodeName();
        pSSysContentBase.resetContentPath();
        pSSysContentBase.resetContentTag();
        pSSysContentBase.resetContentTag2();
        pSSysContentBase.resetContentTag3();
        pSSysContentBase.resetContentTag4();
        pSSysContentBase.resetContentType();
        pSSysContentBase.resetCreateDate();
        pSSysContentBase.resetCreateMan();
        pSSysContentBase.resetHtmlContent();
        pSSysContentBase.resetLockFlag();
        pSSysContentBase.resetMemo();
        pSSysContentBase.resetOrderValue();
        pSSysContentBase.resetPSModuleId();
        pSSysContentBase.resetPSModuleName();
        pSSysContentBase.resetPSSysContentCatId();
        pSSysContentBase.resetPSSysContentCatName();
        pSSysContentBase.resetPSSysContentId();
        pSSysContentBase.resetPSSysContentName();
        pSSysContentBase.resetPSSysDynaModelId();
        pSSysContentBase.resetPSSysDynaModelName();
        pSSysContentBase.resetPSSystemId();
        pSSysContentBase.resetPSSystemName();
        pSSysContentBase.resetRawContent();
        pSSysContentBase.resetSubject();
        pSSysContentBase.resetTags();
        pSSysContentBase.resetUpdateDate();
        pSSysContentBase.resetUpdateMan();
        pSSysContentBase.resetUserCat();
        pSSysContentBase.resetUserTag();
        pSSysContentBase.resetUserTag2();
        pSSysContentBase.resetUserTag3();
        pSSysContentBase.resetUserTag4();
        pSSysContentBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentPathDirty()) {
            hashMap.put(FIELD_CONTENTPATH, this.getContentPath());
        }
        if (!bl || this.isContentTagDirty()) {
            hashMap.put(FIELD_CONTENTTAG, this.getContentTag());
        }
        if (!bl || this.isContentTag2Dirty()) {
            hashMap.put(FIELD_CONTENTTAG2, this.getContentTag2());
        }
        if (!bl || this.isContentTag3Dirty()) {
            hashMap.put(FIELD_CONTENTTAG3, this.getContentTag3());
        }
        if (!bl || this.isContentTag4Dirty()) {
            hashMap.put(FIELD_CONTENTTAG4, this.getContentTag4());
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
        if (!bl || this.isHtmlContentDirty()) {
            hashMap.put(FIELD_HTMLCONTENT, this.getHtmlContent());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
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
        if (!bl || this.isPSSysContentIdDirty()) {
            hashMap.put(FIELD_PSSYSCONTENTID, this.getPSSysContentId());
        }
        if (!bl || this.isPSSysContentNameDirty()) {
            hashMap.put(FIELD_PSSYSCONTENTNAME, this.getPSSysContentName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isSubjectDirty()) {
            hashMap.put(FIELD_SUBJECT, this.getSubject());
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
        return PSSysContentBase.get(this, n);
    }

    private static Object get(PSSysContentBase pSSysContentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysContentBase.getCodeName();
            }
            case 1: {
                return pSSysContentBase.getContentPath();
            }
            case 2: {
                return pSSysContentBase.getContentTag();
            }
            case 3: {
                return pSSysContentBase.getContentTag2();
            }
            case 4: {
                return pSSysContentBase.getContentTag3();
            }
            case 5: {
                return pSSysContentBase.getContentTag4();
            }
            case 6: {
                return pSSysContentBase.getContentType();
            }
            case 7: {
                return pSSysContentBase.getCreateDate();
            }
            case 8: {
                return pSSysContentBase.getCreateMan();
            }
            case 9: {
                return pSSysContentBase.getHtmlContent();
            }
            case 10: {
                return pSSysContentBase.getLockFlag();
            }
            case 11: {
                return pSSysContentBase.getMemo();
            }
            case 12: {
                return pSSysContentBase.getOrderValue();
            }
            case 13: {
                return pSSysContentBase.getPSModuleId();
            }
            case 14: {
                return pSSysContentBase.getPSModuleName();
            }
            case 15: {
                return pSSysContentBase.getPSSysContentCatId();
            }
            case 16: {
                return pSSysContentBase.getPSSysContentCatName();
            }
            case 17: {
                return pSSysContentBase.getPSSysContentId();
            }
            case 18: {
                return pSSysContentBase.getPSSysContentName();
            }
            case 19: {
                return pSSysContentBase.getPSSysDynaModelId();
            }
            case 20: {
                return pSSysContentBase.getPSSysDynaModelName();
            }
            case 21: {
                return pSSysContentBase.getPSSystemId();
            }
            case 22: {
                return pSSysContentBase.getPSSystemName();
            }
            case 23: {
                return pSSysContentBase.getRawContent();
            }
            case 24: {
                return pSSysContentBase.getSubject();
            }
            case 25: {
                return pSSysContentBase.getTags();
            }
            case 26: {
                return pSSysContentBase.getUpdateDate();
            }
            case 27: {
                return pSSysContentBase.getUpdateMan();
            }
            case 28: {
                return pSSysContentBase.getUserCat();
            }
            case 29: {
                return pSSysContentBase.getUserTag();
            }
            case 30: {
                return pSSysContentBase.getUserTag2();
            }
            case 31: {
                return pSSysContentBase.getUserTag3();
            }
            case 32: {
                return pSSysContentBase.getUserTag4();
            }
            case 33: {
                return pSSysContentBase.getValidFlag();
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
        PSSysContentBase.set(this, n, object);
    }

    private static void set(PSSysContentBase pSSysContentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysContentBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysContentBase.setContentPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysContentBase.setContentTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysContentBase.setContentTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysContentBase.setContentTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysContentBase.setContentTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysContentBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysContentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysContentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysContentBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysContentBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysContentBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysContentBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysContentBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysContentBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysContentBase.setPSSysContentCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysContentBase.setPSSysContentCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysContentBase.setPSSysContentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysContentBase.setPSSysContentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysContentBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysContentBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysContentBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysContentBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysContentBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysContentBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysContentBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysContentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSSysContentBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysContentBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysContentBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysContentBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysContentBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysContentBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysContentBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysContentBase.isNull(this, n);
    }

    private static boolean isNull(PSSysContentBase pSSysContentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysContentBase.getCodeName() == null;
            }
            case 1: {
                return pSSysContentBase.getContentPath() == null;
            }
            case 2: {
                return pSSysContentBase.getContentTag() == null;
            }
            case 3: {
                return pSSysContentBase.getContentTag2() == null;
            }
            case 4: {
                return pSSysContentBase.getContentTag3() == null;
            }
            case 5: {
                return pSSysContentBase.getContentTag4() == null;
            }
            case 6: {
                return pSSysContentBase.getContentType() == null;
            }
            case 7: {
                return pSSysContentBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysContentBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysContentBase.getHtmlContent() == null;
            }
            case 10: {
                return pSSysContentBase.getLockFlag() == null;
            }
            case 11: {
                return pSSysContentBase.getMemo() == null;
            }
            case 12: {
                return pSSysContentBase.getOrderValue() == null;
            }
            case 13: {
                return pSSysContentBase.getPSModuleId() == null;
            }
            case 14: {
                return pSSysContentBase.getPSModuleName() == null;
            }
            case 15: {
                return pSSysContentBase.getPSSysContentCatId() == null;
            }
            case 16: {
                return pSSysContentBase.getPSSysContentCatName() == null;
            }
            case 17: {
                return pSSysContentBase.getPSSysContentId() == null;
            }
            case 18: {
                return pSSysContentBase.getPSSysContentName() == null;
            }
            case 19: {
                return pSSysContentBase.getPSSysDynaModelId() == null;
            }
            case 20: {
                return pSSysContentBase.getPSSysDynaModelName() == null;
            }
            case 21: {
                return pSSysContentBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysContentBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysContentBase.getRawContent() == null;
            }
            case 24: {
                return pSSysContentBase.getSubject() == null;
            }
            case 25: {
                return pSSysContentBase.getTags() == null;
            }
            case 26: {
                return pSSysContentBase.getUpdateDate() == null;
            }
            case 27: {
                return pSSysContentBase.getUpdateMan() == null;
            }
            case 28: {
                return pSSysContentBase.getUserCat() == null;
            }
            case 29: {
                return pSSysContentBase.getUserTag() == null;
            }
            case 30: {
                return pSSysContentBase.getUserTag2() == null;
            }
            case 31: {
                return pSSysContentBase.getUserTag3() == null;
            }
            case 32: {
                return pSSysContentBase.getUserTag4() == null;
            }
            case 33: {
                return pSSysContentBase.getValidFlag() == null;
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
        return PSSysContentBase.contains(this, n);
    }

    private static boolean contains(PSSysContentBase pSSysContentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysContentBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysContentBase.isContentPathDirty();
            }
            case 2: {
                return pSSysContentBase.isContentTagDirty();
            }
            case 3: {
                return pSSysContentBase.isContentTag2Dirty();
            }
            case 4: {
                return pSSysContentBase.isContentTag3Dirty();
            }
            case 5: {
                return pSSysContentBase.isContentTag4Dirty();
            }
            case 6: {
                return pSSysContentBase.isContentTypeDirty();
            }
            case 7: {
                return pSSysContentBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysContentBase.isCreateManDirty();
            }
            case 9: {
                return pSSysContentBase.isHtmlContentDirty();
            }
            case 10: {
                return pSSysContentBase.isLockFlagDirty();
            }
            case 11: {
                return pSSysContentBase.isMemoDirty();
            }
            case 12: {
                return pSSysContentBase.isOrderValueDirty();
            }
            case 13: {
                return pSSysContentBase.isPSModuleIdDirty();
            }
            case 14: {
                return pSSysContentBase.isPSModuleNameDirty();
            }
            case 15: {
                return pSSysContentBase.isPSSysContentCatIdDirty();
            }
            case 16: {
                return pSSysContentBase.isPSSysContentCatNameDirty();
            }
            case 17: {
                return pSSysContentBase.isPSSysContentIdDirty();
            }
            case 18: {
                return pSSysContentBase.isPSSysContentNameDirty();
            }
            case 19: {
                return pSSysContentBase.isPSSysDynaModelIdDirty();
            }
            case 20: {
                return pSSysContentBase.isPSSysDynaModelNameDirty();
            }
            case 21: {
                return pSSysContentBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysContentBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysContentBase.isRawContentDirty();
            }
            case 24: {
                return pSSysContentBase.isSubjectDirty();
            }
            case 25: {
                return pSSysContentBase.isTagsDirty();
            }
            case 26: {
                return pSSysContentBase.isUpdateDateDirty();
            }
            case 27: {
                return pSSysContentBase.isUpdateManDirty();
            }
            case 28: {
                return pSSysContentBase.isUserCatDirty();
            }
            case 29: {
                return pSSysContentBase.isUserTagDirty();
            }
            case 30: {
                return pSSysContentBase.isUserTag2Dirty();
            }
            case 31: {
                return pSSysContentBase.isUserTag3Dirty();
            }
            case 32: {
                return pSSysContentBase.isUserTag4Dirty();
            }
            case 33: {
                return pSSysContentBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysContentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysContentBase pSSysContentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysContentBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysContentBase.getContentPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpath", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getContentPath()), (boolean)false);
        }
        if (bl || pSSysContentBase.getContentTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttag", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getContentTag()), (boolean)false);
        }
        if (bl || pSSysContentBase.getContentTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttag2", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getContentTag2()), (boolean)false);
        }
        if (bl || pSSysContentBase.getContentTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttag3", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getContentTag3()), (boolean)false);
        }
        if (bl || pSSysContentBase.getContentTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttag4", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getContentTag4()), (boolean)false);
        }
        if (bl || pSSysContentBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getContentType()), (boolean)false);
        }
        if (bl || pSSysContentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysContentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysContentBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSSysContentBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysContentBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysContentBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSysContentCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentcatid", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSysContentCatId()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSysContentCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentcatname", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSysContentCatName()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSysContentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentid", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSysContentId()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSysContentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentname", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSysContentName()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysContentBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysContentBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getRawContent()), (boolean)false);
        }
        if (bl || pSSysContentBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysContentBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getTags()), (boolean)false);
        }
        if (bl || pSSysContentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysContentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysContentBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysContentBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysContentBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysContentBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysContentBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysContentBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysContentBase.getJSONValue((Object)pSSysContentBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysContentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysContentBase pSSysContentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysContentBase.getCodeName() != null) {
            object = pSSysContentBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentBase.getContentPath() != null) {
            object = pSSysContentBase.getContentPath();
            xmlNode.setAttribute(FIELD_CONTENTPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentBase.getContentTag() != null) {
            object = pSSysContentBase.getContentTag();
            xmlNode.setAttribute(FIELD_CONTENTTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentBase.getContentTag2() != null) {
            object = pSSysContentBase.getContentTag2();
            xmlNode.setAttribute(FIELD_CONTENTTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentBase.getContentTag3() != null) {
            object = pSSysContentBase.getContentTag3();
            xmlNode.setAttribute(FIELD_CONTENTTAG3, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentBase.getContentTag4() != null) {
            object = pSSysContentBase.getContentTag4();
            xmlNode.setAttribute(FIELD_CONTENTTAG4, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentBase.getContentType() != null) {
            object = pSSysContentBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getCreateDate() != null) {
            object = pSSysContentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysContentBase.getCreateMan() != null) {
            object = pSSysContentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getHtmlContent() != null) {
            object = pSSysContentBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getLockFlag() != null) {
            object = pSSysContentBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysContentBase.getMemo() != null) {
            object = pSSysContentBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getOrderValue() != null) {
            object = pSSysContentBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysContentBase.getPSModuleId() != null) {
            object = pSSysContentBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSModuleName() != null) {
            object = pSSysContentBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSysContentCatId() != null) {
            object = pSSysContentBase.getPSSysContentCatId();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSysContentCatName() != null) {
            object = pSSysContentBase.getPSSysContentCatName();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSysContentId() != null) {
            object = pSSysContentBase.getPSSysContentId();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSysContentName() != null) {
            object = pSSysContentBase.getPSSysContentName();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSysDynaModelId() != null) {
            object = pSSysContentBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSysDynaModelName() != null) {
            object = pSSysContentBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSystemId() != null) {
            object = pSSysContentBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getPSSystemName() != null) {
            object = pSSysContentBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getRawContent() != null) {
            object = pSSysContentBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getSubject() != null) {
            object = pSSysContentBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getTags() != null) {
            object = pSSysContentBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getUpdateDate() != null) {
            object = pSSysContentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysContentBase.getUpdateMan() != null) {
            object = pSSysContentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getUserCat() != null) {
            object = pSSysContentBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getUserTag() != null) {
            object = pSSysContentBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getUserTag2() != null) {
            object = pSSysContentBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getUserTag3() != null) {
            object = pSSysContentBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getUserTag4() != null) {
            object = pSSysContentBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentBase.getValidFlag() != null) {
            object = pSSysContentBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysContentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysContentBase pSSysContentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysContentBase.isCodeNameDirty() && (bl || pSSysContentBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysContentBase.getCodeName());
        }
        if (pSSysContentBase.isContentPathDirty() && (bl || pSSysContentBase.getContentPath() != null)) {
            iDataObject.set(FIELD_CONTENTPATH, (Object)pSSysContentBase.getContentPath());
        }
        if (pSSysContentBase.isContentTagDirty() && (bl || pSSysContentBase.getContentTag() != null)) {
            iDataObject.set(FIELD_CONTENTTAG, (Object)pSSysContentBase.getContentTag());
        }
        if (pSSysContentBase.isContentTag2Dirty() && (bl || pSSysContentBase.getContentTag2() != null)) {
            iDataObject.set(FIELD_CONTENTTAG2, (Object)pSSysContentBase.getContentTag2());
        }
        if (pSSysContentBase.isContentTag3Dirty() && (bl || pSSysContentBase.getContentTag3() != null)) {
            iDataObject.set(FIELD_CONTENTTAG3, (Object)pSSysContentBase.getContentTag3());
        }
        if (pSSysContentBase.isContentTag4Dirty() && (bl || pSSysContentBase.getContentTag4() != null)) {
            iDataObject.set(FIELD_CONTENTTAG4, (Object)pSSysContentBase.getContentTag4());
        }
        if (pSSysContentBase.isContentTypeDirty() && (bl || pSSysContentBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSSysContentBase.getContentType());
        }
        if (pSSysContentBase.isCreateDateDirty() && (bl || pSSysContentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysContentBase.getCreateDate());
        }
        if (pSSysContentBase.isCreateManDirty() && (bl || pSSysContentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysContentBase.getCreateMan());
        }
        if (pSSysContentBase.isHtmlContentDirty() && (bl || pSSysContentBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSSysContentBase.getHtmlContent());
        }
        if (pSSysContentBase.isLockFlagDirty() && (bl || pSSysContentBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysContentBase.getLockFlag());
        }
        if (pSSysContentBase.isMemoDirty() && (bl || pSSysContentBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysContentBase.getMemo());
        }
        if (pSSysContentBase.isOrderValueDirty() && (bl || pSSysContentBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysContentBase.getOrderValue());
        }
        if (pSSysContentBase.isPSModuleIdDirty() && (bl || pSSysContentBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysContentBase.getPSModuleId());
        }
        if (pSSysContentBase.isPSModuleNameDirty() && (bl || pSSysContentBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysContentBase.getPSModuleName());
        }
        if (pSSysContentBase.isPSSysContentCatIdDirty() && (bl || pSSysContentBase.getPSSysContentCatId() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTCATID, (Object)pSSysContentBase.getPSSysContentCatId());
        }
        if (pSSysContentBase.isPSSysContentCatNameDirty() && (bl || pSSysContentBase.getPSSysContentCatName() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTCATNAME, (Object)pSSysContentBase.getPSSysContentCatName());
        }
        if (pSSysContentBase.isPSSysContentIdDirty() && (bl || pSSysContentBase.getPSSysContentId() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTID, (Object)pSSysContentBase.getPSSysContentId());
        }
        if (pSSysContentBase.isPSSysContentNameDirty() && (bl || pSSysContentBase.getPSSysContentName() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTNAME, (Object)pSSysContentBase.getPSSysContentName());
        }
        if (pSSysContentBase.isPSSysDynaModelIdDirty() && (bl || pSSysContentBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysContentBase.getPSSysDynaModelId());
        }
        if (pSSysContentBase.isPSSysDynaModelNameDirty() && (bl || pSSysContentBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysContentBase.getPSSysDynaModelName());
        }
        if (pSSysContentBase.isPSSystemIdDirty() && (bl || pSSysContentBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysContentBase.getPSSystemId());
        }
        if (pSSysContentBase.isPSSystemNameDirty() && (bl || pSSysContentBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysContentBase.getPSSystemName());
        }
        if (pSSysContentBase.isRawContentDirty() && (bl || pSSysContentBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSSysContentBase.getRawContent());
        }
        if (pSSysContentBase.isSubjectDirty() && (bl || pSSysContentBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysContentBase.getSubject());
        }
        if (pSSysContentBase.isTagsDirty() && (bl || pSSysContentBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysContentBase.getTags());
        }
        if (pSSysContentBase.isUpdateDateDirty() && (bl || pSSysContentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysContentBase.getUpdateDate());
        }
        if (pSSysContentBase.isUpdateManDirty() && (bl || pSSysContentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysContentBase.getUpdateMan());
        }
        if (pSSysContentBase.isUserCatDirty() && (bl || pSSysContentBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysContentBase.getUserCat());
        }
        if (pSSysContentBase.isUserTagDirty() && (bl || pSSysContentBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysContentBase.getUserTag());
        }
        if (pSSysContentBase.isUserTag2Dirty() && (bl || pSSysContentBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysContentBase.getUserTag2());
        }
        if (pSSysContentBase.isUserTag3Dirty() && (bl || pSSysContentBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysContentBase.getUserTag3());
        }
        if (pSSysContentBase.isUserTag4Dirty() && (bl || pSSysContentBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysContentBase.getUserTag4());
        }
        if (pSSysContentBase.isValidFlagDirty() && (bl || pSSysContentBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysContentBase.getValidFlag());
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
        return PSSysContentBase.remove(this, n);
    }

    private static boolean remove(PSSysContentBase pSSysContentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysContentBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysContentBase.resetContentPath();
                return true;
            }
            case 2: {
                pSSysContentBase.resetContentTag();
                return true;
            }
            case 3: {
                pSSysContentBase.resetContentTag2();
                return true;
            }
            case 4: {
                pSSysContentBase.resetContentTag3();
                return true;
            }
            case 5: {
                pSSysContentBase.resetContentTag4();
                return true;
            }
            case 6: {
                pSSysContentBase.resetContentType();
                return true;
            }
            case 7: {
                pSSysContentBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysContentBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysContentBase.resetHtmlContent();
                return true;
            }
            case 10: {
                pSSysContentBase.resetLockFlag();
                return true;
            }
            case 11: {
                pSSysContentBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysContentBase.resetOrderValue();
                return true;
            }
            case 13: {
                pSSysContentBase.resetPSModuleId();
                return true;
            }
            case 14: {
                pSSysContentBase.resetPSModuleName();
                return true;
            }
            case 15: {
                pSSysContentBase.resetPSSysContentCatId();
                return true;
            }
            case 16: {
                pSSysContentBase.resetPSSysContentCatName();
                return true;
            }
            case 17: {
                pSSysContentBase.resetPSSysContentId();
                return true;
            }
            case 18: {
                pSSysContentBase.resetPSSysContentName();
                return true;
            }
            case 19: {
                pSSysContentBase.resetPSSysDynaModelId();
                return true;
            }
            case 20: {
                pSSysContentBase.resetPSSysDynaModelName();
                return true;
            }
            case 21: {
                pSSysContentBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysContentBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysContentBase.resetRawContent();
                return true;
            }
            case 24: {
                pSSysContentBase.resetSubject();
                return true;
            }
            case 25: {
                pSSysContentBase.resetTags();
                return true;
            }
            case 26: {
                pSSysContentBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSSysContentBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSSysContentBase.resetUserCat();
                return true;
            }
            case 29: {
                pSSysContentBase.resetUserTag();
                return true;
            }
            case 30: {
                pSSysContentBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSSysContentBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSSysContentBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSSysContentBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSModuleService.autoGet((IEntity)pSModule);
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
                pSSysContentCatService.autoGet((IEntity)pSSysContentCat);
                this.pssyscontentcat = pSSysContentCat;
            }
            return this.pssyscontentcat;
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

    private PSSysContentBase getProxyEntity() {
        return this.proxyPSSysContentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysContentBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysContentBase) {
            this.proxyPSSysContentBase = (PSSysContentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysContentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTENTPATH, 1);
        fieldIndexMap.put(FIELD_CONTENTTAG, 2);
        fieldIndexMap.put(FIELD_CONTENTTAG2, 3);
        fieldIndexMap.put(FIELD_CONTENTTAG3, 4);
        fieldIndexMap.put(FIELD_CONTENTTAG4, 5);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 9);
        fieldIndexMap.put(FIELD_LOCKFLAG, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_ORDERVALUE, 12);
        fieldIndexMap.put(FIELD_PSMODULEID, 13);
        fieldIndexMap.put(FIELD_PSMODULENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSCONTENTCATID, 15);
        fieldIndexMap.put(FIELD_PSSYSCONTENTCATNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSCONTENTID, 17);
        fieldIndexMap.put(FIELD_PSSYSCONTENTNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 19);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_RAWCONTENT, 23);
        fieldIndexMap.put(FIELD_SUBJECT, 24);
        fieldIndexMap.put(FIELD_TAGS, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_VALIDFLAG, 33);
    }
}

