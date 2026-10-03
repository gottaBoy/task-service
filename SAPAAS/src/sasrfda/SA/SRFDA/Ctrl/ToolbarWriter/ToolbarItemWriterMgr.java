/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class ToolbarItemWriterMgr
extends XMLCollectionExConfig<ToolbarItemWriterConfig> {
    protected Hashtable<String, IToolbarItemWriter> toolbarWriterMap = new Hashtable();
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    protected GlobalHelperEx globalHelperEx = null;

    static {
        childNodeMap.put("SRFDATOOLBARITEMWRITER", ToolbarItemWriterConfig.class.getName());
    }

    public void setGlobalHelperEx(GlobalHelperEx globalHelperEx) {
        this.globalHelperEx = globalHelperEx;
    }

    public IToolbarItemWriter FindToolbarItemWriter(String strToolbarItemStyle) {
        return this.InternalFindToolbarItemWriter(strToolbarItemStyle);
    }

    protected IToolbarItemWriter InternalFindToolbarItemWriter(String strToolbarItemStyle) {
        String strToolbarWriterKey = strToolbarItemStyle = strToolbarItemStyle.toUpperCase();
        if (this.toolbarWriterMap.containsKey(strToolbarWriterKey)) {
            return this.toolbarWriterMap.get(strToolbarWriterKey);
        }
        for (ToolbarItemWriterConfig formCtrlWriterConfig : this.arr) {
            if (StringHelper.Compare((String)strToolbarItemStyle, (String)formCtrlWriterConfig.getID(), (boolean)true) != 0) continue;
            String strObject = formCtrlWriterConfig.getObject();
            if (!StringHelper.IsNullOrEmpty((String)strObject)) {
                Object obj = ObjectHelper.Create((String)strObject);
                if (obj == null) {
                    return null;
                }
                if (obj instanceof IToolbarItemWriter) {
                    IToolbarItemWriter IToolbarHelper = (IToolbarItemWriter)obj;
                    IToolbarHelper.Init(formCtrlWriterConfig, this.globalHelperEx);
                    this.toolbarWriterMap.put(strToolbarWriterKey, IToolbarHelper);
                    return (IToolbarItemWriter)obj;
                }
            }
            return null;
        }
        return null;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = ToolbarItemWriterMgr.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((ToolbarItemWriterConfig)childNode)) {
                this.add((ToolbarItemWriterConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

