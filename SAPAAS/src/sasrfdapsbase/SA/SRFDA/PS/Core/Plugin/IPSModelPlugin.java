/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Plugin;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSModelPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSModelPlugin
extends IPSObject {
    public static final String PLUGINTYPE_DIFF = "DIFF";
    public static final String PLUGINTYPE_CHECK = "CHECK";

    public void init(ISRFDAGlobalHelper var1, PSModelPlugin var2) throws Exception;

    public String getPluginType();
}

