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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssue;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCorePrdIssueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCorePrdIssueBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISSUESN = "ISSUESN";
    public static final String FIELD_ISSUESTATE = "ISSUESTATE";
    public static final String FIELD_ISSUETAG = "ISSUETAG";
    public static final String FIELD_ISSUETAG2 = "ISSUETAG2";
    public static final String FIELD_ISSUEURL = "ISSUEURL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOREPRDID = "PSCOREPRDID";
    public static final String FIELD_PSCOREPRDISSUEID = "PSCOREPRDISSUEID";
    public static final String FIELD_PSCOREPRDISSUENAME = "PSCOREPRDISSUENAME";
    public static final String FIELD_PSCOREPRDNAME = "PSCOREPRDNAME";
    public static final String FIELD_PSCOREPRDVERID = "PSCOREPRDVERID";
    public static final String FIELD_PSCOREPRDVERNAME = "PSCOREPRDVERNAME";
    public static final String FIELD_REFPSCOREPRDISSUEID = "REFPSCOREPRDISSUEID";
    public static final String FIELD_REFPSCOREPRDISSUENAME = "REFPSCOREPRDISSUENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ISSUESN = 2;
    private static final int INDEX_ISSUESTATE = 3;
    private static final int INDEX_ISSUETAG = 4;
    private static final int INDEX_ISSUETAG2 = 5;
    private static final int INDEX_ISSUEURL = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSCOREPRDID = 8;
    private static final int INDEX_PSCOREPRDISSUEID = 9;
    private static final int INDEX_PSCOREPRDISSUENAME = 10;
    private static final int INDEX_PSCOREPRDNAME = 11;
    private static final int INDEX_PSCOREPRDVERID = 12;
    private static final int INDEX_PSCOREPRDVERNAME = 13;
    private static final int INDEX_REFPSCOREPRDISSUEID = 14;
    private static final int INDEX_REFPSCOREPRDISSUENAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCorePrdIssueBase proxyPSCorePrdIssueBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issuesnDirtyFlag = false;
    private boolean issuestateDirtyFlag = false;
    private boolean issuetagDirtyFlag = false;
    private boolean issuetag2DirtyFlag = false;
    private boolean issueurlDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscoreprdidDirtyFlag = false;
    private boolean pscoreprdissueidDirtyFlag = false;
    private boolean pscoreprdissuenameDirtyFlag = false;
    private boolean pscoreprdnameDirtyFlag = false;
    private boolean pscoreprdveridDirtyFlag = false;
    private boolean pscoreprdvernameDirtyFlag = false;
    private boolean refpscoreprdissueidDirtyFlag = false;
    private boolean refpscoreprdissuenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issuesn")
    private String issuesn;
    @Column(name="issuestate")
    private Integer issuestate;
    @Column(name="issuetag")
    private String issuetag;
    @Column(name="issuetag2")
    private String issuetag2;
    @Column(name="issueurl")
    private String issueurl;
    @Column(name="memo")
    private String memo;
    @Column(name="pscoreprdid")
    private String pscoreprdid;
    @Column(name="pscoreprdissueid")
    private String pscoreprdissueid;
    @Column(name="pscoreprdissuename")
    private String pscoreprdissuename;
    @Column(name="pscoreprdname")
    private String pscoreprdname;
    @Column(name="pscoreprdverid")
    private String pscoreprdverid;
    @Column(name="pscoreprdvername")
    private String pscoreprdvername;
    @Column(name="refpscoreprdissueid")
    private String refpscoreprdissueid;
    @Column(name="refpscoreprdissuename")
    private String refpscoreprdissuename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objRefPSCorePrdIssueLock = new Integer(1);
    private PSCorePrdIssue refpscoreprdissue = null;
    private Integer objPSCoreRepVerLock = new Integer(1);
    private PSCorePrdVer pscorerepver = null;
    private Integer objPSCorePrdLock = new Integer(1);
    private PSCorePrd pscoreprd = null;

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

    public void setIssueState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueState(n);
            return;
        }
        this.issuestate = n;
        this.issuestateDirtyFlag = true;
    }

    public Integer getIssueState() {
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

    public void setIssueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuetag = string;
        this.issuetagDirtyFlag = true;
    }

    public String getIssueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueTag();
        }
        return this.issuetag;
    }

    public boolean isIssueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueTagDirty();
        }
        return this.issuetagDirtyFlag;
    }

    public void resetIssueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueTag();
            return;
        }
        this.issuetagDirtyFlag = false;
        this.issuetag = null;
    }

    public void setIssueTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuetag2 = string;
        this.issuetag2DirtyFlag = true;
    }

    public String getIssueTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueTag2();
        }
        return this.issuetag2;
    }

    public boolean isIssueTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueTag2Dirty();
        }
        return this.issuetag2DirtyFlag;
    }

    public void resetIssueTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueTag2();
            return;
        }
        this.issuetag2DirtyFlag = false;
        this.issuetag2 = null;
    }

    public void setIssueUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issueurl = string;
        this.issueurlDirtyFlag = true;
    }

    public String getIssueUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueUrl();
        }
        return this.issueurl;
    }

    public boolean isIssueUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueUrlDirty();
        }
        return this.issueurlDirtyFlag;
    }

    public void resetIssueUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueUrl();
            return;
        }
        this.issueurlDirtyFlag = false;
        this.issueurl = null;
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

    public void setPSCorePrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdid = string;
        this.pscoreprdidDirtyFlag = true;
    }

    public String getPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdId();
        }
        return this.pscoreprdid;
    }

    public boolean isPSCorePrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIdDirty();
        }
        return this.pscoreprdidDirtyFlag;
    }

    public void resetPSCorePrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdId();
            return;
        }
        this.pscoreprdidDirtyFlag = false;
        this.pscoreprdid = null;
    }

    public void setPSCorePrdIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdissueid = string;
        this.pscoreprdissueidDirtyFlag = true;
    }

    public String getPSCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdIssueId();
        }
        return this.pscoreprdissueid;
    }

    public boolean isPSCorePrdIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIssueIdDirty();
        }
        return this.pscoreprdissueidDirtyFlag;
    }

    public void resetPSCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdIssueId();
            return;
        }
        this.pscoreprdissueidDirtyFlag = false;
        this.pscoreprdissueid = null;
    }

    public void setPSCorePrdIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdissuename = string;
        this.pscoreprdissuenameDirtyFlag = true;
    }

    public String getPSCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdIssueName();
        }
        return this.pscoreprdissuename;
    }

    public boolean isPSCorePrdIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIssueNameDirty();
        }
        return this.pscoreprdissuenameDirtyFlag;
    }

    public void resetPSCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdIssueName();
            return;
        }
        this.pscoreprdissuenameDirtyFlag = false;
        this.pscoreprdissuename = null;
    }

    public void setPSCorePrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdname = string;
        this.pscoreprdnameDirtyFlag = true;
    }

    public String getPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdName();
        }
        return this.pscoreprdname;
    }

    public boolean isPSCorePrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdNameDirty();
        }
        return this.pscoreprdnameDirtyFlag;
    }

    public void resetPSCorePrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdName();
            return;
        }
        this.pscoreprdnameDirtyFlag = false;
        this.pscoreprdname = null;
    }

    public void setPSCorePrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdverid = string;
        this.pscoreprdveridDirtyFlag = true;
    }

    public String getPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerId();
        }
        return this.pscoreprdverid;
    }

    public boolean isPSCorePrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerIdDirty();
        }
        return this.pscoreprdveridDirtyFlag;
    }

    public void resetPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerId();
            return;
        }
        this.pscoreprdveridDirtyFlag = false;
        this.pscoreprdverid = null;
    }

    public void setPSCorePrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdvername = string;
        this.pscoreprdvernameDirtyFlag = true;
    }

    public String getPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerName();
        }
        return this.pscoreprdvername;
    }

    public boolean isPSCorePrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerNameDirty();
        }
        return this.pscoreprdvernameDirtyFlag;
    }

    public void resetPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerName();
            return;
        }
        this.pscoreprdvernameDirtyFlag = false;
        this.pscoreprdvername = null;
    }

    public void setRefPSCorePrdIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSCorePrdIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpscoreprdissueid = string;
        this.refpscoreprdissueidDirtyFlag = true;
    }

    public String getRefPSCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSCorePrdIssueId();
        }
        return this.refpscoreprdissueid;
    }

    public boolean isRefPSCorePrdIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSCorePrdIssueIdDirty();
        }
        return this.refpscoreprdissueidDirtyFlag;
    }

    public void resetRefPSCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSCorePrdIssueId();
            return;
        }
        this.refpscoreprdissueidDirtyFlag = false;
        this.refpscoreprdissueid = null;
    }

    public void setRefPSCorePrdIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSCorePrdIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpscoreprdissuename = string;
        this.refpscoreprdissuenameDirtyFlag = true;
    }

    public String getRefPSCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSCorePrdIssueName();
        }
        return this.refpscoreprdissuename;
    }

    public boolean isRefPSCorePrdIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSCorePrdIssueNameDirty();
        }
        return this.refpscoreprdissuenameDirtyFlag;
    }

    public void resetRefPSCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSCorePrdIssueName();
            return;
        }
        this.refpscoreprdissuenameDirtyFlag = false;
        this.refpscoreprdissuename = null;
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

    protected void onReset() {
        PSCorePrdIssueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCorePrdIssueBase pSCorePrdIssueBase) {
        pSCorePrdIssueBase.resetCreateDate();
        pSCorePrdIssueBase.resetCreateMan();
        pSCorePrdIssueBase.resetIssueSN();
        pSCorePrdIssueBase.resetIssueState();
        pSCorePrdIssueBase.resetIssueTag();
        pSCorePrdIssueBase.resetIssueTag2();
        pSCorePrdIssueBase.resetIssueUrl();
        pSCorePrdIssueBase.resetMemo();
        pSCorePrdIssueBase.resetPSCorePrdId();
        pSCorePrdIssueBase.resetPSCorePrdIssueId();
        pSCorePrdIssueBase.resetPSCorePrdIssueName();
        pSCorePrdIssueBase.resetPSCorePrdName();
        pSCorePrdIssueBase.resetPSCorePrdVerId();
        pSCorePrdIssueBase.resetPSCorePrdVerName();
        pSCorePrdIssueBase.resetRefPSCorePrdIssueId();
        pSCorePrdIssueBase.resetRefPSCorePrdIssueName();
        pSCorePrdIssueBase.resetUpdateDate();
        pSCorePrdIssueBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isIssueTagDirty()) {
            hashMap.put(FIELD_ISSUETAG, this.getIssueTag());
        }
        if (!bl || this.isIssueTag2Dirty()) {
            hashMap.put(FIELD_ISSUETAG2, this.getIssueTag2());
        }
        if (!bl || this.isIssueUrlDirty()) {
            hashMap.put(FIELD_ISSUEURL, this.getIssueUrl());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCorePrdIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDID, this.getPSCorePrdId());
        }
        if (!bl || this.isPSCorePrdIssueIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDISSUEID, this.getPSCorePrdIssueId());
        }
        if (!bl || this.isPSCorePrdIssueNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDISSUENAME, this.getPSCorePrdIssueName());
        }
        if (!bl || this.isPSCorePrdNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDNAME, this.getPSCorePrdName());
        }
        if (!bl || this.isPSCorePrdVerIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERID, this.getPSCorePrdVerId());
        }
        if (!bl || this.isPSCorePrdVerNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERNAME, this.getPSCorePrdVerName());
        }
        if (!bl || this.isRefPSCorePrdIssueIdDirty()) {
            hashMap.put(FIELD_REFPSCOREPRDISSUEID, this.getRefPSCorePrdIssueId());
        }
        if (!bl || this.isRefPSCorePrdIssueNameDirty()) {
            hashMap.put(FIELD_REFPSCOREPRDISSUENAME, this.getRefPSCorePrdIssueName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSCorePrdIssueBase.get(this, n);
    }

    private static Object get(PSCorePrdIssueBase pSCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdIssueBase.getCreateDate();
            }
            case 1: {
                return pSCorePrdIssueBase.getCreateMan();
            }
            case 2: {
                return pSCorePrdIssueBase.getIssueSN();
            }
            case 3: {
                return pSCorePrdIssueBase.getIssueState();
            }
            case 4: {
                return pSCorePrdIssueBase.getIssueTag();
            }
            case 5: {
                return pSCorePrdIssueBase.getIssueTag2();
            }
            case 6: {
                return pSCorePrdIssueBase.getIssueUrl();
            }
            case 7: {
                return pSCorePrdIssueBase.getMemo();
            }
            case 8: {
                return pSCorePrdIssueBase.getPSCorePrdId();
            }
            case 9: {
                return pSCorePrdIssueBase.getPSCorePrdIssueId();
            }
            case 10: {
                return pSCorePrdIssueBase.getPSCorePrdIssueName();
            }
            case 11: {
                return pSCorePrdIssueBase.getPSCorePrdName();
            }
            case 12: {
                return pSCorePrdIssueBase.getPSCorePrdVerId();
            }
            case 13: {
                return pSCorePrdIssueBase.getPSCorePrdVerName();
            }
            case 14: {
                return pSCorePrdIssueBase.getRefPSCorePrdIssueId();
            }
            case 15: {
                return pSCorePrdIssueBase.getRefPSCorePrdIssueName();
            }
            case 16: {
                return pSCorePrdIssueBase.getUpdateDate();
            }
            case 17: {
                return pSCorePrdIssueBase.getUpdateMan();
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
        PSCorePrdIssueBase.set(this, n, object);
    }

    private static void set(PSCorePrdIssueBase pSCorePrdIssueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdIssueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCorePrdIssueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCorePrdIssueBase.setIssueSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCorePrdIssueBase.setIssueState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSCorePrdIssueBase.setIssueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCorePrdIssueBase.setIssueTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCorePrdIssueBase.setIssueUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCorePrdIssueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCorePrdIssueBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCorePrdIssueBase.setPSCorePrdIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCorePrdIssueBase.setPSCorePrdIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCorePrdIssueBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCorePrdIssueBase.setPSCorePrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCorePrdIssueBase.setPSCorePrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCorePrdIssueBase.setRefPSCorePrdIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCorePrdIssueBase.setRefPSCorePrdIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCorePrdIssueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSCorePrdIssueBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCorePrdIssueBase.isNull(this, n);
    }

    private static boolean isNull(PSCorePrdIssueBase pSCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdIssueBase.getCreateDate() == null;
            }
            case 1: {
                return pSCorePrdIssueBase.getCreateMan() == null;
            }
            case 2: {
                return pSCorePrdIssueBase.getIssueSN() == null;
            }
            case 3: {
                return pSCorePrdIssueBase.getIssueState() == null;
            }
            case 4: {
                return pSCorePrdIssueBase.getIssueTag() == null;
            }
            case 5: {
                return pSCorePrdIssueBase.getIssueTag2() == null;
            }
            case 6: {
                return pSCorePrdIssueBase.getIssueUrl() == null;
            }
            case 7: {
                return pSCorePrdIssueBase.getMemo() == null;
            }
            case 8: {
                return pSCorePrdIssueBase.getPSCorePrdId() == null;
            }
            case 9: {
                return pSCorePrdIssueBase.getPSCorePrdIssueId() == null;
            }
            case 10: {
                return pSCorePrdIssueBase.getPSCorePrdIssueName() == null;
            }
            case 11: {
                return pSCorePrdIssueBase.getPSCorePrdName() == null;
            }
            case 12: {
                return pSCorePrdIssueBase.getPSCorePrdVerId() == null;
            }
            case 13: {
                return pSCorePrdIssueBase.getPSCorePrdVerName() == null;
            }
            case 14: {
                return pSCorePrdIssueBase.getRefPSCorePrdIssueId() == null;
            }
            case 15: {
                return pSCorePrdIssueBase.getRefPSCorePrdIssueName() == null;
            }
            case 16: {
                return pSCorePrdIssueBase.getUpdateDate() == null;
            }
            case 17: {
                return pSCorePrdIssueBase.getUpdateMan() == null;
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
        return PSCorePrdIssueBase.contains(this, n);
    }

    private static boolean contains(PSCorePrdIssueBase pSCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCorePrdIssueBase.isCreateDateDirty();
            }
            case 1: {
                return pSCorePrdIssueBase.isCreateManDirty();
            }
            case 2: {
                return pSCorePrdIssueBase.isIssueSNDirty();
            }
            case 3: {
                return pSCorePrdIssueBase.isIssueStateDirty();
            }
            case 4: {
                return pSCorePrdIssueBase.isIssueTagDirty();
            }
            case 5: {
                return pSCorePrdIssueBase.isIssueTag2Dirty();
            }
            case 6: {
                return pSCorePrdIssueBase.isIssueUrlDirty();
            }
            case 7: {
                return pSCorePrdIssueBase.isMemoDirty();
            }
            case 8: {
                return pSCorePrdIssueBase.isPSCorePrdIdDirty();
            }
            case 9: {
                return pSCorePrdIssueBase.isPSCorePrdIssueIdDirty();
            }
            case 10: {
                return pSCorePrdIssueBase.isPSCorePrdIssueNameDirty();
            }
            case 11: {
                return pSCorePrdIssueBase.isPSCorePrdNameDirty();
            }
            case 12: {
                return pSCorePrdIssueBase.isPSCorePrdVerIdDirty();
            }
            case 13: {
                return pSCorePrdIssueBase.isPSCorePrdVerNameDirty();
            }
            case 14: {
                return pSCorePrdIssueBase.isRefPSCorePrdIssueIdDirty();
            }
            case 15: {
                return pSCorePrdIssueBase.isRefPSCorePrdIssueNameDirty();
            }
            case 16: {
                return pSCorePrdIssueBase.isUpdateDateDirty();
            }
            case 17: {
                return pSCorePrdIssueBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCorePrdIssueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCorePrdIssueBase pSCorePrdIssueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCorePrdIssueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getIssueSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuesn", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getIssueSN()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getIssueState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuestate", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getIssueState()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getIssueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuetag", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getIssueTag()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getIssueTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuetag2", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getIssueTag2()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getIssueUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issueurl", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getIssueUrl()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getMemo()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdissueid", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getPSCorePrdIssueId()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdissuename", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getPSCorePrdIssueName()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdverid", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getPSCorePrdVerId()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdvername", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getPSCorePrdVerName()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getRefPSCorePrdIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpscoreprdissueid", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getRefPSCorePrdIssueId()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getRefPSCorePrdIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpscoreprdissuename", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getRefPSCorePrdIssueName()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCorePrdIssueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCorePrdIssueBase.getJSONValue((Object)pSCorePrdIssueBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCorePrdIssueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCorePrdIssueBase pSCorePrdIssueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCorePrdIssueBase.getCreateDate() != null) {
            object = pSCorePrdIssueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdIssueBase.getCreateMan() != null) {
            object = pSCorePrdIssueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getIssueSN() != null) {
            object = pSCorePrdIssueBase.getIssueSN();
            xmlNode.setAttribute(FIELD_ISSUESN, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getIssueState() != null) {
            object = pSCorePrdIssueBase.getIssueState();
            xmlNode.setAttribute(FIELD_ISSUESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCorePrdIssueBase.getIssueTag() != null) {
            object = pSCorePrdIssueBase.getIssueTag();
            xmlNode.setAttribute(FIELD_ISSUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getIssueTag2() != null) {
            object = pSCorePrdIssueBase.getIssueTag2();
            xmlNode.setAttribute(FIELD_ISSUETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getIssueUrl() != null) {
            object = pSCorePrdIssueBase.getIssueUrl();
            xmlNode.setAttribute(FIELD_ISSUEURL, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getMemo() != null) {
            object = pSCorePrdIssueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdId() != null) {
            object = pSCorePrdIssueBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdIssueId() != null) {
            object = pSCorePrdIssueBase.getPSCorePrdIssueId();
            xmlNode.setAttribute(FIELD_PSCOREPRDISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdIssueName() != null) {
            object = pSCorePrdIssueBase.getPSCorePrdIssueName();
            xmlNode.setAttribute(FIELD_PSCOREPRDISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdName() != null) {
            object = pSCorePrdIssueBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdVerId() != null) {
            object = pSCorePrdIssueBase.getPSCorePrdVerId();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getPSCorePrdVerName() != null) {
            object = pSCorePrdIssueBase.getPSCorePrdVerName();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getRefPSCorePrdIssueId() != null) {
            object = pSCorePrdIssueBase.getRefPSCorePrdIssueId();
            xmlNode.setAttribute(FIELD_REFPSCOREPRDISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getRefPSCorePrdIssueName() != null) {
            object = pSCorePrdIssueBase.getRefPSCorePrdIssueName();
            xmlNode.setAttribute(FIELD_REFPSCOREPRDISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCorePrdIssueBase.getUpdateDate() != null) {
            object = pSCorePrdIssueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCorePrdIssueBase.getUpdateMan() != null) {
            object = pSCorePrdIssueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCorePrdIssueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCorePrdIssueBase pSCorePrdIssueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCorePrdIssueBase.isCreateDateDirty() && (bl || pSCorePrdIssueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCorePrdIssueBase.getCreateDate());
        }
        if (pSCorePrdIssueBase.isCreateManDirty() && (bl || pSCorePrdIssueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCorePrdIssueBase.getCreateMan());
        }
        if (pSCorePrdIssueBase.isIssueSNDirty() && (bl || pSCorePrdIssueBase.getIssueSN() != null)) {
            iDataObject.set(FIELD_ISSUESN, (Object)pSCorePrdIssueBase.getIssueSN());
        }
        if (pSCorePrdIssueBase.isIssueStateDirty() && (bl || pSCorePrdIssueBase.getIssueState() != null)) {
            iDataObject.set(FIELD_ISSUESTATE, (Object)pSCorePrdIssueBase.getIssueState());
        }
        if (pSCorePrdIssueBase.isIssueTagDirty() && (bl || pSCorePrdIssueBase.getIssueTag() != null)) {
            iDataObject.set(FIELD_ISSUETAG, (Object)pSCorePrdIssueBase.getIssueTag());
        }
        if (pSCorePrdIssueBase.isIssueTag2Dirty() && (bl || pSCorePrdIssueBase.getIssueTag2() != null)) {
            iDataObject.set(FIELD_ISSUETAG2, (Object)pSCorePrdIssueBase.getIssueTag2());
        }
        if (pSCorePrdIssueBase.isIssueUrlDirty() && (bl || pSCorePrdIssueBase.getIssueUrl() != null)) {
            iDataObject.set(FIELD_ISSUEURL, (Object)pSCorePrdIssueBase.getIssueUrl());
        }
        if (pSCorePrdIssueBase.isMemoDirty() && (bl || pSCorePrdIssueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCorePrdIssueBase.getMemo());
        }
        if (pSCorePrdIssueBase.isPSCorePrdIdDirty() && (bl || pSCorePrdIssueBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSCorePrdIssueBase.getPSCorePrdId());
        }
        if (pSCorePrdIssueBase.isPSCorePrdIssueIdDirty() && (bl || pSCorePrdIssueBase.getPSCorePrdIssueId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDISSUEID, (Object)pSCorePrdIssueBase.getPSCorePrdIssueId());
        }
        if (pSCorePrdIssueBase.isPSCorePrdIssueNameDirty() && (bl || pSCorePrdIssueBase.getPSCorePrdIssueName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDISSUENAME, (Object)pSCorePrdIssueBase.getPSCorePrdIssueName());
        }
        if (pSCorePrdIssueBase.isPSCorePrdNameDirty() && (bl || pSCorePrdIssueBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSCorePrdIssueBase.getPSCorePrdName());
        }
        if (pSCorePrdIssueBase.isPSCorePrdVerIdDirty() && (bl || pSCorePrdIssueBase.getPSCorePrdVerId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERID, (Object)pSCorePrdIssueBase.getPSCorePrdVerId());
        }
        if (pSCorePrdIssueBase.isPSCorePrdVerNameDirty() && (bl || pSCorePrdIssueBase.getPSCorePrdVerName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERNAME, (Object)pSCorePrdIssueBase.getPSCorePrdVerName());
        }
        if (pSCorePrdIssueBase.isRefPSCorePrdIssueIdDirty() && (bl || pSCorePrdIssueBase.getRefPSCorePrdIssueId() != null)) {
            iDataObject.set(FIELD_REFPSCOREPRDISSUEID, (Object)pSCorePrdIssueBase.getRefPSCorePrdIssueId());
        }
        if (pSCorePrdIssueBase.isRefPSCorePrdIssueNameDirty() && (bl || pSCorePrdIssueBase.getRefPSCorePrdIssueName() != null)) {
            iDataObject.set(FIELD_REFPSCOREPRDISSUENAME, (Object)pSCorePrdIssueBase.getRefPSCorePrdIssueName());
        }
        if (pSCorePrdIssueBase.isUpdateDateDirty() && (bl || pSCorePrdIssueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCorePrdIssueBase.getUpdateDate());
        }
        if (pSCorePrdIssueBase.isUpdateManDirty() && (bl || pSCorePrdIssueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCorePrdIssueBase.getUpdateMan());
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
        return PSCorePrdIssueBase.remove(this, n);
    }

    private static boolean remove(PSCorePrdIssueBase pSCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCorePrdIssueBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCorePrdIssueBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCorePrdIssueBase.resetIssueSN();
                return true;
            }
            case 3: {
                pSCorePrdIssueBase.resetIssueState();
                return true;
            }
            case 4: {
                pSCorePrdIssueBase.resetIssueTag();
                return true;
            }
            case 5: {
                pSCorePrdIssueBase.resetIssueTag2();
                return true;
            }
            case 6: {
                pSCorePrdIssueBase.resetIssueUrl();
                return true;
            }
            case 7: {
                pSCorePrdIssueBase.resetMemo();
                return true;
            }
            case 8: {
                pSCorePrdIssueBase.resetPSCorePrdId();
                return true;
            }
            case 9: {
                pSCorePrdIssueBase.resetPSCorePrdIssueId();
                return true;
            }
            case 10: {
                pSCorePrdIssueBase.resetPSCorePrdIssueName();
                return true;
            }
            case 11: {
                pSCorePrdIssueBase.resetPSCorePrdName();
                return true;
            }
            case 12: {
                pSCorePrdIssueBase.resetPSCorePrdVerId();
                return true;
            }
            case 13: {
                pSCorePrdIssueBase.resetPSCorePrdVerName();
                return true;
            }
            case 14: {
                pSCorePrdIssueBase.resetRefPSCorePrdIssueId();
                return true;
            }
            case 15: {
                pSCorePrdIssueBase.resetRefPSCorePrdIssueName();
                return true;
            }
            case 16: {
                pSCorePrdIssueBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSCorePrdIssueBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdIssue getRefPSCorePrdIssue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSCorePrdIssue();
        }
        if (this.getRefPSCorePrdIssueId() == null) {
            return null;
        }
        Integer n = this.objRefPSCorePrdIssueLock;
        synchronized (n) {
            if (this.refpscoreprdissue != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSCorePrdIssueId(), (Object)this.refpscoreprdissue.getPSCorePrdIssueId()) != 0L) {
                this.refpscoreprdissue = null;
            }
            if (this.refpscoreprdissue == null) {
                PSCorePrdIssue pSCorePrdIssue = new PSCorePrdIssue();
                pSCorePrdIssue.setPSCorePrdIssueId(this.getRefPSCorePrdIssueId());
                PSCorePrdIssueService pSCorePrdIssueService = (PSCorePrdIssueService)ServiceGlobal.getService(PSCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdIssueService.autoGet(pSCorePrdIssue);
                this.refpscoreprdissue = pSCorePrdIssue;
            }
            return this.refpscoreprdissue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdVer getPSCoreRepVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCoreRepVer();
        }
        if (this.getPSCorePrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSCoreRepVerLock;
        synchronized (n) {
            if (this.pscorerepver != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdVerId(), (Object)this.pscorerepver.getPSCorePrdVerId()) != 0L) {
                this.pscorerepver = null;
            }
            if (this.pscorerepver == null) {
                PSCorePrdVer pSCorePrdVer = new PSCorePrdVer();
                pSCorePrdVer.setPSCorePrdVerId(this.getPSCorePrdVerId());
                PSCorePrdVerService pSCorePrdVerService = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdVerService.autoGet(pSCorePrdVer);
                this.pscorerepver = pSCorePrdVer;
            }
            return this.pscorerepver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrd getPSCorePrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrd();
        }
        if (this.getPSCorePrdId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdLock;
        synchronized (n) {
            if (this.pscoreprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdId(), (Object)this.pscoreprd.getPSCorePrdId()) != 0L) {
                this.pscoreprd = null;
            }
            if (this.pscoreprd == null) {
                PSCorePrd pSCorePrd = new PSCorePrd();
                pSCorePrd.setPSCorePrdId(this.getPSCorePrdId());
                PSCorePrdService pSCorePrdService = (PSCorePrdService)ServiceGlobal.getService(PSCorePrdService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdService.autoGet(pSCorePrd);
                this.pscoreprd = pSCorePrd;
            }
            return this.pscoreprd;
        }
    }

    private PSCorePrdIssueBase getProxyEntity() {
        return this.proxyPSCorePrdIssueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCorePrdIssueBase = null;
        if (iDataObject != null && iDataObject instanceof PSCorePrdIssueBase) {
            this.proxyPSCorePrdIssueBase = (PSCorePrdIssueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ISSUESN, 2);
        fieldIndexMap.put(FIELD_ISSUESTATE, 3);
        fieldIndexMap.put(FIELD_ISSUETAG, 4);
        fieldIndexMap.put(FIELD_ISSUETAG2, 5);
        fieldIndexMap.put(FIELD_ISSUEURL, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 8);
        fieldIndexMap.put(FIELD_PSCOREPRDISSUEID, 9);
        fieldIndexMap.put(FIELD_PSCOREPRDISSUENAME, 10);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 11);
        fieldIndexMap.put(FIELD_PSCOREPRDVERID, 12);
        fieldIndexMap.put(FIELD_PSCOREPRDVERNAME, 13);
        fieldIndexMap.put(FIELD_REFPSCOREPRDISSUEID, 14);
        fieldIndexMap.put(FIELD_REFPSCOREPRDISSUENAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

