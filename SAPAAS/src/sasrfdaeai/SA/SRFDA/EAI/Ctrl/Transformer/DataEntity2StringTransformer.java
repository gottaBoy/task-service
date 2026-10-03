package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.text.ParseException;
import java.util.Map;
import java.util.TreeMap;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;

public class DataEntity2StringTransformer extends StringTransformer {
    protected TreeMap<Integer, PackagePart> headerPartMap;
    protected TreeMap<Integer, PackagePart> contentPartMap;

    protected Object doTransform(Object object, String encoding) throws TransformerException {
        BaseDataEntity entity = TransformerHelper.GetDataEntity(this, object);
        try {
            headerPartMap = ParseHeaderFormat(GetConfig(TAG_HEADERFORMAT, ""));
            contentPartMap = ParseContentFormat(GetConfig(TAG_CONTENTFORMAT, ""));
            if (headerPartMap.isEmpty() && contentPartMap.isEmpty()) {
                throw new ParseException("Missing HEADERFORMAT and CONTENTFORMAT", 0);
            }
            String fill = GetConfig(TAG_STUFFCHAR, " ");
            StringBuilder output = new StringBuilder();
            write(entity, headerPartMap, fill, output);
            output.append(GetConfig(TAG_SEPERATOR, ""));
            write(entity, contentPartMap, fill, output);
            return output.toString();
        } catch (ParseException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid fixed-width entity"), ex);
        } catch (IllegalArgumentException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid fixed-width format"), ex);
        }
    }

    private static void write(BaseDataEntity entity, TreeMap<Integer, PackagePart> parts,
            String fill, StringBuilder output) throws ParseException {
        for (Map.Entry<Integer, PackagePart> entry : parts.entrySet()) {
            PackagePart part = entry.getValue();
            String value = GetStringValue(entity, part.getName(), part);
            if (value.length() > part.getSize()) {
                throw new ParseException("Field exceeds width: " + part.getName(), 0);
            }
            output.append(value).append(GetStuff(part.getSize() - value.length(), fill));
        }
    }
}
