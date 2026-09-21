/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.PSObjectImpl
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PF.IPSNGState;
import SA.SRFDA.PS.Core.PSObjectImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class PSVue2StateImpl
extends PSObjectImpl
implements IPSNGState {
    private IPSNGState parentState = null;
    private int nLevel = 0;
    private ArrayList<IPSNGState> childStateList = new ArrayList();
    private String strFullStateName = "";
    private IPSAppView iPSAppView = null;
    private int nIndex = 0;
    private String strCId = "";
    private JSONObject viewParamJO = null;
    private HashMap<String, IPSNGState> psChildStateMap = new HashMap();

    public void init(IPSNGState parentState, String strName) {
        this.parentState = parentState;
        strName = strName.toLowerCase();
        this.setName(strName);
        if (this.parentState != null) {
            this.strFullStateName = StringHelper.format((String)"%1$s.%2$s", (Object)parentState.getFullStateName(), (Object)this.getName());
            this.nLevel = parentState.getLevel() + 1;
        } else {
            this.strFullStateName = strName;
        }
    }

    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getFullStateName() {
        return this.strFullStateName;
    }

    @Override
    public IPSNGState getParentState() {
        return this.parentState;
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    @Override
    public Iterator<IPSNGState> getChildStates() {
        return this.childStateList.iterator();
    }

    public ArrayList<IPSNGState> getChildStateList() {
        return this.childStateList;
    }

    public void addChildState(IPSNGState state) {
        if (!this.psChildStateMap.containsKey(state.getName())) {
            this.childStateList.add(state);
            this.psChildStateMap.put(state.getName(), state);
        }
    }

    @Override
    public int getLevel() {
        return this.nLevel;
    }

    public void setIndex(int nIndex) {
        this.nIndex = nIndex;
        this.strCId = this.nIndex == 0 ? "" : StringHelper.format((String)"C%1$s", (Object)this.nIndex);
    }

    @Override
    public String getCId() {
        return this.strCId;
    }

    @Override
    public JSONObject getViewParamJO() {
        return this.viewParamJO;
    }

    public void setViewParamJO(JSONObject viewParamJO) {
        this.viewParamJO = viewParamJO;
    }

    @Override
    public String getViewParamJOString() {
        if (this.getViewParamJO() != null) {
            return this.getViewParamJO().toString();
        }
        return "";
    }

    public void setLevel(int level) {
        this.nLevel = level;
    }
}

