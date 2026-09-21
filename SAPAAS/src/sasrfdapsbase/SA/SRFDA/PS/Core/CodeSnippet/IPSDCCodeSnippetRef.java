/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSDCCodeSnippetRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDCCodeSnippetRef
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSDCCodeSnippet var2, PSDCCodeSnippetRef var3) throws Exception;

    public IPSDCCodeSnippet getPSDCCodeSnippet();

    public String getRefMode();

    public IPSDCCodeSnippet getRefPSDCCodeSnippet() throws Exception;

    public String getRefPSDCCodeSnippetId();
}

