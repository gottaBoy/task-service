/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;

public interface IToolbarItemWriter {
    public CallResult Init(ToolbarItemWriterConfig var1, ISRFDAGlobalHelper var2);

    public CallResult Export(XMLNode var1, XMLNode var2, TBItemConfig var3, DEBehavior var4, IToolbarItemWriterContext var5, boolean var6);
}

