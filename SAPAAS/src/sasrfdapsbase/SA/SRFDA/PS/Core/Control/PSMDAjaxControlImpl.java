/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Ajax.IPSMDAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlNavContext;
import SA.SRFDA.PS.Core.Control.IPSControlNavParam;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlImpl;
import SA.SRFDA.PS.Core.Control.PSControlNavContextImpl;
import SA.SRFDA.PS.Core.Control.PSControlNavParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMDAjaxControlImpl
extends PSAjaxControlImpl
implements IPSMDAjaxControl {
    private static final Log log = LogFactory.getLog(PSMDAjaxControlImpl.class);
    private boolean bCheckControlDataSet = false;
    private IPSMDAjaxControlHandler iPSMDAjaxControlHandler = null;
    private boolean bBufferRenderer = true;
    private Map<String, IPSControlNavContext> psControlNavContextMap = null;
    private Map<String, IPSControlNavParam> psControlNavParamMap = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSAjaxControlHandler() != null && this.getPSAjaxControlHandler() instanceof IPSMDAjaxControlHandler) {
            this.iPSMDAjaxControlHandler = (IPSMDAjaxControlHandler)this.getPSAjaxControlHandler();
        }
        this.onPreparePSControlNavParams();
    }

    protected void onPreparePSControlNavParams() throws Exception {
        Iterator<String> names;
        if (this.getPSControlParam() != null && (names = this.getPSControlParam().getCtrlParamNames()) != null) {
            while (names.hasNext()) {
                boolean bRawValue;
                String strKey = names.next();
                String strValue = this.getPSControlParam().getCtrlParam(strKey, "");
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSControlNavContextImpl psControlNavContextImpl = new PSControlNavContextImpl();
                    psControlNavContextImpl.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psControlNavContextMap == null) {
                        this.psControlNavContextMap = new LinkedHashMap<String, IPSControlNavContext>();
                    }
                    this.psControlNavContextMap.put(strTag, psControlNavContextImpl);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") != 0) continue;
                bRawValue = true;
                strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSControlNavParamImpl psControlNavParamImpl = new PSControlNavParamImpl();
                psControlNavParamImpl.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psControlNavParamMap == null) {
                    this.psControlNavParamMap = new LinkedHashMap<String, IPSControlNavParam>();
                }
                this.psControlNavParamMap.put(strTag, psControlNavParamImpl);
            }
        }
    }

    @Override
    public IPSMDAjaxControlHandler getPSMDAjaxControlHandler() {
        return this.iPSMDAjaxControlHandler;
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
        if (this.isCheckControlDataSet() && this.getPSMDAjaxControlHandler() != null && StringHelper.IsNullOrEmpty((String)this.getPSMDAjaxControlHandler().getPSDEDataSetId())) {
            throw new Exception(StringHelper.Format((String)"\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u6ca1\u6709\u6307\u5b9a\u540e\u53f0\u5904\u7406\u6570\u636e\u96c6\u5408", (Object)this.getPSAppView().getName(), (Object)this.getName()));
        }
    }

    protected boolean isCheckControlDataSet() {
        return this.bCheckControlDataSet;
    }

    protected void setCheckControlDataSet(boolean bCheckControlDataSet) {
        this.bCheckControlDataSet = bCheckControlDataSet;
        if (this.bCheckControlDataSet) {
            this.setCheckControlHandler(true);
        }
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getFetchPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("fetch", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    public Iterator<IPSAppDEField> getPSAppDEFields() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u8bfb\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isReadOnly() {
        return this.onGetReadOnly();
    }

    protected boolean onGetReadOnly() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getCreatePSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            try {
               return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("create", true);
            }
            catch (Exception exAjaxAction) {
               log.error((Object)exAjaxAction);
               return null;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getUpdatePSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            try {
               return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("update", true);
            }
            catch (Exception exAjaxAction) {
               log.error((Object)exAjaxAction);
               return null;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getRemovePSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            try {
               return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("remove", true);
            }
            catch (Exception exAjaxAction) {
               log.error((Object)exAjaxAction);
               return null;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGetPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("load", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGetDraftPSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            try {
               return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraft", true);
            }
            catch (Exception exAjaxAction) {
               log.error((Object)exAjaxAction);
               return null;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\u884c\u4e3a\uff08\u62f7\u8d1d\uff09", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getGetDraftFromPSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            try {
               return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("loaddraftfrom", true);
            }
            catch (Exception exAjaxAction) {
               log.error((Object)exAjaxAction);
               return null;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u6570\u636e\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getMovePSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSMDAjaxControlHandler() != null) {
            try {
               return this.getPSMDAjaxControlHandler().getPSAjaxHandlerAction("move", true);
            }
            catch (Exception exAjaxAction) {
               log.error((Object)exAjaxAction);
               return null;
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bfc\u51fa\u5bf9\u8c61", hideempty=true, dumpref=true, from="__self__", from_method="getPSAppDataEntityMust().getPSAppDEDataExport")
    public IPSDEDataExport getPSDEDataExport() throws Exception {
        try {
            if (this.getPSMDAjaxControlHandler() != null) {
                if (this.getPSAppDataEntity() != null) {
                    if (!StringHelper.IsNullOrEmpty((String)this.getPSMDAjaxControlHandler().getPSDEDataExportId())) {
                        return this.getPSAppDataEntity().getPSAppDEDataExport(this.getPSMDAjaxControlHandler().getPSDEDataExportId());
                    }
                } else if (this.getPSDataEntity() != null && !StringHelper.IsNullOrEmpty((String)this.getPSMDAjaxControlHandler().getPSDEDataExportId())) {
                    return this.getPSDataEntity().getPSDEDataExport(this.getPSMDAjaxControlHandler().getPSDEDataExportId());
                }
            }
            if (this.getPSDataEntity() != null) {
                IPSDEDataExport iPSDEDataExport = this.getPSDataEntity().getDefaultPSDEDataExport();
                if (iPSDEDataExport != null && this.getPSAppDataEntity() != null) {
                    return this.getPSAppDataEntity().getPSAppDEDataExport(iPSDEDataExport.getId());
                }
                return iPSDEDataExport;
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bfc\u5165\u5bf9\u8c61", hideempty=true, dumpref=true, from="__self__", from_method="getPSAppDataEntityMust().getPSAppDEDataImport")
    public IPSDEDataImport getPSDEDataImport() throws Exception {
        block8: {
            try {
                if (!this.isReadOnly()) break block8;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSMDAjaxControlHandler() != null) {
            if (this.getPSAppDataEntity() != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPSMDAjaxControlHandler().getPSDEDataImportId())) {
                    return this.getPSAppDataEntity().getPSAppDEDataImport(this.getPSMDAjaxControlHandler().getPSDEDataImportId());
                }
                return this.getPSAppDataEntity().getDefaultPSAppDEDataImport();
            }
            if (this.getPSDataEntity() != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPSMDAjaxControlHandler().getPSDEDataImportId())) {
                    return this.getPSDataEntity().getPSDEDataImport(this.getPSMDAjaxControlHandler().getPSDEDataImportId());
                }
                return this.getPSDataEntity().getDefaultPSDEDataImport();
            }
        }
        return null;
    }

    @Override
    public boolean isBufferRenderer() {
        return this.bBufferRenderer;
    }

    protected void setBufferRenderer(boolean bBufferRenderer) {
        this.bBufferRenderer = bBufferRenderer;
    }

    @Override
    public boolean hasWFDataItems() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSControlNavParam> getPSControlNavParams() throws Exception {
        if (this.psControlNavParamMap == null || this.psControlNavParamMap.size() == 0) {
            return null;
        }
        return this.psControlNavParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true)
    public Iterator<IPSControlNavContext> getPSControlNavContexts() throws Exception {
        if (this.psControlNavContextMap == null || this.psControlNavContextMap.size() == 0) {
            return null;
        }
        return this.psControlNavContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isActiveDataMode() {
        if (this.getPSControlParam() instanceof IPSMDAjaxControlParam) {
            IPSMDAjaxControlParam iPSMDAjaxControlParam = (IPSMDAjaxControlParam)this.getPSControlParam();
            if (iPSMDAjaxControlParam.isActiveDataMode() == null) {
                return false;
            }
            return iPSMDAjaxControlParam.isActiveDataMode();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u5c5e\u6027")
    public String getActiveDataField() {
        if (this.isActiveDataMode() && this.getPSControlParam() instanceof IPSMDAjaxControlParam) {
            IPSMDAjaxControlParam iPSMDAjaxControlParam = (IPSMDAjaxControlParam)this.getPSControlParam();
            return iPSMDAjaxControlParam.getActiveDataField();
        }
        return null;
    }
}

