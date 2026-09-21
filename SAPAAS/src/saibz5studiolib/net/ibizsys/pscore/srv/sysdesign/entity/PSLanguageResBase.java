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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysLanRes;
import net.ibizsys.pscore.srv.config.service.PSSysLanResService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSLanguageResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSLanguageResBase.class);
    public static final String FIELD_APPREFFLAG = "APPREFFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENT2 = "CONTENT2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LANRESTAG = "LANRESTAG";
    public static final String FIELD_LANRESTYPE = "LANRESTYPE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSLANGUAGERESID = "PSLANGUAGERESID";
    public static final String FIELD_PSLANGUAGERESNAME = "PSLANGUAGERESNAME";
    public static final String FIELD_PSLANITEMSCNT = "PSLANITEMSCNT";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSLANRESID = "PSSYSLANRESID";
    public static final String FIELD_PSSYSLANRESNAME = "PSSYSLANRESNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_SHORTTAG = "SHORTTAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    private static final int INDEX_APPREFFLAG = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CONTENT = 2;
    private static final int INDEX_CONTENT2 = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_LANRESTAG = 6;
    private static final int INDEX_LANRESTYPE = 7;
    private static final int INDEX_LOCKFLAG = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSAPPVIEWID = 10;
    private static final int INDEX_PSAPPVIEWNAME = 11;
    private static final int INDEX_PSDEFID = 12;
    private static final int INDEX_PSDEFNAME = 13;
    private static final int INDEX_PSDEID = 14;
    private static final int INDEX_PSDENAME = 15;
    private static final int INDEX_PSDEVIEWBASEID = 16;
    private static final int INDEX_PSDEVIEWBASENAME = 17;
    private static final int INDEX_PSLANGUAGERESID = 18;
    private static final int INDEX_PSLANGUAGERESNAME = 19;
    private static final int INDEX_PSLANITEMSCNT = 20;
    private static final int INDEX_PSMODULEID = 21;
    private static final int INDEX_PSMODULENAME = 22;
    private static final int INDEX_PSSYSAPPID = 23;
    private static final int INDEX_PSSYSAPPNAME = 24;
    private static final int INDEX_PSSYSLANRESID = 25;
    private static final int INDEX_PSSYSLANRESNAME = 26;
    private static final int INDEX_PSSYSTEMID = 27;
    private static final int INDEX_PSSYSTEMNAME = 28;
    private static final int INDEX_PSWFID = 29;
    private static final int INDEX_PSWFNAME = 30;
    private static final int INDEX_PSWFVERSIONID = 31;
    private static final int INDEX_PSWFVERSIONNAME = 32;
    private static final int INDEX_SHORTTAG = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_USERDATA = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSLanguageResBase proxyPSLanguageResBase = null;
    private boolean apprefflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean content2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lanrestagDirtyFlag = false;
    private boolean lanrestypeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean pslanguageresidDirtyFlag = false;
    private boolean pslanguageresnameDirtyFlag = false;
    private boolean pslanitemscntDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyslanresidDirtyFlag = false;
    private boolean pssyslanresnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean shorttagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    @Column(name="apprefflag")
    private Integer apprefflag;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="content2")
    private String content2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lanrestag")
    private String lanrestag;
    @Column(name="lanrestype")
    private String lanrestype;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="pslanguageresid")
    private String pslanguageresid;
    @Column(name="pslanguageresname")
    private String pslanguageresname;
    @Column(name="pslanitemscnt")
    private Integer pslanitemscnt;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyslanresid")
    private String pssyslanresid;
    @Column(name="pssyslanresname")
    private String pssyslanresname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="shorttag")
    private String shorttag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    private Integer objPSAppViewLock = new Integer(1);
    private PSAppView psappview = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysLanResLock = new Integer(1);
    private PSSysLanRes pssyslanres = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;
    private Integer objPSLanguageItemsLock = new Integer(1);
    private ArrayList<PSLanguageItem> pslanguageitems = null;

    public void setAppRefFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppRefFlag(n);
            return;
        }
        this.apprefflag = n;
        this.apprefflagDirtyFlag = true;
    }

    public Integer getAppRefFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppRefFlag();
        }
        return this.apprefflag;
    }

    public boolean isAppRefFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppRefFlagDirty();
        }
        return this.apprefflagDirtyFlag;
    }

    public void resetAppRefFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppRefFlag();
            return;
        }
        this.apprefflagDirtyFlag = false;
        this.apprefflag = null;
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

    public void setLanResTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanResTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.lanrestag = string;
        this.lanrestagDirtyFlag = true;
    }

    public String getLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanResTag();
        }
        return this.lanrestag;
    }

    public boolean isLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanResTagDirty();
        }
        return this.lanrestagDirtyFlag;
    }

    public void resetLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanResTag();
            return;
        }
        this.lanrestagDirtyFlag = false;
        this.lanrestag = null;
    }

    public void setLanResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lanrestype = string;
        this.lanrestypeDirtyFlag = true;
    }

    public String getLanResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanResType();
        }
        return this.lanrestype;
    }

    public boolean isLanResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanResTypeDirty();
        }
        return this.lanrestypeDirtyFlag;
    }

    public void resetLanResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanResType();
            return;
        }
        this.lanrestypeDirtyFlag = false;
        this.lanrestype = null;
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

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSLanguageResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageresid = string;
        this.pslanguageresidDirtyFlag = true;
    }

    public String getPSLanguageResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageResId();
        }
        return this.pslanguageresid;
    }

    public boolean isPSLanguageResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageResIdDirty();
        }
        return this.pslanguageresidDirtyFlag;
    }

    public void resetPSLanguageResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageResId();
            return;
        }
        this.pslanguageresidDirtyFlag = false;
        this.pslanguageresid = null;
    }

    public void setPSLanguageResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageresname = string;
        this.pslanguageresnameDirtyFlag = true;
    }

    public String getPSLanguageResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageResName();
        }
        return this.pslanguageresname;
    }

    public boolean isPSLanguageResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageResNameDirty();
        }
        return this.pslanguageresnameDirtyFlag;
    }

    public void resetPSLanguageResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageResName();
            return;
        }
        this.pslanguageresnameDirtyFlag = false;
        this.pslanguageresname = null;
    }

    public void setPSLanItemsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanItemsCnt(n);
            return;
        }
        this.pslanitemscnt = n;
        this.pslanitemscntDirtyFlag = true;
    }

    public Integer getPSLanItemsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanItemsCnt();
        }
        return this.pslanitemscnt;
    }

    public boolean isPSLanItemsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanItemsCntDirty();
        }
        return this.pslanitemscntDirtyFlag;
    }

    public void resetPSLanItemsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanItemsCnt();
            return;
        }
        this.pslanitemscntDirtyFlag = false;
        this.pslanitemscnt = null;
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

    public void setPSSysLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanresid = string;
        this.pssyslanresidDirtyFlag = true;
    }

    public String getPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanResId();
        }
        return this.pssyslanresid;
    }

    public boolean isPSSysLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanResIdDirty();
        }
        return this.pssyslanresidDirtyFlag;
    }

    public void resetPSSysLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanResId();
            return;
        }
        this.pssyslanresidDirtyFlag = false;
        this.pssyslanresid = null;
    }

    public void setPSSysLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyslanresname = string;
        this.pssyslanresnameDirtyFlag = true;
    }

    public String getPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanResName();
        }
        return this.pssyslanresname;
    }

    public boolean isPSSysLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysLanResNameDirty();
        }
        return this.pssyslanresnameDirtyFlag;
    }

    public void resetPSSysLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysLanResName();
            return;
        }
        this.pssyslanresnameDirtyFlag = false;
        this.pssyslanresname = null;
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

    public void setPSWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfid = string;
        this.pswfidDirtyFlag = true;
    }

    public String getPSWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFId();
        }
        return this.pswfid;
    }

    public boolean isPSWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFIdDirty();
        }
        return this.pswfidDirtyFlag;
    }

    public void resetPSWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFId();
            return;
        }
        this.pswfidDirtyFlag = false;
        this.pswfid = null;
    }

    public void setPSWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfname = string;
        this.pswfnameDirtyFlag = true;
    }

    public String getPSWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFName();
        }
        return this.pswfname;
    }

    public boolean isPSWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFNameDirty();
        }
        return this.pswfnameDirtyFlag;
    }

    public void resetPSWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFName();
            return;
        }
        this.pswfnameDirtyFlag = false;
        this.pswfname = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
    }

    public void setShortTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShortTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shorttag = string;
        this.shorttagDirtyFlag = true;
    }

    public String getShortTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShortTag();
        }
        return this.shorttag;
    }

    public boolean isShortTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShortTagDirty();
        }
        return this.shorttagDirtyFlag;
    }

    public void resetShortTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShortTag();
            return;
        }
        this.shorttagDirtyFlag = false;
        this.shorttag = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
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

    protected void onReset() {
        PSLanguageResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSLanguageResBase pSLanguageResBase) {
        pSLanguageResBase.resetAppRefFlag();
        pSLanguageResBase.resetCodeName();
        pSLanguageResBase.resetContent();
        pSLanguageResBase.resetContent2();
        pSLanguageResBase.resetCreateDate();
        pSLanguageResBase.resetCreateMan();
        pSLanguageResBase.resetLanResTag();
        pSLanguageResBase.resetLanResType();
        pSLanguageResBase.resetLockFlag();
        pSLanguageResBase.resetMemo();
        pSLanguageResBase.resetPSAppViewId();
        pSLanguageResBase.resetPSAppViewName();
        pSLanguageResBase.resetPSDEFId();
        pSLanguageResBase.resetPSDEFName();
        pSLanguageResBase.resetPSDEId();
        pSLanguageResBase.resetPSDEName();
        pSLanguageResBase.resetPSDEViewBaseId();
        pSLanguageResBase.resetPSDEViewBaseName();
        pSLanguageResBase.resetPSLanguageResId();
        pSLanguageResBase.resetPSLanguageResName();
        pSLanguageResBase.resetPSLanItemsCnt();
        pSLanguageResBase.resetPSModuleId();
        pSLanguageResBase.resetPSModuleName();
        pSLanguageResBase.resetPSSysAppId();
        pSLanguageResBase.resetPSSysAppName();
        pSLanguageResBase.resetPSSysLanResId();
        pSLanguageResBase.resetPSSysLanResName();
        pSLanguageResBase.resetPSSystemId();
        pSLanguageResBase.resetPSSystemName();
        pSLanguageResBase.resetPSWFId();
        pSLanguageResBase.resetPSWFName();
        pSLanguageResBase.resetPSWFVersionId();
        pSLanguageResBase.resetPSWFVersionName();
        pSLanguageResBase.resetShortTag();
        pSLanguageResBase.resetUpdateDate();
        pSLanguageResBase.resetUpdateMan();
        pSLanguageResBase.resetUserData();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppRefFlagDirty()) {
            hashMap.put(FIELD_APPREFFLAG, this.getAppRefFlag());
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
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLanResTagDirty()) {
            hashMap.put(FIELD_LANRESTAG, this.getLanResTag());
        }
        if (!bl || this.isLanResTypeDirty()) {
            hashMap.put(FIELD_LANRESTYPE, this.getLanResType());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
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
        if (!bl || this.isPSLanguageResIdDirty()) {
            hashMap.put(FIELD_PSLANGUAGERESID, this.getPSLanguageResId());
        }
        if (!bl || this.isPSLanguageResNameDirty()) {
            hashMap.put(FIELD_PSLANGUAGERESNAME, this.getPSLanguageResName());
        }
        if (!bl || this.isPSLanItemsCntDirty()) {
            hashMap.put(FIELD_PSLANITEMSCNT, this.getPSLanItemsCnt());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysLanResIdDirty()) {
            hashMap.put(FIELD_PSSYSLANRESID, this.getPSSysLanResId());
        }
        if (!bl || this.isPSSysLanResNameDirty()) {
            hashMap.put(FIELD_PSSYSLANRESNAME, this.getPSSysLanResName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isShortTagDirty()) {
            hashMap.put(FIELD_SHORTTAG, this.getShortTag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
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
        return PSLanguageResBase.get(this, n);
    }

    private static Object get(PSLanguageResBase pSLanguageResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageResBase.getAppRefFlag();
            }
            case 1: {
                return pSLanguageResBase.getCodeName();
            }
            case 2: {
                return pSLanguageResBase.getContent();
            }
            case 3: {
                return pSLanguageResBase.getContent2();
            }
            case 4: {
                return pSLanguageResBase.getCreateDate();
            }
            case 5: {
                return pSLanguageResBase.getCreateMan();
            }
            case 6: {
                return pSLanguageResBase.getLanResTag();
            }
            case 7: {
                return pSLanguageResBase.getLanResType();
            }
            case 8: {
                return pSLanguageResBase.getLockFlag();
            }
            case 9: {
                return pSLanguageResBase.getMemo();
            }
            case 10: {
                return pSLanguageResBase.getPSAppViewId();
            }
            case 11: {
                return pSLanguageResBase.getPSAppViewName();
            }
            case 12: {
                return pSLanguageResBase.getPSDEFId();
            }
            case 13: {
                return pSLanguageResBase.getPSDEFName();
            }
            case 14: {
                return pSLanguageResBase.getPSDEId();
            }
            case 15: {
                return pSLanguageResBase.getPSDEName();
            }
            case 16: {
                return pSLanguageResBase.getPSDEViewBaseId();
            }
            case 17: {
                return pSLanguageResBase.getPSDEViewBaseName();
            }
            case 18: {
                return pSLanguageResBase.getPSLanguageResId();
            }
            case 19: {
                return pSLanguageResBase.getPSLanguageResName();
            }
            case 20: {
                return pSLanguageResBase.getPSLanItemsCnt();
            }
            case 21: {
                return pSLanguageResBase.getPSModuleId();
            }
            case 22: {
                return pSLanguageResBase.getPSModuleName();
            }
            case 23: {
                return pSLanguageResBase.getPSSysAppId();
            }
            case 24: {
                return pSLanguageResBase.getPSSysAppName();
            }
            case 25: {
                return pSLanguageResBase.getPSSysLanResId();
            }
            case 26: {
                return pSLanguageResBase.getPSSysLanResName();
            }
            case 27: {
                return pSLanguageResBase.getPSSystemId();
            }
            case 28: {
                return pSLanguageResBase.getPSSystemName();
            }
            case 29: {
                return pSLanguageResBase.getPSWFId();
            }
            case 30: {
                return pSLanguageResBase.getPSWFName();
            }
            case 31: {
                return pSLanguageResBase.getPSWFVersionId();
            }
            case 32: {
                return pSLanguageResBase.getPSWFVersionName();
            }
            case 33: {
                return pSLanguageResBase.getShortTag();
            }
            case 34: {
                return pSLanguageResBase.getUpdateDate();
            }
            case 35: {
                return pSLanguageResBase.getUpdateMan();
            }
            case 36: {
                return pSLanguageResBase.getUserData();
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
        PSLanguageResBase.set(this, n, object);
    }

    private static void set(PSLanguageResBase pSLanguageResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSLanguageResBase.setAppRefFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSLanguageResBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSLanguageResBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSLanguageResBase.setContent2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSLanguageResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSLanguageResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSLanguageResBase.setLanResTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSLanguageResBase.setLanResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSLanguageResBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSLanguageResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSLanguageResBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSLanguageResBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSLanguageResBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSLanguageResBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSLanguageResBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSLanguageResBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSLanguageResBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSLanguageResBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSLanguageResBase.setPSLanguageResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSLanguageResBase.setPSLanguageResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSLanguageResBase.setPSLanItemsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSLanguageResBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSLanguageResBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSLanguageResBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSLanguageResBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSLanguageResBase.setPSSysLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSLanguageResBase.setPSSysLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSLanguageResBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSLanguageResBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSLanguageResBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSLanguageResBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSLanguageResBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSLanguageResBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSLanguageResBase.setShortTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSLanguageResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSLanguageResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSLanguageResBase.setUserData(DataObject.getStringValue((Object)object));
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
        return PSLanguageResBase.isNull(this, n);
    }

    private static boolean isNull(PSLanguageResBase pSLanguageResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageResBase.getAppRefFlag() == null;
            }
            case 1: {
                return pSLanguageResBase.getCodeName() == null;
            }
            case 2: {
                return pSLanguageResBase.getContent() == null;
            }
            case 3: {
                return pSLanguageResBase.getContent2() == null;
            }
            case 4: {
                return pSLanguageResBase.getCreateDate() == null;
            }
            case 5: {
                return pSLanguageResBase.getCreateMan() == null;
            }
            case 6: {
                return pSLanguageResBase.getLanResTag() == null;
            }
            case 7: {
                return pSLanguageResBase.getLanResType() == null;
            }
            case 8: {
                return pSLanguageResBase.getLockFlag() == null;
            }
            case 9: {
                return pSLanguageResBase.getMemo() == null;
            }
            case 10: {
                return pSLanguageResBase.getPSAppViewId() == null;
            }
            case 11: {
                return pSLanguageResBase.getPSAppViewName() == null;
            }
            case 12: {
                return pSLanguageResBase.getPSDEFId() == null;
            }
            case 13: {
                return pSLanguageResBase.getPSDEFName() == null;
            }
            case 14: {
                return pSLanguageResBase.getPSDEId() == null;
            }
            case 15: {
                return pSLanguageResBase.getPSDEName() == null;
            }
            case 16: {
                return pSLanguageResBase.getPSDEViewBaseId() == null;
            }
            case 17: {
                return pSLanguageResBase.getPSDEViewBaseName() == null;
            }
            case 18: {
                return pSLanguageResBase.getPSLanguageResId() == null;
            }
            case 19: {
                return pSLanguageResBase.getPSLanguageResName() == null;
            }
            case 20: {
                return pSLanguageResBase.getPSLanItemsCnt() == null;
            }
            case 21: {
                return pSLanguageResBase.getPSModuleId() == null;
            }
            case 22: {
                return pSLanguageResBase.getPSModuleName() == null;
            }
            case 23: {
                return pSLanguageResBase.getPSSysAppId() == null;
            }
            case 24: {
                return pSLanguageResBase.getPSSysAppName() == null;
            }
            case 25: {
                return pSLanguageResBase.getPSSysLanResId() == null;
            }
            case 26: {
                return pSLanguageResBase.getPSSysLanResName() == null;
            }
            case 27: {
                return pSLanguageResBase.getPSSystemId() == null;
            }
            case 28: {
                return pSLanguageResBase.getPSSystemName() == null;
            }
            case 29: {
                return pSLanguageResBase.getPSWFId() == null;
            }
            case 30: {
                return pSLanguageResBase.getPSWFName() == null;
            }
            case 31: {
                return pSLanguageResBase.getPSWFVersionId() == null;
            }
            case 32: {
                return pSLanguageResBase.getPSWFVersionName() == null;
            }
            case 33: {
                return pSLanguageResBase.getShortTag() == null;
            }
            case 34: {
                return pSLanguageResBase.getUpdateDate() == null;
            }
            case 35: {
                return pSLanguageResBase.getUpdateMan() == null;
            }
            case 36: {
                return pSLanguageResBase.getUserData() == null;
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
        return PSLanguageResBase.contains(this, n);
    }

    private static boolean contains(PSLanguageResBase pSLanguageResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageResBase.isAppRefFlagDirty();
            }
            case 1: {
                return pSLanguageResBase.isCodeNameDirty();
            }
            case 2: {
                return pSLanguageResBase.isContentDirty();
            }
            case 3: {
                return pSLanguageResBase.isContent2Dirty();
            }
            case 4: {
                return pSLanguageResBase.isCreateDateDirty();
            }
            case 5: {
                return pSLanguageResBase.isCreateManDirty();
            }
            case 6: {
                return pSLanguageResBase.isLanResTagDirty();
            }
            case 7: {
                return pSLanguageResBase.isLanResTypeDirty();
            }
            case 8: {
                return pSLanguageResBase.isLockFlagDirty();
            }
            case 9: {
                return pSLanguageResBase.isMemoDirty();
            }
            case 10: {
                return pSLanguageResBase.isPSAppViewIdDirty();
            }
            case 11: {
                return pSLanguageResBase.isPSAppViewNameDirty();
            }
            case 12: {
                return pSLanguageResBase.isPSDEFIdDirty();
            }
            case 13: {
                return pSLanguageResBase.isPSDEFNameDirty();
            }
            case 14: {
                return pSLanguageResBase.isPSDEIdDirty();
            }
            case 15: {
                return pSLanguageResBase.isPSDENameDirty();
            }
            case 16: {
                return pSLanguageResBase.isPSDEViewBaseIdDirty();
            }
            case 17: {
                return pSLanguageResBase.isPSDEViewBaseNameDirty();
            }
            case 18: {
                return pSLanguageResBase.isPSLanguageResIdDirty();
            }
            case 19: {
                return pSLanguageResBase.isPSLanguageResNameDirty();
            }
            case 20: {
                return pSLanguageResBase.isPSLanItemsCntDirty();
            }
            case 21: {
                return pSLanguageResBase.isPSModuleIdDirty();
            }
            case 22: {
                return pSLanguageResBase.isPSModuleNameDirty();
            }
            case 23: {
                return pSLanguageResBase.isPSSysAppIdDirty();
            }
            case 24: {
                return pSLanguageResBase.isPSSysAppNameDirty();
            }
            case 25: {
                return pSLanguageResBase.isPSSysLanResIdDirty();
            }
            case 26: {
                return pSLanguageResBase.isPSSysLanResNameDirty();
            }
            case 27: {
                return pSLanguageResBase.isPSSystemIdDirty();
            }
            case 28: {
                return pSLanguageResBase.isPSSystemNameDirty();
            }
            case 29: {
                return pSLanguageResBase.isPSWFIdDirty();
            }
            case 30: {
                return pSLanguageResBase.isPSWFNameDirty();
            }
            case 31: {
                return pSLanguageResBase.isPSWFVersionIdDirty();
            }
            case 32: {
                return pSLanguageResBase.isPSWFVersionNameDirty();
            }
            case 33: {
                return pSLanguageResBase.isShortTagDirty();
            }
            case 34: {
                return pSLanguageResBase.isUpdateDateDirty();
            }
            case 35: {
                return pSLanguageResBase.isUpdateManDirty();
            }
            case 36: {
                return pSLanguageResBase.isUserDataDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSLanguageResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSLanguageResBase pSLanguageResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSLanguageResBase.getAppRefFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apprefflag", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getAppRefFlag()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getCodeName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getContent()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getContent2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content2", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getContent2()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getLanResTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanrestag", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getLanResTag()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getLanResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanrestype", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getLanResType()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getMemo()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSLanguageResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageresid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSLanguageResId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSLanguageResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageresname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSLanguageResName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSLanItemsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanitemscnt", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSLanItemsCnt()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSSysLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanresid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSSysLanResId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSSysLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyslanresname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSSysLanResName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getShortTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shorttag", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getShortTag()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSLanguageResBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSLanguageResBase.getJSONValue((Object)pSLanguageResBase.getUserData()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSLanguageResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSLanguageResBase pSLanguageResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSLanguageResBase.getAppRefFlag() != null) {
            object = pSLanguageResBase.getAppRefFlag();
            xmlNode.setAttribute(FIELD_APPREFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSLanguageResBase.getCodeName() != null) {
            object = pSLanguageResBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getContent() != null) {
            object = pSLanguageResBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getContent2() != null) {
            object = pSLanguageResBase.getContent2();
            xmlNode.setAttribute(FIELD_CONTENT2, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getCreateDate() != null) {
            object = pSLanguageResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSLanguageResBase.getCreateMan() != null) {
            object = pSLanguageResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getLanResTag() != null) {
            object = pSLanguageResBase.getLanResTag();
            xmlNode.setAttribute(FIELD_LANRESTAG, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getLanResType() != null) {
            object = pSLanguageResBase.getLanResType();
            xmlNode.setAttribute(FIELD_LANRESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getLockFlag() != null) {
            object = pSLanguageResBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSLanguageResBase.getMemo() != null) {
            object = pSLanguageResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSAppViewId() != null) {
            object = pSLanguageResBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSAppViewName() != null) {
            object = pSLanguageResBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSDEFId() != null) {
            object = pSLanguageResBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSDEFName() != null) {
            object = pSLanguageResBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSDEId() != null) {
            object = pSLanguageResBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSDEName() != null) {
            object = pSLanguageResBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSDEViewBaseId() != null) {
            object = pSLanguageResBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSDEViewBaseName() != null) {
            object = pSLanguageResBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSLanguageResId() != null) {
            object = pSLanguageResBase.getPSLanguageResId();
            xmlNode.setAttribute(FIELD_PSLANGUAGERESID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSLanguageResName() != null) {
            object = pSLanguageResBase.getPSLanguageResName();
            xmlNode.setAttribute(FIELD_PSLANGUAGERESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSLanItemsCnt() != null) {
            object = pSLanguageResBase.getPSLanItemsCnt();
            xmlNode.setAttribute(FIELD_PSLANITEMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSLanguageResBase.getPSModuleId() != null) {
            object = pSLanguageResBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSModuleName() != null) {
            object = pSLanguageResBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSSysAppId() != null) {
            object = pSLanguageResBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSSysAppName() != null) {
            object = pSLanguageResBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSSysLanResId() != null) {
            object = pSLanguageResBase.getPSSysLanResId();
            xmlNode.setAttribute(FIELD_PSSYSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSSysLanResName() != null) {
            object = pSLanguageResBase.getPSSysLanResName();
            xmlNode.setAttribute(FIELD_PSSYSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSSystemId() != null) {
            object = pSLanguageResBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSSystemName() != null) {
            object = pSLanguageResBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSWFId() != null) {
            object = pSLanguageResBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSWFName() != null) {
            object = pSLanguageResBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSWFVersionId() != null) {
            object = pSLanguageResBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getPSWFVersionName() != null) {
            object = pSLanguageResBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getShortTag() != null) {
            object = pSLanguageResBase.getShortTag();
            xmlNode.setAttribute(FIELD_SHORTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getUpdateDate() != null) {
            object = pSLanguageResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSLanguageResBase.getUpdateMan() != null) {
            object = pSLanguageResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageResBase.getUserData() != null) {
            object = pSLanguageResBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSLanguageResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSLanguageResBase pSLanguageResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSLanguageResBase.isAppRefFlagDirty() && (bl || pSLanguageResBase.getAppRefFlag() != null)) {
            iDataObject.set(FIELD_APPREFFLAG, (Object)pSLanguageResBase.getAppRefFlag());
        }
        if (pSLanguageResBase.isCodeNameDirty() && (bl || pSLanguageResBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSLanguageResBase.getCodeName());
        }
        if (pSLanguageResBase.isContentDirty() && (bl || pSLanguageResBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSLanguageResBase.getContent());
        }
        if (pSLanguageResBase.isContent2Dirty() && (bl || pSLanguageResBase.getContent2() != null)) {
            iDataObject.set(FIELD_CONTENT2, (Object)pSLanguageResBase.getContent2());
        }
        if (pSLanguageResBase.isCreateDateDirty() && (bl || pSLanguageResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSLanguageResBase.getCreateDate());
        }
        if (pSLanguageResBase.isCreateManDirty() && (bl || pSLanguageResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSLanguageResBase.getCreateMan());
        }
        if (pSLanguageResBase.isLanResTagDirty() && (bl || pSLanguageResBase.getLanResTag() != null)) {
            iDataObject.set(FIELD_LANRESTAG, (Object)pSLanguageResBase.getLanResTag());
        }
        if (pSLanguageResBase.isLanResTypeDirty() && (bl || pSLanguageResBase.getLanResType() != null)) {
            iDataObject.set(FIELD_LANRESTYPE, (Object)pSLanguageResBase.getLanResType());
        }
        if (pSLanguageResBase.isLockFlagDirty() && (bl || pSLanguageResBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSLanguageResBase.getLockFlag());
        }
        if (pSLanguageResBase.isMemoDirty() && (bl || pSLanguageResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSLanguageResBase.getMemo());
        }
        if (pSLanguageResBase.isPSAppViewIdDirty() && (bl || pSLanguageResBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSLanguageResBase.getPSAppViewId());
        }
        if (pSLanguageResBase.isPSAppViewNameDirty() && (bl || pSLanguageResBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSLanguageResBase.getPSAppViewName());
        }
        if (pSLanguageResBase.isPSDEFIdDirty() && (bl || pSLanguageResBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSLanguageResBase.getPSDEFId());
        }
        if (pSLanguageResBase.isPSDEFNameDirty() && (bl || pSLanguageResBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSLanguageResBase.getPSDEFName());
        }
        if (pSLanguageResBase.isPSDEIdDirty() && (bl || pSLanguageResBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSLanguageResBase.getPSDEId());
        }
        if (pSLanguageResBase.isPSDENameDirty() && (bl || pSLanguageResBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSLanguageResBase.getPSDEName());
        }
        if (pSLanguageResBase.isPSDEViewBaseIdDirty() && (bl || pSLanguageResBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSLanguageResBase.getPSDEViewBaseId());
        }
        if (pSLanguageResBase.isPSDEViewBaseNameDirty() && (bl || pSLanguageResBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSLanguageResBase.getPSDEViewBaseName());
        }
        if (pSLanguageResBase.isPSLanguageResIdDirty() && (bl || pSLanguageResBase.getPSLanguageResId() != null)) {
            iDataObject.set(FIELD_PSLANGUAGERESID, (Object)pSLanguageResBase.getPSLanguageResId());
        }
        if (pSLanguageResBase.isPSLanguageResNameDirty() && (bl || pSLanguageResBase.getPSLanguageResName() != null)) {
            iDataObject.set(FIELD_PSLANGUAGERESNAME, (Object)pSLanguageResBase.getPSLanguageResName());
        }
        if (pSLanguageResBase.isPSLanItemsCntDirty() && (bl || pSLanguageResBase.getPSLanItemsCnt() != null)) {
            iDataObject.set(FIELD_PSLANITEMSCNT, (Object)pSLanguageResBase.getPSLanItemsCnt());
        }
        if (pSLanguageResBase.isPSModuleIdDirty() && (bl || pSLanguageResBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSLanguageResBase.getPSModuleId());
        }
        if (pSLanguageResBase.isPSModuleNameDirty() && (bl || pSLanguageResBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSLanguageResBase.getPSModuleName());
        }
        if (pSLanguageResBase.isPSSysAppIdDirty() && (bl || pSLanguageResBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSLanguageResBase.getPSSysAppId());
        }
        if (pSLanguageResBase.isPSSysAppNameDirty() && (bl || pSLanguageResBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSLanguageResBase.getPSSysAppName());
        }
        if (pSLanguageResBase.isPSSysLanResIdDirty() && (bl || pSLanguageResBase.getPSSysLanResId() != null)) {
            iDataObject.set(FIELD_PSSYSLANRESID, (Object)pSLanguageResBase.getPSSysLanResId());
        }
        if (pSLanguageResBase.isPSSysLanResNameDirty() && (bl || pSLanguageResBase.getPSSysLanResName() != null)) {
            iDataObject.set(FIELD_PSSYSLANRESNAME, (Object)pSLanguageResBase.getPSSysLanResName());
        }
        if (pSLanguageResBase.isPSSystemIdDirty() && (bl || pSLanguageResBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSLanguageResBase.getPSSystemId());
        }
        if (pSLanguageResBase.isPSSystemNameDirty() && (bl || pSLanguageResBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSLanguageResBase.getPSSystemName());
        }
        if (pSLanguageResBase.isPSWFIdDirty() && (bl || pSLanguageResBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSLanguageResBase.getPSWFId());
        }
        if (pSLanguageResBase.isPSWFNameDirty() && (bl || pSLanguageResBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSLanguageResBase.getPSWFName());
        }
        if (pSLanguageResBase.isPSWFVersionIdDirty() && (bl || pSLanguageResBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSLanguageResBase.getPSWFVersionId());
        }
        if (pSLanguageResBase.isPSWFVersionNameDirty() && (bl || pSLanguageResBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSLanguageResBase.getPSWFVersionName());
        }
        if (pSLanguageResBase.isShortTagDirty() && (bl || pSLanguageResBase.getShortTag() != null)) {
            iDataObject.set(FIELD_SHORTTAG, (Object)pSLanguageResBase.getShortTag());
        }
        if (pSLanguageResBase.isUpdateDateDirty() && (bl || pSLanguageResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSLanguageResBase.getUpdateDate());
        }
        if (pSLanguageResBase.isUpdateManDirty() && (bl || pSLanguageResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSLanguageResBase.getUpdateMan());
        }
        if (pSLanguageResBase.isUserDataDirty() && (bl || pSLanguageResBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSLanguageResBase.getUserData());
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
        return PSLanguageResBase.remove(this, n);
    }

    private static boolean remove(PSLanguageResBase pSLanguageResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSLanguageResBase.resetAppRefFlag();
                return true;
            }
            case 1: {
                pSLanguageResBase.resetCodeName();
                return true;
            }
            case 2: {
                pSLanguageResBase.resetContent();
                return true;
            }
            case 3: {
                pSLanguageResBase.resetContent2();
                return true;
            }
            case 4: {
                pSLanguageResBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSLanguageResBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSLanguageResBase.resetLanResTag();
                return true;
            }
            case 7: {
                pSLanguageResBase.resetLanResType();
                return true;
            }
            case 8: {
                pSLanguageResBase.resetLockFlag();
                return true;
            }
            case 9: {
                pSLanguageResBase.resetMemo();
                return true;
            }
            case 10: {
                pSLanguageResBase.resetPSAppViewId();
                return true;
            }
            case 11: {
                pSLanguageResBase.resetPSAppViewName();
                return true;
            }
            case 12: {
                pSLanguageResBase.resetPSDEFId();
                return true;
            }
            case 13: {
                pSLanguageResBase.resetPSDEFName();
                return true;
            }
            case 14: {
                pSLanguageResBase.resetPSDEId();
                return true;
            }
            case 15: {
                pSLanguageResBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSLanguageResBase.resetPSDEViewBaseId();
                return true;
            }
            case 17: {
                pSLanguageResBase.resetPSDEViewBaseName();
                return true;
            }
            case 18: {
                pSLanguageResBase.resetPSLanguageResId();
                return true;
            }
            case 19: {
                pSLanguageResBase.resetPSLanguageResName();
                return true;
            }
            case 20: {
                pSLanguageResBase.resetPSLanItemsCnt();
                return true;
            }
            case 21: {
                pSLanguageResBase.resetPSModuleId();
                return true;
            }
            case 22: {
                pSLanguageResBase.resetPSModuleName();
                return true;
            }
            case 23: {
                pSLanguageResBase.resetPSSysAppId();
                return true;
            }
            case 24: {
                pSLanguageResBase.resetPSSysAppName();
                return true;
            }
            case 25: {
                pSLanguageResBase.resetPSSysLanResId();
                return true;
            }
            case 26: {
                pSLanguageResBase.resetPSSysLanResName();
                return true;
            }
            case 27: {
                pSLanguageResBase.resetPSSystemId();
                return true;
            }
            case 28: {
                pSLanguageResBase.resetPSSystemName();
                return true;
            }
            case 29: {
                pSLanguageResBase.resetPSWFId();
                return true;
            }
            case 30: {
                pSLanguageResBase.resetPSWFName();
                return true;
            }
            case 31: {
                pSLanguageResBase.resetPSWFVersionId();
                return true;
            }
            case 32: {
                pSLanguageResBase.resetPSWFVersionName();
                return true;
            }
            case 33: {
                pSLanguageResBase.resetShortTag();
                return true;
            }
            case 34: {
                pSLanguageResBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSLanguageResBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSLanguageResBase.resetUserData();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
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
    public PSSysLanRes getPSSysLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysLanRes();
        }
        if (this.getPSSysLanResId() == null) {
            return null;
        }
        Integer n = this.objPSSysLanResLock;
        synchronized (n) {
            if (this.pssyslanres != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysLanResId(), (Object)this.pssyslanres.getPSSysLanResId()) != 0L) {
                this.pssyslanres = null;
            }
            if (this.pssyslanres == null) {
                PSSysLanRes pSSysLanRes = new PSSysLanRes();
                pSSysLanRes.setPSSysLanResId(this.getPSSysLanResId());
                PSSysLanResService pSSysLanResService = (PSSysLanResService)ServiceGlobal.getService(PSSysLanResService.class, (SessionFactory)this.getSessionFactory());
                pSSysLanResService.autoGet((IEntity)pSSysLanRes);
                this.pssyslanres = pSSysLanRes;
            }
            return this.pssyslanres;
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
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWF();
        }
        if (this.getPSWFId() == null) {
            return null;
        }
        Integer n = this.objPSWFLock;
        synchronized (n) {
            if (this.pswf != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFId(), (Object)this.pswf.getPSWorkflowId()) != 0L) {
                this.pswf = null;
            }
            if (this.pswf == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWFId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.pswf = pSWorkflow;
            }
            return this.pswf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSLanguageItem> getPSLanguageItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageItems();
        }
        if (this.getPSLanguageResId() == null) {
            return null;
        }
        PSLanguageItemService pSLanguageItemService = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSLanguageItemsLock;
        synchronized (n) {
            if (this.pslanguageitems == null) {
                this.pslanguageitems = pSLanguageItemService.selectByPSLanguageRes(this);
            }
            return this.pslanguageitems;
        }
    }

    private PSLanguageResBase getProxyEntity() {
        return this.proxyPSLanguageResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSLanguageResBase = null;
        if (iDataObject != null && iDataObject instanceof PSLanguageResBase) {
            this.proxyPSLanguageResBase = (PSLanguageResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPREFFLAG, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CONTENT, 2);
        fieldIndexMap.put(FIELD_CONTENT2, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_LANRESTAG, 6);
        fieldIndexMap.put(FIELD_LANRESTYPE, 7);
        fieldIndexMap.put(FIELD_LOCKFLAG, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 10);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 11);
        fieldIndexMap.put(FIELD_PSDEFID, 12);
        fieldIndexMap.put(FIELD_PSDEFNAME, 13);
        fieldIndexMap.put(FIELD_PSDEID, 14);
        fieldIndexMap.put(FIELD_PSDENAME, 15);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 16);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 17);
        fieldIndexMap.put(FIELD_PSLANGUAGERESID, 18);
        fieldIndexMap.put(FIELD_PSLANGUAGERESNAME, 19);
        fieldIndexMap.put(FIELD_PSLANITEMSCNT, 20);
        fieldIndexMap.put(FIELD_PSMODULEID, 21);
        fieldIndexMap.put(FIELD_PSMODULENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 23);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSLANRESID, 25);
        fieldIndexMap.put(FIELD_PSSYSLANRESNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 27);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 28);
        fieldIndexMap.put(FIELD_PSWFID, 29);
        fieldIndexMap.put(FIELD_PSWFNAME, 30);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 31);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 32);
        fieldIndexMap.put(FIELD_SHORTTAG, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_USERDATA, 36);
    }
}

