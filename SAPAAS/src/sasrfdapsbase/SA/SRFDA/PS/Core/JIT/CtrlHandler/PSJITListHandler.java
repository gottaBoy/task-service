/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.ListHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IListModel
 *  net.ibizsys.paas.db.DBFetchResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSDEListHandler;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.ListHandlerBase;
import net.ibizsys.paas.ctrlmodel.IListModel;
import net.ibizsys.paas.db.DBFetchResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITListHandler
extends ListHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITListHandler.class);
    private IPSControl iPSControl = null;
    private IListModel iListModel = null;
    private IPSDEListHandler iPSDEListHandler = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEList getPSDEList() {
        return (IPSDEList)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDEList iPSDEList = this.getPSDEList();
        if (this.getPSDEList().getPSAjaxControlHandler() != null) {
            this.iPSDEListHandler = (IPSDEListHandler)this.getPSDEList().getPSAjaxControlHandler();
        }
        this.iListModel = (IListModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IListModel getListModel() {
        return this.iListModel;
    }

    public IPSDEListHandler getPSDEListHandler() {
        return this.iPSDEListHandler;
    }

    protected void prepareDataAccessActions() throws Exception {
        super.prepareDataAccessActions();
        if (this.getPSDEListHandler() != null) {
            Iterator<String> ajaxActions = this.getPSDEListHandler().getAjaxActions();
            while (ajaxActions.hasNext()) {
                this.registerDataAccessAction(ajaxActions.next(), "NONE");
            }
        }
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContext) throws Exception {
        if (this.getPSDEListHandler() != null && this.getPSDEListHandler().getPSDEDataSet() != null) {
            return this.getService().fetchDataSet(this.getPSDEListHandler().getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
        }
        return this.getService().fetchDataSet(this.getPSDEList().getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
    }

    public int getTempMode() {
        if (this.getPSDEListHandler() != null && this.getPSDEListHandler().getTempMode() > 0) {
            return this.getPSDEListHandler().getTempMode();
        }
        return super.getTempMode();
    }
}

