package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Map;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;

public class DataEntityUpdater extends BaseTransformer {
    public static final String TAG_UPDATE = "UPDATE";

    protected Object doTransform(Object object, String encoding) throws TransformerException {
        if (!(object instanceof Map)) {
            throw new TransformerException(MessageFactory.createStaticMessage("Expected Map with entity update"));
        }
        Map payload = (Map)object;
        String key = GetConfig(TAG_UPDATE, TAG_UPDATE);
        BaseDataEntity update = TransformerHelper.GetDataEntity(this, payload.get(key));
        return TransformerHelper.GetPayload(this, payload, update);
    }
}
