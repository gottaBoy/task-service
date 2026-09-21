/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv;

import net.ibizsys.paas.dao.DAOBase;
import net.ibizsys.paas.entity.IEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSRuntimeSysDAOBase<ET extends IEntity>
extends DAOBase<ET> {
    private static final Log log = LogFactory.getLog(PSRuntimeSysDAOBase.class);
}

