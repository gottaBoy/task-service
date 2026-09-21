/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.PS.Data.PSAppUtilType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSAppUtilType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSAppUtilType var2) throws Exception;

    public IPSAppUtil createPSAppUtil(PSAppUtil var1) throws Exception;

    public boolean isRegToApp();

    public Iterator<String> getRTParamNames() throws Exception;

    public String getRTParamKey(String var1) throws Exception;
}

