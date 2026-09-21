import { Vue, Component, Prop, Watch, Emit } from 'vue-property-decorator';
import { throttle, Util, ToolbarItem } from 'ibiz-core';

/**
 * 视图工具栏
 *
 * @export
 * @class ViewToolbar
 * @extends {Vue}
 */
@Component({})
export class ViewToolbar extends Vue {

    /**
     * 工具栏模型
     *
     * @type {{ [key: string]: ToolbarItem }}
     * @memberof ViewToolbar
     */
    @Prop()
    public toolbarModels?: { [key: string]: ToolbarItem };

    /**
     * 绘制模式
     *
     * @type {string}
     * @memberof ViewToolbar
     */
    @Prop({ default: 'DEFAULT' })
    public mode?: string;

    /**
     * 计树器服务集合
     *
     * @type {any}
     * @memberof ViewToolbar
     */
    @Prop()
    public counterServiceArray?:any;

    /**
     * 视图loading服务
     *
     * @type {any}
     * @memberof ViewToolbar
     */
    @Prop({default: false})
    public isViewLoading?:any;
    /**
     * 视图loading服务
     *
     * @type {any}
     * @memberof ViewToolbar
     */
    @Prop()
    public context?:any;
    
    /**
     * 视图loading服务
     *
     * @type {any}
     * @memberof ViewToolbar
     */
    @Prop()
    public viewparams?:any;
    
    /**
     * 视图loading服务
     *
     * @type {any}
     * @memberof ViewToolbar
     */
    @Prop()
    public contextData?:any;


    /**
     * 监控工具栏模型变更
     *
     * @memberof ViewToolbar
     */
    @Watch('toolbarModels', { immediate: true })
    public watchModels(): void {
        if (this.toolbarModels) {
            this.items = [];
            this.format();
        }
    }

    /**
     * 所有工机具项
     *
     * @protected
     * @type {ToolbarItem[]}
     * @memberof ViewToolbar
     */
    protected items: ToolbarItem[] = [];

    /**
     * 格式化工具栏模型
     *
     * @protected
     * @param {*} [model=this.model]
     * @memberof ViewToolbar
     */
    protected format(model: any = this.toolbarModels, items: ToolbarItem[] = this.items): void {
        for (const key in model) {
            const item: any = model[key];
            items.push(item);
            if (item.model) {
                item.items = [];
                this.format(item.model, item.items);
            }
        }
    }

    /**
     * 工具栏项点击
     *
     * @param {*} uiAction
     * @param {MouseEvent} e
     * @memberof ViewToolbar
     */
    @Emit('item-click')
    public itemClick(uiAction: any, e?: MouseEvent): void { }

    /**
     * @description span按钮点击
     * 用于控制禁用状态点击
     * @protected
     * @param {*} item
     * @param {MouseEvent} e
     * @memberof ViewToolbar
     */
    protected spanClick(item: any, e: MouseEvent) {
      if (!item.disabled) {
        throttle(this.itemClick,[{ tag: item.name }, e],this);
      }
    }

    /**
     * 绘制分割线
     *
     * @protected
     * @returns {*}
     * @memberof ViewToolbar
     */
    protected renderSeperator(): any {
        return <span class='app-view-toolbar__seperator'>|</span>;
    }

    /**
     * 绘制菜单
     *
     * @protected
     * @param {any[]} [items]
     * @returns {*}
     * @memberof ViewToolbar
     */
    protected renderMenuItems(items?: any[]): any {
        if (!items) {
            return;
        }
        return items.map((item: any) => {
            if (item.itemType === 'SEPERATOR') {
                return <li class='ivu-dropdown-item app-view-toolbar__seperator'></li>;
            }
            if (item.items && item.items.length > 0) {
                return this.renderMenuGroup(item);
            }
            // 当在分组中时，ui 呈现异常 无法放在 el-tooltip 中
            if (item.uiaction && item.uiaction.uIActionTag === 'ExportExcel') {
                if(item.visabled) {
                    return (
                        <app-export-excel
                            item={item}
                            caption={item.caption}
                            on-exportexcel={(e: MouseEvent) => this.spanClick(item, e)}
                            showType='more'>
                        </app-export-excel>
                    )
                }else {
                    return null
                }
            }
            return <dropdown-item disabled={item.disabled} name={item.name}>{this.renderMenuItem(item,false)}</dropdown-item>;
        });
    }

