/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Model;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.XML.XMLNode;

public interface IDAFormItemHelper {
    public void Init(GlobalHelperEx var1);

    public XMLNode GetSearchFormCtrlNode(String var1, String var2, IDEHelper var3, IDEFHelper var4, SearchItemConfig var5);

    public XMLNode GetSearchFormCtrlNode(String var1, String var2, IDEHelper var3, IDEFHelper var4, SearchItemConfig var5, XMLNode var6);

    public String GetSearchFormItemId(IDEFHelper var1, SearchItemConfig var2);

    public XMLNode GetFormCtrlNode(String var1, String var2, IDEHelper var3, IDEFHelper var4, XMLNode var5);

    public XMLNode GetDGEditorNode(String var1, String var2, IDEHelper var3, IDEFHelper var4, DGModeDetail var5);
}

