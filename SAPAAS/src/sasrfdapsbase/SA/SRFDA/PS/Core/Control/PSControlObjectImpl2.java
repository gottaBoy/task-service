/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlObjectNavigatable;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSControlObjectImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;

public class PSControlObjectImpl2
extends PSControlObjectImpl
implements IPSControlObjectNavigatable {
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String TAG_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    private IPSAppView navPSAppView = null;
    private String strEmbedViewId = "";
    private JSONObject joNavViewParams = null;
    private IPSDERBase navPSDERBase = null;
    private String strNavPSDERId = null;
    private String strNavPSDEViewBaseId = null;
    private String strNavFilter = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;

    protected void initNavParams(BaseDataEntity model) throws Exception {
        Properties navViewParams = PropertiesHelper.load((String)model.getParamStringValue(TAG_NAVVIEWPARAM, ""));
        this.onPreparePSNavViewParams(navViewParams);
        this.strNavPSDEViewBaseId = model.getParamStringValue(TAG_PSDEVIEWBASEID, "");
        if (!StringHelper.isNullOrEmpty((String)this.strNavPSDEViewBaseId)) {
            this.strNavPSDERId = model.getParamStringValue(TAG_PSDERID, "");
            this.strNavFilter = model.getParamStringValue(TAG_NAVVIEWFILTER, this.strNavFilter);
        }
        if (!StringHelper.isNullOrEmpty((String)this.getNavPSDEViewId()) && this.getPSAppView() != null) {
            this.navPSAppView = this.getPSAppView().getPSApplication().getPSAppViewByDEViewId(this.getNavPSDEViewId(), false);
            this.strEmbedViewId = this.getPSAppView().generateViewUniId();
            if (!StringHelper.isNullOrEmpty((String)this.getNavPSDERId())) {
                this.navPSDERBase = this.getPSAppView().getPSApplication().getPSSystem().getPSDER(this.getNavPSDERId());
            }
        }
    }

    protected void onPreparePSNavViewParams(Properties navViewParams) throws Exception {
        if (navViewParams != null) {
            this.joNavViewParams = new JSONObject();
            for (Object objKey : navViewParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                boolean bRawValue;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)navViewParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                bRawValue = true;
                strTag = strTag.toLowerCase();
                if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                this.joNavViewParams.put(strKey.toLowerCase(), (Object)PropertiesHelper.getProperty((Properties)navViewParams, (String)strKey));
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u8fc7\u6ee4\u9879", hideempty2=true)
    public String getNavFilter() {
        return this.strNavFilter;
    }

    @Override
    public String getNavPSDEViewId() {
        return this.strNavPSDEViewBaseId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppView getNavPSAppView() {
        return this.navPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u53c2\u6570", hideempty=true)
    public JSONObject getNavViewParamJO() {
        return this.joNavViewParams;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5173\u7cfb", hideempty=true, child=true)
    public IPSDERBase getNavPSDER() {
        return this.navPSDERBase;
    }

    @Override
    public String getNavPSDERId() {
        return this.strNavPSDERId;
    }

    @Override
    public String getNavEmbeddedViewId() {
        return this.strEmbedViewId;
    }

    protected IPSAppView getPSAppView() {
        return this.getOwnedPSControl().getPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    public String getNavDataType() {
        return null;
    }

    @Override
    public String getLogicName() {
        return null;
    }
}

