/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.IPSCodeSnippetType;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodeSnippetPublisher;
import SA.SRFDA.PS.Data.PSCodeSnippetType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodeSnippetTypeImpl
extends PSObjectImpl
implements IPSCodeSnippetType {
    protected PSCodeSnippetType psCodeSnippetType = null;
    private static final Log log = LogFactory.getLog(PSCodeSnippetTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSCodeSnippetType psCodeSnippetType) throws Exception {
        this.psCodeSnippetType = psCodeSnippetType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psCodeSnippetType.getPSCODESNIPPETTYPEID());
        this.setName(psCodeSnippetType.getPSCODESNIPPETTYPENAME());
        this.setPSObjectData(this.psCodeSnippetType);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSCodeSnippetPublisher createPSCodeSnippetPublisher(IPSDCCodeSnippet iPSDCCodeSnippet) throws Exception {
        return (IPSCodeSnippetPublisher)ObjectHelper.Create((String)this.psCodeSnippetType.getPUBOBJ());
    }
}

