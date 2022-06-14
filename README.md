參考
https://github.com/xkcoding/spring-boot-demo


使用 spring initializr 2.6.8 將部分專案整合


执行mvn打包命令，因为插件中 `execution` 节点配置了 package，所以会在打包的时候自动执行 build 命令。

   ```bash
   $ mvn clean package -Dmaven.test.skip=true
   ```
運行

   ```bash
   $ docker run -d -p 9090:8080 spring-boot-all:<version>
   ```

更新 pom 檔並備份

   ```bash
   $ mvn versions:set -DnewVersion=<version>
   ```