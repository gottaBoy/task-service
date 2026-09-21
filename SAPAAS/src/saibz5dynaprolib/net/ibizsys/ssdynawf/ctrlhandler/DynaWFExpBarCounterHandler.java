/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.pswf.ctrlhandler.WFExpBarCounterHandler
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdynawf.ctrlhandler;

import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.pswf.ctrlhandler.WFExpBarCounterHandler;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCounterHandler;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaWFExpBarCounterHandler
extends WFExpBarCounterHandler
implements IDynaCounterHandler {
    private static final Log log = LogFactory.getLog(DynaWFExpBarCounterHandler.class);
    private IDynaSysModel iDynaSysModel = null;
    private IPSSysCounter iPSSysCounter = null;

    @Override
    public void init(IDynaSysModel iDynaSysModel, IPSSysCounter iPSSysCounter) throws Exception {
        this.iDynaSysModel = iDynaSysModel;
        this.iPSSysCounter = iPSSysCounter;
        this.setId(this.iPSSysCounter.getId());
        this.setName(this.iPSSysCounter.getName());
        this.onInit();
    }

    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    public IDynaSysModel getSystemModel() {
        return this.iDynaSysModel;
    }
}

