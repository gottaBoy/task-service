/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObj;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserObjServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevUserObjService<ET extends PSDevUserObj>
extends PSDevUserObjServiceBase<ET> {
    private static final Log log = LogFactory.getLog(PSDevUserObjService.class);
}

