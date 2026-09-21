/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIScheme;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysEAIScheme
extends IPSEAIScheme,
IPSSystemObject,
IPSSysSFPubObject {
    public Iterator<? extends IPSSysEAIDataType> getAllPSSysEAIDataTypes() throws Exception;

    public IPSSysEAIDataType getPSSysEAIDataType(String var1) throws Exception;

    public IPSSysEAIDataType getPSSysEAIDataType(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysEAIElement> getAllPSSysEAIElements() throws Exception;

    public IPSSysEAIElement getPSSysEAIElement(String var1) throws Exception;

    public IPSSysEAIElement getPSSysEAIElement(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysEAIDE> getAllPSSysEAIDEs() throws Exception;

    public IPSSysEAIDE getPSSysEAIDE(String var1) throws Exception;

    public IPSSysEAIDE getPSSysEAIDE(String var1, boolean var2) throws Exception;

    public IPSSystemModule getPSSystemModule();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();
}

