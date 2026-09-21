/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;

public class TextAreaWriter
extends BaseFormCtrlWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXTEXTBOX");
        if (this.formCtrlHelperConfig.GetExtValue("CARET", false)) {
            ctrlNode.SetValue("TEXTBOXMODE", "Caret");
        } else {
            ctrlNode.SetValue("TEXTBOXMODE", "MultiLine");
        }
        int nRowCount = 5;
        if (this.formCtrlHelperConfig.IsContainsKey("ROWS") && (nRowCount = this.formCtrlHelperConfig.GetExtValue("ROWS", nRowCount)) <= 0) {
            nRowCount = 5;
        }
        ctrlNode.SetValue("HEIGHT", StringHelper.Format((String)"%1$s", (Object)(nRowCount * 20)));
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        if (iFormCtrl.IsReadonly()) {
            ctrlNode.SetValue("READONLY", "TRUE");
        }
        return ctrlNode;
    }

    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATAGRIDTEXTEDITOR");
        return ctrlNode;
    }
}

