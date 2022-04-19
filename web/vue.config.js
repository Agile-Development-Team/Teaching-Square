module.exports = {
    devServer: {
        open: true,
        host: 'localhost',
        port: 8081,
        https: false,
        // hotOnly: false,
        proxy: { //配置跨域
            '/api':{
                target: 'http://172.19.241.104:8888/',
                changOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        },
        before: app => { }
    }
}