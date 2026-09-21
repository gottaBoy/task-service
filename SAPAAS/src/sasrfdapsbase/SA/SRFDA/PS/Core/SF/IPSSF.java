/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.SF.IPSSFACHandler;
import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.IPSSFPubObj;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Data.PSSF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSF
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSSF var2) throws Exception;

    public IPSSFStyle getPSSFStyle(String var1) throws Exception;

    public IPSSFStyle getPSSFStyle(String var1, boolean var2) throws Exception;

    public void resetPSSFStyle(String var1) throws Exception;

    public IPSSFACHandler getPSSFACHandler(String var1) throws Exception;

    public void resetPSSFACHandler(String var1) throws Exception;

    public boolean isPkgLowercase();

    public IPSSFPkg getPSSFPkg(String var1) throws Exception;

    public void resetPSSFPkg(String var1) throws Exception;

    public IPSSFPkgVer getPSSFPkgVer(String var1) throws Exception;

    public void resetPSSFPkgVer(String var1) throws Exception;

    public IPSSFStyleParam getPSSFStyleParam(String var1) throws Exception;

    public void resetPSSFStyleParam(String var1) throws Exception;

    public IPSSFPubObj getPSSFPubObj(String var1, boolean var2) throws Exception;

    public IPSSFPubObj getPSSFPubObjByTarget(String var1, boolean var2) throws Exception;

    public void resetPSSFPubObj(String var1) throws Exception;

    public String getClassOrPkgName(String var1) throws Exception;

    public boolean isCodeFramework();

    public boolean isDocFramework();
}

