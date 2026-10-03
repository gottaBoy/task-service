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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateRS;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMainStateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMainStateBase.class);
    public static final String FIELD_ALLOWMODE = "ALLOWMODE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEACTIONDENYMSG = "DEACTIONDENYMSG";
    public static final String FIELD_DEACTIONDMPSLANRESID = "DEACTIONDMPSLANRESID";
    public static final String FIELD_DEACTIONDMPSLANRESNAME = "DEACTIONDMPSLANRESNAME";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DEOPPRIVDENYMSG = "DEOPPRIVDENYMSG";
    public static final String FIELD_DEOPPRIVDMPSLANRESID = "DEOPPRIVDMPSLANRESID";
    public static final String FIELD_DEOPPRIVDMPSLANRESNAME = "DEOPPRIVDMPSLANRESNAME";
    public static final String FIELD_EDITVIEWTYPE = "EDITVIEWTYPE";
    public static final String FIELD_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String FIELD_ENTERPSDEACTIONID = "ENTERPSDEACTIONID";
    public static final String FIELD_ENTERPSDEACTIONNAME = "ENTERPSDEACTIONNAME";
    public static final String FIELD_ENTERSTATEMODE = "ENTERSTATEMODE";
    public static final String FIELD_FIELDALLOWMODE = "FIELDALLOWMODE";
    public static final String FIELD_FORMCODENAME = "FORMCODENAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBEDITVIEWTYPE = "MOBEDITVIEWTYPE";
    public static final String FIELD_MOBFORMCODENAME = "MOBFORMCODENAME";
    public static final String FIELD_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String FIELD_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String FIELD_MOBQUICKFORMCODENAME = "MOBQUICKFORMCODENAME";
    public static final String FIELD_MOBQUICKPSDEFORMID = "MOBQUICKPSDEFORMID";
    public static final String FIELD_MOBQUICKPSDEFORMNAME = "MOBQUICKPSDEFORMNAME";
    public static final String FIELD_MOBUTILFORMCODENAME = "MOBUTILFORMCODENAME";
    public static final String FIELD_MOBUTILPSDEFORMID = "MOBUTILPSDEFORMID";
    public static final String FIELD_MOBUTILPSDEFORMNAME = "MOBUTILPSDEFORMNAME";
    public static final String FIELD_MSTAG = "MSTAG";
    public static final String FIELD_MSVALUE = "MSVALUE";
    public static final String FIELD_MSVALUE2 = "MSVALUE2";
    public static final String FIELD_MSVALUE2TEXT = "MSVALUE2TEXT";
    public static final String FIELD_MSVALUE3 = "MSVALUE3";
    public static final String FIELD_MSVALUE3TEXT = "MSVALUE3TEXT";
    public static final String FIELD_MSVALUETEXT = "MSVALUETEXT";
    public static final String FIELD_OPPRIVALLOWMODE = "OPPRIVALLOWMODE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_QUICKFORMCODENAME = "QUICKFORMCODENAME";
    public static final String FIELD_QUICKPSDEFORMID = "QUICKPSDEFORMID";
    public static final String FIELD_QUICKPSDEFORMNAME = "QUICKPSDEFORMNAME";
    public static final String FIELD_TEXTPSLANRESID = "TEXTPSLANRESID";
    public static final String FIELD_TEXTPSLANRESNAME = "TEXTPSLANRESNAME";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTILFORMCODENAME = "UTILFORMCODENAME";
    public static final String FIELD_UTILPSDEFORMID = "UTILPSDEFORMID";
    public static final String FIELD_UTILPSDEFORMNAME = "UTILPSDEFORMNAME";
    public static final String FIELD_VIEWACTIONS = "VIEWACTIONS";
    public static final String FIELD_WFSTATEMODE = "WFSTATEMODE";
    private static final int INDEX_ALLOWMODE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_COLOR = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DEACTIONDENYMSG = 5;
    private static final int INDEX_DEACTIONDMPSLANRESID = 6;
    private static final int INDEX_DEACTIONDMPSLANRESNAME = 7;
    private static final int INDEX_DEFAULTMODE = 8;
    private static final int INDEX_DEOPPRIVDENYMSG = 9;
    private static final int INDEX_DEOPPRIVDMPSLANRESID = 10;
    private static final int INDEX_DEOPPRIVDMPSLANRESNAME = 11;
    private static final int INDEX_EDITVIEWTYPE = 12;
    private static final int INDEX_ENABLEVIEWACTIONS = 13;
    private static final int INDEX_ENTERPSDEACTIONID = 14;
    private static final int INDEX_ENTERPSDEACTIONNAME = 15;
    private static final int INDEX_ENTERSTATEMODE = 16;
    private static final int INDEX_FIELDALLOWMODE = 17;
    private static final int INDEX_FORMCODENAME = 18;
    private static final int INDEX_LOCKFLAG = 19;
    private static final int INDEX_MEMO = 20;
    private static final int INDEX_MOBEDITVIEWTYPE = 21;
    private static final int INDEX_MOBFORMCODENAME = 22;
    private static final int INDEX_MOBPSDEFORMID = 23;
    private static final int INDEX_MOBPSDEFORMNAME = 24;
    private static final int INDEX_MOBQUICKFORMCODENAME = 25;
    private static final int INDEX_MOBQUICKPSDEFORMID = 26;
    private static final int INDEX_MOBQUICKPSDEFORMNAME = 27;
    private static final int INDEX_MOBUTILFORMCODENAME = 28;
    private static final int INDEX_MOBUTILPSDEFORMID = 29;
    private static final int INDEX_MOBUTILPSDEFORMNAME = 30;
    private static final int INDEX_MSTAG = 31;
    private static final int INDEX_MSVALUE = 32;
    private static final int INDEX_MSVALUE2 = 33;
    private static final int INDEX_MSVALUE2TEXT = 34;
    private static final int INDEX_MSVALUE3 = 35;
    private static final int INDEX_MSVALUE3TEXT = 36;
    private static final int INDEX_MSVALUETEXT = 37;
    private static final int INDEX_OPPRIVALLOWMODE = 38;
    private static final int INDEX_ORDERVALUE = 39;
    private static final int INDEX_PSDEDQID = 40;
    private static final int INDEX_PSDEDQNAME = 41;
    private static final int INDEX_PSDEFORMID = 42;
    private static final int INDEX_PSDEFORMNAME = 43;
    private static final int INDEX_PSDEID = 44;
    private static final int INDEX_PSDEMAINSTATEID = 45;
    private static final int INDEX_PSDEMAINSTATENAME = 46;
    private static final int INDEX_PSDENAME = 47;
    private static final int INDEX_PSSYSCSSID = 48;
    private static final int INDEX_PSSYSCSSNAME = 49;
    private static final int INDEX_PSSYSDYNAMODELID = 50;
    private static final int INDEX_PSSYSDYNAMODELNAME = 51;
    private static final int INDEX_PSSYSIMAGEID = 52;
    private static final int INDEX_PSSYSIMAGENAME = 53;
    private static final int INDEX_QUICKFORMCODENAME = 54;
    private static final int INDEX_QUICKPSDEFORMID = 55;
    private static final int INDEX_QUICKPSDEFORMNAME = 56;
    private static final int INDEX_TEXTPSLANRESID = 57;
    private static final int INDEX_TEXTPSLANRESNAME = 58;
    private static final int INDEX_TIPPSLANRESID = 59;
    private static final int INDEX_TIPPSLANRESNAME = 60;
    private static final int INDEX_TODOTASK = 61;
    private static final int INDEX_TOOLTIPINFO = 62;
    private static final int INDEX_UPDATEDATE = 63;
    private static final int INDEX_UPDATEMAN = 64;
    private static final int INDEX_USERCAT = 65;
    private static final int INDEX_USERTAG = 66;
    private static final int INDEX_USERTAG2 = 67;
    private static final int INDEX_USERTAG3 = 68;
    private static final int INDEX_USERTAG4 = 69;
    private static final int INDEX_UTILFORMCODENAME = 70;
    private static final int INDEX_UTILPSDEFORMID = 71;
    private static final int INDEX_UTILPSDEFORMNAME = 72;
    private static final int INDEX_VIEWACTIONS = 73;
    private static final int INDEX_WFSTATEMODE = 74;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMainStateBase proxyPSDEMainStateBase = null;
    private boolean allowmodeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deactiondenymsgDirtyFlag = false;
    private boolean deactiondmpslanresidDirtyFlag = false;
    private boolean deactiondmpslanresnameDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean deopprivdenymsgDirtyFlag = false;
    private boolean deopprivdmpslanresidDirtyFlag = false;
    private boolean deopprivdmpslanresnameDirtyFlag = false;
    private boolean editviewtypeDirtyFlag = false;
    private boolean enableviewactionsDirtyFlag = false;
    private boolean enterpsdeactionidDirtyFlag = false;
    private boolean enterpsdeactionnameDirtyFlag = false;
    private boolean enterstatemodeDirtyFlag = false;
    private boolean fieldallowmodeDirtyFlag = false;
    private boolean formcodenameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobeditviewtypeDirtyFlag = false;
    private boolean mobformcodenameDirtyFlag = false;
    private boolean mobpsdeformidDirtyFlag = false;
    private boolean mobpsdeformnameDirtyFlag = false;
    private boolean mobquickformcodenameDirtyFlag = false;
    private boolean mobquickpsdeformidDirtyFlag = false;
    private boolean mobquickpsdeformnameDirtyFlag = false;
    private boolean mobutilformcodenameDirtyFlag = false;
    private boolean mobutilpsdeformidDirtyFlag = false;
    private boolean mobutilpsdeformnameDirtyFlag = false;
    private boolean mstagDirtyFlag = false;
    private boolean msvalueDirtyFlag = false;
    private boolean msvalue2DirtyFlag = false;
    private boolean msvalue2textDirtyFlag = false;
    private boolean msvalue3DirtyFlag = false;
    private boolean msvalue3textDirtyFlag = false;
    private boolean msvaluetextDirtyFlag = false;
    private boolean opprivallowmodeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean quickformcodenameDirtyFlag = false;
    private boolean quickpsdeformidDirtyFlag = false;
    private boolean quickpsdeformnameDirtyFlag = false;
    private boolean textpslanresidDirtyFlag = false;
    private boolean textpslanresnameDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean utilformcodenameDirtyFlag = false;
    private boolean utilpsdeformidDirtyFlag = false;
    private boolean utilpsdeformnameDirtyFlag = false;
    private boolean viewactionsDirtyFlag = false;
    private boolean wfstatemodeDirtyFlag = false;
    @Column(name="allowmode")
    private String allowmode;
    @Column(name="codename")
    private String codename;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deactiondenymsg")
    private String deactiondenymsg;
    @Column(name="deactiondmpslanresid")
    private String deactiondmpslanresid;
    @Column(name="deactiondmpslanresname")
    private String deactiondmpslanresname;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="deopprivdenymsg")
    private String deopprivdenymsg;
    @Column(name="deopprivdmpslanresid")
    private String deopprivdmpslanresid;
    @Column(name="deopprivdmpslanresname")
    private String deopprivdmpslanresname;
    @Column(name="editviewtype")
    private String editviewtype;
    @Column(name="enableviewactions")
    private Integer enableviewactions;
    @Column(name="enterpsdeactionid")
    private String enterpsdeactionid;
    @Column(name="enterpsdeactionname")
    private String enterpsdeactionname;
    @Column(name="enterstatemode")
    private String enterstatemode;
    @Column(name="fieldallowmode")
    private String fieldallowmode;
    @Column(name="formcodename")
    private String formcodename;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="mobeditviewtype")
    private String mobeditviewtype;
    @Column(name="mobformcodename")
    private String mobformcodename;
    @Column(name="mobpsdeformid")
    private String mobpsdeformid;
    @Column(name="mobpsdeformname")
    private String mobpsdeformname;
    @Column(name="mobquickformcodename")
    private String mobquickformcodename;
    @Column(name="mobquickpsdeformid")
    private String mobquickpsdeformid;
    @Column(name="mobquickpsdeformname")
    private String mobquickpsdeformname;
    @Column(name="mobutilformcodename")
    private String mobutilformcodename;
    @Column(name="mobutilpsdeformid")
    private String mobutilpsdeformid;
    @Column(name="mobutilpsdeformname")
    private String mobutilpsdeformname;
    @Column(name="mstag")
    private String mstag;
    @Column(name="msvalue")
    private String msvalue;
    @Column(name="msvalue2")
    private String msvalue2;
    @Column(name="msvalue2text")
    private String msvalue2text;
    @Column(name="msvalue3")
    private String msvalue3;
    @Column(name="msvalue3text")
    private String msvalue3text;
    @Column(name="msvaluetext")
    private String msvaluetext;
    @Column(name="opprivallowmode")
    private String opprivallowmode;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="quickformcodename")
    private String quickformcodename;
    @Column(name="quickpsdeformid")
    private String quickpsdeformid;
    @Column(name="quickpsdeformname")
    private String quickpsdeformname;
    @Column(name="textpslanresid")
    private String textpslanresid;
    @Column(name="textpslanresname")
    private String textpslanresname;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="todotask")
    private String todotask;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
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
    @Column(name="utilformcodename")
    private String utilformcodename;
    @Column(name="utilpsdeformid")
    private String utilpsdeformid;
    @Column(name="utilpsdeformname")
    private String utilpsdeformname;
    @Column(name="viewactions")
    private Integer viewactions;
    @Column(name="wfstatemode")
    private Integer wfstatemode;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objEnterPSDEActionLock = new Integer(1);
    private PSDEAction enterpsdeaction = null;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objMobPSDEFormLock = new Integer(1);
    private PSDEForm mobpsdeform = null;
    private Integer objMobQuickPSDEFormLock = new Integer(1);
    private PSDEForm mobquickpsdeform = null;
    private Integer objMobUtilPSDEFormLock = new Integer(1);
    private PSDEForm mobutilpsdeform = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objQuickPSDEFormLock = new Integer(1);
    private PSDEForm quickpsdeform = null;
    private Integer objUtilPSDEFormLock = new Integer(1);
    private PSDEForm utilpsdeform = null;
    private Integer objDEActionDMPSLanResLock = new Integer(1);
    private PSLanguageRes deactiondmpslanres = null;
    private Integer objDEOPPrivDMPSLanResLock = new Integer(1);
    private PSLanguageRes deopprivdmpslanres = null;
    private Integer objTextPSLanResLock = new Integer(1);
    private PSLanguageRes textpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSDEMainStateRSsLock = new Integer(1);
    private ArrayList<PSDEMainStateRS> psdemainstaterss = null;
    private Integer objPSDEMSActionsLock = new Integer(1);
    private ArrayList<PSDEMSAction> psdemsactions = null;
    private Integer objPSDEMSFieldsLock = new Integer(1);
    private ArrayList<PSDEMSField> psdemsfields = null;
    private Integer objPSDEMSOPPrivsLock = new Integer(1);
    private ArrayList<PSDEMSOPPriv> psdemsopprivs = null;
    private Integer objPSDESampleDatasLock = new Integer(1);
    private ArrayList<PSDESampleData> psdesampledatas = null;

    public void setAllowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.allowmode = string;
        this.allowmodeDirtyFlag = true;
    }

    public String getAllowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowMode();
        }
        return this.allowmode;
    }

    public boolean isAllowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowModeDirty();
        }
        return this.allowmodeDirtyFlag;
    }

    public void resetAllowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowMode();
            return;
        }
        this.allowmodeDirtyFlag = false;
        this.allowmode = null;
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

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setDEActionDenyMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEActionDenyMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deactiondenymsg = string;
        this.deactiondenymsgDirtyFlag = true;
    }

    public String getDEActionDenyMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEActionDenyMsg();
        }
        return this.deactiondenymsg;
    }

    public boolean isDEActionDenyMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEActionDenyMsgDirty();
        }
        return this.deactiondenymsgDirtyFlag;
    }

    public void resetDEActionDenyMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEActionDenyMsg();
            return;
        }
        this.deactiondenymsgDirtyFlag = false;
        this.deactiondenymsg = null;
    }

    public void setDEActionDMPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEActionDMPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deactiondmpslanresid = string;
        this.deactiondmpslanresidDirtyFlag = true;
    }

    public String getDEActionDMPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEActionDMPSLanResId();
        }
        return this.deactiondmpslanresid;
    }

    public boolean isDEActionDMPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEActionDMPSLanResIdDirty();
        }
        return this.deactiondmpslanresidDirtyFlag;
    }

    public void resetDEActionDMPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEActionDMPSLanResId();
            return;
        }
        this.deactiondmpslanresidDirtyFlag = false;
        this.deactiondmpslanresid = null;
    }

    public void setDEActionDMPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEActionDMPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deactiondmpslanresname = string;
        this.deactiondmpslanresnameDirtyFlag = true;
    }

    public String getDEActionDMPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEActionDMPSLanResName();
        }
        return this.deactiondmpslanresname;
    }

    public boolean isDEActionDMPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEActionDMPSLanResNameDirty();
        }
        return this.deactiondmpslanresnameDirtyFlag;
    }

    public void resetDEActionDMPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEActionDMPSLanResName();
            return;
        }
        this.deactiondmpslanresnameDirtyFlag = false;
        this.deactiondmpslanresname = null;
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

    public void setDEOPPrivDenyMsg(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEOPPrivDenyMsg(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deopprivdenymsg = string;
        this.deopprivdenymsgDirtyFlag = true;
    }

    public String getDEOPPrivDenyMsg() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOPPrivDenyMsg();
        }
        return this.deopprivdenymsg;
    }

    public boolean isDEOPPrivDenyMsgDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEOPPrivDenyMsgDirty();
        }
        return this.deopprivdenymsgDirtyFlag;
    }

    public void resetDEOPPrivDenyMsg() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEOPPrivDenyMsg();
            return;
        }
        this.deopprivdenymsgDirtyFlag = false;
        this.deopprivdenymsg = null;
    }

    public void setDEOPPrivDMPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEOPPrivDMPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deopprivdmpslanresid = string;
        this.deopprivdmpslanresidDirtyFlag = true;
    }

    public String getDEOPPrivDMPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOPPrivDMPSLanResId();
        }
        return this.deopprivdmpslanresid;
    }

    public boolean isDEOPPrivDMPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEOPPrivDMPSLanResIdDirty();
        }
        return this.deopprivdmpslanresidDirtyFlag;
    }

    public void resetDEOPPrivDMPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEOPPrivDMPSLanResId();
            return;
        }
        this.deopprivdmpslanresidDirtyFlag = false;
        this.deopprivdmpslanresid = null;
    }

    public void setDEOPPrivDMPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEOPPrivDMPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deopprivdmpslanresname = string;
        this.deopprivdmpslanresnameDirtyFlag = true;
    }

    public String getDEOPPrivDMPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOPPrivDMPSLanResName();
        }
        return this.deopprivdmpslanresname;
    }

    public boolean isDEOPPrivDMPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEOPPrivDMPSLanResNameDirty();
        }
        return this.deopprivdmpslanresnameDirtyFlag;
    }

    public void resetDEOPPrivDMPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEOPPrivDMPSLanResName();
            return;
        }
        this.deopprivdmpslanresnameDirtyFlag = false;
        this.deopprivdmpslanresname = null;
    }

    public void setEditViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editviewtype = string;
        this.editviewtypeDirtyFlag = true;
    }

    public String getEditViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditViewType();
        }
        return this.editviewtype;
    }

    public boolean isEditViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditViewTypeDirty();
        }
        return this.editviewtypeDirtyFlag;
    }

    public void resetEditViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditViewType();
            return;
        }
        this.editviewtypeDirtyFlag = false;
        this.editviewtype = null;
    }

    public void setEnableViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableViewActions(n);
            return;
        }
        this.enableviewactions = n;
        this.enableviewactionsDirtyFlag = true;
    }

    public Integer getEnableViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableViewActions();
        }
        return this.enableviewactions;
    }

    public boolean isEnableViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableViewActionsDirty();
        }
        return this.enableviewactionsDirtyFlag;
    }

    public void resetEnableViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableViewActions();
            return;
        }
        this.enableviewactionsDirtyFlag = false;
        this.enableviewactions = null;
    }

    public void setEnterPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnterPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enterpsdeactionid = string;
        this.enterpsdeactionidDirtyFlag = true;
    }

    public String getEnterPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnterPSDEActionId();
        }
        return this.enterpsdeactionid;
    }

    public boolean isEnterPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnterPSDEActionIdDirty();
        }
        return this.enterpsdeactionidDirtyFlag;
    }

    public void resetEnterPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnterPSDEActionId();
            return;
        }
        this.enterpsdeactionidDirtyFlag = false;
        this.enterpsdeactionid = null;
    }

    public void setEnterPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnterPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enterpsdeactionname = string;
        this.enterpsdeactionnameDirtyFlag = true;
    }

    public String getEnterPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnterPSDEActionName();
        }
        return this.enterpsdeactionname;
    }

    public boolean isEnterPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnterPSDEActionNameDirty();
        }
        return this.enterpsdeactionnameDirtyFlag;
    }

    public void resetEnterPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnterPSDEActionName();
            return;
        }
        this.enterpsdeactionnameDirtyFlag = false;
        this.enterpsdeactionname = null;
    }

    public void setEnterStateMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnterStateMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enterstatemode = string;
        this.enterstatemodeDirtyFlag = true;
    }

    public String getEnterStateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnterStateMode();
        }
        return this.enterstatemode;
    }

    public boolean isEnterStateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnterStateModeDirty();
        }
        return this.enterstatemodeDirtyFlag;
    }

    public void resetEnterStateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnterStateMode();
            return;
        }
        this.enterstatemodeDirtyFlag = false;
        this.enterstatemode = null;
    }

    public void setFieldAllowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldAllowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldallowmode = string;
        this.fieldallowmodeDirtyFlag = true;
    }

    public String getFieldAllowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldAllowMode();
        }
        return this.fieldallowmode;
    }

    public boolean isFieldAllowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldAllowModeDirty();
        }
        return this.fieldallowmodeDirtyFlag;
    }

    public void resetFieldAllowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldAllowMode();
            return;
        }
        this.fieldallowmodeDirtyFlag = false;
        this.fieldallowmode = null;
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

    public void setMobEditViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobEditViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobeditviewtype = string;
        this.mobeditviewtypeDirtyFlag = true;
    }

    public String getMobEditViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobEditViewType();
        }
        return this.mobeditviewtype;
    }

    public boolean isMobEditViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobEditViewTypeDirty();
        }
        return this.mobeditviewtypeDirtyFlag;
    }

    public void resetMobEditViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobEditViewType();
            return;
        }
        this.mobeditviewtypeDirtyFlag = false;
        this.mobeditviewtype = null;
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

    public void setMobQuickFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobQuickFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobquickformcodename = string;
        this.mobquickformcodenameDirtyFlag = true;
    }

    public String getMobQuickFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobQuickFormCodeName();
        }
        return this.mobquickformcodename;
    }

    public boolean isMobQuickFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobQuickFormCodeNameDirty();
        }
        return this.mobquickformcodenameDirtyFlag;
    }

    public void resetMobQuickFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobQuickFormCodeName();
            return;
        }
        this.mobquickformcodenameDirtyFlag = false;
        this.mobquickformcodename = null;
    }

    public void setMobQuickPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobQuickPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobquickpsdeformid = string;
        this.mobquickpsdeformidDirtyFlag = true;
    }

    public String getMobQuickPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobQuickPSDEFormId();
        }
        return this.mobquickpsdeformid;
    }

    public boolean isMobQuickPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobQuickPSDEFormIdDirty();
        }
        return this.mobquickpsdeformidDirtyFlag;
    }

    public void resetMobQuickPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobQuickPSDEFormId();
            return;
        }
        this.mobquickpsdeformidDirtyFlag = false;
        this.mobquickpsdeformid = null;
    }

    public void setMobQuickPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobQuickPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobquickpsdeformname = string;
        this.mobquickpsdeformnameDirtyFlag = true;
    }

    public String getMobQuickPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobQuickPSDEFormName();
        }
        return this.mobquickpsdeformname;
    }

    public boolean isMobQuickPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobQuickPSDEFormNameDirty();
        }
        return this.mobquickpsdeformnameDirtyFlag;
    }

    public void resetMobQuickPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobQuickPSDEFormName();
            return;
        }
        this.mobquickpsdeformnameDirtyFlag = false;
        this.mobquickpsdeformname = null;
    }

    public void setMobUtilFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtilFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutilformcodename = string;
        this.mobutilformcodenameDirtyFlag = true;
    }

    public String getMobUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilFormCodeName();
        }
        return this.mobutilformcodename;
    }

    public boolean isMobUtilFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtilFormCodeNameDirty();
        }
        return this.mobutilformcodenameDirtyFlag;
    }

    public void resetMobUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtilFormCodeName();
            return;
        }
        this.mobutilformcodenameDirtyFlag = false;
        this.mobutilformcodename = null;
    }

    public void setMobUtilPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtilPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutilpsdeformid = string;
        this.mobutilpsdeformidDirtyFlag = true;
    }

    public String getMobUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilPSDEFormId();
        }
        return this.mobutilpsdeformid;
    }

    public boolean isMobUtilPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtilPSDEFormIdDirty();
        }
        return this.mobutilpsdeformidDirtyFlag;
    }

    public void resetMobUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtilPSDEFormId();
            return;
        }
        this.mobutilpsdeformidDirtyFlag = false;
        this.mobutilpsdeformid = null;
    }

    public void setMobUtilPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobUtilPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobutilpsdeformname = string;
        this.mobutilpsdeformnameDirtyFlag = true;
    }

    public String getMobUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilPSDEFormName();
        }
        return this.mobutilpsdeformname;
    }

    public boolean isMobUtilPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobUtilPSDEFormNameDirty();
        }
        return this.mobutilpsdeformnameDirtyFlag;
    }

    public void resetMobUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobUtilPSDEFormName();
            return;
        }
        this.mobutilpsdeformnameDirtyFlag = false;
        this.mobutilpsdeformname = null;
    }

    public void setMSTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mstag = string;
        this.mstagDirtyFlag = true;
    }

    public String getMSTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSTag();
        }
        return this.mstag;
    }

    public boolean isMSTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSTagDirty();
        }
        return this.mstagDirtyFlag;
    }

    public void resetMSTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSTag();
            return;
        }
        this.mstagDirtyFlag = false;
        this.mstag = null;
    }

    public void setMSValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msvalue = string;
        this.msvalueDirtyFlag = true;
    }

    public String getMSValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSValue();
        }
        return this.msvalue;
    }

    public boolean isMSValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSValueDirty();
        }
        return this.msvalueDirtyFlag;
    }

    public void resetMSValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSValue();
            return;
        }
        this.msvalueDirtyFlag = false;
        this.msvalue = null;
    }

    public void setMSValue2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSValue2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msvalue2 = string;
        this.msvalue2DirtyFlag = true;
    }

    public String getMSValue2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSValue2();
        }
        return this.msvalue2;
    }

    public boolean isMSValue2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSValue2Dirty();
        }
        return this.msvalue2DirtyFlag;
    }

    public void resetMSValue2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSValue2();
            return;
        }
        this.msvalue2DirtyFlag = false;
        this.msvalue2 = null;
    }

    public void setMSValue2Text(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSValue2Text(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msvalue2text = string;
        this.msvalue2textDirtyFlag = true;
    }

    public String getMSValue2Text() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSValue2Text();
        }
        return this.msvalue2text;
    }

    public boolean isMSValue2TextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSValue2TextDirty();
        }
        return this.msvalue2textDirtyFlag;
    }

    public void resetMSValue2Text() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSValue2Text();
            return;
        }
        this.msvalue2textDirtyFlag = false;
        this.msvalue2text = null;
    }

    public void setMSValue3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSValue3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msvalue3 = string;
        this.msvalue3DirtyFlag = true;
    }

    public String getMSValue3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSValue3();
        }
        return this.msvalue3;
    }

    public boolean isMSValue3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSValue3Dirty();
        }
        return this.msvalue3DirtyFlag;
    }

    public void resetMSValue3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSValue3();
            return;
        }
        this.msvalue3DirtyFlag = false;
        this.msvalue3 = null;
    }

    public void setMSValue3Text(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSValue3Text(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msvalue3text = string;
        this.msvalue3textDirtyFlag = true;
    }

    public String getMSValue3Text() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSValue3Text();
        }
        return this.msvalue3text;
    }

    public boolean isMSValue3TextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSValue3TextDirty();
        }
        return this.msvalue3textDirtyFlag;
    }

    public void resetMSValue3Text() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSValue3Text();
            return;
        }
        this.msvalue3textDirtyFlag = false;
        this.msvalue3text = null;
    }

    public void setMSValueText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSValueText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msvaluetext = string;
        this.msvaluetextDirtyFlag = true;
    }

    public String getMSValueText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSValueText();
        }
        return this.msvaluetext;
    }

    public boolean isMSValueTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSValueTextDirty();
        }
        return this.msvaluetextDirtyFlag;
    }

    public void resetMSValueText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSValueText();
            return;
        }
        this.msvaluetextDirtyFlag = false;
        this.msvaluetext = null;
    }

    public void setOPPrivAllowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOPPrivAllowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.opprivallowmode = string;
        this.opprivallowmodeDirtyFlag = true;
    }

    public String getOPPrivAllowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOPPrivAllowMode();
        }
        return this.opprivallowmode;
    }

    public boolean isOPPrivAllowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOPPrivAllowModeDirty();
        }
        return this.opprivallowmodeDirtyFlag;
    }

    public void resetOPPrivAllowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOPPrivAllowMode();
            return;
        }
        this.opprivallowmodeDirtyFlag = false;
        this.opprivallowmode = null;
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

    public void setPSDEDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqid = string;
        this.psdedqidDirtyFlag = true;
    }

    public String getPSDEDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQId();
        }
        return this.psdedqid;
    }

    public boolean isPSDEDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQIdDirty();
        }
        return this.psdedqidDirtyFlag;
    }

    public void resetPSDEDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQId();
            return;
        }
        this.psdedqidDirtyFlag = false;
        this.psdedqid = null;
    }

    public void setPSDEDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqname = string;
        this.psdedqnameDirtyFlag = true;
    }

    public String getPSDEDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQName();
        }
        return this.psdedqname;
    }

    public boolean isPSDEDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQNameDirty();
        }
        return this.psdedqnameDirtyFlag;
    }

    public void resetPSDEDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQName();
            return;
        }
        this.psdedqnameDirtyFlag = false;
        this.psdedqname = null;
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

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
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

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setQuickFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.quickformcodename = string;
        this.quickformcodenameDirtyFlag = true;
    }

    public String getQuickFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickFormCodeName();
        }
        return this.quickformcodename;
    }

    public boolean isQuickFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickFormCodeNameDirty();
        }
        return this.quickformcodenameDirtyFlag;
    }

    public void resetQuickFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickFormCodeName();
            return;
        }
        this.quickformcodenameDirtyFlag = false;
        this.quickformcodename = null;
    }

    public void setQuickPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.quickpsdeformid = string;
        this.quickpsdeformidDirtyFlag = true;
    }

    public String getQuickPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEFormId();
        }
        return this.quickpsdeformid;
    }

    public boolean isQuickPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickPSDEFormIdDirty();
        }
        return this.quickpsdeformidDirtyFlag;
    }

    public void resetQuickPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickPSDEFormId();
            return;
        }
        this.quickpsdeformidDirtyFlag = false;
        this.quickpsdeformid = null;
    }

    public void setQuickPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQuickPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.quickpsdeformname = string;
        this.quickpsdeformnameDirtyFlag = true;
    }

    public String getQuickPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEFormName();
        }
        return this.quickpsdeformname;
    }

    public boolean isQuickPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQuickPSDEFormNameDirty();
        }
        return this.quickpsdeformnameDirtyFlag;
    }

    public void resetQuickPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQuickPSDEFormName();
            return;
        }
        this.quickpsdeformnameDirtyFlag = false;
        this.quickpsdeformname = null;
    }

    public void setTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpslanresid = string;
        this.textpslanresidDirtyFlag = true;
    }

    public String getTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanResId();
        }
        return this.textpslanresid;
    }

    public boolean isTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSLanResIdDirty();
        }
        return this.textpslanresidDirtyFlag;
    }

    public void resetTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSLanResId();
            return;
        }
        this.textpslanresidDirtyFlag = false;
        this.textpslanresid = null;
    }

    public void setTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpslanresname = string;
        this.textpslanresnameDirtyFlag = true;
    }

    public String getTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanResName();
        }
        return this.textpslanresname;
    }

    public boolean isTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSLanResNameDirty();
        }
        return this.textpslanresnameDirtyFlag;
    }

    public void resetTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSLanResName();
            return;
        }
        this.textpslanresnameDirtyFlag = false;
        this.textpslanresname = null;
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

    public void setTooltipInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTooltipInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltipinfo = string;
        this.tooltipinfoDirtyFlag = true;
    }

    public String getTooltipInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTooltipInfo();
        }
        return this.tooltipinfo;
    }

    public boolean isTooltipInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTooltipInfoDirty();
        }
        return this.tooltipinfoDirtyFlag;
    }

    public void resetTooltipInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTooltipInfo();
            return;
        }
        this.tooltipinfoDirtyFlag = false;
        this.tooltipinfo = null;
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

    public void setUtilFormCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilFormCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilformcodename = string;
        this.utilformcodenameDirtyFlag = true;
    }

    public String getUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilFormCodeName();
        }
        return this.utilformcodename;
    }

    public boolean isUtilFormCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilFormCodeNameDirty();
        }
        return this.utilformcodenameDirtyFlag;
    }

    public void resetUtilFormCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilFormCodeName();
            return;
        }
        this.utilformcodenameDirtyFlag = false;
        this.utilformcodename = null;
    }

    public void setUtilPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdeformid = string;
        this.utilpsdeformidDirtyFlag = true;
    }

    public String getUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEFormId();
        }
        return this.utilpsdeformid;
    }

    public boolean isUtilPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDEFormIdDirty();
        }
        return this.utilpsdeformidDirtyFlag;
    }

    public void resetUtilPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEFormId();
            return;
        }
        this.utilpsdeformidDirtyFlag = false;
        this.utilpsdeformid = null;
    }

    public void setUtilPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilpsdeformname = string;
        this.utilpsdeformnameDirtyFlag = true;
    }

    public String getUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEFormName();
        }
        return this.utilpsdeformname;
    }

    public boolean isUtilPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilPSDEFormNameDirty();
        }
        return this.utilpsdeformnameDirtyFlag;
    }

    public void resetUtilPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilPSDEFormName();
            return;
        }
        this.utilpsdeformnameDirtyFlag = false;
        this.utilpsdeformname = null;
    }

    public void setViewActions(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewActions(n);
            return;
        }
        this.viewactions = n;
        this.viewactionsDirtyFlag = true;
    }

    public Integer getViewActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewActions();
        }
        return this.viewactions;
    }

    public boolean isViewActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewActionsDirty();
        }
        return this.viewactionsDirtyFlag;
    }

    public void resetViewActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewActions();
            return;
        }
        this.viewactionsDirtyFlag = false;
        this.viewactions = null;
    }

    public void setWFStateMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStateMode(n);
            return;
        }
        this.wfstatemode = n;
        this.wfstatemodeDirtyFlag = true;
    }

    public Integer getWFStateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStateMode();
        }
        return this.wfstatemode;
    }

    public boolean isWFStateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStateModeDirty();
        }
        return this.wfstatemodeDirtyFlag;
    }

    public void resetWFStateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStateMode();
            return;
        }
        this.wfstatemodeDirtyFlag = false;
        this.wfstatemode = null;
    }

    protected void onReset() {
        PSDEMainStateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMainStateBase pSDEMainStateBase) {
        pSDEMainStateBase.resetAllowMode();
        pSDEMainStateBase.resetCodeName();
        pSDEMainStateBase.resetColor();
        pSDEMainStateBase.resetCreateDate();
        pSDEMainStateBase.resetCreateMan();
        pSDEMainStateBase.resetDEActionDenyMsg();
        pSDEMainStateBase.resetDEActionDMPSLanResId();
        pSDEMainStateBase.resetDEActionDMPSLanResName();
        pSDEMainStateBase.resetDefaultMode();
        pSDEMainStateBase.resetDEOPPrivDenyMsg();
        pSDEMainStateBase.resetDEOPPrivDMPSLanResId();
        pSDEMainStateBase.resetDEOPPrivDMPSLanResName();
        pSDEMainStateBase.resetEditViewType();
        pSDEMainStateBase.resetEnableViewActions();
        pSDEMainStateBase.resetEnterPSDEActionId();
        pSDEMainStateBase.resetEnterPSDEActionName();
        pSDEMainStateBase.resetEnterStateMode();
        pSDEMainStateBase.resetFieldAllowMode();
        pSDEMainStateBase.resetFormCodeName();
        pSDEMainStateBase.resetLockFlag();
        pSDEMainStateBase.resetMemo();
        pSDEMainStateBase.resetMobEditViewType();
        pSDEMainStateBase.resetMobFormCodeName();
        pSDEMainStateBase.resetMobPSDEFormId();
        pSDEMainStateBase.resetMobPSDEFormName();
        pSDEMainStateBase.resetMobQuickFormCodeName();
        pSDEMainStateBase.resetMobQuickPSDEFormId();
        pSDEMainStateBase.resetMobQuickPSDEFormName();
        pSDEMainStateBase.resetMobUtilFormCodeName();
        pSDEMainStateBase.resetMobUtilPSDEFormId();
        pSDEMainStateBase.resetMobUtilPSDEFormName();
        pSDEMainStateBase.resetMSTag();
        pSDEMainStateBase.resetMSValue();
        pSDEMainStateBase.resetMSValue2();
        pSDEMainStateBase.resetMSValue2Text();
        pSDEMainStateBase.resetMSValue3();
        pSDEMainStateBase.resetMSValue3Text();
        pSDEMainStateBase.resetMSValueText();
        pSDEMainStateBase.resetOPPrivAllowMode();
        pSDEMainStateBase.resetOrderValue();
        pSDEMainStateBase.resetPSDEDQId();
        pSDEMainStateBase.resetPSDEDQName();
        pSDEMainStateBase.resetPSDEFormId();
        pSDEMainStateBase.resetPSDEFormName();
        pSDEMainStateBase.resetPSDEId();
        pSDEMainStateBase.resetPSDEMainStateId();
        pSDEMainStateBase.resetPSDEMainStateName();
        pSDEMainStateBase.resetPSDEName();
        pSDEMainStateBase.resetPSSysCssId();
        pSDEMainStateBase.resetPSSysCssName();
        pSDEMainStateBase.resetPSSysDynaModelId();
        pSDEMainStateBase.resetPSSysDynaModelName();
        pSDEMainStateBase.resetPSSysImageId();
        pSDEMainStateBase.resetPSSysImageName();
        pSDEMainStateBase.resetQuickFormCodeName();
        pSDEMainStateBase.resetQuickPSDEFormId();
        pSDEMainStateBase.resetQuickPSDEFormName();
        pSDEMainStateBase.resetTextPSLanResId();
        pSDEMainStateBase.resetTextPSLanResName();
        pSDEMainStateBase.resetTipPSLanResId();
        pSDEMainStateBase.resetTipPSLanResName();
        pSDEMainStateBase.resetToDoTask();
        pSDEMainStateBase.resetTooltipInfo();
        pSDEMainStateBase.resetUpdateDate();
        pSDEMainStateBase.resetUpdateMan();
        pSDEMainStateBase.resetUserCat();
        pSDEMainStateBase.resetUserTag();
        pSDEMainStateBase.resetUserTag2();
        pSDEMainStateBase.resetUserTag3();
        pSDEMainStateBase.resetUserTag4();
        pSDEMainStateBase.resetUtilFormCodeName();
        pSDEMainStateBase.resetUtilPSDEFormId();
        pSDEMainStateBase.resetUtilPSDEFormName();
        pSDEMainStateBase.resetViewActions();
        pSDEMainStateBase.resetWFStateMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowModeDirty()) {
            hashMap.put(FIELD_ALLOWMODE, this.getAllowMode());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEActionDenyMsgDirty()) {
            hashMap.put(FIELD_DEACTIONDENYMSG, this.getDEActionDenyMsg());
        }
        if (!bl || this.isDEActionDMPSLanResIdDirty()) {
            hashMap.put(FIELD_DEACTIONDMPSLANRESID, this.getDEActionDMPSLanResId());
        }
        if (!bl || this.isDEActionDMPSLanResNameDirty()) {
            hashMap.put(FIELD_DEACTIONDMPSLANRESNAME, this.getDEActionDMPSLanResName());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isDEOPPrivDenyMsgDirty()) {
            hashMap.put(FIELD_DEOPPRIVDENYMSG, this.getDEOPPrivDenyMsg());
        }
        if (!bl || this.isDEOPPrivDMPSLanResIdDirty()) {
            hashMap.put(FIELD_DEOPPRIVDMPSLANRESID, this.getDEOPPrivDMPSLanResId());
        }
        if (!bl || this.isDEOPPrivDMPSLanResNameDirty()) {
            hashMap.put(FIELD_DEOPPRIVDMPSLANRESNAME, this.getDEOPPrivDMPSLanResName());
        }
        if (!bl || this.isEditViewTypeDirty()) {
            hashMap.put(FIELD_EDITVIEWTYPE, this.getEditViewType());
        }
        if (!bl || this.isEnableViewActionsDirty()) {
            hashMap.put(FIELD_ENABLEVIEWACTIONS, this.getEnableViewActions());
        }
        if (!bl || this.isEnterPSDEActionIdDirty()) {
            hashMap.put(FIELD_ENTERPSDEACTIONID, this.getEnterPSDEActionId());
        }
        if (!bl || this.isEnterPSDEActionNameDirty()) {
            hashMap.put(FIELD_ENTERPSDEACTIONNAME, this.getEnterPSDEActionName());
        }
        if (!bl || this.isEnterStateModeDirty()) {
            hashMap.put(FIELD_ENTERSTATEMODE, this.getEnterStateMode());
        }
        if (!bl || this.isFieldAllowModeDirty()) {
            hashMap.put(FIELD_FIELDALLOWMODE, this.getFieldAllowMode());
        }
        if (!bl || this.isFormCodeNameDirty()) {
            hashMap.put(FIELD_FORMCODENAME, this.getFormCodeName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobEditViewTypeDirty()) {
            hashMap.put(FIELD_MOBEDITVIEWTYPE, this.getMobEditViewType());
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
        if (!bl || this.isMobQuickFormCodeNameDirty()) {
            hashMap.put(FIELD_MOBQUICKFORMCODENAME, this.getMobQuickFormCodeName());
        }
        if (!bl || this.isMobQuickPSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBQUICKPSDEFORMID, this.getMobQuickPSDEFormId());
        }
        if (!bl || this.isMobQuickPSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBQUICKPSDEFORMNAME, this.getMobQuickPSDEFormName());
        }
        if (!bl || this.isMobUtilFormCodeNameDirty()) {
            hashMap.put(FIELD_MOBUTILFORMCODENAME, this.getMobUtilFormCodeName());
        }
        if (!bl || this.isMobUtilPSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBUTILPSDEFORMID, this.getMobUtilPSDEFormId());
        }
        if (!bl || this.isMobUtilPSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBUTILPSDEFORMNAME, this.getMobUtilPSDEFormName());
        }
        if (!bl || this.isMSTagDirty()) {
            hashMap.put(FIELD_MSTAG, this.getMSTag());
        }
        if (!bl || this.isMSValueDirty()) {
            hashMap.put(FIELD_MSVALUE, this.getMSValue());
        }
        if (!bl || this.isMSValue2Dirty()) {
            hashMap.put(FIELD_MSVALUE2, this.getMSValue2());
        }
        if (!bl || this.isMSValue2TextDirty()) {
            hashMap.put(FIELD_MSVALUE2TEXT, this.getMSValue2Text());
        }
        if (!bl || this.isMSValue3Dirty()) {
            hashMap.put(FIELD_MSVALUE3, this.getMSValue3());
        }
        if (!bl || this.isMSValue3TextDirty()) {
            hashMap.put(FIELD_MSVALUE3TEXT, this.getMSValue3Text());
        }
        if (!bl || this.isMSValueTextDirty()) {
            hashMap.put(FIELD_MSVALUETEXT, this.getMSValueText());
        }
        if (!bl || this.isOPPrivAllowModeDirty()) {
            hashMap.put(FIELD_OPPRIVALLOWMODE, this.getOPPrivAllowMode());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
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
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isQuickFormCodeNameDirty()) {
            hashMap.put(FIELD_QUICKFORMCODENAME, this.getQuickFormCodeName());
        }
        if (!bl || this.isQuickPSDEFormIdDirty()) {
            hashMap.put(FIELD_QUICKPSDEFORMID, this.getQuickPSDEFormId());
        }
        if (!bl || this.isQuickPSDEFormNameDirty()) {
            hashMap.put(FIELD_QUICKPSDEFORMNAME, this.getQuickPSDEFormName());
        }
        if (!bl || this.isTextPSLanResIdDirty()) {
            hashMap.put(FIELD_TEXTPSLANRESID, this.getTextPSLanResId());
        }
        if (!bl || this.isTextPSLanResNameDirty()) {
            hashMap.put(FIELD_TEXTPSLANRESNAME, this.getTextPSLanResName());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
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
        if (!bl || this.isUtilFormCodeNameDirty()) {
            hashMap.put(FIELD_UTILFORMCODENAME, this.getUtilFormCodeName());
        }
        if (!bl || this.isUtilPSDEFormIdDirty()) {
            hashMap.put(FIELD_UTILPSDEFORMID, this.getUtilPSDEFormId());
        }
        if (!bl || this.isUtilPSDEFormNameDirty()) {
            hashMap.put(FIELD_UTILPSDEFORMNAME, this.getUtilPSDEFormName());
        }
        if (!bl || this.isViewActionsDirty()) {
            hashMap.put(FIELD_VIEWACTIONS, this.getViewActions());
        }
        if (!bl || this.isWFStateModeDirty()) {
            hashMap.put(FIELD_WFSTATEMODE, this.getWFStateMode());
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
        return PSDEMainStateBase.get(this, n);
    }

    private static Object get(PSDEMainStateBase pSDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMainStateBase.getAllowMode();
            }
            case 1: {
                return pSDEMainStateBase.getCodeName();
            }
            case 2: {
                return pSDEMainStateBase.getColor();
            }
            case 3: {
                return pSDEMainStateBase.getCreateDate();
            }
            case 4: {
                return pSDEMainStateBase.getCreateMan();
            }
            case 5: {
                return pSDEMainStateBase.getDEActionDenyMsg();
            }
            case 6: {
                return pSDEMainStateBase.getDEActionDMPSLanResId();
            }
            case 7: {
                return pSDEMainStateBase.getDEActionDMPSLanResName();
            }
            case 8: {
                return pSDEMainStateBase.getDefaultMode();
            }
            case 9: {
                return pSDEMainStateBase.getDEOPPrivDenyMsg();
            }
            case 10: {
                return pSDEMainStateBase.getDEOPPrivDMPSLanResId();
            }
            case 11: {
                return pSDEMainStateBase.getDEOPPrivDMPSLanResName();
            }
            case 12: {
                return pSDEMainStateBase.getEditViewType();
            }
            case 13: {
                return pSDEMainStateBase.getEnableViewActions();
            }
            case 14: {
                return pSDEMainStateBase.getEnterPSDEActionId();
            }
            case 15: {
                return pSDEMainStateBase.getEnterPSDEActionName();
            }
            case 16: {
                return pSDEMainStateBase.getEnterStateMode();
            }
            case 17: {
                return pSDEMainStateBase.getFieldAllowMode();
            }
            case 18: {
                return pSDEMainStateBase.getFormCodeName();
            }
            case 19: {
                return pSDEMainStateBase.getLockFlag();
            }
            case 20: {
                return pSDEMainStateBase.getMemo();
            }
            case 21: {
                return pSDEMainStateBase.getMobEditViewType();
            }
            case 22: {
                return pSDEMainStateBase.getMobFormCodeName();
            }
            case 23: {
                return pSDEMainStateBase.getMobPSDEFormId();
            }
            case 24: {
                return pSDEMainStateBase.getMobPSDEFormName();
            }
            case 25: {
                return pSDEMainStateBase.getMobQuickFormCodeName();
            }
            case 26: {
                return pSDEMainStateBase.getMobQuickPSDEFormId();
            }
            case 27: {
                return pSDEMainStateBase.getMobQuickPSDEFormName();
            }
            case 28: {
                return pSDEMainStateBase.getMobUtilFormCodeName();
            }
            case 29: {
                return pSDEMainStateBase.getMobUtilPSDEFormId();
            }
            case 30: {
                return pSDEMainStateBase.getMobUtilPSDEFormName();
            }
            case 31: {
                return pSDEMainStateBase.getMSTag();
            }
            case 32: {
                return pSDEMainStateBase.getMSValue();
            }
            case 33: {
                return pSDEMainStateBase.getMSValue2();
            }
            case 34: {
                return pSDEMainStateBase.getMSValue2Text();
            }
            case 35: {
                return pSDEMainStateBase.getMSValue3();
            }
            case 36: {
                return pSDEMainStateBase.getMSValue3Text();
            }
            case 37: {
                return pSDEMainStateBase.getMSValueText();
            }
            case 38: {
                return pSDEMainStateBase.getOPPrivAllowMode();
            }
            case 39: {
                return pSDEMainStateBase.getOrderValue();
            }
            case 40: {
                return pSDEMainStateBase.getPSDEDQId();
            }
            case 41: {
                return pSDEMainStateBase.getPSDEDQName();
            }
            case 42: {
                return pSDEMainStateBase.getPSDEFormId();
            }
            case 43: {
                return pSDEMainStateBase.getPSDEFormName();
            }
            case 44: {
                return pSDEMainStateBase.getPSDEId();
            }
            case 45: {
                return pSDEMainStateBase.getPSDEMainStateId();
            }
            case 46: {
                return pSDEMainStateBase.getPSDEMainStateName();
            }
            case 47: {
                return pSDEMainStateBase.getPSDEName();
            }
            case 48: {
                return pSDEMainStateBase.getPSSysCssId();
            }
            case 49: {
                return pSDEMainStateBase.getPSSysCssName();
            }
            case 50: {
                return pSDEMainStateBase.getPSSysDynaModelId();
            }
            case 51: {
                return pSDEMainStateBase.getPSSysDynaModelName();
            }
            case 52: {
                return pSDEMainStateBase.getPSSysImageId();
            }
            case 53: {
                return pSDEMainStateBase.getPSSysImageName();
            }
            case 54: {
                return pSDEMainStateBase.getQuickFormCodeName();
            }
            case 55: {
                return pSDEMainStateBase.getQuickPSDEFormId();
            }
            case 56: {
                return pSDEMainStateBase.getQuickPSDEFormName();
            }
            case 57: {
                return pSDEMainStateBase.getTextPSLanResId();
            }
            case 58: {
                return pSDEMainStateBase.getTextPSLanResName();
            }
            case 59: {
                return pSDEMainStateBase.getTipPSLanResId();
            }
            case 60: {
                return pSDEMainStateBase.getTipPSLanResName();
            }
            case 61: {
                return pSDEMainStateBase.getToDoTask();
            }
            case 62: {
                return pSDEMainStateBase.getTooltipInfo();
            }
            case 63: {
                return pSDEMainStateBase.getUpdateDate();
            }
            case 64: {
                return pSDEMainStateBase.getUpdateMan();
            }
            case 65: {
                return pSDEMainStateBase.getUserCat();
            }
            case 66: {
                return pSDEMainStateBase.getUserTag();
            }
            case 67: {
                return pSDEMainStateBase.getUserTag2();
            }
            case 68: {
                return pSDEMainStateBase.getUserTag3();
            }
            case 69: {
                return pSDEMainStateBase.getUserTag4();
            }
            case 70: {
                return pSDEMainStateBase.getUtilFormCodeName();
            }
            case 71: {
                return pSDEMainStateBase.getUtilPSDEFormId();
            }
            case 72: {
                return pSDEMainStateBase.getUtilPSDEFormName();
            }
            case 73: {
                return pSDEMainStateBase.getViewActions();
            }
            case 74: {
                return pSDEMainStateBase.getWFStateMode();
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
        PSDEMainStateBase.set(this, n, object);
    }

    private static void set(PSDEMainStateBase pSDEMainStateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMainStateBase.setAllowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEMainStateBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEMainStateBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMainStateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEMainStateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMainStateBase.setDEActionDenyMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEMainStateBase.setDEActionDMPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMainStateBase.setDEActionDMPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMainStateBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEMainStateBase.setDEOPPrivDenyMsg(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMainStateBase.setDEOPPrivDMPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMainStateBase.setDEOPPrivDMPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMainStateBase.setEditViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMainStateBase.setEnableViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEMainStateBase.setEnterPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMainStateBase.setEnterPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEMainStateBase.setEnterStateMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMainStateBase.setFieldAllowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMainStateBase.setFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMainStateBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEMainStateBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEMainStateBase.setMobEditViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEMainStateBase.setMobFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEMainStateBase.setMobPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEMainStateBase.setMobPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEMainStateBase.setMobQuickFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEMainStateBase.setMobQuickPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEMainStateBase.setMobQuickPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEMainStateBase.setMobUtilFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEMainStateBase.setMobUtilPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEMainStateBase.setMobUtilPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEMainStateBase.setMSTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEMainStateBase.setMSValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEMainStateBase.setMSValue2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEMainStateBase.setMSValue2Text(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEMainStateBase.setMSValue3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEMainStateBase.setMSValue3Text(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEMainStateBase.setMSValueText(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEMainStateBase.setOPPrivAllowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEMainStateBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDEMainStateBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEMainStateBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEMainStateBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEMainStateBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEMainStateBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEMainStateBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEMainStateBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEMainStateBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEMainStateBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEMainStateBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEMainStateBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEMainStateBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEMainStateBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEMainStateBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEMainStateBase.setQuickFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEMainStateBase.setQuickPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEMainStateBase.setQuickPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEMainStateBase.setTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEMainStateBase.setTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEMainStateBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEMainStateBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEMainStateBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEMainStateBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEMainStateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 64: {
                pSDEMainStateBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEMainStateBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEMainStateBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEMainStateBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEMainStateBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEMainStateBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEMainStateBase.setUtilFormCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEMainStateBase.setUtilPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEMainStateBase.setUtilPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEMainStateBase.setViewActions(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 74: {
                pSDEMainStateBase.setWFStateMode(DataObject.getIntegerValue((Object)object));
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
        return PSDEMainStateBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMainStateBase pSDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMainStateBase.getAllowMode() == null;
            }
            case 1: {
                return pSDEMainStateBase.getCodeName() == null;
            }
            case 2: {
                return pSDEMainStateBase.getColor() == null;
            }
            case 3: {
                return pSDEMainStateBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEMainStateBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEMainStateBase.getDEActionDenyMsg() == null;
            }
            case 6: {
                return pSDEMainStateBase.getDEActionDMPSLanResId() == null;
            }
            case 7: {
                return pSDEMainStateBase.getDEActionDMPSLanResName() == null;
            }
            case 8: {
                return pSDEMainStateBase.getDefaultMode() == null;
            }
            case 9: {
                return pSDEMainStateBase.getDEOPPrivDenyMsg() == null;
            }
            case 10: {
                return pSDEMainStateBase.getDEOPPrivDMPSLanResId() == null;
            }
            case 11: {
                return pSDEMainStateBase.getDEOPPrivDMPSLanResName() == null;
            }
            case 12: {
                return pSDEMainStateBase.getEditViewType() == null;
            }
            case 13: {
                return pSDEMainStateBase.getEnableViewActions() == null;
            }
            case 14: {
                return pSDEMainStateBase.getEnterPSDEActionId() == null;
            }
            case 15: {
                return pSDEMainStateBase.getEnterPSDEActionName() == null;
            }
            case 16: {
                return pSDEMainStateBase.getEnterStateMode() == null;
            }
            case 17: {
                return pSDEMainStateBase.getFieldAllowMode() == null;
            }
            case 18: {
                return pSDEMainStateBase.getFormCodeName() == null;
            }
            case 19: {
                return pSDEMainStateBase.getLockFlag() == null;
            }
            case 20: {
                return pSDEMainStateBase.getMemo() == null;
            }
            case 21: {
                return pSDEMainStateBase.getMobEditViewType() == null;
            }
            case 22: {
                return pSDEMainStateBase.getMobFormCodeName() == null;
            }
            case 23: {
                return pSDEMainStateBase.getMobPSDEFormId() == null;
            }
            case 24: {
                return pSDEMainStateBase.getMobPSDEFormName() == null;
            }
            case 25: {
                return pSDEMainStateBase.getMobQuickFormCodeName() == null;
            }
            case 26: {
                return pSDEMainStateBase.getMobQuickPSDEFormId() == null;
            }
            case 27: {
                return pSDEMainStateBase.getMobQuickPSDEFormName() == null;
            }
            case 28: {
                return pSDEMainStateBase.getMobUtilFormCodeName() == null;
            }
            case 29: {
                return pSDEMainStateBase.getMobUtilPSDEFormId() == null;
            }
            case 30: {
                return pSDEMainStateBase.getMobUtilPSDEFormName() == null;
            }
            case 31: {
                return pSDEMainStateBase.getMSTag() == null;
            }
            case 32: {
                return pSDEMainStateBase.getMSValue() == null;
            }
            case 33: {
                return pSDEMainStateBase.getMSValue2() == null;
            }
            case 34: {
                return pSDEMainStateBase.getMSValue2Text() == null;
            }
            case 35: {
                return pSDEMainStateBase.getMSValue3() == null;
            }
            case 36: {
                return pSDEMainStateBase.getMSValue3Text() == null;
            }
            case 37: {
                return pSDEMainStateBase.getMSValueText() == null;
            }
            case 38: {
                return pSDEMainStateBase.getOPPrivAllowMode() == null;
            }
            case 39: {
                return pSDEMainStateBase.getOrderValue() == null;
            }
            case 40: {
                return pSDEMainStateBase.getPSDEDQId() == null;
            }
            case 41: {
                return pSDEMainStateBase.getPSDEDQName() == null;
            }
            case 42: {
                return pSDEMainStateBase.getPSDEFormId() == null;
            }
            case 43: {
                return pSDEMainStateBase.getPSDEFormName() == null;
            }
            case 44: {
                return pSDEMainStateBase.getPSDEId() == null;
            }
            case 45: {
                return pSDEMainStateBase.getPSDEMainStateId() == null;
            }
            case 46: {
                return pSDEMainStateBase.getPSDEMainStateName() == null;
            }
            case 47: {
                return pSDEMainStateBase.getPSDEName() == null;
            }
            case 48: {
                return pSDEMainStateBase.getPSSysCssId() == null;
            }
            case 49: {
                return pSDEMainStateBase.getPSSysCssName() == null;
            }
            case 50: {
                return pSDEMainStateBase.getPSSysDynaModelId() == null;
            }
            case 51: {
                return pSDEMainStateBase.getPSSysDynaModelName() == null;
            }
            case 52: {
                return pSDEMainStateBase.getPSSysImageId() == null;
            }
            case 53: {
                return pSDEMainStateBase.getPSSysImageName() == null;
            }
            case 54: {
                return pSDEMainStateBase.getQuickFormCodeName() == null;
            }
            case 55: {
                return pSDEMainStateBase.getQuickPSDEFormId() == null;
            }
            case 56: {
                return pSDEMainStateBase.getQuickPSDEFormName() == null;
            }
            case 57: {
                return pSDEMainStateBase.getTextPSLanResId() == null;
            }
            case 58: {
                return pSDEMainStateBase.getTextPSLanResName() == null;
            }
            case 59: {
                return pSDEMainStateBase.getTipPSLanResId() == null;
            }
            case 60: {
                return pSDEMainStateBase.getTipPSLanResName() == null;
            }
            case 61: {
                return pSDEMainStateBase.getToDoTask() == null;
            }
            case 62: {
                return pSDEMainStateBase.getTooltipInfo() == null;
            }
            case 63: {
                return pSDEMainStateBase.getUpdateDate() == null;
            }
            case 64: {
                return pSDEMainStateBase.getUpdateMan() == null;
            }
            case 65: {
                return pSDEMainStateBase.getUserCat() == null;
            }
            case 66: {
                return pSDEMainStateBase.getUserTag() == null;
            }
            case 67: {
                return pSDEMainStateBase.getUserTag2() == null;
            }
            case 68: {
                return pSDEMainStateBase.getUserTag3() == null;
            }
            case 69: {
                return pSDEMainStateBase.getUserTag4() == null;
            }
            case 70: {
                return pSDEMainStateBase.getUtilFormCodeName() == null;
            }
            case 71: {
                return pSDEMainStateBase.getUtilPSDEFormId() == null;
            }
            case 72: {
                return pSDEMainStateBase.getUtilPSDEFormName() == null;
            }
            case 73: {
                return pSDEMainStateBase.getViewActions() == null;
            }
            case 74: {
                return pSDEMainStateBase.getWFStateMode() == null;
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
        return PSDEMainStateBase.contains(this, n);
    }

    private static boolean contains(PSDEMainStateBase pSDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMainStateBase.isAllowModeDirty();
            }
            case 1: {
                return pSDEMainStateBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEMainStateBase.isColorDirty();
            }
            case 3: {
                return pSDEMainStateBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEMainStateBase.isCreateManDirty();
            }
            case 5: {
                return pSDEMainStateBase.isDEActionDenyMsgDirty();
            }
            case 6: {
                return pSDEMainStateBase.isDEActionDMPSLanResIdDirty();
            }
            case 7: {
                return pSDEMainStateBase.isDEActionDMPSLanResNameDirty();
            }
            case 8: {
                return pSDEMainStateBase.isDefaultModeDirty();
            }
            case 9: {
                return pSDEMainStateBase.isDEOPPrivDenyMsgDirty();
            }
            case 10: {
                return pSDEMainStateBase.isDEOPPrivDMPSLanResIdDirty();
            }
            case 11: {
                return pSDEMainStateBase.isDEOPPrivDMPSLanResNameDirty();
            }
            case 12: {
                return pSDEMainStateBase.isEditViewTypeDirty();
            }
            case 13: {
                return pSDEMainStateBase.isEnableViewActionsDirty();
            }
            case 14: {
                return pSDEMainStateBase.isEnterPSDEActionIdDirty();
            }
            case 15: {
                return pSDEMainStateBase.isEnterPSDEActionNameDirty();
            }
            case 16: {
                return pSDEMainStateBase.isEnterStateModeDirty();
            }
            case 17: {
                return pSDEMainStateBase.isFieldAllowModeDirty();
            }
            case 18: {
                return pSDEMainStateBase.isFormCodeNameDirty();
            }
            case 19: {
                return pSDEMainStateBase.isLockFlagDirty();
            }
            case 20: {
                return pSDEMainStateBase.isMemoDirty();
            }
            case 21: {
                return pSDEMainStateBase.isMobEditViewTypeDirty();
            }
            case 22: {
                return pSDEMainStateBase.isMobFormCodeNameDirty();
            }
            case 23: {
                return pSDEMainStateBase.isMobPSDEFormIdDirty();
            }
            case 24: {
                return pSDEMainStateBase.isMobPSDEFormNameDirty();
            }
            case 25: {
                return pSDEMainStateBase.isMobQuickFormCodeNameDirty();
            }
            case 26: {
                return pSDEMainStateBase.isMobQuickPSDEFormIdDirty();
            }
            case 27: {
                return pSDEMainStateBase.isMobQuickPSDEFormNameDirty();
            }
            case 28: {
                return pSDEMainStateBase.isMobUtilFormCodeNameDirty();
            }
            case 29: {
                return pSDEMainStateBase.isMobUtilPSDEFormIdDirty();
            }
            case 30: {
                return pSDEMainStateBase.isMobUtilPSDEFormNameDirty();
            }
            case 31: {
                return pSDEMainStateBase.isMSTagDirty();
            }
            case 32: {
                return pSDEMainStateBase.isMSValueDirty();
            }
            case 33: {
                return pSDEMainStateBase.isMSValue2Dirty();
            }
            case 34: {
                return pSDEMainStateBase.isMSValue2TextDirty();
            }
            case 35: {
                return pSDEMainStateBase.isMSValue3Dirty();
            }
            case 36: {
                return pSDEMainStateBase.isMSValue3TextDirty();
            }
            case 37: {
                return pSDEMainStateBase.isMSValueTextDirty();
            }
            case 38: {
                return pSDEMainStateBase.isOPPrivAllowModeDirty();
            }
            case 39: {
                return pSDEMainStateBase.isOrderValueDirty();
            }
            case 40: {
                return pSDEMainStateBase.isPSDEDQIdDirty();
            }
            case 41: {
                return pSDEMainStateBase.isPSDEDQNameDirty();
            }
            case 42: {
                return pSDEMainStateBase.isPSDEFormIdDirty();
            }
            case 43: {
                return pSDEMainStateBase.isPSDEFormNameDirty();
            }
            case 44: {
                return pSDEMainStateBase.isPSDEIdDirty();
            }
            case 45: {
                return pSDEMainStateBase.isPSDEMainStateIdDirty();
            }
            case 46: {
                return pSDEMainStateBase.isPSDEMainStateNameDirty();
            }
            case 47: {
                return pSDEMainStateBase.isPSDENameDirty();
            }
            case 48: {
                return pSDEMainStateBase.isPSSysCssIdDirty();
            }
            case 49: {
                return pSDEMainStateBase.isPSSysCssNameDirty();
            }
            case 50: {
                return pSDEMainStateBase.isPSSysDynaModelIdDirty();
            }
            case 51: {
                return pSDEMainStateBase.isPSSysDynaModelNameDirty();
            }
            case 52: {
                return pSDEMainStateBase.isPSSysImageIdDirty();
            }
            case 53: {
                return pSDEMainStateBase.isPSSysImageNameDirty();
            }
            case 54: {
                return pSDEMainStateBase.isQuickFormCodeNameDirty();
            }
            case 55: {
                return pSDEMainStateBase.isQuickPSDEFormIdDirty();
            }
            case 56: {
                return pSDEMainStateBase.isQuickPSDEFormNameDirty();
            }
            case 57: {
                return pSDEMainStateBase.isTextPSLanResIdDirty();
            }
            case 58: {
                return pSDEMainStateBase.isTextPSLanResNameDirty();
            }
            case 59: {
                return pSDEMainStateBase.isTipPSLanResIdDirty();
            }
            case 60: {
                return pSDEMainStateBase.isTipPSLanResNameDirty();
            }
            case 61: {
                return pSDEMainStateBase.isToDoTaskDirty();
            }
            case 62: {
                return pSDEMainStateBase.isTooltipInfoDirty();
            }
            case 63: {
                return pSDEMainStateBase.isUpdateDateDirty();
            }
            case 64: {
                return pSDEMainStateBase.isUpdateManDirty();
            }
            case 65: {
                return pSDEMainStateBase.isUserCatDirty();
            }
            case 66: {
                return pSDEMainStateBase.isUserTagDirty();
            }
            case 67: {
                return pSDEMainStateBase.isUserTag2Dirty();
            }
            case 68: {
                return pSDEMainStateBase.isUserTag3Dirty();
            }
            case 69: {
                return pSDEMainStateBase.isUserTag4Dirty();
            }
            case 70: {
                return pSDEMainStateBase.isUtilFormCodeNameDirty();
            }
            case 71: {
                return pSDEMainStateBase.isUtilPSDEFormIdDirty();
            }
            case 72: {
                return pSDEMainStateBase.isUtilPSDEFormNameDirty();
            }
            case 73: {
                return pSDEMainStateBase.isViewActionsDirty();
            }
            case 74: {
                return pSDEMainStateBase.isWFStateModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMainStateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMainStateBase pSDEMainStateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMainStateBase.getAllowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowmode", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getAllowMode()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getColor()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getDEActionDenyMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deactiondenymsg", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getDEActionDenyMsg()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getDEActionDMPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deactiondmpslanresid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getDEActionDMPSLanResId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getDEActionDMPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deactiondmpslanresname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getDEActionDMPSLanResName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getDEOPPrivDenyMsg() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deopprivdenymsg", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getDEOPPrivDenyMsg()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getDEOPPrivDMPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deopprivdmpslanresid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getDEOPPrivDMPSLanResId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getDEOPPrivDMPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deopprivdmpslanresname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getDEOPPrivDMPSLanResName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getEditViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editviewtype", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getEditViewType()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getEnableViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableviewactions", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getEnableViewActions()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getEnterPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enterpsdeactionid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getEnterPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getEnterPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enterpsdeactionname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getEnterPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getEnterStateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enterstatemode", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getEnterStateMode()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getFieldAllowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldallowmode", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getFieldAllowMode()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formcodename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getFormCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobEditViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobeditviewtype", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobEditViewType()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobformcodename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobFormCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobQuickFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobquickformcodename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobQuickFormCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobQuickPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobquickpsdeformid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobQuickPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobQuickPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobquickpsdeformname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobQuickPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobUtilFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutilformcodename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobUtilFormCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobUtilPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutilpsdeformid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobUtilPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMobUtilPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobutilpsdeformname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMobUtilPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMSTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mstag", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMSTag()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMSValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msvalue", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMSValue()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMSValue2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msvalue2", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMSValue2()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMSValue2Text() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msvalue2text", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMSValue2Text()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMSValue3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msvalue3", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMSValue3()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMSValue3Text() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msvalue3text", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMSValue3Text()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getMSValueText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msvaluetext", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getMSValueText()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getOPPrivAllowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"opprivallowmode", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getOPPrivAllowMode()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getQuickFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickformcodename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getQuickFormCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getQuickPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdeformid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getQuickPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getQuickPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"quickpsdeformname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getQuickPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpslanresid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getTextPSLanResId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpslanresname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getTextPSLanResName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUtilFormCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilformcodename", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUtilFormCodeName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUtilPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdeformid", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUtilPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getUtilPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilpsdeformname", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getUtilPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getViewActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewactions", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getViewActions()), (boolean)false);
        }
        if (bl || pSDEMainStateBase.getWFStateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfstatemode", (Object)PSDEMainStateBase.getJSONValue((Object)pSDEMainStateBase.getWFStateMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMainStateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMainStateBase pSDEMainStateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMainStateBase.getAllowMode() != null) {
            object = pSDEMainStateBase.getAllowMode();
            xmlNode.setAttribute(FIELD_ALLOWMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEMainStateBase.getCodeName() != null) {
            object = pSDEMainStateBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEMainStateBase.getColor() != null) {
            object = pSDEMainStateBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getCreateDate() != null) {
            object = pSDEMainStateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMainStateBase.getCreateMan() != null) {
            object = pSDEMainStateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getDEActionDenyMsg() != null) {
            object = pSDEMainStateBase.getDEActionDenyMsg();
            xmlNode.setAttribute(FIELD_DEACTIONDENYMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getDEActionDMPSLanResId() != null) {
            object = pSDEMainStateBase.getDEActionDMPSLanResId();
            xmlNode.setAttribute(FIELD_DEACTIONDMPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getDEActionDMPSLanResName() != null) {
            object = pSDEMainStateBase.getDEActionDMPSLanResName();
            xmlNode.setAttribute(FIELD_DEACTIONDMPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getDefaultMode() != null) {
            object = pSDEMainStateBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMainStateBase.getDEOPPrivDenyMsg() != null) {
            object = pSDEMainStateBase.getDEOPPrivDenyMsg();
            xmlNode.setAttribute(FIELD_DEOPPRIVDENYMSG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getDEOPPrivDMPSLanResId() != null) {
            object = pSDEMainStateBase.getDEOPPrivDMPSLanResId();
            xmlNode.setAttribute(FIELD_DEOPPRIVDMPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getDEOPPrivDMPSLanResName() != null) {
            object = pSDEMainStateBase.getDEOPPrivDMPSLanResName();
            xmlNode.setAttribute(FIELD_DEOPPRIVDMPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getEditViewType() != null) {
            object = pSDEMainStateBase.getEditViewType();
            xmlNode.setAttribute(FIELD_EDITVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getEnableViewActions() != null) {
            object = pSDEMainStateBase.getEnableViewActions();
            xmlNode.setAttribute(FIELD_ENABLEVIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMainStateBase.getEnterPSDEActionId() != null) {
            object = pSDEMainStateBase.getEnterPSDEActionId();
            xmlNode.setAttribute(FIELD_ENTERPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getEnterPSDEActionName() != null) {
            object = pSDEMainStateBase.getEnterPSDEActionName();
            xmlNode.setAttribute(FIELD_ENTERPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getEnterStateMode() != null) {
            object = pSDEMainStateBase.getEnterStateMode();
            xmlNode.setAttribute(FIELD_ENTERSTATEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getFieldAllowMode() != null) {
            object = pSDEMainStateBase.getFieldAllowMode();
            xmlNode.setAttribute(FIELD_FIELDALLOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getFormCodeName() != null) {
            object = pSDEMainStateBase.getFormCodeName();
            xmlNode.setAttribute(FIELD_FORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getLockFlag() != null) {
            object = pSDEMainStateBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMainStateBase.getMemo() != null) {
            object = pSDEMainStateBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobEditViewType() != null) {
            object = pSDEMainStateBase.getMobEditViewType();
            xmlNode.setAttribute(FIELD_MOBEDITVIEWTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobFormCodeName() != null) {
            object = pSDEMainStateBase.getMobFormCodeName();
            xmlNode.setAttribute(FIELD_MOBFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobPSDEFormId() != null) {
            object = pSDEMainStateBase.getMobPSDEFormId();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobPSDEFormName() != null) {
            object = pSDEMainStateBase.getMobPSDEFormName();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobQuickFormCodeName() != null) {
            object = pSDEMainStateBase.getMobQuickFormCodeName();
            xmlNode.setAttribute(FIELD_MOBQUICKFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobQuickPSDEFormId() != null) {
            object = pSDEMainStateBase.getMobQuickPSDEFormId();
            xmlNode.setAttribute(FIELD_MOBQUICKPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobQuickPSDEFormName() != null) {
            object = pSDEMainStateBase.getMobQuickPSDEFormName();
            xmlNode.setAttribute(FIELD_MOBQUICKPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobUtilFormCodeName() != null) {
            object = pSDEMainStateBase.getMobUtilFormCodeName();
            xmlNode.setAttribute(FIELD_MOBUTILFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobUtilPSDEFormId() != null) {
            object = pSDEMainStateBase.getMobUtilPSDEFormId();
            xmlNode.setAttribute(FIELD_MOBUTILPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMobUtilPSDEFormName() != null) {
            object = pSDEMainStateBase.getMobUtilPSDEFormName();
            xmlNode.setAttribute(FIELD_MOBUTILPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMSTag() != null) {
            object = pSDEMainStateBase.getMSTag();
            xmlNode.setAttribute(FIELD_MSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMSValue() != null) {
            object = pSDEMainStateBase.getMSValue();
            xmlNode.setAttribute(FIELD_MSVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMSValue2() != null) {
            object = pSDEMainStateBase.getMSValue2();
            xmlNode.setAttribute(FIELD_MSVALUE2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMSValue2Text() != null) {
            object = pSDEMainStateBase.getMSValue2Text();
            xmlNode.setAttribute(FIELD_MSVALUE2TEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMSValue3() != null) {
            object = pSDEMainStateBase.getMSValue3();
            xmlNode.setAttribute(FIELD_MSVALUE3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMSValue3Text() != null) {
            object = pSDEMainStateBase.getMSValue3Text();
            xmlNode.setAttribute(FIELD_MSVALUE3TEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getMSValueText() != null) {
            object = pSDEMainStateBase.getMSValueText();
            xmlNode.setAttribute(FIELD_MSVALUETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getOPPrivAllowMode() != null) {
            object = pSDEMainStateBase.getOPPrivAllowMode();
            xmlNode.setAttribute(FIELD_OPPRIVALLOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getOrderValue() != null) {
            object = pSDEMainStateBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMainStateBase.getPSDEDQId() != null) {
            object = pSDEMainStateBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSDEDQName() != null) {
            object = pSDEMainStateBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSDEFormId() != null) {
            object = pSDEMainStateBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSDEFormName() != null) {
            object = pSDEMainStateBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSDEId() != null) {
            object = pSDEMainStateBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSDEMainStateId() != null) {
            object = pSDEMainStateBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSDEMainStateName() != null) {
            object = pSDEMainStateBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSDEName() != null) {
            object = pSDEMainStateBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSSysCssId() != null) {
            object = pSDEMainStateBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSSysCssName() != null) {
            object = pSDEMainStateBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSSysDynaModelId() != null) {
            object = pSDEMainStateBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSSysDynaModelName() != null) {
            object = pSDEMainStateBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSSysImageId() != null) {
            object = pSDEMainStateBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getPSSysImageName() != null) {
            object = pSDEMainStateBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getQuickFormCodeName() != null) {
            object = pSDEMainStateBase.getQuickFormCodeName();
            xmlNode.setAttribute(FIELD_QUICKFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getQuickPSDEFormId() != null) {
            object = pSDEMainStateBase.getQuickPSDEFormId();
            xmlNode.setAttribute(FIELD_QUICKPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getQuickPSDEFormName() != null) {
            object = pSDEMainStateBase.getQuickPSDEFormName();
            xmlNode.setAttribute(FIELD_QUICKPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getTextPSLanResId() != null) {
            object = pSDEMainStateBase.getTextPSLanResId();
            xmlNode.setAttribute(FIELD_TEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getTextPSLanResName() != null) {
            object = pSDEMainStateBase.getTextPSLanResName();
            xmlNode.setAttribute(FIELD_TEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getTipPSLanResId() != null) {
            object = pSDEMainStateBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getTipPSLanResName() != null) {
            object = pSDEMainStateBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getToDoTask() != null) {
            object = pSDEMainStateBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getTooltipInfo() != null) {
            object = pSDEMainStateBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUpdateDate() != null) {
            object = pSDEMainStateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMainStateBase.getUpdateMan() != null) {
            object = pSDEMainStateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUserCat() != null) {
            object = pSDEMainStateBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUserTag() != null) {
            object = pSDEMainStateBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUserTag2() != null) {
            object = pSDEMainStateBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUserTag3() != null) {
            object = pSDEMainStateBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUserTag4() != null) {
            object = pSDEMainStateBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUtilFormCodeName() != null) {
            object = pSDEMainStateBase.getUtilFormCodeName();
            xmlNode.setAttribute(FIELD_UTILFORMCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUtilPSDEFormId() != null) {
            object = pSDEMainStateBase.getUtilPSDEFormId();
            xmlNode.setAttribute(FIELD_UTILPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getUtilPSDEFormName() != null) {
            object = pSDEMainStateBase.getUtilPSDEFormName();
            xmlNode.setAttribute(FIELD_UTILPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMainStateBase.getViewActions() != null) {
            object = pSDEMainStateBase.getViewActions();
            xmlNode.setAttribute(FIELD_VIEWACTIONS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMainStateBase.getWFStateMode() != null) {
            object = pSDEMainStateBase.getWFStateMode();
            xmlNode.setAttribute(FIELD_WFSTATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMainStateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMainStateBase pSDEMainStateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMainStateBase.isAllowModeDirty() && (bl || pSDEMainStateBase.getAllowMode() != null)) {
            iDataObject.set(FIELD_ALLOWMODE, (Object)pSDEMainStateBase.getAllowMode());
        }
        if (pSDEMainStateBase.isCodeNameDirty() && (bl || pSDEMainStateBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEMainStateBase.getCodeName());
        }
        if (pSDEMainStateBase.isColorDirty() && (bl || pSDEMainStateBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSDEMainStateBase.getColor());
        }
        if (pSDEMainStateBase.isCreateDateDirty() && (bl || pSDEMainStateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMainStateBase.getCreateDate());
        }
        if (pSDEMainStateBase.isCreateManDirty() && (bl || pSDEMainStateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMainStateBase.getCreateMan());
        }
        if (pSDEMainStateBase.isDEActionDenyMsgDirty() && (bl || pSDEMainStateBase.getDEActionDenyMsg() != null)) {
            iDataObject.set(FIELD_DEACTIONDENYMSG, (Object)pSDEMainStateBase.getDEActionDenyMsg());
        }
        if (pSDEMainStateBase.isDEActionDMPSLanResIdDirty() && (bl || pSDEMainStateBase.getDEActionDMPSLanResId() != null)) {
            iDataObject.set(FIELD_DEACTIONDMPSLANRESID, (Object)pSDEMainStateBase.getDEActionDMPSLanResId());
        }
        if (pSDEMainStateBase.isDEActionDMPSLanResNameDirty() && (bl || pSDEMainStateBase.getDEActionDMPSLanResName() != null)) {
            iDataObject.set(FIELD_DEACTIONDMPSLANRESNAME, (Object)pSDEMainStateBase.getDEActionDMPSLanResName());
        }
        if (pSDEMainStateBase.isDefaultModeDirty() && (bl || pSDEMainStateBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDEMainStateBase.getDefaultMode());
        }
        if (pSDEMainStateBase.isDEOPPrivDenyMsgDirty() && (bl || pSDEMainStateBase.getDEOPPrivDenyMsg() != null)) {
            iDataObject.set(FIELD_DEOPPRIVDENYMSG, (Object)pSDEMainStateBase.getDEOPPrivDenyMsg());
        }
        if (pSDEMainStateBase.isDEOPPrivDMPSLanResIdDirty() && (bl || pSDEMainStateBase.getDEOPPrivDMPSLanResId() != null)) {
            iDataObject.set(FIELD_DEOPPRIVDMPSLANRESID, (Object)pSDEMainStateBase.getDEOPPrivDMPSLanResId());
        }
        if (pSDEMainStateBase.isDEOPPrivDMPSLanResNameDirty() && (bl || pSDEMainStateBase.getDEOPPrivDMPSLanResName() != null)) {
            iDataObject.set(FIELD_DEOPPRIVDMPSLANRESNAME, (Object)pSDEMainStateBase.getDEOPPrivDMPSLanResName());
        }
        if (pSDEMainStateBase.isEditViewTypeDirty() && (bl || pSDEMainStateBase.getEditViewType() != null)) {
            iDataObject.set(FIELD_EDITVIEWTYPE, (Object)pSDEMainStateBase.getEditViewType());
        }
        if (pSDEMainStateBase.isEnableViewActionsDirty() && (bl || pSDEMainStateBase.getEnableViewActions() != null)) {
            iDataObject.set(FIELD_ENABLEVIEWACTIONS, (Object)pSDEMainStateBase.getEnableViewActions());
        }
        if (pSDEMainStateBase.isEnterPSDEActionIdDirty() && (bl || pSDEMainStateBase.getEnterPSDEActionId() != null)) {
            iDataObject.set(FIELD_ENTERPSDEACTIONID, (Object)pSDEMainStateBase.getEnterPSDEActionId());
        }
        if (pSDEMainStateBase.isEnterPSDEActionNameDirty() && (bl || pSDEMainStateBase.getEnterPSDEActionName() != null)) {
            iDataObject.set(FIELD_ENTERPSDEACTIONNAME, (Object)pSDEMainStateBase.getEnterPSDEActionName());
        }
        if (pSDEMainStateBase.isEnterStateModeDirty() && (bl || pSDEMainStateBase.getEnterStateMode() != null)) {
            iDataObject.set(FIELD_ENTERSTATEMODE, (Object)pSDEMainStateBase.getEnterStateMode());
        }
        if (pSDEMainStateBase.isFieldAllowModeDirty() && (bl || pSDEMainStateBase.getFieldAllowMode() != null)) {
            iDataObject.set(FIELD_FIELDALLOWMODE, (Object)pSDEMainStateBase.getFieldAllowMode());
        }
        if (pSDEMainStateBase.isFormCodeNameDirty() && (bl || pSDEMainStateBase.getFormCodeName() != null)) {
            iDataObject.set(FIELD_FORMCODENAME, (Object)pSDEMainStateBase.getFormCodeName());
        }
        if (pSDEMainStateBase.isLockFlagDirty() && (bl || pSDEMainStateBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEMainStateBase.getLockFlag());
        }
        if (pSDEMainStateBase.isMemoDirty() && (bl || pSDEMainStateBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMainStateBase.getMemo());
        }
        if (pSDEMainStateBase.isMobEditViewTypeDirty() && (bl || pSDEMainStateBase.getMobEditViewType() != null)) {
            iDataObject.set(FIELD_MOBEDITVIEWTYPE, (Object)pSDEMainStateBase.getMobEditViewType());
        }
        if (pSDEMainStateBase.isMobFormCodeNameDirty() && (bl || pSDEMainStateBase.getMobFormCodeName() != null)) {
            iDataObject.set(FIELD_MOBFORMCODENAME, (Object)pSDEMainStateBase.getMobFormCodeName());
        }
        if (pSDEMainStateBase.isMobPSDEFormIdDirty() && (bl || pSDEMainStateBase.getMobPSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMID, (Object)pSDEMainStateBase.getMobPSDEFormId());
        }
        if (pSDEMainStateBase.isMobPSDEFormNameDirty() && (bl || pSDEMainStateBase.getMobPSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMNAME, (Object)pSDEMainStateBase.getMobPSDEFormName());
        }
        if (pSDEMainStateBase.isMobQuickFormCodeNameDirty() && (bl || pSDEMainStateBase.getMobQuickFormCodeName() != null)) {
            iDataObject.set(FIELD_MOBQUICKFORMCODENAME, (Object)pSDEMainStateBase.getMobQuickFormCodeName());
        }
        if (pSDEMainStateBase.isMobQuickPSDEFormIdDirty() && (bl || pSDEMainStateBase.getMobQuickPSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBQUICKPSDEFORMID, (Object)pSDEMainStateBase.getMobQuickPSDEFormId());
        }
        if (pSDEMainStateBase.isMobQuickPSDEFormNameDirty() && (bl || pSDEMainStateBase.getMobQuickPSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBQUICKPSDEFORMNAME, (Object)pSDEMainStateBase.getMobQuickPSDEFormName());
        }
        if (pSDEMainStateBase.isMobUtilFormCodeNameDirty() && (bl || pSDEMainStateBase.getMobUtilFormCodeName() != null)) {
            iDataObject.set(FIELD_MOBUTILFORMCODENAME, (Object)pSDEMainStateBase.getMobUtilFormCodeName());
        }
        if (pSDEMainStateBase.isMobUtilPSDEFormIdDirty() && (bl || pSDEMainStateBase.getMobUtilPSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBUTILPSDEFORMID, (Object)pSDEMainStateBase.getMobUtilPSDEFormId());
        }
        if (pSDEMainStateBase.isMobUtilPSDEFormNameDirty() && (bl || pSDEMainStateBase.getMobUtilPSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBUTILPSDEFORMNAME, (Object)pSDEMainStateBase.getMobUtilPSDEFormName());
        }
        if (pSDEMainStateBase.isMSTagDirty() && (bl || pSDEMainStateBase.getMSTag() != null)) {
            iDataObject.set(FIELD_MSTAG, (Object)pSDEMainStateBase.getMSTag());
        }
        if (pSDEMainStateBase.isMSValueDirty() && (bl || pSDEMainStateBase.getMSValue() != null)) {
            iDataObject.set(FIELD_MSVALUE, (Object)pSDEMainStateBase.getMSValue());
        }
        if (pSDEMainStateBase.isMSValue2Dirty() && (bl || pSDEMainStateBase.getMSValue2() != null)) {
            iDataObject.set(FIELD_MSVALUE2, (Object)pSDEMainStateBase.getMSValue2());
        }
        if (pSDEMainStateBase.isMSValue2TextDirty() && (bl || pSDEMainStateBase.getMSValue2Text() != null)) {
            iDataObject.set(FIELD_MSVALUE2TEXT, (Object)pSDEMainStateBase.getMSValue2Text());
        }
        if (pSDEMainStateBase.isMSValue3Dirty() && (bl || pSDEMainStateBase.getMSValue3() != null)) {
            iDataObject.set(FIELD_MSVALUE3, (Object)pSDEMainStateBase.getMSValue3());
        }
        if (pSDEMainStateBase.isMSValue3TextDirty() && (bl || pSDEMainStateBase.getMSValue3Text() != null)) {
            iDataObject.set(FIELD_MSVALUE3TEXT, (Object)pSDEMainStateBase.getMSValue3Text());
        }
        if (pSDEMainStateBase.isMSValueTextDirty() && (bl || pSDEMainStateBase.getMSValueText() != null)) {
            iDataObject.set(FIELD_MSVALUETEXT, (Object)pSDEMainStateBase.getMSValueText());
        }
        if (pSDEMainStateBase.isOPPrivAllowModeDirty() && (bl || pSDEMainStateBase.getOPPrivAllowMode() != null)) {
            iDataObject.set(FIELD_OPPRIVALLOWMODE, (Object)pSDEMainStateBase.getOPPrivAllowMode());
        }
        if (pSDEMainStateBase.isOrderValueDirty() && (bl || pSDEMainStateBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEMainStateBase.getOrderValue());
        }
        if (pSDEMainStateBase.isPSDEDQIdDirty() && (bl || pSDEMainStateBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEMainStateBase.getPSDEDQId());
        }
        if (pSDEMainStateBase.isPSDEDQNameDirty() && (bl || pSDEMainStateBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEMainStateBase.getPSDEDQName());
        }
        if (pSDEMainStateBase.isPSDEFormIdDirty() && (bl || pSDEMainStateBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEMainStateBase.getPSDEFormId());
        }
        if (pSDEMainStateBase.isPSDEFormNameDirty() && (bl || pSDEMainStateBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEMainStateBase.getPSDEFormName());
        }
        if (pSDEMainStateBase.isPSDEIdDirty() && (bl || pSDEMainStateBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMainStateBase.getPSDEId());
        }
        if (pSDEMainStateBase.isPSDEMainStateIdDirty() && (bl || pSDEMainStateBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSDEMainStateBase.getPSDEMainStateId());
        }
        if (pSDEMainStateBase.isPSDEMainStateNameDirty() && (bl || pSDEMainStateBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSDEMainStateBase.getPSDEMainStateName());
        }
        if (pSDEMainStateBase.isPSDENameDirty() && (bl || pSDEMainStateBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEMainStateBase.getPSDEName());
        }
        if (pSDEMainStateBase.isPSSysCssIdDirty() && (bl || pSDEMainStateBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEMainStateBase.getPSSysCssId());
        }
        if (pSDEMainStateBase.isPSSysCssNameDirty() && (bl || pSDEMainStateBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEMainStateBase.getPSSysCssName());
        }
        if (pSDEMainStateBase.isPSSysDynaModelIdDirty() && (bl || pSDEMainStateBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEMainStateBase.getPSSysDynaModelId());
        }
        if (pSDEMainStateBase.isPSSysDynaModelNameDirty() && (bl || pSDEMainStateBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEMainStateBase.getPSSysDynaModelName());
        }
        if (pSDEMainStateBase.isPSSysImageIdDirty() && (bl || pSDEMainStateBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEMainStateBase.getPSSysImageId());
        }
        if (pSDEMainStateBase.isPSSysImageNameDirty() && (bl || pSDEMainStateBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEMainStateBase.getPSSysImageName());
        }
        if (pSDEMainStateBase.isQuickFormCodeNameDirty() && (bl || pSDEMainStateBase.getQuickFormCodeName() != null)) {
            iDataObject.set(FIELD_QUICKFORMCODENAME, (Object)pSDEMainStateBase.getQuickFormCodeName());
        }
        if (pSDEMainStateBase.isQuickPSDEFormIdDirty() && (bl || pSDEMainStateBase.getQuickPSDEFormId() != null)) {
            iDataObject.set(FIELD_QUICKPSDEFORMID, (Object)pSDEMainStateBase.getQuickPSDEFormId());
        }
        if (pSDEMainStateBase.isQuickPSDEFormNameDirty() && (bl || pSDEMainStateBase.getQuickPSDEFormName() != null)) {
            iDataObject.set(FIELD_QUICKPSDEFORMNAME, (Object)pSDEMainStateBase.getQuickPSDEFormName());
        }
        if (pSDEMainStateBase.isTextPSLanResIdDirty() && (bl || pSDEMainStateBase.getTextPSLanResId() != null)) {
            iDataObject.set(FIELD_TEXTPSLANRESID, (Object)pSDEMainStateBase.getTextPSLanResId());
        }
        if (pSDEMainStateBase.isTextPSLanResNameDirty() && (bl || pSDEMainStateBase.getTextPSLanResName() != null)) {
            iDataObject.set(FIELD_TEXTPSLANRESNAME, (Object)pSDEMainStateBase.getTextPSLanResName());
        }
        if (pSDEMainStateBase.isTipPSLanResIdDirty() && (bl || pSDEMainStateBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDEMainStateBase.getTipPSLanResId());
        }
        if (pSDEMainStateBase.isTipPSLanResNameDirty() && (bl || pSDEMainStateBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDEMainStateBase.getTipPSLanResName());
        }
        if (pSDEMainStateBase.isToDoTaskDirty() && (bl || pSDEMainStateBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEMainStateBase.getToDoTask());
        }
        if (pSDEMainStateBase.isTooltipInfoDirty() && (bl || pSDEMainStateBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDEMainStateBase.getTooltipInfo());
        }
        if (pSDEMainStateBase.isUpdateDateDirty() && (bl || pSDEMainStateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMainStateBase.getUpdateDate());
        }
        if (pSDEMainStateBase.isUpdateManDirty() && (bl || pSDEMainStateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMainStateBase.getUpdateMan());
        }
        if (pSDEMainStateBase.isUserCatDirty() && (bl || pSDEMainStateBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMainStateBase.getUserCat());
        }
        if (pSDEMainStateBase.isUserTagDirty() && (bl || pSDEMainStateBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMainStateBase.getUserTag());
        }
        if (pSDEMainStateBase.isUserTag2Dirty() && (bl || pSDEMainStateBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMainStateBase.getUserTag2());
        }
        if (pSDEMainStateBase.isUserTag3Dirty() && (bl || pSDEMainStateBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMainStateBase.getUserTag3());
        }
        if (pSDEMainStateBase.isUserTag4Dirty() && (bl || pSDEMainStateBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMainStateBase.getUserTag4());
        }
        if (pSDEMainStateBase.isUtilFormCodeNameDirty() && (bl || pSDEMainStateBase.getUtilFormCodeName() != null)) {
            iDataObject.set(FIELD_UTILFORMCODENAME, (Object)pSDEMainStateBase.getUtilFormCodeName());
        }
        if (pSDEMainStateBase.isUtilPSDEFormIdDirty() && (bl || pSDEMainStateBase.getUtilPSDEFormId() != null)) {
            iDataObject.set(FIELD_UTILPSDEFORMID, (Object)pSDEMainStateBase.getUtilPSDEFormId());
        }
        if (pSDEMainStateBase.isUtilPSDEFormNameDirty() && (bl || pSDEMainStateBase.getUtilPSDEFormName() != null)) {
            iDataObject.set(FIELD_UTILPSDEFORMNAME, (Object)pSDEMainStateBase.getUtilPSDEFormName());
        }
        if (pSDEMainStateBase.isViewActionsDirty() && (bl || pSDEMainStateBase.getViewActions() != null)) {
            iDataObject.set(FIELD_VIEWACTIONS, (Object)pSDEMainStateBase.getViewActions());
        }
        if (pSDEMainStateBase.isWFStateModeDirty() && (bl || pSDEMainStateBase.getWFStateMode() != null)) {
            iDataObject.set(FIELD_WFSTATEMODE, (Object)pSDEMainStateBase.getWFStateMode());
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
        return PSDEMainStateBase.remove(this, n);
    }

    private static boolean remove(PSDEMainStateBase pSDEMainStateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMainStateBase.resetAllowMode();
                return true;
            }
            case 1: {
                pSDEMainStateBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEMainStateBase.resetColor();
                return true;
            }
            case 3: {
                pSDEMainStateBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEMainStateBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEMainStateBase.resetDEActionDenyMsg();
                return true;
            }
            case 6: {
                pSDEMainStateBase.resetDEActionDMPSLanResId();
                return true;
            }
            case 7: {
                pSDEMainStateBase.resetDEActionDMPSLanResName();
                return true;
            }
            case 8: {
                pSDEMainStateBase.resetDefaultMode();
                return true;
            }
            case 9: {
                pSDEMainStateBase.resetDEOPPrivDenyMsg();
                return true;
            }
            case 10: {
                pSDEMainStateBase.resetDEOPPrivDMPSLanResId();
                return true;
            }
            case 11: {
                pSDEMainStateBase.resetDEOPPrivDMPSLanResName();
                return true;
            }
            case 12: {
                pSDEMainStateBase.resetEditViewType();
                return true;
            }
            case 13: {
                pSDEMainStateBase.resetEnableViewActions();
                return true;
            }
            case 14: {
                pSDEMainStateBase.resetEnterPSDEActionId();
                return true;
            }
            case 15: {
                pSDEMainStateBase.resetEnterPSDEActionName();
                return true;
            }
            case 16: {
                pSDEMainStateBase.resetEnterStateMode();
                return true;
            }
            case 17: {
                pSDEMainStateBase.resetFieldAllowMode();
                return true;
            }
            case 18: {
                pSDEMainStateBase.resetFormCodeName();
                return true;
            }
            case 19: {
                pSDEMainStateBase.resetLockFlag();
                return true;
            }
            case 20: {
                pSDEMainStateBase.resetMemo();
                return true;
            }
            case 21: {
                pSDEMainStateBase.resetMobEditViewType();
                return true;
            }
            case 22: {
                pSDEMainStateBase.resetMobFormCodeName();
                return true;
            }
            case 23: {
                pSDEMainStateBase.resetMobPSDEFormId();
                return true;
            }
            case 24: {
                pSDEMainStateBase.resetMobPSDEFormName();
                return true;
            }
            case 25: {
                pSDEMainStateBase.resetMobQuickFormCodeName();
                return true;
            }
            case 26: {
                pSDEMainStateBase.resetMobQuickPSDEFormId();
                return true;
            }
            case 27: {
                pSDEMainStateBase.resetMobQuickPSDEFormName();
                return true;
            }
            case 28: {
                pSDEMainStateBase.resetMobUtilFormCodeName();
                return true;
            }
            case 29: {
                pSDEMainStateBase.resetMobUtilPSDEFormId();
                return true;
            }
            case 30: {
                pSDEMainStateBase.resetMobUtilPSDEFormName();
                return true;
            }
            case 31: {
                pSDEMainStateBase.resetMSTag();
                return true;
            }
            case 32: {
                pSDEMainStateBase.resetMSValue();
                return true;
            }
            case 33: {
                pSDEMainStateBase.resetMSValue2();
                return true;
            }
            case 34: {
                pSDEMainStateBase.resetMSValue2Text();
                return true;
            }
            case 35: {
                pSDEMainStateBase.resetMSValue3();
                return true;
            }
            case 36: {
                pSDEMainStateBase.resetMSValue3Text();
                return true;
            }
            case 37: {
                pSDEMainStateBase.resetMSValueText();
                return true;
            }
            case 38: {
                pSDEMainStateBase.resetOPPrivAllowMode();
                return true;
            }
            case 39: {
                pSDEMainStateBase.resetOrderValue();
                return true;
            }
            case 40: {
                pSDEMainStateBase.resetPSDEDQId();
                return true;
            }
            case 41: {
                pSDEMainStateBase.resetPSDEDQName();
                return true;
            }
            case 42: {
                pSDEMainStateBase.resetPSDEFormId();
                return true;
            }
            case 43: {
                pSDEMainStateBase.resetPSDEFormName();
                return true;
            }
            case 44: {
                pSDEMainStateBase.resetPSDEId();
                return true;
            }
            case 45: {
                pSDEMainStateBase.resetPSDEMainStateId();
                return true;
            }
            case 46: {
                pSDEMainStateBase.resetPSDEMainStateName();
                return true;
            }
            case 47: {
                pSDEMainStateBase.resetPSDEName();
                return true;
            }
            case 48: {
                pSDEMainStateBase.resetPSSysCssId();
                return true;
            }
            case 49: {
                pSDEMainStateBase.resetPSSysCssName();
                return true;
            }
            case 50: {
                pSDEMainStateBase.resetPSSysDynaModelId();
                return true;
            }
            case 51: {
                pSDEMainStateBase.resetPSSysDynaModelName();
                return true;
            }
            case 52: {
                pSDEMainStateBase.resetPSSysImageId();
                return true;
            }
            case 53: {
                pSDEMainStateBase.resetPSSysImageName();
                return true;
            }
            case 54: {
                pSDEMainStateBase.resetQuickFormCodeName();
                return true;
            }
            case 55: {
                pSDEMainStateBase.resetQuickPSDEFormId();
                return true;
            }
            case 56: {
                pSDEMainStateBase.resetQuickPSDEFormName();
                return true;
            }
            case 57: {
                pSDEMainStateBase.resetTextPSLanResId();
                return true;
            }
            case 58: {
                pSDEMainStateBase.resetTextPSLanResName();
                return true;
            }
            case 59: {
                pSDEMainStateBase.resetTipPSLanResId();
                return true;
            }
            case 60: {
                pSDEMainStateBase.resetTipPSLanResName();
                return true;
            }
            case 61: {
                pSDEMainStateBase.resetToDoTask();
                return true;
            }
            case 62: {
                pSDEMainStateBase.resetTooltipInfo();
                return true;
            }
            case 63: {
                pSDEMainStateBase.resetUpdateDate();
                return true;
            }
            case 64: {
                pSDEMainStateBase.resetUpdateMan();
                return true;
            }
            case 65: {
                pSDEMainStateBase.resetUserCat();
                return true;
            }
            case 66: {
                pSDEMainStateBase.resetUserTag();
                return true;
            }
            case 67: {
                pSDEMainStateBase.resetUserTag2();
                return true;
            }
            case 68: {
                pSDEMainStateBase.resetUserTag3();
                return true;
            }
            case 69: {
                pSDEMainStateBase.resetUserTag4();
                return true;
            }
            case 70: {
                pSDEMainStateBase.resetUtilFormCodeName();
                return true;
            }
            case 71: {
                pSDEMainStateBase.resetUtilPSDEFormId();
                return true;
            }
            case 72: {
                pSDEMainStateBase.resetUtilPSDEFormName();
                return true;
            }
            case 73: {
                pSDEMainStateBase.resetViewActions();
                return true;
            }
            case 74: {
                pSDEMainStateBase.resetWFStateMode();
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
    public PSDEAction getEnterPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnterPSDEAction();
        }
        if (this.getEnterPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objEnterPSDEActionLock;
        synchronized (n) {
            if (this.enterpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getEnterPSDEActionId(), (Object)this.enterpsdeaction.getPSDEActionId()) != 0L) {
                this.enterpsdeaction = null;
            }
            if (this.enterpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getEnterPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.enterpsdeaction = pSDEAction;
            }
            return this.enterpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getPSDEDQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQ();
        }
        if (this.getPSDEDQId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQLock;
        synchronized (n) {
            if (this.psdedq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQId(), (Object)this.psdedq.getPSDEDataQueryId()) != 0L) {
                this.psdedq = null;
            }
            if (this.psdedq == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDQId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet(pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
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
                pSDEFormService.autoGet(pSDEForm);
                this.mobpsdeform = pSDEForm;
            }
            return this.mobpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobQuickPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobQuickPSDEForm();
        }
        if (this.getMobQuickPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobQuickPSDEFormLock;
        synchronized (n) {
            if (this.mobquickpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobQuickPSDEFormId(), (Object)this.mobquickpsdeform.getPSDEFormId()) != 0L) {
                this.mobquickpsdeform = null;
            }
            if (this.mobquickpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobQuickPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.mobquickpsdeform = pSDEForm;
            }
            return this.mobquickpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobUtilPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobUtilPSDEForm();
        }
        if (this.getMobUtilPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobUtilPSDEFormLock;
        synchronized (n) {
            if (this.mobutilpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobUtilPSDEFormId(), (Object)this.mobutilpsdeform.getPSDEFormId()) != 0L) {
                this.mobutilpsdeform = null;
            }
            if (this.mobutilpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobUtilPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.mobutilpsdeform = pSDEForm;
            }
            return this.mobutilpsdeform;
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
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getQuickPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQuickPSDEForm();
        }
        if (this.getQuickPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objQuickPSDEFormLock;
        synchronized (n) {
            if (this.quickpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getQuickPSDEFormId(), (Object)this.quickpsdeform.getPSDEFormId()) != 0L) {
                this.quickpsdeform = null;
            }
            if (this.quickpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getQuickPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.quickpsdeform = pSDEForm;
            }
            return this.quickpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getUtilPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilPSDEForm();
        }
        if (this.getUtilPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objUtilPSDEFormLock;
        synchronized (n) {
            if (this.utilpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getUtilPSDEFormId(), (Object)this.utilpsdeform.getPSDEFormId()) != 0L) {
                this.utilpsdeform = null;
            }
            if (this.utilpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getUtilPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.utilpsdeform = pSDEForm;
            }
            return this.utilpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getDEActionDMPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEActionDMPSLanRes();
        }
        if (this.getDEActionDMPSLanResId() == null) {
            return null;
        }
        Integer n = this.objDEActionDMPSLanResLock;
        synchronized (n) {
            if (this.deactiondmpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getDEActionDMPSLanResId(), (Object)this.deactiondmpslanres.getPSLanguageResId()) != 0L) {
                this.deactiondmpslanres = null;
            }
            if (this.deactiondmpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getDEActionDMPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.deactiondmpslanres = pSLanguageRes;
            }
            return this.deactiondmpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getDEOPPrivDMPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOPPrivDMPSLanRes();
        }
        if (this.getDEOPPrivDMPSLanResId() == null) {
            return null;
        }
        Integer n = this.objDEOPPrivDMPSLanResLock;
        synchronized (n) {
            if (this.deopprivdmpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getDEOPPrivDMPSLanResId(), (Object)this.deopprivdmpslanres.getPSLanguageResId()) != 0L) {
                this.deopprivdmpslanres = null;
            }
            if (this.deopprivdmpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getDEOPPrivDMPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.deopprivdmpslanres = pSLanguageRes;
            }
            return this.deopprivdmpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanRes();
        }
        if (this.getTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTextPSLanResLock;
        synchronized (n) {
            if (this.textpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSLanResId(), (Object)this.textpslanres.getPSLanguageResId()) != 0L) {
                this.textpslanres = null;
            }
            if (this.textpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.textpslanres = pSLanguageRes;
            }
            return this.textpslanres;
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMainStateRS> getPSDEMainStateRSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateRSs();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        PSDEMainStateRSService pSDEMainStateRSService = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMainStateRSsLock;
        synchronized (n) {
            if (this.psdemainstaterss == null) {
                this.psdemainstaterss = pSDEMainStateService.isTempData(this) ? pSDEMainStateRSService.selectTempByNextPSDEMS(this) : pSDEMainStateRSService.selectByNextPSDEMS(this);
            }
            return this.psdemainstaterss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMSAction> getPSDEMSActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSActions();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMSActionsLock;
        synchronized (n) {
            if (this.psdemsactions == null) {
                this.psdemsactions = pSDEMainStateService.isTempData(this) ? pSDEMSActionService.selectTempByPSDEMS(this) : pSDEMSActionService.selectByPSDEMS(this);
            }
            return this.psdemsactions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMSField> getPSDEMSFields() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSFields();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMSFieldsLock;
        synchronized (n) {
            if (this.psdemsfields == null) {
                this.psdemsfields = pSDEMainStateService.isTempData(this) ? pSDEMSFieldService.selectTempByPSDEMS(this) : pSDEMSFieldService.selectByPSDEMS(this);
            }
            return this.psdemsfields;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMSOPPriv> getPSDEMSOPPrivs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSOPPrivs();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMSOPPrivsLock;
        synchronized (n) {
            if (this.psdemsopprivs == null) {
                this.psdemsopprivs = pSDEMainStateService.isTempData(this) ? pSDEMSOPPrivService.selectTempByPSDEMainState(this) : pSDEMSOPPrivService.selectByPSDEMainState(this);
            }
            return this.psdemsopprivs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDESampleData> getPSDESampleDatas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDatas();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        PSDESampleDataService pSDESampleDataService = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDESampleDatasLock;
        synchronized (n) {
            if (this.psdesampledatas == null) {
                this.psdesampledatas = pSDESampleDataService.selectByPSDEMainState(this);
            }
            return this.psdesampledatas;
        }
    }

    private PSDEMainStateBase getProxyEntity() {
        return this.proxyPSDEMainStateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMainStateBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMainStateBase) {
            this.proxyPSDEMainStateBase = (PSDEMainStateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWMODE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_COLOR, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DEACTIONDENYMSG, 5);
        fieldIndexMap.put(FIELD_DEACTIONDMPSLANRESID, 6);
        fieldIndexMap.put(FIELD_DEACTIONDMPSLANRESNAME, 7);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 8);
        fieldIndexMap.put(FIELD_DEOPPRIVDENYMSG, 9);
        fieldIndexMap.put(FIELD_DEOPPRIVDMPSLANRESID, 10);
        fieldIndexMap.put(FIELD_DEOPPRIVDMPSLANRESNAME, 11);
        fieldIndexMap.put(FIELD_EDITVIEWTYPE, 12);
        fieldIndexMap.put(FIELD_ENABLEVIEWACTIONS, 13);
        fieldIndexMap.put(FIELD_ENTERPSDEACTIONID, 14);
        fieldIndexMap.put(FIELD_ENTERPSDEACTIONNAME, 15);
        fieldIndexMap.put(FIELD_ENTERSTATEMODE, 16);
        fieldIndexMap.put(FIELD_FIELDALLOWMODE, 17);
        fieldIndexMap.put(FIELD_FORMCODENAME, 18);
        fieldIndexMap.put(FIELD_LOCKFLAG, 19);
        fieldIndexMap.put(FIELD_MEMO, 20);
        fieldIndexMap.put(FIELD_MOBEDITVIEWTYPE, 21);
        fieldIndexMap.put(FIELD_MOBFORMCODENAME, 22);
        fieldIndexMap.put(FIELD_MOBPSDEFORMID, 23);
        fieldIndexMap.put(FIELD_MOBPSDEFORMNAME, 24);
        fieldIndexMap.put(FIELD_MOBQUICKFORMCODENAME, 25);
        fieldIndexMap.put(FIELD_MOBQUICKPSDEFORMID, 26);
        fieldIndexMap.put(FIELD_MOBQUICKPSDEFORMNAME, 27);
        fieldIndexMap.put(FIELD_MOBUTILFORMCODENAME, 28);
        fieldIndexMap.put(FIELD_MOBUTILPSDEFORMID, 29);
        fieldIndexMap.put(FIELD_MOBUTILPSDEFORMNAME, 30);
        fieldIndexMap.put(FIELD_MSTAG, 31);
        fieldIndexMap.put(FIELD_MSVALUE, 32);
        fieldIndexMap.put(FIELD_MSVALUE2, 33);
        fieldIndexMap.put(FIELD_MSVALUE2TEXT, 34);
        fieldIndexMap.put(FIELD_MSVALUE3, 35);
        fieldIndexMap.put(FIELD_MSVALUE3TEXT, 36);
        fieldIndexMap.put(FIELD_MSVALUETEXT, 37);
        fieldIndexMap.put(FIELD_OPPRIVALLOWMODE, 38);
        fieldIndexMap.put(FIELD_ORDERVALUE, 39);
        fieldIndexMap.put(FIELD_PSDEDQID, 40);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 41);
        fieldIndexMap.put(FIELD_PSDEFORMID, 42);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 43);
        fieldIndexMap.put(FIELD_PSDEID, 44);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 45);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 46);
        fieldIndexMap.put(FIELD_PSDENAME, 47);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 48);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 49);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 50);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 51);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 52);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 53);
        fieldIndexMap.put(FIELD_QUICKFORMCODENAME, 54);
        fieldIndexMap.put(FIELD_QUICKPSDEFORMID, 55);
        fieldIndexMap.put(FIELD_QUICKPSDEFORMNAME, 56);
        fieldIndexMap.put(FIELD_TEXTPSLANRESID, 57);
        fieldIndexMap.put(FIELD_TEXTPSLANRESNAME, 58);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 59);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 60);
        fieldIndexMap.put(FIELD_TODOTASK, 61);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 62);
        fieldIndexMap.put(FIELD_UPDATEDATE, 63);
        fieldIndexMap.put(FIELD_UPDATEMAN, 64);
        fieldIndexMap.put(FIELD_USERCAT, 65);
        fieldIndexMap.put(FIELD_USERTAG, 66);
        fieldIndexMap.put(FIELD_USERTAG2, 67);
        fieldIndexMap.put(FIELD_USERTAG3, 68);
        fieldIndexMap.put(FIELD_USERTAG4, 69);
        fieldIndexMap.put(FIELD_UTILFORMCODENAME, 70);
        fieldIndexMap.put(FIELD_UTILPSDEFORMID, 71);
        fieldIndexMap.put(FIELD_UTILPSDEFORMNAME, 72);
        fieldIndexMap.put(FIELD_VIEWACTIONS, 73);
        fieldIndexMap.put(FIELD_WFSTATEMODE, 74);
    }
}

