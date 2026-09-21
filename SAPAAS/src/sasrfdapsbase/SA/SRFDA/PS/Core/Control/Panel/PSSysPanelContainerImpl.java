/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelContainer;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelContainerImplBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"CONTAINER"})
public class PSSysPanelContainerImpl
extends PSSysPanelContainerImplBase
implements IPSSysPanelContainer {
    private int nTitleBarCloseMode = 0;
    private IPSUIActionGroup iPSUIActionGroup = null;
    private String strGroupExtractMode = "ITEM";

    @Override
    protected void onInit() throws Exception {
        if (!this.psSysPanelItem.isTITLEBARCLOSEMODENull()) {
            this.nTitleBarCloseMode = this.psSysPanelItem.getTITLEBARCLOSEMODE();
        }
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
            if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getITEMPARAM4())) {
                this.strGroupExtractMode = this.psSysPanelItem.getITEMPARAM4();
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSPanelItem> getPSPanelItems() {
        return this.psPanelItemList.iterator();
    }

    @Override
    public int getPSPanelItemCount() {
        return this.psPanelItemList.size();
    }

    @Override
    public IPSPanelItem getPSPanelItem(int nIndex) throws Exception {
        return (IPSPanelItem)this.psPanelItemList.get(nIndex);
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_CONTAINER";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f", codelist="FormTitleBarCloseMode", ignoredumpvalues="0", fields={"TITLEBARCLOSEMODE"})
    public int getTitleBarCloseMode() {
        return this.nTitleBarCloseMode;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b", fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return super.getPredefinedType();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6807\u9898\u7ed1\u5b9a\u503c\u9879", fields={"FIELDNAME"}, doc="\u4ec5\u5728\u6570\u636e\u533a\u57df\u7c7b\u578b{@link #getDataRegionType}\u4e3a\u65e0(NONE)\u53ca\u7ee7\u627f(INHERIT)\u65f6\u542f\u7528")
    public String getCaptionItemName() {
        if (StringHelper.Compare((String)this.getDataRegionType(), (String)"NONE", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataRegionType(), (String)"INHERIT", (boolean)false) == 0) {
            return this.psSysPanelItem.getFIELDNAME();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, fields={"PSDEUAGROUPID"})
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.iPSUIActionGroup;
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
}

