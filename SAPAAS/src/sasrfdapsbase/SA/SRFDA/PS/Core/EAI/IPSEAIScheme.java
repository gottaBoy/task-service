/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSEAIScheme
extends IPSModelObject {
    @Override
    public String getCodeName();

    public Iterator<? extends IPSEAIDataType> getAllPSEAIDataTypes() throws Exception;

    public IPSEAIDataType getPSEAIDataType(String var1) throws Exception;

    public IPSEAIDataType getPSEAIDataType(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSEAIElement> getAllPSEAIElements() throws Exception;

    public IPSEAIElement getPSEAIElement(String var1) throws Exception;

    public IPSEAIElement getPSEAIElement(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSEAIDE> getAllPSEAIDEs() throws Exception;

    public IPSEAIDE getPSEAIDE(String var1) throws Exception;

    public IPSEAIDE getPSEAIDE(String var1, boolean var2) throws Exception;

    public String getSchemeTag();

    public String getSchemeTag2();
}

