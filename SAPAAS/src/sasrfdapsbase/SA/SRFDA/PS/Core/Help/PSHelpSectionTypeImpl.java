/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Core.Help.PSHelpSectionImpl;
import SA.SRFDA.PS.Core.Help.PSHelpSectionPublisherImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDataEntityDataCtrl;
import SA.SRFDA.PS.Data.PSHelpSectionType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpSectionTypeImpl
extends PSObjectImpl
implements IPSHelpSectionType {
    protected PSHelpSectionType psHelpSectionType = null;
    private static final Log log = LogFactory.getLog(PSHelpSectionTypeImpl.class);
    private String strHelpSectionObj = null;
    private String strPubObj = null;
    private boolean bOutputDir = true;
    private IPSHelpSectionTempl defaultPSHelpSectionTempl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSHelpSectionType psHelpSectionType) throws Exception {
        this.psHelpSectionType = psHelpSectionType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psHelpSectionType.getPSHELPSECTIONTYPEID());
        this.setName(psHelpSectionType.getPSHELPSECTIONTYPENAME());
        this.setPSObjectData(this.psHelpSectionType);
        this.strHelpSectionObj = this.psHelpSectionType.getSECTIONOBJ();
        this.strPubObj = this.psHelpSectionType.getPUBOBJ();
        if (!this.psHelpSectionType.isOUTPUTDIRNull()) {
            this.bOutputDir = this.psHelpSectionType.getOUTPUTDIR();
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public void initModel(IPSSystem iPSSystem, SA.SRFDA.PS.Data.PSHelpSection psHelpSection) throws Exception {
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
            PSHelpSection psHelpSection2 = new PSHelpSection();
            PSDataEntityDataCtrl.convertEntity2(psHelpSection, (IEntity)psHelpSection2);
            this.onInitModel(iPSSystem, psHelpSection2);
            SessionFactoryManager.commit();
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    protected void onInitModel(IPSSystem iPSSystem, PSHelpSection psHelpSection) throws Exception {
    }

    @Override
    public IPSHelpSection createPSHelpSection(SA.SRFDA.PS.Data.PSHelpSection psHelpSection) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strHelpSectionObj)) {
            return new PSHelpSectionImpl();
        }
        return (IPSHelpSection)ObjectHelper.Create((String)this.strHelpSectionObj);
    }

    @Override
    public IPSHelpSectionPublisher createPSHelpSectionPublisher() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strPubObj)) {
            return new PSHelpSectionPublisherImpl();
        }
        return (IPSHelpSectionPublisher)ObjectHelper.Create((String)this.strPubObj);
    }

    @Override
    public IPSHelpSectionTempl getDefaultPSHelpSectionTempl() {
        return this.defaultPSHelpSectionTempl;
    }

    @Override
    public boolean isOutputDir() {
        return this.bOutputDir;
    }
}

