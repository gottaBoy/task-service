/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.Func.IPSAppFunc
 *  SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView
 *  SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView
 *  SA.SRFDA.PS.Core.App.View.IPSAppExplorerView
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.App.View.IPSAppViewRef
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
package SA.SRFDA.PS.Core.Pub.Angular;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.PF.IPSNGState;
import SA.SRFDA.PS.Core.PF.PSNGStateImpl;
import SA.SRFDA.PS.Core.Pub.Angular.PSAngularTemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.sf.json.JSONObject;

public class PSAngularViewCodePublisherImpl
extends PSPFViewCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSNGState> psNGStateList = null;
        if (StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SHELL_ROUTES_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SHELL_MODULE_TS", (boolean)true) == 0) {
            psNGStateList = new ArrayList<IPSNGState>();
            HashMap<String, IPSNGState> psNGStateMap = new HashMap<String, IPSNGState>();
            this.fillNGStates(this.iPSAppView, null, "", null, psNGStateList, true, psNGStateMap);
            params.put("ngstates", psNGStateList);
        }
        ArrayList<IPSAppView> embeddedPSAppViewList = null;
        ArrayList<IPSAppView> modalPSAppViewList = null;
        ArrayList<IPSAppView> allModalPSAppViewList = null;
        ArrayList refPSAppViewList = null;
        embeddedPSAppViewList = new ArrayList<IPSAppView>();
        this.fillEmbeddedPSAppViews(this.iPSAppView, embeddedPSAppViewList);
        params.put("embeddedviews", embeddedPSAppViewList);
        modalPSAppViewList = new ArrayList<IPSAppView>();
        this.fillModalPSAppViews(this.iPSAppView, modalPSAppViewList);
        params.put("modalviews", modalPSAppViewList);
        allModalPSAppViewList = new ArrayList<IPSAppView>();
        HashMap<String, IPSAppView> allModalViewmaps = new HashMap<String, IPSAppView>();
        this.fillAllModalPSAppViews(this.iPSAppView, allModalViewmaps, 0);
        if (allModalViewmaps.containsKey(this.iPSAppView.getId())) {
            allModalViewmaps.remove(this.iPSAppView.getId());
        }
        allModalPSAppViewList.addAll(allModalViewmaps.values());
        params.put("allmodalviews", allModalPSAppViewList);
        refPSAppViewList = new ArrayList();
        HashMap<String, IPSAppView> refViewMap = new HashMap<String, IPSAppView>();
        for (IPSAppView iPSAppView : embeddedPSAppViewList) {
            refViewMap.put(iPSAppView.getId(), iPSAppView);
        }
        for (IPSAppView iPSAppView : modalPSAppViewList) {
            refViewMap.put(iPSAppView.getId(), iPSAppView);
        }
        if (refViewMap.containsKey(this.iPSAppView.getId())) {
            refViewMap.remove(this.iPSAppView.getId());
        }
        refPSAppViewList.addAll(refViewMap.values());
        params.put("refviews", refPSAppViewList);
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
        if (StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER_BASE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SERVICE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CSS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"MODULE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SHELL_MODULE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"MODAL_SERVICE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SHELL_COMPONENT_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SHELL_ROUTES_TS", (boolean)true) == 0) {
            String strFullName = iPSAppView.getFullCodeName();
            int nPos = strFullName.lastIndexOf(".");
            if (nPos != -1) {
                strFullName = StringHelper.Format((String)"%1$s.%2$s.%2$s", (Object)this.replaceFullName(strFullName.substring(0, nPos)), (Object)this.replaceFullName(strFullName.substring(nPos + 1)));
            }
            return strFullName;
        }
        return super.getPSAppViewCodeName(iPSAppView);
    }

    private String replaceFullName(String strFullName) {
        strFullName = strFullName.replaceAll("_", "-");
        boolean state = false;
        String str = strFullName;
        StringBuilder strBuilder = new StringBuilder();
        if (Character.isUpperCase(str.charAt(0))) {
            strBuilder.append(str.substring(0, 1).toLowerCase());
            state = true;
        } else {
            strBuilder.append(str.substring(0, 1));
            state = false;
        }
        int i = 1;
        while (i < str.length()) {
            char chr = str.charAt(i);
            if (Character.isUpperCase(chr)) {
                if (state) {
                    strBuilder.append(str.substring(i, i + 1).toLowerCase());
                } else {
                    strBuilder.append("-");
                    strBuilder.append(str.substring(i, i + 1).toLowerCase());
                }
                state = true;
            } else {
                strBuilder.append(chr);
                state = false;
            }
            ++i;
        }
        String resultStr = strBuilder.toString();
        resultStr = resultStr.replaceAll("--", "-");
        resultStr = resultStr.replaceAll("---", "-");
        return resultStr;
    }

    protected String generateCode(Map<String, Object> params2) throws Exception {
        if (params2 == null) {
            params2 = new HashMap<String, Object>();
        }
        params2.put("viewname", this.replaceFullName(this.iPSAppView.getCodeName()));
        PSAngularTemplHelper.fillParams(params2);
        return super.generateCode(params2);
    }

    protected String generateCode(BaseDataEntity templData, String strCodeName, HashMap<String, Object> params) throws Exception {
        return super.generateCode(templData, strCodeName, params);
    }

    protected void fillNGStates(IPSAppView iPSAppView, IPSNGState parentPSNGState, String strName, JSONObject viewParamJO, ArrayList<IPSNGState> psNGStateList, boolean bNext, HashMap<String, IPSNGState> psNGStateMap) throws Exception {
        if (parentPSNGState != null && parentPSNGState.getLevel() >= 4) {
            return;
        }
        if (psNGStateMap.containsKey(strName)) {
            return;
        }
        PSNGStateImpl psNGStateImpl = new PSNGStateImpl();
        psNGStateImpl.init(null, strName);
        psNGStateImpl.setPSAppView(iPSAppView);
        psNGStateImpl.setIndex(psNGStateList.size());
        psNGStateImpl.setViewParamJO(viewParamJO);
        psNGStateList.add(psNGStateImpl);
        psNGStateMap.put(strName, psNGStateImpl);
        if (iPSAppView != null && bNext) {
            String strStateName;
            IPSAppView editView;
            Iterator psAppViews;
            JSONObject stateViewParamJO;
            String strStateName2;
            String strRefMode;
            IPSAppViewRef iPSAppViewRef;
            Iterator psAppViewRefs;
            Iterator psAppFuncs = iPSAppView.getPSAppFuncs();
            while (psAppFuncs.hasNext()) {
                IPSAppFunc psAppFunc = (IPSAppFunc)psAppFuncs.next();
                if (psAppFunc.getPSAppView() == null) continue;
                String routeName = psAppFunc.getCodeName();
                if (StringHelper.IsNullOrEmpty((String)routeName)) {
                    routeName = StringHelper.Format((String)"%1$s_%2$s", (Object)psAppFunc.getPSAppView().getPSAppModule().getCodeName(), (Object)psAppFunc.getPSAppView().getCodeName()).toLowerCase();
                }
                this.fillNGStates(psAppFunc.getPSAppView(), parentPSNGState, routeName, null, psNGStateList, false, psNGStateMap);
            }
            if (iPSAppView instanceof IPSAppDEMultiDataView && (psAppViewRefs = iPSAppView.getPSAppViewRefs()) != null) {
                while (psAppViewRefs.hasNext()) {
                    String strOpenMode;
                    iPSAppViewRef = (IPSAppViewRef)psAppViewRefs.next();
                    if (iPSAppViewRef.getRefPSAppView() == null) continue;
                    strRefMode = iPSAppViewRef.getName();
                    strStateName2 = "";
                    stateViewParamJO = null;
                    if (strRefMode.indexOf("NEWDATA:") == 0) {
                        strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
                        if (!StringHelper.IsNullOrEmpty((String)strOpenMode)) continue;
                        strStateName2 = StringHelper.Format((String)"new_%1$s", (Object)strRefMode.substring(8).replace(":", "__").replace("@", "__"));
                        stateViewParamJO = viewParamJO;
                    } else if (strRefMode.indexOf("EDITDATA:") == 0) {
                        strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
                        if (!StringHelper.IsNullOrEmpty((String)strOpenMode)) continue;
                        strStateName2 = StringHelper.Format((String)"edit_%1$s", (Object)strRefMode.substring(9).replace(":", "__").replace("@", "__"));
                    } else if (StringHelper.Compare((String)strRefMode, (String)"NEWDATA", (boolean)true) == 0) {
                        strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
                        if (!StringHelper.IsNullOrEmpty((String)strOpenMode)) continue;
                        strStateName2 = StringHelper.Format((String)"new");
                        stateViewParamJO = viewParamJO;
                    } else {
                        if (StringHelper.Compare((String)strRefMode, (String)"EDITDATA", (boolean)true) != 0 || !StringHelper.IsNullOrEmpty((String)(strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef)))) continue;
                        strStateName2 = StringHelper.Format((String)"edit");
                    }
                    strStateName2 = StringHelper.Format((String)"%1$s%2$s", (Object)strName, (Object)strStateName2);
                    this.fillNGStates(iPSAppViewRef.getRefPSAppView(), parentPSNGState, strStateName2, stateViewParamJO, psNGStateList, false, psNGStateMap);
                }
            }
            if (iPSAppView instanceof IPSAppExplorerView && (psAppViewRefs = iPSAppView.getPSAppViewRefs()) != null) {
                while (psAppViewRefs.hasNext()) {
                    iPSAppViewRef = (IPSAppViewRef)psAppViewRefs.next();
                    if (iPSAppViewRef.getRefPSAppView() == null) continue;
                    strRefMode = iPSAppViewRef.getName();
                    strStateName2 = "";
                    stateViewParamJO = null;
                    if (strRefMode.indexOf("EXPITEM:") != 0) continue;
                    strStateName2 = StringHelper.Format((String)"%1$s", (Object)strRefMode.substring(8).replace(":", "__").replace("@", "__"));
                    stateViewParamJO = viewParamJO;
                    this.fillNGStates(iPSAppViewRef.getRefPSAppView(), psNGStateImpl, strStateName2, stateViewParamJO, psNGStateList, false, psNGStateMap);
                }
            }
            if (iPSAppView instanceof IPSAppIndexView) {
                psAppViews = null;
                psAppViews = this.iPSApplication.isPubRefViewOnly() ? this.iPSApplication.getAllRefPSAppViews() : this.iPSApplication.getAllPSAppViews();
                while (psAppViews.hasNext()) {
                    editView = (IPSAppView)psAppViews.next();
                    if (editView.getViewType().indexOf("EDITVIEW") == -1 || editView.getViewType().indexOf("EDITVIEW9") != -1) continue;
                    strStateName = StringHelper.Format((String)"%1$s_%2$s", (Object)editView.getPSAppModule().getCodeName(), (Object)editView.getCodeName()).toLowerCase();
                    this.fillNGStates(editView, psNGStateImpl, strStateName, null, psNGStateList, false, psNGStateMap);
                }
            } else {
                psAppViews = iPSAppView.getAllRelatedPSAppViews();
                while (psAppViews.hasNext()) {
                    IPSAppDERedirectView iPSAppDERedirectView;
                    Iterator redirectViews;
                    editView = (IPSAppView)psAppViews.next();
                    if (editView.getViewType().indexOf("EDITVIEW") != -1 && editView.getViewType().indexOf("EDITVIEW9") == -1) {
                        strStateName = StringHelper.Format((String)"%1$s_%2$s", (Object)editView.getPSAppModule().getCodeName(), (Object)editView.getCodeName()).toLowerCase();
                        this.fillNGStates(editView, psNGStateImpl, strStateName, null, psNGStateList, false, psNGStateMap);
                        continue;
                    }
                    if (!(editView instanceof IPSAppDERedirectView) || (redirectViews = (iPSAppDERedirectView = (IPSAppDERedirectView)editView).getRedirectPSAppViews()) == null) continue;
                    while (redirectViews.hasNext()) {
                        IPSAppView redirectView = (IPSAppView)redirectViews.next();
                        String strStateName3 = StringHelper.Format((String)"%1$s_%2$s", (Object)redirectView.getPSAppModule().getCodeName(), (Object)redirectView.getCodeName()).toLowerCase();
                        this.fillNGStates(redirectView, psNGStateImpl, strStateName3, null, psNGStateList, false, psNGStateMap);
                    }
                }
            }
            Iterator psControls = iPSAppView.getAllPSControls().iterator();
            if (psControls != null) {
                while (psControls.hasNext()) {
                    IPSControl iPSControl = (IPSControl)psControls.next();
                    if (iPSControl instanceof IPSDEDRCtrl) {
                        Iterator psDEDRCtrlItems;
                        IPSDEDRCtrl iPSDEDRCtrl = (IPSDEDRCtrl)iPSControl;
                        if (iPSDEDRCtrl.isIncludeMajor()) {
                            this.fillNGStates(null, psNGStateImpl, "form", null, psNGStateList, false, psNGStateMap);
                        }
                        if ((psDEDRCtrlItems = iPSDEDRCtrl.getPSDEDRCtrlItems()) == null) continue;
                        while (psDEDRCtrlItems.hasNext()) {
                            IPSDEDRCtrlItem iPSDEDRCtrlItem = (IPSDEDRCtrlItem)psDEDRCtrlItems.next();
                            this.fillNGStates(iPSDEDRCtrlItem.getPSAppView(), psNGStateImpl, iPSDEDRCtrlItem.getName(), iPSDEDRCtrlItem.getViewParamJO(), psNGStateList, false, psNGStateMap);
                        }
                        continue;
                    }
                    if (!(iPSControl instanceof IPSDEViewPanel)) continue;
                    IPSDEViewPanel iPSDEViewPanel = (IPSDEViewPanel)iPSControl;
                    this.fillNGStates((IPSAppView)iPSDEViewPanel.getPSAppDEView(), psNGStateImpl, iPSDEViewPanel.getName(), null, psNGStateList, false, psNGStateMap);
                }
            }
        }
    }

    protected void fillEmbeddedPSAppViews(IPSAppView iPSAppView, ArrayList<IPSAppView> embeddedPSAppViewList) throws Exception {
        Iterator psAppViewRefLists = iPSAppView.getEmbeddedPSAppViewRefs("");
        HashMap<String, IPSAppView> embeddedViewMap = new HashMap<String, IPSAppView>();
        while (psAppViewRefLists.hasNext()) {
            IPSAppViewRef iPSAPPViewRef = (IPSAppViewRef)psAppViewRefLists.next();
            if (iPSAPPViewRef.getRefPSAppView() == null || StringHelper.IsNullOrEmpty((String)iPSAPPViewRef.getEmbedId()) || iPSAPPViewRef.getRefPSAppView().isPickupView() || StringHelper.Compare((String)iPSAPPViewRef.getRefPSAppView().getOpenMode(), (String)"POPUPMODAL", (boolean)true) == 0 || iPSAPPViewRef.getEmbedId().indexOf("_") != -1) continue;
            embeddedViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
        }
        if (embeddedViewMap.containsKey(iPSAppView.getId())) {
            embeddedViewMap.remove(iPSAppView.getId());
        }
        embeddedPSAppViewList.addAll(embeddedViewMap.values());
    }

    protected void fillModalPSAppViews(IPSAppView iPSAppView, ArrayList<IPSAppView> modalPSAppViewList) throws Exception {
        Iterator psAppViewRefLists = iPSAppView.getPSAppViewRefs();
        HashMap<String, IPSAppView> modalViewMap = new HashMap<String, IPSAppView>();
        while (psAppViewRefLists.hasNext()) {
            IPSAppViewRef iPSAPPViewRef = (IPSAppViewRef)psAppViewRefLists.next();
            if (iPSAPPViewRef.getRefPSAppView() == null || StringHelper.Compare((String)iPSAPPViewRef.getRealOpenMode(), (String)"POPUP", (boolean)true) != 0 && StringHelper.Compare((String)iPSAPPViewRef.getRealOpenMode(), (String)"POPUPMODAL", (boolean)true) != 0) continue;
            modalViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
        }
        Iterator psAppViewLists = iPSAppView.getAllRelatedPSAppViews();
        while (psAppViewLists.hasNext()) {
            IPSAppView psAppView = (IPSAppView)psAppViewLists.next();
            if (psAppView == null) continue;
            if (StringHelper.Compare((String)psAppView.getOpenMode(), (String)"POPUP", (boolean)true) == 0 || StringHelper.Compare((String)psAppView.getOpenMode(), (String)"POPUPMODAL", (boolean)true) == 0) {
                modalViewMap.put(psAppView.getId(), psAppView);
                continue;
            }
            if (!psAppView.isPickupView()) continue;
            modalViewMap.put(psAppView.getId(), psAppView);
        }
        if (modalViewMap.containsKey(iPSAppView.getId())) {
            modalViewMap.remove(iPSAppView.getId());
        }
        modalPSAppViewList.addAll(modalViewMap.values());
    }

    protected void fillAllModalPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> modalViewMap, int level) throws Exception {
        if (level > 3) {
            return;
        }
        Iterator psAppViewRefLists = iPSAppView.getPSAppViewRefs();
        while (psAppViewRefLists.hasNext()) {
            IPSAppViewRef iPSAPPViewRef = (IPSAppViewRef)psAppViewRefLists.next();
            if (iPSAPPViewRef.getRefPSAppView() == null || StringHelper.Compare((String)iPSAPPViewRef.getRealOpenMode(), (String)"POPUP", (boolean)true) != 0 && StringHelper.Compare((String)iPSAPPViewRef.getRealOpenMode(), (String)"POPUPMODAL", (boolean)true) != 0 || modalViewMap.containsKey(iPSAPPViewRef.getRefPSAppView().getId())) continue;
            modalViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
            this.fillAllModalPSAppViews(iPSAPPViewRef.getRefPSAppView(), modalViewMap, level + 1);
        }
        Iterator psAppViewLists = iPSAppView.getAllRelatedPSAppViews();
        while (psAppViewLists.hasNext()) {
            IPSAppView psAppView = (IPSAppView)psAppViewLists.next();
            if (psAppView == null) continue;
            if (!(StringHelper.Compare((String)psAppView.getOpenMode(), (String)"POPUP", (boolean)true) != 0 && StringHelper.Compare((String)psAppView.getOpenMode(), (String)"POPUPMODAL", (boolean)true) != 0 || modalViewMap.containsKey(psAppView.getId()))) {
                modalViewMap.put(psAppView.getId(), psAppView);
                this.fillAllModalPSAppViews(psAppView, modalViewMap, level + 1);
                continue;
            }
            if (!psAppView.isPickupView()) continue;
            modalViewMap.put(psAppView.getId(), psAppView);
        }
    }

    protected boolean isOutputAllControls() {
        return true;
    }
}

