/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSCodeSnippetPublisher {
    public void init(ISRFDAGlobalHelper var1, IPSDCCodeSnippet var2) throws Exception;

    public IPSPublisherContext getContext();

    public void close();

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, IPSObject var2) throws Exception;

    public IPSGenerateCodeResult getRef(String var1, Object var2) throws Exception;
}

