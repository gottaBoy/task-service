/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class IndexViewModel
extends MainViewModel {
    protected String strContainerTransition = "";
    protected int nLeftBarWidth = 0;

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getLeftBarWidth() > 0) {
            jo.put("leftbarwidth", this.getLeftBarWidth());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getContainerTransition())) {
            jo.put("containertransition", (Object)this.getContainerTransition());
        }
    }

    public String getContainerTransition() {
        return this.strContainerTransition;
    }

    public void setContainerTransition(String strContainerTransition) {
        this.strContainerTransition = strContainerTransition;
    }

    public int getLeftBarWidth() {
        return this.nLeftBarWidth;
    }

    public void setLeftBarWidth(int nLeftBarWidth) {
        this.nLeftBarWidth = nLeftBarWidth;
    }
}

