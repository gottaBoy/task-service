/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab;

import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstTag;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.util.gitlab.model.Group;
import net.ibizsys.pscore.srv.util.gitlab.model.Member;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import net.ibizsys.pscore.srv.util.gitlab.model.Tag;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.model.WikiPage;

public interface IPSGitLabPlugin {
    public static final String SYSTAG4_SUPERGUEST = "SUPERGUEST";

    public Group createGroupByPSDevSln(PSDevSln var1) throws Exception;

    public void removeGroupByPSDevSln(PSDevSln var1) throws Exception;

    public Project createCodeProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception;

    public Project createModelProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception;

    public Project createRuntimeProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception;

    public Project createDocProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception;

    public Project createProjectByPSDevSlnTempl(PSDevSlnTempl var1) throws Exception;

    public void removeCodeProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception;

    public void removeModelProjectByPSDevSlnSys(PSDevSlnSys var1) throws Exception;

    public void removeProjectByPSDevSlnTempl(PSDevSlnTempl var1) throws Exception;

    public Project moveCodeProjectByPSDevSlnSys(PSDevSlnSys var1, PSDevSln var2) throws Exception;

    public Project moveModelProjectByPSDevSlnSys(PSDevSlnSys var1, PSDevSln var2) throws Exception;

    public Project moveProjectByPSDevSlnTempl(PSDevSlnTempl var1, PSDevSln var2) throws Exception;

    public User createUserByPSDevUser(PSDevUser var1) throws Exception;

    public User getUserByPSDevUser(PSDevUser var1, boolean var2) throws Exception;

    public Project[] listProjectsByPSDevSln(PSDevSln var1) throws Exception;

    public Member createMemberByPSDevSlnUser(PSDevSlnUser var1) throws Exception;

    public Member updateMemberByPSDevSlnUser(PSDevSlnUser var1) throws Exception;

    public void removeMemberByPSDevSlnUser(PSDevSlnUser var1) throws Exception;

    public Project createProjectByPSDevSlnSysDynaInst(PSDevSln var1, PSDevSlnSysDynaInst var2, boolean var3) throws Exception;

    public Tag[] listTagsByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst var1) throws Exception;

    public Tag getTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception;

    public Tag createTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception;

    public Tag updateTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception;

    public void removeTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception;

    public void revertTagByPSDevSlnSysDynaInstTag(PSDevSlnSysDynaInstTag var1) throws Exception;

    public WikiPage getWikiPage(PSDevSlnSys var1, String var2, boolean var3) throws Exception;

    public void updateWikiPage(PSDevSlnSys var1, String var2, String var3, String var4, boolean var5) throws Exception;
}

