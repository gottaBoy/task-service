/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSUMLObject;
import SA.SRFDA.PS.Data.PSSysUserCaseRS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysUseCaseRS
extends IPSSystemObject,
IPSUMLObject {
    public static final String RSMODE_ACTOR2ACTOR = "ACTOR2ACTOR";
    public static final String RSMODE_USECASE2USECASE = "USECASE2USECASE";
    public static final String RSMODE_ACTOR2USECASE = "ACTOR2USECASE";
    public static final String RSMODE_USECASE2ACTOR = "USECASE2ACTOR";
    public static final String RSTYPE_ASSOCIATION = "ASSOCIATION";
    public static final String RSTYPE_INHERITANCE = "INHERITANCE";
    public static final String RSTYPE_INCLUDE = "INCLUDE";
    public static final String RSTYPE_EXTEND = "EXTEND";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUserCaseRS var3) throws Exception;

    public String getRSMode();

    public String getRSType();

    public IPSSysActor getFromPSSysActor();

    public IPSSysUseCase getFromPSSysUseCase();

    public IPSSysActor getToPSSysActor();

    public IPSSysUseCase getToPSSysUseCase();

    public IPSUMLObject getFromPSUMLObject();

    public IPSUMLObject getToPSUMLObject();

    @Override
    public String getCodeName();

    public String getContent();

    public IPSSystemModule getPSSystemModule();
}

