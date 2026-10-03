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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
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

public abstract class PSDEPrintBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEPrintBase.class);
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String FIELD_ENABLELOG = "ENABLELOG";
    public static final String FIELD_ENABLEMP = "ENABLEMP";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_GETDATAPSDEACTIONID = "GETDATAPSDEACTIONID";
    public static final String FIELD_GETDATAPSDEACTIONNAME = "GETDATAPSDEACTIONNAME";
    public static final String FIELD_LAYOUTPANELMODE = "LAYOUTPANELMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_POTIME = "POTIME";
    public static final String FIELD_PRINTMODEL = "PRINTMODEL";
    public static final String FIELD_PRINTPARAMS = "PRINTPARAMS";
    public static final String FIELD_PRINTTAG = "PRINTTAG";
    public static final String FIELD_PRINTTAG2 = "PRINTTAG2";
    public static final String FIELD_PRINTUIMODEL = "PRINTUIMODEL";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEPRINTID = "PSDEPRINTID";
    public static final String FIELD_PSDEPRINTNAME = "PSDEPRINTNAME";
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
    public static final String FIELD_READPSDEOPPRIVID = "READPSDEOPPRIVID";
    public static final String FIELD_READPSDEOPPRIVNAME = "READPSDEOPPRIVNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_REPORTFILE = "REPORTFILE";
    public static final String FIELD_REPORTTYPE = "REPORTTYPE";
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
    private static final int INDEX_DEFAULTMODE = 8;
    private static final int INDEX_ENABLECOLPRIV = 9;
    private static final int INDEX_ENABLELOG = 10;
    private static final int INDEX_ENABLEMP = 11;
    private static final int INDEX_EXTENDMODE = 12;
    private static final int INDEX_GETDATAPSDEACTIONID = 13;
    private static final int INDEX_GETDATAPSDEACTIONNAME = 14;
    private static final int INDEX_LAYOUTPANELMODE = 15;
    private static final int INDEX_LOCKFLAG = 16;
    private static final int INDEX_LOGICNAME = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_POTIME = 19;
    private static final int INDEX_PRINTMODEL = 20;
    private static final int INDEX_PRINTPARAMS = 21;
    private static final int INDEX_PRINTTAG = 22;
    private static final int INDEX_PRINTTAG2 = 23;
    private static final int INDEX_PRINTUIMODEL = 24;
    private static final int INDEX_PSDEDATASETID = 25;
    private static final int INDEX_PSDEDATASETNAME = 26;
    private static final int INDEX_PSDEID = 27;
    private static final int INDEX_PSDENAME = 28;
    private static final int INDEX_PSDEPRINTID = 29;
    private static final int INDEX_PSDEPRINTNAME = 30;
    private static final int INDEX_PSSYSPFPLUGINID = 31;
    private static final int INDEX_PSSYSPFPLUGINNAME = 32;
    private static final int INDEX_PSSYSREQITEMID = 33;
    private static final int INDEX_PSSYSREQITEMNAME = 34;
    private static final int INDEX_PSSYSRESOURCEID = 35;
    private static final int INDEX_PSSYSRESOURCENAME = 36;
    private static final int INDEX_PSSYSSFPLUGINID = 37;
    private static final int INDEX_PSSYSSFPLUGINNAME = 38;
    private static final int INDEX_PSSYSUNIRESID = 39;
    private static final int INDEX_PSSYSUNIRESNAME = 40;
    private static final int INDEX_PSSYSVIEWPANELID = 41;
    private static final int INDEX_PSSYSVIEWPANELNAME = 42;
    private static final int INDEX_PSVIEWMSGGROUPID = 43;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 44;
    private static final int INDEX_READPSDEOPPRIVID = 45;
    private static final int INDEX_READPSDEOPPRIVNAME = 46;
    private static final int INDEX_REFPSDEID = 47;
    private static final int INDEX_REFPSDENAME = 48;
    private static final int INDEX_REPORTFILE = 49;
    private static final int INDEX_REPORTTYPE = 50;
    private static final int INDEX_TODOTASK = 51;
    private static final int INDEX_UPDATEDATE = 52;
    private static final int INDEX_UPDATEMAN = 53;
    private static final int INDEX_USERCAT = 54;
    private static final int INDEX_USERTAG = 55;
    private static final int INDEX_USERTAG2 = 56;
    private static final int INDEX_USERTAG3 = 57;
    private static final int INDEX_USERTAG4 = 58;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEPrintBase proxyPSDEPrintBase = null;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean enablecolprivDirtyFlag = false;
    private boolean enablelogDirtyFlag = false;
    private boolean enablempDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean getdatapsdeactionidDirtyFlag = false;
    private boolean getdatapsdeactionnameDirtyFlag = false;
    private boolean layoutpanelmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean potimeDirtyFlag = false;
    private boolean printmodelDirtyFlag = false;
    private boolean printparamsDirtyFlag = false;
    private boolean printtagDirtyFlag = false;
    private boolean printtag2DirtyFlag = false;
    private boolean printuimodelDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeprintidDirtyFlag = false;
    private boolean psdeprintnameDirtyFlag = false;
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
    private boolean readpsdeopprividDirtyFlag = false;
    private boolean readpsdeopprivnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean reportfileDirtyFlag = false;
    private boolean reporttypeDirtyFlag = false;
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
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="enablecolpriv")
    private Integer enablecolpriv;
    @Column(name="enablelog")
    private Integer enablelog;
    @Column(name="enablemp")
    private Integer enablemp;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="getdatapsdeactionid")
    private String getdatapsdeactionid;
    @Column(name="getdatapsdeactionname")
    private String getdatapsdeactionname;
    @Column(name="layoutpanelmode")
    private Integer layoutpanelmode;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="potime")
    private Integer potime;
    @Column(name="printmodel")
    private String printmodel;
    @Column(name="printparams")
    private String printparams;
    @Column(name="printtag")
    private String printtag;
    @Column(name="printtag2")
    private String printtag2;
    @Column(name="printuimodel")
    private String printuimodel;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeprintid")
    private String psdeprintid;
    @Column(name="psdeprintname")
    private String psdeprintname;
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
    @Column(name="readpsdeopprivid")
    private String readpsdeopprivid;
    @Column(name="readpsdeopprivname")
    private String readpsdeopprivname;
    @Column(name="refpsdeid")
    private String refpsdeid;
    @Column(name="refpsdename")
    private String refpsdename;
    @Column(name="reportfile")
    private String reportfile;
    @Column(name="reporttype")
    private String reporttype;
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
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objGetDataPSDEActionLock = new Integer(1);
    private PSDEAction getdatapsdeaction = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objReadPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv readpsdeoppriv = null;
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

    public void setDefaultMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(n);
            return;
        }
        this.defaultmode = n;
        this.defaultmodeDirtyFlag = true;
    }

    public Integer getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
    }

    public void setEnableColPriv(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableColPriv(n);
            return;
        }
        this.enablecolpriv = n;
        this.enablecolprivDirtyFlag = true;
    }

    public Integer getEnableColPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableColPriv();
        }
        return this.enablecolpriv;
    }

    public boolean isEnableColPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableColPrivDirty();
        }
        return this.enablecolprivDirtyFlag;
    }

    public void resetEnableColPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableColPriv();
            return;
        }
        this.enablecolprivDirtyFlag = false;
        this.enablecolpriv = null;
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

    public void setEnableMP(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMP(n);
            return;
        }
        this.enablemp = n;
        this.enablempDirtyFlag = true;
    }

    public Integer getEnableMP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMP();
        }
        return this.enablemp;
    }

    public boolean isEnableMPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMPDirty();
        }
        return this.enablempDirtyFlag;
    }

    public void resetEnableMP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMP();
            return;
        }
        this.enablempDirtyFlag = false;
        this.enablemp = null;
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

    public void setGetDataPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDataPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getdatapsdeactionid = string;
        this.getdatapsdeactionidDirtyFlag = true;
    }

    public String getGetDataPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDataPSDEActionId();
        }
        return this.getdatapsdeactionid;
    }

    public boolean isGetDataPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDataPSDEActionIdDirty();
        }
        return this.getdatapsdeactionidDirtyFlag;
    }

    public void resetGetDataPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDataPSDEActionId();
            return;
        }
        this.getdatapsdeactionidDirtyFlag = false;
        this.getdatapsdeactionid = null;
    }

    public void setGetDataPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDataPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getdatapsdeactionname = string;
        this.getdatapsdeactionnameDirtyFlag = true;
    }

    public String getGetDataPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDataPSDEActionName();
        }
        return this.getdatapsdeactionname;
    }

    public boolean isGetDataPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDataPSDEActionNameDirty();
        }
        return this.getdatapsdeactionnameDirtyFlag;
    }

    public void resetGetDataPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDataPSDEActionName();
            return;
        }
        this.getdatapsdeactionnameDirtyFlag = false;
        this.getdatapsdeactionname = null;
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

    public void setPrintModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrintModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.printmodel = string;
        this.printmodelDirtyFlag = true;
    }

    public String getPrintModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrintModel();
        }
        return this.printmodel;
    }

    public boolean isPrintModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrintModelDirty();
        }
        return this.printmodelDirtyFlag;
    }

    public void resetPrintModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrintModel();
            return;
        }
        this.printmodelDirtyFlag = false;
        this.printmodel = null;
    }

    public void setPrintParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrintParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.printparams = string;
        this.printparamsDirtyFlag = true;
    }

    public String getPrintParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrintParams();
        }
        return this.printparams;
    }

    public boolean isPrintParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrintParamsDirty();
        }
        return this.printparamsDirtyFlag;
    }

    public void resetPrintParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrintParams();
            return;
        }
        this.printparamsDirtyFlag = false;
        this.printparams = null;
    }

    public void setPrintTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrintTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.printtag = string;
        this.printtagDirtyFlag = true;
    }

    public String getPrintTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrintTag();
        }
        return this.printtag;
    }

    public boolean isPrintTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrintTagDirty();
        }
        return this.printtagDirtyFlag;
    }

    public void resetPrintTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrintTag();
            return;
        }
        this.printtagDirtyFlag = false;
        this.printtag = null;
    }

    public void setPrintTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrintTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.printtag2 = string;
        this.printtag2DirtyFlag = true;
    }

    public String getPrintTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrintTag2();
        }
        return this.printtag2;
    }

    public boolean isPrintTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrintTag2Dirty();
        }
        return this.printtag2DirtyFlag;
    }

    public void resetPrintTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrintTag2();
            return;
        }
        this.printtag2DirtyFlag = false;
        this.printtag2 = null;
    }

    public void setPrintUIModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrintUIModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.printuimodel = string;
        this.printuimodelDirtyFlag = true;
    }

    public String getPrintUIModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrintUIModel();
        }
        return this.printuimodel;
    }

    public boolean isPrintUIModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrintUIModelDirty();
        }
        return this.printuimodelDirtyFlag;
    }

    public void resetPrintUIModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrintUIModel();
            return;
        }
        this.printuimodelDirtyFlag = false;
        this.printuimodel = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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

    public void setPSDEPrintId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPrintId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeprintid = string;
        this.psdeprintidDirtyFlag = true;
    }

    public String getPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrintId();
        }
        return this.psdeprintid;
    }

    public boolean isPSDEPrintIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPrintIdDirty();
        }
        return this.psdeprintidDirtyFlag;
    }

    public void resetPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPrintId();
            return;
        }
        this.psdeprintidDirtyFlag = false;
        this.psdeprintid = null;
    }

    public void setPSDEPrintName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPrintName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeprintname = string;
        this.psdeprintnameDirtyFlag = true;
    }

    public String getPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrintName();
        }
        return this.psdeprintname;
    }

    public boolean isPSDEPrintNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPrintNameDirty();
        }
        return this.psdeprintnameDirtyFlag;
    }

    public void resetPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPrintName();
            return;
        }
        this.psdeprintnameDirtyFlag = false;
        this.psdeprintname = null;
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

    public void setReadPSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadPSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.readpsdeopprivid = string;
        this.readpsdeopprividDirtyFlag = true;
    }

    public String getReadPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadPSDEOPPrivId();
        }
        return this.readpsdeopprivid;
    }

    public boolean isReadPSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadPSDEOPPrivIdDirty();
        }
        return this.readpsdeopprividDirtyFlag;
    }

    public void resetReadPSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadPSDEOPPrivId();
            return;
        }
        this.readpsdeopprividDirtyFlag = false;
        this.readpsdeopprivid = null;
    }

    public void setReadPSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadPSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.readpsdeopprivname = string;
        this.readpsdeopprivnameDirtyFlag = true;
    }

    public String getReadPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadPSDEOPPrivName();
        }
        return this.readpsdeopprivname;
    }

    public boolean isReadPSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadPSDEOPPrivNameDirty();
        }
        return this.readpsdeopprivnameDirtyFlag;
    }

    public void resetReadPSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadPSDEOPPrivName();
            return;
        }
        this.readpsdeopprivnameDirtyFlag = false;
        this.readpsdeopprivname = null;
    }

    public void setRefPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeid = string;
        this.refpsdeidDirtyFlag = true;
    }

    public String getRefPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEId();
        }
        return this.refpsdeid;
    }

    public boolean isRefPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEIdDirty();
        }
        return this.refpsdeidDirtyFlag;
    }

    public void resetRefPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEId();
            return;
        }
        this.refpsdeidDirtyFlag = false;
        this.refpsdeid = null;
    }

    public void setRefPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdename = string;
        this.refpsdenameDirtyFlag = true;
    }

    public String getRefPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEName();
        }
        return this.refpsdename;
    }

    public boolean isRefPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDENameDirty();
        }
        return this.refpsdenameDirtyFlag;
    }

    public void resetRefPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEName();
            return;
        }
        this.refpsdenameDirtyFlag = false;
        this.refpsdename = null;
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
        PSDEPrintBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEPrintBase pSDEPrintBase) {
        pSDEPrintBase.resetADPSDELogicId();
        pSDEPrintBase.resetADPSDELogicName();
        pSDEPrintBase.resetCodeName();
        pSDEPrintBase.resetContentType();
        pSDEPrintBase.resetCreateDate();
        pSDEPrintBase.resetCreateMan();
        pSDEPrintBase.resetCustomCode();
        pSDEPrintBase.resetCustomMode();
        pSDEPrintBase.resetDefaultMode();
        pSDEPrintBase.resetEnableColPriv();
        pSDEPrintBase.resetEnableLog();
        pSDEPrintBase.resetEnableMP();
        pSDEPrintBase.resetExtendMode();
        pSDEPrintBase.resetGetDataPSDEActionId();
        pSDEPrintBase.resetGetDataPSDEActionName();
        pSDEPrintBase.resetLayoutPanelMode();
        pSDEPrintBase.resetLockFlag();
        pSDEPrintBase.resetLogicName();
        pSDEPrintBase.resetMemo();
        pSDEPrintBase.resetPOTime();
        pSDEPrintBase.resetPrintModel();
        pSDEPrintBase.resetPrintParams();
        pSDEPrintBase.resetPrintTag();
        pSDEPrintBase.resetPrintTag2();
        pSDEPrintBase.resetPrintUIModel();
        pSDEPrintBase.resetPSDEDataSetId();
        pSDEPrintBase.resetPSDEDataSetName();
        pSDEPrintBase.resetPSDEId();
        pSDEPrintBase.resetPSDEName();
        pSDEPrintBase.resetPSDEPrintId();
        pSDEPrintBase.resetPSDEPrintName();
        pSDEPrintBase.resetPSSysPFPluginId();
        pSDEPrintBase.resetPSSysPFPluginName();
        pSDEPrintBase.resetPSSysReqItemId();
        pSDEPrintBase.resetPSSysReqItemName();
        pSDEPrintBase.resetPSSysResourceId();
        pSDEPrintBase.resetPSSysResourceName();
        pSDEPrintBase.resetPSSysSFPluginId();
        pSDEPrintBase.resetPSSysSFPluginName();
        pSDEPrintBase.resetPSSysUniResId();
        pSDEPrintBase.resetPSSysUniResName();
        pSDEPrintBase.resetPSSysViewPanelId();
        pSDEPrintBase.resetPSSysViewPanelName();
        pSDEPrintBase.resetPSViewMsgGroupId();
        pSDEPrintBase.resetPSViewMsgGroupName();
        pSDEPrintBase.resetReadPSDEOPPrivId();
        pSDEPrintBase.resetReadPSDEOPPrivName();
        pSDEPrintBase.resetRefPSDEId();
        pSDEPrintBase.resetRefPSDEName();
        pSDEPrintBase.resetReportFile();
        pSDEPrintBase.resetReportType();
        pSDEPrintBase.resetToDoTask();
        pSDEPrintBase.resetUpdateDate();
        pSDEPrintBase.resetUpdateMan();
        pSDEPrintBase.resetUserCat();
        pSDEPrintBase.resetUserTag();
        pSDEPrintBase.resetUserTag2();
        pSDEPrintBase.resetUserTag3();
        pSDEPrintBase.resetUserTag4();
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
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isEnableColPrivDirty()) {
            hashMap.put(FIELD_ENABLECOLPRIV, this.getEnableColPriv());
        }
        if (!bl || this.isEnableLogDirty()) {
            hashMap.put(FIELD_ENABLELOG, this.getEnableLog());
        }
        if (!bl || this.isEnableMPDirty()) {
            hashMap.put(FIELD_ENABLEMP, this.getEnableMP());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isGetDataPSDEActionIdDirty()) {
            hashMap.put(FIELD_GETDATAPSDEACTIONID, this.getGetDataPSDEActionId());
        }
        if (!bl || this.isGetDataPSDEActionNameDirty()) {
            hashMap.put(FIELD_GETDATAPSDEACTIONNAME, this.getGetDataPSDEActionName());
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
        if (!bl || this.isPOTimeDirty()) {
            hashMap.put(FIELD_POTIME, this.getPOTime());
        }
        if (!bl || this.isPrintModelDirty()) {
            hashMap.put(FIELD_PRINTMODEL, this.getPrintModel());
        }
        if (!bl || this.isPrintParamsDirty()) {
            hashMap.put(FIELD_PRINTPARAMS, this.getPrintParams());
        }
        if (!bl || this.isPrintTagDirty()) {
            hashMap.put(FIELD_PRINTTAG, this.getPrintTag());
        }
        if (!bl || this.isPrintTag2Dirty()) {
            hashMap.put(FIELD_PRINTTAG2, this.getPrintTag2());
        }
        if (!bl || this.isPrintUIModelDirty()) {
            hashMap.put(FIELD_PRINTUIMODEL, this.getPrintUIModel());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEPrintIdDirty()) {
            hashMap.put(FIELD_PSDEPRINTID, this.getPSDEPrintId());
        }
        if (!bl || this.isPSDEPrintNameDirty()) {
            hashMap.put(FIELD_PSDEPRINTNAME, this.getPSDEPrintName());
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
        if (!bl || this.isReadPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_READPSDEOPPRIVID, this.getReadPSDEOPPrivId());
        }
        if (!bl || this.isReadPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_READPSDEOPPRIVNAME, this.getReadPSDEOPPrivName());
        }
        if (!bl || this.isRefPSDEIdDirty()) {
            hashMap.put(FIELD_REFPSDEID, this.getRefPSDEId());
        }
        if (!bl || this.isRefPSDENameDirty()) {
            hashMap.put(FIELD_REFPSDENAME, this.getRefPSDEName());
        }
        if (!bl || this.isReportFileDirty()) {
            hashMap.put(FIELD_REPORTFILE, this.getReportFile());
        }
        if (!bl || this.isReportTypeDirty()) {
            hashMap.put(FIELD_REPORTTYPE, this.getReportType());
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
        return PSDEPrintBase.get(this, n);
    }

    private static Object get(PSDEPrintBase pSDEPrintBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEPrintBase.getADPSDELogicId();
            }
            case 1: {
                return pSDEPrintBase.getADPSDELogicName();
            }
            case 2: {
                return pSDEPrintBase.getCodeName();
            }
            case 3: {
                return pSDEPrintBase.getContentType();
            }
            case 4: {
                return pSDEPrintBase.getCreateDate();
            }
            case 5: {
                return pSDEPrintBase.getCreateMan();
            }
            case 6: {
                return pSDEPrintBase.getCustomCode();
            }
            case 7: {
                return pSDEPrintBase.getCustomMode();
            }
            case 8: {
                return pSDEPrintBase.getDefaultMode();
            }
            case 9: {
                return pSDEPrintBase.getEnableColPriv();
            }
            case 10: {
                return pSDEPrintBase.getEnableLog();
            }
            case 11: {
                return pSDEPrintBase.getEnableMP();
            }
            case 12: {
                return pSDEPrintBase.getExtendMode();
            }
            case 13: {
                return pSDEPrintBase.getGetDataPSDEActionId();
            }
            case 14: {
                return pSDEPrintBase.getGetDataPSDEActionName();
            }
            case 15: {
                return pSDEPrintBase.getLayoutPanelMode();
            }
            case 16: {
                return pSDEPrintBase.getLockFlag();
            }
            case 17: {
                return pSDEPrintBase.getLogicName();
            }
            case 18: {
                return pSDEPrintBase.getMemo();
            }
            case 19: {
                return pSDEPrintBase.getPOTime();
            }
            case 20: {
                return pSDEPrintBase.getPrintModel();
            }
            case 21: {
                return pSDEPrintBase.getPrintParams();
            }
            case 22: {
                return pSDEPrintBase.getPrintTag();
            }
            case 23: {
                return pSDEPrintBase.getPrintTag2();
            }
            case 24: {
                return pSDEPrintBase.getPrintUIModel();
            }
            case 25: {
                return pSDEPrintBase.getPSDEDataSetId();
            }
            case 26: {
                return pSDEPrintBase.getPSDEDataSetName();
            }
            case 27: {
                return pSDEPrintBase.getPSDEId();
            }
            case 28: {
                return pSDEPrintBase.getPSDEName();
            }
            case 29: {
                return pSDEPrintBase.getPSDEPrintId();
            }
            case 30: {
                return pSDEPrintBase.getPSDEPrintName();
            }
            case 31: {
                return pSDEPrintBase.getPSSysPFPluginId();
            }
            case 32: {
                return pSDEPrintBase.getPSSysPFPluginName();
            }
            case 33: {
                return pSDEPrintBase.getPSSysReqItemId();
            }
            case 34: {
                return pSDEPrintBase.getPSSysReqItemName();
            }
            case 35: {
                return pSDEPrintBase.getPSSysResourceId();
            }
            case 36: {
                return pSDEPrintBase.getPSSysResourceName();
            }
            case 37: {
                return pSDEPrintBase.getPSSysSFPluginId();
            }
            case 38: {
                return pSDEPrintBase.getPSSysSFPluginName();
            }
            case 39: {
                return pSDEPrintBase.getPSSysUniResId();
            }
            case 40: {
                return pSDEPrintBase.getPSSysUniResName();
            }
            case 41: {
                return pSDEPrintBase.getPSSysViewPanelId();
            }
            case 42: {
                return pSDEPrintBase.getPSSysViewPanelName();
            }
            case 43: {
                return pSDEPrintBase.getPSViewMsgGroupId();
            }
            case 44: {
                return pSDEPrintBase.getPSViewMsgGroupName();
            }
            case 45: {
                return pSDEPrintBase.getReadPSDEOPPrivId();
            }
            case 46: {
                return pSDEPrintBase.getReadPSDEOPPrivName();
            }
            case 47: {
                return pSDEPrintBase.getRefPSDEId();
            }
            case 48: {
                return pSDEPrintBase.getRefPSDEName();
            }
            case 49: {
                return pSDEPrintBase.getReportFile();
            }
            case 50: {
                return pSDEPrintBase.getReportType();
            }
            case 51: {
                return pSDEPrintBase.getToDoTask();
            }
            case 52: {
                return pSDEPrintBase.getUpdateDate();
            }
            case 53: {
                return pSDEPrintBase.getUpdateMan();
            }
            case 54: {
                return pSDEPrintBase.getUserCat();
            }
            case 55: {
                return pSDEPrintBase.getUserTag();
            }
            case 56: {
                return pSDEPrintBase.getUserTag2();
            }
            case 57: {
                return pSDEPrintBase.getUserTag3();
            }
            case 58: {
                return pSDEPrintBase.getUserTag4();
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
        PSDEPrintBase.set(this, n, object);
    }

    private static void set(PSDEPrintBase pSDEPrintBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEPrintBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEPrintBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEPrintBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEPrintBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEPrintBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEPrintBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEPrintBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEPrintBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEPrintBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEPrintBase.setEnableColPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEPrintBase.setEnableLog(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEPrintBase.setEnableMP(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEPrintBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEPrintBase.setGetDataPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEPrintBase.setGetDataPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEPrintBase.setLayoutPanelMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEPrintBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEPrintBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEPrintBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEPrintBase.setPOTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEPrintBase.setPrintModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEPrintBase.setPrintParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEPrintBase.setPrintTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEPrintBase.setPrintTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEPrintBase.setPrintUIModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEPrintBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEPrintBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEPrintBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEPrintBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEPrintBase.setPSDEPrintId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEPrintBase.setPSDEPrintName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEPrintBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEPrintBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEPrintBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEPrintBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEPrintBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEPrintBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEPrintBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEPrintBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEPrintBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEPrintBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEPrintBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEPrintBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEPrintBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEPrintBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEPrintBase.setReadPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEPrintBase.setReadPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEPrintBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEPrintBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEPrintBase.setReportFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEPrintBase.setReportType(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEPrintBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEPrintBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 53: {
                pSDEPrintBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEPrintBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEPrintBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEPrintBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEPrintBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEPrintBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEPrintBase.isNull(this, n);
    }

    private static boolean isNull(PSDEPrintBase pSDEPrintBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEPrintBase.getADPSDELogicId() == null;
            }
            case 1: {
                return pSDEPrintBase.getADPSDELogicName() == null;
            }
            case 2: {
                return pSDEPrintBase.getCodeName() == null;
            }
            case 3: {
                return pSDEPrintBase.getContentType() == null;
            }
            case 4: {
                return pSDEPrintBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEPrintBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEPrintBase.getCustomCode() == null;
            }
            case 7: {
                return pSDEPrintBase.getCustomMode() == null;
            }
            case 8: {
                return pSDEPrintBase.getDefaultMode() == null;
            }
            case 9: {
                return pSDEPrintBase.getEnableColPriv() == null;
            }
            case 10: {
                return pSDEPrintBase.getEnableLog() == null;
            }
            case 11: {
                return pSDEPrintBase.getEnableMP() == null;
            }
            case 12: {
                return pSDEPrintBase.getExtendMode() == null;
            }
            case 13: {
                return pSDEPrintBase.getGetDataPSDEActionId() == null;
            }
            case 14: {
                return pSDEPrintBase.getGetDataPSDEActionName() == null;
            }
            case 15: {
                return pSDEPrintBase.getLayoutPanelMode() == null;
            }
            case 16: {
                return pSDEPrintBase.getLockFlag() == null;
            }
            case 17: {
                return pSDEPrintBase.getLogicName() == null;
            }
            case 18: {
                return pSDEPrintBase.getMemo() == null;
            }
            case 19: {
                return pSDEPrintBase.getPOTime() == null;
            }
            case 20: {
                return pSDEPrintBase.getPrintModel() == null;
            }
            case 21: {
                return pSDEPrintBase.getPrintParams() == null;
            }
            case 22: {
                return pSDEPrintBase.getPrintTag() == null;
            }
            case 23: {
                return pSDEPrintBase.getPrintTag2() == null;
            }
            case 24: {
                return pSDEPrintBase.getPrintUIModel() == null;
            }
            case 25: {
                return pSDEPrintBase.getPSDEDataSetId() == null;
            }
            case 26: {
                return pSDEPrintBase.getPSDEDataSetName() == null;
            }
            case 27: {
                return pSDEPrintBase.getPSDEId() == null;
            }
            case 28: {
                return pSDEPrintBase.getPSDEName() == null;
            }
            case 29: {
                return pSDEPrintBase.getPSDEPrintId() == null;
            }
            case 30: {
                return pSDEPrintBase.getPSDEPrintName() == null;
            }
            case 31: {
                return pSDEPrintBase.getPSSysPFPluginId() == null;
            }
            case 32: {
                return pSDEPrintBase.getPSSysPFPluginName() == null;
            }
            case 33: {
                return pSDEPrintBase.getPSSysReqItemId() == null;
            }
            case 34: {
                return pSDEPrintBase.getPSSysReqItemName() == null;
            }
            case 35: {
                return pSDEPrintBase.getPSSysResourceId() == null;
            }
            case 36: {
                return pSDEPrintBase.getPSSysResourceName() == null;
            }
            case 37: {
                return pSDEPrintBase.getPSSysSFPluginId() == null;
            }
            case 38: {
                return pSDEPrintBase.getPSSysSFPluginName() == null;
            }
            case 39: {
                return pSDEPrintBase.getPSSysUniResId() == null;
            }
            case 40: {
                return pSDEPrintBase.getPSSysUniResName() == null;
            }
            case 41: {
                return pSDEPrintBase.getPSSysViewPanelId() == null;
            }
            case 42: {
                return pSDEPrintBase.getPSSysViewPanelName() == null;
            }
            case 43: {
                return pSDEPrintBase.getPSViewMsgGroupId() == null;
            }
            case 44: {
                return pSDEPrintBase.getPSViewMsgGroupName() == null;
            }
            case 45: {
                return pSDEPrintBase.getReadPSDEOPPrivId() == null;
            }
            case 46: {
                return pSDEPrintBase.getReadPSDEOPPrivName() == null;
            }
            case 47: {
                return pSDEPrintBase.getRefPSDEId() == null;
            }
            case 48: {
                return pSDEPrintBase.getRefPSDEName() == null;
            }
            case 49: {
                return pSDEPrintBase.getReportFile() == null;
            }
            case 50: {
                return pSDEPrintBase.getReportType() == null;
            }
            case 51: {
                return pSDEPrintBase.getToDoTask() == null;
            }
            case 52: {
                return pSDEPrintBase.getUpdateDate() == null;
            }
            case 53: {
                return pSDEPrintBase.getUpdateMan() == null;
            }
            case 54: {
                return pSDEPrintBase.getUserCat() == null;
            }
            case 55: {
                return pSDEPrintBase.getUserTag() == null;
            }
            case 56: {
                return pSDEPrintBase.getUserTag2() == null;
            }
            case 57: {
                return pSDEPrintBase.getUserTag3() == null;
            }
            case 58: {
                return pSDEPrintBase.getUserTag4() == null;
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
        return PSDEPrintBase.contains(this, n);
    }

    private static boolean contains(PSDEPrintBase pSDEPrintBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEPrintBase.isADPSDELogicIdDirty();
            }
            case 1: {
                return pSDEPrintBase.isADPSDELogicNameDirty();
            }
            case 2: {
                return pSDEPrintBase.isCodeNameDirty();
            }
            case 3: {
                return pSDEPrintBase.isContentTypeDirty();
            }
            case 4: {
                return pSDEPrintBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEPrintBase.isCreateManDirty();
            }
            case 6: {
                return pSDEPrintBase.isCustomCodeDirty();
            }
            case 7: {
                return pSDEPrintBase.isCustomModeDirty();
            }
            case 8: {
                return pSDEPrintBase.isDefaultModeDirty();
            }
            case 9: {
                return pSDEPrintBase.isEnableColPrivDirty();
            }
            case 10: {
                return pSDEPrintBase.isEnableLogDirty();
            }
            case 11: {
                return pSDEPrintBase.isEnableMPDirty();
            }
            case 12: {
                return pSDEPrintBase.isExtendModeDirty();
            }
            case 13: {
                return pSDEPrintBase.isGetDataPSDEActionIdDirty();
            }
            case 14: {
                return pSDEPrintBase.isGetDataPSDEActionNameDirty();
            }
            case 15: {
                return pSDEPrintBase.isLayoutPanelModeDirty();
            }
            case 16: {
                return pSDEPrintBase.isLockFlagDirty();
            }
            case 17: {
                return pSDEPrintBase.isLogicNameDirty();
            }
            case 18: {
                return pSDEPrintBase.isMemoDirty();
            }
            case 19: {
                return pSDEPrintBase.isPOTimeDirty();
            }
            case 20: {
                return pSDEPrintBase.isPrintModelDirty();
            }
            case 21: {
                return pSDEPrintBase.isPrintParamsDirty();
            }
            case 22: {
                return pSDEPrintBase.isPrintTagDirty();
            }
            case 23: {
                return pSDEPrintBase.isPrintTag2Dirty();
            }
            case 24: {
                return pSDEPrintBase.isPrintUIModelDirty();
            }
            case 25: {
                return pSDEPrintBase.isPSDEDataSetIdDirty();
            }
            case 26: {
                return pSDEPrintBase.isPSDEDataSetNameDirty();
            }
            case 27: {
                return pSDEPrintBase.isPSDEIdDirty();
            }
            case 28: {
                return pSDEPrintBase.isPSDENameDirty();
            }
            case 29: {
                return pSDEPrintBase.isPSDEPrintIdDirty();
            }
            case 30: {
                return pSDEPrintBase.isPSDEPrintNameDirty();
            }
            case 31: {
                return pSDEPrintBase.isPSSysPFPluginIdDirty();
            }
            case 32: {
                return pSDEPrintBase.isPSSysPFPluginNameDirty();
            }
            case 33: {
                return pSDEPrintBase.isPSSysReqItemIdDirty();
            }
            case 34: {
                return pSDEPrintBase.isPSSysReqItemNameDirty();
            }
            case 35: {
                return pSDEPrintBase.isPSSysResourceIdDirty();
            }
            case 36: {
                return pSDEPrintBase.isPSSysResourceNameDirty();
            }
            case 37: {
                return pSDEPrintBase.isPSSysSFPluginIdDirty();
            }
            case 38: {
                return pSDEPrintBase.isPSSysSFPluginNameDirty();
            }
            case 39: {
                return pSDEPrintBase.isPSSysUniResIdDirty();
            }
            case 40: {
                return pSDEPrintBase.isPSSysUniResNameDirty();
            }
            case 41: {
                return pSDEPrintBase.isPSSysViewPanelIdDirty();
            }
            case 42: {
                return pSDEPrintBase.isPSSysViewPanelNameDirty();
            }
            case 43: {
                return pSDEPrintBase.isPSViewMsgGroupIdDirty();
            }
            case 44: {
                return pSDEPrintBase.isPSViewMsgGroupNameDirty();
            }
            case 45: {
                return pSDEPrintBase.isReadPSDEOPPrivIdDirty();
            }
            case 46: {
                return pSDEPrintBase.isReadPSDEOPPrivNameDirty();
            }
            case 47: {
                return pSDEPrintBase.isRefPSDEIdDirty();
            }
            case 48: {
                return pSDEPrintBase.isRefPSDENameDirty();
            }
            case 49: {
                return pSDEPrintBase.isReportFileDirty();
            }
            case 50: {
                return pSDEPrintBase.isReportTypeDirty();
            }
            case 51: {
                return pSDEPrintBase.isToDoTaskDirty();
            }
            case 52: {
                return pSDEPrintBase.isUpdateDateDirty();
            }
            case 53: {
                return pSDEPrintBase.isUpdateManDirty();
            }
            case 54: {
                return pSDEPrintBase.isUserCatDirty();
            }
            case 55: {
                return pSDEPrintBase.isUserTagDirty();
            }
            case 56: {
                return pSDEPrintBase.isUserTag2Dirty();
            }
            case 57: {
                return pSDEPrintBase.isUserTag3Dirty();
            }
            case 58: {
                return pSDEPrintBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEPrintBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEPrintBase pSDEPrintBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEPrintBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getContentType()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getEnableColPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecolpriv", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getEnableColPriv()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getEnableLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelog", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getEnableLog()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getEnableMP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemp", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getEnableMP()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getGetDataPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdatapsdeactionid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getGetDataPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getGetDataPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdatapsdeactionname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getGetDataPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getLayoutPanelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutpanelmode", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getLayoutPanelMode()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPOTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"potime", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPOTime()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPrintModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"printmodel", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPrintModel()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPrintParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"printparams", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPrintParams()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPrintTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"printtag", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPrintTag()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPrintTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"printtag2", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPrintTag2()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPrintUIModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"printuimodel", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPrintUIModel()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSDEPrintId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeprintid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSDEPrintId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSDEPrintName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeprintname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSDEPrintName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getReadPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readpsdeopprivid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getReadPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getReadPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readpsdeopprivname", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getReadPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getReportFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reportfile", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getReportFile()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getReportType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reporttype", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getReportType()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEPrintBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEPrintBase.getJSONValue((Object)pSDEPrintBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEPrintBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEPrintBase pSDEPrintBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEPrintBase.getADPSDELogicId() != null) {
            object = pSDEPrintBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEPrintBase.getADPSDELogicName() != null) {
            object = pSDEPrintBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEPrintBase.getCodeName() != null) {
            object = pSDEPrintBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEPrintBase.getContentType() != null) {
            object = pSDEPrintBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getCreateDate() != null) {
            object = pSDEPrintBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEPrintBase.getCreateMan() != null) {
            object = pSDEPrintBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getCustomCode() != null) {
            object = pSDEPrintBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getCustomMode() != null) {
            object = pSDEPrintBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getDefaultMode() != null) {
            object = pSDEPrintBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getEnableColPriv() != null) {
            object = pSDEPrintBase.getEnableColPriv();
            xmlNode.setAttribute(FIELD_ENABLECOLPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getEnableLog() != null) {
            object = pSDEPrintBase.getEnableLog();
            xmlNode.setAttribute(FIELD_ENABLELOG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getEnableMP() != null) {
            object = pSDEPrintBase.getEnableMP();
            xmlNode.setAttribute(FIELD_ENABLEMP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getExtendMode() != null) {
            object = pSDEPrintBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getGetDataPSDEActionId() != null) {
            object = pSDEPrintBase.getGetDataPSDEActionId();
            xmlNode.setAttribute(FIELD_GETDATAPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getGetDataPSDEActionName() != null) {
            object = pSDEPrintBase.getGetDataPSDEActionName();
            xmlNode.setAttribute(FIELD_GETDATAPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getLayoutPanelMode() != null) {
            object = pSDEPrintBase.getLayoutPanelMode();
            xmlNode.setAttribute(FIELD_LAYOUTPANELMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getLockFlag() != null) {
            object = pSDEPrintBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getLogicName() != null) {
            object = pSDEPrintBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getMemo() != null) {
            object = pSDEPrintBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPOTime() != null) {
            object = pSDEPrintBase.getPOTime();
            xmlNode.setAttribute(FIELD_POTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEPrintBase.getPrintModel() != null) {
            object = pSDEPrintBase.getPrintModel();
            xmlNode.setAttribute(FIELD_PRINTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPrintParams() != null) {
            object = pSDEPrintBase.getPrintParams();
            xmlNode.setAttribute(FIELD_PRINTPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPrintTag() != null) {
            object = pSDEPrintBase.getPrintTag();
            xmlNode.setAttribute(FIELD_PRINTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPrintTag2() != null) {
            object = pSDEPrintBase.getPrintTag2();
            xmlNode.setAttribute(FIELD_PRINTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPrintUIModel() != null) {
            object = pSDEPrintBase.getPrintUIModel();
            xmlNode.setAttribute(FIELD_PRINTUIMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSDEDataSetId() != null) {
            object = pSDEPrintBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSDEDataSetName() != null) {
            object = pSDEPrintBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSDEId() != null) {
            object = pSDEPrintBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSDEName() != null) {
            object = pSDEPrintBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSDEPrintId() != null) {
            object = pSDEPrintBase.getPSDEPrintId();
            xmlNode.setAttribute(FIELD_PSDEPRINTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSDEPrintName() != null) {
            object = pSDEPrintBase.getPSDEPrintName();
            xmlNode.setAttribute(FIELD_PSDEPRINTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysPFPluginId() != null) {
            object = pSDEPrintBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysPFPluginName() != null) {
            object = pSDEPrintBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysReqItemId() != null) {
            object = pSDEPrintBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysReqItemName() != null) {
            object = pSDEPrintBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysResourceId() != null) {
            object = pSDEPrintBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysResourceName() != null) {
            object = pSDEPrintBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysSFPluginId() != null) {
            object = pSDEPrintBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysSFPluginName() != null) {
            object = pSDEPrintBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysUniResId() != null) {
            object = pSDEPrintBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysUniResName() != null) {
            object = pSDEPrintBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysViewPanelId() != null) {
            object = pSDEPrintBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSSysViewPanelName() != null) {
            object = pSDEPrintBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSViewMsgGroupId() != null) {
            object = pSDEPrintBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getPSViewMsgGroupName() != null) {
            object = pSDEPrintBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getReadPSDEOPPrivId() != null) {
            object = pSDEPrintBase.getReadPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_READPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getReadPSDEOPPrivName() != null) {
            object = pSDEPrintBase.getReadPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_READPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getRefPSDEId() != null) {
            object = pSDEPrintBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getRefPSDEName() != null) {
            object = pSDEPrintBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getReportFile() != null) {
            object = pSDEPrintBase.getReportFile();
            xmlNode.setAttribute(FIELD_REPORTFILE, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getReportType() != null) {
            object = pSDEPrintBase.getReportType();
            xmlNode.setAttribute(FIELD_REPORTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getToDoTask() != null) {
            object = pSDEPrintBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getUpdateDate() != null) {
            object = pSDEPrintBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEPrintBase.getUpdateMan() != null) {
            object = pSDEPrintBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getUserCat() != null) {
            object = pSDEPrintBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getUserTag() != null) {
            object = pSDEPrintBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getUserTag2() != null) {
            object = pSDEPrintBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getUserTag3() != null) {
            object = pSDEPrintBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEPrintBase.getUserTag4() != null) {
            object = pSDEPrintBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEPrintBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEPrintBase pSDEPrintBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEPrintBase.isADPSDELogicIdDirty() && (bl || pSDEPrintBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSDEPrintBase.getADPSDELogicId());
        }
        if (pSDEPrintBase.isADPSDELogicNameDirty() && (bl || pSDEPrintBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSDEPrintBase.getADPSDELogicName());
        }
        if (pSDEPrintBase.isCodeNameDirty() && (bl || pSDEPrintBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEPrintBase.getCodeName());
        }
        if (pSDEPrintBase.isContentTypeDirty() && (bl || pSDEPrintBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDEPrintBase.getContentType());
        }
        if (pSDEPrintBase.isCreateDateDirty() && (bl || pSDEPrintBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEPrintBase.getCreateDate());
        }
        if (pSDEPrintBase.isCreateManDirty() && (bl || pSDEPrintBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEPrintBase.getCreateMan());
        }
        if (pSDEPrintBase.isCustomCodeDirty() && (bl || pSDEPrintBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEPrintBase.getCustomCode());
        }
        if (pSDEPrintBase.isCustomModeDirty() && (bl || pSDEPrintBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEPrintBase.getCustomMode());
        }
        if (pSDEPrintBase.isDefaultModeDirty() && (bl || pSDEPrintBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDEPrintBase.getDefaultMode());
        }
        if (pSDEPrintBase.isEnableColPrivDirty() && (bl || pSDEPrintBase.getEnableColPriv() != null)) {
            iDataObject.set(FIELD_ENABLECOLPRIV, (Object)pSDEPrintBase.getEnableColPriv());
        }
        if (pSDEPrintBase.isEnableLogDirty() && (bl || pSDEPrintBase.getEnableLog() != null)) {
            iDataObject.set(FIELD_ENABLELOG, (Object)pSDEPrintBase.getEnableLog());
        }
        if (pSDEPrintBase.isEnableMPDirty() && (bl || pSDEPrintBase.getEnableMP() != null)) {
            iDataObject.set(FIELD_ENABLEMP, (Object)pSDEPrintBase.getEnableMP());
        }
        if (pSDEPrintBase.isExtendModeDirty() && (bl || pSDEPrintBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEPrintBase.getExtendMode());
        }
        if (pSDEPrintBase.isGetDataPSDEActionIdDirty() && (bl || pSDEPrintBase.getGetDataPSDEActionId() != null)) {
            iDataObject.set(FIELD_GETDATAPSDEACTIONID, (Object)pSDEPrintBase.getGetDataPSDEActionId());
        }
        if (pSDEPrintBase.isGetDataPSDEActionNameDirty() && (bl || pSDEPrintBase.getGetDataPSDEActionName() != null)) {
            iDataObject.set(FIELD_GETDATAPSDEACTIONNAME, (Object)pSDEPrintBase.getGetDataPSDEActionName());
        }
        if (pSDEPrintBase.isLayoutPanelModeDirty() && (bl || pSDEPrintBase.getLayoutPanelMode() != null)) {
            iDataObject.set(FIELD_LAYOUTPANELMODE, (Object)pSDEPrintBase.getLayoutPanelMode());
        }
        if (pSDEPrintBase.isLockFlagDirty() && (bl || pSDEPrintBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEPrintBase.getLockFlag());
        }
        if (pSDEPrintBase.isLogicNameDirty() && (bl || pSDEPrintBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEPrintBase.getLogicName());
        }
        if (pSDEPrintBase.isMemoDirty() && (bl || pSDEPrintBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEPrintBase.getMemo());
        }
        if (pSDEPrintBase.isPOTimeDirty() && (bl || pSDEPrintBase.getPOTime() != null)) {
            iDataObject.set(FIELD_POTIME, (Object)pSDEPrintBase.getPOTime());
        }
        if (pSDEPrintBase.isPrintModelDirty() && (bl || pSDEPrintBase.getPrintModel() != null)) {
            iDataObject.set(FIELD_PRINTMODEL, (Object)pSDEPrintBase.getPrintModel());
        }
        if (pSDEPrintBase.isPrintParamsDirty() && (bl || pSDEPrintBase.getPrintParams() != null)) {
            iDataObject.set(FIELD_PRINTPARAMS, (Object)pSDEPrintBase.getPrintParams());
        }
        if (pSDEPrintBase.isPrintTagDirty() && (bl || pSDEPrintBase.getPrintTag() != null)) {
            iDataObject.set(FIELD_PRINTTAG, (Object)pSDEPrintBase.getPrintTag());
        }
        if (pSDEPrintBase.isPrintTag2Dirty() && (bl || pSDEPrintBase.getPrintTag2() != null)) {
            iDataObject.set(FIELD_PRINTTAG2, (Object)pSDEPrintBase.getPrintTag2());
        }
        if (pSDEPrintBase.isPrintUIModelDirty() && (bl || pSDEPrintBase.getPrintUIModel() != null)) {
            iDataObject.set(FIELD_PRINTUIMODEL, (Object)pSDEPrintBase.getPrintUIModel());
        }
        if (pSDEPrintBase.isPSDEDataSetIdDirty() && (bl || pSDEPrintBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEPrintBase.getPSDEDataSetId());
        }
        if (pSDEPrintBase.isPSDEDataSetNameDirty() && (bl || pSDEPrintBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEPrintBase.getPSDEDataSetName());
        }
        if (pSDEPrintBase.isPSDEIdDirty() && (bl || pSDEPrintBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEPrintBase.getPSDEId());
        }
        if (pSDEPrintBase.isPSDENameDirty() && (bl || pSDEPrintBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEPrintBase.getPSDEName());
        }
        if (pSDEPrintBase.isPSDEPrintIdDirty() && (bl || pSDEPrintBase.getPSDEPrintId() != null)) {
            iDataObject.set(FIELD_PSDEPRINTID, (Object)pSDEPrintBase.getPSDEPrintId());
        }
        if (pSDEPrintBase.isPSDEPrintNameDirty() && (bl || pSDEPrintBase.getPSDEPrintName() != null)) {
            iDataObject.set(FIELD_PSDEPRINTNAME, (Object)pSDEPrintBase.getPSDEPrintName());
        }
        if (pSDEPrintBase.isPSSysPFPluginIdDirty() && (bl || pSDEPrintBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEPrintBase.getPSSysPFPluginId());
        }
        if (pSDEPrintBase.isPSSysPFPluginNameDirty() && (bl || pSDEPrintBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEPrintBase.getPSSysPFPluginName());
        }
        if (pSDEPrintBase.isPSSysReqItemIdDirty() && (bl || pSDEPrintBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEPrintBase.getPSSysReqItemId());
        }
        if (pSDEPrintBase.isPSSysReqItemNameDirty() && (bl || pSDEPrintBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEPrintBase.getPSSysReqItemName());
        }
        if (pSDEPrintBase.isPSSysResourceIdDirty() && (bl || pSDEPrintBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSDEPrintBase.getPSSysResourceId());
        }
        if (pSDEPrintBase.isPSSysResourceNameDirty() && (bl || pSDEPrintBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSDEPrintBase.getPSSysResourceName());
        }
        if (pSDEPrintBase.isPSSysSFPluginIdDirty() && (bl || pSDEPrintBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEPrintBase.getPSSysSFPluginId());
        }
        if (pSDEPrintBase.isPSSysSFPluginNameDirty() && (bl || pSDEPrintBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEPrintBase.getPSSysSFPluginName());
        }
        if (pSDEPrintBase.isPSSysUniResIdDirty() && (bl || pSDEPrintBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSDEPrintBase.getPSSysUniResId());
        }
        if (pSDEPrintBase.isPSSysUniResNameDirty() && (bl || pSDEPrintBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSDEPrintBase.getPSSysUniResName());
        }
        if (pSDEPrintBase.isPSSysViewPanelIdDirty() && (bl || pSDEPrintBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEPrintBase.getPSSysViewPanelId());
        }
        if (pSDEPrintBase.isPSSysViewPanelNameDirty() && (bl || pSDEPrintBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEPrintBase.getPSSysViewPanelName());
        }
        if (pSDEPrintBase.isPSViewMsgGroupIdDirty() && (bl || pSDEPrintBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEPrintBase.getPSViewMsgGroupId());
        }
        if (pSDEPrintBase.isPSViewMsgGroupNameDirty() && (bl || pSDEPrintBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEPrintBase.getPSViewMsgGroupName());
        }
        if (pSDEPrintBase.isReadPSDEOPPrivIdDirty() && (bl || pSDEPrintBase.getReadPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_READPSDEOPPRIVID, (Object)pSDEPrintBase.getReadPSDEOPPrivId());
        }
        if (pSDEPrintBase.isReadPSDEOPPrivNameDirty() && (bl || pSDEPrintBase.getReadPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_READPSDEOPPRIVNAME, (Object)pSDEPrintBase.getReadPSDEOPPrivName());
        }
        if (pSDEPrintBase.isRefPSDEIdDirty() && (bl || pSDEPrintBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSDEPrintBase.getRefPSDEId());
        }
        if (pSDEPrintBase.isRefPSDENameDirty() && (bl || pSDEPrintBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSDEPrintBase.getRefPSDEName());
        }
        if (pSDEPrintBase.isReportFileDirty() && (bl || pSDEPrintBase.getReportFile() != null)) {
            iDataObject.set(FIELD_REPORTFILE, (Object)pSDEPrintBase.getReportFile());
        }
        if (pSDEPrintBase.isReportTypeDirty() && (bl || pSDEPrintBase.getReportType() != null)) {
            iDataObject.set(FIELD_REPORTTYPE, (Object)pSDEPrintBase.getReportType());
        }
        if (pSDEPrintBase.isToDoTaskDirty() && (bl || pSDEPrintBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEPrintBase.getToDoTask());
        }
        if (pSDEPrintBase.isUpdateDateDirty() && (bl || pSDEPrintBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEPrintBase.getUpdateDate());
        }
        if (pSDEPrintBase.isUpdateManDirty() && (bl || pSDEPrintBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEPrintBase.getUpdateMan());
        }
        if (pSDEPrintBase.isUserCatDirty() && (bl || pSDEPrintBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEPrintBase.getUserCat());
        }
        if (pSDEPrintBase.isUserTagDirty() && (bl || pSDEPrintBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEPrintBase.getUserTag());
        }
        if (pSDEPrintBase.isUserTag2Dirty() && (bl || pSDEPrintBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEPrintBase.getUserTag2());
        }
        if (pSDEPrintBase.isUserTag3Dirty() && (bl || pSDEPrintBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEPrintBase.getUserTag3());
        }
        if (pSDEPrintBase.isUserTag4Dirty() && (bl || pSDEPrintBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEPrintBase.getUserTag4());
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
        return PSDEPrintBase.remove(this, n);
    }

    private static boolean remove(PSDEPrintBase pSDEPrintBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEPrintBase.resetADPSDELogicId();
                return true;
            }
            case 1: {
                pSDEPrintBase.resetADPSDELogicName();
                return true;
            }
            case 2: {
                pSDEPrintBase.resetCodeName();
                return true;
            }
            case 3: {
                pSDEPrintBase.resetContentType();
                return true;
            }
            case 4: {
                pSDEPrintBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEPrintBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEPrintBase.resetCustomCode();
                return true;
            }
            case 7: {
                pSDEPrintBase.resetCustomMode();
                return true;
            }
            case 8: {
                pSDEPrintBase.resetDefaultMode();
                return true;
            }
            case 9: {
                pSDEPrintBase.resetEnableColPriv();
                return true;
            }
            case 10: {
                pSDEPrintBase.resetEnableLog();
                return true;
            }
            case 11: {
                pSDEPrintBase.resetEnableMP();
                return true;
            }
            case 12: {
                pSDEPrintBase.resetExtendMode();
                return true;
            }
            case 13: {
                pSDEPrintBase.resetGetDataPSDEActionId();
                return true;
            }
            case 14: {
                pSDEPrintBase.resetGetDataPSDEActionName();
                return true;
            }
            case 15: {
                pSDEPrintBase.resetLayoutPanelMode();
                return true;
            }
            case 16: {
                pSDEPrintBase.resetLockFlag();
                return true;
            }
            case 17: {
                pSDEPrintBase.resetLogicName();
                return true;
            }
            case 18: {
                pSDEPrintBase.resetMemo();
                return true;
            }
            case 19: {
                pSDEPrintBase.resetPOTime();
                return true;
            }
            case 20: {
                pSDEPrintBase.resetPrintModel();
                return true;
            }
            case 21: {
                pSDEPrintBase.resetPrintParams();
                return true;
            }
            case 22: {
                pSDEPrintBase.resetPrintTag();
                return true;
            }
            case 23: {
                pSDEPrintBase.resetPrintTag2();
                return true;
            }
            case 24: {
                pSDEPrintBase.resetPrintUIModel();
                return true;
            }
            case 25: {
                pSDEPrintBase.resetPSDEDataSetId();
                return true;
            }
            case 26: {
                pSDEPrintBase.resetPSDEDataSetName();
                return true;
            }
            case 27: {
                pSDEPrintBase.resetPSDEId();
                return true;
            }
            case 28: {
                pSDEPrintBase.resetPSDEName();
                return true;
            }
            case 29: {
                pSDEPrintBase.resetPSDEPrintId();
                return true;
            }
            case 30: {
                pSDEPrintBase.resetPSDEPrintName();
                return true;
            }
            case 31: {
                pSDEPrintBase.resetPSSysPFPluginId();
                return true;
            }
            case 32: {
                pSDEPrintBase.resetPSSysPFPluginName();
                return true;
            }
            case 33: {
                pSDEPrintBase.resetPSSysReqItemId();
                return true;
            }
            case 34: {
                pSDEPrintBase.resetPSSysReqItemName();
                return true;
            }
            case 35: {
                pSDEPrintBase.resetPSSysResourceId();
                return true;
            }
            case 36: {
                pSDEPrintBase.resetPSSysResourceName();
                return true;
            }
            case 37: {
                pSDEPrintBase.resetPSSysSFPluginId();
                return true;
            }
            case 38: {
                pSDEPrintBase.resetPSSysSFPluginName();
                return true;
            }
            case 39: {
                pSDEPrintBase.resetPSSysUniResId();
                return true;
            }
            case 40: {
                pSDEPrintBase.resetPSSysUniResName();
                return true;
            }
            case 41: {
                pSDEPrintBase.resetPSSysViewPanelId();
                return true;
            }
            case 42: {
                pSDEPrintBase.resetPSSysViewPanelName();
                return true;
            }
            case 43: {
                pSDEPrintBase.resetPSViewMsgGroupId();
                return true;
            }
            case 44: {
                pSDEPrintBase.resetPSViewMsgGroupName();
                return true;
            }
            case 45: {
                pSDEPrintBase.resetReadPSDEOPPrivId();
                return true;
            }
            case 46: {
                pSDEPrintBase.resetReadPSDEOPPrivName();
                return true;
            }
            case 47: {
                pSDEPrintBase.resetRefPSDEId();
                return true;
            }
            case 48: {
                pSDEPrintBase.resetRefPSDEName();
                return true;
            }
            case 49: {
                pSDEPrintBase.resetReportFile();
                return true;
            }
            case 50: {
                pSDEPrintBase.resetReportType();
                return true;
            }
            case 51: {
                pSDEPrintBase.resetToDoTask();
                return true;
            }
            case 52: {
                pSDEPrintBase.resetUpdateDate();
                return true;
            }
            case 53: {
                pSDEPrintBase.resetUpdateMan();
                return true;
            }
            case 54: {
                pSDEPrintBase.resetUserCat();
                return true;
            }
            case 55: {
                pSDEPrintBase.resetUserTag();
                return true;
            }
            case 56: {
                pSDEPrintBase.resetUserTag2();
                return true;
            }
            case 57: {
                pSDEPrintBase.resetUserTag3();
                return true;
            }
            case 58: {
                pSDEPrintBase.resetUserTag4();
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
    public PSDataEntity getRefPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDE();
        }
        if (this.getRefPSDEId() == null) {
            return null;
        }
        Integer n = this.objRefPSDELock;
        synchronized (n) {
            if (this.refpsde != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEId(), (Object)this.refpsde.getPSDataEntityId()) != 0L) {
                this.refpsde = null;
            }
            if (this.refpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getRefPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.refpsde = pSDataEntity;
            }
            return this.refpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getGetDataPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDataPSDEAction();
        }
        if (this.getGetDataPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objGetDataPSDEActionLock;
        synchronized (n) {
            if (this.getdatapsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getGetDataPSDEActionId(), (Object)this.getdatapsdeaction.getPSDEActionId()) != 0L) {
                this.getdatapsdeaction = null;
            }
            if (this.getdatapsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getGetDataPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.getdatapsdeaction = pSDEAction;
            }
            return this.getdatapsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
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
                pSDELogicService.autoGet(pSDELogic);
                this.adpsdelogic = pSDELogic;
            }
            return this.adpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEOPPriv getReadPSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadPSDEOPPriv();
        }
        if (this.getReadPSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objReadPSDEOPPrivLock;
        synchronized (n) {
            if (this.readpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getReadPSDEOPPrivId(), (Object)this.readpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.readpsdeoppriv = null;
            }
            if (this.readpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getReadPSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.readpsdeoppriv = pSDEOPPriv;
            }
            return this.readpsdeoppriv;
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
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
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
                pSSysReqItemService.autoGet(pSSysReqItem);
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
                pSSysResourceService.autoGet(pSSysResource);
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
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
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
                pSSysUniResService.autoGet(pSSysUniRes);
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
                pSSysViewPanelService.autoGet(pSSysViewPanel);
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
                pSViewMsgGroupService.autoGet(pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    private PSDEPrintBase getProxyEntity() {
        return this.proxyPSDEPrintBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEPrintBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEPrintBase) {
            this.proxyPSDEPrintBase = (PSDEPrintBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_DEFAULTMODE, 8);
        fieldIndexMap.put(FIELD_ENABLECOLPRIV, 9);
        fieldIndexMap.put(FIELD_ENABLELOG, 10);
        fieldIndexMap.put(FIELD_ENABLEMP, 11);
        fieldIndexMap.put(FIELD_EXTENDMODE, 12);
        fieldIndexMap.put(FIELD_GETDATAPSDEACTIONID, 13);
        fieldIndexMap.put(FIELD_GETDATAPSDEACTIONNAME, 14);
        fieldIndexMap.put(FIELD_LAYOUTPANELMODE, 15);
        fieldIndexMap.put(FIELD_LOCKFLAG, 16);
        fieldIndexMap.put(FIELD_LOGICNAME, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_POTIME, 19);
        fieldIndexMap.put(FIELD_PRINTMODEL, 20);
        fieldIndexMap.put(FIELD_PRINTPARAMS, 21);
        fieldIndexMap.put(FIELD_PRINTTAG, 22);
        fieldIndexMap.put(FIELD_PRINTTAG2, 23);
        fieldIndexMap.put(FIELD_PRINTUIMODEL, 24);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 25);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 26);
        fieldIndexMap.put(FIELD_PSDEID, 27);
        fieldIndexMap.put(FIELD_PSDENAME, 28);
        fieldIndexMap.put(FIELD_PSDEPRINTID, 29);
        fieldIndexMap.put(FIELD_PSDEPRINTNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 31);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 33);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 35);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 36);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 37);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 39);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 40);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 41);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 42);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 43);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 44);
        fieldIndexMap.put(FIELD_READPSDEOPPRIVID, 45);
        fieldIndexMap.put(FIELD_READPSDEOPPRIVNAME, 46);
        fieldIndexMap.put(FIELD_REFPSDEID, 47);
        fieldIndexMap.put(FIELD_REFPSDENAME, 48);
        fieldIndexMap.put(FIELD_REPORTFILE, 49);
        fieldIndexMap.put(FIELD_REPORTTYPE, 50);
        fieldIndexMap.put(FIELD_TODOTASK, 51);
        fieldIndexMap.put(FIELD_UPDATEDATE, 52);
        fieldIndexMap.put(FIELD_UPDATEMAN, 53);
        fieldIndexMap.put(FIELD_USERCAT, 54);
        fieldIndexMap.put(FIELD_USERTAG, 55);
        fieldIndexMap.put(FIELD_USERTAG2, 56);
        fieldIndexMap.put(FIELD_USERTAG3, 57);
        fieldIndexMap.put(FIELD_USERTAG4, 58);
    }
}

