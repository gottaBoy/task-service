/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;

public class DatePickerExWriter
extends BaseFormCtrlWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATEPICKEREX");
        ctrlNode.SetValue("DAYENABLE", this.formCtrlHelperConfig.GetExtValue("DAYENABLE", ""));
        ctrlNode.SetValue("HOURENABLE", this.formCtrlHelperConfig.GetExtValue("HOURENABLE", ""));
        ctrlNode.SetValue("MINUTEENABLE", this.formCtrlHelperConfig.GetExtValue("MINUTEENABLE", ""));
        ctrlNode.SetValue("SECONDENABLE", this.formCtrlHelperConfig.GetExtValue("SECONDENABLE", ""));
        return ctrlNode;
    }

    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITOR");
        ctrlNode.SetValue("OBJECT", "SA.SRFDA.Ctrl.DataGrid.DateColumnEditor");
        TreeMap<String, String> ctrlParams = new TreeMap<String, String>();
        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getDGItem().GetEditorParam(dgModeDetail))) {
            try {
                Properties properties = PropertiesHelper.Load((String)iDEFHelper.getDGItem().GetEditorParam(dgModeDetail));
                Enumeration<Object> en = properties.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    ctrlParams.put(strKey.toUpperCase(), strValue);
                }
            }
            catch (Exception ex) {
                return null;
            }
        }
        if (ctrlParams.containsKey("DAYENABLE")) {
            ctrlNode.SetValue("DAYENABLE", (String)ctrlParams.get("DAYENABLE"));
        } else {
            ctrlNode.SetValue("DAYENABLE", this.formCtrlHelperConfig.GetExtValue("DAYENABLE", ""));
        }
        if (ctrlParams.containsKey("HOURENABLE")) {
            ctrlNode.SetValue("HOURENABLE", (String)ctrlParams.get("HOURENABLE"));
        } else {
            ctrlNode.SetValue("HOURENABLE", this.formCtrlHelperConfig.GetExtValue("HOURENABLE", ""));
        }
        if (ctrlParams.containsKey("MINUTEENABLE")) {
            ctrlNode.SetValue("MINUTEENABLE", (String)ctrlParams.get("MINUTEENABLE"));
        } else {
            ctrlNode.SetValue("MINUTEENABLE", this.formCtrlHelperConfig.GetExtValue("MINUTEENABLE", ""));
        }
        if (ctrlParams.containsKey("SECONDENABLE")) {
            ctrlNode.SetValue("SECONDENABLE", (String)ctrlParams.get("SECONDENABLE"));
        } else {
            ctrlNode.SetValue("SECONDENABLE", this.formCtrlHelperConfig.GetExtValue("SECONDENABLE", ""));
        }
        return ctrlNode;
    }
}

