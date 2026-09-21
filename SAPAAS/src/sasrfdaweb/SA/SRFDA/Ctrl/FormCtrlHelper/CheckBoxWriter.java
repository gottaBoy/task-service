/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;

public class CheckBoxWriter
extends BaseFormCtrlWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXCHECKBOX");
        return ctrlNode;
    }

    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITOR");
        ctrlNode.SetValue("OBJECT", "SA.SRFDA.Ctrl.DataGrid.CheckBoxColumnEditor");
        if (iDEFHelper.GetFormCtrl().IsAllowEmpty()) {
            ctrlNode.SetValue("EMPTYENABLE", "TRUE");
        } else {
            ctrlNode.SetValue("EMPTYENABLE", "FALSE");
        }
        return ctrlNode;
    }
}

