package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import java.util.Map;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;
import org.mule.transport.NullPayload;

public class TransformerHelper {
    public static String GetString(BaseTransformer transformer, Object object, String encoding) throws TransformerException {
        if (object instanceof String) {
            return (String)object;
        }
        byte[] bytes;
        if (object instanceof byte[]) {
            bytes = (byte[])object;
        } else if (object instanceof InputStream) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            try {
                int count;
                while ((count = ((InputStream)object).read(buffer)) != -1) {
                    output.write(buffer, 0, count);
                }
            } catch (IOException ex) {
                throw failure("Cannot read string payload", ex);
            }
            bytes = output.toByteArray();
        } else {
            throw invalidType(object, "String, byte[] or InputStream");
        }
        String fallback = encoding == null || encoding.length() == 0 ? "UTF-8" : encoding;
        String charset = transformer == null ? fallback : transformer.GetConfig(BaseTransformer.TAG_ENCODING, fallback);
        try {
            return Charset.forName(charset).newDecoder()
                    .onMalformedInput(CodingErrorAction.REPORT)
                    .onUnmappableCharacter(CodingErrorAction.REPORT)
                    .decode(ByteBuffer.wrap(bytes)).toString();
        } catch (IllegalArgumentException ex) {
            throw failure("Invalid payload encoding: " + charset, ex);
        } catch (CharacterCodingException ex) {
            throw failure("Cannot decode string payload as " + charset, ex);
        }
    }

    public static BaseDataEntity GetDataEntity(BaseTransformer transformer, Object object) throws TransformerException {
        if (object instanceof BaseDataEntity) {
            return (BaseDataEntity)object;
        }
        if (object instanceof NullPayload) {
            return new BaseDataEntity();
        }
        if (object instanceof Map) {
            BaseDataEntity entity = new BaseDataEntity();
            try {
                entity.FromMap((Map)object);
            } catch (Exception ex) {
                throw failure("Cannot convert map payload to BaseDataEntity", ex);
            }
            return entity;
        }
        throw invalidType(object, "BaseDataEntity, Map or NullPayload");
    }

    public static Map GetMap(BaseTransformer transformer, Object object) throws TransformerException {
        if (object instanceof Map) {
            return (Map)object;
        }
        if (object instanceof BaseDataEntity) {
            Map map = new HashMap();
            ((BaseDataEntity)object).FillMap(map);
            return map;
        }
        throw invalidType(object, "Map or BaseDataEntity");
    }

    public static Map GetPayload(BaseTransformer transformer, Object object, BaseDataEntity entity) throws TransformerException {
        if (entity == null) {
            throw invalidType(null, "BaseDataEntity update");
        }
        Map payload;
        if (object instanceof Map) {
            payload = (Map)object;
        } else if (object instanceof BaseDataEntity) {
            payload = new HashMap();
            ((BaseDataEntity)object).FillMap(payload);
        } else if (object instanceof NullPayload) {
            payload = new HashMap();
        } else {
            throw invalidType(object, "Map, BaseDataEntity or NullPayload");
        }
        // Preserve the original fields, then let the update win on duplicate keys.
        try {
            entity.FillMap(payload);
        } catch (UnsupportedOperationException ex) {
            throw failure("Cannot update read-only map payload", ex);
        }
        return payload;
    }

    private static TransformerException invalidType(Object object, String expected) {
        String actual = object == null ? "null" : object.getClass().getName();
        return new TransformerException(MessageFactory.createStaticMessage("Expected " + expected + ", got " + actual));
    }

    private static TransformerException failure(String message, Exception cause) {
        return new TransformerException(MessageFactory.createStaticMessage(message), cause);
    }
}
