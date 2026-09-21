/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Data.PSSysTestPrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u9879\u76ee\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysTestPrj")
public interface IPSSysTestPrj
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String PRJTYPE_SYSAPP = "SYSAPP";
    public static final String PRJTYPE_SYSSERVICEAPI = "SYSSERVICEAPI";
    public static final String PRJTYPE_USER = "USER";
    public static final String PRJTYPE_USER2 = "USER2";
    public static final String PRJTYPE_USER3 = "USER3";
    public static final String PRJTYPE_USER4 = "USER4";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysTestPrj var3) throws Exception;

    public String getPrjType();

    public Iterator<IPSSysTestModule> getPSSysTestModules();

    @Override
    public String getCodeName();

    public String getPrjTag();

    public String getPrjTag2();

    public IPSSystemModule getPSSystemModule();

    public IPSSysServiceAPI getPSSysServiceAPI();

    public IPSApplication getPSApplication();

    public IPSModelObject getTargetPSModel();
}

