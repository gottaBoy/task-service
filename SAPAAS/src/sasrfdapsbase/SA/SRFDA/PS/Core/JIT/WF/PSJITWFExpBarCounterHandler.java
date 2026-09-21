/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.ctrlhandler.WFExpBarCounterHandler
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCounterHandler;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import net.ibizsys.pswf.ctrlhandler.WFExpBarCounterHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITWFExpBarCounterHandler
extends WFExpBarCounterHandler
implements IPSJITCounterHandler {
    private static final Log log = LogFactory.getLog(PSJITWFExpBarCounterHandler.class);
    private IPSJITSystemModel iPSJITSystemModel = null;
    private IPSSysCounter iPSSysCounter = null;

    @Override
    public void init(IPSJITSystemModel iPSJITSystemModel, IPSSysCounter iPSSysCounter) throws Exception {
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSSysCounter = iPSSysCounter;
        this.setId(this.iPSSysCounter.getId());
        this.setName(this.iPSSysCounter.getName());
        this.onInit();
    }

    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    public IPSJITSystemModel getSystemModel() {
        return this.iPSJITSystemModel;
    }
}

