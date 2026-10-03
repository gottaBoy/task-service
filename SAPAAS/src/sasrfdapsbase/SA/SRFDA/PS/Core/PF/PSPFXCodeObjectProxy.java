/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSPFXCodeObjectProxy
extends PSObjectImpl
implements IPSPFXCodeObject {
    private static Map<String, String> codeNameMap = new HashMap<String, String>();
    private Object objView = null;
    private Object objCtrl = null;
    private Object objItem = null;
    private Map<String, Object> params = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysPFPluginTempl iPSSysPFPluginTempl = null;

    static {
        codeNameMap.put("CODE", "");
        codeNameMap.put("CODE2", "");
        codeNameMap.put("CODE3", "");
        codeNameMap.put("CODE4", "");
        codeNameMap.put("CODE5", "");
        codeNameMap.put("CODE6", "");
    }

    public PSPFXCodeObjectProxy(IPSSysPFPluginTempl iPSSysPFPluginTempl, Object objView, Object objCtrl) {
        this.iPSSysPFPluginTempl = iPSSysPFPluginTempl;
        this.iPSSysPFPlugin = iPSSysPFPluginTempl.getPSSysPFPlugin();
        this.objView = objView;
        this.objCtrl = objCtrl;
    }

    public PSPFXCodeObjectProxy(IPSSysPFPluginTempl iPSSysPFPluginTempl, Object objView, Object objCtrl, Object objItem) {
        this.iPSSysPFPluginTempl = iPSSysPFPluginTempl;
        this.iPSSysPFPlugin = iPSSysPFPluginTempl.getPSSysPFPlugin();
        this.objView = objView;
        this.objCtrl = objCtrl;
        this.objItem = objItem;
    }

    public PSPFXCodeObjectProxy(IPSSysPFPluginTempl iPSSysPFPluginTempl, Object objView, Object objCtrl, Object objItem, Map<String, Object> params) {
        this.iPSSysPFPluginTempl = iPSSysPFPluginTempl;
        this.iPSSysPFPlugin = iPSSysPFPluginTempl.getPSSysPFPlugin();
        this.objView = objView;
        this.objCtrl = objCtrl;
        this.objItem = objItem;
        this.params = params;
    }

    public PSPFXCodeObjectProxy(IPSSysPFPlugin iPSSysPFPlugin, Object objView, Object objCtrl) {
        this.iPSSysPFPlugin = iPSSysPFPlugin;
        this.objView = objView;
        this.objCtrl = objCtrl;
    }

    public PSPFXCodeObjectProxy(IPSSysPFPlugin iPSSysPFPlugin, Object objView, Object objCtrl, Object objItem) {
        this.iPSSysPFPlugin = iPSSysPFPlugin;
        this.objView = objView;
        this.objCtrl = objCtrl;
        this.objItem = objItem;
    }

    public PSPFXCodeObjectProxy(IPSSysPFPlugin iPSSysPFPlugin, Object objView, Object objCtrl, Object objItem, Map<String, Object> params) {
        this.iPSSysPFPlugin = iPSSysPFPlugin;
        this.objView = objView;
        this.objCtrl = objCtrl;
        this.objItem = objItem;
        this.params = params;
    }

    protected IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    protected IPSSysPFPluginTempl getPSSysPFPluginTempl() {
        return this.iPSSysPFPluginTempl;
    }

    @Override
    public boolean isEnableXCode() {
        return true;
    }

    @Override
    public boolean hasXCode(String strCodeType) {
        block6: {
            block7: {
                if (!this.isEnableXCode()) {
                    return false;
                }
                if (StringHelper.isNullOrEmpty((String)strCodeType)) {
                    return false;
                }
                try {
                    if (this.getPSSysPFPluginTempl() == null) break block6;
                    if (!this.getPSSysPFPluginTempl().hasXCode(strCodeType)) break block7;
                    return true;
                }
                catch (Exception ex) {
                    return false;
                }
            }
            if (!codeNameMap.containsKey(strCodeType.toUpperCase())) break block6;
            return false;
        }
        try {
            return this.getPSSysPFPlugin().hasCode(strCodeType);
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String getXCode() {
        return this.getXCode("CODE");
    }

    @Override
    public String getXCode(String strCodeType) {
        if (PSTemplHelper.getCurrentParams() == null) {
            return "!!!!\u6a21\u7248\u4ea7\u751f\u4ee3\u7801\u9519\u8bef:\u6b64\u65b9\u6cd5\u5fc5\u987b\u6a21\u677f\u53d1\u5e03\u4e2d\u8c03\u7528";
        }
        if (this.getPSSysPFPluginTempl() != null) {
            try {
                if (this.getPSSysPFPluginTempl().hasXCode(strCodeType)) {
                    return this.getPSSysPFPluginTempl().getXCode(strCodeType, this.objView, this.objCtrl, this.objItem, this.params);
                }
                if (codeNameMap.containsKey(strCodeType.toUpperCase())) {
                    return "";
                }
            }
            catch (Exception ex) {
                return "!!!!\u6a21\u7248\u4ea7\u751f\u4ee3\u7801\u9519\u8bef:" + ex.getMessage();
            }
        }
        if (this.getPSSysPFPlugin() != null) {
            try {
                return this.getPSSysPFPlugin().getXCode(strCodeType, this.objView, this.objCtrl, this.objItem, this.params);
            }
            catch (Exception ex) {
                return "!!!!\u6a21\u7248\u4ea7\u751f\u4ee3\u7801\u9519\u8bef:" + ex.getMessage();
            }
        }
        return "!!!!\u6a21\u7248\u4ea7\u751f\u4ee3\u7801\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u6269\u5c55\u63d2\u4ef6";
    }

    @Override
    public String getCode() {
        return this.getXCode("CODE");
    }

    @Override
    public String getCode2() {
        return this.getXCode("CODE2");
    }

    @Override
    public String getCode3() {
        return this.getXCode("CODE3");
    }

    @Override
    public String getCode4() {
        return this.getXCode("CODE4");
    }

    @Override
    public String getCode5() {
        return this.getXCode("CODE5");
    }

    @Override
    public String getCode6() {
        return this.getXCode("CODE6");
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysPFPlugin().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSPFXCODEOBJECT";
    }

    @Override
    public String getModelName() {
        return this.getPSSysPFPlugin().getModelName();
    }

    @Override
    public String getModelId() {
        if (this.getPSSysPFPluginTempl() != null) {
            return this.getPSSysPFPluginTempl().getModelId();
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u4ee3\u7801\u96c6\u5408")
    public String[] getXCodes() {
        if (this.getPSSysPFPluginTempl() != null) {
            return this.getPSSysPFPluginTempl().getXCodes();
        }
        return null;
    }
}

