package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;

public class DataEntity2Array extends BaseTransformer {
    public static final String TAG_ARRAYSIZE = "ARRAYSIZE";
    public static final String TAG_ITEM = "ITEM";

    protected Object doTransform(Object object, String encoding) throws TransformerException {
        BaseDataEntity entity = TransformerHelper.GetDataEntity(this, object);
        int size = GetConfig(TAG_ARRAYSIZE, -1);
        if (size < 0 || size > 100000) {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid ARRAYSIZE"));
        }
        Object[] values = new Object[size];
        for (int i = 0; i < size; i++) {
            String field = GetConfig(TAG_ITEM + (i + 1), null);
            if (field == null || field.length() == 0) {
                throw new TransformerException(MessageFactory.createStaticMessage("Missing ITEM" + (i + 1)));
            }
            values[i] = entity.GetParamValue(field);
        }
        return values;
    }
}
