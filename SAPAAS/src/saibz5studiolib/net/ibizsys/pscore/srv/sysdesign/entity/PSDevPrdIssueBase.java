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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdIssueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdIssueBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISSUESN = "ISSUESN";
    public static final String FIELD_ISSUESTATE = "ISSUESTATE";
    public static final String FIELD_ISSUETYPE = "ISSUETYPE";
    public static final String FIELD_LOGTIME = "LOGTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDISSUEID = "PSDEVPRDISSUEID";
    public static final String FIELD_PSDEVPRDISSUENAME = "PSDEVPRDISSUENAME";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVPRDSUBVERID = "PSDEVPRDSUBVERID";
    public static final String FIELD_PSDEVPRDSUBVERNAME = "PSDEVPRDSUBVERNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_SOLVEDCONTENT = "SOLVEDCONTENT";
    public static final String FIELD_SOLVEDTIME = "SOLVEDTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ISSUESN = 3;
    private static final int INDEX_ISSUESTATE = 4;
    private static final int INDEX_ISSUETYPE = 5;
    private static final int INDEX_LOGTIME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEVPRDID = 8;
    private static final int INDEX_PSDEVPRDISSUEID = 9;
    private static final int INDEX_PSDEVPRDISSUENAME = 10;
    private static final int INDEX_PSDEVPRDNAME = 11;
    private static final int INDEX_PSDEVPRDSUBVERID = 12;
    private static final int INDEX_PSDEVPRDSUBVERNAME = 13;
    private static final int INDEX_PSDEVPRDVERID = 14;
    private static final int INDEX_PSDEVPRDVERNAME = 15;
    private static final int INDEX_SOLVEDCONTENT = 16;
    private static final int INDEX_SOLVEDTIME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdIssueBase proxyPSDevPrdIssueBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issuesnDirtyFlag = false;
    private boolean issuestateDirtyFlag = false;
    private boolean issuetypeDirtyFlag = false;
    private boolean logtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdissueidDirtyFlag = false;
    private boolean psdevprdissuenameDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevprdsubveridDirtyFlag = false;
    private boolean psdevprdsubvernameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean solvedcontentDirtyFlag = false;
    private boolean solvedtimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issuesn")
    private String issuesn;
    @Column(name="issuestate")
    private String issuestate;
    @Column(name="issuetype")
    private Integer issuetype;
    @Column(name="logtime")
    private Timestamp logtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdissueid")
    private String psdevprdissueid;
    @Column(name="psdevprdissuename")
    private String psdevprdissuename;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevprdsubverid")
    private String psdevprdsubverid;
    @Column(name="psdevprdsubvername")
    private String psdevprdsubvername;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="solvedcontent")
    private String solvedcontent;
    @Column(name="solvedtime")
    private Timestamp solvedtime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDevPrdSubVerLock = new Integer(1);
    private PSDevPrdSubVer psdevprdsubver = null;
    private Integer objPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer psdevprdver = null;
    private Integer objPSDevPrdLock = new Integer(1);
    private PSDevPrd psdevprd = null;

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

    public void setIssueSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuesn = string;
        this.issuesnDirtyFlag = true;
    }

    public String getIssueSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueSN();
        }
        return this.issuesn;
    }

    public boolean isIssueSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueSNDirty();
        }
        return this.issuesnDirtyFlag;
    }

    public void resetIssueSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueSN();
            return;
        }
        this.issuesnDirtyFlag = false;
        this.issuesn = null;
    }

    public void setIssueState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuestate = string;
        this.issuestateDirtyFlag = true;
    }

    public String getIssueState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueState();
        }
        return this.issuestate;
    }

    public boolean isIssueStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueStateDirty();
        }
        return this.issuestateDirtyFlag;
    }

    public void resetIssueState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueState();
            return;
        }
        this.issuestateDirtyFlag = false;
        this.issuestate = null;
    }

    public void setIssueType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueType(n);
            return;
        }
        this.issuetype = n;
        this.issuetypeDirtyFlag = true;
    }

    public Integer getIssueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueType();
        }
        return this.issuetype;
    }

    public boolean isIssueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueTypeDirty();
        }
        return this.issuetypeDirtyFlag;
    }

    public void resetIssueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueType();
            return;
        }
        this.issuetypeDirtyFlag = false;
        this.issuetype = null;
    }

    public void setLogTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogTime(timestamp);
            return;
        }
        this.logtime = timestamp;
        this.logtimeDirtyFlag = true;
    }

    public Timestamp getLogTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogTime();
        }
        return this.logtime;
    }

    public boolean isLogTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogTimeDirty();
        }
        return this.logtimeDirtyFlag;
    }

    public void resetLogTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogTime();
            return;
        }
        this.logtimeDirtyFlag = false;
        this.logtime = null;
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

    public void setPSDevPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdid = string;
        this.psdevprdidDirtyFlag = true;
    }

    public String getPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdId();
        }
        return this.psdevprdid;
    }

    public boolean isPSDevPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIdDirty();
        }
        return this.psdevprdidDirtyFlag;
    }

    public void resetPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdId();
            return;
        }
        this.psdevprdidDirtyFlag = false;
        this.psdevprdid = null;
    }

    public void setPSDevPrdIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdissueid = string;
        this.psdevprdissueidDirtyFlag = true;
    }

    public String getPSDevPrdIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssueId();
        }
        return this.psdevprdissueid;
    }

    public boolean isPSDevPrdIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIssueIdDirty();
        }
        return this.psdevprdissueidDirtyFlag;
    }

    public void resetPSDevPrdIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdIssueId();
            return;
        }
        this.psdevprdissueidDirtyFlag = false;
        this.psdevprdissueid = null;
    }

    public void setPSDevPrdIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdissuename = string;
        this.psdevprdissuenameDirtyFlag = true;
    }

    public String getPSDevPrdIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdIssueName();
        }
        return this.psdevprdissuename;
    }

    public boolean isPSDevPrdIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIssueNameDirty();
        }
        return this.psdevprdissuenameDirtyFlag;
    }

    public void resetPSDevPrdIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdIssueName();
            return;
        }
        this.psdevprdissuenameDirtyFlag = false;
        this.psdevprdissuename = null;
    }

    public void setPSDevPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdname = string;
        this.psdevprdnameDirtyFlag = true;
    }

    public String getPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdName();
        }
        return this.psdevprdname;
    }

    public boolean isPSDevPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdNameDirty();
        }
        return this.psdevprdnameDirtyFlag;
    }

    public void resetPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdName();
            return;
        }
        this.psdevprdnameDirtyFlag = false;
        this.psdevprdname = null;
    }

    public void setPSDevPrdSubVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubverid = string;
        this.psdevprdsubveridDirtyFlag = true;
    }

    public String getPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerId();
        }
        return this.psdevprdsubverid;
    }

    public boolean isPSDevPrdSubVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerIdDirty();
        }
        return this.psdevprdsubveridDirtyFlag;
    }

    public void resetPSDevPrdSubVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerId();
            return;
        }
        this.psdevprdsubveridDirtyFlag = false;
        this.psdevprdsubverid = null;
    }

    public void setPSDevPrdSubVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSubVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsubvername = string;
        this.psdevprdsubvernameDirtyFlag = true;
    }

    public String getPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVerName();
        }
        return this.psdevprdsubvername;
    }

    public boolean isPSDevPrdSubVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSubVerNameDirty();
        }
        return this.psdevprdsubvernameDirtyFlag;
    }

    public void resetPSDevPrdSubVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSubVerName();
            return;
        }
        this.psdevprdsubvernameDirtyFlag = false;
        this.psdevprdsubvername = null;
    }

    public void setPSDevPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdverid = string;
        this.psdevprdveridDirtyFlag = true;
    }

    public String getPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerId();
        }
        return this.psdevprdverid;
    }

    public boolean isPSDevPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerIdDirty();
        }
        return this.psdevprdveridDirtyFlag;
    }

    public void resetPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerId();
            return;
        }
        this.psdevprdveridDirtyFlag = false;
        this.psdevprdverid = null;
    }

    public void setPSDevPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdvername = string;
        this.psdevprdvernameDirtyFlag = true;
    }

    public String getPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerName();
        }
        return this.psdevprdvername;
    }

    public boolean isPSDevPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerNameDirty();
        }
        return this.psdevprdvernameDirtyFlag;
    }

    public void resetPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerName();
            return;
        }
        this.psdevprdvernameDirtyFlag = false;
        this.psdevprdvername = null;
    }

    public void setSolvedContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSolvedContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.solvedcontent = string;
        this.solvedcontentDirtyFlag = true;
    }

    public String getSolvedContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSolvedContent();
        }
        return this.solvedcontent;
    }

    public boolean isSolvedContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSolvedContentDirty();
        }
        return this.solvedcontentDirtyFlag;
    }

    public void resetSolvedContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSolvedContent();
            return;
        }
        this.solvedcontentDirtyFlag = false;
        this.solvedcontent = null;
    }

    public void setSolvedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSolvedTime(timestamp);
            return;
        }
        this.solvedtime = timestamp;
        this.solvedtimeDirtyFlag = true;
    }

    public Timestamp getSolvedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSolvedTime();
        }
        return this.solvedtime;
    }

    public boolean isSolvedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSolvedTimeDirty();
        }
        return this.solvedtimeDirtyFlag;
    }

    public void resetSolvedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSolvedTime();
            return;
        }
        this.solvedtimeDirtyFlag = false;
        this.solvedtime = null;
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

    protected void onReset() {
        PSDevPrdIssueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdIssueBase pSDevPrdIssueBase) {
        pSDevPrdIssueBase.resetContent();
        pSDevPrdIssueBase.resetCreateDate();
        pSDevPrdIssueBase.resetCreateMan();
        pSDevPrdIssueBase.resetIssueSN();
        pSDevPrdIssueBase.resetIssueState();
        pSDevPrdIssueBase.resetIssueType();
        pSDevPrdIssueBase.resetLogTime();
        pSDevPrdIssueBase.resetMemo();
        pSDevPrdIssueBase.resetPSDevPrdId();
        pSDevPrdIssueBase.resetPSDevPrdIssueId();
        pSDevPrdIssueBase.resetPSDevPrdIssueName();
        pSDevPrdIssueBase.resetPSDevPrdName();
        pSDevPrdIssueBase.resetPSDevPrdSubVerId();
        pSDevPrdIssueBase.resetPSDevPrdSubVerName();
        pSDevPrdIssueBase.resetPSDevPrdVerId();
        pSDevPrdIssueBase.resetPSDevPrdVerName();
        pSDevPrdIssueBase.resetSolvedContent();
        pSDevPrdIssueBase.resetSolvedTime();
        pSDevPrdIssueBase.resetUpdateDate();
        pSDevPrdIssueBase.resetUpdateMan();
        pSDevPrdIssueBase.resetUserTag();
        pSDevPrdIssueBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIssueSNDirty()) {
            hashMap.put(FIELD_ISSUESN, this.getIssueSN());
        }
        if (!bl || this.isIssueStateDirty()) {
            hashMap.put(FIELD_ISSUESTATE, this.getIssueState());
        }
        if (!bl || this.isIssueTypeDirty()) {
            hashMap.put(FIELD_ISSUETYPE, this.getIssueType());
        }
        if (!bl || this.isLogTimeDirty()) {
            hashMap.put(FIELD_LOGTIME, this.getLogTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdIssueIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDISSUEID, this.getPSDevPrdIssueId());
        }
        if (!bl || this.isPSDevPrdIssueNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDISSUENAME, this.getPSDevPrdIssueName());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevPrdSubVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERID, this.getPSDevPrdSubVerId());
        }
        if (!bl || this.isPSDevPrdSubVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSUBVERNAME, this.getPSDevPrdSubVerName());
        }
        if (!bl || this.isPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERID, this.getPSDevPrdVerId());
        }
        if (!bl || this.isPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERNAME, this.getPSDevPrdVerName());
        }
        if (!bl || this.isSolvedContentDirty()) {
            hashMap.put(FIELD_SOLVEDCONTENT, this.getSolvedContent());
        }
        if (!bl || this.isSolvedTimeDirty()) {
            hashMap.put(FIELD_SOLVEDTIME, this.getSolvedTime());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDevPrdIssueBase.get(this, n);
    }

    private static Object get(PSDevPrdIssueBase pSDevPrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdIssueBase.getContent();
            }
            case 1: {
                return pSDevPrdIssueBase.getCreateDate();
            }
            case 2: {
                return pSDevPrdIssueBase.getCreateMan();
            }
            case 3: {
                return pSDevPrdIssueBase.getIssueSN();
            }
            case 4: {
                return pSDevPrdIssueBase.getIssueState();
            }
            case 5: {
                return pSDevPrdIssueBase.getIssueType();
            }
            case 6: {
                return pSDevPrdIssueBase.getLogTime();
            }
            case 7: {
                return pSDevPrdIssueBase.getMemo();
            }
            case 8: {
                return pSDevPrdIssueBase.getPSDevPrdId();
            }
            case 9: {
                return pSDevPrdIssueBase.getPSDevPrdIssueId();
            }
            case 10: {
                return pSDevPrdIssueBase.getPSDevPrdIssueName();
            }
            case 11: {
                return pSDevPrdIssueBase.getPSDevPrdName();
            }
            case 12: {
                return pSDevPrdIssueBase.getPSDevPrdSubVerId();
            }
            case 13: {
                return pSDevPrdIssueBase.getPSDevPrdSubVerName();
            }
            case 14: {
                return pSDevPrdIssueBase.getPSDevPrdVerId();
            }
            case 15: {
                return pSDevPrdIssueBase.getPSDevPrdVerName();
            }
            case 16: {
                return pSDevPrdIssueBase.getSolvedContent();
            }
            case 17: {
                return pSDevPrdIssueBase.getSolvedTime();
            }
            case 18: {
                return pSDevPrdIssueBase.getUpdateDate();
            }
            case 19: {
                return pSDevPrdIssueBase.getUpdateMan();
            }
            case 20: {
                return pSDevPrdIssueBase.getUserTag();
            }
            case 21: {
                return pSDevPrdIssueBase.getUserTag2();
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
        PSDevPrdIssueBase.set(this, n, object);
    }

    private static void set(PSDevPrdIssueBase pSDevPrdIssueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdIssueBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdIssueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdIssueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdIssueBase.setIssueSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdIssueBase.setIssueState(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdIssueBase.setIssueType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdIssueBase.setLogTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdIssueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdIssueBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdIssueBase.setPSDevPrdIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdIssueBase.setPSDevPrdIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdIssueBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdIssueBase.setPSDevPrdSubVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdIssueBase.setPSDevPrdSubVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevPrdIssueBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevPrdIssueBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevPrdIssueBase.setSolvedContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevPrdIssueBase.setSolvedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDevPrdIssueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDevPrdIssueBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevPrdIssueBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevPrdIssueBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDevPrdIssueBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdIssueBase pSDevPrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdIssueBase.getContent() == null;
            }
            case 1: {
                return pSDevPrdIssueBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevPrdIssueBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevPrdIssueBase.getIssueSN() == null;
            }
            case 4: {
                return pSDevPrdIssueBase.getIssueState() == null;
            }
            case 5: {
                return pSDevPrdIssueBase.getIssueType() == null;
            }
            case 6: {
                return pSDevPrdIssueBase.getLogTime() == null;
            }
            case 7: {
                return pSDevPrdIssueBase.getMemo() == null;
            }
            case 8: {
                return pSDevPrdIssueBase.getPSDevPrdId() == null;
            }
            case 9: {
                return pSDevPrdIssueBase.getPSDevPrdIssueId() == null;
            }
            case 10: {
                return pSDevPrdIssueBase.getPSDevPrdIssueName() == null;
            }
            case 11: {
                return pSDevPrdIssueBase.getPSDevPrdName() == null;
            }
            case 12: {
                return pSDevPrdIssueBase.getPSDevPrdSubVerId() == null;
            }
            case 13: {
                return pSDevPrdIssueBase.getPSDevPrdSubVerName() == null;
            }
            case 14: {
                return pSDevPrdIssueBase.getPSDevPrdVerId() == null;
            }
            case 15: {
                return pSDevPrdIssueBase.getPSDevPrdVerName() == null;
            }
            case 16: {
                return pSDevPrdIssueBase.getSolvedContent() == null;
            }
            case 17: {
                return pSDevPrdIssueBase.getSolvedTime() == null;
            }
            case 18: {
                return pSDevPrdIssueBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDevPrdIssueBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDevPrdIssueBase.getUserTag() == null;
            }
            case 21: {
                return pSDevPrdIssueBase.getUserTag2() == null;
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
        return PSDevPrdIssueBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdIssueBase pSDevPrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdIssueBase.isContentDirty();
            }
            case 1: {
                return pSDevPrdIssueBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevPrdIssueBase.isCreateManDirty();
            }
            case 3: {
                return pSDevPrdIssueBase.isIssueSNDirty();
            }
            case 4: {
                return pSDevPrdIssueBase.isIssueStateDirty();
            }
            case 5: {
                return pSDevPrdIssueBase.isIssueTypeDirty();
            }
            case 6: {
                return pSDevPrdIssueBase.isLogTimeDirty();
            }
            case 7: {
                return pSDevPrdIssueBase.isMemoDirty();
            }
            case 8: {
                return pSDevPrdIssueBase.isPSDevPrdIdDirty();
            }
            case 9: {
                return pSDevPrdIssueBase.isPSDevPrdIssueIdDirty();
            }
            case 10: {
                return pSDevPrdIssueBase.isPSDevPrdIssueNameDirty();
            }
            case 11: {
                return pSDevPrdIssueBase.isPSDevPrdNameDirty();
            }
            case 12: {
                return pSDevPrdIssueBase.isPSDevPrdSubVerIdDirty();
            }
            case 13: {
                return pSDevPrdIssueBase.isPSDevPrdSubVerNameDirty();
            }
            case 14: {
                return pSDevPrdIssueBase.isPSDevPrdVerIdDirty();
            }
            case 15: {
                return pSDevPrdIssueBase.isPSDevPrdVerNameDirty();
            }
            case 16: {
                return pSDevPrdIssueBase.isSolvedContentDirty();
            }
            case 17: {
                return pSDevPrdIssueBase.isSolvedTimeDirty();
            }
            case 18: {
                return pSDevPrdIssueBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDevPrdIssueBase.isUpdateManDirty();
            }
            case 20: {
                return pSDevPrdIssueBase.isUserTagDirty();
            }
            case 21: {
                return pSDevPrdIssueBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdIssueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdIssueBase pSDevPrdIssueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdIssueBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getContent()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getIssueSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuesn", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getIssueSN()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getIssueState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuestate", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getIssueState()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getIssueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuetype", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getIssueType()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getLogTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtime", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getLogTime()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdissueid", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdIssueId()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdissuename", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdIssueName()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdSubVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubverid", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdSubVerId()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdSubVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsubvername", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdSubVerName()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getSolvedContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"solvedcontent", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getSolvedContent()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getSolvedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"solvedtime", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getSolvedTime()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevPrdIssueBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevPrdIssueBase.getJSONValue((Object)pSDevPrdIssueBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdIssueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdIssueBase pSDevPrdIssueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdIssueBase.getContent() != null) {
            object = pSDevPrdIssueBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getCreateDate() != null) {
            object = pSDevPrdIssueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdIssueBase.getCreateMan() != null) {
            object = pSDevPrdIssueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getIssueSN() != null) {
            object = pSDevPrdIssueBase.getIssueSN();
            xmlNode.setAttribute(FIELD_ISSUESN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getIssueState() != null) {
            object = pSDevPrdIssueBase.getIssueState();
            xmlNode.setAttribute(FIELD_ISSUESTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getIssueType() != null) {
            object = pSDevPrdIssueBase.getIssueType();
            xmlNode.setAttribute(FIELD_ISSUETYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdIssueBase.getLogTime() != null) {
            object = pSDevPrdIssueBase.getLogTime();
            xmlNode.setAttribute(FIELD_LOGTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdIssueBase.getMemo() != null) {
            object = pSDevPrdIssueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdId() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdIssueId() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdIssueId();
            xmlNode.setAttribute(FIELD_PSDEVPRDISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdIssueName() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdIssueName();
            xmlNode.setAttribute(FIELD_PSDEVPRDISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdName() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdSubVerId() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdSubVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdSubVerName() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdSubVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSUBVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdVerId() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getPSDevPrdVerName() != null) {
            object = pSDevPrdIssueBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getSolvedContent() != null) {
            object = pSDevPrdIssueBase.getSolvedContent();
            xmlNode.setAttribute(FIELD_SOLVEDCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getSolvedTime() != null) {
            object = pSDevPrdIssueBase.getSolvedTime();
            xmlNode.setAttribute(FIELD_SOLVEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdIssueBase.getUpdateDate() != null) {
            object = pSDevPrdIssueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdIssueBase.getUpdateMan() != null) {
            object = pSDevPrdIssueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getUserTag() != null) {
            object = pSDevPrdIssueBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdIssueBase.getUserTag2() != null) {
            object = pSDevPrdIssueBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdIssueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdIssueBase pSDevPrdIssueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdIssueBase.isContentDirty() && (bl || pSDevPrdIssueBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDevPrdIssueBase.getContent());
        }
        if (pSDevPrdIssueBase.isCreateDateDirty() && (bl || pSDevPrdIssueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdIssueBase.getCreateDate());
        }
        if (pSDevPrdIssueBase.isCreateManDirty() && (bl || pSDevPrdIssueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdIssueBase.getCreateMan());
        }
        if (pSDevPrdIssueBase.isIssueSNDirty() && (bl || pSDevPrdIssueBase.getIssueSN() != null)) {
            iDataObject.set(FIELD_ISSUESN, (Object)pSDevPrdIssueBase.getIssueSN());
        }
        if (pSDevPrdIssueBase.isIssueStateDirty() && (bl || pSDevPrdIssueBase.getIssueState() != null)) {
            iDataObject.set(FIELD_ISSUESTATE, (Object)pSDevPrdIssueBase.getIssueState());
        }
        if (pSDevPrdIssueBase.isIssueTypeDirty() && (bl || pSDevPrdIssueBase.getIssueType() != null)) {
            iDataObject.set(FIELD_ISSUETYPE, (Object)pSDevPrdIssueBase.getIssueType());
        }
        if (pSDevPrdIssueBase.isLogTimeDirty() && (bl || pSDevPrdIssueBase.getLogTime() != null)) {
            iDataObject.set(FIELD_LOGTIME, (Object)pSDevPrdIssueBase.getLogTime());
        }
        if (pSDevPrdIssueBase.isMemoDirty() && (bl || pSDevPrdIssueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevPrdIssueBase.getMemo());
        }
        if (pSDevPrdIssueBase.isPSDevPrdIdDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSDevPrdIssueBase.getPSDevPrdId());
        }
        if (pSDevPrdIssueBase.isPSDevPrdIssueIdDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdIssueId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDISSUEID, (Object)pSDevPrdIssueBase.getPSDevPrdIssueId());
        }
        if (pSDevPrdIssueBase.isPSDevPrdIssueNameDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdIssueName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDISSUENAME, (Object)pSDevPrdIssueBase.getPSDevPrdIssueName());
        }
        if (pSDevPrdIssueBase.isPSDevPrdNameDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSDevPrdIssueBase.getPSDevPrdName());
        }
        if (pSDevPrdIssueBase.isPSDevPrdSubVerIdDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdSubVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERID, (Object)pSDevPrdIssueBase.getPSDevPrdSubVerId());
        }
        if (pSDevPrdIssueBase.isPSDevPrdSubVerNameDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdSubVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSUBVERNAME, (Object)pSDevPrdIssueBase.getPSDevPrdSubVerName());
        }
        if (pSDevPrdIssueBase.isPSDevPrdVerIdDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSDevPrdIssueBase.getPSDevPrdVerId());
        }
        if (pSDevPrdIssueBase.isPSDevPrdVerNameDirty() && (bl || pSDevPrdIssueBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSDevPrdIssueBase.getPSDevPrdVerName());
        }
        if (pSDevPrdIssueBase.isSolvedContentDirty() && (bl || pSDevPrdIssueBase.getSolvedContent() != null)) {
            iDataObject.set(FIELD_SOLVEDCONTENT, (Object)pSDevPrdIssueBase.getSolvedContent());
        }
        if (pSDevPrdIssueBase.isSolvedTimeDirty() && (bl || pSDevPrdIssueBase.getSolvedTime() != null)) {
            iDataObject.set(FIELD_SOLVEDTIME, (Object)pSDevPrdIssueBase.getSolvedTime());
        }
        if (pSDevPrdIssueBase.isUpdateDateDirty() && (bl || pSDevPrdIssueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdIssueBase.getUpdateDate());
        }
        if (pSDevPrdIssueBase.isUpdateManDirty() && (bl || pSDevPrdIssueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdIssueBase.getUpdateMan());
        }
        if (pSDevPrdIssueBase.isUserTagDirty() && (bl || pSDevPrdIssueBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevPrdIssueBase.getUserTag());
        }
        if (pSDevPrdIssueBase.isUserTag2Dirty() && (bl || pSDevPrdIssueBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevPrdIssueBase.getUserTag2());
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
        return PSDevPrdIssueBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdIssueBase pSDevPrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdIssueBase.resetContent();
                return true;
            }
            case 1: {
                pSDevPrdIssueBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevPrdIssueBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevPrdIssueBase.resetIssueSN();
                return true;
            }
            case 4: {
                pSDevPrdIssueBase.resetIssueState();
                return true;
            }
            case 5: {
                pSDevPrdIssueBase.resetIssueType();
                return true;
            }
            case 6: {
                pSDevPrdIssueBase.resetLogTime();
                return true;
            }
            case 7: {
                pSDevPrdIssueBase.resetMemo();
                return true;
            }
            case 8: {
                pSDevPrdIssueBase.resetPSDevPrdId();
                return true;
            }
            case 9: {
                pSDevPrdIssueBase.resetPSDevPrdIssueId();
                return true;
            }
            case 10: {
                pSDevPrdIssueBase.resetPSDevPrdIssueName();
                return true;
            }
            case 11: {
                pSDevPrdIssueBase.resetPSDevPrdName();
                return true;
            }
            case 12: {
                pSDevPrdIssueBase.resetPSDevPrdSubVerId();
                return true;
            }
            case 13: {
                pSDevPrdIssueBase.resetPSDevPrdSubVerName();
                return true;
            }
            case 14: {
                pSDevPrdIssueBase.resetPSDevPrdVerId();
                return true;
            }
            case 15: {
                pSDevPrdIssueBase.resetPSDevPrdVerName();
                return true;
            }
            case 16: {
                pSDevPrdIssueBase.resetSolvedContent();
                return true;
            }
            case 17: {
                pSDevPrdIssueBase.resetSolvedTime();
                return true;
            }
            case 18: {
                pSDevPrdIssueBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDevPrdIssueBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDevPrdIssueBase.resetUserTag();
                return true;
            }
            case 21: {
                pSDevPrdIssueBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSubVer getPSDevPrdSubVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSubVer();
        }
        if (this.getPSDevPrdSubVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdSubVerLock;
        synchronized (n) {
            if (this.psdevprdsubver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdSubVerId(), (Object)this.psdevprdsubver.getPSDevPrdSubVerId()) != 0L) {
                this.psdevprdsubver = null;
            }
            if (this.psdevprdsubver == null) {
                PSDevPrdSubVer pSDevPrdSubVer = new PSDevPrdSubVer();
                pSDevPrdSubVer.setPSDevPrdSubVerId(this.getPSDevPrdSubVerId());
                PSDevPrdSubVerService pSDevPrdSubVerService = (PSDevPrdSubVerService)ServiceGlobal.getService(PSDevPrdSubVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSubVerService.autoGet((IEntity)pSDevPrdSubVer);
                this.psdevprdsubver = pSDevPrdSubVer;
            }
            return this.psdevprdsubver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdVer getPSDevPrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVer();
        }
        if (this.getPSDevPrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdVerLock;
        synchronized (n) {
            if (this.psdevprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdVerId(), (Object)this.psdevprdver.getPSDevPrdVerId()) != 0L) {
                this.psdevprdver = null;
            }
            if (this.psdevprdver == null) {
                PSDevPrdVer pSDevPrdVer = new PSDevPrdVer();
                pSDevPrdVer.setPSDevPrdVerId(this.getPSDevPrdVerId());
                PSDevPrdVerService pSDevPrdVerService = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdVerService.autoGet((IEntity)pSDevPrdVer);
                this.psdevprdver = pSDevPrdVer;
            }
            return this.psdevprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrd getPSDevPrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrd();
        }
        if (this.getPSDevPrdId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdLock;
        synchronized (n) {
            if (this.psdevprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdId(), (Object)this.psdevprd.getPSDevPrdId()) != 0L) {
                this.psdevprd = null;
            }
            if (this.psdevprd == null) {
                PSDevPrd pSDevPrd = new PSDevPrd();
                pSDevPrd.setPSDevPrdId(this.getPSDevPrdId());
                PSDevPrdService pSDevPrdService = (PSDevPrdService)ServiceGlobal.getService(PSDevPrdService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdService.autoGet((IEntity)pSDevPrd);
                this.psdevprd = pSDevPrd;
            }
            return this.psdevprd;
        }
    }

    private PSDevPrdIssueBase getProxyEntity() {
        return this.proxyPSDevPrdIssueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdIssueBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdIssueBase) {
            this.proxyPSDevPrdIssueBase = (PSDevPrdIssueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ISSUESN, 3);
        fieldIndexMap.put(FIELD_ISSUESTATE, 4);
        fieldIndexMap.put(FIELD_ISSUETYPE, 5);
        fieldIndexMap.put(FIELD_LOGTIME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 8);
        fieldIndexMap.put(FIELD_PSDEVPRDISSUEID, 9);
        fieldIndexMap.put(FIELD_PSDEVPRDISSUENAME, 10);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERID, 12);
        fieldIndexMap.put(FIELD_PSDEVPRDSUBVERNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 14);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 15);
        fieldIndexMap.put(FIELD_SOLVEDCONTENT, 16);
        fieldIndexMap.put(FIELD_SOLVEDTIME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
    }
}

