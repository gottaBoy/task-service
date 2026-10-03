/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wf.entity.WFUser
 *  net.ibizsys.psrt.srv.wf.service.WFUserService
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleUser
 *  net.ibizsys.pswf.core.WFProcSysActorRoleModel
 *  net.ibizsys.pswf.core.WFRoleUser
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITIWFProcessModel;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFProcSysActorRoleModel;
import net.ibizsys.pswf.core.WFRoleUser;
import org.hibernate.SessionFactory;

public class PSJITWFProcSysActorRoleModel
extends WFProcSysActorRoleModel {
    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (StringHelper.compare((String)this.getWFProcRoleType(), (String)"CURACTOR", (boolean)true) == 0) {
            ArrayList<IWFRoleUser> wfRoleUserList = new ArrayList<IWFRoleUser>();
            String strWFUserId = iWFActionContext.getOpPersonId();
            if (StringHelper.isNullOrEmpty((String)strWFUserId)) {
                return null;
            }
            WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class, (SessionFactory)((IPSJITIWFProcessModel)this.getWFInteractiveProcessModel()).getPSJITWFVersionModel().getPSJITWFModel().getPSJITSystemModel().getSessionFactory());
            WFUser wfUser = new WFUser();
            wfUser.setWFUserId(strWFUserId);
            wfUserService.get(wfUser);
            wfRoleUserList.add(WFRoleUser.fromWFUser((WFUser)wfUser, null));
            return wfRoleUserList.iterator();
        }
        return null;
    }
}
