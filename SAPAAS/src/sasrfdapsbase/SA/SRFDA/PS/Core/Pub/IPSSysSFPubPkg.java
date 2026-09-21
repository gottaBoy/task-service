/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Data.PSSysSFPubPkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysSFPubPkg
extends IPSModelObject,
IPSSFPkgVer {
    public void init(ISRFDAGlobalHelper var1, IPSSysSFPub var2, PSSysSFPubPkg var3) throws Exception;

    public IPSSysSFPub getPSSysSFPub();

    @Override
    public IPSSFPkg getPSSFPkg();

    public IPSSFPkgVer getPSSFPkgVer();

    public String getPkgParam();

    public int getOrderValue();

    public String getPkgParam2();

    public String getPkgParam3();

    public String getPkgParam4();

    @Override
    public String getVerTag();

    @Override
    public String getVerTag2();

    @Override
    public String getVerParam();
}

