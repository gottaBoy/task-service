/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  org.yaml.snakeyaml.Yaml
 */
package SA.SRFDA.PS.Core.Pub.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import org.yaml.snakeyaml.Yaml;

public class PSYaml2JsonMethod
implements TemplateMethodModel {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            throw new TemplateModelException("\u4e3a\u4f20\u5165Yaml\u5185\u5bb9");
        }
        Object strValue = arg0.get(0);
        if (strValue == null) {
            return "{}";
        }
        try {
            Yaml yaml = new Yaml();
            Object objMap = yaml.load((String)strValue);
            String strContent = MAPPER.writeValueAsString(objMap);
            ObjectNode objectNode = (ObjectNode)MAPPER.readTree(strContent);
            return objectNode.toString();
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

