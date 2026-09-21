/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import net.ibizsys.pscore.srv.paasmgr.entity.PSProduct;
import net.ibizsys.pscore.srv.paasmgr.service.PSProductServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSProductService<ET extends PSProduct>
extends PSProductServiceBase<ET> {
    private static final Log log = LogFactory.getLog(PSProductService.class);
}

