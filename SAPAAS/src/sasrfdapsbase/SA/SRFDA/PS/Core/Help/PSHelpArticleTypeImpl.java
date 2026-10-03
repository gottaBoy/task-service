/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection
 *  net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpArticlePublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleType;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Core.Help.PSHelpArticleImpl;
import SA.SRFDA.PS.Core.Help.PSHelpArticlePublisherImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDataEntityDataCtrl;
import SA.SRFDA.PS.Data.PSHelpArticleType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSHelpArticleTypeImpl
extends PSObjectImpl
implements IPSHelpArticleType {
    protected PSHelpArticleType psHelpArticleType = null;
    private static final Log log = LogFactory.getLog(PSHelpArticleTypeImpl.class);
    private String strHelpArticleObj = null;
    private String strPubObj = null;
    private IPSHelpArticleTempl defaultPSHelpArticleTempl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSHelpArticleType psHelpArticleType) throws Exception {
        this.psHelpArticleType = psHelpArticleType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psHelpArticleType.getPSHELPARTICLETYPEID());
        this.setName(psHelpArticleType.getPSHELPARTICLETYPENAME());
        this.setPSObjectData(this.psHelpArticleType);
        this.strHelpArticleObj = this.psHelpArticleType.getARTICLEOBJ();
        this.strPubObj = this.psHelpArticleType.getPUBOBJ();
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public void initModel(IPSSystem iPSSystem, SA.SRFDA.PS.Data.PSHelpArticle psHelpArticle) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        if (WebContext.getCurrent() == null) {
            SimpleWebContext iWebContext = new SimpleWebContext();
            iWebContext.init(null, null, null);
            WebContext.setCurrent((IWebContext)iWebContext);
            iWebContext.setSessionValue("SRFPERSONID", (Object)"SYSTEM");
            iWebContext.setSessionValue("SRFLOGINNAME", (Object)"SYSTEM");
            iWebContext.setSessionValue("SRFUSERNAME", (Object)"\u7cfb\u7edf\u5185\u7f6e\u7528\u6237");
        }
        SessionFactoryManager.addRef();
        try {
            PSHelpArticle psHelpArticle2 = new PSHelpArticle();
            PSDataEntityDataCtrl.convertEntity2(psHelpArticle, (IEntity)psHelpArticle2);
            this.onInitModel(iPSSystem, psHelpArticle2);
            SessionFactoryManager.commit();
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected void onInitModel(IPSSystem iPSSystem, PSHelpArticle psHelpArticle) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)iPSSystem.getPSSysModelInstId());
        PSHelpSectionService psHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSHELPARTICLEID", (Object)psHelpArticle.getPSHelpArticleId());
        selectCond.set("PPSHELPSECTIONID", SelectCond.ISNULL);
        ArrayList<PSHelpSection> psHelpSectionList = psHelpSectionService.select((ISelectCond)selectCond);
        for (PSHelpSection psHelpSection : psHelpSectionList) {
            SA.SRFDA.PS.Data.PSHelpSection psHelpSection2 = new SA.SRFDA.PS.Data.PSHelpSection();
            PSDEDataCtrl.convertEntity((IEntity)psHelpSection, psHelpSection2);
            IPSHelpSectionType iPSHelpSectionType = this.getPSModelStorage().getPSHelpSectionType(psHelpSection2.getSECTIONTYPE());
            iPSHelpSectionType.initModel(iPSSystem, psHelpSection2);
        }
    }

    @Override
    public IPSHelpArticle createPSHelpArticle(SA.SRFDA.PS.Data.PSHelpArticle psHelpArticle) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strHelpArticleObj)) {
            return new PSHelpArticleImpl();
        }
        return (IPSHelpArticle)ObjectHelper.Create((String)this.strHelpArticleObj);
    }

    @Override
    public IPSHelpArticleTempl getDefaultPSHelpArticleTempl() {
        return this.defaultPSHelpArticleTempl;
    }

    @Override
    public IPSHelpArticlePublisher createPSHelpArticlePublisher() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strPubObj)) {
            return new PSHelpArticlePublisherImpl();
        }
        return (IPSHelpArticlePublisher)ObjectHelper.Create((String)this.strPubObj);
    }
}
