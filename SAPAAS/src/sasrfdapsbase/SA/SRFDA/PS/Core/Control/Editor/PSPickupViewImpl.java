/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Editor.IPSPickupView;
import SA.SRFDA.PS.Core.Control.Editor.PSValueItemEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"PICKUPVIEW"})
public class PSPickupViewImpl
extends PSValueItemEditorImpl
implements IPSPickupView {
    private static final Log log = LogFactory.getLog(PSPickupViewImpl.class);
    private String strParamJOString = null;
    private String strContextJOString = null;

    @Override
    @PSModelRTMeta(description="\u9009\u62e9\u89c6\u56fe", hideempty=true, dumpref=true)
    public IPSAppView getPickupPSAppView() throws Exception {
        return this.getPSEditorContainer().getRefPickupPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u53c2\u6570\u5bf9\u8c61")
    public JSONObject getItemParamJO() throws Exception {
        return this.getPSEditorContainer().getItemParam();
    }

    @Override
    public boolean isEnablePickupView() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u53c2\u6570Json\u5b57\u7b26\u4e32")
    public String getParamJOString() {
        if (this.strParamJOString == null) {
            try {
                this.strParamJOString = PSPickupViewImpl.calcParamJOString(this.getItemParamJO());
            }
            catch (Exception ex) {
                log.error((Object)ex);
                this.strParamJOString = "";
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.strParamJOString)) {
            return null;
        }
        return this.strParamJOString;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u4e0a\u4e0b\u6587Json\u5b57\u7b26\u4e32")
    public String getContextJOString() {
        if (this.strContextJOString == null) {
            try {
                this.strContextJOString = PSPickupViewImpl.calcContextJOString(this.getItemParamJO());
            }
            catch (Exception ex) {
                log.error((Object)ex);
                this.strContextJOString = "";
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.strContextJOString)) {
            return null;
        }
        return this.strContextJOString;
    }
}

