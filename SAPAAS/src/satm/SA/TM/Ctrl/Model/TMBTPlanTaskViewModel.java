/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.TM.Ctrl.Model;

import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.Model.BaseTMObjectModel;
import SA.TM.Ctrl.Model.TMObjectModel;
import java.util.Vector;
import net.sf.json.JSONObject;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMBTPlanTaskViewModel
extends BaseTMObjectModel {
    Vector<TMResViewDetail> tmResViewDetails = null;

    @Override
    protected void OnFillJSONObject(JSONObject jsonObject) throws Exception {
        super.OnFillJSONObject(jsonObject);
        if (this.getTMResViewDetails() != null) {
            Vector<JSONObject> tmResViewDetails = new Vector<JSONObject>();
            for (TMResViewDetail tmResViewDetail : this.getTMResViewDetails()) {
                TMObjectModel item = new TMObjectModel();
                item.setId(tmResViewDetail.getTMRESBASEID());
                item.setName(tmResViewDetail.getTMRESBASENAME());
                tmResViewDetails.add(item.ToJSONObject());
            }
            jsonObject.put("details", (Object)tmResViewDetails.toArray());
        }
    }

    public Vector<TMResViewDetail> getTMResViewDetails() {
        return this.tmResViewDetails;
    }

    public void setTMResViewDetails(Vector<TMResViewDetail> tmResViewDetails) {
        this.tmResViewDetails = tmResViewDetails;
    }
}

