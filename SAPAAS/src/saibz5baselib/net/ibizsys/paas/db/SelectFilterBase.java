/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.db;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.db.ISelectFilter;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public abstract class SelectFilterBase
extends ModelBaseImpl
implements ISelectFilter,
IDEDataQueryCodeCond {
    public static final String ATTR_CONDTYPE = "type";
    protected String strCondOp = null;
    protected String strDEFName = null;
    protected String strCondValue = null;
    protected String strCustomCond = null;
    protected String strDEFieldExp = null;
    protected int nStdDataType = 0;
    protected boolean bNotMode = false;
    protected String strValueFunc = null;

    @Override
    public String getDEFName() {
        return this.strDEFName;
    }

    @Override
    public String getCondOp() {
        return this.strCondOp;
    }

    public void setCondOp(String strCondOp) {
        this.strCondOp = strCondOp;
    }

    @Override
    public String getCondValue() {
        return this.strCondValue;
    }

    @Override
    public String getCustomCond() {
        return this.strCustomCond;
    }

    @Override
    @Deprecated
    public String getPredefindedCond() {
        return null;
    }

    @Override
    public String getPredefinedCode() {
        return null;
    }

    @Override
    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
        return null;
    }

    @Override
    public String getDEFieldExp() {
        return this.strDEFieldExp;
    }

    @Override
    public boolean isNotMode() {
        return this.bNotMode;
    }

    @Override
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    public String getValueFunc() {
        return this.strValueFunc;
    }

    protected static JSONObject toJSONObject(ISelectFilter iSelectFilter, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        JSONObjectHelper.put(jsonObject, ATTR_CONDTYPE, iSelectFilter.getCondType());
        return jsonObject;
    }

    protected static ISelectFilter fromJSONObject(JSONObject jsonObject, SelectFilterBase selectFilterBase) throws Exception {
        return selectFilterBase;
    }
}

