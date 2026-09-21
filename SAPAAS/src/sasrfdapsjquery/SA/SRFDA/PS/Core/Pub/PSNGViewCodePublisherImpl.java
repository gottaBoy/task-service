/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView
 *  SA.SRFDA.PS.Core.App.View.IPSAppExplorerView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.App.View.IPSAppViewRef
 *  SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl
 *  SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel
 *  SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl
 *  SA.SRFDA.PS.Core.Res.IPSSubViewType
 *  SA.SRFDA.PS.Core.View.IPSViewType
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.PF.IPSNGState;
import SA.SRFDA.PS.Core.PF.PSNGStateImpl;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.sf.json.JSONObject;

public class PSNGViewCodePublisherImpl
extends PSPFViewCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSSubViewType iPSSubViewType;
        String strIncludeJsFileId;
        String strIncludeCssFileId;
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSNGState> psNGStateList = null;
        if (StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0) {
            psNGStateList = new ArrayList<IPSNGState>();
            this.fillNGStates(this.iPSAppView, null, "d", null, psNGStateList);
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
                if (psAppViewMap.containsKey(iPSAppViewRef.getRefPSAppView().getId())) continue;
                psAppViewMap.put(iPSAppViewRef.getRefPSAppView().getId(), iPSAppViewRef.getRefPSAppView());
                psViewTypeMap.put(iPSAppViewRef.getRefPSAppView().getPSViewType().getId(), iPSAppViewRef.getRefPSAppView().getPSViewType());
                strIncludeCssFileId = "";
                strIncludeJsFileId = "";
                strIncludeCssFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                strIncludeJsFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                iPSSubViewType = iPSAppViewRef.getRefPSAppView().getPSSubViewType();
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
        }
        if (psNGStateList != null) {
            params.put("ngstates", psNGStateList);
            for (IPSNGState iPSNGState : psNGStateList) {
                if (iPSNGState.getPSAppView() == null || psAppViewMap.containsKey(iPSNGState.getPSAppView().getId())) continue;
                psAppViewMap.put(iPSNGState.getPSAppView().getId(), iPSNGState.getPSAppView());
                strIncludeCssFileId = "";
                strIncludeJsFileId = "";
                strIncludeCssFileId = iPSNGState.getPSAppView().getPSViewType().getId();
                strIncludeJsFileId = iPSNGState.getPSAppView().getPSViewType().getId();
                iPSSubViewType = iPSNGState.getPSAppView().getPSSubViewType();
                if (iPSSubViewType != null) {
                    if (iPSSubViewType.isExtendView()) {
                        if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                            strIncludeCssFileId = iPSNGState.getPSAppView().getPSViewType().getId();
                            strIncludeCssFileId = String.valueOf(strIncludeCssFileId) + "_";
                            strIncludeCssFileId = String.valueOf(strIncludeCssFileId) + iPSSubViewType.getTypeCode();
                        } else if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                            strIncludeCssFileId = iPSSubViewType.getTypeCode();
                        }
                    }
                    if (iPSSubViewType.isExtendCtrl()) {
                        if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                            strIncludeJsFileId = iPSNGState.getPSAppView().getPSViewType().getId();
                            strIncludeJsFileId = String.valueOf(strIncludeJsFileId) + "_";
                            strIncludeJsFileId = String.valueOf(strIncludeJsFileId) + iPSSubViewType.getTypeCode();
                        } else if (StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                            strIncludeJsFileId = iPSSubViewType.getTypeCode();
                        }
                    }
                }
                includeCssFileIdMap.put(strIncludeCssFileId, "");
                includeJsFileIdMap.put(strIncludeJsFileId, "");
                Iterator psAppViewRefs2 = iPSNGState.getPSAppView().getEmbeddedPSAppViewRefs(null);
                if (psAppViewRefs2 == null) continue;
                while (psAppViewRefs2.hasNext()) {
                    IPSAppViewRef iPSAppViewRef = (IPSAppViewRef)psAppViewRefs2.next();
                    if (psAppViewMap.containsKey(iPSAppViewRef.getRefPSAppView().getId())) continue;
                    psAppViewMap.put(iPSAppViewRef.getRefPSAppView().getId(), iPSAppViewRef.getRefPSAppView());
                    psViewTypeMap.put(iPSAppViewRef.getRefPSAppView().getPSViewType().getId(), iPSAppViewRef.getRefPSAppView().getPSViewType());
                    String strIncludeCssFileId2 = "";
                    String strIncludeJsFileId2 = "";
                    strIncludeCssFileId2 = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                    strIncludeJsFileId2 = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                    IPSSubViewType iPSSubViewType2 = iPSAppViewRef.getRefPSAppView().getPSSubViewType();
                    if (iPSSubViewType2 != null) {
                        if (iPSSubViewType2.isExtendView()) {
                            if (StringHelper.Compare((String)iPSSubViewType2.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                                strIncludeCssFileId2 = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                                strIncludeCssFileId2 = String.valueOf(strIncludeCssFileId2) + "_";
                                strIncludeCssFileId2 = String.valueOf(strIncludeCssFileId2) + iPSSubViewType2.getTypeCode();
                            } else if (StringHelper.Compare((String)iPSSubViewType2.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                                strIncludeCssFileId2 = iPSSubViewType2.getTypeCode();
                            }
                        }
                        if (iPSSubViewType2.isExtendCtrl()) {
                            if (StringHelper.Compare((String)iPSSubViewType2.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                                strIncludeJsFileId2 = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                                strIncludeJsFileId2 = String.valueOf(strIncludeJsFileId2) + "_";
                                strIncludeJsFileId2 = String.valueOf(strIncludeJsFileId2) + iPSSubViewType2.getTypeCode();
                            } else if (StringHelper.Compare((String)iPSSubViewType2.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                                strIncludeJsFileId2 = iPSSubViewType2.getTypeCode();
                            }
                        }
                    }
                    includeCssFileIdMap.put(strIncludeCssFileId2, "");
                    includeJsFileIdMap.put(strIncludeJsFileId2, "");
                }
            }
        }
        psViewTypeMap.remove(this.iPSAppView.getPSViewType().getId());
        psAppViewMap.remove(this.iPSAppView.getId());
        strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
        strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
        IPSSubViewType iPSSubViewType3 = this.iPSAppView.getPSSubViewType();
        if (iPSSubViewType3 != null) {
            if (iPSSubViewType3.isExtendView()) {
                if (StringHelper.Compare((String)iPSSubViewType3.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                    strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
                    strCurIncludeCssFileId = String.valueOf(strCurIncludeCssFileId) + "_";
                    strCurIncludeCssFileId = String.valueOf(strCurIncludeCssFileId) + iPSSubViewType3.getTypeCode();
                } else if (StringHelper.Compare((String)iPSSubViewType3.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                    strCurIncludeCssFileId = iPSSubViewType3.getTypeCode();
                }
            }
            if (iPSSubViewType3.isExtendCtrl()) {
                if (StringHelper.Compare((String)iPSSubViewType3.getNameMode(), (String)"APPEND", (boolean)true) == 0) {
                    strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
                    strCurIncludeJsFileId = String.valueOf(strCurIncludeJsFileId) + "_";
                    strCurIncludeJsFileId = String.valueOf(strCurIncludeJsFileId) + iPSSubViewType3.getTypeCode();
                } else if (StringHelper.Compare((String)iPSSubViewType3.getNameMode(), (String)"REPLACE", (boolean)true) == 0) {
                    strCurIncludeJsFileId = iPSSubViewType3.getTypeCode();
                }
            }
        }
        includeCssFileIdMap.remove(strCurIncludeCssFileId);
        includeJsFileIdMap.remove(strCurIncludeJsFileId);
        ArrayList embedPSAppViewList = new ArrayList();
        embedPSAppViewList.addAll(psAppViewMap.values());
        params.put("allembedviews", embedPSAppViewList);
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
        if (StringHelper.Compare((String)this.getPSPFPubCode().getFileNameExt(), (String)".jsp", (boolean)true) == 0) {
            return super.getPSAppViewCodeName(iPSAppView).toLowerCase();
        }
        if (StringHelper.Compare((String)this.getPSPFPubCode().getFileNameExt(), (String)".js", (boolean)true) == 0) {
            return super.getPSAppViewCodeName(iPSAppView).toLowerCase();
        }
        return super.getPSAppViewCodeName(iPSAppView);
    }

    protected String generateCode(BaseDataEntity templData, String strCodeName, HashMap<String, Object> params) throws Exception {
        return super.generateCode(templData, strCodeName, params);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void fillNGStates(IPSAppView iPSAppView, IPSNGState parentPSNGState, String strName, JSONObject viewParamJO, ArrayList<IPSNGState> psNGStateList) throws Exception {
        Iterator psControls;
        JSONObject stateViewParamJO;
        String strStateName;
        String strRefMode;
        IPSAppViewRef iPSAppViewRef;
        Iterator psAppViewRefs;
        if (parentPSNGState != null && parentPSNGState.getLevel() >= 4) {
            return;
        }
        PSNGStateImpl psNGStateImpl = new PSNGStateImpl();
        psNGStateImpl.init(parentPSNGState, strName);
        psNGStateImpl.setPSAppView(iPSAppView);
        psNGStateImpl.setIndex(psNGStateList.size());
        psNGStateImpl.setViewParamJO(viewParamJO);
        psNGStateList.add(psNGStateImpl);
        if (iPSAppView == null) return;
        if (iPSAppView instanceof IPSAppDEMultiDataView && (psAppViewRefs = iPSAppView.getPSAppViewRefs()) != null) {
            while (psAppViewRefs.hasNext()) {
                String strOpenMode;
                iPSAppViewRef = (IPSAppViewRef)psAppViewRefs.next();
                if (iPSAppViewRef.getRefPSAppView() == null) continue;
                strRefMode = iPSAppViewRef.getName();
                strStateName = "";
                stateViewParamJO = null;
                if (strRefMode.indexOf("NEWDATA:") == 0) {
                    strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
                    if (!StringHelper.IsNullOrEmpty((String)strOpenMode)) continue;
                    strStateName = StringHelper.Format((String)"new_%1$s", (Object)strRefMode.substring(8).replace(":", "__").replace("@", "__"));
                    stateViewParamJO = viewParamJO;
                } else if (strRefMode.indexOf("EDITDATA:") == 0) {
                    strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
                    if (!StringHelper.IsNullOrEmpty((String)strOpenMode)) continue;
                    strStateName = StringHelper.Format((String)"edit_%1$s", (Object)strRefMode.substring(9).replace(":", "__").replace("@", "__"));
                } else if (StringHelper.Compare((String)strRefMode, (String)"NEWDATA", (boolean)true) == 0) {
                    strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
                    if (!StringHelper.IsNullOrEmpty((String)strOpenMode)) continue;
                    strStateName = StringHelper.Format((String)"new");
                    stateViewParamJO = viewParamJO;
                } else {
                    if (StringHelper.Compare((String)strRefMode, (String)"EDITDATA", (boolean)true) != 0 || !StringHelper.IsNullOrEmpty((String)(strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef)))) continue;
                    strStateName = StringHelper.Format((String)"edit");
                }
                strStateName = StringHelper.Format((String)"%1$s$%2$s", (Object)strName, (Object)strStateName);
                this.fillNGStates(iPSAppViewRef.getRefPSAppView(), parentPSNGState, strStateName, stateViewParamJO, psNGStateList);
            }
        }
        if (iPSAppView instanceof IPSAppExplorerView && (psAppViewRefs = iPSAppView.getPSAppViewRefs()) != null) {
            while (psAppViewRefs.hasNext()) {
                iPSAppViewRef = (IPSAppViewRef)psAppViewRefs.next();
                if (iPSAppViewRef.getRefPSAppView() == null) continue;
                strRefMode = iPSAppViewRef.getName();
                strStateName = "";
                stateViewParamJO = null;
                if (strRefMode.indexOf("EXPITEM:") != 0) continue;
                strStateName = StringHelper.Format((String)"%1$s", (Object)strRefMode.substring(8).replace(":", "__").replace("@", "__"));
                stateViewParamJO = viewParamJO;
                this.fillNGStates(iPSAppViewRef.getRefPSAppView(), psNGStateImpl, strStateName, stateViewParamJO, psNGStateList);
            }
        }
        if ((psControls = iPSAppView.getPSControls()) == null) return;
        while (psControls.hasNext()) {
            IPSControl iPSControl = (IPSControl)psControls.next();
            if (iPSControl instanceof IPSDEDRCtrl) {
                Iterator psDEDRCtrlItems;
                IPSDEDRCtrl iPSDEDRCtrl = (IPSDEDRCtrl)iPSControl;
                if (iPSDEDRCtrl.isIncludeMajor()) {
                    this.fillNGStates(null, psNGStateImpl, "form", null, psNGStateList);
                }
                if ((psDEDRCtrlItems = iPSDEDRCtrl.getPSDEDRCtrlItems()) == null) continue;
                while (psDEDRCtrlItems.hasNext()) {
                    IPSDEDRCtrlItem iPSDEDRCtrlItem = (IPSDEDRCtrlItem)psDEDRCtrlItems.next();
                    this.fillNGStates(iPSDEDRCtrlItem.getPSAppView(), psNGStateImpl, iPSDEDRCtrlItem.getName(), iPSDEDRCtrlItem.getViewParamJO(), psNGStateList);
                }
                continue;
            }
            if (!(iPSControl instanceof IPSDEViewPanel)) continue;
            IPSDEViewPanel iPSDEViewPanel = (IPSDEViewPanel)iPSControl;
            this.fillNGStates((IPSAppView)iPSDEViewPanel.getPSAppDEView(), psNGStateImpl, iPSDEViewPanel.getName(), null, psNGStateList);
        }
    }
}

