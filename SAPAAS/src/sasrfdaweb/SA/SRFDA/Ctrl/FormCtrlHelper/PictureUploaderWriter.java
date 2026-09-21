/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;

public class PictureUploaderWriter
extends BaseFormCtrlWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXPICTUREUPLOADER");
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        return ctrlNode;
    }
}

