/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.EditView2Model;
import net.sf.json.JSONObject;

public class WizardStepViewModel
extends EditView2Model {
    protected boolean bNext = false;
    protected boolean bFinish = false;
    protected boolean bPrev = false;

    public boolean isNext() {
        return this.bNext;
    }

    public void setNext(boolean bNext) {
        this.bNext = bNext;
    }

    public boolean isPrev() {
        return this.bPrev;
    }

    public void setPrev(boolean bPrev) {
        this.bPrev = bPrev;
    }

    public boolean isFinish() {
        return this.bFinish;
    }

    public void setFinish(boolean bFinish) {
        this.bFinish = bFinish;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.isNext()) {
            jo.put("enablenext", true);
        }
        if (this.isFinish()) {
            jo.put("enablefinish", true);
        }
        if (this.isPrev()) {
            jo.put("enableprev", true);
        }
    }
}

