/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelLogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPanelLogicParamImpl
extends PSObjectImpl
implements IPSPanelLogicParam {
    private static final Log log = LogFactory.getLog(PSPanelLogicParamImpl.class);
    protected IPSPanelLogic iPSPanelLogic;
    protected PSPanelLogicParam psPanelLogicParam;
    private String strDataType = null;
    private IPSPanelModel iPSPanelModel = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanelLogic iPSPanelLogic, PSPanelLogicParam psPanelLogicParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSPanelLogic = iPSPanelLogic;
            this.psPanelLogicParam = psPanelLogicParam;
            this.setId(this.psPanelLogicParam.getPSPANELLOGICPARAMID());
            this.setName(this.psPanelLogicParam.getLOGICNAME());
            this.setPSObjectData(this.psPanelLogicParam);
            this.strDataType = this.psPanelLogicParam.getDATATYPE();
            if (StringHelper.compare((String)this.getType(), (String)"PANELMODEL", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psPanelLogicParam.getPSSYSVIEWPANELMODELID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u53c2\u6570\u5f15\u7528\u7684\u9762\u677f\u6a21\u578b");
                }
                this.iPSPanelModel = this.getPSPanelLogic().getPSPanel().getPSPanelModel(this.psPanelLogicParam.getPSSYSVIEWPANELMODELID());
                this.strDataType = this.iPSPanelModel.getDataType();
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
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psPanelLogicParam.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u903b\u8f91\u5bf9\u8c61")
    public IPSPanelLogic getPSPanelLogic() {
        return this.iPSPanelLogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPanelLogic().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSPANELLOGICPARAM";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSPanelLogic().getPSPanel().getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u903b\u8f91\u53c2\u6570\u7c7b\u578b", codelist="PanelLogicParamType")
    public String getType() {
        return this.psPanelLogicParam.getPARAMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u903b\u8f91\u53c2\u6570\u6570\u636e\u7c7b\u578b", codelist="CtrlModelDataType")
    public String getDataType() {
        return this.strDataType;
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6a21\u578b\u5bf9\u8c61")
    public IPSPanelModel getPSPanelModel() {
        return this.iPSPanelModel;
    }
}

