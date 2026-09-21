/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  net.sf.json.JSONObject
 */
package SA.TM.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.TM.Ctrl.Model.TMBTPlanTaskViewModel;
import net.sf.json.JSONObject;

public class TMBTPlanTaskScheduleViewModel
extends MainViewModel {
    protected TMBTPlanTaskViewModel tmBTPlanTaskViewModel = null;

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getTMBTPlanTaskViewModel() != null) {
            try {
                JSONObject item = this.getTMBTPlanTaskViewModel().ToJSONObject();
                jo.put("resview", (Object)item);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public TMBTPlanTaskViewModel getTMBTPlanTaskViewModel() {
        return this.tmBTPlanTaskViewModel;
    }

    public void setTMBTPlanTaskViewModel(TMBTPlanTaskViewModel tmResViewModel) {
        this.tmBTPlanTaskViewModel = tmResViewModel;
    }
}

