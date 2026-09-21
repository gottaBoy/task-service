/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSGridExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSGridExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSMDControlExpBarImplBase;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"GRIDEXPBAR"})
public class PSGridExpBarImpl
extends PSMDControlExpBarImplBase
implements IPSGridExpBar {
    public static final String GRIDNAME = "_grid";
    private IPSDEGrid iPSDEGrid = null;
    private IPSGridExpBarParam iPSGridExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSGridExpBarParam = (IPSGridExpBarParam)this.getPSControlParam();
        PSDEGridParamImpl psDEGridParamImpl = new PSDEGridParamImpl();
        PSDEViewCtrl gridPSDEViewCtrl = new PSDEViewCtrl();
        gridPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + GRIDNAME);
        gridPSDEViewCtrl.setPSDEGRIDID(this.iPSGridExpBarParam.getPSDEGridId());
        gridPSDEViewCtrl.setPSACHANDLERID(this.iPSGridExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
        if (!this.iPSGridExpBarParam.getPSDEViewCtrlData().isMULTISELECTNull()) {
            gridPSDEViewCtrl.setMULTISELECT(this.iPSGridExpBarParam.getPSDEViewCtrlData().getMULTISELECT());
        }
        psDEGridParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), gridPSDEViewCtrl);
        if (this.iPSGridExpBarParam.getCtrlParamNames() != null) {
            Iterator<String> ctrlParamNames = this.iPSGridExpBarParam.getCtrlParamNames();
            while (ctrlParamNames.hasNext()) {
                String strKey = ctrlParamNames.next();
                psDEGridParamImpl.setCtrlParam(strKey, this.iPSGridExpBarParam.getCtrlParam(strKey));
            }
        }
        this.iPSDEGrid = (IPSDEGrid)this.registerPSControl(String.valueOf(this.getName()) + GRIDNAME, "GRID", psDEGridParamImpl);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u683c")
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @Override
    protected String onGetControlType() {
        return "GRIDEXPBAR";
    }

    @Override
    protected IPSControlNavigatable getPSControlNavigatable() {
        return this.getPSDEGrid();
    }
}

