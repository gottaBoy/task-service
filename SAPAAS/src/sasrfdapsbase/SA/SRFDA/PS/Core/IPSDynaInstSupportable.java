/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDynaInstSupportable {
    public static final int DYNAINSTMODE_DISABLE = 0;
    public static final int DYNAINSTMODE_ENABLE = 1;
    public static final int DYNAINSTMODE_ENABLEINST = 2;

    public boolean isEnableDynaModel();

    public int getDynaInstMode();

    public String getDynaInstTag();

    public String getDynaInstTag2();

    public String getDynaModelFolder();

    public String getDynaModelFilePath();

    public String getDynaModelTag();

    public boolean isDynaInstModel();
}

