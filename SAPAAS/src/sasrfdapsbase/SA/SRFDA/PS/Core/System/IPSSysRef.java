/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Core.System.IPSSysRefDE;
import SA.SRFDA.PS.Core.System.IPSSysRefMavenRepo;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b50\u7cfb\u7edf\u5f15\u7528\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysRef")
public interface IPSSysRef
extends IPSSystemObject,
IPSSFCodeObject {
    public static final String SYSREFTYPE_SUBSYS = "SUBSYS";
    public static final String SYSREFTYPE_DEVSYS = "DEVSYS";
    public static final String SYSREFTYPE_DEVSYSCLOUD = "DEVSYSCLOUD";
    public static final String SYSREFTYPE_ETLSOURCE = "ETLSOURCE";
    public static final String SYSREFTYPE_ETLMODEL = "ETLMODEL";
    public static final String SYSREFTYPE_CLOUDHUBSUBAPP = "CLOUDHUBSUBAPP";
    public static final String SYSREFTYPE_ETLEXTRACT = "ETLEXTRACT";
    public static final String SYSREFTYPE_ETLTRANSFORM = "ETLTRANSFORM";
    public static final String SYSREFTYPE_ETLLOAD = "ETLLOAD";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysRef var3) throws Exception;

    public IPSSysRefDE getPSSysRefDE(String var1, boolean var2) throws Exception;

    public String getSysRefType();

    public boolean isRuntimeFramework();

    public IPSSysRefMavenRepo getPSSysRefMavenRepo();

    public int getOrderValue();

    public String getRefParam();

    public String getRefParam2();

    public String getRefParam3();

    public String getRefParam4();

    public String getSysCodeName();

    public String getSysPkgName();

    public String getSysName();

    public String getSysVCName();

    public String getDevSlnCodeName();

    public String getDCDomainName();

    public String getSysSrvCodeName();

    public String getPSSubSysId();

    public String getSystemTag();

    public boolean isSubSysAsCloud();

    public String getSysRefTag();

    public Iterator<IPSSystemModule> getPSSystemModules() throws Exception;

    public Properties getRefParams();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public String getRefServiceId();
}

