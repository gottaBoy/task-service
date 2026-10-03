package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.text.ParseException;
import java.util.Map;
import java.util.TreeMap;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;

public class String2DataEntityTransformer extends StringTransformer {
    protected TreeMap<Integer, PackagePart> headerPartMap;
    protected int nHeaderSize;
    protected TreeMap<Integer, PackagePart> contentPartMap;

    protected Object doTransform(Object object, String encoding) throws TransformerException {
        String input = TransformerHelper.GetString(this, object, encoding);
        try {
            headerPartMap = ParseHeaderFormat(GetConfig(TAG_HEADERFORMAT, ""));
            contentPartMap = ParseContentFormat(GetConfig(TAG_CONTENTFORMAT, ""));
            if (headerPartMap.isEmpty() && contentPartMap.isEmpty()) {
                throw new ParseException("Missing HEADERFORMAT and CONTENTFORMAT", 0);
            }
            nHeaderSize = GetHeaderSize(headerPartMap);
            int position = 0;
            BaseDataEntity entity = new BaseDataEntity();
            String fill = GetConfig(TAG_STUFFCHAR, " ");
            if (fill.length() != 1) throw new ParseException("Invalid STUFFCHAR", 0);
            position = read(input, position, headerPartMap, entity, fill.charAt(0));
            String separator = GetConfig(TAG_SEPERATOR, "");
            if (!input.startsWith(separator, position)) {
                throw new ParseException("Missing content separator", position);
            }
            position += separator.length();
            position = read(input, position, contentPartMap, entity, fill.charAt(0));
            if (position != input.length()) throw new ParseException("Trailing input", position);
            return entity;
        } catch (ParseException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid fixed-width entity"), ex);
        }
    }

    private static int read(String input, int position, TreeMap<Integer, PackagePart> parts,
            BaseDataEntity entity, char fill) throws ParseException {
        for (Map.Entry<Integer, PackagePart> entry : parts.entrySet()) {
            PackagePart part = entry.getValue();
            if (part.getSize() > input.length() - position) {
                throw new ParseException("Truncated field: " + part.getName(), position);
            }
            String value = input.substring(position, position + part.getSize());
            String type = part.getDataType();
            if (TAG_DATATYPE_STRING.equalsIgnoreCase(type)
                    || TAG_DATATYPE_NSTRING.equalsIgnoreCase(type)
                    || TAG_DATATYPE_GBSTRING.equalsIgnoreCase(type)) {
                int end = value.length();
                while (end > 0 && value.charAt(end - 1) == fill) end--;
                value = value.substring(0, end);
            }
            entity.SetParamValue(part.getName(), ParseValue(value, part));
            position += part.getSize();
        }
        return position;
    }
}
