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
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.sf.json.JSONObject;

public abstract class PSMDControlExpBarImplBase
extends PSExpBarImpl {
    @Override
    protected void onInit() throws Exception {
        if (this.getPSControlNavigatable() != null) {
            boolean bIFrameMode = false;
            if (this.getPSAppView() instanceof IPSAppExplorerView) {
                bIFrameMode = ((IPSAppExplorerView)this.getPSAppView()).isIFrameMode();
            }
            if (this.isPrepareDefaultPSAppViewLogics()) {
                this.getPSControlNavigatable().registerPSControlLogic(new PSControlLogicImpl(this){

                    @Override
                    public String getName() {
                        return StringHelper.Format((String)"%1$s_selectionchange", (Object)super.getName());
                    }

                    @Override
                    public String getLogicTag() {
                        return PSMDControlExpBarImplBase.this.getPSControlNavigatable().getName();
                    }

                    @Override
                    public String getEventNames() {
                        return "SELECTIONCHANGE";
                    }
                });
                this.getPSControlNavigatable().registerPSControlLogic(new PSControlLogicImpl(this){

                    @Override
                    public String getName() {
                        return StringHelper.Format((String)"%1$s_load", (Object)super.getName());
                    }

                    @Override
                    public String getLogicTag() {
                        return PSMDControlExpBarImplBase.this.getPSControlNavigatable().getName();
                    }

                    @Override
                    public String getEventNames() {
                        return "LOAD";
                    }
                });
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getPSControlNavigatable().getNavPSDEViewId())) {
                String strKey;
                Iterator keys;
                boolean bRegisterPSAppViewRefToContainer = !this.isPrepareDefaultPSAppViewLogics();
                String strExpId = this.getPSControlNavigatable().getNavDataType();
                String strViewRefMode = StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)strExpId);
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                String strRefModeText = this.getPSControlNavigatable().getLogicName();
                if (StringHelper.IsNullOrEmpty((String)strRefModeText)) {
                    strRefModeText = this.getPSControlNavigatable().getName();
                }
                psAppViewRef.setREFMODETEXT(StringHelper.Format((String)"[%1$s]\u5bfc\u822a\u89c6\u56fe", (Object)strRefModeText));
                psAppViewRef.setMINORPSAPPVIEWID(this.getPSControlNavigatable().getNavPSAppView().getId());
                if (!bIFrameMode) {
                    psAppViewRef.setParamValue("EMBEDVIEWID", this.getPSControlNavigatable().getNavEmbeddedViewId());
                }
                IPSAppViewRef ipsAppViewRef = null;
                ipsAppViewRef = bRegisterPSAppViewRefToContainer ? this.getPSControlContainer().registerPSAppViewRef(psAppViewRef) : this.registerPSAppViewRef(psAppViewRef);
                if (this.getPSControlNavigatable().getNavViewParamJO() != null) {
                    JSONObject joViewParam = ipsAppViewRef.getViewParam(true);
                    keys = this.getPSControlNavigatable().getNavViewParamJO().keys();
                    while (keys.hasNext()) {
                        strKey = keys.next().toString();
                        joViewParam.put(strKey, this.getPSControlNavigatable().getNavViewParamJO().get(strKey));
                    }
                }
                if (!bRegisterPSAppViewRefToContainer) {
                    JSONObject parentDataJO = ipsAppViewRef.getParentDataJO(true);
                    if (this.getPSControlNavigatable().getNavViewParamJO() != null) {
                        keys = this.getPSControlNavigatable().getNavViewParamJO().keys();
                        while (keys.hasNext()) {
                            strKey = keys.next().toString();
                            if (parentDataJO.has(strKey)) continue;
                            parentDataJO.put(strKey, this.getPSControlNavigatable().getNavViewParamJO().get(strKey));
                        }
                    }
                    if (!StringHelper.IsNullOrEmpty((String)this.getPSControlNavigatable().getNavFilter()) && !parentDataJO.has("srfparentdefname")) {
                        parentDataJO.put("srfparentdefname", (Object)this.getPSControlNavigatable().getNavFilter());
                    }
                    if (this.getPSControlNavigatable().getNavPSDER() != null && this.getPSControlNavigatable().getNavPSDER() instanceof IPSDER1N) {
                        IPSDER1N iPSDER1N = (IPSDER1N)this.getPSControlNavigatable().getNavPSDER();
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
        super.onInit();
    }

    protected abstract IPSControlNavigatable getPSControlNavigatable();

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    protected IPSControl onGetXDataPSControl() {
        return this.getPSControlNavigatable();
    }
}

