/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelInitException;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppView, IPSAppView> {
    private static final Log log = LogFactory.getLog(PSAppViewGlobalModel.class);
    private static Map<String, String> autoDEViewMap = new HashMap<String, String>();
    private static Map<String, String> autoDEMobViewMap = new HashMap<String, String>();
    private ArrayList<IPSAppView> extPSAppViewList = new ArrayList();

    static {
        autoDEViewMap.put("DEEDITVIEW", "");
        autoDEViewMap.put("DEEDITVIEW2", "");
        autoDEViewMap.put("DEEDITVIEW3", "");
        autoDEViewMap.put("DEEDITVIEW9", "");
        autoDEViewMap.put("DEGRIDVIEW", "");
        autoDEViewMap.put("DEGRIDVIEW9", "");
        autoDEViewMap.put("DEREDIRECTVIEW", "");
        autoDEViewMap.put("DEGRIDEXPVIEW", "");
        autoDEViewMap.put("DEDATAVIEW", "");
        autoDEViewMap.put("DEDATAVIEW9", "");
        autoDEViewMap.put("DEDATAVIEWEXPVIEW", "");
        autoDEViewMap.put("DEPICKUPDATAVIEW", "");
        autoDEViewMap.put("DELISTEXPVIEW", "");
        autoDEViewMap.put("DELISTVIEW", "");
        autoDEViewMap.put("DELISTVIEW9", "");
        autoDEViewMap.put("DECHARTEXPVIEW", "");
        autoDEViewMap.put("DECHARTVIEW", "");
        autoDEViewMap.put("DECHARTVIEW9", "");
        autoDEViewMap.put("DEPORTALVIEW", "");
        autoDEViewMap.put("DEPORTALVIEW9", "");
        autoDEViewMap.put("DETREEVIEW", "");
        autoDEViewMap.put("DETREEVIEW9", "");
        autoDEViewMap.put("DETREEEXPVIEW", "");
        autoDEViewMap.put("DETREEGRIDEXVIEW", "");
        autoDEViewMap.put("DETREEGRIDEXVIEW9", "");
        autoDEViewMap.put("DEGANTTVIEW", "");
        autoDEViewMap.put("DEGANTTVIEW9", "");
        autoDEViewMap.put("DEGANTTEXPVIEW", "");
        autoDEViewMap.put("DEKANBANVIEW", "");
        autoDEViewMap.put("DEKANBANVIEW9", "");
        autoDEViewMap.put("DECALENDAREXPVIEW", "");
        autoDEViewMap.put("DECALENDARVIEW", "");
        autoDEViewMap.put("DECALENDARVIEW9", "");
        autoDEViewMap.put("DEMAPVIEW", "");
        autoDEViewMap.put("DEMAPVIEW9", "");
        autoDEViewMap.put("DEMAPEXPVIEW", "");
        autoDEViewMap.put("DEREPORTVIEW", "");
        autoDEViewMap.put("DETABEXPVIEW", "");
        autoDEViewMap.put("DETABEXPVIEW9", "");
        autoDEViewMap.put("DEPICKUPVIEW", "");
        autoDEViewMap.put("DEPICKUPVIEW2", "");
        autoDEViewMap.put("DEPICKUPVIEW3", "");
        autoDEViewMap.put("DEMPICKUPVIEW", "");
        autoDEViewMap.put("DEMPICKUPVIEW2", "");
        autoDEViewMap.put("DEPICKUPGRIDVIEW", "");
        autoDEViewMap.put("DEPICKUPTREEVIEW", "");
        autoDEViewMap.put("DEOPTVIEW", "");
        autoDEViewMap.put("DEWIZARDVIEW", "");
        autoDEViewMap.put("DEHTMLVIEW", "");
        autoDEViewMap.put("DEFORMPICKUPDATAVIEW", "");
        autoDEViewMap.put("DEINDEXPICKUPDATAVIEW", "");
        autoDEViewMap.put("DEMEDITVIEW9", "");
        autoDEMobViewMap.put("DEMOBEDITVIEW", "");
        autoDEMobViewMap.put("DEMOBEDITVIEW3", "");
        autoDEMobViewMap.put("DEMOBEDITVIEW9", "");
        autoDEMobViewMap.put("DEMOBREDIRECTVIEW", "");
        autoDEMobViewMap.put("DEMOBDATAVIEW", "");
        autoDEMobViewMap.put("DEMOBDATAVIEWEXPVIEW", "");
        autoDEMobViewMap.put("DEMOBLISTEXPVIEW", "");
        autoDEMobViewMap.put("DEMOBLISTVIEW", "");
        autoDEMobViewMap.put("DEMOBPICKUPLISTVIEW", "");
        autoDEMobViewMap.put("DEMOBCHARTEXPVIEW", "");
        autoDEMobViewMap.put("DEMOBCHARTVIEW", "");
        autoDEMobViewMap.put("DEMOBCHARTVIEW9", "");
        autoDEMobViewMap.put("DEMOBPORTALVIEW", "");
        autoDEMobViewMap.put("DEMOBPORTALVIEW9", "");
        autoDEMobViewMap.put("DEMOBTREEVIEW", "");
        autoDEMobViewMap.put("DEMOBTREEEXPVIEW", "");
        autoDEMobViewMap.put("DEMOBTREEEXPVIEW9", "");
        autoDEMobViewMap.put("DEMOBGANTTVIEW", "");
        autoDEMobViewMap.put("DEMOBGANTTVIEW9", "");
        autoDEMobViewMap.put("DEMOBGANTTEXPVIEW", "");
        autoDEMobViewMap.put("DEMOBCALENDAREXPVIEW", "");
        autoDEMobViewMap.put("DEMOBCALENDARVIEW", "");
        autoDEMobViewMap.put("DEMOBCALENDARVIEW9", "");
        autoDEMobViewMap.put("DEMOBMAPVIEW", "");
        autoDEMobViewMap.put("DEMOBMAPVIEW9", "");
        autoDEMobViewMap.put("DEMOBMAPEXPVIEW", "");
        autoDEMobViewMap.put("DEMOBREPORTVIEW", "");
        autoDEMobViewMap.put("DEMOBTABEXPVIEW", "");
        autoDEMobViewMap.put("DEMOBTABEXPVIEW9", "");
        autoDEMobViewMap.put("DEMOBPICKUPVIEW", "");
        autoDEMobViewMap.put("DEMOBMPICKUPVIEW", "");
        autoDEMobViewMap.put("DEMOBPICKUPMDVIEW", "");
        autoDEMobViewMap.put("DEMOBPICKUPTREEVIEW", "");
        autoDEMobViewMap.put("DEMOBOPTVIEW", "");
        autoDEMobViewMap.put("DEMOBWIZARDVIEW", "");
        autoDEMobViewMap.put("DEMOBHTMLVIEW", "");
        autoDEMobViewMap.put("DEMOBMDVIEW", "");
        autoDEMobViewMap.put("DEMOBMDVIEW9", "");
        autoDEMobViewMap.put("DEMOBFORMPICKUPMDVIEW", "");
        autoDEMobViewMap.put("DEMOBINDEXPICKUPMDVIEW", "");
        autoDEMobViewMap.put("DEMOBMEDITVIEW9", "");
    }

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSAppView GetObject(String strPSApplicationViewId) {
        PSAppView psApplicationView = new PSAppView();
        CallResult callResult = this.iPSModelHelper.getPSApplicationView(strPSApplicationViewId, psApplicationView);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSApplicationViewId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psApplicationView;
    }

    @Override
    protected IPSAppView OnCreateModelHelper(PSAppView vt, String strId) throws Exception {
        if (StringHelper.Compare((String)strId, (String)vt.getPSAPPVIEWID(), (boolean)false) == 0) {
            long nTime = System.currentTimeMillis();
            if (StringHelper.IsNullOrEmpty((String)vt.getPSDEVIEWBASEID()) && StringHelper.IsNullOrEmpty((String)vt.getPSDYNADEVIEWTEMPLID()) && StringHelper.IsNullOrEmpty((String)vt.getPSAPPUTILVIEWTYPE())) {
                IPSViewType iPSAppViewType = this.iPSModelStorage.getPSViewType(vt.getPSAPPVIEWTYPE());
                IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
                long nValue = System.currentTimeMillis() - nTime;
                if (nValue >= 5L) {
                    log.debug((Object)StringHelper.Format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
                }
                return iPSApplicationView;
            }
            if (!StringHelper.IsNullOrEmpty((String)vt.getPSDEVIEWTYPE())) {
                IPSViewType iPSAppViewType = this.iPSModelStorage.getPSViewType(vt.getPSDEVIEWTYPE());
                IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
                long nValue = System.currentTimeMillis() - nTime;
                if (nValue >= 5L) {
                    log.debug((Object)StringHelper.Format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
                }
                return iPSApplicationView;
            }
            if (!StringHelper.IsNullOrEmpty((String)vt.getPSDYNADEVIEWTYPE())) {
                IPSViewType iPSAppViewType = this.iPSModelStorage.getPSViewType(vt.getPSDYNADEVIEWTYPE());
                IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
                long nValue = System.currentTimeMillis() - nTime;
                if (nValue >= 5L) {
                    log.debug((Object)StringHelper.Format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
                }
                return iPSApplicationView;
            }
            if (!StringHelper.IsNullOrEmpty((String)vt.getPSAPPUTILVIEWTYPE())) {
                IPSViewType iPSAppViewType = this.iPSModelStorage.getPSViewType(vt.getPSAPPUTILVIEWTYPE());
                IPSAppView iPSApplicationView = iPSAppViewType.createPSAppView(vt);
                long nValue = System.currentTimeMillis() - nTime;
                if (nValue >= 5L) {
                    log.debug((Object)StringHelper.Format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSApplicationView.getName(), (Object)nValue));
                }
                return iPSApplicationView;
            }
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u521b\u5efa\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]\u5bf9\u8c61\uff0c\u65e0\u6cd5\u8bc6\u522b", (Object)vt.getPSAPPVIEWID()));
        }
        return (IPSAppView)this.FindModelHelper(vt.getPSAPPVIEWID());
    }

    @Override
    protected Boolean TestObjectRenew(PSAppView obj) {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSAppView FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSAppView iPSAppView = (IPSAppView)super.FindModelHelper(objObjectId, bTryMode);
        if (iPSAppView == null) {
            return iPSAppView;
        }
        IPSAppView iPSAppView2 = iPSAppView;
        synchronized (iPSAppView2) {
            if (!iPSAppView.isInited()) {
                PSAppView psAppView = (PSAppView)((Object)this.InternalGetModel(objObjectId));
                if (psAppView == null) {
                    psAppView = this.GetObject(objObjectId);
                } else {
                    PSAppView psAppView2 = new PSAppView();
                    psAppView.CopyTo(psAppView2, false);
                    psAppView = psAppView2;
                }
                long nTime = System.currentTimeMillis();
                try {
                    iPSAppView.init(this.iDAGlobalHelper, this.getPSApplication(), psAppView);
                    long nValue = System.currentTimeMillis() - nTime;
                    if (nValue >= 5L) {
                        log.debug((Object)StringHelper.Format((String)"\u6784\u5efa\u5e94\u7528\u89c6\u56fe[%1$s]\u8017\u65f6[%2$s]ms", (Object)iPSAppView.getName(), (Object)nValue));
                    }
                }
                catch (Exception ex) {
                    PSModelInitException psModelInitException;
                    if (this.testPSAppViewGlobalModelException(ex)) {
                        throw ex;
                    }
                    if (ex instanceof PSModelInitException && (psModelInitException = (PSModelInitException)ex).getPSModelObject() instanceof IPSAppView) {
                        this.getPSApplicationRuntime().log(1, this.getPSApplication(), psModelInitException.getMessage());
                        throw new PSAppViewGlobalModelException(psModelInitException.getMessage(), ex);
                    }
                    String strInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u5e94\u7528\u89c6\u56fe[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psAppView.getPSAPPVIEWNAME(), (Object)ex.getMessage());
                    log.error((Object)strInfo, (Throwable)ex);
                    this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
                    throw new PSAppViewGlobalModelException(strInfo, ex);
                }
            }
        }
        return iPSAppView;
    }

    protected boolean testPSAppViewGlobalModelException(Throwable ex) {
        if (ex instanceof PSAppViewGlobalModelException) {
            return true;
        }
        if (ex.getCause() == null) {
            return false;
        }
        return this.testPSAppViewGlobalModelException(ex.getCause());
    }

    @Override
    protected IPSAppView registerModel(PSAppView vt) throws Exception {
        IPSAppView iPSAppView = (IPSAppView)this.InternalGetModelHelper(vt.getPSAPPVIEWID());
        if (iPSAppView != null) {
            return iPSAppView;
        }
        this.setModel(vt.getPSAPPVIEWID(), vt, null);
        iPSAppView = (IPSAppView)this.FindModelHelper(vt.getPSAPPVIEWID());
        return iPSAppView;
    }

    @Override
    protected Vector<PSAppView> getAllModels() throws Exception {
        Vector<PSAppView> list = new Vector<PSAppView>();
        CallResult callResult = this.iPSModelHelper.getAllPSApplicationViews(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u89c6\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        IPSSystemRuntime iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSApplication().getPSSystem());
        if (!StringHelper.IsNullOrEmpty((String)iPSSystemRuntime.getPSDynaInstId()) && (this.getPSApplication().isAutoAddAppDEView() || this.getPSApplication().getDefaultFlag())) {
            Iterator<IPSAppDataEntity> psAppDataEntities;
            Iterator<IPSAppModule> psAppModules;
            HashMap<String, PSAppView> psAppViewMap = new HashMap<String, PSAppView>();
            for (PSAppView psAppView : list) {
                if (StringHelper.Compare((String)psAppView.getPSAPPVIEWTYPE(), (String)"APPDEVIEW", (boolean)false) != 0 || StringHelper.IsNullOrEmpty((String)psAppView.getPSDEVIEWBASEID())) continue;
                psAppViewMap.put(psAppView.getPSDEVIEWBASEID(), psAppView);
            }
            IPSAppModule defaultPSAppModule = this.getPSApplication().getDefaultPSAppModule();
            if (defaultPSAppModule == null && (psAppModules = this.getPSApplication().getAllPSAppModules()) != null && psAppModules.hasNext()) {
                defaultPSAppModule = psAppModules.next();
            }
            if ((psAppDataEntities = this.getPSApplication().getAllPSAppDataEntities()) != null) {
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                    Iterator<PSDEViewBase> psDEViewBases = iPSAppDataEntity.getPSDataEntity().getAllPSDEViewDatas();
                    if (psDEViewBases == null) continue;
                    boolean bAddView = false;
                    while (psDEViewBases.hasNext()) {
                        PSDEViewBase psDEViewBase = psDEViewBases.next();
                        if (!psAppViewMap.containsKey(psDEViewBase.getPSDEVIEWBASEID())) continue;
                        bAddView = true;
                        break;
                    }
                    if (!bAddView) continue;
                    psDEViewBases = iPSAppDataEntity.getPSDataEntity().getAllPSDEViewDatas();
                    String strPSAppModuleId = iPSAppDataEntity.getPSAppModuleId();
                    if (StringHelper.IsNullOrEmpty((String)strPSAppModuleId) && defaultPSAppModule != null) {
                        strPSAppModuleId = defaultPSAppModule.getId();
                    }
                    while (psDEViewBases.hasNext()) {
                        PSDEViewBase psDEViewBase = psDEViewBases.next();
                        if (psAppViewMap.containsKey(psDEViewBase.getPSDEVIEWBASEID()) || (this.getPSApplication().isMobileApp() ? !autoDEMobViewMap.containsKey(psDEViewBase.getPSDEVIEWBASETYPE()) : !autoDEViewMap.containsKey(psDEViewBase.getPSDEVIEWBASETYPE()))) continue;
                        PSAppView psAppView = new PSAppView();
                        psAppView.setPSAPPVIEWID(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID()));
                        psAppView.setPSAPPVIEWNAME(StringHelper.Format((String)"%1$s%2$s", (Object)iPSAppDataEntity.getPSDataEntity().getCodeName(), (Object)psDEViewBase.getCODENAME()));
                        psAppView.setPSAPPMODULEID(strPSAppModuleId);
                        psAppView.setPSDEVIEWBASEID(psDEViewBase.getPSDEVIEWBASEID());
                        psAppView.setPSDEVIEWBASENAME(psDEViewBase.getPSDEVIEWBASENAME());
                        psAppView.setPSDEVIEWTYPE(psDEViewBase.getPSDEVIEWBASETYPE());
                        psAppView.setPSSYSAPPID(this.getPSApplication().getId());
                        psAppView.setPSAPPVIEWTYPE("APPDEVIEW");
                        psAppView.set("AUTOMODEL", 1);
                        list.add(psAppView);
                        psAppViewMap.put(psAppView.getPSDEVIEWBASEID(), psAppView);
                    }
                }
            }
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModels();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected String getObjectId(PSAppView vt) {
        return vt.getPSAPPVIEWID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppView vt) {
        String strUniqueId;
        if (StringHelper.Compare((String)vt.getPSAPPVIEWTYPE(), (String)"APPDEVIEW", (boolean)true) == 0) {
            String strUniqueId2 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)vt.getPSDEVIEWBASEID());
            if (StringHelper.Compare((String)strUniqueId2, (String)vt.getPSAPPVIEWID(), (boolean)false) != 0) {
                return new String[]{strUniqueId2.toUpperCase()};
            }
        } else if (StringHelper.Compare((String)vt.getPSAPPVIEWTYPE(), (String)"APPDYNADEVIEW", (boolean)true) == 0 && StringHelper.Compare((String)(strUniqueId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)vt.getPSDYNADEVIEWTEMPLID())), (String)vt.getPSAPPVIEWID(), (boolean)false) != 0) {
            return new String[]{strUniqueId.toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    public IPSAppView registerPSAppView(PSAppView psAppView) throws Exception {
        this.setModel(psAppView.getPSAPPVIEWID(), psAppView, null);
        IPSAppView iPSAppView = (IPSAppView)this.FindModelHelper(psAppView.getPSAPPVIEWID());
        this.extPSAppViewList.add(iPSAppView);
        return iPSAppView;
    }

    private class PSAppViewGlobalModelException
    extends Exception {
        public PSAppViewGlobalModelException(String arg0, Throwable arg1) {
            super(arg0, arg1);
        }
    }
}

