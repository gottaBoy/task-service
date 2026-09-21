/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSListExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSListExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSMDControlExpBarImplBase;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.PSDEListParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"LISTEXPBAR"})
public class PSListExpBarImpl
extends PSMDControlExpBarImplBase
implements IPSListExpBar {
    public static final String LISTNAME = "_list";
    private IPSDEList iPSDEList = null;
    private IPSListExpBarParam iPSListExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSListExpBarParam = (IPSListExpBarParam)this.getPSControlParam();
        PSDEListParamImpl psDEListParamImpl = new PSDEListParamImpl();
        PSDEViewCtrl gridPSDEViewCtrl = new PSDEViewCtrl();
        gridPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + LISTNAME);
        gridPSDEViewCtrl.setPSDELISTID(this.iPSListExpBarParam.getPSDEListId());
        gridPSDEViewCtrl.setPSACHANDLERID(this.iPSListExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
        if (!this.iPSListExpBarParam.getPSDEViewCtrlData().isMULTISELECTNull()) {
            gridPSDEViewCtrl.setMULTISELECT(this.iPSListExpBarParam.getPSDEViewCtrlData().getMULTISELECT());
        }
        psDEListParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), gridPSDEViewCtrl);
        if (this.iPSListExpBarParam.getCtrlParamNames() != null) {
            Iterator<String> ctrlParamNames = this.iPSListExpBarParam.getCtrlParamNames();
            while (ctrlParamNames.hasNext()) {
                String strKey = ctrlParamNames.next();
                psDEListParamImpl.setCtrlParam(strKey, this.iPSListExpBarParam.getCtrlParam(strKey));
            }
        }
        this.iPSDEList = (IPSDEList)this.registerPSControl(String.valueOf(this.getName()) + LISTNAME, "LIST", psDEListParamImpl);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5217\u8868")
    public IPSDEList getPSDEList() {
        return this.iPSDEList;
    }

    @Override
    protected String onGetControlType() {
        return "LISTEXPBAR";
    }

    @Override
    protected IPSControlNavigatable getPSControlNavigatable() {
        return this.getPSDEList();
    }
}

