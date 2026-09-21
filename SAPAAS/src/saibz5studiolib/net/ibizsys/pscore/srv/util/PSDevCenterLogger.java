/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  org.hibernate.SessionFactory
 *  org.hibernate.internal.util.StringHelper
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterLog;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterLogService;
import net.ibizsys.pscore.srv.util.PSDCInstGlobal;
import org.hibernate.SessionFactory;
import org.hibernate.internal.util.StringHelper;

public class PSDevCenterLogger {
    public static void log(PSDevCenterLog pSDevCenterLog, String string) throws Exception {
        PSDevCenterLogService pSDevCenterLogService = null;
        pSDevCenterLogService = StringHelper.isEmpty((String)string) ? (PSDevCenterLogService)ServiceGlobal.getService(PSDevCenterLogService.class) : (PSDevCenterLogService)ServiceGlobal.getService(PSDevCenterLogService.class, (SessionFactory)PSDCInstGlobal.getSessionFactory(string));
        pSDevCenterLogService.create(pSDevCenterLog, false);
    }
}

