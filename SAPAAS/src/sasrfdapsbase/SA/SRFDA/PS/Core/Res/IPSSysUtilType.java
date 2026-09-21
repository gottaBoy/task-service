/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Data.PSSysUtil;
import SA.SRFDA.PS.Data.PSSysUtilType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSSysUtilType
extends IPSObject,
IPSSFCodeObject {
    public void init(ISRFDAGlobalHelper var1, PSSysUtilType var2) throws Exception;

    public IPSSysUtil createPSSysUtil(PSSysUtil var1) throws Exception;

    public String getBaseClass(String var1) throws Exception;

    public boolean isRegToSys();

    public Iterator<String> getRTParamNames() throws Exception;

    public String getRTParamKey(String var1) throws Exception;

    public String getClassOrPkgName(String var1, IPSSysSFPub var2, boolean var3) throws Exception;
}

