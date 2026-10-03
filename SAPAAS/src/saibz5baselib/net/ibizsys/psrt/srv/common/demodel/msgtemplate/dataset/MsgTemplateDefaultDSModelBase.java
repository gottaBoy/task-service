/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgtemplate.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="e2c5b96d6cb0389900da130bc4545add",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="563B84B0-DE2A-4EF1-92D2-3BA701879891",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class MsgTemplateDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public MsgTemplateDefaultDSModelBase() {
        super();

        this.initAnnotation(MsgTemplateDefaultDSModelBase.class);
    }




}