/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDETreeExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataViewImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRV;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DETREEEXPVIEW", "DETREEEXPVIEW3"})
public class PSAppDETreeExplorerViewImpl
extends PSAppDEMultiDataViewImpl
implements IPSAppDETreeExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDETreeExplorerViewImpl.class);
    private IPSTreeExpBar iPSTreeExpBar = null;
    protected boolean bShowDataInfoBar = true;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psViewBase.isVIEWPARAM6Null()) {
            this.bShowDataInfoBar = this.psViewBase.getVIEWPARAM6();
        }
    }

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSTreeExpBar = (IPSTreeExpBar)this.getPSControl("TREEEXPBAR");
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!this.isPrepareTemplV2logic() && this.getPSTreeExpBar() != null && this.getPSTreeExpBar().getPSDETree() != null && this.getPSTreeExpBar().getPSDETree().getCatPSCodeList() != null) {
            this.registerPSAppViewParam("UI.ENABLEEXPTREECAT", "TRUE", "\u652f\u6301\u6811\u5206\u7c7b");
        }
        super.onPreparePSAppViewParams();
    }

    public IPSDETree getPSDETree() {
        if (this.getPSTreeExpBar() != null) {
            return this.getPSTreeExpBar().getPSDETree();
        }
        return null;
    }

    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
        if (this.getPSDETree() == null) {
            return;
        }
        Iterator<IPSDETreeNode> psDETreeNodes = this.getPSDETree().getPSDETreeNodes();
        while (psDETreeNodes.hasNext()) {
            IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
            this.onPreparePSPSDETreeNodeRefs(iPSDETreeNode);
        }
    }

    protected void onPreparePSPSDETreeNodeRefs(IPSDETreeNode iPSDETreeNode) throws Exception {
        PSAppViewRef psAppViewRef;
        String strPSAppDEViewId;
        String strViewRefMode;
        if (iPSDETreeNode.getPSDataEntity() == null) {
            return;
        }
        String strPDTHeader = "";
        Iterator<IPSDETreeNodeRV> psDETreeNodeRVs = iPSDETreeNode.getPSDETreeNodeRVs();
        if (psDETreeNodeRVs != null) {
            while (psDETreeNodeRVs.hasNext()) {
                IPSDETreeNodeRV iPSDETreeNodeRV = psDETreeNodeRVs.next();
                strViewRefMode = StringHelper.Format((String)"%1$s@%2$s", (Object)iPSDETreeNodeRV.getName(), (Object)iPSDETreeNode.getNodeType());
                IPSAppView iPSAppView = this.getRefPSAppView(strViewRefMode, true);
                if (iPSAppView != null) continue;
                strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSDETreeNodeRV.getPSDEViewBaseId());
                psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", iPSDETreeNodeRV.getPSDEViewBaseId());
                psAppViewRef.setParamValue("TRYMODE", true);
                psAppViewRef.setVIEWPARAMS(iPSDETreeNodeRV.getViewParam());
                this.registerPSAppViewRef(psAppViewRef);
            }
        }
        if (!iPSDETreeNode.isBatchAddOnly()) {
            PSDEViewBase psDEViewBase;
            String strViewRefMode2;
            IPSAppView iPSAppView;
            if (iPSDETreeNode.isEnableNewData() && (iPSAppView = this.getRefPSAppView(strViewRefMode2 = StringHelper.Format((String)"%1$s@%2$s", (Object)"NEWDATA", (Object)iPSDETreeNode.getNodeType()), true)) == null) {
                psDEViewBase = null;
                psDEViewBase = iPSDETreeNode.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", "", true);
                if (psDEViewBase != null) {
                    strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                    psAppViewRef = new PSAppViewRef();
                    psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                    psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                    psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                    psAppViewRef.setParamValue("TRYMODE", true);
                    this.registerPSAppViewRef(psAppViewRef);
                }
            }
            if ((iPSDETreeNode.isEnableEditData() || iPSDETreeNode.isEnableViewData()) && (iPSAppView = this.getRefPSAppView(strViewRefMode2 = StringHelper.Format((String)"%1$s@%2$s", (Object)"EDITDATA", (Object)iPSDETreeNode.getNodeType()), true)) == null) {
                psDEViewBase = null;
                psDEViewBase = iPSDETreeNode.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", "", true);
                if (psDEViewBase != null) {
                    strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                    psAppViewRef = new PSAppViewRef();
                    psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                    psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                    psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                    psAppViewRef.setParamValue("TRYMODE", true);
                    this.registerPSAppViewRef(psAppViewRef);
                }
            }
        }
        if (iPSDETreeNode.isEnableBatchAdd()) {
            PSAppViewRef psAppViewRef2;
            String strPSAppDEViewId2;
            IPSDERNN iPSDERNN = iPSDETreeNode.getPSDataEntity().getPSDERNN();
            String strMPickupViewTag = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getFirstPSDER().getCodeName(), (Object)iPSDETreeNode.getNodeType());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.IsNullOrEmpty((String)iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId())) {
                strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId());
                psAppViewRef2 = new PSAppViewRef();
                psAppViewRef2.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", iPSDERNN.getFirstPSDER().getRefMPickupPSDEViewId());
                psAppViewRef2.setParamValue("TRYMODE", true);
                this.registerPSAppViewRef(psAppViewRef2);
            }
            strMPickupViewTag = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getSecondPSDER().getCodeName(), (Object)iPSDETreeNode.getNodeType());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.IsNullOrEmpty((String)iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId())) {
                strPSAppDEViewId2 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId());
                psAppViewRef2 = new PSAppViewRef();
                psAppViewRef2.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", iPSDERNN.getSecondPSDER().getRefMPickupPSDEViewId());
                psAppViewRef2.setParamValue("TRYMODE", true);
                this.registerPSAppViewRef(psAppViewRef2);
            }
        }
        if (StringHelper.Compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.Compare((String)iPSDETreeNode.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
            PSDEViewBase psDEViewBase;
            IPSDEField mfPSDEField;
            IPSCodeList mfPSCodeList;
            IPSDEField iPSDEField = null;
            iPSDEField = StringHelper.Compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? iPSDETreeNode.getPSDataEntity().getFormTypePSDEField() : iPSDETreeNode.getPSDataEntity().getIndexTypePSDEField();
            if (iPSDEField == null) {
                log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)iPSDETreeNode.getPSDataEntity().getName()));
            }
            if (this.getPSAppViewRef(strViewRefMode = StringHelper.Format((String)"%1$s@%2$s", (Object)"NEWDATAWIZARD", (Object)iPSDETreeNode.getNodeType()), true) == null) {
                String strEditViewTag = "";
                strEditViewTag = StringHelper.Compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? "FORMPICKUPVIEW" : "INDEXDEPICKUPVIEW";
                PSDEViewBase psDEViewBase2 = iPSDETreeNode.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + strEditViewTag, true);
                if (psDEViewBase2 != null) {
                    String strPSAppDEViewId3 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                    PSAppViewRef psAppViewRef3 = new PSAppViewRef();
                    psAppViewRef3.setPSAPPVIEWREFNAME(strViewRefMode);
                    psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                    psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                    this.registerPSAppViewRef(psAppViewRef3);
                } else {
                    log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u9884\u7f6e\u89c6\u56fe[%2$s]", (Object)iPSDETreeNode.getPSDataEntity().getName(), (Object)strEditViewTag));
                }
            }
            if (StringHelper.Compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 && (mfPSCodeList = (mfPSDEField = iPSDETreeNode.getPSDataEntity().getFormTypePSDEField()).getPSCodeList()) != null) {
                Iterator<IPSCodeItem> psCodeItems = mfPSCodeList.getPSCodeItems();
                if (psCodeItems != null) {
                    while (psCodeItems.hasNext()) {
                        psDEViewBase = null;
                        IPSCodeItem iPSCodeItem = psCodeItems.next();
                        if (psDEViewBase == null) {
                            String strPDTParam = StringHelper.Format((String)"%1$s", (Object)iPSCodeItem.getValue());
                            psDEViewBase = iPSDETreeNode.getPSDataEntity().getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", strPDTParam, true);
                        }
                        if (psDEViewBase == null) continue;
                        strViewRefMode = "";
                        if (!iPSDETreeNode.isEnableNewData()) continue;
                        strViewRefMode = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)iPSCodeItem.getValue(), (Object)iPSDETreeNode.getNodeType());
                        if (this.getPSAppViewRef(strViewRefMode = strViewRefMode.toUpperCase(), true) != null) continue;
                        String strPSAppDEViewId4 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        PSAppViewRef psAppViewRef4 = new PSAppViewRef();
                        psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode);
                        psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                        psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef4.setParamValue("TRYMODE", true);
                        this.registerPSAppViewRef(psAppViewRef4);
                    }
                } else {
                    Iterator<PSDEViewBase> psDEViewBases = iPSDETreeNode.getPSDataEntity().getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + "EDITVIEW");
                    if (psDEViewBases != null) {
                        while (psDEViewBases.hasNext()) {
                            PSDEViewBase psDEViewBase3 = psDEViewBases.next();
                            if (StringHelper.IsNullOrEmpty((String)psDEViewBase3.getPDVTPARAM())) continue;
                            strViewRefMode = "";
                        }
                    }
                }
            }
            if (StringHelper.Compare((String)iPSDETreeNode.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                Iterator<IPSDERIndex> psDERIndexs = iPSDETreeNode.getPSDataEntity().getPSDERIndexs(true);
                while (psDERIndexs.hasNext()) {
                    PSAppViewRef psAppViewRef5;
                    String strPSAppDEViewId5;
                    IPSDERIndex iPSDERIndex = psDERIndexs.next();
                    IPSDataEntity minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                    strViewRefMode = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)iPSDERIndex.getTypeValue(), (Object)iPSDETreeNode.getNodeType());
                    if (this.getPSAppViewRef(strViewRefMode, true) == null && (psDEViewBase = minorPSDataEntity.getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", true)) != null) {
                        strPSAppDEViewId5 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef5 = new PSAppViewRef();
                        psAppViewRef5.setPSAPPVIEWREFNAME(strViewRefMode);
                        psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                        psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        this.registerPSAppViewRef(psAppViewRef5);
                    }
                    if (this.getPSAppViewRef(strViewRefMode = StringHelper.Format((String)"%1$s:%2$s@%3$s", (Object)"EDITDATA", (Object)iPSDERIndex.getTypeValue(), (Object)iPSDETreeNode.getNodeType()), true) != null || (psDEViewBase = minorPSDataEntity.getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", true)) == null) continue;
                    strPSAppDEViewId5 = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                    psAppViewRef5 = new PSAppViewRef();
                    psAppViewRef5.setPSAPPVIEWREFNAME(strViewRefMode);
                    psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                    psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                    this.registerPSAppViewRef(psAppViewRef5);
                }
            }
        }
    }

    @Override
    public boolean isIFrameMode() {
        return false;
    }

    @Override
    protected boolean isIgnoreMDViewCheck() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u5bfc\u822a\u680f")
    public IPSTreeExpBar getPSTreeExpBar() {
        return this.iPSTreeExpBar;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f")
    public boolean isShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6570\u636e\u6a21\u5f0f", codelist="EditViewMarkOpenDataMode", fields={"VIEWPARAM13"})
    public String getMarkOpenDataMode() {
        return this.psViewBase.getVIEWPARAM13();
    }
}

