/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.FormCtrlWriterConfig;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;

public interface IFormCtrlWriter {
    public CallResult Init(FormCtrlWriterConfig var1, GlobalHelperEx var2, String var3, String var4);

    public XMLNode GetFormCtrlNode(IDEFHelper var1, IDEMAFieldHelper var2, XMLNode var3);

    public XMLNode GetSearchFormCtrlNode(IDEFHelper var1, XMLNode var2, String var3, String var4);

    public XMLNode GetDGEditor(IDEFHelper var1, IDEMAFieldHelper var2, DGModeDetail var3);
}

