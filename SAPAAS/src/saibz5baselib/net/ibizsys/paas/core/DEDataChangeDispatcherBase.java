/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataChangeDispatchParam;
import net.ibizsys.paas.core.IDEDataChangeDispatcher;
import net.ibizsys.psrt.srv.common.entity.DEDataChgDisp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DEDataChangeDispatcherBase
implements IDEDataChangeDispatcher {
    private static final Log log = LogFactory.getLog(DEDataChangeDispatcherBase.class);
    protected DEDataChgDisp deDataChgDisp = null;

    @Override
    public void init(DEDataChgDisp deDataChgDisp) throws Exception {
        this.deDataChgDisp = deDataChgDisp;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    @Override
    public String getName() {
        return this.deDataChgDisp.getDEDataChgDispName();
    }

    @Override
    public void dispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
        this.onDispatch(iDEDataChangeDispatchParam);
    }

    protected void onDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
    }
}