    /**
     * 绘制菜单项
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof ViewToolbar
     */
    protected renderMenuItem(item: any, showButton: boolean = true): any {
        const targetCounterService: any = {};
        if (this.counterServiceArray?.length > 0) {
            Object.assign(targetCounterService,this.counterServiceArray[0].service)
        }
        const classes:any = {}
        if(item.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.contextData;
            Object.assign(classes,...eval(item.dynaClass))
        }
        if(item.visabled){
            if (item.itemType == 'RAWITEM') {
                return <el-tooltip disabled={!item.tooltip}>
                    {this.renderRawItem(item)}
                </el-tooltip>
            } else if (!showButton) {
              return (
                  <span
                    disabled={item.disabled}
                    class={item.class}
                    on-click={(e: any) => this.spanClick(item, e)}>
                      {item.showIcon ? <menu-icon item={item} /> : null}
                      {item.showCaption ? <span class='app-view-toolbar__item__caption'>{item.caption}</span> : ''}
                  </span>
              );
            }
            return (
                <el-tooltip disabled={!item.tooltip} class={classes} >
                    {item.uiaction && Object.is(item.uiaction.uIActionTag, 'ExportExcel') ? (
                        <app-export-excel
                            item={item}
                            caption={item.caption}
                            on-exportexcel={($event: any) => throttle(this.itemClick,[{ tag: item.name }, $event],this)}
                            loading={this.isViewLoading}
                        ></app-export-excel>
                    ) : (item.uiaction && item.uiaction.counterId) && Object.keys(targetCounterService).length > 0 ? (
                        <app-button
                            disabled={item.disabled}
                            classContent={this.getToolBarItemClass(item)}
                            showCaption={item.showCaption}
                            caption={item.caption}
                            showIcon={item.showIcon}
                            icon={item.getPSSysImage?.imagePath}
                            iconcls={item.getPSSysImage?.cssClass}
                            loading={this.isViewLoading}
                            on-onClick={(e: any) => throttle(this.itemClick,[{ tag: item.name }, e],this)}>
                        </app-button>                       
                    ) : (
                        <app-button
                            disabled={item.disabled}
                            classContent={this.getToolBarItemClass(item)}
                            showCaption={item.showCaption}
                            caption={item.caption}
                            showIcon={item.showIcon}
                            icon={item.getPSSysImage?.imagePath}
                            iconcls={item.getPSSysImage?.cssClass}
                            loading={this.isViewLoading}
                            on-onClick={(e: any) => throttle(this.itemClick,[{ tag: item.name }, e],this)}>
                        </app-button>  
                    )}
                    <div slot='content'>{item.tooltip}</div>
                </el-tooltip>
            );
        }else{
            return null;
        }
    }

    /**
     * 绘制菜单分组
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof ViewToolbar
     */
    protected renderMenuGroup(item: ToolbarItem): any {
        const classes:any = {"app-view-toolbar__group":true}
        if(item.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.contextData;
            Object.assign(classes,...eval(item.dynaClass))
        }
        return (
            <dropdown transfer transfer-class-name="app-view-toolbar__transfer" class={classes} placement='left-start'>
                <dropdownItem name={item.name} title={item.tooltip}>
                    <icon type='ios-arrow-back'></icon>
                    {item.caption}
                </dropdownItem>
                <dropdownMenu slot='list'>{this.renderMenuItems(item.items)}</dropdownMenu>
            </dropdown>
        );
    }

    /**
     * 绘制模式2
     *
     * @protected
     * @returns {*}
     * @memberof ViewToolbar
     */
    protected renderStyle2(): any {
        return this.items.map((item: ToolbarItem) => {
            if (!item.visabled) {
                return;
            }
            let content: any;
            if (item.itemType === 'SEPERATOR') {
                content = this.renderSeperator();
            } else if (!item.items) {
                content = this.renderMenuItem(item);
            } else {
                content = (
                    <dropdown
                        v-show={item.visabled}
                        placement="bottom-start"
                        trigger="click"
                        stop-propagation
                        transfer
                    >
                        {
                        <app-button
                            v-show={item.visabled}
                            disabled={item.disabled}
                            tooltip={item.tooltip}
                            classContent={this.getToolBarItemClass(item)}
                            buttonGhost={true}
                            stopBubble={false}
                            showCaption={item.showCaption}
                            caption={item.caption}
                            showIcon={item.showIcon}
                            icon={item.icon}
                            iconcls={item.iconcls}
                            loading={this.isViewLoading}
                            on-onClick={(e: any) => throttle(this.itemClick,[{ tag: item.name }, e],this)}>
                              <icon type="ios-arrow-down" />
                        </app-button>                              
                        }
                        <dropdownMenu slot="list">{this.renderMenuItems(item.items)}</dropdownMenu>
                    </dropdown>
                );
            }
            return [<div class="app-view-toolbar__item">{content}</div>];
        });
    }

