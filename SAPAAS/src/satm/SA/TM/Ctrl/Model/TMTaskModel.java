/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl.Model;

import SA.TM.Ctrl.ITMTaskBaseHelper;
import SA.TM.Ctrl.Model.BaseTMObjectModel;
import net.sf.json.JSONObject;

public class TMTaskModel
extends BaseTMObjectModel {
    protected ITMTaskBaseHelper iTMTaskBaseHelper = null;

    public void Init(ITMTaskBaseHelper iTMTaskBaseHelper) throws Exception {
        this.iTMTaskBaseHelper = iTMTaskBaseHelper;
        this.setId(this.iTMTaskBaseHelper.getId());
    }

    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        super.OnFillJSONObject(jsonObject);
    }
}

