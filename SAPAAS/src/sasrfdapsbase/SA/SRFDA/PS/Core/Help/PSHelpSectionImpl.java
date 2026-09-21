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

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpResource;
import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSFHelpCodeObject;
import SA.SRFDA.PS.Core.Util.MarkDownHelper;
import SA.SRFDA.PS.Data.PSHelpSection;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpSectionImpl
extends PSObjectImpl
implements IPSHelpSection,
IPSSFHelpCodeObject {
    private static final Log log = LogFactory.getLog(PSHelpSectionImpl.class);
    private IPSHelpArticle iPSHelpArticle = null;
    private IPSHelpSection parentPSHelpSection = null;
    protected PSHelpSection psHelpSection = null;
    private String strSectionType = null;
    private ArrayList<IPSHelpSection> psHelpSectionList = new ArrayList();
    private IPSHelpSectionTempl iPSHelpSectionTempl = null;
    private IPSHelpSectionType iPSHelpSectionType = null;
    private boolean bOutputDir = true;
    private IPSDEField iPSDEField = null;
    private IPSCodeList iPSCodeList = null;
    private IPSDEUIAction iPSDEUIAction = null;
    private IPSHelpArticle refPSHelpActicle = null;
    private boolean bContentAsCode = false;
    private IPSHelpResource imagePSHelpResource = null;
    private IPSHelpResource linkPSHelpResource = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSHelpArticle iPSHelpArticle, IPSHelpSection parentPSHelpSection, PSHelpSection psHelpSection) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psHelpSection = psHelpSection;
            this.iPSHelpArticle = iPSHelpArticle;
            this.parentPSHelpSection = parentPSHelpSection;
            this.setId(this.psHelpSection.getPSHELPSECTIONID());
            this.setName(this.psHelpSection.getPSHELPSECTIONNAME());
            this.setPSObjectData(this.psHelpSection);
            this.strSectionType = this.psHelpSection.getSECTIONTYPE();
            this.iPSHelpSectionType = this.getPSModelStorage().getPSHelpSectionType(this.strSectionType);
            this.iPSHelpSectionTempl = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpSection.getPSHELPSECTIONTEMPLID()) ? this.getPSModelStorage().getPSHelpSectionTempl(this.psHelpSection.getPSHELPSECTIONTEMPLID()) : this.iPSHelpSectionType.getDefaultPSHelpSectionTempl();
            this.bOutputDir = !this.psHelpSection.isOUTPUTDIRNull() ? this.psHelpSection.getOUTPUTDIR() : this.iPSHelpSectionType.isOutputDir();
            if (!this.psHelpSection.isCONTENTASCODENull()) {
                this.bContentAsCode = this.psHelpSection.getCONTENTASCODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpSection.getPSDEFIELDID()) && this.getPSHelpArticle().getPSDataEntity() != null) {
                this.iPSDEField = this.getPSHelpArticle().getPSDataEntity().getPSDEField(this.psHelpSection.getPSDEFIELDID(), true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpSection.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSHelpArticle().getPSSystem().getPSCodeList(this.psHelpSection.getPSCODELISTID(), true);
            } else if (this.getPSDEField() != null) {
                this.iPSCodeList = this.getPSDEField().getPSCodeList();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpSection.getPSDEUIACTIONID()) && this.getPSHelpArticle().getPSDataEntity() != null) {
                this.iPSDEUIAction = this.getPSHelpArticle().getPSDataEntity().getPSDEUIAction(this.psHelpSection.getPSDEUIACTIONID(), true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpSection.getREFPSHELPARTICLEID())) {
                this.refPSHelpActicle = this.getPSHelpArticle().getPSSystem().getPSHelpArticle(this.psHelpSection.getREFPSHELPARTICLEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpSection.getPSHELPRESOURCEID())) {
                this.imagePSHelpResource = this.getPSHelpArticle().getPSSystem().getPSHelpResource(this.psHelpSection.getPSHELPRESOURCEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psHelpSection.getLINKPSHELPRESOURCEID())) {
                this.linkPSHelpResource = this.getPSHelpArticle().getPSSystem().getPSHelpResource(this.psHelpSection.getLINKPSHELPRESOURCEID());
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
        this.preparePSHelpSections();
        super.onInit();
    }

    protected void preparePSHelpSections() throws Exception {
        ArrayList<PSHelpSection> psHelpSectionList = this.psHelpSection.getChildPSHelpSections(false);
        if (psHelpSectionList == null) {
            return;
        }
        for (PSHelpSection psHelpSection : psHelpSectionList) {
            IPSHelpSection iPSHelpSection = this.getPSModelStorage().getPSHelpSectionType(psHelpSection.getSECTIONTYPE()).createPSHelpSection(psHelpSection);
            iPSHelpSection.init(this.getDAGlobalHelper(), this.iPSHelpArticle, this, psHelpSection);
            this.psHelpSectionList.add(iPSHelpSection);
        }
    }

    @Override
    public String getModelType() {
        return "PSHELPSECTION";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSHelpArticle().getModelId(), (Object)super.getModelId());
    }

    @Override
    public IPSHelpSection getParentPSHelpSection() {
        return this.parentPSHelpSection;
    }

    @Override
    public IPSHelpArticle getPSHelpArticle() {
        return this.iPSHelpArticle;
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
            return MarkDownHelper.renderHtml2(this.psHelpSection.getCONTENT());
        }
        return this.psHelpSection.getCONTENT();
    }

    @Override
    public String getHeaderContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpSection.getHEADERCONTENT());
        }
        return this.psHelpSection.getHEADERCONTENT();
    }

    @Override
    public String getBottomContent(boolean bRenderHtml) {
        if (bRenderHtml) {
            return MarkDownHelper.renderHtml2(this.psHelpSection.getBOTTOMCONTENT());
        }
        return this.psHelpSection.getBOTTOMCONTENT();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSHelpArticle().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u7ae0\u8282\u7c7b\u578b", codelist="HelpSectionType")
    public String getSectionType() {
        return this.strSectionType;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7ae0\u8282\u96c6\u5408")
    public Iterator<IPSHelpSection> getPSHelpSections() {
        if (this.psHelpSectionList == null || this.psHelpSectionList.size() == 0) {
            return null;
        }
        return this.psHelpSectionList.iterator();
    }

    @Override
    public IPSHelpSectionTempl getPSHelpSectionTempl() {
        return this.iPSHelpSectionTempl;
    }

    @Override
    public IPSHelpSectionType getPSHelpSectionType() {
        return this.iPSHelpSectionType;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getTitle() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u4e3a\u76ee\u5f55")
    public boolean isOutputDir() {
        return this.bOutputDir;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61")
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5e2e\u52a9\u6587\u7ae0")
    public IPSHelpArticle getRefPSHelpArticle() {
        return this.refPSHelpActicle;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u4e3a\u4ee3\u7801")
    public boolean isContentAsCode() {
        return this.bContentAsCode;
    }

    @Override
    @PSModelRTMeta(description="\u7ae0\u8282\u7ea7\u522b")
    public int getSectionLevel() {
        if (this.getParentPSHelpSection() != null) {
            return this.getParentPSHelpSection().getSectionLevel() + 1;
        }
        return 1;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5e2e\u52a9\u8d44\u6e90")
    public IPSHelpResource getImagePSHelpResource() {
        return this.imagePSHelpResource;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5e2e\u52a9\u8d44\u6e90")
    public IPSHelpResource getLinkPSHelpResource() {
        return this.linkPSHelpResource;
    }

    @Override
    public IPSHelpSection getPSHelpSectionByUserTag(String strUserTag) {
        for (IPSHelpSection iPSHelpSection : this.psHelpSectionList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSHelpSection.getUserTag(), (String)strUserTag, (boolean)true) != 0) continue;
            return iPSHelpSection;
        }
        return null;
    }

    @Override
    public IPSHelpSection getPSHelpSectionByUserTag2(String strUserTag2) {
        for (IPSHelpSection iPSHelpSection : this.psHelpSectionList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSHelpSection.getUserTag2(), (String)strUserTag2, (boolean)true) != 0) continue;
            return iPSHelpSection;
        }
        return null;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSHelpArticle().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u7ae0\u8282\u6807\u8bb0")
    public String getSectionTag() {
        return this.psHelpSection.getSECTIONPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u7ae0\u8282\u6807\u8bb02")
    public String getSectionTag2() {
        return this.psHelpSection.getSECTIONPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psHelpSection.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    public void fillChildPSHelpSectionList(ArrayList<IPSHelpSection> list) {
        for (IPSHelpSection iPSHelpSection : this.psHelpSectionList) {
            list.add(iPSHelpSection);
            iPSHelpSection.fillChildPSHelpSectionList(list);
        }
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5e2e\u52a9\u4ee3\u7801\u5206\u7c7b")
    public String getSFHelpCodeCat() {
        return "HELPSECTION";
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u5e2e\u52a9\u4ee3\u7801\u7c7b\u578b")
    public String getSFHelpCodeType() {
        return this.getSectionType();
    }
}

