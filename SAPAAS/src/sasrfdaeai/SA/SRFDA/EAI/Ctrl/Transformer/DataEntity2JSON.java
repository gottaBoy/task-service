package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DataEntity2JSON extends BaseTransformer {
    public static final String TAG_BUFFER = "BUFFER";

    public DataEntity2JSON() {
    }

    protected Object doTransform(Object object, String encoding) {
        if (!(object instanceof BaseDataEntity)) {
            throw new IllegalArgumentException("Expected BaseDataEntity, got "
                    + (object == null ? "null" : object.getClass().getName()));
        }
        return ((BaseDataEntity)object).ToJSONString();
    }
}
