package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.PF.IPSNGState;
import SA.SRFDA.PS.Core.PF.PSVue2StateImpl;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;
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

public class PSVue2ViewCodePublisherImpl extends PSPFViewCodePublisherImpl {
   @Override
   protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
      super.onFillGenerateCodeParams(params);
      ArrayList<IPSNGState> psNGStateList = null;
      if (StringHelper.Compare(this.getPSPFPubCode().getName(), "DEBUGHTML", true) == 0
         || StringHelper.Compare(this.getPSPFPubCode().getName(), "HTML", true) == 0
         || StringHelper.Compare(this.getPSPFPubCode().getName(), "REFVIEWS", true) == 0) {
         psNGStateList = new ArrayList<>();
         HashMap<String, IPSNGState> psNGStateMap = new HashMap<>();
         this.fillNGStates(this.iPSAppView, null, "", null, psNGStateList, true, psNGStateMap, 0);
         Collections.reverse(psNGStateList);
         params.put("vue2states", psNGStateList);
         ArrayList<IPSAppView> modalPSAppViewList = new ArrayList<>();
         HashMap<String, IPSAppView> allModalViewmaps = new HashMap<>();
         this.fillAllModalPSAppViews(this.iPSAppView, allModalViewmaps, 0);
         if (allModalViewmaps.containsKey(this.iPSAppView.getId())) {
            allModalViewmaps.remove(this.iPSAppView.getId());
         }

         ArrayList<IPSAppView> embeddedPSAppViewList = new ArrayList<>();
         HashMap<String, IPSAppView> embeddedViewmaps = new HashMap<>();
         this.fillEmbeddedPSAppViews(this.iPSAppView, embeddedViewmaps, 0);
         if (embeddedViewmaps.containsKey(this.iPSAppView.getId())) {
            embeddedViewmaps.remove(this.iPSAppView.getId());
         }

         ArrayList<IPSAppView> refPSAppViewList = new ArrayList<>();
         HashMap<String, IPSAppView> refViewMap = new HashMap<>();
         ArrayList<IPSAppView> modalPSAppViewList2 = new ArrayList<>();
         HashMap<String, IPSAppView> allModalViewmaps2 = new HashMap<>();
         ArrayList<IPSAppView> embeddedPSAppViewList2 = new ArrayList<>();
         HashMap<String, IPSAppView> embeddedViewmaps2 = new HashMap<>();

         for (IPSNGState iPSNGState : psNGStateMap.values()) {
            IPSAppView iPSAppView = iPSNGState.getPSAppView();
            if (iPSAppView != null && !refViewMap.containsKey(iPSAppView.getId())) {
               if (allModalViewmaps.containsKey(iPSAppView.getId())) {
                  allModalViewmaps2.put(iPSAppView.getId(), iPSAppView);
                  allModalViewmaps.remove(iPSAppView.getId());
               }

               if (embeddedViewmaps.containsKey(iPSAppView.getId())) {
                  embeddedViewmaps2.put(iPSAppView.getId(), iPSAppView);
                  embeddedViewmaps.remove(iPSAppView.getId());
               }

               refViewMap.put(iPSAppView.getId(), iPSAppView);
            }
         }

         if (refViewMap.containsKey(this.iPSAppView.getId())) {
            refViewMap.remove(this.iPSAppView.getId());
         }

         refPSAppViewList.addAll(refViewMap.values());
         params.put("refviews", refPSAppViewList);

         for (String viewid : allModalViewmaps.keySet()) {
            if (embeddedViewmaps.containsKey(viewid)) {
               embeddedViewmaps.remove(viewid);
               embeddedViewmaps2.put(viewid, allModalViewmaps.get(viewid));
            }
         }

         modalPSAppViewList.addAll(allModalViewmaps.values());
         params.put("modalviews", modalPSAppViewList);
         modalPSAppViewList2.addAll(allModalViewmaps2.values());
         params.put("modalviews2", modalPSAppViewList2);
         embeddedPSAppViewList.addAll(embeddedViewmaps.values());
         params.put("embeddedviews", embeddedPSAppViewList);
         embeddedPSAppViewList2.addAll(embeddedViewmaps2.values());
         params.put("embeddedviews2", embeddedPSAppViewList2);
         ArrayList<IPSAppView> spRefPSAppViewList = new ArrayList<>();
         if (this.iPSAppView instanceof IPSAppIndexView && ((IPSAppIndexView)this.iPSAppView).isDefaultPage()) {
            HashMap<String, IPSAppView> spRefViewMap = new HashMap<>();
            this.fillSPRefViews(this.iPSAppView, spRefViewMap);
            if (!spRefViewMap.containsKey(this.iPSAppView.getId())) {
               spRefViewMap.put(this.iPSAppView.getId(), this.iPSAppView);
            }

            spRefPSAppViewList.addAll(spRefViewMap.values());
         }

         params.put("sprefviews", spRefPSAppViewList);
      }

