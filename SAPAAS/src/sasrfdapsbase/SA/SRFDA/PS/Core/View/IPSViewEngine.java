/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSViewEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSViewEngine
extends IPSObject {
    public static final String ENGINETYPE_VIEW = "VIEW";
    public static final String ENGINETYPE_PLUGIN = "PLUGIN";

    public void init(ISRFDAGlobalHelper var1, PSViewEngine var2) throws Exception;

    public String getEngineType();

    public String getEngineObj();
}

