package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.Utility.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;

public class DataEntity2ObjectStream extends BaseTransformer {
    protected Object doTransform(Object object, String encoding) throws TransformerException {
        Map map = TransformerHelper.GetMap(this, object);
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(bytes);
            stream.writeObject(Integer.valueOf(map.size()));
            for (Object key : map.keySet()) {
                if (!(key instanceof String)) {
                    throw new TransformerException(MessageFactory.createStaticMessage("Object stream keys must be strings"));
                }
                stream.writeObject(key);
                stream.writeObject(map.get(key));
            }
            stream.close();
            return Base64.encodeBytes(bytes.toByteArray(), 2);
        } catch (IOException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Cannot serialize entity"), ex);
        }
    }
}
