/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseListFormCtrlWriter
extends BaseFormCtrlWriter {
    private static final Log log = LogFactory.getLog(BaseListFormCtrlWriter.class);

    protected static XMLNode AppendListFillterNode(String strLanguage, IDEFHelper iDEFHelper, XMLNode formCtrlConfig, XMLNode ctrlNode, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        IDEMAFieldHelper iDEMAFieldHelper = null;
        try {
            iDEMAFieldHelper = BaseListFormCtrlWriter.GetDEMAField(iDEFHelper, formCtrlConfig);
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u5c5e\u6027\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
            return null;
        }
        return BaseListFormCtrlWriter.AppendListFillterNode(strLanguage, iDEFHelper, iDEMAFieldHelper, formCtrlConfig, ctrlNode, bSearchMode, ctrlParams);
    }

    protected static XMLNode AppendListFillterNode(String strLanguage, IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, XMLNode ctrlNode, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode listFillerNode = new XMLNode();
        listFillerNode.setNodeName("SRFEXLISTFILLER");
        ctrlNode.AddNode(listFillerNode);
        String strCodeList = BaseListFormCtrlWriter.GetFormCtrlCodeList(iDEFHelper, iDEMAFieldHelper, formCtrlConfig);
        boolean bAllowEmpty = BaseListFormCtrlWriter.GetFormCtrlAllowEmpty(iDEFHelper, iDEMAFieldHelper, formCtrlConfig);
        if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
            listFillerNode.SetValue("CODELIST", strCodeList);
            String strCodeListParam = BaseListFormCtrlWriter.GetFormCtrlCodeListParam(iDEFHelper, iDEMAFieldHelper, formCtrlConfig);
            if (!StringHelper.IsNullOrEmpty((String)strCodeListParam)) {
                listFillerNode.SetValue("CODELISTPARAM", strCodeListParam);
            }
            if (bAllowEmpty) {
                String strEmptySupported = "TRUE";
                String strEmptyAtFirst = "TRUE";
                String strEmptyText = "";
                if (ctrlParams != null) {
                    strEmptySupported = BaseListFormCtrlWriter.GetCtrlParam(ctrlParams, "LISTFILLER.EMPTYSUPPORTED", strEmptySupported);
                    strEmptyAtFirst = BaseListFormCtrlWriter.GetCtrlParam(ctrlParams, "LISTFILLER.EMPTYATFIRST", strEmptyAtFirst);
                    String strEmptyTextKey = "LISTFILLER.EMPTYTEXT";
                    if (!StringHelper.IsNullOrEmpty((String)strLanguage)) {
                        strEmptyTextKey = String.valueOf(strEmptyTextKey) + "." + strLanguage;
                    }
                    strEmptyText = BaseListFormCtrlWriter.GetCtrlParam(ctrlParams, strEmptyTextKey, strEmptyText);
                }
                listFillerNode.SetValue("EMPTYSUPPORTED", strEmptySupported);
                listFillerNode.SetValue("EMPTYATFIRST", strEmptyAtFirst);
                listFillerNode.SetValue("EMPTYTEXT", strEmptyText);
            }
        }
        return listFillerNode;
    }
}

