/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;

public class SpanExWriter
extends BaseFormCtrlWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXSPANEX");
        String strCodeList = this.GetFormCtrlCodeList(iDEFHelper, formCtrlConfig);
        if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
            ctrlNode.SetValue("CODELIST", strCodeList);
        }
        return ctrlNode;
    }

    @Override
    protected XMLNode OnAppendFormItemNode(IDEFHelper helper, XMLNode formCtrlConfig, XMLNode ctrlNode) {
        XMLNode formItemNode = super.OnAppendFormItemNode(helper, formCtrlConfig, ctrlNode);
        if (formItemNode != null) {
            formCtrlConfig.SetValue("ALLOWEMPTY", "TRUE");
            formItemNode.SetValue("ALLOWEMPTY", "TRUE");
        }
        return formItemNode;
    }

    @Override
    protected boolean IsAppendFormItemRule() {
        return false;
    }
}

