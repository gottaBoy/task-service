/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  freemarker.template.TemplateMethodModel
 *  freemarker.template.TemplateModelException
 *  org.yaml.snakeyaml.DumperOptions
 *  org.yaml.snakeyaml.DumperOptions$FlowStyle
 *  org.yaml.snakeyaml.Yaml
 */
package SA.SRFDA.PS.Core.Pub.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class PSJson2YamlMethod
implements TemplateMethodModel {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Object exec(List arg0) throws TemplateModelException {
        if (arg0.size() == 0) {
            throw new TemplateModelException("\u4e3a\u4f20\u5165Json\u5185\u5bb9");
        }
        Object strValue = arg0.get(0);
        if (strValue == null) {
            return "";
        }
        try {
            Map map = (Map)MAPPER.readValue((String)strValue, Map.class);
            DumperOptions dumperOptions = new DumperOptions();
            dumperOptions.setProcessComments(true);
            dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yaml = new Yaml(dumperOptions);
            return yaml.dump((Object)map);
        }
        catch (Exception e) {
            throw new TemplateModelException(e);
        }
    }
}

