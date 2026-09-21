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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpPrjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpPrjBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRJPARAM = "PRJPARAM";
    public static final String FIELD_PRJPARAM2 = "PRJPARAM2";
    public static final String FIELD_PRJSN = "PRJSN";
    public static final String FIELD_PRJTYPE = "PRJTYPE";
    public static final String FIELD_PRJVER = "PRJVER";
    public static final String FIELD_PSHELPPRJID = "PSHELPPRJID";
    public static final String FIELD_PSHELPPRJNAME = "PSHELPPRJNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SUBCAPTION = "SUBCAPTION";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CONTENT = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_HEADERCONTENT = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PRJPARAM = 7;
    private static final int INDEX_PRJPARAM2 = 8;
    private static final int INDEX_PRJSN = 9;
    private static final int INDEX_PRJTYPE = 10;
    private static final int INDEX_PRJVER = 11;
    private static final int INDEX_PSHELPPRJID = 12;
    private static final int INDEX_PSHELPPRJNAME = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSSYSTEMID = 16;
    private static final int INDEX_PSSYSTEMNAME = 17;
    private static final int INDEX_SUBCAPTION = 18;
    private static final int INDEX_TITLE = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpPrjBase proxyPSHelpPrjBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prjparamDirtyFlag = false;
    private boolean prjparam2DirtyFlag = false;
    private boolean prjsnDirtyFlag = false;
    private boolean prjtypeDirtyFlag = false;
    private boolean prjverDirtyFlag = false;
    private boolean pshelpprjidDirtyFlag = false;
    private boolean pshelpprjnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean subcaptionDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="prjparam")
    private String prjparam;
    @Column(name="prjparam2")
    private String prjparam2;
    @Column(name="prjsn")
    private String prjsn;
    @Column(name="prjtype")
    private String prjtype;
    @Column(name="prjver")
    private String prjver;
    @Column(name="pshelpprjid")
    private String pshelpprjid;
    @Column(name="pshelpprjname")
    private String pshelpprjname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPrjParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjparam = string;
        this.prjparamDirtyFlag = true;
    }

    public String getPrjParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjParam();
        }
        return this.prjparam;
    }

    public boolean isPrjParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjParamDirty();
        }
        return this.prjparamDirtyFlag;
    }

    public void resetPrjParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjParam();
            return;
        }
        this.prjparamDirtyFlag = false;
        this.prjparam = null;
    }

    public void setPrjParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjparam2 = string;
        this.prjparam2DirtyFlag = true;
    }

    public String getPrjParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjParam2();
        }
        return this.prjparam2;
    }

    public boolean isPrjParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjParam2Dirty();
        }
        return this.prjparam2DirtyFlag;
    }

    public void resetPrjParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjParam2();
            return;
        }
        this.prjparam2DirtyFlag = false;
        this.prjparam2 = null;
    }

    public void setPrjSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjsn = string;
        this.prjsnDirtyFlag = true;
    }

    public String getPrjSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjSN();
        }
        return this.prjsn;
    }

    public boolean isPrjSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjSNDirty();
        }
        return this.prjsnDirtyFlag;
    }

    public void resetPrjSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjSN();
            return;
        }
        this.prjsnDirtyFlag = false;
        this.prjsn = null;
    }

    public void setPrjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjtype = string;
        this.prjtypeDirtyFlag = true;
    }

    public String getPrjType() {
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

    public void setPrjVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjver = string;
        this.prjverDirtyFlag = true;
    }

    public String getPrjVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjVer();
        }
        return this.prjver;
    }

    public boolean isPrjVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjVerDirty();
        }
        return this.prjverDirtyFlag;
    }

    public void resetPrjVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjVer();
            return;
        }
        this.prjverDirtyFlag = false;
        this.prjver = null;
    }

    public void setPSHelpPrjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjid = string;
        this.pshelpprjidDirtyFlag = true;
    }

    public String getPSHelpPrjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjId();
        }
        return this.pshelpprjid;
    }

    public boolean isPSHelpPrjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjIdDirty();
        }
        return this.pshelpprjidDirtyFlag;
    }

    public void resetPSHelpPrjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjId();
            return;
        }
        this.pshelpprjidDirtyFlag = false;
        this.pshelpprjid = null;
    }

    public void setPSHelpPrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjname = string;
        this.pshelpprjnameDirtyFlag = true;
    }

    public String getPSHelpPrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjName();
        }
        return this.pshelpprjname;
    }

    public boolean isPSHelpPrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjNameDirty();
        }
        return this.pshelpprjnameDirtyFlag;
    }

    public void resetPSHelpPrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjName();
            return;
        }
        this.pshelpprjnameDirtyFlag = false;
        this.pshelpprjname = null;
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
        PSHelpPrjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpPrjBase pSHelpPrjBase) {
        pSHelpPrjBase.resetBottomContent();
        pSHelpPrjBase.resetCodeName();
        pSHelpPrjBase.resetContent();
        pSHelpPrjBase.resetCreateDate();
        pSHelpPrjBase.resetCreateMan();
        pSHelpPrjBase.resetHeaderContent();
        pSHelpPrjBase.resetMemo();
        pSHelpPrjBase.resetPrjParam();
        pSHelpPrjBase.resetPrjParam2();
        pSHelpPrjBase.resetPrjSN();
        pSHelpPrjBase.resetPrjType();
        pSHelpPrjBase.resetPrjVer();
        pSHelpPrjBase.resetPSHelpPrjId();
        pSHelpPrjBase.resetPSHelpPrjName();
        pSHelpPrjBase.resetPSModuleId();
        pSHelpPrjBase.resetPSModuleName();
        pSHelpPrjBase.resetPSSystemId();
        pSHelpPrjBase.resetPSSystemName();
        pSHelpPrjBase.resetSubCaption();
        pSHelpPrjBase.resetTitle();
        pSHelpPrjBase.resetUpdateDate();
        pSHelpPrjBase.resetUpdateMan();
        pSHelpPrjBase.resetUserCat();
        pSHelpPrjBase.resetUserTag();
        pSHelpPrjBase.resetUserTag2();
        pSHelpPrjBase.resetUserTag3();
        pSHelpPrjBase.resetUserTag4();
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
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isHeaderContentDirty()) {
            hashMap.put(FIELD_HEADERCONTENT, this.getHeaderContent());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrjParamDirty()) {
            hashMap.put(FIELD_PRJPARAM, this.getPrjParam());
        }
        if (!bl || this.isPrjParam2Dirty()) {
            hashMap.put(FIELD_PRJPARAM2, this.getPrjParam2());
        }
        if (!bl || this.isPrjSNDirty()) {
            hashMap.put(FIELD_PRJSN, this.getPrjSN());
        }
        if (!bl || this.isPrjTypeDirty()) {
            hashMap.put(FIELD_PRJTYPE, this.getPrjType());
        }
        if (!bl || this.isPrjVerDirty()) {
            hashMap.put(FIELD_PRJVER, this.getPrjVer());
        }
        if (!bl || this.isPSHelpPrjIdDirty()) {
            hashMap.put(FIELD_PSHELPPRJID, this.getPSHelpPrjId());
        }
        if (!bl || this.isPSHelpPrjNameDirty()) {
            hashMap.put(FIELD_PSHELPPRJNAME, this.getPSHelpPrjName());
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
        return PSHelpPrjBase.get(this, n);
    }

    private static Object get(PSHelpPrjBase pSHelpPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjBase.getBottomContent();
            }
            case 1: {
                return pSHelpPrjBase.getCodeName();
            }
            case 2: {
                return pSHelpPrjBase.getContent();
            }
            case 3: {
                return pSHelpPrjBase.getCreateDate();
            }
            case 4: {
                return pSHelpPrjBase.getCreateMan();
            }
            case 5: {
                return pSHelpPrjBase.getHeaderContent();
            }
            case 6: {
                return pSHelpPrjBase.getMemo();
            }
            case 7: {
                return pSHelpPrjBase.getPrjParam();
            }
            case 8: {
                return pSHelpPrjBase.getPrjParam2();
            }
            case 9: {
                return pSHelpPrjBase.getPrjSN();
            }
            case 10: {
                return pSHelpPrjBase.getPrjType();
            }
            case 11: {
                return pSHelpPrjBase.getPrjVer();
            }
            case 12: {
                return pSHelpPrjBase.getPSHelpPrjId();
            }
            case 13: {
                return pSHelpPrjBase.getPSHelpPrjName();
            }
            case 14: {
                return pSHelpPrjBase.getPSModuleId();
            }
            case 15: {
                return pSHelpPrjBase.getPSModuleName();
            }
            case 16: {
                return pSHelpPrjBase.getPSSystemId();
            }
            case 17: {
                return pSHelpPrjBase.getPSSystemName();
            }
            case 18: {
                return pSHelpPrjBase.getSubCaption();
            }
            case 19: {
                return pSHelpPrjBase.getTitle();
            }
            case 20: {
                return pSHelpPrjBase.getUpdateDate();
            }
            case 21: {
                return pSHelpPrjBase.getUpdateMan();
            }
            case 22: {
                return pSHelpPrjBase.getUserCat();
            }
            case 23: {
                return pSHelpPrjBase.getUserTag();
            }
            case 24: {
                return pSHelpPrjBase.getUserTag2();
            }
            case 25: {
                return pSHelpPrjBase.getUserTag3();
            }
            case 26: {
                return pSHelpPrjBase.getUserTag4();
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
        PSHelpPrjBase.set(this, n, object);
    }

    private static void set(PSHelpPrjBase pSHelpPrjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpPrjBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSHelpPrjBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpPrjBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSHelpPrjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSHelpPrjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpPrjBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpPrjBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpPrjBase.setPrjParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpPrjBase.setPrjParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpPrjBase.setPrjSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpPrjBase.setPrjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSHelpPrjBase.setPrjVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpPrjBase.setPSHelpPrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSHelpPrjBase.setPSHelpPrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSHelpPrjBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSHelpPrjBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSHelpPrjBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSHelpPrjBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSHelpPrjBase.setSubCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSHelpPrjBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSHelpPrjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSHelpPrjBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSHelpPrjBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSHelpPrjBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSHelpPrjBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSHelpPrjBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSHelpPrjBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSHelpPrjBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpPrjBase pSHelpPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjBase.getBottomContent() == null;
            }
            case 1: {
                return pSHelpPrjBase.getCodeName() == null;
            }
            case 2: {
                return pSHelpPrjBase.getContent() == null;
            }
            case 3: {
                return pSHelpPrjBase.getCreateDate() == null;
            }
            case 4: {
                return pSHelpPrjBase.getCreateMan() == null;
            }
            case 5: {
                return pSHelpPrjBase.getHeaderContent() == null;
            }
            case 6: {
                return pSHelpPrjBase.getMemo() == null;
            }
            case 7: {
                return pSHelpPrjBase.getPrjParam() == null;
            }
            case 8: {
                return pSHelpPrjBase.getPrjParam2() == null;
            }
            case 9: {
                return pSHelpPrjBase.getPrjSN() == null;
            }
            case 10: {
                return pSHelpPrjBase.getPrjType() == null;
            }
            case 11: {
                return pSHelpPrjBase.getPrjVer() == null;
            }
            case 12: {
                return pSHelpPrjBase.getPSHelpPrjId() == null;
            }
            case 13: {
                return pSHelpPrjBase.getPSHelpPrjName() == null;
            }
            case 14: {
                return pSHelpPrjBase.getPSModuleId() == null;
            }
            case 15: {
                return pSHelpPrjBase.getPSModuleName() == null;
            }
            case 16: {
                return pSHelpPrjBase.getPSSystemId() == null;
            }
            case 17: {
                return pSHelpPrjBase.getPSSystemName() == null;
            }
            case 18: {
                return pSHelpPrjBase.getSubCaption() == null;
            }
            case 19: {
                return pSHelpPrjBase.getTitle() == null;
            }
            case 20: {
                return pSHelpPrjBase.getUpdateDate() == null;
            }
            case 21: {
                return pSHelpPrjBase.getUpdateMan() == null;
            }
            case 22: {
                return pSHelpPrjBase.getUserCat() == null;
            }
            case 23: {
                return pSHelpPrjBase.getUserTag() == null;
            }
            case 24: {
                return pSHelpPrjBase.getUserTag2() == null;
            }
            case 25: {
                return pSHelpPrjBase.getUserTag3() == null;
            }
            case 26: {
                return pSHelpPrjBase.getUserTag4() == null;
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
        return PSHelpPrjBase.contains(this, n);
    }

    private static boolean contains(PSHelpPrjBase pSHelpPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjBase.isBottomContentDirty();
            }
            case 1: {
                return pSHelpPrjBase.isCodeNameDirty();
            }
            case 2: {
                return pSHelpPrjBase.isContentDirty();
            }
            case 3: {
                return pSHelpPrjBase.isCreateDateDirty();
            }
            case 4: {
                return pSHelpPrjBase.isCreateManDirty();
            }
            case 5: {
                return pSHelpPrjBase.isHeaderContentDirty();
            }
            case 6: {
                return pSHelpPrjBase.isMemoDirty();
            }
            case 7: {
                return pSHelpPrjBase.isPrjParamDirty();
            }
            case 8: {
                return pSHelpPrjBase.isPrjParam2Dirty();
            }
            case 9: {
                return pSHelpPrjBase.isPrjSNDirty();
            }
            case 10: {
                return pSHelpPrjBase.isPrjTypeDirty();
            }
            case 11: {
                return pSHelpPrjBase.isPrjVerDirty();
            }
            case 12: {
                return pSHelpPrjBase.isPSHelpPrjIdDirty();
            }
            case 13: {
                return pSHelpPrjBase.isPSHelpPrjNameDirty();
            }
            case 14: {
                return pSHelpPrjBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSHelpPrjBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSHelpPrjBase.isPSSystemIdDirty();
            }
            case 17: {
                return pSHelpPrjBase.isPSSystemNameDirty();
            }
            case 18: {
                return pSHelpPrjBase.isSubCaptionDirty();
            }
            case 19: {
                return pSHelpPrjBase.isTitleDirty();
            }
            case 20: {
                return pSHelpPrjBase.isUpdateDateDirty();
            }
            case 21: {
                return pSHelpPrjBase.isUpdateManDirty();
            }
            case 22: {
                return pSHelpPrjBase.isUserCatDirty();
            }
            case 23: {
                return pSHelpPrjBase.isUserTagDirty();
            }
            case 24: {
                return pSHelpPrjBase.isUserTag2Dirty();
            }
            case 25: {
                return pSHelpPrjBase.isUserTag3Dirty();
            }
            case 26: {
                return pSHelpPrjBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpPrjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpPrjBase pSHelpPrjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpPrjBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getCodeName()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getContent()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPrjParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjparam", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPrjParam()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPrjParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjparam2", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPrjParam2()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPrjSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjsn", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPrjSN()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPrjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjtype", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPrjType()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPrjVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjver", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPrjVer()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPSHelpPrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjid", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPSHelpPrjId()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPSHelpPrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjname", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPSHelpPrjName()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getSubCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcaption", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getSubCaption()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getTitle()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getUserCat()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getUserTag()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSHelpPrjBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSHelpPrjBase.getJSONValue((Object)pSHelpPrjBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpPrjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpPrjBase pSHelpPrjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpPrjBase.getBottomContent() != null) {
            object = pSHelpPrjBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpPrjBase.getCodeName() != null) {
            object = pSHelpPrjBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpPrjBase.getContent() != null) {
            object = pSHelpPrjBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getCreateDate() != null) {
            object = pSHelpPrjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpPrjBase.getCreateMan() != null) {
            object = pSHelpPrjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getHeaderContent() != null) {
            object = pSHelpPrjBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getMemo() != null) {
            object = pSHelpPrjBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPrjParam() != null) {
            object = pSHelpPrjBase.getPrjParam();
            xmlNode.setAttribute(FIELD_PRJPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPrjParam2() != null) {
            object = pSHelpPrjBase.getPrjParam2();
            xmlNode.setAttribute(FIELD_PRJPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPrjSN() != null) {
            object = pSHelpPrjBase.getPrjSN();
            xmlNode.setAttribute(FIELD_PRJSN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPrjType() != null) {
            object = pSHelpPrjBase.getPrjType();
            xmlNode.setAttribute(FIELD_PRJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPrjVer() != null) {
            object = pSHelpPrjBase.getPrjVer();
            xmlNode.setAttribute(FIELD_PRJVER, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPSHelpPrjId() != null) {
            object = pSHelpPrjBase.getPSHelpPrjId();
            xmlNode.setAttribute(FIELD_PSHELPPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPSHelpPrjName() != null) {
            object = pSHelpPrjBase.getPSHelpPrjName();
            xmlNode.setAttribute(FIELD_PSHELPPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPSModuleId() != null) {
            object = pSHelpPrjBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPSModuleName() != null) {
            object = pSHelpPrjBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPSSystemId() != null) {
            object = pSHelpPrjBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getPSSystemName() != null) {
            object = pSHelpPrjBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getSubCaption() != null) {
            object = pSHelpPrjBase.getSubCaption();
            xmlNode.setAttribute(FIELD_SUBCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getTitle() != null) {
            object = pSHelpPrjBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getUpdateDate() != null) {
            object = pSHelpPrjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpPrjBase.getUpdateMan() != null) {
            object = pSHelpPrjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getUserCat() != null) {
            object = pSHelpPrjBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getUserTag() != null) {
            object = pSHelpPrjBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getUserTag2() != null) {
            object = pSHelpPrjBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getUserTag3() != null) {
            object = pSHelpPrjBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjBase.getUserTag4() != null) {
            object = pSHelpPrjBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpPrjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpPrjBase pSHelpPrjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpPrjBase.isBottomContentDirty() && (bl || pSHelpPrjBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSHelpPrjBase.getBottomContent());
        }
        if (pSHelpPrjBase.isCodeNameDirty() && (bl || pSHelpPrjBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSHelpPrjBase.getCodeName());
        }
        if (pSHelpPrjBase.isContentDirty() && (bl || pSHelpPrjBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSHelpPrjBase.getContent());
        }
        if (pSHelpPrjBase.isCreateDateDirty() && (bl || pSHelpPrjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpPrjBase.getCreateDate());
        }
        if (pSHelpPrjBase.isCreateManDirty() && (bl || pSHelpPrjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpPrjBase.getCreateMan());
        }
        if (pSHelpPrjBase.isHeaderContentDirty() && (bl || pSHelpPrjBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSHelpPrjBase.getHeaderContent());
        }
        if (pSHelpPrjBase.isMemoDirty() && (bl || pSHelpPrjBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpPrjBase.getMemo());
        }
        if (pSHelpPrjBase.isPrjParamDirty() && (bl || pSHelpPrjBase.getPrjParam() != null)) {
            iDataObject.set(FIELD_PRJPARAM, (Object)pSHelpPrjBase.getPrjParam());
        }
        if (pSHelpPrjBase.isPrjParam2Dirty() && (bl || pSHelpPrjBase.getPrjParam2() != null)) {
            iDataObject.set(FIELD_PRJPARAM2, (Object)pSHelpPrjBase.getPrjParam2());
        }
        if (pSHelpPrjBase.isPrjSNDirty() && (bl || pSHelpPrjBase.getPrjSN() != null)) {
            iDataObject.set(FIELD_PRJSN, (Object)pSHelpPrjBase.getPrjSN());
        }
        if (pSHelpPrjBase.isPrjTypeDirty() && (bl || pSHelpPrjBase.getPrjType() != null)) {
            iDataObject.set(FIELD_PRJTYPE, (Object)pSHelpPrjBase.getPrjType());
        }
        if (pSHelpPrjBase.isPrjVerDirty() && (bl || pSHelpPrjBase.getPrjVer() != null)) {
            iDataObject.set(FIELD_PRJVER, (Object)pSHelpPrjBase.getPrjVer());
        }
        if (pSHelpPrjBase.isPSHelpPrjIdDirty() && (bl || pSHelpPrjBase.getPSHelpPrjId() != null)) {
            iDataObject.set(FIELD_PSHELPPRJID, (Object)pSHelpPrjBase.getPSHelpPrjId());
        }
        if (pSHelpPrjBase.isPSHelpPrjNameDirty() && (bl || pSHelpPrjBase.getPSHelpPrjName() != null)) {
            iDataObject.set(FIELD_PSHELPPRJNAME, (Object)pSHelpPrjBase.getPSHelpPrjName());
        }
        if (pSHelpPrjBase.isPSModuleIdDirty() && (bl || pSHelpPrjBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSHelpPrjBase.getPSModuleId());
        }
        if (pSHelpPrjBase.isPSModuleNameDirty() && (bl || pSHelpPrjBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSHelpPrjBase.getPSModuleName());
        }
        if (pSHelpPrjBase.isPSSystemIdDirty() && (bl || pSHelpPrjBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSHelpPrjBase.getPSSystemId());
        }
        if (pSHelpPrjBase.isPSSystemNameDirty() && (bl || pSHelpPrjBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSHelpPrjBase.getPSSystemName());
        }
        if (pSHelpPrjBase.isSubCaptionDirty() && (bl || pSHelpPrjBase.getSubCaption() != null)) {
            iDataObject.set(FIELD_SUBCAPTION, (Object)pSHelpPrjBase.getSubCaption());
        }
        if (pSHelpPrjBase.isTitleDirty() && (bl || pSHelpPrjBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSHelpPrjBase.getTitle());
        }
        if (pSHelpPrjBase.isUpdateDateDirty() && (bl || pSHelpPrjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpPrjBase.getUpdateDate());
        }
        if (pSHelpPrjBase.isUpdateManDirty() && (bl || pSHelpPrjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpPrjBase.getUpdateMan());
        }
        if (pSHelpPrjBase.isUserCatDirty() && (bl || pSHelpPrjBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSHelpPrjBase.getUserCat());
        }
        if (pSHelpPrjBase.isUserTagDirty() && (bl || pSHelpPrjBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSHelpPrjBase.getUserTag());
        }
        if (pSHelpPrjBase.isUserTag2Dirty() && (bl || pSHelpPrjBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSHelpPrjBase.getUserTag2());
        }
        if (pSHelpPrjBase.isUserTag3Dirty() && (bl || pSHelpPrjBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSHelpPrjBase.getUserTag3());
        }
        if (pSHelpPrjBase.isUserTag4Dirty() && (bl || pSHelpPrjBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSHelpPrjBase.getUserTag4());
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
        return PSHelpPrjBase.remove(this, n);
    }

    private static boolean remove(PSHelpPrjBase pSHelpPrjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpPrjBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSHelpPrjBase.resetCodeName();
                return true;
            }
            case 2: {
                pSHelpPrjBase.resetContent();
                return true;
            }
            case 3: {
                pSHelpPrjBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSHelpPrjBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSHelpPrjBase.resetHeaderContent();
                return true;
            }
            case 6: {
                pSHelpPrjBase.resetMemo();
                return true;
            }
            case 7: {
                pSHelpPrjBase.resetPrjParam();
                return true;
            }
            case 8: {
                pSHelpPrjBase.resetPrjParam2();
                return true;
            }
            case 9: {
                pSHelpPrjBase.resetPrjSN();
                return true;
            }
            case 10: {
                pSHelpPrjBase.resetPrjType();
                return true;
            }
            case 11: {
                pSHelpPrjBase.resetPrjVer();
                return true;
            }
            case 12: {
                pSHelpPrjBase.resetPSHelpPrjId();
                return true;
            }
            case 13: {
                pSHelpPrjBase.resetPSHelpPrjName();
                return true;
            }
            case 14: {
                pSHelpPrjBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSHelpPrjBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSHelpPrjBase.resetPSSystemId();
                return true;
            }
            case 17: {
                pSHelpPrjBase.resetPSSystemName();
                return true;
            }
            case 18: {
                pSHelpPrjBase.resetSubCaption();
                return true;
            }
            case 19: {
                pSHelpPrjBase.resetTitle();
                return true;
            }
            case 20: {
                pSHelpPrjBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSHelpPrjBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSHelpPrjBase.resetUserCat();
                return true;
            }
            case 23: {
                pSHelpPrjBase.resetUserTag();
                return true;
            }
            case 24: {
                pSHelpPrjBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSHelpPrjBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSHelpPrjBase.resetUserTag4();
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

    private PSHelpPrjBase getProxyEntity() {
        return this.proxyPSHelpPrjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpPrjBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpPrjBase) {
            this.proxyPSHelpPrjBase = (PSHelpPrjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpPrjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CONTENT, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PRJPARAM, 7);
        fieldIndexMap.put(FIELD_PRJPARAM2, 8);
        fieldIndexMap.put(FIELD_PRJSN, 9);
        fieldIndexMap.put(FIELD_PRJTYPE, 10);
        fieldIndexMap.put(FIELD_PRJVER, 11);
        fieldIndexMap.put(FIELD_PSHELPPRJID, 12);
        fieldIndexMap.put(FIELD_PSHELPPRJNAME, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 17);
        fieldIndexMap.put(FIELD_SUBCAPTION, 18);
        fieldIndexMap.put(FIELD_TITLE, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERCAT, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
    }
}

