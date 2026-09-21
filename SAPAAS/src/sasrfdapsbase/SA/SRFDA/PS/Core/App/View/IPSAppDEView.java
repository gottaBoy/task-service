/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDEViewBase;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelExtendMeta(typevalue={"APPDEVIEW"})
@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="viewType", implement="PSAppDEViewImpl", model="PSDEViewBase", description="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u5b9e\u9645\u7684\u6807\u51c6\u6a21\u578b\u662f{@link PSAppDEViewDTO}\uff0c\u5b9a\u4e49\u4e86\u5b9e\u4f53\u89c6\u56fe{@link PSDEViewBaseDTO}\u4e0e\u5e94\u7528\u7684\u5173\u7cfb\u3002\u89c6\u56fe\u5927\u90e8\u5206\u529f\u80fd\u5b9a\u4e49\u7684\u6a21\u578b\u6765\u81ea{@link PSDEViewBaseDTO}\u3002")
public interface IPSAppDEView
extends IPSAppView,
IPSDataEntityObject,
IPSAppDEViewBase {
    public static final String APPDEVIEWTYPE_DECALENDAREXPVIEW = "DECALENDAREXPVIEW";
    public static final String APPDEVIEWTYPE_DECALENDARVIEW = "DECALENDARVIEW";
    public static final String APPDEVIEWTYPE_DECALENDARVIEW9 = "DECALENDARVIEW9";
    public static final String APPDEVIEWTYPE_DECHARTEXPVIEW = "DECHARTEXPVIEW";
    public static final String APPDEVIEWTYPE_DECHARTVIEW = "DECHARTVIEW";
    public static final String APPDEVIEWTYPE_DECHARTVIEW9 = "DECHARTVIEW9";
    public static final String APPDEVIEWTYPE_DECUSTOMVIEW = "DECUSTOMVIEW";
    public static final String APPDEVIEWTYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String APPDEVIEWTYPE_DEDATAVIEW9 = "DEDATAVIEW9";
    public static final String APPDEVIEWTYPE_DEDATAVIEWEXPVIEW = "DEDATAVIEWEXPVIEW";
    public static final String APPDEVIEWTYPE_DEEDITVIEW = "DEEDITVIEW";
    public static final String APPDEVIEWTYPE_DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String APPDEVIEWTYPE_DEEDITVIEW3 = "DEEDITVIEW3";
    public static final String APPDEVIEWTYPE_DEEDITVIEW4 = "DEEDITVIEW4";
    public static final String APPDEVIEWTYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String APPDEVIEWTYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String APPDEVIEWTYPE_DEGANTTEXPVIEW = "DEGANTTEXPVIEW";
    public static final String APPDEVIEWTYPE_DEGANTTVIEW = "DEGANTTVIEW";
    public static final String APPDEVIEWTYPE_DEGANTTVIEW9 = "DEGANTTVIEW9";
    public static final String APPDEVIEWTYPE_DEGRIDEXPVIEW = "DEGRIDEXPVIEW";
    public static final String APPDEVIEWTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String APPDEVIEWTYPE_DEGRIDVIEW2 = "DEGRIDVIEW2";
    public static final String APPDEVIEWTYPE_DEGRIDVIEW4 = "DEGRIDVIEW4";
    public static final String APPDEVIEWTYPE_DEGRIDVIEW8 = "DEGRIDVIEW8";
    public static final String APPDEVIEWTYPE_DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String APPDEVIEWTYPE_DEHTMLVIEW = "DEHTMLVIEW";
    public static final String APPDEVIEWTYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String APPDEVIEWTYPE_DEINDEXVIEW = "DEINDEXVIEW";
    public static final String APPDEVIEWTYPE_DEKANBANVIEW = "DEKANBANVIEW";
    public static final String APPDEVIEWTYPE_DEKANBANVIEW9 = "DEKANBANVIEW9";
    public static final String APPDEVIEWTYPE_DELISTEXPVIEW = "DELISTEXPVIEW";
    public static final String APPDEVIEWTYPE_DELISTVIEW = "DELISTVIEW";
    public static final String APPDEVIEWTYPE_DELISTVIEW9 = "DELISTVIEW9";
    public static final String APPDEVIEWTYPE_DEMAPEXPVIEW = "DEMAPEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMAPVIEW = "DEMAPVIEW";
    public static final String APPDEVIEWTYPE_DEMAPVIEW9 = "DEMAPVIEW9";
    public static final String APPDEVIEWTYPE_DEMDCUSTOMVIEW = "DEMDCUSTOMVIEW";
    public static final String APPDEVIEWTYPE_DEMEDITVIEW9 = "DEMEDITVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBCALENDAREXPVIEW = "DEMOBCALENDAREXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBCALENDARVIEW = "DEMOBCALENDARVIEW";
    public static final String APPDEVIEWTYPE_DEMOBCALENDARVIEW9 = "DEMOBCALENDARVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBCHARTEXPVIEW = "DEMOBCHARTEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBCHARTVIEW = "DEMOBCHARTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBCHARTVIEW9 = "DEMOBCHARTVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBCUSTOMVIEW = "DEMOBCUSTOMVIEW";
    public static final String APPDEVIEWTYPE_DEMOBDATAVIEW = "DEMOBDATAVIEW";
    public static final String APPDEVIEWTYPE_DEMOBDATAVIEWEXPVIEW = "DEMOBDATAVIEWEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBEDITVIEW = "DEMOBEDITVIEW";
    public static final String APPDEVIEWTYPE_DEMOBEDITVIEW3 = "DEMOBEDITVIEW3";
    public static final String APPDEVIEWTYPE_DEMOBEDITVIEW9 = "DEMOBEDITVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBFORMPICKUPMDVIEW = "DEMOBFORMPICKUPMDVIEW";
    public static final String APPDEVIEWTYPE_DEMOBGANTTEXPVIEW = "DEMOBGANTTEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBGANTTVIEW = "DEMOBGANTTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBGANTTVIEW9 = "DEMOBGANTTVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBHTMLVIEW = "DEMOBHTMLVIEW";
    public static final String APPDEVIEWTYPE_DEMOBINDEXPICKUPMDVIEW = "DEMOBINDEXPICKUPMDVIEW";
    public static final String APPDEVIEWTYPE_DEMOBLISTEXPVIEW = "DEMOBLISTEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBLISTVIEW = "DEMOBLISTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBMAPEXPVIEW = "DEMOBMAPEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBMAPVIEW = "DEMOBMAPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBMAPVIEW9 = "DEMOBMAPVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBMDVIEW = "DEMOBMDVIEW";
    public static final String APPDEVIEWTYPE_DEMOBMDVIEW9 = "DEMOBMDVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBMEDITVIEW9 = "DEMOBMEDITVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBMPICKUPVIEW = "DEMOBMPICKUPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBOPTVIEW = "DEMOBOPTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBPANELVIEW = "DEMOBPANELVIEW";
    public static final String APPDEVIEWTYPE_DEMOBPANELVIEW9 = "DEMOBPANELVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBPICKUPLISTVIEW = "DEMOBPICKUPLISTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBPICKUPMDVIEW = "DEMOBPICKUPMDVIEW";
    public static final String APPDEVIEWTYPE_DEMOBPICKUPTREEVIEW = "DEMOBPICKUPTREEVIEW";
    public static final String APPDEVIEWTYPE_DEMOBPICKUPVIEW = "DEMOBPICKUPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBPORTALVIEW = "DEMOBPORTALVIEW";
    public static final String APPDEVIEWTYPE_DEMOBPORTALVIEW9 = "DEMOBPORTALVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBREDIRECTVIEW = "DEMOBREDIRECTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBREPORTVIEW = "DEMOBREPORTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBTABEXPVIEW = "DEMOBTABEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBTABEXPVIEW9 = "DEMOBTABEXPVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBTABSEARCHVIEW = "DEMOBTABSEARCHVIEW";
    public static final String APPDEVIEWTYPE_DEMOBTABSEARCHVIEW9 = "DEMOBTABSEARCHVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBTREEEXPVIEW = "DEMOBTREEEXPVIEW";
    public static final String APPDEVIEWTYPE_DEMOBTREEEXPVIEW9 = "DEMOBTREEEXPVIEW9";
    public static final String APPDEVIEWTYPE_DEMOBTREEVIEW = "DEMOBTREEVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFACTIONVIEW = "DEMOBWFACTIONVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFDATAREDIRECTVIEW = "DEMOBWFDATAREDIRECTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFDYNAACTIONVIEW = "DEMOBWFDYNAACTIONVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFDYNAEDITVIEW = "DEMOBWFDYNAEDITVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFDYNAEDITVIEW3 = "DEMOBWFDYNAEDITVIEW3";
    public static final String APPDEVIEWTYPE_DEMOBWFDYNAEXPMDVIEW = "DEMOBWFDYNAEXPMDVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFDYNASTARTVIEW = "DEMOBWFDYNASTARTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFEDITVIEW = "DEMOBWFEDITVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFEDITVIEW3 = "DEMOBWFEDITVIEW3";
    public static final String APPDEVIEWTYPE_DEMOBWFMDVIEW = "DEMOBWFMDVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFPROXYRESULTVIEW = "DEMOBWFPROXYRESULTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFPROXYSTARTVIEW = "DEMOBWFPROXYSTARTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWFSTARTVIEW = "DEMOBWFSTARTVIEW";
    public static final String APPDEVIEWTYPE_DEMOBWIZARDVIEW = "DEMOBWIZARDVIEW";
    public static final String APPDEVIEWTYPE_DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String APPDEVIEWTYPE_DEMPICKUPVIEW2 = "DEMPICKUPVIEW2";
    public static final String APPDEVIEWTYPE_DEOPTVIEW = "DEOPTVIEW";
    public static final String APPDEVIEWTYPE_DEPANELVIEW = "DEPANELVIEW";
    public static final String APPDEVIEWTYPE_DEPANELVIEW9 = "DEPANELVIEW9";
    public static final String APPDEVIEWTYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String APPDEVIEWTYPE_DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String APPDEVIEWTYPE_DEPICKUPTREEVIEW = "DEPICKUPTREEVIEW";
    public static final String APPDEVIEWTYPE_DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String APPDEVIEWTYPE_DEPICKUPVIEW2 = "DEPICKUPVIEW2";
    public static final String APPDEVIEWTYPE_DEPICKUPVIEW3 = "DEPICKUPVIEW3";
    public static final String APPDEVIEWTYPE_DEPORTALVIEW = "DEPORTALVIEW";
    public static final String APPDEVIEWTYPE_DEPORTALVIEW9 = "DEPORTALVIEW9";
    public static final String APPDEVIEWTYPE_DEREDIRECTVIEW = "DEREDIRECTVIEW";
    public static final String APPDEVIEWTYPE_DEREPORTVIEW = "DEREPORTVIEW";
    public static final String APPDEVIEWTYPE_DETABEXPVIEW = "DETABEXPVIEW";
    public static final String APPDEVIEWTYPE_DETABEXPVIEW9 = "DETABEXPVIEW9";
    public static final String APPDEVIEWTYPE_DETABSEARCHVIEW = "DETABSEARCHVIEW";
    public static final String APPDEVIEWTYPE_DETABSEARCHVIEW9 = "DETABSEARCHVIEW9";
    public static final String APPDEVIEWTYPE_DETREEEXPVIEW = "DETREEEXPVIEW";
    public static final String APPDEVIEWTYPE_DETREEEXPVIEW2 = "DETREEEXPVIEW2";
    public static final String APPDEVIEWTYPE_DETREEEXPVIEW3 = "DETREEEXPVIEW3";
    public static final String APPDEVIEWTYPE_DETREEGRIDEXVIEW = "DETREEGRIDEXVIEW";
    public static final String APPDEVIEWTYPE_DETREEGRIDEXVIEW9 = "DETREEGRIDEXVIEW9";
    public static final String APPDEVIEWTYPE_DETREEGRIDVIEW = "DETREEGRIDVIEW";
    public static final String APPDEVIEWTYPE_DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String APPDEVIEWTYPE_DETREEVIEW = "DETREEVIEW";
    public static final String APPDEVIEWTYPE_DETREEVIEW9 = "DETREEVIEW9";
    public static final String APPDEVIEWTYPE_DEWFACTIONVIEW = "DEWFACTIONVIEW";
    public static final String APPDEVIEWTYPE_DEWFDATAREDIRECTVIEW = "DEWFDATAREDIRECTVIEW";
    public static final String APPDEVIEWTYPE_DEWFDYNAACTIONVIEW = "DEWFDYNAACTIONVIEW";
    public static final String APPDEVIEWTYPE_DEWFDYNAEDITVIEW = "DEWFDYNAEDITVIEW";
    public static final String APPDEVIEWTYPE_DEWFDYNAEDITVIEW3 = "DEWFDYNAEDITVIEW3";
    public static final String APPDEVIEWTYPE_DEWFDYNAEXPGRIDVIEW = "DEWFDYNAEXPGRIDVIEW";
    public static final String APPDEVIEWTYPE_DEWFDYNASTARTVIEW = "DEWFDYNASTARTVIEW";
    public static final String APPDEVIEWTYPE_DEWFEDITPROXYDATAVIEW = "DEWFEDITPROXYDATAVIEW";
    public static final String APPDEVIEWTYPE_DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String APPDEVIEWTYPE_DEWFEDITVIEW2 = "DEWFEDITVIEW2";
    public static final String APPDEVIEWTYPE_DEWFEDITVIEW3 = "DEWFEDITVIEW3";
    public static final String APPDEVIEWTYPE_DEWFEDITVIEW9 = "DEWFEDITVIEW9";
    public static final String APPDEVIEWTYPE_DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String APPDEVIEWTYPE_DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String APPDEVIEWTYPE_DEWFPROXYDATAREDIRECTVIEW = "DEWFPROXYDATAREDIRECTVIEW";
    public static final String APPDEVIEWTYPE_DEWFPROXYDATAVIEW = "DEWFPROXYDATAVIEW";
    public static final String APPDEVIEWTYPE_DEWFPROXYRESULTVIEW = "DEWFPROXYRESULTVIEW";
    public static final String APPDEVIEWTYPE_DEWFPROXYSTARTVIEW = "DEWFPROXYSTARTVIEW";
    public static final String APPDEVIEWTYPE_DEWFSTARTVIEW = "DEWFSTARTVIEW";
    public static final String APPDEVIEWTYPE_DEWIZARDVIEW = "DEWIZARDVIEW";
    public static final String APPDEVIEWTYPE_DESUBAPPREFVIEW = "DESUBAPPREFVIEW";

    @Override
    public String getPSDEViewId();

    @Override
    public String getPSDEViewName();

    @Override
    public IPSDataEntity getPSDataEntity();

    @Override
    public int getTempMode();

    @Override
    public boolean isEnableWF();

    @Override
    public IPSDEActionWizardGroup getPSDEActionWizardGroup();

    @Override
    public String getPSDEViewCodeName();

    @Override
    public IPSDER1N getPSDER1N();

    @Override
    public String getFuncViewMode();

    @Override
    public String getFuncViewParam();

    @Override
    public IPSSysCounter getPSSysCounter();

    @Override
    public IPSSysCounterRef getPSSysCounterRef();

    @Override
    public IPSAppCounterRef getPSAppCounterRef();

    @Override
    public IPSAppDataEntity getParentPSAppDataEntity() throws Exception;
}

