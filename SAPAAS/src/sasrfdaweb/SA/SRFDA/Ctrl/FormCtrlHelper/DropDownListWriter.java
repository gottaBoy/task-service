/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseListFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DropDownListWriter
extends BaseListFormCtrlWriter {
    private static final Log log = LogFactory.getLog(DropDownListWriter.class);

    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDROPDOWNLIST");
        if (ctrlNode != null) {
            DropDownListWriter.AppendListFillterNode(this.strLanguage, iDEFHelper, iDEMAFieldHelper, formCtrlConfig, ctrlNode, bSearchMode, ctrlParams);
        }
        return ctrlNode;
    }

    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        String strCodeList = iDEFHelper.GetCodeList();
        if (StringHelper.IsNullOrEmpty((String)strCodeList)) {
            return null;
        }
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITOR");
        ctrlNode.SetValue("OBJECT", "SA.SRFDA.Ctrl.DataGrid.CodeListColumnEditor");
        ctrlNode.SetValue("CODELIST", strCodeList);
        if (iDEFHelper.GetFormCtrl().IsAllowEmpty()) {
            ctrlNode.SetValue("EMPTYENABLE", "TRUE");
        } else {
            ctrlNode.SetValue("EMPTYENABLE", "FALSE");
        }
        return ctrlNode;
    }
}