    /**
     * 绘制默认模式工具栏
     *
     * @protected
     * @returns {*}
     * @memberof ViewToolbar
     */
    protected renderDefault(): any {
        return this.items.map((item: ToolbarItem) => {
            if (item.itemType === 'SEPERATOR') {
                return this.renderSeperator();
            }
            const classes:any = { };
            if(item.dynaClass){
                const context = this.context;
                const viewparams = this.viewparams;
                const data = this.contextData;
                Object.assign(classes,...eval(item.dynaClass))
            }
            if (Object.is(item.itemType, 'ITEMS') && item.items && item.items.length > 0) {
                return (
					 <dropdown placement="bottom-end" transfer-class-name="app-view-toolbar__transfer" class={classes} v-show={item.visabled} trigger='click'>
                        <el-tooltip disabled={!item.tooltip}>
                            <app-button
                                showCaption={item.showCaption}
                                stopBubble={false}
                                showIcon={item.showIcon}
                                caption={item.caption}
                                icon={item.icon}
                                iconcls={item.iconcls}
                                classContent={this.getToolBarItemClass(item)}
                                loading={this.isViewLoading}>
                                    <icon type='ios-arrow-down'></icon>          
                            </app-button>
                            <div slot='content'>{item.tooltip}</div>
                        </el-tooltip>
                        <dropdown-menu slot='list'>{this.renderMenuItems(item.items)}</dropdown-menu>
                    </dropdown>
                );
            }
            return this.renderMenuItem(item);
        });
    }

    /**
     * 渲染直接内容
     *
     * @protected
     * @returns {*}
     * @memberof ViewToolbar
     */
    public renderRawItem(item: any) {
        let { style, rawContent, htmlContent, rawType, getPSSysImage } = item;
        let content: any;
        let sysImage = getPSSysImage?.cssClass;
        let sysImgurl = getPSSysImage?.imagePath;
        if (['RAW','VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(rawType)) {
            content = rawContent;
        } else if (Object.is(rawType,'HTML')){
            content = htmlContent;
        }else if(Object.is(rawType,'PLACEHOLDER')){
            content = null;
        }
        if (content) {
            const items = content.match(/\{{(.+?)\}}/g);
            if (items) {
                items.forEach((item: string) => {
                    content = content.replace(/\{{(.+?)\}}/, eval(item.substring(2, item.length - 2)));
                });
            }
            content = content.replaceAll('&lt;','<');
            content = content.replaceAll('&gt;','>');
            content = content.replaceAll('&amp;nbsp;',' ');
            content = content.replaceAll('&nbsp;',' ');
        }
        const classes = {};
        if(item.class){
            Object.assign(classes,{[item.class]:true})
        }
        if(item.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.contextData;
            Object.assign(classes,...eval(item.dynaClass))
        }
        if(['VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(rawType)){
            if(content){
                try{
                    if(typeof content === 'string'){
                        let func = new Function('return (' + content + ');');
                        content  = func();
                    }
                }catch{
                    console.error(`${rawType}类型自定义参数配置错误`);
                    content = null;
                }
            }else{
                content = null;
            }
        }
        return (
            <app-rawitem
                class={classes}
                style={style}
                imageClass={sysImage}
                imgUrl={sysImgurl}
                contentType={rawType}
                content={content}
                videoParams={content}
                dividerParams={content}
                alertParams={content}
                >
            </app-rawitem>
        )
    }

    /**
     * 绘制工具栏内容
     *
     * @returns {*}
     * @memberof ViewToolbar
     */
    public render(): any {
        if (this.items.length == 0) {
            return;
        }
        let content: any = this.mode == "STYLE2" ? this.renderStyle2() : this.renderDefault();
        return <div class={{ 'app-view-toolbar': true, 'app-view-toolbar--style2': this.mode == "STYLE2" ? true : false }}>{content}</div>;
    }

    /**
     * 绘制工具栏项样式
     *
     * @returns {*}
     * @memberof ViewToolbar
     */
    public getToolBarItemClass(item:any){
        let tempClass:string = '';
        if(item.actionLevel){
            tempClass += `srfactionlevel${item.actionLevel}`
        }
        if(item.class){
            tempClass += ` ${item.class}`
        }
        return tempClass;
    }
}
