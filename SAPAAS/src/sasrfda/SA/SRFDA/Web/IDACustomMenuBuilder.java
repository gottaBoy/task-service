/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;

public interface IDACustomMenuBuilder {
    public CallResult Build(ISRFDAGlobalHelper var1, ISRFDAWebContext var2, XMLNode var3);
}

