/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Data.PSSFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

@PSModelIgnoreMeta
public interface IPSSFPluginTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSSFPluginTempl var2) throws Exception;

    public String getCode(String var1);

    public IPSSF getPSSF();

    public BaseDataEntity getPSSFPluginTemplData();
}

