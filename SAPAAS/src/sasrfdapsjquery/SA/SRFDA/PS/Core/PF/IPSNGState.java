/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.IPSObject
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSObject;
import java.util.Iterator;
import net.sf.json.JSONObject;

public interface IPSNGState
extends IPSObject {
    public String getFullStateName();

    public IPSNGState getParentState();

    public IPSAppView getPSAppView();

    public Iterator<IPSNGState> getChildStates();

    public int getLevel();

    public String getCId();

    public JSONObject getViewParamJO();

    public String getViewParamJOString();
}

