/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseListFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CheckBoxListWriter
extends BaseListFormCtrlWriter {
    private static final Log log = LogFactory.getLog(CheckBoxListWriter.class);

    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXCHECKBOXLIST");
        String strCodeList = CheckBoxListWriter.GetFormCtrlCodeList(iDEFHelper, iDEMAFieldHelper, formCtrlConfig);
        if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
            CodeListConfig codeListConfig = this.globalHelperEx.getCodeListMgr().GetCodeListConfig(strCodeList, this.strLanguage);
            if (codeListConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)strCodeList));
                return null;
            }
            if (codeListConfig.getNumberOrMode()) {
                ctrlNode.SetValue("NUMBERORMODE", "TRUE");
            } else {
                ctrlNode.SetValue("SEPARATOR", codeListConfig.getValueSeperator());
            }
        }
        if (ctrlNode != null) {
            CheckBoxListWriter.AppendListFillterNode(this.strLanguage, iDEFHelper, formCtrlConfig, ctrlNode, bSearchMode, ctrlParams);
        }
        return ctrlNode;
    }
}

