/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SRFExGridRowActionResult
extends SRFExAjaxActionResult {
    protected JSONObject objRow = null;
    protected Vector errors = new Vector();
    protected Vector items = new Vector();
    protected boolean bRowDirty = false;

    public void setRow(JSONObject value) {
        this.objRow = value;
    }

    public JSONObject getRow() {
        return this.objRow;
    }

    public Vector getErrors() {
        return this.errors;
    }

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (this.objRow != null) {
            objJSON.put("row", (Object)this.objRow);
        }
        if (this.items.size() != 0) {
            objJSON.put("rows", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
        }
        objJSON.put("errors", (Object)JSONArray.fromArray((Object[])this.errors.toArray()));
        objJSON.put("rowdirty", this.bRowDirty);
    }

    public Vector getItems() {
        return this.items;
    }

    public boolean isRowDirty() {
        return this.bRowDirty;
    }

    public void setRowDirty(boolean bRowDirty) {
        this.bRowDirty = bRowDirty;
    }
}

