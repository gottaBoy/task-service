/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAConfigHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IDPConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IDPConfigPublisherContext;
import SA.SRFDA.Ctrl.Config.IDPConfigPublisherPlugin;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;

public class DemoDPConfigPublisherPlugin
implements IDPConfigPublisherPlugin {
    @Override
    public void Publish(IDPConfigPublisherContext iDPConfigPublisherContext, IDPConfigPublishContext iPublishContext, String strParam, XMLNode rootNode, XMLNode curNode) throws Exception {
        BaseDataEntity data = iPublishContext.getActiveData();
        String strCaption = "";
        strCaption = data == null ? "\u672a\u77e5\u72b6\u6001" : (StringHelper.IsNullOrEmpty((String)strParam) ? data.GetParamStringValue("MAINSTATE", "") : data.GetParamStringValue(strParam, ""));
        curNode.setNodeName("SRFEXDPGROUP");
        curNode.SetValue("SHOWCAPTION", "TRUE");
        curNode.SetValue("CAPTION", "\u81ea\u5b9a\u4e49\u914d\u7f6e\u63d2\u4ef6");
        curNode.SetValue("COLUMNS", "50%;50%");
        int i = 0;
        while (i < 500) {
            XMLNode dpDFormItem = new XMLNode();
            dpDFormItem.setNodeName("SRFEXDPFORMITEM");
            dpDFormItem.SetValue("CAPTION", StringHelper.Format((String)"%2$s%1$s", (Object)i, (Object)strCaption));
            dpDFormItem.SetValue("ALLOWEMPTY", "TRUE");
            curNode.AddNode(dpDFormItem);
            XMLNode textBox = new XMLNode();
            textBox.setNodeName("SRFEXTEXTBOX");
            textBox.setID(StringHelper.Format((String)"DENAME%1$s", (Object)i));
            dpDFormItem.AddNode(textBox);
            XMLNode formItem = new XMLNode();
            formItem.setNodeName("SRFEXFORMITEM");
            formItem.SetValue("MAXLENGTH", "100");
            formItem.SetValue("ITEMFORMAT", "%1$s");
            formItem.SetValue("ALLOWEMPTY", "TRUE");
            formItem.SetValue("NAME", StringHelper.Format((String)"%2$s%1$s", (Object)i, (Object)strCaption));
            textBox.AddNode(formItem);
            ++i;
        }
    }

    public CallResult Process(IDAConfigHelper iDAConfigHelper, IDEHelper iDEHelper, Object objConfig, String strParam, XMLNode rootNode, XMLNode curNode) {
        curNode.setNodeName("SRFEXDPGROUP");
        curNode.SetValue("SHOWCAPTION", "TRUE");
        curNode.SetValue("CAPTION", "\u81ea\u5b9a\u4e49\u914d\u7f6e\u63d2\u4ef6");
        curNode.SetValue("COLUMNS", "50%;50%");
        int i = 0;
        while (i < 50) {
            XMLNode dpDFormItem = new XMLNode();
            dpDFormItem.setNodeName("SRFEXDPFORMITEM");
            dpDFormItem.SetValue("CAPTION", StringHelper.Format((String)"\u5b9e\u4f53\u540d\u79f0%1$s", (Object)i));
            dpDFormItem.SetValue("ALLOWEMPTY", "TRUE");
            curNode.AddNode(dpDFormItem);
            XMLNode textBox = new XMLNode();
            textBox.setNodeName("SRFEXTEXTBOX");
            textBox.setID(StringHelper.Format((String)"DENAME%1$s", (Object)i));
            dpDFormItem.AddNode(textBox);
            XMLNode formItem = new XMLNode();
            formItem.setNodeName("SRFEXFORMITEM");
            formItem.SetValue("MAXLENGTH", "100");
            formItem.SetValue("ITEMFORMAT", "%1$s");
            formItem.SetValue("ALLOWEMPTY", "TRUE");
            formItem.SetValue("NAME", StringHelper.Format((String)"\u5b9e\u4f53\u540d\u79f0%1$s", (Object)i));
            textBox.AddNode(formItem);
            ++i;
        }
        return new CallResult();
    }
}

