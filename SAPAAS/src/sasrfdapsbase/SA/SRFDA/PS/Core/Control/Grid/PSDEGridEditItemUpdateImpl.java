/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGEIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGEIUpdateDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEGEIUDetail;
import SA.SRFDA.PS.Data.PSDEGEIUpdate;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridEditItemUpdateImpl
extends PSObjectImpl
implements IPSDEGridEditItemUpdate {
    private static final Log log = LogFactory.getLog(PSDEGridEditItemUpdateImpl.class);
    private IPSDEGrid iPSDEGrid;
    private PSDEGEIUpdate psDEGEIUpdate;
    private IPSDEAction iPSDEAction = null;
    private IPSAppDEMethod iPSAppDEMethod = null;
    private boolean bShowBusyIndicator = true;
    private boolean bCustomCode = false;
    protected ArrayList<IPSDEGEIUpdateDetail> psDEGEIUpdateDetailList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEGrid iPSDEGrid, PSDEGEIUpdate psDEGEIUpdate) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEGrid = iPSDEGrid;
            this.psDEGEIUpdate = psDEGEIUpdate;
            this.setId(psDEGEIUpdate.getPSDEGEIUPDATEID());
            this.setName(psDEGEIUpdate.getPSDEGEIUPDATENAME());
            this.setPSObjectData(psDEGEIUpdate);
            if (!this.psDEGEIUpdate.isCUSTOMMODENull()) {
                this.bCustomCode = this.psDEGEIUpdate.getCUSTOMMODE();
            }
            if (!this.isCustomCode()) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGEIUpdate.getPSDEACTIONID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a");
                }
                this.iPSDEAction = iPSDEGrid.getPSDataEntity().getPSDEAction(psDEGEIUpdate.getPSDEACTIONID());
                if (this.getPSDEGrid() != null && this.getPSDEGrid().getPSAppDataEntity() != null && this.getPSDEAction() != null) {
                    this.iPSAppDEMethod = this.getPSDEGrid().getPSAppDataEntity().getPSAppDEMethod(this.getPSDEAction(), true);
                }
            }
            if (!this.psDEGEIUpdate.isBUSYINDICATORNull()) {
                this.bShowBusyIndicator = this.psDEGEIUpdate.getBUSYINDICATOR();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEGEIUpdateDetails();
    }

    protected void onPreparePSDEGEIUpdateDetails() throws Exception {
        this.psDEGEIUpdateDetailList.clear();
        ArrayList<PSDEGEIUDetail> psDEGEIUDetailList = this.psDEGEIUpdate.getPSDEGEIUDetails(false);
        if (psDEGEIUDetailList == null) {
            return;
        }
        for (PSDEGEIUDetail psDEGEIUDetail : psDEGEIUDetailList) {
            PSDEGEIUpdateDetailImpl psDEGEIUpdateDetailImpl = new PSDEGEIUpdateDetailImpl();
            psDEGEIUpdateDetailImpl.init(this.getDAGlobalHelper(), this, psDEGEIUDetail);
            this.psDEGEIUpdateDetailList.add(psDEGEIUpdateDetailImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSDEGEIUpdateDetail> getPSDEGEIUpdateDetails() {
        return this.psDEGEIUpdateDetailList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDEGEIUpdate.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u683c\u5bf9\u8c61")
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getPSDEAction() throws Exception {
        return this.iPSDEAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEGrid.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEGEIUPDATE";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEGrid() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEGrid().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEGrid().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEGrid().getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5904\u7406\u63d0\u793a", ignoredumpvalues="true", fields={"BUSYINDICATOR"})
    public boolean isShowBusyIndicator() {
        return this.bShowBusyIndicator;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5", dumpref=true, from="IPSAppDataEntity", fields={"PSDEACTIONID"})
    public IPSAppDEMethod getPSAppDEMethod() throws Exception {
        return this.iPSAppDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u811a\u672c\u4ee3\u7801", ignoredumpvalues="false", fields={"CUSTOMMODE"})
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        if (this.isCustomCode()) {
            return this.psDEGEIUpdate.getCUSTOMCODE();
        }
        return "";
    }
}

