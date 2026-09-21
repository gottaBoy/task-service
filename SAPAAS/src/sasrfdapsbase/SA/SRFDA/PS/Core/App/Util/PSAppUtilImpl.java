/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUtilImpl
extends PSApplicationObjectImpl
implements IPSAppUtil,
IPSPFLogicCodeObject {
    private static final Log log = LogFactory.getLog(PSAppUtilImpl.class);
    protected PSAppUtil psAppUtil;
    private String strUtilPSDEId = null;
    private String strUtilPSDE2Id = null;
    private String strUtilPSDE3Id = null;
    private String strUtilPSDE4Id = null;
    private String strUtilPSDE5Id = null;
    private String strUtilPSDE6Id = null;
    private String strUtilPSDE7Id = null;
    private String strUtilPSDE8Id = null;
    private String strUtilPSDE9Id = null;
    private String strUtilPSDE10Id = null;
    private String strUtilPSDE11Id = null;
    private String strUtilPSDE12Id = null;
    private String strUtilPSDE13Id = null;
    private String strUtilPSDE14Id = null;
    private String strUtilPSDE15Id = null;
    private String strUtilPSDE16Id = null;
    private String strUtilPSDE17Id = null;
    private String strUtilPSDE18Id = null;
    private String strUtilPSDE19Id = null;
    private String strUtilPSDE20Id = null;
    private String strUtilPSDEName = null;
    private String strUtilPSDE2Name = null;
    private String strUtilPSDE3Name = null;
    private String strUtilPSDE4Name = null;
    private String strUtilPSDE5Name = null;
    private String strUtilPSDE6Name = null;
    private String strUtilPSDE7Name = null;
    private String strUtilPSDE8Name = null;
    private String strUtilPSDE9Name = null;
    private String strUtilPSDE10Name = null;
    private String strUtilPSDE11Name = null;
    private String strUtilPSDE12Name = null;
    private String strUtilPSDE13Name = null;
    private String strUtilPSDE14Name = null;
    private String strUtilPSDE15Name = null;
    private String strUtilPSDE16Name = null;
    private String strUtilPSDE17Name = null;
    private String strUtilPSDE18Name = null;
    private String strUtilPSDE19Name = null;
    private String strUtilPSDE20Name = null;
    private String strUtilType = null;
    private boolean bRegToApp = true;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private Properties utilParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppUtil psAppUtil) throws Exception {
        try {
            this.setPSApplication(iPSApplication);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psAppUtil = psAppUtil;
            this.setId(psAppUtil.getPSAPPUTILID());
            this.setName(psAppUtil.getPSAPPUTILNAME());
            this.setPSObjectData(this.psAppUtil);
            this.strUtilPSDEId = this.psAppUtil.getUTILPSDEID();
            this.strUtilPSDE2Id = this.psAppUtil.getUTILPSDE2ID();
            this.strUtilPSDE3Id = this.psAppUtil.getUTILPSDE3ID();
            this.strUtilPSDE4Id = this.psAppUtil.getUTILPSDE4ID();
            this.strUtilPSDE5Id = this.psAppUtil.getUTILPSDE5ID();
            this.strUtilPSDE6Id = this.psAppUtil.getUTILPSDE6ID();
            this.strUtilPSDE7Id = this.psAppUtil.getUTILPSDE7ID();
            this.strUtilPSDE8Id = this.psAppUtil.getUTILPSDE8ID();
            this.strUtilPSDE9Id = this.psAppUtil.getUTILPSDE9ID();
            this.strUtilPSDEName = this.psAppUtil.getUTILPSDENAME();
            this.strUtilPSDE2Name = this.psAppUtil.getUTILPSDE2NAME();
            this.strUtilPSDE3Name = this.psAppUtil.getUTILPSDE3NAME();
            this.strUtilPSDE4Name = this.psAppUtil.getUTILPSDE4NAME();
            this.strUtilPSDE5Name = this.psAppUtil.getUTILPSDE5NAME();
            this.strUtilPSDE6Name = this.psAppUtil.getUTILPSDE6NAME();
            this.strUtilPSDE7Name = this.psAppUtil.getUTILPSDE7NAME();
            this.strUtilPSDE8Name = this.psAppUtil.getUTILPSDE8NAME();
            this.strUtilPSDE9Name = this.psAppUtil.getUTILPSDE9NAME();
            this.strUtilType = this.psAppUtil.getUTILTYPE();
            if (!StringHelper.isNullOrEmpty((String)this.psAppUtil.getUTILPARAMS())) {
                this.utilParams = PropertiesHelper.load((String)this.psAppUtil.getUTILPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppUtil.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.psAppUtil.getPSSYSPFPLUGINID());
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
        if (this.getPSSysPFPlugin() != null && this.getPSApplication() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
            }
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSAPPUTIL";
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b", codelist="AppUtilType", group="\u57fa\u672c", order=125, fields={"UTILTYPE"})
    public String getUtilType() {
        return this.strUtilType;
    }

    @Override
    public String getUtilPSDEId() {
        return this.strUtilPSDEId;
    }

    @Override
    public String getUtilPSDE2Id() {
        return this.strUtilPSDE2Id;
    }

    @Override
    public String getUtilPSDE3Id() {
        return this.strUtilPSDE3Id;
    }

    @Override
    public String getUtilPSDE4Id() {
        return this.strUtilPSDE4Id;
    }

    @Override
    public String getUtilPSDE5Id() {
        return this.strUtilPSDE5Id;
    }

    @Override
    public String getUtilPSDE6Id() {
        return this.strUtilPSDE6Id;
    }

    @Override
    public String getUtilPSDE7Id() {
        return this.strUtilPSDE7Id;
    }

    @Override
    public String getUtilPSDE8Id() {
        return this.strUtilPSDE8Id;
    }

    @Override
    public String getUtilPSDE9Id() {
        return this.strUtilPSDE9Id;
    }

    @Override
    public String getUtilPSDE10Id() {
        return this.strUtilPSDE10Id;
    }

    @Override
    public String getUtilPSDE11Id() {
        return this.strUtilPSDE11Id;
    }

    @Override
    public String getUtilPSDE12Id() {
        return this.strUtilPSDE12Id;
    }

    @Override
    public String getUtilPSDE13Id() {
        return this.strUtilPSDE13Id;
    }

    @Override
    public String getUtilPSDE14Id() {
        return this.strUtilPSDE14Id;
    }

    @Override
    public String getUtilPSDE15Id() {
        return this.strUtilPSDE15Id;
    }

    @Override
    public String getUtilPSDE16Id() {
        return this.strUtilPSDE16Id;
    }

    @Override
    public String getUtilPSDE17Id() {
        return this.strUtilPSDE17Id;
    }

    @Override
    public String getUtilPSDE18Id() {
        return this.strUtilPSDE18Id;
    }

    @Override
    public String getUtilPSDE19Id() {
        return this.strUtilPSDE19Id;
    }

    @Override
    public String getUtilPSDE20Id() {
        return this.strUtilPSDE20Id;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f53\u540d\u79f0", hideempty2=true)
    public String getUtilPSDEName() {
        return this.strUtilPSDEName;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f532\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE2Name() {
        return this.strUtilPSDE2Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f533\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE3Name() {
        return this.strUtilPSDE3Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f534\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE4Name() {
        return this.strUtilPSDE4Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f535\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE5Name() {
        return this.strUtilPSDE5Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f536\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE6Name() {
        return this.strUtilPSDE6Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f537\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE7Name() {
        return this.strUtilPSDE7Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f538\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE8Name() {
        return this.strUtilPSDE8Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f539\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE9Name() {
        return this.strUtilPSDE9Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u5b9e\u4f5310\u540d\u79f0", hideempty2=true)
    public String getUtilPSDE10Name() {
        return this.strUtilPSDE10Name;
    }

    @Override
    public String getUtilPSDE11Name() {
        return this.strUtilPSDE11Name;
    }

    @Override
    public String getUtilPSDE12Name() {
        return this.strUtilPSDE12Name;
    }

    @Override
    public String getUtilPSDE13Name() {
        return this.strUtilPSDE13Name;
    }

    @Override
    public String getUtilPSDE14Name() {
        return this.strUtilPSDE14Name;
    }

    @Override
    public String getUtilPSDE15Name() {
        return this.strUtilPSDE15Name;
    }

    @Override
    public String getUtilPSDE16Name() {
        return this.strUtilPSDE16Name;
    }

    @Override
    public String getUtilPSDE17Name() {
        return this.strUtilPSDE17Name;
    }

    @Override
    public String getUtilPSDE18Name() {
        return this.strUtilPSDE18Name;
    }

    @Override
    public String getUtilPSDE19Name() {
        return this.strUtilPSDE19Name;
    }

    @Override
    public String getUtilPSDE20Name() {
        return this.strUtilPSDE20Name;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6807\u8bb0", hideempty=true, group="\u57fa\u672c", order=126, fields={"UTILTAG"})
    public String getUtilTag() {
        if (StringHelper.isNullOrEmpty((String)this.psAppUtil.getUTILTAG())) {
            return null;
        }
        return this.psAppUtil.getUTILTAG();
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public boolean isRegToApp() {
        return this.bRegToApp;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u522b", dump=false)
    public String getPFLogicCodeCat() {
        return "APPUTIL";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        if (StringHelper.isNullOrEmpty((String)this.getUtilTag())) {
            return this.getUtilType();
        }
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getUtilType(), (Object)this.getUtilTag());
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return this.getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
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
        return this.psAppUtil.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u529f\u80fd\u53c2\u6570\u96c6\u5408", hideempty=true, fields={"UTILPARAMS"})
    public Properties getUtilParams() {
        return this.utilParams;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

