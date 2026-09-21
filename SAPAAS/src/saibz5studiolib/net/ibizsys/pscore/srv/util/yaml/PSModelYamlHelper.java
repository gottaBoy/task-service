/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.yaml.snakeyaml.DumperOptions
 *  org.yaml.snakeyaml.DumperOptions$FlowStyle
 *  org.yaml.snakeyaml.Yaml
 *  org.yaml.snakeyaml.representer.Representer
 */
package net.ibizsys.pscore.srv.util.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.util.yaml.PSModelRepresenter;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.representer.Representer;

public class PSModelYamlHelper {
    private static ObjectMapper MAPPER = new ObjectMapper();

    public static String exportModel(IDataEntityModel iDataEntityModel, IEntity iEntity, ObjectNode objectNode) throws Exception {
        Map map = (Map)MAPPER.readValue(objectNode.toString(), Map.class);
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setProcessComments(true);
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        PSModelRepresenter pSModelRepresenter = new PSModelRepresenter();
        pSModelRepresenter.setDEModel(iDataEntityModel);
        Yaml yaml = new Yaml((Representer)pSModelRepresenter, dumperOptions);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = iDataEntityModel.getDEFields();
        if (iterator != null) {
            while (iterator.hasNext()) {
                IPSDEFieldModel iPSDEFieldModel = (IPSDEFieldModel)iterator.next();
                if (!map.containsKey(iPSDEFieldModel.getName().toLowerCase())) continue;
                Object v = map.remove(iPSDEFieldModel.getName().toLowerCase());
                if (!StringHelper.isNullOrEmpty((String)iPSDEFieldModel.getUserTag()) && ("IGNOREMODELV2".equals(iPSDEFieldModel.getUserTag()) || "RESERVEMODELV2".equals(iPSDEFieldModel.getUserTag()))) continue;
                String string = iPSDEFieldModel.getCodeName();
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = iPSDEFieldModel.getName();
                }
                linkedHashMap.put(string.toLowerCase(), v);
            }
        }
        linkedHashMap.putAll(map);
        return yaml.dump(linkedHashMap);
    }

    public static ObjectNode importModel(IDataEntityModel iDataEntityModel, IEntity iEntity, String string) throws Exception {
        Yaml yaml = new Yaml();
        Object object = yaml.load(string);
        return (ObjectNode)JsonNodeHelper.fromString((String)MAPPER.writeValueAsString(object));
    }

    public static String exportModel(ObjectNode objectNode) throws Exception {
        Map map = (Map)MAPPER.readValue(objectNode.toString(), Map.class);
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(dumperOptions);
        return yaml.dump((Object)map);
    }

    public static ObjectNode importModel(String string) throws Exception {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(dumperOptions);
        Object object = yaml.load(string);
        return (ObjectNode)JsonNodeHelper.fromString((String)MAPPER.writeValueAsString(object));
    }
}

