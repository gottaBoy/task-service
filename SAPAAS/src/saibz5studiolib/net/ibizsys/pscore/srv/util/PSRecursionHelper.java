/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSModels;

public class PSRecursionHelper {
    public static <T> T execute(IPSRecursionWork<T> iPSRecursionWork, IPSModelObject iPSModelObject) throws Exception {
        return PSRecursionHelper.execute(iPSRecursionWork, iPSModelObject, null);
    }

    public static <T> T execute(IPSRecursionWork<T> iPSRecursionWork, IPSModelObject iPSModelObject, Object object) throws Exception {
        boolean bl = false;
        ActionSession actionSession = null;
        try {
            actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bl = true;
                actionSession = ActionSessionManager.openSession((String)"PSRECURSIONHELPER");
                actionSession.registerRecursion(iPSModelObject.getModelType(), (Object)iPSModelObject.getId());
            } else if (!actionSession.registerRecursion(iPSModelObject.getModelType(), (Object)iPSModelObject.getId())) {
                throw new Exception(StringHelper.format((String)"%1$s[%2$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)PSModels.getModelName(iPSModelObject.getModelType()), (Object)iPSModelObject.getFullName()));
            }
            T t = iPSRecursionWork.execute(object);
            actionSession.unregisterRecursion(iPSModelObject.getModelType(), (Object)iPSModelObject.getId());
            if (bl) {
                ActionSessionManager.closeSession();
            }
            return t;
        }
        catch (Exception exception) {
            if (bl) {
                ActionSessionManager.closeSession();
            }
            throw exception;
        }
    }
}

