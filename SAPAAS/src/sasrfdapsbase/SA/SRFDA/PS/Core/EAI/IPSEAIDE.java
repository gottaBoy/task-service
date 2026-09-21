/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.EAI.IPSEAIDEField;
import SA.SRFDA.PS.Core.EAI.IPSEAIDER;
import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSEAIDE
extends IPSModelObject {
    public IPSDataEntity getPSDataEntity();

    @Override
    public String getCodeName();

    public IPSEAIElement getPSEAIElement();

    public Iterator<? extends IPSEAIDEField> getAllPSEAIDEFields() throws Exception;

    public IPSEAIDEField getPSEAIDEField(String var1) throws Exception;

    public IPSEAIDEField getPSEAIDEField(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSEAIDER> getAllPSEAIDERs() throws Exception;

    public IPSEAIDER getPSEAIDER(String var1) throws Exception;

    public IPSEAIDER getPSEAIDER(String var1, boolean var2) throws Exception;

    public String getDETag();

    public String getDETag2();
}

