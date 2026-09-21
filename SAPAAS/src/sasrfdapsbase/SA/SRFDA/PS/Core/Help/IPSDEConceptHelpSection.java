/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Help.IPSDEFieldHelpSectionBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDEConceptHelpSection
extends IPSDEFieldHelpSectionBase {
    @Override
    public IPSCodeList getPSCodeList();
}

