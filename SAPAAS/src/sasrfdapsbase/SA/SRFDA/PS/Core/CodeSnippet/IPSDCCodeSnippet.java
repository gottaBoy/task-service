/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.IPSCodeSnippetType;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippetRef;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSCodeSnippetPublisher;
import SA.SRFDA.PS.Data.PSDCCodeSnippet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSDCCodeSnippet
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDCCodeSnippet var2) throws Exception;

    public IPSCodeSnippetType getPSCodeSnippetType();

    public Iterator<IPSDCCodeSnippetRef> getPSDCCodeSnippetRefs() throws Exception;

    public IPSDCCodeSnippetRef getPSDCCodeSnippetRef(String var1) throws Exception;

    public IPSDCCodeSnippetRef getPSDCCodeSnippetRef(String var1, boolean var2) throws Exception;

    public void resetPSDCCodeSnippetRef(String var1) throws Exception;

    public IPSCodeSnippetPublisher getPSCodeSnippetPublisher() throws Exception;

    public void releasePSCodeSnippetPublisher(IPSCodeSnippetPublisher var1);

    public void resetPSCodeSnippetPublishers();

    public PSDCCodeSnippet getPSDCCodeSnippetData();
}

