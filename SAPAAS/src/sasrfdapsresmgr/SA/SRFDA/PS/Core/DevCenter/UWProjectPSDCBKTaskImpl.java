/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase
 *  SA.SRFDA.PS.Core.PSTaskServerEnvImpl
 *  SA.SRFDA.PS.Core.Util.CmdHelper
 *  SA.SRFDA.PS.Core.Util.CmdHelper$Result
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.config.service.PSPFStyleService
 *  net.ibizsys.pscore.srv.config.service.PSSFStyleService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import java.io.File;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class UWProjectPSDCBKTaskImpl
extends PSDevCenterBKTaskImplBase {
    private static final Log log = LogFactory.getLog(UWProjectPSDCBKTaskImpl.class);

    protected String onRun() throws Exception {
        String strPSUWProjectId = this.getTaskParam();
        PSUWProject psUWProject = new PSUWProject();
        PSUWProject psUWProject2 = new PSUWProject();
        PSUWProjectService psUWProjectService = (PSUWProjectService)ServiceGlobal.getService(PSUWProjectService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnTemplService psDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFStyleService psPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSFStyleService psSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        String strOwnerId = StringHelper.format((String)"%1$s|%2$s", (Object)psUWProjectService.getDEModel().getName(), (Object)strPSUWProjectId);
        Object strPSWorkspaceId = null;
        Object strPSDevSlnTemplId = null;
        int nLastPSDevSlnTemplState = -1;
        try {
            psUWProject.setPSUWProjectId(strPSUWProjectId);
            psUWProjectService.get(psUWProject);
            PSDevSlnTempl psDevSlnTempl = new PSDevSlnTempl();
            psDevSlnTempl.setPSDevSlnTemplId(psUWProject.getRealProjectId());
            psDevSlnTemplService.get(psDevSlnTempl);
            String strGitUser = "";
            String strGitPassword = "";
            PSSVNServer psSVNServer = null;
            String strGitPath = "";
            if (psDevSlnTempl.getPSDevCenterSVN() != null && psDevSlnTempl.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
                psSVNServer = psDevSlnTempl.getPSDevCenterSVN().getPSSVNInstRepo().getPSSVNServer();
                strGitPath = psDevSlnTempl.getPSDevCenterSVN().getPSSVNInstRepo().getGitPath();
            }
            if (psSVNServer == null) {
                log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f00\u53d1\u6a21\u677f[%1$s]\u7684\u7248\u672c\u670d\u52a1\u5668", (Object)psDevSlnTempl.getPSDevSlnTemplId()));
            } else {
                if (!StringHelper.isNullOrEmpty((String)psSVNServer.getGITUserName())) {
                    strGitUser = psSVNServer.getGITUserName();
                }
                if (!StringHelper.isNullOrEmpty((String)psSVNServer.getGITPassword())) {
                    strGitPassword = psSVNServer.getGITPassword();
                }
            }
            String strFolder = PSTaskServerEnvImpl.getCurrent().createTempFolder("SRCTEMPL");
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$ssynctempl.py %3$s %4$s %5$s %6$s %7$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strFolder, (Object)psUWProject.getSource(), (Object)strGitPath, (Object)strGitUser, (Object)strGitPassword) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$ssynctempl.py %3$s %4$s %5$s %6$s %7$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strFolder, (Object)psUWProject.getSource(), (Object)strGitPath, (Object)strGitUser, (Object)strGitPassword);
            CmdHelper.Result result = CmdHelper.getInstance().executeBat(strCmd);
            psUWProject2.reset();
            psUWProject2.setPSUWProjectId(strPSUWProjectId);
            psUWProject2.setEndTime(DateHelper.getCurTime());
            psUWProject2.setWizardState(DBInstBStateCodeListModel.CREATED);
            psUWProjectService.sysUpdate(psUWProject2, false);
            return "\u5efa\u7acb\u9879\u76ee\u6210\u529f";
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u65b0\u5efa\u9879\u76ee\u5411\u5bfc[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getTaskParam(), (Object)ex.getMessage()), (Throwable)ex);
            try {
                psUWProject2.reset();
                psUWProject2.setPSUWProjectId(strPSUWProjectId);
                psUWProject2.setEndTime(DateHelper.getCurTime());
                psUWProject2.setWizardState(DBInstBStateCodeListModel.FAILED);
                psUWProjectService.sysUpdate(psUWProject2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }
}
