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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRF;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFormDetailBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_BLANKLOGIC = "BLANKLOGIC";
    public static final String FIELD_BL_POS = "BL_POS";
    public static final String FIELD_BORDERSTYLE = "BORDERSTYLE";
    public static final String FIELD_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String FIELD_BUILDINACTION = "BUILDINACTION";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CHILD_COL_LG = "CHILD_COL_LG";
    public static final String FIELD_CHILD_COL_MD = "CHILD_COL_MD";
    public static final String FIELD_CHILD_COL_SM = "CHILD_COL_SM";
    public static final String FIELD_CHILD_COL_XS = "CHILD_COL_XS";
    public static final String FIELD_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String FIELD_COLALIGN = "COLALIGN";
    public static final String FIELD_COLID = "COLID";
    public static final String FIELD_COLMODEL = "COLMODEL";
    public static final String FIELD_COLSPAN = "COLSPAN";
    public static final String FIELD_COL_LG = "COL_LG";
    public static final String FIELD_COL_LG_OS = "COL_LG_OS";
    public static final String FIELD_COL_MD = "COL_MD";
    public static final String FIELD_COL_MD_OS = "COL_MD_OS";
    public static final String FIELD_COL_SM = "COL_SM";
    public static final String FIELD_COL_SM_OS = "COL_SM_OS";
    public static final String FIELD_COL_WIDTH = "COL_WIDTH";
    public static final String FIELD_COL_XS = "COL_XS";
    public static final String FIELD_COL_XS_OS = "COL_XS_OS";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CONVERTCITEXT = "CONVERTCITEXT";
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEDV = "CREATEDV";
    public static final String FIELD_CREATEDVT = "CREATEDVT";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSID = "CSSID";
    public static final String FIELD_CTRLCOLSPAN = "CTRLCOLSPAN";
    public static final String FIELD_CTRLDYNACLASS = "CTRLDYNACLASS";
    public static final String FIELD_CTRLHEIGHT = "CTRLHEIGHT";
    public static final String FIELD_CTRLPSSYSCSSID = "CTRLPSSYSCSSID";
    public static final String FIELD_CTRLPSSYSCSSNAME = "CTRLPSSYSCSSNAME";
    public static final String FIELD_CTRLRAWCSSSTYLE = "CTRLRAWCSSSTYLE";
    public static final String FIELD_CTRLWIDTH = "CTRLWIDTH";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DETAILSTYLE = "DETAILSTYLE";
    public static final String FIELD_DETAILSTYLETEXT = "DETAILSTYLETEXT";
    public static final String FIELD_DETAILTAG = "DETAILTAG";
    public static final String FIELD_DETAILTAG2 = "DETAILTAG2";
    public static final String FIELD_DETAILTYPE = "DETAILTYPE";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EDITORPARAMS = "EDITORPARAMS";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORTYPENAME = "EDITORTYPENAME";
    public static final String FIELD_EMPTYCAPTION = "EMPTYCAPTION";
    public static final String FIELD_ENABLEANCHOR = "ENABLEANCHOR";
    public static final String FIELD_ENABLECOND = "ENABLECOND";
    public static final String FIELD_ENABLEINPUTTIP = "ENABLEINPUTTIP";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_ENABLELOGIC = "ENABLELOGIC";
    public static final String FIELD_FIELDNAME = "FIELDNAME";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXBASIS = "FLEXBASIS";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXGROW = "FLEXGROW";
    public static final String FIELD_FLEXSHRINK = "FLEXSHRINK";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_FORMTYPE = "FORMTYPE";
    public static final String FIELD_GRIDROWID = "GRIDROWID";
    public static final String FIELD_HALIGN = "HALIGN";
    public static final String FIELD_HALIGNSELF = "HALIGNSELF";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HEIGHTMODE = "HEIGHTMODE";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String FIELD_ICONALIGN = "ICONALIGN";
    public static final String FIELD_IGNOREINPUT = "IGNOREINPUT";
    public static final String FIELD_INSERTPOS = "INSERTPOS";
    public static final String FIELD_ITEMPSACHANDLERID = "ITEMPSACHANDLERID";
    public static final String FIELD_ITEMPSACHANDLERNAME = "ITEMPSACHANDLERNAME";
    public static final String FIELD_ITEMSTATES = "ITEMSTATES";
    public static final String FIELD_LABELCOLSPAN = "LABELCOLSPAN";
    public static final String FIELD_LABELCOLSPAN2 = "LABELCOLSPAN2";
    public static final String FIELD_LABELCSSID = "LABELCSSID";
    public static final String FIELD_LABELDYNACLASS = "LABELDYNACLASS";
    public static final String FIELD_LABELPOS = "LABELPOS";
    public static final String FIELD_LABELPSSYSCSSID = "LABELPSSYSCSSID";
    public static final String FIELD_LABELPSSYSCSSNAME = "LABELPSSYSCSSNAME";
    public static final String FIELD_LABELRAWCSSSTYLE = "LABELRAWCSSSTYLE";
    public static final String FIELD_LABELWIDTH = "LABELWIDTH";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String FIELD_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MARGIN = "MARGIN";
    public static final String FIELD_MASKINFO = "MASKINFO";
    public static final String FIELD_MASKMODE = "MASKMODE";
    public static final String FIELD_MASKPSLANRESID = "MASKPSLANRESID";
    public static final String FIELD_MASKPSLANRESNAME = "MASKPSLANRESNAME";
    public static final String FIELD_MDCTRLTYPE = "MDCTRLTYPE";
    public static final String FIELD_MDPSDEDATAVIEWID = "MDPSDEDATAVIEWID";
    public static final String FIELD_MDPSDEDATAVIEWNAME = "MDPSDEDATAVIEWNAME";
    public static final String FIELD_MDPSDEFORMID = "MDPSDEFORMID";
    public static final String FIELD_MDPSDEFORMNAME = "MDPSDEFORMNAME";
    public static final String FIELD_MDPSDEGRIDID = "MDPSDEGRIDID";
    public static final String FIELD_MDPSDEGRIDNAME = "MDPSDEGRIDNAME";
    public static final String FIELD_MDPSDELISTID = "MDPSDELISTID";
    public static final String FIELD_MDPSDELISTNAME = "MDPSDELISTNAME";
    public static final String FIELD_MDPSSYSVIEWPANELID = "MDPSSYSVIEWPANELID";
    public static final String FIELD_MDPSSYSVIEWPANELNAME = "MDPSSYSVIEWPANELNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFLAG = "MOBFLAG";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String FIELD_NOPRIVDM = "NOPRIVDM";
    public static final String FIELD_OPENPSDEVIEWID = "OPENPSDEVIEWID";
    public static final String FIELD_OPENPSDEVIEWNAME = "OPENPSDEVIEWNAME";
    public static final String FIELD_OPENPSSYSPDTVIEWID = "OPENPSSYSPDTVIEWID";
    public static final String FIELD_OPENPSSYSPDTVIEWNAME = "OPENPSSYSPDTVIEWNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PADDING = "PADDING";
    public static final String FIELD_PHPSLANRESID = "PHPSLANRESID";
    public static final String FIELD_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String FIELD_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String FIELD_PLACEHOLDER = "PLACEHOLDER";
    public static final String FIELD_PLAYOUTMODE = "PLAYOUTMODE";
    public static final String FIELD_PPSDEFORMDETAILID = "PPSDEFORMDETAILID";
    public static final String FIELD_PPSDEFORMDETAILNAME = "PPSDEFORMDETAILNAME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREVENTXSS = "PREVENTXSS";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEDRID = "PSDEDRID";
    public static final String FIELD_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String FIELD_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String FIELD_PSDEDRNAME = "PSDEDRNAME";
    public static final String FIELD_PSDEFUIMODEID = "PSDEFFORMITEMID";
    public static final String FIELD_PSDEFUIMODENAME = "PSDEFFORMITEMNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFIUPDATEID = "PSDEFIUPDATEID";
    public static final String FIELD_PSDEFIUPDATENAME = "PSDEFIUPDATENAME";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String FIELD_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEFORMRFID = "PSDEFORMRFID";
    public static final String FIELD_PSDEFORMRFNAME = "PSDEFORMRFNAME";
    public static final String FIELD_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String FIELD_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String FIELD_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String FIELD_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String FIELD_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String FIELD_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String FIELD_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String FIELD_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String FIELD_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String FIELD_REFPSDEFORMDETAILID = "REFPSDEFORMDETAILID";
    public static final String FIELD_REFPSDEFORMDETAILNAME = "REFPSDEFORMDETAILNAME";
    public static final String FIELD_REFPSDEFORMID = "REFPSDEFORMID";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_REFPSDERID = "REFPSDERID";
    public static final String FIELD_REFPSDERNAME = "REFPSDERNAME";
    public static final String FIELD_RENDERMODE = "RENDERMODE";
    public static final String FIELD_RENDERMODETEXT = "RENDERMODETEXT";
    public static final String FIELD_RESETITEMNAME = "RESETITEMNAME";
    public static final String FIELD_ROWSPAN = "ROWSPAN";
    public static final String FIELD_SHOWCAPTION = "SHOWCAPTION";
    public static final String FIELD_SHOWMOREMODE = "SHOWMOREMODE";
    public static final String FIELD_SPACINGBOTTOM = "SPACINGBOTTOM";
    public static final String FIELD_SPACINGLEFT = "SPACINGLEFT";
    public static final String FIELD_SPACINGRIGHT = "SPACINGRIGHT";
    public static final String FIELD_SPACINGTOP = "SPACINGTOP";
    public static final String FIELD_SWAPMODE = "SWAPMODE";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String FIELD_TOGGLEMODE = "TOGGLEMODE";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UCPSSYSPFPLUGINID = "UCPSSYSPFPLUGINID";
    public static final String FIELD_UCPSSYSPFPLUGINNAME = "UCPSSYSPFPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEDV = "UPDATEDV";
    public static final String FIELD_UPDATEDVT = "UPDATEDVT";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIGN = "VALIGN";
    public static final String FIELD_VALIGNSELF = "VALIGNSELF";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String FIELD_VISIBLELOGIC = "VISIBLELOGIC";
    public static final String FIELD_WBDEFMODE = "WBDEFMODE";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_WIDTHMODE = "WIDTHMODE";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_BLANKLOGIC = 1;
    private static final int INDEX_BL_POS = 2;
    private static final int INDEX_BORDERSTYLE = 3;
    private static final int INDEX_BTNACTIONTYPE = 4;
    private static final int INDEX_BUILDINACTION = 5;
    private static final int INDEX_CAPPSLANRESID = 6;
    private static final int INDEX_CAPPSLANRESNAME = 7;
    private static final int INDEX_CAPTION = 8;
    private static final int INDEX_CHILD_COL_LG = 9;
    private static final int INDEX_CHILD_COL_MD = 10;
    private static final int INDEX_CHILD_COL_SM = 11;
    private static final int INDEX_CHILD_COL_XS = 12;
    private static final int INDEX_CODELISTCONFIGMODE = 13;
    private static final int INDEX_COLALIGN = 14;
    private static final int INDEX_COLID = 15;
    private static final int INDEX_COLMODEL = 16;
    private static final int INDEX_COLSPAN = 17;
    private static final int INDEX_COL_LG = 18;
    private static final int INDEX_COL_LG_OS = 19;
    private static final int INDEX_COL_MD = 20;
    private static final int INDEX_COL_MD_OS = 21;
    private static final int INDEX_COL_SM = 22;
    private static final int INDEX_COL_SM_OS = 23;
    private static final int INDEX_COL_WIDTH = 24;
    private static final int INDEX_COL_XS = 25;
    private static final int INDEX_COL_XS_OS = 26;
    private static final int INDEX_CONTENTTYPE = 27;
    private static final int INDEX_CONVERTCITEXT = 28;
    private static final int INDEX_COUNTERID = 29;
    private static final int INDEX_COUNTERMODE = 30;
    private static final int INDEX_CREATEDATE = 31;
    private static final int INDEX_CREATEDV = 32;
    private static final int INDEX_CREATEDVT = 33;
    private static final int INDEX_CREATEMAN = 34;
    private static final int INDEX_CSSID = 35;
    private static final int INDEX_CTRLCOLSPAN = 36;
    private static final int INDEX_CTRLDYNACLASS = 37;
    private static final int INDEX_CTRLHEIGHT = 38;
    private static final int INDEX_CTRLPSSYSCSSID = 39;
    private static final int INDEX_CTRLPSSYSCSSNAME = 40;
    private static final int INDEX_CTRLRAWCSSSTYLE = 41;
    private static final int INDEX_CTRLWIDTH = 42;
    private static final int INDEX_CUSTOMCODE = 43;
    private static final int INDEX_DATA = 44;
    private static final int INDEX_DEFAULTFLAG = 45;
    private static final int INDEX_DETAILSTYLE = 46;
    private static final int INDEX_DETAILSTYLETEXT = 47;
    private static final int INDEX_DETAILTAG = 48;
    private static final int INDEX_DETAILTAG2 = 49;
    private static final int INDEX_DETAILTYPE = 50;
    private static final int INDEX_DYNACLASS = 51;
    private static final int INDEX_DYNAMODELFLAG = 52;
    private static final int INDEX_EDITORPARAMS = 53;
    private static final int INDEX_EDITORTYPE = 54;
    private static final int INDEX_EDITORTYPENAME = 55;
    private static final int INDEX_EMPTYCAPTION = 56;
    private static final int INDEX_ENABLEANCHOR = 57;
    private static final int INDEX_ENABLECOND = 58;
    private static final int INDEX_ENABLEINPUTTIP = 59;
    private static final int INDEX_ENABLEITEMPRIV = 60;
    private static final int INDEX_ENABLELOGIC = 61;
    private static final int INDEX_FIELDNAME = 62;
    private static final int INDEX_FLEXALIGN = 63;
    private static final int INDEX_FLEXBASIS = 64;
    private static final int INDEX_FLEXDIR = 65;
    private static final int INDEX_FLEXGROW = 66;
    private static final int INDEX_FLEXSHRINK = 67;
    private static final int INDEX_FLEXVALIGN = 68;
    private static final int INDEX_FORMTYPE = 69;
    private static final int INDEX_GRIDROWID = 70;
    private static final int INDEX_HALIGN = 71;
    private static final int INDEX_HALIGNSELF = 72;
    private static final int INDEX_HEIGHT = 73;
    private static final int INDEX_HEIGHTMODE = 74;
    private static final int INDEX_HTMLCONTENT = 75;
    private static final int INDEX_HTMLPAGEURL = 76;
    private static final int INDEX_ICONALIGN = 77;
    private static final int INDEX_IGNOREINPUT = 78;
    private static final int INDEX_INSERTPOS = 79;
    private static final int INDEX_ITEMPSACHANDLERID = 80;
    private static final int INDEX_ITEMPSACHANDLERNAME = 81;
    private static final int INDEX_ITEMSTATES = 82;
    private static final int INDEX_LABELCOLSPAN = 83;
    private static final int INDEX_LABELCOLSPAN2 = 84;
    private static final int INDEX_LABELCSSID = 85;
    private static final int INDEX_LABELDYNACLASS = 86;
    private static final int INDEX_LABELPOS = 87;
    private static final int INDEX_LABELPSSYSCSSID = 88;
    private static final int INDEX_LABELPSSYSCSSNAME = 89;
    private static final int INDEX_LABELRAWCSSSTYLE = 90;
    private static final int INDEX_LABELWIDTH = 91;
    private static final int INDEX_LAYOUTMODE = 92;
    private static final int INDEX_LEVELTAG = 93;
    private static final int INDEX_LEVELVALUE = 94;
    private static final int INDEX_LINKPSDEVIEWID = 95;
    private static final int INDEX_LINKPSDEVIEWNAME = 96;
    private static final int INDEX_LOGICNAME = 97;
    private static final int INDEX_MARGIN = 98;
    private static final int INDEX_MASKINFO = 99;
    private static final int INDEX_MASKMODE = 100;
    private static final int INDEX_MASKPSLANRESID = 101;
    private static final int INDEX_MASKPSLANRESNAME = 102;
    private static final int INDEX_MDCTRLTYPE = 103;
    private static final int INDEX_MDPSDEDATAVIEWID = 104;
    private static final int INDEX_MDPSDEDATAVIEWNAME = 105;
    private static final int INDEX_MDPSDEFORMID = 106;
    private static final int INDEX_MDPSDEFORMNAME = 107;
    private static final int INDEX_MDPSDEGRIDID = 108;
    private static final int INDEX_MDPSDEGRIDNAME = 109;
    private static final int INDEX_MDPSDELISTID = 110;
    private static final int INDEX_MDPSDELISTNAME = 111;
    private static final int INDEX_MDPSSYSVIEWPANELID = 112;
    private static final int INDEX_MDPSSYSVIEWPANELNAME = 113;
    private static final int INDEX_MEMO = 114;
    private static final int INDEX_MOBFLAG = 115;
    private static final int INDEX_MODELSTATE = 116;
    private static final int INDEX_NEEDCODELISTCONFIG = 117;
    private static final int INDEX_NOPRIVDM = 118;
    private static final int INDEX_OPENPSDEVIEWID = 119;
    private static final int INDEX_OPENPSDEVIEWNAME = 120;
    private static final int INDEX_OPENPSSYSPDTVIEWID = 121;
    private static final int INDEX_OPENPSSYSPDTVIEWNAME = 122;
    private static final int INDEX_ORDERVALUE = 123;
    private static final int INDEX_PADDING = 124;
    private static final int INDEX_PHPSLANRESID = 125;
    private static final int INDEX_PHPSLANRESNAME = 126;
    private static final int INDEX_PICKUPPSDEVIEWID = 127;
    private static final int INDEX_PICKUPPSDEVIEWNAME = 128;
    private static final int INDEX_PLACEHOLDER = 129;
    private static final int INDEX_PLAYOUTMODE = 130;
    private static final int INDEX_PPSDEFORMDETAILID = 131;
    private static final int INDEX_PPSDEFORMDETAILNAME = 132;
    private static final int INDEX_PREDEFINEDTYPE = 133;
    private static final int INDEX_PREDEFINEDTYPETEXT = 134;
    private static final int INDEX_PREVENTXSS = 135;
    private static final int INDEX_PREVIEWHTML = 136;
    private static final int INDEX_PSCODELISTID = 137;
    private static final int INDEX_PSCODELISTNAME = 138;
    private static final int INDEX_PSDEDRID = 139;
    private static final int INDEX_PSDEDRITEMID = 140;
    private static final int INDEX_PSDEDRITEMNAME = 141;
    private static final int INDEX_PSDEDRNAME = 142;
    private static final int INDEX_PSDEFUIMODEID = 143;
    private static final int INDEX_PSDEFUIMODENAME = 144;
    private static final int INDEX_PSDEFID = 145;
    private static final int INDEX_PSDEFIUPDATEID = 146;
    private static final int INDEX_PSDEFIUPDATENAME = 147;
    private static final int INDEX_PSDEFNAME = 148;
    private static final int INDEX_PSDEFORMDETAILID = 149;
    private static final int INDEX_PSDEFORMDETAILNAME = 150;
    private static final int INDEX_PSDEFORMID = 151;
    private static final int INDEX_PSDEFORMNAME = 152;
    private static final int INDEX_PSDEFORMRFID = 153;
    private static final int INDEX_PSDEFORMRFNAME = 154;
    private static final int INDEX_PSDEFSFITEMID = 155;
    private static final int INDEX_PSDEFSFITEMNAME = 156;
    private static final int INDEX_PSDEID = 157;
    private static final int INDEX_PSDELOGICID = 158;
    private static final int INDEX_PSDELOGICNAME = 159;
    private static final int INDEX_PSDEUAGROUPID = 160;
    private static final int INDEX_PSDEUAGROUPNAME = 161;
    private static final int INDEX_PSDEUIACTIONID = 162;
    private static final int INDEX_PSDEUIACTIONNAME = 163;
    private static final int INDEX_PSDYNAINSTID = 164;
    private static final int INDEX_PSSYSCOUNTERID = 165;
    private static final int INDEX_PSSYSCOUNTERNAME = 166;
    private static final int INDEX_PSSYSCSSID = 167;
    private static final int INDEX_PSSYSCSSNAME = 168;
    private static final int INDEX_PSSYSDICTCATID = 169;
    private static final int INDEX_PSSYSDICTCATNAME = 170;
    private static final int INDEX_PSSYSDYNAMODELID = 171;
    private static final int INDEX_PSSYSDYNAMODELNAME = 172;
    private static final int INDEX_PSSYSEDITORSTYLEID = 173;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 174;
    private static final int INDEX_PSSYSIMAGEID = 175;
    private static final int INDEX_PSSYSIMAGENAME = 176;
    private static final int INDEX_PSSYSRESOURCEID = 177;
    private static final int INDEX_PSSYSRESOURCENAME = 178;
    private static final int INDEX_RAWCONTENT = 179;
    private static final int INDEX_RAWCSSSTYLE = 180;
    private static final int INDEX_RAWSERVICEMETHOD = 181;
    private static final int INDEX_RAWSERVICEURL = 182;
    private static final int INDEX_REFPSDEACMODEID = 183;
    private static final int INDEX_REFPSDEACMODENAME = 184;
    private static final int INDEX_REFPSDEDATASETID = 185;
    private static final int INDEX_REFPSDEDATASETNAME = 186;
    private static final int INDEX_REFPSDEFORMDETAILID = 187;
    private static final int INDEX_REFPSDEFORMDETAILNAME = 188;
    private static final int INDEX_REFPSDEFORMID = 189;
    private static final int INDEX_REFPSDEID = 190;
    private static final int INDEX_REFPSDENAME = 191;
    private static final int INDEX_REFPSDERID = 192;
    private static final int INDEX_REFPSDERNAME = 193;
    private static final int INDEX_RENDERMODE = 194;
    private static final int INDEX_RENDERMODETEXT = 195;
    private static final int INDEX_RESETITEMNAME = 196;
    private static final int INDEX_ROWSPAN = 197;
    private static final int INDEX_SHOWCAPTION = 198;
    private static final int INDEX_SHOWMOREMODE = 199;
    private static final int INDEX_SPACINGBOTTOM = 200;
    private static final int INDEX_SPACINGLEFT = 201;
    private static final int INDEX_SPACINGRIGHT = 202;
    private static final int INDEX_SPACINGTOP = 203;
    private static final int INDEX_SWAPMODE = 204;
    private static final int INDEX_TEMPLATEMODE = 205;
    private static final int INDEX_TIPPSLANRESID = 206;
    private static final int INDEX_TIPPSLANRESNAME = 207;
    private static final int INDEX_TITLEBARCLOSEMODE = 208;
    private static final int INDEX_TOGGLEMODE = 209;
    private static final int INDEX_TOOLTIPINFO = 210;
    private static final int INDEX_UCPSSYSPFPLUGINID = 211;
    private static final int INDEX_UCPSSYSPFPLUGINNAME = 212;
    private static final int INDEX_UPDATEDATE = 213;
    private static final int INDEX_UPDATEDV = 214;
    private static final int INDEX_UPDATEDVT = 215;
    private static final int INDEX_UPDATEMAN = 216;
    private static final int INDEX_USERTAG = 217;
    private static final int INDEX_USERTAG2 = 218;
    private static final int INDEX_VALIGN = 219;
    private static final int INDEX_VALIGNSELF = 220;
    private static final int INDEX_VALUEFORMAT = 221;
    private static final int INDEX_VALUEITEMNAME = 222;
    private static final int INDEX_VISIBLELOGIC = 223;
    private static final int INDEX_WBDEFMODE = 224;
    private static final int INDEX_WIDTH = 225;
    private static final int INDEX_WIDTHMODE = 226;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFormDetailBase proxyPSDEFormDetailBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean blanklogicDirtyFlag = false;
    private boolean bl_posDirtyFlag = false;
    private boolean borderstyleDirtyFlag = false;
    private boolean btnactiontypeDirtyFlag = false;
    private boolean buildinactionDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean child_col_lgDirtyFlag = false;
    private boolean child_col_mdDirtyFlag = false;
    private boolean child_col_smDirtyFlag = false;
    private boolean child_col_xsDirtyFlag = false;
    private boolean codelistconfigmodeDirtyFlag = false;
    private boolean colalignDirtyFlag = false;
    private boolean colidDirtyFlag = false;
    private boolean colmodelDirtyFlag = false;
    private boolean colspanDirtyFlag = false;
    private boolean col_lgDirtyFlag = false;
    private boolean col_lg_osDirtyFlag = false;
    private boolean col_mdDirtyFlag = false;
    private boolean col_md_osDirtyFlag = false;
    private boolean col_smDirtyFlag = false;
    private boolean col_sm_osDirtyFlag = false;
    private boolean col_widthDirtyFlag = false;
    private boolean col_xsDirtyFlag = false;
    private boolean col_xs_osDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean convertcitextDirtyFlag = false;
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createdvDirtyFlag = false;
    private boolean createdvtDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssidDirtyFlag = false;
    private boolean ctrlcolspanDirtyFlag = false;
    private boolean ctrldynaclassDirtyFlag = false;
    private boolean ctrlheightDirtyFlag = false;
    private boolean ctrlpssyscssidDirtyFlag = false;
    private boolean ctrlpssyscssnameDirtyFlag = false;
    private boolean ctrlrawcssstyleDirtyFlag = false;
    private boolean ctrlwidthDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean detailstyleDirtyFlag = false;
    private boolean detailstyletextDirtyFlag = false;
    private boolean detailtagDirtyFlag = false;
    private boolean detailtag2DirtyFlag = false;
    private boolean detailtypeDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean editorparamsDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editortypenameDirtyFlag = false;
    private boolean emptycaptionDirtyFlag = false;
    private boolean enableanchorDirtyFlag = false;
    private boolean enablecondDirtyFlag = false;
    private boolean enableinputtipDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean enablelogicDirtyFlag = false;
    private boolean fieldnameDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexbasisDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexgrowDirtyFlag = false;
    private boolean flexshrinkDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean formtypeDirtyFlag = false;
    private boolean gridrowidDirtyFlag = false;
    private boolean halignDirtyFlag = false;
    private boolean halignselfDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean heightmodeDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean htmlpageurlDirtyFlag = false;
    private boolean iconalignDirtyFlag = false;
    private boolean ignoreinputDirtyFlag = false;
    private boolean insertposDirtyFlag = false;
    private boolean itempsachandleridDirtyFlag = false;
    private boolean itempsachandlernameDirtyFlag = false;
    private boolean itemstatesDirtyFlag = false;
    private boolean labelcolspanDirtyFlag = false;
    private boolean labelcolspan2DirtyFlag = false;
    private boolean labelcssidDirtyFlag = false;
    private boolean labeldynaclassDirtyFlag = false;
    private boolean labelposDirtyFlag = false;
    private boolean labelpssyscssidDirtyFlag = false;
    private boolean labelpssyscssnameDirtyFlag = false;
    private boolean labelrawcssstyleDirtyFlag = false;
    private boolean labelwidthDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean linkpsdeviewidDirtyFlag = false;
    private boolean linkpsdeviewnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean marginDirtyFlag = false;
    private boolean maskinfoDirtyFlag = false;
    private boolean maskmodeDirtyFlag = false;
    private boolean maskpslanresidDirtyFlag = false;
    private boolean maskpslanresnameDirtyFlag = false;
    private boolean mdctrltypeDirtyFlag = false;
    private boolean mdpsdedataviewidDirtyFlag = false;
    private boolean mdpsdedataviewnameDirtyFlag = false;
    private boolean mdpsdeformidDirtyFlag = false;
    private boolean mdpsdeformnameDirtyFlag = false;
    private boolean mdpsdegrididDirtyFlag = false;
    private boolean mdpsdegridnameDirtyFlag = false;
    private boolean mdpsdelistidDirtyFlag = false;
    private boolean mdpsdelistnameDirtyFlag = false;
    private boolean mdpssysviewpanelidDirtyFlag = false;
    private boolean mdpssysviewpanelnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobflagDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean needcodelistconfigDirtyFlag = false;
    private boolean noprivdmDirtyFlag = false;
    private boolean openpsdeviewidDirtyFlag = false;
    private boolean openpsdeviewnameDirtyFlag = false;
    private boolean openpssyspdtviewidDirtyFlag = false;
    private boolean openpssyspdtviewnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paddingDirtyFlag = false;
    private boolean phpslanresidDirtyFlag = false;
    private boolean phpslanresnameDirtyFlag = false;
    private boolean pickuppsdeviewidDirtyFlag = false;
    private boolean pickuppsdeviewnameDirtyFlag = false;
    private boolean placeholderDirtyFlag = false;
    private boolean playoutmodeDirtyFlag = false;
    private boolean ppsdeformdetailidDirtyFlag = false;
    private boolean ppsdeformdetailnameDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean preventxssDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdedridDirtyFlag = false;
    private boolean psdedritemidDirtyFlag = false;
    private boolean psdedritemnameDirtyFlag = false;
    private boolean psdedrnameDirtyFlag = false;
    private boolean psdefuimodeidDirtyFlag = false;
    private boolean psdefuimodenameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefiupdateidDirtyFlag = false;
    private boolean psdefiupdatenameDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeformdetailidDirtyFlag = false;
    private boolean psdeformdetailnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeformrfidDirtyFlag = false;
    private boolean psdeformrfnameDirtyFlag = false;
    private boolean psdefsfitemidDirtyFlag = false;
    private boolean psdefsfitemnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdictcatidDirtyFlag = false;
    private boolean pssysdictcatnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean rawcssstyleDirtyFlag = false;
    private boolean rawservicemethodDirtyFlag = false;
    private boolean rawserviceurlDirtyFlag = false;
    private boolean refpsdeacmodeidDirtyFlag = false;
    private boolean refpsdeacmodenameDirtyFlag = false;
    private boolean refpsdedatasetidDirtyFlag = false;
    private boolean refpsdedatasetnameDirtyFlag = false;
    private boolean refpsdeformdetailidDirtyFlag = false;
    private boolean refpsdeformdetailnameDirtyFlag = false;
    private boolean refpsdeformidDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean refpsderidDirtyFlag = false;
    private boolean refpsdernameDirtyFlag = false;
    private boolean rendermodeDirtyFlag = false;
    private boolean rendermodetextDirtyFlag = false;
    private boolean resetitemnameDirtyFlag = false;
    private boolean rowspanDirtyFlag = false;
    private boolean showcaptionDirtyFlag = false;
    private boolean showmoremodeDirtyFlag = false;
    private boolean spacingbottomDirtyFlag = false;
    private boolean spacingleftDirtyFlag = false;
    private boolean spacingrightDirtyFlag = false;
    private boolean spacingtopDirtyFlag = false;
    private boolean swapmodeDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean titlebarclosemodeDirtyFlag = false;
    private boolean togglemodeDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean ucpssyspfpluginidDirtyFlag = false;
    private boolean ucpssyspfpluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatedvDirtyFlag = false;
    private boolean updatedvtDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean valignDirtyFlag = false;
    private boolean valignselfDirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean valueitemnameDirtyFlag = false;
    private boolean visiblelogicDirtyFlag = false;
    private boolean wbdefmodeDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    private boolean widthmodeDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="blanklogic")
    private String blanklogic;
    @Column(name="bl_pos")
    private String bl_pos;
    @Column(name="borderstyle")
    private String borderstyle;
    @Column(name="btnactiontype")
    private String btnactiontype;
    @Column(name="buildinaction")
    private Integer buildinaction;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="child_col_lg")
    private Integer child_col_lg;
    @Column(name="child_col_md")
    private Integer child_col_md;
    @Column(name="child_col_sm")
    private Integer child_col_sm;
    @Column(name="child_col_xs")
    private Integer child_col_xs;
    @Column(name="codelistconfigmode")
    private Integer codelistconfigmode;
    @Column(name="colalign")
    private String colalign;
    @Column(name="colid")
    private Integer colid;
    @Column(name="colmodel")
    private String colmodel;
    @Column(name="colspan")
    private Integer colspan;
    @Column(name="col_lg")
    private Integer col_lg;
    @Column(name="col_lg_os")
    private Integer col_lg_os;
    @Column(name="col_md")
    private Integer col_md;
    @Column(name="col_md_os")
    private Integer col_md_os;
    @Column(name="col_sm")
    private Integer col_sm;
    @Column(name="col_sm_os")
    private Integer col_sm_os;
    @Column(name="col_width")
    private Integer col_width;
    @Column(name="col_xs")
    private Integer col_xs;
    @Column(name="col_xs_os")
    private Integer col_xs_os;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="convertcitext")
    private Integer convertcitext;
    @Column(name="counterid")
    private String counterid;
    @Column(name="countermode")
    private Integer countermode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createdv")
    private String createdv;
    @Column(name="createdvt")
    private String createdvt;
    @Column(name="createman")
    private String createman;
    @Column(name="cssid")
    private String cssid;
    @Column(name="ctrlcolspan")
    private Integer ctrlcolspan;
    @Column(name="ctrldynaclass")
    private String ctrldynaclass;
    @Column(name="ctrlheight")
    private Integer ctrlheight;
    @Column(name="ctrlpssyscssid")
    private String ctrlpssyscssid;
    @Column(name="ctrlpssyscssname")
    private String ctrlpssyscssname;
    @Column(name="ctrlrawcssstyle")
    private String ctrlrawcssstyle;
    @Column(name="ctrlwidth")
    private Integer ctrlwidth;
    @Column(name="customcode")
    private String customcode;
    @Column(name="data")
    private String data;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="detailstyle")
    private String detailstyle;
    @Column(name="detailstyletext")
    private String detailstyletext;
    @Column(name="detailtag")
    private String detailtag;
    @Column(name="detailtag2")
    private String detailtag2;
    @Column(name="detailtype")
    private String detailtype;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="editorparams")
    private String editorparams;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editortypename")
    private String editortypename;
    @Column(name="emptycaption")
    private Integer emptycaption;
    @Column(name="enableanchor")
    private Integer enableanchor;
    @Column(name="enablecond")
    private Integer enablecond;
    @Column(name="enableinputtip")
    private Integer enableinputtip;
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="enablelogic")
    private String enablelogic;
    @Column(name="fieldname")
    private String fieldname;
    @Column(name="flexalign")
    private String flexalign;
    @Column(name="flexbasis")
    private Integer flexbasis;
    @Column(name="flexdir")
    private String flexdir;
    @Column(name="flexgrow")
    private Integer flexgrow;
    @Column(name="flexshrink")
    private Integer flexshrink;
    @Column(name="flexvalign")
    private String flexvalign;
    @Column(name="formtype")
    private String formtype;
    @Column(name="gridrowid")
    private Integer gridrowid;
    @Column(name="halign")
    private String halign;
    @Column(name="halignself")
    private String halignself;
    @Column(name="height")
    private Integer height;
    @Column(name="heightmode")
    private String heightmode;
    @Column(name="htmlcontent")
    private String htmlcontent;
    @Column(name="htmlpageurl")
    private String htmlpageurl;
    @Column(name="iconalign")
    private String iconalign;
    @Column(name="ignoreinput")
    private Integer ignoreinput;
    @Column(name="insertpos")
    private Integer insertpos;
    @Column(name="itempsachandlerid")
    private String itempsachandlerid;
    @Column(name="itempsachandlername")
    private String itempsachandlername;
    @Column(name="itemstates")
    private Integer itemstates;
    @Column(name="labelcolspan")
    private Integer labelcolspan;
    @Column(name="labelcolspan2")
    private Integer labelcolspan2;
    @Column(name="labelcssid")
    private String labelcssid;
    @Column(name="labeldynaclass")
    private String labeldynaclass;
    @Column(name="labelpos")
    private String labelpos;
    @Column(name="labelpssyscssid")
    private String labelpssyscssid;
    @Column(name="labelpssyscssname")
    private String labelpssyscssname;
    @Column(name="labelrawcssstyle")
    private String labelrawcssstyle;
    @Column(name="labelwidth")
    private Integer labelwidth;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="linkpsdeviewid")
    private String linkpsdeviewid;
    @Column(name="linkpsdeviewname")
    private String linkpsdeviewname;
    @Column(name="logicname")
    private String logicname;
    @Column(name="margin")
    private String margin;
    @Column(name="maskinfo")
    private String maskinfo;
    @Column(name="maskmode")
    private Integer maskmode;
    @Column(name="maskpslanresid")
    private String maskpslanresid;
    @Column(name="maskpslanresname")
    private String maskpslanresname;
    @Column(name="mdctrltype")
    private String mdctrltype;
    @Column(name="mdpsdedataviewid")
    private String mdpsdedataviewid;
    @Column(name="mdpsdedataviewname")
    private String mdpsdedataviewname;
    @Column(name="mdpsdeformid")
    private String mdpsdeformid;
    @Column(name="mdpsdeformname")
    private String mdpsdeformname;
    @Column(name="mdpsdegridid")
    private String mdpsdegridid;
    @Column(name="mdpsdegridname")
    private String mdpsdegridname;
    @Column(name="mdpsdelistid")
    private String mdpsdelistid;
    @Column(name="mdpsdelistname")
    private String mdpsdelistname;
    @Column(name="mdpssysviewpanelid")
    private String mdpssysviewpanelid;
    @Column(name="mdpssysviewpanelname")
    private String mdpssysviewpanelname;
    @Column(name="memo")
    private String memo;
    @Column(name="mobflag")
    private Integer mobflag;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="needcodelistconfig")
    private Integer needcodelistconfig;
    @Column(name="noprivdm")
    private Integer noprivdm;
    @Column(name="openpsdeviewid")
    private String openpsdeviewid;
    @Column(name="openpsdeviewname")
    private String openpsdeviewname;
    @Column(name="openpssyspdtviewid")
    private String openpssyspdtviewid;
    @Column(name="openpssyspdtviewname")
    private String openpssyspdtviewname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="padding")
    private String padding;
    @Column(name="phpslanresid")
    private String phpslanresid;
    @Column(name="phpslanresname")
    private String phpslanresname;
    @Column(name="pickuppsdeviewid")
    private String pickuppsdeviewid;
    @Column(name="pickuppsdeviewname")
    private String pickuppsdeviewname;
    @Column(name="placeholder")
    private String placeholder;
    @Column(name="playoutmode")
    private String playoutmode;
    @Column(name="ppsdeformdetailid")
    private String ppsdeformdetailid;
    @Column(name="ppsdeformdetailname")
    private String ppsdeformdetailname;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="preventxss")
    private Integer preventxss;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdedrid")
    private String psdedrid;
    @Column(name="psdedritemid")
    private String psdedritemid;
    @Column(name="psdedritemname")
    private String psdedritemname;
    @Column(name="psdedrname")
    private String psdedrname;
    @Column(name="psdefuimodeid")
    private String psdefuimodeid;
    @Column(name="psdefuimodename")
    private String psdefuimodename;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefiupdateid")
    private String psdefiupdateid;
    @Column(name="psdefiupdatename")
    private String psdefiupdatename;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeformdetailid")
    private String psdeformdetailid;
    @Column(name="psdeformdetailname")
    private String psdeformdetailname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeformrfid")
    private String psdeformrfid;
    @Column(name="psdeformrfname")
    private String psdeformrfname;
    @Column(name="psdefsfitemid")
    private String psdefsfitemid;
    @Column(name="psdefsfitemname")
    private String psdefsfitemname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdictcatid")
    private String pssysdictcatid;
    @Column(name="pssysdictcatname")
    private String pssysdictcatname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyseditorstyleid")
    private String pssyseditorstyleid;
    @Column(name="pssyseditorstylename")
    private String pssyseditorstylename;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="rawcssstyle")
    private String rawcssstyle;
    @Column(name="rawservicemethod")
    private String rawservicemethod;
    @Column(name="rawserviceurl")
    private String rawserviceurl;
    @Column(name="refpsdeacmodeid")
    private String refpsdeacmodeid;
    @Column(name="refpsdeacmodename")
    private String refpsdeacmodename;
    @Column(name="refpsdedatasetid")
    private String refpsdedatasetid;
    @Column(name="refpsdedatasetname")
    private String refpsdedatasetname;
    @Column(name="refpsdeformdetailid")
    private String refpsdeformdetailid;
    @Column(name="refpsdeformdetailname")
    private String refpsdeformdetailname;
    @Column(name="refpsdeformid")
    private String refpsdeformid;
    @Column(name="refpsdeid")
    private String refpsdeid;
    @Column(name="refpsdename")
    private String refpsdename;
    @Column(name="refpsderid")
    private String refpsderid;
    @Column(name="refpsdername")
    private String refpsdername;
    @Column(name="rendermode")
    private String rendermode;
    @Column(name="rendermodetext")
    private String rendermodetext;
    @Column(name="resetitemname")
    private String resetitemname;
    @Column(name="rowspan")
    private Integer rowspan;
    @Column(name="showcaption")
    private Integer showcaption;
    @Column(name="showmoremode")
    private Integer showmoremode;
    @Column(name="spacingbottom")
    private String spacingbottom;
    @Column(name="spacingleft")
    private String spacingleft;
    @Column(name="spacingright")
    private String spacingright;
    @Column(name="spacingtop")
    private String spacingtop;
    @Column(name="swapmode")
    private String swapmode;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="titlebarclosemode")
    private Integer titlebarclosemode;
    @Column(name="togglemode")
    private String togglemode;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="ucpssyspfpluginid")
    private String ucpssyspfpluginid;
    @Column(name="ucpssyspfpluginname")
    private String ucpssyspfpluginname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updatedv")
    private String updatedv;
    @Column(name="updatedvt")
    private String updatedvt;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="valign")
    private String valign;
    @Column(name="valignself")
    private String valignself;
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="valueitemname")
    private String valueitemname;
    @Column(name="visiblelogic")
    private String visiblelogic;
    @Column(name="wbdefmode")
    private Integer wbdefmode;
    @Column(name="width")
    private Integer width;
    @Column(name="widthmode")
    private String widthmode;
    private Integer objItemPSACHandlerLock = new Integer(1);
    private PSACHandler itempsachandler = null;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objRefPSDEACModeLock = new Integer(1);
    private PSDEACMode refpsdeacmode = null;
    private Integer objPSDEDRLock = new Integer(1);
    private PSDEDataRelation psdedr = null;
    private Integer objRefPSDEDataSetLock = new Integer(1);
    private PSDEDataSet refpsdedataset = null;
    private Integer objMDPSDEDataViewLock = new Integer(1);
    private PSDEDataView mdpsdedataview = null;
    private Integer objPSDEDRItemLock = new Integer(1);
    private PSDEDRItem psdedritem = null;
    private Integer objPSDEFUIModeLock = new Integer(1);
    private PSDEFUIMode psdefuimode = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFIUpdateLock = new Integer(1);
    private PSDEFIUpdate psdefiupdate = null;
    private Integer objPPSDEFormDetailLock = new Integer(1);
    private PSDEFormDetail ppsdeformdetail = null;
    private Integer objRefPSDEFormDetailLock = new Integer(1);
    private PSDEFormDetail refpsdeformdetail = null;
    private Integer objPSDEFormRFLock = new Integer(1);
    private PSDEFormRF psdeformrf = null;
    private Integer objMDPSDEFormLock = new Integer(1);
    private PSDEForm mdpsdeform = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEFSFItemLock = new Integer(1);
    private PSDEFSFItem psdefsfitem = null;
    private Integer objMDPSDEGridLock = new Integer(1);
    private PSDEGrid mdpsdegrid = null;
    private Integer objMDPSDEListLock = new Integer(1);
    private PSDEList mdpsdelist = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objRefPSDERLock = new Integer(1);
    private PSDER refpsder = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase linkpsdeview = null;
    private Integer objOpenPSDEViewLock = new Integer(1);
    private PSDEViewBase openpsdeview = null;
    private Integer objPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase pickuppsdeview = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objMaskPSLanResLock = new Integer(1);
    private PSLanguageRes maskpslanres = null;
    private Integer objPHPSLanResLock = new Integer(1);
    private PSLanguageRes phpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objCtrlPSSysCssLock = new Integer(1);
    private PSSysCss ctrlpssyscss = null;
    private Integer objLabelPSSysCssLock = new Integer(1);
    private PSSysCss labelpssyscss = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDictCatLock = new Integer(1);
    private PSSysDictCat pssysdictcat = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objOpenPSSysPDTViewLock = new Integer(1);
    private PSSysPDTView openpssyspdtview = null;
    private Integer objUCPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin ucpssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objMDPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel mdpssysviewpanel = null;
    private Integer objPSDEFDLogicsLock = new Integer(1);
    private ArrayList<PSDEFDLogic> psdefdlogics = null;
    private Integer objPSDEFormDetailsLock = new Integer(1);
    private ArrayList<PSDEFormDetail> psdeformdetails = null;

    public void setAllowEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowEmpty(n);
            return;
        }
        this.allowempty = n;
        this.allowemptyDirtyFlag = true;
    }

    public Integer getAllowEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowEmpty();
        }
        return this.allowempty;
    }

    public boolean isAllowEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowEmptyDirty();
        }
        return this.allowemptyDirtyFlag;
    }

    public void resetAllowEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowEmpty();
            return;
        }
        this.allowemptyDirtyFlag = false;
        this.allowempty = null;
    }

    public void setBlankLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBlankLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.blanklogic = string;
        this.blanklogicDirtyFlag = true;
    }

    public String getBlankLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBlankLogic();
        }
        return this.blanklogic;
    }

    public boolean isBlankLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBlankLogicDirty();
        }
        return this.blanklogicDirtyFlag;
    }

    public void resetBlankLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBlankLogic();
            return;
        }
        this.blanklogicDirtyFlag = false;
        this.blanklogic = null;
    }

    public void setBL_Pos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBL_Pos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bl_pos = string;
        this.bl_posDirtyFlag = true;
    }

    public String getBL_Pos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBL_Pos();
        }
        return this.bl_pos;
    }

    public boolean isBL_PosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBL_PosDirty();
        }
        return this.bl_posDirtyFlag;
    }

    public void resetBL_Pos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBL_Pos();
            return;
        }
        this.bl_posDirtyFlag = false;
        this.bl_pos = null;
    }

    public void setBorderStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBorderStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.borderstyle = string;
        this.borderstyleDirtyFlag = true;
    }

    public String getBorderStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBorderStyle();
        }
        return this.borderstyle;
    }

    public boolean isBorderStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBorderStyleDirty();
        }
        return this.borderstyleDirtyFlag;
    }

    public void resetBorderStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBorderStyle();
            return;
        }
        this.borderstyleDirtyFlag = false;
        this.borderstyle = null;
    }

    public void setBtnActionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBtnActionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.btnactiontype = string;
        this.btnactiontypeDirtyFlag = true;
    }

    public String getBtnActionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBtnActionType();
        }
        return this.btnactiontype;
    }

    public boolean isBtnActionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBtnActionTypeDirty();
        }
        return this.btnactiontypeDirtyFlag;
    }

    public void resetBtnActionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBtnActionType();
            return;
        }
        this.btnactiontypeDirtyFlag = false;
        this.btnactiontype = null;
    }

    public void setBuildInAction(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBuildInAction(n);
            return;
        }
        this.buildinaction = n;
        this.buildinactionDirtyFlag = true;
    }

    public Integer getBuildInAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBuildInAction();
        }
        return this.buildinaction;
    }

    public boolean isBuildInActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBuildInActionDirty();
        }
        return this.buildinactionDirtyFlag;
    }

    public void resetBuildInAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBuildInAction();
            return;
        }
        this.buildinactionDirtyFlag = false;
        this.buildinaction = null;
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

    public void setChild_Col_LG(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChild_Col_LG(n);
            return;
        }
        this.child_col_lg = n;
        this.child_col_lgDirtyFlag = true;
    }

    public Integer getChild_Col_LG() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChild_Col_LG();
        }
        return this.child_col_lg;
    }

    public boolean isChild_Col_LGDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChild_Col_LGDirty();
        }
        return this.child_col_lgDirtyFlag;
    }

    public void resetChild_Col_LG() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChild_Col_LG();
            return;
        }
        this.child_col_lgDirtyFlag = false;
        this.child_col_lg = null;
    }

    public void setChild_Col_MD(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChild_Col_MD(n);
            return;
        }
        this.child_col_md = n;
        this.child_col_mdDirtyFlag = true;
    }

    public Integer getChild_Col_MD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChild_Col_MD();
        }
        return this.child_col_md;
    }

    public boolean isChild_Col_MDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChild_Col_MDDirty();
        }
        return this.child_col_mdDirtyFlag;
    }

    public void resetChild_Col_MD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChild_Col_MD();
            return;
        }
        this.child_col_mdDirtyFlag = false;
        this.child_col_md = null;
    }

    public void setChild_Col_SM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChild_Col_SM(n);
            return;
        }
        this.child_col_sm = n;
        this.child_col_smDirtyFlag = true;
    }

    public Integer getChild_Col_SM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChild_Col_SM();
        }
        return this.child_col_sm;
    }

    public boolean isChild_Col_SMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChild_Col_SMDirty();
        }
        return this.child_col_smDirtyFlag;
    }

    public void resetChild_Col_SM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChild_Col_SM();
            return;
        }
        this.child_col_smDirtyFlag = false;
        this.child_col_sm = null;
    }

    public void setChild_Col_XS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChild_Col_XS(n);
            return;
        }
        this.child_col_xs = n;
        this.child_col_xsDirtyFlag = true;
    }

    public Integer getChild_Col_XS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChild_Col_XS();
        }
        return this.child_col_xs;
    }

    public boolean isChild_Col_XSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChild_Col_XSDirty();
        }
        return this.child_col_xsDirtyFlag;
    }

    public void resetChild_Col_XS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChild_Col_XS();
            return;
        }
        this.child_col_xsDirtyFlag = false;
        this.child_col_xs = null;
    }

    public void setCodeListConfigMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListConfigMode(n);
            return;
        }
        this.codelistconfigmode = n;
        this.codelistconfigmodeDirtyFlag = true;
    }

    public Integer getCodeListConfigMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListConfigMode();
        }
        return this.codelistconfigmode;
    }

    public boolean isCodeListConfigModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListConfigModeDirty();
        }
        return this.codelistconfigmodeDirtyFlag;
    }

    public void resetCodeListConfigMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListConfigMode();
            return;
        }
        this.codelistconfigmodeDirtyFlag = false;
        this.codelistconfigmode = null;
    }

    public void setColAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colalign = string;
        this.colalignDirtyFlag = true;
    }

    public String getColAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColAlign();
        }
        return this.colalign;
    }

    public boolean isColAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColAlignDirty();
        }
        return this.colalignDirtyFlag;
    }

    public void resetColAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColAlign();
            return;
        }
        this.colalignDirtyFlag = false;
        this.colalign = null;
    }

    public void setColId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColId(n);
            return;
        }
        this.colid = n;
        this.colidDirtyFlag = true;
    }

    public Integer getColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColId();
        }
        return this.colid;
    }

    public boolean isColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColIdDirty();
        }
        return this.colidDirtyFlag;
    }

    public void resetColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColId();
            return;
        }
        this.colidDirtyFlag = false;
        this.colid = null;
    }

    public void setColModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.colmodel = string;
        this.colmodelDirtyFlag = true;
    }

    public String getColModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColModel();
        }
        return this.colmodel;
    }

    public boolean isColModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColModelDirty();
        }
        return this.colmodelDirtyFlag;
    }

    public void resetColModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColModel();
            return;
        }
        this.colmodelDirtyFlag = false;
        this.colmodel = null;
    }

    public void setColSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColSpan(n);
            return;
        }
        this.colspan = n;
        this.colspanDirtyFlag = true;
    }

    public Integer getColSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColSpan();
        }
        return this.colspan;
    }

    public boolean isColSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColSpanDirty();
        }
        return this.colspanDirtyFlag;
    }

    public void resetColSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColSpan();
            return;
        }
        this.colspanDirtyFlag = false;
        this.colspan = null;
    }

    public void setCol_LG(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_LG(n);
            return;
        }
        this.col_lg = n;
        this.col_lgDirtyFlag = true;
    }

    public Integer getCol_LG() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_LG();
        }
        return this.col_lg;
    }

    public boolean isCol_LGDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_LGDirty();
        }
        return this.col_lgDirtyFlag;
    }

    public void resetCol_LG() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_LG();
            return;
        }
        this.col_lgDirtyFlag = false;
        this.col_lg = null;
    }

    public void setCol_LG_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_LG_OS(n);
            return;
        }
        this.col_lg_os = n;
        this.col_lg_osDirtyFlag = true;
    }

    public Integer getCol_LG_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_LG_OS();
        }
        return this.col_lg_os;
    }

    public boolean isCol_LG_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_LG_OSDirty();
        }
        return this.col_lg_osDirtyFlag;
    }

    public void resetCol_LG_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_LG_OS();
            return;
        }
        this.col_lg_osDirtyFlag = false;
        this.col_lg_os = null;
    }

    public void setCol_MD(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_MD(n);
            return;
        }
        this.col_md = n;
        this.col_mdDirtyFlag = true;
    }

    public Integer getCol_MD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_MD();
        }
        return this.col_md;
    }

    public boolean isCol_MDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_MDDirty();
        }
        return this.col_mdDirtyFlag;
    }

    public void resetCol_MD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_MD();
            return;
        }
        this.col_mdDirtyFlag = false;
        this.col_md = null;
    }

    public void setCol_MD_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_MD_OS(n);
            return;
        }
        this.col_md_os = n;
        this.col_md_osDirtyFlag = true;
    }

    public Integer getCol_MD_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_MD_OS();
        }
        return this.col_md_os;
    }

    public boolean isCol_MD_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_MD_OSDirty();
        }
        return this.col_md_osDirtyFlag;
    }

    public void resetCol_MD_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_MD_OS();
            return;
        }
        this.col_md_osDirtyFlag = false;
        this.col_md_os = null;
    }

    public void setCol_SM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_SM(n);
            return;
        }
        this.col_sm = n;
        this.col_smDirtyFlag = true;
    }

    public Integer getCol_SM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_SM();
        }
        return this.col_sm;
    }

    public boolean isCol_SMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_SMDirty();
        }
        return this.col_smDirtyFlag;
    }

    public void resetCol_SM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_SM();
            return;
        }
        this.col_smDirtyFlag = false;
        this.col_sm = null;
    }

    public void setCol_SM_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_SM_OS(n);
            return;
        }
        this.col_sm_os = n;
        this.col_sm_osDirtyFlag = true;
    }

    public Integer getCol_SM_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_SM_OS();
        }
        return this.col_sm_os;
    }

    public boolean isCol_SM_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_SM_OSDirty();
        }
        return this.col_sm_osDirtyFlag;
    }

    public void resetCol_SM_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_SM_OS();
            return;
        }
        this.col_sm_osDirtyFlag = false;
        this.col_sm_os = null;
    }

    public void setCol_Width(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_Width(n);
            return;
        }
        this.col_width = n;
        this.col_widthDirtyFlag = true;
    }

    public Integer getCol_Width() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_Width();
        }
        return this.col_width;
    }

    public boolean isCol_WidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_WidthDirty();
        }
        return this.col_widthDirtyFlag;
    }

    public void resetCol_Width() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_Width();
            return;
        }
        this.col_widthDirtyFlag = false;
        this.col_width = null;
    }

    public void setCol_XS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_XS(n);
            return;
        }
        this.col_xs = n;
        this.col_xsDirtyFlag = true;
    }

    public Integer getCol_XS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_XS();
        }
        return this.col_xs;
    }

    public boolean isCol_XSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_XSDirty();
        }
        return this.col_xsDirtyFlag;
    }

    public void resetCol_XS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_XS();
            return;
        }
        this.col_xsDirtyFlag = false;
        this.col_xs = null;
    }

    public void setCol_XS_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_XS_OS(n);
            return;
        }
        this.col_xs_os = n;
        this.col_xs_osDirtyFlag = true;
    }

    public Integer getCol_XS_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_XS_OS();
        }
        return this.col_xs_os;
    }

    public boolean isCol_XS_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_XS_OSDirty();
        }
        return this.col_xs_osDirtyFlag;
    }

    public void resetCol_XS_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_XS_OS();
            return;
        }
        this.col_xs_osDirtyFlag = false;
        this.col_xs_os = null;
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

    public void setConvertCIText(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConvertCIText(n);
            return;
        }
        this.convertcitext = n;
        this.convertcitextDirtyFlag = true;
    }

    public Integer getConvertCIText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConvertCIText();
        }
        return this.convertcitext;
    }

    public boolean isConvertCITextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConvertCITextDirty();
        }
        return this.convertcitextDirtyFlag;
    }

    public void resetConvertCIText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConvertCIText();
            return;
        }
        this.convertcitextDirtyFlag = false;
        this.convertcitext = null;
    }

    public void setCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterid = string;
        this.counteridDirtyFlag = true;
    }

    public String getCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterId();
        }
        return this.counterid;
    }

    public boolean isCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterIdDirty();
        }
        return this.counteridDirtyFlag;
    }

    public void resetCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterId();
            return;
        }
        this.counteridDirtyFlag = false;
        this.counterid = null;
    }

    public void setCounterMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterMode(n);
            return;
        }
        this.countermode = n;
        this.countermodeDirtyFlag = true;
    }

    public Integer getCounterMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterMode();
        }
        return this.countermode;
    }

    public boolean isCounterModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterModeDirty();
        }
        return this.countermodeDirtyFlag;
    }

    public void resetCounterMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterMode();
            return;
        }
        this.countermodeDirtyFlag = false;
        this.countermode = null;
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

    public void setCreateDV(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDV(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdv = string;
        this.createdvDirtyFlag = true;
    }

    public String getCreateDV() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDV();
        }
        return this.createdv;
    }

    public boolean isCreateDVDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDVDirty();
        }
        return this.createdvDirtyFlag;
    }

    public void resetCreateDV() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDV();
            return;
        }
        this.createdvDirtyFlag = false;
        this.createdv = null;
    }

    public void setCreateDVT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDVT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdvt = string;
        this.createdvtDirtyFlag = true;
    }

    public String getCreateDVT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDVT();
        }
        return this.createdvt;
    }

    public boolean isCreateDVTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDVTDirty();
        }
        return this.createdvtDirtyFlag;
    }

    public void resetCreateDVT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDVT();
            return;
        }
        this.createdvtDirtyFlag = false;
        this.createdvt = null;
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

    public void setCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssid = string;
        this.cssidDirtyFlag = true;
    }

    public String getCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssId();
        }
        return this.cssid;
    }

    public boolean isCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssIdDirty();
        }
        return this.cssidDirtyFlag;
    }

    public void resetCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssId();
            return;
        }
        this.cssidDirtyFlag = false;
        this.cssid = null;
    }

    public void setCtrlColSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlColSpan(n);
            return;
        }
        this.ctrlcolspan = n;
        this.ctrlcolspanDirtyFlag = true;
    }

    public Integer getCtrlColSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlColSpan();
        }
        return this.ctrlcolspan;
    }

    public boolean isCtrlColSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlColSpanDirty();
        }
        return this.ctrlcolspanDirtyFlag;
    }

    public void resetCtrlColSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlColSpan();
            return;
        }
        this.ctrlcolspanDirtyFlag = false;
        this.ctrlcolspan = null;
    }

    public void setCtrlDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrldynaclass = string;
        this.ctrldynaclassDirtyFlag = true;
    }

    public String getCtrlDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlDynaClass();
        }
        return this.ctrldynaclass;
    }

    public boolean isCtrlDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlDynaClassDirty();
        }
        return this.ctrldynaclassDirtyFlag;
    }

    public void resetCtrlDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlDynaClass();
            return;
        }
        this.ctrldynaclassDirtyFlag = false;
        this.ctrldynaclass = null;
    }

    public void setCtrlHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlHeight(n);
            return;
        }
        this.ctrlheight = n;
        this.ctrlheightDirtyFlag = true;
    }

    public Integer getCtrlHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlHeight();
        }
        return this.ctrlheight;
    }

    public boolean isCtrlHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlHeightDirty();
        }
        return this.ctrlheightDirtyFlag;
    }

    public void resetCtrlHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlHeight();
            return;
        }
        this.ctrlheightDirtyFlag = false;
        this.ctrlheight = null;
    }

    public void setCtrlPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlpssyscssid = string;
        this.ctrlpssyscssidDirtyFlag = true;
    }

    public String getCtrlPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPSSysCssId();
        }
        return this.ctrlpssyscssid;
    }

    public boolean isCtrlPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlPSSysCssIdDirty();
        }
        return this.ctrlpssyscssidDirtyFlag;
    }

    public void resetCtrlPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlPSSysCssId();
            return;
        }
        this.ctrlpssyscssidDirtyFlag = false;
        this.ctrlpssyscssid = null;
    }

    public void setCtrlPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlpssyscssname = string;
        this.ctrlpssyscssnameDirtyFlag = true;
    }

    public String getCtrlPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPSSysCssName();
        }
        return this.ctrlpssyscssname;
    }

    public boolean isCtrlPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlPSSysCssNameDirty();
        }
        return this.ctrlpssyscssnameDirtyFlag;
    }

    public void resetCtrlPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlPSSysCssName();
            return;
        }
        this.ctrlpssyscssnameDirtyFlag = false;
        this.ctrlpssyscssname = null;
    }

    public void setCtrlRawCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlRawCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlrawcssstyle = string;
        this.ctrlrawcssstyleDirtyFlag = true;
    }

    public String getCtrlRawCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlRawCssStyle();
        }
        return this.ctrlrawcssstyle;
    }

    public boolean isCtrlRawCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlRawCssStyleDirty();
        }
        return this.ctrlrawcssstyleDirtyFlag;
    }

    public void resetCtrlRawCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlRawCssStyle();
            return;
        }
        this.ctrlrawcssstyleDirtyFlag = false;
        this.ctrlrawcssstyle = null;
    }

    public void setCtrlWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlWidth(n);
            return;
        }
        this.ctrlwidth = n;
        this.ctrlwidthDirtyFlag = true;
    }

    public Integer getCtrlWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlWidth();
        }
        return this.ctrlwidth;
    }

    public boolean isCtrlWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlWidthDirty();
        }
        return this.ctrlwidthDirtyFlag;
    }

    public void resetCtrlWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlWidth();
            return;
        }
        this.ctrlwidthDirtyFlag = false;
        this.ctrlwidth = null;
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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
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

    public void setDetailStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailstyle = string;
        this.detailstyleDirtyFlag = true;
    }

    public String getDetailStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailStyle();
        }
        return this.detailstyle;
    }

    public boolean isDetailStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailStyleDirty();
        }
        return this.detailstyleDirtyFlag;
    }

    public void resetDetailStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailStyle();
            return;
        }
        this.detailstyleDirtyFlag = false;
        this.detailstyle = null;
    }

    public void setDetailStyleText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailStyleText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailstyletext = string;
        this.detailstyletextDirtyFlag = true;
    }

    public String getDetailStyleText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailStyleText();
        }
        return this.detailstyletext;
    }

    public boolean isDetailStyleTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailStyleTextDirty();
        }
        return this.detailstyletextDirtyFlag;
    }

    public void resetDetailStyleText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailStyleText();
            return;
        }
        this.detailstyletextDirtyFlag = false;
        this.detailstyletext = null;
    }

    public void setDetailTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag = string;
        this.detailtagDirtyFlag = true;
    }

    public String getDetailTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag();
        }
        return this.detailtag;
    }

    public boolean isDetailTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTagDirty();
        }
        return this.detailtagDirtyFlag;
    }

    public void resetDetailTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag();
            return;
        }
        this.detailtagDirtyFlag = false;
        this.detailtag = null;
    }

    public void setDetailTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag2 = string;
        this.detailtag2DirtyFlag = true;
    }

    public String getDetailTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag2();
        }
        return this.detailtag2;
    }

    public boolean isDetailTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTag2Dirty();
        }
        return this.detailtag2DirtyFlag;
    }

    public void resetDetailTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag2();
            return;
        }
        this.detailtag2DirtyFlag = false;
        this.detailtag2 = null;
    }

    public void setDetailType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtype = string;
        this.detailtypeDirtyFlag = true;
    }

    public String getDetailType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailType();
        }
        return this.detailtype;
    }

    public boolean isDetailTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTypeDirty();
        }
        return this.detailtypeDirtyFlag;
    }

    public void resetDetailType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailType();
            return;
        }
        this.detailtypeDirtyFlag = false;
        this.detailtype = null;
    }

    public void setDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaclass = string;
        this.dynaclassDirtyFlag = true;
    }

    public String getDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaClass();
        }
        return this.dynaclass;
    }

    public boolean isDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaClassDirty();
        }
        return this.dynaclassDirtyFlag;
    }

    public void resetDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaClass();
            return;
        }
        this.dynaclassDirtyFlag = false;
        this.dynaclass = null;
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

    public void setEditorParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editorparams = string;
        this.editorparamsDirtyFlag = true;
    }

    public String getEditorParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorParams();
        }
        return this.editorparams;
    }

    public boolean isEditorParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorParamsDirty();
        }
        return this.editorparamsDirtyFlag;
    }

    public void resetEditorParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorParams();
            return;
        }
        this.editorparamsDirtyFlag = false;
        this.editorparams = null;
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

    public void setEmptyCaption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyCaption(n);
            return;
        }
        this.emptycaption = n;
        this.emptycaptionDirtyFlag = true;
    }

    public Integer getEmptyCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyCaption();
        }
        return this.emptycaption;
    }

    public boolean isEmptyCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyCaptionDirty();
        }
        return this.emptycaptionDirtyFlag;
    }

    public void resetEmptyCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyCaption();
            return;
        }
        this.emptycaptionDirtyFlag = false;
        this.emptycaption = null;
    }

    public void setEnableAnchor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAnchor(n);
            return;
        }
        this.enableanchor = n;
        this.enableanchorDirtyFlag = true;
    }

    public Integer getEnableAnchor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAnchor();
        }
        return this.enableanchor;
    }

    public boolean isEnableAnchorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAnchorDirty();
        }
        return this.enableanchorDirtyFlag;
    }

    public void resetEnableAnchor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAnchor();
            return;
        }
        this.enableanchorDirtyFlag = false;
        this.enableanchor = null;
    }

    public void setEnableCond(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCond(n);
            return;
        }
        this.enablecond = n;
        this.enablecondDirtyFlag = true;
    }

    public Integer getEnableCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCond();
        }
        return this.enablecond;
    }

    public boolean isEnableCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCondDirty();
        }
        return this.enablecondDirtyFlag;
    }

    public void resetEnableCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCond();
            return;
        }
        this.enablecondDirtyFlag = false;
        this.enablecond = null;
    }

    public void setEnableInputTip(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableInputTip(n);
            return;
        }
        this.enableinputtip = n;
        this.enableinputtipDirtyFlag = true;
    }

    public Integer getEnableInputTip() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableInputTip();
        }
        return this.enableinputtip;
    }

    public boolean isEnableInputTipDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableInputTipDirty();
        }
        return this.enableinputtipDirtyFlag;
    }

    public void resetEnableInputTip() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableInputTip();
            return;
        }
        this.enableinputtipDirtyFlag = false;
        this.enableinputtip = null;
    }

    public void setEnableItemPriv(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableItemPriv(n);
            return;
        }
        this.enableitempriv = n;
        this.enableitemprivDirtyFlag = true;
    }

    public Integer getEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableItemPriv();
        }
        return this.enableitempriv;
    }

    public boolean isEnableItemPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableItemPrivDirty();
        }
        return this.enableitemprivDirtyFlag;
    }

    public void resetEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableItemPriv();
            return;
        }
        this.enableitemprivDirtyFlag = false;
        this.enableitempriv = null;
    }

    public void setEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablelogic = string;
        this.enablelogicDirtyFlag = true;
    }

    public String getEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLogic();
        }
        return this.enablelogic;
    }

    public boolean isEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLogicDirty();
        }
        return this.enablelogicDirtyFlag;
    }

    public void resetEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLogic();
            return;
        }
        this.enablelogicDirtyFlag = false;
        this.enablelogic = null;
    }

    public void setFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldname = string;
        this.fieldnameDirtyFlag = true;
    }

    public String getFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldName();
        }
        return this.fieldname;
    }

    public boolean isFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldNameDirty();
        }
        return this.fieldnameDirtyFlag;
    }

    public void resetFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldName();
            return;
        }
        this.fieldnameDirtyFlag = false;
        this.fieldname = null;
    }

    public void setFlexAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexalign = string;
        this.flexalignDirtyFlag = true;
    }

    public String getFlexAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexAlign();
        }
        return this.flexalign;
    }

    public boolean isFlexAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexAlignDirty();
        }
        return this.flexalignDirtyFlag;
    }

    public void resetFlexAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexAlign();
            return;
        }
        this.flexalignDirtyFlag = false;
        this.flexalign = null;
    }

    public void setFlexBasis(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexBasis(n);
            return;
        }
        this.flexbasis = n;
        this.flexbasisDirtyFlag = true;
    }

    public Integer getFlexBasis() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexBasis();
        }
        return this.flexbasis;
    }

    public boolean isFlexBasisDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexBasisDirty();
        }
        return this.flexbasisDirtyFlag;
    }

    public void resetFlexBasis() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexBasis();
            return;
        }
        this.flexbasisDirtyFlag = false;
        this.flexbasis = null;
    }

    public void setFlexDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexdir = string;
        this.flexdirDirtyFlag = true;
    }

    public String getFlexDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexDir();
        }
        return this.flexdir;
    }

    public boolean isFlexDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexDirDirty();
        }
        return this.flexdirDirtyFlag;
    }

    public void resetFlexDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexDir();
            return;
        }
        this.flexdirDirtyFlag = false;
        this.flexdir = null;
    }

    public void setFlexGrow(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexGrow(n);
            return;
        }
        this.flexgrow = n;
        this.flexgrowDirtyFlag = true;
    }

    public Integer getFlexGrow() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexGrow();
        }
        return this.flexgrow;
    }

    public boolean isFlexGrowDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexGrowDirty();
        }
        return this.flexgrowDirtyFlag;
    }

    public void resetFlexGrow() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexGrow();
            return;
        }
        this.flexgrowDirtyFlag = false;
        this.flexgrow = null;
    }

    public void setFlexShrink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexShrink(n);
            return;
        }
        this.flexshrink = n;
        this.flexshrinkDirtyFlag = true;
    }

    public Integer getFlexShrink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexShrink();
        }
        return this.flexshrink;
    }

    public boolean isFlexShrinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexShrinkDirty();
        }
        return this.flexshrinkDirtyFlag;
    }

    public void resetFlexShrink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexShrink();
            return;
        }
        this.flexshrinkDirtyFlag = false;
        this.flexshrink = null;
    }

    public void setFlexVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexvalign = string;
        this.flexvalignDirtyFlag = true;
    }

    public String getFlexVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexVAlign();
        }
        return this.flexvalign;
    }

    public boolean isFlexVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexVAlignDirty();
        }
        return this.flexvalignDirtyFlag;
    }

    public void resetFlexVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexVAlign();
            return;
        }
        this.flexvalignDirtyFlag = false;
        this.flexvalign = null;
    }

    public void setFormType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formtype = string;
        this.formtypeDirtyFlag = true;
    }

    public String getFormType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormType();
        }
        return this.formtype;
    }

    public boolean isFormTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormTypeDirty();
        }
        return this.formtypeDirtyFlag;
    }

    public void resetFormType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormType();
            return;
        }
        this.formtypeDirtyFlag = false;
        this.formtype = null;
    }

    public void setGridRowId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridRowId(n);
            return;
        }
        this.gridrowid = n;
        this.gridrowidDirtyFlag = true;
    }

    public Integer getGridRowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridRowId();
        }
        return this.gridrowid;
    }

    public boolean isGridRowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridRowIdDirty();
        }
        return this.gridrowidDirtyFlag;
    }

    public void resetGridRowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridRowId();
            return;
        }
        this.gridrowidDirtyFlag = false;
        this.gridrowid = null;
    }

    public void setHAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.halign = string;
        this.halignDirtyFlag = true;
    }

    public String getHAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHAlign();
        }
        return this.halign;
    }

    public boolean isHAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHAlignDirty();
        }
        return this.halignDirtyFlag;
    }

    public void resetHAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHAlign();
            return;
        }
        this.halignDirtyFlag = false;
        this.halign = null;
    }

    public void setHAlignSelf(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHAlignSelf(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.halignself = string;
        this.halignselfDirtyFlag = true;
    }

    public String getHAlignSelf() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHAlignSelf();
        }
        return this.halignself;
    }

    public boolean isHAlignSelfDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHAlignSelfDirty();
        }
        return this.halignselfDirtyFlag;
    }

    public void resetHAlignSelf() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHAlignSelf();
            return;
        }
        this.halignselfDirtyFlag = false;
        this.halignself = null;
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

    public void setHeightMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeightMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.heightmode = string;
        this.heightmodeDirtyFlag = true;
    }

    public String getHeightMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeightMode();
        }
        return this.heightmode;
    }

    public boolean isHeightModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightModeDirty();
        }
        return this.heightmodeDirtyFlag;
    }

    public void resetHeightMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeightMode();
            return;
        }
        this.heightmodeDirtyFlag = false;
        this.heightmode = null;
    }

    public void setHtmlContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlcontent = string;
        this.htmlcontentDirtyFlag = true;
    }

    public String getHtmlContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlContent();
        }
        return this.htmlcontent;
    }

    public boolean isHtmlContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlContentDirty();
        }
        return this.htmlcontentDirtyFlag;
    }

    public void resetHtmlContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlContent();
            return;
        }
        this.htmlcontentDirtyFlag = false;
        this.htmlcontent = null;
    }

    public void setHtmlPageUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlPageUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlpageurl = string;
        this.htmlpageurlDirtyFlag = true;
    }

    public String getHtmlPageUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlPageUrl();
        }
        return this.htmlpageurl;
    }

    public boolean isHtmlPageUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlPageUrlDirty();
        }
        return this.htmlpageurlDirtyFlag;
    }

    public void resetHtmlPageUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlPageUrl();
            return;
        }
        this.htmlpageurlDirtyFlag = false;
        this.htmlpageurl = null;
    }

    public void setIconAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconalign = string;
        this.iconalignDirtyFlag = true;
    }

    public String getIconAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconAlign();
        }
        return this.iconalign;
    }

    public boolean isIconAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconAlignDirty();
        }
        return this.iconalignDirtyFlag;
    }

    public void resetIconAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconAlign();
            return;
        }
        this.iconalignDirtyFlag = false;
        this.iconalign = null;
    }

    public void setIgnoreInput(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreInput(n);
            return;
        }
        this.ignoreinput = n;
        this.ignoreinputDirtyFlag = true;
    }

    public Integer getIgnoreInput() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreInput();
        }
        return this.ignoreinput;
    }

    public boolean isIgnoreInputDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreInputDirty();
        }
        return this.ignoreinputDirtyFlag;
    }

    public void resetIgnoreInput() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreInput();
            return;
        }
        this.ignoreinputDirtyFlag = false;
        this.ignoreinput = null;
    }

    public void setInsertPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInsertPos(n);
            return;
        }
        this.insertpos = n;
        this.insertposDirtyFlag = true;
    }

    public Integer getInsertPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInsertPos();
        }
        return this.insertpos;
    }

    public boolean isInsertPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInsertPosDirty();
        }
        return this.insertposDirtyFlag;
    }

    public void resetInsertPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInsertPos();
            return;
        }
        this.insertposDirtyFlag = false;
        this.insertpos = null;
    }

    public void setItemPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempsachandlerid = string;
        this.itempsachandleridDirtyFlag = true;
    }

    public String getItemPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSACHandlerId();
        }
        return this.itempsachandlerid;
    }

    public boolean isItemPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSACHandlerIdDirty();
        }
        return this.itempsachandleridDirtyFlag;
    }

    public void resetItemPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSACHandlerId();
            return;
        }
        this.itempsachandleridDirtyFlag = false;
        this.itempsachandlerid = null;
    }

    public void setItemPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itempsachandlername = string;
        this.itempsachandlernameDirtyFlag = true;
    }

    public String getItemPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSACHandlerName();
        }
        return this.itempsachandlername;
    }

    public boolean isItemPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemPSACHandlerNameDirty();
        }
        return this.itempsachandlernameDirtyFlag;
    }

    public void resetItemPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemPSACHandlerName();
            return;
        }
        this.itempsachandlernameDirtyFlag = false;
        this.itempsachandlername = null;
    }

    public void setItemStates(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemStates(n);
            return;
        }
        this.itemstates = n;
        this.itemstatesDirtyFlag = true;
    }

    public Integer getItemStates() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemStates();
        }
        return this.itemstates;
    }

    public boolean isItemStatesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemStatesDirty();
        }
        return this.itemstatesDirtyFlag;
    }

    public void resetItemStates() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemStates();
            return;
        }
        this.itemstatesDirtyFlag = false;
        this.itemstates = null;
    }

    public void setLabelColSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelColSpan(n);
            return;
        }
        this.labelcolspan = n;
        this.labelcolspanDirtyFlag = true;
    }

    public Integer getLabelColSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelColSpan();
        }
        return this.labelcolspan;
    }

    public boolean isLabelColSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelColSpanDirty();
        }
        return this.labelcolspanDirtyFlag;
    }

    public void resetLabelColSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelColSpan();
            return;
        }
        this.labelcolspanDirtyFlag = false;
        this.labelcolspan = null;
    }

    public void setLabelColSpan2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelColSpan2(n);
            return;
        }
        this.labelcolspan2 = n;
        this.labelcolspan2DirtyFlag = true;
    }

    public Integer getLabelColSpan2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelColSpan2();
        }
        return this.labelcolspan2;
    }

    public boolean isLabelColSpan2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelColSpan2Dirty();
        }
        return this.labelcolspan2DirtyFlag;
    }

    public void resetLabelColSpan2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelColSpan2();
            return;
        }
        this.labelcolspan2DirtyFlag = false;
        this.labelcolspan2 = null;
    }

    public void setLabelCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelcssid = string;
        this.labelcssidDirtyFlag = true;
    }

    public String getLabelCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelCssId();
        }
        return this.labelcssid;
    }

    public boolean isLabelCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelCssIdDirty();
        }
        return this.labelcssidDirtyFlag;
    }

    public void resetLabelCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelCssId();
            return;
        }
        this.labelcssidDirtyFlag = false;
        this.labelcssid = null;
    }

    public void setLabelDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labeldynaclass = string;
        this.labeldynaclassDirtyFlag = true;
    }

    public String getLabelDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelDynaClass();
        }
        return this.labeldynaclass;
    }

    public boolean isLabelDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelDynaClassDirty();
        }
        return this.labeldynaclassDirtyFlag;
    }

    public void resetLabelDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelDynaClass();
            return;
        }
        this.labeldynaclassDirtyFlag = false;
        this.labeldynaclass = null;
    }

    public void setLabelPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelpos = string;
        this.labelposDirtyFlag = true;
    }

    public String getLabelPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPos();
        }
        return this.labelpos;
    }

    public boolean isLabelPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelPosDirty();
        }
        return this.labelposDirtyFlag;
    }

    public void resetLabelPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelPos();
            return;
        }
        this.labelposDirtyFlag = false;
        this.labelpos = null;
    }

    public void setLabelPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelpssyscssid = string;
        this.labelpssyscssidDirtyFlag = true;
    }

    public String getLabelPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPSSysCssId();
        }
        return this.labelpssyscssid;
    }

    public boolean isLabelPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelPSSysCssIdDirty();
        }
        return this.labelpssyscssidDirtyFlag;
    }

    public void resetLabelPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelPSSysCssId();
            return;
        }
        this.labelpssyscssidDirtyFlag = false;
        this.labelpssyscssid = null;
    }

    public void setLabelPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelpssyscssname = string;
        this.labelpssyscssnameDirtyFlag = true;
    }

    public String getLabelPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPSSysCssName();
        }
        return this.labelpssyscssname;
    }

    public boolean isLabelPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelPSSysCssNameDirty();
        }
        return this.labelpssyscssnameDirtyFlag;
    }

    public void resetLabelPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelPSSysCssName();
            return;
        }
        this.labelpssyscssnameDirtyFlag = false;
        this.labelpssyscssname = null;
    }

    public void setLabelRawCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelRawCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.labelrawcssstyle = string;
        this.labelrawcssstyleDirtyFlag = true;
    }

    public String getLabelRawCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelRawCssStyle();
        }
        return this.labelrawcssstyle;
    }

    public boolean isLabelRawCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelRawCssStyleDirty();
        }
        return this.labelrawcssstyleDirtyFlag;
    }

    public void resetLabelRawCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelRawCssStyle();
            return;
        }
        this.labelrawcssstyleDirtyFlag = false;
        this.labelrawcssstyle = null;
    }

    public void setLabelWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLabelWidth(n);
            return;
        }
        this.labelwidth = n;
        this.labelwidthDirtyFlag = true;
    }

    public Integer getLabelWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelWidth();
        }
        return this.labelwidth;
    }

    public boolean isLabelWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLabelWidthDirty();
        }
        return this.labelwidthDirtyFlag;
    }

    public void resetLabelWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLabelWidth();
            return;
        }
        this.labelwidthDirtyFlag = false;
        this.labelwidth = null;
    }

    public void setLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutmode = string;
        this.layoutmodeDirtyFlag = true;
    }

    public String getLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutMode();
        }
        return this.layoutmode;
    }

    public boolean isLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutModeDirty();
        }
        return this.layoutmodeDirtyFlag;
    }

    public void resetLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutMode();
            return;
        }
        this.layoutmodeDirtyFlag = false;
        this.layoutmode = null;
    }

    public void setLevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leveltag = string;
        this.leveltagDirtyFlag = true;
    }

    public String getLevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelTag();
        }
        return this.leveltag;
    }

    public boolean isLevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelTagDirty();
        }
        return this.leveltagDirtyFlag;
    }

    public void resetLevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelTag();
            return;
        }
        this.leveltagDirtyFlag = false;
        this.leveltag = null;
    }

    public void setLevelValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelValue(n);
            return;
        }
        this.levelvalue = n;
        this.levelvalueDirtyFlag = true;
    }

    public Integer getLevelValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelValue();
        }
        return this.levelvalue;
    }

    public boolean isLevelValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelValueDirty();
        }
        return this.levelvalueDirtyFlag;
    }

    public void resetLevelValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelValue();
            return;
        }
        this.levelvalueDirtyFlag = false;
        this.levelvalue = null;
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

    public void setMargin(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMargin(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.margin = string;
        this.marginDirtyFlag = true;
    }

    public String getMargin() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMargin();
        }
        return this.margin;
    }

    public boolean isMarginDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMarginDirty();
        }
        return this.marginDirtyFlag;
    }

    public void resetMargin() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMargin();
            return;
        }
        this.marginDirtyFlag = false;
        this.margin = null;
    }

    public void setMaskInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaskInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maskinfo = string;
        this.maskinfoDirtyFlag = true;
    }

    public String getMaskInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaskInfo();
        }
        return this.maskinfo;
    }

    public boolean isMaskInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaskInfoDirty();
        }
        return this.maskinfoDirtyFlag;
    }

    public void resetMaskInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaskInfo();
            return;
        }
        this.maskinfoDirtyFlag = false;
        this.maskinfo = null;
    }

    public void setMaskMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaskMode(n);
            return;
        }
        this.maskmode = n;
        this.maskmodeDirtyFlag = true;
    }

    public Integer getMaskMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaskMode();
        }
        return this.maskmode;
    }

    public boolean isMaskModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaskModeDirty();
        }
        return this.maskmodeDirtyFlag;
    }

    public void resetMaskMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaskMode();
            return;
        }
        this.maskmodeDirtyFlag = false;
        this.maskmode = null;
    }

    public void setMaskPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaskPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maskpslanresid = string;
        this.maskpslanresidDirtyFlag = true;
    }

    public String getMaskPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaskPSLanResId();
        }
        return this.maskpslanresid;
    }

    public boolean isMaskPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaskPSLanResIdDirty();
        }
        return this.maskpslanresidDirtyFlag;
    }

    public void resetMaskPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaskPSLanResId();
            return;
        }
        this.maskpslanresidDirtyFlag = false;
        this.maskpslanresid = null;
    }

    public void setMaskPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaskPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maskpslanresname = string;
        this.maskpslanresnameDirtyFlag = true;
    }

    public String getMaskPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaskPSLanResName();
        }
        return this.maskpslanresname;
    }

    public boolean isMaskPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaskPSLanResNameDirty();
        }
        return this.maskpslanresnameDirtyFlag;
    }

    public void resetMaskPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaskPSLanResName();
            return;
        }
        this.maskpslanresnameDirtyFlag = false;
        this.maskpslanresname = null;
    }

    public void setMDCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdctrltype = string;
        this.mdctrltypeDirtyFlag = true;
    }

    public String getMDCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDCtrlType();
        }
        return this.mdctrltype;
    }

    public boolean isMDCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDCtrlTypeDirty();
        }
        return this.mdctrltypeDirtyFlag;
    }

    public void resetMDCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDCtrlType();
            return;
        }
        this.mdctrltypeDirtyFlag = false;
        this.mdctrltype = null;
    }

    public void setMDPSDEDataViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEDataViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdedataviewid = string;
        this.mdpsdedataviewidDirtyFlag = true;
    }

    public String getMDPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEDataViewId();
        }
        return this.mdpsdedataviewid;
    }

    public boolean isMDPSDEDataViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEDataViewIdDirty();
        }
        return this.mdpsdedataviewidDirtyFlag;
    }

    public void resetMDPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEDataViewId();
            return;
        }
        this.mdpsdedataviewidDirtyFlag = false;
        this.mdpsdedataviewid = null;
    }

    public void setMDPSDEDataViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEDataViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdedataviewname = string;
        this.mdpsdedataviewnameDirtyFlag = true;
    }

    public String getMDPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEDataViewName();
        }
        return this.mdpsdedataviewname;
    }

    public boolean isMDPSDEDataViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEDataViewNameDirty();
        }
        return this.mdpsdedataviewnameDirtyFlag;
    }

    public void resetMDPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEDataViewName();
            return;
        }
        this.mdpsdedataviewnameDirtyFlag = false;
        this.mdpsdedataviewname = null;
    }

    public void setMDPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdeformid = string;
        this.mdpsdeformidDirtyFlag = true;
    }

    public String getMDPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEFormId();
        }
        return this.mdpsdeformid;
    }

    public boolean isMDPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEFormIdDirty();
        }
        return this.mdpsdeformidDirtyFlag;
    }

    public void resetMDPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEFormId();
            return;
        }
        this.mdpsdeformidDirtyFlag = false;
        this.mdpsdeformid = null;
    }

    public void setMDPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdeformname = string;
        this.mdpsdeformnameDirtyFlag = true;
    }

    public String getMDPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEFormName();
        }
        return this.mdpsdeformname;
    }

    public boolean isMDPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEFormNameDirty();
        }
        return this.mdpsdeformnameDirtyFlag;
    }

    public void resetMDPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEFormName();
            return;
        }
        this.mdpsdeformnameDirtyFlag = false;
        this.mdpsdeformname = null;
    }

    public void setMDPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdegridid = string;
        this.mdpsdegrididDirtyFlag = true;
    }

    public String getMDPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEGridId();
        }
        return this.mdpsdegridid;
    }

    public boolean isMDPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEGridIdDirty();
        }
        return this.mdpsdegrididDirtyFlag;
    }

    public void resetMDPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEGridId();
            return;
        }
        this.mdpsdegrididDirtyFlag = false;
        this.mdpsdegridid = null;
    }

    public void setMDPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdegridname = string;
        this.mdpsdegridnameDirtyFlag = true;
    }

    public String getMDPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEGridName();
        }
        return this.mdpsdegridname;
    }

    public boolean isMDPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEGridNameDirty();
        }
        return this.mdpsdegridnameDirtyFlag;
    }

    public void resetMDPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEGridName();
            return;
        }
        this.mdpsdegridnameDirtyFlag = false;
        this.mdpsdegridname = null;
    }

    public void setMDPSDEListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdelistid = string;
        this.mdpsdelistidDirtyFlag = true;
    }

    public String getMDPSDEListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEListId();
        }
        return this.mdpsdelistid;
    }

    public boolean isMDPSDEListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEListIdDirty();
        }
        return this.mdpsdelistidDirtyFlag;
    }

    public void resetMDPSDEListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEListId();
            return;
        }
        this.mdpsdelistidDirtyFlag = false;
        this.mdpsdelistid = null;
    }

    public void setMDPSDEListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSDEListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpsdelistname = string;
        this.mdpsdelistnameDirtyFlag = true;
    }

    public String getMDPSDEListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEListName();
        }
        return this.mdpsdelistname;
    }

    public boolean isMDPSDEListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSDEListNameDirty();
        }
        return this.mdpsdelistnameDirtyFlag;
    }

    public void resetMDPSDEListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSDEListName();
            return;
        }
        this.mdpsdelistnameDirtyFlag = false;
        this.mdpsdelistname = null;
    }

    public void setMDPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpssysviewpanelid = string;
        this.mdpssysviewpanelidDirtyFlag = true;
    }

    public String getMDPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSSysViewPanelId();
        }
        return this.mdpssysviewpanelid;
    }

    public boolean isMDPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSSysViewPanelIdDirty();
        }
        return this.mdpssysviewpanelidDirtyFlag;
    }

    public void resetMDPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSSysViewPanelId();
            return;
        }
        this.mdpssysviewpanelidDirtyFlag = false;
        this.mdpssysviewpanelid = null;
    }

    public void setMDPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMDPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mdpssysviewpanelname = string;
        this.mdpssysviewpanelnameDirtyFlag = true;
    }

    public String getMDPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSSysViewPanelName();
        }
        return this.mdpssysviewpanelname;
    }

    public boolean isMDPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMDPSSysViewPanelNameDirty();
        }
        return this.mdpssysviewpanelnameDirtyFlag;
    }

    public void resetMDPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMDPSSysViewPanelName();
            return;
        }
        this.mdpssysviewpanelnameDirtyFlag = false;
        this.mdpssysviewpanelname = null;
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

    public void setMobFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobFlag(n);
            return;
        }
        this.mobflag = n;
        this.mobflagDirtyFlag = true;
    }

    public Integer getMobFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobFlag();
        }
        return this.mobflag;
    }

    public boolean isMobFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobFlagDirty();
        }
        return this.mobflagDirtyFlag;
    }

    public void resetMobFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobFlag();
            return;
        }
        this.mobflagDirtyFlag = false;
        this.mobflag = null;
    }

    public void setModelState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelState(n);
            return;
        }
        this.modelstate = n;
        this.modelstateDirtyFlag = true;
    }

    public Integer getModelState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelState();
        }
        return this.modelstate;
    }

    public boolean isModelStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateDirty();
        }
        return this.modelstateDirtyFlag;
    }

    public void resetModelState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelState();
            return;
        }
        this.modelstateDirtyFlag = false;
        this.modelstate = null;
    }

    public void setNeedCodeListConfig(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNeedCodeListConfig(n);
            return;
        }
        this.needcodelistconfig = n;
        this.needcodelistconfigDirtyFlag = true;
    }

    public Integer getNeedCodeListConfig() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNeedCodeListConfig();
        }
        return this.needcodelistconfig;
    }

    public boolean isNeedCodeListConfigDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNeedCodeListConfigDirty();
        }
        return this.needcodelistconfigDirtyFlag;
    }

    public void resetNeedCodeListConfig() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNeedCodeListConfig();
            return;
        }
        this.needcodelistconfigDirtyFlag = false;
        this.needcodelistconfig = null;
    }

    public void setNoPrivDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoPrivDM(n);
            return;
        }
        this.noprivdm = n;
        this.noprivdmDirtyFlag = true;
    }

    public Integer getNoPrivDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoPrivDM();
        }
        return this.noprivdm;
    }

    public boolean isNoPrivDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoPrivDMDirty();
        }
        return this.noprivdmDirtyFlag;
    }

    public void resetNoPrivDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoPrivDM();
            return;
        }
        this.noprivdmDirtyFlag = false;
        this.noprivdm = null;
    }

    public void setOpenPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsdeviewid = string;
        this.openpsdeviewidDirtyFlag = true;
    }

    public String getOpenPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSDEViewId();
        }
        return this.openpsdeviewid;
    }

    public boolean isOpenPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSDEViewIdDirty();
        }
        return this.openpsdeviewidDirtyFlag;
    }

    public void resetOpenPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSDEViewId();
            return;
        }
        this.openpsdeviewidDirtyFlag = false;
        this.openpsdeviewid = null;
    }

    public void setOpenPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsdeviewname = string;
        this.openpsdeviewnameDirtyFlag = true;
    }

    public String getOpenPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSDEViewName();
        }
        return this.openpsdeviewname;
    }

    public boolean isOpenPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSDEViewNameDirty();
        }
        return this.openpsdeviewnameDirtyFlag;
    }

    public void resetOpenPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSDEViewName();
            return;
        }
        this.openpsdeviewnameDirtyFlag = false;
        this.openpsdeviewname = null;
    }

    public void setOpenPSSysPDTViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSSysPDTViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpssyspdtviewid = string;
        this.openpssyspdtviewidDirtyFlag = true;
    }

    public String getOpenPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSSysPDTViewId();
        }
        return this.openpssyspdtviewid;
    }

    public boolean isOpenPSSysPDTViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSSysPDTViewIdDirty();
        }
        return this.openpssyspdtviewidDirtyFlag;
    }

    public void resetOpenPSSysPDTViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSSysPDTViewId();
            return;
        }
        this.openpssyspdtviewidDirtyFlag = false;
        this.openpssyspdtviewid = null;
    }

    public void setOpenPSSysPDTViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSSysPDTViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpssyspdtviewname = string;
        this.openpssyspdtviewnameDirtyFlag = true;
    }

    public String getOpenPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSSysPDTViewName();
        }
        return this.openpssyspdtviewname;
    }

    public boolean isOpenPSSysPDTViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSSysPDTViewNameDirty();
        }
        return this.openpssyspdtviewnameDirtyFlag;
    }

    public void resetOpenPSSysPDTViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSSysPDTViewName();
            return;
        }
        this.openpssyspdtviewnameDirtyFlag = false;
        this.openpssyspdtviewname = null;
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

    public void setPadding(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPadding(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.padding = string;
        this.paddingDirtyFlag = true;
    }

    public String getPadding() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPadding();
        }
        return this.padding;
    }

    public boolean isPaddingDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPaddingDirty();
        }
        return this.paddingDirtyFlag;
    }

    public void resetPadding() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPadding();
            return;
        }
        this.paddingDirtyFlag = false;
        this.padding = null;
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

    public void setPLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.playoutmode = string;
        this.playoutmodeDirtyFlag = true;
    }

    public String getPLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPLayoutMode();
        }
        return this.playoutmode;
    }

    public boolean isPLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPLayoutModeDirty();
        }
        return this.playoutmodeDirtyFlag;
    }

    public void resetPLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPLayoutMode();
            return;
        }
        this.playoutmodeDirtyFlag = false;
        this.playoutmode = null;
    }

    public void setPPSDEFormDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEFormDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdeformdetailid = string;
        this.ppsdeformdetailidDirtyFlag = true;
    }

    public String getPPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFormDetailId();
        }
        return this.ppsdeformdetailid;
    }

    public boolean isPPSDEFormDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEFormDetailIdDirty();
        }
        return this.ppsdeformdetailidDirtyFlag;
    }

    public void resetPPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEFormDetailId();
            return;
        }
        this.ppsdeformdetailidDirtyFlag = false;
        this.ppsdeformdetailid = null;
    }

    public void setPPSDEFormDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEFormDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdeformdetailname = string;
        this.ppsdeformdetailnameDirtyFlag = true;
    }

    public String getPPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFormDetailName();
        }
        return this.ppsdeformdetailname;
    }

    public boolean isPPSDEFormDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEFormDetailNameDirty();
        }
        return this.ppsdeformdetailnameDirtyFlag;
    }

    public void resetPPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEFormDetailName();
            return;
        }
        this.ppsdeformdetailnameDirtyFlag = false;
        this.ppsdeformdetailname = null;
    }

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPredefinedTypeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypetext = string;
        this.predefinedtypetextDirtyFlag = true;
    }

    public String getPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeText();
        }
        return this.predefinedtypetext;
    }

    public boolean isPredefinedTypeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeTextDirty();
        }
        return this.predefinedtypetextDirtyFlag;
    }

    public void resetPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeText();
            return;
        }
        this.predefinedtypetextDirtyFlag = false;
        this.predefinedtypetext = null;
    }

    public void setPreventXSS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreventXSS(n);
            return;
        }
        this.preventxss = n;
        this.preventxssDirtyFlag = true;
    }

    public Integer getPreventXSS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreventXSS();
        }
        return this.preventxss;
    }

    public boolean isPreventXSSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreventXSSDirty();
        }
        return this.preventxssDirtyFlag;
    }

    public void resetPreventXSS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreventXSS();
            return;
        }
        this.preventxssDirtyFlag = false;
        this.preventxss = null;
    }

    public void setPreviewHtml(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreviewHtml(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.previewhtml = string;
        this.previewhtmlDirtyFlag = true;
    }

    public String getPreviewHtml() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreviewHtml();
        }
        return this.previewhtml;
    }

    public boolean isPreviewHtmlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreviewHtmlDirty();
        }
        return this.previewhtmlDirtyFlag;
    }

    public void resetPreviewHtml() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreviewHtml();
            return;
        }
        this.previewhtmlDirtyFlag = false;
        this.previewhtml = null;
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

    public void setPSDEDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrid = string;
        this.psdedridDirtyFlag = true;
    }

    public String getPSDEDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRId();
        }
        return this.psdedrid;
    }

    public boolean isPSDEDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRIdDirty();
        }
        return this.psdedridDirtyFlag;
    }

    public void resetPSDEDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRId();
            return;
        }
        this.psdedridDirtyFlag = false;
        this.psdedrid = null;
    }

    public void setPSDEDRItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedritemid = string;
        this.psdedritemidDirtyFlag = true;
    }

    public String getPSDEDRItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemId();
        }
        return this.psdedritemid;
    }

    public boolean isPSDEDRItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemIdDirty();
        }
        return this.psdedritemidDirtyFlag;
    }

    public void resetPSDEDRItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemId();
            return;
        }
        this.psdedritemidDirtyFlag = false;
        this.psdedritemid = null;
    }

    public void setPSDEDRItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedritemname = string;
        this.psdedritemnameDirtyFlag = true;
    }

    public String getPSDEDRItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItemName();
        }
        return this.psdedritemname;
    }

    public boolean isPSDEDRItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRItemNameDirty();
        }
        return this.psdedritemnameDirtyFlag;
    }

    public void resetPSDEDRItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRItemName();
            return;
        }
        this.psdedritemnameDirtyFlag = false;
        this.psdedritemname = null;
    }

    public void setPSDEDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedrname = string;
        this.psdedrnameDirtyFlag = true;
    }

    public String getPSDEDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRName();
        }
        return this.psdedrname;
    }

    public boolean isPSDEDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDRNameDirty();
        }
        return this.psdedrnameDirtyFlag;
    }

    public void resetPSDEDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDRName();
            return;
        }
        this.psdedrnameDirtyFlag = false;
        this.psdedrname = null;
    }

    public void setPSDEFUIModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodeid = string;
        this.psdefuimodeidDirtyFlag = true;
    }

    public String getPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeId();
        }
        return this.psdefuimodeid;
    }

    public boolean isPSDEFUIModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeIdDirty();
        }
        return this.psdefuimodeidDirtyFlag;
    }

    public void resetPSDEFUIModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeId();
            return;
        }
        this.psdefuimodeidDirtyFlag = false;
        this.psdefuimodeid = null;
    }

    public void setPSDEFUIModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFUIModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefuimodename = string;
        this.psdefuimodenameDirtyFlag = true;
    }

    public String getPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIModeName();
        }
        return this.psdefuimodename;
    }

    public boolean isPSDEFUIModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFUIModeNameDirty();
        }
        return this.psdefuimodenameDirtyFlag;
    }

    public void resetPSDEFUIModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFUIModeName();
            return;
        }
        this.psdefuimodenameDirtyFlag = false;
        this.psdefuimodename = null;
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

    public void setPSDEFIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiupdateid = string;
        this.psdefiupdateidDirtyFlag = true;
    }

    public String getPSDEFIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdateId();
        }
        return this.psdefiupdateid;
    }

    public boolean isPSDEFIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUpdateIdDirty();
        }
        return this.psdefiupdateidDirtyFlag;
    }

    public void resetPSDEFIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUpdateId();
            return;
        }
        this.psdefiupdateidDirtyFlag = false;
        this.psdefiupdateid = null;
    }

    public void setPSDEFIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiupdatename = string;
        this.psdefiupdatenameDirtyFlag = true;
    }

    public String getPSDEFIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdateName();
        }
        return this.psdefiupdatename;
    }

    public boolean isPSDEFIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUpdateNameDirty();
        }
        return this.psdefiupdatenameDirtyFlag;
    }

    public void resetPSDEFIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUpdateName();
            return;
        }
        this.psdefiupdatenameDirtyFlag = false;
        this.psdefiupdatename = null;
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

    public void setPSDEFormDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailid = string;
        this.psdeformdetailidDirtyFlag = true;
    }

    public String getPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailId();
        }
        return this.psdeformdetailid;
    }

    public boolean isPSDEFormDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailIdDirty();
        }
        return this.psdeformdetailidDirtyFlag;
    }

    public void resetPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailId();
            return;
        }
        this.psdeformdetailidDirtyFlag = false;
        this.psdeformdetailid = null;
    }

    public void setPSDEFormDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailname = string;
        this.psdeformdetailnameDirtyFlag = true;
    }

    public String getPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailName();
        }
        return this.psdeformdetailname;
    }

    public boolean isPSDEFormDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailNameDirty();
        }
        return this.psdeformdetailnameDirtyFlag;
    }

    public void resetPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailName();
            return;
        }
        this.psdeformdetailnameDirtyFlag = false;
        this.psdeformdetailname = null;
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

    public void setPSDEFormRFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormRFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformrfid = string;
        this.psdeformrfidDirtyFlag = true;
    }

    public String getPSDEFormRFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormRFId();
        }
        return this.psdeformrfid;
    }

    public boolean isPSDEFormRFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormRFIdDirty();
        }
        return this.psdeformrfidDirtyFlag;
    }

    public void resetPSDEFormRFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormRFId();
            return;
        }
        this.psdeformrfidDirtyFlag = false;
        this.psdeformrfid = null;
    }

    public void setPSDEFormRFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormRFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformrfname = string;
        this.psdeformrfnameDirtyFlag = true;
    }

    public String getPSDEFormRFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormRFName();
        }
        return this.psdeformrfname;
    }

    public boolean isPSDEFormRFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormRFNameDirty();
        }
        return this.psdeformrfnameDirtyFlag;
    }

    public void resetPSDEFormRFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormRFName();
            return;
        }
        this.psdeformrfnameDirtyFlag = false;
        this.psdeformrfname = null;
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

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
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

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
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

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
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

    public void setPSSysDictCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDictCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdictcatid = string;
        this.pssysdictcatidDirtyFlag = true;
    }

    public String getPSSysDictCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCatId();
        }
        return this.pssysdictcatid;
    }

    public boolean isPSSysDictCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDictCatIdDirty();
        }
        return this.pssysdictcatidDirtyFlag;
    }

    public void resetPSSysDictCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDictCatId();
            return;
        }
        this.pssysdictcatidDirtyFlag = false;
        this.pssysdictcatid = null;
    }

    public void setPSSysDictCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDictCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdictcatname = string;
        this.pssysdictcatnameDirtyFlag = true;
    }

    public String getPSSysDictCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCatName();
        }
        return this.pssysdictcatname;
    }

    public boolean isPSSysDictCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDictCatNameDirty();
        }
        return this.pssysdictcatnameDirtyFlag;
    }

    public void resetPSSysDictCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDictCatName();
            return;
        }
        this.pssysdictcatnameDirtyFlag = false;
        this.pssysdictcatname = null;
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

    public void setRawContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcontent = string;
        this.rawcontentDirtyFlag = true;
    }

    public String getRawContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawContent();
        }
        return this.rawcontent;
    }

    public boolean isRawContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawContentDirty();
        }
        return this.rawcontentDirtyFlag;
    }

    public void resetRawContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawContent();
            return;
        }
        this.rawcontentDirtyFlag = false;
        this.rawcontent = null;
    }

    public void setRawCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcssstyle = string;
        this.rawcssstyleDirtyFlag = true;
    }

    public String getRawCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawCssStyle();
        }
        return this.rawcssstyle;
    }

    public boolean isRawCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawCssStyleDirty();
        }
        return this.rawcssstyleDirtyFlag;
    }

    public void resetRawCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawCssStyle();
            return;
        }
        this.rawcssstyleDirtyFlag = false;
        this.rawcssstyle = null;
    }

    public void setRawServiceMethod(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawServiceMethod(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawservicemethod = string;
        this.rawservicemethodDirtyFlag = true;
    }

    public String getRawServiceMethod() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawServiceMethod();
        }
        return this.rawservicemethod;
    }

    public boolean isRawServiceMethodDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawServiceMethodDirty();
        }
        return this.rawservicemethodDirtyFlag;
    }

    public void resetRawServiceMethod() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawServiceMethod();
            return;
        }
        this.rawservicemethodDirtyFlag = false;
        this.rawservicemethod = null;
    }

    public void setRawServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawserviceurl = string;
        this.rawserviceurlDirtyFlag = true;
    }

    public String getRawServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawServiceUrl();
        }
        return this.rawserviceurl;
    }

    public boolean isRawServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawServiceUrlDirty();
        }
        return this.rawserviceurlDirtyFlag;
    }

    public void resetRawServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawServiceUrl();
            return;
        }
        this.rawserviceurlDirtyFlag = false;
        this.rawserviceurl = null;
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

    public void setRefPSDEFormDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEFormDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeformdetailid = string;
        this.refpsdeformdetailidDirtyFlag = true;
    }

    public String getRefPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEFormDetailId();
        }
        return this.refpsdeformdetailid;
    }

    public boolean isRefPSDEFormDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEFormDetailIdDirty();
        }
        return this.refpsdeformdetailidDirtyFlag;
    }

    public void resetRefPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEFormDetailId();
            return;
        }
        this.refpsdeformdetailidDirtyFlag = false;
        this.refpsdeformdetailid = null;
    }

    public void setRefPSDEFormDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEFormDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeformdetailname = string;
        this.refpsdeformdetailnameDirtyFlag = true;
    }

    public String getRefPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEFormDetailName();
        }
        return this.refpsdeformdetailname;
    }

    public boolean isRefPSDEFormDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEFormDetailNameDirty();
        }
        return this.refpsdeformdetailnameDirtyFlag;
    }

    public void resetRefPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEFormDetailName();
            return;
        }
        this.refpsdeformdetailnameDirtyFlag = false;
        this.refpsdeformdetailname = null;
    }

    public void setRefPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeformid = string;
        this.refpsdeformidDirtyFlag = true;
    }

    public String getRefPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEFormId();
        }
        return this.refpsdeformid;
    }

    public boolean isRefPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEFormIdDirty();
        }
        return this.refpsdeformidDirtyFlag;
    }

    public void resetRefPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEFormId();
            return;
        }
        this.refpsdeformidDirtyFlag = false;
        this.refpsdeformid = null;
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

    public void setRenderMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRenderMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rendermode = string;
        this.rendermodeDirtyFlag = true;
    }

    public String getRenderMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRenderMode();
        }
        return this.rendermode;
    }

    public boolean isRenderModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRenderModeDirty();
        }
        return this.rendermodeDirtyFlag;
    }

    public void resetRenderMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRenderMode();
            return;
        }
        this.rendermodeDirtyFlag = false;
        this.rendermode = null;
    }

    public void setRenderModeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRenderModeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rendermodetext = string;
        this.rendermodetextDirtyFlag = true;
    }

    public String getRenderModeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRenderModeText();
        }
        return this.rendermodetext;
    }

    public boolean isRenderModeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRenderModeTextDirty();
        }
        return this.rendermodetextDirtyFlag;
    }

    public void resetRenderModeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRenderModeText();
            return;
        }
        this.rendermodetextDirtyFlag = false;
        this.rendermodetext = null;
    }

    public void setResetItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResetItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resetitemname = string;
        this.resetitemnameDirtyFlag = true;
    }

    public String getResetItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResetItemName();
        }
        return this.resetitemname;
    }

    public boolean isResetItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResetItemNameDirty();
        }
        return this.resetitemnameDirtyFlag;
    }

    public void resetResetItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResetItemName();
            return;
        }
        this.resetitemnameDirtyFlag = false;
        this.resetitemname = null;
    }

    public void setRowSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRowSpan(n);
            return;
        }
        this.rowspan = n;
        this.rowspanDirtyFlag = true;
    }

    public Integer getRowSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRowSpan();
        }
        return this.rowspan;
    }

    public boolean isRowSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRowSpanDirty();
        }
        return this.rowspanDirtyFlag;
    }

    public void resetRowSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRowSpan();
            return;
        }
        this.rowspanDirtyFlag = false;
        this.rowspan = null;
    }

    public void setShowCaption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowCaption(n);
            return;
        }
        this.showcaption = n;
        this.showcaptionDirtyFlag = true;
    }

    public Integer getShowCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowCaption();
        }
        return this.showcaption;
    }

    public boolean isShowCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowCaptionDirty();
        }
        return this.showcaptionDirtyFlag;
    }

    public void resetShowCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowCaption();
            return;
        }
        this.showcaptionDirtyFlag = false;
        this.showcaption = null;
    }

    public void setShowMoreMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowMoreMode(n);
            return;
        }
        this.showmoremode = n;
        this.showmoremodeDirtyFlag = true;
    }

    public Integer getShowMoreMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowMoreMode();
        }
        return this.showmoremode;
    }

    public boolean isShowMoreModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowMoreModeDirty();
        }
        return this.showmoremodeDirtyFlag;
    }

    public void resetShowMoreMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowMoreMode();
            return;
        }
        this.showmoremodeDirtyFlag = false;
        this.showmoremode = null;
    }

    public void setSpacingBottom(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpacingBottom(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.spacingbottom = string;
        this.spacingbottomDirtyFlag = true;
    }

    public String getSpacingBottom() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpacingBottom();
        }
        return this.spacingbottom;
    }

    public boolean isSpacingBottomDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpacingBottomDirty();
        }
        return this.spacingbottomDirtyFlag;
    }

    public void resetSpacingBottom() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpacingBottom();
            return;
        }
        this.spacingbottomDirtyFlag = false;
        this.spacingbottom = null;
    }

    public void setSpacingLeft(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpacingLeft(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.spacingleft = string;
        this.spacingleftDirtyFlag = true;
    }

    public String getSpacingLeft() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpacingLeft();
        }
        return this.spacingleft;
    }

    public boolean isSpacingLeftDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpacingLeftDirty();
        }
        return this.spacingleftDirtyFlag;
    }

    public void resetSpacingLeft() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpacingLeft();
            return;
        }
        this.spacingleftDirtyFlag = false;
        this.spacingleft = null;
    }

    public void setSpacingRight(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpacingRight(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.spacingright = string;
        this.spacingrightDirtyFlag = true;
    }

    public String getSpacingRight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpacingRight();
        }
        return this.spacingright;
    }

    public boolean isSpacingRightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpacingRightDirty();
        }
        return this.spacingrightDirtyFlag;
    }

    public void resetSpacingRight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpacingRight();
            return;
        }
        this.spacingrightDirtyFlag = false;
        this.spacingright = null;
    }

    public void setSpacingTop(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSpacingTop(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.spacingtop = string;
        this.spacingtopDirtyFlag = true;
    }

    public String getSpacingTop() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSpacingTop();
        }
        return this.spacingtop;
    }

    public boolean isSpacingTopDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSpacingTopDirty();
        }
        return this.spacingtopDirtyFlag;
    }

    public void resetSpacingTop() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSpacingTop();
            return;
        }
        this.spacingtopDirtyFlag = false;
        this.spacingtop = null;
    }

    public void setSwapMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSwapMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.swapmode = string;
        this.swapmodeDirtyFlag = true;
    }

    public String getSwapMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwapMode();
        }
        return this.swapmode;
    }

    public boolean isSwapModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSwapModeDirty();
        }
        return this.swapmodeDirtyFlag;
    }

    public void resetSwapMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSwapMode();
            return;
        }
        this.swapmodeDirtyFlag = false;
        this.swapmode = null;
    }

    public void setTemplateMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplateMode(n);
            return;
        }
        this.templatemode = n;
        this.templatemodeDirtyFlag = true;
    }

    public Integer getTemplateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplateMode();
        }
        return this.templatemode;
    }

    public boolean isTemplateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplateModeDirty();
        }
        return this.templatemodeDirtyFlag;
    }

    public void resetTemplateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplateMode();
            return;
        }
        this.templatemodeDirtyFlag = false;
        this.templatemode = null;
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

    public void setTitleBarCloseMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitleBarCloseMode(n);
            return;
        }
        this.titlebarclosemode = n;
        this.titlebarclosemodeDirtyFlag = true;
    }

    public Integer getTitleBarCloseMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitleBarCloseMode();
        }
        return this.titlebarclosemode;
    }

    public boolean isTitleBarCloseModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleBarCloseModeDirty();
        }
        return this.titlebarclosemodeDirtyFlag;
    }

    public void resetTitleBarCloseMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitleBarCloseMode();
            return;
        }
        this.titlebarclosemodeDirtyFlag = false;
        this.titlebarclosemode = null;
    }

    public void setToggleMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToggleMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.togglemode = string;
        this.togglemodeDirtyFlag = true;
    }

    public String getToggleMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToggleMode();
        }
        return this.togglemode;
    }

    public boolean isToggleModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToggleModeDirty();
        }
        return this.togglemodeDirtyFlag;
    }

    public void resetToggleMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToggleMode();
            return;
        }
        this.togglemodeDirtyFlag = false;
        this.togglemode = null;
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

    public void setUCPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUCPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ucpssyspfpluginid = string;
        this.ucpssyspfpluginidDirtyFlag = true;
    }

    public String getUCPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCPSSysPFPluginId();
        }
        return this.ucpssyspfpluginid;
    }

    public boolean isUCPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUCPSSysPFPluginIdDirty();
        }
        return this.ucpssyspfpluginidDirtyFlag;
    }

    public void resetUCPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUCPSSysPFPluginId();
            return;
        }
        this.ucpssyspfpluginidDirtyFlag = false;
        this.ucpssyspfpluginid = null;
    }

    public void setUCPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUCPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ucpssyspfpluginname = string;
        this.ucpssyspfpluginnameDirtyFlag = true;
    }

    public String getUCPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCPSSysPFPluginName();
        }
        return this.ucpssyspfpluginname;
    }

    public boolean isUCPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUCPSSysPFPluginNameDirty();
        }
        return this.ucpssyspfpluginnameDirtyFlag;
    }

    public void resetUCPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUCPSSysPFPluginName();
            return;
        }
        this.ucpssyspfpluginnameDirtyFlag = false;
        this.ucpssyspfpluginname = null;
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

    public void setUpdateDV(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDV(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatedv = string;
        this.updatedvDirtyFlag = true;
    }

    public String getUpdateDV() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDV();
        }
        return this.updatedv;
    }

    public boolean isUpdateDVDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDVDirty();
        }
        return this.updatedvDirtyFlag;
    }

    public void resetUpdateDV() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDV();
            return;
        }
        this.updatedvDirtyFlag = false;
        this.updatedv = null;
    }

    public void setUpdateDVT(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDVT(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatedvt = string;
        this.updatedvtDirtyFlag = true;
    }

    public String getUpdateDVT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDVT();
        }
        return this.updatedvt;
    }

    public boolean isUpdateDVTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDVTDirty();
        }
        return this.updatedvtDirtyFlag;
    }

    public void resetUpdateDVT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDVT();
            return;
        }
        this.updatedvtDirtyFlag = false;
        this.updatedvt = null;
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

    public void setVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valign = string;
        this.valignDirtyFlag = true;
    }

    public String getVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVAlign();
        }
        return this.valign;
    }

    public boolean isVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVAlignDirty();
        }
        return this.valignDirtyFlag;
    }

    public void resetVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVAlign();
            return;
        }
        this.valignDirtyFlag = false;
        this.valign = null;
    }

    public void setVAlignSelf(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVAlignSelf(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valignself = string;
        this.valignselfDirtyFlag = true;
    }

    public String getVAlignSelf() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVAlignSelf();
        }
        return this.valignself;
    }

    public boolean isVAlignSelfDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVAlignSelfDirty();
        }
        return this.valignselfDirtyFlag;
    }

    public void resetVAlignSelf() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVAlignSelf();
            return;
        }
        this.valignselfDirtyFlag = false;
        this.valignself = null;
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

    public void setValueItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueitemname = string;
        this.valueitemnameDirtyFlag = true;
    }

    public String getValueItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueItemName();
        }
        return this.valueitemname;
    }

    public boolean isValueItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueItemNameDirty();
        }
        return this.valueitemnameDirtyFlag;
    }

    public void resetValueItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueItemName();
            return;
        }
        this.valueitemnameDirtyFlag = false;
        this.valueitemname = null;
    }

    public void setVisibleLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVisibleLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.visiblelogic = string;
        this.visiblelogicDirtyFlag = true;
    }

    public String getVisibleLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVisibleLogic();
        }
        return this.visiblelogic;
    }

    public boolean isVisibleLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVisibleLogicDirty();
        }
        return this.visiblelogicDirtyFlag;
    }

    public void resetVisibleLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVisibleLogic();
            return;
        }
        this.visiblelogicDirtyFlag = false;
        this.visiblelogic = null;
    }

    public void setWBDEFMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWBDEFMode(n);
            return;
        }
        this.wbdefmode = n;
        this.wbdefmodeDirtyFlag = true;
    }

    public Integer getWBDEFMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWBDEFMode();
        }
        return this.wbdefmode;
    }

    public boolean isWBDEFModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWBDEFModeDirty();
        }
        return this.wbdefmodeDirtyFlag;
    }

    public void resetWBDEFMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWBDEFMode();
            return;
        }
        this.wbdefmodeDirtyFlag = false;
        this.wbdefmode = null;
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

    public void setWidthMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidthMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.widthmode = string;
        this.widthmodeDirtyFlag = true;
    }

    public String getWidthMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidthMode();
        }
        return this.widthmode;
    }

    public boolean isWidthModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthModeDirty();
        }
        return this.widthmodeDirtyFlag;
    }

    public void resetWidthMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidthMode();
            return;
        }
        this.widthmodeDirtyFlag = false;
        this.widthmode = null;
    }

    protected void onReset() {
        PSDEFormDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFormDetailBase pSDEFormDetailBase) {
        pSDEFormDetailBase.resetAllowEmpty();
        pSDEFormDetailBase.resetBlankLogic();
        pSDEFormDetailBase.resetBL_Pos();
        pSDEFormDetailBase.resetBorderStyle();
        pSDEFormDetailBase.resetBtnActionType();
        pSDEFormDetailBase.resetBuildInAction();
        pSDEFormDetailBase.resetCapPSLanResId();
        pSDEFormDetailBase.resetCapPSLanResName();
        pSDEFormDetailBase.resetCaption();
        pSDEFormDetailBase.resetChild_Col_LG();
        pSDEFormDetailBase.resetChild_Col_MD();
        pSDEFormDetailBase.resetChild_Col_SM();
        pSDEFormDetailBase.resetChild_Col_XS();
        pSDEFormDetailBase.resetCodeListConfigMode();
        pSDEFormDetailBase.resetColAlign();
        pSDEFormDetailBase.resetColId();
        pSDEFormDetailBase.resetColModel();
        pSDEFormDetailBase.resetColSpan();
        pSDEFormDetailBase.resetCol_LG();
        pSDEFormDetailBase.resetCol_LG_OS();
        pSDEFormDetailBase.resetCol_MD();
        pSDEFormDetailBase.resetCol_MD_OS();
        pSDEFormDetailBase.resetCol_SM();
        pSDEFormDetailBase.resetCol_SM_OS();
        pSDEFormDetailBase.resetCol_Width();
        pSDEFormDetailBase.resetCol_XS();
        pSDEFormDetailBase.resetCol_XS_OS();
        pSDEFormDetailBase.resetContentType();
        pSDEFormDetailBase.resetConvertCIText();
        pSDEFormDetailBase.resetCounterId();
        pSDEFormDetailBase.resetCounterMode();
        pSDEFormDetailBase.resetCreateDate();
        pSDEFormDetailBase.resetCreateDV();
        pSDEFormDetailBase.resetCreateDVT();
        pSDEFormDetailBase.resetCreateMan();
        pSDEFormDetailBase.resetCssId();
        pSDEFormDetailBase.resetCtrlColSpan();
        pSDEFormDetailBase.resetCtrlDynaClass();
        pSDEFormDetailBase.resetCtrlHeight();
        pSDEFormDetailBase.resetCtrlPSSysCssId();
        pSDEFormDetailBase.resetCtrlPSSysCssName();
        pSDEFormDetailBase.resetCtrlRawCssStyle();
        pSDEFormDetailBase.resetCtrlWidth();
        pSDEFormDetailBase.resetCustomCode();
        pSDEFormDetailBase.resetData();
        pSDEFormDetailBase.resetDefaultFlag();
        pSDEFormDetailBase.resetDetailStyle();
        pSDEFormDetailBase.resetDetailStyleText();
        pSDEFormDetailBase.resetDetailTag();
        pSDEFormDetailBase.resetDetailTag2();
        pSDEFormDetailBase.resetDetailType();
        pSDEFormDetailBase.resetDynaClass();
        pSDEFormDetailBase.resetDynaModelFlag();
        pSDEFormDetailBase.resetEditorParams();
        pSDEFormDetailBase.resetEditorType();
        pSDEFormDetailBase.resetEditorTypeName();
        pSDEFormDetailBase.resetEmptyCaption();
        pSDEFormDetailBase.resetEnableAnchor();
        pSDEFormDetailBase.resetEnableCond();
        pSDEFormDetailBase.resetEnableInputTip();
        pSDEFormDetailBase.resetEnableItemPriv();
        pSDEFormDetailBase.resetEnableLogic();
        pSDEFormDetailBase.resetFieldName();
        pSDEFormDetailBase.resetFlexAlign();
        pSDEFormDetailBase.resetFlexBasis();
        pSDEFormDetailBase.resetFlexDir();
        pSDEFormDetailBase.resetFlexGrow();
        pSDEFormDetailBase.resetFlexShrink();
        pSDEFormDetailBase.resetFlexVAlign();
        pSDEFormDetailBase.resetFormType();
        pSDEFormDetailBase.resetGridRowId();
        pSDEFormDetailBase.resetHAlign();
        pSDEFormDetailBase.resetHAlignSelf();
        pSDEFormDetailBase.resetHeight();
        pSDEFormDetailBase.resetHeightMode();
        pSDEFormDetailBase.resetHtmlContent();
        pSDEFormDetailBase.resetHtmlPageUrl();
        pSDEFormDetailBase.resetIconAlign();
        pSDEFormDetailBase.resetIgnoreInput();
        pSDEFormDetailBase.resetInsertPos();
        pSDEFormDetailBase.resetItemPSACHandlerId();
        pSDEFormDetailBase.resetItemPSACHandlerName();
        pSDEFormDetailBase.resetItemStates();
        pSDEFormDetailBase.resetLabelColSpan();
        pSDEFormDetailBase.resetLabelColSpan2();
        pSDEFormDetailBase.resetLabelCssId();
        pSDEFormDetailBase.resetLabelDynaClass();
        pSDEFormDetailBase.resetLabelPos();
        pSDEFormDetailBase.resetLabelPSSysCssId();
        pSDEFormDetailBase.resetLabelPSSysCssName();
        pSDEFormDetailBase.resetLabelRawCssStyle();
        pSDEFormDetailBase.resetLabelWidth();
        pSDEFormDetailBase.resetLayoutMode();
        pSDEFormDetailBase.resetLevelTag();
        pSDEFormDetailBase.resetLevelValue();
        pSDEFormDetailBase.resetLinkPSDEViewId();
        pSDEFormDetailBase.resetLinkPSDEViewName();
        pSDEFormDetailBase.resetLogicName();
        pSDEFormDetailBase.resetMargin();
        pSDEFormDetailBase.resetMaskInfo();
        pSDEFormDetailBase.resetMaskMode();
        pSDEFormDetailBase.resetMaskPSLanResId();
        pSDEFormDetailBase.resetMaskPSLanResName();
        pSDEFormDetailBase.resetMDCtrlType();
        pSDEFormDetailBase.resetMDPSDEDataViewId();
        pSDEFormDetailBase.resetMDPSDEDataViewName();
        pSDEFormDetailBase.resetMDPSDEFormId();
        pSDEFormDetailBase.resetMDPSDEFormName();
        pSDEFormDetailBase.resetMDPSDEGridId();
        pSDEFormDetailBase.resetMDPSDEGridName();
        pSDEFormDetailBase.resetMDPSDEListId();
        pSDEFormDetailBase.resetMDPSDEListName();
        pSDEFormDetailBase.resetMDPSSysViewPanelId();
        pSDEFormDetailBase.resetMDPSSysViewPanelName();
        pSDEFormDetailBase.resetMemo();
        pSDEFormDetailBase.resetMobFlag();
        pSDEFormDetailBase.resetModelState();
        pSDEFormDetailBase.resetNeedCodeListConfig();
        pSDEFormDetailBase.resetNoPrivDM();
        pSDEFormDetailBase.resetOpenPSDEViewId();
        pSDEFormDetailBase.resetOpenPSDEViewName();
        pSDEFormDetailBase.resetOpenPSSysPDTViewId();
        pSDEFormDetailBase.resetOpenPSSysPDTViewName();
        pSDEFormDetailBase.resetOrderValue();
        pSDEFormDetailBase.resetPadding();
        pSDEFormDetailBase.resetPHPSLanResId();
        pSDEFormDetailBase.resetPHPSLanResName();
        pSDEFormDetailBase.resetPickupPSDEViewId();
        pSDEFormDetailBase.resetPickupPSDEViewName();
        pSDEFormDetailBase.resetPlaceHolder();
        pSDEFormDetailBase.resetPLayoutMode();
        pSDEFormDetailBase.resetPPSDEFormDetailId();
        pSDEFormDetailBase.resetPPSDEFormDetailName();
        pSDEFormDetailBase.resetPredefinedType();
        pSDEFormDetailBase.resetPredefinedTypeText();
        pSDEFormDetailBase.resetPreventXSS();
        pSDEFormDetailBase.resetPreviewHtml();
        pSDEFormDetailBase.resetPSCodeListId();
        pSDEFormDetailBase.resetPSCodeListName();
        pSDEFormDetailBase.resetPSDEDRId();
        pSDEFormDetailBase.resetPSDEDRItemId();
        pSDEFormDetailBase.resetPSDEDRItemName();
        pSDEFormDetailBase.resetPSDEDRName();
        pSDEFormDetailBase.resetPSDEFUIModeId();
        pSDEFormDetailBase.resetPSDEFUIModeName();
        pSDEFormDetailBase.resetPSDEFId();
        pSDEFormDetailBase.resetPSDEFIUpdateId();
        pSDEFormDetailBase.resetPSDEFIUpdateName();
        pSDEFormDetailBase.resetPSDEFName();
        pSDEFormDetailBase.resetPSDEFormDetailId();
        pSDEFormDetailBase.resetPSDEFormDetailName();
        pSDEFormDetailBase.resetPSDEFormId();
        pSDEFormDetailBase.resetPSDEFormName();
        pSDEFormDetailBase.resetPSDEFormRFId();
        pSDEFormDetailBase.resetPSDEFormRFName();
        pSDEFormDetailBase.resetPSDEFSFItemId();
        pSDEFormDetailBase.resetPSDEFSFItemName();
        pSDEFormDetailBase.resetPSDEId();
        pSDEFormDetailBase.resetPSDELogicId();
        pSDEFormDetailBase.resetPSDELogicName();
        pSDEFormDetailBase.resetPSDEUAGroupId();
        pSDEFormDetailBase.resetPSDEUAGroupName();
        pSDEFormDetailBase.resetPSDEUIActionId();
        pSDEFormDetailBase.resetPSDEUIActionName();
        pSDEFormDetailBase.resetPSDynaInstId();
        pSDEFormDetailBase.resetPSSysCounterId();
        pSDEFormDetailBase.resetPSSysCounterName();
        pSDEFormDetailBase.resetPSSysCssId();
        pSDEFormDetailBase.resetPSSysCssName();
        pSDEFormDetailBase.resetPSSysDictCatId();
        pSDEFormDetailBase.resetPSSysDictCatName();
        pSDEFormDetailBase.resetPSSysDynaModelId();
        pSDEFormDetailBase.resetPSSysDynaModelName();
        pSDEFormDetailBase.resetPSSysEditorStyleId();
        pSDEFormDetailBase.resetPSSysEditorStyleName();
        pSDEFormDetailBase.resetPSSysImageId();
        pSDEFormDetailBase.resetPSSysImageName();
        pSDEFormDetailBase.resetPSSysResourceId();
        pSDEFormDetailBase.resetPSSysResourceName();
        pSDEFormDetailBase.resetRawContent();
        pSDEFormDetailBase.resetRawCssStyle();
        pSDEFormDetailBase.resetRawServiceMethod();
        pSDEFormDetailBase.resetRawServiceUrl();
        pSDEFormDetailBase.resetRefPSDEACModeId();
        pSDEFormDetailBase.resetRefPSDEACModeName();
        pSDEFormDetailBase.resetRefPSDEDataSetId();
        pSDEFormDetailBase.resetRefPSDEDataSetName();
        pSDEFormDetailBase.resetRefPSDEFormDetailId();
        pSDEFormDetailBase.resetRefPSDEFormDetailName();
        pSDEFormDetailBase.resetRefPSDEFormId();
        pSDEFormDetailBase.resetRefPSDEId();
        pSDEFormDetailBase.resetRefPSDEName();
        pSDEFormDetailBase.resetRefPSDERId();
        pSDEFormDetailBase.resetRefPSDERName();
        pSDEFormDetailBase.resetRenderMode();
        pSDEFormDetailBase.resetRenderModeText();
        pSDEFormDetailBase.resetResetItemName();
        pSDEFormDetailBase.resetRowSpan();
        pSDEFormDetailBase.resetShowCaption();
        pSDEFormDetailBase.resetShowMoreMode();
        pSDEFormDetailBase.resetSpacingBottom();
        pSDEFormDetailBase.resetSpacingLeft();
        pSDEFormDetailBase.resetSpacingRight();
        pSDEFormDetailBase.resetSpacingTop();
        pSDEFormDetailBase.resetSwapMode();
        pSDEFormDetailBase.resetTemplateMode();
        pSDEFormDetailBase.resetTipPSLanResId();
        pSDEFormDetailBase.resetTipPSLanResName();
        pSDEFormDetailBase.resetTitleBarCloseMode();
        pSDEFormDetailBase.resetToggleMode();
        pSDEFormDetailBase.resetTooltipInfo();
        pSDEFormDetailBase.resetUCPSSysPFPluginId();
        pSDEFormDetailBase.resetUCPSSysPFPluginName();
        pSDEFormDetailBase.resetUpdateDate();
        pSDEFormDetailBase.resetUpdateDV();
        pSDEFormDetailBase.resetUpdateDVT();
        pSDEFormDetailBase.resetUpdateMan();
        pSDEFormDetailBase.resetUserTag();
        pSDEFormDetailBase.resetUserTag2();
        pSDEFormDetailBase.resetVAlign();
        pSDEFormDetailBase.resetVAlignSelf();
        pSDEFormDetailBase.resetValueFormat();
        pSDEFormDetailBase.resetValueItemName();
        pSDEFormDetailBase.resetVisibleLogic();
        pSDEFormDetailBase.resetWBDEFMode();
        pSDEFormDetailBase.resetWidth();
        pSDEFormDetailBase.resetWidthMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
        }
        if (!bl || this.isBlankLogicDirty()) {
            hashMap.put(FIELD_BLANKLOGIC, this.getBlankLogic());
        }
        if (!bl || this.isBL_PosDirty()) {
            hashMap.put(FIELD_BL_POS, this.getBL_Pos());
        }
        if (!bl || this.isBorderStyleDirty()) {
            hashMap.put(FIELD_BORDERSTYLE, this.getBorderStyle());
        }
        if (!bl || this.isBtnActionTypeDirty()) {
            hashMap.put(FIELD_BTNACTIONTYPE, this.getBtnActionType());
        }
        if (!bl || this.isBuildInActionDirty()) {
            hashMap.put(FIELD_BUILDINACTION, this.getBuildInAction());
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
        if (!bl || this.isChild_Col_LGDirty()) {
            hashMap.put(FIELD_CHILD_COL_LG, this.getChild_Col_LG());
        }
        if (!bl || this.isChild_Col_MDDirty()) {
            hashMap.put(FIELD_CHILD_COL_MD, this.getChild_Col_MD());
        }
        if (!bl || this.isChild_Col_SMDirty()) {
            hashMap.put(FIELD_CHILD_COL_SM, this.getChild_Col_SM());
        }
        if (!bl || this.isChild_Col_XSDirty()) {
            hashMap.put(FIELD_CHILD_COL_XS, this.getChild_Col_XS());
        }
        if (!bl || this.isCodeListConfigModeDirty()) {
            hashMap.put(FIELD_CODELISTCONFIGMODE, this.getCodeListConfigMode());
        }
        if (!bl || this.isColAlignDirty()) {
            hashMap.put(FIELD_COLALIGN, this.getColAlign());
        }
        if (!bl || this.isColIdDirty()) {
            hashMap.put(FIELD_COLID, this.getColId());
        }
        if (!bl || this.isColModelDirty()) {
            hashMap.put(FIELD_COLMODEL, this.getColModel());
        }
        if (!bl || this.isColSpanDirty()) {
            hashMap.put(FIELD_COLSPAN, this.getColSpan());
        }
        if (!bl || this.isCol_LGDirty()) {
            hashMap.put(FIELD_COL_LG, this.getCol_LG());
        }
        if (!bl || this.isCol_LG_OSDirty()) {
            hashMap.put(FIELD_COL_LG_OS, this.getCol_LG_OS());
        }
        if (!bl || this.isCol_MDDirty()) {
            hashMap.put(FIELD_COL_MD, this.getCol_MD());
        }
        if (!bl || this.isCol_MD_OSDirty()) {
            hashMap.put(FIELD_COL_MD_OS, this.getCol_MD_OS());
        }
        if (!bl || this.isCol_SMDirty()) {
            hashMap.put(FIELD_COL_SM, this.getCol_SM());
        }
        if (!bl || this.isCol_SM_OSDirty()) {
            hashMap.put(FIELD_COL_SM_OS, this.getCol_SM_OS());
        }
        if (!bl || this.isCol_WidthDirty()) {
            hashMap.put(FIELD_COL_WIDTH, this.getCol_Width());
        }
        if (!bl || this.isCol_XSDirty()) {
            hashMap.put(FIELD_COL_XS, this.getCol_XS());
        }
        if (!bl || this.isCol_XS_OSDirty()) {
            hashMap.put(FIELD_COL_XS_OS, this.getCol_XS_OS());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bl || this.isConvertCITextDirty()) {
            hashMap.put(FIELD_CONVERTCITEXT, this.getConvertCIText());
        }
        if (!bl || this.isCounterIdDirty()) {
            hashMap.put(FIELD_COUNTERID, this.getCounterId());
        }
        if (!bl || this.isCounterModeDirty()) {
            hashMap.put(FIELD_COUNTERMODE, this.getCounterMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateDVDirty()) {
            hashMap.put(FIELD_CREATEDV, this.getCreateDV());
        }
        if (!bl || this.isCreateDVTDirty()) {
            hashMap.put(FIELD_CREATEDVT, this.getCreateDVT());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCssIdDirty()) {
            hashMap.put(FIELD_CSSID, this.getCssId());
        }
        if (!bl || this.isCtrlColSpanDirty()) {
            hashMap.put(FIELD_CTRLCOLSPAN, this.getCtrlColSpan());
        }
        if (!bl || this.isCtrlDynaClassDirty()) {
            hashMap.put(FIELD_CTRLDYNACLASS, this.getCtrlDynaClass());
        }
        if (!bl || this.isCtrlHeightDirty()) {
            hashMap.put(FIELD_CTRLHEIGHT, this.getCtrlHeight());
        }
        if (!bl || this.isCtrlPSSysCssIdDirty()) {
            hashMap.put(FIELD_CTRLPSSYSCSSID, this.getCtrlPSSysCssId());
        }
        if (!bl || this.isCtrlPSSysCssNameDirty()) {
            hashMap.put(FIELD_CTRLPSSYSCSSNAME, this.getCtrlPSSysCssName());
        }
        if (!bl || this.isCtrlRawCssStyleDirty()) {
            hashMap.put(FIELD_CTRLRAWCSSSTYLE, this.getCtrlRawCssStyle());
        }
        if (!bl || this.isCtrlWidthDirty()) {
            hashMap.put(FIELD_CTRLWIDTH, this.getCtrlWidth());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDetailStyleDirty()) {
            hashMap.put(FIELD_DETAILSTYLE, this.getDetailStyle());
        }
        if (!bl || this.isDetailStyleTextDirty()) {
            hashMap.put(FIELD_DETAILSTYLETEXT, this.getDetailStyleText());
        }
        if (!bl || this.isDetailTagDirty()) {
            hashMap.put(FIELD_DETAILTAG, this.getDetailTag());
        }
        if (!bl || this.isDetailTag2Dirty()) {
            hashMap.put(FIELD_DETAILTAG2, this.getDetailTag2());
        }
        if (!bl || this.isDetailTypeDirty()) {
            hashMap.put(FIELD_DETAILTYPE, this.getDetailType());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEditorParamsDirty()) {
            hashMap.put(FIELD_EDITORPARAMS, this.getEditorParams());
        }
        if (!bl || this.isEditorTypeDirty()) {
            hashMap.put(FIELD_EDITORTYPE, this.getEditorType());
        }
        if (!bl || this.isEditorTypeNameDirty()) {
            hashMap.put(FIELD_EDITORTYPENAME, this.getEditorTypeName());
        }
        if (!bl || this.isEmptyCaptionDirty()) {
            hashMap.put(FIELD_EMPTYCAPTION, this.getEmptyCaption());
        }
        if (!bl || this.isEnableAnchorDirty()) {
            hashMap.put(FIELD_ENABLEANCHOR, this.getEnableAnchor());
        }
        if (!bl || this.isEnableCondDirty()) {
            hashMap.put(FIELD_ENABLECOND, this.getEnableCond());
        }
        if (!bl || this.isEnableInputTipDirty()) {
            hashMap.put(FIELD_ENABLEINPUTTIP, this.getEnableInputTip());
        }
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isEnableLogicDirty()) {
            hashMap.put(FIELD_ENABLELOGIC, this.getEnableLogic());
        }
        if (!bl || this.isFieldNameDirty()) {
            hashMap.put(FIELD_FIELDNAME, this.getFieldName());
        }
        if (!bl || this.isFlexAlignDirty()) {
            hashMap.put(FIELD_FLEXALIGN, this.getFlexAlign());
        }
        if (!bl || this.isFlexBasisDirty()) {
            hashMap.put(FIELD_FLEXBASIS, this.getFlexBasis());
        }
        if (!bl || this.isFlexDirDirty()) {
            hashMap.put(FIELD_FLEXDIR, this.getFlexDir());
        }
        if (!bl || this.isFlexGrowDirty()) {
            hashMap.put(FIELD_FLEXGROW, this.getFlexGrow());
        }
        if (!bl || this.isFlexShrinkDirty()) {
            hashMap.put(FIELD_FLEXSHRINK, this.getFlexShrink());
        }
        if (!bl || this.isFlexVAlignDirty()) {
            hashMap.put(FIELD_FLEXVALIGN, this.getFlexVAlign());
        }
        if (!bl || this.isFormTypeDirty()) {
            hashMap.put(FIELD_FORMTYPE, this.getFormType());
        }
        if (!bl || this.isGridRowIdDirty()) {
            hashMap.put(FIELD_GRIDROWID, this.getGridRowId());
        }
        if (!bl || this.isHAlignDirty()) {
            hashMap.put(FIELD_HALIGN, this.getHAlign());
        }
        if (!bl || this.isHAlignSelfDirty()) {
            hashMap.put(FIELD_HALIGNSELF, this.getHAlignSelf());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isHeightModeDirty()) {
            hashMap.put(FIELD_HEIGHTMODE, this.getHeightMode());
        }
        if (!bl || this.isHtmlContentDirty()) {
            hashMap.put(FIELD_HTMLCONTENT, this.getHtmlContent());
        }
        if (!bl || this.isHtmlPageUrlDirty()) {
            hashMap.put(FIELD_HTMLPAGEURL, this.getHtmlPageUrl());
        }
        if (!bl || this.isIconAlignDirty()) {
            hashMap.put(FIELD_ICONALIGN, this.getIconAlign());
        }
        if (!bl || this.isIgnoreInputDirty()) {
            hashMap.put(FIELD_IGNOREINPUT, this.getIgnoreInput());
        }
        if (!bl || this.isInsertPosDirty()) {
            hashMap.put(FIELD_INSERTPOS, this.getInsertPos());
        }
        if (!bl || this.isItemPSACHandlerIdDirty()) {
            hashMap.put(FIELD_ITEMPSACHANDLERID, this.getItemPSACHandlerId());
        }
        if (!bl || this.isItemPSACHandlerNameDirty()) {
            hashMap.put(FIELD_ITEMPSACHANDLERNAME, this.getItemPSACHandlerName());
        }
        if (!bl || this.isItemStatesDirty()) {
            hashMap.put(FIELD_ITEMSTATES, this.getItemStates());
        }
        if (!bl || this.isLabelColSpanDirty()) {
            hashMap.put(FIELD_LABELCOLSPAN, this.getLabelColSpan());
        }
        if (!bl || this.isLabelColSpan2Dirty()) {
            hashMap.put(FIELD_LABELCOLSPAN2, this.getLabelColSpan2());
        }
        if (!bl || this.isLabelCssIdDirty()) {
            hashMap.put(FIELD_LABELCSSID, this.getLabelCssId());
        }
        if (!bl || this.isLabelDynaClassDirty()) {
            hashMap.put(FIELD_LABELDYNACLASS, this.getLabelDynaClass());
        }
        if (!bl || this.isLabelPosDirty()) {
            hashMap.put(FIELD_LABELPOS, this.getLabelPos());
        }
        if (!bl || this.isLabelPSSysCssIdDirty()) {
            hashMap.put(FIELD_LABELPSSYSCSSID, this.getLabelPSSysCssId());
        }
        if (!bl || this.isLabelPSSysCssNameDirty()) {
            hashMap.put(FIELD_LABELPSSYSCSSNAME, this.getLabelPSSysCssName());
        }
        if (!bl || this.isLabelRawCssStyleDirty()) {
            hashMap.put(FIELD_LABELRAWCSSSTYLE, this.getLabelRawCssStyle());
        }
        if (!bl || this.isLabelWidthDirty()) {
            hashMap.put(FIELD_LABELWIDTH, this.getLabelWidth());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isLevelTagDirty()) {
            hashMap.put(FIELD_LEVELTAG, this.getLevelTag());
        }
        if (!bl || this.isLevelValueDirty()) {
            hashMap.put(FIELD_LEVELVALUE, this.getLevelValue());
        }
        if (!bl || this.isLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWID, this.getLinkPSDEViewId());
        }
        if (!bl || this.isLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_LINKPSDEVIEWNAME, this.getLinkPSDEViewName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMarginDirty()) {
            hashMap.put(FIELD_MARGIN, this.getMargin());
        }
        if (!bl || this.isMaskInfoDirty()) {
            hashMap.put(FIELD_MASKINFO, this.getMaskInfo());
        }
        if (!bl || this.isMaskModeDirty()) {
            hashMap.put(FIELD_MASKMODE, this.getMaskMode());
        }
        if (!bl || this.isMaskPSLanResIdDirty()) {
            hashMap.put(FIELD_MASKPSLANRESID, this.getMaskPSLanResId());
        }
        if (!bl || this.isMaskPSLanResNameDirty()) {
            hashMap.put(FIELD_MASKPSLANRESNAME, this.getMaskPSLanResName());
        }
        if (!bl || this.isMDCtrlTypeDirty()) {
            hashMap.put(FIELD_MDCTRLTYPE, this.getMDCtrlType());
        }
        if (!bl || this.isMDPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_MDPSDEDATAVIEWID, this.getMDPSDEDataViewId());
        }
        if (!bl || this.isMDPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_MDPSDEDATAVIEWNAME, this.getMDPSDEDataViewName());
        }
        if (!bl || this.isMDPSDEFormIdDirty()) {
            hashMap.put(FIELD_MDPSDEFORMID, this.getMDPSDEFormId());
        }
        if (!bl || this.isMDPSDEFormNameDirty()) {
            hashMap.put(FIELD_MDPSDEFORMNAME, this.getMDPSDEFormName());
        }
        if (!bl || this.isMDPSDEGridIdDirty()) {
            hashMap.put(FIELD_MDPSDEGRIDID, this.getMDPSDEGridId());
        }
        if (!bl || this.isMDPSDEGridNameDirty()) {
            hashMap.put(FIELD_MDPSDEGRIDNAME, this.getMDPSDEGridName());
        }
        if (!bl || this.isMDPSDEListIdDirty()) {
            hashMap.put(FIELD_MDPSDELISTID, this.getMDPSDEListId());
        }
        if (!bl || this.isMDPSDEListNameDirty()) {
            hashMap.put(FIELD_MDPSDELISTNAME, this.getMDPSDEListName());
        }
        if (!bl || this.isMDPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_MDPSSYSVIEWPANELID, this.getMDPSSysViewPanelId());
        }
        if (!bl || this.isMDPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_MDPSSYSVIEWPANELNAME, this.getMDPSSysViewPanelName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobFlagDirty()) {
            hashMap.put(FIELD_MOBFLAG, this.getMobFlag());
        }
        if (!bl || this.isModelStateDirty()) {
            hashMap.put(FIELD_MODELSTATE, this.getModelState());
        }
        if (!bl || this.isNeedCodeListConfigDirty()) {
            hashMap.put(FIELD_NEEDCODELISTCONFIG, this.getNeedCodeListConfig());
        }
        if (!bl || this.isNoPrivDMDirty()) {
            hashMap.put(FIELD_NOPRIVDM, this.getNoPrivDM());
        }
        if (!bl || this.isOpenPSDEViewIdDirty()) {
            hashMap.put(FIELD_OPENPSDEVIEWID, this.getOpenPSDEViewId());
        }
        if (!bl || this.isOpenPSDEViewNameDirty()) {
            hashMap.put(FIELD_OPENPSDEVIEWNAME, this.getOpenPSDEViewName());
        }
        if (!bl || this.isOpenPSSysPDTViewIdDirty()) {
            hashMap.put(FIELD_OPENPSSYSPDTVIEWID, this.getOpenPSSysPDTViewId());
        }
        if (!bl || this.isOpenPSSysPDTViewNameDirty()) {
            hashMap.put(FIELD_OPENPSSYSPDTVIEWNAME, this.getOpenPSSysPDTViewName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPaddingDirty()) {
            hashMap.put(FIELD_PADDING, this.getPadding());
        }
        if (!bl || this.isPHPSLanResIdDirty()) {
            hashMap.put(FIELD_PHPSLANRESID, this.getPHPSLanResId());
        }
        if (!bl || this.isPHPSLanResNameDirty()) {
            hashMap.put(FIELD_PHPSLANRESNAME, this.getPHPSLanResName());
        }
        if (!bl || this.isPickupPSDEViewIdDirty()) {
            hashMap.put(FIELD_PICKUPPSDEVIEWID, this.getPickupPSDEViewId());
        }
        if (!bl || this.isPickupPSDEViewNameDirty()) {
            hashMap.put(FIELD_PICKUPPSDEVIEWNAME, this.getPickupPSDEViewName());
        }
        if (!bl || this.isPlaceHolderDirty()) {
            hashMap.put(FIELD_PLACEHOLDER, this.getPlaceHolder());
        }
        if (!bl || this.isPLayoutModeDirty()) {
            hashMap.put(FIELD_PLAYOUTMODE, this.getPLayoutMode());
        }
        if (!bl || this.isPPSDEFormDetailIdDirty()) {
            hashMap.put(FIELD_PPSDEFORMDETAILID, this.getPPSDEFormDetailId());
        }
        if (!bl || this.isPPSDEFormDetailNameDirty()) {
            hashMap.put(FIELD_PPSDEFORMDETAILNAME, this.getPPSDEFormDetailName());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPreventXSSDirty()) {
            hashMap.put(FIELD_PREVENTXSS, this.getPreventXSS());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEDRIdDirty()) {
            hashMap.put(FIELD_PSDEDRID, this.getPSDEDRId());
        }
        if (!bl || this.isPSDEDRItemIdDirty()) {
            hashMap.put(FIELD_PSDEDRITEMID, this.getPSDEDRItemId());
        }
        if (!bl || this.isPSDEDRItemNameDirty()) {
            hashMap.put(FIELD_PSDEDRITEMNAME, this.getPSDEDRItemName());
        }
        if (!bl || this.isPSDEDRNameDirty()) {
            hashMap.put(FIELD_PSDEDRNAME, this.getPSDEDRName());
        }
        if (!bl || this.isPSDEFUIModeIdDirty()) {
            hashMap.put(FIELD_PSDEFUIMODEID, this.getPSDEFUIModeId());
        }
        if (!bl || this.isPSDEFUIModeNameDirty()) {
            hashMap.put(FIELD_PSDEFUIMODENAME, this.getPSDEFUIModeName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDEFIUPDATEID, this.getPSDEFIUpdateId());
        }
        if (!bl || this.isPSDEFIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDEFIUPDATENAME, this.getPSDEFIUpdateName());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEFormDetailIdDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILID, this.getPSDEFormDetailId());
        }
        if (!bl || this.isPSDEFormDetailNameDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILNAME, this.getPSDEFormDetailName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEFormRFIdDirty()) {
            hashMap.put(FIELD_PSDEFORMRFID, this.getPSDEFormRFId());
        }
        if (!bl || this.isPSDEFormRFNameDirty()) {
            hashMap.put(FIELD_PSDEFORMRFNAME, this.getPSDEFormRFName());
        }
        if (!bl || this.isPSDEFSFItemIdDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMID, this.getPSDEFSFItemId());
        }
        if (!bl || this.isPSDEFSFItemNameDirty()) {
            hashMap.put(FIELD_PSDEFSFITEMNAME, this.getPSDEFSFItemName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysDictCatIdDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATID, this.getPSSysDictCatId());
        }
        if (!bl || this.isPSSysDictCatNameDirty()) {
            hashMap.put(FIELD_PSSYSDICTCATNAME, this.getPSSysDictCatName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isRawCssStyleDirty()) {
            hashMap.put(FIELD_RAWCSSSTYLE, this.getRawCssStyle());
        }
        if (!bl || this.isRawServiceMethodDirty()) {
            hashMap.put(FIELD_RAWSERVICEMETHOD, this.getRawServiceMethod());
        }
        if (!bl || this.isRawServiceUrlDirty()) {
            hashMap.put(FIELD_RAWSERVICEURL, this.getRawServiceUrl());
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
        if (!bl || this.isRefPSDEFormDetailIdDirty()) {
            hashMap.put(FIELD_REFPSDEFORMDETAILID, this.getRefPSDEFormDetailId());
        }
        if (!bl || this.isRefPSDEFormDetailNameDirty()) {
            hashMap.put(FIELD_REFPSDEFORMDETAILNAME, this.getRefPSDEFormDetailName());
        }
        if (!bl || this.isRefPSDEFormIdDirty()) {
            hashMap.put(FIELD_REFPSDEFORMID, this.getRefPSDEFormId());
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
        if (!bl || this.isRenderModeDirty()) {
            hashMap.put(FIELD_RENDERMODE, this.getRenderMode());
        }
        if (!bl || this.isRenderModeTextDirty()) {
            hashMap.put(FIELD_RENDERMODETEXT, this.getRenderModeText());
        }
        if (!bl || this.isResetItemNameDirty()) {
            hashMap.put(FIELD_RESETITEMNAME, this.getResetItemName());
        }
        if (!bl || this.isRowSpanDirty()) {
            hashMap.put(FIELD_ROWSPAN, this.getRowSpan());
        }
        if (!bl || this.isShowCaptionDirty()) {
            hashMap.put(FIELD_SHOWCAPTION, this.getShowCaption());
        }
        if (!bl || this.isShowMoreModeDirty()) {
            hashMap.put(FIELD_SHOWMOREMODE, this.getShowMoreMode());
        }
        if (!bl || this.isSpacingBottomDirty()) {
            hashMap.put(FIELD_SPACINGBOTTOM, this.getSpacingBottom());
        }
        if (!bl || this.isSpacingLeftDirty()) {
            hashMap.put(FIELD_SPACINGLEFT, this.getSpacingLeft());
        }
        if (!bl || this.isSpacingRightDirty()) {
            hashMap.put(FIELD_SPACINGRIGHT, this.getSpacingRight());
        }
        if (!bl || this.isSpacingTopDirty()) {
            hashMap.put(FIELD_SPACINGTOP, this.getSpacingTop());
        }
        if (!bl || this.isSwapModeDirty()) {
            hashMap.put(FIELD_SWAPMODE, this.getSwapMode());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isTitleBarCloseModeDirty()) {
            hashMap.put(FIELD_TITLEBARCLOSEMODE, this.getTitleBarCloseMode());
        }
        if (!bl || this.isToggleModeDirty()) {
            hashMap.put(FIELD_TOGGLEMODE, this.getToggleMode());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
        }
        if (!bl || this.isUCPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_UCPSSYSPFPLUGINID, this.getUCPSSysPFPluginId());
        }
        if (!bl || this.isUCPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_UCPSSYSPFPLUGINNAME, this.getUCPSSysPFPluginName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateDVDirty()) {
            hashMap.put(FIELD_UPDATEDV, this.getUpdateDV());
        }
        if (!bl || this.isUpdateDVTDirty()) {
            hashMap.put(FIELD_UPDATEDVT, this.getUpdateDVT());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isVAlignDirty()) {
            hashMap.put(FIELD_VALIGN, this.getVAlign());
        }
        if (!bl || this.isVAlignSelfDirty()) {
            hashMap.put(FIELD_VALIGNSELF, this.getVAlignSelf());
        }
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
        }
        if (!bl || this.isValueItemNameDirty()) {
            hashMap.put(FIELD_VALUEITEMNAME, this.getValueItemName());
        }
        if (!bl || this.isVisibleLogicDirty()) {
            hashMap.put(FIELD_VISIBLELOGIC, this.getVisibleLogic());
        }
        if (!bl || this.isWBDEFModeDirty()) {
            hashMap.put(FIELD_WBDEFMODE, this.getWBDEFMode());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
        }
        if (!bl || this.isWidthModeDirty()) {
            hashMap.put(FIELD_WIDTHMODE, this.getWidthMode());
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
        return PSDEFormDetailBase.get(this, n);
    }

    private static Object get(PSDEFormDetailBase pSDEFormDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormDetailBase.getAllowEmpty();
            }
            case 1: {
                return pSDEFormDetailBase.getBlankLogic();
            }
            case 2: {
                return pSDEFormDetailBase.getBL_Pos();
            }
            case 3: {
                return pSDEFormDetailBase.getBorderStyle();
            }
            case 4: {
                return pSDEFormDetailBase.getBtnActionType();
            }
            case 5: {
                return pSDEFormDetailBase.getBuildInAction();
            }
            case 6: {
                return pSDEFormDetailBase.getCapPSLanResId();
            }
            case 7: {
                return pSDEFormDetailBase.getCapPSLanResName();
            }
            case 8: {
                return pSDEFormDetailBase.getCaption();
            }
            case 9: {
                return pSDEFormDetailBase.getChild_Col_LG();
            }
            case 10: {
                return pSDEFormDetailBase.getChild_Col_MD();
            }
            case 11: {
                return pSDEFormDetailBase.getChild_Col_SM();
            }
            case 12: {
                return pSDEFormDetailBase.getChild_Col_XS();
            }
            case 13: {
                return pSDEFormDetailBase.getCodeListConfigMode();
            }
            case 14: {
                return pSDEFormDetailBase.getColAlign();
            }
            case 15: {
                return pSDEFormDetailBase.getColId();
            }
            case 16: {
                return pSDEFormDetailBase.getColModel();
            }
            case 17: {
                return pSDEFormDetailBase.getColSpan();
            }
            case 18: {
                return pSDEFormDetailBase.getCol_LG();
            }
            case 19: {
                return pSDEFormDetailBase.getCol_LG_OS();
            }
            case 20: {
                return pSDEFormDetailBase.getCol_MD();
            }
            case 21: {
                return pSDEFormDetailBase.getCol_MD_OS();
            }
            case 22: {
                return pSDEFormDetailBase.getCol_SM();
            }
            case 23: {
                return pSDEFormDetailBase.getCol_SM_OS();
            }
            case 24: {
                return pSDEFormDetailBase.getCol_Width();
            }
            case 25: {
                return pSDEFormDetailBase.getCol_XS();
            }
            case 26: {
                return pSDEFormDetailBase.getCol_XS_OS();
            }
            case 27: {
                return pSDEFormDetailBase.getContentType();
            }
            case 28: {
                return pSDEFormDetailBase.getConvertCIText();
            }
            case 29: {
                return pSDEFormDetailBase.getCounterId();
            }
            case 30: {
                return pSDEFormDetailBase.getCounterMode();
            }
            case 31: {
                return pSDEFormDetailBase.getCreateDate();
            }
            case 32: {
                return pSDEFormDetailBase.getCreateDV();
            }
            case 33: {
                return pSDEFormDetailBase.getCreateDVT();
            }
            case 34: {
                return pSDEFormDetailBase.getCreateMan();
            }
            case 35: {
                return pSDEFormDetailBase.getCssId();
            }
            case 36: {
                return pSDEFormDetailBase.getCtrlColSpan();
            }
            case 37: {
                return pSDEFormDetailBase.getCtrlDynaClass();
            }
            case 38: {
                return pSDEFormDetailBase.getCtrlHeight();
            }
            case 39: {
                return pSDEFormDetailBase.getCtrlPSSysCssId();
            }
            case 40: {
                return pSDEFormDetailBase.getCtrlPSSysCssName();
            }
            case 41: {
                return pSDEFormDetailBase.getCtrlRawCssStyle();
            }
            case 42: {
                return pSDEFormDetailBase.getCtrlWidth();
            }
            case 43: {
                return pSDEFormDetailBase.getCustomCode();
            }
            case 44: {
                return pSDEFormDetailBase.getData();
            }
            case 45: {
                return pSDEFormDetailBase.getDefaultFlag();
            }
            case 46: {
                return pSDEFormDetailBase.getDetailStyle();
            }
            case 47: {
                return pSDEFormDetailBase.getDetailStyleText();
            }
            case 48: {
                return pSDEFormDetailBase.getDetailTag();
            }
            case 49: {
                return pSDEFormDetailBase.getDetailTag2();
            }
            case 50: {
                return pSDEFormDetailBase.getDetailType();
            }
            case 51: {
                return pSDEFormDetailBase.getDynaClass();
            }
            case 52: {
                return pSDEFormDetailBase.getDynaModelFlag();
            }
            case 53: {
                return pSDEFormDetailBase.getEditorParams();
            }
            case 54: {
                return pSDEFormDetailBase.getEditorType();
            }
            case 55: {
                return pSDEFormDetailBase.getEditorTypeName();
            }
            case 56: {
                return pSDEFormDetailBase.getEmptyCaption();
            }
            case 57: {
                return pSDEFormDetailBase.getEnableAnchor();
            }
            case 58: {
                return pSDEFormDetailBase.getEnableCond();
            }
            case 59: {
                return pSDEFormDetailBase.getEnableInputTip();
            }
            case 60: {
                return pSDEFormDetailBase.getEnableItemPriv();
            }
            case 61: {
                return pSDEFormDetailBase.getEnableLogic();
            }
            case 62: {
                return pSDEFormDetailBase.getFieldName();
            }
            case 63: {
                return pSDEFormDetailBase.getFlexAlign();
            }
            case 64: {
                return pSDEFormDetailBase.getFlexBasis();
            }
            case 65: {
                return pSDEFormDetailBase.getFlexDir();
            }
            case 66: {
                return pSDEFormDetailBase.getFlexGrow();
            }
            case 67: {
                return pSDEFormDetailBase.getFlexShrink();
            }
            case 68: {
                return pSDEFormDetailBase.getFlexVAlign();
            }
            case 69: {
                return pSDEFormDetailBase.getFormType();
            }
            case 70: {
                return pSDEFormDetailBase.getGridRowId();
            }
            case 71: {
                return pSDEFormDetailBase.getHAlign();
            }
            case 72: {
                return pSDEFormDetailBase.getHAlignSelf();
            }
            case 73: {
                return pSDEFormDetailBase.getHeight();
            }
            case 74: {
                return pSDEFormDetailBase.getHeightMode();
            }
            case 75: {
                return pSDEFormDetailBase.getHtmlContent();
            }
            case 76: {
                return pSDEFormDetailBase.getHtmlPageUrl();
            }
            case 77: {
                return pSDEFormDetailBase.getIconAlign();
            }
            case 78: {
                return pSDEFormDetailBase.getIgnoreInput();
            }
            case 79: {
                return pSDEFormDetailBase.getInsertPos();
            }
            case 80: {
                return pSDEFormDetailBase.getItemPSACHandlerId();
            }
            case 81: {
                return pSDEFormDetailBase.getItemPSACHandlerName();
            }
            case 82: {
                return pSDEFormDetailBase.getItemStates();
            }
            case 83: {
                return pSDEFormDetailBase.getLabelColSpan();
            }
            case 84: {
                return pSDEFormDetailBase.getLabelColSpan2();
            }
            case 85: {
                return pSDEFormDetailBase.getLabelCssId();
            }
            case 86: {
                return pSDEFormDetailBase.getLabelDynaClass();
            }
            case 87: {
                return pSDEFormDetailBase.getLabelPos();
            }
            case 88: {
                return pSDEFormDetailBase.getLabelPSSysCssId();
            }
            case 89: {
                return pSDEFormDetailBase.getLabelPSSysCssName();
            }
            case 90: {
                return pSDEFormDetailBase.getLabelRawCssStyle();
            }
            case 91: {
                return pSDEFormDetailBase.getLabelWidth();
            }
            case 92: {
                return pSDEFormDetailBase.getLayoutMode();
            }
            case 93: {
                return pSDEFormDetailBase.getLevelTag();
            }
            case 94: {
                return pSDEFormDetailBase.getLevelValue();
            }
            case 95: {
                return pSDEFormDetailBase.getLinkPSDEViewId();
            }
            case 96: {
                return pSDEFormDetailBase.getLinkPSDEViewName();
            }
            case 97: {
                return pSDEFormDetailBase.getLogicName();
            }
            case 98: {
                return pSDEFormDetailBase.getMargin();
            }
            case 99: {
                return pSDEFormDetailBase.getMaskInfo();
            }
            case 100: {
                return pSDEFormDetailBase.getMaskMode();
            }
            case 101: {
                return pSDEFormDetailBase.getMaskPSLanResId();
            }
            case 102: {
                return pSDEFormDetailBase.getMaskPSLanResName();
            }
            case 103: {
                return pSDEFormDetailBase.getMDCtrlType();
            }
            case 104: {
                return pSDEFormDetailBase.getMDPSDEDataViewId();
            }
            case 105: {
                return pSDEFormDetailBase.getMDPSDEDataViewName();
            }
            case 106: {
                return pSDEFormDetailBase.getMDPSDEFormId();
            }
            case 107: {
                return pSDEFormDetailBase.getMDPSDEFormName();
            }
            case 108: {
                return pSDEFormDetailBase.getMDPSDEGridId();
            }
            case 109: {
                return pSDEFormDetailBase.getMDPSDEGridName();
            }
            case 110: {
                return pSDEFormDetailBase.getMDPSDEListId();
            }
            case 111: {
                return pSDEFormDetailBase.getMDPSDEListName();
            }
            case 112: {
                return pSDEFormDetailBase.getMDPSSysViewPanelId();
            }
            case 113: {
                return pSDEFormDetailBase.getMDPSSysViewPanelName();
            }
            case 114: {
                return pSDEFormDetailBase.getMemo();
            }
            case 115: {
                return pSDEFormDetailBase.getMobFlag();
            }
            case 116: {
                return pSDEFormDetailBase.getModelState();
            }
            case 117: {
                return pSDEFormDetailBase.getNeedCodeListConfig();
            }
            case 118: {
                return pSDEFormDetailBase.getNoPrivDM();
            }
            case 119: {
                return pSDEFormDetailBase.getOpenPSDEViewId();
            }
            case 120: {
                return pSDEFormDetailBase.getOpenPSDEViewName();
            }
            case 121: {
                return pSDEFormDetailBase.getOpenPSSysPDTViewId();
            }
            case 122: {
                return pSDEFormDetailBase.getOpenPSSysPDTViewName();
            }
            case 123: {
                return pSDEFormDetailBase.getOrderValue();
            }
            case 124: {
                return pSDEFormDetailBase.getPadding();
            }
            case 125: {
                return pSDEFormDetailBase.getPHPSLanResId();
            }
            case 126: {
                return pSDEFormDetailBase.getPHPSLanResName();
            }
            case 127: {
                return pSDEFormDetailBase.getPickupPSDEViewId();
            }
            case 128: {
                return pSDEFormDetailBase.getPickupPSDEViewName();
            }
            case 129: {
                return pSDEFormDetailBase.getPlaceHolder();
            }
            case 130: {
                return pSDEFormDetailBase.getPLayoutMode();
            }
            case 131: {
                return pSDEFormDetailBase.getPPSDEFormDetailId();
            }
            case 132: {
                return pSDEFormDetailBase.getPPSDEFormDetailName();
            }
            case 133: {
                return pSDEFormDetailBase.getPredefinedType();
            }
            case 134: {
                return pSDEFormDetailBase.getPredefinedTypeText();
            }
            case 135: {
                return pSDEFormDetailBase.getPreventXSS();
            }
            case 136: {
                return pSDEFormDetailBase.getPreviewHtml();
            }
            case 137: {
                return pSDEFormDetailBase.getPSCodeListId();
            }
            case 138: {
                return pSDEFormDetailBase.getPSCodeListName();
            }
            case 139: {
                return pSDEFormDetailBase.getPSDEDRId();
            }
            case 140: {
                return pSDEFormDetailBase.getPSDEDRItemId();
            }
            case 141: {
                return pSDEFormDetailBase.getPSDEDRItemName();
            }
            case 142: {
                return pSDEFormDetailBase.getPSDEDRName();
            }
            case 143: {
                return pSDEFormDetailBase.getPSDEFUIModeId();
            }
            case 144: {
                return pSDEFormDetailBase.getPSDEFUIModeName();
            }
            case 145: {
                return pSDEFormDetailBase.getPSDEFId();
            }
            case 146: {
                return pSDEFormDetailBase.getPSDEFIUpdateId();
            }
            case 147: {
                return pSDEFormDetailBase.getPSDEFIUpdateName();
            }
            case 148: {
                return pSDEFormDetailBase.getPSDEFName();
            }
            case 149: {
                return pSDEFormDetailBase.getPSDEFormDetailId();
            }
            case 150: {
                return pSDEFormDetailBase.getPSDEFormDetailName();
            }
            case 151: {
                return pSDEFormDetailBase.getPSDEFormId();
            }
            case 152: {
                return pSDEFormDetailBase.getPSDEFormName();
            }
            case 153: {
                return pSDEFormDetailBase.getPSDEFormRFId();
            }
            case 154: {
                return pSDEFormDetailBase.getPSDEFormRFName();
            }
            case 155: {
                return pSDEFormDetailBase.getPSDEFSFItemId();
            }
            case 156: {
                return pSDEFormDetailBase.getPSDEFSFItemName();
            }
            case 157: {
                return pSDEFormDetailBase.getPSDEId();
            }
            case 158: {
                return pSDEFormDetailBase.getPSDELogicId();
            }
            case 159: {
                return pSDEFormDetailBase.getPSDELogicName();
            }
            case 160: {
                return pSDEFormDetailBase.getPSDEUAGroupId();
            }
            case 161: {
                return pSDEFormDetailBase.getPSDEUAGroupName();
            }
            case 162: {
                return pSDEFormDetailBase.getPSDEUIActionId();
            }
            case 163: {
                return pSDEFormDetailBase.getPSDEUIActionName();
            }
            case 164: {
                return pSDEFormDetailBase.getPSDynaInstId();
            }
            case 165: {
                return pSDEFormDetailBase.getPSSysCounterId();
            }
            case 166: {
                return pSDEFormDetailBase.getPSSysCounterName();
            }
            case 167: {
                return pSDEFormDetailBase.getPSSysCssId();
            }
            case 168: {
                return pSDEFormDetailBase.getPSSysCssName();
            }
            case 169: {
                return pSDEFormDetailBase.getPSSysDictCatId();
            }
            case 170: {
                return pSDEFormDetailBase.getPSSysDictCatName();
            }
            case 171: {
                return pSDEFormDetailBase.getPSSysDynaModelId();
            }
            case 172: {
                return pSDEFormDetailBase.getPSSysDynaModelName();
            }
            case 173: {
                return pSDEFormDetailBase.getPSSysEditorStyleId();
            }
            case 174: {
                return pSDEFormDetailBase.getPSSysEditorStyleName();
            }
            case 175: {
                return pSDEFormDetailBase.getPSSysImageId();
            }
            case 176: {
                return pSDEFormDetailBase.getPSSysImageName();
            }
            case 177: {
                return pSDEFormDetailBase.getPSSysResourceId();
            }
            case 178: {
                return pSDEFormDetailBase.getPSSysResourceName();
            }
            case 179: {
                return pSDEFormDetailBase.getRawContent();
            }
            case 180: {
                return pSDEFormDetailBase.getRawCssStyle();
            }
            case 181: {
                return pSDEFormDetailBase.getRawServiceMethod();
            }
            case 182: {
                return pSDEFormDetailBase.getRawServiceUrl();
            }
            case 183: {
                return pSDEFormDetailBase.getRefPSDEACModeId();
            }
            case 184: {
                return pSDEFormDetailBase.getRefPSDEACModeName();
            }
            case 185: {
                return pSDEFormDetailBase.getRefPSDEDataSetId();
            }
            case 186: {
                return pSDEFormDetailBase.getRefPSDEDataSetName();
            }
            case 187: {
                return pSDEFormDetailBase.getRefPSDEFormDetailId();
            }
            case 188: {
                return pSDEFormDetailBase.getRefPSDEFormDetailName();
            }
            case 189: {
                return pSDEFormDetailBase.getRefPSDEFormId();
            }
            case 190: {
                return pSDEFormDetailBase.getRefPSDEId();
            }
            case 191: {
                return pSDEFormDetailBase.getRefPSDEName();
            }
            case 192: {
                return pSDEFormDetailBase.getRefPSDERId();
            }
            case 193: {
                return pSDEFormDetailBase.getRefPSDERName();
            }
            case 194: {
                return pSDEFormDetailBase.getRenderMode();
            }
            case 195: {
                return pSDEFormDetailBase.getRenderModeText();
            }
            case 196: {
                return pSDEFormDetailBase.getResetItemName();
            }
            case 197: {
                return pSDEFormDetailBase.getRowSpan();
            }
            case 198: {
                return pSDEFormDetailBase.getShowCaption();
            }
            case 199: {
                return pSDEFormDetailBase.getShowMoreMode();
            }
            case 200: {
                return pSDEFormDetailBase.getSpacingBottom();
            }
            case 201: {
                return pSDEFormDetailBase.getSpacingLeft();
            }
            case 202: {
                return pSDEFormDetailBase.getSpacingRight();
            }
            case 203: {
                return pSDEFormDetailBase.getSpacingTop();
            }
            case 204: {
                return pSDEFormDetailBase.getSwapMode();
            }
            case 205: {
                return pSDEFormDetailBase.getTemplateMode();
            }
            case 206: {
                return pSDEFormDetailBase.getTipPSLanResId();
            }
            case 207: {
                return pSDEFormDetailBase.getTipPSLanResName();
            }
            case 208: {
                return pSDEFormDetailBase.getTitleBarCloseMode();
            }
            case 209: {
                return pSDEFormDetailBase.getToggleMode();
            }
            case 210: {
                return pSDEFormDetailBase.getTooltipInfo();
            }
            case 211: {
                return pSDEFormDetailBase.getUCPSSysPFPluginId();
            }
            case 212: {
                return pSDEFormDetailBase.getUCPSSysPFPluginName();
            }
            case 213: {
                return pSDEFormDetailBase.getUpdateDate();
            }
            case 214: {
                return pSDEFormDetailBase.getUpdateDV();
            }
            case 215: {
                return pSDEFormDetailBase.getUpdateDVT();
            }
            case 216: {
                return pSDEFormDetailBase.getUpdateMan();
            }
            case 217: {
                return pSDEFormDetailBase.getUserTag();
            }
            case 218: {
                return pSDEFormDetailBase.getUserTag2();
            }
            case 219: {
                return pSDEFormDetailBase.getVAlign();
            }
            case 220: {
                return pSDEFormDetailBase.getVAlignSelf();
            }
            case 221: {
                return pSDEFormDetailBase.getValueFormat();
            }
            case 222: {
                return pSDEFormDetailBase.getValueItemName();
            }
            case 223: {
                return pSDEFormDetailBase.getVisibleLogic();
            }
            case 224: {
                return pSDEFormDetailBase.getWBDEFMode();
            }
            case 225: {
                return pSDEFormDetailBase.getWidth();
            }
            case 226: {
                return pSDEFormDetailBase.getWidthMode();
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
        PSDEFormDetailBase.set(this, n, object);
    }

    private static void set(PSDEFormDetailBase pSDEFormDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormDetailBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFormDetailBase.setBlankLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFormDetailBase.setBL_Pos(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFormDetailBase.setBorderStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFormDetailBase.setBtnActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFormDetailBase.setBuildInAction(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEFormDetailBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFormDetailBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFormDetailBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFormDetailBase.setChild_Col_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEFormDetailBase.setChild_Col_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEFormDetailBase.setChild_Col_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEFormDetailBase.setChild_Col_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEFormDetailBase.setCodeListConfigMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEFormDetailBase.setColAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFormDetailBase.setColId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEFormDetailBase.setColModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFormDetailBase.setColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEFormDetailBase.setCol_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEFormDetailBase.setCol_LG_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEFormDetailBase.setCol_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEFormDetailBase.setCol_MD_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEFormDetailBase.setCol_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEFormDetailBase.setCol_SM_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEFormDetailBase.setCol_Width(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEFormDetailBase.setCol_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEFormDetailBase.setCol_XS_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEFormDetailBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFormDetailBase.setConvertCIText(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEFormDetailBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFormDetailBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEFormDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSDEFormDetailBase.setCreateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFormDetailBase.setCreateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFormDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFormDetailBase.setCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFormDetailBase.setCtrlColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDEFormDetailBase.setCtrlDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFormDetailBase.setCtrlHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEFormDetailBase.setCtrlPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEFormDetailBase.setCtrlPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEFormDetailBase.setCtrlRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFormDetailBase.setCtrlWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEFormDetailBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEFormDetailBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEFormDetailBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDEFormDetailBase.setDetailStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEFormDetailBase.setDetailStyleText(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEFormDetailBase.setDetailTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEFormDetailBase.setDetailTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEFormDetailBase.setDetailType(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEFormDetailBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDEFormDetailBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 53: {
                pSDEFormDetailBase.setEditorParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDEFormDetailBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDEFormDetailBase.setEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDEFormDetailBase.setEmptyCaption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSDEFormDetailBase.setEnableAnchor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 58: {
                pSDEFormDetailBase.setEnableCond(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSDEFormDetailBase.setEnableInputTip(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSDEFormDetailBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSDEFormDetailBase.setEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDEFormDetailBase.setFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 63: {
                pSDEFormDetailBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDEFormDetailBase.setFlexBasis(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 65: {
                pSDEFormDetailBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDEFormDetailBase.setFlexGrow(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 67: {
                pSDEFormDetailBase.setFlexShrink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 68: {
                pSDEFormDetailBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDEFormDetailBase.setFormType(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDEFormDetailBase.setGridRowId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 71: {
                pSDEFormDetailBase.setHAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSDEFormDetailBase.setHAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDEFormDetailBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 74: {
                pSDEFormDetailBase.setHeightMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 75: {
                pSDEFormDetailBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDEFormDetailBase.setHtmlPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 77: {
                pSDEFormDetailBase.setIconAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDEFormDetailBase.setIgnoreInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 79: {
                pSDEFormDetailBase.setInsertPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 80: {
                pSDEFormDetailBase.setItemPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDEFormDetailBase.setItemPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDEFormDetailBase.setItemStates(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSDEFormDetailBase.setLabelColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 84: {
                pSDEFormDetailBase.setLabelColSpan2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 85: {
                pSDEFormDetailBase.setLabelCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDEFormDetailBase.setLabelDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 87: {
                pSDEFormDetailBase.setLabelPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSDEFormDetailBase.setLabelPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSDEFormDetailBase.setLabelPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDEFormDetailBase.setLabelRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDEFormDetailBase.setLabelWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 92: {
                pSDEFormDetailBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDEFormDetailBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDEFormDetailBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 95: {
                pSDEFormDetailBase.setLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDEFormDetailBase.setLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDEFormDetailBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDEFormDetailBase.setMargin(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDEFormDetailBase.setMaskInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDEFormDetailBase.setMaskMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 101: {
                pSDEFormDetailBase.setMaskPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDEFormDetailBase.setMaskPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDEFormDetailBase.setMDCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDEFormDetailBase.setMDPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDEFormDetailBase.setMDPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDEFormDetailBase.setMDPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDEFormDetailBase.setMDPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDEFormDetailBase.setMDPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDEFormDetailBase.setMDPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDEFormDetailBase.setMDPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDEFormDetailBase.setMDPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDEFormDetailBase.setMDPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDEFormDetailBase.setMDPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDEFormDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDEFormDetailBase.setMobFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 116: {
                pSDEFormDetailBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 117: {
                pSDEFormDetailBase.setNeedCodeListConfig(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 118: {
                pSDEFormDetailBase.setNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 119: {
                pSDEFormDetailBase.setOpenPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDEFormDetailBase.setOpenPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDEFormDetailBase.setOpenPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDEFormDetailBase.setOpenPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDEFormDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 124: {
                pSDEFormDetailBase.setPadding(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDEFormDetailBase.setPHPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDEFormDetailBase.setPHPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDEFormDetailBase.setPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDEFormDetailBase.setPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDEFormDetailBase.setPlaceHolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDEFormDetailBase.setPLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDEFormDetailBase.setPPSDEFormDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSDEFormDetailBase.setPPSDEFormDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDEFormDetailBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDEFormDetailBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDEFormDetailBase.setPreventXSS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 136: {
                pSDEFormDetailBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 137: {
                pSDEFormDetailBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDEFormDetailBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSDEFormDetailBase.setPSDEDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 140: {
                pSDEFormDetailBase.setPSDEDRItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 141: {
                pSDEFormDetailBase.setPSDEDRItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSDEFormDetailBase.setPSDEDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSDEFormDetailBase.setPSDEFUIModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 144: {
                pSDEFormDetailBase.setPSDEFUIModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 145: {
                pSDEFormDetailBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 146: {
                pSDEFormDetailBase.setPSDEFIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 147: {
                pSDEFormDetailBase.setPSDEFIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 148: {
                pSDEFormDetailBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 149: {
                pSDEFormDetailBase.setPSDEFormDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 150: {
                pSDEFormDetailBase.setPSDEFormDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 151: {
                pSDEFormDetailBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 152: {
                pSDEFormDetailBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 153: {
                pSDEFormDetailBase.setPSDEFormRFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 154: {
                pSDEFormDetailBase.setPSDEFormRFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 155: {
                pSDEFormDetailBase.setPSDEFSFItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 156: {
                pSDEFormDetailBase.setPSDEFSFItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 157: {
                pSDEFormDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 158: {
                pSDEFormDetailBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 159: {
                pSDEFormDetailBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 160: {
                pSDEFormDetailBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 161: {
                pSDEFormDetailBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 162: {
                pSDEFormDetailBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 163: {
                pSDEFormDetailBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 164: {
                pSDEFormDetailBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 165: {
                pSDEFormDetailBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 166: {
                pSDEFormDetailBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 167: {
                pSDEFormDetailBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 168: {
                pSDEFormDetailBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 169: {
                pSDEFormDetailBase.setPSSysDictCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 170: {
                pSDEFormDetailBase.setPSSysDictCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 171: {
                pSDEFormDetailBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 172: {
                pSDEFormDetailBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 173: {
                pSDEFormDetailBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 174: {
                pSDEFormDetailBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 175: {
                pSDEFormDetailBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 176: {
                pSDEFormDetailBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 177: {
                pSDEFormDetailBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 178: {
                pSDEFormDetailBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 179: {
                pSDEFormDetailBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 180: {
                pSDEFormDetailBase.setRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 181: {
                pSDEFormDetailBase.setRawServiceMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 182: {
                pSDEFormDetailBase.setRawServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 183: {
                pSDEFormDetailBase.setRefPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 184: {
                pSDEFormDetailBase.setRefPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 185: {
                pSDEFormDetailBase.setRefPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 186: {
                pSDEFormDetailBase.setRefPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 187: {
                pSDEFormDetailBase.setRefPSDEFormDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 188: {
                pSDEFormDetailBase.setRefPSDEFormDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 189: {
                pSDEFormDetailBase.setRefPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 190: {
                pSDEFormDetailBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 191: {
                pSDEFormDetailBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 192: {
                pSDEFormDetailBase.setRefPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 193: {
                pSDEFormDetailBase.setRefPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 194: {
                pSDEFormDetailBase.setRenderMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 195: {
                pSDEFormDetailBase.setRenderModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 196: {
                pSDEFormDetailBase.setResetItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 197: {
                pSDEFormDetailBase.setRowSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 198: {
                pSDEFormDetailBase.setShowCaption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 199: {
                pSDEFormDetailBase.setShowMoreMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 200: {
                pSDEFormDetailBase.setSpacingBottom(DataObject.getStringValue((Object)object));
                return;
            }
            case 201: {
                pSDEFormDetailBase.setSpacingLeft(DataObject.getStringValue((Object)object));
                return;
            }
            case 202: {
                pSDEFormDetailBase.setSpacingRight(DataObject.getStringValue((Object)object));
                return;
            }
            case 203: {
                pSDEFormDetailBase.setSpacingTop(DataObject.getStringValue((Object)object));
                return;
            }
            case 204: {
                pSDEFormDetailBase.setSwapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 205: {
                pSDEFormDetailBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 206: {
                pSDEFormDetailBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 207: {
                pSDEFormDetailBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 208: {
                pSDEFormDetailBase.setTitleBarCloseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 209: {
                pSDEFormDetailBase.setToggleMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 210: {
                pSDEFormDetailBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 211: {
                pSDEFormDetailBase.setUCPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 212: {
                pSDEFormDetailBase.setUCPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 213: {
                pSDEFormDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 214: {
                pSDEFormDetailBase.setUpdateDV(DataObject.getStringValue((Object)object));
                return;
            }
            case 215: {
                pSDEFormDetailBase.setUpdateDVT(DataObject.getStringValue((Object)object));
                return;
            }
            case 216: {
                pSDEFormDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 217: {
                pSDEFormDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 218: {
                pSDEFormDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 219: {
                pSDEFormDetailBase.setVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 220: {
                pSDEFormDetailBase.setVAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 221: {
                pSDEFormDetailBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 222: {
                pSDEFormDetailBase.setValueItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 223: {
                pSDEFormDetailBase.setVisibleLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 224: {
                pSDEFormDetailBase.setWBDEFMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 225: {
                pSDEFormDetailBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 226: {
                pSDEFormDetailBase.setWidthMode(DataObject.getStringValue((Object)object));
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
        return PSDEFormDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFormDetailBase pSDEFormDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormDetailBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDEFormDetailBase.getBlankLogic() == null;
            }
            case 2: {
                return pSDEFormDetailBase.getBL_Pos() == null;
            }
            case 3: {
                return pSDEFormDetailBase.getBorderStyle() == null;
            }
            case 4: {
                return pSDEFormDetailBase.getBtnActionType() == null;
            }
            case 5: {
                return pSDEFormDetailBase.getBuildInAction() == null;
            }
            case 6: {
                return pSDEFormDetailBase.getCapPSLanResId() == null;
            }
            case 7: {
                return pSDEFormDetailBase.getCapPSLanResName() == null;
            }
            case 8: {
                return pSDEFormDetailBase.getCaption() == null;
            }
            case 9: {
                return pSDEFormDetailBase.getChild_Col_LG() == null;
            }
            case 10: {
                return pSDEFormDetailBase.getChild_Col_MD() == null;
            }
            case 11: {
                return pSDEFormDetailBase.getChild_Col_SM() == null;
            }
            case 12: {
                return pSDEFormDetailBase.getChild_Col_XS() == null;
            }
            case 13: {
                return pSDEFormDetailBase.getCodeListConfigMode() == null;
            }
            case 14: {
                return pSDEFormDetailBase.getColAlign() == null;
            }
            case 15: {
                return pSDEFormDetailBase.getColId() == null;
            }
            case 16: {
                return pSDEFormDetailBase.getColModel() == null;
            }
            case 17: {
                return pSDEFormDetailBase.getColSpan() == null;
            }
            case 18: {
                return pSDEFormDetailBase.getCol_LG() == null;
            }
            case 19: {
                return pSDEFormDetailBase.getCol_LG_OS() == null;
            }
            case 20: {
                return pSDEFormDetailBase.getCol_MD() == null;
            }
            case 21: {
                return pSDEFormDetailBase.getCol_MD_OS() == null;
            }
            case 22: {
                return pSDEFormDetailBase.getCol_SM() == null;
            }
            case 23: {
                return pSDEFormDetailBase.getCol_SM_OS() == null;
            }
            case 24: {
                return pSDEFormDetailBase.getCol_Width() == null;
            }
            case 25: {
                return pSDEFormDetailBase.getCol_XS() == null;
            }
            case 26: {
                return pSDEFormDetailBase.getCol_XS_OS() == null;
            }
            case 27: {
                return pSDEFormDetailBase.getContentType() == null;
            }
            case 28: {
                return pSDEFormDetailBase.getConvertCIText() == null;
            }
            case 29: {
                return pSDEFormDetailBase.getCounterId() == null;
            }
            case 30: {
                return pSDEFormDetailBase.getCounterMode() == null;
            }
            case 31: {
                return pSDEFormDetailBase.getCreateDate() == null;
            }
            case 32: {
                return pSDEFormDetailBase.getCreateDV() == null;
            }
            case 33: {
                return pSDEFormDetailBase.getCreateDVT() == null;
            }
            case 34: {
                return pSDEFormDetailBase.getCreateMan() == null;
            }
            case 35: {
                return pSDEFormDetailBase.getCssId() == null;
            }
            case 36: {
                return pSDEFormDetailBase.getCtrlColSpan() == null;
            }
            case 37: {
                return pSDEFormDetailBase.getCtrlDynaClass() == null;
            }
            case 38: {
                return pSDEFormDetailBase.getCtrlHeight() == null;
            }
            case 39: {
                return pSDEFormDetailBase.getCtrlPSSysCssId() == null;
            }
            case 40: {
                return pSDEFormDetailBase.getCtrlPSSysCssName() == null;
            }
            case 41: {
                return pSDEFormDetailBase.getCtrlRawCssStyle() == null;
            }
            case 42: {
                return pSDEFormDetailBase.getCtrlWidth() == null;
            }
            case 43: {
                return pSDEFormDetailBase.getCustomCode() == null;
            }
            case 44: {
                return pSDEFormDetailBase.getData() == null;
            }
            case 45: {
                return pSDEFormDetailBase.getDefaultFlag() == null;
            }
            case 46: {
                return pSDEFormDetailBase.getDetailStyle() == null;
            }
            case 47: {
                return pSDEFormDetailBase.getDetailStyleText() == null;
            }
            case 48: {
                return pSDEFormDetailBase.getDetailTag() == null;
            }
            case 49: {
                return pSDEFormDetailBase.getDetailTag2() == null;
            }
            case 50: {
                return pSDEFormDetailBase.getDetailType() == null;
            }
            case 51: {
                return pSDEFormDetailBase.getDynaClass() == null;
            }
            case 52: {
                return pSDEFormDetailBase.getDynaModelFlag() == null;
            }
            case 53: {
                return pSDEFormDetailBase.getEditorParams() == null;
            }
            case 54: {
                return pSDEFormDetailBase.getEditorType() == null;
            }
            case 55: {
                return pSDEFormDetailBase.getEditorTypeName() == null;
            }
            case 56: {
                return pSDEFormDetailBase.getEmptyCaption() == null;
            }
            case 57: {
                return pSDEFormDetailBase.getEnableAnchor() == null;
            }
            case 58: {
                return pSDEFormDetailBase.getEnableCond() == null;
            }
            case 59: {
                return pSDEFormDetailBase.getEnableInputTip() == null;
            }
            case 60: {
                return pSDEFormDetailBase.getEnableItemPriv() == null;
            }
            case 61: {
                return pSDEFormDetailBase.getEnableLogic() == null;
            }
            case 62: {
                return pSDEFormDetailBase.getFieldName() == null;
            }
            case 63: {
                return pSDEFormDetailBase.getFlexAlign() == null;
            }
            case 64: {
                return pSDEFormDetailBase.getFlexBasis() == null;
            }
            case 65: {
                return pSDEFormDetailBase.getFlexDir() == null;
            }
            case 66: {
                return pSDEFormDetailBase.getFlexGrow() == null;
            }
            case 67: {
                return pSDEFormDetailBase.getFlexShrink() == null;
            }
            case 68: {
                return pSDEFormDetailBase.getFlexVAlign() == null;
            }
            case 69: {
                return pSDEFormDetailBase.getFormType() == null;
            }
            case 70: {
                return pSDEFormDetailBase.getGridRowId() == null;
            }
            case 71: {
                return pSDEFormDetailBase.getHAlign() == null;
            }
            case 72: {
                return pSDEFormDetailBase.getHAlignSelf() == null;
            }
            case 73: {
                return pSDEFormDetailBase.getHeight() == null;
            }
            case 74: {
                return pSDEFormDetailBase.getHeightMode() == null;
            }
            case 75: {
                return pSDEFormDetailBase.getHtmlContent() == null;
            }
            case 76: {
                return pSDEFormDetailBase.getHtmlPageUrl() == null;
            }
            case 77: {
                return pSDEFormDetailBase.getIconAlign() == null;
            }
            case 78: {
                return pSDEFormDetailBase.getIgnoreInput() == null;
            }
            case 79: {
                return pSDEFormDetailBase.getInsertPos() == null;
            }
            case 80: {
                return pSDEFormDetailBase.getItemPSACHandlerId() == null;
            }
            case 81: {
                return pSDEFormDetailBase.getItemPSACHandlerName() == null;
            }
            case 82: {
                return pSDEFormDetailBase.getItemStates() == null;
            }
            case 83: {
                return pSDEFormDetailBase.getLabelColSpan() == null;
            }
            case 84: {
                return pSDEFormDetailBase.getLabelColSpan2() == null;
            }
            case 85: {
                return pSDEFormDetailBase.getLabelCssId() == null;
            }
            case 86: {
                return pSDEFormDetailBase.getLabelDynaClass() == null;
            }
            case 87: {
                return pSDEFormDetailBase.getLabelPos() == null;
            }
            case 88: {
                return pSDEFormDetailBase.getLabelPSSysCssId() == null;
            }
            case 89: {
                return pSDEFormDetailBase.getLabelPSSysCssName() == null;
            }
            case 90: {
                return pSDEFormDetailBase.getLabelRawCssStyle() == null;
            }
            case 91: {
                return pSDEFormDetailBase.getLabelWidth() == null;
            }
            case 92: {
                return pSDEFormDetailBase.getLayoutMode() == null;
            }
            case 93: {
                return pSDEFormDetailBase.getLevelTag() == null;
            }
            case 94: {
                return pSDEFormDetailBase.getLevelValue() == null;
            }
            case 95: {
                return pSDEFormDetailBase.getLinkPSDEViewId() == null;
            }
            case 96: {
                return pSDEFormDetailBase.getLinkPSDEViewName() == null;
            }
            case 97: {
                return pSDEFormDetailBase.getLogicName() == null;
            }
            case 98: {
                return pSDEFormDetailBase.getMargin() == null;
            }
            case 99: {
                return pSDEFormDetailBase.getMaskInfo() == null;
            }
            case 100: {
                return pSDEFormDetailBase.getMaskMode() == null;
            }
            case 101: {
                return pSDEFormDetailBase.getMaskPSLanResId() == null;
            }
            case 102: {
                return pSDEFormDetailBase.getMaskPSLanResName() == null;
            }
            case 103: {
                return pSDEFormDetailBase.getMDCtrlType() == null;
            }
            case 104: {
                return pSDEFormDetailBase.getMDPSDEDataViewId() == null;
            }
            case 105: {
                return pSDEFormDetailBase.getMDPSDEDataViewName() == null;
            }
            case 106: {
                return pSDEFormDetailBase.getMDPSDEFormId() == null;
            }
            case 107: {
                return pSDEFormDetailBase.getMDPSDEFormName() == null;
            }
            case 108: {
                return pSDEFormDetailBase.getMDPSDEGridId() == null;
            }
            case 109: {
                return pSDEFormDetailBase.getMDPSDEGridName() == null;
            }
            case 110: {
                return pSDEFormDetailBase.getMDPSDEListId() == null;
            }
            case 111: {
                return pSDEFormDetailBase.getMDPSDEListName() == null;
            }
            case 112: {
                return pSDEFormDetailBase.getMDPSSysViewPanelId() == null;
            }
            case 113: {
                return pSDEFormDetailBase.getMDPSSysViewPanelName() == null;
            }
            case 114: {
                return pSDEFormDetailBase.getMemo() == null;
            }
            case 115: {
                return pSDEFormDetailBase.getMobFlag() == null;
            }
            case 116: {
                return pSDEFormDetailBase.getModelState() == null;
            }
            case 117: {
                return pSDEFormDetailBase.getNeedCodeListConfig() == null;
            }
            case 118: {
                return pSDEFormDetailBase.getNoPrivDM() == null;
            }
            case 119: {
                return pSDEFormDetailBase.getOpenPSDEViewId() == null;
            }
            case 120: {
                return pSDEFormDetailBase.getOpenPSDEViewName() == null;
            }
            case 121: {
                return pSDEFormDetailBase.getOpenPSSysPDTViewId() == null;
            }
            case 122: {
                return pSDEFormDetailBase.getOpenPSSysPDTViewName() == null;
            }
            case 123: {
                return pSDEFormDetailBase.getOrderValue() == null;
            }
            case 124: {
                return pSDEFormDetailBase.getPadding() == null;
            }
            case 125: {
                return pSDEFormDetailBase.getPHPSLanResId() == null;
            }
            case 126: {
                return pSDEFormDetailBase.getPHPSLanResName() == null;
            }
            case 127: {
                return pSDEFormDetailBase.getPickupPSDEViewId() == null;
            }
            case 128: {
                return pSDEFormDetailBase.getPickupPSDEViewName() == null;
            }
            case 129: {
                return pSDEFormDetailBase.getPlaceHolder() == null;
            }
            case 130: {
                return pSDEFormDetailBase.getPLayoutMode() == null;
            }
            case 131: {
                return pSDEFormDetailBase.getPPSDEFormDetailId() == null;
            }
            case 132: {
                return pSDEFormDetailBase.getPPSDEFormDetailName() == null;
            }
            case 133: {
                return pSDEFormDetailBase.getPredefinedType() == null;
            }
            case 134: {
                return pSDEFormDetailBase.getPredefinedTypeText() == null;
            }
            case 135: {
                return pSDEFormDetailBase.getPreventXSS() == null;
            }
            case 136: {
                return pSDEFormDetailBase.getPreviewHtml() == null;
            }
            case 137: {
                return pSDEFormDetailBase.getPSCodeListId() == null;
            }
            case 138: {
                return pSDEFormDetailBase.getPSCodeListName() == null;
            }
            case 139: {
                return pSDEFormDetailBase.getPSDEDRId() == null;
            }
            case 140: {
                return pSDEFormDetailBase.getPSDEDRItemId() == null;
            }
            case 141: {
                return pSDEFormDetailBase.getPSDEDRItemName() == null;
            }
            case 142: {
                return pSDEFormDetailBase.getPSDEDRName() == null;
            }
            case 143: {
                return pSDEFormDetailBase.getPSDEFUIModeId() == null;
            }
            case 144: {
                return pSDEFormDetailBase.getPSDEFUIModeName() == null;
            }
            case 145: {
                return pSDEFormDetailBase.getPSDEFId() == null;
            }
            case 146: {
                return pSDEFormDetailBase.getPSDEFIUpdateId() == null;
            }
            case 147: {
                return pSDEFormDetailBase.getPSDEFIUpdateName() == null;
            }
            case 148: {
                return pSDEFormDetailBase.getPSDEFName() == null;
            }
            case 149: {
                return pSDEFormDetailBase.getPSDEFormDetailId() == null;
            }
            case 150: {
                return pSDEFormDetailBase.getPSDEFormDetailName() == null;
            }
            case 151: {
                return pSDEFormDetailBase.getPSDEFormId() == null;
            }
            case 152: {
                return pSDEFormDetailBase.getPSDEFormName() == null;
            }
            case 153: {
                return pSDEFormDetailBase.getPSDEFormRFId() == null;
            }
            case 154: {
                return pSDEFormDetailBase.getPSDEFormRFName() == null;
            }
            case 155: {
                return pSDEFormDetailBase.getPSDEFSFItemId() == null;
            }
            case 156: {
                return pSDEFormDetailBase.getPSDEFSFItemName() == null;
            }
            case 157: {
                return pSDEFormDetailBase.getPSDEId() == null;
            }
            case 158: {
                return pSDEFormDetailBase.getPSDELogicId() == null;
            }
            case 159: {
                return pSDEFormDetailBase.getPSDELogicName() == null;
            }
            case 160: {
                return pSDEFormDetailBase.getPSDEUAGroupId() == null;
            }
            case 161: {
                return pSDEFormDetailBase.getPSDEUAGroupName() == null;
            }
            case 162: {
                return pSDEFormDetailBase.getPSDEUIActionId() == null;
            }
            case 163: {
                return pSDEFormDetailBase.getPSDEUIActionName() == null;
            }
            case 164: {
                return pSDEFormDetailBase.getPSDynaInstId() == null;
            }
            case 165: {
                return pSDEFormDetailBase.getPSSysCounterId() == null;
            }
            case 166: {
                return pSDEFormDetailBase.getPSSysCounterName() == null;
            }
            case 167: {
                return pSDEFormDetailBase.getPSSysCssId() == null;
            }
            case 168: {
                return pSDEFormDetailBase.getPSSysCssName() == null;
            }
            case 169: {
                return pSDEFormDetailBase.getPSSysDictCatId() == null;
            }
            case 170: {
                return pSDEFormDetailBase.getPSSysDictCatName() == null;
            }
            case 171: {
                return pSDEFormDetailBase.getPSSysDynaModelId() == null;
            }
            case 172: {
                return pSDEFormDetailBase.getPSSysDynaModelName() == null;
            }
            case 173: {
                return pSDEFormDetailBase.getPSSysEditorStyleId() == null;
            }
            case 174: {
                return pSDEFormDetailBase.getPSSysEditorStyleName() == null;
            }
            case 175: {
                return pSDEFormDetailBase.getPSSysImageId() == null;
            }
            case 176: {
                return pSDEFormDetailBase.getPSSysImageName() == null;
            }
            case 177: {
                return pSDEFormDetailBase.getPSSysResourceId() == null;
            }
            case 178: {
                return pSDEFormDetailBase.getPSSysResourceName() == null;
            }
            case 179: {
                return pSDEFormDetailBase.getRawContent() == null;
            }
            case 180: {
                return pSDEFormDetailBase.getRawCssStyle() == null;
            }
            case 181: {
                return pSDEFormDetailBase.getRawServiceMethod() == null;
            }
            case 182: {
                return pSDEFormDetailBase.getRawServiceUrl() == null;
            }
            case 183: {
                return pSDEFormDetailBase.getRefPSDEACModeId() == null;
            }
            case 184: {
                return pSDEFormDetailBase.getRefPSDEACModeName() == null;
            }
            case 185: {
                return pSDEFormDetailBase.getRefPSDEDataSetId() == null;
            }
            case 186: {
                return pSDEFormDetailBase.getRefPSDEDataSetName() == null;
            }
            case 187: {
                return pSDEFormDetailBase.getRefPSDEFormDetailId() == null;
            }
            case 188: {
                return pSDEFormDetailBase.getRefPSDEFormDetailName() == null;
            }
            case 189: {
                return pSDEFormDetailBase.getRefPSDEFormId() == null;
            }
            case 190: {
                return pSDEFormDetailBase.getRefPSDEId() == null;
            }
            case 191: {
                return pSDEFormDetailBase.getRefPSDEName() == null;
            }
            case 192: {
                return pSDEFormDetailBase.getRefPSDERId() == null;
            }
            case 193: {
                return pSDEFormDetailBase.getRefPSDERName() == null;
            }
            case 194: {
                return pSDEFormDetailBase.getRenderMode() == null;
            }
            case 195: {
                return pSDEFormDetailBase.getRenderModeText() == null;
            }
            case 196: {
                return pSDEFormDetailBase.getResetItemName() == null;
            }
            case 197: {
                return pSDEFormDetailBase.getRowSpan() == null;
            }
            case 198: {
                return pSDEFormDetailBase.getShowCaption() == null;
            }
            case 199: {
                return pSDEFormDetailBase.getShowMoreMode() == null;
            }
            case 200: {
                return pSDEFormDetailBase.getSpacingBottom() == null;
            }
            case 201: {
                return pSDEFormDetailBase.getSpacingLeft() == null;
            }
            case 202: {
                return pSDEFormDetailBase.getSpacingRight() == null;
            }
            case 203: {
                return pSDEFormDetailBase.getSpacingTop() == null;
            }
            case 204: {
                return pSDEFormDetailBase.getSwapMode() == null;
            }
            case 205: {
                return pSDEFormDetailBase.getTemplateMode() == null;
            }
            case 206: {
                return pSDEFormDetailBase.getTipPSLanResId() == null;
            }
            case 207: {
                return pSDEFormDetailBase.getTipPSLanResName() == null;
            }
            case 208: {
                return pSDEFormDetailBase.getTitleBarCloseMode() == null;
            }
            case 209: {
                return pSDEFormDetailBase.getToggleMode() == null;
            }
            case 210: {
                return pSDEFormDetailBase.getTooltipInfo() == null;
            }
            case 211: {
                return pSDEFormDetailBase.getUCPSSysPFPluginId() == null;
            }
            case 212: {
                return pSDEFormDetailBase.getUCPSSysPFPluginName() == null;
            }
            case 213: {
                return pSDEFormDetailBase.getUpdateDate() == null;
            }
            case 214: {
                return pSDEFormDetailBase.getUpdateDV() == null;
            }
            case 215: {
                return pSDEFormDetailBase.getUpdateDVT() == null;
            }
            case 216: {
                return pSDEFormDetailBase.getUpdateMan() == null;
            }
            case 217: {
                return pSDEFormDetailBase.getUserTag() == null;
            }
            case 218: {
                return pSDEFormDetailBase.getUserTag2() == null;
            }
            case 219: {
                return pSDEFormDetailBase.getVAlign() == null;
            }
            case 220: {
                return pSDEFormDetailBase.getVAlignSelf() == null;
            }
            case 221: {
                return pSDEFormDetailBase.getValueFormat() == null;
            }
            case 222: {
                return pSDEFormDetailBase.getValueItemName() == null;
            }
            case 223: {
                return pSDEFormDetailBase.getVisibleLogic() == null;
            }
            case 224: {
                return pSDEFormDetailBase.getWBDEFMode() == null;
            }
            case 225: {
                return pSDEFormDetailBase.getWidth() == null;
            }
            case 226: {
                return pSDEFormDetailBase.getWidthMode() == null;
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
        return PSDEFormDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEFormDetailBase pSDEFormDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFormDetailBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDEFormDetailBase.isBlankLogicDirty();
            }
            case 2: {
                return pSDEFormDetailBase.isBL_PosDirty();
            }
            case 3: {
                return pSDEFormDetailBase.isBorderStyleDirty();
            }
            case 4: {
                return pSDEFormDetailBase.isBtnActionTypeDirty();
            }
            case 5: {
                return pSDEFormDetailBase.isBuildInActionDirty();
            }
            case 6: {
                return pSDEFormDetailBase.isCapPSLanResIdDirty();
            }
            case 7: {
                return pSDEFormDetailBase.isCapPSLanResNameDirty();
            }
            case 8: {
                return pSDEFormDetailBase.isCaptionDirty();
            }
            case 9: {
                return pSDEFormDetailBase.isChild_Col_LGDirty();
            }
            case 10: {
                return pSDEFormDetailBase.isChild_Col_MDDirty();
            }
            case 11: {
                return pSDEFormDetailBase.isChild_Col_SMDirty();
            }
            case 12: {
                return pSDEFormDetailBase.isChild_Col_XSDirty();
            }
            case 13: {
                return pSDEFormDetailBase.isCodeListConfigModeDirty();
            }
            case 14: {
                return pSDEFormDetailBase.isColAlignDirty();
            }
            case 15: {
                return pSDEFormDetailBase.isColIdDirty();
            }
            case 16: {
                return pSDEFormDetailBase.isColModelDirty();
            }
            case 17: {
                return pSDEFormDetailBase.isColSpanDirty();
            }
            case 18: {
                return pSDEFormDetailBase.isCol_LGDirty();
            }
            case 19: {
                return pSDEFormDetailBase.isCol_LG_OSDirty();
            }
            case 20: {
                return pSDEFormDetailBase.isCol_MDDirty();
            }
            case 21: {
                return pSDEFormDetailBase.isCol_MD_OSDirty();
            }
            case 22: {
                return pSDEFormDetailBase.isCol_SMDirty();
            }
            case 23: {
                return pSDEFormDetailBase.isCol_SM_OSDirty();
            }
            case 24: {
                return pSDEFormDetailBase.isCol_WidthDirty();
            }
            case 25: {
                return pSDEFormDetailBase.isCol_XSDirty();
            }
            case 26: {
                return pSDEFormDetailBase.isCol_XS_OSDirty();
            }
            case 27: {
                return pSDEFormDetailBase.isContentTypeDirty();
            }
            case 28: {
                return pSDEFormDetailBase.isConvertCITextDirty();
            }
            case 29: {
                return pSDEFormDetailBase.isCounterIdDirty();
            }
            case 30: {
                return pSDEFormDetailBase.isCounterModeDirty();
            }
            case 31: {
                return pSDEFormDetailBase.isCreateDateDirty();
            }
            case 32: {
                return pSDEFormDetailBase.isCreateDVDirty();
            }
            case 33: {
                return pSDEFormDetailBase.isCreateDVTDirty();
            }
            case 34: {
                return pSDEFormDetailBase.isCreateManDirty();
            }
            case 35: {
                return pSDEFormDetailBase.isCssIdDirty();
            }
            case 36: {
                return pSDEFormDetailBase.isCtrlColSpanDirty();
            }
            case 37: {
                return pSDEFormDetailBase.isCtrlDynaClassDirty();
            }
            case 38: {
                return pSDEFormDetailBase.isCtrlHeightDirty();
            }
            case 39: {
                return pSDEFormDetailBase.isCtrlPSSysCssIdDirty();
            }
            case 40: {
                return pSDEFormDetailBase.isCtrlPSSysCssNameDirty();
            }
            case 41: {
                return pSDEFormDetailBase.isCtrlRawCssStyleDirty();
            }
            case 42: {
                return pSDEFormDetailBase.isCtrlWidthDirty();
            }
            case 43: {
                return pSDEFormDetailBase.isCustomCodeDirty();
            }
            case 44: {
                return pSDEFormDetailBase.isDataDirty();
            }
            case 45: {
                return pSDEFormDetailBase.isDefaultFlagDirty();
            }
            case 46: {
                return pSDEFormDetailBase.isDetailStyleDirty();
            }
            case 47: {
                return pSDEFormDetailBase.isDetailStyleTextDirty();
            }
            case 48: {
                return pSDEFormDetailBase.isDetailTagDirty();
            }
            case 49: {
                return pSDEFormDetailBase.isDetailTag2Dirty();
            }
            case 50: {
                return pSDEFormDetailBase.isDetailTypeDirty();
            }
            case 51: {
                return pSDEFormDetailBase.isDynaClassDirty();
            }
            case 52: {
                return pSDEFormDetailBase.isDynaModelFlagDirty();
            }
            case 53: {
                return pSDEFormDetailBase.isEditorParamsDirty();
            }
            case 54: {
                return pSDEFormDetailBase.isEditorTypeDirty();
            }
            case 55: {
                return pSDEFormDetailBase.isEditorTypeNameDirty();
            }
            case 56: {
                return pSDEFormDetailBase.isEmptyCaptionDirty();
            }
            case 57: {
                return pSDEFormDetailBase.isEnableAnchorDirty();
            }
            case 58: {
                return pSDEFormDetailBase.isEnableCondDirty();
            }
            case 59: {
                return pSDEFormDetailBase.isEnableInputTipDirty();
            }
            case 60: {
                return pSDEFormDetailBase.isEnableItemPrivDirty();
            }
            case 61: {
                return pSDEFormDetailBase.isEnableLogicDirty();
            }
            case 62: {
                return pSDEFormDetailBase.isFieldNameDirty();
            }
            case 63: {
                return pSDEFormDetailBase.isFlexAlignDirty();
            }
            case 64: {
                return pSDEFormDetailBase.isFlexBasisDirty();
            }
            case 65: {
                return pSDEFormDetailBase.isFlexDirDirty();
            }
            case 66: {
                return pSDEFormDetailBase.isFlexGrowDirty();
            }
            case 67: {
                return pSDEFormDetailBase.isFlexShrinkDirty();
            }
            case 68: {
                return pSDEFormDetailBase.isFlexVAlignDirty();
            }
            case 69: {
                return pSDEFormDetailBase.isFormTypeDirty();
            }
            case 70: {
                return pSDEFormDetailBase.isGridRowIdDirty();
            }
            case 71: {
                return pSDEFormDetailBase.isHAlignDirty();
            }
            case 72: {
                return pSDEFormDetailBase.isHAlignSelfDirty();
            }
            case 73: {
                return pSDEFormDetailBase.isHeightDirty();
            }
            case 74: {
                return pSDEFormDetailBase.isHeightModeDirty();
            }
            case 75: {
                return pSDEFormDetailBase.isHtmlContentDirty();
            }
            case 76: {
                return pSDEFormDetailBase.isHtmlPageUrlDirty();
            }
            case 77: {
                return pSDEFormDetailBase.isIconAlignDirty();
            }
            case 78: {
                return pSDEFormDetailBase.isIgnoreInputDirty();
            }
            case 79: {
                return pSDEFormDetailBase.isInsertPosDirty();
            }
            case 80: {
                return pSDEFormDetailBase.isItemPSACHandlerIdDirty();
            }
            case 81: {
                return pSDEFormDetailBase.isItemPSACHandlerNameDirty();
            }
            case 82: {
                return pSDEFormDetailBase.isItemStatesDirty();
            }
            case 83: {
                return pSDEFormDetailBase.isLabelColSpanDirty();
            }
            case 84: {
                return pSDEFormDetailBase.isLabelColSpan2Dirty();
            }
            case 85: {
                return pSDEFormDetailBase.isLabelCssIdDirty();
            }
            case 86: {
                return pSDEFormDetailBase.isLabelDynaClassDirty();
            }
            case 87: {
                return pSDEFormDetailBase.isLabelPosDirty();
            }
            case 88: {
                return pSDEFormDetailBase.isLabelPSSysCssIdDirty();
            }
            case 89: {
                return pSDEFormDetailBase.isLabelPSSysCssNameDirty();
            }
            case 90: {
                return pSDEFormDetailBase.isLabelRawCssStyleDirty();
            }
            case 91: {
                return pSDEFormDetailBase.isLabelWidthDirty();
            }
            case 92: {
                return pSDEFormDetailBase.isLayoutModeDirty();
            }
            case 93: {
                return pSDEFormDetailBase.isLevelTagDirty();
            }
            case 94: {
                return pSDEFormDetailBase.isLevelValueDirty();
            }
            case 95: {
                return pSDEFormDetailBase.isLinkPSDEViewIdDirty();
            }
            case 96: {
                return pSDEFormDetailBase.isLinkPSDEViewNameDirty();
            }
            case 97: {
                return pSDEFormDetailBase.isLogicNameDirty();
            }
            case 98: {
                return pSDEFormDetailBase.isMarginDirty();
            }
            case 99: {
                return pSDEFormDetailBase.isMaskInfoDirty();
            }
            case 100: {
                return pSDEFormDetailBase.isMaskModeDirty();
            }
            case 101: {
                return pSDEFormDetailBase.isMaskPSLanResIdDirty();
            }
            case 102: {
                return pSDEFormDetailBase.isMaskPSLanResNameDirty();
            }
            case 103: {
                return pSDEFormDetailBase.isMDCtrlTypeDirty();
            }
            case 104: {
                return pSDEFormDetailBase.isMDPSDEDataViewIdDirty();
            }
            case 105: {
                return pSDEFormDetailBase.isMDPSDEDataViewNameDirty();
            }
            case 106: {
                return pSDEFormDetailBase.isMDPSDEFormIdDirty();
            }
            case 107: {
                return pSDEFormDetailBase.isMDPSDEFormNameDirty();
            }
            case 108: {
                return pSDEFormDetailBase.isMDPSDEGridIdDirty();
            }
            case 109: {
                return pSDEFormDetailBase.isMDPSDEGridNameDirty();
            }
            case 110: {
                return pSDEFormDetailBase.isMDPSDEListIdDirty();
            }
            case 111: {
                return pSDEFormDetailBase.isMDPSDEListNameDirty();
            }
            case 112: {
                return pSDEFormDetailBase.isMDPSSysViewPanelIdDirty();
            }
            case 113: {
                return pSDEFormDetailBase.isMDPSSysViewPanelNameDirty();
            }
            case 114: {
                return pSDEFormDetailBase.isMemoDirty();
            }
            case 115: {
                return pSDEFormDetailBase.isMobFlagDirty();
            }
            case 116: {
                return pSDEFormDetailBase.isModelStateDirty();
            }
            case 117: {
                return pSDEFormDetailBase.isNeedCodeListConfigDirty();
            }
            case 118: {
                return pSDEFormDetailBase.isNoPrivDMDirty();
            }
            case 119: {
                return pSDEFormDetailBase.isOpenPSDEViewIdDirty();
            }
            case 120: {
                return pSDEFormDetailBase.isOpenPSDEViewNameDirty();
            }
            case 121: {
                return pSDEFormDetailBase.isOpenPSSysPDTViewIdDirty();
            }
            case 122: {
                return pSDEFormDetailBase.isOpenPSSysPDTViewNameDirty();
            }
            case 123: {
                return pSDEFormDetailBase.isOrderValueDirty();
            }
            case 124: {
                return pSDEFormDetailBase.isPaddingDirty();
            }
            case 125: {
                return pSDEFormDetailBase.isPHPSLanResIdDirty();
            }
            case 126: {
                return pSDEFormDetailBase.isPHPSLanResNameDirty();
            }
            case 127: {
                return pSDEFormDetailBase.isPickupPSDEViewIdDirty();
            }
            case 128: {
                return pSDEFormDetailBase.isPickupPSDEViewNameDirty();
            }
            case 129: {
                return pSDEFormDetailBase.isPlaceHolderDirty();
            }
            case 130: {
                return pSDEFormDetailBase.isPLayoutModeDirty();
            }
            case 131: {
                return pSDEFormDetailBase.isPPSDEFormDetailIdDirty();
            }
            case 132: {
                return pSDEFormDetailBase.isPPSDEFormDetailNameDirty();
            }
            case 133: {
                return pSDEFormDetailBase.isPredefinedTypeDirty();
            }
            case 134: {
                return pSDEFormDetailBase.isPredefinedTypeTextDirty();
            }
            case 135: {
                return pSDEFormDetailBase.isPreventXSSDirty();
            }
            case 136: {
                return pSDEFormDetailBase.isPreviewHtmlDirty();
            }
            case 137: {
                return pSDEFormDetailBase.isPSCodeListIdDirty();
            }
            case 138: {
                return pSDEFormDetailBase.isPSCodeListNameDirty();
            }
            case 139: {
                return pSDEFormDetailBase.isPSDEDRIdDirty();
            }
            case 140: {
                return pSDEFormDetailBase.isPSDEDRItemIdDirty();
            }
            case 141: {
                return pSDEFormDetailBase.isPSDEDRItemNameDirty();
            }
            case 142: {
                return pSDEFormDetailBase.isPSDEDRNameDirty();
            }
            case 143: {
                return pSDEFormDetailBase.isPSDEFUIModeIdDirty();
            }
            case 144: {
                return pSDEFormDetailBase.isPSDEFUIModeNameDirty();
            }
            case 145: {
                return pSDEFormDetailBase.isPSDEFIdDirty();
            }
            case 146: {
                return pSDEFormDetailBase.isPSDEFIUpdateIdDirty();
            }
            case 147: {
                return pSDEFormDetailBase.isPSDEFIUpdateNameDirty();
            }
            case 148: {
                return pSDEFormDetailBase.isPSDEFNameDirty();
            }
            case 149: {
                return pSDEFormDetailBase.isPSDEFormDetailIdDirty();
            }
            case 150: {
                return pSDEFormDetailBase.isPSDEFormDetailNameDirty();
            }
            case 151: {
                return pSDEFormDetailBase.isPSDEFormIdDirty();
            }
            case 152: {
                return pSDEFormDetailBase.isPSDEFormNameDirty();
            }
            case 153: {
                return pSDEFormDetailBase.isPSDEFormRFIdDirty();
            }
            case 154: {
                return pSDEFormDetailBase.isPSDEFormRFNameDirty();
            }
            case 155: {
                return pSDEFormDetailBase.isPSDEFSFItemIdDirty();
            }
            case 156: {
                return pSDEFormDetailBase.isPSDEFSFItemNameDirty();
            }
            case 157: {
                return pSDEFormDetailBase.isPSDEIdDirty();
            }
            case 158: {
                return pSDEFormDetailBase.isPSDELogicIdDirty();
            }
            case 159: {
                return pSDEFormDetailBase.isPSDELogicNameDirty();
            }
            case 160: {
                return pSDEFormDetailBase.isPSDEUAGroupIdDirty();
            }
            case 161: {
                return pSDEFormDetailBase.isPSDEUAGroupNameDirty();
            }
            case 162: {
                return pSDEFormDetailBase.isPSDEUIActionIdDirty();
            }
            case 163: {
                return pSDEFormDetailBase.isPSDEUIActionNameDirty();
            }
            case 164: {
                return pSDEFormDetailBase.isPSDynaInstIdDirty();
            }
            case 165: {
                return pSDEFormDetailBase.isPSSysCounterIdDirty();
            }
            case 166: {
                return pSDEFormDetailBase.isPSSysCounterNameDirty();
            }
            case 167: {
                return pSDEFormDetailBase.isPSSysCssIdDirty();
            }
            case 168: {
                return pSDEFormDetailBase.isPSSysCssNameDirty();
            }
            case 169: {
                return pSDEFormDetailBase.isPSSysDictCatIdDirty();
            }
            case 170: {
                return pSDEFormDetailBase.isPSSysDictCatNameDirty();
            }
            case 171: {
                return pSDEFormDetailBase.isPSSysDynaModelIdDirty();
            }
            case 172: {
                return pSDEFormDetailBase.isPSSysDynaModelNameDirty();
            }
            case 173: {
                return pSDEFormDetailBase.isPSSysEditorStyleIdDirty();
            }
            case 174: {
                return pSDEFormDetailBase.isPSSysEditorStyleNameDirty();
            }
            case 175: {
                return pSDEFormDetailBase.isPSSysImageIdDirty();
            }
            case 176: {
                return pSDEFormDetailBase.isPSSysImageNameDirty();
            }
            case 177: {
                return pSDEFormDetailBase.isPSSysResourceIdDirty();
            }
            case 178: {
                return pSDEFormDetailBase.isPSSysResourceNameDirty();
            }
            case 179: {
                return pSDEFormDetailBase.isRawContentDirty();
            }
            case 180: {
                return pSDEFormDetailBase.isRawCssStyleDirty();
            }
            case 181: {
                return pSDEFormDetailBase.isRawServiceMethodDirty();
            }
            case 182: {
                return pSDEFormDetailBase.isRawServiceUrlDirty();
            }
            case 183: {
                return pSDEFormDetailBase.isRefPSDEACModeIdDirty();
            }
            case 184: {
                return pSDEFormDetailBase.isRefPSDEACModeNameDirty();
            }
            case 185: {
                return pSDEFormDetailBase.isRefPSDEDataSetIdDirty();
            }
            case 186: {
                return pSDEFormDetailBase.isRefPSDEDataSetNameDirty();
            }
            case 187: {
                return pSDEFormDetailBase.isRefPSDEFormDetailIdDirty();
            }
            case 188: {
                return pSDEFormDetailBase.isRefPSDEFormDetailNameDirty();
            }
            case 189: {
                return pSDEFormDetailBase.isRefPSDEFormIdDirty();
            }
            case 190: {
                return pSDEFormDetailBase.isRefPSDEIdDirty();
            }
            case 191: {
                return pSDEFormDetailBase.isRefPSDENameDirty();
            }
            case 192: {
                return pSDEFormDetailBase.isRefPSDERIdDirty();
            }
            case 193: {
                return pSDEFormDetailBase.isRefPSDERNameDirty();
            }
            case 194: {
                return pSDEFormDetailBase.isRenderModeDirty();
            }
            case 195: {
                return pSDEFormDetailBase.isRenderModeTextDirty();
            }
            case 196: {
                return pSDEFormDetailBase.isResetItemNameDirty();
            }
            case 197: {
                return pSDEFormDetailBase.isRowSpanDirty();
            }
            case 198: {
                return pSDEFormDetailBase.isShowCaptionDirty();
            }
            case 199: {
                return pSDEFormDetailBase.isShowMoreModeDirty();
            }
            case 200: {
                return pSDEFormDetailBase.isSpacingBottomDirty();
            }
            case 201: {
                return pSDEFormDetailBase.isSpacingLeftDirty();
            }
            case 202: {
                return pSDEFormDetailBase.isSpacingRightDirty();
            }
            case 203: {
                return pSDEFormDetailBase.isSpacingTopDirty();
            }
            case 204: {
                return pSDEFormDetailBase.isSwapModeDirty();
            }
            case 205: {
                return pSDEFormDetailBase.isTemplateModeDirty();
            }
            case 206: {
                return pSDEFormDetailBase.isTipPSLanResIdDirty();
            }
            case 207: {
                return pSDEFormDetailBase.isTipPSLanResNameDirty();
            }
            case 208: {
                return pSDEFormDetailBase.isTitleBarCloseModeDirty();
            }
            case 209: {
                return pSDEFormDetailBase.isToggleModeDirty();
            }
            case 210: {
                return pSDEFormDetailBase.isTooltipInfoDirty();
            }
            case 211: {
                return pSDEFormDetailBase.isUCPSSysPFPluginIdDirty();
            }
            case 212: {
                return pSDEFormDetailBase.isUCPSSysPFPluginNameDirty();
            }
            case 213: {
                return pSDEFormDetailBase.isUpdateDateDirty();
            }
            case 214: {
                return pSDEFormDetailBase.isUpdateDVDirty();
            }
            case 215: {
                return pSDEFormDetailBase.isUpdateDVTDirty();
            }
            case 216: {
                return pSDEFormDetailBase.isUpdateManDirty();
            }
            case 217: {
                return pSDEFormDetailBase.isUserTagDirty();
            }
            case 218: {
                return pSDEFormDetailBase.isUserTag2Dirty();
            }
            case 219: {
                return pSDEFormDetailBase.isVAlignDirty();
            }
            case 220: {
                return pSDEFormDetailBase.isVAlignSelfDirty();
            }
            case 221: {
                return pSDEFormDetailBase.isValueFormatDirty();
            }
            case 222: {
                return pSDEFormDetailBase.isValueItemNameDirty();
            }
            case 223: {
                return pSDEFormDetailBase.isVisibleLogicDirty();
            }
            case 224: {
                return pSDEFormDetailBase.isWBDEFModeDirty();
            }
            case 225: {
                return pSDEFormDetailBase.isWidthDirty();
            }
            case 226: {
                return pSDEFormDetailBase.isWidthModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFormDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFormDetailBase pSDEFormDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFormDetailBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getBlankLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"blanklogic", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getBlankLogic()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getBL_Pos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bl_pos", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getBL_Pos()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getBorderStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"borderstyle", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getBorderStyle()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getBtnActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"btnactiontype", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getBtnActionType()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getBuildInAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"buildinaction", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getBuildInAction()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getChild_Col_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_lg", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getChild_Col_LG()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getChild_Col_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_md", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getChild_Col_MD()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getChild_Col_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_sm", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getChild_Col_SM()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getChild_Col_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_xs", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getChild_Col_XS()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCodeListConfigMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codelistconfigmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCodeListConfigMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getColAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colalign", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getColAlign()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getColId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getColModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colmodel", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getColModel()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colspan", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getColSpan()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_LG()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_LG_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg_os", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_LG_OS()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_MD()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_MD_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md_os", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_MD_OS()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_SM()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_SM_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm_os", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_SM_OS()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_Width() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_width", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_Width()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_XS()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCol_XS_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs_os", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCol_XS_OS()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getContentType()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getConvertCIText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"convertcitext", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getConvertCIText()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCounterId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCreateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdv", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCreateDV()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCreateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdvt", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCreateDVT()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCssId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCtrlColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlcolspan", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCtrlColSpan()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCtrlDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrldynaclass", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCtrlDynaClass()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCtrlHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlheight", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCtrlHeight()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCtrlPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpssyscssid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCtrlPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCtrlPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpssyscssname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCtrlPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCtrlRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlrawcssstyle", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCtrlRawCssStyle()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCtrlWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlwidth", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCtrlWidth()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getData()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDetailStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailstyle", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDetailStyle()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDetailStyleText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailstyletext", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDetailStyleText()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDetailTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDetailTag()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDetailTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag2", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDetailTag2()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDetailType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtype", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDetailType()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEditorParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorparams", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEditorParams()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEditorType()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortypename", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEditorTypeName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEmptyCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptycaption", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEmptyCaption()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEnableAnchor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableanchor", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEnableAnchor()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEnableCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecond", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEnableCond()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEnableInputTip() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableinputtip", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEnableInputTip()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelogic", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getEnableLogic()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFieldName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFlexBasis() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexbasis", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFlexBasis()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFlexGrow() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexgrow", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFlexGrow()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFlexShrink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexshrink", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFlexShrink()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getFormType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formtype", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getFormType()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getGridRowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridrowid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getGridRowId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getHAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halign", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getHAlign()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getHAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halignself", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getHAlignSelf()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getHeight()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getHeightMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"heightmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getHeightMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getHtmlPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlpageurl", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getHtmlPageUrl()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getIconAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconalign", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getIconAlign()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getIgnoreInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreinput", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getIgnoreInput()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getInsertPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insertpos", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getInsertPos()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getItemPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempsachandlerid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getItemPSACHandlerId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getItemPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itempsachandlername", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getItemPSACHandlerName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getItemStates() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemstates", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getItemStates()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelcolspan", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelColSpan()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelColSpan2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelcolspan2", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelColSpan2()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelcssid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelCssId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labeldynaclass", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelDynaClass()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpos", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelPos()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpssyscssid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpssyscssname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelrawcssstyle", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelRawCssStyle()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLabelWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelwidth", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLabelWidth()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkpsdeviewname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMargin() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"margin", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMargin()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMaskInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maskinfo", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMaskInfo()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMaskMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maskmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMaskMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMaskPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maskpslanresid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMaskPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMaskPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maskpslanresname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMaskPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdctrltype", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDCtrlType()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdedataviewid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdedataviewname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdeformid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdeformname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdegridid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdegridname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdelistid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEListId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpsdelistname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSDEListName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpssysviewpanelid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMDPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mdpssysviewpanelname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMDPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getMobFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobflag", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getMobFlag()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getNeedCodeListConfig() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needcodelistconfig", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getNeedCodeListConfig()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noprivdm", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getNoPrivDM()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getOpenPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsdeviewid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getOpenPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getOpenPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsdeviewname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getOpenPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getOpenPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpssyspdtviewid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getOpenPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getOpenPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpssyspdtviewname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getOpenPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPadding() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"padding", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPadding()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPHPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPHPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPHPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPHPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pickuppsdeviewname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPlaceHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placeholder", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPlaceHolder()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"playoutmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPLayoutMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPPSDEFormDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdeformdetailid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPPSDEFormDetailId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPPSDEFormDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdeformdetailname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPPSDEFormDetailName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPreventXSS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preventxss", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPreventXSS()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEDRId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEDRItemId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEDRItemName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEDRName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFUIModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefformitemid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFUIModeId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFUIModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefformitemname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFUIModeName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiupdateid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFIUpdateId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiupdatename", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFIUpdateName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFormDetailId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFormDetailName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormRFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformrfid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFormRFId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormRFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformrfname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFormRFName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFSFItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFSFItemId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEFSFItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefsfitemname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEFSFItemName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysDictCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysDictCatId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysDictCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdictcatname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysDictCatName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRawContent()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcssstyle", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRawCssStyle()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRawServiceMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawservicemethod", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRawServiceMethod()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRawServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawserviceurl", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRawServiceUrl()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodeid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodename", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEFormDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeformdetailid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEFormDetailId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEFormDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeformdetailname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEFormDetailName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeformid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsderid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDERId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRefPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdername", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRefPSDERName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRenderMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRenderMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRenderModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermodetext", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRenderModeText()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getResetItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetitemname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getResetItemName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getRowSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rowspan", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getRowSpan()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getShowCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showcaption", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getShowCaption()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getShowMoreMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showmoremode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getShowMoreMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getSpacingBottom() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingbottom", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getSpacingBottom()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getSpacingLeft() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingleft", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getSpacingLeft()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getSpacingRight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingright", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getSpacingRight()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getSpacingTop() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingtop", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getSpacingTop()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getSwapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swapmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getSwapMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getTitleBarCloseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlebarclosemode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getTitleBarCloseMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getToggleMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"togglemode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getToggleMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUCPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ucpssyspfpluginid", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUCPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUCPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ucpssyspfpluginname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUCPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUpdateDV() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedv", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUpdateDV()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUpdateDVT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedvt", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUpdateDVT()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valign", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getVAlign()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getVAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valignself", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getVAlignSelf()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getValueItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueitemname", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getValueItemName()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getVisibleLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"visiblelogic", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getVisibleLogic()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getWBDEFMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wbdefmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getWBDEFMode()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getWidth()), (boolean)false);
        }
        if (bl || pSDEFormDetailBase.getWidthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"widthmode", (Object)PSDEFormDetailBase.getJSONValue((Object)pSDEFormDetailBase.getWidthMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFormDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFormDetailBase pSDEFormDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFormDetailBase.getAllowEmpty() != null) {
            object = pSDEFormDetailBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getBlankLogic() != null) {
            object = pSDEFormDetailBase.getBlankLogic();
            xmlNode.setAttribute(FIELD_BLANKLOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getBL_Pos() != null) {
            object = pSDEFormDetailBase.getBL_Pos();
            xmlNode.setAttribute(FIELD_BL_POS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getBorderStyle() != null) {
            object = pSDEFormDetailBase.getBorderStyle();
            xmlNode.setAttribute(FIELD_BORDERSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getBtnActionType() != null) {
            object = pSDEFormDetailBase.getBtnActionType();
            xmlNode.setAttribute(FIELD_BTNACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getBuildInAction() != null) {
            object = pSDEFormDetailBase.getBuildInAction();
            xmlNode.setAttribute(FIELD_BUILDINACTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCapPSLanResId() != null) {
            object = pSDEFormDetailBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCapPSLanResName() != null) {
            object = pSDEFormDetailBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCaption() != null) {
            object = pSDEFormDetailBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getChild_Col_LG() != null) {
            object = pSDEFormDetailBase.getChild_Col_LG();
            xmlNode.setAttribute(FIELD_CHILD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getChild_Col_MD() != null) {
            object = pSDEFormDetailBase.getChild_Col_MD();
            xmlNode.setAttribute(FIELD_CHILD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getChild_Col_SM() != null) {
            object = pSDEFormDetailBase.getChild_Col_SM();
            xmlNode.setAttribute(FIELD_CHILD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getChild_Col_XS() != null) {
            object = pSDEFormDetailBase.getChild_Col_XS();
            xmlNode.setAttribute(FIELD_CHILD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCodeListConfigMode() != null) {
            object = pSDEFormDetailBase.getCodeListConfigMode();
            xmlNode.setAttribute(FIELD_CODELISTCONFIGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getColAlign() != null) {
            object = pSDEFormDetailBase.getColAlign();
            xmlNode.setAttribute(FIELD_COLALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getColId() != null) {
            object = pSDEFormDetailBase.getColId();
            xmlNode.setAttribute(FIELD_COLID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getColModel() != null) {
            object = pSDEFormDetailBase.getColModel();
            xmlNode.setAttribute(FIELD_COLMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getColSpan() != null) {
            object = pSDEFormDetailBase.getColSpan();
            xmlNode.setAttribute(FIELD_COLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_LG() != null) {
            object = pSDEFormDetailBase.getCol_LG();
            xmlNode.setAttribute(FIELD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_LG_OS() != null) {
            object = pSDEFormDetailBase.getCol_LG_OS();
            xmlNode.setAttribute(FIELD_COL_LG_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_MD() != null) {
            object = pSDEFormDetailBase.getCol_MD();
            xmlNode.setAttribute(FIELD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_MD_OS() != null) {
            object = pSDEFormDetailBase.getCol_MD_OS();
            xmlNode.setAttribute(FIELD_COL_MD_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_SM() != null) {
            object = pSDEFormDetailBase.getCol_SM();
            xmlNode.setAttribute(FIELD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_SM_OS() != null) {
            object = pSDEFormDetailBase.getCol_SM_OS();
            xmlNode.setAttribute(FIELD_COL_SM_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_Width() != null) {
            object = pSDEFormDetailBase.getCol_Width();
            xmlNode.setAttribute(FIELD_COL_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_XS() != null) {
            object = pSDEFormDetailBase.getCol_XS();
            xmlNode.setAttribute(FIELD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCol_XS_OS() != null) {
            object = pSDEFormDetailBase.getCol_XS_OS();
            xmlNode.setAttribute(FIELD_COL_XS_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getContentType() != null) {
            object = pSDEFormDetailBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getConvertCIText() != null) {
            object = pSDEFormDetailBase.getConvertCIText();
            xmlNode.setAttribute(FIELD_CONVERTCITEXT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCounterId() != null) {
            object = pSDEFormDetailBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCounterMode() != null) {
            object = pSDEFormDetailBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCreateDate() != null) {
            object = pSDEFormDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCreateDV() != null) {
            object = pSDEFormDetailBase.getCreateDV();
            xmlNode.setAttribute(FIELD_CREATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCreateDVT() != null) {
            object = pSDEFormDetailBase.getCreateDVT();
            xmlNode.setAttribute(FIELD_CREATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCreateMan() != null) {
            object = pSDEFormDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCssId() != null) {
            object = pSDEFormDetailBase.getCssId();
            xmlNode.setAttribute(FIELD_CSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCtrlColSpan() != null) {
            object = pSDEFormDetailBase.getCtrlColSpan();
            xmlNode.setAttribute(FIELD_CTRLCOLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCtrlDynaClass() != null) {
            object = pSDEFormDetailBase.getCtrlDynaClass();
            xmlNode.setAttribute(FIELD_CTRLDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCtrlHeight() != null) {
            object = pSDEFormDetailBase.getCtrlHeight();
            xmlNode.setAttribute(FIELD_CTRLHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCtrlPSSysCssId() != null) {
            object = pSDEFormDetailBase.getCtrlPSSysCssId();
            xmlNode.setAttribute(FIELD_CTRLPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCtrlPSSysCssName() != null) {
            object = pSDEFormDetailBase.getCtrlPSSysCssName();
            xmlNode.setAttribute(FIELD_CTRLPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCtrlRawCssStyle() != null) {
            object = pSDEFormDetailBase.getCtrlRawCssStyle();
            xmlNode.setAttribute(FIELD_CTRLRAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getCtrlWidth() != null) {
            object = pSDEFormDetailBase.getCtrlWidth();
            xmlNode.setAttribute(FIELD_CTRLWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getCustomCode() != null) {
            object = pSDEFormDetailBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getData() != null) {
            object = pSDEFormDetailBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getDefaultFlag() != null) {
            object = pSDEFormDetailBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getDetailStyle() != null) {
            object = pSDEFormDetailBase.getDetailStyle();
            xmlNode.setAttribute(FIELD_DETAILSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getDetailStyleText() != null) {
            object = pSDEFormDetailBase.getDetailStyleText();
            xmlNode.setAttribute(FIELD_DETAILSTYLETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getDetailTag() != null) {
            object = pSDEFormDetailBase.getDetailTag();
            xmlNode.setAttribute(FIELD_DETAILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getDetailTag2() != null) {
            object = pSDEFormDetailBase.getDetailTag2();
            xmlNode.setAttribute(FIELD_DETAILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getDetailType() != null) {
            object = pSDEFormDetailBase.getDetailType();
            xmlNode.setAttribute(FIELD_DETAILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getDynaClass() != null) {
            object = pSDEFormDetailBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getDynaModelFlag() != null) {
            object = pSDEFormDetailBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getEditorParams() != null) {
            object = pSDEFormDetailBase.getEditorParams();
            xmlNode.setAttribute(FIELD_EDITORPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getEditorType() != null) {
            object = pSDEFormDetailBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getEditorTypeName() != null) {
            object = pSDEFormDetailBase.getEditorTypeName();
            xmlNode.setAttribute(FIELD_EDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getEmptyCaption() != null) {
            object = pSDEFormDetailBase.getEmptyCaption();
            xmlNode.setAttribute(FIELD_EMPTYCAPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getEnableAnchor() != null) {
            object = pSDEFormDetailBase.getEnableAnchor();
            xmlNode.setAttribute(FIELD_ENABLEANCHOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getEnableCond() != null) {
            object = pSDEFormDetailBase.getEnableCond();
            xmlNode.setAttribute(FIELD_ENABLECOND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getEnableInputTip() != null) {
            object = pSDEFormDetailBase.getEnableInputTip();
            xmlNode.setAttribute(FIELD_ENABLEINPUTTIP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getEnableItemPriv() != null) {
            object = pSDEFormDetailBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getEnableLogic() != null) {
            object = pSDEFormDetailBase.getEnableLogic();
            xmlNode.setAttribute(FIELD_ENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getFieldName() != null) {
            object = pSDEFormDetailBase.getFieldName();
            xmlNode.setAttribute(FIELD_FIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getFlexAlign() != null) {
            object = pSDEFormDetailBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getFlexBasis() != null) {
            object = pSDEFormDetailBase.getFlexBasis();
            xmlNode.setAttribute(FIELD_FLEXBASIS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getFlexDir() != null) {
            object = pSDEFormDetailBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getFlexGrow() != null) {
            object = pSDEFormDetailBase.getFlexGrow();
            xmlNode.setAttribute(FIELD_FLEXGROW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getFlexShrink() != null) {
            object = pSDEFormDetailBase.getFlexShrink();
            xmlNode.setAttribute(FIELD_FLEXSHRINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getFlexVAlign() != null) {
            object = pSDEFormDetailBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getFormType() != null) {
            object = pSDEFormDetailBase.getFormType();
            xmlNode.setAttribute(FIELD_FORMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getGridRowId() != null) {
            object = pSDEFormDetailBase.getGridRowId();
            xmlNode.setAttribute(FIELD_GRIDROWID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getHAlign() != null) {
            object = pSDEFormDetailBase.getHAlign();
            xmlNode.setAttribute(FIELD_HALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getHAlignSelf() != null) {
            object = pSDEFormDetailBase.getHAlignSelf();
            xmlNode.setAttribute(FIELD_HALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getHeight() != null) {
            object = pSDEFormDetailBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getHeightMode() != null) {
            object = pSDEFormDetailBase.getHeightMode();
            xmlNode.setAttribute(FIELD_HEIGHTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getHtmlContent() != null) {
            object = pSDEFormDetailBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getHtmlPageUrl() != null) {
            object = pSDEFormDetailBase.getHtmlPageUrl();
            xmlNode.setAttribute(FIELD_HTMLPAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getIconAlign() != null) {
            object = pSDEFormDetailBase.getIconAlign();
            xmlNode.setAttribute(FIELD_ICONALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getIgnoreInput() != null) {
            object = pSDEFormDetailBase.getIgnoreInput();
            xmlNode.setAttribute(FIELD_IGNOREINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getInsertPos() != null) {
            object = pSDEFormDetailBase.getInsertPos();
            xmlNode.setAttribute(FIELD_INSERTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getItemPSACHandlerId() != null) {
            object = pSDEFormDetailBase.getItemPSACHandlerId();
            xmlNode.setAttribute(FIELD_ITEMPSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getItemPSACHandlerName() != null) {
            object = pSDEFormDetailBase.getItemPSACHandlerName();
            xmlNode.setAttribute(FIELD_ITEMPSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getItemStates() != null) {
            object = pSDEFormDetailBase.getItemStates();
            xmlNode.setAttribute(FIELD_ITEMSTATES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getLabelColSpan() != null) {
            object = pSDEFormDetailBase.getLabelColSpan();
            xmlNode.setAttribute(FIELD_LABELCOLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getLabelColSpan2() != null) {
            object = pSDEFormDetailBase.getLabelColSpan2();
            xmlNode.setAttribute(FIELD_LABELCOLSPAN2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getLabelCssId() != null) {
            object = pSDEFormDetailBase.getLabelCssId();
            xmlNode.setAttribute(FIELD_LABELCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLabelDynaClass() != null) {
            object = pSDEFormDetailBase.getLabelDynaClass();
            xmlNode.setAttribute(FIELD_LABELDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLabelPos() != null) {
            object = pSDEFormDetailBase.getLabelPos();
            xmlNode.setAttribute(FIELD_LABELPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLabelPSSysCssId() != null) {
            object = pSDEFormDetailBase.getLabelPSSysCssId();
            xmlNode.setAttribute(FIELD_LABELPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLabelPSSysCssName() != null) {
            object = pSDEFormDetailBase.getLabelPSSysCssName();
            xmlNode.setAttribute(FIELD_LABELPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLabelRawCssStyle() != null) {
            object = pSDEFormDetailBase.getLabelRawCssStyle();
            xmlNode.setAttribute(FIELD_LABELRAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLabelWidth() != null) {
            object = pSDEFormDetailBase.getLabelWidth();
            xmlNode.setAttribute(FIELD_LABELWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getLayoutMode() != null) {
            object = pSDEFormDetailBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLevelTag() != null) {
            object = pSDEFormDetailBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLevelValue() != null) {
            object = pSDEFormDetailBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getLinkPSDEViewId() != null) {
            object = pSDEFormDetailBase.getLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLinkPSDEViewName() != null) {
            object = pSDEFormDetailBase.getLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_LINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getLogicName() != null) {
            object = pSDEFormDetailBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMargin() != null) {
            object = pSDEFormDetailBase.getMargin();
            xmlNode.setAttribute(FIELD_MARGIN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMaskInfo() != null) {
            object = pSDEFormDetailBase.getMaskInfo();
            xmlNode.setAttribute(FIELD_MASKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMaskMode() != null) {
            object = pSDEFormDetailBase.getMaskMode();
            xmlNode.setAttribute(FIELD_MASKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getMaskPSLanResId() != null) {
            object = pSDEFormDetailBase.getMaskPSLanResId();
            xmlNode.setAttribute(FIELD_MASKPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMaskPSLanResName() != null) {
            object = pSDEFormDetailBase.getMaskPSLanResName();
            xmlNode.setAttribute(FIELD_MASKPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDCtrlType() != null) {
            object = pSDEFormDetailBase.getMDCtrlType();
            xmlNode.setAttribute(FIELD_MDCTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEDataViewId() != null) {
            object = pSDEFormDetailBase.getMDPSDEDataViewId();
            xmlNode.setAttribute(FIELD_MDPSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEDataViewName() != null) {
            object = pSDEFormDetailBase.getMDPSDEDataViewName();
            xmlNode.setAttribute(FIELD_MDPSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEFormId() != null) {
            object = pSDEFormDetailBase.getMDPSDEFormId();
            xmlNode.setAttribute(FIELD_MDPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEFormName() != null) {
            object = pSDEFormDetailBase.getMDPSDEFormName();
            xmlNode.setAttribute(FIELD_MDPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEGridId() != null) {
            object = pSDEFormDetailBase.getMDPSDEGridId();
            xmlNode.setAttribute(FIELD_MDPSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEGridName() != null) {
            object = pSDEFormDetailBase.getMDPSDEGridName();
            xmlNode.setAttribute(FIELD_MDPSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEListId() != null) {
            object = pSDEFormDetailBase.getMDPSDEListId();
            xmlNode.setAttribute(FIELD_MDPSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSDEListName() != null) {
            object = pSDEFormDetailBase.getMDPSDEListName();
            xmlNode.setAttribute(FIELD_MDPSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSSysViewPanelId() != null) {
            object = pSDEFormDetailBase.getMDPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_MDPSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMDPSSysViewPanelName() != null) {
            object = pSDEFormDetailBase.getMDPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_MDPSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMemo() != null) {
            object = pSDEFormDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getMobFlag() != null) {
            object = pSDEFormDetailBase.getMobFlag();
            xmlNode.setAttribute(FIELD_MOBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getModelState() != null) {
            object = pSDEFormDetailBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getNeedCodeListConfig() != null) {
            object = pSDEFormDetailBase.getNeedCodeListConfig();
            xmlNode.setAttribute(FIELD_NEEDCODELISTCONFIG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getNoPrivDM() != null) {
            object = pSDEFormDetailBase.getNoPrivDM();
            xmlNode.setAttribute(FIELD_NOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getOpenPSDEViewId() != null) {
            object = pSDEFormDetailBase.getOpenPSDEViewId();
            xmlNode.setAttribute(FIELD_OPENPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getOpenPSDEViewName() != null) {
            object = pSDEFormDetailBase.getOpenPSDEViewName();
            xmlNode.setAttribute(FIELD_OPENPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getOpenPSSysPDTViewId() != null) {
            object = pSDEFormDetailBase.getOpenPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_OPENPSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getOpenPSSysPDTViewName() != null) {
            object = pSDEFormDetailBase.getOpenPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_OPENPSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getOrderValue() != null) {
            object = pSDEFormDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getPadding() != null) {
            object = pSDEFormDetailBase.getPadding();
            xmlNode.setAttribute(FIELD_PADDING, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPHPSLanResId() != null) {
            object = pSDEFormDetailBase.getPHPSLanResId();
            xmlNode.setAttribute(FIELD_PHPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPHPSLanResName() != null) {
            object = pSDEFormDetailBase.getPHPSLanResName();
            xmlNode.setAttribute(FIELD_PHPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPickupPSDEViewId() != null) {
            object = pSDEFormDetailBase.getPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPickupPSDEViewName() != null) {
            object = pSDEFormDetailBase.getPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_PICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPlaceHolder() != null) {
            object = pSDEFormDetailBase.getPlaceHolder();
            xmlNode.setAttribute(FIELD_PLACEHOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPLayoutMode() != null) {
            object = pSDEFormDetailBase.getPLayoutMode();
            xmlNode.setAttribute(FIELD_PLAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPPSDEFormDetailId() != null) {
            object = pSDEFormDetailBase.getPPSDEFormDetailId();
            xmlNode.setAttribute(FIELD_PPSDEFORMDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPPSDEFormDetailName() != null) {
            object = pSDEFormDetailBase.getPPSDEFormDetailName();
            xmlNode.setAttribute(FIELD_PPSDEFORMDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPredefinedType() != null) {
            object = pSDEFormDetailBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPredefinedTypeText() != null) {
            object = pSDEFormDetailBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPreventXSS() != null) {
            object = pSDEFormDetailBase.getPreventXSS();
            xmlNode.setAttribute(FIELD_PREVENTXSS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getPreviewHtml() != null) {
            object = pSDEFormDetailBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSCodeListId() != null) {
            object = pSDEFormDetailBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSCodeListName() != null) {
            object = pSDEFormDetailBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRId() != null) {
            object = pSDEFormDetailBase.getPSDEDRId();
            xmlNode.setAttribute(FIELD_PSDEDRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRItemId() != null) {
            object = pSDEFormDetailBase.getPSDEDRItemId();
            xmlNode.setAttribute(FIELD_PSDEDRITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRItemName() != null) {
            object = pSDEFormDetailBase.getPSDEDRItemName();
            xmlNode.setAttribute(FIELD_PSDEDRITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEDRName() != null) {
            object = pSDEFormDetailBase.getPSDEDRName();
            xmlNode.setAttribute(FIELD_PSDEDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFUIModeId() != null) {
            object = pSDEFormDetailBase.getPSDEFUIModeId();
            xmlNode.setAttribute("PSDEFUIMODEID", object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFUIModeName() != null) {
            object = pSDEFormDetailBase.getPSDEFUIModeName();
            xmlNode.setAttribute("PSDEFUIMODENAME", object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFId() != null) {
            object = pSDEFormDetailBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFIUpdateId() != null) {
            object = pSDEFormDetailBase.getPSDEFIUpdateId();
            xmlNode.setAttribute(FIELD_PSDEFIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFIUpdateName() != null) {
            object = pSDEFormDetailBase.getPSDEFIUpdateName();
            xmlNode.setAttribute(FIELD_PSDEFIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFName() != null) {
            object = pSDEFormDetailBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormDetailId() != null) {
            object = pSDEFormDetailBase.getPSDEFormDetailId();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormDetailName() != null) {
            object = pSDEFormDetailBase.getPSDEFormDetailName();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormId() != null) {
            object = pSDEFormDetailBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormName() != null) {
            object = pSDEFormDetailBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormRFId() != null) {
            object = pSDEFormDetailBase.getPSDEFormRFId();
            xmlNode.setAttribute(FIELD_PSDEFORMRFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFormRFName() != null) {
            object = pSDEFormDetailBase.getPSDEFormRFName();
            xmlNode.setAttribute(FIELD_PSDEFORMRFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFSFItemId() != null) {
            object = pSDEFormDetailBase.getPSDEFSFItemId();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEFSFItemName() != null) {
            object = pSDEFormDetailBase.getPSDEFSFItemName();
            xmlNode.setAttribute(FIELD_PSDEFSFITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEId() != null) {
            object = pSDEFormDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDELogicId() != null) {
            object = pSDEFormDetailBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDELogicName() != null) {
            object = pSDEFormDetailBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEUAGroupId() != null) {
            object = pSDEFormDetailBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEUAGroupName() != null) {
            object = pSDEFormDetailBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEUIActionId() != null) {
            object = pSDEFormDetailBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDEUIActionName() != null) {
            object = pSDEFormDetailBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSDynaInstId() != null) {
            object = pSDEFormDetailBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysCounterId() != null) {
            object = pSDEFormDetailBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysCounterName() != null) {
            object = pSDEFormDetailBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysCssId() != null) {
            object = pSDEFormDetailBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysCssName() != null) {
            object = pSDEFormDetailBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysDictCatId() != null) {
            object = pSDEFormDetailBase.getPSSysDictCatId();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysDictCatName() != null) {
            object = pSDEFormDetailBase.getPSSysDictCatName();
            xmlNode.setAttribute(FIELD_PSSYSDICTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysDynaModelId() != null) {
            object = pSDEFormDetailBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysDynaModelName() != null) {
            object = pSDEFormDetailBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysEditorStyleId() != null) {
            object = pSDEFormDetailBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysEditorStyleName() != null) {
            object = pSDEFormDetailBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysImageId() != null) {
            object = pSDEFormDetailBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysImageName() != null) {
            object = pSDEFormDetailBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysResourceId() != null) {
            object = pSDEFormDetailBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getPSSysResourceName() != null) {
            object = pSDEFormDetailBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRawContent() != null) {
            object = pSDEFormDetailBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRawCssStyle() != null) {
            object = pSDEFormDetailBase.getRawCssStyle();
            xmlNode.setAttribute(FIELD_RAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRawServiceMethod() != null) {
            object = pSDEFormDetailBase.getRawServiceMethod();
            xmlNode.setAttribute(FIELD_RAWSERVICEMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRawServiceUrl() != null) {
            object = pSDEFormDetailBase.getRawServiceUrl();
            xmlNode.setAttribute(FIELD_RAWSERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEACModeId() != null) {
            object = pSDEFormDetailBase.getRefPSDEACModeId();
            xmlNode.setAttribute(FIELD_REFPSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEACModeName() != null) {
            object = pSDEFormDetailBase.getRefPSDEACModeName();
            xmlNode.setAttribute(FIELD_REFPSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEDataSetId() != null) {
            object = pSDEFormDetailBase.getRefPSDEDataSetId();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEDataSetName() != null) {
            object = pSDEFormDetailBase.getRefPSDEDataSetName();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEFormDetailId() != null) {
            object = pSDEFormDetailBase.getRefPSDEFormDetailId();
            xmlNode.setAttribute(FIELD_REFPSDEFORMDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEFormDetailName() != null) {
            object = pSDEFormDetailBase.getRefPSDEFormDetailName();
            xmlNode.setAttribute(FIELD_REFPSDEFORMDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEFormId() != null) {
            object = pSDEFormDetailBase.getRefPSDEFormId();
            xmlNode.setAttribute(FIELD_REFPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEId() != null) {
            object = pSDEFormDetailBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDEName() != null) {
            object = pSDEFormDetailBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDERId() != null) {
            object = pSDEFormDetailBase.getRefPSDERId();
            xmlNode.setAttribute(FIELD_REFPSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRefPSDERName() != null) {
            object = pSDEFormDetailBase.getRefPSDERName();
            xmlNode.setAttribute(FIELD_REFPSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRenderMode() != null) {
            object = pSDEFormDetailBase.getRenderMode();
            xmlNode.setAttribute(FIELD_RENDERMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRenderModeText() != null) {
            object = pSDEFormDetailBase.getRenderModeText();
            xmlNode.setAttribute(FIELD_RENDERMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getResetItemName() != null) {
            object = pSDEFormDetailBase.getResetItemName();
            xmlNode.setAttribute(FIELD_RESETITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getRowSpan() != null) {
            object = pSDEFormDetailBase.getRowSpan();
            xmlNode.setAttribute(FIELD_ROWSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getShowCaption() != null) {
            object = pSDEFormDetailBase.getShowCaption();
            xmlNode.setAttribute(FIELD_SHOWCAPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getShowMoreMode() != null) {
            object = pSDEFormDetailBase.getShowMoreMode();
            xmlNode.setAttribute(FIELD_SHOWMOREMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getSpacingBottom() != null) {
            object = pSDEFormDetailBase.getSpacingBottom();
            xmlNode.setAttribute(FIELD_SPACINGBOTTOM, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getSpacingLeft() != null) {
            object = pSDEFormDetailBase.getSpacingLeft();
            xmlNode.setAttribute(FIELD_SPACINGLEFT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getSpacingRight() != null) {
            object = pSDEFormDetailBase.getSpacingRight();
            xmlNode.setAttribute(FIELD_SPACINGRIGHT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getSpacingTop() != null) {
            object = pSDEFormDetailBase.getSpacingTop();
            xmlNode.setAttribute(FIELD_SPACINGTOP, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getSwapMode() != null) {
            object = pSDEFormDetailBase.getSwapMode();
            xmlNode.setAttribute(FIELD_SWAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getTemplateMode() != null) {
            object = pSDEFormDetailBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getTipPSLanResId() != null) {
            object = pSDEFormDetailBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getTipPSLanResName() != null) {
            object = pSDEFormDetailBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getTitleBarCloseMode() != null) {
            object = pSDEFormDetailBase.getTitleBarCloseMode();
            xmlNode.setAttribute(FIELD_TITLEBARCLOSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getToggleMode() != null) {
            object = pSDEFormDetailBase.getToggleMode();
            xmlNode.setAttribute(FIELD_TOGGLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getTooltipInfo() != null) {
            object = pSDEFormDetailBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getUCPSSysPFPluginId() != null) {
            object = pSDEFormDetailBase.getUCPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_UCPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getUCPSSysPFPluginName() != null) {
            object = pSDEFormDetailBase.getUCPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_UCPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getUpdateDate() != null) {
            object = pSDEFormDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getUpdateDV() != null) {
            object = pSDEFormDetailBase.getUpdateDV();
            xmlNode.setAttribute(FIELD_UPDATEDV, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getUpdateDVT() != null) {
            object = pSDEFormDetailBase.getUpdateDVT();
            xmlNode.setAttribute(FIELD_UPDATEDVT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getUpdateMan() != null) {
            object = pSDEFormDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getUserTag() != null) {
            object = pSDEFormDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getUserTag2() != null) {
            object = pSDEFormDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getVAlign() != null) {
            object = pSDEFormDetailBase.getVAlign();
            xmlNode.setAttribute(FIELD_VALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getVAlignSelf() != null) {
            object = pSDEFormDetailBase.getVAlignSelf();
            xmlNode.setAttribute(FIELD_VALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getValueFormat() != null) {
            object = pSDEFormDetailBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getValueItemName() != null) {
            object = pSDEFormDetailBase.getValueItemName();
            xmlNode.setAttribute(FIELD_VALUEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getVisibleLogic() != null) {
            object = pSDEFormDetailBase.getVisibleLogic();
            xmlNode.setAttribute(FIELD_VISIBLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEFormDetailBase.getWBDEFMode() != null) {
            object = pSDEFormDetailBase.getWBDEFMode();
            xmlNode.setAttribute(FIELD_WBDEFMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getWidth() != null) {
            object = pSDEFormDetailBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFormDetailBase.getWidthMode() != null) {
            object = pSDEFormDetailBase.getWidthMode();
            xmlNode.setAttribute(FIELD_WIDTHMODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFormDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFormDetailBase pSDEFormDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFormDetailBase.isAllowEmptyDirty() && (bl || pSDEFormDetailBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEFormDetailBase.getAllowEmpty());
        }
        if (pSDEFormDetailBase.isBlankLogicDirty() && (bl || pSDEFormDetailBase.getBlankLogic() != null)) {
            iDataObject.set(FIELD_BLANKLOGIC, (Object)pSDEFormDetailBase.getBlankLogic());
        }
        if (pSDEFormDetailBase.isBL_PosDirty() && (bl || pSDEFormDetailBase.getBL_Pos() != null)) {
            iDataObject.set(FIELD_BL_POS, (Object)pSDEFormDetailBase.getBL_Pos());
        }
        if (pSDEFormDetailBase.isBorderStyleDirty() && (bl || pSDEFormDetailBase.getBorderStyle() != null)) {
            iDataObject.set(FIELD_BORDERSTYLE, (Object)pSDEFormDetailBase.getBorderStyle());
        }
        if (pSDEFormDetailBase.isBtnActionTypeDirty() && (bl || pSDEFormDetailBase.getBtnActionType() != null)) {
            iDataObject.set(FIELD_BTNACTIONTYPE, (Object)pSDEFormDetailBase.getBtnActionType());
        }
        if (pSDEFormDetailBase.isBuildInActionDirty() && (bl || pSDEFormDetailBase.getBuildInAction() != null)) {
            iDataObject.set(FIELD_BUILDINACTION, (Object)pSDEFormDetailBase.getBuildInAction());
        }
        if (pSDEFormDetailBase.isCapPSLanResIdDirty() && (bl || pSDEFormDetailBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEFormDetailBase.getCapPSLanResId());
        }
        if (pSDEFormDetailBase.isCapPSLanResNameDirty() && (bl || pSDEFormDetailBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEFormDetailBase.getCapPSLanResName());
        }
        if (pSDEFormDetailBase.isCaptionDirty() && (bl || pSDEFormDetailBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEFormDetailBase.getCaption());
        }
        if (pSDEFormDetailBase.isChild_Col_LGDirty() && (bl || pSDEFormDetailBase.getChild_Col_LG() != null)) {
            iDataObject.set(FIELD_CHILD_COL_LG, (Object)pSDEFormDetailBase.getChild_Col_LG());
        }
        if (pSDEFormDetailBase.isChild_Col_MDDirty() && (bl || pSDEFormDetailBase.getChild_Col_MD() != null)) {
            iDataObject.set(FIELD_CHILD_COL_MD, (Object)pSDEFormDetailBase.getChild_Col_MD());
        }
        if (pSDEFormDetailBase.isChild_Col_SMDirty() && (bl || pSDEFormDetailBase.getChild_Col_SM() != null)) {
            iDataObject.set(FIELD_CHILD_COL_SM, (Object)pSDEFormDetailBase.getChild_Col_SM());
        }
        if (pSDEFormDetailBase.isChild_Col_XSDirty() && (bl || pSDEFormDetailBase.getChild_Col_XS() != null)) {
            iDataObject.set(FIELD_CHILD_COL_XS, (Object)pSDEFormDetailBase.getChild_Col_XS());
        }
        if (pSDEFormDetailBase.isCodeListConfigModeDirty() && (bl || pSDEFormDetailBase.getCodeListConfigMode() != null)) {
            iDataObject.set(FIELD_CODELISTCONFIGMODE, (Object)pSDEFormDetailBase.getCodeListConfigMode());
        }
        if (pSDEFormDetailBase.isColAlignDirty() && (bl || pSDEFormDetailBase.getColAlign() != null)) {
            iDataObject.set(FIELD_COLALIGN, (Object)pSDEFormDetailBase.getColAlign());
        }
        if (pSDEFormDetailBase.isColIdDirty() && (bl || pSDEFormDetailBase.getColId() != null)) {
            iDataObject.set(FIELD_COLID, (Object)pSDEFormDetailBase.getColId());
        }
        if (pSDEFormDetailBase.isColModelDirty() && (bl || pSDEFormDetailBase.getColModel() != null)) {
            iDataObject.set(FIELD_COLMODEL, (Object)pSDEFormDetailBase.getColModel());
        }
        if (pSDEFormDetailBase.isColSpanDirty() && (bl || pSDEFormDetailBase.getColSpan() != null)) {
            iDataObject.set(FIELD_COLSPAN, (Object)pSDEFormDetailBase.getColSpan());
        }
        if (pSDEFormDetailBase.isCol_LGDirty() && (bl || pSDEFormDetailBase.getCol_LG() != null)) {
            iDataObject.set(FIELD_COL_LG, (Object)pSDEFormDetailBase.getCol_LG());
        }
        if (pSDEFormDetailBase.isCol_LG_OSDirty() && (bl || pSDEFormDetailBase.getCol_LG_OS() != null)) {
            iDataObject.set(FIELD_COL_LG_OS, (Object)pSDEFormDetailBase.getCol_LG_OS());
        }
        if (pSDEFormDetailBase.isCol_MDDirty() && (bl || pSDEFormDetailBase.getCol_MD() != null)) {
            iDataObject.set(FIELD_COL_MD, (Object)pSDEFormDetailBase.getCol_MD());
        }
        if (pSDEFormDetailBase.isCol_MD_OSDirty() && (bl || pSDEFormDetailBase.getCol_MD_OS() != null)) {
            iDataObject.set(FIELD_COL_MD_OS, (Object)pSDEFormDetailBase.getCol_MD_OS());
        }
        if (pSDEFormDetailBase.isCol_SMDirty() && (bl || pSDEFormDetailBase.getCol_SM() != null)) {
            iDataObject.set(FIELD_COL_SM, (Object)pSDEFormDetailBase.getCol_SM());
        }
        if (pSDEFormDetailBase.isCol_SM_OSDirty() && (bl || pSDEFormDetailBase.getCol_SM_OS() != null)) {
            iDataObject.set(FIELD_COL_SM_OS, (Object)pSDEFormDetailBase.getCol_SM_OS());
        }
        if (pSDEFormDetailBase.isCol_WidthDirty() && (bl || pSDEFormDetailBase.getCol_Width() != null)) {
            iDataObject.set(FIELD_COL_WIDTH, (Object)pSDEFormDetailBase.getCol_Width());
        }
        if (pSDEFormDetailBase.isCol_XSDirty() && (bl || pSDEFormDetailBase.getCol_XS() != null)) {
            iDataObject.set(FIELD_COL_XS, (Object)pSDEFormDetailBase.getCol_XS());
        }
        if (pSDEFormDetailBase.isCol_XS_OSDirty() && (bl || pSDEFormDetailBase.getCol_XS_OS() != null)) {
            iDataObject.set(FIELD_COL_XS_OS, (Object)pSDEFormDetailBase.getCol_XS_OS());
        }
        if (pSDEFormDetailBase.isContentTypeDirty() && (bl || pSDEFormDetailBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSDEFormDetailBase.getContentType());
        }
        if (pSDEFormDetailBase.isConvertCITextDirty() && (bl || pSDEFormDetailBase.getConvertCIText() != null)) {
            iDataObject.set(FIELD_CONVERTCITEXT, (Object)pSDEFormDetailBase.getConvertCIText());
        }
        if (pSDEFormDetailBase.isCounterIdDirty() && (bl || pSDEFormDetailBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSDEFormDetailBase.getCounterId());
        }
        if (pSDEFormDetailBase.isCounterModeDirty() && (bl || pSDEFormDetailBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSDEFormDetailBase.getCounterMode());
        }
        if (pSDEFormDetailBase.isCreateDateDirty() && (bl || pSDEFormDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFormDetailBase.getCreateDate());
        }
        if (pSDEFormDetailBase.isCreateDVDirty() && (bl || pSDEFormDetailBase.getCreateDV() != null)) {
            iDataObject.set(FIELD_CREATEDV, (Object)pSDEFormDetailBase.getCreateDV());
        }
        if (pSDEFormDetailBase.isCreateDVTDirty() && (bl || pSDEFormDetailBase.getCreateDVT() != null)) {
            iDataObject.set(FIELD_CREATEDVT, (Object)pSDEFormDetailBase.getCreateDVT());
        }
        if (pSDEFormDetailBase.isCreateManDirty() && (bl || pSDEFormDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFormDetailBase.getCreateMan());
        }
        if (pSDEFormDetailBase.isCssIdDirty() && (bl || pSDEFormDetailBase.getCssId() != null)) {
            iDataObject.set(FIELD_CSSID, (Object)pSDEFormDetailBase.getCssId());
        }
        if (pSDEFormDetailBase.isCtrlColSpanDirty() && (bl || pSDEFormDetailBase.getCtrlColSpan() != null)) {
            iDataObject.set(FIELD_CTRLCOLSPAN, (Object)pSDEFormDetailBase.getCtrlColSpan());
        }
        if (pSDEFormDetailBase.isCtrlDynaClassDirty() && (bl || pSDEFormDetailBase.getCtrlDynaClass() != null)) {
            iDataObject.set(FIELD_CTRLDYNACLASS, (Object)pSDEFormDetailBase.getCtrlDynaClass());
        }
        if (pSDEFormDetailBase.isCtrlHeightDirty() && (bl || pSDEFormDetailBase.getCtrlHeight() != null)) {
            iDataObject.set(FIELD_CTRLHEIGHT, (Object)pSDEFormDetailBase.getCtrlHeight());
        }
        if (pSDEFormDetailBase.isCtrlPSSysCssIdDirty() && (bl || pSDEFormDetailBase.getCtrlPSSysCssId() != null)) {
            iDataObject.set(FIELD_CTRLPSSYSCSSID, (Object)pSDEFormDetailBase.getCtrlPSSysCssId());
        }
        if (pSDEFormDetailBase.isCtrlPSSysCssNameDirty() && (bl || pSDEFormDetailBase.getCtrlPSSysCssName() != null)) {
            iDataObject.set(FIELD_CTRLPSSYSCSSNAME, (Object)pSDEFormDetailBase.getCtrlPSSysCssName());
        }
        if (pSDEFormDetailBase.isCtrlRawCssStyleDirty() && (bl || pSDEFormDetailBase.getCtrlRawCssStyle() != null)) {
            iDataObject.set(FIELD_CTRLRAWCSSSTYLE, (Object)pSDEFormDetailBase.getCtrlRawCssStyle());
        }
        if (pSDEFormDetailBase.isCtrlWidthDirty() && (bl || pSDEFormDetailBase.getCtrlWidth() != null)) {
            iDataObject.set(FIELD_CTRLWIDTH, (Object)pSDEFormDetailBase.getCtrlWidth());
        }
        if (pSDEFormDetailBase.isCustomCodeDirty() && (bl || pSDEFormDetailBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEFormDetailBase.getCustomCode());
        }
        if (pSDEFormDetailBase.isDataDirty() && (bl || pSDEFormDetailBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSDEFormDetailBase.getData());
        }
        if (pSDEFormDetailBase.isDefaultFlagDirty() && (bl || pSDEFormDetailBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEFormDetailBase.getDefaultFlag());
        }
        if (pSDEFormDetailBase.isDetailStyleDirty() && (bl || pSDEFormDetailBase.getDetailStyle() != null)) {
            iDataObject.set(FIELD_DETAILSTYLE, (Object)pSDEFormDetailBase.getDetailStyle());
        }
        if (pSDEFormDetailBase.isDetailStyleTextDirty() && (bl || pSDEFormDetailBase.getDetailStyleText() != null)) {
            iDataObject.set(FIELD_DETAILSTYLETEXT, (Object)pSDEFormDetailBase.getDetailStyleText());
        }
        if (pSDEFormDetailBase.isDetailTagDirty() && (bl || pSDEFormDetailBase.getDetailTag() != null)) {
            iDataObject.set(FIELD_DETAILTAG, (Object)pSDEFormDetailBase.getDetailTag());
        }
        if (pSDEFormDetailBase.isDetailTag2Dirty() && (bl || pSDEFormDetailBase.getDetailTag2() != null)) {
            iDataObject.set(FIELD_DETAILTAG2, (Object)pSDEFormDetailBase.getDetailTag2());
        }
        if (pSDEFormDetailBase.isDetailTypeDirty() && (bl || pSDEFormDetailBase.getDetailType() != null)) {
            iDataObject.set(FIELD_DETAILTYPE, (Object)pSDEFormDetailBase.getDetailType());
        }
        if (pSDEFormDetailBase.isDynaClassDirty() && (bl || pSDEFormDetailBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSDEFormDetailBase.getDynaClass());
        }
        if (pSDEFormDetailBase.isDynaModelFlagDirty() && (bl || pSDEFormDetailBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFormDetailBase.getDynaModelFlag());
        }
        if (pSDEFormDetailBase.isEditorParamsDirty() && (bl || pSDEFormDetailBase.getEditorParams() != null)) {
            iDataObject.set(FIELD_EDITORPARAMS, (Object)pSDEFormDetailBase.getEditorParams());
        }
        if (pSDEFormDetailBase.isEditorTypeDirty() && (bl || pSDEFormDetailBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSDEFormDetailBase.getEditorType());
        }
        if (pSDEFormDetailBase.isEditorTypeNameDirty() && (bl || pSDEFormDetailBase.getEditorTypeName() != null)) {
            iDataObject.set(FIELD_EDITORTYPENAME, (Object)pSDEFormDetailBase.getEditorTypeName());
        }
        if (pSDEFormDetailBase.isEmptyCaptionDirty() && (bl || pSDEFormDetailBase.getEmptyCaption() != null)) {
            iDataObject.set(FIELD_EMPTYCAPTION, (Object)pSDEFormDetailBase.getEmptyCaption());
        }
        if (pSDEFormDetailBase.isEnableAnchorDirty() && (bl || pSDEFormDetailBase.getEnableAnchor() != null)) {
            iDataObject.set(FIELD_ENABLEANCHOR, (Object)pSDEFormDetailBase.getEnableAnchor());
        }
        if (pSDEFormDetailBase.isEnableCondDirty() && (bl || pSDEFormDetailBase.getEnableCond() != null)) {
            iDataObject.set(FIELD_ENABLECOND, (Object)pSDEFormDetailBase.getEnableCond());
        }
        if (pSDEFormDetailBase.isEnableInputTipDirty() && (bl || pSDEFormDetailBase.getEnableInputTip() != null)) {
            iDataObject.set(FIELD_ENABLEINPUTTIP, (Object)pSDEFormDetailBase.getEnableInputTip());
        }
        if (pSDEFormDetailBase.isEnableItemPrivDirty() && (bl || pSDEFormDetailBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEFormDetailBase.getEnableItemPriv());
        }
        if (pSDEFormDetailBase.isEnableLogicDirty() && (bl || pSDEFormDetailBase.getEnableLogic() != null)) {
            iDataObject.set(FIELD_ENABLELOGIC, (Object)pSDEFormDetailBase.getEnableLogic());
        }
        if (pSDEFormDetailBase.isFieldNameDirty() && (bl || pSDEFormDetailBase.getFieldName() != null)) {
            iDataObject.set(FIELD_FIELDNAME, (Object)pSDEFormDetailBase.getFieldName());
        }
        if (pSDEFormDetailBase.isFlexAlignDirty() && (bl || pSDEFormDetailBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSDEFormDetailBase.getFlexAlign());
        }
        if (pSDEFormDetailBase.isFlexBasisDirty() && (bl || pSDEFormDetailBase.getFlexBasis() != null)) {
            iDataObject.set(FIELD_FLEXBASIS, (Object)pSDEFormDetailBase.getFlexBasis());
        }
        if (pSDEFormDetailBase.isFlexDirDirty() && (bl || pSDEFormDetailBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSDEFormDetailBase.getFlexDir());
        }
        if (pSDEFormDetailBase.isFlexGrowDirty() && (bl || pSDEFormDetailBase.getFlexGrow() != null)) {
            iDataObject.set(FIELD_FLEXGROW, (Object)pSDEFormDetailBase.getFlexGrow());
        }
        if (pSDEFormDetailBase.isFlexShrinkDirty() && (bl || pSDEFormDetailBase.getFlexShrink() != null)) {
            iDataObject.set(FIELD_FLEXSHRINK, (Object)pSDEFormDetailBase.getFlexShrink());
        }
        if (pSDEFormDetailBase.isFlexVAlignDirty() && (bl || pSDEFormDetailBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSDEFormDetailBase.getFlexVAlign());
        }
        if (pSDEFormDetailBase.isFormTypeDirty() && (bl || pSDEFormDetailBase.getFormType() != null)) {
            iDataObject.set(FIELD_FORMTYPE, (Object)pSDEFormDetailBase.getFormType());
        }
        if (pSDEFormDetailBase.isGridRowIdDirty() && (bl || pSDEFormDetailBase.getGridRowId() != null)) {
            iDataObject.set(FIELD_GRIDROWID, (Object)pSDEFormDetailBase.getGridRowId());
        }
        if (pSDEFormDetailBase.isHAlignDirty() && (bl || pSDEFormDetailBase.getHAlign() != null)) {
            iDataObject.set(FIELD_HALIGN, (Object)pSDEFormDetailBase.getHAlign());
        }
        if (pSDEFormDetailBase.isHAlignSelfDirty() && (bl || pSDEFormDetailBase.getHAlignSelf() != null)) {
            iDataObject.set(FIELD_HALIGNSELF, (Object)pSDEFormDetailBase.getHAlignSelf());
        }
        if (pSDEFormDetailBase.isHeightDirty() && (bl || pSDEFormDetailBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSDEFormDetailBase.getHeight());
        }
        if (pSDEFormDetailBase.isHeightModeDirty() && (bl || pSDEFormDetailBase.getHeightMode() != null)) {
            iDataObject.set(FIELD_HEIGHTMODE, (Object)pSDEFormDetailBase.getHeightMode());
        }
        if (pSDEFormDetailBase.isHtmlContentDirty() && (bl || pSDEFormDetailBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSDEFormDetailBase.getHtmlContent());
        }
        if (pSDEFormDetailBase.isHtmlPageUrlDirty() && (bl || pSDEFormDetailBase.getHtmlPageUrl() != null)) {
            iDataObject.set(FIELD_HTMLPAGEURL, (Object)pSDEFormDetailBase.getHtmlPageUrl());
        }
        if (pSDEFormDetailBase.isIconAlignDirty() && (bl || pSDEFormDetailBase.getIconAlign() != null)) {
            iDataObject.set(FIELD_ICONALIGN, (Object)pSDEFormDetailBase.getIconAlign());
        }
        if (pSDEFormDetailBase.isIgnoreInputDirty() && (bl || pSDEFormDetailBase.getIgnoreInput() != null)) {
            iDataObject.set(FIELD_IGNOREINPUT, (Object)pSDEFormDetailBase.getIgnoreInput());
        }
        if (pSDEFormDetailBase.isInsertPosDirty() && (bl || pSDEFormDetailBase.getInsertPos() != null)) {
            iDataObject.set(FIELD_INSERTPOS, (Object)pSDEFormDetailBase.getInsertPos());
        }
        if (pSDEFormDetailBase.isItemPSACHandlerIdDirty() && (bl || pSDEFormDetailBase.getItemPSACHandlerId() != null)) {
            iDataObject.set(FIELD_ITEMPSACHANDLERID, (Object)pSDEFormDetailBase.getItemPSACHandlerId());
        }
        if (pSDEFormDetailBase.isItemPSACHandlerNameDirty() && (bl || pSDEFormDetailBase.getItemPSACHandlerName() != null)) {
            iDataObject.set(FIELD_ITEMPSACHANDLERNAME, (Object)pSDEFormDetailBase.getItemPSACHandlerName());
        }
        if (pSDEFormDetailBase.isItemStatesDirty() && (bl || pSDEFormDetailBase.getItemStates() != null)) {
            iDataObject.set(FIELD_ITEMSTATES, (Object)pSDEFormDetailBase.getItemStates());
        }
        if (pSDEFormDetailBase.isLabelColSpanDirty() && (bl || pSDEFormDetailBase.getLabelColSpan() != null)) {
            iDataObject.set(FIELD_LABELCOLSPAN, (Object)pSDEFormDetailBase.getLabelColSpan());
        }
        if (pSDEFormDetailBase.isLabelColSpan2Dirty() && (bl || pSDEFormDetailBase.getLabelColSpan2() != null)) {
            iDataObject.set(FIELD_LABELCOLSPAN2, (Object)pSDEFormDetailBase.getLabelColSpan2());
        }
        if (pSDEFormDetailBase.isLabelCssIdDirty() && (bl || pSDEFormDetailBase.getLabelCssId() != null)) {
            iDataObject.set(FIELD_LABELCSSID, (Object)pSDEFormDetailBase.getLabelCssId());
        }
        if (pSDEFormDetailBase.isLabelDynaClassDirty() && (bl || pSDEFormDetailBase.getLabelDynaClass() != null)) {
            iDataObject.set(FIELD_LABELDYNACLASS, (Object)pSDEFormDetailBase.getLabelDynaClass());
        }
        if (pSDEFormDetailBase.isLabelPosDirty() && (bl || pSDEFormDetailBase.getLabelPos() != null)) {
            iDataObject.set(FIELD_LABELPOS, (Object)pSDEFormDetailBase.getLabelPos());
        }
        if (pSDEFormDetailBase.isLabelPSSysCssIdDirty() && (bl || pSDEFormDetailBase.getLabelPSSysCssId() != null)) {
            iDataObject.set(FIELD_LABELPSSYSCSSID, (Object)pSDEFormDetailBase.getLabelPSSysCssId());
        }
        if (pSDEFormDetailBase.isLabelPSSysCssNameDirty() && (bl || pSDEFormDetailBase.getLabelPSSysCssName() != null)) {
            iDataObject.set(FIELD_LABELPSSYSCSSNAME, (Object)pSDEFormDetailBase.getLabelPSSysCssName());
        }
        if (pSDEFormDetailBase.isLabelRawCssStyleDirty() && (bl || pSDEFormDetailBase.getLabelRawCssStyle() != null)) {
            iDataObject.set(FIELD_LABELRAWCSSSTYLE, (Object)pSDEFormDetailBase.getLabelRawCssStyle());
        }
        if (pSDEFormDetailBase.isLabelWidthDirty() && (bl || pSDEFormDetailBase.getLabelWidth() != null)) {
            iDataObject.set(FIELD_LABELWIDTH, (Object)pSDEFormDetailBase.getLabelWidth());
        }
        if (pSDEFormDetailBase.isLayoutModeDirty() && (bl || pSDEFormDetailBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSDEFormDetailBase.getLayoutMode());
        }
        if (pSDEFormDetailBase.isLevelTagDirty() && (bl || pSDEFormDetailBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSDEFormDetailBase.getLevelTag());
        }
        if (pSDEFormDetailBase.isLevelValueDirty() && (bl || pSDEFormDetailBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSDEFormDetailBase.getLevelValue());
        }
        if (pSDEFormDetailBase.isLinkPSDEViewIdDirty() && (bl || pSDEFormDetailBase.getLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWID, (Object)pSDEFormDetailBase.getLinkPSDEViewId());
        }
        if (pSDEFormDetailBase.isLinkPSDEViewNameDirty() && (bl || pSDEFormDetailBase.getLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_LINKPSDEVIEWNAME, (Object)pSDEFormDetailBase.getLinkPSDEViewName());
        }
        if (pSDEFormDetailBase.isLogicNameDirty() && (bl || pSDEFormDetailBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEFormDetailBase.getLogicName());
        }
        if (pSDEFormDetailBase.isMarginDirty() && (bl || pSDEFormDetailBase.getMargin() != null)) {
            iDataObject.set(FIELD_MARGIN, (Object)pSDEFormDetailBase.getMargin());
        }
        if (pSDEFormDetailBase.isMaskInfoDirty() && (bl || pSDEFormDetailBase.getMaskInfo() != null)) {
            iDataObject.set(FIELD_MASKINFO, (Object)pSDEFormDetailBase.getMaskInfo());
        }
        if (pSDEFormDetailBase.isMaskModeDirty() && (bl || pSDEFormDetailBase.getMaskMode() != null)) {
            iDataObject.set(FIELD_MASKMODE, (Object)pSDEFormDetailBase.getMaskMode());
        }
        if (pSDEFormDetailBase.isMaskPSLanResIdDirty() && (bl || pSDEFormDetailBase.getMaskPSLanResId() != null)) {
            iDataObject.set(FIELD_MASKPSLANRESID, (Object)pSDEFormDetailBase.getMaskPSLanResId());
        }
        if (pSDEFormDetailBase.isMaskPSLanResNameDirty() && (bl || pSDEFormDetailBase.getMaskPSLanResName() != null)) {
            iDataObject.set(FIELD_MASKPSLANRESNAME, (Object)pSDEFormDetailBase.getMaskPSLanResName());
        }
        if (pSDEFormDetailBase.isMDCtrlTypeDirty() && (bl || pSDEFormDetailBase.getMDCtrlType() != null)) {
            iDataObject.set(FIELD_MDCTRLTYPE, (Object)pSDEFormDetailBase.getMDCtrlType());
        }
        if (pSDEFormDetailBase.isMDPSDEDataViewIdDirty() && (bl || pSDEFormDetailBase.getMDPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_MDPSDEDATAVIEWID, (Object)pSDEFormDetailBase.getMDPSDEDataViewId());
        }
        if (pSDEFormDetailBase.isMDPSDEDataViewNameDirty() && (bl || pSDEFormDetailBase.getMDPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_MDPSDEDATAVIEWNAME, (Object)pSDEFormDetailBase.getMDPSDEDataViewName());
        }
        if (pSDEFormDetailBase.isMDPSDEFormIdDirty() && (bl || pSDEFormDetailBase.getMDPSDEFormId() != null)) {
            iDataObject.set(FIELD_MDPSDEFORMID, (Object)pSDEFormDetailBase.getMDPSDEFormId());
        }
        if (pSDEFormDetailBase.isMDPSDEFormNameDirty() && (bl || pSDEFormDetailBase.getMDPSDEFormName() != null)) {
            iDataObject.set(FIELD_MDPSDEFORMNAME, (Object)pSDEFormDetailBase.getMDPSDEFormName());
        }
        if (pSDEFormDetailBase.isMDPSDEGridIdDirty() && (bl || pSDEFormDetailBase.getMDPSDEGridId() != null)) {
            iDataObject.set(FIELD_MDPSDEGRIDID, (Object)pSDEFormDetailBase.getMDPSDEGridId());
        }
        if (pSDEFormDetailBase.isMDPSDEGridNameDirty() && (bl || pSDEFormDetailBase.getMDPSDEGridName() != null)) {
            iDataObject.set(FIELD_MDPSDEGRIDNAME, (Object)pSDEFormDetailBase.getMDPSDEGridName());
        }
        if (pSDEFormDetailBase.isMDPSDEListIdDirty() && (bl || pSDEFormDetailBase.getMDPSDEListId() != null)) {
            iDataObject.set(FIELD_MDPSDELISTID, (Object)pSDEFormDetailBase.getMDPSDEListId());
        }
        if (pSDEFormDetailBase.isMDPSDEListNameDirty() && (bl || pSDEFormDetailBase.getMDPSDEListName() != null)) {
            iDataObject.set(FIELD_MDPSDELISTNAME, (Object)pSDEFormDetailBase.getMDPSDEListName());
        }
        if (pSDEFormDetailBase.isMDPSSysViewPanelIdDirty() && (bl || pSDEFormDetailBase.getMDPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_MDPSSYSVIEWPANELID, (Object)pSDEFormDetailBase.getMDPSSysViewPanelId());
        }
        if (pSDEFormDetailBase.isMDPSSysViewPanelNameDirty() && (bl || pSDEFormDetailBase.getMDPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_MDPSSYSVIEWPANELNAME, (Object)pSDEFormDetailBase.getMDPSSysViewPanelName());
        }
        if (pSDEFormDetailBase.isMemoDirty() && (bl || pSDEFormDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFormDetailBase.getMemo());
        }
        if (pSDEFormDetailBase.isMobFlagDirty() && (bl || pSDEFormDetailBase.getMobFlag() != null)) {
            iDataObject.set(FIELD_MOBFLAG, (Object)pSDEFormDetailBase.getMobFlag());
        }
        if (pSDEFormDetailBase.isModelStateDirty() && (bl || pSDEFormDetailBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEFormDetailBase.getModelState());
        }
        if (pSDEFormDetailBase.isNeedCodeListConfigDirty() && (bl || pSDEFormDetailBase.getNeedCodeListConfig() != null)) {
            iDataObject.set(FIELD_NEEDCODELISTCONFIG, (Object)pSDEFormDetailBase.getNeedCodeListConfig());
        }
        if (pSDEFormDetailBase.isNoPrivDMDirty() && (bl || pSDEFormDetailBase.getNoPrivDM() != null)) {
            iDataObject.set(FIELD_NOPRIVDM, (Object)pSDEFormDetailBase.getNoPrivDM());
        }
        if (pSDEFormDetailBase.isOpenPSDEViewIdDirty() && (bl || pSDEFormDetailBase.getOpenPSDEViewId() != null)) {
            iDataObject.set(FIELD_OPENPSDEVIEWID, (Object)pSDEFormDetailBase.getOpenPSDEViewId());
        }
        if (pSDEFormDetailBase.isOpenPSDEViewNameDirty() && (bl || pSDEFormDetailBase.getOpenPSDEViewName() != null)) {
            iDataObject.set(FIELD_OPENPSDEVIEWNAME, (Object)pSDEFormDetailBase.getOpenPSDEViewName());
        }
        if (pSDEFormDetailBase.isOpenPSSysPDTViewIdDirty() && (bl || pSDEFormDetailBase.getOpenPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_OPENPSSYSPDTVIEWID, (Object)pSDEFormDetailBase.getOpenPSSysPDTViewId());
        }
        if (pSDEFormDetailBase.isOpenPSSysPDTViewNameDirty() && (bl || pSDEFormDetailBase.getOpenPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_OPENPSSYSPDTVIEWNAME, (Object)pSDEFormDetailBase.getOpenPSSysPDTViewName());
        }
        if (pSDEFormDetailBase.isOrderValueDirty() && (bl || pSDEFormDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFormDetailBase.getOrderValue());
        }
        if (pSDEFormDetailBase.isPaddingDirty() && (bl || pSDEFormDetailBase.getPadding() != null)) {
            iDataObject.set(FIELD_PADDING, (Object)pSDEFormDetailBase.getPadding());
        }
        if (pSDEFormDetailBase.isPHPSLanResIdDirty() && (bl || pSDEFormDetailBase.getPHPSLanResId() != null)) {
            iDataObject.set(FIELD_PHPSLANRESID, (Object)pSDEFormDetailBase.getPHPSLanResId());
        }
        if (pSDEFormDetailBase.isPHPSLanResNameDirty() && (bl || pSDEFormDetailBase.getPHPSLanResName() != null)) {
            iDataObject.set(FIELD_PHPSLANRESNAME, (Object)pSDEFormDetailBase.getPHPSLanResName());
        }
        if (pSDEFormDetailBase.isPickupPSDEViewIdDirty() && (bl || pSDEFormDetailBase.getPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWID, (Object)pSDEFormDetailBase.getPickupPSDEViewId());
        }
        if (pSDEFormDetailBase.isPickupPSDEViewNameDirty() && (bl || pSDEFormDetailBase.getPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_PICKUPPSDEVIEWNAME, (Object)pSDEFormDetailBase.getPickupPSDEViewName());
        }
        if (pSDEFormDetailBase.isPlaceHolderDirty() && (bl || pSDEFormDetailBase.getPlaceHolder() != null)) {
            iDataObject.set(FIELD_PLACEHOLDER, (Object)pSDEFormDetailBase.getPlaceHolder());
        }
        if (pSDEFormDetailBase.isPLayoutModeDirty() && (bl || pSDEFormDetailBase.getPLayoutMode() != null)) {
            iDataObject.set(FIELD_PLAYOUTMODE, (Object)pSDEFormDetailBase.getPLayoutMode());
        }
        if (pSDEFormDetailBase.isPPSDEFormDetailIdDirty() && (bl || pSDEFormDetailBase.getPPSDEFormDetailId() != null)) {
            iDataObject.set(FIELD_PPSDEFORMDETAILID, (Object)pSDEFormDetailBase.getPPSDEFormDetailId());
        }
        if (pSDEFormDetailBase.isPPSDEFormDetailNameDirty() && (bl || pSDEFormDetailBase.getPPSDEFormDetailName() != null)) {
            iDataObject.set(FIELD_PPSDEFORMDETAILNAME, (Object)pSDEFormDetailBase.getPPSDEFormDetailName());
        }
        if (pSDEFormDetailBase.isPredefinedTypeDirty() && (bl || pSDEFormDetailBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDEFormDetailBase.getPredefinedType());
        }
        if (pSDEFormDetailBase.isPredefinedTypeTextDirty() && (bl || pSDEFormDetailBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSDEFormDetailBase.getPredefinedTypeText());
        }
        if (pSDEFormDetailBase.isPreventXSSDirty() && (bl || pSDEFormDetailBase.getPreventXSS() != null)) {
            iDataObject.set(FIELD_PREVENTXSS, (Object)pSDEFormDetailBase.getPreventXSS());
        }
        if (pSDEFormDetailBase.isPreviewHtmlDirty() && (bl || pSDEFormDetailBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSDEFormDetailBase.getPreviewHtml());
        }
        if (pSDEFormDetailBase.isPSCodeListIdDirty() && (bl || pSDEFormDetailBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEFormDetailBase.getPSCodeListId());
        }
        if (pSDEFormDetailBase.isPSCodeListNameDirty() && (bl || pSDEFormDetailBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEFormDetailBase.getPSCodeListName());
        }
        if (pSDEFormDetailBase.isPSDEDRIdDirty() && (bl || pSDEFormDetailBase.getPSDEDRId() != null)) {
            iDataObject.set(FIELD_PSDEDRID, (Object)pSDEFormDetailBase.getPSDEDRId());
        }
        if (pSDEFormDetailBase.isPSDEDRItemIdDirty() && (bl || pSDEFormDetailBase.getPSDEDRItemId() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMID, (Object)pSDEFormDetailBase.getPSDEDRItemId());
        }
        if (pSDEFormDetailBase.isPSDEDRItemNameDirty() && (bl || pSDEFormDetailBase.getPSDEDRItemName() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMNAME, (Object)pSDEFormDetailBase.getPSDEDRItemName());
        }
        if (pSDEFormDetailBase.isPSDEDRNameDirty() && (bl || pSDEFormDetailBase.getPSDEDRName() != null)) {
            iDataObject.set(FIELD_PSDEDRNAME, (Object)pSDEFormDetailBase.getPSDEDRName());
        }
        if (pSDEFormDetailBase.isPSDEFUIModeIdDirty() && (bl || pSDEFormDetailBase.getPSDEFUIModeId() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODEID, (Object)pSDEFormDetailBase.getPSDEFUIModeId());
        }
        if (pSDEFormDetailBase.isPSDEFUIModeNameDirty() && (bl || pSDEFormDetailBase.getPSDEFUIModeName() != null)) {
            iDataObject.set(FIELD_PSDEFUIMODENAME, (Object)pSDEFormDetailBase.getPSDEFUIModeName());
        }
        if (pSDEFormDetailBase.isPSDEFIdDirty() && (bl || pSDEFormDetailBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFormDetailBase.getPSDEFId());
        }
        if (pSDEFormDetailBase.isPSDEFIUpdateIdDirty() && (bl || pSDEFormDetailBase.getPSDEFIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDEFIUPDATEID, (Object)pSDEFormDetailBase.getPSDEFIUpdateId());
        }
        if (pSDEFormDetailBase.isPSDEFIUpdateNameDirty() && (bl || pSDEFormDetailBase.getPSDEFIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDEFIUPDATENAME, (Object)pSDEFormDetailBase.getPSDEFIUpdateName());
        }
        if (pSDEFormDetailBase.isPSDEFNameDirty() && (bl || pSDEFormDetailBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFormDetailBase.getPSDEFName());
        }
        if (pSDEFormDetailBase.isPSDEFormDetailIdDirty() && (bl || pSDEFormDetailBase.getPSDEFormDetailId() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILID, (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        }
        if (pSDEFormDetailBase.isPSDEFormDetailNameDirty() && (bl || pSDEFormDetailBase.getPSDEFormDetailName() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILNAME, (Object)pSDEFormDetailBase.getPSDEFormDetailName());
        }
        if (pSDEFormDetailBase.isPSDEFormIdDirty() && (bl || pSDEFormDetailBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFormDetailBase.getPSDEFormId());
        }
        if (pSDEFormDetailBase.isPSDEFormNameDirty() && (bl || pSDEFormDetailBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFormDetailBase.getPSDEFormName());
        }
        if (pSDEFormDetailBase.isPSDEFormRFIdDirty() && (bl || pSDEFormDetailBase.getPSDEFormRFId() != null)) {
            iDataObject.set(FIELD_PSDEFORMRFID, (Object)pSDEFormDetailBase.getPSDEFormRFId());
        }
        if (pSDEFormDetailBase.isPSDEFormRFNameDirty() && (bl || pSDEFormDetailBase.getPSDEFormRFName() != null)) {
            iDataObject.set(FIELD_PSDEFORMRFNAME, (Object)pSDEFormDetailBase.getPSDEFormRFName());
        }
        if (pSDEFormDetailBase.isPSDEFSFItemIdDirty() && (bl || pSDEFormDetailBase.getPSDEFSFItemId() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMID, (Object)pSDEFormDetailBase.getPSDEFSFItemId());
        }
        if (pSDEFormDetailBase.isPSDEFSFItemNameDirty() && (bl || pSDEFormDetailBase.getPSDEFSFItemName() != null)) {
            iDataObject.set(FIELD_PSDEFSFITEMNAME, (Object)pSDEFormDetailBase.getPSDEFSFItemName());
        }
        if (pSDEFormDetailBase.isPSDEIdDirty() && (bl || pSDEFormDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFormDetailBase.getPSDEId());
        }
        if (pSDEFormDetailBase.isPSDELogicIdDirty() && (bl || pSDEFormDetailBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDEFormDetailBase.getPSDELogicId());
        }
        if (pSDEFormDetailBase.isPSDELogicNameDirty() && (bl || pSDEFormDetailBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDEFormDetailBase.getPSDELogicName());
        }
        if (pSDEFormDetailBase.isPSDEUAGroupIdDirty() && (bl || pSDEFormDetailBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEFormDetailBase.getPSDEUAGroupId());
        }
        if (pSDEFormDetailBase.isPSDEUAGroupNameDirty() && (bl || pSDEFormDetailBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEFormDetailBase.getPSDEUAGroupName());
        }
        if (pSDEFormDetailBase.isPSDEUIActionIdDirty() && (bl || pSDEFormDetailBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEFormDetailBase.getPSDEUIActionId());
        }
        if (pSDEFormDetailBase.isPSDEUIActionNameDirty() && (bl || pSDEFormDetailBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEFormDetailBase.getPSDEUIActionName());
        }
        if (pSDEFormDetailBase.isPSDynaInstIdDirty() && (bl || pSDEFormDetailBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFormDetailBase.getPSDynaInstId());
        }
        if (pSDEFormDetailBase.isPSSysCounterIdDirty() && (bl || pSDEFormDetailBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSDEFormDetailBase.getPSSysCounterId());
        }
        if (pSDEFormDetailBase.isPSSysCounterNameDirty() && (bl || pSDEFormDetailBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSDEFormDetailBase.getPSSysCounterName());
        }
        if (pSDEFormDetailBase.isPSSysCssIdDirty() && (bl || pSDEFormDetailBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEFormDetailBase.getPSSysCssId());
        }
        if (pSDEFormDetailBase.isPSSysCssNameDirty() && (bl || pSDEFormDetailBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEFormDetailBase.getPSSysCssName());
        }
        if (pSDEFormDetailBase.isPSSysDictCatIdDirty() && (bl || pSDEFormDetailBase.getPSSysDictCatId() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATID, (Object)pSDEFormDetailBase.getPSSysDictCatId());
        }
        if (pSDEFormDetailBase.isPSSysDictCatNameDirty() && (bl || pSDEFormDetailBase.getPSSysDictCatName() != null)) {
            iDataObject.set(FIELD_PSSYSDICTCATNAME, (Object)pSDEFormDetailBase.getPSSysDictCatName());
        }
        if (pSDEFormDetailBase.isPSSysDynaModelIdDirty() && (bl || pSDEFormDetailBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEFormDetailBase.getPSSysDynaModelId());
        }
        if (pSDEFormDetailBase.isPSSysDynaModelNameDirty() && (bl || pSDEFormDetailBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEFormDetailBase.getPSSysDynaModelName());
        }
        if (pSDEFormDetailBase.isPSSysEditorStyleIdDirty() && (bl || pSDEFormDetailBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSDEFormDetailBase.getPSSysEditorStyleId());
        }
        if (pSDEFormDetailBase.isPSSysEditorStyleNameDirty() && (bl || pSDEFormDetailBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSDEFormDetailBase.getPSSysEditorStyleName());
        }
        if (pSDEFormDetailBase.isPSSysImageIdDirty() && (bl || pSDEFormDetailBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEFormDetailBase.getPSSysImageId());
        }
        if (pSDEFormDetailBase.isPSSysImageNameDirty() && (bl || pSDEFormDetailBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEFormDetailBase.getPSSysImageName());
        }
        if (pSDEFormDetailBase.isPSSysResourceIdDirty() && (bl || pSDEFormDetailBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSDEFormDetailBase.getPSSysResourceId());
        }
        if (pSDEFormDetailBase.isPSSysResourceNameDirty() && (bl || pSDEFormDetailBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSDEFormDetailBase.getPSSysResourceName());
        }
        if (pSDEFormDetailBase.isRawContentDirty() && (bl || pSDEFormDetailBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSDEFormDetailBase.getRawContent());
        }
        if (pSDEFormDetailBase.isRawCssStyleDirty() && (bl || pSDEFormDetailBase.getRawCssStyle() != null)) {
            iDataObject.set(FIELD_RAWCSSSTYLE, (Object)pSDEFormDetailBase.getRawCssStyle());
        }
        if (pSDEFormDetailBase.isRawServiceMethodDirty() && (bl || pSDEFormDetailBase.getRawServiceMethod() != null)) {
            iDataObject.set(FIELD_RAWSERVICEMETHOD, (Object)pSDEFormDetailBase.getRawServiceMethod());
        }
        if (pSDEFormDetailBase.isRawServiceUrlDirty() && (bl || pSDEFormDetailBase.getRawServiceUrl() != null)) {
            iDataObject.set(FIELD_RAWSERVICEURL, (Object)pSDEFormDetailBase.getRawServiceUrl());
        }
        if (pSDEFormDetailBase.isRefPSDEACModeIdDirty() && (bl || pSDEFormDetailBase.getRefPSDEACModeId() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODEID, (Object)pSDEFormDetailBase.getRefPSDEACModeId());
        }
        if (pSDEFormDetailBase.isRefPSDEACModeNameDirty() && (bl || pSDEFormDetailBase.getRefPSDEACModeName() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODENAME, (Object)pSDEFormDetailBase.getRefPSDEACModeName());
        }
        if (pSDEFormDetailBase.isRefPSDEDataSetIdDirty() && (bl || pSDEFormDetailBase.getRefPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETID, (Object)pSDEFormDetailBase.getRefPSDEDataSetId());
        }
        if (pSDEFormDetailBase.isRefPSDEDataSetNameDirty() && (bl || pSDEFormDetailBase.getRefPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETNAME, (Object)pSDEFormDetailBase.getRefPSDEDataSetName());
        }
        if (pSDEFormDetailBase.isRefPSDEFormDetailIdDirty() && (bl || pSDEFormDetailBase.getRefPSDEFormDetailId() != null)) {
            iDataObject.set(FIELD_REFPSDEFORMDETAILID, (Object)pSDEFormDetailBase.getRefPSDEFormDetailId());
        }
        if (pSDEFormDetailBase.isRefPSDEFormDetailNameDirty() && (bl || pSDEFormDetailBase.getRefPSDEFormDetailName() != null)) {
            iDataObject.set(FIELD_REFPSDEFORMDETAILNAME, (Object)pSDEFormDetailBase.getRefPSDEFormDetailName());
        }
        if (pSDEFormDetailBase.isRefPSDEFormIdDirty() && (bl || pSDEFormDetailBase.getRefPSDEFormId() != null)) {
            iDataObject.set(FIELD_REFPSDEFORMID, (Object)pSDEFormDetailBase.getRefPSDEFormId());
        }
        if (pSDEFormDetailBase.isRefPSDEIdDirty() && (bl || pSDEFormDetailBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSDEFormDetailBase.getRefPSDEId());
        }
        if (pSDEFormDetailBase.isRefPSDENameDirty() && (bl || pSDEFormDetailBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSDEFormDetailBase.getRefPSDEName());
        }
        if (pSDEFormDetailBase.isRefPSDERIdDirty() && (bl || pSDEFormDetailBase.getRefPSDERId() != null)) {
            iDataObject.set(FIELD_REFPSDERID, (Object)pSDEFormDetailBase.getRefPSDERId());
        }
        if (pSDEFormDetailBase.isRefPSDERNameDirty() && (bl || pSDEFormDetailBase.getRefPSDERName() != null)) {
            iDataObject.set(FIELD_REFPSDERNAME, (Object)pSDEFormDetailBase.getRefPSDERName());
        }
        if (pSDEFormDetailBase.isRenderModeDirty() && (bl || pSDEFormDetailBase.getRenderMode() != null)) {
            iDataObject.set(FIELD_RENDERMODE, (Object)pSDEFormDetailBase.getRenderMode());
        }
        if (pSDEFormDetailBase.isRenderModeTextDirty() && (bl || pSDEFormDetailBase.getRenderModeText() != null)) {
            iDataObject.set(FIELD_RENDERMODETEXT, (Object)pSDEFormDetailBase.getRenderModeText());
        }
        if (pSDEFormDetailBase.isResetItemNameDirty() && (bl || pSDEFormDetailBase.getResetItemName() != null)) {
            iDataObject.set(FIELD_RESETITEMNAME, (Object)pSDEFormDetailBase.getResetItemName());
        }
        if (pSDEFormDetailBase.isRowSpanDirty() && (bl || pSDEFormDetailBase.getRowSpan() != null)) {
            iDataObject.set(FIELD_ROWSPAN, (Object)pSDEFormDetailBase.getRowSpan());
        }
        if (pSDEFormDetailBase.isShowCaptionDirty() && (bl || pSDEFormDetailBase.getShowCaption() != null)) {
            iDataObject.set(FIELD_SHOWCAPTION, (Object)pSDEFormDetailBase.getShowCaption());
        }
        if (pSDEFormDetailBase.isShowMoreModeDirty() && (bl || pSDEFormDetailBase.getShowMoreMode() != null)) {
            iDataObject.set(FIELD_SHOWMOREMODE, (Object)pSDEFormDetailBase.getShowMoreMode());
        }
        if (pSDEFormDetailBase.isSpacingBottomDirty() && (bl || pSDEFormDetailBase.getSpacingBottom() != null)) {
            iDataObject.set(FIELD_SPACINGBOTTOM, (Object)pSDEFormDetailBase.getSpacingBottom());
        }
        if (pSDEFormDetailBase.isSpacingLeftDirty() && (bl || pSDEFormDetailBase.getSpacingLeft() != null)) {
            iDataObject.set(FIELD_SPACINGLEFT, (Object)pSDEFormDetailBase.getSpacingLeft());
        }
        if (pSDEFormDetailBase.isSpacingRightDirty() && (bl || pSDEFormDetailBase.getSpacingRight() != null)) {
            iDataObject.set(FIELD_SPACINGRIGHT, (Object)pSDEFormDetailBase.getSpacingRight());
        }
        if (pSDEFormDetailBase.isSpacingTopDirty() && (bl || pSDEFormDetailBase.getSpacingTop() != null)) {
            iDataObject.set(FIELD_SPACINGTOP, (Object)pSDEFormDetailBase.getSpacingTop());
        }
        if (pSDEFormDetailBase.isSwapModeDirty() && (bl || pSDEFormDetailBase.getSwapMode() != null)) {
            iDataObject.set(FIELD_SWAPMODE, (Object)pSDEFormDetailBase.getSwapMode());
        }
        if (pSDEFormDetailBase.isTemplateModeDirty() && (bl || pSDEFormDetailBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSDEFormDetailBase.getTemplateMode());
        }
        if (pSDEFormDetailBase.isTipPSLanResIdDirty() && (bl || pSDEFormDetailBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSDEFormDetailBase.getTipPSLanResId());
        }
        if (pSDEFormDetailBase.isTipPSLanResNameDirty() && (bl || pSDEFormDetailBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSDEFormDetailBase.getTipPSLanResName());
        }
        if (pSDEFormDetailBase.isTitleBarCloseModeDirty() && (bl || pSDEFormDetailBase.getTitleBarCloseMode() != null)) {
            iDataObject.set(FIELD_TITLEBARCLOSEMODE, (Object)pSDEFormDetailBase.getTitleBarCloseMode());
        }
        if (pSDEFormDetailBase.isToggleModeDirty() && (bl || pSDEFormDetailBase.getToggleMode() != null)) {
            iDataObject.set(FIELD_TOGGLEMODE, (Object)pSDEFormDetailBase.getToggleMode());
        }
        if (pSDEFormDetailBase.isTooltipInfoDirty() && (bl || pSDEFormDetailBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSDEFormDetailBase.getTooltipInfo());
        }
        if (pSDEFormDetailBase.isUCPSSysPFPluginIdDirty() && (bl || pSDEFormDetailBase.getUCPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_UCPSSYSPFPLUGINID, (Object)pSDEFormDetailBase.getUCPSSysPFPluginId());
        }
        if (pSDEFormDetailBase.isUCPSSysPFPluginNameDirty() && (bl || pSDEFormDetailBase.getUCPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_UCPSSYSPFPLUGINNAME, (Object)pSDEFormDetailBase.getUCPSSysPFPluginName());
        }
        if (pSDEFormDetailBase.isUpdateDateDirty() && (bl || pSDEFormDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFormDetailBase.getUpdateDate());
        }
        if (pSDEFormDetailBase.isUpdateDVDirty() && (bl || pSDEFormDetailBase.getUpdateDV() != null)) {
            iDataObject.set(FIELD_UPDATEDV, (Object)pSDEFormDetailBase.getUpdateDV());
        }
        if (pSDEFormDetailBase.isUpdateDVTDirty() && (bl || pSDEFormDetailBase.getUpdateDVT() != null)) {
            iDataObject.set(FIELD_UPDATEDVT, (Object)pSDEFormDetailBase.getUpdateDVT());
        }
        if (pSDEFormDetailBase.isUpdateManDirty() && (bl || pSDEFormDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFormDetailBase.getUpdateMan());
        }
        if (pSDEFormDetailBase.isUserTagDirty() && (bl || pSDEFormDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFormDetailBase.getUserTag());
        }
        if (pSDEFormDetailBase.isUserTag2Dirty() && (bl || pSDEFormDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFormDetailBase.getUserTag2());
        }
        if (pSDEFormDetailBase.isVAlignDirty() && (bl || pSDEFormDetailBase.getVAlign() != null)) {
            iDataObject.set(FIELD_VALIGN, (Object)pSDEFormDetailBase.getVAlign());
        }
        if (pSDEFormDetailBase.isVAlignSelfDirty() && (bl || pSDEFormDetailBase.getVAlignSelf() != null)) {
            iDataObject.set(FIELD_VALIGNSELF, (Object)pSDEFormDetailBase.getVAlignSelf());
        }
        if (pSDEFormDetailBase.isValueFormatDirty() && (bl || pSDEFormDetailBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDEFormDetailBase.getValueFormat());
        }
        if (pSDEFormDetailBase.isValueItemNameDirty() && (bl || pSDEFormDetailBase.getValueItemName() != null)) {
            iDataObject.set(FIELD_VALUEITEMNAME, (Object)pSDEFormDetailBase.getValueItemName());
        }
        if (pSDEFormDetailBase.isVisibleLogicDirty() && (bl || pSDEFormDetailBase.getVisibleLogic() != null)) {
            iDataObject.set(FIELD_VISIBLELOGIC, (Object)pSDEFormDetailBase.getVisibleLogic());
        }
        if (pSDEFormDetailBase.isWBDEFModeDirty() && (bl || pSDEFormDetailBase.getWBDEFMode() != null)) {
            iDataObject.set(FIELD_WBDEFMODE, (Object)pSDEFormDetailBase.getWBDEFMode());
        }
        if (pSDEFormDetailBase.isWidthDirty() && (bl || pSDEFormDetailBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEFormDetailBase.getWidth());
        }
        if (pSDEFormDetailBase.isWidthModeDirty() && (bl || pSDEFormDetailBase.getWidthMode() != null)) {
            iDataObject.set(FIELD_WIDTHMODE, (Object)pSDEFormDetailBase.getWidthMode());
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
        return PSDEFormDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEFormDetailBase pSDEFormDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFormDetailBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDEFormDetailBase.resetBlankLogic();
                return true;
            }
            case 2: {
                pSDEFormDetailBase.resetBL_Pos();
                return true;
            }
            case 3: {
                pSDEFormDetailBase.resetBorderStyle();
                return true;
            }
            case 4: {
                pSDEFormDetailBase.resetBtnActionType();
                return true;
            }
            case 5: {
                pSDEFormDetailBase.resetBuildInAction();
                return true;
            }
            case 6: {
                pSDEFormDetailBase.resetCapPSLanResId();
                return true;
            }
            case 7: {
                pSDEFormDetailBase.resetCapPSLanResName();
                return true;
            }
            case 8: {
                pSDEFormDetailBase.resetCaption();
                return true;
            }
            case 9: {
                pSDEFormDetailBase.resetChild_Col_LG();
                return true;
            }
            case 10: {
                pSDEFormDetailBase.resetChild_Col_MD();
                return true;
            }
            case 11: {
                pSDEFormDetailBase.resetChild_Col_SM();
                return true;
            }
            case 12: {
                pSDEFormDetailBase.resetChild_Col_XS();
                return true;
            }
            case 13: {
                pSDEFormDetailBase.resetCodeListConfigMode();
                return true;
            }
            case 14: {
                pSDEFormDetailBase.resetColAlign();
                return true;
            }
            case 15: {
                pSDEFormDetailBase.resetColId();
                return true;
            }
            case 16: {
                pSDEFormDetailBase.resetColModel();
                return true;
            }
            case 17: {
                pSDEFormDetailBase.resetColSpan();
                return true;
            }
            case 18: {
                pSDEFormDetailBase.resetCol_LG();
                return true;
            }
            case 19: {
                pSDEFormDetailBase.resetCol_LG_OS();
                return true;
            }
            case 20: {
                pSDEFormDetailBase.resetCol_MD();
                return true;
            }
            case 21: {
                pSDEFormDetailBase.resetCol_MD_OS();
                return true;
            }
            case 22: {
                pSDEFormDetailBase.resetCol_SM();
                return true;
            }
            case 23: {
                pSDEFormDetailBase.resetCol_SM_OS();
                return true;
            }
            case 24: {
                pSDEFormDetailBase.resetCol_Width();
                return true;
            }
            case 25: {
                pSDEFormDetailBase.resetCol_XS();
                return true;
            }
            case 26: {
                pSDEFormDetailBase.resetCol_XS_OS();
                return true;
            }
            case 27: {
                pSDEFormDetailBase.resetContentType();
                return true;
            }
            case 28: {
                pSDEFormDetailBase.resetConvertCIText();
                return true;
            }
            case 29: {
                pSDEFormDetailBase.resetCounterId();
                return true;
            }
            case 30: {
                pSDEFormDetailBase.resetCounterMode();
                return true;
            }
            case 31: {
                pSDEFormDetailBase.resetCreateDate();
                return true;
            }
            case 32: {
                pSDEFormDetailBase.resetCreateDV();
                return true;
            }
            case 33: {
                pSDEFormDetailBase.resetCreateDVT();
                return true;
            }
            case 34: {
                pSDEFormDetailBase.resetCreateMan();
                return true;
            }
            case 35: {
                pSDEFormDetailBase.resetCssId();
                return true;
            }
            case 36: {
                pSDEFormDetailBase.resetCtrlColSpan();
                return true;
            }
            case 37: {
                pSDEFormDetailBase.resetCtrlDynaClass();
                return true;
            }
            case 38: {
                pSDEFormDetailBase.resetCtrlHeight();
                return true;
            }
            case 39: {
                pSDEFormDetailBase.resetCtrlPSSysCssId();
                return true;
            }
            case 40: {
                pSDEFormDetailBase.resetCtrlPSSysCssName();
                return true;
            }
            case 41: {
                pSDEFormDetailBase.resetCtrlRawCssStyle();
                return true;
            }
            case 42: {
                pSDEFormDetailBase.resetCtrlWidth();
                return true;
            }
            case 43: {
                pSDEFormDetailBase.resetCustomCode();
                return true;
            }
            case 44: {
                pSDEFormDetailBase.resetData();
                return true;
            }
            case 45: {
                pSDEFormDetailBase.resetDefaultFlag();
                return true;
            }
            case 46: {
                pSDEFormDetailBase.resetDetailStyle();
                return true;
            }
            case 47: {
                pSDEFormDetailBase.resetDetailStyleText();
                return true;
            }
            case 48: {
                pSDEFormDetailBase.resetDetailTag();
                return true;
            }
            case 49: {
                pSDEFormDetailBase.resetDetailTag2();
                return true;
            }
            case 50: {
                pSDEFormDetailBase.resetDetailType();
                return true;
            }
            case 51: {
                pSDEFormDetailBase.resetDynaClass();
                return true;
            }
            case 52: {
                pSDEFormDetailBase.resetDynaModelFlag();
                return true;
            }
            case 53: {
                pSDEFormDetailBase.resetEditorParams();
                return true;
            }
            case 54: {
                pSDEFormDetailBase.resetEditorType();
                return true;
            }
            case 55: {
                pSDEFormDetailBase.resetEditorTypeName();
                return true;
            }
            case 56: {
                pSDEFormDetailBase.resetEmptyCaption();
                return true;
            }
            case 57: {
                pSDEFormDetailBase.resetEnableAnchor();
                return true;
            }
            case 58: {
                pSDEFormDetailBase.resetEnableCond();
                return true;
            }
            case 59: {
                pSDEFormDetailBase.resetEnableInputTip();
                return true;
            }
            case 60: {
                pSDEFormDetailBase.resetEnableItemPriv();
                return true;
            }
            case 61: {
                pSDEFormDetailBase.resetEnableLogic();
                return true;
            }
            case 62: {
                pSDEFormDetailBase.resetFieldName();
                return true;
            }
            case 63: {
                pSDEFormDetailBase.resetFlexAlign();
                return true;
            }
            case 64: {
                pSDEFormDetailBase.resetFlexBasis();
                return true;
            }
            case 65: {
                pSDEFormDetailBase.resetFlexDir();
                return true;
            }
            case 66: {
                pSDEFormDetailBase.resetFlexGrow();
                return true;
            }
            case 67: {
                pSDEFormDetailBase.resetFlexShrink();
                return true;
            }
            case 68: {
                pSDEFormDetailBase.resetFlexVAlign();
                return true;
            }
            case 69: {
                pSDEFormDetailBase.resetFormType();
                return true;
            }
            case 70: {
                pSDEFormDetailBase.resetGridRowId();
                return true;
            }
            case 71: {
                pSDEFormDetailBase.resetHAlign();
                return true;
            }
            case 72: {
                pSDEFormDetailBase.resetHAlignSelf();
                return true;
            }
            case 73: {
                pSDEFormDetailBase.resetHeight();
                return true;
            }
            case 74: {
                pSDEFormDetailBase.resetHeightMode();
                return true;
            }
            case 75: {
                pSDEFormDetailBase.resetHtmlContent();
                return true;
            }
            case 76: {
                pSDEFormDetailBase.resetHtmlPageUrl();
                return true;
            }
            case 77: {
                pSDEFormDetailBase.resetIconAlign();
                return true;
            }
            case 78: {
                pSDEFormDetailBase.resetIgnoreInput();
                return true;
            }
            case 79: {
                pSDEFormDetailBase.resetInsertPos();
                return true;
            }
            case 80: {
                pSDEFormDetailBase.resetItemPSACHandlerId();
                return true;
            }
            case 81: {
                pSDEFormDetailBase.resetItemPSACHandlerName();
                return true;
            }
            case 82: {
                pSDEFormDetailBase.resetItemStates();
                return true;
            }
            case 83: {
                pSDEFormDetailBase.resetLabelColSpan();
                return true;
            }
            case 84: {
                pSDEFormDetailBase.resetLabelColSpan2();
                return true;
            }
            case 85: {
                pSDEFormDetailBase.resetLabelCssId();
                return true;
            }
            case 86: {
                pSDEFormDetailBase.resetLabelDynaClass();
                return true;
            }
            case 87: {
                pSDEFormDetailBase.resetLabelPos();
                return true;
            }
            case 88: {
                pSDEFormDetailBase.resetLabelPSSysCssId();
                return true;
            }
            case 89: {
                pSDEFormDetailBase.resetLabelPSSysCssName();
                return true;
            }
            case 90: {
                pSDEFormDetailBase.resetLabelRawCssStyle();
                return true;
            }
            case 91: {
                pSDEFormDetailBase.resetLabelWidth();
                return true;
            }
            case 92: {
                pSDEFormDetailBase.resetLayoutMode();
                return true;
            }
            case 93: {
                pSDEFormDetailBase.resetLevelTag();
                return true;
            }
            case 94: {
                pSDEFormDetailBase.resetLevelValue();
                return true;
            }
            case 95: {
                pSDEFormDetailBase.resetLinkPSDEViewId();
                return true;
            }
            case 96: {
                pSDEFormDetailBase.resetLinkPSDEViewName();
                return true;
            }
            case 97: {
                pSDEFormDetailBase.resetLogicName();
                return true;
            }
            case 98: {
                pSDEFormDetailBase.resetMargin();
                return true;
            }
            case 99: {
                pSDEFormDetailBase.resetMaskInfo();
                return true;
            }
            case 100: {
                pSDEFormDetailBase.resetMaskMode();
                return true;
            }
            case 101: {
                pSDEFormDetailBase.resetMaskPSLanResId();
                return true;
            }
            case 102: {
                pSDEFormDetailBase.resetMaskPSLanResName();
                return true;
            }
            case 103: {
                pSDEFormDetailBase.resetMDCtrlType();
                return true;
            }
            case 104: {
                pSDEFormDetailBase.resetMDPSDEDataViewId();
                return true;
            }
            case 105: {
                pSDEFormDetailBase.resetMDPSDEDataViewName();
                return true;
            }
            case 106: {
                pSDEFormDetailBase.resetMDPSDEFormId();
                return true;
            }
            case 107: {
                pSDEFormDetailBase.resetMDPSDEFormName();
                return true;
            }
            case 108: {
                pSDEFormDetailBase.resetMDPSDEGridId();
                return true;
            }
            case 109: {
                pSDEFormDetailBase.resetMDPSDEGridName();
                return true;
            }
            case 110: {
                pSDEFormDetailBase.resetMDPSDEListId();
                return true;
            }
            case 111: {
                pSDEFormDetailBase.resetMDPSDEListName();
                return true;
            }
            case 112: {
                pSDEFormDetailBase.resetMDPSSysViewPanelId();
                return true;
            }
            case 113: {
                pSDEFormDetailBase.resetMDPSSysViewPanelName();
                return true;
            }
            case 114: {
                pSDEFormDetailBase.resetMemo();
                return true;
            }
            case 115: {
                pSDEFormDetailBase.resetMobFlag();
                return true;
            }
            case 116: {
                pSDEFormDetailBase.resetModelState();
                return true;
            }
            case 117: {
                pSDEFormDetailBase.resetNeedCodeListConfig();
                return true;
            }
            case 118: {
                pSDEFormDetailBase.resetNoPrivDM();
                return true;
            }
            case 119: {
                pSDEFormDetailBase.resetOpenPSDEViewId();
                return true;
            }
            case 120: {
                pSDEFormDetailBase.resetOpenPSDEViewName();
                return true;
            }
            case 121: {
                pSDEFormDetailBase.resetOpenPSSysPDTViewId();
                return true;
            }
            case 122: {
                pSDEFormDetailBase.resetOpenPSSysPDTViewName();
                return true;
            }
            case 123: {
                pSDEFormDetailBase.resetOrderValue();
                return true;
            }
            case 124: {
                pSDEFormDetailBase.resetPadding();
                return true;
            }
            case 125: {
                pSDEFormDetailBase.resetPHPSLanResId();
                return true;
            }
            case 126: {
                pSDEFormDetailBase.resetPHPSLanResName();
                return true;
            }
            case 127: {
                pSDEFormDetailBase.resetPickupPSDEViewId();
                return true;
            }
            case 128: {
                pSDEFormDetailBase.resetPickupPSDEViewName();
                return true;
            }
            case 129: {
                pSDEFormDetailBase.resetPlaceHolder();
                return true;
            }
            case 130: {
                pSDEFormDetailBase.resetPLayoutMode();
                return true;
            }
            case 131: {
                pSDEFormDetailBase.resetPPSDEFormDetailId();
                return true;
            }
            case 132: {
                pSDEFormDetailBase.resetPPSDEFormDetailName();
                return true;
            }
            case 133: {
                pSDEFormDetailBase.resetPredefinedType();
                return true;
            }
            case 134: {
                pSDEFormDetailBase.resetPredefinedTypeText();
                return true;
            }
            case 135: {
                pSDEFormDetailBase.resetPreventXSS();
                return true;
            }
            case 136: {
                pSDEFormDetailBase.resetPreviewHtml();
                return true;
            }
            case 137: {
                pSDEFormDetailBase.resetPSCodeListId();
                return true;
            }
            case 138: {
                pSDEFormDetailBase.resetPSCodeListName();
                return true;
            }
            case 139: {
                pSDEFormDetailBase.resetPSDEDRId();
                return true;
            }
            case 140: {
                pSDEFormDetailBase.resetPSDEDRItemId();
                return true;
            }
            case 141: {
                pSDEFormDetailBase.resetPSDEDRItemName();
                return true;
            }
            case 142: {
                pSDEFormDetailBase.resetPSDEDRName();
                return true;
            }
            case 143: {
                pSDEFormDetailBase.resetPSDEFUIModeId();
                return true;
            }
            case 144: {
                pSDEFormDetailBase.resetPSDEFUIModeName();
                return true;
            }
            case 145: {
                pSDEFormDetailBase.resetPSDEFId();
                return true;
            }
            case 146: {
                pSDEFormDetailBase.resetPSDEFIUpdateId();
                return true;
            }
            case 147: {
                pSDEFormDetailBase.resetPSDEFIUpdateName();
                return true;
            }
            case 148: {
                pSDEFormDetailBase.resetPSDEFName();
                return true;
            }
            case 149: {
                pSDEFormDetailBase.resetPSDEFormDetailId();
                return true;
            }
            case 150: {
                pSDEFormDetailBase.resetPSDEFormDetailName();
                return true;
            }
            case 151: {
                pSDEFormDetailBase.resetPSDEFormId();
                return true;
            }
            case 152: {
                pSDEFormDetailBase.resetPSDEFormName();
                return true;
            }
            case 153: {
                pSDEFormDetailBase.resetPSDEFormRFId();
                return true;
            }
            case 154: {
                pSDEFormDetailBase.resetPSDEFormRFName();
                return true;
            }
            case 155: {
                pSDEFormDetailBase.resetPSDEFSFItemId();
                return true;
            }
            case 156: {
                pSDEFormDetailBase.resetPSDEFSFItemName();
                return true;
            }
            case 157: {
                pSDEFormDetailBase.resetPSDEId();
                return true;
            }
            case 158: {
                pSDEFormDetailBase.resetPSDELogicId();
                return true;
            }
            case 159: {
                pSDEFormDetailBase.resetPSDELogicName();
                return true;
            }
            case 160: {
                pSDEFormDetailBase.resetPSDEUAGroupId();
                return true;
            }
            case 161: {
                pSDEFormDetailBase.resetPSDEUAGroupName();
                return true;
            }
            case 162: {
                pSDEFormDetailBase.resetPSDEUIActionId();
                return true;
            }
            case 163: {
                pSDEFormDetailBase.resetPSDEUIActionName();
                return true;
            }
            case 164: {
                pSDEFormDetailBase.resetPSDynaInstId();
                return true;
            }
            case 165: {
                pSDEFormDetailBase.resetPSSysCounterId();
                return true;
            }
            case 166: {
                pSDEFormDetailBase.resetPSSysCounterName();
                return true;
            }
            case 167: {
                pSDEFormDetailBase.resetPSSysCssId();
                return true;
            }
            case 168: {
                pSDEFormDetailBase.resetPSSysCssName();
                return true;
            }
            case 169: {
                pSDEFormDetailBase.resetPSSysDictCatId();
                return true;
            }
            case 170: {
                pSDEFormDetailBase.resetPSSysDictCatName();
                return true;
            }
            case 171: {
                pSDEFormDetailBase.resetPSSysDynaModelId();
                return true;
            }
            case 172: {
                pSDEFormDetailBase.resetPSSysDynaModelName();
                return true;
            }
            case 173: {
                pSDEFormDetailBase.resetPSSysEditorStyleId();
                return true;
            }
            case 174: {
                pSDEFormDetailBase.resetPSSysEditorStyleName();
                return true;
            }
            case 175: {
                pSDEFormDetailBase.resetPSSysImageId();
                return true;
            }
            case 176: {
                pSDEFormDetailBase.resetPSSysImageName();
                return true;
            }
            case 177: {
                pSDEFormDetailBase.resetPSSysResourceId();
                return true;
            }
            case 178: {
                pSDEFormDetailBase.resetPSSysResourceName();
                return true;
            }
            case 179: {
                pSDEFormDetailBase.resetRawContent();
                return true;
            }
            case 180: {
                pSDEFormDetailBase.resetRawCssStyle();
                return true;
            }
            case 181: {
                pSDEFormDetailBase.resetRawServiceMethod();
                return true;
            }
            case 182: {
                pSDEFormDetailBase.resetRawServiceUrl();
                return true;
            }
            case 183: {
                pSDEFormDetailBase.resetRefPSDEACModeId();
                return true;
            }
            case 184: {
                pSDEFormDetailBase.resetRefPSDEACModeName();
                return true;
            }
            case 185: {
                pSDEFormDetailBase.resetRefPSDEDataSetId();
                return true;
            }
            case 186: {
                pSDEFormDetailBase.resetRefPSDEDataSetName();
                return true;
            }
            case 187: {
                pSDEFormDetailBase.resetRefPSDEFormDetailId();
                return true;
            }
            case 188: {
                pSDEFormDetailBase.resetRefPSDEFormDetailName();
                return true;
            }
            case 189: {
                pSDEFormDetailBase.resetRefPSDEFormId();
                return true;
            }
            case 190: {
                pSDEFormDetailBase.resetRefPSDEId();
                return true;
            }
            case 191: {
                pSDEFormDetailBase.resetRefPSDEName();
                return true;
            }
            case 192: {
                pSDEFormDetailBase.resetRefPSDERId();
                return true;
            }
            case 193: {
                pSDEFormDetailBase.resetRefPSDERName();
                return true;
            }
            case 194: {
                pSDEFormDetailBase.resetRenderMode();
                return true;
            }
            case 195: {
                pSDEFormDetailBase.resetRenderModeText();
                return true;
            }
            case 196: {
                pSDEFormDetailBase.resetResetItemName();
                return true;
            }
            case 197: {
                pSDEFormDetailBase.resetRowSpan();
                return true;
            }
            case 198: {
                pSDEFormDetailBase.resetShowCaption();
                return true;
            }
            case 199: {
                pSDEFormDetailBase.resetShowMoreMode();
                return true;
            }
            case 200: {
                pSDEFormDetailBase.resetSpacingBottom();
                return true;
            }
            case 201: {
                pSDEFormDetailBase.resetSpacingLeft();
                return true;
            }
            case 202: {
                pSDEFormDetailBase.resetSpacingRight();
                return true;
            }
            case 203: {
                pSDEFormDetailBase.resetSpacingTop();
                return true;
            }
            case 204: {
                pSDEFormDetailBase.resetSwapMode();
                return true;
            }
            case 205: {
                pSDEFormDetailBase.resetTemplateMode();
                return true;
            }
            case 206: {
                pSDEFormDetailBase.resetTipPSLanResId();
                return true;
            }
            case 207: {
                pSDEFormDetailBase.resetTipPSLanResName();
                return true;
            }
            case 208: {
                pSDEFormDetailBase.resetTitleBarCloseMode();
                return true;
            }
            case 209: {
                pSDEFormDetailBase.resetToggleMode();
                return true;
            }
            case 210: {
                pSDEFormDetailBase.resetTooltipInfo();
                return true;
            }
            case 211: {
                pSDEFormDetailBase.resetUCPSSysPFPluginId();
                return true;
            }
            case 212: {
                pSDEFormDetailBase.resetUCPSSysPFPluginName();
                return true;
            }
            case 213: {
                pSDEFormDetailBase.resetUpdateDate();
                return true;
            }
            case 214: {
                pSDEFormDetailBase.resetUpdateDV();
                return true;
            }
            case 215: {
                pSDEFormDetailBase.resetUpdateDVT();
                return true;
            }
            case 216: {
                pSDEFormDetailBase.resetUpdateMan();
                return true;
            }
            case 217: {
                pSDEFormDetailBase.resetUserTag();
                return true;
            }
            case 218: {
                pSDEFormDetailBase.resetUserTag2();
                return true;
            }
            case 219: {
                pSDEFormDetailBase.resetVAlign();
                return true;
            }
            case 220: {
                pSDEFormDetailBase.resetVAlignSelf();
                return true;
            }
            case 221: {
                pSDEFormDetailBase.resetValueFormat();
                return true;
            }
            case 222: {
                pSDEFormDetailBase.resetValueItemName();
                return true;
            }
            case 223: {
                pSDEFormDetailBase.resetVisibleLogic();
                return true;
            }
            case 224: {
                pSDEFormDetailBase.resetWBDEFMode();
                return true;
            }
            case 225: {
                pSDEFormDetailBase.resetWidth();
                return true;
            }
            case 226: {
                pSDEFormDetailBase.resetWidthMode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getItemPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemPSACHandler();
        }
        if (this.getItemPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objItemPSACHandlerLock;
        synchronized (n) {
            if (this.itempsachandler != null && DataTypeHelper.compare((int)25, (Object)this.getItemPSACHandlerId(), (Object)this.itempsachandler.getPSACHandlerId()) != 0L) {
                this.itempsachandler = null;
            }
            if (this.itempsachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getItemPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet((IEntity)pSACHandler);
                this.itempsachandler = pSACHandler;
            }
            return this.itempsachandler;
        }
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
    public PSDEDataRelation getPSDEDR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDR();
        }
        if (this.getPSDEDRId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRLock;
        synchronized (n) {
            if (this.psdedr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRId(), (Object)this.psdedr.getPSDEDataRelationId()) != 0L) {
                this.psdedr = null;
            }
            if (this.psdedr == null) {
                PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
                pSDEDataRelation.setPSDEDataRelationId(this.getPSDEDRId());
                PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataRelationService.autoGet((IEntity)pSDEDataRelation);
                this.psdedr = pSDEDataRelation;
            }
            return this.psdedr;
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
    public PSDEDataView getMDPSDEDataView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEDataView();
        }
        if (this.getMDPSDEDataViewId() == null) {
            return null;
        }
        Integer n = this.objMDPSDEDataViewLock;
        synchronized (n) {
            if (this.mdpsdedataview != null && DataTypeHelper.compare((int)25, (Object)this.getMDPSDEDataViewId(), (Object)this.mdpsdedataview.getPSDEDataViewId()) != 0L) {
                this.mdpsdedataview = null;
            }
            if (this.mdpsdedataview == null) {
                PSDEDataView pSDEDataView = new PSDEDataView();
                pSDEDataView.setPSDEDataViewId(this.getMDPSDEDataViewId());
                PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataViewService.autoGet((IEntity)pSDEDataView);
                this.mdpsdedataview = pSDEDataView;
            }
            return this.mdpsdedataview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDRItem getPSDEDRItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDRItem();
        }
        if (this.getPSDEDRItemId() == null) {
            return null;
        }
        Integer n = this.objPSDEDRItemLock;
        synchronized (n) {
            if (this.psdedritem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDRItemId(), (Object)this.psdedritem.getPSDEDRItemId()) != 0L) {
                this.psdedritem = null;
            }
            if (this.psdedritem == null) {
                PSDEDRItem pSDEDRItem = new PSDEDRItem();
                pSDEDRItem.setPSDEDRItemId(this.getPSDEDRItemId());
                PSDEDRItemService pSDEDRItemService = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
                pSDEDRItemService.autoGet((IEntity)pSDEDRItem);
                this.psdedritem = pSDEDRItem;
            }
            return this.psdedritem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFUIMode getPSDEFUIMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFUIMode();
        }
        if (this.getPSDEFUIModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEFUIModeLock;
        synchronized (n) {
            if (this.psdefuimode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFUIModeId(), (Object)this.psdefuimode.getPSDEFUIModeId()) != 0L) {
                this.psdefuimode = null;
            }
            if (this.psdefuimode == null) {
                PSDEFUIMode pSDEFUIMode = new PSDEFUIMode();
                pSDEFUIMode.setPSDEFUIModeId(this.getPSDEFUIModeId());
                PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFUIModeService.autoGet((IEntity)pSDEFUIMode);
                this.psdefuimode = pSDEFUIMode;
            }
            return this.psdefuimode;
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
    public PSDEFIUpdate getPSDEFIUpdate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdate();
        }
        if (this.getPSDEFIUpdateId() == null) {
            return null;
        }
        Integer n = this.objPSDEFIUpdateLock;
        synchronized (n) {
            if (this.psdefiupdate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFIUpdateId(), (Object)this.psdefiupdate.getPSDEFIUpdateId()) != 0L) {
                this.psdefiupdate = null;
            }
            if (this.psdefiupdate == null) {
                PSDEFIUpdate pSDEFIUpdate = new PSDEFIUpdate();
                pSDEFIUpdate.setPSDEFIUpdateId(this.getPSDEFIUpdateId());
                PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
                pSDEFIUpdateService.autoGet((IEntity)pSDEFIUpdate);
                this.psdefiupdate = pSDEFIUpdate;
            }
            return this.psdefiupdate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFormDetail getPPSDEFormDetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFormDetail();
        }
        if (this.getPPSDEFormDetailId() == null) {
            return null;
        }
        Integer n = this.objPPSDEFormDetailLock;
        synchronized (n) {
            if (this.ppsdeformdetail != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDEFormDetailId(), (Object)this.ppsdeformdetail.getPSDEFormDetailId()) != 0L) {
                this.ppsdeformdetail = null;
            }
            if (this.ppsdeformdetail == null) {
                PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormDetailId(this.getPPSDEFormDetailId());
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormDetailService.autoGet((IEntity)pSDEFormDetail);
                this.ppsdeformdetail = pSDEFormDetail;
            }
            return this.ppsdeformdetail;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFormDetail getRefPSDEFormDetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEFormDetail();
        }
        if (this.getRefPSDEFormDetailId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEFormDetailLock;
        synchronized (n) {
            if (this.refpsdeformdetail != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEFormDetailId(), (Object)this.refpsdeformdetail.getPSDEFormDetailId()) != 0L) {
                this.refpsdeformdetail = null;
            }
            if (this.refpsdeformdetail == null) {
                PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormDetailId(this.getRefPSDEFormDetailId());
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormDetailService.autoGet((IEntity)pSDEFormDetail);
                this.refpsdeformdetail = pSDEFormDetail;
            }
            return this.refpsdeformdetail;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFormRF getPSDEFormRF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormRF();
        }
        if (this.getPSDEFormRFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormRFLock;
        synchronized (n) {
            if (this.psdeformrf != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormRFId(), (Object)this.psdeformrf.getPSDEFormRFId()) != 0L) {
                this.psdeformrf = null;
            }
            if (this.psdeformrf == null) {
                PSDEFormRF pSDEFormRF = new PSDEFormRF();
                pSDEFormRF.setPSDEFormRFId(this.getPSDEFormRFId());
                PSDEFormRFService pSDEFormRFService = (PSDEFormRFService)ServiceGlobal.getService(PSDEFormRFService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormRFService.autoGet((IEntity)pSDEFormRF);
                this.psdeformrf = pSDEFormRF;
            }
            return this.psdeformrf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMDPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEForm();
        }
        if (this.getMDPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMDPSDEFormLock;
        synchronized (n) {
            if (this.mdpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMDPSDEFormId(), (Object)this.mdpsdeform.getPSDEFormId()) != 0L) {
                this.mdpsdeform = null;
            }
            if (this.mdpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMDPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mdpsdeform = pSDEForm;
            }
            return this.mdpsdeform;
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
    public PSDEFSFItem getPSDEFSFItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFSFItem();
        }
        if (this.getPSDEFSFItemId() == null) {
            return null;
        }
        Integer n = this.objPSDEFSFItemLock;
        synchronized (n) {
            if (this.psdefsfitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFSFItemId(), (Object)this.psdefsfitem.getPSDEFSFItemId()) != 0L) {
                this.psdefsfitem = null;
            }
            if (this.psdefsfitem == null) {
                PSDEFSFItem pSDEFSFItem = new PSDEFSFItem();
                pSDEFSFItem.setPSDEFSFItemId(this.getPSDEFSFItemId());
                PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
                pSDEFSFItemService.autoGet((IEntity)pSDEFSFItem);
                this.psdefsfitem = pSDEFSFItem;
            }
            return this.psdefsfitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getMDPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEGrid();
        }
        if (this.getMDPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objMDPSDEGridLock;
        synchronized (n) {
            if (this.mdpsdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getMDPSDEGridId(), (Object)this.mdpsdegrid.getPSDEGridId()) != 0L) {
                this.mdpsdegrid = null;
            }
            if (this.mdpsdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getMDPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet((IEntity)pSDEGrid);
                this.mdpsdegrid = pSDEGrid;
            }
            return this.mdpsdegrid;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEList getMDPSDEList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSDEList();
        }
        if (this.getMDPSDEListId() == null) {
            return null;
        }
        Integer n = this.objMDPSDEListLock;
        synchronized (n) {
            if (this.mdpsdelist != null && DataTypeHelper.compare((int)25, (Object)this.getMDPSDEListId(), (Object)this.mdpsdelist.getPSDEListId()) != 0L) {
                this.mdpsdelist = null;
            }
            if (this.mdpsdelist == null) {
                PSDEList pSDEList = new PSDEList();
                pSDEList.setPSDEListId(this.getMDPSDEListId());
                PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
                pSDEListService.autoGet((IEntity)pSDEList);
                this.mdpsdelist = pSDEList;
            }
            return this.mdpsdelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
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
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUIActionLock;
        synchronized (n) {
            if (this.psdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuiaction.getPSDEUIActionId()) != 0L) {
                this.psdeuiaction = null;
            }
            if (this.psdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
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
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.linkpsdeview = pSDEViewBase;
            }
            return this.linkpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getOpenPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSDEView();
        }
        if (this.getOpenPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objOpenPSDEViewLock;
        synchronized (n) {
            if (this.openpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getOpenPSDEViewId(), (Object)this.openpsdeview.getPSDEViewBaseId()) != 0L) {
                this.openpsdeview = null;
            }
            if (this.openpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getOpenPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.openpsdeview = pSDEViewBase;
            }
            return this.openpsdeview;
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
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.pickuppsdeview = pSDEViewBase;
            }
            return this.pickuppsdeview;
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
    public PSLanguageRes getMaskPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaskPSLanRes();
        }
        if (this.getMaskPSLanResId() == null) {
            return null;
        }
        Integer n = this.objMaskPSLanResLock;
        synchronized (n) {
            if (this.maskpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getMaskPSLanResId(), (Object)this.maskpslanres.getPSLanguageResId()) != 0L) {
                this.maskpslanres = null;
            }
            if (this.maskpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getMaskPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.maskpslanres = pSLanguageRes;
            }
            return this.maskpslanres;
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
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet((IEntity)pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getCtrlPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPSSysCss();
        }
        if (this.getCtrlPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objCtrlPSSysCssLock;
        synchronized (n) {
            if (this.ctrlpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getCtrlPSSysCssId(), (Object)this.ctrlpssyscss.getPSSysCssId()) != 0L) {
                this.ctrlpssyscss = null;
            }
            if (this.ctrlpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getCtrlPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.ctrlpssyscss = pSSysCss;
            }
            return this.ctrlpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getLabelPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLabelPSSysCss();
        }
        if (this.getLabelPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objLabelPSSysCssLock;
        synchronized (n) {
            if (this.labelpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getLabelPSSysCssId(), (Object)this.labelpssyscss.getPSSysCssId()) != 0L) {
                this.labelpssyscss = null;
            }
            if (this.labelpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getLabelPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.labelpssyscss = pSSysCss;
            }
            return this.labelpssyscss;
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
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDictCat getPSSysDictCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDictCat();
        }
        if (this.getPSSysDictCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysDictCatLock;
        synchronized (n) {
            if (this.pssysdictcat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDictCatId(), (Object)this.pssysdictcat.getPSSysDictCatId()) != 0L) {
                this.pssysdictcat = null;
            }
            if (this.pssysdictcat == null) {
                PSSysDictCat pSSysDictCat = new PSSysDictCat();
                pSSysDictCat.setPSSysDictCatId(this.getPSSysDictCatId());
                PSSysDictCatService pSSysDictCatService = (PSSysDictCatService)ServiceGlobal.getService(PSSysDictCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysDictCatService.autoGet((IEntity)pSSysDictCat);
                this.pssysdictcat = pSSysDictCat;
            }
            return this.pssysdictcat;
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
    public PSSysPDTView getOpenPSSysPDTView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSSysPDTView();
        }
        if (this.getOpenPSSysPDTViewId() == null) {
            return null;
        }
        Integer n = this.objOpenPSSysPDTViewLock;
        synchronized (n) {
            if (this.openpssyspdtview != null && DataTypeHelper.compare((int)25, (Object)this.getOpenPSSysPDTViewId(), (Object)this.openpssyspdtview.getPSSysPDTViewId()) != 0L) {
                this.openpssyspdtview = null;
            }
            if (this.openpssyspdtview == null) {
                PSSysPDTView pSSysPDTView = new PSSysPDTView();
                pSSysPDTView.setPSSysPDTViewId(this.getOpenPSSysPDTViewId());
                PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysPDTViewService.autoGet((IEntity)pSSysPDTView);
                this.openpssyspdtview = pSSysPDTView;
            }
            return this.openpssyspdtview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getUCPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCPSSysPFPlugin();
        }
        if (this.getUCPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objUCPSSysPFPluginLock;
        synchronized (n) {
            if (this.ucpssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getUCPSSysPFPluginId(), (Object)this.ucpssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.ucpssyspfplugin = null;
            }
            if (this.ucpssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getUCPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.ucpssyspfplugin = pSSysPFPlugin;
            }
            return this.ucpssyspfplugin;
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
    public PSSysViewPanel getMDPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMDPSSysViewPanel();
        }
        if (this.getMDPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objMDPSSysViewPanelLock;
        synchronized (n) {
            if (this.mdpssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getMDPSSysViewPanelId(), (Object)this.mdpssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.mdpssysviewpanel = null;
            }
            if (this.mdpssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getMDPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.mdpssysviewpanel = pSSysViewPanel;
            }
            return this.mdpssysviewpanel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFDLogic> getPSDEFDLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDLogics();
        }
        if (this.getPSDEFormDetailId() == null) {
            return null;
        }
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFDLogicsLock;
        synchronized (n) {
            if (this.psdefdlogics == null) {
                this.psdefdlogics = pSDEFormDetailService.isTempData((IEntity)this) ? pSDEFDLogicService.selectTempByPSDEFormDetail(this) : pSDEFDLogicService.selectByPSDEFormDetail(this);
            }
            return this.psdefdlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFormDetail> getPSDEFormDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetails();
        }
        if (this.getPSDEFormDetailId() == null) {
            return null;
        }
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormDetailService pSDEFormDetailService2 = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFormDetailsLock;
        synchronized (n) {
            if (this.psdeformdetails == null) {
                this.psdeformdetails = pSDEFormDetailService.isTempData((IEntity)this) ? pSDEFormDetailService2.selectTempByPPSDEFormDetail(this) : pSDEFormDetailService2.selectByPPSDEFormDetail(this);
            }
            return this.psdeformdetails;
        }
    }

    private PSDEFormDetailBase getProxyEntity() {
        return this.proxyPSDEFormDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFormDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFormDetailBase) {
            this.proxyPSDEFormDetailBase = (PSDEFormDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_BLANKLOGIC, 1);
        fieldIndexMap.put(FIELD_BL_POS, 2);
        fieldIndexMap.put(FIELD_BORDERSTYLE, 3);
        fieldIndexMap.put(FIELD_BTNACTIONTYPE, 4);
        fieldIndexMap.put(FIELD_BUILDINACTION, 5);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 6);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 7);
        fieldIndexMap.put(FIELD_CAPTION, 8);
        fieldIndexMap.put(FIELD_CHILD_COL_LG, 9);
        fieldIndexMap.put(FIELD_CHILD_COL_MD, 10);
        fieldIndexMap.put(FIELD_CHILD_COL_SM, 11);
        fieldIndexMap.put(FIELD_CHILD_COL_XS, 12);
        fieldIndexMap.put(FIELD_CODELISTCONFIGMODE, 13);
        fieldIndexMap.put(FIELD_COLALIGN, 14);
        fieldIndexMap.put(FIELD_COLID, 15);
        fieldIndexMap.put(FIELD_COLMODEL, 16);
        fieldIndexMap.put(FIELD_COLSPAN, 17);
        fieldIndexMap.put(FIELD_COL_LG, 18);
        fieldIndexMap.put(FIELD_COL_LG_OS, 19);
        fieldIndexMap.put(FIELD_COL_MD, 20);
        fieldIndexMap.put(FIELD_COL_MD_OS, 21);
        fieldIndexMap.put(FIELD_COL_SM, 22);
        fieldIndexMap.put(FIELD_COL_SM_OS, 23);
        fieldIndexMap.put(FIELD_COL_WIDTH, 24);
        fieldIndexMap.put(FIELD_COL_XS, 25);
        fieldIndexMap.put(FIELD_COL_XS_OS, 26);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 27);
        fieldIndexMap.put(FIELD_CONVERTCITEXT, 28);
        fieldIndexMap.put(FIELD_COUNTERID, 29);
        fieldIndexMap.put(FIELD_COUNTERMODE, 30);
        fieldIndexMap.put(FIELD_CREATEDATE, 31);
        fieldIndexMap.put(FIELD_CREATEDV, 32);
        fieldIndexMap.put(FIELD_CREATEDVT, 33);
        fieldIndexMap.put(FIELD_CREATEMAN, 34);
        fieldIndexMap.put(FIELD_CSSID, 35);
        fieldIndexMap.put(FIELD_CTRLCOLSPAN, 36);
        fieldIndexMap.put(FIELD_CTRLDYNACLASS, 37);
        fieldIndexMap.put(FIELD_CTRLHEIGHT, 38);
        fieldIndexMap.put(FIELD_CTRLPSSYSCSSID, 39);
        fieldIndexMap.put(FIELD_CTRLPSSYSCSSNAME, 40);
        fieldIndexMap.put(FIELD_CTRLRAWCSSSTYLE, 41);
        fieldIndexMap.put(FIELD_CTRLWIDTH, 42);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 43);
        fieldIndexMap.put(FIELD_DATA, 44);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 45);
        fieldIndexMap.put(FIELD_DETAILSTYLE, 46);
        fieldIndexMap.put(FIELD_DETAILSTYLETEXT, 47);
        fieldIndexMap.put(FIELD_DETAILTAG, 48);
        fieldIndexMap.put(FIELD_DETAILTAG2, 49);
        fieldIndexMap.put(FIELD_DETAILTYPE, 50);
        fieldIndexMap.put(FIELD_DYNACLASS, 51);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 52);
        fieldIndexMap.put(FIELD_EDITORPARAMS, 53);
        fieldIndexMap.put(FIELD_EDITORTYPE, 54);
        fieldIndexMap.put(FIELD_EDITORTYPENAME, 55);
        fieldIndexMap.put(FIELD_EMPTYCAPTION, 56);
        fieldIndexMap.put(FIELD_ENABLEANCHOR, 57);
        fieldIndexMap.put(FIELD_ENABLECOND, 58);
        fieldIndexMap.put(FIELD_ENABLEINPUTTIP, 59);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 60);
        fieldIndexMap.put(FIELD_ENABLELOGIC, 61);
        fieldIndexMap.put(FIELD_FIELDNAME, 62);
        fieldIndexMap.put(FIELD_FLEXALIGN, 63);
        fieldIndexMap.put(FIELD_FLEXBASIS, 64);
        fieldIndexMap.put(FIELD_FLEXDIR, 65);
        fieldIndexMap.put(FIELD_FLEXGROW, 66);
        fieldIndexMap.put(FIELD_FLEXSHRINK, 67);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 68);
        fieldIndexMap.put(FIELD_FORMTYPE, 69);
        fieldIndexMap.put(FIELD_GRIDROWID, 70);
        fieldIndexMap.put(FIELD_HALIGN, 71);
        fieldIndexMap.put(FIELD_HALIGNSELF, 72);
        fieldIndexMap.put(FIELD_HEIGHT, 73);
        fieldIndexMap.put(FIELD_HEIGHTMODE, 74);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 75);
        fieldIndexMap.put(FIELD_HTMLPAGEURL, 76);
        fieldIndexMap.put(FIELD_ICONALIGN, 77);
        fieldIndexMap.put(FIELD_IGNOREINPUT, 78);
        fieldIndexMap.put(FIELD_INSERTPOS, 79);
        fieldIndexMap.put(FIELD_ITEMPSACHANDLERID, 80);
        fieldIndexMap.put(FIELD_ITEMPSACHANDLERNAME, 81);
        fieldIndexMap.put(FIELD_ITEMSTATES, 82);
        fieldIndexMap.put(FIELD_LABELCOLSPAN, 83);
        fieldIndexMap.put(FIELD_LABELCOLSPAN2, 84);
        fieldIndexMap.put(FIELD_LABELCSSID, 85);
        fieldIndexMap.put(FIELD_LABELDYNACLASS, 86);
        fieldIndexMap.put(FIELD_LABELPOS, 87);
        fieldIndexMap.put(FIELD_LABELPSSYSCSSID, 88);
        fieldIndexMap.put(FIELD_LABELPSSYSCSSNAME, 89);
        fieldIndexMap.put(FIELD_LABELRAWCSSSTYLE, 90);
        fieldIndexMap.put(FIELD_LABELWIDTH, 91);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 92);
        fieldIndexMap.put(FIELD_LEVELTAG, 93);
        fieldIndexMap.put(FIELD_LEVELVALUE, 94);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWID, 95);
        fieldIndexMap.put(FIELD_LINKPSDEVIEWNAME, 96);
        fieldIndexMap.put(FIELD_LOGICNAME, 97);
        fieldIndexMap.put(FIELD_MARGIN, 98);
        fieldIndexMap.put(FIELD_MASKINFO, 99);
        fieldIndexMap.put(FIELD_MASKMODE, 100);
        fieldIndexMap.put(FIELD_MASKPSLANRESID, 101);
        fieldIndexMap.put(FIELD_MASKPSLANRESNAME, 102);
        fieldIndexMap.put(FIELD_MDCTRLTYPE, 103);
        fieldIndexMap.put(FIELD_MDPSDEDATAVIEWID, 104);
        fieldIndexMap.put(FIELD_MDPSDEDATAVIEWNAME, 105);
        fieldIndexMap.put(FIELD_MDPSDEFORMID, 106);
        fieldIndexMap.put(FIELD_MDPSDEFORMNAME, 107);
        fieldIndexMap.put(FIELD_MDPSDEGRIDID, 108);
        fieldIndexMap.put(FIELD_MDPSDEGRIDNAME, 109);
        fieldIndexMap.put(FIELD_MDPSDELISTID, 110);
        fieldIndexMap.put(FIELD_MDPSDELISTNAME, 111);
        fieldIndexMap.put(FIELD_MDPSSYSVIEWPANELID, 112);
        fieldIndexMap.put(FIELD_MDPSSYSVIEWPANELNAME, 113);
        fieldIndexMap.put(FIELD_MEMO, 114);
        fieldIndexMap.put(FIELD_MOBFLAG, 115);
        fieldIndexMap.put(FIELD_MODELSTATE, 116);
        fieldIndexMap.put(FIELD_NEEDCODELISTCONFIG, 117);
        fieldIndexMap.put(FIELD_NOPRIVDM, 118);
        fieldIndexMap.put(FIELD_OPENPSDEVIEWID, 119);
        fieldIndexMap.put(FIELD_OPENPSDEVIEWNAME, 120);
        fieldIndexMap.put(FIELD_OPENPSSYSPDTVIEWID, 121);
        fieldIndexMap.put(FIELD_OPENPSSYSPDTVIEWNAME, 122);
        fieldIndexMap.put(FIELD_ORDERVALUE, 123);
        fieldIndexMap.put(FIELD_PADDING, 124);
        fieldIndexMap.put(FIELD_PHPSLANRESID, 125);
        fieldIndexMap.put(FIELD_PHPSLANRESNAME, 126);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWID, 127);
        fieldIndexMap.put(FIELD_PICKUPPSDEVIEWNAME, 128);
        fieldIndexMap.put(FIELD_PLACEHOLDER, 129);
        fieldIndexMap.put(FIELD_PLAYOUTMODE, 130);
        fieldIndexMap.put(FIELD_PPSDEFORMDETAILID, 131);
        fieldIndexMap.put(FIELD_PPSDEFORMDETAILNAME, 132);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 133);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 134);
        fieldIndexMap.put(FIELD_PREVENTXSS, 135);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 136);
        fieldIndexMap.put(FIELD_PSCODELISTID, 137);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 138);
        fieldIndexMap.put(FIELD_PSDEDRID, 139);
        fieldIndexMap.put(FIELD_PSDEDRITEMID, 140);
        fieldIndexMap.put(FIELD_PSDEDRITEMNAME, 141);
        fieldIndexMap.put(FIELD_PSDEDRNAME, 142);
        fieldIndexMap.put(FIELD_PSDEFUIMODEID, 143);
        fieldIndexMap.put(FIELD_PSDEFUIMODENAME, 144);
        fieldIndexMap.put(FIELD_PSDEFID, 145);
        fieldIndexMap.put(FIELD_PSDEFIUPDATEID, 146);
        fieldIndexMap.put(FIELD_PSDEFIUPDATENAME, 147);
        fieldIndexMap.put(FIELD_PSDEFNAME, 148);
        fieldIndexMap.put(FIELD_PSDEFORMDETAILID, 149);
        fieldIndexMap.put(FIELD_PSDEFORMDETAILNAME, 150);
        fieldIndexMap.put(FIELD_PSDEFORMID, 151);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 152);
        fieldIndexMap.put(FIELD_PSDEFORMRFID, 153);
        fieldIndexMap.put(FIELD_PSDEFORMRFNAME, 154);
        fieldIndexMap.put(FIELD_PSDEFSFITEMID, 155);
        fieldIndexMap.put(FIELD_PSDEFSFITEMNAME, 156);
        fieldIndexMap.put(FIELD_PSDEID, 157);
        fieldIndexMap.put(FIELD_PSDELOGICID, 158);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 159);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 160);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 161);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 162);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 163);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 164);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 165);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 166);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 167);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 168);
        fieldIndexMap.put(FIELD_PSSYSDICTCATID, 169);
        fieldIndexMap.put(FIELD_PSSYSDICTCATNAME, 170);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 171);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 172);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 173);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 174);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 175);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 176);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 177);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 178);
        fieldIndexMap.put(FIELD_RAWCONTENT, 179);
        fieldIndexMap.put(FIELD_RAWCSSSTYLE, 180);
        fieldIndexMap.put(FIELD_RAWSERVICEMETHOD, 181);
        fieldIndexMap.put(FIELD_RAWSERVICEURL, 182);
        fieldIndexMap.put(FIELD_REFPSDEACMODEID, 183);
        fieldIndexMap.put(FIELD_REFPSDEACMODENAME, 184);
        fieldIndexMap.put(FIELD_REFPSDEDATASETID, 185);
        fieldIndexMap.put(FIELD_REFPSDEDATASETNAME, 186);
        fieldIndexMap.put(FIELD_REFPSDEFORMDETAILID, 187);
        fieldIndexMap.put(FIELD_REFPSDEFORMDETAILNAME, 188);
        fieldIndexMap.put(FIELD_REFPSDEFORMID, 189);
        fieldIndexMap.put(FIELD_REFPSDEID, 190);
        fieldIndexMap.put(FIELD_REFPSDENAME, 191);
        fieldIndexMap.put(FIELD_REFPSDERID, 192);
        fieldIndexMap.put(FIELD_REFPSDERNAME, 193);
        fieldIndexMap.put(FIELD_RENDERMODE, 194);
        fieldIndexMap.put(FIELD_RENDERMODETEXT, 195);
        fieldIndexMap.put(FIELD_RESETITEMNAME, 196);
        fieldIndexMap.put(FIELD_ROWSPAN, 197);
        fieldIndexMap.put(FIELD_SHOWCAPTION, 198);
        fieldIndexMap.put(FIELD_SHOWMOREMODE, 199);
        fieldIndexMap.put(FIELD_SPACINGBOTTOM, 200);
        fieldIndexMap.put(FIELD_SPACINGLEFT, 201);
        fieldIndexMap.put(FIELD_SPACINGRIGHT, 202);
        fieldIndexMap.put(FIELD_SPACINGTOP, 203);
        fieldIndexMap.put(FIELD_SWAPMODE, 204);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 205);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 206);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 207);
        fieldIndexMap.put(FIELD_TITLEBARCLOSEMODE, 208);
        fieldIndexMap.put(FIELD_TOGGLEMODE, 209);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 210);
        fieldIndexMap.put(FIELD_UCPSSYSPFPLUGINID, 211);
        fieldIndexMap.put(FIELD_UCPSSYSPFPLUGINNAME, 212);
        fieldIndexMap.put(FIELD_UPDATEDATE, 213);
        fieldIndexMap.put(FIELD_UPDATEDV, 214);
        fieldIndexMap.put(FIELD_UPDATEDVT, 215);
        fieldIndexMap.put(FIELD_UPDATEMAN, 216);
        fieldIndexMap.put(FIELD_USERTAG, 217);
        fieldIndexMap.put(FIELD_USERTAG2, 218);
        fieldIndexMap.put(FIELD_VALIGN, 219);
        fieldIndexMap.put(FIELD_VALIGNSELF, 220);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 221);
        fieldIndexMap.put(FIELD_VALUEITEMNAME, 222);
        fieldIndexMap.put(FIELD_VISIBLELOGIC, 223);
        fieldIndexMap.put(FIELD_WBDEFMODE, 224);
        fieldIndexMap.put(FIELD_WIDTH, 225);
        fieldIndexMap.put(FIELD_WIDTHMODE, 226);
    }
}

