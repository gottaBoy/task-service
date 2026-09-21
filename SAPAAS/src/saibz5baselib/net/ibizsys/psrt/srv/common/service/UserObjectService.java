/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.service.UserObjectServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserObjectService<ET extends UserObject>
extends UserObjectServiceBase<ET> {
    private static final Log log = LogFactory.getLog(UserObjectService.class);
}

