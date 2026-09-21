/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarImpl;
import SA.SRFDA.PS.Core.Control.IPSControlObjectNavigatable;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.sf.json.JSONObject;

public abstract class PSMDControlExpBarImplBase2
extends PSExpBarImpl {
    @Override
    protected void onInit() throws Exception {
        if (this.getXDataPSControl() != null && this.isPrepareDefaultPSAppViewLogics()) {
            this.getXDataPSControl().registerPSControlLogic(new PSControlLogicImpl(this){

                @Override
                public String getName() {
                    return StringHelper.Format((String)"%1$s_selectionchange", (Object)super.getName());
                }

                @Override
                public String getLogicTag() {
                    return PSMDControlExpBarImplBase2.this.getXDataPSControl().getName();
                }

                @Override
                public String getEventNames() {
                    return "SELECTIONCHANGE";
                }
            });
            this.getXDataPSControl().registerPSControlLogic(new PSControlLogicImpl(this){

                @Override
                public String getName() {
                    return StringHelper.Format((String)"%1$s_load", (Object)super.getName());
                }

                @Override
                public String getLogicTag() {
                    return PSMDControlExpBarImplBase2.this.getXDataPSControl().getName();
                }

                @Override
                public String getEventNames() {
                    return "LOAD";
                }
            });
        }
        super.onInit();
    }

    protected void registerPSControlObjectNavigatable(IPSControlObjectNavigatable iPSControlObjectNavigatable) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)iPSControlObjectNavigatable.getNavPSDEViewId())) {
            String strKey;
            Iterator keys;
            boolean bIFrameMode = false;
            if (this.getPSAppView() instanceof IPSAppExplorerView) {
                bIFrameMode = ((IPSAppExplorerView)this.getPSAppView()).isIFrameMode();
            }
            boolean bRegisterPSAppViewRefToContainer = !this.isPrepareDefaultPSAppViewLogics();
            String strExpId = iPSControlObjectNavigatable.getNavDataType();
            String strViewRefMode = StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strExpId);
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
            String strRefModeText = iPSControlObjectNavigatable.getLogicName();
            if (StringHelper.IsNullOrEmpty((String)strRefModeText)) {
                strRefModeText = iPSControlObjectNavigatable.getName();
            }
            psAppViewRef.setREFMODETEXT(StringHelper.Format((String)"[%1$s]\u5bfc\u822a\u89c6\u56fe", (Object)strRefModeText));
            psAppViewRef.setMINORPSAPPVIEWID(iPSControlObjectNavigatable.getNavPSAppView().getId());
            if (!bIFrameMode) {
                psAppViewRef.setParamValue("EMBEDVIEWID", iPSControlObjectNavigatable.getNavEmbeddedViewId());
            }
            IPSAppViewRef ipsAppViewRef = null;
            ipsAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
            if (iPSControlObjectNavigatable.getNavViewParamJO() != null) {
                JSONObject joViewParam = ipsAppViewRef.getViewParam(true);
                keys = iPSControlObjectNavigatable.getNavViewParamJO().keys();
                while (keys.hasNext()) {
                    strKey = keys.next().toString();
                    joViewParam.put(strKey, iPSControlObjectNavigatable.getNavViewParamJO().get(strKey));
                }
            }
            if (!bRegisterPSAppViewRefToContainer) {
                JSONObject parentDataJO = ipsAppViewRef.getParentDataJO(true);
                if (iPSControlObjectNavigatable.getNavViewParamJO() != null) {
                    keys = iPSControlObjectNavigatable.getNavViewParamJO().keys();
                    while (keys.hasNext()) {
                        strKey = keys.next().toString();
                        if (parentDataJO.has(strKey)) continue;
                        parentDataJO.put(strKey, iPSControlObjectNavigatable.getNavViewParamJO().get(strKey));
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)iPSControlObjectNavigatable.getNavFilter()) && !parentDataJO.has("srfparentdefname")) {
                    parentDataJO.put("srfparentdefname", (Object)iPSControlObjectNavigatable.getNavFilter());
                }
                if (iPSControlObjectNavigatable.getNavPSDER() != null && iPSControlObjectNavigatable.getNavPSDER() instanceof IPSDER1N) {
                    IPSDER1N iPSDER1N = (IPSDER1N)iPSControlObjectNavigatable.getNavPSDER();
                    if (!parentDataJO.has("srfparentmode")) {
                        parentDataJO.put("srfparentmode", (Object)iPSDER1N.getName());
                    }
                    if (!parentDataJO.has("srfparentdename")) {
                        parentDataJO.put("srfparentdename", (Object)iPSDER1N.getMajorDEName());
                    }
                    if (!parentDataJO.has("srfparentdefname")) {
                        parentDataJO.put("srfparentdefname", (Object)iPSDER1N.getPickupDEFName());
                    }
                }
            }
        }
    }

    @Override
    public String getModelScope() {
        return "DE";
    }
}

