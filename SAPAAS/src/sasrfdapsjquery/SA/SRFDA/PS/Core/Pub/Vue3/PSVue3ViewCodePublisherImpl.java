/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.Func.IPSAppFunc
 *  SA.SRFDA.PS.Core.App.View.IPSAppDEPickupView
 *  SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView
 *  SA.SRFDA.PS.Core.App.View.IPSAppDynaDEView
 *  SA.SRFDA.PS.Core.App.View.IPSAppExplorerView
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.App.View.IPSAppViewRef
 *  SA.SRFDA.PS.Core.App.View.PSAppDEPickupGridViewImpl
 *  SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl
 *  SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel
 *  SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl
 *  SA.SRFDA.PS.Core.Res.IPSSubViewType
 *  SA.SRFDA.PS.Core.SubSys.IPSSubDEView
 *  SA.SRFDA.PS.Core.View.IPSViewType
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Pub.Vue3;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppDEPickupView;
import SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppDynaDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppDEPickupGridViewImpl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.PF.IPSNGState;
import SA.SRFDA.PS.Core.PF.PSVue2StateImpl;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2FileNameMethod;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2TemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.sf.json.JSONObject;

public class PSVue3ViewCodePublisherImpl
extends PSPFViewCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSNGState> psNGStateList = null;
        if (StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"DEBUGHTML", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"REFVIEWS", (boolean)true) == 0) {
            psNGStateList = new ArrayList<IPSNGState>();
            HashMap<String, IPSNGState> psNGStateMap = new HashMap<String, IPSNGState>();
            this.fillNGStates(this.iPSAppView, null, "", null, psNGStateList, true, psNGStateMap, 0);
            Collections.reverse(psNGStateList);
            params.put("vue2states", psNGStateList);
            HashMap<String, IPSAppView> routeViewMaps = new HashMap<String, IPSAppView>();
            for (IPSNGState iPSNGState : psNGStateMap.values()) {
                IPSAppView iPSAppView = iPSNGState.getPSAppView();
                if (iPSAppView == null || routeViewMaps.containsKey(iPSAppView.getId())) continue;
                routeViewMaps.put(iPSAppView.getId(), iPSAppView);
            }
            ArrayList<IPSAppView> modalPSAppViewList = new ArrayList<IPSAppView>();
            HashMap<String, IPSAppView> allModalViewmaps = new HashMap<String, IPSAppView>();
            this.fillAllModalPSAppViews(this.iPSAppView, allModalViewmaps, 0);
            if (allModalViewmaps.containsKey(this.iPSAppView.getId())) {
                allModalViewmaps.remove(this.iPSAppView.getId());
            }
            ArrayList<IPSAppView> embeddedPSAppViewList = new ArrayList<IPSAppView>();
            HashMap<String, IPSAppView> allEmbeddedViewmaps = new HashMap<String, IPSAppView>();
            this.fillEmbeddedPSAppViews(this.iPSAppView, allEmbeddedViewmaps, 0);
            if (allEmbeddedViewmaps.containsKey(this.iPSAppView.getId())) {
                allEmbeddedViewmaps.remove(this.iPSAppView.getId());
            }
            if (this.iPSAppView.isDynamicView()) {
                this.addDynamicViewRefViews(routeViewMaps);
                this.addDynamicViewRefViews(allModalViewmaps);
                this.addDynamicViewRefViews(allEmbeddedViewmaps);
            }
            ArrayList<IPSAppView> refPSAppViewList = new ArrayList<IPSAppView>();
            ArrayList modalPSAppViewList2 = new ArrayList();
            HashMap<String, IPSAppView> allModalViewmaps2 = new HashMap<String, IPSAppView>();
            ArrayList embeddedPSAppViewList2 = new ArrayList();
            HashMap<String, IPSAppView> embeddedViewmaps2 = new HashMap<String, IPSAppView>();
            for (IPSAppView _iPSAppView : routeViewMaps.values()) {
                if (_iPSAppView == null) continue;
                if (allModalViewmaps.containsKey(_iPSAppView.getId())) {
                    allModalViewmaps2.put(_iPSAppView.getId(), _iPSAppView);
                    allModalViewmaps.remove(_iPSAppView.getId());
                }
                if (!allEmbeddedViewmaps.containsKey(_iPSAppView.getId())) continue;
                embeddedViewmaps2.put(_iPSAppView.getId(), _iPSAppView);
                allEmbeddedViewmaps.remove(_iPSAppView.getId());
            }
            if (routeViewMaps.containsKey(this.iPSAppView.getId())) {
                routeViewMaps.remove(this.iPSAppView.getId());
            }
            refPSAppViewList.addAll(routeViewMaps.values());
            params.put("refviews", refPSAppViewList);
            for (String viewid : allModalViewmaps.keySet()) {
                if (!allEmbeddedViewmaps.containsKey(viewid)) continue;
                allEmbeddedViewmaps.remove(viewid);
                embeddedViewmaps2.put(viewid, allModalViewmaps.get(viewid));
            }
            modalPSAppViewList.addAll(allModalViewmaps.values());
            params.put("modalviews", modalPSAppViewList);
            modalPSAppViewList2.addAll(allModalViewmaps2.values());
            params.put("modalviews2", modalPSAppViewList2);
            embeddedPSAppViewList.addAll(allEmbeddedViewmaps.values());
            params.put("embeddedviews", embeddedPSAppViewList);
            embeddedPSAppViewList2.addAll(embeddedViewmaps2.values());
            params.put("embeddedviews2", embeddedPSAppViewList2);
            if (this.iPSAppView instanceof IPSAppIndexView && ((IPSAppIndexView)this.iPSAppView).isDefaultPage()) {
                HashMap<String, IPSAppView> spRefViewMap = new HashMap<String, IPSAppView>();
                this.fillSPRefViews(this.iPSAppView, spRefViewMap);
                ArrayList<IPSAppView> spRefPSAppViewList = new ArrayList<IPSAppView>();
                if (!spRefViewMap.containsKey(this.iPSAppView.getId())) {
                    spRefViewMap.put(this.iPSAppView.getId(), this.iPSAppView);
                }
                spRefPSAppViewList.addAll(spRefViewMap.values());
                params.put("sprefviews", spRefPSAppViewList);
            }
        }
        String strFullClassName = this.iPSApplication.getPKGCodeName();
        if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPKGCodeName())) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".%1$s", (Object)this.getPSPFPubCode().getPKGCodeName());
        }
        if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
        }
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        strFullClassName = this.iPSApplication.getPKGCodeName();
        if (!StringHelper.IsNullOrEmpty((String)this.getPSPFPubCode().getPKGCodeName())) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".%1$s", (Object)this.getPSPFPubCode().getPKGCodeName());
        }
        if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
        }
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
        String strAliasName = this.iPSAppView.getFullCodeName().replace('.', '_').toLowerCase();
        params.put("viewaliasname", strAliasName);
        ArrayList<IPSAppViewRef> embedPSAppViewRefList = new ArrayList<IPSAppViewRef>();
        HashMap<String, IPSViewType> psViewTypeMap = new HashMap<String, IPSViewType>();
        HashMap<String, IPSAppView> psAppViewMap = new HashMap<String, IPSAppView>();
        HashMap<String, String> includeCssFileIdMap = new HashMap<String, String>();
        HashMap<String, String> includeJsFileIdMap = new HashMap<String, String>();
        String strCurIncludeCssFileId = "";
        String strCurIncludeJsFileId = "";
        Iterator psAppViewRefs = this.iPSAppView.getEmbeddedPSAppViewRefs(null);
        if (psAppViewRefs != null) {
            while (psAppViewRefs.hasNext()) {
                IPSAppViewRef iPSAppViewRef = (IPSAppViewRef)psAppViewRefs.next();
                psViewTypeMap.put(iPSAppViewRef.getRefPSAppView().getPSViewType().getId(), iPSAppViewRef.getRefPSAppView().getPSViewType());
                psAppViewMap.put(iPSAppViewRef.getRefPSAppView().getId(), iPSAppViewRef.getRefPSAppView());
                if (iPSAppViewRef.getRefPSAppView() instanceof IPSAppSubSysDEView) {
                    IPSAppSubSysDEView iPSAppSubSysDEView = (IPSAppSubSysDEView)iPSAppViewRef.getRefPSAppView();
                    IPSSubDEView ipsSubDEView = iPSAppSubSysDEView.getPSSubAppRef().getPSSubApp().getPSSubSys().getPSSubDEView(iPSAppSubSysDEView.getPSSubAppView().getPSSubDEViewId());
                    psViewTypeMap.put(ipsSubDEView.getPSViewType().getId(), ipsSubDEView.getPSViewType());
                    continue;
                }
                if (iPSAppViewRef.getEmbedId().indexOf("_") == -1) {
                    embedPSAppViewRefList.add(iPSAppViewRef);
                }
                String strIncludeCssFileId = "";
                String strIncludeJsFileId = "";
                strIncludeCssFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                strIncludeJsFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                IPSSubViewType iPSSubViewType = iPSAppViewRef.getRefPSAppView().getPSSubViewType();
                if (iPSSubViewType != null) {
                    if (iPSSubViewType.isExtendView()) {
                        if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                            strIncludeCssFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                            strIncludeCssFileId = String.valueOf(strIncludeCssFileId) + "_";
                            strIncludeCssFileId = String.valueOf(strIncludeCssFileId) + iPSSubViewType.getTypeCode();
                        } else if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                            strIncludeCssFileId = iPSSubViewType.getTypeCode();
                        }
                    }
                    if (iPSSubViewType.isExtendCtrl()) {
                        if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                            strIncludeJsFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                            strIncludeJsFileId = String.valueOf(strIncludeJsFileId) + "_";
                            strIncludeJsFileId = String.valueOf(strIncludeJsFileId) + iPSSubViewType.getTypeCode();
                        } else if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                            strIncludeJsFileId = iPSSubViewType.getTypeCode();
                        }
                    }
                }
                includeCssFileIdMap.put(strIncludeCssFileId, "");
                includeJsFileIdMap.put(strIncludeJsFileId, "");
            }
            psViewTypeMap.remove(this.iPSAppView.getPSViewType().getId());
            psAppViewMap.remove(this.iPSAppView.getId());
            strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
            strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
            IPSSubViewType iPSSubViewType = this.iPSAppView.getPSSubViewType();
            if (iPSSubViewType != null) {
                if (iPSSubViewType.isExtendView()) {
                    if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                        strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
                        strCurIncludeCssFileId = String.valueOf(strCurIncludeCssFileId) + "_";
                        strCurIncludeCssFileId = String.valueOf(strCurIncludeCssFileId) + iPSSubViewType.getTypeCode();
                    } else if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                        strCurIncludeCssFileId = iPSSubViewType.getTypeCode();
                    }
                }
                if (iPSSubViewType.isExtendCtrl()) {
                    if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                        strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
                        strCurIncludeJsFileId = String.valueOf(strCurIncludeJsFileId) + "_";
                        strCurIncludeJsFileId = String.valueOf(strCurIncludeJsFileId) + iPSSubViewType.getTypeCode();
                    } else if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                        strCurIncludeJsFileId = iPSSubViewType.getTypeCode();
                    }
                }
            }
            includeCssFileIdMap.remove(strCurIncludeCssFileId);
            includeJsFileIdMap.remove(strCurIncludeJsFileId);
        }
        ArrayList embedPSViewTypeList = new ArrayList();
        ArrayList embedPSAppViewList = new ArrayList();
        embedPSViewTypeList.addAll(psViewTypeMap.values());
        embedPSAppViewList.addAll(psAppViewMap.values());
        params.put("allembedviewtypes", embedPSViewTypeList);
        params.put("allembedviews", embedPSAppViewList);
        params.put("curembedviewrefs", embedPSAppViewRefList);
        ArrayList allCssFileList = new ArrayList();
        ArrayList allJsFileList = new ArrayList();
        allCssFileList.addAll(includeCssFileIdMap.keySet());
        allJsFileList.addAll(includeJsFileIdMap.keySet());
        params.put("allcssfiles", allCssFileList);
        params.put("alljsfiles", allJsFileList);
        params.put("curcssfile", strCurIncludeCssFileId);
        params.put("curjsfile", strCurIncludeJsFileId);
    }

    protected String getPSAppViewCodeName(IPSAppView iPSAppView) {
        if (StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLERBASE", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CSS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"VIEW_COMPONENT", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"MODAL_VIEW_COMPONENT", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"EMBEDDED_VIEW_COMPONENT", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"DEBUGHTML", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"REFVIEWS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"MODEL", (boolean)true) == 0) {
            String strFullName = iPSAppView.getFullCodeName();
            int nPos = strFullName.lastIndexOf(".");
            if (nPos != -1) {
                strFullName = StringHelper.Format((String)"%1$s.%2$s.%2$s", (Object)PSVue2FileNameMethod.replaceFullName(strFullName.substring(0, nPos)), (Object)PSVue2FileNameMethod.replaceFullName(strFullName.substring(nPos + 1)));
            }
            return strFullName;
        }
        return super.getPSAppViewCodeName(iPSAppView);
    }

    protected String generateCode(Map<String, Object> params2) throws Exception {
        if (params2 == null) {
            params2 = new HashMap<String, Object>();
        }
        params2.put("viewname", PSVue2FileNameMethod.replaceFullName(this.iPSAppView.getCodeName()));
        PSVue2TemplHelper.fillParams(params2);
        return super.generateCode(params2);
    }

    protected String generateCode(BaseDataEntity templData, String strCodeName, HashMap<String, Object> params) throws Exception {
        return super.generateCode(templData, strCodeName, params);
    }

    /*
     * Unable to fully structure code
     */
    protected void fillNGStates(IPSAppView iPSAppView, PSVue2StateImpl parentPSNGState, String strName, JSONObject viewParamJO, ArrayList<IPSNGState> psNGStateList, boolean bNext, HashMap<String, IPSNGState> psNGStateMap, int level) throws Exception {
        block12: {
            if (iPSAppView == null) {
                return;
            }
            psVue2StateImpl = new PSVue2StateImpl();
            psVue2StateImpl.init(parentPSNGState, strName);
            psVue2StateImpl.setLevel(level);
            psVue2StateImpl.setPSAppView(iPSAppView);
            psVue2StateImpl.setViewParamJO(viewParamJO);
            if (level == 1) {
                psNGStateList.add(psVue2StateImpl);
            }
            if (parentPSNGState != null) {
                parentPSNGState.addChildState(psVue2StateImpl);
            }
            psNGStateMap.put(strName, psVue2StateImpl);
            if (parentPSNGState != null && parentPSNGState.getLevel() >= 4 || level >= 4) {
                return;
            }
            if (iPSAppView == null || !bNext) break block12;
            psAppFuncs = iPSAppView.getPSAppFuncs();
            while (psAppFuncs.hasNext()) {
                psAppFunc = (IPSAppFunc)psAppFuncs.next();
                if (psAppFunc.getPSAppView() == null) continue;
                routeName = StringHelper.Format((String)"%1$s_%2$s", (Object)psAppFunc.getPSAppView().getPSAppModule().getCodeName(), (Object)psAppFunc.getPSAppView().getCodeName()).toLowerCase();
                if (!psAppFunc.getPSAppView().testViewUsage(1)) continue;
                this.fillNGStates(psAppFunc.getPSAppView(), psVue2StateImpl, routeName, null, psNGStateList, true, psNGStateMap, level + 1);
            }
            if (iPSAppView instanceof IPSAppExplorerView && (psAppViewRefs = iPSAppView.getPSAppViewRefs()) != null) {
                while (psAppViewRefs.hasNext()) {
                    iPSAppViewRef = (IPSAppViewRef)psAppViewRefs.next();
                    if (iPSAppViewRef.getRefPSAppView() == null) continue;
                    strRefMode = iPSAppViewRef.getName();
                    strStateName = "";
                    stateViewParamJO = null;
                    if (strRefMode.indexOf("EXPITEM:") != 0) continue;
                    strStateName = StringHelper.Format((String)"%1$s_%2$s", (Object)iPSAppViewRef.getRefPSAppView().getPSAppModule().getCodeName(), (Object)iPSAppViewRef.getRefPSAppView().getCodeName()).toLowerCase();
                    stateViewParamJO = viewParamJO;
                    if (!iPSAppViewRef.getRefPSAppView().testViewUsage(1)) continue;
                    this.fillNGStates(iPSAppViewRef.getRefPSAppView(), psVue2StateImpl, strStateName, stateViewParamJO, psNGStateList, true, psNGStateMap, level + 1);
                }
            }
            psAppViews = iPSAppView.getAllRelatedPSAppViews();
            while (psAppViews.hasNext()) {
                editView = (IPSAppView)psAppViews.next();
                if (editView instanceof IPSAppDERedirectView && (redirectViews = (iPSAppDERedirectView = (IPSAppDERedirectView)editView).getRedirectPSAppViews()) != null) ** GOTO lbl49
                continue;
lbl-1000:
                // 1 sources

                {
                    redirectView = (IPSAppView)redirectViews.next();
                    if (redirectView == null) continue;
                    strStateName = StringHelper.Format((String)"%1$s_%2$s", (Object)redirectView.getPSAppModule().getCodeName(), (Object)redirectView.getCodeName()).toLowerCase();
                    if (!redirectView.testViewUsage(1)) continue;
                    this.fillNGStates(redirectView, psVue2StateImpl, strStateName, null, psNGStateList, true, psNGStateMap, level + 1);
lbl49:
                    // 4 sources

                    ** while (redirectViews.hasNext())
                }
lbl50:
                // 1 sources

            }
            psControls = iPSAppView.getAllPSControls().iterator();
            if (psControls == null) break block12;
            while (psControls.hasNext()) {
                block13: {
                    iPSControl = (IPSControl)psControls.next();
                    if (!(iPSControl instanceof IPSDEDRCtrl)) break block13;
                    iPSDEDRCtrl = (IPSDEDRCtrl)iPSControl;
                    if (iPSDEDRCtrl.isIncludeMajor()) {
                        this.fillNGStates(null, psVue2StateImpl, "form", null, psNGStateList, true, psNGStateMap, level + 1);
                    }
                    if ((psDEDRCtrlItems = iPSDEDRCtrl.getPSDEDRCtrlItems()) != null) ** GOTO lbl65
                    continue;
lbl-1000:
                    // 1 sources

                    {
                        iPSDEDRCtrlItem = (IPSDEDRCtrlItem)psDEDRCtrlItems.next();
                        if (iPSDEDRCtrlItem.getPSAppView() == null || !iPSDEDRCtrlItem.getPSAppView().testViewUsage(1)) continue;
                        strStateName = StringHelper.Format((String)"%1$s_%2$s", (Object)iPSDEDRCtrlItem.getPSAppView().getPSAppModule().getCodeName(), (Object)iPSDEDRCtrlItem.getPSAppView().getCodeName()).toLowerCase();
                        this.fillNGStates(iPSDEDRCtrlItem.getPSAppView(), psVue2StateImpl, strStateName, iPSDEDRCtrlItem.getViewParamJO(), psNGStateList, true, psNGStateMap, level + 1);
lbl65:
                        // 3 sources

                        ** while (psDEDRCtrlItems.hasNext())
                    }
                }
                if (!(iPSControl instanceof IPSDEViewPanel) || (iPSDEViewPanel = (IPSDEViewPanel)iPSControl).getPSAppDEView() == null || !iPSDEViewPanel.getPSAppDEView().testViewUsage(1)) continue;
                strStateName = StringHelper.Format((String)"%1$s_%2$s", (Object)iPSDEViewPanel.getPSAppDEView().getPSAppModule().getCodeName(), (Object)iPSDEViewPanel.getPSAppDEView().getCodeName()).toLowerCase();
                this.fillNGStates((IPSAppView)iPSDEViewPanel.getPSAppDEView(), psVue2StateImpl, strStateName, null, psNGStateList, true, psNGStateMap, level + 1);
            }
        }
    }

    protected void fillAllModalPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> modalViewMap, int level) throws Exception {
        if (level >= 4) {
            return;
        }
        Iterator psAppViewRefLists = iPSAppView.getPSAppViewRefs();
        while (psAppViewRefLists.hasNext()) {
            int _index = level;
            IPSAppViewRef iPSAPPViewRef = (IPSAppViewRef)psAppViewRefLists.next();
            if (iPSAPPViewRef.getRefPSAppView() == null) continue;
            if (iPSAPPViewRef.getRefPSAppView().testViewUsage(2) && !modalViewMap.containsKey(iPSAPPViewRef.getRefPSAppView().getId())) {
                modalViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
            }
            this.fillAllModalPSAppViews(iPSAPPViewRef.getRefPSAppView(), modalViewMap, _index + 1);
        }
        Iterator psAppViewLists = iPSAppView.getAllRelatedPSAppViews();
        while (psAppViewLists.hasNext()) {
            int _index = level;
            IPSAppView psAppView = (IPSAppView)psAppViewLists.next();
            if (psAppView == null) continue;
            if (psAppView.testViewUsage(2) && !modalViewMap.containsKey(psAppView.getId())) {
                modalViewMap.put(psAppView.getId(), psAppView);
            }
            if (psAppView.isPickupView() && !modalViewMap.containsKey(psAppView.getId())) {
                modalViewMap.put(psAppView.getId(), psAppView);
            }
            this.fillAllModalPSAppViews(psAppView, modalViewMap, _index + 1);
        }
    }

    protected void fillEmbeddedPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> embeddedViewMap, int index) throws Exception {
        if (index >= 4) {
            return;
        }
        Iterator psAppViewRefLists = iPSAppView.getEmbeddedPSAppViewRefs("");
        while (psAppViewRefLists.hasNext()) {
            int _index = index;
            IPSAppViewRef iPSAPPViewRef = (IPSAppViewRef)psAppViewRefLists.next();
            if (iPSAPPViewRef.getRefPSAppView() == null || StringHelper.IsNullOrEmpty((String)iPSAPPViewRef.getEmbedId())) continue;
            if (iPSAPPViewRef.getRefPSAppView().testViewUsage(4) && !embeddedViewMap.containsKey(iPSAPPViewRef.getRefPSAppView().getId())) {
                embeddedViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
            }
            this.fillEmbeddedPSAppViews(iPSAPPViewRef.getRefPSAppView(), embeddedViewMap, _index);
        }
        Iterator psAppViewLists = iPSAppView.getAllRelatedPSAppViews();
        while (psAppViewLists.hasNext()) {
            int _index = index;
            IPSAppView psAppView = (IPSAppView)psAppViewLists.next();
            if (psAppView == null) continue;
            if (psAppView.testViewUsage(4) && !embeddedViewMap.containsKey(psAppView.getId())) {
                embeddedViewMap.put(psAppView.getId(), psAppView);
            }
            this.fillEmbeddedPSAppViews(psAppView, embeddedViewMap, _index + 1);
        }
    }

    protected void fillSPRefViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> spRefViewMap) throws Exception {
        Iterator psAppViewLists = iPSAppView.getAllRelatedPSAppViews();
        while (psAppViewLists.hasNext()) {
            IPSAppView psAppView = (IPSAppView)psAppViewLists.next();
            if (psAppView == null || spRefViewMap.containsKey(psAppView.getId())) continue;
            spRefViewMap.put(psAppView.getId(), psAppView);
            this.fillSPRefViews(psAppView, spRefViewMap);
        }
    }

    protected void addDynamicViewRefViews(HashMap<String, IPSAppView> refviews) throws Exception {
        Iterator psAppViews = this.iPSApplication.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = (IPSAppView)psAppViews.next();
            if (iPSAppView == null || refviews.containsKey(iPSAppView.getId()) || iPSAppView instanceof IPSAppDERedirectView) continue;
            if (iPSAppView instanceof IPSAppDEPickupView) {
                refviews.put(iPSAppView.getId(), iPSAppView);
            }
            if (iPSAppView instanceof PSAppDEPickupGridViewImpl) {
                refviews.put(iPSAppView.getId(), iPSAppView);
            }
            if (!(iPSAppView instanceof IPSAppDynaDEView) || iPSAppView.isRedirectView()) continue;
            refviews.put(iPSAppView.getId(), iPSAppView);
        }
    }

    protected boolean isOutputAllControls() {
        return true;
    }
}

