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
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFSFItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFSFItemBase.class);
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DSTPSDEFID = "DSTPSDEFID";
    public static final String FIELD_DSTPSDEFSFITEMID = "DSTPSDEFSFITEMID";
    public static final String FIELD_DSTPSDEFSFITEMNAME = "DSTPSDEFSFITEMNAME";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORTYPENAME = "EDITORTYPENAME";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_JSONFORMAT = "JSONFORMAT";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_O2MPSDERID = "O2MPSDERID";
    public static final String FIELD_O2OPSDERID = "O2OPSDERID";
    public static final String FIELD_PHPSLANRESID = "PHPSLANRESID";
    public static final String FIELD_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String FIELD_PLACEHOLDER = "PLACEHOLDER";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String FIELD_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String FIELD_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String FIELD_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String FIELD_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_REFADPSDELOGICID = "REFADPSDELOGICID";
    public static final String FIELD_REFADPSDELOGICNAME = "REFADPSDELOGICNAME";
    public static final String FIELD_REFMOBMPICKUPPSDEVIEWID = "REFMOBMPICKUPPSDEVIEWID";
    public static final String FIELD_REFMOBMPICKUPPSDEVIEWNAME = "REFMOBMPICKUPPSDEVIEWNAME";
    public static final String FIELD_REFMOBPICKUPPSDEVIEWID = "REFMOBPICKUPPSDEVIEWID";
    public static final String FIELD_REFMOBPICKUPPSDEVIEWNAME = "REFMOBPICKUPPSDEVIEWNAME";
    public static final String FIELD_REFMPICKUPPSDEVIEWID = "REFMPICKUPPSDEVIEWID";
    public static final String FIELD_REFMPICKUPPSDEVIEWNAME = "REFMPICKUPPSDEVIEWNAME";
    public static final String FIELD_REFPICKUPPSDEVIEWID = "REFPICKUPPSDEVIEWID";
    public static final String FIELD_REFPICKUPPSDEVIEWNAME = "REFPICKUPPSDEVIEWNAME";
    public static final String FIELD_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String FIELD_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String FIELD_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String FIELD_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_REFPSDERID = "REFPSDERID";
    public static final String FIELD_REFPSDERNAME = "REFPSDERNAME";
    public static final String FIELD_SEARCHMODE = "SEARCHMODE";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_VALUESEPERATOR = "VALUESEPERATOR";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_ARRAYFLAG = 0;
    private static final int INDEX_CAPPSLANRESID = 1;
    private static final int INDEX_CAPPSLANRESNAME = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DEFAULTFLAG = 7;
    private static final int INDEX_DSTPSDEFID = 8;
    private static final int INDEX_DSTPSDEFSFITEMID = 9;
    private static final int INDEX_DSTPSDEFSFITEMNAME = 10;
    private static final int INDEX_DSTPSDEID = 11;
    private static final int INDEX_EDITORTYPE = 12;
    private static final int INDEX_EDITORTYPENAME = 13;
    private static final int INDEX_EXTENDMODE = 14;
    private static final int INDEX_HEIGHT = 15;
    private static final int INDEX_ITEMTAG = 16;
    private static final int INDEX_ITEMTAG2 = 17;
    private static final int INDEX_JSONFORMAT = 18;
    private static final int INDEX_LOCKFLAG = 19;
    private static final int INDEX_LOGICNAME = 20;
    private static final int INDEX_MEMO = 21;
    private static final int INDEX_O2MPSDERID = 22;
    private static final int INDEX_O2OPSDERID = 23;
    private static final int INDEX_PHPSLANRESID = 24;
    private static final int INDEX_PHPSLANRESNAME = 25;
    private static final int INDEX_PLACEHOLDER = 26;
    private static final int INDEX_PSCODELISTID = 27;
    private static final int INDEX_PSCODELISTNAME = 28;
    private static final int INDEX_PSDBVALUEOPID = 29;
    private static final int INDEX_PSDBVALUEOPNAME = 30;
    private static final int INDEX_PSDEFID = 31;
    private static final int INDEX_PSDEFNAME = 32;
    private static final int INDEX_PSDEFSFITEMID = 33;
    private static final int INDEX_PSDEFSFITEMNAME = 34;
    private static final int INDEX_PSDEFVALUERULEID = 35;
    private static final int INDEX_PSDEFVALUERULENAME = 36;
    private static final int INDEX_PSDEID = 37;
    private static final int INDEX_PSDENAME = 38;
    private static final int INDEX_PSSYSDBVFID = 39;
    private static final int INDEX_PSSYSDBVFNAME = 40;
    private static final int INDEX_PSSYSEDITORSTYLEID = 41;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 42;
    private static final int INDEX_PSSYSIMAGEID = 43;
    private static final int INDEX_PSSYSIMAGENAME = 44;
    private static final int INDEX_PSSYSSFPLUGINID = 45;
    private static final int INDEX_PSSYSSFPLUGINNAME = 46;
    private static final int INDEX_PSSYSTRANSLATORID = 47;
    private static final int INDEX_PSSYSTRANSLATORNAME = 48;
    private static final int INDEX_PSSYSVALUERULEID = 49;
    private static final int INDEX_PSSYSVALUERULENAME = 50;
    private static final int INDEX_REFADPSDELOGICID = 51;
    private static final int INDEX_REFADPSDELOGICNAME = 52;
    private static final int INDEX_REFMOBMPICKUPPSDEVIEWID = 53;
    private static final int INDEX_REFMOBMPICKUPPSDEVIEWNAME = 54;
    private static final int INDEX_REFMOBPICKUPPSDEVIEWID = 55;
    private static final int INDEX_REFMOBPICKUPPSDEVIEWNAME = 56;
    private static final int INDEX_REFMPICKUPPSDEVIEWID = 57;
    private static final int INDEX_REFMPICKUPPSDEVIEWNAME = 58;
    private static final int INDEX_REFPICKUPPSDEVIEWID = 59;
    private static final int INDEX_REFPICKUPPSDEVIEWNAME = 60;
    private static final int INDEX_REFPSDEACMODEID = 61;
    private static final int INDEX_REFPSDEACMODENAME = 62;
    private static final int INDEX_REFPSDEDATASETID = 63;
    private static final int INDEX_REFPSDEDATASETNAME = 64;
    private static final int INDEX_REFPSDEID = 65;
    private static final int INDEX_REFPSDENAME = 66;
    private static final int INDEX_REFPSDERID = 67;
    private static final int INDEX_REFPSDERNAME = 68;
    private static final int INDEX_SEARCHMODE = 69;
    private static final int INDEX_SERVICECODENAME = 70;
    private static final int INDEX_UPDATEDATE = 71;
    private static final int INDEX_UPDATEMAN = 72;
    private static final int INDEX_USERCAT = 73;
    private static final int INDEX_USERPARAMS = 74;
    private static final int INDEX_USERTAG = 75;
    private static final int INDEX_USERTAG2 = 76;
    private static final int INDEX_USERTAG3 = 77;
    private static final int INDEX_USERTAG4 = 78;
    private static final int INDEX_VALUEFORMAT = 79;
    private static final int INDEX_VALUESEPERATOR = 80;
    private static final int INDEX_WIDTH = 81;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFSFItemBase proxyPSDEFSFItemBase = null;
    private boolean arrayflagDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dstpsdefidDirtyFlag = false;
    private boolean dstpsdefsfitemidDirtyFlag = false;
    private boolean dstpsdefsfitemnameDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editortypenameDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean jsonformatDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean o2mpsderidDirtyFlag = false;
    private boolean o2opsderidDirtyFlag = false;
    private boolean phpslanresidDirtyFlag = false;
    private boolean phpslanresnameDirtyFlag = false;
    private boolean placeholderDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdefsfitemidDirtyFlag = false;
    private boolean psdefsfitemnameDirtyFlag = false;
    private boolean psdefvalueruleidDirtyFlag = false;
    private boolean psdefvaluerulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysdbvfidDirtyFlag = false;
    private boolean pssysdbvfnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean refadpsdelogicidDirtyFlag = false;
    private boolean refadpsdelogicnameDirtyFlag = false;
    private boolean refmobmpickuppsdeviewidDirtyFlag = false;
    private boolean refmobmpickuppsdeviewnameDirtyFlag = false;
    private boolean refmobpickuppsdeviewidDirtyFlag = false;
    private boolean refmobpickuppsdeviewnameDirtyFlag = false;
    private boolean refmpickuppsdeviewidDirtyFlag = false;
    private boolean refmpickuppsdeviewnameDirtyFlag = false;
    private boolean refpickuppsdeviewidDirtyFlag = false;
    private boolean refpickuppsdeviewnameDirtyFlag = false;
    private boolean refpsdeacmodeidDirtyFlag = false;
    private boolean refpsdeacmodenameDirtyFlag = false;
    private boolean refpsdedatasetidDirtyFlag = false;
    private boolean refpsdedatasetnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean refpsderidDirtyFlag = false;
    private boolean refpsdernameDirtyFlag = false;
    private boolean searchmodeDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean valueseperatorDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dstpsdefid")
    private String dstpsdefid;
    @Column(name="dstpsdefsfitemid")
    private String dstpsdefsfitemid;
    @Column(name="dstpsdefsfitemname")
    private String dstpsdefsfitemname;
    @Column(name="dstpsdeid")
    private String dstpsdeid;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editortypename")
    private String editortypename;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="height")
    private Integer height;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="jsonformat")
    private String jsonformat;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="o2mpsderid")
    private String o2mpsderid;
    @Column(name="o2opsderid")
    private String o2opsderid;
    @Column(name="phpslanresid")
    private String phpslanresid;
    @Column(name="phpslanresname")
    private String phpslanresname;
    @Column(name="placeholder")
    private String placeholder;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdefsfitemid")
    private String psdefsfitemid;
    @Column(name="psdefsfitemname")
    private String psdefsfitemname;
    @Column(name="psdefvalueruleid")
    private String psdefvalueruleid;
    @Column(name="psdefvaluerulename")
    private String psdefvaluerulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysdbvfid")
    private String pssysdbvfid;
    @Column(name="pssysdbvfname")
    private String pssysdbvfname;
    @Column(name="pssyseditorstyleid")
    private String pssyseditorstyleid;
    @Column(name="pssyseditorstylename")
    private String pssyseditorstylename;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
    @Column(name="refadpsdelogicid")
    private String refadpsdelogicid;
    @Column(name="refadpsdelogicname")
    private String refadpsdelogicname;
    @Column(name="refmobmpickuppsdeviewid")
    private String refmobmpickuppsdeviewid;
    @Column(name="refmobmpickuppsdeviewname")
    private String refmobmpickuppsdeviewname;
    @Column(name="refmobpickuppsdeviewid")
    private String refmobpickuppsdeviewid;
    @Column(name="refmobpickuppsdeviewname")
    private String refmobpickuppsdeviewname;
    @Column(name="refmpickuppsdeviewid")
    private String refmpickuppsdeviewid;
    @Column(name="refmpickuppsdeviewname")
    private String refmpickuppsdeviewname;
    @Column(name="refpickuppsdeviewid")
    private String refpickuppsdeviewid;
    @Column(name="refpickuppsdeviewname")
    private String refpickuppsdeviewname;
    @Column(name="refpsdeacmodeid")
    private String refpsdeacmodeid;
    @Column(name="refpsdeacmodename")
    private String refpsdeacmodename;
    @Column(name="refpsdedatasetid")
    private String refpsdedatasetid;
    @Column(name="refpsdedatasetname")
    private String refpsdedatasetname;
    @Column(name="refpsdeid")
    private String refpsdeid;
    @Column(name="refpsdename")
    private String refpsdename;
    @Column(name="refpsderid")
    private String refpsderid;
    @Column(name="refpsdername")
    private String refpsdername;
    @Column(name="searchmode")
    private String searchmode;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="valueseperator")
    private String valueseperator;
    @Column(name="width")
    private Integer width;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objPSDBValueOPLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objRefPSDEACModeLock = new Integer(1);
    private PSDEACMode refpsdeacmode = null;
    private Integer objRefPSDEDataSetLock = new Integer(1);
    private PSDEDataSet refpsdedataset = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objDstPSDEFSFItemLock = new Integer(1);
    private PSDEFSFItem dstpsdefsfitem = null;
    private Integer objPSDEFValueRuleLock = new Integer(1);
    private PSDEFValueRule psdefvaluerule = null;
    private Integer objRefADPSDELogicLock = new Integer(1);
    private PSDELogic refadpsdelogic = null;
    private Integer objRefPSDERLock = new Integer(1);
    private PSDER refpsder = null;
    private Integer objRefMobMPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase refmobmpickuppsdeview = null;
    private Integer objRefMobPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase refmobpickuppsdeview = null;
    private Integer objRefMPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase refmpickuppsdeview = null;
    private Integer objRefPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase refpickuppsdeview = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPHPSLanResLock = new Integer(1);
    private PSLanguageRes phpslanres = null;
    private Integer objPSSysDBVFLock = new Integer(1);
    private PSSysDBVF pssysdbvf = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;

    public void setArrayFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArrayFlag(n);
            return;
        }
        this.arrayflag = n;
        this.arrayflagDirtyFlag = true;
    }

    public Integer getArrayFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArrayFlag();
        }
        return this.arrayflag;
    }

    public boolean isArrayFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArrayFlagDirty();
        }
        return this.arrayflagDirtyFlag;
    }

    public void resetArrayFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArrayFlag();
            return;
        }
        this.arrayflagDirtyFlag = false;
        this.arrayflag = null;
    }

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDstPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefid = string;
        this.dstpsdefidDirtyFlag = true;
    }

    public String getDstPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFId();
        }
        return this.dstpsdefid;
    }

    public boolean isDstPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFIdDirty();
        }
        return this.dstpsdefidDirtyFlag;
    }

    public void resetDstPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFId();
            return;
        }
        this.dstpsdefidDirtyFlag = false;
        this.dstpsdefid = null;
    }

    public void setDstPSDEFSFItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFSFItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefsfitemid = string;
        this.dstpsdefsfitemidDirtyFlag = true;
    }

    public String getDstPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFSFItemId();
        }
        return this.dstpsdefsfitemid;
    }

    public boolean isDstPSDEFSFItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFSFItemIdDirty();
        }
        return this.dstpsdefsfitemidDirtyFlag;
    }

    public void resetDstPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFSFItemId();
            return;
        }
        this.dstpsdefsfitemidDirtyFlag = false;
        this.dstpsdefsfitemid = null;
    }

    public void setDstPSDEFSFItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFSFItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefsfitemname = string;
        this.dstpsdefsfitemnameDirtyFlag = true;
    }

    public String getDstPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFSFItemName();
        }
        return this.dstpsdefsfitemname;
    }

    public boolean isDstPSDEFSFItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFSFItemNameDirty();
        }
        return this.dstpsdefsfitemnameDirtyFlag;
    }

    public void resetDstPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFSFItemName();
            return;
        }
        this.dstpsdefsfitemnameDirtyFlag = false;
        this.dstpsdefsfitemname = null;
    }

    public void setDstPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeid = string;
        this.dstpsdeidDirtyFlag = true;
    }

    public String getDstPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEId();
        }
        return this.dstpsdeid;
    }

    public boolean isDstPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEIdDirty();
        }
        return this.dstpsdeidDirtyFlag;
    }

    public void resetDstPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEId();
            return;
        }
        this.dstpsdeidDirtyFlag = false;
        this.dstpsdeid = null;
    }

    public void setEditorType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editortype = string;
        this.editortypeDirtyFlag = true;
    }

    public String getEditorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorType();
        }
        return this.editortype;
    }

    public boolean isEditorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorTypeDirty();
        }
        return this.editortypeDirtyFlag;
    }

    public void resetEditorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorType();
            return;
        }
        this.editortypeDirtyFlag = false;
        this.editortype = null;
    }

    public void setEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editortypename = string;
        this.editortypenameDirtyFlag = true;
    }

    public String getEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorTypeName();
        }
        return this.editortypename;
    }

    public boolean isEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorTypeNameDirty();
        }
        return this.editortypenameDirtyFlag;
    }

    public void resetEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorTypeName();
            return;
        }
        this.editortypenameDirtyFlag = false;
        this.editortypename = null;
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

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag = string;
        this.itemtagDirtyFlag = true;
    }

    public String getItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag();
        }
        return this.itemtag;
    }

    public boolean isItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTagDirty();
        }
        return this.itemtagDirtyFlag;
    }

    public void resetItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag();
            return;
        }
        this.itemtagDirtyFlag = false;
        this.itemtag = null;
    }

    public void setItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag2 = string;
        this.itemtag2DirtyFlag = true;
    }

    public String getItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag2();
        }
        return this.itemtag2;
    }

    public boolean isItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag2Dirty();
        }
        return this.itemtag2DirtyFlag;
    }

    public void resetItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag2();
            return;
        }
        this.itemtag2DirtyFlag = false;
        this.itemtag2 = null;
    }

    public void setJsonFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJsonFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsonformat = string;
        this.jsonformatDirtyFlag = true;
    }

    public String getJsonFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJsonFormat();
        }
        return this.jsonformat;
    }

    public boolean isJsonFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJsonFormatDirty();
        }
        return this.jsonformatDirtyFlag;
    }

    public void resetJsonFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJsonFormat();
            return;
        }
        this.jsonformatDirtyFlag = false;
        this.jsonformat = null;
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

    public void setO2MPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setO2MPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.o2mpsderid = string;
        this.o2mpsderidDirtyFlag = true;
    }

    public String getO2MPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2MPSDERId();
        }
        return this.o2mpsderid;
    }

    public boolean isO2MPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isO2MPSDERIdDirty();
        }
        return this.o2mpsderidDirtyFlag;
    }

    public void resetO2MPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetO2MPSDERId();
            return;
        }
        this.o2mpsderidDirtyFlag = false;
        this.o2mpsderid = null;
    }

    public void setO2OPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setO2OPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.o2opsderid = string;
        this.o2opsderidDirtyFlag = true;
    }

    public String getO2OPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getO2OPSDERId();
        }
        return this.o2opsderid;
    }

    public boolean isO2OPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isO2OPSDERIdDirty();
        }
        return this.o2opsderidDirtyFlag;
    }

    public void resetO2OPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetO2OPSDERId();
            return;
        }
        this.o2opsderidDirtyFlag = false;
        this.o2opsderid = null;
    }

    public void setPHPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPHPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.phpslanresid = string;
        this.phpslanresidDirtyFlag = true;
    }

    public String getPHPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPHPSLanResId();
        }
        return this.phpslanresid;
    }

    public boolean isPHPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPHPSLanResIdDirty();
        }
        return this.phpslanresidDirtyFlag;
    }

    public void resetPHPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPHPSLanResId();
            return;
        }
        this.phpslanresidDirtyFlag = false;
        this.phpslanresid = null;
    }

    public void setPHPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPHPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.phpslanresname = string;
        this.phpslanresnameDirtyFlag = true;
    }

    public String getPHPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPHPSLanResName();
        }
        return this.phpslanresname;
    }

    public boolean isPHPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPHPSLanResNameDirty();
        }
        return this.phpslanresnameDirtyFlag;
    }

    public void resetPHPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPHPSLanResName();
            return;
        }
        this.phpslanresnameDirtyFlag = false;
        this.phpslanresname = null;
    }

    public void setPlaceHolder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlaceHolder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.placeholder = string;
        this.placeholderDirtyFlag = true;
    }

    public String getPlaceHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlaceHolder();
        }
        return this.placeholder;
    }

    public boolean isPlaceHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlaceHolderDirty();
        }
        return this.placeholderDirtyFlag;
    }

    public void resetPlaceHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlaceHolder();
            return;
        }
        this.placeholderDirtyFlag = false;
        this.placeholder = null;
    }

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDBValueOPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopid = string;
        this.psdbvalueopidDirtyFlag = true;
    }

    public String getPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPId();
        }
        return this.psdbvalueopid;
    }

    public boolean isPSDBValueOPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPIdDirty();
        }
        return this.psdbvalueopidDirtyFlag;
    }

    public void resetPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPId();
            return;
        }
        this.psdbvalueopidDirtyFlag = false;
        this.psdbvalueopid = null;
    }

    public void setPSDBValueOPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopname = string;
        this.psdbvalueopnameDirtyFlag = true;
    }

    public String getPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPName();
        }
        return this.psdbvalueopname;
    }

    public boolean isPSDBValueOPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPNameDirty();
        }
        return this.psdbvalueopnameDirtyFlag;
    }

    public void resetPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPName();
            return;
        }
        this.psdbvalueopnameDirtyFlag = false;
        this.psdbvalueopname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSDEFSFItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefsfitemid = string;
        this.psdefsfitemidDirtyFlag = true;
    }

    public String getPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemId();
        }
        return this.psdefsfitemid;
    }

    public boolean isPSDEFSFItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemIdDirty();
        }
        return this.psdefsfitemidDirtyFlag;
    }

    public void resetPSDEFSFItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemId();
            return;
        }
        this.psdefsfitemidDirtyFlag = false;
        this.psdefsfitemid = null;
    }

    public void setPSDEFSFItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFSFItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefsfitemname = string;
        this.psdefsfitemnameDirtyFlag = true;
    }

    public String getPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItemName();
        }
        return this.psdefsfitemname;
    }

    public boolean isPSDEFSFItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFSFItemNameDirty();
        }
        return this.psdefsfitemnameDirtyFlag;
    }

    public void resetPSDEFSFItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFSFItemName();
            return;
        }
        this.psdefsfitemnameDirtyFlag = false;
        this.psdefsfitemname = null;
    }

    public void setPSDEFValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvalueruleid = string;
        this.psdefvalueruleidDirtyFlag = true;
    }

    public String getPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleId();
        }
        return this.psdefvalueruleid;
    }

    public boolean isPSDEFValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleIdDirty();
        }
        return this.psdefvalueruleidDirtyFlag;
    }

    public void resetPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleId();
            return;
        }
        this.psdefvalueruleidDirtyFlag = false;
        this.psdefvalueruleid = null;
    }

    public void setPSDEFValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvaluerulename = string;
        this.psdefvaluerulenameDirtyFlag = true;
    }

    public String getPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleName();
        }
        return this.psdefvaluerulename;
    }

    public boolean isPSDEFValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleNameDirty();
        }
        return this.psdefvaluerulenameDirtyFlag;
    }

    public void resetPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleName();
            return;
        }
        this.psdefvaluerulenameDirtyFlag = false;
        this.psdefvaluerulename = null;
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

    public void setPSSysDBVFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfid = string;
        this.pssysdbvfidDirtyFlag = true;
    }

    public String getPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFId();
        }
        return this.pssysdbvfid;
    }

    public boolean isPSSysDBVFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFIdDirty();
        }
        return this.pssysdbvfidDirtyFlag;
    }

    public void resetPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFId();
            return;
        }
        this.pssysdbvfidDirtyFlag = false;
        this.pssysdbvfid = null;
    }

    public void setPSSysDBVFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfname = string;
        this.pssysdbvfnameDirtyFlag = true;
    }

    public String getPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFName();
        }
        return this.pssysdbvfname;
    }

    public boolean isPSSysDBVFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFNameDirty();
        }
        return this.pssysdbvfnameDirtyFlag;
    }

    public void resetPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFName();
            return;
        }
        this.pssysdbvfnameDirtyFlag = false;
        this.pssysdbvfname = null;
    }

    public void setPSSysEditorStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstyleid = string;
        this.pssyseditorstyleidDirtyFlag = true;
    }

    public String getPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleId();
        }
        return this.pssyseditorstyleid;
    }

    public boolean isPSSysEditorStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleIdDirty();
        }
        return this.pssyseditorstyleidDirtyFlag;
    }

    public void resetPSSysEditorStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleId();
            return;
        }
        this.pssyseditorstyleidDirtyFlag = false;
        this.pssyseditorstyleid = null;
    }

    public void setPSSysEditorStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEditorStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseditorstylename = string;
        this.pssyseditorstylenameDirtyFlag = true;
    }

    public String getPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyleName();
        }
        return this.pssyseditorstylename;
    }

    public boolean isPSSysEditorStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEditorStyleNameDirty();
        }
        return this.pssyseditorstylenameDirtyFlag;
    }

    public void resetPSSysEditorStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEditorStyleName();
            return;
        }
        this.pssyseditorstylenameDirtyFlag = false;
        this.pssyseditorstylename = null;
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

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setPSSysValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvalueruleid = string;
        this.pssysvalueruleidDirtyFlag = true;
    }

    public String getPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleId();
        }
        return this.pssysvalueruleid;
    }

    public boolean isPSSysValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleIdDirty();
        }
        return this.pssysvalueruleidDirtyFlag;
    }

    public void resetPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleId();
            return;
        }
        this.pssysvalueruleidDirtyFlag = false;
        this.pssysvalueruleid = null;
    }

    public void setPSSysValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvaluerulename = string;
        this.pssysvaluerulenameDirtyFlag = true;
    }

    public String getPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleName();
        }
        return this.pssysvaluerulename;
    }

    public boolean isPSSysValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleNameDirty();
        }
        return this.pssysvaluerulenameDirtyFlag;
    }

    public void resetPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleName();
            return;
        }
        this.pssysvaluerulenameDirtyFlag = false;
        this.pssysvaluerulename = null;
    }

    public void setRefADPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefADPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refadpsdelogicid = string;
        this.refadpsdelogicidDirtyFlag = true;
    }

    public String getRefADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefADPSDELogicId();
        }
        return this.refadpsdelogicid;
    }

    public boolean isRefADPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefADPSDELogicIdDirty();
        }
        return this.refadpsdelogicidDirtyFlag;
    }

    public void resetRefADPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefADPSDELogicId();
            return;
        }
        this.refadpsdelogicidDirtyFlag = false;
        this.refadpsdelogicid = null;
    }

    public void setRefADPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefADPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refadpsdelogicname = string;
        this.refadpsdelogicnameDirtyFlag = true;
    }

    public String getRefADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefADPSDELogicName();
        }
        return this.refadpsdelogicname;
    }

    public boolean isRefADPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefADPSDELogicNameDirty();
        }
        return this.refadpsdelogicnameDirtyFlag;
    }

    public void resetRefADPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefADPSDELogicName();
            return;
        }
        this.refadpsdelogicnameDirtyFlag = false;
        this.refadpsdelogicname = null;
    }

    public void setRefMobMPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMobMPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmobmpickuppsdeviewid = string;
        this.refmobmpickuppsdeviewidDirtyFlag = true;
    }

    public String getRefMobMPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMobMPickupPSDEViewId();
        }
        return this.refmobmpickuppsdeviewid;
    }

    public boolean isRefMobMPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMobMPickupPSDEViewIdDirty();
        }
        return this.refmobmpickuppsdeviewidDirtyFlag;
    }

    public void resetRefMobMPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMobMPickupPSDEViewId();
            return;
        }
        this.refmobmpickuppsdeviewidDirtyFlag = false;
        this.refmobmpickuppsdeviewid = null;
    }

    public void setRefMobMPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMobMPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmobmpickuppsdeviewname = string;
        this.refmobmpickuppsdeviewnameDirtyFlag = true;
    }

    public String getRefMobMPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMobMPickupPSDEViewName();
        }
        return this.refmobmpickuppsdeviewname;
    }

    public boolean isRefMobMPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMobMPickupPSDEViewNameDirty();
        }
        return this.refmobmpickuppsdeviewnameDirtyFlag;
    }

    public void resetRefMobMPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMobMPickupPSDEViewName();
            return;
        }
        this.refmobmpickuppsdeviewnameDirtyFlag = false;
        this.refmobmpickuppsdeviewname = null;
    }

    public void setRefMobPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMobPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmobpickuppsdeviewid = string;
        this.refmobpickuppsdeviewidDirtyFlag = true;
    }

    public String getRefMobPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMobPickupPSDEViewId();
        }
        return this.refmobpickuppsdeviewid;
    }

    public boolean isRefMobPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMobPickupPSDEViewIdDirty();
        }
        return this.refmobpickuppsdeviewidDirtyFlag;
    }

    public void resetRefMobPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMobPickupPSDEViewId();
            return;
        }
        this.refmobpickuppsdeviewidDirtyFlag = false;
        this.refmobpickuppsdeviewid = null;
    }

    public void setRefMobPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMobPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmobpickuppsdeviewname = string;
        this.refmobpickuppsdeviewnameDirtyFlag = true;
    }

    public String getRefMobPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMobPickupPSDEViewName();
        }
        return this.refmobpickuppsdeviewname;
    }

    public boolean isRefMobPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMobPickupPSDEViewNameDirty();
        }
        return this.refmobpickuppsdeviewnameDirtyFlag;
    }

    public void resetRefMobPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMobPickupPSDEViewName();
            return;
        }
        this.refmobpickuppsdeviewnameDirtyFlag = false;
        this.refmobpickuppsdeviewname = null;
    }

    public void setRefMPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmpickuppsdeviewid = string;
        this.refmpickuppsdeviewidDirtyFlag = true;
    }

    public String getRefMPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMPickupPSDEViewId();
        }
        return this.refmpickuppsdeviewid;
    }

    public boolean isRefMPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMPickupPSDEViewIdDirty();
        }
        return this.refmpickuppsdeviewidDirtyFlag;
    }

    public void resetRefMPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMPickupPSDEViewId();
            return;
        }
        this.refmpickuppsdeviewidDirtyFlag = false;
        this.refmpickuppsdeviewid = null;
    }

    public void setRefMPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmpickuppsdeviewname = string;
        this.refmpickuppsdeviewnameDirtyFlag = true;
    }

    public String getRefMPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMPickupPSDEViewName();
        }
        return this.refmpickuppsdeviewname;
    }

    public boolean isRefMPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefMPickupPSDEViewNameDirty();
        }
        return this.refmpickuppsdeviewnameDirtyFlag;
    }

    public void resetRefMPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMPickupPSDEViewName();
            return;
        }
        this.refmpickuppsdeviewnameDirtyFlag = false;
        this.refmpickuppsdeviewname = null;
    }

    public void setRefPickupPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPickupPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpickuppsdeviewid = string;
        this.refpickuppsdeviewidDirtyFlag = true;
    }

    public String getRefPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPickupPSDEViewId();
        }
        return this.refpickuppsdeviewid;
    }

    public boolean isRefPickupPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPickupPSDEViewIdDirty();
        }
        return this.refpickuppsdeviewidDirtyFlag;
    }

    public void resetRefPickupPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPickupPSDEViewId();
            return;
        }
        this.refpickuppsdeviewidDirtyFlag = false;
        this.refpickuppsdeviewid = null;
    }

    public void setRefPickupPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPickupPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpickuppsdeviewname = string;
        this.refpickuppsdeviewnameDirtyFlag = true;
    }

    public String getRefPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPickupPSDEViewName();
        }
        return this.refpickuppsdeviewname;
    }

    public boolean isRefPickupPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPickupPSDEViewNameDirty();
        }
        return this.refpickuppsdeviewnameDirtyFlag;
    }

    public void resetRefPickupPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPickupPSDEViewName();
            return;
        }
        this.refpickuppsdeviewnameDirtyFlag = false;
        this.refpickuppsdeviewname = null;
    }

    public void setRefPSDEACModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEACModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeacmodeid = string;
        this.refpsdeacmodeidDirtyFlag = true;
    }

    public String getRefPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEACModeId();
        }
        return this.refpsdeacmodeid;
    }

    public boolean isRefPSDEACModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEACModeIdDirty();
        }
        return this.refpsdeacmodeidDirtyFlag;
    }

    public void resetRefPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEACModeId();
            return;
        }
        this.refpsdeacmodeidDirtyFlag = false;
        this.refpsdeacmodeid = null;
    }

    public void setRefPSDEACModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEACModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeacmodename = string;
        this.refpsdeacmodenameDirtyFlag = true;
    }

    public String getRefPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEACModeName();
        }
        return this.refpsdeacmodename;
    }

    public boolean isRefPSDEACModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEACModeNameDirty();
        }
        return this.refpsdeacmodenameDirtyFlag;
    }

    public void resetRefPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEACModeName();
            return;
        }
        this.refpsdeacmodenameDirtyFlag = false;
        this.refpsdeacmodename = null;
    }

    public void setRefPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdedatasetid = string;
        this.refpsdedatasetidDirtyFlag = true;
    }

    public String getRefPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSetId();
        }
        return this.refpsdedatasetid;
    }

    public boolean isRefPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEDataSetIdDirty();
        }
        return this.refpsdedatasetidDirtyFlag;
    }

    public void resetRefPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEDataSetId();
            return;
        }
        this.refpsdedatasetidDirtyFlag = false;
        this.refpsdedatasetid = null;
    }

    public void setRefPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdedatasetname = string;
        this.refpsdedatasetnameDirtyFlag = true;
    }

    public String getRefPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSetName();
        }
        return this.refpsdedatasetname;
    }

    public boolean isRefPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEDataSetNameDirty();
        }
        return this.refpsdedatasetnameDirtyFlag;
    }

    public void resetRefPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEDataSetName();
            return;
        }
        this.refpsdedatasetnameDirtyFlag = false;
        this.refpsdedatasetname = null;
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

    public void setRefPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsderid = string;
        this.refpsderidDirtyFlag = true;
    }

    public String getRefPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDERId();
        }
        return this.refpsderid;
    }

    public boolean isRefPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDERIdDirty();
        }
        return this.refpsderidDirtyFlag;
    }

    public void resetRefPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDERId();
            return;
        }
        this.refpsderidDirtyFlag = false;
        this.refpsderid = null;
    }

    public void setRefPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdername = string;
        this.refpsdernameDirtyFlag = true;
    }

    public String getRefPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDERName();
        }
        return this.refpsdername;
    }

    public boolean isRefPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDERNameDirty();
        }
        return this.refpsdernameDirtyFlag;
    }

    public void resetRefPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDERName();
            return;
        }
        this.refpsdernameDirtyFlag = false;
        this.refpsdername = null;
    }

    public void setSearchMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchmode = string;
        this.searchmodeDirtyFlag = true;
    }

    public String getSearchMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchMode();
        }
        return this.searchmode;
    }

    public boolean isSearchModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchModeDirty();
        }
        return this.searchmodeDirtyFlag;
    }

    public void resetSearchMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchMode();
            return;
        }
        this.searchmodeDirtyFlag = false;
        this.searchmode = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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

    public void setValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueformat = string;
        this.valueformatDirtyFlag = true;
    }

    public String getValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFormat();
        }
        return this.valueformat;
    }

    public boolean isValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFormatDirty();
        }
        return this.valueformatDirtyFlag;
    }

    public void resetValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFormat();
            return;
        }
        this.valueformatDirtyFlag = false;
        this.valueformat = null;
    }

    public void setValueSeperator(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueSeperator(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueseperator = string;
        this.valueseperatorDirtyFlag = true;
    }

    public String getValueSeperator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueSeperator();
        }
        return this.valueseperator;
    }

    public boolean isValueSeperatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueSeperatorDirty();
        }
        return this.valueseperatorDirtyFlag;
    }

    public void resetValueSeperator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueSeperator();
            return;
        }
        this.valueseperatorDirtyFlag = false;
        this.valueseperator = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSDEFSFItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFSFItemBase pSDEFSFItemBase) {
        pSDEFSFItemBase.resetArrayFlag();
        pSDEFSFItemBase.resetCapPSLanResId();
        pSDEFSFItemBase.resetCapPSLanResName();
        pSDEFSFItemBase.resetCaption();
        pSDEFSFItemBase.resetCodeName();
        pSDEFSFItemBase.resetCreateDate();
        pSDEFSFItemBase.resetCreateMan();
        pSDEFSFItemBase.resetDefaultFlag();
        pSDEFSFItemBase.resetDstPSDEFId();
        pSDEFSFItemBase.resetDstPSDEFSFItemId();
        pSDEFSFItemBase.resetDstPSDEFSFItemName();
        pSDEFSFItemBase.resetDstPSDEId();
        pSDEFSFItemBase.resetEditorType();
        pSDEFSFItemBase.resetEditorTypeName();
        pSDEFSFItemBase.resetExtendMode();
        pSDEFSFItemBase.resetHeight();
        pSDEFSFItemBase.resetItemTag();
        pSDEFSFItemBase.resetItemTag2();
        pSDEFSFItemBase.resetJsonFormat();
        pSDEFSFItemBase.resetLockFlag();
        pSDEFSFItemBase.resetLogicName();
        pSDEFSFItemBase.resetMemo();
        pSDEFSFItemBase.resetO2MPSDERId();
        pSDEFSFItemBase.resetO2OPSDERId();
        pSDEFSFItemBase.resetPHPSLanResId();
        pSDEFSFItemBase.resetPHPSLanResName();
        pSDEFSFItemBase.resetPlaceHolder();
        pSDEFSFItemBase.resetPSCodeListId();
        pSDEFSFItemBase.resetPSCodeListName();
        pSDEFSFItemBase.resetPSDBValueOPId();
        pSDEFSFItemBase.resetPSDBValueOPName();
        pSDEFSFItemBase.resetPSDEFId();
        pSDEFSFItemBase.resetPSDEFName();
        pSDEFSFItemBase.resetPSDEFSFItemId();
        pSDEFSFItemBase.resetPSDEFSFItemName();
        pSDEFSFItemBase.resetPSDEFValueRuleId();
        pSDEFSFItemBase.resetPSDEFValueRuleName();
        pSDEFSFItemBase.resetPSDEId();
        pSDEFSFItemBase.resetPSDEName();
        pSDEFSFItemBase.resetPSSysDBVFId();
        pSDEFSFItemBase.resetPSSysDBVFName();
        pSDEFSFItemBase.resetPSSysEditorStyleId();
        pSDEFSFItemBase.resetPSSysEditorStyleName();
        pSDEFSFItemBase.resetPSSysImageId();
        pSDEFSFItemBase.resetPSSysImageName();
        pSDEFSFItemBase.resetPSSysSFPluginId();
        pSDEFSFItemBase.resetPSSysSFPluginName();
        pSDEFSFItemBase.resetPSSysTranslatorId();
        pSDEFSFItemBase.resetPSSysTranslatorName();
        pSDEFSFItemBase.resetPSSysValueRuleId();
        pSDEFSFItemBase.resetPSSysValueRuleName();
        pSDEFSFItemBase.resetRefADPSDELogicId();
        pSDEFSFItemBase.resetRefADPSDELogicName();
        pSDEFSFItemBase.resetRefMobMPickupPSDEViewId();
        pSDEFSFItemBase.resetRefMobMPickupPSDEViewName();
        pSDEFSFItemBase.resetRefMobPickupPSDEViewId();
        pSDEFSFItemBase.resetRefMobPickupPSDEViewName();
        pSDEFSFItemBase.resetRefMPickupPSDEViewId();
        pSDEFSFItemBase.resetRefMPickupPSDEViewName();
        pSDEFSFItemBase.resetRefPickupPSDEViewId();
        pSDEFSFItemBase.resetRefPickupPSDEViewName();
        pSDEFSFItemBase.resetRefPSDEACModeId();
        pSDEFSFItemBase.resetRefPSDEACModeName();
        pSDEFSFItemBase.resetRefPSDEDataSetId();
        pSDEFSFItemBase.resetRefPSDEDataSetName();
        pSDEFSFItemBase.resetRefPSDEId();
        pSDEFSFItemBase.resetRefPSDEName();
        pSDEFSFItemBase.resetRefPSDERId();
        pSDEFSFItemBase.resetRefPSDERName();
        pSDEFSFItemBase.resetSearchMode();
        pSDEFSFItemBase.resetServiceCodeName();
        pSDEFSFItemBase.resetUpdateDate();
        pSDEFSFItemBase.resetUpdateMan();
        pSDEFSFItemBase.resetUserCat();
        pSDEFSFItemBase.resetUserParams();
        pSDEFSFItemBase.resetUserTag();
        pSDEFSFItemBase.resetUserTag2();
        pSDEFSFItemBase.resetUserTag3();
        pSDEFSFItemBase.resetUserTag4();
        pSDEFSFItemBase.resetValueFormat();
        pSDEFSFItemBase.resetValueSeperator();
        pSDEFSFItemBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArrayFlagDirty()) {
            hashMap.put(FIELD_ARRAYFLAG, this.getArrayFlag());
        }
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDstPSDEFIdDirty()) {
            hashMap.put(FIELD_DSTPSDEFID, this.getDstPSDEFId());
        }
        if (!bl || this.isDstPSDEFSFItemIdDirty()) {
            hashMap.put(FIELD_DSTPSDEFSFITEMID, this.getDstPSDEFSFItemId());
        }
        if (!bl || this.isDstPSDEFSFItemNameDirty()) {
            hashMap.put(FIELD_DSTPSDEFSFITEMNAME, this.getDstPSDEFSFItemName());
        }
        if (!bl || this.isDstPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEID, this.getDstPSDEId());
        }
        if (!bl || this.isEditorTypeDirty()) {
            hashMap.put(FIELD_EDITORTYPE, this.getEditorType());
        }
        if (!bl || this.isEditorTypeNameDirty()) {
            hashMap.put(FIELD_EDITORTYPENAME, this.getEditorTypeName());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isItemTagDirty()) {
            hashMap.put(FIELD_ITEMTAG, this.getItemTag());
        }
        if (!bl || this.isItemTag2Dirty()) {
            hashMap.put(FIELD_ITEMTAG2, this.getItemTag2());
        }
        if (!bl || this.isJsonFormatDirty()) {
            hashMap.put(FIELD_JSONFORMAT, this.getJsonFormat());
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
        if (!bl || this.isO2MPSDERIdDirty()) {
            hashMap.put(FIELD_O2MPSDERID, this.getO2MPSDERId());
        }
        if (!bl || this.isO2OPSDERIdDirty()) {
            hashMap.put(FIELD_O2OPSDERID, this.getO2OPSDERId());
        }
        if (!bl || this.isPHPSLanResIdDirty()) {
            hashMap.put(FIELD_PHPSLANRESID, this.getPHPSLanResId());
        }
        if (!bl || this.isPHPSLanResNameDirty()) {
            hashMap.put(FIELD_PHPSLANRESNAME, this.getPHPSLanResName());
        }
        if (!bl || this.isPlaceHolderDirty()) {
            hashMap.put(FIELD_PLACEHOLDER, this.getPlaceHolder());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEFSFItemIdDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMID, this.getPSDEFSFItemId());
        }
        if (!bl || this.isPSDEFSFItemNameDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMNAME, this.getPSDEFSFItemName());
        }
        if (!bl || this.isPSDEFValueRuleIdDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULEID, this.getPSDEFValueRuleId());
        }
        if (!bl || this.isPSDEFValueRuleNameDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULENAME, this.getPSDEFValueRuleName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysDBVFIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVFID, this.getPSSysDBVFId());
        }
        if (!bl || this.isPSSysDBVFNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVFNAME, this.getPSSysDBVFName());
        }
        if (!bl || this.isPSSysEditorStyleIdDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLEID, this.getPSSysEditorStyleId());
        }
        if (!bl || this.isPSSysEditorStyleNameDirty()) {
            hashMap.put(FIELD_PSSYSEDITORSTYLENAME, this.getPSSysEditorStyleName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
        }
        if (!bl || this.isRefADPSDELogicIdDirty()) {
            hashMap.put(FIELD_REFADPSDELOGICID, this.getRefADPSDELogicId());
        }
        if (!bl || this.isRefADPSDELogicNameDirty()) {
            hashMap.put(FIELD_REFADPSDELOGICNAME, this.getRefADPSDELogicName());
        }
        if (!bl || this.isRefMobMPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFMOBMPICKUPPSDEVIEWID, this.getRefMobMPickupPSDEViewId());
        }
        if (!bl || this.isRefMobMPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFMOBMPICKUPPSDEVIEWNAME, this.getRefMobMPickupPSDEViewName());
        }
        if (!bl || this.isRefMobPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFMOBPICKUPPSDEVIEWID, this.getRefMobPickupPSDEViewId());
        }
        if (!bl || this.isRefMobPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFMOBPICKUPPSDEVIEWNAME, this.getRefMobPickupPSDEViewName());
        }
        if (!bl || this.isRefMPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFMPICKUPPSDEVIEWID, this.getRefMPickupPSDEViewId());
        }
        if (!bl || this.isRefMPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFMPICKUPPSDEVIEWNAME, this.getRefMPickupPSDEViewName());
        }
        if (!bl || this.isRefPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFPICKUPPSDEVIEWID, this.getRefPickupPSDEViewId());
        }
        if (!bl || this.isRefPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFPICKUPPSDEVIEWNAME, this.getRefPickupPSDEViewName());
        }
        if (!bl || this.isRefPSDEACModeIdDirty()) {
            hashMap.put(FIELD_REFPSDEACMODEID, this.getRefPSDEACModeId());
        }
        if (!bl || this.isRefPSDEACModeNameDirty()) {
            hashMap.put(FIELD_REFPSDEACMODENAME, this.getRefPSDEACModeName());
        }
        if (!bl || this.isRefPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_REFPSDEDATASETID, this.getRefPSDEDataSetId());
        }
        if (!bl || this.isRefPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_REFPSDEDATASETNAME, this.getRefPSDEDataSetName());
        }
        if (!bl || this.isRefPSDEIdDirty()) {
            hashMap.put(FIELD_REFPSDEID, this.getRefPSDEId());
        }
        if (!bl || this.isRefPSDENameDirty()) {
            hashMap.put(FIELD_REFPSDENAME, this.getRefPSDEName());
        }
        if (!bl || this.isRefPSDERIdDirty()) {
            hashMap.put(FIELD_REFPSDERID, this.getRefPSDERId());
        }
        if (!bl || this.isRefPSDERNameDirty()) {
            hashMap.put(FIELD_REFPSDERNAME, this.getRefPSDERName());
        }
        if (!bl || this.isSearchModeDirty()) {
            hashMap.put(FIELD_SEARCHMODE, this.getSearchMode());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
        }
        if (!bl || this.isValueSeperatorDirty()) {
            hashMap.put(FIELD_VALUESEPERATOR, this.getValueSeperator());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSDEFSFItemBase.get(this, n);
    }

    private static Object get(PSDEFSFItemBase pSDEFSFItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFSFItemBase.getArrayFlag();
            }
            case 1: {
                return pSDEFSFItemBase.getCapPSLanResId();
            }
            case 2: {
                return pSDEFSFItemBase.getCapPSLanResName();
            }
            case 3: {
                return pSDEFSFItemBase.getCaption();
            }
            case 4: {
                return pSDEFSFItemBase.getCodeName();
            }
            case 5: {
                return pSDEFSFItemBase.getCreateDate();
            }
            case 6: {
                return pSDEFSFItemBase.getCreateMan();
            }
            case 7: {
                return pSDEFSFItemBase.getDefaultFlag();
            }
            case 8: {
                return pSDEFSFItemBase.getDstPSDEFId();
            }
            case 9: {
                return pSDEFSFItemBase.getDstPSDEFSFItemId();
            }
            case 10: {
                return pSDEFSFItemBase.getDstPSDEFSFItemName();
            }
            case 11: {
                return pSDEFSFItemBase.getDstPSDEId();
            }
            case 12: {
                return pSDEFSFItemBase.getEditorType();
            }
            case 13: {
                return pSDEFSFItemBase.getEditorTypeName();
            }
            case 14: {
                return pSDEFSFItemBase.getExtendMode();
            }
            case 15: {
                return pSDEFSFItemBase.getHeight();
            }
            case 16: {
                return pSDEFSFItemBase.getItemTag();
            }
            case 17: {
                return pSDEFSFItemBase.getItemTag2();
            }
            case 18: {
                return pSDEFSFItemBase.getJsonFormat();
            }
            case 19: {
                return pSDEFSFItemBase.getLockFlag();
            }
            case 20: {
                return pSDEFSFItemBase.getLogicName();
            }
            case 21: {
                return pSDEFSFItemBase.getMemo();
            }
            case 22: {
                return pSDEFSFItemBase.getO2MPSDERId();
            }
            case 23: {
                return pSDEFSFItemBase.getO2OPSDERId();
            }
            case 24: {
                return pSDEFSFItemBase.getPHPSLanResId();
            }
            case 25: {
                return pSDEFSFItemBase.getPHPSLanResName();
            }
            case 26: {
                return pSDEFSFItemBase.getPlaceHolder();
            }
            case 27: {
                return pSDEFSFItemBase.getPSCodeListId();
            }
            case 28: {
                return pSDEFSFItemBase.getPSCodeListName();
            }
            case 29: {
                return pSDEFSFItemBase.getPSDBValueOPId();
            }
            case 30: {
                return pSDEFSFItemBase.getPSDBValueOPName();
            }
            case 31: {
                return pSDEFSFItemBase.getPSDEFId();
            }
            case 32: {
                return pSDEFSFItemBase.getPSDEFName();
            }
            case 33: {
                return pSDEFSFItemBase.getPSDEFSFItemId();
            }
            case 34: {
                return pSDEFSFItemBase.getPSDEFSFItemName();
            }
            case 35: {
                return pSDEFSFItemBase.getPSDEFValueRuleId();
            }
            case 36: {
                return pSDEFSFItemBase.getPSDEFValueRuleName();
            }
            case 37: {
                return pSDEFSFItemBase.getPSDEId();
            }
            case 38: {
                return pSDEFSFItemBase.getPSDEName();
            }
            case 39: {
                return pSDEFSFItemBase.getPSSysDBVFId();
            }
            case 40: {
                return pSDEFSFItemBase.getPSSysDBVFName();
            }
            case 41: {
                return pSDEFSFItemBase.getPSSysEditorStyleId();
            }
            case 42: {
                return pSDEFSFItemBase.getPSSysEditorStyleName();
            }
            case 43: {
                return pSDEFSFItemBase.getPSSysImageId();
            }
            case 44: {
                return pSDEFSFItemBase.getPSSysImageName();
            }
            case 45: {
                return pSDEFSFItemBase.getPSSysSFPluginId();
            }
            case 46: {
                return pSDEFSFItemBase.getPSSysSFPluginName();
            }
            case 47: {
                return pSDEFSFItemBase.getPSSysTranslatorId();
            }
            case 48: {
                return pSDEFSFItemBase.getPSSysTranslatorName();
            }
            case 49: {
                return pSDEFSFItemBase.getPSSysValueRuleId();
            }
            case 50: {
                return pSDEFSFItemBase.getPSSysValueRuleName();
            }
            case 51: {
                return pSDEFSFItemBase.getRefADPSDELogicId();
            }
            case 52: {
                return pSDEFSFItemBase.getRefADPSDELogicName();
            }
            case 53: {
                return pSDEFSFItemBase.getRefMobMPickupPSDEViewId();
            }
            case 54: {
                return pSDEFSFItemBase.getRefMobMPickupPSDEViewName();
            }
            case 55: {
                return pSDEFSFItemBase.getRefMobPickupPSDEViewId();
            }
            case 56: {
                return pSDEFSFItemBase.getRefMobPickupPSDEViewName();
            }
            case 57: {
                return pSDEFSFItemBase.getRefMPickupPSDEViewId();
            }
            case 58: {
                return pSDEFSFItemBase.getRefMPickupPSDEViewName();
            }
            case 59: {
                return pSDEFSFItemBase.getRefPickupPSDEViewId();
            }
            case 60: {
                return pSDEFSFItemBase.getRefPickupPSDEViewName();
            }
            case 61: {
                return pSDEFSFItemBase.getRefPSDEACModeId();
            }
            case 62: {
                return pSDEFSFItemBase.getRefPSDEACModeName();
            }
            case 63: {
                return pSDEFSFItemBase.getRefPSDEDataSetId();
            }
            case 64: {
                return pSDEFSFItemBase.getRefPSDEDataSetName();
            }
            case 65: {
                return pSDEFSFItemBase.getRefPSDEId();
            }
            case 66: {
                return pSDEFSFItemBase.getRefPSDEName();
            }
            case 67: {
                return pSDEFSFItemBase.getRefPSDERId();
            }
            case 68: {
                return pSDEFSFItemBase.getRefPSDERName();
            }
            case 69: {
                return pSDEFSFItemBase.getSearchMode();
            }
            case 70: {
                return pSDEFSFItemBase.getServiceCodeName();
            }
            case 71: {
                return pSDEFSFItemBase.getUpdateDate();
            }
            case 72: {
                return pSDEFSFItemBase.getUpdateMan();
            }
            case 73: {
                return pSDEFSFItemBase.getUserCat();
            }
            case 74: {
                return pSDEFSFItemBase.getUserParams();
            }
            case 75: {
                return pSDEFSFItemBase.getUserTag();
            }
            case 76: {
                return pSDEFSFItemBase.getUserTag2();
            }
            case 77: {
                return pSDEFSFItemBase.getUserTag3();
            }
            case 78: {
                return pSDEFSFItemBase.getUserTag4();
            }
            case 79: {
                return pSDEFSFItemBase.getValueFormat();
            }
            case 80: {
                return pSDEFSFItemBase.getValueSeperator();
            }
            case 81: {
                return pSDEFSFItemBase.getWidth();
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
        PSDEFSFItemBase.set(this, n, object);
    }

    private static void set(PSDEFSFItemBase pSDEFSFItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFSFItemBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFSFItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFSFItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFSFItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFSFItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFSFItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDEFSFItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFSFItemBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEFSFItemBase.setDstPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFSFItemBase.setDstPSDEFSFItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFSFItemBase.setDstPSDEFSFItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFSFItemBase.setDstPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFSFItemBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFSFItemBase.setEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFSFItemBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEFSFItemBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEFSFItemBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFSFItemBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFSFItemBase.setJsonFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFSFItemBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEFSFItemBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFSFItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFSFItemBase.setO2MPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFSFItemBase.setO2OPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFSFItemBase.setPHPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFSFItemBase.setPHPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFSFItemBase.setPlaceHolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFSFItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFSFItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFSFItemBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFSFItemBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFSFItemBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFSFItemBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFSFItemBase.setPSDEFSFItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFSFItemBase.setPSDEFSFItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFSFItemBase.setPSDEFValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFSFItemBase.setPSDEFValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEFSFItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFSFItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEFSFItemBase.setPSSysDBVFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEFSFItemBase.setPSSysDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEFSFItemBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFSFItemBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEFSFItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEFSFItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEFSFItemBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEFSFItemBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEFSFItemBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEFSFItemBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEFSFItemBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEFSFItemBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEFSFItemBase.setRefADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEFSFItemBase.setRefADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDEFSFItemBase.setRefMobMPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEFSFItemBase.setRefMobMPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEFSFItemBase.setRefMobPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEFSFItemBase.setRefMobPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDEFSFItemBase.setRefMPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDEFSFItemBase.setRefMPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDEFSFItemBase.setRefPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDEFSFItemBase.setRefPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDEFSFItemBase.setRefPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEFSFItemBase.setRefPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEFSFItemBase.setRefPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEFSFItemBase.setRefPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDEFSFItemBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEFSFItemBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDEFSFItemBase.setRefPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDEFSFItemBase.setRefPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEFSFItemBase.setSearchMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEFSFItemBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDEFSFItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 72: {
                pSDEFSFItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEFSFItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDEFSFItemBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEFSFItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEFSFItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEFSFItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEFSFItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDEFSFItemBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDEFSFItemBase.setValueSeperator(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEFSFItemBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSDEFSFItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFSFItemBase pSDEFSFItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFSFItemBase.getArrayFlag() == null;
            }
            case 1: {
                return pSDEFSFItemBase.getCapPSLanResId() == null;
            }
            case 2: {
                return pSDEFSFItemBase.getCapPSLanResName() == null;
            }
            case 3: {
                return pSDEFSFItemBase.getCaption() == null;
            }
            case 4: {
                return pSDEFSFItemBase.getCodeName() == null;
            }
            case 5: {
                return pSDEFSFItemBase.getCreateDate() == null;
            }
            case 6: {
                return pSDEFSFItemBase.getCreateMan() == null;
            }
            case 7: {
                return pSDEFSFItemBase.getDefaultFlag() == null;
            }
            case 8: {
                return pSDEFSFItemBase.getDstPSDEFId() == null;
            }
            case 9: {
                return pSDEFSFItemBase.getDstPSDEFSFItemId() == null;
            }
            case 10: {
                return pSDEFSFItemBase.getDstPSDEFSFItemName() == null;
            }
            case 11: {
                return pSDEFSFItemBase.getDstPSDEId() == null;
            }
            case 12: {
                return pSDEFSFItemBase.getEditorType() == null;
            }
            case 13: {
                return pSDEFSFItemBase.getEditorTypeName() == null;
            }
            case 14: {
                return pSDEFSFItemBase.getExtendMode() == null;
            }
            case 15: {
                return pSDEFSFItemBase.getHeight() == null;
            }
            case 16: {
                return pSDEFSFItemBase.getItemTag() == null;
            }
            case 17: {
                return pSDEFSFItemBase.getItemTag2() == null;
            }
            case 18: {
                return pSDEFSFItemBase.getJsonFormat() == null;
            }
            case 19: {
                return pSDEFSFItemBase.getLockFlag() == null;
            }
            case 20: {
                return pSDEFSFItemBase.getLogicName() == null;
            }
            case 21: {
                return pSDEFSFItemBase.getMemo() == null;
            }
            case 22: {
                return pSDEFSFItemBase.getO2MPSDERId() == null;
            }
            case 23: {
                return pSDEFSFItemBase.getO2OPSDERId() == null;
            }
            case 24: {
                return pSDEFSFItemBase.getPHPSLanResId() == null;
            }
            case 25: {
                return pSDEFSFItemBase.getPHPSLanResName() == null;
            }
            case 26: {
                return pSDEFSFItemBase.getPlaceHolder() == null;
            }
            case 27: {
                return pSDEFSFItemBase.getPSCodeListId() == null;
            }
            case 28: {
                return pSDEFSFItemBase.getPSCodeListName() == null;
            }
            case 29: {
                return pSDEFSFItemBase.getPSDBValueOPId() == null;
            }
            case 30: {
                return pSDEFSFItemBase.getPSDBValueOPName() == null;
            }
            case 31: {
                return pSDEFSFItemBase.getPSDEFId() == null;
            }
            case 32: {
                return pSDEFSFItemBase.getPSDEFName() == null;
            }
            case 33: {
                return pSDEFSFItemBase.getPSDEFSFItemId() == null;
            }
            case 34: {
                return pSDEFSFItemBase.getPSDEFSFItemName() == null;
            }
            case 35: {
                return pSDEFSFItemBase.getPSDEFValueRuleId() == null;
            }
            case 36: {
                return pSDEFSFItemBase.getPSDEFValueRuleName() == null;
            }
            case 37: {
                return pSDEFSFItemBase.getPSDEId() == null;
            }
            case 38: {
                return pSDEFSFItemBase.getPSDEName() == null;
            }
            case 39: {
                return pSDEFSFItemBase.getPSSysDBVFId() == null;
            }
            case 40: {
                return pSDEFSFItemBase.getPSSysDBVFName() == null;
            }
            case 41: {
                return pSDEFSFItemBase.getPSSysEditorStyleId() == null;
            }
            case 42: {
                return pSDEFSFItemBase.getPSSysEditorStyleName() == null;
            }
            case 43: {
                return pSDEFSFItemBase.getPSSysImageId() == null;
            }
            case 44: {
                return pSDEFSFItemBase.getPSSysImageName() == null;
            }
            case 45: {
                return pSDEFSFItemBase.getPSSysSFPluginId() == null;
            }
            case 46: {
                return pSDEFSFItemBase.getPSSysSFPluginName() == null;
            }
            case 47: {
                return pSDEFSFItemBase.getPSSysTranslatorId() == null;
            }
            case 48: {
                return pSDEFSFItemBase.getPSSysTranslatorName() == null;
            }
            case 49: {
                return pSDEFSFItemBase.getPSSysValueRuleId() == null;
            }
            case 50: {
                return pSDEFSFItemBase.getPSSysValueRuleName() == null;
            }
            case 51: {
                return pSDEFSFItemBase.getRefADPSDELogicId() == null;
            }
            case 52: {
                return pSDEFSFItemBase.getRefADPSDELogicName() == null;
            }
            case 53: {
                return pSDEFSFItemBase.getRefMobMPickupPSDEViewId() == null;
            }
            case 54: {
                return pSDEFSFItemBase.getRefMobMPickupPSDEViewName() == null;
            }
            case 55: {
                return pSDEFSFItemBase.getRefMobPickupPSDEViewId() == null;
            }
            case 56: {
                return pSDEFSFItemBase.getRefMobPickupPSDEViewName() == null;
            }
            case 57: {
                return pSDEFSFItemBase.getRefMPickupPSDEViewId() == null;
            }
            case 58: {
                return pSDEFSFItemBase.getRefMPickupPSDEViewName() == null;
            }
            case 59: {
                return pSDEFSFItemBase.getRefPickupPSDEViewId() == null;
            }
            case 60: {
                return pSDEFSFItemBase.getRefPickupPSDEViewName() == null;
            }
            case 61: {
                return pSDEFSFItemBase.getRefPSDEACModeId() == null;
            }
            case 62: {
                return pSDEFSFItemBase.getRefPSDEACModeName() == null;
            }
            case 63: {
                return pSDEFSFItemBase.getRefPSDEDataSetId() == null;
            }
            case 64: {
                return pSDEFSFItemBase.getRefPSDEDataSetName() == null;
            }
            case 65: {
                return pSDEFSFItemBase.getRefPSDEId() == null;
            }
            case 66: {
                return pSDEFSFItemBase.getRefPSDEName() == null;
            }
            case 67: {
                return pSDEFSFItemBase.getRefPSDERId() == null;
            }
            case 68: {
                return pSDEFSFItemBase.getRefPSDERName() == null;
            }
            case 69: {
                return pSDEFSFItemBase.getSearchMode() == null;
            }
            case 70: {
                return pSDEFSFItemBase.getServiceCodeName() == null;
            }
            case 71: {
                return pSDEFSFItemBase.getUpdateDate() == null;
            }
            case 72: {
                return pSDEFSFItemBase.getUpdateMan() == null;
            }
            case 73: {
                return pSDEFSFItemBase.getUserCat() == null;
            }
            case 74: {
                return pSDEFSFItemBase.getUserParams() == null;
            }
            case 75: {
                return pSDEFSFItemBase.getUserTag() == null;
            }
            case 76: {
                return pSDEFSFItemBase.getUserTag2() == null;
            }
            case 77: {
                return pSDEFSFItemBase.getUserTag3() == null;
            }
            case 78: {
                return pSDEFSFItemBase.getUserTag4() == null;
            }
            case 79: {
                return pSDEFSFItemBase.getValueFormat() == null;
            }
            case 80: {
                return pSDEFSFItemBase.getValueSeperator() == null;
            }
            case 81: {
                return pSDEFSFItemBase.getWidth() == null;
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
        return PSDEFSFItemBase.contains(this, n);
    }

    private static boolean contains(PSDEFSFItemBase pSDEFSFItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFSFItemBase.isArrayFlagDirty();
            }
            case 1: {
                return pSDEFSFItemBase.isCapPSLanResIdDirty();
            }
            case 2: {
                return pSDEFSFItemBase.isCapPSLanResNameDirty();
            }
            case 3: {
                return pSDEFSFItemBase.isCaptionDirty();
            }
            case 4: {
                return pSDEFSFItemBase.isCodeNameDirty();
            }
            case 5: {
                return pSDEFSFItemBase.isCreateDateDirty();
            }
            case 6: {
                return pSDEFSFItemBase.isCreateManDirty();
            }
            case 7: {
                return pSDEFSFItemBase.isDefaultFlagDirty();
            }
            case 8: {
                return pSDEFSFItemBase.isDstPSDEFIdDirty();
            }
            case 9: {
                return pSDEFSFItemBase.isDstPSDEFSFItemIdDirty();
            }
            case 10: {
                return pSDEFSFItemBase.isDstPSDEFSFItemNameDirty();
            }
            case 11: {
                return pSDEFSFItemBase.isDstPSDEIdDirty();
            }
            case 12: {
                return pSDEFSFItemBase.isEditorTypeDirty();
            }
            case 13: {
                return pSDEFSFItemBase.isEditorTypeNameDirty();
            }
            case 14: {
                return pSDEFSFItemBase.isExtendModeDirty();
            }
            case 15: {
                return pSDEFSFItemBase.isHeightDirty();
            }
            case 16: {
                return pSDEFSFItemBase.isItemTagDirty();
            }
            case 17: {
                return pSDEFSFItemBase.isItemTag2Dirty();
            }
            case 18: {
                return pSDEFSFItemBase.isJsonFormatDirty();
            }
            case 19: {
                return pSDEFSFItemBase.isLockFlagDirty();
            }
            case 20: {
                return pSDEFSFItemBase.isLogicNameDirty();
            }
            case 21: {
                return pSDEFSFItemBase.isMemoDirty();
            }
            case 22: {
                return pSDEFSFItemBase.isO2MPSDERIdDirty();
            }
            case 23: {
                return pSDEFSFItemBase.isO2OPSDERIdDirty();
            }
            case 24: {
                return pSDEFSFItemBase.isPHPSLanResIdDirty();
            }
            case 25: {
                return pSDEFSFItemBase.isPHPSLanResNameDirty();
            }
            case 26: {
                return pSDEFSFItemBase.isPlaceHolderDirty();
            }
            case 27: {
                return pSDEFSFItemBase.isPSCodeListIdDirty();
            }
            case 28: {
                return pSDEFSFItemBase.isPSCodeListNameDirty();
            }
            case 29: {
                return pSDEFSFItemBase.isPSDBValueOPIdDirty();
            }
            case 30: {
                return pSDEFSFItemBase.isPSDBValueOPNameDirty();
            }
            case 31: {
                return pSDEFSFItemBase.isPSDEFIdDirty();
            }
            case 32: {
                return pSDEFSFItemBase.isPSDEFNameDirty();
            }
            case 33: {
                return pSDEFSFItemBase.isPSDEFSFItemIdDirty();
            }
            case 34: {
                return pSDEFSFItemBase.isPSDEFSFItemNameDirty();
            }
            case 35: {
                return pSDEFSFItemBase.isPSDEFValueRuleIdDirty();
            }
            case 36: {
                return pSDEFSFItemBase.isPSDEFValueRuleNameDirty();
            }
            case 37: {
                return pSDEFSFItemBase.isPSDEIdDirty();
            }
            case 38: {
                return pSDEFSFItemBase.isPSDENameDirty();
            }
            case 39: {
                return pSDEFSFItemBase.isPSSysDBVFIdDirty();
            }
            case 40: {
                return pSDEFSFItemBase.isPSSysDBVFNameDirty();
            }
            case 41: {
                return pSDEFSFItemBase.isPSSysEditorStyleIdDirty();
            }
            case 42: {
                return pSDEFSFItemBase.isPSSysEditorStyleNameDirty();
            }
            case 43: {
                return pSDEFSFItemBase.isPSSysImageIdDirty();
            }
            case 44: {
                return pSDEFSFItemBase.isPSSysImageNameDirty();
            }
            case 45: {
                return pSDEFSFItemBase.isPSSysSFPluginIdDirty();
            }
            case 46: {
                return pSDEFSFItemBase.isPSSysSFPluginNameDirty();
            }
            case 47: {
                return pSDEFSFItemBase.isPSSysTranslatorIdDirty();
            }
            case 48: {
                return pSDEFSFItemBase.isPSSysTranslatorNameDirty();
            }
            case 49: {
                return pSDEFSFItemBase.isPSSysValueRuleIdDirty();
            }
            case 50: {
                return pSDEFSFItemBase.isPSSysValueRuleNameDirty();
            }
            case 51: {
                return pSDEFSFItemBase.isRefADPSDELogicIdDirty();
            }
            case 52: {
                return pSDEFSFItemBase.isRefADPSDELogicNameDirty();
            }
            case 53: {
                return pSDEFSFItemBase.isRefMobMPickupPSDEViewIdDirty();
            }
            case 54: {
                return pSDEFSFItemBase.isRefMobMPickupPSDEViewNameDirty();
            }
            case 55: {
                return pSDEFSFItemBase.isRefMobPickupPSDEViewIdDirty();
            }
            case 56: {
                return pSDEFSFItemBase.isRefMobPickupPSDEViewNameDirty();
            }
            case 57: {
                return pSDEFSFItemBase.isRefMPickupPSDEViewIdDirty();
            }
            case 58: {
                return pSDEFSFItemBase.isRefMPickupPSDEViewNameDirty();
            }
            case 59: {
                return pSDEFSFItemBase.isRefPickupPSDEViewIdDirty();
            }
            case 60: {
                return pSDEFSFItemBase.isRefPickupPSDEViewNameDirty();
            }
            case 61: {
                return pSDEFSFItemBase.isRefPSDEACModeIdDirty();
            }
            case 62: {
                return pSDEFSFItemBase.isRefPSDEACModeNameDirty();
            }
            case 63: {
                return pSDEFSFItemBase.isRefPSDEDataSetIdDirty();
            }
            case 64: {
                return pSDEFSFItemBase.isRefPSDEDataSetNameDirty();
            }
            case 65: {
                return pSDEFSFItemBase.isRefPSDEIdDirty();
            }
            case 66: {
                return pSDEFSFItemBase.isRefPSDENameDirty();
            }
            case 67: {
                return pSDEFSFItemBase.isRefPSDERIdDirty();
            }
            case 68: {
                return pSDEFSFItemBase.isRefPSDERNameDirty();
            }
            case 69: {
                return pSDEFSFItemBase.isSearchModeDirty();
            }
            case 70: {
                return pSDEFSFItemBase.isServiceCodeNameDirty();
            }
            case 71: {
                return pSDEFSFItemBase.isUpdateDateDirty();
            }
            case 72: {
                return pSDEFSFItemBase.isUpdateManDirty();
            }
            case 73: {
                return pSDEFSFItemBase.isUserCatDirty();
            }
            case 74: {
                return pSDEFSFItemBase.isUserParamsDirty();
            }
            case 75: {
                return pSDEFSFItemBase.isUserTagDirty();
            }
            case 76: {
                return pSDEFSFItemBase.isUserTag2Dirty();
            }
            case 77: {
                return pSDEFSFItemBase.isUserTag3Dirty();
            }
            case 78: {
                return pSDEFSFItemBase.isUserTag4Dirty();
            }
            case 79: {
                return pSDEFSFItemBase.isValueFormatDirty();
            }
            case 80: {
                return pSDEFSFItemBase.isValueSeperatorDirty();
            }
            case 81: {
                return pSDEFSFItemBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFSFItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFSFItemBase pSDEFSFItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFSFItemBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getDstPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getDstPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getDstPSDEFSFItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefsfitemid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getDstPSDEFSFItemId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getDstPSDEFSFItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefsfitemname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getDstPSDEFSFItemName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getDstPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getDstPSDEId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getEditorType()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortypename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getEditorTypeName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getHeight()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getItemTag()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getJsonFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsonformat", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getJsonFormat()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getO2MPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"o2mpsderid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getO2MPSDERId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getO2OPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"o2opsderid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getO2OPSDERId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPHPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPHPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPHPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPHPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPlaceHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placeholder", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPlaceHolder()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEFSFItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEFSFItemId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEFSFItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEFSFItemName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEFValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvalueruleid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEFValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEFValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEFValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysDBVFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysDBVFId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysDBVFName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refadpsdelogicid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefADPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refadpsdelogicname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefADPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefMobMPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmobmpickuppsdeviewid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefMobMPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefMobMPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmobmpickuppsdeviewname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefMobMPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefMobPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmobpickuppsdeviewid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefMobPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefMobPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmobpickuppsdeviewname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefMobPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefMPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmpickuppsdeviewid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefMPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefMPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmpickuppsdeviewname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefMPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpickuppsdeviewid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpickuppsdeviewname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodeid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetname", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsderid", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDERId()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getRefPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdername", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getRefPSDERName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getSearchMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmode", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getSearchMode()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getValueSeperator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueseperator", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getValueSeperator()), (boolean)false);
        }
        if (bl || pSDEFSFItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEFSFItemBase.getJSONValue((Object)pSDEFSFItemBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFSFItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFSFItemBase pSDEFSFItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFSFItemBase.getArrayFlag() != null) {
            object = pSDEFSFItemBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFSFItemBase.getCapPSLanResId() != null) {
            object = pSDEFSFItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getCapPSLanResName() != null) {
            object = pSDEFSFItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getCaption() != null) {
            object = pSDEFSFItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getCodeName() != null) {
            object = pSDEFSFItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getCreateDate() != null) {
            object = pSDEFSFItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFSFItemBase.getCreateMan() != null) {
            object = pSDEFSFItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getDefaultFlag() != null) {
            object = pSDEFSFItemBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFSFItemBase.getDstPSDEFId() != null) {
            object = pSDEFSFItemBase.getDstPSDEFId();
            xmlNode.setAttribute(FIELD_DSTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getDstPSDEFSFItemId() != null) {
            object = pSDEFSFItemBase.getDstPSDEFSFItemId();
            xmlNode.setAttribute(FIELD_DSTPSDEFSFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getDstPSDEFSFItemName() != null) {
            object = pSDEFSFItemBase.getDstPSDEFSFItemName();
            xmlNode.setAttribute(FIELD_DSTPSDEFSFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getDstPSDEId() != null) {
            object = pSDEFSFItemBase.getDstPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getEditorType() != null) {
            object = pSDEFSFItemBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getEditorTypeName() != null) {
            object = pSDEFSFItemBase.getEditorTypeName();
            xmlNode.setAttribute(FIELD_EDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getExtendMode() != null) {
            object = pSDEFSFItemBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFSFItemBase.getHeight() != null) {
            object = pSDEFSFItemBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFSFItemBase.getItemTag() != null) {
            object = pSDEFSFItemBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getItemTag2() != null) {
            object = pSDEFSFItemBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getJsonFormat() != null) {
            object = pSDEFSFItemBase.getJsonFormat();
            xmlNode.setAttribute(FIELD_JSONFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getLockFlag() != null) {
            object = pSDEFSFItemBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFSFItemBase.getLogicName() != null) {
            object = pSDEFSFItemBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getMemo() != null) {
            object = pSDEFSFItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getO2MPSDERId() != null) {
            object = pSDEFSFItemBase.getO2MPSDERId();
            xmlNode.setAttribute(FIELD_O2MPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getO2OPSDERId() != null) {
            object = pSDEFSFItemBase.getO2OPSDERId();
            xmlNode.setAttribute(FIELD_O2OPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPHPSLanResId() != null) {
            object = pSDEFSFItemBase.getPHPSLanResId();
            xmlNode.setAttribute(FIELD_PHPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPHPSLanResName() != null) {
            object = pSDEFSFItemBase.getPHPSLanResName();
            xmlNode.setAttribute(FIELD_PHPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPlaceHolder() != null) {
            object = pSDEFSFItemBase.getPlaceHolder();
            xmlNode.setAttribute(FIELD_PLACEHOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSCodeListId() != null) {
            object = pSDEFSFItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSCodeListName() != null) {
            object = pSDEFSFItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDBValueOPId() != null) {
            object = pSDEFSFItemBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDBValueOPName() != null) {
            object = pSDEFSFItemBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEFId() != null) {
            object = pSDEFSFItemBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEFName() != null) {
            object = pSDEFSFItemBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEFSFItemId() != null) {
            object = pSDEFSFItemBase.getPSDEFSFItemId();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEFSFItemName() != null) {
            object = pSDEFSFItemBase.getPSDEFSFItemName();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEFValueRuleId() != null) {
            object = pSDEFSFItemBase.getPSDEFValueRuleId();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEFValueRuleName() != null) {
            object = pSDEFSFItemBase.getPSDEFValueRuleName();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEId() != null) {
            object = pSDEFSFItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSDEName() != null) {
            object = pSDEFSFItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysDBVFId() != null) {
            object = pSDEFSFItemBase.getPSSysDBVFId();
            xmlNode.setAttribute(FIELD_PSSYSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysDBVFName() != null) {
            object = pSDEFSFItemBase.getPSSysDBVFName();
            xmlNode.setAttribute(FIELD_PSSYSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysEditorStyleId() != null) {
            object = pSDEFSFItemBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysEditorStyleName() != null) {
            object = pSDEFSFItemBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysImageId() != null) {
            object = pSDEFSFItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysImageName() != null) {
            object = pSDEFSFItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysSFPluginId() != null) {
            object = pSDEFSFItemBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysSFPluginName() != null) {
            object = pSDEFSFItemBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysTranslatorId() != null) {
            object = pSDEFSFItemBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysTranslatorName() != null) {
            object = pSDEFSFItemBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysValueRuleId() != null) {
            object = pSDEFSFItemBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getPSSysValueRuleName() != null) {
            object = pSDEFSFItemBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefADPSDELogicId() != null) {
            object = pSDEFSFItemBase.getRefADPSDELogicId();
            xmlNode.setAttribute(FIELD_REFADPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefADPSDELogicName() != null) {
            object = pSDEFSFItemBase.getRefADPSDELogicName();
            xmlNode.setAttribute(FIELD_REFADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefMobMPickupPSDEViewId() != null) {
            object = pSDEFSFItemBase.getRefMobMPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_REFMOBMPICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefMobMPickupPSDEViewName() != null) {
            object = pSDEFSFItemBase.getRefMobMPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_REFMOBMPICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefMobPickupPSDEViewId() != null) {
            object = pSDEFSFItemBase.getRefMobPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_REFMOBPICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefMobPickupPSDEViewName() != null) {
            object = pSDEFSFItemBase.getRefMobPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_REFMOBPICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefMPickupPSDEViewId() != null) {
            object = pSDEFSFItemBase.getRefMPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_REFMPICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefMPickupPSDEViewName() != null) {
            object = pSDEFSFItemBase.getRefMPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_REFMPICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPickupPSDEViewId() != null) {
            object = pSDEFSFItemBase.getRefPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_REFPICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPickupPSDEViewName() != null) {
            object = pSDEFSFItemBase.getRefPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_REFPICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEACModeId() != null) {
            object = pSDEFSFItemBase.getRefPSDEACModeId();
            xmlNode.setAttribute(FIELD_REFPSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEACModeName() != null) {
            object = pSDEFSFItemBase.getRefPSDEACModeName();
            xmlNode.setAttribute(FIELD_REFPSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEDataSetId() != null) {
            object = pSDEFSFItemBase.getRefPSDEDataSetId();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEDataSetName() != null) {
            object = pSDEFSFItemBase.getRefPSDEDataSetName();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEId() != null) {
            object = pSDEFSFItemBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDEName() != null) {
            object = pSDEFSFItemBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDERId() != null) {
            object = pSDEFSFItemBase.getRefPSDERId();
            xmlNode.setAttribute(FIELD_REFPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getRefPSDERName() != null) {
            object = pSDEFSFItemBase.getRefPSDERName();
            xmlNode.setAttribute(FIELD_REFPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getSearchMode() != null) {
            object = pSDEFSFItemBase.getSearchMode();
            xmlNode.setAttribute(FIELD_SEARCHMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getServiceCodeName() != null) {
            object = pSDEFSFItemBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getUpdateDate() != null) {
            object = pSDEFSFItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFSFItemBase.getUpdateMan() != null) {
            object = pSDEFSFItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getUserCat() != null) {
            object = pSDEFSFItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getUserParams() != null) {
            object = pSDEFSFItemBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getUserTag() != null) {
            object = pSDEFSFItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getUserTag2() != null) {
            object = pSDEFSFItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getUserTag3() != null) {
            object = pSDEFSFItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getUserTag4() != null) {
            object = pSDEFSFItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getValueFormat() != null) {
            object = pSDEFSFItemBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getValueSeperator() != null) {
            object = pSDEFSFItemBase.getValueSeperator();
            xmlNode.setAttribute(FIELD_VALUESEPERATOR, object == null ? "" : (String)object);
        }
        if (bl || pSDEFSFItemBase.getWidth() != null) {
            object = pSDEFSFItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFSFItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFSFItemBase pSDEFSFItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFSFItemBase.isArrayFlagDirty() && (bl || pSDEFSFItemBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSDEFSFItemBase.getArrayFlag());
        }
        if (pSDEFSFItemBase.isCapPSLanResIdDirty() && (bl || pSDEFSFItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEFSFItemBase.getCapPSLanResId());
        }
        if (pSDEFSFItemBase.isCapPSLanResNameDirty() && (bl || pSDEFSFItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEFSFItemBase.getCapPSLanResName());
        }
        if (pSDEFSFItemBase.isCaptionDirty() && (bl || pSDEFSFItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEFSFItemBase.getCaption());
        }
        if (pSDEFSFItemBase.isCodeNameDirty() && (bl || pSDEFSFItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFSFItemBase.getCodeName());
        }
        if (pSDEFSFItemBase.isCreateDateDirty() && (bl || pSDEFSFItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFSFItemBase.getCreateDate());
        }
        if (pSDEFSFItemBase.isCreateManDirty() && (bl || pSDEFSFItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFSFItemBase.getCreateMan());
        }
        if (pSDEFSFItemBase.isDefaultFlagDirty() && (bl || pSDEFSFItemBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEFSFItemBase.getDefaultFlag());
        }
        if (pSDEFSFItemBase.isDstPSDEFIdDirty() && (bl || pSDEFSFItemBase.getDstPSDEFId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFID, (Object)pSDEFSFItemBase.getDstPSDEFId());
        }
        if (pSDEFSFItemBase.isDstPSDEFSFItemIdDirty() && (bl || pSDEFSFItemBase.getDstPSDEFSFItemId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFSFITEMID, (Object)pSDEFSFItemBase.getDstPSDEFSFItemId());
        }
        if (pSDEFSFItemBase.isDstPSDEFSFItemNameDirty() && (bl || pSDEFSFItemBase.getDstPSDEFSFItemName() != null)) {
            iDataObject.set(FIELD_DSTPSDEFSFITEMNAME, (Object)pSDEFSFItemBase.getDstPSDEFSFItemName());
        }
        if (pSDEFSFItemBase.isDstPSDEIdDirty() && (bl || pSDEFSFItemBase.getDstPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSDEFSFItemBase.getDstPSDEId());
        }
        if (pSDEFSFItemBase.isEditorTypeDirty() && (bl || pSDEFSFItemBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSDEFSFItemBase.getEditorType());
        }
        if (pSDEFSFItemBase.isEditorTypeNameDirty() && (bl || pSDEFSFItemBase.getEditorTypeName() != null)) {
            iDataObject.set(FIELD_EDITORTYPENAME, (Object)pSDEFSFItemBase.getEditorTypeName());
        }
        if (pSDEFSFItemBase.isExtendModeDirty() && (bl || pSDEFSFItemBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDEFSFItemBase.getExtendMode());
        }
        if (pSDEFSFItemBase.isHeightDirty() && (bl || pSDEFSFItemBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDEFSFItemBase.getHeight());
        }
        if (pSDEFSFItemBase.isItemTagDirty() && (bl || pSDEFSFItemBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSDEFSFItemBase.getItemTag());
        }
        if (pSDEFSFItemBase.isItemTag2Dirty() && (bl || pSDEFSFItemBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSDEFSFItemBase.getItemTag2());
        }
        if (pSDEFSFItemBase.isJsonFormatDirty() && (bl || pSDEFSFItemBase.getJsonFormat() != null)) {
            iDataObject.set(FIELD_JSONFORMAT, (Object)pSDEFSFItemBase.getJsonFormat());
        }
        if (pSDEFSFItemBase.isLockFlagDirty() && (bl || pSDEFSFItemBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEFSFItemBase.getLockFlag());
        }
        if (pSDEFSFItemBase.isLogicNameDirty() && (bl || pSDEFSFItemBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEFSFItemBase.getLogicName());
        }
        if (pSDEFSFItemBase.isMemoDirty() && (bl || pSDEFSFItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFSFItemBase.getMemo());
        }
        if (pSDEFSFItemBase.isO2MPSDERIdDirty() && (bl || pSDEFSFItemBase.getO2MPSDERId() != null)) {
            iDataObject.set(FIELD_O2MPSDERID, (Object)pSDEFSFItemBase.getO2MPSDERId());
        }
        if (pSDEFSFItemBase.isO2OPSDERIdDirty() && (bl || pSDEFSFItemBase.getO2OPSDERId() != null)) {
            iDataObject.set(FIELD_O2OPSDERID, (Object)pSDEFSFItemBase.getO2OPSDERId());
        }
        if (pSDEFSFItemBase.isPHPSLanResIdDirty() && (bl || pSDEFSFItemBase.getPHPSLanResId() != null)) {
            iDataObject.set(FIELD_PHPSLANRESID, (Object)pSDEFSFItemBase.getPHPSLanResId());
        }
        if (pSDEFSFItemBase.isPHPSLanResNameDirty() && (bl || pSDEFSFItemBase.getPHPSLanResName() != null)) {
            iDataObject.set(FIELD_PHPSLANRESNAME, (Object)pSDEFSFItemBase.getPHPSLanResName());
        }
        if (pSDEFSFItemBase.isPlaceHolderDirty() && (bl || pSDEFSFItemBase.getPlaceHolder() != null)) {
            iDataObject.set(FIELD_PLACEHOLDER, (Object)pSDEFSFItemBase.getPlaceHolder());
        }
        if (pSDEFSFItemBase.isPSCodeListIdDirty() && (bl || pSDEFSFItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEFSFItemBase.getPSCodeListId());
        }
        if (pSDEFSFItemBase.isPSCodeListNameDirty() && (bl || pSDEFSFItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEFSFItemBase.getPSCodeListName());
        }
        if (pSDEFSFItemBase.isPSDBValueOPIdDirty() && (bl || pSDEFSFItemBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSDEFSFItemBase.getPSDBValueOPId());
        }
        if (pSDEFSFItemBase.isPSDBValueOPNameDirty() && (bl || pSDEFSFItemBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSDEFSFItemBase.getPSDBValueOPName());
        }
        if (pSDEFSFItemBase.isPSDEFIdDirty() && (bl || pSDEFSFItemBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFSFItemBase.getPSDEFId());
        }
        if (pSDEFSFItemBase.isPSDEFNameDirty() && (bl || pSDEFSFItemBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFSFItemBase.getPSDEFName());
        }
        if (pSDEFSFItemBase.isPSDEFSFItemIdDirty() && (bl || pSDEFSFItemBase.getPSDEFSFItemId() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMID, (Object)pSDEFSFItemBase.getPSDEFSFItemId());
        }
        if (pSDEFSFItemBase.isPSDEFSFItemNameDirty() && (bl || pSDEFSFItemBase.getPSDEFSFItemName() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMNAME, (Object)pSDEFSFItemBase.getPSDEFSFItemName());
        }
        if (pSDEFSFItemBase.isPSDEFValueRuleIdDirty() && (bl || pSDEFSFItemBase.getPSDEFValueRuleId() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULEID, (Object)pSDEFSFItemBase.getPSDEFValueRuleId());
        }
        if (pSDEFSFItemBase.isPSDEFValueRuleNameDirty() && (bl || pSDEFSFItemBase.getPSDEFValueRuleName() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULENAME, (Object)pSDEFSFItemBase.getPSDEFValueRuleName());
        }
        if (pSDEFSFItemBase.isPSDEIdDirty() && (bl || pSDEFSFItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFSFItemBase.getPSDEId());
        }
        if (pSDEFSFItemBase.isPSDENameDirty() && (bl || pSDEFSFItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFSFItemBase.getPSDEName());
        }
        if (pSDEFSFItemBase.isPSSysDBVFIdDirty() && (bl || pSDEFSFItemBase.getPSSysDBVFId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFID, (Object)pSDEFSFItemBase.getPSSysDBVFId());
        }
        if (pSDEFSFItemBase.isPSSysDBVFNameDirty() && (bl || pSDEFSFItemBase.getPSSysDBVFName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFNAME, (Object)pSDEFSFItemBase.getPSSysDBVFName());
        }
        if (pSDEFSFItemBase.isPSSysEditorStyleIdDirty() && (bl || pSDEFSFItemBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSDEFSFItemBase.getPSSysEditorStyleId());
        }
        if (pSDEFSFItemBase.isPSSysEditorStyleNameDirty() && (bl || pSDEFSFItemBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSDEFSFItemBase.getPSSysEditorStyleName());
        }
        if (pSDEFSFItemBase.isPSSysImageIdDirty() && (bl || pSDEFSFItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEFSFItemBase.getPSSysImageId());
        }
        if (pSDEFSFItemBase.isPSSysImageNameDirty() && (bl || pSDEFSFItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEFSFItemBase.getPSSysImageName());
        }
        if (pSDEFSFItemBase.isPSSysSFPluginIdDirty() && (bl || pSDEFSFItemBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEFSFItemBase.getPSSysSFPluginId());
        }
        if (pSDEFSFItemBase.isPSSysSFPluginNameDirty() && (bl || pSDEFSFItemBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEFSFItemBase.getPSSysSFPluginName());
        }
        if (pSDEFSFItemBase.isPSSysTranslatorIdDirty() && (bl || pSDEFSFItemBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSDEFSFItemBase.getPSSysTranslatorId());
        }
        if (pSDEFSFItemBase.isPSSysTranslatorNameDirty() && (bl || pSDEFSFItemBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSDEFSFItemBase.getPSSysTranslatorName());
        }
        if (pSDEFSFItemBase.isPSSysValueRuleIdDirty() && (bl || pSDEFSFItemBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEFSFItemBase.getPSSysValueRuleId());
        }
        if (pSDEFSFItemBase.isPSSysValueRuleNameDirty() && (bl || pSDEFSFItemBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEFSFItemBase.getPSSysValueRuleName());
        }
        if (pSDEFSFItemBase.isRefADPSDELogicIdDirty() && (bl || pSDEFSFItemBase.getRefADPSDELogicId() != null)) {
            iDataObject.set(FIELD_REFADPSDELOGICID, (Object)pSDEFSFItemBase.getRefADPSDELogicId());
        }
        if (pSDEFSFItemBase.isRefADPSDELogicNameDirty() && (bl || pSDEFSFItemBase.getRefADPSDELogicName() != null)) {
            iDataObject.set(FIELD_REFADPSDELOGICNAME, (Object)pSDEFSFItemBase.getRefADPSDELogicName());
        }
        if (pSDEFSFItemBase.isRefMobMPickupPSDEViewIdDirty() && (bl || pSDEFSFItemBase.getRefMobMPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFMOBMPICKUPPSDEVIEWID, (Object)pSDEFSFItemBase.getRefMobMPickupPSDEViewId());
        }
        if (pSDEFSFItemBase.isRefMobMPickupPSDEViewNameDirty() && (bl || pSDEFSFItemBase.getRefMobMPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFMOBMPICKUPPSDEVIEWNAME, (Object)pSDEFSFItemBase.getRefMobMPickupPSDEViewName());
        }
        if (pSDEFSFItemBase.isRefMobPickupPSDEViewIdDirty() && (bl || pSDEFSFItemBase.getRefMobPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFMOBPICKUPPSDEVIEWID, (Object)pSDEFSFItemBase.getRefMobPickupPSDEViewId());
        }
        if (pSDEFSFItemBase.isRefMobPickupPSDEViewNameDirty() && (bl || pSDEFSFItemBase.getRefMobPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFMOBPICKUPPSDEVIEWNAME, (Object)pSDEFSFItemBase.getRefMobPickupPSDEViewName());
        }
        if (pSDEFSFItemBase.isRefMPickupPSDEViewIdDirty() && (bl || pSDEFSFItemBase.getRefMPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFMPICKUPPSDEVIEWID, (Object)pSDEFSFItemBase.getRefMPickupPSDEViewId());
        }
        if (pSDEFSFItemBase.isRefMPickupPSDEViewNameDirty() && (bl || pSDEFSFItemBase.getRefMPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFMPICKUPPSDEVIEWNAME, (Object)pSDEFSFItemBase.getRefMPickupPSDEViewName());
        }
        if (pSDEFSFItemBase.isRefPickupPSDEViewIdDirty() && (bl || pSDEFSFItemBase.getRefPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFPICKUPPSDEVIEWID, (Object)pSDEFSFItemBase.getRefPickupPSDEViewId());
        }
        if (pSDEFSFItemBase.isRefPickupPSDEViewNameDirty() && (bl || pSDEFSFItemBase.getRefPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFPICKUPPSDEVIEWNAME, (Object)pSDEFSFItemBase.getRefPickupPSDEViewName());
        }
        if (pSDEFSFItemBase.isRefPSDEACModeIdDirty() && (bl || pSDEFSFItemBase.getRefPSDEACModeId() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODEID, (Object)pSDEFSFItemBase.getRefPSDEACModeId());
        }
        if (pSDEFSFItemBase.isRefPSDEACModeNameDirty() && (bl || pSDEFSFItemBase.getRefPSDEACModeName() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODENAME, (Object)pSDEFSFItemBase.getRefPSDEACModeName());
        }
        if (pSDEFSFItemBase.isRefPSDEDataSetIdDirty() && (bl || pSDEFSFItemBase.getRefPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETID, (Object)pSDEFSFItemBase.getRefPSDEDataSetId());
        }
        if (pSDEFSFItemBase.isRefPSDEDataSetNameDirty() && (bl || pSDEFSFItemBase.getRefPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETNAME, (Object)pSDEFSFItemBase.getRefPSDEDataSetName());
        }
        if (pSDEFSFItemBase.isRefPSDEIdDirty() && (bl || pSDEFSFItemBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSDEFSFItemBase.getRefPSDEId());
        }
        if (pSDEFSFItemBase.isRefPSDENameDirty() && (bl || pSDEFSFItemBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSDEFSFItemBase.getRefPSDEName());
        }
        if (pSDEFSFItemBase.isRefPSDERIdDirty() && (bl || pSDEFSFItemBase.getRefPSDERId() != null)) {
            iDataObject.set(FIELD_REFPSDERID, (Object)pSDEFSFItemBase.getRefPSDERId());
        }
        if (pSDEFSFItemBase.isRefPSDERNameDirty() && (bl || pSDEFSFItemBase.getRefPSDERName() != null)) {
            iDataObject.set(FIELD_REFPSDERNAME, (Object)pSDEFSFItemBase.getRefPSDERName());
        }
        if (pSDEFSFItemBase.isSearchModeDirty() && (bl || pSDEFSFItemBase.getSearchMode() != null)) {
            iDataObject.set(FIELD_SEARCHMODE, (Object)pSDEFSFItemBase.getSearchMode());
        }
        if (pSDEFSFItemBase.isServiceCodeNameDirty() && (bl || pSDEFSFItemBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSDEFSFItemBase.getServiceCodeName());
        }
        if (pSDEFSFItemBase.isUpdateDateDirty() && (bl || pSDEFSFItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFSFItemBase.getUpdateDate());
        }
        if (pSDEFSFItemBase.isUpdateManDirty() && (bl || pSDEFSFItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFSFItemBase.getUpdateMan());
        }
        if (pSDEFSFItemBase.isUserCatDirty() && (bl || pSDEFSFItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFSFItemBase.getUserCat());
        }
        if (pSDEFSFItemBase.isUserParamsDirty() && (bl || pSDEFSFItemBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEFSFItemBase.getUserParams());
        }
        if (pSDEFSFItemBase.isUserTagDirty() && (bl || pSDEFSFItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFSFItemBase.getUserTag());
        }
        if (pSDEFSFItemBase.isUserTag2Dirty() && (bl || pSDEFSFItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFSFItemBase.getUserTag2());
        }
        if (pSDEFSFItemBase.isUserTag3Dirty() && (bl || pSDEFSFItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFSFItemBase.getUserTag3());
        }
        if (pSDEFSFItemBase.isUserTag4Dirty() && (bl || pSDEFSFItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFSFItemBase.getUserTag4());
        }
        if (pSDEFSFItemBase.isValueFormatDirty() && (bl || pSDEFSFItemBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDEFSFItemBase.getValueFormat());
        }
        if (pSDEFSFItemBase.isValueSeperatorDirty() && (bl || pSDEFSFItemBase.getValueSeperator() != null)) {
            iDataObject.set(FIELD_VALUESEPERATOR, (Object)pSDEFSFItemBase.getValueSeperator());
        }
        if (pSDEFSFItemBase.isWidthDirty() && (bl || pSDEFSFItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEFSFItemBase.getWidth());
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
        return PSDEFSFItemBase.remove(this, n);
    }

    private static boolean remove(PSDEFSFItemBase pSDEFSFItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFSFItemBase.resetArrayFlag();
                return true;
            }
            case 1: {
                pSDEFSFItemBase.resetCapPSLanResId();
                return true;
            }
            case 2: {
                pSDEFSFItemBase.resetCapPSLanResName();
                return true;
            }
            case 3: {
                pSDEFSFItemBase.resetCaption();
                return true;
            }
            case 4: {
                pSDEFSFItemBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDEFSFItemBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDEFSFItemBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDEFSFItemBase.resetDefaultFlag();
                return true;
            }
            case 8: {
                pSDEFSFItemBase.resetDstPSDEFId();
                return true;
            }
            case 9: {
                pSDEFSFItemBase.resetDstPSDEFSFItemId();
                return true;
            }
            case 10: {
                pSDEFSFItemBase.resetDstPSDEFSFItemName();
                return true;
            }
            case 11: {
                pSDEFSFItemBase.resetDstPSDEId();
                return true;
            }
            case 12: {
                pSDEFSFItemBase.resetEditorType();
                return true;
            }
            case 13: {
                pSDEFSFItemBase.resetEditorTypeName();
                return true;
            }
            case 14: {
                pSDEFSFItemBase.resetExtendMode();
                return true;
            }
            case 15: {
                pSDEFSFItemBase.resetHeight();
                return true;
            }
            case 16: {
                pSDEFSFItemBase.resetItemTag();
                return true;
            }
            case 17: {
                pSDEFSFItemBase.resetItemTag2();
                return true;
            }
            case 18: {
                pSDEFSFItemBase.resetJsonFormat();
                return true;
            }
            case 19: {
                pSDEFSFItemBase.resetLockFlag();
                return true;
            }
            case 20: {
                pSDEFSFItemBase.resetLogicName();
                return true;
            }
            case 21: {
                pSDEFSFItemBase.resetMemo();
                return true;
            }
            case 22: {
                pSDEFSFItemBase.resetO2MPSDERId();
                return true;
            }
            case 23: {
                pSDEFSFItemBase.resetO2OPSDERId();
                return true;
            }
            case 24: {
                pSDEFSFItemBase.resetPHPSLanResId();
                return true;
            }
            case 25: {
                pSDEFSFItemBase.resetPHPSLanResName();
                return true;
            }
            case 26: {
                pSDEFSFItemBase.resetPlaceHolder();
                return true;
            }
            case 27: {
                pSDEFSFItemBase.resetPSCodeListId();
                return true;
            }
            case 28: {
                pSDEFSFItemBase.resetPSCodeListName();
                return true;
            }
            case 29: {
                pSDEFSFItemBase.resetPSDBValueOPId();
                return true;
            }
            case 30: {
                pSDEFSFItemBase.resetPSDBValueOPName();
                return true;
            }
            case 31: {
                pSDEFSFItemBase.resetPSDEFId();
                return true;
            }
            case 32: {
                pSDEFSFItemBase.resetPSDEFName();
                return true;
            }
            case 33: {
                pSDEFSFItemBase.resetPSDEFSFItemId();
                return true;
            }
            case 34: {
                pSDEFSFItemBase.resetPSDEFSFItemName();
                return true;
            }
            case 35: {
                pSDEFSFItemBase.resetPSDEFValueRuleId();
                return true;
            }
            case 36: {
                pSDEFSFItemBase.resetPSDEFValueRuleName();
                return true;
            }
            case 37: {
                pSDEFSFItemBase.resetPSDEId();
                return true;
            }
            case 38: {
                pSDEFSFItemBase.resetPSDEName();
                return true;
            }
            case 39: {
                pSDEFSFItemBase.resetPSSysDBVFId();
                return true;
            }
            case 40: {
                pSDEFSFItemBase.resetPSSysDBVFName();
                return true;
            }
            case 41: {
                pSDEFSFItemBase.resetPSSysEditorStyleId();
                return true;
            }
            case 42: {
                pSDEFSFItemBase.resetPSSysEditorStyleName();
                return true;
            }
            case 43: {
                pSDEFSFItemBase.resetPSSysImageId();
                return true;
            }
            case 44: {
                pSDEFSFItemBase.resetPSSysImageName();
                return true;
            }
            case 45: {
                pSDEFSFItemBase.resetPSSysSFPluginId();
                return true;
            }
            case 46: {
                pSDEFSFItemBase.resetPSSysSFPluginName();
                return true;
            }
            case 47: {
                pSDEFSFItemBase.resetPSSysTranslatorId();
                return true;
            }
            case 48: {
                pSDEFSFItemBase.resetPSSysTranslatorName();
                return true;
            }
            case 49: {
                pSDEFSFItemBase.resetPSSysValueRuleId();
                return true;
            }
            case 50: {
                pSDEFSFItemBase.resetPSSysValueRuleName();
                return true;
            }
            case 51: {
                pSDEFSFItemBase.resetRefADPSDELogicId();
                return true;
            }
            case 52: {
                pSDEFSFItemBase.resetRefADPSDELogicName();
                return true;
            }
            case 53: {
                pSDEFSFItemBase.resetRefMobMPickupPSDEViewId();
                return true;
            }
            case 54: {
                pSDEFSFItemBase.resetRefMobMPickupPSDEViewName();
                return true;
            }
            case 55: {
                pSDEFSFItemBase.resetRefMobPickupPSDEViewId();
                return true;
            }
            case 56: {
                pSDEFSFItemBase.resetRefMobPickupPSDEViewName();
                return true;
            }
            case 57: {
                pSDEFSFItemBase.resetRefMPickupPSDEViewId();
                return true;
            }
            case 58: {
                pSDEFSFItemBase.resetRefMPickupPSDEViewName();
                return true;
            }
            case 59: {
                pSDEFSFItemBase.resetRefPickupPSDEViewId();
                return true;
            }
            case 60: {
                pSDEFSFItemBase.resetRefPickupPSDEViewName();
                return true;
            }
            case 61: {
                pSDEFSFItemBase.resetRefPSDEACModeId();
                return true;
            }
            case 62: {
                pSDEFSFItemBase.resetRefPSDEACModeName();
                return true;
            }
            case 63: {
                pSDEFSFItemBase.resetRefPSDEDataSetId();
                return true;
            }
            case 64: {
                pSDEFSFItemBase.resetRefPSDEDataSetName();
                return true;
            }
            case 65: {
                pSDEFSFItemBase.resetRefPSDEId();
                return true;
            }
            case 66: {
                pSDEFSFItemBase.resetRefPSDEName();
                return true;
            }
            case 67: {
                pSDEFSFItemBase.resetRefPSDERId();
                return true;
            }
            case 68: {
                pSDEFSFItemBase.resetRefPSDERName();
                return true;
            }
            case 69: {
                pSDEFSFItemBase.resetSearchMode();
                return true;
            }
            case 70: {
                pSDEFSFItemBase.resetServiceCodeName();
                return true;
            }
            case 71: {
                pSDEFSFItemBase.resetUpdateDate();
                return true;
            }
            case 72: {
                pSDEFSFItemBase.resetUpdateMan();
                return true;
            }
            case 73: {
                pSDEFSFItemBase.resetUserCat();
                return true;
            }
            case 74: {
                pSDEFSFItemBase.resetUserParams();
                return true;
            }
            case 75: {
                pSDEFSFItemBase.resetUserTag();
                return true;
            }
            case 76: {
                pSDEFSFItemBase.resetUserTag2();
                return true;
            }
            case 77: {
                pSDEFSFItemBase.resetUserTag3();
                return true;
            }
            case 78: {
                pSDEFSFItemBase.resetUserTag4();
                return true;
            }
            case 79: {
                pSDEFSFItemBase.resetValueFormat();
                return true;
            }
            case 80: {
                pSDEFSFItemBase.resetValueSeperator();
                return true;
            }
            case 81: {
                pSDEFSFItemBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.refpsde = pSDataEntity;
            }
            return this.refpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueOP getPSDBValueOP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOP();
        }
        if (this.getPSDBValueOPId() == null) {
            return null;
        }
        Integer n = this.objPSDBValueOPLock;
        synchronized (n) {
            if (this.psdbvalueop != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBValueOPId(), (Object)this.psdbvalueop.getPSDBValueOPId()) != 0L) {
                this.psdbvalueop = null;
            }
            if (this.psdbvalueop == null) {
                PSDBValueOP pSDBValueOP = new PSDBValueOP();
                pSDBValueOP.setPSDBValueOPId(this.getPSDBValueOPId());
                PSDBValueOPService pSDBValueOPService = (PSDBValueOPService)ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueOPService.autoGet((IEntity)pSDBValueOP);
                this.psdbvalueop = pSDBValueOP;
            }
            return this.psdbvalueop;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEACMode getRefPSDEACMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEACMode();
        }
        if (this.getRefPSDEACModeId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEACModeLock;
        synchronized (n) {
            if (this.refpsdeacmode != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEACModeId(), (Object)this.refpsdeacmode.getPSDEACModeId()) != 0L) {
                this.refpsdeacmode = null;
            }
            if (this.refpsdeacmode == null) {
                PSDEACMode pSDEACMode = new PSDEACMode();
                pSDEACMode.setPSDEACModeId(this.getRefPSDEACModeId());
                PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEACModeService.autoGet((IEntity)pSDEACMode);
                this.refpsdeacmode = pSDEACMode;
            }
            return this.refpsdeacmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSet();
        }
        if (this.getRefPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEDataSetLock;
        synchronized (n) {
            if (this.refpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEDataSetId(), (Object)this.refpsdedataset.getPSDEDataSetId()) != 0L) {
                this.refpsdedataset = null;
            }
            if (this.refpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getRefPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.refpsdedataset = pSDEDataSet;
            }
            return this.refpsdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFSFItem getDstPSDEFSFItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFSFItem();
        }
        if (this.getDstPSDEFSFItemId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEFSFItemLock;
        synchronized (n) {
            if (this.dstpsdefsfitem != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEFSFItemId(), (Object)this.dstpsdefsfitem.getPSDEFSFItemId()) != 0L) {
                this.dstpsdefsfitem = null;
            }
            if (this.dstpsdefsfitem == null) {
                PSDEFSFItem pSDEFSFItem = new PSDEFSFItem();
                pSDEFSFItem.setPSDEFSFItemId(this.getDstPSDEFSFItemId());
                PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
                pSDEFSFItemService.autoGet((IEntity)pSDEFSFItem);
                this.dstpsdefsfitem = pSDEFSFItem;
            }
            return this.dstpsdefsfitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getPSDEFValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRule();
        }
        if (this.getPSDEFValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSDEFValueRuleLock;
        synchronized (n) {
            if (this.psdefvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFValueRuleId(), (Object)this.psdefvaluerule.getPSDEFValueRuleId()) != 0L) {
                this.psdefvaluerule = null;
            }
            if (this.psdefvaluerule == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFValueRuleId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet((IEntity)pSDEFValueRule);
                this.psdefvaluerule = pSDEFValueRule;
            }
            return this.psdefvaluerule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getRefADPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefADPSDELogic();
        }
        if (this.getRefADPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objRefADPSDELogicLock;
        synchronized (n) {
            if (this.refadpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getRefADPSDELogicId(), (Object)this.refadpsdelogic.getPSDELogicId()) != 0L) {
                this.refadpsdelogic = null;
            }
            if (this.refadpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getRefADPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.refadpsdelogic = pSDELogic;
            }
            return this.refadpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getRefPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDER();
        }
        if (this.getRefPSDERId() == null) {
            return null;
        }
        Integer n = this.objRefPSDERLock;
        synchronized (n) {
            if (this.refpsder != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDERId(), (Object)this.refpsder.getPSDERId()) != 0L) {
                this.refpsder = null;
            }
            if (this.refpsder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getRefPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.refpsder = pSDER;
            }
            return this.refpsder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefMobMPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMobMPickupPSDEView();
        }
        if (this.getRefMobMPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefMobMPickupPSDEViewLock;
        synchronized (n) {
            if (this.refmobmpickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefMobMPickupPSDEViewId(), (Object)this.refmobmpickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.refmobmpickuppsdeview = null;
            }
            if (this.refmobmpickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefMobMPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.refmobmpickuppsdeview = pSDEViewBase;
            }
            return this.refmobmpickuppsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefMobPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMobPickupPSDEView();
        }
        if (this.getRefMobPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefMobPickupPSDEViewLock;
        synchronized (n) {
            if (this.refmobpickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefMobPickupPSDEViewId(), (Object)this.refmobpickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.refmobpickuppsdeview = null;
            }
            if (this.refmobpickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefMobPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.refmobpickuppsdeview = pSDEViewBase;
            }
            return this.refmobpickuppsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefMPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMPickupPSDEView();
        }
        if (this.getRefMPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefMPickupPSDEViewLock;
        synchronized (n) {
            if (this.refmpickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefMPickupPSDEViewId(), (Object)this.refmpickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.refmpickuppsdeview = null;
            }
            if (this.refmpickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefMPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.refmpickuppsdeview = pSDEViewBase;
            }
            return this.refmpickuppsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefPickupPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPickupPSDEView();
        }
        if (this.getRefPickupPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefPickupPSDEViewLock;
        synchronized (n) {
            if (this.refpickuppsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefPickupPSDEViewId(), (Object)this.refpickuppsdeview.getPSDEViewBaseId()) != 0L) {
                this.refpickuppsdeview = null;
            }
            if (this.refpickuppsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefPickupPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.refpickuppsdeview = pSDEViewBase;
            }
            return this.refpickuppsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getPHPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPHPSLanRes();
        }
        if (this.getPHPSLanResId() == null) {
            return null;
        }
        Integer n = this.objPHPSLanResLock;
        synchronized (n) {
            if (this.phpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getPHPSLanResId(), (Object)this.phpslanres.getPSLanguageResId()) != 0L) {
                this.phpslanres = null;
            }
            if (this.phpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getPHPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.phpslanres = pSLanguageRes;
            }
            return this.phpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBVF getPSSysDBVF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVF();
        }
        if (this.getPSSysDBVFId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBVFLock;
        synchronized (n) {
            if (this.pssysdbvf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBVFId(), (Object)this.pssysdbvf.getPSSysDBVFId()) != 0L) {
                this.pssysdbvf = null;
            }
            if (this.pssysdbvf == null) {
                PSSysDBVF pSSysDBVF = new PSSysDBVF();
                pSSysDBVF.setPSSysDBVFId(this.getPSSysDBVFId());
                PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBVFService.autoGet((IEntity)pSSysDBVF);
                this.pssysdbvf = pSSysDBVF;
            }
            return this.pssysdbvf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEditorStyle getPSSysEditorStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEditorStyle();
        }
        if (this.getPSSysEditorStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSysEditorStyleLock;
        synchronized (n) {
            if (this.pssyseditorstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEditorStyleId(), (Object)this.pssyseditorstyle.getPSSysEditorStyleId()) != 0L) {
                this.pssyseditorstyle = null;
            }
            if (this.pssyseditorstyle == null) {
                PSSysEditorStyle pSSysEditorStyle = new PSSysEditorStyle();
                pSSysEditorStyle.setPSSysEditorStyleId(this.getPSSysEditorStyleId());
                PSSysEditorStyleService pSSysEditorStyleService = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSysEditorStyleService.autoGet((IEntity)pSSysEditorStyle);
                this.pssyseditorstyle = pSSysEditorStyle;
            }
            return this.pssyseditorstyle;
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
                pSSysImageService.autoGet((IEntity)pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
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
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRule();
        }
        if (this.getPSSysValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysValueRuleLock;
        synchronized (n) {
            if (this.pssysvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysValueRuleId(), (Object)this.pssysvaluerule.getPSSysValueRuleId()) != 0L) {
                this.pssysvaluerule = null;
            }
            if (this.pssysvaluerule == null) {
                PSSysValueRule pSSysValueRule = new PSSysValueRule();
                pSSysValueRule.setPSSysValueRuleId(this.getPSSysValueRuleId());
                PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysValueRuleService.autoGet((IEntity)pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    private PSDEFSFItemBase getProxyEntity() {
        return this.proxyPSDEFSFItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFSFItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFSFItemBase) {
            this.proxyPSDEFSFItemBase = (PSDEFSFItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARRAYFLAG, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 1);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 7);
        fieldIndexMap.put(FIELD_DSTPSDEFID, 8);
        fieldIndexMap.put(FIELD_DSTPSDEFSFITEMID, 9);
        fieldIndexMap.put(FIELD_DSTPSDEFSFITEMNAME, 10);
        fieldIndexMap.put(FIELD_DSTPSDEID, 11);
        fieldIndexMap.put(FIELD_EDITORTYPE, 12);
        fieldIndexMap.put(FIELD_EDITORTYPENAME, 13);
        fieldIndexMap.put(FIELD_EXTENDMODE, 14);
        fieldIndexMap.put(FIELD_HEIGHT, 15);
        fieldIndexMap.put(FIELD_ITEMTAG, 16);
        fieldIndexMap.put(FIELD_ITEMTAG2, 17);
        fieldIndexMap.put(FIELD_JSONFORMAT, 18);
        fieldIndexMap.put(FIELD_LOCKFLAG, 19);
        fieldIndexMap.put(FIELD_LOGICNAME, 20);
        fieldIndexMap.put(FIELD_MEMO, 21);
        fieldIndexMap.put(FIELD_O2MPSDERID, 22);
        fieldIndexMap.put(FIELD_O2OPSDERID, 23);
        fieldIndexMap.put(FIELD_PHPSLANRESID, 24);
        fieldIndexMap.put(FIELD_PHPSLANRESNAME, 25);
        fieldIndexMap.put(FIELD_PLACEHOLDER, 26);
        fieldIndexMap.put(FIELD_PSCODELISTID, 27);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 28);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 29);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 30);
        fieldIndexMap.put(FIELD_PSDEFID, 31);
        fieldIndexMap.put(FIELD_PSDEFNAME, 32);
        fieldIndexMap.put(FIELD_PSDEFSFITEMID, 33);
        fieldIndexMap.put(FIELD_PSDEFSFITEMNAME, 34);
        fieldIndexMap.put(FIELD_PSDEFVALUERULEID, 35);
        fieldIndexMap.put(FIELD_PSDEFVALUERULENAME, 36);
        fieldIndexMap.put(FIELD_PSDEID, 37);
        fieldIndexMap.put(FIELD_PSDENAME, 38);
        fieldIndexMap.put(FIELD_PSSYSDBVFID, 39);
        fieldIndexMap.put(FIELD_PSSYSDBVFNAME, 40);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 41);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 42);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 43);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 44);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 45);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 46);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 47);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 48);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 49);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 50);
        fieldIndexMap.put(FIELD_REFADPSDELOGICID, 51);
        fieldIndexMap.put(FIELD_REFADPSDELOGICNAME, 52);
        fieldIndexMap.put(FIELD_REFMOBMPICKUPPSDEVIEWID, 53);
        fieldIndexMap.put(FIELD_REFMOBMPICKUPPSDEVIEWNAME, 54);
        fieldIndexMap.put(FIELD_REFMOBPICKUPPSDEVIEWID, 55);
        fieldIndexMap.put(FIELD_REFMOBPICKUPPSDEVIEWNAME, 56);
        fieldIndexMap.put(FIELD_REFMPICKUPPSDEVIEWID, 57);
        fieldIndexMap.put(FIELD_REFMPICKUPPSDEVIEWNAME, 58);
        fieldIndexMap.put(FIELD_REFPICKUPPSDEVIEWID, 59);
        fieldIndexMap.put(FIELD_REFPICKUPPSDEVIEWNAME, 60);
        fieldIndexMap.put(FIELD_REFPSDEACMODEID, 61);
        fieldIndexMap.put(FIELD_REFPSDEACMODENAME, 62);
        fieldIndexMap.put(FIELD_REFPSDEDATASETID, 63);
        fieldIndexMap.put(FIELD_REFPSDEDATASETNAME, 64);
        fieldIndexMap.put(FIELD_REFPSDEID, 65);
        fieldIndexMap.put(FIELD_REFPSDENAME, 66);
        fieldIndexMap.put(FIELD_REFPSDERID, 67);
        fieldIndexMap.put(FIELD_REFPSDERNAME, 68);
        fieldIndexMap.put(FIELD_SEARCHMODE, 69);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 70);
        fieldIndexMap.put(FIELD_UPDATEDATE, 71);
        fieldIndexMap.put(FIELD_UPDATEMAN, 72);
        fieldIndexMap.put(FIELD_USERCAT, 73);
        fieldIndexMap.put(FIELD_USERPARAMS, 74);
        fieldIndexMap.put(FIELD_USERTAG, 75);
        fieldIndexMap.put(FIELD_USERTAG2, 76);
        fieldIndexMap.put(FIELD_USERTAG3, 77);
        fieldIndexMap.put(FIELD_USERTAG4, 78);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 79);
        fieldIndexMap.put(FIELD_VALUESEPERATOR, 80);
        fieldIndexMap.put(FIELD_WIDTH, 81);
    }
}

