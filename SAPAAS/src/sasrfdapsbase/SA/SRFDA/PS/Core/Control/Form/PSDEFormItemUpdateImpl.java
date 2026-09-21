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
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.PSDEFIUpdateDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFIUDetail;
import SA.SRFDA.PS.Data.PSDEFIUpdate;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormItemUpdateImpl
extends PSObjectImpl
implements IPSDEFormItemUpdate {
    private static final Log log = LogFactory.getLog(PSDEFormItemUpdateImpl.class);
    private IPSDEForm iPSDEForm;
    private PSDEFIUpdate psDEFIUpdate;
    private IPSDEAction iPSDEAction = null;
    private boolean bShowBusyIndicator = true;
    private IPSAppDEMethod iPSAppDEMethod = null;
    private boolean bCustomCode = false;
    protected ArrayList<IPSDEFIUpdateDetail> psDEFIUpdateDetailList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEForm iPSDEForm, PSDEFIUpdate psDEFIUpdate) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEForm = iPSDEForm;
            this.psDEFIUpdate = psDEFIUpdate;
            this.setId(psDEFIUpdate.getPSDEFIUPDATEID());
            this.setName(psDEFIUpdate.getPSDEFIUPDATENAME());
            this.setPSObjectData(psDEFIUpdate);
            if (!this.psDEFIUpdate.isCUSTOMMODENull()) {
                this.bCustomCode = this.psDEFIUpdate.getCUSTOMMODE();
            }
            if (!this.isCustomCode()) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFIUpdate.getPSDEACTIONID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a");
                }
                this.iPSDEAction = iPSDEForm.getPSDataEntity().getPSDEAction(psDEFIUpdate.getPSDEACTIONID());
                if (this.getPSDEForm() != null && this.getPSDEForm().getPSAppDataEntity() != null && this.getPSDEAction() != null) {
                    this.iPSAppDEMethod = this.getPSDEForm().getPSAppDataEntity().getPSAppDEMethod(this.getPSDEAction(), true);
                }
            }
            if (!this.psDEFIUpdate.isBUSYINDICATORNull()) {
                this.bShowBusyIndicator = this.psDEFIUpdate.getBUSYINDICATOR();
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
        this.onPreparePSDEFIUpdateDetails();
    }

    protected void onPreparePSDEFIUpdateDetails() throws Exception {
        this.psDEFIUpdateDetailList.clear();
        ArrayList<PSDEFIUDetail> psDEFIUDetailList = this.psDEFIUpdate.getPSDEFIUDetails(false);
        if (psDEFIUDetailList == null) {
            return;
        }
        for (PSDEFIUDetail psDEFIUDetail : psDEFIUDetailList) {
            PSDEFIUpdateDetailImpl psDEFIUpdateDetailImpl = new PSDEFIUpdateDetailImpl();
            psDEFIUpdateDetailImpl.init(this.getDAGlobalHelper(), this, psDEFIUDetail);
            this.psDEFIUpdateDetailList.add(psDEFIUpdateDetailImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSDEFIUpdateDetail> getPSDEFIUpdateDetails() {
        return this.psDEFIUpdateDetailList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDEFIUpdate.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u5355\u5bf9\u8c61")
    public IPSDEForm getPSDEForm() {
        return this.iPSDEForm;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getPSDEAction() throws Exception {
        return this.iPSDEAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEForm.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEFIUPDATE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEForm().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEForm().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEForm().getModelId(), (Object)this.getCodeName());
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
            return this.psDEFIUpdate.getCUSTOMCODE();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u72b6\u6001", ignorert=3, ignoredumpvalues="0", fields={"MODELSTATE"})
    public int getModelState() {
        if (!this.psDEFIUpdate.isMODELSTATENull()) {
            return this.psDEFIUpdate.getMODELSTATE();
        }
        return 0;
    }
}

