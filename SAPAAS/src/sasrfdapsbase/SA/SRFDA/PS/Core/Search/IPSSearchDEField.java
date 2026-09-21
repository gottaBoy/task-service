/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Search.IPSSearchDEObject;
import SA.SRFDA.PS.Core.Search.IPSSearchField;

@PSModelPFIgnoreMeta
public interface IPSSearchDEField
extends IPSModelObject,
IPSSearchDEObject {
    public IPSDEField getPSDEField();

    @Override
    public String getCodeName();

    public IPSSearchField getPSSearchField();

    public String getFieldTag();

    public String getFieldTag2();

    public String getDefaultValueType();

    public String getDefaultValue();

    public IPSSysTranslator getPSSysTranslator() throws Exception;

    public String[] getFields();
}

