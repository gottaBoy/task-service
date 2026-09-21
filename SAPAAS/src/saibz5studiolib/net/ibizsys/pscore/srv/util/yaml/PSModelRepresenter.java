/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.demodel.IDEFieldModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.yaml.snakeyaml.comments.CommentLine
 *  org.yaml.snakeyaml.comments.CommentType
 *  org.yaml.snakeyaml.nodes.MappingNode
 *  org.yaml.snakeyaml.nodes.Node
 *  org.yaml.snakeyaml.nodes.NodeTuple
 *  org.yaml.snakeyaml.nodes.ScalarNode
 *  org.yaml.snakeyaml.representer.Representer
 */
package net.ibizsys.pscore.srv.util.yaml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.representer.Representer;

public class PSModelRepresenter
extends Representer {
    private static final Log log = LogFactory.getLog(PSModelRepresenter.class);
    private IDataEntityModel iDataEntityModel;

    public IDataEntityModel getDEModel() {
        return this.iDataEntityModel;
    }

    public void setDEModel(IDataEntityModel iDataEntityModel) {
        this.iDataEntityModel = iDataEntityModel;
    }

    public Node represent(Object object) {
        Node node = super.represent(object);
        if (this.getDEModel() != null) {
            Object object2;
            String string;
            Object object3;
            String string2;
            Object object4;
            ArrayList<Iterator<Object>> arrayList;
            Object object5;
            if (node != null) {
                // empty if block
            }
            LinkedHashMap<String, IPSDEFieldModel> linkedHashMap = new LinkedHashMap<String, IPSDEFieldModel>();
            Iterator iterator = null;
            try {
                iterator = this.getDEModel().getDEFields();
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
            if (iterator != null) {
                while (iterator.hasNext()) {
                    object5 = (IPSDEFieldModel)iterator.next();
                    if (object5.isKeyDEField() || !object5.isPhisicalDEField() || object5.getUserInputMode() == 0 || object5.getName().equalsIgnoreCase("PSSYSTEMID") || object5.getName().equalsIgnoreCase("PSSYSTEMNAME") || !StringHelper.isNullOrEmpty((String)object5.getUserTag()) && ("IGNOREMODELV2".equals(object5.getUserTag()) || "RESERVEMODELV2".equals(object5.getUserTag()))) continue;
                    linkedHashMap.put(object5.getName(), (IPSDEFieldModel)object5);
                }
            }
            linkedHashMap.remove("PSDEVSLNID");
            linkedHashMap.remove("PSDEVSLNNAME");
            linkedHashMap.remove("PSDEVCENTERID");
            linkedHashMap.remove("PSDEVCENTERNAME");
            linkedHashMap.remove("PSDEVSLNSYSID");
            linkedHashMap.remove("PSDEVSLNSYSNAME");
            linkedHashMap.remove("ENABLE");
            linkedHashMap.remove("CREATEMAN");
            linkedHashMap.remove("UPDATEMAN");
            linkedHashMap.remove("CREATEDATE");
            linkedHashMap.remove("UPDATEDATE");
            if (node instanceof MappingNode && (arrayList = (object5 = (MappingNode)node).getValue()) != null) {
                for (NodeTuple object6 : arrayList) {
                    ArrayList<Object> n;
                    block28: {
                        if (!(object6.getKeyNode() instanceof ScalarNode)) continue;
                        object4 = (ScalarNode)object6.getKeyNode();
                        string2 = object4.getValue();
                        object3 = null;
                        try {
                            object3 = (IDEFieldModel)this.getDEModel().getDEField(string2, true);
                        }
                        catch (Exception exception) {
                            log.error((Object)exception);
                        }
                        n = new ArrayList<Object>();
                        if (object3 != null) {
                            linkedHashMap.remove(object3.getName());
                            string = object3.getLogicName();
                            if (!StringHelper.isNullOrEmpty((String)object3.getMemo())) {
                                string = string + "\uff0c";
                                string = string + object3.getMemo();
                            }
                            object2 = new CommentLine(null, null, "\n#" + string, CommentType.BLOCK);
                            n.add(object2);
                            if (!StringHelper.isNullOrEmpty((String)object3.getCodeListId())) {
                                try {
                                    string = CodeListGlobal.getCodeList((String)object3.getCodeListId(), (boolean)true);
                                    if (string == null || (object2 = string.getCodeItems()) == null) break block28;
                                    int n2 = 0;
                                    while (object2.hasNext()) {
                                        ICodeItem iCodeItem;
                                        if (n2 >= 20) {
                                            iCodeItem = new CommentLine(null, null, "  ..., \u4ec5\u8f93\u51fa\u524d20\u9879\uff0c\u66f4\u591a\u8bf7\u67e5\u770b\u6587\u6863\u8bf4\u660e", CommentType.BLOCK);
                                            n.add(iCodeItem);
                                            break;
                                        }
                                        iCodeItem = (ICodeItem)object2.next();
                                        String string3 = String.format("  %1$s(%2$s)", iCodeItem.getText(), iCodeItem.getValue());
                                        if (!StringHelper.isNullOrEmpty((String)iCodeItem.getUserData())) {
                                            string3 = string3 + "\uff0c";
                                            string3 = string3 + iCodeItem.getUserData();
                                        }
                                        CommentLine commentLine = new CommentLine(null, null, string3, CommentType.BLOCK);
                                        n.add(commentLine);
                                        ++n2;
                                    }
                                }
                                catch (Exception exception) {
                                    log.error((Object)exception);
                                }
                            }
                        }
                    }
                    if (n.size() <= 0) continue;
                    object6.getKeyNode().setBlockComments(n);
                }
            }
            if (linkedHashMap.size() > 0) {
                object5 = new StringBuilder();
                arrayList = new ArrayList<Iterator<Object>>();
                ((StringBuilder)object5).append("");
                ((StringBuilder)object5).append("\n#\u4ee5\u4e0b\u4e3a\u652f\u6301\u914d\u7f6e\u5c5e\u6027");
                ((StringBuilder)object5).append("\n");
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    block29: {
                        object4 = (IPSDEFieldModel)entry.getValue();
                        string2 = object4.getLogicName();
                        if (!StringHelper.isNullOrEmpty((String)object4.getMemo())) {
                            string2 = string2 + "\uff0c";
                            string2 = string2 + object4.getMemo();
                        }
                        ((StringBuilder)object5).append(String.format("\n\n#%1$s", string2));
                        if (!StringHelper.isNullOrEmpty((String)object4.getCodeListId())) {
                            try {
                                string2 = CodeListGlobal.getCodeList((String)object4.getCodeListId(), (boolean)true);
                                if (string2 == null || (object3 = string2.getCodeItems()) == null) break block29;
                                int n = 0;
                                while (object3.hasNext()) {
                                    if (n >= 20) {
                                        ((StringBuilder)object5).append(String.format("\n#%1$s", "  ..., \u4ec5\u8f93\u51fa\u524d20\u9879\uff0c\u66f4\u591a\u8bf7\u67e5\u770b\u6587\u6863\u8bf4\u660e"));
                                        break;
                                    }
                                    string = (ICodeItem)object3.next();
                                    object2 = String.format("  %1$s(%2$s)", string.getText(), string.getValue());
                                    if (!StringHelper.isNullOrEmpty((String)string.getUserData())) {
                                        object2 = (String)object2 + "\uff0c";
                                        object2 = (String)object2 + string.getUserData();
                                    }
                                    ((StringBuilder)object5).append(String.format("\n#%1$s", object2));
                                }
                            }
                            catch (Exception exception) {
                                log.error((Object)exception);
                            }
                        }
                    }
                    if (StringHelper.isNullOrEmpty((String)(string2 = object4.getCodeName()))) {
                        string2 = object4.getName();
                    }
                    ((StringBuilder)object5).append(String.format("\n#%1$s: ", string2).toLowerCase());
                }
                Iterator<Object> iterator2 = new CommentLine(null, null, ((StringBuilder)object5).toString(), CommentType.BLOCK);
                arrayList.add(iterator2);
                node.setEndComments(arrayList);
            }
        }
        return node;
    }
}

