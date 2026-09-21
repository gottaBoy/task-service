/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl.Model;

import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.ITMResViewHelper;
import SA.TM.Ctrl.Model.BaseTMObjectModel;
import SA.TM.Ctrl.Model.TMObjectModel;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TMResViewModel
extends BaseTMObjectModel {
    protected ITMResViewHelper iTMResViewHelper = null;

    public TMResViewModel(ITMResViewHelper iTMResViewHelper) throws Exception {
        this.iTMResViewHelper = iTMResViewHelper;
        this.setId(this.iTMResViewHelper.getId());
        this.setName(this.iTMResViewHelper.getName());
        this.setVersion(this.iTMResViewHelper.getVersion());
    }

    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        super.OnFillJSONObject(jsonObject);
        Vector<JSONObject> tmResViewDetails = new Vector<JSONObject>();
        for (TMResViewDetail tmResViewDetail : this.iTMResViewHelper.getResViewDetails()) {
            TMObjectModel item = new TMObjectModel();
            item.setId(tmResViewDetail.getTMRESBASEID());
            item.setName(tmResViewDetail.getTMRESBASENAME());
            tmResViewDetails.add(item.ToJSONObject());
        }
        jsonObject.put("details", (Object)tmResViewDetails.toArray());
    }
}

