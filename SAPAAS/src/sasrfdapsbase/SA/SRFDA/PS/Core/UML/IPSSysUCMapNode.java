/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSUMLObject;
import SA.SRFDA.PS.Data.PSSysUCMapNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysUCMapNode
extends IPSModelObject,
IPSUMLObject {
    public static final String NODETYPE_USECASE = "USECASE";
    public static final String NODETYPE_ACTOR = "ACTOR";

    public void init(ISRFDAGlobalHelper var1, IPSSysUCMap var2, PSSysUCMapNode var3) throws Exception;

    public IPSSysUCMap getPSSysUCMap();

    public String getNodeType();

    public IPSSysActor getPSSysActor() throws Exception;

    public IPSSysUseCase getPSSysUseCase() throws Exception;

    public int getLeftPos();

    public int getTopPos();
}

