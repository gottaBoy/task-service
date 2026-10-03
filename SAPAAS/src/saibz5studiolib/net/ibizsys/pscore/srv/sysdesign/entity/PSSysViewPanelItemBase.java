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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysViewPanelItemBase.class);
    public static final String FIELD_ACTIVEDATAMODE = "ACTIVEDATAMODE";
    public static final String FIELD_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String FIELD_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String FIELD_AL_POS = "AL_POS";
    public static final String FIELD_BLANKLOGIC = "BLANKLOGIC";
    public static final String FIELD_BL_POS = "BL_POS";
    public static final String FIELD_BORDERSTYLE = "BORDERSTYLE";
    public static final String FIELD_BOTTOMPOS = "BOTTOMPOS";
    public static final String FIELD_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CAPTIONPOS = "CAPTIONPOS";
    public static final String FIELD_CHILD_COL_LG = "CHILD_COL_LG";
    public static final String FIELD_CHILD_COL_MD = "CHILD_COL_MD";
    public static final String FIELD_CHILD_COL_SM = "CHILD_COL_SM";
    public static final String FIELD_CHILD_COL_XS = "CHILD_COL_XS";
    public static final String FIELD_COLID = "COLID";
    public static final String FIELD_COLLAPSIBLEFLAG = "COLLAPSIBLEFLAG";
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
    public static final String FIELD_COUNTERID = "COUNTERID";
    public static final String FIELD_COUNTERMODE = "COUNTERMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSID = "CSSID";
    public static final String FIELD_CTRLDYNACLASS = "CTRLDYNACLASS";
    public static final String FIELD_CTRLHEIGHT = "CTRLHEIGHT";
    public static final String FIELD_CTRLPSSYSCSSID = "CTRLPSSYSCSSID";
    public static final String FIELD_CTRLPSSYSCSSNAME = "CTRLPSSYSCSSNAME";
    public static final String FIELD_CTRLRAWCSSSTYLE = "CTRLRAWCSSSTYLE";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_CTRLWIDTH = "CTRLWIDTH";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATAPANELMODE = "DATAPANELMODE";
    public static final String FIELD_DATASOURCE = "DATASOURCE";
    public static final String FIELD_DATASOURCETEXT = "DATASOURCETEXT";
    public static final String FIELD_DETAILSTYLE = "DETAILSTYLE";
    public static final String FIELD_DETAILSTYLETEXT = "DETAILSTYLETEXT";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORTYPENAME = "EDITORTYPENAME";
    public static final String FIELD_EMPTYCAPTION = "EMPTYCAPTION";
    public static final String FIELD_ENABLEANCHOR = "ENABLEANCHOR";
    public static final String FIELD_ENABLELOGIC = "ENABLELOGIC";
    public static final String FIELD_FIELDNAME = "FIELDNAME";
    public static final String FIELD_FIELDSTATES = "FIELDSTATES";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXBASIS = "FLEXBASIS";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXGROW = "FLEXGROW";
    public static final String FIELD_FLEXSHRINK = "FLEXSHRINK";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_GETDATATIMER = "GETDATATIMER";
    public static final String FIELD_GRIDROWID = "GRIDROWID";
    public static final String FIELD_HALIGN = "HALIGN";
    public static final String FIELD_HALIGNSELF = "HALIGNSELF";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HEIGHTMODE = "HEIGHTMODE";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String FIELD_ICONALIGN = "ICONALIGN";
    public static final String FIELD_IGNOREINPUT = "IGNOREINPUT";
    public static final String FIELD_ITEMPARAM = "ITEMPARAM";
    public static final String FIELD_ITEMPARAM10 = "ITEMPARAM10";
    public static final String FIELD_ITEMPARAM11 = "ITEMPARAM11";
    public static final String FIELD_ITEMPARAM12 = "ITEMPARAM12";
    public static final String FIELD_ITEMPARAM2 = "ITEMPARAM2";
    public static final String FIELD_ITEMPARAM3 = "ITEMPARAM3";
    public static final String FIELD_ITEMPARAM4 = "ITEMPARAM4";
    public static final String FIELD_ITEMPARAM5 = "ITEMPARAM5";
    public static final String FIELD_ITEMPARAM6 = "ITEMPARAM6";
    public static final String FIELD_ITEMPARAM7 = "ITEMPARAM7";
    public static final String FIELD_ITEMPARAM8 = "ITEMPARAM8";
    public static final String FIELD_ITEMPARAM9 = "ITEMPARAM9";
    public static final String FIELD_ITEMPARAMS = "ITEMPARAMS";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_LABELDYNACLASS = "LABELDYNACLASS";
    public static final String FIELD_LABELPSSYSCSSID = "LABELPSSYSCSSID";
    public static final String FIELD_LABELPSSYSCSSNAME = "LABELPSSYSCSSNAME";
    public static final String FIELD_LABELRAWCSSSTYLE = "LABELRAWCSSSTYLE";
    public static final String FIELD_LABLECSSID = "LABLECSSID";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFLAG = "MOBFLAG";
    public static final String FIELD_OPENPSAPPVIEWID = "OPENPSAPPVIEWID";
    public static final String FIELD_OPENPSAPPVIEWNAME = "OPENPSAPPVIEWNAME";
    public static final String FIELD_OPENPSDEVIEWID = "OPENPSDEVIEWID";
    public static final String FIELD_OPENPSDEVIEWNAME = "OPENPSDEVIEWNAME";
    public static final String FIELD_OPENPSSYSPDTVIEWID = "OPENPSSYSPDTVIEWID";
    public static final String FIELD_OPENPSSYSPDTVIEWNAME = "OPENPSSYSPDTVIEWNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_ORIENTATIONMODE = "ORIENTATIONMODE";
    public static final String FIELD_PHPSLANRESID = "PHPSLANRESID";
    public static final String FIELD_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String FIELD_PLACEHOLDER = "PLACEHOLDER";
    public static final String FIELD_PLAYOUTMODE = "PLAYOUTMODE";
    public static final String FIELD_PPSSYSVIEWPANELITEMID = "PPSSYSVIEWPANELITEMID";
    public static final String FIELD_PPSSYSVIEWPANELITEMNAME = "PPSSYSVIEWPANELITEMNAME";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREVIEWHTML = "PREVIEWHTML";
    public static final String FIELD_PSACHANDLERID = "PSACHANDLERID";
    public static final String FIELD_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSCTRLID = "PSCTRLID";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLNAME = "PSCTRLNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDECHARTID = "PSDECHARTID";
    public static final String FIELD_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String FIELD_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String FIELD_PSDEDRID = "PSDEDRID";
    public static final String FIELD_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String FIELD_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String FIELD_PSDEDRNAME = "PSDEDRNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELISTID = "PSDELISTID";
    public static final String FIELD_PSDELISTNAME = "PSDELISTNAME";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEPANELID = "PSDEPANELID";
    public static final String FIELD_PSDEPANELNAME = "PSDEPANELNAME";
    public static final String FIELD_PSDEREPORTID = "PSDEREPORTID";
    public static final String FIELD_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String FIELD_PSDESEARCHFORMID = "PSDESEARCHFORMID";
    public static final String FIELD_PSDESEARCHFORMNAME = "PSDESEARCHFORMNAME";
    public static final String FIELD_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String FIELD_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String FIELD_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String FIELD_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String FIELD_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String FIELD_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String FIELD_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSEARCHBARID = "PSSYSSEARCHBARID";
    public static final String FIELD_PSSYSSEARCHBARNAME = "PSSYSSEARCHBARNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String FIELD_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String FIELD_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String FIELD_READONLYMODE = "READONLYMODE";
    public static final String FIELD_REFCTRL2NAME = "REFCTRL2NAME";
    public static final String FIELD_REFCTRL2USAGE = "REFCTRL2USAGE";
    public static final String FIELD_REFCTRL2USAGETEXT = "REFCTRL2USAGETEXT";
    public static final String FIELD_REFCTRLNAME = "REFCTRLNAME";
    public static final String FIELD_REFCTRLUSAGE = "REFCTRLUSAGE";
    public static final String FIELD_REFCTRLUSAGETEXT = "REFCTRLUSAGETEXT";
    public static final String FIELD_REFLINKPSDEVIEWID = "REFLINKPSDEVIEWID";
    public static final String FIELD_REFLINKPSDEVIEWNAME = "REFLINKPSDEVIEWNAME";
    public static final String FIELD_REFPICKUPPSDEVIEWID = "REFPICKUPPSDEVIEWID";
    public static final String FIELD_REFPICKUPPSDEVIEWNAME = "REFPICKUPPSDEVIEWNAME";
    public static final String FIELD_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String FIELD_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String FIELD_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String FIELD_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_RENDERMODE = "RENDERMODE";
    public static final String FIELD_RENDERMODETEXT = "RENDERMODETEXT";
    public static final String FIELD_RESETITEMNAME = "RESETITEMNAME";
    public static final String FIELD_RIGHTPOS = "RIGHTPOS";
    public static final String FIELD_ROWSPAN = "ROWSPAN";
    public static final String FIELD_SHOWCAPTION = "SHOWCAPTION";
    public static final String FIELD_SPACINGBOTTOM = "SPACINGBOTTOM";
    public static final String FIELD_SPACINGLEFT = "SPACINGLEFT";
    public static final String FIELD_SPACINGRIGHT = "SPACINGRIGHT";
    public static final String FIELD_SPACINGTOP = "SPACINGTOP";
    public static final String FIELD_SWAPMODE = "SWAPMODE";
    public static final String FIELD_TABINDEX = "TABINDEX";
    public static final String FIELD_TARGETID = "TARGETID";
    public static final String FIELD_TARGETNAME = "TARGETNAME";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String FIELD_TOGGLEMODE = "TOGGLEMODE";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIGN = "VALIGN";
    public static final String FIELD_VALIGNSELF = "VALIGNSELF";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String FIELD_VISIBLELOGIC = "VISIBLELOGIC";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_WIDTHMODE = "WIDTHMODE";
    private static final int INDEX_ACTIVEDATAMODE = 0;
    private static final int INDEX_ADPSDELOGICID = 1;
    private static final int INDEX_ADPSDELOGICNAME = 2;
    private static final int INDEX_AL_POS = 3;
    private static final int INDEX_BLANKLOGIC = 4;
    private static final int INDEX_BL_POS = 5;
    private static final int INDEX_BORDERSTYLE = 6;
    private static final int INDEX_BOTTOMPOS = 7;
    private static final int INDEX_BTNACTIONTYPE = 8;
    private static final int INDEX_BUSYINDICATOR = 9;
    private static final int INDEX_CAPPSLANRESID = 10;
    private static final int INDEX_CAPPSLANRESNAME = 11;
    private static final int INDEX_CAPTION = 12;
    private static final int INDEX_CAPTIONPOS = 13;
    private static final int INDEX_CHILD_COL_LG = 14;
    private static final int INDEX_CHILD_COL_MD = 15;
    private static final int INDEX_CHILD_COL_SM = 16;
    private static final int INDEX_CHILD_COL_XS = 17;
    private static final int INDEX_COLID = 18;
    private static final int INDEX_COLLAPSIBLEFLAG = 19;
    private static final int INDEX_COLMODEL = 20;
    private static final int INDEX_COLSPAN = 21;
    private static final int INDEX_COL_LG = 22;
    private static final int INDEX_COL_LG_OS = 23;
    private static final int INDEX_COL_MD = 24;
    private static final int INDEX_COL_MD_OS = 25;
    private static final int INDEX_COL_SM = 26;
    private static final int INDEX_COL_SM_OS = 27;
    private static final int INDEX_COL_WIDTH = 28;
    private static final int INDEX_COL_XS = 29;
    private static final int INDEX_COL_XS_OS = 30;
    private static final int INDEX_CONTENTTYPE = 31;
    private static final int INDEX_COUNTERID = 32;
    private static final int INDEX_COUNTERMODE = 33;
    private static final int INDEX_CREATEDATE = 34;
    private static final int INDEX_CREATEMAN = 35;
    private static final int INDEX_CSSID = 36;
    private static final int INDEX_CTRLDYNACLASS = 37;
    private static final int INDEX_CTRLHEIGHT = 38;
    private static final int INDEX_CTRLPSSYSCSSID = 39;
    private static final int INDEX_CTRLPSSYSCSSNAME = 40;
    private static final int INDEX_CTRLRAWCSSSTYLE = 41;
    private static final int INDEX_CTRLTYPE = 42;
    private static final int INDEX_CTRLWIDTH = 43;
    private static final int INDEX_CUSTOMCODE = 44;
    private static final int INDEX_CUSTOMMODE = 45;
    private static final int INDEX_DATAPANELMODE = 46;
    private static final int INDEX_DATASOURCE = 47;
    private static final int INDEX_DATASOURCETEXT = 48;
    private static final int INDEX_DETAILSTYLE = 49;
    private static final int INDEX_DETAILSTYLETEXT = 50;
    private static final int INDEX_DYNACLASS = 51;
    private static final int INDEX_EDITORTYPE = 52;
    private static final int INDEX_EDITORTYPENAME = 53;
    private static final int INDEX_EMPTYCAPTION = 54;
    private static final int INDEX_ENABLEANCHOR = 55;
    private static final int INDEX_ENABLELOGIC = 56;
    private static final int INDEX_FIELDNAME = 57;
    private static final int INDEX_FIELDSTATES = 58;
    private static final int INDEX_FLEXALIGN = 59;
    private static final int INDEX_FLEXBASIS = 60;
    private static final int INDEX_FLEXDIR = 61;
    private static final int INDEX_FLEXGROW = 62;
    private static final int INDEX_FLEXSHRINK = 63;
    private static final int INDEX_FLEXVALIGN = 64;
    private static final int INDEX_GETDATATIMER = 65;
    private static final int INDEX_GRIDROWID = 66;
    private static final int INDEX_HALIGN = 67;
    private static final int INDEX_HALIGNSELF = 68;
    private static final int INDEX_HEIGHT = 69;
    private static final int INDEX_HEIGHTMODE = 70;
    private static final int INDEX_HTMLCONTENT = 71;
    private static final int INDEX_HTMLPAGEURL = 72;
    private static final int INDEX_ICONALIGN = 73;
    private static final int INDEX_IGNOREINPUT = 74;
    private static final int INDEX_ITEMPARAM = 75;
    private static final int INDEX_ITEMPARAM10 = 76;
    private static final int INDEX_ITEMPARAM11 = 77;
    private static final int INDEX_ITEMPARAM12 = 78;
    private static final int INDEX_ITEMPARAM2 = 79;
    private static final int INDEX_ITEMPARAM3 = 80;
    private static final int INDEX_ITEMPARAM4 = 81;
    private static final int INDEX_ITEMPARAM5 = 82;
    private static final int INDEX_ITEMPARAM6 = 83;
    private static final int INDEX_ITEMPARAM7 = 84;
    private static final int INDEX_ITEMPARAM8 = 85;
    private static final int INDEX_ITEMPARAM9 = 86;
    private static final int INDEX_ITEMPARAMS = 87;
    private static final int INDEX_ITEMTYPE = 88;
    private static final int INDEX_LABELDYNACLASS = 89;
    private static final int INDEX_LABELPSSYSCSSID = 90;
    private static final int INDEX_LABELPSSYSCSSNAME = 91;
    private static final int INDEX_LABELRAWCSSSTYLE = 92;
    private static final int INDEX_LABLECSSID = 93;
    private static final int INDEX_LAYOUTMODE = 94;
    private static final int INDEX_LEFTPOS = 95;
    private static final int INDEX_LOGICNAME = 96;
    private static final int INDEX_MEMO = 97;
    private static final int INDEX_MOBFLAG = 98;
    private static final int INDEX_OPENPSAPPVIEWID = 99;
    private static final int INDEX_OPENPSAPPVIEWNAME = 100;
    private static final int INDEX_OPENPSDEVIEWID = 101;
    private static final int INDEX_OPENPSDEVIEWNAME = 102;
    private static final int INDEX_OPENPSSYSPDTVIEWID = 103;
    private static final int INDEX_OPENPSSYSPDTVIEWNAME = 104;
    private static final int INDEX_ORDERVALUE = 105;
    private static final int INDEX_ORIENTATIONMODE = 106;
    private static final int INDEX_PHPSLANRESID = 107;
    private static final int INDEX_PHPSLANRESNAME = 108;
    private static final int INDEX_PLACEHOLDER = 109;
    private static final int INDEX_PLAYOUTMODE = 110;
    private static final int INDEX_PPSSYSVIEWPANELITEMID = 111;
    private static final int INDEX_PPSSYSVIEWPANELITEMNAME = 112;
    private static final int INDEX_PREDEFINEDTYPE = 113;
    private static final int INDEX_PREDEFINEDTYPETEXT = 114;
    private static final int INDEX_PREVIEWHTML = 115;
    private static final int INDEX_PSACHANDLERID = 116;
    private static final int INDEX_PSACHANDLERNAME = 117;
    private static final int INDEX_PSAPPMENUID = 118;
    private static final int INDEX_PSAPPMENUNAME = 119;
    private static final int INDEX_PSCODELISTID = 120;
    private static final int INDEX_PSCODELISTNAME = 121;
    private static final int INDEX_PSCTRLID = 122;
    private static final int INDEX_PSCTRLLOGICGROUPID = 123;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 124;
    private static final int INDEX_PSCTRLNAME = 125;
    private static final int INDEX_PSDEACTIONID = 126;
    private static final int INDEX_PSDEACTIONNAME = 127;
    private static final int INDEX_PSDECHARTID = 128;
    private static final int INDEX_PSDECHARTNAME = 129;
    private static final int INDEX_PSDEDATASETID = 130;
    private static final int INDEX_PSDEDATASETNAME = 131;
    private static final int INDEX_PSDEDATAVIEWID = 132;
    private static final int INDEX_PSDEDATAVIEWNAME = 133;
    private static final int INDEX_PSDEDRID = 134;
    private static final int INDEX_PSDEDRITEMID = 135;
    private static final int INDEX_PSDEDRITEMNAME = 136;
    private static final int INDEX_PSDEDRNAME = 137;
    private static final int INDEX_PSDEFORMID = 138;
    private static final int INDEX_PSDEFORMNAME = 139;
    private static final int INDEX_PSDEGRIDID = 140;
    private static final int INDEX_PSDEGRIDNAME = 141;
    private static final int INDEX_PSDEID = 142;
    private static final int INDEX_PSDELISTID = 143;
    private static final int INDEX_PSDELISTNAME = 144;
    private static final int INDEX_PSDELOGICID = 145;
    private static final int INDEX_PSDELOGICNAME = 146;
    private static final int INDEX_PSDENAME = 147;
    private static final int INDEX_PSDEPANELID = 148;
    private static final int INDEX_PSDEPANELNAME = 149;
    private static final int INDEX_PSDEREPORTID = 150;
    private static final int INDEX_PSDEREPORTNAME = 151;
    private static final int INDEX_PSDESEARCHFORMID = 152;
    private static final int INDEX_PSDESEARCHFORMNAME = 153;
    private static final int INDEX_PSDETOOLBARID = 154;
    private static final int INDEX_PSDETOOLBARNAME = 155;
    private static final int INDEX_PSDETREEVIEWID = 156;
    private static final int INDEX_PSDETREEVIEWNAME = 157;
    private static final int INDEX_PSDEUAGROUPID = 158;
    private static final int INDEX_PSDEUAGROUPNAME = 159;
    private static final int INDEX_PSDEUIACTIONID = 160;
    private static final int INDEX_PSDEUIACTIONNAME = 161;
    private static final int INDEX_PSDEVIEWBASEID = 162;
    private static final int INDEX_PSDEVIEWBASENAME = 163;
    private static final int INDEX_PSDEWIZARDID = 164;
    private static final int INDEX_PSDEWIZARDNAME = 165;
    private static final int INDEX_PSSYSCALENDARID = 166;
    private static final int INDEX_PSSYSCALENDARNAME = 167;
    private static final int INDEX_PSSYSCOUNTERID = 168;
    private static final int INDEX_PSSYSCOUNTERNAME = 169;
    private static final int INDEX_PSSYSCSSID = 170;
    private static final int INDEX_PSSYSCSSNAME = 171;
    private static final int INDEX_PSSYSDASHBOARDID = 172;
    private static final int INDEX_PSSYSDASHBOARDNAME = 173;
    private static final int INDEX_PSSYSDYNAMODELID = 174;
    private static final int INDEX_PSSYSDYNAMODELNAME = 175;
    private static final int INDEX_PSSYSEDITORSTYLEID = 176;
    private static final int INDEX_PSSYSEDITORSTYLENAME = 177;
    private static final int INDEX_PSSYSIMAGEID = 178;
    private static final int INDEX_PSSYSIMAGENAME = 179;
    private static final int INDEX_PSSYSMAPVIEWID = 180;
    private static final int INDEX_PSSYSMAPVIEWNAME = 181;
    private static final int INDEX_PSSYSPFPLUGINID = 182;
    private static final int INDEX_PSSYSPFPLUGINNAME = 183;
    private static final int INDEX_PSSYSRESOURCEID = 184;
    private static final int INDEX_PSSYSRESOURCENAME = 185;
    private static final int INDEX_PSSYSSEARCHBARID = 186;
    private static final int INDEX_PSSYSSEARCHBARNAME = 187;
    private static final int INDEX_PSSYSVIEWPANELID = 188;
    private static final int INDEX_PSSYSVIEWPANELITEMID = 189;
    private static final int INDEX_PSSYSVIEWPANELITEMNAME = 190;
    private static final int INDEX_PSSYSVIEWPANELNAME = 191;
    private static final int INDEX_RAWCONTENT = 192;
    private static final int INDEX_RAWCSSSTYLE = 193;
    private static final int INDEX_RAWSERVICEMETHOD = 194;
    private static final int INDEX_RAWSERVICEURL = 195;
    private static final int INDEX_READONLYMODE = 196;
    private static final int INDEX_REFCTRL2NAME = 197;
    private static final int INDEX_REFCTRL2USAGE = 198;
    private static final int INDEX_REFCTRL2USAGETEXT = 199;
    private static final int INDEX_REFCTRLNAME = 200;
    private static final int INDEX_REFCTRLUSAGE = 201;
    private static final int INDEX_REFCTRLUSAGETEXT = 202;
    private static final int INDEX_REFLINKPSDEVIEWID = 203;
    private static final int INDEX_REFLINKPSDEVIEWNAME = 204;
    private static final int INDEX_REFPICKUPPSDEVIEWID = 205;
    private static final int INDEX_REFPICKUPPSDEVIEWNAME = 206;
    private static final int INDEX_REFPSDEACMODEID = 207;
    private static final int INDEX_REFPSDEACMODENAME = 208;
    private static final int INDEX_REFPSDEDATASETID = 209;
    private static final int INDEX_REFPSDEDATASETNAME = 210;
    private static final int INDEX_REFPSDEID = 211;
    private static final int INDEX_REFPSDENAME = 212;
    private static final int INDEX_RENDERMODE = 213;
    private static final int INDEX_RENDERMODETEXT = 214;
    private static final int INDEX_RESETITEMNAME = 215;
    private static final int INDEX_RIGHTPOS = 216;
    private static final int INDEX_ROWSPAN = 217;
    private static final int INDEX_SHOWCAPTION = 218;
    private static final int INDEX_SPACINGBOTTOM = 219;
    private static final int INDEX_SPACINGLEFT = 220;
    private static final int INDEX_SPACINGRIGHT = 221;
    private static final int INDEX_SPACINGTOP = 222;
    private static final int INDEX_SWAPMODE = 223;
    private static final int INDEX_TABINDEX = 224;
    private static final int INDEX_TARGETID = 225;
    private static final int INDEX_TARGETNAME = 226;
    private static final int INDEX_TARGETTYPE = 227;
    private static final int INDEX_TEMPLATEMODE = 228;
    private static final int INDEX_TIPPSLANRESID = 229;
    private static final int INDEX_TIPPSLANRESNAME = 230;
    private static final int INDEX_TITLEBARCLOSEMODE = 231;
    private static final int INDEX_TOGGLEMODE = 232;
    private static final int INDEX_TOOLTIPINFO = 233;
    private static final int INDEX_TOPPOS = 234;
    private static final int INDEX_UPDATEDATE = 235;
    private static final int INDEX_UPDATEMAN = 236;
    private static final int INDEX_USERTAG = 237;
    private static final int INDEX_USERTAG2 = 238;
    private static final int INDEX_VALIGN = 239;
    private static final int INDEX_VALIGNSELF = 240;
    private static final int INDEX_VALUEFORMAT = 241;
    private static final int INDEX_VALUEITEMNAME = 242;
    private static final int INDEX_VISIBLELOGIC = 243;
    private static final int INDEX_WIDTH = 244;
    private static final int INDEX_WIDTHMODE = 245;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysViewPanelItemBase proxyPSSysViewPanelItemBase = null;
    private boolean activedatamodeDirtyFlag = false;
    private boolean adpsdelogicidDirtyFlag = false;
    private boolean adpsdelogicnameDirtyFlag = false;
    private boolean al_posDirtyFlag = false;
    private boolean blanklogicDirtyFlag = false;
    private boolean bl_posDirtyFlag = false;
    private boolean borderstyleDirtyFlag = false;
    private boolean bottomposDirtyFlag = false;
    private boolean btnactiontypeDirtyFlag = false;
    private boolean busyindicatorDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean captionposDirtyFlag = false;
    private boolean child_col_lgDirtyFlag = false;
    private boolean child_col_mdDirtyFlag = false;
    private boolean child_col_smDirtyFlag = false;
    private boolean child_col_xsDirtyFlag = false;
    private boolean colidDirtyFlag = false;
    private boolean collapsibleflagDirtyFlag = false;
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
    private boolean counteridDirtyFlag = false;
    private boolean countermodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssidDirtyFlag = false;
    private boolean ctrldynaclassDirtyFlag = false;
    private boolean ctrlheightDirtyFlag = false;
    private boolean ctrlpssyscssidDirtyFlag = false;
    private boolean ctrlpssyscssnameDirtyFlag = false;
    private boolean ctrlrawcssstyleDirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean ctrlwidthDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean datapanelmodeDirtyFlag = false;
    private boolean datasourceDirtyFlag = false;
    private boolean datasourcetextDirtyFlag = false;
    private boolean detailstyleDirtyFlag = false;
    private boolean detailstyletextDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editortypenameDirtyFlag = false;
    private boolean emptycaptionDirtyFlag = false;
    private boolean enableanchorDirtyFlag = false;
    private boolean enablelogicDirtyFlag = false;
    private boolean fieldnameDirtyFlag = false;
    private boolean fieldstatesDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexbasisDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexgrowDirtyFlag = false;
    private boolean flexshrinkDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean getdatatimerDirtyFlag = false;
    private boolean gridrowidDirtyFlag = false;
    private boolean halignDirtyFlag = false;
    private boolean halignselfDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean heightmodeDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean htmlpageurlDirtyFlag = false;
    private boolean iconalignDirtyFlag = false;
    private boolean ignoreinputDirtyFlag = false;
    private boolean itemparamDirtyFlag = false;
    private boolean itemparam10DirtyFlag = false;
    private boolean itemparam11DirtyFlag = false;
    private boolean itemparam12DirtyFlag = false;
    private boolean itemparam2DirtyFlag = false;
    private boolean itemparam3DirtyFlag = false;
    private boolean itemparam4DirtyFlag = false;
    private boolean itemparam5DirtyFlag = false;
    private boolean itemparam6DirtyFlag = false;
    private boolean itemparam7DirtyFlag = false;
    private boolean itemparam8DirtyFlag = false;
    private boolean itemparam9DirtyFlag = false;
    private boolean itemparamsDirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean labeldynaclassDirtyFlag = false;
    private boolean labelpssyscssidDirtyFlag = false;
    private boolean labelpssyscssnameDirtyFlag = false;
    private boolean labelrawcssstyleDirtyFlag = false;
    private boolean lablecssidDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobflagDirtyFlag = false;
    private boolean openpsappviewidDirtyFlag = false;
    private boolean openpsappviewnameDirtyFlag = false;
    private boolean openpsdeviewidDirtyFlag = false;
    private boolean openpsdeviewnameDirtyFlag = false;
    private boolean openpssyspdtviewidDirtyFlag = false;
    private boolean openpssyspdtviewnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean orientationmodeDirtyFlag = false;
    private boolean phpslanresidDirtyFlag = false;
    private boolean phpslanresnameDirtyFlag = false;
    private boolean placeholderDirtyFlag = false;
    private boolean playoutmodeDirtyFlag = false;
    private boolean ppssysviewpanelitemidDirtyFlag = false;
    private boolean ppssysviewpanelitemnameDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean previewhtmlDirtyFlag = false;
    private boolean psachandleridDirtyFlag = false;
    private boolean psachandlernameDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psctrlidDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlnameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdechartidDirtyFlag = false;
    private boolean psdechartnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdedataviewidDirtyFlag = false;
    private boolean psdedataviewnameDirtyFlag = false;
    private boolean psdedridDirtyFlag = false;
    private boolean psdedritemidDirtyFlag = false;
    private boolean psdedritemnameDirtyFlag = false;
    private boolean psdedrnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelistidDirtyFlag = false;
    private boolean psdelistnameDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdepanelidDirtyFlag = false;
    private boolean psdepanelnameDirtyFlag = false;
    private boolean psdereportidDirtyFlag = false;
    private boolean psdereportnameDirtyFlag = false;
    private boolean psdesearchformidDirtyFlag = false;
    private boolean psdesearchformnameDirtyFlag = false;
    private boolean psdetoolbaridDirtyFlag = false;
    private boolean psdetoolbarnameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psdewizardidDirtyFlag = false;
    private boolean psdewizardnameDirtyFlag = false;
    private boolean pssyscalendaridDirtyFlag = false;
    private boolean pssyscalendarnameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdashboardidDirtyFlag = false;
    private boolean pssysdashboardnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyseditorstyleidDirtyFlag = false;
    private boolean pssyseditorstylenameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssysmapviewidDirtyFlag = false;
    private boolean pssysmapviewnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssearchbaridDirtyFlag = false;
    private boolean pssyssearchbarnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelitemidDirtyFlag = false;
    private boolean pssysviewpanelitemnameDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean rawcssstyleDirtyFlag = false;
    private boolean rawservicemethodDirtyFlag = false;
    private boolean rawserviceurlDirtyFlag = false;
    private boolean readonlymodeDirtyFlag = false;
    private boolean refctrl2nameDirtyFlag = false;
    private boolean refctrl2usageDirtyFlag = false;
    private boolean refctrl2usagetextDirtyFlag = false;
    private boolean refctrlnameDirtyFlag = false;
    private boolean refctrlusageDirtyFlag = false;
    private boolean refctrlusagetextDirtyFlag = false;
    private boolean reflinkpsdeviewidDirtyFlag = false;
    private boolean reflinkpsdeviewnameDirtyFlag = false;
    private boolean refpickuppsdeviewidDirtyFlag = false;
    private boolean refpickuppsdeviewnameDirtyFlag = false;
    private boolean refpsdeacmodeidDirtyFlag = false;
    private boolean refpsdeacmodenameDirtyFlag = false;
    private boolean refpsdedatasetidDirtyFlag = false;
    private boolean refpsdedatasetnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean rendermodeDirtyFlag = false;
    private boolean rendermodetextDirtyFlag = false;
    private boolean resetitemnameDirtyFlag = false;
    private boolean rightposDirtyFlag = false;
    private boolean rowspanDirtyFlag = false;
    private boolean showcaptionDirtyFlag = false;
    private boolean spacingbottomDirtyFlag = false;
    private boolean spacingleftDirtyFlag = false;
    private boolean spacingrightDirtyFlag = false;
    private boolean spacingtopDirtyFlag = false;
    private boolean swapmodeDirtyFlag = false;
    private boolean tabindexDirtyFlag = false;
    private boolean targetidDirtyFlag = false;
    private boolean targetnameDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean titlebarclosemodeDirtyFlag = false;
    private boolean togglemodeDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean valignDirtyFlag = false;
    private boolean valignselfDirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean valueitemnameDirtyFlag = false;
    private boolean visiblelogicDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    private boolean widthmodeDirtyFlag = false;
    @Column(name="activedatamode")
    private Integer activedatamode;
    @Column(name="adpsdelogicid")
    private String adpsdelogicid;
    @Column(name="adpsdelogicname")
    private String adpsdelogicname;
    @Column(name="al_pos")
    private String al_pos;
    @Column(name="blanklogic")
    private String blanklogic;
    @Column(name="bl_pos")
    private String bl_pos;
    @Column(name="borderstyle")
    private String borderstyle;
    @Column(name="bottompos")
    private Integer bottompos;
    @Column(name="btnactiontype")
    private String btnactiontype;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="captionpos")
    private String captionpos;
    @Column(name="child_col_lg")
    private Integer child_col_lg;
    @Column(name="child_col_md")
    private Integer child_col_md;
    @Column(name="child_col_sm")
    private Integer child_col_sm;
    @Column(name="child_col_xs")
    private Integer child_col_xs;
    @Column(name="colid")
    private Integer colid;
    @Column(name="collapsibleflag")
    private Integer collapsibleflag;
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
    @Column(name="counterid")
    private String counterid;
    @Column(name="countermode")
    private Integer countermode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="cssid")
    private String cssid;
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
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="ctrlwidth")
    private Integer ctrlwidth;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="datapanelmode")
    private String datapanelmode;
    @Column(name="datasource")
    private String datasource;
    @Column(name="datasourcetext")
    private String datasourcetext;
    @Column(name="detailstyle")
    private String detailstyle;
    @Column(name="detailstyletext")
    private String detailstyletext;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editortypename")
    private String editortypename;
    @Column(name="emptycaption")
    private Integer emptycaption;
    @Column(name="enableanchor")
    private Integer enableanchor;
    @Column(name="enablelogic")
    private String enablelogic;
    @Column(name="fieldname")
    private String fieldname;
    @Column(name="fieldstates")
    private Integer fieldstates;
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
    @Column(name="getdatatimer")
    private Integer getdatatimer;
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
    @Column(name="itemparam")
    private String itemparam;
    @Column(name="itemparam10")
    private Double itemparam10;
    @Column(name="itemparam11")
    private Integer itemparam11;
    @Column(name="itemparam12")
    private Integer itemparam12;
    @Column(name="itemparam2")
    private String itemparam2;
    @Column(name="itemparam3")
    private String itemparam3;
    @Column(name="itemparam4")
    private String itemparam4;
    @Column(name="itemparam5")
    private Integer itemparam5;
    @Column(name="itemparam6")
    private Integer itemparam6;
    @Column(name="itemparam7")
    private Integer itemparam7;
    @Column(name="itemparam8")
    private Integer itemparam8;
    @Column(name="itemparam9")
    private Double itemparam9;
    @Column(name="itemparams")
    private String itemparams;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="labeldynaclass")
    private String labeldynaclass;
    @Column(name="labelpssyscssid")
    private String labelpssyscssid;
    @Column(name="labelpssyscssname")
    private String labelpssyscssname;
    @Column(name="labelrawcssstyle")
    private String labelrawcssstyle;
    @Column(name="lablecssid")
    private String lablecssid;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="mobflag")
    private Integer mobflag;
    @Column(name="openpsappviewid")
    private String openpsappviewid;
    @Column(name="openpsappviewname")
    private String openpsappviewname;
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
    @Column(name="orientationmode")
    private String orientationmode;
    @Column(name="phpslanresid")
    private String phpslanresid;
    @Column(name="phpslanresname")
    private String phpslanresname;
    @Column(name="placeholder")
    private String placeholder;
    @Column(name="playoutmode")
    private String playoutmode;
    @Column(name="ppssysviewpanelitemid")
    private String ppssysviewpanelitemid;
    @Column(name="ppssysviewpanelitemname")
    private String ppssysviewpanelitemname;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="previewhtml")
    private String previewhtml;
    @Column(name="psachandlerid")
    private String psachandlerid;
    @Column(name="psachandlername")
    private String psachandlername;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psctrlid")
    private String psctrlid;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psctrlname")
    private String psctrlname;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdechartid")
    private String psdechartid;
    @Column(name="psdechartname")
    private String psdechartname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdedataviewid")
    private String psdedataviewid;
    @Column(name="psdedataviewname")
    private String psdedataviewname;
    @Column(name="psdedrid")
    private String psdedrid;
    @Column(name="psdedritemid")
    private String psdedritemid;
    @Column(name="psdedritemname")
    private String psdedritemname;
    @Column(name="psdedrname")
    private String psdedrname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelistid")
    private String psdelistid;
    @Column(name="psdelistname")
    private String psdelistname;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdepanelid")
    private String psdepanelid;
    @Column(name="psdepanelname")
    private String psdepanelname;
    @Column(name="psdereportid")
    private String psdereportid;
    @Column(name="psdereportname")
    private String psdereportname;
    @Column(name="psdesearchformid")
    private String psdesearchformid;
    @Column(name="psdesearchformname")
    private String psdesearchformname;
    @Column(name="psdetoolbarid")
    private String psdetoolbarid;
    @Column(name="psdetoolbarname")
    private String psdetoolbarname;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psdewizardid")
    private String psdewizardid;
    @Column(name="psdewizardname")
    private String psdewizardname;
    @Column(name="pssyscalendarid")
    private String pssyscalendarid;
    @Column(name="pssyscalendarname")
    private String pssyscalendarname;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdashboardid")
    private String pssysdashboardid;
    @Column(name="pssysdashboardname")
    private String pssysdashboardname;
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
    @Column(name="pssysmapviewid")
    private String pssysmapviewid;
    @Column(name="pssysmapviewname")
    private String pssysmapviewname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssearchbarid")
    private String pssyssearchbarid;
    @Column(name="pssyssearchbarname")
    private String pssyssearchbarname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelitemid")
    private String pssysviewpanelitemid;
    @Column(name="pssysviewpanelitemname")
    private String pssysviewpanelitemname;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="rawcssstyle")
    private String rawcssstyle;
    @Column(name="rawservicemethod")
    private String rawservicemethod;
    @Column(name="rawserviceurl")
    private String rawserviceurl;
    @Column(name="readonlymode")
    private Integer readonlymode;
    @Column(name="refctrl2name")
    private String refctrl2name;
    @Column(name="refctrl2usage")
    private String refctrl2usage;
    @Column(name="refctrl2usagetext")
    private String refctrl2usagetext;
    @Column(name="refctrlname")
    private String refctrlname;
    @Column(name="refctrlusage")
    private String refctrlusage;
    @Column(name="refctrlusagetext")
    private String refctrlusagetext;
    @Column(name="reflinkpsdeviewid")
    private String reflinkpsdeviewid;
    @Column(name="reflinkpsdeviewname")
    private String reflinkpsdeviewname;
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
    @Column(name="rendermode")
    private String rendermode;
    @Column(name="rendermodetext")
    private String rendermodetext;
    @Column(name="resetitemname")
    private String resetitemname;
    @Column(name="rightpos")
    private Integer rightpos;
    @Column(name="rowspan")
    private Integer rowspan;
    @Column(name="showcaption")
    private Integer showcaption;
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
    @Column(name="tabindex")
    private Integer tabindex;
    @Column(name="targetid")
    private String targetid;
    @Column(name="targetname")
    private String targetname;
    @Column(name="targettype")
    private String targettype;
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
    @Column(name="toppos")
    private Integer toppos;
    @Column(name="updatedate")
    private Timestamp updatedate;
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
    @Column(name="width")
    private Integer width;
    @Column(name="widthmode")
    private String widthmode;
    private Integer objPSACHandlerLock = new Integer(1);
    private PSACHandler psachandler = null;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;
    private Integer objOpenPSAppViewLock = new Integer(1);
    private PSAppView openpsappview = null;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objRefPSDEACModeLock = new Integer(1);
    private PSDEACMode refpsdeacmode = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEChartLock = new Integer(1);
    private PSDEChart psdechart = null;
    private Integer objPSDEDRLock = new Integer(1);
    private PSDEDataRelation psdedr = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objRefPSDEDataSetLock = new Integer(1);
    private PSDEDataSet refpsdedataset = null;
    private Integer objPSDEDataViewLock = new Integer(1);
    private PSDEDataView psdedataview = null;
    private Integer objPSDEDRItemLock = new Integer(1);
    private PSDEDRItem psdedritem = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDESearchFormLock = new Integer(1);
    private PSDEForm psdesearchform = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objPSDEListLock = new Integer(1);
    private PSDEList psdelist = null;
    private Integer objADPSDELogicLock = new Integer(1);
    private PSDELogic adpsdelogic = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEReportLock = new Integer(1);
    private PSDEReport psdereport = null;
    private Integer objPSDEToolbarLock = new Integer(1);
    private PSDEToolbar psdetoolbar = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objOpenPSDEViewLock = new Integer(1);
    private PSDEViewBase openpsdeview = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objRefLinkPSDEViewLock = new Integer(1);
    private PSDEViewBase reflinkpsdeview = null;
    private Integer objRefPickupPSDEViewLock = new Integer(1);
    private PSDEViewBase refpickuppsdeview = null;
    private Integer objPSDEWizardLock = new Integer(1);
    private PSDEWizard psdewizard = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPHPSLanResLock = new Integer(1);
    private PSLanguageRes phpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCalendarLock = new Integer(1);
    private PSSysCalendar pssyscalendar = null;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;
    private Integer objCtrlPSSysCssLock = new Integer(1);
    private PSSysCss ctrlpssyscss = null;
    private Integer objLabelPSSysCssLock = new Integer(1);
    private PSSysCss labelpssyscss = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDashboardLock = new Integer(1);
    private PSSysDashboard pssysdashboard = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysEditorStyleLock = new Integer(1);
    private PSSysEditorStyle pssyseditorstyle = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysMapViewLock = new Integer(1);
    private PSSysMapView pssysmapview = null;
    private Integer objOpenPSSysPDTViewLock = new Integer(1);
    private PSSysPDTView openpssyspdtview = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSearchBarLock = new Integer(1);
    private PSSysSearchBar pssyssearchbar = null;
    private Integer objPPSSysViewPanelItemLock = new Integer(1);
    private PSSysViewPanelItem ppssysviewpanelitem = null;
    private Integer objPSDEPanelLock = new Integer(1);
    private PSSysViewPanel psdepanel = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSPanelItemLogicsLock = new Integer(1);
    private ArrayList<PSPanelItemLogic> pspanelitemlogics = null;
    private Integer objPSSysViewPanelItemsLock = new Integer(1);
    private ArrayList<PSSysViewPanelItem> pssysviewpanelitems = null;

    public void setActiveDataMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActiveDataMode(n);
            return;
        }
        this.activedatamode = n;
        this.activedatamodeDirtyFlag = true;
    }

    public Integer getActiveDataMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActiveDataMode();
        }
        return this.activedatamode;
    }

    public boolean isActiveDataModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActiveDataModeDirty();
        }
        return this.activedatamodeDirtyFlag;
    }

    public void resetActiveDataMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActiveDataMode();
            return;
        }
        this.activedatamodeDirtyFlag = false;
        this.activedatamode = null;
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

    public void setAL_Pos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAL_Pos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.al_pos = string;
        this.al_posDirtyFlag = true;
    }

    public String getAL_Pos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAL_Pos();
        }
        return this.al_pos;
    }

    public boolean isAL_PosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAL_PosDirty();
        }
        return this.al_posDirtyFlag;
    }

    public void resetAL_Pos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAL_Pos();
            return;
        }
        this.al_posDirtyFlag = false;
        this.al_pos = null;
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

    public void setBottomPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomPos(n);
            return;
        }
        this.bottompos = n;
        this.bottomposDirtyFlag = true;
    }

    public Integer getBottomPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomPos();
        }
        return this.bottompos;
    }

    public boolean isBottomPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomPosDirty();
        }
        return this.bottomposDirtyFlag;
    }

    public void resetBottomPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomPos();
            return;
        }
        this.bottomposDirtyFlag = false;
        this.bottompos = null;
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

    public void setBusyIndicator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBusyIndicator(n);
            return;
        }
        this.busyindicator = n;
        this.busyindicatorDirtyFlag = true;
    }

    public Integer getBusyIndicator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBusyIndicator();
        }
        return this.busyindicator;
    }

    public boolean isBusyIndicatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBusyIndicatorDirty();
        }
        return this.busyindicatorDirtyFlag;
    }

    public void resetBusyIndicator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBusyIndicator();
            return;
        }
        this.busyindicatorDirtyFlag = false;
        this.busyindicator = null;
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

    public void setCaptionPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaptionPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.captionpos = string;
        this.captionposDirtyFlag = true;
    }

    public String getCaptionPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaptionPos();
        }
        return this.captionpos;
    }

    public boolean isCaptionPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionPosDirty();
        }
        return this.captionposDirtyFlag;
    }

    public void resetCaptionPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaptionPos();
            return;
        }
        this.captionposDirtyFlag = false;
        this.captionpos = null;
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

    public void setCollapsibleFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCollapsibleFlag(n);
            return;
        }
        this.collapsibleflag = n;
        this.collapsibleflagDirtyFlag = true;
    }

    public Integer getCollapsibleFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCollapsibleFlag();
        }
        return this.collapsibleflag;
    }

    public boolean isCollapsibleFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCollapsibleFlagDirty();
        }
        return this.collapsibleflagDirtyFlag;
    }

    public void resetCollapsibleFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCollapsibleFlag();
            return;
        }
        this.collapsibleflagDirtyFlag = false;
        this.collapsibleflag = null;
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

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
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

    public void setDataPanelMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataPanelMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datapanelmode = string;
        this.datapanelmodeDirtyFlag = true;
    }

    public String getDataPanelMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataPanelMode();
        }
        return this.datapanelmode;
    }

    public boolean isDataPanelModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataPanelModeDirty();
        }
        return this.datapanelmodeDirtyFlag;
    }

    public void resetDataPanelMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataPanelMode();
            return;
        }
        this.datapanelmodeDirtyFlag = false;
        this.datapanelmode = null;
    }

    public void setDataSource(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSource(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datasource = string;
        this.datasourceDirtyFlag = true;
    }

    public String getDataSource() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSource();
        }
        return this.datasource;
    }

    public boolean isDataSourceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSourceDirty();
        }
        return this.datasourceDirtyFlag;
    }

    public void resetDataSource() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSource();
            return;
        }
        this.datasourceDirtyFlag = false;
        this.datasource = null;
    }

    public void setDataSourceText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSourceText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datasourcetext = string;
        this.datasourcetextDirtyFlag = true;
    }

    public String getDataSourceText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSourceText();
        }
        return this.datasourcetext;
    }

    public boolean isDataSourceTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSourceTextDirty();
        }
        return this.datasourcetextDirtyFlag;
    }

    public void resetDataSourceText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSourceText();
            return;
        }
        this.datasourcetextDirtyFlag = false;
        this.datasourcetext = null;
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

    public void setFieldStates(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldStates(n);
            return;
        }
        this.fieldstates = n;
        this.fieldstatesDirtyFlag = true;
    }

    public Integer getFieldStates() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldStates();
        }
        return this.fieldstates;
    }

    public boolean isFieldStatesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldStatesDirty();
        }
        return this.fieldstatesDirtyFlag;
    }

    public void resetFieldStates() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldStates();
            return;
        }
        this.fieldstatesDirtyFlag = false;
        this.fieldstates = null;
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

    public void setGetDataTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetDataTimer(n);
            return;
        }
        this.getdatatimer = n;
        this.getdatatimerDirtyFlag = true;
    }

    public Integer getGetDataTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetDataTimer();
        }
        return this.getdatatimer;
    }

    public boolean isGetDataTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetDataTimerDirty();
        }
        return this.getdatatimerDirtyFlag;
    }

    public void resetGetDataTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetDataTimer();
            return;
        }
        this.getdatatimerDirtyFlag = false;
        this.getdatatimer = null;
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

    public void setItemParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam = string;
        this.itemparamDirtyFlag = true;
    }

    public String getItemParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam();
        }
        return this.itemparam;
    }

    public boolean isItemParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParamDirty();
        }
        return this.itemparamDirtyFlag;
    }

    public void resetItemParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam();
            return;
        }
        this.itemparamDirtyFlag = false;
        this.itemparam = null;
    }

    public void setItemParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam10(d);
            return;
        }
        this.itemparam10 = d;
        this.itemparam10DirtyFlag = true;
    }

    public Double getItemParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam10();
        }
        return this.itemparam10;
    }

    public boolean isItemParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam10Dirty();
        }
        return this.itemparam10DirtyFlag;
    }

    public void resetItemParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam10();
            return;
        }
        this.itemparam10DirtyFlag = false;
        this.itemparam10 = null;
    }

    public void setItemParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam11(n);
            return;
        }
        this.itemparam11 = n;
        this.itemparam11DirtyFlag = true;
    }

    public Integer getItemParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam11();
        }
        return this.itemparam11;
    }

    public boolean isItemParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam11Dirty();
        }
        return this.itemparam11DirtyFlag;
    }

    public void resetItemParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam11();
            return;
        }
        this.itemparam11DirtyFlag = false;
        this.itemparam11 = null;
    }

    public void setItemParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam12(n);
            return;
        }
        this.itemparam12 = n;
        this.itemparam12DirtyFlag = true;
    }

    public Integer getItemParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam12();
        }
        return this.itemparam12;
    }

    public boolean isItemParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam12Dirty();
        }
        return this.itemparam12DirtyFlag;
    }

    public void resetItemParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam12();
            return;
        }
        this.itemparam12DirtyFlag = false;
        this.itemparam12 = null;
    }

    public void setItemParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam2 = string;
        this.itemparam2DirtyFlag = true;
    }

    public String getItemParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam2();
        }
        return this.itemparam2;
    }

    public boolean isItemParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam2Dirty();
        }
        return this.itemparam2DirtyFlag;
    }

    public void resetItemParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam2();
            return;
        }
        this.itemparam2DirtyFlag = false;
        this.itemparam2 = null;
    }

    public void setItemParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam3 = string;
        this.itemparam3DirtyFlag = true;
    }

    public String getItemParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam3();
        }
        return this.itemparam3;
    }

    public boolean isItemParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam3Dirty();
        }
        return this.itemparam3DirtyFlag;
    }

    public void resetItemParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam3();
            return;
        }
        this.itemparam3DirtyFlag = false;
        this.itemparam3 = null;
    }

    public void setItemParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparam4 = string;
        this.itemparam4DirtyFlag = true;
    }

    public String getItemParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam4();
        }
        return this.itemparam4;
    }

    public boolean isItemParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam4Dirty();
        }
        return this.itemparam4DirtyFlag;
    }

    public void resetItemParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam4();
            return;
        }
        this.itemparam4DirtyFlag = false;
        this.itemparam4 = null;
    }

    public void setItemParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam5(n);
            return;
        }
        this.itemparam5 = n;
        this.itemparam5DirtyFlag = true;
    }

    public Integer getItemParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam5();
        }
        return this.itemparam5;
    }

    public boolean isItemParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam5Dirty();
        }
        return this.itemparam5DirtyFlag;
    }

    public void resetItemParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam5();
            return;
        }
        this.itemparam5DirtyFlag = false;
        this.itemparam5 = null;
    }

    public void setItemParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam6(n);
            return;
        }
        this.itemparam6 = n;
        this.itemparam6DirtyFlag = true;
    }

    public Integer getItemParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam6();
        }
        return this.itemparam6;
    }

    public boolean isItemParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam6Dirty();
        }
        return this.itemparam6DirtyFlag;
    }

    public void resetItemParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam6();
            return;
        }
        this.itemparam6DirtyFlag = false;
        this.itemparam6 = null;
    }

    public void setItemParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam7(n);
            return;
        }
        this.itemparam7 = n;
        this.itemparam7DirtyFlag = true;
    }

    public Integer getItemParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam7();
        }
        return this.itemparam7;
    }

    public boolean isItemParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam7Dirty();
        }
        return this.itemparam7DirtyFlag;
    }

    public void resetItemParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam7();
            return;
        }
        this.itemparam7DirtyFlag = false;
        this.itemparam7 = null;
    }

    public void setItemParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam8(n);
            return;
        }
        this.itemparam8 = n;
        this.itemparam8DirtyFlag = true;
    }

    public Integer getItemParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam8();
        }
        return this.itemparam8;
    }

    public boolean isItemParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam8Dirty();
        }
        return this.itemparam8DirtyFlag;
    }

    public void resetItemParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam8();
            return;
        }
        this.itemparam8DirtyFlag = false;
        this.itemparam8 = null;
    }

    public void setItemParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParam9(d);
            return;
        }
        this.itemparam9 = d;
        this.itemparam9DirtyFlag = true;
    }

    public Double getItemParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParam9();
        }
        return this.itemparam9;
    }

    public boolean isItemParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParam9Dirty();
        }
        return this.itemparam9DirtyFlag;
    }

    public void resetItemParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParam9();
            return;
        }
        this.itemparam9DirtyFlag = false;
        this.itemparam9 = null;
    }

    public void setItemParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemparams = string;
        this.itemparamsDirtyFlag = true;
    }

    public String getItemParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemParams();
        }
        return this.itemparams;
    }

    public boolean isItemParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemParamsDirty();
        }
        return this.itemparamsDirtyFlag;
    }

    public void resetItemParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemParams();
            return;
        }
        this.itemparamsDirtyFlag = false;
        this.itemparams = null;
    }

    public void setItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtype = string;
        this.itemtypeDirtyFlag = true;
    }

    public String getItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemType();
        }
        return this.itemtype;
    }

    public boolean isItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTypeDirty();
        }
        return this.itemtypeDirtyFlag;
    }

    public void resetItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemType();
            return;
        }
        this.itemtypeDirtyFlag = false;
        this.itemtype = null;
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

    public void setLableCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLableCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lablecssid = string;
        this.lablecssidDirtyFlag = true;
    }

    public String getLableCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLableCssId();
        }
        return this.lablecssid;
    }

    public boolean isLableCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLableCssIdDirty();
        }
        return this.lablecssidDirtyFlag;
    }

    public void resetLableCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLableCssId();
            return;
        }
        this.lablecssidDirtyFlag = false;
        this.lablecssid = null;
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

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
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

    public void setOpenPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsappviewid = string;
        this.openpsappviewidDirtyFlag = true;
    }

    public String getOpenPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSAppViewId();
        }
        return this.openpsappviewid;
    }

    public boolean isOpenPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSAppViewIdDirty();
        }
        return this.openpsappviewidDirtyFlag;
    }

    public void resetOpenPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSAppViewId();
            return;
        }
        this.openpsappviewidDirtyFlag = false;
        this.openpsappviewid = null;
    }

    public void setOpenPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpenPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.openpsappviewname = string;
        this.openpsappviewnameDirtyFlag = true;
    }

    public String getOpenPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSAppViewName();
        }
        return this.openpsappviewname;
    }

    public boolean isOpenPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpenPSAppViewNameDirty();
        }
        return this.openpsappviewnameDirtyFlag;
    }

    public void resetOpenPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpenPSAppViewName();
            return;
        }
        this.openpsappviewnameDirtyFlag = false;
        this.openpsappviewname = null;
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

    public void setOrientationMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrientationMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.orientationmode = string;
        this.orientationmodeDirtyFlag = true;
    }

    public String getOrientationMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrientationMode();
        }
        return this.orientationmode;
    }

    public boolean isOrientationModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrientationModeDirty();
        }
        return this.orientationmodeDirtyFlag;
    }

    public void resetOrientationMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrientationMode();
            return;
        }
        this.orientationmodeDirtyFlag = false;
        this.orientationmode = null;
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

    public void setPPSSysViewPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysViewPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysviewpanelitemid = string;
        this.ppssysviewpanelitemidDirtyFlag = true;
    }

    public String getPPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysViewPanelItemId();
        }
        return this.ppssysviewpanelitemid;
    }

    public boolean isPPSSysViewPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysViewPanelItemIdDirty();
        }
        return this.ppssysviewpanelitemidDirtyFlag;
    }

    public void resetPPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysViewPanelItemId();
            return;
        }
        this.ppssysviewpanelitemidDirtyFlag = false;
        this.ppssysviewpanelitemid = null;
    }

    public void setPPSSysViewPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysViewPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysviewpanelitemname = string;
        this.ppssysviewpanelitemnameDirtyFlag = true;
    }

    public String getPPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysViewPanelItemName();
        }
        return this.ppssysviewpanelitemname;
    }

    public boolean isPPSSysViewPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysViewPanelItemNameDirty();
        }
        return this.ppssysviewpanelitemnameDirtyFlag;
    }

    public void resetPPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysViewPanelItemName();
            return;
        }
        this.ppssysviewpanelitemnameDirtyFlag = false;
        this.ppssysviewpanelitemname = null;
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

    public void setPSACHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlerid = string;
        this.psachandleridDirtyFlag = true;
    }

    public String getPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerId();
        }
        return this.psachandlerid;
    }

    public boolean isPSACHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerIdDirty();
        }
        return this.psachandleridDirtyFlag;
    }

    public void resetPSACHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerId();
            return;
        }
        this.psachandleridDirtyFlag = false;
        this.psachandlerid = null;
    }

    public void setPSACHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSACHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psachandlername = string;
        this.psachandlernameDirtyFlag = true;
    }

    public String getPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandlerName();
        }
        return this.psachandlername;
    }

    public boolean isPSACHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSACHandlerNameDirty();
        }
        return this.psachandlernameDirtyFlag;
    }

    public void resetPSACHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSACHandlerName();
            return;
        }
        this.psachandlernameDirtyFlag = false;
        this.psachandlername = null;
    }

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
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

    public void setPSCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlid = string;
        this.psctrlidDirtyFlag = true;
    }

    public String getPSCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlId();
        }
        return this.psctrlid;
    }

    public boolean isPSCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlIdDirty();
        }
        return this.psctrlidDirtyFlag;
    }

    public void resetPSCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlId();
            return;
        }
        this.psctrlidDirtyFlag = false;
        this.psctrlid = null;
    }

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
    }

    public void setPSCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlname = string;
        this.psctrlnameDirtyFlag = true;
    }

    public String getPSCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlName();
        }
        return this.psctrlname;
    }

    public boolean isPSCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlNameDirty();
        }
        return this.psctrlnameDirtyFlag;
    }

    public void resetPSCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlName();
            return;
        }
        this.psctrlnameDirtyFlag = false;
        this.psctrlname = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEChartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartid = string;
        this.psdechartidDirtyFlag = true;
    }

    public String getPSDEChartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartId();
        }
        return this.psdechartid;
    }

    public boolean isPSDEChartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartIdDirty();
        }
        return this.psdechartidDirtyFlag;
    }

    public void resetPSDEChartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartId();
            return;
        }
        this.psdechartidDirtyFlag = false;
        this.psdechartid = null;
    }

    public void setPSDEChartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartname = string;
        this.psdechartnameDirtyFlag = true;
    }

    public String getPSDEChartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartName();
        }
        return this.psdechartname;
    }

    public boolean isPSDEChartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartNameDirty();
        }
        return this.psdechartnameDirtyFlag;
    }

    public void resetPSDEChartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartName();
            return;
        }
        this.psdechartnameDirtyFlag = false;
        this.psdechartname = null;
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

    public void setPSDEDataViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewid = string;
        this.psdedataviewidDirtyFlag = true;
    }

    public String getPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewId();
        }
        return this.psdedataviewid;
    }

    public boolean isPSDEDataViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewIdDirty();
        }
        return this.psdedataviewidDirtyFlag;
    }

    public void resetPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewId();
            return;
        }
        this.psdedataviewidDirtyFlag = false;
        this.psdedataviewid = null;
    }

    public void setPSDEDataViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewname = string;
        this.psdedataviewnameDirtyFlag = true;
    }

    public String getPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewName();
        }
        return this.psdedataviewname;
    }

    public boolean isPSDEDataViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewNameDirty();
        }
        return this.psdedataviewnameDirtyFlag;
    }

    public void resetPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewName();
            return;
        }
        this.psdedataviewnameDirtyFlag = false;
        this.psdedataviewname = null;
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

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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

    public void setPSDEListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistid = string;
        this.psdelistidDirtyFlag = true;
    }

    public String getPSDEListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListId();
        }
        return this.psdelistid;
    }

    public boolean isPSDEListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListIdDirty();
        }
        return this.psdelistidDirtyFlag;
    }

    public void resetPSDEListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListId();
            return;
        }
        this.psdelistidDirtyFlag = false;
        this.psdelistid = null;
    }

    public void setPSDEListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistname = string;
        this.psdelistnameDirtyFlag = true;
    }

    public String getPSDEListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListName();
        }
        return this.psdelistname;
    }

    public boolean isPSDEListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListNameDirty();
        }
        return this.psdelistnameDirtyFlag;
    }

    public void resetPSDEListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListName();
            return;
        }
        this.psdelistnameDirtyFlag = false;
        this.psdelistname = null;
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

    public void setPSDEPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepanelid = string;
        this.psdepanelidDirtyFlag = true;
    }

    public String getPSDEPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPanelId();
        }
        return this.psdepanelid;
    }

    public boolean isPSDEPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPanelIdDirty();
        }
        return this.psdepanelidDirtyFlag;
    }

    public void resetPSDEPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPanelId();
            return;
        }
        this.psdepanelidDirtyFlag = false;
        this.psdepanelid = null;
    }

    public void setPSDEPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepanelname = string;
        this.psdepanelnameDirtyFlag = true;
    }

    public String getPSDEPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPanelName();
        }
        return this.psdepanelname;
    }

    public boolean isPSDEPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPanelNameDirty();
        }
        return this.psdepanelnameDirtyFlag;
    }

    public void resetPSDEPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPanelName();
            return;
        }
        this.psdepanelnameDirtyFlag = false;
        this.psdepanelname = null;
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

    public void setPSDESearchFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESearchFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesearchformid = string;
        this.psdesearchformidDirtyFlag = true;
    }

    public String getPSDESearchFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESearchFormId();
        }
        return this.psdesearchformid;
    }

    public boolean isPSDESearchFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESearchFormIdDirty();
        }
        return this.psdesearchformidDirtyFlag;
    }

    public void resetPSDESearchFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESearchFormId();
            return;
        }
        this.psdesearchformidDirtyFlag = false;
        this.psdesearchformid = null;
    }

    public void setPSDESearchFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESearchFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesearchformname = string;
        this.psdesearchformnameDirtyFlag = true;
    }

    public String getPSDESearchFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESearchFormName();
        }
        return this.psdesearchformname;
    }

    public boolean isPSDESearchFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESearchFormNameDirty();
        }
        return this.psdesearchformnameDirtyFlag;
    }

    public void resetPSDESearchFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESearchFormName();
            return;
        }
        this.psdesearchformnameDirtyFlag = false;
        this.psdesearchformname = null;
    }

    public void setPSDEToolbarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarid = string;
        this.psdetoolbaridDirtyFlag = true;
    }

    public String getPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarId();
        }
        return this.psdetoolbarid;
    }

    public boolean isPSDEToolbarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarIdDirty();
        }
        return this.psdetoolbaridDirtyFlag;
    }

    public void resetPSDEToolbarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarId();
            return;
        }
        this.psdetoolbaridDirtyFlag = false;
        this.psdetoolbarid = null;
    }

    public void setPSDEToolbarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEToolbarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetoolbarname = string;
        this.psdetoolbarnameDirtyFlag = true;
    }

    public String getPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbarName();
        }
        return this.psdetoolbarname;
    }

    public boolean isPSDEToolbarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEToolbarNameDirty();
        }
        return this.psdetoolbarnameDirtyFlag;
    }

    public void resetPSDEToolbarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEToolbarName();
            return;
        }
        this.psdetoolbarnameDirtyFlag = false;
        this.psdetoolbarname = null;
    }

    public void setPSDETreeViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewid = string;
        this.psdetreeviewidDirtyFlag = true;
    }

    public String getPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewId();
        }
        return this.psdetreeviewid;
    }

    public boolean isPSDETreeViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewIdDirty();
        }
        return this.psdetreeviewidDirtyFlag;
    }

    public void resetPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewId();
            return;
        }
        this.psdetreeviewidDirtyFlag = false;
        this.psdetreeviewid = null;
    }

    public void setPSDETreeViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewname = string;
        this.psdetreeviewnameDirtyFlag = true;
    }

    public String getPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewName();
        }
        return this.psdetreeviewname;
    }

    public boolean isPSDETreeViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewNameDirty();
        }
        return this.psdetreeviewnameDirtyFlag;
    }

    public void resetPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewName();
            return;
        }
        this.psdetreeviewnameDirtyFlag = false;
        this.psdetreeviewname = null;
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

    public void setPSDEWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardid = string;
        this.psdewizardidDirtyFlag = true;
    }

    public String getPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardId();
        }
        return this.psdewizardid;
    }

    public boolean isPSDEWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardIdDirty();
        }
        return this.psdewizardidDirtyFlag;
    }

    public void resetPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardId();
            return;
        }
        this.psdewizardidDirtyFlag = false;
        this.psdewizardid = null;
    }

    public void setPSDEWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardname = string;
        this.psdewizardnameDirtyFlag = true;
    }

    public String getPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardName();
        }
        return this.psdewizardname;
    }

    public boolean isPSDEWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardNameDirty();
        }
        return this.psdewizardnameDirtyFlag;
    }

    public void resetPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardName();
            return;
        }
        this.psdewizardnameDirtyFlag = false;
        this.psdewizardname = null;
    }

    public void setPSSysCalendarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarid = string;
        this.pssyscalendaridDirtyFlag = true;
    }

    public String getPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarId();
        }
        return this.pssyscalendarid;
    }

    public boolean isPSSysCalendarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarIdDirty();
        }
        return this.pssyscalendaridDirtyFlag;
    }

    public void resetPSSysCalendarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarId();
            return;
        }
        this.pssyscalendaridDirtyFlag = false;
        this.pssyscalendarid = null;
    }

    public void setPSSysCalendarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCalendarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscalendarname = string;
        this.pssyscalendarnameDirtyFlag = true;
    }

    public String getPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendarName();
        }
        return this.pssyscalendarname;
    }

    public boolean isPSSysCalendarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCalendarNameDirty();
        }
        return this.pssyscalendarnameDirtyFlag;
    }

    public void resetPSSysCalendarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCalendarName();
            return;
        }
        this.pssyscalendarnameDirtyFlag = false;
        this.pssyscalendarname = null;
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

    public void setPSSysDashboardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardid = string;
        this.pssysdashboardidDirtyFlag = true;
    }

    public String getPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardId();
        }
        return this.pssysdashboardid;
    }

    public boolean isPSSysDashboardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardIdDirty();
        }
        return this.pssysdashboardidDirtyFlag;
    }

    public void resetPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardId();
            return;
        }
        this.pssysdashboardidDirtyFlag = false;
        this.pssysdashboardid = null;
    }

    public void setPSSysDashboardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardname = string;
        this.pssysdashboardnameDirtyFlag = true;
    }

    public String getPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardName();
        }
        return this.pssysdashboardname;
    }

    public boolean isPSSysDashboardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardNameDirty();
        }
        return this.pssysdashboardnameDirtyFlag;
    }

    public void resetPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardName();
            return;
        }
        this.pssysdashboardnameDirtyFlag = false;
        this.pssysdashboardname = null;
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

    public void setPSSysMapViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewid = string;
        this.pssysmapviewidDirtyFlag = true;
    }

    public String getPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewId();
        }
        return this.pssysmapviewid;
    }

    public boolean isPSSysMapViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewIdDirty();
        }
        return this.pssysmapviewidDirtyFlag;
    }

    public void resetPSSysMapViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewId();
            return;
        }
        this.pssysmapviewidDirtyFlag = false;
        this.pssysmapviewid = null;
    }

    public void setPSSysMapViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMapViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmapviewname = string;
        this.pssysmapviewnameDirtyFlag = true;
    }

    public String getPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapViewName();
        }
        return this.pssysmapviewname;
    }

    public boolean isPSSysMapViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMapViewNameDirty();
        }
        return this.pssysmapviewnameDirtyFlag;
    }

    public void resetPSSysMapViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMapViewName();
            return;
        }
        this.pssysmapviewnameDirtyFlag = false;
        this.pssysmapviewname = null;
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

    public void setPSSysSearchBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarid = string;
        this.pssyssearchbaridDirtyFlag = true;
    }

    public String getPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarId();
        }
        return this.pssyssearchbarid;
    }

    public boolean isPSSysSearchBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarIdDirty();
        }
        return this.pssyssearchbaridDirtyFlag;
    }

    public void resetPSSysSearchBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarId();
            return;
        }
        this.pssyssearchbaridDirtyFlag = false;
        this.pssyssearchbarid = null;
    }

    public void setPSSysSearchBarName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchBarName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchbarname = string;
        this.pssyssearchbarnameDirtyFlag = true;
    }

    public String getPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBarName();
        }
        return this.pssyssearchbarname;
    }

    public boolean isPSSysSearchBarNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchBarNameDirty();
        }
        return this.pssyssearchbarnameDirtyFlag;
    }

    public void resetPSSysSearchBarName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchBarName();
            return;
        }
        this.pssyssearchbarnameDirtyFlag = false;
        this.pssyssearchbarname = null;
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

    public void setPSSysViewPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemid = string;
        this.pssysviewpanelitemidDirtyFlag = true;
    }

    public String getPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemId();
        }
        return this.pssysviewpanelitemid;
    }

    public boolean isPSSysViewPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemIdDirty();
        }
        return this.pssysviewpanelitemidDirtyFlag;
    }

    public void resetPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemId();
            return;
        }
        this.pssysviewpanelitemidDirtyFlag = false;
        this.pssysviewpanelitemid = null;
    }

    public void setPSSysViewPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemname = string;
        this.pssysviewpanelitemnameDirtyFlag = true;
    }

    public String getPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemName();
        }
        return this.pssysviewpanelitemname;
    }

    public boolean isPSSysViewPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemNameDirty();
        }
        return this.pssysviewpanelitemnameDirtyFlag;
    }

    public void resetPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemName();
            return;
        }
        this.pssysviewpanelitemnameDirtyFlag = false;
        this.pssysviewpanelitemname = null;
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

    public void setReadOnlyMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadOnlyMode(n);
            return;
        }
        this.readonlymode = n;
        this.readonlymodeDirtyFlag = true;
    }

    public Integer getReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadOnlyMode();
        }
        return this.readonlymode;
    }

    public boolean isReadOnlyModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadOnlyModeDirty();
        }
        return this.readonlymodeDirtyFlag;
    }

    public void resetReadOnlyMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadOnlyMode();
            return;
        }
        this.readonlymodeDirtyFlag = false;
        this.readonlymode = null;
    }

    public void setRefCtrl2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrl2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrl2name = string;
        this.refctrl2nameDirtyFlag = true;
    }

    public String getRefCtrl2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrl2Name();
        }
        return this.refctrl2name;
    }

    public boolean isRefCtrl2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrl2NameDirty();
        }
        return this.refctrl2nameDirtyFlag;
    }

    public void resetRefCtrl2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrl2Name();
            return;
        }
        this.refctrl2nameDirtyFlag = false;
        this.refctrl2name = null;
    }

    public void setRefCtrl2Usage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrl2Usage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrl2usage = string;
        this.refctrl2usageDirtyFlag = true;
    }

    public String getRefCtrl2Usage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrl2Usage();
        }
        return this.refctrl2usage;
    }

    public boolean isRefCtrl2UsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrl2UsageDirty();
        }
        return this.refctrl2usageDirtyFlag;
    }

    public void resetRefCtrl2Usage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrl2Usage();
            return;
        }
        this.refctrl2usageDirtyFlag = false;
        this.refctrl2usage = null;
    }

    public void setRefCtrl2UsageText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrl2UsageText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrl2usagetext = string;
        this.refctrl2usagetextDirtyFlag = true;
    }

    public String getRefCtrl2UsageText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrl2UsageText();
        }
        return this.refctrl2usagetext;
    }

    public boolean isRefCtrl2UsageTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrl2UsageTextDirty();
        }
        return this.refctrl2usagetextDirtyFlag;
    }

    public void resetRefCtrl2UsageText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrl2UsageText();
            return;
        }
        this.refctrl2usagetextDirtyFlag = false;
        this.refctrl2usagetext = null;
    }

    public void setRefCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrlname = string;
        this.refctrlnameDirtyFlag = true;
    }

    public String getRefCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrlName();
        }
        return this.refctrlname;
    }

    public boolean isRefCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrlNameDirty();
        }
        return this.refctrlnameDirtyFlag;
    }

    public void resetRefCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrlName();
            return;
        }
        this.refctrlnameDirtyFlag = false;
        this.refctrlname = null;
    }

    public void setRefCtrlUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrlUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrlusage = string;
        this.refctrlusageDirtyFlag = true;
    }

    public String getRefCtrlUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrlUsage();
        }
        return this.refctrlusage;
    }

    public boolean isRefCtrlUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrlUsageDirty();
        }
        return this.refctrlusageDirtyFlag;
    }

    public void resetRefCtrlUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrlUsage();
            return;
        }
        this.refctrlusageDirtyFlag = false;
        this.refctrlusage = null;
    }

    public void setRefCtrlUsageText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCtrlUsageText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refctrlusagetext = string;
        this.refctrlusagetextDirtyFlag = true;
    }

    public String getRefCtrlUsageText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCtrlUsageText();
        }
        return this.refctrlusagetext;
    }

    public boolean isRefCtrlUsageTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCtrlUsageTextDirty();
        }
        return this.refctrlusagetextDirtyFlag;
    }

    public void resetRefCtrlUsageText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCtrlUsageText();
            return;
        }
        this.refctrlusagetextDirtyFlag = false;
        this.refctrlusagetext = null;
    }

    public void setRefLinkPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefLinkPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reflinkpsdeviewid = string;
        this.reflinkpsdeviewidDirtyFlag = true;
    }

    public String getRefLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefLinkPSDEViewId();
        }
        return this.reflinkpsdeviewid;
    }

    public boolean isRefLinkPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefLinkPSDEViewIdDirty();
        }
        return this.reflinkpsdeviewidDirtyFlag;
    }

    public void resetRefLinkPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefLinkPSDEViewId();
            return;
        }
        this.reflinkpsdeviewidDirtyFlag = false;
        this.reflinkpsdeviewid = null;
    }

    public void setRefLinkPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefLinkPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reflinkpsdeviewname = string;
        this.reflinkpsdeviewnameDirtyFlag = true;
    }

    public String getRefLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefLinkPSDEViewName();
        }
        return this.reflinkpsdeviewname;
    }

    public boolean isRefLinkPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefLinkPSDEViewNameDirty();
        }
        return this.reflinkpsdeviewnameDirtyFlag;
    }

    public void resetRefLinkPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefLinkPSDEViewName();
            return;
        }
        this.reflinkpsdeviewnameDirtyFlag = false;
        this.reflinkpsdeviewname = null;
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

    public void setRightPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRightPos(n);
            return;
        }
        this.rightpos = n;
        this.rightposDirtyFlag = true;
    }

    public Integer getRightPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRightPos();
        }
        return this.rightpos;
    }

    public boolean isRightPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRightPosDirty();
        }
        return this.rightposDirtyFlag;
    }

    public void resetRightPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRightPos();
            return;
        }
        this.rightposDirtyFlag = false;
        this.rightpos = null;
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

    public void setTabIndex(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTabIndex(n);
            return;
        }
        this.tabindex = n;
        this.tabindexDirtyFlag = true;
    }

    public Integer getTabIndex() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTabIndex();
        }
        return this.tabindex;
    }

    public boolean isTabIndexDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTabIndexDirty();
        }
        return this.tabindexDirtyFlag;
    }

    public void resetTabIndex() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTabIndex();
            return;
        }
        this.tabindexDirtyFlag = false;
        this.tabindex = null;
    }

    public void setTargetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetid = string;
        this.targetidDirtyFlag = true;
    }

    public String getTargetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetId();
        }
        return this.targetid;
    }

    public boolean isTargetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetIdDirty();
        }
        return this.targetidDirtyFlag;
    }

    public void resetTargetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetId();
            return;
        }
        this.targetidDirtyFlag = false;
        this.targetid = null;
    }

    public void setTargetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targetname = string;
        this.targetnameDirtyFlag = true;
    }

    public String getTargetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetName();
        }
        return this.targetname;
    }

    public boolean isTargetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetNameDirty();
        }
        return this.targetnameDirtyFlag;
    }

    public void resetTargetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetName();
            return;
        }
        this.targetnameDirtyFlag = false;
        this.targetname = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
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

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
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
        PSSysViewPanelItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysViewPanelItemBase pSSysViewPanelItemBase) {
        pSSysViewPanelItemBase.resetActiveDataMode();
        pSSysViewPanelItemBase.resetADPSDELogicId();
        pSSysViewPanelItemBase.resetADPSDELogicName();
        pSSysViewPanelItemBase.resetAL_Pos();
        pSSysViewPanelItemBase.resetBlankLogic();
        pSSysViewPanelItemBase.resetBL_Pos();
        pSSysViewPanelItemBase.resetBorderStyle();
        pSSysViewPanelItemBase.resetBottomPos();
        pSSysViewPanelItemBase.resetBtnActionType();
        pSSysViewPanelItemBase.resetBusyIndicator();
        pSSysViewPanelItemBase.resetCapPSLanResId();
        pSSysViewPanelItemBase.resetCapPSLanResName();
        pSSysViewPanelItemBase.resetCaption();
        pSSysViewPanelItemBase.resetCaptionPos();
        pSSysViewPanelItemBase.resetChild_Col_LG();
        pSSysViewPanelItemBase.resetChild_Col_MD();
        pSSysViewPanelItemBase.resetChild_Col_SM();
        pSSysViewPanelItemBase.resetChild_Col_XS();
        pSSysViewPanelItemBase.resetColId();
        pSSysViewPanelItemBase.resetCollapsibleFlag();
        pSSysViewPanelItemBase.resetColModel();
        pSSysViewPanelItemBase.resetColSpan();
        pSSysViewPanelItemBase.resetCol_LG();
        pSSysViewPanelItemBase.resetCol_LG_OS();
        pSSysViewPanelItemBase.resetCol_MD();
        pSSysViewPanelItemBase.resetCol_MD_OS();
        pSSysViewPanelItemBase.resetCol_SM();
        pSSysViewPanelItemBase.resetCol_SM_OS();
        pSSysViewPanelItemBase.resetCol_Width();
        pSSysViewPanelItemBase.resetCol_XS();
        pSSysViewPanelItemBase.resetCol_XS_OS();
        pSSysViewPanelItemBase.resetContentType();
        pSSysViewPanelItemBase.resetCounterId();
        pSSysViewPanelItemBase.resetCounterMode();
        pSSysViewPanelItemBase.resetCreateDate();
        pSSysViewPanelItemBase.resetCreateMan();
        pSSysViewPanelItemBase.resetCssId();
        pSSysViewPanelItemBase.resetCtrlDynaClass();
        pSSysViewPanelItemBase.resetCtrlHeight();
        pSSysViewPanelItemBase.resetCtrlPSSysCssId();
        pSSysViewPanelItemBase.resetCtrlPSSysCssName();
        pSSysViewPanelItemBase.resetCtrlRawCssStyle();
        pSSysViewPanelItemBase.resetCtrlType();
        pSSysViewPanelItemBase.resetCtrlWidth();
        pSSysViewPanelItemBase.resetCustomCode();
        pSSysViewPanelItemBase.resetCustomMode();
        pSSysViewPanelItemBase.resetDataPanelMode();
        pSSysViewPanelItemBase.resetDataSource();
        pSSysViewPanelItemBase.resetDataSourceText();
        pSSysViewPanelItemBase.resetDetailStyle();
        pSSysViewPanelItemBase.resetDetailStyleText();
        pSSysViewPanelItemBase.resetDynaClass();
        pSSysViewPanelItemBase.resetEditorType();
        pSSysViewPanelItemBase.resetEditorTypeName();
        pSSysViewPanelItemBase.resetEmptyCaption();
        pSSysViewPanelItemBase.resetEnableAnchor();
        pSSysViewPanelItemBase.resetEnableLogic();
        pSSysViewPanelItemBase.resetFieldName();
        pSSysViewPanelItemBase.resetFieldStates();
        pSSysViewPanelItemBase.resetFlexAlign();
        pSSysViewPanelItemBase.resetFlexBasis();
        pSSysViewPanelItemBase.resetFlexDir();
        pSSysViewPanelItemBase.resetFlexGrow();
        pSSysViewPanelItemBase.resetFlexShrink();
        pSSysViewPanelItemBase.resetFlexVAlign();
        pSSysViewPanelItemBase.resetGetDataTimer();
        pSSysViewPanelItemBase.resetGridRowId();
        pSSysViewPanelItemBase.resetHAlign();
        pSSysViewPanelItemBase.resetHAlignSelf();
        pSSysViewPanelItemBase.resetHeight();
        pSSysViewPanelItemBase.resetHeightMode();
        pSSysViewPanelItemBase.resetHtmlContent();
        pSSysViewPanelItemBase.resetHtmlPageUrl();
        pSSysViewPanelItemBase.resetIconAlign();
        pSSysViewPanelItemBase.resetIgnoreInput();
        pSSysViewPanelItemBase.resetItemParam();
        pSSysViewPanelItemBase.resetItemParam10();
        pSSysViewPanelItemBase.resetItemParam11();
        pSSysViewPanelItemBase.resetItemParam12();
        pSSysViewPanelItemBase.resetItemParam2();
        pSSysViewPanelItemBase.resetItemParam3();
        pSSysViewPanelItemBase.resetItemParam4();
        pSSysViewPanelItemBase.resetItemParam5();
        pSSysViewPanelItemBase.resetItemParam6();
        pSSysViewPanelItemBase.resetItemParam7();
        pSSysViewPanelItemBase.resetItemParam8();
        pSSysViewPanelItemBase.resetItemParam9();
        pSSysViewPanelItemBase.resetItemParams();
        pSSysViewPanelItemBase.resetItemType();
        pSSysViewPanelItemBase.resetLabelDynaClass();
        pSSysViewPanelItemBase.resetLabelPSSysCssId();
        pSSysViewPanelItemBase.resetLabelPSSysCssName();
        pSSysViewPanelItemBase.resetLabelRawCssStyle();
        pSSysViewPanelItemBase.resetLableCssId();
        pSSysViewPanelItemBase.resetLayoutMode();
        pSSysViewPanelItemBase.resetLeftPos();
        pSSysViewPanelItemBase.resetLogicName();
        pSSysViewPanelItemBase.resetMemo();
        pSSysViewPanelItemBase.resetMobFlag();
        pSSysViewPanelItemBase.resetOpenPSAppViewId();
        pSSysViewPanelItemBase.resetOpenPSAppViewName();
        pSSysViewPanelItemBase.resetOpenPSDEViewId();
        pSSysViewPanelItemBase.resetOpenPSDEViewName();
        pSSysViewPanelItemBase.resetOpenPSSysPDTViewId();
        pSSysViewPanelItemBase.resetOpenPSSysPDTViewName();
        pSSysViewPanelItemBase.resetOrderValue();
        pSSysViewPanelItemBase.resetOrientationMode();
        pSSysViewPanelItemBase.resetPHPSLanResId();
        pSSysViewPanelItemBase.resetPHPSLanResName();
        pSSysViewPanelItemBase.resetPlaceHolder();
        pSSysViewPanelItemBase.resetPLayoutMode();
        pSSysViewPanelItemBase.resetPPSSysViewPanelItemId();
        pSSysViewPanelItemBase.resetPPSSysViewPanelItemName();
        pSSysViewPanelItemBase.resetPredefinedType();
        pSSysViewPanelItemBase.resetPredefinedTypeText();
        pSSysViewPanelItemBase.resetPreviewHtml();
        pSSysViewPanelItemBase.resetPSACHandlerId();
        pSSysViewPanelItemBase.resetPSACHandlerName();
        pSSysViewPanelItemBase.resetPSAppMenuId();
        pSSysViewPanelItemBase.resetPSAppMenuName();
        pSSysViewPanelItemBase.resetPSCodeListId();
        pSSysViewPanelItemBase.resetPSCodeListName();
        pSSysViewPanelItemBase.resetPSCtrlId();
        pSSysViewPanelItemBase.resetPSCtrlLogicGroupId();
        pSSysViewPanelItemBase.resetPSCtrlLogicGroupName();
        pSSysViewPanelItemBase.resetPSCtrlName();
        pSSysViewPanelItemBase.resetPSDEActionId();
        pSSysViewPanelItemBase.resetPSDEActionName();
        pSSysViewPanelItemBase.resetPSDEChartId();
        pSSysViewPanelItemBase.resetPSDEChartName();
        pSSysViewPanelItemBase.resetPSDEDataSetId();
        pSSysViewPanelItemBase.resetPSDEDataSetName();
        pSSysViewPanelItemBase.resetPSDEDataViewId();
        pSSysViewPanelItemBase.resetPSDEDataViewName();
        pSSysViewPanelItemBase.resetPSDEDRId();
        pSSysViewPanelItemBase.resetPSDEDRItemId();
        pSSysViewPanelItemBase.resetPSDEDRItemName();
        pSSysViewPanelItemBase.resetPSDEDRName();
        pSSysViewPanelItemBase.resetPSDEFormId();
        pSSysViewPanelItemBase.resetPSDEFormName();
        pSSysViewPanelItemBase.resetPSDEGridId();
        pSSysViewPanelItemBase.resetPSDEGridName();
        pSSysViewPanelItemBase.resetPSDEId();
        pSSysViewPanelItemBase.resetPSDEListId();
        pSSysViewPanelItemBase.resetPSDEListName();
        pSSysViewPanelItemBase.resetPSDELogicId();
        pSSysViewPanelItemBase.resetPSDELogicName();
        pSSysViewPanelItemBase.resetPSDEName();
        pSSysViewPanelItemBase.resetPSDEPanelId();
        pSSysViewPanelItemBase.resetPSDEPanelName();
        pSSysViewPanelItemBase.resetPSDEReportId();
        pSSysViewPanelItemBase.resetPSDEReportName();
        pSSysViewPanelItemBase.resetPSDESearchFormId();
        pSSysViewPanelItemBase.resetPSDESearchFormName();
        pSSysViewPanelItemBase.resetPSDEToolbarId();
        pSSysViewPanelItemBase.resetPSDEToolbarName();
        pSSysViewPanelItemBase.resetPSDETreeViewId();
        pSSysViewPanelItemBase.resetPSDETreeViewName();
        pSSysViewPanelItemBase.resetPSDEUAGroupId();
        pSSysViewPanelItemBase.resetPSDEUAGroupName();
        pSSysViewPanelItemBase.resetPSDEUIActionId();
        pSSysViewPanelItemBase.resetPSDEUIActionName();
        pSSysViewPanelItemBase.resetPSDEViewBaseId();
        pSSysViewPanelItemBase.resetPSDEViewBaseName();
        pSSysViewPanelItemBase.resetPSDEWizardId();
        pSSysViewPanelItemBase.resetPSDEWizardName();
        pSSysViewPanelItemBase.resetPSSysCalendarId();
        pSSysViewPanelItemBase.resetPSSysCalendarName();
        pSSysViewPanelItemBase.resetPSSysCounterId();
        pSSysViewPanelItemBase.resetPSSysCounterName();
        pSSysViewPanelItemBase.resetPSSysCssId();
        pSSysViewPanelItemBase.resetPSSysCssName();
        pSSysViewPanelItemBase.resetPSSysDashboardId();
        pSSysViewPanelItemBase.resetPSSysDashboardName();
        pSSysViewPanelItemBase.resetPSSysDynaModelId();
        pSSysViewPanelItemBase.resetPSSysDynaModelName();
        pSSysViewPanelItemBase.resetPSSysEditorStyleId();
        pSSysViewPanelItemBase.resetPSSysEditorStyleName();
        pSSysViewPanelItemBase.resetPSSysImageId();
        pSSysViewPanelItemBase.resetPSSysImageName();
        pSSysViewPanelItemBase.resetPSSysMapViewId();
        pSSysViewPanelItemBase.resetPSSysMapViewName();
        pSSysViewPanelItemBase.resetPSSysPFPluginId();
        pSSysViewPanelItemBase.resetPSSysPFPluginName();
        pSSysViewPanelItemBase.resetPSSysResourceId();
        pSSysViewPanelItemBase.resetPSSysResourceName();
        pSSysViewPanelItemBase.resetPSSysSearchBarId();
        pSSysViewPanelItemBase.resetPSSysSearchBarName();
        pSSysViewPanelItemBase.resetPSSysViewPanelId();
        pSSysViewPanelItemBase.resetPSSysViewPanelItemId();
        pSSysViewPanelItemBase.resetPSSysViewPanelItemName();
        pSSysViewPanelItemBase.resetPSSysViewPanelName();
        pSSysViewPanelItemBase.resetRawContent();
        pSSysViewPanelItemBase.resetRawCssStyle();
        pSSysViewPanelItemBase.resetRawServiceMethod();
        pSSysViewPanelItemBase.resetRawServiceUrl();
        pSSysViewPanelItemBase.resetReadOnlyMode();
        pSSysViewPanelItemBase.resetRefCtrl2Name();
        pSSysViewPanelItemBase.resetRefCtrl2Usage();
        pSSysViewPanelItemBase.resetRefCtrl2UsageText();
        pSSysViewPanelItemBase.resetRefCtrlName();
        pSSysViewPanelItemBase.resetRefCtrlUsage();
        pSSysViewPanelItemBase.resetRefCtrlUsageText();
        pSSysViewPanelItemBase.resetRefLinkPSDEViewId();
        pSSysViewPanelItemBase.resetRefLinkPSDEViewName();
        pSSysViewPanelItemBase.resetRefPickupPSDEViewId();
        pSSysViewPanelItemBase.resetRefPickupPSDEViewName();
        pSSysViewPanelItemBase.resetRefPSDEACModeId();
        pSSysViewPanelItemBase.resetRefPSDEACModeName();
        pSSysViewPanelItemBase.resetRefPSDEDataSetId();
        pSSysViewPanelItemBase.resetRefPSDEDataSetName();
        pSSysViewPanelItemBase.resetRefPSDEId();
        pSSysViewPanelItemBase.resetRefPSDEName();
        pSSysViewPanelItemBase.resetRenderMode();
        pSSysViewPanelItemBase.resetRenderModeText();
        pSSysViewPanelItemBase.resetResetItemName();
        pSSysViewPanelItemBase.resetRightPos();
        pSSysViewPanelItemBase.resetRowSpan();
        pSSysViewPanelItemBase.resetShowCaption();
        pSSysViewPanelItemBase.resetSpacingBottom();
        pSSysViewPanelItemBase.resetSpacingLeft();
        pSSysViewPanelItemBase.resetSpacingRight();
        pSSysViewPanelItemBase.resetSpacingTop();
        pSSysViewPanelItemBase.resetSwapMode();
        pSSysViewPanelItemBase.resetTabIndex();
        pSSysViewPanelItemBase.resetTargetId();
        pSSysViewPanelItemBase.resetTargetName();
        pSSysViewPanelItemBase.resetTargetType();
        pSSysViewPanelItemBase.resetTemplateMode();
        pSSysViewPanelItemBase.resetTipPSLanResId();
        pSSysViewPanelItemBase.resetTipPSLanResName();
        pSSysViewPanelItemBase.resetTitleBarCloseMode();
        pSSysViewPanelItemBase.resetToggleMode();
        pSSysViewPanelItemBase.resetTooltipInfo();
        pSSysViewPanelItemBase.resetTopPos();
        pSSysViewPanelItemBase.resetUpdateDate();
        pSSysViewPanelItemBase.resetUpdateMan();
        pSSysViewPanelItemBase.resetUserTag();
        pSSysViewPanelItemBase.resetUserTag2();
        pSSysViewPanelItemBase.resetVAlign();
        pSSysViewPanelItemBase.resetVAlignSelf();
        pSSysViewPanelItemBase.resetValueFormat();
        pSSysViewPanelItemBase.resetValueItemName();
        pSSysViewPanelItemBase.resetVisibleLogic();
        pSSysViewPanelItemBase.resetWidth();
        pSSysViewPanelItemBase.resetWidthMode();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActiveDataModeDirty()) {
            hashMap.put(FIELD_ACTIVEDATAMODE, this.getActiveDataMode());
        }
        if (!bl || this.isADPSDELogicIdDirty()) {
            hashMap.put(FIELD_ADPSDELOGICID, this.getADPSDELogicId());
        }
        if (!bl || this.isADPSDELogicNameDirty()) {
            hashMap.put(FIELD_ADPSDELOGICNAME, this.getADPSDELogicName());
        }
        if (!bl || this.isAL_PosDirty()) {
            hashMap.put(FIELD_AL_POS, this.getAL_Pos());
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
        if (!bl || this.isBottomPosDirty()) {
            hashMap.put(FIELD_BOTTOMPOS, this.getBottomPos());
        }
        if (!bl || this.isBtnActionTypeDirty()) {
            hashMap.put(FIELD_BTNACTIONTYPE, this.getBtnActionType());
        }
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
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
        if (!bl || this.isCaptionPosDirty()) {
            hashMap.put(FIELD_CAPTIONPOS, this.getCaptionPos());
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
        if (!bl || this.isColIdDirty()) {
            hashMap.put(FIELD_COLID, this.getColId());
        }
        if (!bl || this.isCollapsibleFlagDirty()) {
            hashMap.put(FIELD_COLLAPSIBLEFLAG, this.getCollapsibleFlag());
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
        if (!bl || this.isCounterIdDirty()) {
            hashMap.put(FIELD_COUNTERID, this.getCounterId());
        }
        if (!bl || this.isCounterModeDirty()) {
            hashMap.put(FIELD_COUNTERMODE, this.getCounterMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCssIdDirty()) {
            hashMap.put(FIELD_CSSID, this.getCssId());
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
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isCtrlWidthDirty()) {
            hashMap.put(FIELD_CTRLWIDTH, this.getCtrlWidth());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataPanelModeDirty()) {
            hashMap.put(FIELD_DATAPANELMODE, this.getDataPanelMode());
        }
        if (!bl || this.isDataSourceDirty()) {
            hashMap.put(FIELD_DATASOURCE, this.getDataSource());
        }
        if (!bl || this.isDataSourceTextDirty()) {
            hashMap.put(FIELD_DATASOURCETEXT, this.getDataSourceText());
        }
        if (!bl || this.isDetailStyleDirty()) {
            hashMap.put(FIELD_DETAILSTYLE, this.getDetailStyle());
        }
        if (!bl || this.isDetailStyleTextDirty()) {
            hashMap.put(FIELD_DETAILSTYLETEXT, this.getDetailStyleText());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
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
        if (!bl || this.isEnableLogicDirty()) {
            hashMap.put(FIELD_ENABLELOGIC, this.getEnableLogic());
        }
        if (!bl || this.isFieldNameDirty()) {
            hashMap.put(FIELD_FIELDNAME, this.getFieldName());
        }
        if (!bl || this.isFieldStatesDirty()) {
            hashMap.put(FIELD_FIELDSTATES, this.getFieldStates());
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
        if (!bl || this.isGetDataTimerDirty()) {
            hashMap.put(FIELD_GETDATATIMER, this.getGetDataTimer());
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
        if (!bl || this.isItemParamDirty()) {
            hashMap.put(FIELD_ITEMPARAM, this.getItemParam());
        }
        if (!bl || this.isItemParam10Dirty()) {
            hashMap.put(FIELD_ITEMPARAM10, this.getItemParam10());
        }
        if (!bl || this.isItemParam11Dirty()) {
            hashMap.put(FIELD_ITEMPARAM11, this.getItemParam11());
        }
        if (!bl || this.isItemParam12Dirty()) {
            hashMap.put(FIELD_ITEMPARAM12, this.getItemParam12());
        }
        if (!bl || this.isItemParam2Dirty()) {
            hashMap.put(FIELD_ITEMPARAM2, this.getItemParam2());
        }
        if (!bl || this.isItemParam3Dirty()) {
            hashMap.put(FIELD_ITEMPARAM3, this.getItemParam3());
        }
        if (!bl || this.isItemParam4Dirty()) {
            hashMap.put(FIELD_ITEMPARAM4, this.getItemParam4());
        }
        if (!bl || this.isItemParam5Dirty()) {
            hashMap.put(FIELD_ITEMPARAM5, this.getItemParam5());
        }
        if (!bl || this.isItemParam6Dirty()) {
            hashMap.put(FIELD_ITEMPARAM6, this.getItemParam6());
        }
        if (!bl || this.isItemParam7Dirty()) {
            hashMap.put(FIELD_ITEMPARAM7, this.getItemParam7());
        }
        if (!bl || this.isItemParam8Dirty()) {
            hashMap.put(FIELD_ITEMPARAM8, this.getItemParam8());
        }
        if (!bl || this.isItemParam9Dirty()) {
            hashMap.put(FIELD_ITEMPARAM9, this.getItemParam9());
        }
        if (!bl || this.isItemParamsDirty()) {
            hashMap.put(FIELD_ITEMPARAMS, this.getItemParams());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isLabelDynaClassDirty()) {
            hashMap.put(FIELD_LABELDYNACLASS, this.getLabelDynaClass());
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
        if (!bl || this.isLableCssIdDirty()) {
            hashMap.put(FIELD_LABLECSSID, this.getLableCssId());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobFlagDirty()) {
            hashMap.put(FIELD_MOBFLAG, this.getMobFlag());
        }
        if (!bl || this.isOpenPSAppViewIdDirty()) {
            hashMap.put(FIELD_OPENPSAPPVIEWID, this.getOpenPSAppViewId());
        }
        if (!bl || this.isOpenPSAppViewNameDirty()) {
            hashMap.put(FIELD_OPENPSAPPVIEWNAME, this.getOpenPSAppViewName());
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
        if (!bl || this.isOrientationModeDirty()) {
            hashMap.put(FIELD_ORIENTATIONMODE, this.getOrientationMode());
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
        if (!bl || this.isPLayoutModeDirty()) {
            hashMap.put(FIELD_PLAYOUTMODE, this.getPLayoutMode());
        }
        if (!bl || this.isPPSSysViewPanelItemIdDirty()) {
            hashMap.put(FIELD_PPSSYSVIEWPANELITEMID, this.getPPSSysViewPanelItemId());
        }
        if (!bl || this.isPPSSysViewPanelItemNameDirty()) {
            hashMap.put(FIELD_PPSSYSVIEWPANELITEMNAME, this.getPPSSysViewPanelItemName());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPreviewHtmlDirty()) {
            hashMap.put(FIELD_PREVIEWHTML, this.getPreviewHtml());
        }
        if (!bl || this.isPSACHandlerIdDirty()) {
            hashMap.put(FIELD_PSACHANDLERID, this.getPSACHandlerId());
        }
        if (!bl || this.isPSACHandlerNameDirty()) {
            hashMap.put(FIELD_PSACHANDLERNAME, this.getPSACHandlerName());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSCtrlIdDirty()) {
            hashMap.put(FIELD_PSCTRLID, this.getPSCtrlId());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSCtrlNameDirty()) {
            hashMap.put(FIELD_PSCTRLNAME, this.getPSCtrlName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEChartIdDirty()) {
            hashMap.put(FIELD_PSDECHARTID, this.getPSDEChartId());
        }
        if (!bl || this.isPSDEChartNameDirty()) {
            hashMap.put(FIELD_PSDECHARTNAME, this.getPSDEChartName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWID, this.getPSDEDataViewId());
        }
        if (!bl || this.isPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWNAME, this.getPSDEDataViewName());
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
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEListIdDirty()) {
            hashMap.put(FIELD_PSDELISTID, this.getPSDEListId());
        }
        if (!bl || this.isPSDEListNameDirty()) {
            hashMap.put(FIELD_PSDELISTNAME, this.getPSDEListName());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEPanelIdDirty()) {
            hashMap.put(FIELD_PSDEPANELID, this.getPSDEPanelId());
        }
        if (!bl || this.isPSDEPanelNameDirty()) {
            hashMap.put(FIELD_PSDEPANELNAME, this.getPSDEPanelName());
        }
        if (!bl || this.isPSDEReportIdDirty()) {
            hashMap.put(FIELD_PSDEREPORTID, this.getPSDEReportId());
        }
        if (!bl || this.isPSDEReportNameDirty()) {
            hashMap.put(FIELD_PSDEREPORTNAME, this.getPSDEReportName());
        }
        if (!bl || this.isPSDESearchFormIdDirty()) {
            hashMap.put(FIELD_PSDESEARCHFORMID, this.getPSDESearchFormId());
        }
        if (!bl || this.isPSDESearchFormNameDirty()) {
            hashMap.put(FIELD_PSDESEARCHFORMNAME, this.getPSDESearchFormName());
        }
        if (!bl || this.isPSDEToolbarIdDirty()) {
            hashMap.put(FIELD_PSDETOOLBARID, this.getPSDEToolbarId());
        }
        if (!bl || this.isPSDEToolbarNameDirty()) {
            hashMap.put(FIELD_PSDETOOLBARNAME, this.getPSDEToolbarName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
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
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSDEWizardIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDID, this.getPSDEWizardId());
        }
        if (!bl || this.isPSDEWizardNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDNAME, this.getPSDEWizardName());
        }
        if (!bl || this.isPSSysCalendarIdDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARID, this.getPSSysCalendarId());
        }
        if (!bl || this.isPSSysCalendarNameDirty()) {
            hashMap.put(FIELD_PSSYSCALENDARNAME, this.getPSSysCalendarName());
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
        if (!bl || this.isPSSysDashboardIdDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDID, this.getPSSysDashboardId());
        }
        if (!bl || this.isPSSysDashboardNameDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDNAME, this.getPSSysDashboardName());
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
        if (!bl || this.isPSSysMapViewIdDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWID, this.getPSSysMapViewId());
        }
        if (!bl || this.isPSSysMapViewNameDirty()) {
            hashMap.put(FIELD_PSSYSMAPVIEWNAME, this.getPSSysMapViewName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSearchBarIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARID, this.getPSSysSearchBarId());
        }
        if (!bl || this.isPSSysSearchBarNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHBARNAME, this.getPSSysSearchBarName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelItemIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMID, this.getPSSysViewPanelItemId());
        }
        if (!bl || this.isPSSysViewPanelItemNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMNAME, this.getPSSysViewPanelItemName());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
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
        if (!bl || this.isReadOnlyModeDirty()) {
            hashMap.put(FIELD_READONLYMODE, this.getReadOnlyMode());
        }
        if (!bl || this.isRefCtrl2NameDirty()) {
            hashMap.put(FIELD_REFCTRL2NAME, this.getRefCtrl2Name());
        }
        if (!bl || this.isRefCtrl2UsageDirty()) {
            hashMap.put(FIELD_REFCTRL2USAGE, this.getRefCtrl2Usage());
        }
        if (!bl || this.isRefCtrl2UsageTextDirty()) {
            hashMap.put(FIELD_REFCTRL2USAGETEXT, this.getRefCtrl2UsageText());
        }
        if (!bl || this.isRefCtrlNameDirty()) {
            hashMap.put(FIELD_REFCTRLNAME, this.getRefCtrlName());
        }
        if (!bl || this.isRefCtrlUsageDirty()) {
            hashMap.put(FIELD_REFCTRLUSAGE, this.getRefCtrlUsage());
        }
        if (!bl || this.isRefCtrlUsageTextDirty()) {
            hashMap.put(FIELD_REFCTRLUSAGETEXT, this.getRefCtrlUsageText());
        }
        if (!bl || this.isRefLinkPSDEViewIdDirty()) {
            hashMap.put(FIELD_REFLINKPSDEVIEWID, this.getRefLinkPSDEViewId());
        }
        if (!bl || this.isRefLinkPSDEViewNameDirty()) {
            hashMap.put(FIELD_REFLINKPSDEVIEWNAME, this.getRefLinkPSDEViewName());
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
        if (!bl || this.isRenderModeDirty()) {
            hashMap.put(FIELD_RENDERMODE, this.getRenderMode());
        }
        if (!bl || this.isRenderModeTextDirty()) {
            hashMap.put(FIELD_RENDERMODETEXT, this.getRenderModeText());
        }
        if (!bl || this.isResetItemNameDirty()) {
            hashMap.put(FIELD_RESETITEMNAME, this.getResetItemName());
        }
        if (!bl || this.isRightPosDirty()) {
            hashMap.put(FIELD_RIGHTPOS, this.getRightPos());
        }
        if (!bl || this.isRowSpanDirty()) {
            hashMap.put(FIELD_ROWSPAN, this.getRowSpan());
        }
        if (!bl || this.isShowCaptionDirty()) {
            hashMap.put(FIELD_SHOWCAPTION, this.getShowCaption());
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
        if (!bl || this.isTabIndexDirty()) {
            hashMap.put(FIELD_TABINDEX, this.getTabIndex());
        }
        if (!bl || this.isTargetIdDirty()) {
            hashMap.put(FIELD_TARGETID, this.getTargetId());
        }
        if (!bl || this.isTargetNameDirty()) {
            hashMap.put(FIELD_TARGETNAME, this.getTargetName());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
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
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
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
        return PSSysViewPanelItemBase.get(this, n);
    }

    private static Object get(PSSysViewPanelItemBase pSSysViewPanelItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelItemBase.getActiveDataMode();
            }
            case 1: {
                return pSSysViewPanelItemBase.getADPSDELogicId();
            }
            case 2: {
                return pSSysViewPanelItemBase.getADPSDELogicName();
            }
            case 3: {
                return pSSysViewPanelItemBase.getAL_Pos();
            }
            case 4: {
                return pSSysViewPanelItemBase.getBlankLogic();
            }
            case 5: {
                return pSSysViewPanelItemBase.getBL_Pos();
            }
            case 6: {
                return pSSysViewPanelItemBase.getBorderStyle();
            }
            case 7: {
                return pSSysViewPanelItemBase.getBottomPos();
            }
            case 8: {
                return pSSysViewPanelItemBase.getBtnActionType();
            }
            case 9: {
                return pSSysViewPanelItemBase.getBusyIndicator();
            }
            case 10: {
                return pSSysViewPanelItemBase.getCapPSLanResId();
            }
            case 11: {
                return pSSysViewPanelItemBase.getCapPSLanResName();
            }
            case 12: {
                return pSSysViewPanelItemBase.getCaption();
            }
            case 13: {
                return pSSysViewPanelItemBase.getCaptionPos();
            }
            case 14: {
                return pSSysViewPanelItemBase.getChild_Col_LG();
            }
            case 15: {
                return pSSysViewPanelItemBase.getChild_Col_MD();
            }
            case 16: {
                return pSSysViewPanelItemBase.getChild_Col_SM();
            }
            case 17: {
                return pSSysViewPanelItemBase.getChild_Col_XS();
            }
            case 18: {
                return pSSysViewPanelItemBase.getColId();
            }
            case 19: {
                return pSSysViewPanelItemBase.getCollapsibleFlag();
            }
            case 20: {
                return pSSysViewPanelItemBase.getColModel();
            }
            case 21: {
                return pSSysViewPanelItemBase.getColSpan();
            }
            case 22: {
                return pSSysViewPanelItemBase.getCol_LG();
            }
            case 23: {
                return pSSysViewPanelItemBase.getCol_LG_OS();
            }
            case 24: {
                return pSSysViewPanelItemBase.getCol_MD();
            }
            case 25: {
                return pSSysViewPanelItemBase.getCol_MD_OS();
            }
            case 26: {
                return pSSysViewPanelItemBase.getCol_SM();
            }
            case 27: {
                return pSSysViewPanelItemBase.getCol_SM_OS();
            }
            case 28: {
                return pSSysViewPanelItemBase.getCol_Width();
            }
            case 29: {
                return pSSysViewPanelItemBase.getCol_XS();
            }
            case 30: {
                return pSSysViewPanelItemBase.getCol_XS_OS();
            }
            case 31: {
                return pSSysViewPanelItemBase.getContentType();
            }
            case 32: {
                return pSSysViewPanelItemBase.getCounterId();
            }
            case 33: {
                return pSSysViewPanelItemBase.getCounterMode();
            }
            case 34: {
                return pSSysViewPanelItemBase.getCreateDate();
            }
            case 35: {
                return pSSysViewPanelItemBase.getCreateMan();
            }
            case 36: {
                return pSSysViewPanelItemBase.getCssId();
            }
            case 37: {
                return pSSysViewPanelItemBase.getCtrlDynaClass();
            }
            case 38: {
                return pSSysViewPanelItemBase.getCtrlHeight();
            }
            case 39: {
                return pSSysViewPanelItemBase.getCtrlPSSysCssId();
            }
            case 40: {
                return pSSysViewPanelItemBase.getCtrlPSSysCssName();
            }
            case 41: {
                return pSSysViewPanelItemBase.getCtrlRawCssStyle();
            }
            case 42: {
                return pSSysViewPanelItemBase.getCtrlType();
            }
            case 43: {
                return pSSysViewPanelItemBase.getCtrlWidth();
            }
            case 44: {
                return pSSysViewPanelItemBase.getCustomCode();
            }
            case 45: {
                return pSSysViewPanelItemBase.getCustomMode();
            }
            case 46: {
                return pSSysViewPanelItemBase.getDataPanelMode();
            }
            case 47: {
                return pSSysViewPanelItemBase.getDataSource();
            }
            case 48: {
                return pSSysViewPanelItemBase.getDataSourceText();
            }
            case 49: {
                return pSSysViewPanelItemBase.getDetailStyle();
            }
            case 50: {
                return pSSysViewPanelItemBase.getDetailStyleText();
            }
            case 51: {
                return pSSysViewPanelItemBase.getDynaClass();
            }
            case 52: {
                return pSSysViewPanelItemBase.getEditorType();
            }
            case 53: {
                return pSSysViewPanelItemBase.getEditorTypeName();
            }
            case 54: {
                return pSSysViewPanelItemBase.getEmptyCaption();
            }
            case 55: {
                return pSSysViewPanelItemBase.getEnableAnchor();
            }
            case 56: {
                return pSSysViewPanelItemBase.getEnableLogic();
            }
            case 57: {
                return pSSysViewPanelItemBase.getFieldName();
            }
            case 58: {
                return pSSysViewPanelItemBase.getFieldStates();
            }
            case 59: {
                return pSSysViewPanelItemBase.getFlexAlign();
            }
            case 60: {
                return pSSysViewPanelItemBase.getFlexBasis();
            }
            case 61: {
                return pSSysViewPanelItemBase.getFlexDir();
            }
            case 62: {
                return pSSysViewPanelItemBase.getFlexGrow();
            }
            case 63: {
                return pSSysViewPanelItemBase.getFlexShrink();
            }
            case 64: {
                return pSSysViewPanelItemBase.getFlexVAlign();
            }
            case 65: {
                return pSSysViewPanelItemBase.getGetDataTimer();
            }
            case 66: {
                return pSSysViewPanelItemBase.getGridRowId();
            }
            case 67: {
                return pSSysViewPanelItemBase.getHAlign();
            }
            case 68: {
                return pSSysViewPanelItemBase.getHAlignSelf();
            }
            case 69: {
                return pSSysViewPanelItemBase.getHeight();
            }
            case 70: {
                return pSSysViewPanelItemBase.getHeightMode();
            }
            case 71: {
                return pSSysViewPanelItemBase.getHtmlContent();
            }
            case 72: {
                return pSSysViewPanelItemBase.getHtmlPageUrl();
            }
            case 73: {
                return pSSysViewPanelItemBase.getIconAlign();
            }
            case 74: {
                return pSSysViewPanelItemBase.getIgnoreInput();
            }
            case 75: {
                return pSSysViewPanelItemBase.getItemParam();
            }
            case 76: {
                return pSSysViewPanelItemBase.getItemParam10();
            }
            case 77: {
                return pSSysViewPanelItemBase.getItemParam11();
            }
            case 78: {
                return pSSysViewPanelItemBase.getItemParam12();
            }
            case 79: {
                return pSSysViewPanelItemBase.getItemParam2();
            }
            case 80: {
                return pSSysViewPanelItemBase.getItemParam3();
            }
            case 81: {
                return pSSysViewPanelItemBase.getItemParam4();
            }
            case 82: {
                return pSSysViewPanelItemBase.getItemParam5();
            }
            case 83: {
                return pSSysViewPanelItemBase.getItemParam6();
            }
            case 84: {
                return pSSysViewPanelItemBase.getItemParam7();
            }
            case 85: {
                return pSSysViewPanelItemBase.getItemParam8();
            }
            case 86: {
                return pSSysViewPanelItemBase.getItemParam9();
            }
            case 87: {
                return pSSysViewPanelItemBase.getItemParams();
            }
            case 88: {
                return pSSysViewPanelItemBase.getItemType();
            }
            case 89: {
                return pSSysViewPanelItemBase.getLabelDynaClass();
            }
            case 90: {
                return pSSysViewPanelItemBase.getLabelPSSysCssId();
            }
            case 91: {
                return pSSysViewPanelItemBase.getLabelPSSysCssName();
            }
            case 92: {
                return pSSysViewPanelItemBase.getLabelRawCssStyle();
            }
            case 93: {
                return pSSysViewPanelItemBase.getLableCssId();
            }
            case 94: {
                return pSSysViewPanelItemBase.getLayoutMode();
            }
            case 95: {
                return pSSysViewPanelItemBase.getLeftPos();
            }
            case 96: {
                return pSSysViewPanelItemBase.getLogicName();
            }
            case 97: {
                return pSSysViewPanelItemBase.getMemo();
            }
            case 98: {
                return pSSysViewPanelItemBase.getMobFlag();
            }
            case 99: {
                return pSSysViewPanelItemBase.getOpenPSAppViewId();
            }
            case 100: {
                return pSSysViewPanelItemBase.getOpenPSAppViewName();
            }
            case 101: {
                return pSSysViewPanelItemBase.getOpenPSDEViewId();
            }
            case 102: {
                return pSSysViewPanelItemBase.getOpenPSDEViewName();
            }
            case 103: {
                return pSSysViewPanelItemBase.getOpenPSSysPDTViewId();
            }
            case 104: {
                return pSSysViewPanelItemBase.getOpenPSSysPDTViewName();
            }
            case 105: {
                return pSSysViewPanelItemBase.getOrderValue();
            }
            case 106: {
                return pSSysViewPanelItemBase.getOrientationMode();
            }
            case 107: {
                return pSSysViewPanelItemBase.getPHPSLanResId();
            }
            case 108: {
                return pSSysViewPanelItemBase.getPHPSLanResName();
            }
            case 109: {
                return pSSysViewPanelItemBase.getPlaceHolder();
            }
            case 110: {
                return pSSysViewPanelItemBase.getPLayoutMode();
            }
            case 111: {
                return pSSysViewPanelItemBase.getPPSSysViewPanelItemId();
            }
            case 112: {
                return pSSysViewPanelItemBase.getPPSSysViewPanelItemName();
            }
            case 113: {
                return pSSysViewPanelItemBase.getPredefinedType();
            }
            case 114: {
                return pSSysViewPanelItemBase.getPredefinedTypeText();
            }
            case 115: {
                return pSSysViewPanelItemBase.getPreviewHtml();
            }
            case 116: {
                return pSSysViewPanelItemBase.getPSACHandlerId();
            }
            case 117: {
                return pSSysViewPanelItemBase.getPSACHandlerName();
            }
            case 118: {
                return pSSysViewPanelItemBase.getPSAppMenuId();
            }
            case 119: {
                return pSSysViewPanelItemBase.getPSAppMenuName();
            }
            case 120: {
                return pSSysViewPanelItemBase.getPSCodeListId();
            }
            case 121: {
                return pSSysViewPanelItemBase.getPSCodeListName();
            }
            case 122: {
                return pSSysViewPanelItemBase.getPSCtrlId();
            }
            case 123: {
                return pSSysViewPanelItemBase.getPSCtrlLogicGroupId();
            }
            case 124: {
                return pSSysViewPanelItemBase.getPSCtrlLogicGroupName();
            }
            case 125: {
                return pSSysViewPanelItemBase.getPSCtrlName();
            }
            case 126: {
                return pSSysViewPanelItemBase.getPSDEActionId();
            }
            case 127: {
                return pSSysViewPanelItemBase.getPSDEActionName();
            }
            case 128: {
                return pSSysViewPanelItemBase.getPSDEChartId();
            }
            case 129: {
                return pSSysViewPanelItemBase.getPSDEChartName();
            }
            case 130: {
                return pSSysViewPanelItemBase.getPSDEDataSetId();
            }
            case 131: {
                return pSSysViewPanelItemBase.getPSDEDataSetName();
            }
            case 132: {
                return pSSysViewPanelItemBase.getPSDEDataViewId();
            }
            case 133: {
                return pSSysViewPanelItemBase.getPSDEDataViewName();
            }
            case 134: {
                return pSSysViewPanelItemBase.getPSDEDRId();
            }
            case 135: {
                return pSSysViewPanelItemBase.getPSDEDRItemId();
            }
            case 136: {
                return pSSysViewPanelItemBase.getPSDEDRItemName();
            }
            case 137: {
                return pSSysViewPanelItemBase.getPSDEDRName();
            }
            case 138: {
                return pSSysViewPanelItemBase.getPSDEFormId();
            }
            case 139: {
                return pSSysViewPanelItemBase.getPSDEFormName();
            }
            case 140: {
                return pSSysViewPanelItemBase.getPSDEGridId();
            }
            case 141: {
                return pSSysViewPanelItemBase.getPSDEGridName();
            }
            case 142: {
                return pSSysViewPanelItemBase.getPSDEId();
            }
            case 143: {
                return pSSysViewPanelItemBase.getPSDEListId();
            }
            case 144: {
                return pSSysViewPanelItemBase.getPSDEListName();
            }
            case 145: {
                return pSSysViewPanelItemBase.getPSDELogicId();
            }
            case 146: {
                return pSSysViewPanelItemBase.getPSDELogicName();
            }
            case 147: {
                return pSSysViewPanelItemBase.getPSDEName();
            }
            case 148: {
                return pSSysViewPanelItemBase.getPSDEPanelId();
            }
            case 149: {
                return pSSysViewPanelItemBase.getPSDEPanelName();
            }
            case 150: {
                return pSSysViewPanelItemBase.getPSDEReportId();
            }
            case 151: {
                return pSSysViewPanelItemBase.getPSDEReportName();
            }
            case 152: {
                return pSSysViewPanelItemBase.getPSDESearchFormId();
            }
            case 153: {
                return pSSysViewPanelItemBase.getPSDESearchFormName();
            }
            case 154: {
                return pSSysViewPanelItemBase.getPSDEToolbarId();
            }
            case 155: {
                return pSSysViewPanelItemBase.getPSDEToolbarName();
            }
            case 156: {
                return pSSysViewPanelItemBase.getPSDETreeViewId();
            }
            case 157: {
                return pSSysViewPanelItemBase.getPSDETreeViewName();
            }
            case 158: {
                return pSSysViewPanelItemBase.getPSDEUAGroupId();
            }
            case 159: {
                return pSSysViewPanelItemBase.getPSDEUAGroupName();
            }
            case 160: {
                return pSSysViewPanelItemBase.getPSDEUIActionId();
            }
            case 161: {
                return pSSysViewPanelItemBase.getPSDEUIActionName();
            }
            case 162: {
                return pSSysViewPanelItemBase.getPSDEViewBaseId();
            }
            case 163: {
                return pSSysViewPanelItemBase.getPSDEViewBaseName();
            }
            case 164: {
                return pSSysViewPanelItemBase.getPSDEWizardId();
            }
            case 165: {
                return pSSysViewPanelItemBase.getPSDEWizardName();
            }
            case 166: {
                return pSSysViewPanelItemBase.getPSSysCalendarId();
            }
            case 167: {
                return pSSysViewPanelItemBase.getPSSysCalendarName();
            }
            case 168: {
                return pSSysViewPanelItemBase.getPSSysCounterId();
            }
            case 169: {
                return pSSysViewPanelItemBase.getPSSysCounterName();
            }
            case 170: {
                return pSSysViewPanelItemBase.getPSSysCssId();
            }
            case 171: {
                return pSSysViewPanelItemBase.getPSSysCssName();
            }
            case 172: {
                return pSSysViewPanelItemBase.getPSSysDashboardId();
            }
            case 173: {
                return pSSysViewPanelItemBase.getPSSysDashboardName();
            }
            case 174: {
                return pSSysViewPanelItemBase.getPSSysDynaModelId();
            }
            case 175: {
                return pSSysViewPanelItemBase.getPSSysDynaModelName();
            }
            case 176: {
                return pSSysViewPanelItemBase.getPSSysEditorStyleId();
            }
            case 177: {
                return pSSysViewPanelItemBase.getPSSysEditorStyleName();
            }
            case 178: {
                return pSSysViewPanelItemBase.getPSSysImageId();
            }
            case 179: {
                return pSSysViewPanelItemBase.getPSSysImageName();
            }
            case 180: {
                return pSSysViewPanelItemBase.getPSSysMapViewId();
            }
            case 181: {
                return pSSysViewPanelItemBase.getPSSysMapViewName();
            }
            case 182: {
                return pSSysViewPanelItemBase.getPSSysPFPluginId();
            }
            case 183: {
                return pSSysViewPanelItemBase.getPSSysPFPluginName();
            }
            case 184: {
                return pSSysViewPanelItemBase.getPSSysResourceId();
            }
            case 185: {
                return pSSysViewPanelItemBase.getPSSysResourceName();
            }
            case 186: {
                return pSSysViewPanelItemBase.getPSSysSearchBarId();
            }
            case 187: {
                return pSSysViewPanelItemBase.getPSSysSearchBarName();
            }
            case 188: {
                return pSSysViewPanelItemBase.getPSSysViewPanelId();
            }
            case 189: {
                return pSSysViewPanelItemBase.getPSSysViewPanelItemId();
            }
            case 190: {
                return pSSysViewPanelItemBase.getPSSysViewPanelItemName();
            }
            case 191: {
                return pSSysViewPanelItemBase.getPSSysViewPanelName();
            }
            case 192: {
                return pSSysViewPanelItemBase.getRawContent();
            }
            case 193: {
                return pSSysViewPanelItemBase.getRawCssStyle();
            }
            case 194: {
                return pSSysViewPanelItemBase.getRawServiceMethod();
            }
            case 195: {
                return pSSysViewPanelItemBase.getRawServiceUrl();
            }
            case 196: {
                return pSSysViewPanelItemBase.getReadOnlyMode();
            }
            case 197: {
                return pSSysViewPanelItemBase.getRefCtrl2Name();
            }
            case 198: {
                return pSSysViewPanelItemBase.getRefCtrl2Usage();
            }
            case 199: {
                return pSSysViewPanelItemBase.getRefCtrl2UsageText();
            }
            case 200: {
                return pSSysViewPanelItemBase.getRefCtrlName();
            }
            case 201: {
                return pSSysViewPanelItemBase.getRefCtrlUsage();
            }
            case 202: {
                return pSSysViewPanelItemBase.getRefCtrlUsageText();
            }
            case 203: {
                return pSSysViewPanelItemBase.getRefLinkPSDEViewId();
            }
            case 204: {
                return pSSysViewPanelItemBase.getRefLinkPSDEViewName();
            }
            case 205: {
                return pSSysViewPanelItemBase.getRefPickupPSDEViewId();
            }
            case 206: {
                return pSSysViewPanelItemBase.getRefPickupPSDEViewName();
            }
            case 207: {
                return pSSysViewPanelItemBase.getRefPSDEACModeId();
            }
            case 208: {
                return pSSysViewPanelItemBase.getRefPSDEACModeName();
            }
            case 209: {
                return pSSysViewPanelItemBase.getRefPSDEDataSetId();
            }
            case 210: {
                return pSSysViewPanelItemBase.getRefPSDEDataSetName();
            }
            case 211: {
                return pSSysViewPanelItemBase.getRefPSDEId();
            }
            case 212: {
                return pSSysViewPanelItemBase.getRefPSDEName();
            }
            case 213: {
                return pSSysViewPanelItemBase.getRenderMode();
            }
            case 214: {
                return pSSysViewPanelItemBase.getRenderModeText();
            }
            case 215: {
                return pSSysViewPanelItemBase.getResetItemName();
            }
            case 216: {
                return pSSysViewPanelItemBase.getRightPos();
            }
            case 217: {
                return pSSysViewPanelItemBase.getRowSpan();
            }
            case 218: {
                return pSSysViewPanelItemBase.getShowCaption();
            }
            case 219: {
                return pSSysViewPanelItemBase.getSpacingBottom();
            }
            case 220: {
                return pSSysViewPanelItemBase.getSpacingLeft();
            }
            case 221: {
                return pSSysViewPanelItemBase.getSpacingRight();
            }
            case 222: {
                return pSSysViewPanelItemBase.getSpacingTop();
            }
            case 223: {
                return pSSysViewPanelItemBase.getSwapMode();
            }
            case 224: {
                return pSSysViewPanelItemBase.getTabIndex();
            }
            case 225: {
                return pSSysViewPanelItemBase.getTargetId();
            }
            case 226: {
                return pSSysViewPanelItemBase.getTargetName();
            }
            case 227: {
                return pSSysViewPanelItemBase.getTargetType();
            }
            case 228: {
                return pSSysViewPanelItemBase.getTemplateMode();
            }
            case 229: {
                return pSSysViewPanelItemBase.getTipPSLanResId();
            }
            case 230: {
                return pSSysViewPanelItemBase.getTipPSLanResName();
            }
            case 231: {
                return pSSysViewPanelItemBase.getTitleBarCloseMode();
            }
            case 232: {
                return pSSysViewPanelItemBase.getToggleMode();
            }
            case 233: {
                return pSSysViewPanelItemBase.getTooltipInfo();
            }
            case 234: {
                return pSSysViewPanelItemBase.getTopPos();
            }
            case 235: {
                return pSSysViewPanelItemBase.getUpdateDate();
            }
            case 236: {
                return pSSysViewPanelItemBase.getUpdateMan();
            }
            case 237: {
                return pSSysViewPanelItemBase.getUserTag();
            }
            case 238: {
                return pSSysViewPanelItemBase.getUserTag2();
            }
            case 239: {
                return pSSysViewPanelItemBase.getVAlign();
            }
            case 240: {
                return pSSysViewPanelItemBase.getVAlignSelf();
            }
            case 241: {
                return pSSysViewPanelItemBase.getValueFormat();
            }
            case 242: {
                return pSSysViewPanelItemBase.getValueItemName();
            }
            case 243: {
                return pSSysViewPanelItemBase.getVisibleLogic();
            }
            case 244: {
                return pSSysViewPanelItemBase.getWidth();
            }
            case 245: {
                return pSSysViewPanelItemBase.getWidthMode();
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
        PSSysViewPanelItemBase.set(this, n, object);
    }

    private static void set(PSSysViewPanelItemBase pSSysViewPanelItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelItemBase.setActiveDataMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysViewPanelItemBase.setADPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysViewPanelItemBase.setADPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysViewPanelItemBase.setAL_Pos(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysViewPanelItemBase.setBlankLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysViewPanelItemBase.setBL_Pos(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysViewPanelItemBase.setBorderStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysViewPanelItemBase.setBottomPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysViewPanelItemBase.setBtnActionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysViewPanelItemBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysViewPanelItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysViewPanelItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysViewPanelItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysViewPanelItemBase.setCaptionPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysViewPanelItemBase.setChild_Col_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysViewPanelItemBase.setChild_Col_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysViewPanelItemBase.setChild_Col_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysViewPanelItemBase.setChild_Col_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysViewPanelItemBase.setColId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysViewPanelItemBase.setCollapsibleFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysViewPanelItemBase.setColModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysViewPanelItemBase.setColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysViewPanelItemBase.setCol_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSysViewPanelItemBase.setCol_LG_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSSysViewPanelItemBase.setCol_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysViewPanelItemBase.setCol_MD_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSysViewPanelItemBase.setCol_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysViewPanelItemBase.setCol_SM_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysViewPanelItemBase.setCol_Width(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysViewPanelItemBase.setCol_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSysViewPanelItemBase.setCol_XS_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysViewPanelItemBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysViewPanelItemBase.setCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysViewPanelItemBase.setCounterMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSSysViewPanelItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSSysViewPanelItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysViewPanelItemBase.setCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysViewPanelItemBase.setCtrlDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysViewPanelItemBase.setCtrlHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSSysViewPanelItemBase.setCtrlPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysViewPanelItemBase.setCtrlPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysViewPanelItemBase.setCtrlRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysViewPanelItemBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysViewPanelItemBase.setCtrlWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSSysViewPanelItemBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysViewPanelItemBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSSysViewPanelItemBase.setDataPanelMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysViewPanelItemBase.setDataSource(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysViewPanelItemBase.setDataSourceText(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysViewPanelItemBase.setDetailStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysViewPanelItemBase.setDetailStyleText(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysViewPanelItemBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysViewPanelItemBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysViewPanelItemBase.setEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysViewPanelItemBase.setEmptyCaption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSSysViewPanelItemBase.setEnableAnchor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 56: {
                pSSysViewPanelItemBase.setEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSSysViewPanelItemBase.setFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysViewPanelItemBase.setFieldStates(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSSysViewPanelItemBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysViewPanelItemBase.setFlexBasis(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 61: {
                pSSysViewPanelItemBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysViewPanelItemBase.setFlexGrow(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 63: {
                pSSysViewPanelItemBase.setFlexShrink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 64: {
                pSSysViewPanelItemBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysViewPanelItemBase.setGetDataTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 66: {
                pSSysViewPanelItemBase.setGridRowId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 67: {
                pSSysViewPanelItemBase.setHAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysViewPanelItemBase.setHAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSSysViewPanelItemBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 70: {
                pSSysViewPanelItemBase.setHeightMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSSysViewPanelItemBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 72: {
                pSSysViewPanelItemBase.setHtmlPageUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSSysViewPanelItemBase.setIconAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSSysViewPanelItemBase.setIgnoreInput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 75: {
                pSSysViewPanelItemBase.setItemParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSSysViewPanelItemBase.setItemParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 77: {
                pSSysViewPanelItemBase.setItemParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 78: {
                pSSysViewPanelItemBase.setItemParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 79: {
                pSSysViewPanelItemBase.setItemParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSSysViewPanelItemBase.setItemParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSSysViewPanelItemBase.setItemParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSSysViewPanelItemBase.setItemParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 83: {
                pSSysViewPanelItemBase.setItemParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 84: {
                pSSysViewPanelItemBase.setItemParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 85: {
                pSSysViewPanelItemBase.setItemParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 86: {
                pSSysViewPanelItemBase.setItemParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 87: {
                pSSysViewPanelItemBase.setItemParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 88: {
                pSSysViewPanelItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 89: {
                pSSysViewPanelItemBase.setLabelDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSSysViewPanelItemBase.setLabelPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSSysViewPanelItemBase.setLabelPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSSysViewPanelItemBase.setLabelRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSSysViewPanelItemBase.setLableCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSSysViewPanelItemBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSSysViewPanelItemBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 96: {
                pSSysViewPanelItemBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSSysViewPanelItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSSysViewPanelItemBase.setMobFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 99: {
                pSSysViewPanelItemBase.setOpenPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSSysViewPanelItemBase.setOpenPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSSysViewPanelItemBase.setOpenPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSSysViewPanelItemBase.setOpenPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSSysViewPanelItemBase.setOpenPSSysPDTViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSSysViewPanelItemBase.setOpenPSSysPDTViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSSysViewPanelItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 106: {
                pSSysViewPanelItemBase.setOrientationMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSSysViewPanelItemBase.setPHPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSSysViewPanelItemBase.setPHPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSSysViewPanelItemBase.setPlaceHolder(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSSysViewPanelItemBase.setPLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSSysViewPanelItemBase.setPPSSysViewPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSSysViewPanelItemBase.setPPSSysViewPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSSysViewPanelItemBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSSysViewPanelItemBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSSysViewPanelItemBase.setPreviewHtml(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSSysViewPanelItemBase.setPSACHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSSysViewPanelItemBase.setPSACHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSSysViewPanelItemBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSSysViewPanelItemBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSSysViewPanelItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSSysViewPanelItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSSysViewPanelItemBase.setPSCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSSysViewPanelItemBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSSysViewPanelItemBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSSysViewPanelItemBase.setPSCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSSysViewPanelItemBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSSysViewPanelItemBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSSysViewPanelItemBase.setPSDEChartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSSysViewPanelItemBase.setPSDEChartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSSysViewPanelItemBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSSysViewPanelItemBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSSysViewPanelItemBase.setPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSSysViewPanelItemBase.setPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSSysViewPanelItemBase.setPSDEDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSSysViewPanelItemBase.setPSDEDRItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 136: {
                pSSysViewPanelItemBase.setPSDEDRItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 137: {
                pSSysViewPanelItemBase.setPSDEDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSSysViewPanelItemBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSSysViewPanelItemBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 140: {
                pSSysViewPanelItemBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 141: {
                pSSysViewPanelItemBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSSysViewPanelItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSSysViewPanelItemBase.setPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 144: {
                pSSysViewPanelItemBase.setPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 145: {
                pSSysViewPanelItemBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 146: {
                pSSysViewPanelItemBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 147: {
                pSSysViewPanelItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 148: {
                pSSysViewPanelItemBase.setPSDEPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 149: {
                pSSysViewPanelItemBase.setPSDEPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 150: {
                pSSysViewPanelItemBase.setPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 151: {
                pSSysViewPanelItemBase.setPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 152: {
                pSSysViewPanelItemBase.setPSDESearchFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 153: {
                pSSysViewPanelItemBase.setPSDESearchFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 154: {
                pSSysViewPanelItemBase.setPSDEToolbarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 155: {
                pSSysViewPanelItemBase.setPSDEToolbarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 156: {
                pSSysViewPanelItemBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 157: {
                pSSysViewPanelItemBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 158: {
                pSSysViewPanelItemBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 159: {
                pSSysViewPanelItemBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 160: {
                pSSysViewPanelItemBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 161: {
                pSSysViewPanelItemBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 162: {
                pSSysViewPanelItemBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 163: {
                pSSysViewPanelItemBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 164: {
                pSSysViewPanelItemBase.setPSDEWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 165: {
                pSSysViewPanelItemBase.setPSDEWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 166: {
                pSSysViewPanelItemBase.setPSSysCalendarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 167: {
                pSSysViewPanelItemBase.setPSSysCalendarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 168: {
                pSSysViewPanelItemBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 169: {
                pSSysViewPanelItemBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 170: {
                pSSysViewPanelItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 171: {
                pSSysViewPanelItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 172: {
                pSSysViewPanelItemBase.setPSSysDashboardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 173: {
                pSSysViewPanelItemBase.setPSSysDashboardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 174: {
                pSSysViewPanelItemBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 175: {
                pSSysViewPanelItemBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 176: {
                pSSysViewPanelItemBase.setPSSysEditorStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 177: {
                pSSysViewPanelItemBase.setPSSysEditorStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 178: {
                pSSysViewPanelItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 179: {
                pSSysViewPanelItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 180: {
                pSSysViewPanelItemBase.setPSSysMapViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 181: {
                pSSysViewPanelItemBase.setPSSysMapViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 182: {
                pSSysViewPanelItemBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 183: {
                pSSysViewPanelItemBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 184: {
                pSSysViewPanelItemBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 185: {
                pSSysViewPanelItemBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 186: {
                pSSysViewPanelItemBase.setPSSysSearchBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 187: {
                pSSysViewPanelItemBase.setPSSysSearchBarName(DataObject.getStringValue((Object)object));
                return;
            }
            case 188: {
                pSSysViewPanelItemBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 189: {
                pSSysViewPanelItemBase.setPSSysViewPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 190: {
                pSSysViewPanelItemBase.setPSSysViewPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 191: {
                pSSysViewPanelItemBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 192: {
                pSSysViewPanelItemBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 193: {
                pSSysViewPanelItemBase.setRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 194: {
                pSSysViewPanelItemBase.setRawServiceMethod(DataObject.getStringValue((Object)object));
                return;
            }
            case 195: {
                pSSysViewPanelItemBase.setRawServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 196: {
                pSSysViewPanelItemBase.setReadOnlyMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 197: {
                pSSysViewPanelItemBase.setRefCtrl2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 198: {
                pSSysViewPanelItemBase.setRefCtrl2Usage(DataObject.getStringValue((Object)object));
                return;
            }
            case 199: {
                pSSysViewPanelItemBase.setRefCtrl2UsageText(DataObject.getStringValue((Object)object));
                return;
            }
            case 200: {
                pSSysViewPanelItemBase.setRefCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 201: {
                pSSysViewPanelItemBase.setRefCtrlUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 202: {
                pSSysViewPanelItemBase.setRefCtrlUsageText(DataObject.getStringValue((Object)object));
                return;
            }
            case 203: {
                pSSysViewPanelItemBase.setRefLinkPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 204: {
                pSSysViewPanelItemBase.setRefLinkPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 205: {
                pSSysViewPanelItemBase.setRefPickupPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 206: {
                pSSysViewPanelItemBase.setRefPickupPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 207: {
                pSSysViewPanelItemBase.setRefPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 208: {
                pSSysViewPanelItemBase.setRefPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 209: {
                pSSysViewPanelItemBase.setRefPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 210: {
                pSSysViewPanelItemBase.setRefPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 211: {
                pSSysViewPanelItemBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 212: {
                pSSysViewPanelItemBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 213: {
                pSSysViewPanelItemBase.setRenderMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 214: {
                pSSysViewPanelItemBase.setRenderModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 215: {
                pSSysViewPanelItemBase.setResetItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 216: {
                pSSysViewPanelItemBase.setRightPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 217: {
                pSSysViewPanelItemBase.setRowSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 218: {
                pSSysViewPanelItemBase.setShowCaption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 219: {
                pSSysViewPanelItemBase.setSpacingBottom(DataObject.getStringValue((Object)object));
                return;
            }
            case 220: {
                pSSysViewPanelItemBase.setSpacingLeft(DataObject.getStringValue((Object)object));
                return;
            }
            case 221: {
                pSSysViewPanelItemBase.setSpacingRight(DataObject.getStringValue((Object)object));
                return;
            }
            case 222: {
                pSSysViewPanelItemBase.setSpacingTop(DataObject.getStringValue((Object)object));
                return;
            }
            case 223: {
                pSSysViewPanelItemBase.setSwapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 224: {
                pSSysViewPanelItemBase.setTabIndex(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 225: {
                pSSysViewPanelItemBase.setTargetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 226: {
                pSSysViewPanelItemBase.setTargetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 227: {
                pSSysViewPanelItemBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 228: {
                pSSysViewPanelItemBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 229: {
                pSSysViewPanelItemBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 230: {
                pSSysViewPanelItemBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 231: {
                pSSysViewPanelItemBase.setTitleBarCloseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 232: {
                pSSysViewPanelItemBase.setToggleMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 233: {
                pSSysViewPanelItemBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 234: {
                pSSysViewPanelItemBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 235: {
                pSSysViewPanelItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 236: {
                pSSysViewPanelItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 237: {
                pSSysViewPanelItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 238: {
                pSSysViewPanelItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 239: {
                pSSysViewPanelItemBase.setVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 240: {
                pSSysViewPanelItemBase.setVAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 241: {
                pSSysViewPanelItemBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 242: {
                pSSysViewPanelItemBase.setValueItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 243: {
                pSSysViewPanelItemBase.setVisibleLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 244: {
                pSSysViewPanelItemBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 245: {
                pSSysViewPanelItemBase.setWidthMode(DataObject.getStringValue((Object)object));
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
        return PSSysViewPanelItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysViewPanelItemBase pSSysViewPanelItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelItemBase.getActiveDataMode() == null;
            }
            case 1: {
                return pSSysViewPanelItemBase.getADPSDELogicId() == null;
            }
            case 2: {
                return pSSysViewPanelItemBase.getADPSDELogicName() == null;
            }
            case 3: {
                return pSSysViewPanelItemBase.getAL_Pos() == null;
            }
            case 4: {
                return pSSysViewPanelItemBase.getBlankLogic() == null;
            }
            case 5: {
                return pSSysViewPanelItemBase.getBL_Pos() == null;
            }
            case 6: {
                return pSSysViewPanelItemBase.getBorderStyle() == null;
            }
            case 7: {
                return pSSysViewPanelItemBase.getBottomPos() == null;
            }
            case 8: {
                return pSSysViewPanelItemBase.getBtnActionType() == null;
            }
            case 9: {
                return pSSysViewPanelItemBase.getBusyIndicator() == null;
            }
            case 10: {
                return pSSysViewPanelItemBase.getCapPSLanResId() == null;
            }
            case 11: {
                return pSSysViewPanelItemBase.getCapPSLanResName() == null;
            }
            case 12: {
                return pSSysViewPanelItemBase.getCaption() == null;
            }
            case 13: {
                return pSSysViewPanelItemBase.getCaptionPos() == null;
            }
            case 14: {
                return pSSysViewPanelItemBase.getChild_Col_LG() == null;
            }
            case 15: {
                return pSSysViewPanelItemBase.getChild_Col_MD() == null;
            }
            case 16: {
                return pSSysViewPanelItemBase.getChild_Col_SM() == null;
            }
            case 17: {
                return pSSysViewPanelItemBase.getChild_Col_XS() == null;
            }
            case 18: {
                return pSSysViewPanelItemBase.getColId() == null;
            }
            case 19: {
                return pSSysViewPanelItemBase.getCollapsibleFlag() == null;
            }
            case 20: {
                return pSSysViewPanelItemBase.getColModel() == null;
            }
            case 21: {
                return pSSysViewPanelItemBase.getColSpan() == null;
            }
            case 22: {
                return pSSysViewPanelItemBase.getCol_LG() == null;
            }
            case 23: {
                return pSSysViewPanelItemBase.getCol_LG_OS() == null;
            }
            case 24: {
                return pSSysViewPanelItemBase.getCol_MD() == null;
            }
            case 25: {
                return pSSysViewPanelItemBase.getCol_MD_OS() == null;
            }
            case 26: {
                return pSSysViewPanelItemBase.getCol_SM() == null;
            }
            case 27: {
                return pSSysViewPanelItemBase.getCol_SM_OS() == null;
            }
            case 28: {
                return pSSysViewPanelItemBase.getCol_Width() == null;
            }
            case 29: {
                return pSSysViewPanelItemBase.getCol_XS() == null;
            }
            case 30: {
                return pSSysViewPanelItemBase.getCol_XS_OS() == null;
            }
            case 31: {
                return pSSysViewPanelItemBase.getContentType() == null;
            }
            case 32: {
                return pSSysViewPanelItemBase.getCounterId() == null;
            }
            case 33: {
                return pSSysViewPanelItemBase.getCounterMode() == null;
            }
            case 34: {
                return pSSysViewPanelItemBase.getCreateDate() == null;
            }
            case 35: {
                return pSSysViewPanelItemBase.getCreateMan() == null;
            }
            case 36: {
                return pSSysViewPanelItemBase.getCssId() == null;
            }
            case 37: {
                return pSSysViewPanelItemBase.getCtrlDynaClass() == null;
            }
            case 38: {
                return pSSysViewPanelItemBase.getCtrlHeight() == null;
            }
            case 39: {
                return pSSysViewPanelItemBase.getCtrlPSSysCssId() == null;
            }
            case 40: {
                return pSSysViewPanelItemBase.getCtrlPSSysCssName() == null;
            }
            case 41: {
                return pSSysViewPanelItemBase.getCtrlRawCssStyle() == null;
            }
            case 42: {
                return pSSysViewPanelItemBase.getCtrlType() == null;
            }
            case 43: {
                return pSSysViewPanelItemBase.getCtrlWidth() == null;
            }
            case 44: {
                return pSSysViewPanelItemBase.getCustomCode() == null;
            }
            case 45: {
                return pSSysViewPanelItemBase.getCustomMode() == null;
            }
            case 46: {
                return pSSysViewPanelItemBase.getDataPanelMode() == null;
            }
            case 47: {
                return pSSysViewPanelItemBase.getDataSource() == null;
            }
            case 48: {
                return pSSysViewPanelItemBase.getDataSourceText() == null;
            }
            case 49: {
                return pSSysViewPanelItemBase.getDetailStyle() == null;
            }
            case 50: {
                return pSSysViewPanelItemBase.getDetailStyleText() == null;
            }
            case 51: {
                return pSSysViewPanelItemBase.getDynaClass() == null;
            }
            case 52: {
                return pSSysViewPanelItemBase.getEditorType() == null;
            }
            case 53: {
                return pSSysViewPanelItemBase.getEditorTypeName() == null;
            }
            case 54: {
                return pSSysViewPanelItemBase.getEmptyCaption() == null;
            }
            case 55: {
                return pSSysViewPanelItemBase.getEnableAnchor() == null;
            }
            case 56: {
                return pSSysViewPanelItemBase.getEnableLogic() == null;
            }
            case 57: {
                return pSSysViewPanelItemBase.getFieldName() == null;
            }
            case 58: {
                return pSSysViewPanelItemBase.getFieldStates() == null;
            }
            case 59: {
                return pSSysViewPanelItemBase.getFlexAlign() == null;
            }
            case 60: {
                return pSSysViewPanelItemBase.getFlexBasis() == null;
            }
            case 61: {
                return pSSysViewPanelItemBase.getFlexDir() == null;
            }
            case 62: {
                return pSSysViewPanelItemBase.getFlexGrow() == null;
            }
            case 63: {
                return pSSysViewPanelItemBase.getFlexShrink() == null;
            }
            case 64: {
                return pSSysViewPanelItemBase.getFlexVAlign() == null;
            }
            case 65: {
                return pSSysViewPanelItemBase.getGetDataTimer() == null;
            }
            case 66: {
                return pSSysViewPanelItemBase.getGridRowId() == null;
            }
            case 67: {
                return pSSysViewPanelItemBase.getHAlign() == null;
            }
            case 68: {
                return pSSysViewPanelItemBase.getHAlignSelf() == null;
            }
            case 69: {
                return pSSysViewPanelItemBase.getHeight() == null;
            }
            case 70: {
                return pSSysViewPanelItemBase.getHeightMode() == null;
            }
            case 71: {
                return pSSysViewPanelItemBase.getHtmlContent() == null;
            }
            case 72: {
                return pSSysViewPanelItemBase.getHtmlPageUrl() == null;
            }
            case 73: {
                return pSSysViewPanelItemBase.getIconAlign() == null;
            }
            case 74: {
                return pSSysViewPanelItemBase.getIgnoreInput() == null;
            }
            case 75: {
                return pSSysViewPanelItemBase.getItemParam() == null;
            }
            case 76: {
                return pSSysViewPanelItemBase.getItemParam10() == null;
            }
            case 77: {
                return pSSysViewPanelItemBase.getItemParam11() == null;
            }
            case 78: {
                return pSSysViewPanelItemBase.getItemParam12() == null;
            }
            case 79: {
                return pSSysViewPanelItemBase.getItemParam2() == null;
            }
            case 80: {
                return pSSysViewPanelItemBase.getItemParam3() == null;
            }
            case 81: {
                return pSSysViewPanelItemBase.getItemParam4() == null;
            }
            case 82: {
                return pSSysViewPanelItemBase.getItemParam5() == null;
            }
            case 83: {
                return pSSysViewPanelItemBase.getItemParam6() == null;
            }
            case 84: {
                return pSSysViewPanelItemBase.getItemParam7() == null;
            }
            case 85: {
                return pSSysViewPanelItemBase.getItemParam8() == null;
            }
            case 86: {
                return pSSysViewPanelItemBase.getItemParam9() == null;
            }
            case 87: {
                return pSSysViewPanelItemBase.getItemParams() == null;
            }
            case 88: {
                return pSSysViewPanelItemBase.getItemType() == null;
            }
            case 89: {
                return pSSysViewPanelItemBase.getLabelDynaClass() == null;
            }
            case 90: {
                return pSSysViewPanelItemBase.getLabelPSSysCssId() == null;
            }
            case 91: {
                return pSSysViewPanelItemBase.getLabelPSSysCssName() == null;
            }
            case 92: {
                return pSSysViewPanelItemBase.getLabelRawCssStyle() == null;
            }
            case 93: {
                return pSSysViewPanelItemBase.getLableCssId() == null;
            }
            case 94: {
                return pSSysViewPanelItemBase.getLayoutMode() == null;
            }
            case 95: {
                return pSSysViewPanelItemBase.getLeftPos() == null;
            }
            case 96: {
                return pSSysViewPanelItemBase.getLogicName() == null;
            }
            case 97: {
                return pSSysViewPanelItemBase.getMemo() == null;
            }
            case 98: {
                return pSSysViewPanelItemBase.getMobFlag() == null;
            }
            case 99: {
                return pSSysViewPanelItemBase.getOpenPSAppViewId() == null;
            }
            case 100: {
                return pSSysViewPanelItemBase.getOpenPSAppViewName() == null;
            }
            case 101: {
                return pSSysViewPanelItemBase.getOpenPSDEViewId() == null;
            }
            case 102: {
                return pSSysViewPanelItemBase.getOpenPSDEViewName() == null;
            }
            case 103: {
                return pSSysViewPanelItemBase.getOpenPSSysPDTViewId() == null;
            }
            case 104: {
                return pSSysViewPanelItemBase.getOpenPSSysPDTViewName() == null;
            }
            case 105: {
                return pSSysViewPanelItemBase.getOrderValue() == null;
            }
            case 106: {
                return pSSysViewPanelItemBase.getOrientationMode() == null;
            }
            case 107: {
                return pSSysViewPanelItemBase.getPHPSLanResId() == null;
            }
            case 108: {
                return pSSysViewPanelItemBase.getPHPSLanResName() == null;
            }
            case 109: {
                return pSSysViewPanelItemBase.getPlaceHolder() == null;
            }
            case 110: {
                return pSSysViewPanelItemBase.getPLayoutMode() == null;
            }
            case 111: {
                return pSSysViewPanelItemBase.getPPSSysViewPanelItemId() == null;
            }
            case 112: {
                return pSSysViewPanelItemBase.getPPSSysViewPanelItemName() == null;
            }
            case 113: {
                return pSSysViewPanelItemBase.getPredefinedType() == null;
            }
            case 114: {
                return pSSysViewPanelItemBase.getPredefinedTypeText() == null;
            }
            case 115: {
                return pSSysViewPanelItemBase.getPreviewHtml() == null;
            }
            case 116: {
                return pSSysViewPanelItemBase.getPSACHandlerId() == null;
            }
            case 117: {
                return pSSysViewPanelItemBase.getPSACHandlerName() == null;
            }
            case 118: {
                return pSSysViewPanelItemBase.getPSAppMenuId() == null;
            }
            case 119: {
                return pSSysViewPanelItemBase.getPSAppMenuName() == null;
            }
            case 120: {
                return pSSysViewPanelItemBase.getPSCodeListId() == null;
            }
            case 121: {
                return pSSysViewPanelItemBase.getPSCodeListName() == null;
            }
            case 122: {
                return pSSysViewPanelItemBase.getPSCtrlId() == null;
            }
            case 123: {
                return pSSysViewPanelItemBase.getPSCtrlLogicGroupId() == null;
            }
            case 124: {
                return pSSysViewPanelItemBase.getPSCtrlLogicGroupName() == null;
            }
            case 125: {
                return pSSysViewPanelItemBase.getPSCtrlName() == null;
            }
            case 126: {
                return pSSysViewPanelItemBase.getPSDEActionId() == null;
            }
            case 127: {
                return pSSysViewPanelItemBase.getPSDEActionName() == null;
            }
            case 128: {
                return pSSysViewPanelItemBase.getPSDEChartId() == null;
            }
            case 129: {
                return pSSysViewPanelItemBase.getPSDEChartName() == null;
            }
            case 130: {
                return pSSysViewPanelItemBase.getPSDEDataSetId() == null;
            }
            case 131: {
                return pSSysViewPanelItemBase.getPSDEDataSetName() == null;
            }
            case 132: {
                return pSSysViewPanelItemBase.getPSDEDataViewId() == null;
            }
            case 133: {
                return pSSysViewPanelItemBase.getPSDEDataViewName() == null;
            }
            case 134: {
                return pSSysViewPanelItemBase.getPSDEDRId() == null;
            }
            case 135: {
                return pSSysViewPanelItemBase.getPSDEDRItemId() == null;
            }
            case 136: {
                return pSSysViewPanelItemBase.getPSDEDRItemName() == null;
            }
            case 137: {
                return pSSysViewPanelItemBase.getPSDEDRName() == null;
            }
            case 138: {
                return pSSysViewPanelItemBase.getPSDEFormId() == null;
            }
            case 139: {
                return pSSysViewPanelItemBase.getPSDEFormName() == null;
            }
            case 140: {
                return pSSysViewPanelItemBase.getPSDEGridId() == null;
            }
            case 141: {
                return pSSysViewPanelItemBase.getPSDEGridName() == null;
            }
            case 142: {
                return pSSysViewPanelItemBase.getPSDEId() == null;
            }
            case 143: {
                return pSSysViewPanelItemBase.getPSDEListId() == null;
            }
            case 144: {
                return pSSysViewPanelItemBase.getPSDEListName() == null;
            }
            case 145: {
                return pSSysViewPanelItemBase.getPSDELogicId() == null;
            }
            case 146: {
                return pSSysViewPanelItemBase.getPSDELogicName() == null;
            }
            case 147: {
                return pSSysViewPanelItemBase.getPSDEName() == null;
            }
            case 148: {
                return pSSysViewPanelItemBase.getPSDEPanelId() == null;
            }
            case 149: {
                return pSSysViewPanelItemBase.getPSDEPanelName() == null;
            }
            case 150: {
                return pSSysViewPanelItemBase.getPSDEReportId() == null;
            }
            case 151: {
                return pSSysViewPanelItemBase.getPSDEReportName() == null;
            }
            case 152: {
                return pSSysViewPanelItemBase.getPSDESearchFormId() == null;
            }
            case 153: {
                return pSSysViewPanelItemBase.getPSDESearchFormName() == null;
            }
            case 154: {
                return pSSysViewPanelItemBase.getPSDEToolbarId() == null;
            }
            case 155: {
                return pSSysViewPanelItemBase.getPSDEToolbarName() == null;
            }
            case 156: {
                return pSSysViewPanelItemBase.getPSDETreeViewId() == null;
            }
            case 157: {
                return pSSysViewPanelItemBase.getPSDETreeViewName() == null;
            }
            case 158: {
                return pSSysViewPanelItemBase.getPSDEUAGroupId() == null;
            }
            case 159: {
                return pSSysViewPanelItemBase.getPSDEUAGroupName() == null;
            }
            case 160: {
                return pSSysViewPanelItemBase.getPSDEUIActionId() == null;
            }
            case 161: {
                return pSSysViewPanelItemBase.getPSDEUIActionName() == null;
            }
            case 162: {
                return pSSysViewPanelItemBase.getPSDEViewBaseId() == null;
            }
            case 163: {
                return pSSysViewPanelItemBase.getPSDEViewBaseName() == null;
            }
            case 164: {
                return pSSysViewPanelItemBase.getPSDEWizardId() == null;
            }
            case 165: {
                return pSSysViewPanelItemBase.getPSDEWizardName() == null;
            }
            case 166: {
                return pSSysViewPanelItemBase.getPSSysCalendarId() == null;
            }
            case 167: {
                return pSSysViewPanelItemBase.getPSSysCalendarName() == null;
            }
            case 168: {
                return pSSysViewPanelItemBase.getPSSysCounterId() == null;
            }
            case 169: {
                return pSSysViewPanelItemBase.getPSSysCounterName() == null;
            }
            case 170: {
                return pSSysViewPanelItemBase.getPSSysCssId() == null;
            }
            case 171: {
                return pSSysViewPanelItemBase.getPSSysCssName() == null;
            }
            case 172: {
                return pSSysViewPanelItemBase.getPSSysDashboardId() == null;
            }
            case 173: {
                return pSSysViewPanelItemBase.getPSSysDashboardName() == null;
            }
            case 174: {
                return pSSysViewPanelItemBase.getPSSysDynaModelId() == null;
            }
            case 175: {
                return pSSysViewPanelItemBase.getPSSysDynaModelName() == null;
            }
            case 176: {
                return pSSysViewPanelItemBase.getPSSysEditorStyleId() == null;
            }
            case 177: {
                return pSSysViewPanelItemBase.getPSSysEditorStyleName() == null;
            }
            case 178: {
                return pSSysViewPanelItemBase.getPSSysImageId() == null;
            }
            case 179: {
                return pSSysViewPanelItemBase.getPSSysImageName() == null;
            }
            case 180: {
                return pSSysViewPanelItemBase.getPSSysMapViewId() == null;
            }
            case 181: {
                return pSSysViewPanelItemBase.getPSSysMapViewName() == null;
            }
            case 182: {
                return pSSysViewPanelItemBase.getPSSysPFPluginId() == null;
            }
            case 183: {
                return pSSysViewPanelItemBase.getPSSysPFPluginName() == null;
            }
            case 184: {
                return pSSysViewPanelItemBase.getPSSysResourceId() == null;
            }
            case 185: {
                return pSSysViewPanelItemBase.getPSSysResourceName() == null;
            }
            case 186: {
                return pSSysViewPanelItemBase.getPSSysSearchBarId() == null;
            }
            case 187: {
                return pSSysViewPanelItemBase.getPSSysSearchBarName() == null;
            }
            case 188: {
                return pSSysViewPanelItemBase.getPSSysViewPanelId() == null;
            }
            case 189: {
                return pSSysViewPanelItemBase.getPSSysViewPanelItemId() == null;
            }
            case 190: {
                return pSSysViewPanelItemBase.getPSSysViewPanelItemName() == null;
            }
            case 191: {
                return pSSysViewPanelItemBase.getPSSysViewPanelName() == null;
            }
            case 192: {
                return pSSysViewPanelItemBase.getRawContent() == null;
            }
            case 193: {
                return pSSysViewPanelItemBase.getRawCssStyle() == null;
            }
            case 194: {
                return pSSysViewPanelItemBase.getRawServiceMethod() == null;
            }
            case 195: {
                return pSSysViewPanelItemBase.getRawServiceUrl() == null;
            }
            case 196: {
                return pSSysViewPanelItemBase.getReadOnlyMode() == null;
            }
            case 197: {
                return pSSysViewPanelItemBase.getRefCtrl2Name() == null;
            }
            case 198: {
                return pSSysViewPanelItemBase.getRefCtrl2Usage() == null;
            }
            case 199: {
                return pSSysViewPanelItemBase.getRefCtrl2UsageText() == null;
            }
            case 200: {
                return pSSysViewPanelItemBase.getRefCtrlName() == null;
            }
            case 201: {
                return pSSysViewPanelItemBase.getRefCtrlUsage() == null;
            }
            case 202: {
                return pSSysViewPanelItemBase.getRefCtrlUsageText() == null;
            }
            case 203: {
                return pSSysViewPanelItemBase.getRefLinkPSDEViewId() == null;
            }
            case 204: {
                return pSSysViewPanelItemBase.getRefLinkPSDEViewName() == null;
            }
            case 205: {
                return pSSysViewPanelItemBase.getRefPickupPSDEViewId() == null;
            }
            case 206: {
                return pSSysViewPanelItemBase.getRefPickupPSDEViewName() == null;
            }
            case 207: {
                return pSSysViewPanelItemBase.getRefPSDEACModeId() == null;
            }
            case 208: {
                return pSSysViewPanelItemBase.getRefPSDEACModeName() == null;
            }
            case 209: {
                return pSSysViewPanelItemBase.getRefPSDEDataSetId() == null;
            }
            case 210: {
                return pSSysViewPanelItemBase.getRefPSDEDataSetName() == null;
            }
            case 211: {
                return pSSysViewPanelItemBase.getRefPSDEId() == null;
            }
            case 212: {
                return pSSysViewPanelItemBase.getRefPSDEName() == null;
            }
            case 213: {
                return pSSysViewPanelItemBase.getRenderMode() == null;
            }
            case 214: {
                return pSSysViewPanelItemBase.getRenderModeText() == null;
            }
            case 215: {
                return pSSysViewPanelItemBase.getResetItemName() == null;
            }
            case 216: {
                return pSSysViewPanelItemBase.getRightPos() == null;
            }
            case 217: {
                return pSSysViewPanelItemBase.getRowSpan() == null;
            }
            case 218: {
                return pSSysViewPanelItemBase.getShowCaption() == null;
            }
            case 219: {
                return pSSysViewPanelItemBase.getSpacingBottom() == null;
            }
            case 220: {
                return pSSysViewPanelItemBase.getSpacingLeft() == null;
            }
            case 221: {
                return pSSysViewPanelItemBase.getSpacingRight() == null;
            }
            case 222: {
                return pSSysViewPanelItemBase.getSpacingTop() == null;
            }
            case 223: {
                return pSSysViewPanelItemBase.getSwapMode() == null;
            }
            case 224: {
                return pSSysViewPanelItemBase.getTabIndex() == null;
            }
            case 225: {
                return pSSysViewPanelItemBase.getTargetId() == null;
            }
            case 226: {
                return pSSysViewPanelItemBase.getTargetName() == null;
            }
            case 227: {
                return pSSysViewPanelItemBase.getTargetType() == null;
            }
            case 228: {
                return pSSysViewPanelItemBase.getTemplateMode() == null;
            }
            case 229: {
                return pSSysViewPanelItemBase.getTipPSLanResId() == null;
            }
            case 230: {
                return pSSysViewPanelItemBase.getTipPSLanResName() == null;
            }
            case 231: {
                return pSSysViewPanelItemBase.getTitleBarCloseMode() == null;
            }
            case 232: {
                return pSSysViewPanelItemBase.getToggleMode() == null;
            }
            case 233: {
                return pSSysViewPanelItemBase.getTooltipInfo() == null;
            }
            case 234: {
                return pSSysViewPanelItemBase.getTopPos() == null;
            }
            case 235: {
                return pSSysViewPanelItemBase.getUpdateDate() == null;
            }
            case 236: {
                return pSSysViewPanelItemBase.getUpdateMan() == null;
            }
            case 237: {
                return pSSysViewPanelItemBase.getUserTag() == null;
            }
            case 238: {
                return pSSysViewPanelItemBase.getUserTag2() == null;
            }
            case 239: {
                return pSSysViewPanelItemBase.getVAlign() == null;
            }
            case 240: {
                return pSSysViewPanelItemBase.getVAlignSelf() == null;
            }
            case 241: {
                return pSSysViewPanelItemBase.getValueFormat() == null;
            }
            case 242: {
                return pSSysViewPanelItemBase.getValueItemName() == null;
            }
            case 243: {
                return pSSysViewPanelItemBase.getVisibleLogic() == null;
            }
            case 244: {
                return pSSysViewPanelItemBase.getWidth() == null;
            }
            case 245: {
                return pSSysViewPanelItemBase.getWidthMode() == null;
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
        return PSSysViewPanelItemBase.contains(this, n);
    }

    private static boolean contains(PSSysViewPanelItemBase pSSysViewPanelItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelItemBase.isActiveDataModeDirty();
            }
            case 1: {
                return pSSysViewPanelItemBase.isADPSDELogicIdDirty();
            }
            case 2: {
                return pSSysViewPanelItemBase.isADPSDELogicNameDirty();
            }
            case 3: {
                return pSSysViewPanelItemBase.isAL_PosDirty();
            }
            case 4: {
                return pSSysViewPanelItemBase.isBlankLogicDirty();
            }
            case 5: {
                return pSSysViewPanelItemBase.isBL_PosDirty();
            }
            case 6: {
                return pSSysViewPanelItemBase.isBorderStyleDirty();
            }
            case 7: {
                return pSSysViewPanelItemBase.isBottomPosDirty();
            }
            case 8: {
                return pSSysViewPanelItemBase.isBtnActionTypeDirty();
            }
            case 9: {
                return pSSysViewPanelItemBase.isBusyIndicatorDirty();
            }
            case 10: {
                return pSSysViewPanelItemBase.isCapPSLanResIdDirty();
            }
            case 11: {
                return pSSysViewPanelItemBase.isCapPSLanResNameDirty();
            }
            case 12: {
                return pSSysViewPanelItemBase.isCaptionDirty();
            }
            case 13: {
                return pSSysViewPanelItemBase.isCaptionPosDirty();
            }
            case 14: {
                return pSSysViewPanelItemBase.isChild_Col_LGDirty();
            }
            case 15: {
                return pSSysViewPanelItemBase.isChild_Col_MDDirty();
            }
            case 16: {
                return pSSysViewPanelItemBase.isChild_Col_SMDirty();
            }
            case 17: {
                return pSSysViewPanelItemBase.isChild_Col_XSDirty();
            }
            case 18: {
                return pSSysViewPanelItemBase.isColIdDirty();
            }
            case 19: {
                return pSSysViewPanelItemBase.isCollapsibleFlagDirty();
            }
            case 20: {
                return pSSysViewPanelItemBase.isColModelDirty();
            }
            case 21: {
                return pSSysViewPanelItemBase.isColSpanDirty();
            }
            case 22: {
                return pSSysViewPanelItemBase.isCol_LGDirty();
            }
            case 23: {
                return pSSysViewPanelItemBase.isCol_LG_OSDirty();
            }
            case 24: {
                return pSSysViewPanelItemBase.isCol_MDDirty();
            }
            case 25: {
                return pSSysViewPanelItemBase.isCol_MD_OSDirty();
            }
            case 26: {
                return pSSysViewPanelItemBase.isCol_SMDirty();
            }
            case 27: {
                return pSSysViewPanelItemBase.isCol_SM_OSDirty();
            }
            case 28: {
                return pSSysViewPanelItemBase.isCol_WidthDirty();
            }
            case 29: {
                return pSSysViewPanelItemBase.isCol_XSDirty();
            }
            case 30: {
                return pSSysViewPanelItemBase.isCol_XS_OSDirty();
            }
            case 31: {
                return pSSysViewPanelItemBase.isContentTypeDirty();
            }
            case 32: {
                return pSSysViewPanelItemBase.isCounterIdDirty();
            }
            case 33: {
                return pSSysViewPanelItemBase.isCounterModeDirty();
            }
            case 34: {
                return pSSysViewPanelItemBase.isCreateDateDirty();
            }
            case 35: {
                return pSSysViewPanelItemBase.isCreateManDirty();
            }
            case 36: {
                return pSSysViewPanelItemBase.isCssIdDirty();
            }
            case 37: {
                return pSSysViewPanelItemBase.isCtrlDynaClassDirty();
            }
            case 38: {
                return pSSysViewPanelItemBase.isCtrlHeightDirty();
            }
            case 39: {
                return pSSysViewPanelItemBase.isCtrlPSSysCssIdDirty();
            }
            case 40: {
                return pSSysViewPanelItemBase.isCtrlPSSysCssNameDirty();
            }
            case 41: {
                return pSSysViewPanelItemBase.isCtrlRawCssStyleDirty();
            }
            case 42: {
                return pSSysViewPanelItemBase.isCtrlTypeDirty();
            }
            case 43: {
                return pSSysViewPanelItemBase.isCtrlWidthDirty();
            }
            case 44: {
                return pSSysViewPanelItemBase.isCustomCodeDirty();
            }
            case 45: {
                return pSSysViewPanelItemBase.isCustomModeDirty();
            }
            case 46: {
                return pSSysViewPanelItemBase.isDataPanelModeDirty();
            }
            case 47: {
                return pSSysViewPanelItemBase.isDataSourceDirty();
            }
            case 48: {
                return pSSysViewPanelItemBase.isDataSourceTextDirty();
            }
            case 49: {
                return pSSysViewPanelItemBase.isDetailStyleDirty();
            }
            case 50: {
                return pSSysViewPanelItemBase.isDetailStyleTextDirty();
            }
            case 51: {
                return pSSysViewPanelItemBase.isDynaClassDirty();
            }
            case 52: {
                return pSSysViewPanelItemBase.isEditorTypeDirty();
            }
            case 53: {
                return pSSysViewPanelItemBase.isEditorTypeNameDirty();
            }
            case 54: {
                return pSSysViewPanelItemBase.isEmptyCaptionDirty();
            }
            case 55: {
                return pSSysViewPanelItemBase.isEnableAnchorDirty();
            }
            case 56: {
                return pSSysViewPanelItemBase.isEnableLogicDirty();
            }
            case 57: {
                return pSSysViewPanelItemBase.isFieldNameDirty();
            }
            case 58: {
                return pSSysViewPanelItemBase.isFieldStatesDirty();
            }
            case 59: {
                return pSSysViewPanelItemBase.isFlexAlignDirty();
            }
            case 60: {
                return pSSysViewPanelItemBase.isFlexBasisDirty();
            }
            case 61: {
                return pSSysViewPanelItemBase.isFlexDirDirty();
            }
            case 62: {
                return pSSysViewPanelItemBase.isFlexGrowDirty();
            }
            case 63: {
                return pSSysViewPanelItemBase.isFlexShrinkDirty();
            }
            case 64: {
                return pSSysViewPanelItemBase.isFlexVAlignDirty();
            }
            case 65: {
                return pSSysViewPanelItemBase.isGetDataTimerDirty();
            }
            case 66: {
                return pSSysViewPanelItemBase.isGridRowIdDirty();
            }
            case 67: {
                return pSSysViewPanelItemBase.isHAlignDirty();
            }
            case 68: {
                return pSSysViewPanelItemBase.isHAlignSelfDirty();
            }
            case 69: {
                return pSSysViewPanelItemBase.isHeightDirty();
            }
            case 70: {
                return pSSysViewPanelItemBase.isHeightModeDirty();
            }
            case 71: {
                return pSSysViewPanelItemBase.isHtmlContentDirty();
            }
            case 72: {
                return pSSysViewPanelItemBase.isHtmlPageUrlDirty();
            }
            case 73: {
                return pSSysViewPanelItemBase.isIconAlignDirty();
            }
            case 74: {
                return pSSysViewPanelItemBase.isIgnoreInputDirty();
            }
            case 75: {
                return pSSysViewPanelItemBase.isItemParamDirty();
            }
            case 76: {
                return pSSysViewPanelItemBase.isItemParam10Dirty();
            }
            case 77: {
                return pSSysViewPanelItemBase.isItemParam11Dirty();
            }
            case 78: {
                return pSSysViewPanelItemBase.isItemParam12Dirty();
            }
            case 79: {
                return pSSysViewPanelItemBase.isItemParam2Dirty();
            }
            case 80: {
                return pSSysViewPanelItemBase.isItemParam3Dirty();
            }
            case 81: {
                return pSSysViewPanelItemBase.isItemParam4Dirty();
            }
            case 82: {
                return pSSysViewPanelItemBase.isItemParam5Dirty();
            }
            case 83: {
                return pSSysViewPanelItemBase.isItemParam6Dirty();
            }
            case 84: {
                return pSSysViewPanelItemBase.isItemParam7Dirty();
            }
            case 85: {
                return pSSysViewPanelItemBase.isItemParam8Dirty();
            }
            case 86: {
                return pSSysViewPanelItemBase.isItemParam9Dirty();
            }
            case 87: {
                return pSSysViewPanelItemBase.isItemParamsDirty();
            }
            case 88: {
                return pSSysViewPanelItemBase.isItemTypeDirty();
            }
            case 89: {
                return pSSysViewPanelItemBase.isLabelDynaClassDirty();
            }
            case 90: {
                return pSSysViewPanelItemBase.isLabelPSSysCssIdDirty();
            }
            case 91: {
                return pSSysViewPanelItemBase.isLabelPSSysCssNameDirty();
            }
            case 92: {
                return pSSysViewPanelItemBase.isLabelRawCssStyleDirty();
            }
            case 93: {
                return pSSysViewPanelItemBase.isLableCssIdDirty();
            }
            case 94: {
                return pSSysViewPanelItemBase.isLayoutModeDirty();
            }
            case 95: {
                return pSSysViewPanelItemBase.isLeftPosDirty();
            }
            case 96: {
                return pSSysViewPanelItemBase.isLogicNameDirty();
            }
            case 97: {
                return pSSysViewPanelItemBase.isMemoDirty();
            }
            case 98: {
                return pSSysViewPanelItemBase.isMobFlagDirty();
            }
            case 99: {
                return pSSysViewPanelItemBase.isOpenPSAppViewIdDirty();
            }
            case 100: {
                return pSSysViewPanelItemBase.isOpenPSAppViewNameDirty();
            }
            case 101: {
                return pSSysViewPanelItemBase.isOpenPSDEViewIdDirty();
            }
            case 102: {
                return pSSysViewPanelItemBase.isOpenPSDEViewNameDirty();
            }
            case 103: {
                return pSSysViewPanelItemBase.isOpenPSSysPDTViewIdDirty();
            }
            case 104: {
                return pSSysViewPanelItemBase.isOpenPSSysPDTViewNameDirty();
            }
            case 105: {
                return pSSysViewPanelItemBase.isOrderValueDirty();
            }
            case 106: {
                return pSSysViewPanelItemBase.isOrientationModeDirty();
            }
            case 107: {
                return pSSysViewPanelItemBase.isPHPSLanResIdDirty();
            }
            case 108: {
                return pSSysViewPanelItemBase.isPHPSLanResNameDirty();
            }
            case 109: {
                return pSSysViewPanelItemBase.isPlaceHolderDirty();
            }
            case 110: {
                return pSSysViewPanelItemBase.isPLayoutModeDirty();
            }
            case 111: {
                return pSSysViewPanelItemBase.isPPSSysViewPanelItemIdDirty();
            }
            case 112: {
                return pSSysViewPanelItemBase.isPPSSysViewPanelItemNameDirty();
            }
            case 113: {
                return pSSysViewPanelItemBase.isPredefinedTypeDirty();
            }
            case 114: {
                return pSSysViewPanelItemBase.isPredefinedTypeTextDirty();
            }
            case 115: {
                return pSSysViewPanelItemBase.isPreviewHtmlDirty();
            }
            case 116: {
                return pSSysViewPanelItemBase.isPSACHandlerIdDirty();
            }
            case 117: {
                return pSSysViewPanelItemBase.isPSACHandlerNameDirty();
            }
            case 118: {
                return pSSysViewPanelItemBase.isPSAppMenuIdDirty();
            }
            case 119: {
                return pSSysViewPanelItemBase.isPSAppMenuNameDirty();
            }
            case 120: {
                return pSSysViewPanelItemBase.isPSCodeListIdDirty();
            }
            case 121: {
                return pSSysViewPanelItemBase.isPSCodeListNameDirty();
            }
            case 122: {
                return pSSysViewPanelItemBase.isPSCtrlIdDirty();
            }
            case 123: {
                return pSSysViewPanelItemBase.isPSCtrlLogicGroupIdDirty();
            }
            case 124: {
                return pSSysViewPanelItemBase.isPSCtrlLogicGroupNameDirty();
            }
            case 125: {
                return pSSysViewPanelItemBase.isPSCtrlNameDirty();
            }
            case 126: {
                return pSSysViewPanelItemBase.isPSDEActionIdDirty();
            }
            case 127: {
                return pSSysViewPanelItemBase.isPSDEActionNameDirty();
            }
            case 128: {
                return pSSysViewPanelItemBase.isPSDEChartIdDirty();
            }
            case 129: {
                return pSSysViewPanelItemBase.isPSDEChartNameDirty();
            }
            case 130: {
                return pSSysViewPanelItemBase.isPSDEDataSetIdDirty();
            }
            case 131: {
                return pSSysViewPanelItemBase.isPSDEDataSetNameDirty();
            }
            case 132: {
                return pSSysViewPanelItemBase.isPSDEDataViewIdDirty();
            }
            case 133: {
                return pSSysViewPanelItemBase.isPSDEDataViewNameDirty();
            }
            case 134: {
                return pSSysViewPanelItemBase.isPSDEDRIdDirty();
            }
            case 135: {
                return pSSysViewPanelItemBase.isPSDEDRItemIdDirty();
            }
            case 136: {
                return pSSysViewPanelItemBase.isPSDEDRItemNameDirty();
            }
            case 137: {
                return pSSysViewPanelItemBase.isPSDEDRNameDirty();
            }
            case 138: {
                return pSSysViewPanelItemBase.isPSDEFormIdDirty();
            }
            case 139: {
                return pSSysViewPanelItemBase.isPSDEFormNameDirty();
            }
            case 140: {
                return pSSysViewPanelItemBase.isPSDEGridIdDirty();
            }
            case 141: {
                return pSSysViewPanelItemBase.isPSDEGridNameDirty();
            }
            case 142: {
                return pSSysViewPanelItemBase.isPSDEIdDirty();
            }
            case 143: {
                return pSSysViewPanelItemBase.isPSDEListIdDirty();
            }
            case 144: {
                return pSSysViewPanelItemBase.isPSDEListNameDirty();
            }
            case 145: {
                return pSSysViewPanelItemBase.isPSDELogicIdDirty();
            }
            case 146: {
                return pSSysViewPanelItemBase.isPSDELogicNameDirty();
            }
            case 147: {
                return pSSysViewPanelItemBase.isPSDENameDirty();
            }
            case 148: {
                return pSSysViewPanelItemBase.isPSDEPanelIdDirty();
            }
            case 149: {
                return pSSysViewPanelItemBase.isPSDEPanelNameDirty();
            }
            case 150: {
                return pSSysViewPanelItemBase.isPSDEReportIdDirty();
            }
            case 151: {
                return pSSysViewPanelItemBase.isPSDEReportNameDirty();
            }
            case 152: {
                return pSSysViewPanelItemBase.isPSDESearchFormIdDirty();
            }
            case 153: {
                return pSSysViewPanelItemBase.isPSDESearchFormNameDirty();
            }
            case 154: {
                return pSSysViewPanelItemBase.isPSDEToolbarIdDirty();
            }
            case 155: {
                return pSSysViewPanelItemBase.isPSDEToolbarNameDirty();
            }
            case 156: {
                return pSSysViewPanelItemBase.isPSDETreeViewIdDirty();
            }
            case 157: {
                return pSSysViewPanelItemBase.isPSDETreeViewNameDirty();
            }
            case 158: {
                return pSSysViewPanelItemBase.isPSDEUAGroupIdDirty();
            }
            case 159: {
                return pSSysViewPanelItemBase.isPSDEUAGroupNameDirty();
            }
            case 160: {
                return pSSysViewPanelItemBase.isPSDEUIActionIdDirty();
            }
            case 161: {
                return pSSysViewPanelItemBase.isPSDEUIActionNameDirty();
            }
            case 162: {
                return pSSysViewPanelItemBase.isPSDEViewBaseIdDirty();
            }
            case 163: {
                return pSSysViewPanelItemBase.isPSDEViewBaseNameDirty();
            }
            case 164: {
                return pSSysViewPanelItemBase.isPSDEWizardIdDirty();
            }
            case 165: {
                return pSSysViewPanelItemBase.isPSDEWizardNameDirty();
            }
            case 166: {
                return pSSysViewPanelItemBase.isPSSysCalendarIdDirty();
            }
            case 167: {
                return pSSysViewPanelItemBase.isPSSysCalendarNameDirty();
            }
            case 168: {
                return pSSysViewPanelItemBase.isPSSysCounterIdDirty();
            }
            case 169: {
                return pSSysViewPanelItemBase.isPSSysCounterNameDirty();
            }
            case 170: {
                return pSSysViewPanelItemBase.isPSSysCssIdDirty();
            }
            case 171: {
                return pSSysViewPanelItemBase.isPSSysCssNameDirty();
            }
            case 172: {
                return pSSysViewPanelItemBase.isPSSysDashboardIdDirty();
            }
            case 173: {
                return pSSysViewPanelItemBase.isPSSysDashboardNameDirty();
            }
            case 174: {
                return pSSysViewPanelItemBase.isPSSysDynaModelIdDirty();
            }
            case 175: {
                return pSSysViewPanelItemBase.isPSSysDynaModelNameDirty();
            }
            case 176: {
                return pSSysViewPanelItemBase.isPSSysEditorStyleIdDirty();
            }
            case 177: {
                return pSSysViewPanelItemBase.isPSSysEditorStyleNameDirty();
            }
            case 178: {
                return pSSysViewPanelItemBase.isPSSysImageIdDirty();
            }
            case 179: {
                return pSSysViewPanelItemBase.isPSSysImageNameDirty();
            }
            case 180: {
                return pSSysViewPanelItemBase.isPSSysMapViewIdDirty();
            }
            case 181: {
                return pSSysViewPanelItemBase.isPSSysMapViewNameDirty();
            }
            case 182: {
                return pSSysViewPanelItemBase.isPSSysPFPluginIdDirty();
            }
            case 183: {
                return pSSysViewPanelItemBase.isPSSysPFPluginNameDirty();
            }
            case 184: {
                return pSSysViewPanelItemBase.isPSSysResourceIdDirty();
            }
            case 185: {
                return pSSysViewPanelItemBase.isPSSysResourceNameDirty();
            }
            case 186: {
                return pSSysViewPanelItemBase.isPSSysSearchBarIdDirty();
            }
            case 187: {
                return pSSysViewPanelItemBase.isPSSysSearchBarNameDirty();
            }
            case 188: {
                return pSSysViewPanelItemBase.isPSSysViewPanelIdDirty();
            }
            case 189: {
                return pSSysViewPanelItemBase.isPSSysViewPanelItemIdDirty();
            }
            case 190: {
                return pSSysViewPanelItemBase.isPSSysViewPanelItemNameDirty();
            }
            case 191: {
                return pSSysViewPanelItemBase.isPSSysViewPanelNameDirty();
            }
            case 192: {
                return pSSysViewPanelItemBase.isRawContentDirty();
            }
            case 193: {
                return pSSysViewPanelItemBase.isRawCssStyleDirty();
            }
            case 194: {
                return pSSysViewPanelItemBase.isRawServiceMethodDirty();
            }
            case 195: {
                return pSSysViewPanelItemBase.isRawServiceUrlDirty();
            }
            case 196: {
                return pSSysViewPanelItemBase.isReadOnlyModeDirty();
            }
            case 197: {
                return pSSysViewPanelItemBase.isRefCtrl2NameDirty();
            }
            case 198: {
                return pSSysViewPanelItemBase.isRefCtrl2UsageDirty();
            }
            case 199: {
                return pSSysViewPanelItemBase.isRefCtrl2UsageTextDirty();
            }
            case 200: {
                return pSSysViewPanelItemBase.isRefCtrlNameDirty();
            }
            case 201: {
                return pSSysViewPanelItemBase.isRefCtrlUsageDirty();
            }
            case 202: {
                return pSSysViewPanelItemBase.isRefCtrlUsageTextDirty();
            }
            case 203: {
                return pSSysViewPanelItemBase.isRefLinkPSDEViewIdDirty();
            }
            case 204: {
                return pSSysViewPanelItemBase.isRefLinkPSDEViewNameDirty();
            }
            case 205: {
                return pSSysViewPanelItemBase.isRefPickupPSDEViewIdDirty();
            }
            case 206: {
                return pSSysViewPanelItemBase.isRefPickupPSDEViewNameDirty();
            }
            case 207: {
                return pSSysViewPanelItemBase.isRefPSDEACModeIdDirty();
            }
            case 208: {
                return pSSysViewPanelItemBase.isRefPSDEACModeNameDirty();
            }
            case 209: {
                return pSSysViewPanelItemBase.isRefPSDEDataSetIdDirty();
            }
            case 210: {
                return pSSysViewPanelItemBase.isRefPSDEDataSetNameDirty();
            }
            case 211: {
                return pSSysViewPanelItemBase.isRefPSDEIdDirty();
            }
            case 212: {
                return pSSysViewPanelItemBase.isRefPSDENameDirty();
            }
            case 213: {
                return pSSysViewPanelItemBase.isRenderModeDirty();
            }
            case 214: {
                return pSSysViewPanelItemBase.isRenderModeTextDirty();
            }
            case 215: {
                return pSSysViewPanelItemBase.isResetItemNameDirty();
            }
            case 216: {
                return pSSysViewPanelItemBase.isRightPosDirty();
            }
            case 217: {
                return pSSysViewPanelItemBase.isRowSpanDirty();
            }
            case 218: {
                return pSSysViewPanelItemBase.isShowCaptionDirty();
            }
            case 219: {
                return pSSysViewPanelItemBase.isSpacingBottomDirty();
            }
            case 220: {
                return pSSysViewPanelItemBase.isSpacingLeftDirty();
            }
            case 221: {
                return pSSysViewPanelItemBase.isSpacingRightDirty();
            }
            case 222: {
                return pSSysViewPanelItemBase.isSpacingTopDirty();
            }
            case 223: {
                return pSSysViewPanelItemBase.isSwapModeDirty();
            }
            case 224: {
                return pSSysViewPanelItemBase.isTabIndexDirty();
            }
            case 225: {
                return pSSysViewPanelItemBase.isTargetIdDirty();
            }
            case 226: {
                return pSSysViewPanelItemBase.isTargetNameDirty();
            }
            case 227: {
                return pSSysViewPanelItemBase.isTargetTypeDirty();
            }
            case 228: {
                return pSSysViewPanelItemBase.isTemplateModeDirty();
            }
            case 229: {
                return pSSysViewPanelItemBase.isTipPSLanResIdDirty();
            }
            case 230: {
                return pSSysViewPanelItemBase.isTipPSLanResNameDirty();
            }
            case 231: {
                return pSSysViewPanelItemBase.isTitleBarCloseModeDirty();
            }
            case 232: {
                return pSSysViewPanelItemBase.isToggleModeDirty();
            }
            case 233: {
                return pSSysViewPanelItemBase.isTooltipInfoDirty();
            }
            case 234: {
                return pSSysViewPanelItemBase.isTopPosDirty();
            }
            case 235: {
                return pSSysViewPanelItemBase.isUpdateDateDirty();
            }
            case 236: {
                return pSSysViewPanelItemBase.isUpdateManDirty();
            }
            case 237: {
                return pSSysViewPanelItemBase.isUserTagDirty();
            }
            case 238: {
                return pSSysViewPanelItemBase.isUserTag2Dirty();
            }
            case 239: {
                return pSSysViewPanelItemBase.isVAlignDirty();
            }
            case 240: {
                return pSSysViewPanelItemBase.isVAlignSelfDirty();
            }
            case 241: {
                return pSSysViewPanelItemBase.isValueFormatDirty();
            }
            case 242: {
                return pSSysViewPanelItemBase.isValueItemNameDirty();
            }
            case 243: {
                return pSSysViewPanelItemBase.isVisibleLogicDirty();
            }
            case 244: {
                return pSSysViewPanelItemBase.isWidthDirty();
            }
            case 245: {
                return pSSysViewPanelItemBase.isWidthModeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysViewPanelItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysViewPanelItemBase pSSysViewPanelItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysViewPanelItemBase.getActiveDataMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"activedatamode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getActiveDataMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getADPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getADPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getADPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adpsdelogicname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getADPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getAL_Pos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"al_pos", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getAL_Pos()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getBlankLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"blanklogic", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getBlankLogic()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getBL_Pos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bl_pos", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getBL_Pos()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getBorderStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"borderstyle", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getBorderStyle()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getBottomPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottompos", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getBottomPos()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getBtnActionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"btnactiontype", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getBtnActionType()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCaptionPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"captionpos", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCaptionPos()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_lg", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getChild_Col_LG()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_md", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getChild_Col_MD()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_sm", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getChild_Col_SM()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"child_col_xs", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getChild_Col_XS()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getColId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCollapsibleFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"collapsibleflag", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCollapsibleFlag()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getColModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colmodel", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getColModel()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colspan", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getColSpan()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_LG()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_LG_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg_os", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_LG_OS()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_MD()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_MD_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md_os", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_MD_OS()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_SM()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_SM_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm_os", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_SM_OS()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_Width() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_width", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_Width()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_XS()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCol_XS_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs_os", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCol_XS_OS()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getContentType()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCounterId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCounterMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countermode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCounterMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCssId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrldynaclass", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCtrlDynaClass()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlheight", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCtrlHeight()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpssyscssid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCtrlPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpssyscssname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCtrlPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlrawcssstyle", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCtrlRawCssStyle()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlwidth", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCtrlWidth()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getDataPanelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datapanelmode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getDataPanelMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getDataSource() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasource", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getDataSource()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getDataSourceText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasourcetext", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getDataSourceText()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getDetailStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailstyle", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getDetailStyle()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getDetailStyleText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailstyletext", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getDetailStyleText()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getEditorType()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortypename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getEditorTypeName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getEmptyCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptycaption", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getEmptyCaption()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getEnableAnchor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableanchor", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getEnableAnchor()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelogic", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getEnableLogic()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFieldName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFieldStates() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldstates", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFieldStates()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFlexBasis() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexbasis", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFlexBasis()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFlexGrow() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexgrow", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFlexGrow()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFlexShrink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexshrink", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFlexShrink()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getGetDataTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getdatatimer", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getGetDataTimer()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getGridRowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridrowid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getGridRowId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getHAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halign", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getHAlign()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getHAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halignself", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getHAlignSelf()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getHeight()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getHeightMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"heightmode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getHeightMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getHtmlPageUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlpageurl", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getHtmlPageUrl()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getIconAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconalign", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getIconAlign()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getIgnoreInput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreinput", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getIgnoreInput()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam10", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam10()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam11", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam11()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam12", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam12()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam2", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam2()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam3", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam3()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam4", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam4()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam5", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam5()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam6", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam6()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam7", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam7()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam8", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam8()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparam9", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParam9()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemparams", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemParams()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLabelDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labeldynaclass", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLabelDynaClass()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLabelPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpssyscssid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLabelPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLabelPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelpssyscssname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLabelPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLabelRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"labelrawcssstyle", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLabelRawCssStyle()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLableCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lablecssid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLableCssId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getMobFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobflag", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getMobFlag()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsappviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOpenPSAppViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsappviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOpenPSAppViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsdeviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOpenPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpsdeviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOpenPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSSysPDTViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpssyspdtviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOpenPSSysPDTViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSSysPDTViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"openpssyspdtviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOpenPSSysPDTViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getOrientationMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orientationmode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getOrientationMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPHPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPHPSLanResId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPHPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"phpslanresname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPHPSLanResName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPlaceHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placeholder", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPlaceHolder()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"playoutmode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPLayoutMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPPSSysViewPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysviewpanelitemid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPPSSysViewPanelItemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPPSSysViewPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysviewpanelitemname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPPSSysViewPanelItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPreviewHtml() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"previewhtml", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPreviewHtml()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSACHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlerid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSACHandlerId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSACHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psachandlername", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSACHandlerName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSCtrlId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSCtrlName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEChartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEChartId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEChartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEChartName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDRId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDRItemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedritemname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDRItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedrname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEDRName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEListId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEListName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepanelid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEPanelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepanelname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEPanelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEReportId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEReportName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDESearchFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesearchformid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDESearchFormId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDESearchFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesearchformname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDESearchFormName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEToolbarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEToolbarId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEToolbarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetoolbarname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEToolbarName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEWizardId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSDEWizardName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCalendarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysCalendarId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCalendarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscalendarname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysCalendarName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDashboardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysDashboardId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDashboardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysDashboardName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysEditorStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstyleid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysEditorStyleId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysEditorStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseditorstylename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysEditorStyleName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysMapViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysMapViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysMapViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmapviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysMapViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysSearchBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysSearchBarId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysSearchBarName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchbarname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysSearchBarName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysViewPanelItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRawContent()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcssstyle", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRawCssStyle()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRawServiceMethod() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawservicemethod", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRawServiceMethod()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRawServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawserviceurl", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRawServiceUrl()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getReadOnlyMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"readonlymode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getReadOnlyMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrl2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrl2name", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefCtrl2Name()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrl2Usage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrl2usage", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefCtrl2Usage()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrl2UsageText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrl2usagetext", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefCtrl2UsageText()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrlname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefCtrlName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrlUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrlusage", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefCtrlUsage()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrlUsageText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refctrlusagetext", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefCtrlUsageText()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefLinkPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reflinkpsdeviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefLinkPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefLinkPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reflinkpsdeviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefLinkPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPickupPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpickuppsdeviewid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPickupPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPickupPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpickuppsdeviewname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPickupPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodeid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPSDEACModeId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeacmodename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPSDEACModeName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRenderMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRenderMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRenderModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermodetext", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRenderModeText()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getResetItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resetitemname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getResetItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRightPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rightpos", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRightPos()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getRowSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rowspan", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getRowSpan()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getShowCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showcaption", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getShowCaption()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getSpacingBottom() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingbottom", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getSpacingBottom()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getSpacingLeft() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingleft", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getSpacingLeft()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getSpacingRight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingright", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getSpacingRight()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getSpacingTop() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spacingtop", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getSpacingTop()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getSwapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swapmode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getSwapMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTabIndex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabindex", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTabIndex()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTargetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTargetId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTargetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targetname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTargetName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTargetType()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTitleBarCloseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlebarclosemode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTitleBarCloseMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getToggleMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"togglemode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getToggleMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getTopPos()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valign", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getVAlign()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getVAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valignself", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getVAlignSelf()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getValueItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueitemname", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getValueItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getVisibleLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"visiblelogic", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getVisibleLogic()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getWidth()), (boolean)false);
        }
        if (bl || pSSysViewPanelItemBase.getWidthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"widthmode", (Object)PSSysViewPanelItemBase.getJSONValue((Object)pSSysViewPanelItemBase.getWidthMode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysViewPanelItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysViewPanelItemBase pSSysViewPanelItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysViewPanelItemBase.getActiveDataMode() != null) {
            object = pSSysViewPanelItemBase.getActiveDataMode();
            xmlNode.setAttribute(FIELD_ACTIVEDATAMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getADPSDELogicId() != null) {
            object = pSSysViewPanelItemBase.getADPSDELogicId();
            xmlNode.setAttribute(FIELD_ADPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getADPSDELogicName() != null) {
            object = pSSysViewPanelItemBase.getADPSDELogicName();
            xmlNode.setAttribute(FIELD_ADPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getAL_Pos() != null) {
            object = pSSysViewPanelItemBase.getAL_Pos();
            xmlNode.setAttribute(FIELD_AL_POS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getBlankLogic() != null) {
            object = pSSysViewPanelItemBase.getBlankLogic();
            xmlNode.setAttribute(FIELD_BLANKLOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getBL_Pos() != null) {
            object = pSSysViewPanelItemBase.getBL_Pos();
            xmlNode.setAttribute(FIELD_BL_POS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getBorderStyle() != null) {
            object = pSSysViewPanelItemBase.getBorderStyle();
            xmlNode.setAttribute(FIELD_BORDERSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getBottomPos() != null) {
            object = pSSysViewPanelItemBase.getBottomPos();
            xmlNode.setAttribute(FIELD_BOTTOMPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getBtnActionType() != null) {
            object = pSSysViewPanelItemBase.getBtnActionType();
            xmlNode.setAttribute(FIELD_BTNACTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getBusyIndicator() != null) {
            object = pSSysViewPanelItemBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCapPSLanResId() != null) {
            object = pSSysViewPanelItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCapPSLanResName() != null) {
            object = pSSysViewPanelItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCaption() != null) {
            object = pSSysViewPanelItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCaptionPos() != null) {
            object = pSSysViewPanelItemBase.getCaptionPos();
            xmlNode.setAttribute(FIELD_CAPTIONPOS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_LG() != null) {
            object = pSSysViewPanelItemBase.getChild_Col_LG();
            xmlNode.setAttribute(FIELD_CHILD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_MD() != null) {
            object = pSSysViewPanelItemBase.getChild_Col_MD();
            xmlNode.setAttribute(FIELD_CHILD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_SM() != null) {
            object = pSSysViewPanelItemBase.getChild_Col_SM();
            xmlNode.setAttribute(FIELD_CHILD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getChild_Col_XS() != null) {
            object = pSSysViewPanelItemBase.getChild_Col_XS();
            xmlNode.setAttribute(FIELD_CHILD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getColId() != null) {
            object = pSSysViewPanelItemBase.getColId();
            xmlNode.setAttribute(FIELD_COLID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCollapsibleFlag() != null) {
            object = pSSysViewPanelItemBase.getCollapsibleFlag();
            xmlNode.setAttribute(FIELD_COLLAPSIBLEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getColModel() != null) {
            object = pSSysViewPanelItemBase.getColModel();
            xmlNode.setAttribute(FIELD_COLMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getColSpan() != null) {
            object = pSSysViewPanelItemBase.getColSpan();
            xmlNode.setAttribute(FIELD_COLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_LG() != null) {
            object = pSSysViewPanelItemBase.getCol_LG();
            xmlNode.setAttribute(FIELD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_LG_OS() != null) {
            object = pSSysViewPanelItemBase.getCol_LG_OS();
            xmlNode.setAttribute(FIELD_COL_LG_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_MD() != null) {
            object = pSSysViewPanelItemBase.getCol_MD();
            xmlNode.setAttribute(FIELD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_MD_OS() != null) {
            object = pSSysViewPanelItemBase.getCol_MD_OS();
            xmlNode.setAttribute(FIELD_COL_MD_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_SM() != null) {
            object = pSSysViewPanelItemBase.getCol_SM();
            xmlNode.setAttribute(FIELD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_SM_OS() != null) {
            object = pSSysViewPanelItemBase.getCol_SM_OS();
            xmlNode.setAttribute(FIELD_COL_SM_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_Width() != null) {
            object = pSSysViewPanelItemBase.getCol_Width();
            xmlNode.setAttribute(FIELD_COL_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_XS() != null) {
            object = pSSysViewPanelItemBase.getCol_XS();
            xmlNode.setAttribute(FIELD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCol_XS_OS() != null) {
            object = pSSysViewPanelItemBase.getCol_XS_OS();
            xmlNode.setAttribute(FIELD_COL_XS_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getContentType() != null) {
            object = pSSysViewPanelItemBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCounterId() != null) {
            object = pSSysViewPanelItemBase.getCounterId();
            xmlNode.setAttribute(FIELD_COUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCounterMode() != null) {
            object = pSSysViewPanelItemBase.getCounterMode();
            xmlNode.setAttribute(FIELD_COUNTERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCreateDate() != null) {
            object = pSSysViewPanelItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCreateMan() != null) {
            object = pSSysViewPanelItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCssId() != null) {
            object = pSSysViewPanelItemBase.getCssId();
            xmlNode.setAttribute(FIELD_CSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlDynaClass() != null) {
            object = pSSysViewPanelItemBase.getCtrlDynaClass();
            xmlNode.setAttribute(FIELD_CTRLDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlHeight() != null) {
            object = pSSysViewPanelItemBase.getCtrlHeight();
            xmlNode.setAttribute(FIELD_CTRLHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCtrlPSSysCssId() != null) {
            object = pSSysViewPanelItemBase.getCtrlPSSysCssId();
            xmlNode.setAttribute(FIELD_CTRLPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlPSSysCssName() != null) {
            object = pSSysViewPanelItemBase.getCtrlPSSysCssName();
            xmlNode.setAttribute(FIELD_CTRLPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlRawCssStyle() != null) {
            object = pSSysViewPanelItemBase.getCtrlRawCssStyle();
            xmlNode.setAttribute(FIELD_CTRLRAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlType() != null) {
            object = pSSysViewPanelItemBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCtrlWidth() != null) {
            object = pSSysViewPanelItemBase.getCtrlWidth();
            xmlNode.setAttribute(FIELD_CTRLWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getCustomCode() != null) {
            object = pSSysViewPanelItemBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getCustomMode() != null) {
            object = pSSysViewPanelItemBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getDataPanelMode() != null) {
            object = pSSysViewPanelItemBase.getDataPanelMode();
            xmlNode.setAttribute(FIELD_DATAPANELMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getDataSource() != null) {
            object = pSSysViewPanelItemBase.getDataSource();
            xmlNode.setAttribute(FIELD_DATASOURCE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getDataSourceText() != null) {
            object = pSSysViewPanelItemBase.getDataSourceText();
            xmlNode.setAttribute(FIELD_DATASOURCETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getDetailStyle() != null) {
            object = pSSysViewPanelItemBase.getDetailStyle();
            xmlNode.setAttribute(FIELD_DETAILSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getDetailStyleText() != null) {
            object = pSSysViewPanelItemBase.getDetailStyleText();
            xmlNode.setAttribute(FIELD_DETAILSTYLETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getDynaClass() != null) {
            object = pSSysViewPanelItemBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getEditorType() != null) {
            object = pSSysViewPanelItemBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getEditorTypeName() != null) {
            object = pSSysViewPanelItemBase.getEditorTypeName();
            xmlNode.setAttribute(FIELD_EDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getEmptyCaption() != null) {
            object = pSSysViewPanelItemBase.getEmptyCaption();
            xmlNode.setAttribute(FIELD_EMPTYCAPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getEnableAnchor() != null) {
            object = pSSysViewPanelItemBase.getEnableAnchor();
            xmlNode.setAttribute(FIELD_ENABLEANCHOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getEnableLogic() != null) {
            object = pSSysViewPanelItemBase.getEnableLogic();
            xmlNode.setAttribute(FIELD_ENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getFieldName() != null) {
            object = pSSysViewPanelItemBase.getFieldName();
            xmlNode.setAttribute(FIELD_FIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getFieldStates() != null) {
            object = pSSysViewPanelItemBase.getFieldStates();
            xmlNode.setAttribute(FIELD_FIELDSTATES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getFlexAlign() != null) {
            object = pSSysViewPanelItemBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getFlexBasis() != null) {
            object = pSSysViewPanelItemBase.getFlexBasis();
            xmlNode.setAttribute(FIELD_FLEXBASIS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getFlexDir() != null) {
            object = pSSysViewPanelItemBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getFlexGrow() != null) {
            object = pSSysViewPanelItemBase.getFlexGrow();
            xmlNode.setAttribute(FIELD_FLEXGROW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getFlexShrink() != null) {
            object = pSSysViewPanelItemBase.getFlexShrink();
            xmlNode.setAttribute(FIELD_FLEXSHRINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getFlexVAlign() != null) {
            object = pSSysViewPanelItemBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getGetDataTimer() != null) {
            object = pSSysViewPanelItemBase.getGetDataTimer();
            xmlNode.setAttribute(FIELD_GETDATATIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getGridRowId() != null) {
            object = pSSysViewPanelItemBase.getGridRowId();
            xmlNode.setAttribute(FIELD_GRIDROWID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getHAlign() != null) {
            object = pSSysViewPanelItemBase.getHAlign();
            xmlNode.setAttribute(FIELD_HALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getHAlignSelf() != null) {
            object = pSSysViewPanelItemBase.getHAlignSelf();
            xmlNode.setAttribute(FIELD_HALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getHeight() != null) {
            object = pSSysViewPanelItemBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getHeightMode() != null) {
            object = pSSysViewPanelItemBase.getHeightMode();
            xmlNode.setAttribute(FIELD_HEIGHTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getHtmlContent() != null) {
            object = pSSysViewPanelItemBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getHtmlPageUrl() != null) {
            object = pSSysViewPanelItemBase.getHtmlPageUrl();
            xmlNode.setAttribute(FIELD_HTMLPAGEURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getIconAlign() != null) {
            object = pSSysViewPanelItemBase.getIconAlign();
            xmlNode.setAttribute(FIELD_ICONALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getIgnoreInput() != null) {
            object = pSSysViewPanelItemBase.getIgnoreInput();
            xmlNode.setAttribute(FIELD_IGNOREINPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam() != null) {
            object = pSSysViewPanelItemBase.getItemParam();
            xmlNode.setAttribute(FIELD_ITEMPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam10() != null) {
            object = pSSysViewPanelItemBase.getItemParam10();
            xmlNode.setAttribute(FIELD_ITEMPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam11() != null) {
            object = pSSysViewPanelItemBase.getItemParam11();
            xmlNode.setAttribute(FIELD_ITEMPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam12() != null) {
            object = pSSysViewPanelItemBase.getItemParam12();
            xmlNode.setAttribute(FIELD_ITEMPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam2() != null) {
            object = pSSysViewPanelItemBase.getItemParam2();
            xmlNode.setAttribute(FIELD_ITEMPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam3() != null) {
            object = pSSysViewPanelItemBase.getItemParam3();
            xmlNode.setAttribute(FIELD_ITEMPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam4() != null) {
            object = pSSysViewPanelItemBase.getItemParam4();
            xmlNode.setAttribute(FIELD_ITEMPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getItemParam5() != null) {
            object = pSSysViewPanelItemBase.getItemParam5();
            xmlNode.setAttribute(FIELD_ITEMPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam6() != null) {
            object = pSSysViewPanelItemBase.getItemParam6();
            xmlNode.setAttribute(FIELD_ITEMPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam7() != null) {
            object = pSSysViewPanelItemBase.getItemParam7();
            xmlNode.setAttribute(FIELD_ITEMPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam8() != null) {
            object = pSSysViewPanelItemBase.getItemParam8();
            xmlNode.setAttribute(FIELD_ITEMPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParam9() != null) {
            object = pSSysViewPanelItemBase.getItemParam9();
            xmlNode.setAttribute(FIELD_ITEMPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getItemParams() != null) {
            object = pSSysViewPanelItemBase.getItemParams();
            xmlNode.setAttribute(FIELD_ITEMPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getItemType() != null) {
            object = pSSysViewPanelItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getLabelDynaClass() != null) {
            object = pSSysViewPanelItemBase.getLabelDynaClass();
            xmlNode.setAttribute(FIELD_LABELDYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getLabelPSSysCssId() != null) {
            object = pSSysViewPanelItemBase.getLabelPSSysCssId();
            xmlNode.setAttribute(FIELD_LABELPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getLabelPSSysCssName() != null) {
            object = pSSysViewPanelItemBase.getLabelPSSysCssName();
            xmlNode.setAttribute(FIELD_LABELPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getLabelRawCssStyle() != null) {
            object = pSSysViewPanelItemBase.getLabelRawCssStyle();
            xmlNode.setAttribute(FIELD_LABELRAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getLableCssId() != null) {
            object = pSSysViewPanelItemBase.getLableCssId();
            xmlNode.setAttribute(FIELD_LABLECSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getLayoutMode() != null) {
            object = pSSysViewPanelItemBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getLeftPos() != null) {
            object = pSSysViewPanelItemBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getLogicName() != null) {
            object = pSSysViewPanelItemBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getMemo() != null) {
            object = pSSysViewPanelItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getMobFlag() != null) {
            object = pSSysViewPanelItemBase.getMobFlag();
            xmlNode.setAttribute(FIELD_MOBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSAppViewId() != null) {
            object = pSSysViewPanelItemBase.getOpenPSAppViewId();
            xmlNode.setAttribute(FIELD_OPENPSAPPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSAppViewName() != null) {
            object = pSSysViewPanelItemBase.getOpenPSAppViewName();
            xmlNode.setAttribute(FIELD_OPENPSAPPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSDEViewId() != null) {
            object = pSSysViewPanelItemBase.getOpenPSDEViewId();
            xmlNode.setAttribute(FIELD_OPENPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSDEViewName() != null) {
            object = pSSysViewPanelItemBase.getOpenPSDEViewName();
            xmlNode.setAttribute(FIELD_OPENPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSSysPDTViewId() != null) {
            object = pSSysViewPanelItemBase.getOpenPSSysPDTViewId();
            xmlNode.setAttribute(FIELD_OPENPSSYSPDTVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getOpenPSSysPDTViewName() != null) {
            object = pSSysViewPanelItemBase.getOpenPSSysPDTViewName();
            xmlNode.setAttribute(FIELD_OPENPSSYSPDTVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getOrderValue() != null) {
            object = pSSysViewPanelItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getOrientationMode() != null) {
            object = pSSysViewPanelItemBase.getOrientationMode();
            xmlNode.setAttribute(FIELD_ORIENTATIONMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPHPSLanResId() != null) {
            object = pSSysViewPanelItemBase.getPHPSLanResId();
            xmlNode.setAttribute(FIELD_PHPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPHPSLanResName() != null) {
            object = pSSysViewPanelItemBase.getPHPSLanResName();
            xmlNode.setAttribute(FIELD_PHPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPlaceHolder() != null) {
            object = pSSysViewPanelItemBase.getPlaceHolder();
            xmlNode.setAttribute(FIELD_PLACEHOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPLayoutMode() != null) {
            object = pSSysViewPanelItemBase.getPLayoutMode();
            xmlNode.setAttribute(FIELD_PLAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPPSSysViewPanelItemId() != null) {
            object = pSSysViewPanelItemBase.getPPSSysViewPanelItemId();
            xmlNode.setAttribute(FIELD_PPSSYSVIEWPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPPSSysViewPanelItemName() != null) {
            object = pSSysViewPanelItemBase.getPPSSysViewPanelItemName();
            xmlNode.setAttribute(FIELD_PPSSYSVIEWPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPredefinedType() != null) {
            object = pSSysViewPanelItemBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPredefinedTypeText() != null) {
            object = pSSysViewPanelItemBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPreviewHtml() != null) {
            object = pSSysViewPanelItemBase.getPreviewHtml();
            xmlNode.setAttribute(FIELD_PREVIEWHTML, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSACHandlerId() != null) {
            object = pSSysViewPanelItemBase.getPSACHandlerId();
            xmlNode.setAttribute(FIELD_PSACHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSACHandlerName() != null) {
            object = pSSysViewPanelItemBase.getPSACHandlerName();
            xmlNode.setAttribute(FIELD_PSACHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSAppMenuId() != null) {
            object = pSSysViewPanelItemBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSAppMenuName() != null) {
            object = pSSysViewPanelItemBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSCodeListId() != null) {
            object = pSSysViewPanelItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSCodeListName() != null) {
            object = pSSysViewPanelItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlId() != null) {
            object = pSSysViewPanelItemBase.getPSCtrlId();
            xmlNode.setAttribute(FIELD_PSCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlLogicGroupId() != null) {
            object = pSSysViewPanelItemBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlLogicGroupName() != null) {
            object = pSSysViewPanelItemBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSCtrlName() != null) {
            object = pSSysViewPanelItemBase.getPSCtrlName();
            xmlNode.setAttribute(FIELD_PSCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEActionId() != null) {
            object = pSSysViewPanelItemBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEActionName() != null) {
            object = pSSysViewPanelItemBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEChartId() != null) {
            object = pSSysViewPanelItemBase.getPSDEChartId();
            xmlNode.setAttribute(FIELD_PSDECHARTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEChartName() != null) {
            object = pSSysViewPanelItemBase.getPSDEChartName();
            xmlNode.setAttribute(FIELD_PSDECHARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataSetId() != null) {
            object = pSSysViewPanelItemBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataSetName() != null) {
            object = pSSysViewPanelItemBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataViewId() != null) {
            object = pSSysViewPanelItemBase.getPSDEDataViewId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDataViewName() != null) {
            object = pSSysViewPanelItemBase.getPSDEDataViewName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRId() != null) {
            object = pSSysViewPanelItemBase.getPSDEDRId();
            xmlNode.setAttribute(FIELD_PSDEDRID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRItemId() != null) {
            object = pSSysViewPanelItemBase.getPSDEDRItemId();
            xmlNode.setAttribute(FIELD_PSDEDRITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRItemName() != null) {
            object = pSSysViewPanelItemBase.getPSDEDRItemName();
            xmlNode.setAttribute(FIELD_PSDEDRITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEDRName() != null) {
            object = pSSysViewPanelItemBase.getPSDEDRName();
            xmlNode.setAttribute(FIELD_PSDEDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEFormId() != null) {
            object = pSSysViewPanelItemBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEFormName() != null) {
            object = pSSysViewPanelItemBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEGridId() != null) {
            object = pSSysViewPanelItemBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEGridName() != null) {
            object = pSSysViewPanelItemBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEId() != null) {
            object = pSSysViewPanelItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEListId() != null) {
            object = pSSysViewPanelItemBase.getPSDEListId();
            xmlNode.setAttribute(FIELD_PSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEListName() != null) {
            object = pSSysViewPanelItemBase.getPSDEListName();
            xmlNode.setAttribute(FIELD_PSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDELogicId() != null) {
            object = pSSysViewPanelItemBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDELogicName() != null) {
            object = pSSysViewPanelItemBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEName() != null) {
            object = pSSysViewPanelItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEPanelId() != null) {
            object = pSSysViewPanelItemBase.getPSDEPanelId();
            xmlNode.setAttribute(FIELD_PSDEPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEPanelName() != null) {
            object = pSSysViewPanelItemBase.getPSDEPanelName();
            xmlNode.setAttribute(FIELD_PSDEPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEReportId() != null) {
            object = pSSysViewPanelItemBase.getPSDEReportId();
            xmlNode.setAttribute(FIELD_PSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEReportName() != null) {
            object = pSSysViewPanelItemBase.getPSDEReportName();
            xmlNode.setAttribute(FIELD_PSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDESearchFormId() != null) {
            object = pSSysViewPanelItemBase.getPSDESearchFormId();
            xmlNode.setAttribute(FIELD_PSDESEARCHFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDESearchFormName() != null) {
            object = pSSysViewPanelItemBase.getPSDESearchFormName();
            xmlNode.setAttribute(FIELD_PSDESEARCHFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEToolbarId() != null) {
            object = pSSysViewPanelItemBase.getPSDEToolbarId();
            xmlNode.setAttribute(FIELD_PSDETOOLBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEToolbarName() != null) {
            object = pSSysViewPanelItemBase.getPSDEToolbarName();
            xmlNode.setAttribute(FIELD_PSDETOOLBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDETreeViewId() != null) {
            object = pSSysViewPanelItemBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDETreeViewName() != null) {
            object = pSSysViewPanelItemBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUAGroupId() != null) {
            object = pSSysViewPanelItemBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUAGroupName() != null) {
            object = pSSysViewPanelItemBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUIActionId() != null) {
            object = pSSysViewPanelItemBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEUIActionName() != null) {
            object = pSSysViewPanelItemBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEViewBaseId() != null) {
            object = pSSysViewPanelItemBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEViewBaseName() != null) {
            object = pSSysViewPanelItemBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEWizardId() != null) {
            object = pSSysViewPanelItemBase.getPSDEWizardId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSDEWizardName() != null) {
            object = pSSysViewPanelItemBase.getPSDEWizardName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCalendarId() != null) {
            object = pSSysViewPanelItemBase.getPSSysCalendarId();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCalendarName() != null) {
            object = pSSysViewPanelItemBase.getPSSysCalendarName();
            xmlNode.setAttribute(FIELD_PSSYSCALENDARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCounterId() != null) {
            object = pSSysViewPanelItemBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCounterName() != null) {
            object = pSSysViewPanelItemBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCssId() != null) {
            object = pSSysViewPanelItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysCssName() != null) {
            object = pSSysViewPanelItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDashboardId() != null) {
            object = pSSysViewPanelItemBase.getPSSysDashboardId();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDashboardName() != null) {
            object = pSSysViewPanelItemBase.getPSSysDashboardName();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDynaModelId() != null) {
            object = pSSysViewPanelItemBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysDynaModelName() != null) {
            object = pSSysViewPanelItemBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysEditorStyleId() != null) {
            object = pSSysViewPanelItemBase.getPSSysEditorStyleId();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysEditorStyleName() != null) {
            object = pSSysViewPanelItemBase.getPSSysEditorStyleName();
            xmlNode.setAttribute(FIELD_PSSYSEDITORSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysImageId() != null) {
            object = pSSysViewPanelItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysImageName() != null) {
            object = pSSysViewPanelItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysMapViewId() != null) {
            object = pSSysViewPanelItemBase.getPSSysMapViewId();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysMapViewName() != null) {
            object = pSSysViewPanelItemBase.getPSSysMapViewName();
            xmlNode.setAttribute(FIELD_PSSYSMAPVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysPFPluginId() != null) {
            object = pSSysViewPanelItemBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysPFPluginName() != null) {
            object = pSSysViewPanelItemBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysResourceId() != null) {
            object = pSSysViewPanelItemBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysResourceName() != null) {
            object = pSSysViewPanelItemBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysSearchBarId() != null) {
            object = pSSysViewPanelItemBase.getPSSysSearchBarId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysSearchBarName() != null) {
            object = pSSysViewPanelItemBase.getPSSysSearchBarName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHBARNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelId() != null) {
            object = pSSysViewPanelItemBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelItemId() != null) {
            object = pSSysViewPanelItemBase.getPSSysViewPanelItemId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelItemName() != null) {
            object = pSSysViewPanelItemBase.getPSSysViewPanelItemName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getPSSysViewPanelName() != null) {
            object = pSSysViewPanelItemBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRawContent() != null) {
            object = pSSysViewPanelItemBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRawCssStyle() != null) {
            object = pSSysViewPanelItemBase.getRawCssStyle();
            xmlNode.setAttribute(FIELD_RAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRawServiceMethod() != null) {
            object = pSSysViewPanelItemBase.getRawServiceMethod();
            xmlNode.setAttribute(FIELD_RAWSERVICEMETHOD, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRawServiceUrl() != null) {
            object = pSSysViewPanelItemBase.getRawServiceUrl();
            xmlNode.setAttribute(FIELD_RAWSERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getReadOnlyMode() != null) {
            object = pSSysViewPanelItemBase.getReadOnlyMode();
            xmlNode.setAttribute(FIELD_READONLYMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrl2Name() != null) {
            object = pSSysViewPanelItemBase.getRefCtrl2Name();
            xmlNode.setAttribute(FIELD_REFCTRL2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrl2Usage() != null) {
            object = pSSysViewPanelItemBase.getRefCtrl2Usage();
            xmlNode.setAttribute(FIELD_REFCTRL2USAGE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrl2UsageText() != null) {
            object = pSSysViewPanelItemBase.getRefCtrl2UsageText();
            xmlNode.setAttribute(FIELD_REFCTRL2USAGETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrlName() != null) {
            object = pSSysViewPanelItemBase.getRefCtrlName();
            xmlNode.setAttribute(FIELD_REFCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrlUsage() != null) {
            object = pSSysViewPanelItemBase.getRefCtrlUsage();
            xmlNode.setAttribute(FIELD_REFCTRLUSAGE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefCtrlUsageText() != null) {
            object = pSSysViewPanelItemBase.getRefCtrlUsageText();
            xmlNode.setAttribute(FIELD_REFCTRLUSAGETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefLinkPSDEViewId() != null) {
            object = pSSysViewPanelItemBase.getRefLinkPSDEViewId();
            xmlNode.setAttribute(FIELD_REFLINKPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefLinkPSDEViewName() != null) {
            object = pSSysViewPanelItemBase.getRefLinkPSDEViewName();
            xmlNode.setAttribute(FIELD_REFLINKPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPickupPSDEViewId() != null) {
            object = pSSysViewPanelItemBase.getRefPickupPSDEViewId();
            xmlNode.setAttribute(FIELD_REFPICKUPPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPickupPSDEViewName() != null) {
            object = pSSysViewPanelItemBase.getRefPickupPSDEViewName();
            xmlNode.setAttribute(FIELD_REFPICKUPPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEACModeId() != null) {
            object = pSSysViewPanelItemBase.getRefPSDEACModeId();
            xmlNode.setAttribute(FIELD_REFPSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEACModeName() != null) {
            object = pSSysViewPanelItemBase.getRefPSDEACModeName();
            xmlNode.setAttribute(FIELD_REFPSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEDataSetId() != null) {
            object = pSSysViewPanelItemBase.getRefPSDEDataSetId();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEDataSetName() != null) {
            object = pSSysViewPanelItemBase.getRefPSDEDataSetName();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEId() != null) {
            object = pSSysViewPanelItemBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRefPSDEName() != null) {
            object = pSSysViewPanelItemBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRenderMode() != null) {
            object = pSSysViewPanelItemBase.getRenderMode();
            xmlNode.setAttribute(FIELD_RENDERMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRenderModeText() != null) {
            object = pSSysViewPanelItemBase.getRenderModeText();
            xmlNode.setAttribute(FIELD_RENDERMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getResetItemName() != null) {
            object = pSSysViewPanelItemBase.getResetItemName();
            xmlNode.setAttribute(FIELD_RESETITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getRightPos() != null) {
            object = pSSysViewPanelItemBase.getRightPos();
            xmlNode.setAttribute(FIELD_RIGHTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getRowSpan() != null) {
            object = pSSysViewPanelItemBase.getRowSpan();
            xmlNode.setAttribute(FIELD_ROWSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getShowCaption() != null) {
            object = pSSysViewPanelItemBase.getShowCaption();
            xmlNode.setAttribute(FIELD_SHOWCAPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getSpacingBottom() != null) {
            object = pSSysViewPanelItemBase.getSpacingBottom();
            xmlNode.setAttribute(FIELD_SPACINGBOTTOM, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getSpacingLeft() != null) {
            object = pSSysViewPanelItemBase.getSpacingLeft();
            xmlNode.setAttribute(FIELD_SPACINGLEFT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getSpacingRight() != null) {
            object = pSSysViewPanelItemBase.getSpacingRight();
            xmlNode.setAttribute(FIELD_SPACINGRIGHT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getSpacingTop() != null) {
            object = pSSysViewPanelItemBase.getSpacingTop();
            xmlNode.setAttribute(FIELD_SPACINGTOP, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getSwapMode() != null) {
            object = pSSysViewPanelItemBase.getSwapMode();
            xmlNode.setAttribute(FIELD_SWAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTabIndex() != null) {
            object = pSSysViewPanelItemBase.getTabIndex();
            xmlNode.setAttribute(FIELD_TABINDEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getTargetId() != null) {
            object = pSSysViewPanelItemBase.getTargetId();
            xmlNode.setAttribute(FIELD_TARGETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTargetName() != null) {
            object = pSSysViewPanelItemBase.getTargetName();
            xmlNode.setAttribute(FIELD_TARGETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTargetType() != null) {
            object = pSSysViewPanelItemBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTemplateMode() != null) {
            object = pSSysViewPanelItemBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getTipPSLanResId() != null) {
            object = pSSysViewPanelItemBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTipPSLanResName() != null) {
            object = pSSysViewPanelItemBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTitleBarCloseMode() != null) {
            object = pSSysViewPanelItemBase.getTitleBarCloseMode();
            xmlNode.setAttribute(FIELD_TITLEBARCLOSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getToggleMode() != null) {
            object = pSSysViewPanelItemBase.getToggleMode();
            xmlNode.setAttribute(FIELD_TOGGLEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTooltipInfo() != null) {
            object = pSSysViewPanelItemBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getTopPos() != null) {
            object = pSSysViewPanelItemBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getUpdateDate() != null) {
            object = pSSysViewPanelItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getUpdateMan() != null) {
            object = pSSysViewPanelItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getUserTag() != null) {
            object = pSSysViewPanelItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getUserTag2() != null) {
            object = pSSysViewPanelItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getVAlign() != null) {
            object = pSSysViewPanelItemBase.getVAlign();
            xmlNode.setAttribute(FIELD_VALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getVAlignSelf() != null) {
            object = pSSysViewPanelItemBase.getVAlignSelf();
            xmlNode.setAttribute(FIELD_VALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getValueFormat() != null) {
            object = pSSysViewPanelItemBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getValueItemName() != null) {
            object = pSSysViewPanelItemBase.getValueItemName();
            xmlNode.setAttribute(FIELD_VALUEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getVisibleLogic() != null) {
            object = pSSysViewPanelItemBase.getVisibleLogic();
            xmlNode.setAttribute(FIELD_VISIBLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelItemBase.getWidth() != null) {
            object = pSSysViewPanelItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelItemBase.getWidthMode() != null) {
            object = pSSysViewPanelItemBase.getWidthMode();
            xmlNode.setAttribute(FIELD_WIDTHMODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysViewPanelItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysViewPanelItemBase pSSysViewPanelItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysViewPanelItemBase.isActiveDataModeDirty() && (bl || pSSysViewPanelItemBase.getActiveDataMode() != null)) {
            iDataObject.set(FIELD_ACTIVEDATAMODE, (Object)pSSysViewPanelItemBase.getActiveDataMode());
        }
        if (pSSysViewPanelItemBase.isADPSDELogicIdDirty() && (bl || pSSysViewPanelItemBase.getADPSDELogicId() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICID, (Object)pSSysViewPanelItemBase.getADPSDELogicId());
        }
        if (pSSysViewPanelItemBase.isADPSDELogicNameDirty() && (bl || pSSysViewPanelItemBase.getADPSDELogicName() != null)) {
            iDataObject.set(FIELD_ADPSDELOGICNAME, (Object)pSSysViewPanelItemBase.getADPSDELogicName());
        }
        if (pSSysViewPanelItemBase.isAL_PosDirty() && (bl || pSSysViewPanelItemBase.getAL_Pos() != null)) {
            iDataObject.set(FIELD_AL_POS, (Object)pSSysViewPanelItemBase.getAL_Pos());
        }
        if (pSSysViewPanelItemBase.isBlankLogicDirty() && (bl || pSSysViewPanelItemBase.getBlankLogic() != null)) {
            iDataObject.set(FIELD_BLANKLOGIC, (Object)pSSysViewPanelItemBase.getBlankLogic());
        }
        if (pSSysViewPanelItemBase.isBL_PosDirty() && (bl || pSSysViewPanelItemBase.getBL_Pos() != null)) {
            iDataObject.set(FIELD_BL_POS, (Object)pSSysViewPanelItemBase.getBL_Pos());
        }
        if (pSSysViewPanelItemBase.isBorderStyleDirty() && (bl || pSSysViewPanelItemBase.getBorderStyle() != null)) {
            iDataObject.set(FIELD_BORDERSTYLE, (Object)pSSysViewPanelItemBase.getBorderStyle());
        }
        if (pSSysViewPanelItemBase.isBottomPosDirty() && (bl || pSSysViewPanelItemBase.getBottomPos() != null)) {
            iDataObject.set(FIELD_BOTTOMPOS, (Object)pSSysViewPanelItemBase.getBottomPos());
        }
        if (pSSysViewPanelItemBase.isBtnActionTypeDirty() && (bl || pSSysViewPanelItemBase.getBtnActionType() != null)) {
            iDataObject.set(FIELD_BTNACTIONTYPE, (Object)pSSysViewPanelItemBase.getBtnActionType());
        }
        if (pSSysViewPanelItemBase.isBusyIndicatorDirty() && (bl || pSSysViewPanelItemBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSSysViewPanelItemBase.getBusyIndicator());
        }
        if (pSSysViewPanelItemBase.isCapPSLanResIdDirty() && (bl || pSSysViewPanelItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSSysViewPanelItemBase.getCapPSLanResId());
        }
        if (pSSysViewPanelItemBase.isCapPSLanResNameDirty() && (bl || pSSysViewPanelItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSSysViewPanelItemBase.getCapPSLanResName());
        }
        if (pSSysViewPanelItemBase.isCaptionDirty() && (bl || pSSysViewPanelItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSSysViewPanelItemBase.getCaption());
        }
        if (pSSysViewPanelItemBase.isCaptionPosDirty() && (bl || pSSysViewPanelItemBase.getCaptionPos() != null)) {
            iDataObject.set(FIELD_CAPTIONPOS, (Object)pSSysViewPanelItemBase.getCaptionPos());
        }
        if (pSSysViewPanelItemBase.isChild_Col_LGDirty() && (bl || pSSysViewPanelItemBase.getChild_Col_LG() != null)) {
            iDataObject.set(FIELD_CHILD_COL_LG, (Object)pSSysViewPanelItemBase.getChild_Col_LG());
        }
        if (pSSysViewPanelItemBase.isChild_Col_MDDirty() && (bl || pSSysViewPanelItemBase.getChild_Col_MD() != null)) {
            iDataObject.set(FIELD_CHILD_COL_MD, (Object)pSSysViewPanelItemBase.getChild_Col_MD());
        }
        if (pSSysViewPanelItemBase.isChild_Col_SMDirty() && (bl || pSSysViewPanelItemBase.getChild_Col_SM() != null)) {
            iDataObject.set(FIELD_CHILD_COL_SM, (Object)pSSysViewPanelItemBase.getChild_Col_SM());
        }
        if (pSSysViewPanelItemBase.isChild_Col_XSDirty() && (bl || pSSysViewPanelItemBase.getChild_Col_XS() != null)) {
            iDataObject.set(FIELD_CHILD_COL_XS, (Object)pSSysViewPanelItemBase.getChild_Col_XS());
        }
        if (pSSysViewPanelItemBase.isColIdDirty() && (bl || pSSysViewPanelItemBase.getColId() != null)) {
            iDataObject.set(FIELD_COLID, (Object)pSSysViewPanelItemBase.getColId());
        }
        if (pSSysViewPanelItemBase.isCollapsibleFlagDirty() && (bl || pSSysViewPanelItemBase.getCollapsibleFlag() != null)) {
            iDataObject.set(FIELD_COLLAPSIBLEFLAG, (Object)pSSysViewPanelItemBase.getCollapsibleFlag());
        }
        if (pSSysViewPanelItemBase.isColModelDirty() && (bl || pSSysViewPanelItemBase.getColModel() != null)) {
            iDataObject.set(FIELD_COLMODEL, (Object)pSSysViewPanelItemBase.getColModel());
        }
        if (pSSysViewPanelItemBase.isColSpanDirty() && (bl || pSSysViewPanelItemBase.getColSpan() != null)) {
            iDataObject.set(FIELD_COLSPAN, (Object)pSSysViewPanelItemBase.getColSpan());
        }
        if (pSSysViewPanelItemBase.isCol_LGDirty() && (bl || pSSysViewPanelItemBase.getCol_LG() != null)) {
            iDataObject.set(FIELD_COL_LG, (Object)pSSysViewPanelItemBase.getCol_LG());
        }
        if (pSSysViewPanelItemBase.isCol_LG_OSDirty() && (bl || pSSysViewPanelItemBase.getCol_LG_OS() != null)) {
            iDataObject.set(FIELD_COL_LG_OS, (Object)pSSysViewPanelItemBase.getCol_LG_OS());
        }
        if (pSSysViewPanelItemBase.isCol_MDDirty() && (bl || pSSysViewPanelItemBase.getCol_MD() != null)) {
            iDataObject.set(FIELD_COL_MD, (Object)pSSysViewPanelItemBase.getCol_MD());
        }
        if (pSSysViewPanelItemBase.isCol_MD_OSDirty() && (bl || pSSysViewPanelItemBase.getCol_MD_OS() != null)) {
            iDataObject.set(FIELD_COL_MD_OS, (Object)pSSysViewPanelItemBase.getCol_MD_OS());
        }
        if (pSSysViewPanelItemBase.isCol_SMDirty() && (bl || pSSysViewPanelItemBase.getCol_SM() != null)) {
            iDataObject.set(FIELD_COL_SM, (Object)pSSysViewPanelItemBase.getCol_SM());
        }
        if (pSSysViewPanelItemBase.isCol_SM_OSDirty() && (bl || pSSysViewPanelItemBase.getCol_SM_OS() != null)) {
            iDataObject.set(FIELD_COL_SM_OS, (Object)pSSysViewPanelItemBase.getCol_SM_OS());
        }
        if (pSSysViewPanelItemBase.isCol_WidthDirty() && (bl || pSSysViewPanelItemBase.getCol_Width() != null)) {
            iDataObject.set(FIELD_COL_WIDTH, (Object)pSSysViewPanelItemBase.getCol_Width());
        }
        if (pSSysViewPanelItemBase.isCol_XSDirty() && (bl || pSSysViewPanelItemBase.getCol_XS() != null)) {
            iDataObject.set(FIELD_COL_XS, (Object)pSSysViewPanelItemBase.getCol_XS());
        }
        if (pSSysViewPanelItemBase.isCol_XS_OSDirty() && (bl || pSSysViewPanelItemBase.getCol_XS_OS() != null)) {
            iDataObject.set(FIELD_COL_XS_OS, (Object)pSSysViewPanelItemBase.getCol_XS_OS());
        }
        if (pSSysViewPanelItemBase.isContentTypeDirty() && (bl || pSSysViewPanelItemBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSSysViewPanelItemBase.getContentType());
        }
        if (pSSysViewPanelItemBase.isCounterIdDirty() && (bl || pSSysViewPanelItemBase.getCounterId() != null)) {
            iDataObject.set(FIELD_COUNTERID, (Object)pSSysViewPanelItemBase.getCounterId());
        }
        if (pSSysViewPanelItemBase.isCounterModeDirty() && (bl || pSSysViewPanelItemBase.getCounterMode() != null)) {
            iDataObject.set(FIELD_COUNTERMODE, (Object)pSSysViewPanelItemBase.getCounterMode());
        }
        if (pSSysViewPanelItemBase.isCreateDateDirty() && (bl || pSSysViewPanelItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysViewPanelItemBase.getCreateDate());
        }
        if (pSSysViewPanelItemBase.isCreateManDirty() && (bl || pSSysViewPanelItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysViewPanelItemBase.getCreateMan());
        }
        if (pSSysViewPanelItemBase.isCssIdDirty() && (bl || pSSysViewPanelItemBase.getCssId() != null)) {
            iDataObject.set(FIELD_CSSID, (Object)pSSysViewPanelItemBase.getCssId());
        }
        if (pSSysViewPanelItemBase.isCtrlDynaClassDirty() && (bl || pSSysViewPanelItemBase.getCtrlDynaClass() != null)) {
            iDataObject.set(FIELD_CTRLDYNACLASS, (Object)pSSysViewPanelItemBase.getCtrlDynaClass());
        }
        if (pSSysViewPanelItemBase.isCtrlHeightDirty() && (bl || pSSysViewPanelItemBase.getCtrlHeight() != null)) {
            iDataObject.set(FIELD_CTRLHEIGHT, (Object)pSSysViewPanelItemBase.getCtrlHeight());
        }
        if (pSSysViewPanelItemBase.isCtrlPSSysCssIdDirty() && (bl || pSSysViewPanelItemBase.getCtrlPSSysCssId() != null)) {
            iDataObject.set(FIELD_CTRLPSSYSCSSID, (Object)pSSysViewPanelItemBase.getCtrlPSSysCssId());
        }
        if (pSSysViewPanelItemBase.isCtrlPSSysCssNameDirty() && (bl || pSSysViewPanelItemBase.getCtrlPSSysCssName() != null)) {
            iDataObject.set(FIELD_CTRLPSSYSCSSNAME, (Object)pSSysViewPanelItemBase.getCtrlPSSysCssName());
        }
        if (pSSysViewPanelItemBase.isCtrlRawCssStyleDirty() && (bl || pSSysViewPanelItemBase.getCtrlRawCssStyle() != null)) {
            iDataObject.set(FIELD_CTRLRAWCSSSTYLE, (Object)pSSysViewPanelItemBase.getCtrlRawCssStyle());
        }
        if (pSSysViewPanelItemBase.isCtrlTypeDirty() && (bl || pSSysViewPanelItemBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSSysViewPanelItemBase.getCtrlType());
        }
        if (pSSysViewPanelItemBase.isCtrlWidthDirty() && (bl || pSSysViewPanelItemBase.getCtrlWidth() != null)) {
            iDataObject.set(FIELD_CTRLWIDTH, (Object)pSSysViewPanelItemBase.getCtrlWidth());
        }
        if (pSSysViewPanelItemBase.isCustomCodeDirty() && (bl || pSSysViewPanelItemBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysViewPanelItemBase.getCustomCode());
        }
        if (pSSysViewPanelItemBase.isCustomModeDirty() && (bl || pSSysViewPanelItemBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysViewPanelItemBase.getCustomMode());
        }
        if (pSSysViewPanelItemBase.isDataPanelModeDirty() && (bl || pSSysViewPanelItemBase.getDataPanelMode() != null)) {
            iDataObject.set(FIELD_DATAPANELMODE, (Object)pSSysViewPanelItemBase.getDataPanelMode());
        }
        if (pSSysViewPanelItemBase.isDataSourceDirty() && (bl || pSSysViewPanelItemBase.getDataSource() != null)) {
            iDataObject.set(FIELD_DATASOURCE, (Object)pSSysViewPanelItemBase.getDataSource());
        }
        if (pSSysViewPanelItemBase.isDataSourceTextDirty() && (bl || pSSysViewPanelItemBase.getDataSourceText() != null)) {
            iDataObject.set(FIELD_DATASOURCETEXT, (Object)pSSysViewPanelItemBase.getDataSourceText());
        }
        if (pSSysViewPanelItemBase.isDetailStyleDirty() && (bl || pSSysViewPanelItemBase.getDetailStyle() != null)) {
            iDataObject.set(FIELD_DETAILSTYLE, (Object)pSSysViewPanelItemBase.getDetailStyle());
        }
        if (pSSysViewPanelItemBase.isDetailStyleTextDirty() && (bl || pSSysViewPanelItemBase.getDetailStyleText() != null)) {
            iDataObject.set(FIELD_DETAILSTYLETEXT, (Object)pSSysViewPanelItemBase.getDetailStyleText());
        }
        if (pSSysViewPanelItemBase.isDynaClassDirty() && (bl || pSSysViewPanelItemBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSSysViewPanelItemBase.getDynaClass());
        }
        if (pSSysViewPanelItemBase.isEditorTypeDirty() && (bl || pSSysViewPanelItemBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSSysViewPanelItemBase.getEditorType());
        }
        if (pSSysViewPanelItemBase.isEditorTypeNameDirty() && (bl || pSSysViewPanelItemBase.getEditorTypeName() != null)) {
            iDataObject.set(FIELD_EDITORTYPENAME, (Object)pSSysViewPanelItemBase.getEditorTypeName());
        }
        if (pSSysViewPanelItemBase.isEmptyCaptionDirty() && (bl || pSSysViewPanelItemBase.getEmptyCaption() != null)) {
            iDataObject.set(FIELD_EMPTYCAPTION, (Object)pSSysViewPanelItemBase.getEmptyCaption());
        }
        if (pSSysViewPanelItemBase.isEnableAnchorDirty() && (bl || pSSysViewPanelItemBase.getEnableAnchor() != null)) {
            iDataObject.set(FIELD_ENABLEANCHOR, (Object)pSSysViewPanelItemBase.getEnableAnchor());
        }
        if (pSSysViewPanelItemBase.isEnableLogicDirty() && (bl || pSSysViewPanelItemBase.getEnableLogic() != null)) {
            iDataObject.set(FIELD_ENABLELOGIC, (Object)pSSysViewPanelItemBase.getEnableLogic());
        }
        if (pSSysViewPanelItemBase.isFieldNameDirty() && (bl || pSSysViewPanelItemBase.getFieldName() != null)) {
            iDataObject.set(FIELD_FIELDNAME, (Object)pSSysViewPanelItemBase.getFieldName());
        }
        if (pSSysViewPanelItemBase.isFieldStatesDirty() && (bl || pSSysViewPanelItemBase.getFieldStates() != null)) {
            iDataObject.set(FIELD_FIELDSTATES, (Object)pSSysViewPanelItemBase.getFieldStates());
        }
        if (pSSysViewPanelItemBase.isFlexAlignDirty() && (bl || pSSysViewPanelItemBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSSysViewPanelItemBase.getFlexAlign());
        }
        if (pSSysViewPanelItemBase.isFlexBasisDirty() && (bl || pSSysViewPanelItemBase.getFlexBasis() != null)) {
            iDataObject.set(FIELD_FLEXBASIS, (Object)pSSysViewPanelItemBase.getFlexBasis());
        }
        if (pSSysViewPanelItemBase.isFlexDirDirty() && (bl || pSSysViewPanelItemBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSSysViewPanelItemBase.getFlexDir());
        }
        if (pSSysViewPanelItemBase.isFlexGrowDirty() && (bl || pSSysViewPanelItemBase.getFlexGrow() != null)) {
            iDataObject.set(FIELD_FLEXGROW, (Object)pSSysViewPanelItemBase.getFlexGrow());
        }
        if (pSSysViewPanelItemBase.isFlexShrinkDirty() && (bl || pSSysViewPanelItemBase.getFlexShrink() != null)) {
            iDataObject.set(FIELD_FLEXSHRINK, (Object)pSSysViewPanelItemBase.getFlexShrink());
        }
        if (pSSysViewPanelItemBase.isFlexVAlignDirty() && (bl || pSSysViewPanelItemBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSSysViewPanelItemBase.getFlexVAlign());
        }
        if (pSSysViewPanelItemBase.isGetDataTimerDirty() && (bl || pSSysViewPanelItemBase.getGetDataTimer() != null)) {
            iDataObject.set(FIELD_GETDATATIMER, (Object)pSSysViewPanelItemBase.getGetDataTimer());
        }
        if (pSSysViewPanelItemBase.isGridRowIdDirty() && (bl || pSSysViewPanelItemBase.getGridRowId() != null)) {
            iDataObject.set(FIELD_GRIDROWID, (Object)pSSysViewPanelItemBase.getGridRowId());
        }
        if (pSSysViewPanelItemBase.isHAlignDirty() && (bl || pSSysViewPanelItemBase.getHAlign() != null)) {
            iDataObject.set(FIELD_HALIGN, (Object)pSSysViewPanelItemBase.getHAlign());
        }
        if (pSSysViewPanelItemBase.isHAlignSelfDirty() && (bl || pSSysViewPanelItemBase.getHAlignSelf() != null)) {
            iDataObject.set(FIELD_HALIGNSELF, (Object)pSSysViewPanelItemBase.getHAlignSelf());
        }
        if (pSSysViewPanelItemBase.isHeightDirty() && (bl || pSSysViewPanelItemBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSSysViewPanelItemBase.getHeight());
        }
        if (pSSysViewPanelItemBase.isHeightModeDirty() && (bl || pSSysViewPanelItemBase.getHeightMode() != null)) {
            iDataObject.set(FIELD_HEIGHTMODE, (Object)pSSysViewPanelItemBase.getHeightMode());
        }
        if (pSSysViewPanelItemBase.isHtmlContentDirty() && (bl || pSSysViewPanelItemBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSSysViewPanelItemBase.getHtmlContent());
        }
        if (pSSysViewPanelItemBase.isHtmlPageUrlDirty() && (bl || pSSysViewPanelItemBase.getHtmlPageUrl() != null)) {
            iDataObject.set(FIELD_HTMLPAGEURL, (Object)pSSysViewPanelItemBase.getHtmlPageUrl());
        }
        if (pSSysViewPanelItemBase.isIconAlignDirty() && (bl || pSSysViewPanelItemBase.getIconAlign() != null)) {
            iDataObject.set(FIELD_ICONALIGN, (Object)pSSysViewPanelItemBase.getIconAlign());
        }
        if (pSSysViewPanelItemBase.isIgnoreInputDirty() && (bl || pSSysViewPanelItemBase.getIgnoreInput() != null)) {
            iDataObject.set(FIELD_IGNOREINPUT, (Object)pSSysViewPanelItemBase.getIgnoreInput());
        }
        if (pSSysViewPanelItemBase.isItemParamDirty() && (bl || pSSysViewPanelItemBase.getItemParam() != null)) {
            iDataObject.set(FIELD_ITEMPARAM, (Object)pSSysViewPanelItemBase.getItemParam());
        }
        if (pSSysViewPanelItemBase.isItemParam10Dirty() && (bl || pSSysViewPanelItemBase.getItemParam10() != null)) {
            iDataObject.set(FIELD_ITEMPARAM10, (Object)pSSysViewPanelItemBase.getItemParam10());
        }
        if (pSSysViewPanelItemBase.isItemParam11Dirty() && (bl || pSSysViewPanelItemBase.getItemParam11() != null)) {
            iDataObject.set(FIELD_ITEMPARAM11, (Object)pSSysViewPanelItemBase.getItemParam11());
        }
        if (pSSysViewPanelItemBase.isItemParam12Dirty() && (bl || pSSysViewPanelItemBase.getItemParam12() != null)) {
            iDataObject.set(FIELD_ITEMPARAM12, (Object)pSSysViewPanelItemBase.getItemParam12());
        }
        if (pSSysViewPanelItemBase.isItemParam2Dirty() && (bl || pSSysViewPanelItemBase.getItemParam2() != null)) {
            iDataObject.set(FIELD_ITEMPARAM2, (Object)pSSysViewPanelItemBase.getItemParam2());
        }
        if (pSSysViewPanelItemBase.isItemParam3Dirty() && (bl || pSSysViewPanelItemBase.getItemParam3() != null)) {
            iDataObject.set(FIELD_ITEMPARAM3, (Object)pSSysViewPanelItemBase.getItemParam3());
        }
        if (pSSysViewPanelItemBase.isItemParam4Dirty() && (bl || pSSysViewPanelItemBase.getItemParam4() != null)) {
            iDataObject.set(FIELD_ITEMPARAM4, (Object)pSSysViewPanelItemBase.getItemParam4());
        }
        if (pSSysViewPanelItemBase.isItemParam5Dirty() && (bl || pSSysViewPanelItemBase.getItemParam5() != null)) {
            iDataObject.set(FIELD_ITEMPARAM5, (Object)pSSysViewPanelItemBase.getItemParam5());
        }
        if (pSSysViewPanelItemBase.isItemParam6Dirty() && (bl || pSSysViewPanelItemBase.getItemParam6() != null)) {
            iDataObject.set(FIELD_ITEMPARAM6, (Object)pSSysViewPanelItemBase.getItemParam6());
        }
        if (pSSysViewPanelItemBase.isItemParam7Dirty() && (bl || pSSysViewPanelItemBase.getItemParam7() != null)) {
            iDataObject.set(FIELD_ITEMPARAM7, (Object)pSSysViewPanelItemBase.getItemParam7());
        }
        if (pSSysViewPanelItemBase.isItemParam8Dirty() && (bl || pSSysViewPanelItemBase.getItemParam8() != null)) {
            iDataObject.set(FIELD_ITEMPARAM8, (Object)pSSysViewPanelItemBase.getItemParam8());
        }
        if (pSSysViewPanelItemBase.isItemParam9Dirty() && (bl || pSSysViewPanelItemBase.getItemParam9() != null)) {
            iDataObject.set(FIELD_ITEMPARAM9, (Object)pSSysViewPanelItemBase.getItemParam9());
        }
        if (pSSysViewPanelItemBase.isItemParamsDirty() && (bl || pSSysViewPanelItemBase.getItemParams() != null)) {
            iDataObject.set(FIELD_ITEMPARAMS, (Object)pSSysViewPanelItemBase.getItemParams());
        }
        if (pSSysViewPanelItemBase.isItemTypeDirty() && (bl || pSSysViewPanelItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSSysViewPanelItemBase.getItemType());
        }
        if (pSSysViewPanelItemBase.isLabelDynaClassDirty() && (bl || pSSysViewPanelItemBase.getLabelDynaClass() != null)) {
            iDataObject.set(FIELD_LABELDYNACLASS, (Object)pSSysViewPanelItemBase.getLabelDynaClass());
        }
        if (pSSysViewPanelItemBase.isLabelPSSysCssIdDirty() && (bl || pSSysViewPanelItemBase.getLabelPSSysCssId() != null)) {
            iDataObject.set(FIELD_LABELPSSYSCSSID, (Object)pSSysViewPanelItemBase.getLabelPSSysCssId());
        }
        if (pSSysViewPanelItemBase.isLabelPSSysCssNameDirty() && (bl || pSSysViewPanelItemBase.getLabelPSSysCssName() != null)) {
            iDataObject.set(FIELD_LABELPSSYSCSSNAME, (Object)pSSysViewPanelItemBase.getLabelPSSysCssName());
        }
        if (pSSysViewPanelItemBase.isLabelRawCssStyleDirty() && (bl || pSSysViewPanelItemBase.getLabelRawCssStyle() != null)) {
            iDataObject.set(FIELD_LABELRAWCSSSTYLE, (Object)pSSysViewPanelItemBase.getLabelRawCssStyle());
        }
        if (pSSysViewPanelItemBase.isLableCssIdDirty() && (bl || pSSysViewPanelItemBase.getLableCssId() != null)) {
            iDataObject.set(FIELD_LABLECSSID, (Object)pSSysViewPanelItemBase.getLableCssId());
        }
        if (pSSysViewPanelItemBase.isLayoutModeDirty() && (bl || pSSysViewPanelItemBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSSysViewPanelItemBase.getLayoutMode());
        }
        if (pSSysViewPanelItemBase.isLeftPosDirty() && (bl || pSSysViewPanelItemBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSSysViewPanelItemBase.getLeftPos());
        }
        if (pSSysViewPanelItemBase.isLogicNameDirty() && (bl || pSSysViewPanelItemBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysViewPanelItemBase.getLogicName());
        }
        if (pSSysViewPanelItemBase.isMemoDirty() && (bl || pSSysViewPanelItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysViewPanelItemBase.getMemo());
        }
        if (pSSysViewPanelItemBase.isMobFlagDirty() && (bl || pSSysViewPanelItemBase.getMobFlag() != null)) {
            iDataObject.set(FIELD_MOBFLAG, (Object)pSSysViewPanelItemBase.getMobFlag());
        }
        if (pSSysViewPanelItemBase.isOpenPSAppViewIdDirty() && (bl || pSSysViewPanelItemBase.getOpenPSAppViewId() != null)) {
            iDataObject.set(FIELD_OPENPSAPPVIEWID, (Object)pSSysViewPanelItemBase.getOpenPSAppViewId());
        }
        if (pSSysViewPanelItemBase.isOpenPSAppViewNameDirty() && (bl || pSSysViewPanelItemBase.getOpenPSAppViewName() != null)) {
            iDataObject.set(FIELD_OPENPSAPPVIEWNAME, (Object)pSSysViewPanelItemBase.getOpenPSAppViewName());
        }
        if (pSSysViewPanelItemBase.isOpenPSDEViewIdDirty() && (bl || pSSysViewPanelItemBase.getOpenPSDEViewId() != null)) {
            iDataObject.set(FIELD_OPENPSDEVIEWID, (Object)pSSysViewPanelItemBase.getOpenPSDEViewId());
        }
        if (pSSysViewPanelItemBase.isOpenPSDEViewNameDirty() && (bl || pSSysViewPanelItemBase.getOpenPSDEViewName() != null)) {
            iDataObject.set(FIELD_OPENPSDEVIEWNAME, (Object)pSSysViewPanelItemBase.getOpenPSDEViewName());
        }
        if (pSSysViewPanelItemBase.isOpenPSSysPDTViewIdDirty() && (bl || pSSysViewPanelItemBase.getOpenPSSysPDTViewId() != null)) {
            iDataObject.set(FIELD_OPENPSSYSPDTVIEWID, (Object)pSSysViewPanelItemBase.getOpenPSSysPDTViewId());
        }
        if (pSSysViewPanelItemBase.isOpenPSSysPDTViewNameDirty() && (bl || pSSysViewPanelItemBase.getOpenPSSysPDTViewName() != null)) {
            iDataObject.set(FIELD_OPENPSSYSPDTVIEWNAME, (Object)pSSysViewPanelItemBase.getOpenPSSysPDTViewName());
        }
        if (pSSysViewPanelItemBase.isOrderValueDirty() && (bl || pSSysViewPanelItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysViewPanelItemBase.getOrderValue());
        }
        if (pSSysViewPanelItemBase.isOrientationModeDirty() && (bl || pSSysViewPanelItemBase.getOrientationMode() != null)) {
            iDataObject.set(FIELD_ORIENTATIONMODE, (Object)pSSysViewPanelItemBase.getOrientationMode());
        }
        if (pSSysViewPanelItemBase.isPHPSLanResIdDirty() && (bl || pSSysViewPanelItemBase.getPHPSLanResId() != null)) {
            iDataObject.set(FIELD_PHPSLANRESID, (Object)pSSysViewPanelItemBase.getPHPSLanResId());
        }
        if (pSSysViewPanelItemBase.isPHPSLanResNameDirty() && (bl || pSSysViewPanelItemBase.getPHPSLanResName() != null)) {
            iDataObject.set(FIELD_PHPSLANRESNAME, (Object)pSSysViewPanelItemBase.getPHPSLanResName());
        }
        if (pSSysViewPanelItemBase.isPlaceHolderDirty() && (bl || pSSysViewPanelItemBase.getPlaceHolder() != null)) {
            iDataObject.set(FIELD_PLACEHOLDER, (Object)pSSysViewPanelItemBase.getPlaceHolder());
        }
        if (pSSysViewPanelItemBase.isPLayoutModeDirty() && (bl || pSSysViewPanelItemBase.getPLayoutMode() != null)) {
            iDataObject.set(FIELD_PLAYOUTMODE, (Object)pSSysViewPanelItemBase.getPLayoutMode());
        }
        if (pSSysViewPanelItemBase.isPPSSysViewPanelItemIdDirty() && (bl || pSSysViewPanelItemBase.getPPSSysViewPanelItemId() != null)) {
            iDataObject.set(FIELD_PPSSYSVIEWPANELITEMID, (Object)pSSysViewPanelItemBase.getPPSSysViewPanelItemId());
        }
        if (pSSysViewPanelItemBase.isPPSSysViewPanelItemNameDirty() && (bl || pSSysViewPanelItemBase.getPPSSysViewPanelItemName() != null)) {
            iDataObject.set(FIELD_PPSSYSVIEWPANELITEMNAME, (Object)pSSysViewPanelItemBase.getPPSSysViewPanelItemName());
        }
        if (pSSysViewPanelItemBase.isPredefinedTypeDirty() && (bl || pSSysViewPanelItemBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSSysViewPanelItemBase.getPredefinedType());
        }
        if (pSSysViewPanelItemBase.isPredefinedTypeTextDirty() && (bl || pSSysViewPanelItemBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSSysViewPanelItemBase.getPredefinedTypeText());
        }
        if (pSSysViewPanelItemBase.isPreviewHtmlDirty() && (bl || pSSysViewPanelItemBase.getPreviewHtml() != null)) {
            iDataObject.set(FIELD_PREVIEWHTML, (Object)pSSysViewPanelItemBase.getPreviewHtml());
        }
        if (pSSysViewPanelItemBase.isPSACHandlerIdDirty() && (bl || pSSysViewPanelItemBase.getPSACHandlerId() != null)) {
            iDataObject.set(FIELD_PSACHANDLERID, (Object)pSSysViewPanelItemBase.getPSACHandlerId());
        }
        if (pSSysViewPanelItemBase.isPSACHandlerNameDirty() && (bl || pSSysViewPanelItemBase.getPSACHandlerName() != null)) {
            iDataObject.set(FIELD_PSACHANDLERNAME, (Object)pSSysViewPanelItemBase.getPSACHandlerName());
        }
        if (pSSysViewPanelItemBase.isPSAppMenuIdDirty() && (bl || pSSysViewPanelItemBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSSysViewPanelItemBase.getPSAppMenuId());
        }
        if (pSSysViewPanelItemBase.isPSAppMenuNameDirty() && (bl || pSSysViewPanelItemBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSSysViewPanelItemBase.getPSAppMenuName());
        }
        if (pSSysViewPanelItemBase.isPSCodeListIdDirty() && (bl || pSSysViewPanelItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysViewPanelItemBase.getPSCodeListId());
        }
        if (pSSysViewPanelItemBase.isPSCodeListNameDirty() && (bl || pSSysViewPanelItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysViewPanelItemBase.getPSCodeListName());
        }
        if (pSSysViewPanelItemBase.isPSCtrlIdDirty() && (bl || pSSysViewPanelItemBase.getPSCtrlId() != null)) {
            iDataObject.set(FIELD_PSCTRLID, (Object)pSSysViewPanelItemBase.getPSCtrlId());
        }
        if (pSSysViewPanelItemBase.isPSCtrlLogicGroupIdDirty() && (bl || pSSysViewPanelItemBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSSysViewPanelItemBase.getPSCtrlLogicGroupId());
        }
        if (pSSysViewPanelItemBase.isPSCtrlLogicGroupNameDirty() && (bl || pSSysViewPanelItemBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSSysViewPanelItemBase.getPSCtrlLogicGroupName());
        }
        if (pSSysViewPanelItemBase.isPSCtrlNameDirty() && (bl || pSSysViewPanelItemBase.getPSCtrlName() != null)) {
            iDataObject.set(FIELD_PSCTRLNAME, (Object)pSSysViewPanelItemBase.getPSCtrlName());
        }
        if (pSSysViewPanelItemBase.isPSDEActionIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSSysViewPanelItemBase.getPSDEActionId());
        }
        if (pSSysViewPanelItemBase.isPSDEActionNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSSysViewPanelItemBase.getPSDEActionName());
        }
        if (pSSysViewPanelItemBase.isPSDEChartIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEChartId() != null)) {
            iDataObject.set(FIELD_PSDECHARTID, (Object)pSSysViewPanelItemBase.getPSDEChartId());
        }
        if (pSSysViewPanelItemBase.isPSDEChartNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEChartName() != null)) {
            iDataObject.set(FIELD_PSDECHARTNAME, (Object)pSSysViewPanelItemBase.getPSDEChartName());
        }
        if (pSSysViewPanelItemBase.isPSDEDataSetIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSSysViewPanelItemBase.getPSDEDataSetId());
        }
        if (pSSysViewPanelItemBase.isPSDEDataSetNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSSysViewPanelItemBase.getPSDEDataSetName());
        }
        if (pSSysViewPanelItemBase.isPSDEDataViewIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWID, (Object)pSSysViewPanelItemBase.getPSDEDataViewId());
        }
        if (pSSysViewPanelItemBase.isPSDEDataViewNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWNAME, (Object)pSSysViewPanelItemBase.getPSDEDataViewName());
        }
        if (pSSysViewPanelItemBase.isPSDEDRIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEDRId() != null)) {
            iDataObject.set(FIELD_PSDEDRID, (Object)pSSysViewPanelItemBase.getPSDEDRId());
        }
        if (pSSysViewPanelItemBase.isPSDEDRItemIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEDRItemId() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMID, (Object)pSSysViewPanelItemBase.getPSDEDRItemId());
        }
        if (pSSysViewPanelItemBase.isPSDEDRItemNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEDRItemName() != null)) {
            iDataObject.set(FIELD_PSDEDRITEMNAME, (Object)pSSysViewPanelItemBase.getPSDEDRItemName());
        }
        if (pSSysViewPanelItemBase.isPSDEDRNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEDRName() != null)) {
            iDataObject.set(FIELD_PSDEDRNAME, (Object)pSSysViewPanelItemBase.getPSDEDRName());
        }
        if (pSSysViewPanelItemBase.isPSDEFormIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSSysViewPanelItemBase.getPSDEFormId());
        }
        if (pSSysViewPanelItemBase.isPSDEFormNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSSysViewPanelItemBase.getPSDEFormName());
        }
        if (pSSysViewPanelItemBase.isPSDEGridIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSSysViewPanelItemBase.getPSDEGridId());
        }
        if (pSSysViewPanelItemBase.isPSDEGridNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSSysViewPanelItemBase.getPSDEGridName());
        }
        if (pSSysViewPanelItemBase.isPSDEIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysViewPanelItemBase.getPSDEId());
        }
        if (pSSysViewPanelItemBase.isPSDEListIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEListId() != null)) {
            iDataObject.set(FIELD_PSDELISTID, (Object)pSSysViewPanelItemBase.getPSDEListId());
        }
        if (pSSysViewPanelItemBase.isPSDEListNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEListName() != null)) {
            iDataObject.set(FIELD_PSDELISTNAME, (Object)pSSysViewPanelItemBase.getPSDEListName());
        }
        if (pSSysViewPanelItemBase.isPSDELogicIdDirty() && (bl || pSSysViewPanelItemBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysViewPanelItemBase.getPSDELogicId());
        }
        if (pSSysViewPanelItemBase.isPSDELogicNameDirty() && (bl || pSSysViewPanelItemBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysViewPanelItemBase.getPSDELogicName());
        }
        if (pSSysViewPanelItemBase.isPSDENameDirty() && (bl || pSSysViewPanelItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysViewPanelItemBase.getPSDEName());
        }
        if (pSSysViewPanelItemBase.isPSDEPanelIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEPanelId() != null)) {
            iDataObject.set(FIELD_PSDEPANELID, (Object)pSSysViewPanelItemBase.getPSDEPanelId());
        }
        if (pSSysViewPanelItemBase.isPSDEPanelNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEPanelName() != null)) {
            iDataObject.set(FIELD_PSDEPANELNAME, (Object)pSSysViewPanelItemBase.getPSDEPanelName());
        }
        if (pSSysViewPanelItemBase.isPSDEReportIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEReportId() != null)) {
            iDataObject.set(FIELD_PSDEREPORTID, (Object)pSSysViewPanelItemBase.getPSDEReportId());
        }
        if (pSSysViewPanelItemBase.isPSDEReportNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEReportName() != null)) {
            iDataObject.set(FIELD_PSDEREPORTNAME, (Object)pSSysViewPanelItemBase.getPSDEReportName());
        }
        if (pSSysViewPanelItemBase.isPSDESearchFormIdDirty() && (bl || pSSysViewPanelItemBase.getPSDESearchFormId() != null)) {
            iDataObject.set(FIELD_PSDESEARCHFORMID, (Object)pSSysViewPanelItemBase.getPSDESearchFormId());
        }
        if (pSSysViewPanelItemBase.isPSDESearchFormNameDirty() && (bl || pSSysViewPanelItemBase.getPSDESearchFormName() != null)) {
            iDataObject.set(FIELD_PSDESEARCHFORMNAME, (Object)pSSysViewPanelItemBase.getPSDESearchFormName());
        }
        if (pSSysViewPanelItemBase.isPSDEToolbarIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEToolbarId() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARID, (Object)pSSysViewPanelItemBase.getPSDEToolbarId());
        }
        if (pSSysViewPanelItemBase.isPSDEToolbarNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEToolbarName() != null)) {
            iDataObject.set(FIELD_PSDETOOLBARNAME, (Object)pSSysViewPanelItemBase.getPSDEToolbarName());
        }
        if (pSSysViewPanelItemBase.isPSDETreeViewIdDirty() && (bl || pSSysViewPanelItemBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSSysViewPanelItemBase.getPSDETreeViewId());
        }
        if (pSSysViewPanelItemBase.isPSDETreeViewNameDirty() && (bl || pSSysViewPanelItemBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSSysViewPanelItemBase.getPSDETreeViewName());
        }
        if (pSSysViewPanelItemBase.isPSDEUAGroupIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSSysViewPanelItemBase.getPSDEUAGroupId());
        }
        if (pSSysViewPanelItemBase.isPSDEUAGroupNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSSysViewPanelItemBase.getPSDEUAGroupName());
        }
        if (pSSysViewPanelItemBase.isPSDEUIActionIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSSysViewPanelItemBase.getPSDEUIActionId());
        }
        if (pSSysViewPanelItemBase.isPSDEUIActionNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSSysViewPanelItemBase.getPSDEUIActionName());
        }
        if (pSSysViewPanelItemBase.isPSDEViewBaseIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSysViewPanelItemBase.getPSDEViewBaseId());
        }
        if (pSSysViewPanelItemBase.isPSDEViewBaseNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSSysViewPanelItemBase.getPSDEViewBaseName());
        }
        if (pSSysViewPanelItemBase.isPSDEWizardIdDirty() && (bl || pSSysViewPanelItemBase.getPSDEWizardId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDID, (Object)pSSysViewPanelItemBase.getPSDEWizardId());
        }
        if (pSSysViewPanelItemBase.isPSDEWizardNameDirty() && (bl || pSSysViewPanelItemBase.getPSDEWizardName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDNAME, (Object)pSSysViewPanelItemBase.getPSDEWizardName());
        }
        if (pSSysViewPanelItemBase.isPSSysCalendarIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysCalendarId() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARID, (Object)pSSysViewPanelItemBase.getPSSysCalendarId());
        }
        if (pSSysViewPanelItemBase.isPSSysCalendarNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysCalendarName() != null)) {
            iDataObject.set(FIELD_PSSYSCALENDARNAME, (Object)pSSysViewPanelItemBase.getPSSysCalendarName());
        }
        if (pSSysViewPanelItemBase.isPSSysCounterIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSSysViewPanelItemBase.getPSSysCounterId());
        }
        if (pSSysViewPanelItemBase.isPSSysCounterNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSSysViewPanelItemBase.getPSSysCounterName());
        }
        if (pSSysViewPanelItemBase.isPSSysCssIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysViewPanelItemBase.getPSSysCssId());
        }
        if (pSSysViewPanelItemBase.isPSSysCssNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysViewPanelItemBase.getPSSysCssName());
        }
        if (pSSysViewPanelItemBase.isPSSysDashboardIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysDashboardId() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDID, (Object)pSSysViewPanelItemBase.getPSSysDashboardId());
        }
        if (pSSysViewPanelItemBase.isPSSysDashboardNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysDashboardName() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDNAME, (Object)pSSysViewPanelItemBase.getPSSysDashboardName());
        }
        if (pSSysViewPanelItemBase.isPSSysDynaModelIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysViewPanelItemBase.getPSSysDynaModelId());
        }
        if (pSSysViewPanelItemBase.isPSSysDynaModelNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysViewPanelItemBase.getPSSysDynaModelName());
        }
        if (pSSysViewPanelItemBase.isPSSysEditorStyleIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysEditorStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLEID, (Object)pSSysViewPanelItemBase.getPSSysEditorStyleId());
        }
        if (pSSysViewPanelItemBase.isPSSysEditorStyleNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysEditorStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSEDITORSTYLENAME, (Object)pSSysViewPanelItemBase.getPSSysEditorStyleName());
        }
        if (pSSysViewPanelItemBase.isPSSysImageIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysViewPanelItemBase.getPSSysImageId());
        }
        if (pSSysViewPanelItemBase.isPSSysImageNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysViewPanelItemBase.getPSSysImageName());
        }
        if (pSSysViewPanelItemBase.isPSSysMapViewIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysMapViewId() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWID, (Object)pSSysViewPanelItemBase.getPSSysMapViewId());
        }
        if (pSSysViewPanelItemBase.isPSSysMapViewNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysMapViewName() != null)) {
            iDataObject.set(FIELD_PSSYSMAPVIEWNAME, (Object)pSSysViewPanelItemBase.getPSSysMapViewName());
        }
        if (pSSysViewPanelItemBase.isPSSysPFPluginIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysViewPanelItemBase.getPSSysPFPluginId());
        }
        if (pSSysViewPanelItemBase.isPSSysPFPluginNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysViewPanelItemBase.getPSSysPFPluginName());
        }
        if (pSSysViewPanelItemBase.isPSSysResourceIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysViewPanelItemBase.getPSSysResourceId());
        }
        if (pSSysViewPanelItemBase.isPSSysResourceNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysViewPanelItemBase.getPSSysResourceName());
        }
        if (pSSysViewPanelItemBase.isPSSysSearchBarIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysSearchBarId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARID, (Object)pSSysViewPanelItemBase.getPSSysSearchBarId());
        }
        if (pSSysViewPanelItemBase.isPSSysSearchBarNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysSearchBarName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHBARNAME, (Object)pSSysViewPanelItemBase.getPSSysSearchBarName());
        }
        if (pSSysViewPanelItemBase.isPSSysViewPanelIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysViewPanelItemBase.getPSSysViewPanelId());
        }
        if (pSSysViewPanelItemBase.isPSSysViewPanelItemIdDirty() && (bl || pSSysViewPanelItemBase.getPSSysViewPanelItemId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMID, (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        }
        if (pSSysViewPanelItemBase.isPSSysViewPanelItemNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysViewPanelItemName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMNAME, (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemName());
        }
        if (pSSysViewPanelItemBase.isPSSysViewPanelNameDirty() && (bl || pSSysViewPanelItemBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysViewPanelItemBase.getPSSysViewPanelName());
        }
        if (pSSysViewPanelItemBase.isRawContentDirty() && (bl || pSSysViewPanelItemBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSSysViewPanelItemBase.getRawContent());
        }
        if (pSSysViewPanelItemBase.isRawCssStyleDirty() && (bl || pSSysViewPanelItemBase.getRawCssStyle() != null)) {
            iDataObject.set(FIELD_RAWCSSSTYLE, (Object)pSSysViewPanelItemBase.getRawCssStyle());
        }
        if (pSSysViewPanelItemBase.isRawServiceMethodDirty() && (bl || pSSysViewPanelItemBase.getRawServiceMethod() != null)) {
            iDataObject.set(FIELD_RAWSERVICEMETHOD, (Object)pSSysViewPanelItemBase.getRawServiceMethod());
        }
        if (pSSysViewPanelItemBase.isRawServiceUrlDirty() && (bl || pSSysViewPanelItemBase.getRawServiceUrl() != null)) {
            iDataObject.set(FIELD_RAWSERVICEURL, (Object)pSSysViewPanelItemBase.getRawServiceUrl());
        }
        if (pSSysViewPanelItemBase.isReadOnlyModeDirty() && (bl || pSSysViewPanelItemBase.getReadOnlyMode() != null)) {
            iDataObject.set(FIELD_READONLYMODE, (Object)pSSysViewPanelItemBase.getReadOnlyMode());
        }
        if (pSSysViewPanelItemBase.isRefCtrl2NameDirty() && (bl || pSSysViewPanelItemBase.getRefCtrl2Name() != null)) {
            iDataObject.set(FIELD_REFCTRL2NAME, (Object)pSSysViewPanelItemBase.getRefCtrl2Name());
        }
        if (pSSysViewPanelItemBase.isRefCtrl2UsageDirty() && (bl || pSSysViewPanelItemBase.getRefCtrl2Usage() != null)) {
            iDataObject.set(FIELD_REFCTRL2USAGE, (Object)pSSysViewPanelItemBase.getRefCtrl2Usage());
        }
        if (pSSysViewPanelItemBase.isRefCtrl2UsageTextDirty() && (bl || pSSysViewPanelItemBase.getRefCtrl2UsageText() != null)) {
            iDataObject.set(FIELD_REFCTRL2USAGETEXT, (Object)pSSysViewPanelItemBase.getRefCtrl2UsageText());
        }
        if (pSSysViewPanelItemBase.isRefCtrlNameDirty() && (bl || pSSysViewPanelItemBase.getRefCtrlName() != null)) {
            iDataObject.set(FIELD_REFCTRLNAME, (Object)pSSysViewPanelItemBase.getRefCtrlName());
        }
        if (pSSysViewPanelItemBase.isRefCtrlUsageDirty() && (bl || pSSysViewPanelItemBase.getRefCtrlUsage() != null)) {
            iDataObject.set(FIELD_REFCTRLUSAGE, (Object)pSSysViewPanelItemBase.getRefCtrlUsage());
        }
        if (pSSysViewPanelItemBase.isRefCtrlUsageTextDirty() && (bl || pSSysViewPanelItemBase.getRefCtrlUsageText() != null)) {
            iDataObject.set(FIELD_REFCTRLUSAGETEXT, (Object)pSSysViewPanelItemBase.getRefCtrlUsageText());
        }
        if (pSSysViewPanelItemBase.isRefLinkPSDEViewIdDirty() && (bl || pSSysViewPanelItemBase.getRefLinkPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFLINKPSDEVIEWID, (Object)pSSysViewPanelItemBase.getRefLinkPSDEViewId());
        }
        if (pSSysViewPanelItemBase.isRefLinkPSDEViewNameDirty() && (bl || pSSysViewPanelItemBase.getRefLinkPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFLINKPSDEVIEWNAME, (Object)pSSysViewPanelItemBase.getRefLinkPSDEViewName());
        }
        if (pSSysViewPanelItemBase.isRefPickupPSDEViewIdDirty() && (bl || pSSysViewPanelItemBase.getRefPickupPSDEViewId() != null)) {
            iDataObject.set(FIELD_REFPICKUPPSDEVIEWID, (Object)pSSysViewPanelItemBase.getRefPickupPSDEViewId());
        }
        if (pSSysViewPanelItemBase.isRefPickupPSDEViewNameDirty() && (bl || pSSysViewPanelItemBase.getRefPickupPSDEViewName() != null)) {
            iDataObject.set(FIELD_REFPICKUPPSDEVIEWNAME, (Object)pSSysViewPanelItemBase.getRefPickupPSDEViewName());
        }
        if (pSSysViewPanelItemBase.isRefPSDEACModeIdDirty() && (bl || pSSysViewPanelItemBase.getRefPSDEACModeId() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODEID, (Object)pSSysViewPanelItemBase.getRefPSDEACModeId());
        }
        if (pSSysViewPanelItemBase.isRefPSDEACModeNameDirty() && (bl || pSSysViewPanelItemBase.getRefPSDEACModeName() != null)) {
            iDataObject.set(FIELD_REFPSDEACMODENAME, (Object)pSSysViewPanelItemBase.getRefPSDEACModeName());
        }
        if (pSSysViewPanelItemBase.isRefPSDEDataSetIdDirty() && (bl || pSSysViewPanelItemBase.getRefPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETID, (Object)pSSysViewPanelItemBase.getRefPSDEDataSetId());
        }
        if (pSSysViewPanelItemBase.isRefPSDEDataSetNameDirty() && (bl || pSSysViewPanelItemBase.getRefPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETNAME, (Object)pSSysViewPanelItemBase.getRefPSDEDataSetName());
        }
        if (pSSysViewPanelItemBase.isRefPSDEIdDirty() && (bl || pSSysViewPanelItemBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSSysViewPanelItemBase.getRefPSDEId());
        }
        if (pSSysViewPanelItemBase.isRefPSDENameDirty() && (bl || pSSysViewPanelItemBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSSysViewPanelItemBase.getRefPSDEName());
        }
        if (pSSysViewPanelItemBase.isRenderModeDirty() && (bl || pSSysViewPanelItemBase.getRenderMode() != null)) {
            iDataObject.set(FIELD_RENDERMODE, (Object)pSSysViewPanelItemBase.getRenderMode());
        }
        if (pSSysViewPanelItemBase.isRenderModeTextDirty() && (bl || pSSysViewPanelItemBase.getRenderModeText() != null)) {
            iDataObject.set(FIELD_RENDERMODETEXT, (Object)pSSysViewPanelItemBase.getRenderModeText());
        }
        if (pSSysViewPanelItemBase.isResetItemNameDirty() && (bl || pSSysViewPanelItemBase.getResetItemName() != null)) {
            iDataObject.set(FIELD_RESETITEMNAME, (Object)pSSysViewPanelItemBase.getResetItemName());
        }
        if (pSSysViewPanelItemBase.isRightPosDirty() && (bl || pSSysViewPanelItemBase.getRightPos() != null)) {
            iDataObject.set(FIELD_RIGHTPOS, (Object)pSSysViewPanelItemBase.getRightPos());
        }
        if (pSSysViewPanelItemBase.isRowSpanDirty() && (bl || pSSysViewPanelItemBase.getRowSpan() != null)) {
            iDataObject.set(FIELD_ROWSPAN, (Object)pSSysViewPanelItemBase.getRowSpan());
        }
        if (pSSysViewPanelItemBase.isShowCaptionDirty() && (bl || pSSysViewPanelItemBase.getShowCaption() != null)) {
            iDataObject.set(FIELD_SHOWCAPTION, (Object)pSSysViewPanelItemBase.getShowCaption());
        }
        if (pSSysViewPanelItemBase.isSpacingBottomDirty() && (bl || pSSysViewPanelItemBase.getSpacingBottom() != null)) {
            iDataObject.set(FIELD_SPACINGBOTTOM, (Object)pSSysViewPanelItemBase.getSpacingBottom());
        }
        if (pSSysViewPanelItemBase.isSpacingLeftDirty() && (bl || pSSysViewPanelItemBase.getSpacingLeft() != null)) {
            iDataObject.set(FIELD_SPACINGLEFT, (Object)pSSysViewPanelItemBase.getSpacingLeft());
        }
        if (pSSysViewPanelItemBase.isSpacingRightDirty() && (bl || pSSysViewPanelItemBase.getSpacingRight() != null)) {
            iDataObject.set(FIELD_SPACINGRIGHT, (Object)pSSysViewPanelItemBase.getSpacingRight());
        }
        if (pSSysViewPanelItemBase.isSpacingTopDirty() && (bl || pSSysViewPanelItemBase.getSpacingTop() != null)) {
            iDataObject.set(FIELD_SPACINGTOP, (Object)pSSysViewPanelItemBase.getSpacingTop());
        }
        if (pSSysViewPanelItemBase.isSwapModeDirty() && (bl || pSSysViewPanelItemBase.getSwapMode() != null)) {
            iDataObject.set(FIELD_SWAPMODE, (Object)pSSysViewPanelItemBase.getSwapMode());
        }
        if (pSSysViewPanelItemBase.isTabIndexDirty() && (bl || pSSysViewPanelItemBase.getTabIndex() != null)) {
            iDataObject.set(FIELD_TABINDEX, (Object)pSSysViewPanelItemBase.getTabIndex());
        }
        if (pSSysViewPanelItemBase.isTargetIdDirty() && (bl || pSSysViewPanelItemBase.getTargetId() != null)) {
            iDataObject.set(FIELD_TARGETID, (Object)pSSysViewPanelItemBase.getTargetId());
        }
        if (pSSysViewPanelItemBase.isTargetNameDirty() && (bl || pSSysViewPanelItemBase.getTargetName() != null)) {
            iDataObject.set(FIELD_TARGETNAME, (Object)pSSysViewPanelItemBase.getTargetName());
        }
        if (pSSysViewPanelItemBase.isTargetTypeDirty() && (bl || pSSysViewPanelItemBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSSysViewPanelItemBase.getTargetType());
        }
        if (pSSysViewPanelItemBase.isTemplateModeDirty() && (bl || pSSysViewPanelItemBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSSysViewPanelItemBase.getTemplateMode());
        }
        if (pSSysViewPanelItemBase.isTipPSLanResIdDirty() && (bl || pSSysViewPanelItemBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSSysViewPanelItemBase.getTipPSLanResId());
        }
        if (pSSysViewPanelItemBase.isTipPSLanResNameDirty() && (bl || pSSysViewPanelItemBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSSysViewPanelItemBase.getTipPSLanResName());
        }
        if (pSSysViewPanelItemBase.isTitleBarCloseModeDirty() && (bl || pSSysViewPanelItemBase.getTitleBarCloseMode() != null)) {
            iDataObject.set(FIELD_TITLEBARCLOSEMODE, (Object)pSSysViewPanelItemBase.getTitleBarCloseMode());
        }
        if (pSSysViewPanelItemBase.isToggleModeDirty() && (bl || pSSysViewPanelItemBase.getToggleMode() != null)) {
            iDataObject.set(FIELD_TOGGLEMODE, (Object)pSSysViewPanelItemBase.getToggleMode());
        }
        if (pSSysViewPanelItemBase.isTooltipInfoDirty() && (bl || pSSysViewPanelItemBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSSysViewPanelItemBase.getTooltipInfo());
        }
        if (pSSysViewPanelItemBase.isTopPosDirty() && (bl || pSSysViewPanelItemBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSSysViewPanelItemBase.getTopPos());
        }
        if (pSSysViewPanelItemBase.isUpdateDateDirty() && (bl || pSSysViewPanelItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysViewPanelItemBase.getUpdateDate());
        }
        if (pSSysViewPanelItemBase.isUpdateManDirty() && (bl || pSSysViewPanelItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysViewPanelItemBase.getUpdateMan());
        }
        if (pSSysViewPanelItemBase.isUserTagDirty() && (bl || pSSysViewPanelItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysViewPanelItemBase.getUserTag());
        }
        if (pSSysViewPanelItemBase.isUserTag2Dirty() && (bl || pSSysViewPanelItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysViewPanelItemBase.getUserTag2());
        }
        if (pSSysViewPanelItemBase.isVAlignDirty() && (bl || pSSysViewPanelItemBase.getVAlign() != null)) {
            iDataObject.set(FIELD_VALIGN, (Object)pSSysViewPanelItemBase.getVAlign());
        }
        if (pSSysViewPanelItemBase.isVAlignSelfDirty() && (bl || pSSysViewPanelItemBase.getVAlignSelf() != null)) {
            iDataObject.set(FIELD_VALIGNSELF, (Object)pSSysViewPanelItemBase.getVAlignSelf());
        }
        if (pSSysViewPanelItemBase.isValueFormatDirty() && (bl || pSSysViewPanelItemBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSSysViewPanelItemBase.getValueFormat());
        }
        if (pSSysViewPanelItemBase.isValueItemNameDirty() && (bl || pSSysViewPanelItemBase.getValueItemName() != null)) {
            iDataObject.set(FIELD_VALUEITEMNAME, (Object)pSSysViewPanelItemBase.getValueItemName());
        }
        if (pSSysViewPanelItemBase.isVisibleLogicDirty() && (bl || pSSysViewPanelItemBase.getVisibleLogic() != null)) {
            iDataObject.set(FIELD_VISIBLELOGIC, (Object)pSSysViewPanelItemBase.getVisibleLogic());
        }
        if (pSSysViewPanelItemBase.isWidthDirty() && (bl || pSSysViewPanelItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSSysViewPanelItemBase.getWidth());
        }
        if (pSSysViewPanelItemBase.isWidthModeDirty() && (bl || pSSysViewPanelItemBase.getWidthMode() != null)) {
            iDataObject.set(FIELD_WIDTHMODE, (Object)pSSysViewPanelItemBase.getWidthMode());
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
        return PSSysViewPanelItemBase.remove(this, n);
    }

    private static boolean remove(PSSysViewPanelItemBase pSSysViewPanelItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelItemBase.resetActiveDataMode();
                return true;
            }
            case 1: {
                pSSysViewPanelItemBase.resetADPSDELogicId();
                return true;
            }
            case 2: {
                pSSysViewPanelItemBase.resetADPSDELogicName();
                return true;
            }
            case 3: {
                pSSysViewPanelItemBase.resetAL_Pos();
                return true;
            }
            case 4: {
                pSSysViewPanelItemBase.resetBlankLogic();
                return true;
            }
            case 5: {
                pSSysViewPanelItemBase.resetBL_Pos();
                return true;
            }
            case 6: {
                pSSysViewPanelItemBase.resetBorderStyle();
                return true;
            }
            case 7: {
                pSSysViewPanelItemBase.resetBottomPos();
                return true;
            }
            case 8: {
                pSSysViewPanelItemBase.resetBtnActionType();
                return true;
            }
            case 9: {
                pSSysViewPanelItemBase.resetBusyIndicator();
                return true;
            }
            case 10: {
                pSSysViewPanelItemBase.resetCapPSLanResId();
                return true;
            }
            case 11: {
                pSSysViewPanelItemBase.resetCapPSLanResName();
                return true;
            }
            case 12: {
                pSSysViewPanelItemBase.resetCaption();
                return true;
            }
            case 13: {
                pSSysViewPanelItemBase.resetCaptionPos();
                return true;
            }
            case 14: {
                pSSysViewPanelItemBase.resetChild_Col_LG();
                return true;
            }
            case 15: {
                pSSysViewPanelItemBase.resetChild_Col_MD();
                return true;
            }
            case 16: {
                pSSysViewPanelItemBase.resetChild_Col_SM();
                return true;
            }
            case 17: {
                pSSysViewPanelItemBase.resetChild_Col_XS();
                return true;
            }
            case 18: {
                pSSysViewPanelItemBase.resetColId();
                return true;
            }
            case 19: {
                pSSysViewPanelItemBase.resetCollapsibleFlag();
                return true;
            }
            case 20: {
                pSSysViewPanelItemBase.resetColModel();
                return true;
            }
            case 21: {
                pSSysViewPanelItemBase.resetColSpan();
                return true;
            }
            case 22: {
                pSSysViewPanelItemBase.resetCol_LG();
                return true;
            }
            case 23: {
                pSSysViewPanelItemBase.resetCol_LG_OS();
                return true;
            }
            case 24: {
                pSSysViewPanelItemBase.resetCol_MD();
                return true;
            }
            case 25: {
                pSSysViewPanelItemBase.resetCol_MD_OS();
                return true;
            }
            case 26: {
                pSSysViewPanelItemBase.resetCol_SM();
                return true;
            }
            case 27: {
                pSSysViewPanelItemBase.resetCol_SM_OS();
                return true;
            }
            case 28: {
                pSSysViewPanelItemBase.resetCol_Width();
                return true;
            }
            case 29: {
                pSSysViewPanelItemBase.resetCol_XS();
                return true;
            }
            case 30: {
                pSSysViewPanelItemBase.resetCol_XS_OS();
                return true;
            }
            case 31: {
                pSSysViewPanelItemBase.resetContentType();
                return true;
            }
            case 32: {
                pSSysViewPanelItemBase.resetCounterId();
                return true;
            }
            case 33: {
                pSSysViewPanelItemBase.resetCounterMode();
                return true;
            }
            case 34: {
                pSSysViewPanelItemBase.resetCreateDate();
                return true;
            }
            case 35: {
                pSSysViewPanelItemBase.resetCreateMan();
                return true;
            }
            case 36: {
                pSSysViewPanelItemBase.resetCssId();
                return true;
            }
            case 37: {
                pSSysViewPanelItemBase.resetCtrlDynaClass();
                return true;
            }
            case 38: {
                pSSysViewPanelItemBase.resetCtrlHeight();
                return true;
            }
            case 39: {
                pSSysViewPanelItemBase.resetCtrlPSSysCssId();
                return true;
            }
            case 40: {
                pSSysViewPanelItemBase.resetCtrlPSSysCssName();
                return true;
            }
            case 41: {
                pSSysViewPanelItemBase.resetCtrlRawCssStyle();
                return true;
            }
            case 42: {
                pSSysViewPanelItemBase.resetCtrlType();
                return true;
            }
            case 43: {
                pSSysViewPanelItemBase.resetCtrlWidth();
                return true;
            }
            case 44: {
                pSSysViewPanelItemBase.resetCustomCode();
                return true;
            }
            case 45: {
                pSSysViewPanelItemBase.resetCustomMode();
                return true;
            }
            case 46: {
                pSSysViewPanelItemBase.resetDataPanelMode();
                return true;
            }
            case 47: {
                pSSysViewPanelItemBase.resetDataSource();
                return true;
            }
            case 48: {
                pSSysViewPanelItemBase.resetDataSourceText();
                return true;
            }
            case 49: {
                pSSysViewPanelItemBase.resetDetailStyle();
                return true;
            }
            case 50: {
                pSSysViewPanelItemBase.resetDetailStyleText();
                return true;
            }
            case 51: {
                pSSysViewPanelItemBase.resetDynaClass();
                return true;
            }
            case 52: {
                pSSysViewPanelItemBase.resetEditorType();
                return true;
            }
            case 53: {
                pSSysViewPanelItemBase.resetEditorTypeName();
                return true;
            }
            case 54: {
                pSSysViewPanelItemBase.resetEmptyCaption();
                return true;
            }
            case 55: {
                pSSysViewPanelItemBase.resetEnableAnchor();
                return true;
            }
            case 56: {
                pSSysViewPanelItemBase.resetEnableLogic();
                return true;
            }
            case 57: {
                pSSysViewPanelItemBase.resetFieldName();
                return true;
            }
            case 58: {
                pSSysViewPanelItemBase.resetFieldStates();
                return true;
            }
            case 59: {
                pSSysViewPanelItemBase.resetFlexAlign();
                return true;
            }
            case 60: {
                pSSysViewPanelItemBase.resetFlexBasis();
                return true;
            }
            case 61: {
                pSSysViewPanelItemBase.resetFlexDir();
                return true;
            }
            case 62: {
                pSSysViewPanelItemBase.resetFlexGrow();
                return true;
            }
            case 63: {
                pSSysViewPanelItemBase.resetFlexShrink();
                return true;
            }
            case 64: {
                pSSysViewPanelItemBase.resetFlexVAlign();
                return true;
            }
            case 65: {
                pSSysViewPanelItemBase.resetGetDataTimer();
                return true;
            }
            case 66: {
                pSSysViewPanelItemBase.resetGridRowId();
                return true;
            }
            case 67: {
                pSSysViewPanelItemBase.resetHAlign();
                return true;
            }
            case 68: {
                pSSysViewPanelItemBase.resetHAlignSelf();
                return true;
            }
            case 69: {
                pSSysViewPanelItemBase.resetHeight();
                return true;
            }
            case 70: {
                pSSysViewPanelItemBase.resetHeightMode();
                return true;
            }
            case 71: {
                pSSysViewPanelItemBase.resetHtmlContent();
                return true;
            }
            case 72: {
                pSSysViewPanelItemBase.resetHtmlPageUrl();
                return true;
            }
            case 73: {
                pSSysViewPanelItemBase.resetIconAlign();
                return true;
            }
            case 74: {
                pSSysViewPanelItemBase.resetIgnoreInput();
                return true;
            }
            case 75: {
                pSSysViewPanelItemBase.resetItemParam();
                return true;
            }
            case 76: {
                pSSysViewPanelItemBase.resetItemParam10();
                return true;
            }
            case 77: {
                pSSysViewPanelItemBase.resetItemParam11();
                return true;
            }
            case 78: {
                pSSysViewPanelItemBase.resetItemParam12();
                return true;
            }
            case 79: {
                pSSysViewPanelItemBase.resetItemParam2();
                return true;
            }
            case 80: {
                pSSysViewPanelItemBase.resetItemParam3();
                return true;
            }
            case 81: {
                pSSysViewPanelItemBase.resetItemParam4();
                return true;
            }
            case 82: {
                pSSysViewPanelItemBase.resetItemParam5();
                return true;
            }
            case 83: {
                pSSysViewPanelItemBase.resetItemParam6();
                return true;
            }
            case 84: {
                pSSysViewPanelItemBase.resetItemParam7();
                return true;
            }
            case 85: {
                pSSysViewPanelItemBase.resetItemParam8();
                return true;
            }
            case 86: {
                pSSysViewPanelItemBase.resetItemParam9();
                return true;
            }
            case 87: {
                pSSysViewPanelItemBase.resetItemParams();
                return true;
            }
            case 88: {
                pSSysViewPanelItemBase.resetItemType();
                return true;
            }
            case 89: {
                pSSysViewPanelItemBase.resetLabelDynaClass();
                return true;
            }
            case 90: {
                pSSysViewPanelItemBase.resetLabelPSSysCssId();
                return true;
            }
            case 91: {
                pSSysViewPanelItemBase.resetLabelPSSysCssName();
                return true;
            }
            case 92: {
                pSSysViewPanelItemBase.resetLabelRawCssStyle();
                return true;
            }
            case 93: {
                pSSysViewPanelItemBase.resetLableCssId();
                return true;
            }
            case 94: {
                pSSysViewPanelItemBase.resetLayoutMode();
                return true;
            }
            case 95: {
                pSSysViewPanelItemBase.resetLeftPos();
                return true;
            }
            case 96: {
                pSSysViewPanelItemBase.resetLogicName();
                return true;
            }
            case 97: {
                pSSysViewPanelItemBase.resetMemo();
                return true;
            }
            case 98: {
                pSSysViewPanelItemBase.resetMobFlag();
                return true;
            }
            case 99: {
                pSSysViewPanelItemBase.resetOpenPSAppViewId();
                return true;
            }
            case 100: {
                pSSysViewPanelItemBase.resetOpenPSAppViewName();
                return true;
            }
            case 101: {
                pSSysViewPanelItemBase.resetOpenPSDEViewId();
                return true;
            }
            case 102: {
                pSSysViewPanelItemBase.resetOpenPSDEViewName();
                return true;
            }
            case 103: {
                pSSysViewPanelItemBase.resetOpenPSSysPDTViewId();
                return true;
            }
            case 104: {
                pSSysViewPanelItemBase.resetOpenPSSysPDTViewName();
                return true;
            }
            case 105: {
                pSSysViewPanelItemBase.resetOrderValue();
                return true;
            }
            case 106: {
                pSSysViewPanelItemBase.resetOrientationMode();
                return true;
            }
            case 107: {
                pSSysViewPanelItemBase.resetPHPSLanResId();
                return true;
            }
            case 108: {
                pSSysViewPanelItemBase.resetPHPSLanResName();
                return true;
            }
            case 109: {
                pSSysViewPanelItemBase.resetPlaceHolder();
                return true;
            }
            case 110: {
                pSSysViewPanelItemBase.resetPLayoutMode();
                return true;
            }
            case 111: {
                pSSysViewPanelItemBase.resetPPSSysViewPanelItemId();
                return true;
            }
            case 112: {
                pSSysViewPanelItemBase.resetPPSSysViewPanelItemName();
                return true;
            }
            case 113: {
                pSSysViewPanelItemBase.resetPredefinedType();
                return true;
            }
            case 114: {
                pSSysViewPanelItemBase.resetPredefinedTypeText();
                return true;
            }
            case 115: {
                pSSysViewPanelItemBase.resetPreviewHtml();
                return true;
            }
            case 116: {
                pSSysViewPanelItemBase.resetPSACHandlerId();
                return true;
            }
            case 117: {
                pSSysViewPanelItemBase.resetPSACHandlerName();
                return true;
            }
            case 118: {
                pSSysViewPanelItemBase.resetPSAppMenuId();
                return true;
            }
            case 119: {
                pSSysViewPanelItemBase.resetPSAppMenuName();
                return true;
            }
            case 120: {
                pSSysViewPanelItemBase.resetPSCodeListId();
                return true;
            }
            case 121: {
                pSSysViewPanelItemBase.resetPSCodeListName();
                return true;
            }
            case 122: {
                pSSysViewPanelItemBase.resetPSCtrlId();
                return true;
            }
            case 123: {
                pSSysViewPanelItemBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 124: {
                pSSysViewPanelItemBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 125: {
                pSSysViewPanelItemBase.resetPSCtrlName();
                return true;
            }
            case 126: {
                pSSysViewPanelItemBase.resetPSDEActionId();
                return true;
            }
            case 127: {
                pSSysViewPanelItemBase.resetPSDEActionName();
                return true;
            }
            case 128: {
                pSSysViewPanelItemBase.resetPSDEChartId();
                return true;
            }
            case 129: {
                pSSysViewPanelItemBase.resetPSDEChartName();
                return true;
            }
            case 130: {
                pSSysViewPanelItemBase.resetPSDEDataSetId();
                return true;
            }
            case 131: {
                pSSysViewPanelItemBase.resetPSDEDataSetName();
                return true;
            }
            case 132: {
                pSSysViewPanelItemBase.resetPSDEDataViewId();
                return true;
            }
            case 133: {
                pSSysViewPanelItemBase.resetPSDEDataViewName();
                return true;
            }
            case 134: {
                pSSysViewPanelItemBase.resetPSDEDRId();
                return true;
            }
            case 135: {
                pSSysViewPanelItemBase.resetPSDEDRItemId();
                return true;
            }
            case 136: {
                pSSysViewPanelItemBase.resetPSDEDRItemName();
                return true;
            }
            case 137: {
                pSSysViewPanelItemBase.resetPSDEDRName();
                return true;
            }
            case 138: {
                pSSysViewPanelItemBase.resetPSDEFormId();
                return true;
            }
            case 139: {
                pSSysViewPanelItemBase.resetPSDEFormName();
                return true;
            }
            case 140: {
                pSSysViewPanelItemBase.resetPSDEGridId();
                return true;
            }
            case 141: {
                pSSysViewPanelItemBase.resetPSDEGridName();
                return true;
            }
            case 142: {
                pSSysViewPanelItemBase.resetPSDEId();
                return true;
            }
            case 143: {
                pSSysViewPanelItemBase.resetPSDEListId();
                return true;
            }
            case 144: {
                pSSysViewPanelItemBase.resetPSDEListName();
                return true;
            }
            case 145: {
                pSSysViewPanelItemBase.resetPSDELogicId();
                return true;
            }
            case 146: {
                pSSysViewPanelItemBase.resetPSDELogicName();
                return true;
            }
            case 147: {
                pSSysViewPanelItemBase.resetPSDEName();
                return true;
            }
            case 148: {
                pSSysViewPanelItemBase.resetPSDEPanelId();
                return true;
            }
            case 149: {
                pSSysViewPanelItemBase.resetPSDEPanelName();
                return true;
            }
            case 150: {
                pSSysViewPanelItemBase.resetPSDEReportId();
                return true;
            }
            case 151: {
                pSSysViewPanelItemBase.resetPSDEReportName();
                return true;
            }
            case 152: {
                pSSysViewPanelItemBase.resetPSDESearchFormId();
                return true;
            }
            case 153: {
                pSSysViewPanelItemBase.resetPSDESearchFormName();
                return true;
            }
            case 154: {
                pSSysViewPanelItemBase.resetPSDEToolbarId();
                return true;
            }
            case 155: {
                pSSysViewPanelItemBase.resetPSDEToolbarName();
                return true;
            }
            case 156: {
                pSSysViewPanelItemBase.resetPSDETreeViewId();
                return true;
            }
            case 157: {
                pSSysViewPanelItemBase.resetPSDETreeViewName();
                return true;
            }
            case 158: {
                pSSysViewPanelItemBase.resetPSDEUAGroupId();
                return true;
            }
            case 159: {
                pSSysViewPanelItemBase.resetPSDEUAGroupName();
                return true;
            }
            case 160: {
                pSSysViewPanelItemBase.resetPSDEUIActionId();
                return true;
            }
            case 161: {
                pSSysViewPanelItemBase.resetPSDEUIActionName();
                return true;
            }
            case 162: {
                pSSysViewPanelItemBase.resetPSDEViewBaseId();
                return true;
            }
            case 163: {
                pSSysViewPanelItemBase.resetPSDEViewBaseName();
                return true;
            }
            case 164: {
                pSSysViewPanelItemBase.resetPSDEWizardId();
                return true;
            }
            case 165: {
                pSSysViewPanelItemBase.resetPSDEWizardName();
                return true;
            }
            case 166: {
                pSSysViewPanelItemBase.resetPSSysCalendarId();
                return true;
            }
            case 167: {
                pSSysViewPanelItemBase.resetPSSysCalendarName();
                return true;
            }
            case 168: {
                pSSysViewPanelItemBase.resetPSSysCounterId();
                return true;
            }
            case 169: {
                pSSysViewPanelItemBase.resetPSSysCounterName();
                return true;
            }
            case 170: {
                pSSysViewPanelItemBase.resetPSSysCssId();
                return true;
            }
            case 171: {
                pSSysViewPanelItemBase.resetPSSysCssName();
                return true;
            }
            case 172: {
                pSSysViewPanelItemBase.resetPSSysDashboardId();
                return true;
            }
            case 173: {
                pSSysViewPanelItemBase.resetPSSysDashboardName();
                return true;
            }
            case 174: {
                pSSysViewPanelItemBase.resetPSSysDynaModelId();
                return true;
            }
            case 175: {
                pSSysViewPanelItemBase.resetPSSysDynaModelName();
                return true;
            }
            case 176: {
                pSSysViewPanelItemBase.resetPSSysEditorStyleId();
                return true;
            }
            case 177: {
                pSSysViewPanelItemBase.resetPSSysEditorStyleName();
                return true;
            }
            case 178: {
                pSSysViewPanelItemBase.resetPSSysImageId();
                return true;
            }
            case 179: {
                pSSysViewPanelItemBase.resetPSSysImageName();
                return true;
            }
            case 180: {
                pSSysViewPanelItemBase.resetPSSysMapViewId();
                return true;
            }
            case 181: {
                pSSysViewPanelItemBase.resetPSSysMapViewName();
                return true;
            }
            case 182: {
                pSSysViewPanelItemBase.resetPSSysPFPluginId();
                return true;
            }
            case 183: {
                pSSysViewPanelItemBase.resetPSSysPFPluginName();
                return true;
            }
            case 184: {
                pSSysViewPanelItemBase.resetPSSysResourceId();
                return true;
            }
            case 185: {
                pSSysViewPanelItemBase.resetPSSysResourceName();
                return true;
            }
            case 186: {
                pSSysViewPanelItemBase.resetPSSysSearchBarId();
                return true;
            }
            case 187: {
                pSSysViewPanelItemBase.resetPSSysSearchBarName();
                return true;
            }
            case 188: {
                pSSysViewPanelItemBase.resetPSSysViewPanelId();
                return true;
            }
            case 189: {
                pSSysViewPanelItemBase.resetPSSysViewPanelItemId();
                return true;
            }
            case 190: {
                pSSysViewPanelItemBase.resetPSSysViewPanelItemName();
                return true;
            }
            case 191: {
                pSSysViewPanelItemBase.resetPSSysViewPanelName();
                return true;
            }
            case 192: {
                pSSysViewPanelItemBase.resetRawContent();
                return true;
            }
            case 193: {
                pSSysViewPanelItemBase.resetRawCssStyle();
                return true;
            }
            case 194: {
                pSSysViewPanelItemBase.resetRawServiceMethod();
                return true;
            }
            case 195: {
                pSSysViewPanelItemBase.resetRawServiceUrl();
                return true;
            }
            case 196: {
                pSSysViewPanelItemBase.resetReadOnlyMode();
                return true;
            }
            case 197: {
                pSSysViewPanelItemBase.resetRefCtrl2Name();
                return true;
            }
            case 198: {
                pSSysViewPanelItemBase.resetRefCtrl2Usage();
                return true;
            }
            case 199: {
                pSSysViewPanelItemBase.resetRefCtrl2UsageText();
                return true;
            }
            case 200: {
                pSSysViewPanelItemBase.resetRefCtrlName();
                return true;
            }
            case 201: {
                pSSysViewPanelItemBase.resetRefCtrlUsage();
                return true;
            }
            case 202: {
                pSSysViewPanelItemBase.resetRefCtrlUsageText();
                return true;
            }
            case 203: {
                pSSysViewPanelItemBase.resetRefLinkPSDEViewId();
                return true;
            }
            case 204: {
                pSSysViewPanelItemBase.resetRefLinkPSDEViewName();
                return true;
            }
            case 205: {
                pSSysViewPanelItemBase.resetRefPickupPSDEViewId();
                return true;
            }
            case 206: {
                pSSysViewPanelItemBase.resetRefPickupPSDEViewName();
                return true;
            }
            case 207: {
                pSSysViewPanelItemBase.resetRefPSDEACModeId();
                return true;
            }
            case 208: {
                pSSysViewPanelItemBase.resetRefPSDEACModeName();
                return true;
            }
            case 209: {
                pSSysViewPanelItemBase.resetRefPSDEDataSetId();
                return true;
            }
            case 210: {
                pSSysViewPanelItemBase.resetRefPSDEDataSetName();
                return true;
            }
            case 211: {
                pSSysViewPanelItemBase.resetRefPSDEId();
                return true;
            }
            case 212: {
                pSSysViewPanelItemBase.resetRefPSDEName();
                return true;
            }
            case 213: {
                pSSysViewPanelItemBase.resetRenderMode();
                return true;
            }
            case 214: {
                pSSysViewPanelItemBase.resetRenderModeText();
                return true;
            }
            case 215: {
                pSSysViewPanelItemBase.resetResetItemName();
                return true;
            }
            case 216: {
                pSSysViewPanelItemBase.resetRightPos();
                return true;
            }
            case 217: {
                pSSysViewPanelItemBase.resetRowSpan();
                return true;
            }
            case 218: {
                pSSysViewPanelItemBase.resetShowCaption();
                return true;
            }
            case 219: {
                pSSysViewPanelItemBase.resetSpacingBottom();
                return true;
            }
            case 220: {
                pSSysViewPanelItemBase.resetSpacingLeft();
                return true;
            }
            case 221: {
                pSSysViewPanelItemBase.resetSpacingRight();
                return true;
            }
            case 222: {
                pSSysViewPanelItemBase.resetSpacingTop();
                return true;
            }
            case 223: {
                pSSysViewPanelItemBase.resetSwapMode();
                return true;
            }
            case 224: {
                pSSysViewPanelItemBase.resetTabIndex();
                return true;
            }
            case 225: {
                pSSysViewPanelItemBase.resetTargetId();
                return true;
            }
            case 226: {
                pSSysViewPanelItemBase.resetTargetName();
                return true;
            }
            case 227: {
                pSSysViewPanelItemBase.resetTargetType();
                return true;
            }
            case 228: {
                pSSysViewPanelItemBase.resetTemplateMode();
                return true;
            }
            case 229: {
                pSSysViewPanelItemBase.resetTipPSLanResId();
                return true;
            }
            case 230: {
                pSSysViewPanelItemBase.resetTipPSLanResName();
                return true;
            }
            case 231: {
                pSSysViewPanelItemBase.resetTitleBarCloseMode();
                return true;
            }
            case 232: {
                pSSysViewPanelItemBase.resetToggleMode();
                return true;
            }
            case 233: {
                pSSysViewPanelItemBase.resetTooltipInfo();
                return true;
            }
            case 234: {
                pSSysViewPanelItemBase.resetTopPos();
                return true;
            }
            case 235: {
                pSSysViewPanelItemBase.resetUpdateDate();
                return true;
            }
            case 236: {
                pSSysViewPanelItemBase.resetUpdateMan();
                return true;
            }
            case 237: {
                pSSysViewPanelItemBase.resetUserTag();
                return true;
            }
            case 238: {
                pSSysViewPanelItemBase.resetUserTag2();
                return true;
            }
            case 239: {
                pSSysViewPanelItemBase.resetVAlign();
                return true;
            }
            case 240: {
                pSSysViewPanelItemBase.resetVAlignSelf();
                return true;
            }
            case 241: {
                pSSysViewPanelItemBase.resetValueFormat();
                return true;
            }
            case 242: {
                pSSysViewPanelItemBase.resetValueItemName();
                return true;
            }
            case 243: {
                pSSysViewPanelItemBase.resetVisibleLogic();
                return true;
            }
            case 244: {
                pSSysViewPanelItemBase.resetWidth();
                return true;
            }
            case 245: {
                pSSysViewPanelItemBase.resetWidthMode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSACHandler getPSACHandler() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSACHandler();
        }
        if (this.getPSACHandlerId() == null) {
            return null;
        }
        Integer n = this.objPSACHandlerLock;
        synchronized (n) {
            if (this.psachandler != null && DataTypeHelper.compare((int)25, (Object)this.getPSACHandlerId(), (Object)this.psachandler.getPSACHandlerId()) != 0L) {
                this.psachandler = null;
            }
            if (this.psachandler == null) {
                PSACHandler pSACHandler = new PSACHandler();
                pSACHandler.setPSACHandlerId(this.getPSACHandlerId());
                PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
                pSACHandlerService.autoGet(pSACHandler);
                this.psachandler = pSACHandler;
            }
            return this.psachandler;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet(pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppView getOpenPSAppView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpenPSAppView();
        }
        if (this.getOpenPSAppViewId() == null) {
            return null;
        }
        Integer n = this.objOpenPSAppViewLock;
        synchronized (n) {
            if (this.openpsappview != null && DataTypeHelper.compare((int)25, (Object)this.getOpenPSAppViewId(), (Object)this.openpsappview.getPSAppViewId()) != 0L) {
                this.openpsappview = null;
            }
            if (this.openpsappview == null) {
                PSAppView pSAppView = new PSAppView();
                pSAppView.setPSAppViewId(this.getOpenPSAppViewId());
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppViewService.autoGet(pSAppView);
                this.openpsappview = pSAppView;
            }
            return this.openpsappview;
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
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroup();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.psctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlLogicGroupId(), (Object)this.psctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.psctrllogicgroup = null;
            }
            if (this.psctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet(pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
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
                pSDEACModeService.autoGet(pSDEACMode);
                this.refpsdeacmode = pSDEACMode;
            }
            return this.refpsdeacmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChart getPSDEChart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChart();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        Integer n = this.objPSDEChartLock;
        synchronized (n) {
            if (this.psdechart != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEChartId(), (Object)this.psdechart.getPSDEChartId()) != 0L) {
                this.psdechart = null;
            }
            if (this.psdechart == null) {
                PSDEChart pSDEChart = new PSDEChart();
                pSDEChart.setPSDEChartId(this.getPSDEChartId());
                PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartService.autoGet(pSDEChart);
                this.psdechart = pSDEChart;
            }
            return this.psdechart;
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
                pSDEDataRelationService.autoGet(pSDEDataRelation);
                this.psdedr = pSDEDataRelation;
            }
            return this.psdedr;
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
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.refpsdedataset = pSDEDataSet;
            }
            return this.refpsdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataView getPSDEDataView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataView();
        }
        if (this.getPSDEDataViewId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataViewLock;
        synchronized (n) {
            if (this.psdedataview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataViewId(), (Object)this.psdedataview.getPSDEDataViewId()) != 0L) {
                this.psdedataview = null;
            }
            if (this.psdedataview == null) {
                PSDEDataView pSDEDataView = new PSDEDataView();
                pSDEDataView.setPSDEDataViewId(this.getPSDEDataViewId());
                PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataViewService.autoGet(pSDEDataView);
                this.psdedataview = pSDEDataView;
            }
            return this.psdedataview;
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
                pSDEDRItemService.autoGet(pSDEDRItem);
                this.psdedritem = pSDEDRItem;
            }
            return this.psdedritem;
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
    public PSDEForm getPSDESearchForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESearchForm();
        }
        if (this.getPSDESearchFormId() == null) {
            return null;
        }
        Integer n = this.objPSDESearchFormLock;
        synchronized (n) {
            if (this.psdesearchform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESearchFormId(), (Object)this.psdesearchform.getPSDEFormId()) != 0L) {
                this.psdesearchform = null;
            }
            if (this.psdesearchform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDESearchFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.psdesearchform = pSDEForm;
            }
            return this.psdesearchform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet(pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEList getPSDEList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEList();
        }
        if (this.getPSDEListId() == null) {
            return null;
        }
        Integer n = this.objPSDEListLock;
        synchronized (n) {
            if (this.psdelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEListId(), (Object)this.psdelist.getPSDEListId()) != 0L) {
                this.psdelist = null;
            }
            if (this.psdelist == null) {
                PSDEList pSDEList = new PSDEList();
                pSDEList.setPSDEListId(this.getPSDEListId());
                PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
                pSDEListService.autoGet(pSDEList);
                this.psdelist = pSDEList;
            }
            return this.psdelist;
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
                pSDELogicService.autoGet(pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEReport getPSDEReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReport();
        }
        if (this.getPSDEReportId() == null) {
            return null;
        }
        Integer n = this.objPSDEReportLock;
        synchronized (n) {
            if (this.psdereport != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEReportId(), (Object)this.psdereport.getPSDEReportId()) != 0L) {
                this.psdereport = null;
            }
            if (this.psdereport == null) {
                PSDEReport pSDEReport = new PSDEReport();
                pSDEReport.setPSDEReportId(this.getPSDEReportId());
                PSDEReportService pSDEReportService = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
                pSDEReportService.autoGet(pSDEReport);
                this.psdereport = pSDEReport;
            }
            return this.psdereport;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEToolbar getPSDEToolbar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEToolbar();
        }
        if (this.getPSDEToolbarId() == null) {
            return null;
        }
        Integer n = this.objPSDEToolbarLock;
        synchronized (n) {
            if (this.psdetoolbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEToolbarId(), (Object)this.psdetoolbar.getPSDEToolbarId()) != 0L) {
                this.psdetoolbar = null;
            }
            if (this.psdetoolbar == null) {
                PSDEToolbar pSDEToolbar = new PSDEToolbar();
                pSDEToolbar.setPSDEToolbarId(this.getPSDEToolbarId());
                PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
                pSDEToolbarService.autoGet(pSDEToolbar);
                this.psdetoolbar = pSDEToolbar;
            }
            return this.psdetoolbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeView getPSDETreeView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeView();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeViewLock;
        synchronized (n) {
            if (this.psdetreeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeViewId(), (Object)this.psdetreeview.getPSDETreeViewId()) != 0L) {
                this.psdetreeview = null;
            }
            if (this.psdetreeview == null) {
                PSDETreeView pSDETreeView = new PSDETreeView();
                pSDETreeView.setPSDETreeViewId(this.getPSDETreeViewId());
                PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeViewService.autoGet(pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
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
                pSDEUIActionService.autoGet(pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.openpsdeview = pSDEViewBase;
            }
            return this.openpsdeview;
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getRefLinkPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefLinkPSDEView();
        }
        if (this.getRefLinkPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objRefLinkPSDEViewLock;
        synchronized (n) {
            if (this.reflinkpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getRefLinkPSDEViewId(), (Object)this.reflinkpsdeview.getPSDEViewBaseId()) != 0L) {
                this.reflinkpsdeview = null;
            }
            if (this.reflinkpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getRefLinkPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.reflinkpsdeview = pSDEViewBase;
            }
            return this.reflinkpsdeview;
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
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.refpickuppsdeview = pSDEViewBase;
            }
            return this.refpickuppsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEWizard getPSDEWizard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizard();
        }
        if (this.getPSDEWizardId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardLock;
        synchronized (n) {
            if (this.psdewizard != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardId(), (Object)this.psdewizard.getPSDEWizardId()) != 0L) {
                this.psdewizard = null;
            }
            if (this.psdewizard == null) {
                PSDEWizard pSDEWizard = new PSDEWizard();
                pSDEWizard.setPSDEWizardId(this.getPSDEWizardId());
                PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardService.autoGet(pSDEWizard);
                this.psdewizard = pSDEWizard;
            }
            return this.psdewizard;
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
                pSLanguageResService.autoGet(pSLanguageRes);
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
                pSLanguageResService.autoGet(pSLanguageRes);
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCalendar getPSSysCalendar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCalendar();
        }
        if (this.getPSSysCalendarId() == null) {
            return null;
        }
        Integer n = this.objPSSysCalendarLock;
        synchronized (n) {
            if (this.pssyscalendar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCalendarId(), (Object)this.pssyscalendar.getPSSysCalendarId()) != 0L) {
                this.pssyscalendar = null;
            }
            if (this.pssyscalendar == null) {
                PSSysCalendar pSSysCalendar = new PSSysCalendar();
                pSSysCalendar.setPSSysCalendarId(this.getPSSysCalendarId());
                PSSysCalendarService pSSysCalendarService = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
                pSSysCalendarService.autoGet(pSSysCalendar);
                this.pssyscalendar = pSSysCalendar;
            }
            return this.pssyscalendar;
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
                pSSysCounterService.autoGet(pSSysCounter);
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
                pSSysCssService.autoGet(pSSysCss);
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
                pSSysCssService.autoGet(pSSysCss);
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
                pSSysCssService.autoGet(pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDashboard getPSSysDashboard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboard();
        }
        if (this.getPSSysDashboardId() == null) {
            return null;
        }
        Integer n = this.objPSSysDashboardLock;
        synchronized (n) {
            if (this.pssysdashboard != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDashboardId(), (Object)this.pssysdashboard.getPSSysDashboardId()) != 0L) {
                this.pssysdashboard = null;
            }
            if (this.pssysdashboard == null) {
                PSSysDashboard pSSysDashboard = new PSSysDashboard();
                pSSysDashboard.setPSSysDashboardId(this.getPSSysDashboardId());
                PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
                pSSysDashboardService.autoGet(pSSysDashboard);
                this.pssysdashboard = pSSysDashboard;
            }
            return this.pssysdashboard;
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
                pSSysEditorStyleService.autoGet(pSSysEditorStyle);
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
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMapView getPSSysMapView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMapView();
        }
        if (this.getPSSysMapViewId() == null) {
            return null;
        }
        Integer n = this.objPSSysMapViewLock;
        synchronized (n) {
            if (this.pssysmapview != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMapViewId(), (Object)this.pssysmapview.getPSSysMapViewId()) != 0L) {
                this.pssysmapview = null;
            }
            if (this.pssysmapview == null) {
                PSSysMapView pSSysMapView = new PSSysMapView();
                pSSysMapView.setPSSysMapViewId(this.getPSSysMapViewId());
                PSSysMapViewService pSSysMapViewService = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
                pSSysMapViewService.autoGet(pSSysMapView);
                this.pssysmapview = pSSysMapView;
            }
            return this.pssysmapview;
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
                pSSysPDTViewService.autoGet(pSSysPDTView);
                this.openpssyspdtview = pSSysPDTView;
            }
            return this.openpssyspdtview;
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
    public PSSysSearchBar getPSSysSearchBar() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchBar();
        }
        if (this.getPSSysSearchBarId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchBarLock;
        synchronized (n) {
            if (this.pssyssearchbar != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchBarId(), (Object)this.pssyssearchbar.getPSSysSearchBarId()) != 0L) {
                this.pssyssearchbar = null;
            }
            if (this.pssyssearchbar == null) {
                PSSysSearchBar pSSysSearchBar = new PSSysSearchBar();
                pSSysSearchBar.setPSSysSearchBarId(this.getPSSysSearchBarId());
                PSSysSearchBarService pSSysSearchBarService = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchBarService.autoGet(pSSysSearchBar);
                this.pssyssearchbar = pSSysSearchBar;
            }
            return this.pssyssearchbar;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getPPSSysViewPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysViewPanelItem();
        }
        if (this.getPPSSysViewPanelItemId() == null) {
            return null;
        }
        Integer n = this.objPPSSysViewPanelItemLock;
        synchronized (n) {
            if (this.ppssysviewpanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysViewPanelItemId(), (Object)this.ppssysviewpanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.ppssysviewpanelitem = null;
            }
            if (this.ppssysviewpanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getPPSSysViewPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet(pSSysViewPanelItem);
                this.ppssysviewpanelitem = pSSysViewPanelItem;
            }
            return this.ppssysviewpanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSDEPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPanel();
        }
        if (this.getPSDEPanelId() == null) {
            return null;
        }
        Integer n = this.objPSDEPanelLock;
        synchronized (n) {
            if (this.psdepanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEPanelId(), (Object)this.psdepanel.getPSSysViewPanelId()) != 0L) {
                this.psdepanel = null;
            }
            if (this.psdepanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSDEPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.psdepanel = pSSysViewPanel;
            }
            return this.psdepanel;
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
    public ArrayList<PSPanelItemLogic> getPSPanelItemLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelItemLogics();
        }
        if (this.getPSSysViewPanelItemId() == null) {
            return null;
        }
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelItemLogicsLock;
        synchronized (n) {
            if (this.pspanelitemlogics == null) {
                this.pspanelitemlogics = pSSysViewPanelItemService.isTempData(this) ? pSPanelItemLogicService.selectTempByPSSysViewPanelItem(this) : pSPanelItemLogicService.selectByPSSysViewPanelItem(this);
            }
            return this.pspanelitemlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewPanelItem> getPSSysViewPanelItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItems();
        }
        if (this.getPSSysViewPanelItemId() == null) {
            return null;
        }
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewPanelItemsLock;
        synchronized (n) {
            if (this.pssysviewpanelitems == null) {
                this.pssysviewpanelitems = pSSysViewPanelItemService.selectByPPSSysViewPanelItem(this);
            }
            return this.pssysviewpanelitems;
        }
    }

    private PSSysViewPanelItemBase getProxyEntity() {
        return this.proxyPSSysViewPanelItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysViewPanelItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysViewPanelItemBase) {
            this.proxyPSSysViewPanelItemBase = (PSSysViewPanelItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIVEDATAMODE, 0);
        fieldIndexMap.put(FIELD_ADPSDELOGICID, 1);
        fieldIndexMap.put(FIELD_ADPSDELOGICNAME, 2);
        fieldIndexMap.put(FIELD_AL_POS, 3);
        fieldIndexMap.put(FIELD_BLANKLOGIC, 4);
        fieldIndexMap.put(FIELD_BL_POS, 5);
        fieldIndexMap.put(FIELD_BORDERSTYLE, 6);
        fieldIndexMap.put(FIELD_BOTTOMPOS, 7);
        fieldIndexMap.put(FIELD_BTNACTIONTYPE, 8);
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 9);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 10);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 11);
        fieldIndexMap.put(FIELD_CAPTION, 12);
        fieldIndexMap.put(FIELD_CAPTIONPOS, 13);
        fieldIndexMap.put(FIELD_CHILD_COL_LG, 14);
        fieldIndexMap.put(FIELD_CHILD_COL_MD, 15);
        fieldIndexMap.put(FIELD_CHILD_COL_SM, 16);
        fieldIndexMap.put(FIELD_CHILD_COL_XS, 17);
        fieldIndexMap.put(FIELD_COLID, 18);
        fieldIndexMap.put(FIELD_COLLAPSIBLEFLAG, 19);
        fieldIndexMap.put(FIELD_COLMODEL, 20);
        fieldIndexMap.put(FIELD_COLSPAN, 21);
        fieldIndexMap.put(FIELD_COL_LG, 22);
        fieldIndexMap.put(FIELD_COL_LG_OS, 23);
        fieldIndexMap.put(FIELD_COL_MD, 24);
        fieldIndexMap.put(FIELD_COL_MD_OS, 25);
        fieldIndexMap.put(FIELD_COL_SM, 26);
        fieldIndexMap.put(FIELD_COL_SM_OS, 27);
        fieldIndexMap.put(FIELD_COL_WIDTH, 28);
        fieldIndexMap.put(FIELD_COL_XS, 29);
        fieldIndexMap.put(FIELD_COL_XS_OS, 30);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 31);
        fieldIndexMap.put(FIELD_COUNTERID, 32);
        fieldIndexMap.put(FIELD_COUNTERMODE, 33);
        fieldIndexMap.put(FIELD_CREATEDATE, 34);
        fieldIndexMap.put(FIELD_CREATEMAN, 35);
        fieldIndexMap.put(FIELD_CSSID, 36);
        fieldIndexMap.put(FIELD_CTRLDYNACLASS, 37);
        fieldIndexMap.put(FIELD_CTRLHEIGHT, 38);
        fieldIndexMap.put(FIELD_CTRLPSSYSCSSID, 39);
        fieldIndexMap.put(FIELD_CTRLPSSYSCSSNAME, 40);
        fieldIndexMap.put(FIELD_CTRLRAWCSSSTYLE, 41);
        fieldIndexMap.put(FIELD_CTRLTYPE, 42);
        fieldIndexMap.put(FIELD_CTRLWIDTH, 43);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 44);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 45);
        fieldIndexMap.put(FIELD_DATAPANELMODE, 46);
        fieldIndexMap.put(FIELD_DATASOURCE, 47);
        fieldIndexMap.put(FIELD_DATASOURCETEXT, 48);
        fieldIndexMap.put(FIELD_DETAILSTYLE, 49);
        fieldIndexMap.put(FIELD_DETAILSTYLETEXT, 50);
        fieldIndexMap.put(FIELD_DYNACLASS, 51);
        fieldIndexMap.put(FIELD_EDITORTYPE, 52);
        fieldIndexMap.put(FIELD_EDITORTYPENAME, 53);
        fieldIndexMap.put(FIELD_EMPTYCAPTION, 54);
        fieldIndexMap.put(FIELD_ENABLEANCHOR, 55);
        fieldIndexMap.put(FIELD_ENABLELOGIC, 56);
        fieldIndexMap.put(FIELD_FIELDNAME, 57);
        fieldIndexMap.put(FIELD_FIELDSTATES, 58);
        fieldIndexMap.put(FIELD_FLEXALIGN, 59);
        fieldIndexMap.put(FIELD_FLEXBASIS, 60);
        fieldIndexMap.put(FIELD_FLEXDIR, 61);
        fieldIndexMap.put(FIELD_FLEXGROW, 62);
        fieldIndexMap.put(FIELD_FLEXSHRINK, 63);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 64);
        fieldIndexMap.put(FIELD_GETDATATIMER, 65);
        fieldIndexMap.put(FIELD_GRIDROWID, 66);
        fieldIndexMap.put(FIELD_HALIGN, 67);
        fieldIndexMap.put(FIELD_HALIGNSELF, 68);
        fieldIndexMap.put(FIELD_HEIGHT, 69);
        fieldIndexMap.put(FIELD_HEIGHTMODE, 70);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 71);
        fieldIndexMap.put(FIELD_HTMLPAGEURL, 72);
        fieldIndexMap.put(FIELD_ICONALIGN, 73);
        fieldIndexMap.put(FIELD_IGNOREINPUT, 74);
        fieldIndexMap.put(FIELD_ITEMPARAM, 75);
        fieldIndexMap.put(FIELD_ITEMPARAM10, 76);
        fieldIndexMap.put(FIELD_ITEMPARAM11, 77);
        fieldIndexMap.put(FIELD_ITEMPARAM12, 78);
        fieldIndexMap.put(FIELD_ITEMPARAM2, 79);
        fieldIndexMap.put(FIELD_ITEMPARAM3, 80);
        fieldIndexMap.put(FIELD_ITEMPARAM4, 81);
        fieldIndexMap.put(FIELD_ITEMPARAM5, 82);
        fieldIndexMap.put(FIELD_ITEMPARAM6, 83);
        fieldIndexMap.put(FIELD_ITEMPARAM7, 84);
        fieldIndexMap.put(FIELD_ITEMPARAM8, 85);
        fieldIndexMap.put(FIELD_ITEMPARAM9, 86);
        fieldIndexMap.put(FIELD_ITEMPARAMS, 87);
        fieldIndexMap.put(FIELD_ITEMTYPE, 88);
        fieldIndexMap.put(FIELD_LABELDYNACLASS, 89);
        fieldIndexMap.put(FIELD_LABELPSSYSCSSID, 90);
        fieldIndexMap.put(FIELD_LABELPSSYSCSSNAME, 91);
        fieldIndexMap.put(FIELD_LABELRAWCSSSTYLE, 92);
        fieldIndexMap.put(FIELD_LABLECSSID, 93);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 94);
        fieldIndexMap.put(FIELD_LEFTPOS, 95);
        fieldIndexMap.put(FIELD_LOGICNAME, 96);
        fieldIndexMap.put(FIELD_MEMO, 97);
        fieldIndexMap.put(FIELD_MOBFLAG, 98);
        fieldIndexMap.put(FIELD_OPENPSAPPVIEWID, 99);
        fieldIndexMap.put(FIELD_OPENPSAPPVIEWNAME, 100);
        fieldIndexMap.put(FIELD_OPENPSDEVIEWID, 101);
        fieldIndexMap.put(FIELD_OPENPSDEVIEWNAME, 102);
        fieldIndexMap.put(FIELD_OPENPSSYSPDTVIEWID, 103);
        fieldIndexMap.put(FIELD_OPENPSSYSPDTVIEWNAME, 104);
        fieldIndexMap.put(FIELD_ORDERVALUE, 105);
        fieldIndexMap.put(FIELD_ORIENTATIONMODE, 106);
        fieldIndexMap.put(FIELD_PHPSLANRESID, 107);
        fieldIndexMap.put(FIELD_PHPSLANRESNAME, 108);
        fieldIndexMap.put(FIELD_PLACEHOLDER, 109);
        fieldIndexMap.put(FIELD_PLAYOUTMODE, 110);
        fieldIndexMap.put(FIELD_PPSSYSVIEWPANELITEMID, 111);
        fieldIndexMap.put(FIELD_PPSSYSVIEWPANELITEMNAME, 112);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 113);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 114);
        fieldIndexMap.put(FIELD_PREVIEWHTML, 115);
        fieldIndexMap.put(FIELD_PSACHANDLERID, 116);
        fieldIndexMap.put(FIELD_PSACHANDLERNAME, 117);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 118);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 119);
        fieldIndexMap.put(FIELD_PSCODELISTID, 120);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 121);
        fieldIndexMap.put(FIELD_PSCTRLID, 122);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 123);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 124);
        fieldIndexMap.put(FIELD_PSCTRLNAME, 125);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 126);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 127);
        fieldIndexMap.put(FIELD_PSDECHARTID, 128);
        fieldIndexMap.put(FIELD_PSDECHARTNAME, 129);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 130);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 131);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWID, 132);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWNAME, 133);
        fieldIndexMap.put(FIELD_PSDEDRID, 134);
        fieldIndexMap.put(FIELD_PSDEDRITEMID, 135);
        fieldIndexMap.put(FIELD_PSDEDRITEMNAME, 136);
        fieldIndexMap.put(FIELD_PSDEDRNAME, 137);
        fieldIndexMap.put(FIELD_PSDEFORMID, 138);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 139);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 140);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 141);
        fieldIndexMap.put(FIELD_PSDEID, 142);
        fieldIndexMap.put(FIELD_PSDELISTID, 143);
        fieldIndexMap.put(FIELD_PSDELISTNAME, 144);
        fieldIndexMap.put(FIELD_PSDELOGICID, 145);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 146);
        fieldIndexMap.put(FIELD_PSDENAME, 147);
        fieldIndexMap.put(FIELD_PSDEPANELID, 148);
        fieldIndexMap.put(FIELD_PSDEPANELNAME, 149);
        fieldIndexMap.put(FIELD_PSDEREPORTID, 150);
        fieldIndexMap.put(FIELD_PSDEREPORTNAME, 151);
        fieldIndexMap.put(FIELD_PSDESEARCHFORMID, 152);
        fieldIndexMap.put(FIELD_PSDESEARCHFORMNAME, 153);
        fieldIndexMap.put(FIELD_PSDETOOLBARID, 154);
        fieldIndexMap.put(FIELD_PSDETOOLBARNAME, 155);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 156);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 157);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 158);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 159);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 160);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 161);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 162);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 163);
        fieldIndexMap.put(FIELD_PSDEWIZARDID, 164);
        fieldIndexMap.put(FIELD_PSDEWIZARDNAME, 165);
        fieldIndexMap.put(FIELD_PSSYSCALENDARID, 166);
        fieldIndexMap.put(FIELD_PSSYSCALENDARNAME, 167);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 168);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 169);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 170);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 171);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDID, 172);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDNAME, 173);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 174);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 175);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLEID, 176);
        fieldIndexMap.put(FIELD_PSSYSEDITORSTYLENAME, 177);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 178);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 179);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWID, 180);
        fieldIndexMap.put(FIELD_PSSYSMAPVIEWNAME, 181);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 182);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 183);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 184);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 185);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARID, 186);
        fieldIndexMap.put(FIELD_PSSYSSEARCHBARNAME, 187);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 188);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMID, 189);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMNAME, 190);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 191);
        fieldIndexMap.put(FIELD_RAWCONTENT, 192);
        fieldIndexMap.put(FIELD_RAWCSSSTYLE, 193);
        fieldIndexMap.put(FIELD_RAWSERVICEMETHOD, 194);
        fieldIndexMap.put(FIELD_RAWSERVICEURL, 195);
        fieldIndexMap.put(FIELD_READONLYMODE, 196);
        fieldIndexMap.put(FIELD_REFCTRL2NAME, 197);
        fieldIndexMap.put(FIELD_REFCTRL2USAGE, 198);
        fieldIndexMap.put(FIELD_REFCTRL2USAGETEXT, 199);
        fieldIndexMap.put(FIELD_REFCTRLNAME, 200);
        fieldIndexMap.put(FIELD_REFCTRLUSAGE, 201);
        fieldIndexMap.put(FIELD_REFCTRLUSAGETEXT, 202);
        fieldIndexMap.put(FIELD_REFLINKPSDEVIEWID, 203);
        fieldIndexMap.put(FIELD_REFLINKPSDEVIEWNAME, 204);
        fieldIndexMap.put(FIELD_REFPICKUPPSDEVIEWID, 205);
        fieldIndexMap.put(FIELD_REFPICKUPPSDEVIEWNAME, 206);
        fieldIndexMap.put(FIELD_REFPSDEACMODEID, 207);
        fieldIndexMap.put(FIELD_REFPSDEACMODENAME, 208);
        fieldIndexMap.put(FIELD_REFPSDEDATASETID, 209);
        fieldIndexMap.put(FIELD_REFPSDEDATASETNAME, 210);
        fieldIndexMap.put(FIELD_REFPSDEID, 211);
        fieldIndexMap.put(FIELD_REFPSDENAME, 212);
        fieldIndexMap.put(FIELD_RENDERMODE, 213);
        fieldIndexMap.put(FIELD_RENDERMODETEXT, 214);
        fieldIndexMap.put(FIELD_RESETITEMNAME, 215);
        fieldIndexMap.put(FIELD_RIGHTPOS, 216);
        fieldIndexMap.put(FIELD_ROWSPAN, 217);
        fieldIndexMap.put(FIELD_SHOWCAPTION, 218);
        fieldIndexMap.put(FIELD_SPACINGBOTTOM, 219);
        fieldIndexMap.put(FIELD_SPACINGLEFT, 220);
        fieldIndexMap.put(FIELD_SPACINGRIGHT, 221);
        fieldIndexMap.put(FIELD_SPACINGTOP, 222);
        fieldIndexMap.put(FIELD_SWAPMODE, 223);
        fieldIndexMap.put(FIELD_TABINDEX, 224);
        fieldIndexMap.put(FIELD_TARGETID, 225);
        fieldIndexMap.put(FIELD_TARGETNAME, 226);
        fieldIndexMap.put(FIELD_TARGETTYPE, 227);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 228);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 229);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 230);
        fieldIndexMap.put(FIELD_TITLEBARCLOSEMODE, 231);
        fieldIndexMap.put(FIELD_TOGGLEMODE, 232);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 233);
        fieldIndexMap.put(FIELD_TOPPOS, 234);
        fieldIndexMap.put(FIELD_UPDATEDATE, 235);
        fieldIndexMap.put(FIELD_UPDATEMAN, 236);
        fieldIndexMap.put(FIELD_USERTAG, 237);
        fieldIndexMap.put(FIELD_USERTAG2, 238);
        fieldIndexMap.put(FIELD_VALIGN, 239);
        fieldIndexMap.put(FIELD_VALIGNSELF, 240);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 241);
        fieldIndexMap.put(FIELD_VALUEITEMNAME, 242);
        fieldIndexMap.put(FIELD_VISIBLELOGIC, 243);
        fieldIndexMap.put(FIELD_WIDTH, 244);
        fieldIndexMap.put(FIELD_WIDTHMODE, 245);
    }
}

