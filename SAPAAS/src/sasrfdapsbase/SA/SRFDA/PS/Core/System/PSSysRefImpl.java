/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.PSSFCodeObjectHelper;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSysRefDE;
import SA.SRFDA.PS.Core.System.IPSSysRefMavenRepo;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.System.PSSysRefDEImpl;
import SA.SRFDA.PS.Data.PSDevSlnSys;
import SA.SRFDA.PS.Data.PSSysRef;
import SA.SRFDA.PS.Data.PSSysRefDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysRefImpl
extends PSSystemObjectImpl
implements IPSSysRef {
    private static final Log log = LogFactory.getLog(PSSysRefImpl.class);
    protected PSSysRef psSysRef = null;
    protected Map<String, IPSSysRefDE> psSysRefDEMap = new LinkedHashMap<String, IPSSysRefDE>();
    private Properties classOrPkgNameMap = null;
    private IPSSysRefMavenRepo iPSSysRefMavenRepo = null;
    private int nOrderValue = 10000;
    private String strSysRefType = "SUBSYS";
    private boolean bRuntimeFramework = true;
    private boolean bSubSysAsCloud = false;
    private Properties refParams = null;
    private String strRefServiceId = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysRef psSysRef) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysRef = psSysRef;
            this.setId(this.psSysRef.getPSSYSREFID());
            this.setName(this.psSysRef.getPSSYSREFNAME());
            this.setPSObjectData(this.psSysRef);
            if (!StringHelper.isNullOrEmpty((String)this.psSysRef.getSYSREFTYPE())) {
                this.strSysRefType = this.psSysRef.getSYSREFTYPE();
            }
            if (!this.psSysRef.isSFFWFLAGNull()) {
                this.bRuntimeFramework = this.psSysRef.getSFFWFLAG();
            }
            this.classOrPkgNameMap = SA.SRFramework.UtilityEx.PropertiesHelper.Load((String)this.psSysRef.getCLSPKGPARAMS());
            boolean bl = this.bSubSysAsCloud = StringHelper.compare((String)this.getSysRefType(), (String)"DEVSYSCLOUD", (boolean)false) == 0;
            if (!StringHelper.isNullOrEmpty((String)this.psSysRef.getREFPARAMS())) {
                this.refParams = PropertiesHelper.load((String)this.psSysRef.getREFPARAMS());
            }
            this.onPrepareSysRefDEs();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        StringHelper.compare((String)this.psSysRef.getSYSREFTYPE(), (String)"DEVSYS", (boolean)true);
        super.onInit();
    }

    protected void onPrepareSysRefDEs() throws Exception {
        this.psSysRefDEMap.clear();
        Vector<PSSysRefDE> psSysRefDEList = new Vector<PSSysRefDE>();
        CallResult callResult = this.getPSModelHelper().getPSSysRefDEs(this.getId(), psSysRefDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5f15\u7528\u5b9e\u4f53\u5f15\u7528\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysRefDE psSysRefDE : psSysRefDEList) {
            PSSysRefDEImpl iPSSysRefDE = new PSSysRefDEImpl();
            iPSSysRefDE.init(this.getDAGlobalHelper(), this, psSysRefDE);
            this.psSysRefDEMap.put(iPSSysRefDE.getName(), iPSSysRefDE);
            this.psSysRefDEMap.put(iPSSysRefDE.getId(), iPSSysRefDE);
        }
    }

    @Override
    public IPSSysRefDE getPSSysRefDE(String strName, boolean bTryMode) throws Exception {
        IPSSysRefDE iPSSysRefDE = this.psSysRefDEMap.get(strName);
        if (iPSSysRefDE == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5f15\u7528\u5b9e\u4f53[%1$s]", (Object)strName));
        }
        return iPSSysRefDE;
    }

    @Override
    public String getCodeName() {
        return null;
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        return PSSFCodeObjectHelper.getClassOrPkgName(this, null, this.classOrPkgNameMap, strCodeType, iPSSysSFPub);
    }

    @Override
    public String getModelType() {
        return "PSSYSREF";
    }

    @Override
    public IPSSysRefMavenRepo getPSSysRefMavenRepo() {
        return this.iPSSysRefMavenRepo;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false)
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u7cfb\u7edf\u7c7b\u578b", codelist="SysRefType", group="\u57fa\u672c", order=124, fields={"SYSREFTYPE"})
    public String getSysRefType() {
        return this.strSysRefType;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u6846\u67b6", dump=false)
    public boolean isRuntimeFramework() {
        return this.bRuntimeFramework;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u53c2\u6570", fields={"REFPARAM"})
    public String getRefParam() {
        return this.psSysRef.getREFPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u53c2\u65702", fields={"REFPARAM2"})
    public String getRefParam2() {
        return this.psSysRef.getREFPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u53c2\u65703")
    public String getRefParam3() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u53c2\u65704")
    public String getRefParam4() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4ee3\u7801\u6807\u8bc6", fields={"SYSCODENAME"})
    public String getSysCodeName() {
        return this.psSysRef.getSYSCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5305\u540d\u79f0", fields={"SYSPKGNAME"})
    public String getSysPkgName() {
        return this.psSysRef.getSYSPKGNAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u540d\u79f0", fields={"SYSNAME"})
    public String getSysName() {
        return this.psSysRef.getSYSNAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7248\u672c\u540d\u79f0", fields={"SYSVCNAME"})
    public String getSysVCName() {
        return this.psSysRef.getSYSVCNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u53d1\u65b9\u6848\u4ee3\u7801\u540d\u79f0", dump=false)
    public String getDevSlnCodeName() {
        return this.psSysRef.getDEVSLNCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4e2d\u5fc3\u77ed\u57df\u540d\u79f0", dump=false)
    public String getDCDomainName() {
        return this.psSysRef.getDCDOMAINNAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u53d1\u5e03\u540d\u79f0", fields={"SRVCODENAME"})
    public String getSysSrvCodeName() {
        return this.psSysRef.getSRVCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u5b50\u7cfb\u7edf\u6807\u8bc6", dump=false)
    public String getPSSubSysId() {
        return this.psSysRef.getPSSUBSYSID();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6807\u8bb0", dump=false)
    public String getSystemTag() {
        if (!StringHelper.isNullOrEmpty((String)this.getSysCodeName())) {
            return this.getSysCodeName();
        }
        return this.getPSSubSysId();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u4ee5\u4e91\u670d\u52a1\u65b9\u5f0f\u63d0\u4f9b", dump=false)
    public boolean isSubSysAsCloud() {
        return this.bSubSysAsCloud;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6807\u8bb0", hideempty=true, dump=false)
    public String getDynaModelTag() {
        return this.psSysRef.getREALSYSID();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u7cfb\u7edf\u6807\u8bb0", group="\u57fa\u672c", order=125, fields={"REALSYSID"})
    public String getSysRefTag() {
        return this.psSysRef.getREALSYSID();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getSysRefTag();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757\u96c6\u5408", group="\u57fa\u672c", order=130)
    public Iterator<IPSSystemModule> getPSSystemModules() throws Exception {
        ArrayList<IPSSystemModule> list = new ArrayList<IPSSystemModule>();
        Iterator<IPSSystemModule> psSystemModules = this.getPSSystem().getAllPSSystemModules();
        if (psSystemModules != null) {
            while (psSystemModules.hasNext()) {
                IPSSystemModule iPSSystemModule = psSystemModules.next();
                if (iPSSystemModule.getPSSysRef() == null || StringHelper.compare((String)iPSSystemModule.getPSSysRef().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                list.add(iPSSystemModule);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u53c2\u6570\u96c6\u5408")
    public Properties getRefParams() {
        return this.refParams;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        block4: {
            if (this.iPSSysSFPlugin == null) {
                try {
                    Iterator<IPSSysSFPlugin> psSysSFPlugins = this.getPSSystem().getAllPSSysSFPlugins();
                    if (psSysSFPlugins == null) break block4;
                    while (psSysSFPlugins.hasNext()) {
                        IPSSysSFPlugin item = psSysSFPlugins.next();
                        if (StringHelper.compare((String)"SYSREF", (String)item.getPluginType(), (boolean)false) != 0 || StringHelper.compare((String)this.getSysRefTag(), (String)item.getPluginCode(), (boolean)true) != 0) continue;
                        this.iPSSysSFPlugin = item;
                        break;
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        }
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u670d\u52a1\u6807\u8bc6")
    public String getRefServiceId() {
        if (StringHelper.isNullOrEmpty((String)this.strRefServiceId) && !StringHelper.isNullOrEmpty((String)this.psSysRef.getPSDEVSLNSYSID()) && (StringHelper.compare((String)this.getSysRefType(), (String)"CLOUDHUBSUBAPP", (boolean)false) == 0 || StringHelper.compare((String)this.getSysRefType(), (String)"ETLEXTRACT", (boolean)false) == 0 || StringHelper.compare((String)this.getSysRefType(), (String)"ETLTRANSFORM", (boolean)false) == 0 || StringHelper.compare((String)this.getSysRefType(), (String)"ETLLOAD", (boolean)false) == 0)) {
            try {
                PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                CallResult callResult = this.getPSModelHelper(null).getPSDevSlnSys(this.psSysRef.getPSDEVSLNSYSID(), psDevSlnSys);
                if (callResult.isOk()) {
                    this.strRefServiceId = psDevSlnSys.getDEPLOYSYSID();
                    if (StringHelper.isNullOrEmpty((String)this.strRefServiceId)) {
                        this.strRefServiceId = psDevSlnSys.getPSDEVSLNSYSNAME();
                    }
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.strRefServiceId;
    }
}

