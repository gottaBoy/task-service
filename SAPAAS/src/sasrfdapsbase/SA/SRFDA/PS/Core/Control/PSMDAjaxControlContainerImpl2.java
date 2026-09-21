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
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlContainerImpl;
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

public class PSMDAjaxControlContainerImpl2
extends PSMDAjaxControlContainerImpl
implements IPSControlNavigatable {
    public static final String TAG_NAVPSDEVIEWBASEID = "NAVPSDEVIEWBASEID";
    public static final String TAG_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String TAG_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String TAG_NAVPSDERID = "NAVPSDERID";
    public static final String TAG_NAVVIEWPOS = "NAVVIEWPOS";
    public static final String TAG_NAVVIEWSHOWMODE = "NAVVIEWSHOWMODE";
    public static final String TAG_NAVVIEWWIDTH = "NAVVIEWWIDTH";
    public static final String TAG_NAVVIEWMINWIDTH = "NAVVIEWMINWIDTH";
    public static final String TAG_NAVVIEWMAXWIDTH = "NAVVIEWMAXWIDTH";
    public static final String TAG_NAVVIEWMAXHEIGHT = "NAVVIEWMAXHEIGHT";
    public static final String TAG_NAVVIEWMINHEIGHT = "NAVVIEWMINHEIGHT";
    public static final String TAG_NAVVIEWHEIGHT = "NAVVIEWHEIGHT";
    public static final String NAVDATATYPE_DEFAULT = "DEFAULT";
    private IPSAppView navPSAppView = null;
    private String strEmbedViewId = "";
    private JSONObject joNavViewParams = null;
    private IPSDERBase navPSDERBase = null;
    private String strNavPSDERId = null;
    private String strNavPSDEViewBaseId = null;
    private String strNavFilter = null;
    private double fNavViewWidth = 0.0;
    private double fNavViewHeight = 0.0;
    private double fNavViewMinWidth = 0.0;
    private double fNavViewMinHeight = 0.0;
    private double fNavViewMaxWidth = 0.0;
    private double fNavViewMaxHeight = 0.0;
    private int nNavViewShowMode = 0;
    private String strNavViewPos = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;

    protected void initNavParams(BaseDataEntity model) throws Exception {
        Properties navViewParams = PropertiesHelper.load((String)model.getParamStringValue(TAG_NAVVIEWPARAM, ""));
        this.onPreparePSNavViewParams(navViewParams);
        this.strNavPSDEViewBaseId = model.getParamStringValue(TAG_NAVPSDEVIEWBASEID, "");
        if (!StringHelper.isNullOrEmpty((String)this.strNavPSDEViewBaseId)) {
            this.strNavPSDERId = model.getParamStringValue(TAG_NAVPSDERID, "");
            this.strNavFilter = model.getParamStringValue(TAG_NAVVIEWFILTER, this.strNavFilter);
        }
        if (!StringHelper.isNullOrEmpty((String)this.getNavPSDEViewId()) && this.getPSAppView() != null) {
            this.navPSAppView = this.getPSAppView().getPSApplication().getPSAppViewByDEViewId(this.getNavPSDEViewId(), false);
            this.strEmbedViewId = this.getPSAppView().generateViewUniId();
            if (!StringHelper.isNullOrEmpty((String)this.getNavPSDERId())) {
                this.navPSDERBase = this.getPSAppView().getPSApplication().getPSSystem().getPSDER(this.getNavPSDERId());
            }
        }
        this.fNavViewWidth = model.GetParamDoubleValue(TAG_NAVVIEWWIDTH, 0.0);
        this.fNavViewHeight = model.GetParamDoubleValue(TAG_NAVVIEWHEIGHT, 0.0);
        this.fNavViewMaxWidth = model.GetParamDoubleValue(TAG_NAVVIEWMAXWIDTH, 0.0);
        this.fNavViewMaxHeight = model.GetParamDoubleValue(TAG_NAVVIEWMAXHEIGHT, 0.0);
        this.fNavViewMinWidth = model.GetParamDoubleValue(TAG_NAVVIEWMINWIDTH, 0.0);
        this.fNavViewMinHeight = model.GetParamDoubleValue(TAG_NAVVIEWMINHEIGHT, 0.0);
        this.strNavViewPos = model.getParamStringValue(TAG_NAVVIEWPOS, null);
        this.nNavViewShowMode = model.GetParamIntValue(TAG_NAVVIEWSHOWMODE, 0);
        if (this.nNavViewShowMode < 0) {
            this.nNavViewShowMode = 0;
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
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u8fc7\u6ee4\u9879", hideempty2=true, group="\u90e8\u4ef6\u5bfc\u822a", order=304)
    public String getNavFilter() {
        return this.strNavFilter;
    }

    @Override
    public String getNavPSDEViewId() {
        return this.strNavPSDEViewBaseId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u5bf9\u8c61", hideempty=true, dumpref=true, group="\u90e8\u4ef6\u5bfc\u822a", order=302)
    public IPSAppView getNavPSAppView() {
        return this.navPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u53c2\u6570", hideempty=true, group="\u90e8\u4ef6\u5bfc\u822a", order=306)
    public JSONObject getNavViewParamJO() {
        return this.joNavViewParams;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5173\u7cfb", hideempty=true, child=true, group="\u90e8\u4ef6\u5bfc\u822a", order=303)
    public IPSDERBase getNavPSDER() {
        return this.navPSDERBase;
    }

    @Override
    public String getNavPSDERId() {
        return this.strNavPSDERId;
    }

    @Override
    public String getNavDataType() {
        return NAVDATATYPE_DEFAULT;
    }

    @Override
    public String getNavEmbeddedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5bfc\u822a", order=316)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u90e8\u4ef6\u5bfc\u822a", order=315)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getNavViewWidth() {
        return this.fNavViewWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getNavViewHeight() {
        return this.fNavViewHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u6700\u5c0f\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getNavViewMinWidth() {
        return this.fNavViewMinWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u6700\u5c0f\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getNavViewMinHeight() {
        return this.fNavViewMinHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u6700\u5927\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getNavViewMaxWidth() {
        return this.fNavViewMaxWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u6700\u5927\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getNavViewMaxHeight() {
        return this.fNavViewMaxHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u4f4d\u7f6e", codelist="NavViewPos", ignoredumpvalues="NONE")
    public String getNavViewPos() {
        return this.strNavViewPos;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", codelist="NavViewShowMode", ignoredumpvalues="0")
    public int getNavViewShowMode() {
        return this.nNavViewShowMode;
    }
}

