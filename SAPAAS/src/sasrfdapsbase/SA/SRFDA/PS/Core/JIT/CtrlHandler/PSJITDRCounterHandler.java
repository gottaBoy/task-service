/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.DRCounterHandlerBase
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.Counter.IPSDEDRCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterItem;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCounterHandler;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.PSJITCustomHandler;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import java.util.Iterator;
import net.ibizsys.paas.ctrlhandler.DRCounterHandlerBase;
import net.ibizsys.paas.demodel.IDataEntityModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITDRCounterHandler
extends DRCounterHandlerBase
implements IPSJITCounterHandler {
    private static final Log log = LogFactory.getLog(PSJITCustomHandler.class);
    private IPSJITSystemModel iPSJITSystemModel = null;
    private IPSSysCounter iPSSysCounter = null;
    private IPSDEDRCounter iPSDEDRCounter = null;

    @Override
    public void init(IPSJITSystemModel iPSJITSystemModel, IPSSysCounter iPSSysCounter) throws Exception {
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSSysCounter = iPSSysCounter;
        this.iPSDEDRCounter = (IPSDEDRCounter)this.iPSSysCounter;
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

    protected void onInit() throws Exception {
        Iterator<IPSSysCounterItem> psSysCounterItems = this.getPSSysCounter().getPSSysCounterItems();
        if (psSysCounterItems != null) {
            while (psSysCounterItems.hasNext()) {
                IPSSysCounterItem iPSSysCounterItem = psSysCounterItems.next();
                this.registerCounterItem(iPSSysCounterItem.getName(), "");
            }
        }
        super.onInit();
    }

    protected IDataEntityModel getDEModel() throws Exception {
        return this.getSystemModel().getDataEntityModel(this.iPSDEDRCounter.getPSDataEntity().getName());
    }
}

