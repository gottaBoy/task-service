/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBValueFuncCode;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDBValueFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysDBValueFunc
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String DBVALUEFUNCTYPE_PS = "PS";
    public static final String DBVALUEFUNCTYPE_UX = "UX";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysDBValueFunc var3) throws Exception;

    public int getInputStdDataType();

    public int getOutputStdDataType();

    public IPSSysDBValueFuncCode getFuncCode(String var1) throws Exception;

    public String getDBValueFuncType();

    @Override
    public String getCodeName();

    public String getOutputValueFormat();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSystemModule getPSSystemModule();

    public IPSXCodeObject getRender();

    public String getValueFuncTag();

    public String getValueFuncTag2();
}

