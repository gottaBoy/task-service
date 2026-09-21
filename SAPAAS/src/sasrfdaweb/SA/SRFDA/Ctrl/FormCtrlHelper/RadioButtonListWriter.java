/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseListFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;

public class RadioButtonListWriter
extends BaseListFormCtrlWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXRADIOBUTTONLIST");
        if (ctrlNode != null) {
            RadioButtonListWriter.AppendListFillterNode(this.strLanguage, iDEFHelper, formCtrlConfig, ctrlNode, bSearchMode, ctrlParams);
            XMLNode listFillerNode = ctrlNode.GetChildNodeByNodeName("SRFEXLISTFILLER");
            if (listFillerNode != null) {
                listFillerNode.SetValue("EMPTYSUPPORTED", "FALSE");
                listFillerNode.RemoveExtValue("EMPTYATFIRST");
                listFillerNode.RemoveExtValue("EMPTYTEXT");
            }
        }
        return ctrlNode;
    }
}

