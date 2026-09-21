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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCat;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssue;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdCatService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCCorePrdIssueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCCorePrdIssueBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISSUEMEMO = "ISSUEMEMO";
    public static final String FIELD_ISSUEREPLY = "ISSUEREPLY";
    public static final String FIELD_ISSUESTATE = "ISSUESTATE";
    public static final String FIELD_PSCOREPRDCATID = "PSCOREPRDCATID";
    public static final String FIELD_PSCOREPRDCATNAME = "PSCOREPRDCATNAME";
    public static final String FIELD_PSCOREPRDFUNCID = "PSCOREPRDFUNCID";
    public static final String FIELD_PSCOREPRDFUNCNAME = "PSCOREPRDFUNCNAME";
    public static final String FIELD_PSCOREPRDID = "PSCOREPRDID";
    public static final String FIELD_PSCOREPRDISSUEID = "PSCOREPRDISSUEID";
    public static final String FIELD_PSCOREPRDISSUENAME = "PSCOREPRDISSUENAME";
    public static final String FIELD_PSCOREPRDNAME = "PSCOREPRDNAME";
    public static final String FIELD_PSDCCOREPRDISSUEID = "PSDCCOREPRDISSUEID";
    public static final String FIELD_PSDCCOREPRDISSUENAME = "PSDCCOREPRDISSUENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REPLYDATE = "REPLYDATE";
    public static final String FIELD_REPLYMAN = "REPLYMAN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ISSUEMEMO = 2;
    private static final int INDEX_ISSUEREPLY = 3;
    private static final int INDEX_ISSUESTATE = 4;
    private static final int INDEX_PSCOREPRDCATID = 5;
    private static final int INDEX_PSCOREPRDCATNAME = 6;
    private static final int INDEX_PSCOREPRDFUNCID = 7;
    private static final int INDEX_PSCOREPRDFUNCNAME = 8;
    private static final int INDEX_PSCOREPRDID = 9;
    private static final int INDEX_PSCOREPRDISSUEID = 10;
    private static final int INDEX_PSCOREPRDISSUENAME = 11;
    private static final int INDEX_PSCOREPRDNAME = 12;
    private static final int INDEX_PSDCCOREPRDISSUEID = 13;
    private static final int INDEX_PSDCCOREPRDISSUENAME = 14;
    private static final int INDEX_PSDEVCENTERID = 15;
    private static final int INDEX_PSDEVCENTERNAME = 16;
    private static final int INDEX_REPLYDATE = 17;
    private static final int INDEX_REPLYMAN = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCCorePrdIssueBase proxyPSDCCorePrdIssueBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issuememoDirtyFlag = false;
    private boolean issuereplyDirtyFlag = false;
    private boolean issuestateDirtyFlag = false;
    private boolean pscoreprdcatidDirtyFlag = false;
    private boolean pscoreprdcatnameDirtyFlag = false;
    private boolean pscoreprdfuncidDirtyFlag = false;
    private boolean pscoreprdfuncnameDirtyFlag = false;
    private boolean pscoreprdidDirtyFlag = false;
    private boolean pscoreprdissueidDirtyFlag = false;
    private boolean pscoreprdissuenameDirtyFlag = false;
    private boolean pscoreprdnameDirtyFlag = false;
    private boolean psdccoreprdissueidDirtyFlag = false;
    private boolean psdccoreprdissuenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean replydateDirtyFlag = false;
    private boolean replymanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issuememo")
    private String issuememo;
    @Column(name="issuereply")
    private String issuereply;
    @Column(name="issuestate")
    private Integer issuestate;
    @Column(name="pscoreprdcatid")
    private String pscoreprdcatid;
    @Column(name="pscoreprdcatname")
    private String pscoreprdcatname;
    @Column(name="pscoreprdfuncid")
    private String pscoreprdfuncid;
    @Column(name="pscoreprdfuncname")
    private String pscoreprdfuncname;
    @Column(name="pscoreprdid")
    private String pscoreprdid;
    @Column(name="pscoreprdissueid")
    private String pscoreprdissueid;
    @Column(name="pscoreprdissuename")
    private String pscoreprdissuename;
    @Column(name="pscoreprdname")
    private String pscoreprdname;
    @Column(name="psdccoreprdissueid")
    private String psdccoreprdissueid;
    @Column(name="psdccoreprdissuename")
    private String psdccoreprdissuename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="replydate")
    private Timestamp replydate;
    @Column(name="replyman")
    private String replyman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCorePrdCatLock = new Integer(1);
    private PSCorePrdCat pscoreprdcat = null;
    private Integer objPSCorePrdFuncLock = new Integer(1);
    private PSCorePrdFunc pscoreprdfunc = null;
    private Integer objPSCorePrdIssueLock = new Integer(1);
    private PSCorePrdIssue pscoreprdissue = null;
    private Integer objPSCorePrdLock = new Integer(1);
    private PSCorePrd pscoreprd = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setIssueMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuememo = string;
        this.issuememoDirtyFlag = true;
    }

    public String getIssueMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueMemo();
        }
        return this.issuememo;
    }

    public boolean isIssueMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueMemoDirty();
        }
        return this.issuememoDirtyFlag;
    }

    public void resetIssueMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueMemo();
            return;
        }
        this.issuememoDirtyFlag = false;
        this.issuememo = null;
    }

    public void setIssueReply(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueReply(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuereply = string;
        this.issuereplyDirtyFlag = true;
    }

    public String getIssueReply() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueReply();
        }
        return this.issuereply;
    }

    public boolean isIssueReplyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueReplyDirty();
        }
        return this.issuereplyDirtyFlag;
    }

    public void resetIssueReply() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueReply();
            return;
        }
        this.issuereplyDirtyFlag = false;
        this.issuereply = null;
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

    public void setPSCorePrdCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdcatid = string;
        this.pscoreprdcatidDirtyFlag = true;
    }

    public String getPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCatId();
        }
        return this.pscoreprdcatid;
    }

    public boolean isPSCorePrdCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdCatIdDirty();
        }
        return this.pscoreprdcatidDirtyFlag;
    }

    public void resetPSCorePrdCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdCatId();
            return;
        }
        this.pscoreprdcatidDirtyFlag = false;
        this.pscoreprdcatid = null;
    }

    public void setPSCorePrdCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdcatname = string;
        this.pscoreprdcatnameDirtyFlag = true;
    }

    public String getPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCatName();
        }
        return this.pscoreprdcatname;
    }

    public boolean isPSCorePrdCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdCatNameDirty();
        }
        return this.pscoreprdcatnameDirtyFlag;
    }

    public void resetPSCorePrdCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdCatName();
            return;
        }
        this.pscoreprdcatnameDirtyFlag = false;
        this.pscoreprdcatname = null;
    }

    public void setPSCorePrdFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncid = string;
        this.pscoreprdfuncidDirtyFlag = true;
    }

    public String getPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncId();
        }
        return this.pscoreprdfuncid;
    }

    public boolean isPSCorePrdFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncIdDirty();
        }
        return this.pscoreprdfuncidDirtyFlag;
    }

    public void resetPSCorePrdFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncId();
            return;
        }
        this.pscoreprdfuncidDirtyFlag = false;
        this.pscoreprdfuncid = null;
    }

    public void setPSCorePrdFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdfuncname = string;
        this.pscoreprdfuncnameDirtyFlag = true;
    }

    public String getPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFuncName();
        }
        return this.pscoreprdfuncname;
    }

    public boolean isPSCorePrdFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdFuncNameDirty();
        }
        return this.pscoreprdfuncnameDirtyFlag;
    }

    public void resetPSCorePrdFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdFuncName();
            return;
        }
        this.pscoreprdfuncnameDirtyFlag = false;
        this.pscoreprdfuncname = null;
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

    public void setPSDCCorePrdIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCorePrdIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccoreprdissueid = string;
        this.psdccoreprdissueidDirtyFlag = true;
    }

    public String getPSDCCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCorePrdIssueId();
        }
        return this.psdccoreprdissueid;
    }

    public boolean isPSDCCorePrdIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCorePrdIssueIdDirty();
        }
        return this.psdccoreprdissueidDirtyFlag;
    }

    public void resetPSDCCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCorePrdIssueId();
            return;
        }
        this.psdccoreprdissueidDirtyFlag = false;
        this.psdccoreprdissueid = null;
    }

    public void setPSDCCorePrdIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCorePrdIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccoreprdissuename = string;
        this.psdccoreprdissuenameDirtyFlag = true;
    }

    public String getPSDCCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCorePrdIssueName();
        }
        return this.psdccoreprdissuename;
    }

    public boolean isPSDCCorePrdIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCorePrdIssueNameDirty();
        }
        return this.psdccoreprdissuenameDirtyFlag;
    }

    public void resetPSDCCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCorePrdIssueName();
            return;
        }
        this.psdccoreprdissuenameDirtyFlag = false;
        this.psdccoreprdissuename = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setReplyDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReplyDate(timestamp);
            return;
        }
        this.replydate = timestamp;
        this.replydateDirtyFlag = true;
    }

    public Timestamp getReplyDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReplyDate();
        }
        return this.replydate;
    }

    public boolean isReplyDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReplyDateDirty();
        }
        return this.replydateDirtyFlag;
    }

    public void resetReplyDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReplyDate();
            return;
        }
        this.replydateDirtyFlag = false;
        this.replydate = null;
    }

    public void setReplyMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReplyMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.replyman = string;
        this.replymanDirtyFlag = true;
    }

    public String getReplyMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReplyMan();
        }
        return this.replyman;
    }

    public boolean isReplyManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReplyManDirty();
        }
        return this.replymanDirtyFlag;
    }

    public void resetReplyMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReplyMan();
            return;
        }
        this.replymanDirtyFlag = false;
        this.replyman = null;
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
        PSDCCorePrdIssueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCCorePrdIssueBase pSDCCorePrdIssueBase) {
        pSDCCorePrdIssueBase.resetCreateDate();
        pSDCCorePrdIssueBase.resetCreateMan();
        pSDCCorePrdIssueBase.resetIssueMemo();
        pSDCCorePrdIssueBase.resetIssueReply();
        pSDCCorePrdIssueBase.resetIssueState();
        pSDCCorePrdIssueBase.resetPSCorePrdCatId();
        pSDCCorePrdIssueBase.resetPSCorePrdCatName();
        pSDCCorePrdIssueBase.resetPSCorePrdFuncId();
        pSDCCorePrdIssueBase.resetPSCorePrdFuncName();
        pSDCCorePrdIssueBase.resetPSCorePrdId();
        pSDCCorePrdIssueBase.resetPSCorePrdIssueId();
        pSDCCorePrdIssueBase.resetPSCorePrdIssueName();
        pSDCCorePrdIssueBase.resetPSCorePrdName();
        pSDCCorePrdIssueBase.resetPSDCCorePrdIssueId();
        pSDCCorePrdIssueBase.resetPSDCCorePrdIssueName();
        pSDCCorePrdIssueBase.resetPSDevCenterId();
        pSDCCorePrdIssueBase.resetPSDevCenterName();
        pSDCCorePrdIssueBase.resetReplyDate();
        pSDCCorePrdIssueBase.resetReplyMan();
        pSDCCorePrdIssueBase.resetUpdateDate();
        pSDCCorePrdIssueBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIssueMemoDirty()) {
            hashMap.put(FIELD_ISSUEMEMO, this.getIssueMemo());
        }
        if (!bl || this.isIssueReplyDirty()) {
            hashMap.put(FIELD_ISSUEREPLY, this.getIssueReply());
        }
        if (!bl || this.isIssueStateDirty()) {
            hashMap.put(FIELD_ISSUESTATE, this.getIssueState());
        }
        if (!bl || this.isPSCorePrdCatIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDCATID, this.getPSCorePrdCatId());
        }
        if (!bl || this.isPSCorePrdCatNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDCATNAME, this.getPSCorePrdCatName());
        }
        if (!bl || this.isPSCorePrdFuncIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCID, this.getPSCorePrdFuncId());
        }
        if (!bl || this.isPSCorePrdFuncNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDFUNCNAME, this.getPSCorePrdFuncName());
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
        if (!bl || this.isPSDCCorePrdIssueIdDirty()) {
            hashMap.put(FIELD_PSDCCOREPRDISSUEID, this.getPSDCCorePrdIssueId());
        }
        if (!bl || this.isPSDCCorePrdIssueNameDirty()) {
            hashMap.put(FIELD_PSDCCOREPRDISSUENAME, this.getPSDCCorePrdIssueName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isReplyDateDirty()) {
            hashMap.put(FIELD_REPLYDATE, this.getReplyDate());
        }
        if (!bl || this.isReplyManDirty()) {
            hashMap.put(FIELD_REPLYMAN, this.getReplyMan());
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
        return PSDCCorePrdIssueBase.get(this, n);
    }

    private static Object get(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCorePrdIssueBase.getCreateDate();
            }
            case 1: {
                return pSDCCorePrdIssueBase.getCreateMan();
            }
            case 2: {
                return pSDCCorePrdIssueBase.getIssueMemo();
            }
            case 3: {
                return pSDCCorePrdIssueBase.getIssueReply();
            }
            case 4: {
                return pSDCCorePrdIssueBase.getIssueState();
            }
            case 5: {
                return pSDCCorePrdIssueBase.getPSCorePrdCatId();
            }
            case 6: {
                return pSDCCorePrdIssueBase.getPSCorePrdCatName();
            }
            case 7: {
                return pSDCCorePrdIssueBase.getPSCorePrdFuncId();
            }
            case 8: {
                return pSDCCorePrdIssueBase.getPSCorePrdFuncName();
            }
            case 9: {
                return pSDCCorePrdIssueBase.getPSCorePrdId();
            }
            case 10: {
                return pSDCCorePrdIssueBase.getPSCorePrdIssueId();
            }
            case 11: {
                return pSDCCorePrdIssueBase.getPSCorePrdIssueName();
            }
            case 12: {
                return pSDCCorePrdIssueBase.getPSCorePrdName();
            }
            case 13: {
                return pSDCCorePrdIssueBase.getPSDCCorePrdIssueId();
            }
            case 14: {
                return pSDCCorePrdIssueBase.getPSDCCorePrdIssueName();
            }
            case 15: {
                return pSDCCorePrdIssueBase.getPSDevCenterId();
            }
            case 16: {
                return pSDCCorePrdIssueBase.getPSDevCenterName();
            }
            case 17: {
                return pSDCCorePrdIssueBase.getReplyDate();
            }
            case 18: {
                return pSDCCorePrdIssueBase.getReplyMan();
            }
            case 19: {
                return pSDCCorePrdIssueBase.getUpdateDate();
            }
            case 20: {
                return pSDCCorePrdIssueBase.getUpdateMan();
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
        PSDCCorePrdIssueBase.set(this, n, object);
    }

    private static void set(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCCorePrdIssueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCCorePrdIssueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCCorePrdIssueBase.setIssueMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCCorePrdIssueBase.setIssueReply(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCCorePrdIssueBase.setIssueState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCCorePrdIssueBase.setPSCorePrdCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCCorePrdIssueBase.setPSCorePrdCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCCorePrdIssueBase.setPSCorePrdFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCCorePrdIssueBase.setPSCorePrdFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCCorePrdIssueBase.setPSCorePrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCCorePrdIssueBase.setPSCorePrdIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCCorePrdIssueBase.setPSCorePrdIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCCorePrdIssueBase.setPSCorePrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCCorePrdIssueBase.setPSDCCorePrdIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCCorePrdIssueBase.setPSDCCorePrdIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCCorePrdIssueBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCCorePrdIssueBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCCorePrdIssueBase.setReplyDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDCCorePrdIssueBase.setReplyMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCCorePrdIssueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSDCCorePrdIssueBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCCorePrdIssueBase.isNull(this, n);
    }

    private static boolean isNull(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCorePrdIssueBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCCorePrdIssueBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCCorePrdIssueBase.getIssueMemo() == null;
            }
            case 3: {
                return pSDCCorePrdIssueBase.getIssueReply() == null;
            }
            case 4: {
                return pSDCCorePrdIssueBase.getIssueState() == null;
            }
            case 5: {
                return pSDCCorePrdIssueBase.getPSCorePrdCatId() == null;
            }
            case 6: {
                return pSDCCorePrdIssueBase.getPSCorePrdCatName() == null;
            }
            case 7: {
                return pSDCCorePrdIssueBase.getPSCorePrdFuncId() == null;
            }
            case 8: {
                return pSDCCorePrdIssueBase.getPSCorePrdFuncName() == null;
            }
            case 9: {
                return pSDCCorePrdIssueBase.getPSCorePrdId() == null;
            }
            case 10: {
                return pSDCCorePrdIssueBase.getPSCorePrdIssueId() == null;
            }
            case 11: {
                return pSDCCorePrdIssueBase.getPSCorePrdIssueName() == null;
            }
            case 12: {
                return pSDCCorePrdIssueBase.getPSCorePrdName() == null;
            }
            case 13: {
                return pSDCCorePrdIssueBase.getPSDCCorePrdIssueId() == null;
            }
            case 14: {
                return pSDCCorePrdIssueBase.getPSDCCorePrdIssueName() == null;
            }
            case 15: {
                return pSDCCorePrdIssueBase.getPSDevCenterId() == null;
            }
            case 16: {
                return pSDCCorePrdIssueBase.getPSDevCenterName() == null;
            }
            case 17: {
                return pSDCCorePrdIssueBase.getReplyDate() == null;
            }
            case 18: {
                return pSDCCorePrdIssueBase.getReplyMan() == null;
            }
            case 19: {
                return pSDCCorePrdIssueBase.getUpdateDate() == null;
            }
            case 20: {
                return pSDCCorePrdIssueBase.getUpdateMan() == null;
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
        return PSDCCorePrdIssueBase.contains(this, n);
    }

    private static boolean contains(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCCorePrdIssueBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCCorePrdIssueBase.isCreateManDirty();
            }
            case 2: {
                return pSDCCorePrdIssueBase.isIssueMemoDirty();
            }
            case 3: {
                return pSDCCorePrdIssueBase.isIssueReplyDirty();
            }
            case 4: {
                return pSDCCorePrdIssueBase.isIssueStateDirty();
            }
            case 5: {
                return pSDCCorePrdIssueBase.isPSCorePrdCatIdDirty();
            }
            case 6: {
                return pSDCCorePrdIssueBase.isPSCorePrdCatNameDirty();
            }
            case 7: {
                return pSDCCorePrdIssueBase.isPSCorePrdFuncIdDirty();
            }
            case 8: {
                return pSDCCorePrdIssueBase.isPSCorePrdFuncNameDirty();
            }
            case 9: {
                return pSDCCorePrdIssueBase.isPSCorePrdIdDirty();
            }
            case 10: {
                return pSDCCorePrdIssueBase.isPSCorePrdIssueIdDirty();
            }
            case 11: {
                return pSDCCorePrdIssueBase.isPSCorePrdIssueNameDirty();
            }
            case 12: {
                return pSDCCorePrdIssueBase.isPSCorePrdNameDirty();
            }
            case 13: {
                return pSDCCorePrdIssueBase.isPSDCCorePrdIssueIdDirty();
            }
            case 14: {
                return pSDCCorePrdIssueBase.isPSDCCorePrdIssueNameDirty();
            }
            case 15: {
                return pSDCCorePrdIssueBase.isPSDevCenterIdDirty();
            }
            case 16: {
                return pSDCCorePrdIssueBase.isPSDevCenterNameDirty();
            }
            case 17: {
                return pSDCCorePrdIssueBase.isReplyDateDirty();
            }
            case 18: {
                return pSDCCorePrdIssueBase.isReplyManDirty();
            }
            case 19: {
                return pSDCCorePrdIssueBase.isUpdateDateDirty();
            }
            case 20: {
                return pSDCCorePrdIssueBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCCorePrdIssueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCCorePrdIssueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getIssueMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuememo", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getIssueMemo()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getIssueReply() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuereply", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getIssueReply()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getIssueState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuestate", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getIssueState()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdcatid", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdCatId()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdcatname", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdCatName()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncid", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdFuncId()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdfuncname", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdFuncName()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdid", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdId()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdissueid", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdIssueId()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdissuename", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdIssueName()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdname", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSCorePrdName()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDCCorePrdIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccoreprdissueid", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSDCCorePrdIssueId()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDCCorePrdIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccoreprdissuename", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSDCCorePrdIssueName()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getReplyDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"replydate", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getReplyDate()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getReplyMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"replyman", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getReplyMan()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCCorePrdIssueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCCorePrdIssueBase.getJSONValue((Object)pSDCCorePrdIssueBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCCorePrdIssueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCCorePrdIssueBase.getCreateDate() != null) {
            object = pSDCCorePrdIssueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCCorePrdIssueBase.getCreateMan() != null) {
            object = pSDCCorePrdIssueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getIssueMemo() != null) {
            object = pSDCCorePrdIssueBase.getIssueMemo();
            xmlNode.setAttribute(FIELD_ISSUEMEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getIssueReply() != null) {
            object = pSDCCorePrdIssueBase.getIssueReply();
            xmlNode.setAttribute(FIELD_ISSUEREPLY, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getIssueState() != null) {
            object = pSDCCorePrdIssueBase.getIssueState();
            xmlNode.setAttribute(FIELD_ISSUESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdCatId() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdCatId();
            xmlNode.setAttribute(FIELD_PSCOREPRDCATID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdCatName() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdCatName();
            xmlNode.setAttribute(FIELD_PSCOREPRDCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdFuncId() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdFuncId();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdFuncName() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdFuncName();
            xmlNode.setAttribute(FIELD_PSCOREPRDFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdId() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdId();
            xmlNode.setAttribute(FIELD_PSCOREPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdIssueId() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdIssueId();
            xmlNode.setAttribute(FIELD_PSCOREPRDISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdIssueName() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdIssueName();
            xmlNode.setAttribute(FIELD_PSCOREPRDISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSCorePrdName() != null) {
            object = pSDCCorePrdIssueBase.getPSCorePrdName();
            xmlNode.setAttribute(FIELD_PSCOREPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDCCorePrdIssueId() != null) {
            object = pSDCCorePrdIssueBase.getPSDCCorePrdIssueId();
            xmlNode.setAttribute(FIELD_PSDCCOREPRDISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDCCorePrdIssueName() != null) {
            object = pSDCCorePrdIssueBase.getPSDCCorePrdIssueName();
            xmlNode.setAttribute(FIELD_PSDCCOREPRDISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDevCenterId() != null) {
            object = pSDCCorePrdIssueBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getPSDevCenterName() != null) {
            object = pSDCCorePrdIssueBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getReplyDate() != null) {
            object = pSDCCorePrdIssueBase.getReplyDate();
            xmlNode.setAttribute(FIELD_REPLYDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCCorePrdIssueBase.getReplyMan() != null) {
            object = pSDCCorePrdIssueBase.getReplyMan();
            xmlNode.setAttribute(FIELD_REPLYMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCCorePrdIssueBase.getUpdateDate() != null) {
            object = pSDCCorePrdIssueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCCorePrdIssueBase.getUpdateMan() != null) {
            object = pSDCCorePrdIssueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCCorePrdIssueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCCorePrdIssueBase.isCreateDateDirty() && (bl || pSDCCorePrdIssueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCCorePrdIssueBase.getCreateDate());
        }
        if (pSDCCorePrdIssueBase.isCreateManDirty() && (bl || pSDCCorePrdIssueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCCorePrdIssueBase.getCreateMan());
        }
        if (pSDCCorePrdIssueBase.isIssueMemoDirty() && (bl || pSDCCorePrdIssueBase.getIssueMemo() != null)) {
            iDataObject.set(FIELD_ISSUEMEMO, (Object)pSDCCorePrdIssueBase.getIssueMemo());
        }
        if (pSDCCorePrdIssueBase.isIssueReplyDirty() && (bl || pSDCCorePrdIssueBase.getIssueReply() != null)) {
            iDataObject.set(FIELD_ISSUEREPLY, (Object)pSDCCorePrdIssueBase.getIssueReply());
        }
        if (pSDCCorePrdIssueBase.isIssueStateDirty() && (bl || pSDCCorePrdIssueBase.getIssueState() != null)) {
            iDataObject.set(FIELD_ISSUESTATE, (Object)pSDCCorePrdIssueBase.getIssueState());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdCatIdDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdCatId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDCATID, (Object)pSDCCorePrdIssueBase.getPSCorePrdCatId());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdCatNameDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdCatName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDCATNAME, (Object)pSDCCorePrdIssueBase.getPSCorePrdCatName());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdFuncIdDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdFuncId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCID, (Object)pSDCCorePrdIssueBase.getPSCorePrdFuncId());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdFuncNameDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdFuncName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDFUNCNAME, (Object)pSDCCorePrdIssueBase.getPSCorePrdFuncName());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdIdDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDID, (Object)pSDCCorePrdIssueBase.getPSCorePrdId());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdIssueIdDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdIssueId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDISSUEID, (Object)pSDCCorePrdIssueBase.getPSCorePrdIssueId());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdIssueNameDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdIssueName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDISSUENAME, (Object)pSDCCorePrdIssueBase.getPSCorePrdIssueName());
        }
        if (pSDCCorePrdIssueBase.isPSCorePrdNameDirty() && (bl || pSDCCorePrdIssueBase.getPSCorePrdName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDNAME, (Object)pSDCCorePrdIssueBase.getPSCorePrdName());
        }
        if (pSDCCorePrdIssueBase.isPSDCCorePrdIssueIdDirty() && (bl || pSDCCorePrdIssueBase.getPSDCCorePrdIssueId() != null)) {
            iDataObject.set(FIELD_PSDCCOREPRDISSUEID, (Object)pSDCCorePrdIssueBase.getPSDCCorePrdIssueId());
        }
        if (pSDCCorePrdIssueBase.isPSDCCorePrdIssueNameDirty() && (bl || pSDCCorePrdIssueBase.getPSDCCorePrdIssueName() != null)) {
            iDataObject.set(FIELD_PSDCCOREPRDISSUENAME, (Object)pSDCCorePrdIssueBase.getPSDCCorePrdIssueName());
        }
        if (pSDCCorePrdIssueBase.isPSDevCenterIdDirty() && (bl || pSDCCorePrdIssueBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCCorePrdIssueBase.getPSDevCenterId());
        }
        if (pSDCCorePrdIssueBase.isPSDevCenterNameDirty() && (bl || pSDCCorePrdIssueBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCCorePrdIssueBase.getPSDevCenterName());
        }
        if (pSDCCorePrdIssueBase.isReplyDateDirty() && (bl || pSDCCorePrdIssueBase.getReplyDate() != null)) {
            iDataObject.set(FIELD_REPLYDATE, (Object)pSDCCorePrdIssueBase.getReplyDate());
        }
        if (pSDCCorePrdIssueBase.isReplyManDirty() && (bl || pSDCCorePrdIssueBase.getReplyMan() != null)) {
            iDataObject.set(FIELD_REPLYMAN, (Object)pSDCCorePrdIssueBase.getReplyMan());
        }
        if (pSDCCorePrdIssueBase.isUpdateDateDirty() && (bl || pSDCCorePrdIssueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCCorePrdIssueBase.getUpdateDate());
        }
        if (pSDCCorePrdIssueBase.isUpdateManDirty() && (bl || pSDCCorePrdIssueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCCorePrdIssueBase.getUpdateMan());
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
        return PSDCCorePrdIssueBase.remove(this, n);
    }

    private static boolean remove(PSDCCorePrdIssueBase pSDCCorePrdIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCCorePrdIssueBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCCorePrdIssueBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCCorePrdIssueBase.resetIssueMemo();
                return true;
            }
            case 3: {
                pSDCCorePrdIssueBase.resetIssueReply();
                return true;
            }
            case 4: {
                pSDCCorePrdIssueBase.resetIssueState();
                return true;
            }
            case 5: {
                pSDCCorePrdIssueBase.resetPSCorePrdCatId();
                return true;
            }
            case 6: {
                pSDCCorePrdIssueBase.resetPSCorePrdCatName();
                return true;
            }
            case 7: {
                pSDCCorePrdIssueBase.resetPSCorePrdFuncId();
                return true;
            }
            case 8: {
                pSDCCorePrdIssueBase.resetPSCorePrdFuncName();
                return true;
            }
            case 9: {
                pSDCCorePrdIssueBase.resetPSCorePrdId();
                return true;
            }
            case 10: {
                pSDCCorePrdIssueBase.resetPSCorePrdIssueId();
                return true;
            }
            case 11: {
                pSDCCorePrdIssueBase.resetPSCorePrdIssueName();
                return true;
            }
            case 12: {
                pSDCCorePrdIssueBase.resetPSCorePrdName();
                return true;
            }
            case 13: {
                pSDCCorePrdIssueBase.resetPSDCCorePrdIssueId();
                return true;
            }
            case 14: {
                pSDCCorePrdIssueBase.resetPSDCCorePrdIssueName();
                return true;
            }
            case 15: {
                pSDCCorePrdIssueBase.resetPSDevCenterId();
                return true;
            }
            case 16: {
                pSDCCorePrdIssueBase.resetPSDevCenterName();
                return true;
            }
            case 17: {
                pSDCCorePrdIssueBase.resetReplyDate();
                return true;
            }
            case 18: {
                pSDCCorePrdIssueBase.resetReplyMan();
                return true;
            }
            case 19: {
                pSDCCorePrdIssueBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSDCCorePrdIssueBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdCat getPSCorePrdCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdCat();
        }
        if (this.getPSCorePrdCatId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdCatLock;
        synchronized (n) {
            if (this.pscoreprdcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdCatId(), (Object)this.pscoreprdcat.getPSCorePrdCatId()) != 0L) {
                this.pscoreprdcat = null;
            }
            if (this.pscoreprdcat == null) {
                PSCorePrdCat pSCorePrdCat = new PSCorePrdCat();
                pSCorePrdCat.setPSCorePrdCatId(this.getPSCorePrdCatId());
                PSCorePrdCatService pSCorePrdCatService = (PSCorePrdCatService)ServiceGlobal.getService(PSCorePrdCatService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdCatService.autoGet((IEntity)pSCorePrdCat);
                this.pscoreprdcat = pSCorePrdCat;
            }
            return this.pscoreprdcat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdFunc getPSCorePrdFunc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdFunc();
        }
        if (this.getPSCorePrdFuncId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdFuncLock;
        synchronized (n) {
            if (this.pscoreprdfunc != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdFuncId(), (Object)this.pscoreprdfunc.getPSCorePrdFuncId()) != 0L) {
                this.pscoreprdfunc = null;
            }
            if (this.pscoreprdfunc == null) {
                PSCorePrdFunc pSCorePrdFunc = new PSCorePrdFunc();
                pSCorePrdFunc.setPSCorePrdFuncId(this.getPSCorePrdFuncId());
                PSCorePrdFuncService pSCorePrdFuncService = (PSCorePrdFuncService)ServiceGlobal.getService(PSCorePrdFuncService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdFuncService.autoGet((IEntity)pSCorePrdFunc);
                this.pscoreprdfunc = pSCorePrdFunc;
            }
            return this.pscoreprdfunc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdIssue getPSCorePrdIssue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdIssue();
        }
        if (this.getPSCorePrdIssueId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdIssueLock;
        synchronized (n) {
            if (this.pscoreprdissue != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdIssueId(), (Object)this.pscoreprdissue.getPSCorePrdIssueId()) != 0L) {
                this.pscoreprdissue = null;
            }
            if (this.pscoreprdissue == null) {
                PSCorePrdIssue pSCorePrdIssue = new PSCorePrdIssue();
                pSCorePrdIssue.setPSCorePrdIssueId(this.getPSCorePrdIssueId());
                PSCorePrdIssueService pSCorePrdIssueService = (PSCorePrdIssueService)ServiceGlobal.getService(PSCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdIssueService.autoGet((IEntity)pSCorePrdIssue);
                this.pscoreprdissue = pSCorePrdIssue;
            }
            return this.pscoreprdissue;
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
                pSCorePrdService.autoGet((IEntity)pSCorePrd);
                this.pscoreprd = pSCorePrd;
            }
            return this.pscoreprd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCCorePrdIssueBase getProxyEntity() {
        return this.proxyPSDCCorePrdIssueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCCorePrdIssueBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCCorePrdIssueBase) {
            this.proxyPSDCCorePrdIssueBase = (PSDCCorePrdIssueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDCCorePrdIssueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ISSUEMEMO, 2);
        fieldIndexMap.put(FIELD_ISSUEREPLY, 3);
        fieldIndexMap.put(FIELD_ISSUESTATE, 4);
        fieldIndexMap.put(FIELD_PSCOREPRDCATID, 5);
        fieldIndexMap.put(FIELD_PSCOREPRDCATNAME, 6);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCID, 7);
        fieldIndexMap.put(FIELD_PSCOREPRDFUNCNAME, 8);
        fieldIndexMap.put(FIELD_PSCOREPRDID, 9);
        fieldIndexMap.put(FIELD_PSCOREPRDISSUEID, 10);
        fieldIndexMap.put(FIELD_PSCOREPRDISSUENAME, 11);
        fieldIndexMap.put(FIELD_PSCOREPRDNAME, 12);
        fieldIndexMap.put(FIELD_PSDCCOREPRDISSUEID, 13);
        fieldIndexMap.put(FIELD_PSDCCOREPRDISSUENAME, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 16);
        fieldIndexMap.put(FIELD_REPLYDATE, 17);
        fieldIndexMap.put(FIELD_REPLYMAN, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
    }
}

