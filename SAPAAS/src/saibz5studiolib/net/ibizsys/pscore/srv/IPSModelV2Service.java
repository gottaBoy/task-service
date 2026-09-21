/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 */
package net.ibizsys.pscore.srv;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.IPSCoreSysService;

public interface IPSModelV2Service<ET extends IEntity>
extends IPSCoreSysService<ET> {
    public static final int COMPILEMODE_KEY = 1;
    public static final int COMPILEMODE_DATA = 2;
    public static final String MODELV2SCOPE = "SRFMODELV2SCOPE";
    public static final String CONTENTTYPE_YAML = "YAML";
    public static final String CONTENTTYPE_JSON = "JSON";

    public String getModelV2ResPath(IEntity var1, boolean var2) throws Exception;

    public String getModelV2Name(boolean var1);

    public String getModelV2Name(ET var1, boolean var2) throws Exception;

    public String getModelV2LogicName();

    public String getModelV2LogicName(ET var1) throws Exception;

    public String getModelV2Tag(ET var1);

    public boolean setModelV2Tag(ET var1, String var2);

    public void exportModelV2(ET var1, String var2, String var3) throws Exception;

    public String getModelV2ResScope(IEntity var1) throws Exception;

    public boolean setModelV2ResScope(IEntity var1, String var2, String var3) throws Exception;

    public void compileModelV2(ET var1, ObjectNode var2, String var3, String var4, int var5) throws Exception;

    public ObjectNode exportModelV2(ET var1) throws Exception;

    public void emptyModelV2(ET var1) throws Exception;

    public void importModelV2(ET var1, ObjectNode var2) throws Exception;

    public IEntity getModelV2Entity(ET var1, String var2, String var3) throws Exception;

    public boolean containsModelV2Entity(String var1, int var2) throws Exception;

    public String getModelV2ResScopeDER(IEntity var1) throws Exception;

    public String getModelV2ResScopeText(IEntity var1) throws Exception;

    public String[] getModelV2ResScopeFields() throws Exception;

    public String exportModelV2Ex(ET var1, String var2) throws Exception;

    public void importModelV2Ex(ET var1, String var2, String var3) throws Exception;
}

