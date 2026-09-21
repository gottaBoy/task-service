/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.QueryGroupItemConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class QueryGroupModelConfig
extends XMLCollectionExConfig<QueryGroupItemConfig> {
    public static final String TAG_TOPCOUNT = "TOPCOUNT";
    public static final String TAG_AQUERYGROUPMODEL = "SRFDAQUERYGROUPMODEL";
    public static final String TAG_GROUPCOND = "GROUPCOND";
    protected int nTopCount = 0;
    protected String strGroupCond = "";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFDAQUERYGROUPITEM", QueryGroupItemConfig.class.getName());
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TOPCOUNT, (boolean)true) == 0) {
            this.setTopCount(QueryGroupModelConfig.GetValue((String)strValue, (int)this.getTopCount()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUPCOND, (boolean)true) == 0) {
            this.setGroupCond(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getTopCount() {
        return this.nTopCount;
    }

    public void setTopCount(int topCount) {
        this.nTopCount = topCount;
        if (this.nTopCount < 0) {
            this.nTopCount = 0;
        }
    }

    public String getGroupCond() {
        return this.strGroupCond;
    }

    public void setGroupCond(String strGroupCond) {
        this.strGroupCond = strGroupCond;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = QueryGroupModelConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((QueryGroupItemConfig)childNode))) {
                this.add((Object)((QueryGroupItemConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

