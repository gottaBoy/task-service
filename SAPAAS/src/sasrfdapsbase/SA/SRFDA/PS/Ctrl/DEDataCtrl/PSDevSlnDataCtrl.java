/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Deploy.IPSMavenServerType;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Ctrl.Util.PSDevSlnGitLabHelper;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import java.util.Random;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDevSlnDataCtrl.class);
    public static final String CUSTOMCALL_INITMAVENREPO = "INITMAVENREPO";
    public static final String CUSTOMCALL_UPDATEMAVENREPOADMIN = "UPDATEMAVENREPOADMIN";
    public static final String CUSTOMCALL_UPDATEMAVENREPOGUEST = "UPDATEMAVENREPOGUEST";
    public static final String CUSTOMCALL_SYNCGITLAB = "SYNCGITLAB";
    public static final String CUSTOMCALL_FIXPSDCSVNS = "FIXPSDCSVNS";
    private static final Random random = new Random();

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_INITMAVENREPO, (boolean)true) == 0) {
            return this.initMavenRepo(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_UPDATEMAVENREPOADMIN, (boolean)true) == 0) {
            return this.updateMavenRepo(dataEntity, 1);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_UPDATEMAVENREPOGUEST, (boolean)true) == 0) {
            return this.updateMavenRepo(dataEntity, 2);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_SYNCGITLAB, (boolean)true) == 0) {
            return this.syncGitLab(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_FIXPSDCSVNS, (boolean)true) == 0) {
            return this.fixPSDCSVNs(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initMavenRepo(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevSlnDataCtrl.this.onInitMavenRepo(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u4e2d\u5fc3\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitMavenRepo(BaseDataEntity dataEntity2) throws Exception {
        PSDevSln psDevSln = new PSDevSln();
        PSDEDataCtrl.convertEntity2(dataEntity2, (IEntity)psDevSln);
        net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo psMavenRepo = new net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo();
        psMavenRepo.setPSMavenRepoId(KeyValueHelper.genUniqueId((String)"PSDEVSLN", (String)psDevSln.getPSDevSlnId()));
        if (psMavenRepo.get(true)) {
            return;
        }
        PSMavenServer psMavenServer = new PSMavenServer();
        psMavenServer.setPSSvrDomainId(psDevSln.getPSDevCenter().getPSSvrDomainId());
        psMavenServer.setValidFlag(Integer.valueOf(1));
        if (!psMavenServer.select(true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u670d\u52a1\u57dfMaven\u670d\u52a1\u5668");
        }
        psMavenRepo.setPSMavenRepoName(StringHelper.format((String)"%1$s__%2$s", (Object)psDevSln.getPSDevCenter().getDomainName().toLowerCase(), (Object)psDevSln.getCodeName().toLowerCase()));
        psMavenRepo.setLogicName(StringHelper.format((String)"[%1$s]Maven\u4ed3\u5e93", (Object)psDevSln.getPSDevSlnName()));
        psMavenRepo.setRepoState(Integer.valueOf(20));
        psMavenRepo.setPSMavenServerId(psMavenServer.getPSMavenServerId());
        psMavenRepo.setPSMavenServerName(psMavenServer.getPSMavenServerName());
        psMavenRepo.setPSSvrDomainId(psMavenServer.getPSSvrDomainId());
        psMavenRepo.setPSSvrDomainName(psMavenServer.getPSSvrDomainName());
        psMavenRepo.setPSObjType("PSDEVSLN");
        psMavenRepo.setPSObjId(psDevSln.getPSDevSlnId());
        psMavenRepo.setPSObjName(psDevSln.getPSDevSlnName());
        psMavenRepo.setPSDevCenterId(psDevSln.getPSDevCenterId());
        psMavenRepo.setPSDevCenterName(psDevSln.getPSDevCenterName());
        psMavenRepo.setValidFlag(Integer.valueOf(1));
        psMavenRepo.setConnStr(StringHelper.format((String)"%1$s/%2$s", (Object)psMavenServer.getMavenUrl(), (Object)psMavenRepo.getPSMavenRepoName()));
        psMavenRepo.setMavenUserName(StringHelper.format((String)"admin@%2$s.maven.%1$s", (Object)psDevSln.getPSDevCenter().getFullDomainName(), (Object)psDevSln.getCodeName().toLowerCase()));
        psMavenRepo.setMavenPasswd(this.calcPassword());
        psMavenRepo.setROUserName(StringHelper.format((String)"guest@%2$s.maven.%1$s", (Object)psDevSln.getPSDevCenter().getFullDomainName(), (Object)psDevSln.getCodeName().toLowerCase()));
        psMavenRepo.setROPasswd(this.calcPassword());
        psMavenRepo.create();
        PSMavenRepo psMavenRepo2 = new PSMavenRepo();
        PSDEDataCtrl.convertEntity((IEntity)psMavenRepo, psMavenRepo2);
        IPSMavenServerType iPSMavenServerType = this.getPSModelStorage().getPSMavenServerType(psMavenServer.getMavenServerType());
        iPSMavenServerType.createMavenRepo(psMavenRepo2);
    }

    protected String calcPassword() {
        String strSource = Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 8);
        String strPassword = "";
        int i = 0;
        while (i < 8) {
            int nPos = random.nextInt(100) % 5;
            strPassword = nPos == 0 ? String.valueOf(strPassword) + "@" : (nPos == 2 ? String.valueOf(strPassword) + strSource.substring(i, i + 1).toUpperCase() : String.valueOf(strPassword) + strSource.substring(i, i + 1));
            ++i;
        }
        return strPassword;
    }

    public CallResult updateMavenRepo(BaseDataEntity dataEntity, int nMode) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            final int nMode2 = nMode;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevSlnDataCtrl.this.onUpdateMavenRepo(dataEntity2, nMode2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u5f00\u53d1\u65b9\u6848\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUpdateMavenRepo(BaseDataEntity dataEntity2, int nMode) throws Exception {
        PSDevSln psDevSln = new PSDevSln();
        PSDEDataCtrl.convertEntity2(dataEntity2, (IEntity)psDevSln);
        net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo psMavenRepo = new net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo();
        psMavenRepo.setPSMavenRepoId(KeyValueHelper.genUniqueId((String)"PSDEVSLN", (String)psDevSln.getPSDevSlnId()));
        if (!psMavenRepo.get(true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u65b9\u6848Maven\u4ed3\u5e93");
        }
        PSMavenRepo psMavenRepo2 = new PSMavenRepo();
        PSDEDataCtrl.convertEntity((IEntity)psMavenRepo, psMavenRepo2);
        IPSMavenServerType iPSMavenServerType = this.getPSModelStorage().getPSMavenServerType(psMavenRepo.getPSMavenServer().getMavenServerType());
        iPSMavenServerType.updateMavenRepo(psMavenRepo2, nMode);
    }

    public CallResult syncGitLab(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevSlnDataCtrl.this.onSyncGitLab(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u540c\u6b65GitLab\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncGitLab(BaseDataEntity dataEntity2) throws Exception {
        PSDevSln psDevSln = new PSDevSln();
        PSDEDataCtrl.convertEntity2(dataEntity2, (IEntity)psDevSln);
        PSDevSlnService psDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnService.get((IEntity)psDevSln);
        PSDevSlnGitLabHelper psDevSlnGitLabHelper = new PSDevSlnGitLabHelper();
        psDevSlnGitLabHelper.convertV6toV7(psDevSln);
    }

    public CallResult fixPSDCSVNs(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevSlnDataCtrl.this.onFixPSDCSVNs(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u540c\u6b65GitLab\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onFixPSDCSVNs(BaseDataEntity dataEntity2) throws Exception {
        PSDevSln psDevSln = new PSDevSln();
        PSDEDataCtrl.convertEntity2(dataEntity2, (IEntity)psDevSln);
        PSDevSlnService psDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnService.fixPSDCSVNs(psDevSln);
    }
}

