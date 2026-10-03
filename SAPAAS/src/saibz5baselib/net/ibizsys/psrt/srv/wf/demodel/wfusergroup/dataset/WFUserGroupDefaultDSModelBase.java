/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusergroup.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="e64a576e41250c73ac1f51c15d6631e2",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="95DACEE8-1185-41FF-81E2-78B53F7744CF",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFUserGroupDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFUserGroupDefaultDSModelBase() {
        super();

        this.initAnnotation(WFUserGroupDefaultDSModelBase.class);
    }




}