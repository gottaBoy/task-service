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

import SA.SRFDA.PS.Core.Help.IPSHelpModule;
import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjType;
import SA.SRFDA.PS.Core.Help.PSHelpModuleImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFHelpCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Util.MarkDownHelper;
import SA.SRFDA.PS.Data.PSHelpModule;
import SA.SRFDA.PS.Data.PSHelpPrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpPrjImpl
extends PSSystemObjectImpl
implements IPSHelpPrj,
IPSSFHelpCodeObject {
    private static final Log log = LogFactory.getLog(PSHelpPrjImpl.class);
    protected PSHelpPrj psHelpPrj = null;
    private String strPrjType = null;
    private IPSHelpPrjType iPSHelpPrjType = null;
    private ArrayList<IPSHelpModule> psHelpModuleList = new ArrayList();
    private ArrayList<IPSHelpModule> allPSHelpModuleList = new ArrayList();
    private IPSHelpPrjTempl iPSHelpPrjTempl = null;
    private String strPrjSN = null;
    private String strTitle = null;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSHelpPrj psHelpPrj) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psHelpPrj = psHelpPrj;
            this.setId(this.psHelpPrj.getPSHELPPRJID());
            this.setName(this.psHelpPrj.getPSHELPPRJNAME());
            this.setPSObjectData(this.psHelpPrj);
            this.strPrjType = this.psHelpPrj.getPRJTYPE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPrjType)) {
                this.strPrjType = "COMMON";
            }
            if (this.iPSHelpPrjType == null) {
                this.iPSHelpPrjType = this.getPSModelStorage().getPSHelpPrjType(this.strPrjType);
            }
            this.iPSHelpPrjTempl = this.iPSHelpPrjType.getDefaultPSHelpPrjTempl();
            this.strPrjSN = this.psHelpPrj.getPRJSN();
            this.strTitle = this.psHelpPrj.getTITLE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPrjSN)) {
                this.strPrjSN = this.getId();
            }
            this.strPrjSN = this.strPrjSN.toLowerCase();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpPrj.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psHelpPrj.getPSMODULEID());
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
        this.preparePSHelpModules();
        super.onInit();
    }

    protected void preparePSHelpModules() throws Exception {
        ArrayList<PSHelpModule> psHelpModuleList = this.psHelpPrj.getRootPSHelpModules(false);
        if (psHelpModuleList == null) {
            return;
        }
        for (PSHelpModule psHelpModule : psHelpModuleList) {
            PSHelpModuleImpl iPSHelpModule = new PSHelpModuleImpl();
            iPSHelpModule.init(this.getDAGlobalHelper(), this, null, psHelpModule);
            this.psHelpModuleList.add(iPSHelpModule);
        }
        for (IPSHelpModule iPSHelpModule : this.psHelpModuleList) {
            this.allPSHelpModuleList.add(iPSHelpModule);
            iPSHelpModule.fillChildPSHelpModuleList(this.allPSHelpModuleList);
        }
    }

    public void setPSHelpPrjType(IPSHelpPrjType iPSHelpPrjType) {
        this.iPSHelpPrjType = iPSHelpPrjType;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u7c7b\u578b", codelist="HelpPrjType")
    public String getPrjType() {
        return this.strPrjType;
    }

    @Override
    public IPSHelpPrjType getPSHelpPrjType() {
        return this.iPSHelpPrjType;
    }

    @Override
    public String getModelType() {
        return "PSHELPPRJ";
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u6a21\u5757\u96c6\u5408")
    public Iterator<IPSHelpModule> getPSHelpModules() {
        if (this.psHelpModuleList == null || this.psHelpModuleList.size() == 0) {
            return null;
        }
        return this.psHelpModuleList.iterator();
    }

    @Override
    public Iterator<IPSHelpModule> getAllPSHelpModules() {
        if (this.allPSHelpModuleList == null || this.allPSHelpModuleList.size() == 0) {
            return null;
        }
        return this.allPSHelpModuleList.iterator();
    }

    @Override
    public IPSHelpPrjTempl getPSHelpPrjTempl() {
        return this.iPSHelpPrjTempl;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u62ac\u5934")
    public String getTitle() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strTitle)) {
            return this.getName();
        }
        return this.strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u7f16\u53f7")
    public String getPrjSN() {
        return this.strPrjSN;
    }

    @Override
    public String getContent() {
        return this.getContent(true);
    }

    @Override
    public String getHeaderContent() {
        return this.getHeaderContent(true);
    }

    @Override
    public String getBottomContent() {
        return this.getBottomContent(true);
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u76f4\u63a5\u5934\u90e8\u5185\u5bb9")
    public String getRawHeaderContent() {
        return this.getHeaderContent(false);
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u76f4\u63a5\u5185\u5bb9")
    public String getRawContent() {
        return this.getContent(false);
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u76f4\u63a5\u5c3e\u90e8\u5185\u5bb9")
    public String getRawBottomContent() {
        return this.getBottomContent(false);
    }

    @Override
    public String getContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpPrj.getCONTENT());
        }
        return this.psHelpPrj.getCONTENT();
    }

    @Override
    public String getHeaderContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpPrj.getHEADERCONTENT());
        }
        return this.psHelpPrj.getHEADERCONTENT();
    }

    @Override
    public String getBottomContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpPrj.getBOTTOMCONTENT());
        }
        return this.psHelpPrj.getBOTTOMCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpPrj.getCODENAME())) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPrjSN())) {
                return "";
            }
            return this.getPrjSN();
        }
        return this.psHelpPrj.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u6807\u8bb0")
    public String getPrjTag() {
        return this.psHelpPrj.getPRJPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76ee\u6807\u8bb02")
    public String getPrjTag2() {
        return this.psHelpPrj.getPRJPARAM2();
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5e2e\u52a9\u4ee3\u7801\u5206\u7c7b")
    public String getSFHelpCodeCat() {
        return "HELPPRJ";
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5e2e\u52a9\u4ee3\u7801\u7c7b\u578b")
    public String getSFHelpCodeType() {
        return this.getPrjType();
    }
}

