/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjType;
import SA.SRFDA.PS.Core.Help.PSHelpPrjImpl;
import SA.SRFDA.PS.Core.Help.PSHelpPrjPublisherImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSHelpPrj;
import SA.SRFDA.PS.Data.PSHelpPrjType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpPrjTypeImpl
extends PSObjectImpl
implements IPSHelpPrjType {
    protected PSHelpPrjType psHelpPrjType = null;
    private static final Log log = LogFactory.getLog(PSHelpPrjTypeImpl.class);
    private String strHelpPrjObj = null;
    private String strPubObj = null;
    private IPSHelpPrjTempl defaultPSHelpPrjTempl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSHelpPrjType psHelpPrjType) throws Exception {
        this.psHelpPrjType = psHelpPrjType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psHelpPrjType.getPSHELPPRJTYPEID());
        this.setName(psHelpPrjType.getPSHELPPRJTYPENAME());
        this.setPSObjectData(this.psHelpPrjType);
        this.strHelpPrjObj = this.psHelpPrjType.getPRJOBJ();
        this.strPubObj = this.psHelpPrjType.getPUBOBJ();
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSHelpPrj createPSHelpPrj(PSHelpPrj psHelpPrj) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strHelpPrjObj)) {
            return new PSHelpPrjImpl();
        }
        return (IPSHelpPrj)ObjectHelper.Create((String)this.strHelpPrjObj);
    }

    @Override
    public IPSHelpPrjTempl getDefaultPSHelpPrjTempl() {
        return this.defaultPSHelpPrjTempl;
    }

    @Override
    public IPSHelpPrjPublisher createPSHelpPrjPublisher() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strPubObj)) {
            return new PSHelpPrjPublisherImpl();
        }
        return (IPSHelpPrjPublisher)ObjectHelper.Create((String)this.strPubObj);
    }
}

