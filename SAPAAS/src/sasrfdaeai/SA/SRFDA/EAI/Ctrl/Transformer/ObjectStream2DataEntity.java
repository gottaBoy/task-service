package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;

public class ObjectStream2DataEntity extends BaseTransformer {
    protected Object doTransform(Object object, String encoding) throws TransformerException {
        String encoded = TransformerHelper.GetString(this, object, encoding);
        try {
            byte[] bytes = Base64.decode(encoded);
            ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(bytes));
            Object countObject = stream.readObject();
            if (!(countObject instanceof Integer) || ((Integer)countObject).intValue() < 0
                    || ((Integer)countObject).intValue() > 100000) {
                throw new IOException("Invalid object stream field count");
            }
            BaseDataEntity entity = new BaseDataEntity();
            int count = ((Integer)countObject).intValue();
            for (int i = 0; i < count; i++) {
                Object key = stream.readObject();
                Object value = stream.readObject();
                if (!(key instanceof String)) {
                    throw new IOException("Invalid object stream field name");
                }
                entity.SetParamValue((String)key, value);
            }
            if (stream.read() != -1) {
                throw new IOException("Trailing object stream data");
            }
            stream.close();
            return entity;
        } catch (IOException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid entity object stream"), ex);
        } catch (ClassNotFoundException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Unknown object stream type"), ex);
        } catch (RuntimeException ex) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid entity object stream"), ex);
        }
    }
}
