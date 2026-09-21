/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDAMBConfigHelperContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDAMBConfigHelperContext;
import SA.SRFDA.Mobile.Ctrl.BaseDAMBConfigHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAMBConfigHelper
extends BaseDAMBConfigHelper {
    private static final Log log = LogFactory.getLog(DAMBConfigHelper.class);

    public String GetMBListPanelListConfigId(IDAMBConfigHelperContext context) throws Exception {
        String strListConfigId = StringHelper.Format((String)"DE%1$s.MBLIST_%2$s_%3$s%4$s", (Object)context.getDEHelper().getId(), (Object)context.getDEHelper().getVersion(), (Object)context.getMBList().getMBLISTID(), (Object)context.getMBList().getVERSION());
        if (context.getMBPanel() != null) {
            strListConfigId = String.valueOf(strListConfigId) + StringHelper.Format((String)"_%1$s_%2$s", (Object)context.getMBPanel().getMBPANELID(), (Object)context.getMBPanel().getVERSION());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            strListConfigId = String.valueOf(strListConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.getLanguage());
        }
        strListConfigId = strListConfigId.toUpperCase();
        String strDGFilePath = DAMBConfigHelper.GetRuntimeMBListConfigPath(this.getGlobalHelper().GetAppRootPath(), strListConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strListConfigId;
        }
        XMLNode rootNode = this.GetMBListPanelListConfig(context);
        DAMBConfigHelper.ExportConfigFile(rootNode, strDGFilePath);
        return strListConfigId;
    }

    protected XMLNode GetMBListPanelListConfig(IDAMBConfigHelperContext context) throws Exception {
        Hashtable<String, Object> extParams = new Hashtable<String, Object>();
        return this.GetMBListConfig(context, extParams);
    }

    public String GetMBListConfigId(IDAMBConfigHelperContext context) throws Exception {
        String strListConfigId = StringHelper.Format((String)"DE%1$s.MBLIST_%2$s_%3$s%4$s", (Object)context.getDEHelper().getId(), (Object)context.getDEHelper().getVersion(), (Object)context.getMBList().getMBLISTID(), (Object)context.getMBList().getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            strListConfigId = String.valueOf(strListConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.getLanguage());
        }
        strListConfigId = strListConfigId.toUpperCase();
        String strDGFilePath = DAMBConfigHelper.GetRuntimeMBListConfigPath(this.getGlobalHelper().GetAppRootPath(), strListConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strListConfigId;
        }
        XMLNode rootNode = this.GetMBListConfig(context, new Hashtable<String, Object>());
        DAMBConfigHelper.ExportConfigFile(rootNode, strDGFilePath);
        return strListConfigId;
    }

    protected XMLNode GetMBListConfig(IDAMBConfigHelperContext context, Hashtable<String, Object> extParams) throws Exception {
        Hashtable<String, String> dsItemMap = new Hashtable<String, String>();
        String strDSItems = context.getMBList().getDSITEMS();
        if (!StringHelper.IsNullOrEmpty((String)strDSItems)) {
            strDSItems = String.valueOf(strDSItems) + ";";
            strDSItems = String.valueOf(strDSItems) + context.getDEHelper().GetKeyDEFHelper().getName();
            strDSItems = String.valueOf(strDSItems) + ";";
            strDSItems = String.valueOf(strDSItems) + context.getDEHelper().GetMajorDEFHelper().getName();
            String[] dsItems = StringHelper.SplitEx((String)strDSItems);
            int i = 0;
            while (i < dsItems.length) {
                String strDSItem = dsItems[i];
                if (!StringHelper.IsNullOrEmpty((String)strDSItem) && !StringHelper.IsNullOrEmpty((String)(strDSItem = strDSItem.trim()))) {
                    strDSItem = strDSItem.toUpperCase();
                    dsItemMap.put(strDSItem, "");
                }
                ++i;
            }
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFDAMBLIST");
        XMLNode dsItemsNode = new XMLNode();
        dsItemsNode.setNodeName("SRFDAMBUIPARTDS");
        rootNode.AddNode(dsItemsNode);
        for (IDEFHelper iDEFHelper : context.getDEHelper().GetDEFHelpers()) {
            XMLNode dsItemNode;
            if (dsItemMap.size() > 0 && !dsItemMap.containsKey(iDEFHelper.getName())) continue;
            if (iDEFHelper.IsKeyDEField()) {
                dsItemNode = new XMLNode();
                dsItemNode.setNodeName("SRFDAMBUIPARTDSITEM");
                dsItemsNode.AddNode(dsItemNode);
                dsItemNode.setID(iDEFHelper.getName());
                dsItemNode.SetValue("ITEMFORMAT", iDEFHelper.getMobileSetting().getItemFormat());
                dsItemNode.SetValue("KEY", "TRUE");
                dsItemNode.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
            }
            if (iDEFHelper.IsMajorDEField()) {
                dsItemNode = new XMLNode();
                dsItemNode.setNodeName("SRFDAMBUIPARTDSITEM");
                dsItemsNode.AddNode(dsItemNode);
                dsItemNode.setID("SRFMAJORTEXT");
                XMLNode dsItemParamsNode = new XMLNode();
                dsItemParamsNode.setNodeName("SRFEXITEMPARAMS");
                dsItemNode.AddNode(dsItemParamsNode);
                XMLNode dsItemParamNode = new XMLNode();
                dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                dsItemParamsNode.AddNode(dsItemParamNode);
                dsItemParamNode.setID(iDEFHelper.getName());
                dsItemParamNode.SetValue("ITEMFORMAT", iDEFHelper.getMobileSetting().getItemFormat());
            }
            boolean bAppendCodeList = false;
            XMLNode dsItemNode2 = new XMLNode();
            dsItemNode2.setNodeName("SRFDAMBUIPARTDSITEM");
            dsItemsNode.AddNode(dsItemNode2);
            dsItemNode2.setID(iDEFHelper.getName());
            if (iDEFHelper.IsEnableDEFieldPriv()) {
                dsItemNode2.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
            }
            dsItemNode2.SetValue("ITEMFORMAT", iDEFHelper.getMobileSetting().getItemFormat());
            dsItemNode2.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
            String strCodeList = iDEFHelper.GetCodeList();
            if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
                bAppendCodeList = true;
            }
            if (!bAppendCodeList) continue;
            dsItemNode2 = new XMLNode();
            dsItemNode2.setNodeName("SRFDAMBUIPARTDSITEM");
            dsItemsNode.AddNode(dsItemNode2);
            dsItemNode2.setID(String.valueOf(iDEFHelper.getName()) + "_CLTEXT");
            if (iDEFHelper.IsEnableDEFieldPriv()) {
                dsItemNode2.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
            }
            dsItemNode2.SetValue("DATATYPE", "VARCHAR");
            XMLNode dsItemParamsNode = new XMLNode();
            dsItemParamsNode.setNodeName("SRFEXITEMPARAMS");
            dsItemNode2.AddNode(dsItemParamsNode);
            XMLNode dsItemParamNode = new XMLNode();
            dsItemParamNode.setNodeName("SRFEXITEMPARAM");
            dsItemParamsNode.AddNode(dsItemParamNode);
            dsItemParamNode.setID(iDEFHelper.getName());
            String strCodeList2 = iDEFHelper.GetCodeList();
            dsItemParamNode.SetValue("CODELIST", strCodeList2);
        }
        return rootNode;
    }
}

