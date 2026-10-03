/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfappsetting.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="598b85c09bc9375e762590d2ab97552c",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="C336E5BD-3D0D-45C2-BBF5-91C43BBAE20A",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFAppSettingDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFAppSettingDefaultDSModelBase() {
        super();

        this.initAnnotation(WFAppSettingDefaultDSModelBase.class);
    }




}