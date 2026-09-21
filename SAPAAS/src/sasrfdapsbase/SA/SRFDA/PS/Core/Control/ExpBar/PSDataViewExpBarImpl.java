/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewParamImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSDataViewExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSDataViewExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSMDControlExpBarImplBase;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"DATAVIEWEXPBAR"})
public class PSDataViewExpBarImpl
extends PSMDControlExpBarImplBase
implements IPSDataViewExpBar {
    public static final String DATAVIEWNAME = "_dataview";
    private IPSDEDataView iPSDEDataView = null;
    private IPSDataViewExpBarParam iPSDataViewExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSDataViewExpBarParam = (IPSDataViewExpBarParam)this.getPSControlParam();
        PSDEDataViewParamImpl psDEDataViewParamImpl = new PSDEDataViewParamImpl();
        PSDEViewCtrl gridPSDEViewCtrl = new PSDEViewCtrl();
        gridPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + DATAVIEWNAME);
        gridPSDEViewCtrl.setPSDEDATAVIEWID(this.iPSDataViewExpBarParam.getPSDEDataViewId());
        gridPSDEViewCtrl.setPSACHANDLERID(this.iPSDataViewExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
        if (!this.iPSDataViewExpBarParam.getPSDEViewCtrlData().isMULTISELECTNull()) {
            gridPSDEViewCtrl.setMULTISELECT(this.iPSDataViewExpBarParam.getPSDEViewCtrlData().getMULTISELECT());
        }
        psDEDataViewParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), gridPSDEViewCtrl);
        if (this.iPSDataViewExpBarParam.getCtrlParamNames() != null) {
            Iterator<String> ctrlParamNames = this.iPSDataViewExpBarParam.getCtrlParamNames();
            while (ctrlParamNames.hasNext()) {
                String strKey = ctrlParamNames.next();
                psDEDataViewParamImpl.setCtrlParam(strKey, this.iPSDataViewExpBarParam.getCtrlParam(strKey));
            }
        }
        this.iPSDEDataView = (IPSDEDataView)this.registerPSControl(String.valueOf(this.getName()) + DATAVIEWNAME, "DATAVIEW", psDEDataViewParamImpl);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5361\u7247\u89c6\u56fe")
    public IPSDEDataView getPSDEDataView() {
        return this.iPSDEDataView;
    }

    @Override
    protected String onGetControlType() {
        return "DATAVIEWEXPBAR";
    }

    @Override
    protected IPSControlNavigatable getPSControlNavigatable() {
        return this.getPSDEDataView();
    }
}

