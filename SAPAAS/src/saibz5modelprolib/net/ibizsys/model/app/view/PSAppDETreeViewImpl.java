/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDETreeView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.codelist.IPSCodeItem
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.tree.IPSDETree
 *  net.ibizsys.model.control.tree.IPSDETreeNode
 *  net.ibizsys.model.control.tree.IPSDETreeNodeRV
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.der.IPSDERIndex
 *  net.ibizsys.model.der.IPSDERNN
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppDETreeView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.PSAppDEMultiDataViewImpl;
import net.ibizsys.model.codelist.IPSCodeItem;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.control.tree.IPSDETreeNodeRV;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.der.IPSDER1NRuntime;
import net.ibizsys.model.der.IPSDERIndex;
import net.ibizsys.model.der.IPSDERNN;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDEViewCtrl;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDETreeViewImpl
extends PSAppDEMultiDataViewImpl
implements IPSAppDETreeView {
    private static final Log log = LogFactory.getLog(PSAppDETreeViewImpl.class);
    private IPSDETree iPSDETree = null;

    @Override
    protected boolean isEnableQuickSearchDefault() {
        return false;
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("tree");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDETree) {
            this.iPSDETree = (IPSDETree)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSDETree getPSDETree() {
        return this.iPSDETree;
    }

    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
        if (this.getPSDETree() == null || this.isPickupMode()) {
            return;
        }
        Iterator psDETreeNodes = this.getPSDETree().getPSDETreeNodes();
        while (psDETreeNodes.hasNext()) {
            IPSDETreeNode iPSDETreeNode = (IPSDETreeNode)psDETreeNodes.next();
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
        Iterator psDETreeNodeRVs = iPSDETreeNode.getPSDETreeNodeRVs();
        if (psDETreeNodeRVs != null) {
            while (psDETreeNodeRVs.hasNext()) {
                IPSDETreeNodeRV iPSDETreeNodeRV = (IPSDETreeNodeRV)psDETreeNodeRVs.next();
                strViewRefMode = StringHelper.format((String)"%1$s@%2$s", (Object)iPSDETreeNodeRV.getName(), (Object)iPSDETreeNode.getNodeType());
                IPSAppView iPSAppView = this.getRefPSAppView(strViewRefMode, true);
                if (iPSAppView != null) continue;
                strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)iPSDETreeNodeRV.getPSDEViewBaseId());
                psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", iPSDETreeNodeRV.getPSDEViewBaseId());
                this.registerPSAppViewRef(psAppViewRef);
            }
        }
        if (!iPSDETreeNode.isBatchAddOnly()) {
            PSDEViewBase psDEViewBase;
            String strViewRefMode2;
            IPSAppView iPSAppView;
            PSAppViewRef psAppViewRef2;
            String strPSAppDEViewId2;
            IPSDataEntity minorPSDataEntity;
            IPSDERIndex iPSDERIndex;
            Iterator psDERIndexs;
            PSDEViewBase psDEViewBase2;
            Iterator<PSDEViewBase> psDEViewBases;
            String strPDTParam;
            IPSCodeItem iPSCodeItem;
            PSDEViewBase psDEViewBase3;
            Iterator psCodeItems;
            IPSDEField mfPSDEField;
            IPSCodeList mfPSCodeList;
            IPSDEField iPSDEField;
            if (iPSDETreeNode.isEnableNewData()) {
                if (StringHelper.compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.compare((String)iPSDETreeNode.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                    iPSDEField = null;
                    iPSDEField = StringHelper.compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? iPSDETreeNode.getPSDataEntity().getFormTypePSDEField() : iPSDETreeNode.getPSDataEntity().getIndexTypePSDEField();
                    if (iPSDEField == null) {
                        log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)iPSDETreeNode.getPSDataEntity().getName()));
                    }
                    if (this.getPSAppViewRef(strViewRefMode = StringHelper.format((String)"%1$s@%2$s", (Object)"NEWDATAWIZARD", (Object)iPSDETreeNode.getNodeType()), true) == null) {
                        String strEditViewTag = "";
                        strEditViewTag = StringHelper.compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? "FORMPICKUPVIEW" : "INDEXDEPICKUPVIEW";
                        PSDEViewBase psDEViewBase4 = ((IPSDataEntityRuntime)iPSDETreeNode.getPSDataEntity()).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + strEditViewTag, true);
                        if (psDEViewBase4 != null) {
                            String strPSAppDEViewId3 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase4.getPSDEVIEWBASEID());
                            PSAppViewRef psAppViewRef3 = new PSAppViewRef();
                            psAppViewRef3.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef3.setMINORPSAPPVIEWID(strPSAppDEViewId3);
                            psAppViewRef3.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase4.getPSDEVIEWBASEID());
                            this.registerPSAppViewRef(psAppViewRef3);
                        } else {
                            log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u9884\u7f6e\u89c6\u56fe[%2$s]", (Object)iPSDETreeNode.getPSDataEntity().getName(), (Object)strEditViewTag));
                        }
                    }
                    if (StringHelper.compare((String)iPSDETreeNode.getNewDataMode(), (String)"MULTIFORM", (boolean)true) == 0 && (mfPSCodeList = (mfPSDEField = iPSDETreeNode.getPSDataEntity().getFormTypePSDEField()).getPSCodeList()) != null) {
                        PSAppViewRef psAppViewRef4;
                        String strPSAppDEViewId4;
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase3 = null;
                                iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                                if (psDEViewBase3 == null) {
                                    strPDTParam = StringHelper.format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase3 = ((IPSDataEntityRuntime)iPSDETreeNode.getPSDataEntity()).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", strPDTParam, true);
                                }
                                if (psDEViewBase3 == null) continue;
                                strViewRefMode = "";
                                if (!iPSDETreeNode.isEnableNewData()) continue;
                                strViewRefMode = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)iPSCodeItem.getValue(), (Object)iPSDETreeNode.getNodeType());
                                if (this.getPSAppViewRef(strViewRefMode = strViewRefMode.toUpperCase(), true) != null) continue;
                                strPSAppDEViewId4 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                                psAppViewRef4 = new PSAppViewRef();
                                psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode);
                                psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                                this.registerPSAppViewRef(psAppViewRef4);
                            }
                        } else {
                            psDEViewBases = ((IPSDataEntityRuntime)iPSDETreeNode.getPSDataEntity()).getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + "EDITVIEW");
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase2 = psDEViewBases.next();
                                    if (StringHelper.isNullOrEmpty((String)psDEViewBase2.getPDVTPARAM())) continue;
                                    strViewRefMode = "";
                                    if (!this.isEnableNewData()) continue;
                                    strViewRefMode = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)psDEViewBase2.getPDVTPARAM(), (Object)iPSDETreeNode.getNodeType());
                                    if (this.getPSAppViewRef(strViewRefMode = strViewRefMode.toUpperCase(), true) != null) continue;
                                    strPSAppDEViewId4 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase2.getPSDEVIEWBASEID());
                                    psAppViewRef4 = new PSAppViewRef();
                                    psAppViewRef4.setPSAPPVIEWREFNAME(strViewRefMode);
                                    psAppViewRef4.setMINORPSAPPVIEWID(strPSAppDEViewId4);
                                    psAppViewRef4.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase2.getPSDEVIEWBASEID());
                                    this.registerPSAppViewRef(psAppViewRef4);
                                }
                            }
                        }
                    }
                    if (StringHelper.compare((String)iPSDETreeNode.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                        psDERIndexs = iPSDETreeNode.getPSDataEntity().getPSDERIndexs(true);
                        while (psDERIndexs.hasNext()) {
                            iPSDERIndex = (IPSDERIndex)psDERIndexs.next();
                            minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                            strViewRefMode = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"NEWDATA", (Object)iPSDERIndex.getTypeValue(), (Object)iPSDETreeNode.getNodeType());
                            if (this.getPSAppViewRef(strViewRefMode, true) != null || (psDEViewBase3 = ((IPSDataEntityRuntime)minorPSDataEntity).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", true)) == null) continue;
                            strPSAppDEViewId2 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                            psAppViewRef2 = new PSAppViewRef();
                            psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                            psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                            this.registerPSAppViewRef(psAppViewRef2);
                        }
                    }
                }
                if ((iPSAppView = this.getRefPSAppView(strViewRefMode2 = StringHelper.format((String)"%1$s@%2$s", (Object)"NEWDATA", (Object)iPSDETreeNode.getNodeType()), true)) == null) {
                    psDEViewBase = null;
                    psDEViewBase = ((IPSDataEntityRuntime)iPSDETreeNode.getPSDataEntity()).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", "", true);
                    if (psDEViewBase != null) {
                        strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
            if (iPSDETreeNode.isEnableEditData() || iPSDETreeNode.isEnableViewData()) {
                if (StringHelper.compare((String)iPSDETreeNode.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.compare((String)iPSDETreeNode.getEditDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                    iPSDEField = null;
                    iPSDEField = StringHelper.compare((String)iPSDETreeNode.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 ? iPSDETreeNode.getPSDataEntity().getFormTypePSDEField() : iPSDETreeNode.getPSDataEntity().getIndexTypePSDEField();
                    if (iPSDEField == null) {
                        log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u672a\u5b9a\u4e49\u6570\u636e\u5206\u7c7b\u5c5e\u6027", (Object)iPSDETreeNode.getPSDataEntity().getName()));
                    }
                    strViewRefMode = "";
                    if (StringHelper.compare((String)iPSDETreeNode.getEditDataMode(), (String)"MULTIFORM", (boolean)true) == 0 && (mfPSCodeList = (mfPSDEField = iPSDETreeNode.getPSDataEntity().getFormTypePSDEField()).getPSCodeList()) != null) {
                        psCodeItems = mfPSCodeList.getPSCodeItems();
                        if (psCodeItems != null) {
                            while (psCodeItems.hasNext()) {
                                psDEViewBase3 = null;
                                iPSCodeItem = (IPSCodeItem)psCodeItems.next();
                                if (psDEViewBase3 == null) {
                                    strPDTParam = StringHelper.format((String)"%1$s", (Object)iPSCodeItem.getValue());
                                    psDEViewBase3 = ((IPSDataEntityRuntime)iPSDETreeNode.getPSDataEntity()).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", strPDTParam, true);
                                }
                                if (psDEViewBase3 == null) continue;
                                strViewRefMode = "";
                            }
                        } else {
                            psDEViewBases = ((IPSDataEntityRuntime)iPSDETreeNode.getPSDataEntity()).getPSDEViewDatasByPDT(String.valueOf(strPDTHeader) + "EDITVIEW");
                            if (psDEViewBases != null) {
                                while (psDEViewBases.hasNext()) {
                                    psDEViewBase2 = psDEViewBases.next();
                                    if (StringHelper.isNullOrEmpty((String)psDEViewBase2.getPDVTPARAM())) continue;
                                    strViewRefMode = "";
                                    this.isWFIAMode();
                                }
                            }
                        }
                    }
                    if (StringHelper.compare((String)iPSDETreeNode.getNewDataMode(), (String)"INDEXDE", (boolean)true) == 0) {
                        psDERIndexs = iPSDETreeNode.getPSDataEntity().getPSDERIndexs(true);
                        while (psDERIndexs.hasNext()) {
                            iPSDERIndex = (IPSDERIndex)psDERIndexs.next();
                            minorPSDataEntity = iPSDERIndex.getMinorPSDataEntity();
                            strViewRefMode = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"EDITDATA", (Object)iPSDERIndex.getTypeValue(), (Object)iPSDETreeNode.getNodeType());
                            if (this.getPSAppViewRef(strViewRefMode, true) != null || (psDEViewBase3 = ((IPSDataEntityRuntime)minorPSDataEntity).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", true)) == null) continue;
                            strPSAppDEViewId2 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase3.getPSDEVIEWBASEID());
                            psAppViewRef2 = new PSAppViewRef();
                            psAppViewRef2.setPSAPPVIEWREFNAME(strViewRefMode);
                            psAppViewRef2.setMINORPSAPPVIEWID(strPSAppDEViewId2);
                            psAppViewRef2.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase3.getPSDEVIEWBASEID());
                            this.registerPSAppViewRef(psAppViewRef2);
                        }
                    }
                }
                if ((iPSAppView = this.getRefPSAppView(strViewRefMode2 = StringHelper.format((String)"%1$s@%2$s", (Object)"EDITDATA", (Object)iPSDETreeNode.getNodeType()), true)) == null) {
                    psDEViewBase = null;
                    psDEViewBase = ((IPSDataEntityRuntime)iPSDETreeNode.getPSDataEntity()).getPSDEViewDataByPDT(String.valueOf(strPDTHeader) + "EDITVIEW", "", true);
                    if (psDEViewBase != null) {
                        strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                        psAppViewRef = new PSAppViewRef();
                        psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode2);
                        psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
                        psAppViewRef.setParamValue("MINORPSDEVIEWBASEID", psDEViewBase.getPSDEVIEWBASEID());
                        this.registerPSAppViewRef(psAppViewRef);
                    }
                }
            }
        }
        if (iPSDETreeNode.isEnableBatchAdd()) {
            PSAppViewRef psAppViewRef5;
            String strPSAppDEViewId5;
            IPSDERNN iPSDERNN = iPSDETreeNode.getPSDataEntity().getPSDERNN();
            String strMPickupViewTag = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getFirstPSDER1N().getCodeName(), (Object)iPSDETreeNode.getNodeType());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.isNullOrEmpty((String)((IPSDER1NRuntime)iPSDERNN.getFirstPSDER1N()).getRefMPickupPSDEViewId())) {
                strPSAppDEViewId5 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)((IPSDER1NRuntime)iPSDERNN.getFirstPSDER1N()).getRefMPickupPSDEViewId());
                psAppViewRef5 = new PSAppViewRef();
                psAppViewRef5.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", ((IPSDER1NRuntime)iPSDERNN.getFirstPSDER1N()).getRefMPickupPSDEViewId());
                this.registerPSAppViewRef(psAppViewRef5);
            }
            strMPickupViewTag = StringHelper.format((String)"%1$s:%2$s@%3$s", (Object)"MPICKUPVIEW", (Object)iPSDERNN.getSecondPSDER1N().getCodeName(), (Object)iPSDETreeNode.getNodeType());
            if (this.getPSAppViewRef(strMPickupViewTag = strMPickupViewTag.toUpperCase(), true) == null && !StringHelper.isNullOrEmpty((String)((IPSDER1NRuntime)iPSDERNN.getSecondPSDER1N()).getRefMPickupPSDEViewId())) {
                strPSAppDEViewId5 = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)((IPSDER1NRuntime)iPSDERNN.getSecondPSDER1N()).getRefMPickupPSDEViewId());
                psAppViewRef5 = new PSAppViewRef();
                psAppViewRef5.setPSAPPVIEWREFNAME(strMPickupViewTag);
                psAppViewRef5.setMINORPSAPPVIEWID(strPSAppDEViewId5);
                psAppViewRef5.setParamValue("MINORPSDEVIEWBASEID", ((IPSDER1NRuntime)iPSDERNN.getSecondPSDER1N()).getRefMPickupPSDEViewId());
                this.registerPSAppViewRef(psAppViewRef5);
            }
        }
    }
}

