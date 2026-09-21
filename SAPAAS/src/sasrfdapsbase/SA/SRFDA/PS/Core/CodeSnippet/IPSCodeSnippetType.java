/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodeSnippetPublisher;
import SA.SRFDA.PS.Data.PSCodeSnippetType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSCodeSnippetType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSCodeSnippetType var2) throws Exception;

    public IPSCodeSnippetPublisher createPSCodeSnippetPublisher(IPSDCCodeSnippet var1) throws Exception;
}

