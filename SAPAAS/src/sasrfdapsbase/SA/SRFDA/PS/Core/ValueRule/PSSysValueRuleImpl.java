/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ValueRule;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSSysValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysValueRuleImpl
extends PSSystemObjectImpl
implements IPSSysValueRule {
    private static final Log log = LogFactory.getLog(PSSysValueRuleImpl.class);
    protected PSSysValueRule psSysValueRule = null;
    private IPSSystemModule iPSSystemModule = null;
    private int nRuleHolder = 3;
    private boolean bCustomRuleHolder = false;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSLanguageRes ruleInfoPSLanguageRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysValueRule psSysValueRule) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysValueRule = psSysValueRule;
            this.setId(this.psSysValueRule.getPSSYSVALUERULEID());
            this.setName(this.psSysValueRule.getPSSYSVALUERULENAME());
            this.setPSObjectData(this.psSysValueRule);
            if (!this.psSysValueRule.isRULEHOLDERNull()) {
                this.nRuleHolder = this.psSysValueRule.getRULEHOLDER();
                this.bCustomRuleHolder = true;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysValueRule.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysValueRule.getPSMODULEID());
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
    protected void onInit() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysValueRule.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.psSysValueRule.getPSSYSPFPLUGINID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysValueRule.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysValueRule.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysValueRule.getRIPSLANRESID())) {
            this.ruleInfoPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysValueRule.getRIPSLANRESID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u7c7b\u578b", codelist="ValueRuleType", group="\u57fa\u672c", order=125, fields={"RULETYPE"})
    public String getRuleType() {
        return this.psSysValueRule.getRULETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u4fe1\u606f", fields={"RULEINFO"})
    public String getRuleInfo() {
        return this.psSysValueRule.getRULEINFO();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u7801", hideempty2=true, fields={"REGEXPCODE"})
    public String getRegExCode() {
        return this.psSysValueRule.getREGEXPCODE();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"SCRIPT"})
    public String getScriptCode() {
        return this.psSysValueRule.getSCRIPT();
    }

    @Override
    public String getModelType() {
        return "PSSYSVALUERULE";
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61", hideempty2=true, fields={"CUSTOMOBJ"})
    public String getCustomObject() {
        return this.psSysValueRule.getCUSTOMOBJ();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u53c2\u6570", hideempty2=true, fields={"CUSTOMPARAMS"})
    public String getCustomParams() {
        return this.psSysValueRule.getCUSTOMPARAMS();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u78012", hideempty2=true, fields={"REGEXPCODE2"})
    public String getRegExCode2() {
        return this.psSysValueRule.getREGEXPCODE2();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u78013", hideempty2=true, fields={"REGEXPCODE3"})
    public String getRegExCode3() {
        return this.psSysValueRule.getREGEXPCODE3();
    }

    @Override
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f\u4ee3\u78014", hideempty2=true, fields={"REGEXPCODE4"})
    public String getRegExCode4() {
        return this.psSysValueRule.getREGEXPCODE4();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, outputdoc="false", ignorepf=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
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
        return this.psSysValueRule.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getRuleHolder() {
        return this.nRuleHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", fields={"RULEHOLDER"})
    public boolean isEnableBackend() {
        return (this.getRuleHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", fields={"RULEHOLDER"})
    public boolean isEnableFront() {
        return (this.getRuleHolder() & 2) == 2;
    }

    protected boolean isCustomRuleHolder() {
        return this.bCustomRuleHolder;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6807\u8bb0", hideempty2=true, fields={"RULETAG"})
    public String getRuleTag() {
        return this.psSysValueRule.getRULETAG();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u6807\u8bb02", hideempty2=true, fields={"RULETAG2"})
    public String getRuleTag2() {
        return this.psSysValueRule.getRULETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getRuleInfoLanResTag() {
        if (this.getRuleInfoPSLanguageRes() == null) {
            return null;
        }
        return this.getRuleInfoPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getRuleInfoPSLanguageRes() {
        return this.ruleInfoPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }
}

