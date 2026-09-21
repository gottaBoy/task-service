/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  net.sf.json.JSONObject
 */
package SA.TM.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.TM.Ctrl.Model.TMBTPlanResViewModel;
import net.sf.json.JSONObject;

public class TMBTPlanResScheduleViewModel
extends MainViewModel {
    protected TMBTPlanResViewModel tmBTPlanResViewModel = null;

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getTMBTPlanResViewModel() != null) {
            try {
                JSONObject item = this.getTMBTPlanResViewModel().ToJSONObject();
                jo.put("resview", (Object)item);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public TMBTPlanResViewModel getTMBTPlanResViewModel() {
        return this.tmBTPlanResViewModel;
    }

    public void setTMBTPlanResViewModel(TMBTPlanResViewModel tmResViewModel) {
        this.tmBTPlanResViewModel = tmResViewModel;
    }
}

