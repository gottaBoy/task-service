/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSUIEngineType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSUIEngineType
extends IPSObject {
    public static final int ENGINEPARAMMODE_DISABLE = 0;
    public static final int ENGINEPARAMMODE_ENABLE = 1;
    public static final int ENGINEPARAMMODE_MUST = 2;

    public void init(ISRFDAGlobalHelper var1, PSUIEngineType var2) throws Exception;

    public Iterator<String> getEngineParamNames() throws Exception;

    public String getEngineParamKey(String var1) throws Exception;

    public String getEngineCat();

    public String getTypeCode();

    public int getEngineParamMode(String var1) throws Exception;
}

