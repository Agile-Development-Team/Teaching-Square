module.exports = {
    devServer: {
        open: true,
        host: 'localhost',
        port: 8080,
        https: false,
        // hotOnly: false,
        proxy: { //配置跨域
            '/api':{
                target: 'http://localhost:8888/',
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