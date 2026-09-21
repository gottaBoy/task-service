/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;

public class UserControlWriter
extends BaseFormCtrlWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXUSERCONTROLEX");
        String strFormItemXML = formCtrlConfig.GetExtValue("FC_FORMITEMXML", "");
        if (StringHelper.IsNullOrEmpty((String)strFormItemXML)) {
            strFormItemXML = iDEFHelper.GetFormCtrl().GetUserControlConfig();
        }
        ctrlNode.SetValue("CONFIG", strFormItemXML);
        return ctrlNode;
    }

    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITOR");
        if (dgModeDetail != null) {
            ctrlNode.SetValue("OBJECT", dgModeDetail.getDGCOLEDITORCUSTOM());
        } else {
            ctrlNode.SetValue("OBJECT", iDEFHelper.getDEField().getDGCOLEDITORCUSTOM());
        }
        if (iDEFHelper.GetFormCtrl().IsAllowEmpty()) {
            ctrlNode.SetValue("EMPTYENABLE", "TRUE");
        } else {
            ctrlNode.SetValue("EMPTYENABLE", "FALSE");
        }
        return ctrlNode;
    }
}

