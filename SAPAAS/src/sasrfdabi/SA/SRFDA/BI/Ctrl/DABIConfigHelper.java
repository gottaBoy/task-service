/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAConfigHelper
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBICubeDataCtrl;
import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBICubeDimensionDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.BI.Ctrl.Data.BIDimensionRef;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BIReport;
import SA.SRFDA.BI.Ctrl.IBILevelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepDMHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.BI.Ctrl.IDABIConfigHelper;
import SA.SRFDA.Ctrl.BaseDAConfigHelper;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DABIConfigHelper
extends BaseDAConfigHelper
implements IDABIConfigHelper {
    private static final Log log = LogFactory.getLog(DABIConfigHelper.class);

    @Override
    public String GetBIReportSPExConfigId(BIReport biReport) {
        String strSPExConfigId = StringHelper.Format((String)"BI%1$s.SPEX_%2$s_%3$s_%4$s", (Object)biReport.getBICATALOGID(), (Object)biReport.getCLVERSION(), (Object)biReport.getBIREPORTID(), (Object)biReport.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strSPExConfigId = strSPExConfigId.toUpperCase();
        String strSPExFilePath = ConfigPathHelper.GetRuntimeSPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strSPExConfigId);
        File file = new File(strSPExFilePath);
        if (file.exists()) {
            return strSPExConfigId;
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXSPEX");
        XMLNode dpNode = new XMLNode();
        dpNode.setNodeName("SRFEXDP");
        rootNode.AddNode(dpNode);
        IBICubeDataCtrl cubeDataCtrl = (IBICubeDataCtrl)this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("BI0001", "SYSTEM", null);
        if (cubeDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0001"));
            return "";
        }
        Vector<BICubeDimension> biCubeDimensions = new Vector<BICubeDimension>();
        CallResult callResult = cubeDataCtrl.ListBICubeDimensions(biReport.getBICUBEID(), biCubeDimensions);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u591a\u7ef4\u5206\u6790\u7acb\u65b9\u4f53\u7ef4\u5ea6\u5931\u8d25\uff0c%2$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        XMLNode dpPageGroupNode = new XMLNode();
        dpPageGroupNode.setNodeName("SRFEXDPPAGEGROUP");
        dpPageGroupNode.SetValue("CAPTION", "\u67e5\u8be2\u6761\u4ef6");
        dpNode.AddNode(dpPageGroupNode);
        IBICubeDimensionDataCtrl biCubeDimensionDataCtrl = (IBICubeDimensionDataCtrl)this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("BI0002", "SYSTEM", null);
        if (biCubeDimensionDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0002"));
            return "";
        }
        IDEDataCtrl biDimensionRefDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("BI0004", "SYSTEM", null);
        if (biDimensionRefDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0004"));
            return "";
        }
        for (BICubeDimension biCubeDimension : biCubeDimensions) {
            String strCaption;
            BICubeDimension realCubeDimension = null;
            if (StringHelper.Compare((String)biCubeDimension.getBICUBEDIMENSIONTYPE(), (String)"REF", (boolean)true) == 0) {
                BIDimensionRef biDimensionRef = new BIDimensionRef();
                biDimensionRef.setBIDIMENSIONREFID(biCubeDimension.getBICUBEDIMENSIONID());
                callResult = biDimensionRefDataCtrl.Get((BaseDataEntity)biDimensionRef);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u591a\u7ef4\u5206\u6790\u7acb\u65b9\u4f53\u5f15\u7528\u7ef4\u5ea6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)biCubeDimension.getBICUBEDIMENSIONID(), (Object)callResult.getErrorInfo()));
                    return "";
                }
                realCubeDimension = new BICubeDimension();
                realCubeDimension.setBICUBEDIMENSIONID(biDimensionRef.getBIDIMENSIONID());
                callResult = biCubeDimensionDataCtrl.Get(realCubeDimension);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u591a\u7ef4\u5206\u6790\u7acb\u65b9\u4f53\u7ef4\u5ea6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)biCubeDimension.getBICUBEDIMENSIONID(), (Object)callResult.getErrorInfo()));
                    return "";
                }
            } else {
                realCubeDimension = biCubeDimension;
            }
            if (StringHelper.IsNullOrEmpty((String)(strCaption = realCubeDimension.getCAPTION()))) {
                strCaption = realCubeDimension.getBICUBEDIMENSIONNAME();
            }
            XMLNode dpCommonGroupNode = new XMLNode();
            dpCommonGroupNode.setNodeName("SRFEXDPGROUP");
            dpCommonGroupNode.SetValue("SHOWCAPTION", "TRUE");
            dpCommonGroupNode.SetValue("CAPTION", strCaption);
            dpCommonGroupNode.SetValue("COLUMNS", "460;*");
            dpCommonGroupNode.SetValue("EXPANDER", "EXPAND");
            dpPageGroupNode.AddNode(dpCommonGroupNode);
            Properties properties = null;
            if (!StringHelper.IsNullOrEmpty((String)realCubeDimension.getQUERYCTRLPARAM())) {
                try {
                    properties = PropertiesHelper.Load((String)realCubeDimension.getQUERYCTRLPARAM());
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            XMLNode dpFormItem = new XMLNode();
            dpFormItem.setNodeName("SRFEXDPFORMITEM");
            dpCommonGroupNode.AddNode(dpFormItem);
            Vector<BIHierarchy> biHierarchies = new Vector<BIHierarchy>();
            callResult = biCubeDimensionDataCtrl.ListBIHierarchies(biCubeDimension, biHierarchies);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u591a\u7ef4\u5206\u6790\u7acb\u65b9\u4f53\u7ef4\u5ea6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return "";
            }
            String strHRCList = "";
            for (BIHierarchy biHierarchy : biHierarchies) {
                if (!StringHelper.IsNullOrEmpty((String)strHRCList)) {
                    strHRCList = String.valueOf(strHRCList) + ";";
                }
                strHRCList = String.valueOf(strHRCList) + StringHelper.Format((String)"%1$s|%2$s", (Object)biHierarchy.getBIHIERARCHYNAME(), (Object)biHierarchy.getBIHIERARCHYID());
            }
            XMLNode dpUserControlItem = new XMLNode();
            dpUserControlItem.setNodeName("SRFEXUSERCONTROLEX");
            dpUserControlItem.setID(biCubeDimension.getBICUBEDIMENSIONID());
            dpUserControlItem.SetValue("WIDTH", PropertiesHelper.GetProperty((Properties)properties, (String)"WIDTH", (String)"450"));
            dpUserControlItem.SetValue("BICUBEDIMENSIONID", biCubeDimension.getBICUBEDIMENSIONID());
            dpUserControlItem.SetValue("BIHIERARCHY", strHRCList);
            if (StringHelper.IsNullOrEmpty((String)realCubeDimension.getQUERYCTRL()) || StringHelper.Compare((String)realCubeDimension.getQUERYCTRL(), (String)"AUTO", (boolean)true) == 0) {
                dpUserControlItem.SetValue("HEIGHT", PropertiesHelper.GetProperty((Properties)properties, (String)"HEIGHT", (String)"200"));
                dpUserControlItem.SetValue("CONFIG", "SA.SRFDA.BI.Web.UI.BIDimensionSelectorConfig");
            } else if (StringHelper.Compare((String)realCubeDimension.getQUERYCTRL(), (String)"AUTOTD", (boolean)true) == 0) {
                dpUserControlItem.SetValue("HEIGHT", PropertiesHelper.GetProperty((Properties)properties, (String)"HEIGHT", (String)"150"));
                dpUserControlItem.SetValue("CONFIG", "SA.SRFDA.BI.Web.UI.BITDSelectorConfig");
            } else {
                dpUserControlItem.SetValue("HEIGHT", PropertiesHelper.GetProperty((Properties)properties, (String)"HEIGHT", (String)"200"));
                dpUserControlItem.SetValue("CONFIG", realCubeDimension.getCUSTOMQUERYCTRL());
            }
            dpFormItem.AddNode(dpUserControlItem);
            XMLNode formItemNode = new XMLNode();
            formItemNode.setNodeName("SRFEXFORMITEM");
            formItemNode.SetValue("MAXLENGTH", "655360");
            formItemNode.SetValue("DATATYPE", "TEXT");
            formItemNode.SetValue("NAME", biCubeDimension.getBICUBEDIMENSIONNAME());
            dpUserControlItem.AddNode(formItemNode);
            dpFormItem = new XMLNode();
            dpFormItem.setNodeName("SRFEXDPRAWITEM");
            dpCommonGroupNode.AddNode(dpFormItem);
            StringBuilderEx content = new StringBuilderEx();
            content.Append("<div>");
            content.Append("<div class=\"x-box-tl\"><div class=\"x-box-tr\"><div class=\"x-box-tc\"></div></div></div>");
            content.Append("<div class=\"x-box-ml\"><div class=\"x-box-mr\"><div class=\"x-box-mc\"><span class='sx-normaltext'>");
            content.Append(realCubeDimension.getDESCRIPTION());
            content.Append("</span></div></div></div>");
            content.Append(" <div class=\"x-box-bl\"><div class=\"x-box-br\"><div class=\"x-box-bc\"></div></div></div>");
            content.Append("</div>");
            dpFormItem.SetValue("CONTENT", content.toString());
        }
        if (!DABIConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strSPExFilePath)) {
            return "";
        }
        return strSPExConfigId;
    }

    @Override
    public String GetBIReportExSPExConfigId(IBIReportExHelper iBIReportExHelper) throws Exception {
        String strSPExConfigId = StringHelper.Format((String)"BICUBE.SPEX_%2$s_%3$s_%4$s", (Object)iBIReportExHelper.getBICube().getId(), (Object)iBIReportExHelper.getBICube().getVersion(), (Object)iBIReportExHelper.getId(), (Object)iBIReportExHelper.getVersion());
        if (!StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            strSPExConfigId = String.valueOf(strSPExConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.strLanguage);
        }
        strSPExConfigId = strSPExConfigId.toUpperCase();
        String strSPExFilePath = ConfigPathHelper.GetRuntimeSPConfigPath((String)this.globalHelperEx.GetAppRootPath(), (String)strSPExConfigId);
        File file = new File(strSPExFilePath);
        if (file.exists()) {
            return strSPExConfigId;
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXSPEX");
        XMLNode dpNode = new XMLNode();
        dpNode.setNodeName("SRFEXDP");
        rootNode.AddNode(dpNode);
        dpNode.SetValue("HIDETABHEADER", "TRUE");
        XMLNode dpPageGroupNode = new XMLNode();
        dpPageGroupNode.setNodeName("SRFEXDPPAGEGROUP");
        dpPageGroupNode.SetValue("CAPTION", "\u67e5\u8be2\u6761\u4ef6");
        dpNode.AddNode(dpPageGroupNode);
        Vector<IBIRepDMHelper> filterList = new Vector<IBIRepDMHelper>();
        for (IBIRepDMHelper iBIRepDMHelper : iBIReportExHelper.getDimensions()) {
            if (!iBIRepDMHelper.isEnableFilter()) continue;
            boolean bAdd = false;
            int i = 0;
            while (i < filterList.size()) {
                IBIRepDMHelper tempDMHelper = (IBIRepDMHelper)filterList.get(i);
                if (iBIRepDMHelper.getFilterPos() < tempDMHelper.getFilterPos()) {
                    bAdd = true;
                    filterList.add(i, iBIRepDMHelper);
                    break;
                }
                ++i;
            }
            if (bAdd) continue;
            filterList.add(iBIRepDMHelper);
        }
        XMLNode dpCommonGroupNode = new XMLNode();
        dpCommonGroupNode.setNodeName("SRFEXDPGROUP");
        dpCommonGroupNode.SetValue("SHOWCAPTION", "TRUE");
        dpCommonGroupNode.SetValue("SHOWCAPTION", "FALSE");
        dpCommonGroupNode.SetValue("COLUMNS", "33%;34%;33%");
        dpCommonGroupNode.SetValue("EXPANDER", "EXPAND");
        dpPageGroupNode.AddNode(dpCommonGroupNode);
        for (IBIRepDMHelper iBIRepDMHelper : filterList) {
            XMLNode dpFormItem = new XMLNode();
            dpFormItem.setNodeName("SRFEXDPFORMITEM");
            dpFormItem.SetValue("CAPTION", iBIRepDMHelper.getBIHierarchy().getLogicName());
            dpFormItem.SetValue("CAPTIONWIDTH", "100");
            dpCommonGroupNode.AddNode(dpFormItem);
            XMLNode dpUserControlItem = new XMLNode();
            dpUserControlItem.setNodeName("SRFEXUSERCONTROLEX");
            dpUserControlItem.setID(iBIRepDMHelper.getBIHierarchy().getUniqueName());
            dpUserControlItem.SetValue("PLACETYPE", iBIRepDMHelper.getPlaceType());
            String strLevels = "";
            for (IBILevelHelper biLevelHelper : iBIRepDMHelper.getBIHierarchy().getBILevels()) {
                if (!StringHelper.IsNullOrEmpty((String)strLevels)) {
                    strLevels = String.valueOf(strLevels) + ";";
                }
                strLevels = String.valueOf(strLevels) + StringHelper.Format((String)"%1$s|%2$s", (Object)biLevelHelper.getName(), (Object)biLevelHelper.getLogicName());
            }
            dpUserControlItem.SetValue("BILEVELS", strLevels);
            dpUserControlItem.SetValue("ALLCAPTION", iBIRepDMHelper.getBIHierarchy().getAllCaption());
            String strFilterType = iBIRepDMHelper.getBIHierarchy().getFilterType();
            if (StringHelper.IsNullOrEmpty((String)strFilterType) || StringHelper.Compare((String)strFilterType, (String)"AUTO", (boolean)true) == 0) {
                dpUserControlItem.SetValue("CONFIG", "SA.SRFDA.BI.Web.UI.BIHierarchySelectorConfig");
                dpUserControlItem.SetValue("DATAURL", StringHelper.Format((String)"../srfbi/birepexdmdatabackend.jsp?SRFBIREPORTEXID=%1$s&BIHIERARCHYID=%2$s", (Object)iBIReportExHelper.getId(), (Object)iBIRepDMHelper.getBIHierarchy().getId()));
            } else if (StringHelper.Compare((String)strFilterType, (String)"AUTOTD", (boolean)true) == 0) {
                dpUserControlItem.SetValue("CONFIG", "SA.SRFDA.BI.Web.UI.BIHierarchySelectorConfig");
                dpUserControlItem.SetValue("DATAURL", StringHelper.Format((String)"../srfbi/birepexdmdatabackend.jsp?SRFBIREPORTEXID=%1$s&BIHIERARCHYID=%2$s", (Object)iBIReportExHelper.getId(), (Object)iBIRepDMHelper.getBIHierarchy().getId()));
            } else {
                dpUserControlItem.SetValue("CONFIG", iBIRepDMHelper.getBIHierarchy().getCustomFilter());
            }
            dpFormItem.AddNode(dpUserControlItem);
            XMLNode formItemNode = new XMLNode();
            formItemNode.setNodeName("SRFEXFORMITEM");
            formItemNode.SetValue("MAXLENGTH", "655360");
            formItemNode.SetValue("DATATYPE", "TEXT");
            dpUserControlItem.AddNode(formItemNode);
        }
        if (!DABIConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strSPExFilePath)) {
            return "";
        }
        return strSPExConfigId;
    }
}

