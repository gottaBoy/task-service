/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpModule;
import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSFHelpCodeObject;
import SA.SRFDA.PS.Data.PSHelpModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpModuleImpl
extends PSObjectImpl
implements IPSHelpModule,
IPSSFHelpCodeObject {
    private static final Log log = LogFactory.getLog(PSHelpModuleImpl.class);
    private IPSHelpPrj iPSHelpPrj = null;
    private IPSHelpModule parentPSHelpModule = null;
    protected PSHelpModule psHelpModule = null;
    private ArrayList<IPSHelpModule> psHelpModuleList = new ArrayList();
    private boolean bOutputDir = true;
    private IPSHelpArticle iPSHelpArticle = null;
    private String strArticleUrl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSHelpPrj iPSHelpPrj, IPSHelpModule parentPSHelpModule, PSHelpModule psHelpModule) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psHelpModule = psHelpModule;
            this.iPSHelpPrj = iPSHelpPrj;
            this.parentPSHelpModule = parentPSHelpModule;
            this.setId(this.psHelpModule.getPSHELPMODULEID());
            this.setName(this.psHelpModule.getPSHELPMODULENAME());
            this.setPSObjectData(this.psHelpModule);
            if (!StringHelper.IsNullOrEmpty((String)this.psHelpModule.getPSHELPARTICLEID())) {
                this.iPSHelpArticle = this.getPSHelpPrj().getPSSystem().getPSHelpArticle(this.psHelpModule.getPSHELPARTICLEID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psHelpModule.getARTICLEURL())) {
                this.strArticleUrl = this.psHelpModule.getARTICLEURL();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.preparePSHelpModules();
        super.onInit();
    }

    protected void preparePSHelpModules() throws Exception {
        ArrayList<PSHelpModule> psHelpModuleList = this.psHelpModule.getChildPSHelpModules(false);
        if (psHelpModuleList == null) {
            return;
        }
        for (PSHelpModule psHelpModule : psHelpModuleList) {
            PSHelpModuleImpl iPSHelpModule = new PSHelpModuleImpl();
            iPSHelpModule.init(this.getDAGlobalHelper(), this.iPSHelpPrj, this, psHelpModule);
            this.psHelpModuleList.add(iPSHelpModule);
        }
    }

    @Override
    public String getModelType() {
        return "PSHELPMODULE";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSHelpPrj().getModelId(), (Object)super.getModelId());
    }

    @Override
    public IPSHelpModule getParentPSHelpModule() {
        return this.parentPSHelpModule;
    }

    @Override
    public IPSHelpPrj getPSHelpPrj() {
        if (this.iPSHelpPrj == null) {
            return null;
        }
        return this.iPSHelpPrj;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSHelpPrj().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6a21\u5757\u96c6\u5408")
    public Iterator<IPSHelpModule> getPSHelpModules() {
        if (this.psHelpModuleList == null || this.psHelpModuleList.size() == 0) {
            return null;
        }
        return this.psHelpModuleList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u62ac\u5934")
    public String getTitle() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u76ee\u5f55")
    public boolean isOutputDir() {
        return this.bOutputDir;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u7ea7\u522b")
    public int getModuleLevel() {
        if (this.getParentPSHelpModule() != null) {
            return this.getParentPSHelpModule().getModuleLevel() + 1;
        }
        return 1;
    }

    @Override
    public IPSHelpArticle getPSHelpArticle() {
        return this.iPSHelpArticle;
    }

    @Override
    public void fillChildPSHelpModuleList(ArrayList<IPSHelpModule> list) {
        for (IPSHelpModule iPSHelpModule : this.psHelpModuleList) {
            list.add(iPSHelpModule);
            iPSHelpModule.fillChildPSHelpModuleList(list);
        }
    }

    @Override
    @PSModelRTMeta(description="\u6587\u7ae0\u8def\u5f84")
    public String getArticleUrl() {
        return this.strArticleUrl;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSHelpPrj().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psHelpModule.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb0")
    public String getModuleTag() {
        return this.psHelpModule.getMODPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb02")
    public String getModuleTag2() {
        return this.psHelpModule.getMODPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5e2e\u52a9\u4ee3\u7801\u5206\u7c7b")
    public String getSFHelpCodeCat() {
        return "HELPMODULE";
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5e2e\u52a9\u4ee3\u7801\u7c7b\u578b")
    public String getSFHelpCodeType() {
        return "COMMON";
    }
}

