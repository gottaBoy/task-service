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
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEACModeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEACModeBase.class);
    public static final String FIELD_ACIPSSYSPFPLUGINID = "ACIPSSYSPFPLUGINID";
    public static final String FIELD_ACIPSSYSPFPLUGINNAME = "ACIPSSYSPFPLUGINNAME";
    public static final String FIELD_ACPARAMS = "ACPARAMS";
    public static final String FIELD_ACTAG = "ACTAG";
    public static final String FIELD_ACTAG2 = "ACTAG2";
    public static final String FIELD_ACTAG3 = "ACTAG3";
    public static final String FIELD_ACTAG4 = "ACTAG4";
    public static final String FIELD_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String FIELD_ACTYPE = "ACTYPE";
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_AIFACTORYPSSYSUTILDEID = "AIFACTORYPSSYSUTILDEID";
    public static final String FIELD_AIFACTORYPSSYSUTILDENAME = "AIFACTORYPSSYSUTILDENAME";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String FIELD_CREATEPSDEOPPRIVNAME = "CREATEPSDEOPPRIVNAME";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String FIELD_ENABLEPAGINGBAR = "ENABLEPAGINGBAR";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FILLEROBJ = "FILLEROBJ";
    public static final String FIELD_HISTORYPSSYSMSGTEMPLID = "HISTORYPSSYSMSGTEMPLID";
    public static final String FIELD_HISTORYPSSYSMSGTEMPLNAME = "HISTORYPSSYSMSGTEMPLNAME";
    public static final String FIELD_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String FIELD_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORSORTDIR = "MINORSORTDIR";
    public static final String FIELD_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String FIELD_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String FIELD_PAGINGSIZE = "PAGINGSIZE";
    public static final String FIELD_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String FIELD_PSDEACMODEID = "PSDEACMODEID";
    public static final String FIELD_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSAICHATAGENTID = "PSSYSAICHATAGENTID";
    public static final String FIELD_PSSYSAICHATAGENTNAME = "PSSYSAICHATAGENTNAME";
    public static final String FIELD_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String FIELD_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_READPSDEOPPRIVID = "READPSDEOPPRIVID";
    public static final String FIELD_READPSDEOPPRIVNAME = "READPSDEOPPRIVNAME";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String FIELD_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    private static final int INDEX_ACIPSSYSPFPLUGINID = 0;
    private static final int INDEX_ACIPSSYSPFPLUGINNAME = 1;
    private static final int INDEX_ACPARAMS = 2;
    private static final int INDEX_ACTAG = 3;
    private static final int INDEX_ACTAG2 = 4;
    private static final int INDEX_ACTAG3 = 5;
    private static final int INDEX_ACTAG4 = 6;
    private static final int INDEX_ACTIONHOLDER = 7;
    private static final int INDEX_ACTYPE = 8;
    private static final int INDEX_ADPSDELOGICID = 9;
    private static final int INDEX_ADPSDELOGICNAME = 10;
    private static final int INDEX_AIFACTORYPSSYSUTILDEID = 11;
    private static final int INDEX_AIFACTORYPSSYSUTILDENAME = 12;
    private static final int INDEX_CODENAME = 13;
    private static final int INDEX_CREATEDATE = 14;
    private static final int INDEX_CREATEMAN = 15;
    private static final int INDEX_CREATEPSDEOPPRIVID = 16;
    private static final int INDEX_CREATEPSDEOPPRIVNAME = 17;
    private static final int INDEX_CUSTOMCODE = 18;
    private static final int INDEX_CUSTOMMODE = 19;
    private static final int INDEX_DEFAULTMODE = 20;
    private static final int INDEX_DYNAMODELFLAG = 21;
    private static final int INDEX_EMPTYTEXT = 22;
    private static final int INDEX_EMPTYTEXTPSLANRESID = 23;
    private static final int INDEX_EMPTYTEXTPSLANRESNAME = 24;
    private static final int INDEX_ENABLEPAGINGBAR = 25;
    private static final int INDEX_EXTENDMODE = 26;
    private static final int INDEX_FILLEROBJ = 27;
    private static final int INDEX_HISTORYPSSYSMSGTEMPLID = 28;
    private static final int INDEX_HISTORYPSSYSMSGTEMPLNAME = 29;
    private static final int INDEX_LINKPSDEVIEWID = 30;
    private static final int INDEX_LINKPSDEVIEWNAME = 31;
    private static final int INDEX_LOCKFLAG = 32;
    private static final int INDEX_LOGICNAME = 33;
    private static final int INDEX_MEMO = 34;
    private static final int INDEX_MINORSORTDIR = 35;
    private static final int INDEX_MINORSORTPSDEFID = 36;
    private static final int INDEX_MINORSORTPSDEFNAME = 37;
    private static final int INDEX_PAGINGSIZE = 38;
    private static final int INDEX_PICKUPPSDEVIEWID = 39;
    private static final int INDEX_PICKUPPSDEVIEWNAME = 40;
    private static final int INDEX_PSDEACMODEID = 41;
    private static final int INDEX_PSDEACMODENAME = 42;
    private static final int INDEX_PSDEDATASETID = 43;
    private static final int INDEX_PSDEDATASETNAME = 44;
    private static final int INDEX_PSDEID = 45;
    private static final int INDEX_PSDENAME = 46;
    private static final int INDEX_PSDEUAGROUPID = 47;
    private static final int INDEX_PSDEUAGROUPNAME = 48;
    private static final int INDEX_PSDYNAINSTID = 49;
    private static final int INDEX_PSSYSAICHATAGENTID = 50;
    private static final int INDEX_PSSYSAICHATAGENTNAME = 51;
    private static final int INDEX_PSSYSAIFACTORYID = 52;
    private static final int INDEX_PSSYSAIFACTORYNAME = 53;
    private static final int INDEX_PSSYSSFPLUGINID = 54;
    private static final int INDEX_PSSYSSFPLUGINNAME = 55;
    private static final int INDEX_PSSYSVIEWPANELID = 56;
    private static final int INDEX_PSSYSVIEWPANELNAME = 57;
    private static final int INDEX_READPSDEOPPRIVID = 58;
    private static final int INDEX_READPSDEOPPRIVNAME = 59;
    private static final int INDEX_TEXTPSDEFID = 60;
    private static final int INDEX_TEXTPSDEFNAME = 61;
    private static final int INDEX_UPDATEDATE = 62;
    private static final int INDEX_UPDATEMAN = 63;
    private static final int INDEX_USERCAT = 64;
    private static final int INDEX_USERTAG = 65;
    private static final int INDEX_USERTAG2 = 66;
    private static final int INDEX_USERTAG3 = 67;
    private static final int INDEX_USERTAG4 = 68;
    private static final int INDEX_VALUEPSDEFID = 69;
    private static final int INDEX_VALUEPSDEFNAME = 70;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEACModeBase proxyPSDEACModeBase = null;
    private boolean acipssyspfpluginidDirtyFlag = false;
    private boolean acipssyspfpluginnameDirtyFlag = false;
    private boolean acparamsDirtyFlag = false;
    private boolean actagDirtyFlag = false;
    private boolean actag2DirtyFlag = false;
    private boolean actag3DirtyFlag = false;
    private boolean actag4DirtyFlag = false;
    private boolean actionholderDirtyFlag = false;
    private boolean actypeDirtyFlag = false;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean aifactorypssysutildeidDirtyFlag = false;
    private boolean aifactorypssysutildenameDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createpsdeopprividDirtyFlag = false;
    private boolean createpsdeopprivnameDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpslanresidDirtyFlag = false;
    private boolean emptytextpslanresnameDirtyFlag = false;
    private boolean enablepagingbarDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean fillerobjDirtyFlag = false;
    private boolean historypssysmsgtemplidDirtyFlag = false;
    private boolean historypssysmsgtemplnameDirtyFlag = false;
    private boolean linkpsdeviewidDirtyFlag = false;
    private boolean linkpsdeviewnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorsortdirDirtyFlag = false;
    private boolean minorsortpsdefidDirtyFlag = false;
    private boolean minorsortpsdefnameDirtyFlag = false;
    private boolean pagingsizeDirtyFlag = false;
    private boolean pickuppsdeviewidDirtyFlag = false;
    private boolean pickuppsdeviewnameDirtyFlag = false;
    private boolean psdeacmodeidDirtyFlag = false;
    private boolean psdeacmodenameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysaichatagentidDirtyFlag = false;
    private boolean pssysaichatagentnameDirtyFlag = false;
    private boolean pssysaifactoryidDirtyFlag = false;
    private boolean pssysaifactorynameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean readpsdeopprividDirtyFlag = false;
    private boolean readpsdeopprivnameDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean valuepsdefidDirtyFlag = false;
    private boolean valuepsdefnameDirtyFlag = false;
    @Column(name="acipssyspfpluginid")
    private String acipssyspfpluginid;
    @Column(name="acipssyspfpluginname")
    private String acipssyspfpluginname;
    @Column(name="acparams")
    private String acparams;
    @Column(name="actag")
    private String actag;
    @Column(name="actag2")
    private String actag2;
    @Column(name="actag3")
    private String actag3;
    @Column(name="actag4")
    private String actag4;
    @Column(name="actionholder")
    private Integer actionholder;
    @Column(name="actype")
    private String actype;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="aifactorypssysutildeid")
    private String aifactorypssysutildeid;
    @Column(name="aifactorypssysutildename")
    private String aifactorypssysutildename;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="createpsdeopprivid")
    private String createpsdeopprivid;
    @Column(name="createpsdeopprivname")
    private String createpsdeopprivname;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="emptytextpslanresid")
    private String emptytextpslanresid;
    @Column(name="emptytextpslanresname")
    private String emptytextpslanresname;
    @Column(name="enablepagingbar")
    private Integer enablepagingbar;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="fillerobj")
    private String fillerobj;
    @Column(name="historypssysmsgtemplid")
    private String historypssysmsgtemplid;
    @Column(name="historypssysmsgtemplname")
    private String historypssysmsgtemplname;
    @Column(name="linkpsdeviewid")
    private String linkpsdeviewid;
    @Column(name="linkpsdeviewname")
    private String linkpsdeviewname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="minorsortdir")
    private String minorsortdir;
    @Column(name="minorsortpsdefid")
    private String minorsortpsdefid;
    @Column(name="minorsortpsdefname")
    private String minorsortpsdefname;
    @Column(name="pagingsize")
    private Integer pagingsize;
    @Column(name="pickuppsdeviewid")
    private String pickuppsdeviewid;
    @Column(name="pickuppsdeviewname")
    private String pickuppsdeviewname;
    @Column(name="psdeacmodeid")
    private String psdeacmodeid;
    @Column(name="psdeacmodename")
    private String psdeacmodename;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysaichatagentid")
    private String pssysaichatagentid;
    @Column(name="pssysaichatagentname")
    private String pssysaichatagentname;
    @Column(name="pssysaifactoryid")
    private String pssysaifactoryid;
    @Column(name="pssysaifactoryname")
    private String pssysaifactoryname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="readpsdeopprivid")
    private String readpsdeopprivid;
    @Column(name="readpsdeopprivname")
    private String readpsdeopprivname;
    @Column(name="textpsdefid")
    private String textpsdefid;
    @Column(name="textpsdefname")
    private String textpsdefname;
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
    @Column(name="valuepsdefid")
    private String valuepsdefid;
    @Column(name="valuepsdefname")
    private String valuepsdefname;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objMinorSortPSDEFLock = new Integer(1);
    private PSDEField minorsortpsdef = null;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objValuePSDEFLock = new Integer(1);
    private PSDEField valuepsdef = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objCreatePSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv createpsdeoppriv = null;
    private Integer objReadPSDEOPPrivLock = new Integer(1);
    private PSDEOPPriv readpsdeoppriv = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase linkpsdeview = null;
    private Integer objPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase pickuppsdeview = null;
    private Integer objEmptyTextPSLanResLock = new Integer(1);
    private PSLanguageRes emptytextpslanres = null;
    private Integer objPSSysAIChatAgentLock = new Integer(1);
    private PSSysAIChatAgent pssysaichatagent = null;
    private Integer objPSSysAIFactoryLock = new Integer(1);
    private PSSysAIFactory pssysaifactory = null;
    private Integer objHistoryPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl historypssysmsgtempl = null;
    private Integer objACIPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin acipssyspfplugin = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objAIFactoryPSSysUtilDELock = new Integer(1);
    private PSSysUtilDE aifactorypssysutilde = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSDEACModeItemsLock = new Integer(1);
    private ArrayList<PSDEACModeItem> psdeacmodeitems = null;

    public void setACIPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACIPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.acipssyspfpluginid = string;
        this.acipssyspfpluginidDirtyFlag = true;
    }

    public String getACIPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACIPSSysPFPluginId();
        }
        return this.acipssyspfpluginid;
    }

    public boolean isACIPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACIPSSysPFPluginIdDirty();
        }
        return this.acipssyspfpluginidDirtyFlag;
    }

    public void resetACIPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACIPSSysPFPluginId();
            return;
        }
        this.acipssyspfpluginidDirtyFlag = false;
        this.acipssyspfpluginid = null;
    }

    public void setACIPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACIPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.acipssyspfpluginname = string;
        this.acipssyspfpluginnameDirtyFlag = true;
    }

    public String getACIPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACIPSSysPFPluginName();
        }
        return this.acipssyspfpluginname;
    }

    public boolean isACIPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACIPSSysPFPluginNameDirty();
        }
        return this.acipssyspfpluginnameDirtyFlag;
    }

    public void resetACIPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACIPSSysPFPluginName();
            return;
        }
        this.acipssyspfpluginnameDirtyFlag = false;
        this.acipssyspfpluginname = null;
    }

    public void setACParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.acparams = string;
        this.acparamsDirtyFlag = true;
    }

    public String getACParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACParams();
        }
        return this.acparams;
    }

    public boolean isACParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACParamsDirty();
        }
        return this.acparamsDirtyFlag;
    }

    public void resetACParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACParams();
            return;
        }
        this.acparamsDirtyFlag = false;
        this.acparams = null;
    }

    public void setACTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actag = string;
        this.actagDirtyFlag = true;
    }

    public String getACTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACTag();
        }
        return this.actag;
    }

    public boolean isACTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACTagDirty();
        }
        return this.actagDirtyFlag;
    }

    public void resetACTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACTag();
            return;
        }
        this.actagDirtyFlag = false;
        this.actag = null;
    }

    public void setACTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actag2 = string;
        this.actag2DirtyFlag = true;
    }

    public String getACTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACTag2();
        }
        return this.actag2;
    }

    public boolean isACTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACTag2Dirty();
        }
        return this.actag2DirtyFlag;
    }

    public void resetACTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACTag2();
            return;
        }
        this.actag2DirtyFlag = false;
        this.actag2 = null;
    }

    public void setACTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actag3 = string;
        this.actag3DirtyFlag = true;
    }

    public String getACTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACTag3();
        }
        return this.actag3;
    }

    public boolean isACTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACTag3Dirty();
        }
        return this.actag3DirtyFlag;
    }

    public void resetACTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACTag3();
            return;
        }
        this.actag3DirtyFlag = false;
        this.actag3 = null;
    }

    public void setACTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actag4 = string;
        this.actag4DirtyFlag = true;
    }

    public String getACTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACTag4();
        }
        return this.actag4;
    }

    public boolean isACTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACTag4Dirty();
        }
        return this.actag4DirtyFlag;
    }

    public void resetACTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACTag4();
            return;
        }
        this.actag4DirtyFlag = false;
        this.actag4 = null;
    }

    public void setActionHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionHolder(n);
            return;
        }
        this.actionholder = n;
        this.actionholderDirtyFlag = true;
    }

    public Integer getActionHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionHolder();
        }
        return this.actionholder;
    }

    public boolean isActionHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionHolderDirty();
        }
        return this.actionholderDirtyFlag;
    }

    public void resetActionHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionHolder();
            return;
        }
        this.actionholderDirtyFlag = false;
        this.actionholder = null;
    }

    public void setACType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setACType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actype = string;
        this.actypeDirtyFlag = true;
    }

    public String getACType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACType();
        }
        return this.actype;
    }

    public boolean isACTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isACTypeDirty();
        }
        return this.actypeDirtyFlag;
    }

    public void resetACType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetACType();
            return;
        }
        this.actypeDirtyFlag = false;
        this.actype = null;
    }

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

    public void setAIFactoryPSSysUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIFactoryPSSysUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aifactorypssysutildeid = string;
        this.aifactorypssysutildeidDirtyFlag = true;
    }

    public String getAIFactoryPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIFactoryPSSysUtilDEId();
        }
        return this.aifactorypssysutildeid;
    }

    public boolean isAIFactoryPSSysUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIFactoryPSSysUtilDEIdDirty();
        }
        return this.aifactorypssysutildeidDirtyFlag;
    }

    public void resetAIFactoryPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIFactoryPSSysUtilDEId();
            return;
        }
        this.aifactorypssysutildeidDirtyFlag = false;
        this.aifactorypssysutildeid = null;
    }

    public void setAIFactoryPSSysUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIFactoryPSSysUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aifactorypssysutildename = string;
        this.aifactorypssysutildenameDirtyFlag = true;
    }

    public String getAIFactoryPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIFactoryPSSysUtilDEName();
        }
        return this.aifactorypssysutildename;
    }

    public boolean isAIFactoryPSSysUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIFactoryPSSysUtilDENameDirty();
        }
        return this.aifactorypssysutildenameDirtyFlag;
    }

    public void resetAIFactoryPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIFactoryPSSysUtilDEName();
            return;
        }
        this.aifactorypssysutildenameDirtyFlag = false;
        this.aifactorypssysutildename = null;
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

    public void setCreatePSDEOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeopprivid = string;
        this.createpsdeopprividDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivId();
        }
        return this.createpsdeopprivid;
    }

    public boolean isCreatePSDEOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivIdDirty();
        }
        return this.createpsdeopprividDirtyFlag;
    }

    public void resetCreatePSDEOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivId();
            return;
        }
        this.createpsdeopprividDirtyFlag = false;
        this.createpsdeopprivid = null;
    }

    public void setCreatePSDEOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatePSDEOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createpsdeopprivname = string;
        this.createpsdeopprivnameDirtyFlag = true;
    }

    public String getCreatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPrivName();
        }
        return this.createpsdeopprivname;
    }

    public boolean isCreatePSDEOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatePSDEOPPrivNameDirty();
        }
        return this.createpsdeopprivnameDirtyFlag;
    }

    public void resetCreatePSDEOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatePSDEOPPrivName();
            return;
        }
        this.createpsdeopprivnameDirtyFlag = false;
        this.createpsdeopprivname = null;
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

    public void setEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytext = string;
        this.emptytextDirtyFlag = true;
    }

    public String getEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyText();
        }
        return this.emptytext;
    }

    public boolean isEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextDirty();
        }
        return this.emptytextDirtyFlag;
    }

    public void resetEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyText();
            return;
        }
        this.emptytextDirtyFlag = false;
        this.emptytext = null;
    }

    public void setEmptyTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresid = string;
        this.emptytextpslanresidDirtyFlag = true;
    }

    public String getEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResId();
        }
        return this.emptytextpslanresid;
    }

    public boolean isEmptyTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResIdDirty();
        }
        return this.emptytextpslanresidDirtyFlag;
    }

    public void resetEmptyTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResId();
            return;
        }
        this.emptytextpslanresidDirtyFlag = false;
        this.emptytextpslanresid = null;
    }

    public void setEmptyTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpslanresname = string;
        this.emptytextpslanresnameDirtyFlag = true;
    }

    public String getEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanResName();
        }
        return this.emptytextpslanresname;
    }

    public boolean isEmptyTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSLanResNameDirty();
        }
        return this.emptytextpslanresnameDirtyFlag;
    }

    public void resetEmptyTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSLanResName();
            return;
        }
        this.emptytextpslanresnameDirtyFlag = false;
        this.emptytextpslanresname = null;
    }

    public void setEnablePagingBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnablePagingBar(n);
            return;
        }
        this.enablepagingbar = n;
        this.enablepagingbarDirtyFlag = true;
    }

    public Integer getEnablePagingBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnablePagingBar();
        }
        return this.enablepagingbar;
    }

    public boolean isEnablePagingBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnablePagingBarDirty();
        }
        return this.enablepagingbarDirtyFlag;
    }

    public void resetEnablePagingBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnablePagingBar();
            return;
        }
        this.enablepagingbarDirtyFlag = false;
        this.enablepagingbar = null;
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

    public void setFillerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFillerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fillerobj = string;
        this.fillerobjDirtyFlag = true;
    }

    public String getFillerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFillerObj();
        }
        return this.fillerobj;
    }

    public boolean isFillerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFillerObjDirty();
        }
        return this.fillerobjDirtyFlag;
    }

    public void resetFillerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFillerObj();
            return;
        }
        this.fillerobjDirtyFlag = false;
        this.fillerobj = null;
    }

    public void setHistoryPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHistoryPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.historypssysmsgtemplid = string;
        this.historypssysmsgtemplidDirtyFlag = true;
    }

    public String getHistoryPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHistoryPSSysMsgTemplId();
        }
        return this.historypssysmsgtemplid;
    }

    public boolean isHistoryPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHistoryPSSysMsgTemplIdDirty();
        }
        return this.historypssysmsgtemplidDirtyFlag;
    }

    public void resetHistoryPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHistoryPSSysMsgTemplId();
            return;
        }
        this.historypssysmsgtemplidDirtyFlag = false;
        this.historypssysmsgtemplid = null;
    }

    public void setHistoryPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHistoryPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.historypssysmsgtemplname = string;
        this.historypssysmsgtemplnameDirtyFlag = true;
    }

    public String getHistoryPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHistoryPSSysMsgTemplName();
        }
        return this.historypssysmsgtemplname;
    }

    public boolean isHistoryPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHistoryPSSysMsgTemplNameDirty();
        }
        return this.historypssysmsgtemplnameDirtyFlag;
    }

    public void resetHistoryPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHistoryPSSysMsgTemplName();
            return;
        }
        this.historypssysmsgtemplnameDirtyFlag = false;
        this.historypssysmsgtemplname = null;
    }

    public void setLinkPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdeviewid = string;
        this.linkpsdeviewidDirtyFlag = true;
    }

    public String getLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEViewId();
        }
        return this.linkpsdeviewid;
    }

    public boolean isLinkPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEViewIdDirty();
        }
        return this.linkpsdeviewidDirtyFlag;
    }

    public void resetLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEViewId();
            return;
        }
        this.linkpsdeviewidDirtyFlag = false;
        this.linkpsdeviewid = null;
    }

    public void setLinkPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkpsdeviewname = string;
        this.linkpsdeviewnameDirtyFlag = true;
    }

    public String getLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEViewName();
        }
        return this.linkpsdeviewname;
    }

    public boolean isLinkPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkPSDEViewNameDirty();
        }
        return this.linkpsdeviewnameDirtyFlag;
    }

    public void resetLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkPSDEViewName();
            return;
        }
        this.linkpsdeviewnameDirtyFlag = false;
        this.linkpsdeviewname = null;
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

    public void setMinorSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortdir = string;
        this.minorsortdirDirtyFlag = true;
    }

    public String getMinorSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortDir();
        }
        return this.minorsortdir;
    }

    public boolean isMinorSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortDirDirty();
        }
        return this.minorsortdirDirtyFlag;
    }

    public void resetMinorSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortDir();
            return;
        }
        this.minorsortdirDirtyFlag = false;
        this.minorsortdir = null;
    }

    public void setMinorSortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefid = string;
        this.minorsortpsdefidDirtyFlag = true;
    }

    public String getMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFId();
        }
        return this.minorsortpsdefid;
    }

    public boolean isMinorSortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFIdDirty();
        }
        return this.minorsortpsdefidDirtyFlag;
    }

    public void resetMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFId();
            return;
        }
        this.minorsortpsdefidDirtyFlag = false;
        this.minorsortpsdefid = null;
    }

    public void setMinorSortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefname = string;
        this.minorsortpsdefnameDirtyFlag = true;
    }

    public String getMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFName();
        }
        return this.minorsortpsdefname;
    }

    public boolean isMinorSortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFNameDirty();
        }
        return this.minorsortpsdefnameDirtyFlag;
    }

    public void resetMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFName();
            return;
        }
        this.minorsortpsdefnameDirtyFlag = false;
        this.minorsortpsdefname = null;
    }

    public void setPagingSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPagingSize(n);
            return;
        }
        this.pagingsize = n;
        this.pagingsizeDirtyFlag = true;
    }

    public Integer getPagingSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPagingSize();
        }
        return this.pagingsize;
    }

    public boolean isPagingSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPagingSizeDirty();
        }
        return this.pagingsizeDirtyFlag;
    }

    public void resetPagingSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPagingSize();
            return;
        }
        this.pagingsizeDirtyFlag = false;
        this.pagingsize = null;
    }

    public void setPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pickuppsdeviewid = string;
        this.pickuppsdeviewidDirtyFlag = true;
    }

    public String getPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupPSDEViewId();
        }
        return this.pickuppsdeviewid;
    }

    public boolean isPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPickupPSDEViewIdDirty();
        }
        return this.pickuppsdeviewidDirtyFlag;
    }

    public void resetPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPickupPSDEViewId();
            return;
        }
        this.pickuppsdeviewidDirtyFlag = false;
        this.pickuppsdeviewid = null;
    }

    public void setPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pickuppsdeviewname = string;
        this.pickuppsdeviewnameDirtyFlag = true;
    }

    public String getPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupPSDEViewName();
        }
        return this.pickuppsdeviewname;
    }

    public boolean isPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPickupPSDEViewNameDirty();
        }
        return this.pickuppsdeviewnameDirtyFlag;
    }

    public void resetPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPickupPSDEViewName();
            return;
        }
        this.pickuppsdeviewnameDirtyFlag = false;
        this.pickuppsdeviewname = null;
    }

    public void setPSDEACModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodeid = string;
        this.psdeacmodeidDirtyFlag = true;
    }

    public String getPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeId();
        }
        return this.psdeacmodeid;
    }

    public boolean isPSDEACModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeIdDirty();
        }
        return this.psdeacmodeidDirtyFlag;
    }

    public void resetPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeId();
            return;
        }
        this.psdeacmodeidDirtyFlag = false;
        this.psdeacmodeid = null;
    }

    public void setPSDEACModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodename = string;
        this.psdeacmodenameDirtyFlag = true;
    }

    public String getPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeName();
        }
        return this.psdeacmodename;
    }

    public boolean isPSDEACModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeNameDirty();
        }
        return this.psdeacmodenameDirtyFlag;
    }

    public void resetPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeName();
            return;
        }
        this.psdeacmodenameDirtyFlag = false;
        this.psdeacmodename = null;
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

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
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

    public void setPSSysAIChatAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIChatAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaichatagentid = string;
        this.pssysaichatagentidDirtyFlag = true;
    }

    public String getPSSysAIChatAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgentId();
        }
        return this.pssysaichatagentid;
    }

    public boolean isPSSysAIChatAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIChatAgentIdDirty();
        }
        return this.pssysaichatagentidDirtyFlag;
    }

    public void resetPSSysAIChatAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIChatAgentId();
            return;
        }
        this.pssysaichatagentidDirtyFlag = false;
        this.pssysaichatagentid = null;
    }

    public void setPSSysAIChatAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIChatAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaichatagentname = string;
        this.pssysaichatagentnameDirtyFlag = true;
    }

    public String getPSSysAIChatAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgentName();
        }
        return this.pssysaichatagentname;
    }

    public boolean isPSSysAIChatAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIChatAgentNameDirty();
        }
        return this.pssysaichatagentnameDirtyFlag;
    }

    public void resetPSSysAIChatAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIChatAgentName();
            return;
        }
        this.pssysaichatagentnameDirtyFlag = false;
        this.pssysaichatagentname = null;
    }

    public void setPSSysAIFactoryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIFactoryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaifactoryid = string;
        this.pssysaifactoryidDirtyFlag = true;
    }

    public String getPSSysAIFactoryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactoryId();
        }
        return this.pssysaifactoryid;
    }

    public boolean isPSSysAIFactoryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIFactoryIdDirty();
        }
        return this.pssysaifactoryidDirtyFlag;
    }

    public void resetPSSysAIFactoryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIFactoryId();
            return;
        }
        this.pssysaifactoryidDirtyFlag = false;
        this.pssysaifactoryid = null;
    }

    public void setPSSysAIFactoryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIFactoryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaifactoryname = string;
        this.pssysaifactorynameDirtyFlag = true;
    }

    public String getPSSysAIFactoryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactoryName();
        }
        return this.pssysaifactoryname;
    }

    public boolean isPSSysAIFactoryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIFactoryNameDirty();
        }
        return this.pssysaifactorynameDirtyFlag;
    }

    public void resetPSSysAIFactoryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIFactoryName();
            return;
        }
        this.pssysaifactorynameDirtyFlag = false;
        this.pssysaifactoryname = null;
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

    public void setTextPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefid = string;
        this.textpsdefidDirtyFlag = true;
    }

    public String getTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFId();
        }
        return this.textpsdefid;
    }

    public boolean isTextPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFIdDirty();
        }
        return this.textpsdefidDirtyFlag;
    }

    public void resetTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFId();
            return;
        }
        this.textpsdefidDirtyFlag = false;
        this.textpsdefid = null;
    }

    public void setTextPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefname = string;
        this.textpsdefnameDirtyFlag = true;
    }

    public String getTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFName();
        }
        return this.textpsdefname;
    }

    public boolean isTextPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFNameDirty();
        }
        return this.textpsdefnameDirtyFlag;
    }

    public void resetTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFName();
            return;
        }
        this.textpsdefnameDirtyFlag = false;
        this.textpsdefname = null;
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

    public void setValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefid = string;
        this.valuepsdefidDirtyFlag = true;
    }

    public String getValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFId();
        }
        return this.valuepsdefid;
    }

    public boolean isValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFIdDirty();
        }
        return this.valuepsdefidDirtyFlag;
    }

    public void resetValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFId();
            return;
        }
        this.valuepsdefidDirtyFlag = false;
        this.valuepsdefid = null;
    }

    public void setValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefname = string;
        this.valuepsdefnameDirtyFlag = true;
    }

    public String getValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFName();
        }
        return this.valuepsdefname;
    }

    public boolean isValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFNameDirty();
        }
        return this.valuepsdefnameDirtyFlag;
    }

    public void resetValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFName();
            return;
        }
        this.valuepsdefnameDirtyFlag = false;
        this.valuepsdefname = null;
    }

    protected void onReset() {
        PSDEACModeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEACModeBase pSDEACModeBase) {
        pSDEACModeBase.resetACIPSSysPFPluginId();
        pSDEACModeBase.resetACIPSSysPFPluginName();
        pSDEACModeBase.resetACParams();
        pSDEACModeBase.resetACTag();
        pSDEACModeBase.resetACTag2();
        pSDEACModeBase.resetACTag3();
        pSDEACModeBase.resetACTag4();
        pSDEACModeBase.resetActionHolder();
        pSDEACModeBase.resetACType();
        pSDEACModeBase.resetADPSDELogicId();
        pSDEACModeBase.resetADPSDELogicName();
        pSDEACModeBase.resetAIFactoryPSSysUtilDEId();
        pSDEACModeBase.resetAIFactoryPSSysUtilDEName();
        pSDEACModeBase.resetCodeName();
        pSDEACModeBase.resetCreateDate();
        pSDEACModeBase.resetCreateMan();
        pSDEACModeBase.resetCreatePSDEOPPrivId();
        pSDEACModeBase.resetCreatePSDEOPPrivName();
        pSDEACModeBase.resetCustomCode();
        pSDEACModeBase.resetCustomMode();
        pSDEACModeBase.resetDefaultMode();
        pSDEACModeBase.resetDynaModelFlag();
        pSDEACModeBase.resetEmptyText();
        pSDEACModeBase.resetEmptyTextPSLanResId();
        pSDEACModeBase.resetEmptyTextPSLanResName();
        pSDEACModeBase.resetEnablePagingBar();
        pSDEACModeBase.resetExtendMode();
        pSDEACModeBase.resetFillerObj();
        pSDEACModeBase.resetHistoryPSSysMsgTemplId();
        pSDEACModeBase.resetHistoryPSSysMsgTemplName();
        pSDEACModeBase.resetLinkPSDEViewId();
        pSDEACModeBase.resetLinkPSDEViewName();
        pSDEACModeBase.resetLockFlag();
        pSDEACModeBase.resetLogicName();
        pSDEACModeBase.resetMemo();
        pSDEACModeBase.resetMinorSortDir();
        pSDEACModeBase.resetMinorSortPSDEFId();
        pSDEACModeBase.resetMinorSortPSDEFName();
        pSDEACModeBase.resetPagingSize();
        pSDEACModeBase.resetPickupPSDEViewId();
        pSDEACModeBase.resetPickupPSDEViewName();
        pSDEACModeBase.resetPSDEACModeId();
        pSDEACModeBase.resetPSDEACModeName();
        pSDEACModeBase.resetPSDEDataSetId();
        pSDEACModeBase.resetPSDEDataSetName();
        pSDEACModeBase.resetPSDEId();
        pSDEACModeBase.resetPSDEName();
        pSDEACModeBase.resetPSDEUAGroupId();
        pSDEACModeBase.resetPSDEUAGroupName();
        pSDEACModeBase.resetPSDynaInstId();
        pSDEACModeBase.resetPSSysAIChatAgentId();
        pSDEACModeBase.resetPSSysAIChatAgentName();
        pSDEACModeBase.resetPSSysAIFactoryId();
        pSDEACModeBase.resetPSSysAIFactoryName();
        pSDEACModeBase.resetPSSysSFPluginId();
        pSDEACModeBase.resetPSSysSFPluginName();
        pSDEACModeBase.resetPSSysViewPanelId();
        pSDEACModeBase.resetPSSysViewPanelName();
        pSDEACModeBase.resetReadPSDEOPPrivId();
        pSDEACModeBase.resetReadPSDEOPPrivName();
        pSDEACModeBase.resetTextPSDEFId();
        pSDEACModeBase.resetTextPSDEFName();
        pSDEACModeBase.resetUpdateDate();
        pSDEACModeBase.resetUpdateMan();
        pSDEACModeBase.resetUserCat();
        pSDEACModeBase.resetUserTag();
        pSDEACModeBase.resetUserTag2();
        pSDEACModeBase.resetUserTag3();
        pSDEACModeBase.resetUserTag4();
        pSDEACModeBase.resetValuePSDEFId();
        pSDEACModeBase.resetValuePSDEFName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isACIPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_ACIPSSYSPFPLUGINID, this.getACIPSSysPFPluginId());
        }
        if (!bl || this.isACIPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_ACIPSSYSPFPLUGINNAME, this.getACIPSSysPFPluginName());
        }
        if (!bl || this.isACParamsDirty()) {
            hashMap.put(FIELD_ACPARAMS, this.getACParams());
        }
        if (!bl || this.isACTagDirty()) {
            hashMap.put(FIELD_ACTAG, this.getACTag());
        }
        if (!bl || this.isACTag2Dirty()) {
            hashMap.put(FIELD_ACTAG2, this.getACTag2());
        }
        if (!bl || this.isACTag3Dirty()) {
            hashMap.put(FIELD_ACTAG3, this.getACTag3());
        }
        if (!bl || this.isACTag4Dirty()) {
            hashMap.put(FIELD_ACTAG4, this.getACTag4());
        }
        if (!bl || this.isActionHolderDirty()) {
            hashMap.put(FIELD_ACTIONHOLDER, this.getActionHolder());
        }
        if (!bl || this.isACTypeDirty()) {
            hashMap.put(FIELD_ACTYPE, this.getACType());
        }
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isAIFactoryPSSysUtilDEIdDirty()) {
            hashMap.put(FIELD_AIFACTORYPSSYSUTILDEID, this.getAIFactoryPSSysUtilDEId());
        }
        if (!bl || this.isAIFactoryPSSysUtilDENameDirty()) {
            hashMap.put(FIELD_AIFACTORYPSSYSUTILDENAME, this.getAIFactoryPSSysUtilDEName());
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
        if (!bl || this.isCreatePSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVID, this.getCreatePSDEOPPrivId());
        }
        if (!bl || this.isCreatePSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_CREATEPSDEOPPRIVNAME, this.getCreatePSDEOPPrivName());
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEmptyTextDirty()) {
            hashMap.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bl || this.isEmptyTextPSLanResIdDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESID, this.getEmptyTextPSLanResId());
        }
        if (!bl || this.isEmptyTextPSLanResNameDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSLANRESNAME, this.getEmptyTextPSLanResName());
        }
        if (!bl || this.isEnablePagingBarDirty()) {
            hashMap.put(FIELD_ENABLEPAGINGBAR, this.getEnablePagingBar());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFillerObjDirty()) {
            hashMap.put(FIELD_FILLEROBJ, this.getFillerObj());
        }
        if (!bl || this.isHistoryPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_HISTORYPSSYSMSGTEMPLID, this.getHistoryPSSysMsgTemplId());
        }
        if (!bl || this.isHistoryPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_HISTORYPSSYSMSGTEMPLNAME, this.getHistoryPSSysMsgTemplName());
        }
        if (!bl || this.isLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWID, this.getLinkPSDEViewId());
        }
        if (!bl || this.isLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWNAME, this.getLinkPSDEViewName());
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
        if (!bl || this.isMinorSortDirDirty()) {
            hashMap.put(FIELD_MINORSORTDIR, this.getMinorSortDir());
        }
        if (!bl || this.isMinorSortPSDEFIdDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFID, this.getMinorSortPSDEFId());
        }
        if (!bl || this.isMinorSortPSDEFNameDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFNAME, this.getMinorSortPSDEFName());
        }
        if (!bl || this.isPagingSizeDirty()) {
            hashMap.put(FIELD_PAGINGSIZE, this.getPagingSize());
        }
        if (!bl || this.isPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_PICKUPPSDEVIEWID, this.getPickupPSDEViewId());
        }
        if (!bl || this.isPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_PICKUPPSDEVIEWNAME, this.getPickupPSDEViewName());
        }
        if (!bl || this.isPSDEACModeIdDirty()) {
            hashMap.put(FIELD_PSDEACMODEID, this.getPSDEACModeId());
        }
        if (!bl || this.isPSDEACModeNameDirty()) {
            hashMap.put(FIELD_PSDEACMODENAME, this.getPSDEACModeName());
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
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysAIChatAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAICHATAGENTID, this.getPSSysAIChatAgentId());
        }
        if (!bl || this.isPSSysAIChatAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAICHATAGENTNAME, this.getPSSysAIChatAgentName());
        }
        if (!bl || this.isPSSysAIFactoryIdDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYID, this.getPSSysAIFactoryId());
        }
        if (!bl || this.isPSSysAIFactoryNameDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYNAME, this.getPSSysAIFactoryName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isReadPSDEOPPrivIdDirty()) {
            hashMap.put(FIELD_READPSDEOPPRIVID, this.getReadPSDEOPPrivId());
        }
        if (!bl || this.isReadPSDEOPPrivNameDirty()) {
            hashMap.put(FIELD_READPSDEOPPRIVNAME, this.getReadPSDEOPPrivName());
        }
        if (!bl || this.isTextPSDEFIdDirty()) {
            hashMap.put(FIELD_TEXTPSDEFID, this.getTextPSDEFId());
        }
        if (!bl || this.isTextPSDEFNameDirty()) {
            hashMap.put(FIELD_TEXTPSDEFNAME, this.getTextPSDEFName());
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
        if (!bl || this.isValuePSDEFIdDirty()) {
            hashMap.put(FIELD_VALUEPSDEFID, this.getValuePSDEFId());
        }
        if (!bl || this.isValuePSDEFNameDirty()) {
            hashMap.put(FIELD_VALUEPSDEFNAME, this.getValuePSDEFName());
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
        return PSDEACModeBase.get(this, n);
    }

    private static Object get(PSDEACModeBase pSDEACModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEACModeBase.getACIPSSysPFPluginId();
            }
            case 1: {
                return pSDEACModeBase.getACIPSSysPFPluginName();
            }
            case 2: {
                return pSDEACModeBase.getACParams();
            }
            case 3: {
                return pSDEACModeBase.getACTag();
            }
            case 4: {
                return pSDEACModeBase.getACTag2();
            }
            case 5: {
                return pSDEACModeBase.getACTag3();
            }
            case 6: {
                return pSDEACModeBase.getACTag4();
            }
            case 7: {
                return pSDEACModeBase.getActionHolder();
            }
            case 8: {
                return pSDEACModeBase.getACType();
            }
            case 9: {
                return pSDEACModeBase.getADPSDELogicId();
            }
            case 10: {
                return pSDEACModeBase.getADPSDELogicName();
            }
            case 11: {
                return pSDEACModeBase.getAIFactoryPSSysUtilDEId();
            }
            case 12: {
                return pSDEACModeBase.getAIFactoryPSSysUtilDEName();
            }
            case 13: {
                return pSDEACModeBase.getCodeName();
            }
            case 14: {
                return pSDEACModeBase.getCreateDate();
            }
            case 15: {
                return pSDEACModeBase.getCreateMan();
            }
            case 16: {
                return pSDEACModeBase.getCreatePSDEOPPrivId();
            }
            case 17: {
                return pSDEACModeBase.getCreatePSDEOPPrivName();
            }
            case 18: {
                return pSDEACModeBase.getCustomCode();
            }
            case 19: {
                return pSDEACModeBase.getCustomMode();
            }
            case 20: {
                return pSDEACModeBase.getDefaultMode();
            }
            case 21: {
                return pSDEACModeBase.getDynaModelFlag();
            }
            case 22: {
                return pSDEACModeBase.getEmptyText();
            }
            case 23: {
                return pSDEACModeBase.getEmptyTextPSLanResId();
            }
            case 24: {
                return pSDEACModeBase.getEmptyTextPSLanResName();
            }
            case 25: {
                return pSDEACModeBase.getEnablePagingBar();
            }
            case 26: {
                return pSDEACModeBase.getExtendMode();
            }
            case 27: {
                return pSDEACModeBase.getFillerObj();
            }
            case 28: {
                return pSDEACModeBase.getHistoryPSSysMsgTemplId();
            }
            case 29: {
                return pSDEACModeBase.getHistoryPSSysMsgTemplName();
            }
            case 30: {
                return pSDEACModeBase.getLinkPSDEViewId();
            }
            case 31: {
                return pSDEACModeBase.getLinkPSDEViewName();
            }
            case 32: {
                return pSDEACModeBase.getLockFlag();
            }
            case 33: {
                return pSDEACModeBase.getLogicName();
            }
            case 34: {
                return pSDEACModeBase.getMemo();
            }
            case 35: {
                return pSDEACModeBase.getMinorSortDir();
            }
            case 36: {
                return pSDEACModeBase.getMinorSortPSDEFId();
            }
            case 37: {
                return pSDEACModeBase.getMinorSortPSDEFName();
            }
            case 38: {
                return pSDEACModeBase.getPagingSize();
            }
            case 39: {
                return pSDEACModeBase.getPickupPSDEViewId();
            }
            case 40: {
                return pSDEACModeBase.getPickupPSDEViewName();
            }
            case 41: {
                return pSDEACModeBase.getPSDEACModeId();
            }
            case 42: {
                return pSDEACModeBase.getPSDEACModeName();
            }
            case 43: {
                return pSDEACModeBase.getPSDEDataSetId();
            }
            case 44: {
                return pSDEACModeBase.getPSDEDataSetName();
            }
            case 45: {
                return pSDEACModeBase.getPSDEId();
            }
            case 46: {
                return pSDEACModeBase.getPSDEName();
            }
            case 47: {
                return pSDEACModeBase.getPSDEUAGroupId();
            }
            case 48: {
                return pSDEACModeBase.getPSDEUAGroupName();
            }
            case 49: {
                return pSDEACModeBase.getPSDynaInstId();
            }
            case 50: {
                return pSDEACModeBase.getPSSysAIChatAgentId();
            }
            case 51: {
                return pSDEACModeBase.getPSSysAIChatAgentName();
            }
            case 52: {
                return pSDEACModeBase.getPSSysAIFactoryId();
            }
            case 53: {
                return pSDEACModeBase.getPSSysAIFactoryName();
            }
            case 54: {
                return pSDEACModeBase.getPSSysSFPluginId();
            }
            case 55: {
                return pSDEACModeBase.getPSSysSFPluginName();
            }
            case 56: {
                return pSDEACModeBase.getPSSysViewPanelId();
            }
            case 57: {
                return pSDEACModeBase.getPSSysViewPanelName();
            }
            case 58: {
                return pSDEACModeBase.getReadPSDEOPPrivId();
            }
            case 59: {
                return pSDEACModeBase.getReadPSDEOPPrivName();
            }
            case 60: {
                return pSDEACModeBase.getTextPSDEFId();
            }
            case 61: {
                return pSDEACModeBase.getTextPSDEFName();
            }
            case 62: {
                return pSDEACModeBase.getUpdateDate();
            }
            case 63: {
                return pSDEACModeBase.getUpdateMan();
            }
            case 64: {
                return pSDEACModeBase.getUserCat();
            }
            case 65: {
                return pSDEACModeBase.getUserTag();
            }
            case 66: {
                return pSDEACModeBase.getUserTag2();
            }
            case 67: {
                return pSDEACModeBase.getUserTag3();
            }
            case 68: {
                return pSDEACModeBase.getUserTag4();
            }
            case 69: {
                return pSDEACModeBase.getValuePSDEFId();
            }
            case 70: {
                return pSDEACModeBase.getValuePSDEFName();
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
        PSDEACModeBase.set(this, n, object);
    }

    private static void set(PSDEACModeBase pSDEACModeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEACModeBase.setACIPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEACModeBase.setACIPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEACModeBase.setACParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEACModeBase.setACTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEACModeBase.setACTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEACModeBase.setACTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEACModeBase.setACTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEACModeBase.setActionHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEACModeBase.setACType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEACModeBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEACModeBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEACModeBase.setAIFactoryPSSysUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEACModeBase.setAIFactoryPSSysUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEACModeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEACModeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDEACModeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEACModeBase.setCreatePSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEACModeBase.setCreatePSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEACModeBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEACModeBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEACModeBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEACModeBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEACModeBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEACModeBase.setEmptyTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEACModeBase.setEmptyTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEACModeBase.setEnablePagingBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEACModeBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEACModeBase.setFillerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEACModeBase.setHistoryPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEACModeBase.setHistoryPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEACModeBase.setLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEACModeBase.setLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEACModeBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEACModeBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEACModeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEACModeBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEACModeBase.setMinorSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEACModeBase.setMinorSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEACModeBase.setPagingSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEACModeBase.setPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEACModeBase.setPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEACModeBase.setPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEACModeBase.setPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEACModeBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEACModeBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEACModeBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEACModeBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEACModeBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEACModeBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEACModeBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEACModeBase.setPSSysAIChatAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEACModeBase.setPSSysAIChatAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEACModeBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEACModeBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEACModeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEACModeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEACModeBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEACModeBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEACModeBase.setReadPSDEOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEACModeBase.setReadPSDEOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEACModeBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEACModeBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEACModeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 63: {
                pSDEACModeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEACModeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEACModeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEACModeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEACModeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEACModeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEACModeBase.setValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEACModeBase.setValuePSDEFName(DataObject.getStringValue((Object)object));
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
        return PSDEACModeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEACModeBase pSDEACModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEACModeBase.getACIPSSysPFPluginId() == null;
            }
            case 1: {
                return pSDEACModeBase.getACIPSSysPFPluginName() == null;
            }
            case 2: {
                return pSDEACModeBase.getACParams() == null;
            }
            case 3: {
                return pSDEACModeBase.getACTag() == null;
            }
            case 4: {
                return pSDEACModeBase.getACTag2() == null;
            }
            case 5: {
                return pSDEACModeBase.getACTag3() == null;
            }
            case 6: {
                return pSDEACModeBase.getACTag4() == null;
            }
            case 7: {
                return pSDEACModeBase.getActionHolder() == null;
            }
            case 8: {
                return pSDEACModeBase.getACType() == null;
            }
            case 9: {
                return pSDEACModeBase.getADPSDELogicId() == null;
            }
            case 10: {
                return pSDEACModeBase.getADPSDELogicName() == null;
            }
            case 11: {
                return pSDEACModeBase.getAIFactoryPSSysUtilDEId() == null;
            }
            case 12: {
                return pSDEACModeBase.getAIFactoryPSSysUtilDEName() == null;
            }
            case 13: {
                return pSDEACModeBase.getCodeName() == null;
            }
            case 14: {
                return pSDEACModeBase.getCreateDate() == null;
            }
            case 15: {
                return pSDEACModeBase.getCreateMan() == null;
            }
            case 16: {
                return pSDEACModeBase.getCreatePSDEOPPrivId() == null;
            }
            case 17: {
                return pSDEACModeBase.getCreatePSDEOPPrivName() == null;
            }
            case 18: {
                return pSDEACModeBase.getCustomCode() == null;
            }
            case 19: {
                return pSDEACModeBase.getCustomMode() == null;
            }
            case 20: {
                return pSDEACModeBase.getDefaultMode() == null;
            }
            case 21: {
                return pSDEACModeBase.getDynaModelFlag() == null;
            }
            case 22: {
                return pSDEACModeBase.getEmptyText() == null;
            }
            case 23: {
                return pSDEACModeBase.getEmptyTextPSLanResId() == null;
            }
            case 24: {
                return pSDEACModeBase.getEmptyTextPSLanResName() == null;
            }
            case 25: {
                return pSDEACModeBase.getEnablePagingBar() == null;
            }
            case 26: {
                return pSDEACModeBase.getExtendMode() == null;
            }
            case 27: {
                return pSDEACModeBase.getFillerObj() == null;
            }
            case 28: {
                return pSDEACModeBase.getHistoryPSSysMsgTemplId() == null;
            }
            case 29: {
                return pSDEACModeBase.getHistoryPSSysMsgTemplName() == null;
            }
            case 30: {
                return pSDEACModeBase.getLinkPSDEViewId() == null;
            }
            case 31: {
                return pSDEACModeBase.getLinkPSDEViewName() == null;
            }
            case 32: {
                return pSDEACModeBase.getLockFlag() == null;
            }
            case 33: {
                return pSDEACModeBase.getLogicName() == null;
            }
            case 34: {
                return pSDEACModeBase.getMemo() == null;
            }
            case 35: {
                return pSDEACModeBase.getMinorSortDir() == null;
            }
            case 36: {
                return pSDEACModeBase.getMinorSortPSDEFId() == null;
            }
            case 37: {
                return pSDEACModeBase.getMinorSortPSDEFName() == null;
            }
            case 38: {
                return pSDEACModeBase.getPagingSize() == null;
            }
            case 39: {
                return pSDEACModeBase.getPickupPSDEViewId() == null;
            }
            case 40: {
                return pSDEACModeBase.getPickupPSDEViewName() == null;
            }
            case 41: {
                return pSDEACModeBase.getPSDEACModeId() == null;
            }
            case 42: {
                return pSDEACModeBase.getPSDEACModeName() == null;
            }
            case 43: {
                return pSDEACModeBase.getPSDEDataSetId() == null;
            }
            case 44: {
                return pSDEACModeBase.getPSDEDataSetName() == null;
            }
            case 45: {
                return pSDEACModeBase.getPSDEId() == null;
            }
            case 46: {
                return pSDEACModeBase.getPSDEName() == null;
            }
            case 47: {
                return pSDEACModeBase.getPSDEUAGroupId() == null;
            }
            case 48: {
                return pSDEACModeBase.getPSDEUAGroupName() == null;
            }
            case 49: {
                return pSDEACModeBase.getPSDynaInstId() == null;
            }
            case 50: {
                return pSDEACModeBase.getPSSysAIChatAgentId() == null;
            }
            case 51: {
                return pSDEACModeBase.getPSSysAIChatAgentName() == null;
            }
            case 52: {
                return pSDEACModeBase.getPSSysAIFactoryId() == null;
            }
            case 53: {
                return pSDEACModeBase.getPSSysAIFactoryName() == null;
            }
            case 54: {
                return pSDEACModeBase.getPSSysSFPluginId() == null;
            }
            case 55: {
                return pSDEACModeBase.getPSSysSFPluginName() == null;
            }
            case 56: {
                return pSDEACModeBase.getPSSysViewPanelId() == null;
            }
            case 57: {
                return pSDEACModeBase.getPSSysViewPanelName() == null;
            }
            case 58: {
                return pSDEACModeBase.getReadPSDEOPPrivId() == null;
            }
            case 59: {
                return pSDEACModeBase.getReadPSDEOPPrivName() == null;
            }
            case 60: {
                return pSDEACModeBase.getTextPSDEFId() == null;
            }
            case 61: {
                return pSDEACModeBase.getTextPSDEFName() == null;
            }
            case 62: {
                return pSDEACModeBase.getUpdateDate() == null;
            }
            case 63: {
                return pSDEACModeBase.getUpdateMan() == null;
            }
            case 64: {
                return pSDEACModeBase.getUserCat() == null;
            }
            case 65: {
                return pSDEACModeBase.getUserTag() == null;
            }
            case 66: {
                return pSDEACModeBase.getUserTag2() == null;
            }
            case 67: {
                return pSDEACModeBase.getUserTag3() == null;
            }
            case 68: {
                return pSDEACModeBase.getUserTag4() == null;
            }
            case 69: {
                return pSDEACModeBase.getValuePSDEFId() == null;
            }
            case 70: {
                return pSDEACModeBase.getValuePSDEFName() == null;
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
        return PSDEACModeBase.contains(this, n);
    }

    private static boolean contains(PSDEACModeBase pSDEACModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEACModeBase.isACIPSSysPFPluginIdDirty();
            }
            case 1: {
                return pSDEACModeBase.isACIPSSysPFPluginNameDirty();
            }
            case 2: {
                return pSDEACModeBase.isACParamsDirty();
            }
            case 3: {
                return pSDEACModeBase.isACTagDirty();
            }
            case 4: {
                return pSDEACModeBase.isACTag2Dirty();
            }
            case 5: {
                return pSDEACModeBase.isACTag3Dirty();
            }
            case 6: {
                return pSDEACModeBase.isACTag4Dirty();
            }
            case 7: {
                return pSDEACModeBase.isActionHolderDirty();
            }
            case 8: {
                return pSDEACModeBase.isACTypeDirty();
            }
            case 9: {
                return pSDEACModeBase.isADPSDELogicIdDirty();
            }
            case 10: {
                return pSDEACModeBase.isADPSDELogicNameDirty();
            }
            case 11: {
                return pSDEACModeBase.isAIFactoryPSSysUtilDEIdDirty();
            }
            case 12: {
                return pSDEACModeBase.isAIFactoryPSSysUtilDENameDirty();
            }
            case 13: {
                return pSDEACModeBase.isCodeNameDirty();
            }
            case 14: {
                return pSDEACModeBase.isCreateDateDirty();
            }
            case 15: {
                return pSDEACModeBase.isCreateManDirty();
            }
            case 16: {
                return pSDEACModeBase.isCreatePSDEOPPrivIdDirty();
            }
            case 17: {
                return pSDEACModeBase.isCreatePSDEOPPrivNameDirty();
            }
            case 18: {
                return pSDEACModeBase.isCustomCodeDirty();
            }
            case 19: {
                return pSDEACModeBase.isCustomModeDirty();
            }
            case 20: {
                return pSDEACModeBase.isDefaultModeDirty();
            }
            case 21: {
                return pSDEACModeBase.isDynaModelFlagDirty();
            }
            case 22: {
                return pSDEACModeBase.isEmptyTextDirty();
            }
            case 23: {
                return pSDEACModeBase.isEmptyTextPSLanResIdDirty();
            }
            case 24: {
                return pSDEACModeBase.isEmptyTextPSLanResNameDirty();
            }
            case 25: {
                return pSDEACModeBase.isEnablePagingBarDirty();
            }
            case 26: {
                return pSDEACModeBase.isExtendModeDirty();
            }
            case 27: {
                return pSDEACModeBase.isFillerObjDirty();
            }
            case 28: {
                return pSDEACModeBase.isHistoryPSSysMsgTemplIdDirty();
            }
            case 29: {
                return pSDEACModeBase.isHistoryPSSysMsgTemplNameDirty();
            }
            case 30: {
                return pSDEACModeBase.isLinkPSDEViewIdDirty();
            }
            case 31: {
                return pSDEACModeBase.isLinkPSDEViewNameDirty();
            }
            case 32: {
                return pSDEACModeBase.isLockFlagDirty();
            }
            case 33: {
                return pSDEACModeBase.isLogicNameDirty();
            }
            case 34: {
                return pSDEACModeBase.isMemoDirty();
            }
            case 35: {
                return pSDEACModeBase.isMinorSortDirDirty();
            }
            case 36: {
                return pSDEACModeBase.isMinorSortPSDEFIdDirty();
            }
            case 37: {
                return pSDEACModeBase.isMinorSortPSDEFNameDirty();
            }
            case 38: {
                return pSDEACModeBase.isPagingSizeDirty();
            }
            case 39: {
                return pSDEACModeBase.isPickupPSDEViewIdDirty();
            }
            case 40: {
                return pSDEACModeBase.isPickupPSDEViewNameDirty();
            }
            case 41: {
                return pSDEACModeBase.isPSDEACModeIdDirty();
            }
            case 42: {
                return pSDEACModeBase.isPSDEACModeNameDirty();
            }
            case 43: {
                return pSDEACModeBase.isPSDEDataSetIdDirty();
            }
            case 44: {
                return pSDEACModeBase.isPSDEDataSetNameDirty();
            }
            case 45: {
                return pSDEACModeBase.isPSDEIdDirty();
            }
            case 46: {
                return pSDEACModeBase.isPSDENameDirty();
            }
            case 47: {
                return pSDEACModeBase.isPSDEUAGroupIdDirty();
            }
            case 48: {
                return pSDEACModeBase.isPSDEUAGroupNameDirty();
            }
            case 49: {
                return pSDEACModeBase.isPSDynaInstIdDirty();
            }
            case 50: {
                return pSDEACModeBase.isPSSysAIChatAgentIdDirty();
            }
            case 51: {
                return pSDEACModeBase.isPSSysAIChatAgentNameDirty();
            }
            case 52: {
                return pSDEACModeBase.isPSSysAIFactoryIdDirty();
            }
            case 53: {
                return pSDEACModeBase.isPSSysAIFactoryNameDirty();
            }
            case 54: {
                return pSDEACModeBase.isPSSysSFPluginIdDirty();
            }
            case 55: {
                return pSDEACModeBase.isPSSysSFPluginNameDirty();
            }
            case 56: {
                return pSDEACModeBase.isPSSysViewPanelIdDirty();
            }
            case 57: {
                return pSDEACModeBase.isPSSysViewPanelNameDirty();
            }
            case 58: {
                return pSDEACModeBase.isReadPSDEOPPrivIdDirty();
            }
            case 59: {
                return pSDEACModeBase.isReadPSDEOPPrivNameDirty();
            }
            case 60: {
                return pSDEACModeBase.isTextPSDEFIdDirty();
            }
            case 61: {
                return pSDEACModeBase.isTextPSDEFNameDirty();
            }
            case 62: {
                return pSDEACModeBase.isUpdateDateDirty();
            }
            case 63: {
                return pSDEACModeBase.isUpdateManDirty();
            }
            case 64: {
                return pSDEACModeBase.isUserCatDirty();
            }
            case 65: {
                return pSDEACModeBase.isUserTagDirty();
            }
            case 66: {
                return pSDEACModeBase.isUserTag2Dirty();
            }
            case 67: {
                return pSDEACModeBase.isUserTag3Dirty();
            }
            case 68: {
                return pSDEACModeBase.isUserTag4Dirty();
            }
            case 69: {
                return pSDEACModeBase.isValuePSDEFIdDirty();
            }
            case 70: {
                return pSDEACModeBase.isValuePSDEFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEACModeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEACModeBase pSDEACModeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEACModeBase.getACIPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"acipssyspfpluginid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACIPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getACIPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"acipssyspfpluginname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACIPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getACParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"acparams", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACParams()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getACTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actag", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACTag()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getACTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actag2", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACTag2()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getACTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actag3", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACTag3()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getACTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actag4", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACTag4()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getActionHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionholder", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getActionHolder()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getACType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actype", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getACType()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getAIFactoryPSSysUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aifactorypssysutildeid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getAIFactoryPSSysUtilDEId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getAIFactoryPSSysUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aifactorypssysutildename", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getAIFactoryPSSysUtilDEName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getCreatePSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeopprivid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getCreatePSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getCreatePSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createpsdeopprivname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getCreatePSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getEmptyTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getEmptyTextPSLanResId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getEmptyTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpslanresname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getEmptyTextPSLanResName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getEnablePagingBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablepagingbar", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getEnablePagingBar()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getFillerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fillerobj", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getFillerObj()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getHistoryPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"historypssysmsgtemplid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getHistoryPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getHistoryPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"historypssysmsgtemplname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getHistoryPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getMinorSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getMinorSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getMinorSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getMinorSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPagingSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pagingsize", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPagingSize()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodeid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodename", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysAIChatAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaichatagentid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysAIChatAgentId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysAIChatAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaichatagentname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysAIChatAgentName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getReadPSDEOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readpsdeopprivid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getReadPSDEOPPrivId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getReadPSDEOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readpsdeopprivname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getReadPSDEOPPrivName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefid", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getValuePSDEFId()), (boolean)false);
        }
        if (bl || pSDEACModeBase.getValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefname", (Object)PSDEACModeBase.getJSONValue((Object)pSDEACModeBase.getValuePSDEFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEACModeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEACModeBase pSDEACModeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEACModeBase.getACIPSSysPFPluginId() != null) {
            object = pSDEACModeBase.getACIPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_ACIPSSYSPFPLUGINID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeBase.getACIPSSysPFPluginName() != null) {
            object = pSDEACModeBase.getACIPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_ACIPSSYSPFPLUGINNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeBase.getACParams() != null) {
            object = pSDEACModeBase.getACParams();
            xmlNode.setAttribute(FIELD_ACPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeBase.getACTag() != null) {
            object = pSDEACModeBase.getACTag();
            xmlNode.setAttribute(FIELD_ACTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeBase.getACTag2() != null) {
            object = pSDEACModeBase.getACTag2();
            xmlNode.setAttribute(FIELD_ACTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeBase.getACTag3() != null) {
            object = pSDEACModeBase.getACTag3();
            xmlNode.setAttribute(FIELD_ACTAG3, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeBase.getACTag4() != null) {
            object = pSDEACModeBase.getACTag4();
            xmlNode.setAttribute(FIELD_ACTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getActionHolder() != null) {
            object = pSDEACModeBase.getActionHolder();
            xmlNode.setAttribute(FIELD_ACTIONHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getACType() != null) {
            object = pSDEACModeBase.getACType();
            xmlNode.setAttribute(FIELD_ACTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getADPSDELogicId() != null) {
            object = pSDEACModeBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getADPSDELogicName() != null) {
            object = pSDEACModeBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getAIFactoryPSSysUtilDEId() != null) {
            object = pSDEACModeBase.getAIFactoryPSSysUtilDEId();
            xmlNode.setAttribute(FIELD_AIFACTORYPSSYSUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getAIFactoryPSSysUtilDEName() != null) {
            object = pSDEACModeBase.getAIFactoryPSSysUtilDEName();
            xmlNode.setAttribute(FIELD_AIFACTORYPSSYSUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getCodeName() != null) {
            object = pSDEACModeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getCreateDate() != null) {
            object = pSDEACModeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEACModeBase.getCreateMan() != null) {
            object = pSDEACModeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getCreatePSDEOPPrivId() != null) {
            object = pSDEACModeBase.getCreatePSDEOPPrivId();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getCreatePSDEOPPrivName() != null) {
            object = pSDEACModeBase.getCreatePSDEOPPrivName();
            xmlNode.setAttribute(FIELD_CREATEPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getCustomCode() != null) {
            object = pSDEACModeBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getCustomMode() != null) {
            object = pSDEACModeBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getDefaultMode() != null) {
            object = pSDEACModeBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getDynaModelFlag() != null) {
            object = pSDEACModeBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getEmptyText() != null) {
            object = pSDEACModeBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getEmptyTextPSLanResId() != null) {
            object = pSDEACModeBase.getEmptyTextPSLanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getEmptyTextPSLanResName() != null) {
            object = pSDEACModeBase.getEmptyTextPSLanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getEnablePagingBar() != null) {
            object = pSDEACModeBase.getEnablePagingBar();
            xmlNode.setAttribute(FIELD_ENABLEPAGINGBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getExtendMode() != null) {
            object = pSDEACModeBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getFillerObj() != null) {
            object = pSDEACModeBase.getFillerObj();
            xmlNode.setAttribute(FIELD_FILLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getHistoryPSSysMsgTemplId() != null) {
            object = pSDEACModeBase.getHistoryPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_HISTORYPSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getHistoryPSSysMsgTemplName() != null) {
            object = pSDEACModeBase.getHistoryPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_HISTORYPSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getLinkPSDEViewId() != null) {
            object = pSDEACModeBase.getLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getLinkPSDEViewName() != null) {
            object = pSDEACModeBase.getLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getLockFlag() != null) {
            object = pSDEACModeBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getLogicName() != null) {
            object = pSDEACModeBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getMemo() != null) {
            object = pSDEACModeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getMinorSortDir() != null) {
            object = pSDEACModeBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getMinorSortPSDEFId() != null) {
            object = pSDEACModeBase.getMinorSortPSDEFId();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getMinorSortPSDEFName() != null) {
            object = pSDEACModeBase.getMinorSortPSDEFName();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPagingSize() != null) {
            object = pSDEACModeBase.getPagingSize();
            xmlNode.setAttribute(FIELD_PAGINGSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeBase.getPickupPSDEViewId() != null) {
            object = pSDEACModeBase.getPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPickupPSDEViewName() != null) {
            object = pSDEACModeBase.getPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEACModeId() != null) {
            object = pSDEACModeBase.getPSDEACModeId();
            xmlNode.setAttribute(FIELD_PSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEACModeName() != null) {
            object = pSDEACModeBase.getPSDEACModeName();
            xmlNode.setAttribute(FIELD_PSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEDataSetId() != null) {
            object = pSDEACModeBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEDataSetName() != null) {
            object = pSDEACModeBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEId() != null) {
            object = pSDEACModeBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEName() != null) {
            object = pSDEACModeBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEUAGroupId() != null) {
            object = pSDEACModeBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDEUAGroupName() != null) {
            object = pSDEACModeBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSDynaInstId() != null) {
            object = pSDEACModeBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysAIChatAgentId() != null) {
            object = pSDEACModeBase.getPSSysAIChatAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAICHATAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysAIChatAgentName() != null) {
            object = pSDEACModeBase.getPSSysAIChatAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAICHATAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysAIFactoryId() != null) {
            object = pSDEACModeBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysAIFactoryName() != null) {
            object = pSDEACModeBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysSFPluginId() != null) {
            object = pSDEACModeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysSFPluginName() != null) {
            object = pSDEACModeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysViewPanelId() != null) {
            object = pSDEACModeBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getPSSysViewPanelName() != null) {
            object = pSDEACModeBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getReadPSDEOPPrivId() != null) {
            object = pSDEACModeBase.getReadPSDEOPPrivId();
            xmlNode.setAttribute(FIELD_READPSDEOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getReadPSDEOPPrivName() != null) {
            object = pSDEACModeBase.getReadPSDEOPPrivName();
            xmlNode.setAttribute(FIELD_READPSDEOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getTextPSDEFId() != null) {
            object = pSDEACModeBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getTextPSDEFName() != null) {
            object = pSDEACModeBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getUpdateDate() != null) {
            object = pSDEACModeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEACModeBase.getUpdateMan() != null) {
            object = pSDEACModeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getUserCat() != null) {
            object = pSDEACModeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getUserTag() != null) {
            object = pSDEACModeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getUserTag2() != null) {
            object = pSDEACModeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getUserTag3() != null) {
            object = pSDEACModeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getUserTag4() != null) {
            object = pSDEACModeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getValuePSDEFId() != null) {
            object = pSDEACModeBase.getValuePSDEFId();
            xmlNode.setAttribute(FIELD_VALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeBase.getValuePSDEFName() != null) {
            object = pSDEACModeBase.getValuePSDEFName();
            xmlNode.setAttribute(FIELD_VALUEPSDEFNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEACModeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEACModeBase pSDEACModeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEACModeBase.isACIPSSysPFPluginIdDirty() && (bl || pSDEACModeBase.getACIPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_ACIPSSYSPFPLUGINID, (Object)pSDEACModeBase.getACIPSSysPFPluginId());
        }
        if (pSDEACModeBase.isACIPSSysPFPluginNameDirty() && (bl || pSDEACModeBase.getACIPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_ACIPSSYSPFPLUGINNAME, (Object)pSDEACModeBase.getACIPSSysPFPluginName());
        }
        if (pSDEACModeBase.isACParamsDirty() && (bl || pSDEACModeBase.getACParams() != null)) {
            iDataObject.set(FIELD_ACPARAMS, (Object)pSDEACModeBase.getACParams());
        }
        if (pSDEACModeBase.isACTagDirty() && (bl || pSDEACModeBase.getACTag() != null)) {
            iDataObject.set(FIELD_ACTAG, (Object)pSDEACModeBase.getACTag());
        }
        if (pSDEACModeBase.isACTag2Dirty() && (bl || pSDEACModeBase.getACTag2() != null)) {
            iDataObject.set(FIELD_ACTAG2, (Object)pSDEACModeBase.getACTag2());
        }
        if (pSDEACModeBase.isACTag3Dirty() && (bl || pSDEACModeBase.getACTag3() != null)) {
            iDataObject.set(FIELD_ACTAG3, (Object)pSDEACModeBase.getACTag3());
        }
        if (pSDEACModeBase.isACTag4Dirty() && (bl || pSDEACModeBase.getACTag4() != null)) {
            iDataObject.set(FIELD_ACTAG4, (Object)pSDEACModeBase.getACTag4());
        }
        if (pSDEACModeBase.isActionHolderDirty() && (bl || pSDEACModeBase.getActionHolder() != null)) {
            iDataObject.set(FIELD_ACTIONHOLDER, (Object)pSDEACModeBase.getActionHolder());
        }
        if (pSDEACModeBase.isACTypeDirty() && (bl || pSDEACModeBase.getACType() != null)) {
            iDataObject.set(FIELD_ACTYPE, (Object)pSDEACModeBase.getACType());
        }
        if (pSDEACModeBase.isADPSDELogicIdDirty() && (bl || pSDEACModeBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSDEACModeBase.getADPSDELogicId());
        }
        if (pSDEACModeBase.isADPSDELogicNameDirty() && (bl || pSDEACModeBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSDEACModeBase.getADPSDELogicName());
        }
        if (pSDEACModeBase.isAIFactoryPSSysUtilDEIdDirty() && (bl || pSDEACModeBase.getAIFactoryPSSysUtilDEId() != null)) {
            iDataObject.set(FIELD_AIFACTORYPSSYSUTILDEID, (Object)pSDEACModeBase.getAIFactoryPSSysUtilDEId());
        }
        if (pSDEACModeBase.isAIFactoryPSSysUtilDENameDirty() && (bl || pSDEACModeBase.getAIFactoryPSSysUtilDEName() != null)) {
            iDataObject.set(FIELD_AIFACTORYPSSYSUTILDENAME, (Object)pSDEACModeBase.getAIFactoryPSSysUtilDEName());
        }
        if (pSDEACModeBase.isCodeNameDirty() && (bl || pSDEACModeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEACModeBase.getCodeName());
        }
        if (pSDEACModeBase.isCreateDateDirty() && (bl || pSDEACModeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEACModeBase.getCreateDate());
        }
        if (pSDEACModeBase.isCreateManDirty() && (bl || pSDEACModeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEACModeBase.getCreateMan());
        }
        if (pSDEACModeBase.isCreatePSDEOPPrivIdDirty() && (bl || pSDEACModeBase.getCreatePSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVID, (Object)pSDEACModeBase.getCreatePSDEOPPrivId());
        }
        if (pSDEACModeBase.isCreatePSDEOPPrivNameDirty() && (bl || pSDEACModeBase.getCreatePSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_CREATEPSDEOPPRIVNAME, (Object)pSDEACModeBase.getCreatePSDEOPPrivName());
        }
        if (pSDEACModeBase.isCustomCodeDirty() && (bl || pSDEACModeBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEACModeBase.getCustomCode());
        }
        if (pSDEACModeBase.isCustomModeDirty() && (bl || pSDEACModeBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEACModeBase.getCustomMode());
        }
        if (pSDEACModeBase.isDefaultModeDirty() && (bl || pSDEACModeBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDEACModeBase.getDefaultMode());
        }
        if (pSDEACModeBase.isDynaModelFlagDirty() && (bl || pSDEACModeBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEACModeBase.getDynaModelFlag());
        }
        if (pSDEACModeBase.isEmptyTextDirty() && (bl || pSDEACModeBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSDEACModeBase.getEmptyText());
        }
        if (pSDEACModeBase.isEmptyTextPSLanResIdDirty() && (bl || pSDEACModeBase.getEmptyTextPSLanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESID, (Object)pSDEACModeBase.getEmptyTextPSLanResId());
        }
        if (pSDEACModeBase.isEmptyTextPSLanResNameDirty() && (bl || pSDEACModeBase.getEmptyTextPSLanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSLANRESNAME, (Object)pSDEACModeBase.getEmptyTextPSLanResName());
        }
        if (pSDEACModeBase.isEnablePagingBarDirty() && (bl || pSDEACModeBase.getEnablePagingBar() != null)) {
            iDataObject.set(FIELD_ENABLEPAGINGBAR, (Object)pSDEACModeBase.getEnablePagingBar());
        }
        if (pSDEACModeBase.isExtendModeDirty() && (bl || pSDEACModeBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEACModeBase.getExtendMode());
        }
        if (pSDEACModeBase.isFillerObjDirty() && (bl || pSDEACModeBase.getFillerObj() != null)) {
            iDataObject.set(FIELD_FILLEROBJ, (Object)pSDEACModeBase.getFillerObj());
        }
        if (pSDEACModeBase.isHistoryPSSysMsgTemplIdDirty() && (bl || pSDEACModeBase.getHistoryPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_HISTORYPSSYSMSGTEMPLID, (Object)pSDEACModeBase.getHistoryPSSysMsgTemplId());
        }
        if (pSDEACModeBase.isHistoryPSSysMsgTemplNameDirty() && (bl || pSDEACModeBase.getHistoryPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_HISTORYPSSYSMSGTEMPLNAME, (Object)pSDEACModeBase.getHistoryPSSysMsgTemplName());
        }
        if (pSDEACModeBase.isLinkPSDEViewIdDirty() && (bl || pSDEACModeBase.getLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWID, (Object)pSDEACModeBase.getLinkPSDEViewId());
        }
        if (pSDEACModeBase.isLinkPSDEViewNameDirty() && (bl || pSDEACModeBase.getLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWNAME, (Object)pSDEACModeBase.getLinkPSDEViewName());
        }
        if (pSDEACModeBase.isLockFlagDirty() && (bl || pSDEACModeBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEACModeBase.getLockFlag());
        }
        if (pSDEACModeBase.isLogicNameDirty() && (bl || pSDEACModeBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEACModeBase.getLogicName());
        }
        if (pSDEACModeBase.isMemoDirty() && (bl || pSDEACModeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEACModeBase.getMemo());
        }
        if (pSDEACModeBase.isMinorSortDirDirty() && (bl || pSDEACModeBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSDEACModeBase.getMinorSortDir());
        }
        if (pSDEACModeBase.isMinorSortPSDEFIdDirty() && (bl || pSDEACModeBase.getMinorSortPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFID, (Object)pSDEACModeBase.getMinorSortPSDEFId());
        }
        if (pSDEACModeBase.isMinorSortPSDEFNameDirty() && (bl || pSDEACModeBase.getMinorSortPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFNAME, (Object)pSDEACModeBase.getMinorSortPSDEFName());
        }
        if (pSDEACModeBase.isPagingSizeDirty() && (bl || pSDEACModeBase.getPagingSize() != null)) {
            iDataObject.set(FIELD_PAGINGSIZE, (Object)pSDEACModeBase.getPagingSize());
        }
        if (pSDEACModeBase.isPickupPSDEViewIdDirty() && (bl || pSDEACModeBase.getPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWID, (Object)pSDEACModeBase.getPickupPSDEViewId());
        }
        if (pSDEACModeBase.isPickupPSDEViewNameDirty() && (bl || pSDEACModeBase.getPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWNAME, (Object)pSDEACModeBase.getPickupPSDEViewName());
        }
        if (pSDEACModeBase.isPSDEACModeIdDirty() && (bl || pSDEACModeBase.getPSDEACModeId() != null)) {
            iDataObject.set(FIELD_PSDEACMODEID, (Object)pSDEACModeBase.getPSDEACModeId());
        }
        if (pSDEACModeBase.isPSDEACModeNameDirty() && (bl || pSDEACModeBase.getPSDEACModeName() != null)) {
            iDataObject.set(FIELD_PSDEACMODENAME, (Object)pSDEACModeBase.getPSDEACModeName());
        }
        if (pSDEACModeBase.isPSDEDataSetIdDirty() && (bl || pSDEACModeBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEACModeBase.getPSDEDataSetId());
        }
        if (pSDEACModeBase.isPSDEDataSetNameDirty() && (bl || pSDEACModeBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEACModeBase.getPSDEDataSetName());
        }
        if (pSDEACModeBase.isPSDEIdDirty() && (bl || pSDEACModeBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEACModeBase.getPSDEId());
        }
        if (pSDEACModeBase.isPSDENameDirty() && (bl || pSDEACModeBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEACModeBase.getPSDEName());
        }
        if (pSDEACModeBase.isPSDEUAGroupIdDirty() && (bl || pSDEACModeBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEACModeBase.getPSDEUAGroupId());
        }
        if (pSDEACModeBase.isPSDEUAGroupNameDirty() && (bl || pSDEACModeBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEACModeBase.getPSDEUAGroupName());
        }
        if (pSDEACModeBase.isPSDynaInstIdDirty() && (bl || pSDEACModeBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEACModeBase.getPSDynaInstId());
        }
        if (pSDEACModeBase.isPSSysAIChatAgentIdDirty() && (bl || pSDEACModeBase.getPSSysAIChatAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAICHATAGENTID, (Object)pSDEACModeBase.getPSSysAIChatAgentId());
        }
        if (pSDEACModeBase.isPSSysAIChatAgentNameDirty() && (bl || pSDEACModeBase.getPSSysAIChatAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAICHATAGENTNAME, (Object)pSDEACModeBase.getPSSysAIChatAgentName());
        }
        if (pSDEACModeBase.isPSSysAIFactoryIdDirty() && (bl || pSDEACModeBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSDEACModeBase.getPSSysAIFactoryId());
        }
        if (pSDEACModeBase.isPSSysAIFactoryNameDirty() && (bl || pSDEACModeBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSDEACModeBase.getPSSysAIFactoryName());
        }
        if (pSDEACModeBase.isPSSysSFPluginIdDirty() && (bl || pSDEACModeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEACModeBase.getPSSysSFPluginId());
        }
        if (pSDEACModeBase.isPSSysSFPluginNameDirty() && (bl || pSDEACModeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEACModeBase.getPSSysSFPluginName());
        }
        if (pSDEACModeBase.isPSSysViewPanelIdDirty() && (bl || pSDEACModeBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSDEACModeBase.getPSSysViewPanelId());
        }
        if (pSDEACModeBase.isPSSysViewPanelNameDirty() && (bl || pSDEACModeBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSDEACModeBase.getPSSysViewPanelName());
        }
        if (pSDEACModeBase.isReadPSDEOPPrivIdDirty() && (bl || pSDEACModeBase.getReadPSDEOPPrivId() != null)) {
            iDataObject.set(FIELD_READPSDEOPPRIVID, (Object)pSDEACModeBase.getReadPSDEOPPrivId());
        }
        if (pSDEACModeBase.isReadPSDEOPPrivNameDirty() && (bl || pSDEACModeBase.getReadPSDEOPPrivName() != null)) {
            iDataObject.set(FIELD_READPSDEOPPRIVNAME, (Object)pSDEACModeBase.getReadPSDEOPPrivName());
        }
        if (pSDEACModeBase.isTextPSDEFIdDirty() && (bl || pSDEACModeBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSDEACModeBase.getTextPSDEFId());
        }
        if (pSDEACModeBase.isTextPSDEFNameDirty() && (bl || pSDEACModeBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSDEACModeBase.getTextPSDEFName());
        }
        if (pSDEACModeBase.isUpdateDateDirty() && (bl || pSDEACModeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEACModeBase.getUpdateDate());
        }
        if (pSDEACModeBase.isUpdateManDirty() && (bl || pSDEACModeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEACModeBase.getUpdateMan());
        }
        if (pSDEACModeBase.isUserCatDirty() && (bl || pSDEACModeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEACModeBase.getUserCat());
        }
        if (pSDEACModeBase.isUserTagDirty() && (bl || pSDEACModeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEACModeBase.getUserTag());
        }
        if (pSDEACModeBase.isUserTag2Dirty() && (bl || pSDEACModeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEACModeBase.getUserTag2());
        }
        if (pSDEACModeBase.isUserTag3Dirty() && (bl || pSDEACModeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEACModeBase.getUserTag3());
        }
        if (pSDEACModeBase.isUserTag4Dirty() && (bl || pSDEACModeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEACModeBase.getUserTag4());
        }
        if (pSDEACModeBase.isValuePSDEFIdDirty() && (bl || pSDEACModeBase.getValuePSDEFId() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFID, (Object)pSDEACModeBase.getValuePSDEFId());
        }
        if (pSDEACModeBase.isValuePSDEFNameDirty() && (bl || pSDEACModeBase.getValuePSDEFName() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFNAME, (Object)pSDEACModeBase.getValuePSDEFName());
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
        return PSDEACModeBase.remove(this, n);
    }

    private static boolean remove(PSDEACModeBase pSDEACModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEACModeBase.resetACIPSSysPFPluginId();
                return true;
            }
            case 1: {
                pSDEACModeBase.resetACIPSSysPFPluginName();
                return true;
            }
            case 2: {
                pSDEACModeBase.resetACParams();
                return true;
            }
            case 3: {
                pSDEACModeBase.resetACTag();
                return true;
            }
            case 4: {
                pSDEACModeBase.resetACTag2();
                return true;
            }
            case 5: {
                pSDEACModeBase.resetACTag3();
                return true;
            }
            case 6: {
                pSDEACModeBase.resetACTag4();
                return true;
            }
            case 7: {
                pSDEACModeBase.resetActionHolder();
                return true;
            }
            case 8: {
                pSDEACModeBase.resetACType();
                return true;
            }
            case 9: {
                pSDEACModeBase.resetADPSDELogicId();
                return true;
            }
            case 10: {
                pSDEACModeBase.resetADPSDELogicName();
                return true;
            }
            case 11: {
                pSDEACModeBase.resetAIFactoryPSSysUtilDEId();
                return true;
            }
            case 12: {
                pSDEACModeBase.resetAIFactoryPSSysUtilDEName();
                return true;
            }
            case 13: {
                pSDEACModeBase.resetCodeName();
                return true;
            }
            case 14: {
                pSDEACModeBase.resetCreateDate();
                return true;
            }
            case 15: {
                pSDEACModeBase.resetCreateMan();
                return true;
            }
            case 16: {
                pSDEACModeBase.resetCreatePSDEOPPrivId();
                return true;
            }
            case 17: {
                pSDEACModeBase.resetCreatePSDEOPPrivName();
                return true;
            }
            case 18: {
                pSDEACModeBase.resetCustomCode();
                return true;
            }
            case 19: {
                pSDEACModeBase.resetCustomMode();
                return true;
            }
            case 20: {
                pSDEACModeBase.resetDefaultMode();
                return true;
            }
            case 21: {
                pSDEACModeBase.resetDynaModelFlag();
                return true;
            }
            case 22: {
                pSDEACModeBase.resetEmptyText();
                return true;
            }
            case 23: {
                pSDEACModeBase.resetEmptyTextPSLanResId();
                return true;
            }
            case 24: {
                pSDEACModeBase.resetEmptyTextPSLanResName();
                return true;
            }
            case 25: {
                pSDEACModeBase.resetEnablePagingBar();
                return true;
            }
            case 26: {
                pSDEACModeBase.resetExtendMode();
                return true;
            }
            case 27: {
                pSDEACModeBase.resetFillerObj();
                return true;
            }
            case 28: {
                pSDEACModeBase.resetHistoryPSSysMsgTemplId();
                return true;
            }
            case 29: {
                pSDEACModeBase.resetHistoryPSSysMsgTemplName();
                return true;
            }
            case 30: {
                pSDEACModeBase.resetLinkPSDEViewId();
                return true;
            }
            case 31: {
                pSDEACModeBase.resetLinkPSDEViewName();
                return true;
            }
            case 32: {
                pSDEACModeBase.resetLockFlag();
                return true;
            }
            case 33: {
                pSDEACModeBase.resetLogicName();
                return true;
            }
            case 34: {
                pSDEACModeBase.resetMemo();
                return true;
            }
            case 35: {
                pSDEACModeBase.resetMinorSortDir();
                return true;
            }
            case 36: {
                pSDEACModeBase.resetMinorSortPSDEFId();
                return true;
            }
            case 37: {
                pSDEACModeBase.resetMinorSortPSDEFName();
                return true;
            }
            case 38: {
                pSDEACModeBase.resetPagingSize();
                return true;
            }
            case 39: {
                pSDEACModeBase.resetPickupPSDEViewId();
                return true;
            }
            case 40: {
                pSDEACModeBase.resetPickupPSDEViewName();
                return true;
            }
            case 41: {
                pSDEACModeBase.resetPSDEACModeId();
                return true;
            }
            case 42: {
                pSDEACModeBase.resetPSDEACModeName();
                return true;
            }
            case 43: {
                pSDEACModeBase.resetPSDEDataSetId();
                return true;
            }
            case 44: {
                pSDEACModeBase.resetPSDEDataSetName();
                return true;
            }
            case 45: {
                pSDEACModeBase.resetPSDEId();
                return true;
            }
            case 46: {
                pSDEACModeBase.resetPSDEName();
                return true;
            }
            case 47: {
                pSDEACModeBase.resetPSDEUAGroupId();
                return true;
            }
            case 48: {
                pSDEACModeBase.resetPSDEUAGroupName();
                return true;
            }
            case 49: {
                pSDEACModeBase.resetPSDynaInstId();
                return true;
            }
            case 50: {
                pSDEACModeBase.resetPSSysAIChatAgentId();
                return true;
            }
            case 51: {
                pSDEACModeBase.resetPSSysAIChatAgentName();
                return true;
            }
            case 52: {
                pSDEACModeBase.resetPSSysAIFactoryId();
                return true;
            }
            case 53: {
                pSDEACModeBase.resetPSSysAIFactoryName();
                return true;
            }
            case 54: {
                pSDEACModeBase.resetPSSysSFPluginId();
                return true;
            }
            case 55: {
                pSDEACModeBase.resetPSSysSFPluginName();
                return true;
            }
            case 56: {
                pSDEACModeBase.resetPSSysViewPanelId();
                return true;
            }
            case 57: {
                pSDEACModeBase.resetPSSysViewPanelName();
                return true;
            }
            case 58: {
                pSDEACModeBase.resetReadPSDEOPPrivId();
                return true;
            }
            case 59: {
                pSDEACModeBase.resetReadPSDEOPPrivName();
                return true;
            }
            case 60: {
                pSDEACModeBase.resetTextPSDEFId();
                return true;
            }
            case 61: {
                pSDEACModeBase.resetTextPSDEFName();
                return true;
            }
            case 62: {
                pSDEACModeBase.resetUpdateDate();
                return true;
            }
            case 63: {
                pSDEACModeBase.resetUpdateMan();
                return true;
            }
            case 64: {
                pSDEACModeBase.resetUserCat();
                return true;
            }
            case 65: {
                pSDEACModeBase.resetUserTag();
                return true;
            }
            case 66: {
                pSDEACModeBase.resetUserTag2();
                return true;
            }
            case 67: {
                pSDEACModeBase.resetUserTag3();
                return true;
            }
            case 68: {
                pSDEACModeBase.resetUserTag4();
                return true;
            }
            case 69: {
                pSDEACModeBase.resetValuePSDEFId();
                return true;
            }
            case 70: {
                pSDEACModeBase.resetValuePSDEFName();
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
    public PSDEField getMinorSortPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEF();
        }
        if (this.getMinorSortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMinorSortPSDEFLock;
        synchronized (n) {
            if (this.minorsortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMinorSortPSDEFId(), (Object)this.minorsortpsdef.getPSDEFieldId()) != 0L) {
                this.minorsortpsdef = null;
            }
            if (this.minorsortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMinorSortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.minorsortpsdef = pSDEField;
            }
            return this.minorsortpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTextPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEF();
        }
        if (this.getTextPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTextPSDEFLock;
        synchronized (n) {
            if (this.textpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSDEFId(), (Object)this.textpsdef.getPSDEFieldId()) != 0L) {
                this.textpsdef = null;
            }
            if (this.textpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTextPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.textpsdef = pSDEField;
            }
            return this.textpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEF();
        }
        if (this.getValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objValuePSDEFLock;
        synchronized (n) {
            if (this.valuepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getValuePSDEFId(), (Object)this.valuepsdef.getPSDEFieldId()) != 0L) {
                this.valuepsdef = null;
            }
            if (this.valuepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.valuepsdef = pSDEField;
            }
            return this.valuepsdef;
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
    public PSDEOPPriv getCreatePSDEOPPriv() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatePSDEOPPriv();
        }
        if (this.getCreatePSDEOPPrivId() == null) {
            return null;
        }
        Integer n = this.objCreatePSDEOPPrivLock;
        synchronized (n) {
            if (this.createpsdeoppriv != null && DataTypeHelper.compare((int)25, (Object)this.getCreatePSDEOPPrivId(), (Object)this.createpsdeoppriv.getPSDEOPPrivId()) != 0L) {
                this.createpsdeoppriv = null;
            }
            if (this.createpsdeoppriv == null) {
                PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
                pSDEOPPriv.setPSDEOPPrivId(this.getCreatePSDEOPPrivId());
                PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
                pSDEOPPrivService.autoGet(pSDEOPPriv);
                this.createpsdeoppriv = pSDEOPPriv;
            }
            return this.createpsdeoppriv;
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
    public PSDEUAGroup getPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroup();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAGroupLock;
        synchronized (n) {
            if (this.psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUAGroupId(), (Object)this.psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.psdeuagroup = null;
            }
            if (this.psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getLinkPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkPSDEView();
        }
        if (this.getLinkPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objLinkPSDEViewLock;
        synchronized (n) {
            if (this.linkpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getLinkPSDEViewId(), (Object)this.linkpsdeview.getPSDEViewBaseId()) != 0L) {
                this.linkpsdeview = null;
            }
            if (this.linkpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getLinkPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.linkpsdeview = pSDEViewBase;
            }
            return this.linkpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPickupPSDEView();
        }
        if (this.getPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objPickupPSDEViewLock;
        synchronized (n) {
            if (this.pickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getPickupPSDEViewId(), (Object)this.pickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.pickuppsdeview = null;
            }
            if (this.pickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.pickuppsdeview = pSDEViewBase;
            }
            return this.pickuppsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getEmptyTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSLanRes();
        }
        if (this.getEmptyTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objEmptyTextPSLanResLock;
        synchronized (n) {
            if (this.emptytextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getEmptyTextPSLanResId(), (Object)this.emptytextpslanres.getPSLanguageResId()) != 0L) {
                this.emptytextpslanres = null;
            }
            if (this.emptytextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getEmptyTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.emptytextpslanres = pSLanguageRes;
            }
            return this.emptytextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIChatAgent getPSSysAIChatAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgent();
        }
        if (this.getPSSysAIChatAgentId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIChatAgentLock;
        synchronized (n) {
            if (this.pssysaichatagent != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIChatAgentId(), (Object)this.pssysaichatagent.getPSSysAIChatAgentId()) != 0L) {
                this.pssysaichatagent = null;
            }
            if (this.pssysaichatagent == null) {
                PSSysAIChatAgent pSSysAIChatAgent = new PSSysAIChatAgent();
                pSSysAIChatAgent.setPSSysAIChatAgentId(this.getPSSysAIChatAgentId());
                PSSysAIChatAgentService pSSysAIChatAgentService = (PSSysAIChatAgentService)ServiceGlobal.getService(PSSysAIChatAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIChatAgentService.autoGet(pSSysAIChatAgent);
                this.pssysaichatagent = pSSysAIChatAgent;
            }
            return this.pssysaichatagent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIFactory getPSSysAIFactory() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactory();
        }
        if (this.getPSSysAIFactoryId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIFactoryLock;
        synchronized (n) {
            if (this.pssysaifactory != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIFactoryId(), (Object)this.pssysaifactory.getPSSysAIFactoryId()) != 0L) {
                this.pssysaifactory = null;
            }
            if (this.pssysaifactory == null) {
                PSSysAIFactory pSSysAIFactory = new PSSysAIFactory();
                pSSysAIFactory.setPSSysAIFactoryId(this.getPSSysAIFactoryId());
                PSSysAIFactoryService pSSysAIFactoryService = (PSSysAIFactoryService)ServiceGlobal.getService(PSSysAIFactoryService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIFactoryService.autoGet(pSSysAIFactory);
                this.pssysaifactory = pSSysAIFactory;
            }
            return this.pssysaifactory;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getHistoryPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHistoryPSSysMsgTempl();
        }
        if (this.getHistoryPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objHistoryPSSysMsgTemplLock;
        synchronized (n) {
            if (this.historypssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getHistoryPSSysMsgTemplId(), (Object)this.historypssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.historypssysmsgtempl = null;
            }
            if (this.historypssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getHistoryPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.historypssysmsgtempl = pSSysMsgTempl;
            }
            return this.historypssysmsgtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getACIPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getACIPSSysPFPlugin();
        }
        if (this.getACIPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objACIPSSysPFPluginLock;
        synchronized (n) {
            if (this.acipssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getACIPSSysPFPluginId(), (Object)this.acipssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.acipssyspfplugin = null;
            }
            if (this.acipssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getACIPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.acipssyspfplugin = pSSysPFPlugin;
            }
            return this.acipssyspfplugin;
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
    public PSSysUtilDE getAIFactoryPSSysUtilDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIFactoryPSSysUtilDE();
        }
        if (this.getAIFactoryPSSysUtilDEId() == null) {
            return null;
        }
        Integer n = this.objAIFactoryPSSysUtilDELock;
        synchronized (n) {
            if (this.aifactorypssysutilde != null && DataTypeHelper.compare((int)25, (Object)this.getAIFactoryPSSysUtilDEId(), (Object)this.aifactorypssysutilde.getPSSysUtilDEId()) != 0L) {
                this.aifactorypssysutilde = null;
            }
            if (this.aifactorypssysutilde == null) {
                PSSysUtilDE pSSysUtilDE = new PSSysUtilDE();
                pSSysUtilDE.setPSSysUtilDEId(this.getAIFactoryPSSysUtilDEId());
                PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysUtilDEService.autoGet(pSSysUtilDE);
                this.aifactorypssysutilde = pSSysUtilDE;
            }
            return this.aifactorypssysutilde;
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
    public ArrayList<PSDEACModeItem> getPSDEACModeItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeItems();
        }
        if (this.getPSDEACModeId() == null) {
            return null;
        }
        PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        PSDEACModeItemService pSDEACModeItemService = (PSDEACModeItemService)ServiceGlobal.getService(PSDEACModeItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEACModeItemsLock;
        synchronized (n) {
            if (this.psdeacmodeitems == null) {
                this.psdeacmodeitems = pSDEACModeService.isTempData(this) ? pSDEACModeItemService.selectTempByPSDEACMode(this) : pSDEACModeItemService.selectByPSDEACMode(this);
            }
            return this.psdeacmodeitems;
        }
    }

    private PSDEACModeBase getProxyEntity() {
        return this.proxyPSDEACModeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEACModeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEACModeBase) {
            this.proxyPSDEACModeBase = (PSDEACModeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACIPSSYSPFPLUGINID, 0);
        fieldIndexMap.put(FIELD_ACIPSSYSPFPLUGINNAME, 1);
        fieldIndexMap.put(FIELD_ACPARAMS, 2);
        fieldIndexMap.put(FIELD_ACTAG, 3);
        fieldIndexMap.put(FIELD_ACTAG2, 4);
        fieldIndexMap.put(FIELD_ACTAG3, 5);
        fieldIndexMap.put(FIELD_ACTAG4, 6);
        fieldIndexMap.put(FIELD_ACTIONHOLDER, 7);
        fieldIndexMap.put(FIELD_ACTYPE, 8);
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 9);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 10);
        fieldIndexMap.put(FIELD_AIFACTORYPSSYSUTILDEID, 11);
        fieldIndexMap.put(FIELD_AIFACTORYPSSYSUTILDENAME, 12);
        fieldIndexMap.put(FIELD_CODENAME, 13);
        fieldIndexMap.put(FIELD_CREATEDATE, 14);
        fieldIndexMap.put(FIELD_CREATEMAN, 15);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVID, 16);
        fieldIndexMap.put(FIELD_CREATEPSDEOPPRIVNAME, 17);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 18);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 19);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 20);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 21);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 22);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESID, 23);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSLANRESNAME, 24);
        fieldIndexMap.put(FIELD_ENABLEPAGINGBAR, 25);
        fieldIndexMap.put(FIELD_EXTENDMODE, 26);
        fieldIndexMap.put(FIELD_FILLEROBJ, 27);
        fieldIndexMap.put(FIELD_HISTORYPSSYSMSGTEMPLID, 28);
        fieldIndexMap.put(FIELD_HISTORYPSSYSMSGTEMPLNAME, 29);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWID, 30);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWNAME, 31);
        fieldIndexMap.put(FIELD_LOCKFLAG, 32);
        fieldIndexMap.put(FIELD_LOGICNAME, 33);
        fieldIndexMap.put(FIELD_MEMO, 34);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 35);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFID, 36);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFNAME, 37);
        fieldIndexMap.put(FIELD_PAGINGSIZE, 38);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWID, 39);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWNAME, 40);
        fieldIndexMap.put(FIELD_PSDEACMODEID, 41);
        fieldIndexMap.put(FIELD_PSDEACMODENAME, 42);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 43);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 44);
        fieldIndexMap.put(FIELD_PSDEID, 45);
        fieldIndexMap.put(FIELD_PSDENAME, 46);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 47);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 48);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 49);
        fieldIndexMap.put(FIELD_PSSYSAICHATAGENTID, 50);
        fieldIndexMap.put(FIELD_PSSYSAICHATAGENTNAME, 51);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYID, 52);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYNAME, 53);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 54);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 55);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 56);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 57);
        fieldIndexMap.put(FIELD_READPSDEOPPRIVID, 58);
        fieldIndexMap.put(FIELD_READPSDEOPPRIVNAME, 59);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 60);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 61);
        fieldIndexMap.put(FIELD_UPDATEDATE, 62);
        fieldIndexMap.put(FIELD_UPDATEMAN, 63);
        fieldIndexMap.put(FIELD_USERCAT, 64);
        fieldIndexMap.put(FIELD_USERTAG, 65);
        fieldIndexMap.put(FIELD_USERTAG2, 66);
        fieldIndexMap.put(FIELD_USERTAG3, 67);
        fieldIndexMap.put(FIELD_USERTAG4, 68);
        fieldIndexMap.put(FIELD_VALUEPSDEFID, 69);
        fieldIndexMap.put(FIELD_VALUEPSDEFNAME, 70);
    }
}

