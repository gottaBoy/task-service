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

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleType;
import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFHelpCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Util.MarkDownHelper;
import SA.SRFDA.PS.Data.PSHelpArticle;
import SA.SRFDA.PS.Data.PSHelpSection;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpArticleImpl
extends PSSystemObjectImpl
implements IPSHelpArticle,
IPSSFHelpCodeObject {
    private static final Log log = LogFactory.getLog(PSHelpArticleImpl.class);
    protected PSHelpArticle psHelpArticle = null;
    private String strArticleType = null;
    private IPSHelpArticleType iPSHelpArticleType = null;
    private ArrayList<IPSHelpSection> psHelpSectionList = new ArrayList();
    private ArrayList<IPSHelpSection> allPSHelpSectionList = new ArrayList();
    private IPSHelpArticleTempl iPSHelpArticleTempl = null;
    private IPSDataEntity iPSDataEntity = null;
    private String strArticleSN = null;
    private String strTitle = null;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSHelpArticle psHelpArticle) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psHelpArticle = psHelpArticle;
            this.setId(this.psHelpArticle.getPSHELPARTICLEID());
            this.setName(this.psHelpArticle.getPSHELPARTICLENAME());
            this.setPSObjectData(this.psHelpArticle);
            this.strArticleType = this.psHelpArticle.getARTICLETYPE();
            if (this.iPSHelpArticleType == null) {
                this.iPSHelpArticleType = this.getPSModelStorage().getPSHelpArticleType(this.strArticleType);
            }
            this.iPSHelpArticleTempl = this.iPSHelpArticleType.getDefaultPSHelpArticleTempl();
            this.strArticleSN = this.psHelpArticle.getARTICLESN();
            this.strTitle = this.psHelpArticle.getTITLE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strArticleSN)) {
                this.strArticleSN = this.getId();
            }
            this.strArticleSN = this.strArticleSN.toLowerCase();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpArticle.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psHelpArticle.getPSMODULEID());
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpArticle.getPSDEID())) {
            this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psHelpArticle.getPSDEID());
        }
        this.preparePSHelpSections();
        super.onInit();
    }

    protected void preparePSHelpSections() throws Exception {
        ArrayList<PSHelpSection> psHelpArticleList = this.psHelpArticle.getRootPSHelpSections(false);
        if (psHelpArticleList == null) {
            return;
        }
        for (PSHelpSection psHelpArticle : psHelpArticleList) {
            IPSHelpSection iPSHelpSection = this.getPSModelStorage().getPSHelpSectionType(psHelpArticle.getSECTIONTYPE()).createPSHelpSection(psHelpArticle);
            iPSHelpSection.init(this.getDAGlobalHelper(), this, null, psHelpArticle);
            this.psHelpSectionList.add(iPSHelpSection);
        }
        for (IPSHelpSection iPSHelpSection : this.psHelpSectionList) {
            this.allPSHelpSectionList.add(iPSHelpSection);
            iPSHelpSection.fillChildPSHelpSectionList(this.allPSHelpSectionList);
        }
    }

    public void setPSHelpArticleType(IPSHelpArticleType iPSHelpArticleType) {
        this.iPSHelpArticleType = iPSHelpArticleType;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u7ae0\u62ac\u5934\u7c7b\u578b", codelist="HelpArticleType")
    public String getArticleType() {
        return this.strArticleType;
    }

    @Override
    public IPSHelpArticleType getPSHelpArticleType() {
        return this.iPSHelpArticleType;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getRawContent() {
        return this.getContent(false);
    }

    @Override
    public String getContent() {
        return this.getContent(true);
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u5185\u5bb9")
    public String getRawHeaderContent() {
        return this.getHeaderContent(false);
    }

    @Override
    @PSModelRTMeta(description="\u5c3e\u90e8\u5185\u5bb9")
    public String getRawBottomContent() {
        return this.getBottomContent(false);
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
    public String getContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpArticle.getCONTENT());
        }
        return this.psHelpArticle.getCONTENT();
    }

    @Override
    public String getHeaderContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpArticle.getHEADERCONTENT());
        }
        return this.psHelpArticle.getHEADERCONTENT();
    }

    @Override
    public String getBottomContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpArticle.getBOTTOMCONTENT());
        }
        return this.psHelpArticle.getBOTTOMCONTENT();
    }

    @Override
    public String getModelType() {
        return "PSHELPARTICLE";
    }

    @Override
    @PSModelRTMeta(description="\u6839\u7ae0\u8282\u96c6\u5408")
    public Iterator<IPSHelpSection> getPSHelpSections() {
        if (this.psHelpSectionList == null || this.psHelpSectionList.size() == 0) {
            return null;
        }
        return this.psHelpSectionList.iterator();
    }

    @Override
    public IPSHelpArticleTempl getPSHelpArticleTempl() {
        return this.iPSHelpArticleTempl;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u7ae0\u62ac\u5934")
    public String getTitle() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strTitle)) {
            return this.getName();
        }
        return this.strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u7ae0\u7f16\u53f7")
    public String getArticleSN() {
        return this.strArticleSN;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpArticle.getCODENAME())) {
            return this.getArticleSN();
        }
        return this.psHelpArticle.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u7ae0\u6807\u8bb0")
    public String getArticleTag() {
        return this.psHelpArticle.getARTICLEPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u7ae0\u6807\u8bb02")
    public String getArticleTag2() {
        return this.psHelpArticle.getARTICLEPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u7ae0\u7248\u672c")
    public String getArticleVer() {
        return this.psHelpArticle.getARTICLEVER();
    }

    @Override
    public Iterator<IPSHelpSection> getAllPSHelpSections() {
        if (this.allPSHelpSectionList == null || this.allPSHelpSectionList.size() == 0) {
            return null;
        }
        return this.allPSHelpSectionList.iterator();
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
        return "HELPARTICLE";
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5e2e\u52a9\u4ee3\u7801\u7c7b\u578b")
    public String getSFHelpCodeType() {
        return this.getArticleType();
    }
}

