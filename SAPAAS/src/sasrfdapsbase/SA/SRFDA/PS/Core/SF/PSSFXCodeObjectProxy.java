/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSSFXCodeObjectProxy
extends PSObjectImpl
implements IPSSFXCodeObject {
    private static Map<String, String> codeNameMap = new HashMap<String, String>();
    private Object objItem = null;
    private Map<String, Object> params = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSysSFPluginTempl iPSSysSFPluginTempl = null;

    static {
        codeNameMap.put("CODE", "");
        codeNameMap.put("CODE2", "");
        codeNameMap.put("CODE3", "");
        codeNameMap.put("CODE4", "");
        codeNameMap.put("CODE5", "");
        codeNameMap.put("CODE6", "");
    }

    public PSSFXCodeObjectProxy(IPSSysSFPluginTempl iPSSysSFPluginTempl, Object objItem) {
        this.iPSSysSFPluginTempl = iPSSysSFPluginTempl;
        this.iPSSysSFPlugin = iPSSysSFPluginTempl.getPSSysSFPlugin();
        this.objItem = objItem;
    }

    public PSSFXCodeObjectProxy(IPSSysSFPluginTempl iPSSysSFPluginTempl, Object objItem, Map<String, Object> params) {
        this.iPSSysSFPluginTempl = iPSSysSFPluginTempl;
        this.iPSSysSFPlugin = iPSSysSFPluginTempl.getPSSysSFPlugin();
        this.objItem = objItem;
        this.params = params;
    }

    protected IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    protected IPSSysSFPluginTempl getPSSysSFPluginTempl() {
        return this.iPSSysSFPluginTempl;
    }

    @Override
    public boolean isEnableXCode() {
        return true;
    }

    @Override
    public boolean hasXCode(String strCodeType) {
        block5: {
            if (!this.isEnableXCode()) {
                return false;
            }
            if (StringHelper.isNullOrEmpty((String)strCodeType)) {
                return false;
            }
            try {
                if (this.getPSSysSFPluginTempl() == null) break block5;
                return this.getPSSysSFPluginTempl().hasXCode(strCodeType);
            }
            catch (Exception ex) {
                return false;
            }
        }
        return this.getPSSysSFPlugin().hasCode(strCodeType);
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
        if (this.getPSSysSFPluginTempl() != null) {
            try {
                if (this.getPSSysSFPluginTempl().hasXCode(strCodeType)) {
                    return this.getPSSysSFPluginTempl().getXCode(strCodeType, this.objItem, this.params);
                }
                return "";
            }
            catch (Exception ex) {
                return "!!!!\u6a21\u7248\u4ea7\u751f\u4ee3\u7801\u9519\u8bef:" + ex.getMessage();
            }
        }
        if (this.getPSSysSFPlugin() != null) {
            try {
                return this.getPSSysSFPlugin().getXCode(strCodeType, this.objItem, this.params);
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
        return this.getPSSysSFPlugin().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSFXCODEOBJECT";
    }

    @Override
    public String getModelName() {
        return this.getPSSysSFPlugin().getModelName();
    }

    @Override
    public String getModelId() {
        if (this.getPSSysSFPluginTempl() != null) {
            return this.getPSSysSFPluginTempl().getModelId();
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u4ee3\u7801\u96c6\u5408")
    public String[] getXCodes() {
        if (this.getPSSysSFPluginTempl() != null) {
            return this.getPSSysSFPluginTempl().getXCodes();
        }
        return null;
    }
}

