/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61\u63a5\u53e3", typefield="type", implement="PSDEMethodDTOImpl")
public interface IPSDEMethodDTO
extends IPSDataEntityObject {
    public static final String TYPE_DEFAULT = "DEFAULT";
    public static final String TYPE_DEACTIONINPUT = "DEACTIONINPUT";
    public static final String TYPE_DEFILTER = "DEFILTER";
    public static final String TYPE_LINK = "LINK";
    public static final String TYPE_DEDATASETINPUT = "DEDATASETINPUT";
    public static final String SOURCETYPE_DE = "DE";
    public static final String SOURCETYPE_DYNAMODEL = "DYNAMODEL";
    public static final String SOURCETYPE_REFDE = "REFDE";

    public Iterator<? extends IPSDEMethodDTOField> getPSDEMethodDTOFields();

    public IPSDEFGroup getPSDEFGroup();

    @Override
    public String getCodeName();

    public String getSourceType();

    public IPSSysDynaModel getSrcPSSysDynaModel();

    public IPSSysMethodDTO getSrcPSSysMethodDTO() throws Exception;

    public boolean isDefaultMode();

    public String getType();

    public String getTag();

    public String getTag2();
}

