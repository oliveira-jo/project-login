const PROXY_CONFIG = [
  {
    context: [
      '/auth',
    ],
    target: "http://localhost:8080/",
    secure: false,
    changeOrigin: true,
    pathRewrite: {
      "^/": ""
    }
  }
]

module.exportx = PROXY_CONFIG;