      String strFullClassName = this.iPSApplication.getPKGCodeName();
      if (!StringHelper.IsNullOrEmpty(this.getPSPFPubCode().getPKGCodeName())) {
         strFullClassName = strFullClassName + StringHelper.Format(".%1$s", this.getPSPFPubCode().getPKGCodeName());
      }

      if (!StringHelper.IsNullOrEmpty(strFullClassName)) {
         strFullClassName = strFullClassName + StringHelper.Format(".");
      }

      HashMap<String, String> requireClassMap = new HashMap<>();
      ArrayList<String> requireClasses = new ArrayList<>();
      strFullClassName = this.iPSApplication.getPKGCodeName();
      if (!StringHelper.IsNullOrEmpty(this.getPSPFPubCode().getPKGCodeName())) {
         strFullClassName = strFullClassName + StringHelper.Format(".%1$s", this.getPSPFPubCode().getPKGCodeName());
      }

      if (!StringHelper.IsNullOrEmpty(strFullClassName)) {
         strFullClassName = strFullClassName + StringHelper.Format(".");
      }

      requireClasses.addAll(requireClassMap.keySet());
      params.put("requires", requireClasses);
      String strAliasName = this.iPSAppView.getFullCodeName().replace('.', '_').toLowerCase();
      params.put("viewaliasname", strAliasName);
      ArrayList<IPSAppViewRef> embedPSAppViewRefList = new ArrayList<>();
      HashMap<String, IPSViewType> psViewTypeMap = new HashMap<>();
      HashMap<String, IPSAppView> psAppViewMap = new HashMap<>();
      HashMap<String, String> includeCssFileIdMap = new HashMap<>();
      HashMap<String, String> includeJsFileIdMap = new HashMap<>();
      String strCurIncludeCssFileId = "";
      String strCurIncludeJsFileId = "";
      Iterator<IPSAppViewRef> psAppViewRefs = this.iPSAppView.getEmbeddedPSAppViewRefs(null);
      if (psAppViewRefs != null) {
         while (psAppViewRefs.hasNext()) {
            IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
            psViewTypeMap.put(iPSAppViewRef.getRefPSAppView().getPSViewType().getId(), iPSAppViewRef.getRefPSAppView().getPSViewType());
            psAppViewMap.put(iPSAppViewRef.getRefPSAppView().getId(), iPSAppViewRef.getRefPSAppView());
            if (iPSAppViewRef.getRefPSAppView() instanceof IPSAppSubSysDEView) {
               IPSAppSubSysDEView iPSAppSubSysDEView = (IPSAppSubSysDEView)iPSAppViewRef.getRefPSAppView();
               IPSSubDEView ipsSubDEView = iPSAppSubSysDEView.getPSSubAppRef()
                  .getPSSubApp()
                  .getPSSubSys()
                  .getPSSubDEView(iPSAppSubSysDEView.getPSSubAppView().getPSSubDEViewId());
               psViewTypeMap.put(ipsSubDEView.getPSViewType().getId(), ipsSubDEView.getPSViewType());
            } else {
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
                     if (StringHelper.Compare(iPSSubViewType.getNameMode(), "APPEND", true) == 0) {
                        strIncludeCssFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                        strIncludeCssFileId = strIncludeCssFileId + "_";
                        strIncludeCssFileId = strIncludeCssFileId + iPSSubViewType.getTypeCode();
                     } else if (StringHelper.Compare(iPSSubViewType.getNameMode(), "REPLACE", true) == 0) {
                        strIncludeCssFileId = iPSSubViewType.getTypeCode();
                     }
                  }

                  if (iPSSubViewType.isExtendCtrl()) {
                     if (StringHelper.Compare(iPSSubViewType.getNameMode(), "APPEND", true) == 0) {
                        strIncludeJsFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
                        strIncludeJsFileId = strIncludeJsFileId + "_";
                        strIncludeJsFileId = strIncludeJsFileId + iPSSubViewType.getTypeCode();
                     } else if (StringHelper.Compare(iPSSubViewType.getNameMode(), "REPLACE", true) == 0) {
                        strIncludeJsFileId = iPSSubViewType.getTypeCode();
                     }
                  }
               }

               includeCssFileIdMap.put(strIncludeCssFileId, "");
               includeJsFileIdMap.put(strIncludeJsFileId, "");
            }
         }

         psViewTypeMap.remove(this.iPSAppView.getPSViewType().getId());
         psAppViewMap.remove(this.iPSAppView.getId());
         strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
         strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
         IPSSubViewType iPSSubViewType = this.iPSAppView.getPSSubViewType();
         if (iPSSubViewType != null) {
            if (iPSSubViewType.isExtendView()) {
               if (StringHelper.Compare(iPSSubViewType.getNameMode(), "APPEND", true) == 0) {
                  strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
                  strCurIncludeCssFileId = strCurIncludeCssFileId + "_";
                  strCurIncludeCssFileId = strCurIncludeCssFileId + iPSSubViewType.getTypeCode();
               } else if (StringHelper.Compare(iPSSubViewType.getNameMode(), "REPLACE", true) == 0) {
                  strCurIncludeCssFileId = iPSSubViewType.getTypeCode();
               }
            }

            if (iPSSubViewType.isExtendCtrl()) {
               if (StringHelper.Compare(iPSSubViewType.getNameMode(), "APPEND", true) == 0) {
                  strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
                  strCurIncludeJsFileId = strCurIncludeJsFileId + "_";
                  strCurIncludeJsFileId = strCurIncludeJsFileId + iPSSubViewType.getTypeCode();
               } else if (StringHelper.Compare(iPSSubViewType.getNameMode(), "REPLACE", true) == 0) {
                  strCurIncludeJsFileId = iPSSubViewType.getTypeCode();
               }
            }
         }

         includeCssFileIdMap.remove(strCurIncludeCssFileId);
         includeJsFileIdMap.remove(strCurIncludeJsFileId);
      }

      ArrayList<IPSViewType> embedPSViewTypeList = new ArrayList<>();
      ArrayList<IPSAppView> embedPSAppViewList = new ArrayList<>();
      embedPSViewTypeList.addAll(psViewTypeMap.values());
      embedPSAppViewList.addAll(psAppViewMap.values());
      params.put("allembedviewtypes", embedPSViewTypeList);
      params.put("allembedviews", embedPSAppViewList);
      params.put("curembedviewrefs", embedPSAppViewRefList);
      ArrayList<String> allCssFileList = new ArrayList<>();
      ArrayList<String> allJsFileList = new ArrayList<>();
      allCssFileList.addAll(includeCssFileIdMap.keySet());
      allJsFileList.addAll(includeJsFileIdMap.keySet());
      params.put("allcssfiles", allCssFileList);
      params.put("alljsfiles", allJsFileList);
      params.put("curcssfile", strCurIncludeCssFileId);
      params.put("curjsfile", strCurIncludeJsFileId);
   }

   @Override
   protected String getPSAppViewCodeName(IPSAppView iPSAppView) {
      if (StringHelper.Compare(this.getPSPFPubCode().getName(), "CONTROLLER", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "CONTROLLERBASE", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "CSS", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "VIEW_COMPONENT", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "MODAL_VIEW_COMPONENT", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "EMBEDDED_VIEW_COMPONENT", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "HTML", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "DEBUGHTML", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "REFVIEWS", true) != 0
         && StringHelper.Compare(this.getPSPFPubCode().getName(), "MODEL", true) != 0) {
         return super.getPSAppViewCodeName(iPSAppView);
      }

      String strFullName = iPSAppView.getFullCodeName();
      int nPos = strFullName.lastIndexOf(".");
      if (nPos != -1) {
         strFullName = StringHelper.Format(
            "%1$s.%2$s.%2$s",
            PSVue2FileNameMethod.replaceFullName(strFullName.substring(0, nPos)),
            PSVue2FileNameMethod.replaceFullName(strFullName.substring(nPos + 1))
         );
      }

      return strFullName;
   }

   @Override
   protected String generateCode(Map<String, Object> params2) throws Exception {
      if (params2 == null) {
         params2 = new HashMap<>();
      }

      params2.put("viewname", PSVue2FileNameMethod.replaceFullName(this.iPSAppView.getCodeName()));
      PSVue2TemplHelper.fillParams(params2);
      return super.generateCode(params2);
   }

   @Override
   protected String generateCode(BaseDataEntity templData, String strCodeName, HashMap<String, Object> params) throws Exception {
      return super.generateCode(templData, strCodeName, params);
   }

   protected void fillNGStates(
      IPSAppView iPSAppView,
      PSVue2StateImpl parentPSNGState,
      String strName,
      JSONObject viewParamJO,
      ArrayList<IPSNGState> psNGStateList,
      boolean bNext,
      HashMap<String, IPSNGState> psNGStateMap,
      int level
   ) throws Exception {
      if (iPSAppView != null) {
         PSVue2StateImpl psVue2StateImpl = new PSVue2StateImpl();
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
         if ((parentPSNGState == null || parentPSNGState.getLevel() < 4) && level < 4) {
            if (iPSAppView != null && bNext) {
               Iterator<IPSAppFunc> psAppFuncs = iPSAppView.getPSAppFuncs();

               while (psAppFuncs.hasNext()) {
                  IPSAppFunc psAppFunc = psAppFuncs.next();
                  if (psAppFunc.getPSAppView() != null) {
                     String routeName = StringHelper.Format(
                           "%1$s_%2$s", psAppFunc.getPSAppView().getPSAppModule().getCodeName(), psAppFunc.getPSAppView().getCodeName()
                        )
                        .toLowerCase();
                     if (psAppFunc.getPSAppView().testViewUsage(1)) {
                        this.fillNGStates(psAppFunc.getPSAppView(), psVue2StateImpl, routeName, null, psNGStateList, true, psNGStateMap, level + 1);
                     }
                  }
               }

               boolean var10000 = iPSAppView instanceof IPSAppDEMultiDataView;
               if (iPSAppView instanceof IPSAppExplorerView) {
                  Iterator<IPSAppViewRef> psAppViewRefs = iPSAppView.getPSAppViewRefs();
                  if (psAppViewRefs != null) {
                     while (psAppViewRefs.hasNext()) {
                        IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
                        if (iPSAppViewRef.getRefPSAppView() != null) {
                           String strRefMode = iPSAppViewRef.getName();
                           String strStateName = "";
                           JSONObject stateViewParamJO = null;
                           if (strRefMode.indexOf("EXPITEM:") == 0) {
                              strStateName = StringHelper.Format(
                                    "%1$s_%2$s", iPSAppViewRef.getRefPSAppView().getPSAppModule().getCodeName(), iPSAppViewRef.getRefPSAppView().getCodeName()
                                 )
                                 .toLowerCase();
                              stateViewParamJO = viewParamJO;
                              if (iPSAppViewRef.getRefPSAppView().testViewUsage(1)) {
                                 this.fillNGStates(
                                    iPSAppViewRef.getRefPSAppView(),
                                    psVue2StateImpl,
                                    strStateName,
                                    stateViewParamJO,
                                    psNGStateList,
                                    true,
                                    psNGStateMap,
                                    level + 1
                                 );
                              }
                           }
                        }
                     }
                  }
               }

               if (!(iPSAppView instanceof IPSAppIndexView)) {
                  Iterator<IPSAppView> relatedPSAppViews = iPSAppView.getAllRelatedPSAppViews();

                  while (relatedPSAppViews.hasNext()) {
                     IPSAppView editView = relatedPSAppViews.next();
                     if (editView instanceof IPSAppDERedirectView) {
                        IPSAppDERedirectView iPSAppDERedirectView = (IPSAppDERedirectView)editView;
                        Iterator<IPSAppView> redirectViews = iPSAppDERedirectView.getRedirectPSAppViews();
                        if (redirectViews != null) {
                           while (redirectViews.hasNext()) {
                              IPSAppView redirectView = redirectViews.next();
                              if (redirectView != null) {
                                 String strStateName = StringHelper.Format("%1$s_%2$s", redirectView.getPSAppModule().getCodeName(), redirectView.getCodeName())
                                    .toLowerCase();
                                 if (redirectView.testViewUsage(1)) {
                                    this.fillNGStates(redirectView, psVue2StateImpl, strStateName, null, psNGStateList, true, psNGStateMap, level + 1);
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               Iterator<IPSControl> psControls = iPSAppView.getAllPSControls().iterator();
               if (psControls != null) {
                  while (true) {
                     IPSControl iPSControl;
                     label89:
                     while (true) {
                        if (!psControls.hasNext()) {
                           return;
                        }

                        iPSControl = psControls.next();
                        if (!(iPSControl instanceof IPSDEDRCtrl)) {
                           break;
                        }

                        IPSDEDRCtrl iPSDEDRCtrl = (IPSDEDRCtrl)iPSControl;
                        if (iPSDEDRCtrl.isIncludeMajor()) {
                           this.fillNGStates(null, psVue2StateImpl, "form", null, psNGStateList, true, psNGStateMap, level + 1);
                        }

                        Iterator<IPSDEDRCtrlItem> psDEDRCtrlItems = iPSDEDRCtrl.getPSDEDRCtrlItems();
                        if (psDEDRCtrlItems != null) {
                           while (true) {
                              if (!psDEDRCtrlItems.hasNext()) {
                                 break label89;
                              }

                              IPSDEDRCtrlItem iPSDEDRCtrlItem = psDEDRCtrlItems.next();
                              if (iPSDEDRCtrlItem.getPSAppView() != null && iPSDEDRCtrlItem.getPSAppView().testViewUsage(1)) {
                                 String strStateName = StringHelper.Format(
                                       "%1$s_%2$s", iPSDEDRCtrlItem.getPSAppView().getPSAppModule().getCodeName(), iPSDEDRCtrlItem.getPSAppView().getCodeName()
                                    )
                                    .toLowerCase();
                                 this.fillNGStates(
                                    iPSDEDRCtrlItem.getPSAppView(),
                                    psVue2StateImpl,
                                    strStateName,
                                    iPSDEDRCtrlItem.getViewParamJO(),
                                    psNGStateList,
                                    true,
                                    psNGStateMap,
                                    level + 1
                                 );
                              }
                           }
                        }
                     }

                     if (iPSControl instanceof IPSDEViewPanel) {
                        IPSDEViewPanel iPSDEViewPanel = (IPSDEViewPanel)iPSControl;
                        if (iPSDEViewPanel.getPSAppDEView() != null && iPSDEViewPanel.getPSAppDEView().testViewUsage(1)) {
                           String strStateName = StringHelper.Format(
                                 "%1$s_%2$s", iPSDEViewPanel.getPSAppDEView().getPSAppModule().getCodeName(), iPSDEViewPanel.getPSAppDEView().getCodeName()
                              )
                              .toLowerCase();
                           this.fillNGStates(iPSDEViewPanel.getPSAppDEView(), psVue2StateImpl, strStateName, null, psNGStateList, true, psNGStateMap, level + 1);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   protected void fillAllModalPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> modalViewMap, int level) throws Exception {
      if (level < 4) {
         Iterator<IPSAppViewRef> psAppViewRefLists = iPSAppView.getPSAppViewRefs();

         while (psAppViewRefLists.hasNext()) {
            int _index = level;
            IPSAppViewRef iPSAPPViewRef = psAppViewRefLists.next();
            if (iPSAPPViewRef.getRefPSAppView() != null) {
               if (iPSAPPViewRef.getRefPSAppView().testViewUsage(2) && !modalViewMap.containsKey(iPSAPPViewRef.getRefPSAppView().getId())) {
                  modalViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
               }

               this.fillAllModalPSAppViews(iPSAPPViewRef.getRefPSAppView(), modalViewMap, _index + 1);
            }
         }

         Iterator<IPSAppView> psAppViewLists = iPSAppView.getAllRelatedPSAppViews();

         while (psAppViewLists.hasNext()) {
            int _index = level;
            IPSAppView psAppView = psAppViewLists.next();
            if (psAppView != null) {
               if (psAppView.testViewUsage(2) && !modalViewMap.containsKey(psAppView.getId())) {
                  modalViewMap.put(psAppView.getId(), psAppView);
               }

               if (psAppView.isPickupView() && !modalViewMap.containsKey(psAppView.getId())) {
                  modalViewMap.put(psAppView.getId(), psAppView);
               }

               this.fillAllModalPSAppViews(psAppView, modalViewMap, _index + 1);
            }
         }
      }
   }

   protected void fillEmbeddedPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> embeddedViewMap, int index) throws Exception {
      if (index < 4) {
         Iterator<IPSAppViewRef> psAppViewRefLists = iPSAppView.getEmbeddedPSAppViewRefs("");

         while (psAppViewRefLists.hasNext()) {
            int _index = index;
            IPSAppViewRef iPSAPPViewRef = psAppViewRefLists.next();
            if (iPSAPPViewRef.getRefPSAppView() != null && !StringHelper.IsNullOrEmpty(iPSAPPViewRef.getEmbedId())) {
               if (iPSAPPViewRef.getRefPSAppView().testViewUsage(4) && !embeddedViewMap.containsKey(iPSAPPViewRef.getRefPSAppView().getId())) {
                  embeddedViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
               }

               this.fillEmbeddedPSAppViews(iPSAPPViewRef.getRefPSAppView(), embeddedViewMap, _index);
            }
         }

         Iterator<IPSAppView> psAppViewLists = iPSAppView.getAllRelatedPSAppViews();

         while (psAppViewLists.hasNext()) {
            int _index = index;
            IPSAppView psAppView = psAppViewLists.next();
            if (psAppView != null) {
               if (psAppView.testViewUsage(4) && !embeddedViewMap.containsKey(psAppView.getId())) {
                  embeddedViewMap.put(psAppView.getId(), psAppView);
               }

               this.fillEmbeddedPSAppViews(psAppView, embeddedViewMap, _index + 1);
            }
         }
      }
   }

   protected void fillSPRefViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> spRefViewMap) throws Exception {
      Iterator<IPSAppView> psAppViewLists = iPSAppView.getAllRelatedPSAppViews();

      while (psAppViewLists.hasNext()) {
         IPSAppView psAppView = psAppViewLists.next();
         if (psAppView != null && !spRefViewMap.containsKey(psAppView.getId())) {
            spRefViewMap.put(psAppView.getId(), psAppView);
            this.fillSPRefViews(psAppView, spRefViewMap);
         }
      }
   }

   @Override
   protected boolean isOutputAllControls() {
      return true;
   }
}
