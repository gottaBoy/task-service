/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.ControlPanelConfig;
import SA.SRFramework.WebEx.UI.GroupPanelConfig;
import SA.SRFramework.WebEx.UI.HiddenPanelConfig;
import SA.SRFramework.WebEx.UI.PanelConfig;
import SA.SRFramework.WebEx.UI.RemotePanelConfig;
import SA.SRFramework.WebEx.UI.TabPanelConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PanelTemplateConfig
extends BasePanelConfig {
    public static final String TAG_PANEL = "SRFEXPANELTEMPLATE";
    protected Hashtable hashTable = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        strName = strName.toUpperCase();
        this.hashTable.put(strName, xmlNode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean GetPanelConfigs(String strName, ArrayList list, ControlConfigContext controlConfigContext) {
        strName = strName.toUpperCase();
        Node xmlNode = null;
        Object object = this.hashTable;
        synchronized (object) {
            if (this.hashTable.containsKey(strName)) {
                xmlNode = (Node)this.hashTable.get(strName);
            }
        }
        if (xmlNode != null && list != null) {
            object = xmlNode;
            synchronized (object) {
                NodeList nodes = xmlNode.getChildNodes();
                if (nodes != null) {
                    ControlConfigContext tempContext = null;
                    if (controlConfigContext != null) {
                        tempContext = controlConfigContext.Clone();
                        tempContext.setParentUIStyle(controlConfigContext.getCurUIStyle());
                        tempContext.setCurUIStyle(null);
                    }
                    int i = 0;
                    while (i < nodes.getLength()) {
                        Node childNode = nodes.item(i);
                        if (childNode != null) {
                            String strNodeName = childNode.getNodeName().toUpperCase();
                            BasePanelConfig basePanelConfig = null;
                            if (StringHelper.Compare((String)strNodeName, (String)"SRFEXHIDDENPANEL", (boolean)true) == 0) {
                                basePanelConfig = new HiddenPanelConfig();
                            }
                            if (StringHelper.Compare((String)strNodeName, (String)"SRFEXREMOTEPANEL", (boolean)true) == 0) {
                                basePanelConfig = new RemotePanelConfig();
                            }
                            if (StringHelper.Compare((String)strNodeName, (String)"SRFEXPANEL", (boolean)true) == 0) {
                                basePanelConfig = new PanelConfig();
                            }
                            if (StringHelper.Compare((String)strNodeName, (String)"SRFEXGROUPPANEL", (boolean)true) == 0) {
                                basePanelConfig = new GroupPanelConfig();
                            }
                            if (StringHelper.Compare((String)strNodeName, (String)"SRFEXCONTROLPANEL", (boolean)true) == 0) {
                                basePanelConfig = new ControlPanelConfig();
                            }
                            if (StringHelper.Compare((String)strNodeName, (String)"SRFEXTABPANEL", (boolean)true) == 0) {
                                basePanelConfig = new TabPanelConfig();
                            }
                            if (basePanelConfig != null && basePanelConfig.LoadConfig(childNode, controlConfigContext)) {
                                list.add(basePanelConfig);
                                if (controlConfigContext != null) {
                                    controlConfigContext.FromParamList(tempContext.getParamList());
                                }
                            }
                        }
                        ++i;
                    }
                }
                return true;
            }
        }
        return false;
    }
}

