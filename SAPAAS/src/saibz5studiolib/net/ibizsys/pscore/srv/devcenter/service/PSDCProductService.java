/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.pscore.srv.devcenter.entity.PSDCProduct;
import net.ibizsys.pscore.srv.devcenter.service.PSDCProductServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCProductService<ET extends PSDCProduct>
extends PSDCProductServiceBase<ET> {
    private static final Log log = LogFactory.getLog(PSDCProductService.class);
}

