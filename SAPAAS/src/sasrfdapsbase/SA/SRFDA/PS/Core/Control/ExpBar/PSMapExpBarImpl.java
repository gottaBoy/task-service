/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSMapExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSMapExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSMDControlExpBarImplBase2;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapItem;
import SA.SRFDA.PS.Core.Control.Map.PSSysMapParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"MAPEXPBAR"})
public class PSMapExpBarImpl
extends PSMDControlExpBarImplBase2
implements IPSMapExpBar {
    public static final String MAPNAME = "_map";
    private IPSSysMap iPSSysMap = null;
    private IPSMapExpBarParam iPSMapExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSMapExpBarParam = (IPSMapExpBarParam)this.getPSControlParam();
        PSSysMapParamImpl psSysMapParamImpl = new PSSysMapParamImpl();
        PSDEViewCtrl gridPSDEViewCtrl = new PSDEViewCtrl();
        gridPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + MAPNAME);
        gridPSDEViewCtrl.setPSSYSMAPVIEWID(this.iPSMapExpBarParam.getPSSysMapId());
        gridPSDEViewCtrl.setPSACHANDLERID(this.iPSMapExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
        psSysMapParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), gridPSDEViewCtrl);
        if (this.iPSMapExpBarParam.getCtrlParamNames() != null) {
            Iterator<String> ctrlParamNames = this.iPSMapExpBarParam.getCtrlParamNames();
            while (ctrlParamNames.hasNext()) {
                String strKey = ctrlParamNames.next();
                psSysMapParamImpl.setCtrlParam(strKey, this.iPSMapExpBarParam.getCtrlParam(strKey));
            }
        }
        this.iPSSysMap = (IPSSysMap)this.registerPSControl(String.valueOf(this.getName()) + MAPNAME, "MAP", psSysMapParamImpl);
        super.onInit();
        Iterator<IPSSysMapItem> psSysMapItems = this.getPSSysMap().getPSSysMapItems();
        if (psSysMapItems != null) {
            while (psSysMapItems.hasNext()) {
                IPSSysMapItem iPSSysMapItem = psSysMapItems.next();
                this.registerPSControlObjectNavigatable(iPSSysMapItem);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5730\u56fe\u90e8\u4ef6")
    public IPSSysMap getPSSysMap() {
        return this.iPSSysMap;
    }

    @Override
    protected String onGetControlType() {
        return "MAPEXPBAR";
    }

    @Override
    protected IPSControl onGetXDataPSControl() {
        return this.getPSSysMap();
    }
}

