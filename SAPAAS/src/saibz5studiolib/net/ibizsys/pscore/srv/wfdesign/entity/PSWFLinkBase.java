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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFLinkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFLinkBase.class);
    public static final String FIELD_ACTIONFIELD = "ACTIONFIELD";
    public static final String FIELD_ACTIONPSCODELISTID = "ACTIONPSCODELISTID";
    public static final String FIELD_ACTIONPSCODELISTNAME = "ACTIONPSCODELISTNAME";
    public static final String FIELD_ACTORFIELDS = "ACTORFIELDS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONDMODEL = "CONDMODEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMCONDFLAG = "CUSTOMCONDFLAG";
    public static final String FIELD_DEFAULTLINK = "DEFAULTLINK";
    public static final String FIELD_DSTENDPOINT = "DSTENDPOINT";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ENABLEMOBILE = "ENABLEMOBILE";
    public static final String FIELD_FORMCODENAME = "FORMCODENAME";
    public static final String FIELD_FROMPSWFPROCID = "FROMPSWFPROCID";
    public static final String FIELD_FROMPSWFPROCNAME = "FROMPSWFPROCNAME";
    public static final String FIELD_LABEL = "LABEL";
    public static final String FIELD_LNPSLANRESID = "LNPSLANRESID";
    public static final String FIELD_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MEMOFIELD = "MEMOFIELD";
    public static final String FIELD_MOBFORMCODENAME = "MOBFORMCODENAME";
    public static final String FIELD_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String FIELD_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String FIELD_MOBPSDEVIEWID = "MOBPSDEVIEWID";
    public static final String FIELD_MOBPSDEVIEWNAME = "MOBPSDEVIEWNAME";
    public static final String FIELD_MOBVIEWCODENAME = "MOBVIEWCODENAME";
    public static final String FIELD_MODELID = "MODELID";
    public static final String FIELD_NEXTCOND = "NEXTCOND";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSWFID = "PSWFID";
    public static final String FIELD_PSWFLINKID = "PSWFLINKID";
    public static final String FIELD_PSWFLINKNAME = "PSWFLINKNAME";
    public static final String FIELD_PSWFNAME = "PSWFNAME";
    public static final String FIELD_PSWFROLEID = "PSWFROLEID";
    public static final String FIELD_PSWFROLENAME = "PSWFROLENAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_SHAPEPARAMS = "SHAPEPARAMS";
    public static final String FIELD_SOMEROLEFLAG = "SOMEROLEFLAG";
    public static final String FIELD_SRCENDPOINT = "SRCENDPOINT";
    public static final String FIELD_THREADFLAG = "THREADFLAG";
    public static final String FIELD_THREADNAME = "THREADNAME";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOPSWFPROCID = "TOPSWFPROCID";
    public static final String FIELD_TOPSWFPROCNAME = "TOPSWFPROCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWCODENAME = "VIEWCODENAME";
    public static final String FIELD_WFENGINETYPE = "WFENGINETYPE";
    public static final String FIELD_WFLINKTYPE = "WFLINKTYPE";
    private static final int INDEX_ACTIONFIELD = 0;
    private static final int INDEX_ACTIONPSCODELISTID = 1;
    private static final int INDEX_ACTIONPSCODELISTNAME = 2;
    private static final int INDEX_ACTORFIELDS = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CONDMODEL = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CUSTOMCOND = 8;
    private static final int INDEX_CUSTOMCONDFLAG = 9;
    private static final int INDEX_DEFAULTLINK = 10;
    private static final int INDEX_DSTENDPOINT = 11;
    private static final int INDEX_DYNAMODELFLAG = 12;
    private static final int INDEX_ENABLE = 13;
    private static final int INDEX_ENABLEMOBILE = 14;
    private static final int INDEX_FORMCODENAME = 15;
    private static final int INDEX_FROMPSWFPROCID = 16;
    private static final int INDEX_FROMPSWFPROCNAME = 17;
    private static final int INDEX_LABEL = 18;
    private static final int INDEX_LNPSLANRESID = 19;
    private static final int INDEX_LNPSLANRESNAME = 20;
    private static final int INDEX_LOGICNAME = 21;
    private static final int INDEX_MEMO = 22;
    private static final int INDEX_MEMOFIELD = 23;
    private static final int INDEX_MOBFORMCODENAME = 24;
    private static final int INDEX_MOBPSDEFORMID = 25;
    private static final int INDEX_MOBPSDEFORMNAME = 26;
    private static final int INDEX_MOBPSDEVIEWID = 27;
    private static final int INDEX_MOBPSDEVIEWNAME = 28;
    private static final int INDEX_MOBVIEWCODENAME = 29;
    private static final int INDEX_MODELID = 30;
    private static final int INDEX_NEXTCOND = 31;
    private static final int INDEX_ORDERVALUE = 32;
    private static final int INDEX_PSDEFORMID = 33;
    private static final int INDEX_PSDEFORMNAME = 34;
    private static final int INDEX_PSDEID = 35;
    private static final int INDEX_PSDEVIEWBASEID = 36;
    private static final int INDEX_PSDEVIEWBASENAME = 37;
    private static final int INDEX_PSDYNAINSTID = 38;
    private static final int INDEX_PSSYSTEMID = 39;
    private static final int INDEX_PSWFDEID = 40;
    private static final int INDEX_PSWFID = 41;
    private static final int INDEX_PSWFLINKID = 42;
    private static final int INDEX_PSWFLINKNAME = 43;
    private static final int INDEX_PSWFNAME = 44;
    private static final int INDEX_PSWFROLEID = 45;
    private static final int INDEX_PSWFROLENAME = 46;
    private static final int INDEX_PSWFVERSIONID = 47;
    private static final int INDEX_PSWFVERSIONNAME = 48;
    private static final int INDEX_SHAPEPARAMS = 49;
    private static final int INDEX_SOMEROLEFLAG = 50;
    private static final int INDEX_SRCENDPOINT = 51;
    private static final int INDEX_THREADFLAG = 52;
    private static final int INDEX_THREADNAME = 53;
    private static final int INDEX_TIPPSLANRESID = 54;
    private static final int INDEX_TIPPSLANRESNAME = 55;
    private static final int INDEX_TOPSWFPROCID = 56;
    private static final int INDEX_TOPSWFPROCNAME = 57;
    private static final int INDEX_UPDATEDATE = 58;
    private static final int INDEX_UPDATEMAN = 59;
    private static final int INDEX_USERCAT = 60;
    private static final int INDEX_USERDATA = 61;
    private static final int INDEX_USERDATA2 = 62;
    private static final int INDEX_USERTAG = 63;
    private static final int INDEX_USERTAG2 = 64;
    private static final int INDEX_USERTAG3 = 65;
    private static final int INDEX_USERTAG4 = 66;
    private static final int INDEX_VIEWCODENAME = 67;
    private static final int INDEX_WFENGINETYPE = 68;
    private static final int INDEX_WFLINKTYPE = 69;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFLinkBase proxyPSWFLinkBase = null;
    private boolean actionfieldDirtyFlag = false;
    private boolean actionpscodelistidDirtyFlag = false;
    private boolean actionpscodelistnameDirtyFlag = false;
    private boolean actorfieldsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean condmodelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customcondflagDirtyFlag = false;
    private boolean defaultlinkDirtyFlag = false;
    private boolean dstendpointDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean enablemobileDirtyFlag = false;
    private boolean formcodenameDirtyFlag = false;
    private boolean frompswfprocidDirtyFlag = false;
    private boolean frompswfprocnameDirtyFlag = false;
    private boolean labelDirtyFlag = false;
    private boolean lnpslanresidDirtyFlag = false;
    private boolean lnpslanresnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean memofieldDirtyFlag = false;
    private boolean mobformcodenameDirtyFlag = false;
    private boolean mobpsdeformidDirtyFlag = false;
    private boolean mobpsdeformnameDirtyFlag = false;
    private boolean mobpsdeviewidDirtyFlag = false;
    private boolean mobpsdeviewnameDirtyFlag = false;
    private boolean mobviewcodenameDirtyFlag = false;
    private boolean modelidDirtyFlag = false;
    private boolean nextcondDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean pswfidDirtyFlag = false;
    private boolean pswflinkidDirtyFlag = false;
    private boolean pswflinknameDirtyFlag = false;
    private boolean pswfnameDirtyFlag = false;
    private boolean pswfroleidDirtyFlag = false;
    private boolean pswfrolenameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean shapeparamsDirtyFlag = false;
    private boolean someroleflagDirtyFlag = false;
    private boolean srcendpointDirtyFlag = false;
    private boolean threadflagDirtyFlag = false;
    private boolean threadnameDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean topswfprocidDirtyFlag = false;
    private boolean topswfprocnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewcodenameDirtyFlag = false;
    private boolean wfenginetypeDirtyFlag = false;
    private boolean wflinktypeDirtyFlag = false;
    @Column(name="actionfield")
    private String actionfield;
    @Column(name="actionpscodelistid")
    private String actionpscodelistid;
    @Column(name="actionpscodelistname")
    private String actionpscodelistname;
    @Column(name="actorfields")
    private String actorfields;
    @Column(name="codename")
    private String codename;
    @Column(name="condmodel")
    private String condmodel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customcondflag")
    private Integer customcondflag;
    @Column(name="defaultlink")
    private Integer defaultlink;
    @Column(name="dstendpoint")
    private String dstendpoint;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enable")
    private Integer enable;
    @Column(name="enablemobile")
    private Integer enablemobile;
    @Column(name="formcodename")
    private String formcodename;
    @Column(name="frompswfprocid")
    private String frompswfprocid;
    @Column(name="frompswfprocname")
    private String frompswfprocname;
    @Column(name="label")
    private String label;
    @Column(name="lnpslanresid")
    private String lnpslanresid;
    @Column(name="lnpslanresname")
    private String lnpslanresname;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="memofield")
    private String memofield;
    @Column(name="mobformcodename")
    private String mobformcodename;
    @Column(name="mobpsdeformid")
    private String mobpsdeformid;
    @Column(name="mobpsdeformname")
    private String mobpsdeformname;
    @Column(name="mobpsdeviewid")
    private String mobpsdeviewid;
    @Column(name="mobpsdeviewname")
    private String mobpsdeviewname;
    @Column(name="mobviewcodename")
    private String mobviewcodename;
    @Column(name="modelid")
    private String modelid;
    @Column(name="nextcond")
    private String nextcond;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="pswfid")
    private String pswfid;
    @Column(name="pswflinkid")
    private String pswflinkid;
    @Column(name="pswflinkname")
    private String pswflinkname;
    @Column(name="pswfname")
    private String pswfname;
    @Column(name="pswfroleid")
    private String pswfroleid;
    @Column(name="pswfrolename")
    private String pswfrolename;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="shapeparams")
    private String shapeparams;
    @Column(name="someroleflag")
    private Integer someroleflag;
    @Column(name="srcendpoint")
    private String srcendpoint;
    @Column(name="threadflag")
    private Integer threadflag;
    @Column(name="threadname")
    private String threadname;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="topswfprocid")
    private String topswfprocid;
    @Column(name="topswfprocname")
    private String topswfprocname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="viewcodename")
    private String viewcodename;
    @Column(name="wfenginetype")
    private String wfenginetype;
    @Column(name="wflinktype")
    private String wflinktype;
    private Integer objActionPSCodeListLock = new Integer(1);
    private PSCodeList actionpscodelist = null;
    private Integer objMobPSDEFormLock = new Integer(1);
    private PSDEForm mobpsdeform = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objMobPSDEViewLock = new Integer(1);
    private PSDEViewBase mobpsdeview = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objLNPSLanResLock = new Integer(1);
    private PSLanguageRes lnpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objFromPSWFProcLock = new Integer(1);
    private PSWFProcess frompswfproc = null;
    private Integer objToPSWFProcLock = new Integer(1);
    private PSWFProcess topswfproc = null;
    private Integer objPSWFRoleLock = new Integer(1);
    private PSWFRole pswfrole = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWorkflow pswf = null;
    private Integer objPSWFLinkCondsLock = new Integer(1);
    private ArrayList<PSWFLinkCond> pswflinkconds = null;
    private Integer objPSWFLinkRolesLock = new Integer(1);
    private ArrayList<PSWFLinkRole> pswflinkroles = null;

    public void setActionField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionfield = string;
        this.actionfieldDirtyFlag = true;
    }

    public String getActionField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionField();
        }
        return this.actionfield;
    }

    public boolean isActionFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionFieldDirty();
        }
        return this.actionfieldDirtyFlag;
    }

    public void resetActionField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionField();
            return;
        }
        this.actionfieldDirtyFlag = false;
        this.actionfield = null;
    }

    public void setActionPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionpscodelistid = string;
        this.actionpscodelistidDirtyFlag = true;
    }

    public String getActionPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionPSCodeListId();
        }
        return this.actionpscodelistid;
    }

    public boolean isActionPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionPSCodeListIdDirty();
        }
        return this.actionpscodelistidDirtyFlag;
    }

    public void resetActionPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionPSCodeListId();
            return;
        }
        this.actionpscodelistidDirtyFlag = false;
        this.actionpscodelistid = null;
    }

    public void setActionPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionpscodelistname = string;
        this.actionpscodelistnameDirtyFlag = true;
    }

    public String getActionPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionPSCodeListName();
        }
        return this.actionpscodelistname;
    }

    public boolean isActionPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionPSCodeListNameDirty();
        }
        return this.actionpscodelistnameDirtyFlag;
    }

    public void resetActionPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionPSCodeListName();
            return;
        }
        this.actionpscodelistnameDirtyFlag = false;
        this.actionpscodelistname = null;
    }

    public void setActorFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actorfields = string;
        this.actorfieldsDirtyFlag = true;
    }

    public String getActorFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorFields();
        }
        return this.actorfields;
    }

    public boolean isActorFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorFieldsDirty();
        }
        return this.actorfieldsDirtyFlag;
    }

    public void resetActorFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorFields();
            return;
        }
        this.actorfieldsDirtyFlag = false;
        this.actorfields = null;
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

    public void setCondModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condmodel = string;
        this.condmodelDirtyFlag = true;
    }

    public String getCondModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModel();
        }
        return this.condmodel;
    }

    public boolean isCondModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelDirty();
        }
        return this.condmodelDirtyFlag;
    }

    public void resetCondModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModel();
            return;
        }
        this.condmodelDirtyFlag = false;
        this.condmodel = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomCondFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCondFlag(n);
            return;
        }
        this.customcondflag = n;
        this.customcondflagDirtyFlag = true;
    }

    public Integer getCustomCondFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCondFlag();
        }
        return this.customcondflag;
    }

    public boolean isCustomCondFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondFlagDirty();
        }
        return this.customcondflagDirtyFlag;
    }

    public void resetCustomCondFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCondFlag();
            return;
        }
        this.customcondflagDirtyFlag = false;
        this.customcondflag = null;
    }

    public void setDefaultLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultLink(n);
            return;
        }
        this.defaultlink = n;
        this.defaultlinkDirtyFlag = true;
    }

    public Integer getDefaultLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultLink();
        }
        return this.defaultlink;
    }

    public boolean isDefaultLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultLinkDirty();
        }
        return this.defaultlinkDirtyFlag;
    }

    public void resetDefaultLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultLink();
            return;
        }
        this.defaultlinkDirtyFlag = false;
        this.defaultlink = null;
    }

    public void setDstEndPoint(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstEndPoint(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstendpoint = string;
        this.dstendpointDirtyFlag = true;
    }

    public String getDstEndPoint() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstEndPoint();
        }
        return this.dstendpoint;
    }

    public boolean isDstEndPointDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstEndPointDirty();
        }
        return this.dstendpointDirtyFlag;
    }

    public void resetDstEndPoint() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstEndPoint();
            return;
        }
        this.dstendpointDirtyFlag = false;
        this.dstendpoint = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setEnableMobile(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMobile(n);
            return;
        }
        this.enablemobile = n;
        this.enablemobileDirtyFlag = true;
    }

    public Integer getEnableMobile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMobile();
        }
        return this.enablemobile;
    }

    public boolean isEnableMobileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMobileDirty();
        }
        return this.enablemobileDirtyFlag;
    }

    public void resetEnableMobile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMobile();
            return;
        }
        this.enablemobileDirtyFlag = false;
        this.enablemobile = null;
    }

    public void setFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formcodename = string;
        this.formcodenameDirtyFlag = true;
    }

    public String getFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormCodeName();
        }
        return this.formcodename;
    }

    public boolean isFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormCodeNameDirty();
        }
        return this.formcodenameDirtyFlag;
    }

    public void resetFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormCodeName();
            return;
        }
        this.formcodenameDirtyFlag = false;
        this.formcodename = null;
    }

    public void setFromPSWFProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSWFProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompswfprocid = string;
        this.frompswfprocidDirtyFlag = true;
    }

    public String getFromPSWFProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSWFProcId();
        }
        return this.frompswfprocid;
    }

    public boolean isFromPSWFProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSWFProcIdDirty();
        }
        return this.frompswfprocidDirtyFlag;
    }

    public void resetFromPSWFProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSWFProcId();
            return;
        }
        this.frompswfprocidDirtyFlag = false;
        this.frompswfprocid = null;
    }

    public void setFromPSWFProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSWFProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompswfprocname = string;
        this.frompswfprocnameDirtyFlag = true;
    }

    public String getFromPSWFProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSWFProcName();
        }
        return this.frompswfprocname;
    }

    public boolean isFromPSWFProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSWFProcNameDirty();
        }
        return this.frompswfprocnameDirtyFlag;
    }

    public void resetFromPSWFProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSWFProcName();
            return;
        }
        this.frompswfprocnameDirtyFlag = false;
        this.frompswfprocname = null;
    }

    public void setLabel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.label = string;
        this.labelDirtyFlag = true;
    }

    public String getLabel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabel();
        }
        return this.label;
    }

    public boolean isLabelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelDirty();
        }
        return this.labelDirtyFlag;
    }

    public void resetLabel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabel();
            return;
        }
        this.labelDirtyFlag = false;
        this.label = null;
    }

    public void setLNPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresid = string;
        this.lnpslanresidDirtyFlag = true;
    }

    public String getLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResId();
        }
        return this.lnpslanresid;
    }

    public boolean isLNPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResIdDirty();
        }
        return this.lnpslanresidDirtyFlag;
    }

    public void resetLNPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResId();
            return;
        }
        this.lnpslanresidDirtyFlag = false;
        this.lnpslanresid = null;
    }

    public void setLNPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLNPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lnpslanresname = string;
        this.lnpslanresnameDirtyFlag = true;
    }

    public String getLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanResName();
        }
        return this.lnpslanresname;
    }

    public boolean isLNPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLNPSLanResNameDirty();
        }
        return this.lnpslanresnameDirtyFlag;
    }

    public void resetLNPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLNPSLanResName();
            return;
        }
        this.lnpslanresnameDirtyFlag = false;
        this.lnpslanresname = null;
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

    public void setMemoField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemoField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memofield = string;
        this.memofieldDirtyFlag = true;
    }

    public String getMemoField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemoField();
        }
        return this.memofield;
    }

    public boolean isMemoFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoFieldDirty();
        }
        return this.memofieldDirtyFlag;
    }

    public void resetMemoField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemoField();
            return;
        }
        this.memofieldDirtyFlag = false;
        this.memofield = null;
    }

    public void setMobFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobformcodename = string;
        this.mobformcodenameDirtyFlag = true;
    }

    public String getMobFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobFormCodeName();
        }
        return this.mobformcodename;
    }

    public boolean isMobFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobFormCodeNameDirty();
        }
        return this.mobformcodenameDirtyFlag;
    }

    public void resetMobFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobFormCodeName();
            return;
        }
        this.mobformcodenameDirtyFlag = false;
        this.mobformcodename = null;
    }

    public void setMobPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeformid = string;
        this.mobpsdeformidDirtyFlag = true;
    }

    public String getMobPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEFormId();
        }
        return this.mobpsdeformid;
    }

    public boolean isMobPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEFormIdDirty();
        }
        return this.mobpsdeformidDirtyFlag;
    }

    public void resetMobPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEFormId();
            return;
        }
        this.mobpsdeformidDirtyFlag = false;
        this.mobpsdeformid = null;
    }

    public void setMobPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeformname = string;
        this.mobpsdeformnameDirtyFlag = true;
    }

    public String getMobPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEFormName();
        }
        return this.mobpsdeformname;
    }

    public boolean isMobPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEFormNameDirty();
        }
        return this.mobpsdeformnameDirtyFlag;
    }

    public void resetMobPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEFormName();
            return;
        }
        this.mobpsdeformnameDirtyFlag = false;
        this.mobpsdeformname = null;
    }

    public void setMobPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeviewid = string;
        this.mobpsdeviewidDirtyFlag = true;
    }

    public String getMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEViewId();
        }
        return this.mobpsdeviewid;
    }

    public boolean isMobPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEViewIdDirty();
        }
        return this.mobpsdeviewidDirtyFlag;
    }

    public void resetMobPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEViewId();
            return;
        }
        this.mobpsdeviewidDirtyFlag = false;
        this.mobpsdeviewid = null;
    }

    public void setMobPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeviewname = string;
        this.mobpsdeviewnameDirtyFlag = true;
    }

    public String getMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEViewName();
        }
        return this.mobpsdeviewname;
    }

    public boolean isMobPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEViewNameDirty();
        }
        return this.mobpsdeviewnameDirtyFlag;
    }

    public void resetMobPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEViewName();
            return;
        }
        this.mobpsdeviewnameDirtyFlag = false;
        this.mobpsdeviewname = null;
    }

    public void setMobViewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobViewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobviewcodename = string;
        this.mobviewcodenameDirtyFlag = true;
    }

    public String getMobViewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobViewCodeName();
        }
        return this.mobviewcodename;
    }

    public boolean isMobViewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobViewCodeNameDirty();
        }
        return this.mobviewcodenameDirtyFlag;
    }

    public void resetMobViewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobViewCodeName();
            return;
        }
        this.mobviewcodenameDirtyFlag = false;
        this.mobviewcodename = null;
    }

    public void setModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelid = string;
        this.modelidDirtyFlag = true;
    }

    public String getModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelId();
        }
        return this.modelid;
    }

    public boolean isModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelIdDirty();
        }
        return this.modelidDirtyFlag;
    }

    public void resetModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelId();
            return;
        }
        this.modelidDirtyFlag = false;
        this.modelid = null;
    }

    public void setNextCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextcond = string;
        this.nextcondDirtyFlag = true;
    }

    public String getNextCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextCond();
        }
        return this.nextcond;
    }

    public boolean isNextCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextCondDirty();
        }
        return this.nextcondDirtyFlag;
    }

    public void resetNextCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextCond();
            return;
        }
        this.nextcondDirtyFlag = false;
        this.nextcond = null;
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

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
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

    public void setPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdeid = string;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
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

    public void setPSWFLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkid = string;
        this.pswflinkidDirtyFlag = true;
    }

    public String getPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkId();
        }
        return this.pswflinkid;
    }

    public boolean isPSWFLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkIdDirty();
        }
        return this.pswflinkidDirtyFlag;
    }

    public void resetPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkId();
            return;
        }
        this.pswflinkidDirtyFlag = false;
        this.pswflinkid = null;
    }

    public void setPSWFLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkname = string;
        this.pswflinknameDirtyFlag = true;
    }

    public String getPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkName();
        }
        return this.pswflinkname;
    }

    public boolean isPSWFLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkNameDirty();
        }
        return this.pswflinknameDirtyFlag;
    }

    public void resetPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkName();
            return;
        }
        this.pswflinknameDirtyFlag = false;
        this.pswflinkname = null;
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

    public void setPSWFRoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFRoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfroleid = string;
        this.pswfroleidDirtyFlag = true;
    }

    public String getPSWFRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRoleId();
        }
        return this.pswfroleid;
    }

    public boolean isPSWFRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFRoleIdDirty();
        }
        return this.pswfroleidDirtyFlag;
    }

    public void resetPSWFRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFRoleId();
            return;
        }
        this.pswfroleidDirtyFlag = false;
        this.pswfroleid = null;
    }

    public void setPSWFRoleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFRoleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfrolename = string;
        this.pswfrolenameDirtyFlag = true;
    }

    public String getPSWFRoleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRoleName();
        }
        return this.pswfrolename;
    }

    public boolean isPSWFRoleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFRoleNameDirty();
        }
        return this.pswfrolenameDirtyFlag;
    }

    public void resetPSWFRoleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFRoleName();
            return;
        }
        this.pswfrolenameDirtyFlag = false;
        this.pswfrolename = null;
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

    public void setShapeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeparams = string;
        this.shapeparamsDirtyFlag = true;
    }

    public String getShapeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeParams();
        }
        return this.shapeparams;
    }

    public boolean isShapeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeParamsDirty();
        }
        return this.shapeparamsDirtyFlag;
    }

    public void resetShapeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeParams();
            return;
        }
        this.shapeparamsDirtyFlag = false;
        this.shapeparams = null;
    }

    public void setSomeRoleFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSomeRoleFlag(n);
            return;
        }
        this.someroleflag = n;
        this.someroleflagDirtyFlag = true;
    }

    public Integer getSomeRoleFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSomeRoleFlag();
        }
        return this.someroleflag;
    }

    public boolean isSomeRoleFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSomeRoleFlagDirty();
        }
        return this.someroleflagDirtyFlag;
    }

    public void resetSomeRoleFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSomeRoleFlag();
            return;
        }
        this.someroleflagDirtyFlag = false;
        this.someroleflag = null;
    }

    public void setSrcEndPoint(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcEndPoint(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcendpoint = string;
        this.srcendpointDirtyFlag = true;
    }

    public String getSrcEndPoint() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcEndPoint();
        }
        return this.srcendpoint;
    }

    public boolean isSrcEndPointDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcEndPointDirty();
        }
        return this.srcendpointDirtyFlag;
    }

    public void resetSrcEndPoint() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcEndPoint();
            return;
        }
        this.srcendpointDirtyFlag = false;
        this.srcendpoint = null;
    }

    public void setThreadFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadFlag(n);
            return;
        }
        this.threadflag = n;
        this.threadflagDirtyFlag = true;
    }

    public Integer getThreadFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadFlag();
        }
        return this.threadflag;
    }

    public boolean isThreadFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadFlagDirty();
        }
        return this.threadflagDirtyFlag;
    }

    public void resetThreadFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadFlag();
            return;
        }
        this.threadflagDirtyFlag = false;
        this.threadflag = null;
    }

    public void setThreadName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.threadname = string;
        this.threadnameDirtyFlag = true;
    }

    public String getThreadName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadName();
        }
        return this.threadname;
    }

    public boolean isThreadNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadNameDirty();
        }
        return this.threadnameDirtyFlag;
    }

    public void resetThreadName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadName();
            return;
        }
        this.threadnameDirtyFlag = false;
        this.threadname = null;
    }

    public void setTipPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresid = string;
        this.tippslanresidDirtyFlag = true;
    }

    public String getTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResId();
        }
        return this.tippslanresid;
    }

    public boolean isTipPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResIdDirty();
        }
        return this.tippslanresidDirtyFlag;
    }

    public void resetTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResId();
            return;
        }
        this.tippslanresidDirtyFlag = false;
        this.tippslanresid = null;
    }

    public void setTipPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresname = string;
        this.tippslanresnameDirtyFlag = true;
    }

    public String getTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResName();
        }
        return this.tippslanresname;
    }

    public boolean isTipPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResNameDirty();
        }
        return this.tippslanresnameDirtyFlag;
    }

    public void resetTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResName();
            return;
        }
        this.tippslanresnameDirtyFlag = false;
        this.tippslanresname = null;
    }

    public void setToPSWFProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToPSWFProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topswfprocid = string;
        this.topswfprocidDirtyFlag = true;
    }

    public String getToPSWFProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToPSWFProcId();
        }
        return this.topswfprocid;
    }

    public boolean isToPSWFProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToPSWFProcIdDirty();
        }
        return this.topswfprocidDirtyFlag;
    }

    public void resetToPSWFProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToPSWFProcId();
            return;
        }
        this.topswfprocidDirtyFlag = false;
        this.topswfprocid = null;
    }

    public void setToPSWFProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToPSWFProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topswfprocname = string;
        this.topswfprocnameDirtyFlag = true;
    }

    public String getToPSWFProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToPSWFProcName();
        }
        return this.topswfprocname;
    }

    public boolean isToPSWFProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToPSWFProcNameDirty();
        }
        return this.topswfprocnameDirtyFlag;
    }

    public void resetToPSWFProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToPSWFProcName();
            return;
        }
        this.topswfprocnameDirtyFlag = false;
        this.topswfprocname = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
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

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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

    public void setViewCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewcodename = string;
        this.viewcodenameDirtyFlag = true;
    }

    public String getViewCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewCodeName();
        }
        return this.viewcodename;
    }

    public boolean isViewCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewCodeNameDirty();
        }
        return this.viewcodenameDirtyFlag;
    }

    public void resetViewCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewCodeName();
            return;
        }
        this.viewcodenameDirtyFlag = false;
        this.viewcodename = null;
    }

    public void setWFEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfenginetype = string;
        this.wfenginetypeDirtyFlag = true;
    }

    public String getWFEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFEngineType();
        }
        return this.wfenginetype;
    }

    public boolean isWFEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFEngineTypeDirty();
        }
        return this.wfenginetypeDirtyFlag;
    }

    public void resetWFEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFEngineType();
            return;
        }
        this.wfenginetypeDirtyFlag = false;
        this.wfenginetype = null;
    }

    public void setWFLinkType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFLinkType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wflinktype = string;
        this.wflinktypeDirtyFlag = true;
    }

    public String getWFLinkType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFLinkType();
        }
        return this.wflinktype;
    }

    public boolean isWFLinkTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFLinkTypeDirty();
        }
        return this.wflinktypeDirtyFlag;
    }

    public void resetWFLinkType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFLinkType();
            return;
        }
        this.wflinktypeDirtyFlag = false;
        this.wflinktype = null;
    }

    protected void onReset() {
        PSWFLinkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFLinkBase pSWFLinkBase) {
        pSWFLinkBase.resetActionField();
        pSWFLinkBase.resetActionPSCodeListId();
        pSWFLinkBase.resetActionPSCodeListName();
        pSWFLinkBase.resetActorFields();
        pSWFLinkBase.resetCodeName();
        pSWFLinkBase.resetCondModel();
        pSWFLinkBase.resetCreateDate();
        pSWFLinkBase.resetCreateMan();
        pSWFLinkBase.resetCustomCond();
        pSWFLinkBase.resetCustomCondFlag();
        pSWFLinkBase.resetDefaultLink();
        pSWFLinkBase.resetDstEndPoint();
        pSWFLinkBase.resetDynaModelFlag();
        pSWFLinkBase.resetEnable();
        pSWFLinkBase.resetEnableMobile();
        pSWFLinkBase.resetFormCodeName();
        pSWFLinkBase.resetFromPSWFProcId();
        pSWFLinkBase.resetFromPSWFProcName();
        pSWFLinkBase.resetLabel();
        pSWFLinkBase.resetLNPSLanResId();
        pSWFLinkBase.resetLNPSLanResName();
        pSWFLinkBase.resetLogicName();
        pSWFLinkBase.resetMemo();
        pSWFLinkBase.resetMemoField();
        pSWFLinkBase.resetMobFormCodeName();
        pSWFLinkBase.resetMobPSDEFormId();
        pSWFLinkBase.resetMobPSDEFormName();
        pSWFLinkBase.resetMobPSDEViewId();
        pSWFLinkBase.resetMobPSDEViewName();
        pSWFLinkBase.resetMobViewCodeName();
        pSWFLinkBase.resetModelId();
        pSWFLinkBase.resetNextCond();
        pSWFLinkBase.resetOrderValue();
        pSWFLinkBase.resetPSDEFormId();
        pSWFLinkBase.resetPSDEFormName();
        pSWFLinkBase.resetPSDEId();
        pSWFLinkBase.resetPSDEViewBaseId();
        pSWFLinkBase.resetPSDEViewBaseName();
        pSWFLinkBase.resetPSDynaInstId();
        pSWFLinkBase.resetPSSystemId();
        pSWFLinkBase.resetPSWFDEId();
        pSWFLinkBase.resetPSWFId();
        pSWFLinkBase.resetPSWFLinkId();
        pSWFLinkBase.resetPSWFLinkName();
        pSWFLinkBase.resetPSWFName();
        pSWFLinkBase.resetPSWFRoleId();
        pSWFLinkBase.resetPSWFRoleName();
        pSWFLinkBase.resetPSWFVersionId();
        pSWFLinkBase.resetPSWFVersionName();
        pSWFLinkBase.resetShapeParams();
        pSWFLinkBase.resetSomeRoleFlag();
        pSWFLinkBase.resetSrcEndPoint();
        pSWFLinkBase.resetThreadFlag();
        pSWFLinkBase.resetThreadName();
        pSWFLinkBase.resetTipPSLanResId();
        pSWFLinkBase.resetTipPSLanResName();
        pSWFLinkBase.resetToPSWFProcId();
        pSWFLinkBase.resetToPSWFProcName();
        pSWFLinkBase.resetUpdateDate();
        pSWFLinkBase.resetUpdateMan();
        pSWFLinkBase.resetUserCat();
        pSWFLinkBase.resetUserData();
        pSWFLinkBase.resetUserData2();
        pSWFLinkBase.resetUserTag();
        pSWFLinkBase.resetUserTag2();
        pSWFLinkBase.resetUserTag3();
        pSWFLinkBase.resetUserTag4();
        pSWFLinkBase.resetViewCodeName();
        pSWFLinkBase.resetWFEngineType();
        pSWFLinkBase.resetWFLinkType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionFieldDirty()) {
            hashMap.put(FIELD_ACTIONFIELD, this.getActionField());
        }
        if (!bl || this.isActionPSCodeListIdDirty()) {
            hashMap.put(FIELD_ACTIONPSCODELISTID, this.getActionPSCodeListId());
        }
        if (!bl || this.isActionPSCodeListNameDirty()) {
            hashMap.put(FIELD_ACTIONPSCODELISTNAME, this.getActionPSCodeListName());
        }
        if (!bl || this.isActorFieldsDirty()) {
            hashMap.put(FIELD_ACTORFIELDS, this.getActorFields());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCondModelDirty()) {
            hashMap.put(FIELD_CONDMODEL, this.getCondModel());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomCondFlagDirty()) {
            hashMap.put(FIELD_CUSTOMCONDFLAG, this.getCustomCondFlag());
        }
        if (!bl || this.isDefaultLinkDirty()) {
            hashMap.put(FIELD_DEFAULTLINK, this.getDefaultLink());
        }
        if (!bl || this.isDstEndPointDirty()) {
            hashMap.put(FIELD_DSTENDPOINT, this.getDstEndPoint());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isEnableMobileDirty()) {
            hashMap.put(FIELD_ENABLEMOBILE, this.getEnableMobile());
        }
        if (!bl || this.isFormCodeNameDirty()) {
            hashMap.put(FIELD_FORMCODENAME, this.getFormCodeName());
        }
        if (!bl || this.isFromPSWFProcIdDirty()) {
            hashMap.put(FIELD_FROMPSWFPROCID, this.getFromPSWFProcId());
        }
        if (!bl || this.isFromPSWFProcNameDirty()) {
            hashMap.put(FIELD_FROMPSWFPROCNAME, this.getFromPSWFProcName());
        }
        if (!bl || this.isLabelDirty()) {
            hashMap.put(FIELD_LABEL, this.getLabel());
        }
        if (!bl || this.isLNPSLanResIdDirty()) {
            hashMap.put(FIELD_LNPSLANRESID, this.getLNPSLanResId());
        }
        if (!bl || this.isLNPSLanResNameDirty()) {
            hashMap.put(FIELD_LNPSLANRESNAME, this.getLNPSLanResName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMemoFieldDirty()) {
            hashMap.put(FIELD_MEMOFIELD, this.getMemoField());
        }
        if (!bl || this.isMobFormCodeNameDirty()) {
            hashMap.put(FIELD_MOBFORMCODENAME, this.getMobFormCodeName());
        }
        if (!bl || this.isMobPSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBPSDEFORMID, this.getMobPSDEFormId());
        }
        if (!bl || this.isMobPSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBPSDEFORMNAME, this.getMobPSDEFormName());
        }
        if (!bl || this.isMobPSDEViewIdDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWID, this.getMobPSDEViewId());
        }
        if (!bl || this.isMobPSDEViewNameDirty()) {
            hashMap.put(FIELD_MOBPSDEVIEWNAME, this.getMobPSDEViewName());
        }
        if (!bl || this.isMobViewCodeNameDirty()) {
            hashMap.put(FIELD_MOBVIEWCODENAME, this.getMobViewCodeName());
        }
        if (!bl || this.isModelIdDirty()) {
            hashMap.put(FIELD_MODELID, this.getModelId());
        }
        if (!bl || this.isNextCondDirty()) {
            hashMap.put(FIELD_NEXTCOND, this.getNextCond());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSWFDEIdDirty()) {
            hashMap.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bl || this.isPSWFIdDirty()) {
            hashMap.put(FIELD_PSWFID, this.getPSWFId());
        }
        if (!bl || this.isPSWFLinkIdDirty()) {
            hashMap.put(FIELD_PSWFLINKID, this.getPSWFLinkId());
        }
        if (!bl || this.isPSWFLinkNameDirty()) {
            hashMap.put(FIELD_PSWFLINKNAME, this.getPSWFLinkName());
        }
        if (!bl || this.isPSWFNameDirty()) {
            hashMap.put(FIELD_PSWFNAME, this.getPSWFName());
        }
        if (!bl || this.isPSWFRoleIdDirty()) {
            hashMap.put(FIELD_PSWFROLEID, this.getPSWFRoleId());
        }
        if (!bl || this.isPSWFRoleNameDirty()) {
            hashMap.put(FIELD_PSWFROLENAME, this.getPSWFRoleName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isShapeParamsDirty()) {
            hashMap.put(FIELD_SHAPEPARAMS, this.getShapeParams());
        }
        if (!bl || this.isSomeRoleFlagDirty()) {
            hashMap.put(FIELD_SOMEROLEFLAG, this.getSomeRoleFlag());
        }
        if (!bl || this.isSrcEndPointDirty()) {
            hashMap.put(FIELD_SRCENDPOINT, this.getSrcEndPoint());
        }
        if (!bl || this.isThreadFlagDirty()) {
            hashMap.put(FIELD_THREADFLAG, this.getThreadFlag());
        }
        if (!bl || this.isThreadNameDirty()) {
            hashMap.put(FIELD_THREADNAME, this.getThreadName());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isToPSWFProcIdDirty()) {
            hashMap.put(FIELD_TOPSWFPROCID, this.getToPSWFProcId());
        }
        if (!bl || this.isToPSWFProcNameDirty()) {
            hashMap.put(FIELD_TOPSWFPROCNAME, this.getToPSWFProcName());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        if (!bl || this.isViewCodeNameDirty()) {
            hashMap.put(FIELD_VIEWCODENAME, this.getViewCodeName());
        }
        if (!bl || this.isWFEngineTypeDirty()) {
            hashMap.put(FIELD_WFENGINETYPE, this.getWFEngineType());
        }
        if (!bl || this.isWFLinkTypeDirty()) {
            hashMap.put(FIELD_WFLINKTYPE, this.getWFLinkType());
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
        return PSWFLinkBase.get(this, n);
    }

    private static Object get(PSWFLinkBase pSWFLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkBase.getActionField();
            }
            case 1: {
                return pSWFLinkBase.getActionPSCodeListId();
            }
            case 2: {
                return pSWFLinkBase.getActionPSCodeListName();
            }
            case 3: {
                return pSWFLinkBase.getActorFields();
            }
            case 4: {
                return pSWFLinkBase.getCodeName();
            }
            case 5: {
                return pSWFLinkBase.getCondModel();
            }
            case 6: {
                return pSWFLinkBase.getCreateDate();
            }
            case 7: {
                return pSWFLinkBase.getCreateMan();
            }
            case 8: {
                return pSWFLinkBase.getCustomCond();
            }
            case 9: {
                return pSWFLinkBase.getCustomCondFlag();
            }
            case 10: {
                return pSWFLinkBase.getDefaultLink();
            }
            case 11: {
                return pSWFLinkBase.getDstEndPoint();
            }
            case 12: {
                return pSWFLinkBase.getDynaModelFlag();
            }
            case 13: {
                return pSWFLinkBase.getEnable();
            }
            case 14: {
                return pSWFLinkBase.getEnableMobile();
            }
            case 15: {
                return pSWFLinkBase.getFormCodeName();
            }
            case 16: {
                return pSWFLinkBase.getFromPSWFProcId();
            }
            case 17: {
                return pSWFLinkBase.getFromPSWFProcName();
            }
            case 18: {
                return pSWFLinkBase.getLabel();
            }
            case 19: {
                return pSWFLinkBase.getLNPSLanResId();
            }
            case 20: {
                return pSWFLinkBase.getLNPSLanResName();
            }
            case 21: {
                return pSWFLinkBase.getLogicName();
            }
            case 22: {
                return pSWFLinkBase.getMemo();
            }
            case 23: {
                return pSWFLinkBase.getMemoField();
            }
            case 24: {
                return pSWFLinkBase.getMobFormCodeName();
            }
            case 25: {
                return pSWFLinkBase.getMobPSDEFormId();
            }
            case 26: {
                return pSWFLinkBase.getMobPSDEFormName();
            }
            case 27: {
                return pSWFLinkBase.getMobPSDEViewId();
            }
            case 28: {
                return pSWFLinkBase.getMobPSDEViewName();
            }
            case 29: {
                return pSWFLinkBase.getMobViewCodeName();
            }
            case 30: {
                return pSWFLinkBase.getModelId();
            }
            case 31: {
                return pSWFLinkBase.getNextCond();
            }
            case 32: {
                return pSWFLinkBase.getOrderValue();
            }
            case 33: {
                return pSWFLinkBase.getPSDEFormId();
            }
            case 34: {
                return pSWFLinkBase.getPSDEFormName();
            }
            case 35: {
                return pSWFLinkBase.getPSDEId();
            }
            case 36: {
                return pSWFLinkBase.getPSDEViewBaseId();
            }
            case 37: {
                return pSWFLinkBase.getPSDEViewBaseName();
            }
            case 38: {
                return pSWFLinkBase.getPSDynaInstId();
            }
            case 39: {
                return pSWFLinkBase.getPSSystemId();
            }
            case 40: {
                return pSWFLinkBase.getPSWFDEId();
            }
            case 41: {
                return pSWFLinkBase.getPSWFId();
            }
            case 42: {
                return pSWFLinkBase.getPSWFLinkId();
            }
            case 43: {
                return pSWFLinkBase.getPSWFLinkName();
            }
            case 44: {
                return pSWFLinkBase.getPSWFName();
            }
            case 45: {
                return pSWFLinkBase.getPSWFRoleId();
            }
            case 46: {
                return pSWFLinkBase.getPSWFRoleName();
            }
            case 47: {
                return pSWFLinkBase.getPSWFVersionId();
            }
            case 48: {
                return pSWFLinkBase.getPSWFVersionName();
            }
            case 49: {
                return pSWFLinkBase.getShapeParams();
            }
            case 50: {
                return pSWFLinkBase.getSomeRoleFlag();
            }
            case 51: {
                return pSWFLinkBase.getSrcEndPoint();
            }
            case 52: {
                return pSWFLinkBase.getThreadFlag();
            }
            case 53: {
                return pSWFLinkBase.getThreadName();
            }
            case 54: {
                return pSWFLinkBase.getTipPSLanResId();
            }
            case 55: {
                return pSWFLinkBase.getTipPSLanResName();
            }
            case 56: {
                return pSWFLinkBase.getToPSWFProcId();
            }
            case 57: {
                return pSWFLinkBase.getToPSWFProcName();
            }
            case 58: {
                return pSWFLinkBase.getUpdateDate();
            }
            case 59: {
                return pSWFLinkBase.getUpdateMan();
            }
            case 60: {
                return pSWFLinkBase.getUserCat();
            }
            case 61: {
                return pSWFLinkBase.getUserData();
            }
            case 62: {
                return pSWFLinkBase.getUserData2();
            }
            case 63: {
                return pSWFLinkBase.getUserTag();
            }
            case 64: {
                return pSWFLinkBase.getUserTag2();
            }
            case 65: {
                return pSWFLinkBase.getUserTag3();
            }
            case 66: {
                return pSWFLinkBase.getUserTag4();
            }
            case 67: {
                return pSWFLinkBase.getViewCodeName();
            }
            case 68: {
                return pSWFLinkBase.getWFEngineType();
            }
            case 69: {
                return pSWFLinkBase.getWFLinkType();
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
        PSWFLinkBase.set(this, n, object);
    }

    private static void set(PSWFLinkBase pSWFLinkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkBase.setActionField(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFLinkBase.setActionPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFLinkBase.setActionPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFLinkBase.setActorFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFLinkBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFLinkBase.setCondModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFLinkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSWFLinkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFLinkBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFLinkBase.setCustomCondFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSWFLinkBase.setDefaultLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSWFLinkBase.setDstEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFLinkBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSWFLinkBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSWFLinkBase.setEnableMobile(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSWFLinkBase.setFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFLinkBase.setFromPSWFProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFLinkBase.setFromPSWFProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFLinkBase.setLabel(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFLinkBase.setLNPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFLinkBase.setLNPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFLinkBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFLinkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFLinkBase.setMemoField(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFLinkBase.setMobFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWFLinkBase.setMobPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWFLinkBase.setMobPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWFLinkBase.setMobPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWFLinkBase.setMobPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWFLinkBase.setMobViewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSWFLinkBase.setModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSWFLinkBase.setNextCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSWFLinkBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSWFLinkBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSWFLinkBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSWFLinkBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSWFLinkBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSWFLinkBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSWFLinkBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSWFLinkBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSWFLinkBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSWFLinkBase.setPSWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSWFLinkBase.setPSWFLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSWFLinkBase.setPSWFLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSWFLinkBase.setPSWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSWFLinkBase.setPSWFRoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSWFLinkBase.setPSWFRoleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSWFLinkBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSWFLinkBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSWFLinkBase.setShapeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSWFLinkBase.setSomeRoleFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSWFLinkBase.setSrcEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSWFLinkBase.setThreadFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSWFLinkBase.setThreadName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSWFLinkBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSWFLinkBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSWFLinkBase.setToPSWFProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSWFLinkBase.setToPSWFProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSWFLinkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 59: {
                pSWFLinkBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSWFLinkBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSWFLinkBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSWFLinkBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSWFLinkBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSWFLinkBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSWFLinkBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSWFLinkBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSWFLinkBase.setViewCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSWFLinkBase.setWFEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSWFLinkBase.setWFLinkType(DataObject.getStringValue((Object)object));
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
        return PSWFLinkBase.isNull(this, n);
    }

    private static boolean isNull(PSWFLinkBase pSWFLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkBase.getActionField() == null;
            }
            case 1: {
                return pSWFLinkBase.getActionPSCodeListId() == null;
            }
            case 2: {
                return pSWFLinkBase.getActionPSCodeListName() == null;
            }
            case 3: {
                return pSWFLinkBase.getActorFields() == null;
            }
            case 4: {
                return pSWFLinkBase.getCodeName() == null;
            }
            case 5: {
                return pSWFLinkBase.getCondModel() == null;
            }
            case 6: {
                return pSWFLinkBase.getCreateDate() == null;
            }
            case 7: {
                return pSWFLinkBase.getCreateMan() == null;
            }
            case 8: {
                return pSWFLinkBase.getCustomCond() == null;
            }
            case 9: {
                return pSWFLinkBase.getCustomCondFlag() == null;
            }
            case 10: {
                return pSWFLinkBase.getDefaultLink() == null;
            }
            case 11: {
                return pSWFLinkBase.getDstEndPoint() == null;
            }
            case 12: {
                return pSWFLinkBase.getDynaModelFlag() == null;
            }
            case 13: {
                return pSWFLinkBase.getEnable() == null;
            }
            case 14: {
                return pSWFLinkBase.getEnableMobile() == null;
            }
            case 15: {
                return pSWFLinkBase.getFormCodeName() == null;
            }
            case 16: {
                return pSWFLinkBase.getFromPSWFProcId() == null;
            }
            case 17: {
                return pSWFLinkBase.getFromPSWFProcName() == null;
            }
            case 18: {
                return pSWFLinkBase.getLabel() == null;
            }
            case 19: {
                return pSWFLinkBase.getLNPSLanResId() == null;
            }
            case 20: {
                return pSWFLinkBase.getLNPSLanResName() == null;
            }
            case 21: {
                return pSWFLinkBase.getLogicName() == null;
            }
            case 22: {
                return pSWFLinkBase.getMemo() == null;
            }
            case 23: {
                return pSWFLinkBase.getMemoField() == null;
            }
            case 24: {
                return pSWFLinkBase.getMobFormCodeName() == null;
            }
            case 25: {
                return pSWFLinkBase.getMobPSDEFormId() == null;
            }
            case 26: {
                return pSWFLinkBase.getMobPSDEFormName() == null;
            }
            case 27: {
                return pSWFLinkBase.getMobPSDEViewId() == null;
            }
            case 28: {
                return pSWFLinkBase.getMobPSDEViewName() == null;
            }
            case 29: {
                return pSWFLinkBase.getMobViewCodeName() == null;
            }
            case 30: {
                return pSWFLinkBase.getModelId() == null;
            }
            case 31: {
                return pSWFLinkBase.getNextCond() == null;
            }
            case 32: {
                return pSWFLinkBase.getOrderValue() == null;
            }
            case 33: {
                return pSWFLinkBase.getPSDEFormId() == null;
            }
            case 34: {
                return pSWFLinkBase.getPSDEFormName() == null;
            }
            case 35: {
                return pSWFLinkBase.getPSDEId() == null;
            }
            case 36: {
                return pSWFLinkBase.getPSDEViewBaseId() == null;
            }
            case 37: {
                return pSWFLinkBase.getPSDEViewBaseName() == null;
            }
            case 38: {
                return pSWFLinkBase.getPSDynaInstId() == null;
            }
            case 39: {
                return pSWFLinkBase.getPSSystemId() == null;
            }
            case 40: {
                return pSWFLinkBase.getPSWFDEId() == null;
            }
            case 41: {
                return pSWFLinkBase.getPSWFId() == null;
            }
            case 42: {
                return pSWFLinkBase.getPSWFLinkId() == null;
            }
            case 43: {
                return pSWFLinkBase.getPSWFLinkName() == null;
            }
            case 44: {
                return pSWFLinkBase.getPSWFName() == null;
            }
            case 45: {
                return pSWFLinkBase.getPSWFRoleId() == null;
            }
            case 46: {
                return pSWFLinkBase.getPSWFRoleName() == null;
            }
            case 47: {
                return pSWFLinkBase.getPSWFVersionId() == null;
            }
            case 48: {
                return pSWFLinkBase.getPSWFVersionName() == null;
            }
            case 49: {
                return pSWFLinkBase.getShapeParams() == null;
            }
            case 50: {
                return pSWFLinkBase.getSomeRoleFlag() == null;
            }
            case 51: {
                return pSWFLinkBase.getSrcEndPoint() == null;
            }
            case 52: {
                return pSWFLinkBase.getThreadFlag() == null;
            }
            case 53: {
                return pSWFLinkBase.getThreadName() == null;
            }
            case 54: {
                return pSWFLinkBase.getTipPSLanResId() == null;
            }
            case 55: {
                return pSWFLinkBase.getTipPSLanResName() == null;
            }
            case 56: {
                return pSWFLinkBase.getToPSWFProcId() == null;
            }
            case 57: {
                return pSWFLinkBase.getToPSWFProcName() == null;
            }
            case 58: {
                return pSWFLinkBase.getUpdateDate() == null;
            }
            case 59: {
                return pSWFLinkBase.getUpdateMan() == null;
            }
            case 60: {
                return pSWFLinkBase.getUserCat() == null;
            }
            case 61: {
                return pSWFLinkBase.getUserData() == null;
            }
            case 62: {
                return pSWFLinkBase.getUserData2() == null;
            }
            case 63: {
                return pSWFLinkBase.getUserTag() == null;
            }
            case 64: {
                return pSWFLinkBase.getUserTag2() == null;
            }
            case 65: {
                return pSWFLinkBase.getUserTag3() == null;
            }
            case 66: {
                return pSWFLinkBase.getUserTag4() == null;
            }
            case 67: {
                return pSWFLinkBase.getViewCodeName() == null;
            }
            case 68: {
                return pSWFLinkBase.getWFEngineType() == null;
            }
            case 69: {
                return pSWFLinkBase.getWFLinkType() == null;
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
        return PSWFLinkBase.contains(this, n);
    }

    private static boolean contains(PSWFLinkBase pSWFLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkBase.isActionFieldDirty();
            }
            case 1: {
                return pSWFLinkBase.isActionPSCodeListIdDirty();
            }
            case 2: {
                return pSWFLinkBase.isActionPSCodeListNameDirty();
            }
            case 3: {
                return pSWFLinkBase.isActorFieldsDirty();
            }
            case 4: {
                return pSWFLinkBase.isCodeNameDirty();
            }
            case 5: {
                return pSWFLinkBase.isCondModelDirty();
            }
            case 6: {
                return pSWFLinkBase.isCreateDateDirty();
            }
            case 7: {
                return pSWFLinkBase.isCreateManDirty();
            }
            case 8: {
                return pSWFLinkBase.isCustomCondDirty();
            }
            case 9: {
                return pSWFLinkBase.isCustomCondFlagDirty();
            }
            case 10: {
                return pSWFLinkBase.isDefaultLinkDirty();
            }
            case 11: {
                return pSWFLinkBase.isDstEndPointDirty();
            }
            case 12: {
                return pSWFLinkBase.isDynaModelFlagDirty();
            }
            case 13: {
                return pSWFLinkBase.isEnableDirty();
            }
            case 14: {
                return pSWFLinkBase.isEnableMobileDirty();
            }
            case 15: {
                return pSWFLinkBase.isFormCodeNameDirty();
            }
            case 16: {
                return pSWFLinkBase.isFromPSWFProcIdDirty();
            }
            case 17: {
                return pSWFLinkBase.isFromPSWFProcNameDirty();
            }
            case 18: {
                return pSWFLinkBase.isLabelDirty();
            }
            case 19: {
                return pSWFLinkBase.isLNPSLanResIdDirty();
            }
            case 20: {
                return pSWFLinkBase.isLNPSLanResNameDirty();
            }
            case 21: {
                return pSWFLinkBase.isLogicNameDirty();
            }
            case 22: {
                return pSWFLinkBase.isMemoDirty();
            }
            case 23: {
                return pSWFLinkBase.isMemoFieldDirty();
            }
            case 24: {
                return pSWFLinkBase.isMobFormCodeNameDirty();
            }
            case 25: {
                return pSWFLinkBase.isMobPSDEFormIdDirty();
            }
            case 26: {
                return pSWFLinkBase.isMobPSDEFormNameDirty();
            }
            case 27: {
                return pSWFLinkBase.isMobPSDEViewIdDirty();
            }
            case 28: {
                return pSWFLinkBase.isMobPSDEViewNameDirty();
            }
            case 29: {
                return pSWFLinkBase.isMobViewCodeNameDirty();
            }
            case 30: {
                return pSWFLinkBase.isModelIdDirty();
            }
            case 31: {
                return pSWFLinkBase.isNextCondDirty();
            }
            case 32: {
                return pSWFLinkBase.isOrderValueDirty();
            }
            case 33: {
                return pSWFLinkBase.isPSDEFormIdDirty();
            }
            case 34: {
                return pSWFLinkBase.isPSDEFormNameDirty();
            }
            case 35: {
                return pSWFLinkBase.isPSDEIdDirty();
            }
            case 36: {
                return pSWFLinkBase.isPSDEViewBaseIdDirty();
            }
            case 37: {
                return pSWFLinkBase.isPSDEViewBaseNameDirty();
            }
            case 38: {
                return pSWFLinkBase.isPSDynaInstIdDirty();
            }
            case 39: {
                return pSWFLinkBase.isPSSystemIdDirty();
            }
            case 40: {
                return pSWFLinkBase.isPSWFDEIdDirty();
            }
            case 41: {
                return pSWFLinkBase.isPSWFIdDirty();
            }
            case 42: {
                return pSWFLinkBase.isPSWFLinkIdDirty();
            }
            case 43: {
                return pSWFLinkBase.isPSWFLinkNameDirty();
            }
            case 44: {
                return pSWFLinkBase.isPSWFNameDirty();
            }
            case 45: {
                return pSWFLinkBase.isPSWFRoleIdDirty();
            }
            case 46: {
                return pSWFLinkBase.isPSWFRoleNameDirty();
            }
            case 47: {
                return pSWFLinkBase.isPSWFVersionIdDirty();
            }
            case 48: {
                return pSWFLinkBase.isPSWFVersionNameDirty();
            }
            case 49: {
                return pSWFLinkBase.isShapeParamsDirty();
            }
            case 50: {
                return pSWFLinkBase.isSomeRoleFlagDirty();
            }
            case 51: {
                return pSWFLinkBase.isSrcEndPointDirty();
            }
            case 52: {
                return pSWFLinkBase.isThreadFlagDirty();
            }
            case 53: {
                return pSWFLinkBase.isThreadNameDirty();
            }
            case 54: {
                return pSWFLinkBase.isTipPSLanResIdDirty();
            }
            case 55: {
                return pSWFLinkBase.isTipPSLanResNameDirty();
            }
            case 56: {
                return pSWFLinkBase.isToPSWFProcIdDirty();
            }
            case 57: {
                return pSWFLinkBase.isToPSWFProcNameDirty();
            }
            case 58: {
                return pSWFLinkBase.isUpdateDateDirty();
            }
            case 59: {
                return pSWFLinkBase.isUpdateManDirty();
            }
            case 60: {
                return pSWFLinkBase.isUserCatDirty();
            }
            case 61: {
                return pSWFLinkBase.isUserDataDirty();
            }
            case 62: {
                return pSWFLinkBase.isUserData2Dirty();
            }
            case 63: {
                return pSWFLinkBase.isUserTagDirty();
            }
            case 64: {
                return pSWFLinkBase.isUserTag2Dirty();
            }
            case 65: {
                return pSWFLinkBase.isUserTag3Dirty();
            }
            case 66: {
                return pSWFLinkBase.isUserTag4Dirty();
            }
            case 67: {
                return pSWFLinkBase.isViewCodeNameDirty();
            }
            case 68: {
                return pSWFLinkBase.isWFEngineTypeDirty();
            }
            case 69: {
                return pSWFLinkBase.isWFLinkTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFLinkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFLinkBase pSWFLinkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFLinkBase.getActionField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionfield", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getActionField()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getActionPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionpscodelistid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getActionPSCodeListId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getActionPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionpscodelistname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getActionPSCodeListName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getActorFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actorfields", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getActorFields()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getCondModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodel", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getCondModel()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getCustomCondFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcondflag", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getCustomCondFlag()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getDefaultLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultlink", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getDefaultLink()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getDstEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstendpoint", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getDstEndPoint()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getEnable()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getEnableMobile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemobile", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getEnableMobile()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formcodename", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getFormCodeName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getFromPSWFProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompswfprocid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getFromPSWFProcId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getFromPSWFProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompswfprocname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getFromPSWFProcName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getLabel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"label", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getLabel()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getLNPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getLNPSLanResId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getLNPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lnpslanresname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getLNPSLanResName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getLogicName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMemoField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memofield", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMemoField()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMobFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobformcodename", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMobFormCodeName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMobPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMobPSDEFormId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMobPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMobPSDEFormName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMobPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMobPSDEViewId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMobPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeviewname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMobPSDEViewName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getMobViewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobviewcodename", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getMobViewCodeName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getModelId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getNextCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextcond", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getNextCond()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFLinkId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFLinkName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFRoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfroleid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFRoleId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFRoleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfrolename", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFRoleName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getShapeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeparams", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getShapeParams()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getSomeRoleFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"someroleflag", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getSomeRoleFlag()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getSrcEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcendpoint", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getSrcEndPoint()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getThreadFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadflag", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getThreadFlag()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getThreadName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getThreadName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getToPSWFProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topswfprocid", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getToPSWFProcId()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getToPSWFProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topswfprocname", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getToPSWFProcName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUserData()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUserData2()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getViewCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcodename", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getViewCodeName()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getWFEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfenginetype", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getWFEngineType()), (boolean)false);
        }
        if (bl || pSWFLinkBase.getWFLinkType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wflinktype", (Object)PSWFLinkBase.getJSONValue((Object)pSWFLinkBase.getWFLinkType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFLinkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFLinkBase pSWFLinkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFLinkBase.getActionField() != null) {
            object = pSWFLinkBase.getActionField();
            xmlNode.setAttribute(FIELD_ACTIONFIELD, (String)(object == null ? "" : object));
        }
        if (bl || pSWFLinkBase.getActionPSCodeListId() != null) {
            object = pSWFLinkBase.getActionPSCodeListId();
            xmlNode.setAttribute(FIELD_ACTIONPSCODELISTID, (String)(object == null ? "" : object));
        }
        if (bl || pSWFLinkBase.getActionPSCodeListName() != null) {
            object = pSWFLinkBase.getActionPSCodeListName();
            xmlNode.setAttribute(FIELD_ACTIONPSCODELISTNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSWFLinkBase.getActorFields() != null) {
            object = pSWFLinkBase.getActorFields();
            xmlNode.setAttribute(FIELD_ACTORFIELDS, (String)(object == null ? "" : object));
        }
        if (bl || pSWFLinkBase.getCodeName() != null) {
            object = pSWFLinkBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSWFLinkBase.getCondModel() != null) {
            object = pSWFLinkBase.getCondModel();
            xmlNode.setAttribute(FIELD_CONDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getCreateDate() != null) {
            object = pSWFLinkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkBase.getCreateMan() != null) {
            object = pSWFLinkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getCustomCond() != null) {
            object = pSWFLinkBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getCustomCondFlag() != null) {
            object = pSWFLinkBase.getCustomCondFlag();
            xmlNode.setAttribute(FIELD_CUSTOMCONDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getDefaultLink() != null) {
            object = pSWFLinkBase.getDefaultLink();
            xmlNode.setAttribute(FIELD_DEFAULTLINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getDstEndPoint() != null) {
            object = pSWFLinkBase.getDstEndPoint();
            xmlNode.setAttribute(FIELD_DSTENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getDynaModelFlag() != null) {
            object = pSWFLinkBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getEnable() != null) {
            object = pSWFLinkBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getEnableMobile() != null) {
            object = pSWFLinkBase.getEnableMobile();
            xmlNode.setAttribute(FIELD_ENABLEMOBILE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getFormCodeName() != null) {
            object = pSWFLinkBase.getFormCodeName();
            xmlNode.setAttribute(FIELD_FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getFromPSWFProcId() != null) {
            object = pSWFLinkBase.getFromPSWFProcId();
            xmlNode.setAttribute(FIELD_FROMPSWFPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getFromPSWFProcName() != null) {
            object = pSWFLinkBase.getFromPSWFProcName();
            xmlNode.setAttribute(FIELD_FROMPSWFPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getLabel() != null) {
            object = pSWFLinkBase.getLabel();
            xmlNode.setAttribute(FIELD_LABEL, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getLNPSLanResId() != null) {
            object = pSWFLinkBase.getLNPSLanResId();
            xmlNode.setAttribute(FIELD_LNPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getLNPSLanResName() != null) {
            object = pSWFLinkBase.getLNPSLanResName();
            xmlNode.setAttribute(FIELD_LNPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getLogicName() != null) {
            object = pSWFLinkBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMemo() != null) {
            object = pSWFLinkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMemoField() != null) {
            object = pSWFLinkBase.getMemoField();
            xmlNode.setAttribute(FIELD_MEMOFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMobFormCodeName() != null) {
            object = pSWFLinkBase.getMobFormCodeName();
            xmlNode.setAttribute(FIELD_MOBFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMobPSDEFormId() != null) {
            object = pSWFLinkBase.getMobPSDEFormId();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMobPSDEFormName() != null) {
            object = pSWFLinkBase.getMobPSDEFormName();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMobPSDEViewId() != null) {
            object = pSWFLinkBase.getMobPSDEViewId();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMobPSDEViewName() != null) {
            object = pSWFLinkBase.getMobPSDEViewName();
            xmlNode.setAttribute(FIELD_MOBPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getMobViewCodeName() != null) {
            object = pSWFLinkBase.getMobViewCodeName();
            xmlNode.setAttribute(FIELD_MOBVIEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getModelId() != null) {
            object = pSWFLinkBase.getModelId();
            xmlNode.setAttribute(FIELD_MODELID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getNextCond() != null) {
            object = pSWFLinkBase.getNextCond();
            xmlNode.setAttribute(FIELD_NEXTCOND, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getOrderValue() != null) {
            object = pSWFLinkBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getPSDEFormId() != null) {
            object = pSWFLinkBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSDEFormName() != null) {
            object = pSWFLinkBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSDEId() != null) {
            object = pSWFLinkBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSDEViewBaseId() != null) {
            object = pSWFLinkBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSDEViewBaseName() != null) {
            object = pSWFLinkBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSDynaInstId() != null) {
            object = pSWFLinkBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSSystemId() != null) {
            object = pSWFLinkBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFDEId() != null) {
            object = pSWFLinkBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFId() != null) {
            object = pSWFLinkBase.getPSWFId();
            xmlNode.setAttribute(FIELD_PSWFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFLinkId() != null) {
            object = pSWFLinkBase.getPSWFLinkId();
            xmlNode.setAttribute(FIELD_PSWFLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFLinkName() != null) {
            object = pSWFLinkBase.getPSWFLinkName();
            xmlNode.setAttribute(FIELD_PSWFLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFName() != null) {
            object = pSWFLinkBase.getPSWFName();
            xmlNode.setAttribute(FIELD_PSWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFRoleId() != null) {
            object = pSWFLinkBase.getPSWFRoleId();
            xmlNode.setAttribute(FIELD_PSWFROLEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFRoleName() != null) {
            object = pSWFLinkBase.getPSWFRoleName();
            xmlNode.setAttribute(FIELD_PSWFROLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFVersionId() != null) {
            object = pSWFLinkBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getPSWFVersionName() != null) {
            object = pSWFLinkBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getShapeParams() != null) {
            object = pSWFLinkBase.getShapeParams();
            xmlNode.setAttribute(FIELD_SHAPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getSomeRoleFlag() != null) {
            object = pSWFLinkBase.getSomeRoleFlag();
            xmlNode.setAttribute(FIELD_SOMEROLEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getSrcEndPoint() != null) {
            object = pSWFLinkBase.getSrcEndPoint();
            xmlNode.setAttribute(FIELD_SRCENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getThreadFlag() != null) {
            object = pSWFLinkBase.getThreadFlag();
            xmlNode.setAttribute(FIELD_THREADFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkBase.getThreadName() != null) {
            object = pSWFLinkBase.getThreadName();
            xmlNode.setAttribute(FIELD_THREADNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getTipPSLanResId() != null) {
            object = pSWFLinkBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getTipPSLanResName() != null) {
            object = pSWFLinkBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getToPSWFProcId() != null) {
            object = pSWFLinkBase.getToPSWFProcId();
            xmlNode.setAttribute(FIELD_TOPSWFPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getToPSWFProcName() != null) {
            object = pSWFLinkBase.getToPSWFProcName();
            xmlNode.setAttribute(FIELD_TOPSWFPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUpdateDate() != null) {
            object = pSWFLinkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkBase.getUpdateMan() != null) {
            object = pSWFLinkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUserCat() != null) {
            object = pSWFLinkBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUserData() != null) {
            object = pSWFLinkBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUserData2() != null) {
            object = pSWFLinkBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUserTag() != null) {
            object = pSWFLinkBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUserTag2() != null) {
            object = pSWFLinkBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUserTag3() != null) {
            object = pSWFLinkBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getUserTag4() != null) {
            object = pSWFLinkBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getViewCodeName() != null) {
            object = pSWFLinkBase.getViewCodeName();
            xmlNode.setAttribute(FIELD_VIEWCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getWFEngineType() != null) {
            object = pSWFLinkBase.getWFEngineType();
            xmlNode.setAttribute(FIELD_WFENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkBase.getWFLinkType() != null) {
            object = pSWFLinkBase.getWFLinkType();
            xmlNode.setAttribute(FIELD_WFLINKTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFLinkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFLinkBase pSWFLinkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFLinkBase.isActionFieldDirty() && (bl || pSWFLinkBase.getActionField() != null)) {
            iDataObject.set(FIELD_ACTIONFIELD, (Object)pSWFLinkBase.getActionField());
        }
        if (pSWFLinkBase.isActionPSCodeListIdDirty() && (bl || pSWFLinkBase.getActionPSCodeListId() != null)) {
            iDataObject.set(FIELD_ACTIONPSCODELISTID, (Object)pSWFLinkBase.getActionPSCodeListId());
        }
        if (pSWFLinkBase.isActionPSCodeListNameDirty() && (bl || pSWFLinkBase.getActionPSCodeListName() != null)) {
            iDataObject.set(FIELD_ACTIONPSCODELISTNAME, (Object)pSWFLinkBase.getActionPSCodeListName());
        }
        if (pSWFLinkBase.isActorFieldsDirty() && (bl || pSWFLinkBase.getActorFields() != null)) {
            iDataObject.set(FIELD_ACTORFIELDS, (Object)pSWFLinkBase.getActorFields());
        }
        if (pSWFLinkBase.isCodeNameDirty() && (bl || pSWFLinkBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWFLinkBase.getCodeName());
        }
        if (pSWFLinkBase.isCondModelDirty() && (bl || pSWFLinkBase.getCondModel() != null)) {
            iDataObject.set(FIELD_CONDMODEL, (Object)pSWFLinkBase.getCondModel());
        }
        if (pSWFLinkBase.isCreateDateDirty() && (bl || pSWFLinkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFLinkBase.getCreateDate());
        }
        if (pSWFLinkBase.isCreateManDirty() && (bl || pSWFLinkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFLinkBase.getCreateMan());
        }
        if (pSWFLinkBase.isCustomCondDirty() && (bl || pSWFLinkBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSWFLinkBase.getCustomCond());
        }
        if (pSWFLinkBase.isCustomCondFlagDirty() && (bl || pSWFLinkBase.getCustomCondFlag() != null)) {
            iDataObject.set(FIELD_CUSTOMCONDFLAG, (Object)pSWFLinkBase.getCustomCondFlag());
        }
        if (pSWFLinkBase.isDefaultLinkDirty() && (bl || pSWFLinkBase.getDefaultLink() != null)) {
            iDataObject.set(FIELD_DEFAULTLINK, (Object)pSWFLinkBase.getDefaultLink());
        }
        if (pSWFLinkBase.isDstEndPointDirty() && (bl || pSWFLinkBase.getDstEndPoint() != null)) {
            iDataObject.set(FIELD_DSTENDPOINT, (Object)pSWFLinkBase.getDstEndPoint());
        }
        if (pSWFLinkBase.isDynaModelFlagDirty() && (bl || pSWFLinkBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFLinkBase.getDynaModelFlag());
        }
        if (pSWFLinkBase.isEnableDirty() && (bl || pSWFLinkBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWFLinkBase.getEnable());
        }
        if (pSWFLinkBase.isEnableMobileDirty() && (bl || pSWFLinkBase.getEnableMobile() != null)) {
            iDataObject.set(FIELD_ENABLEMOBILE, (Object)pSWFLinkBase.getEnableMobile());
        }
        if (pSWFLinkBase.isFormCodeNameDirty() && (bl || pSWFLinkBase.getFormCodeName() != null)) {
            iDataObject.set(FIELD_FORMCODENAME, (Object)pSWFLinkBase.getFormCodeName());
        }
        if (pSWFLinkBase.isFromPSWFProcIdDirty() && (bl || pSWFLinkBase.getFromPSWFProcId() != null)) {
            iDataObject.set(FIELD_FROMPSWFPROCID, (Object)pSWFLinkBase.getFromPSWFProcId());
        }
        if (pSWFLinkBase.isFromPSWFProcNameDirty() && (bl || pSWFLinkBase.getFromPSWFProcName() != null)) {
            iDataObject.set(FIELD_FROMPSWFPROCNAME, (Object)pSWFLinkBase.getFromPSWFProcName());
        }
        if (pSWFLinkBase.isLabelDirty() && (bl || pSWFLinkBase.getLabel() != null)) {
            iDataObject.set(FIELD_LABEL, (Object)pSWFLinkBase.getLabel());
        }
        if (pSWFLinkBase.isLNPSLanResIdDirty() && (bl || pSWFLinkBase.getLNPSLanResId() != null)) {
            iDataObject.set(FIELD_LNPSLANRESID, (Object)pSWFLinkBase.getLNPSLanResId());
        }
        if (pSWFLinkBase.isLNPSLanResNameDirty() && (bl || pSWFLinkBase.getLNPSLanResName() != null)) {
            iDataObject.set(FIELD_LNPSLANRESNAME, (Object)pSWFLinkBase.getLNPSLanResName());
        }
        if (pSWFLinkBase.isLogicNameDirty() && (bl || pSWFLinkBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSWFLinkBase.getLogicName());
        }
        if (pSWFLinkBase.isMemoDirty() && (bl || pSWFLinkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFLinkBase.getMemo());
        }
        if (pSWFLinkBase.isMemoFieldDirty() && (bl || pSWFLinkBase.getMemoField() != null)) {
            iDataObject.set(FIELD_MEMOFIELD, (Object)pSWFLinkBase.getMemoField());
        }
        if (pSWFLinkBase.isMobFormCodeNameDirty() && (bl || pSWFLinkBase.getMobFormCodeName() != null)) {
            iDataObject.set(FIELD_MOBFORMCODENAME, (Object)pSWFLinkBase.getMobFormCodeName());
        }
        if (pSWFLinkBase.isMobPSDEFormIdDirty() && (bl || pSWFLinkBase.getMobPSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMID, (Object)pSWFLinkBase.getMobPSDEFormId());
        }
        if (pSWFLinkBase.isMobPSDEFormNameDirty() && (bl || pSWFLinkBase.getMobPSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMNAME, (Object)pSWFLinkBase.getMobPSDEFormName());
        }
        if (pSWFLinkBase.isMobPSDEViewIdDirty() && (bl || pSWFLinkBase.getMobPSDEViewId() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWID, (Object)pSWFLinkBase.getMobPSDEViewId());
        }
        if (pSWFLinkBase.isMobPSDEViewNameDirty() && (bl || pSWFLinkBase.getMobPSDEViewName() != null)) {
            iDataObject.set(FIELD_MOBPSDEVIEWNAME, (Object)pSWFLinkBase.getMobPSDEViewName());
        }
        if (pSWFLinkBase.isMobViewCodeNameDirty() && (bl || pSWFLinkBase.getMobViewCodeName() != null)) {
            iDataObject.set(FIELD_MOBVIEWCODENAME, (Object)pSWFLinkBase.getMobViewCodeName());
        }
        if (pSWFLinkBase.isModelIdDirty() && (bl || pSWFLinkBase.getModelId() != null)) {
            iDataObject.set(FIELD_MODELID, (Object)pSWFLinkBase.getModelId());
        }
        if (pSWFLinkBase.isNextCondDirty() && (bl || pSWFLinkBase.getNextCond() != null)) {
            iDataObject.set(FIELD_NEXTCOND, (Object)pSWFLinkBase.getNextCond());
        }
        if (pSWFLinkBase.isOrderValueDirty() && (bl || pSWFLinkBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSWFLinkBase.getOrderValue());
        }
        if (pSWFLinkBase.isPSDEFormIdDirty() && (bl || pSWFLinkBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSWFLinkBase.getPSDEFormId());
        }
        if (pSWFLinkBase.isPSDEFormNameDirty() && (bl || pSWFLinkBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSWFLinkBase.getPSDEFormName());
        }
        if (pSWFLinkBase.isPSDEIdDirty() && (bl || pSWFLinkBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSWFLinkBase.getPSDEId());
        }
        if (pSWFLinkBase.isPSDEViewBaseIdDirty() && (bl || pSWFLinkBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSWFLinkBase.getPSDEViewBaseId());
        }
        if (pSWFLinkBase.isPSDEViewBaseNameDirty() && (bl || pSWFLinkBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSWFLinkBase.getPSDEViewBaseName());
        }
        if (pSWFLinkBase.isPSDynaInstIdDirty() && (bl || pSWFLinkBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFLinkBase.getPSDynaInstId());
        }
        if (pSWFLinkBase.isPSSystemIdDirty() && (bl || pSWFLinkBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFLinkBase.getPSSystemId());
        }
        if (pSWFLinkBase.isPSWFDEIdDirty() && (bl || pSWFLinkBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSWFLinkBase.getPSWFDEId());
        }
        if (pSWFLinkBase.isPSWFIdDirty() && (bl || pSWFLinkBase.getPSWFId() != null)) {
            iDataObject.set(FIELD_PSWFID, (Object)pSWFLinkBase.getPSWFId());
        }
        if (pSWFLinkBase.isPSWFLinkIdDirty() && (bl || pSWFLinkBase.getPSWFLinkId() != null)) {
            iDataObject.set(FIELD_PSWFLINKID, (Object)pSWFLinkBase.getPSWFLinkId());
        }
        if (pSWFLinkBase.isPSWFLinkNameDirty() && (bl || pSWFLinkBase.getPSWFLinkName() != null)) {
            iDataObject.set(FIELD_PSWFLINKNAME, (Object)pSWFLinkBase.getPSWFLinkName());
        }
        if (pSWFLinkBase.isPSWFNameDirty() && (bl || pSWFLinkBase.getPSWFName() != null)) {
            iDataObject.set(FIELD_PSWFNAME, (Object)pSWFLinkBase.getPSWFName());
        }
        if (pSWFLinkBase.isPSWFRoleIdDirty() && (bl || pSWFLinkBase.getPSWFRoleId() != null)) {
            iDataObject.set(FIELD_PSWFROLEID, (Object)pSWFLinkBase.getPSWFRoleId());
        }
        if (pSWFLinkBase.isPSWFRoleNameDirty() && (bl || pSWFLinkBase.getPSWFRoleName() != null)) {
            iDataObject.set(FIELD_PSWFROLENAME, (Object)pSWFLinkBase.getPSWFRoleName());
        }
        if (pSWFLinkBase.isPSWFVersionIdDirty() && (bl || pSWFLinkBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFLinkBase.getPSWFVersionId());
        }
        if (pSWFLinkBase.isPSWFVersionNameDirty() && (bl || pSWFLinkBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSWFLinkBase.getPSWFVersionName());
        }
        if (pSWFLinkBase.isShapeParamsDirty() && (bl || pSWFLinkBase.getShapeParams() != null)) {
            iDataObject.set(FIELD_SHAPEPARAMS, (Object)pSWFLinkBase.getShapeParams());
        }
        if (pSWFLinkBase.isSomeRoleFlagDirty() && (bl || pSWFLinkBase.getSomeRoleFlag() != null)) {
            iDataObject.set(FIELD_SOMEROLEFLAG, (Object)pSWFLinkBase.getSomeRoleFlag());
        }
        if (pSWFLinkBase.isSrcEndPointDirty() && (bl || pSWFLinkBase.getSrcEndPoint() != null)) {
            iDataObject.set(FIELD_SRCENDPOINT, (Object)pSWFLinkBase.getSrcEndPoint());
        }
        if (pSWFLinkBase.isThreadFlagDirty() && (bl || pSWFLinkBase.getThreadFlag() != null)) {
            iDataObject.set(FIELD_THREADFLAG, (Object)pSWFLinkBase.getThreadFlag());
        }
        if (pSWFLinkBase.isThreadNameDirty() && (bl || pSWFLinkBase.getThreadName() != null)) {
            iDataObject.set(FIELD_THREADNAME, (Object)pSWFLinkBase.getThreadName());
        }
        if (pSWFLinkBase.isTipPSLanResIdDirty() && (bl || pSWFLinkBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSWFLinkBase.getTipPSLanResId());
        }
        if (pSWFLinkBase.isTipPSLanResNameDirty() && (bl || pSWFLinkBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSWFLinkBase.getTipPSLanResName());
        }
        if (pSWFLinkBase.isToPSWFProcIdDirty() && (bl || pSWFLinkBase.getToPSWFProcId() != null)) {
            iDataObject.set(FIELD_TOPSWFPROCID, (Object)pSWFLinkBase.getToPSWFProcId());
        }
        if (pSWFLinkBase.isToPSWFProcNameDirty() && (bl || pSWFLinkBase.getToPSWFProcName() != null)) {
            iDataObject.set(FIELD_TOPSWFPROCNAME, (Object)pSWFLinkBase.getToPSWFProcName());
        }
        if (pSWFLinkBase.isUpdateDateDirty() && (bl || pSWFLinkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFLinkBase.getUpdateDate());
        }
        if (pSWFLinkBase.isUpdateManDirty() && (bl || pSWFLinkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFLinkBase.getUpdateMan());
        }
        if (pSWFLinkBase.isUserCatDirty() && (bl || pSWFLinkBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFLinkBase.getUserCat());
        }
        if (pSWFLinkBase.isUserDataDirty() && (bl || pSWFLinkBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSWFLinkBase.getUserData());
        }
        if (pSWFLinkBase.isUserData2Dirty() && (bl || pSWFLinkBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSWFLinkBase.getUserData2());
        }
        if (pSWFLinkBase.isUserTagDirty() && (bl || pSWFLinkBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFLinkBase.getUserTag());
        }
        if (pSWFLinkBase.isUserTag2Dirty() && (bl || pSWFLinkBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFLinkBase.getUserTag2());
        }
        if (pSWFLinkBase.isUserTag3Dirty() && (bl || pSWFLinkBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFLinkBase.getUserTag3());
        }
        if (pSWFLinkBase.isUserTag4Dirty() && (bl || pSWFLinkBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFLinkBase.getUserTag4());
        }
        if (pSWFLinkBase.isViewCodeNameDirty() && (bl || pSWFLinkBase.getViewCodeName() != null)) {
            iDataObject.set(FIELD_VIEWCODENAME, (Object)pSWFLinkBase.getViewCodeName());
        }
        if (pSWFLinkBase.isWFEngineTypeDirty() && (bl || pSWFLinkBase.getWFEngineType() != null)) {
            iDataObject.set(FIELD_WFENGINETYPE, (Object)pSWFLinkBase.getWFEngineType());
        }
        if (pSWFLinkBase.isWFLinkTypeDirty() && (bl || pSWFLinkBase.getWFLinkType() != null)) {
            iDataObject.set(FIELD_WFLINKTYPE, (Object)pSWFLinkBase.getWFLinkType());
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
        return PSWFLinkBase.remove(this, n);
    }

    private static boolean remove(PSWFLinkBase pSWFLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkBase.resetActionField();
                return true;
            }
            case 1: {
                pSWFLinkBase.resetActionPSCodeListId();
                return true;
            }
            case 2: {
                pSWFLinkBase.resetActionPSCodeListName();
                return true;
            }
            case 3: {
                pSWFLinkBase.resetActorFields();
                return true;
            }
            case 4: {
                pSWFLinkBase.resetCodeName();
                return true;
            }
            case 5: {
                pSWFLinkBase.resetCondModel();
                return true;
            }
            case 6: {
                pSWFLinkBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSWFLinkBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSWFLinkBase.resetCustomCond();
                return true;
            }
            case 9: {
                pSWFLinkBase.resetCustomCondFlag();
                return true;
            }
            case 10: {
                pSWFLinkBase.resetDefaultLink();
                return true;
            }
            case 11: {
                pSWFLinkBase.resetDstEndPoint();
                return true;
            }
            case 12: {
                pSWFLinkBase.resetDynaModelFlag();
                return true;
            }
            case 13: {
                pSWFLinkBase.resetEnable();
                return true;
            }
            case 14: {
                pSWFLinkBase.resetEnableMobile();
                return true;
            }
            case 15: {
                pSWFLinkBase.resetFormCodeName();
                return true;
            }
            case 16: {
                pSWFLinkBase.resetFromPSWFProcId();
                return true;
            }
            case 17: {
                pSWFLinkBase.resetFromPSWFProcName();
                return true;
            }
            case 18: {
                pSWFLinkBase.resetLabel();
                return true;
            }
            case 19: {
                pSWFLinkBase.resetLNPSLanResId();
                return true;
            }
            case 20: {
                pSWFLinkBase.resetLNPSLanResName();
                return true;
            }
            case 21: {
                pSWFLinkBase.resetLogicName();
                return true;
            }
            case 22: {
                pSWFLinkBase.resetMemo();
                return true;
            }
            case 23: {
                pSWFLinkBase.resetMemoField();
                return true;
            }
            case 24: {
                pSWFLinkBase.resetMobFormCodeName();
                return true;
            }
            case 25: {
                pSWFLinkBase.resetMobPSDEFormId();
                return true;
            }
            case 26: {
                pSWFLinkBase.resetMobPSDEFormName();
                return true;
            }
            case 27: {
                pSWFLinkBase.resetMobPSDEViewId();
                return true;
            }
            case 28: {
                pSWFLinkBase.resetMobPSDEViewName();
                return true;
            }
            case 29: {
                pSWFLinkBase.resetMobViewCodeName();
                return true;
            }
            case 30: {
                pSWFLinkBase.resetModelId();
                return true;
            }
            case 31: {
                pSWFLinkBase.resetNextCond();
                return true;
            }
            case 32: {
                pSWFLinkBase.resetOrderValue();
                return true;
            }
            case 33: {
                pSWFLinkBase.resetPSDEFormId();
                return true;
            }
            case 34: {
                pSWFLinkBase.resetPSDEFormName();
                return true;
            }
            case 35: {
                pSWFLinkBase.resetPSDEId();
                return true;
            }
            case 36: {
                pSWFLinkBase.resetPSDEViewBaseId();
                return true;
            }
            case 37: {
                pSWFLinkBase.resetPSDEViewBaseName();
                return true;
            }
            case 38: {
                pSWFLinkBase.resetPSDynaInstId();
                return true;
            }
            case 39: {
                pSWFLinkBase.resetPSSystemId();
                return true;
            }
            case 40: {
                pSWFLinkBase.resetPSWFDEId();
                return true;
            }
            case 41: {
                pSWFLinkBase.resetPSWFId();
                return true;
            }
            case 42: {
                pSWFLinkBase.resetPSWFLinkId();
                return true;
            }
            case 43: {
                pSWFLinkBase.resetPSWFLinkName();
                return true;
            }
            case 44: {
                pSWFLinkBase.resetPSWFName();
                return true;
            }
            case 45: {
                pSWFLinkBase.resetPSWFRoleId();
                return true;
            }
            case 46: {
                pSWFLinkBase.resetPSWFRoleName();
                return true;
            }
            case 47: {
                pSWFLinkBase.resetPSWFVersionId();
                return true;
            }
            case 48: {
                pSWFLinkBase.resetPSWFVersionName();
                return true;
            }
            case 49: {
                pSWFLinkBase.resetShapeParams();
                return true;
            }
            case 50: {
                pSWFLinkBase.resetSomeRoleFlag();
                return true;
            }
            case 51: {
                pSWFLinkBase.resetSrcEndPoint();
                return true;
            }
            case 52: {
                pSWFLinkBase.resetThreadFlag();
                return true;
            }
            case 53: {
                pSWFLinkBase.resetThreadName();
                return true;
            }
            case 54: {
                pSWFLinkBase.resetTipPSLanResId();
                return true;
            }
            case 55: {
                pSWFLinkBase.resetTipPSLanResName();
                return true;
            }
            case 56: {
                pSWFLinkBase.resetToPSWFProcId();
                return true;
            }
            case 57: {
                pSWFLinkBase.resetToPSWFProcName();
                return true;
            }
            case 58: {
                pSWFLinkBase.resetUpdateDate();
                return true;
            }
            case 59: {
                pSWFLinkBase.resetUpdateMan();
                return true;
            }
            case 60: {
                pSWFLinkBase.resetUserCat();
                return true;
            }
            case 61: {
                pSWFLinkBase.resetUserData();
                return true;
            }
            case 62: {
                pSWFLinkBase.resetUserData2();
                return true;
            }
            case 63: {
                pSWFLinkBase.resetUserTag();
                return true;
            }
            case 64: {
                pSWFLinkBase.resetUserTag2();
                return true;
            }
            case 65: {
                pSWFLinkBase.resetUserTag3();
                return true;
            }
            case 66: {
                pSWFLinkBase.resetUserTag4();
                return true;
            }
            case 67: {
                pSWFLinkBase.resetViewCodeName();
                return true;
            }
            case 68: {
                pSWFLinkBase.resetWFEngineType();
                return true;
            }
            case 69: {
                pSWFLinkBase.resetWFLinkType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getActionPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionPSCodeList();
        }
        if (this.getActionPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objActionPSCodeListLock;
        synchronized (n) {
            if (this.actionpscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getActionPSCodeListId(), (Object)this.actionpscodelist.getPSCodeListId()) != 0L) {
                this.actionpscodelist = null;
            }
            if (this.actionpscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getActionPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.actionpscodelist = pSCodeList;
            }
            return this.actionpscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEForm();
        }
        if (this.getMobPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobPSDEFormLock;
        synchronized (n) {
            if (this.mobpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobPSDEFormId(), (Object)this.mobpsdeform.getPSDEFormId()) != 0L) {
                this.mobpsdeform = null;
            }
            if (this.mobpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobpsdeform = pSDEForm;
            }
            return this.mobpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getMobPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEView();
        }
        if (this.getMobPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objMobPSDEViewLock;
        synchronized (n) {
            if (this.mobpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getMobPSDEViewId(), (Object)this.mobpsdeview.getPSDEViewBaseId()) != 0L) {
                this.mobpsdeview = null;
            }
            if (this.mobpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getMobPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.mobpsdeview = pSDEViewBase;
            }
            return this.mobpsdeview;
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
    public PSLanguageRes getLNPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLNPSLanRes();
        }
        if (this.getLNPSLanResId() == null) {
            return null;
        }
        Integer n = this.objLNPSLanResLock;
        synchronized (n) {
            if (this.lnpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getLNPSLanResId(), (Object)this.lnpslanres.getPSLanguageResId()) != 0L) {
                this.lnpslanres = null;
            }
            if (this.lnpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getLNPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.lnpslanres = pSLanguageRes;
            }
            return this.lnpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTipPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanRes();
        }
        if (this.getTipPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSLanResLock;
        synchronized (n) {
            if (this.tippslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSLanResId(), (Object)this.tippslanres.getPSLanguageResId()) != 0L) {
                this.tippslanres = null;
            }
            if (this.tippslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTipPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFProcess getFromPSWFProc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSWFProc();
        }
        if (this.getFromPSWFProcId() == null) {
            return null;
        }
        Integer n = this.objFromPSWFProcLock;
        synchronized (n) {
            if (this.frompswfproc != null && DataTypeHelper.compare((int)25, (Object)this.getFromPSWFProcId(), (Object)this.frompswfproc.getPSWFProcessId()) != 0L) {
                this.frompswfproc = null;
            }
            if (this.frompswfproc == null) {
                PSWFProcess pSWFProcess = new PSWFProcess();
                pSWFProcess.setPSWFProcessId(this.getFromPSWFProcId());
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                pSWFProcessService.autoGet((IEntity)pSWFProcess);
                this.frompswfproc = pSWFProcess;
            }
            return this.frompswfproc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFProcess getToPSWFProc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToPSWFProc();
        }
        if (this.getToPSWFProcId() == null) {
            return null;
        }
        Integer n = this.objToPSWFProcLock;
        synchronized (n) {
            if (this.topswfproc != null && DataTypeHelper.compare((int)25, (Object)this.getToPSWFProcId(), (Object)this.topswfproc.getPSWFProcessId()) != 0L) {
                this.topswfproc = null;
            }
            if (this.topswfproc == null) {
                PSWFProcess pSWFProcess = new PSWFProcess();
                pSWFProcess.setPSWFProcessId(this.getToPSWFProcId());
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                pSWFProcessService.autoGet((IEntity)pSWFProcess);
                this.topswfproc = pSWFProcess;
            }
            return this.topswfproc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFRole getPSWFRole() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFRole();
        }
        if (this.getPSWFRoleId() == null) {
            return null;
        }
        Integer n = this.objPSWFRoleLock;
        synchronized (n) {
            if (this.pswfrole != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFRoleId(), (Object)this.pswfrole.getPSWFRoleId()) != 0L) {
                this.pswfrole = null;
            }
            if (this.pswfrole == null) {
                PSWFRole pSWFRole = new PSWFRole();
                pSWFRole.setPSWFRoleId(this.getPSWFRoleId());
                PSWFRoleService pSWFRoleService = (PSWFRoleService)ServiceGlobal.getService(PSWFRoleService.class, (SessionFactory)this.getSessionFactory());
                pSWFRoleService.autoGet((IEntity)pSWFRole);
                this.pswfrole = pSWFRole;
            }
            return this.pswfrole;
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
    public ArrayList<PSWFLinkCond> getPSWFLinkConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkConds();
        }
        if (this.getPSWFLinkId() == null) {
            return null;
        }
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFLinkCondsLock;
        synchronized (n) {
            if (this.pswflinkconds == null) {
                this.pswflinkconds = pSWFLinkService.isTempData((IEntity)this) ? pSWFLinkCondService.selectTempByPSWFLink(this) : pSWFLinkCondService.selectByPSWFLink(this);
            }
            return this.pswflinkconds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFLinkRole> getPSWFLinkRoles() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkRoles();
        }
        if (this.getPSWFLinkId() == null) {
            return null;
        }
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        PSWFLinkRoleService pSWFLinkRoleService = (PSWFLinkRoleService)ServiceGlobal.getService(PSWFLinkRoleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFLinkRolesLock;
        synchronized (n) {
            if (this.pswflinkroles == null) {
                this.pswflinkroles = pSWFLinkService.isTempData((IEntity)this) ? pSWFLinkRoleService.selectTempByPSWFLink(this) : pSWFLinkRoleService.selectByPSWFLink(this);
            }
            return this.pswflinkroles;
        }
    }

    private PSWFLinkBase getProxyEntity() {
        return this.proxyPSWFLinkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFLinkBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFLinkBase) {
            this.proxyPSWFLinkBase = (PSWFLinkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONFIELD, 0);
        fieldIndexMap.put(FIELD_ACTIONPSCODELISTID, 1);
        fieldIndexMap.put(FIELD_ACTIONPSCODELISTNAME, 2);
        fieldIndexMap.put(FIELD_ACTORFIELDS, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CONDMODEL, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 8);
        fieldIndexMap.put(FIELD_CUSTOMCONDFLAG, 9);
        fieldIndexMap.put(FIELD_DEFAULTLINK, 10);
        fieldIndexMap.put(FIELD_DSTENDPOINT, 11);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 12);
        fieldIndexMap.put(FIELD_ENABLE, 13);
        fieldIndexMap.put(FIELD_ENABLEMOBILE, 14);
        fieldIndexMap.put(FIELD_FORMCODENAME, 15);
        fieldIndexMap.put(FIELD_FROMPSWFPROCID, 16);
        fieldIndexMap.put(FIELD_FROMPSWFPROCNAME, 17);
        fieldIndexMap.put(FIELD_LABEL, 18);
        fieldIndexMap.put(FIELD_LNPSLANRESID, 19);
        fieldIndexMap.put(FIELD_LNPSLANRESNAME, 20);
        fieldIndexMap.put(FIELD_LOGICNAME, 21);
        fieldIndexMap.put(FIELD_MEMO, 22);
        fieldIndexMap.put(FIELD_MEMOFIELD, 23);
        fieldIndexMap.put(FIELD_MOBFORMCODENAME, 24);
        fieldIndexMap.put(FIELD_MOBPSDEFORMID, 25);
        fieldIndexMap.put(FIELD_MOBPSDEFORMNAME, 26);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWID, 27);
        fieldIndexMap.put(FIELD_MOBPSDEVIEWNAME, 28);
        fieldIndexMap.put(FIELD_MOBVIEWCODENAME, 29);
        fieldIndexMap.put(FIELD_MODELID, 30);
        fieldIndexMap.put(FIELD_NEXTCOND, 31);
        fieldIndexMap.put(FIELD_ORDERVALUE, 32);
        fieldIndexMap.put(FIELD_PSDEFORMID, 33);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 34);
        fieldIndexMap.put(FIELD_PSDEID, 35);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 36);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 37);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 38);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 39);
        fieldIndexMap.put(FIELD_PSWFDEID, 40);
        fieldIndexMap.put(FIELD_PSWFID, 41);
        fieldIndexMap.put(FIELD_PSWFLINKID, 42);
        fieldIndexMap.put(FIELD_PSWFLINKNAME, 43);
        fieldIndexMap.put(FIELD_PSWFNAME, 44);
        fieldIndexMap.put(FIELD_PSWFROLEID, 45);
        fieldIndexMap.put(FIELD_PSWFROLENAME, 46);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 47);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 48);
        fieldIndexMap.put(FIELD_SHAPEPARAMS, 49);
        fieldIndexMap.put(FIELD_SOMEROLEFLAG, 50);
        fieldIndexMap.put(FIELD_SRCENDPOINT, 51);
        fieldIndexMap.put(FIELD_THREADFLAG, 52);
        fieldIndexMap.put(FIELD_THREADNAME, 53);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 54);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 55);
        fieldIndexMap.put(FIELD_TOPSWFPROCID, 56);
        fieldIndexMap.put(FIELD_TOPSWFPROCNAME, 57);
        fieldIndexMap.put(FIELD_UPDATEDATE, 58);
        fieldIndexMap.put(FIELD_UPDATEMAN, 59);
        fieldIndexMap.put(FIELD_USERCAT, 60);
        fieldIndexMap.put(FIELD_USERDATA, 61);
        fieldIndexMap.put(FIELD_USERDATA2, 62);
        fieldIndexMap.put(FIELD_USERTAG, 63);
        fieldIndexMap.put(FIELD_USERTAG2, 64);
        fieldIndexMap.put(FIELD_USERTAG3, 65);
        fieldIndexMap.put(FIELD_USERTAG4, 66);
        fieldIndexMap.put(FIELD_VIEWCODENAME, 67);
        fieldIndexMap.put(FIELD_WFENGINETYPE, 68);
        fieldIndexMap.put(FIELD_WFLINKTYPE, 69);
    }
}

