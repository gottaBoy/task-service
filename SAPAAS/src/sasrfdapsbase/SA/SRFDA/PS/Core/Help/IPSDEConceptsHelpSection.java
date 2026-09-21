/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSDEConceptHelpSection;
import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDEConceptsHelpSection
extends IPSHelpSection {
    public Iterator<IPSDEConceptHelpSection> getPSDEConceptHelpSections();
}

