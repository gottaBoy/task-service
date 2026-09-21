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
package SA.SRFDA.PS.Core.App.ValueRule;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSSysValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppValueRuleImpl
extends PSApplicationObjectImpl
implements IPSAppValueRule,
IPSPFLogicCodeObject {
    private static final Log log = LogFactory.getLog(PSAppValueRuleImpl.class);
    private IPSSysValueRule iPSSysValueRule = null;
    private IPSXCodeObject iPSXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysValueRule iPSSysValueRule) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysValueRule = iPSSysValueRule;
            this.setId(iPSSysValueRule.getId());
            this.setName(iPSSysValueRule.getName());
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
    protected void onInit() throws Exception {
        if (this.getPSSysPFPlugin() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
            }
        }
        super.onInit();
    }

    public IPSSysValueRule getPSSysValueRule() {
        return this.iPSSysValueRule;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysValueRule();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u7c7b\u578b", codelist="ValueRuleType", fields={"RULETYPE"})
    public String getRuleType() {
        return this.getPSSysValueRule().getRuleType();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u4fe1\u606f", fields={"RULEINFO"})
    public String getRuleInfo() {
        return this.getPSSysValueRule().getRuleInfo();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u7801", hideempty2=true, fields={"REGEXPCODE"})
    public String getRegExCode() {
        return this.getPSSysValueRule().getRegExCode();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"SCRIPT"})
    public String getScriptCode() {
        return this.getPSSysValueRule().getScriptCode();
    }

    @Override
    public String getModelType() {
        return "PSAPPVALUERULE";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getCustomObject() {
        return this.getPSSysValueRule().getCustomObject();
    }

    @Override
    public String getCustomParams() {
        return this.getPSSysValueRule().getCustomParams();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u78012", hideempty2=true, fields={"REGEXPCODE2"})
    public String getRegExCode2() {
        return this.getPSSysValueRule().getRegExCode2();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u78013", hideempty2=true, fields={"REGEXPCODE3"})
    public String getRegExCode3() {
        return this.getPSSysValueRule().getRegExCode3();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u78014", hideempty2=true, fields={"REGEXPCODE4"})
    public String getRegExCode4() {
        return this.getPSSysValueRule().getRegExCode4();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.getPSSysValueRule().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        if (this.getPSApplication().isEnableUIModelEx()) {
            return this.getPSSysValueRule().getUniqueTag();
        }
        return this.getPSSysValueRule().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getRuleHolder() {
        return this.getPSSysValueRule().getRuleHolder();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", dump=false)
    public boolean isEnableBackend() {
        return this.getPSSysValueRule().isEnableBackend();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c")
    public boolean isEnableFront() {
        return this.getPSSysValueRule().isEnableFront();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.getPSSysValueRule().getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.getPSSysValueRule().getPSSysSFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.getPSSysValueRule().getPSSysSFPub();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysValueRule psSysValueRule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeCat() {
        return "VALUERULE";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        return this.getRuleType();
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return this.getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6807\u8bb0", hideempty2=true, fields={"RULETAG"})
    public String getRuleTag() {
        return this.getPSSysValueRule().getRuleTag();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6807\u8bb02", hideempty2=true, fields={"RULETAG2"})
    public String getRuleTag2() {
        return this.getPSSysValueRule().getRuleTag2();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        return this.getPSSysValueRule().getUniqueTag();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getRuleInfoLanResTag() {
        return this.getPSSysValueRule().getRuleInfoLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getRuleInfoPSLanguageRes() {
        return this.getPSSysValueRule().getRuleInfoPSLanguageRes();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        objectNode.remove("getPSSystemModule");
    }
}

