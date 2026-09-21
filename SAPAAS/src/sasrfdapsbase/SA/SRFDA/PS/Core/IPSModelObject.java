/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFDA.PS.Core.IPSModelInfo;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFramework.DataEx.BaseDataEntity;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSModelObject
extends IPSObject,
net.ibizsys.pscore.srv.util.IPSModelObject {
    public static final String MODELTYPE_RUNTIME = "RUNTIME";
    public static final int SCRIPTMODE_DISABLED = 0;
    public static final int SCRIPTMODE_RAWSCRIPT = 1;
    public static final int SCRIPTMODE_MODELRTSCRIPT = 2;

    public String getModelType();

    public BaseDataEntity getModelData();

    public IPSModel getPSModel();

    public int check() throws Exception;

    public IPSDynaModel getPSDynaModel();

    public String getUserTag();

    public String getUserTag2();

    public String getModelName();

    public String getUserTag3();

    public String getUserTag4();

    public String getUserCat();

    public String getModelId();

    public String getModelType(String var1);

    public String getModelId(String var1);

    public String getModelName(String var1);

    public Class<?> getModelClass(String var1);

    public String getFullModelName();

    public boolean isAutoModel();

    public String getDeployId();

    public String getModelInterface();

    public IPSModelObject getParentModel();

    public IPSModelObject getScopeModel();

    public IPSModelInfo getPSModelInfo(String var1);

    public Iterator<IPSModelInfo> getPSModelInfos();

    public String getFullName();

    public ObjectNode getModel();

    public ObjectNode toModel(String var1);

    public ObjectNode getModelRef();

    public ObjectNode toModelRef(String var1);

    public String getCodeName();

    public String getDumpModelType();

    public String getPSDynaInstId();

    public String getModelRefId();

    public String getDynaModelFilePath();

    public ObjectNode getRuntimeModel();

    public String getMOSFilePath();

    public String getRTMOSFilePath();

    public String getWiki();

    @Override
    public String getId();

    @Override
    public String getMemo();

    @Override
    public String getName();
}

