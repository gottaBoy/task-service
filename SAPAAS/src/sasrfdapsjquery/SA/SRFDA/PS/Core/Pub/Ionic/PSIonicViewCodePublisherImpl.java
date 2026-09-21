/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.App.View.IPSAppViewRef
 *  SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl
 *  SA.SRFDA.PS.Core.Res.IPSSubViewType
 *  SA.SRFDA.PS.Core.SubSys.IPSSubDEView
 *  SA.SRFDA.PS.Core.View.IPSViewType
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Ionic;

import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Pub.Ionic.PSIonicFileNameMethod;
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

public class PSIonicViewCodePublisherImpl
extends PSPFViewCodePublisherImpl {
    private static PSIonicFileNameMethod psIonicFileNameMethod = new PSIonicFileNameMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList refPSAppViewList = null;
        refPSAppViewList = new ArrayList();
        HashMap<String, IPSAppView> refViewMap = new HashMap<String, IPSAppView>();
        Iterator psAppViewLists = this.iPSAppView.getAllRelatedPSAppViews();
        while (psAppViewLists.hasNext()) {
            IPSAppView iPSAppView = (IPSAppView)psAppViewLists.next();
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
        if (StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"MODULE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"CONTROLLER_BASE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SERVICE_TS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"SCSS", (boolean)true) == 0 || StringHelper.Compare((String)this.getPSPFPubCode().getName(), (String)"HTML", (boolean)true) == 0) {
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
        params2.put("ionicviewname", this.replaceFullName(this.iPSAppView.getCodeName()));
        params2.put("ionicclassname", psIonicFileNameMethod);
        return super.generateCode(params2);
    }

    protected String generateCode(BaseDataEntity templData, String strCodeName, HashMap<String, Object> params) throws Exception {
        return super.generateCode(templData, strCodeName, params);
    }

    protected boolean isOutputAllControls() {
        return true;
    }
}

