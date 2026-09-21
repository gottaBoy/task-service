/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.TextBoxWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IPAddressTextBoxWriter
extends TextBoxWriter {
    private static final Log log = LogFactory.getLog(TextBoxWriter.class);

    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper iDEFhelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModelDetail) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITOR");
        ctrlNode.SetValue("OBJECT", "SA.SRFDA.Ctrl.DataGrid.IPColumnEditor");
        return ctrlNode;
    }

    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode xmlNode, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXIPADDRESSTEXTBOX");
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        if (iFormCtrl.IsReadonly()) {
            ctrlNode.SetValue("READONLY", "TRUE");
        }
        return ctrlNode;
    }
}

