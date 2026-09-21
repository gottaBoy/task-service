/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.CAL.Web.ViewModel;

import SA.SRFDA.CAL.Web.ViewModel.CalendarModel;
import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import java.util.Collection;
import java.util.Vector;
import net.sf.json.JSONObject;

public class CalendarViewModel
extends MainViewModel {
    protected CalendarModel calendarModel = new CalendarModel();
    protected Vector calTypeList = null;

    public CalendarViewModel() {
        this.RegisterCtrlModel("calendar", this.calendarModel);
    }

    public CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public Vector getCalTypeStyleList() {
        return this.calTypeList;
    }

    public void setCalTypeStyleList(Vector calTypeList) {
        this.calTypeList = calTypeList;
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getCalTypeStyleList() != null) {
            jo.put("caltypestyles", (Collection)this.getCalTypeStyleList());
        }
    }
}

