/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.Logic.BuiltinPSAppUILogicImplBase;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUIOpenDataLogic;
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
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class BuiltinPSAppUIOpenDataLogicImpl
extends BuiltinPSAppUILogicImplBase
implements IPSAppUIOpenDataLogic {
    private IPSControlMDataContainer iPSControlMDataContainer = null;
    private IPSAppUILogicRefView openDataPSAppView = null;
    private ArrayList<IPSAppUILogicRefView> openDataPSAppViewList = null;
    private boolean bEditMode = true;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object objOwner, PSSysViewLogic psSysViewLogic, boolean bEditMode) throws Exception {
        this.bEditMode = bEditMode;
        super.init(iDAGlobalHelper, objOwner, psSysViewLogic);
    }

    @Override
    protected void onInit() throws Exception {
        if (!(this.getOwner() instanceof IPSControlMDataContainer)) {
            throw new Exception("\u5f53\u524d\u63a7\u4ef6\u5bb9\u5668\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iPSControlMDataContainer = (IPSControlMDataContainer)this.getOwner();
        IPSAppViewRef iPSAppViewRef = null;
        if (this.isEditMode()) {
            iPSAppViewRef = this.getPSControlMDataContainer().getPSAppViewRef("EDITDATAX", true);
        }
        if (iPSAppViewRef != null && iPSAppViewRef.getRefPSAppView() != null) {
            this.openDataPSAppView = new PSAppUILogicRefViewImpl(this, iPSAppViewRef, "OPENDATA", "");
        } else {
            iPSAppViewRef = null;
            if (!this.isEditMode()) {
                iPSAppViewRef = this.getPSControlMDataContainer().getPSAppViewRef("OPENDATA", true);
            }
            if (iPSAppViewRef == null) {
                iPSAppViewRef = this.getPSControlMDataContainer().getPSAppViewRef("EDITDATA", true);
            }
            if (iPSAppViewRef != null && iPSAppViewRef.getRefPSAppView() != null) {
                Iterator<IPSCodeItem> psCodeItems;
                IPSSystemRuntime iPSSystemRuntime;
                this.openDataPSAppView = new PSAppUILogicRefViewImpl(this, iPSAppViewRef, "OPENDATA", "");
                IPSCodeList typePSCodeList = null;
                if (this.getPSAppView().getDynaInstMode() == 2 && this.getPSSystem() instanceof IPSSystemRuntime && (iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem())).getDynaInstMode() == 1) {
                    IPSDataEntity iPSDataEntity = null;
                    if (this.getPSAppView() instanceof IPSAppDEView) {
                        iPSDataEntity = ((IPSAppDEView)this.getPSAppView()).getPSDataEntity();
                    }
                    if (iPSDataEntity != null && iPSDataEntity.getDataTypePSDEField() != null && iPSDataEntity.getDataTypePSDEField().getPSCodeList() != null && StringHelper.compare((String)iPSDataEntity.getDataTypePSDEField().getPSCodeList().getPredefinedType(), (String)"MODULEINST", (boolean)false) == 0) {
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
                        psAppViewRef.setMINORPSAPPVIEWID(iPSAppViewRef.getRefPSAppView().getId());
                        psAppViewRef.set("AUTOMODEL", 1);
                        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
                        psAppViewRefImpl.init(this.getDAGlobalHelper(), this, psAppViewRef);
                        psAppViewRefImpl.setRefPSAppView(iPSAppViewRef.getRefPSAppView());
                        PSAppUILogicRefViewImpl psAppViewLogicRefViewImpl = new PSAppUILogicRefViewImpl(this, psAppViewRefImpl, "OPENDATA", strRDMode);
                        if (this.openDataPSAppViewList == null) {
                            this.openDataPSAppViewList = new ArrayList();
                        }
                        this.openDataPSAppViewList.add(psAppViewLogicRefViewImpl);
                        this.registerPSAppUILogicRefView(psAppViewLogicRefViewImpl);
                    }
                }
            }
        }
        if (this.openDataPSAppView != null) {
            this.registerPSAppUILogicRefView(this.openDataPSAppView);
        }
        Iterator<IPSAppViewRef> psAppViewRefs = null;
        if (!this.isEditMode()) {
            psAppViewRefs = this.getPSControlMDataContainer().getPSAppViewRefs("OPENDATA:");
            if (psAppViewRefs == null && this.getPSControlMDataContainer().getPSAppViewRef("OPENDATA", true) == null) {
                psAppViewRefs = this.getPSControlMDataContainer().getPSAppViewRefs("EDITDATA:");
            }
        } else {
            psAppViewRefs = this.getPSControlMDataContainer().getPSAppViewRefs("EDITDATA:");
        }
        if (psAppViewRefs != null) {
            while (psAppViewRefs.hasNext()) {
                IPSAppViewRef iPSAppViewRef2;
                if (this.openDataPSAppViewList == null) {
                    this.openDataPSAppViewList = new ArrayList();
                }
                if ((iPSAppViewRef2 = psAppViewRefs.next()).getRefPSAppView() == null) continue;
                PSAppUILogicRefViewImpl psAppViewLogicRefViewImpl = new PSAppUILogicRefViewImpl(this, iPSAppViewRef2, "OPENDATA", iPSAppViewRef2.getName().substring(9));
                this.openDataPSAppViewList.add(psAppViewLogicRefViewImpl);
                this.registerPSAppUILogicRefView(psAppViewLogicRefViewImpl);
            }
        }
        super.onInit();
    }

    protected IPSControlMDataContainer getPSControlMDataContainer() {
        return this.iPSControlMDataContainer;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00\u6570\u636e\u89c6\u56fe", modeltype="SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase", child=true)
    public IPSAppUILogicRefView getOpenDataPSAppView() {
        return this.openDataPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6a21\u5f0f\u6253\u5f00\u6570\u636e\u89c6\u56fe\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase", child=true)
    public Iterator<IPSAppUILogicRefView> getOpenDataPSAppViews() {
        if (this.openDataPSAppViewList == null || this.openDataPSAppViewList.size() == 0) {
            return null;
        }
        return this.openDataPSAppViewList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u903b\u8f91\u7c7b\u578b")
    public String getViewLogicType() {
        return "APP_OPENDATA";
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u6a21\u5f0f")
    public boolean isEditMode() {
        return this.bEditMode;
    }
}

