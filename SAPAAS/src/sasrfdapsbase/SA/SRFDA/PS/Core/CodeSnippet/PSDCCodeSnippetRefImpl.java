/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippetRef;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDCCodeSnippetRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCCodeSnippetRefImpl
extends PSObjectImpl
implements IPSDCCodeSnippetRef {
    protected PSDCCodeSnippetRef psDCCodeSnippetRef = null;
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetRefImpl.class);
    private IPSDCCodeSnippet iPSDCCodeSnippet = null;
    private String strRefMode = null;
    private String strRefPSDCCodeSnippetId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDCCodeSnippet iPSDCCodeSnippet, PSDCCodeSnippetRef psDCCodeSnippetRef) throws Exception {
        this.psDCCodeSnippetRef = psDCCodeSnippetRef;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDCCodeSnippetRef.getPSDCCODESNIPPETID());
        this.setName(psDCCodeSnippetRef.getPSDCCODESNIPPETNAME());
        this.setPSObjectData(this.psDCCodeSnippetRef);
        this.strRefMode = this.psDCCodeSnippetRef.getPSDCCODESNIPPETREFNAME();
        this.strRefPSDCCodeSnippetId = this.psDCCodeSnippetRef.getREFPSDCCODESNIPPETID();
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSDCCodeSnippet getPSDCCodeSnippet() {
        return this.iPSDCCodeSnippet;
    }

    @Override
    public String getRefMode() {
        return this.strRefMode;
    }

    @Override
    public IPSDCCodeSnippet getRefPSDCCodeSnippet() throws Exception {
        return this.getPSModelStorage().getPSDCCodeSnippet(this.getRefPSDCCodeSnippetId());
    }

    @Override
    public String getRefPSDCCodeSnippetId() {
        return this.strRefPSDCCodeSnippetId;
    }
}

