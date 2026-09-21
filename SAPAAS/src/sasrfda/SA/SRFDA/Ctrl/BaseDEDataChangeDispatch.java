/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEDataChgDisp;
import SA.SRFDA.Ctrl.IDEDataChangeDispatch;
import SA.SRFDA.Ctrl.IDEDataChangeDispatchParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDEDataChangeDispatch
implements IDEDataChangeDispatch {
    private static final Log log = LogFactory.getLog(BaseDEDataChangeDispatch.class);
    protected DEDataChgDisp deDataChgDisp = null;
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DEDataChgDisp deDataChgDisp) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.deDataChgDisp = deDataChgDisp;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    protected ISRFDAGlobalHelper getGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    public String getName() {
        return this.deDataChgDisp.getDEDATACHGDISPNAME();
    }

    @Override
    public void Dispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
        this.OnDispatch(iDEDataChangeDispatchParam);
    }

    protected void OnDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
    }
}

