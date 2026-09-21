/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Res.IPSAppPFPluginRef;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.LinkedHashMap;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPFPluginRefImpl
extends PSApplicationObjectImpl
implements IPSAppPFPluginRef {
    private static final Log log = LogFactory.getLog(PSAppPFPluginRefImpl.class);
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private String strRefTag = null;
    private String strRefTag2 = null;
    private String strRefMode = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysPFPlugin iPSSysPFPlugin, String strRefMode, String strRefTag, String strRefTag2) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysPFPlugin = iPSSysPFPlugin;
            this.strRefMode = strRefMode;
            this.strRefTag = strRefTag;
            this.strRefTag2 = strRefTag2;
            this.setId(KeyValueHelper.genUniqueId((String)iPSApplication.getId(), (String)iPSSysPFPlugin.getId(), (String)strRefMode, (String)strRefTag, (String)strRefTag2));
            this.setName(iPSSysPFPlugin.getName());
            if (this.getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
                    params.put("app", this.getPSApplication());
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, null, params);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
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
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6", group="\u57fa\u672c", order=115, ignorepf=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6807\u8bb0", group="\u57fa\u672c", order=117)
    public String getRefTag() {
        return this.strRefTag;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6807\u8bb02")
    public String getRefTag2() {
        return this.strRefTag2;
    }

    @Override
    public String getModelType() {
        return "PSAPPPFPLUGINREF";
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u4ee3\u7801")
    public String getPluginCode() {
        if (this.getPSSysPFPlugin() != null) {
            if (!StringHelper.isNullOrEmpty((String)this.getPSSysPFPlugin().getPluginCode())) {
                return this.getPSSysPFPlugin().getPluginCode();
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSSysPFPlugin().getCodeName())) {
                return this.getPSSysPFPlugin().getCodeName();
            }
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u63d2\u4ef6\u7c7b\u578b", codelist="PFPluginType", group="\u57fa\u672c", order=125)
    public String getPluginType() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().getPluginType();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f")
    public String getRefMode() {
        return this.strRefMode;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u6269\u5c55\u754c\u9762\u6837\u5f0f", ignoredumpvalues="false")
    public boolean isExtendStyleOnly() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().isExtendStyleOnly();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u6a21\u578b", hideempty=true)
    public ObjectNode getPluginModel() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().getPluginModel();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u540d\u79f0", hideempty2=true)
    public String getRTObjectName() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().getRTObjectName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u4ed3\u5e93", hideempty2=true)
    public String getRTObjectRepo() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().getRTObjectRepo();
        }
        return null;
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().isRuntimeObject();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u9ed8\u8ba4\u66ff\u6362", ignoredumpvalues="false")
    public boolean isReplaceDefault() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().isReplaceDefault();
        }
        return false;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getPluginCode();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u63d2\u4ef6", ignoredumpvalues="false")
    public boolean isRuntimeObject() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().isRuntimeObject();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u52a8\u6001\u53c2\u6570", hideempty=true)
    public Properties getPluginParams() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().getPluginParams();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u7801")
    public String getTemplCode() {
        return this.getTemplCodeX("CODE");
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u78012")
    public String getTemplCode2() {
        return this.getTemplCodeX("CODE2");
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u78013")
    public String getTemplCode3() {
        return this.getTemplCodeX("CODE3");
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u78014")
    public String getTemplCode4() {
        return this.getTemplCodeX("CODE4");
    }

    protected String getTemplCodeX(String strCode) {
        if (this.getPSSysPFPlugin() != null && (this.isRuntimeObject() || PSObjectImpl.isDynaModelCodeGenMode())) {
            try {
                IPSPFPluginTempl iPSPFPluginTempl = this.getPSSysPFPlugin().getPSPFPluginTempl(this.getPSApplication().getPSPF().getId(), "", true);
                if (iPSPFPluginTempl != null) {
                    return iPSPFPluginTempl.getCode(strCode);
                }
            }
            catch (Exception ex) {
                return ex.getMessage();
            }
        }
        return null;
    }
}

