package com.shlf;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;


public class MyCodeGenerator {


    public static void main(String[] args) {
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        //是否支持AR模式
        config.setActiveRecord(true)
                .setAuthor("nihaotian") //作者
                .setOutputDir(projectPath + "/src/main/java")
                .setFileOverride(true)//是否文件覆盖，如果多次
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO) //主键策略
                .setServiceImplName("%sServiceImpl")//设置生成的service接口的名字的首字母是否为I
                .setSwagger2(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };


        // 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/guanjia_manage?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("");
        // 包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.shlf")//父包名
                .setModuleName("guanjia")
                .setController("controller")
                .setEntity("model")
                .setService("service")
                .setMapper("mapper")
                .setXml("mapper");

        // 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setEntityTableFieldAnnotationEnable(true)//加注解
                .setInclude("tbl_apk","tbl_group","tbl_app_version") //生成的表
                .setRestControllerStyle(true)
                .setTablePrefix("tbl_"); // 表前缀

        // 整合配置
        AutoGenerator ag = new AutoGenerator().setGlobalConfig(config)
                .setCfg(cfg)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        ag.execute();

    }
}
