/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSAppType
extends IPSObject {
    public static final String WEBAPP_HTML5 = "WEBAPP_HTML5";
    public static final String MOBILEAPP_HTML5 = "MOBILEAPP_HTML5";

    public void init(ISRFDAGlobalHelper var1, PSAppType var2) throws Exception;

    public boolean isMobileApp();

    public boolean isUseServiceApi();
}

