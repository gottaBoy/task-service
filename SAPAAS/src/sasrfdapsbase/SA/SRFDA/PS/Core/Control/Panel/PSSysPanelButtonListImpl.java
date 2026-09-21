/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelButton;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDetailType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelButtonList;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"BUTTONLIST"})
public class PSSysPanelButtonListImpl
extends PSSysPanelItemImpl
implements IPSSysPanelButtonList {
    private IPSUIActionGroup iPSUIActionGroup = null;
    private String strGroupExtractMode = "ITEM";
    protected ArrayList<IPSPanelButton> psPanelButtonList = new ArrayList();
    private String strButtonListType = "UIACTIONGROUP";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEUAGROUPID())) {
            Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails;
            if (this.iPSUIActionGroup == null) {
                IPSDataEntity iPSDataEntity = null;
                iPSDataEntity = !StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEID()) ? this.getPSSystem().getPSDataEntity2(this.psSysPanelItem.getPSDEID(), false) : this.getPSSysPanel().getPSDataEntity();
                if (iPSDataEntity == null) {
                    throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
                }
                IPSAppDataEntity iPSAppDataEntity = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, true);
                if (iPSAppDataEntity != null) {
                    this.iPSUIActionGroup = iPSAppDataEntity.getPSAppDEUIActionGroup(this.psSysPanelItem.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
                }
                if (this.iPSUIActionGroup == null) {
                    this.iPSUIActionGroup = iPSDataEntity.getPSDEUIActionGroup(this.psSysPanelItem.getPSDEUAGROUPID());
                }
            }
            if ((psUIActionGroupDetails = this.iPSUIActionGroup.getPSUIActionGroupDetails()) != null) {
                while (psUIActionGroupDetails.hasNext()) {
                    IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                    IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                    if (iPSUIAction == null) continue;
                    if (this.isPrepareTemplV2logic()) {
                        PSAppViewUIActionProxy iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSPanel());
                        this.getPSPanel().registerPSAppViewUIAction(iPSAppViewUIAction);
                        this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                        continue;
                    }
                    this.getPSPanel().getPSAppView().registerPSUIAction(iPSUIAction);
                }
            }
        } else {
            this.onPreparePSPanelButtons();
            if (this.psPanelButtonList.size() == 0) {
                throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u884c\u4e3a\u7ec4");
            }
            this.strButtonListType = "BUTTONS";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getITEMPARAM4())) {
            this.strGroupExtractMode = this.psSysPanelItem.getITEMPARAM4();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, fields={"PSDEUAGROUPID"})
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.iPSUIActionGroup;
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_BUTTONLIST";
    }

    protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
        String strCtrlName = this.getPSPanel().getName();
        String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_%3$s_click", (Object)strCtrlName, (Object)this.getName(), (Object)iPSUIActionGroupDetail.getName()).toLowerCase();
        PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
        psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
        psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
        PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSPanel(), psAppViewLogic, iPSAppViewUIAction);
        this.getPSPanel().registerPSAppViewLogic(psAppDEViewLogicImpl);
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode", ignoredumpvalues="ITEM", fields={"ITEMPARAM4"})
    public String getActionGroupExtractMode() {
        return this.strGroupExtractMode;
    }

    protected void onPreparePSPanelButtons() throws Exception {
        this.psPanelButtonList.clear();
        ArrayList<PSSysPanelItem> psPanelItemList = this.psSysPanelItem.getChildPSSysPanelItems(false);
        if (psPanelItemList == null) {
            return;
        }
        for (PSSysPanelItem psPanelItem : psPanelItemList) {
            if (StringHelper.Compare((String)psPanelItem.getITEMTYPE(), (String)"BUTTON", (boolean)false) != 0) continue;
            IPSPanelDetailType iPSPanelItemType = this.getPSModelStorage().getPSPanelDetailType(psPanelItem.getITEMTYPE());
            IPSSysPanelItem iPSSysPanelItem = iPSPanelItemType.createPSSysPanelItem(psPanelItem);
            if (iPSSysPanelItem instanceof IPSPanelButton) {
                iPSSysPanelItem.init(this.getDAGlobalHelper(), this.getPSSysPanel(), this, psPanelItem);
                this.psPanelButtonList.add((IPSPanelButton)((Object)iPSSysPanelItem));
                continue;
            }
            throw new Exception(String.format("\u6210\u5458[%1$s]\u7c7b\u578b[%2$s]\u4e0d\u6b63\u786e\uff0c\u65e0\u6cd5\u9644\u52a0\u81f3\u6309\u94ae\u5217\u8868", psPanelItem.getPSSYSVIEWPANELITEMNAME(), psPanelItem.getITEMTYPE()));
        }
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u96c6\u5408", child=true)
    public Iterator<? extends IPSPanelButton> getPSPanelButtons() {
        return this.psPanelButtonList.iterator();
    }

    @Override
    public boolean isShowCaption() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u5217\u8868\u7c7b\u578b", codelist="FormButtonListType", ignoredumpvalues="UIACTIONGROUP")
    public String getButtonListType() {
        return this.strButtonListType;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSPanelItem iPSPanelItem : this.psPanelButtonList) {
            iPSPanelItem.fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        for (IPSPanelItem iPSPanelItem : this.psPanelButtonList) {
            iPSPanelItem.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
    }
}

