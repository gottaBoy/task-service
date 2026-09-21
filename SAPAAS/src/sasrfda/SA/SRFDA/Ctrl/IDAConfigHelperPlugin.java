/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;

public interface IDAConfigHelperPlugin {
    public CallResult Process(IDAConfigHelper var1, IDEHelper var2, Object var3, String var4, XMLNode var5, XMLNode var6);
}

