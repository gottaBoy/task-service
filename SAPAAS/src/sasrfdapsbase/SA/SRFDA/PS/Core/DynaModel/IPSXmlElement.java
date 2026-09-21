/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSXmlNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import org.w3c.dom.Element;

@PSModelPFIgnoreMeta
public interface IPSXmlElement
extends IPSXmlNode {
    public static final String ATTR_ID = "ID";
    public static final String ATTR_NAME = "NAME";

    public Element getXmlElement();

    public String getElementId();
}

