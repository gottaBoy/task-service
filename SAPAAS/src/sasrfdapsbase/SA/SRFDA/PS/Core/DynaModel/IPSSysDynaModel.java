/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDynaModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="usage", implement="PSSysDynaModelImpl")
public interface IPSSysDynaModel
extends IPSSystemObject,
IPSDynaModel,
IPSModelObject {
    public static final String USAGE_DATA = "DATA";
    public static final String USAGE_JSONSCHEMA = "JSONSCHEMA";
    public static final String USAGE_OPENAPI3SCHEMA = "OPENAPI3SCHEMA";
    public static final String USAGE_LIQUIBASECHANGELOG = "LIQUIBASECHANGELOG";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysDynaModel var3) throws Exception;

    public Iterator<? extends IPSSysDynaModelAttr> getPSSysDynaModelAttrs();

    public boolean isSystemDefault();

    public boolean isModuleDefault();

    public String getContent();

    public String getJOString();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getUsage();

    public String getDTOCodeName();

    public String getModelTag();

    public String getModelTag2();

    public String getModelTag3();

    public String getModelTag4();
}

