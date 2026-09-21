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
 *  net.ibizsys.pswf.core.WFProcUDActorRoleModel
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
import net.ibizsys.pswf.core.WFProcUDActorRoleModel;
import net.ibizsys.pswf.core.WFRoleUser;
import org.hibernate.SessionFactory;

public class PSJITWFProcUDActorRoleModel
extends WFProcUDActorRoleModel {
    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        if (this.getUDFields() != null) {
            WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class, (SessionFactory)((IPSJITIWFProcessModel)this.getWFInteractiveProcessModel()).getPSJITWFVersionModel().getPSJITWFModel().getPSJITSystemModel().getSessionFactory());
            ArrayList<IWFRoleUser> wfRoleUserList = new ArrayList<IWFRoleUser>();
            String[] stringArray = this.getUDFields();
            int n = stringArray.length;
            int n2 = 0;
            while (n2 < n) {
                String strUDField = stringArray[n2];
                String strWFUserId = (String)iWFActionContext.getActiveEntity().get(strUDField);
                if (!StringHelper.isNullOrEmpty((String)strWFUserId)) {
                    WFUser wfUser = new WFUser();
                    wfUser.setWFUserId(strWFUserId);
                    wfUserService.get((IEntity)wfUser);
                    wfRoleUserList.add(WFRoleUser.fromWFUser((WFUser)wfUser, null));
                }
                ++n2;
            }
            return wfRoleUserList.iterator();
        }
        return null;
    }
}

