/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.paas.web.util.UploadDEDataSavePage
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Web;

import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class UploadDEDataSavePage
extends net.ibizsys.paas.web.util.UploadDEDataSavePage {
    protected void onInit() throws Exception {
        String strPSDevSlnSysId = this.getWebContext().getParamValue("PSDEVSLNSYSID");
        if (StringHelper.isNullOrEmpty((String)strPSDevSlnSysId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf");
        }
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
        psDevSlnSysService.get(psDevSlnSys);
        this.setSessionFactory(PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
        PSSystem psSystem = new PSSystem();
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
        psSystemService.get(psSystem);
        psSystem.setPSSysModelInstId(psDevSlnSys.getPSSysModelInstId());
        this.getWebContext().setAttribute("__SYSTEM", (Object)psSystem);
        PSCoreSysServiceBase.setCurrentPSSystemId((String)psDevSlnSys.getPSSystemId());
        PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)psDevSlnSys.getPSDevSlnSysId());
        super.onInit();
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strUserId = request.getHeader("X-SRFUSERID");
        if (StringHelper.isNullOrEmpty((String)strUserId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f53\u524d\u8eab\u4efd");
        }
        String strLoginName = request.getHeader("X-SRFLOGINNAME");
        SimpleWebContext iWebContext = new SimpleWebContext();
        iWebContext.init(this.getRequest(), this.getResponse(), this.getRequest().getSession().getServletContext());
        iWebContext.parseRequest();
        WebContext.setCurrent((IWebContext)iWebContext);
        iWebContext.setSessionValue("SRFPERSONID", (Object)strUserId);
        iWebContext.setSessionValue("SRFLOGINNAME", (Object)strLoginName);
        return iWebContext;
    }

    protected boolean doSaveDatas(Vector<IEntity> dataEntities, boolean bAccess) throws Exception {
        PSSystem psSystem = (PSSystem)this.getWebContext().getAttribute("__SYSTEM");
        for (IEntity iEntity : dataEntities) {
            iEntity.set("pssystemid", (Object)psSystem.getPSSystemId());
            iEntity.set("pssystemname", (Object)psSystem.getPSSystemName());
        }
        if (!StringHelper.isNullOrEmpty((String)psSystem.getPSSysModelInstId())) {
            PSSysModelInstGlobal.active((String)psSystem.getPSSysModelInstId());
        }
        return super.doSaveDatas(dataEntities, bAccess);
    }

    protected void doSaveData(IService iService, String strActionMode, IEntity dataEntity) throws Exception {
        PSSystem psSystem = (PSSystem)this.getWebContext().getAttribute("__SYSTEM");
        if (!StringHelper.isNullOrEmpty((String)psSystem.getPSSysModelInstId())) {
            PSSysModelInstGlobal.active((String)psSystem.getPSSysModelInstId());
        }
        super.doSaveData(iService, strActionMode, dataEntity);
    }
}

