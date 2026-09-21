/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.IDAValueFunc;
import SA.SRFDA.Model.ValueFuncConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.TreeMap;
import java.util.Vector;
import org.w3c.dom.Node;

public class ValueFuncMgr
extends XMLCollectionExConfig<ValueFuncConfig> {
    protected TreeMap<String, IDAValueFunc> valueFuncMap = new TreeMap();
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFDAVALUEFUNC", ValueFuncConfig.class.getName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IDAValueFunc FindFunc(String strFunc) {
        TreeMap<String, IDAValueFunc> treeMap = this.valueFuncMap;
        synchronized (treeMap) {
            return this.InternalFindFunc(strFunc, "", "");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IDAValueFunc FindFunc(String strFunc, String strDBType) {
        TreeMap<String, IDAValueFunc> treeMap = this.valueFuncMap;
        synchronized (treeMap) {
            return this.InternalFindFunc(strFunc, strDBType, "");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IDAValueFunc FindFunc(String strFunc, String strDBType, String strDataType) {
        TreeMap<String, IDAValueFunc> treeMap = this.valueFuncMap;
        synchronized (treeMap) {
            return this.InternalFindFunc(strFunc, strDBType, strDataType);
        }
    }

    protected IDAValueFunc InternalFindFunc(String strFunc, String strDBType, String strDataType) {
        String strKey = "";
        if (!StringHelper.IsNullOrEmpty((String)strDataType) && !StringHelper.IsNullOrEmpty((String)strDBType) ? this.valueFuncMap.containsKey(strKey = StringHelper.Format((String)"%1$s.%2$s.%3$s", (Object)strFunc, (Object)strDBType, (Object)strDataType).toUpperCase()) : (!StringHelper.IsNullOrEmpty((String)strDBType) ? this.valueFuncMap.containsKey(strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)strFunc, (Object)strDBType).toUpperCase()) : this.valueFuncMap.containsKey(strKey = strFunc.toUpperCase()))) {
            return this.valueFuncMap.get(strKey);
        }
        for (ValueFuncConfig valueFuncConfig : this.arr) {
            if (StringHelper.Compare((String)strFunc, (String)valueFuncConfig.getID(), (boolean)true) != 0) continue;
            String strObject = "";
            if (!StringHelper.IsNullOrEmpty((String)strDataType) && !StringHelper.IsNullOrEmpty((String)strDBType)) {
                strObject = valueFuncConfig.GetExtValue(StringHelper.Format((String)"OBJECT.%1$s.%2$s", (Object)strDBType, (Object)strDataType), "");
            }
            if (StringHelper.IsNullOrEmpty((String)strObject) && !StringHelper.IsNullOrEmpty((String)strDBType)) {
                strObject = valueFuncConfig.GetExtValue("OBJECT." + strDBType, "");
            }
            if (StringHelper.IsNullOrEmpty((String)strObject)) {
                strObject = valueFuncConfig.getObject();
            }
            if (!StringHelper.IsNullOrEmpty((String)strObject)) {
                Object obj = ObjectHelper.Create((String)strObject);
                if (obj == null) {
                    return null;
                }
                if (obj instanceof IDAValueFunc) {
                    IDAValueFunc iDAValueFunc = (IDAValueFunc)obj;
                    iDAValueFunc.Init(valueFuncConfig);
                    this.valueFuncMap.put(strKey, iDAValueFunc);
                    return (IDAValueFunc)obj;
                }
            }
            return null;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Vector<ValueFuncConfig> FindFuncsByDataType(String strDataType) {
        Vector<ValueFuncConfig> arrs = new Vector<ValueFuncConfig>();
        TreeMap<String, IDAValueFunc> treeMap = this.valueFuncMap;
        synchronized (treeMap) {
            for (ValueFuncConfig valueFuncConfig : this.arr) {
                IDAValueFunc iDAValueFunc = this.InternalFindFunc(valueFuncConfig.getID(), "", "");
                if (iDAValueFunc == null || !StringHelper.IsNullOrEmpty((String)strDataType) && !iDAValueFunc.IsSupportDataType(strDataType)) continue;
                arrs.add(valueFuncConfig);
            }
        }
        return arrs;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = ValueFuncMgr.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((ValueFuncConfig)childNode))) {
                this.add((Object)((ValueFuncConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

