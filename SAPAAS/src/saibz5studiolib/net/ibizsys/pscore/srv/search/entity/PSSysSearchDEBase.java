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
package net.ibizsys.pscore.srv.search.entity;

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
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDEField;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDocService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchDEBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAG = "DETAG";
    public static final String FIELD_DETAG2 = "DETAG2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NOSQLFLAG = "NOSQLFLAG";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSSEARCHDEID = "PSSYSSEARCHDEID";
    public static final String FIELD_PSSYSSEARCHDENAME = "PSSYSSEARCHDENAME";
    public static final String FIELD_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String FIELD_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String FIELD_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String FIELD_THREADRUNMODE = "THREADRUNMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DETAG = 3;
    private static final int INDEX_DETAG2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_NOSQLFLAG = 6;
    private static final int INDEX_PSDEID = 7;
    private static final int INDEX_PSDENAME = 8;
    private static final int INDEX_PSSYSSEARCHDEID = 9;
    private static final int INDEX_PSSYSSEARCHDENAME = 10;
    private static final int INDEX_PSSYSSEARCHDOCID = 11;
    private static final int INDEX_PSSYSSEARCHDOCNAME = 12;
    private static final int INDEX_PSSYSSEARCHSCHEMEID = 13;
    private static final int INDEX_PSSYSSEARCHSCHEMENAME = 14;
    private static final int INDEX_THREADRUNMODE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSearchDEBase proxyPSSysSearchDEBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detagDirtyFlag = false;
    private boolean detag2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nosqlflagDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssyssearchdeidDirtyFlag = false;
    private boolean pssyssearchdenameDirtyFlag = false;
    private boolean pssyssearchdocidDirtyFlag = false;
    private boolean pssyssearchdocnameDirtyFlag = false;
    private boolean pssyssearchschemeidDirtyFlag = false;
    private boolean pssyssearchschemenameDirtyFlag = false;
    private boolean threadrunmodeDirtyFlag = false;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detag")
    private String detag;
    @Column(name="detag2")
    private String detag2;
    @Column(name="memo")
    private String memo;
    @Column(name="nosqlflag")
    private Integer nosqlflag;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssyssearchdeid")
    private String pssyssearchdeid;
    @Column(name="pssyssearchdename")
    private String pssyssearchdename;
    @Column(name="pssyssearchdocid")
    private String pssyssearchdocid;
    @Column(name="pssyssearchdocname")
    private String pssyssearchdocname;
    @Column(name="pssyssearchschemeid")
    private String pssyssearchschemeid;
    @Column(name="pssyssearchschemename")
    private String pssyssearchschemename;
    @Column(name="threadrunmode")
    private Integer threadrunmode;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysSearchDocLock = new Integer(1);
    private PSSysSearchDoc pssyssearchdoc = null;
    private Integer objPSSysSearchSchemeLock = new Integer(1);
    private PSSysSearchScheme pssyssearchscheme = null;
    private Integer objPSSysSearchDEFieldsLock = new Integer(1);
    private ArrayList<PSSysSearchDEField> pssyssearchdefields = null;

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

    public void setDETag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag = string;
        this.detagDirtyFlag = true;
    }

    public String getDETag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag();
        }
        return this.detag;
    }

    public boolean isDETagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETagDirty();
        }
        return this.detagDirtyFlag;
    }

    public void resetDETag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag();
            return;
        }
        this.detagDirtyFlag = false;
        this.detag = null;
    }

    public void setDETag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detag2 = string;
        this.detag2DirtyFlag = true;
    }

    public String getDETag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETag2();
        }
        return this.detag2;
    }

    public boolean isDETag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETag2Dirty();
        }
        return this.detag2DirtyFlag;
    }

    public void resetDETag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETag2();
            return;
        }
        this.detag2DirtyFlag = false;
        this.detag2 = null;
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

    public void setNoSQLFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoSQLFlag(n);
            return;
        }
        this.nosqlflag = n;
        this.nosqlflagDirtyFlag = true;
    }

    public Integer getNoSQLFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoSQLFlag();
        }
        return this.nosqlflag;
    }

    public boolean isNoSQLFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoSQLFlagDirty();
        }
        return this.nosqlflagDirtyFlag;
    }

    public void resetNoSQLFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoSQLFlag();
            return;
        }
        this.nosqlflagDirtyFlag = false;
        this.nosqlflag = null;
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

    public void setPSSysSearchDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdeid = string;
        this.pssyssearchdeidDirtyFlag = true;
    }

    public String getPSSysSearchDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEId();
        }
        return this.pssyssearchdeid;
    }

    public boolean isPSSysSearchDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDEIdDirty();
        }
        return this.pssyssearchdeidDirtyFlag;
    }

    public void resetPSSysSearchDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDEId();
            return;
        }
        this.pssyssearchdeidDirtyFlag = false;
        this.pssyssearchdeid = null;
    }

    public void setPSSysSearchDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdename = string;
        this.pssyssearchdenameDirtyFlag = true;
    }

    public String getPSSysSearchDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEName();
        }
        return this.pssyssearchdename;
    }

    public boolean isPSSysSearchDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDENameDirty();
        }
        return this.pssyssearchdenameDirtyFlag;
    }

    public void resetPSSysSearchDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDEName();
            return;
        }
        this.pssyssearchdenameDirtyFlag = false;
        this.pssyssearchdename = null;
    }

    public void setPSSysSearchDocId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocid = string;
        this.pssyssearchdocidDirtyFlag = true;
    }

    public String getPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocId();
        }
        return this.pssyssearchdocid;
    }

    public boolean isPSSysSearchDocIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocIdDirty();
        }
        return this.pssyssearchdocidDirtyFlag;
    }

    public void resetPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocId();
            return;
        }
        this.pssyssearchdocidDirtyFlag = false;
        this.pssyssearchdocid = null;
    }

    public void setPSSysSearchDocName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocname = string;
        this.pssyssearchdocnameDirtyFlag = true;
    }

    public String getPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocName();
        }
        return this.pssyssearchdocname;
    }

    public boolean isPSSysSearchDocNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocNameDirty();
        }
        return this.pssyssearchdocnameDirtyFlag;
    }

    public void resetPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocName();
            return;
        }
        this.pssyssearchdocnameDirtyFlag = false;
        this.pssyssearchdocname = null;
    }

    public void setPSSysSearchSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemeid = string;
        this.pssyssearchschemeidDirtyFlag = true;
    }

    public String getPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeId();
        }
        return this.pssyssearchschemeid;
    }

    public boolean isPSSysSearchSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeIdDirty();
        }
        return this.pssyssearchschemeidDirtyFlag;
    }

    public void resetPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeId();
            return;
        }
        this.pssyssearchschemeidDirtyFlag = false;
        this.pssyssearchschemeid = null;
    }

    public void setPSSysSearchSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemename = string;
        this.pssyssearchschemenameDirtyFlag = true;
    }

    public String getPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeName();
        }
        return this.pssyssearchschemename;
    }

    public boolean isPSSysSearchSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeNameDirty();
        }
        return this.pssyssearchschemenameDirtyFlag;
    }

    public void resetPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeName();
            return;
        }
        this.pssyssearchschemenameDirtyFlag = false;
        this.pssyssearchschemename = null;
    }

    public void setThreadRunMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadRunMode(n);
            return;
        }
        this.threadrunmode = n;
        this.threadrunmodeDirtyFlag = true;
    }

    public Integer getThreadRunMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadRunMode();
        }
        return this.threadrunmode;
    }

    public boolean isThreadRunModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadRunModeDirty();
        }
        return this.threadrunmodeDirtyFlag;
    }

    public void resetThreadRunMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadRunMode();
            return;
        }
        this.threadrunmodeDirtyFlag = false;
        this.threadrunmode = null;
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
        PSSysSearchDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchDEBase pSSysSearchDEBase) {
        pSSysSearchDEBase.resetCodeName();
        pSSysSearchDEBase.resetCreateDate();
        pSSysSearchDEBase.resetCreateMan();
        pSSysSearchDEBase.resetDETag();
        pSSysSearchDEBase.resetDETag2();
        pSSysSearchDEBase.resetMemo();
        pSSysSearchDEBase.resetNoSQLFlag();
        pSSysSearchDEBase.resetPSDEId();
        pSSysSearchDEBase.resetPSDEName();
        pSSysSearchDEBase.resetPSSysSearchDEId();
        pSSysSearchDEBase.resetPSSysSearchDEName();
        pSSysSearchDEBase.resetPSSysSearchDocId();
        pSSysSearchDEBase.resetPSSysSearchDocName();
        pSSysSearchDEBase.resetPSSysSearchSchemeId();
        pSSysSearchDEBase.resetPSSysSearchSchemeName();
        pSSysSearchDEBase.resetThreadRunMode();
        pSSysSearchDEBase.resetUpdateDate();
        pSSysSearchDEBase.resetUpdateMan();
        pSSysSearchDEBase.resetUserCat();
        pSSysSearchDEBase.resetUserTag();
        pSSysSearchDEBase.resetUserTag2();
        pSSysSearchDEBase.resetUserTag3();
        pSSysSearchDEBase.resetUserTag4();
        pSSysSearchDEBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDETagDirty()) {
            hashMap.put(FIELD_DETAG, this.getDETag());
        }
        if (!bl || this.isDETag2Dirty()) {
            hashMap.put(FIELD_DETAG2, this.getDETag2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNoSQLFlagDirty()) {
            hashMap.put(FIELD_NOSQLFLAG, this.getNoSQLFlag());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysSearchDEIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDEID, this.getPSSysSearchDEId());
        }
        if (!bl || this.isPSSysSearchDENameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDENAME, this.getPSSysSearchDEName());
        }
        if (!bl || this.isPSSysSearchDocIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCID, this.getPSSysSearchDocId());
        }
        if (!bl || this.isPSSysSearchDocNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCNAME, this.getPSSysSearchDocName());
        }
        if (!bl || this.isPSSysSearchSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMEID, this.getPSSysSearchSchemeId());
        }
        if (!bl || this.isPSSysSearchSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMENAME, this.getPSSysSearchSchemeName());
        }
        if (!bl || this.isThreadRunModeDirty()) {
            hashMap.put(FIELD_THREADRUNMODE, this.getThreadRunMode());
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
        return PSSysSearchDEBase.get(this, n);
    }

    private static Object get(PSSysSearchDEBase pSSysSearchDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDEBase.getCodeName();
            }
            case 1: {
                return pSSysSearchDEBase.getCreateDate();
            }
            case 2: {
                return pSSysSearchDEBase.getCreateMan();
            }
            case 3: {
                return pSSysSearchDEBase.getDETag();
            }
            case 4: {
                return pSSysSearchDEBase.getDETag2();
            }
            case 5: {
                return pSSysSearchDEBase.getMemo();
            }
            case 6: {
                return pSSysSearchDEBase.getNoSQLFlag();
            }
            case 7: {
                return pSSysSearchDEBase.getPSDEId();
            }
            case 8: {
                return pSSysSearchDEBase.getPSDEName();
            }
            case 9: {
                return pSSysSearchDEBase.getPSSysSearchDEId();
            }
            case 10: {
                return pSSysSearchDEBase.getPSSysSearchDEName();
            }
            case 11: {
                return pSSysSearchDEBase.getPSSysSearchDocId();
            }
            case 12: {
                return pSSysSearchDEBase.getPSSysSearchDocName();
            }
            case 13: {
                return pSSysSearchDEBase.getPSSysSearchSchemeId();
            }
            case 14: {
                return pSSysSearchDEBase.getPSSysSearchSchemeName();
            }
            case 15: {
                return pSSysSearchDEBase.getThreadRunMode();
            }
            case 16: {
                return pSSysSearchDEBase.getUpdateDate();
            }
            case 17: {
                return pSSysSearchDEBase.getUpdateMan();
            }
            case 18: {
                return pSSysSearchDEBase.getUserCat();
            }
            case 19: {
                return pSSysSearchDEBase.getUserTag();
            }
            case 20: {
                return pSSysSearchDEBase.getUserTag2();
            }
            case 21: {
                return pSSysSearchDEBase.getUserTag3();
            }
            case 22: {
                return pSSysSearchDEBase.getUserTag4();
            }
            case 23: {
                return pSSysSearchDEBase.getValidFlag();
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
        PSSysSearchDEBase.set(this, n, object);
    }

    private static void set(PSSysSearchDEBase pSSysSearchDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchDEBase.setDETag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchDEBase.setDETag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchDEBase.setNoSQLFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchDEBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchDEBase.setPSSysSearchDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchDEBase.setPSSysSearchDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchDEBase.setPSSysSearchDocId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchDEBase.setPSSysSearchDocName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchDEBase.setPSSysSearchSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchDEBase.setPSSysSearchSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchDEBase.setThreadRunMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchDEBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchDEBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchDEBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchDEBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchDEBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSearchDEBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysSearchDEBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchDEBase pSSysSearchDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDEBase.getCodeName() == null;
            }
            case 1: {
                return pSSysSearchDEBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSearchDEBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSearchDEBase.getDETag() == null;
            }
            case 4: {
                return pSSysSearchDEBase.getDETag2() == null;
            }
            case 5: {
                return pSSysSearchDEBase.getMemo() == null;
            }
            case 6: {
                return pSSysSearchDEBase.getNoSQLFlag() == null;
            }
            case 7: {
                return pSSysSearchDEBase.getPSDEId() == null;
            }
            case 8: {
                return pSSysSearchDEBase.getPSDEName() == null;
            }
            case 9: {
                return pSSysSearchDEBase.getPSSysSearchDEId() == null;
            }
            case 10: {
                return pSSysSearchDEBase.getPSSysSearchDEName() == null;
            }
            case 11: {
                return pSSysSearchDEBase.getPSSysSearchDocId() == null;
            }
            case 12: {
                return pSSysSearchDEBase.getPSSysSearchDocName() == null;
            }
            case 13: {
                return pSSysSearchDEBase.getPSSysSearchSchemeId() == null;
            }
            case 14: {
                return pSSysSearchDEBase.getPSSysSearchSchemeName() == null;
            }
            case 15: {
                return pSSysSearchDEBase.getThreadRunMode() == null;
            }
            case 16: {
                return pSSysSearchDEBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysSearchDEBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysSearchDEBase.getUserCat() == null;
            }
            case 19: {
                return pSSysSearchDEBase.getUserTag() == null;
            }
            case 20: {
                return pSSysSearchDEBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysSearchDEBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysSearchDEBase.getUserTag4() == null;
            }
            case 23: {
                return pSSysSearchDEBase.getValidFlag() == null;
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
        return PSSysSearchDEBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchDEBase pSSysSearchDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchDEBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysSearchDEBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSearchDEBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSearchDEBase.isDETagDirty();
            }
            case 4: {
                return pSSysSearchDEBase.isDETag2Dirty();
            }
            case 5: {
                return pSSysSearchDEBase.isMemoDirty();
            }
            case 6: {
                return pSSysSearchDEBase.isNoSQLFlagDirty();
            }
            case 7: {
                return pSSysSearchDEBase.isPSDEIdDirty();
            }
            case 8: {
                return pSSysSearchDEBase.isPSDENameDirty();
            }
            case 9: {
                return pSSysSearchDEBase.isPSSysSearchDEIdDirty();
            }
            case 10: {
                return pSSysSearchDEBase.isPSSysSearchDENameDirty();
            }
            case 11: {
                return pSSysSearchDEBase.isPSSysSearchDocIdDirty();
            }
            case 12: {
                return pSSysSearchDEBase.isPSSysSearchDocNameDirty();
            }
            case 13: {
                return pSSysSearchDEBase.isPSSysSearchSchemeIdDirty();
            }
            case 14: {
                return pSSysSearchDEBase.isPSSysSearchSchemeNameDirty();
            }
            case 15: {
                return pSSysSearchDEBase.isThreadRunModeDirty();
            }
            case 16: {
                return pSSysSearchDEBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysSearchDEBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysSearchDEBase.isUserCatDirty();
            }
            case 19: {
                return pSSysSearchDEBase.isUserTagDirty();
            }
            case 20: {
                return pSSysSearchDEBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysSearchDEBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysSearchDEBase.isUserTag4Dirty();
            }
            case 23: {
                return pSSysSearchDEBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchDEBase pSSysSearchDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getDETag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getDETag()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getDETag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detag2", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getDETag2()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getNoSQLFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosqlflag", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getNoSQLFlag()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdeid", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSSysSearchDEId()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdename", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSSysSearchDEName()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDocId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocid", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSSysSearchDocId()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDocName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocname", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSSysSearchDocName()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemeid", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSSysSearchSchemeId()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemename", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getPSSysSearchSchemeName()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getThreadRunMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadrunmode", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getThreadRunMode()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSearchDEBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSearchDEBase.getJSONValue((Object)pSSysSearchDEBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchDEBase pSSysSearchDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchDEBase.getCodeName() != null) {
            object = pSSysSearchDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getCreateDate() != null) {
            object = pSSysSearchDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchDEBase.getCreateMan() != null) {
            object = pSSysSearchDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getDETag() != null) {
            object = pSSysSearchDEBase.getDETag();
            xmlNode.setAttribute(FIELD_DETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getDETag2() != null) {
            object = pSSysSearchDEBase.getDETag2();
            xmlNode.setAttribute(FIELD_DETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getMemo() != null) {
            object = pSSysSearchDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getNoSQLFlag() != null) {
            object = pSSysSearchDEBase.getNoSQLFlag();
            xmlNode.setAttribute(FIELD_NOSQLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchDEBase.getPSDEId() != null) {
            object = pSSysSearchDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getPSDEName() != null) {
            object = pSSysSearchDEBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDEId() != null) {
            object = pSSysSearchDEBase.getPSSysSearchDEId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDEName() != null) {
            object = pSSysSearchDEBase.getPSSysSearchDEName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDocId() != null) {
            object = pSSysSearchDEBase.getPSSysSearchDocId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchDocName() != null) {
            object = pSSysSearchDEBase.getPSSysSearchDocName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchSchemeId() != null) {
            object = pSSysSearchDEBase.getPSSysSearchSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getPSSysSearchSchemeName() != null) {
            object = pSSysSearchDEBase.getPSSysSearchSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getThreadRunMode() != null) {
            object = pSSysSearchDEBase.getThreadRunMode();
            xmlNode.setAttribute(FIELD_THREADRUNMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchDEBase.getUpdateDate() != null) {
            object = pSSysSearchDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchDEBase.getUpdateMan() != null) {
            object = pSSysSearchDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getUserCat() != null) {
            object = pSSysSearchDEBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getUserTag() != null) {
            object = pSSysSearchDEBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getUserTag2() != null) {
            object = pSSysSearchDEBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getUserTag3() != null) {
            object = pSSysSearchDEBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getUserTag4() != null) {
            object = pSSysSearchDEBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchDEBase.getValidFlag() != null) {
            object = pSSysSearchDEBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchDEBase pSSysSearchDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchDEBase.isCodeNameDirty() && (bl || pSSysSearchDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSearchDEBase.getCodeName());
        }
        if (pSSysSearchDEBase.isCreateDateDirty() && (bl || pSSysSearchDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchDEBase.getCreateDate());
        }
        if (pSSysSearchDEBase.isCreateManDirty() && (bl || pSSysSearchDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchDEBase.getCreateMan());
        }
        if (pSSysSearchDEBase.isDETagDirty() && (bl || pSSysSearchDEBase.getDETag() != null)) {
            iDataObject.set(FIELD_DETAG, (Object)pSSysSearchDEBase.getDETag());
        }
        if (pSSysSearchDEBase.isDETag2Dirty() && (bl || pSSysSearchDEBase.getDETag2() != null)) {
            iDataObject.set(FIELD_DETAG2, (Object)pSSysSearchDEBase.getDETag2());
        }
        if (pSSysSearchDEBase.isMemoDirty() && (bl || pSSysSearchDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchDEBase.getMemo());
        }
        if (pSSysSearchDEBase.isNoSQLFlagDirty() && (bl || pSSysSearchDEBase.getNoSQLFlag() != null)) {
            iDataObject.set(FIELD_NOSQLFLAG, (Object)pSSysSearchDEBase.getNoSQLFlag());
        }
        if (pSSysSearchDEBase.isPSDEIdDirty() && (bl || pSSysSearchDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysSearchDEBase.getPSDEId());
        }
        if (pSSysSearchDEBase.isPSDENameDirty() && (bl || pSSysSearchDEBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysSearchDEBase.getPSDEName());
        }
        if (pSSysSearchDEBase.isPSSysSearchDEIdDirty() && (bl || pSSysSearchDEBase.getPSSysSearchDEId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDEID, (Object)pSSysSearchDEBase.getPSSysSearchDEId());
        }
        if (pSSysSearchDEBase.isPSSysSearchDENameDirty() && (bl || pSSysSearchDEBase.getPSSysSearchDEName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDENAME, (Object)pSSysSearchDEBase.getPSSysSearchDEName());
        }
        if (pSSysSearchDEBase.isPSSysSearchDocIdDirty() && (bl || pSSysSearchDEBase.getPSSysSearchDocId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCID, (Object)pSSysSearchDEBase.getPSSysSearchDocId());
        }
        if (pSSysSearchDEBase.isPSSysSearchDocNameDirty() && (bl || pSSysSearchDEBase.getPSSysSearchDocName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCNAME, (Object)pSSysSearchDEBase.getPSSysSearchDocName());
        }
        if (pSSysSearchDEBase.isPSSysSearchSchemeIdDirty() && (bl || pSSysSearchDEBase.getPSSysSearchSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMEID, (Object)pSSysSearchDEBase.getPSSysSearchSchemeId());
        }
        if (pSSysSearchDEBase.isPSSysSearchSchemeNameDirty() && (bl || pSSysSearchDEBase.getPSSysSearchSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMENAME, (Object)pSSysSearchDEBase.getPSSysSearchSchemeName());
        }
        if (pSSysSearchDEBase.isThreadRunModeDirty() && (bl || pSSysSearchDEBase.getThreadRunMode() != null)) {
            iDataObject.set(FIELD_THREADRUNMODE, (Object)pSSysSearchDEBase.getThreadRunMode());
        }
        if (pSSysSearchDEBase.isUpdateDateDirty() && (bl || pSSysSearchDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchDEBase.getUpdateDate());
        }
        if (pSSysSearchDEBase.isUpdateManDirty() && (bl || pSSysSearchDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchDEBase.getUpdateMan());
        }
        if (pSSysSearchDEBase.isUserCatDirty() && (bl || pSSysSearchDEBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSearchDEBase.getUserCat());
        }
        if (pSSysSearchDEBase.isUserTagDirty() && (bl || pSSysSearchDEBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchDEBase.getUserTag());
        }
        if (pSSysSearchDEBase.isUserTag2Dirty() && (bl || pSSysSearchDEBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchDEBase.getUserTag2());
        }
        if (pSSysSearchDEBase.isUserTag3Dirty() && (bl || pSSysSearchDEBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSearchDEBase.getUserTag3());
        }
        if (pSSysSearchDEBase.isUserTag4Dirty() && (bl || pSSysSearchDEBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSearchDEBase.getUserTag4());
        }
        if (pSSysSearchDEBase.isValidFlagDirty() && (bl || pSSysSearchDEBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSearchDEBase.getValidFlag());
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
        return PSSysSearchDEBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchDEBase pSSysSearchDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchDEBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysSearchDEBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSearchDEBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSearchDEBase.resetDETag();
                return true;
            }
            case 4: {
                pSSysSearchDEBase.resetDETag2();
                return true;
            }
            case 5: {
                pSSysSearchDEBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysSearchDEBase.resetNoSQLFlag();
                return true;
            }
            case 7: {
                pSSysSearchDEBase.resetPSDEId();
                return true;
            }
            case 8: {
                pSSysSearchDEBase.resetPSDEName();
                return true;
            }
            case 9: {
                pSSysSearchDEBase.resetPSSysSearchDEId();
                return true;
            }
            case 10: {
                pSSysSearchDEBase.resetPSSysSearchDEName();
                return true;
            }
            case 11: {
                pSSysSearchDEBase.resetPSSysSearchDocId();
                return true;
            }
            case 12: {
                pSSysSearchDEBase.resetPSSysSearchDocName();
                return true;
            }
            case 13: {
                pSSysSearchDEBase.resetPSSysSearchSchemeId();
                return true;
            }
            case 14: {
                pSSysSearchDEBase.resetPSSysSearchSchemeName();
                return true;
            }
            case 15: {
                pSSysSearchDEBase.resetThreadRunMode();
                return true;
            }
            case 16: {
                pSSysSearchDEBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysSearchDEBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysSearchDEBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysSearchDEBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysSearchDEBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysSearchDEBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysSearchDEBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSSysSearchDEBase.resetValidFlag();
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
    public PSSysSearchDoc getPSSysSearchDoc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDoc();
        }
        if (this.getPSSysSearchDocId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchDocLock;
        synchronized (n) {
            if (this.pssyssearchdoc != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchDocId(), (Object)this.pssyssearchdoc.getPSSysSearchDocId()) != 0L) {
                this.pssyssearchdoc = null;
            }
            if (this.pssyssearchdoc == null) {
                PSSysSearchDoc pSSysSearchDoc = new PSSysSearchDoc();
                pSSysSearchDoc.setPSSysSearchDocId(this.getPSSysSearchDocId());
                PSSysSearchDocService pSSysSearchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchDocService.autoGet(pSSysSearchDoc);
                this.pssyssearchdoc = pSSysSearchDoc;
            }
            return this.pssyssearchdoc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchScheme getPSSysSearchScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchScheme();
        }
        if (this.getPSSysSearchSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchSchemeLock;
        synchronized (n) {
            if (this.pssyssearchscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchSchemeId(), (Object)this.pssyssearchscheme.getPSSysSearchSchemeId()) != 0L) {
                this.pssyssearchscheme = null;
            }
            if (this.pssyssearchscheme == null) {
                PSSysSearchScheme pSSysSearchScheme = new PSSysSearchScheme();
                pSSysSearchScheme.setPSSysSearchSchemeId(this.getPSSysSearchSchemeId());
                PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchSchemeService.autoGet(pSSysSearchScheme);
                this.pssyssearchscheme = pSSysSearchScheme;
            }
            return this.pssyssearchscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchDEField> getPSSysSearchDEFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEFields();
        }
        if (this.getPSSysSearchDEId() == null) {
            return null;
        }
        PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchDEFieldsLock;
        synchronized (n) {
            if (this.pssyssearchdefields == null) {
                this.pssyssearchdefields = pSSysSearchDEFieldService.selectByPSSysSearchDE(this);
            }
            return this.pssyssearchdefields;
        }
    }

    private PSSysSearchDEBase getProxyEntity() {
        return this.proxyPSSysSearchDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchDEBase) {
            this.proxyPSSysSearchDEBase = (PSSysSearchDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DETAG, 3);
        fieldIndexMap.put(FIELD_DETAG2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_NOSQLFLAG, 6);
        fieldIndexMap.put(FIELD_PSDEID, 7);
        fieldIndexMap.put(FIELD_PSDENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDEID, 9);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCID, 11);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMEID, 13);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMENAME, 14);
        fieldIndexMap.put(FIELD_THREADRUNMODE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
    }
}

