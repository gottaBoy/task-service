<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
const path = require('path');
const os = require('os');
const MonacoWebpackPlugin = require('monaco-editor-webpack-plugin');
const Timestamp = new Date().getTime();

function resolve(dir) {
    return path.join(__dirname, dir)
}

const transpileDependencies = (isCompatible) => {
    if (!isCompatible) {
        return [];
    } else {
        return [
            'ibiz-vue-pivottable',
            'ibiz-vue-lib',
            'vue-grid-layout',
            '@interactjs',
            'cache-loader'
        ]
    }
}

<#assign indexPageCount = 0/>
<#assign port><#if app.getHttpPort?? && app.getHttpPort()?? && app.getHttpPort() gt 0>${app.getHttpPort()?c}<#else>8080</#if></#assign>
module.exports = {
    publicPath: './',
    productionSourceMap: false,
    outputDir:"../resources/app",
    devServer: {
        host: '0.0.0.0',
        port: ${port},
        compress: true,
        disableHostCheck: true,
        // proxy: "http://127.0.0.1:${port}/${app.getPKGCodeName()}",
        headers: {
            'Access-Control-Allow-Origin': '*',
        }
    },
    pages: {
        index: {
            // page 的入口
            entry: 'src/main.ts',
            // 模板来源
            template: 'src/template.html',
            // 在 dist/index.html 的输出
            filename: 'index.html',
            // template 中的 title 标签需要是 <title><%= htmlWebpackPlugin.options.title %></title>
            title: '',
            // 在这个页面中包含的块，默认情况下会包含
            chunks: ['chunk-vendors','chunk-moment', 'chunk-zrender', 'chunk-echarts', 'chunk-tinymce', 'chunk-viewdesign', 'chunk-elementui', 'chunk-libs', 'chunk-core', 'chunk-service', 'chunk-plugin', 'chunk-vue', 'chunk-common','chunk-common', 'index']
        }
    },
    // 多核打包
    parallel: os.cpus().length > 1,
    chainWebpack: (config) => {
        // watch时开启sourceMap
        // if (Object.is(process.env.NODE_ENV, 'development') && !Object.is(process.env.VUE_APP_DEVMODE, 'false')) {
        //    config.devtool('eval-cheap-module-source-map');
        // }
        // 开启微应用处理图片和图标路径
        const publicPath = process.env.VUE_APP_PUBLICPATH;
        config.module
            .rule('fonts')
            .use('url-loader')
            .loader('url-loader')
            .options({
                limit: 4096, // 小于4kb将会被打包成 base64
                fallback: {
                    loader: 'file-loader',
                    options: {
                        name: '[name].[hash:8].[ext]',
                        publicPath: '../',
                    },
                },
            })
            .end();
        config.module
            .rule('images')
            .use('url-loader')
            .loader('url-loader')
            .options({
                limit: 4096, // 小于4kb将会被打包成 base64
                fallback: {
                    loader: 'file-loader',
                    options: {
                        name: '[name].[hash:8].[ext]',
                        publicPath,
                    },
                },
            });
        config.plugin('monaco').use(new MonacoWebpackPlugin());
        // 优化 babel添加缓存
        config.module.rule('tsx').use('babel-loader').tap(options => {
            if (!options) {
                options = {};
            }
            Object.assign(options, { cacheDirectory: true });
            return options;
        })
        config.module.rule('ts').use('babel-loader').tap(options => {
            if (!options) {
                options = {};
            }
            Object.assign(options, { cacheDirectory: true });
            return options;
        })
        // 删除自动计算预加载资源
        config.plugins.delete('preload-index')
        // 删除预加载资源
        config.plugins.delete('prefetch-index')
        config.resolve.alias
            .set('@ibizsys', resolve('src/ibizsys'))
            .set('@pages', resolve('src/pages'))
            .set('@components', resolve('src/components'))
            .set('@widgets', resolve('src/widgets'))
            .set('@engine', resolve('src/engine'))
            .set('@interface', resolve('src/interface'))
            .set('@locale', resolve('src/locale'))
            .set('@mock', resolve('src/mock'))
            .set('@service', resolve('src/service'))
            .set('@codelist', resolve('src/codelist'))
    },
    configureWebpack: config => {
        // 打包文件名添加时间戳
        Object.assign(config, {
            output: {
                ...config.output,
                <#noparse>filename: `js/[name]-${Timestamp}.js`,</#noparse>
                <#noparse>chunkFilename: `js/[name]-${Timestamp}.js`,</#noparse>
                library: `${app.getCodeName()}`,
                libraryTarget: 'umd', // 把子应用打包成 umd 库格式
                jsonpFunction: `webpackJsonp_${app.getCodeName()}`
            },
        });
        let ForkTsCheckerPlugin; 
        if(config.plugins.length > 0){
            ForkTsCheckerPlugin = config.plugins.find(element =>{
                return  element.workersNumber && element.memoryLimit;
            })
        }
        if (Object.is(config.mode, 'production')) {
            // 最大进程数
            ForkTsCheckerPlugin.workersNumber = os.cpus().length > 4 ? 4 : os.cpus().length; // 会占用额外内存不释放，不建议开发阶段使用
            // 单个进程最大使用内存
            ForkTsCheckerPlugin.memoryLimit = 4096;
        } else {
            // 最大进程数
            // ForkTsCheckerPlugin.workersNumber = os.cpus().length > 4 ? 4 : os.cpus().length; // 会占用额外内存不释放，不建议开发阶段使用
            // 单个进程最大使用内存
            ForkTsCheckerPlugin.memoryLimit = 4096;
        }
         // 开启分离js
        Object.assign(config.optimization.splitChunks, {
            chunks: 'all',
            maxInitialRequests: Infinity,
            minSize: 20000,
            automaticNameDelimiter: '-'
        });
        Object.assign(config.optimization.splitChunks.cacheGroups, {
            // node_modules
            vendors: {
                name: `chunk-vendors`,
                test: /[\\/]node_modules[\\/]/,
                priority: 0,
                chunks: 'initial'
            },
            moment: {
                name: 'chunk-moment',
                priority: 10,
                test: /[\\/]node_modules[\\/]_?moment(.*)/
            },
            zrender: {
                name: 'chunk-zrender',
                priority: 10,
                test: /[\\/]node_modules[\\/]_?zrender(.*)/
            },
            echarts: {
                name: 'chunk-echarts',
                priority: 10,
                test: /[\\/]node_modules[\\/]_?echarts(.*)/
            },
            tinymce: {
                name: 'chunk-tinymce',
                priority: 10,
                test: /[\\/]node_modules[\\/]_?tinymce(.*)/
            },
            viewDesign: {
                name: 'chunk-viewdesign',
                priority: 10,
                test: /[\\/]node_modules[\\/]_?view-design(.*)/
            },
            elementUI: {
                name: 'chunk-elementui',
                priority: 10,
                test: /[\\/]node_modules[\\/]_?element-ui(.*)/
            },
            ibizLib: {
                name: 'chunk-libs',
                priority: 10,
                test: /[\\/]node_modules[\\/]_?ibiz-vue-lib(.*)/
            },
            appCore: {
                name: 'chunk-core',
                priority: -10,
                test: /[\\/]packages[\\/]_?ibiz-core(.*)/
            },
            plugin: {
                name: 'chunk-plugin',
                priority: -10,
                test: /[\\/]packages[\\/]_?ibiz-plugin(.*)/
            },
            vue: {
                name: 'chunk-vue',
                priority: -10,
                test: /[\\/]packages[\\/]_?ibiz-vue(.*)/
            },
            // 其他
            common: {
                name: `chunk-common`,
                minChunks: 2,
                priority: -20,
                chunks: 'all',
                reuseExistingChunk: true
            }
        });
    },
    // 需兼容ie调整成true
    transpileDependencies: transpileDependencies(false)
}