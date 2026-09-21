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

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemVR;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEGridEditItemVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridEditItemVRImpl
extends PSObjectImpl
implements IPSDEGridEditItemVR {
    private static final Log log = LogFactory.getLog(PSDEGridEditItemVRImpl.class);
    protected IPSDEGrid iPSDEGrid;
    protected PSDEGridEditItemVR psDEGridEditItemVR;
    protected IPSDEFValueRule iPSDEFValueRule = null;
    private IPSDEGridEditItem iPSDEGridEditItem = null;
    private int nCheckMode = 3;
    private String strValueRuleType = "DEFVALUERULE";
    private IPSSysValueRule iPSSysValueRule = null;
    private IPSDEGridColumn iPSDEGridColumn = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEGrid iPSDEGrid, PSDEGridEditItemVR psDEGridEditItemVR) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEGrid = iPSDEGrid;
            this.psDEGridEditItemVR = psDEGridEditItemVR;
            this.setId(psDEGridEditItemVR.getPSDEGEIVRID());
            this.setName(psDEGridEditItemVR.getPSDEGEIVRNAME());
            this.setPSObjectData(psDEGridEditItemVR);
            this.iPSDEGridColumn = this.getPSDEGrid().getPSDEGridColumn(this.psDEGridEditItemVR.getPSDEGRIDCOLID(), false);
            this.iPSDEGridEditItem = this.iPSDEGridColumn.getPSDEGridEditItem();
            if (this.iPSDEGridEditItem == null) {
                throw new Exception(StringHelper.Format((String)"\u6307\u5b9a\u8868\u683c\u5217[%1$s]\u6ca1\u6709\u542f\u7528\u7f16\u8f91", (Object)this.getPSDEGridColumn().getName()));
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEGridEditItemVR.getVRTYPE())) {
                this.strValueRuleType = this.psDEGridEditItemVR.getVRTYPE();
            }
            if ("DEFVALUERULE".equals(this.getValueRuleType())) {
                this.iPSDEFValueRule = iPSDEGrid.getPSDataEntity().getPSDEFValueRule(this.psDEGridEditItemVR.getPSDEFVRID());
            } else if ("SYSVALUERULE".equals(this.getValueRuleType())) {
                this.iPSSysValueRule = iPSDEGrid.getPSDataEntity().getPSSystem().getPSSysValueRule(this.psDEGridEditItemVR.getPSSYSVALUERULEID());
            }
            if (!this.psDEGridEditItemVR.isCHECKMODENull()) {
                this.nCheckMode = this.psDEGridEditItemVR.getCHECKMODE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEGrid.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u540d\u79f0")
    public String getPSDEGridEditItemName() {
        return this.getPSDEGridEditItem().getName();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5bf9\u8c61 ")
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219 ", child=true, fields={"PSDEFVRID"})
    public IPSDEFValueRule getPSDEFValueRule() {
        return this.iPSDEFValueRule;
    }

    public IPSDEGridColumn getPSDEGridColumn() {
        return this.iPSDEGridColumn;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879 ")
    public IPSDEGridEditItem getPSDEGridEditItem() {
        return this.iPSDEGridEditItem;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u6a21\u5f0f", codelist="DEFIVRCheckMode", fields={"CHECKMODE"})
    public int getCheckMode() {
        return this.nCheckMode;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEGrid().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEGrid().getModelId(), (Object)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u7c7b\u578b", codelist="DEFIVRType", fields={"VRTYPE"})
    public String getValueRuleType() {
        return this.strValueRuleType;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219", child=true, fields={"PSSYSVALUERULEID"})
    public IPSSysValueRule getPSSysValueRule() {
        return this.iPSSysValueRule;
    }

    @Override
    public String getModelType() {
        return "PSDEGEIVR";
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

