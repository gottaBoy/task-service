/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTOField;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysMethodDTO
extends IPSSystemObject {
    public static final String TYPE_DEFAULT = "DEFAULT";
    public static final String SOURCETYPE_DYNAMODEL = "DYNAMODEL";

    public Iterator<? extends IPSSysMethodDTOField> getPSSysMethodDTOFields();

    public String getType();

    @Override
    public String getCodeName();

    public String getSourceType();

    public IPSSysDynaModel getSrcPSSysDynaModel();

    public IPSSystemModule getPSSystemModule();

    public String getTag();

    public String getTag2();
}

