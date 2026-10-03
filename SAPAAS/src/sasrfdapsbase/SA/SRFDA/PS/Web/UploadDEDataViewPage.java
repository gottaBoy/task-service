/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.paas.web.util.UploadDEDataViewPage
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 */
package SA.SRFDA.PS.Web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;

public class UploadDEDataViewPage
extends net.ibizsys.paas.web.util.UploadDEDataViewPage {
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

    public String outputTemplPath() {
        String strPSDevSlnSysId = this.getWebContext().getParamValue("PSDEVSLNSYSID");
        String strPath = super.outputTemplPath();
        strPath = WebUtility.appendURLSeperator((String)strPath);
        strPath = String.valueOf(strPath) + StringHelper.format((String)"PSDEVSLNSYSID=%1$s", (Object)WebUtility.encodeURLParamValue((String)strPSDevSlnSysId));
        return strPath;
    }
}

