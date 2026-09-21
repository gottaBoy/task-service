/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.core.IPSModelObject
 *  net.sf.json.JSONObject
 */
package net.ibizsys.model.pf;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.sf.json.JSONObject;

public interface IPSNGState
extends IPSModelObject {
    public String getFullStateName();

    public IPSNGState getParentState();

    public IPSAppView getPSAppView();

    public Iterator<IPSNGState> getChildStates();

    public int getLevel();

    public String getCId();

    public JSONObject getViewParamJO();

    public String getViewParamJOString();
}

