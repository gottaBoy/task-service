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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEReportBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEReportBase.class);
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_ENABLEAUDIT = "ENABLEAUDIT";
    public static final String FIELD_ENABLELOG = "ENABLELOG";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_LAYOUTPANELMODE = "LAYOUTPANELMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MULTIPAGE = "MULTIPAGE";
    public static final String FIELD_POTIME = "POTIME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSID2 = "PSDEDSID2";
    public static final String FIELD_PSDEDSID3 = "PSDEDSID3";
    public static final String FIELD_PSDEDSID4 = "PSDEDSID4";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEDSNAME2 = "PSDEDSNAME2";
    public static final String FIELD_PSDEDSNAME3 = "PSDEDSNAME3";
    public static final String FIELD_PSDEDSNAME4 = "PSDEDSNAME4";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEREPORTID = "PSDEREPORTID";
    public static final String FIELD_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String FIELD_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_REPORTFILE = "REPORTFILE";
    public static final String FIELD_REPORTMODEL = "REPORTMODEL";
    public static final String FIELD_REPORTPARAMS = "REPORTPARAMS";
    public static final String FIELD_REPORTTAG = "REPORTTAG";
    public static final String FIELD_REPORTTAG2 = "REPORTTAG2";
    public static final String FIELD_REPORTTYPE = "REPORTTYPE";
    public static final String FIELD_REPORTUIMODEL = "REPORTUIMODEL";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_ADPSDELOGICID = 0;
    private static final int INDEX_ADPSDELOGICNAME = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CONTENTTYPE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_CUSTOMCODE = 6;
    private static final int INDEX_CUSTOMMODE = 7;
    private static final int INDEX_ENABLEAUDIT = 8;
    private static final int INDEX_ENABLELOG = 9;
    private static final int INDEX_EXTENDMODE = 10;
    private static final int INDEX_LAYOUTPANELMODE = 11;
    private static final int INDEX_LOCKFLAG = 12;
    private static final int INDEX_LOGICNAME = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_MULTIPAGE = 15;
    private static final int INDEX_POTIME = 16;
    private static final int INDEX_PSDEDSID = 17;
    private static final int INDEX_PSDEDSID2 = 18;
    private static final int INDEX_PSDEDSID3 = 19;
    private static final int INDEX_PSDEDSID4 = 20;
    private static final int INDEX_PSDEDSNAME = 21;
    private static final int INDEX_PSDEDSNAME2 = 22;
    private static final int INDEX_PSDEDSNAME3 = 23;
    private static final int INDEX_PSDEDSNAME4 = 24;
    private static final int INDEX_PSDEID = 25;
    private static final int INDEX_PSDENAME = 26;
    private static final int INDEX_PSDEREPORTID = 27;
    private static final int INDEX_PSDEREPORTNAME = 28;
    private static final int INDEX_PSSYSBICUBEID = 29;
    private static final int INDEX_PSSYSBICUBENAME = 30;
    private static final int INDEX_PSSYSBIREPORTID = 31;
    private static final int INDEX_PSSYSBIREPORTNAME = 32;
    private static final int INDEX_PSSYSBISCHEMEID = 33;
    private static final int INDEX_PSSYSBISCHEMENAME = 34;
    private static final int INDEX_PSSYSPFPLUGINID = 35;
    private static final int INDEX_PSSYSPFPLUGINNAME = 36;
    private static final int INDEX_PSSYSREQITEMID = 37;
    private static final int INDEX_PSSYSREQITEMNAME = 38;
    private static final int INDEX_PSSYSRESOURCEID = 39;
    private static final int INDEX_PSSYSRESOURCENAME = 40;
    private static final int INDEX_PSSYSSFPLUGINID = 41;
    private static final int INDEX_PSSYSSFPLUGINNAME = 42;
    private static final int INDEX_PSSYSUNIRESID = 43;
    private static final int INDEX_PSSYSUNIRESNAME = 44;
    private static final int INDEX_PSSYSVIEWPANELID = 45;
    private static final int INDEX_PSSYSVIEWPANELNAME = 46;
    private static final int INDEX_PSVIEWMSGGROUPID = 47;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 48;
    private static final int INDEX_REPORTFILE = 49;
    private static final int INDEX_REPORTMODEL = 50;
    private static final int INDEX_REPORTPARAMS = 51;
    private static final int INDEX_REPORTTAG = 52;
    private static final int INDEX_REPORTTAG2 = 53;
    private static final int INDEX_REPORTTYPE = 54;
    private static final int INDEX_REPORTUIMODEL = 55;
    private static final int INDEX_TODOTASK = 56;
    private static final int INDEX_UPDATEDATE = 57;
    private static final int INDEX_UPDATEMAN = 58;
    private static final int INDEX_USERCAT = 59;
    private static final int INDEX_USERTAG = 60;
    private static final int INDEX_USERTAG2 = 61;
    private static final int INDEX_USERTAG3 = 62;
    private static final int INDEX_USERTAG4 = 63;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEReportBase proxyPSDEReportBase = null;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean enableauditDirtyFlag = false;
    private boolean enablelogDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean layoutpanelmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean multipageDirtyFlag = false;
    private boolean potimeDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsid2DirtyFlag = false;
    private boolean psdedsid3DirtyFlag = false;
    private boolean psdedsid4DirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdedsname2DirtyFlag = false;
    private boolean psdedsname3DirtyFlag = false;
    private boolean psdedsname4DirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdereportidDirtyFlag = false;
    private boolean psdereportnameDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbireportidDirtyFlag = false;
    private boolean pssysbireportnameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysbischemenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean reportfileDirtyFlag = false;
    private boolean reportmodelDirtyFlag = false;
    private boolean reportparamsDirtyFlag = false;
    private boolean reporttagDirtyFlag = false;
    private boolean reporttag2DirtyFlag = false;
    private boolean reporttypeDirtyFlag = false;
    private boolean reportuimodelDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="codename")
    private String codename;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="enableaudit")
    private Integer enableaudit;
    @Column(name="enablelog")
    private Integer enablelog;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="layoutpanelmode")
    private Integer layoutpanelmode;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="multipage")
    private Integer multipage;
    @Column(name="potime")
    private Integer potime;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsid2")
    private String psdedsid2;
    @Column(name="psdedsid3")
    private String psdedsid3;
    @Column(name="psdedsid4")
    private String psdedsid4;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdedsname2")
    private String psdedsname2;
    @Column(name="psdedsname3")
    private String psdedsname3;
    @Column(name="psdedsname4")
    private String psdedsname4;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdereportid")
    private String psdereportid;
    @Column(name="psdereportname")
    private String psdereportname;
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbireportid")
    private String pssysbireportid;
    @Column(name="pssysbireportname")
    private String pssysbireportname;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysbischemename")
    private String pssysbischemename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="reportfile")
    private String reportfile;
    @Column(name="reportmodel")
    private String reportmodel;
    @Column(name="reportparams")
    private String reportparams;
    @Column(name="reporttag")
    private String reporttag;
    @Column(name="reporttag2")
    private String reporttag2;
    @Column(name="reporttype")
    private String reporttype;
    @Column(name="reportuimodel")
    private String reportuimodel;
    @Column(name="todotask")
    private String todotask;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSDEDS2Lock = new Integer(1);
    private PSDEDataSet psdeds2 = null;
    private Integer objPSDEDS3Lock = new Integer(1);
    private PSDEDataSet psdeds3 = null;
    private Integer objPSDEDS4Lock = new Integer(1);
    private PSDEDataSet psdeds4 = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objPSSysBICubeLock = new Integer(1);
    private PSSysBICube pssysbicube = null;
    private Integer objPSSysBIReportLock = new Integer(1);
    private PSSysBIReport pssysbireport = null;
    private Integer objPSSysBISchemeLock = new Integer(1);
    private PSSysBIScheme pssysbischeme = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;

    public void setADPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setADPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adpsdelogicid = string;
        this.adpsdelogicidDirtyFlag = true;
    }

    public String getADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogicId();
        }
        return this.adpsdelogicid;
    }

    public boolean isADPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isADPSDELogicIdDirty();
        }
        return this.adpsdelogicidDirtyFlag;
    }

    public void resetADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetADPSDELogicId();
            return;
        }
        this.adpsdelogicidDirtyFlag = false;
        this.adpsdelogicid = null;
    }

    public void setADPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setADPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.adpsdelogicname = string;
        this.adpsdelogicnameDirtyFlag = true;
    }

    public String getADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogicName();
        }
        return this.adpsdelogicname;
    }

    public boolean isADPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isADPSDELogicNameDirty();
        }
        return this.adpsdelogicnameDirtyFlag;
    }

    public void resetADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetADPSDELogicName();
            return;
        }
        this.adpsdelogicnameDirtyFlag = false;
        this.adpsdelogicname = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setEnableAudit(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAudit(n);
            return;
        }
        this.enableaudit = n;
        this.enableauditDirtyFlag = true;
    }

    public Integer getEnableAudit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAudit();
        }
        return this.enableaudit;
    }

    public boolean isEnableAuditDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAuditDirty();
        }
        return this.enableauditDirtyFlag;
    }

    public void resetEnableAudit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAudit();
            return;
        }
        this.enableauditDirtyFlag = false;
        this.enableaudit = null;
    }

    public void setEnableLog(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLog(n);
            return;
        }
        this.enablelog = n;
        this.enablelogDirtyFlag = true;
    }

    public Integer getEnableLog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLog();
        }
        return this.enablelog;
    }

    public boolean isEnableLogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLogDirty();
        }
        return this.enablelogDirtyFlag;
    }

    public void resetEnableLog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLog();
            return;
        }
        this.enablelogDirtyFlag = false;
        this.enablelog = null;
    }

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
    }

    public void setLayoutPanelMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutPanelMode(n);
            return;
        }
        this.layoutpanelmode = n;
        this.layoutpanelmodeDirtyFlag = true;
    }

    public Integer getLayoutPanelMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutPanelMode();
        }
        return this.layoutpanelmode;
    }

    public boolean isLayoutPanelModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutPanelModeDirty();
        }
        return this.layoutpanelmodeDirtyFlag;
    }

    public void resetLayoutPanelMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutPanelMode();
            return;
        }
        this.layoutpanelmodeDirtyFlag = false;
        this.layoutpanelmode = null;
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

    public void setMultiPage(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMultiPage(n);
            return;
        }
        this.multipage = n;
        this.multipageDirtyFlag = true;
    }

    public Integer getMultiPage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMultiPage();
        }
        return this.multipage;
    }

    public boolean isMultiPageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMultiPageDirty();
        }
        return this.multipageDirtyFlag;
    }

    public void resetMultiPage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMultiPage();
            return;
        }
        this.multipageDirtyFlag = false;
        this.multipage = null;
    }

    public void setPOTime(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPOTime(n);
            return;
        }
        this.potime = n;
        this.potimeDirtyFlag = true;
    }

    public Integer getPOTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPOTime();
        }
        return this.potime;
    }

    public boolean isPOTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPOTimeDirty();
        }
        return this.potimeDirtyFlag;
    }

    public void resetPOTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPOTime();
            return;
        }
        this.potimeDirtyFlag = false;
        this.potime = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid2 = string;
        this.psdedsid2DirtyFlag = true;
    }

    public String getPSDEDSId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId2();
        }
        return this.psdedsid2;
    }

    public boolean isPSDEDSId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSId2Dirty();
        }
        return this.psdedsid2DirtyFlag;
    }

    public void resetPSDEDSId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId2();
            return;
        }
        this.psdedsid2DirtyFlag = false;
        this.psdedsid2 = null;
    }

    public void setPSDEDSId3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid3 = string;
        this.psdedsid3DirtyFlag = true;
    }

    public String getPSDEDSId3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId3();
        }
        return this.psdedsid3;
    }

    public boolean isPSDEDSId3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSId3Dirty();
        }
        return this.psdedsid3DirtyFlag;
    }

    public void resetPSDEDSId3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId3();
            return;
        }
        this.psdedsid3DirtyFlag = false;
        this.psdedsid3 = null;
    }

    public void setPSDEDSId4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid4 = string;
        this.psdedsid4DirtyFlag = true;
    }

    public String getPSDEDSId4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId4();
        }
        return this.psdedsid4;
    }

    public boolean isPSDEDSId4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSId4Dirty();
        }
        return this.psdedsid4DirtyFlag;
    }

    public void resetPSDEDSId4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId4();
            return;
        }
        this.psdedsid4DirtyFlag = false;
        this.psdedsid4 = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
    }

    public void setPSDEDSName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname2 = string;
        this.psdedsname2DirtyFlag = true;
    }

    public String getPSDEDSName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName2();
        }
        return this.psdedsname2;
    }

    public boolean isPSDEDSName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSName2Dirty();
        }
        return this.psdedsname2DirtyFlag;
    }

    public void resetPSDEDSName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName2();
            return;
        }
        this.psdedsname2DirtyFlag = false;
        this.psdedsname2 = null;
    }

    public void setPSDEDSName3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname3 = string;
        this.psdedsname3DirtyFlag = true;
    }

    public String getPSDEDSName3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName3();
        }
        return this.psdedsname3;
    }

    public boolean isPSDEDSName3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSName3Dirty();
        }
        return this.psdedsname3DirtyFlag;
    }

    public void resetPSDEDSName3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName3();
            return;
        }
        this.psdedsname3DirtyFlag = false;
        this.psdedsname3 = null;
    }

    public void setPSDEDSName4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname4 = string;
        this.psdedsname4DirtyFlag = true;
    }

    public String getPSDEDSName4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName4();
        }
        return this.psdedsname4;
    }

    public boolean isPSDEDSName4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSName4Dirty();
        }
        return this.psdedsname4DirtyFlag;
    }

    public void resetPSDEDSName4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName4();
            return;
        }
        this.psdedsname4DirtyFlag = false;
        this.psdedsname4 = null;
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

    public void setPSDEReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdereportid = string;
        this.psdereportidDirtyFlag = true;
    }

    public String getPSDEReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReportId();
        }
        return this.psdereportid;
    }

    public boolean isPSDEReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEReportIdDirty();
        }
        return this.psdereportidDirtyFlag;
    }

    public void resetPSDEReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEReportId();
            return;
        }
        this.psdereportidDirtyFlag = false;
        this.psdereportid = null;
    }

    public void setPSDEReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdereportname = string;
        this.psdereportnameDirtyFlag = true;
    }

    public String getPSDEReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReportName();
        }
        return this.psdereportname;
    }

    public boolean isPSDEReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEReportNameDirty();
        }
        return this.psdereportnameDirtyFlag;
    }

    public void resetPSDEReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEReportName();
            return;
        }
        this.psdereportnameDirtyFlag = false;
        this.psdereportname = null;
    }

    public void setPSSysBICubeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubeid = string;
        this.pssysbicubeidDirtyFlag = true;
    }

    public String getPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeId();
        }
        return this.pssysbicubeid;
    }

    public boolean isPSSysBICubeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeIdDirty();
        }
        return this.pssysbicubeidDirtyFlag;
    }

    public void resetPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeId();
            return;
        }
        this.pssysbicubeidDirtyFlag = false;
        this.pssysbicubeid = null;
    }

    public void setPSSysBICubeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubename = string;
        this.pssysbicubenameDirtyFlag = true;
    }

    public String getPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeName();
        }
        return this.pssysbicubename;
    }

    public boolean isPSSysBICubeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeNameDirty();
        }
        return this.pssysbicubenameDirtyFlag;
    }

    public void resetPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeName();
            return;
        }
        this.pssysbicubenameDirtyFlag = false;
        this.pssysbicubename = null;
    }

    public void setPSSysBIReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportid = string;
        this.pssysbireportidDirtyFlag = true;
    }

    public String getPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportId();
        }
        return this.pssysbireportid;
    }

    public boolean isPSSysBIReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportIdDirty();
        }
        return this.pssysbireportidDirtyFlag;
    }

    public void resetPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportId();
            return;
        }
        this.pssysbireportidDirtyFlag = false;
        this.pssysbireportid = null;
    }

    public void setPSSysBIReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportname = string;
        this.pssysbireportnameDirtyFlag = true;
    }

    public String getPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportName();
        }
        return this.pssysbireportname;
    }

    public boolean isPSSysBIReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportNameDirty();
        }
        return this.pssysbireportnameDirtyFlag;
    }

    public void resetPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportName();
            return;
        }
        this.pssysbireportnameDirtyFlag = false;
        this.pssysbireportname = null;
    }

    public void setPSSysBISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemeid = string;
        this.pssysbischemeidDirtyFlag = true;
    }

    public String getPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeId();
        }
        return this.pssysbischemeid;
    }

    public boolean isPSSysBISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeIdDirty();
        }
        return this.pssysbischemeidDirtyFlag;
    }

    public void resetPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeId();
            return;
        }
        this.pssysbischemeidDirtyFlag = false;
        this.pssysbischemeid = null;
    }

    public void setPSSysBISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemename = string;
        this.pssysbischemenameDirtyFlag = true;
    }

    public String getPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeName();
        }
        return this.pssysbischemename;
    }

    public boolean isPSSysBISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeNameDirty();
        }
        return this.pssysbischemenameDirtyFlag;
    }

    public void resetPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeName();
            return;
        }
        this.pssysbischemenameDirtyFlag = false;
        this.pssysbischemename = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
    }

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
    }

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
    }

    public void setReportFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reportfile = string;
        this.reportfileDirtyFlag = true;
    }

    public String getReportFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportFile();
        }
        return this.reportfile;
    }

    public boolean isReportFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportFileDirty();
        }
        return this.reportfileDirtyFlag;
    }

    public void resetReportFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportFile();
            return;
        }
        this.reportfileDirtyFlag = false;
        this.reportfile = null;
    }

    public void setReportModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reportmodel = string;
        this.reportmodelDirtyFlag = true;
    }

    public String getReportModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportModel();
        }
        return this.reportmodel;
    }

    public boolean isReportModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportModelDirty();
        }
        return this.reportmodelDirtyFlag;
    }

    public void resetReportModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportModel();
            return;
        }
        this.reportmodelDirtyFlag = false;
        this.reportmodel = null;
    }

    public void setReportParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reportparams = string;
        this.reportparamsDirtyFlag = true;
    }

    public String getReportParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportParams();
        }
        return this.reportparams;
    }

    public boolean isReportParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportParamsDirty();
        }
        return this.reportparamsDirtyFlag;
    }

    public void resetReportParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportParams();
            return;
        }
        this.reportparamsDirtyFlag = false;
        this.reportparams = null;
    }

    public void setReportTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reporttag = string;
        this.reporttagDirtyFlag = true;
    }

    public String getReportTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportTag();
        }
        return this.reporttag;
    }

    public boolean isReportTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportTagDirty();
        }
        return this.reporttagDirtyFlag;
    }

    public void resetReportTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportTag();
            return;
        }
        this.reporttagDirtyFlag = false;
        this.reporttag = null;
    }

    public void setReportTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reporttag2 = string;
        this.reporttag2DirtyFlag = true;
    }

    public String getReportTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportTag2();
        }
        return this.reporttag2;
    }

    public boolean isReportTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportTag2Dirty();
        }
        return this.reporttag2DirtyFlag;
    }

    public void resetReportTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportTag2();
            return;
        }
        this.reporttag2DirtyFlag = false;
        this.reporttag2 = null;
    }

    public void setReportType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reporttype = string;
        this.reporttypeDirtyFlag = true;
    }

    public String getReportType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportType();
        }
        return this.reporttype;
    }

    public boolean isReportTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportTypeDirty();
        }
        return this.reporttypeDirtyFlag;
    }

    public void resetReportType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportType();
            return;
        }
        this.reporttypeDirtyFlag = false;
        this.reporttype = null;
    }

    public void setReportUIModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReportUIModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reportuimodel = string;
        this.reportuimodelDirtyFlag = true;
    }

    public String getReportUIModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReportUIModel();
        }
        return this.reportuimodel;
    }

    public boolean isReportUIModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReportUIModelDirty();
        }
        return this.reportuimodelDirtyFlag;
    }

    public void resetReportUIModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReportUIModel();
            return;
        }
        this.reportuimodelDirtyFlag = false;
        this.reportuimodel = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
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
        PSDEReportBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEReportBase pSDEReportBase) {
        pSDEReportBase.resetADPSDELogicId();
        pSDEReportBase.resetADPSDELogicName();
        pSDEReportBase.resetCodeName();
        pSDEReportBase.resetContentType();
        pSDEReportBase.resetCreateDate();
        pSDEReportBase.resetCreateMan();
        pSDEReportBase.resetCustomCode();
        pSDEReportBase.resetCustomMode();
        pSDEReportBase.resetEnableAudit();
        pSDEReportBase.resetEnableLog();
        pSDEReportBase.resetExtendMode();
        pSDEReportBase.resetLayoutPanelMode();
        pSDEReportBase.resetLockFlag();
        pSDEReportBase.resetLogicName();
        pSDEReportBase.resetMemo();
        pSDEReportBase.resetMultiPage();
        pSDEReportBase.resetPOTime();
        pSDEReportBase.resetPSDEDSId();
        pSDEReportBase.resetPSDEDSId2();
        pSDEReportBase.resetPSDEDSId3();
        pSDEReportBase.resetPSDEDSId4();
        pSDEReportBase.resetPSDEDSName();
        pSDEReportBase.resetPSDEDSName2();
        pSDEReportBase.resetPSDEDSName3();
        pSDEReportBase.resetPSDEDSName4();
        pSDEReportBase.resetPSDEId();
        pSDEReportBase.resetPSDEName();
        pSDEReportBase.resetPSDEReportId();
        pSDEReportBase.resetPSDEReportName();
        pSDEReportBase.resetPSSysBICubeId();
        pSDEReportBase.resetPSSysBICubeName();
        pSDEReportBase.resetPSSysBIReportId();
        pSDEReportBase.resetPSSysBIReportName();
        pSDEReportBase.resetPSSysBISchemeId();
        pSDEReportBase.resetPSSysBISchemeName();
        pSDEReportBase.resetPSSysPFPluginId();
        pSDEReportBase.resetPSSysPFPluginName();
        pSDEReportBase.resetPSSysReqItemId();
        pSDEReportBase.resetPSSysReqItemName();
        pSDEReportBase.resetPSSysResourceId();
        pSDEReportBase.resetPSSysResourceName();
        pSDEReportBase.resetPSSysSFPluginId();
        pSDEReportBase.resetPSSysSFPluginName();
        pSDEReportBase.resetPSSysUniResId();
        pSDEReportBase.resetPSSysUniResName();
        pSDEReportBase.resetPSSysViewPanelId();
        pSDEReportBase.resetPSSysViewPanelName();
        pSDEReportBase.resetPSViewMsgGroupId();
        pSDEReportBase.resetPSViewMsgGroupName();
        pSDEReportBase.resetReportFile();
        pSDEReportBase.resetReportModel();
        pSDEReportBase.resetReportParams();
        pSDEReportBase.resetReportTag();
        pSDEReportBase.resetReportTag2();
        pSDEReportBase.resetReportType();
        pSDEReportBase.resetReportUIModel();
        pSDEReportBase.resetToDoTask();
        pSDEReportBase.resetUpdateDate();
        pSDEReportBase.resetUpdateMan();
        pSDEReportBase.resetUserCat();
        pSDEReportBase.resetUserTag();
        pSDEReportBase.resetUserTag2();
        pSDEReportBase.resetUserTag3();
        pSDEReportBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isEnableAuditDirty()) {
            hashMap.put(FIELD_ENABLEAUDIT, this.getEnableAudit());
        }
        if (!bl || this.isEnableLogDirty()) {
            hashMap.put(FIELD_ENABLELOG, this.getEnableLog());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isLayoutPanelModeDirty()) {
            hashMap.put(FIELD_LAYOUTPANELMODE, this.getLayoutPanelMode());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMultiPageDirty()) {
            hashMap.put(FIELD_MULTIPAGE, this.getMultiPage());
        }
        if (!bl || this.isPOTimeDirty()) {
            hashMap.put(FIELD_POTIME, this.getPOTime());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSId2Dirty()) {
            hashMap.put(FIELD_PSDEDSID2, this.getPSDEDSId2());
        }
        if (!bl || this.isPSDEDSId3Dirty()) {
            hashMap.put(FIELD_PSDEDSID3, this.getPSDEDSId3());
        }
        if (!bl || this.isPSDEDSId4Dirty()) {
            hashMap.put(FIELD_PSDEDSID4, this.getPSDEDSId4());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEDSName2Dirty()) {
            hashMap.put(FIELD_PSDEDSNAME2, this.getPSDEDSName2());
        }
        if (!bl || this.isPSDEDSName3Dirty()) {
            hashMap.put(FIELD_PSDEDSNAME3, this.getPSDEDSName3());
        }
        if (!bl || this.isPSDEDSName4Dirty()) {
            hashMap.put(FIELD_PSDEDSNAME4, this.getPSDEDSName4());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEReportIdDirty()) {
            hashMap.put(FIELD_PSDEREPORTID, this.getPSDEReportId());
        }
        if (!bl || this.isPSDEReportNameDirty()) {
            hashMap.put(FIELD_PSDEREPORTNAME, this.getPSDEReportName());
        }
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBIReportIdDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTID, this.getPSSysBIReportId());
        }
        if (!bl || this.isPSSysBIReportNameDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTNAME, this.getPSSysBIReportName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysBISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMENAME, this.getPSSysBISchemeName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isReportFileDirty()) {
            hashMap.put(FIELD_REPORTFILE, this.getReportFile());
        }
        if (!bl || this.isReportModelDirty()) {
            hashMap.put(FIELD_REPORTMODEL, this.getReportModel());
        }
        if (!bl || this.isReportParamsDirty()) {
            hashMap.put(FIELD_REPORTPARAMS, this.getReportParams());
        }
        if (!bl || this.isReportTagDirty()) {
            hashMap.put(FIELD_REPORTTAG, this.getReportTag());
        }
        if (!bl || this.isReportTag2Dirty()) {
            hashMap.put(FIELD_REPORTTAG2, this.getReportTag2());
        }
        if (!bl || this.isReportTypeDirty()) {
            hashMap.put(FIELD_REPORTTYPE, this.getReportType());
        }
        if (!bl || this.isReportUIModelDirty()) {
            hashMap.put(FIELD_REPORTUIMODEL, this.getReportUIModel());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
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
        return PSDEReportBase.get(this, n);
    }

    private static Object get(PSDEReportBase pSDEReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEReportBase.getADPSDELogicId();
            }
            case 1: {
                return pSDEReportBase.getADPSDELogicName();
            }
            case 2: {
                return pSDEReportBase.getCodeName();
            }
            case 3: {
                return pSDEReportBase.getContentType();
            }
            case 4: {
                return pSDEReportBase.getCreateDate();
            }
            case 5: {
                return pSDEReportBase.getCreateMan();
            }
            case 6: {
                return pSDEReportBase.getCustomCode();
            }
            case 7: {
                return pSDEReportBase.getCustomMode();
            }
            case 8: {
                return pSDEReportBase.getEnableAudit();
            }
            case 9: {
                return pSDEReportBase.getEnableLog();
            }
            case 10: {
                return pSDEReportBase.getExtendMode();
            }
            case 11: {
                return pSDEReportBase.getLayoutPanelMode();
            }
            case 12: {
                return pSDEReportBase.getLockFlag();
            }
            case 13: {
                return pSDEReportBase.getLogicName();
            }
            case 14: {
                return pSDEReportBase.getMemo();
            }
            case 15: {
                return pSDEReportBase.getMultiPage();
            }
            case 16: {
                return pSDEReportBase.getPOTime();
            }
            case 17: {
                return pSDEReportBase.getPSDEDSId();
            }
            case 18: {
                return pSDEReportBase.getPSDEDSId2();
            }
            case 19: {
                return pSDEReportBase.getPSDEDSId3();
            }
            case 20: {
                return pSDEReportBase.getPSDEDSId4();
            }
            case 21: {
                return pSDEReportBase.getPSDEDSName();
            }
            case 22: {
                return pSDEReportBase.getPSDEDSName2();
            }
            case 23: {
                return pSDEReportBase.getPSDEDSName3();
            }
            case 24: {
                return pSDEReportBase.getPSDEDSName4();
            }
            case 25: {
                return pSDEReportBase.getPSDEId();
            }
            case 26: {
                return pSDEReportBase.getPSDEName();
            }
            case 27: {
                return pSDEReportBase.getPSDEReportId();
            }
            case 28: {
                return pSDEReportBase.getPSDEReportName();
            }
            case 29: {
                return pSDEReportBase.getPSSysBICubeId();
            }
            case 30: {
                return pSDEReportBase.getPSSysBICubeName();
            }
            case 31: {
                return pSDEReportBase.getPSSysBIReportId();
            }
            case 32: {
                return pSDEReportBase.getPSSysBIReportName();
            }
            case 33: {
                return pSDEReportBase.getPSSysBISchemeId();
            }
            case 34: {
                return pSDEReportBase.getPSSysBISchemeName();
            }
            case 35: {
                return pSDEReportBase.getPSSysPFPluginId();
            }
            case 36: {
                return pSDEReportBase.getPSSysPFPluginName();
            }
            case 37: {
                return pSDEReportBase.getPSSysReqItemId();
            }
            case 38: {
                return pSDEReportBase.getPSSysReqItemName();
            }
            case 39: {
                return pSDEReportBase.getPSSysResourceId();
            }
            case 40: {
                return pSDEReportBase.getPSSysResourceName();
            }
            case 41: {
                return pSDEReportBase.getPSSysSFPluginId();
            }
            case 42: {
                return pSDEReportBase.getPSSysSFPluginName();
            }
            case 43: {
                return pSDEReportBase.getPSSysUniResId();
            }
            case 44: {
                return pSDEReportBase.getPSSysUniResName();
            }
            case 45: {
                return pSDEReportBase.getPSSysViewPanelId();
            }
            case 46: {
                return pSDEReportBase.getPSSysViewPanelName();
            }
            case 47: {
                return pSDEReportBase.getPSViewMsgGroupId();
            }
            case 48: {
                return pSDEReportBase.getPSViewMsgGroupName();
            }
            case 49: {
                return pSDEReportBase.getReportFile();
            }
            case 50: {
                return pSDEReportBase.getReportModel();
            }
            case 51: {
                return pSDEReportBase.getReportParams();
            }
            case 52: {
                return pSDEReportBase.getReportTag();
            }
            case 53: {
                return pSDEReportBase.getReportTag2();
            }
            case 54: {
                return pSDEReportBase.getReportType();
            }
            case 55: {
                return pSDEReportBase.getReportUIModel();
            }
            case 56: {
                return pSDEReportBase.getToDoTask();
            }
            case 57: {
                return pSDEReportBase.getUpdateDate();
            }
            case 58: {
                return pSDEReportBase.getUpdateMan();
            }
            case 59: {
                return pSDEReportBase.getUserCat();
            }
            case 60: {
                return pSDEReportBase.getUserTag();
            }
            case 61: {
                return pSDEReportBase.getUserTag2();
            }
            case 62: {
                return pSDEReportBase.getUserTag3();
            }
            case 63: {
                return pSDEReportBase.getUserTag4();
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
        PSDEReportBase.set(this, n, object);
    }

    private static void set(PSDEReportBase pSDEReportBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEReportBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEReportBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEReportBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEReportBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEReportBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEReportBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEReportBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEReportBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEReportBase.setEnableAudit(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEReportBase.setEnableLog(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEReportBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEReportBase.setLayoutPanelMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEReportBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEReportBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEReportBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEReportBase.setMultiPage(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEReportBase.setPOTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEReportBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEReportBase.setPSDEDSId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEReportBase.setPSDEDSId3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEReportBase.setPSDEDSId4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEReportBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEReportBase.setPSDEDSName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEReportBase.setPSDEDSName3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEReportBase.setPSDEDSName4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEReportBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEReportBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEReportBase.setPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEReportBase.setPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEReportBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEReportBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEReportBase.setPSSysBIReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEReportBase.setPSSysBIReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEReportBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEReportBase.setPSSysBISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEReportBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEReportBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEReportBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEReportBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEReportBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEReportBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEReportBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEReportBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEReportBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEReportBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEReportBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEReportBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEReportBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEReportBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEReportBase.setReportFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEReportBase.setReportModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEReportBase.setReportParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEReportBase.setReportTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEReportBase.setReportTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEReportBase.setReportType(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEReportBase.setReportUIModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEReportBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEReportBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 58: {
                pSDEReportBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEReportBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEReportBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEReportBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEReportBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEReportBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEReportBase.isNull(this, n);
    }

    private static boolean isNull(PSDEReportBase pSDEReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEReportBase.getADPSDELogicId() == null;
            }
            case 1: {
                return pSDEReportBase.getADPSDELogicName() == null;
            }
            case 2: {
                return pSDEReportBase.getCodeName() == null;
            }
            case 3: {
                return pSDEReportBase.getContentType() == null;
            }
            case 4: {
                return pSDEReportBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEReportBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEReportBase.getCustomCode() == null;
            }
            case 7: {
                return pSDEReportBase.getCustomMode() == null;
            }
            case 8: {
                return pSDEReportBase.getEnableAudit() == null;
            }
            case 9: {
                return pSDEReportBase.getEnableLog() == null;
            }
            case 10: {
                return pSDEReportBase.getExtendMode() == null;
            }
            case 11: {
                return pSDEReportBase.getLayoutPanelMode() == null;
            }
            case 12: {
                return pSDEReportBase.getLockFlag() == null;
            }
            case 13: {
                return pSDEReportBase.getLogicName() == null;
            }
            case 14: {
                return pSDEReportBase.getMemo() == null;
            }
            case 15: {
                return pSDEReportBase.getMultiPage() == null;
            }
            case 16: {
                return pSDEReportBase.getPOTime() == null;
            }
            case 17: {
                return pSDEReportBase.getPSDEDSId() == null;
            }
            case 18: {
                return pSDEReportBase.getPSDEDSId2() == null;
            }
            case 19: {
                return pSDEReportBase.getPSDEDSId3() == null;
            }
            case 20: {
                return pSDEReportBase.getPSDEDSId4() == null;
            }
            case 21: {
                return pSDEReportBase.getPSDEDSName() == null;
            }
            case 22: {
                return pSDEReportBase.getPSDEDSName2() == null;
            }
            case 23: {
                return pSDEReportBase.getPSDEDSName3() == null;
            }
            case 24: {
                return pSDEReportBase.getPSDEDSName4() == null;
            }
            case 25: {
                return pSDEReportBase.getPSDEId() == null;
            }
            case 26: {
                return pSDEReportBase.getPSDEName() == null;
            }
            case 27: {
                return pSDEReportBase.getPSDEReportId() == null;
            }
            case 28: {
                return pSDEReportBase.getPSDEReportName() == null;
            }
            case 29: {
                return pSDEReportBase.getPSSysBICubeId() == null;
            }
            case 30: {
                return pSDEReportBase.getPSSysBICubeName() == null;
            }
            case 31: {
                return pSDEReportBase.getPSSysBIReportId() == null;
            }
            case 32: {
                return pSDEReportBase.getPSSysBIReportName() == null;
            }
            case 33: {
                return pSDEReportBase.getPSSysBISchemeId() == null;
            }
            case 34: {
                return pSDEReportBase.getPSSysBISchemeName() == null;
            }
            case 35: {
                return pSDEReportBase.getPSSysPFPluginId() == null;
            }
            case 36: {
                return pSDEReportBase.getPSSysPFPluginName() == null;
            }
            case 37: {
                return pSDEReportBase.getPSSysReqItemId() == null;
            }
            case 38: {
                return pSDEReportBase.getPSSysReqItemName() == null;
            }
            case 39: {
                return pSDEReportBase.getPSSysResourceId() == null;
            }
            case 40: {
                return pSDEReportBase.getPSSysResourceName() == null;
            }
            case 41: {
                return pSDEReportBase.getPSSysSFPluginId() == null;
            }
            case 42: {
                return pSDEReportBase.getPSSysSFPluginName() == null;
            }
            case 43: {
                return pSDEReportBase.getPSSysUniResId() == null;
            }
            case 44: {
                return pSDEReportBase.getPSSysUniResName() == null;
            }
            case 45: {
                return pSDEReportBase.getPSSysViewPanelId() == null;
            }
            case 46: {
                return pSDEReportBase.getPSSysViewPanelName() == null;
            }
            case 47: {
                return pSDEReportBase.getPSViewMsgGroupId() == null;
            }
            case 48: {
                return pSDEReportBase.getPSViewMsgGroupName() == null;
            }
            case 49: {
                return pSDEReportBase.getReportFile() == null;
            }
            case 50: {
                return pSDEReportBase.getReportModel() == null;
            }
            case 51: {
                return pSDEReportBase.getReportParams() == null;
            }
            case 52: {
                return pSDEReportBase.getReportTag() == null;
            }
            case 53: {
                return pSDEReportBase.getReportTag2() == null;
            }
            case 54: {
                return pSDEReportBase.getReportType() == null;
            }
            case 55: {
                return pSDEReportBase.getReportUIModel() == null;
            }
            case 56: {
                return pSDEReportBase.getToDoTask() == null;
            }
            case 57: {
                return pSDEReportBase.getUpdateDate() == null;
            }
            case 58: {
                return pSDEReportBase.getUpdateMan() == null;
            }
            case 59: {
                return pSDEReportBase.getUserCat() == null;
            }
            case 60: {
                return pSDEReportBase.getUserTag() == null;
            }
            case 61: {
                return pSDEReportBase.getUserTag2() == null;
            }
            case 62: {
                return pSDEReportBase.getUserTag3() == null;
            }
            case 63: {
                return pSDEReportBase.getUserTag4() == null;
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
        return PSDEReportBase.contains(this, n);
    }

    private static boolean contains(PSDEReportBase pSDEReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEReportBase.isADPSDELogicIdDirty();
            }
            case 1: {
                return pSDEReportBase.isADPSDELogicNameDirty();
            }
            case 2: {
                return pSDEReportBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEReportBase.isContentTypeDirty();
            }
            case 4: {
                return pSDEReportBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEReportBase.isCreateManDirty();
            }
            case 6: {
                return pSDEReportBase.isCustomCodeDirty();
            }
            case 7: {
                return pSDEReportBase.isCustomModeDirty();
            }
            case 8: {
                return pSDEReportBase.isEnableAuditDirty();
            }
            case 9: {
                return pSDEReportBase.isEnableLogDirty();
            }
            case 10: {
                return pSDEReportBase.isExtendModeDirty();
            }
            case 11: {
                return pSDEReportBase.isLayoutPanelModeDirty();
            }
            case 12: {
                return pSDEReportBase.isLockFlagDirty();
            }
            case 13: {
                return pSDEReportBase.isLogicNameDirty();
            }
            case 14: {
                return pSDEReportBase.isMemoDirty();
            }
            case 15: {
                return pSDEReportBase.isMultiPageDirty();
            }
            case 16: {
                return pSDEReportBase.isPOTimeDirty();
            }
            case 17: {
                return pSDEReportBase.isPSDEDSIdDirty();
            }
            case 18: {
                return pSDEReportBase.isPSDEDSId2Dirty();
            }
            case 19: {
                return pSDEReportBase.isPSDEDSId3Dirty();
            }
            case 20: {
                return pSDEReportBase.isPSDEDSId4Dirty();
            }
            case 21: {
                return pSDEReportBase.isPSDEDSNameDirty();
            }
            case 22: {
                return pSDEReportBase.isPSDEDSName2Dirty();
            }
            case 23: {
                return pSDEReportBase.isPSDEDSName3Dirty();
            }
            case 24: {
                return pSDEReportBase.isPSDEDSName4Dirty();
            }
            case 25: {
                return pSDEReportBase.isPSDEIdDirty();
            }
            case 26: {
                return pSDEReportBase.isPSDENameDirty();
            }
            case 27: {
                return pSDEReportBase.isPSDEReportIdDirty();
            }
            case 28: {
                return pSDEReportBase.isPSDEReportNameDirty();
            }
            case 29: {
                return pSDEReportBase.isPSSysBICubeIdDirty();
            }
            case 30: {
                return pSDEReportBase.isPSSysBICubeNameDirty();
            }
            case 31: {
                return pSDEReportBase.isPSSysBIReportIdDirty();
            }
            case 32: {
                return pSDEReportBase.isPSSysBIReportNameDirty();
            }
            case 33: {
                return pSDEReportBase.isPSSysBISchemeIdDirty();
            }
            case 34: {
                return pSDEReportBase.isPSSysBISchemeNameDirty();
            }
            case 35: {
                return pSDEReportBase.isPSSysPFPluginIdDirty();
            }
            case 36: {
                return pSDEReportBase.isPSSysPFPluginNameDirty();
            }
            case 37: {
                return pSDEReportBase.isPSSysReqItemIdDirty();
            }
            case 38: {
                return pSDEReportBase.isPSSysReqItemNameDirty();
            }
            case 39: {
                return pSDEReportBase.isPSSysResourceIdDirty();
            }
            case 40: {
                return pSDEReportBase.isPSSysResourceNameDirty();
            }
            case 41: {
                return pSDEReportBase.isPSSysSFPluginIdDirty();
            }
            case 42: {
                return pSDEReportBase.isPSSysSFPluginNameDirty();
            }
            case 43: {
                return pSDEReportBase.isPSSysUniResIdDirty();
            }
            case 44: {
                return pSDEReportBase.isPSSysUniResNameDirty();
            }
            case 45: {
                return pSDEReportBase.isPSSysViewPanelIdDirty();
            }
            case 46: {
                return pSDEReportBase.isPSSysViewPanelNameDirty();
            }
            case 47: {
                return pSDEReportBase.isPSViewMsgGroupIdDirty();
            }
            case 48: {
                return pSDEReportBase.isPSViewMsgGroupNameDirty();
            }
            case 49: {
                return pSDEReportBase.isReportFileDirty();
            }
            case 50: {
                return pSDEReportBase.isReportModelDirty();
            }
            case 51: {
                return pSDEReportBase.isReportParamsDirty();
            }
            case 52: {
                return pSDEReportBase.isReportTagDirty();
            }
            case 53: {
                return pSDEReportBase.isReportTag2Dirty();
            }
            case 54: {
                return pSDEReportBase.isReportTypeDirty();
            }
            case 55: {
                return pSDEReportBase.isReportUIModelDirty();
            }
            case 56: {
                return pSDEReportBase.isToDoTaskDirty();
            }
            case 57: {
                return pSDEReportBase.isUpdateDateDirty();
            }
            case 58: {
                return pSDEReportBase.isUpdateManDirty();
            }
            case 59: {
                return pSDEReportBase.isUserCatDirty();
            }
            case 60: {
                return pSDEReportBase.isUserTagDirty();
            }
            case 61: {
                return pSDEReportBase.isUserTag2Dirty();
            }
            case 62: {
                return pSDEReportBase.isUserTag3Dirty();
            }
            case 63: {
                return pSDEReportBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEReportBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEReportBase pSDEReportBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEReportBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getContentType()), (boolean)false);
        }
        if (bl || pSDEReportBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEReportBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEReportBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEReportBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEReportBase.getEnableAudit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableaudit", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getEnableAudit()), (boolean)false);
        }
        if (bl || pSDEReportBase.getEnableLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelog", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getEnableLog()), (boolean)false);
        }
        if (bl || pSDEReportBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEReportBase.getLayoutPanelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutpanelmode", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getLayoutPanelMode()), (boolean)false);
        }
        if (bl || pSDEReportBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEReportBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEReportBase.getMultiPage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"multipage", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getMultiPage()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPOTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"potime", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPOTime()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid2", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSId2()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSId3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid3", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSId3()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSId4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid4", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSId4()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname2", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSName2()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSName3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname3", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSName3()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEDSName4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname4", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEDSName4()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEReportId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSDEReportName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysBIReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysBIReportId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysBIReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysBIReportName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysBISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemename", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysBISchemeName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEReportBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEReportBase.getReportFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reportfile", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getReportFile()), (boolean)false);
        }
        if (bl || pSDEReportBase.getReportModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reportmodel", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getReportModel()), (boolean)false);
        }
        if (bl || pSDEReportBase.getReportParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reportparams", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getReportParams()), (boolean)false);
        }
        if (bl || pSDEReportBase.getReportTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reporttag", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getReportTag()), (boolean)false);
        }
        if (bl || pSDEReportBase.getReportTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reporttag2", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getReportTag2()), (boolean)false);
        }
        if (bl || pSDEReportBase.getReportType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reporttype", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getReportType()), (boolean)false);
        }
        if (bl || pSDEReportBase.getReportUIModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reportuimodel", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getReportUIModel()), (boolean)false);
        }
        if (bl || pSDEReportBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEReportBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEReportBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEReportBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEReportBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEReportBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEReportBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEReportBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEReportBase.getJSONValue((Object)pSDEReportBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEReportBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEReportBase pSDEReportBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEReportBase.getADPSDELogicId() != null) {
            object = pSDEReportBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEReportBase.getADPSDELogicName() != null) {
            object = pSDEReportBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEReportBase.getCodeName() != null) {
            object = pSDEReportBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEReportBase.getContentType() != null) {
            object = pSDEReportBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getCreateDate() != null) {
            object = pSDEReportBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEReportBase.getCreateMan() != null) {
            object = pSDEReportBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getCustomCode() != null) {
            object = pSDEReportBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getCustomMode() != null) {
            object = pSDEReportBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getEnableAudit() != null) {
            object = pSDEReportBase.getEnableAudit();
            xmlNode.setAttribute(FIELD_ENABLEAUDIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getEnableLog() != null) {
            object = pSDEReportBase.getEnableLog();
            xmlNode.setAttribute(FIELD_ENABLELOG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getExtendMode() != null) {
            object = pSDEReportBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getLayoutPanelMode() != null) {
            object = pSDEReportBase.getLayoutPanelMode();
            xmlNode.setAttribute(FIELD_LAYOUTPANELMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getLockFlag() != null) {
            object = pSDEReportBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getLogicName() != null) {
            object = pSDEReportBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getMemo() != null) {
            object = pSDEReportBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getMultiPage() != null) {
            object = pSDEReportBase.getMultiPage();
            xmlNode.setAttribute(FIELD_MULTIPAGE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getPOTime() != null) {
            object = pSDEReportBase.getPOTime();
            xmlNode.setAttribute(FIELD_POTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEReportBase.getPSDEDSId() != null) {
            object = pSDEReportBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEDSId2() != null) {
            object = pSDEReportBase.getPSDEDSId2();
            xmlNode.setAttribute(FIELD_PSDEDSID2, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEDSId3() != null) {
            object = pSDEReportBase.getPSDEDSId3();
            xmlNode.setAttribute(FIELD_PSDEDSID3, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEDSId4() != null) {
            object = pSDEReportBase.getPSDEDSId4();
            xmlNode.setAttribute(FIELD_PSDEDSID4, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEDSName() != null) {
            object = pSDEReportBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEDSName2() != null) {
            object = pSDEReportBase.getPSDEDSName2();
            xmlNode.setAttribute(FIELD_PSDEDSNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEDSName3() != null) {
            object = pSDEReportBase.getPSDEDSName3();
            xmlNode.setAttribute(FIELD_PSDEDSNAME3, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEDSName4() != null) {
            object = pSDEReportBase.getPSDEDSName4();
            xmlNode.setAttribute(FIELD_PSDEDSNAME4, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEId() != null) {
            object = pSDEReportBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEName() != null) {
            object = pSDEReportBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEReportId() != null) {
            object = pSDEReportBase.getPSDEReportId();
            xmlNode.setAttribute(FIELD_PSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSDEReportName() != null) {
            object = pSDEReportBase.getPSDEReportName();
            xmlNode.setAttribute(FIELD_PSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysBICubeId() != null) {
            object = pSDEReportBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysBICubeName() != null) {
            object = pSDEReportBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysBIReportId() != null) {
            object = pSDEReportBase.getPSSysBIReportId();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysBIReportName() != null) {
            object = pSDEReportBase.getPSSysBIReportName();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysBISchemeId() != null) {
            object = pSDEReportBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysBISchemeName() != null) {
            object = pSDEReportBase.getPSSysBISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysPFPluginId() != null) {
            object = pSDEReportBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysPFPluginName() != null) {
            object = pSDEReportBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysReqItemId() != null) {
            object = pSDEReportBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysReqItemName() != null) {
            object = pSDEReportBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysResourceId() != null) {
            object = pSDEReportBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysResourceName() != null) {
            object = pSDEReportBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysSFPluginId() != null) {
            object = pSDEReportBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysSFPluginName() != null) {
            object = pSDEReportBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysUniResId() != null) {
            object = pSDEReportBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysUniResName() != null) {
            object = pSDEReportBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysViewPanelId() != null) {
            object = pSDEReportBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSSysViewPanelName() != null) {
            object = pSDEReportBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSViewMsgGroupId() != null) {
            object = pSDEReportBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getPSViewMsgGroupName() != null) {
            object = pSDEReportBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getReportFile() != null) {
            object = pSDEReportBase.getReportFile();
            xmlNode.setAttribute(FIELD_REPORTFILE, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getReportModel() != null) {
            object = pSDEReportBase.getReportModel();
            xmlNode.setAttribute(FIELD_REPORTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getReportParams() != null) {
            object = pSDEReportBase.getReportParams();
            xmlNode.setAttribute(FIELD_REPORTPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getReportTag() != null) {
            object = pSDEReportBase.getReportTag();
            xmlNode.setAttribute(FIELD_REPORTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getReportTag2() != null) {
            object = pSDEReportBase.getReportTag2();
            xmlNode.setAttribute(FIELD_REPORTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getReportType() != null) {
            object = pSDEReportBase.getReportType();
            xmlNode.setAttribute(FIELD_REPORTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getReportUIModel() != null) {
            object = pSDEReportBase.getReportUIModel();
            xmlNode.setAttribute(FIELD_REPORTUIMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getToDoTask() != null) {
            object = pSDEReportBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getUpdateDate() != null) {
            object = pSDEReportBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEReportBase.getUpdateMan() != null) {
            object = pSDEReportBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getUserCat() != null) {
            object = pSDEReportBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getUserTag() != null) {
            object = pSDEReportBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getUserTag2() != null) {
            object = pSDEReportBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getUserTag3() != null) {
            object = pSDEReportBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEReportBase.getUserTag4() != null) {
            object = pSDEReportBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEReportBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEReportBase pSDEReportBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEReportBase.isADPSDELogicIdDirty() && (bl || pSDEReportBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSDEReportBase.getADPSDELogicId());
        }
        if (pSDEReportBase.isADPSDELogicNameDirty() && (bl || pSDEReportBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSDEReportBase.getADPSDELogicName());
        }
        if (pSDEReportBase.isCodeNameDirty() && (bl || pSDEReportBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEReportBase.getCodeName());
        }
        if (pSDEReportBase.isContentTypeDirty() && (bl || pSDEReportBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDEReportBase.getContentType());
        }
        if (pSDEReportBase.isCreateDateDirty() && (bl || pSDEReportBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEReportBase.getCreateDate());
        }
        if (pSDEReportBase.isCreateManDirty() && (bl || pSDEReportBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEReportBase.getCreateMan());
        }
        if (pSDEReportBase.isCustomCodeDirty() && (bl || pSDEReportBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEReportBase.getCustomCode());
        }
        if (pSDEReportBase.isCustomModeDirty() && (bl || pSDEReportBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEReportBase.getCustomMode());
        }
        if (pSDEReportBase.isEnableAuditDirty() && (bl || pSDEReportBase.getEnableAudit() != null)) {
            iDataObject.set(FIELD_ENABLEAUDIT, (Object)pSDEReportBase.getEnableAudit());
        }
        if (pSDEReportBase.isEnableLogDirty() && (bl || pSDEReportBase.getEnableLog() != null)) {
            iDataObject.set(FIELD_ENABLELOG, (Object)pSDEReportBase.getEnableLog());
        }
        if (pSDEReportBase.isExtendModeDirty() && (bl || pSDEReportBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEReportBase.getExtendMode());
        }
        if (pSDEReportBase.isLayoutPanelModeDirty() && (bl || pSDEReportBase.getLayoutPanelMode() != null)) {
            iDataObject.set(FIELD_LAYOUTPANELMODE, (Object)pSDEReportBase.getLayoutPanelMode());
        }
        if (pSDEReportBase.isLockFlagDirty() && (bl || pSDEReportBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEReportBase.getLockFlag());
        }
        if (pSDEReportBase.isLogicNameDirty() && (bl || pSDEReportBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEReportBase.getLogicName());
        }
        if (pSDEReportBase.isMemoDirty() && (bl || pSDEReportBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEReportBase.getMemo());
        }
        if (pSDEReportBase.isMultiPageDirty() && (bl || pSDEReportBase.getMultiPage() != null)) {
            iDataObject.set(FIELD_MULTIPAGE, (Object)pSDEReportBase.getMultiPage());
        }
        if (pSDEReportBase.isPOTimeDirty() && (bl || pSDEReportBase.getPOTime() != null)) {
            iDataObject.set(FIELD_POTIME, (Object)pSDEReportBase.getPOTime());
        }
        if (pSDEReportBase.isPSDEDSIdDirty() && (bl || pSDEReportBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDEReportBase.getPSDEDSId());
        }
        if (pSDEReportBase.isPSDEDSId2Dirty() && (bl || pSDEReportBase.getPSDEDSId2() != null)) {
            iDataObject.set(FIELD_PSDEDSID2, (Object)pSDEReportBase.getPSDEDSId2());
        }
        if (pSDEReportBase.isPSDEDSId3Dirty() && (bl || pSDEReportBase.getPSDEDSId3() != null)) {
            iDataObject.set(FIELD_PSDEDSID3, (Object)pSDEReportBase.getPSDEDSId3());
        }
        if (pSDEReportBase.isPSDEDSId4Dirty() && (bl || pSDEReportBase.getPSDEDSId4() != null)) {
            iDataObject.set(FIELD_PSDEDSID4, (Object)pSDEReportBase.getPSDEDSId4());
        }
        if (pSDEReportBase.isPSDEDSNameDirty() && (bl || pSDEReportBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDEReportBase.getPSDEDSName());
        }
        if (pSDEReportBase.isPSDEDSName2Dirty() && (bl || pSDEReportBase.getPSDEDSName2() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME2, (Object)pSDEReportBase.getPSDEDSName2());
        }
        if (pSDEReportBase.isPSDEDSName3Dirty() && (bl || pSDEReportBase.getPSDEDSName3() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME3, (Object)pSDEReportBase.getPSDEDSName3());
        }
        if (pSDEReportBase.isPSDEDSName4Dirty() && (bl || pSDEReportBase.getPSDEDSName4() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME4, (Object)pSDEReportBase.getPSDEDSName4());
        }
        if (pSDEReportBase.isPSDEIdDirty() && (bl || pSDEReportBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEReportBase.getPSDEId());
        }
        if (pSDEReportBase.isPSDENameDirty() && (bl || pSDEReportBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEReportBase.getPSDEName());
        }
        if (pSDEReportBase.isPSDEReportIdDirty() && (bl || pSDEReportBase.getPSDEReportId() != null)) {
            iDataObject.set(FIELD_PSDEREPORTID, (Object)pSDEReportBase.getPSDEReportId());
        }
        if (pSDEReportBase.isPSDEReportNameDirty() && (bl || pSDEReportBase.getPSDEReportName() != null)) {
            iDataObject.set(FIELD_PSDEREPORTNAME, (Object)pSDEReportBase.getPSDEReportName());
        }
        if (pSDEReportBase.isPSSysBICubeIdDirty() && (bl || pSDEReportBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSDEReportBase.getPSSysBICubeId());
        }
        if (pSDEReportBase.isPSSysBICubeNameDirty() && (bl || pSDEReportBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSDEReportBase.getPSSysBICubeName());
        }
        if (pSDEReportBase.isPSSysBIReportIdDirty() && (bl || pSDEReportBase.getPSSysBIReportId() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTID, (Object)pSDEReportBase.getPSSysBIReportId());
        }
        if (pSDEReportBase.isPSSysBIReportNameDirty() && (bl || pSDEReportBase.getPSSysBIReportName() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTNAME, (Object)pSDEReportBase.getPSSysBIReportName());
        }
        if (pSDEReportBase.isPSSysBISchemeIdDirty() && (bl || pSDEReportBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSDEReportBase.getPSSysBISchemeId());
        }
        if (pSDEReportBase.isPSSysBISchemeNameDirty() && (bl || pSDEReportBase.getPSSysBISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMENAME, (Object)pSDEReportBase.getPSSysBISchemeName());
        }
        if (pSDEReportBase.isPSSysPFPluginIdDirty() && (bl || pSDEReportBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEReportBase.getPSSysPFPluginId());
        }
        if (pSDEReportBase.isPSSysPFPluginNameDirty() && (bl || pSDEReportBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEReportBase.getPSSysPFPluginName());
        }
        if (pSDEReportBase.isPSSysReqItemIdDirty() && (bl || pSDEReportBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEReportBase.getPSSysReqItemId());
        }
        if (pSDEReportBase.isPSSysReqItemNameDirty() && (bl || pSDEReportBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEReportBase.getPSSysReqItemName());
        }
        if (pSDEReportBase.isPSSysResourceIdDirty() && (bl || pSDEReportBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSDEReportBase.getPSSysResourceId());
        }
        if (pSDEReportBase.isPSSysResourceNameDirty() && (bl || pSDEReportBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSDEReportBase.getPSSysResourceName());
        }
        if (pSDEReportBase.isPSSysSFPluginIdDirty() && (bl || pSDEReportBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEReportBase.getPSSysSFPluginId());
        }
        if (pSDEReportBase.isPSSysSFPluginNameDirty() && (bl || pSDEReportBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEReportBase.getPSSysSFPluginName());
        }
        if (pSDEReportBase.isPSSysUniResIdDirty() && (bl || pSDEReportBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDEReportBase.getPSSysUniResId());
        }
        if (pSDEReportBase.isPSSysUniResNameDirty() && (bl || pSDEReportBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDEReportBase.getPSSysUniResName());
        }
        if (pSDEReportBase.isPSSysViewPanelIdDirty() && (bl || pSDEReportBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEReportBase.getPSSysViewPanelId());
        }
        if (pSDEReportBase.isPSSysViewPanelNameDirty() && (bl || pSDEReportBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEReportBase.getPSSysViewPanelName());
        }
        if (pSDEReportBase.isPSViewMsgGroupIdDirty() && (bl || pSDEReportBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEReportBase.getPSViewMsgGroupId());
        }
        if (pSDEReportBase.isPSViewMsgGroupNameDirty() && (bl || pSDEReportBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEReportBase.getPSViewMsgGroupName());
        }
        if (pSDEReportBase.isReportFileDirty() && (bl || pSDEReportBase.getReportFile() != null)) {
            iDataObject.set(FIELD_REPORTFILE, (Object)pSDEReportBase.getReportFile());
        }
        if (pSDEReportBase.isReportModelDirty() && (bl || pSDEReportBase.getReportModel() != null)) {
            iDataObject.set(FIELD_REPORTMODEL, (Object)pSDEReportBase.getReportModel());
        }
        if (pSDEReportBase.isReportParamsDirty() && (bl || pSDEReportBase.getReportParams() != null)) {
            iDataObject.set(FIELD_REPORTPARAMS, (Object)pSDEReportBase.getReportParams());
        }
        if (pSDEReportBase.isReportTagDirty() && (bl || pSDEReportBase.getReportTag() != null)) {
            iDataObject.set(FIELD_REPORTTAG, (Object)pSDEReportBase.getReportTag());
        }
        if (pSDEReportBase.isReportTag2Dirty() && (bl || pSDEReportBase.getReportTag2() != null)) {
            iDataObject.set(FIELD_REPORTTAG2, (Object)pSDEReportBase.getReportTag2());
        }
        if (pSDEReportBase.isReportTypeDirty() && (bl || pSDEReportBase.getReportType() != null)) {
            iDataObject.set(FIELD_REPORTTYPE, (Object)pSDEReportBase.getReportType());
        }
        if (pSDEReportBase.isReportUIModelDirty() && (bl || pSDEReportBase.getReportUIModel() != null)) {
            iDataObject.set(FIELD_REPORTUIMODEL, (Object)pSDEReportBase.getReportUIModel());
        }
        if (pSDEReportBase.isToDoTaskDirty() && (bl || pSDEReportBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEReportBase.getToDoTask());
        }
        if (pSDEReportBase.isUpdateDateDirty() && (bl || pSDEReportBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEReportBase.getUpdateDate());
        }
        if (pSDEReportBase.isUpdateManDirty() && (bl || pSDEReportBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEReportBase.getUpdateMan());
        }
        if (pSDEReportBase.isUserCatDirty() && (bl || pSDEReportBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEReportBase.getUserCat());
        }
        if (pSDEReportBase.isUserTagDirty() && (bl || pSDEReportBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEReportBase.getUserTag());
        }
        if (pSDEReportBase.isUserTag2Dirty() && (bl || pSDEReportBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEReportBase.getUserTag2());
        }
        if (pSDEReportBase.isUserTag3Dirty() && (bl || pSDEReportBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEReportBase.getUserTag3());
        }
        if (pSDEReportBase.isUserTag4Dirty() && (bl || pSDEReportBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEReportBase.getUserTag4());
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
        return PSDEReportBase.remove(this, n);
    }

    private static boolean remove(PSDEReportBase pSDEReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEReportBase.resetADPSDELogicId();
                return true;
            }
            case 1: {
                pSDEReportBase.resetADPSDELogicName();
                return true;
            }
            case 2: {
                pSDEReportBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEReportBase.resetContentType();
                return true;
            }
            case 4: {
                pSDEReportBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEReportBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEReportBase.resetCustomCode();
                return true;
            }
            case 7: {
                pSDEReportBase.resetCustomMode();
                return true;
            }
            case 8: {
                pSDEReportBase.resetEnableAudit();
                return true;
            }
            case 9: {
                pSDEReportBase.resetEnableLog();
                return true;
            }
            case 10: {
                pSDEReportBase.resetExtendMode();
                return true;
            }
            case 11: {
                pSDEReportBase.resetLayoutPanelMode();
                return true;
            }
            case 12: {
                pSDEReportBase.resetLockFlag();
                return true;
            }
            case 13: {
                pSDEReportBase.resetLogicName();
                return true;
            }
            case 14: {
                pSDEReportBase.resetMemo();
                return true;
            }
            case 15: {
                pSDEReportBase.resetMultiPage();
                return true;
            }
            case 16: {
                pSDEReportBase.resetPOTime();
                return true;
            }
            case 17: {
                pSDEReportBase.resetPSDEDSId();
                return true;
            }
            case 18: {
                pSDEReportBase.resetPSDEDSId2();
                return true;
            }
            case 19: {
                pSDEReportBase.resetPSDEDSId3();
                return true;
            }
            case 20: {
                pSDEReportBase.resetPSDEDSId4();
                return true;
            }
            case 21: {
                pSDEReportBase.resetPSDEDSName();
                return true;
            }
            case 22: {
                pSDEReportBase.resetPSDEDSName2();
                return true;
            }
            case 23: {
                pSDEReportBase.resetPSDEDSName3();
                return true;
            }
            case 24: {
                pSDEReportBase.resetPSDEDSName4();
                return true;
            }
            case 25: {
                pSDEReportBase.resetPSDEId();
                return true;
            }
            case 26: {
                pSDEReportBase.resetPSDEName();
                return true;
            }
            case 27: {
                pSDEReportBase.resetPSDEReportId();
                return true;
            }
            case 28: {
                pSDEReportBase.resetPSDEReportName();
                return true;
            }
            case 29: {
                pSDEReportBase.resetPSSysBICubeId();
                return true;
            }
            case 30: {
                pSDEReportBase.resetPSSysBICubeName();
                return true;
            }
            case 31: {
                pSDEReportBase.resetPSSysBIReportId();
                return true;
            }
            case 32: {
                pSDEReportBase.resetPSSysBIReportName();
                return true;
            }
            case 33: {
                pSDEReportBase.resetPSSysBISchemeId();
                return true;
            }
            case 34: {
                pSDEReportBase.resetPSSysBISchemeName();
                return true;
            }
            case 35: {
                pSDEReportBase.resetPSSysPFPluginId();
                return true;
            }
            case 36: {
                pSDEReportBase.resetPSSysPFPluginName();
                return true;
            }
            case 37: {
                pSDEReportBase.resetPSSysReqItemId();
                return true;
            }
            case 38: {
                pSDEReportBase.resetPSSysReqItemName();
                return true;
            }
            case 39: {
                pSDEReportBase.resetPSSysResourceId();
                return true;
            }
            case 40: {
                pSDEReportBase.resetPSSysResourceName();
                return true;
            }
            case 41: {
                pSDEReportBase.resetPSSysSFPluginId();
                return true;
            }
            case 42: {
                pSDEReportBase.resetPSSysSFPluginName();
                return true;
            }
            case 43: {
                pSDEReportBase.resetPSSysUniResId();
                return true;
            }
            case 44: {
                pSDEReportBase.resetPSSysUniResName();
                return true;
            }
            case 45: {
                pSDEReportBase.resetPSSysViewPanelId();
                return true;
            }
            case 46: {
                pSDEReportBase.resetPSSysViewPanelName();
                return true;
            }
            case 47: {
                pSDEReportBase.resetPSViewMsgGroupId();
                return true;
            }
            case 48: {
                pSDEReportBase.resetPSViewMsgGroupName();
                return true;
            }
            case 49: {
                pSDEReportBase.resetReportFile();
                return true;
            }
            case 50: {
                pSDEReportBase.resetReportModel();
                return true;
            }
            case 51: {
                pSDEReportBase.resetReportParams();
                return true;
            }
            case 52: {
                pSDEReportBase.resetReportTag();
                return true;
            }
            case 53: {
                pSDEReportBase.resetReportTag2();
                return true;
            }
            case 54: {
                pSDEReportBase.resetReportType();
                return true;
            }
            case 55: {
                pSDEReportBase.resetReportUIModel();
                return true;
            }
            case 56: {
                pSDEReportBase.resetToDoTask();
                return true;
            }
            case 57: {
                pSDEReportBase.resetUpdateDate();
                return true;
            }
            case 58: {
                pSDEReportBase.resetUpdateMan();
                return true;
            }
            case 59: {
                pSDEReportBase.resetUserCat();
                return true;
            }
            case 60: {
                pSDEReportBase.resetUserTag();
                return true;
            }
            case 61: {
                pSDEReportBase.resetUserTag2();
                return true;
            }
            case 62: {
                pSDEReportBase.resetUserTag3();
                return true;
            }
            case 63: {
                pSDEReportBase.resetUserTag4();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS2();
        }
        if (this.getPSDEDSId2() == null) {
            return null;
        }
        Integer n = this.objPSDEDS2Lock;
        synchronized (n) {
            if (this.psdeds2 != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId2(), (Object)this.psdeds2.getPSDEDataSetId()) != 0L) {
                this.psdeds2 = null;
            }
            if (this.psdeds2 == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId2());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds2 = pSDEDataSet;
            }
            return this.psdeds2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS3() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS3();
        }
        if (this.getPSDEDSId3() == null) {
            return null;
        }
        Integer n = this.objPSDEDS3Lock;
        synchronized (n) {
            if (this.psdeds3 != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId3(), (Object)this.psdeds3.getPSDEDataSetId()) != 0L) {
                this.psdeds3 = null;
            }
            if (this.psdeds3 == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId3());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds3 = pSDEDataSet;
            }
            return this.psdeds3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDS4() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS4();
        }
        if (this.getPSDEDSId4() == null) {
            return null;
        }
        Integer n = this.objPSDEDS4Lock;
        synchronized (n) {
            if (this.psdeds4 != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId4(), (Object)this.psdeds4.getPSDEDataSetId()) != 0L) {
                this.psdeds4 = null;
            }
            if (this.psdeds4 == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId4());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds4 = pSDEDataSet;
            }
            return this.psdeds4;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getADPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getADPSDELogic();
        }
        if (this.getADPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objADPSDELogicLock;
        synchronized (n) {
            if (this.adpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getADPSDELogicId(), (Object)this.adpsdelogic.getPSDELogicId()) != 0L) {
                this.adpsdelogic = null;
            }
            if (this.adpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getADPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.adpsdelogic = pSDELogic;
            }
            return this.adpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICube getPSSysBICube() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICube();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeLock;
        synchronized (n) {
            if (this.pssysbicube != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeId(), (Object)this.pssysbicube.getPSSysBICubeId()) != 0L) {
                this.pssysbicube = null;
            }
            if (this.pssysbicube == null) {
                PSSysBICube pSSysBICube = new PSSysBICube();
                pSSysBICube.setPSSysBICubeId(this.getPSSysBICubeId());
                PSSysBICubeService pSSysBICubeService = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeService.autoGet((IEntity)pSSysBICube);
                this.pssysbicube = pSSysBICube;
            }
            return this.pssysbicube;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIReport getPSSysBIReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReport();
        }
        if (this.getPSSysBIReportId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIReportLock;
        synchronized (n) {
            if (this.pssysbireport != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIReportId(), (Object)this.pssysbireport.getPSSysBIReportId()) != 0L) {
                this.pssysbireport = null;
            }
            if (this.pssysbireport == null) {
                PSSysBIReport pSSysBIReport = new PSSysBIReport();
                pSSysBIReport.setPSSysBIReportId(this.getPSSysBIReportId());
                PSSysBIReportService pSSysBIReportService = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIReportService.autoGet((IEntity)pSSysBIReport);
                this.pssysbireport = pSSysBIReport;
            }
            return this.pssysbireport;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIScheme getPSSysBIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIScheme();
        }
        if (this.getPSSysBISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBISchemeLock;
        synchronized (n) {
            if (this.pssysbischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBISchemeId(), (Object)this.pssysbischeme.getPSSysBISchemeId()) != 0L) {
                this.pssysbischeme = null;
            }
            if (this.pssysbischeme == null) {
                PSSysBIScheme pSSysBIScheme = new PSSysBIScheme();
                pSSysBIScheme.setPSSysBISchemeId(this.getPSSysBISchemeId());
                PSSysBISchemeService pSSysBISchemeService = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBISchemeService.autoGet((IEntity)pSSysBIScheme);
                this.pssysbischeme = pSSysBIScheme;
            }
            return this.pssysbischeme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewMsgGroup getPSViewMsgGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroup();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgGroupLock;
        synchronized (n) {
            if (this.psviewmsggroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgGroupId(), (Object)this.psviewmsggroup.getPSViewMsgGroupId()) != 0L) {
                this.psviewmsggroup = null;
            }
            if (this.psviewmsggroup == null) {
                PSViewMsgGroup pSViewMsgGroup = new PSViewMsgGroup();
                pSViewMsgGroup.setPSViewMsgGroupId(this.getPSViewMsgGroupId());
                PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgGroupService.autoGet((IEntity)pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    private PSDEReportBase getProxyEntity() {
        return this.proxyPSDEReportBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEReportBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEReportBase) {
            this.proxyPSDEReportBase = (PSDEReportBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 0);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 6);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 7);
        fieldIndexMap.put(FIELD_ENABLEAUDIT, 8);
        fieldIndexMap.put(FIELD_ENABLELOG, 9);
        fieldIndexMap.put(FIELD_EXTENDMODE, 10);
        fieldIndexMap.put(FIELD_LAYOUTPANELMODE, 11);
        fieldIndexMap.put(FIELD_LOCKFLAG, 12);
        fieldIndexMap.put(FIELD_LOGICNAME, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_MULTIPAGE, 15);
        fieldIndexMap.put(FIELD_POTIME, 16);
        fieldIndexMap.put(FIELD_PSDEDSID, 17);
        fieldIndexMap.put(FIELD_PSDEDSID2, 18);
        fieldIndexMap.put(FIELD_PSDEDSID3, 19);
        fieldIndexMap.put(FIELD_PSDEDSID4, 20);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 21);
        fieldIndexMap.put(FIELD_PSDEDSNAME2, 22);
        fieldIndexMap.put(FIELD_PSDEDSNAME3, 23);
        fieldIndexMap.put(FIELD_PSDEDSNAME4, 24);
        fieldIndexMap.put(FIELD_PSDEID, 25);
        fieldIndexMap.put(FIELD_PSDENAME, 26);
        fieldIndexMap.put(FIELD_PSDEREPORTID, 27);
        fieldIndexMap.put(FIELD_PSDEREPORTNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 29);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 30);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTID, 31);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 33);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMENAME, 34);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 35);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 37);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 39);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 40);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 41);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 42);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 43);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 44);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 45);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 46);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 47);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 48);
        fieldIndexMap.put(FIELD_REPORTFILE, 49);
        fieldIndexMap.put(FIELD_REPORTMODEL, 50);
        fieldIndexMap.put(FIELD_REPORTPARAMS, 51);
        fieldIndexMap.put(FIELD_REPORTTAG, 52);
        fieldIndexMap.put(FIELD_REPORTTAG2, 53);
        fieldIndexMap.put(FIELD_REPORTTYPE, 54);
        fieldIndexMap.put(FIELD_REPORTUIMODEL, 55);
        fieldIndexMap.put(FIELD_TODOTASK, 56);
        fieldIndexMap.put(FIELD_UPDATEDATE, 57);
        fieldIndexMap.put(FIELD_UPDATEMAN, 58);
        fieldIndexMap.put(FIELD_USERCAT, 59);
        fieldIndexMap.put(FIELD_USERTAG, 60);
        fieldIndexMap.put(FIELD_USERTAG2, 61);
        fieldIndexMap.put(FIELD_USERTAG3, 62);
        fieldIndexMap.put(FIELD_USERTAG4, 63);
    }
}

