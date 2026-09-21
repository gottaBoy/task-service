/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard
 *  net.ibizsys.pscore.srv.codelist.AppFuncTypeCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DEUIActionTypeCodeListModel
 *  net.ibizsys.pscore.srv.codelist.ViewRVModeCodeListModel
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.codelist.AppFuncTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DEUIActionTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.ViewRVModeCodeListModel;

public class PSAppStoryBoardHelper {
    public PSAppSBItem getPSAppSBItem(IPSAppView iPSAppView, PSAppStoryBoard psAppStoryBoard, Map<String, PSAppSBItem> psAppSBItemMap, List<PSAppSBItemRS> psAppSBItemRSList) throws Exception {
        return this.getPSAppSBItem(iPSAppView, true, psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
    }

    public PSAppSBItem getPSAppSBItem(IPSAppView iPSAppView, boolean bCheck, PSAppStoryBoard psAppStoryBoard, Map<String, PSAppSBItem> psAppSBItemMap, List<PSAppSBItemRS> psAppSBItemRSList) throws Exception {
        Iterator<IPSAppViewRef> psAppViewRefs;
        ArrayList<IPSControl> psControls;
        Iterator<IPSAppViewUIAction> psAppViewUIActions;
        PSAppSBItemRS psAppSBItemRS;
        PSAppSBItem psAppSBItem2;
        PSAppSBItem psAppSBItem = psAppSBItemMap.get(iPSAppView.getId());
        if (psAppSBItem == null) {
            psAppSBItem = new PSAppSBItem();
            psAppSBItem.setPSAppSBItemName(iPSAppView.getTitle());
            if (StringHelper.isNullOrEmpty((String)psAppSBItem.getPSAppSBItemName())) {
                psAppSBItem.setPSAppSBItemName(iPSAppView.getName());
            }
            psAppSBItem.setPSAppStoryBoardId(psAppStoryBoard.getPSAppStoryBoardId());
            psAppSBItem.setPSAppStoryBoardName(psAppStoryBoard.getPSAppStoryBoardName());
            psAppSBItem.setItemType("APPVIEW");
            psAppSBItem.setPSAppViewId(iPSAppView.getId());
            psAppSBItem.setPSAppViewName(iPSAppView.getName());
            psAppSBItem.setPSAppSBItemId(this.getPSAppSBItemId(psAppSBItem));
            psAppSBItemMap.put(iPSAppView.getId(), psAppSBItem);
        } else if (bCheck) {
            return psAppSBItem;
        }
        Iterator<IPSAppFunc> psAppFuncs = iPSAppView.getPSAppFuncs();
        if (psAppFuncs != null) {
            ICodeList iCodeList = AppFuncTypeCodeListModel.getInstance();
            while (psAppFuncs.hasNext()) {
                IPSAppFunc iPSAppFunc = psAppFuncs.next();
                psAppSBItem2 = null;
                if (iPSAppFunc.getPSAppView() != null) {
                    psAppSBItem2 = this.getPSAppSBItem(iPSAppFunc.getPSAppView(), psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
                }
                psAppSBItemRS = new PSAppSBItemRS();
                psAppSBItemRS.setPSAppStoryBoardId(psAppStoryBoard.getPSAppStoryBoardId());
                psAppSBItemRS.setPSAppStoryBoardName(psAppStoryBoard.getPSAppStoryBoardName());
                psAppSBItemRS.setPPSAppSBItemId(psAppSBItem.getPSAppSBItemId());
                psAppSBItemRS.setPPSAppSBItemName(psAppSBItem.getPSAppSBItemName());
                if (psAppSBItem2 != null) {
                    psAppSBItemRS.setCPSAppSBItemId(psAppSBItem2.getPSAppSBItemId());
                    psAppSBItemRS.setCPSAppSBItemName(psAppSBItem2.getPSAppSBItemName());
                }
                psAppSBItemRS.setPSAppSBItemRSName(iPSAppFunc.getName());
                psAppSBItemRS.setRSType("APPFUNC");
                psAppSBItemRS.setRSTag(iPSAppFunc.getAppFuncType());
                psAppSBItemRS.setRSTag2(iCodeList.getCodeListText(iPSAppFunc.getAppFuncType(), true));
                psAppSBItemRS.setMemo(iPSAppFunc.getMemo());
                psAppSBItemRS.setPSAppSBItemRSId(this.getPSAppSBItemRSId(psAppSBItemRS));
                psAppSBItemRSList.add(psAppSBItemRS);
            }
        }
        if ((psAppViewUIActions = iPSAppView.getPSAppViewUIActions()) != null) {
            while (psAppViewUIActions.hasNext()) {
                IPSAppViewUIAction iPSAppViewUIAction = psAppViewUIActions.next();
                IPSUIAction iPSUIAction = iPSAppViewUIAction.getPSUIAction();
                if (iPSUIAction == null) continue;
                this.calcPSUIAction(iPSAppView, psAppSBItem, iPSUIAction, psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
            }
        }
        if ((psControls = iPSAppView.getAllPSControls()) != null) {
            for (IPSControl iPSControl : psControls) {
                IPSControlContainer iPSControlContainer;
                Iterator<IPSAppViewUIAction> psAppViewUIActions2;
                if (!(iPSControl instanceof IPSControlContainer) || (psAppViewUIActions2 = (iPSControlContainer = (IPSControlContainer)((Object)iPSControl)).getPSAppViewUIActions()) == null) continue;
                while (psAppViewUIActions2.hasNext()) {
                    IPSAppViewUIAction iPSAppViewUIAction = psAppViewUIActions2.next();
                    IPSUIAction iPSUIAction = iPSAppViewUIAction.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    this.calcPSUIAction(iPSAppView, psAppSBItem, iPSUIAction, psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
                }
            }
        }
        if ((psAppViewRefs = iPSAppView.getEmbeddedPSAppViewRefs("")) != null) {
            while (psAppViewRefs.hasNext()) {
                IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
                if (iPSAppViewRef.getRefPSAppView() == null || iPSAppViewRef.getPSAppView() == null || StringHelper.compare((String)iPSAppViewRef.getPSAppView().getId(), (String)iPSAppView.getId(), (boolean)false) != 0) continue;
                psAppSBItem2 = this.getPSAppSBItem(iPSAppViewRef.getRefPSAppView(), psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
                psAppSBItemRS = new PSAppSBItemRS();
                psAppSBItemRS.setPSAppStoryBoardId(psAppStoryBoard.getPSAppStoryBoardId());
                psAppSBItemRS.setPSAppStoryBoardName(psAppStoryBoard.getPSAppStoryBoardName());
                psAppSBItemRS.setPPSAppSBItemId(psAppSBItem.getPSAppSBItemId());
                psAppSBItemRS.setPPSAppSBItemName(psAppSBItem.getPSAppSBItemName());
                if (psAppSBItem2 != null) {
                    psAppSBItemRS.setCPSAppSBItemId(psAppSBItem2.getPSAppSBItemId());
                    psAppSBItemRS.setCPSAppSBItemName(psAppSBItem2.getPSAppSBItemName());
                }
                psAppSBItemRS.setPSAppSBItemRSName(iPSAppViewRef.getRefModeDesc());
                psAppSBItemRS.setRSTag(psAppSBItemRS.getPSAppSBItemRSName());
                if (StringHelper.isNullOrEmpty((String)psAppSBItemRS.getPSAppSBItemRSName())) {
                    psAppSBItemRS.setPSAppSBItemRSName(iPSAppViewRef.getName());
                }
                if (StringHelper.isNullOrEmpty((String)psAppSBItemRS.getPSAppSBItemRSName())) {
                    psAppSBItemRS.setPSAppSBItemRSName("\u5d4c\u5165\u89c6\u56fe");
                }
                psAppSBItemRS.setRSType("APPVIEWEMBED");
                psAppSBItemRS.setRSTag(iPSAppViewRef.getName());
                psAppSBItemRS.setMemo(iPSAppViewRef.getMemo());
                psAppSBItemRS.setPSAppSBItemRSId(this.getPSAppSBItemRSId(psAppSBItemRS));
                psAppSBItemRSList.add(psAppSBItemRS);
            }
        }
        if ((psAppViewRefs = iPSAppView.getPSAppViewRefs()) != null) {
            ICodeList iCodeList = ViewRVModeCodeListModel.getInstance();
            while (psAppViewRefs.hasNext()) {
                IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
                if (!StringHelper.isNullOrEmpty((String)iPSAppViewRef.getEmbedId())) continue;
                PSAppSBItem psAppSBItem22 = null;
                if (iPSAppViewRef.getRefPSAppView() != null) {
                    psAppSBItem22 = this.getPSAppSBItem(iPSAppViewRef.getRefPSAppView(), psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
                }
                PSAppSBItemRS psAppSBItemRS2 = new PSAppSBItemRS();
                psAppSBItemRS2.setPSAppStoryBoardId(psAppStoryBoard.getPSAppStoryBoardId());
                psAppSBItemRS2.setPSAppStoryBoardName(psAppStoryBoard.getPSAppStoryBoardName());
                psAppSBItemRS2.setPPSAppSBItemId(psAppSBItem.getPSAppSBItemId());
                psAppSBItemRS2.setPPSAppSBItemName(psAppSBItem.getPSAppSBItemName());
                if (psAppSBItem22 != null) {
                    psAppSBItemRS2.setCPSAppSBItemId(psAppSBItem22.getPSAppSBItemId());
                    psAppSBItemRS2.setCPSAppSBItemName(psAppSBItem22.getPSAppSBItemName());
                }
                psAppSBItemRS2.setPSAppSBItemRSName(iPSAppViewRef.getRefModeDesc());
                if (StringHelper.isNullOrEmpty((String)psAppSBItemRS2.getPSAppSBItemRSName())) {
                    ICodeItem iCodeItem;
                    if (iCodeList != null && (iCodeItem = iCodeList.getCodeItem(iPSAppViewRef.getName())) != null) {
                        psAppSBItemRS2.setPSAppSBItemRSName(iCodeItem.getText());
                    }
                    if (StringHelper.isNullOrEmpty((String)psAppSBItemRS2.getPSAppSBItemRSName())) {
                        psAppSBItemRS2.setPSAppSBItemRSName(iPSAppViewRef.getName());
                    }
                }
                psAppSBItemRS2.setRSType("APPVIEWREF");
                psAppSBItemRS2.setRSTag(iPSAppViewRef.getName());
                psAppSBItemRS2.setMemo(iPSAppViewRef.getMemo());
                psAppSBItemRS2.setPSAppSBItemRSId(this.getPSAppSBItemRSId(psAppSBItemRS2));
                psAppSBItemRSList.add(psAppSBItemRS2);
            }
        }
        return psAppSBItem;
    }

    public void calcPSUIAction(IPSAppView iPSAppView, PSAppSBItem psAppSBItem, IPSUIAction iPSUIAction, PSAppStoryBoard psAppStoryBoard, Map<String, PSAppSBItem> psAppSBItemMap, List<PSAppSBItemRS> psAppSBItemRSList) throws Exception {
        ICodeList iCodeList = DEUIActionTypeCodeListModel.getInstance();
        PSAppSBItem psAppSBItem2 = null;
        if ((StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"FRONT", (boolean)false) == 0 || StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"WFFRONT", (boolean)false) == 0) && iPSUIAction.getFrontPSAppView() != null) {
            psAppSBItem2 = this.getPSAppSBItem(iPSUIAction.getFrontPSAppView(), psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
        }
        PSAppSBItemRS psAppSBItemRS = new PSAppSBItemRS();
        psAppSBItemRS.setPSAppStoryBoardId(psAppStoryBoard.getPSAppStoryBoardId());
        psAppSBItemRS.setPSAppStoryBoardName(psAppStoryBoard.getPSAppStoryBoardName());
        psAppSBItemRS.setPPSAppSBItemId(psAppSBItem.getPSAppSBItemId());
        psAppSBItemRS.setPPSAppSBItemName(psAppSBItem.getPSAppSBItemName());
        if (psAppSBItem2 != null) {
            psAppSBItemRS.setCPSAppSBItemId(psAppSBItem2.getPSAppSBItemId());
            psAppSBItemRS.setCPSAppSBItemName(psAppSBItem2.getPSAppSBItemName());
        }
        psAppSBItemRS.setPSAppSBItemRSName(iPSUIAction.getName());
        psAppSBItemRS.setRSType("UIACTION");
        psAppSBItemRS.setRSTag(iPSUIAction.getUIActionMode());
        psAppSBItemRS.setRSTag2(iCodeList.getCodeListText(iPSUIAction.getUIActionMode(), true));
        psAppSBItemRS.setMemo(iPSUIAction.getMemo());
        psAppSBItemRS.setPSAppSBItemRSId(this.getPSAppSBItemRSId(psAppSBItemRS));
        psAppSBItemRSList.add(psAppSBItemRS);
    }

    protected String getPSAppSBItemId(PSAppSBItem psAppSBItem) {
        return KeyValueHelper.genGuidEx();
    }

    protected String getPSAppSBItemRSId(PSAppSBItemRS psAppSBItemRS) {
        return KeyValueHelper.genGuidEx();
    }
}

