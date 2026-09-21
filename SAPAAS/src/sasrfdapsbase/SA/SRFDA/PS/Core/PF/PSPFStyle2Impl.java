/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppDataEntityTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppObjectTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppWFTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppWFVerTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder2;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl2;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl2;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin2;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFPubObj;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFStyleCode;
import SA.SRFDA.PS.Core.PF.IPSPFStylePkg;
import SA.SRFDA.PS.Core.PF.IPSPFStylePrj;
import SA.SRFDA.PS.Core.PF.IPSPFUIActionTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl2;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl2;
import SA.SRFDA.PS.Core.PF.PSPFAppDataEntityTemplImpl;
import SA.SRFDA.PS.Core.PF.PSPFAppObjectTemplImpl;
import SA.SRFDA.PS.Core.PF.PSPFAppTempl2Impl;
import SA.SRFDA.PS.Core.PF.PSPFAppWFTemplImpl;
import SA.SRFDA.PS.Core.PF.PSPFAppWFVerTemplImpl;
import SA.SRFDA.PS.Core.PF.PSPFCodeFolder2Impl;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTempl2Impl;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplDetailProxy;
import SA.SRFDA.PS.Core.PF.PSPFEditorTempl2Impl;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Core.PF.PSPFPubCode2Impl;
import SA.SRFDA.PS.Core.PF.PSPFStyleCodeGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFStylePkgGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFStylePrjGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFUIActionTemplGlobalModel;
import SA.SRFDA.PS.Core.PF.PSPFViewLogicTempl2Impl;
import SA.SRFDA.PS.Core.PF.PSPFViewTempl2Impl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyleRuntime;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.PS.Data.PSPFViewTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSPFStyle2Impl
extends PSPFObjectImpl
implements IPSPFStyle2 {
    private static final Log log = LogFactory.getLog(PSPFStyle2Impl.class);
    protected PSPFStyle psPFStyle = null;
    protected HashMap<String, ArrayList<IPSPFViewTempl>> psPFViewTemplListMap = new HashMap();
    protected HashMap<String, ArrayList<IPSPFViewTempl>> psPFViewTemplListMap2 = new HashMap();
    protected HashMap<String, IPSPFViewTempl2> psPFViewTemplMap2 = new HashMap();
    protected HashMap<String, ArrayList<IPSPFCtrlTempl>> psPFCtrlTemplMap = new HashMap();
    protected HashMap<String, IPSPFCtrlTempl2> psPFCtrlTemplMap2 = new HashMap();
    protected HashMap<String, IPSPFEditorTempl2> psPFEditorTemplMap2 = new HashMap();
    protected HashMap<String, IPSPFViewLogicTempl2> psPFViewLogicTemplMap2 = new HashMap();
    protected PSPFStyleCodeGlobalModel psPFStyleCodeGlobalModel = new PSPFStyleCodeGlobalModel();
    protected PSPFUIActionTemplGlobalModel psPFUIActionTemplGlobalModel = new PSPFUIActionTemplGlobalModel();
    protected PSPFStylePrjGlobalModel psPFStylePrjGlobalModel = new PSPFStylePrjGlobalModel();
    protected HashMap<String, PSPFCtrlTemplDetailProxy> psPFCtrlTemplDetailProxyMap = new HashMap();
    protected PSPFStylePkgGlobalModel psPFStylePkgGlobalModel = new PSPFStylePkgGlobalModel();
    protected ArrayList<IPSPFPkgVer> psPFPkgVerList = new ArrayList();
    private String strTemplPSPFStyleId = "";
    private IPSPFStyle templPSPFStyle = null;
    private String strTemplDocRootUrl = null;
    private String strResourceUrl = null;
    private String strVersionString = "";
    private Properties classPkgParamsMap = null;
    protected ArrayList<IPSPFCodeFolder> psPFCodeFolderList = new ArrayList();
    protected HashMap<String, IPSPFCodeFolder> psPFCodeFolderMap = new HashMap();
    protected HashMap<String, IPSPFPubCode> psPFPubCodeMap = new HashMap();
    protected HashMap<String, IPSPFAppTempl> psPFAppTemplMap = new HashMap();
    protected HashMap<String, IPSPFAppDataEntityTempl> psPFAppDataEntityTemplMap = new HashMap();
    protected HashMap<String, ArrayList<IPSPFPubCode>> psPFPubCodesMap = new HashMap();
    protected HashMap<String, IPSPFAppWFTempl> psPFAppWFTemplMap = new HashMap();
    protected HashMap<String, IPSPFAppWFVerTempl> psPFAppWFVerTemplMap = new HashMap();
    protected HashMap<String, HashMap<String, IPSPFAppObjectTempl>> psAppObjectTemplMapMap = new HashMap();
    private File rootFolder = null;
    private String strRealLocalPath = null;
    private File resRootFolder = null;
    private String strRealResLocalPath = null;
    private Properties styleTemplateProperties = null;
    private static HashMap<String, String> REALVIEWTYPEMAP = new HashMap();
    private static Map<String, String> TARGETTYPEMAP = new HashMap<String, String>();

    static {
        REALVIEWTYPEMAP.put("APPDATAUPLOADVIEW", "APPDATAUPLOADVIEW");
        REALVIEWTYPEMAP.put("APPERRORVIEW", "APPERRORVIEW");
        REALVIEWTYPEMAP.put("APPFILEUPLOADVIEW", "APPFILEUPLOADVIEW");
        REALVIEWTYPEMAP.put("APPFUNCPICKUPVIEW", "APPFUNCPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPINDEXVIEW", "APPINDEXVIEW");
        REALVIEWTYPEMAP.put("APPLOGINVIEW", "APPLOGINVIEW");
        REALVIEWTYPEMAP.put("APPLOGOUTVIEW", "APPLOGOUTVIEW");
        REALVIEWTYPEMAP.put("APPPANELVIEW", "APPPANELVIEW");
        REALVIEWTYPEMAP.put("APPPICUPLOADVIEW", "APPPICUPLOADVIEW");
        REALVIEWTYPEMAP.put("APPPORTALVIEW", "APPPORTALVIEW");
        REALVIEWTYPEMAP.put("APPSTARTVIEW", "APPSTARTVIEW");
        REALVIEWTYPEMAP.put("APPWFADDSTEPAFTERVIEW", "APPWFADDSTEPAFTERVIEW");
        REALVIEWTYPEMAP.put("APPWFADDSTEPBEFOREVIEW", "APPWFADDSTEPBEFOREVIEW");
        REALVIEWTYPEMAP.put("APPWFSENDBACKVIEW", "APPWFSENDBACKVIEW");
        REALVIEWTYPEMAP.put("APPWFSTEPACTORVIEW", "APPWFSTEPACTORVIEW");
        REALVIEWTYPEMAP.put("APPWFSTEPDATAVIEW", "APPWFSTEPDATAVIEW");
        REALVIEWTYPEMAP.put("APPWFSTEPTRACEVIEW", "APPWFSTEPTRACEVIEW");
        REALVIEWTYPEMAP.put("APPWFSUPPLYINFOVIEW", "APPWFSUPPLYINFOVIEW");
        REALVIEWTYPEMAP.put("APPWFTAKEADVICEVIEW", "APPWFTAKEADVICEVIEW");
        REALVIEWTYPEMAP.put("APPDECALENDARVIEW", "DECALENDARVIEW");
        REALVIEWTYPEMAP.put("APPDECALENDARVIEW9", "DECALENDARVIEW9");
        REALVIEWTYPEMAP.put("APPDECHARTVIEW", "DECHARTVIEW");
        REALVIEWTYPEMAP.put("APPDECHARTVIEW9", "DECHARTVIEW9");
        REALVIEWTYPEMAP.put("APPDECUSTOMVIEW", "DECUSTOMVIEW");
        REALVIEWTYPEMAP.put("APPDEDATAVIEW", "DEDATAVIEW");
        REALVIEWTYPEMAP.put("APPDEEDITVIEW", "DEEDITVIEW");
        REALVIEWTYPEMAP.put("APPDEEDITVIEW2", "DEEDITVIEW2");
        REALVIEWTYPEMAP.put("APPDEEDITVIEW3", "DEEDITVIEW3");
        REALVIEWTYPEMAP.put("APPDEEDITVIEW4", "DEEDITVIEW4");
        REALVIEWTYPEMAP.put("APPDEEDITVIEW9", "DEEDITVIEW9");
        REALVIEWTYPEMAP.put("APPDEFORMPICKUPDATAVIEW", "DEFORMPICKUPDATAVIEW");
        REALVIEWTYPEMAP.put("APPDEGRIDVIEW", "DEGRIDVIEW");
        REALVIEWTYPEMAP.put("APPDEGRIDVIEW2", "DEGRIDVIEW2");
        REALVIEWTYPEMAP.put("APPDEGRIDVIEW4", "DEGRIDVIEW4");
        REALVIEWTYPEMAP.put("APPDEGRIDVIEW8", "DEGRIDVIEW8");
        REALVIEWTYPEMAP.put("APPDEGRIDVIEW9", "DEGRIDVIEW9");
        REALVIEWTYPEMAP.put("APPDEHTMLVIEW", "DEHTMLVIEW");
        REALVIEWTYPEMAP.put("APPDEINDEXPICKUPDATAVIEW", "DEINDEXPICKUPDATAVIEW");
        REALVIEWTYPEMAP.put("APPDEINDEXVIEW", "DEINDEXVIEW");
        REALVIEWTYPEMAP.put("APPDEMDCUSTOMVIEW", "DEMDCUSTOMVIEW");
        REALVIEWTYPEMAP.put("APPDEMEDITVIEW9", "DEMEDITVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBCALENDARVIEW", "DEMOBCALENDARVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBCALENDARVIEW9", "DEMOBCALENDARVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBCHARTVIEW", "DEMOBCHARTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBCHARTVIEW9", "DEMOBCHARTVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBCUSTOMVIEW", "DEMOBCUSTOMVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBEDITVIEW", "DEMOBEDITVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBEDITVIEW3", "DEMOBEDITVIEW3");
        REALVIEWTYPEMAP.put("APPDEMOBEDITVIEW9", "DEMOBEDITVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBFORMPICKUPMDVIEW", "DEMOBFORMPICKUPMDVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBINDEXPICKUPMDVIEW", "DEMOBINDEXPICKUPMDVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBLISTVIEW", "DEMOBLISTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBMDVIEW", "DEMOBMDVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBMDVIEW9", "DEMOBMDVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBMEDITVIEW9", "DEMOBMEDITVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBMPICKUPVIEW", "DEMOBMPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBOPTVIEW", "DEMOBOPTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBPANELVIEW", "DEMOBPANELVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBPANELVIEW9", "DEMOBPANELVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBPICKUPLISTVIEW", "DEMOBPICKUPLISTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBPICKUPMDVIEW", "DEMOBPICKUPMDVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBPICKUPTREEVIEW", "DEMOBPICKUPTREEVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBPICKUPVIEW", "DEMOBPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBREDIRECTVIEW", "DEMOBREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBTABEXPVIEW", "DEMOBTABEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBTREEVIEW", "DEMOBTREEVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFACTIONVIEW", "DEMOBWFACTIONVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFDATAREDIRECTVIEW", "DEMOBWFDATAREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFEDITVIEW", "DEMOBWFEDITVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFEDITVIEW3", "DEMOBWFEDITVIEW3");
        REALVIEWTYPEMAP.put("APPDEMOBWFMDVIEW", "DEMOBWFMDVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFPROXYRESULTVIEW", "DEMOBWFPROXYRESULTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFPROXYSTARTVIEW", "DEMOBWFPROXYSTARTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFSTARTVIEW", "DEMOBWFSTARTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWIZARDVIEW", "DEMOBWIZARDVIEW");
        REALVIEWTYPEMAP.put("APPDEMPICKUPVIEW", "DEMPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPDEMPICKUPVIEW2", "DEMPICKUPVIEW2");
        REALVIEWTYPEMAP.put("APPDEOPTVIEW", "DEOPTVIEW");
        REALVIEWTYPEMAP.put("APPDEPANELVIEW", "DEPANELVIEW");
        REALVIEWTYPEMAP.put("APPDEPANELVIEW9", "DEPANELVIEW9");
        REALVIEWTYPEMAP.put("APPDEPICKUPDATAVIEW", "DEPICKUPDATAVIEW");
        REALVIEWTYPEMAP.put("APPDEPICKUPGRIDVIEW", "DEPICKUPGRIDVIEW");
        REALVIEWTYPEMAP.put("APPDEPICKUPTREEVIEW", "DEPICKUPTREEVIEW");
        REALVIEWTYPEMAP.put("APPDEPICKUPVIEW", "DEPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPDEPICKUPVIEW2", "DEPICKUPVIEW2");
        REALVIEWTYPEMAP.put("APPDEPORTALVIEW", "DEPORTALVIEW");
        REALVIEWTYPEMAP.put("APPDEPORTALVIEW9", "DEPORTALVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBPORTALVIEW", "DEMOBPORTALVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBPORTALVIEW9", "DEMOBPORTALVIEW9");
        REALVIEWTYPEMAP.put("APPDEREDIRECTVIEW", "DEREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDEREPORTVIEW", "DEREPORTVIEW");
        REALVIEWTYPEMAP.put("APPDETABEXPVIEW", "DETABEXPVIEW");
        REALVIEWTYPEMAP.put("APPDETREEEXPVIEW", "DETREEEXPVIEW");
        REALVIEWTYPEMAP.put("APPDETREEEXPVIEW2", "DETREEEXPVIEW2");
        REALVIEWTYPEMAP.put("APPDETREEEXPVIEW3", "DETREEEXPVIEW3");
        REALVIEWTYPEMAP.put("APPDETREEGRIDVIEW9", "DETREEGRIDVIEW9");
        REALVIEWTYPEMAP.put("APPDETREEVIEW", "DETREEVIEW");
        REALVIEWTYPEMAP.put("APPDETREEVIEW9", "DETREEVIEW9");
        REALVIEWTYPEMAP.put("APPDEWFACTIONVIEW", "DEWFACTIONVIEW");
        REALVIEWTYPEMAP.put("APPDEWFDATAREDIRECTVIEW", "DEWFDATAREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDEWFEDITPROXYDATAVIEW", "DEWFEDITPROXYDATAVIEW");
        REALVIEWTYPEMAP.put("APPDEWFEDITVIEW", "DEWFEDITVIEW");
        REALVIEWTYPEMAP.put("APPDEWFEDITVIEW2", "DEWFEDITVIEW2");
        REALVIEWTYPEMAP.put("APPDEWFEDITVIEW3", "DEWFEDITVIEW3");
        REALVIEWTYPEMAP.put("APPDEWFEDITVIEW9", "DEWFEDITVIEW9");
        REALVIEWTYPEMAP.put("APPDEWFEXPVIEW", "DEWFEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEWFGRIDVIEW", "DEWFGRIDVIEW");
        REALVIEWTYPEMAP.put("APPDEWFPROXYDATAREDIRECTVIEW", "DEWFPROXYDATAREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDEWFPROXYDATAVIEW", "DEWFPROXYDATAVIEW");
        REALVIEWTYPEMAP.put("APPDEWFPROXYRESULTVIEW", "DEWFPROXYRESULTVIEW");
        REALVIEWTYPEMAP.put("APPDEWFPROXYSTARTVIEW", "DEWFPROXYSTARTVIEW");
        REALVIEWTYPEMAP.put("APPDEWFSTARTVIEW", "DEWFSTARTVIEW");
        REALVIEWTYPEMAP.put("APPDEWIZARDVIEW", "DEWIZARDVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEEDITVIEW", "DYNADEEDITVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEEDITVIEW2", "DYNADEEDITVIEW2");
        REALVIEWTYPEMAP.put("APPDYNADEGRIDVIEW", "DYNADEGRIDVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEMPICKUPVIEW", "DYNADEMPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEMPICKUPVIEW2", "DYNADEMPICKUPVIEW2");
        REALVIEWTYPEMAP.put("APPDYNADEPICKUPGRIDVIEW", "DYNADEPICKUPGRIDVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEPICKUPVIEW", "DYNADEPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEPICKUPVIEW2", "DYNADEPICKUPVIEW2");
        REALVIEWTYPEMAP.put("APPDYNADEREDIRECTVIEW", "DYNADEREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFACTIONVIEW", "DYNADEWFACTIONVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFDATAREDIRECTVIEW", "DYNADEWFDATAREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFEDITVIEW", "DYNADEWFEDITVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFEDITVIEW2", "DYNADEWFEDITVIEW2");
        REALVIEWTYPEMAP.put("APPDYNADEWFEDITVIEW3", "DYNADEWFEDITVIEW3");
        REALVIEWTYPEMAP.put("APPDYNADEWFEXPVIEW", "DYNADEWFEXPVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFGRIDVIEW", "DYNADEWFGRIDVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFPROXYDATAREDIRECTVIEW", "DYNADEWFPROXYDATAREDIRECTVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFPROXYDATAVIEW", "DYNADEWFPROXYDATAVIEW");
        REALVIEWTYPEMAP.put("APPDYNADEWFSTARTVIEW", "DYNADEWFSTARTVIEW");
        REALVIEWTYPEMAP.put("APPDETABFORMVIEW9", "DETABFORMVIEW9");
        REALVIEWTYPEMAP.put("APPDEPICKUPVIEW3", "DEPICKUPVIEW3");
        REALVIEWTYPEMAP.put("APPDETREEPICKUPVIEW", "DETREEPICKUPVIEW");
        REALVIEWTYPEMAP.put("APPDEDATAVIEW9", "DEDATAVIEW9");
        REALVIEWTYPEMAP.put("APPDELISTVIEW", "DELISTVIEW");
        REALVIEWTYPEMAP.put("APPDELISTVIEW9", "DELISTVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBTREEEXPVIEW", "DEMOBTREEEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBDATAVIEW", "DEMOBDATAVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBDATAVIEW9", "DEMOBDATAVIEW9");
        REALVIEWTYPEMAP.put("APPDEMAPVIEW", "DEMAPVIEW");
        REALVIEWTYPEMAP.put("APPDEMAPVIEW9", "DEMAPVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBMAPVIEW", "DEMOBMAPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBMAPVIEW9", "DEMOBMAPVIEW9");
        REALVIEWTYPEMAP.put("APPDEGANTTVIEW", "DEGANTTVIEW");
        REALVIEWTYPEMAP.put("APPDEGANTTVIEW9", "DEGANTTVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBGANTTVIEW", "DEMOBGANTTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBGANTTVIEW9", "DEMOBGANTTVIEW9");
        REALVIEWTYPEMAP.put("APPDECALENDAREXPVIEW", "DECALENDAREXPVIEW");
        REALVIEWTYPEMAP.put("APPDEGANTTEXPVIEW", "DEGANTTEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMAPEXPVIEW", "DEMAPEXPVIEW");
        REALVIEWTYPEMAP.put("APPDECHARTEXPVIEW", "DECHARTEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEGRIDEXPVIEW", "DEGRIDEXPVIEW");
        REALVIEWTYPEMAP.put("APPDELISTEXPVIEW", "DELISTEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEDATAVIEWEXPVIEW", "DEDATAVIEWEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBCALENDAREXPVIEW", "DEMOBCALENDAREXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBGANTTEXPVIEW", "DEMOBGANTTEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBMAPEXPVIEW", "DEMOBMAPEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBCHARTEXPVIEW", "DEMOBCHARTEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBLISTEXPVIEW", "DEMOBLISTEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBDATAVIEWEXPVIEW", "DEMOBDATAVIEWEXPVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBTREEEXPVIEW9", "DEMOBTREEEXPVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBTABEXPVIEW9", "DEMOBTABEXPVIEW9");
        REALVIEWTYPEMAP.put("APPDEWFDYNAEXPGRIDVIEW", "DEWFDYNAEXPGRIDVIEW");
        REALVIEWTYPEMAP.put("APPDEWFDYNAEDITVIEW", "DEWFDYNAEDITVIEW");
        REALVIEWTYPEMAP.put("APPDEWFDYNAEDITVIEW3", "DEWFDYNAEDITVIEW3");
        REALVIEWTYPEMAP.put("APPDETREEGRIDEXVIEW", "DETREEGRIDEXVIEW");
        REALVIEWTYPEMAP.put("APPDETREEGRIDEXVIEW9", "DETREEGRIDEXVIEW9");
        REALVIEWTYPEMAP.put("APPDEKANBANVIEW", "DEKANBANVIEW");
        REALVIEWTYPEMAP.put("APPDEKANBANVIEW9", "DEKANBANVIEW9");
        REALVIEWTYPEMAP.put("APPDETABEXPVIEW9", "DETABEXPVIEW9");
        REALVIEWTYPEMAP.put("APPDETABSEARCHVIEW", "DETABSEARCHVIEW");
        REALVIEWTYPEMAP.put("APPDETABSEARCHVIEW9", "DETABSEARCHVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBTABSEARCHVIEW", "DEMOBTABSEARCHVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBTABSEARCHVIEW9", "DEMOBTABSEARCHVIEW9");
        REALVIEWTYPEMAP.put("APPDEMOBWFDYNAEDITVIEW3", "DEMOBWFDYNAEDITVIEW3");
        REALVIEWTYPEMAP.put("APPDEMOBWFDYNAEDITVIEW", "DEMOBWFDYNAEDITVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFDYNAEXPMDVIEW", "DEMOBWFDYNAEXPMDVIEW");
        REALVIEWTYPEMAP.put("APPDEWFDYNAACTIONVIEW", "DEWFDYNAACTIONVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFDYNAACTIONVIEW", "DEMOBWFDYNAACTIONVIEW");
        REALVIEWTYPEMAP.put("APPDEWFDYNASTARTVIEW", "DEWFDYNASTARTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBWFDYNASTARTVIEW", "DEMOBWFDYNASTARTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBREPORTVIEW", "DEMOBREPORTVIEW");
        REALVIEWTYPEMAP.put("APPDEMOBHTMLVIEW", "DEMOBHTMLVIEW");
        TARGETTYPEMAP.put("PSAPPCODELIST", "CODELIST");
        TARGETTYPEMAP.put("PSAPPCOUNTER", "COUNTER");
        TARGETTYPEMAP.put("PSAPPDELOGIC", "DELOGIC");
        TARGETTYPEMAP.put("PSAPPDEUILOGIC", "DEUILOGIC");
        TARGETTYPEMAP.put("PSAPPDEMETHODDTO", "DEMETHODDTO");
        TARGETTYPEMAP.put("PSAPPUTIL", "UTIL");
        TARGETTYPEMAP.put("PSAPPLAN", "LAN");
        TARGETTYPEMAP.put("PSAPPMSGTEMPL", "MSGTEMPL");
        TARGETTYPEMAP.put("PSAPPVIEWMSG", "VIEWMSG");
        TARGETTYPEMAP.put("PSAPPVIEWMSGGROUP", "VIEWMSGGROUP");
        TARGETTYPEMAP.put("PSAPPPFPLUGINREF", "PFPLUGINREF");
        TARGETTYPEMAP.put("PSAPPEDITORSTYLEREF", "EDITORSTYLEREF");
        TARGETTYPEMAP.put("PSAPPSUBVIEWTYPEREF", "SUBVIEWTYPEREF");
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFStyle psPFStyle) throws Exception {
        try {
            this.psPFStyle = psPFStyle;
            this.setPSPF(iPSPF);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(this.psPFStyle.getPSPFSTYLEID());
            if (StringHelper.IsNullOrEmpty((String)this.psPFStyle.getPSPFSTYLEID())) {
                this.setId(this.psPFStyle.getTEMPLPSPFSTYLEID());
            }
            this.setName(this.psPFStyle.getPSPFSTYLENAME());
            this.setPSObjectData(this.psPFStyle);
            if (!this.psPFStyle.isVERSIONNull()) {
                this.setVersion(this.psPFStyle.getVERSION());
            } else {
                this.setVersion(1);
            }
            this.strVersionString = this.psPFStyle.getVERSTR();
            this.classPkgParamsMap = PropertiesHelper.load((String)this.psPFStyle.getCLSPKGPARAMS());
            this.strTemplPSPFStyleId = this.psPFStyle.getTEMPLPSPFSTYLEID();
            this.strTemplDocRootUrl = this.psPFStyle.getTEMPLROOTURL();
            this.strResourceUrl = this.psPFStyle.getSTYLERESURL();
            if (StringHelper.IsNullOrEmpty((String)this.strTemplDocRootUrl) && this.getTemplPSPFStyle() != null) {
                this.strTemplDocRootUrl = this.getTemplPSPFStyle().getTemplDocRootUrl();
            }
            if (StringHelper.IsNullOrEmpty((String)this.strVersionString) && this.getTemplPSPFStyle() != null) {
                this.strVersionString = this.getTemplPSPFStyle().getVersionString();
            }
            if (StringHelper.IsNullOrEmpty((String)this.strResourceUrl) && this.getTemplPSPFStyle() != null) {
                this.strResourceUrl = this.getTemplPSPFStyle().getResourceUrl();
            }
            for (String strKey : TARGETTYPEMAP.keySet()) {
                this.psAppObjectTemplMapMap.put(strKey, new HashMap());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strError = StringHelper.Format((String)"\u521d\u59cb\u5316\u524d\u7aef\u6a21\u677f\u6837\u5f0f[%1$s|%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSPF.getName(), (Object)psPFStyle.getPSPFSTYLENAME(), (Object)ex.getMessage());
            log.error((Object)strError, (Throwable)ex);
            throw new Exception(strError, ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.rootFolder = new File(this.getLocalPath());
        this.pullToLocal();
        if (this.getTemplPSPFStyle() instanceof IPSPFStyle2) {
            CmdHelper.Result result;
            String strCmd;
            String strSourceFolder2;
            String strTempFolder;
            IPSPFStyle2 iPSPFStyle2 = (IPSPFStyle2)this.getTemplPSPFStyle();
            String strSourceFolder = iPSPFStyle2.getRealLocalPath();
            if (!StringHelper.IsNullOrEmpty((String)strSourceFolder)) {
                strTempFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder("TEMPL");
                strSourceFolder2 = this.getLocalPath();
                strCmd = "";
                strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$smergehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strSourceFolder, (Object)strSourceFolder2) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$smergehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strSourceFolder, (Object)strSourceFolder2);
                result = CmdHelper.getInstance().executeBat(strCmd);
                this.strRealLocalPath = strTempFolder;
                this.rootFolder = new File(this.getRealLocalPath());
            }
            if (!StringHelper.IsNullOrEmpty((String)(strSourceFolder = iPSPFStyle2.getRealResLocalPath()))) {
                strTempFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder("TEMPL");
                strSourceFolder2 = this.getResLocalPath();
                strCmd = "";
                strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$smergehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strSourceFolder, (Object)strSourceFolder2) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$smergehelp.py %3$s %4$s %5$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strTempFolder, (Object)strSourceFolder, (Object)strSourceFolder2);
                result = CmdHelper.getInstance().executeBat(strCmd);
                this.strRealResLocalPath = strTempFolder;
                this.resRootFolder = new File(this.getRealResLocalPath());
            }
        }
        if (!this.rootFolder.exists()) {
            throw new Exception("\u672c\u5730\u7f13\u5b58\u4e0d\u5b58\u5728\uff0c\u672a\u80fd\u4ece\u6307\u5b9a\u4ed3\u5e93\u83b7\u53d6\u6a21\u677f");
        }
        File propertiesFile = new File(String.valueOf(this.rootFolder.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            this.styleTemplateProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        this.onPreparePSPFCodeFolders();
        this.onPreparePSPFPubCodes();
        this.psPFStylePkgGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFStylePrjGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFStyleCodeGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psPFUIActionTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
        super.onInit();
        this.getPSPFStyleCodes();
        this.preparePSPFPkgVers();
    }

    protected void pullToLocal() throws Exception {
        String strGitUser = "";
        String strGitPassword = "";
        if (!StringHelper.IsNullOrEmpty((String)this.getRemotePath())) {
            PSSVNServer psSVNServer = null;
            PSDevSlnTemplService psDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnTempl psDevSlnTempl = new PSDevSlnTempl();
            psDevSlnTempl.setPSPFId(this.getPSPF().getId());
            psDevSlnTempl.setPSPFStyleId(this.getId());
            if (psDevSlnTemplService.selectOne((IEntity)psDevSlnTempl, true) && psDevSlnTempl.getPSDevCenterSVN() != null && psDevSlnTempl.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
                psSVNServer = psDevSlnTempl.getPSDevCenterSVN().getPSSVNInstRepo().getPSSVNServer();
            }
            if (psSVNServer == null) {
                log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u524d\u7aef\u6a21\u677f[%1$s]\u6837\u5f0f[%2$s]\u7684\u7248\u672c\u670d\u52a1\u5668", (Object)this.getPSPF().getId(), (Object)this.getId()));
            } else {
                if (!StringHelper.IsNullOrEmpty((String)psSVNServer.getGITUserName())) {
                    strGitUser = psSVNServer.getGITUserName();
                }
                if (!StringHelper.IsNullOrEmpty((String)psSVNServer.getGITPassword())) {
                    strGitPassword = psSVNServer.getGITPassword();
                }
            }
            String strLocalFolder = this.rootFolder.getParent();
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getRemotePath(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getRemotePath(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            log.info((Object)StringHelper.Format((String)"\u83b7\u53d6\u6a21\u677fGit\u4ed3\u5e93\u8fd4\u56de\u4fe1\u606f\r\n[\u6210\u529f\u4fe1\u606f]\r\n%1$s\r\n[\u5931\u8d25\u4fe1\u606f]\r\n%2$s\r\n", (Object)result.getInfo(), (Object)result.getErrorInfo()));
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getResourceUrl())) {
            String strLocalFolder = String.valueOf(this.rootFolder.getAbsolutePath()) + "#RES";
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.Format((String)"python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getResourceUrl(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword) : StringHelper.Format((String)"cmd.exe /c python %1$s%2$spyutils%2$sgit_pull.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.getResourceUrl(), (Object)strLocalFolder, (Object)strGitUser, (Object)strGitPassword);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            log.info((Object)StringHelper.Format((String)"\u83b7\u53d6\u8d44\u6e90Git\u4ed3\u5e93\u8fd4\u56de\u4fe1\u606f\r\n[\u6210\u529f\u4fe1\u606f]\r\n%1$s\r\n[\u5931\u8d25\u4fe1\u606f]\r\n%2$s\r\n", (Object)result.getInfo(), (Object)result.getErrorInfo()));
            String[] items = this.getResourceUrl().split("[*]");
            if (items.length == 3) {
                this.resRootFolder = new File(String.valueOf(strLocalFolder) + File.separator + items[2]);
            } else {
                File resFolder = new File(strLocalFolder);
                File[] files = resFolder.listFiles();
                if (files != null) {
                    int i = 0;
                    while (i < files.length) {
                        File file = files[i];
                        if (file.isDirectory()) {
                            this.resRootFolder = file;
                            break;
                        }
                        ++i;
                    }
                }
            }
        }
    }

    protected void onPreparePSPFCodeFolders() throws Exception {
        String strFolderName;
        Object file;
        this.psPFCodeFolderList.clear();
        this.psPFCodeFolderMap.clear();
        this.psPFPubCodeMap.clear();
        Vector<PSPFCodeFolder> psPFCodeFolderList = new Vector<PSPFCodeFolder>();
        File templFolder = new File(this.getRealLocalPath());
        File[] files = templFolder.listFiles();
        int i = 0;
        while (i < files.length) {
            file = files[i];
            if (((File)file).isDirectory() && (strFolderName = ((File)file).getName()).indexOf("@") != 0) {
                PSPFCodeFolder psPFCodeFolder = new PSPFCodeFolder();
                psPFCodeFolder.setFOLDERNAME(strFolderName);
                psPFCodeFolder.setPSPFCODEFOLDERNAME(strFolderName);
                psPFCodeFolder.setPSPFCODEFOLDERID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strFolderName));
                psPFCodeFolder.setPRJFOLDER(strFolderName);
                psPFCodeFolder.setPRJTYPE("APP_PUB");
                psPFCodeFolderList.add(psPFCodeFolder);
            }
            ++i;
        }
        for (PSPFCodeFolder psPFCodeFolder : psPFCodeFolderList) {
            PSPFCodeFolder2Impl iPSPFCodeFolder = new PSPFCodeFolder2Impl();
            iPSPFCodeFolder.init(this.getDAGlobalHelper(), this, psPFCodeFolder);
            this.psPFCodeFolderList.add(iPSPFCodeFolder);
            this.psPFCodeFolderMap.put(iPSPFCodeFolder.getId(), iPSPFCodeFolder);
            File folder = new File(String.valueOf(this.rootFolder.getCanonicalPath()) + File.separator + iPSPFCodeFolder.getFolderName());
            this.onPreparePSPFTempls(folder, "", iPSPFCodeFolder);
        }
        i = 0;
        while (i < files.length) {
            file = files[i];
            if (((File)file).isDirectory() && (strFolderName = ((File)file).getName()).indexOf("@") == 0) {
                String strFolderName2;
                File ctrl;
                int j;
                File[] ctrls;
                if (StringHelper.Compare((String)strFolderName, (String)"@CONTROL", (boolean)true) == 0) {
                    ctrls = ((File)file).listFiles();
                    j = 0;
                    while (j < ctrls.length) {
                        ctrl = ctrls[j];
                        if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") != 0) {
                            this.onPreparePSPFCtrlTempls(ctrl);
                        }
                        ++j;
                    }
                } else if (StringHelper.Compare((String)strFolderName, (String)"@EDITOR", (boolean)true) == 0) {
                    ctrls = ((File)file).listFiles();
                    j = 0;
                    while (j < ctrls.length) {
                        ctrl = ctrls[j];
                        if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") != 0) {
                            this.onPreparePSPFEditorTempls(ctrl);
                        }
                        ++j;
                    }
                } else if (StringHelper.Compare((String)strFolderName, (String)"@LOGIC", (boolean)true) == 0) {
                    ctrls = ((File)file).listFiles();
                    j = 0;
                    while (j < ctrls.length) {
                        ctrl = ctrls[j];
                        if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") == 0) {
                            this.onPreparePSPFLogicTempls(ctrl);
                        }
                        ++j;
                    }
                }
            }
            ++i;
        }
    }

    protected void onPreparePSPFLogicTempls(File logics) throws Exception {
        String strLogicCat = logics.getName().substring(1);
        File[] ctrls = logics.listFiles();
        int j = 0;
        while (j < ctrls.length) {
            String strFolderName2;
            File ctrl = ctrls[j];
            if (ctrl.isDirectory() && (strFolderName2 = ctrl.getName()).indexOf("@") != 0) {
                this.onPreparePSPFLogicTempls(strLogicCat, ctrl);
            }
            ++j;
        }
    }

    protected void onPreparePSPFLogicTempls(String strLogicCat, File logic) throws Exception {
        File[] files;
        strLogicCat = strLogicCat.toUpperCase();
        String strLogicType = logic.getName().toUpperCase();
        Properties templProperties = null;
        File propertiesFile = new File(String.valueOf(logic.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            templProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        if (!StringHelper.IsNullOrEmpty((String)(strLogicType = PropertiesHelper.getProperty((Properties)templProperties, (String)"LOGICTYPE", (String)strLogicType)))) {
            strLogicType = strLogicType.trim();
        }
        strLogicType = strLogicType.toUpperCase();
        File[] fileArray = files = logic.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFileName = file.getName();
            if (strFileName.indexOf("@") != 0) {
                String strSuffix;
                int nPos;
                if (file.isDirectory()) {
                    this.onPreparePSPFLogicTempls(strLogicCat, file);
                } else if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file.getCanonicalFile(), this.rootFolder);
                    String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                    PSPFPubCode psPFPubCode = new PSPFPubCode();
                    psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"NONE", (String)strFileName.toUpperCase()));
                    IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(psPFPubCode.getPSPFPUBCODEID());
                    if (iPSPFPubCode == null) {
                        psPFPubCode.setPSPFPUBCODENAME(strFileName);
                        psPFPubCode.setPSPFCODEFOLDERID("");
                        psPFPubCode.setPSPFCODEFOLDERNAME("");
                        psPFPubCode.setTARGETTYPE("NONE");
                        PSPFPubCode2Impl psPFPubCode2Impl = new PSPFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, null, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        iPSPFPubCode = psPFPubCode2Impl;
                    }
                    PSPFViewLogicTempl psPFViewLogicTempl = new PSPFViewLogicTempl();
                    psPFViewLogicTempl.setPSPFVLTEMPLID(Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strLogicCat, (String)strLogicType, (String)iPSPFPubCode.getId()));
                    psPFViewLogicTempl.setPSPFVLTEMPLNAME(StringHelper.Format((String)"@LOGIC/@%1$s/%2$s", (Object)strLogicCat, (Object)strLogicType));
                    psPFViewLogicTempl.setPSPFID(this.getPSPF().getId());
                    psPFViewLogicTempl.setPSPFNAME(this.getPSPF().getName());
                    psPFViewLogicTempl.setPSPFSTYLEID(this.getId());
                    psPFViewLogicTempl.setPSPFSTYLENAME(this.getName());
                    psPFViewLogicTempl.setPSPFPUBCODEID(iPSPFPubCode.getId());
                    psPFViewLogicTempl.setPSPFPUBCODENAME(iPSPFPubCode.getName());
                    psPFViewLogicTempl.setTEMPLCODE(strContent);
                    String strTemplFilePath = file.getCanonicalPath();
                    String strRootFilePath = this.rootFolder.getCanonicalPath();
                    if (strTemplFilePath.indexOf(strRootFilePath) == 0) {
                        psPFViewLogicTempl.setTEMPLFILEPATH(strTemplFilePath.substring(strRootFilePath.length()));
                    }
                    psPFViewLogicTempl.setTEMPLCODE2(strTemplFilePath);
                    PSPFViewLogicTempl2Impl psPFViewLogicTempl2Impl = new PSPFViewLogicTempl2Impl();
                    psPFViewLogicTempl2Impl.init(this.getDAGlobalHelper(), (IPSPFPubCode2)iPSPFPubCode, psPFViewLogicTempl);
                    IPSPFViewLogicTempl2 lastPSPFViewLogicTempl2 = this.psPFViewLogicTemplMap2.get(psPFViewLogicTempl2Impl.getId());
                    if (lastPSPFViewLogicTempl2 != null) {
                        throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5b9a\u4e49\u5185\u5bb9\u5df2\u5728\u6a21\u677f[%2$s]\u4e2d\u5b9a\u4e49\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)psPFViewLogicTempl2Impl.getTemplFilePath(), (Object)lastPSPFViewLogicTempl2.getTemplFilePath()));
                    }
                    this.psPFViewLogicTemplMap2.put(psPFViewLogicTempl2Impl.getId(), psPFViewLogicTempl2Impl);
                }
            }
            ++n2;
        }
    }

    protected void onPreparePSPFCtrlTempls(File ctrl) throws Exception {
        File[] files;
        String strControlType = ctrl.getName().toUpperCase();
        Properties templProperties = null;
        File propertiesFile = new File(String.valueOf(ctrl.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            templProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        if (!StringHelper.IsNullOrEmpty((String)(strControlType = PropertiesHelper.getProperty((Properties)templProperties, (String)"CTRLTYPE", (String)strControlType)))) {
            strControlType = strControlType.trim();
        }
        String strPSCtrlTypeId = strControlType = strControlType.toUpperCase();
        if (strControlType.indexOf("#") != -1) {
            strPSCtrlTypeId = strControlType.split("[#]")[0];
        }
        File[] fileArray = files = ctrl.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFileName = file.getName();
            if (strFileName.indexOf("@") != 0) {
                String strSuffix;
                int nPos;
                if (file.isDirectory()) {
                    this.onPreparePSPFCtrlTempls(file);
                } else if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    String strRootFilePath;
                    String strTemplFilePath;
                    Properties macroParams2;
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file.getCanonicalFile(), this.rootFolder);
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    String strPubObj = null;
                    if (!StringHelper.IsNullOrEmpty((String)strTemplate) && !StringHelper.IsNullOrEmpty((String)(strPubObj = PropertiesHelper.getProperty((Properties)(macroParams2 = PropertiesHelper.load((String)strTemplate)), (String)"PUBOBJ", strPubObj)))) {
                        strPubObj = "SA.SRFDA.PS.Core.Pub." + strPubObj + "PublisherImpl";
                    }
                    String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                    PSPFPubCode psPFPubCode = new PSPFPubCode();
                    psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"VIEW", (String)strFileName.toUpperCase()));
                    IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(psPFPubCode.getPSPFPUBCODEID());
                    if (iPSPFPubCode == null) {
                        psPFPubCode.setPSPFPUBCODENAME(strFileName);
                        psPFPubCode.setPSPFCODEFOLDERID("");
                        psPFPubCode.setPSPFCODEFOLDERNAME("");
                        psPFPubCode.setTARGETTYPE("NONE");
                        PSPFPubCode2Impl psPFPubCode2Impl = new PSPFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, null, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        iPSPFPubCode = psPFPubCode2Impl;
                    }
                    PSPFCtrlTempl psPFCtrlTempl = new PSPFCtrlTempl();
                    psPFCtrlTempl.setPSPFCTRLTEMPLID(Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strControlType, (String)iPSPFPubCode.getId()));
                    psPFCtrlTempl.setPSPFCTRLTEMPLNAME("@CONTROL/" + strControlType);
                    psPFCtrlTempl.setPSCTRLTYPEID(strPSCtrlTypeId);
                    psPFCtrlTempl.setPSCTRLTYPENAME(strControlType);
                    psPFCtrlTempl.setPSPFID(this.getPSPF().getId());
                    psPFCtrlTempl.setPSPFNAME(this.getPSPF().getName());
                    psPFCtrlTempl.setPSPFSTYLEID(this.getId());
                    psPFCtrlTempl.setPSPFSTYLENAME(this.getName());
                    psPFCtrlTempl.setPSPFPUBCODEID(iPSPFPubCode.getId());
                    psPFCtrlTempl.setPSPFPUBCODENAME(iPSPFPubCode.getName());
                    psPFCtrlTempl.setTEMPLCODE(strContent);
                    if (!StringHelper.IsNullOrEmpty((String)strPubObj)) {
                        psPFCtrlTempl.setPUBOBJ(strPubObj);
                    }
                    if ((strTemplFilePath = file.getCanonicalPath()).indexOf(strRootFilePath = this.rootFolder.getCanonicalPath()) == 0) {
                        psPFCtrlTempl.setTEMPLFILEPATH(strTemplFilePath.substring(strRootFilePath.length()));
                    }
                    psPFCtrlTempl.setTEMPLCODE2(strTemplFilePath);
                    try {
                        PSPFCtrlTempl2Impl psPFCtrlTempl2Impl = new PSPFCtrlTempl2Impl();
                        psPFCtrlTempl2Impl.init(this.getDAGlobalHelper(), this.getPSPF(), this, iPSPFPubCode, psPFCtrlTempl);
                        IPSPFCtrlTempl2 lastPSPFCtrlTempl2 = this.psPFCtrlTemplMap2.get(psPFCtrlTempl2Impl.getId());
                        if (lastPSPFCtrlTempl2 != null) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5b9a\u4e49\u5185\u5bb9\u5df2\u5728\u6a21\u677f[%2$s]\u4e2d\u5b9a\u4e49\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)psPFCtrlTempl2Impl.getTemplFilePath(), (Object)lastPSPFCtrlTempl2.getTemplFilePath()));
                        }
                        this.psPFCtrlTemplMap2.put(psPFCtrlTempl2Impl.getId(), psPFCtrlTempl2Impl);
                    }
                    catch (Exception ex) {
                        throw new Exception(StringHelper.Format((String)"\u52a0\u8f7d\u90e8\u4ef6\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                    }
                }
            }
            ++n2;
        }
    }

    protected void onPreparePSPFEditorTempls(File ctrl) throws Exception {
        File[] files;
        String strEditorType = ctrl.getName().toUpperCase();
        Properties templProperties = null;
        File propertiesFile = new File(String.valueOf(ctrl.getCanonicalPath()) + File.separator + "template.properties");
        if (propertiesFile.exists()) {
            templProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
        }
        if (!StringHelper.IsNullOrEmpty((String)(strEditorType = PropertiesHelper.getProperty((Properties)templProperties, (String)"EDITORTYPE", (String)strEditorType)))) {
            strEditorType = strEditorType.trim();
        }
        String strPSEditorTypeId = strEditorType = strEditorType.toUpperCase();
        if (strEditorType.indexOf("#") != -1) {
            strPSEditorTypeId = strEditorType.split("[#]")[0];
        }
        File[] fileArray = files = ctrl.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFileName = file.getName();
            if (strFileName.indexOf("@") != 0) {
                String strSuffix;
                int nPos;
                if (file.isDirectory()) {
                    this.onPreparePSPFEditorTempls(file);
                } else if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    String strRootFilePath;
                    String strTemplFilePath;
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file.getCanonicalFile(), this.rootFolder);
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    String strPubObj = null;
                    String strContainerType = null;
                    if (!StringHelper.IsNullOrEmpty((String)strTemplate)) {
                        Properties macroParams2 = PropertiesHelper.load((String)strTemplate);
                        strPubObj = PropertiesHelper.getProperty((Properties)macroParams2, (String)"PUBOBJ", strPubObj);
                        if (!StringHelper.IsNullOrEmpty((String)strPubObj)) {
                            strPubObj = "SA.SRFDA.PS.Core.Pub." + strPubObj + "PublisherImpl";
                        }
                        strContainerType = PropertiesHelper.getProperty((Properties)macroParams2, (String)"CONTAINER", strContainerType);
                    }
                    String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                    PSPFPubCode psPFPubCode = new PSPFPubCode();
                    psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"VIEW", (String)strFileName.toUpperCase()));
                    IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(psPFPubCode.getPSPFPUBCODEID());
                    if (iPSPFPubCode == null) {
                        psPFPubCode.setPSPFPUBCODENAME(strFileName);
                        psPFPubCode.setPSPFCODEFOLDERID("");
                        psPFPubCode.setPSPFCODEFOLDERNAME("");
                        psPFPubCode.setTARGETTYPE("NONE");
                        PSPFPubCode2Impl psPFPubCode2Impl = new PSPFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, null, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        iPSPFPubCode = psPFPubCode2Impl;
                    }
                    PSPFEditorTempl psPFEditorTempl = new PSPFEditorTempl();
                    if (StringHelper.IsNullOrEmpty((String)strContainerType)) {
                        psPFEditorTempl.setPSPFEDITORTEMPLID(Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strEditorType, (String)iPSPFPubCode.getId()));
                    } else {
                        psPFEditorTempl.setPSPFEDITORTEMPLID(Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strEditorType, (String)strContainerType, (String)iPSPFPubCode.getId()));
                    }
                    psPFEditorTempl.setPSEDITORTYPENAME("@EDITOR/" + strEditorType);
                    psPFEditorTempl.setPSEDITORTYPEID(strPSEditorTypeId);
                    psPFEditorTempl.setPSEDITORTYPENAME(strEditorType);
                    psPFEditorTempl.setPSPFID(this.getPSPF().getId());
                    psPFEditorTempl.setPSPFNAME(this.getPSPF().getName());
                    psPFEditorTempl.setPSPFSTYLEID(this.getId());
                    psPFEditorTempl.setPSPFSTYLENAME(this.getName());
                    psPFEditorTempl.setPSPFPUBCODEID(iPSPFPubCode.getId());
                    psPFEditorTempl.setPSPFPUBCODENAME(iPSPFPubCode.getName());
                    psPFEditorTempl.setTEMPLCODE(strContent);
                    if (!StringHelper.IsNullOrEmpty((String)strPubObj)) {
                        psPFEditorTempl.setPUBOBJ(strPubObj);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strContainerType)) {
                        psPFEditorTempl.setCONTAINERTYPE(strContainerType);
                    }
                    if ((strTemplFilePath = file.getCanonicalPath()).indexOf(strRootFilePath = this.rootFolder.getCanonicalPath()) == 0) {
                        psPFEditorTempl.setTEMPLFILEPATH(strTemplFilePath.substring(strRootFilePath.length()));
                    }
                    psPFEditorTempl.setTEMPLCODE2(strTemplFilePath);
                    try {
                        PSPFEditorTempl2Impl psPFEditorTempl2Impl = new PSPFEditorTempl2Impl();
                        psPFEditorTempl2Impl.init(this.getDAGlobalHelper(), this.getPSPF(), this, iPSPFPubCode, psPFEditorTempl);
                        IPSPFEditorTempl2 lastPSPFEditorTempl2 = this.psPFEditorTemplMap2.get(psPFEditorTempl2Impl.getId());
                        if (lastPSPFEditorTempl2 != null) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5b9a\u4e49\u5185\u5bb9\u5df2\u5728\u6a21\u677f[%2$s]\u4e2d\u5b9a\u4e49\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)psPFEditorTempl2Impl.getTemplFilePath(), (Object)lastPSPFEditorTempl2.getTemplFilePath()));
                        }
                        this.psPFEditorTemplMap2.put(psPFEditorTempl2Impl.getId(), psPFEditorTempl2Impl);
                    }
                    catch (Exception ex) {
                        throw new Exception(StringHelper.Format((String)"\u52a0\u8f7d\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                    }
                }
            }
            ++n2;
        }
    }

    protected void onPreparePSPFTempls(File folder, String strFilePath2, IPSPFCodeFolder2 iPSPFCodeFolder) throws Exception {
        File[] files;
        File[] fileArray = files = folder.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFilePath = strFilePath2;
            if (file.isDirectory()) {
                String strFolderName = file.getName();
                this.onPreparePSPFTempls(file, String.valueOf(strFilePath) + File.separator + strFolderName, iPSPFCodeFolder);
            } else {
                String strSuffix;
                int nPos;
                String strFileName = file.getName();
                if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    String strPSPFAppTemplId;
                    PSPFAppTempl psPFAppTempl;
                    String strContent;
                    PSPFPubCode2Impl psPFPubCode2Impl;
                    String strFileCodeType;
                    IPSPFPubObj iPSPFPubObj;
                    PSPFPubCode2Impl psPFPubCode2Impl2;
                    PSPFPubCode psPFPubCode;
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file, this.rootFolder);
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    Properties macroParams = null;
                    if (!StringHelper.IsNullOrEmpty((String)strTemplate)) {
                        macroParams = PropertiesHelper.load((String)strTemplate);
                    }
                    String templFileName = file.getCanonicalPath().substring(this.rootFolder.getCanonicalPath().length());
                    String strTarget = PropertiesHelper.getProperty((Properties)macroParams, (String)"TARGET", (String)"");
                    if (StringHelper.IsNullOrEmpty((String)strTarget)) {
                        throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u6ca1\u6709\u6307\u5b9a\u53d1\u5e03\u6a21\u578b", (Object)templFileName));
                    }
                    String strPubObj = PropertiesHelper.getProperty((Properties)macroParams, (String)"PUBOBJ", (String)"");
                    if (!StringHelper.IsNullOrEmpty((String)strPubObj)) {
                        strPubObj = "SA.SRFDA.PS.Core.Pub." + strPubObj + "PublisherImpl";
                    }
                    strFileName = PropertiesHelper.getProperty((Properties)macroParams, (String)"FILENAME", (String)strFileName);
                    if (StringHelper.Compare((String)strTarget, (String)"PSAPPVIEW", (boolean)true) == 0) {
                        String strTemplPath = PropertiesHelper.getProperty((Properties)macroParams, (String)"TEMPLFILE", (String)"");
                        if (StringHelper.IsNullOrEmpty((String)strTemplPath)) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u6a21\u677f\u6587\u4ef6", (Object)templFileName));
                        }
                        baseDataEntity.set("FILENAME", (Object)strFileName);
                        baseDataEntity.set("CODEPATH", (Object)strFilePath);
                        IPSPFPubObj appViewPSPFPubObj = this.getPSPF().getPSPFPubObjByTarget("PSAPPVIEW", true);
                        if (appViewPSPFPubObj == null) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u53d1\u5e03\u6a21\u578b[%2$s]\u65e0\u6cd5\u8bc6\u522b", (Object)templFileName, (Object)strTarget));
                        }
                        psPFPubCode = new PSPFPubCode();
                        psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"VIEW", (String)strTemplPath.toUpperCase()));
                        IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(psPFPubCode.getPSPFPUBCODEID());
                        if (iPSPFPubCode == null) {
                            psPFPubCode.setPSPFPUBCODENAME(strTemplPath);
                            psPFPubCode.setPSPFCODEFOLDERID(iPSPFCodeFolder.getId());
                            psPFPubCode.setPSPFCODEFOLDERNAME(iPSPFCodeFolder.getName());
                            psPFPubCode.setTARGETTYPE("VIEW");
                            psPFPubCode2Impl2 = new PSPFPubCode2Impl();
                            psPFPubCode2Impl2.init(this.getDAGlobalHelper(), this, iPSPFCodeFolder, psPFPubCode);
                            this.psPFPubCodeMap.put(psPFPubCode2Impl2.getId(), psPFPubCode2Impl2);
                            iPSPFPubCode = psPFPubCode2Impl2;
                        }
                        this.onPreparePSPFViewTempls(baseDataEntity, appViewPSPFPubObj, macroParams, (IPSPFPubCode2)iPSPFPubCode, null);
                    } else if (StringHelper.Compare((String)strTarget, (String)"PSSYSAPP", (boolean)true) == 0) {
                        iPSPFPubObj = this.getPSPF().getPSPFPubObjByTarget(strTarget, true);
                        if (iPSPFPubObj == null) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u53d1\u5e03\u6a21\u578b[%2$s]\u65e0\u6cd5\u8bc6\u522b", (Object)templFileName, (Object)strTarget));
                        }
                        strFileCodeType = strFilePath;
                        if (!StringHelper.IsNullOrEmpty((String)strFileCodeType)) {
                            strFileCodeType = String.valueOf(strFileCodeType) + "/";
                        }
                        strFileCodeType = String.valueOf(strFileCodeType) + strFileName;
                        if (strFilePath.indexOf("%") != -1 && macroParams != null) {
                            strFilePath = TemplFileHelper.replaceMacros(strFilePath, macroParams);
                        }
                        if (strFilePath.indexOf("%") != -1 && iPSPFPubObj != null) {
                            strFilePath = iPSPFPubObj.replaceMacros(strFilePath);
                        }
                        if (strFileName.indexOf("%") != -1 && macroParams != null) {
                            strFileName = TemplFileHelper.replaceMacros(strFileName, macroParams);
                        }
                        if (strFileName.indexOf("%") != -1 && iPSPFPubObj != null) {
                            strFileName = iPSPFPubObj.replaceMacros(strFileName);
                        }
                        if (strFileName.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u540d\u79f0[%1$s]", (Object)strFileName));
                        }
                        if (strFilePath.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", (Object)strFilePath));
                        }
                        psPFPubCode = new PSPFPubCode();
                        psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"APP", (String)strFileCodeType));
                        psPFPubCode.setPSPFPUBCODENAME(strFileCodeType);
                        psPFPubCode.setPSPFCODEFOLDERID(iPSPFCodeFolder.getId());
                        psPFPubCode.setPSPFCODEFOLDERNAME(iPSPFCodeFolder.getName());
                        psPFPubCode.setTARGETTYPE("APP");
                        psPFPubCode2Impl = new PSPFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, iPSPFCodeFolder, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                        psPFAppTempl = new PSPFAppTempl();
                        strPSPFAppTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)psPFPubCode2Impl.getId());
                        psPFAppTempl.setPSPFAPPTEMPLID(strPSPFAppTemplId);
                        psPFAppTempl.setPSPFAPPTEMPLNAME(strFileCodeType);
                        psPFAppTempl.setTYPECODE(strFileCodeType);
                        psPFAppTempl.setCODEPATH(strFilePath);
                        psPFAppTempl.setFILENAME(strFileName);
                        if (StringHelper.IsNullOrEmpty((String)strPubObj)) {
                            psPFAppTempl.setPUBOBJ(iPSPFPubObj.getPubObj());
                        } else {
                            psPFAppTempl.setPUBOBJ(strPubObj);
                        }
                        psPFAppTempl.setTEMPLCODE(strContent);
                        PSPFAppTempl2Impl psPFAppTempl2Impl = new PSPFAppTempl2Impl();
                        psPFAppTempl2Impl.init(this.getDAGlobalHelper(), this, psPFPubCode2Impl, psPFAppTempl);
                        this.psPFAppTemplMap.put(strPSPFAppTemplId, psPFAppTempl2Impl);
                    } else if (strTarget.indexOf("PSAPPVIEWCTRL_") == 0) {
                        String strNewTarget = "PSAPPVIEWCTRL";
                        String strControlType = strTarget.substring(14);
                        strTarget = strNewTarget;
                        IPSPFPubObj iPSPFPubObj2 = this.getPSPF().getPSPFPubObjByTarget(strTarget, true);
                        if (iPSPFPubObj2 == null) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u53d1\u5e03\u6a21\u578b[%2$s]\u65e0\u6cd5\u8bc6\u522b", (Object)templFileName, (Object)strTarget));
                        }
                        String strFileCodeType2 = strFilePath;
                        if (!StringHelper.IsNullOrEmpty((String)strFileCodeType2)) {
                            strFileCodeType2 = String.valueOf(strFileCodeType2) + "/";
                        }
                        strFileCodeType2 = String.valueOf(strFileCodeType2) + strFileName;
                        if (strFilePath.indexOf("%") != -1 && macroParams != null) {
                            strFilePath = TemplFileHelper.replaceMacros(strFilePath, macroParams);
                        }
                        if (strFilePath.indexOf("%") != -1 && iPSPFPubObj2 != null) {
                            strFilePath = iPSPFPubObj2.replaceMacros(strFilePath);
                        }
                        if (strFileName.indexOf("%") != -1 && macroParams != null) {
                            strFileName = TemplFileHelper.replaceMacros(strFileName, macroParams);
                        }
                        if (strFileName.indexOf("%") != -1 && iPSPFPubObj2 != null) {
                            strFileName = iPSPFPubObj2.replaceMacros(strFileName);
                        }
                        if (strFileName.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u540d\u79f0[%1$s]", (Object)strFileName));
                        }
                        if (strFilePath.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", (Object)strFilePath));
                        }
                        strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                        PSPFPubCode psPFPubCode2 = new PSPFPubCode();
                        psPFPubCode2.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"VIEWCTRL", (String)strFileCodeType2));
                        psPFPubCode2.setPSPFPUBCODENAME(strFileCodeType2);
                        psPFPubCode2.setPSPFCODEFOLDERID(iPSPFCodeFolder.getId());
                        psPFPubCode2.setPSPFCODEFOLDERNAME(iPSPFCodeFolder.getName());
                        psPFPubCode2.setTARGETTYPE("VIEWCTRL");
                        PSPFPubCode2Impl psPFPubCode2Impl3 = new PSPFPubCode2Impl();
                        psPFPubCode2Impl3.init(this.getDAGlobalHelper(), this, iPSPFCodeFolder, psPFPubCode2);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl3.getId(), psPFPubCode2Impl3);
                        PSPFCtrlTempl psPFCtrlTempl = new PSPFCtrlTempl();
                        psPFCtrlTempl.setPSPFCTRLTEMPLID(Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strControlType, (String)psPFPubCode2Impl3.getId()));
                        psPFCtrlTempl.setPSPFCTRLTEMPLNAME(strControlType);
                        psPFCtrlTempl.setPSCTRLTYPEID(strControlType);
                        psPFCtrlTempl.setPSPFID(this.getPSPF().getId());
                        psPFCtrlTempl.setPSPFNAME(this.getPSPF().getName());
                        psPFCtrlTempl.setPSPFSTYLEID(this.getId());
                        psPFCtrlTempl.setPSPFSTYLENAME(this.getName());
                        psPFCtrlTempl.setPSPFPUBCODEID(psPFPubCode2Impl3.getId());
                        psPFCtrlTempl.setPSPFPUBCODENAME(psPFPubCode2Impl3.getName());
                        psPFCtrlTempl.setTEMPLCODE(strContent);
                        psPFCtrlTempl.setTEMPLCODE2(file.getCanonicalPath());
                        if (StringHelper.IsNullOrEmpty((String)strPubObj)) {
                            psPFCtrlTempl.setPUBOBJ(iPSPFPubObj2.getPubObj());
                        } else {
                            psPFCtrlTempl.setPUBOBJ(strPubObj);
                        }
                        psPFCtrlTempl.setCODEPATH(strFilePath);
                        psPFCtrlTempl.setFILENAME(strFileName);
                        try {
                            PSPFCtrlTempl2Impl psPFCtrlTempl2Impl = new PSPFCtrlTempl2Impl();
                            psPFCtrlTempl2Impl.init(this.getDAGlobalHelper(), this.getPSPF(), this, psPFPubCode2Impl3, psPFCtrlTempl);
                            ArrayList<IPSPFCtrlTempl> list = this.psPFCtrlTemplMap.get(strControlType);
                            if (list == null) {
                                list = new ArrayList();
                                this.psPFCtrlTemplMap.put(strControlType, list);
                            }
                            list.add(psPFCtrlTempl2Impl);
                            this.psPFCtrlTemplMap2.put(psPFCtrlTempl2Impl.getId(), psPFCtrlTempl2Impl);
                        }
                        catch (Exception ex) {
                            throw new Exception(StringHelper.Format((String)"\u52a0\u8f7d\u90e8\u4ef6\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                        }
                    } else if (StringHelper.Compare((String)strTarget, (String)"PSAPPDATAENTITY", (boolean)true) == 0 || StringHelper.Compare((String)strTarget, (String)"PSAPPWF", (boolean)true) == 0 || StringHelper.Compare((String)strTarget, (String)"PSAPPWFVER", (boolean)true) == 0) {
                        iPSPFPubObj = this.getPSPF().getPSPFPubObjByTarget(strTarget, true);
                        if (iPSPFPubObj == null) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u53d1\u5e03\u6a21\u578b[%2$s]\u65e0\u6cd5\u8bc6\u522b", (Object)templFileName, (Object)strTarget));
                        }
                        strFileCodeType = strFilePath;
                        if (!StringHelper.IsNullOrEmpty((String)strFileCodeType)) {
                            strFileCodeType = String.valueOf(strFileCodeType) + "/";
                        }
                        strFileCodeType = String.valueOf(strFileCodeType) + strFileName;
                        if (strFilePath.indexOf("%") != -1 && macroParams != null) {
                            strFilePath = TemplFileHelper.replaceMacros(strFilePath, macroParams);
                        }
                        if (strFilePath.indexOf("%") != -1 && iPSPFPubObj != null) {
                            strFilePath = iPSPFPubObj.replaceMacros(strFilePath);
                        }
                        if (strFileName.indexOf("%") != -1 && macroParams != null) {
                            strFileName = TemplFileHelper.replaceMacros(strFileName, macroParams);
                        }
                        if (strFileName.indexOf("%") != -1 && iPSPFPubObj != null) {
                            strFileName = iPSPFPubObj.replaceMacros(strFileName);
                        }
                        if (strFileName.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u540d\u79f0[%1$s]", (Object)strFileName));
                        }
                        if (strFilePath.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", (Object)strFilePath));
                        }
                        psPFPubCode = new PSPFPubCode();
                        if (StringHelper.Compare((String)strTarget, (String)"PSAPPDATAENTITY", (boolean)true) == 0) {
                            psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"DATAENTITY", (String)strFileCodeType));
                            psPFPubCode.setTARGETTYPE("DATAENTITY");
                        } else if (StringHelper.Compare((String)strTarget, (String)"PSAPPWF", (boolean)true) == 0) {
                            psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"WF", (String)strFileCodeType));
                            psPFPubCode.setTARGETTYPE("WF");
                        } else if (StringHelper.Compare((String)strTarget, (String)"PSAPPWFVER", (boolean)true) == 0) {
                            psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"WFVER", (String)strFileCodeType));
                            psPFPubCode.setTARGETTYPE("WFVER");
                        }
                        psPFPubCode.setPSPFPUBCODENAME(strFileCodeType);
                        psPFPubCode.setPSPFCODEFOLDERID(iPSPFCodeFolder.getId());
                        psPFPubCode.setPSPFCODEFOLDERNAME(iPSPFCodeFolder.getName());
                        psPFPubCode2Impl = new PSPFPubCode2Impl();
                        psPFPubCode2Impl.init(this.getDAGlobalHelper(), this, iPSPFCodeFolder, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl.getId(), psPFPubCode2Impl);
                        strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                        psPFAppTempl = new PSPFAppTempl();
                        strPSPFAppTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)psPFPubCode2Impl.getId());
                        psPFAppTempl.setPSPFAPPTEMPLID(strPSPFAppTemplId);
                        psPFAppTempl.setPSPFAPPTEMPLNAME(strFileCodeType);
                        psPFAppTempl.setTYPECODE(strFileCodeType);
                        psPFAppTempl.setCODEPATH(strFilePath);
                        psPFAppTempl.setFILENAME(strFileName);
                        if (StringHelper.IsNullOrEmpty((String)strPubObj)) {
                            psPFAppTempl.setPUBOBJ(iPSPFPubObj.getPubObj());
                        } else {
                            psPFAppTempl.setPUBOBJ(strPubObj);
                        }
                        psPFAppTempl.setTEMPLCODE(strContent);
                        if (StringHelper.Compare((String)strTarget, (String)"PSAPPDATAENTITY", (boolean)true) == 0) {
                            PSPFAppDataEntityTemplImpl psPFAppDataEntityTemplImpl = new PSPFAppDataEntityTemplImpl();
                            psPFAppDataEntityTemplImpl.init(this.getDAGlobalHelper(), this, psPFPubCode2Impl, psPFAppTempl);
                            this.psPFAppDataEntityTemplMap.put(strPSPFAppTemplId, psPFAppDataEntityTemplImpl);
                        } else if (StringHelper.Compare((String)strTarget, (String)"PSAPPWF", (boolean)true) == 0) {
                            PSPFAppWFTemplImpl psPFAppWFTemplImpl = new PSPFAppWFTemplImpl();
                            psPFAppWFTemplImpl.init(this.getDAGlobalHelper(), this, psPFPubCode2Impl, psPFAppTempl);
                            this.psPFAppWFTemplMap.put(strPSPFAppTemplId, psPFAppWFTemplImpl);
                        } else if (StringHelper.Compare((String)strTarget, (String)"PSAPPWFVER", (boolean)true) == 0) {
                            PSPFAppWFVerTemplImpl psPFAppWFVerTemplImpl = new PSPFAppWFVerTemplImpl();
                            psPFAppWFVerTemplImpl.init(this.getDAGlobalHelper(), this, psPFPubCode2Impl, psPFAppTempl);
                            this.psPFAppWFVerTemplMap.put(strPSPFAppTemplId, psPFAppWFVerTemplImpl);
                        }
                    } else if (TARGETTYPEMAP.containsKey(strTarget)) {
                        iPSPFPubObj = this.getPSPF().getPSPFPubObjByTarget(strTarget, true);
                        if (iPSPFPubObj == null) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u53d1\u5e03\u6a21\u578b[%2$s]\u65e0\u6cd5\u8bc6\u522b", (Object)templFileName, (Object)strTarget));
                        }
                        strFileCodeType = strFilePath;
                        if (!StringHelper.IsNullOrEmpty((String)strFileCodeType)) {
                            strFileCodeType = String.valueOf(strFileCodeType) + "/";
                        }
                        strFileCodeType = String.valueOf(strFileCodeType) + strFileName;
                        if (strFilePath.indexOf("%") != -1 && macroParams != null) {
                            strFilePath = TemplFileHelper.replaceMacros(strFilePath, macroParams);
                        }
                        if (strFilePath.indexOf("%") != -1 && iPSPFPubObj != null) {
                            strFilePath = iPSPFPubObj.replaceMacros(strFilePath);
                        }
                        if (strFileName.indexOf("%") != -1 && macroParams != null) {
                            strFileName = TemplFileHelper.replaceMacros(strFileName, macroParams);
                        }
                        if (strFileName.indexOf("%") != -1 && iPSPFPubObj != null) {
                            strFileName = iPSPFPubObj.replaceMacros(strFileName);
                        }
                        if (strFileName.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u540d\u79f0[%1$s]", (Object)strFileName));
                        }
                        if (strFilePath.indexOf("%") != -1) {
                            throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", (Object)strFilePath));
                        }
                        psPFPubCode = new PSPFPubCode();
                        String strPubCodeTarget = TARGETTYPEMAP.get(strTarget);
                        psPFPubCode.setPSPFPUBCODEID(KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)strPubCodeTarget, (String)strFileCodeType));
                        psPFPubCode.setTARGETTYPE(strPubCodeTarget);
                        psPFPubCode.setPSPFPUBCODENAME(strFileCodeType);
                        psPFPubCode.setPSPFCODEFOLDERID(iPSPFCodeFolder.getId());
                        psPFPubCode.setPSPFCODEFOLDERNAME(iPSPFCodeFolder.getName());
                        psPFPubCode2Impl2 = new PSPFPubCode2Impl();
                        psPFPubCode2Impl2.init(this.getDAGlobalHelper(), this, iPSPFCodeFolder, psPFPubCode);
                        this.psPFPubCodeMap.put(psPFPubCode2Impl2.getId(), psPFPubCode2Impl2);
                        String strContent2 = baseDataEntity.getParamStringValue("CONTENT", "");
                        PSPFAppTempl psPFAppTempl2 = new PSPFAppTempl();
                        String strPSPFAppTemplId2 = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)psPFPubCode2Impl2.getId());
                        psPFAppTempl2.setPSPFAPPTEMPLID(strPSPFAppTemplId2);
                        psPFAppTempl2.setPSPFAPPTEMPLNAME(strFileCodeType);
                        psPFAppTempl2.setTYPECODE(strFileCodeType);
                        psPFAppTempl2.setCODEPATH(strFilePath);
                        psPFAppTempl2.setFILENAME(strFileName);
                        if (StringHelper.IsNullOrEmpty((String)strPubObj)) {
                            psPFAppTempl2.setPUBOBJ(iPSPFPubObj.getPubObj());
                        } else {
                            psPFAppTempl2.setPUBOBJ(strPubObj);
                        }
                        psPFAppTempl2.setTEMPLCODE(strContent2);
                        HashMap<String, IPSPFAppObjectTempl> map = this.psAppObjectTemplMapMap.get(strTarget);
                        PSPFAppObjectTemplImpl psPFAppObjectTemplImpl = new PSPFAppObjectTemplImpl();
                        psPFAppObjectTemplImpl.init(this.getDAGlobalHelper(), this, psPFPubCode2Impl2, psPFAppTempl2);
                        map.put(strPSPFAppTemplId2, psPFAppObjectTemplImpl);
                    }
                }
            }
            ++n2;
        }
    }

    protected void onPreparePSPFViewTempls(BaseDataEntity appViewEntity, IPSPFPubObj appViewPSPFPubObj, Properties macroParams, IPSPFPubCode2 iPSPFPubCode2, File viewTemplFolder) throws Exception {
        File[] files;
        if (viewTemplFolder == null && !(viewTemplFolder = new File(String.valueOf(this.rootFolder.getCanonicalPath()) + File.separator + "@VIEW")).exists()) {
            return;
        }
        String strTemplPath = PropertiesHelper.getProperty((Properties)macroParams, (String)"TEMPLFILE", (String)"");
        String strContent = appViewEntity.getParamStringValue("CONTENT", "");
        File[] fileArray = files = viewTemplFolder.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            String strFolderName = file.getName();
            if (strFolderName.indexOf("@") != 0 && file.isDirectory()) {
                File templFile = new File(String.valueOf(file.getCanonicalPath()) + File.separator + strTemplPath + ".ftl");
                if (!templFile.exists()) {
                    this.onPreparePSPFViewTempls(appViewEntity, appViewPSPFPubObj, macroParams, iPSPFPubCode2, file);
                } else {
                    String strRootFilePath;
                    String strTemplFilePath;
                    String strFileContent;
                    Properties macroParams2;
                    Properties templProperties = null;
                    File propertiesFile = new File(String.valueOf(file.getCanonicalPath()) + File.separator + "template.properties");
                    if (propertiesFile.exists()) {
                        templProperties = PropertiesHelper.loadFromFile((String)propertiesFile.getCanonicalPath());
                    }
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(templFile, this.rootFolder);
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    String strPubObj = null;
                    if (!StringHelper.IsNullOrEmpty((String)strTemplate) && !StringHelper.IsNullOrEmpty((String)(strPubObj = PropertiesHelper.getProperty((Properties)(macroParams2 = PropertiesHelper.load((String)strTemplate)), (String)"PUBOBJ", strPubObj)))) {
                        strPubObj = "SA.SRFDA.PS.Core.Pub." + strPubObj + "PublisherImpl";
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strFileContent = strContent))) {
                        strFileContent = String.valueOf(strFileContent) + "\r\n";
                    }
                    strFileContent = String.valueOf(strFileContent) + baseDataEntity.getParamStringValue("CONTENT", "");
                    String strFileName = appViewEntity.getParamStringValue("FILENAME", "");
                    String strFilePath = appViewEntity.getParamStringValue("CODEPATH", "");
                    String strFileCodeType = String.valueOf(strFilePath) + "/" + strFileName;
                    String strRealFolderName = PropertiesHelper.getProperty((Properties)templProperties, (String)"VIEWTYPE", (String)strFolderName.toUpperCase());
                    if (!StringHelper.IsNullOrEmpty((String)strRealFolderName)) {
                        strRealFolderName = strRealFolderName.trim();
                    }
                    String strViewStyle = "";
                    if (strRealFolderName.indexOf("#") != -1) {
                        String[] items = strRealFolderName.split("[#]");
                        strRealFolderName = items[0];
                        if (items.length >= 2) {
                            strViewStyle = items[1];
                        }
                    }
                    IPSPFPubObj iPSPFPubObj = this.getPSPF().getPSPFPubObjByTarget("PS" + strRealFolderName.toUpperCase(), true);
                    String strViewType = "";
                    if (iPSPFPubObj != null) {
                        strViewType = iPSPFPubObj.getTag();
                    }
                    if (StringHelper.IsNullOrEmpty((String)strViewType) && (strViewType = REALVIEWTYPEMAP.get(strRealFolderName.toUpperCase())) == null) {
                        strViewType = strRealFolderName.toUpperCase();
                    }
                    if (strFilePath.indexOf("%") != -1 && macroParams != null) {
                        strFilePath = TemplFileHelper.replaceMacros(strFilePath, macroParams);
                    }
                    if (strFilePath.indexOf("%") != -1 && iPSPFPubObj != null) {
                        strFilePath = iPSPFPubObj.replaceMacros(strFilePath);
                    }
                    if (strFilePath.indexOf("%") != -1 && appViewPSPFPubObj != null) {
                        strFilePath = appViewPSPFPubObj.replaceMacros(strFilePath);
                    }
                    if (strFileName.indexOf("%") != -1 && macroParams != null) {
                        strFileName = TemplFileHelper.replaceMacros(strFileName, macroParams);
                    }
                    if (strFileName.indexOf("%") != -1 && iPSPFPubObj != null) {
                        strFileName = iPSPFPubObj.replaceMacros(strFileName);
                    }
                    if (strFileName.indexOf("%") != -1 && appViewPSPFPubObj != null) {
                        strFileName = appViewPSPFPubObj.replaceMacros(strFileName);
                    }
                    if (strFileName.indexOf("%") != -1) {
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u540d\u79f0[%1$s]", (Object)strFileName));
                    }
                    if (strFilePath.indexOf("%") != -1) {
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", (Object)strFilePath));
                    }
                    String strFullViewType = strViewType;
                    if (!StringHelper.IsNullOrEmpty((String)strViewStyle)) {
                        strFullViewType = String.valueOf(strFullViewType) + StringHelper.Format((String)"#%1$s", (Object)strViewStyle);
                    }
                    PSPFViewTempl psPFViewTempl = new PSPFViewTempl();
                    String strPSPFViewTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strFullViewType, (String)iPSPFPubCode2.getId());
                    psPFViewTempl.setPSPFVIEWTEMPLID(strPSPFViewTemplId);
                    psPFViewTempl.setPSPFVIEWTEMPLNAME(strFileCodeType);
                    psPFViewTempl.setTYPECODE(strFileCodeType);
                    psPFViewTempl.setCODEPATH(strFilePath);
                    psPFViewTempl.setFILENAME(strFileName);
                    if (iPSPFPubObj != null) {
                        psPFViewTempl.setPUBOBJ(iPSPFPubObj.getPubObj());
                    } else {
                        psPFViewTempl.setPUBOBJ(appViewPSPFPubObj.getPubObj());
                    }
                    psPFViewTempl.setTEMPLCODE(strFileContent);
                    psPFViewTempl.setPSVIEWTYPEID(strViewType);
                    psPFViewTempl.setPSVIEWTYPENAME(strFullViewType);
                    psPFViewTempl.setVIEWSTYLE(strViewStyle);
                    if (!StringHelper.IsNullOrEmpty((String)strPubObj)) {
                        psPFViewTempl.setPUBOBJ(strPubObj);
                    }
                    if ((strTemplFilePath = templFile.getCanonicalPath()).indexOf(strRootFilePath = this.rootFolder.getCanonicalPath()) == 0) {
                        psPFViewTempl.setTEMPLFILEPATH(strTemplFilePath.substring(strRootFilePath.length()));
                    }
                    try {
                        PSPFViewTempl2Impl psPFViewTempl2Impl = new PSPFViewTempl2Impl();
                        psPFViewTempl2Impl.init(this.getDAGlobalHelper(), this, iPSPFPubCode2, psPFViewTempl);
                        this.registerPSPFViewTempl(psPFViewTempl2Impl);
                    }
                    catch (Exception ex) {
                        throw new Exception(StringHelper.Format((String)"\u52a0\u8f7d\u89c6\u56fe\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                    }
                }
            }
            ++n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSPFPubCodes() throws Exception {
        HashMap<String, ArrayList<IPSPFPubCode>> hashMap = this.psPFPubCodesMap;
        synchronized (hashMap) {
            this.psPFPubCodesMap.clear();
            for (Map.Entry<String, IPSPFPubCode> entry : this.psPFPubCodeMap.entrySet()) {
                ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(entry.getValue().getTargetType());
                if (list == null) {
                    list = new ArrayList();
                    this.psPFPubCodesMap.put(entry.getValue().getTargetType(), list);
                }
                list.add(entry.getValue());
            }
        }
        ArrayList<IPSPFPubCode> psPFPubCodeList = new ArrayList<IPSPFPubCode>();
        psPFPubCodeList.addAll(this.psPFPubCodeMap.values());
        for (IPSPFPubCode iPSPFPubCode : psPFPubCodeList) {
            if (StringHelper.IsNullOrEmpty((String)iPSPFPubCode.getName()) || this.psPFPubCodeMap.containsKey(iPSPFPubCode.getName())) continue;
            this.psPFPubCodeMap.put(iPSPFPubCode.getName(), iPSPFPubCode);
        }
    }

    protected void preparePSPFPkgVers() throws Exception {
        HashMap<String, IPSPFPkgVer> psPFPkgVerMap = new HashMap<String, IPSPFPkgVer>();
        if (this.getTemplPSPFStyle() != null && this.getTemplPSPFStyle().getPSPFPkgVers() != null) {
            Iterator<IPSPFPkgVer> psPFPkgVers = this.getTemplPSPFStyle().getPSPFPkgVers();
            while (psPFPkgVers.hasNext()) {
                IPSPFPkgVer iPSPFPkgVer = psPFPkgVers.next();
                psPFPkgVerMap.put(iPSPFPkgVer.getPSPFPkg().getId(), iPSPFPkgVer);
            }
        }
        Iterator<IPSPFStylePkg> psPFStylePkgs = this.getPSPFStylePkgs();
        while (psPFStylePkgs.hasNext()) {
            IPSPFStylePkg iPSPFStylePkg = psPFStylePkgs.next();
            IPSPFPkgVer iPSPFPkgVer = iPSPFStylePkg.getPSPFPkgVer();
            psPFPkgVerMap.put(iPSPFPkgVer.getPSPFPkg().getId(), iPSPFPkgVer);
        }
        this.psPFPkgVerList.addAll(psPFPkgVerMap.values());
        Collections.sort(this.psPFPkgVerList, new Comparator<IPSPFPkgVer>(){

            @Override
            public int compare(IPSPFPkgVer arg0, IPSPFPkgVer arg1) {
                int nRet = arg0.getOrderValue() - arg1.getOrderValue();
                if (nRet == 0) {
                    return 0;
                }
                if (nRet > 0) {
                    return 1;
                }
                return -1;
            }
        });
    }

    @Override
    public String getStyleCode() {
        return this.psPFStyle.getSTYLECODE();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<IPSPFViewTempl> getPSPFViewTempls(IPSAppView iPSAppView) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)iPSAppView.getViewStyle())) {
            ArrayList<IPSPFViewTempl> list;
            String strFullViewType = StringHelper.Format((String)"%1$s#%2$s", (Object)iPSAppView.getViewType(), (Object)iPSAppView.getViewStyle()).toUpperCase();
            HashMap<String, ArrayList<IPSPFViewTempl>> hashMap = this.psPFViewTemplListMap;
            synchronized (hashMap) {
                list = this.psPFViewTemplListMap.get(strFullViewType);
                if (list != null) {
                    return list.iterator();
                }
            }
            hashMap = this.psPFViewTemplListMap2;
            synchronized (hashMap) {
                list = this.psPFViewTemplListMap2.remove(strFullViewType);
                if (list != null) {
                    HashMap<String, ArrayList<IPSPFViewTempl>> hashMap2 = this.psPFViewTemplListMap;
                    synchronized (hashMap2) {
                        ArrayList<IPSPFViewTempl> list2 = this.psPFViewTemplListMap.get(iPSAppView.getViewType());
                        if (list2 != null) {
                            for (IPSPFViewTempl iPSPFViewTempl2 : list2) {
                                boolean bAdd = true;
                                for (IPSPFViewTempl iPSPFViewTempl : list) {
                                    if (StringHelper.Compare((String)iPSPFViewTempl.getPSPFPubCode().getId(), (String)iPSPFViewTempl2.getPSPFPubCode().getId(), (boolean)true) != 0) continue;
                                    bAdd = false;
                                    break;
                                }
                                if (!bAdd) continue;
                                list.add(iPSPFViewTempl2);
                            }
                        }
                    }
                    this.psPFViewTemplListMap.put(strFullViewType, list);
                    return list.iterator();
                }
            }
        }
        HashMap<String, ArrayList<IPSPFViewTempl>> hashMap = this.psPFViewTemplListMap;
        synchronized (hashMap) {
            ArrayList<IPSPFViewTempl> list = this.psPFViewTemplListMap.get(iPSAppView.getViewType());
            if (list != null) {
                return list.iterator();
            }
            list = new ArrayList();
            this.psPFViewTemplListMap.put(iPSAppView.getViewType(), list);
            return list.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerPSPFViewTempl(IPSPFViewTempl2 iPSPFViewTempl2) throws Exception {
        IPSPFViewTempl2 lastPSPFViewTempl2 = this.psPFViewTemplMap2.get(iPSPFViewTempl2.getId());
        if (lastPSPFViewTempl2 != null) {
            if (StringHelper.Compare((String)iPSPFViewTempl2.getTemplFilePath(), (String)lastPSPFViewTempl2.getTemplFilePath(), (boolean)false) == 0) {
                return;
            }
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5b9a\u4e49\u5185\u5bb9\u5df2\u5728\u6a21\u677f[%2$s]\u4e2d\u5b9a\u4e49\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)iPSPFViewTempl2.getTemplFilePath(), (Object)lastPSPFViewTempl2.getTemplFilePath()));
        }
        this.psPFViewTemplMap2.put(iPSPFViewTempl2.getId(), iPSPFViewTempl2);
        if (!StringHelper.IsNullOrEmpty((String)iPSPFViewTempl2.getViewStyle())) {
            String strFullViewType = StringHelper.Format((String)"%1$s#%2$s", (Object)iPSPFViewTempl2.getViewType(), (Object)iPSPFViewTempl2.getViewStyle());
            HashMap<String, ArrayList<IPSPFViewTempl>> hashMap = this.psPFViewTemplListMap2;
            synchronized (hashMap) {
                ArrayList<IPSPFViewTempl> list = this.psPFViewTemplListMap2.get(strFullViewType);
                if (list == null) {
                    list = new ArrayList();
                    this.psPFViewTemplListMap2.put(strFullViewType, list);
                }
                list.add(iPSPFViewTempl2);
            }
        }
        HashMap<String, ArrayList<IPSPFViewTempl>> hashMap = this.psPFViewTemplListMap;
        synchronized (hashMap) {
            ArrayList<IPSPFViewTempl> list = this.psPFViewTemplListMap.get(iPSPFViewTempl2.getViewType());
            if (list == null) {
                list = new ArrayList();
                this.psPFViewTemplListMap.put(iPSPFViewTempl2.getViewType(), list);
            }
            list.add(iPSPFViewTempl2);
        }
    }

    @Override
    public IPSPFViewTempl getPSPFViewTempl(IPSViewType iPSViewType, IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSPFViewTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSViewType.getId(), (String)iPSPFPubCode.getId());
        IPSPFViewTempl iPSPFViewTempl = this.getPSPFViewTempl(strPSPFViewTemplId, true);
        return iPSPFViewTempl;
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSPFCtrlTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSControlType.getId(), (String)iPSPFPubCode.getId());
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(strPSPFCtrlTemplId, true);
        return iPSPFCtrlTempl;
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode, String strDetailName) throws Exception {
        return this.getPSPFCtrlTemplDetail(iPSControlType, iPSPFPubCode, strDetailName, false);
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode, String strDetailName, boolean bTryMode) throws Exception {
        IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail = null;
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControlType, iPSPFPubCode);
        if (iPSPFCtrlTempl != null && (iPSPFCtrlTemplDetail = iPSPFCtrlTempl.getPSPFCtrlTemplDetail2(strDetailName, true)) != null) {
            return iPSPFCtrlTemplDetail;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%1$s]\u6a21\u677f[%2$s]\u6210\u5458[%3$s]", (Object)iPSControlType.getName(), (Object)iPSPFPubCode.getName(), (Object)strDetailName));
    }

    @Override
    public IPSPFUIActionTempl getPSPFUIActionTempl(IPSUIAction iPSUIAction, IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSPFUIActionTemplId = "";
        IPSDEUIAction iPSDEUIAction = null;
        if (iPSUIAction instanceof IPSDEUIAction) {
            iPSDEUIAction = (IPSDEUIAction)iPSUIAction;
        }
        if (iPSDEUIAction != null) {
            strPSPFUIActionTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSDEUIAction.getPSSysDEUIActionId(null), (String)iPSPFPubCode.getId());
        }
        IPSPFUIActionTempl iPSPFUIActionTempl = this.getPSPFUIActionTempl(strPSPFUIActionTemplId, true);
        return iPSPFUIActionTempl;
    }

    @Override
    public IPSPFViewLogicTempl getPSPFViewLogicTempl(IPSViewLogicType iPSViewLogicType, IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSViewLogicTypeId = null;
        strPSViewLogicTypeId = iPSViewLogicType == null ? "VIEW_DELOGIC" : iPSViewLogicType.getId();
        String strPSPFViewLogicTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strPSViewLogicTypeId, (String)iPSPFPubCode.getId());
        IPSPFViewLogicTempl iPSPFViewLogicTempl = this.getPSPFViewLogicTempl(strPSPFViewLogicTemplId, true);
        return iPSPFViewLogicTempl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<IPSPFAppTempl> getPSPFAppTempls(IPSApplication iPSApplication) throws Exception {
        HashMap<String, IPSPFAppTempl> hashMap = this.psPFAppTemplMap;
        synchronized (hashMap) {
            return this.psPFAppTemplMap.values().iterator();
        }
    }

    @Override
    public IPSPFAppTempl getPSPFAppTempl(IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSPFAppTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSPFPubCode.getId());
        IPSPFAppTempl iPSPFAppTempl = this.getPSPFAppTempl(strPSPFAppTemplId, true);
        return iPSPFAppTempl;
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType iPSEditorType, String strContainerType, IPSPFPubCode iPSPFPubCode) throws Exception {
        String strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getId(), (String)strContainerType, (String)iPSPFPubCode.getId());
        IPSPFEditorTempl iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId, true);
        if (iPSPFEditorTempl != null) {
            return iPSPFEditorTempl;
        }
        strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getId(), (String)iPSPFPubCode.getId());
        iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId, true);
        if (iPSPFEditorTempl != null) {
            return iPSPFEditorTempl;
        }
        if (!iPSEditorType.isStandardEditor() && !StringHelper.IsNullOrEmpty((String)iPSEditorType.getStandardPSEditorType())) {
            strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getStandardPSEditorType(), (String)strContainerType, (String)iPSPFPubCode.getId());
            iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId, true);
            if (iPSPFEditorTempl != null) {
                return iPSPFEditorTempl;
            }
            strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSEditorType.getStandardPSEditorType(), (String)iPSPFPubCode.getId());
            iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId, true);
            if (iPSPFEditorTempl != null) {
                return iPSPFEditorTempl;
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f16\u8f91\u5668[%1$s]\u53d1\u5e03\u4ee3\u7801[%2$s][%3$s]\u6a21\u677f", (Object)iPSEditorType.getId(), (Object)strContainerType, (Object)iPSPFPubCode.getName()));
    }

    @Override
    public IPSPFStyleCode getPSPFStyleCode(String strPSPFStyleCodeId, boolean bTryMode) throws Exception {
        return (IPSPFStyleCode)this.psPFStyleCodeGlobalModel.FindModelHelper(strPSPFStyleCodeId, bTryMode);
    }

    @Override
    public Iterator<IPSPFStyleCode> getPSPFStyleCodes() throws Exception {
        return this.psPFStyleCodeGlobalModel.getAllModelHelpers();
    }

    @Override
    public String replacePFStyleCode(String strCode) throws Exception {
        int i = 0;
        while (i < 10) {
            boolean bChanged = false;
            Iterator<IPSPFStyleCode> psPFStyleCodes = this.getPSPFStyleCodes();
            while (psPFStyleCodes.hasNext()) {
                IPSPFStyleCode iPSPFStyleCode = psPFStyleCodes.next();
                String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)iPSPFStyleCode.getName().toUpperCase());
                if (strCode.indexOf(strTag) == -1) continue;
                strCode = strCode.replace(strTag, iPSPFStyleCode.getStyleCode());
                bChanged = true;
            }
            if (!bChanged) break;
            ++i;
        }
        return strCode;
    }

    @Override
    public String getPFStyleParams() {
        return this.psPFStyle.getPFSTYLEPARAM();
    }

    @Override
    public IPSPFViewTempl getPSPFViewTempl(String strPFViewTemplId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSPFViewTempl getPSPFViewTempl(String strPFViewTemplId, boolean bTryMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void resetPSPFViewTempl(String strPFViewTemplId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u6837\u5f0f", hideempty=true)
    public IPSPFStyle getTemplPSPFStyle() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.strTemplPSPFStyleId)) {
            return null;
        }
        if (this.templPSPFStyle != null) {
            return this.templPSPFStyle;
        }
        boolean bClose = false;
        try {
            ActionSession actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSPFStyleImpl");
                actionSession.registerRecursion("PSPFSTYLE", (Object)this.getId());
            } else if (!actionSession.registerRecursion("PSPFSTYLE", (Object)this.getId())) {
                throw new Exception(StringHelper.Format((String)"\u524d\u7aef\u5e94\u7528\u6846\u67b6[%1$s]\u6837\u5f0f[%2$s]\u6a21\u677f\u6837\u5f0f\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getPSPF().getName(), (Object)this.getName()));
            }
            this.templPSPFStyle = this.getPSPF().getPSPFStyle(this.strTemplPSPFStyleId);
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            return this.templPSPFStyle;
        }
        catch (Exception ex) {
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasPSPFCtrlTempls(IPSControl iPSControl) throws Exception {
        HashMap<String, ArrayList<IPSPFCtrlTempl>> hashMap = this.psPFCtrlTemplMap;
        synchronized (hashMap) {
            ArrayList<IPSPFCtrlTempl> list = this.psPFCtrlTemplMap.get(iPSControl.getPSControlType().getId());
            if (list != null) {
                return list.size() > 0;
            }
            list = new ArrayList();
            Iterator<IPSPFPubCode> psPFPubCodes = this.getPSPFPubCodes("VIEWCTRL", true);
            if (psPFPubCodes != null) {
                while (psPFPubCodes.hasNext()) {
                    IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                    IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
                    if (iPSPFCtrlTempl == null) {
                        log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s/%4$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSControl.getPSControlType().getId(), (Object)iPSPFPubCode.getName()));
                        continue;
                    }
                    list.add(iPSPFCtrlTempl);
                }
            }
            this.psPFCtrlTemplMap.put(iPSControl.getPSControlType().getId(), list);
            return list.size() > 0;
        }
    }

    @Override
    public boolean hasPSPFCtrlTempls(IPSControl iPSControl, String strPubCode) throws Exception {
        IPSPFPubCode iPSPFPubCode = this.getPSPFPubCode(strPubCode);
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
        return iPSPFCtrlTempl != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator<IPSPFCtrlTempl> getPSPFCtrlTempls(IPSControl iPSControl) throws Exception {
        HashMap<String, ArrayList<IPSPFCtrlTempl>> hashMap = this.psPFCtrlTemplMap;
        synchronized (hashMap) {
            ArrayList<IPSPFCtrlTempl> list = this.psPFCtrlTemplMap.get(iPSControl.getPSControlType().getId());
            if (list != null) {
                return list.iterator();
            }
            list = new ArrayList();
            Iterator<IPSPFPubCode> psPFPubCodes = this.getPSPFPubCodes("VIEWCTRL");
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
                if (iPSPFCtrlTempl == null) {
                    log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s/%2$s/%3$s/%4$s]\u4ee3\u7801\u6a21\u7248", (Object)this.getPSPF().getName(), (Object)this.getName(), (Object)iPSControl.getPSControlType().getId(), (Object)iPSPFPubCode.getName()));
                    continue;
                }
                list.add(iPSPFCtrlTempl);
            }
            this.psPFCtrlTemplMap.put(iPSControl.getPSControlType().getId(), list);
            return list.iterator();
        }
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(String strPFCtrlTemplId) throws Exception {
        return this.getPSPFCtrlTempl(strPFCtrlTemplId, false);
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(String strPFCtrlTemplId, boolean bTryMode) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl = this.psPFCtrlTemplMap2.get(strPFCtrlTemplId);
        if (iPSPFCtrlTempl == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u6a21\u677f"));
        }
        return iPSPFCtrlTempl;
    }

    @Override
    public void resetPSPFCtrlTempl(String strPFCtrlTemplId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSPFUIActionTempl getPSPFUIActionTempl(String strPFUIActionTemplId) throws Exception {
        return (IPSPFUIActionTempl)this.psPFUIActionTemplGlobalModel.FindModelHelper(strPFUIActionTemplId);
    }

    @Override
    public IPSPFUIActionTempl getPSPFUIActionTempl(String strPFUIActionTemplId, boolean bTryMode) throws Exception {
        return (IPSPFUIActionTempl)this.psPFUIActionTemplGlobalModel.FindModelHelper(strPFUIActionTemplId, bTryMode);
    }

    @Override
    public void resetPSPFUIActionTempl(String strPFUIActionTemplId) throws Exception {
        this.psPFUIActionTemplGlobalModel.ResetModel(strPFUIActionTemplId);
    }

    @Override
    public IPSPFViewLogicTempl getPSPFViewLogicTempl(String strPFViewLogicTemplId, boolean bTryMode) throws Exception {
        IPSPFViewLogicTempl iPSPFViewLogicTempl = this.psPFViewLogicTemplMap2.get(strPFViewLogicTemplId);
        if (iPSPFViewLogicTempl == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u903b\u8f91\u6a21\u677f[%1$s]", (Object)strPFViewLogicTemplId));
        }
        return iPSPFViewLogicTempl;
    }

    @Override
    public void resetPSPFViewLogicTempl(String strPFViewLogicTemplId) throws Exception {
        this.psPFViewLogicTemplMap2.remove(strPFViewLogicTemplId);
    }

    @Override
    public IPSPFViewLogicTempl getPSPFViewLogicTempl(IPSPFLogicCodeObject iPSPFLogicCodeObject, IPSPFPubCode iPSPFPubCode) throws Exception {
        IPSPFViewLogicTempl2 iPSPFViewLogicTempl;
        if (iPSPFLogicCodeObject.getPSPFPlugin() != null && iPSPFPubCode instanceof IPSPFPubCode2 && iPSPFLogicCodeObject.getPSPFPlugin() instanceof IPSPFPlugin2 && (iPSPFViewLogicTempl = ((IPSPFPlugin2)((Object)iPSPFLogicCodeObject.getPSPFPlugin())).getPSPFViewLogicTempl2((IPSPFPubCode2)iPSPFPubCode, true)) != null) {
            return iPSPFViewLogicTempl;
        }
        String strPSPFViewLogicTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)iPSPFLogicCodeObject.getPFLogicCodeCat(), (String)iPSPFLogicCodeObject.getPFLogicCodeType(), (String)iPSPFPubCode.getId());
        return this.getPSPFViewLogicTempl(strPSPFViewLogicTemplId, true);
    }

    @Override
    public IPSPFAppTempl getPSPFAppTempl(String strPFAppTemplId) throws Exception {
        return this.getPSPFAppTempl(strPFAppTemplId, false);
    }

    @Override
    public IPSPFAppTempl getPSPFAppTempl(String strPFAppTemplId, boolean bTryMode) throws Exception {
        IPSPFAppTempl iPSPFAppTempl = this.psPFAppTemplMap.get(strPFAppTemplId);
        if (iPSPFAppTempl == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u6307\u5b9a\u5e94\u7528\u6a21\u677f[%1$s]", (Object)strPFAppTemplId));
        }
        return iPSPFAppTempl;
    }

    @Override
    public void resetPSPFAppTempl(String strPFAppTemplId) throws Exception {
        this.psPFAppTemplMap.remove(strPFAppTemplId);
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId) throws Exception {
        return this.getPSPFEditorTempl(strPFEditorTemplId, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(String strPFEditorTemplId, boolean bTryMode) throws Exception {
        HashMap<String, IPSPFEditorTempl2> hashMap = this.psPFEditorTemplMap2;
        synchronized (hashMap) {
            IPSPFEditorTempl iPSPFEditorTempl = this.psPFEditorTemplMap2.get(strPFEditorTemplId);
            if (iPSPFEditorTempl == null && !bTryMode) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7f16\u8f91\u5668\u6a21\u677f[%1$s]", (Object)strPFEditorTemplId));
            }
            return iPSPFEditorTempl;
        }
    }

    @Override
    public void resetPSPFEditorTempl(String strPFEditorTemplId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSPFStylePrj getPSPFStylePrj(String strPSPFStylePrjId, boolean bTryMode) throws Exception {
        IPSPFStyle templPSPFStyle = this.getTemplPSPFStyle();
        if (templPSPFStyle != null) {
            return templPSPFStyle.getPSPFStylePrj(strPSPFStylePrjId, bTryMode);
        }
        return (IPSPFStylePrj)this.psPFStylePrjGlobalModel.FindModelHelper(strPSPFStylePrjId, bTryMode);
    }

    @Override
    public Iterator<IPSPFStylePrj> getPSPFStylePrjs() throws Exception {
        IPSPFStyle templPSPFStyle = this.getTemplPSPFStyle();
        if (templPSPFStyle != null) {
            return templPSPFStyle.getPSPFStylePrjs();
        }
        return this.psPFStylePrjGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getPSDevCenterName() {
        return this.psPFStyle.getPSDEVCENTERNAME();
    }

    @Override
    public String getPSDevCenterId() {
        return this.psPFStyle.getPSDEVCENTERID();
    }

    @Override
    public Iterator<IPSPFStylePkg> getPSPFStylePkgs() throws Exception {
        return this.psPFStylePkgGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSPFPkgVer> getPSPFPkgVers() throws Exception {
        return this.psPFPkgVerList.iterator();
    }

    @Override
    public String getTemplDocRootUrl() {
        return this.strTemplDocRootUrl;
    }

    @Override
    public String getResourceUrl() {
        return this.strResourceUrl;
    }

    @Override
    public String getModelType() {
        return "PSPFSTYLE";
    }

    @Override
    public String getVersionString() {
        return this.strVersionString;
    }

    @Override
    public String getStyleParam(String strParamName, String strDefault) {
        if (this.styleTemplateProperties != null && PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName) != null) {
            return PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName, (String)strDefault);
        }
        if (this.templPSPFStyle != null) {
            strDefault = this.templPSPFStyle.getStyleParam(strParamName, strDefault);
        }
        return PropertiesHelper.getProperty((Properties)this.classPkgParamsMap, (String)strParamName, (String)strDefault);
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        if (this.styleTemplateProperties != null && PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName) != null) {
            return PropertiesHelper.getProperty((Properties)this.styleTemplateProperties, (String)strParamName, (int)nDefault);
        }
        if (this.templPSPFStyle != null) {
            nDefault = this.templPSPFStyle.getStyleParam(strParamName, nDefault);
        }
        return PropertiesHelper.getProperty((Properties)this.classPkgParamsMap, (String)strParamName, (int)nDefault);
    }

    @Override
    public boolean isEnableGetPSObjectParam() {
        return true;
    }

    @Override
    public IPSPFCodeFolder getPSPFCodeFolder(String strPFCodeFolderId) throws Exception {
        return this.getPSPF().getPSPFCodeFolder(strPFCodeFolderId);
    }

    @Override
    public void resetPSPFCodeFolder(String strPFCodeFolderId) throws Exception {
        this.getPSPF().resetPSPFCodeFolder(strPFCodeFolderId);
    }

    protected String getLocalPath() {
        if (PSTaskServerEnvImpl.getCurrent().isLinux() && !StringHelper.IsNullOrEmpty((String)this.psPFStyle.getV2FOLDER2())) {
            return this.psPFStyle.getV2FOLDER2();
        }
        return this.psPFStyle.getV2FOLDER();
    }

    @Override
    public String getRealLocalPath() {
        if (PSTemplHelper.isBusy()) {
            log.error((Object)StringHelper.Format((String)"\u4e0d\u80fd\u5728\u6a21\u677f\u53d1\u5e03\u4e2d\u8c03\u7528[%1$s]\u65b9\u6cd5", (Object)"getRealLocalPath"));
            return null;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strRealLocalPath)) {
            return this.strRealLocalPath;
        }
        return this.getLocalPath();
    }

    @Override
    public String getRealResLocalPath() {
        if (PSTemplHelper.isBusy()) {
            log.error((Object)StringHelper.Format((String)"\u4e0d\u80fd\u5728\u6a21\u677f\u53d1\u5e03\u4e2d\u8c03\u7528[%1$s]\u65b9\u6cd5", (Object)"getRealResLocalPath"));
            return null;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strRealResLocalPath)) {
            return this.strRealResLocalPath;
        }
        return this.getResLocalPath();
    }

    protected String getRemotePath() {
        return this.psPFStyle.getV2GITPATH();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId) throws Exception {
        return this.getPSPFPubCode(strPFPubCodeId, false);
    }

    @Override
    public IPSPFPubCode getPSPFPubCode(String strPFPubCodeId, boolean bTryMode) throws Exception {
        IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId);
        if (iPSPFPubCode != null) {
            return iPSPFPubCode;
        }
        String strPFPubCodeId2 = KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)"VIEW", (String)strPFPubCodeId.toUpperCase());
        iPSPFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId2);
        if (iPSPFPubCode != null) {
            return iPSPFPubCode;
        }
        return this.getPSPF().getPSPFPubCode(strPFPubCodeId, bTryMode);
    }

    @Override
    public IPSPFPubCode getPSPFPubCode(String strTargetType, String strPFPubCodeId, boolean bTryMode) throws Exception {
        String strPFPubCodeId2 = KeyValueHelper.genUniqueId((String)this.getPSPF().getId(), (String)strTargetType, (String)strPFPubCodeId.toUpperCase());
        IPSPFPubCode iPSPFPubCode = this.psPFPubCodeMap.get(strPFPubCodeId2);
        if (iPSPFPubCode != null) {
            return iPSPFPubCode;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801\u5bf9\u8c61[%1$s][%2$s]", (Object)strTargetType, (Object)strPFPubCodeId));
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType) throws Exception {
        ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(strTargetType);
        if (list == null) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u76ee\u6807[%1$s]\u53d1\u5e03\u4ee3\u7801", (Object)strTargetType));
        }
        return list.iterator();
    }

    @Override
    public Iterator<IPSPFPubCode> getPSPFPubCodes(String strTargetType, boolean bTryMode) throws Exception {
        ArrayList<IPSPFPubCode> list = this.psPFPubCodesMap.get(strTargetType);
        if (list == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u76ee\u6807[%1$s]\u53d1\u5e03\u4ee3\u7801", (Object)strTargetType));
        }
        return list.iterator();
    }

    @Override
    public boolean isAutoNameOrCode() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public boolean isSystemFieldReadonlyDefault() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public boolean isEnableEditorStyleCode() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControl iPSControl, IPSPFPubCode iPSPFPubCode) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)iPSControl.getControlStyle())) {
            String strRealType = StringHelper.Format((String)"%1$s#%2$s", (Object)iPSControl.getControlType(), (Object)iPSControl.getControlStyle().toUpperCase());
            String strPSPFCtrlTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strRealType, (String)iPSPFPubCode.getId());
            IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFCtrlTempl(strPSPFCtrlTemplId, true);
            if (iPSPFCtrlTempl != null) {
                return iPSPFCtrlTempl;
            }
        }
        return this.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorContainer iPSEditor, IPSPFPubCode iPSPFPubCode) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)iPSEditor.getEditorStyle())) {
            IPSPFPluginTempl iPSPFPluginTempl;
            String strRealType = StringHelper.Format((String)"%1$s#%2$s", (Object)iPSEditor.getEditorType(), (Object)iPSEditor.getEditorStyle().toUpperCase());
            String strPSPFEditorTemplId = Helper.GenUniqueId((String)this.getPSPF().getId(), (String)this.getId(), (String)strRealType, (String)iPSPFPubCode.getId());
            IPSPFEditorTempl iPSPFEditorTempl = this.getPSPFEditorTempl(strPSPFEditorTemplId, true);
            if (iPSPFEditorTempl != null) {
                return iPSPFEditorTempl;
            }
            if (iPSEditor.getPSSysEditorStyle() != null && iPSEditor.getPSSysEditorStyle().getPSSysPFPlugin() != null && !StringHelper.IsNullOrEmpty((String)iPSPFPubCode.getName()) && (iPSPFPluginTempl = iPSEditor.getPSSysEditorStyle().getPSSysPFPlugin().getPSPFPluginTempl(this.getPSPF().getId(), iPSPFPubCode.getName().toUpperCase(), true)) != null) {
                IPSSysEditorStyleRuntime iPSSysEditorStyleRuntime = null;
                if (iPSEditor.getPSSysEditorStyle() instanceof IPSSysEditorStyleRuntime) {
                    iPSSysEditorStyleRuntime = (IPSSysEditorStyleRuntime)((Object)iPSEditor.getPSSysEditorStyle());
                }
                if (iPSSysEditorStyleRuntime != null && iPSSysEditorStyleRuntime.getPSPFEditorTempl() != null) {
                    return iPSSysEditorStyleRuntime.getPSPFEditorTempl();
                }
                PSPFEditorTempl psPFEditorTempl = new PSPFEditorTempl();
                psPFEditorTempl.setPSPFEDITORTEMPLID(strPSPFEditorTemplId);
                psPFEditorTempl.setPSEDITORTYPENAME("@EDITOR/" + iPSEditor.getEditorType());
                psPFEditorTempl.setPSEDITORTYPEID(iPSEditor.getEditorType());
                psPFEditorTempl.setPSEDITORTYPENAME(iPSEditor.getEditorType());
                psPFEditorTempl.setPSPFID(this.getPSPF().getId());
                psPFEditorTempl.setPSPFNAME(this.getPSPF().getName());
                psPFEditorTempl.setPSPFSTYLEID(this.getId());
                psPFEditorTempl.setPSPFSTYLENAME(this.getName());
                psPFEditorTempl.setPSPFPUBCODEID(iPSPFPubCode.getId());
                psPFEditorTempl.setPSPFPUBCODENAME(iPSPFPubCode.getName());
                psPFEditorTempl.setTEMPLCODE(iPSPFPluginTempl.getCode("CODE"));
                PSPFEditorTempl2Impl psPFEditorTempl2Impl = new PSPFEditorTempl2Impl();
                psPFEditorTempl2Impl.init(this.getDAGlobalHelper(), this.getPSPF(), this, iPSPFPubCode, psPFEditorTempl);
                if (iPSSysEditorStyleRuntime != null) {
                    iPSSysEditorStyleRuntime.setPSPFEditorTempl(psPFEditorTempl2Impl);
                }
                return psPFEditorTempl2Impl;
            }
        }
        return this.getPSPFEditorTempl(iPSEditor.getPSEditorType(), iPSEditor.getEditorContainer(), iPSPFPubCode);
    }

    @Override
    public boolean isRegisterToContainer() {
        return this.getPFEngineVer() >= 20;
    }

    @Override
    public Iterator<IPSPFAppDataEntityTempl> getPSPFAppDataEntityTempls(IPSAppDataEntity iPSAppDataEntity) throws Exception {
        return this.psPFAppDataEntityTemplMap.values().iterator();
    }

    @Override
    public Iterator<IPSPFAppWFTempl> getPSPFAppWFTempls(IPSAppWF iPSAppWF) throws Exception {
        return this.psPFAppWFTemplMap.values().iterator();
    }

    @Override
    public Iterator<IPSPFAppWFVerTempl> getPSPFAppWFVerTempls(IPSAppWFVer iPSAppWFVer) throws Exception {
        return this.psPFAppWFVerTemplMap.values().iterator();
    }

    @Override
    public String getTemplInfo() {
        return this.psPFStyle.getTEMPLINFO();
    }

    @Override
    public int getPFEngineVer() {
        int nPFEngineVer = this.getPSPF().getPFEngineVer();
        if (nPFEngineVer != 0) {
            return nPFEngineVer;
        }
        return 20;
    }

    @Override
    public String getResLocalPath() {
        if (this.resRootFolder != null) {
            return this.resRootFolder.getAbsolutePath();
        }
        return null;
    }

    @Override
    public Iterator<IPSPFAppObjectTempl> getPSPFAppObjectTempls(String strPubObject) throws Exception {
        Map map = this.psAppObjectTemplMapMap.get(strPubObject);
        if (map == null) {
            return null;
        }
        return map.values().iterator();
    }
}

