/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl.Model;

import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBIRepRPHelper;
import SA.SRFDA.BI.Ctrl.Model.BaseBIObjectModel;
import net.sf.json.JSONObject;

public class BIRepPanelModel
extends BaseBIObjectModel {
    protected IBIRepRPHelper iBIRepRPHelper = null;
    protected IBICubeCache iIBICubeCache = null;
    protected String strModel = null;

    public void Init(IBIRepRPHelper iBIRepRPHelper, IBICubeCache iIBICubeCache) throws Exception {
        this.iBIRepRPHelper = iBIRepRPHelper;
        this.iIBICubeCache = iIBICubeCache;
        this.setCaption(iBIRepRPHelper.getCaption());
        this.setId(this.iBIRepRPHelper.getBIRepPanel().getId());
        this.setModel(this.iBIRepRPHelper.getBIRepPanel().getRepRPModel(iBIRepRPHelper));
    }

    @Override
    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        super.OnFillJSONObject(jsonObject);
        jsonObject.put("model", (Object)this.getModel());
    }

    public String getModel() {
        return this.strModel;
    }

    public void setModel(String strCustomObject) {
        this.strModel = strCustomObject;
    }
}

