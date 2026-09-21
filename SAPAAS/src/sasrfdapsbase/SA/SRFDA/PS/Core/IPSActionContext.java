/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAActionContext
 *  net.ibizsys.paas.service.IService
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.Ctrl.IDAActionContext;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.service.IService;

@PSModelIgnoreMeta
public interface IPSActionContext
extends IDAActionContext {
    public String getLanguage();

    public String getPSSysModelInstId();

    public IService getService(Class var1) throws Exception;
}

