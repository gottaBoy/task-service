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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysIssueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysIssueBase.class);
    public static final String FIELD_CANCELDATE = "CANCELDATE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FINISHDATE = "FINISHDATE";
    public static final String FIELD_ISSUEINFO = "ISSUEINFO";
    public static final String FIELD_ISSUESTATE = "ISSUESTATE";
    public static final String FIELD_ISSUETYPE = "ISSUETYPE";
    public static final String FIELD_OBJTYPE = "OBJTYPE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSOBJ2ID = "PSOBJ2ID";
    public static final String FIELD_PSOBJ2NAME = "PSOBJ2NAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSISSUEID = "PSSYSISSUEID";
    public static final String FIELD_PSSYSISSUENAME = "PSSYSISSUENAME";
    public static final String FIELD_PSSYSISSUETYPEID = "PSSYSISSUETYPEID";
    public static final String FIELD_PSSYSISSUETYPENAME = "PSSYSISSUETYPENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CANCELDATE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FINISHDATE = 3;
    private static final int INDEX_ISSUEINFO = 4;
    private static final int INDEX_ISSUESTATE = 5;
    private static final int INDEX_ISSUETYPE = 6;
    private static final int INDEX_OBJTYPE = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDENAME = 9;
    private static final int INDEX_PSDYNAINSTID = 10;
    private static final int INDEX_PSOBJ2ID = 11;
    private static final int INDEX_PSOBJ2NAME = 12;
    private static final int INDEX_PSOBJID = 13;
    private static final int INDEX_PSOBJNAME = 14;
    private static final int INDEX_PSSYSAPPID = 15;
    private static final int INDEX_PSSYSAPPNAME = 16;
    private static final int INDEX_PSSYSISSUEID = 17;
    private static final int INDEX_PSSYSISSUENAME = 18;
    private static final int INDEX_PSSYSISSUETYPEID = 19;
    private static final int INDEX_PSSYSISSUETYPENAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysIssueBase proxyPSSysIssueBase = null;
    private boolean canceldateDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean finishdateDirtyFlag = false;
    private boolean issueinfoDirtyFlag = false;
    private boolean issuestateDirtyFlag = false;
    private boolean issuetypeDirtyFlag = false;
    private boolean objtypeDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psobj2idDirtyFlag = false;
    private boolean psobj2nameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysissueidDirtyFlag = false;
    private boolean pssysissuenameDirtyFlag = false;
    private boolean pssysissuetypeidDirtyFlag = false;
    private boolean pssysissuetypenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="canceldate")
    private Timestamp canceldate;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="finishdate")
    private Timestamp finishdate;
    @Column(name="issueinfo")
    private String issueinfo;
    @Column(name="issuestate")
    private String issuestate;
    @Column(name="issuetype")
    private String issuetype;
    @Column(name="objtype")
    private String objtype;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psobj2id")
    private String psobj2id;
    @Column(name="psobj2name")
    private String psobj2name;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysissueid")
    private String pssysissueid;
    @Column(name="pssysissuename")
    private String pssysissuename;
    @Column(name="pssysissuetypeid")
    private String pssysissuetypeid;
    @Column(name="pssysissuetypename")
    private String pssysissuetypename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCancelDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelDate(timestamp);
            return;
        }
        this.canceldate = timestamp;
        this.canceldateDirtyFlag = true;
    }

    public Timestamp getCancelDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelDate();
        }
        return this.canceldate;
    }

    public boolean isCancelDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelDateDirty();
        }
        return this.canceldateDirtyFlag;
    }

    public void resetCancelDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelDate();
            return;
        }
        this.canceldateDirtyFlag = false;
        this.canceldate = null;
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

    public void setFinishDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishDate(timestamp);
            return;
        }
        this.finishdate = timestamp;
        this.finishdateDirtyFlag = true;
    }

    public Timestamp getFinishDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishDate();
        }
        return this.finishdate;
    }

    public boolean isFinishDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishDateDirty();
        }
        return this.finishdateDirtyFlag;
    }

    public void resetFinishDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishDate();
            return;
        }
        this.finishdateDirtyFlag = false;
        this.finishdate = null;
    }

    public void setIssueInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issueinfo = string;
        this.issueinfoDirtyFlag = true;
    }

    public String getIssueInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueInfo();
        }
        return this.issueinfo;
    }

    public boolean isIssueInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueInfoDirty();
        }
        return this.issueinfoDirtyFlag;
    }

    public void resetIssueInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueInfo();
            return;
        }
        this.issueinfoDirtyFlag = false;
        this.issueinfo = null;
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

    public void setIssueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.issuetype = string;
        this.issuetypeDirtyFlag = true;
    }

    public String getIssueType() {
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

    public void setObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objtype = string;
        this.objtypeDirtyFlag = true;
    }

    public String getObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjType();
        }
        return this.objtype;
    }

    public boolean isObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjTypeDirty();
        }
        return this.objtypeDirtyFlag;
    }

    public void resetObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjType();
            return;
        }
        this.objtypeDirtyFlag = false;
        this.objtype = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSObj2Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObj2Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobj2id = string;
        this.psobj2idDirtyFlag = true;
    }

    public String getPSObj2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObj2Id();
        }
        return this.psobj2id;
    }

    public boolean isPSObj2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObj2IdDirty();
        }
        return this.psobj2idDirtyFlag;
    }

    public void resetPSObj2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObj2Id();
            return;
        }
        this.psobj2idDirtyFlag = false;
        this.psobj2id = null;
    }

    public void setPSObj2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObj2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobj2name = string;
        this.psobj2nameDirtyFlag = true;
    }

    public String getPSObj2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObj2Name();
        }
        return this.psobj2name;
    }

    public boolean isPSObj2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObj2NameDirty();
        }
        return this.psobj2nameDirtyFlag;
    }

    public void resetPSObj2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObj2Name();
            return;
        }
        this.psobj2nameDirtyFlag = false;
        this.psobj2name = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
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

    public void setPSSysIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissueid = string;
        this.pssysissueidDirtyFlag = true;
    }

    public String getPSSysIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueId();
        }
        return this.pssysissueid;
    }

    public boolean isPSSysIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueIdDirty();
        }
        return this.pssysissueidDirtyFlag;
    }

    public void resetPSSysIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueId();
            return;
        }
        this.pssysissueidDirtyFlag = false;
        this.pssysissueid = null;
    }

    public void setPSSysIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissuename = string;
        this.pssysissuenameDirtyFlag = true;
    }

    public String getPSSysIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueName();
        }
        return this.pssysissuename;
    }

    public boolean isPSSysIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueNameDirty();
        }
        return this.pssysissuenameDirtyFlag;
    }

    public void resetPSSysIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueName();
            return;
        }
        this.pssysissuenameDirtyFlag = false;
        this.pssysissuename = null;
    }

    public void setPSSysIssueTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissuetypeid = string;
        this.pssysissuetypeidDirtyFlag = true;
    }

    public String getPSSysIssueTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueTypeId();
        }
        return this.pssysissuetypeid;
    }

    public boolean isPSSysIssueTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueTypeIdDirty();
        }
        return this.pssysissuetypeidDirtyFlag;
    }

    public void resetPSSysIssueTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueTypeId();
            return;
        }
        this.pssysissuetypeidDirtyFlag = false;
        this.pssysissuetypeid = null;
    }

    public void setPSSysIssueTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissuetypename = string;
        this.pssysissuetypenameDirtyFlag = true;
    }

    public String getPSSysIssueTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueTypeName();
        }
        return this.pssysissuetypename;
    }

    public boolean isPSSysIssueTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueTypeNameDirty();
        }
        return this.pssysissuetypenameDirtyFlag;
    }

    public void resetPSSysIssueTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueTypeName();
            return;
        }
        this.pssysissuetypenameDirtyFlag = false;
        this.pssysissuetypename = null;
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
        PSSysIssueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysIssueBase pSSysIssueBase) {
        pSSysIssueBase.resetCancelDate();
        pSSysIssueBase.resetCreateDate();
        pSSysIssueBase.resetCreateMan();
        pSSysIssueBase.resetFinishDate();
        pSSysIssueBase.resetIssueInfo();
        pSSysIssueBase.resetIssueState();
        pSSysIssueBase.resetIssueType();
        pSSysIssueBase.resetObjType();
        pSSysIssueBase.resetPSDEId();
        pSSysIssueBase.resetPSDEName();
        pSSysIssueBase.resetPSDynaInstId();
        pSSysIssueBase.resetPSObj2Id();
        pSSysIssueBase.resetPSObj2Name();
        pSSysIssueBase.resetPSObjId();
        pSSysIssueBase.resetPSObjName();
        pSSysIssueBase.resetPSSysAppId();
        pSSysIssueBase.resetPSSysAppName();
        pSSysIssueBase.resetPSSysIssueId();
        pSSysIssueBase.resetPSSysIssueName();
        pSSysIssueBase.resetPSSysIssueTypeId();
        pSSysIssueBase.resetPSSysIssueTypeName();
        pSSysIssueBase.resetPSSystemId();
        pSSysIssueBase.resetPSSystemName();
        pSSysIssueBase.resetUpdateDate();
        pSSysIssueBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCancelDateDirty()) {
            hashMap.put(FIELD_CANCELDATE, this.getCancelDate());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFinishDateDirty()) {
            hashMap.put(FIELD_FINISHDATE, this.getFinishDate());
        }
        if (!bl || this.isIssueInfoDirty()) {
            hashMap.put(FIELD_ISSUEINFO, this.getIssueInfo());
        }
        if (!bl || this.isIssueStateDirty()) {
            hashMap.put(FIELD_ISSUESTATE, this.getIssueState());
        }
        if (!bl || this.isIssueTypeDirty()) {
            hashMap.put(FIELD_ISSUETYPE, this.getIssueType());
        }
        if (!bl || this.isObjTypeDirty()) {
            hashMap.put(FIELD_OBJTYPE, this.getObjType());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSObj2IdDirty()) {
            hashMap.put(FIELD_PSOBJ2ID, this.getPSObj2Id());
        }
        if (!bl || this.isPSObj2NameDirty()) {
            hashMap.put(FIELD_PSOBJ2NAME, this.getPSObj2Name());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysIssueIdDirty()) {
            hashMap.put(FIELD_PSSYSISSUEID, this.getPSSysIssueId());
        }
        if (!bl || this.isPSSysIssueNameDirty()) {
            hashMap.put(FIELD_PSSYSISSUENAME, this.getPSSysIssueName());
        }
        if (!bl || this.isPSSysIssueTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSISSUETYPEID, this.getPSSysIssueTypeId());
        }
        if (!bl || this.isPSSysIssueTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSISSUETYPENAME, this.getPSSysIssueTypeName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysIssueBase.get(this, n);
    }

    private static Object get(PSSysIssueBase pSSysIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueBase.getCancelDate();
            }
            case 1: {
                return pSSysIssueBase.getCreateDate();
            }
            case 2: {
                return pSSysIssueBase.getCreateMan();
            }
            case 3: {
                return pSSysIssueBase.getFinishDate();
            }
            case 4: {
                return pSSysIssueBase.getIssueInfo();
            }
            case 5: {
                return pSSysIssueBase.getIssueState();
            }
            case 6: {
                return pSSysIssueBase.getIssueType();
            }
            case 7: {
                return pSSysIssueBase.getObjType();
            }
            case 8: {
                return pSSysIssueBase.getPSDEId();
            }
            case 9: {
                return pSSysIssueBase.getPSDEName();
            }
            case 10: {
                return pSSysIssueBase.getPSDynaInstId();
            }
            case 11: {
                return pSSysIssueBase.getPSObj2Id();
            }
            case 12: {
                return pSSysIssueBase.getPSObj2Name();
            }
            case 13: {
                return pSSysIssueBase.getPSObjId();
            }
            case 14: {
                return pSSysIssueBase.getPSObjName();
            }
            case 15: {
                return pSSysIssueBase.getPSSysAppId();
            }
            case 16: {
                return pSSysIssueBase.getPSSysAppName();
            }
            case 17: {
                return pSSysIssueBase.getPSSysIssueId();
            }
            case 18: {
                return pSSysIssueBase.getPSSysIssueName();
            }
            case 19: {
                return pSSysIssueBase.getPSSysIssueTypeId();
            }
            case 20: {
                return pSSysIssueBase.getPSSysIssueTypeName();
            }
            case 21: {
                return pSSysIssueBase.getPSSystemId();
            }
            case 22: {
                return pSSysIssueBase.getPSSystemName();
            }
            case 23: {
                return pSSysIssueBase.getUpdateDate();
            }
            case 24: {
                return pSSysIssueBase.getUpdateMan();
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
        PSSysIssueBase.set(this, n, object);
    }

    private static void set(PSSysIssueBase pSSysIssueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysIssueBase.setCancelDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysIssueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysIssueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysIssueBase.setFinishDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysIssueBase.setIssueInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysIssueBase.setIssueState(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysIssueBase.setIssueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysIssueBase.setObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysIssueBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysIssueBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysIssueBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysIssueBase.setPSObj2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysIssueBase.setPSObj2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysIssueBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysIssueBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysIssueBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysIssueBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysIssueBase.setPSSysIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysIssueBase.setPSSysIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysIssueBase.setPSSysIssueTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysIssueBase.setPSSysIssueTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysIssueBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysIssueBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysIssueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysIssueBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysIssueBase.isNull(this, n);
    }

    private static boolean isNull(PSSysIssueBase pSSysIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueBase.getCancelDate() == null;
            }
            case 1: {
                return pSSysIssueBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysIssueBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysIssueBase.getFinishDate() == null;
            }
            case 4: {
                return pSSysIssueBase.getIssueInfo() == null;
            }
            case 5: {
                return pSSysIssueBase.getIssueState() == null;
            }
            case 6: {
                return pSSysIssueBase.getIssueType() == null;
            }
            case 7: {
                return pSSysIssueBase.getObjType() == null;
            }
            case 8: {
                return pSSysIssueBase.getPSDEId() == null;
            }
            case 9: {
                return pSSysIssueBase.getPSDEName() == null;
            }
            case 10: {
                return pSSysIssueBase.getPSDynaInstId() == null;
            }
            case 11: {
                return pSSysIssueBase.getPSObj2Id() == null;
            }
            case 12: {
                return pSSysIssueBase.getPSObj2Name() == null;
            }
            case 13: {
                return pSSysIssueBase.getPSObjId() == null;
            }
            case 14: {
                return pSSysIssueBase.getPSObjName() == null;
            }
            case 15: {
                return pSSysIssueBase.getPSSysAppId() == null;
            }
            case 16: {
                return pSSysIssueBase.getPSSysAppName() == null;
            }
            case 17: {
                return pSSysIssueBase.getPSSysIssueId() == null;
            }
            case 18: {
                return pSSysIssueBase.getPSSysIssueName() == null;
            }
            case 19: {
                return pSSysIssueBase.getPSSysIssueTypeId() == null;
            }
            case 20: {
                return pSSysIssueBase.getPSSysIssueTypeName() == null;
            }
            case 21: {
                return pSSysIssueBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysIssueBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysIssueBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysIssueBase.getUpdateMan() == null;
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
        return PSSysIssueBase.contains(this, n);
    }

    private static boolean contains(PSSysIssueBase pSSysIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueBase.isCancelDateDirty();
            }
            case 1: {
                return pSSysIssueBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysIssueBase.isCreateManDirty();
            }
            case 3: {
                return pSSysIssueBase.isFinishDateDirty();
            }
            case 4: {
                return pSSysIssueBase.isIssueInfoDirty();
            }
            case 5: {
                return pSSysIssueBase.isIssueStateDirty();
            }
            case 6: {
                return pSSysIssueBase.isIssueTypeDirty();
            }
            case 7: {
                return pSSysIssueBase.isObjTypeDirty();
            }
            case 8: {
                return pSSysIssueBase.isPSDEIdDirty();
            }
            case 9: {
                return pSSysIssueBase.isPSDENameDirty();
            }
            case 10: {
                return pSSysIssueBase.isPSDynaInstIdDirty();
            }
            case 11: {
                return pSSysIssueBase.isPSObj2IdDirty();
            }
            case 12: {
                return pSSysIssueBase.isPSObj2NameDirty();
            }
            case 13: {
                return pSSysIssueBase.isPSObjIdDirty();
            }
            case 14: {
                return pSSysIssueBase.isPSObjNameDirty();
            }
            case 15: {
                return pSSysIssueBase.isPSSysAppIdDirty();
            }
            case 16: {
                return pSSysIssueBase.isPSSysAppNameDirty();
            }
            case 17: {
                return pSSysIssueBase.isPSSysIssueIdDirty();
            }
            case 18: {
                return pSSysIssueBase.isPSSysIssueNameDirty();
            }
            case 19: {
                return pSSysIssueBase.isPSSysIssueTypeIdDirty();
            }
            case 20: {
                return pSSysIssueBase.isPSSysIssueTypeNameDirty();
            }
            case 21: {
                return pSSysIssueBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysIssueBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysIssueBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysIssueBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysIssueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysIssueBase pSSysIssueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysIssueBase.getCancelDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canceldate", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getCancelDate()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getFinishDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishdate", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getFinishDate()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getIssueInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issueinfo", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getIssueInfo()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getIssueState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuestate", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getIssueState()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getIssueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuetype", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getIssueType()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objtype", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getObjType()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSObj2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobj2id", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSObj2Id()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSObj2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobj2name", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSObj2Name()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSysIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissueid", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSysIssueId()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSysIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissuename", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSysIssueName()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSysIssueTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissuetypeid", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSysIssueTypeId()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSysIssueTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissuetypename", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSysIssueTypeName()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysIssueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysIssueBase.getJSONValue((Object)pSSysIssueBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysIssueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysIssueBase pSSysIssueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysIssueBase.getCancelDate() != null) {
            object = pSSysIssueBase.getCancelDate();
            xmlNode.setAttribute(FIELD_CANCELDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueBase.getCreateDate() != null) {
            object = pSSysIssueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueBase.getCreateMan() != null) {
            object = pSSysIssueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getFinishDate() != null) {
            object = pSSysIssueBase.getFinishDate();
            xmlNode.setAttribute(FIELD_FINISHDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueBase.getIssueInfo() != null) {
            object = pSSysIssueBase.getIssueInfo();
            xmlNode.setAttribute(FIELD_ISSUEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getIssueState() != null) {
            object = pSSysIssueBase.getIssueState();
            xmlNode.setAttribute(FIELD_ISSUESTATE, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getIssueType() != null) {
            object = pSSysIssueBase.getIssueType();
            xmlNode.setAttribute(FIELD_ISSUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getObjType() != null) {
            object = pSSysIssueBase.getObjType();
            xmlNode.setAttribute(FIELD_OBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSDEId() != null) {
            object = pSSysIssueBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSDEName() != null) {
            object = pSSysIssueBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSDynaInstId() != null) {
            object = pSSysIssueBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSObj2Id() != null) {
            object = pSSysIssueBase.getPSObj2Id();
            xmlNode.setAttribute(FIELD_PSOBJ2ID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSObj2Name() != null) {
            object = pSSysIssueBase.getPSObj2Name();
            xmlNode.setAttribute(FIELD_PSOBJ2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSObjId() != null) {
            object = pSSysIssueBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSObjName() != null) {
            object = pSSysIssueBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSysAppId() != null) {
            object = pSSysIssueBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSysAppName() != null) {
            object = pSSysIssueBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSysIssueId() != null) {
            object = pSSysIssueBase.getPSSysIssueId();
            xmlNode.setAttribute(FIELD_PSSYSISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSysIssueName() != null) {
            object = pSSysIssueBase.getPSSysIssueName();
            xmlNode.setAttribute(FIELD_PSSYSISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSysIssueTypeId() != null) {
            object = pSSysIssueBase.getPSSysIssueTypeId();
            xmlNode.setAttribute(FIELD_PSSYSISSUETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSysIssueTypeName() != null) {
            object = pSSysIssueBase.getPSSysIssueTypeName();
            xmlNode.setAttribute(FIELD_PSSYSISSUETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSystemId() != null) {
            object = pSSysIssueBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getPSSystemName() != null) {
            object = pSSysIssueBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueBase.getUpdateDate() != null) {
            object = pSSysIssueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueBase.getUpdateMan() != null) {
            object = pSSysIssueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysIssueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysIssueBase pSSysIssueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysIssueBase.isCancelDateDirty() && (bl || pSSysIssueBase.getCancelDate() != null)) {
            iDataObject.set(FIELD_CANCELDATE, (Object)pSSysIssueBase.getCancelDate());
        }
        if (pSSysIssueBase.isCreateDateDirty() && (bl || pSSysIssueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysIssueBase.getCreateDate());
        }
        if (pSSysIssueBase.isCreateManDirty() && (bl || pSSysIssueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysIssueBase.getCreateMan());
        }
        if (pSSysIssueBase.isFinishDateDirty() && (bl || pSSysIssueBase.getFinishDate() != null)) {
            iDataObject.set(FIELD_FINISHDATE, (Object)pSSysIssueBase.getFinishDate());
        }
        if (pSSysIssueBase.isIssueInfoDirty() && (bl || pSSysIssueBase.getIssueInfo() != null)) {
            iDataObject.set(FIELD_ISSUEINFO, (Object)pSSysIssueBase.getIssueInfo());
        }
        if (pSSysIssueBase.isIssueStateDirty() && (bl || pSSysIssueBase.getIssueState() != null)) {
            iDataObject.set(FIELD_ISSUESTATE, (Object)pSSysIssueBase.getIssueState());
        }
        if (pSSysIssueBase.isIssueTypeDirty() && (bl || pSSysIssueBase.getIssueType() != null)) {
            iDataObject.set(FIELD_ISSUETYPE, (Object)pSSysIssueBase.getIssueType());
        }
        if (pSSysIssueBase.isObjTypeDirty() && (bl || pSSysIssueBase.getObjType() != null)) {
            iDataObject.set(FIELD_OBJTYPE, (Object)pSSysIssueBase.getObjType());
        }
        if (pSSysIssueBase.isPSDEIdDirty() && (bl || pSSysIssueBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysIssueBase.getPSDEId());
        }
        if (pSSysIssueBase.isPSDENameDirty() && (bl || pSSysIssueBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysIssueBase.getPSDEName());
        }
        if (pSSysIssueBase.isPSDynaInstIdDirty() && (bl || pSSysIssueBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysIssueBase.getPSDynaInstId());
        }
        if (pSSysIssueBase.isPSObj2IdDirty() && (bl || pSSysIssueBase.getPSObj2Id() != null)) {
            iDataObject.set(FIELD_PSOBJ2ID, (Object)pSSysIssueBase.getPSObj2Id());
        }
        if (pSSysIssueBase.isPSObj2NameDirty() && (bl || pSSysIssueBase.getPSObj2Name() != null)) {
            iDataObject.set(FIELD_PSOBJ2NAME, (Object)pSSysIssueBase.getPSObj2Name());
        }
        if (pSSysIssueBase.isPSObjIdDirty() && (bl || pSSysIssueBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysIssueBase.getPSObjId());
        }
        if (pSSysIssueBase.isPSObjNameDirty() && (bl || pSSysIssueBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysIssueBase.getPSObjName());
        }
        if (pSSysIssueBase.isPSSysAppIdDirty() && (bl || pSSysIssueBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysIssueBase.getPSSysAppId());
        }
        if (pSSysIssueBase.isPSSysAppNameDirty() && (bl || pSSysIssueBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysIssueBase.getPSSysAppName());
        }
        if (pSSysIssueBase.isPSSysIssueIdDirty() && (bl || pSSysIssueBase.getPSSysIssueId() != null)) {
            iDataObject.set(FIELD_PSSYSISSUEID, (Object)pSSysIssueBase.getPSSysIssueId());
        }
        if (pSSysIssueBase.isPSSysIssueNameDirty() && (bl || pSSysIssueBase.getPSSysIssueName() != null)) {
            iDataObject.set(FIELD_PSSYSISSUENAME, (Object)pSSysIssueBase.getPSSysIssueName());
        }
        if (pSSysIssueBase.isPSSysIssueTypeIdDirty() && (bl || pSSysIssueBase.getPSSysIssueTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSISSUETYPEID, (Object)pSSysIssueBase.getPSSysIssueTypeId());
        }
        if (pSSysIssueBase.isPSSysIssueTypeNameDirty() && (bl || pSSysIssueBase.getPSSysIssueTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSISSUETYPENAME, (Object)pSSysIssueBase.getPSSysIssueTypeName());
        }
        if (pSSysIssueBase.isPSSystemIdDirty() && (bl || pSSysIssueBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysIssueBase.getPSSystemId());
        }
        if (pSSysIssueBase.isPSSystemNameDirty() && (bl || pSSysIssueBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysIssueBase.getPSSystemName());
        }
        if (pSSysIssueBase.isUpdateDateDirty() && (bl || pSSysIssueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysIssueBase.getUpdateDate());
        }
        if (pSSysIssueBase.isUpdateManDirty() && (bl || pSSysIssueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysIssueBase.getUpdateMan());
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
        return PSSysIssueBase.remove(this, n);
    }

    private static boolean remove(PSSysIssueBase pSSysIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysIssueBase.resetCancelDate();
                return true;
            }
            case 1: {
                pSSysIssueBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysIssueBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysIssueBase.resetFinishDate();
                return true;
            }
            case 4: {
                pSSysIssueBase.resetIssueInfo();
                return true;
            }
            case 5: {
                pSSysIssueBase.resetIssueState();
                return true;
            }
            case 6: {
                pSSysIssueBase.resetIssueType();
                return true;
            }
            case 7: {
                pSSysIssueBase.resetObjType();
                return true;
            }
            case 8: {
                pSSysIssueBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSSysIssueBase.resetPSDEName();
                return true;
            }
            case 10: {
                pSSysIssueBase.resetPSDynaInstId();
                return true;
            }
            case 11: {
                pSSysIssueBase.resetPSObj2Id();
                return true;
            }
            case 12: {
                pSSysIssueBase.resetPSObj2Name();
                return true;
            }
            case 13: {
                pSSysIssueBase.resetPSObjId();
                return true;
            }
            case 14: {
                pSSysIssueBase.resetPSObjName();
                return true;
            }
            case 15: {
                pSSysIssueBase.resetPSSysAppId();
                return true;
            }
            case 16: {
                pSSysIssueBase.resetPSSysAppName();
                return true;
            }
            case 17: {
                pSSysIssueBase.resetPSSysIssueId();
                return true;
            }
            case 18: {
                pSSysIssueBase.resetPSSysIssueName();
                return true;
            }
            case 19: {
                pSSysIssueBase.resetPSSysIssueTypeId();
                return true;
            }
            case 20: {
                pSSysIssueBase.resetPSSysIssueTypeName();
                return true;
            }
            case 21: {
                pSSysIssueBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysIssueBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysIssueBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysIssueBase.resetUpdateMan();
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
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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

    private PSSysIssueBase getProxyEntity() {
        return this.proxyPSSysIssueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysIssueBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysIssueBase) {
            this.proxyPSSysIssueBase = (PSSysIssueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CANCELDATE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FINISHDATE, 3);
        fieldIndexMap.put(FIELD_ISSUEINFO, 4);
        fieldIndexMap.put(FIELD_ISSUESTATE, 5);
        fieldIndexMap.put(FIELD_ISSUETYPE, 6);
        fieldIndexMap.put(FIELD_OBJTYPE, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDENAME, 9);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 10);
        fieldIndexMap.put(FIELD_PSOBJ2ID, 11);
        fieldIndexMap.put(FIELD_PSOBJ2NAME, 12);
        fieldIndexMap.put(FIELD_PSOBJID, 13);
        fieldIndexMap.put(FIELD_PSOBJNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 15);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSISSUEID, 17);
        fieldIndexMap.put(FIELD_PSSYSISSUENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSISSUETYPEID, 19);
        fieldIndexMap.put(FIELD_PSSYSISSUETYPENAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
    }
}

