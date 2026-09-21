/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Res.IPSAppEditorStyleRef;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.LinkedHashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppEditorStyleRefImpl
extends PSApplicationObjectImpl
implements IPSAppEditorStyleRef {
    private static final Log log = LogFactory.getLog(PSAppEditorStyleRefImpl.class);
    private IPSSysEditorStyle iPSSysEditorStyle = null;
    private String strRefTag = null;
    private String strContainerType = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysEditorStyle iPSSysEditorStyle, String strContainerType, String strRefTag) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysEditorStyle = iPSSysEditorStyle;
            this.strRefTag = strRefTag;
            this.strContainerType = strContainerType;
            this.setId(KeyValueHelper.genUniqueId((String)iPSApplication.getId(), (String)iPSSysEditorStyle.getId(), (String)strContainerType, (String)strRefTag));
            this.setName(iPSSysEditorStyle.getName());
            if (iPSSysEditorStyle.getPSSysPFPlugin() != null) {
                this.iPSSysPFPlugin = this.getPSApplication().getPSSysPFPlugin(iPSSysEditorStyle.getPSSysPFPlugin().getId(), "EDITORSTYPE", null, null);
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)iPSSysEditorStyle.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
                    params.put("app", this.getPSApplication());
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this, params);
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u7f16\u8f91\u5668\u6837\u5f0f", group="\u57fa\u672c", order=115)
    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6807\u8bb0", group="\u57fa\u672c", order=117)
    public String getRefTag() {
        return this.strRefTag;
    }

    @Override
    @PSModelRTMeta(description="\u5bb9\u5668\u7c7b\u578b")
    public String getContainerType() {
        return this.strContainerType;
    }

    @Override
    public String getModelType() {
        return "PSAPPEDITORSTYLEREF";
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u4ee3\u7801")
    public String getPluginCode() {
        if (this.getPSSysPFPlugin() != null) {
            return this.getPSSysPFPlugin().getPluginCode();
        }
        return "";
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u6269\u5c55\u754c\u9762\u6837\u5f0f", ignoredumpvalues="false")
    public boolean isExtendStyleOnly() {
        return this.getPSSysEditorStyle().isExtendStyleOnly();
    }

    @Override
    @PSModelRTMeta(description="\u6837\u5f0f\u4ee3\u7801")
    public String getStyleCode() {
        return this.getPSSysEditorStyle().getStyleCode();
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
        return this.getPSSysEditorStyle().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b")
    public String getEditorType() {
        return this.getPSSysEditorStyle().getEditorType();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }
}

