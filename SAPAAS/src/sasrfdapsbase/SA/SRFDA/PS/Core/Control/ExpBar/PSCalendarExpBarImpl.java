/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.Control.Calendar.PSSysCalendarParamImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSCalendarExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSCalendarExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSMDControlExpBarImplBase2;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"CALENDAREXPBAR"})
public class PSCalendarExpBarImpl
extends PSMDControlExpBarImplBase2
implements IPSCalendarExpBar {
    public static final String CALENDARNAME = "_calendar";
    private IPSSysCalendar iPSSysCalendar = null;
    private IPSCalendarExpBarParam iPSCalendarExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSCalendarExpBarParam = (IPSCalendarExpBarParam)this.getPSControlParam();
        PSSysCalendarParamImpl psSysCalendarParamImpl = new PSSysCalendarParamImpl();
        PSDEViewCtrl gridPSDEViewCtrl = new PSDEViewCtrl();
        gridPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + CALENDARNAME);
        gridPSDEViewCtrl.setPSSYSCALENDARID(this.iPSCalendarExpBarParam.getPSSysCalendarId());
        gridPSDEViewCtrl.setPSACHANDLERID(this.iPSCalendarExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
        if (this.iPSCalendarExpBarParam.isEnableEdit() != null) {
            gridPSDEViewCtrl.setCTRLPARAM6(this.iPSCalendarExpBarParam.isEnableEdit());
        }
        psSysCalendarParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), gridPSDEViewCtrl);
        if (this.iPSCalendarExpBarParam.getCtrlParamNames() != null) {
            Iterator<String> ctrlParamNames = this.iPSCalendarExpBarParam.getCtrlParamNames();
            while (ctrlParamNames.hasNext()) {
                String strKey = ctrlParamNames.next();
                psSysCalendarParamImpl.setCtrlParam(strKey, this.iPSCalendarExpBarParam.getCtrlParam(strKey));
            }
        }
        this.iPSSysCalendar = (IPSSysCalendar)this.registerPSControl(String.valueOf(this.getName()) + CALENDARNAME, "CALENDAR", psSysCalendarParamImpl);
        super.onInit();
        Iterator<IPSSysCalendarItem> psSysCalendarItems = this.getPSSysCalendar().getPSSysCalendarItems();
        if (psSysCalendarItems != null) {
            while (psSysCalendarItems.hasNext()) {
                IPSSysCalendarItem iPSSysCalendarItem = psSysCalendarItems.next();
                this.registerPSControlObjectNavigatable(iPSSysCalendarItem);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u90e8\u4ef6")
    public IPSSysCalendar getPSSysCalendar() {
        return this.iPSSysCalendar;
    }

    @Override
    protected String onGetControlType() {
        return "CALENDAREXPBAR";
    }

    @Override
    protected IPSControl onGetXDataPSControl() {
        return this.getPSSysCalendar();
    }
}

