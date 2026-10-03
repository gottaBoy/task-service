/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.FormCtrlHelper.FormCtrlWriterConfig;
import SA.SRFDA.Ctrl.FormCtrlHelper.IFormCtrlWriter;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class FormCtrlWriterMgr
extends XMLCollectionExConfig<FormCtrlWriterConfig> {
    protected Hashtable<String, IFormCtrlWriter> defHelperMap = new Hashtable();
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    protected GlobalHelperEx globalHelperEx = null;

    static {
        childNodeMap.put("SRFDAFROMCTRLWRITER", FormCtrlWriterConfig.class.getName());
        childNodeMap.put("SRFDAFORMCTRLWRITER", FormCtrlWriterConfig.class.getName());
    }

    public void setGlobalHelperEx(GlobalHelperEx globalHelperEx) {
        this.globalHelperEx = globalHelperEx;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IFormCtrlWriter FindFormCtrlWriter(String strFormCtrlStyle, String strPageModel, String strLanguage) {
        Hashtable<String, IFormCtrlWriter> hashtable = this.defHelperMap;
        synchronized (hashtable) {
            return this.InternalFindFormCtrlWriter(strFormCtrlStyle, strPageModel, strLanguage);
        }
    }

    protected IFormCtrlWriter InternalFindFormCtrlWriter(String strFormCtrlStyle, String strPageModel, String strLanguage) {
        String strFormCtrlWriterKey = strFormCtrlStyle = strFormCtrlStyle.toUpperCase();
        if (!StringHelper.IsNullOrEmpty((String)strPageModel)) {
            strFormCtrlWriterKey = String.valueOf(strFormCtrlWriterKey) + ".PM_" + strPageModel;
        }
        if (!StringHelper.IsNullOrEmpty((String)strLanguage)) {
            strFormCtrlWriterKey = String.valueOf(strFormCtrlWriterKey) + ".LAN_" + strLanguage;
        }
        if (this.defHelperMap.containsKey(strFormCtrlWriterKey)) {
            return this.defHelperMap.get(strFormCtrlWriterKey);
        }
        for (FormCtrlWriterConfig formCtrlWriterConfig : this.arr) {
            if (StringHelper.Compare((String)strFormCtrlStyle, (String)formCtrlWriterConfig.getID(), (boolean)true) != 0) continue;
            String strObject = formCtrlWriterConfig.getObject();
            if (!StringHelper.IsNullOrEmpty((String)strObject)) {
                Object obj = ObjectHelper.Create((String)strObject);
                if (obj == null) {
                    return null;
                }
                if (obj instanceof IFormCtrlWriter) {
                    IFormCtrlWriter IFormCtrlHelper = (IFormCtrlWriter)obj;
                    IFormCtrlHelper.Init(formCtrlWriterConfig, this.globalHelperEx, strPageModel, strLanguage);
                    this.defHelperMap.put(strFormCtrlWriterKey, IFormCtrlHelper);
                    return (IFormCtrlWriter)obj;
                }
            }
            return null;
        }
        return null;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = FormCtrlWriterMgr.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((FormCtrlWriterConfig)childNode)) {
                this.add((FormCtrlWriterConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

