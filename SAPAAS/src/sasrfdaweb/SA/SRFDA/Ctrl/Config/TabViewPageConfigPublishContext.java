/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublishContext;
import SA.SRFDA.Ctrl.DAConfigPublishContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Hashtable;
import java.util.Vector;

public class TabViewPageConfigPublishContext
extends DAConfigPublishContext
implements ITabViewPageConfigPublishContext {
    private Object param = null;
    private Hashtable<String, Vector<XMLNode>> groupNodeListMap = new Hashtable();
    private Hashtable<String, XMLNode> groupMap = new Hashtable();
    private Hashtable<String, String> groupNameMap = new Hashtable();
    private Vector<XMLNode> groupList = new Vector();
    private String strCaption = "";
    private String strGroupId = "";
    private String strTabViewPageId = "";

    @Override
    public Object getParam() {
        return this.param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    @Override
    public void RegisterTabViewPageGroup(String strGroupId, XMLNode groupNode, int nOrder) {
        if (this.groupMap.containsKey(strGroupId)) {
            return;
        }
        groupNode.SetValue("GROUPORDER", StringHelper.Format((String)"%1$s", (Object)nOrder));
        this.groupMap.put(strGroupId, groupNode);
        String strGroupName = groupNode.GetExtValue("GROUP", "");
        this.groupNameMap.put(strGroupId, strGroupName);
        boolean bExist = false;
        int nInsertPos = -1;
        int nCount = this.groupList.size();
        int i = 0;
        while (i < nCount) {
            XMLNode item = this.groupList.get(i);
            String strItemGroupName = item.GetExtValue("GROUP", "");
            if (StringHelper.Compare((String)strItemGroupName, (String)strGroupName, (boolean)true) == 0) {
                bExist = true;
                break;
            }
            int nPos = item.GetExtValue("GROUPORDER", 0);
            if (nOrder < nPos) {
                nInsertPos = i;
                break;
            }
            ++i;
        }
        if (!bExist) {
            if (nInsertPos == -1) {
                this.groupList.add(groupNode);
            } else {
                this.groupList.add(nInsertPos, groupNode);
            }
        }
    }

    @Override
    public void AddTabViewPageNode(XMLNode tabViewPageNode, String strGroupId, int nOrder) {
        String strGroupName = this.groupNameMap.get(strGroupId);
        if (StringHelper.IsNullOrEmpty((String)strGroupName)) {
            strGroupName = this.groupNameMap.get("");
        }
        Vector<XMLNode> tabViewPageNodes = null;
        if (this.groupNodeListMap.containsKey(strGroupName)) {
            tabViewPageNodes = this.groupNodeListMap.get(strGroupName);
        } else {
            tabViewPageNodes = new Vector<XMLNode>();
            this.groupNodeListMap.put(strGroupName, tabViewPageNodes);
        }
        tabViewPageNode.SetValue("PAGEORDER", StringHelper.Format((String)"%1$s", (Object)nOrder));
        int nInsertPos = -1;
        int nCount = tabViewPageNodes.size();
        int i = 0;
        while (i < nCount) {
            XMLNode item = tabViewPageNodes.get(i);
            int nPos = item.GetExtValue("PAGEORDER", 0);
            if (nOrder < nPos) {
                nInsertPos = i;
                break;
            }
            ++i;
        }
        if (nInsertPos == -1) {
            tabViewPageNodes.add(tabViewPageNode);
        } else {
            tabViewPageNodes.add(nInsertPos, tabViewPageNode);
        }
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    public String getGroupId() {
        return this.strGroupId;
    }

    public void setGroupId(String strGroupId) {
        this.strGroupId = strGroupId;
    }

    @Override
    public String getTabViewPageId() {
        return this.strTabViewPageId;
    }

    public void setTabViewPageId(String strTabViewPageId) {
        this.strTabViewPageId = strTabViewPageId;
    }

    public void ExportTabViewPageNodes(XMLNode rootNode) {
        for (XMLNode groupNode : this.groupList) {
            String strGroupName = groupNode.GetExtValue("GROUP", "");
            String strGroupIcon = groupNode.GetExtValue("GROUPICON", "");
            boolean bCollapse = groupNode.GetExtValue("ISCOLLAPSE", false);
            boolean bFirstNode = true;
            Vector<XMLNode> sectionNodes = this.groupNodeListMap.get(strGroupName);
            if (sectionNodes == null || sectionNodes.size() == 0) continue;
            for (XMLNode tabViewPageNode : sectionNodes) {
                tabViewPageNode.SetValue("GROUP", strGroupName);
                if (bFirstNode) {
                    tabViewPageNode.SetValue("GROUPICON", strGroupIcon);
                    tabViewPageNode.SetValue("ISCOLLAPSE", bCollapse ? "TRUE" : "FALSE");
                    bFirstNode = false;
                }
                rootNode.AddNode(tabViewPageNode);
            }
        }
    }
}
