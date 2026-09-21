/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWProjectBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWProjectBase.class);
    public static final String FIELD_AUTOCREATESLN = "AUTOCREATESLN";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_ERRORCODE = "ERRORCODE";
    public static final String FIELD_ERRORINFO = "ERRORINFO";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROJECTNAME = "PROJECTNAME";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSUWPROJECTID = "PSUWPROJECTID";
    public static final String FIELD_PSUWPROJECTNAME = "PSUWPROJECTNAME";
    public static final String FIELD_REALPROJECTID = "REALPROJECTID";
    public static final String FIELD_SOURCE = "SOURCE";
    public static final String FIELD_SOURCE2 = "SOURCE2";
    public static final String FIELD_SOURCENAME = "SOURCENAME";
    public static final String FIELD_SOURCETYPE = "SOURCETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    public static final String FIELD_WIZARDPARAM5 = "WIZARDPARAM5";
    public static final String FIELD_WIZARDPARAM6 = "WIZARDPARAM6";
    public static final String FIELD_WIZARDSTATE = "WIZARDSTATE";
    public static final String FIELD_WIZARDSTEP = "WIZARDSTEP";
    public static final String FIELD_WIZARDTAG = "WIZARDTAG";
    public static final String FIELD_WIZARDTAG2 = "WIZARDTAG2";
    private static final int INDEX_AUTOCREATESLN = 0;
    private static final int INDEX_BEGINTIME = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ENDTIME = 5;
    private static final int INDEX_ERRORCODE = 6;
    private static final int INDEX_ERRORINFO = 7;
    private static final int INDEX_LOGICNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PROJECTNAME = 10;
    private static final int INDEX_PSDCWORKSPACEID = 11;
    private static final int INDEX_PSDCWORKSPACENAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNNAME = 16;
    private static final int INDEX_PSDYNAINSTID = 17;
    private static final int INDEX_PSPFID = 18;
    private static final int INDEX_PSPFNAME = 19;
    private static final int INDEX_PSPFSTYLEID = 20;
    private static final int INDEX_PSPFSTYLENAME = 21;
    private static final int INDEX_PSSFID = 22;
    private static final int INDEX_PSSFNAME = 23;
    private static final int INDEX_PSSFSTYLEID = 24;
    private static final int INDEX_PSSFSTYLENAME = 25;
    private static final int INDEX_PSUWPROJECTID = 26;
    private static final int INDEX_PSUWPROJECTNAME = 27;
    private static final int INDEX_REALPROJECTID = 28;
    private static final int INDEX_SOURCE = 29;
    private static final int INDEX_SOURCE2 = 30;
    private static final int INDEX_SOURCENAME = 31;
    private static final int INDEX_SOURCETYPE = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_WIZARDMODE = 35;
    private static final int INDEX_WIZARDPARAM = 36;
    private static final int INDEX_WIZARDPARAM2 = 37;
    private static final int INDEX_WIZARDPARAM3 = 38;
    private static final int INDEX_WIZARDPARAM4 = 39;
    private static final int INDEX_WIZARDPARAM5 = 40;
    private static final int INDEX_WIZARDPARAM6 = 41;
    private static final int INDEX_WIZARDSTATE = 42;
    private static final int INDEX_WIZARDSTEP = 43;
    private static final int INDEX_WIZARDTAG = 44;
    private static final int INDEX_WIZARDTAG2 = 45;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWProjectBase proxyPSUWProjectBase = null;
    private boolean autocreateslnDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean errorcodeDirtyFlag = false;
    private boolean errorinfoDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean projectnameDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdcworkspacenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean psuwprojectidDirtyFlag = false;
    private boolean psuwprojectnameDirtyFlag = false;
    private boolean realprojectidDirtyFlag = false;
    private boolean sourceDirtyFlag = false;
    private boolean source2DirtyFlag = false;
    private boolean sourcenameDirtyFlag = false;
    private boolean sourcetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    private boolean wizardparam5DirtyFlag = false;
    private boolean wizardparam6DirtyFlag = false;
    private boolean wizardstateDirtyFlag = false;
    private boolean wizardstepDirtyFlag = false;
    private boolean wizardtagDirtyFlag = false;
    private boolean wizardtag2DirtyFlag = false;
    @Column(name="autocreatesln")
    private Integer autocreatesln;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="errorcode")
    private Integer errorcode;
    @Column(name="errorinfo")
    private String errorinfo;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="projectname")
    private String projectname;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdcworkspacename")
    private String psdcworkspacename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="psuwprojectid")
    private String psuwprojectid;
    @Column(name="psuwprojectname")
    private String psuwprojectname;
    @Column(name="realprojectid")
    private String realprojectid;
    @Column(name="source")
    private String source;
    @Column(name="source2")
    private String source2;
    @Column(name="sourcename")
    private String sourcename;
    @Column(name="sourcetype")
    private String sourcetype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private String wizardparam;
    @Column(name="wizardparam2")
    private String wizardparam2;
    @Column(name="wizardparam3")
    private String wizardparam3;
    @Column(name="wizardparam4")
    private String wizardparam4;
    @Column(name="wizardparam5")
    private Integer wizardparam5;
    @Column(name="wizardparam6")
    private Integer wizardparam6;
    @Column(name="wizardstate")
    private Integer wizardstate;
    @Column(name="wizardstep")
    private String wizardstep;
    @Column(name="wizardtag")
    private String wizardtag;
    @Column(name="wizardtag2")
    private String wizardtag2;

    public void setAutoCreateSln(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoCreateSln(n);
            return;
        }
        this.autocreatesln = n;
        this.autocreateslnDirtyFlag = true;
    }

    public Integer getAutoCreateSln() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoCreateSln();
        }
        return this.autocreatesln;
    }

    public boolean isAutoCreateSlnDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoCreateSlnDirty();
        }
        return this.autocreateslnDirtyFlag;
    }

    public void resetAutoCreateSln() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoCreateSln();
            return;
        }
        this.autocreateslnDirtyFlag = false;
        this.autocreatesln = null;
    }

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setErrorCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorCode(n);
            return;
        }
        this.errorcode = n;
        this.errorcodeDirtyFlag = true;
    }

    public Integer getErrorCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorCode();
        }
        return this.errorcode;
    }

    public boolean isErrorCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorCodeDirty();
        }
        return this.errorcodeDirtyFlag;
    }

    public void resetErrorCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorCode();
            return;
        }
        this.errorcodeDirtyFlag = false;
        this.errorcode = null;
    }

    public void setErrorInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errorinfo = string;
        this.errorinfoDirtyFlag = true;
    }

    public String getErrorInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorInfo();
        }
        return this.errorinfo;
    }

    public boolean isErrorInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorInfoDirty();
        }
        return this.errorinfoDirtyFlag;
    }

    public void resetErrorInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorInfo();
            return;
        }
        this.errorinfoDirtyFlag = false;
        this.errorinfo = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setProjectName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProjectName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.projectname = string;
        this.projectnameDirtyFlag = true;
    }

    public String getProjectName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProjectName();
        }
        return this.projectname;
    }

    public boolean isProjectNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProjectNameDirty();
        }
        return this.projectnameDirtyFlag;
    }

    public void resetProjectName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProjectName();
            return;
        }
        this.projectnameDirtyFlag = false;
        this.projectname = null;
    }

    public void setPSDCWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceid = string;
        this.psdcworkspaceidDirtyFlag = true;
    }

    public String getPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceId();
        }
        return this.psdcworkspaceid;
    }

    public boolean isPSDCWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceIdDirty();
        }
        return this.psdcworkspaceidDirtyFlag;
    }

    public void resetPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceId();
            return;
        }
        this.psdcworkspaceidDirtyFlag = false;
        this.psdcworkspaceid = null;
    }

    public void setPSDCWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspacename = string;
        this.psdcworkspacenameDirtyFlag = true;
    }

    public String getPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceName();
        }
        return this.psdcworkspacename;
    }

    public boolean isPSDCWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceNameDirty();
        }
        return this.psdcworkspacenameDirtyFlag;
    }

    public void resetPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceName();
            return;
        }
        this.psdcworkspacenameDirtyFlag = false;
        this.psdcworkspacename = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPSUWProjectId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWProjectId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwprojectid = string;
        this.psuwprojectidDirtyFlag = true;
    }

    public String getPSUWProjectId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWProjectId();
        }
        return this.psuwprojectid;
    }

    public boolean isPSUWProjectIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWProjectIdDirty();
        }
        return this.psuwprojectidDirtyFlag;
    }

    public void resetPSUWProjectId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWProjectId();
            return;
        }
        this.psuwprojectidDirtyFlag = false;
        this.psuwprojectid = null;
    }

    public void setPSUWProjectName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWProjectName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwprojectname = string;
        this.psuwprojectnameDirtyFlag = true;
    }

    public String getPSUWProjectName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWProjectName();
        }
        return this.psuwprojectname;
    }

    public boolean isPSUWProjectNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWProjectNameDirty();
        }
        return this.psuwprojectnameDirtyFlag;
    }

    public void resetPSUWProjectName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWProjectName();
            return;
        }
        this.psuwprojectnameDirtyFlag = false;
        this.psuwprojectname = null;
    }

    public void setRealProjectId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRealProjectId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.realprojectid = string;
        this.realprojectidDirtyFlag = true;
    }

    public String getRealProjectId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRealProjectId();
        }
        return this.realprojectid;
    }

    public boolean isRealProjectIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRealProjectIdDirty();
        }
        return this.realprojectidDirtyFlag;
    }

    public void resetRealProjectId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRealProjectId();
            return;
        }
        this.realprojectidDirtyFlag = false;
        this.realprojectid = null;
    }

    public void setSource(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSource(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.source = string;
        this.sourceDirtyFlag = true;
    }

    public String getSource() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSource();
        }
        return this.source;
    }

    public boolean isSourceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSourceDirty();
        }
        return this.sourceDirtyFlag;
    }

    public void resetSource() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSource();
            return;
        }
        this.sourceDirtyFlag = false;
        this.source = null;
    }

    public void setSource2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSource2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.source2 = string;
        this.source2DirtyFlag = true;
    }

    public String getSource2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSource2();
        }
        return this.source2;
    }

    public boolean isSource2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSource2Dirty();
        }
        return this.source2DirtyFlag;
    }

    public void resetSource2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSource2();
            return;
        }
        this.source2DirtyFlag = false;
        this.source2 = null;
    }

    public void setSourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sourcename = string;
        this.sourcenameDirtyFlag = true;
    }

    public String getSourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSourceName();
        }
        return this.sourcename;
    }

    public boolean isSourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSourceNameDirty();
        }
        return this.sourcenameDirtyFlag;
    }

    public void resetSourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSourceName();
            return;
        }
        this.sourcenameDirtyFlag = false;
        this.sourcename = null;
    }

    public void setSourceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSourceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sourcetype = string;
        this.sourcetypeDirtyFlag = true;
    }

    public String getSourceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSourceType();
        }
        return this.sourcetype;
    }

    public boolean isSourceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSourceTypeDirty();
        }
        return this.sourcetypeDirtyFlag;
    }

    public void resetSourceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSourceType();
            return;
        }
        this.sourcetypeDirtyFlag = false;
        this.sourcetype = null;
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

    public void setWizardMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardmode = string;
        this.wizardmodeDirtyFlag = true;
    }

    public String getWizardMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardMode();
        }
        return this.wizardmode;
    }

    public boolean isWizardModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardModeDirty();
        }
        return this.wizardmodeDirtyFlag;
    }

    public void resetWizardMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardMode();
            return;
        }
        this.wizardmodeDirtyFlag = false;
        this.wizardmode = null;
    }

    public void setWizardParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam = string;
        this.wizardparamDirtyFlag = true;
    }

    public String getWizardParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam();
        }
        return this.wizardparam;
    }

    public boolean isWizardParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParamDirty();
        }
        return this.wizardparamDirtyFlag;
    }

    public void resetWizardParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam();
            return;
        }
        this.wizardparamDirtyFlag = false;
        this.wizardparam = null;
    }

    public void setWizardParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam2 = string;
        this.wizardparam2DirtyFlag = true;
    }

    public String getWizardParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam2();
        }
        return this.wizardparam2;
    }

    public boolean isWizardParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam2Dirty();
        }
        return this.wizardparam2DirtyFlag;
    }

    public void resetWizardParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam2();
            return;
        }
        this.wizardparam2DirtyFlag = false;
        this.wizardparam2 = null;
    }

    public void setWizardParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam3 = string;
        this.wizardparam3DirtyFlag = true;
    }

    public String getWizardParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam3();
        }
        return this.wizardparam3;
    }

    public boolean isWizardParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam3Dirty();
        }
        return this.wizardparam3DirtyFlag;
    }

    public void resetWizardParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam3();
            return;
        }
        this.wizardparam3DirtyFlag = false;
        this.wizardparam3 = null;
    }

    public void setWizardParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam4 = string;
        this.wizardparam4DirtyFlag = true;
    }

    public String getWizardParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam4();
        }
        return this.wizardparam4;
    }

    public boolean isWizardParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam4Dirty();
        }
        return this.wizardparam4DirtyFlag;
    }

    public void resetWizardParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam4();
            return;
        }
        this.wizardparam4DirtyFlag = false;
        this.wizardparam4 = null;
    }

    public void setWizardParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam5(n);
            return;
        }
        this.wizardparam5 = n;
        this.wizardparam5DirtyFlag = true;
    }

    public Integer getWizardParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam5();
        }
        return this.wizardparam5;
    }

    public boolean isWizardParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam5Dirty();
        }
        return this.wizardparam5DirtyFlag;
    }

    public void resetWizardParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam5();
            return;
        }
        this.wizardparam5DirtyFlag = false;
        this.wizardparam5 = null;
    }

    public void setWizardParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam6(n);
            return;
        }
        this.wizardparam6 = n;
        this.wizardparam6DirtyFlag = true;
    }

    public Integer getWizardParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam6();
        }
        return this.wizardparam6;
    }

    public boolean isWizardParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam6Dirty();
        }
        return this.wizardparam6DirtyFlag;
    }

    public void resetWizardParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam6();
            return;
        }
        this.wizardparam6DirtyFlag = false;
        this.wizardparam6 = null;
    }

    public void setWizardState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardState(n);
            return;
        }
        this.wizardstate = n;
        this.wizardstateDirtyFlag = true;
    }

    public Integer getWizardState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardState();
        }
        return this.wizardstate;
    }

    public boolean isWizardStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardStateDirty();
        }
        return this.wizardstateDirtyFlag;
    }

    public void resetWizardState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardState();
            return;
        }
        this.wizardstateDirtyFlag = false;
        this.wizardstate = null;
    }

    public void setWizardStep(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardStep(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardstep = string;
        this.wizardstepDirtyFlag = true;
    }

    public String getWizardStep() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardStep();
        }
        return this.wizardstep;
    }

    public boolean isWizardStepDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardStepDirty();
        }
        return this.wizardstepDirtyFlag;
    }

    public void resetWizardStep() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardStep();
            return;
        }
        this.wizardstepDirtyFlag = false;
        this.wizardstep = null;
    }

    public void setWizardTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardtag = string;
        this.wizardtagDirtyFlag = true;
    }

    public String getWizardTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardTag();
        }
        return this.wizardtag;
    }

    public boolean isWizardTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardTagDirty();
        }
        return this.wizardtagDirtyFlag;
    }

    public void resetWizardTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardTag();
            return;
        }
        this.wizardtagDirtyFlag = false;
        this.wizardtag = null;
    }

    public void setWizardTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardtag2 = string;
        this.wizardtag2DirtyFlag = true;
    }

    public String getWizardTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardTag2();
        }
        return this.wizardtag2;
    }

    public boolean isWizardTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardTag2Dirty();
        }
        return this.wizardtag2DirtyFlag;
    }

    public void resetWizardTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardTag2();
            return;
        }
        this.wizardtag2DirtyFlag = false;
        this.wizardtag2 = null;
    }

    protected void onReset() {
        PSUWProjectBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWProjectBase pSUWProjectBase) {
        pSUWProjectBase.resetAutoCreateSln();
        pSUWProjectBase.resetBeginTime();
        pSUWProjectBase.resetCodeName();
        pSUWProjectBase.resetCreateDate();
        pSUWProjectBase.resetCreateMan();
        pSUWProjectBase.resetEndTime();
        pSUWProjectBase.resetErrorCode();
        pSUWProjectBase.resetErrorInfo();
        pSUWProjectBase.resetLogicName();
        pSUWProjectBase.resetMemo();
        pSUWProjectBase.resetProjectName();
        pSUWProjectBase.resetPSDCWorkspaceId();
        pSUWProjectBase.resetPSDCWorkspaceName();
        pSUWProjectBase.resetPSDevCenterId();
        pSUWProjectBase.resetPSDevCenterName();
        pSUWProjectBase.resetPSDevSlnId();
        pSUWProjectBase.resetPSDevSlnName();
        pSUWProjectBase.resetPSDynaInstId();
        pSUWProjectBase.resetPSPFId();
        pSUWProjectBase.resetPSPFName();
        pSUWProjectBase.resetPSPFStyleId();
        pSUWProjectBase.resetPSPFStyleName();
        pSUWProjectBase.resetPSSFId();
        pSUWProjectBase.resetPSSFName();
        pSUWProjectBase.resetPSSFStyleId();
        pSUWProjectBase.resetPSSFStyleName();
        pSUWProjectBase.resetPSUWProjectId();
        pSUWProjectBase.resetPSUWProjectName();
        pSUWProjectBase.resetRealProjectId();
        pSUWProjectBase.resetSource();
        pSUWProjectBase.resetSource2();
        pSUWProjectBase.resetSourceName();
        pSUWProjectBase.resetSourceType();
        pSUWProjectBase.resetUpdateDate();
        pSUWProjectBase.resetUpdateMan();
        pSUWProjectBase.resetWizardMode();
        pSUWProjectBase.resetWizardParam();
        pSUWProjectBase.resetWizardParam2();
        pSUWProjectBase.resetWizardParam3();
        pSUWProjectBase.resetWizardParam4();
        pSUWProjectBase.resetWizardParam5();
        pSUWProjectBase.resetWizardParam6();
        pSUWProjectBase.resetWizardState();
        pSUWProjectBase.resetWizardStep();
        pSUWProjectBase.resetWizardTag();
        pSUWProjectBase.resetWizardTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAutoCreateSlnDirty()) {
            hashMap.put(FIELD_AUTOCREATESLN, this.getAutoCreateSln());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isErrorCodeDirty()) {
            hashMap.put(FIELD_ERRORCODE, this.getErrorCode());
        }
        if (!bl || this.isErrorInfoDirty()) {
            hashMap.put(FIELD_ERRORINFO, this.getErrorInfo());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isProjectNameDirty()) {
            hashMap.put(FIELD_PROJECTNAME, this.getProjectName());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDCWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACENAME, this.getPSDCWorkspaceName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSUWProjectIdDirty()) {
            hashMap.put(FIELD_PSUWPROJECTID, this.getPSUWProjectId());
        }
        if (!bl || this.isPSUWProjectNameDirty()) {
            hashMap.put(FIELD_PSUWPROJECTNAME, this.getPSUWProjectName());
        }
        if (!bl || this.isRealProjectIdDirty()) {
            hashMap.put(FIELD_REALPROJECTID, this.getRealProjectId());
        }
        if (!bl || this.isSourceDirty()) {
            hashMap.put(FIELD_SOURCE, this.getSource());
        }
        if (!bl || this.isSource2Dirty()) {
            hashMap.put(FIELD_SOURCE2, this.getSource2());
        }
        if (!bl || this.isSourceNameDirty()) {
            hashMap.put(FIELD_SOURCENAME, this.getSourceName());
        }
        if (!bl || this.isSourceTypeDirty()) {
            hashMap.put(FIELD_SOURCETYPE, this.getSourceType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWizardModeDirty()) {
            hashMap.put(FIELD_WIZARDMODE, this.getWizardMode());
        }
        if (!bl || this.isWizardParamDirty()) {
            hashMap.put(FIELD_WIZARDPARAM, this.getWizardParam());
        }
        if (!bl || this.isWizardParam2Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM2, this.getWizardParam2());
        }
        if (!bl || this.isWizardParam3Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM3, this.getWizardParam3());
        }
        if (!bl || this.isWizardParam4Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM4, this.getWizardParam4());
        }
        if (!bl || this.isWizardParam5Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM5, this.getWizardParam5());
        }
        if (!bl || this.isWizardParam6Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM6, this.getWizardParam6());
        }
        if (!bl || this.isWizardStateDirty()) {
            hashMap.put(FIELD_WIZARDSTATE, this.getWizardState());
        }
        if (!bl || this.isWizardStepDirty()) {
            hashMap.put(FIELD_WIZARDSTEP, this.getWizardStep());
        }
        if (!bl || this.isWizardTagDirty()) {
            hashMap.put(FIELD_WIZARDTAG, this.getWizardTag());
        }
        if (!bl || this.isWizardTag2Dirty()) {
            hashMap.put(FIELD_WIZARDTAG2, this.getWizardTag2());
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
        return PSUWProjectBase.get(this, n);
    }

    private static Object get(PSUWProjectBase pSUWProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWProjectBase.getAutoCreateSln();
            }
            case 1: {
                return pSUWProjectBase.getBeginTime();
            }
            case 2: {
                return pSUWProjectBase.getCodeName();
            }
            case 3: {
                return pSUWProjectBase.getCreateDate();
            }
            case 4: {
                return pSUWProjectBase.getCreateMan();
            }
            case 5: {
                return pSUWProjectBase.getEndTime();
            }
            case 6: {
                return pSUWProjectBase.getErrorCode();
            }
            case 7: {
                return pSUWProjectBase.getErrorInfo();
            }
            case 8: {
                return pSUWProjectBase.getLogicName();
            }
            case 9: {
                return pSUWProjectBase.getMemo();
            }
            case 10: {
                return pSUWProjectBase.getProjectName();
            }
            case 11: {
                return pSUWProjectBase.getPSDCWorkspaceId();
            }
            case 12: {
                return pSUWProjectBase.getPSDCWorkspaceName();
            }
            case 13: {
                return pSUWProjectBase.getPSDevCenterId();
            }
            case 14: {
                return pSUWProjectBase.getPSDevCenterName();
            }
            case 15: {
                return pSUWProjectBase.getPSDevSlnId();
            }
            case 16: {
                return pSUWProjectBase.getPSDevSlnName();
            }
            case 17: {
                return pSUWProjectBase.getPSDynaInstId();
            }
            case 18: {
                return pSUWProjectBase.getPSPFId();
            }
            case 19: {
                return pSUWProjectBase.getPSPFName();
            }
            case 20: {
                return pSUWProjectBase.getPSPFStyleId();
            }
            case 21: {
                return pSUWProjectBase.getPSPFStyleName();
            }
            case 22: {
                return pSUWProjectBase.getPSSFId();
            }
            case 23: {
                return pSUWProjectBase.getPSSFName();
            }
            case 24: {
                return pSUWProjectBase.getPSSFStyleId();
            }
            case 25: {
                return pSUWProjectBase.getPSSFStyleName();
            }
            case 26: {
                return pSUWProjectBase.getPSUWProjectId();
            }
            case 27: {
                return pSUWProjectBase.getPSUWProjectName();
            }
            case 28: {
                return pSUWProjectBase.getRealProjectId();
            }
            case 29: {
                return pSUWProjectBase.getSource();
            }
            case 30: {
                return pSUWProjectBase.getSource2();
            }
            case 31: {
                return pSUWProjectBase.getSourceName();
            }
            case 32: {
                return pSUWProjectBase.getSourceType();
            }
            case 33: {
                return pSUWProjectBase.getUpdateDate();
            }
            case 34: {
                return pSUWProjectBase.getUpdateMan();
            }
            case 35: {
                return pSUWProjectBase.getWizardMode();
            }
            case 36: {
                return pSUWProjectBase.getWizardParam();
            }
            case 37: {
                return pSUWProjectBase.getWizardParam2();
            }
            case 38: {
                return pSUWProjectBase.getWizardParam3();
            }
            case 39: {
                return pSUWProjectBase.getWizardParam4();
            }
            case 40: {
                return pSUWProjectBase.getWizardParam5();
            }
            case 41: {
                return pSUWProjectBase.getWizardParam6();
            }
            case 42: {
                return pSUWProjectBase.getWizardState();
            }
            case 43: {
                return pSUWProjectBase.getWizardStep();
            }
            case 44: {
                return pSUWProjectBase.getWizardTag();
            }
            case 45: {
                return pSUWProjectBase.getWizardTag2();
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
        PSUWProjectBase.set(this, n, object);
    }

    private static void set(PSUWProjectBase pSUWProjectBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWProjectBase.setAutoCreateSln(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSUWProjectBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUWProjectBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWProjectBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSUWProjectBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWProjectBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSUWProjectBase.setErrorCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSUWProjectBase.setErrorInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWProjectBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWProjectBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWProjectBase.setProjectName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWProjectBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWProjectBase.setPSDCWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWProjectBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWProjectBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSUWProjectBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWProjectBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWProjectBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWProjectBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWProjectBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWProjectBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSUWProjectBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSUWProjectBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSUWProjectBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSUWProjectBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSUWProjectBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSUWProjectBase.setPSUWProjectId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSUWProjectBase.setPSUWProjectName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSUWProjectBase.setRealProjectId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSUWProjectBase.setSource(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSUWProjectBase.setSource2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSUWProjectBase.setSourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSUWProjectBase.setSourceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSUWProjectBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSUWProjectBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSUWProjectBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSUWProjectBase.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSUWProjectBase.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSUWProjectBase.setWizardParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSUWProjectBase.setWizardParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSUWProjectBase.setWizardParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSUWProjectBase.setWizardParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSUWProjectBase.setWizardState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSUWProjectBase.setWizardStep(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSUWProjectBase.setWizardTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSUWProjectBase.setWizardTag2(DataObject.getStringValue((Object)object));
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
        return PSUWProjectBase.isNull(this, n);
    }

    private static boolean isNull(PSUWProjectBase pSUWProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWProjectBase.getAutoCreateSln() == null;
            }
            case 1: {
                return pSUWProjectBase.getBeginTime() == null;
            }
            case 2: {
                return pSUWProjectBase.getCodeName() == null;
            }
            case 3: {
                return pSUWProjectBase.getCreateDate() == null;
            }
            case 4: {
                return pSUWProjectBase.getCreateMan() == null;
            }
            case 5: {
                return pSUWProjectBase.getEndTime() == null;
            }
            case 6: {
                return pSUWProjectBase.getErrorCode() == null;
            }
            case 7: {
                return pSUWProjectBase.getErrorInfo() == null;
            }
            case 8: {
                return pSUWProjectBase.getLogicName() == null;
            }
            case 9: {
                return pSUWProjectBase.getMemo() == null;
            }
            case 10: {
                return pSUWProjectBase.getProjectName() == null;
            }
            case 11: {
                return pSUWProjectBase.getPSDCWorkspaceId() == null;
            }
            case 12: {
                return pSUWProjectBase.getPSDCWorkspaceName() == null;
            }
            case 13: {
                return pSUWProjectBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSUWProjectBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSUWProjectBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSUWProjectBase.getPSDevSlnName() == null;
            }
            case 17: {
                return pSUWProjectBase.getPSDynaInstId() == null;
            }
            case 18: {
                return pSUWProjectBase.getPSPFId() == null;
            }
            case 19: {
                return pSUWProjectBase.getPSPFName() == null;
            }
            case 20: {
                return pSUWProjectBase.getPSPFStyleId() == null;
            }
            case 21: {
                return pSUWProjectBase.getPSPFStyleName() == null;
            }
            case 22: {
                return pSUWProjectBase.getPSSFId() == null;
            }
            case 23: {
                return pSUWProjectBase.getPSSFName() == null;
            }
            case 24: {
                return pSUWProjectBase.getPSSFStyleId() == null;
            }
            case 25: {
                return pSUWProjectBase.getPSSFStyleName() == null;
            }
            case 26: {
                return pSUWProjectBase.getPSUWProjectId() == null;
            }
            case 27: {
                return pSUWProjectBase.getPSUWProjectName() == null;
            }
            case 28: {
                return pSUWProjectBase.getRealProjectId() == null;
            }
            case 29: {
                return pSUWProjectBase.getSource() == null;
            }
            case 30: {
                return pSUWProjectBase.getSource2() == null;
            }
            case 31: {
                return pSUWProjectBase.getSourceName() == null;
            }
            case 32: {
                return pSUWProjectBase.getSourceType() == null;
            }
            case 33: {
                return pSUWProjectBase.getUpdateDate() == null;
            }
            case 34: {
                return pSUWProjectBase.getUpdateMan() == null;
            }
            case 35: {
                return pSUWProjectBase.getWizardMode() == null;
            }
            case 36: {
                return pSUWProjectBase.getWizardParam() == null;
            }
            case 37: {
                return pSUWProjectBase.getWizardParam2() == null;
            }
            case 38: {
                return pSUWProjectBase.getWizardParam3() == null;
            }
            case 39: {
                return pSUWProjectBase.getWizardParam4() == null;
            }
            case 40: {
                return pSUWProjectBase.getWizardParam5() == null;
            }
            case 41: {
                return pSUWProjectBase.getWizardParam6() == null;
            }
            case 42: {
                return pSUWProjectBase.getWizardState() == null;
            }
            case 43: {
                return pSUWProjectBase.getWizardStep() == null;
            }
            case 44: {
                return pSUWProjectBase.getWizardTag() == null;
            }
            case 45: {
                return pSUWProjectBase.getWizardTag2() == null;
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
        return PSUWProjectBase.contains(this, n);
    }

    private static boolean contains(PSUWProjectBase pSUWProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWProjectBase.isAutoCreateSlnDirty();
            }
            case 1: {
                return pSUWProjectBase.isBeginTimeDirty();
            }
            case 2: {
                return pSUWProjectBase.isCodeNameDirty();
            }
            case 3: {
                return pSUWProjectBase.isCreateDateDirty();
            }
            case 4: {
                return pSUWProjectBase.isCreateManDirty();
            }
            case 5: {
                return pSUWProjectBase.isEndTimeDirty();
            }
            case 6: {
                return pSUWProjectBase.isErrorCodeDirty();
            }
            case 7: {
                return pSUWProjectBase.isErrorInfoDirty();
            }
            case 8: {
                return pSUWProjectBase.isLogicNameDirty();
            }
            case 9: {
                return pSUWProjectBase.isMemoDirty();
            }
            case 10: {
                return pSUWProjectBase.isProjectNameDirty();
            }
            case 11: {
                return pSUWProjectBase.isPSDCWorkspaceIdDirty();
            }
            case 12: {
                return pSUWProjectBase.isPSDCWorkspaceNameDirty();
            }
            case 13: {
                return pSUWProjectBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSUWProjectBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSUWProjectBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSUWProjectBase.isPSDevSlnNameDirty();
            }
            case 17: {
                return pSUWProjectBase.isPSDynaInstIdDirty();
            }
            case 18: {
                return pSUWProjectBase.isPSPFIdDirty();
            }
            case 19: {
                return pSUWProjectBase.isPSPFNameDirty();
            }
            case 20: {
                return pSUWProjectBase.isPSPFStyleIdDirty();
            }
            case 21: {
                return pSUWProjectBase.isPSPFStyleNameDirty();
            }
            case 22: {
                return pSUWProjectBase.isPSSFIdDirty();
            }
            case 23: {
                return pSUWProjectBase.isPSSFNameDirty();
            }
            case 24: {
                return pSUWProjectBase.isPSSFStyleIdDirty();
            }
            case 25: {
                return pSUWProjectBase.isPSSFStyleNameDirty();
            }
            case 26: {
                return pSUWProjectBase.isPSUWProjectIdDirty();
            }
            case 27: {
                return pSUWProjectBase.isPSUWProjectNameDirty();
            }
            case 28: {
                return pSUWProjectBase.isRealProjectIdDirty();
            }
            case 29: {
                return pSUWProjectBase.isSourceDirty();
            }
            case 30: {
                return pSUWProjectBase.isSource2Dirty();
            }
            case 31: {
                return pSUWProjectBase.isSourceNameDirty();
            }
            case 32: {
                return pSUWProjectBase.isSourceTypeDirty();
            }
            case 33: {
                return pSUWProjectBase.isUpdateDateDirty();
            }
            case 34: {
                return pSUWProjectBase.isUpdateManDirty();
            }
            case 35: {
                return pSUWProjectBase.isWizardModeDirty();
            }
            case 36: {
                return pSUWProjectBase.isWizardParamDirty();
            }
            case 37: {
                return pSUWProjectBase.isWizardParam2Dirty();
            }
            case 38: {
                return pSUWProjectBase.isWizardParam3Dirty();
            }
            case 39: {
                return pSUWProjectBase.isWizardParam4Dirty();
            }
            case 40: {
                return pSUWProjectBase.isWizardParam5Dirty();
            }
            case 41: {
                return pSUWProjectBase.isWizardParam6Dirty();
            }
            case 42: {
                return pSUWProjectBase.isWizardStateDirty();
            }
            case 43: {
                return pSUWProjectBase.isWizardStepDirty();
            }
            case 44: {
                return pSUWProjectBase.isWizardTagDirty();
            }
            case 45: {
                return pSUWProjectBase.isWizardTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWProjectBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWProjectBase pSUWProjectBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWProjectBase.getAutoCreateSln() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autocreatesln", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getAutoCreateSln()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getCodeName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getEndTime()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getErrorCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorcode", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getErrorCode()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getErrorInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorinfo", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getErrorInfo()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getLogicName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getMemo()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getProjectName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"projectname", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getProjectName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSDCWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacename", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSDCWorkspaceName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSUWProjectId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwprojectid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSUWProjectId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getPSUWProjectName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwprojectname", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getPSUWProjectName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getRealProjectId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"realprojectid", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getRealProjectId()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getSource() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"source", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getSource()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getSource2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"source2", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getSource2()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getSourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sourcename", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getSourceName()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getSourceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sourcetype", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getSourceType()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardParam4()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam5", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardParam5()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam6", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardParam6()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardstate", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardState()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardStep() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardstep", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardStep()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardtag", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardTag()), (boolean)false);
        }
        if (bl || pSUWProjectBase.getWizardTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardtag2", (Object)PSUWProjectBase.getJSONValue((Object)pSUWProjectBase.getWizardTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWProjectBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWProjectBase pSUWProjectBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWProjectBase.getAutoCreateSln() != null) {
            object = pSUWProjectBase.getAutoCreateSln();
            xmlNode.setAttribute(FIELD_AUTOCREATESLN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWProjectBase.getBeginTime() != null) {
            object = pSUWProjectBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWProjectBase.getCodeName() != null) {
            object = pSUWProjectBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getCreateDate() != null) {
            object = pSUWProjectBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWProjectBase.getCreateMan() != null) {
            object = pSUWProjectBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getEndTime() != null) {
            object = pSUWProjectBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWProjectBase.getErrorCode() != null) {
            object = pSUWProjectBase.getErrorCode();
            xmlNode.setAttribute(FIELD_ERRORCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWProjectBase.getErrorInfo() != null) {
            object = pSUWProjectBase.getErrorInfo();
            xmlNode.setAttribute(FIELD_ERRORINFO, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getLogicName() != null) {
            object = pSUWProjectBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getMemo() != null) {
            object = pSUWProjectBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getProjectName() != null) {
            object = pSUWProjectBase.getProjectName();
            xmlNode.setAttribute(FIELD_PROJECTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSDCWorkspaceId() != null) {
            object = pSUWProjectBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSDCWorkspaceName() != null) {
            object = pSUWProjectBase.getPSDCWorkspaceName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSDevCenterId() != null) {
            object = pSUWProjectBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSDevCenterName() != null) {
            object = pSUWProjectBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSDevSlnId() != null) {
            object = pSUWProjectBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSDevSlnName() != null) {
            object = pSUWProjectBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSDynaInstId() != null) {
            object = pSUWProjectBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSPFId() != null) {
            object = pSUWProjectBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSPFName() != null) {
            object = pSUWProjectBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSPFStyleId() != null) {
            object = pSUWProjectBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSPFStyleName() != null) {
            object = pSUWProjectBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSSFId() != null) {
            object = pSUWProjectBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSSFName() != null) {
            object = pSUWProjectBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSSFStyleId() != null) {
            object = pSUWProjectBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSSFStyleName() != null) {
            object = pSUWProjectBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSUWProjectId() != null) {
            object = pSUWProjectBase.getPSUWProjectId();
            xmlNode.setAttribute(FIELD_PSUWPROJECTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getPSUWProjectName() != null) {
            object = pSUWProjectBase.getPSUWProjectName();
            xmlNode.setAttribute(FIELD_PSUWPROJECTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getRealProjectId() != null) {
            object = pSUWProjectBase.getRealProjectId();
            xmlNode.setAttribute(FIELD_REALPROJECTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getSource() != null) {
            object = pSUWProjectBase.getSource();
            xmlNode.setAttribute(FIELD_SOURCE, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getSource2() != null) {
            object = pSUWProjectBase.getSource2();
            xmlNode.setAttribute(FIELD_SOURCE2, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getSourceName() != null) {
            object = pSUWProjectBase.getSourceName();
            xmlNode.setAttribute(FIELD_SOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getSourceType() != null) {
            object = pSUWProjectBase.getSourceType();
            xmlNode.setAttribute(FIELD_SOURCETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getUpdateDate() != null) {
            object = pSUWProjectBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWProjectBase.getUpdateMan() != null) {
            object = pSUWProjectBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardMode() != null) {
            object = pSUWProjectBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardParam() != null) {
            object = pSUWProjectBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardParam2() != null) {
            object = pSUWProjectBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardParam3() != null) {
            object = pSUWProjectBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardParam4() != null) {
            object = pSUWProjectBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardParam5() != null) {
            object = pSUWProjectBase.getWizardParam5();
            xmlNode.setAttribute(FIELD_WIZARDPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWProjectBase.getWizardParam6() != null) {
            object = pSUWProjectBase.getWizardParam6();
            xmlNode.setAttribute(FIELD_WIZARDPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWProjectBase.getWizardState() != null) {
            object = pSUWProjectBase.getWizardState();
            xmlNode.setAttribute(FIELD_WIZARDSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWProjectBase.getWizardStep() != null) {
            object = pSUWProjectBase.getWizardStep();
            xmlNode.setAttribute(FIELD_WIZARDSTEP, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardTag() != null) {
            object = pSUWProjectBase.getWizardTag();
            xmlNode.setAttribute(FIELD_WIZARDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSUWProjectBase.getWizardTag2() != null) {
            object = pSUWProjectBase.getWizardTag2();
            xmlNode.setAttribute(FIELD_WIZARDTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWProjectBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWProjectBase pSUWProjectBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWProjectBase.isAutoCreateSlnDirty() && (bl || pSUWProjectBase.getAutoCreateSln() != null)) {
            iDataObject.set(FIELD_AUTOCREATESLN, (Object)pSUWProjectBase.getAutoCreateSln());
        }
        if (pSUWProjectBase.isBeginTimeDirty() && (bl || pSUWProjectBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSUWProjectBase.getBeginTime());
        }
        if (pSUWProjectBase.isCodeNameDirty() && (bl || pSUWProjectBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSUWProjectBase.getCodeName());
        }
        if (pSUWProjectBase.isCreateDateDirty() && (bl || pSUWProjectBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWProjectBase.getCreateDate());
        }
        if (pSUWProjectBase.isCreateManDirty() && (bl || pSUWProjectBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWProjectBase.getCreateMan());
        }
        if (pSUWProjectBase.isEndTimeDirty() && (bl || pSUWProjectBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSUWProjectBase.getEndTime());
        }
        if (pSUWProjectBase.isErrorCodeDirty() && (bl || pSUWProjectBase.getErrorCode() != null)) {
            iDataObject.set(FIELD_ERRORCODE, (Object)pSUWProjectBase.getErrorCode());
        }
        if (pSUWProjectBase.isErrorInfoDirty() && (bl || pSUWProjectBase.getErrorInfo() != null)) {
            iDataObject.set(FIELD_ERRORINFO, (Object)pSUWProjectBase.getErrorInfo());
        }
        if (pSUWProjectBase.isLogicNameDirty() && (bl || pSUWProjectBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSUWProjectBase.getLogicName());
        }
        if (pSUWProjectBase.isMemoDirty() && (bl || pSUWProjectBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUWProjectBase.getMemo());
        }
        if (pSUWProjectBase.isProjectNameDirty() && (bl || pSUWProjectBase.getProjectName() != null)) {
            iDataObject.set(FIELD_PROJECTNAME, (Object)pSUWProjectBase.getProjectName());
        }
        if (pSUWProjectBase.isPSDCWorkspaceIdDirty() && (bl || pSUWProjectBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSUWProjectBase.getPSDCWorkspaceId());
        }
        if (pSUWProjectBase.isPSDCWorkspaceNameDirty() && (bl || pSUWProjectBase.getPSDCWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACENAME, (Object)pSUWProjectBase.getPSDCWorkspaceName());
        }
        if (pSUWProjectBase.isPSDevCenterIdDirty() && (bl || pSUWProjectBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSUWProjectBase.getPSDevCenterId());
        }
        if (pSUWProjectBase.isPSDevCenterNameDirty() && (bl || pSUWProjectBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSUWProjectBase.getPSDevCenterName());
        }
        if (pSUWProjectBase.isPSDevSlnIdDirty() && (bl || pSUWProjectBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSUWProjectBase.getPSDevSlnId());
        }
        if (pSUWProjectBase.isPSDevSlnNameDirty() && (bl || pSUWProjectBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSUWProjectBase.getPSDevSlnName());
        }
        if (pSUWProjectBase.isPSDynaInstIdDirty() && (bl || pSUWProjectBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWProjectBase.getPSDynaInstId());
        }
        if (pSUWProjectBase.isPSPFIdDirty() && (bl || pSUWProjectBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSUWProjectBase.getPSPFId());
        }
        if (pSUWProjectBase.isPSPFNameDirty() && (bl || pSUWProjectBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSUWProjectBase.getPSPFName());
        }
        if (pSUWProjectBase.isPSPFStyleIdDirty() && (bl || pSUWProjectBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSUWProjectBase.getPSPFStyleId());
        }
        if (pSUWProjectBase.isPSPFStyleNameDirty() && (bl || pSUWProjectBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSUWProjectBase.getPSPFStyleName());
        }
        if (pSUWProjectBase.isPSSFIdDirty() && (bl || pSUWProjectBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSUWProjectBase.getPSSFId());
        }
        if (pSUWProjectBase.isPSSFNameDirty() && (bl || pSUWProjectBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSUWProjectBase.getPSSFName());
        }
        if (pSUWProjectBase.isPSSFStyleIdDirty() && (bl || pSUWProjectBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSUWProjectBase.getPSSFStyleId());
        }
        if (pSUWProjectBase.isPSSFStyleNameDirty() && (bl || pSUWProjectBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSUWProjectBase.getPSSFStyleName());
        }
        if (pSUWProjectBase.isPSUWProjectIdDirty() && (bl || pSUWProjectBase.getPSUWProjectId() != null)) {
            iDataObject.set(FIELD_PSUWPROJECTID, (Object)pSUWProjectBase.getPSUWProjectId());
        }
        if (pSUWProjectBase.isPSUWProjectNameDirty() && (bl || pSUWProjectBase.getPSUWProjectName() != null)) {
            iDataObject.set(FIELD_PSUWPROJECTNAME, (Object)pSUWProjectBase.getPSUWProjectName());
        }
        if (pSUWProjectBase.isRealProjectIdDirty() && (bl || pSUWProjectBase.getRealProjectId() != null)) {
            iDataObject.set(FIELD_REALPROJECTID, (Object)pSUWProjectBase.getRealProjectId());
        }
        if (pSUWProjectBase.isSourceDirty() && (bl || pSUWProjectBase.getSource() != null)) {
            iDataObject.set(FIELD_SOURCE, (Object)pSUWProjectBase.getSource());
        }
        if (pSUWProjectBase.isSource2Dirty() && (bl || pSUWProjectBase.getSource2() != null)) {
            iDataObject.set(FIELD_SOURCE2, (Object)pSUWProjectBase.getSource2());
        }
        if (pSUWProjectBase.isSourceNameDirty() && (bl || pSUWProjectBase.getSourceName() != null)) {
            iDataObject.set(FIELD_SOURCENAME, (Object)pSUWProjectBase.getSourceName());
        }
        if (pSUWProjectBase.isSourceTypeDirty() && (bl || pSUWProjectBase.getSourceType() != null)) {
            iDataObject.set(FIELD_SOURCETYPE, (Object)pSUWProjectBase.getSourceType());
        }
        if (pSUWProjectBase.isUpdateDateDirty() && (bl || pSUWProjectBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWProjectBase.getUpdateDate());
        }
        if (pSUWProjectBase.isUpdateManDirty() && (bl || pSUWProjectBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWProjectBase.getUpdateMan());
        }
        if (pSUWProjectBase.isWizardModeDirty() && (bl || pSUWProjectBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWProjectBase.getWizardMode());
        }
        if (pSUWProjectBase.isWizardParamDirty() && (bl || pSUWProjectBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUWProjectBase.getWizardParam());
        }
        if (pSUWProjectBase.isWizardParam2Dirty() && (bl || pSUWProjectBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUWProjectBase.getWizardParam2());
        }
        if (pSUWProjectBase.isWizardParam3Dirty() && (bl || pSUWProjectBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUWProjectBase.getWizardParam3());
        }
        if (pSUWProjectBase.isWizardParam4Dirty() && (bl || pSUWProjectBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUWProjectBase.getWizardParam4());
        }
        if (pSUWProjectBase.isWizardParam5Dirty() && (bl || pSUWProjectBase.getWizardParam5() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM5, (Object)pSUWProjectBase.getWizardParam5());
        }
        if (pSUWProjectBase.isWizardParam6Dirty() && (bl || pSUWProjectBase.getWizardParam6() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM6, (Object)pSUWProjectBase.getWizardParam6());
        }
        if (pSUWProjectBase.isWizardStateDirty() && (bl || pSUWProjectBase.getWizardState() != null)) {
            iDataObject.set(FIELD_WIZARDSTATE, (Object)pSUWProjectBase.getWizardState());
        }
        if (pSUWProjectBase.isWizardStepDirty() && (bl || pSUWProjectBase.getWizardStep() != null)) {
            iDataObject.set(FIELD_WIZARDSTEP, (Object)pSUWProjectBase.getWizardStep());
        }
        if (pSUWProjectBase.isWizardTagDirty() && (bl || pSUWProjectBase.getWizardTag() != null)) {
            iDataObject.set(FIELD_WIZARDTAG, (Object)pSUWProjectBase.getWizardTag());
        }
        if (pSUWProjectBase.isWizardTag2Dirty() && (bl || pSUWProjectBase.getWizardTag2() != null)) {
            iDataObject.set(FIELD_WIZARDTAG2, (Object)pSUWProjectBase.getWizardTag2());
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
        return PSUWProjectBase.remove(this, n);
    }

    private static boolean remove(PSUWProjectBase pSUWProjectBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWProjectBase.resetAutoCreateSln();
                return true;
            }
            case 1: {
                pSUWProjectBase.resetBeginTime();
                return true;
            }
            case 2: {
                pSUWProjectBase.resetCodeName();
                return true;
            }
            case 3: {
                pSUWProjectBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSUWProjectBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSUWProjectBase.resetEndTime();
                return true;
            }
            case 6: {
                pSUWProjectBase.resetErrorCode();
                return true;
            }
            case 7: {
                pSUWProjectBase.resetErrorInfo();
                return true;
            }
            case 8: {
                pSUWProjectBase.resetLogicName();
                return true;
            }
            case 9: {
                pSUWProjectBase.resetMemo();
                return true;
            }
            case 10: {
                pSUWProjectBase.resetProjectName();
                return true;
            }
            case 11: {
                pSUWProjectBase.resetPSDCWorkspaceId();
                return true;
            }
            case 12: {
                pSUWProjectBase.resetPSDCWorkspaceName();
                return true;
            }
            case 13: {
                pSUWProjectBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSUWProjectBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSUWProjectBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSUWProjectBase.resetPSDevSlnName();
                return true;
            }
            case 17: {
                pSUWProjectBase.resetPSDynaInstId();
                return true;
            }
            case 18: {
                pSUWProjectBase.resetPSPFId();
                return true;
            }
            case 19: {
                pSUWProjectBase.resetPSPFName();
                return true;
            }
            case 20: {
                pSUWProjectBase.resetPSPFStyleId();
                return true;
            }
            case 21: {
                pSUWProjectBase.resetPSPFStyleName();
                return true;
            }
            case 22: {
                pSUWProjectBase.resetPSSFId();
                return true;
            }
            case 23: {
                pSUWProjectBase.resetPSSFName();
                return true;
            }
            case 24: {
                pSUWProjectBase.resetPSSFStyleId();
                return true;
            }
            case 25: {
                pSUWProjectBase.resetPSSFStyleName();
                return true;
            }
            case 26: {
                pSUWProjectBase.resetPSUWProjectId();
                return true;
            }
            case 27: {
                pSUWProjectBase.resetPSUWProjectName();
                return true;
            }
            case 28: {
                pSUWProjectBase.resetRealProjectId();
                return true;
            }
            case 29: {
                pSUWProjectBase.resetSource();
                return true;
            }
            case 30: {
                pSUWProjectBase.resetSource2();
                return true;
            }
            case 31: {
                pSUWProjectBase.resetSourceName();
                return true;
            }
            case 32: {
                pSUWProjectBase.resetSourceType();
                return true;
            }
            case 33: {
                pSUWProjectBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSUWProjectBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSUWProjectBase.resetWizardMode();
                return true;
            }
            case 36: {
                pSUWProjectBase.resetWizardParam();
                return true;
            }
            case 37: {
                pSUWProjectBase.resetWizardParam2();
                return true;
            }
            case 38: {
                pSUWProjectBase.resetWizardParam3();
                return true;
            }
            case 39: {
                pSUWProjectBase.resetWizardParam4();
                return true;
            }
            case 40: {
                pSUWProjectBase.resetWizardParam5();
                return true;
            }
            case 41: {
                pSUWProjectBase.resetWizardParam6();
                return true;
            }
            case 42: {
                pSUWProjectBase.resetWizardState();
                return true;
            }
            case 43: {
                pSUWProjectBase.resetWizardStep();
                return true;
            }
            case 44: {
                pSUWProjectBase.resetWizardTag();
                return true;
            }
            case 45: {
                pSUWProjectBase.resetWizardTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWProjectBase getProxyEntity() {
        return this.proxyPSUWProjectBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWProjectBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWProjectBase) {
            this.proxyPSUWProjectBase = (PSUWProjectBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTOCREATESLN, 0);
        fieldIndexMap.put(FIELD_BEGINTIME, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ENDTIME, 5);
        fieldIndexMap.put(FIELD_ERRORCODE, 6);
        fieldIndexMap.put(FIELD_ERRORINFO, 7);
        fieldIndexMap.put(FIELD_LOGICNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PROJECTNAME, 10);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 11);
        fieldIndexMap.put(FIELD_PSDCWORKSPACENAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 16);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 17);
        fieldIndexMap.put(FIELD_PSPFID, 18);
        fieldIndexMap.put(FIELD_PSPFNAME, 19);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 20);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 21);
        fieldIndexMap.put(FIELD_PSSFID, 22);
        fieldIndexMap.put(FIELD_PSSFNAME, 23);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 24);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 25);
        fieldIndexMap.put(FIELD_PSUWPROJECTID, 26);
        fieldIndexMap.put(FIELD_PSUWPROJECTNAME, 27);
        fieldIndexMap.put(FIELD_REALPROJECTID, 28);
        fieldIndexMap.put(FIELD_SOURCE, 29);
        fieldIndexMap.put(FIELD_SOURCE2, 30);
        fieldIndexMap.put(FIELD_SOURCENAME, 31);
        fieldIndexMap.put(FIELD_SOURCETYPE, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_WIZARDMODE, 35);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 36);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 37);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 38);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 39);
        fieldIndexMap.put(FIELD_WIZARDPARAM5, 40);
        fieldIndexMap.put(FIELD_WIZARDPARAM6, 41);
        fieldIndexMap.put(FIELD_WIZARDSTATE, 42);
        fieldIndexMap.put(FIELD_WIZARDSTEP, 43);
        fieldIndexMap.put(FIELD_WIZARDTAG, 44);
        fieldIndexMap.put(FIELD_WIZARDTAG2, 45);
    }
}

