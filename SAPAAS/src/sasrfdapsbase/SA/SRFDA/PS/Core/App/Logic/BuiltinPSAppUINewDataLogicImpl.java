/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUILogicImplBase;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUINewDataLogic;
import SA.SRFDA.PS.Core.App.Logic.PSAppUILogicRefViewImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControlMDataContainer;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BuiltinPSAppUINewDataLogicImpl
extends BuiltinPSAppUILogicImplBase
implements IPSAppUINewDataLogic {
    private static final Log log = LogFactory.getLog(BuiltinPSAppUINewDataLogicImpl.class);
    private IPSControlMDataContainer iPSControlMDataContainer = null;
    private IPSAppUILogicRefView wizardPSAppView = null;
    private IPSAppUILogicRefView newDataPSAppView = null;
    private ArrayList<IPSAppUILogicRefView> newDataPSAppViewList = null;
    private ArrayList<IPSAppUILogicRefView> batchAddPSAppViewList = null;

    @Override
    protected void onInit() throws Exception {
        PSAppUILogicRefViewImpl psAppViewLogicRefViewImpl;
        IPSAppViewRef iPSAppViewRef;
        Iterator<IPSAppViewRef> psAppViewRefs;
        IPSAppViewRef iPSAppViewRef2;
        if (!(this.getOwner() instanceof IPSControlMDataContainer)) {
            throw new Exception("\u5f53\u524d\u63a7\u4ef6\u5bb9\u5668\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iPSControlMDataContainer = (IPSControlMDataContainer)this.getOwner();
        if (this.isEnableWizardAdd()) {
            iPSAppViewRef2 = this.getPSControlMDataContainer().getPSAppViewRef("NEWDATAWIZARD", true);
            if (iPSAppViewRef2 == null) {
                iPSAppViewRef2 = this.getPSControlMDataContainer().getPSAppViewRef("NEWDATA", true);
            }
            if (iPSAppViewRef2 == null || iPSAppViewRef2.getRefPSAppView() == null) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u65b0\u5efa\u6570\u636e\u5411\u5bfc\u89c6\u56fe"));
            } else {
                this.wizardPSAppView = new PSAppUILogicRefViewImpl(this, iPSAppViewRef2, "NEWDATAWIZARD", "");
                this.registerPSAppUILogicRefView(this.wizardPSAppView);
            }
        }
        if (!this.isBatchAddOnly() && (iPSAppViewRef2 = this.getPSControlMDataContainer().getPSAppViewRef("NEWDATA", true)) != null && iPSAppViewRef2.getRefPSAppView() != null) {
            this.newDataPSAppView = new PSAppUILogicRefViewImpl(this, iPSAppViewRef2, "NEWDATA", "");
            this.registerPSAppUILogicRefView(this.newDataPSAppView);
            if (this.isEnableWizardAdd()) {
                Iterator<IPSCodeItem> psCodeItems;
                IPSSystemRuntime iPSSystemRuntime;
                IPSCodeList typePSCodeList = null;
                if (this.getPSAppView().getDynaInstMode() == 2 && this.getPSSystem() instanceof IPSSystemRuntime && (iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem())).getDynaInstMode() == 1) {
                    IPSDataEntity iPSDataEntity = null;
                    if (this.getPSAppView() instanceof IPSAppDEView) {
                        iPSDataEntity = ((IPSAppDEView)this.getPSAppView()).getPSDataEntity();
                    }
                    if (iPSDataEntity != null && iPSDataEntity.getDataTypePSDEField() != null && iPSDataEntity.getDataTypePSDEField().getPSCodeList() != null && StringHelper.Compare((String)iPSDataEntity.getDataTypePSDEField().getPSCodeList().getPredefinedType(), (String)"MODULEINST", (boolean)false) == 0) {
                        typePSCodeList = iPSDataEntity.getDataTypePSDEField().getPSCodeList();
                    }
                }
                if (typePSCodeList != null && (psCodeItems = typePSCodeList.getPSCodeItems()) != null) {
                    while (psCodeItems.hasNext()) {
                        IPSCodeItem iPSCodeItem = psCodeItems.next();
                        String strRDMode = iPSCodeItem.getValue();
                        PSAppViewRef psAppViewRef = new PSAppViewRef();
                        String strViewParams = String.format("%1$s%2$s=%3$s", "SRFNAVCTX.", "srfdynainstid", iPSCodeItem.getData());
                        psAppViewRef.setVIEWPARAMS(strViewParams);
                        psAppViewRef.setPSAPPVIEWREFNAME(strRDMode);
                        psAppViewRef.setPSAPPVIEWREFID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strRDMode));
                        psAppViewRef.setMINORPSAPPVIEWID(iPSAppViewRef2.getRefPSAppView().getId());
                        psAppViewRef.set("AUTOMODEL", 1);
                        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
                        psAppViewRefImpl.init(this.getDAGlobalHelper(), this, psAppViewRef);
                        psAppViewRefImpl.setRefPSAppView(iPSAppViewRef2.getRefPSAppView());
                        PSAppUILogicRefViewImpl psAppViewLogicRefViewImpl2 = new PSAppUILogicRefViewImpl(this, psAppViewRefImpl, "NEWDATA", strRDMode);
                        if (this.newDataPSAppViewList == null) {
                            this.newDataPSAppViewList = new ArrayList();
                        }
                        this.newDataPSAppViewList.add(psAppViewLogicRefViewImpl2);
                        this.registerPSAppUILogicRefView(psAppViewLogicRefViewImpl2);
                    }
                }
            }
        }
        if ((psAppViewRefs = this.getPSControlMDataContainer().getPSAppViewRefs("NEWDATA:")) != null) {
            while (psAppViewRefs.hasNext()) {
                if (this.newDataPSAppViewList == null) {
                    this.newDataPSAppViewList = new ArrayList();
                }
                if ((iPSAppViewRef = psAppViewRefs.next()).getRefPSAppView() == null) continue;
                psAppViewLogicRefViewImpl = new PSAppUILogicRefViewImpl(this, iPSAppViewRef, "NEWDATA", iPSAppViewRef.getName().substring(8));
                this.newDataPSAppViewList.add(psAppViewLogicRefViewImpl);
                this.registerPSAppUILogicRefView(psAppViewLogicRefViewImpl);
            }
        }
        if (this.isEnableBatchAdd()) {
            psAppViewRefs = this.getPSControlMDataContainer().getPSAppViewRefs("MPICKUPVIEW:");
            if (psAppViewRefs != null) {
                while (psAppViewRefs.hasNext()) {
                    if (this.batchAddPSAppViewList == null) {
                        this.batchAddPSAppViewList = new ArrayList();
                    }
                    if ((iPSAppViewRef = psAppViewRefs.next()).getRefPSAppView() == null) continue;
                    psAppViewLogicRefViewImpl = new PSAppUILogicRefViewImpl(this, iPSAppViewRef, "BATCHADD", iPSAppViewRef.getName().substring(12));
                    this.batchAddPSAppViewList.add(psAppViewLogicRefViewImpl);
                    this.registerPSAppUILogicRefView(psAppViewLogicRefViewImpl);
                }
            }
            this.setPSAppDataEntity(this.getPSControlMDataContainer().getPSAppDataEntity());
            this.getPSAppDataEntity();
        }
        super.onInit();
    }

    protected IPSControlMDataContainer getPSControlMDataContainer() {
        return this.iPSControlMDataContainer;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6279\u6dfb\u52a0")
    public boolean isEnableBatchAdd() {
        return this.getPSControlMDataContainer().isEnableBatchAdd();
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u652f\u6301\u6279\u6dfb\u52a0")
    public boolean isBatchAddOnly() {
        return this.getPSControlMDataContainer().isBatchAddOnly();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5411\u5bfc\u6dfb\u52a0")
    public boolean isEnableWizardAdd() {
        String strNewDataMode = this.getPSControlMDataContainer().getNewDataMode();
        return StringHelper.Compare((String)strNewDataMode, (String)"INDEXDE", (boolean)true) == 0 || StringHelper.Compare((String)strNewDataMode, (String)"MULTIFORM", (boolean)true) == 0 || StringHelper.Compare((String)strNewDataMode, (String)"WIZARD", (boolean)true) == 0;
    }

    @Override
    @PSModelRTMeta(description="\u5411\u5bfc\u6dfb\u52a0\u540e\u64cd\u4f5c")
    public String getActionAfterWizard() {
        return this.getPSControlMDataContainer().getActionAfterNewDataWizard();
    }

    @Override
    @PSModelRTMeta(description="\u65b0\u5efa\u6570\u636e\u5411\u5bfc\u89c6\u56fe", modeltype="SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase", child=true)
    public IPSAppUILogicRefView getWizardPSAppView() {
        return this.wizardPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u65b0\u5efa\u6570\u636e\u89c6\u56fe", modeltype="SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase", child=true)
    public IPSAppUILogicRefView getNewDataPSAppView() {
        return this.newDataPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6a21\u5f0f\u65b0\u5efa\u6570\u636e\u89c6\u56fe\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase", child=true)
    public Iterator<IPSAppUILogicRefView> getNewDataPSAppViews() {
        if (this.newDataPSAppViewList == null || this.newDataPSAppViewList.size() == 0) {
            return null;
        }
        return this.newDataPSAppViewList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6279\u6dfb\u52a0\u65b0\u5efa\u6570\u636e\u89c6\u56fe\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase", child=true)
    public Iterator<IPSAppUILogicRefView> getBatchAddPSAppViews() {
        if (this.batchAddPSAppViewList == null || this.batchAddPSAppViewList.size() == 0) {
            return null;
        }
        return this.batchAddPSAppViewList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u903b\u8f91\u7c7b\u578b")
    public String getViewLogicType() {
        return "APP_NEWDATA";
    }

    @Override
    @PSModelRTMeta(description="\u6279\u6dfb\u52a0\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEAction getBatchAddPSAppDEAction() {
        return null;
    }
}

