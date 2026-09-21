/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  net.sf.json.JSONObject
 */
package SA.TM.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.TM.Ctrl.Model.TMResViewModel;
import net.sf.json.JSONObject;

public class TMResScheduleViewModel
extends MainViewModel {
    protected TMResViewModel tmResViewModel = null;

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getTMResViewModel() != null) {
            try {
                JSONObject item = this.getTMResViewModel().ToJSONObject();
                jo.put("resview", (Object)item);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public TMResViewModel getTMResViewModel() {
        return this.tmResViewModel;
    }

    public void setTMResViewModel(TMResViewModel tmResViewModel) {
        this.tmResViewModel = tmResViewModel;
    }
}

