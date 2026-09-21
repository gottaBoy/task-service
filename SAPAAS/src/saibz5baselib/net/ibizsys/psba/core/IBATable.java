/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import java.util.Iterator;
import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBASchemeObject;
import net.ibizsys.psba.core.IBATableDE;
import net.ibizsys.psba.core.IBATableDER;

public interface IBATable
extends IBASchemeObject {
    public static final String COLSET_CREATEINFO = "CREATEINFO";
    public static final String COLSET_UPDATEINFO = "UPDATEINFO";
    public static final String COL_CREATEINFO_CREATEDATE = "SRFCREATEDATE";
    public static final String COL_UPDATEINFO_UPDATEDATE = "SRFUPDATEDATE";
    public static final int BATABLETYPE_MAJOR = 1;
    public static final int BATABLETYPE_RELATED = 3;
    public static final int BATABLETYPE_INHERIT = 9;

    public int getBATableType();

    public Iterator<IBAColSet> getBAColSets();

    public Iterator<IBAColumn> getBAColumns();

    public IBATableDE getBATableDE(String var1) throws Exception;

    public Iterator<IBATableDE> getBATableDEs();

    public IBATableDE getBATableDE(String var1, boolean var2) throws Exception;

    public IBAColSet getBAColSet(String var1) throws Exception;

    public IBAColumn getBAColumn(String var1) throws Exception;

    public IBAColumn getBAColumn(String var1, String var2) throws Exception;

    public IBATableDER getBATableDER(String var1) throws Exception;
}

