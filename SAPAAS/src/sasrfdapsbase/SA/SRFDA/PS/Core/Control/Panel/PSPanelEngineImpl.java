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

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.PSAppViewEngineImplBase;
import SA.SRFDA.PS.Core.App.View.PSAppViewEngineParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelEngine;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSPanelEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPanelEngineImpl
extends PSAppViewEngineImplBase
implements IPSPanelEngine {
    private static final Log log = LogFactory.getLog(PSPanelEngineImpl.class);
    private IPSPanel iPSPanel = null;
    private PSPanelEngine psPanelEngine = null;
    private IPSUIEngineType iPSUIEngineType = null;
    private int nOrderValue = 99999;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPanel iPSPanel, PSPanelEngine psPanelEngine) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSPanel = iPSPanel;
            this.psPanelEngine = psPanelEngine;
            this.setId(this.psPanelEngine.getPSPANELENGINEID());
            this.setName(this.psPanelEngine.getPSPANELENGINENAME());
            this.setPSObjectData(this.psPanelEngine);
            if (this.getPSUIEngineType() == null) {
                this.iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(this.psPanelEngine.getPSUIENGINETYPEID());
            }
            if (!psPanelEngine.isORDERVALUENull() && psPanelEngine.getORDERVALUE() >= 0) {
                this.nOrderValue = psPanelEngine.getORDERVALUE();
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
        Iterator<String> engineParams = this.getPSUIEngineType().getEngineParamNames();
        if (engineParams != null) {
            while (engineParams.hasNext()) {
                PSAppViewEngineParamImpl psAppViewEngineParamImpl;
                String strKey = engineParams.next();
                String strValue = this.getPSUIEngineType().getEngineParamKey(strKey);
                if (StringHelper.isNullOrEmpty((String)strValue)) continue;
                if (strValue.indexOf("PSDEVIEWCTRLNAME") != -1) {
                    String strCtrlName = this.psPanelEngine.getParamStringValue(strValue = strValue.replace("PSDEVIEWCTRLNAME", "PSPANELITEMNAME"), "");
                    if (StringHelper.isNullOrEmpty((String)strCtrlName)) continue;
                    if (!this.getPSPanel().hasPSControl(strCtrlName)) {
                        throw new Exception(StringHelper.format((String)"\u9762\u677f\u4e0d\u5b58\u5728\u6307\u5b9a\u90e8\u4ef6[%1$s]", (Object)strCtrlName));
                    }
                    final IPSControl iPSControl = this.getPSPanel().getPSControl(strCtrlName);
                    psAppViewEngineParamImpl = new PSAppViewEngineParamImpl();
                    psAppViewEngineParamImpl.init(this.getDAGlobalHelper(), this, strKey, "CTRL", iPSControl);
                    this.registerPSAppViewEngineParam(psAppViewEngineParamImpl);
                    String strEventsKey = StringHelper.format((String)"%1$s.EVENTS", (Object)strKey);
                    final String strEvents = this.getPSUIEngineType().getEngineParamKey(strEventsKey);
                    if (StringHelper.isNullOrEmpty((String)strEvents)) continue;
                    final String strLogicTag = StringHelper.format((String)"%1$s_%2$s", (Object)this.getName(), (Object)iPSControl.getName()).toLowerCase();
                    iPSControl.registerPSControlLogic(new PSControlLogicImpl(this){

                        @Override
                        public String getName() {
                            return strLogicTag;
                        }

                        @Override
                        public String getLogicTag() {
                            return iPSControl.getName();
                        }

                        @Override
                        public String getEventNames() {
                            return strEvents;
                        }

                        @Override
                        public IPSAppViewEngine getPSAppViewEngine() {
                            return (IPSAppViewEngine)this.getOwner();
                        }
                    });
                    continue;
                }
                if (strValue.indexOf("PSDEVIEWLOGICNAME") != -1) {
                    String strLogicName = this.psPanelEngine.getParamStringValue(strValue = strValue.replace("PSDEVIEWLOGICNAME", "PSPANELLOGICNAME"), "");
                    if (StringHelper.isNullOrEmpty((String)strLogicName)) continue;
                    IPSAppViewLogic iPSAppViewLogic = this.getPSPanel().getPSAppViewLogic(strLogicName, true);
                    if (iPSAppViewLogic == null) {
                        throw new Exception(StringHelper.format((String)"\u9762\u677f\u4e0d\u5b58\u5728\u6307\u5b9a\u903b\u8f91[%1$s]", (Object)strLogicName));
                    }
                    psAppViewEngineParamImpl = new PSAppViewEngineParamImpl();
                    psAppViewEngineParamImpl.init(this.getDAGlobalHelper(), this, strKey, "LOGIC", iPSAppViewLogic);
                    this.registerPSAppViewEngineParam(psAppViewEngineParamImpl);
                    continue;
                }
                if (strValue.indexOf("ENGINEPARAM") != 0 && strValue.indexOf("VIEWPARAM") != 0 && strValue.indexOf("WFVIEWPARAM") != 0) continue;
                Object objValue = this.psPanelEngine.get(strValue);
                PSAppViewEngineParamImpl psAppViewEngineParamImpl2 = new PSAppViewEngineParamImpl();
                psAppViewEngineParamImpl2.init(this.getDAGlobalHelper(), this, strKey, "VALUE", objValue);
                this.registerPSAppViewEngineParam(psAppViewEngineParamImpl2);
            }
        }
        super.onInit();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSPanel().getPSAppView();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppView().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u64ce\u7c7b\u578b")
    public String getEngineType() {
        return this.getPSUIEngineType().getTypeCode();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u64ce\u5206\u7c7b")
    public String getEngineCat() {
        return this.getPSUIEngineType().getEngineCat();
    }

    public IPSUIEngineType getPSUIEngineType() {
        return this.iPSUIEngineType;
    }

    protected void setPSUIEngineType(IPSUIEngineType iPSUIEngineType) {
        this.iPSUIEngineType = iPSUIEngineType;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
    }

    @Override
    public IPSPanel getPSPanel() {
        return this.iPSPanel;
    }

    @Override
    public String getModelType() {
        return "PSPANELENGINE";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSPanel().getModelId(), (Object)this.getId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSPanel().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u52a0\u8f7d\u6392\u5e8f\u503c", dump=false)
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public String getCodeName() {
        return this.getName();
    }
}

