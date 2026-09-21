/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMapView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataView2Impl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMAPVIEW", "DEMAPVIEW9"})
public class PSAppDEMapViewImpl
extends PSAppDEMultiDataView2Impl
implements IPSAppDEMapView {
    private static final Log log = LogFactory.getLog(PSAppDEMapViewImpl.class);
    private IPSSysMap iPSSysMap = null;

    @Override
    protected boolean isEnableQuickSearchDefault() {
        return false;
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("map");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSSysMap) {
            this.iPSSysMap = (IPSSysMap)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSSysMap getPSSysMap() {
        return this.iPSSysMap;
    }

    @Override
    protected String onGetXDataControlName() {
        return "map";
    }
}

