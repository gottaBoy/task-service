/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6620\u5c04\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMapDetail", implement="PSDEMapDetailImpl")
public interface IPSDEMapField
extends IPSDEMapObject {
    public static final String SRCTYPE_FIELD = "FIELD";
    public static final String SRCTYPE_VALUE = "VALUE";
    public static final String MAPTYPE_FIELD = "FIELD";
    public static final String MAPTYPE_VALUE = "VALUE";
    public static final String MAPTYPE_EXPRESSION = "EXPRESSION";
    public static final String MAPTYPE_VALUE_SRC = "VALUE_SRC";
    public static final String MAPTYPE_EXPRESSION_SRC = "EXPRESSION_SRC";

    @Deprecated
    public String getSrcType();

    public IPSDEField getSrcPSDEField();

    public IPSDEField getDstPSDEField();

    @Deprecated
    public String getSrcValue();

    public String getDstFieldName();

    public String getSrcFieldName();

    public String getMapType();

    public String getRawValue();

    public String getExpression();

    public IPSSysTranslator getPSSysTranslator();
}

