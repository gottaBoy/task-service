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
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDEField;
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
            LinkedHashMap<String, IPSDEFieldModel> linkedHashMap = new LinkedHashMap<String, IPSDEFieldModel>();
            Iterator<IDEField> iterator = null;
            try {
                iterator = this.getDEModel().getDEFields();
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
            if (iterator != null) {
                while (iterator.hasNext()) {
                    IPSDEFieldModel field = (IPSDEFieldModel)iterator.next();
                    if (field.isKeyDEField() || !field.isPhisicalDEField() || field.getUserInputMode() == 0 || field.getName().equalsIgnoreCase("PSSYSTEMID") || field.getName().equalsIgnoreCase("PSSYSTEMNAME") || !StringHelper.isNullOrEmpty(field.getUserTag()) && ("IGNOREMODELV2".equals(field.getUserTag()) || "RESERVEMODELV2".equals(field.getUserTag()))) continue;
                    linkedHashMap.put(field.getName(), field);
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
            if (node instanceof MappingNode && ((MappingNode)node).getValue() != null) {
                for (NodeTuple tuple : ((MappingNode)node).getValue()) {
                    if (!(tuple.getKeyNode() instanceof ScalarNode)) continue;
                    String name = ((ScalarNode)tuple.getKeyNode()).getValue();
                    IDEFieldModel field = null;
                    try {
                        field = (IDEFieldModel)this.getDEModel().getDEField(name, true);
                    }
                    catch (Exception exception) {
                        log.error((Object)exception);
                    }
                    if (field == null) continue;
                    linkedHashMap.remove(field.getName());
                    List<CommentLine> comments = new ArrayList<CommentLine>();
                    String description = field.getLogicName();
                    if (!StringHelper.isNullOrEmpty(field.getMemo())) {
                        description += "\uff0c" + field.getMemo();
                    }
                    comments.add(new CommentLine(null, null, "\n#" + description, CommentType.BLOCK));
                    if (!StringHelper.isNullOrEmpty(field.getCodeListId())) {
                        try {
                            ICodeList codeList = CodeListGlobal.getCodeList(field.getCodeListId(), true);
                            Iterator<ICodeItem> codeItems = codeList == null ? null : codeList.getCodeItems();
                            if (codeItems != null) {
                                int count = 0;
                                while (codeItems.hasNext()) {
                                    if (count >= 20) {
                                        comments.add(new CommentLine(null, null, "  ..., \u4ec5\u8f93\u51fa\u524d20\u9879\uff0c\u66f4\u591a\u8bf7\u67e5\u770b\u6587\u6863\u8bf4\u660e", CommentType.BLOCK));
                                        break;
                                    }
                                    ICodeItem codeItem = codeItems.next();
                                    String label = String.format("  %1$s(%2$s)", codeItem.getText(), codeItem.getValue());
                                    if (!StringHelper.isNullOrEmpty(codeItem.getUserData())) {
                                        label += "\uff0c" + codeItem.getUserData();
                                    }
                                    comments.add(new CommentLine(null, null, label, CommentType.BLOCK));
                                    ++count;
                                }
                            }
                        }
                        catch (Exception exception) {
                            log.error((Object)exception);
                        }
                    }
                    tuple.getKeyNode().setBlockComments(comments);
                }
            }
            if (linkedHashMap.size() > 0) {
                StringBuilder details = new StringBuilder("\n#\u4ee5\u4e0b\u4e3a\u652f\u6301\u914d\u7f6e\u5c5e\u6027\n");
                for (Map.Entry<String, IPSDEFieldModel> entry : linkedHashMap.entrySet()) {
                    IPSDEFieldModel field = entry.getValue();
                    String description = field.getLogicName();
                    if (!StringHelper.isNullOrEmpty(field.getMemo())) {
                        description += "\uff0c" + field.getMemo();
                    }
                    details.append(String.format("\n\n#%1$s", description));
                    if (!StringHelper.isNullOrEmpty(field.getCodeListId())) {
                        try {
                            ICodeList codeList = CodeListGlobal.getCodeList(field.getCodeListId(), true);
                            Iterator<ICodeItem> codeItems = codeList == null ? null : codeList.getCodeItems();
                            if (codeItems != null) {
                                int count = 0;
                                while (codeItems.hasNext()) {
                                    if (count >= 20) {
                                        details.append(String.format("\n#%1$s", "  ..., \u4ec5\u8f93\u51fa\u524d20\u9879\uff0c\u66f4\u591a\u8bf7\u67e5\u770b\u6587\u6863\u8bf4\u660e"));
                                        break;
                                    }
                                    ICodeItem codeItem = codeItems.next();
                                    String label = String.format("  %1$s(%2$s)", codeItem.getText(), codeItem.getValue());
                                    if (!StringHelper.isNullOrEmpty(codeItem.getUserData())) {
                                        label += "\uff0c" + codeItem.getUserData();
                                    }
                                    details.append(String.format("\n#%1$s", label));
                                    ++count;
                                }
                            }
                        }
                        catch (Exception exception) {
                            log.error((Object)exception);
                        }
                    }
                    String codeName = field.getCodeName();
                    if (StringHelper.isNullOrEmpty(codeName)) {
                        codeName = field.getName();
                    }
                    details.append(String.format("\n#%1$s: ", codeName).toLowerCase());
                }
                List<CommentLine> comments = new ArrayList<CommentLine>();
                comments.add(new CommentLine(null, null, details.toString(), CommentType.BLOCK));
                node.setEndComments(comments);
            }
        }
        return node;
    }
}
