package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public class JSON2DataEntity extends BaseTransformer {
    public JSON2DataEntity() {
    }

    protected Object doTransform(Object object, String encoding) {
        if (object instanceof byte[]) {
            String charset = GetConfig(TAG_ENCODING, encoding == null ? "UTF-8" : encoding);
            try {
                object = Charset.forName(charset).newDecoder()
                        .onMalformedInput(CodingErrorAction.REPORT)
                        .onUnmappableCharacter(CodingErrorAction.REPORT)
                        .decode(ByteBuffer.wrap((byte[])object)).toString();
            } catch (CharacterCodingException ex) {
                throw new IllegalArgumentException("Invalid JSON bytes for encoding " + charset, ex);
            }
        }
        if (!(object instanceof String)) {
            throw new IllegalArgumentException("Expected JSON String or byte[], got "
                    + (object == null ? "null" : object.getClass().getName()));
        }
        return BaseDataEntity.FromJSONString((String)object);
    }
}
